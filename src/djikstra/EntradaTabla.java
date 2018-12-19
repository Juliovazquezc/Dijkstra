
package djikstra;


public class EntradaTabla {
    private String nodo;
    private int inicio;
    private int fin;
    private boolean visitado;
    
    public EntradaTabla(String nodo, int inicio, int fin, boolean visitado){
        this.nodo = nodo;
        this.inicio = inicio;
        this.fin = fin;
        this.visitado = visitado;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public String getNodo() {
        return nodo;
    }

    public void setNodo(String nodo) {
        this.nodo = nodo;
    }

    public int getInicio() {
        return inicio;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public int getFin() {
        return fin;
    }

    public void setFin(int fin) {
        this.fin = fin;
    }
}
