package com.grokonez.jwtauthentication.repository.RequeteRepositories;


import com.grokonez.jwtauthentication.model.RequeteModels.Requete;
import com.grokonez.jwtauthentication.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RepositoryRestResource
public interface RequeteRepository extends JpaRepository<Requete,Long> {

   @RestResource(path = "/byDescriptionPage")
   Page<Requete> findByDescriptionContains(@Param("mc") String req, Pageable pageable);
   @RestResource(path = "/byDescription")
   List<Requete> findByDescriptionContains(@Param("mc") String req);
   Boolean existsByUser(String email);

   List<Requete> findByUser(User user);
   Optional<Requete> findByTitre(String titre);
   Optional<Requete> findById(Long id);
   List<Requete> deleteByUser(User user);

  // Optional<Requete> findByUser(User user);
}
