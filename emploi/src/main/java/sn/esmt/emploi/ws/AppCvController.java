package sn.esmt.emploi.ws;

//Importation des classes et interfaces nécessaires pour le fichier source.
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sn.esmt.emploi.dao.AppCvRepository;
import sn.esmt.emploi.entities.AppCvEntity;

import java.util.List;

//@RestController:indique que la classe est un contrôleur
@RestController
//spécifie le chemin de base pour toutes les requêtes HTTP associées aux utilisateurs.
@RequestMapping(value = "/cvs")
//annotation de Lombok qui permet de générer
// un constructeur avec tous les champs d'une classe
@AllArgsConstructor
//la classe AppUserController, qui est un contrôleur
// pour les requêtes HTTP associées aux cvs de l'application.
public class AppCvController {
    private AppCvRepository appCvRepository;

    //spécifie que cette méthode doit être appelée
    // lorsqu'une requête HTTP POST est envoyée à l'URL /cvs/save.
    @PostMapping(path = "/save")//POST REQUEST
    //@RequestBody indique que les données de la requête HTTP
    // doivent être converties en un objet AppUserEntity
    public AppCvEntity save(@RequestBody AppCvEntity appCvEntity){
        return appCvRepository.save(appCvEntity);
    }
    //************************************************************************************
    //spécifie que cette méthode doit être appelée
    // lorsqu'une requête HTTP GET est envoyée à l'URL /cvs/alls
    @GetMapping(path = "/all")
    public List<AppCvEntity> getAll(){
        return appCvRepository.findAll();
    }
    //************************************************************************************
    // spécifie que cette méthode doit être appelée
    // lorsqu'une requête HTTP GET est envoyée à l'URL /users/login
    @GetMapping(path = "/login")//GET REQUEST: "login" est un point d'entrée HTTP GET pour l'URI "/login".
    //Cette méthode prend deux paramètres email et adresse,
    // qui sont extraits de la requête HTTP en utilisant l'annotation @RequestParam
    public ApiLoginResponse login(@RequestParam String email,@RequestParam String adresse){
        //appelle la méthode "findByEmailAndAdresse" de la classe "AppCvRepository" pour trouver le cv
        // ayant l'adresse e-mail et l'adresse' correspondant aux paramètres de requête "email" et "adresse".
        AppCvEntity appCvEntity = appCvRepository.findByEmailAndAdresse(email, adresse);
        if(appCvEntity != null){
            //signifie qu'un cv correspondant aux informations d'identification a été trouvé.
            //une connexion réussie et l'adresse e-mail de cvr.
            return new ApiLoginResponse("OK",email);
        }else{
            //signifie aucun utilisateur correspondant n'a été trouvé
            //connexion sans resultat...
            return new ApiLoginResponse("NOK",email);
        }
    }
}
