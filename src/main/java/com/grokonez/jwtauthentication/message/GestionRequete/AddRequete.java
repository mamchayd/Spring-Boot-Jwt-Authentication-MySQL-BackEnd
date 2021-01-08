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

    @NotBlank
    @Size(max = 60)
    @Email
    private String email;

    private String type;

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

    public String getType() {
        return type;
    }
}
