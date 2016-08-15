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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL16e+zr1n0f78/2vfaN43vtJLbrxnbsXCeNlf5IPSnFaVfq" +
       "QYkUKVIiKUrc2muKpChKfIk8fKnzmgRYE7RAGmxOmmKJMQwpthZuHKwN2mHL" +
       "4KLYmqDdhgzF2m1Ykm0F+siCNX+0G5Zt3SH1e99HYjidAB1R53zP93yfH355" +
       "Dl/9FnJfGCAl37Mz0/bAoZGCw7VdPwSZb4SHNFPn1SA09I6thqEI+25qz37h" +
       "2l985xOr6wfIZQV5m+q6HlCB5bnhxAg9OzZ0Brl22tuzDScEyHVmrcYqGgHL" +
       "RhkrBC8wyFvOTAXIDeZYBBSKgEIR0EIElDilgpPeariR08lnqC4It8jfQi4x" +
       "yGVfy8UDyDPnmfhqoDpHbPhCA8jh/vz/FCpVTE4D5F0nuu91vkXhT5bQl3/+" +
       "J67/43uQawpyzXKFXBwNCgHgIgryoGM4CyMICV03dAV52DUMXTACS7WtXSG3" +
       "gjwSWqargigwToyUd0a+ERRrnlruQS3XLYg04AUn6i0tw9aP/923tFUT6vro" +
       "qa57Dcm8Hyp41YKCBUtVM46n3LuxXB0gT1+ccaLjjSEkgFOvOAZYeSdL3euq" +
       "sAN5ZO87W3VNVACB5ZqQ9D4vgqsA5Ik7Ms1t7avaRjWNmwB5/CIdvx+CVA8U" +
       "hsinAOQdF8kKTtBLT1zw0hn/fGv0wY//pDtwDwqZdUOzc/nvh5OeujBpYiyN" +
       "wHA1Yz/xweeZT6mPfuljBwgCid9xgXhP8+t/89s/9v6nXv/ynuYHb0PDLdaG" +
       "Bm5qn1s89NV3dt7XuicX437fC63c+ec0L8KfPxp5IfVh5j16wjEfPDwefH3y" +
       "L+cf+mXjmwfIVQq5rHl25MA4eljzHN+yjaBvuEagAkOnkAcMV+8U4xRyBV4z" +
       "lmvse7nlMjQAhdxrF12XveI/NNESsshNdAVeW+7SO772VbAqrlMfQZAr8Is8" +
       "CL8/jOw/xS9ANujKcwxU1VTXcj2UD7xc/xA1XLCAtl2hCxj1GzT0ogCGIOoF" +
       "JqrCOFgZRwN5ZqoJQC0Huh+F7tChT3SUjWxg+XZG2P5KnRj6YR50/v/f5dJc" +
       "++vJpUvQMe+8CAs2zKiBZ8PpN7WXo3bv25+/+TsHJ2lyZDeANKEEh3sJDgsJ" +
       "CkiFEhwWEhweS3B4UQLk0qVi4bfnkuyjAfpyA1EB4uWD7xN+nH7xY8/eA8PQ" +
       "T+6FjshJ0TvDducUR6gCLTUYzMjrn04+PP0p7AA5OI+/ufSw62o+nc9R8wQd" +
       "b1zMu9vxvfbRP/6L1z71kneagecA/QgYbp2ZJ/azF+0ceJqhQ6g8Zf/8u9Qv" +
       "3vzSSzcOkHshWkCEBCqMaAg+T11c41yCv3AMlrku90GFl17gqHY+dIxwV8Eq" +
       "8JLTniIAHiquH4Y2fkse8T8Iv62jFCh+89G3+Xn79n3A5E67oEUBxj8i+J/9" +
       "g3/9J9XC3Me4fe3MnVAwwAtnsCJndq1AhYdPY0AMDAPS/adP83/3k9/66F8v" +
       "AgBSvPt2C97I2w7ECOhCaOa//eXtv//61z73ewenQQPgzTJa2JaWniiZ9yNX" +
       "76IkXO09p/JArLFhAuZRc0NyHU+3lpa6sI08Sv/3tefKX/xvH7++jwMb9hyH" +
       "0fu/O4PT/h9oIx/6nZ/4H08VbC5p+b3u1GanZHsAfdspZyII1CyXI/3wv33y" +
       "F35b/SyEYgh/obUzCkQ7KGxwUGj+DoBUv9dM7UCSXEKYpPlUrPA6WrB5vmgP" +
       "c4sVzJFirJo3T4dns+d8gp4pam5qn/i9P3vr9M/++bcLdc9XRWeDhVX9F/bx" +
       "mTfvSiH7xy5CxUANV5Cu9vrob1y3X/8O5KhAjhoExpALoDLpudA6or7vyn/4" +
       "zd969MWv3oMckMhV21N1Ui2yFHkApocRriDopf5f+7F9dCT3w+Z6oSpyi/L7" +
       "qHq8+HcPFPB9dwYoMi9qTnP88f/F2YuP/Jf/eYsRCmi6zb38wnwFffUzT3R+" +
       "9JvF/FOMyGc/ld6K5rAAPJ1b+WXnzw+evfwvDpArCnJdO6oup6od5ZmnwIoq" +
       "PC45YQV6bvx8dbQvBV44wcB3XsSnM8teRKfTuwi8zqnz66tnAekv4ecS/P7f" +
       "/JubO+/Y35Mf6RwVBu86qQx8P70E0/2+yiF+iOXziYLLM0V7I2/eu3dTfvlD" +
       "EBfCoqyFM5aWq9rFwm0AQ8zWbhxzn8IyF/rkxtrGj5PoehFOufaH+9pwj4h5" +
       "WytY7EMCv2P4fHBPVdz6HjplxniwzPzZP/zE7/7cu78OfUoj98W5vaErz6w4" +
       "ivLK+6df/eSTb3n5Gz9bwBzEuOmHnvvvRR0zupvGedPPm8Gxqk/kqgpFHcGo" +
       "IWALZDL0Qtu7hjIfWA4E8PiorERfeuTrm8/88a/sS8aLcXuB2PjYyz/zl4cf" +
       "f/ngTKH+7ltq5bNz9sV6IfRbjywcIM/cbZViBvlHr730T//RSx/dS/XI+bKz" +
       "B5+qfuXf/Z/fPfz0N75ym5rmXtt7E44F11aDWkgRxx+mrBh1Qkonblydj/BE" +
       "LNcH1XaSJoNVTcV7k8RxU4dt1QYEX16HzQwbaSVHwfGSEumOOm8sqgsOGzWn" +
       "bZoa2kPJ9IcDtM2x244lkQKYeFWZnooNK1SH6RyMha1OD2maFDIvqCeZ6JSq" +
       "vqM7ijvATKuiBr5rVEulKI5L6KzaAPW10lxJWNYdiZy04re1HdsS/ObKLIu0" +
       "Sg1HYwxg5HLGbOP1oN7IavqibCq0IZb8gUo7AJuMwIZ0hJAJ6QTYZWMi2YpV" +
       "Xy16vZ1nKru+2B9ycubHqigvGAUi2FRW6DqoK6Ywag/Wwsr36GTR3HTUMGss" +
       "CEFjvKxNyz1TwGOCB9iS1nuumJarWTTBM6uv9YZTPpKtudvSyRW3CbqqUAtq" +
       "6ipsxio7ni58Z02Vtn2zmXap5miYasqGS7iZrwxMAdAlr1Sq7lCJqRBzQplO" +
       "5xjT0hJDcYLhsAd6glJdVBpOYjMOs6QiaaJtsO6u5y6mpIuJRNj3FHIgl/Wh" +
       "3ymttq4/7Y3FhtsZSPgm8qSOBrhxhql2W9qpC4cmFI6cZHJVS/uLie6OZjK2" +
       "pvl0zgWJuYyixqzUFGmhjKFbhZFmqUISHaLBtAjOZLozosuw643coZdgaCbO" +
       "ospuOMdapyu8KqyH49LWHuqrUlqeh10OsBgXNmSKLCVWoy87tIopcqyOkyEf" +
       "z8rDSaeNDWYVtRHZ3nwRtptSQCtttjOiEwMPh9NRX+nO2pnAoOthxi10rU1I" +
       "GRC6vZLfl2fOlhYanc7I9jbetI3BQGX87XxEcLbUJXbjmioEQ5IZyFsRrlPe" +
       "aIxOD0ic65tDf0hQpMjRrk2nnDanDXXJxJuK0tzJDVzTG1FDGFcEgrXg2LDT" +
       "3JS6glYpCSIWZuOkv3TaI5epZYZV0lFtZ1AdkuBZMFiMBs2aD9yg7Oo871gT" +
       "kUMJtiqbcs9pLlaYMuxWwFiekHLMSFQ6nIkju8on2m4uz1Ijm7S8hOvJSsW2" +
       "WG7l79qZgrsLPGjNl2qVGroRFcmCv52I85422vgLQZlLSr/uDrusr3gekFhR" +
       "mvSMke4TjOHhzDAYNUCmirTRNuC4FWmbarPtWUJCUKutp1RlqbzdBYArKe3a" +
       "rmT1NoRfywaTGmMx8qSa7tgVZWA2FYodeZttPXm92qgNp9SnDIolGKVbG/cT" +
       "6Ihkq0ojlu0nipn1h/q63WPYAdbl/T6BMvB/ie2nAyKeb3pGnRuWd7K97HGT" +
       "ScnihWQy3vIiiqOMMu3ifZlrE/0dS7itucR21iNnMxSpFtNuMQHXbJZIF1XY" +
       "tY310rAqbmtERxrK7U5vZY4ti+qRlNBuZzSxrtNCp22Sqxq98S15zIf18arX" +
       "Hq8ZrLzEcGA1tUor6CvWil/PyZFJ03KVF6TmeDSQGs01Fg/6ldCRNw1Yc9Qp" +
       "fzOhqfq05ljb+ULcsuP5ao15a9AA7IAa9OslmUvpasusrVnMEiRz2Z4x1E6d" +
       "CU5F6utrPpMSvp0ZuDcpDaySIZvxUMyk0VpHRV13++P2YCS2rVqdVCld9For" +
       "j232W10F3XbWPVDB+VW9qcdVo1o31ZHb3m18ttF01FV322piKN/t+YrMNCZ8" +
       "qlTVake3Amq42nU2NaoJMS3GFE7s+9XaOt5K5mZI76T1ZCJp2roT1TdcfxQt" +
       "Kh0agB7X3CVC5ngKz60qBsAXM6uP6W6jteZCOdFwLXNXmrmcorNtC0X9ss7N" +
       "OoylT0ne3U5ImNdoddXVN2XL7MjzUQBAyKZeN6pKXGokDaOyGOmVTjpmOg42" +
       "b0eV3ngVhJRENKu6UeVnspEZfNwmMVxJu8tNkx/TjpQJWxpVhcaKHiaVNT0b" +
       "mBbfCccsoLeVfllIRGgKLOmTnsy3wgruO5ZWqth6XJn3Ovy8pgRirUrgOlp1" +
       "/azUjKrocKSEhE05dF3fkUk2LC14rWtX+8Rcn+w2mY5DMkqLMT5cGVi3N4ok" +
       "moY3AKlPjEk64OuGIDAp0KhNp9Pb0FqiOjOrXEFFplOXGWFGOcMONyHXKk4q" +
       "qrtt0S29zc+m89koQFNLKy+VZtMoq55TjiljXrGdUgBst2yFWdLFuWXNa4Xw" +
       "UafWrqqyKFca0TSbo+0a3krIfkfu16OR1FFEqu5X9Ik4bOGl1ozb6XhdnnjU" +
       "QmBkC9PG/WGQSVOKxNkBS9XcSR9tzsu2K7NTiRaZ8hg+rAXwOYrgGGHbbNUx" +
       "353HuhOvbZduLUtGd7Vp0qw+jwfLDtqt61C01TYs0SKuNdzZfMDW+v3JKpzR" +
       "A7vvD/B1mnDMoGyKU1nSh3MZo7GxN2s22ijakgIPGzqzTiS4wy3uk5kd2h3H" +
       "GAkgyZR0g1nYdiwaZjwFeAsFPDArEV9vNk23Oqo3Tak0CCdDpp8ZJJ5YKNNx" +
       "Zy1QcRdljMV3AgHvf4NuQxZxaWlk9lqLNlGNs3BGzsbTRt3tRn51HIZM30u2" +
       "XGs6bY9w1RMVprlRE2KnVYZou4f3RhRJ1Zi2kbhylgx3i2m9JZc2o95GHMF2" +
       "gUk7P2EB1pAy0Riu4I1uQimlxRB3DTKDwVxVSK9VngwbTIC3fLmiNcNAwm07" +
       "IqlRbLQogibnnGaa41S1l+qshgKbVyup2Ei6A8Uwxxu5qmbr2iJuVFdpaSKn" +
       "gNZ9gbQ7/GA+GBkzehnPZxKJEnTCj+IlCSOBIbblUKVm4jzegcWowYz78nRg" +
       "eXQUjAeraq0arnnUTSQpbKO425k0d5VBvC6RDbLVznZxmNSXAspwfKtWL5sD" +
       "VjKNBdcLZpLjTVmZ785qeLyMAw9fl9sGvP9xw80c6wqkJMq4PSdDIJo7sqow" +
       "ZSdCp6gRoDC0+s1OHGErW/anVX9qzyhgVIbNHWb2tWWV51S15FTKlFmna/2p" +
       "uEm1FVbhWzN8ukwdLhQ4y0LxKCBZrKabqjFYqGIw2KF8xa+QwpLZmUQlbmAY" +
       "p/Oj1MvIuiM7LmGSYeQI1bXIdefjVbTcRGVKW9RGiTESyQUwyGRbm7ortkJ0" +
       "ltwAgr2UgDVdHwszpqUTfhDPXXZBQzy3qxKo68IgNbAZQYV1jplTk34GYy5Y" +
       "ThbEGJf8kAloi2Eafa9bK6fzyjjY1cGQ7Zc1dt136wYz2aYNMXHCrsPsiCax" +
       "nUh6b6BEi4QZrcDc4CydWjGg0owH9Uql5fNyCaOmXlfWGnKGlxy3FEezMhbK" +
       "mtojcBwMuaVv+ssJ14g3vNuzMKoGSEYLtA7b6oLQoRZYPUJXKN8SCUAa83FP" +
       "n7Wb3Xk9ndA1ULM6lVjrk3UB3fYnu4YlzRo9vW9TDT5A18p0olQYaSqsezFa" +
       "52V3FgC0FpvpsAzMXTTaTBeDBcYngdzNxoxVTreDebVlNGHSVYxl0IpX+GgA" +
       "9HWT49gesP1YkaHXqnU1o/sDXh20AjM2NyZIFu1NWHYoXGyCepSNK6Ukqs13" +
       "fW7W9HSxPknSppEaiiWqrjhoTX1VVEwuoKrKctTrtjbL6Xgu10vdckYs20Ea" +
       "DKYeN83kVmzPUruUiqa8Rj1Zp1nb48PRaFNql4SZvWaaFX1ONkomRYBJF04a" +
       "mo1KVi67ZXvcnq2NTsOcWVi7zJXg2rDwN4lhdyvDZIKZAWEmyHapNDbHM9Tb" +
       "jtk0kaISGoXjdbOVNeNyP9xWUT/URmV7xnJVtONwXdsJSoY7rlaWYica+jDm" +
       "bX9nRyFJiBjpV4WuV4sAEH0FzcRwLFA4t211bWYed6N6gtmlBZFNxRRXymXL" +
       "5+qprKSSqQIb9VuiM5fh48lQZSrSMpljqCIkcbyuYH6lX4HIPdbsVTxb0bzJ" +
       "RGNqGCuouIvX3a1Jp1HC9Ax9zYoZg/I9fr5rlHeVGu4SMj0UN+EY1SRYEs1x" +
       "xTHQWk0rLxbrMl4a87KichuM2tD1LjUSVzs5lpcVdFQXbDrubqs70QpbgVge" +
       "A12hF2YmJ43mYMertR5dsoj1ZrGoMxHNtqKMrNLxYOFmFR0FzKypYzFd6W07" +
       "2m60jkoTlC0BzuVVzvUMXB2EGCovp5NxOZmALVrDluvpts4u44yLLG9V7tlg" +
       "7HZrUbwcmOs1qvFLndLqbbaR0MyKr9IterStLNLKjJJY1gmwTRooOJsRFtsm" +
       "/U3AhSomo/PYWlbHHTKNOcdJ4pk93WG+j/bZClobtmTQJR2rL/QXXNccNatA" +
       "M+qptq0TWBBETqlbMQg8ZNeLtMvV+k4/aVa21WBnO61GYDQ6Xb67Goe8Ch8S" +
       "XAJfyyUCFebyylalJXyy/pH8kfvmG9v1eLjY4Dk5CVzbeD5Av4Gn/f3QM3nz" +
       "3MmucvG5fPH06Oyu8ulOIZLvYDx5pwO+Yvficx95+RWd+8XywdEOqwKQB4Dn" +
       "/7BtxIZ9htUVyOn5O+/UsMX55unO329/5E+fEH909eIbOBB5+oKcF1n+Evvq" +
       "V/rv0f7OAXLPyT7gLSev5ye9cH7372pggChwxXN7gE+eWPZtucV+CH47R5bt" +
       "3P5Q4rZRcKmIgr3vL2xgX9gdf6LYZjvdDRdUx7cN1tON4ng1LnhEd9kEz/LG" +
       "B8g7rPAmzPCbPNEZ3mzPxd7NDsfyxRTpTGjNAXJl4Xm2obqnYbf9bptMZxct" +
       "OpwTOz2Rd5bh98UjO734/bHTpaPjtyM7PXnBTnJggeKwQA2BERQcfvouVvqZ" +
       "vPkwQB671UQ3KWjxfPijpwb5yJs1yLPw+4Ujg3zh+2qQQtKC4OW76PupvPk5" +
       "gNyveX7WVYF6QcFPvAkFH8s7n4aiPLGfu//9HhU8OMXHu6VH/rfYTt+fAv39" +
       "u6j6D/Lm70FVHXVTHI+d26c9j00TNSkA76b2T8bf+Opnd6+9ut+GXaihAZDS" +
       "nV6OufX9nPxI9bm7HAufvjbx5/0PvP4n/3X648eQ+pYTOz6Sq/Do3ex4HPwP" +
       "nT2A2p/2/dKpLz/zJnz5zrzzPXDtZ45keOav3Je/ehdffjFvPg+Qq7kv217k" +
       "6uGxDR45AYCJoUE8N23j1ASvvQkTPJV3vh+q/t4jE7z3+2iCM0m71/4376L9" +
       "b+XNP4PuXlrpxfvAqa5fehO6Ppl3Pg8F+sCRrh/4q9T1X91F13+TN18GyFuh" +
       "rh3P9oJC1WNn/8AFtL9AUdjhK2/EDilArl98EyQ/1n78lrfS9m9SaZ9/5dr9" +
       "j70i/X7xMsTJ204PMMj9y8i2zx4inrm+7AcG1Keg3B8p+sXPHwDkvd/jKTjE" +
       "sePLQonf33P4jwB56u4cAHJf8Xt21tcA8vidZgHkHtiepf7PAHn77aghJWzP" +
       "Uv4htOZFSrh+8XuW7o9gJp/SAeTy/uIsyZ9C7pAkv/ym/4ZfGSAWIQhUDUBv" +
       "ppfOl7oncfLId4uTM9Xxu89BevFi43H9GfFHd47XXqFHP/ntxi/uXzfRbHW3" +
       "y7nczyBX9m++nNSwz9yR2zGvy4P3feehLzzw3PHN4aG9wKdJeEa2p2//bkfP" +
       "8UHxNsbuNx77tQ/+w1e+VpzP/j+UP9IncSoAAA==");
}
