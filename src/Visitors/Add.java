package Visitors;
import Factories.*;
import TiposScrabble.AddScrabble;
import TiposScrabble.Number.Especial.*;
import TiposScrabble.Number.FloatScrabble;
import TiposScrabble.Scrabble;
import TiposScrabble.StringScrabble;

public class Add extends visitOperador {
    private AddScrabble Sc;
    public void visitStringScrabble(StringScrabble Sc1, Scrabble Sc2){
        StringScrabbleFactory SScF=new StringScrabbleFactory();
        Sc=SScF.getScrabble(Sc1.Suma(Sc2).getString());
    }
    public void visitFloatScrabble(FloatScrabble Sc1, Scrabble Sc2){
        FloatScrabbleFactory FScF=new FloatScrabbleFactory();
        Sc=FScF.getScrabble(Sc1.Suma(Sc2).getFloat());
    }
    public void visitIntScrabble(IntScrabble Sc1, Scrabble Sc2){
        IntScrabbleFactory IScF=new IntScrabbleFactory();
        Sc=IScF.getScrabble(Sc1.Suma(Sc2).getInt());
    }
    public void visitBinaryScrabble(BinaryScrabble Sc1, IntBinaryScrabble Sc2){
        BinaryScrabbleFactory FScF=new BinaryScrabbleFactory();
        Sc=FScF.getScrabble(Sc1.Suma(Sc2).getBinary());
    }
    public void visitBoolScrabble(BoolScrabble Sc1, Scrabble Sc2){
        Sc=null;
    }
    public AddScrabble getResult(){
        return Sc;
    }
}
