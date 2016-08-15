package org.apache.batik.ext.awt.geom;
public class Linear implements org.apache.batik.ext.awt.geom.Segment {
    public java.awt.geom.Point2D.Double p1;
    public java.awt.geom.Point2D.Double p2;
    public Linear() { super();
                      p1 = new java.awt.geom.Point2D.Double();
                      p2 = new java.awt.geom.Point2D.Double(); }
    public Linear(double x1, double y1, double x2, double y2) { super();
                                                                p1 = new java.awt.geom.Point2D.Double(
                                                                       x1,
                                                                       y1);
                                                                p2 =
                                                                  new java.awt.geom.Point2D.Double(
                                                                    x2,
                                                                    y2);
    }
    public Linear(java.awt.geom.Point2D.Double p1, java.awt.geom.Point2D.Double p2) {
        super(
          );
        this.
          p1 =
          p1;
        this.
          p2 =
          p2;
    }
    public java.lang.Object clone() { return new org.apache.batik.ext.awt.geom.Linear(
                                        new java.awt.geom.Point2D.Double(
                                          p1.
                                            x,
                                          p1.
                                            y),
                                        new java.awt.geom.Point2D.Double(
                                          p2.
                                            x,
                                          p2.
                                            y));
    }
    public org.apache.batik.ext.awt.geom.Segment reverse() {
        return new org.apache.batik.ext.awt.geom.Linear(
          new java.awt.geom.Point2D.Double(
            p2.
              x,
            p2.
              y),
          new java.awt.geom.Point2D.Double(
            p1.
              x,
            p1.
              y));
    }
    public double minX() { if (p1.x < p2.
                                        x)
                               return p1.
                                        x;
                           return p2.x; }
    public double maxX() { if (p1.x > p2.
                                        x)
                               return p1.
                                        x;
                           return p2.x; }
    public double minY() { if (p1.y < p2.
                                        y)
                               return p1.
                                        y;
                           return p2.y; }
    public double maxY() { if (p1.y > p2.
                                        y)
                               return p2.
                                        y;
                           return p1.y; }
    public java.awt.geom.Rectangle2D getBounds2D() {
        double x;
        double y;
        double w;
        double h;
        if (p1.
              x <
              p2.
                x) {
            x =
              p1.
                x;
            w =
              p2.
                x -
                p1.
                  x;
        }
        else {
            x =
              p2.
                x;
            w =
              p1.
                x -
                p2.
                  x;
        }
        if (p1.
              y <
              p2.
                y) {
            y =
              p1.
                y;
            h =
              p2.
                y -
                p1.
                  y;
        }
        else {
            y =
              p2.
                y;
            h =
              p1.
                y -
                p2.
                  y;
        }
        return new java.awt.geom.Rectangle2D.Double(
          x,
          y,
          w,
          h);
    }
    public java.awt.geom.Point2D.Double evalDt(double t) {
        double x =
          p2.
            x -
          p1.
            x;
        double y =
          p2.
            y -
          p1.
            y;
        return new java.awt.geom.Point2D.Double(
          x,
          y);
    }
    public java.awt.geom.Point2D.Double eval(double t) {
        double x =
          p1.
            x +
          t *
          (p2.
             x -
             p1.
               x);
        double y =
          p1.
            y +
          t *
          (p2.
             y -
             p1.
               y);
        return new java.awt.geom.Point2D.Double(
          x,
          y);
    }
    public org.apache.batik.ext.awt.geom.Segment.SplitResults split(double y) {
        if (y ==
              p1.
                y ||
              y ==
              p2.
                y)
            return null;
        if (y <=
              p1.
                y &&
              y <=
              p2.
                y)
            return null;
        if (y >=
              p1.
                y &&
              y >=
              p2.
                y)
            return null;
        double t =
          (y -
             p1.
               y) /
          (p2.
             y -
             p1.
               y);
        org.apache.batik.ext.awt.geom.Segment[] t0 =
          { getSegment(
              0,
              t) };
        org.apache.batik.ext.awt.geom.Segment[] t1 =
          { getSegment(
              t,
              1) };
        if (p2.
              y <
              y)
            return new org.apache.batik.ext.awt.geom.Segment.SplitResults(
              t0,
              t1);
        return new org.apache.batik.ext.awt.geom.Segment.SplitResults(
          t1,
          t0);
    }
    public org.apache.batik.ext.awt.geom.Segment getSegment(double t0,
                                                            double t1) {
        java.awt.geom.Point2D.Double np1 =
          eval(
            t0);
        java.awt.geom.Point2D.Double np2 =
          eval(
            t1);
        return new org.apache.batik.ext.awt.geom.Linear(
          np1,
          np2);
    }
    public org.apache.batik.ext.awt.geom.Segment splitBefore(double t) {
        return new org.apache.batik.ext.awt.geom.Linear(
          p1,
          eval(
            t));
    }
    public org.apache.batik.ext.awt.geom.Segment splitAfter(double t) {
        return new org.apache.batik.ext.awt.geom.Linear(
          eval(
            t),
          p2);
    }
    public void subdivide(org.apache.batik.ext.awt.geom.Segment s0,
                          org.apache.batik.ext.awt.geom.Segment s1) {
        org.apache.batik.ext.awt.geom.Linear l0 =
          null;
        org.apache.batik.ext.awt.geom.Linear l1 =
          null;
        if (s0 instanceof org.apache.batik.ext.awt.geom.Linear)
            l0 =
              (org.apache.batik.ext.awt.geom.Linear)
                s0;
        if (s1 instanceof org.apache.batik.ext.awt.geom.Linear)
            l1 =
              (org.apache.batik.ext.awt.geom.Linear)
                s1;
        subdivide(
          l0,
          l1);
    }
    public void subdivide(double t, org.apache.batik.ext.awt.geom.Segment s0,
                          org.apache.batik.ext.awt.geom.Segment s1) {
        org.apache.batik.ext.awt.geom.Linear l0 =
          null;
        org.apache.batik.ext.awt.geom.Linear l1 =
          null;
        if (s0 instanceof org.apache.batik.ext.awt.geom.Linear)
            l0 =
              (org.apache.batik.ext.awt.geom.Linear)
                s0;
        if (s1 instanceof org.apache.batik.ext.awt.geom.Linear)
            l1 =
              (org.apache.batik.ext.awt.geom.Linear)
                s1;
        subdivide(
          t,
          l0,
          l1);
    }
    public void subdivide(org.apache.batik.ext.awt.geom.Linear l0,
                          org.apache.batik.ext.awt.geom.Linear l1) {
        if (l0 ==
              null &&
              l1 ==
              null)
            return;
        double x =
          (p1.
             x +
             p2.
               x) *
          0.5;
        double y =
          (p1.
             y +
             p2.
               y) *
          0.5;
        if (l0 !=
              null) {
            l0.
              p1.
              x =
              p1.
                x;
            l0.
              p1.
              y =
              p1.
                y;
            l0.
              p2.
              x =
              x;
            l0.
              p2.
              y =
              y;
        }
        if (l1 !=
              null) {
            l1.
              p1.
              x =
              x;
            l1.
              p1.
              y =
              y;
            l1.
              p2.
              x =
              p2.
                x;
            l1.
              p2.
              y =
              p2.
                y;
        }
    }
    public void subdivide(double t, org.apache.batik.ext.awt.geom.Linear l0,
                          org.apache.batik.ext.awt.geom.Linear l1) {
        if (l0 ==
              null &&
              l1 ==
              null)
            return;
        double x =
          p1.
            x +
          t *
          (p2.
             x -
             p1.
               x);
        double y =
          p1.
            y +
          t *
          (p2.
             y -
             p1.
               y);
        if (l0 !=
              null) {
            l0.
              p1.
              x =
              p1.
                x;
            l0.
              p1.
              y =
              p1.
                y;
            l0.
              p2.
              x =
              x;
            l0.
              p2.
              y =
              y;
        }
        if (l1 !=
              null) {
            l1.
              p1.
              x =
              x;
            l1.
              p1.
              y =
              y;
            l1.
              p2.
              x =
              p2.
                x;
            l1.
              p2.
              y =
              p2.
                y;
        }
    }
    public double getLength() { double dx =
                                  p2.
                                    x -
                                  p1.
                                    x;
                                double dy =
                                  p2.
                                    y -
                                  p1.
                                    y;
                                return java.lang.Math.
                                  sqrt(
                                    dx *
                                      dx +
                                      dy *
                                      dy);
    }
    public double getLength(double maxErr) {
        return getLength(
                 );
    }
    public java.lang.String toString() { return "M" +
                                         p1.
                                           x +
                                         ',' +
                                         p1.
                                           y +
                                         'L' +
                                         p2.
                                           x +
                                         ',' +
                                         p2.
                                           y;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVaD3AU1Rl/d/lLQkgIfw0kQAhYwOaAilaD1CQkknCBSDTW" +
       "o3Js9t4lC3u76+675ECoitMBOiOlFNB2lLaKVRkUplNrOxaHDrZqtZ3i32pH" +
       "7FhnaqtMZZzaVlvt973du93bu914HS8z+2Xvve97732/933f+96+d/w8KTN0" +
       "0kQV1sq2adRo7VJYv6AbNNYpC4ZxHZRFxbtKhA82vbPuiiApj5BJI4LRJwoG" +
       "7ZaoHDMipFFSDCYoIjXWURpDiX6dGlQfFZikKhEyTTJ6EposiRLrU2MUGQYF" +
       "PUwmC4zp0lCS0R6rAUYawzCSEB9JqN1d3RYmE0VV22azz3SwdzpqkDNh92Uw" +
       "UhfeIowKoSST5FBYMlhbSidLNFXeNiyrrJWmWOsWeYUFQW94RQ4EzSdrP/x4" +
       "/0gdh2CKoCgq4+oZG6ihyqM0Fia1dmmXTBPGzeTrpCRMqh3MjLSE052GoNMQ" +
       "dJrW1uaC0ddQJZnoVLk6LN1SuSbigBiZl92IJuhCwmqmn48ZWqhklu5cGLSd" +
       "m9HW1DJHxUNLQgfv2lT34xJSGyG1kjKAwxFhEAw6iQCgNDFEdaM9FqOxCJms" +
       "wGQPUF0SZGm7NdP1hjSsCCwJ05+GBQuTGtV5nzZWMI+gm54Umapn1Itzg7J+" +
       "lcVlYRh0nW7ramrYjeWgYJUEA9PjAtidJVK6VVJijMxxS2R0bFkLDCBakaBs" +
       "RM10VaoIUEDqTRORBWU4NACmpwwDa5kKBqgz0uDZKGKtCeJWYZhG0SJdfP1m" +
       "FXBN4ECgCCPT3Gy8JZilBtcsOebn/LqV+25R1ihBEoAxx6go4/irQajJJbSB" +
       "xqlOwQ9MwYmLw4eF6af2BAkB5mkuZpPn8R0Xrr6k6fQzJs+sPDzrh7ZQkUXF" +
       "o0OTzs7uXHRFCQ6jUlMNCSc/S3PuZf1WTVtKgwgzPdMiVramK09v+PWNtx2j" +
       "7wZJVQ8pF1U5mQA7miyqCU2SqX4NVaguMBrrIROoEuvk9T2kAt7DkkLN0vXx" +
       "uEFZDymVeVG5yn8DRHFoAiGqgndJiavpd01gI/w9pRFCKuAhC+FpJOYf/8/I" +
       "DaERNUFDgigokqKG+nUV9TdCEHGGANuR0BBY/daQoSZ1MMGQqg+HBLCDEWpV" +
       "oGcKYyw0TNVECEcr6K1oYFrxmk6hVlPGAgEAfLbb3WXwlDWqHKN6VDyY7Oi6" +
       "8Gj0OdOU0PwtPCBAQW+tZm+tvDceHKG3Vuyt1eyNBAK8k6nYqzmjULEVPBtC" +
       "68RFAzf1bt7TXAKmpI2VApglwNqctcR02u6fjtlR8UR9zfZ555adCZLSMKkX" +
       "RJYUZFwx2vVhiEXiVstdJw7B4mOvAXMdawAuXroq0hiEIK+1wGqlUh2lOpYz" +
       "MtXRQnqFQl8Mea8PecdPTt89dvvgrUuDJJgd9rHLMohYKN6PwToTlFvc7p6v" +
       "3drd73x44vBO1Xb8rHUkvfzlSKIOzW4zcMMTFRfPFR6LntrZwmGfAIGZCTDJ" +
       "EPOa3H1kxZW2dIxGXSpB4biqJwQZq9IYV7ERXR2zS7h9TubvU8EsqtHRJsMz" +
       "1/I8/h9rp2tIZ5j2jHbm0oKvAVcNaPf+4Xd//RKHO71c1DrW+QHK2hwhChur" +
       "58Fosm221+mUAt8bd/d/59D53Ru5zQLH/HwdtiDthNAEUwgwf+OZm19789zR" +
       "l4IZOw8wWKOTQ5DqpDJKYjmp8lESeltojwdCnAyxAK2m5XoF7FOKS8KQTNGx" +
       "/lO7YNlj7+2rM+1AhpK0GV0yfgN2+UUd5LbnNv2ziTcTEHGJtTGz2cy4PcVu" +
       "uV3XhW04jtTtLzR+92nhXlgBIOoa0nbKAynhGBA+aSu4/ks5vdRVdzmSBYbT" +
       "+LP9y5EKRcX9L71fM/j+kxf4aLNzKedc9wlam2leSBamoPkZ7uC0RjBGgO/S" +
       "0+u+Vief/hhajECLIoRYY70OcTGVZRkWd1nF6788M33z2RIS7CZVsirEugXu" +
       "ZGQCWDc1RiCkprSvXG1O7lglkDquKslRPqcAAZ6Tf+q6EhrjYG//2YyfrHzw" +
       "yDluZRpvojHXgxZYxrUgvwchvRjJkly79BJ1zWApH3NpdiTHaDmQHDIg6koJ" +
       "cLJRK+NY3r9Z3NPS/7aZTVyUR8Dkm/ZQ6M7BV7c8z124EuM6lmOXNY6oDfHf" +
       "ET/qTBU+hb8APJ/gg0PHAnPlru+00oe5mfxB09AiFvkk/NkKhHbWv7n1nnce" +
       "MRVw51cuZrrn4Dc/bd130PRLMwmdn5MHOmXMRNRUB8laHN08v164RPdfTux8" +
       "4qGdu81R1WenVF2wY3jklf8+33r3n57Ns66Xx1SITDQznwEzYmFwzZ4eU6fV" +
       "e2t/sb++pBsWhR5SmVSkm5O0J+ZsFNJoIznkmC87v+UFTu1wbhgJLIZpwIJe" +
       "m/Df1/hEiwiSDl71ZSSdphu1/Z8ehwXtnm60xPKFJYW7kZeoS7UgH0iQ/57J" +
       "yGzu/Znsql+FTc3y1S2r+VwhD+Vdx3wA4qls1AZo8+cBkFkxyxosZJNZ2Rvf" +
       "+dsJxLEXL3/5wW8fHjPN0sfJXHIzP1ovD+166185oZ3nS3n8ziUfCR2/p6Fz" +
       "1btc3k5cULollZsBQ/Jnyy4/lvhHsLn8V0FSESF1orXTHhTkJKYDEdhdGunt" +
       "N+zGs+qzd4rmtqgtk5jNdju+o1t3yuR0plKW5TiuLGkePE2WhTW5jTNA+Avz" +
       "tU8vaUaC2jJuabaNcztKjmdHSuFDvAXJKHa5PF+XO3y6TOXTjv+VE9feze19" +
       "s6xQZ/ncAv8dzgAdToC1Y0Ru9NqM82h8dNfBI7H1DywLWo64gUFKoGpflOko" +
       "lR0dT8WWsvynj39+sI3xjUkH/vzzluGOQjY+WNY0ztYGf88BT1js7ZLuoTy9" +
       "628N160a2VzAHmaOCyV3kw/3HX/2moXigSD/1mJ6Sc43mmyhtmzfqNIpS+pK" +
       "9tIyP2MF9TjpM+BZalnB0sLDt5eoT+A94FN3EMmdjJSJsqrQtOXV8WiPYaPV" +
       "DBu26e/73Ja1vRnlpmBdAzwrLOVWFI6Ll6iP7j/0qbsfyT2MVOjgJLrBp/MO" +
       "G4V7i4ACt47p8FxpqXJl4Sh4ifpo+qhP3UkkDzNSmpCUr+J7rw3BsWJCsMrS" +
       "Y1XhEHiJ+qj5hE/dKSQ/RQiElBuCx4sJQYelR0fhEHiJ+qj5jE/db5CcMa3g" +
       "RhcETxUTgm5Lj+7CIfAS9VHzZZ+6V5H83rQCNwRniwABLhKkGZ5eS4/ewiHw" +
       "EvVR8y2fureRvMFI9TBlHWpSiRnLV6fXi4uydwcbYMWAtUOmFgeH6VwRYMI1" +
       "g3+nili6RgqHyUvUBYW1DeVzz1u94IPVB0jeg70sHRXk1fzrF7WROF8sJDCb" +
       "jVrqRAtHwkt0PCQ+8UYiwNv5NzgOIuHC4aMi4IDGwL8QUUsZWjgOXqLj4BCo" +
       "9sGhBkk55FmGJkss7TfLP1OG3zKAMhuokZSZkYEvUFGsTAz3JmMWBmOFw+cl" +
       "6kLH+sDA4bMxbPDBcDaSaYxUQQSyoEE2Oy0LTC8WJOhZOyy9dhQOiZfoeBZ1" +
       "sQ8ai5A0QzzmFtVB46ruylID84tpIbdaOt1aOBxeouPBcakPHJchCYFxcDja" +
       "48z8vuJAY2kR0OAfFJbBs9dSaW/haHiJevvLHZxwtdt9IOlEspLh986hmDQq" +
       "xczY24dkranhtRCZR1UpZqN0VbFQaoPnkKXqocJR8hJ16V9inuNmoooDqmt9" +
       "oBpAEnZChQVdNix9xYIlBM99lm73FQ6Ll2h+40mvO5/p7BzVjnJ0NvkgN4Tk" +
       "Rh/kIsVC7gp4TlnqnyocOS9Rf4MKRG1YEj6w4B2OwIgPLFKxNk6z4Dlr6Xa2" +
       "cFi8RH103e5TtwNJEnCANTtMlWHzQou9ewqMFhOHVyxlXikcBy/R8dao3T5g" +
       "7EWyyweMO4oFBm4PXrc0er1wMLxEfXQ96FN3GMm3GKlkqnl/LR2XHN8dHRUc" +
       "mv2fy2kRbMnM4IYn2jNzLhqal+PER4/UVs44cv2r/DN35gLbxDCpjCdl2XkW" +
       "4ngv13QalziYE82TEX6GGPgBI42+4RaWYPyHYw5835S5n5GZXjKMlAB1cv+I" +
       "kan5uIETqJPzYYDYzQl7Ev7fyXcc8iibD0AzX5wsJ6B1YMHXk1qe+TO/G6fM" +
       "w4xZznnhe79p401nRsR5xwUh4JdI01/wk+Y10qh44kjvulsuXPaAecdGlIXt" +
       "27GV6jCpMK/78EbxFGCeZ2vptsrXLPp40skJC9LnJZPNAdtuMsu2ZdIO3q+h" +
       "NTW4LqAYLZl7KK8dXfnkb/eUvxAkgY0kIDAyZWPuwVxKS+qkcWM495B7UND5" +
       "zZi2Rd/btuqS+N//yK9YEPNQfLY3f1R86cGbXjww82hTkFT3kDJJidEUPzFc" +
       "vU3ZQMVRPUJqJKMrBUOEViRBzjpBn4SGL6AXclwsOGsypXhDi5Hm3PsDuffa" +
       "qmR1jOr8qxE2UxMm1XaJOTOug5SkprkE7BJrKpEOIlmbwtkAe4yG+zQtfb1i" +
       "whc07vU35IvVN3AbPsNf8e2p/wFSWgywYC4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "0Q/B6W8QuHvOAHc5J3eDRT4KHCs+clv0");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("B8rmrgh5G16PEieOjnVycOlW04A830wPdZKej04OD3EUOtkr5pEzFPNYTh6M" +
       "S5fArD7Em7Ptc4KDh24VZ+7YHzrE+aE3yPY/cgbEp3PyThC4CtsTuuGHp/Ke" +
       "gyvnYcsPH2L88BuEETsDYy0nMDBjgRE34t2BlRMQy7cAsTicgYDrZw4h/sy5" +
       "u+vzBSmwvP8MnLlXHzwT50fT55q1trRdwn76hMHat7Q99PfeKvRnwPXiIfQX" +
       "zwf6bftHXuIUfu4M/KOc0Cfx5wX7Vfagf6tYYXB9/hDr58/dzJcLUkD58TNg" +
       "/mROpDNgTm4VZhNcXz6E+eU3xqQnsC7OwGrlZH4GVvVWk+EfBtfXDrF+7Xyw" +
       "ngQQnVGX5MQD4MDywujeYvcdwz4jPvDPA9zXD8F9/XzA3RB5P3wGwo/mJDsD" +
       "4QdvFWGeHX7jEOE3zt98nzqj7u/l5ONx6a7Y3x9SW++xfeJ1HekEqfPua4z8" +
       "aPlDN3zdtfsiSf3iS/fe9eBL4z8qPkg4/mrobqZ0l5E4zsmzjSfuLwahblgF" +
       "1rt3Jx2DAsALcenRM5M8sFjk/3JhD3521+bn4tJDr9UmLt0G6EnuX4hLb7sZ" +
       "N+AE9CTn5+LS5dOcICMt/p/k+yWwjO/5gNJ2NydZ/iHoHbDkt18oHOHzm90W" +
       "5UMn/ahI3e//fiY6bnLyu4ccbvGV3tGuYLL7Tu+a+qWXaPaDr9Z+effdheoo" +
       "WZb3chdTunP3CUjRab6z+MRr9nbU18Xuu793z2/c/dTRLug9O4H3Pn1Ctnfc" +
       "/COHthvExWcJ2W8/+Jvv/ZWXvlkcZvz/CNTMpT45AAA=");
}
