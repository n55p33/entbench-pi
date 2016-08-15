package org.apache.batik.ext.awt.image.rendered;
public class SpecularLightingRed extends org.apache.batik.ext.awt.image.rendered.AbstractTiledRed {
    private double ks;
    private double specularExponent;
    private org.apache.batik.ext.awt.image.Light light;
    private org.apache.batik.ext.awt.image.rendered.BumpMap bumpMap;
    private double scaleX;
    private double scaleY;
    private java.awt.Rectangle litRegion;
    private boolean linear;
    public SpecularLightingRed(double ks, double specularExponent, org.apache.batik.ext.awt.image.Light light,
                               org.apache.batik.ext.awt.image.rendered.BumpMap bumpMap,
                               java.awt.Rectangle litRegion,
                               double scaleX,
                               double scaleY,
                               boolean linear) { super();
                                                 this.ks =
                                                   ks;
                                                 this.specularExponent =
                                                   specularExponent;
                                                 this.light =
                                                   light;
                                                 this.bumpMap =
                                                   bumpMap;
                                                 this.litRegion =
                                                   litRegion;
                                                 this.scaleX =
                                                   scaleX;
                                                 this.scaleY =
                                                   scaleY;
                                                 this.linear =
                                                   linear;
                                                 java.awt.image.ColorModel cm;
                                                 if (linear)
                                                     cm =
                                                       org.apache.batik.ext.awt.image.GraphicsUtil.
                                                         Linear_sRGB_Unpre;
                                                 else
                                                     cm =
                                                       org.apache.batik.ext.awt.image.GraphicsUtil.
                                                         sRGB_Unpre;
                                                 int tw =
                                                   litRegion.
                                                     width;
                                                 int th =
                                                   litRegion.
                                                     height;
                                                 int defSz =
                                                   org.apache.batik.ext.awt.image.rendered.AbstractTiledRed.
                                                   getDefaultTileSize(
                                                     );
                                                 if (tw >
                                                       defSz)
                                                     tw =
                                                       defSz;
                                                 if (th >
                                                       defSz)
                                                     th =
                                                       defSz;
                                                 java.awt.image.SampleModel sm =
                                                   cm.
                                                   createCompatibleSampleModel(
                                                     tw,
                                                     th);
                                                 init(
                                                   (org.apache.batik.ext.awt.image.rendered.CachableRed)
                                                     null,
                                                   litRegion,
                                                   cm,
                                                   sm,
                                                   litRegion.
                                                     x,
                                                   litRegion.
                                                     y,
                                                   null);
    }
    public java.awt.image.WritableRaster copyData(java.awt.image.WritableRaster wr) {
        copyToRaster(
          wr);
        return wr;
    }
    public void genRect(java.awt.image.WritableRaster wr) {
        final double scaleX =
          this.
            scaleX;
        final double scaleY =
          this.
            scaleY;
        final double[] lightColor =
          light.
          getColor(
            linear);
        final int w =
          wr.
          getWidth(
            );
        final int h =
          wr.
          getHeight(
            );
        final int minX =
          wr.
          getMinX(
            );
        final int minY =
          wr.
          getMinY(
            );
        final java.awt.image.DataBufferInt db =
          (java.awt.image.DataBufferInt)
            wr.
            getDataBuffer(
              );
        final int[] pixels =
          db.
          getBankData(
            )[0];
        final java.awt.image.SinglePixelPackedSampleModel sppsm;
        sppsm =
          (java.awt.image.SinglePixelPackedSampleModel)
            wr.
            getSampleModel(
              );
        final int offset =
          db.
          getOffset(
            ) +
          sppsm.
          getOffset(
            minX -
              wr.
              getSampleModelTranslateX(
                ),
            minY -
              wr.
              getSampleModelTranslateY(
                ));
        final int scanStride =
          sppsm.
          getScanlineStride(
            );
        final int adjust =
          scanStride -
          w;
        int p =
          offset;
        int a =
          0;
        int i =
          0;
        int j =
          0;
        double x =
          scaleX *
          minX;
        double y =
          scaleY *
          minY;
        double norm =
          0;
        int pixel =
          0;
        int tmp;
        double mult;
        mult =
          lightColor[0] >
            lightColor[1]
            ? lightColor[0]
            : lightColor[1];
        mult =
          mult >
            lightColor[2]
            ? mult
            : lightColor[2];
        double scale =
          255 /
          mult;
        pixel =
          (int)
            (lightColor[0] *
               scale +
               0.5);
        tmp =
          (int)
            (lightColor[1] *
               scale +
               0.5);
        pixel =
          pixel <<
            8 |
            tmp;
        tmp =
          (int)
            (lightColor[2] *
               scale +
               0.5);
        pixel =
          pixel <<
            8 |
            tmp;
        mult *=
          255 *
            ks;
        final double[][][] NA =
          bumpMap.
          getNormalArray(
            minX,
            minY,
            w,
            h);
        if (light instanceof org.apache.batik.ext.awt.image.SpotLight) {
            org.apache.batik.ext.awt.image.SpotLight slight =
              (org.apache.batik.ext.awt.image.SpotLight)
                light;
            final double[][] LA =
              new double[w][4];
            for (i =
                   0;
                 i <
                   h;
                 i++) {
                final double[][] NR =
                  NA[i];
                slight.
                  getLightRow4(
                    x,
                    y +
                      i *
                      scaleY,
                    scaleX,
                    w,
                    NR,
                    LA);
                for (j =
                       0;
                     j <
                       w;
                     j++) {
                    final double[] N =
                      NR[j];
                    final double[] L =
                      LA[j];
                    double vs =
                      L[3];
                    if (vs ==
                          0) {
                        a =
                          0;
                    }
                    else {
                        L[2] +=
                          1;
                        norm =
                          L[0] *
                            L[0] +
                            L[1] *
                            L[1] +
                            L[2] *
                            L[2];
                        norm =
                          java.lang.Math.
                            sqrt(
                              norm);
                        double dot =
                          N[0] *
                          L[0] +
                          N[1] *
                          L[1] +
                          N[2] *
                          L[2];
                        vs =
                          vs *
                            java.lang.Math.
                            pow(
                              dot /
                                norm,
                              specularExponent);
                        a =
                          (int)
                            (mult *
                               vs +
                               0.5);
                        if ((a &
                               -256) !=
                              0)
                            a =
                              (a &
                                 -2147483648) !=
                                0
                                ? 0
                                : 255;
                    }
                    pixels[p++] =
                      a <<
                        24 |
                        pixel;
                }
                p +=
                  adjust;
            }
        }
        else
            if (!light.
                  isConstant(
                    )) {
                final double[][] LA =
                  new double[w][4];
                for (i =
                       0;
                     i <
                       h;
                     i++) {
                    final double[][] NR =
                      NA[i];
                    light.
                      getLightRow(
                        x,
                        y +
                          i *
                          scaleY,
                        scaleX,
                        w,
                        NR,
                        LA);
                    for (j =
                           0;
                         j <
                           w;
                         j++) {
                        final double[] N =
                          NR[j];
                        final double[] L =
                          LA[j];
                        L[2] +=
                          1;
                        norm =
                          L[0] *
                            L[0] +
                            L[1] *
                            L[1] +
                            L[2] *
                            L[2];
                        norm =
                          java.lang.Math.
                            sqrt(
                              norm);
                        double dot =
                          N[0] *
                          L[0] +
                          N[1] *
                          L[1] +
                          N[2] *
                          L[2];
                        norm =
                          java.lang.Math.
                            pow(
                              dot /
                                norm,
                              specularExponent);
                        a =
                          (int)
                            (mult *
                               norm +
                               0.5);
                        if ((a &
                               -256) !=
                              0)
                            a =
                              (a &
                                 -2147483648) !=
                                0
                                ? 0
                                : 255;
                        pixels[p++] =
                          a <<
                            24 |
                            pixel;
                    }
                    p +=
                      adjust;
                }
            }
            else {
                final double[] L =
                  new double[3];
                light.
                  getLight(
                    0,
                    0,
                    0,
                    L);
                L[2] +=
                  1;
                norm =
                  java.lang.Math.
                    sqrt(
                      L[0] *
                        L[0] +
                        L[1] *
                        L[1] +
                        L[2] *
                        L[2]);
                if (norm >
                      0) {
                    L[0] /=
                      norm;
                    L[1] /=
                      norm;
                    L[2] /=
                      norm;
                }
                for (i =
                       0;
                     i <
                       h;
                     i++) {
                    final double[][] NR =
                      NA[i];
                    for (j =
                           0;
                         j <
                           w;
                         j++) {
                        final double[] N =
                          NR[j];
                        a =
                          (int)
                            (mult *
                               java.lang.Math.
                               pow(
                                 N[0] *
                                   L[0] +
                                   N[1] *
                                   L[1] +
                                   N[2] *
                                   L[2],
                                 specularExponent) +
                               0.5);
                        if ((a &
                               -256) !=
                              0)
                            a =
                              (a &
                                 -2147483648) !=
                                0
                                ? 0
                                : 255;
                        pixels[p++] =
                          a <<
                            24 |
                            pixel;
                    }
                    p +=
                      adjust;
                }
            }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "mwv5r7/9V97zc698vdyt/r9AY6f9pikAAA==");
}
