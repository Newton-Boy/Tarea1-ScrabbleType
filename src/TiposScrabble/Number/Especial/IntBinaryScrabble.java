package TiposScrabble.Number.Especial;

import TiposScrabble.Number.NumberScrabble;

public interface IntBinaryScrabble extends NumberScrabble {
    /**
     * Transforma un IntBinaryScrabble a un IntScrabble
     */
    IntScrabble toIntSc();
    /**
     * Suma con prioridad en los Binarys.
     * Retorna un BinaryScrabble con un valor igual a la suma entre IntBinaryScrabbles
     * @param BinSc
     */
    BinaryScrabble SumaBin(BinaryScrabble BinSc);
    /**
     * Producto con prioridad en los Binarys.
     * Retorna un BinaryScrabble con un valor igual al producto entre IntBinaryScrabble
     * @param BinSc
     */
    BinaryScrabble ProductoBin(BinaryScrabble BinSc);
    /**
     * Transforma un numero entero en su string binario equivalente
     * @param I
     */
    String IntToBinary(int I);
    /**
     * Transforma un numero entero en su string binario positivo equivalente
     * @param I
     */
    String positiveIntToBinary(int I);
    /**
     * A partir de un complemento de un string binario,
     * entrega el complemento dos que buscamos.
     * @param b
     */
    String nowIsTwoComplement(String b);
    /**
     * Intercambia 1s por 0s y viceversa dentro de un string binario
     * @param bin
     */
    String Complement(String bin);
    /**
     * Transforma un string binario a su complemento dos
     * @param bin
     */
    String twosComplement(String bin);
}
