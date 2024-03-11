package edu.devaux.cda24.controller;

import com.fasterxml.jackson.annotation.JsonView;
import edu.devaux.cda24.dao.UtilisateurDao;
import edu.devaux.cda24.model.Utilisateur;
import edu.devaux.cda24.view.UtilisateurView;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class UtilisateurController {
    @Autowired
    protected UtilisateurDao utilisateurDao;

    @GetMapping("/utilisateur/liste")
    @JsonView(UtilisateurView.class)
    public List<Utilisateur> liste() {

        return utilisateurDao.findAll();
    }

    @GetMapping("/utilisateur/{id}")
    @JsonView(UtilisateurView.class)
    public ResponseEntity<Utilisateur> get(@PathVariable int id) {
        Optional<Utilisateur> utilisateurOptional = utilisateurDao.findById(id);
        if (utilisateurOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(utilisateurOptional.get(), HttpStatus.OK);
    }

    @PostMapping("/utilisateur")
    @JsonView(UtilisateurView.class)
    public ResponseEntity<Utilisateur> add(@Valid @RequestBody Utilisateur nouveauUtilisateur) {
//        C'est une mise à jour'
        if (nouveauUtilisateur.getId() != null) {
            Optional<Utilisateur> utilisateurOptional = utilisateurDao.findById(nouveauUtilisateur.getId());
            if (utilisateurOptional.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            utilisateurDao.save(nouveauUtilisateur);
            return new ResponseEntity<>(utilisateurOptional.get(), HttpStatus.OK);
        }
        utilisateurDao.save(nouveauUtilisateur);
        return new ResponseEntity<>(nouveauUtilisateur, HttpStatus.CREATED);
    }


    @DeleteMapping("/utilisateur/{id}")
    @JsonView(UtilisateurView.class)
    public ResponseEntity<Utilisateur> supprimerUtilisateur(@PathVariable int id) {
        Optional<Utilisateur> utilisateurOptional = utilisateurDao.findById(id);
        if (utilisateurOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(utilisateurOptional.get(), HttpStatus.OK);
    }
}


