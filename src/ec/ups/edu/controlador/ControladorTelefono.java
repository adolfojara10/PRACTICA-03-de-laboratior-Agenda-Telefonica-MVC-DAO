/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.controlador;

import ec.ups.edu.idao.ITelefonoDAO;
import es.ups.edu.modelo.Telefono;
import es.ups.edu.vista.VistaTelefono;
import es.ups.edu.dao.TelefonoDAOImpl;
import java.util.*;

/**
 *
 * @author Adolfo
 */
public class ControladorTelefono {

    //objetos vist
    private VistaTelefono vistaDireccion;
    private Telefono direccion;
    private ITelefonoDAO direccionDAO;

    // constructor
    public ControladorTelefono(VistaTelefono vistaDireccion, TelefonoDAOImpl direccionDAO) {
        this.vistaDireccion = vistaDireccion;
        this.direccionDAO = direccionDAO;
    }

    //llama al DAO para guardar un usuario
    public void registrar() {
        direccion = vistaDireccion.ingresarTelefono();
        direccionDAO.create(direccion);
        vistaDireccion.verDireccion(direccion);
    }

    //llama al DAO para obtener un usuario por el correo o contraseña
    public void verDireccion() {
        int id = vistaDireccion.buscarTelefono();
        direccion = direccionDAO.read(id);
        vistaDireccion.verDireccion(direccion);
    }

    //llama al DAO para actualizar un usuario
    public void actualizar() {
        int codigo = vistaDireccion.pedirCodigo();
        direccion = direccionDAO.read(codigo);
        if (direccion != null) {
            vistaDireccion.verDireccion(direccion);
            direccion = vistaDireccion.actualizarTelefono();
            direccionDAO.update(direccion);
        }

    }

    //llama al DAO para eliminar un usuario
    public void eliminar() {
        int id = vistaDireccion.eliminarTelefono();
        direccion = direccionDAO.read(id);
        vistaDireccion.verDireccion(direccion);
        /*
       direccionDAO.delete(direccion);
         */
    }

    //llama al DAO para obtener todos los usuarios y luego los muestra en la vista
    public void verDirecciones() {
        Map<Integer, Telefono> direcciones;
        direcciones = direccionDAO.findAll();
        vistaDireccion.verTelefonos(direcciones);
    }

}
