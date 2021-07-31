package Factories;

import TiposScrabble.Number.BinaryScrabble;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
/**
 * Fabrica Flyweigth de BinaryScrabble.
 * */
public class BinaryScrabbleFactory {
    private Hashtable<List<String>, BinaryScrabble> hashtable=new Hashtable<>();

    public BinaryScrabble getScrabble(String number) {
        String[] array= {number};
        List<String> key = Arrays.asList(array);
        BinaryScrabble Num = hashtable.get(key);
        if(Num != null)
            return Num;
        else {
            Num = new BinaryScrabble(number);
            hashtable.put(key, Num);
        }
        return Num;
    }
}
