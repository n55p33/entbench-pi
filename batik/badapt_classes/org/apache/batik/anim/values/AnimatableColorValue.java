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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "n15x/Kd4xeGd/wKZQrcKlx4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Ed1pFv7LXfo+XRQ/GUNXFckbH90DOSenq7LvO5rknXD8U18Hx6UrFhaTH3Kc" +
       "f2M4vnAC8LES4H/che3/VRSfjaFrqrU3+El5s4E6YfG/fx0slv5QHGK/75DF" +
       "933jlfprd+n7XFH8Ugzdb2jxSgv9E4c44e+Xvw7+HioaHwXPDx3y90PfeP5+" +
       "7y59ny+K3wbaA/x1QEgGQbVoiU+4+52X9cEphl59p6sXxUfkh2+78bW/paT8" +
       "7PPX733d89M/KG8fHN8kuq8P3asnjnP6O8yp+pUg1HSr5OG+/VeZoPz7kxh6" +
       "9G7BLYau7Csl7X+8H/SFGHrNHQfF0KXi7zTsn8fQjfOwMXS5/D8N95dAqCdw" +
       "YNp95TTIX4HACUCK6peCvbddOJs5j7Xw0NfSwqlk+8YzKbK8jneUzpL9hbxb" +
       "ymeeZ4ff9ZXGT+xvTiiOlOcFlnv70NX9JY7jlPiGF8V2hOsK/dRXH/i5+950" +
       "lL4f2BN8YrinaHvizncUwJI8Lm8V5L/wuv/2tp96/gvld4t/A7SNOrMnKQAA");
}
