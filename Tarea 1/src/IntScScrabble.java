class IntScrabble implements NumberScrabble{
    private int Int;
    public IntScrabble(int i){
        Int=i;
    }

    public int getInt() {
        return Int;
    }

    public void setInt(int anInt) {
        Int = anInt;
    }
    @Override
    public String toString() {
        return "" + this.getInt() +"";
    }

    @Override
    public Scrabble intoThisScrabble(Scrabble Sc) {
        return Sc.toIntSc(this);
    }

    @Override
    public StringScrabble toStringSc(StringScrabble S) {
        String I=this.toString();
        return new StringScrabble(I);
    }

    @Override
    public BoolScrabble toBool(BoolScrabble B) {
        return null;
    }

    @Override
    public IntScrabble toIntSc(IntScrabble I) {
        return this;
    }

    @Override
    public FloatScrabble toFloat(FloatScrabble F) {
        String I=this.toString();
        double iToF= Float.valueOf(I);
        return new FloatScrabble(iToF);
    }

    @Override
    public BinaryScrabble toBinary(BinaryScrabble Bi) {
        return null;
    }
}
