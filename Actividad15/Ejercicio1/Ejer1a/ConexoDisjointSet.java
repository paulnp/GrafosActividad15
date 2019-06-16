package Ejer1a;
import java.util.ArrayList;

import disjointSet.EDDisjointSetCH;

import grafo.*;


public class ConexoDisjointSet{

    private EDDisjointSetCH DS;
    private ArrayList<ArcoED> arcos;
    private ArrayList<Nodo> nodos;

    public ConexoDisjointSet(EDGrafoListaAdyacencias g){
    	nodos = g.getNodos();
    	arcos = g.getArcos();
        DS = new EDDisjointSetCH();
    }
    
    /**
     * Metodo que se encarga de verificar si el grafo ingresado es conexo o no
     * por medio de un Disjoint-Set
     * @return si el grafo es conexo o no
     */
    public boolean checkConexo(){
       
        for(Nodo n: nodos) {
        	DS.makeSet(n);
        }
        for(ArcoED e: arcos){
            Nodo v1 = e.getSource();
            Nodo v2 = e.getTarget();
            if(! (DS.findSet(v1).equals(DS.findSet(v2)) ));
                DS.union(v1,v2);
        }
        
        return DS.size()==1;
    }
    
}