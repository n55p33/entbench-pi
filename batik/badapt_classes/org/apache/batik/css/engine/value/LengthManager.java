package org.apache.batik.css.engine.value;
public abstract class LengthManager extends org.apache.batik.css.engine.value.AbstractValueManager {
    static final double SQRT2 = java.lang.Math.sqrt(2.0);
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException { switch (lu.getLexicalUnitType(
                                                         )) {
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
                                            throw createInvalidLexicalUnitDOMException(
                                                    lu.
                                                      getLexicalUnitType(
                                                        ));
    }
    public org.apache.batik.css.engine.value.Value createFloatValue(short type,
                                                                    float floatValue)
          throws org.w3c.dom.DOMException {
        switch (type) {
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_PERCENTAGE:
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_EMS:
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_EXS:
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_PX:
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_CM:
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_MM:
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_IN:
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_PT:
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_PC:
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_NUMBER:
                return new org.apache.batik.css.engine.value.FloatValue(
                  type,
                  floatValue);
        }
        throw createInvalidFloatTypeDOMException(
                type);
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
        switch (value.
                  getPrimitiveType(
                    )) {
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_NUMBER:
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_PX:
                return value;
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_MM:
                org.apache.batik.css.engine.CSSContext ctx =
                  engine.
                  getCSSContext(
                    );
                float v =
                  value.
                  getFloatValue(
                    );
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_NUMBER,
                  v /
                    ctx.
                    getPixelUnitToMillimeter(
                      ));
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_CM:
                ctx =
                  engine.
                    getCSSContext(
                      );
                v =
                  value.
                    getFloatValue(
                      );
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_NUMBER,
                  v *
                    10.0F /
                    ctx.
                    getPixelUnitToMillimeter(
                      ));
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_IN:
                ctx =
                  engine.
                    getCSSContext(
                      );
                v =
                  value.
                    getFloatValue(
                      );
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_NUMBER,
                  v *
                    25.4F /
                    ctx.
                    getPixelUnitToMillimeter(
                      ));
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_PT:
                ctx =
                  engine.
                    getCSSContext(
                      );
                v =
                  value.
                    getFloatValue(
                      );
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_NUMBER,
                  v *
                    25.4F /
                    (72.0F *
                       ctx.
                       getPixelUnitToMillimeter(
                         )));
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_PC:
                ctx =
                  engine.
                    getCSSContext(
                      );
                v =
                  value.
                    getFloatValue(
                      );
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_NUMBER,
                  v *
                    25.4F /
                    (6.0F *
                       ctx.
                       getPixelUnitToMillimeter(
                         )));
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_EMS:
                sm.
                  putFontSizeRelative(
                    idx,
                    true);
                v =
                  value.
                    getFloatValue(
                      );
                int fsidx =
                  engine.
                  getFontSizeIndex(
                    );
                float fs;
                fs =
                  engine.
                    getComputedStyle(
                      elt,
                      pseudo,
                      fsidx).
                    getFloatValue(
                      );
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_NUMBER,
                  v *
                    fs);
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_EXS:
                sm.
                  putFontSizeRelative(
                    idx,
                    true);
                v =
                  value.
                    getFloatValue(
                      );
                fsidx =
                  engine.
                    getFontSizeIndex(
                      );
                fs =
                  engine.
                    getComputedStyle(
                      elt,
                      pseudo,
                      fsidx).
                    getFloatValue(
                      );
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_NUMBER,
                  v *
                    fs *
                    0.5F);
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_PERCENTAGE:
                ctx =
                  engine.
                    getCSSContext(
                      );
                switch (getOrientation(
                          )) {
                    case HORIZONTAL_ORIENTATION:
                        sm.
                          putBlockWidthRelative(
                            idx,
                            true);
                        fs =
                          value.
                            getFloatValue(
                              ) *
                            ctx.
                            getBlockWidth(
                              elt) /
                            100.0F;
                        break;
                    case VERTICAL_ORIENTATION:
                        sm.
                          putBlockHeightRelative(
                            idx,
                            true);
                        fs =
                          value.
                            getFloatValue(
                              ) *
                            ctx.
                            getBlockHeight(
                              elt) /
                            100.0F;
                        break;
                    default:
                        sm.
                          putBlockWidthRelative(
                            idx,
                            true);
                        sm.
                          putBlockHeightRelative(
                            idx,
                            true);
                        double w =
                          ctx.
                          getBlockWidth(
                            elt);
                        double h =
                          ctx.
                          getBlockHeight(
                            elt);
                        fs =
                          (float)
                            (value.
                               getFloatValue(
                                 ) *
                               (java.lang.Math.
                                  sqrt(
                                    w *
                                      w +
                                      h *
                                      h) /
                                  SQRT2) /
                               100.0);
                }
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_NUMBER,
                  fs);
        }
        return value;
    }
    protected static final int HORIZONTAL_ORIENTATION =
      0;
    protected static final int VERTICAL_ORIENTATION =
      1;
    protected static final int BOTH_ORIENTATION =
      2;
    protected abstract int getOrientation();
    public LengthManager() { super(); }
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
       "zzWOTq422AR6OAnCP+saO8O9QOp+QOmFex8dj6uHAOdH7l/+6O8/Jf2Y/aE3" +
       "cKn47it8XiX5j8Zf+HX6h7S/dQTdd3YAf8cThctIL14+dn8kMpI08qVLh+9P" +
       "Xz58fxdI8Ilm4atngueGvcNi1cHm+w+OceXm6Ohg0tPztneWV8BZU6tufmNF" +
       "O2bLsyLFnflOcgrz3GtdE5Oi2K9KVW9/50pv104ugk8oPXnamx54xz1u3M81" +
       "IywtUSH/vTL7dAK9SYsMJTGqK49TzB9+/avqc/jK0X/29Y7VLl4lVRU/c1n5" +
       "z4Kknyhf/9NX/pWTwQdiO4iSu7aYbqAkFb0v3l295effrwB+pcw+n0A3Dyqk" +
       "SsxKL2X9586V849/UOU8DVJxopziT0c51yuA66cWP34drxOTvVtexJZvtIzD" +
       "lUGVvVJm8imVW69FpSRhjJWK689VPP3qa9yzfrnM/kVSvnLywvTEP6/o9Us/" +
       "gF6rW4DnQfrmiV6/+Qb0WsXo6uT/p+6q3IuCfPU12v5DmX0lgR61jISLHKBY" +
       "5fTeXz4X89++ETHzBHrLpWck5T34k3e8Wzu8tdJ+8ZUbD73jldnXq5cUZ++h" +
       "Hmahh8zUdS9eW14oXw8jw3QqAR4+XGKG1d9vJ9Czrxs4kpO7gIrx3zog/s5J" +
       "ZLwHYgJdPxQu4nw7gd52N5wEug/kFyH/IxigVyEBF9X/Rbj/nECPnMOBTg+F" +
       "iyC/B6gDkLL4++Gp07deP1jiJ1N55cQndsmvXZ6tz8z9+OuZ+8IE/75L03L1" +
       "iPF0Ck0Pzxhva198ZTj5ie+1Pnd4daK5SlGUVB5ioQcPD2DOpuFn70ntlNb1" +
       "wfPff/SXHn7udMnw6IHh86Fygbd33/1ZR98Lk+ohRvHP3vFPf/QfvPLN6sLz" +
       "/wJ6dYwTXSoAAA==");
}
