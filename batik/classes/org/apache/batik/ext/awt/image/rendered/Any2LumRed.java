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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1YfWwUxxWfu/P3t41tiMHGGEOEgbuQhEjUJI057GB6Nq5N" +
       "iGoajrndOd/ivd1ld84+O02bpK2glRohQoBWiv9yFKVNCKoatZWayFWkJhFp" +
       "paSobVqFVuo/6QdqUKX0D/r13uze7d7enQlV25N2dm/mzXvzvn7v7b50nVRa" +
       "JulhGg/zBYNZ4WGNT1DTYnJUpZZ1GObi0oUQ/euxD8f3BEnVNGlKUWtMohYb" +
       "UZgqW9OkW9EsTjWJWeOMybhjwmQWM+coV3RtmnQo1mjaUBVJ4WO6zJDgCDVj" +
       "pJVybiqJDGejDgNOumNwkog4SWTIvzwYIw2Sbiy45Os85FHPClKmXVkWJy2x" +
       "E3SORjJcUSMxxeKDWZNsN3R1YUbVeZhlefiEutsxwcHY7iIT9F1u/vjmmVSL" +
       "MMEaqmk6F+pZk8zS1Tkmx0izOzussrR1knyRhGKk3kPMSX8sJzQCQiMgNKet" +
       "SwWnb2RaJh3VhTo8x6nKkPBAnGwqZGJQk6YdNhPizMChhju6i82gbW9eW1vL" +
       "IhWf3R45d+FYy3dDpHmaNCvaFB5HgkNwEDINBmXpBDOtIVlm8jRp1cDZU8xU" +
       "qKosOp5us5QZjfIMuD9nFpzMGMwUMl1bgR9BNzMjcd3Mq5cUAeX8q0yqdAZ0" +
       "7XR1tTUcwXlQsE6Bg5lJCnHnbKmYVTSZk43+HXkd+z8DBLC1Os14Ss+LqtAo" +
       "TJA2O0RUqs1EpiD0tBkgrdQhAE1OusoyRVsbVJqlMyyOEemjm7CXgKpWGAK3" +
       "cNLhJxOcwEtdPi95/HN9fO/Tj2kHtCAJwJllJql4/nrY1OPbNMmSzGSQB/bG" +
       "hoHYedr52ukgIUDc4SO2ab7/hRsP7uhZecumWV+C5lDiBJN4XFpONL27Ibpt" +
       "TwiPUWPoloLOL9BcZNmEszKYNQBhOvMccTGcW1yZ/Mnnnvg2+1OQ1I2SKklX" +
       "M2mIo1ZJTxuKysyHmMZMypk8SmqZJkfF+iiphueYojF79lAyaTE+SipUMVWl" +
       "i/9goiSwQBPVwbOiJfXcs0F5SjxnDUJINVykAa4wsX/izgmLpPQ0i1CJaoqm" +
       "RyZMHfW3IoA4CbBtKpKAqJ+NWHrGhBCM6OZMhEIcpJizgJlJ53lESYP7I+AO" +
       "GXwiQ54v3B3LpCeZHMZwM/5fgrKo8Zr5QACcscEPBSpk0QFdhY1x6Vxm3/CN" +
       "S/Erdphhaji24uRukB22ZYeFbAGcIDssZIdzssOubBIICJHteAbb9+C5WcAA" +
       "AOGGbVOPHjx+ui8EQWfMV4DZkbSvoBhFXaDIoXtceqWtcXHTtV1vBElFjLRR" +
       "iWeoirVlyJwB1JJmncRuSECZcqtFr6daYJkzdYnJAFblqobDpUafYybOc9Lu" +
       "4ZCrZZi1kfKVpOT5ycrF+SePfOmuIAkWFggUWQnYhtsnENbz8N3vB4ZSfJtP" +
       "ffjxK+cf112IKKg4uUJZtBN16PMHhd88cWmgl74af+3xfmH2WoBwTiHlAB17" +
       "/DIKEGgwh+aoSw0onNTNNFVxKWfjOp4y9Xl3RkRrq3huh7Cox5TsgGu3k6Pi" +
       "jqudBo5r7ejGOPNpIarF/VPGc7/62R/uEebOFZZmT0cwxfigB8yQWZuArVY3" +
       "bA+bjAHdBxcnnnn2+qmjImaBYnMpgf04RgHEwIVg5q++dfL9315bvhp045xD" +
       "Nc8koCnK5pXEeVK3ipIgbat7HgBDFXACo6b/YQ3iU0kqNKEyTKy/N2/Z9eqf" +
       "n26x40CFmVwY7bg1A3f+jn3kiSvH/tYj2AQkLMauzVwyG+HXuJyHTJMu4Dmy" +
       "T77X/c036XNQKwCfLWWRCcgNOLmOh1rHyT2fFFaiQIInBFwRDt8tONwlxnvR" +
       "WIIvEWt7cNhieROnMDc9DVdcOnP1o8YjH71+Q2ha2LF542SMGoN2aOKwNQvs" +
       "1/qB7QC1UkB378r451vUlZvAcRo4SgDd1iET9MgWRJVDXVn96x+/0Xn83RAJ" +
       "jpA6VafyCBUJSmohM5iVAnDOGp9+0A6M+RoYWoSqpEj5ogl0zsbSbh9OG1w4" +
       "avEHa7+394WlayJCDZvHei/DO3HYno9V8avyF01vrBZwMEl3ub5G9GTLT51b" +
       "kg89v8vuPtoKe4VhaIVf/sU/3glf/N3bJYpSLdeNnSqbY6pHZghFFtSRMdHy" +
       "uVj2QdPZ3/+wf2bf7ZQQnOu5RZHA/xtBiYHyJcF/lDef+mPX4QdSx2+jGmz0" +
       "mdPP8sWxl95+aKt0Nij6W7sQFPXFhZsGvYYFoSaDRl5DNXGmUYT95nwAdKFj" +
       "++AacgJgqDQil4idPM6V2+rLah9adItQdtHhEVPhAhSoBZ26EHtkFVyYxuGz" +
       "nNTgm+R+yin+f0SQfgqHSTve7/8Pcw0nooaYH8tr3ItrO+FacjReWsVYYhzA" +
       "YadgGoQQN0ydQ84yeLupssRrma9stK/CvLQ58e99Qm5qFWudwOE4J41JJQvA" +
       "oZuYImrOFXf4XOGjEPak/wN7bsK1CFxXHJWv3I498VHGgZUwYjmOtzJidhUj" +
       "LuIAXVITGHGKpg2VFVixy2dFP4kwo/XfMGOWkzq3Nce6sK7oo4D9IitdWmqu" +
       "Wbv08C8FPOZfNhsA6JIZVfXghBczqgyTgY6C0i6Thrh9hZM7P2GNh8TMPQot" +
       "vmxzOAU95uocOKkUd++ur8NbabldnIRg9FJ/A/r7UtRACaOX8gwnLX5KkC/u" +
       "XrpnwN4uHeSu/eAlOQ/cgQQfLxi33RANJaCTh9qFDVGguGiLyOm4VeR4qvTm" +
       "gqIlvivlCkzG/rIE715LB8cfu3Hf83YzLal0UcR3fYxU2319vkhtKsstx6vq" +
       "wLabTZdrtwSdTGm1D+xm73pPGkUh4QwM2i5fp2n15xvO95f3vv7T01XvQZ9w" +
       "lAQoJ2uOer7q2J8woF3NQHdwNOb2B57vkqIFHtz2rYUHdiT/8hvRDxH7vXRD" +
       "efq4dPWFR39+dt0ytMr1oxCJ4J/sNKlTrP0L2iST5sxp0qhYw1k4InBRqDpK" +
       "ajKacjLDRuUYacL8ovjFSdjFMWdjfhZfxTjpK/q0VOIFFnrHeWbu0zOagLhG" +
       "aCjcmYIPXrk6nzEM3wZ3Ju/K9mLd49L+rzX/6ExbaAQwokAdL/tqK5PI9xDe" +
       "b2BuU9Fio/C/4BeA6594odNxAu+ctEWd70G9+Q9C0KTaa6F4bMwwcrS17xh2" +
       "Fr2Iw3eyOM9JYMCZ9UH3JSH/ZfGIw+V/A3PiUgcPFwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Hb46QD2lTuvnjmLRj8DnBHj+N31Sc6cNm5fvffW9DODRgxTA85ITINJPFXbL" +
       "u/mUH8+kPJaVl9LiTZtlSqs/CyAhyPJXwKGZjmhlA9dC4GKWfGlfOgfyWbAm" +
       "l2ZWeT9+LmTulGq/u0kCN2CYllgmYuMS5Zu6z1s3VNlb755DYV0X5JMf+aeP" +
       "fv3Xnvg2WFMKOrVM7Q2W8siITJSm2B98/uMPverqdz6SIRwIbe79r1x8eyqV" +
       "uZXGadFKC3Jf1YupqsMsbeiKQUhnoKQqmba3dOWeb9oAu5d7+SP89H3fnn/y" +
       "u5/f5IbbfrtFrH746q/8aPfZqztHMvInrkuKj/JssvJs0nfvWdiHHrvVKBkH" +
       "8c8vPP3Hv/f0hzazuu94ftkE26fP//X/fH33ue987QaJzB2W+1MsbHjXcyQW" +
       "tPH9TxeZanw8ThJei+AeGmJIaNJkq9Vkm7oU9Y3mbEy188Vyq1ZiFkXGbLni" +
       "zAd5qwKbSwWxlAqWY/MFyesUdGvgGn23xpvL6orocEy944qhwIsrgp9TBuF5" +
       "4tCVuAXBRS5c6iuLcWeSb8A+gkZrtayUVadvcYUiU1Bs2F5PluulU16WpWLe" +
       "4QYiFVlGS4fXtSkjYHyLGSGN0dShxp4gIC1WMvPuuA+rUdKoaGit6XBMy+qM" +
       "eeA2xlQaC/qCr7JzvtoMRjOe4lWWXknGLLb7PJ2TXQ4dhLbTdxF7Jo5rHIXx" +
       "bGlNNfR6g5t5FLeSzAXVaKmzhs6wkc3Ec1fHhvyovVzH03ZcGErmCiuyQaVI" +
       "kGAH27En3JynVoWkiQ7ZwYySx0M6SdROgxeYgEEHyHQscapgWKpmNqMwSGKZ" +
       "nJbN9qhKIBG8nNk2N+zSdFNc2PMSkfOEeWU9REZzO8mba3YdBYE/QObOamC0" +
       "OnN03qOHk0pArfv1vknrTEcNhzHvSAVgMwPljJFbSUpOZ96r4U4rXggtqj8v" +
       "TRXG6Jlrum4Ys6hkVgq6xFdVHll22wavoQOsqOSI6QpVGh5pi0x9KRK1IqnP" +
       "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" +
       "IgAA");
}
