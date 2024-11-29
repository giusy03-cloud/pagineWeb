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
public class Piatto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generazione automatica dell'ID
    private Long id;

    private String nome;
    private String ingredienti;

    public Piatto(String nome, String ingredienti){
        this.nome=nome;
        this.ingredienti=ingredienti;

    }

    @ManyToMany(mappedBy = "piatti", fetch = FetchType.LAZY) // Relazione inversa con Ristorante
    private List<Ristorante> ristoranti = new List<Ristorante>() {
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
        public Iterator<Ristorante> iterator() {
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
        public boolean add(Ristorante ristorante) {
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
        public boolean addAll(Collection<? extends Ristorante> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends Ristorante> c) {
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
        public Ristorante get(int index) {
            return null;
        }

        @Override
        public Ristorante set(int index, Ristorante element) {
            return null;
        }

        @Override
        public void add(int index, Ristorante element) {

        }

        @Override
        public Ristorante remove(int index) {
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
        public ListIterator<Ristorante> listIterator() {
            return null;
        }

        @Override
        public ListIterator<Ristorante> listIterator(int index) {
            return null;
        }

        @Override
        public List<Ristorante> subList(int fromIndex, int toIndex) {
            return List.of();
        }
    }; // Inizializzazione per evitare null pointer

}
