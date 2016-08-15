package org.apache.batik.dom.svg;
public class SVGPathSupport {
    public static float getTotalLength(org.apache.batik.dom.svg.SVGOMPathElement path) {
        org.apache.batik.dom.svg.SVGPathContext pathCtx =
          (org.apache.batik.dom.svg.SVGPathContext)
            path.
            getSVGContext(
              );
        return pathCtx.
          getTotalLength(
            );
    }
    public static int getPathSegAtLength(org.apache.batik.dom.svg.SVGOMPathElement path,
                                         float x) { org.apache.batik.dom.svg.SVGPathContext pathCtx =
                                                      (org.apache.batik.dom.svg.SVGPathContext)
                                                        path.
                                                        getSVGContext(
                                                          );
                                                    return pathCtx.
                                                      getPathSegAtLength(
                                                        x);
    }
    public static org.w3c.dom.svg.SVGPoint getPointAtLength(final org.apache.batik.dom.svg.SVGOMPathElement path,
                                                            final float distance) {
        final org.apache.batik.dom.svg.SVGPathContext pathCtx =
          (org.apache.batik.dom.svg.SVGPathContext)
            path.
            getSVGContext(
              );
        if (pathCtx ==
              null)
            return null;
        return new org.w3c.dom.svg.SVGPoint(
          ) {
            public float getX() {
                java.awt.geom.Point2D pt =
                  pathCtx.
                  getPointAtLength(
                    distance);
                return (float)
                         pt.
                         getX(
                           );
            }
            public float getY() {
                java.awt.geom.Point2D pt =
                  pathCtx.
                  getPointAtLength(
                    distance);
                return (float)
                         pt.
                         getY(
                           );
            }
            public void setX(float x)
                  throws org.w3c.dom.DOMException {
                throw path.
                  createDOMException(
                    org.w3c.dom.DOMException.
                      NO_MODIFICATION_ALLOWED_ERR,
                    "readonly.point",
                    null);
            }
            public void setY(float y)
                  throws org.w3c.dom.DOMException {
                throw path.
                  createDOMException(
                    org.w3c.dom.DOMException.
                      NO_MODIFICATION_ALLOWED_ERR,
                    "readonly.point",
                    null);
            }
            public org.w3c.dom.svg.SVGPoint matrixTransform(org.w3c.dom.svg.SVGMatrix matrix) {
                throw path.
                  createDOMException(
                    org.w3c.dom.DOMException.
                      NO_MODIFICATION_ALLOWED_ERR,
                    "readonly.point",
                    null);
            }
        };
    }
    public SVGPathSupport() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVYfWwUxxUfn7Gxjb/BxuHDgDFQA7mDJrREpmnAscH0DFcM" +
       "qDEJx9ze3N3ae7vL7px9dkqbpK0grYoQNQn9iKVWREmrJERV6YfaRFSpmkRJ" +
       "KyVFTdMqpFIrlX6gBlVK/6Bt+t7M3u3HnU2pkpNubm/mzXtv3sfvvdmnrpIq" +
       "2yKdTOdhPmkyO9yv8xi1bJbs06ht74e5uPJoJf3H4St77giR6hHSmKH2kEJt" +
       "NqAyLWmPkOWqbnOqK8zew1gSd8QsZjNrnHLV0EdIm2oPZk1NVVQ+ZCQZEhyk" +
       "VpS0UM4tNZHjbNBhwMnyKGgSEZpEtgeXe6OkXjHMSZe8w0Pe51lByqwry+ak" +
       "OTpKx2kkx1UtElVt3pu3yAbT0CbTmsHDLM/Do9oWxwS7o1tKTND1bNO7109l" +
       "moUJFlJdN7g4nr2P2YY2zpJR0uTO9mssax8lnyGVUbLAQ8xJd7QgNAJCIyC0" +
       "cFqXCrRvYHou22eI4/ACp2pTQYU4WeVnYlKLZh02MaEzcKjhztnFZjjtyuJp" +
       "5SlLjnhmQ2T60cPN360kTSOkSdWHUR0FlOAgZAQMyrIJZtnbk0mWHCEtOjh7" +
       "mFkq1dQpx9OttprWKc+B+wtmwcmcySwh07UV+BHOZuUUbljF46VEQDn/qlIa" +
       "TcNZ292zyhMO4DwcsE4FxawUhbhztswbU/UkJyuCO4pn7P4EEMDW+VnGM0ZR" +
       "1DydwgRplSGiUT0dGYbQ09NAWmVAAFqcLJmVKdrapMoYTbM4RmSALiaXgKpW" +
       "GAK3cNIWJBOcwEtLAl7y+Ofqnm0n79d36SFSATonmaKh/gtgU2dg0z6WYhaD" +
       "PJAb69dHH6Htz50IEQLEbQFiSfODT1+7a2PnxZckzdIyNHsTo0zhceVcovG1" +
       "ZX09d1SiGjWmYavofN/JRZbFnJXevAkI017kiIvhwuLFfT+/54HvsL+GSN0g" +
       "qVYMLZeFOGpRjKypaszayXRmUc6Sg6SW6ck+sT5I5sNzVNWZnN2bStmMD5J5" +
       "mpiqNsR/MFEKWKCJ6uBZ1VNG4dmkPCOe8yYhZD58ST18u4j8iF9ORiIZI8si" +
       "VKG6qhuRmGXg+e0IIE4CbJuJJCDqxyK2kbMgBCOGlY5QiIMMcxaSRjZij0Mo" +
       "HdwZA4HDOdM0LIAZiDHzA+Wex7MtnKioALMvCya9Bvmyy9CSzIor07kd/dee" +
       "ib8iAwqTwLEKJ+tAYFgKDAuBYRAYBoFhv0BSUSHkLELB0rXgmDFIccDY+p7h" +
       "+3YfOdFVCTFlTswDqyJpl6/W9Lk4UADvuHK+tWFq1eXNL4TIvChppQrPUQ1L" +
       "x3YrDaCkjDl5W5+AKuQWg5WeYoBVzDIUlgQsmq0oOFxqjHFm4TwnizwcCqUK" +
       "kzIye6Eoqz+5eHbiwYOf3RQiIT/+o8gqgC7cHkPULqJzdzDvy/FtOn7l3fOP" +
       "HDNcBPAVlEIdLNmJZ+gKRkLQPHFl/Up6If7csW5h9lpAaE4ho8DJnUEZPoDp" +
       "LYA1nqUGDpwyrCzVcKlg4zqesYwJd0aEaAsObTJaMYQCCgqc/9iw+dhvfvnn" +
       "24QlCyWhyVPLhxnv9cAQMmsVgNPiRuR+izGge+ts7Ctnrh4/JMIRKFaXE9iN" +
       "Yx/AD3gHLPiFl46++fblc5dCbghzqMO5BLQzeXGWRe/BpwK+/8EvQgdOSAhp" +
       "7XNwbGURyEyUvNbVDSBNg8TH4Og+oEMYqimVJjSG+fOvpjWbL/ztZLN0twYz" +
       "hWjZeGMG7vwtO8gDrxz+Z6dgU6FgSXXt55JJnF7oct5uWXQS9cg/+Pryr75I" +
       "HwPEB5S11SkmgJMIexDhwC3CFpvEeHtg7aM4rLG9Me5PI0/rE1dOXXqn4eA7" +
       "z18T2vp7J6/fh6jZK6NIegGELSPO4ANyXG03cVycBx0WB4FqF7UzwOz2i3vu" +
       "bdYuXgexIyBWAdC191oAk3lfKDnUVfN/+9MX2o+8VklCA6ROM2hygIqEI7UQ" +
       "6czOAMLmzY/fJfWYqIGhWdiDlFioZAK9sKK8f/uzJhcemfrh4u9te2LmsghL" +
       "U/JY6mW4Vow9OGyUYYuPt+aLxhKf6jmM5edpkeWzNSaiqTr30PRMcu/jm2X7" +
       "0Oov9v3Qyz7963+/Gj77+5fL1Jpabpi3amycaR6ZlSjSVymGRM/motVbjaf/" +
       "8KPu9I6bKRI413mDMoD/V8Ah1s8O+kFVXnzoL0v235k5chN4vyJgziDLbw89" +
       "9fLOtcrpkGhQJdSXNLb+Tb1ew4JQi0EnruMxcaZBZMvqYgB0oGPXwnedEwDr" +
       "gtkigblsNIVENAES2uKO4IaVCJeWObgGcKLCaQvwfwcnPXO1HXuHsPHAqxXE" +
       "hdDuU3Ogzr04fJKTxjTj+8EfGtT2NM/4GxCMl+FcwoZmQc1CARl3OuYPx44o" +
       "J7pjf5ThfEuZDZKu7cnIlw++MfqqcHwNRlrR3J4og4j0lL1mHMKYUj1z3D/9" +
       "+kSOtb499o0rT0t9gu1+gJidmP7ie+GT0zLV5J1odcm1xLtH3osC2q2aS4rY" +
       "MfCn88d+/OSx4yHH5IMcS7RBeYl7obr7bSg1vfvhpp+caq0cgBQeJDU5XT2a" +
       "Y4NJfxjPt3MJj1HdS5Qb1I7OWHehIV1fAMStOOyTz9v+TyzGiR2mmB8qBnk7" +
       "rn0IvpucIN9006mDw4EyaTMbx0Cgh1xW9+BwREgcnyMdxABg2wrpIPp3lt7O" +
       "nZTApcOO3/GHep6hK65U9RKP4t9Rj5mPfgBmXoprG+C71THK1vfNzLNx/J/M" +
       "/PAcZv4SDp/jpBnNbIDhfEYGhOtAhJu4TfHdp4yChYUtP/9+2DIPyOe/qmFf" +
       "0VHyDki+t1CemWmqWTxz4A1RTIvvFuoB1FI5TfOkozc1q02LpVRx7nrZi5ni" +
       "54xzzHJADuEEo9B6WlKfhXtXOWqghNFL+XWwa5ASIEf8eulmOKlz6aBKyQcv" +
       "yTeBO5Dg47fMgm+aRdeF73/C8mVHvqK0sxIuaruRizyN02ofyot3dQUgzMm3" +
       "dXDhndm95/5rH3lcXnMUjU5NIZcFAH/yMlXsG1bNyq3Aq3pXz/XGZ2vXFFDZ" +
       "d83y6iYCBXJZXEmWBPp+u7vY/r95btvzvzhR/TrUk0OkgnKy8JDnTZm0FFwe" +
       "ctCwHYqWwjz0WOJC0tvztck7N6b+/jvRtDplYdns9HHl0hP3/ep0xzm4uCwY" +
       "JFVQcFh+hNSp9t2T+j6mjFsjpEG1+/OgInBRqearIY0YxBTf4gm7OOZsKM7i" +
       "/ZeTrtK6WPrWABr8CWbtMHJ60qlCC9wZ30tEJzHqIOMCG9wZTyugSqBFb0A8" +
       "xqNDplm4PNb8zBSZPFoeeXG8IB5x+P5/Ab9kfUbHFwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "12BEEBMspekqw6siPmzqcxv3lABXRKMEHB0EOFiV16hqNAc6S46rs1FZnmM9" +
       "dpEs+1GFZ5clWhOrA6XE4MKU1k1mUloQvBgJQjrKGht4lGYda1h2nGZ93XRX" +
       "eOCizMaPVabXQNGaQ26xdiqPeCVBW4ZZSqYNuLkdtg3VTXktIZpGeQsyur5f" +
       "sSNccKUR4auCUEE6tO7XzG6tOm4Mu30sagyXVae/MJrOzPODDtzCSyO6CwTo" +
       "ZVwvQViER/qEKm0wkfSRpd90ewpDAp3PO6YQESYbY6MFrflY2jLn46gPVFsm" +
       "mX4q6MjaoRbohE7JlQVHpZbuTJ31dJRkGFEagi/Ahoq9ZoliqqOFsPIytbRG" +
       "y5w/GSa4G0hW1bWqWJJlNEuQcbvtNZq1qd1dmLNoBtJLw+xRHDybbuUqITLt" +
       "RV2PbUfo2llNbnbTgbpJR3pTqJIGhi94w4HloaZTeAVp1Z0JvVl30TBhYjmI" +
       "h1aW9tCyt0i9qKINxkbGOxVtRpqu5jSqSDWgK7Y6c/nxclztMZJKETSS8vYs" +
       "7IAMMl1XiHXFn2XIrCOVNzOKIiWtXklr1rzVnLHSrO1Mm30fjvHNHAkaVSXa" +
       "ZJvMHCKjYLxChZXhdtM6S7ojyUEpagvOxK0tPV9Pt8sMnQpsCwXwkbrCezUF" +
       "RpabYUT69lxzwwZN26jZryC6jyaZg8Wt7ZylJgOVMmGzJ/qNqDyClzVnSYVL" +
       "v90pAUM1GLc5XOvgXD1H50lztMAMBxcEKezyuIVI+iiIurVpP5gSzaDemioR" +
       "T7M1dG23Wo2tVEGjNpvRa0bgWx3wPkpjQ1w3KQUl6sm6B7hysH5PqWdNUepT" +
       "ng6+P3WmWU3gfhUhlMZqMVZoaksQ+dHozS/tdHp3cRA/vBgBh9J8ovMSTmW7" +
       "qUfz5onD4mPxO3uD4uOxAg2UnzQfvN59R3HK/Pi7n31OEz5R2tsvbE0j6PbI" +
       "83/a1je6farW87rrn6j54rrnqODyxXf/y/2jN5pvfQkl5YdP8Xma5Cf557/c" +
       "eY36wT3opsPyy1UXUSeRLp8supwL9CgO3NGJ0suDh5q9L9fYa8Dz5L5mn7x2" +
       "WfeaVrB3ZAU7AzhVPDyzX53fr8I8daPqv8Dn9f/8vlN3o4JacINS5CZvnAi6" +
       "y9CjEVCzzemuEZkF7PCYiU3ySpHtydGR8bk/qiRwfK1iYHmorXvzwdeCB93X" +
       "Fvr/qK29I6hiLCmgfvEGWnhP3rw9gu4BWihuT3SDiK6viZss95ge3vFj6OHV" +
       "+SAMnvq+Huo/cT188AZ6eDZvfiWCLuR68ICUJ7QALO++3PK2FfXEdZN3Qh3P" +
       "vBR1JMDyTt5Y5SX3+666Ct9d36qfee78ba96bvzXxaXN4RXr7Rx02yK27eMV" +
       "0mP9s36gL6xCvtt39VK/+POxfXGu5Uhgj0FbsPvRHfRvRtArrgUNIEF7HPK3" +
       "gP5OQwLvKf4eh/vtCDp3BBdBZ3ed4yCfBNQBSN79lH+NGuyuoJycORm1D7fi" +
       "nh+1FccC/eMnwnPxLwsHoTTe/dPCFfWzz7G9t71Y+8Tu7km15SzLqdzGQbfu" +
       "rsEOw/Gj16V2QOss/dQP7vrc7U8cfDru2jF8ZO7HeHv42pc7bcePiuuY7A9f" +
       "9ftv+J3nvlGUhP8P48JRLEsiAAA=");
}
