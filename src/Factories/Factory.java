package Factories;
import TiposScrabble.Scrabble;
import java.util.Hashtable;
import java.util.List;

public abstract class Factory implements Comparable{
    private Hashtable<List, Scrabble> hashtable=new Hashtable<>();
    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
