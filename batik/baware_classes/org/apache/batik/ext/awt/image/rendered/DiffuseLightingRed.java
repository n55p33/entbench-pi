package org.apache.batik.ext.awt.image.rendered;
public class DiffuseLightingRed extends org.apache.batik.ext.awt.image.rendered.AbstractRed {
    private double kd;
    private org.apache.batik.ext.awt.image.Light light;
    private org.apache.batik.ext.awt.image.rendered.BumpMap bumpMap;
    private double scaleX;
    private double scaleY;
    private java.awt.Rectangle litRegion;
    private boolean linear;
    public DiffuseLightingRed(double kd, org.apache.batik.ext.awt.image.Light light,
                              org.apache.batik.ext.awt.image.rendered.BumpMap bumpMap,
                              java.awt.Rectangle litRegion,
                              double scaleX,
                              double scaleY,
                              boolean linear) { super();
                                                this.kd =
                                                  kd;
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
                                                        Linear_sRGB_Pre;
                                                else
                                                    cm =
                                                      org.apache.batik.ext.awt.image.GraphicsUtil.
                                                        sRGB_Pre;
                                                java.awt.image.SampleModel sm =
                                                  cm.
                                                  createCompatibleSampleModel(
                                                    litRegion.
                                                      width,
                                                    litRegion.
                                                      height);
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
        int r =
          0;
        int g =
          0;
        int b =
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
        double NL =
          0;
        final double[][][] NA =
          bumpMap.
          getNormalArray(
            minX,
            minY,
            w,
            h);
        if (!light.
              isConstant(
                )) {
            final double[][] LA =
              new double[w][3];
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
                    NL =
                      255.0 *
                        kd *
                        (N[0] *
                           L[0] +
                           N[1] *
                           L[1] +
                           N[2] *
                           L[2]);
                    r =
                      (int)
                        (NL *
                           lightColor[0]);
                    g =
                      (int)
                        (NL *
                           lightColor[1]);
                    b =
                      (int)
                        (NL *
                           lightColor[2]);
                    if ((r &
                           -256) !=
                          0)
                        r =
                          (r &
                             -2147483648) !=
                            0
                            ? 0
                            : 255;
                    if ((g &
                           -256) !=
                          0)
                        g =
                          (g &
                             -2147483648) !=
                            0
                            ? 0
                            : 255;
                    if ((b &
                           -256) !=
                          0)
                        b =
                          (b &
                             -2147483648) !=
                            0
                            ? 0
                            : 255;
                    pixels[p++] =
                      -16777216 |
                        r <<
                        16 |
                        g <<
                        8 |
                        b;
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
                    NL =
                      255.0 *
                        kd *
                        (N[0] *
                           L[0] +
                           N[1] *
                           L[1] +
                           N[2] *
                           L[2]);
                    r =
                      (int)
                        (NL *
                           lightColor[0]);
                    g =
                      (int)
                        (NL *
                           lightColor[1]);
                    b =
                      (int)
                        (NL *
                           lightColor[2]);
                    if ((r &
                           -256) !=
                          0)
                        r =
                          (r &
                             -2147483648) !=
                            0
                            ? 0
                            : 255;
                    if ((g &
                           -256) !=
                          0)
                        g =
                          (g &
                             -2147483648) !=
                            0
                            ? 0
                            : 255;
                    if ((b &
                           -256) !=
                          0)
                        b =
                          (b &
                             -2147483648) !=
                            0
                            ? 0
                            : 255;
                    pixels[p++] =
                      -16777216 |
                        r <<
                        16 |
                        g <<
                        8 |
                        b;
                }
                p +=
                  adjust;
            }
        }
        return wr;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "hhwAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "B5VO9nOSJwAA");
}
