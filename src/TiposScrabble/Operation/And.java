package TiposScrabble.Operation;

import TiposScrabble.Number.Especial.LogicScrabble;
import TiposScrabble.Scrabble;
import TiposScrabble.StringScrabble;

public class And implements Operation {
    LogicScrabble Sc;
    public And(LogicScrabble Sc1, LogicScrabble Sc2){
        Sc=Sc1.logicalAnd(Sc2);
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
