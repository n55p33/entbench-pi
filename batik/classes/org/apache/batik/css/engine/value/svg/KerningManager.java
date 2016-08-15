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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "ZooQkyyYO0oaxCu+Nf4HC/Z08E4fAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "9MznymPj/wPFz6N4lioAAA==");
}
