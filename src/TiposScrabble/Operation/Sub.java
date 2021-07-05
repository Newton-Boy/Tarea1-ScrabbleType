package TiposScrabble.Operation;

import TiposScrabble.AddScrabble;
import TiposScrabble.Number.Especial.IntBinaryScrabble;
import TiposScrabble.Number.FloatScrabble;
import TiposScrabble.Number.NumberScrabble;
import TiposScrabble.Scrabble;
import TiposScrabble.StringScrabble;

public class Sub implements Operation{
    NumberScrabble Sc;
    public Sub(NumberScrabble sc1, NumberScrabble sc2){
        Sc=sc1.Suma(sc2);
    }
    @Override
    public NumberScrabble Operate() {
        if(Sc instanceof IntBinaryScrabble){
            IntBinaryScrabble sc=(IntBinaryScrabble) Sc;
            return sc;
        }
        if(Sc instanceof FloatScrabble){
            FloatScrabble sc=(FloatScrabble) Sc;
            return sc;
        }
        return null;
    }

    @Override
    public StringScrabble toStringSc() {
        return this.Operate().toStringSc();
    }
}
