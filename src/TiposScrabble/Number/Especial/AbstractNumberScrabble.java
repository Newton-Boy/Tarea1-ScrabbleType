package TiposScrabble.Number.Especial;

import TiposScrabble.Number.FloatScrabble;
import TiposScrabble.Number.NumberScrabble;
import TiposScrabble.StringScrabble;

public abstract class AbstractNumberScrabble implements NumberScrabble {
    private Number number;
    public AbstractNumberScrabble(Number num){
        this.number=num;
    }
    public Number getValue(){
        return number;
    }
    public void setValue(Number num){
        number=num;
    }

    public String toString(){
        return String.valueOf(this.getValue());
    }

    public StringScrabble toStringSc(){
        String N=this.toString();
        return new StringScrabble(N);
    }
    public FloatScrabble toFloat() {
        double N=number.doubleValue();
        return new FloatScrabble(N);
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
        FloatScrabble Num= this.toFloat();
        double F1=FloatSc.getFloat();
        double F2= Num.getFloat();
        return new FloatScrabble(F1+F2);
    }

    @Override
    public NumberScrabble Resta(NumberScrabble Num) {
        return this.Suma(Num.Opuesto());
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
        FloatScrabble NumSc= this.toFloat();
        double F= NumSc.getFloat();
        double f= FloatSc.getFloat();
        return new FloatScrabble(F*f);
    }

    @Override
    public FloatScrabble Inverso() {
        FloatScrabble dino=this.toFloat();
        return new FloatScrabble(1.0/dino.getFloat());
    }

    @Override
    public NumberScrabble División(NumberScrabble Num) {
        FloatScrabble inverse= Num.Inverso();
        return this.Producto(inverse);
    }
}
