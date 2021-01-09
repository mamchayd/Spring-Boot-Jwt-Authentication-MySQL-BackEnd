package com.grokonez.jwtauthentication.message.GestionRequete;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class AffichRequete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String username;

    public String getUsername() {
        return username;
    }
}
