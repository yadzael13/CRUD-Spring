package com.examenYadzael.demo.Logic;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examenYadzael.demo.Entities.Usuario;
import com.examenYadzael.demo.Tools.MyLoggers;
import com.examenYadzael.demo.Database.UsuarioDinamicList;

@Service
public class CrudLogic implements UsuarioDinamicList{
    //Inicializa la lista dinámica


    /**Crear usuario
     * @param user Objeto tipo Usuario
     * @return True o false si se ha creado
     */
    public Boolean create_user_logic(Usuario user){
        try {
            addUsuarioList(user);
            return true;
        } catch (Exception e) {
            // Logger de error personalizado
            MyLoggers.errorLog("CrudLogic - createUserLogic", e.toString());
            return false;
        }
    }

    /**Obtener la lista de usuarios
     * @return Lista con objetos tipo usuario
     */
    public static List<Usuario> get_users_logic(){
        try {
            return UsuarioDinamicList.getUsuarioList();
        } catch (Exception e) {
            MyLoggers.errorLog("CrudLogic - getUsers", e.toString());
            return null;
        }
        
    }

    /**Obtener un Usuario
     * @return Objeto tipo usuario
     */
    public Usuario get_user_logic(int id){
        try {
            Usuario us = getUser(id);
            return us;
        } catch (Exception e) {
            MyLoggers.errorLog("CrudLogic - getUser", e.toString());
            return null;
        }
        
    }

    /**Actualizar usuario por id
     * @param id
     * @param usr
     * @return True or False
     */
    public Boolean put_user_logic(int id, Usuario usr){
        try {
            putUser(id, usr);
            return true;
           
        } catch (Exception e) {
            MyLoggers.errorLog("CrudLogic - putUser", e.toString());
            return false;
        }
    }

    /**Eliminar usuario por id
     * @param id
     * @param usr
     * @return True or False
     */
    public Boolean delete_user_logic(int id){
        try {
            deleteUser(id);
            return true;
            
        } catch (Exception e) {
            MyLoggers.errorLog("CrudLogic - deleteUser", e.toString());
            return false;
            
        }
    }


}
