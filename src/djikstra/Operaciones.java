
package djikstra;

import guidjisktra.Enlace;
import java.util.ArrayList;


public class Operaciones {
    public static int INF = 1000000000;
    public void iniciarNodos(ArrayList<Nodo> nodos, ArrayList<Enlace> enlaces){
        for(Enlace e : enlaces)
            nodos.add(new Nodo(e.getNodo1(),e.getNodo2(),e.getPeso()));
    }
    
    public Tabla djkistra(Grafo grafo, String nodoInicio){
        ArrayList<Nodo> nodos = grafo.getNodos();
        ArrayList<EntradaTabla> entradas = new ArrayList<>();
        //Agregó los nombres a la tabla
        setNombreNodos(nodos, entradas);
        //Establezco valores inicio al nodo de inicio
        setValorInicio(entradas,nodoInicio);
        while(!nodoInicio.equalsIgnoreCase("null"))
        {
            int pesoNodoInicio = getPesoNodoInicio(entradas, nodoInicio);
            ArrayList<AuxEntrada> auxEntradas = 
                buscarNodosAdyacentes(nodos,nodoInicio, pesoNodoInicio, 0);
            actualizarEntradas(entradas, auxEntradas);
            nodoInicio = nodoMenorValor(entradas);
            setValores(entradas, nodoInicio);
        }
        return new Tabla(entradas);
    }
    
    public ArrayList<String> caminoMasCorto(Grafo grafo, Tabla tabla ,String nodoInicio ,String nodoFinal){
        ArrayList<String> camino = new ArrayList<>();
        camino.add(nodoFinal);
        ArrayList<Nodo> nodos = grafo.getNodos();
        ArrayList<EntradaTabla> entradas = tabla.getEntradas();
        int pesoNodoFinal = getPesoNodoInicio(entradas, nodoFinal);
        ArrayList<AuxEntrada> auxEntradas = 
                buscarNodosAdyacentes(nodos,nodoFinal, pesoNodoFinal, 1);
        cambiarValoresCaminoCorto(auxEntradas);
        ArrayList<AuxEntrada> auxiliar = new ArrayList<>(); 
        while(!camino.get(camino.size()-1).equalsIgnoreCase(nodoInicio)){
            for(AuxEntrada e : auxEntradas)
                if(coincideValor(e,entradas) && !estaEnCamino(e.getNombreNodo(),camino))
                    auxiliar.add(new AuxEntrada(e.getNombreNodo(),e.getPeso()));
            if(auxiliar.size() == 1)
                camino.add(auxiliar.get(0).getNombreNodo());
            else
                camino.add(entradaMenorValor(auxiliar));
            nodoFinal = camino.get(camino.size()-1);
            pesoNodoFinal = getPesoNodoInicio(entradas, nodoFinal);
            auxEntradas = 
                buscarNodosAdyacentes(nodos,nodoFinal, pesoNodoFinal, 1);
            cambiarValoresCaminoCorto(auxEntradas);
            auxiliar.clear();
        }
        return camino;
    }
    
    public String entradaMenorValor(ArrayList<AuxEntrada> auxiliar){
        AuxEntrada menorValor = auxiliar.get(0);
        for(AuxEntrada a : auxiliar)
            if(a.getPeso() < menorValor.getPeso())
                menorValor = a;    
        return menorValor.getNombreNodo();
    }
        
    public boolean estaEnCamino(String nodo, ArrayList<String> camino){
        for(String e : camino)
            if(e.equalsIgnoreCase(nodo))
                return true;
        return false;
    }
    
        
                
        /*for(AuxEntrada a : auxEntradas){
            System.out.println("\n" + a.getNombreNodo() + " " + a.getPeso());
        }*/
       
    public boolean coincideValor(AuxEntrada e, ArrayList<EntradaTabla> entradas){
        for (EntradaTabla e1 : entradas)
            if(e1.getNodo().equalsIgnoreCase(e.getNombreNodo()) && e.getPeso() == e1.getFin())
                return true;
        return false;
    }
    
    
    
    public void cambiarValoresCaminoCorto(ArrayList<AuxEntrada> auxEntradas){
        for(AuxEntrada e : auxEntradas)
            e.setPeso(e.getPeso() * (-1));
    }
    
    public void imprimeTabla(ArrayList<EntradaTabla> entradas){
        for(EntradaTabla t : entradas)
            System.out.println(t.getNodo() + " " + t.getInicio() + " " 
                    + t.getFin() + " " + t.isVisitado());
    }
        
    /*Imprimir entradas debug
    for(EntradaTabla t : entradas){
            System.out.println(t.getNodo() + " " + t.getInicio() + " " + t.getFin());
        }*/
    
    public void setValores(ArrayList<EntradaTabla> entradas, String nodoInicio){
        for(EntradaTabla e : entradas){
            if(e.getNodo().equalsIgnoreCase(nodoInicio)){
                e.setInicio(e.getFin());
                e.setVisitado(true);
            }
        }
    }
    
    //Encontrar el nodo con menor valore
    public String nodoMenorValor(ArrayList<EntradaTabla> entradas){
        EntradaTabla entrada = noEsVisitada(entradas);
        for (EntradaTabla e: entradas){
            if(e.getFin() < entrada.getFin() && e.isVisitado() != true )
                entrada = e;    
        }
        return entrada.getNodo();
    }
    
    public EntradaTabla noEsVisitada(ArrayList<EntradaTabla> entradas){
        for(EntradaTabla e : entradas){
            if(e.isVisitado() == false)
                return e;
        }
        return new EntradaTabla("null",INF,INF,false);
    }
    
    public void actualizarEntradas(ArrayList<EntradaTabla> entradas, 
            ArrayList<AuxEntrada> auxEntradas){
        for(int i = 0; i < auxEntradas.size(); i++){
            String nodo = auxEntradas.get(i).getNombreNodo();
            int peso  = auxEntradas.get(i).getPeso();
            for(int j = 0; j < entradas.size();j++){
                EntradaTabla entrada = entradas.get(j);
                if(entrada.getNodo().equalsIgnoreCase(nodo) 
                        && (entrada.getFin() == INF 
                        || peso < entrada.getFin())){
                    entrada.setFin(peso);
                }
            }
        }
    }
    
    public int getPesoNodoInicio(ArrayList<EntradaTabla> entradas, 
            String nodoInicio){
        for(EntradaTabla e : entradas)
            if(e.getNodo().equalsIgnoreCase(nodoInicio))
                return e.getInicio();
        return 0;
    }
    
    
    
    //Busca nodos en función a un nodo dado
    public ArrayList<AuxEntrada> buscarNodosAdyacentes(ArrayList<Nodo> nodos, 
            String nodo, int pesoNodoInicio, int operacion){
        if (operacion == 1)
            pesoNodoInicio = (pesoNodoInicio)*-1;
        ArrayList<AuxEntrada> auxEntradas = new ArrayList<>();
        for(int i =0 ; i < nodos.size(); i++){
            Nodo nodoAux = nodos.get(i);
            if(nodoAux.getPrimerNodo().equalsIgnoreCase(nodo))
                auxEntradas.add(new AuxEntrada(nodoAux.getSegundoNodo(),
                        nodoAux.getPeso()+pesoNodoInicio));
            if(nodoAux.getSegundoNodo().equalsIgnoreCase(nodo))
                auxEntradas.add(new AuxEntrada(nodoAux.getPrimerNodo(),
                        nodoAux.getPeso()+pesoNodoInicio));
        }
        return auxEntradas;
    }
    
    public void setNombreNodos(ArrayList<Nodo> nodos, 
            ArrayList<EntradaTabla> entradas){
        for(int i = 0; i < nodos.size(); i++){
            String elemento = nodos.get(i).getPrimerNodo();
            String elemento1 = nodos.get(i).getSegundoNodo();
            //Barrida de la primera columna de nombres de nodos
            if(!existeElemento(entradas, elemento))
                entradas.add(new EntradaTabla(elemento,INF,INF, false));
            //Barrida de la segunda columna de nombres de nodos
            if(!existeElemento(entradas, elemento1))
                entradas.add(new EntradaTabla(elemento1,INF,INF, false));
        }
    }
    
    public void setValorInicio(ArrayList<EntradaTabla> entradas, 
            String nodoInicio){
        for(EntradaTabla t : entradas)
            if (t.getNodo().equalsIgnoreCase(nodoInicio)){
                t.setInicio(0);
                t.setFin(0);
                t.setVisitado(true);
                return;
            }       
    }
    
    public boolean existeElemento(ArrayList<EntradaTabla> entradas, 
            String elemento){
        for(int i = 0; i < entradas.size(); i++){
            if(entradas.get(i).getNodo().equalsIgnoreCase(elemento))
                return true;
        }
        return false;
    }
}
