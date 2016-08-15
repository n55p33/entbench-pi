package org.apache.batik.anim.values;
public class AnimatableNumberValue extends org.apache.batik.anim.values.AnimatableValue {
    protected float value;
    protected AnimatableNumberValue(org.apache.batik.dom.anim.AnimationTarget target) {
        super(
          target);
    }
    public AnimatableNumberValue(org.apache.batik.dom.anim.AnimationTarget target,
                                 float v) { super(target);
                                            value = v; }
    public org.apache.batik.anim.values.AnimatableValue interpolate(org.apache.batik.anim.values.AnimatableValue result,
                                                                    org.apache.batik.anim.values.AnimatableValue to,
                                                                    float interpolation,
                                                                    org.apache.batik.anim.values.AnimatableValue accumulation,
                                                                    int multiplier) {
        org.apache.batik.anim.values.AnimatableNumberValue res;
        if (result ==
              null) {
            res =
              new org.apache.batik.anim.values.AnimatableNumberValue(
                target);
        }
        else {
            res =
              (org.apache.batik.anim.values.AnimatableNumberValue)
                result;
        }
        float v =
          value;
        if (to !=
              null) {
            org.apache.batik.anim.values.AnimatableNumberValue toNumber =
              (org.apache.batik.anim.values.AnimatableNumberValue)
                to;
            v +=
              interpolation *
                (toNumber.
                   value -
                   value);
        }
        if (accumulation !=
              null) {
            org.apache.batik.anim.values.AnimatableNumberValue accNumber =
              (org.apache.batik.anim.values.AnimatableNumberValue)
                accumulation;
            v +=
              multiplier *
                accNumber.
                  value;
        }
        if (res.
              value !=
              v) {
            res.
              value =
              v;
            res.
              hasChanged =
              true;
        }
        return res;
    }
    public float getValue() { return value;
    }
    public boolean canPace() { return true;
    }
    public float distanceTo(org.apache.batik.anim.values.AnimatableValue other) {
        org.apache.batik.anim.values.AnimatableNumberValue o =
          (org.apache.batik.anim.values.AnimatableNumberValue)
            other;
        return java.lang.Math.
          abs(
            value -
              o.
                value);
    }
    public org.apache.batik.anim.values.AnimatableValue getZeroValue() {
        return new org.apache.batik.anim.values.AnimatableNumberValue(
          target,
          0);
    }
    public java.lang.String getCssText() {
        return formatNumber(
                 value);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "YxgSd7q67Jy+GSqxVlH1O1XGTmBzDycNCtWHvMu9KthryBiGxqheHn+++Y6f" +
       "KxThls65NshN33yVWCMmCmi1X0h9tIoNv4/NSU6asqoMUtuNCJgeOQfWELEN" +
       "D6y6q5I+fWtUYq2i7FNVxp7G5nFOWmBPpZll+MHNN8UT58AUnTi2CB7H1ceZ" +
       "vikqsVZR98UqY7/A5jnABJiiD0oDSK9eamgXZ0QswhLy3ts3zs8+kxqYk9ll" +
       "LwfxgDqv5G8JeZWuPHy8rXHu8eteFZVG8bq7BWqGnKNpwYIv8F5vWiynCoVb" +
       "ZPlniq/XoZ6slgDhrCpfhA6vSaY3YN1lmTipxa8g7dtgxigtVITiO0j3DnjA" +
       "p4Np5UuQ5PeQUIEEX9815YaPhcu9ontmf5p7AhXi8lBlJf4z8qogR/5rNKqc" +
       "PL558MYza+6VF2WKRvfuRSnNcOSSd3bFSmpZRWmerPpNK8/OfGTG+V7N2SEX" +
       "7AN/YQCdfRDbTITDgsgVkt1TvEl67cQVT/78QP3LcErZQWKUk1k7So8PBdOB" +
       "EnZHqvRoCVWnuNvqXfntPVetzv35N+LKg5Qcy6L0o8rp+65/5a55J7ripHmA" +
       "1EE5zQriXHPNHn0bUyatNGlV7f4CLBGkqFQLnVtnInIp7iphF9ecrcVevGbl" +
       "pLv00F56Od2kGVPMWm84ehbFwMm32e/xKupQMeqYZoTB7wlcbKRlSkVvAPZG" +
       "U1tM07vTIOOmwOCO8vkV24/FKzZ//w/DIUrgTx4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "jgNUScqN5mrCi0R5vdHmTsVCR+uuULRoczEkzbbtctMV31uRXA/feJIW8rHm" +
       "yisNBbOkRnutLEti0KcckxcnuNHzBadijDc9ejbADQ/x0FBvrcpTwp8IE1dy" +
       "NHaBIf3OgmlEsFBkJcBdujRTE2boBHowWEp800nL2kyUYEq0lmWed4sKO4uD" +
       "Eud501DlK3Op5hpMNGSjRj3F7Bnao9odW07XcbdgrACeit/v1Zgh7jRKqsp7" +
       "9MJhAmVa0tzqUA5a8UQWCHNmSUyTQYA/X1JCgMSBOe2OVS1FCN1shhzJFihj" +
       "ZPfdidtotRhTwOm+x/ZmSktbO7MlPRObOEYt47FgSP2Ql9xBsY2XTcccFJuV" +
       "XlfCpO4wbVG9zWDhdnuchlmtEb5uzTebWGsKaiN15Aa16DVFf7PoETE8rjRL" +
       "9NToLOV006FivjZcYGV/vJw7NqYwSXPZqobL0Wxpb3RkzUypcq3W4DbLlWh0" +
       "RC9cqaVBVWL7prIZWIlc8oVE1uuhQzdL8kjTSLqlofJAV2tceYZ3yBWBTc3Z" +
       "oCuz1DR0S4VCYUiW525cbIutWqJiCstgznBDpq7nJFLK8qvxGEnj2rAz3rAN" +
       "x06aareJppYgor2KlCL2YIM0pcV0JEwK3UoZM8mu0cQ301ZU8+02A6sumSjr" +
       "ljoYLvU22x8SdiDg82BY6aUxIkcjcWm6Y6EyXjCToehRBdXomnxTjZjehmkW" +
       "nNVS5vXJsN1yJx26hy30mVioNgNmwi9Lo03CiJM6wvOLwaxDqgnebZjqkDJF" +
       "uFboYd4i8fvWrN1Lgddw+jRtEKs4DtNaMkJEbLNew4O4xrIcsjBKditMlJU1" +
       "IFVs4xaHSqrGqMMpTIkoy0afMjmbjTdCt1Jl7Z7Z7AxbrWjCW3VYE9UW6vpN" +
       "kl8JWHnGDmvLikQsS4xCYmahtkgdmymtK5S93iy9+cJtiwTj2RgpuYZsWfZi" +
       "TI7Hpqws1DKn87wlViNLn6QtSammRE8iZsTYlVCD6zilnrjC4V5BIXqkibRJ" +
       "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" +
       "iVf/1uNfzy9a/g84NMzKrigAAA==");
}
