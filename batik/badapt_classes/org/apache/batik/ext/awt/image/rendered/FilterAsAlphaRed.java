package org.apache.batik.ext.awt.image.rendered;
public class FilterAsAlphaRed extends org.apache.batik.ext.awt.image.rendered.AbstractRed {
    public FilterAsAlphaRed(org.apache.batik.ext.awt.image.rendered.CachableRed src) {
        super(
          new org.apache.batik.ext.awt.image.rendered.Any2LumRed(
            src),
          src.
            getBounds(
              ),
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
              TYPE_BYTE),
          new java.awt.image.PixelInterleavedSampleModel(
            java.awt.image.DataBuffer.
              TYPE_BYTE,
            src.
              getSampleModel(
                ).
              getWidth(
                ),
            src.
              getSampleModel(
                ).
              getHeight(
                ),
            1,
            src.
              getSampleModel(
                ).
              getWidth(
                ),
            new int[] { 0 }),
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
              VALUE_COLORSPACE_ALPHA);
    }
    public java.awt.image.WritableRaster copyData(java.awt.image.WritableRaster wr) {
        org.apache.batik.ext.awt.image.rendered.CachableRed srcRed =
          (org.apache.batik.ext.awt.image.rendered.CachableRed)
            getSources(
              ).
            get(
              0);
        java.awt.image.SampleModel sm =
          srcRed.
          getSampleModel(
            );
        if (sm.
              getNumBands(
                ) ==
              1)
            return srcRed.
              copyData(
                wr);
        java.awt.image.Raster srcRas =
          srcRed.
          getData(
            wr.
              getBounds(
                ));
        java.awt.image.PixelInterleavedSampleModel srcSM;
        srcSM =
          (java.awt.image.PixelInterleavedSampleModel)
            srcRas.
            getSampleModel(
              );
        java.awt.image.DataBufferByte srcDB =
          (java.awt.image.DataBufferByte)
            srcRas.
            getDataBuffer(
              );
        byte[] src =
          srcDB.
          getData(
            );
        java.awt.image.PixelInterleavedSampleModel dstSM;
        dstSM =
          (java.awt.image.PixelInterleavedSampleModel)
            wr.
            getSampleModel(
              );
        java.awt.image.DataBufferByte dstDB =
          (java.awt.image.DataBufferByte)
            wr.
            getDataBuffer(
              );
        byte[] dst =
          dstDB.
          getData(
            );
        int srcX0 =
          srcRas.
          getMinX(
            ) -
          srcRas.
          getSampleModelTranslateX(
            );
        int srcY0 =
          srcRas.
          getMinY(
            ) -
          srcRas.
          getSampleModelTranslateY(
            );
        int dstX0 =
          wr.
          getMinX(
            ) -
          wr.
          getSampleModelTranslateX(
            );
        int dstX1 =
          dstX0 +
          wr.
          getWidth(
            ) -
          1;
        int dstY0 =
          wr.
          getMinY(
            ) -
          wr.
          getSampleModelTranslateY(
            );
        int srcStep =
          srcSM.
          getPixelStride(
            );
        int[] offsets =
          srcSM.
          getBandOffsets(
            );
        int srcLOff =
          offsets[0];
        int srcAOff =
          offsets[1];
        if (srcRed.
              getColorModel(
                ).
              isAlphaPremultiplied(
                )) {
            for (int y =
                   0;
                 y <
                   srcRas.
                   getHeight(
                     );
                 y++) {
                int srcI =
                  srcDB.
                  getOffset(
                    ) +
                  srcSM.
                  getOffset(
                    srcX0,
                    srcY0);
                int dstI =
                  dstDB.
                  getOffset(
                    ) +
                  dstSM.
                  getOffset(
                    dstX0,
                    dstY0);
                int dstE =
                  dstDB.
                  getOffset(
                    ) +
                  dstSM.
                  getOffset(
                    dstX1 +
                      1,
                    dstY0);
                srcI +=
                  srcLOff;
                while (dstI <
                         dstE) {
                    dst[dstI++] =
                      src[srcI];
                    srcI +=
                      srcStep;
                }
                srcY0++;
                dstY0++;
            }
        }
        else {
            srcAOff =
              srcAOff -
                srcLOff;
            for (int y =
                   0;
                 y <
                   srcRas.
                   getHeight(
                     );
                 y++) {
                int srcI =
                  srcDB.
                  getOffset(
                    ) +
                  srcSM.
                  getOffset(
                    srcX0,
                    srcY0);
                int dstI =
                  dstDB.
                  getOffset(
                    ) +
                  dstSM.
                  getOffset(
                    dstX0,
                    dstY0);
                int dstE =
                  dstDB.
                  getOffset(
                    ) +
                  dstSM.
                  getOffset(
                    dstX1 +
                      1,
                    dstY0);
                srcI +=
                  srcLOff;
                while (dstI <
                         dstE) {
                    int sl =
                      src[srcI] &
                      255;
                    int sa =
                      src[srcI +
                            srcAOff] &
                      255;
                    dst[dstI++] =
                      (byte)
                        (sl *
                           sa +
                           128 >>
                           8);
                    srcI +=
                      srcStep;
                }
                srcY0++;
                dstY0++;
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
       "cZ6T2E5vNoTe+POb4vxviFcczv8XKUipZZAUAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "+1+XBAa9CSAAAA==");
}
