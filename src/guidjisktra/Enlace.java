/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guidjisktra;

/**
 *
 * @author JulioCésar
 */
public class Enlace {
    private String nodo1;
    private String nodo2;
    private int nodo1X;
    private int nodo1Y;
    private int nodo2X;
    private int nodo2Y;
    private int peso;

    public Enlace(String nodo1, String nodo2, int nodo1X, int nodo1Y, int nodo2X, int nodo2Y, int peso) {
        this.nodo1 = nodo1;
        this.nodo2 = nodo2;
        this.nodo1X = nodo1X;
        this.nodo1Y = nodo1Y;
        this.nodo2X = nodo2X;
        this.nodo2Y = nodo2Y;
        this.peso = peso;
    }
    
    public String getNodo1() {
        return nodo1;
    }

    public void setNodo1(String nodo1) {
        this.nodo1 = nodo1;
    }

    public String getNodo2() {
        return nodo2;
    }

    public void setNodo2(String nodo2) {
        this.nodo2 = nodo2;
    }

    public int getNodo1X() {
        return nodo1X;
    }

    public void setNodo1X(int nodo1X) {
        this.nodo1X = nodo1X;
    }

    public int getNodo1Y() {
        return nodo1Y;
    }

    public void setNodo1Y(int nodo1Y) {
        this.nodo1Y = nodo1Y;
    }

    public int getNodo2X() {
        return nodo2X;
    }

    public void setNodo2X(int nodo2X) {
        this.nodo2X = nodo2X;
    }

    public int getNodo2Y() {
        return nodo2Y;
    }

    public void setNodo2Y(int nodo2Y) {
        this.nodo2Y = nodo2Y;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
    
    
}
