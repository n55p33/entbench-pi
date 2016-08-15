package org.apache.batik.ext.awt.geom;
public class Polyline2D implements java.awt.Shape, java.lang.Cloneable, java.io.Serializable {
    private static final float ASSUME_ZERO = 0.001F;
    public int npoints;
    public float[] xpoints;
    public float[] ypoints;
    protected java.awt.geom.Rectangle2D bounds;
    private java.awt.geom.GeneralPath path;
    private java.awt.geom.GeneralPath closedPath;
    public Polyline2D() { super();
                          xpoints = (new float[4]);
                          ypoints = (new float[4]); }
    public Polyline2D(float[] xpoints, float[] ypoints, int npoints) { super(
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
                                                                         (new float[npoints +
                                                                                      1]);
                                                                       this.
                                                                         ypoints =
                                                                         (new float[npoints +
                                                                                      1]);
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
                                                                         );
    }
    public Polyline2D(int[] xpoints, int[] ypoints,
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
                                       );
    }
    public Polyline2D(java.awt.geom.Line2D line) {
        super(
          );
        npoints =
          2;
        xpoints =
          (new float[2]);
        ypoints =
          (new float[2]);
        xpoints[0] =
          (float)
            line.
            getX1(
              );
        xpoints[1] =
          (float)
            line.
            getX2(
              );
        ypoints[0] =
          (float)
            line.
            getY1(
              );
        ypoints[1] =
          (float)
            line.
            getY2(
              );
        calculatePath(
          );
    }
    public void reset() { npoints = 0;
                          bounds = null;
                          path = new java.awt.geom.GeneralPath(
                                   );
                          closedPath = null;
    }
    public java.lang.Object clone() { org.apache.batik.ext.awt.geom.Polyline2D pol =
                                        new org.apache.batik.ext.awt.geom.Polyline2D(
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
    public java.awt.Rectangle getBounds() {
        if (bounds ==
              null)
            return null;
        else
            return bounds.
              getBounds(
                );
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
    public boolean contains(java.awt.Point p) {
        return false;
    }
    public boolean contains(double x, double y) {
        return false;
    }
    public boolean contains(int x, int y) {
        return false;
    }
    public java.awt.geom.Rectangle2D getBounds2D() {
        return bounds;
    }
    public boolean contains(java.awt.geom.Point2D p) {
        return false;
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
                            double h) { return false;
    }
    public boolean contains(java.awt.geom.Rectangle2D r) {
        return false;
    }
    public java.awt.geom.PathIterator getPathIterator(java.awt.geom.AffineTransform at) {
        if (path ==
              null)
            return null;
        else
            return path.
              getPathIterator(
                at);
    }
    public org.apache.batik.ext.awt.geom.Polygon2D getPolygon2D() {
        org.apache.batik.ext.awt.geom.Polygon2D pol =
          new org.apache.batik.ext.awt.geom.Polygon2D(
          );
        for (int i =
               0;
             i <
               npoints -
               1;
             i++) {
            pol.
              addPoint(
                xpoints[i],
                ypoints[i]);
        }
        java.awt.geom.Point2D.Double p0 =
          new java.awt.geom.Point2D.Double(
          xpoints[0],
          ypoints[0]);
        java.awt.geom.Point2D.Double p1 =
          new java.awt.geom.Point2D.Double(
          xpoints[npoints -
                    1],
          ypoints[npoints -
                    1]);
        if (p0.
              distance(
                p1) >
              ASSUME_ZERO)
            pol.
              addPoint(
                xpoints[npoints -
                          1],
                ypoints[npoints -
                          1]);
        return pol;
    }
    public java.awt.geom.PathIterator getPathIterator(java.awt.geom.AffineTransform at,
                                                      double flatness) {
        return path.
          getPathIterator(
            at);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "MPjM35wvZ+Bb9nCUv+Lbmv8BlGHf7W46AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "TEu1hW3CSKhrpAHhejIpe8PGnC1ZIxfy");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("MJ0DoXJz0RbB9Fs2N3a7NAWzhVWUKDdNIprgMGWGLVdEreRwaDfo1VmBwY1A" +
       "r0Gw26GwHmaQS2c2sNkygFwJNLettlEFeNxNfx3USd7kTBtGSZhhOzpVX4sN" +
       "TqZ4rWR7EDoFIurLrurMSWSiDtqtrskteD0ezIh5X6U51PdabhjMB9Px0u1r" +
       "Moz3F9IqwOou3CKpdkMYItBk3aTQqDkYcB2Zg41+ajlkl12iirYazcYjhJqY" +
       "HYUFA73ia0Uqpelu256U/c2si4gtbNM2TJujoRKrxQGqAn40t1J37LkMx1Wy" +
       "5q47jlmudxDHWFrh1Je6gcIMqq1eWGyOofaG4togJALeg5kYgc12V6FTclG2" +
       "XQnc1Okim+4GIlVhCmNTuDvqiByFUG190yS8VRcXSkod2ApY+m+GBDUNjdFa" +
       "KwUVKByyjF9bNPqcj2NJn8WRGlhP6DqiSnKfGxtsz10GEqbNO0WixBNqHK1H" +
       "RdQ11G44FKl2XSgiU8lSoVYH8hsttNnQRqza8ejVoBX0gcMZlGZqO2GbdWc5" +
       "AXGSaPOrztg3IrtdK6djKhY4ewH5s01nSnum3pRQSWeJgG6yqdYvM0kcK55X" +
       "Hvlpc+FOalDLrSGioTkwF3fg5qC1dtj1RBXNtarBYrgJhzykeILU7a4jYRWt" +
       "oEQdVJh03iuv5hu2tW6sBZmqpDov2YJOpzXBWBN9fE15uq3UOhiAV9M9UvWi" +
       "ttg0NQYXi7WuG0Hj+iBaEczA9FAYnuODKTU2UbwMlr9NRB0ui+11kRxoaToR" +
       "GI9ISW8jjERbLqezqoBWaRczixuoC2FTtF+loZEnVE1aEfnE8a0NEk58HCn6" +
       "U1ilbVxKKm6x53aJcWNOL2bLTZquQfBWTrVJyBAlEZLDCh1MVJYTJkRtJFMN" +
       "1pBooqc0q7KGof0e0QWxmLF2xw5v02uXAZ1WIU7gqrZWpxmBXtQHrdhGuuux" +
       "POl5HVueu6N0hsBRs5FAcwQtOSZCCcS8yGsTC14iqDB0olUXAcZQRXiUcYhi" +
       "SZ1DvV7XieiW2G2uFE8LiTU0q5edYEVJOuSN5c24OyAHqtUwWTVMsPGiqJEW" +
       "POtJcaC2AhB9GbO0P7UlFg/SIWIlpfFqiTWGswqyEbGVWxnK3QFY8s03jBCv" +
       "WotqwwtGZTqsafRiMZBJOIlZ3G/12M5kVlWCHr/sIdhmLUG1GQEi6TXEzOx1" +
       "tWa12houohWSJH8yewX7zat7NXxn/qr74CD70sKzjK9dxdvf+Eq7n/nfucKx" +
       "Y2BH9gSO7DWe3X+tfvvB5oSwkLfHLPa3ov3CAycdYM+PLX3k3c8+N+c+Wjqz" +
       "2whlwsItoeu90VLXqnWkr22/yuU7fB/e8fnh43sXh5I4ddPq5E3ZvTOn5N2Q" +
       "JX4vLNzoq4EaXvFl/No15ocj8f2r3s0+BHvXPtiP78B+/PqDvfOUvLszcuv+" +
       "0ZYrbKZsD04dgN277RrA5rtSrwHXZ3ZgP3O1YD/6omAfOiUvM4i9+8PCbYps" +
       "KZElh+puS2vv3CHAV10rwDeC67M7gJ+9PgCPHATJt87bORzoFKhvzMjrw8L5" +
       "yJtfGecbrgFnbqLZ9uKXdzi/fH209tiBi3su3Rnlsw3o7YmLPfwU7E9kpBwW" +
       "bpbn87zOMeTItSJ/HFwv7JC/cH2QX3mEG6egbGXkLSejJK8BZXa8pvAguL6z" +
       "Q/md64PyKP/9U/KEjGTzha6GtUv29u86UImDbf1DyL1rNd3Xg+v7O8jfvz6m" +
       "exTWk6fkyRmRwsLdW4PNdrqj0HD0K1juW68B5t1Z4qsAx7dt625/r7vlHoYN" +
       "uWrmCM1T0Geni/Y0oMy748HBlabdm2aua6mycygJ/XpI4t6dJO69rpZ8JQDn" +
       "5m40y79T23s6h/32U0Tyroxsjogke14dYo+vB/aHd9gfvq7Ys8f8NFV+MnDv" +
       "faeg/PsZec/JKN97DSjzAX0tYPjxHcrHrw/Ko/z/wil52cm/vZ8NCy878GLb" +
       "E0ifP4T3c9djENEdPPS6mnLGXjXH8U9OwfjRjDx38vi96Mm+FwP4AGBld4hp" +
       "77JDTD8cwBu2HyfmZniM5Jg+fQrez2TkE+HuC5xgFxofRfyixwZfCuLJDvHk" +
       "eg9p4fM5jM+eAvFzGfkXp0H8zeuhtbMdxNlfz6B+4RTEX8zIvz1ZiX/7euC1" +
       "dnitH9GQ/sEpAP9DRr50MsAvXwPA+7LENwBW3r4D+PbrCnA/onjg0rUAqWmG" +
       "ow59EA1kn8zmKF84RQL/LSNfDQsXgC/OQqpOqObfn+43f/+xpcbxIrmY/vha" +
       "Q2owze69Zyem91wfMR0F+Ren5H07I38WFm7NBJC9tnGdMrWP/g0v/gH4Yflc" +
       "FN+4HhrzsZ0oPnZ9RHEYfex9/dDwv3eKUH6Qkb+6XCuy5P9xCPY7V3VkH3jO" +
       "wy/ms89/77vsv3Fs/4OE8qnnLtx873Oj/7T92nP/vzzcwhRu1iLLOvrV2ZH7" +
       "c56vakYugFu236B52c+Zc8BGTh3GsHBD9pMxfObGbZ1bwsJ9J9UJC2cBPVr6" +
       "1rDw8iuVBiUBPVryQli443jJsHBj/nu03F1AVoflQIC8vTlaBGjnWVAku31F" +
       "ph1798Rbn3DfUeXK38Pd9WLDdFDl6LfpGdz8v6rsf6YWbf+vypPKp5+j2Z/+" +
       "duWj22/jFUtO889dbmYKN20/088bzT51e/jE1vbbOtd+7Lu3/9otr9t/GXr7" +
       "luFDRT/C20NX/hC9YXth/ul4+lv3/vM3/dPnvpZ/mvH/Ab9lSg7uRgAA");
}
