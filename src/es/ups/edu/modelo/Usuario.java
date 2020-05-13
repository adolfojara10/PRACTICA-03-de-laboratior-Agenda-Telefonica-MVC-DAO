/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ups.edu.modelo;

import es.ups.edu.modelo.Telefono;
import java.util.*;

/**
 *
 * @author Adolfo
 */
public class Usuario {

    private String cedula;
    private String nombre;
    private String apellido;
    private String correo;
    private String contraseña;
    //atributo de agregacion
    private List<Telefono> listaTelefonos;

    //constructores
    public Usuario() {
        listaTelefonos = new ArrayList<>();
    }

    //metodo constructor de seteo de todos sus datos
    public Usuario(String cedula, String nombre, String apellido, String correo,
            String contraseña) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contraseña = contraseña;
        listaTelefonos = new ArrayList<>();
    }

    //getters y setters
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * metodo getListaTelefonos.
     *
     * devuelve la lsitade telefonos de un usuario.
     *
     * @return List
     */
    public List<Telefono> getListaTelefonos() {
        return listaTelefonos;
    }

    /**
     * metodo agregarTelefono.
     *
     * sirve para agregar telefonos al usuario
     *
     * @param telefono
     */
    public void agregarTelefono(Telefono telefono) {
        listaTelefonos.add(telefono);
    }

    /**
     * metodo actualizarTelefono.
     *
     * actualiza la listad e telefonos con un teleofono que reemplza a uno
     * creado anteriormente
     *
     * @param telefono
     */
    public void actualizarTelefono(Telefono telefono) {
        if (listaTelefonos.contains(telefono)) {
            int index = listaTelefonos.indexOf(telefono);
            listaTelefonos.set(index, telefono);
        }
    }

    /**
     * metodo eliminarTelefono.
     *
     * elimina un telelfono del la lista de telefonos del usuario
     *
     * @param telefono
     */
    public void eliminarTelefono(Telefono telefono) {
        if (listaTelefonos.contains(telefono)) {
            int index = listaTelefonos.indexOf(telefono);
            listaTelefonos.remove(index);
        }
    }

    /**
     * metodo listar.
     *
     * devuelve la lista de telefonos del usuario
     *
     * @return List
     */
    public List<Telefono> listar() {
        return listaTelefonos;
    }

    /**
     * metodo buscar.
     *
     * busca un telefono en la lista del usuario de telefonos
     *
     * @param id
     * @return Telefono
     */
    public Telefono buscar(int id) {

        return listaTelefonos.get(id);

    }

    /**
     * metodo toString.
     *
     * sirve para la correcta impresion de los datos de la persona.
     *
     * @return
     */
    @Override
    public String toString() {
        return "\nUsuario:\n" + "cedula: " + cedula + "\nnombre: " + nombre
                + ", apellido: " + apellido + "\ncorreo: " + correo
                + ", contraseÃ±a: " + contraseña + "\ntelefono(s):\n " + listaTelefonos;
    }

}
