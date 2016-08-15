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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "oLPpGGw76I+1dieeLKm4ndlAqM2NpJXi");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("Al6MFLLVi8zFwl7iPIoELbxSqyQds4pSSBetKgZh8nPUoUlp2J4NE9rw0w5V" +
       "A6NiyZElsxnWHUa1+IghGpNeedCBF2LJHLMdXek3p7xutOAe6G9FJ3RPdWdd" +
       "poZR7TIBrw2cZdpjFYwznYNDFpZ9zaCnutwf96ikVIRFwsR0tQEP9Lnqqt1F" +
       "vQeXq+MELIuH1YFuWm4FALGaMOGzQ2yKAneExWpjBFz2eq5SrFQvpwhTFtEB" +
       "xNbqQTf1p6zeV6a4WZ6LomGYrYlU1urLEm6wyaQIfvXpyOeEytwordBBaWPq" +
       "9LgynbebFdZv9nww00nGujIa2UuEVekQxIAi0wfSxGbTDkW0nbVBwXPBIMTA" +
       "b8biKBjE2ESxB1QD00s+QVEJAhxCtAzZ8ZqrhcPeZOqISYmCuHap35TNqcbP" +
       "I9yc23WdIqq16Xy4WAnCQO3PxIUTe3N0IPoSMQBrsD4vVGW6Y0cjv2kYc3HU" +
       "HiSdsUB7zkJvL/SUlFg37fdKg36AyLWomwxSiQn4nlhJE3wDpGFqUdGPcbmV" +
       "gPWojbh2bYGawoyop2s4EtAEg3uDxI7m0JJla35KhbZFVWwWMMrHRRMjEXaC" +
       "hQleingDNNOwWZonSgKIp9k5MJuBR0GLGTdXRubcn+rd1ahoR1Jc0pMgkbQy" +
       "FBXX8AZJNVjiNEuOgZNN8PaK7DlGDSWHk3WnueawNSNWPEjklr6zsZbLqcHG" +
       "ZNEgE1JD69WKgLhJOYoqTWWmoVo4m6mzVqVYnszigWv7sYXVhKGT4JNyxHRQ" +
       "w1CSiikjnr+YhNNeka/DnKXXjHWw8krjTa3rdPtEEa9L06XQo5DRoCSFNXUh" +
       "VdVo1rDQNGIhpF2DVQrEBGXTHBSN6nrdMqf9BTPt8aEK3CDWr1cRhVabsxG7" +
       "Rrg0EhUHWrsiB7dYzKxJLSXgehgE4h0c8wOnJgQ8pQ7rglf0unY0IWFPiGCb" +
       "0Ps2DZubxWTmzdvtFTGZyIsk1STEjWi62B7LcX3aCpLOzGgUlwzec+pkyyxP" +
       "pLosuPHQQIrdgLc7es9EA9BBzJQRbxCnA6xlFRmmKwqz+bRrSyO+SW6kYa+E" +
       "jrhRKEYN3NT9Oiwz5qRcV9Cw2JUhqN6UqtWlD0u1ZrP5M9kr1u9f3avfV+Vv" +
       "uQ/OrC+tWpbxwlW83Y2vtK2b/50vHDvnfGRL4Mjm2nX7b9TvONibGILYP9/w" +
       "3t9/9AsPnHRWPT+r8swHn3paZj8Ln9vt/Klh4ebQ9d5hKWvFOtLXPdudy8s3" +
       "8r6w4/MLx7cuDiVx6t7UybuQe9efknc+S3wpLNzgK4ESXvFl+9o15ANN7BWu" +
       "epv+EOxd+2C/vAP75bMHe/cpefdk5I798wxX2EfZnpY5BHvhGsDmm1IPgesP" +
       "d2D/8GrBPv+yYB8+Je+RjLw+LNwuiZYUWWKo7Ha09m46BPjAtQLM9p2f3wF8" +
       "/mwAHtn9X+Qkh/OOU6BCGXlrWLgl8uQr43zbNeB8TZaY7S5+d4fzu2dvtY1T" +
       "8h7LSBkoUlPC7Khp9uEHgu9b71tf/tuFIxVyYVSuQRh3Z4nZ9vCLO2G8ePbC" +
       "6JySR2WkBVS9E4a2PZNPH6LDrgHdrfuq/tEO3Y/OBt2xo8P3XLoHzmVHCrbn" +
       "pveGp2CfZqQfFm4SZTmvc8zI2WtF/nZwvbRD/tLZIL/yYBZPQZltgu+952SU" +
       "771W630dYPi127rb3zPX7x1HjoYDADks+xTIq4zoAPLukGhwpXn4xoXrWoro" +
       "HErCOAtJ7M5Gb3/PVN/5SaIt+F84Bfz7M5IcAZ89B4co02tAmcUahTcChks7" +
       "lKWzQXmU/4+ekvcPM/KhsHAr8Fat/HQOgmfl3nkI78PXAO+eLPFBwOnuwNXe" +
       "ZQeurh3ep07J+3RG/hGIdA/g7Y+Auw5GwMGHIYeQP3EWdtvaQW6dqd1eaeCd" +
       "l91okX9buffZHPYzp4jktzLyT0625t+41oALrGP2ejvsvavF/vIR5RdOyftS" +
       "Rj4XFu7ehlnZ0aQoNBztCvHW589Cxe/dwXzv2ah476DA3ijH829OwfqVjHz5" +
       "ZD3+/hnEUHveDqB3NgCvzwtcnxvqMZJj+sYpeP99Rv4o3H1hE+xWQUcRf/Us" +
       "EH9gh/gDZ63SwjtzGH96CsRvZ+Rbp0F82aN9r8RqP7GD+Im/G6X+xSmI/1tG" +
       "vnOyEb9wFnif2eF95iek0u+fAvCHGfmrkwG+eA0A78sSQVS098UdwC+eKcD9" +
       "mfKBS9cCTVUFq7WRD+K87FvoHOWPT5HASxn5UVi4kK2HgB+mQiX/sHi/+fuP" +
       "LTWOF8nF9NdnIabdW4C9q34L8HKB5N7fHFj7uVtPFsW52zNy/nJRZMl7B2DP" +
       "3XhVZ/BBcHPw+X/2LfN9l/1fke3/wpA+9/SFm+59evyn2y8Y9/9fxc104SY1" +
       "sqyjX1IduT/v+Ypq5Phv3n5X5eVQXg3s4tR1fVi4PvvJ+D1397bOvWHhvpPq" +
       "hIXrAD1a+v6w8OorlQYlAT1a8oGwcOfxkmHhhvz3aLmHgGc9LAfCpu3N0SKP" +
       "gNZBkez20cw49u6Nt4q576ht5S9873o5LR1UOfqhfQY3//8w+59eRdv/EPO4" +
       "9Pmnu/2f/2H1s9sP/SVLTNOslZvowo3b/zmQN5p9vvXwia3tt3WefNuP7/jd" +
       "m9+0/673ji3Dh3Z+hLc3XPmresL2wvw7+PRf3vvFn/6nT38nP0H9/wEKaMuy" +
       "uEcAAA==");
}
