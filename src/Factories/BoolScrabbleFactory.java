package Factories;

import TiposScrabble.Number.Especial.BoolScrabble;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class BoolScrabbleFactory {
    private Hashtable<List<Boolean>, BoolScrabble> hashtable=new Hashtable<>();

    public BoolScrabble createScrabble(boolean bool) {
        Boolean[] array= {bool};
        List<Boolean> key = Arrays.asList(array);
        BoolScrabble Bool = hashtable.get(key);
        if(Bool != null)
            return Bool;
        else {
            Bool = new BoolScrabble(bool);
            hashtable.put(key, Bool);
        }
        return Bool;
    }
}
