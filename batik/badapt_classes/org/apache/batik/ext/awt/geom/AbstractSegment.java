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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "4XzUIhsNvv3jhU8g6LjcE+P4tuS/8PEidnEkAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "bNNvnIP1fxTFnwCsnpKoJm8Z5amj8THW");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("r79dDT8Jrk8fYP30dxDrlf1RlLto+ISa//wc6N8qij8r3LlQM54uLfWMnv/3" +
       "W8GeJZUbZ47wFWeQHrnjtPD+hKv62VdvXHv3q8K/3ad4h6dQr9OVa6vUdU8e" +
       "GTnxfDWM9JVVsn99f4AkLG4XriaVx86df5LK5eJWcH3hyr7N9aTyyJu1AbkM" +
       "KE9S3wfyk7tRFwdCslOUN5LKzbOUYLIs7yfpHgSiP6YDidX+4SQJmFYvAZLi" +
       "8eHwcKI9cX5gfyonu3DiS+fACEv9Pfjt9HfU5OQBukIE5Unwwy+ZdH8W/AX1" +
       "c6+OmB9+o/UL+wN8qqvkedHLNZB2788SHqTdJ8+fnO3tsK+r5HPfvP9Xrz97" +
       "+OV2/57hY4c4wdsTdz8h1/fCpDzTlv+jd/+D9//iq39QHu75/1IFzayiLwAA");
}
