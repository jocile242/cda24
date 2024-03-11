package edu.devaux.cda24.dao;

import edu.devaux.cda24.model.EtatProduit;
import edu.devaux.cda24.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtatProduitDao extends JpaRepository <EtatProduit,Integer>{

}

