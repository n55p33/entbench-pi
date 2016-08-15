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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "fs8Mh06XGdrgucbR5ZrZm6EUaxlVj5YZux+b70K5oVB9kCphK3zvNFihxQVD" +
       "2lElPXsrlGINaerbHPuE1EfLmOIH2BzjpDatyhA1LK6/bvKs8chpsIaIbHhg" +
       "nXBUmpi9NUqxllH2qTJjT2PzOCf1sDWSzDJCoU2Y4onTYIpWHMNCw3L0sWZv" +
       "ilKsZdR9sczYL7F5DjABpuiBwgCSq5sYmsUZEUuwmLz69ozz88+lAuZkwcy3" +
       "g3hCXVT014S8TlcePtxUs/Dw1a+JQqNw5V0PJUMmp2n+es/3Xm1aLKMKjetl" +
       "9WeKr9ehnCyX/+CwKl+EEick0xuczJ+RiZNK/PLTvg12DNNChhTffrp3wAUe" +
       "HUwrX/wkf4DECCT4+q4pd3wkWO0V/DP/VP7xFYgrAoWV+N/ILYJy8p+jUeXY" +
       "4Sv7rzt50b3ypkzR6J49KKUOTlzy0q5QSC0vKc2VVb1l1SeNj8w9yy05W+SC" +
       "PeQv9sGzB4KbiXBoC90h2V2Fq6QTR9Y/+YsD1S/DIWU7iVBO5m0vPj3kzRxU" +
       "sNsTxSdLKDrF5Vb3qrumL1uT+ctvxZ0HKTqVhelHlVePXvvKbYuOdERJXR+p" +
       "gmqa5cWxZtO0vo0pk1aSNKh2bx6WCFJUqgWOrY2IXIrbStjFMWdDoRfvWTnp" +
       "LD61F99O12rGFLM2Gjk9jWLg4Fvn9bgFdaAWzZlmiMHr8d1sJLEZyKM3AHuj" +
       "ia2m6V5qkJtNgcHtpcu8j8UrNv/4L8aT1wxTHgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
