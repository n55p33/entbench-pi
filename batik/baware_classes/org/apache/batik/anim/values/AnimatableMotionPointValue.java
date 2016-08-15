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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "20KSMoUNbi2fZdFIF4tXfFvyX6swESG4IQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "MVZfxA0aiyuoytlGYo+riBOruczJNm7I3kL2GJ9qaLWNqKibjrKDBaWXIvo4" +
       "E+VBqxESUl+wmvXNAltuNkSNVnrzqaGwTDvdcnlPQ0RV5R1SrRtOdzWTYz9V" +
       "VWkg2Ss1Z/2N4uOBTDS4TrNPRsuqkfWruZQL6iLmslFjowyDKimKtLObVga4" +
       "VtU4tcvutkHXyqt1njQ6Hb5uNza6aKPMjMmrbWFVqWFmVZiOyVnIO1Nj2ne6" +
       "GWnz3Uzs0sQuokM1cSPE82aTcFDrq6N2Zu+mWhqk4zZrJKu1J6GNXnu8IKyQ" +
       "RZ2qb09IYxYQCyvXg7DO4EOMmhGjiQdrK1rrjzgTxeyWaGFyY5JltWEHV6Ya" +
       "ZSUISnPSZB1inkoSoyBerrDtLOtIvSgOdgLVmq3WvjQkmuOeFyyp9rzfwAe2" +
       "KVjqXMuybESnkygIaclQvKk4D6huQtpZHlOoysRUOiM6Iq5ztFrHlcxStWbH" +
       "jXZNfmH0xot0I6mLCDEGXWrJs8i0V1nG3XUv7iS063qs3OntxhbSioi5POGV" +
       "emov2Z6Xx10vNfW+nG8rOy1KgxZMCwuBwThPqcWEJKwDXYxmrXjYhbej6VQk" +
       "tLZmWOthAvfTBb5TZqbL1Nr4cuBOtrTNxDpjI1JVkGXZWJg7Y0g5yoCZDQNz" +
       "tlOIRWKHRHWqVFU3p4yZKuZtHFe3izGyqVqLQV/OfLdbHXh6XV3RtUaDd2ZL" +
       "bpIo80ZPZIadTiBJI761rkfUkNnNXbrCtLHtAB96vWU+6cZoj17BK08ljFad" +
       "tXc8OQuiNKQWnLVz+i2styT87pw2Vs1FpwlCVRJSedaZrJYraRbWOv1Ga6t2" +
       "mG68GAzWvNnXtVDdeQmjODQZ97aJtSGTjFGUmlpv2mFlNm633YkzsgNVIrIh" +
       "tbImlZhj9FoszabwPK13WiOD8lGWWiKYLdK1SauBdzx8ZA0sm6ZHxFaU8Ji1" +
       "CIdY9kH6NCREku2MJbQj0rhSZ8Y2ykdMUoHD9Yiec0NzPRol4xoXrXZIvT1P" +
       "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" +
       "ZCZp5E9uOcx88nhlv6dYsfeCCz9cWfzscd2J7u58Vvehve7PnGZfKAkuHJ2Q" +
       "Pfsa396W57nFmM8en/l99k7nTvfZ/v7d0T+/xyn6vyiKTyfQg+V3G2DRtMQ8" +
       "4Vha4mdez8F62fBjx0tXGuZj4AoPly58c5buNISfuUffF4viXybQ/ZaZyOVy" +
       "neD6qTcDV3aIK3vzcf3yPfp+tSh+fo9LOYPrF94oru8G10cPcX30zcf1m/fo" +
       "+62i+I0EugxwdY6PtU+w/Zs3gO2tRWNx6v7xQ2wff/Ox/eE9+r5SFP8ugS7p" +
       "mi8cfSB1xmcvzYPANTX/BPGX36g2i+j1wiHiF94cxOdOCD5bEnz1HrC/XhR/" +
       "nEBXDHsffCfBGaX+yRuAWMbm4m3OS4cQX3rzlfoX9+j7q6L4Lwn0EDBY1YyC" +
       "k+B8gu+/vgF8jxaNxU7+E4f4fuLNx/fNe/T9TVG8CvaHJNi/thmb5bzJCbz/" +
       "8bpevCbQ9bt/iFR8UvHEbV9E7r/i03/25auX3/ay9B/Lb3GOv7R7gIEuL1LX" +
       "Pf1W8lT9YhiZC7uE8sD+HWVY/n07gd5+r/02gS7uKyWCvy0HnTufQI/dcRAI" +
       "xMXfadoLCXTtLG0CXSj/T9NdBp5xQgem3VdOkzwI9nJAUlQfCvdOd+7WZO5Y" +
       "F49+J12cyv/efUvWVn6uepRhpfsPVm/qX3p5wP3Aq82f3H9HpLtanhdcLjPQ" +
       "pf0nTcdZ2rvuyu2I18X+M996+OceeM9RRvnwXuAT+z0l2zvu/MUO4YVJ+Y1N" +
       "/itv+8UP/NTLXy1f5f0/z3Q9cEcsAAA=");
}
