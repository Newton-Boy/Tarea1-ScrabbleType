package TiposScrabble.Number.Especial;

import TiposScrabble.Number.FloatScrabble;
import TiposScrabble.Number.NumberScrabble;
import TiposScrabble.StringScrabble;

/**
 * Clase TiposScrabble.Number.IntBinary.BoolScrabble es un TiposScrabble.Scrabble con un
 * parametro Tipo int
 * Además es un TiposScrabble.Number.NumberScrabble de valor entero
 */
public class IntScrabble implements IntBinaryScrabble {
    private int Int;
    public IntScrabble(int i){
        Int=i;
    }
    /**
     * Retorna el parametro de TiposScrabble.Number.IntBinary.IntScrabble
     */
    public int getInt() {
        return Int;
    }

    /**
     * Cambia el parametro Integer de un
     * TiposScrabble.Number.IntBinary.IntScrabble dado
     */
    public void setInt(int anInt) {
        Int = anInt;
    }

    /**
     * Override del metodo equals para TiposScrabble.Number.IntBinary.IntScrabble
     */
    @Override
    public boolean equals(Object O){
        if(O instanceof IntScrabble){
            var Sc= (IntScrabble) O;
            return Sc.Int==Int;
        }
        return false;
    }
    @Override
    public String toString() {
        return String.valueOf(this.getInt());
    }

    @Override
    public StringScrabble toStringSc() {
        String I=this.toString();
        return new StringScrabble(I);
    }
    @Override
    public IntScrabble toIntSc() {
        return this;
    }

    @Override
    public FloatScrabble toFloat() {
        String I=this.toString();
        double iToF= Float.valueOf(I);
        return new FloatScrabble(iToF);
    }

    @Override
    public IntScrabble Opuesto() {
        return new IntScrabble(-this.getInt());
    }

    @Override
    public IntScrabble Suma(NumberScrabble Num) {
        return Num.SumaInt(this);
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
    public BinaryScrabble SumaBin(BinaryScrabble BinSc) {
        String Bi= BinSc.getBinary();
        int IntB1= this.getInt();
        int IntB2= BinSc.toInt(Bi);
        String newBin= this.IntToBinary(IntB1+IntB2);
        return new BinaryScrabble(newBin);
    }

    @Override
    public IntScrabble Resta(NumberScrabble Num) {
        return this.Suma(Num.Opuesto());
    }

    @Override
    public IntScrabble Producto(NumberScrabble Num) {
        return Num.ProductoInt(this);
    }

    @Override
    public IntScrabble ProductoInt(IntScrabble IntSc) {
        return new IntScrabble(this.getInt()*IntSc.getInt());
    }

    @Override
    public FloatScrabble ProductoFloat(FloatScrabble FloatSc) {
        double producto= this.getInt()*FloatSc.getFloat();
        return new FloatScrabble(producto);
    }

    @Override
    public BinaryScrabble ProductoBin(BinaryScrabble BinSc) {
        String Bi= BinSc.getBinary();
        int IntB1= this.getInt();
        int IntB2= BinSc.toInt(Bi);
        String newBin= this.IntToBinary(IntB1*IntB2);
        return new BinaryScrabble(newBin);
    }

    @Override
    public FloatScrabble Inverso() {
        FloatScrabble dino= this.toFloat();
        return dino.Inverso();
    }

    @Override
    public IntScrabble División(NumberScrabble Num) {
        FloatScrabble floatNum= Num.Inverso();
        return this.Producto(floatNum);
    }

    /**
     * Transforma un entero a su valor binario
     */
    public String IntToBinary(int I){
        int abs= Math.abs(I);
        String b= positiveIntToBinary(abs);
        if(I<0){
            return twosComplement(b);
        }
        else {
            return b;
        }
    }

    @Override
    public BinaryScrabble toBinary() {
        String b=IntToBinary(Int);
        return new BinaryScrabble(b);
    }
    @Override
    public String positiveIntToBinary(int I) {
        int largoBinario=0;
        String b="";
        while (I!=0){
            int R=I%2;
            b=String.valueOf(R)+b;
            largoBinario+=1;
            I=I/2;
        }
        int N=8-largoBinario;
        String B=new String(new char[N]).replace("\0", "0");
        return B+b;
    }
    @Override
    public String nowIsTwoComplement(String b) {
        int i=b.length()-1;
        int n=1;
        while(b.charAt(i)=='1'){
            n+=1;
            i-=1;
        }
        String d=b.substring(i,i+n);
        String c=b.substring(0,i);
        return c+Complement(d);
    }
    @Override
    public String Complement(String b){
        String S=b.replaceAll("0", "a");
        String T=S.replaceAll("1", "0");
        String B=T.replaceAll("a", "1");
        return B;
    }
    @Override
    public String twosComplement(String b){
        String bComplement= Complement(b);
        return nowIsTwoComplement(bComplement);
    }
}
