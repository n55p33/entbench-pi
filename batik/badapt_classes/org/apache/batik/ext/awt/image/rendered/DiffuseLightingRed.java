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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "BoYcAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "45lv5fun/wMvNKJ9kicAAA==");
}
