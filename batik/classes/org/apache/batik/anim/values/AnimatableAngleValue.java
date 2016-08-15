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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1ZeZBUxRnvmT1Y9t7llGO5FiwOZ8B4lFkvWBdZnF222IUK" +
       "i7r0vunZffDmvcd7PbsDSlTKFCRWLGLwLN0/EgxooVhWzKmGhIpHaUxEojGW" +
       "kMMyJoZEKommJIn5vu735h1zICnJVL2eN939fd3f9fu+7jl4klTYFmlhOo/x" +
       "bSazYx0676GWzZLtGrXtPugbUO4to3+78b3uy6Kksp/UD1O7S6E2W6kyLWn3" +
       "k5mqbnOqK8zuZiyJFD0Ws5k1Qrlq6P1kkmp3pk1NVVTeZSQZTlhPrQRpopxb" +
       "6mCGs06HASczE7CTuNhJfHl4uC1BahXD3OZNn+qb3u4bwZlpby2bk8bEZjpC" +
       "4xmuavGEavO2rEUWm4a2bUgzeIxleWyzdrGjgtWJi/NUMPeJhg9P7xluFCqY" +
       "QHXd4EI8ey2zDW2EJROkwevt0Fja3kq+SMoSpMY3mZPWhLtoHBaNw6KutN4s" +
       "2H0d0zPpdkOIw11OlaaCG+JkTpCJSS2adtj0iD0DhyruyC6IQdrZOWmllHki" +
       "3r04vvfeGxufLCMN/aRB1XtxOwpsgsMi/aBQlh5klr08mWTJftKkg7F7maVS" +
       "Td3uWLrZVod0yjNgflct2JkxmSXW9HQFdgTZrIzCDSsnXko4lPOrIqXRIZB1" +
       "sierlHAl9oOA1SpszEpR8DuHpHyLqic5mRWmyMnYeh1MANJxacaHjdxS5TqF" +
       "DtIsXUSj+lC8F1xPH4KpFQY4oMXJtKJMUdcmVbbQITaAHhma1yOHYNZ4oQgk" +
       "4WRSeJrgBFaaFrKSzz4nuy+/8yZ9lR4lEdhzkika7r8GiFpCRGtZilkM4kAS" +
       "1i5K3EMnP7M7SghMnhSaLOd89+ZTVy9pOfyCnDO9wJw1g5uZwgeUfYP1r85o" +
       "X3hZGW6jyjRsFY0fkFxEWY8z0pY1AWEm5zjiYMwdPLz2uQ23Psrej5LqTlKp" +
       "GFomDX7UpBhpU9WYdS3TmUU5S3aS8UxPtovxTjIO3hOqzmTvmlTKZryTlGui" +
       "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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "220+y/0MdN/uy6ujG7y33nW2w7mudJ95");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("9aFfeuDth9H9oR3Cx2p/Arenzv+2qOMGcfE10PZX3vJv3vMvXvhGcT3z/wDO" +
       "fJTQ3CwAAA==");
}
