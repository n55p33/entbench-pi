package org.apache.batik.ext.awt.image.rendered;
public class Any2LumRed extends org.apache.batik.ext.awt.image.rendered.AbstractRed {
    public Any2LumRed(org.apache.batik.ext.awt.image.rendered.CachableRed src) {
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
        props.
          put(
            org.apache.batik.ext.awt.ColorSpaceHintKey.
              PROPERTY_COLORSPACE,
            org.apache.batik.ext.awt.ColorSpaceHintKey.
              VALUE_COLORSPACE_GREY);
    }
    public java.awt.image.WritableRaster copyData(java.awt.image.WritableRaster wr) {
        org.apache.batik.ext.awt.image.rendered.CachableRed src =
          (org.apache.batik.ext.awt.image.rendered.CachableRed)
            getSources(
              ).
            get(
              0);
        java.awt.image.SampleModel sm =
          src.
          getSampleModel(
            );
        java.awt.image.ColorModel srcCM =
          src.
          getColorModel(
            );
        java.awt.image.Raster srcRas =
          src.
          getData(
            wr.
              getBounds(
                ));
        if (srcCM ==
              null) {
            float[][] matrix =
              null;
            if (sm.
                  getNumBands(
                    ) ==
                  2) {
                matrix =
                  (new float[2][2]);
                matrix[0][0] =
                  1;
                matrix[1][1] =
                  1;
            }
            else {
                matrix =
                  (new float[sm.
                               getNumBands(
                                 )][1]);
                matrix[0][0] =
                  1;
            }
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
            java.awt.image.WritableRaster srcWr =
              (java.awt.image.WritableRaster)
                srcRas;
            if (srcCM.
                  hasAlpha(
                    ))
                org.apache.batik.ext.awt.image.GraphicsUtil.
                  coerceData(
                    srcWr,
                    srcCM,
                    false);
            java.awt.image.BufferedImage srcBI;
            java.awt.image.BufferedImage dstBI;
            srcBI =
              new java.awt.image.BufferedImage(
                srcCM,
                srcWr.
                  createWritableTranslatedChild(
                    0,
                    0),
                false,
                null);
            java.awt.image.ColorModel dstCM =
              getColorModel(
                );
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
                java.awt.image.PixelInterleavedSampleModel dstSM;
                dstSM =
                  (java.awt.image.PixelInterleavedSampleModel)
                    wr.
                    getSampleModel(
                      );
                java.awt.image.SampleModel smna =
                  new java.awt.image.PixelInterleavedSampleModel(
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
                    getPixelStride(
                      ),
                  dstSM.
                    getScanlineStride(
                      ),
                  new int[] { 0 });
                java.awt.image.WritableRaster dstWr;
                dstWr =
                  java.awt.image.Raster.
                    createWritableRaster(
                      smna,
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
                java.awt.image.ColorModel cmna =
                  new java.awt.image.ComponentColorModel(
                  java.awt.color.ColorSpace.
                    getInstance(
                      java.awt.color.ColorSpace.
                        CS_GRAY),
                  new int[] { 8 },
                  false,
                  false,
                  java.awt.Transparency.
                    OPAQUE,
                  java.awt.image.DataBuffer.
                    TYPE_BYTE);
                dstBI =
                  new java.awt.image.BufferedImage(
                    cmna,
                    dstWr,
                    false,
                    null);
            }
            java.awt.image.ColorConvertOp op =
              new java.awt.image.ColorConvertOp(
              null);
            op.
              filter(
                srcBI,
                dstBI);
            if (dstCM.
                  hasAlpha(
                    )) {
                copyBand(
                  srcWr,
                  sm.
                    getNumBands(
                      ) -
                    1,
                  wr,
                  getSampleModel(
                    ).
                    getNumBands(
                      ) -
                    1);
                if (dstCM.
                      isAlphaPremultiplied(
                        ))
                    org.apache.batik.ext.awt.image.GraphicsUtil.
                      multiplyAlpha(
                        wr);
            }
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
                return new java.awt.image.ComponentColorModel(
                  java.awt.color.ColorSpace.
                    getInstance(
                      java.awt.color.ColorSpace.
                        CS_GRAY),
                  new int[] { 8,
                  8 },
                  true,
                  cm.
                    isAlphaPremultiplied(
                      ),
                  java.awt.Transparency.
                    TRANSLUCENT,
                  java.awt.image.DataBuffer.
                    TYPE_BYTE);
            return new java.awt.image.ComponentColorModel(
              java.awt.color.ColorSpace.
                getInstance(
                  java.awt.color.ColorSpace.
                    CS_GRAY),
              new int[] { 8 },
              false,
              false,
              java.awt.Transparency.
                OPAQUE,
              java.awt.image.DataBuffer.
                TYPE_BYTE);
        }
        else {
            java.awt.image.SampleModel sm =
              src.
              getSampleModel(
                );
            if (sm.
                  getNumBands(
                    ) ==
                  2)
                return new java.awt.image.ComponentColorModel(
                  java.awt.color.ColorSpace.
                    getInstance(
                      java.awt.color.ColorSpace.
                        CS_GRAY),
                  new int[] { 8,
                  8 },
                  true,
                  true,
                  java.awt.Transparency.
                    TRANSLUCENT,
                  java.awt.image.DataBuffer.
                    TYPE_BYTE);
            return new java.awt.image.ComponentColorModel(
              java.awt.color.ColorSpace.
                getInstance(
                  java.awt.color.ColorSpace.
                    CS_GRAY),
              new int[] { 8 },
              false,
              false,
              java.awt.Transparency.
                OPAQUE,
              java.awt.image.DataBuffer.
                TYPE_BYTE);
        }
    }
    protected static java.awt.image.SampleModel fixSampleModel(org.apache.batik.ext.awt.image.rendered.CachableRed src) {
        java.awt.image.SampleModel sm =
          src.
          getSampleModel(
            );
        int width =
          sm.
          getWidth(
            );
        int height =
          sm.
          getHeight(
            );
        java.awt.image.ColorModel cm =
          src.
          getColorModel(
            );
        if (cm !=
              null) {
            if (cm.
                  hasAlpha(
                    ))
                return new java.awt.image.PixelInterleavedSampleModel(
                  java.awt.image.DataBuffer.
                    TYPE_BYTE,
                  width,
                  height,
                  2,
                  2 *
                    width,
                  new int[] { 0,
                  1 });
            return new java.awt.image.PixelInterleavedSampleModel(
              java.awt.image.DataBuffer.
                TYPE_BYTE,
              width,
              height,
              1,
              width,
              new int[] { 0 });
        }
        else {
            if (sm.
                  getNumBands(
                    ) ==
                  2)
                return new java.awt.image.PixelInterleavedSampleModel(
                  java.awt.image.DataBuffer.
                    TYPE_BYTE,
                  width,
                  height,
                  2,
                  2 *
                    width,
                  new int[] { 0,
                  1 });
            return new java.awt.image.PixelInterleavedSampleModel(
              java.awt.image.DataBuffer.
                TYPE_BYTE,
              width,
              height,
              1,
              width,
              new int[] { 0 });
        }
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
       "3vj89oZecCL1gs3cHzvwO3aQ+FB6LLE9OBx6BkjPC2Uf6F7KIbjFkeE6KeBW" +
       "+6zquOuaDOTk92rrUMsftd0+zDBtsA4s8GjS+Gb4XNuzwLXbsMAO9BzXc4Cu" +
       "Al1Lw+FW1kh+YinBL95C2fcnxbsBcvfEiEjHdLyWo+25JbTk645Z8hhFao73" +
       "/ATmeCxpROHz8p45Xr4dcyTVZ2/DDh+5hR2uJsWvAOQeaAdRtlxTP2KIi8cM" +
       "cZwktcRzt2OJCCDntpdNycn5g9ddc2+uZtXPXTt/9rXX+n+d3rccXJ/eySFn" +
       "J4FpHj6sPFQ/7Xo61CWl3BxduunXJwDyxh/zoB2GwH41Ff/jGw6/CZCHb80B" +
       "IKfS78O9fgsgD96sF0BOwvIw9W8D5DU3ooaUsDxM+WmAXDhOCcdPvw/TvQDt" +
       "vaUDyOlN5TDJi5A7JEmqn3dv+1YCbh2AJ6sguZU4cXSJOPCQ+36UhxxaVZ44" +
       "shak/5TYx+1g81+JK+qL15j2u14pfmpzo6WachwnXM5yyJnN5doB9j92U277" +
       "vE43nvrBPZ+/88n9deqejcDbADwk2yM3vj6qWy5IL3ziP3zt77/ld659Iz0H" +
       "/j9xM6u4wiIAAA==");
}
