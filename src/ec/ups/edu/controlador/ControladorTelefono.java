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
    private VistaTelefono vista;
    private Telefono tele;
    private ITelefonoDAO telefonoDAO;

    // constructor
    public ControladorTelefono(VistaTelefono vistaDireccion, TelefonoDAOImpl direccionDAO) {
        this.vista = vistaDireccion;
        this.telefonoDAO = direccionDAO;
    }

    //llama al DAO para guardar un telefono
    public void registrar() {
        tele = vista.ingresarTelefono();
        telefonoDAO.create(tele);
        vista.verDireccion(tele);
    }

    //llama al DAO para obtener un telefono por el codigo
    public void verDireccion() {
        int id = vista.buscarTelefono();
        tele = telefonoDAO.read(id);
        vista.verDireccion(tele);
    }

    //llama al DAO para actualizar un telefono
    public void actualizar() {
        int codigo = vista.pedirCodigo();
        tele = telefonoDAO.read(codigo);
        if (tele != null) {
            vista.verDireccion(tele);
            tele = vista.actualizarTelefono();
            telefonoDAO.update(tele);
        }

    }

    //llama al DAO para eliminar un telefono
    public void eliminar() {
        int id = vista.eliminarTelefono();
        tele = telefonoDAO.read(id);
        vista.verDireccion(tele);
        /*
       direccionDAO.delete(direccion);
         */
    }

    //llama al DAO para obtener todos los telefonos y luego los muestra en la vista
    public void verTodosTelefonos() {
        Map<Integer, Telefono> direcciones;
        direcciones = telefonoDAO.findAll();
        vista.verTelefonos(direcciones);
    }

}
