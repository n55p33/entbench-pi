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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "5Nnh3stghwk4Ng2ebY4y28Zuh1KsZXQ9WmbsW9h8g5Nqheq97pVfGfBVJw1D" +
       "Y1QvDkDPfN+8DOZrcWHEHBuwsZuvFGvIRD6tZGH0vTI2fBqb73BSl1Jl3Nok" +
       "bsR81njyMlhDhDssYzVHJW3s1ijFWkbZ58qMPY/Ns5w0wKHqZ5bhi3d5U/z4" +
       "cvkXzFNtRx977KYoxVpG3V+UGTuLzWnABJiiC9JKiJQhB3PmEymWOJlU9HoQ" +
       "S9SpBX9MyMt05fEjTTVTjmx+TSSa+QvvBsgd0llN81cGvvcq02JpVSjXIOsE" +
       "Ga/egMKjXP4DWb58ETq8LpnehHUXZeJkHH75ad+B0jRMCxFbfPvp3gVre3Qw" +
       "rXzxk/weoieQ4Ot7pjzckWBZkN+eSZfaHl8lMTeQEIl/jdycISv/NxpQTh5Z" +
       "u/62C9cdk1dlikb37EEp9ZApyFu7fCI9p6Q0V1bVmgUXxz9RO89NYFrkgj2Q" +
       "T/chsQv8mIlwmBa6RLI78ndJrx9d/uzPDlSdhdRrK4lQTiZsLawzc2YWKpit" +
       "icKMCIoOcbvVueDroysWpf/8G3HpQQrq9zD9gPLq8W2vHJx6tC1K6ntIJeRm" +
       "LCcK4JtG9Y1MGbb6SaNqd+dgiSBFpVog3RqPyKUIeWEXx5yN+V68aOWkvTCF" +
       "LLyertOMEWatMrJ6CsVAwlbv9bgFVaAWyZpmiMHr8aXZX5DhE3cDsDeQWGea" +
       "boZNjpkCg3cVj6XYfiResfn7fwB8cOHyUR4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "O098Mztl+j9bPBiRrCgAAA==");
}
