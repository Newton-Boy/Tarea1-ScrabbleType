import Factories.*;
import TiposScrabble.*;
import TiposScrabble.Number.Especial.BoolScrabble;
import TiposScrabble.Number.Especial.BinaryScrabble;
import TiposScrabble.Number.Especial.LogicScrabble;
import TiposScrabble.Number.FloatScrabble;
import TiposScrabble.Number.Especial.IntScrabble;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class TestScrabble {
    private StringScrabble sType;
    private BoolScrabble bType;
    private FloatScrabble fType;
    private IntScrabble iType;
    private BinaryScrabble biType;

    @BeforeEach
    public void setUp(){
        sType=new StringScrabble("Hola");
        bType= new BoolScrabble(true);
        fType= new FloatScrabble(2.4);
        iType= new IntScrabble(23);
        biType= new BinaryScrabble("00000010");
    }
    /**
     * Test de loa getters de las clases Scrabble
     * */
    @Test void gettersTest(){
        String expectStr= "Hola";
        assertEquals(expectStr,sType.getString());

        boolean expectBool=true;
        assertEquals(expectBool,bType.getBool());
        double expectFloat=2.4;
        assertEquals(expectFloat,fType.getFloat());

        int expectInt=23;
        assertEquals(expectInt,iType.getInt());
        String expectBin="00000010";
        assertEquals(expectBin,biType.getBinary());
    }
    /**
     * Test de los Setters de las clases Scrabble
     * */
    @Test void settersTest(){
        StringScrabble expectStrSc= new StringScrabble("");
        expectStrSc.setString(sType.getString());
        assertEquals(expectStrSc,sType);

        BoolScrabble expectBoolSc=new BoolScrabble(false);
        expectBoolSc.setBool(bType.getBool());
        assertEquals(expectBoolSc,bType);

        FloatScrabble expectFloatSc=new FloatScrabble(0.0);
        expectFloatSc.setFloat(fType.getFloat());
        assertEquals(expectFloatSc,fType);
        IntScrabble expectIntSc=new IntScrabble(0);
        expectIntSc.setInt(iType.getInt());
        assertEquals(expectIntSc,iType);

        BinaryScrabble expectBinSc=new BinaryScrabble("");
        expectBinSc.setBina(biType.getBinary());
        assertEquals(expectBinSc,biType);
    }
    /**
     * Este Test existe para asegurarme que pueda usarlo
     * en los métodos con Strings Binarios
     * */
    @Test void multiplyString(){
        String expected="0000";
        String Bi=new String(new char[4]).replace("\0", "0");
        assertEquals(expected,Bi);
    }
    /**
     * Test que comprueba sí el método logra pasar un entero positivo
     * a un String binario
     * */
    @Test void positiveIntToBinTest(){
        String b= iType.positiveIntToBinary(8);
        String expected ="00001000";
        assertEquals(expected,b);
    }
    /**
     * Test que prueba si, a partir de un String binario Complemento 1,
     * el método devuelve un Complemento 2
     * */
    @Test void  nowIsTwoComplementTest(){
        String B=iType.nowIsTwoComplement("1001");
        String expected="1010";
        assertEquals(expected,B);
    }
    /**
     *Test que prueba si el método Complement cambia los 0 por 1 y viceversa
     * */
    @Test void  ComplementTest(){
        String b=iType.Complement("0110");
        String expected ="1001";
        assertEquals(expected,b);
    }
    /**
     * Test que prueba sí el método 2-Complemento retorna un String que es el
     * Complemento 2 del String binario otorgado.
     * */
    @Test void twosComplementTest(){
        String b= iType.twosComplement("0110");
        String expected ="1010";
        assertEquals(expected,b);
    }
    /**
     * Prueba que todos los parametros de los Scrabbles sean pasados
     * a un Tipo Scrabble.
     * */
    @Test
    void toStringTest(){
        String expectedS="Hola";
        assertEquals(expectedS,sType.toString());

        String expectedB="true";
        assertEquals(expectedB,bType.toString());

        String expectedF="2.4";
        assertEquals(expectedF,fType.toString());

        String expectedI="23";
        assertEquals(expectedI,iType.toString());

        String expectedBi="00000010";
        assertEquals(expectedBi,biType.toString());
    }
    /**
     *Test que comprueba sí los distintos Scrabble pueden pasar
     * a StringScrabble.
     * */
    @Test
    void TestScrabbleToStringSc(){
        StringScrabble expectedSSc= sType.toStringSc();
        assertEquals(expectedSSc,sType);

        StringScrabble expectedBSc=new StringScrabble("true");
        StringScrabble B= bType.toStringSc();
        assertEquals(expectedBSc,B);

        StringScrabble expectedFSc=new StringScrabble("2.4");
        StringScrabble F= fType.toStringSc();
        assertEquals(expectedFSc,F);

        StringScrabble expectedISc=new StringScrabble("23");
        StringScrabble I= iType.toStringSc();
        assertEquals(expectedISc,I);

        StringScrabble expectedBiSc=new StringScrabble("00000010");
        StringScrabble Bi= biType.toStringSc();
        assertEquals(expectedBiSc,Bi);
    }
    /**
     * Prueba sí BoolScrabble puede pasar a un BoolScrabble
     * */
    @Test void TestBoolToBool(){
        BoolScrabble expected= bType.toBool();
        assertEquals(expected,bType);
    }
    /**
     *Test que comprueba sí los distintos NumberScrabble pueden pasar
     * a FloatScrabble.
     * */
    @Test void TestNumberToFloat(){
        FloatScrabble expectedFSc=  fType.toFloat();
        assertEquals(expectedFSc,fType);

        FloatScrabble expectedISc= new FloatScrabble(23.0);
        FloatScrabble newFloatISc=  iType.toFloat();
        assertEquals(expectedISc,newFloatISc);

        FloatScrabble expectedBiSc= new FloatScrabble(2.0);
        FloatScrabble newFloatBiSc= biType.toFloat();
        assertEquals(expectedBiSc,newFloatBiSc);
    }
    /**
     *Test que comprueba sí los IntBinaryScrabble pueden pasar
     * a IntScrabble.
     * */
    @Test public void TestIntBinScToIntSc(){
        IntScrabble expectedISc= iType.toIntSc();
        assertEquals(expectedISc,iType);

        IntScrabble expectedBiSc= new IntScrabble(2);
        IntScrabble newInt= biType.toIntSc();
        assertEquals(expectedBiSc,newInt);
    }
    /**
     *Test que comprueba sí un Integer puede
     * transformarse a un String binario.
     * */
    @Test void TestIntToBinary() {
        String B = iType.IntToBinary(23);
        String expected = "00010111";
        assertEquals(expected, B);
    }
    /**
     *Test que comprueba sí los IntBinaryScrabble pueden pasar
     * a BinaryScrabble.
     * */
    @Test void TestIntScToBinary(){
        BinaryScrabble expectedISc= new BinaryScrabble("00010111");
        BinaryScrabble newBinary= iType.toBinary();
        assertEquals(expectedISc,newBinary);

        BinaryScrabble expectedBiSc= biType.toBinary();
        assertEquals(expectedBiSc,biType);
    }
    /**
     *Test que prueba la concatenación StringScrabble
     * */
    @Test void SumaStringStringTest(){
        StringScrabble StringSc= new StringScrabble("Adios");
        StringScrabble StringSumS= sType.Suma(StringSc);
        StringScrabble expectedSSc= new StringScrabble("HolaAdios");
        assertEquals(expectedSSc,StringSumS);

        StringScrabble StringSumB= sType.Suma(bType);
        StringScrabble expectedB= new StringScrabble("Holatrue");
        assertEquals(expectedB,StringSumB);

        StringScrabble StringSumF= sType.Suma(fType);
        StringScrabble expectedF= new StringScrabble("Hola2.4");
        assertEquals(expectedF,StringSumF);

        StringScrabble StringSumI= sType.Suma(iType);
        StringScrabble expectedI= new StringScrabble("Hola23");
        assertEquals(expectedI,StringSumI);

        StringScrabble StringSumBi= sType.Suma(biType);
        StringScrabble expectedBi= new StringScrabble("Hola00000010");
        assertEquals(expectedBi,StringSumBi);
    }
    /**
     *Test que prueba la suma FloatScrabble, con otro NumberScrabble
     * */
    @Test void SumaFloatNumTest(){
        FloatScrabble FloatSc = new FloatScrabble(5.1);
        FloatScrabble FloatSumF= fType.Suma(FloatSc);
        FloatScrabble expectedF= new FloatScrabble(7.5);
        assertEquals(expectedF,FloatSumF);

        FloatScrabble FloatSumI= fType.Suma(iType);
        FloatScrabble expectedI= new FloatScrabble(25.4);
        assertEquals(expectedI,FloatSumI);

        FloatScrabble FloatSumBi= fType.Suma(biType);
        FloatScrabble expectedBi= new FloatScrabble(4.4);
        assertEquals(expectedBi,FloatSumBi);
    }
    /**
     *Test que prueba la suma IntScrabble, con otro NumberScrabble
     * */
    @Test void SumaIntNumTest(){
        IntScrabble IntSumF= iType.Suma(fType);
        IntScrabble expectedF= new IntScrabble(25);
        assertEquals(expectedF,IntSumF);

        IntScrabble IntSc = new IntScrabble(-7);
        IntScrabble IntSumI= iType.Suma(IntSc);
        IntScrabble expectedI= new IntScrabble(16);
        assertEquals(expectedI,IntSumI);

        IntScrabble IntSumBi= iType.Suma(biType);
        IntScrabble expectedBi= new IntScrabble(25);
        assertEquals(expectedBi,IntSumBi);
    }
    /**
     * Test que prueba la suma BinaryScrabble
     * con otro IntBinaryScrabble
     * */
    @Test void SumaBinaryIntBinTest(){
        BinaryScrabble BinarySumI= biType.Suma(iType);
        BinaryScrabble expectedI= new BinaryScrabble("00011001");
        assertEquals(expectedI,BinarySumI);

        BinaryScrabble BinarySc = new BinaryScrabble("11111100");
        BinaryScrabble BinarySumBi= biType.Suma(BinarySc);
        BinaryScrabble expectedBi= new BinaryScrabble("11111110");
        assertEquals(expectedBi,BinarySumBi);
    }
    /**
     * Test que prueba la resta FloatScrabble
     * con otro NumberScrabble
     * */
    @Test void RestaFloatNumTest(){
        FloatScrabble FloatSc = new FloatScrabble(5.1);
        FloatScrabble FloatSumF= fType.Resta(FloatSc);
        FloatScrabble expectedF= new FloatScrabble(-2.7);
        assertEquals(expectedF,FloatSumF);

        FloatScrabble FloatSumI= fType.Resta(iType);
        FloatScrabble expectedI= new FloatScrabble(-20.6);
        assertEquals(expectedI,FloatSumI);

        FloatScrabble FloatSumBi= fType.Resta(biType);
        FloatScrabble expectedBi= new FloatScrabble(0.4);
        assertEquals(expectedBi,FloatSumBi);
    }
    /**
     * Test que prueba la resta IntScrabble
     * con otro NumberScrabble
     * */
    @Test void RestaIntNumTest(){
        IntScrabble IntSumF= iType.Resta(fType);
        IntScrabble expectedF= new IntScrabble(21);
        assertEquals(expectedF,IntSumF);

        IntScrabble IntSc = new IntScrabble(-7);
        IntScrabble IntSumI= iType.Resta(IntSc);
        IntScrabble expectedI= new IntScrabble(30);
        assertEquals(expectedI,IntSumI);

        IntScrabble IntSumBi= iType.Resta(biType);
        IntScrabble expectedBi= new IntScrabble(21);
        assertEquals(expectedBi,IntSumBi);
    }
    /**
     * Test que prueba la resta BinaryScrabble
     * con otro IntBinaryScrabble
     * */
    @Test void RestaBinaryIntBinTest(){
        BinaryScrabble BinarySumI= biType.Resta(iType);
        BinaryScrabble expectedI= new BinaryScrabble("11101011");
        assertEquals(expectedI,BinarySumI);

        BinaryScrabble BinarySc = new BinaryScrabble("11111100");
        BinaryScrabble BinarySumBi= biType.Resta(BinarySc);
        BinaryScrabble expectedBi= new BinaryScrabble("00000110");
        assertEquals(expectedBi,BinarySumBi);
    }
    /**
     * Test que prueba el producto FloatScrabble
     * con otro NumberScrabble
     * */
    @Test void ProductoFloatNumTes(){
        FloatScrabble FloatSc= new FloatScrabble(3.2);
        FloatScrabble ProductoF =fType.Producto(FloatSc);
        FloatScrabble expectedF= new FloatScrabble(7.68);
        assertEquals(expectedF,ProductoF);

        FloatScrabble ProductoI =fType.Producto(iType);
        FloatScrabble expectedI= new FloatScrabble(55.2);
        assertEquals(expectedI,ProductoI);

        FloatScrabble ProductoBi =fType.Producto(biType);
        FloatScrabble expectedBi= new FloatScrabble(4.8);
        assertEquals(expectedBi,ProductoBi);
    }
    /**
     * Test que prueba el producto IntScrabble
     * con otro NumberScrabble
     * */
    @Test void ProductoIntNumTes(){
        IntScrabble ProductoF =iType.Producto(fType);
        IntScrabble expectedF= new IntScrabble(55);
        assertEquals(expectedF,ProductoF);

        IntScrabble IntSc= new IntScrabble(3);
        IntScrabble ProductoI =iType.Producto(IntSc);
        IntScrabble expectedI= new IntScrabble(69);
        assertEquals(expectedI,ProductoI);

        IntScrabble ProductoBi =iType.Producto(biType);
        IntScrabble expectedBi= new IntScrabble(46);
        assertEquals(expectedBi,ProductoBi);
    }
    /**
     * Test que prueba el producto BinaryScrabble
     * con otro IntBinaryScrabble
     * */
    @Test void ProductoBinaryIntBinTes(){
        BinaryScrabble ProductoI =biType.Producto(iType);
        BinaryScrabble expectedI= new BinaryScrabble("00101110");
        assertEquals(expectedI,ProductoI);

        BinaryScrabble BinSc= new BinaryScrabble("00010101");
        BinaryScrabble ProductoBi =biType.Producto(BinSc);
        BinaryScrabble expectedBi= new BinaryScrabble("00101010");
        assertEquals(expectedBi,ProductoBi);
    }
    /**
     * Test que prueba el división FloatScrabble
     * con otro NumberScrabble
     * */
    @Test void DivisionFloatNumTes(){
        FloatScrabble FloatSc= new FloatScrabble(3.2);
        FloatScrabble DivisiónF =fType.División(FloatSc);
        FloatScrabble expectedF= new FloatScrabble(0.75);
        assertEquals(expectedF,DivisiónF);

        FloatScrabble DivisiónI =fType.División(iType);
        FloatScrabble expectedI= new FloatScrabble(0.1043);
        assertEquals(expectedI,DivisiónI);

        FloatScrabble DivisiónBi =fType.División(biType);
        FloatScrabble expectedBi= new FloatScrabble(1.2);
        assertEquals(expectedBi,DivisiónBi);
    }
    /**
     * Test que prueba el división IntScrabble
     * con otro NumberScrabble
     * */
    @Test void DivisionIntNumTes(){
        IntScrabble DivisiónF =iType.División(fType);
        IntScrabble expectedF= new IntScrabble(10);
        assertEquals(expectedF,DivisiónF);

        IntScrabble IntSc= new IntScrabble(3);
        IntScrabble DivisiónI =iType.División(IntSc);
        IntScrabble expectedI= new IntScrabble(8);
        assertEquals(expectedI,DivisiónI);

        IntScrabble DivisiónBi =iType.División(biType);
        IntScrabble expectedBi= new IntScrabble(12);
        assertEquals(expectedBi,DivisiónBi);
    }
    /**
     * Test que prueba el división BinaryScrabble
     * con otro IntBinaryScrabble
     * */
    @Test void DivisiónBinaryIntBinTes(){
        BinaryScrabble DivisiónI =biType.División(iType);
        BinaryScrabble expectedI= new BinaryScrabble("00000000");
        assertEquals(expectedI,DivisiónI);

        BinaryScrabble BinSc= new BinaryScrabble("00010101");
        BinaryScrabble DivisiónBi =BinSc.División(biType);
        BinaryScrabble expectedBi= new BinaryScrabble("00001011");
        assertEquals(expectedBi,DivisiónBi);
    }
    /**
     * Test que prueba la negación lógica para un BoolScrabble
     * */
    @Test void NegaciónLogicaBoolTest(){
        BoolScrabble NegaBool=bType.Negación();
        BoolScrabble expected=new BoolScrabble(false);
        assertEquals(expected,NegaBool);
    }
    /**
     * Test que prueba la negación lógica para un BinaryScrabble
     * */
    @Test void NegaciónLogicaBinaryTest(){
        BinaryScrabble NegaBin=biType.Negación();
        BinaryScrabble expected=new BinaryScrabble("11111101");
        assertEquals(expected,NegaBin);
    }
    /**
     * Test que prueba el Y lógico para un BoolScrabble con otro
     * */
    @Test void logicalBoolAndBoolTest(){
        BoolScrabble expectedFalse=new BoolScrabble(false);
        BoolScrabble expectedTrue=new BoolScrabble(true);
        BoolScrabble False =new BoolScrabble(false);
        BoolScrabble trueAndFalse=bType.andBool(False);
        LogicScrabble falseAndTrue=False.logicalAnd(bType);
        LogicScrabble falseAndFalse=False.logicalAnd(False);
        LogicScrabble trueAndTrue=bType.logicalAnd(bType);
        assertEquals(expectedFalse,trueAndFalse);
        assertEquals(expectedFalse,falseAndTrue);
        assertEquals(expectedFalse,falseAndFalse);
        assertEquals(expectedTrue,trueAndTrue);
    }
    /**
     * Test que prueba el Y lógico para un BoolScrabble y un BinaryScrabble
     * */
    @Test void logicalAndBoolBinTest(){
        BinaryScrabble BinSc1 =new BinaryScrabble("01100101");
        BoolScrabble False=new BoolScrabble(false);
        LogicScrabble trueAndBin=  bType.logicalAnd(BinSc1);
        LogicScrabble falseAndBin= False.logicalAnd(BinSc1);
        BinaryScrabble expectedTrueBin=new BinaryScrabble("01100101");
        BinaryScrabble expectedFalseBin=new BinaryScrabble("11111111");
        assertEquals(expectedTrueBin,trueAndBin);
        assertEquals(expectedFalseBin,falseAndBin);
    }
    /**
     * Test que prueba el Y lógico para un BinaryScrabble con otro
     * */
    @Test void logicalAndBinBinTest(){
        BinaryScrabble BinSc1 =new BinaryScrabble("01100101");
        BinaryScrabble BinSc2 =new BinaryScrabble("01001101");
        BinaryScrabble LogicBin=BinSc1.logicalAnd(BinSc2);
        BinaryScrabble expected=new BinaryScrabble("01101101");
        assertEquals(expected,LogicBin);
    }
    /**
     * Test que prueba el O lógico para un BoolScrabble con otro
     * */
    @Test void logicalOrBoolBoolTest(){
        BoolScrabble expectedFalse=new BoolScrabble(false);
        BoolScrabble expectedTrue=new BoolScrabble(true);
        BoolScrabble False =new BoolScrabble(false);
        LogicScrabble trueOrFalse= bType.logicalOr(False);
        LogicScrabble falseOrTrue= False.logicalOr(bType);
        LogicScrabble falseOrFalse= False.logicalOr(False);
        LogicScrabble trueOrTrue= bType.logicalOr(bType);
        assertEquals(expectedTrue,trueOrFalse);
        assertEquals(expectedTrue,falseOrTrue);
        assertEquals(expectedFalse,falseOrFalse);
        assertEquals(expectedTrue,trueOrTrue);
    }
    /**
     * Test que prueba el O lógico para un BoolScrabble y un BinaryScrabble
     * */
    @Test void logicalOrBoolBinTest(){
        BinaryScrabble BinSc1 =new BinaryScrabble("01100101");
        BoolScrabble False=new BoolScrabble(false);
        LogicScrabble trueOrBin=  bType.logicalOr(BinSc1);
        LogicScrabble falseOrBin= False.logicalOr(BinSc1);
        BinaryScrabble expectedTrueBin=new BinaryScrabble("00000000");
        BinaryScrabble expectedFalseBin=new BinaryScrabble("01100101");
        assertEquals(expectedTrueBin,trueOrBin);
        assertEquals(expectedFalseBin,falseOrBin);
    }
    /**
     * Test que prueba el O lógico para un BinaryScrabble con otro
     * */
    @Test void logicalOrBinBinTest(){
        BinaryScrabble BinSc1 =new BinaryScrabble("01100101");
        BinaryScrabble BinSc2 =new BinaryScrabble("01001101");
        BinaryScrabble LogicBin=BinSc1.logicalOr(BinSc2);
        BinaryScrabble expected=new BinaryScrabble("01000101");
        assertEquals(expected,LogicBin);
    }
    /**
     * Test que prueba el Patron Flyweigth para las
     * distintas clases Scrabble
     * */
    @Test public void FlyweigthTest(){
        StringScrabbleFactory SScF=new StringScrabbleFactory();
        StringScrabble SSc1=SScF.getScrabble("Hola");
        StringScrabble SSc2=SScF.getScrabble("Hola");
        assertEquals(SSc1,SSc2);
        assertEquals(SSc1,sType);
        assertTrue(SSc1==SSc2);
        assertFalse(SSc1==sType);

        BoolScrabbleFactory BScF=new BoolScrabbleFactory();
        BoolScrabble BSc1=BScF.getScrabble(true);
        BoolScrabble BSc2=BScF.getScrabble(true);
        assertEquals(BSc1,BSc2);
        assertEquals(BSc1,bType);
        assertTrue(BSc1==BSc2);
        assertFalse(BSc1==bType);

        FloatScrabbleFactory FScF=new FloatScrabbleFactory();
        FloatScrabble FSc1=FScF.getScrabble(2.4);
        FloatScrabble FSc2=FScF.getScrabble(2.4);
        assertEquals(FSc1,FSc2);
        assertEquals(FSc1,fType);
        assertTrue(FSc1==FSc2);
        assertFalse(FSc1==fType);

        IntScrabbleFactory IScF=new IntScrabbleFactory();
        IntScrabble ISc1=IScF.getScrabble(23);
        IntScrabble ISc2=IScF.getScrabble(23);
        assertEquals(ISc1,ISc2);
        assertEquals(ISc1,iType);
        assertTrue(ISc1==ISc2);
        assertFalse(ISc1==iType);

        BinaryScrabbleFactory BiScF=new BinaryScrabbleFactory();
        BinaryScrabble BiSc1=BiScF.getScrabble("00000010");
        BinaryScrabble BiSc2=BiScF.getScrabble("00000010");
        assertEquals(BiSc1,BiSc2);
        assertEquals(BiSc1,biType);
        assertTrue(BiSc1==BiSc2);
        assertFalse(BiSc1==biType);
    }
}
