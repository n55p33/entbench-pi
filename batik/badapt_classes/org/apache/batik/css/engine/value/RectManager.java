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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "7bRjt1dr7JK2Ty3kVao0kE63JnfTlQDXau5c24SBoAitfUrUiDhL9hyIYGKP" +
       "owzZd2B6iRTr1KgREtuNGLeDh/ueTecdRRTbfFvvdOrWNtDmlusIxt4I1gZr" +
       "CAt1MxnA/eYK74Qt2eu3VRIOGbJJkQwb+0FrSs9oSnGCzOJG8UCZ7OmVOrEs" +
       "CVO0pra32KLZdtJtV1h7+HyFyMIwyVHeNGN77NZsdktwotWnuHYx8JZGc49K" +
       "eafWCzZu5qzRep0wNwtSYBmi5hnrWTy26km/HXVTidVbu5rCbWAryfyBq42y" +
       "Ab2uaQ2qXij6xuzr1tQYRgLiULS+nY4WBDnjQpYWPHXXEJZLaqeIjX5X9Geb" +
       "rjsLC3ZMMrVEsUdkC4+nGeMTWD9GhgXeaXfZLBT3ZD5YzupEY0dNtwI/7YzX" +
       "uLQK5WDGdbYECTwbShwycbssWycCdWwgKtJt26HUDnebOj9ZIWJdlVeuMN7a" +
       "cd7pjgaDDsOztJx4mFEQqeoVVrOl6SuTKPxRL53BdcYyCiwY7vs92+PRrBPP" +
       "m83avtnhGMpGx+OQ3mGSNMn51Zp2F7VtbbKgiaXM12lbG9FsR9mYkt10Gzw8" +
       "6ppiYx/F+LpAtKXGgChvkdzlrMYqM2qtldXk++NNcz10g0z0I2zCAjwzxXVn" +
       "viLVaWNv6Hw0FosiGQfuep9x7fq2Z61WVCOat/INE4uqnYqY7eCxsRfXtZGc" +
       "L/nU0OHueugrTTSdOxbBsD2wLkyIFuuyuZyFioK2mtJ0l6upjjLSPB/th4ja" +
       "XNTFCd7KuWQ50eb6RkZBYLvNpkZrCkmjelObuNZ4uXLZsUKK845eVy1iPczn" +
       "+UbLhGi4QwbNzgiVaZ7r1ggSl50urEyDXsfzPHQJY1Th9oVFFxnN2mKQyoq2" +
       "SNFkOReFzsbhmq1Ec7R6P3FlZDmikdki4HUe7ckdj4wXNsNtBErtpF0NodrG" +
       "1FO6Mq5xrfmgs5jCdUru0g3PnqLYDndFWBuC1dCaBZO8Wx95WHuudQfzPh0Y" +
       "dFKMujDKdVuhzvrCaNLJud5uLNFDjG1pJJ83bUVKZXbSLPRUNcbM3PARfZH5" +
       "C6G+0ZFdRmHwSmhmXU22alySwfs6Q+lLWUxhsS17KDrITIzh5aCzqIeB4cpi" +
       "5svznrPar8Cc2pmBnMKD9Z6L+W4PTUl0MGip6qKFDThyMhbJPVIXGlNE3PUo" +
       "1AIL7pLTrdYKvIcsB7wzw31lkOzZBin6eX1BLGSh4076qQEXPE/turNsGPYE" +
       "b7nfR91V4dVopRsv60ud4PFemk5mRTvDHCxMgtmcZdcEtqB2UjpZqAZiNAQ0" +
       "5MHbrLHzsdGUCw2RmgzXzRVjrkcavgEvfHyDd7uUtrLltLWdw1ot4Ql+2zJb" +
       "jN2LsBU9FFtCKO/kfFg4XgNZu0NmiTdJtLkPdFmZbl1yENIRqKmG8SKPesg8" +
       "2YJlgpC99l5rYLWObtYVZZnly9GgwFcDUgVvu99fvgYbb+z1/JFqJ+LsJA+8" +
       "lZcP1m/gDby4/YBHJzsgD0hynESSkhRnm1vV3427bJxf2FyEyr2gJ+50elft" +
       "A33uwy+9rFK/gBydbMrOE+jBxA++19Eyzbkgqjypfu7Oe15kdXh5vln4Bx/+" +
       "74+zP7B9/xs4Dnn3FT2vivwV8pU/HH+X8tNH0D1nW4evOVa9zPT85Q3DhyIt" +
       "SSOPvbRt+MSZZyvvvgtc8Iln4dsfSdx+z7CK2CExrux5Hx1Cero99Z3l0VWO" +
       "KtWJVSwpx4RWmIrkcJ6ZnNI8c7fjLYxh8KpXjfajV0a7dnKEdSLpsdPRVN89" +
       "HlIkXihaUEaiYv7xstkn0JuUSJMSrdqsPeX87tc/YjunrxL9A6+31XRxE7y6" +
       "kZ85/9HTVGZOnM+8Eecn0P1BZGbAhNtG4Np5iD5YEbx0Z4KfqAg+XTYfT6C3" +
       "HhxTniWWO46+px22Pn/y3OpPfBtWVyn3BLh+7MTqH/v7SbnrFcH101Aev046" +
       "McnOKc+Gyg9GTgysQOzDZTM9lXLrblJKERopVVr/ZKXTz9/l6OcXy+Znk/KT" +
       "CzdITxLvil8/++1m01Pg+vyJXz//Rv06vK1fL9rwpbs8+/Wy+dUEetjQEur8" +
       "3ODcnZWFr3wbFn5HebM8P/3CiYVfeKMW/vTrWvgv7vLsd8rmNwECHyYIKTnl" +
       "EbCmljPlIsxUU+rc5N96IyYXAJgunOKXx5CPveaDocNHLsoXXr7xwDtf5v5d" +
       "dZB99iHKgwT0gJ46zsVTowv960Gk6WZlz4OHM6Sg+vf7CfT066JfcrL/X6n9" +
       "Lw+MXz6B9zswJtD1Q+ciz1cS6G2340mge0B7kfKPE+jmVUqgRfX/It1XE+ih" +
       "czow6KFzkeRrQDogKbv/Jjid4PDrIz4BfiXbk4AU1y7XGmdRfvT1onyhPHnv" +
       "paKi+mzstABIDx+OvaB88eXZ4gPfbP/C4bRfcaT9vpTyAAHdf/jw4KyIePqO" +
       "0k5lXZ88+62Hv/TgM6cFz8MHhc9nywXd3n3743TcDZLqAHz/W+/8Z9/3Sy//" +
       "SXXM8/8AEA63+c8nAAA=");
}
