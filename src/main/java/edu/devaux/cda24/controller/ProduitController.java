package edu.devaux.cda24.controller;

import edu.devaux.cda24.model.Produit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProduitController {
   @GetMapping("/produit")
    public Produit get(){
       Produit produitTest = new Produit();
       produitTest.setId(42);
       produitTest.setNom("cafe!");
       return produitTest;

    }
}
