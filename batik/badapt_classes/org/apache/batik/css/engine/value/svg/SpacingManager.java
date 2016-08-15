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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "IrRSvOJb138AgTbdcn4hAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
