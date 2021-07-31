package TiposScrabble;

import Visitors.visitOperador;

import java.rmi.server.Operation;

public interface Scrabble {
    /**
     * Transforma un Scrabble a un StringScrabble
     */
    StringScrabble toStringSc();
    /**
     * Transforma un parametro de un Tipo Scrabble
     * y retorna el valor String de este.
     */
    @Override String toString();

    void accept(visitOperador aOperador, Scrabble Sc);
}
