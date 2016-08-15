package org.apache.batik.ext.awt.image.rendered;
public class Any2LsRGBRed extends org.apache.batik.ext.awt.image.rendered.AbstractRed {
    boolean srcIssRGB = false;
    public Any2LsRGBRed(org.apache.batik.ext.awt.image.rendered.CachableRed src) {
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
                  CS_sRGB))
            srcIssRGB =
              true;
    }
    private static final double GAMMA = 2.4;
    private static final double LFACT = 1.0 / 12.92;
    public static final double sRGBToLsRGB(double value) { if (value <=
                                                                 0.003928)
                                                               return value *
                                                                 LFACT;
                                                           return java.lang.Math.
                                                             pow(
                                                               (value +
                                                                  0.055) /
                                                                 1.055,
                                                               GAMMA);
    }
    private static final int[] sRGBToLsRGBLut = new int[256];
    static { final double scale = 1.0 / 255;
             for (int i = 0; i < 256; i++) { double value =
                                               sRGBToLsRGB(
                                                 i *
                                                   scale);
                                             sRGBToLsRGBLut[i] =
                                               (int)
                                                 java.lang.Math.
                                                 round(
                                                   value *
                                                     255.0);
             } }
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
        if (srcIssRGB &&
              org.apache.batik.ext.awt.image.rendered.Any2sRGBRed.
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
            org.apache.batik.ext.awt.image.rendered.Any2sRGBRed.
              applyLut_INT(
                wr,
                sRGBToLsRGBLut);
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
                      (new float[1][3]);
                    matrix[0][0] =
                      1;
                    matrix[0][1] =
                      1;
                    matrix[0][2] =
                      1;
                    break;
                case 2:
                    matrix =
                      (new float[2][4]);
                    matrix[0][0] =
                      1;
                    matrix[0][1] =
                      1;
                    matrix[0][2] =
                      1;
                    matrix[1][3] =
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
                      (new float[srcSM.
                                   getNumBands(
                                     )][4]);
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
        }
        else {
            java.awt.image.ColorModel dstCM =
              getColorModel(
                );
            java.awt.image.BufferedImage dstBI;
            if (!dstCM.
                  hasAlpha(
                    )) {
                dstBI =
                  new java.awt.image.BufferedImage(
                    dstCM,
                    wr.
                      createWritableTranslatedChild(
                        0,
                        0),
                    dstCM.
                      isAlphaPremultiplied(
                        ),
                    null);
            }
            else {
                java.awt.image.SinglePixelPackedSampleModel dstSM;
                dstSM =
                  (java.awt.image.SinglePixelPackedSampleModel)
                    wr.
                    getSampleModel(
                      );
                int[] masks =
                  dstSM.
                  getBitMasks(
                    );
                java.awt.image.SampleModel dstSMNoA =
                  new java.awt.image.SinglePixelPackedSampleModel(
                  dstSM.
                    getDataType(
                      ),
                  dstSM.
                    getWidth(
                      ),
                  dstSM.
                    getHeight(
                      ),
                  dstSM.
                    getScanlineStride(
                      ),
                  new int[] { masks[0],
                  masks[1],
                  masks[2] });
                java.awt.image.ColorModel dstCMNoA =
                  org.apache.batik.ext.awt.image.GraphicsUtil.
                    Linear_sRGB;
                java.awt.image.WritableRaster dstWr;
                dstWr =
                  java.awt.image.Raster.
                    createWritableRaster(
                      dstSMNoA,
                      wr.
                        getDataBuffer(
                          ),
                      new java.awt.Point(
                        0,
                        0));
                dstWr =
                  dstWr.
                    createWritableChild(
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
                          ),
                      wr.
                        getWidth(
                          ),
                      wr.
                        getHeight(
                          ),
                      0,
                      0,
                      null);
                dstBI =
                  new java.awt.image.BufferedImage(
                    dstCMNoA,
                    dstWr,
                    false,
                    null);
            }
            java.awt.image.ColorModel srcBICM =
              srcCM;
            java.awt.image.WritableRaster srcWr;
            if (srcCM.
                  hasAlpha(
                    ) &&
                  srcCM.
                  isAlphaPremultiplied(
                    )) {
                java.awt.Rectangle wrR =
                  wr.
                  getBounds(
                    );
                java.awt.image.SampleModel sm =
                  srcCM.
                  createCompatibleSampleModel(
                    wrR.
                      width,
                    wrR.
                      height);
                srcWr =
                  java.awt.image.Raster.
                    createWritableRaster(
                      sm,
                      new java.awt.Point(
                        wrR.
                          x,
                        wrR.
                          y));
                src.
                  copyData(
                    srcWr);
                srcBICM =
                  org.apache.batik.ext.awt.image.GraphicsUtil.
                    coerceData(
                      srcWr,
                      srcCM,
                      false);
            }
            else {
                java.awt.image.Raster srcRas =
                  src.
                  getData(
                    wr.
                      getBounds(
                        ));
                srcWr =
                  org.apache.batik.ext.awt.image.GraphicsUtil.
                    makeRasterWritable(
                      srcRas);
            }
            java.awt.image.BufferedImage srcBI;
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
              null);
            op.
              filter(
                srcBI,
                dstBI);
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
        }
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
                         Linear_sRGB_Unpre;
            return org.apache.batik.ext.awt.image.GraphicsUtil.
                     Linear_sRGB;
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
                             Linear_sRGB;
                case 2:
                    return org.apache.batik.ext.awt.image.GraphicsUtil.
                             Linear_sRGB_Unpre;
                case 3:
                    return org.apache.batik.ext.awt.image.GraphicsUtil.
                             Linear_sRGB;
            }
            return org.apache.batik.ext.awt.image.GraphicsUtil.
                     Linear_sRGB_Unpre;
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
       "Q828irWW/wIQC2IOYiIAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "3dzd/1sVR9796l3I4Y/uIIf/kjf/KYYe");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("AHIQZce39TOCeHRPEPsghSR+/24kkcbQfaePY+VnSx656Tjo7gij+vlXr115" +
       "+NXxv9t9Szs6ZngvD10x1rZ9+nP+qf4lP9QBNwXk7uO+X/x9I4a+/y0eRQFO" +
       "cNQtGPj6DsOfxNDjd8YQQ/cU/6dn/c8YeuR2s2LoAmhPQ/9pDL3jVtAAErSn" +
       "Ib8TQ9f3IcH6xf9puDdi6OoJXAxd2nVOg/w5wA5A8u53/SPdv+VzO4QSxaGs" +
       "xvm5nXNn88exjTz0ZjZyKuU8c+abWXGi+Oj71np3pvhF9QuvdoQf/Xbtc7sz" +
       "X6otZ1mO5QoPXd4dPzv+RvbUbbEd4brEPPfGA79077NHSeyBHcEnLniKtidu" +
       "fcCq5fhxcSQq+7WHf+X9P//qHxRHA/4fyoNbT+otAAA=");
}
