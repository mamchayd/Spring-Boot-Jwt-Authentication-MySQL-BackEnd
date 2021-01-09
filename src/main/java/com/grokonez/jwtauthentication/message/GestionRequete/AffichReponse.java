package com.grokonez.jwtauthentication.message.GestionRequete;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class AffichReponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private Long idRequete;

    public Long getIdRequete() {
        return idRequete;
    }
}
