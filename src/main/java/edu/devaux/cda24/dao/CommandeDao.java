package edu.devaux.cda24.dao;

import edu.devaux.cda24.model.Commande;
import edu.devaux.cda24.model.EtatProduit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeDao extends JpaRepository <Commande,Integer>{

    @Query(value = "FROM Commande c JOIN c.statut s WHERE s.designation = :status")
    List<Commande> commandeValide(@Param("statut")String status);

}

