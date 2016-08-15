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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "/b8BCfDDfZ8fAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "aUggWdprMA7Ja5NKq9cbce56q5p5Z0k0/Rx34RWTrz2NHNfgphE6WFuva+tW" +
       "p5UzjODpE9smiVltMO5JWRDRCV3J8oAR8lYwd3dWpMabWtKNhR2pdq0wzmZ1" +
       "voOqeSMIzDUXjOqZV9khq3yiVBktr1WzOIUNcttZ8E0ybdq9Be7MtUZQYY1J" +
       "JUq9scx7+JzcSPkaQaYShS/7eZ2ad+q7CQNCYgUxDMvyHVFC6q1U95BASDxt" +
       "A7tgWZzj7ICr8u1xs5eTvFe3l7jYWMtrxcVndpfsh3Uhm65EfzWTpXEWD7dD" +
       "RxUzlRxXJou6VBPag3rFpxcub2j5dJOomwXIUSQ3523X72cqPotjKok5ap2C" +
       "HLgdhcxWr2ds0038aUXauit0yWxwQonSBirzC9q3qtU5QYW6Sc2w3lonFVjp" +
       "9DADxw2pY4Av4G8sPo2/5cXtTjxQbsScnLmtHaRoIF7EV/m+6YmiePJk87b8" +
       "u3zxnObs5u3pjh5U7DQ8equjtHKX4aPvefY5jf5Y7eBoJ3SZQPcmfvB1jr7R" +
       "nTOi7gWS3nrrHZVJeZJ4ukP3W+/520fm32S+80WcO7z+gp4XRX588snPDt+k" +
       "/uABdMfJft0NZ5znmZ46v0t3JdKTNPLm5/bqHj2x7EOFxd4EnvqRZes33/u/" +
       "qRdcKr1gP/a32WiOb9OWFoWXQA9Z8cgz9chKdI2J/PLUuGTgzjiMkEB3K77v" +
       "6LJ36kz+C23xnO2yrLDPo38zeLpH6LsvP/r33Kbtu4rimQR6lRWjnuXKSXFC" +
       "cAy/aNue4vz2l4rzSfAc8e5/X16c779N2weK4nsT6EGruEJQbvndAuX3vQSU" +
       "V4vKx8AzPEI5fPlR/uht2j5SFB9MoKsrPTmGd3LodsGP77CO7naUqD/0ElA/" +
       "WFQ+AZ7pEerpy4/647dp+8mi+Oh51NOj+EOcQvzYS4BYLgGPg4c/gsi//BA/" +
       "c5u2ny+KT+8h4rohp87+XOX4eOHNL3wafkpfWuNnXqo1iuPadxxZ4x0vjzUO" +
       "SoKDY1BfXYDaNtQSSyyrh5SeWars8J6VHNM8eTvgGMf1y7eyt1+/0Nulo+P9" +
       "I0kPH/em+e4hTk9AQqMHxeJZMn+2KH4lgV6hRrqc6KUxi6pfPLXor77UKVT4" +
       "V3Rk0ejFWBQkD0HkJ7oKlq4XdLM/uk3bnxTF7yfQ/cDN6MjSvX36UNQ+dwr0" +
       "cy/VdR4Fz7uOgL7r5XGdyyXB5ePBPHwBt+CSnVOsdMXFOYCyjBRF8ZunUIGU" +
       "67eTUojQJ3Kp9S+WOv3lbSz7xaL486S4euYG6c0d6PMvxq4ZSHVvuNpSnNM/" +
       "fMNNu/3tMPWnn7t6z2uf4/+4vN1xcoPrXgq6x0gd5+yx6pn3y0GkG1YJ4d79" +
       "IWtQ/vzj/ynmlDdwEuiu8reE8A979n9OoCdekD05Osw8y/gvR2HhFowJdHn/" +
       "cpbn30F6czMesAaC8izlVxLo2kVKoEX5e5buvxPoyikd6HT/coakOFO+A5AU" +
       "rwfBsUPBL2wyCvyXmEfjmV06/1lx4ioPvpCrnPkSeeO574fyuuZxrp/uL2w+" +
       "rX7qOXL6bV9uf2x/g0Z15DwvpNxDQXfvL/OcfC88cUtpx7IuE2/5yv2fvvfJ" +
       "42+b+/cKn87rM7q9/ubXVfpukJQXTPJfeO3PfcOPP/f58sz6fwEKvVmURysA" +
       "AA==");
}
