package org.apache.batik.css.engine.value.svg;
public class DominantBaselineManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_AUTO_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          AUTO_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_ALPHABETIC_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          ALPHABETIC_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_CENTRAL_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          CENTRAL_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_HANGING_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          HANGING_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_IDEOGRAPHIC_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          IDEOGRAPHIC_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_MATHEMATICAL_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          MATHEMATICAL_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_MIDDLE_VALUE, org.apache.batik.css.engine.value.svg.SVGValueConstants.
                                              MIDDLE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_NO_CHANGE_VALUE, org.apache.batik.css.engine.value.svg.SVGValueConstants.
                                                 NO_CHANGE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_RESET_SIZE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          RESET_SIZE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_TEXT_AFTER_EDGE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          TEXT_AFTER_EDGE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_TEXT_BEFORE_EDGE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          TEXT_BEFORE_EDGE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_TEXT_BOTTOM_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          TEXT_BOTTOM_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_TEXT_TOP_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          TEXT_TOP_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_USE_SCRIPT_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          USE_SCRIPT_VALUE);
    }
    public boolean isInheritedProperty() {
        return false;
    }
    public boolean isAnimatableProperty() {
        return true;
    }
    public boolean isAdditiveProperty() {
        return false;
    }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT;
    }
    public java.lang.String getPropertyName() {
        return org.apache.batik.util.CSSConstants.
                 CSS_DOMINANT_BASELINE_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 AUTO_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public DominantBaselineManager() { super(
                                         );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "+KV73jknJbJ92+nxaPw55HGzx6+BCBtwbSY8KVsOqdGLsBBqETGdKrL2HA7f" +
       "94twHcQqpxqrFwU+1qR21eVK6MQ1kNA4XJsBj26zqY9eQoVQi0jhZ0XWXsbh" +
       "J5aEVrAkzShWwe5IaO7I9aoLLwT3wjUQXCOuzUIom/vB0QuuEGoR4bxZZO3X" +
       "OJzhZCwIriMB2RIafmbVld2uMH75vxBGlpNJBS7+sEudnPefhHWPLj17pK5y" +
       "0pG7zolaOXfXXQO1TzKjKN4+yvNerhssKQsWa6yuShdf73Iy+wvdUUIAglHw" +
       "cs5CfZ+TmSOiQnM1kDMkG/E8J1OKIEJzZb14cf4ASXU4HCALRi/kR+D/QUig" +
       "Qnx74T7mpNqFg0OtFy/IJ7A7gODrRd1xnZtGFpdrOLY+syF/B5YzpMaRDMnT" +
       "tM3yVarijy2nlMtYf231SiePrFl37+UvPWXd6EkK3bkTdxkDBZx1b5jrWWYW" +
       "3M3Zq3z1vCtjT1XNdipL342ilzZhzpCNxO1bU+CKy2zN3XS9d3TJS7/aW/42" +
       "1MRbSIhCb7Al//Ygq2egWdwSyy9Uob8Td29t8x4fWrow+df3xf0MybuVCcL3" +
       "SmeP3fPOgclHm8NkTAcpg6KZZcW1xoohdQOTBoweUiubK7NAIuqNKr4qeCx6" +
       "GMUsIuRii7M2N4tXvZy05Nf2+Rfk1Yo2yIzlWkZN4DZQR49xZ5ze1df2ZXQ9" +
       "gODOeNqZrFUqoDbAZHtjnbru3JOWNuoi3gwNXzvg+Ll4xeHqfwHps3/49B4A" +
       "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAMV6a+zsxnUf75V0r6TIuleSbbmyLetxZUfe9M/lY19Q7JjL" +
       "5e5y+doHl9xl00h8LZfL5/Kx5DJR6hhpbNSoayRy4gCJ+qE22gR+BEGCvpBA" +
       "RZDaQYwAKdw2bVE7LQLEbWog/tC0qNumQ+7/rXuvIkhAF+Asd+acmfM7c86Z" +
       "szPzpe9C98URVAsDd2+5QXJk5snRxm0cJfvQjI9GbGOsRrFpkK4axyKoe1F/" +
       "5tdu/MX3P7u+eRW6pkCPqb4fJGpiB348NePA3ZkGC904q6Vc04sT6Ca7UXcq" +
       "nCa2C7N2nLzAQj9wjjWBbrEnIsBABBiIAFciwMQZFWB6h+mnHllyqH4Sb6Gf" +
       "hK6w0LVQL8VLoKcvdhKqkeoddzOuEIAe7i9/SwBUxZxH0FOn2A+YXwf4czX4" +
       "lV/4sZu/fg90Q4Fu2P6sFEcHQiRgEAV6yDM9zYxiwjBMQ4Ee8U3TmJmRrbp2" +
       "UcmtQI/GtuWrSRqZp0oqK9PQjKoxzzT3kF5ii1I9CaJTeCvbdI2TX/etXNUC" +
       "WN99hvWAsF/WA4AP2kCwaKXq5gnLvY7tGwn0gcscpxhvMYAAsF73zGQdnA51" +
       "r6+CCujRw9y5qm/BsySyfQuQ3hekYJQEeuKOnZa6DlXdUS3zxQR6z2W68aEJ" +
       "UD1QKaJkSaB3XSaregKz9MSlWTo3P9/lf/gzP+4P/auVzIapu6X89wOmJy8x" +
       "Tc2VGZm+bh4YH/ow+/Pqu3/rU1chCBC/6xLxgeYf/8T3PvZDT7729QPNe29D" +
       "I2gbU09e1L+gPfyH7yOf79xTinF/GMR2OfkXkFfmPz5ueSEPgee9+7THsvHo" +
       "pPG16b9cfvxXzT+7Cj1IQ9f0wE09YEeP6IEX2q4ZDUzfjNTENGjoAdM3yKqd" +
       "hq6Dd9b2zUOtsFrFZkJD97pV1bWg+g1UtAJdlCq6Dt5tfxWcvIdqsq7e8xCC" +
       "oOvggR4CzzPQ4VN9J1AIrwPPhFVd9W0/gMdRUOKPYdNPNKDbNawBq3fgOEgj" +
       "YIJwEFmwCuxgbR436HFJawGZ4J3qpiYc7yy4F3i2D1y6q8ZmKS6n+sA4oqPS" +
       "8sL/D2PmpR5uZleugCl63+UA4QLfGgauYUYv6q+kXep7X3nx96+eOsyxBhPo" +
       "I0CMo4MYR5UYR0CMo4MYR5UYR0CMozuIAV25Uo3+zlKcg3GAqXVAkADh86Hn" +
       "Z39z9NKnnrkHWGWY3QvmpSSF7xzFybOwQlfBUwe2Db32+eynpL9VvwpdvRiO" +
       "Swig6sGSfVwG0dNgeeuyG96u3xuf/M5ffPXnXw7OHPJCfD+OE6/nLP38mcvK" +
       "jgLdNEDkPOv+w0+pv/nib7186yp0LwgeIGAmKlAbiEVPXh7jgr+/cBI7Syz3" +
       "AcCrIPJUt2w6CXgPJusoyM5qKit4uHp/BOj4R6Dj4oJHlK2PhWX5zoPVlJN2" +
       "CUUVmz8yC3/5j/7gv2CVuk/C+I1zC+PMTF44FzrKzm5UQeKRMxsQI9MEdP/x" +
       "8+Of+9x3P/k3KgMAFM/ebsBbZUmCkAGmEKj5b399++++/a0vfPPqmdEkYO1M" +
       "NdfW8wPIvwSfK+D5v+VTgisrDm7/KHkce546DT5hOfIHz2QDYcgFblla0K25" +
       "7wWGvbJVzTVLi/3fN55DfvO/febmwSZcUHNiUj/0xh2c1f+1LvTx3/+x//Fk" +
       "1c0VvVwGz/R3RnaIrY+d9UxEkbov5ch/6l+9/xe/pv4yiNIgMsZ2YVbBDqr0" +
       "AVUTWK90UatK+FIbWhYfiM87wkVfO5euvKh/9pt//g7pz3/7e5W0F/Od8/PO" +
       "qeELB1Mri6dy0P3jl71+qMZrQIe/xv/oTfe174MeFdCjDqJdLEQgEuUXrOSY" +
       "+r7r//5f/M67X/rDe6CrfehBN1CNvlo5HPQAsHQzXoMgloc/8rGDNWf3g+Jm" +
       "BRV6HfiDgbyn+nUvEPD5O8eafpmunLnre/6X4Gqf+M//83VKqKLMbVbpS/wK" +
       "/KVfeoL86J9V/GfuXnI/mb8+OoPU7owX/VXvv1995trvXoWuK9BN/ThvlMrY" +
       "C5xIAblSfJJMgtzyQvvFvOewyL9wGs7edznUnBv2cqA5WxXAe0ldvj94Kba8" +
       "t9TyR8HzoePY8qHLseUKVL18rGJ5uipvlcWHqjm5J4EeCKMgAVKaINe7FldJ" +
       "agIkAYuLWw32PKiulp24Yn5XAtXeeIU6JHzAlg6hrSyxsiAOBtG8o/G8UA2Z" +
       "XwEx5j70qHVUL3+zdxC+fP3BsqDKon8i7uMbV791EnckkGMDs7m1cVsn8t+s" +
       "LL6coGM5Lwn5/F9ZSGDRD591xgYgx/30n3z2G3/v2W8DsxtB91XKANZ2bkQ+" +
       "LdP+n/nS597/A6/88aeroAoiqvTT33/iY2Wv8zcH9YkS6qzKX1g1Trgq9plG" +
       "hfau3jaObA8sF7vjnBZ++dFvO7/0nS8f8tXLrnWJ2PzUK3/nL48+88rVc/8S" +
       "nn1don6e5/BPoRL6HccajqCn7zZKxdH/06++/M//0cufPEj16MWclwJ/6b78" +
       "b/7PN44+/8e/d5s06l43eAsTm9y4d4jHNHHy4ebKapnNkRWWYDsjz/P6sItt" +
       "CELXu7jOG3PVQdZ7S6cJo6ULg4lLCQ2z2LU6vmIZnro0Fym2bsq2OkkSxulT" +
       "U0ZwViiZ9Wl56fmNJaur9Vkke4yNqDSs9ablmiTOEFH23F2npnkKOt4ZWOGE" +
       "o5TzOj4G7zrYLumsWllHX3pzb6KEir0dt8mB4SkDiUlr9jp2Zq1JgBTLeobs" +
       "447ssHCyW5Cpu+uF7H64oZBpjAj2yI1dbi+tO2E3jL1wv3UibsEZS2IzaPYG" +
       "y/0S7+5liW/NGD42tlNkqigOtnXcATGKA0flNoygDzC6nSHecDeh/Do6ImbS" +
       "dEK5dXkxaLLONBzVcUNvc47ZHmpj0mE8TOM5MQ03aM0iNrKKR9R0E8e+FluK" +
       "Egx2zJyt2e3Jhm3HFqpoVGJt5DxfOLbac6VOx5Ng1W3SSzaX+nOETayCL7ri" +
       "PFOWtKNtMd6TSCfVhPZmMaM8bjOmCL1Dq3rW5LNtfyrw4hoJ5mTTSxXP8TAV" +
       "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" +
       "AA==");
}
