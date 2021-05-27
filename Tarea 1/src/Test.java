import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;


class TestScrabble {
    private StringScrabble sType;
    private BoolScrabble bType;
    private NumberScrabble fType;
    private NumberScrabble iType;
    private NumberScrabble biType;

    @BeforeEach
    public void setUp(){
        sType=new StringScrabble("Hola");
        bType= new BoolScrabble(true);
        fType= new FloatScrabble(2.4);
        iType= new IntScrabble(23);
        biType= new BinaryScrabble("00000010");
    }
    public boolean assertEquals(String l1, String l2){
        return(l1.equals(l2));
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
    @Test public void TestStringScToStringSc(){
        StringScrabble expected= new StringScrabble("Hola");
        StringScrabble newString= expected.toStringSc(sType);
        assertEquals(expected,newString);
    }
    @Test public void TestBoolToStringSc(){
        StringScrabble expected= new StringScrabble("true");
        StringScrabble newString= expected.toStringSc(bType);
        assertEquals(expected,newString);
    }
    @Test public void TestFloatToStringSc(){
        StringScrabble expected= new StringScrabble("2.4");
        StringScrabble newString= expected.toStringSc(fType);
        assertEquals(expected,newString);
    }
    @Test public void TestIntScToStringSc(){
        StringScrabble expected= new StringScrabble("23");
        StringScrabble newString= expected.toStringSc(iType);
        assertEquals(expected,newString);
    }
    @Test public void TestBinaryToStringSc(){
        StringScrabble expected= new StringScrabble("00000010");
        StringScrabble newString= expected.toStringSc(biType);
        assertEquals(expected,newString);
    }
    @Test public void TestBoolToBool(){
        BoolScrabble expected= new BoolScrabble(true);
        BoolScrabble newBool= new expected.toBool(bType);
        assertEquals(expected,newBool);
    }

    @Test public void TestFloatToFloat(){
        FloatScrabble expected= new FloatScrabble(2.4);
        FloatScrabble newFloat= new toFloat(fType);
        assertEquals(expected,newFloat);
    }
    @Test public void TestIntScToFloat(){
        FloatScrabble expected= new FloatScrabble(23.0);
        FloatScrabble newFloat= new toFloat(iType);
        assertEquals(expected,newFloat);
    }
    @Test public void TestBinaryToFloat(){
        FloatScrabble expected= new FloatScrabble(2.0);
        FloatScrabble newFloat= new toFloat(biType);
        assertEquals(expected,newFloat);
    }
    @Test public void TestIntScToIntSc(){
        IntScrabble expected= new IntScrabble(23);
        IntScrabble newInt= new toIntSc(iType);
        assertEquals(expected,newInt);
    }
    @Test public void TestBinaryToIntSc(){
        IntScrabble expected= new IntScrabble(2);
        IntScrabble newInt= new toIntSc(biType);
        assertEquals(expected,newInt);
    }
    @Test public void TestIntScToBinary(){
        BinaryScrabble expected= new BinaryScrabble("00010111");
        BinaryScrabble newBinary= new toBinary(iType);
        assertEquals(expected,newBinary);
    }
    @Test public void TestBinaryToBinary(){
        BinaryScrabble expected= new BinaryScrabble("00000010");
        BinaryScrabble newBinary= new toBinary(biType);
        assertEquals(expected,newBinary);
    }
}
