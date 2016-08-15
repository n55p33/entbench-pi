package org.apache.batik.ext.awt.image.renderable;
public class GaussianBlurRable8Bit extends org.apache.batik.ext.awt.image.renderable.AbstractColorInterpolationRable implements org.apache.batik.ext.awt.image.renderable.GaussianBlurRable {
    private double stdDeviationX;
    private double stdDeviationY;
    public GaussianBlurRable8Bit(org.apache.batik.ext.awt.image.renderable.Filter src,
                                 double stdevX,
                                 double stdevY) { super(src, null);
                                                  setStdDeviationX(
                                                    stdevX);
                                                  setStdDeviationY(
                                                    stdevY); }
    public void setStdDeviationX(double stdDeviationX) { if (stdDeviationX <
                                                               0) {
                                                             throw new java.lang.IllegalArgumentException(
                                                               );
                                                         }
                                                         touch(
                                                           );
                                                         this.
                                                           stdDeviationX =
                                                           stdDeviationX;
    }
    public void setStdDeviationY(double stdDeviationY) { if (stdDeviationY <
                                                               0) {
                                                             throw new java.lang.IllegalArgumentException(
                                                               );
                                                         }
                                                         touch(
                                                           );
                                                         this.
                                                           stdDeviationY =
                                                           stdDeviationY;
    }
    public double getStdDeviationX() { return stdDeviationX;
    }
    public double getStdDeviationY() { return stdDeviationY;
    }
    public void setSource(org.apache.batik.ext.awt.image.renderable.Filter src) {
        init(
          src,
          null);
    }
    static final double DSQRT2PI = java.lang.Math.
      sqrt(
        2 *
          java.lang.Math.
            PI) *
      3.0 /
      4.0;
    public java.awt.geom.Rectangle2D getBounds2D() {
        java.awt.geom.Rectangle2D src =
          getSource(
            ).
          getBounds2D(
            );
        float dX =
          (float)
            (stdDeviationX *
               DSQRT2PI);
        float dY =
          (float)
            (stdDeviationY *
               DSQRT2PI);
        float radX =
          3 *
          dX /
          2;
        float radY =
          3 *
          dY /
          2;
        return new java.awt.geom.Rectangle2D.Float(
          (float)
            (src.
               getMinX(
                 ) -
               radX),
          (float)
            (src.
               getMinY(
                 ) -
               radY),
          (float)
            (src.
               getWidth(
                 ) +
               2 *
               radX),
          (float)
            (src.
               getHeight(
                 ) +
               2 *
               radY));
    }
    public org.apache.batik.ext.awt.image.renderable.Filter getSource() {
        return (org.apache.batik.ext.awt.image.renderable.Filter)
                 getSources(
                   ).
                 get(
                   0);
    }
    public static final double eps = 1.0E-4;
    public static boolean eps_eq(double f1,
                                 double f2) {
        return f1 >=
          f2 -
          eps &&
          f1 <=
          f2 +
          eps;
    }
    public static boolean eps_abs_eq(double f1,
                                     double f2) {
        if (f1 <
              0)
            f1 =
              -f1;
        if (f2 <
              0)
            f2 =
              -f2;
        return eps_eq(
                 f1,
                 f2);
    }
    public java.awt.image.RenderedImage createRendering(java.awt.image.renderable.RenderContext rc) {
        java.awt.RenderingHints rh =
          rc.
          getRenderingHints(
            );
        if (rh ==
              null)
            rh =
              new java.awt.RenderingHints(
                null);
        java.awt.geom.AffineTransform at =
          rc.
          getTransform(
            );
        double sx =
          at.
          getScaleX(
            );
        double sy =
          at.
          getScaleY(
            );
        double shx =
          at.
          getShearX(
            );
        double shy =
          at.
          getShearY(
            );
        double tx =
          at.
          getTranslateX(
            );
        double ty =
          at.
          getTranslateY(
            );
        double scaleX =
          java.lang.Math.
          sqrt(
            sx *
              sx +
              shy *
              shy);
        double scaleY =
          java.lang.Math.
          sqrt(
            sy *
              sy +
              shx *
              shx);
        double sdx =
          stdDeviationX *
          scaleX;
        double sdy =
          stdDeviationY *
          scaleY;
        java.awt.geom.AffineTransform srcAt;
        java.awt.geom.AffineTransform resAt;
        int outsetX;
        int outsetY;
        if (sdx <
              10 &&
              sdy <
              10 &&
              eps_eq(
                sdx,
                sdy) &&
              eps_abs_eq(
                sx /
                  scaleX,
                sy /
                  scaleY)) {
            srcAt =
              at;
            resAt =
              null;
            outsetX =
              0;
            outsetY =
              0;
        }
        else {
            if (sdx >
                  10) {
                scaleX =
                  scaleX *
                    10 /
                    sdx;
                sdx =
                  10;
            }
            if (sdy >
                  10) {
                scaleY =
                  scaleY *
                    10 /
                    sdy;
                sdy =
                  10;
            }
            srcAt =
              java.awt.geom.AffineTransform.
                getScaleInstance(
                  scaleX,
                  scaleY);
            resAt =
              new java.awt.geom.AffineTransform(
                sx /
                  scaleX,
                shy /
                  scaleX,
                shx /
                  scaleY,
                sy /
                  scaleY,
                tx,
                ty);
            outsetX =
              1;
            outsetY =
              1;
        }
        java.awt.Shape aoi =
          rc.
          getAreaOfInterest(
            );
        if (aoi ==
              null)
            aoi =
              getBounds2D(
                );
        java.awt.Shape devShape =
          srcAt.
          createTransformedShape(
            aoi);
        java.awt.Rectangle devRect =
          devShape.
          getBounds(
            );
        outsetX +=
          org.apache.batik.ext.awt.image.rendered.GaussianBlurRed8Bit.
            surroundPixels(
              sdx,
              rh);
        outsetY +=
          org.apache.batik.ext.awt.image.rendered.GaussianBlurRed8Bit.
            surroundPixels(
              sdy,
              rh);
        devRect.
          x -=
          outsetX;
        devRect.
          y -=
          outsetY;
        devRect.
          width +=
          2 *
            outsetX;
        devRect.
          height +=
          2 *
            outsetY;
        java.awt.geom.Rectangle2D r;
        try {
            java.awt.geom.AffineTransform invSrcAt =
              srcAt.
              createInverse(
                );
            r =
              invSrcAt.
                createTransformedShape(
                  devRect).
                getBounds2D(
                  );
        }
        catch (java.awt.geom.NoninvertibleTransformException nte) {
            r =
              aoi.
                getBounds2D(
                  );
            r =
              new java.awt.geom.Rectangle2D.Double(
                r.
                  getX(
                    ) -
                  outsetX /
                  scaleX,
                r.
                  getY(
                    ) -
                  outsetY /
                  scaleY,
                r.
                  getWidth(
                    ) +
                  2 *
                  outsetX /
                  scaleX,
                r.
                  getHeight(
                    ) +
                  2 *
                  outsetY /
                  scaleY);
        }
        java.awt.image.RenderedImage ri;
        ri =
          getSource(
            ).
            createRendering(
              new java.awt.image.renderable.RenderContext(
                srcAt,
                r,
                rh));
        if (ri ==
              null)
            return null;
        org.apache.batik.ext.awt.image.rendered.CachableRed cr =
          convertSourceCS(
            ri);
        if (!devRect.
              equals(
                cr.
                  getBounds(
                    ))) {
            cr =
              new org.apache.batik.ext.awt.image.rendered.PadRed(
                cr,
                devRect,
                org.apache.batik.ext.awt.image.PadMode.
                  ZERO_PAD,
                rh);
        }
        cr =
          new org.apache.batik.ext.awt.image.rendered.GaussianBlurRed8Bit(
            cr,
            sdx,
            sdy,
            rh);
        if (resAt !=
              null &&
              !resAt.
              isIdentity(
                ))
            cr =
              new org.apache.batik.ext.awt.image.rendered.AffineRed(
                cr,
                resAt,
                rh);
        return cr;
    }
    public java.awt.Shape getDependencyRegion(int srcIndex,
                                              java.awt.geom.Rectangle2D outputRgn) {
        if (srcIndex !=
              0)
            outputRgn =
              null;
        else {
            float dX =
              (float)
                (stdDeviationX *
                   DSQRT2PI);
            float dY =
              (float)
                (stdDeviationY *
                   DSQRT2PI);
            float radX =
              3 *
              dX /
              2;
            float radY =
              3 *
              dY /
              2;
            outputRgn =
              new java.awt.geom.Rectangle2D.Float(
                (float)
                  (outputRgn.
                     getMinX(
                       ) -
                     radX),
                (float)
                  (outputRgn.
                     getMinY(
                       ) -
                     radY),
                (float)
                  (outputRgn.
                     getWidth(
                       ) +
                     2 *
                     radX),
                (float)
                  (outputRgn.
                     getHeight(
                       ) +
                     2 *
                     radY));
            java.awt.geom.Rectangle2D bounds =
              getBounds2D(
                );
            if (!outputRgn.
                  intersects(
                    bounds))
                return new java.awt.geom.Rectangle2D.Float(
                  );
            outputRgn =
              outputRgn.
                createIntersection(
                  bounds);
        }
        return outputRgn;
    }
    public java.awt.Shape getDirtyRegion(int srcIndex,
                                         java.awt.geom.Rectangle2D inputRgn) {
        java.awt.geom.Rectangle2D dirtyRegion =
          null;
        if (srcIndex ==
              0) {
            float dX =
              (float)
                (stdDeviationX *
                   DSQRT2PI);
            float dY =
              (float)
                (stdDeviationY *
                   DSQRT2PI);
            float radX =
              3 *
              dX /
              2;
            float radY =
              3 *
              dY /
              2;
            inputRgn =
              new java.awt.geom.Rectangle2D.Float(
                (float)
                  (inputRgn.
                     getMinX(
                       ) -
                     radX),
                (float)
                  (inputRgn.
                     getMinY(
                       ) -
                     radY),
                (float)
                  (inputRgn.
                     getWidth(
                       ) +
                     2 *
                     radX),
                (float)
                  (inputRgn.
                     getHeight(
                       ) +
                     2 *
                     radY));
            java.awt.geom.Rectangle2D bounds =
              getBounds2D(
                );
            if (!inputRgn.
                  intersects(
                    bounds))
                return new java.awt.geom.Rectangle2D.Float(
                  );
            dirtyRegion =
              inputRgn.
                createIntersection(
                  bounds);
        }
        return dirtyRegion;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Qc3inmMWTaY62HSjdCtKrcJn9P3h6L4f3LfvBlOq5vz0vwmq2wd++e8XQne+" +
       "/VyRbFKZUMHoTR8/F90gF/Tn52+PqVPvjQ0/vKW5rA/iTT+pzijS7gztT7iZ" +
       "QslnZOKu/XJqMd7h1g73BvLRatgG7Pgsb9dzWc7JSUS4RISPDWCz0nDH3vwt" +
       "c5X2MfGWVz6oH/3giRNc7fyzgTvUbBU0E/MmbFYh5ou8uXGLYIwD3bnHBq9o" +
       "lI+dBI5jwFGEusDYpoMrZPMCk0VdUfXrHz+5cOeLZSTYR2pkVUj0CTzGkzkQ" +
       "XKkxDsk+q118iRlbpqqhaeSqkgLlCzrQv5cXjxyb0hrjvr730UXfu+DeQ2/y" +
       "IKeZPJbw+eVYf+QldX7CdPLK/S9/5hf3fu32KdOkSjiIZ17LP7fJ8eve+agA" +
       "cp5Gi/iMZ/5Y+MhdrZGL3uXznXyGszuzhTUT1ATO3HX3p/8e7Kh8Kkiqxkij" +
       "aJ3oRgU5g1liDE4xhn3Mg1Nf3nj+icQsv7tz+Xqp12ldy3ozqdsRylme0TvJ" +
       "sw63cAU8a628stabPAOEv1zBp5zJ29XYnG3nqipNl+DUTz3JqrYEU0bqDZbo" +
       "pZMS35LPc5czszS2l2Jzpclv0NcoRwuV2GCtt8FHCTO4nIlNrFBav9keaS8v" +
       "Jm3y9KVtwt4eeDRrPc1HWrk45EEIlQY/pTPYcEkRZA/yjSV4M1LdO/K54e3r" +
       "hvqLqZE+fTVasBdPTzdaS91YoAbG7kYeGdCYQ708vl/z3Z8MdE2cLAe/6iUV" +
       "k2jz2TyywQzeOHz5yMFltdNv38wjxsWtG955d2nkbOQ7WRyVMnwNYcNX3+3B" +
       "ZFEJQRkpo5pRDI6pEnBkHVs6K7cW/6kk1nHS/u0u05zIF7BLnO7/4RiFKWKZ" +
       "3+0BT8mHr5s+lNh2z9qglbh6GMR8VTtbppNUdolTh5zyAvFWfl/iRLU35t76" +
       "28c6Uz0zOVhhX9spjk7493KwgdX+sd0ryjPX/al1+0XjO2dwRlruQcnL8ttb" +
       "jzy3eZV4a5BfDpnhtuBSKX9Sd36QrdEpy+hKfn1xRv45BWNLxLKNiNdhHOvz" +
       "mFWu+veb6ilUrNLJqWRuK1HJHMTmAIOylbIRd1Tm1Bda1R/+2shI+aQqJRwH" +
       "+eqp4kXpygE7tpuud1MhTkOWskMzx8lv6qlw+lYJnO7B5lAhTjwf3OFg8s1Z" +
       "wKQZxzrg2WEptmPmmPhNLaHyQyXGHsbmOwBHymM2HE0HjiOzCUfc0ik+czj8" +
       "ppZQ+fESYz/C5tFCOC73wPHYbHnMSngkSydp5nD4TfX3mA2c609LYPICNk9B" +
       "vkGP4XeXHld5ehbAWGTbRsbSKDNzMPymltD11RJjr2HzEiO1YBs9akZJGOt6" +
       "7eS/mBc+mOxTVE2HhqHchyJIphYFh+nl2XKhJfBcb+l6/cxh8ptaAorflxg7" +
       "js1vwFxSbnPZ4ODwzizg0Ipj7fDcbClzcwkcCkpxfDWLTk+92VSCoweCoMOK" +
       "159mJvpbCaA+xOYvcAyAsjVGd3Oa87Cx8rQnZ1fFVVWmglLMiTdnHXjfny14" +
       "O+E5YIFx4BOD14/j6cAbqPKHNzAHGzjY1iC8QhwhRrKPckgFgrOA1GIc+xQ8" +
       "05Ze0yWQ8nFIv6nFg7gdgs7MhaCC88Ywf7W+BnNw5pcArgWbBkYaRJ0KjJqT" +
       "JSVlL7TUs5BJQBP9+JeDbuMsoNtk2WFglcnT/D0jdH2nFje4U3llmWR94y/w" +
       "SGxf54CuLAH2GmzaGZkH0bKXagilIu4Zpin7GASAz80BPjIuaC6IV8wWxMtB" +
       "iwELp4GZQ+w31denA6sctM4vgVY3NucCIoiWpDMLKOwNObCs/yRgyTKyoOjn" +
       "TrwobSn4fwzzfwjEBw81VC86dNmr/HCd+85fB8fkZEaW3Vd5rvdKTadJieNa" +
       "Z17s8evrQISRrtO+VGB4cLX/QKUCPSaXPkbaSnNhpEKyfdee1c9Ii98ssHpo" +
       "3dRRRuYXo8Y7mWwe5Taorb2UsD7/7aYbBn0cOkiS5oub5DLgDiT4OqrZvtJ/" +
       "+rcwG+MG0wWRRVQZP5MyqsOu8mrfvJMxI+sSt53wBLvgVOaVm+L+dIhi8H/2" +
       "sS8uMua/+8TEo4cGBq8+seEe89OlKAt79yKX2iipMr+icqZ4+bHCl5vNq3JL" +
       "18m5D81ZaV8TNZkCOy67xFWAbAcX1dCcWz3f9YzO3Oe91w5f8MTP9le+FCSB" +
       "HSQgQKDaUXixndUyOlm2I1r4gWdU0PkHx+6ub+y5aE3y/df5RSAxPwgt9aeP" +
       "ia/ce+XLt7YcbguS2n6wT9i1LL9x792jQHU9qY+ResnYlAURgYskyHlfj+ai" +
       "5wmYtDguFpz1uV788M1IR+G3s8J/F6iR1Smq83of2dRHSa3TY+6M5/4oo2me" +
       "CU6PtZXY9pmJBHcDDDkW3app9qfFyiqNR6HNvpklIPFXfNv1X4ZGJgkIKAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "gri3uv/9Dlj/R5F8L6lc1IP4uh6e5Wgu");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("Kb7v6LJ3jP+/3i3+q+B55QD/K3/a+M+duz3+c2UQ+EdJ5YECv6wUMihyfnAM" +
       "9o/vAuy7isz3gufGAdgbb44mn7s5Svzxowl5S1TIl68HF5NLxG+9gzQeLpL7" +
       "ksplNdLlRN9XtjzjsKMnTnW0J9A1uvg6Etm5++9CZA8f6Me59+zr7n/vXmQH" +
       "qnGWgl+wvPL+2b8pZfDkHeTzXJE8llTeBixDVw8K9J6643XjMLoFMnroSEZT" +
       "Uw5OSOVddyuVpyvF4fheKsybKpWCvaeORXDtDiIoLhacewHALERgRckB+iL3" +
       "6jHWF98I1m1SeceZN12La3uP3XIVf399XP3lVy/f9+irs39VXvY8uuJ9/7By" +
       "3yp1nJMXfk68XwwifWWVorh/f/0nKFG1ksoLr3uplRSLicOPAs255r6VP5NU" +
       "nrpzK0nlXutwrhzWen9Seex2tYBygvQk9YeSytvPoi7ujmxvoiRADHaaEvRf" +
       "/p6kIwGeYzrgCvYvJ0lo0DogKV6Z4FDR6de/Nu0ocRLJakL4TnGpN9EjMKpl" +
       "VLhfqe4t2WMndb+0vY/8KDU6qnLyomvBRvl/HoeLyXT/nx7X1a+8yox/6vvN" +
       "X9hftFUdOc+LVu4bVi7t7/yWjRYL0mdv29phWxepF3740Ffvf/5w8fzQnuHj" +
       "eXiCt6fPvtXac4OkvIea/4NHf+Un/9arv19eH/p/5PtK+oAzAAA=");
}
