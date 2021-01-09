package com.grokonez.jwtauthentication.model.RequeteModels;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.grokonez.jwtauthentication.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Reponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @NonNull
    private String titre ;

    @NonNull
    private String description ;

    @ManyToOne
    private User user ;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date date ;

    @ManyToOne
    @JsonIgnore
    private Requete requete;

    public Reponse(String titre,String description){
        this.titre=titre;
        this.description=description;


    }

    public Long getIdRequete(){
        return this.requete.getId();
    }

}
