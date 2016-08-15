package org.apache.batik.anim.values;
public class AnimatablePaintValue extends org.apache.batik.anim.values.AnimatableColorValue {
    public static final int PAINT_NONE = 0;
    public static final int PAINT_CURRENT_COLOR = 1;
    public static final int PAINT_COLOR = 2;
    public static final int PAINT_URI = 3;
    public static final int PAINT_URI_NONE = 4;
    public static final int PAINT_URI_CURRENT_COLOR = 5;
    public static final int PAINT_URI_COLOR = 6;
    public static final int PAINT_INHERIT = 7;
    protected int paintType;
    protected java.lang.String uri;
    protected AnimatablePaintValue(org.apache.batik.dom.anim.AnimationTarget target) {
        super(
          target);
    }
    protected AnimatablePaintValue(org.apache.batik.dom.anim.AnimationTarget target,
                                   float r,
                                   float g,
                                   float b) { super(target,
                                                    r,
                                                    g,
                                                    b); }
    public static org.apache.batik.anim.values.AnimatablePaintValue createNonePaintValue(org.apache.batik.dom.anim.AnimationTarget target) {
        org.apache.batik.anim.values.AnimatablePaintValue v =
          new org.apache.batik.anim.values.AnimatablePaintValue(
          target);
        v.
          paintType =
          PAINT_NONE;
        return v;
    }
    public static org.apache.batik.anim.values.AnimatablePaintValue createCurrentColorPaintValue(org.apache.batik.dom.anim.AnimationTarget target) {
        org.apache.batik.anim.values.AnimatablePaintValue v =
          new org.apache.batik.anim.values.AnimatablePaintValue(
          target);
        v.
          paintType =
          PAINT_CURRENT_COLOR;
        return v;
    }
    public static org.apache.batik.anim.values.AnimatablePaintValue createColorPaintValue(org.apache.batik.dom.anim.AnimationTarget target,
                                                                                          float r,
                                                                                          float g,
                                                                                          float b) {
        org.apache.batik.anim.values.AnimatablePaintValue v =
          new org.apache.batik.anim.values.AnimatablePaintValue(
          target,
          r,
          g,
          b);
        v.
          paintType =
          PAINT_COLOR;
        return v;
    }
    public static org.apache.batik.anim.values.AnimatablePaintValue createURIPaintValue(org.apache.batik.dom.anim.AnimationTarget target,
                                                                                        java.lang.String uri) {
        org.apache.batik.anim.values.AnimatablePaintValue v =
          new org.apache.batik.anim.values.AnimatablePaintValue(
          target);
        v.
          uri =
          uri;
        v.
          paintType =
          PAINT_URI;
        return v;
    }
    public static org.apache.batik.anim.values.AnimatablePaintValue createURINonePaintValue(org.apache.batik.dom.anim.AnimationTarget target,
                                                                                            java.lang.String uri) {
        org.apache.batik.anim.values.AnimatablePaintValue v =
          new org.apache.batik.anim.values.AnimatablePaintValue(
          target);
        v.
          uri =
          uri;
        v.
          paintType =
          PAINT_URI_NONE;
        return v;
    }
    public static org.apache.batik.anim.values.AnimatablePaintValue createURICurrentColorPaintValue(org.apache.batik.dom.anim.AnimationTarget target,
                                                                                                    java.lang.String uri) {
        org.apache.batik.anim.values.AnimatablePaintValue v =
          new org.apache.batik.anim.values.AnimatablePaintValue(
          target);
        v.
          uri =
          uri;
        v.
          paintType =
          PAINT_URI_CURRENT_COLOR;
        return v;
    }
    public static org.apache.batik.anim.values.AnimatablePaintValue createURIColorPaintValue(org.apache.batik.dom.anim.AnimationTarget target,
                                                                                             java.lang.String uri,
                                                                                             float r,
                                                                                             float g,
                                                                                             float b) {
        org.apache.batik.anim.values.AnimatablePaintValue v =
          new org.apache.batik.anim.values.AnimatablePaintValue(
          target,
          r,
          g,
          b);
        v.
          uri =
          uri;
        v.
          paintType =
          PAINT_URI_COLOR;
        return v;
    }
    public static org.apache.batik.anim.values.AnimatablePaintValue createInheritPaintValue(org.apache.batik.dom.anim.AnimationTarget target) {
        org.apache.batik.anim.values.AnimatablePaintValue v =
          new org.apache.batik.anim.values.AnimatablePaintValue(
          target);
        v.
          paintType =
          PAINT_INHERIT;
        return v;
    }
    public org.apache.batik.anim.values.AnimatableValue interpolate(org.apache.batik.anim.values.AnimatableValue result,
                                                                    org.apache.batik.anim.values.AnimatableValue to,
                                                                    float interpolation,
                                                                    org.apache.batik.anim.values.AnimatableValue accumulation,
                                                                    int multiplier) {
        org.apache.batik.anim.values.AnimatablePaintValue res;
        if (result ==
              null) {
            res =
              new org.apache.batik.anim.values.AnimatablePaintValue(
                target);
        }
        else {
            res =
              (org.apache.batik.anim.values.AnimatablePaintValue)
                result;
        }
        if (paintType ==
              PAINT_COLOR) {
            boolean canInterpolate =
              true;
            if (to !=
                  null) {
                org.apache.batik.anim.values.AnimatablePaintValue toPaint =
                  (org.apache.batik.anim.values.AnimatablePaintValue)
                    to;
                canInterpolate =
                  toPaint.
                    paintType ==
                    PAINT_COLOR;
            }
            if (accumulation !=
                  null) {
                org.apache.batik.anim.values.AnimatablePaintValue accPaint =
                  (org.apache.batik.anim.values.AnimatablePaintValue)
                    accumulation;
                canInterpolate =
                  canInterpolate &&
                    accPaint.
                      paintType ==
                    PAINT_COLOR;
            }
            if (canInterpolate) {
                res.
                  paintType =
                  PAINT_COLOR;
                return super.
                  interpolate(
                    res,
                    to,
                    interpolation,
                    accumulation,
                    multiplier);
            }
        }
        int newPaintType;
        java.lang.String newURI;
        float newRed;
        float newGreen;
        float newBlue;
        if (to !=
              null &&
              interpolation >=
              0.5) {
            org.apache.batik.anim.values.AnimatablePaintValue toValue =
              (org.apache.batik.anim.values.AnimatablePaintValue)
                to;
            newPaintType =
              toValue.
                paintType;
            newURI =
              toValue.
                uri;
            newRed =
              toValue.
                red;
            newGreen =
              toValue.
                green;
            newBlue =
              toValue.
                blue;
        }
        else {
            newPaintType =
              paintType;
            newURI =
              uri;
            newRed =
              red;
            newGreen =
              green;
            newBlue =
              blue;
        }
        if (res.
              paintType !=
              newPaintType ||
              res.
                uri ==
              null ||
              !res.
                 uri.
              equals(
                newURI) ||
              res.
                red !=
              newRed ||
              res.
                green !=
              newGreen ||
              res.
                blue !=
              newBlue) {
            res.
              paintType =
              newPaintType;
            res.
              uri =
              newURI;
            res.
              red =
              newRed;
            res.
              green =
              newGreen;
            res.
              blue =
              newBlue;
            res.
              hasChanged =
              true;
        }
        return res;
    }
    public int getPaintType() { return paintType;
    }
    public java.lang.String getURI() { return uri;
    }
    public boolean canPace() { return false;
    }
    public float distanceTo(org.apache.batik.anim.values.AnimatableValue other) {
        return 0.0F;
    }
    public org.apache.batik.anim.values.AnimatableValue getZeroValue() {
        return org.apache.batik.anim.values.AnimatablePaintValue.
          createColorPaintValue(
            target,
            0.0F,
            0.0F,
            0.0F);
    }
    public java.lang.String getCssText() {
        switch (paintType) {
            case PAINT_NONE:
                return "none";
            case PAINT_CURRENT_COLOR:
                return "currentColor";
            case PAINT_COLOR:
                return super.
                  getCssText(
                    );
            case PAINT_URI:
                return "url(" +
                uri +
                ")";
            case PAINT_URI_NONE:
                return "url(" +
                uri +
                ") none";
            case PAINT_URI_CURRENT_COLOR:
                return "url(" +
                uri +
                ") currentColor";
            case PAINT_URI_COLOR:
                return "url(" +
                uri +
                ") " +
                super.
                  getCssText(
                    );
            default:
                return "inherit";
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "DL7y1+bff9Gyn+dZzL3wPw0K+28jMQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "jD/T9Rq1cSFVSvvImlsXe1AZX9CDev64");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("7LWbewT3UP748Pgk3Zt4cJic8dj0g/uTG/nvXOHUeawTj2FPvHgtZG+V33Gj" +
       "I3P5G+Uvf/LlV1T2K6XD3UvfdlS4J/L8n7a1lWafaOoCaOk9N36HS+cnBvcv" +
       "Un/zk3/yhPD++Ydv4tzRO0/hPN3kP6K/+tvUu5TPHRbuOH6tes1ZxqsrXb76" +
       "Zeq9gRbFgStc9Ur1HceSzV8KXAZXayfZ1ukH3PvRvGaYDvd6sVWJUy/WD/aD" +
       "WcwL/OEZb97/KAt+Pyq8VQk0OdIYzz1xauyUSv37m3krnyf8u6sZN8HF7hiz" +
       "P0nG/+UMxv8tC74ZFZ7cMm7GQaC5UdOzveCGzL91q8zfC67pjvn0NjI/eUol" +
       "C4h9kJf/0zME8XoW/ElUeHQniDMl8L1blcBfBZeyk4ByGyVwuC+VS+DVvNSP" +
       "zuD9F1nwg6jwyJb3aNi5Iesf3irr94PL27H2ftKsD87fmPXBPVlwGBUeO2Z9" +
       "lq0f3HGrzElwfWTH/CM/ceaPnMH80Sx4AHjwY+ZvxOYPLtyqBH4GXC/tJPDS" +
       "bZTAXXmpu/YSuI7hH7zzDIFkJ+MOnogKj+8FcqYk3n47rOBzO0l87jZK4rTf" +
       "P4DOYP3TWfCuYwPouHMtMKMbkn73LZB+e5aYHVT40o70l26C9G4VdsbIH73M" +
       "fvENHgM/oneAHynJNpafRT/AzpDZ5SwoR4W35F94gAUQEFxefS8n5BbkdKGw" +
       "E9Z3dnL6zu2R00kKZ+VRWfCBqHCfoW0V4fjswp5f/Rb4PZwlZidCvrvj993b" +
       "z29wRh6fBf2ocA7w2514enXPjL4FZo9kiU+A6/Uds9dvP7MPnpF3JQsmUeG8" +
       "Irvc0YdHp84enJ95nq3J7p7x9BYYP3Skq3++Y/znt4fx3ocd4Dk1+wza2Sn+" +
       "AyMq3Kua222HkH9KQ+wpzm/VbQGHfbBjuL3f3kFNzshLsyDcmqOkBd7eb+35" +
       "Rbdqjk8CqOd3/M7ffn5/84y8T2XBx8DoAX5NsDEGW9tTJvnxmzr3DHZt1/vW" +
       "J/tq4fFrPjHcfhanfO2VC3c/9sroD/PPXY4/XbunX7hbj2375HHgE/FzfqDp" +
       "Zs79nu3hYD8n9PNgF3XWHAQ8zzaSYT/4O9tKnwU7jutWigp3ZreTZX8xKjx4" +
       "umxUuCu/nyz3BSDUfTnQ7TZyssgvR4U7QJEs+iv+0Qz6Rj+kytdHuXCT7em9" +
       "x09qWL5VePjHDd2J5yTPXfV0I/9o9OhJRLz9bPSK8vVXusxHXke/sv2+R7Hl" +
       "NDOPwt39wvntp0Z5o9nTjGdu2NpRW+faL/zogV+/5/mjJy8PbAHvtf0Etnde" +
       "/0ualuNH+bcv6T977J+89x+88s38tPb/A7kTy3XNOwAA");
}
