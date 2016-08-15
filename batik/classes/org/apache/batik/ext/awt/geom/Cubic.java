package org.apache.batik.ext.awt.geom;
public class Cubic extends org.apache.batik.ext.awt.geom.AbstractSegment {
    public java.awt.geom.Point2D.Double p1;
    public java.awt.geom.Point2D.Double p2;
    public java.awt.geom.Point2D.Double p3;
    public java.awt.geom.Point2D.Double p4;
    public Cubic() { super();
                     p1 = new java.awt.geom.Point2D.Double();
                     p2 = new java.awt.geom.Point2D.Double();
                     p3 = new java.awt.geom.Point2D.Double();
                     p4 = new java.awt.geom.Point2D.Double(); }
    public Cubic(double x1, double y1, double x2, double y2, double x3, double y3,
                 double x4,
                 double y4) { super();
                              p1 = new java.awt.geom.Point2D.Double(
                                     x1,
                                     y1);
                              p2 = new java.awt.geom.Point2D.Double(
                                     x2,
                                     y2);
                              p3 = new java.awt.geom.Point2D.Double(
                                     x3,
                                     y3);
                              p4 = new java.awt.geom.Point2D.Double(
                                     x4,
                                     y4); }
    public Cubic(java.awt.geom.Point2D.Double p1, java.awt.geom.Point2D.Double p2,
                 java.awt.geom.Point2D.Double p3,
                 java.awt.geom.Point2D.Double p4) { super(
                                                      );
                                                    this.
                                                      p1 =
                                                      p1;
                                                    this.
                                                      p2 =
                                                      p2;
                                                    this.
                                                      p3 =
                                                      p3;
                                                    this.
                                                      p4 =
                                                      p4;
    }
    public java.lang.Object clone() { return new org.apache.batik.ext.awt.geom.Cubic(
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
                                            y),
                                        new java.awt.geom.Point2D.Double(
                                          p4.
                                            x,
                                          p4.
                                            y)); }
    public org.apache.batik.ext.awt.geom.Segment reverse() {
        return new org.apache.batik.ext.awt.geom.Cubic(
          new java.awt.geom.Point2D.Double(
            p4.
              x,
            p4.
              y),
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
                           double p4,
                           double[] minMax) { if (p4 >
                                                    p1) {
                                                  minMax[0] =
                                                    p1;
                                                  minMax[1] =
                                                    p4;
                                              }
                                              else {
                                                  minMax[0] =
                                                    p4;
                                                  minMax[1] =
                                                    p1;
                                              }
                                              double c0 =
                                                3 *
                                                (p2 -
                                                   p1);
                                              double c1 =
                                                6 *
                                                (p3 -
                                                   p2);
                                              double c2 =
                                                3 *
                                                (p4 -
                                                   p3);
                                              double[] eqn =
                                                { c0,
                                              c1 -
                                                2 *
                                                c0,
                                              c2 -
                                                c1 +
                                                c0 };
                                              int roots =
                                                java.awt.geom.QuadCurve2D.
                                                solveQuadratic(
                                                  eqn);
                                              for (int r =
                                                     0;
                                                   r <
                                                     roots;
                                                   r++) {
                                                  double tv =
                                                    eqn[r];
                                                  if (tv <=
                                                        0 ||
                                                        tv >=
                                                        1)
                                                      continue;
                                                  tv =
                                                    (1 -
                                                       tv) *
                                                      (1 -
                                                         tv) *
                                                      (1 -
                                                         tv) *
                                                      p1 +
                                                      3 *
                                                      tv *
                                                      (1 -
                                                         tv) *
                                                      (1 -
                                                         tv) *
                                                      p2 +
                                                      3 *
                                                      tv *
                                                      tv *
                                                      (1 -
                                                         tv) *
                                                      p3 +
                                                      tv *
                                                      tv *
                                                      tv *
                                                      p4;
                                                  if (tv <
                                                        minMax[0])
                                                      minMax[0] =
                                                        tv;
                                                  else
                                                      if (tv >
                                                            minMax[1])
                                                          minMax[1] =
                                                            tv;
                                              } }
    public double minX() { double[] minMax = { 0,
                           0 };
                           getMinMax(p1.x, p2.x, p3.
                                                   x,
                                     p4.
                                       x,
                                     minMax);
                           return minMax[0]; }
    public double maxX() { double[] minMax = { 0,
                           0 };
                           getMinMax(p1.x, p2.x, p3.
                                                   x,
                                     p4.
                                       x,
                                     minMax);
                           return minMax[1]; }
    public double minY() { double[] minMax = { 0,
                           0 };
                           getMinMax(p1.y, p2.y, p3.
                                                   y,
                                     p4.
                                       y,
                                     minMax);
                           return minMax[0]; }
    public double maxY() { double[] minMax = { 0,
                           0 };
                           getMinMax(p1.y, p2.y, p3.
                                                   y,
                                     p4.
                                       y,
                                     minMax);
                           return minMax[1]; }
    public java.awt.geom.Rectangle2D getBounds2D() {
        double[] minMaxX =
          { 0,
        0 };
        getMinMax(
          p1.
            x,
          p2.
            x,
          p3.
            x,
          p4.
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
          p4.
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
        3 *
          (p2.
             y -
             p1.
               y),
        3 *
          (p1.
             y -
             2 *
             p2.
               y +
             p3.
               y),
        3 *
          p2.
            y -
          p1.
            y +
          p4.
            y -
          3 *
          p3.
            y };
        return java.awt.geom.CubicCurve2D.
          solveCubic(
            eqn,
            roots);
    }
    public java.awt.geom.Point2D.Double evalDt(double t) {
        double x =
          3 *
          ((p2.
              x -
              p1.
                x) *
             (1 -
                t) *
             (1 -
                t) +
             2 *
             (p3.
                x -
                p2.
                  x) *
             (1 -
                t) *
             t +
             (p4.
                x -
                p3.
                  x) *
             t *
             t);
        double y =
          3 *
          ((p2.
              y -
              p1.
                y) *
             (1 -
                t) *
             (1 -
                t) +
             2 *
             (p3.
                y -
                p2.
                  y) *
             (1 -
                t) *
             t +
             (p4.
                y -
                p3.
                  y) *
             t *
             t);
        return new java.awt.geom.Point2D.Double(
          x,
          y);
    }
    public java.awt.geom.Point2D.Double eval(double t) {
        double x =
          (1 -
             t) *
          (1 -
             t) *
          (1 -
             t) *
          p1.
            x +
          3 *
          (t *
             (1 -
                t) *
             (1 -
                t) *
             p2.
               x +
             t *
             t *
             (1 -
                t) *
             p3.
               x) +
          t *
          t *
          t *
          p4.
            x;
        double y =
          (1 -
             t) *
          (1 -
             t) *
          (1 -
             t) *
          p1.
            y +
          3 *
          (t *
             (1 -
                t) *
             (1 -
                t) *
             p2.
               y +
             t *
             t *
             (1 -
                t) *
             p3.
               y) +
          t *
          t *
          t *
          p4.
            y;
        return new java.awt.geom.Point2D.Double(
          x,
          y);
    }
    public void subdivide(org.apache.batik.ext.awt.geom.Segment s0,
                          org.apache.batik.ext.awt.geom.Segment s1) {
        org.apache.batik.ext.awt.geom.Cubic c0 =
          null;
        org.apache.batik.ext.awt.geom.Cubic c1 =
          null;
        if (s0 instanceof org.apache.batik.ext.awt.geom.Cubic)
            c0 =
              (org.apache.batik.ext.awt.geom.Cubic)
                s0;
        if (s1 instanceof org.apache.batik.ext.awt.geom.Cubic)
            c1 =
              (org.apache.batik.ext.awt.geom.Cubic)
                s1;
        subdivide(
          c0,
          c1);
    }
    public void subdivide(double t, org.apache.batik.ext.awt.geom.Segment s0,
                          org.apache.batik.ext.awt.geom.Segment s1) {
        org.apache.batik.ext.awt.geom.Cubic c0 =
          null;
        org.apache.batik.ext.awt.geom.Cubic c1 =
          null;
        if (s0 instanceof org.apache.batik.ext.awt.geom.Cubic)
            c0 =
              (org.apache.batik.ext.awt.geom.Cubic)
                s0;
        if (s1 instanceof org.apache.batik.ext.awt.geom.Cubic)
            c1 =
              (org.apache.batik.ext.awt.geom.Cubic)
                s1;
        subdivide(
          t,
          c0,
          c1);
    }
    public void subdivide(org.apache.batik.ext.awt.geom.Cubic c0,
                          org.apache.batik.ext.awt.geom.Cubic c1) {
        if (c0 ==
              null &&
              c1 ==
              null)
            return;
        double npX =
          (p1.
             x +
             3 *
             (p2.
                x +
                p3.
                  x) +
             p4.
               x) *
          0.125;
        double npY =
          (p1.
             y +
             3 *
             (p2.
                y +
                p3.
                  y) +
             p4.
               y) *
          0.125;
        double npdx =
          (p2.
             x -
             p1.
               x +
             2 *
             (p3.
                x -
                p2.
                  x) +
             (p4.
                x -
                p3.
                  x)) *
          0.125;
        double npdy =
          (p2.
             y -
             p1.
               y +
             2 *
             (p3.
                y -
                p2.
                  y) +
             (p4.
                y -
                p3.
                  y)) *
          0.125;
        if (c0 !=
              null) {
            c0.
              p1.
              x =
              p1.
                x;
            c0.
              p1.
              y =
              p1.
                y;
            c0.
              p2.
              x =
              (p2.
                 x +
                 p1.
                   x) *
                0.5;
            c0.
              p2.
              y =
              (p2.
                 y +
                 p1.
                   y) *
                0.5;
            c0.
              p3.
              x =
              npX -
                npdx;
            c0.
              p3.
              y =
              npY -
                npdy;
            c0.
              p4.
              x =
              npX;
            c0.
              p4.
              y =
              npY;
        }
        if (c1 !=
              null) {
            c1.
              p1.
              x =
              npX;
            c1.
              p1.
              y =
              npY;
            c1.
              p2.
              x =
              npX +
                npdx;
            c1.
              p2.
              y =
              npY +
                npdy;
            c1.
              p3.
              x =
              (p4.
                 x +
                 p3.
                   x) *
                0.5;
            c1.
              p3.
              y =
              (p4.
                 y +
                 p3.
                   y) *
                0.5;
            c1.
              p4.
              x =
              p4.
                x;
            c1.
              p4.
              y =
              p4.
                y;
        }
    }
    public void subdivide(double t, org.apache.batik.ext.awt.geom.Cubic c0,
                          org.apache.batik.ext.awt.geom.Cubic c1) {
        if (c0 ==
              null &&
              c1 ==
              null)
            return;
        java.awt.geom.Point2D.Double np =
          eval(
            t);
        java.awt.geom.Point2D.Double npd =
          evalDt(
            t);
        if (c0 !=
              null) {
            c0.
              p1.
              x =
              p1.
                x;
            c0.
              p1.
              y =
              p1.
                y;
            c0.
              p2.
              x =
              (p2.
                 x +
                 p1.
                   x) *
                t;
            c0.
              p2.
              y =
              (p2.
                 y +
                 p1.
                   y) *
                t;
            c0.
              p3.
              x =
              np.
                x -
                npd.
                  x *
                t /
                3;
            c0.
              p3.
              y =
              np.
                y -
                npd.
                  y *
                t /
                3;
            c0.
              p4.
              x =
              np.
                x;
            c0.
              p4.
              y =
              np.
                y;
        }
        if (c1 !=
              null) {
            c1.
              p1.
              x =
              np.
                x;
            c1.
              p1.
              y =
              np.
                y;
            c1.
              p2.
              x =
              np.
                x +
                npd.
                  x *
                (1 -
                   t) /
                3;
            c1.
              p2.
              y =
              np.
                y +
                npd.
                  y *
                (1 -
                   t) /
                3;
            c1.
              p3.
              x =
              (p4.
                 x +
                 p3.
                   x) *
                (1 -
                   t);
            c1.
              p3.
              y =
              (p4.
                 y +
                 p3.
                   y) *
                (1 -
                   t);
            c1.
              p4.
              x =
              p4.
                x;
            c1.
              p4.
              y =
              p4.
                y;
        }
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
            dt *
            dp1.
              x /
            3,
          np1.
            y +
            dt *
            dp1.
              y /
            3);
        java.awt.geom.Point2D.Double np4 =
          eval(
            t1);
        java.awt.geom.Point2D.Double dp4 =
          evalDt(
            t1);
        java.awt.geom.Point2D.Double np3 =
          new java.awt.geom.Point2D.Double(
          np4.
            x -
            dt *
            dp4.
              x /
            3,
          np4.
            y -
            dt *
            dp4.
              y /
            3);
        return new org.apache.batik.ext.awt.geom.Cubic(
          np1,
          np2,
          np3,
          np4);
    }
    private static int count = 0;
    protected double subLength(double leftLegLen,
                               double rightLegLen,
                               double maxErr) { count++;
                                                double cldx;
                                                double cldy;
                                                double cdx;
                                                double cdy;
                                                cldx =
                                                  p3.
                                                    x -
                                                    p2.
                                                      x;
                                                cldy =
                                                  p3.
                                                    y -
                                                    p2.
                                                      y;
                                                double crossLegLen =
                                                  java.lang.Math.
                                                  sqrt(
                                                    cldx *
                                                      cldx +
                                                      cldy *
                                                      cldy);
                                                cdx =
                                                  p4.
                                                    x -
                                                    p1.
                                                      x;
                                                cdy =
                                                  p4.
                                                    y -
                                                    p1.
                                                      y;
                                                double cordLen =
                                                  java.lang.Math.
                                                  sqrt(
                                                    cdx *
                                                      cdx +
                                                      cdy *
                                                      cdy);
                                                double hullLen =
                                                  leftLegLen +
                                                  rightLegLen +
                                                  crossLegLen;
                                                if (hullLen <
                                                      maxErr)
                                                    return (hullLen +
                                                              cordLen) /
                                                      2;
                                                double err =
                                                  hullLen -
                                                  cordLen;
                                                if (err <
                                                      maxErr)
                                                    return (hullLen +
                                                              cordLen) /
                                                      2;
                                                org.apache.batik.ext.awt.geom.Cubic c =
                                                  new org.apache.batik.ext.awt.geom.Cubic(
                                                  );
                                                double npX =
                                                  (p1.
                                                     x +
                                                     3 *
                                                     (p2.
                                                        x +
                                                        p3.
                                                          x) +
                                                     p4.
                                                       x) *
                                                  0.125;
                                                double npY =
                                                  (p1.
                                                     y +
                                                     3 *
                                                     (p2.
                                                        y +
                                                        p3.
                                                          y) +
                                                     p4.
                                                       y) *
                                                  0.125;
                                                double npdx =
                                                  (cldx +
                                                     cdx) *
                                                  0.125;
                                                double npdy =
                                                  (cldy +
                                                     cdy) *
                                                  0.125;
                                                c.
                                                  p1.
                                                  x =
                                                  p1.
                                                    x;
                                                c.
                                                  p1.
                                                  y =
                                                  p1.
                                                    y;
                                                c.
                                                  p2.
                                                  x =
                                                  (p2.
                                                     x +
                                                     p1.
                                                       x) *
                                                    0.5;
                                                c.
                                                  p2.
                                                  y =
                                                  (p2.
                                                     y +
                                                     p1.
                                                       y) *
                                                    0.5;
                                                c.
                                                  p3.
                                                  x =
                                                  npX -
                                                    npdx;
                                                c.
                                                  p3.
                                                  y =
                                                  npY -
                                                    npdy;
                                                c.
                                                  p4.
                                                  x =
                                                  npX;
                                                c.
                                                  p4.
                                                  y =
                                                  npY;
                                                double midLen =
                                                  java.lang.Math.
                                                  sqrt(
                                                    npdx *
                                                      npdx +
                                                      npdy *
                                                      npdy);
                                                double len =
                                                  c.
                                                  subLength(
                                                    leftLegLen /
                                                      2,
                                                    midLen,
                                                    maxErr /
                                                      2);
                                                c.
                                                  p1.
                                                  x =
                                                  npX;
                                                c.
                                                  p1.
                                                  y =
                                                  npY;
                                                c.
                                                  p2.
                                                  x =
                                                  npX +
                                                    npdx;
                                                c.
                                                  p2.
                                                  y =
                                                  npY +
                                                    npdy;
                                                c.
                                                  p3.
                                                  x =
                                                  (p4.
                                                     x +
                                                     p3.
                                                       x) *
                                                    0.5;
                                                c.
                                                  p3.
                                                  y =
                                                  (p4.
                                                     y +
                                                     p3.
                                                       y) *
                                                    0.5;
                                                c.
                                                  p4.
                                                  x =
                                                  p4.
                                                    x;
                                                c.
                                                  p4.
                                                  y =
                                                  p4.
                                                    y;
                                                len +=
                                                  c.
                                                    subLength(
                                                      midLen,
                                                      rightLegLen /
                                                        2,
                                                      maxErr /
                                                        2);
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
          p4.
            x -
            p3.
              x;
        dy =
          p4.
            y -
            p3.
              y;
        double rightLegLen =
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
        double crossLegLen =
          java.lang.Math.
          sqrt(
            dx *
              dx +
              dy *
              dy);
        double eps =
          maxErr *
          (leftLegLen +
             rightLegLen +
             crossLegLen);
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
                                         'C' +
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
                                           y +
                                         ' ' +
                                         p4.
                                           x +
                                         ',' +
                                         p4.
                                           y;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "/D/r0Hn+im9f/Q+GgDH/PjMAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL17ebAsV3nf3Cvp6UkI6UliETLakESAgdezdM8SmaWX6Znu" +
       "6enZe6Y7xo+e3qb3faa7bRlDCOC4DNgWNq7YSlKGOHFJCCeh7FSMTcqFMWXi" +
       "FBR24lTFOCGVkBAq8IdJyjhxTvfc7d13daVX75Gp6q97+nznnO93zrecrZ/7" +
       "dum2MCiVPddKNcuNLitJdNmwkMtR6inhZZpBRmIQKjJuiWE4A++uSG/4zD3f" +
       "+/7H1pf2SxeE0v2i47iRGOmuE06U0LU2isyU7jl+27EUO4xKlxhD3IhQHOkW" +
       "xOhh9BRTesWJrFHpCeZQBAiIAAERoEIECD3mApleqTixjec5RCcK/dJPlPaY" +
       "0gVPysWLSo9dXYgnBqJ9UMyoQABKuJj/5wCoInMSlB49wr7DfA3gj5ehZ37x" +
       "Ry/901tK9wile3RnmosjASEiUIlQustW7JUShKgsK7JQutdRFHmqBLpo6Vkh" +
       "t1C6L9Q1R4ziQDlqpPxl7ClBUedxy90l5diCWIrc4AieqiuWfPjvNtUSNYD1" +
       "NcdYdwjJ/D0AeKcOBAtUUVIOs9xq6o4clR45neMI4xN9wACy3m4r0do9qupW" +
       "RwQvSvft+s4SHQ2aRoHuaID1NjcGtUSlB1+00LytPVEyRU25EpUeOM032iUB" +
       "rjuKhsizRKVXn2YrSgK99OCpXjrRP99mf/gjP+b0nP1CZlmRrFz+iyDTw6cy" +
       "TRRVCRRHUnYZ73oL8wviaz734f1SCTC/+hTzjuc3f/y773rrw5//gx3PD53B" +
       "M1wZihRdkT65uvsrr8ff3L4lF+Oi54Z63vlXIS/Uf3SQ8lTiAct7zVGJeeLl" +
       "w8TPT36f/8lfV761X7qTKl2QXCu2gR7dK7m2p1tK0FUcJRAjRaZKdyiOjBfp" +
       "VOl28MzojrJ7O1TVUImo0q1W8eqCW/wHTaSCIvImuh08647qHj57YrQunhOv" +
       "VCrdDq7SXeB6pLT7FfeoxEFr11YgURId3XGhUeDm+ENIcaIVaNs1tAJab0Kh" +
       "GwdABSE30CAR6MFaOUjILVPcRpCmuDaExytdupzrl/cDKznJMV3a7u2B5n79" +
       "aWO3gJ30XEtWgivSMzHW+e6nr/zh/pHyH7RGVHocVHZ5V9nlorLCUYLKLueV" +
       "XS4qK+3tFXW8Kq90152gM0xg1sDh3fXm6bvp93z4DbcAPfK2t4KWvAWwQi/u" +
       "d/FjR0AV7k4C2lj6/Ce27+PeW9kv7V/tQHNBwas78+yj3O0dubcnThvOWeXe" +
       "86Fvfu+FX3jaPTahqzzygWVfmzO3zDecbtLAlRQZ+Lrj4t/yqPjZK597+on9" +
       "0q3A3IGLi0SgksB7PHy6jqss9KlDb5djuQ0AVt3AFq086dBF3RmtA3d7/Kbo" +
       "67uL53tBG78iV9lL4HrDgQ4X9zz1fi+nr9rpRt5pp1AU3vTtU+9X/t0f/bd6" +
       "0dyHjveeE6FsqkRPnTD2vLB7CrO+91gHZoGiAL7/8InRz3/82x/6W4UCAI7H" +
       "z6rwiZziwMhBF4Jm/jt/4P/p1//sk1/bP1KavQhEu3hl6VJyBDJ/X7rzHJCg" +
       "tjceywOchQXMKteaJ+aO7cq6qosrS8m19K/uebL62f/xkUs7PbDAm0M1eutL" +
       "F3D8/nVY6Sf/8Ef/18NFMXtSHqyO2+yYbecB7z8uGQ0CMc3lSN731Yd+6Yvi" +
       "rwBfCvxXqGdK4ZJKRRuUik6DCvxvKejlU2nVnDwSnlT+q+3rxKDiivSxr33n" +
       "ldx3fue7hbRXj0pO9vVA9J7aqVdOHk1A8a89bek9MVwDPvjz7I9csj7/fVCi" +
       "AEqUgLcKhwHwMclVmnHAfdvt//5f/d5r3vOVW0r7ZOlOyxVlUiyMrHQH0G4l" +
       "XAP3lHjvfNeuc7cXD1S6lJSuAV+8ePBa9X/TgWa86Wz1z+ljOXnyWqV6sayn" +
       "mv9iIcFF0ChvPmcsGeg2MJTNQfyFnr7v6+Yvf/P5XWw9HaxPMSsffubv/vXl" +
       "jzyzf2JE8/g1g4qTeXajmgLiK3e4/hr89sD1f/Mrx5O/2EW1+/CD0ProUWz1" +
       "vLyPHztPrKIK8r++8PS//MdPf2gH476rA3oHjFef/5P/8+XLn/jzL50RVy7I" +
       "LrDm4j92PilwvOMcpadz0i6Sajn5mzttQG5IcSoHvV+5fsV5saynINxaSHBr" +
       "8f/VUen1hXkcBdaRC0azNeIJ4qiZZsekEGJ6TpMscsIeN8nweppkx/vAy9Fr" +
       "Mh+gH4e7B/5yaK3e/5/+9zUOpYjSZ6j6qfwC9NwvP4i/41tF/uNwmed+OLl2" +
       "DAMmM8d5a79u/8X+Gy58Yb90u1C6JB3MlDjRivMgJIDZQXg4fQKzqavSrx7p" +
       "74a1Tx0NB15/2tZOVHs6UB/rOHjOufPnO8+KzW8G12MHivLYaR3bKxUP4k7N" +
       "CvpETv7GLhTmj28qCsWj0r5XPVKMS8c9vnqpHv+R65dn/fLkqZ0lj/4DkMd9" +
       "efLUz5LH+wHIs3l58sBnybN9+fLcfyDD3r071t39DHmePlue/ah0uxfoG+Dq" +
       "gR8Oi0n9oXS3SW58sL7wzuLVTqxOVLoF+KNTMv/ES8q8K2IPDN5uq11uXq7k" +
       "/3/qbKluKVopJ+8H3KruiNahUK81LOmJwzDFKUEIXMoThtU8dJ2XCteZG+/l" +
       "3TT9lJz4y5YTeLu7jwtjXDDj/+n//LEvf/TxrwOXRJdu2+TuAniiEzWycb4I" +
       "8sHnPv7QK575858uBqygS7gPfP/Bd+Wl/vxLos3JzxxCfTCHOi3meYwYRoNi" +
       "jKnIR2hPdcqtlnsDaKP7P9aDQwo9/DGcSAjoPJks47q6WcfDIQzDCDTswSNK" +
       "0+sahlcyd73VsCzcjs1+a4IPY9kux3BPsBddu11DMHzhc2NmapJkl/aEsUeJ" +
       "ayykkoXRp/UA1xeTQaxOqMqE98d6hdMnXrcf8sRsI0tQnA2accaYntyIbbm5" +
       "am4UpLxslqFmXCccpDNN04nhD3ixhonEQqsxLMv79kRkWdGeClyFlJV6Opov" +
       "p6O2oi6XCG3T05rJ92QzmuvTRJADEq0KwWIyNBeZ3Z/RVdIbiuMtsjCr/nzF" +
       "9njXjyOhs9ajucRWJyRn6UzPZ6mQdFO3Nh0ntO7J+Jhfrfgm3x/HuDGkW7TV" +
       "QZx41W2wptbfrhZJlsLTZkpbEjMPRTmcJl3fH6y8CeyZNt7vuqZP2tHAjif4" +
       "uKrU5b7ZEBsYXQ2wibNgiZAYN+htjON8m1OXvXI7RnzC7EZe12zAZVroN2zL" +
       "zyoVUue4WVzRLUmMMmXS8/B1v29lHYOd9OYw2+VZlCJof1r1u3iNk6fMhNxU" +
       "AhNmWG7mT3vGGtMEp23TlGBN60NQqNQSFH1tRHEqdcWxbCHCYkqbFmxVlpPN" +
       "SgmbzUZrSk+rc9EnuxVuZird6QzlPbSCempnKFpBxmcdUUyHBEsaISdP5jS5" +
       "FES/XTFEriJOaGY76jv8oNdfd0h25IsEKW6NtMvbQl9ciWqnEc8ZYVNxG5xo" +
       "MgJW91PcNZdUVqW6OIKuB9kwXY6HSGwp9FBPJprQKHNUWtUhAtXRiCtLoQ23" +
       "R9w0oc0O6U86vmt6Ilcbcz7dXGDi2BrqupZKa6pegSdiZThlK5YcYZVqxRwt" +
       "+56P+karh1om31UoC87qWN+tVwKaDtQZslJjJ240x9bC0zv8AE76fghDW0/r" +
       "xux6YZpNf+5ghDYztL4ziRuLdVaG+50t0xlnWUeLxWUVKTdV1ufhVOpkoiax" +
       "eNhgrb4QSWFvqIlloCFeqnPkkKqk46Y0X462g3Rlc5HsRsbcJEaDbCxTEF+j" +
       "MX/ENFNvEcUKNSl39ZWViZN5NeI6vdHENftZj5gvLGTNzd3GqiP2U6Hdl8GI" +
       "xa6zCFtuYQjH4p7P1Se1hTeumrU+xyFLHyJktIqCsVhnZrX6iOssA78uYDxb" +
       "b4+67nSsbvAxquIDWmGITWIJPcVZwNlYT4W+LfZ8sypPJioYYfV8iQiHtaFM" +
       "EYsV7PFKSHVIPnMFS+6gRt31HJ5Y+Kt5mtIyR7V79pqS9ShFy/Z8HgwlM7Vm" +
       "q+7Wxer9YTvxG7gzzSbViVatlRdtfbxgsnXVU6tzt6P7kDHmjU6tu8UMkkeT" +
       "8iCu8HyAdnpiGSdMDqeMrMNjyZLB+TjBpa0IDX20L24WjFzbihVq0qB7k8U2" +
       "oUit562pDK7EM14NvXXUinpi6tcNo1VttebbPt+Ydk3LxucOKRE9tYnSPbpb" +
       "TldLDsUqY4Xe4gNpO0cNMrWZaMCXsTI07hL1ub+qz7FR0J04YUPvcE6Ejimo" +
       "iVGK2kpVsr2ZKXHdgI3ZoC+M1uUeg5L1tZJGjb4z6wWOIpZjpOzXRUUVGbcu" +
       "bypJLci2mu7L+jLhzXQ2wnxtoiiy4/jDoUO3baVeXY74MswuhTXNd2Z6ayDD" +
       "ycBL+nzLw9w0sage7qxC3iKFaNqllWxljTbywocVrak3YRZjpsE49YO1vcBX" +
       "PRXqVv1O1wqHnaE/VBRxpqEK2vPhrFmv16MgkZOYHCZu6HIIKU+qsZHO2muB" +
       "UOWOlqTVjeSb5FAr11i5gVRrapPLGHnCu3TMiyHWZOgNxoTUGG21Kg4btOvl" +
       "aIpFLdYbjVsJzuI0Ea4z0zbXodCYY1uNdivVGqKNyrMxN9JIb6Y2592yb1X6" +
       "Vr83jbrbje+L7GhEb8q1mHR8bWxW+4a4qtZ5cjaqUVis9Li22lK2zZBOJ2u1" +
       "J22lQdytiEhNQZDYjtClY66yJFv5QN0zmSjD6rLfsFb9paQn/SGqdBnWVZkR" +
       "PFyGWTWSml1eYGxu1B6Wlz1rHNezZg1pL4NNsxUv2Vbk2bTVi6NFOjXmorYE" +
       "4WZWGVW2QZ0VKcuRx4TaLI/owG8vDaTR67HxeoJpchDMCNAPfMYOhjYTO/V1" +
       "Iis9JlgbU2q6NDNgsLU+I4iwKfTKLlufNzRxZBszezmFF1FTHXC2PaVJBxeq" +
       "c23bZTOmXdPjQQeukbHa3aw6Hq/WnDItChs0bgRU1EDpVTxtUqs5yatamcGb" +
       "o2rFhbgQpi11gFi2AEsbZeFPKIlcAu+rIb1qbeh0A5ZnW36zUTUGujXRJ1ql" +
       "NyaWpitFG1/ORAXBBWntwHKj3qOmnrrENtCmtYa4sTvZwNgQR2pRSxp6PCXR" +
       "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" +
       "qdgr/OT7n3lWHn6qun+wQ0VGpTsi13ub");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "+63X/vMf/rVn/6w4qv3/AJpue34HQAAA");
}
