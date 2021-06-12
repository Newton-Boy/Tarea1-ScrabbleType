import TiposScrabble.*;
import TiposScrabble.Number.Especial.BoolScrabble;
import TiposScrabble.Number.Especial.BinaryScrabble;
import TiposScrabble.Number.FloatScrabble;
import TiposScrabble.Number.Especial.IntScrabble;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


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
    @Test void multiplyString(){
        String expected="0000";
        String Bi=new String(new char[4]).replace("\0", "0");
        assertEquals(expected,Bi);
    }
    @Test void positiveIntToBinTest(){
        String b= iType.positiveIntToBinary(8);
        String expected ="00001000";
        assertEquals(expected,b);
    }
    @Test void  nowIsTwoComplementTest(){
        String B=iType.nowIsTwoComplement("1001");
        String expected="1010";
        assertEquals(expected,B);
    }
    @Test void  ComplementTest(){
        String b=iType.Complement("0110");
        String expected ="1001";
        assertEquals(expected,b);
    }
    @Test void twosComplementTest(){
        String b= iType.twosComplement("0110");
        String expected ="1010";
        assertEquals(expected,b);
    }
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

    @Test
    void TestStringScToStringSc(){
        StringScrabble expected= sType.toStringSc();
        assertEquals(expected,sType);
    }
    @Test void TestBoolToStringSc(){
        StringScrabble expected=new StringScrabble("true");
        StringScrabble B= bType.toStringSc();
        assertEquals(expected,B);
    }
    @Test void TestFloatToStringSc(){
        StringScrabble expected=new StringScrabble("2.4");
        StringScrabble F= fType.toStringSc();
        assertEquals(expected,F);
    }
    @Test void TestIntScToStringSc(){
        StringScrabble expected=new StringScrabble("23");
        StringScrabble I= iType.toStringSc();
        assertEquals(expected,I);
    }
    @Test void TestBinaryToStringSc(){
        StringScrabble expected=new StringScrabble("00000010");
        StringScrabble Bi= biType.toStringSc();
        assertEquals(expected,Bi);
    }
    @Test void TestBoolToBool(){
        BoolScrabble expected= bType.toBool();
        assertEquals(expected,bType);
    }
    @Test void TestFloatToFloat(){
        FloatScrabble expected=  fType.toFloat();
        assertEquals(expected,fType);
    }
    @Test void TestIntScToFloat(){
        FloatScrabble expected= new FloatScrabble(23.0);
        FloatScrabble newFloat=  iType.toFloat();
        assertEquals(expected,newFloat);
    }
    @Test public void TestBinaryToFloat(){
        FloatScrabble expected= new FloatScrabble(2.0);
        FloatScrabble newFloat= biType.toFloat();
        assertEquals(expected,newFloat);
    }
    @Test public void TestIntScToIntSc(){
        IntScrabble expected= iType.toIntSc();
        assertEquals(expected,iType);
    }
    @Test void TestBinaryToIntSc(){
        IntScrabble expected= new IntScrabble(2);
        IntScrabble newInt= biType.toIntSc();
        assertEquals(expected,newInt);
    }
    @Test void TestIntToBinary() {
        String B = iType.IntToBinary(23);
        String expected = "00010111";
        assertEquals(expected, B);
    }
    @Test void TestIntScToBinary(){
        BinaryScrabble expected= new BinaryScrabble("00010111");
        BinaryScrabble newBinary= iType.toBinary();
        assertEquals(expected,newBinary);
    }
    @Test void TestBinaryToBinary(){
        BinaryScrabble expected= biType.toBinary();
        assertEquals(expected,biType);
    }
    @Test void SumaStringStringTest(){
        StringScrabble StringSc= new StringScrabble("Adios");
        StringScrabble StringSum= sType.SumaString(StringSc);
        StringScrabble expected= new StringScrabble("HolaAdios");
        assertEquals(expected,StringSum);
    }
    @Test void SumaStringBoolTest(){
        StringScrabble StringSum= sType.SumaString(bType);
        StringScrabble expected= new StringScrabble("Holatrue");
        assertEquals(expected,StringSum);
    }
    @Test void SumaStringFloatTest(){
        StringScrabble StringSum= sType.SumaString(fType);
        StringScrabble expected= new StringScrabble("Hola2.4");
        assertEquals(expected,StringSum);
    }
    @Test void SumaStringIntTest(){
        StringScrabble StringSum= sType.SumaString(iType);
        StringScrabble expected= new StringScrabble("Hola23");
        assertEquals(expected,StringSum);
    }
    @Test void SumaStringBinaryTest(){
        StringScrabble StringSum= sType.SumaString(biType);
        StringScrabble expected= new StringScrabble("Hola00000010");
        assertEquals(expected,StringSum);
    }
    @Test void SumaFloatFloatTest(){
        FloatScrabble FloatSc = new FloatScrabble(5.1);
        FloatScrabble FloatSum= fType.Suma(FloatSc);
        FloatScrabble expected= new FloatScrabble(7.5);
        assertEquals(expected,FloatSum);
    }
    @Test void SumaFloatIntTest(){
        FloatScrabble FloatSum= fType.Suma(iType);
        FloatScrabble expected= new FloatScrabble(25.4);
        assertEquals(expected,FloatSum);
    }
    @Test void SumaFloatBinaryTest(){
        FloatScrabble FloatSum= fType.Suma(biType);
        FloatScrabble expected= new FloatScrabble(4.4);
        assertEquals(expected,FloatSum);
    }
    @Test void SumaIntFloatTest(){
        IntScrabble IntSum= iType.Suma(fType);
        IntScrabble expected= new IntScrabble(25);
        assertEquals(expected,IntSum);
    }
    @Test void SumaIntIntTest(){
        IntScrabble IntSc = new IntScrabble(-7);
        IntScrabble IntSum= iType.Suma(IntSc);
        IntScrabble expected= new IntScrabble(16);
        assertEquals(expected,IntSum);
    }
    @Test void SumaIntBinaryTest(){
        IntScrabble IntSum= iType.Suma(biType);
        IntScrabble expected= new IntScrabble(25);
        assertEquals(expected,IntSum);
    }
    @Test void SumaBinaryIntTest(){
        BinaryScrabble BinarySum= biType.Suma(iType);
        BinaryScrabble expected= new BinaryScrabble("00011001");
        assertEquals(expected,BinarySum);
    }
    @Test void SumaBinaryBinaryTest(){
        BinaryScrabble BinarySc = new BinaryScrabble("11111100");
        BinaryScrabble BinarySum= biType.Suma(BinarySc);
        BinaryScrabble expected= new BinaryScrabble("11111110");
        assertEquals(expected,BinarySum);
    }
    @Test void RestaFloatFloatTest(){
        FloatScrabble FloatSc = new FloatScrabble(5.1);
        FloatScrabble FloatSum= fType.Resta(FloatSc);
        FloatScrabble expected= new FloatScrabble(-2.7);
        assertEquals(expected,FloatSum);
    }
    @Test void RestaFloatIntTest(){
        FloatScrabble FloatSum= fType.Resta(iType);
        FloatScrabble expected= new FloatScrabble(-20.6);
        assertEquals(expected,FloatSum);
    }
    @Test void RestaFloatBinaryTest(){
        FloatScrabble FloatSum= fType.Resta(biType);
        FloatScrabble expected= new FloatScrabble(0.4);
        assertEquals(expected,FloatSum);
    }
    @Test void RestaIntFloatTest(){
        IntScrabble IntSum= iType.Resta(fType);
        IntScrabble expected= new IntScrabble(21);
        assertEquals(expected,IntSum);
    }
    @Test void RestaIntIntTest(){
        IntScrabble IntSc = new IntScrabble(-7);
        IntScrabble IntSum= iType.Resta(IntSc);
        IntScrabble expected= new IntScrabble(30);
        assertEquals(expected,IntSum);
    }
    @Test void RestaIntBinaryTest(){
        IntScrabble IntSum= iType.Resta(biType);
        IntScrabble expected= new IntScrabble(21);
        assertEquals(expected,IntSum);
    }
    @Test void RestaBinaryIntTest(){
        BinaryScrabble BinarySum= biType.Resta(iType);
        BinaryScrabble expected= new BinaryScrabble("11101011");
        assertEquals(expected,BinarySum);
    }
    @Test void RestaBinaryBinaryTest(){
        BinaryScrabble BinarySc = new BinaryScrabble("11111100");
        BinaryScrabble BinarySum= biType.Resta(BinarySc);
        BinaryScrabble expected= new BinaryScrabble("00000110");
        assertEquals(expected,BinarySum);
    }
    @Test void ProductoFloatFloatTes(){
        FloatScrabble FloatSc= new FloatScrabble(3.2);
        FloatScrabble Producto =fType.Producto(FloatSc);
        FloatScrabble expected= new FloatScrabble(7.68);
        assertEquals(expected,Producto);
    }
    @Test void ProductoFloatIntTes(){
        FloatScrabble Producto =fType.Producto(iType);
        FloatScrabble expected= new FloatScrabble(55.2);
        assertEquals(expected,Producto);
    }
    @Test void ProductoFloatBinaryTes(){
        FloatScrabble Producto =fType.Producto(biType);
        FloatScrabble expected= new FloatScrabble(4.8);
        assertEquals(expected,Producto);
    }
    @Test void ProductoIntFloatTes(){
        IntScrabble Producto =iType.Producto(fType);
        IntScrabble expected= new IntScrabble(55);
        assertEquals(expected,Producto);
    }
    @Test void ProductoIntIntTes(){
        IntScrabble IntSc= new IntScrabble(3);
        IntScrabble Producto =iType.Producto(IntSc);
        IntScrabble expected= new IntScrabble(69);
        assertEquals(expected,Producto);
    }
    @Test void ProductoIntBinaryTes(){
        IntScrabble Producto =iType.Producto(biType);
        IntScrabble expected= new IntScrabble(46);
        assertEquals(expected,Producto);
    }
    @Test void ProductoBinaryIntTes(){
        BinaryScrabble Producto =biType.Producto(iType);
        BinaryScrabble expected= new BinaryScrabble("00101110");
        assertEquals(expected,Producto);
    }
    @Test void ProductoBinaryBinaryTes(){
        BinaryScrabble BinSc= new BinaryScrabble("00010101");
        BinaryScrabble Producto =biType.Producto(BinSc);
        BinaryScrabble expected= new BinaryScrabble("00101010");
        assertEquals(expected,Producto);
    }
    @Test void DivisiónFloatFloatTes(){
        FloatScrabble FloatSc= new FloatScrabble(3.2);
        FloatScrabble División =fType.División(FloatSc);
        FloatScrabble expected= new FloatScrabble(0.75);
        assertEquals(expected,División);
    }
    @Test void DivisiónFloatIntTes(){
        FloatScrabble División =fType.División(iType);
        FloatScrabble expected= new FloatScrabble(0.1043);
        assertEquals(expected,División);
    }
    @Test void DivisiónFloatBinaryTes(){
        FloatScrabble División =fType.División(biType);
        FloatScrabble expected= new FloatScrabble(1.2);
        assertEquals(expected,División);
    }
    @Test void DivisiónIntFloatTes(){
        IntScrabble División =iType.División(fType);
        IntScrabble expected= new IntScrabble(10);
        assertEquals(expected,División);
    }
    @Test void DivisiónIntIntTes(){
        IntScrabble IntSc= new IntScrabble(3);
        IntScrabble División =iType.División(IntSc);
        IntScrabble expected= new IntScrabble(8);
        assertEquals(expected,División);
    }
    @Test void DivisiónIntBinaryTes(){
        IntScrabble División =iType.División(biType);
        IntScrabble expected= new IntScrabble(12);
        assertEquals(expected,División);
    }
    @Test void DivisiónBinaryIntTes(){
        BinaryScrabble División =biType.División(iType);
        BinaryScrabble expected= new BinaryScrabble("00000000");
        assertEquals(expected,División);
    }
    @Test void DivisiónBinaryBinaryTes(){
        BinaryScrabble BinSc= new BinaryScrabble("00010101");
        BinaryScrabble División =BinSc.División(biType);
        BinaryScrabble expected= new BinaryScrabble("00001011");
        assertEquals(expected,División);
    }
    @Test void NegaciónLogicaBoolTest(){
        BoolScrabble NegaBool=bType.Negación();
        BoolScrabble expected=new BoolScrabble(false);
        assertEquals(expected,NegaBool);
    }
    @Test void NegaciónLogicaBinaryTest(){
        BinaryScrabble NegaBin=biType.Negación();
        BinaryScrabble expected=new BinaryScrabble("11111101");
        assertEquals(expected,NegaBin);
    }

    @Test void logicalBoolAndBoolTest(){
        BoolScrabble expectedFalse=new BoolScrabble(false);
        BoolScrabble expectedTrue=new BoolScrabble(true);
        BoolScrabble False =new BoolScrabble(false);
        BoolScrabble trueAndFalse=bType.andBool(False);
        BoolScrabble falseAndTrue=False.logicalAnd(bType);
        BoolScrabble falseAndFalse=False.logicalAnd(False);
        BoolScrabble trueAndTrue=bType.logicalAnd(bType);
        assertEquals(expectedFalse,trueAndFalse);
        assertEquals(expectedFalse,falseAndTrue);
        assertEquals(expectedFalse,falseAndFalse);
        assertEquals(expectedTrue,trueAndTrue);
    }
    @Test void logicalAndBoolBinTest(){
        BinaryScrabble BinSc1 =new BinaryScrabble("01100101");
        BoolScrabble False=new BoolScrabble(false);
        BinaryScrabble trueAndBin=  bType.logicalAnd(BinSc1);
        BinaryScrabble falseAndBin= False.logicalAnd(BinSc1);
        BinaryScrabble expectedTrueBin=new BinaryScrabble("01100101");
        BinaryScrabble expectedFalseBin=new BinaryScrabble("11111111");
        assertEquals(expectedTrueBin,trueAndBin);
        assertEquals(expectedFalseBin,falseAndBin);
    }
    @Test void logicalAndBinBinTest(){
        BinaryScrabble BinSc1 =new BinaryScrabble("01100101");
        BinaryScrabble BinSc2 =new BinaryScrabble("01001101");
        BinaryScrabble LogicBin=BinSc1.logicalAnd(BinSc2);
        BinaryScrabble expected=new BinaryScrabble("01101101");
        assertEquals(expected,LogicBin);
    }

    @Test void logicalOrBoolBoolTest(){
        BoolScrabble expectedFalse=new BoolScrabble(false);
        BoolScrabble expectedTrue=new BoolScrabble(true);
        BoolScrabble False =new BoolScrabble(false);
        BoolScrabble trueOrFalse= bType.logicalOr(False);
        BoolScrabble falseOrTrue= False.logicalOr(bType);
        BoolScrabble falseOrFalse= False.logicalOr(False);
        BoolScrabble trueOrTrue= bType.logicalOr(bType);
        assertEquals(expectedTrue,trueOrFalse);
        assertEquals(expectedTrue,falseOrTrue);
        assertEquals(expectedFalse,falseOrFalse);
        assertEquals(expectedTrue,trueOrTrue);
    }
    @Test void logicalOrBoolBinTest(){
        BinaryScrabble BinSc1 =new BinaryScrabble("01100101");
        BoolScrabble False=new BoolScrabble(false);
        BinaryScrabble trueOrBin=  bType.logicalOr(BinSc1);
        BinaryScrabble falseOrBin= False.logicalOr(BinSc1);
        BinaryScrabble expectedTrueBin=new BinaryScrabble("00000000");
        BinaryScrabble expectedFalseBin=new BinaryScrabble("01100101");
        assertEquals(expectedTrueBin,trueOrBin);
        assertEquals(expectedFalseBin,falseOrBin);
    }
    @Test void logicalOrBinBinTest(){
        BinaryScrabble BinSc1 =new BinaryScrabble("01100101");
        BinaryScrabble BinSc2 =new BinaryScrabble("01001101");
        BinaryScrabble LogicBin=BinSc1.logicalOr(BinSc2);
        BinaryScrabble expected=new BinaryScrabble("01000101");
        assertEquals(expected,LogicBin);
    }
}
