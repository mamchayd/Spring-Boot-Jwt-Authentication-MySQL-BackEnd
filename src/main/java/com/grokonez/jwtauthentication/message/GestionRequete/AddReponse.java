package com.grokonez.jwtauthentication.message.GestionRequete;

import lombok.NonNull;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class AddReponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @NonNull
    private String titre ;

    @NonNull
    private String description ;

    @ManyToOne
    private String email ;

    private Long requeteId;

    public Long getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public String getEmail() {
        return email;
    }

    public Long getRequeteId() {
        return requeteId;
    }
}
