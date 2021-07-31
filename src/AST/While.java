package AST;
import TiposScrabble.Scrabble;
import Visitors.visitOperador;

import java.util.ArrayList;
import java.util.List;

public class While implements AST{
    private boolean Cond;
    private AST WhileTrue;
    private List<Scrabble> Lista=new ArrayList<Scrabble>();
    public While(boolean cond, AST whileTrue){
        Cond=cond;
        WhileTrue=whileTrue;
    }

    @Override
    public List<Scrabble> getList() {
        return null;
    }
}
