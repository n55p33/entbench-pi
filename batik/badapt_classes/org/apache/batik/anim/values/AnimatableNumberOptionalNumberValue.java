package org.apache.batik.anim.values;
public class AnimatableNumberOptionalNumberValue extends org.apache.batik.anim.values.AnimatableValue {
    protected float number;
    protected boolean hasOptionalNumber;
    protected float optionalNumber;
    protected AnimatableNumberOptionalNumberValue(org.apache.batik.dom.anim.AnimationTarget target) {
        super(
          target);
    }
    public AnimatableNumberOptionalNumberValue(org.apache.batik.dom.anim.AnimationTarget target,
                                               float n) {
        super(
          target);
        number =
          n;
    }
    public AnimatableNumberOptionalNumberValue(org.apache.batik.dom.anim.AnimationTarget target,
                                               float n,
                                               float on) {
        super(
          target);
        number =
          n;
        optionalNumber =
          on;
        hasOptionalNumber =
          true;
    }
    public org.apache.batik.anim.values.AnimatableValue interpolate(org.apache.batik.anim.values.AnimatableValue result,
                                                                    org.apache.batik.anim.values.AnimatableValue to,
                                                                    float interpolation,
                                                                    org.apache.batik.anim.values.AnimatableValue accumulation,
                                                                    int multiplier) {
        org.apache.batik.anim.values.AnimatableNumberOptionalNumberValue res;
        if (result ==
              null) {
            res =
              new org.apache.batik.anim.values.AnimatableNumberOptionalNumberValue(
                target);
        }
        else {
            res =
              (org.apache.batik.anim.values.AnimatableNumberOptionalNumberValue)
                result;
        }
        float newNumber;
        float newOptionalNumber;
        boolean newHasOptionalNumber;
        if (to !=
              null &&
              interpolation >=
              0.5) {
            org.apache.batik.anim.values.AnimatableNumberOptionalNumberValue toValue =
              (org.apache.batik.anim.values.AnimatableNumberOptionalNumberValue)
                to;
            newNumber =
              toValue.
                number;
            newOptionalNumber =
              toValue.
                optionalNumber;
            newHasOptionalNumber =
              toValue.
                hasOptionalNumber;
        }
        else {
            newNumber =
              number;
            newOptionalNumber =
              optionalNumber;
            newHasOptionalNumber =
              hasOptionalNumber;
        }
        if (res.
              number !=
              newNumber ||
              res.
                hasOptionalNumber !=
              newHasOptionalNumber ||
              res.
                optionalNumber !=
              newOptionalNumber) {
            res.
              number =
              number;
            res.
              optionalNumber =
              optionalNumber;
            res.
              hasOptionalNumber =
              hasOptionalNumber;
            res.
              hasChanged =
              true;
        }
        return res;
    }
    public float getNumber() { return number;
    }
    public boolean hasOptionalNumber() { return hasOptionalNumber;
    }
    public float getOptionalNumber() { return optionalNumber;
    }
    public boolean canPace() { return false;
    }
    public float distanceTo(org.apache.batik.anim.values.AnimatableValue other) {
        return 0.0F;
    }
    public org.apache.batik.anim.values.AnimatableValue getZeroValue() {
        if (hasOptionalNumber) {
            return new org.apache.batik.anim.values.AnimatableNumberOptionalNumberValue(
              target,
              0.0F,
              0.0F);
        }
        return new org.apache.batik.anim.values.AnimatableNumberOptionalNumberValue(
          target,
          0.0F);
    }
    public java.lang.String getCssText() {
        java.lang.StringBuffer sb =
          new java.lang.StringBuffer(
          );
        sb.
          append(
            formatNumber(
              number));
        if (hasOptionalNumber) {
            sb.
              append(
                ' ');
            sb.
              append(
                formatNumber(
                  optionalNumber));
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
      ("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");
}
