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
 * clase ControladorTelefono.
 *
 * clase encargada de crear, actualizar, eliminar un telefono. Esta recibe
 * diferentes parametros para su correcta realizacion de metodos.
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

    //llama al DAO para guardar un telefono
    public void registrar() {
        direccion = vistaDireccion.ingresarTelefono();
        direccionDAO.create(direccion);
        vistaDireccion.verDireccion(direccion);
    }

    //llama al DAO para obtener un telefono por el codigo
    public void verDireccion() {
        int id = vistaDireccion.buscarTelefono();
        direccion = direccionDAO.read(id);
        vistaDireccion.verDireccion(direccion);
    }

    //llama al DAO para actualizar un telefono
    public void actualizar() {
        int codigo = vistaDireccion.pedirCodigo();
        direccion = direccionDAO.read(codigo);
        if (direccion != null) {
            vistaDireccion.verDireccion(direccion);
            direccion = vistaDireccion.actualizarTelefono();
            direccionDAO.update(direccion);
        }

    }

    //llama al DAO para eliminar un telefono
    public void eliminar() {
        int id = vistaDireccion.eliminarTelefono();
        direccion = direccionDAO.read(id);
        vistaDireccion.verDireccion(direccion);
        /*
       direccionDAO.delete(direccion);
         */
    }

    //llama al DAO para obtener todos los telefonos y luego los muestra en la vista
    public void verDirecciones() {
        Map<Integer, Telefono> direcciones;
        direcciones = direccionDAO.findAll();
        vistaDireccion.verTelefonos(direcciones);
    }

}
