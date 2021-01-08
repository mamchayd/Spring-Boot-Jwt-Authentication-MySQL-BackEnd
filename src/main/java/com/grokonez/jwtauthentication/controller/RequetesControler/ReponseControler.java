package com.grokonez.jwtauthentication.controller.RequetesControler;


import com.grokonez.jwtauthentication.message.GestionRequete.AddReponse;
import com.grokonez.jwtauthentication.message.response.ResponseMessage;
import com.grokonez.jwtauthentication.model.RequeteModels.Reponse;
import com.grokonez.jwtauthentication.model.RequeteModels.Requete;
import com.grokonez.jwtauthentication.model.User;
import com.grokonez.jwtauthentication.repository.RequeteRepositories.ReponseRepository;
import com.grokonez.jwtauthentication.repository.RequeteRepositories.RequeteRepository;
import com.grokonez.jwtauthentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ReponseControler {

    @Autowired
    ReponseRepository reponseRepository ;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RequeteRepository requeteRepository;

    @GetMapping(value = "/listReponses")
    public List<Reponse> listReponse(){
        return  reponseRepository.findAll();
    }


    @GetMapping(value = "/listReponses/{id}")
    public Reponse listReponse(@PathVariable(name="id") Long id){
        return  reponseRepository.findById(id).get();
    }


    @PutMapping(value = "/listReponses/{id}")
    public Reponse update(@PathVariable(name="id") Long id,@RequestBody Reponse r){
        r.setId(id);
        return  reponseRepository.save(r);
    }

    @PreAuthorize("hasRole('CONSULTANT') or hasRole('ADMIN')or hasRole('PROFESSEUR')")
    @PostMapping(value = "/listReponses")
    public Reponse save(@RequestBody Reponse r){
        return  reponseRepository.save(r);
    }



    @DeleteMapping(value = "/listReponses/{id}")
    public void delete(@PathVariable(name="id") Long id){
        reponseRepository.deleteById(id);
    }

    //--------------------------------------------------------------------------------------------------//

    @PostMapping("/api/reponse/add")
    public ResponseEntity<?> reponseadd(@Valid @RequestBody AddReponse addReponse) {
        // Creating user's account

        User user= userRepository.findByEmail(addReponse.getEmail()).orElseThrow(() -> new RuntimeException("Fail! -> Cause: User not find."));
        //Requete requete=requeteRepository.findByTitre(addReponse.getTitre()).orElseThrow(() -> new RuntimeException("Fail! -> Cause: type not find."));
        Requete requete=requeteRepository.findById(addReponse.getRequeteId()).orElseThrow(() -> new RuntimeException("Fail! -> Cause: type not find."));

        Date date=new Date();
        Reponse reponse=new Reponse(addReponse.getTitre(),addReponse.getDescription());
        reponse.setUser(user);
        reponse.setDate(date);
        reponse.setRequete(requete);
        reponseRepository.save(reponse);

        return new ResponseEntity<>(new ResponseMessage("reponse registered successfully!"), HttpStatus.OK);
    }


    @GetMapping("/api/reponse/affich")
    public ResponseEntity<?> requeteaffiche(@Valid @RequestBody AddReponse addReponse) {
       // User user= userRepository.findByEmail(addReponse.getEmail()).orElseThrow(() -> new RuntimeException("Fail! -> Cause: User not find."));
       Requete requete = requeteRepository.findById(addReponse.getRequeteId()).orElseThrow(() -> new RuntimeException("Fail! -> Cause: req not find."));
        return ResponseEntity.ok(reponseRepository.findByRequete(requete));
    }
}
