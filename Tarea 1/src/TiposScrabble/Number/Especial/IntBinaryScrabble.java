package TiposScrabble.Number.Especial;

import TiposScrabble.Number.NumberScrabble;

public interface IntBinaryScrabble extends NumberScrabble {
    /**
     * Transforma un TiposScrabble.Scrabble a un TiposScrabble.Number.IntBinary.IntScrabble
     */
    IntScrabble toIntSc();
    /**
     * Transforma un TiposScrabble.Scrabble a un TiposScrabble.Number.IntBinary.BinaryScrabble
     */
    BinaryScrabble toBinary();
    /**
     * Suma con prioridad en los Binarys,
     * retorna el valor binario de una suma entre NumberScrabbles
     */
    BinaryScrabble SumaBin(BinaryScrabble BinSc);
    /**
     * Producto con prioridad en los Binarys,
     * retorna el valor binario de un producto entre NumberScrabbles
     */
    BinaryScrabble ProductoBin(BinaryScrabble BinSc);
    /**
     * Transforma un numero entero en su equivalente binario
     */
    String IntToBinary(int I);
    /**
     * Transforma un numero entero en su equivalente binario positivo
     */
    String positiveIntToBinary(int I);
    /**
     * A partir de un complemento de un numero binario,
     * entrega el complemento dos que buscamos.
     */
    String nowIsTwoComplement(String b);
    /**
     * Intercambia 1s por 0s y viceversa dentro de un numero binario
     */
    String Complement(String bin);
    /**
     * Transforma un numero binario a su complemento dos
     */
    String twosComplement(String bin);
}
