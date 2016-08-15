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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "UDOvYq3lv+qY+6FiIgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "OfzeLeTwn4riP0TQg0AOvOz4tn5BEI8d");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("COIQpJTEb9+OJNIIuv/8VaziXsmj110F3V9fVL/w6tV7HnlV+Df772gnVwzv" +
       "HUP3GLFtn/+Uf65+xQ90wE0Juf+w75d/34yg73+L11CAE5xUSwa+scfw3yPo" +
       "iVtjiKC7yv/zo/5HBD16s1ERdAcoz0P/QQS940bQABKU5yH/KIKuHUKC+cv/" +
       "83BvRNB9Z3ARdGVfOQ/yxwA7ACmq3/VPdP+W7+zgShgFshoVd3YuXVw/Tm3k" +
       "4TezkXNLzrMXvpeVt4lPvm3F+/vEL6lffHXE/Nh3Gp/f3/dSbTnPCyz3jKG7" +
       "91fPTr+PPX1TbCe4rhDPv/HgL9z73pNF7ME9wWcueI62J298uarv+FF5HSr/" +
       "pUd+8QN/89XfKa8F/D+XDCh35i0AAA==");
}
