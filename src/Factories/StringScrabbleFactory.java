package Factories;

import Factories.ScrabbleFactory;
import TiposScrabble.Scrabble;
import TiposScrabble.StringScrabble;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class StringScrabbleFactory implements ScrabbleFactory{
    private Hashtable<List<String>,StringScrabble> hashtable=new Hashtable<>();

    public StringScrabble createScrabble(String string) {
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

    @Override
    public List<Scrabble> createScrabble() {
        return null;
    }
}
