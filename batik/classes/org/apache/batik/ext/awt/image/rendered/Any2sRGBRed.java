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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "582Yb3CE2VKwig618y72Fv8P6p9anr0iAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "3p/NhPbT/kvH8Peu89B0qtvzwHQyd4Dngrp4vnIOi0orPw2ug8MwPTiPRReg" +
       "8oEsmzxblteL4vsPR2jP6jvgdwFc/6e4ivqiYj+VP0of5hPPHCcUEZjMriSx" +
       "1k+4Ypq687iKseMDINsc5lPwy49+bfkzf/xL+1zp/CCeIzY+/spf+87BJ165" +
       "eCpDff6mJPF0m32WWlrpoaJoF2Hx7J16KVt0/ujzL//jv/3yx/ZSPXo232qD" +
       "5cQv/av//eWDT//Bb95iWr9vEYaeoQZ71C9KtCiovWnx28bJe49H8Z1HmdMH" +
       "DkfxAzeNYjGxXysjtXCsg1YI8Nr48N/7DeaF5Rv3AKFa0L2bwv+yM2SDdbHq" +
       "+PHXPvXkW175g58oEf/9l5DyV/Ad3dopLgGdotjZgKEGM0NSrmRS4JxOoHql" +
       "ZdvgX5fk+b1T9Q7tXNw40EAvZTtnDekurfE+cGmH1tBu49OL24hfPMpFoRTF" +
       "B45EvlqkuGo8DiXgs9w6BRZ99+3dtpw29l746s89/5UfffX5f1+i5/1OAoKW" +
       "jK1brDdOtfnma1/7+u889OTnyuzknoWa7MP3/ELt5nXYmeVVKfqDx5YpEm3o" +
       "Koj6wd4w+3sKad9jDqxGUQInG2sB0p7EiOFBqBuioy2NWFQDwztKtf8suslu" +
       "5VKXnMN1/MG5+fq9ReEe+cPq1v5wsXj8gTOucNkzAmu/jvGLwomyY/4X942O" +
       "8oG3nkQT7YXAgYBvH73bJ+VOeHC8lAcvs5skjaEXb+9nfDncJ3PPFz/6n54Y" +
       "v8/+4F1k40+fc8PzLP8O/9pvdr9P+8mL0KXjmeimdf7ZRi+dnX+uxEa6joPx" +
       "mVnoyb3xS/vtLV8U7y5NfIdc6CN3ePdjRfEjAF20wtT7kbkD+Y9n0DmY0d4U" +
       "ZvaedQHkvPfWD/CDavH/r94BSH7gZiB5h+tp149mxakRJ2B4rrsefuQWpwB4" +
       "vxVyTsj2dy0kcJ2HT5hxYWC99BP/8ZNf/uvPfw1gEXME+QX1BDja9C+/8cT7" +
       "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" +
       "/tui+Jcp9JDpZHTohXEZHEc+885zPnOO");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("ojTHV79X/4eBsPyhOfi79f/fvQs7/NEd7PAnRfGHKfQwsMMplChqf/lE1/9w" +
       "N7pmKfSWUwe8itMqj990unR/IlL73KtX73/Hq5Pf3X9FPDq1+AAH3W+uPe/0" +
       "AYFTz5ej2DD3QfvA/rhAVN6+mULf/10ebgFefvRYyv9f9hz+awo9dWcOKXRv" +
       "eT/d6tsp9PjtWqXQJVCepv6fKfS2W1EDSlCepvxTAMLnKUH/5f003XdS6MoJ" +
       "XQpd3j+cIrkAQugSICkeL0VHXv7dH9dbJGmsamlxEujC2dny2EUefTMXOTXB" +
       "Pn/ma2F5QPnoy956f0T5hvb5V5nBh77V+Nn9KTLNU/O84HI/B923P9B2/HXw" +
       "2dtyO+J1uffCGw9/4YF3H03ZD+8FPomxU7I9fesjW20/SstDVvk/eMevvPfn" +
       "X/398qzB/wVNv+FsOS4AAA==");
}
