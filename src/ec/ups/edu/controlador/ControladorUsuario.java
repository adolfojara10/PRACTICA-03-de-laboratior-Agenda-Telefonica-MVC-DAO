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
import es.ups.edu.modelo.Usuario;
import java.util.*;
import java.util.Map;

/**
 *
 * @author Adolfo
 */
public class ControladorUsuario {

   //objetos vist
    private VistaUsuario vistaCliente;
    private VistaTelefono vistaDireccion;
    //objetos modelo
    private Usuario cliente;
    private Telefono direccion;
    //objetos DAO
    private IUsuarioDAO clienteDAO;
    private ITelefonoDAO direccionDAO;

    // constructor
    public ControladorUsuario(VistaUsuario vistaCliente, UsuarioDAOImpl clienteDAO,
            VistaTelefono vistaDireccion, TelefonoDAOImpl direccionDAO) {
        this.vistaCliente = vistaCliente;
        this.clienteDAO = clienteDAO;

        this.vistaDireccion = vistaDireccion;
        this.direccionDAO = direccionDAO;

    }

    //llama al DAO para guardar un cliente
   public void registrar() {
        cliente = vistaCliente.ingresarCliente();
        clienteDAO.create(cliente);
    }

    public Usuario iniciarSesion() {
        //se obtienen los datos de contraseÃ±a y correo
        String correo = vistaCliente.iniciarSesionCorreo();
        String contraseña = vistaCliente.iniciarSesionContraseña();

        //se envian los datos y se recibe una persona
        cliente = clienteDAO.iniciarSesion(correo, contraseña);
        vistaCliente.verCliente(cliente);
        return cliente;
    }
    public void buscarTelefonos(){
        String id = vistaCliente.buscarCliente();
        cliente=clienteDAO.read(id);
        if(cliente!=null){
            vistaDireccion.imprimirTelefonosUsuario(cliente);
        } else {
            String frase = "Usuario no encontrado";
            vistaCliente.frase(frase);
        }
    }
    
    public void imprimirUsuario(){
       
        String id = vistaCliente.buscarCliente();
        cliente = clienteDAO.read(id);
        if (cliente!=null){
           vistaCliente.verCliente(cliente);
        } else {
           String frase = "Usuario no encontrado";
            vistaCliente.frase(frase);
        }
       
   }
    
   //llama al DAO para obtener un cliente por el id y luego los muestra en la vista
    public boolean verCliente() {
       String id = vistaCliente.confirmacionCedula();
        cliente = clienteDAO.read(id);
        if (cliente == null) {
            String frase = "cedula no valida";
            vistaCliente.frase(frase);
            return false;
        }
        return true;
    }

    //llama al DAO para actualizar un cliente
    public void actualizar() {
        cliente = vistaCliente.actualizarCliente();

        clienteDAO.update(cliente);
    }

    //llama al DAO para eliminar un cliente
   public void eliminar() {
        cliente = vistaCliente.eliminarCliente();
        clienteDAO.delete(cliente);
    }

    //llama al DAO para obtener todos los clientes y luego los muestra en la vista
    public void verClientes() {
        Map<String, Usuario> clientes;
        clientes = clienteDAO.findAll();
        vistaCliente.verClientes(clientes);
    }

   //ejemplo de agregacion
    public void agregarDireccion() {
       int id = vistaDireccion.confirmarCodigo();
        direccion = direccionDAO.read(id);
       if (direccion != null) {
            cliente.agregarTelefono(direccion);
            clienteDAO.update(cliente);
            vistaDireccion.imprimirTelefonosUsuario(cliente);
        }else{
           String frase = "Codigo erroneo";
            vistaCliente.frase(frase);
        }
        
    }

    public void actualizarTelefono() {
        int id = vistaDireccion.confirmarCodigo();
        direccion = direccionDAO.read(id);
        if (direccion != null) {

            cliente.actualizarTelefono(direccion);
            clienteDAO.update(cliente);
            vistaDireccion.imprimirTelefonosUsuario(cliente);
        } else {
            String frase = "Telefono no encontrado";
            vistaCliente.frase(frase);
        }

    }

    public void eliminarTelefono() {

        int id = vistaDireccion.confirmarCodigo();
        direccion = direccionDAO.read(id);
        if (direccion != null) {

           cliente.eliminarDireccion(direccion);
            clienteDAO.update(cliente);
            vistaDireccion.imprimirTelefonosUsuario(cliente);
            direccionDAO.delete(direccion);
       } else {
            String frase = "Codigo erroneo";
            vistaCliente.frase(frase);
       }
    }

    public void salir() {

        //creacion de la frase a ser impresa
        String frase = "Usted ha salido del programa";

        //impresion de la frase
        vistaCliente.frase(frase);
    }

    public void numeroErroneo() {

        //creacion de la frase a ser impresa
        String frase = "Opcion incorrecta. Digite otra vez la opcion";
        //impresion de la frase
        vistaCliente.frase(frase);
    }

    public void cerrarSesion(){
        String frase = "Sesion cerrada";
        vistaCliente.frase(frase);
        
    }
}