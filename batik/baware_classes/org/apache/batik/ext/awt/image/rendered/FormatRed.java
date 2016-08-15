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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Z4pXfJv1Xz9vOtuvIQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "viOeum0FL27rHkfq6e6+7i31Ky8x/Ee/");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("3/ji7mKV6shZlmu5DBbb3R2vk2j/3ffUdqzrEv3Mqw9/9cGnj79MHt51eD/N" +
       "TvXtXXe/xUS6QVLcO8r+8Tt+9Sf/7kt/WJyy/x8neGnTRi0AAA==");
}
