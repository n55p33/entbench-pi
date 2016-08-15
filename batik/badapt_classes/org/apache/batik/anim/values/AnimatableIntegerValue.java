package org.apache.batik.anim.values;
public class AnimatableIntegerValue extends org.apache.batik.anim.values.AnimatableValue {
    protected int value;
    protected AnimatableIntegerValue(org.apache.batik.dom.anim.AnimationTarget target) {
        super(
          target);
    }
    public AnimatableIntegerValue(org.apache.batik.dom.anim.AnimationTarget target,
                                  int v) { super(target);
                                           value = v; }
    public org.apache.batik.anim.values.AnimatableValue interpolate(org.apache.batik.anim.values.AnimatableValue result,
                                                                    org.apache.batik.anim.values.AnimatableValue to,
                                                                    float interpolation,
                                                                    org.apache.batik.anim.values.AnimatableValue accumulation,
                                                                    int multiplier) {
        org.apache.batik.anim.values.AnimatableIntegerValue res;
        if (result ==
              null) {
            res =
              new org.apache.batik.anim.values.AnimatableIntegerValue(
                target);
        }
        else {
            res =
              (org.apache.batik.anim.values.AnimatableIntegerValue)
                result;
        }
        int v =
          value;
        if (to !=
              null) {
            org.apache.batik.anim.values.AnimatableIntegerValue toInteger =
              (org.apache.batik.anim.values.AnimatableIntegerValue)
                to;
            v +=
              value +
                interpolation *
                (toInteger.
                   getValue(
                     ) -
                   value);
        }
        if (accumulation !=
              null) {
            org.apache.batik.anim.values.AnimatableIntegerValue accInteger =
              (org.apache.batik.anim.values.AnimatableIntegerValue)
                accumulation;
            v +=
              multiplier *
                accInteger.
                getValue(
                  );
        }
        if (res.
              value !=
              v) {
            res.
              value =
              v;
            res.
              hasChanged =
              true;
        }
        return res;
    }
    public int getValue() { return value;
    }
    public boolean canPace() { return true;
    }
    public float distanceTo(org.apache.batik.anim.values.AnimatableValue other) {
        org.apache.batik.anim.values.AnimatableIntegerValue o =
          (org.apache.batik.anim.values.AnimatableIntegerValue)
            other;
        return java.lang.Math.
          abs(
            value -
              o.
                value);
    }
    public org.apache.batik.anim.values.AnimatableValue getZeroValue() {
        return new org.apache.batik.anim.values.AnimatableIntegerValue(
          target,
          0);
    }
    public java.lang.String getCssText() {
        return java.lang.Integer.
          toString(
            value);
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
