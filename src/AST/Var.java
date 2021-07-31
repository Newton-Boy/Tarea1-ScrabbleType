package AST;
import TiposScrabble.Scrabble;

import java.util.ArrayList;
import java.util.List;
/**
 * Leaf del patron de diseño Composite
 */
public class Var implements AST{
    private List<Scrabble> Lista=new ArrayList<>();
    /**
     * Constructor de Var. Genera una lista de Scrabbles con 2 Nodos
     * @param sc1,sc2
     */
    public Var(Scrabble sc1,Scrabble sc2){
        Lista.add(sc1);
        Lista.add(sc2);
    }
    @Override
    public List<Scrabble> getList() {
        return Lista;
    }
    /**
     * Retorna un Scrabble que es un Nodo de la Lista Scrabble
     * @param i
     */
    public Scrabble Nodo(int i){
        return Lista.get(i);
    }
}
