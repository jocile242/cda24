package edu.devaux.cda24.model;

import com.fasterxml.jackson.annotation.JsonView;
import edu.devaux.cda24.view.CommandeView;
import edu.devaux.cda24.view.UtilisateurView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(UtilisateurView.class)
    protected Integer id;

    @JsonView({UtilisateurView.class, CommandeView.class})
    protected String email;


    protected String motDePasse;

    @JsonView(UtilisateurView.class)
    protected Boolean administrateur;


    @OneToMany (mappedBy = "client")
    @JsonView(UtilisateurView.class)
    protected List<Commande> listeCommandes = new ArrayList<>();

}