package com.grokonez.jwtauthentication.model.RequeteModels;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.grokonez.jwtauthentication.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Requete {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @NonNull
    private String titre ;

    @NonNull
    @Column(columnDefinition = "MEDIUMTEXT")
    private String description ;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date date ;

    @ManyToOne
    private User user ;
    private boolean duplique;

    @OneToMany (mappedBy = "requete")
    List<Reponse> reponse;

    @ManyToOne
    private TypeRequete type;

    private Boolean Checked;

    public Requete(String titre,String description){
        this.titre=titre;
        this.description=description;


    }
}
