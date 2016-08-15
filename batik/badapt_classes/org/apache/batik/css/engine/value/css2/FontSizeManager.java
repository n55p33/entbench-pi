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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "KiwpvL7dKZOLFdn3k3k/XH/s8ClhlqYcY2HWwy7K8bAip/c2+cOvXvybY3fc" +
       "PSGzglXFPVuAb/6/BrT4je/+M29dhE8rkLEE+IejjzywoGvDh4Lfcy7I3ZHJ" +
       "j1vgoD3edQ+nPgm3V/4yTKqGSZPi5NA7MCrBvh6GvNF2E2vIs3P6c3NAmfB0" +
       "Zp3noqBj800bdGtevIQ6UmO9IWCDC3EJN8C3zrHBdUEbDBFR2SpYVopyFRZr" +
       "xfKVcVJjWgYHKRnkvZW2SNg5SKLqVMtk5xGmsqDEPMArorYtWOZzsmbqAC8z" +
       "ZDBv6ZKx/DIWl8t51xey50xhPUJYPceTV/yrLLE3fSZMcJ8uLpY0i4T/yI0H" +
       "DycGjp4njbglNxHthnPWo6//+4XIvb9/rkCmU8MN8xyNjTPNN2cdTpmzbfrE" +
       "ecKzwbdn3fnHn3aMbZpOToJtbVNkHfh7CSixuvhODIryzI0fLNi+IblrGunF" +
       "kgCcwSG/1/fIc5etVO4Mi8OT3Bx5h65cps7cLVFrMTgl6ttzNsbyrAG04sIu" +
       "h6/PMYC+4MbwjG4lFl/LtfXaEqwlYo9aok8sGWyyWWNw1EjA4kPkZHKBhjzj" +
       "ZyWM/ws4c2zYZIr2XVmNZmPfSvi2Oxptnz4YxVhLKDxeok8UezmZrdq9epJZ" +
       "KvgfSBHFMT83aUejH0rHbUiw1RQkXePOkXTd4C7lQMfgn+SePKsAg6RrfSh6" +
       "6443dr8grLcat0vWZnxbBbaVL1VswiKCfqFEwArIE93f8s6eB957VMoTjE4B" +
       "Ynbg4Lc+j9x2UPoLeemwPO/c7+eRFw8B6ZaVmkVw9Pz5+P6fP7T/lrCD+5Wc" +
       "VMUNQ2NUz65LKBvJ5+SiKGXd/M3GJ29vKesBT9RLqtO6ujfNehO5u7HKTsd9" +
       "sHr3FN7edKTGbJWT0Go3jRBGb82U0Z8N307HcndO3+iLsZYw7DtK9N2Fxbfh" +
       "3KfaG3U1RTkmzq7VY9+1HiS3zhQkK+CLO3rFpw9JMdYSah8u0fcdLO6DrEnF" +
       "W0Fhu0UAuX8GAGnBvmXwqY5W6vQBKcZaQunvl+h7FIvvwuEDooSLRD9sNDev" +
       "ahKpOmaXTv7kIXRsBhBqxL42+ExHTXP6CBVjLYHCz0r0PYnFE7kIZY/6+xzf" +
       "iH/2++o3cFKmOvfgPp+HP2/2OaIfzQCEzdi3FKkcHCamD2Ex1hIwvVCi70Us" +
       "npEQbmajNK3J04trZGdPnbx79AK4Z2cKuEXwXedof930gSvGGgAnLAQJu/ov" +
       "RP0nzleE2jZVIjGWURWqXaGr3KVZUQqjrqGhblETIr4VmM0NuM5I893ZEkYq" +
       "snmgrzujMBMTbMH8Byxe56ROsRjlTOCOTS954L8xU+C3w3fIQfDQ9MEvxhqA" +
       "o0weRafavxV20rCK7GAsj2NxSlT/Whhw/PmuIPgEi/c5aZagSk9aCNoPZgra" +
       "xfAddfA5On1oi7EGFK8UglS6lhaZwmaH+KSGOQk+PkIq6KGKxQl3lI5So+AQ" +
       "zDnTv4SKhEhxRxSqxMYzHB/zUma6sHV/NlOBfymYxCo5pvxbZAlEGbxs6A9c" +
       "jjSUGKwEAC0l+uZgUS8PjAOWCgtC3TvnE1l4Qg3/C3gyEAsCTy14Lzg/78FX" +
       "PlIqjx1urJ53+Io3xO1E9iGxHg5Yo2lN899c+eqVpsVGVYFsvbzHMoWeizhZ" +
       "+cWegzgpxz+oRWihZF7CybIpmcF5jLvxymVsd9x8EUZOKmXFz7MCcvdCPJBc" +
       "QOmn/BJkakFKkEL89dOt4aTWo4NJZcVPEoHRgQSrUdPdg9GpAYvBL550VjMj" +
       "o81Cvx2I3dU6lfn4LsmW5xyGxf8ZcE+Lafm/BkaU44e39l9z+qKj8gVF0eg+" +
       "4dLr4Iwo32nEoHhHtKzoaO5YlVtWnZn1eM0K9/Ca84Ljl00YMWw88dqxIPCk" +
       "YHdkXxbePLL+xK8PVL4Cx+6dJEQ5mb0z/7Y2Y6YtsnhnLP8svINa4q2jc9X9" +
       "kxvWjv7tLXEfTvJuwYP0I8prx6569c75R9rCpK6XVMC5nGXENfLmSX0bU8at" +
       "YdKg2t0ZEBHvhaiWc9CehfuLYoQSuDhwNmRb8WmNk/b864P8B8lazZhg1iYj" +
       "rSdwGDiq13ktcmUC12xp0wwweC3OUmJ5k4zVuBpgriOxPtN036XKLzKFl7m5" +
       "aOgObRJVrHX9FwXDo1NPJAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "nP16/uJxOHvP2VBzatizgeZkOQD3BXVx/+CZ2PLuQssfBBd6GFvQs7HlHFTe" +
       "fKhkeaYsrxfF+8s5uS+GLgehHwMpNZDWXYrKfDQGklie5JSDvQCqy/UmKpnf" +
       "EUOVOy9N+9wO2NI+tBUlVhT43iAatzSeF8sh83MgxlxED5oHSPHM3EL44vZv" +
       "FwVZFNSRuO+yHeX6UdyZg3QamM1122keyX+1tPhigg7lPCPkC39jIYFFP3LS" +
       "GeODdPb7/8Onv/SDz30NmN0AulgqA1jbqRFHSZHh/+PPv/rkQ6/88feXQRVE" +
       "1PnHnv+LMl+avTWoTxRQhTJjYaQoZsvYp6kl2tt6Gx9aLlgu0sP0FX752tfW" +
       "P/6nP7tPTc+61hli7ZOvfN+3Dj71yvlTLwTPvSknP82zfykohX7boYZD6Jnb" +
       "jVJyUP/5Cy//2s+8/Im9VNduTG9J8Pb2s//2/3zp4DN//Ds3yZ8uOP5dTGx8" +
       "9WP9WkTjRz+mKkmrTMknCzB9SNpEe6m83EZNfSnluLJbDRuGOtlFbaGusVhK" +
       "S4183ZXyUHMDDE2agezpyyZbk6Y4PlCGQ5zrZYkhznR1ndGrjkB5Pbw+NtYG" +
       "wdFDk+iwY2tI0dvJihSEoaCYzbmKTfkp1o8cGnXCDRokm/Ym1SpautQ2Wx9u" +
       "mb0gIjAh98ZaTWTdaMurnFlZOxEiLCebalPDxqMNo8wQGdbTeRMWNVLQZpkr" +
       "LtZq0CZkVbJZq2p26zy1ceu7jZWyTVeJjMm2S4WcOJo16lJidwNqUdWqHPAs" +
       "f9PcsUIXd9AZEfdcy/McM+CVthx22e6gZpo0aS6ESVfpJbvYDqhaviNdXmca" +
       "fMqmS6M+DuRtQ1435JVsB5yPuokU91ZSynM2uVy49ArlpJXIs/SWZwZy0iY6" +
       "q14aZXZGo2Y7hfkp21TWLq5Q0SaJelQlFNG6GUscG5ECN1q6CZY7DLr0aHW4" +
       "Siac2coHOZKrbdqfdjaUMK/GvLAZp34/aMyFJa1Ozebamgc+TSgyHak5MV3Y" +
       "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" +
       "9SwlkKL8P033TAw9eEIHBt3fnCa5DnoH");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("JMXt88GRu8B3VhgDnmLzcDbzfYB+/LRFl45w7U5mcup187kbXhLLk9pHL3TJ" +
       "/qz2S8oXXhuMvvsbjdf3p+gU8Oq+K3p5gIHu3x/oKzstXgqfuWVvR31d6r/w" +
       "zUd+/vLzRy+wj+wFPvGuU7K99+bH1Eg3iMuDZbtffdcvfsdPv/bV8iDI/wNL" +
       "HuunQi8AAA==");
}
