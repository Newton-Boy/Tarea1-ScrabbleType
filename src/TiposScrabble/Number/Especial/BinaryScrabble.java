package TiposScrabble.Number.Especial;

import TiposScrabble.*;
import TiposScrabble.Number.FloatScrabble;
import TiposScrabble.Number.NumberScrabble;

/**
 * Clase TiposScrabble.Number.IntBinary.BinaryScrabble es un TiposScrabble.Scrabble con un
 * parametro binario Tipo String
 * Además es un TiposScrabble.Number.NumberScrabble de valor binario
 * y un TiposScrabble.Number.IntBinary.LogicScrabble de valor binario
 */
public class BinaryScrabble implements IntBinaryScrabble, LogicScrabble {
    private String Bin;
    public BinaryScrabble(String binary){
        Bin=binary;
    }

    /**
     * Retorna el parametro de TiposScrabble.Number.IntBinary.BinaryScrabble
     */
    public String getBinary() {
        return Bin;
    }

    /**
     * Cambia el parametro (String) binary de un
     * TiposScrabble.Number.IntBinary.BinaryScrabble dado
     */
    public void setBina(String binary) {
        Bin = binary;
    }

    /**
     * Transforma un String binario de un
     * a su equivalente entero
     */
    public int toInt(String binary) {
        if (bitToInt(binary.charAt(0)) == 0) {
            return positiveBinToInt(binary);
        } else {
            return negativeBinaryToInt(binary);
        }
    }

    /**
     * Transforma un String binario de un
     * a su equivalente entero negativo
     */
    private int negativeBinaryToInt(String binary) {
        int n = binary.length() - 1;
        int w = -bitToInt(binary.charAt(0)) * (int) Math.pow(2, n);
        for (int i = n, j = 0; i > 0; i--, j++) {
            w += (int) Math.pow(2, j) * (binary.charAt(i) == '1' ? 1 : 0);
        }
        return w;
    }

    /**
     * Transforma un String binario de un
     * a su equivalente entero positivo
     */
    private int positiveBinToInt(String binary) {
        int w = 0;
        for (int i = binary.length() - 1, j = 0; i > 0; i--, j++) {
            w += (int) Math.pow(2, j) * bitToInt(binary.charAt(i));
        }
        return w;
    }
    private int bitToInt(char bit) {
        return bit == '0' ? 0 : 1;
    }

    @Override
    public String toString() {
        return Bin ;
    }

    @Override
    public StringScrabble toStringSc() {
        return new StringScrabble(Bin);
    }

    @Override
    public IntScrabble toIntSc() {
        String B=this.getBinary();
        int bit=this.toInt(B);
        return new IntScrabble(bit);
    }

    @Override
    public FloatScrabble toFloat() {
        String B=this.getBinary();
        int bit=this.toInt(B);
        String S= String.valueOf(bit);
        double Bit= Float.valueOf(S);
        return new FloatScrabble(Bit);
    }

    @Override
    public BinaryScrabble toBinary() {
        return this;
    }

    /**
     * Override del metodo equals para TiposScrabble.Number.IntBinary.BinaryScrabble
     */
    @Override
    public boolean equals(Object O){
        if(O instanceof BinaryScrabble){
            var Sc= (BinaryScrabble) O;
            return Sc.Bin.equals(Bin);
        }
        return false;
    }

    @Override
    public BinaryScrabble Opuesto() {
        String Bina= this.getBinary();
        return new BinaryScrabble(this.twosComplement(Bina));

    }

    public BinaryScrabble Suma(NumberScrabble Num) {
        if(Num instanceof IntBinaryScrabble){
            var newNum= (IntBinaryScrabble) Num;
            return newNum.SumaBin(this);
        }
        return null;
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
        String Bi1=this.getBinary();
        String Bi2=BinSc.getBinary();
        int IntB1= this.toInt(Bi1);
        int IntB2= BinSc.toInt(Bi2);
        String newBin= this.IntToBinary(IntB1+IntB2);
        return new BinaryScrabble(newBin);
    }

    @Override
    public BinaryScrabble Resta(NumberScrabble Num) {
        return this.Suma(Num.Opuesto());
    }

    @Override
    public BinaryScrabble Producto(NumberScrabble Num) {
        if(Num instanceof IntBinaryScrabble){
            var newNum= (IntBinaryScrabble) Num;
            return newNum.ProductoBin(this);
        }
        return null;
    }

    @Override
    public IntScrabble ProductoInt(IntScrabble IntSc) {
        FloatScrabble FloatSc=this.toFloat();
        int I1=IntSc.getInt();
        int I2= (int) FloatSc.getFloat();
        return new IntScrabble(I1*I2);
    }

    @Override
    public FloatScrabble ProductoFloat(FloatScrabble FloatSc) {
        FloatScrabble Num= this.toFloat();
        double F1=FloatSc.getFloat();
        double F2= Num.getFloat();
        return new FloatScrabble(F1*F2);
    }

    @Override
    public BinaryScrabble ProductoBin(BinaryScrabble BinSc) {
        String Bi1=this.getBinary();
        String Bi2=BinSc.getBinary();
        int IntB1= this.toInt(Bi1);
        int IntB2= BinSc.toInt(Bi2);
        String newBin= this.IntToBinary(IntB1*IntB2);
        return new BinaryScrabble(newBin);
    }

    @Override
    public FloatScrabble Inverso() {
        FloatScrabble dino= this.toFloat();
        return dino.Inverso();
    }

    @Override
    public BinaryScrabble División(NumberScrabble Num) {
        IntScrabble unidad= new IntScrabble(1);
        FloatScrabble inversoFloat= Num.Inverso();
        FloatScrabble producto=inversoFloat.Producto(this);
        IntScrabble inverso= unidad.Producto(producto);
        return inverso.toBinary();
    }

    @Override
    public String IntToBinary(int I) {
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
    public String positiveIntToBinary(int I){
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
    public String nowIsTwoComplement(String b){
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
    public String Complement(String bin){
        String S=bin.replaceAll("0", "a");
        String T=S.replaceAll("1", "0");
        String B=T.replaceAll("a", "1");
        return B;
    }
    @Override
    public String twosComplement(String bin){
        String bComplement= Complement(bin);
        return nowIsTwoComplement(bComplement);
    }
    @Override
    public BinaryScrabble Negación(){
        return new BinaryScrabble(this.Complement(this.getBinary()));
    }

    /**
     * logicalAnd, con parametro TiposScrabble.Number.IntBinary.BinaryScrabble
     * Retorna un TiposScrabble.Number.IntBinary.BinaryScrabble que es la operacion
     * Y Logica de un TiposScrabble.Number.IntBinary.LogicScrabble con este TiposScrabble.Number.IntBinary.BinaryScrabble
     */
    public BinaryScrabble logicalAnd(LogicScrabble logic){
        return logic.andBin(this);
    }
    @Override
    public BinaryScrabble andBool(BoolScrabble boolSc){
        return boolSc.andBin(this);
    }
    @Override
    public BinaryScrabble andBin(BinaryScrabble binSc){
        int min= Math.min(this.getBinary().length(),binSc.getBinary().length());
        String bin="11111111";
        String bin1= this.getBinary();
        String bin2= binSc.getBinary();
        for(int i=0;i<min;i++){
            if(bin1.charAt(i)=='0' && bin2.charAt(i)=='0') {
                bin = bin.substring(0, i) + "0" + bin.substring(i+1,min);
            }
        }
        return new BinaryScrabble(bin);
    }
    /**
     * logicalOr, con parametro TiposScrabble.Number.IntBinary.BinaryScrabble
     * Retorna un TiposScrabble.Number.IntBinary.BinaryScrabble que es la operacion
     * O Logica de un TiposScrabble.Number.IntBinary.LogicScrabble con este TiposScrabble.Number.IntBinary.BinaryScrabble
     */
    public BinaryScrabble logicalOr(LogicScrabble logic){
        return logic.orBin(this);
    }
    @Override
    public BinaryScrabble orBool(BoolScrabble boolSc){
        return boolSc.orBin(this);
    }
    @Override
    public BinaryScrabble orBin(BinaryScrabble binSc){
        int min= Math.min(this.getBinary().length(),binSc.getBinary().length());
        String bin="00000000";
        String bin1= this.getBinary();
        String bin2= binSc.getBinary();
        for(int i=0;i<min;i++){
            if(bin1.charAt(i)=='1' && bin2.charAt(i)=='1') {
                bin = bin.substring(0, i) + "1" + bin.substring(i+1,min);
            }
        }
        return new BinaryScrabble(bin);
    }
}
