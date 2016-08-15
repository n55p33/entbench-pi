package org.apache.batik.anim.values;
public class AnimatableAngleOrIdentValue extends org.apache.batik.anim.values.AnimatableAngleValue {
    protected boolean isIdent;
    protected java.lang.String ident;
    protected AnimatableAngleOrIdentValue(org.apache.batik.dom.anim.AnimationTarget target) {
        super(
          target);
    }
    public AnimatableAngleOrIdentValue(org.apache.batik.dom.anim.AnimationTarget target,
                                       float v,
                                       short unit) { super(
                                                       target,
                                                       v,
                                                       unit);
    }
    public AnimatableAngleOrIdentValue(org.apache.batik.dom.anim.AnimationTarget target,
                                       java.lang.String ident) {
        super(
          target);
        this.
          ident =
          ident;
        this.
          isIdent =
          true;
    }
    public boolean isIdent() { return isIdent; }
    public java.lang.String getIdent() { return ident;
    }
    public boolean canPace() { return false; }
    public float distanceTo(org.apache.batik.anim.values.AnimatableValue other) {
        return 0.0F;
    }
    public org.apache.batik.anim.values.AnimatableValue getZeroValue() {
        return new org.apache.batik.anim.values.AnimatableAngleOrIdentValue(
          target,
          0,
          org.w3c.dom.svg.SVGAngle.
            SVG_ANGLETYPE_UNSPECIFIED);
    }
    public java.lang.String getCssText() {
        if (isIdent) {
            return ident;
        }
        return super.
          getCssText(
            );
    }
    public org.apache.batik.anim.values.AnimatableValue interpolate(org.apache.batik.anim.values.AnimatableValue result,
                                                                    org.apache.batik.anim.values.AnimatableValue to,
                                                                    float interpolation,
                                                                    org.apache.batik.anim.values.AnimatableValue accumulation,
                                                                    int multiplier) {
        org.apache.batik.anim.values.AnimatableAngleOrIdentValue res;
        if (result ==
              null) {
            res =
              new org.apache.batik.anim.values.AnimatableAngleOrIdentValue(
                target);
        }
        else {
            res =
              (org.apache.batik.anim.values.AnimatableAngleOrIdentValue)
                result;
        }
        if (to ==
              null) {
            if (isIdent) {
                res.
                  hasChanged =
                  !res.
                     isIdent ||
                    !res.
                       ident.
                    equals(
                      ident);
                res.
                  ident =
                  ident;
                res.
                  isIdent =
                  true;
            }
            else {
                short oldUnit =
                  res.
                    unit;
                float oldValue =
                  res.
                    value;
                super.
                  interpolate(
                    res,
                    to,
                    interpolation,
                    accumulation,
                    multiplier);
                if (res.
                      unit !=
                      oldUnit ||
                      res.
                        value !=
                      oldValue) {
                    res.
                      hasChanged =
                      true;
                }
            }
        }
        else {
            org.apache.batik.anim.values.AnimatableAngleOrIdentValue toValue =
              (org.apache.batik.anim.values.AnimatableAngleOrIdentValue)
                to;
            if (isIdent ||
                  toValue.
                    isIdent) {
                if (interpolation >=
                      0.5) {
                    if (res.
                          isIdent !=
                          toValue.
                            isIdent ||
                          res.
                            unit !=
                          toValue.
                            unit ||
                          res.
                            value !=
                          toValue.
                            value ||
                          res.
                            isIdent &&
                          toValue.
                            isIdent &&
                          !toValue.
                             ident.
                          equals(
                            ident)) {
                        res.
                          isIdent =
                          toValue.
                            isIdent;
                        res.
                          ident =
                          toValue.
                            ident;
                        res.
                          unit =
                          toValue.
                            unit;
                        res.
                          value =
                          toValue.
                            value;
                        res.
                          hasChanged =
                          true;
                    }
                }
                else {
                    if (res.
                          isIdent !=
                          isIdent ||
                          res.
                            unit !=
                          unit ||
                          res.
                            value !=
                          value ||
                          res.
                            isIdent &&
                          isIdent &&
                          !res.
                             ident.
                          equals(
                            ident)) {
                        res.
                          isIdent =
                          isIdent;
                        res.
                          ident =
                          ident;
                        res.
                          unit =
                          unit;
                        res.
                          value =
                          value;
                        res.
                          hasChanged =
                          true;
                    }
                }
            }
            else {
                super.
                  interpolate(
                    res,
                    to,
                    interpolation,
                    accumulation,
                    multiplier);
            }
        }
        return res;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "W/YfSFJ0M4chAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "zg4YvCOS0bRj+gTThrtIHGwJd5x1tEbgbnMtQ/jpFhn2VpEXb5xN3O6Tqp01" +
       "DELGdc3YVWaOPxdcQQ7kmSY6aLPnb7w5u5wIU42dgQZCDxv7k1Tgi3EVwaZ9" +
       "KSF8jJuuST4MZcvtmqtV3Y8MmhqjggCy/bypLXNWYoQ9r0Zq0w688Mec2R3y" +
       "1anZGhu7MFDzDA39DJ/vFArbhfiKkWaEBKZlDFmGZHOhI9y4spTZJj2OkD4S" +
       "TSZyZUdF8AxX9dwKqbAyW/TXvaDuD7Z6qyOQDd/Hs9G6W+/3UIeSBdhDGc1B" +
       "1T6hLuo5gcCdyLZ5zu20xYhwshlfzYXKtALHSJgIWRTiu5ms+qG/wiJJ3wk0" +
       "bYcUWrPwqYk3Zwt/yKKUTDYiTZT6rQU7D2aWiBdKSybI1q60xn0siekVVnN6" +
       "1e1goLvpmOmIa19zJAx1N4s2yaW1ubxWjDwetSPJ8oJhItaF2MxGbRusZSaj" +
       "qsYA/0Hh5ppuoZKYBWmvY6DUCGiymg03Kb8RGxs8QFxE7bhhcyKv2pXmLgM2" +
       "3pwS/Y2VJit/J9WXbZDfVMf0dKZsdEkNQXypDyqRDhsKUZnNrWbL7u6yxNP6" +
       "huBvo6G8pIedWTNud5eLSJVIos5s8nxek2LNB4mDaS9CYoCjGwox+n13qJnr" +
       "ieKyu4XWXERzdEk2aqwlCxbXR3ik1ekhY0+luZASkUpj0x242CyaKY267DEt" +
       "p7UTnH6wEyhfqTn8pCpvk4huK9GmTVabc9nZ5kqTmVVpZhBafGSKMDnheRLf" +
       "4LiyWEw3GBifsT15LuNKgyBWkVjzIrnVruprpsrjNaqPYFiojuJ4IcILk6OG" +
       "1XFDs8DK+zuLJfnHX9lWwcPlDsjJN/d/wd7H7l57neXfdejCd9qLe52PHu+x" +
       "xtBbX+5Terl9/JmPPP+Czv4kcnC0qTlMoQfSIPwO19gY7hlSNwCld7/8HuW4" +
       "PElwulH4ex/528fm77U+/Ao+PT55gc+LJH92/OIXeu/SfvQAunqybXjXGYfz" +
       "nZ4+v1l4MzbSdezPz20ZvvVEsm8oJPYYuMgjyZKXbEDfcw/ufXvdX7Jn/JlL" +
       "6n6qKP796WZj8eidWsp/eMV7658+gfbIMTT6CBr92kP73CV1v1QUP59C9y+N" +
       "9ATbB06xvfgqsJ2obX6Ebf7aY/u1S+p+oyh+BahNU/yJohkX1ParrwJa6e/F" +
       "xvAHj6B98LWBduGz6Hu+yTMM5T5+SfDzl8jji0XxWyl0U7f3XjgvT5xQpyL5" +
       "7VchkkIa0LeBSzsSifbaa/uPL6n706L4Ugo9CCxZNkD6VcikePeFU3x/+Go9" +
       "9XFwOUf4nNce319eUvdXRfHnQHsAHw7mCRDpL/jql1+t9opvfOsjdOvXBt21" +
       "/Xe0Ug8nBXWqlgvb8ldtf/9t879dIon/XhR/k0KvKw/YgXlGSS8q+m9f0Re/" +
       "FHrLJeeBipMNj951NnF/nk77xRdu3f/mF/g/KY/EnJx5e4CG7jfXrnv2e9iZ" +
       "++thbJh2ieWB/dexsPz5xxR6/DKPT6Hr+5sSwv/ed/qnFHrjPTul0H3Fz5m2" +
       "V6AUun2xbQpdK3/PtrsKzOy0HRh2f3O2yXWgLNCkuL0RHscr5JWcudoHrSvn" +
       "s6ITDT7yjTR4JpF657n0pzxtepyqrPfnTZ/VPvvCkPnurzV/cn8GSHOVPC+o" +
       "3E9DN/bHkU7Snbe/LLVjWtf7T339oc898K3HqdlDe4ZPPeQMb0/e+7QN6YVp" +
       "eT4m/9U3/8dnfvqFL5ffv/4feG25RgYsAAA=");
}
