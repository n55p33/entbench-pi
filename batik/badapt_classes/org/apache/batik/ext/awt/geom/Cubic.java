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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVaC5AUxRnu3Xtw3HHccccbjudBBOEWEILmfMEBcrAHJyjE" +
       "QzjmZvvuBmZnhpneuwUlqFUC0ZJSRCWWUqaEoAbBMloxioqxolgSLR+JGiPE" +
       "SEWisSJJxVjBaP6/e3ZndnZnzk25WzW9s93/393/1/+re/vQZ6TEMskYqrEG" +
       "ttmgVsNCjbVKpkVjTapkWVdBXbt8T5H0z3Vnll0UJqVtZGC3ZLXIkkUXKVSN" +
       "WW2kTtEsJmkytZZRGkOOVpNa1OyRmKJrbWSIYjXHDVWRFdaixygSrJLMKBkk" +
       "MWYqHQlGm+0OGKmLwkwifCaRed7mxigZIOvGZod8uIu8ydWClHFnLIuR6ugG" +
       "qUeKJJiiRqKKxRqTJjnf0NXNXarOGmiSNWxQ59gQLInOyYJgwmNVX5y7vbua" +
       "Q1AraZrOuHjWCmrpag+NRUmVU7tQpXFrE/kRKYqSChcxI/XR1KARGDQCg6ak" +
       "dahg9pVUS8SbdC4OS/VUasg4IUbGZ3ZiSKYUt7tp5XOGHsqYLTtnBmnHpaUV" +
       "UmaJeNf5kT33rKt+vIhUtZEqRVuJ05FhEgwGaQNAabyDmta8WIzG2sggDRZ7" +
       "JTUVSVW22CtdYyldmsQSsPwpWLAyYVCTj+lgBesIspkJmelmWrxOrlD2r5JO" +
       "VeoCWYc6sgoJF2E9CFiuwMTMTgn0zmYp3qhoMUbGejnSMtYvBQJg7RenrFtP" +
       "D1WsSVBBaoSKqJLWFVkJqqd1AWmJDgpoMjLSt1PE2pDkjVIXbUeN9NC1iiag" +
       "6s+BQBZGhnjJeE+wSiM9q+Ran8+WXbzrOm2xFiYhmHOMyirOvwKYxniYVtBO" +
       "alKwA8E4YGr0bmnoszvDhADxEA+xoPnl9Wcvnzbm2HFBMyoHzfKODVRm7fL+" +
       "joFvjG6aclERTqPM0C0FFz9Dcm5lrXZLY9IADzM03SM2NqQaj6146ZobHqGf" +
       "hkl5MymVdTURBz0aJOtxQ1GpeQXVqCkxGmsm/akWa+LtzaQfvEcVjYra5Z2d" +
       "FmXNpFjlVaU6/w0QdUIXCFE5vCtap556NyTWzd+TBiGkHzxkADxjifjwb0ZW" +
       "Rbr1OI1IsqQpmh5pNXWU34qAx+kAbLsjHaD1GyOWnjBBBSO62RWRQA+6qd2A" +
       "lin1skgX1eORpkSHIjegfhkF6zmJMtX2hkIA92ivsatgJ4t1NUbNdnlPYv7C" +
       "s4fbXxWKhMpvo8HIRBisQQzWwAfjrhEGa8DBGvhgJBTiYwzGQcVywmJsBLMG" +
       "vzpgysq1S9bvnFAEemT0FgOSRUA6ISO+NDm2n3LY7fKRmsot40/OfDFMiqOk" +
       "RpJZQlIxXMwzu8ARyRttWx3QAZHHCQDjXAEAI5epyzQG/scvENi9lOk91MR6" +
       "Rga7ekiFJzTEiH9wyDl/cmxv742rts0Ik3Cmz8chS8BdIXsreuq0R6732nqu" +
       "fqt2nPniyN1bdcfqM4JIKvZlcaIME7xa4IWnXZ46Tnqy/dmt9Rz2/uCVmQRW" +
       "BA5vjHeMDKfSmHLQKEsZCNypm3FJxaYUxuWs29R7nRqunoP4+2BQiwq0smp4" +
       "Jthmx7+xdaiB5TChzqhnHil4ALhkpXH/u6/99QIOdypWVLmC/ErKGl3+CTur" +
       "4Z5okKO2V5mUAt0He1vvvOuzHWu4zgLFxFwD1mPZBH4JlhBgvvn4pvdOndz/" +
       "djit5yEGATrRAXlOMi0k1pPyACFhtMnOfMC/qeAJUGvqr9ZAP5VORepQKRrW" +
       "V1WTZj75t13VQg9UqEmp0bS+O3DqR8wnN7y67t9jeDchGeOrg5lDJpx2rdPz" +
       "PNOUNuM8kje+WfeTl6X7wf2Dy7WULZR7UcIxIHzR5nD5Z/BytqdtLhaTLLfy" +
       "Z9qXKw9ql29/+/PKVZ8/d5bPNjORcq91i2Q0CvXCYnISuh/mdU6LJasb6GYf" +
       "W3ZttXrsHPTYBj3K4GCt5Sa4xWSGZtjUJf3+8MKLQ9e/UUTCi0i5qkuxRRI3" +
       "MtIftJta3eBRk8Zll4vF7S2zVZokSZbwWRUI8NjcS7cwbjAO9panhj1x8cF9" +
       "J7mWGbyLumwLOs9WrvNyWxCW38Pi/Gy99GP1rGAZn3NZpidHb7ky0WGB11Xi" +
       "YGQ9droxq3W9vLO+9bRIJUbkYBB0Qx6K3LbqnQ0nuAmXoV/Hehyy0uW1wf+7" +
       "/Ee1EOEb+ITg+RofnDpWiLBd02TnDuPSyYNhoEZMCcj2MwWIbK05tfG+M48K" +
       "AbzJlYeY7txzyzcNu/YIuxQZ6MSsJNDNI7JQIQ4WS3F244NG4RyLPj6y9ZmH" +
       "tu4Qs6rJzKcWwnbh0d//90TD3j+9kiOsl8Z08Ew0vZ4h4bHQuWYuj5BpwY+r" +
       "jt5eU7QIgkIzKUtoyqYEbY65O4Uc2kp0uNbLSW55hVs6XBtGQlNhGbBiSXDB" +
       "aa4I8CBtWMznTRdi0SRMq/H/tEKsmOdrWjNs+5iRv2n5sXpEK+YTKea/hzMy" +
       "mnuEdMLVqsMuZ9aC+gV8/ZDGVfBJxAKg4lluuwPV+u8CKtEwilfi2cHojNyO" +
       "Hwo46cUjb8393cE77u4VShtggh6+4f9Zrnbc9Ocvsxw/z6ZyWKWHvy1y6L6R" +
       "TZd+yvmdtAa565PZ6TGkhg7vrEfi/wpPKP1NmPRrI9WyvQlfJakJTBbaYONp" +
       "pXbmsFHPaM/cRIodU2M6bRvtdQuuYb0JldvUilmGWXlyqCnwjLd1bbxXTUOE" +
       "v7BATfXjZiRszEyrW62jR4m+9EjLf4rXYdGDQ87KNeT1BRjyhvSQF+Qa8sYC" +
       "DHlzesjZuYbc/u2HrLWHCQ0SpOI7x5C3iLXn5VQspnPTDTPSzzCVHgiQEB8s" +
       "ftbjSVxrAnpnpETWE/bZ1GI7jOFXi+v9SkaKFJvGFXbw5+qkR/RbA0RP5lJf" +
       "/iklnn2719GOSnkzk9T5Ha3w8Lr/pj37YssPzAzbvnMFgxxPN6artIeqrq4G" +
       "Y08ZLq+FHyY5/uODgbs/+lV91/x8drJYN6aPvSr+HgvOa6q/F/VO5eWbPhl5" +
       "1aXd6/PYlI71oOTt8uGWQ69cMVneHeYnZ8KxZZ24ZTI1ZrqzcpOyhKll5goT" +
       "0+tag+s1DJ4L7XW90KvYfcdeP9aAWPlwQNvPsdiPKq/qGk2F6moeqtHTNwhP" +
       "7yjzge8sJ3kg0+BHwnOZLdxl+ePixxog+1MBbU9j8QtwJCYYiWmlkZkUfIq0" +
       "knbFqeaC64kCwIUnemQaPIttmRcFwOV1jtxF7fK4w4pUJzk684BUIrIj/OnN" +
       "bzP/bUlvifj+WmTf11a89Lz14F8eFzlTrg2X53z3oYNl8vvxl06nXFdzet6j" +
       "cJrjXSAs9oIA05nk709cs9r3s4mvbds38UO+cS5TLPBQ4NBynFi7eD4/dOrT" +
       "NyvrDnNPWIz+jhu896g/+yQ/44Cey1SFxQmxgcjaxvDIKAjsoPeGT9DD1wYw" +
       "5E5Fk1Te21KIfirVusSR8J1YvG44ShYWfCnNrnVsvgl9gZTaVUGbOA9V9Ib0" +
       "vyLQmMw52QccaV53GSyfT4C9nQpo+xCLP6Z8lBAjgPy0b3pPvDPGn6uTnOt4" +
       "QI9nsPg1RM0uyloUrUXKmQ8U9+hKzLH8Fwtg+TyADIWn3Vb69vwdpR9rgPxf" +
       "BLR9icVZkD6uaD90dJhD8I9CQhCz5YjlD4Efq7+YoaKANu4Mv0YIpKQXgm8K" +
       "CYFiy6HkD4Efa4CY1QFtNVhUCC24JhOC0IBCQqDZcmj5Q+DHGiBmXUDbWCyG" +
       "Cy3wQjCiABBgHskP3ZktB8sfAj/WADGnBrRNw2ISIxXgJ+fDFipmzVqQCiEj" +
       "Mk9/VkBSCaFGpTYFh2lyoTQFk4VttqzbAmDKSpbA5xumzmCyNObJmSoD+vRg" +
       "FHYiNM+UXuVoNQYgeQkWs2F0iOaxFbouMsrdDlRzCgAVZuBkHDzbbbG2569R" +
       "fqweWV3xlx+LhhYHgIGYhZogmaE9krqA/zlEHSQWFAqJMfDcYYtzR/5I+LH2" +
       "hcTVAUisxqIVfAwi4cHhygLgwA9/ZsLzoC3Mg/nj4MfqbyNHecEF7ggAI4bF" +
       "Wobn8x0xpUcRxwifOIisKxQijfAcscU6kj8ifqweWYvEHYO013DBogfAsgmL" +
       "DQGwbCwULNPhOWrLdjR/WPxYcytKKq58m2sdKPVWDs71AcDhmWmoNwC4ZKGA" +
       "mwvPR7b0H+UPnB9rsD6Ftjqw3BoAy21YbA+AZUehToTqwC+GRZ/iOy9YfFn7" +
       "CM7CC+8NQOReLO5kpBzSHPvAh5umA8meAkAyBNsgJoVqbblqgyEJzc3KV3xZ" +
       "+/A8LlwOBOByEIsHhKZE0+cOrjT4pwXM70L2OVAo6xyob03xYw2Q9fGAtiew" +
       "eFQcF+TE4XAhcYjawkTzx8GPta+U5fkAMF7A4ukAMJ4pFBiQxIXW2hKtzR8M" +
       "P9YAWU8EtL2GxcuMlDFd3MBNBTDXWburgUNz/Dv5U5uREh4F8VbO8Kyb0uJ2" +
       "r3x4X1XZsH1XvyPOM1M3cAdESVlnQlXd/9i63ksNk3YqHMsB4v9bfg8i9C4j" +
       "dYFhGTJY/MIph94RPO8zMtyPh5EiKN3UJxkZnIsaKKF0U34ICHspARH+7aY7" +
       "Df7coYPNhnhxk3wMvQMJvp4xUss3PTj/mNdhMVOSU3EiKQ5JR7nXjJ8TDelr" +
       "qV3/9k3MONXmV+RTx+gJcUm+XT6yb8my685+/4C4RCir0pYt2EtFlPQT9xl5" +
       "p/iv2Hjf3lJ9lS6ecm7gY/0npQ7hB4kJOyY0ytFzMg9MxkBVG+m5YWfVpy/a" +
       "vbf/4ud+u7P0zTAJrSEhiZHaNdl3C5JGwiR1a6LZt3hWSSa/+tc45d7Nl07r" +
       "/Pv7/A4ZEbd+RvvTt8tvH1z71u7h+8eESUUzKYGtNU3ySw8LNmsrqNxjtpFK" +
       "xVqYhClCL4qkZlwRGohWIaGFclxsOCvTtXgFlZEJ2Reksi/ulqt6LzX5EQl2" +
       "UxklFU6NWBnPH4sJw/AwODX2UmK5CoulSVwNUNb2aIthpO6PkR8Y3COszuXH" +
       "+X/WoXP8Fd+++h85A2y/PjMAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "emKrjfcSXSPxucFvtj1aZrONQ4b4aNxLtr6WhevKDJUSt4t1VGde7mrUjFlg" +
       "jcGMgiZtp+rWRnxzNWSc0IuQMkyt2t2xsaYsxicF2h6ky/FmG7cwJmOiiEtr" +
       "NCb0+wTdNpdYBxvUVT/b0j04lJPOxEBtykIrY6bBaGJTtYwuuZ13jD66ydo2" +
       "LDtp0kSqQRSWB1aNcLYtWZ+1cGWwDAM1XpeZRrNWddfxah1V3alrZJOKpMir" +
       "9RghB8NEsGVxMO40UxEZcO5SQBpzd53BihOhzLYKxwTr0AyHY/XE7Kvj9nA1" +
       "c/ojetgJBWKS+U6tS6Yiv0hjLqyiTNNl1rHrTRGoitPGZl0OHR8hI91Jm1AK" +
       "XCBenxP6dq27fcNGsJFu+cs+HDdgFKUHlJL5HDtyCLgTDHt2DSLmcYAIdc8a" +
       "UlW27iywqNxXK0mSUPG2z8XIVht10+6mXXGmAt5HSFvHtSRxET9RKFfZwopp" +
       "RPWs08PmAYMtbWpslK2KP80woqtHY5dajQl4rWLkopesA1TApnWWYlSfHjIB" +
       "x1a4uWA261GlxtIaulh3HL8szSCq1l4zrY07aWaNZoSaalvWeyoVaHW7Tfpp" +
       "NVCm2+mEWkziccsyVYhbqXO7sWxuVtV21uQWI4FpLuRBOuhvmbrbrgswnkVr" +
       "JRrp4nw0WmUCul4ON+jarqIwBE+HrNCClbo0nZgUI6/RilGly0SyJHh3MIt1" +
       "2FEWjREphlKjx6+4mhBFyyDsT+c8btaGSI+I6jMRSblZT4jMBbmqQa3xcESj" +
       "KrxYzAmjbNTXVpwyzKA2jgariIzEmoozVkuwbSTpNmfVLSt41kyQNhyzGLQm" +
       "pjxryhvJxCjUF13drKQtuYuSTYfrSdkodjYjKkS5IJlkXEpwtdbUgHsZivam" +
       "laCHCW5tIviG0peaVlbmenilsjT4Ho0qgZeuaxyajCgIlZgBuZAsHsfLdNoY" +
       "1kbS2qXLbow5S4+F+6qeZeWYq2xWUBPuqJUO1ZGgwVyDGG/ltn3OGOFKuTp3" +
       "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" +
       "UrFX+In3P/ucQn2ysn+wQ9WNSndEnv9W");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "+xuv/Zc//CvP/UlxVPv/AwltUUIHQAAA");
}
