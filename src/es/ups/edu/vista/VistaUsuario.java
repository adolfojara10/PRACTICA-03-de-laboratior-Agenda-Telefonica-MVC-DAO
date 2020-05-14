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
 * encargada de la imperesio en consola de menus de opciones, creación de un
 * usuario, agregar telelfono a un usuario, editar, eliminar un telefono del
 * usuario. Encargado de pedir la contraseña y el correo de la persona de que
 * desea iniciar sesion. Imprime todos los clientes de la base de datos, y 
 * un usuario que se desea buscar.
 * @author Adolfo
 */
public class VistaUsuario {

    private Scanner entrada;

    public VistaUsuario() {
        entrada = new Scanner(System.in);
    }

    //menu de opciones
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

    //creacion de un cliente
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
        System.out.println("Ingrese la contraseña: ");
        String contraseña = entrada.next();

        return new Usuario(cedula, nombre, apellido, correo, contraseña);
    }

    //se pide el correo para el inicio de sesion
    public String iniciarSesionCorreo() {
        entrada = new Scanner(System.in);

        System.out.println("Escriba su correo: ");
        String correo = entrada.next();

        return correo;

    }

    //se pide la contraseña del inicio de sesion
    public String iniciarSesionContraseña() {
        entrada = new Scanner(System.in);

        System.out.println("Escriba su contraseÃ±a: ");
        String contraseña = entrada.next();

        return contraseña;
    }

    //se actualiza la informacion de un cliente
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

    //se elimina un cliente
    public Usuario eliminarCliente() {
        entrada = new Scanner(System.in);
        System.out.println("Ingresa el id del cliente a eliminar");
        String id = entrada.next();
        return new Usuario(id, null, null, null, null);
    }

    //confirmar cedula
    public String confirmacionCedula() {
        entrada = new Scanner(System.in);
        System.out.println("\nEscriba su cedula para confirmar el cambio:");
        String cedula = entrada.next();
        return cedula;
    }

    //para buscar un cliente
    public String buscarCliente() {
        entrada = new Scanner(System.in);
        System.out.println("Ingresa el correo o cedula del cliente: ");
        String id = entrada.next();
        return id;
    }

    //imprime un cliente
    public void verCliente(Usuario cliente) {
        System.out.println("Datos del Cliente: " + cliente);
    }

    //imprime todos los clientes
    public void verClientes(Map<String, Usuario> clientes) {
        for (Map.Entry<String, Usuario> usuario2 : clientes.entrySet()) {
            String key = usuario2.getKey();
            Usuario persona = usuario2.getValue();
            System.out.println("\nClave del usuario: " + key + "\n" + persona);
        }
    }

    //imprime una frase
    public void frase(String frase) {
        System.out.println(frase);
    }

}
