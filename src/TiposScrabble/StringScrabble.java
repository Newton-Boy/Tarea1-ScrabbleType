package TiposScrabble;

/**
 * Clase StringScrabble es un Scrabble con un
 * parametro Tipo String
 */
public class StringScrabble implements AddScrabble{
    private String String;
    public StringScrabble(String string){
        String=string;
    }
    /**
     * Retorna el parametro de StringScrabble
     */
    public StringScrabble(){
        String="";
    }
    public String getString(){
        return String;
    }

    /**
     * Cambia el parametro String de un
     * TiposScrabble.StringScrabble dado
     */
    public void setString(String aString) {
        String = aString;
    }

    @Override
    public String toString(){
        return this.getString();
    }
    @Override
    public StringScrabble toStringSc() {
        return this;
    }

    /**
     * Override del metodo equals para TiposScrabble.StringScrabble
     */
    @Override
    public boolean equals(Object O){
        if(O instanceof StringScrabble){
            var Sc= (StringScrabble) O;
            return Sc.String.equals(String);
        }
        return false;
    }
    /**
     * Suma que concatena los valores String de
     * los parametros de 2 TiposScrabble.Scrabble
     */
    @Override
    public StringScrabble Suma(Scrabble SC){
        String S1=this.toString();
        String S2= SC.toString();
        return new StringScrabble(S1+S2);
    }
}
