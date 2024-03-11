package edu.devaux.cda24.model;

import com.fasterxml.jackson.annotation.JsonView;
import edu.devaux.cda24.view.CommandeView;
import edu.devaux.cda24.view.ProduitView;
import edu.devaux.cda24.view.UtilisateurView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class LigneCommande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @JsonView(CommandeView.class)
    protected Float prixVente;

    @JsonView(CommandeView.class)
    protected int quantite;

    @ManyToOne(optional = false)
    protected Commande commande;

    @ManyToOne(optional = false)
    @JsonView(CommandeView.class)
    protected Produit produit;
}