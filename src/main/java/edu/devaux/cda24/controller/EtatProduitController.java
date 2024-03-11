package edu.devaux.cda24.controller;

import com.fasterxml.jackson.annotation.JsonView;
import edu.devaux.cda24.dao.EtatProduitDao;
import edu.devaux.cda24.model.EtatProduit;
import edu.devaux.cda24.view.EtatProduitView;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class EtatProduitController {
    @Autowired
    protected EtatProduitDao etatProduitDao;

    @GetMapping("/etat-produit/liste")
    public List<EtatProduit> liste() {

        return etatProduitDao.findAll();
    }

    @GetMapping("/etat-produit/{id}")
    @JsonView(EtatProduitView.class)
    public ResponseEntity<EtatProduit> get(@PathVariable int id) {
        Optional<EtatProduit> etatProduitOptional = etatProduitDao.findById(id);
        if (etatProduitOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(etatProduitOptional.get(), HttpStatus.OK);
    }

    @PostMapping("/etat-produit")
    public ResponseEntity<EtatProduit> add(@Valid @RequestBody EtatProduit nouveauEtatProduit) {
//        C'est une mise à jour'
        if (nouveauEtatProduit.getId() != null) {
            Optional<EtatProduit> etatProduitOptional = etatProduitDao.findById(nouveauEtatProduit.getId());
            if (etatProduitOptional.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            etatProduitDao.save(nouveauEtatProduit);
            return new ResponseEntity<>(etatProduitOptional.get(), HttpStatus.OK);
        }
        etatProduitDao.save(nouveauEtatProduit);
        return new ResponseEntity<>(nouveauEtatProduit, HttpStatus.CREATED);
    }


    @DeleteMapping("/etat-produit/{id}")
    public ResponseEntity<EtatProduit> supprimerEtatProduit(@PathVariable int id) {
        Optional<EtatProduit> etatProduitOptional = etatProduitDao.findById(id);
        if (etatProduitOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(etatProduitOptional.get(), HttpStatus.OK);
    }
}


