package AST;

import TiposScrabble.Scrabble;
import java.util.List;
/** Interfaz Component para implementar un patron de
 * diseño Composite en un AST
 */
public interface AST {
    /**
     * Método devuelve una lista. Sí viene de un Leaf, entrega Lista de
     * Scrabbles, y si es Composite, devuelve una lista de
     * listas de Scrabbles.
     */
    List getList();
}
