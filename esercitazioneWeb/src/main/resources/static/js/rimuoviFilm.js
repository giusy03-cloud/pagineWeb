document.getElementById("removeFilmButton").addEventListener("click", function() {
    document.getElementById("removeFilmForm").style.display = "block";
    document.getElementById("filmForm").style.display = "none";
});
function removeFilmByNumber(event) {
    event.preventDefault(); // Impedisce il submit del form

    // Recupera il numero del film da rimuovere
    const filmNumber = parseInt(document.getElementById("filmNumber").value);

    // Ottiene tutte le righe della tabella film, escluse le intestazioni
    const rows = document.getElementById('filmTableBody').querySelectorAll('tr');

    // Controlla se il numero è valido
    if (filmNumber > 0 && filmNumber <= rows.length) {
        rows[filmNumber - 1].remove(); // Rimuove la riga corrispondente (indice base 0)
        document.getElementById("removeFilmForm").style.display = "none"; // Nasconde il form
        document.getElementById("removeFilmByNumberForm").reset(); // Resetta il campo del form
    } else {
        alert("Numero del film non valido!"); // Avviso per numero non valido
    }
}



// DELETE specific row
// Aggiunge la funzionalità di eliminazione per i pulsanti "Elimina" già presenti
document.querySelectorAll(".deleteButton").forEach(button => {
    button.addEventListener("click", function() {
        const row = button.closest("tr");
        row.parentNode.removeChild(row); // Elimina la riga
    });
});


// Funzione per eliminare la riga con opzioni diverse
function deleteRow(button) {
    const row = button.parentNode.parentNode; // Trova la riga corrente

    // Opzione 1: Rimuove la riga direttamente
    row.parentNode.removeChild(row);

}