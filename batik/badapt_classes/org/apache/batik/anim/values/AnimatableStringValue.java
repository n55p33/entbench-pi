package org.apache.batik.anim.values;
public class AnimatableStringValue extends org.apache.batik.anim.values.AnimatableValue {
    protected java.lang.String string;
    protected AnimatableStringValue(org.apache.batik.dom.anim.AnimationTarget target) {
        super(
          target);
    }
    public AnimatableStringValue(org.apache.batik.dom.anim.AnimationTarget target,
                                 java.lang.String s) { super(
                                                         target);
                                                       string =
                                                         s;
    }
    public org.apache.batik.anim.values.AnimatableValue interpolate(org.apache.batik.anim.values.AnimatableValue result,
                                                                    org.apache.batik.anim.values.AnimatableValue to,
                                                                    float interpolation,
                                                                    org.apache.batik.anim.values.AnimatableValue accumulation,
                                                                    int multiplier) {
        org.apache.batik.anim.values.AnimatableStringValue res;
        if (result ==
              null) {
            res =
              new org.apache.batik.anim.values.AnimatableStringValue(
                target);
        }
        else {
            res =
              (org.apache.batik.anim.values.AnimatableStringValue)
                result;
        }
        java.lang.String newString;
        if (to !=
              null &&
              interpolation >=
              0.5) {
            org.apache.batik.anim.values.AnimatableStringValue toValue =
              (org.apache.batik.anim.values.AnimatableStringValue)
                to;
            newString =
              toValue.
                string;
        }
        else {
            newString =
              string;
        }
        if (res.
              string ==
              null ||
              !res.
                 string.
              equals(
                newString)) {
            res.
              string =
              newString;
            res.
              hasChanged =
              true;
        }
        return res;
    }
    public java.lang.String getString() {
        return string;
    }
    public boolean canPace() { return false;
    }
    public float distanceTo(org.apache.batik.anim.values.AnimatableValue other) {
        return 0.0F;
    }
    public org.apache.batik.anim.values.AnimatableValue getZeroValue() {
        return new org.apache.batik.anim.values.AnimatableStringValue(
          target,
          "");
    }
    public java.lang.String getCssText() {
        return string;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "PDvcfQnsMAHHpsGzzVFm29jtUIq1jK7Hyox9C5tvclKtUL3XvfIrA77qpGFo" +
       "jOrFAeiZ76FLYL4WF0bMsQEbu/lKsYZM5NNKFkbfK2PDZ7H5Did1KVXGrU3i" +
       "RsxnjacvgTVEuMMyVnNU0sZujVKsZZQ9VWbseWxOcNIAh6qfWYYv3uVN8eNL" +
       "5V8wT7Udfeyxm6IUaxl1f1Fm7FVsTgMmwBRdkFZCpAw5mJc/lWKJk0lFrwex" +
       "RJ1a8MeEvExXnjzaVDPl6OY3RKKZv/BugNwhndU0f2Xge68yLZZWhXINsk6Q" +
       "8eotKDzK5T+Q5csXocObkukMrLsoEyfj8MtP+w6UpmFaiNji20/3Lljbo4Np" +
       "5Yuf5PcQPYEEX98z5eGOBMuC/PZMutj2+CqJuYGESPxr5OYMWfm/0YBy/Oja" +
       "9XsvXPOwvCpTNLpnD0qph0xB3trlE+k5JaW5sqrWLPh4/FO189wEpkUu2AP5" +
       "dB8Su8CPmQiHaaFLJLsjf5f05rFrT/xsf9WrkHptJRHKyYSthXVmzsxCBbM1" +
       "UZgRQdEhbrc6F3xj9PpF6T//Rlx6kIL6PUw/oLz+yLbXDk091hYl9T2kEnIz" +
       "lhMF8I2j+kamDFv9pFG1u3OwRJCiUi2Qbo1H5FKEvLCLY87GfC9etHLSXphC" +
       "Fl5P12nGCLNWGlk9hWIgYav3etyCKlCLZE0zxOD1+NLsL8nwibsB2BtIrDNN" +
       "N8MmD5kCg3cUj6XYfiResfn7fwDD87yyUR4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "uC25LdxfjddCx8YNJVRazFKKMVsY2mO6zLrdwcAk46BNyP1VbZzEZlUI6dqo" +
       "pjmMs27zVblm9xy20Zg21931vBk0lP6g1a2lUtAYzkoVrWEw/qASLWlpvF51" +
       "BBS1LWM511G1xAoI4Rpxz6555Wq7zk9Wk9bYmNeBQcaSJOOdQLAWHsr5Ud/B" +
       "N1QvCBIk1cJQEGZaaR0OVrCMSBHZDxl7ydQ0u4ebVDFCO71+bY3prt3oDbSp" +
       "JCzmsxoZSk18utCbC7SuUrXSSHS7E3dGJm1JWyUCj6eMtWRsTU+ra3FW7ysL" +
       "ctAnR15toXILiow7i47cHRkcqTdwkmtUW8XirF6fBCnTW9u8MimNpZGqSfVB" +
       "Z91oaGG6IhZOYBItzpSonsg1LWIq+ZOyNTXgIDWMQrmxNHyZ5X0rGog8vxmp" +
       "xqa4isWJ2A87xSi11DrmiRHZSM0mUlC8At8kCJ0iepN+H4ZXPq9Q4UQzqPaY" +
       "I3AiWrcQe+1gQ9KdtFm4N+9VqfU6XrW4iSvKSbUwbPfTsRdqvFhT11LVZRzE" +
       "4maiutJYZbkJkDKOz+mi0Z3yeND007i1aqn9sdVqOFxJskpu4jF+sHZ0exYX" +
       "S31NDNdtgemjw3giof3ykIsTBkcaqZtYCyYaLRmqKY96RLeWNLSSNmgVysiY" +
       "tThdXYtm0PD14oxkOaIDV4OIo0xszVjpgJIXYWK2l/Fww1eqNTItuoQiGtaY" +
       "J/EwNGOJKNfF/nrVSBheJcmmV6dma2zcXkiiYJaWfb5Z41oBWy/7tMaIY6Vg" +
       "FOReR5W51OqOWvWN5I+02VD25E7ZDKRZyW9sBmECpu6Aq8tDe8M2FoMQDFfd" +
       "Y9tIf5UyU5VBqmg3mfQpZC2PrK657iyQBjqvRBUCXdV1otlKlaIiJKhYwdGG" +
       "SA7aDbst+RghT6NZqy0g84guoTO2h2lKi52yA3peFbo6Mw66/IJtRqU5UQzD" +
       "Zns1ifwEKdcrXYJidI0C3hyXxa61ITsTZ0W5gmUuBk4jmLuUJ24wp+mthhUn" +
       "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" +
       "8Vf+9hNfy2+Z/g+fKnUNrCgAAA==");
}
