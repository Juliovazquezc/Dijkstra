
package djikstra;

import java.util.ArrayList;

public class Tabla {
    private ArrayList<EntradaTabla> entradas;

    
    
    public Tabla(ArrayList<EntradaTabla> entradas){
        this.entradas = entradas;
    }
    
    public ArrayList<EntradaTabla> getEntradas() {
        return entradas;
    }
}
