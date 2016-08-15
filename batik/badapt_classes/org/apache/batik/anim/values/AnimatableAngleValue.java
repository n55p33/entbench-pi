package org.apache.batik.anim.values;
public class AnimatableAngleValue extends org.apache.batik.anim.values.AnimatableNumberValue {
    protected static final java.lang.String[] UNITS = { "", "", "deg", "rad",
    "grad" };
    protected short unit;
    public AnimatableAngleValue(org.apache.batik.dom.anim.AnimationTarget target) {
        super(
          target);
    }
    public AnimatableAngleValue(org.apache.batik.dom.anim.AnimationTarget target,
                                float v,
                                short unit) { super(target,
                                                    v);
                                              this.unit =
                                                unit; }
    public org.apache.batik.anim.values.AnimatableValue interpolate(org.apache.batik.anim.values.AnimatableValue result,
                                                                    org.apache.batik.anim.values.AnimatableValue to,
                                                                    float interpolation,
                                                                    org.apache.batik.anim.values.AnimatableValue accumulation,
                                                                    int multiplier) {
        org.apache.batik.anim.values.AnimatableAngleValue res;
        if (result ==
              null) {
            res =
              new org.apache.batik.anim.values.AnimatableAngleValue(
                target);
        }
        else {
            res =
              (org.apache.batik.anim.values.AnimatableAngleValue)
                result;
        }
        float v =
          value;
        short u =
          unit;
        if (to !=
              null) {
            org.apache.batik.anim.values.AnimatableAngleValue toAngle =
              (org.apache.batik.anim.values.AnimatableAngleValue)
                to;
            if (toAngle.
                  unit !=
                  u) {
                v =
                  rad(
                    v,
                    u);
                v +=
                  interpolation *
                    (rad(
                       toAngle.
                         value,
                       toAngle.
                         unit) -
                       v);
                u =
                  org.w3c.dom.svg.SVGAngle.
                    SVG_ANGLETYPE_RAD;
            }
            else {
                v +=
                  interpolation *
                    (toAngle.
                       value -
                       v);
            }
        }
        if (accumulation !=
              null) {
            org.apache.batik.anim.values.AnimatableAngleValue accAngle =
              (org.apache.batik.anim.values.AnimatableAngleValue)
                accumulation;
            if (accAngle.
                  unit !=
                  u) {
                v +=
                  multiplier *
                    rad(
                      accAngle.
                        value,
                      accAngle.
                        unit);
                u =
                  org.w3c.dom.svg.SVGAngle.
                    SVG_ANGLETYPE_RAD;
            }
            else {
                v +=
                  multiplier *
                    accAngle.
                      value;
            }
        }
        if (res.
              value !=
              v ||
              res.
                unit !=
              u) {
            res.
              value =
              v;
            res.
              unit =
              u;
            res.
              hasChanged =
              true;
        }
        return res;
    }
    public short getUnit() { return unit;
    }
    public float distanceTo(org.apache.batik.anim.values.AnimatableValue other) {
        org.apache.batik.anim.values.AnimatableAngleValue o =
          (org.apache.batik.anim.values.AnimatableAngleValue)
            other;
        return java.lang.Math.
          abs(
            rad(
              value,
              unit) -
              rad(
                o.
                  value,
                o.
                  unit));
    }
    public org.apache.batik.anim.values.AnimatableValue getZeroValue() {
        return new org.apache.batik.anim.values.AnimatableAngleValue(
          target,
          0,
          org.w3c.dom.svg.SVGAngle.
            SVG_ANGLETYPE_UNSPECIFIED);
    }
    public java.lang.String getCssText() {
        return super.
          getCssText(
            ) +
        UNITS[unit];
    }
    public static float rad(float v, short unit) {
        switch (unit) {
            case org.w3c.dom.svg.SVGAngle.
                   SVG_ANGLETYPE_RAD:
                return v;
            case org.w3c.dom.svg.SVGAngle.
                   SVG_ANGLETYPE_GRAD:
                return (float)
                         java.lang.Math.
                           PI *
                  v /
                  200;
            default:
                return (float)
                         java.lang.Math.
                           PI *
                  v /
                  180;
        }
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
       "/TR03+7Lq6MbvLfedbbDua70n/3OQ7/4");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("wDOH0f2hHcLHan8Ct6fO/7ao4wZx8TXQ9pfe8m/e/S9e/EZxPfP/AIPMDhXc" +
       "LAAA");
}
