package org.apache.batik.css.engine.value.svg;
public class ColorProfileManager extends org.apache.batik.css.engine.value.AbstractValueManager {
    public boolean isInheritedProperty() { return true; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_COLOR_PROFILE_PROPERTY;
    }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_URI_OR_IDENT;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 AUTO_VALUE;
    }
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException {
        switch (lu.
                  getLexicalUnitType(
                    )) {
            case org.w3c.css.sac.LexicalUnit.
                   SAC_INHERIT:
                return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                         INHERIT_VALUE;
            case org.w3c.css.sac.LexicalUnit.
                   SAC_IDENT:
                java.lang.String s =
                  lu.
                  getStringValue(
                    ).
                  toLowerCase(
                    );
                if (s.
                      equals(
                        org.apache.batik.util.CSSConstants.
                          CSS_AUTO_VALUE)) {
                    return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                             AUTO_VALUE;
                }
                if (s.
                      equals(
                        org.apache.batik.util.CSSConstants.
                          CSS_SRGB_VALUE)) {
                    return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                             SRGB_VALUE;
                }
                return new org.apache.batik.css.engine.value.StringValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_IDENT,
                  s);
            case org.w3c.css.sac.LexicalUnit.
                   SAC_URI:
                return new org.apache.batik.css.engine.value.URIValue(
                  lu.
                    getStringValue(
                      ),
                  resolveURI(
                    engine.
                      getCSSBaseURI(
                        ),
                    lu.
                      getStringValue(
                        )));
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
        switch (type) {
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_IDENT:
                java.lang.String s =
                  value.
                  toLowerCase(
                    );
                if (s.
                      equals(
                        org.apache.batik.util.CSSConstants.
                          CSS_AUTO_VALUE)) {
                    return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                             AUTO_VALUE;
                }
                if (s.
                      equals(
                        org.apache.batik.util.CSSConstants.
                          CSS_SRGB_VALUE)) {
                    return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                             SRGB_VALUE;
                }
                return new org.apache.batik.css.engine.value.StringValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_IDENT,
                  s);
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_URI:
                return new org.apache.batik.css.engine.value.URIValue(
                  value,
                  resolveURI(
                    engine.
                      getCSSBaseURI(
                        ),
                    value));
        }
        throw createInvalidStringTypeDOMException(
                type);
    }
    public ColorProfileManager() { super(
                                     ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "JYNBVSlwx66LLvgvzRX4dfAYNoLG7MFPx+qDI1sokj3T/s2FUstIs4OxjWNz" +
       "Sby+PT3g+PPnguA32FzhpMIC1cq200H7y/8FtAk4505zoYbV36Ip9/vWnbR0" +
       "/lRZwcJTO94TJU/y3rgEjrDRuKJ4jl7eY1iebrCoLCwssSpmXXxdm8Fdk/d+" +
       "ECWhFXb80WL9kJPaGVlhcUaT8cBm/MjeRmkYOcmzXrw8f4bMPx0PqAWtl/Jj" +
       "OC35KUEL8e2l+4STIpcOJrVevCSfgnQgwddburMnH5gZrmYoMQyoRYXb2Eua" +
       "yJpanws/qp7Jjzzl98qUmkP8T+QcyuPWP0UD0oVTW7v2337geeuyTFLoxARK" +
       "KYajuHUll6w+a9NKc2TltTfcmXexcJVTI6Rc1nl1E94M+0hcbC323R6Z9clL" +
       "pPdPb7z0q8m8d6G62UmyYOtW7fT8S2P9JdGU0ONQ9u8MTy05oFIX11pNDc+M" +
       "b2qMfvoHcfVBrBJlaXr6AenqmV2/PrrodE2AFHeQXCh/WKKfFMnmlnF1G5NG" +
       "jX5SKputCVARpMhUSaln5uEmoxgIBC42nKXJXrxF5aRuapU29e65SNHGmLFZ" +
       "i6sRFAMVUbHb49xCpBTwcV33Mbg9nsKUWSERVwO8diDcqevOFWROuS7CTTRt" +
       "hMzKFq/4lvMfKPrS5kMeAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1aDewsV1Wf93/ta/sofa8tlFr63VewbP3P7sx+UsTOzu7s" +
       "zO7szO7O7MeMSJnvmd35ntmd2YUq4AdVIhBtESI0mEBQUigxoCQGUjUIBKJi" +
       "iIqJlKhREIhUIxqr4p3Z/3ffew1p4z9v7pu995xzz+/cc88999554nvQlVEI" +
       "FXzPXhu2F+9qabw7tyu78drXot0uXRlIYaSpuC1FEQ/qHlLu/uS5Hzz7HvP8" +
       "DnRGhG6UXNeLpdjy3GikRZ690lQaOndY27Y1J4qh8/RcWknwMrZsmLai+AEa" +
       "eskR1hi6QO+rAAMVYKACnKsAY4dUgOmlmrt08IxDcuMogH4WOkVDZ3wlUy+G" +
       "7jouxJdCydkTM8gRAAlXZ78nAFTOnIbQnQfYt5ifA/ixAvzob7zx/O+ehs6J" +
       "0DnL5TJ1FKBEDDoRoWsdzZG1MMJUVVNF6HpX01ROCy3Jtja53iJ0Q2QZrhQv" +
       "Q+3ASFnl0tfCvM9Dy12rZNjCpRJ74QE83dJsdf/XlbotGQDrTYdYtwiJrB4A" +
       "PGsBxUJdUrR9lisWlqvG0B0nOQ4wXugBAsB6laPFpnfQ1RWuBCqgG7ZjZ0uu" +
       "AXNxaLkGIL3SW4JeYuiWSwrNbO1LykIytIdi6OaTdINtE6C6JjdExhJDLz9J" +
       "lksCo3TLiVE6Mj7fY173rje7pLuT66xqip3pfzVguv0E00jTtVBzFW3LeO1r" +
       "6PdKN332kR0IAsQvP0G8pfn9tzzz4P23P/XFLc0rL0LDynNNiR9SPixf99Vb" +
       "8fsapzM1rva9yMoG/xjy3P0Hey0PpD6YeTcdSMwad/cbnxr9ifDWj2nf2YHO" +
       "UtAZxbOXDvCj6xXP8S1bCzuaq4VSrKkUdI3mqnjeTkFXgXfacrVtLavrkRZT" +
       "0BV2XnXGy38DE+lARGaiq8C75ere/rsvxWb+nvoQBF0FHuha8Lwa2v7l/8eQ" +
       "DZueo8GSIrmW68GD0MvwR7DmxjKwrQnLwOsXcOQtQ+CCsBcasAT8wNT2GpQo" +
       "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" +
       "Pvr4N/Jb0f8D1hdF4YQpAAA=");
}
