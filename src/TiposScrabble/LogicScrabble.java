package TiposScrabble;

import TiposScrabble.Number.BinaryScrabble;

public interface LogicScrabble extends Scrabble {
    /**
     * Retorna el opuesto logico de un LogicScrabble
     */
    LogicScrabble Negación();
    /**
     * Opera un Y lógico en un LogicScrabble con un BoolScrabble
     * @param boolSc
     */
    LogicScrabble andBool(BoolScrabble boolSc);
    /**
     * Opera un Y lógico en un LogicScrabble con un BinaryScrabble
     * @param binSc
     */
    BinaryScrabble andBin(BinaryScrabble binSc);
    /**
     * Opera un O lógico en un LogicScrabble con un BoolScrabble
     * @param boolSc
     */
    LogicScrabble orBool(BoolScrabble boolSc);
    /**
     * Opera un O lógico en un LogicScrabble con un BinaryScrabble
     * @param binSc
     */
    BinaryScrabble orBin(BinaryScrabble binSc);
    /**
     * Y logíco entre 2 LogicScrabble
     * @param logic
     */
    LogicScrabble logicalAnd(LogicScrabble logic);
    /**
     * O logíco entre 2 LogicScrabble
     * @param logic
     */
    LogicScrabble logicalOr(LogicScrabble logic);

}
