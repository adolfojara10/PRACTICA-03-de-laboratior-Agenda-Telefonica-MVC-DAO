# PRACTICA-03-de-laboratior-Agenda-Telefonica-MVC-DAO

## Informe de la Practica de Laboratorio
*Desarrollo de una aplicación en Java utilizando los patrones diseño
de software MVC y DAO.*

**Carrera:** Computación.

**Objetivos:**
• Utilizar el patrón MVC para el desarrollo de aplicaciones de software

### Version de las Herramientas:

- IDE Apache NetBeans 11.3

- Java = JDK 14

**1. Crear un repositorio en GitHub con el nombre “Práctica de laboratorio 03: Agenda Telefónica con MVC yDAO”.**

A continuación, se presentara el inicio de un repositorio en GitHub:

![Initial commit](https://github.com/adolfojara10/ImagesGitHub/blob/master/1.png)

**2. Desarrollar una aplicación en Java para gestionar una agenda telefónica según los requerimientos planteados en las instrucciones de la práctica.**

Para comenzar esta práctica, primero se creo el proyecto, los paquetes y sus clases:

![creacionProyecto](https://github.com/adolfojara10/ImagesGitHub/blob/master/Paquetes%2Cclases.png)

Luego en la clase Usuario, se crearon sus atributos y metodos. A continuación, su link del pseudocodigo:

![Usuario](https://github.com/adolfojara10/PRACTICA-03-de-laboratior-Agenda-Telefonica-MVC-DAO/blob/master/src/es/ups/edu/modelo/Usuario.java)

Luego se procedió con la clase Telefono. A continuación su link del pseudocodigo:

![Telefono](https://github.com/adolfojara10/PRACTICA-03-de-laboratior-Agenda-Telefonica-MVC-DAO/blob/master/src/es/ups/edu/modelo/Telefono.java)

Una vez creadas las dos clases del paquete modelo, se procedio con el paque idao.

Primero se creó la Inteface IUsuarioDAO. A continuación, su link de pseudocodigo:

![IUsuarioDAO](https://github.com/adolfojara10/PRACTICA-03-de-laboratior-Agenda-Telefonica-MVC-DAO/blob/master/src/ec/ups/edu/idao/IUsuarioDAO.java)

Luego, se hizo lo mismo con la Interface ITelefonoDAO. A continuación, su link de pseudocodigo:

![ITelefonoDAO](https://github.com/adolfojara10/PRACTICA-03-de-laboratior-Agenda-Telefonica-MVC-DAO/blob/master/src/ec/ups/edu/idao/ITelefonoDAO.java)

Una vez terminado esto, se procedio a implementar estas dos interfaces en el paquete dao.

A continuación, el link del peudocodigo del UsuarioDAOImpl:

![UsuarioDAOImpl](https://github.com/adolfojara10/PRACTICA-03-de-laboratior-Agenda-Telefonica-MVC-DAO/blob/master/src/es/ups/edu/dao/UsuarioDAOImpl.java)

A continuación, el link del pseudocodigo de TelefonoDAOImpl:

![TelefonoDAOImpl](https://github.com/adolfojara10/PRACTICA-03-de-laboratior-Agenda-Telefonica-MVC-DAO/blob/master/src/es/ups/edu/dao/TelefonoDAOImpl.java)

Una vez terminada con las implementaciones del código, procedemos al paquete vista.

A continuación, el link del pseudocodigo de VistaUsuario:

![VistaUsuario](https://github.com/adolfojara10/PRACTICA-03-de-laboratior-Agenda-Telefonica-MVC-DAO/blob/master/src/es/ups/edu/vista/VistaUsuario.java)

A continuación, el link del pseudocodigo de VistaTelefono:

![VistaTelefono](https://github.com/adolfojara10/PRACTICA-03-de-laboratior-Agenda-Telefonica-MVC-DAO/blob/master/src/es/ups/edu/vista/VistaTelefono.java)

Una vez terminado con el paquete vista, procedemos al paquete controlador.

A continuación, el link del pseudocodigo de ControladorUsuario:

![ControladorUsuario](https://github.com/adolfojara10/PRACTICA-03-de-laboratior-Agenda-Telefonica-MVC-DAO/blob/master/src/ec/ups/edu/controlador/ControladorUsuario.java)

A continuación, el link del pseudocodigo de ControladorTelefono:

![ControladorTelefono](https://github.com/adolfojara10/PRACTICA-03-de-laboratior-Agenda-Telefonica-MVC-DAO/blob/master/src/ec/ups/edu/controlador/ControladorTelefono.java)

Una vez terminado con este paquete, procedemos al paquete test. 

A continuación,el link del pseudocodigo de la clase Test:

![Test](https://github.com/adolfojara10/PRACTICA-03-de-laboratior-Agenda-Telefonica-MVC-DAO/blob/master/src/ec/ups/edu/test/Test.java)


**3. Realizar varios commits en la herramienta GitHub que demuestren el desarrollo de la aplicación desde principio a fin.**

Fotos de los commits. En orden desde el último commit hasta el primer commit:

![commit](https://github.com/adolfojara10/ImagesGitHub/blob/master/commit1.png)

![commit](https://github.com/adolfojara10/ImagesGitHub/blob/master/commit2.png)


**4. Generar el informe de la práctica con el desarrollo de cada uno de los puntos descritos anteriormente.**

Lo primero que nos aparece al iniciar el programa es el menu:

![menu](https://github.com/adolfojara10/ImagesGitHub/blob/master/menu.png)

Procedemos a crear dos usuarios:

![usuarios](https://github.com/adolfojara10/ImagesGitHub/blob/master/usuarios.png)

Una vez creado dos usuarios, iniciamos sesión con uno de ellos:

![inicioSesion](https://github.com/adolfojara10/ImagesGitHub/blob/master/inicioSesion.png)

Nos aparece el submenú para los teléfonos, vamos a crear 2 teléfonos:

![telefonos](https://github.com/adolfojara10/ImagesGitHub/blob/master/creacionTelefonos.png)

Ahora procedemos a editar el primer teléfono:

![edicion](https://github.com/adolfojara10/ImagesGitHub/blob/master/edicionTelefonos.png)

Ahora procedemos a eliminar el segundo teléfono:

![eliminarTelefono](https://github.com/adolfojara10/ImagesGitHub/blob/master/eliminarTelefono.png)

Por último, cerramos sesión:

![cerrarSesion](https://github.com/adolfojara10/ImagesGitHub/blob/master/cerrarSesion.png)

Ahora imprimimos los teléfonos del primer y segundo usuario mediante su cedula:

![impresion telefonos](https://github.com/adolfojara10/ImagesGitHub/blob/master/impresionTelefonos.png)

Ahora buscamos al primer usuario mediante el correo: 

![busquedaUsuario](https://github.com/adolfojara10/ImagesGitHub/blob/master/busquedaUsuario.png)

Ahora imprimimos todos los usuarios:

![impresionUsuarios](https://github.com/adolfojara10/ImagesGitHub/blob/master/impresionUsuarios.png)

Ahora procedemos a imprimir todos los teléfonos del sistema:

![telefonoSistema](https://github.com/adolfojara10/ImagesGitHub/blob/master/impresionTodosTelefonos.png)

Por último, cerramos sesión:

![finPrograma](https://github.com/adolfojara10/ImagesGitHub/blob/master/finPrograma.png)

**5. Implementar el README del repositorio del proyecto con la misma información del informe de la práctica (incluidas las imágenes y versiones de las herramientas).

- IDE Apache NetBeans 11.3

![NetBeans](https://github.com/adolfojara10/ImagesGitHub/blob/master/netbeans.png)

- Java = JDK 14

**6. Subir al AVAC el informe del proyecto en formato *.pdf. El informe debe contar con conclusiones apropiadas y la firma de cada estudiante**


## Resultados Obtenidos

•	Diseñar e implementar una aplicación con base a la arquitectura de MVC y DAO, es decir aplicar las correctas relaciones entre clases y paquetes, para simular a una base de datos.

•	Implementación de diccionarios y listas.

•	Uso correcto de un repositorio en la herramienta de GitHub.

•	Implementación de la herramienta GitHub para crear varios “commits” y varios “push” para guardar nuestro proyecto remotamente.

•	Uso correcto de la herramienta README en Github. En este se duplico el informe de esta práctica.


## Conclusiones

•	Esta practica ha sido muy beneficiosa para un entendimiento mucho más profundo de los patrones de arquitectura de MVC y DAO. Además, esta practica nos ayuda para entender las relaciones que deben existir entre clases y paquetes de esta arquitectura.

•	La puesta en practica de diccionarios. Es una herramienta muy útil para almacenar muchas cosas, ya que muchos sistemas en la vida real utilizan códigos para cada objeto, y por lo tanto hace más rápido que se encuentren estos objetos.

•	La aplicación de la herramienta GitHub en este proyecto. Es una herramienta que nos ayuda a subir nuestro código a un lugar remoto de almacenamiento y así poder compartirlo rápidamente con personas. Además, nos permite ver los cambios que se han realizado a lo largo de nuestro proyecto. Por esta vez no trabajamos con “branches”, pero es la primera vez que uso esta herramienta y estuvo muy bien para familiarizarnos con ella.

•	En mi opinión, me gusto que el menú haya quedado a disposición nuestra para la realización de este trabajo. Ya que así tenemos que utilizar más nuestra imaginación para implementar un menú completo basado en nuestro juicio.


## Recomendaciones 

•	En conclusión, no tengo ninguna recomendación, ya que la descripción de la practica estaba clara y además si tenemos alguna duda, el docente está abierto a solventar nuestras dudas de manera clara.

## Nombre del Estudiante

Adolfo Sebastián Jara Gavilanes

## Firma del estudiante

![firmaEstudiante](https://github.com/adolfojara10/ImagesGitHub/blob/master/firma%20electronica.jpg)















