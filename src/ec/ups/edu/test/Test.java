/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.test;

import ec.ups.edu.controlador.ControladorTelefono;
import ec.ups.edu.controlador.ControladorUsuario;
import es.ups.edu.modelo.Usuario;
import es.ups.edu.vista.VistaTelefono;
import es.ups.edu.vista.VistaUsuario;
import es.ups.edu.dao.TelefonoDAOImpl;
import es.ups.edu.dao.UsuarioDAOImpl;

/**
 *
 * @author Adolfo
 */
public class Test {

    public static void main(String[] args) {

        // vista
        VistaUsuario vistaU = new VistaUsuario();
        VistaTelefono vistaT = new VistaTelefono();
        //DAOs
        UsuarioDAOImpl clienteDAO = new UsuarioDAOImpl();
        TelefonoDAOImpl telefonoDAO = new TelefonoDAOImpl();
        // controlador
        ControladorUsuario controladorUsuario = new ControladorUsuario(vistaU, clienteDAO, vistaT, telefonoDAO);
        ControladorTelefono controladorTelefono = new ControladorTelefono(vistaT, telefonoDAO);

        int opcionMenu = 0;
        do {
            //se llama al menu
           opcionMenu = vistaU.menu();

           switch (opcionMenu) {
                case 1:
                    // guarda un cliente a traves del controlador        
                    controladorUsuario.registrar();
                    break;

               case 2:
                   //para iniciar sesion
                    Usuario usuario = controladorUsuario.iniciarSesion();
                    // siel usuario existe
                    if (usuario != null) {
                        int opcion = 0;
                        do {
                           opcion = vistaT.menuEditarTelefonoUsuario();
                            switch (opcion) {
                                case 1:
                                    //para agregar un telefono
                                    controladorTelefono.registrar();
                                    boolean contiene = controladorUsuario.verCliente();
                                    if (contiene == true) {
                                        controladorUsuario.agregarDireccion();
                                    }
                                    break;

                                case 2:
                                    //para editar telefono
                                    controladorTelefono.actualizar();
                                    boolean contiene2 = controladorUsuario.verCliente();
                                    if (contiene2 == true) {
                                        controladorUsuario.actualizarTelefono();
                                    }
                                    break;

                               case 3:
                                    //para eliminar un telefono
                                    controladorTelefono.eliminar();
                                    boolean contiene3 = controladorUsuario.verCliente();
                                    if (contiene3) {
                                        controladorUsuario.eliminarTelefono();
                                    }
                                   break;

                                case 4:
                                    //para salir
                                    controladorUsuario.cerrarSesion();
                                    break;

                                default:
                                    controladorUsuario.numeroErroneo();
                                    break;

                            }
                        } while (opcion != 4);
                    }

                    break;
                case 3:
                    //paraimprimir telefonos de un usuario
                    controladorUsuario.buscarTelefonos();
                    break;

                case 4:
                    //para imprimir un usuario
                    controladorUsuario.imprimirUsuario();
                    break;

                case 5:
                    //para ver todos los usuarios
                    controladorUsuario.verClientes();
                    break;

                case 6:
                    //para ver todos los telefonos
                    controladorTelefono.verDirecciones();
                    break;

                case 7:

                    controladorUsuario.salir();
                    break;

                default:

                    controladorUsuario.numeroErroneo();
                    break;

            }

        } while (opcionMenu != 7);
       
    }
}