package Factories;

import TiposScrabble.BoolScrabble;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
/**
 * Fabrica Flyweigth de BoolScrabble.
 * */
public class BoolScrabbleFactory extends Factory{
    private Hashtable<List<Boolean>, BoolScrabble> hashtable=new Hashtable<>();

    public BoolScrabble getScrabble(boolean bool) {
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
