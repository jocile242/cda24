package edu.devaux.cda24.controller;

import com.fasterxml.jackson.annotation.JsonView;
import edu.devaux.cda24.dao.CommandeDao;
import edu.devaux.cda24.model.Commande;
import edu.devaux.cda24.view.CommandeView;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class CommandeController {
    @Autowired
    protected CommandeDao commandeDao;

    @GetMapping("/commande/valide")
    @JsonView(CommandeView.class)
    public List<Commande> listeCommandeValide() {
//        List<Commande>listeCommande = commandeDao.findAll();
//        List<Commande>ListeCommandeValide = new ArrayList<>();
//        for(Commande commande : listeCommande){
//            if(commande.getStatut())
//        }
//
//        return commandeDao.findAll();
    }

    @GetMapping("/commande/liste")
    @JsonView(CommandeView.class)
    public List<Commande> liste() {

        return commandeDao.findAll();
    }

    @GetMapping("/commande/{id}")
    @JsonView(CommandeView.class)
    public ResponseEntity<Commande> get(@PathVariable int id) {
        Optional<Commande> commandeOptional = commandeDao.findById(id);
        if (commandeOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(commandeOptional.get(), HttpStatus.OK);
    }

    @PostMapping("/commande")
    @JsonView(CommandeView.class)
    public ResponseEntity<Commande> add(@Valid @RequestBody Commande nouveauCommande) {
//        C'est une mise à jour'
        if (nouveauCommande.getId() != null) {
            Optional<Commande> commandeOptional = commandeDao.findById(nouveauCommande.getId());
            if (commandeOptional.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            commandeDao.save(nouveauCommande);
            return new ResponseEntity<>(commandeOptional.get(), HttpStatus.OK);
        }
        commandeDao.save(nouveauCommande);
        return new ResponseEntity<>(nouveauCommande, HttpStatus.CREATED);
    }


    @DeleteMapping("/commande/{id}")
    @JsonView(CommandeView.class)
    public ResponseEntity<Commande> supprimerCommande(@PathVariable int id) {
        Optional<Commande> commandeOptional = commandeDao.findById(id);
        if (commandeOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(commandeOptional.get(), HttpStatus.OK);
    }
}


