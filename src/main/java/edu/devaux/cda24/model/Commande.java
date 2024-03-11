package edu.devaux.cda24.model;

import com.fasterxml.jackson.annotation.JsonView;
import edu.devaux.cda24.view.CommandeView;
import edu.devaux.cda24.view.LigneCommandeView;
import edu.devaux.cda24.view.ProduitView;
import edu.devaux.cda24.view.UtilisateurView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({UtilisateurView.class, CommandeView.class})
    protected Integer id;

    @JsonView({UtilisateurView.class, CommandeView.class})
    protected LocalDate date;

    @ManyToOne(optional = false)
    @JsonView(CommandeView.class)
    protected Utilisateur client;

    @ManyToOne(optional = false)
    @JsonView(CommandeView.class)
    protected StatutCommande statut;

    @OneToMany(mappedBy = "commande")
    @JsonView(LigneCommandeView.class)
    protected List<LigneCommande> ligneCommande = new ArrayList<>();

}