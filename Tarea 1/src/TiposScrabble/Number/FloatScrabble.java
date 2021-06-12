package TiposScrabble.Number;

import TiposScrabble.Number.Especial.IntScrabble;
import TiposScrabble.StringScrabble;

/**
 * Clase TiposScrabble.Number.FloatScrabble es un TiposScrabble.Scrabble con un
 * parametro Tipo double
 * Además es un TiposScrabble.Number.NumberScrabble de valor double
 */
public class FloatScrabble implements NumberScrabble {
    private double Float;
    public FloatScrabble(double f){
        Float=f;
    }

    /**
     * Retorna el parametro de TiposScrabble.Number.FloatScrabble
     */
    public double getFloat() {
        return Float;
    }

    /**
     * Cambia el parametro double de un
     * TiposScrabble.Number.FloatScrabble dado
     */
    public void setFloat(double aFloat) {
        Float = aFloat;
    }

    @Override
    public String toString() {
        return String.valueOf(this.getFloat());
    }

    /**
     * Override del metodo equals para TiposScrabble.Number.FloatScrabble
     */
    @Override
    public boolean equals(Object O){
        if(O instanceof FloatScrabble){
            var Sc= (FloatScrabble) O;
            return Sc.Float-Float<=0.001 && Sc.Float-Float>=-0.001;
        }
        return false;
    }

    @Override
    public StringScrabble toStringSc() {
        String F=this.toString();
        return new StringScrabble(F);
    }

    @Override
    public FloatScrabble toFloat() {
        return this;
    }

    @Override
    public FloatScrabble Opuesto() {
        return new FloatScrabble(-this.getFloat());
    }

    @Override
    public FloatScrabble Suma(NumberScrabble Num) {
        return Num.SumaFloat(this);
    }
    @Override
    public IntScrabble SumaInt(IntScrabble IntSc) {
        FloatScrabble FloatSc=this.toFloat();
        int I1=IntSc.getInt();
        int I2= (int) FloatSc.getFloat();
        return new IntScrabble(I1+I2);
    }

    @Override
    public FloatScrabble SumaFloat(FloatScrabble FloatSc) {
        double F1=FloatSc.getFloat();
        double F2= this.getFloat();
        return new FloatScrabble(F1+F2);
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
    public IntScrabble ProductoInt(IntScrabble IntSc) {
        FloatScrabble IntScToFloatSc= IntSc.toFloat();
        FloatScrabble floatProducto= this.ProductoFloat(IntScToFloatSc);
        double round= Math.round(floatProducto.getFloat());
        int IntProducto= (int) round;
        return new IntScrabble(IntProducto);
    }

    @Override
    public FloatScrabble ProductoFloat(FloatScrabble FloatSc) {
        return new FloatScrabble(this.getFloat()*FloatSc.getFloat());
    }

    public FloatScrabble Inverso() {
        return new FloatScrabble(1.0/this.getFloat());
    }
    @Override
    public FloatScrabble División(NumberScrabble Num) {
        FloatScrabble inverso= Num.Inverso();
        return this.Producto(inverso);
    }
}
