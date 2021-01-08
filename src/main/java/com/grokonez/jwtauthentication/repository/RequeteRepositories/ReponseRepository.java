package com.grokonez.jwtauthentication.repository.RequeteRepositories;


import com.grokonez.jwtauthentication.model.RequeteModels.Reponse;
import com.grokonez.jwtauthentication.model.RequeteModels.Requete;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("*")
@RepositoryRestResource
public interface ReponseRepository extends JpaRepository<Reponse,Long> {
    @RestResource(path = "/byDescriptionPage")
    Page<Reponse> findByDescriptionContains(@Param("mc") String req, Pageable pageable);
    @RestResource(path = "/byDescription")
    List<Reponse> findByDescriptionContains(@Param("mc") String req);
    List<Reponse> findByRequete(Requete requete);
}
