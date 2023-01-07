package com.examenYadzael.demo.Controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.examenYadzael.demo.Entities.Response;
import com.examenYadzael.demo.Entities.Usuario;
import com.examenYadzael.demo.Logic.CrudLogic;

    //Notación para indicar que es un controlador de tipo Rest
@RestController
//Notación para indicar el contexto de nuestros endpoint es decir /torre/nombreServicio
@RequestMapping("/WSCentralesMock/api/v1")
//URL que permitimos que consuman nuestras APIS
//En caso de querer permitir todos los origentes ponemos en lugar de la URL un *
//@CrossOrigin(origins = "http://localhost:8080")
public class Controller extends CrudLogic{
  
   /*El nombre de las torres es unico,
    en la creación y actualizacón se hace la validación*/
  
    //Inyección de dependencias
    @Autowired
    CrudLogic crudLogic;
    
    //TorreService torreService;

    //Se le indica el tipo de petición asi como el nombre del servicio


    /**Servicio para crear un usuario
     * @param newUser
     * @return ResponseEntity
     */
    @PostMapping("/usuario")
    public ResponseEntity<?> create_user(@RequestBody Usuario newUser){


        Response resp = new Response();
            Boolean status = create_user_logic(newUser);
            if(status){
                resp.setCode("200");
                resp.setResult("Servicio consumido");
                resp.setResulDescription("Se ha creado el usuario correctamente");    
            }
            else{
                resp.setCode("400");
                resp.setResult("Operación con error");
                resp.setResulDescription("No se ha podido crear el usuario"); 
            }
           
        
       return ResponseEntity.status(HttpStatus.OK).body(resp);
    }

    /**Obtener un  usuario
     * @return ResponseEntity
     */
    @GetMapping("/usuario")
    public ResponseEntity<?> get_user(){

           List<Usuario> listResp = get_users_logic();
           
        
       return ResponseEntity.status(HttpStatus.OK).body(listResp);
    }

     /**Obtener todos lo usuarios
     * @return ResponseEntity
     */
    @GetMapping("/usuario/{id}")
    public ResponseEntity<?> get_users(@PathVariable("id") int id){


       // Response resp = new Response();
           Usuario resp = get_user_logic(id);
           if(resp==null){
            Response res = new Response();
            res.setCode("400");
            res.setResult("Operación con error");
            res.setResulDescription("No existe el usuario con index: " + id); 
            return ResponseEntity.status(HttpStatus.OK).body(res);
           }
           return ResponseEntity.status(HttpStatus.OK).body(resp);
        
      
    }

   
    /**Actualizacion de usuarios por id
     * @param id
     * @param usr
     * @return ResponseEntity
     */
    @PostMapping("/usuario/{id}")
    public ResponseEntity<?> put_user(@PathVariable("id") int id, @RequestBody Usuario usr){


       // Response resp = new Response();
       Response res = new Response();
           Boolean status = put_user_logic(id,usr);
           if(status){
                res.setCode("200");
                res.setResult("Servicio consumido");
                res.setResulDescription("Se ha Actualizado el usuario correctamente");    
            
           } else{
            res.setCode("400");
            res.setResult("Operación con error");
            res.setResulDescription("No existe el usuario con index: " + id); 
           }
           return ResponseEntity.status(HttpStatus.OK).body(res);
        
      
    }

     /**Eliminacion de usuarios por id
     * @param id
     * @return ResponseEntity
     */
    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<?> delete_user(@PathVariable("id") int id){


       // Response resp = new Response();
       Response res = new Response();
           Boolean status = delete_user_logic(id);
           if(status){
                res.setCode("200");
                res.setResult("Servicio consumido");
                res.setResulDescription("Se ha Eliminado el usuario correctamente");    
            
           } else{
            res.setCode("400");
            res.setResult("Operación con error");
            res.setResulDescription("No existe el usuario con index: " + id); 
           }
           return ResponseEntity.status(HttpStatus.OK).body(res);
        
      
    }

}
