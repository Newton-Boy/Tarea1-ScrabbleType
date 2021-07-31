import TiposScrabble.Number.BinaryScrabble;
import TiposScrabble.Number.IntScrabble;
import TiposScrabble.LogicScrabble;
import TiposScrabble.Number.FloatScrabble;
import TiposScrabble.StringScrabble;

public class Visitor {
    public void visitStringScrabble(StringScrabble Sc){}
    public void visitFloatScrabble(FloatScrabble Sc){}
    public void visitIntScrabble(IntScrabble Sc){}
    public void visitBinaryScrabble(BinaryScrabble Sc){}
    public void visitLogicScrabble(LogicScrabble Sc){}
}
