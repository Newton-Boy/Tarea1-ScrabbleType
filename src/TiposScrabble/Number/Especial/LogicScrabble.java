package TiposScrabble.Number.Especial;

import TiposScrabble.Scrabble;

public interface LogicScrabble extends Scrabble {
    /**
     * Retorna el opuesto logico de un TiposScrabble.Number.IntBinary.LogicScrabble
     */
    LogicScrabble Negación();
    /**
     * Opera un Y lógico en un TiposScrabble.Number.IntBinary.LogicScrabble con un TiposScrabble.Number.IntBinary.BoolScrabble
     */
    LogicScrabble andBool(BoolScrabble boolSc);
    /**
     * Opera un Y lógico en un TiposScrabble.Number.IntBinary.LogicScrabble con un TiposScrabble.Number.IntBinary.BinaryScrabble
     */
    BinaryScrabble andBin(BinaryScrabble binSc);
    /**
     * Opera un O lógico en un TiposScrabble.Number.IntBinary.LogicScrabble con un TiposScrabble.Number.IntBinary.BoolScrabble
     */
    LogicScrabble orBool(BoolScrabble boolSc);
    /**
     * Opera un O lógico en un TiposScrabble.Number.IntBinary.LogicScrabble con un TiposScrabble.Number.IntBinary.BinaryScrabble
     */
    BinaryScrabble orBin(BinaryScrabble binSc);

    LogicScrabble logicalAnd(LogicScrabble logic);
    LogicScrabble logicalOr(LogicScrabble logic);

}
