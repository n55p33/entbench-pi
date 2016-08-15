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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AAA=");
}
