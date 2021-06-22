package TiposScrabble.Number.Especial;

import TiposScrabble.StringScrabble;

/**
 * Clase TiposScrabble.Number.IntBinary.BoolScrabble es un TiposScrabble.Scrabble con un
 * parametro Tipo boolean
 * Además es un TiposScrabble.Number.IntBinary.LogicScrabble de valor booleano
 */
public class BoolScrabble implements LogicScrabble {
    private boolean bool;
    public BoolScrabble(boolean b){
        bool=b;
    }
    /**
     * Retorna el parametro de TiposScrabble.Number.IntBinary.BoolScrabble
     */
    public boolean getBool(){
        return bool;
    }

    /**
     * Cambia el parametro boolean de un
     * TiposScrabble.Number.IntBinary.BoolScrabble dado
     */
    public void setBool(boolean bool) {
        this.bool = bool;
    }

    @Override
    public String toString() {
        return String.valueOf(this.getBool());
    }
    /**
     * Override del metodo equals para TiposScrabble.Number.IntBinary.BoolScrabble
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
     * Transforma un TiposScrabble.Number.IntBinary.BoolScrabble a un TiposScrabble.Number.IntBinary.BoolScrabble
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
     * logicalAnd, con parametro TiposScrabble.Number.IntBinary.BoolScrabble
     * Retorna un TiposScrabble.Number.IntBinary.BoolScrabble que es la operacion
     * Y Logica de un TiposScrabble.Number.IntBinary.BoolScrabble con este TiposScrabble.Number.IntBinary.BoolScrabble
     */
    public BoolScrabble logicalAnd(BoolScrabble logic){
        return logic.andBool(this);
    }
    /**
     * Overloading de logicalAnd, con parametro TiposScrabble.Number.IntBinary.BinaryScrabble
     * Retorna un TiposScrabble.Number.IntBinary.BinaryScrabble que es la operacion
     * Y Logica de un TiposScrabble.Number.IntBinary.BinaryScrabble con este TiposScrabble.Number.IntBinary.BoolScrabble
     */
    public BinaryScrabble logicalAnd(BinaryScrabble logic){
        return logic.andBool(this);
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
     * logicalOr, con parametro TiposScrabble.Number.IntBinary.BoolScrabble
     * Retorna un TiposScrabble.Number.IntBinary.BoolScrabble que es la operacion
     * O Logica de un TiposScrabble.Number.IntBinary.BoolScrabble con este TiposScrabble.Number.IntBinary.BoolScrabble
     */
    public BoolScrabble logicalOr(BoolScrabble logic){
        return logic.orBool(this);
    }
    /**
     * Overloading de logicalOr, con parametro TiposScrabble.Number.IntBinary.BinaryScrabble
     * Retorna un TiposScrabble.Number.IntBinary.BinaryScrabble que es la operacion
     * O Logica de un TiposScrabble.Number.IntBinary.BinaryScrabble con este TiposScrabble.Number.IntBinary.BoolScrabble
     */
    public BinaryScrabble logicalOr(BinaryScrabble logic){
        return logic.orBool(this);
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
