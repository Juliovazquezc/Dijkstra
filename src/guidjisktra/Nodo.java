
package guidjisktra;

public class Nodo {
    private String nombre;
    private int nodoX;
    private int nodoY;
    
    public Nodo(String nombre, int nodoX, int nodoY){
        this.nombre = nombre;
        this.nodoX = nodoX;
        this.nodoY = nodoY;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNodoX() {
        return nodoX;
    }

    public void setNodoX(int nodoX) {
        this.nodoX = nodoX;
    }

    public int getNodoY() {
        return nodoY;
    }

    public void setNodoY(int nodoY) {
        this.nodoY = nodoY;
    }
}
