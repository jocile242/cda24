package edu.devaux.cda24.dao;

import edu.devaux.cda24.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneCommandeDao extends JpaRepository <Commande,Integer>{

}

