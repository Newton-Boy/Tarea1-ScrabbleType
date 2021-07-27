package TiposScrabble.Number.Especial;

import TiposScrabble.Scrabble;
import TiposScrabble.StringScrabble;
import Visitors.visitOperador;

/**
 * Clase BoolScrabble es un Scrabble con un
 * parametro Tipo boolean
 * Además es un LogicScrabble de valor booleano
 */
public class BoolScrabble implements LogicScrabble {
    private boolean bool;
    public BoolScrabble(boolean b){
        bool=b;
    }
    /**
     * Retorna el parametro de BoolScrabble
     */
    public boolean getBool(){
        return bool;
    }

    /**
     * Cambia el parametro boolean de un BoolScrabble dado
     * @param bool
     */
    public void setBool(boolean bool) {
        this.bool = bool;
    }

    @Override
    public String toString() {
        return String.valueOf(this.getBool());
    }

    @Override
    public void accept(visitOperador aOperador, Scrabble Sc) {
        aOperador.visitBoolScrabble(this, Sc);
    }

    /**
     * Override del metodo equals para BoolScrabble
     * @param O
     */
    @Override
    public boolean equals(Object O){
        if(O instanceof BoolScrabble){
            var Sc= (BoolScrabble) O;
            return Sc.bool==bool;
        }
        return false;
    }

    @Override
    public StringScrabble toStringSc() {
        String B=this.toString();
        return new StringScrabble(B);
    }

    /**
     * Transforma un BoolScrabble a un BoolScrabble
     */
    public BoolScrabble toBool() {
        return this;
    }

    @Override
    public BoolScrabble Negación(){
        if(this.getBool()==true){
            return new BoolScrabble(false);
        }
        else{
            return new BoolScrabble(true);
        }
    }
    /**
     * logicalAnd, con parametro BoolScrabble
     * Retorna un BoolScrabble que es la operacion
     * Y Logica de un BoolScrabble con este BoolScrabble
     */
    public BoolScrabble BoolLogicalAnd(BoolScrabble logic){
        return logic.andBool(this);
    }
    /**
     * Overloading de logicalAnd, con parametro BinaryScrabble
     * Retorna un BinaryScrabble que es la operacion
     * Y Logica de un BinaryScrabble con este BoolScrabble
     */
    public BinaryScrabble BinLogicalAnd(BinaryScrabble logic){
        return logic.andBool(this);
    }

    @Override
    public LogicScrabble logicalAnd(LogicScrabble logic){
        if(logic instanceof BoolScrabble){
            BoolScrabble Logic=(BoolScrabble) logic;
            return this.BoolLogicalAnd(Logic);
        }
        else {
            BinaryScrabble Logic=(BinaryScrabble) logic;
            return this.BinLogicalAnd(Logic);
        }
    }

    @Override
    public BoolScrabble andBool(BoolScrabble boolSc){
        if(this.getBool()==true && boolSc.getBool()==true){
            return new BoolScrabble(true);
        }
        else {
            return new BoolScrabble(false);
        }
    }
    @Override
    public BinaryScrabble andBin(BinaryScrabble binSc){
        if(this.getBool()==true){
            return binSc;
        }
        else {
            return new BinaryScrabble("11111111");
        }
    }
    /**
     * logicalOr, con parametro BoolScrabble
     * Retorna un BoolScrabble que es la operacion
     * O Logica de un BoolScrabble con este BoolScrabble
     */
    public BoolScrabble BoolLogicalOr(BoolScrabble logic){
        return logic.orBool(this);
    }
    /**
     * Overloading de logicalOr, con parametro BinaryScrabble
     * Retorna un BinaryScrabble que es la operacion
     * O Logica de un BinaryScrabble con este BoolScrabble
     */
    public BinaryScrabble BinLogicalOr(BinaryScrabble logic){
        return logic.orBool(this);
    }
    @Override
    public LogicScrabble logicalOr(LogicScrabble logic){
        if(logic instanceof BoolScrabble){
            BoolScrabble Logic=(BoolScrabble) logic;
            return this.BoolLogicalOr(Logic);
        }
        else {
            BinaryScrabble Logic=(BinaryScrabble) logic;
            return this.BinLogicalOr(Logic);
        }
    }

    @Override
    public BoolScrabble orBool(BoolScrabble boolSc){
        if(this.getBool()==false && boolSc.getBool()==false){
            return new BoolScrabble(false);
        }
        else {
            return new BoolScrabble(true);
        }
    }
    @Override
    public BinaryScrabble orBin(BinaryScrabble binSc){
        if(this.getBool()==true){
            return new BinaryScrabble("00000000");
        }
        else {
            return binSc;
        }
    }
}
