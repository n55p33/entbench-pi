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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "oULjXn9Dvlh9A7fhM/wV3576Pw+YcwNgLgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "OJ1iHIEz3iBw95wD7lJO7gZBPgocKz42");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("2+r3lc1d5vM6YyNaO3F0IpODizebBuT5ZnIkk+TWyOToAEchk71gHjlHMI/l" +
       "5MG4dBHM6iO8Ods+Jzh46GZx5ob9wSOcH3yDdP9D50B8OifvBI6r0H3bmPvh" +
       "mbzn4PKt0OWHjjB+6A3CiJyDsZETCKixwIjN491hlVMQKzcBsTiYAYPrZ44g" +
       "/swtN9fnC1Jged85OHOrPngmzo+lq7q1sfRdwn72dMHGt/Q99PfeLPRnwPXi" +
       "EfQXbw302/ZL3vYZ/Ow5+Lmc9E/jzx/so+zB4GaxQuD67BHWz95yNV8qSAHl" +
       "x86B+RM5kc6BOblZmC1wfekI5pfeGJWewro4B6uVE/UcrNrNJsM/CK6vHmH9" +
       "6q3BehpAdE7ZOiceAAfCC214i903DPuM+MC/FeC+dgTua7cG3HWe90PnIPxw" +
       "TrJzEH7gZhHm2eHXjxB+/dar7xPnlP3jnHw0Lt0V+/sDaps9to+9ruOcIHXe" +
       "fYmRHyt/6Lovu3ZfI2mff+neux58SfyT4mOEky+G7qZLd83XjnP6XOOp+wtB" +
       "aMytAuvdu1OOQQHghbj06LlJHggW+b98sAc/u6vzc3HpodeqE5duA/Q09y/E" +
       "pbfdiBtwAnqa8zNx6dJZTpCRFv9P8/0SCON7PiC03c1pln8GWgcs+e3nCkP4" +
       "bLrbonzotB0Vqfv930tFJ1VOf/OQwy2+0DveFVzvvtG7qn3hpT7zgVcbv7z7" +
       "5kJzlCzLW7mLLt25+/yjaDTfWXziNVs7busC9e7v3vMbdz91vAt6z27Ae5s+" +
       "NbZ33PgDB8IN4uKThOyLD/7me3/lpW8UBxn/PwE1qrY6OQAA");
}
