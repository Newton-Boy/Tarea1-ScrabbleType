package Factories;

import TiposScrabble.Number.Especial.IntScrabble;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
/**
 * Fabrica Flyweigth de IntScrabble.
 * */
public class IntScrabbleFactory {
    private Hashtable<List<Integer>, IntScrabble> hashtable=new Hashtable<>();

    public IntScrabble getScrabble(int number) {
        Integer[] array= {number};
        List<Integer> key = Arrays.asList(array);
        IntScrabble Num = hashtable.get(key);
        if(Num != null)
            return Num;
        else {
            Num = new IntScrabble(number);
            hashtable.put(key, Num);
        }
        return Num;
    }
}
