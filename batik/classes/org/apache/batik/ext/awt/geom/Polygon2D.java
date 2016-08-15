package org.apache.batik.ext.awt.geom;
public class Polygon2D implements java.awt.Shape, java.lang.Cloneable, java.io.Serializable {
    public int npoints;
    public float[] xpoints;
    public float[] ypoints;
    protected java.awt.geom.Rectangle2D bounds;
    private java.awt.geom.GeneralPath path;
    private java.awt.geom.GeneralPath closedPath;
    public Polygon2D() { super();
                         xpoints = (new float[4]);
                         ypoints = (new float[4]); }
    public Polygon2D(java.awt.geom.Rectangle2D rec) { super();
                                                      if (rec == null) { throw new java.lang.IndexOutOfBoundsException(
                                                                           "null Rectangle");
                                                      }
                                                      npoints =
                                                        4;
                                                      xpoints =
                                                        (new float[4]);
                                                      ypoints =
                                                        (new float[4]);
                                                      xpoints[0] =
                                                        (float)
                                                          rec.
                                                          getMinX(
                                                            );
                                                      ypoints[0] =
                                                        (float)
                                                          rec.
                                                          getMinY(
                                                            );
                                                      xpoints[1] =
                                                        (float)
                                                          rec.
                                                          getMaxX(
                                                            );
                                                      ypoints[1] =
                                                        (float)
                                                          rec.
                                                          getMinY(
                                                            );
                                                      xpoints[2] =
                                                        (float)
                                                          rec.
                                                          getMaxX(
                                                            );
                                                      ypoints[2] =
                                                        (float)
                                                          rec.
                                                          getMaxY(
                                                            );
                                                      xpoints[3] =
                                                        (float)
                                                          rec.
                                                          getMinX(
                                                            );
                                                      ypoints[3] =
                                                        (float)
                                                          rec.
                                                          getMaxY(
                                                            );
                                                      calculatePath(
                                                        );
    }
    public Polygon2D(java.awt.Polygon pol) { super();
                                             if (pol == null) {
                                                 throw new java.lang.IndexOutOfBoundsException(
                                                   "null Polygon");
                                             }
                                             this.
                                               npoints =
                                               pol.
                                                 npoints;
                                             this.
                                               xpoints =
                                               (new float[pol.
                                                            npoints]);
                                             this.
                                               ypoints =
                                               (new float[pol.
                                                            npoints]);
                                             for (int i =
                                                    0;
                                                  i <
                                                    pol.
                                                      npoints;
                                                  i++) {
                                                 xpoints[i] =
                                                   pol.
                                                     xpoints[i];
                                                 ypoints[i] =
                                                   pol.
                                                     ypoints[i];
                                             }
                                             calculatePath(
                                               );
    }
    public Polygon2D(float[] xpoints, float[] ypoints,
                     int npoints) { super();
                                    if (npoints >
                                          xpoints.
                                            length ||
                                          npoints >
                                          ypoints.
                                            length) {
                                        throw new java.lang.IndexOutOfBoundsException(
                                          "npoints > xpoints.length || npoints > ypoints.length");
                                    }
                                    this.
                                      npoints =
                                      npoints;
                                    this.
                                      xpoints =
                                      (new float[npoints]);
                                    this.
                                      ypoints =
                                      (new float[npoints]);
                                    java.lang.System.
                                      arraycopy(
                                        xpoints,
                                        0,
                                        this.
                                          xpoints,
                                        0,
                                        npoints);
                                    java.lang.System.
                                      arraycopy(
                                        ypoints,
                                        0,
                                        this.
                                          ypoints,
                                        0,
                                        npoints);
                                    calculatePath(
                                      ); }
    public Polygon2D(int[] xpoints, int[] ypoints,
                     int npoints) { super(
                                      );
                                    if (npoints >
                                          xpoints.
                                            length ||
                                          npoints >
                                          ypoints.
                                            length) {
                                        throw new java.lang.IndexOutOfBoundsException(
                                          "npoints > xpoints.length || npoints > ypoints.length");
                                    }
                                    this.
                                      npoints =
                                      npoints;
                                    this.
                                      xpoints =
                                      (new float[npoints]);
                                    this.
                                      ypoints =
                                      (new float[npoints]);
                                    for (int i =
                                           0;
                                         i <
                                           npoints;
                                         i++) {
                                        this.
                                          xpoints[i] =
                                          xpoints[i];
                                        this.
                                          ypoints[i] =
                                          ypoints[i];
                                    }
                                    calculatePath(
                                      ); }
    public void reset() { npoints = 0;
                          bounds = null;
                          path = new java.awt.geom.GeneralPath(
                                   );
                          closedPath = null;
    }
    public java.lang.Object clone() { org.apache.batik.ext.awt.geom.Polygon2D pol =
                                        new org.apache.batik.ext.awt.geom.Polygon2D(
                                        );
                                      for (int i =
                                             0;
                                           i <
                                             npoints;
                                           i++) {
                                          pol.
                                            addPoint(
                                              xpoints[i],
                                              ypoints[i]);
                                      }
                                      return pol;
    }
    private void calculatePath() { path =
                                     new java.awt.geom.GeneralPath(
                                       );
                                   path.moveTo(
                                          xpoints[0],
                                          ypoints[0]);
                                   for (int i =
                                          1;
                                        i <
                                          npoints;
                                        i++) {
                                       path.
                                         lineTo(
                                           xpoints[i],
                                           ypoints[i]);
                                   }
                                   bounds =
                                     path.
                                       getBounds2D(
                                         );
                                   closedPath =
                                     null;
    }
    private void updatePath(float x, float y) {
        closedPath =
          null;
        if (path ==
              null) {
            path =
              new java.awt.geom.GeneralPath(
                java.awt.geom.GeneralPath.
                  WIND_EVEN_ODD);
            path.
              moveTo(
                x,
                y);
            bounds =
              new java.awt.geom.Rectangle2D.Float(
                x,
                y,
                0,
                0);
        }
        else {
            path.
              lineTo(
                x,
                y);
            float _xmax =
              (float)
                bounds.
                getMaxX(
                  );
            float _ymax =
              (float)
                bounds.
                getMaxY(
                  );
            float _xmin =
              (float)
                bounds.
                getMinX(
                  );
            float _ymin =
              (float)
                bounds.
                getMinY(
                  );
            if (x <
                  _xmin)
                _xmin =
                  x;
            else
                if (x >
                      _xmax)
                    _xmax =
                      x;
            if (y <
                  _ymin)
                _ymin =
                  y;
            else
                if (y >
                      _ymax)
                    _ymax =
                      y;
            bounds =
              new java.awt.geom.Rectangle2D.Float(
                _xmin,
                _ymin,
                _xmax -
                  _xmin,
                _ymax -
                  _ymin);
        }
    }
    public org.apache.batik.ext.awt.geom.Polyline2D getPolyline2D() {
        org.apache.batik.ext.awt.geom.Polyline2D pol =
          new org.apache.batik.ext.awt.geom.Polyline2D(
          xpoints,
          ypoints,
          npoints);
        pol.
          addPoint(
            xpoints[0],
            ypoints[0]);
        return pol;
    }
    public java.awt.Polygon getPolygon() {
        int[] _xpoints =
          new int[npoints];
        int[] _ypoints =
          new int[npoints];
        for (int i =
               0;
             i <
               npoints;
             i++) {
            _xpoints[i] =
              (int)
                xpoints[i];
            _ypoints[i] =
              (int)
                ypoints[i];
        }
        return new java.awt.Polygon(
          _xpoints,
          _ypoints,
          npoints);
    }
    public void addPoint(java.awt.geom.Point2D p) {
        addPoint(
          (float)
            p.
            getX(
              ),
          (float)
            p.
            getY(
              ));
    }
    public void addPoint(float x, float y) {
        if (npoints ==
              xpoints.
                length) {
            float[] tmp;
            tmp =
              (new float[npoints *
                           2]);
            java.lang.System.
              arraycopy(
                xpoints,
                0,
                tmp,
                0,
                npoints);
            xpoints =
              tmp;
            tmp =
              (new float[npoints *
                           2]);
            java.lang.System.
              arraycopy(
                ypoints,
                0,
                tmp,
                0,
                npoints);
            ypoints =
              tmp;
        }
        xpoints[npoints] =
          x;
        ypoints[npoints] =
          y;
        npoints++;
        updatePath(
          x,
          y);
    }
    public boolean contains(java.awt.Point p) {
        return contains(
                 p.
                   x,
                 p.
                   y);
    }
    public boolean contains(int x, int y) {
        return contains(
                 (double)
                   x,
                 (double)
                   y);
    }
    public java.awt.geom.Rectangle2D getBounds2D() {
        return bounds;
    }
    public java.awt.Rectangle getBounds() {
        if (bounds ==
              null)
            return null;
        else
            return bounds.
              getBounds(
                );
    }
    public boolean contains(double x, double y) {
        if (npoints <=
              2 ||
              !bounds.
              contains(
                x,
                y)) {
            return false;
        }
        updateComputingPath(
          );
        return closedPath.
          contains(
            x,
            y);
    }
    private void updateComputingPath() { if (npoints >=
                                               1) {
                                             if (closedPath ==
                                                   null) {
                                                 closedPath =
                                                   (java.awt.geom.GeneralPath)
                                                     path.
                                                     clone(
                                                       );
                                                 closedPath.
                                                   closePath(
                                                     );
                                             }
                                         }
    }
    public boolean contains(java.awt.geom.Point2D p) {
        return contains(
                 p.
                   getX(
                     ),
                 p.
                   getY(
                     ));
    }
    public boolean intersects(double x, double y,
                              double w,
                              double h) {
        if (npoints <=
              0 ||
              !bounds.
              intersects(
                x,
                y,
                w,
                h)) {
            return false;
        }
        updateComputingPath(
          );
        return closedPath.
          intersects(
            x,
            y,
            w,
            h);
    }
    public boolean intersects(java.awt.geom.Rectangle2D r) {
        return intersects(
                 r.
                   getX(
                     ),
                 r.
                   getY(
                     ),
                 r.
                   getWidth(
                     ),
                 r.
                   getHeight(
                     ));
    }
    public boolean contains(double x, double y,
                            double w,
                            double h) { if (npoints <=
                                              0 ||
                                              !bounds.
                                              intersects(
                                                x,
                                                y,
                                                w,
                                                h)) {
                                            return false;
                                        }
                                        updateComputingPath(
                                          );
                                        return closedPath.
                                          contains(
                                            x,
                                            y,
                                            w,
                                            h);
    }
    public boolean contains(java.awt.geom.Rectangle2D r) {
        return contains(
                 r.
                   getX(
                     ),
                 r.
                   getY(
                     ),
                 r.
                   getWidth(
                     ),
                 r.
                   getHeight(
                     ));
    }
    public java.awt.geom.PathIterator getPathIterator(java.awt.geom.AffineTransform at) {
        updateComputingPath(
          );
        if (closedPath ==
              null)
            return null;
        else
            return closedPath.
              getPathIterator(
                at);
    }
    public java.awt.geom.PathIterator getPathIterator(java.awt.geom.AffineTransform at,
                                                      double flatness) {
        return getPathIterator(
                 at);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "egRir+1Rp4vP9DKGsnForBa6W+4FQoui");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("kPKosWi2ylKZr1MKPImRLlwyJLkkiky5ortzYDijMljmdZKowpbihUl30Cov" +
       "rUYrkZvIM05MnMnaa6dJo4/RGpu2q9Qg1TW7BxxTyJXDbpsw3Lk1ai94XlfG" +
       "YGDXlqi5cWrkhmVis6k2BxKip1ZzRm7cMT9pCJNwLiKUCbvzyQw3++Ew5Iwu" +
       "5s4heUpxw1prw0J4qDLV/kIaLKIFJXRFhgXx3GjA9tKFbodVFouDOcTFo5JU" +
       "JjdNZ8j0GxbTCUvD1INoXK6WWZQOPb4/YY3VqtcZtW3IJHBizPBQV203fXKz" +
       "XAAnt2EVj2NYw/BE0R0vULppzmZ6qBVbXKNNVnl26WyG2jrsGfi4r4zgtmmx" +
       "bR6hlkOuU3LbfqfWX2JJRw70WXfKMCMwhoxsDNEmR+vJ2F4XUb/v27MuHIUi" +
       "HoOFDFsZgJUyhxlCRAT8sj9g2iuSE835QqpOOaZSFJdNmCvH+EIpTa0Fq8zF" +
       "mke3yhsQ7XQWgjhssvhYFOpVQ0wU1iJ8echDLXraJ6OygQbd8iTtj5ZjsRjH" +
       "eFpsMPTaLI6deOINNnWvZi9LXpV2DI1EGulaCXhn3Cqt3LJTjFOzWNz4E9dc" +
       "zvTUVsHEbjQT2xSQ9opVq0l/1utqqFGWqKXO8Cq74Volq81itVWjQZt9p10L" +
       "BoMxCcNQjFNopbl0N30EgopqCNYNFQumSH02gJDVptaEV1SvsinB881oXY79" +
       "Ib7uSVUDESHIW8Sway3Hw9gpGi0cisqyWuOXVL2mdmCMqft2DAvztVPh5sVe" +
       "Fyupo5Cr47OiPvbaBlpBW1Iy79eD0kCSw5XH0UMzRqW6qKo132lKzaAjL0tp" +
       "PEgMdbhwHXFAzOLKoBql1XJNK5NaJEFoytdWXnnQ4hboojOl5w1+6sT17jIx" +
       "u2EtYdosZHEbVoKIVTONOTDDp0HYUKo01MKqvYmRtGsx5BKbuob202gjrZdJ" +
       "y2pI8MLpgQ4FXuNmUY3j1XaZsmaTxJuq8ILjKJabtR2aSSDepNw1ApbpZFMm" +
       "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" +
       "06e/k5+g/v8VgbBRuEcAAA==");
}
