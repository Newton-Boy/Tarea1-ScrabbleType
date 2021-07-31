package Factories;

import TiposScrabble.Number.FloatScrabble;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
/**
 * Fabrica Flyweigth de FloatScrabble.
 * */
public class FloatScrabbleFactory {
    private Hashtable<List<Double>, FloatScrabble> hashtable=new Hashtable<>();

    public FloatScrabble getScrabble(double number) {
        Double[] array= {number};
        List<Double> key = Arrays.asList(array);
        FloatScrabble Num = hashtable.get(key);
        if(Num != null)
            return Num;
        else {
            Num = new FloatScrabble(number);
            hashtable.put(key, Num);
        }
        return Num;
    }
}
