package org.apache.batik.anim.values;
public class AnimatableNumberOrIdentValue extends org.apache.batik.anim.values.AnimatableNumberValue {
    protected boolean isIdent;
    protected java.lang.String ident;
    protected boolean numericIdent;
    protected AnimatableNumberOrIdentValue(org.apache.batik.dom.anim.AnimationTarget target) {
        super(
          target);
    }
    public AnimatableNumberOrIdentValue(org.apache.batik.dom.anim.AnimationTarget target,
                                        float v,
                                        boolean numericIdent) {
        super(
          target,
          v);
        this.
          numericIdent =
          numericIdent;
    }
    public AnimatableNumberOrIdentValue(org.apache.batik.dom.anim.AnimationTarget target,
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
    public boolean canPace() { return false; }
    public float distanceTo(org.apache.batik.anim.values.AnimatableValue other) {
        return 0.0F;
    }
    public org.apache.batik.anim.values.AnimatableValue getZeroValue() {
        return new org.apache.batik.anim.values.AnimatableNumberOrIdentValue(
          target,
          0.0F,
          numericIdent);
    }
    public java.lang.String getCssText() {
        if (isIdent) {
            return ident;
        }
        if (numericIdent) {
            return java.lang.Integer.
              toString(
                (int)
                  value);
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
        org.apache.batik.anim.values.AnimatableNumberOrIdentValue res;
        if (result ==
              null) {
            res =
              new org.apache.batik.anim.values.AnimatableNumberOrIdentValue(
                target);
        }
        else {
            res =
              (org.apache.batik.anim.values.AnimatableNumberOrIdentValue)
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
            else
                if (numericIdent) {
                    res.
                      hasChanged =
                      res.
                        value !=
                        value ||
                        res.
                          isIdent;
                    res.
                      value =
                      value;
                    res.
                      isIdent =
                      false;
                    res.
                      hasChanged =
                      true;
                    res.
                      numericIdent =
                      true;
                }
                else {
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
                    res.
                      numericIdent =
                      false;
                    if (res.
                          value !=
                          oldValue) {
                        res.
                          hasChanged =
                          true;
                    }
                }
        }
        else {
            org.apache.batik.anim.values.AnimatableNumberOrIdentValue toValue =
              (org.apache.batik.anim.values.AnimatableNumberOrIdentValue)
                to;
            if (isIdent ||
                  toValue.
                    isIdent ||
                  numericIdent) {
                if (interpolation >=
                      0.5) {
                    if (res.
                          isIdent !=
                          toValue.
                            isIdent ||
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
                          value =
                          toValue.
                            value;
                        res.
                          numericIdent =
                          toValue.
                            numericIdent;
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
                          value =
                          value;
                        res.
                          numericIdent =
                          numericIdent;
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
                res.
                  numericIdent =
                  false;
            }
        }
        return res;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "6QQFY6RWvOJb3X8AhUuM8fUfAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "hXzyRLKvKyT2OHiYI8kyF0/XTnV396O1d+91f8kx9I9dUvfJIvmPGXTd0MKR" +
       "ZpQ0sqeW8olXfVz/IyesPXJ8likesSZ+fVi78NHu7V/lJ/byjLkc8KcvkcfP" +
       "FMmnM+iG6e7VKZZXInqnIvnM1yCSQhrlke57jkTynq+/tv/bJXU/VySfy6CH" +
       "5lY2s5KolElR9tlT/n72a+Dv0aLwCfDoR/zpX3/+fu2Sul8vks8D7QH+SAA4" +
       "ADJK/Dvl7pe/Vu29DTzREXfR14e7q3uwK/VwkvRO1XLhvPY+N9x/f/69SyTx" +
       "hSL57Qx6TXkDDACWll1U9O+8qq9RGfTEZddVig/vj91xe25/48v4yZdvPvDG" +
       "l6XfLW9snNzKepCBHrBz3z/7seZM/lqcWLZbMvPg/tNNXP79KaDkMpfPoGv7" +
       "TMnDn+w7/UUGvf6unTLo/uLvbNu/yqBbF9tm0NXy/2y7vwZ2dtoOTLvPnG3y" +
       "v4G2QJMi+3/iY8BCXtWdoD1sXTm/wJ7o8NGvpMMza/Iz51bS8kLk8aqX769E" +
       "vmB8+mWa+/Yv4T+6v6Ni+NpuV4zyAANd31+XOVk533LP0Y7HukY9++WHP/Pg" +
       "W49X+Yf3BJ/6yBna3nT32yDdIM7K+xu7n3njT7/zP738B+WnkX8BeZQh5Kkq" +
       "AAA=");
}
