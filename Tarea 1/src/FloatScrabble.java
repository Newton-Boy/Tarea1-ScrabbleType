public class FloatScrabble implements NumberScrabble {
    private double Float;
    public FloatScrabble(double f){
        Float=f;
    }

    public double getFloat() {
        return Float;
    }

    public void setFloat(double aFloat) {
        Float = aFloat;
    }

    @Override
    public String toString() {
        return "" + this.getFloat() +"";
    }

    @Override
    public Scrabble intoThisScrabble(Scrabble Sc) {
        return Sc.toFloat(this);
    }

    @Override
    public StringScrabble toStringSc(StringScrabble S) {
        String F=this.toString();
        return new StringScrabble(F);
    }

    @Override
    public BoolScrabble toBool(BoolScrabble B) {
        return null;
    }

    @Override
    public IntScrabble toIntSc(IntScrabble I) {
        return null;
    }

    @Override
    public FloatScrabble toFloat(FloatScrabble F) {
        return this;
    }

    @Override
    public BinaryScrabble toBinary(BinaryScrabble Bi) {
        return null;
    }
}
