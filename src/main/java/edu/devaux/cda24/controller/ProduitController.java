package edu.devaux.cda24.controller;

import com.fasterxml.jackson.annotation.JsonView;
import edu.devaux.cda24.dao.ProduitDao;
import edu.devaux.cda24.model.Produit;
import edu.devaux.cda24.view.ProduitView;
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
public class ProduitController {
    @Autowired
    protected ProduitDao produitDao;

    @GetMapping("/produit/liste")
    @JsonView(ProduitView.class)
    public List<Produit> liste() {

        return produitDao.findAll();
    }

    @GetMapping("/produit/{id}")
    @JsonView(ProduitView.class)
    public ResponseEntity<Produit> get(@PathVariable int id) {
        Optional<Produit> produitOptional = produitDao.findById(id);
        if (produitOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(produitOptional.get(), HttpStatus.OK);
    }

    @PostMapping("/produit")
    @JsonView(ProduitView.class)
    public ResponseEntity<Produit> add(@Valid @RequestBody Produit nouveauProduit) {
//        C'est une mise à jour'
        if (nouveauProduit.getId() != null) {
            Optional<Produit> produitOptional = produitDao.findById(nouveauProduit.getId());
            if (produitOptional.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            produitDao.save(nouveauProduit);
            return new ResponseEntity<>(produitOptional.get(), HttpStatus.OK);
        }
        produitDao.save(nouveauProduit);
        return new ResponseEntity<>(nouveauProduit, HttpStatus.CREATED);
    }


    @DeleteMapping("/produit/{id}")
    @JsonView(ProduitView.class)
    public ResponseEntity<Produit> supprimerProduit(@PathVariable int id) {
        Optional<Produit> produitOptional = produitDao.findById(id);
        if (produitOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(produitOptional.get(), HttpStatus.OK);
    }
}


