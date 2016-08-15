package org.apache.batik.css.engine.value.css2;
public class CursorManager extends org.apache.batik.css.engine.value.AbstractValueManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_AUTO_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          AUTO_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_CROSSHAIR_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          CROSSHAIR_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_DEFAULT_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          DEFAULT_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_E_RESIZE_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          E_RESIZE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_HELP_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          HELP_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_MOVE_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          MOVE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_N_RESIZE_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          N_RESIZE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_NE_RESIZE_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          NE_RESIZE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_NW_RESIZE_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          NW_RESIZE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_POINTER_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          POINTER_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_S_RESIZE_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          S_RESIZE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_SE_RESIZE_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          SE_RESIZE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_SW_RESIZE_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          SW_RESIZE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_TEXT_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          TEXT_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_W_RESIZE_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          W_RESIZE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_WAIT_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          WAIT_VALUE); }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_CURSOR_VALUE; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_CURSOR_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.ValueConstants.
                 AUTO_VALUE;
    }
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException { org.apache.batik.css.engine.value.ListValue result =
                                              new org.apache.batik.css.engine.value.ListValue(
                                              );
                                            switch (lu.
                                                      getLexicalUnitType(
                                                        )) {
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_INHERIT:
                                                    return org.apache.batik.css.engine.value.ValueConstants.
                                                             INHERIT_VALUE;
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_URI:
                                                    do  {
                                                        result.
                                                          append(
                                                            new org.apache.batik.css.engine.value.URIValue(
                                                              lu.
                                                                getStringValue(
                                                                  ),
                                                              resolveURI(
                                                                engine.
                                                                  getCSSBaseURI(
                                                                    ),
                                                                lu.
                                                                  getStringValue(
                                                                    ))));
                                                        lu =
                                                          lu.
                                                            getNextLexicalUnit(
                                                              );
                                                        if (lu ==
                                                              null) {
                                                            throw createMalformedLexicalUnitDOMException(
                                                                    );
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
                                                    }while(lu.
                                                             getLexicalUnitType(
                                                               ) ==
                                                             org.w3c.css.sac.LexicalUnit.
                                                               SAC_URI); 
                                                    if (lu.
                                                          getLexicalUnitType(
                                                            ) !=
                                                          org.w3c.css.sac.LexicalUnit.
                                                            SAC_IDENT) {
                                                        throw createInvalidLexicalUnitDOMException(
                                                                lu.
                                                                  getLexicalUnitType(
                                                                    ));
                                                    }
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
                                                      values.
                                                      get(
                                                        s);
                                                    if (v ==
                                                          null) {
                                                        throw createInvalidIdentifierDOMException(
                                                                lu.
                                                                  getStringValue(
                                                                    ));
                                                    }
                                                    result.
                                                      append(
                                                        (org.apache.batik.css.engine.value.Value)
                                                          v);
                                                    lu =
                                                      lu.
                                                        getNextLexicalUnit(
                                                          );
                                            }
                                            if (lu !=
                                                  null) {
                                                throw createInvalidLexicalUnitDOMException(
                                                        lu.
                                                          getLexicalUnitType(
                                                            ));
                                            }
                                            return result;
    }
    public org.apache.batik.css.engine.value.Value computeValue(org.apache.batik.css.engine.CSSStylableElement elt,
                                                                java.lang.String pseudo,
                                                                org.apache.batik.css.engine.CSSEngine engine,
                                                                int idx,
                                                                org.apache.batik.css.engine.StyleMap sm,
                                                                org.apache.batik.css.engine.value.Value value) {
        if (value.
              getCssValueType(
                ) ==
              org.w3c.dom.css.CSSValue.
                CSS_VALUE_LIST) {
            org.apache.batik.css.engine.value.ListValue lv =
              (org.apache.batik.css.engine.value.ListValue)
                value;
            int len =
              lv.
              getLength(
                );
            org.apache.batik.css.engine.value.ListValue result =
              new org.apache.batik.css.engine.value.ListValue(
              ' ');
            for (int i =
                   0;
                 i <
                   len;
                 i++) {
                org.apache.batik.css.engine.value.Value v =
                  lv.
                  item(
                    0);
                if (v.
                      getPrimitiveType(
                        ) ==
                      org.w3c.dom.css.CSSPrimitiveValue.
                        CSS_URI) {
                    result.
                      append(
                        new org.apache.batik.css.engine.value.URIValue(
                          v.
                            getStringValue(
                              ),
                          v.
                            getStringValue(
                              )));
                }
                else {
                    result.
                      append(
                        v);
                }
            }
            return result;
        }
        return super.
          computeValue(
            elt,
            pseudo,
            engine,
            idx,
            sm,
            value);
    }
    public CursorManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "kTckuJlxo4RCRd2yPZaReTyNukpEp8MeOqrLFjMTdKXn55Ez69DqmlIXOY/Q" +
       "covyqYWpmgg66vQIej7vseuOg4VVA2u0MqeZkFINmeG1Plaj1hlmNphqaEgs" +
       "YjI2hpCMN1i2cx+zQl5pVlqNCqzQSZvujTmGEPNurHNmb7jjtHE3ZFo5UrPi" +
       "LZX7QmvaZfGVidpBt1qj+djOK93tTm96lWGX5JeNBmnNMK5PJrlX04aaVaNF" +
       "bWV0a722DhanOipXxbYvZaIsDIyEgisImJq4uYbjcDtYuHhPczKE6Tit9gaG" +
       "t72FHQdqAve00CWWJq54YUVpWlFzXBv0YddZSp1JlRhjHLrNVyGsrX0eBCBv" +
       "kdUal45Thzdgkum3M5zfMgYTB3I/zRo9aTn2UypO+1s9C0CM5vWI6+eTZkVD" +
       "JL+PZCnMgdV+LaB9ZIEOfWI3xK1Zh6Nblt2YRBIqt1PUNfSxILo+t3OnC88x" +
       "4LU0ynAzoxs8l5L+xFJwtsPO2IU+GHTHcqM+alZUr8vsZF0chGavatrSTK5b" +
       "S2UIgp5tsDxvYtwaY4QWWNtGahvJZk2e95vCiOhscqJRGQeo5M0TwZ01uvVl" +
       "JVrnu91K6TGU0LAMr0Z0o5zs93qjpBU3TW67gBvMDltvqcYq1+eiQ1cTetXa" +
       "wKPMGnBwAwcrY90cGOKgpwya63XPynF8K457Gs6siaxBY9IyHDNznaeS5hRv" +
       "2WM85DZwEDi9GWZPV4NMwjG8ZpOVhj9m7dVsJtvGbldnOw0W5lpCkO/WY1ej" +
       "2jWDXXXdrSbz3nZKY9vulGTzqO0s2tR4rmvdaZNdWp1uGtn1HdOZxbSbiSYn" +
       "hvhwIo5ynhMthtaGMWvLQY6QE3EjMUyW9nhXqPW7W2LItqI5M2LxROwieAvj" +
       "LJ7SVNvqt3TwpzmkHMas9GvVNOUyBtc2fS+EzXAYsth60nYTsuU5881iIgdw" +
       "na61OlV2RYWNZcfr5Wx7ERvgjzYiwK1WZbHU1QosErPxRhPl9YYijMAy7arb" +
       "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");
}
