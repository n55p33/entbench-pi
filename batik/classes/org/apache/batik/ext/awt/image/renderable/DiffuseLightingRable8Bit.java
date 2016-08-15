package org.apache.batik.ext.awt.image.renderable;
public class DiffuseLightingRable8Bit extends org.apache.batik.ext.awt.image.renderable.AbstractColorInterpolationRable implements org.apache.batik.ext.awt.image.renderable.DiffuseLightingRable {
    private double surfaceScale;
    private double kd;
    private org.apache.batik.ext.awt.image.Light light;
    private java.awt.geom.Rectangle2D litRegion;
    private float[] kernelUnitLength = null;
    public DiffuseLightingRable8Bit(org.apache.batik.ext.awt.image.renderable.Filter src,
                                    java.awt.geom.Rectangle2D litRegion,
                                    org.apache.batik.ext.awt.image.Light light,
                                    double kd,
                                    double surfaceScale,
                                    double[] kernelUnitLength) { super(
                                                                   src,
                                                                   null);
                                                                 setLight(
                                                                   light);
                                                                 setKd(
                                                                   kd);
                                                                 setSurfaceScale(
                                                                   surfaceScale);
                                                                 setLitRegion(
                                                                   litRegion);
                                                                 setKernelUnitLength(
                                                                   kernelUnitLength);
    }
    public org.apache.batik.ext.awt.image.renderable.Filter getSource() {
        return (org.apache.batik.ext.awt.image.renderable.Filter)
                 getSources(
                   ).
                 get(
                   0);
    }
    public void setSource(org.apache.batik.ext.awt.image.renderable.Filter src) {
        init(
          src,
          null);
    }
    public java.awt.geom.Rectangle2D getBounds2D() {
        return (java.awt.geom.Rectangle2D)
                 litRegion.
                 clone(
                   );
    }
    public java.awt.geom.Rectangle2D getLitRegion() {
        return getBounds2D(
                 );
    }
    public void setLitRegion(java.awt.geom.Rectangle2D litRegion) {
        touch(
          );
        this.
          litRegion =
          litRegion;
    }
    public org.apache.batik.ext.awt.image.Light getLight() {
        return light;
    }
    public void setLight(org.apache.batik.ext.awt.image.Light light) {
        touch(
          );
        this.
          light =
          light;
    }
    public double getSurfaceScale() { return surfaceScale;
    }
    public void setSurfaceScale(double surfaceScale) {
        touch(
          );
        this.
          surfaceScale =
          surfaceScale;
    }
    public double getKd() { return kd; }
    public void setKd(double kd) { touch(
                                     );
                                   this.kd =
                                     kd; }
    public double[] getKernelUnitLength() {
        if (kernelUnitLength ==
              null)
            return null;
        double[] ret =
          new double[2];
        ret[0] =
          kernelUnitLength[0];
        ret[1] =
          kernelUnitLength[1];
        return ret;
    }
    public void setKernelUnitLength(double[] kernelUnitLength) {
        touch(
          );
        if (kernelUnitLength ==
              null) {
            this.
              kernelUnitLength =
              null;
            return;
        }
        if (this.
              kernelUnitLength ==
              null)
            this.
              kernelUnitLength =
              (new float[2]);
        this.
          kernelUnitLength[0] =
          (float)
            kernelUnitLength[0];
        this.
          kernelUnitLength[1] =
          (float)
            kernelUnitLength[1];
    }
    public java.awt.image.RenderedImage createRendering(java.awt.image.renderable.RenderContext rc) {
        java.awt.Shape aoi =
          rc.
          getAreaOfInterest(
            );
        if (aoi ==
              null)
            aoi =
              getBounds2D(
                );
        java.awt.geom.Rectangle2D aoiR =
          aoi.
          getBounds2D(
            );
        java.awt.geom.Rectangle2D.
          intersect(
            aoiR,
            getBounds2D(
              ),
            aoiR);
        java.awt.geom.AffineTransform at =
          rc.
          getTransform(
            );
        java.awt.Rectangle devRect =
          at.
          createTransformedShape(
            aoiR).
          getBounds(
            );
        if (devRect.
              width ==
              0 ||
              devRect.
                height ==
              0) {
            return null;
        }
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
        if (scaleX ==
              0 ||
              scaleY ==
              0) {
            return null;
        }
        if (kernelUnitLength !=
              null) {
            if (kernelUnitLength[0] >
                  0 &&
                  scaleX >
                  1 /
                  kernelUnitLength[0])
                scaleX =
                  1 /
                    kernelUnitLength[0];
            if (kernelUnitLength[1] >
                  0 &&
                  scaleY >
                  1 /
                  kernelUnitLength[1])
                scaleY =
                  1 /
                    kernelUnitLength[1];
        }
        java.awt.geom.AffineTransform scale =
          java.awt.geom.AffineTransform.
          getScaleInstance(
            scaleX,
            scaleY);
        devRect =
          scale.
            createTransformedShape(
              aoiR).
            getBounds(
              );
        aoiR.
          setRect(
            aoiR.
              getX(
                ) -
              2 /
              scaleX,
            aoiR.
              getY(
                ) -
              2 /
              scaleY,
            aoiR.
              getWidth(
                ) +
              4 /
              scaleX,
            aoiR.
              getHeight(
                ) +
              4 /
              scaleY);
        rc =
          (java.awt.image.renderable.RenderContext)
            rc.
            clone(
              );
        rc.
          setAreaOfInterest(
            aoiR);
        rc.
          setTransform(
            scale);
        org.apache.batik.ext.awt.image.rendered.CachableRed cr;
        cr =
          org.apache.batik.ext.awt.image.GraphicsUtil.
            wrap(
              getSource(
                ).
                createRendering(
                  rc));
        org.apache.batik.ext.awt.image.rendered.BumpMap bumpMap =
          new org.apache.batik.ext.awt.image.rendered.BumpMap(
          cr,
          surfaceScale,
          scaleX,
          scaleY);
        cr =
          new org.apache.batik.ext.awt.image.rendered.DiffuseLightingRed(
            kd,
            light,
            bumpMap,
            devRect,
            1 /
              scaleX,
            1 /
              scaleY,
            isColorSpaceLinear(
              ));
        java.awt.geom.AffineTransform shearAt =
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
        if (!shearAt.
              isIdentity(
                )) {
            java.awt.RenderingHints rh =
              rc.
              getRenderingHints(
                );
            java.awt.Rectangle padRect =
              new java.awt.Rectangle(
              devRect.
                x -
                1,
              devRect.
                y -
                1,
              devRect.
                width +
                2,
              devRect.
                height +
                2);
            cr =
              new org.apache.batik.ext.awt.image.rendered.PadRed(
                cr,
                padRect,
                org.apache.batik.ext.awt.image.PadMode.
                  REPLICATE,
                rh);
            cr =
              new org.apache.batik.ext.awt.image.rendered.AffineRed(
                cr,
                shearAt,
                rh);
        }
        return cr;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "8f8BXL9Y3mYvAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "qrzxoJHLWbySay0YFSCwA6zm9UUtzkAg");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("HiMzOm1AysLJO7EGYW3KolYYI2YWTXgDW0RsZOGkK0UIml0niAR/lc+6QT6a" +
       "bttdf6ZJ3kQHWfwM5C8yzzChPxjIw45RXW4HOyKExtCMh+zVDCKHDiKFGyL0" +
       "RoxOEdGoCbbikzlvUU6towyCvJs3erQL9SJ1Eztac91GBLmrNavr2Fpseb7h" +
       "xpqktaou4a/8MKzFHWncs3x0lfXqdRqZqNVdR/YGo3jtkxLbG1uSwxCcwLK0" +
       "uR0gbhrhUyLHYJkOhfYupbpVeiVS+TiP4d5wFqzj/lAkJRTW2jBaq7MEJzpz" +
       "oekPkNxNdrypYjuNlA2+IXX6orkYxugQ7bhwQxKdrr5ogoDe6rsrqS2nWFfc" +
       "OB1qDZERoiHYiu4KTVuIURT9YPFK7Vff2Ku+N5dvNY9OS4L4WDR86Q28zUtP" +
       "/N539Da+/LtQOThZd/j/xLv/Ez9InTt8g/qhWztLVvzy9ujNzlKWhzC+8PGX" +
       "XlamX6yfP3ib/MGwck/oet9tqbFqneBofxBKPELzYMH8d4EiHKARTv+ScSyv" +
       "G/+M8Z69vM94s/2vzmj710X1NcCsrob717LFg9qxfv7la71tPTniKXDlWa9n" +
       "QHn+ANzztwfcuWOCWknw6hkI/6CofhcgDA4R3vBFc+wayjHq/3ALqN9RPCx+" +
       "M7vmVMrtVel/P6Ptm0X1R2HlPqBSzI0cJWjgxaPGMbw/vlV4xQE+5wCec/vh" +
       "/ekZbX9WVH8SVu4H8Ohrfk88xvftWzXaJijRAb7othttoyA4d+HmIM9dLKpz" +
       "xc/dp0D+5yOQ587fAsjSkT4MygsHIF+47Uo89+AZbW8tqjeFlYulEg9/pz7G" +
       "9sDt8DqfOMD2iduuwFYJ4rEzAD5RVA8DgMEJgCeU98gtACxjxpOg/OgBwB+9" +
       "/cp73xlt7y+qZ8LKpSJmnD6OcQzxXbeqwxYonz2A+NnbrsNuiQU+AydSVHWA" +
       "M7ge5wlVNm5VlYVH/YkDnD9x+1WJndFWBIZzIFe5C6hypJxS4IduVYFPgPLT" +
       "B8B++i9IgZMz0BVnEM5RAF1wiO6E2oa3gO5txcP3gPJzB+h+7varTTyj7fuK" +
       "ahFW3lKo7dThlYIeO4a5vFUlfi8ov3wA85dvuxKxEo92BtYShQSwBjfGekKl" +
       "61vA+vChSr96gPWrtxVreQ82Iu8+Oud+3caDLS8PvpAroftniCUuKhs4J9lX" +
       "pVDddwb7lcOJ3nlqoj2BqlDF3bHInDcisjSsPHSzT22K7wYeuu6jwP2HbPKX" +
       "Xr508R0vL/7t/vT34cdm99CVi1pkWSeP4564vuD5qmaUQr1nfwrSK5F/NKy8" +
       "93Vv58LiUOnhTQHo3A/uR/l4WHns7FGA3zAOhXXY64eBBG7WK6zcAeqT1J8K" +
       "K2+9ETWgBPVJyk+HlcunKcH85f+TdC8CPMd0YeXC/uIkyV8HowOS4vLgvBOw" +
       "Bur173/RdRD6khyWp8eo4jg+0Gp5gmy/Fd6b8kMnV1G5Dh98LUs66nLyS5uC" +
       "jfKL08NDxdH+m9Pn5C+/PJz8wLfgL+6/9JEtKc+LUS7Slbv3Hx2VgxYHk5+8" +
       "6WiHY10g3/udB37hnmcOd+cP7Bk+XtEneHv8xp/VELYXlh/C5P/4Hf/wA3//" +
       "5d8rT0L9H0G5dqkKPAAA");
}
