package org.apache.batik.css.engine.value.css2;
public class FontSizeAdjustManager extends org.apache.batik.css.engine.value.AbstractValueManager {
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_FONT_SIZE_ADJUST_VALUE; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_FONT_SIZE_ADJUST_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.ValueConstants.
                 NONE_VALUE;
    }
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException {
        switch (lu.
                  getLexicalUnitType(
                    )) {
            case org.w3c.css.sac.LexicalUnit.
                   SAC_INHERIT:
                return org.apache.batik.css.engine.value.ValueConstants.
                         INHERIT_VALUE;
            case org.w3c.css.sac.LexicalUnit.
                   SAC_INTEGER:
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_NUMBER,
                  lu.
                    getIntegerValue(
                      ));
            case org.w3c.css.sac.LexicalUnit.
                   SAC_REAL:
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_NUMBER,
                  lu.
                    getFloatValue(
                      ));
            case org.w3c.css.sac.LexicalUnit.
                   SAC_IDENT:
                if (lu.
                      getStringValue(
                        ).
                      equalsIgnoreCase(
                        org.apache.batik.util.CSSConstants.
                          CSS_NONE_VALUE)) {
                    return org.apache.batik.css.engine.value.ValueConstants.
                             NONE_VALUE;
                }
                throw createInvalidIdentifierDOMException(
                        lu.
                          getStringValue(
                            ));
        }
        throw createInvalidLexicalUnitDOMException(
                lu.
                  getLexicalUnitType(
                    ));
    }
    public org.apache.batik.css.engine.value.Value createStringValue(short type,
                                                                     java.lang.String value,
                                                                     org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException {
        if (type !=
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_IDENT) {
            throw createInvalidStringTypeDOMException(
                    type);
        }
        if (value.
              equalsIgnoreCase(
                org.apache.batik.util.CSSConstants.
                  CSS_NONE_VALUE)) {
            return org.apache.batik.css.engine.value.ValueConstants.
                     NONE_VALUE;
        }
        throw createInvalidIdentifierDOMException(
                value);
    }
    public org.apache.batik.css.engine.value.Value createFloatValue(short type,
                                                                    float floatValue)
          throws org.w3c.dom.DOMException {
        if (type ==
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_NUMBER) {
            return new org.apache.batik.css.engine.value.FloatValue(
              type,
              floatValue);
        }
        throw createInvalidFloatTypeDOMException(
                type);
    }
    public FontSizeAdjustManager() { super(
                                       );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "68EuzQNXUxwbDPAsl/X2R4d6O7JzMr/T0m27vUmOtd3sdfFYlN108cyYv5Qm" +
       "nwugV4ieLARyZsy06LN7Fv38tVr0PvD4Oxb1Xx6LHt05EbzM/D/ma46XLX5Z" +
       "cPSFjP/rl7dR+vrljOAbafJnIMza2GFzVnU5a/z5tVojBZRHd6zx6MvqX+nr" +
       "X17WJIrpCEHG+g8vZohvp8k3A+jMxhBEynk5Ozz3UuwQB9Atl71ukp6X33bJ" +
       "NbjN1S3xk0+evv7VT47+OrtxcfF61Ukaul4JTXP/8ea+/HHXkxU9U+Xk5rDT" +
       "zf7+PYAe/L9djAmg69K/TIl/2zD/RwDd+6LMwc4Z5H7G7+/M9iswBtDxTWY/" +
       "zw9B1HI5HrC0gXQ/5QtgmA5TAimy//10PwqgU3t0oNNNZh9JehR8FJCk2S13" +
       "FzoqL26w+twPPEHcuMjOoMYb7Llt/yTIfObsi/nMvu+M+w98HWQXKncj+XBz" +
       "pfKC+MyTbebtz1c+urnaIppCkqStXE9DJza3bLJG06+Be6/Y2m5bx8mHXrjx" +
       "Uycf2P1yuXEj8N6E3Cfb3Ze/O4JbbpDd9kg+++pPv+m3n/xmduL8v6vw2LTp" +
       "KgAA");
}
