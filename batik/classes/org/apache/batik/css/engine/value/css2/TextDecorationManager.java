package org.apache.batik.css.engine.value.css2;
public class TextDecorationManager extends org.apache.batik.css.engine.value.AbstractValueManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_BLINK_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          BLINK_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_LINE_THROUGH_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          LINE_THROUGH_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_OVERLINE_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          OVERLINE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_UNDERLINE_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          UNDERLINE_VALUE); }
    public boolean isInheritedProperty() { return false; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT_LIST; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_TEXT_DECORATION_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.ValueConstants.
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
                org.apache.batik.css.engine.value.ListValue lv =
                  new org.apache.batik.css.engine.value.ListValue(
                  ' ');
                do  {
                    if (lu.
                          getLexicalUnitType(
                            ) ==
                          org.w3c.css.sac.LexicalUnit.
                            SAC_IDENT) {
                        java.lang.String s =
                          lu.
                          getStringValue(
                            ).
                          toLowerCase(
                            ).
                          intern(
                            );
                        java.lang.Object obj =
                          values.
                          get(
                            s);
                        if (obj ==
                              null) {
                            throw createInvalidIdentifierDOMException(
                                    lu.
                                      getStringValue(
                                        ));
                        }
                        lv.
                          append(
                            (org.apache.batik.css.engine.value.Value)
                              obj);
                        lu =
                          lu.
                            getNextLexicalUnit(
                              );
                    }
                    else {
                        throw createInvalidLexicalUnitDOMException(
                                lu.
                                  getLexicalUnitType(
                                    ));
                    }
                }while(lu !=
                         null); 
                return lv;
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
        if (type !=
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_IDENT) {
            throw createInvalidStringTypeDOMException(
                    type);
        }
        if (!value.
              equalsIgnoreCase(
                org.apache.batik.util.CSSConstants.
                  CSS_NONE_VALUE)) {
            throw createInvalidIdentifierDOMException(
                    value);
        }
        return org.apache.batik.css.engine.value.ValueConstants.
                 NONE_VALUE;
    }
    public TextDecorationManager() { super(
                                       );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "45ef/rXnv1WcEP8/wVTVf20rAAA=");
}
