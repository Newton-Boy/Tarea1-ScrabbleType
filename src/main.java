import TiposScrabble.AddScrabble;
import TiposScrabble.Number.Especial.BinaryScrabble;
import TiposScrabble.Number.Especial.BoolScrabble;
import TiposScrabble.Number.Especial.IntScrabble;
import TiposScrabble.Number.Especial.LogicScrabble;
import TiposScrabble.Number.FloatScrabble;
import TiposScrabble.Number.NumberScrabble;
import TiposScrabble.Scrabble;

public class main {
    /**
     * Dado una seríe de operaciones, que retornan un Scrabble. Imprime el resultado.
     * @param Sc
     */
    static void Ejemplo(Scrabble Sc){
        System.out.println("El resultado de esto es: "+Sc.toString());
    }
    /**
     * Operación Estática de suma/concatenación. Recibe 2 parametros Scrabble
     * @param sc1,sc2
     */
    public static AddScrabble Add(Scrabble sc1, Scrabble sc2){
        if(sc1 instanceof AddScrabble){
            return ((AddScrabble) sc1).Suma(sc2);
        }
        return null;
    }
    /**
     * Operación Estática de resta. Recibe 2 parametros Scrabble
     * @param sc1,sc2
     */
    public static NumberScrabble Sub(Scrabble sc1,Scrabble sc2){
        if(sc1 instanceof NumberScrabble && sc2 instanceof NumberScrabble){
            return ((NumberScrabble)sc1).Resta((NumberScrabble) sc2);
        }
        else{
            return null;
        }
    }
    /**
     * Operación Estática de producto. Recibe 2 parametros Scrabble
     * @param sc1,sc2
     */
    public static NumberScrabble Product(Scrabble sc1, Scrabble sc2) {
        if (sc1 instanceof NumberScrabble && sc2 instanceof NumberScrabble) {
            return ((NumberScrabble) sc1).Producto((NumberScrabble) sc2);
        } else {
            return null;
        }
    }
    /**
     * Operación Estática de división. Recibe 2 parametros Scrabble
     * @param sc1,sc2
     */
    public static NumberScrabble Division(Scrabble sc1, Scrabble sc2){
        if (sc1 instanceof NumberScrabble && sc2 instanceof NumberScrabble) {
            return ((NumberScrabble) sc1).División((NumberScrabble) sc2);
        } else {
            return null;
        }
    }
    /**
     * Operación Estática de O lógico. Recibe 2 parametros Scrabble
     * @param (Sc1, Sc2)
     */
    public static LogicScrabble Or(Scrabble Sc1, Scrabble Sc2){
        if(Sc1 instanceof BoolScrabble && Sc2 instanceof BoolScrabble){
            return ((BoolScrabble) Sc1).logicalOr((BoolScrabble) Sc2);
        }
        if(Sc1 instanceof BinaryScrabble && Sc2 instanceof BinaryScrabble){
            return ((BinaryScrabble) Sc1).logicalOr((BinaryScrabble) Sc2);
        }
        if(Sc1 instanceof BoolScrabble && Sc2 instanceof BinaryScrabble){
            return ((BoolScrabble) Sc1).logicalOr((BinaryScrabble) Sc2);
        }
        else {
            return null;
        }
    }
    /**
     * Operación Estática de Y lógico. Recibe 2 parametros Scrabble
     * @param (Sc1, Sc2)
     */
    public static LogicScrabble And(Scrabble Sc1, Scrabble Sc2){
        if(Sc1 instanceof BoolScrabble && Sc2 instanceof BoolScrabble){
            return ((BoolScrabble) Sc1).logicalAnd((BoolScrabble) Sc2);
        }
        if(Sc1 instanceof BinaryScrabble && Sc2 instanceof BinaryScrabble){
            return ((BinaryScrabble) Sc1).logicalAnd((BinaryScrabble) Sc2);
        }
        if(Sc1 instanceof BoolScrabble && Sc2 instanceof BinaryScrabble){
            return ((BoolScrabble) Sc1).logicalAnd((BinaryScrabble) Sc2);
        }
        else {
            return null;
        }
    }
    public static void main(String[] args){
        /*Aquí cabe destacar que el ejemplo original carece de sentido al final, pues un Scrabble binario,
        * operarse de izquierda a derecha con un FloatScrabble, por ello se ha cambiado respecto
        * del ejemplo respectivamente.*/
        Scrabble Sc1= Add(new FloatScrabble(6.9),Or(new BinaryScrabble("00001000"),Sub(new IntScrabble(25),new BinaryScrabble("00000101")).toBinary()));
        Scrabble Sc2= Product(Or(new BoolScrabble(false),Division(new BinaryScrabble("00010100"),new IntScrabble(5))),And(new BoolScrabble(true),new BinaryScrabble("00000110")));
        Ejemplo(Sc1);
        Ejemplo(Sc2);
    }
}