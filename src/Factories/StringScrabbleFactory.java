package Factories;

import TiposScrabble.Number.Especial.LogicScrabble;
import TiposScrabble.Number.NumberScrabble;
import TiposScrabble.Scrabble;
import TiposScrabble.StringScrabble;
import jdk.dynalink.Operation;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
/**
 * Fabrica Flyweigth de StringScrabble.
 * */
public class StringScrabbleFactory {
    private Hashtable<List<String>,StringScrabble> hashtable=new Hashtable<>();

    public StringScrabble getScrabble(String string) {
        String[] array= {string};
        List<String> key = Arrays.asList(array);
        StringScrabble Str = hashtable.get(key);
        if(Str != null)
            return Str;
        else {
            Str = new StringScrabble(string);
            hashtable.put(key, Str);
        }
        return Str;
    }
}
