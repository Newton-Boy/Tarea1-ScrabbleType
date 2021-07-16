package TiposScrabble;

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
}
