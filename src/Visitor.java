import TiposScrabble.Number.Especial.BinaryScrabble;
import TiposScrabble.Number.Especial.IntScrabble;
import TiposScrabble.Number.Especial.LogicScrabble;
import TiposScrabble.Number.FloatScrabble;
import TiposScrabble.Number.NumberScrabble;
import TiposScrabble.StringScrabble;

public class Visitor {
    public void visitStringScrabble(StringScrabble Sc){}
    public void visitFloatScrabble(FloatScrabble Sc){}
    public void visitIntScrabble(IntScrabble Sc){}
    public void visitBinaryScrabble(BinaryScrabble Sc){}
    public void visitLogicScrabble(LogicScrabble Sc){}
}
