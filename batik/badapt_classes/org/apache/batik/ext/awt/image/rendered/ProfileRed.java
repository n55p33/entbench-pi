package org.apache.batik.ext.awt.image.rendered;
public class ProfileRed extends org.apache.batik.ext.awt.image.rendered.AbstractRed {
    private static final java.awt.color.ColorSpace sRGBCS = java.awt.color.ColorSpace.
      getInstance(
        java.awt.color.ColorSpace.
          CS_sRGB);
    private static final java.awt.image.ColorModel sRGBCM = new java.awt.image.DirectColorModel(
      sRGBCS,
      32,
      16711680,
      65280,
      255,
      -16777216,
      false,
      java.awt.image.DataBuffer.
        TYPE_INT);
    private org.apache.batik.ext.awt.color.ICCColorSpaceExt
      colorSpace;
    public ProfileRed(org.apache.batik.ext.awt.image.rendered.CachableRed src,
                      org.apache.batik.ext.awt.color.ICCColorSpaceExt colorSpace) {
        super(
          );
        this.
          colorSpace =
          colorSpace;
        init(
          src,
          src.
            getBounds(
              ),
          sRGBCM,
          sRGBCM.
            createCompatibleSampleModel(
              src.
                getWidth(
                  ),
              src.
                getHeight(
                  )),
          src.
            getTileGridXOffset(
              ),
          src.
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
    public java.awt.image.WritableRaster copyData(java.awt.image.WritableRaster argbWR) {
        try {
            java.awt.image.RenderedImage img =
              getSource(
                );
            java.awt.image.ColorModel imgCM =
              img.
              getColorModel(
                );
            java.awt.color.ColorSpace imgCS =
              imgCM.
              getColorSpace(
                );
            int nImageComponents =
              imgCS.
              getNumComponents(
                );
            int nProfileComponents =
              colorSpace.
              getNumComponents(
                );
            if (nImageComponents !=
                  nProfileComponents) {
                java.lang.System.
                  err.
                  println(
                    "Input image and associated color profile have" +
                    (" mismatching number of color components: conversion is not p" +
                     "ossible"));
                return argbWR;
            }
            int w =
              argbWR.
              getWidth(
                );
            int h =
              argbWR.
              getHeight(
                );
            int minX =
              argbWR.
              getMinX(
                );
            int minY =
              argbWR.
              getMinY(
                );
            java.awt.image.WritableRaster srcWR =
              imgCM.
              createCompatibleWritableRaster(
                w,
                h);
            srcWR =
              srcWR.
                createWritableTranslatedChild(
                  minX,
                  minY);
            img.
              copyData(
                srcWR);
            if (!(imgCM instanceof java.awt.image.ComponentColorModel) ||
                  !(img.
                      getSampleModel(
                        ) instanceof java.awt.image.BandedSampleModel) ||
                  imgCM.
                  hasAlpha(
                    ) &&
                  imgCM.
                  isAlphaPremultiplied(
                    )) {
                java.awt.image.ComponentColorModel imgCompCM =
                  new java.awt.image.ComponentColorModel(
                  imgCS,
                  imgCM.
                    getComponentSize(
                      ),
                  imgCM.
                    hasAlpha(
                      ),
                  false,
                  imgCM.
                    getTransparency(
                      ),
                  java.awt.image.DataBuffer.
                    TYPE_BYTE);
                java.awt.image.WritableRaster wr =
                  java.awt.image.Raster.
                  createBandedRaster(
                    java.awt.image.DataBuffer.
                      TYPE_BYTE,
                    argbWR.
                      getWidth(
                        ),
                    argbWR.
                      getHeight(
                        ),
                    imgCompCM.
                      getNumComponents(
                        ),
                    new java.awt.Point(
                      0,
                      0));
                java.awt.image.BufferedImage imgComp =
                  new java.awt.image.BufferedImage(
                  imgCompCM,
                  wr,
                  imgCompCM.
                    isAlphaPremultiplied(
                      ),
                  null);
                java.awt.image.BufferedImage srcImg =
                  new java.awt.image.BufferedImage(
                  imgCM,
                  srcWR.
                    createWritableTranslatedChild(
                      0,
                      0),
                  imgCM.
                    isAlphaPremultiplied(
                      ),
                  null);
                java.awt.Graphics2D g =
                  imgComp.
                  createGraphics(
                    );
                g.
                  setRenderingHint(
                    java.awt.RenderingHints.
                      KEY_COLOR_RENDERING,
                    java.awt.RenderingHints.
                      VALUE_COLOR_RENDER_QUALITY);
                g.
                  drawImage(
                    srcImg,
                    0,
                    0,
                    null);
                img =
                  imgComp;
                imgCM =
                  imgCompCM;
                srcWR =
                  wr.
                    createWritableTranslatedChild(
                      minX,
                      minY);
            }
            java.awt.image.ComponentColorModel newCM =
              new java.awt.image.ComponentColorModel(
              colorSpace,
              imgCM.
                getComponentSize(
                  ),
              false,
              false,
              java.awt.Transparency.
                OPAQUE,
              java.awt.image.DataBuffer.
                TYPE_BYTE);
            java.awt.image.DataBufferByte data =
              (java.awt.image.DataBufferByte)
                srcWR.
                getDataBuffer(
                  );
            srcWR =
              java.awt.image.Raster.
                createBandedRaster(
                  data,
                  argbWR.
                    getWidth(
                      ),
                  argbWR.
                    getHeight(
                      ),
                  argbWR.
                    getWidth(
                      ),
                  new int[] { 0,
                  1,
                  2 },
                  new int[] { 0,
                  0,
                  0 },
                  new java.awt.Point(
                    0,
                    0));
            java.awt.image.BufferedImage newImg =
              new java.awt.image.BufferedImage(
              newCM,
              srcWR,
              newCM.
                isAlphaPremultiplied(
                  ),
              null);
            java.awt.image.ComponentColorModel sRGBCompCM =
              new java.awt.image.ComponentColorModel(
              java.awt.color.ColorSpace.
                getInstance(
                  java.awt.color.ColorSpace.
                    CS_sRGB),
              new int[] { 8,
              8,
              8 },
              false,
              false,
              java.awt.Transparency.
                OPAQUE,
              java.awt.image.DataBuffer.
                TYPE_BYTE);
            java.awt.image.WritableRaster wr =
              java.awt.image.Raster.
              createBandedRaster(
                java.awt.image.DataBuffer.
                  TYPE_BYTE,
                argbWR.
                  getWidth(
                    ),
                argbWR.
                  getHeight(
                    ),
                sRGBCompCM.
                  getNumComponents(
                    ),
                new java.awt.Point(
                  0,
                  0));
            java.awt.image.BufferedImage sRGBImage =
              new java.awt.image.BufferedImage(
              sRGBCompCM,
              wr,
              false,
              null);
            java.awt.image.ColorConvertOp colorConvertOp =
              new java.awt.image.ColorConvertOp(
              null);
            colorConvertOp.
              filter(
                newImg,
                sRGBImage);
            if (imgCM.
                  hasAlpha(
                    )) {
                java.awt.image.DataBufferByte rgbData =
                  (java.awt.image.DataBufferByte)
                    wr.
                    getDataBuffer(
                      );
                byte[][] imgBanks =
                  data.
                  getBankData(
                    );
                byte[][] rgbBanks =
                  rgbData.
                  getBankData(
                    );
                byte[][] argbBanks =
                  { rgbBanks[0],
                rgbBanks[1],
                rgbBanks[2],
                imgBanks[3] };
                java.awt.image.DataBufferByte argbData =
                  new java.awt.image.DataBufferByte(
                  argbBanks,
                  imgBanks[0].
                    length);
                srcWR =
                  java.awt.image.Raster.
                    createBandedRaster(
                      argbData,
                      argbWR.
                        getWidth(
                          ),
                      argbWR.
                        getHeight(
                          ),
                      argbWR.
                        getWidth(
                          ),
                      new int[] { 0,
                      1,
                      2,
                      3 },
                      new int[] { 0,
                      0,
                      0,
                      0 },
                      new java.awt.Point(
                        0,
                        0));
                sRGBCompCM =
                  new java.awt.image.ComponentColorModel(
                    java.awt.color.ColorSpace.
                      getInstance(
                        java.awt.color.ColorSpace.
                          CS_sRGB),
                    new int[] { 8,
                    8,
                    8,
                    8 },
                    true,
                    false,
                    java.awt.Transparency.
                      TRANSLUCENT,
                    java.awt.image.DataBuffer.
                      TYPE_BYTE);
                sRGBImage =
                  new java.awt.image.BufferedImage(
                    sRGBCompCM,
                    srcWR,
                    false,
                    null);
            }
            java.awt.image.BufferedImage result =
              new java.awt.image.BufferedImage(
              sRGBCM,
              argbWR.
                createWritableTranslatedChild(
                  0,
                  0),
              false,
              null);
            java.awt.Graphics2D g =
              result.
              createGraphics(
                );
            g.
              setRenderingHint(
                java.awt.RenderingHints.
                  KEY_COLOR_RENDERING,
                java.awt.RenderingHints.
                  VALUE_COLOR_RENDER_QUALITY);
            g.
              drawImage(
                sRGBImage,
                0,
                0,
                null);
            g.
              dispose(
                );
            return argbWR;
        }
        catch (java.lang.Exception e) {
            e.
              printStackTrace(
                );
            throw new java.lang.Error(
              e.
                getMessage(
                  ));
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
      ("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");
}
