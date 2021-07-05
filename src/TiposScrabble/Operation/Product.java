package TiposScrabble.Operation;

import TiposScrabble.Number.NumberScrabble;
import TiposScrabble.Scrabble;
import TiposScrabble.StringScrabble;

public class Product implements Operation{
    NumberScrabble Sc;
    public Product(NumberScrabble sc1, NumberScrabble sc2){
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
