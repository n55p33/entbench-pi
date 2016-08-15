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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "iya2VvwHIHSONNAhAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "yzPsvwVALOGP1ywAAA==");
}
