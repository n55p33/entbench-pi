package org.apache.batik.parser;
public class FloatArrayProducer extends org.apache.batik.parser.DefaultNumberListHandler implements org.apache.batik.parser.PointsHandler {
    protected java.util.LinkedList as;
    protected float[] a;
    protected int index;
    protected int count;
    public float[] getFloatArray() { return a; }
    public void startNumberList() throws org.apache.batik.parser.ParseException {
        as =
          new java.util.LinkedList(
            );
        a =
          (new float[11]);
        count =
          0;
        index =
          0;
    }
    public void numberValue(float v) throws org.apache.batik.parser.ParseException {
        if (index ==
              a.
                length) {
            as.
              add(
                a);
            a =
              (new float[a.
                           length *
                           2 +
                           1]);
            index =
              0;
        }
        a[index++] =
          v;
        count++;
    }
    public void endNumberList() throws org.apache.batik.parser.ParseException {
        float[] all =
          new float[count];
        int pos =
          0;
        java.util.Iterator it =
          as.
          iterator(
            );
        while (it.
                 hasNext(
                   )) {
            float[] b =
              (float[])
                it.
                next(
                  );
            java.lang.System.
              arraycopy(
                b,
                0,
                all,
                pos,
                b.
                  length);
            pos +=
              b.
                length;
        }
        java.lang.System.
          arraycopy(
            a,
            0,
            all,
            pos,
            index);
        as.
          clear(
            );
        a =
          all;
    }
    public void startPoints() throws org.apache.batik.parser.ParseException {
        startNumberList(
          );
    }
    public void point(float x, float y) throws org.apache.batik.parser.ParseException {
        numberValue(
          x);
        numberValue(
          y);
    }
    public void endPoints() throws org.apache.batik.parser.ParseException {
        endNumberList(
          );
    }
    public FloatArrayProducer() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVaDXAV1RW+7yUkISEkhF8RAoQAw4/voZX6E7RCCBJ8gUiQ" +
       "TsNP2LfvvmRh3+66e1/yiKVWph1pZ2T8wZ86mnamKKgojlOnWqvScUSpP1N/" +
       "WrVWtNW2WuoodbRObbXn3Lv79ue9fWmsyczebO6ec+49557znXPvzeH3yRjL" +
       "JI1UYzG2y6BWrE1jnZJp0VSrKlnWRujrkW8ukz7a9u6686KkopuM75OsDlmy" +
       "6GqFqimrm8xUNItJmkytdZSmkKPTpBY1+yWm6Fo3maxY7RlDVWSFdegpigSb" +
       "JDNBJkiMmUoyy2i7LYCRmQmYSZzPJL4i+LklQcbJurHLJZ/mIW/1fEHKjDuW" +
       "xUh9YofUL8WzTFHjCcViLTmTLDZ0dVevqrMYzbHYDnWZbYK1iWUFJmi6v+6T" +
       "z67tq+cmmChpms64etYGaulqP00lSJ3b26bSjHU5+Q4pS5AaDzEjzQln0DgM" +
       "GodBHW1dKph9LdWymVadq8McSRWGjBNiZI5fiCGZUsYW08nnDBKqmK07ZwZt" +
       "Z+e1FVoWqHjj4vj+m7fVP1BG6rpJnaJ14XRkmASDQbrBoDSTpKa1IpWiqW4y" +
       "QYPF7qKmIqnKoL3SDZbSq0ksC8vvmAU7swY1+ZiurWAdQTczKzPdzKuX5g5l" +
       "/zUmrUq9oOsUV1eh4WrsBwWrFZiYmZbA72yW8p2KlmJkVpAjr2PzJUAArJUZ" +
       "yvr0/FDlmgQdpEG4iCppvfEucD2tF0jH6OCAJiPTQ4WirQ1J3in10h70yABd" +
       "p/gEVGO5IZCFkclBMi4JVml6YJU86/P+uuX7rtDWaFESgTmnqKzi/GuAqTHA" +
       "tIGmqUkhDgTjuEWJm6Qpj+6NEgLEkwPEgubn3z510ZLGo08LmtOL0KxP7qAy" +
       "65EPJMe/MKN14XllOI0qQ7cUXHyf5jzKOu0vLTkDEGZKXiJ+jDkfj2449q3v" +
       "3k1PRkl1O6mQdTWbAT+aIOsZQ1GpeTHVqCkxmmonY6mWauXf20klvCcUjYre" +
       "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" +
       "yu8xeBQnQ/dFEX4ZlsS3c/8LMqAe7YUlAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "z29WysfBFRxIGbz1Uv7lG0n5P/Piz4El");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("C1fe4dkZGb/4ZmXMPwxnBzJmb42M+8ffHV849tu/eSNp/zYv/ncIXfDcgy+Q" +
       "J+T8P29Wzm8H18sHcr78ltty7/Y3kG7vYl79elicyLyZJfegb0bCJIQevPGQ" +
       "YX5K6tEbjjHvjt4qn3r10p2PvDr9w905g8PjsXf1oTv1yLJOHmo5Ub/o+Zpu" +
       "FNLftTvi4hXS3BdCj5yDyfkhtKKSM713747+cghdPksPLF38n6R7KITuPqYD" +
       "Q+0qJ0keDqHbAElefcQ7XCBK5y0QLU2XI+vEMnCYD+ydWNIPVF842oNvZIaj" +
       "LieP6eVfsItj5odfmyP+4DDOp1+l2fd9tfaTu2OCiiVnWT7KnX3ojt2JxWLQ" +
       "/Iv10+eOdjjWRer5r93/s3c9e5ii3L9j+Nh7T/D25M3P4bVtLyxOzmW/9MjP" +
       "f/e/evVPi699/x/aPAsf/y8AAA==");
}
