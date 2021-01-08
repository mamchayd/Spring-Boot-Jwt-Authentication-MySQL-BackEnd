package com.grokonez.jwtauthentication.repository.RequeteRepositories;

import com.grokonez.jwtauthentication.model.RequeteModels.TypeRequete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface TypeReqRepository extends JpaRepository<TypeRequete,Long> {
    Optional<TypeRequete> findByType(String type);
}
