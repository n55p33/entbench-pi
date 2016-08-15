package org.apache.batik.css.engine.value.svg;
public class MaskManager extends org.apache.batik.css.engine.value.AbstractValueManager {
    public boolean isInheritedProperty() { return false; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_URI_OR_IDENT; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_MASK_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.ValueConstants.
                 NONE_VALUE;
    }
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException { switch (lu.
                                                      getLexicalUnitType(
                                                        )) {
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_INHERIT:
                                                    return org.apache.batik.css.engine.value.ValueConstants.
                                                             INHERIT_VALUE;
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
                if (value.
                      equalsIgnoreCase(
                        org.apache.batik.util.CSSConstants.
                          CSS_NONE_VALUE)) {
                    return org.apache.batik.css.engine.value.ValueConstants.
                             NONE_VALUE;
                }
                break;
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
    public MaskManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "yt5K/wOMhPYjIx4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AAA=");
}
