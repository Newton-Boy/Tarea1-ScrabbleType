package AST;

import TiposScrabble.Scrabble;
import Visitors.visitOperador;

public class If extends visitOperador {
    private boolean Cond;
    private visitOperador V1;
    private visitOperador V2;
    public If(boolean cond,visitOperador ifTrue,visitOperador ifFalse){
        Cond=cond;
        V1=ifTrue;
        V2=ifFalse;
    }
    public Scrabble getResult(){
        if(Cond==true){
            return V1.getResult();
        }
        else {
            return V2.getResult();
        }
    }
}
