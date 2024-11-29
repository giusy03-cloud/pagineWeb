window.addEventListener("DOMContentLoaded", function () {
    var btn_aggiungi = document.querySelector("#btn_aggiungi");
    if (btn_aggiungi) {
        btn_aggiungi.addEventListener("click", function () {
            console.log("Bottone cliccato!");
            aggiungiRistorante();
        });
    } else {
        console.error("Bottone #btn_aggiungi non trovato.");
    }
});

function aggiungiRistorante() {
    var txtNome = document.querySelector("#nome_rist");
    var txtDescrizione = document.querySelector("#desc_rist");
    var txtUbicazione = document.querySelector("#ub_ristorante");

    var nome = txtNome.value;
    var descrizione = txtDescrizione.value;
    var ubicazione = txtUbicazione.value;

    // Controllo di validità dei campi
    if (!nome || !descrizione || ubicazione === "---") {
        alert("Tutti i campi sono obbligatori!");
        return;
    }

    var ristorante = {
        "nome": nome,
        "descrizione": descrizione,
        "ubicazione": ubicazione
    };

    // Chiamata AJAX con metodo POST per aggiungere il ristorante
    $.ajax({
        url: "/addRistorante",  // Assicurati che il percorso sia corretto (modifica se necessario)
        type: "POST",
        contentType: "application/json", // Indica che i dati sono in formato JSON
        data: JSON.stringify(ristorante),  // Converti l'oggetto in una stringa JSON
        success: function (risposta) {
            // Successo: Mostra un messaggio di conferma e aggiorna la tabella
            alert("Ristorante aggiunto: " + nome); // Messaggio di conferma

            // Aggiungi il ristorante alla tabella dinamicamente
            aggiungiRistoranteAllaTabella(ristorante);
        },
        error: function () {
            alert("Si è verificato un errore nell'aggiunta del ristorante.");
        }
    });

    // Funzione per aggiungere il ristorante alla tabella nella pagina
    function aggiungiRistoranteAllaTabella(ristorante) {
        var tableBody = document.querySelector("table tbody"); // Ottieni il corpo della tabella
        var newRow = document.createElement("tr"); // Crea una nuova riga

        // Crea le celle della riga con i dati del ristorante
        var tdNome = document.createElement("td");
        tdNome.textContent = ristorante.nome;

        var tdDescrizione = document.createElement("td");
        tdDescrizione.textContent = ristorante.descrizione;

        var tdUbicazione = document.createElement("td");
        tdUbicazione.textContent = ristorante.ubicazione;

        // Aggiungi le celle alla riga
        newRow.appendChild(tdNome);
        newRow.appendChild(tdDescrizione);
        newRow.appendChild(tdUbicazione);

        // Aggiungi la nuova riga alla tabella
        tableBody.appendChild(newRow);
    }
}
