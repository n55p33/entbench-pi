package org.apache.batik.anim.values;
public class AnimatableNumberOrPercentageValue extends org.apache.batik.anim.values.AnimatableNumberValue {
    protected boolean isPercentage;
    protected AnimatableNumberOrPercentageValue(org.apache.batik.dom.anim.AnimationTarget target) {
        super(
          target);
    }
    public AnimatableNumberOrPercentageValue(org.apache.batik.dom.anim.AnimationTarget target,
                                             float n) { super(
                                                          target,
                                                          n);
    }
    public AnimatableNumberOrPercentageValue(org.apache.batik.dom.anim.AnimationTarget target,
                                             float n,
                                             boolean isPercentage) {
        super(
          target,
          n);
        this.
          isPercentage =
          isPercentage;
    }
    public org.apache.batik.anim.values.AnimatableValue interpolate(org.apache.batik.anim.values.AnimatableValue result,
                                                                    org.apache.batik.anim.values.AnimatableValue to,
                                                                    float interpolation,
                                                                    org.apache.batik.anim.values.AnimatableValue accumulation,
                                                                    int multiplier) {
        org.apache.batik.anim.values.AnimatableNumberOrPercentageValue res;
        if (result ==
              null) {
            res =
              new org.apache.batik.anim.values.AnimatableNumberOrPercentageValue(
                target);
        }
        else {
            res =
              (org.apache.batik.anim.values.AnimatableNumberOrPercentageValue)
                result;
        }
        float newValue;
        boolean newIsPercentage;
        org.apache.batik.anim.values.AnimatableNumberOrPercentageValue toValue =
          (org.apache.batik.anim.values.AnimatableNumberOrPercentageValue)
            to;
        org.apache.batik.anim.values.AnimatableNumberOrPercentageValue accValue =
          (org.apache.batik.anim.values.AnimatableNumberOrPercentageValue)
            accumulation;
        if (to !=
              null) {
            if (toValue.
                  isPercentage ==
                  isPercentage) {
                newValue =
                  value +
                    interpolation *
                    (toValue.
                       value -
                       value);
                newIsPercentage =
                  isPercentage;
            }
            else {
                if (interpolation >=
                      0.5) {
                    newValue =
                      toValue.
                        value;
                    newIsPercentage =
                      toValue.
                        isPercentage;
                }
                else {
                    newValue =
                      value;
                    newIsPercentage =
                      isPercentage;
                }
            }
        }
        else {
            newValue =
              value;
            newIsPercentage =
              isPercentage;
        }
        if (accumulation !=
              null &&
              accValue.
                isPercentage ==
              newIsPercentage) {
            newValue +=
              multiplier *
                accValue.
                  value;
        }
        if (res.
              value !=
              newValue ||
              res.
                isPercentage !=
              newIsPercentage) {
            res.
              value =
              newValue;
            res.
              isPercentage =
              newIsPercentage;
            res.
              hasChanged =
              true;
        }
        return res;
    }
    public boolean isPercentage() { return isPercentage;
    }
    public boolean canPace() { return false;
    }
    public float distanceTo(org.apache.batik.anim.values.AnimatableValue other) {
        return 0.0F;
    }
    public org.apache.batik.anim.values.AnimatableValue getZeroValue() {
        return new org.apache.batik.anim.values.AnimatableNumberOrPercentageValue(
          target,
          0,
          isPercentage);
    }
    public java.lang.String getCssText() {
        java.lang.StringBuffer sb =
          new java.lang.StringBuffer(
          );
        sb.
          append(
            formatNumber(
              value));
        if (isPercentage) {
            sb.
              append(
                '%');
        }
        return sb.
          toString(
            );
    }
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
       "3v6b7/nlF/+8/L7z/wHXUAAjVSoAAA==");
}
