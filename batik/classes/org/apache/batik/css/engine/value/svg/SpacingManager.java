package org.apache.batik.css.engine.value.svg;
public class SpacingManager extends org.apache.batik.css.engine.value.LengthManager {
    protected java.lang.String property;
    public SpacingManager(java.lang.String prop) { super();
                                                   property = prop; }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return true; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_SPACING_VALUE; }
    public java.lang.String getPropertyName() { return property; }
    public org.apache.batik.css.engine.value.Value getDefaultValue() { return org.apache.batik.css.engine.value.svg.SVGValueConstants.
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
                return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                         INHERIT_VALUE;
            case org.w3c.css.sac.LexicalUnit.
                   SAC_IDENT:
                if (lu.
                      getStringValue(
                        ).
                      equalsIgnoreCase(
                        org.apache.batik.util.CSSConstants.
                          CSS_NORMAL_VALUE)) {
                    return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                             NORMAL_VALUE;
                }
                throw createInvalidIdentifierDOMException(
                        lu.
                          getStringValue(
                            ));
        }
        return super.
          createValue(
            lu,
            engine);
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
                  CSS_NORMAL_VALUE)) {
            return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                     NORMAL_VALUE;
        }
        throw createInvalidIdentifierDOMException(
                value);
    }
    protected int getOrientation() { return BOTH_ORIENTATION;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "hFaKV3zr+g9DKHY6fiEAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
