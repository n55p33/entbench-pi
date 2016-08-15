package org.apache.batik.anim.values;
public class AnimatableNumberOrIdentValue extends org.apache.batik.anim.values.AnimatableNumberValue {
    protected boolean isIdent;
    protected java.lang.String ident;
    protected boolean numericIdent;
    protected AnimatableNumberOrIdentValue(org.apache.batik.dom.anim.AnimationTarget target) {
        super(
          target);
    }
    public AnimatableNumberOrIdentValue(org.apache.batik.dom.anim.AnimationTarget target,
                                        float v,
                                        boolean numericIdent) {
        super(
          target,
          v);
        this.
          numericIdent =
          numericIdent;
    }
    public AnimatableNumberOrIdentValue(org.apache.batik.dom.anim.AnimationTarget target,
                                        java.lang.String ident) {
        super(
          target);
        this.
          ident =
          ident;
        this.
          isIdent =
          true;
    }
    public boolean canPace() { return false; }
    public float distanceTo(org.apache.batik.anim.values.AnimatableValue other) {
        return 0.0F;
    }
    public org.apache.batik.anim.values.AnimatableValue getZeroValue() {
        return new org.apache.batik.anim.values.AnimatableNumberOrIdentValue(
          target,
          0.0F,
          numericIdent);
    }
    public java.lang.String getCssText() {
        if (isIdent) {
            return ident;
        }
        if (numericIdent) {
            return java.lang.Integer.
              toString(
                (int)
                  value);
        }
        return super.
          getCssText(
            );
    }
    public org.apache.batik.anim.values.AnimatableValue interpolate(org.apache.batik.anim.values.AnimatableValue result,
                                                                    org.apache.batik.anim.values.AnimatableValue to,
                                                                    float interpolation,
                                                                    org.apache.batik.anim.values.AnimatableValue accumulation,
                                                                    int multiplier) {
        org.apache.batik.anim.values.AnimatableNumberOrIdentValue res;
        if (result ==
              null) {
            res =
              new org.apache.batik.anim.values.AnimatableNumberOrIdentValue(
                target);
        }
        else {
            res =
              (org.apache.batik.anim.values.AnimatableNumberOrIdentValue)
                result;
        }
        if (to ==
              null) {
            if (isIdent) {
                res.
                  hasChanged =
                  !res.
                     isIdent ||
                    !res.
                       ident.
                    equals(
                      ident);
                res.
                  ident =
                  ident;
                res.
                  isIdent =
                  true;
            }
            else
                if (numericIdent) {
                    res.
                      hasChanged =
                      res.
                        value !=
                        value ||
                        res.
                          isIdent;
                    res.
                      value =
                      value;
                    res.
                      isIdent =
                      false;
                    res.
                      hasChanged =
                      true;
                    res.
                      numericIdent =
                      true;
                }
                else {
                    float oldValue =
                      res.
                        value;
                    super.
                      interpolate(
                        res,
                        to,
                        interpolation,
                        accumulation,
                        multiplier);
                    res.
                      numericIdent =
                      false;
                    if (res.
                          value !=
                          oldValue) {
                        res.
                          hasChanged =
                          true;
                    }
                }
        }
        else {
            org.apache.batik.anim.values.AnimatableNumberOrIdentValue toValue =
              (org.apache.batik.anim.values.AnimatableNumberOrIdentValue)
                to;
            if (isIdent ||
                  toValue.
                    isIdent ||
                  numericIdent) {
                if (interpolation >=
                      0.5) {
                    if (res.
                          isIdent !=
                          toValue.
                            isIdent ||
                          res.
                            value !=
                          toValue.
                            value ||
                          res.
                            isIdent &&
                          toValue.
                            isIdent &&
                          !toValue.
                             ident.
                          equals(
                            ident)) {
                        res.
                          isIdent =
                          toValue.
                            isIdent;
                        res.
                          ident =
                          toValue.
                            ident;
                        res.
                          value =
                          toValue.
                            value;
                        res.
                          numericIdent =
                          toValue.
                            numericIdent;
                        res.
                          hasChanged =
                          true;
                    }
                }
                else {
                    if (res.
                          isIdent !=
                          isIdent ||
                          res.
                            value !=
                          value ||
                          res.
                            isIdent &&
                          isIdent &&
                          !res.
                             ident.
                          equals(
                            ident)) {
                        res.
                          isIdent =
                          isIdent;
                        res.
                          ident =
                          ident;
                        res.
                          value =
                          value;
                        res.
                          numericIdent =
                          numericIdent;
                        res.
                          hasChanged =
                          true;
                    }
                }
            }
            else {
                super.
                  interpolate(
                    res,
                    to,
                    interpolation,
                    accumulation,
                    multiplier);
                res.
                  numericIdent =
                  false;
            }
        }
        return res;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL0Za3BU1fnsJiQhJOTBUyABQsDhtStU7dCoFUKQ6JKkJDLT" +
       "TTGcvXs2uXD33su9Z5MFi1VHB/piKMVXK/zo4GApitPWaW2rQ8epj1E7o9Cq" +
       "7aidtlOtlqmMre3Utvb7zrl372MfNB3tztyzd8/5vu987+87Z0+dJ1Nsi7Qz" +
       "ncf4HpPZsR6dD1DLZulujdr2EMyNKPdU0fdueqtvXZTUJMn0MWpvUajNNqlM" +
       "S9tJ0qbqNqe6wuw+xtKIMWAxm1njlKuGniSzVLs3a2qqovItRpohwDZqJUgL" +
       "5dxSUznOeh0CnLQlgJO44CS+PrzclSANimHu8cDn+sC7fSsImfX2sjlpTuyk" +
       "4zSe46oWT6g278pbZKVpaHtGNYPHWJ7HdmpXOCq4PnFFkQo6Hml6/4NDY81C" +
       "BTOorhtciGdvZbahjbN0gjR5sz0ay9q7yS2kKkGm+YA56Uy4m8Zh0zhs6krr" +
       "QQH3jUzPZbsNIQ53KdWYCjLEyeIgEZNaNOuQGRA8A4U67sgukEHaRQVppZRF" +
       "It61Mn7knpuav1tFmpKkSdUHkR0FmOCwSRIUyrIpZtnr02mWTpIWHYw9yCyV" +
       "aupex9KttjqqU54D87tqwcmcySyxp6crsCPIZuUUblgF8TLCoZxfUzIaHQVZ" +
       "Z3uySgk34TwIWK8CY1aGgt85KNW7VD3NycIwRkHGzhsAAFBrs4yPGYWtqnUK" +
       "E6RVuohG9dH4ILiePgqgUwxwQIuTeWWJoq5Nquyio2wEPTIENyCXAGqqUASi" +
       "cDIrDCYogZXmhazks8/5vqsO3qxv1qMkAjynmaIh/9MAqT2EtJVlmMUgDiRi" +
       "w4rE3XT24weihADwrBCwhPnB5y9cu6r9zDMSZn4JmP7UTqbwEeV4avqLC7qX" +
       "r6tCNupMw1bR+AHJRZQNOCtdeRMyzOwCRVyMuYtntj712VtPsneipL6X1CiG" +
       "lsuCH7UoRtZUNWZdx3RmUc7SvWQq09PdYr2X1MJ7QtWZnO3PZGzGe0m1JqZq" +
       "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" +
       "0gkKxkiteMW3uv8AnZk3rfUfAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "XLqj/oCmJtss742CfocyBrtWdbedztyeTTKLYUeh8k6d7mLaKqmwnelujrob" +
       "a0oostuJcG5CLfx2MCJteEhaLBdtFuEiwTA7401v5nVFP+moiEKsA1obUJLg" +
       "xY2dq1SNLrYajjJ8uMJVUpZ22xFfZQYjRBuRuIfsNmauDpsze4aOFJckBKq5" +
       "oLOWVeE1B/NqqKKFC9qNeZnu+uhQmlFcz6isCbuyHXJYunNMZFi1YRlurzAv" +
       "hlVpEaGUhQ/quiEZ7jrVllqL8mtaT1QG1HgTZBW6wbkr2duyasOYmT2L3ep1" +
       "k5tYQaD2qUqGUGRnoI5Hwrq2WHTri1ZO0va4axssVzPHuoR2lRkjNBYpPRbx" +
       "eb7byHE+m+YOj2vkOI2GlBBQyHJsV+daBQ61MU4CC8rKEMmWDBNhVlbvUkF/" +
       "sQ0NZaws1XC3JuJoEZKJgy0qqzqR2mp3ubU9YhbtMEphuuayx2pwI+cai3p9" +
       "067QlpuqrY3TSxF6yRI1mq0mZsehPXIAQBc3wrBlmd2hvO10SXmVTw1EnTM1" +
       "d0AtlyLcDsUgsKuzlqYM5dhlBkyzagf0FuvYWHvbwRwklpIKYmLUFMxqVQ+T" +
       "xwQuVUQNtVhN6Uc1YsVNE73pRIm/8gR5bWxpLdL41syfrU2E72ydVjJs+VRv" +
       "m8sZEzoU1hliRL8fWGTfaPJhr27PzaS7mw9H62moLDmjKdbGtRE+0a0gqcrC" +
       "pLLSFS2vYQazMMi8C4f1hOrHbo2ft3uuZul8Bx428ilrsRjBdeJxe1yPRSXK" +
       "O1qHmWyFvrpZa0GrP5gtVypwOH0bREEdaza4VKMRedrEJT7YbavJ0gY+OZ1R" +
       "PL8cT5QhJ7YrFSvwCINFGGJCC4I9bfWEmTwc9b1lXdvmYoNhYJ1sYQ3YEpxN" +
       "UI0XLCMMWXeEbdZsNk9HeR6QpKbPiU2o0rvFBjd2Ypw19GVF4tXumqostHZ3" +
       "SRkxogxdtwMH6U7shllljdkCMbfUXKAnm03IVlm/S6p+N3fJVVZR7K1BUT0b" +
       "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" +
       "AA==");
}
