package edu.devaux.cda24.model;

import com.fasterxml.jackson.annotation.JsonView;
import edu.devaux.cda24.view.CommandeView;
import edu.devaux.cda24.view.ProduitView;
import edu.devaux.cda24.view.StatutCommandeView;
import edu.devaux.cda24.view.UtilisateurView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class StatutCommande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @JsonView(CommandeView.class)
    protected String designation;

}