public interface Scrabble {
    Scrabble intoThisScrabble(Scrabble Sc);
    StringScrabble toStringSc(StringScrabble S);
    BoolScrabble toBool(BoolScrabble B);
    FloatScrabble toFloat(FloatScrabble F);
    IntScrabble toIntSc(IntScrabble I);
    BinaryScrabble toBinary(BinaryScrabble Bi);
    @Override String toString();
}
