package org.apache.batik.ext.awt.image.rendered;
public class ColorMatrixRed extends org.apache.batik.ext.awt.image.rendered.AbstractRed {
    private float[][] matrix;
    public float[][] getMatrix() { return copyMatrix(matrix); }
    public void setMatrix(float[][] matrix) { float[][] tmp = copyMatrix(
                                                                matrix);
                                              if (tmp == null) { throw new java.lang.IllegalArgumentException(
                                                                   );
                                              }
                                              if (tmp.length != 4) {
                                                  throw new java.lang.IllegalArgumentException(
                                                    );
                                              }
                                              for (int i =
                                                     0; i <
                                                          4;
                                                   i++) {
                                                  if (tmp[i].
                                                        length !=
                                                        5) {
                                                      throw new java.lang.IllegalArgumentException(
                                                        java.lang.String.
                                                          valueOf(
                                                            i) +
                                                        " : " +
                                                        tmp[i].
                                                          length);
                                                  }
                                              }
                                              this.
                                                matrix =
                                                matrix;
    }
    private float[][] copyMatrix(float[][] m) { if (m ==
                                                      null) {
                                                    return null;
                                                }
                                                float[][] cm =
                                                  new float[m.
                                                              length][];
                                                for (int i =
                                                       0;
                                                     i <
                                                       m.
                                                         length;
                                                     i++) {
                                                    if (m[i] !=
                                                          null) {
                                                        cm[i] =
                                                          (new float[m[i].
                                                                       length]);
                                                        java.lang.System.
                                                          arraycopy(
                                                            m[i],
                                                            0,
                                                            cm[i],
                                                            0,
                                                            m[i].
                                                              length);
                                                    }
                                                }
                                                return cm;
    }
    public ColorMatrixRed(org.apache.batik.ext.awt.image.rendered.CachableRed src,
                          float[][] matrix) {
        super(
          );
        setMatrix(
          matrix);
        java.awt.image.ColorModel srcCM =
          src.
          getColorModel(
            );
        java.awt.color.ColorSpace srcCS =
          null;
        if (srcCM !=
              null)
            srcCS =
              srcCM.
                getColorSpace(
                  );
        java.awt.image.ColorModel cm;
        if (srcCS ==
              null)
            cm =
              org.apache.batik.ext.awt.image.GraphicsUtil.
                Linear_sRGB_Unpre;
        else {
            if (srcCS ==
                  java.awt.color.ColorSpace.
                  getInstance(
                    java.awt.color.ColorSpace.
                      CS_LINEAR_RGB))
                cm =
                  org.apache.batik.ext.awt.image.GraphicsUtil.
                    Linear_sRGB_Unpre;
            else
                cm =
                  org.apache.batik.ext.awt.image.GraphicsUtil.
                    sRGB_Unpre;
        }
        java.awt.image.SampleModel sm =
          cm.
          createCompatibleSampleModel(
            src.
              getWidth(
                ),
            src.
              getHeight(
                ));
        init(
          src,
          src.
            getBounds(
              ),
          cm,
          sm,
          src.
            getTileGridXOffset(
              ),
          src.
            getTileGridYOffset(
              ),
          null);
    }
    public java.awt.image.WritableRaster copyData(java.awt.image.WritableRaster wr) {
        org.apache.batik.ext.awt.image.rendered.CachableRed src =
          (org.apache.batik.ext.awt.image.rendered.CachableRed)
            getSources(
              ).
            get(
              0);
        wr =
          src.
            copyData(
              wr);
        java.awt.image.ColorModel cm =
          src.
          getColorModel(
            );
        org.apache.batik.ext.awt.image.GraphicsUtil.
          coerceData(
            wr,
            cm,
            false);
        final int minX =
          wr.
          getMinX(
            );
        final int minY =
          wr.
          getMinY(
            );
        final int w =
          wr.
          getWidth(
            );
        final int h =
          wr.
          getHeight(
            );
        java.awt.image.DataBufferInt dbf =
          (java.awt.image.DataBufferInt)
            wr.
            getDataBuffer(
              );
        final int[] pixels =
          dbf.
          getBankData(
            )[0];
        java.awt.image.SinglePixelPackedSampleModel sppsm;
        sppsm =
          (java.awt.image.SinglePixelPackedSampleModel)
            wr.
            getSampleModel(
              );
        final int offset =
          dbf.
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
          ((java.awt.image.SinglePixelPackedSampleModel)
             wr.
             getSampleModel(
               )).
          getScanlineStride(
            );
        final int adjust =
          scanStride -
          w;
        int p =
          offset;
        int i =
          0;
        int j =
          0;
        final float a00 =
          matrix[0][0] /
          255.0F;
        final float a01 =
          matrix[0][1] /
          255.0F;
        final float a02 =
          matrix[0][2] /
          255.0F;
        final float a03 =
          matrix[0][3] /
          255.0F;
        final float a04 =
          matrix[0][4] /
          255.0F;
        final float a10 =
          matrix[1][0] /
          255.0F;
        final float a11 =
          matrix[1][1] /
          255.0F;
        final float a12 =
          matrix[1][2] /
          255.0F;
        final float a13 =
          matrix[1][3] /
          255.0F;
        final float a14 =
          matrix[1][4] /
          255.0F;
        final float a20 =
          matrix[2][0] /
          255.0F;
        final float a21 =
          matrix[2][1] /
          255.0F;
        final float a22 =
          matrix[2][2] /
          255.0F;
        final float a23 =
          matrix[2][3] /
          255.0F;
        final float a24 =
          matrix[2][4] /
          255.0F;
        final float a30 =
          matrix[3][0] /
          255.0F;
        final float a31 =
          matrix[3][1] /
          255.0F;
        final float a32 =
          matrix[3][2] /
          255.0F;
        final float a33 =
          matrix[3][3] /
          255.0F;
        final float a34 =
          matrix[3][4] /
          255.0F;
        for (i =
               0;
             i <
               h;
             i++) {
            for (j =
                   0;
                 j <
                   w;
                 j++) {
                int pel =
                  pixels[p];
                int a =
                  pel >>>
                  24;
                int r =
                  pel >>
                  16 &
                  255;
                int g =
                  pel >>
                  8 &
                  255;
                int b =
                  pel &
                  255;
                int dr =
                  (int)
                    ((a00 *
                        r +
                        a01 *
                        g +
                        a02 *
                        b +
                        a03 *
                        a +
                        a04) *
                       255.0F);
                int dg =
                  (int)
                    ((a10 *
                        r +
                        a11 *
                        g +
                        a12 *
                        b +
                        a13 *
                        a +
                        a14) *
                       255.0F);
                int db =
                  (int)
                    ((a20 *
                        r +
                        a21 *
                        g +
                        a22 *
                        b +
                        a23 *
                        a +
                        a24) *
                       255.0F);
                int da =
                  (int)
                    ((a30 *
                        r +
                        a31 *
                        g +
                        a32 *
                        b +
                        a33 *
                        a +
                        a34) *
                       255.0F);
                if ((dr &
                       -256) !=
                      0)
                    dr =
                      (dr &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
                if ((dg &
                       -256) !=
                      0)
                    dg =
                      (dg &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
                if ((db &
                       -256) !=
                      0)
                    db =
                      (db &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
                if ((da &
                       -256) !=
                      0)
                    da =
                      (da &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
                pixels[p++] =
                  da <<
                    24 |
                    dr <<
                    16 |
                    dg <<
                    8 |
                    db;
            }
            p +=
              adjust;
        }
        return wr;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "sD2NTS9dDTKfxbfCfj1XBZYjBKRd55oeIvVhdJCHcHs7MHChaLsu483lOWeG" +
       "y0ZNIZ0N60s2XVdQVGxk2ARmzKjRwgW8WcPR8Xyh72sjjA0WrhBaNW/gthgq" +
       "8pO4oyCdyOLnze50RIw37rTVaLXnGtx1e3Rk8zOQBwSqQtCeOWUydUTtuu22" +
       "mItt3FqiqqYpvg4Ptj4mNHduutxtOhwzphSps94yrdhXpbA1o8DSKtJ3ZGdK" +
       "rTSO40Szk1kpNpn6Wp0Iuk2dRrOm13Lr+NxoToYsLuQ6i/LK0nN1boVsszZh" +
       "EIo01Ntmt9v9wXKr4K++uS2MR6rdmpMTMRsXLys+8SZ2KfIzO68ne1vV7xp0" +
       "4RTFmb2tM/tiULlz9+QbHXSpPot89qMvv6IJv9C4erSfSCbQA0kQvt/VM929" +
       "Y4tNOmHjHWX3T4Hr+SM2nr+4xXYq6J37a5XKDoq6ZG/z85fUfbEsfhEwa+oJ" +
       "d7o1d6rYz32n7Z+zPV4QrvpYXwPX+4+Ee/8fj3BXTgnQiuDvXSLhPyiLLwEJ" +
       "42MJ77rzlQW2dir13/4epH6sfPkMuI7aHv7fjNQf+e6k/vIlUn+lLP5JAj2o" +
       "BuH+rob9le9BxOoj7rPg2hyJuPljNezxRuyT1bbo6ef/VWQn1Vd/OU70qOrh" +
       "n1+ig98pi3+WQNdLHfTkRC6ff/tUA199MxrIE+jh86eDyqMOj99xRvFwrk79" +
       "/Cs3rr/zlcW/OBwcOD779sAIum6krnv2G96Z+2thpBsHQz1w+G4QVn9fS6D3" +
       "fpcnI4C0x7eVCK8fevh3CfTU5T0k0H3V/9lW/yGBHn+jVgl0DyjPUv9+Ar39" +
       "btSAEpRnKf8ggW5epATjV/9n6f4z8N9TugS6drg5S/JfQO+ApLz9r+GbPkbS" +
       "VeIkktUEWDO/ch7wT7zk0e/kJWdixHPnPh5Vx1yPvzemh4OuL6pfeIXlf+Rb" +
       "rV84HEFSXbkoyl6uj6D7D6ehTr5ZvvsNezvu69rg+W8//MUH3nMcdR4+MHw6" +
       "+c7w9vTdz/tQXphUJ3SKv/vOv/WBv/7K");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      "71afHP4v9TY4Yn8sAAA=";
}
