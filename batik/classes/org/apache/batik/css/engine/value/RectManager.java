package org.apache.batik.css.engine.value;
public abstract class RectManager extends org.apache.batik.css.engine.value.LengthManager {
    protected int orientation;
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException { switch (lu.getLexicalUnitType(
                                                         )) {
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_FUNCTION:
                                                    if (!lu.
                                                          getFunctionName(
                                                            ).
                                                          equalsIgnoreCase(
                                                            "rect")) {
                                                        break;
                                                    }
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_RECT_FUNCTION:
                                                    lu =
                                                      lu.
                                                        getParameters(
                                                          );
                                                    org.apache.batik.css.engine.value.Value top =
                                                      createRectComponent(
                                                        lu);
                                                    lu =
                                                      lu.
                                                        getNextLexicalUnit(
                                                          );
                                                    if (lu ==
                                                          null ||
                                                          lu.
                                                          getLexicalUnitType(
                                                            ) !=
                                                          org.w3c.css.sac.LexicalUnit.
                                                            SAC_OPERATOR_COMMA) {
                                                        throw createMalformedRectDOMException(
                                                                );
                                                    }
                                                    lu =
                                                      lu.
                                                        getNextLexicalUnit(
                                                          );
                                                    org.apache.batik.css.engine.value.Value right =
                                                      createRectComponent(
                                                        lu);
                                                    lu =
                                                      lu.
                                                        getNextLexicalUnit(
                                                          );
                                                    if (lu ==
                                                          null ||
                                                          lu.
                                                          getLexicalUnitType(
                                                            ) !=
                                                          org.w3c.css.sac.LexicalUnit.
                                                            SAC_OPERATOR_COMMA) {
                                                        throw createMalformedRectDOMException(
                                                                );
                                                    }
                                                    lu =
                                                      lu.
                                                        getNextLexicalUnit(
                                                          );
                                                    org.apache.batik.css.engine.value.Value bottom =
                                                      createRectComponent(
                                                        lu);
                                                    lu =
                                                      lu.
                                                        getNextLexicalUnit(
                                                          );
                                                    if (lu ==
                                                          null ||
                                                          lu.
                                                          getLexicalUnitType(
                                                            ) !=
                                                          org.w3c.css.sac.LexicalUnit.
                                                            SAC_OPERATOR_COMMA) {
                                                        throw createMalformedRectDOMException(
                                                                );
                                                    }
                                                    lu =
                                                      lu.
                                                        getNextLexicalUnit(
                                                          );
                                                    org.apache.batik.css.engine.value.Value left =
                                                      createRectComponent(
                                                        lu);
                                                    return new org.apache.batik.css.engine.value.RectValue(
                                                      top,
                                                      right,
                                                      bottom,
                                                      left);
                                            }
                                            throw createMalformedRectDOMException(
                                                    );
    }
    private org.apache.batik.css.engine.value.Value createRectComponent(org.w3c.css.sac.LexicalUnit lu)
          throws org.w3c.dom.DOMException {
        switch (lu.
                  getLexicalUnitType(
                    )) {
            case org.w3c.css.sac.LexicalUnit.
                   SAC_IDENT:
                if (lu.
                      getStringValue(
                        ).
                      equalsIgnoreCase(
                        org.apache.batik.util.CSSConstants.
                          CSS_AUTO_VALUE)) {
                    return org.apache.batik.css.engine.value.ValueConstants.
                             AUTO_VALUE;
                }
                break;
            case org.w3c.css.sac.LexicalUnit.
                   SAC_EM:
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_EMS,
                  lu.
                    getFloatValue(
                      ));
            case org.w3c.css.sac.LexicalUnit.
                   SAC_EX:
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_EXS,
                  lu.
                    getFloatValue(
                      ));
            case org.w3c.css.sac.LexicalUnit.
                   SAC_PIXEL:
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_PX,
                  lu.
                    getFloatValue(
                      ));
            case org.w3c.css.sac.LexicalUnit.
                   SAC_CENTIMETER:
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_CM,
                  lu.
                    getFloatValue(
                      ));
            case org.w3c.css.sac.LexicalUnit.
                   SAC_MILLIMETER:
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_MM,
                  lu.
                    getFloatValue(
                      ));
            case org.w3c.css.sac.LexicalUnit.
                   SAC_INCH:
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_IN,
                  lu.
                    getFloatValue(
                      ));
            case org.w3c.css.sac.LexicalUnit.
                   SAC_POINT:
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_PT,
                  lu.
                    getFloatValue(
                      ));
            case org.w3c.css.sac.LexicalUnit.
                   SAC_PICA:
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_PC,
                  lu.
                    getFloatValue(
                      ));
            case org.w3c.css.sac.LexicalUnit.
                   SAC_INTEGER:
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_NUMBER,
                  lu.
                    getIntegerValue(
                      ));
            case org.w3c.css.sac.LexicalUnit.
                   SAC_REAL:
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_NUMBER,
                  lu.
                    getFloatValue(
                      ));
            case org.w3c.css.sac.LexicalUnit.
                   SAC_PERCENTAGE:
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_PERCENTAGE,
                  lu.
                    getFloatValue(
                      ));
        }
        throw createMalformedRectDOMException(
                );
    }
    public org.apache.batik.css.engine.value.Value computeValue(org.apache.batik.css.engine.CSSStylableElement elt,
                                                                java.lang.String pseudo,
                                                                org.apache.batik.css.engine.CSSEngine engine,
                                                                int idx,
                                                                org.apache.batik.css.engine.StyleMap sm,
                                                                org.apache.batik.css.engine.value.Value value) {
        if (value.
              getCssValueType(
                ) !=
              org.w3c.dom.css.CSSValue.
                CSS_PRIMITIVE_VALUE) {
            return value;
        }
        if (value.
              getPrimitiveType(
                ) !=
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_RECT) {
            return value;
        }
        org.apache.batik.css.engine.value.RectValue rect =
          (org.apache.batik.css.engine.value.RectValue)
            value;
        orientation =
          VERTICAL_ORIENTATION;
        org.apache.batik.css.engine.value.Value top =
          super.
          computeValue(
            elt,
            pseudo,
            engine,
            idx,
            sm,
            rect.
              getTop(
                ));
        org.apache.batik.css.engine.value.Value bottom =
          super.
          computeValue(
            elt,
            pseudo,
            engine,
            idx,
            sm,
            rect.
              getBottom(
                ));
        orientation =
          HORIZONTAL_ORIENTATION;
        org.apache.batik.css.engine.value.Value left =
          super.
          computeValue(
            elt,
            pseudo,
            engine,
            idx,
            sm,
            rect.
              getLeft(
                ));
        org.apache.batik.css.engine.value.Value right =
          super.
          computeValue(
            elt,
            pseudo,
            engine,
            idx,
            sm,
            rect.
              getRight(
                ));
        if (top !=
              rect.
              getTop(
                ) ||
              right !=
              rect.
              getRight(
                ) ||
              bottom !=
              rect.
              getBottom(
                ) ||
              left !=
              rect.
              getLeft(
                )) {
            return new org.apache.batik.css.engine.value.RectValue(
              top,
              right,
              bottom,
              left);
        }
        else {
            return value;
        }
    }
    protected int getOrientation() { return orientation;
    }
    private org.w3c.dom.DOMException createMalformedRectDOMException() {
        java.lang.Object[] p =
          new java.lang.Object[] { getPropertyName(
                                     ) };
        java.lang.String s =
          org.apache.batik.css.engine.value.Messages.
          formatMessage(
            "malformed.rect",
            p);
        return new org.w3c.dom.DOMException(
          org.w3c.dom.DOMException.
            SYNTAX_ERR,
          s);
    }
    public RectManager() { super(); }
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
      ("H4sIAAAAAAAAAL1aeczs1lX3+5K8LG3zXtIthCZN2hcgmfJ5xsssCi2dxct4" +
       "7Nns8cwYaOrxMvaM921sl9BFXanUViUtRbQRf5QthLZCoFZiURBLi4qQisoq" +
       "0SKExFqJ/sEiynbt+fa890JUxCf5fnfsc84959xzfvf4Xj/7Dei2MIAqnmtl" +
       "a8uNDrU0OtxY+GGUeVp4yLD4WA5CTe1achgK4N4Tyus+d+VfvvUR4+oBdFmC" +
       "Xi47jhvJkek64VQLXSvRVBa6cnqXsDQ7jKCr7EZOZDiOTAtmzTB6nIVecoY1" +
       "gq6xxyrAQAUYqACXKsDtUyrA9DLNie1uwSE7UehDPwJdYqHLnlKoF0EPnxfi" +
       "yYFsH4kZlxYACXcUv0VgVMmcBtBDJ7bvbX6ewR+rwE/9+Fuu/tIt0BUJumI6" +
       "fKGOApSIwCAS9FJbs1daELZVVVMl6B5H01ReC0zZMvNSbwm6NzTXjhzFgXbi" +
       "pOJm7GlBOeap516qFLYFsRK5wYl5uqlZ6vGv23RLXgNbX3Vq695CsrgPDLzL" +
       "BIoFuqxoxyy3bk1HjaDXXuQ4sfHaABAA1tttLTLck6FudWRwA7p3P3eW7Kxh" +
       "PgpMZw1Ib3NjMEoE3X9DoYWvPVnZymvtiQi67yLdeP8IUN1ZOqJgiaBXXiQr" +
       "JYFZuv/CLJ2Zn28Mv+9Db3No56DUWdUUq9D/DsD04AWmqaZrgeYo2p7xpY+x" +
       "H5df9evvP4AgQPzKC8R7ms//8Dff/IYHn/vSnuY7r0MzWm00JXpC+fTq7q+8" +
       "pvto65ZCjTs8NzSLyT9neRn+46Mnj6ceyLxXnUgsHh4eP3xu+rvLdzyj/cMB" +
       "dFcfuqy4VmyDOLpHcW3PtLSA0hwtkCNN7UN3ao7aLZ/3odtBnzUdbX93pOuh" +
       "FvWhW63y1mW3/A1cpAMRhYtuB33T0d3jvidHRtlPPQiCroILeiW4HoH2f+X/" +
       "CHorbLi2BsuK7JiOC48Dt7A/hDUnWgHfGvAKRP0WDt04ACEIu8EalkEcGNrR" +
       "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" +
       "i5xBVou8Gc4Y9QqfB9WcleuNlBcQG+d9xEhFQqEYYR1W19WRJFuaZLkBsbPn" +
       "9e5SGLYNxGG2A1GaTZkWW7OigTOT6lSTjeKdYld3syz1YiUwu+Ol5EtW4EVS" +
       "E++brpTqzMwWWy4VbfPaajVJFlhvt5wPqPbSlvlJhOHsiKPILtrJtN1u2lpR" +
       "3lZrt8kN7aWbpNYYshuVcwWmUx9VxZmfiIwyW7eCSavPo9P+hBkJdZkbTMXm" +
       "SuzU17q8o7mcIWrIHG77XoZNjC0mTwyhu9xOJN426uzWbFaGLSVBGy12Lhsk" +
       "3+m5jj3ITNhbtGsdw0TCLp9T/K6H5JQfr5aEEODRojqduF2sP5uGVTRHQykc" +
       "s3OsCePSkMu4sTDXk565yunEwlbNaoOrhYuxaIJyYyLFvrhutkdzs4bO8VXq" +
       "ZVOzzTGjnEhIq0bXcD3kVpscT02nOutPF5FHCvPaYjJo2mY3GCjcdL6wd9V0" +
       "w8SzsDprDGxJcknwkpYtDGxjbuUQURrbqs02F8tMMETBWwVYj8cH67VRnU1m" +
       "TRD1vIo3h1mSkEpzuTaGQsfKhba6o9JxpZ8wrdjSNyjJdD1BUMmqrySz6gJn" +
       "26HgdVQY4RvIpDUZ8Z6sDnmCZIZwuO06ziTHd4vQnVd1uSsMiY04ZDikTYd0" +
       "jW9Ledew7YSE591RT91iysD0uwS349pYe6AhGkBzeYnwnM77LT9GbRtHqo14" +
       "0emNOg1Tam9DqjFfbJae5TY6YY3EkIEnDyve0prORDOa2VjSqYXd4ay9or02" +
       "KntkU0aDKK6sxF0qSets2M6bm/oqbbfmTm0LwqsJ8ndFo7VsmAZ81iIydr30" +
       "ZSUTapxoNq1BuGuteQPfqQ4jsq2JFeQ515RmdEDFNhtwhDscupIymM785Zgz" +
       "xs5IcrbbSnvOtjK7GptWvw5X8HE+BbiCjlEcNQi+S06oBdsmdhN4GadjIlxs" +
       "NHLLd3V06LdqeRPXEB5t2GTX5XjMEiiaQJAl2awDD0Z1fLTEW2Q+lhvxyhgm" +
       "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" +
       "VvDr288nAAA=");
}
