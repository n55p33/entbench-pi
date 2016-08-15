package org.apache.batik.ext.awt.image.rendered;
public class MultiplyAlphaRed extends org.apache.batik.ext.awt.image.rendered.AbstractRed {
    public MultiplyAlphaRed(org.apache.batik.ext.awt.image.rendered.CachableRed src,
                            org.apache.batik.ext.awt.image.rendered.CachableRed alpha) {
        super(
          makeList(
            src,
            alpha),
          makeBounds(
            src,
            alpha),
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
    }
    public boolean is_INT_PACK_BYTE_COMP(java.awt.image.SampleModel srcSM,
                                         java.awt.image.SampleModel alpSM) {
        if (!(srcSM instanceof java.awt.image.SinglePixelPackedSampleModel))
            return false;
        if (!(alpSM instanceof java.awt.image.ComponentSampleModel))
            return false;
        if (srcSM.
              getDataType(
                ) !=
              java.awt.image.DataBuffer.
                TYPE_INT)
            return false;
        if (alpSM.
              getDataType(
                ) !=
              java.awt.image.DataBuffer.
                TYPE_BYTE)
            return false;
        java.awt.image.SinglePixelPackedSampleModel sppsm;
        sppsm =
          (java.awt.image.SinglePixelPackedSampleModel)
            srcSM;
        int[] masks =
          sppsm.
          getBitMasks(
            );
        if (masks.
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
        if (masks[3] !=
              -16777216)
            return false;
        java.awt.image.ComponentSampleModel csm;
        csm =
          (java.awt.image.ComponentSampleModel)
            alpSM;
        if (csm.
              getNumBands(
                ) !=
              1)
            return false;
        if (csm.
              getPixelStride(
                ) !=
              1)
            return false;
        return true;
    }
    public java.awt.image.WritableRaster INT_PACK_BYTE_COMP_Impl(java.awt.image.WritableRaster wr) {
        org.apache.batik.ext.awt.image.rendered.CachableRed srcRed =
          (org.apache.batik.ext.awt.image.rendered.CachableRed)
            getSources(
              ).
            get(
              0);
        org.apache.batik.ext.awt.image.rendered.CachableRed alphaRed =
          (org.apache.batik.ext.awt.image.rendered.CachableRed)
            getSources(
              ).
            get(
              1);
        srcRed.
          copyData(
            wr);
        java.awt.Rectangle rgn =
          wr.
          getBounds(
            );
        rgn =
          rgn.
            intersection(
              alphaRed.
                getBounds(
                  ));
        java.awt.image.Raster r =
          alphaRed.
          getData(
            rgn);
        java.awt.image.ComponentSampleModel csm;
        csm =
          (java.awt.image.ComponentSampleModel)
            r.
            getSampleModel(
              );
        final int alpScanStride =
          csm.
          getScanlineStride(
            );
        java.awt.image.DataBufferByte alpDB =
          (java.awt.image.DataBufferByte)
            r.
            getDataBuffer(
              );
        final int alpBase =
          alpDB.
          getOffset(
            ) +
          csm.
          getOffset(
            rgn.
              x -
              r.
              getSampleModelTranslateX(
                ),
            rgn.
              y -
              r.
              getSampleModelTranslateY(
                ));
        final byte[] alpPixels =
          alpDB.
          getBankData(
            )[0];
        java.awt.image.SinglePixelPackedSampleModel sppsm;
        sppsm =
          (java.awt.image.SinglePixelPackedSampleModel)
            wr.
            getSampleModel(
              );
        final int srcScanStride =
          sppsm.
          getScanlineStride(
            );
        java.awt.image.DataBufferInt srcDB =
          (java.awt.image.DataBufferInt)
            wr.
            getDataBuffer(
              );
        final int srcBase =
          srcDB.
          getOffset(
            ) +
          sppsm.
          getOffset(
            rgn.
              x -
              wr.
              getSampleModelTranslateX(
                ),
            rgn.
              y -
              wr.
              getSampleModelTranslateY(
                ));
        final int[] srcPixels =
          srcDB.
          getBankData(
            )[0];
        java.awt.image.ColorModel cm =
          srcRed.
          getColorModel(
            );
        if (cm.
              isAlphaPremultiplied(
                )) {
            for (int y =
                   0;
                 y <
                   rgn.
                     height;
                 y++) {
                int sp =
                  srcBase +
                  y *
                  srcScanStride;
                int ap =
                  alpBase +
                  y *
                  alpScanStride;
                int end =
                  sp +
                  rgn.
                    width;
                while (sp <
                         end) {
                    int a =
                      (int)
                        alpPixels[ap++] &
                      255;
                    final int pix =
                      srcPixels[sp];
                    srcPixels[sp] =
                      ((pix >>>
                          24) *
                         a &
                         65280) <<
                        16 |
                        ((pix >>>
                            16 &
                            255) *
                           a &
                           65280) <<
                        8 |
                        (pix >>>
                           8 &
                           255) *
                        a &
                        65280 |
                        ((pix &
                            255) *
                           a &
                           65280) >>
                        8;
                    sp++;
                }
            }
        }
        else {
            for (int y =
                   0;
                 y <
                   rgn.
                     height;
                 y++) {
                int sp =
                  srcBase +
                  y *
                  srcScanStride;
                int ap =
                  alpBase +
                  y *
                  alpScanStride;
                int end =
                  sp +
                  rgn.
                    width;
                while (sp <
                         end) {
                    int a =
                      (int)
                        alpPixels[ap++] &
                      255;
                    int sa =
                      srcPixels[sp] >>>
                      24;
                    srcPixels[sp] =
                      (sa *
                         a &
                         65280) <<
                        16 |
                        srcPixels[sp] &
                        16777215;
                    sp++;
                }
            }
        }
        return wr;
    }
    public java.awt.image.WritableRaster copyData(java.awt.image.WritableRaster wr) {
        org.apache.batik.ext.awt.image.rendered.CachableRed srcRed =
          (org.apache.batik.ext.awt.image.rendered.CachableRed)
            getSources(
              ).
            get(
              0);
        org.apache.batik.ext.awt.image.rendered.CachableRed alphaRed =
          (org.apache.batik.ext.awt.image.rendered.CachableRed)
            getSources(
              ).
            get(
              1);
        if (is_INT_PACK_BYTE_COMP(
              srcRed.
                getSampleModel(
                  ),
              alphaRed.
                getSampleModel(
                  )))
            return INT_PACK_BYTE_COMP_Impl(
                     wr);
        java.awt.image.ColorModel cm =
          srcRed.
          getColorModel(
            );
        if (cm.
              hasAlpha(
                )) {
            srcRed.
              copyData(
                wr);
            java.awt.Rectangle rgn =
              wr.
              getBounds(
                );
            if (rgn.
                  intersects(
                    alphaRed.
                      getBounds(
                        )))
                rgn =
                  rgn.
                    intersection(
                      alphaRed.
                        getBounds(
                          ));
            else
                return wr;
            int[] wrData =
              null;
            int[] alphaData =
              null;
            java.awt.image.Raster r =
              alphaRed.
              getData(
                rgn);
            int w =
              rgn.
                width;
            final int bands =
              wr.
              getSampleModel(
                ).
              getNumBands(
                );
            if (cm.
                  isAlphaPremultiplied(
                    )) {
                for (int y =
                       rgn.
                         y;
                     y <
                       rgn.
                         y +
                       rgn.
                         height;
                     y++) {
                    wrData =
                      wr.
                        getPixels(
                          rgn.
                            x,
                          y,
                          w,
                          1,
                          wrData);
                    alphaData =
                      r.
                        getSamples(
                          rgn.
                            x,
                          y,
                          w,
                          1,
                          0,
                          alphaData);
                    int i =
                      0;
                    int a;
                    int b;
                    switch (bands) {
                        case 2:
                            for (int x =
                                   0;
                                 x <
                                   alphaData.
                                     length;
                                 x++) {
                                a =
                                  alphaData[x] &
                                    255;
                                wrData[i] =
                                  (wrData[i] &
                                     255) *
                                    a >>
                                    8;
                                ++i;
                                wrData[i] =
                                  (wrData[i] &
                                     255) *
                                    a >>
                                    8;
                                ++i;
                            }
                            break;
                        case 4:
                            for (int x =
                                   0;
                                 x <
                                   alphaData.
                                     length;
                                 x++) {
                                a =
                                  alphaData[x] &
                                    255;
                                wrData[i] =
                                  (wrData[i] &
                                     255) *
                                    a >>
                                    8;
                                ++i;
                                wrData[i] =
                                  (wrData[i] &
                                     255) *
                                    a >>
                                    8;
                                ++i;
                                wrData[i] =
                                  (wrData[i] &
                                     255) *
                                    a >>
                                    8;
                                ++i;
                                wrData[i] =
                                  (wrData[i] &
                                     255) *
                                    a >>
                                    8;
                                ++i;
                            }
                            break;
                        default:
                            for (int x =
                                   0;
                                 x <
                                   alphaData.
                                     length;
                                 x++) {
                                a =
                                  alphaData[x] &
                                    255;
                                for (b =
                                       0;
                                     b <
                                       bands;
                                     b++) {
                                    wrData[i] =
                                      (wrData[i] &
                                         255) *
                                        a >>
                                        8;
                                    ++i;
                                }
                            }
                    }
                    wr.
                      setPixels(
                        rgn.
                          x,
                        y,
                        w,
                        1,
                        wrData);
                }
            }
            else {
                int b =
                  srcRed.
                  getSampleModel(
                    ).
                  getNumBands(
                    ) -
                  1;
                for (int y =
                       rgn.
                         y;
                     y <
                       rgn.
                         y +
                       rgn.
                         height;
                     y++) {
                    wrData =
                      wr.
                        getSamples(
                          rgn.
                            x,
                          y,
                          w,
                          1,
                          b,
                          wrData);
                    alphaData =
                      r.
                        getSamples(
                          rgn.
                            x,
                          y,
                          w,
                          1,
                          0,
                          alphaData);
                    for (int i =
                           0;
                         i <
                           wrData.
                             length;
                         i++) {
                        wrData[i] =
                          (wrData[i] &
                             255) *
                            (alphaData[i] &
                               255) >>
                            8;
                    }
                    wr.
                      setSamples(
                        rgn.
                          x,
                        y,
                        w,
                        1,
                        b,
                        wrData);
                }
            }
            return wr;
        }
        int[] bands =
          new int[wr.
                    getNumBands(
                      ) -
                    1];
        for (int i =
               0;
             i <
               bands.
                 length;
             i++)
            bands[i] =
              i;
        java.awt.image.WritableRaster subWr;
        subWr =
          wr.
            createWritableChild(
              wr.
                getMinX(
                  ),
              wr.
                getMinY(
                  ),
              wr.
                getWidth(
                  ),
              wr.
                getHeight(
                  ),
              wr.
                getMinX(
                  ),
              wr.
                getMinY(
                  ),
              bands);
        srcRed.
          copyData(
            subWr);
        java.awt.Rectangle rgn =
          wr.
          getBounds(
            );
        rgn =
          rgn.
            intersection(
              alphaRed.
                getBounds(
                  ));
        bands =
          (new int[] { wr.
             getNumBands(
               ) -
             1 });
        subWr =
          wr.
            createWritableChild(
              rgn.
                x,
              rgn.
                y,
              rgn.
                width,
              rgn.
                height,
              rgn.
                x,
              rgn.
                y,
              bands);
        alphaRed.
          copyData(
            subWr);
        return wr;
    }
    public static java.util.List makeList(org.apache.batik.ext.awt.image.rendered.CachableRed src1,
                                          org.apache.batik.ext.awt.image.rendered.CachableRed src2) {
        java.util.List ret =
          new java.util.ArrayList(
          2);
        ret.
          add(
            src1);
        ret.
          add(
            src2);
        return ret;
    }
    public static java.awt.Rectangle makeBounds(org.apache.batik.ext.awt.image.rendered.CachableRed src1,
                                                org.apache.batik.ext.awt.image.rendered.CachableRed src2) {
        java.awt.Rectangle r1 =
          src1.
          getBounds(
            );
        java.awt.Rectangle r2 =
          src2.
          getBounds(
            );
        return r1.
          intersection(
            r2);
    }
    public static java.awt.image.SampleModel fixSampleModel(org.apache.batik.ext.awt.image.rendered.CachableRed src) {
        java.awt.image.ColorModel cm =
          src.
          getColorModel(
            );
        java.awt.image.SampleModel srcSM =
          src.
          getSampleModel(
            );
        if (cm.
              hasAlpha(
                ))
            return srcSM;
        int w =
          srcSM.
          getWidth(
            );
        int h =
          srcSM.
          getHeight(
            );
        int b =
          srcSM.
          getNumBands(
            ) +
          1;
        int[] offsets =
          new int[b];
        for (int i =
               0;
             i <
               b;
             i++)
            offsets[i] =
              i;
        return new java.awt.image.PixelInterleavedSampleModel(
          java.awt.image.DataBuffer.
            TYPE_BYTE,
          w,
          h,
          b,
          w *
            b,
          offsets);
    }
    public static java.awt.image.ColorModel fixColorModel(org.apache.batik.ext.awt.image.rendered.CachableRed src) {
        java.awt.image.ColorModel cm =
          src.
          getColorModel(
            );
        if (cm.
              hasAlpha(
                ))
            return cm;
        int b =
          src.
          getSampleModel(
            ).
          getNumBands(
            ) +
          1;
        int[] bits =
          new int[b];
        for (int i =
               0;
             i <
               b;
             i++)
            bits[i] =
              8;
        java.awt.color.ColorSpace cs =
          cm.
          getColorSpace(
            );
        return new java.awt.image.ComponentColorModel(
          cs,
          bits,
          true,
          false,
          java.awt.Transparency.
            TRANSLUCENT,
          java.awt.image.DataBuffer.
            TYPE_BYTE);
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
       "yrcx8n/yxD/60N975evl+ez/AxT379xxKgAA");
}
