package AST;

import TiposScrabble.Number.IntScrabble;

import java.util.List;

public class CompareTo implements AST{
    private IntScrabble ISc;

    @Override
    public List getList() {
        return null;
    }
    /**
    public void visitStringScrabble(StringScrabble Sc1, Scrabble Sc2){
        String St1=Sc1.toString();
        String St2=Sc2.toString();
        IntScrabbleFactory IScF=new IntScrabbleFactory();
        int Bool= St1.compareTo(St2);
        ISc=IScF.getScrabble(Bool);
    }
    public void visitFloatScrabble(FloatScrabble Sc1, NumberScrabble Sc2){
        double St1=Sc1.getFloat();
        double St2=(Double) Sc2.getValue();
        IntScrabbleFactory IScF=new IntScrabbleFactory();
        if (St1>St2){
            ISc=IScF.getScrabble(1);
        }
        if (St1<St2){
            ISc=IScF.getScrabble(-1);
        }
        else {
            ISc=IScF.getScrabble(0);
        }
    }
    public void visitIntScrabble(IntScrabble Sc1, NumberScrabble Sc2){
        int St1=Sc1.getInt();
        int St2=(Integer) Sc2.getValue();
        IntScrabbleFactory IScF=new IntScrabbleFactory();
        if (St1>St2){
            ISc=IScF.getScrabble(1);
        }
        if (St1<St2){
            ISc=IScF.getScrabble(-1);
        }
        else {
            ISc=IScF.getScrabble(0);
        }
    }
    public void visitBinaryScrabble(BinaryScrabble Sc1, Scrabble Sc2){
        IntScrabbleFactory IScF=new IntScrabbleFactory();
        if(Sc2 instanceof NumberScrabble){
            IntScrabble Int=Sc1.toIntSc();
            int St1=Int.getInt();
            int St2=(Integer) ((NumberScrabble) Sc2).getValue();
            if (St1>St2){
                ISc=IScF.getScrabble(1);
            }
            if (St1<St2){
                ISc=IScF.getScrabble(-1);
            }
            else {
                ISc=IScF.getScrabble(0);
            }
        }
        if(Sc2 instanceof LogicScrabble){
            visitOperador Op=new CompareTo();
            IntScrabble Int=Sc1.toIntSc();
            BinaryScrabble Bin=Sc1.logicalOr((LogicScrabble) Sc2);
            Int.accept(Op,Bin);
            ISc=(IntScrabble) Op.getResult();
        }
    }
    public void visitBoolScrabble(BoolScrabble Sc1, LogicScrabble Sc2){

    }
    public IntScrabble getResult(){
        return ISc;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof )
        return 0;
    }
    */
}
