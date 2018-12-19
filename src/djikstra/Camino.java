/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package djikstra;

import java.util.ArrayList;

/**
 *
 * @author JulioCésar
 */
public class Camino {
    ArrayList<String> camino;

    public ArrayList<String> getCamino() {
        return camino;
    }

    public void setCamino(ArrayList<String> camino) {
        this.camino = camino;
    }
    
    public Camino(ArrayList<String> camino){
        this.camino = camino;
    }
}
