/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenjava;

/**
 *
 * @author alexc
 */
public class Dato {
    private String carp;
    private String tipo;
    private int contador=0;

    public Dato() {
    }

    public Dato(String carp, String tipo) {
        this.carp = carp;
        this.tipo = tipo;
        contador=0;
    }
    public String getCarp() {
        return carp;
    }

    public void setCarp(String carp) {
        this.carp = carp;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
    
    public void sumar(){
        contador++;
    }

    @Override
    public String toString() {
        return "Hay " + contador+" de tipo: " + tipo + '\n';
    }
    
    
    
}

