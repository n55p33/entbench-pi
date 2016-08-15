package org.apache.batik.css.engine.value.css2;
public class FontFamilyManager extends org.apache.batik.css.engine.value.AbstractValueManager {
    protected static final org.apache.batik.css.engine.value.ListValue DEFAULT_VALUE =
      new org.apache.batik.css.engine.value.ListValue(
      );
    static { DEFAULT_VALUE.append(new org.apache.batik.css.engine.value.StringValue(
                                    org.w3c.dom.css.CSSPrimitiveValue.
                                      CSS_STRING,
                                    "Arial"));
             DEFAULT_VALUE.append(new org.apache.batik.css.engine.value.StringValue(
                                    org.w3c.dom.css.CSSPrimitiveValue.
                                      CSS_STRING,
                                    "Helvetica"));
             DEFAULT_VALUE.append(new org.apache.batik.css.engine.value.StringValue(
                                    org.w3c.dom.css.CSSPrimitiveValue.
                                      CSS_IDENT,
                                    org.apache.batik.util.CSSConstants.
                                      CSS_SANS_SERIF_VALUE));
    }
    protected static final org.apache.batik.css.engine.value.StringMap
      values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.
                          CSS_CURSIVE_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          CURSIVE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_FANTASY_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          FANTASY_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_MONOSPACE_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          MONOSPACE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_SERIF_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          SERIF_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_SANS_SERIF_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          SANS_SERIF_VALUE);
    }
    public boolean isInheritedProperty() {
        return true;
    }
    public boolean isAnimatableProperty() {
        return true;
    }
    public boolean isAdditiveProperty() {
        return false;
    }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_FONT_FAMILY_VALUE;
    }
    public java.lang.String getPropertyName() {
        return org.apache.batik.util.CSSConstants.
                 CSS_FONT_FAMILY_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return DEFAULT_VALUE;
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
            default:
                throw createInvalidLexicalUnitDOMException(
                        lu.
                          getLexicalUnitType(
                            ));
            case org.w3c.css.sac.LexicalUnit.
                   SAC_IDENT:
            case org.w3c.css.sac.LexicalUnit.
                   SAC_STRING_VALUE:
        }
        org.apache.batik.css.engine.value.ListValue result =
          new org.apache.batik.css.engine.value.ListValue(
          );
        for (;
             ;
             ) {
            switch (lu.
                      getLexicalUnitType(
                        )) {
                case org.w3c.css.sac.LexicalUnit.
                       SAC_STRING_VALUE:
                    result.
                      append(
                        new org.apache.batik.css.engine.value.StringValue(
                          org.w3c.dom.css.CSSPrimitiveValue.
                            CSS_STRING,
                          lu.
                            getStringValue(
                              )));
                    lu =
                      lu.
                        getNextLexicalUnit(
                          );
                    break;
                case org.w3c.css.sac.LexicalUnit.
                       SAC_IDENT:
                    java.lang.StringBuffer sb =
                      new java.lang.StringBuffer(
                      lu.
                        getStringValue(
                          ));
                    lu =
                      lu.
                        getNextLexicalUnit(
                          );
                    if (lu !=
                          null &&
                          lu.
                          getLexicalUnitType(
                            ) ==
                          org.w3c.css.sac.LexicalUnit.
                            SAC_IDENT) {
                        do  {
                            sb.
                              append(
                                ' ');
                            sb.
                              append(
                                lu.
                                  getStringValue(
                                    ));
                            lu =
                              lu.
                                getNextLexicalUnit(
                                  );
                        }while(lu !=
                                 null &&
                                 lu.
                                 getLexicalUnitType(
                                   ) ==
                                 org.w3c.css.sac.LexicalUnit.
                                   SAC_IDENT); 
                        result.
                          append(
                            new org.apache.batik.css.engine.value.StringValue(
                              org.w3c.dom.css.CSSPrimitiveValue.
                                CSS_STRING,
                              sb.
                                toString(
                                  )));
                    }
                    else {
                        java.lang.String id =
                          sb.
                          toString(
                            );
                        java.lang.String s =
                          id.
                          toLowerCase(
                            ).
                          intern(
                            );
                        org.apache.batik.css.engine.value.Value v =
                          (org.apache.batik.css.engine.value.Value)
                            values.
                            get(
                              s);
                        result.
                          append(
                            v !=
                              null
                              ? v
                              : new org.apache.batik.css.engine.value.StringValue(
                              org.w3c.dom.css.CSSPrimitiveValue.
                                CSS_STRING,
                              id));
                    }
            }
            if (lu ==
                  null) {
                return result;
            }
            if (lu.
                  getLexicalUnitType(
                    ) !=
                  org.w3c.css.sac.LexicalUnit.
                    SAC_OPERATOR_COMMA) {
                throw createInvalidLexicalUnitDOMException(
                        lu.
                          getLexicalUnitType(
                            ));
            }
            lu =
              lu.
                getNextLexicalUnit(
                  );
            if (lu ==
                  null) {
                throw createMalformedLexicalUnitDOMException(
                        );
            }
        }
    }
    public org.apache.batik.css.engine.value.Value computeValue(org.apache.batik.css.engine.CSSStylableElement elt,
                                                                java.lang.String pseudo,
                                                                org.apache.batik.css.engine.CSSEngine engine,
                                                                int idx,
                                                                org.apache.batik.css.engine.StyleMap sm,
                                                                org.apache.batik.css.engine.value.Value value) {
        if (value ==
              DEFAULT_VALUE) {
            org.apache.batik.css.engine.CSSContext ctx =
              engine.
              getCSSContext(
                );
            value =
              ctx.
                getDefaultFontFamily(
                  );
        }
        return value;
    }
    public FontFamilyManager() { super();
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "RRNbK/4DV0tn+NAhAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "W3/yfV946XfLM+y/BbkUXYLXLAAA");
}
