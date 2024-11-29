package com.dipartimento.ristorantitwo.controller;


import com.dipartimento.ristorantitwo.exception.PiattoNotValidException;
import com.dipartimento.ristorantitwo.model.Piatto;
import com.dipartimento.ristorantitwo.service.IPiattoService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Collection;

@RestController

//una classe controller REST per la gestione dei piatti
@RequestMapping("/api/piatto/v1")
class PiattoController {


    private final IPiattoService piattoService;


    public PiattoController(IPiattoService piattoService) {
        this.piattoService = piattoService;
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    //restituisce tutti i piatti attaraverso il metodo getAllPiatti()
    ResponseEntity<Collection<Piatto>> getAllPiatti(){

        Collection<Piatto> all = this.piattoService.findAll();

        return  ResponseEntity.ok(all);

    }
    //restituisce un piatto specifico identificato dal nomePiatto

    @RequestMapping(value = "/{nomePiatto}", method = RequestMethod.GET)
        // opzione 1
//    ResponseEntity<Piatto> getPiattoById(@PathVariable("nomePiatto") String nome){
        // opzione 2
    ResponseEntity<Piatto> getPiattoById(@PathVariable String nomePiatto){
        return  ResponseEntity.ok(
                this.piattoService.findById(nomePiatto)
        );
    }

    //crea un nuovo piatto con i dati forniti nel corpo della richiesta
    @RequestMapping(value = "/", method = RequestMethod.POST)
    ResponseEntity<Piatto> postCreateNewPiatto(@RequestBody  Piatto piatto) throws Exception {

        try{
            return  ResponseEntity.ok(
                    this.piattoService.createPiatto(piatto)
            );
        }catch (PiattoNotValidException e){
            return new ResponseEntity(e.getMessage() , HttpStatusCode.valueOf(400));
            // return ResponseEntity.status(HttpStatusCode.valueOf(400) , ).build();
        }

    }


    //aggiorna un piatto esistente, identificato dal nome
    @RequestMapping(value = "/{nomePiatto}", method = RequestMethod.POST)
    ResponseEntity<Piatto> postUpdatePiatto(
            @PathVariable String nomePiatto,
            @RequestBody Piatto piatto
    ) throws Exception {
        return  ResponseEntity.ok(
                this.piattoService.updatePiatto(nomePiatto, piatto)
        );
    }

    //elimina un piatto specifico dal database
    @RequestMapping(value = "/{nomePiatto}", method = RequestMethod.DELETE)
    ResponseEntity<Void> deletePiatto(String nome){
        this.piattoService.deletePiatto(nome);
        return ResponseEntity.ok().build();

    }






}