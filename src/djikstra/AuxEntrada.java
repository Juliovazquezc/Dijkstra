/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package djikstra;

/**
 *
 * @author JulioCésar
 */
public class AuxEntrada {
    private String nombreNodo;
    private int peso;
    
    public AuxEntrada(String nombreNodo, int peso){
        this.nombreNodo = nombreNodo;
        this.peso = peso;
    }
    
    public String getNombreNodo() {
        return nombreNodo;
    }

    public void setNombreNodo(String nombreNodo) {
        this.nombreNodo = nombreNodo;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
}
