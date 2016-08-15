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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1ZC3AV1Rk+9ybkRUJCIIA8wivg8LpX8T2hVAhBgjeQIcDU" +
       "oCTn7j33ZmHv7rJ7NrlBqa+20k51fCCio0yng4OlKIyjY1urxWFatVpnVFpr" +
       "W7WvGW0tVdrROqXV/v/Z3buP+4iZKWZmz92c8//nf5zv/Of/zx49TcaZBmll" +
       "Ko/xEZ2ZsU6V91DDZKkOhZrmZujrl+6roP/c/t6GK6Kkqo9MGKRmt0RNtlZm" +
       "SsrsI7Nk1eRUlZi5gbEUcvQYzGTGEOWypvaRFtnsyuqKLMm8W0sxJNhKjQSZ" +
       "SDk35KTFWZczASezEqBJXGgSXxUebk+QeknTRzzyaT7yDt8IUmY9WSYnTYkd" +
       "dIjGLS4r8YRs8vacQZbomjKSUTQeYzke26Fc4rhgfeKSAhfMO9748dk7B5uE" +
       "CyZRVdW4MM/cxExNGWKpBGn0ejsVljV3ka+SigQZ7yPmpC3hCo2D0DgIda31" +
       "qED7BqZa2Q5NmMPdmap0CRXiZG5wEp0aNOtM0yN0hhlquGO7YAZr5+Stta0s" +
       "MPHeJfF9921veryCNPaRRlntRXUkUIKDkD5wKMsmmWGuSqVYqo9MVGGxe5kh" +
       "U0Xe7ax0sylnVMotWH7XLdhp6cwQMj1fwTqCbYYlcc3Im5cWgHL+G5dWaAZs" +
       "neLZalu4FvvBwDoZFDPSFHDnsFTulNUUJ7PDHHkb264GAmCtzjI+qOVFVaoU" +
       "OkizDRGFqpl4L0BPzQDpOA0AaHAyveSk6GudSjtphvUjIkN0PfYQUNUKRyAL" +
       "Jy1hMjETrNL00Cr51uf0hhV3XK+uU6MkAjqnmKSg/uOBqTXEtImlmcFgH9iM" +
       "9YsT++mUZ/ZGCQHilhCxTfPUDWeuXNp64gWbZkYRmo3JHUzi/dKh5IRXZ3Ys" +
       "uqIC1ajRNVPGxQ9YLnZZjzPSntMhwkzJz4iDMXfwxKafXXPTEfZ+lNR1kSpJ" +
       "U6ws4GiipGV1WWHGVUxlBuUs1UVqmZrqEONdpBreE7LK7N6N6bTJeBepVERX" +
       "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" +
       "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AA==");
}
