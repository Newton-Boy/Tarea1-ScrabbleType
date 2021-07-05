package TiposScrabble.Operation;

import TiposScrabble.AddScrabble;
import TiposScrabble.Scrabble;
import TiposScrabble.StringScrabble;

public class Add implements Operation{
    AddScrabble Sc;
    public Add(AddScrabble sc1, Scrabble sc2){
        Sc=sc1.Suma(sc2);
    }

    @Override
    public Scrabble Operate() {
        return Sc;
    }

    @Override
    public StringScrabble toStringSc() {
        return this.Operate().toStringSc();
    }
}
