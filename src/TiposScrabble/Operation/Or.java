package TiposScrabble.Operation;

import TiposScrabble.Number.Especial.BinaryScrabble;
import TiposScrabble.Number.Especial.BoolScrabble;
import TiposScrabble.Number.Especial.LogicScrabble;
import TiposScrabble.Scrabble;
import TiposScrabble.StringScrabble;

public class Or implements Operation{
    LogicScrabble Sc;
    public Or(LogicScrabble Sc1, LogicScrabble Sc2){
        Sc=Sc1.logicalOr(Sc2);
    }

    @Override
    public LogicScrabble Operate() {
        if(Sc instanceof BinaryScrabble){
            BinaryScrabble sc=(BinaryScrabble) Sc;
            return Sc;
        }
        if(Sc instanceof BoolScrabble){
            BoolScrabble sc=(BoolScrabble) Sc;
            return Sc;
        }
        return null;
    }

    @Override
    public StringScrabble toStringSc() {
        return this.Operate().toStringSc();
    }
}
