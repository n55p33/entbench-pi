package org.apache.batik.css.engine.value.svg;
public class MarkerManager extends org.apache.batik.css.engine.value.AbstractValueManager {
    protected java.lang.String property;
    public MarkerManager(java.lang.String prop) { super();
                                                  property = prop; }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_URI_OR_IDENT; }
    public java.lang.String getPropertyName() { return property; }
    public org.apache.batik.css.engine.value.Value getDefaultValue() { return org.apache.batik.css.engine.value.ValueConstants.
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
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "+sZIu+hib9Z/AJS0g0t0IAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "KwAA");
}
