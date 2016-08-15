package org.apache.batik.ext.awt.image.rendered;
public class FormatRed extends org.apache.batik.ext.awt.image.rendered.AbstractRed {
    public static org.apache.batik.ext.awt.image.rendered.CachableRed construct(org.apache.batik.ext.awt.image.rendered.CachableRed src,
                                                                                java.awt.image.ColorModel cm) {
        java.awt.image.ColorModel srcCM =
          src.
          getColorModel(
            );
        if (cm.
              hasAlpha(
                ) !=
              srcCM.
              hasAlpha(
                ) ||
              cm.
              isAlphaPremultiplied(
                ) !=
              srcCM.
              isAlphaPremultiplied(
                ))
            return new org.apache.batik.ext.awt.image.rendered.FormatRed(
              src,
              cm);
        if (cm.
              getNumComponents(
                ) !=
              srcCM.
              getNumComponents(
                ))
            throw new java.lang.IllegalArgumentException(
              "Incompatible ColorModel given");
        if (srcCM instanceof java.awt.image.ComponentColorModel &&
              cm instanceof java.awt.image.ComponentColorModel)
            return src;
        if (srcCM instanceof java.awt.image.DirectColorModel &&
              cm instanceof java.awt.image.DirectColorModel)
            return src;
        return new org.apache.batik.ext.awt.image.rendered.FormatRed(
          src,
          cm);
    }
    public FormatRed(org.apache.batik.ext.awt.image.rendered.CachableRed cr,
                     java.awt.image.SampleModel sm) { super(
                                                        cr,
                                                        cr.
                                                          getBounds(
                                                            ),
                                                        makeColorModel(
                                                          cr,
                                                          sm),
                                                        sm,
                                                        cr.
                                                          getTileGridXOffset(
                                                            ),
                                                        cr.
                                                          getTileGridYOffset(
                                                            ),
                                                        null);
    }
    public FormatRed(org.apache.batik.ext.awt.image.rendered.CachableRed cr,
                     java.awt.image.ColorModel cm) { super(
                                                       cr,
                                                       cr.
                                                         getBounds(
                                                           ),
                                                       cm,
                                                       makeSampleModel(
                                                         cr,
                                                         cm),
                                                       cr.
                                                         getTileGridXOffset(
                                                           ),
                                                       cr.
                                                         getTileGridYOffset(
                                                           ),
                                                       null);
    }
    public org.apache.batik.ext.awt.image.rendered.CachableRed getSource() {
        return (org.apache.batik.ext.awt.image.rendered.CachableRed)
                 getSources(
                   ).
                 get(
                   0);
    }
    public java.lang.Object getProperty(java.lang.String name) {
        return getSource(
                 ).
          getProperty(
            name);
    }
    public java.lang.String[] getPropertyNames() { return getSource(
                                                            ).
                                                     getPropertyNames(
                                                       );
    }
    public java.awt.image.WritableRaster copyData(java.awt.image.WritableRaster wr) {
        java.awt.image.ColorModel cm =
          getColorModel(
            );
        org.apache.batik.ext.awt.image.rendered.CachableRed cr =
          getSource(
            );
        java.awt.image.ColorModel srcCM =
          cr.
          getColorModel(
            );
        java.awt.image.SampleModel srcSM =
          cr.
          getSampleModel(
            );
        srcSM =
          srcSM.
            createCompatibleSampleModel(
              wr.
                getWidth(
                  ),
              wr.
                getHeight(
                  ));
        java.awt.image.WritableRaster srcWR;
        srcWR =
          java.awt.image.Raster.
            createWritableRaster(
              srcSM,
              new java.awt.Point(
                wr.
                  getMinX(
                    ),
                wr.
                  getMinY(
                    )));
        getSource(
          ).
          copyData(
            srcWR);
        java.awt.image.BufferedImage srcBI =
          new java.awt.image.BufferedImage(
          srcCM,
          srcWR.
            createWritableTranslatedChild(
              0,
              0),
          srcCM.
            isAlphaPremultiplied(
              ),
          null);
        java.awt.image.BufferedImage dstBI =
          new java.awt.image.BufferedImage(
          cm,
          wr.
            createWritableTranslatedChild(
              0,
              0),
          cm.
            isAlphaPremultiplied(
              ),
          null);
        org.apache.batik.ext.awt.image.GraphicsUtil.
          copyData(
            srcBI,
            dstBI);
        return wr;
    }
    public static java.awt.image.SampleModel makeSampleModel(org.apache.batik.ext.awt.image.rendered.CachableRed cr,
                                                             java.awt.image.ColorModel cm) {
        java.awt.image.SampleModel srcSM =
          cr.
          getSampleModel(
            );
        return cm.
          createCompatibleSampleModel(
            srcSM.
              getWidth(
                ),
            srcSM.
              getHeight(
                ));
    }
    public static java.awt.image.ColorModel makeColorModel(org.apache.batik.ext.awt.image.rendered.CachableRed cr,
                                                           java.awt.image.SampleModel sm) {
        java.awt.image.ColorModel srcCM =
          cr.
          getColorModel(
            );
        java.awt.color.ColorSpace cs =
          srcCM.
          getColorSpace(
            );
        int bands =
          sm.
          getNumBands(
            );
        int bits;
        int dt =
          sm.
          getDataType(
            );
        switch (dt) {
            case java.awt.image.DataBuffer.
                   TYPE_BYTE:
                bits =
                  8;
                break;
            case java.awt.image.DataBuffer.
                   TYPE_SHORT:
                bits =
                  16;
                break;
            case java.awt.image.DataBuffer.
                   TYPE_USHORT:
                bits =
                  16;
                break;
            case java.awt.image.DataBuffer.
                   TYPE_INT:
                bits =
                  32;
                break;
            default:
                throw new java.lang.IllegalArgumentException(
                  "Unsupported DataBuffer type: " +
                  dt);
        }
        boolean hasAlpha =
          srcCM.
          hasAlpha(
            );
        if (hasAlpha) {
            if (bands ==
                  srcCM.
                  getNumComponents(
                    ) -
                  1)
                hasAlpha =
                  false;
            else
                if (bands !=
                      srcCM.
                      getNumComponents(
                        ))
                    throw new java.lang.IllegalArgumentException(
                      "Incompatible number of bands in and out");
        }
        else {
            if (bands ==
                  srcCM.
                  getNumComponents(
                    ) +
                  1)
                hasAlpha =
                  true;
            else
                if (bands !=
                      srcCM.
                      getNumComponents(
                        ))
                    throw new java.lang.IllegalArgumentException(
                      "Incompatible number of bands in and out");
        }
        boolean preMult =
          srcCM.
          isAlphaPremultiplied(
            );
        if (!hasAlpha)
            preMult =
              false;
        if (sm instanceof java.awt.image.ComponentSampleModel) {
            int[] bitsPer =
              new int[bands];
            for (int i =
                   0;
                 i <
                   bands;
                 i++)
                bitsPer[i] =
                  bits;
            return new java.awt.image.ComponentColorModel(
              cs,
              bitsPer,
              hasAlpha,
              preMult,
              hasAlpha
                ? java.awt.Transparency.
                    TRANSLUCENT
                : java.awt.Transparency.
                    OPAQUE,
              dt);
        }
        else
            if (sm instanceof java.awt.image.SinglePixelPackedSampleModel) {
                java.awt.image.SinglePixelPackedSampleModel sppsm;
                sppsm =
                  (java.awt.image.SinglePixelPackedSampleModel)
                    sm;
                int[] masks =
                  sppsm.
                  getBitMasks(
                    );
                if (bands ==
                      4)
                    return new java.awt.image.DirectColorModel(
                      cs,
                      bits,
                      masks[0],
                      masks[1],
                      masks[2],
                      masks[3],
                      preMult,
                      dt);
                else
                    if (bands ==
                          3)
                        return new java.awt.image.DirectColorModel(
                          cs,
                          bits,
                          masks[0],
                          masks[1],
                          masks[2],
                          0,
                          preMult,
                          dt);
                    else
                        throw new java.lang.IllegalArgumentException(
                          "Incompatible number of bands out for ColorModel");
            }
        throw new java.lang.IllegalArgumentException(
          "Unsupported SampleModel Type");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "TPGKb7P+C+8BNQuvIQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ePrMCl7c1j2O1NPdfd3b6pdfZviPfK/x");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("hd3FKtWRsyxv5SpYbHd3vE6i/Xffs7Xjtq7Qz37/4a88+Mzxl8nDuwHvp9mp" +
       "sb3r7reYSDdIintH2T96xy//5N95+feLU/b/A/cpCXlGLQAA");
}
