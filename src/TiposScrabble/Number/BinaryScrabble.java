package TiposScrabble.Number;

import TiposScrabble.*;
import TiposScrabble.Operadores.IntBinaryScrabble;
import Visitors.visitOperador;

/**
 * Clase BinaryScrabble es un Scrabble con un
 * parametro binario Tipo String
 * Además es un IntBinaryScrabble de valor binario
 * y un LogicScrabble de valor binario
 */
public class BinaryScrabble implements IntBinaryScrabble, LogicScrabble {
    private String Bin;
    public BinaryScrabble(String binary){
        Bin=binary;
    }
    /**
     * Retorna el parametro de BinaryScrabble
     */
    public String getBinary() {
        return Bin;
    }

    /**
     * Cambia el parametro (String) binary de un BinaryScrabble dado
     * @param binary
     */
    public void setBina(String binary) {
        Bin = binary;
    }

    /**
     * Transforma un String binario de un BinaryScrabble
     * a su equivalente entero
     * @param binary
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
     * @param binary
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
     * @param binary
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
    public void accept(visitOperador aOperador, Scrabble Sc) {
        aOperador.visitBinaryScrabble(this, Sc);
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
    public Number getValue() {
        IntScrabble Int=this.toIntSc();
        return Int.getValue();
    }

    @Override
    public FloatScrabble toFloat() {
        String B=this.getBinary();
        int bit=this.toInt(B);
        double Bit=bit/1.0;
        return new FloatScrabble(Bit);
    }

    @Override
    public BinaryScrabble toBinary() {
        return this;
    }

    /**
     * Override del metodo equals para BinaryScrabble
     * @param O
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
    public IntBinaryScrabble Opuesto() {
        String Bina= this.getBinary();
        return new BinaryScrabble(this.twosComplement(Bina));

    }

    public BinaryScrabble Suma(Scrabble Num) {
        if(Num instanceof IntBinaryScrabble) {
            IntBinaryScrabble num=(IntBinaryScrabble) Num;
            return num.SumaBin(this);
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
        return (BinaryScrabble) this.Suma(Num.Opuesto());
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
     * logicalAnd, con parametro BinaryScrabble
     * Retorna un BinaryScrabble que es la operacion
     * Y Logica de un LogicScrabble con este BinaryScrabble
     * @param logic
     */
    @Override
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
     * logicalOr, con parametro BinaryScrabble
     * Retorna un BinaryScrabble que es la operacion
     * O Logica de un LogicScrabble con este BinaryScrabble
     * @param logic
     */
    @Override
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
