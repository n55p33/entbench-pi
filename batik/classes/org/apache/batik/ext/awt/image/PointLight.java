package org.apache.batik.ext.awt.image;
public class PointLight extends org.apache.batik.ext.awt.image.AbstractLight {
    private double lightX;
    private double lightY;
    private double lightZ;
    public double getLightX() { return lightX; }
    public double getLightY() { return lightY; }
    public double getLightZ() { return lightZ; }
    public PointLight(double lightX, double lightY, double lightZ, java.awt.Color lightColor) {
        super(
          lightColor);
        this.
          lightX =
          lightX;
        this.
          lightY =
          lightY;
        this.
          lightZ =
          lightZ;
    }
    public boolean isConstant() { return false; }
    public final void getLight(final double x, final double y, final double z,
                               final double[] L) { double L0 = lightX -
                                                     x;
                                                   double L1 = lightY -
                                                     y;
                                                   double L2 = lightZ -
                                                     z;
                                                   final double norm =
                                                     java.lang.Math.
                                                     sqrt(
                                                       L0 *
                                                         L0 +
                                                         L1 *
                                                         L1 +
                                                         L2 *
                                                         L2);
                                                   if (norm > 0) {
                                                       final double invNorm =
                                                         1.0 /
                                                         norm;
                                                       L0 *=
                                                         invNorm;
                                                       L1 *=
                                                         invNorm;
                                                       L2 *=
                                                         invNorm;
                                                   }
                                                   L[0] = L0;
                                                   L[1] = L1;
                                                   L[2] = L2; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVZC5AUxRnu2zuO4x7cg6fAHa8Di9cuGlCpMyochxwucMXh" +
                                                              "lSzIMTvbuzvc7Mw403u3nCE+qlKQVEIRAqiJXlUSFGIhWEbLvCSkKF+lsUrE" +
                                                              "GLXEPKwEo5SSlMbEJOb/u2d2HvugqJKt2t7Z7r//7v/v//++7p6j58koyyRt" +
                                                              "VGNhtsOgVrhLYz2SadFEpypZ1kao65fvq5T+sfXcumUhUh0jY9OStVaWLLpK" +
                                                              "oWrCipFWRbOYpMnUWkdpAnv0mNSi5qDEFF2LkQmK1Z0xVEVW2Fo9QVGgTzKj" +
                                                              "pFlizFTiWUa7bQWMtEZhJhE+k8jyYHNHlNTLurHDFZ/sEe/0tKBkxh3LYqQp" +
                                                              "ul0alCJZpqiRqGKxjpxJFhi6uiOl6ixMcyy8XV1qu2BNdGmBC2Y93vjp53vT" +
                                                              "TdwF4yRN0xk3z9pALV0dpIkoaXRru1Sase4gXyeVUVLnEWakPeoMGoFBIzCo" +
                                                              "Y60rBbNvoFo206lzc5ijqdqQcUKMzPQrMSRTythqevicQUMNs23nncHaGXlr" +
                                                              "hZUFJh5YENl/39amJypJY4w0KlovTkeGSTAYJAYOpZk4Na3liQRNxEizBovd" +
                                                              "S01FUpVhe6VbLCWlSSwLy++4BSuzBjX5mK6vYB3BNjMrM93Mm5fkAWX/G5VU" +
                                                              "pRTYOtG1VVi4CuvBwFoFJmYmJYg7u0vVgKIlGJke7JG3sf0WEICuozOUpfX8" +
                                                              "UFWaBBWkRYSIKmmpSC+EnpYC0VE6BKDJyJSSStHXhiQPSCnajxEZkOsRTSA1" +
                                                              "hjsCuzAyISjGNcEqTQmskmd9zq+7fs+d2motRCpgzgkqqzj/OujUFui0gSap" +
                                                              "SSEPRMf6+dGD0sRndocIAeEJAWEh8/TXLty0sO3kC0JmahGZ9fHtVGb98qH4" +
                                                              "2Fendc5bVonTqDF0S8HF91nOs6zHbunIGYAwE/MasTHsNJ7c8Nymux+lH4RI" +
                                                              "bTeplnU1m4E4apb1jKGo1LyZatSUGE10kzFUS3Ty9m4yGp6jikZF7fpk0qKs" +
                                                              "m1SpvKpa5//BRUlQgS6qhWdFS+rOsyGxNH/OGYSQ0fAl9fBtJeLDfxnZEknr" +
                                                              "GRqRZElTND3SY+povxUBxImDb9OROET9QMTSsyaEYEQ3UxEJ4iBN7QbMTGmI" +
                                                              "RZQMLD94A8I1qqTSADQQZcZl1p9D+8YNVVSA66cFE1+FnFmtqwlq9sv7syu6" +
                                                              "Lhzrf0kEFSaC7RlG5sGQYTFkmA/JYRKGDPMhw+6QpKKCjzQehxYLDMszAIkO" +
                                                              "SFs/r/f2Ndt2z6qEyDKGqsC3KDrLxzidLho4EN4vH29pGJ559qpTIVIVJS2S" +
                                                              "zLKSigSy3EwBNMkDdvbWx4GLXEqY4aEE5DJTl2kCEKkUNdhaavRBamI9I+M9" +
                                                              "GhzCwtSMlKaLovMnJ+8fuqfvrsUhEvKzAA45CgAMu/cgducxuj2Y/cX0Nu46" +
                                                              "9+nxgzt1Fwd8tOKwYUFPtGFWMBaC7umX58+Qnup/Zmc7d/sYwGkmQV4BBLYF" +
                                                              "x/DBTIcD2WhLDRic1M2MpGKT4+Naljb1IbeGB2kzfx4PYVGHeTcBvtfZich/" +
                                                              "sXWigeUkEdQYZwErOCV8tdd46PevvP8V7m6HPRo9tN9LWYcHsVBZC8emZjds" +
                                                              "N5qUgtw79/d878D5XZt5zILE7GIDtmPZCUgFSwhu/sYLd7z57tlDZ0JunDOg" +
                                                              "7Gwcdj65vJFYT2rLGAmjzXXnA4inAipg1LTfqkF8KklFiqsUE+s/jXOueurD" +
                                                              "PU0iDlSoccJo4cUVuPVXrCB3v7T1n21cTYWMjOv6zBUTMD7O1bzcNKUdOI/c" +
                                                              "PadbH3heeggIAUDYUoYpx9Uq7oMqf65jPvVm4xbkpZKBZRi0Kerqnm3y7vae" +
                                                              "9wT9XFGkg5CbcCTynb43tr/MF7kGMx/r0e4GT14DQngirEk4/wv4VMD3f/hF" +
                                                              "p2OFgPqWTptvZuQJxzByMPN5ZXaIfgMiO1veHXjw3GPCgCAhB4Tp7v3f+iK8" +
                                                              "Z79YObFrmV2wcfD2ETsXYQ4Wy3B2M8uNwnus+uvxnb88snOXmFWLn4O7YIv5" +
                                                              "2O/++3L4/j+8WAT+qxM6xK5I1SUYzXnsHu9fHmHTym82/mpvS+UqgI1uUpPV" +
                                                              "lDuytDvhVQr7Lisb96yXuyHiFV7rcG2AVubDMmDFdbzgU5nMyFgehEhEEJ66" +
                                                              "ySWW8sbF+dkSPlvC29ZgMcfywqt/OT17735575mPG/o+PnGBu8S/efeiyVrJ" +
                                                              "EOvRjMVcXI9JQfpbLVlpkFtyct2WJvXk56AxBhploHNrvQn0m/Nhjy09avRb" +
                                                              "vzk1cdurlSS0itSqupRYJXEYJ2MAP6mVBubOGTfeJOBjqAaKJm4qKTC+oAJT" +
                                                              "eHpxcOjKGIyn8/DPJj15/eGRsxzHDKFjKu9fiZsJH2/zI6BLHY++du3rh797" +
                                                              "cEiEW5nkCfSb/O/1avzeP31W4HLOlEXyKdA/Fjn64JTOGz7g/V3Kwt7tucIN" +
                                                              "ENC+2/fqRzOfhGZVPxsio2OkSbaPXH2SmkUiiMExw3LOYXAs87X7jwxif9yR" +
                                                              "p+RpwYT2DBskS2+SVDFfQrj8iHtUMh++M23qmBnkxwrCH7bwLlfycj4Wixw6" +
                                                              "Gm2YChzLaYCP6sooBSBQcY93Wz4Px/HOt2Bxu1C0rmQ09l367LntW51hNxUb" +
                                                              "NnkZht3uGzZWbNiBMsOKpiuxWJAfnH+qSeBo4SV7N7kIIkhrqdMfR/ND9+4f" +
                                                              "Sax/+KqQjWs3MYAE3Vik0kGqelThjU6rL0/X8vOuG/TvjN3355+3p1ZcytYa" +
                                                              "69ousnnG/9Mh4+aXTv3gVJ6/929TNt6Q3nYJu+TpAS8FVf5k7dEXb54r7wvx" +
                                                              "w73IxoJLAX+nDn8O1pqUZU3NT02z8+vagus1Fb5z7XWdGwwqN3ICIZHf/5Xq" +
                                                              "WobH7irTdg8WwxAQKSrOZLe5lMmD986L5Ux54sCKjQavHyz0wyLbmEWX7odS" +
                                                              "XcvY+u0ybXuw2OXxw6aAH3ZfTj8ssY1Zcul+KNW1jK0PlGn7ARb7PX6IBfxw" +
                                                              "4DL4YRy2IcZ12sZ0XrofSnUtY+sjZdqOYPFD5qVxLncNFsuEYR2e5xuBJOO6" +
                                                              "rlJJC+588W9XzvXgjy6DB5uxbTF8e2w3rC/jwSDBh/AxzGBroWiSGuD4JkdZ" +
                                                              "EaUB/9knNx4wbuF/TZA/l/FjoDgCbKl77tfWj//yhNj+FTv1BS4mjxyukd/O" +
                                                              "PPeeQ2jX5qeMycSperU9Zf7LSN+XdGmWonom0pmNK7JzHXeZNCOrzynNhh7v" +
                                                              "jTwy+5W7Rmb/kZ8SahQL+BXouMiVsKfPx0ff/eB0Q+sxzuNVyNacroJ36YVX" +
                                                              "5b4bcO77RixO5FyU8J758H+fELC3S8+WC0EsnuaqluGGimopli6WaZUwL3w8" +
                                                              "Zbj5ERJ6nLOeuHDADTZshnSNSs6RFNrEdaOih/OvIaAxV3Tyg651pzzww6dT" +
                                                              "Bj1eL9P2BhanIdtknJcwo4z4W6UQwAMWPqDhvX5RRuNZLH7KSI0D8cVcXDWo" +
                                                              "KwkXs578MjArB3DqXv7imXJywbsl8T5EPjbSWDNp5NY3RIA67yzqYcuYzKqq" +
                                                              "99Tjea42TJpUuI314gwkbgHeZ6St/J00rAb/5TM/J3p9yMjkUr0gBKH0Sn8E" +
                                                              "YVVMGiSh9Er+nZGmoCSMz3+9cp+At1w5yAfx4BX5DLSDCD7+y3Cie+FFrt+X" +
                                                              "A56asHXni5Cr8B8l8gs+4WIL7jl9zPbhFH+r6AB4VrxX7JePj6xZd+eFax4W" +
                                                              "t6yyKg0Po5Y6gBRx4Zvfpc8sqc3RVb163udjHx8zx4H/ZjFhl+GmeqJ9IySG" +
                                                              "gbE2JXAFabXnbyLfPHT9id/urj4NELqZVEiAHpsLD+g5IwvHo83RwkssQFx+" +
                                                              "N9ox7/s7bliY/OhtfgVCxKXXtNLy/fKZw7e/tm/yobYQqeuGENQSNMdvDlbu" +
                                                              "0DZQedCMkQbF6srBFEELQJXvhmwspoWE7xu5X2x3NuRr8Y6ekVmF94OFbzZq" +
                                                              "VX2Imiv0rJawiaDOrXGw33fQyRpGoINb42GHlQJVBAlX9kfXGoZzfVqVNjgu" +
                                                              "dBWHMSgr6vkjPjX8HxMJRJtxIAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "yb8F9l8bh8PNw0bqqa98/2vtQJ3lWBV8363Kve9Iufd945X7z3ep+1SZfPyM" +
       "cqsLyn3iG6EceqQc+o1X7ofvUvcjZfJfzignX1Duv34dyr3pOMh7R8r1vvHK" +
       "/fhd6n6iTD6TnD25uN2W6f1qELiG4p8q/dmvQ+kK6WrgmR4pPXkdSl8+QWTz" +
       "tpofHWlWY3SaAIB7950BrjomPRxYvvTDT//6d7/09B9WJ2JX7VhUom60vs0N" +
       "mjNtvvLyq1/64huf+Gx1Gn+vqsQHBLp49ejWm0XnLgxV2jx0YqTSntDD4Fkf" +
       "Gal6J5Dzdd7vUCNbXxsIL9KUAYY8K29OjZUksvPyrhngQlQEx9dJ/n92V1mg" +
       "GYbhwTd//i5++4Uy+dkEunoclLfd6M8CWz912c+/HpfNQUyc3kQpj9Ufu+Wi" +
       "2+FylvbZl65dfdtLi989DP/xBaoHWOiqmbru2dO6M/krYWSYdqXLA4ezu7B6" +
       "/VYCPXn3CzIJdF/1rkT+4qHV7yTQY3dqlUD3gPQs9e8l0JtvRw0oQXqW8n8l" +
       "0PWLlKD/6n2W7lVgrVO6BLpyyJwl+SPAHZCU2T8Ojw+h3vsad4G6apxEinYY" +
       "hPzS+dXPycA++loDe2bB9PQ5FKiuOB4vSdLDJcfntc+9xHDf9dXWDx1uqWiu" +
       "st+XXK6CgD1cmDlZ1jx1R27HvK4Mnvnawz/2wLuPl2APHwQ+Bbgzsr3j9ldC" +
       "SC9Mqksc+59+2098y3976fer87J/AIkMt+F7KgAA");
}
