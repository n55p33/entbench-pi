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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "/Q/xaM28Zi8AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAMV7e9Dj1nUfdyWtVg9r17Ity4r1slZ+0VkQIEECkewYIPgA" +
       "CRIkQJAEmlgC8SaexIMAkSp2PEnsqVPXjeXUbRJ1mtptmih2JtNMm+kko06n" +
       "dTLJuJM0faXTKGk70ySuW/uPuJ04bXoBfq/9dveT1N2k38y9H4B77r3nd865" +
       "55wLXrz89cpdUVipBr6zMxw/vqpl8dW1g16Nd4EWXR0w6EQOI01tO3IUzcCz" +
       "55R3/fylb337M+bl85ULUuUtsuf5sRxbvhdxWuQ7W01lKpeOn3YczY3iymVm" +
       "LW9lKIktB2KsKH6Gqdx3omtcucIcsgABFiDAAlSyABHHVKDTmzQvcdtFD9mL" +
       "o03l+yvnmMqFQCnYiytPXjtIIIeyezDMpEQARrhY3M8BqLJzFlaeOMK+x3wd" +
       "4M9VoRf/xkcu/8IdlUtS5ZLl8QU7CmAiBpNIlftdzV1pYUSoqqZKlTd7mqby" +
       "WmjJjpWXfEuVByPL8OQ4CbUjIRUPk0ALyzmPJXe/UmALEyX2wyN4uqU56uHd" +
       "XbojGwDrQ8dY9wi7xXMA8F4LMBbqsqIddrnTtjw1rjx+uscRxitDQAC63u1q" +
       "sekfTXWnJ4MHlQf3unNkz4D4OLQ8A5De5SdglrjyyE0HLWQdyIotG9pzceXh" +
       "03STfROguqcURNElrrztNFk5EtDSI6e0dEI/Xx8/++nv8/re+ZJnVVOcgv+L" +
       "oNNjpzpxmq6Fmqdo+473v5/5MfmhX/7k+UoFEL/tFPGe5h/95W9++AOPvfKr" +
       "e5rvuAENu1prSvyc8oXVA7/5zvb78DsKNi4GfmQVyr8GeWn+k4OWZ7IArLyH" +
       "jkYsGq8eNr7C/QvxYz+jfe185V66ckHxncQFdvRmxXcDy9HCnuZpoRxrKl25" +
       "R/PUdtlOV+4G14zlafunrK5HWkxX7nTKRxf88h6ISAdDFCK6G1xbnu4fXgdy" +
       "bJbXWVCpVO4GpfIUKFcr+78PFFVcSSDTdzVIVmTP8nxoEvoF/gjSvHgFZGtC" +
       "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" +
       "bGTuUjcbai1fGUxm5nhihkTNguJWn+Qp");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("vRaE24Y6dE1opvpun8PlZFsNO6yuSfWUHURromYyrMAptojhI3tiudUdGq5Z" +
       "NMLnUE82pepYQ2aRPknQWUsIImaCBnnUWhtgwcbiNI9HWB+LRFVztlLcUrZQ" +
       "HiyrjUi35qOpEw94miDifNlaLYIhXw1sNJZ83FXYRcqrOracRZN2C8miJQ61" +
       "YEZHNWvB44G+4tWGu+2v1hg8T7zWEBvbrcEibasNRpnrWLMlh+7ObviUxvO+" +
       "LdaFIUdz0qDTZ6u0ZPXZBkbIo37ciJ3cD2pMHR1n0VpptXE6CiFyiC7nUznM" +
       "0dRuzISF4FBg2+AqWJiyMzeRTKXvR3Nk2OoG0XyoT3sEA7Z6IBvEDQXJpoJM" +
       "1WahkggWFBk7vDOuWnVtAk0hsJwQTLIwgiA++MHildqvvLFXfW8u32oenZZc" +
       "O62i4Utv4G1eduL3vqO38eXfhcrBybrD/yfe/Z/4Qerc4RvUD93aWbLil7dH" +
       "b3aWsjyE8YWPv/iSyn4RPn/wNvmDceWe2A++09G2mnOCo/1BKOkIzYMF898B" +
       "iniARjz9S8axvG78M8Z79/I+4832vzqj7V8X1VcBs4YW71/LFg9qx/r5l6/1" +
       "tvXkiKfAlWe9ngbl+QNwz98ecOeOCWolwatnIPz9ovodgDA6RHjDF81b31KP" +
       "Uf+HW0D99uJh8ZvZNadSbq9K//sZbd8oqj+MK/cBlZJ+4qkRQhWPkGN4f3Sr" +
       "8IoDfN4BPO/2w/uTM9r+tKj+OK7cD+Ax1/yeeIzvW7dqtHVQkgN8yW03WqQg" +
       "OHfh5iDPXSyqc8XP3adA/ucjkOfO3wLI0pG+A5QXDkC+cNuVeO7BM9reWlRv" +
       "iisXSyUe/k59jO2B2+F1fvAA2w/edgU2ShCPnQHwiaJ6BwAYnQB4QnmP3ALA" +
       "MmY8CcqPHAD8kduvvPef0faBono6rlwqYsbp4xjHEN99qzpsgPLZA4ifve06" +
       "xEsszTNwYkUFA5zR9ThPqBK5VVUWHvXHD3D++O1XJXlGWxEYzoFc5S6gyqF6" +
       "SoEfulUFPgHKTx0A+6k/JwWOz0BXnEE4RwN00SG6E2ob3AK6txUP3wvKzx6g" +
       "+9nbrzbpjLbvKSohrrylUNupwysFPXkMc36rSvxuUH7pAOYv3XYlkiUe/Qys" +
       "JQoZYI1ujPWESle3gPUdhyr9ygHWr9xWrOU92Ii85+ic+3UbD668PPhCroQe" +
       "niGWbVG5wDkpoSbH2r4z2K8cTvTOUxPtCTSVLu6ORea9EZFlceXhm31qU3w3" +
       "8PB1HwXuP2RTvvTSpYtvf0n4t/vT34cfm93DVC7qieOcPI574vpCEGq6VQr1" +
       "nv0pyKBE/tG48r7XvZ2Li0OlhzcFoHPfvx/l43HlsbNHAX7DOhTWYa8fAhK4" +
       "Wa+4cgeoT1J/Mq689UbUgBLUJyk/FVcun6YE85f/T9J9GuA5posrF/YXJ0n+" +
       "OhgdkBSXB+edgDXQr3//S6yiOJSVuDw9RhfH8YFWyxNk+63w3pQfPrmKynX4" +
       "4GtZ0lGXk1/aFGyUX5weHipO9t+cPqd8+aXB+Pu+2fzi/ksfxZHzvBjlIlO5" +
       "e//RUTlocTD5yZuOdjjWhf77vv3Az9/z9OHu/IE9w8cr+gRvj9/4s5qOG8Tl" +
       "hzD5P377P3z277/0u+VJqP8La4RMvgo8AAA=");
}
