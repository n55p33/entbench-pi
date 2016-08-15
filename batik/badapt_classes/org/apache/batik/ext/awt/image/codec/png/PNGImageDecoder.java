package org.apache.batik.ext.awt.image.codec.png;
public class PNGImageDecoder extends org.apache.batik.ext.awt.image.codec.util.ImageDecoderImpl {
    public PNGImageDecoder(java.io.InputStream input, org.apache.batik.ext.awt.image.codec.png.PNGDecodeParam param) {
        super(
          input,
          param);
    }
    public java.awt.image.RenderedImage decodeAsRenderedImage(int page)
          throws java.io.IOException { if (page != 0) { throw new java.io.IOException(
                                                          org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                                                            getString(
                                                              "PNGImageDecoder19"));
                                       }
                                       return new org.apache.batik.ext.awt.image.codec.png.PNGImage(
                                         input,
                                         (org.apache.batik.ext.awt.image.codec.png.PNGDecodeParam)
                                           param);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "VvOowUkq5adZPsi1v81v2eU7/wVbpFbpihYAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Ivv91/zuG3/z2W8VVcr/Ba/bwLaSIQAA");
}
class PNGChunk {
    int length;
    int type;
    byte[] data;
    int crc;
    final java.lang.String typeString;
    PNGChunk(int length, int type, byte[] data,
             int crc) { super();
                        this.length = length;
                        this.type = type;
                        this.data = data;
                        this.crc = crc;
                        typeString = "" +
                                     (char)
                                       (type >>>
                                          24 &
                                          255) +
                                     (char)
                                       (type >>>
                                          16 &
                                          255) +
                                     (char)
                                       (type >>>
                                          8 &
                                          255) +
                                     (char)
                                       (type &
                                          255);
    }
    public int getLength() { return length;
    }
    public int getType() { return type; }
    public java.lang.String getTypeString() {
        return typeString;
    }
    public byte[] getData() { return data;
    }
    public byte getByte(int offset) { return data[offset];
    }
    public int getInt1(int offset) { return data[offset] &
                                       255;
    }
    public int getInt2(int offset) { return (data[offset] &
                                               255) <<
                                       8 |
                                       data[offset +
                                              1] &
                                       255;
    }
    public int getInt4(int offset) { return (data[offset] &
                                               255) <<
                                       24 |
                                       (data[offset +
                                               1] &
                                          255) <<
                                       16 |
                                       (data[offset +
                                               2] &
                                          255) <<
                                       8 |
                                       data[offset +
                                              3] &
                                       255;
    }
    public java.lang.String getString4(int offset) {
        return "" +
        (char)
          data[offset] +
        (char)
          data[offset +
                 1] +
        (char)
          data[offset +
                 2] +
        (char)
          data[offset +
                 3];
    }
    public boolean isType(java.lang.String typeName) {
        return typeString.
          equals(
            typeName);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "j6z4qsFjTlv+uIaOyy8u2vAp8V9REmwv3ycAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL17e8zk1nXf7Oq1WkvalWRLsmrrYa3Sykw+zpszWNsJH8Ph" +
       "cDhDznA4D6aOzDc5w9eQHL5SNZaB1k5juEYrpy6Q6C+nj0Cxg7RBWrRJVQRp" +
       "kjpI4SBI+kDiNC2QpK4bG0XSIm7rXnK+9+5+kiI5H8A75L3nXp7fOef+7iF5" +
       "v9e+XrknDCqQ79mZYXvRgZZGB2u7dRBlvhYe0EyLk4JQU3FbCsMZqHtR+cBP" +
       "X/vTb33WvH65cq9YeVRyXS+SIstzw6kWenasqUzl2kltz9acMKpcZ9ZSLMG7" +
       "yLJhxgqjm0zlXae6RpUbzJEKMFABBirApQoweiIFOj2ouTsHL3pIbhRuK3+9" +
       "comp3OsrhXpR5dmzg/hSIDmHw3AlAjDCleJ6DkCVndOg8swx9j3mWwB/DoJf" +
       "+Xs/cP1n7qpcEyvXLJcv1FGAEhG4iVh5wNEcWQtCVFU1Vaw87GqaymuBJdlW" +
       "XuotVh4JLcOVol2gHRupqNz5WlDe88RyDygFtmCnRF5wDE+3NFs9urpHtyUD" +
       "YH3sBOseIVnUA4BXLaBYoEuKdtTl7o3lqlHl6fM9jjHeGAIB0PU+R4tM7/hW" +
       "d7sSqKg8svedLbkGzEeB5RpA9B5vB+4SVZ6846CFrX1J2UiG9mJUeeK8HLdv" +
       "AlL3l4YoukSV95wXK0cCXnrynJdO+efr4w995gddyr1c6qxqil3ofwV0eupc" +
       "p6mma4HmKtq+4wMfZH5UeuznP3W5UgHC7zknvJf5ub/2ze/77qde/5W9zF+6" +
       "jQwrrzUlelH5gvzQV96Hv9C9q1Djiu+FVuH8M8jL8OcOW26mPph5jx2PWDQe" +
       "HDW+Pv03q4//pPa1y5Wrg8q9imfvHBBHDyue41u2FvQ1VwukSFMHlfs1V8XL" +
       "9kHlPnDOWK62r2V1PdSiQeVuu6y61yuvgYl0MERhovvAueXq3tG5L0VmeZ76" +
       "lcO/e8BBHZ6Xv1FlA5ueo8GSIrmW68Fc4BX4Q1hzIxnY1oRlEPUbOPR2AQhB" +
       "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" +
       "t++M71Ip9mfH+Orn8H3rncCXH+LLvzP4");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("Lr3rAnwPFsW9x/iaZ/Fduu/tUkvx5e3lQ3wvf4fwPX4BvvcWxSNR5SrAtyfP" +
       "EuIJe1569G1AfLSoLNjzhw8h/vA7DvHTJYznLoD4fFE8FVXutcLj7YnnPord" +
       "J3uerUnuCeqn3wrqNKpcOdp7Wuyoe+KWDfD7TdvKF1+9duXxV4Xf3m/ROtpY" +
       "fT9TuaLvbPv0fplT5/f6gaZbpR3u329P8EtccFT5K292a2xUucvff5K9dLDv" +
       "XY8qN95M72LvRvF7ui+w2FMX9wW9yt/TvTpR5Yk79QL6gfK09M2o8u7bSQNJ" +
       "UJ6W/EhUuX5eEty//D0th4IoP5ED8bA/OS1CgNGBSHHa2+9TOfsBe78dKr10" +
       "Nik+ZrtH3ihoTuXRz53ZuFL+Y8XR/p/d/l8rXlS+9Co9/sFvtn9iv+tVsaU8" +
       "L0a5wlTu22/ALQct9hA9e8fRjsa6l3rhWw/99P3PH2XmD+0VPpl/p3R7+vZ7" +
       "TXuOH5W7Q/N/9vg//dA/fPV3y0/X/x9LgEUo8TIAAA==");
}
class PNGImage extends org.apache.batik.ext.awt.image.codec.util.SimpleRenderedImage {
    public static final int PNG_COLOR_GRAY =
      0;
    public static final int PNG_COLOR_RGB =
      2;
    public static final int PNG_COLOR_PALETTE =
      3;
    public static final int PNG_COLOR_GRAY_ALPHA =
      4;
    public static final int PNG_COLOR_RGB_ALPHA =
      6;
    private static final java.lang.String[]
      colorTypeNames =
      { "Grayscale",
    "Error",
    "Truecolor",
    "Index",
    "Grayscale with alpha",
    "Error",
    "Truecolor with alpha" };
    public static final int PNG_FILTER_NONE =
      0;
    public static final int PNG_FILTER_SUB =
      1;
    public static final int PNG_FILTER_UP =
      2;
    public static final int PNG_FILTER_AVERAGE =
      3;
    public static final int PNG_FILTER_PAETH =
      4;
    private int[][] bandOffsets = { null,
    { 0 },
    { 0,
    1 },
    { 0,
    1,
    2 },
    { 0,
    1,
    2,
    3 } };
    private int bitDepth;
    private int colorType;
    private int compressionMethod;
    private int filterMethod;
    private int interlaceMethod;
    private int paletteEntries;
    private byte[] redPalette;
    private byte[] greenPalette;
    private byte[] bluePalette;
    private byte[] alphaPalette;
    private int bkgdRed;
    private int bkgdGreen;
    private int bkgdBlue;
    private int grayTransparentAlpha;
    private int redTransparentAlpha;
    private int greenTransparentAlpha;
    private int blueTransparentAlpha;
    private int maxOpacity;
    private int[] significantBits = null;
    private boolean suppressAlpha = false;
    private boolean expandPalette = false;
    private boolean output8BitGray = false;
    private boolean outputHasAlphaPalette =
      false;
    private boolean performGammaCorrection =
      false;
    private boolean expandGrayAlpha = false;
    private boolean generateEncodeParam =
      false;
    private org.apache.batik.ext.awt.image.codec.png.PNGDecodeParam
      decodeParam =
      null;
    private org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam
      encodeParam =
      null;
    private boolean emitProperties = true;
    private float fileGamma = 45455 / 100000.0F;
    private float userExponent = 1.0F;
    private float displayExponent = 2.2F;
    private float[] chromaticity = null;
    private int sRGBRenderingIntent = -1;
    private int postProcess = POST_NONE;
    private static final int POST_NONE = 0;
    private static final int POST_GAMMA =
      1;
    private static final int POST_GRAY_LUT =
      2;
    private static final int POST_GRAY_LUT_ADD_TRANS =
      3;
    private static final int POST_PALETTE_TO_RGB =
      4;
    private static final int POST_PALETTE_TO_RGBA =
      5;
    private static final int POST_ADD_GRAY_TRANS =
      6;
    private static final int POST_ADD_RGB_TRANS =
      7;
    private static final int POST_REMOVE_GRAY_TRANS =
      8;
    private static final int POST_REMOVE_RGB_TRANS =
      9;
    private static final int POST_EXP_MASK =
      16;
    private static final int POST_GRAY_ALPHA_EXP =
      POST_NONE |
      POST_EXP_MASK;
    private static final int POST_GAMMA_EXP =
      POST_GAMMA |
      POST_EXP_MASK;
    private static final int POST_GRAY_LUT_ADD_TRANS_EXP =
      POST_GRAY_LUT_ADD_TRANS |
      POST_EXP_MASK;
    private static final int POST_ADD_GRAY_TRANS_EXP =
      POST_ADD_GRAY_TRANS |
      POST_EXP_MASK;
    private java.util.List<java.io.InputStream>
      streamVec =
      new java.util.ArrayList<java.io.InputStream>(
      );
    private java.io.DataInputStream dataStream;
    private int bytesPerPixel;
    private int inputBands;
    private int outputBands;
    private int chunkIndex = 0;
    private java.util.List textKeys = new java.util.ArrayList(
      );
    private java.util.List textStrings = new java.util.ArrayList(
      );
    private java.util.List ztextKeys = new java.util.ArrayList(
      );
    private java.util.List ztextStrings =
      new java.util.ArrayList(
      );
    private java.awt.image.WritableRaster
      theTile;
    private int[] gammaLut = null;
    private void initGammaLut(int bits) {
        double exp =
          (double)
            userExponent /
          (fileGamma *
             displayExponent);
        int numSamples =
          1 <<
          bits;
        int maxOutSample =
          bits ==
          16
          ? 65535
          : 255;
        gammaLut =
          (new int[numSamples]);
        for (int i =
               0;
             i <
               numSamples;
             i++) {
            double gbright =
              (double)
                i /
              (numSamples -
                 1);
            double gamma =
              java.lang.Math.
              pow(
                gbright,
                exp);
            int igamma =
              (int)
                (gamma *
                   maxOutSample +
                   0.5);
            if (igamma >
                  maxOutSample) {
                igamma =
                  maxOutSample;
            }
            gammaLut[i] =
              igamma;
        }
    }
    private final byte[][] expandBits = { null,
    { (byte)
        0,
    (byte)
      255 },
    { (byte)
        0,
    (byte)
      85,
    (byte)
      170,
    (byte)
      255 },
    null,
    { (byte)
        0,
    (byte)
      17,
    (byte)
      34,
    (byte)
      51,
    (byte)
      68,
    (byte)
      85,
    (byte)
      102,
    (byte)
      119,
    (byte)
      136,
    (byte)
      153,
    (byte)
      170,
    (byte)
      187,
    (byte)
      204,
    (byte)
      221,
    (byte)
      238,
    (byte)
      255 } };
    private int[] grayLut = null;
    private void initGrayLut(int bits) { int len =
                                           1 <<
                                           bits;
                                         grayLut =
                                           (new int[len]);
                                         if (performGammaCorrection) {
                                             java.lang.System.
                                               arraycopy(
                                                 gammaLut,
                                                 0,
                                                 grayLut,
                                                 0,
                                                 len);
                                         }
                                         else {
                                             for (int i =
                                                    0;
                                                  i <
                                                    len;
                                                  i++) {
                                                 grayLut[i] =
                                                   expandBits[bits][i];
                                             }
                                         }
    }
    public PNGImage(java.io.InputStream stream,
                    org.apache.batik.ext.awt.image.codec.png.PNGDecodeParam decodeParam)
          throws java.io.IOException { super(
                                         );
                                       if (!stream.
                                             markSupported(
                                               )) {
                                           stream =
                                             new java.io.BufferedInputStream(
                                               stream);
                                       }
                                       java.io.DataInputStream distream =
                                         new java.io.DataInputStream(
                                         stream);
                                       if (decodeParam ==
                                             null) {
                                           decodeParam =
                                             new org.apache.batik.ext.awt.image.codec.png.PNGDecodeParam(
                                               );
                                       }
                                       this.
                                         decodeParam =
                                         decodeParam;
                                       this.
                                         suppressAlpha =
                                         decodeParam.
                                           getSuppressAlpha(
                                             );
                                       this.
                                         expandPalette =
                                         decodeParam.
                                           getExpandPalette(
                                             );
                                       this.
                                         output8BitGray =
                                         decodeParam.
                                           getOutput8BitGray(
                                             );
                                       this.
                                         expandGrayAlpha =
                                         decodeParam.
                                           getExpandGrayAlpha(
                                             );
                                       if (decodeParam.
                                             getPerformGammaCorrection(
                                               )) {
                                           this.
                                             userExponent =
                                             decodeParam.
                                               getUserExponent(
                                                 );
                                           this.
                                             displayExponent =
                                             decodeParam.
                                               getDisplayExponent(
                                                 );
                                           performGammaCorrection =
                                             true;
                                           output8BitGray =
                                             true;
                                       }
                                       this.
                                         generateEncodeParam =
                                         decodeParam.
                                           getGenerateEncodeParam(
                                             );
                                       if (emitProperties) {
                                           properties.
                                             put(
                                               "file_type",
                                               "PNG v. 1.0");
                                       }
                                       try {
                                           long magic =
                                             distream.
                                             readLong(
                                               );
                                           if (magic !=
                                                 -8552249625308161526L) {
                                               java.lang.String msg =
                                                 org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                                                 getString(
                                                   "PNGImageDecoder0");
                                               throw new java.lang.RuntimeException(
                                                 msg);
                                           }
                                       }
                                       catch (java.lang.Exception e) {
                                           e.
                                             printStackTrace(
                                               );
                                           java.lang.String msg =
                                             org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                                             getString(
                                               "PNGImageDecoder1");
                                           throw new java.lang.RuntimeException(
                                             msg);
                                       }
                                       do  {
                                           try {
                                               org.apache.batik.ext.awt.image.codec.png.PNGChunk chunk;
                                               java.lang.String chunkType =
                                                 getChunkType(
                                                   distream);
                                               if (chunkType.
                                                     equals(
                                                       "IHDR")) {
                                                   chunk =
                                                     readChunk(
                                                       distream);
                                                   parse_IHDR_chunk(
                                                     chunk);
                                               }
                                               else
                                                   if (chunkType.
                                                         equals(
                                                           "PLTE")) {
                                                       chunk =
                                                         readChunk(
                                                           distream);
                                                       parse_PLTE_chunk(
                                                         chunk);
                                                   }
                                                   else
                                                       if (chunkType.
                                                             equals(
                                                               "IDAT")) {
                                                           chunk =
                                                             readChunk(
                                                               distream);
                                                           streamVec.
                                                             add(
                                                               new java.io.ByteArrayInputStream(
                                                                 chunk.
                                                                   getData(
                                                                     )));
                                                       }
                                                       else
                                                           if (chunkType.
                                                                 equals(
                                                                   "IEND")) {
                                                               chunk =
                                                                 readChunk(
                                                                   distream);
                                                               parse_IEND_chunk(
                                                                 chunk);
                                                               break;
                                                           }
                                                           else
                                                               if (chunkType.
                                                                     equals(
                                                                       "bKGD")) {
                                                                   chunk =
                                                                     readChunk(
                                                                       distream);
                                                                   parse_bKGD_chunk(
                                                                     chunk);
                                                               }
                                                               else
                                                                   if (chunkType.
                                                                         equals(
                                                                           "cHRM")) {
                                                                       chunk =
                                                                         readChunk(
                                                                           distream);
                                                                       parse_cHRM_chunk(
                                                                         chunk);
                                                                   }
                                                                   else
                                                                       if (chunkType.
                                                                             equals(
                                                                               "gAMA")) {
                                                                           chunk =
                                                                             readChunk(
                                                                               distream);
                                                                           parse_gAMA_chunk(
                                                                             chunk);
                                                                       }
                                                                       else
                                                                           if (chunkType.
                                                                                 equals(
                                                                                   "hIST")) {
                                                                               chunk =
                                                                                 readChunk(
                                                                                   distream);
                                                                               parse_hIST_chunk(
                                                                                 chunk);
                                                                           }
                                                                           else
                                                                               if (chunkType.
                                                                                     equals(
                                                                                       "iCCP")) {
                                                                                   chunk =
                                                                                     readChunk(
                                                                                       distream);
                                                                                   parse_iCCP_chunk(
                                                                                     chunk);
                                                                               }
                                                                               else
                                                                                   if (chunkType.
                                                                                         equals(
                                                                                           "pHYs")) {
                                                                                       chunk =
                                                                                         readChunk(
                                                                                           distream);
                                                                                       parse_pHYs_chunk(
                                                                                         chunk);
                                                                                   }
                                                                                   else
                                                                                       if (chunkType.
                                                                                             equals(
                                                                                               "sBIT")) {
                                                                                           chunk =
                                                                                             readChunk(
                                                                                               distream);
                                                                                           parse_sBIT_chunk(
                                                                                             chunk);
                                                                                       }
                                                                                       else
                                                                                           if (chunkType.
                                                                                                 equals(
                                                                                                   "sRGB")) {
                                                                                               chunk =
                                                                                                 readChunk(
                                                                                                   distream);
                                                                                               parse_sRGB_chunk(
                                                                                                 chunk);
                                                                                           }
                                                                                           else
                                                                                               if (chunkType.
                                                                                                     equals(
                                                                                                       "tEXt")) {
                                                                                                   chunk =
                                                                                                     readChunk(
                                                                                                       distream);
                                                                                                   parse_tEXt_chunk(
                                                                                                     chunk);
                                                                                               }
                                                                                               else
                                                                                                   if (chunkType.
                                                                                                         equals(
                                                                                                           "tIME")) {
                                                                                                       chunk =
                                                                                                         readChunk(
                                                                                                           distream);
                                                                                                       parse_tIME_chunk(
                                                                                                         chunk);
                                                                                                   }
                                                                                                   else
                                                                                                       if (chunkType.
                                                                                                             equals(
                                                                                                               "tRNS")) {
                                                                                                           chunk =
                                                                                                             readChunk(
                                                                                                               distream);
                                                                                                           parse_tRNS_chunk(
                                                                                                             chunk);
                                                                                                       }
                                                                                                       else
                                                                                                           if (chunkType.
                                                                                                                 equals(
                                                                                                                   "zTXt")) {
                                                                                                               chunk =
                                                                                                                 readChunk(
                                                                                                                   distream);
                                                                                                               parse_zTXt_chunk(
                                                                                                                 chunk);
                                                                                                           }
                                                                                                           else {
                                                                                                               chunk =
                                                                                                                 readChunk(
                                                                                                                   distream);
                                                                                                               java.lang.String type =
                                                                                                                 chunk.
                                                                                                                 getTypeString(
                                                                                                                   );
                                                                                                               byte[] data =
                                                                                                                 chunk.
                                                                                                                 getData(
                                                                                                                   );
                                                                                                               if (encodeParam !=
                                                                                                                     null) {
                                                                                                                   encodeParam.
                                                                                                                     addPrivateChunk(
                                                                                                                       type,
                                                                                                                       data);
                                                                                                               }
                                                                                                               if (emitProperties) {
                                                                                                                   java.lang.String key =
                                                                                                                     "chunk_" +
                                                                                                                   chunkIndex++ +
                                                                                                                   ':' +
                                                                                                                   type;
                                                                                                                   properties.
                                                                                                                     put(
                                                                                                                       key.
                                                                                                                         toLowerCase(
                                                                                                                           ),
                                                                                                                       data);
                                                                                                               }
                                                                                                           }
                                           }
                                           catch (java.lang.Exception e) {
                                               e.
                                                 printStackTrace(
                                                   );
                                               java.lang.String msg =
                                                 org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                                                 getString(
                                                   "PNGImageDecoder2");
                                               throw new java.lang.RuntimeException(
                                                 msg);
                                           }
                                       }while(true); 
                                       if (significantBits ==
                                             null) {
                                           significantBits =
                                             (new int[inputBands]);
                                           for (int i =
                                                  0;
                                                i <
                                                  inputBands;
                                                i++) {
                                               significantBits[i] =
                                                 bitDepth;
                                           }
                                           if (emitProperties) {
                                               properties.
                                                 put(
                                                   "significant_bits",
                                                   significantBits);
                                           }
                                       } }
    private static java.lang.String getChunkType(java.io.DataInputStream distream) {
        try {
            distream.
              mark(
                8);
            distream.
              readInt(
                );
            int type =
              distream.
              readInt(
                );
            distream.
              reset(
                );
            java.lang.String typeString =
              "";
            typeString +=
              (char)
                (type >>
                   24);
            typeString +=
              (char)
                (type >>
                   16 &
                   255);
            typeString +=
              (char)
                (type >>
                   8 &
                   255);
            typeString +=
              (char)
                (type &
                   255);
            return typeString;
        }
        catch (java.lang.Exception e) {
            e.
              printStackTrace(
                );
            return null;
        }
    }
    private static org.apache.batik.ext.awt.image.codec.png.PNGChunk readChunk(java.io.DataInputStream distream) {
        try {
            int length =
              distream.
              readInt(
                );
            int type =
              distream.
              readInt(
                );
            byte[] data =
              new byte[length];
            distream.
              readFully(
                data);
            int crc =
              distream.
              readInt(
                );
            return new org.apache.batik.ext.awt.image.codec.png.PNGChunk(
              length,
              type,
              data,
              crc);
        }
        catch (java.lang.Exception e) {
            e.
              printStackTrace(
                );
            return null;
        }
    }
    private void parse_IHDR_chunk(org.apache.batik.ext.awt.image.codec.png.PNGChunk chunk) {
        tileWidth =
          (width =
             chunk.
               getInt4(
                 0));
        tileHeight =
          (height =
             chunk.
               getInt4(
                 4));
        bitDepth =
          chunk.
            getInt1(
              8);
        if (bitDepth !=
              1 &&
              bitDepth !=
              2 &&
              bitDepth !=
              4 &&
              bitDepth !=
              8 &&
              bitDepth !=
              16) {
            java.lang.String msg =
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
              getString(
                "PNGImageDecoder3");
            throw new java.lang.RuntimeException(
              msg);
        }
        maxOpacity =
          (1 <<
             bitDepth) -
            1;
        colorType =
          chunk.
            getInt1(
              9);
        if (colorType !=
              PNG_COLOR_GRAY &&
              colorType !=
              PNG_COLOR_RGB &&
              colorType !=
              PNG_COLOR_PALETTE &&
              colorType !=
              PNG_COLOR_GRAY_ALPHA &&
              colorType !=
              PNG_COLOR_RGB_ALPHA) {
            java.lang.System.
              out.
              println(
                org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                  getString(
                    "PNGImageDecoder4"));
        }
        if (colorType ==
              PNG_COLOR_RGB &&
              bitDepth <
              8) {
            java.lang.String msg =
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
              getString(
                "PNGImageDecoder5");
            throw new java.lang.RuntimeException(
              msg);
        }
        if (colorType ==
              PNG_COLOR_PALETTE &&
              bitDepth ==
              16) {
            java.lang.String msg =
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
              getString(
                "PNGImageDecoder6");
            throw new java.lang.RuntimeException(
              msg);
        }
        if (colorType ==
              PNG_COLOR_GRAY_ALPHA &&
              bitDepth <
              8) {
            java.lang.String msg =
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
              getString(
                "PNGImageDecoder7");
            throw new java.lang.RuntimeException(
              msg);
        }
        if (colorType ==
              PNG_COLOR_RGB_ALPHA &&
              bitDepth <
              8) {
            java.lang.String msg =
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
              getString(
                "PNGImageDecoder8");
            throw new java.lang.RuntimeException(
              msg);
        }
        if (emitProperties) {
            properties.
              put(
                "color_type",
                colorTypeNames[colorType]);
        }
        if (generateEncodeParam) {
            if (colorType ==
                  PNG_COLOR_PALETTE) {
                encodeParam =
                  new org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.Palette(
                    );
            }
            else
                if (colorType ==
                      PNG_COLOR_GRAY ||
                      colorType ==
                      PNG_COLOR_GRAY_ALPHA) {
                    encodeParam =
                      new org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.Gray(
                        );
                }
                else {
                    encodeParam =
                      new org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.RGB(
                        );
                }
            decodeParam.
              setEncodeParam(
                encodeParam);
        }
        if (encodeParam !=
              null) {
            encodeParam.
              setBitDepth(
                bitDepth);
        }
        if (emitProperties) {
            properties.
              put(
                "bit_depth",
                new java.lang.Integer(
                  bitDepth));
        }
        if (performGammaCorrection) {
            float gamma =
              1.0F /
              2.2F *
              (displayExponent /
                 userExponent);
            if (encodeParam !=
                  null) {
                encodeParam.
                  setGamma(
                    gamma);
            }
            if (emitProperties) {
                properties.
                  put(
                    "gamma",
                    new java.lang.Float(
                      gamma));
            }
        }
        compressionMethod =
          chunk.
            getInt1(
              10);
        if (compressionMethod !=
              0) {
            java.lang.String msg =
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
              getString(
                "PNGImageDecoder9");
            throw new java.lang.RuntimeException(
              msg);
        }
        filterMethod =
          chunk.
            getInt1(
              11);
        if (filterMethod !=
              0) {
            java.lang.String msg =
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
              getString(
                "PNGImageDecoder10");
            throw new java.lang.RuntimeException(
              msg);
        }
        interlaceMethod =
          chunk.
            getInt1(
              12);
        if (interlaceMethod ==
              0) {
            if (encodeParam !=
                  null) {
                encodeParam.
                  setInterlacing(
                    false);
            }
            if (emitProperties) {
                properties.
                  put(
                    "interlace_method",
                    "None");
            }
        }
        else
            if (interlaceMethod ==
                  1) {
                if (encodeParam !=
                      null) {
                    encodeParam.
                      setInterlacing(
                        true);
                }
                if (emitProperties) {
                    properties.
                      put(
                        "interlace_method",
                        "Adam7");
                }
            }
            else {
                java.lang.String msg =
                  org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                  getString(
                    "PNGImageDecoder11");
                throw new java.lang.RuntimeException(
                  msg);
            }
        bytesPerPixel =
          bitDepth ==
            16
            ? 2
            : 1;
        switch (colorType) {
            case PNG_COLOR_GRAY:
                inputBands =
                  1;
                outputBands =
                  1;
                if (output8BitGray &&
                      bitDepth <
                      8) {
                    postProcess =
                      POST_GRAY_LUT;
                }
                else
                    if (performGammaCorrection) {
                        postProcess =
                          POST_GAMMA;
                    }
                    else {
                        postProcess =
                          POST_NONE;
                    }
                break;
            case PNG_COLOR_RGB:
                inputBands =
                  3;
                bytesPerPixel *=
                  3;
                outputBands =
                  3;
                if (performGammaCorrection) {
                    postProcess =
                      POST_GAMMA;
                }
                else {
                    postProcess =
                      POST_NONE;
                }
                break;
            case PNG_COLOR_PALETTE:
                inputBands =
                  1;
                bytesPerPixel =
                  1;
                outputBands =
                  expandPalette
                    ? 3
                    : 1;
                if (expandPalette) {
                    postProcess =
                      POST_PALETTE_TO_RGB;
                }
                else {
                    postProcess =
                      POST_NONE;
                }
                break;
            case PNG_COLOR_GRAY_ALPHA:
                inputBands =
                  2;
                bytesPerPixel *=
                  2;
                if (suppressAlpha) {
                    outputBands =
                      1;
                    postProcess =
                      POST_REMOVE_GRAY_TRANS;
                }
                else {
                    if (performGammaCorrection) {
                        postProcess =
                          POST_GAMMA;
                    }
                    else {
                        postProcess =
                          POST_NONE;
                    }
                    if (expandGrayAlpha) {
                        postProcess |=
                          POST_EXP_MASK;
                        outputBands =
                          4;
                    }
                    else {
                        outputBands =
                          2;
                    }
                }
                break;
            case PNG_COLOR_RGB_ALPHA:
                inputBands =
                  4;
                bytesPerPixel *=
                  4;
                outputBands =
                  !suppressAlpha
                    ? 4
                    : 3;
                if (suppressAlpha) {
                    postProcess =
                      POST_REMOVE_RGB_TRANS;
                }
                else
                    if (performGammaCorrection) {
                        postProcess =
                          POST_GAMMA;
                    }
                    else {
                        postProcess =
                          POST_NONE;
                    }
                break;
        }
    }
    private void parse_IEND_chunk(org.apache.batik.ext.awt.image.codec.png.PNGChunk chunk)
          throws java.lang.Exception { int textLen =
                                         textKeys.
                                         size(
                                           );
                                       java.lang.String[] textArray =
                                         new java.lang.String[2 *
                                                                textLen];
                                       for (int i =
                                              0;
                                            i <
                                              textLen;
                                            i++) {
                                           java.lang.String key =
                                             (java.lang.String)
                                               textKeys.
                                               get(
                                                 i);
                                           java.lang.String val =
                                             (java.lang.String)
                                               textStrings.
                                               get(
                                                 i);
                                           textArray[2 *
                                                       i] =
                                             key;
                                           textArray[2 *
                                                       i +
                                                       1] =
                                             val;
                                           if (emitProperties) {
                                               java.lang.String uniqueKey =
                                                 "text_" +
                                               i +
                                               ':' +
                                               key;
                                               properties.
                                                 put(
                                                   uniqueKey.
                                                     toLowerCase(
                                                       ),
                                                   val);
                                           }
                                       }
                                       if (encodeParam !=
                                             null) {
                                           encodeParam.
                                             setText(
                                               textArray);
                                       }
                                       int ztextLen =
                                         ztextKeys.
                                         size(
                                           );
                                       java.lang.String[] ztextArray =
                                         new java.lang.String[2 *
                                                                ztextLen];
                                       for (int i =
                                              0;
                                            i <
                                              ztextLen;
                                            i++) {
                                           java.lang.String key =
                                             (java.lang.String)
                                               ztextKeys.
                                               get(
                                                 i);
                                           java.lang.String val =
                                             (java.lang.String)
                                               ztextStrings.
                                               get(
                                                 i);
                                           ztextArray[2 *
                                                        i] =
                                             key;
                                           ztextArray[2 *
                                                        i +
                                                        1] =
                                             val;
                                           if (emitProperties) {
                                               java.lang.String uniqueKey =
                                                 "ztext_" +
                                               i +
                                               ':' +
                                               key;
                                               properties.
                                                 put(
                                                   uniqueKey.
                                                     toLowerCase(
                                                       ),
                                                   val);
                                           }
                                       }
                                       if (encodeParam !=
                                             null) {
                                           encodeParam.
                                             setCompressedText(
                                               ztextArray);
                                       }
                                       java.io.InputStream seqStream =
                                         new java.io.SequenceInputStream(
                                         java.util.Collections.
                                           enumeration(
                                             streamVec));
                                       java.io.InputStream infStream =
                                         new java.util.zip.InflaterInputStream(
                                         seqStream,
                                         new java.util.zip.Inflater(
                                           ));
                                       dataStream =
                                         new java.io.DataInputStream(
                                           infStream);
                                       int depth =
                                         bitDepth;
                                       if (colorType ==
                                             PNG_COLOR_GRAY &&
                                             bitDepth <
                                             8 &&
                                             output8BitGray) {
                                           depth =
                                             8;
                                       }
                                       if (colorType ==
                                             PNG_COLOR_PALETTE &&
                                             expandPalette) {
                                           depth =
                                             8;
                                       }
                                       int bytesPerRow =
                                         (outputBands *
                                            width *
                                            depth +
                                            7) /
                                         8;
                                       int scanlineStride =
                                         depth ==
                                         16
                                         ? bytesPerRow /
                                         2
                                         : bytesPerRow;
                                       theTile =
                                         createRaster(
                                           width,
                                           height,
                                           outputBands,
                                           scanlineStride,
                                           depth);
                                       if (performGammaCorrection &&
                                             gammaLut ==
                                             null) {
                                           initGammaLut(
                                             bitDepth);
                                       }
                                       if (postProcess ==
                                             POST_GRAY_LUT ||
                                             postProcess ==
                                             POST_GRAY_LUT_ADD_TRANS ||
                                             postProcess ==
                                             POST_GRAY_LUT_ADD_TRANS_EXP) {
                                           initGrayLut(
                                             bitDepth);
                                       }
                                       decodeImage(
                                         interlaceMethod ==
                                           1);
                                       sampleModel =
                                         theTile.
                                           getSampleModel(
                                             );
                                       if (colorType ==
                                             PNG_COLOR_PALETTE &&
                                             !expandPalette) {
                                           if (outputHasAlphaPalette) {
                                               colorModel =
                                                 new java.awt.image.IndexColorModel(
                                                   bitDepth,
                                                   paletteEntries,
                                                   redPalette,
                                                   greenPalette,
                                                   bluePalette,
                                                   alphaPalette);
                                           }
                                           else {
                                               colorModel =
                                                 new java.awt.image.IndexColorModel(
                                                   bitDepth,
                                                   paletteEntries,
                                                   redPalette,
                                                   greenPalette,
                                                   bluePalette);
                                           }
                                       }
                                       else
                                           if (colorType ==
                                                 PNG_COLOR_GRAY &&
                                                 bitDepth <
                                                 8 &&
                                                 !output8BitGray) {
                                               byte[] palette =
                                                 expandBits[bitDepth];
                                               colorModel =
                                                 new java.awt.image.IndexColorModel(
                                                   bitDepth,
                                                   palette.
                                                     length,
                                                   palette,
                                                   palette,
                                                   palette);
                                           }
                                           else {
                                               colorModel =
                                                 createComponentColorModel(
                                                   sampleModel);
                                           }
    }
    private static final int[] GrayBits8 =
      { 8 };
    private static final java.awt.image.ComponentColorModel
      colorModelGray8 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_GRAY),
      GrayBits8,
      false,
      false,
      java.awt.Transparency.
        OPAQUE,
      java.awt.image.DataBuffer.
        TYPE_BYTE);
    private static final int[] GrayAlphaBits8 =
      { 8,
    8 };
    private static final java.awt.image.ComponentColorModel
      colorModelGrayAlpha8 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_GRAY),
      GrayAlphaBits8,
      true,
      false,
      java.awt.Transparency.
        TRANSLUCENT,
      java.awt.image.DataBuffer.
        TYPE_BYTE);
    private static final int[] GrayBits16 =
      { 16 };
    private static final java.awt.image.ComponentColorModel
      colorModelGray16 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_GRAY),
      GrayBits16,
      false,
      false,
      java.awt.Transparency.
        OPAQUE,
      java.awt.image.DataBuffer.
        TYPE_USHORT);
    private static final int[] GrayAlphaBits16 =
      { 16,
    16 };
    private static final java.awt.image.ComponentColorModel
      colorModelGrayAlpha16 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_GRAY),
      GrayAlphaBits16,
      true,
      false,
      java.awt.Transparency.
        TRANSLUCENT,
      java.awt.image.DataBuffer.
        TYPE_USHORT);
    private static final int[] GrayBits32 =
      { 32 };
    private static final java.awt.image.ComponentColorModel
      colorModelGray32 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_GRAY),
      GrayBits32,
      false,
      false,
      java.awt.Transparency.
        OPAQUE,
      java.awt.image.DataBuffer.
        TYPE_INT);
    private static final int[] GrayAlphaBits32 =
      { 32,
    32 };
    private static final java.awt.image.ComponentColorModel
      colorModelGrayAlpha32 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_GRAY),
      GrayAlphaBits32,
      true,
      false,
      java.awt.Transparency.
        TRANSLUCENT,
      java.awt.image.DataBuffer.
        TYPE_INT);
    private static final int[] RGBBits8 =
      { 8,
    8,
    8 };
    private static final java.awt.image.ComponentColorModel
      colorModelRGB8 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_sRGB),
      RGBBits8,
      false,
      false,
      java.awt.Transparency.
        OPAQUE,
      java.awt.image.DataBuffer.
        TYPE_BYTE);
    private static final int[] RGBABits8 =
      { 8,
    8,
    8,
    8 };
    private static final java.awt.image.ComponentColorModel
      colorModelRGBA8 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_sRGB),
      RGBABits8,
      true,
      false,
      java.awt.Transparency.
        TRANSLUCENT,
      java.awt.image.DataBuffer.
        TYPE_BYTE);
    private static final int[] RGBBits16 =
      { 16,
    16,
    16 };
    private static final java.awt.image.ComponentColorModel
      colorModelRGB16 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_sRGB),
      RGBBits16,
      false,
      false,
      java.awt.Transparency.
        OPAQUE,
      java.awt.image.DataBuffer.
        TYPE_USHORT);
    private static final int[] RGBABits16 =
      { 16,
    16,
    16,
    16 };
    private static final java.awt.image.ComponentColorModel
      colorModelRGBA16 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_sRGB),
      RGBABits16,
      true,
      false,
      java.awt.Transparency.
        TRANSLUCENT,
      java.awt.image.DataBuffer.
        TYPE_USHORT);
    private static final int[] RGBBits32 =
      { 32,
    32,
    32 };
    private static final java.awt.image.ComponentColorModel
      colorModelRGB32 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_sRGB),
      RGBBits32,
      false,
      false,
      java.awt.Transparency.
        OPAQUE,
      java.awt.image.DataBuffer.
        TYPE_INT);
    private static final int[] RGBABits32 =
      { 32,
    32,
    32,
    32 };
    private static final java.awt.image.ComponentColorModel
      colorModelRGBA32 =
      new java.awt.image.ComponentColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_sRGB),
      RGBABits32,
      true,
      false,
      java.awt.Transparency.
        TRANSLUCENT,
      java.awt.image.DataBuffer.
        TYPE_INT);
    public static java.awt.image.ColorModel createComponentColorModel(java.awt.image.SampleModel sm) {
        int type =
          sm.
          getDataType(
            );
        int bands =
          sm.
          getNumBands(
            );
        java.awt.image.ComponentColorModel cm =
          null;
        if (type ==
              java.awt.image.DataBuffer.
                TYPE_BYTE) {
            switch (bands) {
                case 1:
                    cm =
                      colorModelGray8;
                    break;
                case 2:
                    cm =
                      colorModelGrayAlpha8;
                    break;
                case 3:
                    cm =
                      colorModelRGB8;
                    break;
                case 4:
                    cm =
                      colorModelRGBA8;
                    break;
            }
        }
        else
            if (type ==
                  java.awt.image.DataBuffer.
                    TYPE_USHORT) {
                switch (bands) {
                    case 1:
                        cm =
                          colorModelGray16;
                        break;
                    case 2:
                        cm =
                          colorModelGrayAlpha16;
                        break;
                    case 3:
                        cm =
                          colorModelRGB16;
                        break;
                    case 4:
                        cm =
                          colorModelRGBA16;
                        break;
                }
            }
            else
                if (type ==
                      java.awt.image.DataBuffer.
                        TYPE_INT) {
                    switch (bands) {
                        case 1:
                            cm =
                              colorModelGray32;
                            break;
                        case 2:
                            cm =
                              colorModelGrayAlpha32;
                            break;
                        case 3:
                            cm =
                              colorModelRGB32;
                            break;
                        case 4:
                            cm =
                              colorModelRGBA32;
                            break;
                    }
                }
        return cm;
    }
    private void parse_PLTE_chunk(org.apache.batik.ext.awt.image.codec.png.PNGChunk chunk) {
        paletteEntries =
          chunk.
            getLength(
              ) /
            3;
        redPalette =
          (new byte[paletteEntries]);
        greenPalette =
          (new byte[paletteEntries]);
        bluePalette =
          (new byte[paletteEntries]);
        int pltIndex =
          0;
        if (performGammaCorrection) {
            if (gammaLut ==
                  null) {
                initGammaLut(
                  bitDepth ==
                    16
                    ? 16
                    : 8);
            }
            for (int i =
                   0;
                 i <
                   paletteEntries;
                 i++) {
                byte r =
                  chunk.
                  getByte(
                    pltIndex++);
                byte g =
                  chunk.
                  getByte(
                    pltIndex++);
                byte b =
                  chunk.
                  getByte(
                    pltIndex++);
                redPalette[i] =
                  (byte)
                    gammaLut[r &
                               255];
                greenPalette[i] =
                  (byte)
                    gammaLut[g &
                               255];
                bluePalette[i] =
                  (byte)
                    gammaLut[b &
                               255];
            }
        }
        else {
            for (int i =
                   0;
                 i <
                   paletteEntries;
                 i++) {
                redPalette[i] =
                  chunk.
                    getByte(
                      pltIndex++);
                greenPalette[i] =
                  chunk.
                    getByte(
                      pltIndex++);
                bluePalette[i] =
                  chunk.
                    getByte(
                      pltIndex++);
            }
        }
    }
    private void parse_bKGD_chunk(org.apache.batik.ext.awt.image.codec.png.PNGChunk chunk) {
        switch (colorType) {
            case PNG_COLOR_PALETTE:
                int bkgdIndex =
                  chunk.
                  getByte(
                    0) &
                  255;
                bkgdRed =
                  redPalette[bkgdIndex] &
                    255;
                bkgdGreen =
                  greenPalette[bkgdIndex] &
                    255;
                bkgdBlue =
                  bluePalette[bkgdIndex] &
                    255;
                if (encodeParam !=
                      null) {
                    ((org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.Palette)
                       encodeParam).
                      setBackgroundPaletteIndex(
                        bkgdIndex);
                }
                break;
            case PNG_COLOR_GRAY:
            case PNG_COLOR_GRAY_ALPHA:
                int bkgdGray =
                  chunk.
                  getInt2(
                    0);
                bkgdRed =
                  (bkgdGreen =
                     (bkgdBlue =
                        bkgdGray));
                if (encodeParam !=
                      null) {
                    ((org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.Gray)
                       encodeParam).
                      setBackgroundGray(
                        bkgdGray);
                }
                break;
            case PNG_COLOR_RGB:
            case PNG_COLOR_RGB_ALPHA:
                bkgdRed =
                  chunk.
                    getInt2(
                      0);
                bkgdGreen =
                  chunk.
                    getInt2(
                      2);
                bkgdBlue =
                  chunk.
                    getInt2(
                      4);
                int[] bkgdRGB =
                  new int[3];
                bkgdRGB[0] =
                  bkgdRed;
                bkgdRGB[1] =
                  bkgdGreen;
                bkgdRGB[2] =
                  bkgdBlue;
                if (encodeParam !=
                      null) {
                    ((org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.RGB)
                       encodeParam).
                      setBackgroundRGB(
                        bkgdRGB);
                }
                break;
        }
        int r =
          0;
        int g =
          0;
        int b =
          0;
        if (bitDepth <
              8) {
            r =
              expandBits[bitDepth][bkgdRed];
            g =
              expandBits[bitDepth][bkgdGreen];
            b =
              expandBits[bitDepth][bkgdBlue];
        }
        else
            if (bitDepth ==
                  8) {
                r =
                  bkgdRed;
                g =
                  bkgdGreen;
                b =
                  bkgdBlue;
            }
            else
                if (bitDepth ==
                      16) {
                    r =
                      bkgdRed >>
                        8;
                    g =
                      bkgdGreen >>
                        8;
                    b =
                      bkgdBlue >>
                        8;
                }
        if (emitProperties) {
            properties.
              put(
                "background_color",
                new java.awt.Color(
                  r,
                  g,
                  b));
        }
    }
    private void parse_cHRM_chunk(org.apache.batik.ext.awt.image.codec.png.PNGChunk chunk) {
        if (sRGBRenderingIntent !=
              -1) {
            return;
        }
        chromaticity =
          (new float[8]);
        chromaticity[0] =
          chunk.
            getInt4(
              0) /
            100000.0F;
        chromaticity[1] =
          chunk.
            getInt4(
              4) /
            100000.0F;
        chromaticity[2] =
          chunk.
            getInt4(
              8) /
            100000.0F;
        chromaticity[3] =
          chunk.
            getInt4(
              12) /
            100000.0F;
        chromaticity[4] =
          chunk.
            getInt4(
              16) /
            100000.0F;
        chromaticity[5] =
          chunk.
            getInt4(
              20) /
            100000.0F;
        chromaticity[6] =
          chunk.
            getInt4(
              24) /
            100000.0F;
        chromaticity[7] =
          chunk.
            getInt4(
              28) /
            100000.0F;
        if (encodeParam !=
              null) {
            encodeParam.
              setChromaticity(
                chromaticity);
        }
        if (emitProperties) {
            properties.
              put(
                "white_point_x",
                new java.lang.Float(
                  chromaticity[0]));
            properties.
              put(
                "white_point_y",
                new java.lang.Float(
                  chromaticity[1]));
            properties.
              put(
                "red_x",
                new java.lang.Float(
                  chromaticity[2]));
            properties.
              put(
                "red_y",
                new java.lang.Float(
                  chromaticity[3]));
            properties.
              put(
                "green_x",
                new java.lang.Float(
                  chromaticity[4]));
            properties.
              put(
                "green_y",
                new java.lang.Float(
                  chromaticity[5]));
            properties.
              put(
                "blue_x",
                new java.lang.Float(
                  chromaticity[6]));
            properties.
              put(
                "blue_y",
                new java.lang.Float(
                  chromaticity[7]));
        }
    }
    private void parse_gAMA_chunk(org.apache.batik.ext.awt.image.codec.png.PNGChunk chunk) {
        if (sRGBRenderingIntent !=
              -1) {
            return;
        }
        fileGamma =
          chunk.
            getInt4(
              0) /
            100000.0F;
        float exp =
          performGammaCorrection
          ? displayExponent /
          userExponent
          : 1.0F;
        if (encodeParam !=
              null) {
            encodeParam.
              setGamma(
                fileGamma *
                  exp);
        }
        if (emitProperties) {
            properties.
              put(
                "gamma",
                new java.lang.Float(
                  fileGamma *
                    exp));
        }
    }
    private void parse_hIST_chunk(org.apache.batik.ext.awt.image.codec.png.PNGChunk chunk) {
        if (redPalette ==
              null) {
            java.lang.String msg =
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
              getString(
                "PNGImageDecoder18");
            throw new java.lang.RuntimeException(
              msg);
        }
        int length =
          redPalette.
            length;
        int[] hist =
          new int[length];
        for (int i =
               0;
             i <
               length;
             i++) {
            hist[i] =
              chunk.
                getInt2(
                  2 *
                    i);
        }
        if (encodeParam !=
              null) {
            encodeParam.
              setPaletteHistogram(
                hist);
        }
    }
    private void parse_iCCP_chunk(org.apache.batik.ext.awt.image.codec.png.PNGChunk chunk) {
        java.lang.String name =
          "";
        byte b;
        int textIndex =
          0;
        while ((b =
                  chunk.
                    getByte(
                      textIndex++)) !=
                 0) {
            name +=
              (char)
                b;
        }
    }
    private void parse_pHYs_chunk(org.apache.batik.ext.awt.image.codec.png.PNGChunk chunk) {
        int xPixelsPerUnit =
          chunk.
          getInt4(
            0);
        int yPixelsPerUnit =
          chunk.
          getInt4(
            4);
        int unitSpecifier =
          chunk.
          getInt1(
            8);
        if (encodeParam !=
              null) {
            encodeParam.
              setPhysicalDimension(
                xPixelsPerUnit,
                yPixelsPerUnit,
                unitSpecifier);
        }
        if (emitProperties) {
            properties.
              put(
                "x_pixels_per_unit",
                new java.lang.Integer(
                  xPixelsPerUnit));
            properties.
              put(
                "y_pixels_per_unit",
                new java.lang.Integer(
                  yPixelsPerUnit));
            properties.
              put(
                "pixel_aspect_ratio",
                new java.lang.Float(
                  (float)
                    xPixelsPerUnit /
                    yPixelsPerUnit));
            if (unitSpecifier ==
                  1) {
                properties.
                  put(
                    "pixel_units",
                    "Meters");
            }
            else
                if (unitSpecifier !=
                      0) {
                    java.lang.String msg =
                      org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                      getString(
                        "PNGImageDecoder12");
                    throw new java.lang.RuntimeException(
                      msg);
                }
        }
    }
    private void parse_sBIT_chunk(org.apache.batik.ext.awt.image.codec.png.PNGChunk chunk) {
        if (colorType ==
              PNG_COLOR_PALETTE) {
            significantBits =
              (new int[3]);
        }
        else {
            significantBits =
              (new int[inputBands]);
        }
        for (int i =
               0;
             i <
               significantBits.
                 length;
             i++) {
            int bits =
              chunk.
              getByte(
                i);
            int depth =
              colorType ==
              PNG_COLOR_PALETTE
              ? 8
              : bitDepth;
            if (bits <=
                  0 ||
                  bits >
                  depth) {
                java.lang.String msg =
                  org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                  getString(
                    "PNGImageDecoder13");
                throw new java.lang.RuntimeException(
                  msg);
            }
            significantBits[i] =
              bits;
        }
        if (encodeParam !=
              null) {
            encodeParam.
              setSignificantBits(
                significantBits);
        }
        if (emitProperties) {
            properties.
              put(
                "significant_bits",
                significantBits);
        }
    }
    private void parse_sRGB_chunk(org.apache.batik.ext.awt.image.codec.png.PNGChunk chunk) {
        sRGBRenderingIntent =
          chunk.
            getByte(
              0);
        fileGamma =
          45455 /
            100000.0F;
        chromaticity =
          (new float[8]);
        chromaticity[0] =
          31270 /
            10000.0F;
        chromaticity[1] =
          32900 /
            10000.0F;
        chromaticity[2] =
          64000 /
            10000.0F;
        chromaticity[3] =
          33000 /
            10000.0F;
        chromaticity[4] =
          30000 /
            10000.0F;
        chromaticity[5] =
          60000 /
            10000.0F;
        chromaticity[6] =
          15000 /
            10000.0F;
        chromaticity[7] =
          6000 /
            10000.0F;
        if (performGammaCorrection) {
            float gamma =
              fileGamma *
              (displayExponent /
                 userExponent);
            if (encodeParam !=
                  null) {
                encodeParam.
                  setGamma(
                    gamma);
                encodeParam.
                  setChromaticity(
                    chromaticity);
            }
            if (emitProperties) {
                properties.
                  put(
                    "gamma",
                    new java.lang.Float(
                      gamma));
                properties.
                  put(
                    "white_point_x",
                    new java.lang.Float(
                      chromaticity[0]));
                properties.
                  put(
                    "white_point_y",
                    new java.lang.Float(
                      chromaticity[1]));
                properties.
                  put(
                    "red_x",
                    new java.lang.Float(
                      chromaticity[2]));
                properties.
                  put(
                    "red_y",
                    new java.lang.Float(
                      chromaticity[3]));
                properties.
                  put(
                    "green_x",
                    new java.lang.Float(
                      chromaticity[4]));
                properties.
                  put(
                    "green_y",
                    new java.lang.Float(
                      chromaticity[5]));
                properties.
                  put(
                    "blue_x",
                    new java.lang.Float(
                      chromaticity[6]));
                properties.
                  put(
                    "blue_y",
                    new java.lang.Float(
                      chromaticity[7]));
            }
        }
    }
    private void parse_tEXt_chunk(org.apache.batik.ext.awt.image.codec.png.PNGChunk chunk) {
        byte b;
        java.lang.StringBuffer key =
          new java.lang.StringBuffer(
          );
        int textIndex =
          0;
        while ((b =
                  chunk.
                    getByte(
                      textIndex++)) !=
                 0) {
            key.
              append(
                (char)
                  b);
        }
        java.lang.StringBuffer value =
          new java.lang.StringBuffer(
          );
        for (int i =
               textIndex;
             i <
               chunk.
               getLength(
                 );
             i++) {
            value.
              append(
                (char)
                  chunk.
                  getByte(
                    i));
        }
        textKeys.
          add(
            key.
              toString(
                ));
        textStrings.
          add(
            value.
              toString(
                ));
    }
    private void parse_tIME_chunk(org.apache.batik.ext.awt.image.codec.png.PNGChunk chunk) {
        int year =
          chunk.
          getInt2(
            0);
        int month =
          chunk.
          getInt1(
            2) -
          1;
        int day =
          chunk.
          getInt1(
            3);
        int hour =
          chunk.
          getInt1(
            4);
        int minute =
          chunk.
          getInt1(
            5);
        int second =
          chunk.
          getInt1(
            6);
        java.util.TimeZone gmt =
          java.util.TimeZone.
          getTimeZone(
            "GMT");
        java.util.GregorianCalendar cal =
          new java.util.GregorianCalendar(
          gmt);
        cal.
          set(
            year,
            month,
            day,
            hour,
            minute,
            second);
        java.util.Date date =
          cal.
          getTime(
            );
        if (encodeParam !=
              null) {
            encodeParam.
              setModificationTime(
                date);
        }
        if (emitProperties) {
            properties.
              put(
                "timestamp",
                date);
        }
    }
    private void parse_tRNS_chunk(org.apache.batik.ext.awt.image.codec.png.PNGChunk chunk) {
        if (colorType ==
              PNG_COLOR_PALETTE) {
            int entries =
              chunk.
              getLength(
                );
            if (entries >
                  paletteEntries) {
                java.lang.String msg =
                  org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                  getString(
                    "PNGImageDecoder14");
                throw new java.lang.RuntimeException(
                  msg);
            }
            alphaPalette =
              (new byte[paletteEntries]);
            for (int i =
                   0;
                 i <
                   entries;
                 i++) {
                alphaPalette[i] =
                  chunk.
                    getByte(
                      i);
            }
            for (int i =
                   entries;
                 i <
                   paletteEntries;
                 i++) {
                alphaPalette[i] =
                  (byte)
                    255;
            }
            if (!suppressAlpha) {
                if (expandPalette) {
                    postProcess =
                      POST_PALETTE_TO_RGBA;
                    outputBands =
                      4;
                }
                else {
                    outputHasAlphaPalette =
                      true;
                }
            }
        }
        else
            if (colorType ==
                  PNG_COLOR_GRAY) {
                grayTransparentAlpha =
                  chunk.
                    getInt2(
                      0);
                if (!suppressAlpha) {
                    if (bitDepth <
                          8) {
                        output8BitGray =
                          true;
                        maxOpacity =
                          255;
                        postProcess =
                          POST_GRAY_LUT_ADD_TRANS;
                    }
                    else {
                        postProcess =
                          POST_ADD_GRAY_TRANS;
                    }
                    if (expandGrayAlpha) {
                        outputBands =
                          4;
                        postProcess |=
                          POST_EXP_MASK;
                    }
                    else {
                        outputBands =
                          2;
                    }
                    if (encodeParam !=
                          null) {
                        ((org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.Gray)
                           encodeParam).
                          setTransparentGray(
                            grayTransparentAlpha);
                    }
                }
            }
            else
                if (colorType ==
                      PNG_COLOR_RGB) {
                    redTransparentAlpha =
                      chunk.
                        getInt2(
                          0);
                    greenTransparentAlpha =
                      chunk.
                        getInt2(
                          2);
                    blueTransparentAlpha =
                      chunk.
                        getInt2(
                          4);
                    if (!suppressAlpha) {
                        outputBands =
                          4;
                        postProcess =
                          POST_ADD_RGB_TRANS;
                        if (encodeParam !=
                              null) {
                            int[] rgbTrans =
                              new int[3];
                            rgbTrans[0] =
                              redTransparentAlpha;
                            rgbTrans[1] =
                              greenTransparentAlpha;
                            rgbTrans[2] =
                              blueTransparentAlpha;
                            ((org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.RGB)
                               encodeParam).
                              setTransparentRGB(
                                rgbTrans);
                        }
                    }
                }
                else
                    if (colorType ==
                          PNG_COLOR_GRAY_ALPHA ||
                          colorType ==
                          PNG_COLOR_RGB_ALPHA) {
                        java.lang.String msg =
                          org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                          getString(
                            "PNGImageDecoder15");
                        throw new java.lang.RuntimeException(
                          msg);
                    }
    }
    private void parse_zTXt_chunk(org.apache.batik.ext.awt.image.codec.png.PNGChunk chunk) {
        int textIndex =
          0;
        java.lang.StringBuffer key =
          new java.lang.StringBuffer(
          );
        byte b;
        while ((b =
                  chunk.
                    getByte(
                      textIndex++)) !=
                 0) {
            key.
              append(
                (char)
                  b);
        }
        chunk.
          getByte(
            textIndex++);
        java.lang.StringBuffer value =
          new java.lang.StringBuffer(
          );
        try {
            int length =
              chunk.
              getLength(
                ) -
              textIndex;
            byte[] data =
              chunk.
              getData(
                );
            java.io.InputStream cis =
              new java.io.ByteArrayInputStream(
              data,
              textIndex,
              length);
            java.io.InputStream iis =
              new java.util.zip.InflaterInputStream(
              cis);
            int c;
            while ((c =
                      iis.
                        read(
                          )) !=
                     -1) {
                value.
                  append(
                    (char)
                      c);
            }
            ztextKeys.
              add(
                key.
                  toString(
                    ));
            ztextStrings.
              add(
                value.
                  toString(
                    ));
        }
        catch (java.lang.Exception e) {
            e.
              printStackTrace(
                );
        }
    }
    private java.awt.image.WritableRaster createRaster(int width,
                                                       int height,
                                                       int bands,
                                                       int scanlineStride,
                                                       int bitDepth) {
        java.awt.image.DataBuffer dataBuffer;
        java.awt.image.WritableRaster ras =
          null;
        java.awt.Point origin =
          new java.awt.Point(
          0,
          0);
        if (bitDepth <
              8 &&
              bands ==
              1) {
            dataBuffer =
              new java.awt.image.DataBufferByte(
                height *
                  scanlineStride);
            ras =
              java.awt.image.Raster.
                createPackedRaster(
                  dataBuffer,
                  width,
                  height,
                  bitDepth,
                  origin);
        }
        else
            if (bitDepth <=
                  8) {
                dataBuffer =
                  new java.awt.image.DataBufferByte(
                    height *
                      scanlineStride);
                ras =
                  java.awt.image.Raster.
                    createInterleavedRaster(
                      dataBuffer,
                      width,
                      height,
                      scanlineStride,
                      bands,
                      bandOffsets[bands],
                      origin);
            }
            else {
                dataBuffer =
                  new java.awt.image.DataBufferUShort(
                    height *
                      scanlineStride);
                ras =
                  java.awt.image.Raster.
                    createInterleavedRaster(
                      dataBuffer,
                      width,
                      height,
                      scanlineStride,
                      bands,
                      bandOffsets[bands],
                      origin);
            }
        return ras;
    }
    private static void decodeSubFilter(byte[] curr,
                                        int count,
                                        int bpp) {
        for (int i =
               bpp;
             i <
               count;
             i++) {
            int val;
            val =
              curr[i] &
                255;
            val +=
              curr[i -
                     bpp] &
                255;
            curr[i] =
              (byte)
                val;
        }
    }
    private static void decodeUpFilter(byte[] curr,
                                       byte[] prev,
                                       int count) {
        for (int i =
               0;
             i <
               count;
             i++) {
            int raw =
              curr[i] &
              255;
            int prior =
              prev[i] &
              255;
            curr[i] =
              (byte)
                (raw +
                   prior);
        }
    }
    private static void decodeAverageFilter(byte[] curr,
                                            byte[] prev,
                                            int count,
                                            int bpp) {
        int raw;
        int priorPixel;
        int priorRow;
        for (int i =
               0;
             i <
               bpp;
             i++) {
            raw =
              curr[i] &
                255;
            priorRow =
              prev[i] &
                255;
            curr[i] =
              (byte)
                (raw +
                   priorRow /
                   2);
        }
        for (int i =
               bpp;
             i <
               count;
             i++) {
            raw =
              curr[i] &
                255;
            priorPixel =
              curr[i -
                     bpp] &
                255;
            priorRow =
              prev[i] &
                255;
            curr[i] =
              (byte)
                (raw +
                   (priorPixel +
                      priorRow) /
                   2);
        }
    }
    private static void decodePaethFilter(byte[] curr,
                                          byte[] prev,
                                          int count,
                                          int bpp) {
        int raw;
        int priorPixel;
        int priorRow;
        int priorRowPixel;
        for (int i =
               0;
             i <
               bpp;
             i++) {
            raw =
              curr[i] &
                255;
            priorRow =
              prev[i] &
                255;
            curr[i] =
              (byte)
                (raw +
                   priorRow);
        }
        for (int i =
               bpp;
             i <
               count;
             i++) {
            raw =
              curr[i] &
                255;
            priorPixel =
              curr[i -
                     bpp] &
                255;
            priorRow =
              prev[i] &
                255;
            priorRowPixel =
              prev[i -
                     bpp] &
                255;
            curr[i] =
              (byte)
                (raw +
                   org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.
                   paethPredictor(
                     priorPixel,
                     priorRow,
                     priorRowPixel));
        }
    }
    private void processPixels(int process,
                               java.awt.image.Raster src,
                               java.awt.image.WritableRaster dst,
                               int xOffset,
                               int step,
                               int y,
                               int width) {
        int srcX;
        int dstX;
        int[] ps =
          src.
          getPixel(
            0,
            0,
            (int[])
              null);
        int[] pd =
          dst.
          getPixel(
            0,
            0,
            (int[])
              null);
        dstX =
          xOffset;
        switch (process) {
            case POST_NONE:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    dst.
                      setPixel(
                        dstX,
                        y,
                        ps);
                    dstX +=
                      step;
                }
                break;
            case POST_GAMMA:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    for (int i =
                           0;
                         i <
                           inputBands;
                         i++) {
                        int x =
                          ps[i];
                        ps[i] =
                          gammaLut[x];
                    }
                    dst.
                      setPixel(
                        dstX,
                        y,
                        ps);
                    dstX +=
                      step;
                }
                break;
            case POST_GRAY_LUT:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    pd[0] =
                      grayLut[ps[0]];
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
            case POST_GRAY_LUT_ADD_TRANS:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    int val =
                      ps[0];
                    pd[0] =
                      grayLut[val];
                    if (val ==
                          grayTransparentAlpha) {
                        pd[1] =
                          0;
                    }
                    else {
                        pd[1] =
                          maxOpacity;
                    }
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
            case POST_PALETTE_TO_RGB:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    int val =
                      ps[0];
                    pd[0] =
                      redPalette[val];
                    pd[1] =
                      greenPalette[val];
                    pd[2] =
                      bluePalette[val];
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
            case POST_PALETTE_TO_RGBA:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    int val =
                      ps[0];
                    pd[0] =
                      redPalette[val];
                    pd[1] =
                      greenPalette[val];
                    pd[2] =
                      bluePalette[val];
                    pd[3] =
                      alphaPalette[val];
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
            case POST_ADD_GRAY_TRANS:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    int val =
                      ps[0];
                    if (performGammaCorrection) {
                        val =
                          gammaLut[val];
                    }
                    pd[0] =
                      val;
                    if (val ==
                          grayTransparentAlpha) {
                        pd[1] =
                          0;
                    }
                    else {
                        pd[1] =
                          maxOpacity;
                    }
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
            case POST_ADD_RGB_TRANS:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    int r =
                      ps[0];
                    int g =
                      ps[1];
                    int b =
                      ps[2];
                    if (performGammaCorrection) {
                        pd[0] =
                          gammaLut[r];
                        pd[1] =
                          gammaLut[g];
                        pd[2] =
                          gammaLut[b];
                    }
                    else {
                        pd[0] =
                          r;
                        pd[1] =
                          g;
                        pd[2] =
                          b;
                    }
                    if (r ==
                          redTransparentAlpha &&
                          g ==
                          greenTransparentAlpha &&
                          b ==
                          blueTransparentAlpha) {
                        pd[3] =
                          0;
                    }
                    else {
                        pd[3] =
                          maxOpacity;
                    }
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
            case POST_REMOVE_GRAY_TRANS:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    int g =
                      ps[0];
                    if (performGammaCorrection) {
                        pd[0] =
                          gammaLut[g];
                    }
                    else {
                        pd[0] =
                          g;
                    }
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
            case POST_REMOVE_RGB_TRANS:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    int r =
                      ps[0];
                    int g =
                      ps[1];
                    int b =
                      ps[2];
                    if (performGammaCorrection) {
                        pd[0] =
                          gammaLut[r];
                        pd[1] =
                          gammaLut[g];
                        pd[2] =
                          gammaLut[b];
                    }
                    else {
                        pd[0] =
                          r;
                        pd[1] =
                          g;
                        pd[2] =
                          b;
                    }
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
            case POST_GAMMA_EXP:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    int val =
                      ps[0];
                    int alpha =
                      ps[1];
                    int gamma =
                      gammaLut[val];
                    pd[0] =
                      gamma;
                    pd[1] =
                      gamma;
                    pd[2] =
                      gamma;
                    pd[3] =
                      alpha;
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
            case POST_GRAY_ALPHA_EXP:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    int val =
                      ps[0];
                    int alpha =
                      ps[1];
                    pd[0] =
                      val;
                    pd[1] =
                      val;
                    pd[2] =
                      val;
                    pd[3] =
                      alpha;
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
            case POST_ADD_GRAY_TRANS_EXP:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    int val =
                      ps[0];
                    if (performGammaCorrection) {
                        val =
                          gammaLut[val];
                    }
                    pd[0] =
                      val;
                    pd[1] =
                      val;
                    pd[2] =
                      val;
                    if (val ==
                          grayTransparentAlpha) {
                        pd[3] =
                          0;
                    }
                    else {
                        pd[3] =
                          maxOpacity;
                    }
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
            case POST_GRAY_LUT_ADD_TRANS_EXP:
                for (srcX =
                       0;
                     srcX <
                       width;
                     srcX++) {
                    src.
                      getPixel(
                        srcX,
                        0,
                        ps);
                    int val =
                      ps[0];
                    int val2 =
                      grayLut[val];
                    pd[0] =
                      val2;
                    pd[1] =
                      val2;
                    pd[2] =
                      val2;
                    if (val ==
                          grayTransparentAlpha) {
                        pd[3] =
                          0;
                    }
                    else {
                        pd[3] =
                          maxOpacity;
                    }
                    dst.
                      setPixel(
                        dstX,
                        y,
                        pd);
                    dstX +=
                      step;
                }
                break;
        }
    }
    private void decodePass(java.awt.image.WritableRaster imRas,
                            int xOffset,
                            int yOffset,
                            int xStep,
                            int yStep,
                            int passWidth,
                            int passHeight) {
        if (passWidth ==
              0 ||
              passHeight ==
              0) {
            return;
        }
        int bytesPerRow =
          (inputBands *
             passWidth *
             bitDepth +
             7) /
          8;
        int eltsPerRow =
          bitDepth ==
          16
          ? bytesPerRow /
          2
          : bytesPerRow;
        byte[] curr =
          new byte[bytesPerRow];
        byte[] prior =
          new byte[bytesPerRow];
        java.awt.image.WritableRaster passRow =
          createRaster(
            passWidth,
            1,
            inputBands,
            eltsPerRow,
            bitDepth);
        java.awt.image.DataBuffer dataBuffer =
          passRow.
          getDataBuffer(
            );
        int type =
          dataBuffer.
          getDataType(
            );
        byte[] byteData =
          null;
        short[] shortData =
          null;
        if (type ==
              java.awt.image.DataBuffer.
                TYPE_BYTE) {
            byteData =
              ((java.awt.image.DataBufferByte)
                 dataBuffer).
                getData(
                  );
        }
        else {
            shortData =
              ((java.awt.image.DataBufferUShort)
                 dataBuffer).
                getData(
                  );
        }
        int srcY;
        int dstY;
        for (srcY =
               0,
               dstY =
                 yOffset;
             srcY <
               passHeight;
             srcY++,
               dstY +=
                 yStep) {
            int filter =
              0;
            try {
                filter =
                  dataStream.
                    read(
                      );
                dataStream.
                  readFully(
                    curr,
                    0,
                    bytesPerRow);
            }
            catch (java.lang.Exception e) {
                e.
                  printStackTrace(
                    );
            }
            switch (filter) {
                case PNG_FILTER_NONE:
                    break;
                case PNG_FILTER_SUB:
                    decodeSubFilter(
                      curr,
                      bytesPerRow,
                      bytesPerPixel);
                    break;
                case PNG_FILTER_UP:
                    decodeUpFilter(
                      curr,
                      prior,
                      bytesPerRow);
                    break;
                case PNG_FILTER_AVERAGE:
                    decodeAverageFilter(
                      curr,
                      prior,
                      bytesPerRow,
                      bytesPerPixel);
                    break;
                case PNG_FILTER_PAETH:
                    decodePaethFilter(
                      curr,
                      prior,
                      bytesPerRow,
                      bytesPerPixel);
                    break;
                default:
                    java.lang.String msg =
                      org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                      getString(
                        "PNGImageDecoder16");
                    throw new java.lang.RuntimeException(
                      msg);
            }
            if (bitDepth <
                  16) {
                java.lang.System.
                  arraycopy(
                    curr,
                    0,
                    byteData,
                    0,
                    bytesPerRow);
            }
            else {
                int idx =
                  0;
                for (int j =
                       0;
                     j <
                       eltsPerRow;
                     j++) {
                    shortData[j] =
                      (short)
                        (curr[idx] <<
                           8 |
                           curr[idx +
                                  1] &
                           255);
                    idx +=
                      2;
                }
            }
            processPixels(
              postProcess,
              passRow,
              imRas,
              xOffset,
              xStep,
              dstY,
              passWidth);
            byte[] tmp =
              prior;
            prior =
              curr;
            curr =
              tmp;
        }
    }
    private void decodeImage(boolean useInterlacing) {
        if (!useInterlacing) {
            decodePass(
              theTile,
              0,
              0,
              1,
              1,
              width,
              height);
        }
        else {
            decodePass(
              theTile,
              0,
              0,
              8,
              8,
              (width +
                 7) /
                8,
              (height +
                 7) /
                8);
            decodePass(
              theTile,
              4,
              0,
              8,
              8,
              (width +
                 3) /
                8,
              (height +
                 7) /
                8);
            decodePass(
              theTile,
              0,
              4,
              4,
              8,
              (width +
                 3) /
                4,
              (height +
                 3) /
                8);
            decodePass(
              theTile,
              2,
              0,
              4,
              4,
              (width +
                 1) /
                4,
              (height +
                 3) /
                4);
            decodePass(
              theTile,
              0,
              2,
              2,
              4,
              (width +
                 1) /
                2,
              (height +
                 1) /
                4);
            decodePass(
              theTile,
              1,
              0,
              2,
              2,
              width /
                2,
              (height +
                 1) /
                2);
            decodePass(
              theTile,
              0,
              1,
              1,
              2,
              width,
              height /
                2);
        }
    }
    public java.awt.image.Raster getTile(int tileX,
                                         int tileY) {
        if (tileX !=
              0 ||
              tileY !=
              0) {
            java.lang.String msg =
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
              getString(
                "PNGImageDecoder17");
            throw new java.lang.IllegalArgumentException(
              msg);
        }
        return theTile;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1dCXgcxbHu3ZUsId8ntsEG2zJgMBK2sbExlyTLkkAXkmxA" +
       "2IjR7kgavNodZntl2Ym5EgKEF8JhzoATwAQCBPM4ws1zIEAIBD4cCCY8rpBH" +
       "OBMTh4SEQF5Vd+/O7Ox0r2aMou+b3tFsV1f9f3dXV89M9975CSlOWWSmnqAV" +
       "dIOppypqE7RVs1J6rCaupVIdcK0renVE233a+83LwmREJxnTp6WaolpKX2no" +
       "8Viqk8wwEimqJaJ6qlnXYyjRaukp3RrQqJFMdJLJRqqh34wbUYM2JWM6Zlit" +
       "WY1kvEapZXSnqd4gCqBkRiNYUsksqaxyf728kYyKJs0Ndvapjuw1jm8wZ7+t" +
       "K0XJuMYztAGtMk2NeGWjkaLLBy1yiJmMb+iNJ2mFPkgrzogvFhQc37g4j4LZ" +
       "d4/92xeX9o1jFEzUEokkZfBSbXoqGR/QY41krH21Nq73p84kZ5FIIxnpyExJ" +
       "eWNGaSUorQSlGbR2LrB+tJ5I99ckGRyaKWmEGUWDKJmVW4ipWVq/KKaV2Qwl" +
       "lFKBnQkD2v2zaDnKPIhXHlK5+erTxt0TIWM7yVgj0Y7mRMEICko6gVC9v1u3" +
       "UlWxmB7rJOMTUNntumVocWOjqOkJKaM3odE0VH+GFryYNnWL6bS5gnoEbFY6" +
       "SpNWFl4Pa1Div+KeuNYLWKfYWDnClXgdAJYZYJjVo0G7EyJF64xEjJL93BJZ" +
       "jOUnQAYQLenXaV8yq6ooocEFMoE3kbiW6K1sh6aX6IWsxUlogBYl06WFItem" +
       "Fl2n9epd2CJd+Vr5V5BrL0YEilAy2Z2NlQS1NN1VS476+aT5qEu+kahPhEkI" +
       "bI7p0TjaPxKEZrqE2vQe3dKhH3DBUQc3XqVNeezCMCGQebIrM8/zwDc/PW7+" +
       "zO2/5Hn28cjT0n2GHqVd0a3dY17at2besgiaUWomUwZWfg5y1staxTfLB03w" +
       "MFOyJeKXFZkvt7c9fco5t+sfhUlZAxkRTcbT/dCOxkeT/aYR1606PaFbGtVj" +
       "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" +
       "AlRMp9C4WoLlicBYVktK9u4x3rXzZIBB");
    public static final java.lang.String jlc$ClassType$jl7$1 =
      ("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" +
       "JJeOMoWoC61jy1FHC3lIwckjmNyH65V0iov98N/LbD7u/zr4GKSktLW5jvFt" +
       "piwy1fWqRasWXQdfdUXv2jK2dO8tq17lvzCOe1RgAaMaSWlPOh53bC7h3Ghi" +
       "hGnpPXwt2CiWjmc/Gl38JCUHDfUxKiURkz+cLn6CSz9NSflQpPHHpPHTKfss" +
       "JTPVsiDFPp1Sz1MyVSYF9kHqzP0iJZO8ckNOSJ05d8Dcw50T9LNPZ75XwE3Y" +
       "+SgZwU+cWXZC6ZAFT18zMy7+6CGRzPaBaTfwCRvfq1WPsfYwyB/H5eyewX4w" +
       "cnKhlud4d2eOdFeXpnSrWAu+bcvxzd/4dMktbJOb4mhc27gRSxnZSEpwd36N" +
       "P46L5K0rd5aWKWtE/bwvxty919zM20DjucF2N97H7mFszyMTm/10e0OcKsvS" +
       "NqTK2Qduc/La1qMe//WFI3aESehUEoIAdeKpfAsbfIZbyXcbWT5opi0y49TG" +
       "3N0CnLufLJ933YZj5vf8+XU0zCR8c5p95fm7oi/fuvY3l0/dOjNMRjZAm8Sd" +
       "EzpJmZFasSHRpkcHrE4y2kjVDoKJUIqhxRtIaTphnJnWG2KyvWVG5+wtQ8ls" +
       "98/AD2EvmdGNZKR9hdeMcnsZFLCviKrElP3G51r2biM03q7GJtPMbDaz1/km" +
       "c1CGx2jCF5cWf8xO8eyT/wddnQEf7pYAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "wy999Z89n/sS48sPGIJ94RnzOFvkD5Af/JXuy5X/43LhynEIcctFnpsPevzm" +
       "wOHeQIviwOVuCh9euFF+rr+N5rPkZbmKzwS4R3Fc9v+3nbPvX2fJe9IuX8lU" +
       "vamZc7K/PymccQFfeaDbKqXbd22N/LvOcVv57991mNt6IHNbaJ/gEObGgBrs" +
       "7Bu++0DeLEb77i3vd5/Deyn78gOH8d5/ipcd7ex8f/AOQoXv2eJ+zzm4eRP9" +
       "P+8gVNjijuhdtD9yIC2Ubh/Y0n7gHNqc6KcOo33oFG2TR5hmd6c9/PSByGC6" +
       "fe8W+XvPQc5jhZ89DPnBU8h0E+F6u4B/7uLA92W/Zn3uD22Bv+8W4I0f/5Xd" +
       "nLlNv/WI7umydHTpchNOvO34RPdn5WZf3r49Uf4ZFYwn6RIhGduR6dtaN5BU" +
       "Mz2YToeE0fY6/9HlyH+2cyVnhM+1/EBa44ON7JvPqKA8QSDJ90MgXEzlwFuG" +
       "WgAMsisapmJpAS25mn0k9z/HaXIT4PYHBP/pyJB+54IBQZZ8w7F1f/LWYCD7" +
       "95uy5J239u7Z/+/anDY/Oku+9ZxO61Pn7Pt0lvyXLHnfhuScvH906jrJLSr4" +
       "xJEK/viOVPDxO1TBJ/LCPn47Ffz5Ofv+Mkv+9FgFHz9PBX99S///qwe6o2wc" +
       "8KGtl/jQHnf03y/iju6Rzaij+adiylNUnzuQKgu9P7yl+vAeqv/vIlRPOx6J" +
       "7ML6+wOxXpJuP7LF+pHdWJcKF8HK708F6cgojWs3cecOvEuXDsR7Ybr96Bbv" +
       "R/fg3X0RvPt0005HS/vJ7jmQ7NF0+7Et2Y/tIbv/ImQP5MO47A7TfrgHDoT7" +
       "wnT7iS3cT+yBe9ZF4O73JVuLIg1x0wHbZox0lu3ZB7K9KN0+smX7yB62F1yE" +
       "LR3AqPQG70x/+YJtBV3695vTbD6feEcmB6Y61YBWOiJnlcD0o3QMi7gLM/Bc" +
       "Jy3jyeovL3KajdKHuSo230dR4aq82upiVwdy6SVH6n3lnXQgl158Zx1Ietr8" +
       "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" +
       "ufuNPjLYRrIZAr52axyXcuO4XNhM3N/34MaWKH8u9Ybyle/7x9/40zd/6leu" +
       "FO4iCvdmE+ylQFPTUVrh+r7lKk4X8BiXfuukRz1OFO7fHJ0O8vJq3VbfQ8e/" +
       "Hj/9HBVes6/s/Dm2Mw9JZws+2N5SC1pe7Ob3pV90Zop/7Pun9+aGcN8dG8Jb" +
       "gsKrL6C7Y9EL27+Hcou//+Shi+x5ttM7/bRnaBNNlr3BTWjkBt9k+s0WgeQW" +
       "lj3ut506cPMjJJsHKHORSjc9TLqZR3jKVXzjga7ii1I7eeXWVbxyj6v44Yu4" +
       "intVKZJufsb4OUePl3TSXaeeQT6D/KHDJ1VdKm6Ri3uQP3IR5GfkU4hoLaDN" +
       "RLN3Od6fPPy26aVXb9FevQftoxfSppmpqyW5mxDpLNd/OJDrBWn5r9lyvWYP" +
       "1y9chOvpmxtWe8F+8fBJPpdKW7DSHrBfv5DCFCN2rb6raskurt84/NbUpfKW" +
       "q7yH6z9dhOuebKI7rq3Cc3oPRlrmzvKG8lPDT//md6w/9MHNg69Z/xcViue5" +
       "yZvX8Mn6kXMe1TvV0f5t94s/9qf/L/+my1sP8vSbxX/wPPFzV3WUnFbybx2o" +
       "ZCAtHdqeBdqj5D+4kFVmSt4+ZpflvPy7t4qz90R7xfn0geKkDetSdXuW6h5x" +
       "PnOhqGt9bDR7hNl7mr3C/Onhtz8vwduzwHuE+exFhLlvfYHK2XumvfL89wPl" +
       "yUZN9e1Z6nvk+fuLyHN3ZGicefIM5QvzTu7kBqQQmFEWGTBSGG3WWThF/fnD" +
       "Z6xf+uIt9Rfvpr5y5UJuaJrd1iPiPGQ8M8/lytWLUz2U/XpXWjq/pSL3UN27" +
       "myq/T5KPhk6uEW9u3meTcPLcb7v5ZM8+Osmuk83zCbK+f+Y+x5WnH6jndGB6" +
       "abw9yXiPRA9fyDqyaXd71PzIgaNPMB08bp3wlT190JXnHzbofFo2RSLTdH0X" +
       "4BccftH1Sm0LuMd/X3nxYYAP5A98kJ6q2Rlq/aiVveRMK8se5M7vrraP858R" +
       "5iWHX62/0tgK09gjzKsOE+b+4wkpe1VevAOVf8mWcp9DAA+jfORmlee8OdvL" +
       "z7CWD2RNTeLKNuvmcwdr/TDWe4/sF4R3abNx+JXhK8iWsLmH8PWHET54szZz" +
       "zls0+YYDOV+bnq+75ezu4UQPbGg32eZudXbvQJ3EFrO3B5M8DPNZO4xzt04H" +
       "d2Cd20dMN587YA+8GXBsnVB5lzoPvQGQBndX2C0htYfwvOVpbm+dOectmjxg" +
       "hZpj6xxtOUd7OOUnYp271ancgTrFLSa/B9N84ta5W6ezO/Dzb9zCvnEPrH8Y" +
       "7D1Mt7W3H5offhvwirTle9MevuWBveWJMlPSnT1QciBl2kNeUbaUyh7KtxwY" +
       "QWU3f/eq8a13oEZjC6juAXz7HUdQGepOPX7tHehxtsWc7cHccz/hPD3u73kO" +
       "uIp53Fy8LaC1B/BdT0SPu/ucdx+I+fr8dBvM+R7Mbz+wzzmyx92K/Nd3oMjF" +
       "ljDYQ/hdd9znZKy7NXnAOjLHFplsOZM9nN9/Zxa5u7f5gTsIL968BVztAfzQ" +
       "E7HI3f3Mh+/AIt+6xXzrHsyfuEOL3K3Ij9yBIr9mS/hVewh/5glZ5G5NfvS2" +
       "nHlpyaVLUeFa+Xrteik76j+eQ7JjiZrnzGzlsaNFyXgtyBYUeGxm17LdX3sz" +
       "UOH2Ae4RUHjTDSjCc6ePf/0fv/PXv/mlf3C5cAk7WuYyy93LruR81cv+Olv1" +
       "4cqvHcb+/IydzWfmElIYkfk6t5qa4edFnH1e20457lik6NFCrxL2m0d/BKi2" +
       "x1MlkXsxJI7Cvlp3oxDpltfYlGzh5VBGEnvFEZbVHFtO0iz3Z0zNmkqLgaeK" +
       "bmSXJ04VmeIIWseMtdfkls1hu0WTlWUIrvtIs9/qVJR2e1IP/FaPapGcUWGR" +
       "IVrl1SJA1aikFJQl0ouLMhShIQ/qDR1Sx3y9QTYatWqbtSlBYB133uTVPuX7" +
       "K3+O1Bg+BDE4aEuxz/dVBS8FmssjZQiSinWIWDoMgiUu58OC5Nk+Pi67Xp03" +
       "51Z9uURMZ45JGDy33fFkNWOk2PIhJhjO");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "wZ1Fazqx8MSua5JIE/zM5Nn6uAgVcXRu");
    public static final java.lang.String jlc$ClassType$jl5$2 =
      ("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" +
       "2OrvNt1/82QI+p1bQb/zKRL0w+cI+iNZ8u9OBM0Wd98l6AefDEG3b4i8essb" +
       "Ip8kQf/9OYJ+NEs+cixohIyjnYLedgnXiwj6O1tBf+cpEvSXzxH0V7Pk508E" +
       "7ZO7I6P/+GQIun3J1NVbXjL1JAn6W+cI+ttZ8okTQZkBu1PQ274f7QKCXtte" +
       "7rn2pF/u2Qr66XME/aMs+f1jQdfcHtP9L09A0OwFrtl1rWvbyzvXnqTLO9fy" +
       "DNlrVArcriQX8C/OEf6vsuRPsjeR5eOe42UyL//TieC3fT3aOYLnr8ropYhv" +
       "2Qr+lgMEv92VkCvHF0437+o+JfPfnSPz32fJ57JXw+VvWmRjGTXtjdin6/t/" +
       "PFGxM8P+V1ux/+VTJ/ZW9izrtav7xb6Wvbfm6j9F+Zrwqdgjf5fU1wpPVOo0" +
       "5r+2vYh87V1PotRX81xXz0h9IvqD54j+UJY8PSo8vBG9udCCdOi+U/77nqj8" +
       "r0vl/v6t/N/3zyj/C86R/0VZ8pyo8Myjd4tqkbFT+uc+UWfeTaX+2Fb6W97j" +
       "fo705/i4u/MMd+eS5j8+Kyo868xFmFN+60QtZxT0inMU9OoseWlUeIa/eedc" +
       "vgR9eEY5jz1R5XxxoXDX9kXjd33syVbObsnP6AA+Rwe5jGCUv3EiN5LwrAJu" +
       "u+To7RRQSVGftTl28/nEFXDS1V96Zy5G6xwRs6t81153/I7dfmY7Z2T8kicg" +
       "Y75C8vNS2V62lfGWt9TcTsZX7JTx1EstT9Xl2VynBc3eW3Otny2ArEXZ8tjZ" +
       "v688ERI7RMgkKtxDD7q5svwwKDz3zJ0/WlKsdNcN5Yff/8A9z3n/6HcuF64S" +
       "havZO0ayop5GFO7RY9s+9XKQ0y8KucsPNN3MxX5ant7v5xIIUeEVF71DERWu" +
       "pGkGfo3fHC1GhccucnRUuJZ/nj72TVHhRecfmx6Vf54+6sujwnP3HZXypenp" +
       "3OmJH9mVO82Zpqdz6mlgejZnev7883Q+M224J/miwl2bL6ez2GnpaZbsq+Mf" +
       "edLXXUjJ+at3WDO7nr55baim5vaQbC6+P/d0e8gsrPDQ7Szs1K3kl+591w4Z" +
       "09tXMXzo/djgKz4Lf2/+KqJrii2t11kp9xCFu7PXoUubi++XkrOvdThd2lFZ" +
       "d/Ve+fn7P/y0lx3dnL5/A3zSNk+xfeHJm4fanm1v3rYePoY4frTK3lCz/snn" +
       "/Nhrv+/9n8rK8v9/q8zYCteqAAA=");
}
