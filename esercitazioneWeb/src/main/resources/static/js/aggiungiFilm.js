console.log('HELLO JS');

// Evento click sul pulsante "Aggiungi Film"
document.getElementById("addFilmButton").addEventListener("click", function() {
    // Mostra il form per aggiungere un nuovo film
    document.getElementById("filmForm").style.display = "block";
    // Nasconde il form di rimozione, se presente
    document.getElementById("removeFilmForm").style.display = "none";
});

// Evento submit sul form "newFilmForm" per aggiungere un nuovo film
document.getElementById("newFilmForm").addEventListener("submit", function(event) {
    event.preventDefault();

    // Recupera i valori dai campi di input
    const title = document.getElementById("title").value;
    const year = document.getElementById("year").value;
    const channel = document.getElementById("channel").value;

    const tableBody = document.getElementById("filmTableBody");

    addNewRowV2(tableBody, title, year, channel);

    document.getElementById("filmForm").style.display = "none";
    document.getElementById("newFilmForm").reset();
});

// Funzione per aggiungere una nuova riga alla tabella
function addNewRowV2(tableBody, title, year, channel) {
    // Crea una nuova riga nella tabella
    const newRow = tableBody.insertRow();

    // Creazione delle celle per la nuova riga e inserimento dei dati
    const titleCell = newRow.insertCell(0);    // Cella per il titolo
    const yearCell = newRow.insertCell(1);     // Cella per l'anno
    const channelCell = newRow.insertCell(2);  // Cella per il canale trasmesso
    const deleteButtonCell = newRow.insertCell(3); // Cella per il pulsante elimina

    // Assegnazione dei valori alle celle della nuova riga
    titleCell.textContent = title;  // Inserisce il titolo nella prima cella
    yearCell.innerHTML = `<span class="badge bg-info">${year}</span>`; // Inserisce l'anno con badge
    channelCell.textContent = channel; // Inserisce il canale trasmesso nella terza cella

    // Creazione del pulsante elimina e aggiunta all'ultima cella
    const deleteButton = document.createElement("button");
    deleteButton.className = "btn btn-danger btn-sm";
    deleteButton.innerHTML = '<i class="fas fa-trash-alt"></i>';
    deleteButton.onclick = function() {
        deleteRow(deleteButton); // Chiama la funzione deleteRow quando il pulsante viene cliccato
    };

    deleteButtonCell.appendChild(deleteButton); // Aggiunge il pulsante elimina alla cella

    console.log('Aggiunta di una nuova riga, con il metodo 2');
}

// Funzione per eliminare una riga dalla tabella
function deleteRow(button) {
    const row = button.parentElement.parentElement;
    row.parentElement.removeChild(row);
}

