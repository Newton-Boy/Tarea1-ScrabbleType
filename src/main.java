/**
import TiposScrabble.AddScrabble;
import TiposScrabble.Number.Especial.BinaryScrabble;
import TiposScrabble.Number.Especial.IntScrabble;
import TiposScrabble.Number.Especial.LogicScrabble;
import TiposScrabble.Number.FloatScrabble;
import TiposScrabble.Number.NumberScrabble;
import TiposScrabble.Scrabble;
import TiposScrabble.Operation.*;

public class main {
    static void Ejemplo(Scrabble Sc){
        System.out.println("El resultado de esto es: "+Sc.toString());
    }
    public static void main(String[] args){
        Scrabble Sc= new Add(new Or(new BinaryScrabble("00001000"),new Sub(new IntScrabble(25),new BinaryScrabble("00000101")).Operate().toBinary()).Operate(),new FloatScrabble(6.9)).Operate();
        Ejemplo(Sc);
    }
}
 */