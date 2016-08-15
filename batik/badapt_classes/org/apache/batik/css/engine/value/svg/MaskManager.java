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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "yt5K/wMaYHCUIx4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AAA=");
}
