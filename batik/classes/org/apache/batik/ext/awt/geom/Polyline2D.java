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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "2uAzf3O+nIFv2cNR/opva/4HbvJGQm46AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL18e/DsVn3f/u69fl1sXz8wNgbbGBuIveFqd7WSdmNC0Gof" +
       "0u5Kq13tU7TYeku7eq3eK3AJNAVPaClNTEJmEndKIQVKIGSaJh2G1m2GEpoM" +
       "TEj6CJlimrbTNIQp/NE0lAI90u7vcX/3/n725V7ym9FZ6Ty/n+/5vo7O0e+T" +
       "3yzc4HuFouuYG810gotKElxcmsjFYOMq/sVuH2EFz1dkwhR8fwzynpRe++sX" +
       "/vK7H9DvOFO4kS/cLdi2EwiB4dj+SPEdM1LkfuHCYW7LVCw/KNzRXwqRAIWB" +
       "YUJ9ww+e6BdedqRpUHi0v08CBEiAAAlQTgKEH9YCjW5T7NAishaCHfjrwt8q" +
       "7PULN7pSRl5QePjSTlzBE6xdN2yOAPRwc/Y8BaDyxolXeM0B9i3mywB/sAg9" +
       "+4tvu+M3zhYu8IULhs1l5EiAiAAMwhdutRRLVDwfl2VF5gt32ooic4pnCKaR" +
       "5nTzhbt8Q7OFIPSUAyZlmaGrePmYh5y7VcqweaEUON4BPNVQTHn/6QbVFDSA" +
       "9RWHWLcI21k+AHjeAIR5qiAp+03OrQxbDgoPHW9xgPHRHqgAmt5kKYHuHAx1" +
       "zhZARuGu7dyZgq1BXOAZtgaq3uCEYJSgcP+JnWa8dgVpJWjKk0HhvuP12G0R" +
       "qHVLzoisSVC453i1vCcwS/cfm6Uj8/NN5k3vf7tN2mdymmVFMjP6bwaNHjzW" +
       "aKSoiqfYkrJteOvj/V8QXvG5Z84UCqDyPccqb+v81ju+/ZYff/D5393WedUV" +
       "6gzEpSIFT0ofEW//g1cTj9XPZmTc7Dq+kU3+Jchz8Wd3JU8kLtC8Vxz0mBVe" +
       "3C98fvRvFz/9CeUbZwrnqcKNkmOGFpCjOyXHcg1T8TqKrXhCoMhU4RbFlom8" +
       "nCrcBO77hq1scweq6isBVThn5lk3OvkzYJEKushYdBO4N2zV2b93hUDP7xO3" +
       "UCjcBK4CDq43FLZ/+W9QeCukO5YCCZJgG7YDsZ6T4fchxQ5EwFsdEoHUryDf" +
       "CT0ggpDjaZAA5EBXdgWZZgpxAGmKYwFmmJuMvErzYiZk7o+2+yRDd0e8twcY" +
       "/+rjam8CjSEdU1a8J6Vnw0br25968vfOHKjBji9B4cfAiBe3I17MR8xNJhjx" +
       "YjbixcMRC3t7+UAvz0bezi6YmxXQcmD/bn2M+5vdp5557VkgVm58DjD2HKgK" +
       "nWyGiUO7QOXWTwLCWXj+Q/G7pu8snSmcudSeZtSCrPNZczazggfW7tHjenSl" +
       "fi+898/+8tO/8LRzqFGXGOidol/eMlPU1x7nq+dIigxM32H3j79G+M0nP/f0" +
       "o2cK54D2A4sXCIBjwJg8eHyMSxT2iX3jl2G5AQBWHc8SzKxo32KdD3TPiQ9z" +
       "8gm/Pb+/E/D4ZZkE3wOu/k6k89+s9G43S1++FZBs0o6hyI3rT3Lur/ynL/1P" +
       "OGf3vh2+cMSzcUrwxBHdzzq7kGv5nYcyMPYUBdT7zx9if/6D33zvW3MBADUe" +
       "udKAj2YpAXQeTCFg89/53fUfv/C1j/zRmQOh2QuA8wtF05CSA5BZfuH8KSDB" +
       "aK8/pAfYDhMoWCY1j05sy5EN1RBEU8mk9P9deF35N//i/Xds5cAEOfti9OMv" +
       "3sFh/isbhZ/+vbf9nwfzbvakzHcd8uyw2tYg3n3YM+55wiajI3nXVx74pS8I" +
       "vwJMKzBnvpEquYUq5Dwo5JMG5fgfz9OLx8rKWfKQf1T4L9WvIzHGk9IH/uhb" +
       "t02/9S+/nVN7aZBydK5pwX1iK15Z8poEdH/vcU0nBV8H9arPM3/jDvP574Ie" +
       "edCjBOyWP/CAoUkukYxd7Rtu+uq//p1XPPUHZwtn2oXzpiPIbSFXssItQLoV" +
       "Xwc2KnF/6i3byY1vBskdOdTCZeDzjPsvF/+ndpLx1JXFP0sfzpLXXS5UJzU9" +
       "xv6zOQVnAVNed7JNy+d362af+9VHvvTO5x75LzmLbjZ8EKDhnnYFv3+kzbc+" +
       "+cI3vnLbA5/Kzcg5UfBzI33+eMB0eTx0SZiTY771AOj9Ga6HLvd6s2t0S6CZ" +
       "lcm64+HgLheofY/3o+o6E8nHTgnsPcMCZiraBUPQ03e9sPrlP/u1baBzPHI6" +
       "Vll55tmf/cHF9z975kh4+chlEd7RNtsQM2f2bVtm/wD87YHr+9mVMTnL2DL7" +
       "LmIX57zmINBx3QzOw6eRlQ/R/h+ffvqzH3v6vVsYd10aXbXA4uHX/sP3fv/i" +
       "h77+xSu4dmDSHSE4kOG9rYk9nYvtTNQOXdt9/3dgiu/+07+6zHjkHvkKjD3W" +
       "noc++cv3E2/+Rt7+0DVmrR9MLg9agJoctq18wvrfZ1574+fPFG7iC3dIu0XS" +
       "VDDDzOHwQBH8/ZUTWEhdUn5pkL+NaJ84cP2vPj6zR4Y97pQPOQrus9q5Th4a" +
       "ykayV8gtxmRrZvL00Sx5Q87uM9ntj2VzYdiCmbejgJMzFVsL9LxyK8/b2rZe" +
       "UDgL1Du7xd3kYObObLvKn+8Jdi4lgwaWDY6tZN5pv2wbnRnOxYMlGyhMriAD" +
       "j58sA3RuTg4n4gvv/vP7x2/Wn7qKsOyhYxN7vMuP05/8Yuf10s+dKZw9mJbL" +
       "1nOXNnri0sk47ylgAWqPL5mSB7ZTkvPviNnPOXyKQzVOKVtliQomUMpYvZ2Z" +
       "U6rbSe5F8Czh85w3n1I7l5x6XlTJkp/YzhRyTd4w3Vn69Oq94UlNT/CG2fNP" +
       "HfRya9boAuiN2Xay/Q0K0rX6A9f1IT/SRBAK+4oHMY6ssIa0UjxWsBVz3+38" +
       "dQyTs5C/TJuyZzZL3r5vDd55mjXIkvnWFGTJIu80S9LLdT57fFuWPHW5EmfP" +
       "0nbYvHWWaKdI23tOKXsmS34mS8wtJafU/dmtjKeHMr45pfbfzZLgUMbD6yHj" +
       "z+wE9Zmrl/GTmh6DcJTJB3b1YFncz5fE+WgfPAX7L2XJBw6x/4Orwb6te1/+" +
       "dH4rYwdoXpnVqILrsR2ax44zIl+rXzj0FO0sFvjqN7/44T9507f+ArjjduGG" +
       "KHOVwFjfcViLCbN3f+/55AcfeNmzX39fvjD7ib99V/5G5bkri/TZoHCT6xkR" +
       "CGqAX/Pzd4lHBDwovAznuAndepJvjQZZFnk4RTlP/uGL8YS9dPrvBVdph7p0" +
       "Geqt+n3iyrTu5eq3T9hNtusYu7eu/DGi/ulVEvUqcGE7orATiPrMSyIqOSQK" +
       "P0bUb/wQRL15R9SbTyDqt18SUZuTifoXL52o27Pch8HV3BHVPIGof3UCUUHh" +
       "FtdzAmDWFfkglBKd0Jb9fT195aV6OgJ1gVybQFmP0f38S6c7d2wPgKu9o7t9" +
       "At1fPIWZH90nOH8teQK52+WBye5eXB4h999dJbmPgKuzI7dzArlfeSnkngdx" +
       "j6/I+yR96Rhdf/iidOX9AHMEQqjKRexiKXv+4xNsSS51WfKrl5iQe5em9Oj+" +
       "GmqqeD4IPh9dmtg+F48YsO0L/WNEUi+ZSGAzbz/srO/Y2hPv+28f+P2//8gL" +
       "wGR2901mVvsfAUZNf+a7978le/jTq8Nzf4aHywORvuAHdP6OSZEPIB1bEpwD" +
       "kecPDym4JyGrPoXv//WnIsFr0mg0C61xJR1BImWLOGJuaB1rNeikryVhYK5W" +
       "cWXM05WO0wj0Up0Zh/Vw5WKR6wWWPB/1V6VGs0RXKKrDaloP58Y1fGI4bo3U" +
       "ovZ4OBnH1TKOsJpexan+aIS32m1yE60tBXUrCmrWSFo1ixAmWOspNFegMlpX" +
       "zOlYKmqLnsjQtFtee9SE6dRH65nQSfq+VRL6iWxyiYcj4/LGrEUrFUFKQuC1" +
       "q3JXGdb4wabBC5Vx19FLvanCzJoVk2OooGutNkHAjzsrge27jUW5sZlZaNth" +
       "LaGxsIdmczrj2p5MLtuNwDfp2BF4fEEj08UqaA/CmOlYa0rjFqN+y7LTqSd3" +
       "uEXF79SYQa1mhUhYCTvWhpdoYdPpWezciBnOba0m9RE17bcXQs1ZgQAJHQSb" +
       "CF1v2q657CeKY3Sq/WlpMkFadFqUg7KIlavYhK7pHUJ2LR+tgtUtKoT2mqLK" +
       "JMeXx+GqZxKKz0n6yjX47npayehi3SFHxwI+7IxnkRfgfVdArdm4P/bmjcoM" +
       "W9vSqt3SRhZvypUu5bpcHBZtg17RrCmlM3s8aAZLOq1oTiCVuRrkpxS2rqtT" +
       "tii3zP58WHQm3ihqryYtquGwJbyHl1rCwCqPBLYEa6wgN/EKA0+mxGjaEVsB" +
       "PNNciPdaK6tZZIhkYTU5ZyPJJR+nMM1CrIkFqJt2omUaTiCwUhwjc3QoK93l" +
       "GiHiuOo34pnXbjRprMviWGUzKxmVXtuSV7orLZ0Kmyoyjs8InzNx2LGEdo8Z" +
       "rnpcj4lb0zlXNFi5SroCmw6DUq3VGE8Eq2gLvVkj5KLWfO1iMJgIpDIXqN7M" +
       "gfUhgfepZFBL5zq76M1c0ggRjGR8jO/JZmXtBU28q0lJ0lv7jppO4rEqxZ4g" +
       "18u9YdyMR8tUTJ2m3G8VYaVFLMhOK90wIz6KxBRO1qo9XkIJByRv5tYqaIWe" +
       "TngP3kTBcpGU6q6NhdUGPXMYctQfKowtSIg942W5hDgbiu7SKctRJge7G4P1" +
       "SCj1kbnKlWuD1dodTDbYWhhTuMpIOhqbjYmwRled5cQchQOZx9NpNazUIpeZ" +
       "xGQwKQmaM5fVOV8mZ9zEnc5NLqzVgJaO6iVt1JjGYmjUFduVS4yBQ3GdHzWI" +
       "XojrokpIY3+oQjWIcn0Dt9f4iOMXpZFML+eCMCia/shoaklMLrSWNojgpJfU" +
       "e8NuX1+OUhWlGmQ1Hg5KPbtrcy0qKk3SUmPRWzZ7DEogHOzwLT4JS0VdDged" +
       "odHCIX0cBW1ZT9YpVx5rZaU4lzeziTcOUrlY1eMeH3cYA6VtvLUMHG00gwyK" +
       "bS0JgyhVFw4QWs1qF1vNpTQb6XOxybTdpdnq8B5i82pIeukyWJnVttiZECt8" +
       "FrsMX5ECplge9FpLEitjiNRhg00vnqeRyVvdUYcT6JWPcqtq6IEp5Zvzbg+u" +
       "tAdwV1v0VyKtpCQXNDBjaIkuXU2IAcQs2iEi91SeEGY0RiltiUXlSQ9IW0tF" +
       "YaqX1hDfUh3DqahsGtBxYPZxHOEbQatfEf1Y6kiE3GdgNFS9oIitp/UaqtJ0" +
       "BR6uiNks6CmGTVcnQ5m3AzkeBqyXJpEbcXU4CmFmzgKZIoa8Ti06Sl+VB7XF" +
       "bNyxmFElmvByb9LXWSYZcIY5dZe9aKH1VuyAm0ujJKoWYT02KmtJbrCaIa/T" +
       "FQuRFWfVKa1swq2TLNv24rqCj2FpEYxTqGJW63HIMP0RUvZSpWh5zGTqeUQ6" +
       "0tFFR9/A8KzBEWFFgetMGVbnpBdgLXXECym9ghdNlpM1fbxo9fDiIoSiAcc7" +
       "G8hXNmupptJDDZqgncWg1EWmo5YfdKcLgqMZ110u4yFmchShaGVgALxqt96z" +
       "N/32lHLGaFovuwiWRiIUeg256LS63YoDW8s62pikiNkR7dpqERUZvgy3kG4S" +
       "ziexhKy7nSY2QEWbYXpT3SSYcjJiGCatruBhzwPKoXGJpbM9jVtqpD4yo1Z9" +
       "XBRL1ZkS2oOR3Vkj9riOqZ7NOSaGVNbKoFypAtuJd/tWuTIPZ5X6yOsKjXmo" +
       "K1ypTQ6hzSiUpit7hvdHotIZB0jRm1LFOrFM4aETb/Sy6dpDK6H5udWBxbVf" +
       "DSwVslID8eU+1zea0x5wV4PisEgMl4saga3HE3wxnpoq2x3Hnt40J811KDir" +
       "EWRJuDaqjmxs7E20xZKi6zWH6cLlykYt1vow7dPwajrGtFQQm9EcieKUGNgu" +
       "R2N0feJDU6fW5rAl3ZVXYqO6mcGStUhEPTJ6qSHVJyzkcyikzMFzYsgu1rHN" +
       "sRmzSK8o2i0NrnHNNruhKb3SipFW5PWTegJg+BDMmXHLb6TmGp61lbbmz+mO" +
       "xa7ZaNoeRaMQ5dQaCYXcojmLu/ZyhlbiUQCn6mgzRzdhSTTZ+rQozvviooiW" +
       "kCVcLmLIZh72gnlPF3y12mBtdzxO5mytxJBzG9WD0PWjBjqh/LicyGtUsaqu" +
       "zcuaBI2dVYnnpnBcQcfEpKHN7aHs0O05H5mkVJZhvDIUsUkMq1HcrvZtdp4O" +
       "+bamjRl1Ia4Vmk5pxKmQmkDSTca2ea0kVJgRJkvRwJNjW60VxYnt86WkWI0i" +
       "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" +
       "N+pzZBUEPauHema/iyTjsTafraw+EEev");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
