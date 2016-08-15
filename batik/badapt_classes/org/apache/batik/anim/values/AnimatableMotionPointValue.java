package org.apache.batik.anim.values;
public class AnimatableMotionPointValue extends org.apache.batik.anim.values.AnimatableValue {
    protected float x;
    protected float y;
    protected float angle;
    protected AnimatableMotionPointValue(org.apache.batik.dom.anim.AnimationTarget target) {
        super(
          target);
    }
    public AnimatableMotionPointValue(org.apache.batik.dom.anim.AnimationTarget target,
                                      float x,
                                      float y,
                                      float angle) { super(
                                                       target);
                                                     this.
                                                       x =
                                                       x;
                                                     this.
                                                       y =
                                                       y;
                                                     this.
                                                       angle =
                                                       angle;
    }
    public org.apache.batik.anim.values.AnimatableValue interpolate(org.apache.batik.anim.values.AnimatableValue result,
                                                                    org.apache.batik.anim.values.AnimatableValue to,
                                                                    float interpolation,
                                                                    org.apache.batik.anim.values.AnimatableValue accumulation,
                                                                    int multiplier) {
        org.apache.batik.anim.values.AnimatableMotionPointValue res;
        if (result ==
              null) {
            res =
              new org.apache.batik.anim.values.AnimatableMotionPointValue(
                target);
        }
        else {
            res =
              (org.apache.batik.anim.values.AnimatableMotionPointValue)
                result;
        }
        float newX =
          x;
        float newY =
          y;
        float newAngle =
          angle;
        int angleCount =
          1;
        if (to !=
              null) {
            org.apache.batik.anim.values.AnimatableMotionPointValue toValue =
              (org.apache.batik.anim.values.AnimatableMotionPointValue)
                to;
            newX +=
              interpolation *
                (toValue.
                   x -
                   x);
            newY +=
              interpolation *
                (toValue.
                   y -
                   y);
            newAngle +=
              toValue.
                angle;
            angleCount++;
        }
        if (accumulation !=
              null &&
              multiplier !=
              0) {
            org.apache.batik.anim.values.AnimatableMotionPointValue accValue =
              (org.apache.batik.anim.values.AnimatableMotionPointValue)
                accumulation;
            newX +=
              multiplier *
                accValue.
                  x;
            newY +=
              multiplier *
                accValue.
                  y;
            newAngle +=
              accValue.
                angle;
            angleCount++;
        }
        newAngle /=
          angleCount;
        if (res.
              x !=
              newX ||
              res.
                y !=
              newY ||
              res.
                angle !=
              newAngle) {
            res.
              x =
              newX;
            res.
              y =
              newY;
            res.
              angle =
              newAngle;
            res.
              hasChanged =
              true;
        }
        return res;
    }
    public float getX() { return x; }
    public float getY() { return y; }
    public float getAngle() { return angle;
    }
    public boolean canPace() { return true;
    }
    public float distanceTo(org.apache.batik.anim.values.AnimatableValue other) {
        org.apache.batik.anim.values.AnimatableMotionPointValue o =
          (org.apache.batik.anim.values.AnimatableMotionPointValue)
            other;
        float dx =
          x -
          o.
            x;
        float dy =
          y -
          o.
            y;
        return (float)
                 java.lang.Math.
                 sqrt(
                   dx *
                     dx +
                     dy *
                     dy);
    }
    public org.apache.batik.anim.values.AnimatableValue getZeroValue() {
        return new org.apache.batik.anim.values.AnimatableMotionPointValue(
          target,
          0.0F,
          0.0F,
          0.0F);
    }
    public java.lang.String toStringRep() {
        java.lang.StringBuffer sb =
          new java.lang.StringBuffer(
          );
        sb.
          append(
            formatNumber(
              x));
        sb.
          append(
            ',');
        sb.
          append(
            formatNumber(
              y));
        sb.
          append(
            ',');
        sb.
          append(
            formatNumber(
              angle));
        sb.
          append(
            "rad");
        return sb.
          toString(
            );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "FpKrTWGDW0tnWTTSxeIV35b8F7hRoqu4IQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Z1/5evkp7/8Bt6xSX0csAAA=");
}
