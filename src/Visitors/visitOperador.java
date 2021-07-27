package Visitors;

import TiposScrabble.Number.Especial.BinaryScrabble;
import TiposScrabble.Number.Especial.IntScrabble;
import TiposScrabble.Number.Especial.LogicScrabble;
import TiposScrabble.Number.FloatScrabble;
import TiposScrabble.Number.NumberScrabble;
import TiposScrabble.Scrabble;
import TiposScrabble.StringScrabble;

import java.util.ArrayList;
import java.util.List;

public class visitOperador {
    public void visitStringScrabble(StringScrabble Sc1, Scrabble Sc2){}
    public void visitFloatScrabble(FloatScrabble Sc1, Scrabble Sc2){}
    public void visitIntScrabble(IntScrabble Sc1, Scrabble Sc2){}
    public void visitBinaryScrabble(BinaryScrabble Sc1, Scrabble Sc2){}
    public void visitBoolScrabble(LogicScrabble Sc1, Scrabble Sc2){}
    public Scrabble getResult(){
        return null;
    }
}
