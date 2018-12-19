
package djikstra;

import java.util.ArrayList;


public class Grafo {
    private ArrayList<Nodo> nodos;
    public Grafo(ArrayList<Nodo> nodos){
        this.nodos = nodos;
    }
    
    public ArrayList<Nodo> getNodos() {
        return nodos;
    }
}
