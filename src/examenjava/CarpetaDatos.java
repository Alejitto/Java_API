/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenjava;

import java.util.ArrayList;

/**
 *
 * @author alexc
 */
public class CarpetaDatos {
    private int nElementos;
    private String nombre;
    private ArrayList<Dato> elemento=new ArrayList<>();

    public CarpetaDatos() {
    }

    public CarpetaDatos(int nElementos, String nombre) {
        this.nElementos = nElementos;
        this.nombre = nombre;
    }

    public int getnElementos() {
        return nElementos;
    }

    public void setnElementos(int nElementos) {
        this.nElementos = nElementos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Dato> getElemento() {
        return elemento;
    }

    public void setElemento(ArrayList<Dato> elemento) {
        this.elemento = elemento;
    }

    @Override
    public String toString() {
        return nElementos + " Widgets "+ "en la carpeta: " + nombre + "\n" + elemento.toString();
    }
    
    
    
    public void addDato(Dato agg){
        boolean band=false;
        int i;
        if(elemento.isEmpty()){
            agg.sumar();
            elemento.add(agg);
        }
        else{
            for (i = 0; i < elemento.size(); i++) {
                if(elemento.get(i).getTipo().contains(agg.getTipo())){
                    band=true;
                    //elemento.get(i).sumar();
                    break;
                }}
            if(band)
                elemento.get(i).sumar();
            else{
               agg.sumar();
               elemento.add(agg);   
            }    
        }
    }
    
}
