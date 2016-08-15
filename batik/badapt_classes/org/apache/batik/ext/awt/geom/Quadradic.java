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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "f8W3f/4XO1a5AG4zAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "JBvHqsq3wJ+++nYOVRyBOtpT+b3n//uD");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "hRBmPwAA");
}
