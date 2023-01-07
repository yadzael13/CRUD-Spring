package com.examenYadzael.demo.Database;

import java.util.ArrayList;
import java.util.List;



import com.examenYadzael.demo.Entities.Usuario;


public interface UsuarioDinamicList {
  
    static List<Usuario> usuarioList = new ArrayList<>();

    //Obtener todos los usuarios
     static List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    //Añadir un usuario a la lista
    default void addUsuarioList(Usuario u){
        usuarioList.add(u);
    }

    //Obtener un usuario por index
    default Usuario getUser(int id){
        return usuarioList.get(id);
    }

    //Actualizar usuario
    default void putUser(int id, Usuario usr){
        usuarioList.remove(id);
        usuarioList.add(id, usr);
    }

    //Eliminar usuario por index
    default void deleteUser(int id){
        usuarioList.remove(id);
        
    }

    

}




