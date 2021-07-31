package Visitors;

import Factories.*;
import TiposScrabble.Number.BinaryScrabble;
import TiposScrabble.BoolScrabble;
import TiposScrabble.Operadores.IntBinaryScrabble;
import TiposScrabble.Number.IntScrabble;
import TiposScrabble.Number.FloatScrabble;
import TiposScrabble.Number.NumberScrabble;
import TiposScrabble.Scrabble;
import TiposScrabble.StringScrabble;
/**
 * Operador visitante Producto. Realiza una resta entre Scrabble retornando un
 * resultado adecuado en cada situación (Usando el cuadro 2 como referente)
 */
public class Product extends visitOperador{
    private NumberScrabble Sc;
    public void visitStringScrabble(StringScrabble Sc1, Scrabble Sc2){
        Sc=null;
    }
    public void visitFloatScrabble(FloatScrabble Sc1, NumberScrabble Sc2){
        FloatScrabbleFactory FScF=new FloatScrabbleFactory();
        Sc=FScF.getScrabble(Sc1.Producto(Sc2).getFloat());
    }
    public void visitIntScrabble(IntScrabble Sc1, NumberScrabble Sc2){
        IntScrabbleFactory IScF=new IntScrabbleFactory();
        Sc=IScF.getScrabble(Sc1.Producto(Sc2).getInt());
    }
    public void visitBinaryScrabble(BinaryScrabble Sc1, IntBinaryScrabble Sc2){
        BinaryScrabbleFactory FScF=new BinaryScrabbleFactory();
        Sc=FScF.getScrabble(Sc1.Producto(Sc2).getBinary());
    }
    public void visitBoolScrabble(BoolScrabble Sc1, Scrabble Sc2){
        Sc=null;
    }
    public NumberScrabble getResult(){
        return Sc;
    }
}
