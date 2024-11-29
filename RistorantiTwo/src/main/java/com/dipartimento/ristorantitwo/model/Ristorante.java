package com.dipartimento.ristorantitwo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Ristorante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descrizione;
    private String ubicazione;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "ristorante_piatto", // Nome della tabella di join
            joinColumns = @JoinColumn(name = "ristorante_id"), // Colonna per la chiave primaria di Ristorante
            inverseJoinColumns = @JoinColumn(name = "piatto_id") // Colonna per la chiave primaria di Piatto
    )
    private List<Piatto> piatti = new List<Piatto>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<Piatto> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(Piatto piatto) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends Piatto> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends Piatto> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public Piatto get(int index) {
            return null;
        }

        @Override
        public Piatto set(int index, Piatto element) {
            return null;
        }

        @Override
        public void add(int index, Piatto element) {

        }

        @Override
        public Piatto remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<Piatto> listIterator() {
            return null;
        }

        @Override
        public ListIterator<Piatto> listIterator(int index) {
            return null;
        }

        @Override
        public List<Piatto> subList(int fromIndex, int toIndex) {
            return List.of();
        }
    }; // Inizializza come HashSet per evitare null pointer

    // Getter e Setter saranno generati automaticamente da Lombok
}
