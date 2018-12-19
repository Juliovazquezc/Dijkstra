
package djikstra;


public class Nodo {
     private String primerNodo;
     private String segundoNodo;
     private int peso;
     
     public Nodo(String primerNodo, String segundoNodo, int peso){
         this.primerNodo = primerNodo;
         this.segundoNodo = segundoNodo;
         this.peso = peso;
     }

    public String getPrimerNodo() {
        return primerNodo;
    }

    public void setPrimerNodo(String primerNodo) {
        this.primerNodo = primerNodo;
    }

    public String getSegundoNodo() {
        return segundoNodo;
    }

    public void setSegundoNodo(String segundoNodo) {
        this.segundoNodo = segundoNodo;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
}
