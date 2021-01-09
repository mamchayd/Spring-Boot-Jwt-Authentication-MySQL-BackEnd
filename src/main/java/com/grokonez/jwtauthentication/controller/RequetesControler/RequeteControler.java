package com.grokonez.jwtauthentication.controller.RequetesControler;



import com.grokonez.jwtauthentication.message.GestionRequete.AddRequete;
import com.grokonez.jwtauthentication.message.GestionRequete.AffichRequete;
import com.grokonez.jwtauthentication.message.response.ResponseMessage;
import com.grokonez.jwtauthentication.model.RequeteModels.Requete;
import com.grokonez.jwtauthentication.model.RequeteModels.TypeRequete;
import com.grokonez.jwtauthentication.model.User;
import com.grokonez.jwtauthentication.repository.RequeteRepositories.RequeteRepository;
import com.grokonez.jwtauthentication.repository.RequeteRepositories.TypeReqRepository;
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
public class RequeteControler {

    @Autowired
    RequeteRepository requeteRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    TypeReqRepository typeReqRepository;

    @PostMapping(path = "/consultent/requete/deplica/{id}")
    public Requete marckasDup(@PathVariable("id") Long id){
        Requete requete=requeteRepository.findById(id).get();
        requete.setDuplique(true);
        requeteRepository.save(requete);
        return requete;
    }

    @GetMapping(value = "/listrequetes")
    public List<Requete> listRequete(){
        return  requeteRepository.findAll();
    }


    @GetMapping(value = "/listrequetes/{id}")
    public Requete listRequete(@PathVariable(name="id") Long id){
        return  requeteRepository.findById(id).get();
    }

    @PutMapping(value = "/listrequetes/{id}")
    public Requete update(@PathVariable(name="id") Long id,@RequestBody Requete r){
        r.setId(id);
        return  requeteRepository.save(r);
    }

//----------------------------------------------------------------------------------------------------//

    @DeleteMapping("/api/requete/delete/{id}")
    public ResponseEntity<Object> requetedelete(@PathVariable Long id) {
        requeteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping ("/api/requete/affich")
    public ResponseEntity<?> requeteaffiche(@Valid @RequestBody AffichRequete affichRequete) {
        User user= userRepository.findByUsername(affichRequete.getUsername()).orElseThrow(() -> new RuntimeException("Fail! -> Cause: User not find."));

        return ResponseEntity.ok(requeteRepository.findByUser(user));
    }


    @PostMapping("/api/requete/add")
    public ResponseEntity<?> requeteadd(@Valid @RequestBody AddRequete addRequete) {
        // Creating user's account

        User user= userRepository.findByUsername(addRequete.getUsername()).orElseThrow(() -> new RuntimeException("Fail! -> Cause: User not find."));
        TypeRequete type= typeReqRepository.findByType(addRequete.getType()).orElseThrow(() -> new RuntimeException("Fail! -> Cause: type not find."));

        Date date=new Date();
        Requete requete=new Requete(addRequete.getTitre(),addRequete.getDescription());
        requete.setUser(user);
        requete.setDate(date);
        requete.setType(type);
        requeteRepository.save(requete);

        return new ResponseEntity<>(new ResponseMessage("req registered successfully!"), HttpStatus.OK);
    }
}

