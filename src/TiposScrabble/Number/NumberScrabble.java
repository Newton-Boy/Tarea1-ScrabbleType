package TiposScrabble.Number;

import TiposScrabble.AddScrabble;
import TiposScrabble.Number.Especial.BinaryScrabble;
import TiposScrabble.Number.Especial.IntScrabble;
import TiposScrabble.Scrabble;

public interface NumberScrabble extends AddScrabble {
    /**
     * Transforma un TiposScrabble.Scrabble a un TiposScrabble.Number.FloatScrabble
     */
    FloatScrabble toFloat();

    BinaryScrabble toBinary();

    /**
     * Transforma un TiposScrabble.Number.NumberScrabble en su
     * opouesto aditivo
     */
    NumberScrabble Opuesto();
    /**
     * Opera Suma aritmetica entre 2 TiposScrabble.Number.NumberScrabble
     */
    @Override
    NumberScrabble Suma(Scrabble Num);
    /**
     * Suma con prioridad en los Integers,
     * retorna el valor entero de una suma entre NumberScrabbles
     */
    IntScrabble SumaInt(IntScrabble IntSc);
    /**
     * Suma con prioridad en los Floats,
     * retorna el valor real (flotante) de una suma entre NumberScrabbles
     */
    FloatScrabble SumaFloat(FloatScrabble FloatSc);
    /**
     * Opera Resta aritmetica entre 2 TiposScrabble.Number.NumberScrabble
     */
    NumberScrabble Resta(NumberScrabble Num);
    /**
     * Opera Producto aritmetico entre 2 TiposScrabble.Number.NumberScrabble
     */
    NumberScrabble Producto(NumberScrabble Num);
    /**
     * Producto con prioridad en los Integers,
     * retorna el valor entero de un producto entre NumberScrabbles
     */
    IntScrabble ProductoInt(IntScrabble IntSc);
    /**
     * Producto con prioridad en los Floats,
     * retorna el valor real/flotante de un producto entre NumberScrabbles
     */
    FloatScrabble ProductoFloat(FloatScrabble FloatSc);

    /**
     * Transforma un TiposScrabble.Number.NumberScrabble en su
     * opouesto multiplicativo
     */
    FloatScrabble Inverso();
    /**
     * Opera Producto aritmetico entre 2 TiposScrabble.Number.NumberScrabble
     */
    NumberScrabble División(NumberScrabble Num);
}
