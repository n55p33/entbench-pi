package org.apache.batik.ext.awt.geom;
public class Quadradic extends org.apache.batik.ext.awt.geom.AbstractSegment {
    public java.awt.geom.Point2D.Double p1;
    public java.awt.geom.Point2D.Double p2;
    public java.awt.geom.Point2D.Double p3;
    public Quadradic() { super();
                         p1 = new java.awt.geom.Point2D.Double();
                         p2 = new java.awt.geom.Point2D.Double();
                         p3 = new java.awt.geom.Point2D.Double(); }
    public Quadradic(double x1, double y1, double x2, double y2, double x3,
                     double y3) { super();
                                  p1 = new java.awt.geom.Point2D.Double(x1,
                                                                        y1);
                                  p2 = new java.awt.geom.Point2D.Double(x2,
                                                                        y2);
                                  p3 = new java.awt.geom.Point2D.Double(x3,
                                                                        y3);
    }
    public Quadradic(java.awt.geom.Point2D.Double p1, java.awt.geom.Point2D.Double p2,
                     java.awt.geom.Point2D.Double p3) { super();
                                                        this.p1 =
                                                          p1;
                                                        this.p2 =
                                                          p2;
                                                        this.p3 =
                                                          p3; }
    public java.lang.Object clone() { return new org.apache.batik.ext.awt.geom.Quadradic(
                                        new java.awt.geom.Point2D.Double(
                                          p1.
                                            x,
                                          p1.
                                            y),
                                        new java.awt.geom.Point2D.Double(
                                          p2.
                                            x,
                                          p2.
                                            y),
                                        new java.awt.geom.Point2D.Double(
                                          p3.
                                            x,
                                          p3.
                                            y)); }
    public org.apache.batik.ext.awt.geom.Segment reverse() {
        return new org.apache.batik.ext.awt.geom.Quadradic(
          new java.awt.geom.Point2D.Double(
            p3.
              x,
            p3.
              y),
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
    private void getMinMax(double p1, double p2, double p3,
                           double[] minMax) { if (p3 > p1) {
                                                  minMax[0] =
                                                    p1;
                                                  minMax[1] =
                                                    p3;
                                              }
                                              else {
                                                  minMax[0] =
                                                    p3;
                                                  minMax[1] =
                                                    p1;
                                              }
                                              double a = p1 -
                                                2 *
                                                p2 +
                                                p3;
                                              double b = p2 -
                                                p1;
                                              if (a == 0)
                                                  return;
                                              double tv =
                                                b /
                                                a;
                                              if (tv <= 0 ||
                                                    tv >=
                                                    1) return;
                                              tv = ((p1 -
                                                       2 *
                                                       p2 +
                                                       p3) *
                                                      tv +
                                                      2 *
                                                      (p2 -
                                                         p1)) *
                                                     tv +
                                                     p1;
                                              if (tv < minMax[0])
                                                  minMax[0] =
                                                    tv;
                                              else
                                                  if (tv >
                                                        minMax[1])
                                                      minMax[1] =
                                                        tv;
    }
    public double minX() { double[] minMax = { 0, 0 };
                           getMinMax(p1.x, p2.x, p3.x, minMax);
                           return minMax[0]; }
    public double maxX() { double[] minMax = { 0, 0 };
                           getMinMax(p1.x, p2.x, p3.x, minMax);
                           return minMax[1]; }
    public double minY() { double[] minMax = { 0, 0 };
                           getMinMax(p1.y, p2.y, p3.y, minMax);
                           return minMax[0]; }
    public double maxY() { double[] minMax = { 0, 0 };
                           getMinMax(p1.y, p2.y, p3.y, minMax);
                           return minMax[1]; }
    public java.awt.geom.Rectangle2D getBounds2D() { double[] minMaxX =
                                                       { 0,
                                                     0 };
                                                     getMinMax(
                                                       p1.
                                                         x,
                                                       p2.
                                                         x,
                                                       p3.
                                                         x,
                                                       minMaxX);
                                                     double[] minMaxY =
                                                       { 0,
                                                     0 };
                                                     getMinMax(
                                                       p1.
                                                         y,
                                                       p2.
                                                         y,
                                                       p3.
                                                         y,
                                                       minMaxY);
                                                     return new java.awt.geom.Rectangle2D.Double(
                                                       minMaxX[0],
                                                       minMaxY[0],
                                                       minMaxX[1] -
                                                         minMaxX[0],
                                                       minMaxY[1] -
                                                         minMaxY[0]);
    }
    protected int findRoots(double y, double[] roots) {
        double[] eqn =
          { p1.
              y -
          y,
        2 *
          (p2.
             y -
             p1.
               y),
        p1.
          y -
          2 *
          p2.
            y +
          p3.
            y };
        return java.awt.geom.QuadCurve2D.
          solveQuadratic(
            eqn,
            roots);
    }
    public java.awt.geom.Point2D.Double evalDt(double t) {
        double x =
          2 *
          (p1.
             x -
             2 *
             p2.
               x +
             p3.
               x) *
          t +
          2 *
          (p2.
             x -
             p1.
               x);
        double y =
          2 *
          (p1.
             y -
             2 *
             p2.
               y +
             p3.
               y) *
          t +
          2 *
          (p2.
             y -
             p1.
               y);
        return new java.awt.geom.Point2D.Double(
          x,
          y);
    }
    public java.awt.geom.Point2D.Double eval(double t) {
        double x =
          ((p1.
              x -
              2 *
              p2.
                x +
              p3.
                x) *
             t +
             2 *
             (p2.
                x -
                p1.
                  x)) *
          t +
          p1.
            x;
        double y =
          ((p1.
              y -
              2 *
              p2.
                y +
              p3.
                y) *
             t +
             2 *
             (p2.
                y -
                p1.
                  y)) *
          t +
          p1.
            y;
        return new java.awt.geom.Point2D.Double(
          x,
          y);
    }
    public org.apache.batik.ext.awt.geom.Segment getSegment(double t0,
                                                            double t1) {
        double dt =
          t1 -
          t0;
        java.awt.geom.Point2D.Double np1 =
          eval(
            t0);
        java.awt.geom.Point2D.Double dp1 =
          evalDt(
            t0);
        java.awt.geom.Point2D.Double np2 =
          new java.awt.geom.Point2D.Double(
          np1.
            x +
            0.5 *
            dt *
            dp1.
              x,
          np1.
            y +
            0.5 *
            dt *
            dp1.
              y);
        java.awt.geom.Point2D.Double np3 =
          eval(
            t1);
        return new org.apache.batik.ext.awt.geom.Quadradic(
          np1,
          np2,
          np3);
    }
    public void subdivide(org.apache.batik.ext.awt.geom.Quadradic q0,
                          org.apache.batik.ext.awt.geom.Quadradic q1) {
        if (q0 ==
              null &&
              q1 ==
              null)
            return;
        double x =
          (p1.
             x -
             2 *
             p2.
               x +
             p3.
               x) *
          0.25 +
          (p2.
             x -
             p1.
               x) +
          p1.
            x;
        double y =
          (p1.
             y -
             2 *
             p2.
               y +
             p3.
               y) *
          0.25 +
          (p2.
             y -
             p1.
               y) +
          p1.
            y;
        double dx =
          (p1.
             x -
             2 *
             p2.
               x +
             p3.
               x) *
          0.25 +
          (p2.
             x -
             p1.
               x) *
          0.5;
        double dy =
          (p1.
             y -
             2 *
             p2.
               y +
             p3.
               y) *
          0.25 +
          (p2.
             y -
             p1.
               y) *
          0.5;
        if (q0 !=
              null) {
            q0.
              p1.
              x =
              p1.
                x;
            q0.
              p1.
              y =
              p1.
                y;
            q0.
              p2.
              x =
              x -
                dx;
            q0.
              p2.
              y =
              y -
                dy;
            q0.
              p3.
              x =
              x;
            q0.
              p3.
              y =
              y;
        }
        if (q1 !=
              null) {
            q1.
              p1.
              x =
              x;
            q1.
              p1.
              y =
              y;
            q1.
              p2.
              x =
              x +
                dx;
            q1.
              p2.
              y =
              y +
                dy;
            q1.
              p3.
              x =
              p3.
                x;
            q1.
              p3.
              y =
              p3.
                y;
        }
    }
    public void subdivide(double t, org.apache.batik.ext.awt.geom.Quadradic q0,
                          org.apache.batik.ext.awt.geom.Quadradic q1) {
        java.awt.geom.Point2D.Double np =
          eval(
            t);
        java.awt.geom.Point2D.Double npd =
          evalDt(
            t);
        if (q0 !=
              null) {
            q0.
              p1.
              x =
              p1.
                x;
            q0.
              p1.
              y =
              p1.
                y;
            q0.
              p2.
              x =
              np.
                x -
                npd.
                  x *
                t *
                0.5;
            q0.
              p2.
              y =
              np.
                y -
                npd.
                  y *
                t *
                0.5;
            q0.
              p3.
              x =
              np.
                x;
            q0.
              p3.
              y =
              np.
                y;
        }
        if (q1 !=
              null) {
            q1.
              p1.
              x =
              np.
                x;
            q1.
              p1.
              y =
              np.
                y;
            q1.
              p2.
              x =
              np.
                x +
                npd.
                  x *
                (1 -
                   t) *
                0.5;
            q1.
              p2.
              y =
              np.
                y +
                npd.
                  y *
                (1 -
                   t) *
                0.5;
            q1.
              p3.
              x =
              p3.
                x;
            q1.
              p3.
              y =
              p3.
                y;
        }
    }
    public void subdivide(org.apache.batik.ext.awt.geom.Segment s0,
                          org.apache.batik.ext.awt.geom.Segment s1) {
        org.apache.batik.ext.awt.geom.Quadradic q0 =
          null;
        org.apache.batik.ext.awt.geom.Quadradic q1 =
          null;
        if (s0 instanceof org.apache.batik.ext.awt.geom.Quadradic)
            q0 =
              (org.apache.batik.ext.awt.geom.Quadradic)
                s0;
        if (s1 instanceof org.apache.batik.ext.awt.geom.Quadradic)
            q1 =
              (org.apache.batik.ext.awt.geom.Quadradic)
                s1;
        subdivide(
          q0,
          q1);
    }
    public void subdivide(double t, org.apache.batik.ext.awt.geom.Segment s0,
                          org.apache.batik.ext.awt.geom.Segment s1) {
        org.apache.batik.ext.awt.geom.Quadradic q0 =
          null;
        org.apache.batik.ext.awt.geom.Quadradic q1 =
          null;
        if (s0 instanceof org.apache.batik.ext.awt.geom.Quadradic)
            q0 =
              (org.apache.batik.ext.awt.geom.Quadradic)
                s0;
        if (s1 instanceof org.apache.batik.ext.awt.geom.Quadradic)
            q1 =
              (org.apache.batik.ext.awt.geom.Quadradic)
                s1;
        subdivide(
          t,
          q0,
          q1);
    }
    static int count = 0;
    protected double subLength(double leftLegLen,
                               double rightLegLen,
                               double maxErr) { count++;
                                                double dx;
                                                double dy;
                                                dx =
                                                  p3.
                                                    x -
                                                    p1.
                                                      x;
                                                dy =
                                                  p3.
                                                    y -
                                                    p1.
                                                      y;
                                                double cordLen =
                                                  java.lang.Math.
                                                  sqrt(
                                                    dx *
                                                      dx +
                                                      dy *
                                                      dy);
                                                double hullLen =
                                                  leftLegLen +
                                                  rightLegLen;
                                                if (hullLen <
                                                      maxErr)
                                                    return (hullLen +
                                                              cordLen) *
                                                      0.5;
                                                double err =
                                                  hullLen -
                                                  cordLen;
                                                if (err <
                                                      maxErr)
                                                    return (hullLen +
                                                              cordLen) *
                                                      0.5;
                                                org.apache.batik.ext.awt.geom.Quadradic q =
                                                  new org.apache.batik.ext.awt.geom.Quadradic(
                                                  );
                                                double x =
                                                  (p1.
                                                     x +
                                                     2 *
                                                     p2.
                                                       x +
                                                     p3.
                                                       x) *
                                                  0.25;
                                                double y =
                                                  (p1.
                                                     y +
                                                     2 *
                                                     p2.
                                                       y +
                                                     p3.
                                                       y) *
                                                  0.25;
                                                dx =
                                                  0.25 *
                                                    dx;
                                                dy =
                                                  0.25 *
                                                    dy;
                                                q.
                                                  p1.
                                                  x =
                                                  p1.
                                                    x;
                                                q.
                                                  p1.
                                                  y =
                                                  p1.
                                                    y;
                                                q.
                                                  p2.
                                                  x =
                                                  x -
                                                    dx;
                                                q.
                                                  p2.
                                                  y =
                                                  y -
                                                    dy;
                                                q.
                                                  p3.
                                                  x =
                                                  x;
                                                q.
                                                  p3.
                                                  y =
                                                  y;
                                                double midLen =
                                                  0.25 *
                                                  cordLen;
                                                double len =
                                                  q.
                                                  subLength(
                                                    leftLegLen *
                                                      0.5,
                                                    midLen,
                                                    maxErr *
                                                      0.5);
                                                q.
                                                  p1.
                                                  x =
                                                  x;
                                                q.
                                                  p1.
                                                  y =
                                                  y;
                                                q.
                                                  p2.
                                                  x =
                                                  x +
                                                    dx;
                                                q.
                                                  p2.
                                                  y =
                                                  y +
                                                    dy;
                                                q.
                                                  p3.
                                                  x =
                                                  p3.
                                                    x;
                                                q.
                                                  p3.
                                                  y =
                                                  p3.
                                                    y;
                                                len +=
                                                  q.
                                                    subLength(
                                                      midLen,
                                                      rightLegLen *
                                                        0.5,
                                                      maxErr *
                                                        0.5);
                                                return len;
    }
    public double getLength() { return getLength(
                                         1.0E-6);
    }
    public double getLength(double maxErr) {
        double dx;
        double dy;
        dx =
          p2.
            x -
            p1.
              x;
        dy =
          p2.
            y -
            p1.
              y;
        double leftLegLen =
          java.lang.Math.
          sqrt(
            dx *
              dx +
              dy *
              dy);
        dx =
          p3.
            x -
            p2.
              x;
        dy =
          p3.
            y -
            p2.
              y;
        double rightLegLen =
          java.lang.Math.
          sqrt(
            dx *
              dx +
              dy *
              dy);
        double eps =
          maxErr *
          (leftLegLen +
             rightLegLen);
        return subLength(
                 leftLegLen,
                 rightLegLen,
                 eps);
    }
    public java.lang.String toString() { return "M" +
                                         p1.
                                           x +
                                         ',' +
                                         p1.
                                           y +
                                         'Q' +
                                         p2.
                                           x +
                                         ',' +
                                         p2.
                                           y +
                                         ' ' +
                                         p3.
                                           x +
                                         ',' +
                                         p3.
                                           y;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "f8W3f/4XMm7rTG4zAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL17edDr1nUfv/ekp9XSk2RLsqLNWuJatB9AcK/ihQRAEiRA" +
       "ggQJkmhsGSsBYt+XWE2saWJNPXU9qZw4nkTTP6w08ch2mmmWGY9jdXHj1Ik7" +
       "8WRat9PGSSdp3dpu7ekk7cRt3Qvw2973vvfJb95zOINLAPfce8/v3HPOPXfB" +
       "q98u3ex7pbJjG+nGsINLchJc2hr1S0HqyP6lIVmnec+XJdTgfX8O3j0nPvFr" +
       "d//l9z6qXjxXusCV7uMtyw74QLMtfyb7thHJElm6++gtbsimH5Qukls+4qEw" +
       "0AyI1PzgWbJ0x7GiQekp8oAFCLAAARagggWoc0QFCr1BtkITzUvwVuC7pb9d" +
       "2iNLFxwxZy8oveXyShze4839augCAajh1vyZBaCKwolXevwQ+w7zFYA/VoZe" +
       "+vn3Xfz186W7udLdmsXk7IiAiQA0wpXuNGVTkD2/I0myxJXusWRZYmRP4w0t" +
       "K/jmSvf62sbig9CTD4WUvwwd2SvaPJLcnWKOzQvFwPYO4SmabEgHTzcrBr8B" +
       "WO8/wrpD2MvfA4C3a4AxT+FF+aDITbpmSUHpsZMlDjE+NQIEoOgtphyo9mFT" +
       "N1k8eFG6d9d3Bm9tICbwNGsDSG+2Q9BKUHroqpXmsnZ4Uec38nNB6cGTdPQu" +
       "C1DdVggiLxKU3nSSrKgJ9NJDJ3rpWP98e/xjH/kJa2CdK3iWZNHI+b8VFHr0" +
       "RKGZrMiebInyruCdz5A/x9//+RfPlUqA+E0niHc0v/WB777n7Y++9qUdzY+c" +
       "QjMRtrIYPCd+UrjrDx9G39Y+n7Nxq2P7Wt75lyEv1J/ez3k2cYDl3X9YY555" +
       "6SDztdm/XP/Up+RvnivdTpQuiLYRmkCP7hFt09EM2evLluzxgSwRpdtkS0KL" +
       "fKJ0C7gnNUvevZ0oii8HROkmo3h1wS6egYgUUEUuolvAvWYp9sG9wwdqcZ84" +
       "pVLpFnCV7gTXo6Xdr/gPShyk2qYM8SJvaZYN0Z6d4/ch2QoEIFsVEoDW65Bv" +
       "hx5QQcj2NhAP9ECV9zNyy+TjANrItglNQ17yeEkTL+U65vxQa09ybBfjvT0g" +
       "9odPGr0B7GVgG5LsPSe+FHbx737muS+fOzSCfakEpbeCBi/tGrxUNFg4TNDg" +
       "pbzBS4cNlvb2inbemDe861rQMTowceD87nwb897h+1984jzQKSe+CUj1PCCF" +
       "ru6D0SOnQBSuTwSaWXrt4/EH2Z+Ez5XOXe5Mc2bBq9vz4nTuAg9d3VMnjei0" +
       "eu/+0Df+8rM/97x9ZE6Xeed9K7+yZG6lT5wUq2eLsgT83lH1zzzO/8Zzn3/+" +
       "qXOlm4DpA3cX8EA9gSd59GQbl1nrsweeL8dyMwCs2J7JG3nWgbu6PVA9Oz56" +
       "U/T3XcX9PUDGd+Tq+0ZwvWVfn4v/PPc+J0/fuNOPvNNOoCg86zsZ55e+9pX/" +
       "Wi3EfeCE7z42rDFy8Owxw88ru7sw8XuOdGDuyTKg+48fp//Bx779ob9VKACg" +
       "ePK0Bp/KUxQYPOhCIOaf/pL7777+x5/8o3OHSrMXgJEvFAxNTA5B5u9Lt58B" +
       "ErT2o0f8AMdhAPPKteaphWXakqZovGDIuZb+n7ufrvzGtz5ycacHBnhzoEZv" +
       "f/0Kjt6/uVv6qS+/7389WlSzJ+YD15HMjsh23vC+o5o7nsenOR/JB7/6yC/8" +
       "Lv9LwK8CX+ZrmVy4p1Ihg1LRaVCB/5kivXQir5Inj/nHlf9y+zoWYDwnfvSP" +
       "vvMG9ju/892C28sjlON9TfHOszv1ypPHE1D9AyctfcD7KqCrvTb+8YvGa98D" +
       "NXKgRhF4LX/iAT+TXKYZ+9Q33/Lv/+k/v//9f3i+dK5Xut2weanHF0ZWug1o" +
       "t+yrwEUlzrvfs+vc+FaQXCyglq4AX7x46Er1f+u+Zrz1dPXP07fkydNXKtXV" +
       "ip4Q/4WCgwtAKG87I670NBMYSrQ/FkPP3/t1/Re/8endOHty4D5BLL/40t/9" +
       "/qWPvHTuWHTz5BUBxvEyuwingPiGHa7vg98euP5ffuV48he7Ee5edH+Yffxw" +
       "nHWcvI/fchZbRRO9//LZ5z/3K89/aAfj3ssHdxzErp/+N//39y99/E9+75Sx" +
       "5YJkA2sunrunJQX37zpD1Yd50i6ykDz5mzsdqF+XukD7fQ5du7pcregJCOf3" +
       "h8D8+U1B6eHCKA6HVNoG8SyCPYUdCmdeJEX7zBnSWObJ+Egak2uRxo72weLp" +
       "lrMVuZdH50fj24N/NTGEF/7T/77CgxTD8im6faI8B736iw+h7/pmUf5ofMxL" +
       "P5pcGbiAmcxRWeRT5l+ce+LCF8+VbuFKF8X9aRLLG2E+6nBgauAfzJ3AVOqy" +
       "/MvD/F1M++zh+P/wSeM61uzJkflIqcF9Tp3f337aYPw0uB7b15HHTqrXXqm4" +
       "4XcaVqRP5clbd2Nffvs3ikrRoHTOqRwqxsWjHhder8d//Nr5UX8wfpDT+NF+" +
       "CPzYPxg/1dP4ca6RnzeD61v7/HzrKvxEV+EHuDe/mDcf8HSzaIf7U/h3F692" +
       "zOBB6Tww+BOcxq/L6a6KPdDOzcil5iU4f/7g6bycL2STJxmgVjSLNw6YemBr" +
       "iE8deH8WTOqB4T61NZoHvuli4ZtyE7m0mwmf4BP9gfkEPuWuo8pIG0yqP/xn" +
       "H/39v//k14HhD0s3R7lRAns/1uI4zNcZfubVjz1yx0t/8uEiDgSCZf/O9x56" +
       "T17rh18XbZ789AHUh3KoTDGNInk/oIrQTZYO0Z7olJsM+zrQBve9OKj5ROfg" +
       "R7I8uuqIyWwVrCRkNRR9KwhZzLAG3Ka7FtBuN0EUwvCbo54wnRP9gYEE2mJs" +
       "OTDHWa4RiPhwguI1doR2TJQKFyMXRddMZ85oYQ+XRULd2GiPFTsLIibWvU5n" +
       "06iNOtqQEbdQdU41/SbVtJF0xEqr1mC1gqrtKtRWypACKTC9lgh1uWRMdrZt" +
       "LlNvyleR+szz9EVKDrcBmwoEMu2ZkDKYcO2J0Rs04vp4YbvlllYjRMCctiQ9" +
       "A+iQN28wRKgtFxnD9d3AnjNDfAubAb+pk1ivV4E8YkitXEY1XUIL/SXcZriJ" +
       "xmbYhiOznjmyddiuVJBOLYWTPq5ToDqkO4SkhSxWqLDhS6xhlR21Cc0XRF8Z" +
       "NUEY7aBG2Z9P/UQaUovlOEmWhNTnKHFd3roVvcdyZRiO23bE6uWUYDcSner0" +
       "JhCa/W0LEoPKFK9Jm407cyYh7S7l0Hb4CBt3dWu7bDqiszQ9PCICWOWs8axu" +
       "dg1Hy0IpcbF5fzB3+UmQxvJGcIfcRJIdcSDzMNu3iAna7dfDKbLWNdMgR0JD" +
       "7m1VlXdNHm72Yi7gELnSYz3TXW23lNCTxhVoIQ1aHC/H2+3aRQa2uI3Tzloa" +
       "E4PNeLjYON5SNxlmGEWE3IFNOYMrvYXBBoGeVZexs6l7OLzF2piWrE2Mt1Ml" +
       "gP31sN4dV6mASmCqEckdTLTLzfKowy74bg+2wqY9wlhpM2HUtdvCOlkHHzap" +
       "2nIklTUeN/pcpBv+1kWsKUwRPZe1zYTIqhzr6cZ0OnR7Gq8xY1UVsAZvYdOh" +
       "p05rfR4jUlLozpKxO62jVYaYVAYaNE/a641bGwGSUYcg6nRLIGPDHLFOZFhp" +
       "RpXVMS9JcsNEgGkyKBHXmeWCTSqtwXQ7bk/DyO5gC6dM4FOv11pHsMlD9HYy" +
       "QgcdmrIG5GAjR2EWL0VlUqXLVG1oyJu+FNRMwvWr9focIUUtoxq9esKr/sQe" +
       "WzMyFi0a5pLmct2W4DqeENSQyjyeMOTKpK7UK920UYP6zcaamy8kpzdassp8" +
       "JKDbljCSKZVhTS10ZjoyhJfTlcv3eN+hV1Idd2Wi5fXVpcHHYp+k3AZDWiMt" +
       "dSrQtt0Zd7pjAmcqrVHd7jS9TNBVXyPbFoYPid481QdOg5vRWbKChcZaHzc0" +
       "f60vJWIxX0MVE/NcobXY1LRpB2n01h03KTOtjIFTfr3G42oXoRiEwqcBE02p" +
       "xmLWU0Nd1hxkbjgj0xgyuhTNEjtlAqferTI8NUOJTjlOIbgRbchGAI8X1lix" +
       "jJUcWmlcjZpWQvXVRX1jt0hCmWjxajVfZ9tIJ2ZEQ6DECdKkJF3X8HZGzSYJ" +
       "N0eTSdZlY3FtZu1NtBRYE5IR1u6PzSVldCYuJ2K86dFLiXSSuGPJkDIq120u" +
       "EONaKG+HozSc6EtuyC2NYdJgVQ3Th1PdU9aKESqb3opYTRNTTtbYimKpFc8N" +
       "NZztajVSYrxFeY7DPocwmhOzlrsYWdvOIup1VoM5JCiUNew1mzK9rQ9tIcoG" +
       "YGq9kUa9GgYLgTCYhS0oaNurteBB3qZVhauCpEjoEM1sbOuthzW9EWBuEE8h" +
       "mq6mcWAxGwihBQTa+mOpo/bXjNyd4lHdKtMWgc4Jce71+ive6NammDTXbYfF" +
       "fL4iUNvFrB0zgktuy0qAU4TfaGNqy1xOmgQN9RBf78OahTrjwUTpeXEiY3Bb" +
       "5AKvCcWVhKpVqUYDllWuNZbmlbA/ZCV1TdXao1oFAbbfZVAriaoSmYFwgV4J" +
       "yxmSJnGGVhfrWcTMbXVGEYtOq76iVzTZR2KlGnXJMWKZeAwsfa5jE72lu5q8" +
       "1Mf6bNiYVGwpi6eNCkOg/U1FkCV3PYRGG5QwWMKdtJerbYQvaMWaBXqzg/UW" +
       "tkhlDtLsCGLLnSx1P1TC8kahqnqGz6zVUhUzA4bxVscIUzigFm13VGupYosl" +
       "yW29sRTsidGhRpGzTLf0iGC2m4GqV9dMBWrX5joEVziE4oZNY6zURQgi9Rno" +
       "B4lvt+AAa6azyaC8VDM99aLVQCJnthiT6WzANbD6SGluAtxNVRuLErrikWbC" +
       "tJNytxeFm9lMRz0BsDZG16mAU2Yz1IB7hBSLTOuqQjKDKfB2bGUkGGhNr/d5" +
       "H2248wW+mLNba2AuzXE647XueNVbMk41kTtTouVC2IJctLgtMWk3OdzB6glS" +
       "L6tdwVz0hQZhVGu0ibTWlajZGRAcQteHaiuMY6YtVjbDWTvjljU9QbQ67SAx" +
       "MbHd0QpN1/Ooshyn2VJqcpVoAhxjOBlpnU0ZFaSeEJrt5pK0ymK4IirJQAyT" +
       "NOboCiHUmjVdmS9GPa/ciTp+G2oBU17XeuvY8ZvNeaJJW35GdVJY6yxUc1UO" +
       "O94gyJbtKFSWmFxboJA+JxM4qTY9r+FCnCfFJtQbW3aVTHEY9beUMVIxZ5SJ" +
       "q1kWW56Ka5FcbSptWAiRVcr2K1wqLFNk4ImTdgRF1VYZqUL0gOvoQZNjR4MU" +
       "Z7JWos/waYjx5SaMDpGlIkCJL4d8WhE6dtDtucGEF3WTl7Rle7sgygK/mFuR" +
       "keKVilwbLyb1Gj9L8dG6C8a71Xobm85CFXmKTtmhLE1dZh72pgOlbDWRQVfX" +
       "0YEWGDLORLK9HuIK77IIr8+gbZnVZ3oLM2dzb1aT2luTNJqLoNac9GmCjCGH" +
       "Ukc0vgja7R6v0KsNN7JNqkamWR/KcMssE2bHhCERUsih167XoQW8jXUHU6ia" +
       "NYZYhW+v8O223dZniiMrziLuVNotC0lkpCFVLKuvVjI5W46noYbMrWSMkeF2" +
       "RHq1Zps14UAZOaOR5RIwkkZTOjKkKcxtpLY/CWGrD9eb42HWsMZVvT9qVoaD" +
       "MYwItVoNtZbVVr+uLAPREbazZkPnZ7WWj8SZWV5W4c5WBcwvwKCs99c6rzVJ" +
       "c+z3KzY0W0vulKVbM1KfJluj5pPSyuBQwW3R48hA18tGNCIJ0i6j9XTSTGst" +
       "NPQSZt5hLLSOi8C+l+SquVxoXQ7ru3N96nDzdmBNG5HvTMdQuK1G9azLOMGm" +
       "ZRkoDdUbqxZjtaIZ2qNqC1+j2ywelMvIDDKdrd9NmGkwXYiCgluCj9ArfkAG" +
       "g3WoSZHKJykawXZ1y2IOxS7ac7zZN6zRdp5N29mqK5X5djxWoLqBlDFmbfH0" +
       "EuOyLQ2r0LZF1nwFreGYOWh58wlUQwSR4qb1kEQ620nLHegCNLSqitgKoaFd" +
       "Xq9tuqkzPrOKEjRYuShVtQOGN0bsmFxJbcsJpQrCi15qxVY/oxstoywm9WZ9" +
       "6jMYa4bCpuyEMT0cDd2Wa0aLJaMJZXw0jAVOAk5oZQ6gVrBc4GGTHs1FtMEr" +
       "qChoQVWO+rUuYfYbgzrEjGGMmdQNh7LxYdYPSAz4eL0dVQK62xsvWuIEDjps" +
       "VsmiOPKrqxAj+t4U13xKT4w+NkRWcOqLFduFRwTtrkYzR0YhK4zTNhIMJDVC" +
       "282pVmsicdNHI28cQaLXJkAoGYhWZrlVRVoyCGTOvdhTJ43QG2KWXdsmg2p5" +
       "ZEUENJRnVRfK2qNWZq0wureIFpQvRLLYS7IaLTdwyIoiLIAFK2oBow2Ww+6Q" +
       "WHWW5a6OpHSWziuRAqnMtBXIA29AUkwziydzaDjsQjWnnelUORHgeRqMVbHe" +
       "ryRl0g76k9gor1doW1V6leqamHQmQLxmKxDGqsHyzljTJlu33W15mTrRx4sU" +
       "0+UJ1R/POXjtpzMridlKzU0WsBRmK7i8oYxx7JOBJHDNare7LlsOWmsR8jS0" +
       "x0TV6mouCwyGRqR4CHda69YayuAobixlrG8lNMPQsWyXmZ5ZtS2W7CqTZcvs" +
       "SYxgzxoRzsxQrQzjSL9ezYSJ2IpotzPQ1oINIQZRBUEdtGnyTjIPlLHcn0yn" +
       "ipGM0Lmwls2aOyDwDbykYALlra1niTjBdVJlo5VJdIGjbEjPaHya64g71qdg" +
       "+E3IHhF4ExRMLTfamF/i6zG2XDe7NZQY4tM2I/ZAk52Wrq+nbBlF+RWYiFIS" +
       "rHv0yA3Uit3q4n2NWHoTrGEImxHD6nOX0OFAdesy3NPameGgW9EvExUfZzA4" +
       "HDMmPMECWlwY+mi4XWwDt7Yl5h2WmTguBgYKCswM2iO2gjG9oLxFR6Hmw1l5" +
       "MxHJ2QRdDFIT3iyncjk2NWXVEDxCGUCbqbesdXuYOrcHlGrKTU8SkJoGu8yY" +
       "sVxEadfXsqXLC3U9SnBRXetUdbZeOEqCwcpithwOXQ7rxDVcCrZ2U9NFDYzh" +
       "/nDM9wgS7zJzBe/jc1RtTfhF3ngZ43gmzPzqRtzo8wEQQHdmtYh+d8TQOucS" +
       "krcuw2Ndbmk9rk8NiUlvwKVK129HS76qJHqHGfZsAdd4DGrEi0EFy3o4O8Rg" +
       "ipKJGkVF1VjXfTcmNg2yaindfmqzcl9BWw1tHI/o3iYRQVxJs2CcVZEepdfF" +
       "YcpPNz5Sxym11UkXmrPu+YMsdKtCo7XCcG3KN/trWhRHlapqoumYJSJ1gqYg" +
       "5lEXmwE9gTjeq6xodNi1w36/Zq+MRO2uBZ1LV6DeSl3sGLqxVssRQ7BhdVru" +
       "xzO8SWUVE51RcieZTRZKQqBpUtOD2FjXAjPrwi2X7nnoAG2lrDB1FDtMDR2b" +
       "4b1qVZXm7Y5vSTVf2xCdGkSmiwmFJAanMvS0jtnLvkWu096GJgZ6bdaJB5rO" +
       "9ocYMZsJfF+D/YEdb+BZV7JixJHj5lBINIfz3Jon+36Ta0YdpzbC/Mp81fKr" +
       "ItUpmwm0yThAO5e9ZFnZyHLbXkPLBbwaK3hZ5jO7KpW3mjPQNc+NxK1Xlttg" +
       "LuxsKDLxurKi0IakiZq3JRl8qCHTVCZobBulmtOtW1zfmc5HYI4yqIgeNEzB" +
       "zKhKdYYVKqjjPQwRsyETr8ptZdLuTPO5Ec9h0UDlqvZquZmySjWbiKN5HNJY" +
       "IOgeuh6JxsR27JnaWM0jhe5nNd/czleS5ZbnYnU8CSCTlUNlTadwWFEUsgxz" +
       "K69pwS1MCfGuOObYFR+AsNtdh/ORNbD0uTxaQQOzSwpm0FvWeb8/ExWFzQZU" +
       "uW/Hqw6YsfCk4zWQ6TAkkK6zFcZSHNG8H8iJFWwzxKChAWfVF8EMDwyCUIkt" +
       "ngnmClaIft+cB/2UqrfBNJBjKWWLxOvWIPSWojiBsMSEUrk/w6sbZI23QJDj" +
       "tdN6Q14ITtjg+gxbWfFTNAg2cFxuD8lx6Ho8nfpjY9BXZ5485fvoCLZ1x8m2" +
       "y40o20t85Tsgxuv56VDQxizbX0ZUtJBZpelW2PasBwZKihFGa3UeeiIOuIw2" +
       "ZZUX6RgVNkbbmGrNBZtKG87q1NIK3a4Hfaom+XW7v4HlXiv2emLUGNMK0VNa" +
       "y6oC1VYgsPfm/VrW6XTemS/J/fy1LRXeU6yKHh4W2hrNPOND17AamJy2T1T8" +
       "LpROHDA5tqZ8bA+mlG+/PXK1M0DF1tsnX3jpZWnySuXc/v5PLyjdFtjOOww5" +
       "ko1jVeVb4M9cfTuHKo5AHe2p/O4L/+2h");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "rG9IZj8AAA==");
}
