package Visitors;
import Factories.*;
import TiposScrabble.*;
import TiposScrabble.Number.BinaryScrabble;
import TiposScrabble.Number.FloatScrabble;
import TiposScrabble.Number.IntScrabble;
import TiposScrabble.Operadores.AddScrabble;
import TiposScrabble.Operadores.IntBinaryScrabble;

/**
 * Operador visitante Suma/Concatenación. Realiza una resta entre Scrabble retornando un
 * resultado adecuado en cada situación (Usando el cuadro 2 como referente)
 */
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
        BinaryScrabbleFactory BiScF=new BinaryScrabbleFactory();
        Sc=BiScF.getScrabble(Sc1.Suma(Sc2).getBinary());
    }
    public void visitBoolScrabble(BoolScrabble Sc1, Scrabble Sc2){Sc=null; }
    public AddScrabble getResult(){
        return Sc;
    }
}
