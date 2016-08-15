package org.apache.batik.css.engine.value.svg;
public class KerningManager extends org.apache.batik.css.engine.value.LengthManager {
    public boolean isInheritedProperty() { return true; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_KERNING_PROPERTY;
    }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return true; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_KERNING_VALUE; }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 AUTO_VALUE;
    }
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException { switch (lu.
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
                                                              CSS_AUTO_VALUE)) {
                                                        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                                                                 AUTO_VALUE;
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
                  CSS_AUTO_VALUE)) {
            return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                     AUTO_VALUE;
        }
        throw createInvalidIdentifierDOMException(
                value);
    }
    protected int getOrientation() { return HORIZONTAL_ORIENTATION;
    }
    public KerningManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "U4SYZMHcUdIgXvGt8T+uLMh2Th8AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Pfat/Nj4/wDGisM9lioAAA==");
}
