package org.apache.batik.css.engine.value.svg;
public class ICCColor extends org.apache.batik.css.engine.value.AbstractValue {
    protected java.lang.String colorProfile;
    protected int count;
    protected float[] colors = new float[5];
    public ICCColor(java.lang.String name) { super();
                                             colorProfile = name; }
    public short getCssValueType() { return org.w3c.dom.css.CSSValue.CSS_CUSTOM;
    }
    public java.lang.String getColorProfile() throws org.w3c.dom.DOMException {
        return colorProfile;
    }
    public int getNumberOfColors() throws org.w3c.dom.DOMException { return count;
    }
    public float getColor(int i) throws org.w3c.dom.DOMException {
        return colors[i];
    }
    public java.lang.String getCssText() { java.lang.StringBuffer sb =
                                             new java.lang.StringBuffer(
                                             count *
                                               8);
                                           sb.append("icc-color(");
                                           sb.append(colorProfile);
                                           for (int i = 0; i < count;
                                                i++) { sb.append(
                                                            ", ");
                                                       sb.append(
                                                            colors[i]);
                                           }
                                           sb.append(')');
                                           return sb.toString(); }
    public void append(float c) { if (count == colors.length) { float[] t =
                                                                  new float[count *
                                                                              2];
                                                                java.lang.System.
                                                                  arraycopy(
                                                                    colors,
                                                                    0,
                                                                    t,
                                                                    0,
                                                                    count);
                                                                colors =
                                                                  t;
                                  }
                                  colors[count++] =
                                    c; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL0ZaZAU1fnN7MGe7IHAyrHAMmgt4ox3yqwaYVxkdfYoFrBc" +
       "kKWn581uQ0932/1md3YN8ahKQZKKMQSFpHT/iIFQKJYVc6ohZbxKY5VoPGIJ" +
       "ScxhglYgqZhU1Jjve697+phjs5WQreq3Pe993/e+73vf+frIB6TKMkk71ViU" +
       "TRjUinZrbEAyLZqKq5JlbYC5YXlfhfTXre/1XRkm1UNk9qhk9cqSRdcqVE1Z" +
       "Q2SxollM0mRq9VGaQowBk1rUHJOYomtDZK5i9WQMVZEV1qunKAJskswEaZEY" +
       "M5VkltEemwAjixPASYxzElsdXO5KkAZZNyZc8DYPeNyzgpAZdy+LkebEdmlM" +
       "imWZosYSisW6cia5wNDViRFVZ1GaY9Ht6uW2Cm5IXF6ggo5Hmz786J7RZq6C" +
       "OZKm6YyLZ62nlq6O0VSCNLmz3SrNWLeSL5CKBKn3ADMSSTibxmDTGGzqSOtC" +
       "AfeNVMtm4joXhzmUqg0ZGWJkmZ+IIZlSxiYzwHkGCjXMlp0jg7RL89IKKQtE" +
       "vPeC2N59W5sfqyBNQ6RJ0QaRHRmYYLDJECiUZpLUtFanUjQ1RFo0OOxBaiqS" +
       "qkzaJ91qKSOaxLJw/I5acDJrUJPv6eoKzhFkM7My0828eGluUPavqrQqjYCs" +
       "81xZhYRrcR4ErFOAMTMtgd3ZKJU7FC3FyJIgRl7GyI0AAKizMpSN6vmtKjUJ" +
       "JkirMBFV0kZig2B62giAVulggCYjC0oSRV0bkrxDGqHDaJEBuAGxBFC1XBGI" +
       "wsjcIBinBKe0IHBKnvP5oO+qu2/T1mlhEgKeU1RWkf96QGoPIK2naWpS8AOB" +
       "2LAycZ8078ndYUIAeG4AWMB8//Nnrl3Vfux5AbOwCEx/cjuV2bB8IDn7lUXx" +
       "zisrkI0aQ7cUPHyf5NzLBuyVrpwBEWZeniIuRp3FY+ufvfmOw/RUmNT1kGpZ" +
       "V7MZsKMWWc8YikrN66lGTYnRVA+ppVoqztd7yCx4TygaFbP96bRFWQ+pVPlU" +
       "tc5/g4rSQAJVVAfvipbWnXdDYqP8PWcQQmbBQxrgWULEH//PiBQb1TM0JsmS" +
       "pmh6bMDUUX4rBhEnCbodjSXB6nfELD1rggnGdHMkJoEdjFJ7QbYQdgR4io1J" +
       "apbGrLGRWE88DkLoZhRNzfh/bJJDSeeMh0JwCIuCIUAF71mnqylqDst7s2u6" +
       "zzwy/KIwL3QJW0eMRGHfqNg3yveNwr5RsW+U7xuFfaPOviQU4tudg/uL84bT" +
       "2gF+D4G3oXPwlhu27e6oAEMzxitB1Qja4UtAcTc4OBF9WD7a2ji57MTFT4dJ" +
       "ZYK0SjLLSirmk9XmCEQqeYftzA1JSE1uhljqyRCY2kxdpikIUKUyhU2lRh+j" +
       "Js4zco6HgpO/0FNjpbNHUf7Jsf3jd266/aIwCfuTAm5ZBfEM0QcwlOdDdiQY" +
       "DIrRbdr13odH79upu2HBl2Wc5FiAiTJ0BA0iqJ5heeVS6fHhJ3dGuNprIWwz" +
       "CU4dImJ7cA9f1OlyIjjKUgMCp3UzI6m45Oi4jo2a+rg7wy21hb+fA2ZRj244" +
       "B55Lbb/k/3F1noHjfGHZaGcBKXiGuHrQeODNl/94KVe3k0yaPFXAIGVdngCG" +
       "xFp5qGpxzXaDSSnAvbN/4Bv3frBrM7dZgFhebMMIjnEIXHCEoOYvPn/rWydP" +
       "HHgt7No5gwyeTUIhlMsLifOkroyQsNt5Lj/gXirEB7SayEYN7FNJK1JSpehY" +
       "HzetuPjx9+9uFnagwoxjRqumJ+DOn7uG3PHi1r+3czIhGROwqzMXTET1OS7l" +
       "1aYpTSAfuTuPL/7mc9IDkB8gJlvKJOVhNmT7OjLVBvUYx8RcGxW5lp/m5Xz5" +
       "Ij5ehprgSISvXYnDCsvrFX7H81RQw/I9r51u3HT6qTNcDH8J5jWCXsnoEnaH" +
       "w3k5ID8/GLXWSdYowF12rG9Ls3rsI6A4BBRliMdWvwmhM+czGRu6atYvf/r0" +
       "vG2vVJDwWlKn6lJqrcS9j9SC2VNrFKJuzvjcteLUx2tgaOaikgLhCyZQ80uK" +
       "n2l3xmD8FCZ/MP+7Vx2cOsHNzxA0FnL8CkwEvnDLC3nX4w+/+plfHPz6feOi" +
       "FOgsHeYCeG3/7FeTd/3mHwUq5wGuSJkSwB+KHbl/QfyaUxzfjTSIHckVJi+I" +
       "1i7uJYczfwt3VD8TJrOGSLNsF86bMDWB/w5BsWg51TQU1751f+EnqpyufCRd" +
       "FIxynm2DMc5NmvCO0PjeGAhrs/EIO+CJ2B4fCYa1EOEvN3KU8/m4EocLnShS" +
       "a5g6Ay5pKhBIGsuQZVhzQ3KGEO/URVeIAIrjZ3FICHJXl7TKbr8UbfB02tt1" +
       "lpBig5ACh75CZkthM1Il61nofHyVAWbfwWzSgiyuZCBoj9n17SUD2+TdkYHf" +
       "CoM9twiCgJt7KPbVTW9sf4mnhBqsEzY4h+SpAqCe8OSjZsH0p/AXgudf+CCz" +
       "OCHqxNa4XawuzVer6HBlPScgQGxn68kd97/3sBAg6CYBYLp775c/jd69V8R5" +
       "0fIsL+g6vDii7RHi4LAFuVtWbheOsfYPR3f++NDOXYKrVn8B3w396cOvf/JS" +
       "dP+vXihSMVYodtt6mSf0Q6b2n40Q6LovNT1xT2vFWqgwekhNVlNuzdKelN+d" +
       "ZlnZpOew3FbKdTFbNDwYRkIr4QwC5r1xhua9Cp6obaDREuatljXvUtiMtzrQ" +
       "+fqvXvLmynOpUM6W+md/Yj34+8fEIRRzhkCzd+hgjfx25lnuDLjZUJ6tBcgF" +
       "Njfn22ydLwz4pv+yBwG0TIwX/qvhjYd8p705W6TRgFeUdi+P/qa+vfzl26eW" +
       "/5pn7RrFgvANDl6k0fbgnD5y8tTxxsWP8JK3EuOEbXb+G4rCCwjfvQLXfhMO" +
       "TBjezbbv4b+tnvckwzSiSwUOgz9HcwVuxE1V0LWt8I7iqSKMr1GkrmiSyvnZ" +
       "AqanQuMmGmAJhwnD3SIs8JwibY5bpMVVXaNYKTprorlT9Gj+DggWC5k1yWJf" +
       "rdHLNeQm7ndm73n3h5GRNTPp6nCufZq+DX8vgWNeWdpKgqw8d9efFmy4ZnTb" +
       "DBq0JQEjCpL8Tu+RF64/T94T5tdMoqIouJ7yI3X5A1+dSVnW1Pyhbrk4fX56" +
       "bgC6gB9wmQp6T5m1vTh8DfMuHrSwizLg+wqLUpyIG5761WfFgVicKROLcx6R" +
       "8sGL/1WTwC2NJ6Z6KlyC4WFxqYs0ntsO3LV3KtX/0MVOlIQ+p5bpxoUqHaOq" +
       "h1Q1f/9Kno0WJL8Uni6bja5gYnAFDUiQb/VKoZZR96Eya4dxeBDamhHK4pbF" +
       "a9p8U10u5kAPYpaLOfygDkyXNMt3KsIoAkpsxbVl8KyxNbFm5koshVpGUT8K" +
       "rAU60ja85Bq/VI6m9Ez0uv7e7pxMDfR/jvwEDo/bWg7W0a66vncW1NXk2FyP" +
       "LXPPzNVVCrWMul4ori78+SQHeBGHnzHSAirpy+K3gf40Vw1H2ewq5ZmzoBTu" +
       "iOfCM2BLNjBzpZRCLS34Zk719ek08yYOrzBS4xgL/p50FXL8bDnVInhusqW6" +
       "aeYKKYVaxkreLbP2OxxOMFInItMGyMABdzl5FhTB7w0xO6RtadIzV0Qp1NIH" +
       "P8mpni6jjb/gcArqL8kwqJYqFpIrx3Ql5Wrn/f+FdnJghs7FPF4ctRV8BhSf" +
       "ruRHpppq5k9tfENUvc7npQaoqdJZVfVebXjeqw2TphUuX4O46BBt1yeMrPiP" +
       "PhpAqwgjZ/5jjhqCjmTZtKiQvvh/L2IFIwvLIILmxYsXpxoK2WI4wBaMXsha" +
       "RpqDkMAF/++FawB7d+H4ceOLF6QJqAMIvjYbTvqJTa+u1dDtmVAi8xSfC/kr" +
       "nrzVzJ3OajxF0nJfdcy/IzuVbFZ8SR6Wj07d0HfbmSseEhfpsipNTiKVemh3" +
       "xJ1+vhpeVpKaQ6t6XedHsx+tXeGUXS2CYdchF3ocJg6uZaDJLgjcMluR/GXz" +
       "Wweueurnu6uPQ3u3mYQkaFk2F17m5Yws1IObE4WXD9A58Ovvrs5vTVyzKv3n" +
       "t/l1KRGNy6LS8MPyawdveXVP24H2MKnvIVVQUdIcv2W8bkJbT+Uxc4g0KlZ3" +
       "DlgEKtAf+W42ZqN3SXjrzfViq7MxP4ufYRjpKLzUKfx4Vafq49Rco2e1FJKB" +
       "JrXenXG6Il9DkYXw40dwZzyd64gITXgaYK7DiV7DcO68KjcaPLiMliz1Q7xD" +
       "wR4zFPk3z8iJImMiAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "o9ANvb64MDmKQ0nZX8XILpxdzY+t45HX");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("s45TCcBzZw4Uy6u/R4d/yf7y74vK516hhz/2TeQz++taiiPleTHKFbbywP7m" +
       "2PEB4jN3He1orMuDF7790K9dff4opXhoT/CJl52i7ak7343quUFc3mbKf/ud" +
       "v/m+f/LKl8uzqv8LyI65tJMtAAA=");
}
