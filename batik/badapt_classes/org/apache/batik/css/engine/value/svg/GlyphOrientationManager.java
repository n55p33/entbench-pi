package org.apache.batik.css.engine.value.svg;
public abstract class GlyphOrientationManager extends org.apache.batik.css.engine.value.AbstractValueManager {
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return false; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_ANGLE; }
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException { switch (lu.getLexicalUnitType(
                                                         )) {
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_INHERIT:
                                                    return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                                                             INHERIT_VALUE;
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_DEGREE:
                                                    return new org.apache.batik.css.engine.value.FloatValue(
                                                      org.w3c.dom.css.CSSPrimitiveValue.
                                                        CSS_DEG,
                                                      lu.
                                                        getFloatValue(
                                                          ));
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_GRADIAN:
                                                    return new org.apache.batik.css.engine.value.FloatValue(
                                                      org.w3c.dom.css.CSSPrimitiveValue.
                                                        CSS_GRAD,
                                                      lu.
                                                        getFloatValue(
                                                          ));
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_RADIAN:
                                                    return new org.apache.batik.css.engine.value.FloatValue(
                                                      org.w3c.dom.css.CSSPrimitiveValue.
                                                        CSS_RAD,
                                                      lu.
                                                        getFloatValue(
                                                          ));
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_INTEGER:
                                                    {
                                                        int n =
                                                          lu.
                                                          getIntegerValue(
                                                            );
                                                        return new org.apache.batik.css.engine.value.FloatValue(
                                                          org.w3c.dom.css.CSSPrimitiveValue.
                                                            CSS_DEG,
                                                          n);
                                                    }
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_REAL:
                                                    {
                                                        float n =
                                                          lu.
                                                          getFloatValue(
                                                            );
                                                        return new org.apache.batik.css.engine.value.FloatValue(
                                                          org.w3c.dom.css.CSSPrimitiveValue.
                                                            CSS_DEG,
                                                          n);
                                                    }
                                            }
                                            throw createInvalidLexicalUnitDOMException(
                                                    lu.
                                                      getLexicalUnitType(
                                                        ));
    }
    public org.apache.batik.css.engine.value.Value createFloatValue(short type,
                                                                    float floatValue)
          throws org.w3c.dom.DOMException {
        switch (type) {
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_DEG:
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_GRAD:
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_RAD:
                return new org.apache.batik.css.engine.value.FloatValue(
                  type,
                  floatValue);
        }
        throw createInvalidFloatValueDOMException(
                floatValue);
    }
    public GlyphOrientationManager() { super(
                                         );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "FuNdnicAAA==");
}
