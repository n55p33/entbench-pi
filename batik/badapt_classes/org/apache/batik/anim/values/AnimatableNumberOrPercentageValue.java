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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "f+a9P/zin5bfd/4fadgqG1UqAAA=");
}
