package TiposScrabble.Number;

import TiposScrabble.Operadores.IntBinaryScrabble;
import TiposScrabble.Scrabble;
import Visitors.visitOperador;

/**
 * Clase IntScrabble es un Scrabble con un
 * parametro Tipo int
 * Además es un IntBinaryScrabble de valor entero que
 * extiende de AbstractNumberScrabble.
 */
public class IntScrabble extends AbstractNumberScrabble implements IntBinaryScrabble {
    public IntScrabble(int i){
        super(i);
    }

    /**
     * Retorna el parametro de IntScrabble
     */
    public int getInt() {
        return (int) this.getValue();
    }

    /**
     * Cambia el valor entero del IntScrabble
     * @param num
     */
    public void setInt(int num) {
        super.setValue(num);
    }
    /**
     * Override del método equals para IntScrabble
     */
    @Override
    public boolean equals(Object O){
        if(O instanceof IntScrabble){
            var Sc= (IntScrabble) O;
            return Sc.getValue()==this.getValue();
        }
        return false;
    }
    @Override
    public IntScrabble toIntSc() {
        return this;
    }

    @Override
    public IntBinaryScrabble Opuesto() {
        int N= this.getInt();
        return new IntScrabble(-N);

    }

    @Override
    public IntScrabble Suma(Scrabble Num) {
        if(Num instanceof  NumberScrabble) {
            NumberScrabble num=(NumberScrabble) Num;
            return num.SumaInt(this);
        }
        return null;
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
    public BinaryScrabble ProductoBin(BinaryScrabble BinSc) {
        String Bi= BinSc.getBinary();
        int IntB1= this.getInt();
        int IntB2= BinSc.toInt(Bi);
        String newBin= this.IntToBinary(IntB1*IntB2);
        return new BinaryScrabble(newBin);
    }

    @Override
    public IntScrabble División(NumberScrabble Num) {
        FloatScrabble inverse= Num.Inverso();
        return this.Producto(inverse);
    }

    @Override
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
        String b=IntToBinary(this.getInt());
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

    @Override
    public void accept(visitOperador aOperador, Scrabble Sc) {
        aOperador.visitIntScrabble(this, Sc);
    }
}
