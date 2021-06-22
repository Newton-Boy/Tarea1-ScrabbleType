package TiposScrabble;

public interface Scrabble {
    /**
     * Transforma un TiposScrabble.Scrabble a un TiposScrabble.StringScrabble
     */
    StringScrabble toStringSc();
    /**
     * Transforma un parametro de un Tipo TiposScrabble.Scrabble
     * y retorna el valor String de este.
     */
    @Override String toString();
}
