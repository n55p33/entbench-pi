package org.apache.batik.css.engine.value;
public abstract class IdentifierManager extends org.apache.batik.css.engine.value.AbstractValueManager {
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException { switch (lu.getLexicalUnitType(
                                                         )) {
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_INHERIT:
                                                    return org.apache.batik.css.engine.value.ValueConstants.
                                                             INHERIT_VALUE;
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_IDENT:
                                                    java.lang.String s =
                                                      lu.
                                                      getStringValue(
                                                        ).
                                                      toLowerCase(
                                                        ).
                                                      intern(
                                                        );
                                                    java.lang.Object v =
                                                      getIdentifiers(
                                                        ).
                                                      get(
                                                        s);
                                                    if (v ==
                                                          null) {
                                                        throw createInvalidIdentifierDOMException(
                                                                lu.
                                                                  getStringValue(
                                                                    ));
                                                    }
                                                    return (org.apache.batik.css.engine.value.Value)
                                                             v;
                                                default:
                                                    throw createInvalidLexicalUnitDOMException(
                                                            lu.
                                                              getLexicalUnitType(
                                                                ));
                                            }
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
        java.lang.Object v =
          getIdentifiers(
            ).
          get(
            value.
              toLowerCase(
                ).
              intern(
                ));
        if (v ==
              null) {
            throw createInvalidIdentifierDOMException(
                    value);
        }
        return (org.apache.batik.css.engine.value.Value)
                 v;
    }
    public abstract org.apache.batik.css.engine.value.StringMap getIdentifiers();
    public IdentifierManager() { super();
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "DS/9G6XeDdyWGAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "0/8XCVH7HqwjAAA=");
}
