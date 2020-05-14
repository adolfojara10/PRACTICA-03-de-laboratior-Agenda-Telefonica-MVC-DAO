/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ups.edu.vista;

import es.ups.edu.modelo.Telefono;
import es.ups.edu.modelo.Usuario;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Adolfo
 */
public class VistaTelefono {

    private Scanner entrada;

    public VistaTelefono() {
        entrada = new Scanner(System.in);
    }

    public int menuEditarTelefonoUsuario() {
        entrada = new Scanner(System.in);
        System.out.println("\nDigite la opcion que desea realizar:\n"
                + "1.-Ingresar un nuevo numero" + "\n2.-Editar un telefono"
                + "\n3.-Eliminar un telefono" + "\n4.-Cerrar sesion y volver al "
                + "menu");
        int opcionSesion = entrada.nextInt();

        return opcionSesion;
    }

    public Telefono ingresarTelefono() {
        entrada = new Scanner(System.in);
        System.out.println("Ingresa los datos del Telefono:");

        System.out.println("Ingrese el numero: ");
        String numero = entrada.next();
        System.out.println("Ingrese el tipo de telefono: ");
        String tipo = entrada.next();
        System.out.println("Ingrese la operadora: ");
        String operadora = entrada.next();
        System.out.println("Ingrese el codigo: ");
        int codigo = entrada.nextInt();
        return new Telefono(codigo, numero, tipo, operadora);
    }

    public int confirmarCodigo() {
        entrada = new Scanner(System.in);
        System.out.println("\nConfirme el codigo del telefono: ");
        int codigo = entrada.nextInt();
        return codigo;
    }

    public int pedirCodigo() {

        entrada = new Scanner(System.in);
        System.out.println("Ingresa el codigo del telefono a actualizar");
        int id = entrada.nextInt();

        return id;
    }

    public Telefono actualizarTelefono() {
        entrada = new Scanner(System.in);
        System.out.println("\nIngrese los nuevos datos: ");
        System.out.println("\nIngresa el mismo codigo: ");
        int id = entrada.nextInt();
        System.out.println("Ingrese el numero: ");
        String numero = entrada.next();
        System.out.println("Ingrese el tipo: ");
        String tipo = entrada.next();
        System.out.println("Ingrese la operadora: ");
        String operadora = entrada.next();

        return new Telefono(id, numero, tipo, operadora);
    }

    public int eliminarTelefono() {
        entrada = new Scanner(System.in);
        System.out.println("Ingresa el codigo del telefono a eliminar");
        int id = entrada.nextInt();
        return id;
    }

    public int buscarTelefono() {
        entrada = new Scanner(System.in);
        System.out.println("Ingresa el id de la direccion a buscar");
        int id = entrada.nextInt();
        return id;
    }

    public void imprimirTelefonosUsuario(Usuario usuario) {
        if (usuario.getListaTelefonos().isEmpty()) {
            System.out.println("El usuario no tiene telefonos agregados");
        } else {
            for (Telefono telefono : usuario.getListaTelefonos()) {
                System.out.println(telefono.toString());
            }
        }
    }

    public void verDireccion(Telefono telefono) {
        System.out.println("Datos del Cliente: " + telefono);
    }

    public void verTelefonos(Map<Integer, Telefono> telefonos) {
        for (Map.Entry<Integer, Telefono> telefono2 : telefonos.entrySet()) {
            int cod = telefono2.getKey();
            Telefono tele = telefono2.getValue();
            System.out.println("Clave telefono: " + cod + "\nInformación del "
                    + "telefono: " + tele.toString());
            
        }
    }

}
