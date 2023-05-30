/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenjava;

/**
 *
 * @author alexc
 */
public class Argumento {
    private String carpeta;
    private String tipo;
    private String titulo;

    @Override
    public String toString() {
        return "{"+"carpeta: "+carpeta + " tipo: " + tipo + ", titulo: " + titulo + '}'+"\n";
    }

    public String getCarpeta() {
        return carpeta;
    }

    public void setCarpeta(String carpeta) {
        this.carpeta = carpeta;
    }

    public Argumento() {
        this.carpeta="";
        this.tipo = "";
        this.titulo = "";
    }

    public Argumento(String carpeta, String tipo, String titulo) {
        this.carpeta=carpeta;
        this.tipo = tipo;
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
}
