package org.apache.batik.ext.awt.geom;
public abstract class AbstractSegment implements org.apache.batik.ext.awt.geom.Segment {
    protected abstract int findRoots(double y, double[] roots);
    public org.apache.batik.ext.awt.geom.Segment.SplitResults split(double y) {
        double[] roots =
          { 0,
        0,
        0 };
        int numSol =
          findRoots(
            y,
            roots);
        if (numSol ==
              0)
            return null;
        java.util.Arrays.
          sort(
            roots,
            0,
            numSol);
        double[] segs =
          new double[numSol +
                       2];
        int numSegments =
          0;
        segs[numSegments++] =
          0;
        for (int i =
               0;
             i <
               numSol;
             i++) {
            double r =
              roots[i];
            if (r <=
                  0.0)
                continue;
            if (r >=
                  1.0)
                break;
            if (segs[numSegments -
                       1] !=
                  r)
                segs[numSegments++] =
                  r;
        }
        segs[numSegments++] =
          1.0;
        if (numSegments ==
              2)
            return null;
        org.apache.batik.ext.awt.geom.Segment[] parts =
          new org.apache.batik.ext.awt.geom.Segment[numSegments];
        double pT =
          0.0;
        int pIdx =
          0;
        boolean firstAbove =
          false;
        boolean prevAbove =
          false;
        for (int i =
               1;
             i <
               numSegments;
             i++) {
            parts[pIdx] =
              getSegment(
                segs[i -
                       1],
                segs[i]);
            java.awt.geom.Point2D.Double pt =
              parts[pIdx].
              eval(
                0.5);
            if (pIdx ==
                  0) {
                pIdx++;
                firstAbove =
                  (prevAbove =
                     pt.
                       y <
                       y);
                continue;
            }
            boolean above =
              pt.
                y <
              y;
            if (prevAbove ==
                  above) {
                parts[pIdx -
                        1] =
                  getSegment(
                    pT,
                    segs[i]);
            }
            else {
                pIdx++;
                pT =
                  segs[i -
                         1];
                prevAbove =
                  above;
            }
        }
        if (pIdx ==
              1)
            return null;
        org.apache.batik.ext.awt.geom.Segment[] below;
        org.apache.batik.ext.awt.geom.Segment[] above;
        if (firstAbove) {
            above =
              (new org.apache.batik.ext.awt.geom.Segment[(pIdx +
                                                            1) /
                                                           2]);
            below =
              (new org.apache.batik.ext.awt.geom.Segment[pIdx /
                                                           2]);
        }
        else {
            above =
              (new org.apache.batik.ext.awt.geom.Segment[pIdx /
                                                           2]);
            below =
              (new org.apache.batik.ext.awt.geom.Segment[(pIdx +
                                                            1) /
                                                           2]);
        }
        int ai =
          0;
        int bi =
          0;
        for (int i =
               0;
             i <
               pIdx;
             i++) {
            if (firstAbove)
                above[ai++] =
                  parts[i];
            else
                below[bi++] =
                  parts[i];
            firstAbove =
              !firstAbove;
        }
        return new org.apache.batik.ext.awt.geom.Segment.SplitResults(
          below,
          above);
    }
    public org.apache.batik.ext.awt.geom.Segment splitBefore(double t) { return getSegment(
                                                                                  0.0,
                                                                                  t);
    }
    public org.apache.batik.ext.awt.geom.Segment splitAfter(double t) {
        return getSegment(
                 t,
                 1.0);
    }
    static final double eps = 1 / (double) (1L <<
                                              48);
    static final double tol = 4.0 * eps;
    public static int solveLine(double a, double b,
                                double[] roots) {
        if (a ==
              0) {
            if (b !=
                  0)
                return 0;
            roots[0] =
              0;
            return 1;
        }
        roots[0] =
          -b /
            a;
        return 1;
    }
    public static int solveQuad(double a, double b,
                                double c,
                                double[] roots) {
        if (a ==
              0) {
            return solveLine(
                     b,
                     c,
                     roots);
        }
        double det =
          b *
          b -
          4 *
          a *
          c;
        if (java.lang.Math.
              abs(
                det) <=
              tol *
              b *
              b) {
            roots[0] =
              -b /
                (2 *
                   a);
            return 1;
        }
        if (det <
              0)
            return 0;
        det =
          java.lang.Math.
            sqrt(
              det);
        double w =
          -(b +
              matchSign(
                det,
                b));
        roots[0] =
          2 *
            c /
            w;
        roots[1] =
          w /
            (2 *
               a);
        return 2;
    }
    public static double matchSign(double a, double b) {
        if (b <
              0)
            return a <
              0
              ? a
              : -a;
        return a >
          0
          ? a
          : -a;
    }
    public static int solveCubic(double a3, double a2,
                                 double a1,
                                 double a0,
                                 double[] roots) {
        double[] dRoots =
          { 0,
        0 };
        int dCnt =
          solveQuad(
            3 *
              a3,
            2 *
              a2,
            a1,
            dRoots);
        double[] yVals =
          { 0,
        0,
        0,
        0 };
        double[] tVals =
          { 0,
        0,
        0,
        0 };
        int yCnt =
          0;
        yVals[yCnt] =
          a0;
        tVals[yCnt++] =
          0;
        double r;
        switch (dCnt) {
            case 1:
                r =
                  dRoots[0];
                if (r >
                      0 &&
                      r <
                      1) {
                    yVals[yCnt] =
                      ((a3 *
                          r +
                          a2) *
                         r +
                         a1) *
                        r +
                        a0;
                    tVals[yCnt++] =
                      r;
                }
                break;
            case 2:
                if (dRoots[0] >
                      dRoots[1]) {
                    double t =
                      dRoots[0];
                    dRoots[0] =
                      dRoots[1];
                    dRoots[1] =
                      t;
                }
                r =
                  dRoots[0];
                if (r >
                      0 &&
                      r <
                      1) {
                    yVals[yCnt] =
                      ((a3 *
                          r +
                          a2) *
                         r +
                         a1) *
                        r +
                        a0;
                    tVals[yCnt++] =
                      r;
                }
                r =
                  dRoots[1];
                if (r >
                      0 &&
                      r <
                      1) {
                    yVals[yCnt] =
                      ((a3 *
                          r +
                          a2) *
                         r +
                         a1) *
                        r +
                        a0;
                    tVals[yCnt++] =
                      r;
                }
                break;
            default:
                break;
        }
        yVals[yCnt] =
          a3 +
            a2 +
            a1 +
            a0;
        tVals[yCnt++] =
          1.0;
        int ret =
          0;
        for (int i =
               0;
             i <
               yCnt -
               1;
             i++) {
            double y0 =
              yVals[i];
            double t0 =
              tVals[i];
            double y1 =
              yVals[i +
                      1];
            double t1 =
              tVals[i +
                      1];
            if (y0 <
                  0 &&
                  y1 <
                  0)
                continue;
            if (y0 >
                  0 &&
                  y1 >
                  0)
                continue;
            if (y0 >
                  y1) {
                double t;
                t =
                  y0;
                y0 =
                  y1;
                y1 =
                  t;
                t =
                  t0;
                t0 =
                  t1;
                t1 =
                  t;
            }
            if (-y0 <
                  tol *
                  y1) {
                roots[ret++] =
                  t0;
                continue;
            }
            if (y1 <
                  -tol *
                  y0) {
                roots[ret++] =
                  t1;
                i++;
                continue;
            }
            double epsZero =
              tol *
              (y1 -
                 y0);
            int cnt;
            for (cnt =
                   0;
                 cnt <
                   20;
                 cnt++) {
                double dt =
                  t1 -
                  t0;
                double dy =
                  y1 -
                  y0;
                double t =
                  t0 +
                  (java.lang.Math.
                     abs(
                       y0 /
                         dy) *
                     99 +
                     0.5) *
                  dt /
                  100;
                double v =
                  ((a3 *
                      t +
                      a2) *
                     t +
                     a1) *
                  t +
                  a0;
                if (java.lang.Math.
                      abs(
                        v) <
                      epsZero) {
                    roots[ret++] =
                      t;
                    break;
                }
                if (v <
                      0) {
                    t0 =
                      t;
                    y0 =
                      v;
                }
                else {
                    t1 =
                      t;
                    y1 =
                      v;
                }
            }
            if (cnt ==
                  20)
                roots[ret++] =
                  (t0 +
                     t1) /
                    2;
        }
        return ret;
    }
    public AbstractSegment() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "yncQ9cn85Nim3zgH6/8oij8GWMF3sWLy");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("llGeOhodY/3GO9Xwk+D6zAHWz3wHsV7ZH0W5i4ZPqPnPzoH+raL408KdCzWT" +
       "iWwpZ/T8v98O9jSu3DhzhK84g/TIHaeF9ydclc+9euPae1+d/bt9ind4CvX6" +
       "sHJNTxzn5JGRE89Xg1DTrZL96/sDJEFxu3A1rjx27vwTVy4Xt4LrC1f2ba7H" +
       "lUfeqg3IZUB5kvo+kJ/cjbo4EJKeorwRV26epQSTZXk/SfcgEP0xHUis9g8n" +
       "ScC0egmQFI8PB4cT7YnzA/tTOemFE186B0ZY6u/Bb6e/oyYnD9AVIihPgh9+" +
       "yST7s+AvKJ9/lWF/5I3mz+8P8CmOlOdFL9dA2r0/S3iQdp88f3K2t8O+rvae" +
       "e/P+X7n+7OGX2/17ho8d4gRvT9z9hBzlBnF5pi3/x+/9hx/8hVd/vzzc8/8B" +
       "jHab+KIvAAA=");
}
