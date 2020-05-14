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
import java.util.*;

/**
 *
 * @author Adolfo
 */
public class TelefonoDAOImpl implements ITelefonoDAO {

    private Map<Integer, Telefono> listaTelefonos;

    public TelefonoDAOImpl() {
        listaTelefonos = new HashMap<>();
    }

    @Override
    public void create(Telefono telefono) {
        listaTelefonos.put(telefono.getCodigo(),telefono);
    }

    @Override
    public Telefono read(int id) {
        for (Map.Entry<Integer, Telefono> telefono : listaTelefonos.entrySet()) {
            int cod = telefono.getKey();
            if (cod == id) {
                Telefono tele = listaTelefonos.get(cod);
                return tele;
            }
        }
        return null;
    }

    @Override
    public void update(Telefono telefono) {
        for (Map.Entry<Integer, Telefono> telefono2 : listaTelefonos.entrySet()) {
            int cod = telefono2.getKey();
            if (cod == telefono.getCodigo()) {
                listaTelefonos.replace(cod, telefono);
                break;
            }
        }

    }

    @Override
    public void delete(Telefono telefono) {
        for (Map.Entry<Integer, Telefono> telefono2 : listaTelefonos.entrySet()) {
            int cod = telefono2.getKey();
            if (cod == telefono.getCodigo()) {
                listaTelefonos.remove(telefono.getCodigo());
                break;
            }
        }
    }

    @Override
    public Map<Integer, Telefono> findAll() {
        return listaTelefonos;
    }
}
