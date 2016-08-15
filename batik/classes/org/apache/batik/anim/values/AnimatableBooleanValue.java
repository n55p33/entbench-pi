package org.apache.batik.anim.values;
public class AnimatableBooleanValue extends org.apache.batik.anim.values.AnimatableValue {
    protected boolean value;
    protected AnimatableBooleanValue(org.apache.batik.dom.anim.AnimationTarget target) {
        super(
          target);
    }
    public AnimatableBooleanValue(org.apache.batik.dom.anim.AnimationTarget target,
                                  boolean b) { super(target);
                                               value = b;
    }
    public org.apache.batik.anim.values.AnimatableValue interpolate(org.apache.batik.anim.values.AnimatableValue result,
                                                                    org.apache.batik.anim.values.AnimatableValue to,
                                                                    float interpolation,
                                                                    org.apache.batik.anim.values.AnimatableValue accumulation,
                                                                    int multiplier) {
        org.apache.batik.anim.values.AnimatableBooleanValue res;
        if (result ==
              null) {
            res =
              new org.apache.batik.anim.values.AnimatableBooleanValue(
                target);
        }
        else {
            res =
              (org.apache.batik.anim.values.AnimatableBooleanValue)
                result;
        }
        boolean newValue;
        if (to !=
              null &&
              interpolation >=
              0.5) {
            org.apache.batik.anim.values.AnimatableBooleanValue toValue =
              (org.apache.batik.anim.values.AnimatableBooleanValue)
                to;
            newValue =
              toValue.
                value;
        }
        else {
            newValue =
              value;
        }
        if (res.
              value !=
              newValue) {
            res.
              value =
              newValue;
            res.
              hasChanged =
              true;
        }
        return res;
    }
    public boolean getValue() { return value;
    }
    public boolean canPace() { return false;
    }
    public float distanceTo(org.apache.batik.anim.values.AnimatableValue other) {
        return 0.0F;
    }
    public org.apache.batik.anim.values.AnimatableValue getZeroValue() {
        return new org.apache.batik.anim.values.AnimatableBooleanValue(
          target,
          false);
    }
    public java.lang.String getCssText() {
        return value
          ? "true"
          : "false";
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
       "/wDi2lFTrigAAA==");
}
