package Visitors;

import Factories.*;
import TiposScrabble.Number.Especial.BinaryScrabble;
import TiposScrabble.Number.Especial.BoolScrabble;
import TiposScrabble.Number.Especial.IntBinaryScrabble;
import TiposScrabble.Number.Especial.IntScrabble;
import TiposScrabble.Number.FloatScrabble;
import TiposScrabble.Number.NumberScrabble;
import TiposScrabble.Scrabble;
import TiposScrabble.StringScrabble;

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
