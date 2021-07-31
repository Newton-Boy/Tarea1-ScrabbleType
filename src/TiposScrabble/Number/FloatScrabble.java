package TiposScrabble.Number;

import TiposScrabble.Scrabble;
import Visitors.visitOperador;

/**
 * Clase FloatScrabble es un Scrabble con un
 * parametro Tipo double
 * Además es un NumberScrabble de valor double que
 * extiende de AbstractNumberScrabble.
 */
public class FloatScrabble extends AbstractNumberScrabble {
    public FloatScrabble(double f){
        super(f);
    }

    /**
     * Retorna el parametro de FloatScrabble
     */
    public double getFloat() {
        return (double) this.getValue();
    }

    /**
     * Cambia el valor real (float) del FloatScrabble
     * @param num
     */
    public void setFloat(double num) {
        super.setValue(num);
    }

    /**
     * Override del método equals para FloatScrabble
     * @param O
     */
    @Override
    public boolean equals(Object O){
        if(O instanceof FloatScrabble){
            var Sc= (FloatScrabble) O;
            return Sc.getFloat()-this.getFloat()<=0.001 && Sc.getFloat()-this.getFloat()>=-0.001;
        }
        return false;
    }

    @Override
    public BinaryScrabble toBinary() {
        return null;
    }

    @Override
    public FloatScrabble Opuesto() {
        double F=this.getFloat();
        return new FloatScrabble(-F);
    }

    @Override
    public FloatScrabble Suma(Scrabble Num) {
        if(Num instanceof NumberScrabble){
            NumberScrabble num=(NumberScrabble) Num;
            return num.SumaFloat(this);
        }
        return null;
    }

    @Override
    public FloatScrabble Resta(NumberScrabble Num) {
        return this.Suma(Num.Opuesto());
    }

    @Override
    public FloatScrabble Producto(NumberScrabble Num) {
        return Num.ProductoFloat(this);
    }
    @Override
    public FloatScrabble División(NumberScrabble Num) {
        FloatScrabble inverse= Num.Inverso();
        return this.Producto(inverse);
    }

    @Override
    public void accept(visitOperador aOperador, Scrabble Sc) {
        aOperador.visitFloatScrabble(this, Sc);
    }
}
