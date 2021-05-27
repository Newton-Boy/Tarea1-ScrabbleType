public class BoolScrabble implements Scrabble {
    private boolean bool;
    public BoolScrabble(boolean b){
        bool=b;
    }
    public boolean getBool(){
        return this.bool;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }

    @Override
    public String toString() {
        boolean B=this.getBool();
        return ""+B+"";
    }
    @Override
    public boolean equals(Object O){
        if(O instanceof BoolScrabble){
            var Sc= (BoolScrabble) O;
            return Sc.bool==bool;
        }
        return false;
    }

    @Override
    public Scrabble intoThisScrabble(Scrabble Sc) {
        return Sc.toBool(this);
    }

    @Override
    public StringScrabble toStringSc(StringScrabble S) {
        String B=this.toString();
        return new StringScrabble(B);
    }

    @Override
    public BoolScrabble toBool(BoolScrabble B) {
        return this;
    }

    @Override
    public IntScrabble toIntSc(IntScrabble I) {
        return null;
    }

    @Override
    public FloatScrabble toFloat(FloatScrabble F) {
        return null;
    }

    @Override
    public BinaryScrabble toBinary(BinaryScrabble Bi) {
        return null;
    }
}
