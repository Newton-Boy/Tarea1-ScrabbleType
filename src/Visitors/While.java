package Visitors;
import TiposScrabble.Scrabble;

import java.util.ArrayList;

public class While extends visitOperador{
    private boolean Cond;
    private visitOperador WhileTrue;
    public While(boolean cond, visitOperador whileTrue){
        Cond=cond;
        WhileTrue=whileTrue;
    }
}
