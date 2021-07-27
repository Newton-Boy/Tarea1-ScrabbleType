package Visitors;

import Factories.*;
import TiposScrabble.Number.Especial.*;
import TiposScrabble.Number.FloatScrabble;
import TiposScrabble.Number.NumberScrabble;
import TiposScrabble.Scrabble;
import TiposScrabble.StringScrabble;

public class And extends visitOperador {
    private LogicScrabble Sc;
    public void visitStringScrabble(StringScrabble Sc1, Scrabble Sc2){
        Sc=null;
    }
    public void visitFloatScrabble(FloatScrabble Sc1, NumberScrabble Sc2){
        Sc=null;
    }
    public void visitIntScrabble(IntScrabble Sc1, NumberScrabble Sc2){
        Sc=null;
    }
    public void visitBinaryScrabble(BinaryScrabble Sc1, LogicScrabble Sc2){
        BinaryScrabbleFactory BiScF=new BinaryScrabbleFactory();
        Sc=BiScF.getScrabble(Sc1.logicalAnd(Sc2).getBinary());
    }
    public void visitBoolScrabble(BoolScrabble Sc1, LogicScrabble Sc2){
        BoolScrabbleFactory BScF=new BoolScrabbleFactory();
        BinaryScrabbleFactory BiScF=new BinaryScrabbleFactory();
        LogicScrabble logic=Sc1.logicalAnd(Sc2);
        if(logic instanceof BoolScrabble){
            Sc=BiScF.getScrabble(((BinaryScrabble) logic).getBinary());
        }
        else{

        }
        Sc=BScF.getScrabble(((BoolScrabble) logic).getBool());
    }
    public LogicScrabble getResult(){
        return Sc;
    }
}
