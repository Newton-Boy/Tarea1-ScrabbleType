package Visitors;

import TiposScrabble.Number.BinaryScrabble;
import TiposScrabble.Number.IntScrabble;
import TiposScrabble.LogicScrabble;
import TiposScrabble.Number.FloatScrabble;
import TiposScrabble.Scrabble;
import TiposScrabble.StringScrabble;

/**
 * Clase visitOperador da forma los métodos que deben de extender
 * el resto de los "visitantes" por medio de un
 * Double Dispatch
 */
public class visitOperador {
    /**
     * Double Dispatch del patron visitante para los StringScrabble
     * @param Sc1,Sc2
     */
    public void visitStringScrabble(StringScrabble Sc1, Scrabble Sc2){}
    /**
     * Double Dispatch del patron visitante para los FloatScrabble
     * @param Sc1,Sc2
     */
    public void visitFloatScrabble(FloatScrabble Sc1, Scrabble Sc2){}
    /**
     * Double Dispatch del patron visitante para los IntScrabble
     * @param Sc1,Sc2
     */
    public void visitIntScrabble(IntScrabble Sc1, Scrabble Sc2){}
    /**
     * Double Dispatch del patron visitante para los BinaryScrabble
     * @param Sc1,Sc2
     */
    public void visitBinaryScrabble(BinaryScrabble Sc1, Scrabble Sc2){}
    /**
     * Double Dispatch del patron visitante para los LogicScrabble
     * @param Sc1,Sc2
     */
    public void visitBoolScrabble(LogicScrabble Sc1, Scrabble Sc2){}
    /**
     * getResult entrega el resultado de la operación visitante
     * realizada en forma de un Scrabble.
     */
    public Scrabble getResult(){
        return null;
    }
}
