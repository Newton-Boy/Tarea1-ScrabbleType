package TiposScrabble.Number;

import TiposScrabble.AddScrabble;
import TiposScrabble.Number.Especial.BinaryScrabble;
import TiposScrabble.Number.Especial.IntScrabble;
import TiposScrabble.Scrabble;

public interface NumberScrabble extends AddScrabble {
    Number getValue();
    /**
     * Transforma un NumberScrabble a un FloatScrabble
     */
    FloatScrabble toFloat();

    /**
     * Transforma un NumberScrabble a un BinaryScrabble
     */
    BinaryScrabble toBinary();

    /**
     * Transforma un NumberScrabble en su opouesto aditivo
     */
    NumberScrabble Opuesto();
    /**
     * Opera Suma aritmetica entre 2 NumberScrabble
     * @param Num
     */
    @Override
    NumberScrabble Suma(Scrabble Num);
    /**
     * Suma con prioridad en los Integers,
     * retorna el valor entero de una suma entre NumberScrabbles
     * @param IntSc
     */
    IntScrabble SumaInt(IntScrabble IntSc);
    /**
     * Suma con prioridad en los Floats,
     * retorna el valor real (flotante) de una suma entre NumberScrabbles
     * @param FloatSc
     */
    FloatScrabble SumaFloat(FloatScrabble FloatSc);
    /**
     * Opera Resta aritmetica entre 2 NumberScrabble
     * @param Num
     */
    NumberScrabble Resta(NumberScrabble Num);
    /**
     * Opera Producto aritmetico entre 2 NumberScrabble
     * @param Num
     */
    NumberScrabble Producto(NumberScrabble Num);
    /**
     * Producto con prioridad en los Integers,
     * retorna el valor entero de un producto entre NumberScrabbles
     * @param IntSc
     */
    IntScrabble ProductoInt(IntScrabble IntSc);
    /**
     * Producto con prioridad en los Floats,
     * retorna el valor real (flotante) de un producto entre NumberScrabbles
     * @param FloatSc
     */
    FloatScrabble ProductoFloat(FloatScrabble FloatSc);

    /**
     * Transforma un NumberScrabble en su opouesto multiplicativo
     */
    FloatScrabble Inverso();
    /**
     * Opera división aritmetica entre 2 NumberScrabble
     * @param Num
     */
    NumberScrabble División(NumberScrabble Num);
}
