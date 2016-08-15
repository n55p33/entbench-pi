package org.apache.batik.ext.awt.image.rendered;
public class Any2sRGBRed extends org.apache.batik.ext.awt.image.rendered.AbstractRed {
    boolean srcIsLsRGB = false;
    public Any2sRGBRed(org.apache.batik.ext.awt.image.rendered.CachableRed src) {
        super(
          src,
          src.
            getBounds(
              ),
          fixColorModel(
            src),
          fixSampleModel(
            src),
          src.
            getTileGridXOffset(
              ),
          src.
            getTileGridYOffset(
              ),
          null);
        java.awt.image.ColorModel srcCM =
          src.
          getColorModel(
            );
        if (srcCM ==
              null)
            return;
        java.awt.color.ColorSpace srcCS =
          srcCM.
          getColorSpace(
            );
        if (srcCS ==
              java.awt.color.ColorSpace.
              getInstance(
                java.awt.color.ColorSpace.
                  CS_LINEAR_RGB))
            srcIsLsRGB =
              true;
    }
    public static boolean is_INT_PACK_COMP(java.awt.image.SampleModel sm) {
        if (!(sm instanceof java.awt.image.SinglePixelPackedSampleModel))
            return false;
        if (sm.
              getDataType(
                ) !=
              java.awt.image.DataBuffer.
                TYPE_INT)
            return false;
        java.awt.image.SinglePixelPackedSampleModel sppsm;
        sppsm =
          (java.awt.image.SinglePixelPackedSampleModel)
            sm;
        int[] masks =
          sppsm.
          getBitMasks(
            );
        if (masks.
              length !=
              3 &&
              masks.
                length !=
              4)
            return false;
        if (masks[0] !=
              16711680)
            return false;
        if (masks[1] !=
              65280)
            return false;
        if (masks[2] !=
              255)
            return false;
        if (masks.
              length ==
              4 &&
              masks[3] !=
              -16777216)
            return false;
        return true;
    }
    private static final double GAMMA = 2.4;
    private static final int[] linearToSRGBLut = new int[256];
    static { final double scale = 1.0 / 255;
             final double exp = 1.0 / GAMMA;
             for (int i = 0; i < 256; i++) { double value = i * scale;
                                             if (value <= 0.0031308)
                                                 value *=
                                                   12.92;
                                             else
                                                 value =
                                                   1.055 *
                                                     java.lang.Math.
                                                     pow(
                                                       value,
                                                       exp) -
                                                     0.055;
                                             linearToSRGBLut[i] =
                                               (int)
                                                 java.lang.Math.
                                                 round(
                                                   value *
                                                     255.0); } }
    public static java.awt.image.WritableRaster applyLut_INT(java.awt.image.WritableRaster wr,
                                                             final int[] lut) {
        java.awt.image.SinglePixelPackedSampleModel sm =
          (java.awt.image.SinglePixelPackedSampleModel)
            wr.
            getSampleModel(
              );
        java.awt.image.DataBufferInt db =
          (java.awt.image.DataBufferInt)
            wr.
            getDataBuffer(
              );
        final int srcBase =
          db.
          getOffset(
            ) +
          sm.
          getOffset(
            wr.
              getMinX(
                ) -
              wr.
              getSampleModelTranslateX(
                ),
            wr.
              getMinY(
                ) -
              wr.
              getSampleModelTranslateY(
                ));
        final int[] pixels =
          db.
          getBankData(
            )[0];
        final int width =
          wr.
          getWidth(
            );
        final int height =
          wr.
          getHeight(
            );
        final int scanStride =
          sm.
          getScanlineStride(
            );
        int end;
        int pix;
        for (int y =
               0;
             y <
               height;
             y++) {
            int sp =
              srcBase +
              y *
              scanStride;
            end =
              sp +
                width;
            while (sp <
                     end) {
                pix =
                  pixels[sp];
                pixels[sp] =
                  pix &
                    -16777216 |
                    lut[pix >>>
                          16 &
                          255] <<
                    16 |
                    lut[pix >>>
                          8 &
                          255] <<
                    8 |
                    lut[pix &
                          255];
                sp++;
            }
        }
        return wr;
    }
    public java.awt.image.WritableRaster copyData(java.awt.image.WritableRaster wr) {
        org.apache.batik.ext.awt.image.rendered.CachableRed src =
          (org.apache.batik.ext.awt.image.rendered.CachableRed)
            getSources(
              ).
            get(
              0);
        java.awt.image.ColorModel srcCM =
          src.
          getColorModel(
            );
        java.awt.image.SampleModel srcSM =
          src.
          getSampleModel(
            );
        if (srcIsLsRGB &&
              is_INT_PACK_COMP(
                wr.
                  getSampleModel(
                    ))) {
            src.
              copyData(
                wr);
            if (srcCM.
                  hasAlpha(
                    ))
                org.apache.batik.ext.awt.image.GraphicsUtil.
                  coerceData(
                    wr,
                    srcCM,
                    false);
            applyLut_INT(
              wr,
              linearToSRGBLut);
            return wr;
        }
        if (srcCM ==
              null) {
            float[][] matrix =
              null;
            switch (srcSM.
                      getNumBands(
                        )) {
                case 1:
                    matrix =
                      (new float[3][1]);
                    matrix[0][0] =
                      1;
                    matrix[1][0] =
                      1;
                    matrix[2][0] =
                      1;
                    break;
                case 2:
                    matrix =
                      (new float[4][2]);
                    matrix[0][0] =
                      1;
                    matrix[1][0] =
                      1;
                    matrix[2][0] =
                      1;
                    matrix[3][1] =
                      1;
                    break;
                case 3:
                    matrix =
                      (new float[3][3]);
                    matrix[0][0] =
                      1;
                    matrix[1][1] =
                      1;
                    matrix[2][2] =
                      1;
                    break;
                default:
                    matrix =
                      (new float[4][srcSM.
                                      getNumBands(
                                        )]);
                    matrix[0][0] =
                      1;
                    matrix[1][1] =
                      1;
                    matrix[2][2] =
                      1;
                    matrix[3][3] =
                      1;
                    break;
            }
            java.awt.image.Raster srcRas =
              src.
              getData(
                wr.
                  getBounds(
                    ));
            java.awt.image.BandCombineOp op =
              new java.awt.image.BandCombineOp(
              matrix,
              null);
            op.
              filter(
                srcRas,
                wr);
            return wr;
        }
        if (srcCM.
              getColorSpace(
                ) ==
              java.awt.color.ColorSpace.
              getInstance(
                java.awt.color.ColorSpace.
                  CS_GRAY)) {
            try {
                float[][] matrix =
                  null;
                switch (srcSM.
                          getNumBands(
                            )) {
                    case 1:
                        matrix =
                          (new float[3][1]);
                        matrix[0][0] =
                          1;
                        matrix[1][0] =
                          1;
                        matrix[2][0] =
                          1;
                        break;
                    case 2:
                    default:
                        matrix =
                          (new float[4][2]);
                        matrix[0][0] =
                          1;
                        matrix[1][0] =
                          1;
                        matrix[2][0] =
                          1;
                        matrix[3][1] =
                          1;
                        break;
                }
                java.awt.image.Raster srcRas =
                  src.
                  getData(
                    wr.
                      getBounds(
                        ));
                java.awt.image.BandCombineOp op =
                  new java.awt.image.BandCombineOp(
                  matrix,
                  null);
                op.
                  filter(
                    srcRas,
                    wr);
            }
            catch (java.lang.Throwable t) {
                t.
                  printStackTrace(
                    );
            }
            return wr;
        }
        java.awt.image.ColorModel dstCM =
          getColorModel(
            );
        if (srcCM.
              getColorSpace(
                ) ==
              dstCM.
              getColorSpace(
                )) {
            if (is_INT_PACK_COMP(
                  srcSM))
                src.
                  copyData(
                    wr);
            else
                org.apache.batik.ext.awt.image.GraphicsUtil.
                  copyData(
                    src.
                      getData(
                        wr.
                          getBounds(
                            )),
                    wr);
            return wr;
        }
        java.awt.image.Raster srcRas =
          src.
          getData(
            wr.
              getBounds(
                ));
        java.awt.image.WritableRaster srcWr =
          (java.awt.image.WritableRaster)
            srcRas;
        java.awt.image.ColorModel srcBICM =
          srcCM;
        if (srcCM.
              hasAlpha(
                ))
            srcBICM =
              org.apache.batik.ext.awt.image.GraphicsUtil.
                coerceData(
                  srcWr,
                  srcCM,
                  false);
        java.awt.image.BufferedImage srcBI;
        java.awt.image.BufferedImage dstBI;
        srcBI =
          new java.awt.image.BufferedImage(
            srcBICM,
            srcWr.
              createWritableTranslatedChild(
                0,
                0),
            false,
            null);
        java.awt.image.ColorConvertOp op =
          new java.awt.image.ColorConvertOp(
          dstCM.
            getColorSpace(
              ),
          null);
        dstBI =
          op.
            filter(
              srcBI,
              null);
        java.awt.image.WritableRaster wr00 =
          wr.
          createWritableTranslatedChild(
            0,
            0);
        for (int i =
               0;
             i <
               dstCM.
               getColorSpace(
                 ).
               getNumComponents(
                 );
             i++)
            copyBand(
              dstBI.
                getRaster(
                  ),
              i,
              wr00,
              i);
        if (dstCM.
              hasAlpha(
                ))
            copyBand(
              srcWr,
              srcSM.
                getNumBands(
                  ) -
                1,
              wr,
              getSampleModel(
                ).
                getNumBands(
                  ) -
                1);
        return wr;
    }
    protected static java.awt.image.ColorModel fixColorModel(org.apache.batik.ext.awt.image.rendered.CachableRed src) {
        java.awt.image.ColorModel cm =
          src.
          getColorModel(
            );
        if (cm !=
              null) {
            if (cm.
                  hasAlpha(
                    ))
                return org.apache.batik.ext.awt.image.GraphicsUtil.
                         sRGB_Unpre;
            return org.apache.batik.ext.awt.image.GraphicsUtil.
                     sRGB;
        }
        else {
            java.awt.image.SampleModel sm =
              src.
              getSampleModel(
                );
            switch (sm.
                      getNumBands(
                        )) {
                case 1:
                    return org.apache.batik.ext.awt.image.GraphicsUtil.
                             sRGB;
                case 2:
                    return org.apache.batik.ext.awt.image.GraphicsUtil.
                             sRGB_Unpre;
                case 3:
                    return org.apache.batik.ext.awt.image.GraphicsUtil.
                             sRGB;
            }
            return org.apache.batik.ext.awt.image.GraphicsUtil.
                     sRGB_Unpre;
        }
    }
    protected static java.awt.image.SampleModel fixSampleModel(org.apache.batik.ext.awt.image.rendered.CachableRed src) {
        java.awt.image.SampleModel sm =
          src.
          getSampleModel(
            );
        java.awt.image.ColorModel cm =
          src.
          getColorModel(
            );
        boolean alpha =
          false;
        if (cm !=
              null)
            alpha =
              cm.
                hasAlpha(
                  );
        else {
            switch (sm.
                      getNumBands(
                        )) {
                case 1:
                case 3:
                    alpha =
                      false;
                    break;
                default:
                    alpha =
                      true;
                    break;
            }
        }
        if (alpha)
            return new java.awt.image.SinglePixelPackedSampleModel(
              java.awt.image.DataBuffer.
                TYPE_INT,
              sm.
                getWidth(
                  ),
              sm.
                getHeight(
                  ),
              new int[] { 16711680,
              65280,
              255,
              -16777216 });
        else
            return new java.awt.image.SinglePixelPackedSampleModel(
              java.awt.image.DataBuffer.
                TYPE_INT,
              sm.
                getWidth(
                  ),
              sm.
                getHeight(
                  ),
              new int[] { 16711680,
              65280,
              255 });
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "5824xOAIs6VgFR1q513sLf4fOvFVTr0iAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "u6L4Vyn0oGFnVOiFcRkcRz7zznM+c46i");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("NMdXvlf/h4Gw/KE5+Lv1/9+9Czv80R3s8CdF8Ycp9BCwwymUKGp/6UTX/3g3" +
       "umYp9JZTB7yK0yqP3XS6dH8iUv3sa9fue8dr09/df0U8OrV4PwfdZ6w97/QB" +
       "gVPPV6JYN/ZBe//+uEBU3r6RQt//XR5uAV5+9FjK/6d7Dv81hZ68M4cUuqe8" +
       "n271rRR67HatUugSKE9T/88UetutqAElKE9T/hkA4fOUoP/yfpruOyl09YQu" +
       "ha7sH06RXAAhdAmQFI+XoiMv/+6P6y2TNFbUtDgJdOHsbHnsIo+8mYucmmCf" +
       "O/O1sDygfPRlb70/onxD/dxrzOCD32z87P4UmeopeV5wuY+D7t0faDv+OvjM" +
       "bbkd8brSe/HbD33+/heOpuyH9gKfxNgp2Z669ZGtjh+l5SGr/B++41fe83Ov" +
       "/X551uD/AsxKfHM5LgAA");
}
