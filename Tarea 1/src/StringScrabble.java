public class StringScrabble implements Scrabble{
    private String String;
    public StringScrabble(String string){
        String=string;
    }
    public String getString(){
        return String;
    }

    public void setString(String aString) {
        String = aString;
    }

    @Override
    public String toString(){
        return this.getString();
    }
    public Scrabble intoThisScrabble(Scrabble Sc){
        return Sc.toStringSc(this);
    }
    @Override
    public StringScrabble toStringSc(StringScrabble S) {
        return this;
    }

    @Override
    public BoolScrabble toBool(BoolScrabble B) {
        return null;
    }@Override
    public IntScrabble toIntSc(IntScrabble I) {
        return null;
    }
    @Override
    public boolean equals(Object O){
        if(O instanceof StringScrabble){
            var Sc= (StringScrabble) O;
            return Sc.String==String;
        }
        return false;
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
