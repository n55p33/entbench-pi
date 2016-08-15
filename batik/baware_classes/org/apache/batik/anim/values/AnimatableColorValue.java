package org.apache.batik.anim.values;
public class AnimatableColorValue extends org.apache.batik.anim.values.AnimatableValue {
    protected float red;
    protected float green;
    protected float blue;
    protected AnimatableColorValue(org.apache.batik.dom.anim.AnimationTarget target) {
        super(
          target);
    }
    public AnimatableColorValue(org.apache.batik.dom.anim.AnimationTarget target,
                                float r,
                                float g,
                                float b) { super(target);
                                           red = r;
                                           green = g;
                                           blue = b; }
    public org.apache.batik.anim.values.AnimatableValue interpolate(org.apache.batik.anim.values.AnimatableValue result,
                                                                    org.apache.batik.anim.values.AnimatableValue to,
                                                                    float interpolation,
                                                                    org.apache.batik.anim.values.AnimatableValue accumulation,
                                                                    int multiplier) {
        org.apache.batik.anim.values.AnimatableColorValue res;
        if (result ==
              null) {
            res =
              new org.apache.batik.anim.values.AnimatableColorValue(
                target);
        }
        else {
            res =
              (org.apache.batik.anim.values.AnimatableColorValue)
                result;
        }
        float oldRed =
          res.
            red;
        float oldGreen =
          res.
            green;
        float oldBlue =
          res.
            blue;
        res.
          red =
          red;
        res.
          green =
          green;
        res.
          blue =
          blue;
        org.apache.batik.anim.values.AnimatableColorValue toColor =
          (org.apache.batik.anim.values.AnimatableColorValue)
            to;
        org.apache.batik.anim.values.AnimatableColorValue accColor =
          (org.apache.batik.anim.values.AnimatableColorValue)
            accumulation;
        if (to !=
              null) {
            res.
              red +=
              interpolation *
                (toColor.
                   red -
                   res.
                     red);
            res.
              green +=
              interpolation *
                (toColor.
                   green -
                   res.
                     green);
            res.
              blue +=
              interpolation *
                (toColor.
                   blue -
                   res.
                     blue);
        }
        if (accumulation !=
              null) {
            res.
              red +=
              multiplier *
                accColor.
                  red;
            res.
              green +=
              multiplier *
                accColor.
                  green;
            res.
              blue +=
              multiplier *
                accColor.
                  blue;
        }
        if (res.
              red !=
              oldRed ||
              res.
                green !=
              oldGreen ||
              res.
                blue !=
              oldBlue) {
            res.
              hasChanged =
              true;
        }
        return res;
    }
    public boolean canPace() { return true;
    }
    public float distanceTo(org.apache.batik.anim.values.AnimatableValue other) {
        org.apache.batik.anim.values.AnimatableColorValue o =
          (org.apache.batik.anim.values.AnimatableColorValue)
            other;
        float dr =
          red -
          o.
            red;
        float dg =
          green -
          o.
            green;
        float db =
          blue -
          o.
            blue;
        return (float)
                 java.lang.Math.
                 sqrt(
                   dr *
                     dr +
                     dg *
                     dg +
                     db *
                     db);
    }
    public org.apache.batik.anim.values.AnimatableValue getZeroValue() {
        return new org.apache.batik.anim.values.AnimatableColorValue(
          target,
          0.0F,
          0.0F,
          0.0F);
    }
    public java.lang.String getCssText() {
        return "rgb(" +
        java.lang.Math.
          round(
            red *
              255) +
        ',' +
        java.lang.Math.
          round(
            green *
              255) +
        ',' +
        java.lang.Math.
          round(
            blue *
              255) +
        ')';
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Pr3i+A/xisO7/wHPM8Bvlx4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Hb1D7FaNVhEKcaVuxpBqTSWHNVWAccpRZd1c1ba61co2XiuyYyzFB7itWCPO" +
       "4tlWrStPK611vx8uKV/vrtfIZmPWsCE2nsgr2ra2/MSpIMvFGFPZHO1K/tCq" +
       "s9qYW8AcwrNTpyXqc3Qtd1N/irSCqkagOjGQGlzTVQUG77hEyvTMvj9bjqcO" +
       "R2bitsvucETFeTqNmzkVqNxOHy/lvNHQkv7ErWDrLUfGw2joNsc4OtjMJykw" +
       "BrLjLNDJiAnXojXeNWeUnmLDgSMtOFOo1SOy6jfr06bPu6xWjxeDzk7O6RE2" +
       "dWkiYamEtFF9Fi0suR6OCdMVarWF12Q6TWTHCC1Xx/10gPvRfEobgr/Aka4V" +
       "RPHQd6ekJWWGuasPQqHTwbdsA8vG0rQhSLXpakVXOZ2ZbbsNaZDKfLWq4NG4" +
       "0elgbGMhcLPhOJD8sdcYLOamRPf0mOijOEnkOtFhdXGCrngcJ2SuOhyytotg" +
       "aj/ILdtJavxyO59Nu+O+JHoqgzrs1JtSi5q9WKyyVmdK10dUU12ZUw2ZwTbe" +
       "6bi6QtgmwWhMMEcXcdPMW/5qJi03a4dDwuqc2VIKr7Qra8s2asq8plJZv4rh" +
       "gjBodpQKabMtdLhs9XtEdwpzeG+5qmBGS6rCFXVWa2M9xGvO/M2EDXRfZjaz" +
       "Wm3Yk6dCV3DkBdsMd7rrsL2dUXFEndxoVAdJXXtWox0VEUfjeiOdWoI+4dsr" +
       "udHlRsPOxpoD5lpbJFgok/ZkF2o9tdWz9C7fYWvBpsmNdhTWQHcKPzDx3Wje" +
       "WG63DtbTd2m3ImtmbzDgqEmcqfg21Mws7iPWiO/i8WI4yQh3lYJtGsmOE5Ju" +
       "Gguy1YxQAwT2VRUnGlJtsFibUh9x4LqjdRIKE3OK6wjzkGAVorvMPKtJ2k53" +
       "YQzGuwTL4VpjbPLV0GTHs4xWZGoReRgdLCZGM9PjgTiRs5Yf8Rw1C9WJwlD0" +
       "nBnq0aBDdWZTYiEozHI5sgOt2pos6BRdsOHOTGmP33V4Wk69xkqu91RhJVaS" +
       "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" +
       "KQAA");
}
