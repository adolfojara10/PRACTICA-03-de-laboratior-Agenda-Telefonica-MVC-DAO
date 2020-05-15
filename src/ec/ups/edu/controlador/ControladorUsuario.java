/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.controlador;

import ec.ups.edu.idao.ITelefonoDAO;
import ec.ups.edu.idao.IUsuarioDAO;
import es.ups.edu.modelo.Telefono;
import es.ups.edu.modelo.Usuario;
import es.ups.edu.vista.VistaTelefono;
import es.ups.edu.vista.VistaUsuario;
import es.ups.edu.dao.TelefonoDAOImpl;
import es.ups.edu.dao.UsuarioDAOImpl;
import java.util.*;
import java.util.Map;

/**
 * clase ControladorUsuario.
 *
 * clase que llama a la vista y al dao para crear, eliminar, obtener, actualzar
 * un usuario. Ademas aqui se agregan, eliminan, editan telefonos de un usuario.
 *
 * @author Adolfo
 */
public class ControladorUsuario {

    //objetos vista
    private VistaUsuario vistaU;
    private VistaTelefono vistaT;
    //objetos modelo
    private Usuario cliente;
    private Telefono tele;
    //objetos DAO
    private IUsuarioDAO clienteDAO;
    private ITelefonoDAO telefonoDAO;

    // constructor
    public ControladorUsuario(VistaUsuario vistaCliente, UsuarioDAOImpl clienteDAO,
            VistaTelefono vistaDireccion, TelefonoDAOImpl direccionDAO) {
        this.vistaU = vistaCliente;
        this.clienteDAO = clienteDAO;

        this.vistaT = vistaDireccion;
        this.telefonoDAO = direccionDAO;

    }

    //llama al DAO para guardar un usuario
    public void registrar() {
        cliente = vistaU.ingresarCliente();
        clienteDAO.create(cliente);
    }

    //se inicia sesion
    public Usuario iniciarSesion() {

        //se obtienen los datos de contraseÃ±a y correo
        String correo = vistaU.iniciarSesionCorreo();
        String contraseña = vistaU.iniciarSesionContraseña();

        //se envian los datos y se recibe una persona
        cliente = clienteDAO.iniciarSesion(correo, contraseña);

        vistaU.verCliente(cliente);
        return cliente;
    }

    //busca telefonos de un usuario
    public void buscarTelefonos() {
        String id = vistaU.buscarCliente();
        cliente = clienteDAO.read(id);
        if (cliente != null) {
            vistaT.imprimirTelefonosUsuario(cliente);
        } else {
            String frase = "Usuario no encontrado";
            vistaU.frase(frase);
        }
    }

    //imprime un usuario
    public void imprimirUsuario() {

        String id = vistaU.buscarCliente();
        cliente = clienteDAO.read(id);
        if (cliente != null) {
            vistaU.verCliente(cliente);
        } else {
            String frase = "Usuario no encontrado";
            vistaU.frase(frase);
        }

    }

    //llama al DAO para obtener un usuario por la cedula o correo
    public boolean verCliente() {
        String id = vistaU.confirmacionCedula();
        cliente = clienteDAO.read(id);
        if (cliente == null) {
            String frase = "cedula no valida";
            vistaU.frase(frase);
            return false;
        }
        return true;
    }

    //llama al DAO para actualizar un usuario
    public void actualizar() {
        cliente = vistaU.actualizarCliente();
        clienteDAO.update(cliente);
    }

    //llama al DAO para eliminar un usuario
    public void eliminar() {
        cliente = vistaU.eliminarCliente();
        clienteDAO.delete(cliente);
    }

    //para ver los usarios
    public void verClientes() {
        Map<String, Usuario> clientes;
        clientes = clienteDAO.findAll();
        vistaU.verClientes(clientes);
    }

    //para ver los usuarios
    public void agregarTelefono() {
        int id = vistaT.confirmarCodigo();
        tele = telefonoDAO.read(id);
        if (tele != null) {
            cliente.agregarTelefono(tele);
            clienteDAO.update(cliente);
            vistaT.imprimirTelefonosUsuario(cliente);
        } else {
            String frase = "Codigo erroneo";
            vistaU.frase(frase);
        }

    }

    //actualizar un telefono
    public void actualizarTelefono() {
        int id = vistaT.confirmarCodigo();
        tele = telefonoDAO.read(id);
        if (tele != null) {

            cliente.actualizarTelefono(tele);
            clienteDAO.update(cliente);
            vistaT.imprimirTelefonosUsuario(cliente);
        } else {
            String frase = "Telefono no encontrado";
            vistaU.frase(frase);
        }
    }

    //elimina un telefono
    public void eliminarTelefono() {

        int id = vistaT.confirmarCodigo();
        tele = telefonoDAO.read(id);
        if (tele != null) {

            cliente.eliminarDireccion(tele);
            clienteDAO.update(cliente);
            vistaT.imprimirTelefonosUsuario(cliente);
            telefonoDAO.delete(tele);
        } else {
            String frase = "Codigo erroneo";
            vistaU.frase(frase);
        }
    }

    //frase a imprimir de salir
    public void salir() {

        //creacion de la frase a ser impresa
        String frase = "Usted ha salido del programa";

        //impresion de la frase
        vistaU.frase(frase);
    }

    //frase de numero erroneo
    public void numeroErroneo() {

        //creacion de la frase a ser impresa
        String frase = "Opcion incorrecta. Digite otra vez la opcion";
        //impresion de la frase
        vistaU.frase(frase);
    }

    //cerrar sesion
    public void cerrarSesion() {
        String frase = "Sesion cerrada";
        vistaU.frase(frase);

    }
}
