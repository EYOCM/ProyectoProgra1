/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication16;

import java.util.ArrayList;

/**
 *
 * @author Nitro
 */
public class BBDMemoria extends BBDAbstracto {

    private ArrayList<Libro> Libreria;

    public BBDMemoria() {
        Libreria = new ArrayList<Libro>();
    }

    public void Guardar(Libro LibroAGuardar) {
        Libreria.add(LibroAGuardar);
        System.out.println("El libro ha sido guardado");
        System.out.println(Libreria.get(Libreria.size()-1).getTitulo());
       
    }

    public void Modificar(Libro LibroAModificar, String ValorAModificar) {
        int IndiceLibro = -1;
        
        for (int indice = 0; indice < Libreria.size() ; indice++) {
            if (Libreria.get(indice).getIsbn().contains(LibroAModificar.getIsbn())) {
                IndiceLibro = indice; // retorna el índice de la llave de búsqueda
            }
        }
        
        
        System.out.println(IndiceLibro);
        if(IndiceLibro >= 0){
            Libreria.set(IndiceLibro, LibroAModificar);
            System.out.println("El Libro ha sido modificado");
        }else{
            System.out.println("El Libro no ha sido modificado");
    }
    }

    @Override
    public void Leer() {
        System.out.println("Guardar");
    }

    @Override
    public void Borrar() {
        System.out.println("Guardar");
    }

}
