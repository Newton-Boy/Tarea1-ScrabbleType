package TiposScrabble.Number;

import TiposScrabble.Number.Especial.AbstractNumberScrabble;
import TiposScrabble.Number.Especial.BinaryScrabble;
import TiposScrabble.Number.Especial.IntScrabble;
import TiposScrabble.Scrabble;
import TiposScrabble.StringScrabble;

/**
 * Clase TiposScrabble.Number.FloatScrabble es un TiposScrabble.Scrabble con un
 * parametro Tipo double
 * Además es un TiposScrabble.Number.NumberScrabble de valor double
 */
public class FloatScrabble extends AbstractNumberScrabble {
    public FloatScrabble(double f){
        super(f);
    }

    /**
     * Retorna el parametro de TiposScrabble.Number.FloatScrabble
     */
    public double getFloat() {
        return (double) this.getValue();
    }

    /**
     * Override del metodo equals para TiposScrabble.Number.FloatScrabble
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
}
