package com.grokonez.jwtauthentication.message.GestionRequete;


import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AddRequete {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @NonNull
    private String titre ;

    @NonNull
    @Column(columnDefinition = "MEDIUMTEXT")
    private String description ;


    private String username;

    private String type;

    private String name;
    private String prenom;

    public Long getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public String getUsername() {
        return username;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getPrenom() {
        return prenom;
    }
}
