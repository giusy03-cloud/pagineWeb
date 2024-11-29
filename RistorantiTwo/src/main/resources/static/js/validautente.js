// Funzione di validazione
function validate(event) {
    event.preventDefault(); // Evita il submit automatico del form

    const casellaTesto = document.getElementById("user");
    const content = casellaTesto.value;

    // Controlla se l'username contiene il simbolo "@" (per esempio)
    if (content.includes("@")) {
        // Se l'input è valido, invia il form manualmente
        document.getElementById("formSubmit").submit();
    } else {
        // Se manca la chiocciola, mostra un alert
        alert("Manca la chiocciola");
    }
}

// Aggiungi l'evento di submit quando la pagina è completamente caricata
window.addEventListener("load", function() {
    const form = document.getElementById("formSubmit");
    form.addEventListener("submit", validate);  // Attacca l'evento di validazione
});
