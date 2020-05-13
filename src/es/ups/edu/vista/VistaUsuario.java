/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ups.edu.vista;

import es.ups.edu.modelo.Usuario;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * clase VistaUsuario.
 *
 * Esta clase es la encargada de pedir los datos de las opciones de menu, cuando
 * se quiere crear un nuevo usuario, cuando se quiere iniciar sesion, de
 * imprimir los telefonos de un usuario, de imprimir un usuario, de imprimir
 * todos los usuarios creados, y de imprimir frases. Estos son enviados a otras
 * clases para su debido funcionamiento.
 *
 * @see ControladorUsuario
 * @author Adolfo
 */
public class VistaUsuario {

    private Scanner entrada;

    public VistaUsuario() {
        entrada = new Scanner(System.in);
    }

    /**
     * metodo menu.
     *
     * es el encargado de imprimir las opciones del menu y de recibir un dato de
     * tipo entero que refleja la opcion que usuario desea ejecutar. Y por
     * ultimo devuelve ese numero.
     *
     * @return int
     */
    public int menu() {
        entrada = new Scanner(System.in);
        System.out.println("\nDigite el numero de accion que desea "
                + "ejecutar:\n" + "1.-Crear un nuevo usuario"
                + "\n2.-Iniciar sesion" + "\n3.-Imprimir telefonos de un usuario "
                + "\n4.-Buscar un usuario" + "\n5.-Imprimir todos los usuarios"
                + "\n6.-Imprimir todos los telefonos registrados" + "\n7.-Salir");
        int opcionMenu = entrada.nextInt();

        return opcionMenu;
    }

    /**
     * metodo ingresarUsuario.
     *
     * Es el metodo encargado de pedir todos los datos para crear un objeto de
     * tipo Usuario. Ademas se pregunta si se quieren añadir o no numeros de
     * telefono ese momento.
     *
     * @return Usuario
     */
    public Usuario ingresarCliente() {
        entrada = new Scanner(System.in);
        System.out.println("Ingresa los datos del cliente");
        System.out.println("Ingrese la cedula: ");
        String cedula = entrada.next();
        System.out.println("Ingrese el nombre: ");
        String nombre = entrada.next();
        System.out.println("Ingrese el apellido: ");
        String apellido = entrada.next();
        System.out.println("Ingrese el correo: ");
        String correo = entrada.next();
        System.out.println("Ingrese la contraseÃ±a: ");
        String contraseña = entrada.next();

        return new Usuario(cedula, nombre, apellido, correo, contraseña);
    }

    /**
     * metodo iniciarSesionCorreo.
     *
     * es el metodo encargado de pedir un correo al usuario que desea inicar
     * sesion. Devuelve este valor que es de tipo String
     *
     * @return String
     */
    public String iniciarSesionCorreo() {
        entrada = new Scanner(System.in);

        System.out.println("Escriba su correo: ");
        String correo = entrada.next();

        return correo;

    }

    /**
     * metodo iniciarSesionContraseña.
     *
     * metodo encargado de pedir la contraseña al usuario que quiere iniciar
     * sesion. Y por ultimo devuelve la contraseña que es de tipo String.
     *
     * @return String
     */
    public String iniciarSesionContraseña() {
        entrada = new Scanner(System.in);

        System.out.println("Escriba su contraseÃ±a: ");
        String contraseña = entrada.next();

        return contraseña;
    }
    
    /**
     * metodo actualizarUsuario.
     * 
     * actualiza un usuario en la base de datos
     * @return Usuario
     */
    public Usuario actualizarCliente() {
        entrada = new Scanner(System.in);
        System.out.println("Ingresa el id del cliente a actualizar");
        String id = entrada.next();
        System.out.println("Ingrese los nuevos Datos (nombre, apellido)");
        String nombre = entrada.next();
        String apellido = entrada.next();
        String correo = entrada.next();
        String contraseña = entrada.next();
        return new Usuario(id, nombre, apellido, correo, contraseña);
    }

    /**
     * metodo eliminarUsuario.
     * 
     * elimina un usuario de la base datos y del sistema.
     * @return Usuario
     */
    public Usuario eliminarCliente() {
        entrada = new Scanner(System.in);
        System.out.println("Ingresa el id del cliente a eliminar");
        String id = entrada.next();
        return new Usuario(id, null, null, null, null);
    }

    /**
     * metodo confirmacionCedula.
     * 
     * pide esto cad vez que va a haber un cambio en el usuario
     * @return Usuario
     */
    public String confirmacionCedula() {
        entrada = new Scanner(System.in);
        System.out.println("\nEscriba su cedula para confirmar el cambio:");
        String cedula = entrada.next();
        return cedula;
    }

    /**
     * metodo buscarUsuario.
     * 
     * para pedir un id del usuario(correo o contraseña) y mandarlo para su futura
     * busqueda
     * @return String
     */
    public String buscarCliente() {
        entrada = new Scanner(System.in);
        System.out.println("Ingresa el correo o cedula del cliente: ");
        String id = entrada.next();
        return id;
    }

    //imprime un usuario
    public void verCliente(Usuario cliente) {
        System.out.println("Datos del Cliente: " + cliente);
    }

    //me imprime todos los clientes
    public void verClientes(Map<String, Usuario> clientes) {
        for (Map.Entry<String, Usuario> usuario2 : clientes.entrySet()) {
            String key = usuario2.getKey();
            Usuario persona = usuario2.getValue();
            System.out.println("\nClave del usuario: " + key + "\n" + persona);
        }
    }

    //para imprimir una frase
    public void frase(String frase) {
        System.out.println(frase);
    }

}
