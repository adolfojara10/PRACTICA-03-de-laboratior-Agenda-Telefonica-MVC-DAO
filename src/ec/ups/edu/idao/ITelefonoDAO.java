/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.idao;

import es.ups.edu.modelo.Telefono;
import java.util.*;

/**
 * inteface ITelefonoDAO.
 * 
 * encargado de crear los metodos abstarctos para implementar en dao
 * @author Adolfo
 */
public interface ITelefonoDAO {
    
    /**
     * metodo create.
     * 
     * crea un telelefono y lo manda al array de telefonos
     * @param telefono 
     */
    public void create(Telefono telefono);
    
    /**
     * metodo read.
     * 
     * busca un telefono por su codigo y lo devuelve
     * @param id
     * @return Telefono
     */
    public Telefono read(int id);
    
    /**
     * metodo update.
     * 
     * metodo encargado de actualizar un telefono ya creado
     * @param telefono 
     */
    public void update(Telefono telefono);
    
    /**
     * metodo delete.
     * 
     * metodo encargado de eliminar un telefono
     * @param telefono 
     */
    public void delete(Telefono telefono);   
    
    /**
     * metodo findAll.
     * 
     * metodo encargado de devolver los telefonos del sistems
     * @return List
     */
    public List<Telefono> findAll();
}