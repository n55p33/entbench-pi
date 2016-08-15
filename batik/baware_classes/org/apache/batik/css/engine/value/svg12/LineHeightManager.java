package org.apache.batik.css.engine.value.svg12;
public class LineHeightManager extends org.apache.batik.css.engine.value.LengthManager {
    public LineHeightManager() { super(); }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return true; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_LINE_HEIGHT_VALUE; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.SVG12CSSConstants.
                                                         CSS_LINE_HEIGHT_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg12.SVG12ValueConstants.
                 NORMAL_VALUE;
    }
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException {
        switch (lu.
                  getLexicalUnitType(
                    )) {
            case org.w3c.css.sac.LexicalUnit.
                   SAC_INHERIT:
                return org.apache.batik.css.engine.value.svg12.SVG12ValueConstants.
                         INHERIT_VALUE;
            case org.w3c.css.sac.LexicalUnit.
                   SAC_IDENT:
                {
                    java.lang.String s =
                      lu.
                      getStringValue(
                        ).
                      toLowerCase(
                        );
                    if (org.apache.batik.util.SVG12CSSConstants.
                          CSS_NORMAL_VALUE.
                          equals(
                            s))
                        return org.apache.batik.css.engine.value.svg12.SVG12ValueConstants.
                                 NORMAL_VALUE;
                    throw createInvalidIdentifierDOMException(
                            lu.
                              getStringValue(
                                ));
                }
            default:
                return super.
                  createValue(
                    lu,
                    engine);
        }
    }
    protected int getOrientation() { return VERTICAL_ORIENTATION;
    }
    public org.apache.batik.css.engine.value.Value computeValue(org.apache.batik.css.engine.CSSStylableElement elt,
                                                                java.lang.String pseudo,
                                                                org.apache.batik.css.engine.CSSEngine engine,
                                                                int idx,
                                                                org.apache.batik.css.engine.StyleMap sm,
                                                                org.apache.batik.css.engine.value.Value value) {
        if (value.
              getCssValueType(
                ) !=
              org.w3c.dom.css.CSSValue.
                CSS_PRIMITIVE_VALUE)
            return value;
        switch (value.
                  getPrimitiveType(
                    )) {
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_NUMBER:
                return new org.apache.batik.css.engine.value.svg12.LineHeightValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_NUMBER,
                  value.
                    getFloatValue(
                      ),
                  true);
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_PERCENTAGE:
                {
                    float v =
                      value.
                      getFloatValue(
                        );
                    int fsidx =
                      engine.
                      getFontSizeIndex(
                        );
                    float fs =
                      engine.
                      getComputedStyle(
                        elt,
                        pseudo,
                        fsidx).
                      getFloatValue(
                        );
                    return new org.apache.batik.css.engine.value.FloatValue(
                      org.w3c.dom.css.CSSPrimitiveValue.
                        CSS_NUMBER,
                      v *
                        fs *
                        0.01F);
                }
            default:
                return super.
                  computeValue(
                    elt,
                    pseudo,
                    engine,
                    idx,
                    sm,
                    value);
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1ZC2wUxxken/Hbxg+e4WFeBsTrLpDQFpmmMcaAyfkhDFZr" +
       "A2a8N3e3eG932Z2zzw6kJFILbRWKKElIVagqEUErAqhqmlZpEFGkJjRp1VDU" +
       "hFaQSqlUGkob1CqRSpP0/2d3b/f2fOe6qnvSzu3N/P8//+Obf/6ZO3eHFJkG" +
       "qWcqD/JhnZnBFpV3UsNkkWaFmuZ26OuTnimkf999q31dgBT3kMlxarZJ1GSb" +
       "ZKZEzB4yV1ZNTlWJme2MRZCj02AmMwYplzW1h0yTzdaErsiSzNu0CEOCbmqE" +
       "SS3l3JD7k5y12gI4mRsGTUJCk1CTf7gxTColTR92yWd6yJs9I0iZcOcyOakJ" +
       "76WDNJTkshIKyyZvTBlkha4pwzFF40GW4sG9ylrbBVvDa7NcsPBi9Yf3jsZr" +
       "hAumUFXVuDDP3MZMTRlkkTCpdntbFJYw95HHSGGYVHiIOWkIO5OGYNIQTOpY" +
       "61KB9lVMTSaaNWEOdyQV6xIqxMmCTCE6NWjCFtMpdAYJpdy2XTCDtfPT1lpW" +
       "Zpn41IrQ8Wd21/ywkFT3kGpZ7UJ1JFCCwyQ94FCW6GeG2RSJsEgPqVUh2F3M" +
       "kKkij9iRrjPlmEp5EsLvuAU7kzozxJyuryCOYJuRlLhmpM2LCkDZv4qiCo2B" +
       "rdNdWy0LN2E/GFgug2JGlALubJZJA7Ia4WSenyNtY8MjQACsJQnG41p6qkkq" +
       "hQ5SZ0FEoWos1AXQU2NAWqQBAA1OZuUUir7WqTRAY6wPEemj67SGgKpMOAJZ" +
       "OJnmJxOSIEqzfFHyxOdO+/ojj6pb1AApAJ0jTFJQ/wpgqvcxbWNRZjBYBxZj" +
       "5fLw03T6y4cDhADxNB+xRfPi/rsPr6y//LpFM3sUmo7+vUzifdLp/slvzWle" +
       "tq4Q1SjVNVPG4GdYLlZZpz3SmNIhw0xPS8TBoDN4edvPv3TwB+x2gJS3kmJJ" +
       "U5IJwFGtpCV0WWHGZqYyg3IWaSVlTI00i/FWUgLvYVllVm9HNGoy3komKaKr" +
       "WBO/wUVREIEuKod3WY1qzrtOeVy8p3RCSAk8pBKeFcT6iG9OlFBcS7AQlagq" +
       "q1qo09DQfjMEGacffBsP9QPqB0KmljQAgiHNiIUo4CDO7AHJRNoY6BQapEqS" +
       "hczB2Oo1IdR7C5Njcd5GVQCGEUTU6f/n+VJo/5ShggIIzRx/YlBgTW3RlAgz" +
       "+qTjyQ0td8/3vWGBDheK7TlO1oEKQUuFoFAhCCoELRWCQoWgUCGYpQIpKBAz" +
       "T0VVLEAAzQAkBsjMlcu6dm3dc3hhISBRH5oEsUDShRk7VLObPZyU3yddqKsa" +
       "WXBz9asBMilM6qjEk1TBDafJiEEqkwbs1V7ZD3uXu4XM92whuPcZmsQikMFy" +
       "bSW2lFJtkBnYz8lUjwRng8OlHMq9vYyqP7l8Yujx7i/fHyCBzF0DpyyChIfs" +
       "nZjr0zm9wZ8tRpNbfejWhxeePqC5eSNjG3J2zyxOtGGhHxt+9/RJy+fTF/pe" +
       "PtAg3F4GeZ1TiDekzHr/HBlpqdFJ8WhLKRgc1YwEVXDI8XE5jxvakNsjQFsr" +
       "3qcCLCpwnc6BZ5W9cMU3jk7XsZ1hgRxx5rNCbCGf79JPvvOrPz8g3O3sNtWe" +
       "MqGL8UZPhkNhdSKX1bqw3W4wBnQ3TnR+66k7h3oFZoFi0WgTNmDbDJkNQghu" +
       "/srr+66/e/P0tYCLcw5bfLIfKqVU2kjsJ+V5jITZlrj6QIZUIGsgahp2qIBP" +
       "OSrTfoXhwvpX9eLVL/zlSI2FAwV6HBitHFuA23/fBnLwjd0f1QsxBRLu0K7P" +
       "XDIr7U9xJTcZBh1GPVKPX5377Gv0JGwgkLRNeYSJPEyED4gI2lph//2ifdA3" +
       "9llsFpte8GeuL08l1ScdvfZBVfcHl+4KbTNLMW+s26jeaMELmyUpED/Dn5y2" +
       "UDMOdA9ebt9Zo1y+BxJ7QKIEydjsMCBZpjKQYVMXlfzulVen73mrkAQ2kXJF" +
       "o5FNVCwyUgboZmYc8mxK/8LDVnCHSqGpEaaSLOOzOtDB80YPXUtC58LZIz+Z" +
       "8aP1Z07dFCjTLRmzvQKXYrMijTfxKfbvhl68ZUgwyNxcBYsotk4/cfxUpOO5" +
       "1VZZUZdZBLRAjfv8bz9+M3jiD1dG2V/KuKavUtggUzxzluGUGXtBm6jl3Hx0" +
       "Y/Kx937aENswnm0A++rHSPT4ex4YsTx3Wver8toT78/a/lB8zzgy+jyfO/0i" +
       "v9927srmJdKxgChcrWSeVfBmMjV6HQuTGgwqdBXNxJ4qAftFaQBMwcAugWeN" +
       "DYA1o2fVUbCTzlW5WPOs6u15xrqx6eBkChwk1TgcOaAghI1InCoySwOMc1ey" +
       "34RtXE5A1h60K+A1nXukww2df7RgeN8oDBbdtLOhJ7vf3vumCFgpIiTtJg86" +
       "AEmeDanGsv9T+BTA8wk+qDp2WJVkXbNdzs5P17O4FA2yLM8BNNOA0IG6dwe+" +
       "c+t5ywB/ve8jZoePf/3T4JHj1pqyDkWLss4lXh7rYGSZg00varcg3yyCY9Of" +
       "Lhx46eyBQwE7UJs5KenXNIVRNR3IgnQJNzXT7ZauG79W/bOjdYWbYLW2ktKk" +
       "Ku9LstZIJmJLzGS/Jw7uOcrFr601+pyTguVOpvscNp3We+N/mWSxo0kX/Y9k" +
       "rpKl8Kyzob5u/KskF2uelbAvz5johGwwVTabVDlBOW7bzjLBsR7XJYmJcsli" +
       "eGyZ1vf4XJKLNY/Zj+UZO4jNMCxAGW8tBHZzOGRkAhxSjWP18Gy2rdo8fofk" +
       "Ys1j9DfyjD2JzVeh9Ikx7ngiXV9/0V75+LXL8045KZTtWyjPisafUc8yOzQB" +
       "LqzDsQXwtNt+aB+/C3Ox5nHTyTxj38XmRKYL2yFXCeKZnNSIggwvkYLWJZLr" +
       "oWcnwEO1ODYfnh22mTvG76FcrHm8cC7P2Hlszlge2siiNKnwbrwNcDy0dOx7" +
       "A5deOO7sRDkOT487bet3jt9xuVh9zgkIRQKO/bPR/qEHJGG2SaVgmKVkiSo7" +
       "VJk7NIvz+ai5q6tFvAkVX/LN5my4tqSZzmwRLRHc2NHWkpKYjkWoYH4Fmx9z" +
       "UiEZDOoS4Xfsuug6/8WJWteIWsP2oJHH+aJdjs0q55hcphsah7MOi/hOylV5" +
       "ZOaB7K/zjF3F5gonkwHOHYYMRQx1rgO+6XrpFxMF0bnw7Lct2j9+iOZi9Rlc" +
       "LBQpdkATHAN+XXxYwfIC/+cAhyDX97C55HoFpDTkk4IiGByQBdqEITfyBOE9" +
       "bN7h+L9BQk+ODtTr/4sQpDipzbqvxIP2zKy/T6wrf+n8qerSGad2vC3Om+lr" +
       "+Uo4P0STiuIpY70lbbFusKgsTKu07h108XX7P0qP4lqVkyLxLSx532L/KycL" +
       "xmQHxsF0frUZ79ppKQcjJ8XWi5fnH1BrjsYD5QK0XsqPYFv0U4IW4ttL909O" +
       "yl06mNR68ZJ8DNKBBF8/0R2ghcZ2WRh+8bgdz5SVHTPuQQSEpo0FIc/Fx6KM" +
       "w5v4D8453SStf+H6pAuntrY/evczz1l3jJJCR0ZQSgWcaazrTvsc6T1s+aU5" +
       "soq3LLs3+WLZYuewVWsp7KaA2Z710gRpUkfYzvJdwJkN6Xu466fXX/rl4eKr" +
       "cEzsJQVQ5U3p9fwDZv3d05jSkwaZ2xvOPrt1U0PcDDYu+/bwQyujf/u9uGIi" +
       "1llvTm76PunamV2/OTbzdH2AVLSSIjhHslQPKZfNjcPqNiYNGj2kSjZbUqAi" +
       "SJGpknEwnIwrjGJhJfxiu7Mq3Ys31JwszD7uZt/rlyvaEDM2aEk1gmLgaFnh" +
       "9liR8V2dJHXdx+D22KHEVtD3pjAaANe+cJuuO7cBxbd1kWmio5fT0BaIwEbx" +
       "re7faWm1X58fAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
