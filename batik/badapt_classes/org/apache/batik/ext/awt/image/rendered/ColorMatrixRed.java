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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "xJ3P+/TdIC5P6OT//K3/5N3/8KU/Kj85");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      "/CXfNoWgfywAAA==";
}
