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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1aecwsWVWv9828ZR4z894MzMLI7I9lpvCrXqu78wSpru6q" +
       "Xqq7uqu6q7sL5VF7VXdtXUvXgqNAVFAUUQYcEpjEBALisGggGAlmjAsQiAmG" +
       "uCUCMSaiSML8IRpHxVvV3/6WmYnGTur27XvPOfecc8/51V36me9Dp30Pgl3H" +
       "TDTTCXaVONhdmtXdIHEVf7dHVUeC5ysybgq+PwFtV6RHPnvhh8+/T7+4A53h" +
       "oZcLtu0EQmA4ts8ovmNuFJmCLhy2tk3F8gPoIrUUNgISBoaJUIYfXKaglx1h" +
       "DaBL1L4KCFABASoguQoIdkgFmG5T7NDCMw7BDvw19LPQKQo640qZegH08HEh" +
       "ruAJ1p6YUW4BkHAu+80Bo3Lm2IMeOrB9a/NVBn8ARp78zbdc/L2boAs8dMGw" +
       "2UwdCSgRgEF46FZLsUTF8zFZVmQeusNWFJlVPEMwjTTXm4fu9A3NFoLQUw6c" +
       "lDWGruLlYx567lYps80LpcDxDsxTDcWU93+dVk1BA7befWjr1kIiawcGnjeA" +
       "Yp4qSMo+y80rw5YD6MGTHAc2XuoDAsB61lIC3TkY6mZbAA3Qndu5MwVbQ9jA" +
       "M2wNkJ52QjBKAN13XaGZr11BWgmaciWA7j1JN9p2AapbckdkLAF010myXBKY" +
       "pftOzNKR+fn+8Cfe+za7Y+/kOsuKZGb6nwNMD5xgYhRV8RRbUraMtz5OfVC4" +
       "+0vv3oEgQHzXCeItzRd+5rk3vf6BZ7+ypfmxa9DQ4lKRgivSR8Xbv/Eq/LHG" +
       "TZka51zHN7LJP2Z5Hv6jvZ7LsQsy7+4DiVnn7n7ns8yfLd7+SeV7O9D5LnRG" +
       "cszQAnF0h+RYrmEqHqnYiicEityFblFsGc/7u9BZUKcMW9m20qrqK0EXutnM" +
       "m844+W/gIhWIyFx0FtQNW3X2664Q6Hk9diEIOgse6FbwFKDtJ/8OIAXRHUtB" +
       "BEmwDdtBRp6T2e8jih2IwLc6IoKoXyG+E3ogBBHH0xABxIGu7HVkmSlEAWJY" +
       "YPoRMB0ymBM5k5PpxSjybhZu7v/XQHFm8cXo1CkwGa86CQUmyKKOYwLGK9KT" +
       "YbP93KevfG3nIDX2fBVAJTD27nbs3XzsHEbB2Lv52Lv7Y+8ejg2dOpUP+YpM" +
       "h+3cg5lbAQwA6HjrY+xP99767kduAkHnRjcDt2ekyPVBGj9EjW6OjRIIXejZ" +
       "p6J3cD9X2IF2jqNtpjdoOp+xjzKMPMDCSyez7FpyL7zruz/8zAefcA7z7Rh8" +
       "78HA1ZxZGj9y0sOeIykyAMZD8Y8/JHz+ypeeuLQD3QywAeBhIID4BVDzwMkx" +
       "jqXz5X1ozGw5DQxWHc8SzKxrH8/OB7rnRIct+dTfntfvAD5+WRbfd4GnvRfw" +
       "+XfW+3I3K1+xDZVs0k5YkUPvG1j3I3/95/9Uzt29j9IXjrz3WCW4fAQZMmEX" +
       "cgy44zAGJp6iALq/e2r0/g98/11vzgMAUDx6rQEvZSUOEAFMIXDzL3xl/Tff" +
       "/tZHv7lzGDQBeDWGomlI8YGRWTt0/gZGgtFec6gPQBYTJF0WNZemtuXIhmoI" +
       "oqlkUfqfF15d/Py/vPfiNg5M0LIfRq9/YQGH7a9sQm//2lv+7YFczCkpe7Md" +
       "+uyQbAuXLz+UjHmekGR6xO/4i/s/9GXhIwB4Adj5Rqrk+LWT+2Ant/yuACq/" +
       "2BzFAUmmIUjSfV7kurwAmR1vt4vjeFZhAYnSjoM8UJCc+/G83M2cnOsD5X3V" +
       "rHjQP5pwx3P6yKrnivS+b/7gNu4Hf/hc7qHjy6aj8TUQ3MvbkM6Kh2Ig/p6T" +
       "6NIRfB3QVZ4d/tRF89nngUQeSJQAfvq0B+yPj0XjHvXps3/7R39891u/cRO0" +
       "Q0DnTUeQCSFPbOgWkFGKrwOEjN2ffNM2oKJzoLiYmwpdZfw2EO/Nf50BCj52" +
       "fUwjslXPISzc+x+0Kb7z7//9KifkaHaNl/0Jfh555sP34W/8Xs5/CCsZ9wPx" +
       "1dAPVoiHvKVPWv+688iZP92BzvLQRWlv+ckJZpglKw+WXP7+mhQsUY/1H18+" +
       "bdcKlw9g81UnIe3IsCcB7fCVA+oZdVY/fwLDXpl5uQqe0l56F09i2Ckor+A5" +
       "y8N5eSkrXpvPyU0BdNb1jA1YWwDw8POVbgD0MGzB3AORH4HPKfD8d/Zk0rOG" +
       "7dLgTnxvffLQwQLFdTM5DNnE2f1semUeYIfZc5g6W3zNSjQrWtsRG9eNrDce" +
       "t7sCnst7dpevY/f4OnZnVTIrOlnRzd3a21d9cLXqW9DIVR84smKeUJ158apn" +
       "SyzodeB5w57qb7iO6vy1VT+Vq76v8HnpmDdLJ/R68wvqlcuJT4F3x+nSbm23" +
       "kP0WbuC0113ttHuWpnRpPxQ4sDUCaXppadb2vXgx92KWELvb/cQJJXsvWkmA" +
       "ILcfCqMcsDV5zz+87+u/9ui3QZr3oNObLAVBdh8ZcRhmu7VffOYD97/sye+8" +
       "J39ZAh9yP//8fW/KpC5fmqn3Zaay+QqUEvxgkL/fFDm39oboNvIMCywDNntb" +
       "EeSJO7+9+vB3P7XdZpyEshPEyruf/OUf7b73yZ0jm7tHr9pfHeXZbvBypW/b" +
       "87AHPXyjUXIO4h8/88QXP/HEu7Za3Xl8q9IGO/FP/eV/fX33qe989Rpr4ptN" +
       "538xscFtf9Kp+F1s/0MVF0opmsaxpdKVkRprDSV2sOYCxeqSLy3dbmHQoxfR" +
       "ouOUvFXJUZZjSSoHacOnlJrXrfFVWC4YTFeYaV53um6u8LU+1WbGeMK0OYEu" +
       "CStbZqwCSJvSVG/V2L7HrJGCJToaz02EDVtE1GEtqMA1H8W44ZxNnaK98eV6" +
       "uZymcA3lk1TtysOBVpumZnuChoN0xDpItym4mt/haEdQ0KYvTAocNm8kSLUM" +
       "w/XRqu60rQmBpxO0Z1lJLe2xBYvFKF6er7jebFGSGgtyuSJb5CJZVJlkxg0m" +
       "PMX7DYsvMjy/Kq8Vk2Qo350K0pAY0a2JxVXQdE74rV60NPwe7s7aYYGe2CrB" +
       "iqUVqgxCRQg7I1rgx9LaX9c3Kxc34VW3xgrdGsUux6FVizyx2uLCtTBoJb6w" +
       "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" +
       "AAA=");
}
