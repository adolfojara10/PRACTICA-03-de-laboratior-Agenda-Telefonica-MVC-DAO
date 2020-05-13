/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ups.edu.dao;

import ec.ups.edu.idao.ITelefonoDAO;
import es.ups.edu.modelo.Telefono;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Adolfo
 */
public class TelefonoDAOImpl implements ITelefonoDAO {

    private List<Telefono> listaTelefonos;

    public TelefonoDAOImpl() {
        listaTelefonos = new ArrayList<>();
    }

    @Override
    public void create(Telefono telefono) {
        listaTelefonos.add(telefono);
    }

    @Override
    public Telefono read(int id) {
        for (Telefono telefono : listaTelefonos) {
            if (telefono.getCodigo() == id) {
                return telefono;
            }
        }
        return null;
    }

    @Override
    public void update(Telefono telefono) {
        for (int i = 0; i < listaTelefonos.size(); i++) {
            Telefono c = listaTelefonos.get(i);
            if (c.getCodigo() == telefono.getCodigo()) {
                listaTelefonos.set(i, telefono);
                break;
            }
        }

    }

    @Override
    public void delete(Telefono telefono) {
        Iterator<Telefono> it = listaTelefonos.iterator();
        while (it.hasNext()) {
            Telefono d = it.next();
            if (d.getCodigo() == telefono.getCodigo()) {
                it.remove();
                break;
            }
        }
    }

    @Override
    public List<Telefono> findAll() {
        return listaTelefonos;
    }
}
