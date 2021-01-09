package com.grokonez.jwtauthentication.message.GestionRequete;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ChercheRequete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String titre;

    public Long getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }
}
