package org.apache.batik.css.engine.value.svg;
public class ClipPathManager extends org.apache.batik.css.engine.value.AbstractValueManager {
    public boolean isInheritedProperty() { return false; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_CLIP_PATH_PROPERTY;
    }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_URI_OR_IDENT; }
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
    public ClipPathManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "9BXwV/ZW+B+2TYZ/Mx4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/wG7Bj1YdCkAAA==");
}
