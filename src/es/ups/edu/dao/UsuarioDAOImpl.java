/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ups.edu.dao;

import ec.ups.edu.idao.IUsuarioDAO;
import es.ups.edu.modelo.Usuario;
import java.util.ArrayList;
import java.util.*;

/**
 *
 * @author Adolfo
 */
public class UsuarioDAOImpl implements IUsuarioDAO {

    private Map<String, Usuario> listaUsuarios;

    public UsuarioDAOImpl() {
        listaUsuarios = new HashMap<>();
    }

    @Override
    public void create(Usuario cliente) {
        listaUsuarios.put(cliente.getCedula(), cliente);
    }

    @Override
    public Usuario read(String cedula) {
        //bucle for each para buscar el usuario
        for (Map.Entry<String, Usuario> usuario : listaUsuarios.entrySet()) {
            String key = usuario.getKey();
            Usuario valor = usuario.getValue();
            //se compara la cedula o el correo
            if (valor.getCedula().equals(cedula)
                    || (valor.getCorreo().equals(cedula))) {
                //se obtiene el usuario con el key
                Usuario usuario2 = listaUsuarios.get(key);
                return usuario2;
            }

        }
        return null;
    }

    @Override
    public void update(Usuario cliente) {
        for (Map.Entry<String, Usuario> usuario2 : listaUsuarios.entrySet()) {
            Usuario usuario3 = usuario2.getValue();
            if (usuario3.getCedula().equals(cliente.getCedula())) {
                listaUsuarios.replace(cliente.getCedula(), cliente);
                break;
            }

        }

    }

    @Override
    public void delete(Usuario cliente) {
        for (Map.Entry<String, Usuario> usuario2 : listaUsuarios.entrySet()) {
            Usuario usuario3 = usuario2.getValue();
            if (usuario3.getCedula().equals(cliente.getCedula())) {
                listaUsuarios.remove(cliente.getCedula());
                break;
            }

        }
    }

    @Override
    public Usuario iniciarSesion(String correo, String contraseña) {
        //bucle for each para recorrer los usuarios
        for (Map.Entry<String, Usuario> usuario : listaUsuarios.entrySet()) {
            String key = usuario.getKey();
            Usuario valor = usuario.getValue();
            //compara primero el correo
            if (valor.getCorreo().equals(correo)) {
                //si el correo es igual, compara la contraseÃ±a
                if (valor.getContraseña().equals(contraseña)) {
                    Usuario usu = new Usuario();
                    usu = listaUsuarios.get(key);
                    return usu;
                }
            }
        }

        return null;
    }

    @Override
    public Map<String, Usuario> findAll() {
        return listaUsuarios;
    }

}
