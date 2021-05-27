public class BinaryScrabble implements NumberScrabble  {
    private String Bin;
    public BinaryScrabble(String binary){
        Bin=binary;
    }

    public String getBinary() {
        return Bin;
    }

    public void setBina(String binary) {
        Bin = binary;
    }
    public int toInt(String binary) {
        if (bitToInt(binary.charAt(0)) == 0) {
            return positiveBinToInt(binary);
        } else {
            return negativeBinaryToInt(binary);
        }
    }
    private int negativeBinaryToInt(String binary) {
        int n = binary.length() - 1;
        int w = -bitToInt(binary.charAt(0)) * (int) Math.pow(2, n);
        for (int i = n, j = 0; i > 0; i--, j++) {
            w += (int) Math.pow(2, j) * (binary.charAt(i) == '1' ? 1 : 0);
        }
        return w;
    }
    private int positiveBinToInt(String binary) {
        int w = 0;
        for (int i = binary.length() - 1, j = 0; i > 0; i--, j++) {
            w += (int) Math.pow(2, j) * bitToInt(binary.charAt(i));
        }
        return w;
    }
    private int bitToInt(char bit) {
        return bit == '0' ? 0 : 1;
    }

    @Override
    public String toString() {
        return this.getBinary() ;
    }

    @Override
    public Scrabble intoThisScrabble(Scrabble Sc) {
        return Sc.toBinary(this);
    }

    @Override
    public StringScrabble toStringSc(StringScrabble S) {
        return null;
    }

    @Override
    public BoolScrabble toBool(BoolScrabble B) {
        return null;
    }

    @Override
    public IntScrabble toIntSc(IntScrabble I) {
        String B=this.getBinary();
        int bit=this.toInt(B);
        return new IntScrabble(bit);
    }

    @Override
    public FloatScrabble toFloat(FloatScrabble F) {
        String B=this.getBinary();
        int bit=this.toInt(B);
        String S= String.valueOf(bit);
        double Bit= Float.valueOf(S);
        return new FloatScrabble(Bit);
    }

    @Override
    public BinaryScrabble toBinary(BinaryScrabble Bi) {
        return this;
    }
}
