package org.apache.batik.css.engine.value.css2;
public class SrcManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_NONE_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          NONE_VALUE); }
    public SrcManager() { super(); }
    public boolean isInheritedProperty() { return false; }
    public boolean isAnimatableProperty() { return false; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_FONT_DESCRIPTOR_SRC_VALUE;
    }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_SRC_PROPERTY;
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
                                                default:
                                                    throw createInvalidLexicalUnitDOMException(
                                                            lu.
                                                              getLexicalUnitType(
                                                                ));
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_IDENT:
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_STRING_VALUE:
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_URI:
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
                                                           SAC_URI:
                                                        java.lang.String uri =
                                                          resolveURI(
                                                            engine.
                                                              getCSSBaseURI(
                                                                ),
                                                            lu.
                                                              getStringValue(
                                                                ));
                                                        result.
                                                          append(
                                                            new org.apache.batik.css.engine.value.URIValue(
                                                              lu.
                                                                getStringValue(
                                                                  ),
                                                              uri));
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
                                                                SAC_FUNCTION) {
                                                            if (!lu.
                                                                  getFunctionName(
                                                                    ).
                                                                  equalsIgnoreCase(
                                                                    "format")) {
                                                                break;
                                                            }
                                                            lu =
                                                              lu.
                                                                getNextLexicalUnit(
                                                                  );
                                                        }
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
                                                        break;
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
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "g8X8N9T4X8dVAK9VIAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
