package org.apache.batik.css.engine.value.css2;
public class FontSizeManager extends org.apache.batik.css.engine.value.LengthManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_ALL_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          ALL_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_LARGE_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          LARGE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_LARGER_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          LARGER_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_MEDIUM_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          MEDIUM_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_SMALL_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          SMALL_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_SMALLER_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          SMALLER_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_X_LARGE_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          X_LARGE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_X_SMALL_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          X_SMALL_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_XX_LARGE_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          XX_LARGE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_XX_SMALL_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          XX_SMALL_VALUE); }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return true; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_FONT_SIZE_PROPERTY;
    }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_FONT_SIZE_VALUE;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.ValueConstants.
                 MEDIUM_VALUE;
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
                                                                s);
                                                    }
                                                    return (org.apache.batik.css.engine.value.Value)
                                                             v;
                                                default:
                                                    break;
                                            }
                                            return super.
                                              createValue(
                                                lu,
                                                engine);
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
          values.
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
    public org.apache.batik.css.engine.value.Value computeValue(org.apache.batik.css.engine.CSSStylableElement elt,
                                                                java.lang.String pseudo,
                                                                org.apache.batik.css.engine.CSSEngine engine,
                                                                int idx,
                                                                org.apache.batik.css.engine.StyleMap sm,
                                                                org.apache.batik.css.engine.value.Value value) {
        float scale =
          1.0F;
        boolean doParentRelative =
          false;
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
                doParentRelative =
                  true;
                scale =
                  value.
                    getFloatValue(
                      );
                break;
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_EXS:
                doParentRelative =
                  true;
                scale =
                  value.
                    getFloatValue(
                      ) *
                    0.5F;
                break;
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_PERCENTAGE:
                doParentRelative =
                  true;
                scale =
                  value.
                    getFloatValue(
                      ) *
                    0.01F;
                break;
            default:
        }
        if (value ==
              org.apache.batik.css.engine.value.ValueConstants.
                LARGER_VALUE) {
            doParentRelative =
              true;
            scale =
              1.2F;
        }
        else
            if (value ==
                  org.apache.batik.css.engine.value.ValueConstants.
                    SMALLER_VALUE) {
                doParentRelative =
                  true;
                scale =
                  1 /
                    1.2F;
            }
        if (doParentRelative) {
            sm.
              putParentRelative(
                idx,
                true);
            org.apache.batik.css.engine.CSSStylableElement p;
            p =
              org.apache.batik.css.engine.CSSEngine.
                getParentCSSStylableElement(
                  elt);
            float fs;
            if (p ==
                  null) {
                org.apache.batik.css.engine.CSSContext ctx1 =
                  engine.
                  getCSSContext(
                    );
                fs =
                  ctx1.
                    getMediumFontSize(
                      );
            }
            else {
                fs =
                  engine.
                    getComputedStyle(
                      p,
                      null,
                      idx).
                    getFloatValue(
                      );
            }
            return new org.apache.batik.css.engine.value.FloatValue(
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_NUMBER,
              fs *
                scale);
        }
        org.apache.batik.css.engine.CSSContext ctx2 =
          engine.
          getCSSContext(
            );
        float fs =
          ctx2.
          getMediumFontSize(
            );
        java.lang.String s =
          value.
          getStringValue(
            );
        switch (s.
                  charAt(
                    0)) {
            case 'm':
                break;
            case 's':
                fs =
                  (float)
                    (fs /
                       1.2);
                break;
            case 'l':
                fs =
                  (float)
                    (fs *
                       1.2);
                break;
            default:
                switch (s.
                          charAt(
                            1)) {
                    case 'x':
                        switch (s.
                                  charAt(
                                    3)) {
                            case 's':
                                fs =
                                  (float)
                                    (fs /
                                       1.2 /
                                       1.2 /
                                       1.2);
                                break;
                            default:
                                fs =
                                  (float)
                                    (fs *
                                       1.2 *
                                       1.2 *
                                       1.2);
                        }
                        break;
                    default:
                        switch (s.
                                  charAt(
                                    2)) {
                            case 's':
                                fs =
                                  (float)
                                    (fs /
                                       1.2 /
                                       1.2);
                                break;
                            default:
                                fs =
                                  (float)
                                    (fs *
                                       1.2 *
                                       1.2);
                        }
                }
        }
        return new org.apache.batik.css.engine.value.FloatValue(
          org.w3c.dom.css.CSSPrimitiveValue.
            CSS_NUMBER,
          fs);
    }
    protected int getOrientation() { return VERTICAL_ORIENTATION;
    }
    public FontSizeManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "4CosnXp9u1MmFyuy7ycLfrj+2OFTwixNOcbirIddkuNhRU7vbfKHX734N8fu" +
       "uHtCZgUdhT1bgG/hvwa0+I3v/jNvXYRPmyJjCfAPRx95YFHXhg8Fv+dckLs9" +
       "kx+3wEF7vOseTn0Sbiv/ZZhUDJMGxcmhd2BUgn09DHmj7SbWkGfn9OfmgDLh" +
       "6cw6zyVBx+abNujWvHgJdaTGel3ABhfjEm6Ab51jg+uCNhgiorJVsKwSZQcW" +
       "a8XylXBSZVoGBykZ5L3ltkjYOUii6lTLZOcRprKoyDzAK6K2LVgWcrJm+gAv" +
       "M2Qwb+mSsfwyFpfLeddPZc+ZqfUIYfUcT17xr7zI3vSZMMF92lIoaRYJ/5Eb" +
       "Dx5ODBw9TxpxU24i2g3nrEdf//cLkXt//9wUmU4VN8xzNDbONN+cNThlzrbp" +
       "E+cJzwbfnnPnH3/aPrZpJjkJtrVOk3Xg76WgxOrCOzEoyjM3frBo+4bkrhmk" +
       "F0sDcAaH/F7fI89dtkq5MywOT3Jz5B26cpk6c7dEtcXglKhvz9kYK7IG0IwL" +
       "uwK+PscA+oIbwzO6VVh8LdfWq4uwFok9apE+sWSwyeaMwVEjAYsPkZPJBRry" +
       "jJ8VMf4v4MyxYZMp2ndlNZqLfavg2+5otH3mYBRiLaLweJE+UezlZK5q9+pJ" +
       "ZqngfyBFFMf83KQdjX4oHbchwVZTkHSNO0fSdYO7lAPtg3+Se/KsKRgkXfND" +
       "0Vt3vLH7BWG9lbhdsjbj2yqwrXypYgMWEfQLRQJWQJ7o/qZ39jzw3qNSnmB0" +
       "ChCzAwe/9XnktoPSX8hLhxV5534/j7x4CEi3vNgsgqPnz8f3//yh/beEHdyv" +
       "5KQibhgao3p2XULZSD4vF0Up6+Zv1j95e1NJD3iiXlKZ1tW9adabyN2NFXY6" +
       "7oPVu6fw9qYjNWarnIRWu2mEMHprtoz+bPh2Opa7c+ZGX4i1iGHfUaTvLiy+" +
       "Dec+1d6oqynKMXF2rR77rvUguXW2IFkJX9zRKz5zSAqxFlH7cJG+72BxH2RN" +
       "Kt4KCtstAMj9swBIE/Yth091tFJnDkgh1iJKf79I36NYfBcOHxAlXCT6YaO5" +
       "eVWDSNUxu3TyJw+hY7OAUD32tcJnOmqaM0eoEGsRFH5WpO9JLJ7IRSh71N/n" +
       "+Eb8s99Xv4GTEtW5B/f5PPx5s88R/WgWIGzEvmVI5eAwMXMIC7EWgemFIn0v" +
       "YvGMhHAzG6VpTZ5eXCM7e/rk3aMXwD07W8Atge86R/vrZg5cIdYAOGEhSNjV" +
       "fzHqP3G+ItS2qRKJsYyqUO0KXeUuzcpiGHUNDXWLmhDxrcBsbsB1RlrozpYw" +
       "UpHNA33dGYWZmGAL5j9g8TonNYrFKGcCd2x6yQP/jdkCvw2+Qw6Ch2YOfiHW" +
       "ABwl8ig63f4ts5OGVWAHY3kci1Oi+tepAcef7wqCT7B4n5NGCar0pFNB+8Fs" +
       "QdsC31EHn6Mzh7YQa0DxciFIuWtpkWlsdohPapiT4OMjpIIeqliccEdpLzYK" +
       "DsGcM/1LqEiIFHZEoXJsPMPxMS9lpqe27s9mK/AvA5PokGPKvwWWQJTBy4b+" +
       "wOVIXZHBigDQVKRvHha18sA4YKmwINS9cz6RhSdU97+AJwOxIPDUgveCC/Me" +
       "fOUjpfLY4frKBYeveEPcTmQfEmvhgDWa1jT/zZWvXm5abFQVyNbKeyxT6LmE" +
       "k1Vf7DmIk1L8g1qEFkvmpZwsn5YZnMe4G69cxjbHzRdg5KRcVvw8KyF3n4oH" +
       "kgso/ZRfgkwtSAlSiL9+ujWcVHt0MKms+EkiMDqQYDVqunswOj1gMfjFk85q" +
       "ZmS0Wey3A7G7mqczH98l2Yqcw7D4PwPuaTEt/9fAiHL88Nb+a05fdFS+oCga" +
       "3Sdceg2cEeU7jRgU74iWFxzNHat8S8eZOY9XrXQPrzkvOH7ZhBHDxhOvHYsC" +
       "Twp2e/Zl4c0j60/8+kD5K3Ds3klClJO5O/NvazNm2iItO2P5Z+Ed1BJvHZ0d" +
       "909uWDv6t7fEfTjJuwUP0o8orx276tU7Fx5pDZOaXlIG53KWEdfImyf1bUwZ" +
       "t4ZJnWp3Z0BEvBeiWs5Bew7uL4oRSuDiwFmXbcWnNU7a8q8P8h8kqzVjglmb" +
       "jLSewGHgqF7jtciVCVyzpU0zwOC1OEuJ5U0yVuNqgLmOxPpM032XKm0xhZe5" +
       "uWDoDm0SVax1/RerqhcDTyQAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "gDUSlKcpn0qgq2cpgRTl/2m6ZxLowRM6");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("MOj+5jTJddA7IClunw+P3AW+s8Jo8JRYh7OZ7QP046ctunSEa3cyk1Ovm8/d" +
       "8JJYntY+eqHb7M9rv6R+8bUh8/3fbLy+P0mnunKeF708QEP37w/1lZ0WL4XP" +
       "3LK3o74uUS9865Ffvvz80QvsI3uBT7zrlGzvvflRNdILk/JwWf5P3vWPvvvv" +
       "vva18jDI/wOnpUgfRi8AAA==");
}
