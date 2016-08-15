package org.apache.batik.ext.awt.image.codec.png;
public class PNGRed extends org.apache.batik.ext.awt.image.rendered.AbstractRed {
    static class PNGChunk {
        int length;
        int type;
        byte[] data;
        int crc;
        java.lang.String typeString;
        public PNGChunk(int length, int type, byte[] data, int crc) { super(
                                                                        );
                                                                      this.
                                                                        length =
                                                                        length;
                                                                      this.
                                                                        type =
                                                                        type;
                                                                      this.
                                                                        data =
                                                                        data;
                                                                      this.
                                                                        crc =
                                                                        crc;
                                                                      typeString =
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
        }
        public int getLength() { return length;
        }
        public int getType() { return type;
        }
        public java.lang.String getTypeString() {
            return typeString;
        }
        public byte[] getData() { return data;
        }
        public byte getByte(int offset) {
            return data[offset];
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
            java.lang.String s =
              new java.lang.String(
              );
            s +=
              (char)
                data[offset];
            s +=
              (char)
                data[offset +
                       1];
            s +=
              (char)
                data[offset +
                       2];
            s +=
              (char)
                data[offset +
                       3];
            return s;
        }
        public boolean isType(java.lang.String typeName) {
            return typeString.
              equals(
                typeName);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "Z36H8P2Pc/D9aV78tx2+vhuVz6y9//5u");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("4HMO8TnfIXzfuju+g4Lsz4/xVc7ge/PdwBcc4gu+M/gO7j8H34N5cekYX+00" +
           "voPL79S1PAuu7BBf9h3C9/g5+L4rLx6JoKsA3855FhD33vPg0XcAMT/9V3jP" +
           "lw8hvvyuQ3ylgPHcORDzow0HT4MsxAyPzyqe+WZ2WfY8W5PcPepn3g7qNIKu" +
           "HB1ELRrfG0HI2zzJCvKqJ247Ob877a188bVrVx5/Tfjd3emuoxPZ9zHQlWVs" +
           "2yeP2pyoX/IDbWkW6rtvd97BL9RRjqAPfbuyRdBFf/eh96C04waJ6Y1vhzs/" +
           "DJL/nuQFmeDT5/MCruL3JNdfjqAn7sYF5APlSeoXIug9d6IGlKA8SfliBF0/" +
           "SwnGL35P0uFgcezpgBntKidJSNA7IMmrXf/IAE58D96dpEoPTifSx07ykbey" +
           "tRO593OnTsIU/5FxdHwo3v1Pxi3lS69Rgx/8ZuOndidnFVvabvNerjDQ5d0h" +
           "3qLT/AjS++/a21Ffl3offvOhn73vg0fZ/EM7gffL9oRsz9z5mCrh+FFxsHT7" +
           "Tx7/xx/9+6/9fvFB/P8B0oj0BiozAAA=");
    }
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
    private java.awt.Rectangle bounds;
    private java.util.Map properties = new java.util.HashMap(
      );
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
    public PNGRed(java.io.InputStream stream)
          throws java.io.IOException { this(
                                         stream,
                                         null);
    }
    public PNGRed(java.io.InputStream stream,
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
                                               org.apache.batik.ext.awt.image.codec.png.PNGRed.PNGChunk chunk;
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
              "" +
            (char)
              (type >>
                 24 &
                 255) +
            (char)
              (type >>
                 16 &
                 255) +
            (char)
              (type >>
                 8 &
                 255) +
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
    private static org.apache.batik.ext.awt.image.codec.png.PNGRed.PNGChunk readChunk(java.io.DataInputStream distream) {
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
            return new org.apache.batik.ext.awt.image.codec.png.PNGRed.PNGChunk(
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
    private void parse_IHDR_chunk(org.apache.batik.ext.awt.image.codec.png.PNGRed.PNGChunk chunk) {
        int width =
          chunk.
          getInt4(
            0);
        int height =
          chunk.
          getInt4(
            4);
        bounds =
          new java.awt.Rectangle(
            0,
            0,
            width,
            height);
        bitDepth =
          chunk.
            getInt1(
              8);
        int validMask =
          1 <<
          1 |
          1 <<
          2 |
          1 <<
          4 |
          1 <<
          8 |
          1 <<
          16;
        if ((1 <<
               bitDepth &
               validMask) ==
              0) {
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
    private void parse_IEND_chunk(org.apache.batik.ext.awt.image.codec.png.PNGRed.PNGChunk chunk)
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
                                       int width =
                                         bounds.
                                           width;
                                       int height =
                                         bounds.
                                           height;
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
                                       java.awt.image.SampleModel sm =
                                         theTile.
                                         getSampleModel(
                                           );
                                       java.awt.image.ColorModel cm;
                                       if (colorType ==
                                             PNG_COLOR_PALETTE &&
                                             !expandPalette) {
                                           if (outputHasAlphaPalette) {
                                               cm =
                                                 new java.awt.image.IndexColorModel(
                                                   bitDepth,
                                                   paletteEntries,
                                                   redPalette,
                                                   greenPalette,
                                                   bluePalette,
                                                   alphaPalette);
                                           }
                                           else {
                                               cm =
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
                                               cm =
                                                 new java.awt.image.IndexColorModel(
                                                   bitDepth,
                                                   palette.
                                                     length,
                                                   palette,
                                                   palette,
                                                   palette);
                                           }
                                           else {
                                               cm =
                                                 createComponentColorModel(
                                                   sm);
                                           }
                                       init(
                                         (org.apache.batik.ext.awt.image.rendered.CachableRed)
                                           null,
                                         bounds,
                                         cm,
                                         sm,
                                         0,
                                         0,
                                         properties);
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
    private void parse_PLTE_chunk(org.apache.batik.ext.awt.image.codec.png.PNGRed.PNGChunk chunk) {
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
    private void parse_bKGD_chunk(org.apache.batik.ext.awt.image.codec.png.PNGRed.PNGChunk chunk) {
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
        if (emitProperties) {
            int r =
              0;
            int g =
              0;
            int b =
              0;
            if (colorType ==
                  PNG_COLOR_PALETTE ||
                  bitDepth ==
                  8) {
                r =
                  bkgdRed;
                g =
                  bkgdGreen;
                b =
                  bkgdBlue;
            }
            else
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
            properties.
              put(
                "background_color",
                new java.awt.Color(
                  r,
                  g,
                  b));
        }
    }
    private void parse_cHRM_chunk(org.apache.batik.ext.awt.image.codec.png.PNGRed.PNGChunk chunk) {
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
    private void parse_gAMA_chunk(org.apache.batik.ext.awt.image.codec.png.PNGRed.PNGChunk chunk) {
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
    private void parse_hIST_chunk(org.apache.batik.ext.awt.image.codec.png.PNGRed.PNGChunk chunk) {
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
    private void parse_iCCP_chunk(org.apache.batik.ext.awt.image.codec.png.PNGRed.PNGChunk chunk) {
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
    private void parse_pHYs_chunk(org.apache.batik.ext.awt.image.codec.png.PNGRed.PNGChunk chunk) {
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
    private void parse_sBIT_chunk(org.apache.batik.ext.awt.image.codec.png.PNGRed.PNGChunk chunk) {
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
    private void parse_sRGB_chunk(org.apache.batik.ext.awt.image.codec.png.PNGRed.PNGChunk chunk) {
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
    private void parse_tEXt_chunk(org.apache.batik.ext.awt.image.codec.png.PNGRed.PNGChunk chunk) {
        java.lang.StringBuffer key =
          new java.lang.StringBuffer(
          );
        java.lang.StringBuffer value =
          new java.lang.StringBuffer(
          );
        byte b;
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
    private void parse_tIME_chunk(org.apache.batik.ext.awt.image.codec.png.PNGRed.PNGChunk chunk) {
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
    private void parse_tRNS_chunk(org.apache.batik.ext.awt.image.codec.png.PNGRed.PNGChunk chunk) {
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
    private void parse_zTXt_chunk(org.apache.batik.ext.awt.image.codec.png.PNGRed.PNGChunk chunk) {
        java.lang.StringBuffer key =
          new java.lang.StringBuffer(
          );
        java.lang.StringBuffer value =
          new java.lang.StringBuffer(
          );
        byte b;
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
        chunk.
          getByte(
            textIndex++);
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
        for (int i =
               0;
             i <
               bpp;
             i++) {
            int raw =
              curr[i] &
              255;
            int priorRow =
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
            int raw =
              curr[i] &
              255;
            int priorPixel =
              curr[i -
                     bpp] &
              255;
            int priorRow =
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
    private static int paethPredictor(int a,
                                      int b,
                                      int c) {
        int p =
          a +
          b -
          c;
        int pa =
          java.lang.Math.
          abs(
            p -
              a);
        int pb =
          java.lang.Math.
          abs(
            p -
              b);
        int pc =
          java.lang.Math.
          abs(
            p -
              c);
        if (pa <=
              pb &&
              pa <=
              pc) {
            return a;
        }
        else
            if (pb <=
                  pc) {
                return b;
            }
            else {
                return c;
            }
    }
    private static void decodePaethFilter(byte[] curr,
                                          byte[] prev,
                                          int count,
                                          int bpp) {
        int priorPixel;
        int priorRowPixel;
        for (int i =
               0;
             i <
               bpp;
             i++) {
            int raw =
              curr[i] &
              255;
            int priorRow =
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
            int raw =
              curr[i] &
              255;
            priorPixel =
              curr[i -
                     bpp] &
                255;
            int priorRow =
              prev[i] &
              255;
            priorRowPixel =
              prev[i -
                     bpp] &
                255;
            curr[i] =
              (byte)
                (raw +
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
                boolean flagGammaCorrection =
                  performGammaCorrection;
                int[] workGammaLut =
                  gammaLut;
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
                    if (flagGammaCorrection) {
                        pd[0] =
                          workGammaLut[r];
                        pd[1] =
                          workGammaLut[g];
                        pd[2] =
                          workGammaLut[b];
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
        int width =
          bounds.
            width;
        int height =
          bounds.
            height;
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
    public java.awt.image.WritableRaster copyData(java.awt.image.WritableRaster wr) {
        org.apache.batik.ext.awt.image.GraphicsUtil.
          copyData(
            theTile,
            wr);
        return wr;
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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "QLKSoS/PtqlFR7rVi4cNMNnHoqEWoUw2");
    public static final java.lang.String jlc$ClassType$jl7$1 =
      ("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" +
       "yw5hb/HdvP8HHgBo09mbAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL29CbTr2Fkm6jtVVSqVqkpVxiJDJamEJE6ubMu2rFQSkCfJ" +
       "sgZbki1LkNxosixZkzVZNgQI3U0CAcKQhLCAdNIdCNAZupma7oZ+eQ8aCEN3" +
       "kwUPAo+E6XUDgUWgmR6hw5Nkn+Gea597fKuKs5a2faw9fN+///3vf2/tvfWR" +
       "PytcC/xC0XOtlW654XUtCa+bVu16uPK04DpO1AaSH2hqy5KCgEt/u6G89N8+" +
       "8Ddf+LbZg5cLd4mFhyXHcUMpNFwnYLTAtWJNJQoPnPzasTQ7CAsPEqYUS0AU" +
       "GhZAGEH4OFF4+qmkYeEx4ggCkEIAUghADgFATmKliZ6hOZHdylJIThgsCl9T" +
       "uEQU7vKUDF5YeMnNmXiSL9nbbAY5gzSHe7L/xympPHHiFx495r7hfAvh9xSB" +
       "d3/Xmx/8kSuFB8TCA4bDZnCUFESYFiIW7rM1W9b8AFFVTRULz3Q0TWU135As" +
       "Y53jFgsPBYbuSGHka8dCyn6MPM3PyzyR3H1Kxs2PlND1j+lNDc1Sj/67NrUk" +
       "PeX6nBOuG4bd7PeU4L1GCsyfSop2lOTq3HDUsPDisymOOT7WTyOkSe+2tXDm" +
       "Hhd11ZHSHwoPberOkhwdYEPfcPQ06jU3SksJC4/szTSTtScpc0nXboSF552N" +
       "N9jcSmM9LRdEliQsPPtstDyntJYeOVNLp+rnz6jXf+tXOZhzOcesaoqV4b8n" +
       "TfSiM4kYbar5mqNom4T3vZp4r/Scn37H5UIhjfzsM5E3cf79V//Fl7/mRZ/4" +
       "hU2cL9kRh5ZNTQlvKB+S7//VF7ReBV/JYNzjuYGRVf5NzHP1H2zvPJ54act7" +
       "znGO2c3rRzc/wfyc8HU/rH3ucuHeXuEuxbUiO9WjZyqu7RmW5qOao/lSqKm9" +
       "wtM0R23l93uFu9PvhOFom1/p6TTQwl7hqpX/dJeb/5+KaJpmkYno7vS74Uzd" +
       "o++eFM7y74lXKBTuTq/Cfen1xsLmL/8MCzIwc20NkBTJMRwXGPhuxj8ANCeU" +
       "U9nOADnV+jkQuJGfqiDg+jogpXow07Y3spYpLUPAsNPqBxQ3rTDAS1VrQKGM" +
       "pl7PdM37Jyklybg+uLx0Ka2GF5w1AlbafjDXUjX/hvLuqNn5i4/d+KXLx41i" +
       "K6WwkBV8fVPw9bzg3ICmBV/PC76eF3w9Lfj6puDCpUt5ec/KAGyqPK2wedr0" +
       "U6N436vYN+FvecdLr6S65i2vptK+nEYF9tvm1omx6OUmUUk1tvCJ9y3fNv7a" +
       "0uXC5ZuNbAY6/eneLPkgM43HJvCxs41rV74PvP2P/ubj732re9LMbrLa29Z/" +
       "a8qs9b70rHh9V9HU1B6eZP/qR6Ufv/HTb33scuFqahJSMxhKqdqmFuZFZ8u4" +
       "qRU/fmQRMy7XUsJT17clK7t1ZMbuDWe+uzz5Ja/3+/Pvz0xl/PRMrdMvl960" +
       "UfPNZ3b3YS8Ln7XRk6zSzrDILe4bWO/7fvO//jGYi/vIOD9wqrtjtfDxUwYh" +
       "y+yBvOk/80QHOF/T0ni/877Bd77nz97+FbkCpDFetqvAx7KwlRqCtApTMf+L" +
       "X1h8+rOf+dCvXT5Wmkth2iNGsmUoyTHJ7PfCveeQTEt7xQme1KBYaXPLtOax" +
       "kWO7qjE1JNnSMi39hwdeXv7xP/3WBzd6YKW/HKnRa26fwcnvz28Wvu6X3vy3" +
       "L8qzuaRkHdqJzE6ibazkwyc5I74vrTIcyds+9cLv/nnp+1J7m9q4wFhrudm6" +
       "tJFBzvzZ4Tal4V7vOV4Upt2XJtl5hQJ5jFfn4fXz0tGdRNG8DEueDsyCFwen" +
       "G83N7fKUw3JD+bZf+/wzxp//z3+Rs7zZ4zmtI6TkPb5Ryyx4NEmzf+5ZC4FJ" +
       "wSyNV/0E9ZUPWp/4QpqjmOaopNYvoP3UTiU3adQ29rW7f+v//JnnvOVXrxQu" +
       "dwv3Wq6kdqW8cRaelrYKLZilJi7xvuzLN1qxvCcNHsy+JYVjwRRywRQ2uvTI" +
       "rc1G2mqUtLvZZOFLsuDltyrjvqRnqubyxhZm/5aO6gc6xPC2tezf3OblqJq7" +
       "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" +
       "fla0pmbw8yzOHgVgpTjumFL4aAGrBj3k");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("6I8oq62JriQiH0XscFYU8QYKhzq/FIOAZtvLChKxomjp7JBgOVFvdyjfM0Zl" +
       "LCiVBhxfkVtIU1wrQqu1bKLwTG305I7TRoedXnU+oQUTGZF6a8i0Wu0u1us6" +
       "tLmiiF4LbU6l4kJ0FrZXD1FwJDMwOKGkvqjF0ykAS/5iPFHHawkCWZYJ56JV" +
       "n4cyw0mS5tshXZpDFBvFieeyPBdPERHGhJDFQqKiweVJtzTH2RDnSTTEGIjr" +
       "xH5/uYQ7o2KMczQp4t5iJRoaFLbLdMcr8Y4nhWvRLXd0q1zr44zvlUudpUAK" +
       "dMUr9uqiZZg8X5nzi8GIdNz1GG2Mm2Nk5S5LwYLX+HJbqcZliGfmcncUCTYN" +
       "RKOYTihNhfX1vCuPawtW4UFHakalor4sd+JxyHhuhEJEz+WFRSDNgbmEl4uz" +
       "Vkiv1GTWb+seIZiGYQiAQCdTAGys3G5i9oiEN/uiqydaNA8HXtKTYUyXUT4E" +
       "Kt562IQHznxRZEbNyFulOsTyZXlsz+F+v4R5Y7ukGvXl1Ge1NbKseIyu2Eaa" +
       "qreaDUWO7BvrTrmVhKMmx634FdoxFu6SrHcQrdKk5aEiMlgHEqa8DMUVH+uC" +
       "s4YphDwbzLUEVSq43kRGllTtDqdycxLCPaoh69qkFC3m5bYIyp4lIZYZ1E3P" +
       "9jnGgRm3uXABdhkW7Xa3bBTtUiTg9Saa8Phc5MZ6TcNA0m2Mi3OijpURWMQp" +
       "S6IVZFxs64jf5tpkPRwgUJXpaUSFMbvUSu+SxgzCKiKpI27Et+lZuVcbs915" +
       "4jWG6KJqrNiSiMEwBc20YFZcMRah603BKtXZbi/U7K4VxbAWMnBnhsVzqNjV" +
       "OMlM0GbPY0gVFU181Am5yWA0siA4puAEak4cfKzY+mqIUMG0zCNE6C/7M3tY" +
       "nxF+eRCCKcdysiwPVhUJYvB2pUR19L6Ir91VY70GHQBgDGFKgUQFq8HOFFeK" +
       "C9AZlNAeiKqxRGsTsV6CVuawMkNnotVHy2atqczEfjEYgaulTC5QzBaHfkcu" +
       "BiuwXouKcVJaFRuTSQNkW57MjueBpeikPoPHSbnf9jxs6DMCvBgHUlmjQ7Hd" +
       "gFEeNkBIYxXHnIoGUwYiexH79RJnhThNdor9eZQAVdQYGHqrLy06cElaEbUx" +
       "LFe8kk6UpqQ+n9UmLWY0QVQO0KdanZ+HYFWnJHMirTuhxDIcLJb5Vow69TqG" +
       "1YfjqFn0oKUWT8p1lUOHoRK0axasqn4VUdpRrLf4ulSZq4Ksl9swzGGuyRNl" +
       "3J/xYkklrKQeD8uNNbAaS7NZ2y/2Kk2ky7VVVHHmvXYlWPfHBh3yFCGEJdhs" +
       "lESQmYAItiwJM77f63RVNUkmY5LUgtVw0lFH5TXWpbRm1VxENjJscVSjQ/Wa" +
       "E3rMCZpt1ksDjbZDFa7NLUeulVTEaqypqtSE2ObcGZeWTXMiAiO6MqoCKLRw" +
       "xXji8P1qoLVq+BKtO4xgsiY+afYkuV13ZbrvM9NQGw9jswNVelhXB41W061F" +
       "YyNKmfWpuV4duR7bLw/l6VIpuXYN54eY0l8Gqkw0k+ak2HCi+lrUQlr2W1Vy" +
       "zrf1yCXdnorOXdC1YU2CJr4zqTQrkGX6YNWXAU1VSt2+HDr95swNIsqcs4xh" +
       "02Cp1VLgkmo2EGgMuUtYHZGhCy7hurzwmmyVohVJ5JgShgWrtWywNN/S24oF" +
       "9dBwyBQtja/O9ZqwEMAK3kjGC9iBWhrCj1WdXSznuENaMu4AXXmliXYHsn23" +
       "XKzN282m65hRUJKn8ZQIa8oy8gfmSjUaw35T9hrxqmgigd+Ty+OQr1QAUYh0" +
       "qAZb0ESbTirwqlHUgXlQw03T8xG+tJLdqI70dU0EQHAQsfViMYgHNYGEBkgy" +
       "RBujZZx08DYttqu0ZI10hAmbsFMZNouC3qy2YkmsqAzRSA3yOqTqHVMHfawy" +
       "cAjfB2M2RhUO7i1bqkitF4GKYJVamZRXAg/QdMzZ0koYImtMwIM1ncRxhZzK" +
       "OKcKli/gEGPU68RcBAC7o+ok2VGR0KuCFB2FHlJbtmfOst8VcXSxqJYlXnBN" +
       "wqhTgb6AEYMXVl2iXZ7iPu9qRjS3KwExNwNxLpsLoMSwlRW0FPrJAmrE8wFT" +
       "B2oNGh2gpN/qtcApA7tlJbFAtrSkUZcw8HUAheJY0vT2CpPrkABXqgkNDVyF" +
       "LY/QHklH61Jfj+rlRadlJv1ar8gDU4BNWF4B0BXR7ErD1VwljP6a42nSKpZa" +
       "fglG2qXVfGC3WHXlwzMBUebVaVvtKMFwyOhLsR+7SL8oIPDKizFz6C3qHDWo" +
       "1RprCAUhzOhq0hQ3vBkDDnqlqshKWiNuw2iTbBtgRazZrgtK7SnCIdMqQI7j" +
       "LjNxJbnG+cUV5FFiOMGhqN4GEqhNLtYtEZlAgDUjedNo4oA5R03YpeL5pAiR" +
       "gyLYmhOMSVe6axyyujHQKDMEvF5BfFBp2DPfcZaCosyo4jRaMHSRH4A1vkZQ" +
       "AYKheLMJrqRiCE64YlifzkBbXqvzOlWCxs1ERVqmy1ag4kBuctX+egVWNZwe" +
       "+yvZEGw81WymJ0JNYDI0V9p6XhOEQY1tYOWZTJbaK56vpQ5EXUk4fFQMlGFx" +
       "5Tapmik7S6BidgOO7NYXwtQXZhgz0ZLSZCbJjZaE4/POgBmMi6Dk16qgWpk6" +
       "PpOMonYFhbvUou0tSbdKl2GsuVAREF6VpyN5HIZKJKxKDg8MxbhVWartqt2q" +
       "6f5s0AyxCQdJnCS7ehtjURdnAAXg+U6A8wNkJVHUAvZ4dTSWo5lHE9XVmGxC" +
       "3jpm7Z5UTZp2R6isWi0g4FWxoVXKjlRcjcvBwg2Q9XqalGOfKENJNW1Qwby/" +
       "Rlb9ucNWQm2CDJlxWO0NhJoMrCaNptauI0axhJqAvpxQ1Lxq6u3GqtvoS/hU" +
       "mrbKSQmpG0VXm0xgmAfU5bBTxdSI4dViHVJ7cT1V52SuFAd6URmth+NVbTpT" +
       "Sh26mZBtX4ysUtCbj+N1PGGUhkIH3S5I+5LuOZRSWkoyYIYA3Iiier1cq5VS" +
       "EbdnnknUlvCiQwSjsl7CwsGKDYawxjOUhHDdSb/u9PBeeU2Cnh8TSNPqK2nm" +
       "9lhUGjE0EmYuinVHzb7QBsc6DEcBVA4niwiWJ6oR1KO21DeT8qIUrZem6ohx" +
       "vOYkt6KP5jEe1ASJwFtNljchRR6W1X4PW1arPRSstNB5MsGV3lRU3F4bXYeA" +
       "geJdqsnKI2oh0zNfth0PnlNlU2ksTbflz6Pueh6MA5Ko1kxiGqDDhUCJowpa" +
       "7qKwW08d6WpvGvFMhROmrSonGTDXa8VtCg4bvRrt6YhRWiJTa0kIAwyejQBi" +
       "SPpG1C0HEaE3U/unCzg29/ucEgtIuxJ2KXYkE50oUUi3Uwqs0WIN1XtIhFvl" +
       "6nitgxKBCA6oMvW6q01XHBxzwHQth61wheEKAyzKVrAQjMZgENRTXpy0Lkmd" +
       "aNpjeiNANL3YAQaETxelxtom/JZBUuSwT7JsFVwP8PkgXJfrfjwwxVqC1yJw" +
       "5nTdzrpsVUUQrc4ivDlVMFuyTGayxALe0miyHXd8nx6VJbkyXEBLCGzp5hwz" +
       "04FMMxj2WhworiswFciOK0uCKguuG00QOuklLrtgWXoO6UEIUyuyPlAc1akq" +
       "0axnpA72gtQZtOzYdLkqF4vCAoaqqc8NuDVNJqamuG72wRHQBpB626gFsQ/y" +
       "Tr9TjjVbFdcA2RaxqC5jdHPZqmhMCE1izScsl5qNhxOhbSOawXAa3aryfFeo" +
       "Fy1RpMmytFKIlbpcToUK0LOZRbLCxjQLUcsmAMJCQy1HXLOOuG0UtZQEHnoY" +
       "TGrOfNY2fAwAKLpHNzGmClXd8XLCjupWPxhhHAZNe0BsWoaNGPKi0kRjCQV9" +
       "Sav31cV6oTRLqa+ayshQ6PEyosarECGHiyk8LPe9eb9TXOIjuOJPOrRSw8qY" +
       "TC26S3vZ4+o1pgglEcf1+F5FZ+2yWI7mXSjTa3xCRd04KvVZch1QYNKeL2yk" +
       "P6pqXk8or8clipCgCK6L2KQX69FccOOR1DSq4xACHBRPLVK1HKSD+zpa8+pj" +
       "eWFq2Lq6mBJcq+cF6jAalxnJrA4HNk4nJr+2a6Vh3+xbEcVixngcj/1KMG5J" +
       "Kw0kWZmU+coAKdXUpTCt9VdjByo2V/Z0SZJorC+9AGM1tyy0oURtjWSk3TYh" +
       "D9U61KTVkgNsjhVxuB0PhaSrU1ZdD4G5j6NjgFnW1eKAGwtg6gPqnMAv0SFj" +
       "VrhEpnVJQYpwD5l3Zl2l2wtIMl63awgrCJrbDUaa0QXgOrXiwG7AcMXpGp6s" +
       "6lwCLKcWktoWi+5DpDgbVU1toMzT6IpCTRvtwWg4iHqSLkJVRWosRoA0R8L5" +
       "qtZdc1xXhcnEFvtW00iYGl6pmRA2nKzBitI2msVqzU0HawlU7LSU4mrZIAYG" +
       "MF/a3Mjq+iV0Ul9JU9Q06tV5K2RKtLOc8OYI482EatfYOWWVZkzcF4Kah0fW" +
       "DFyU1LaogAldjw0tUXGMHXnzUm2UWiTctJcm25oBVtQ1gIo06JARJvQdLrC6" +
       "BjzmjRXn2czIqaGIJvlKpU/CqBPok7aCq5yKm+1yU5IS0o6IVU9Gxt1k2oO4" +
       "dIAFlbAlxhMlzCASqjpmnTDF1FzbZa/llVlMk5tWA7dLJXjFctW5UgvqnXpZ" +
       "mjW6Eh5p5b5SmbBdWtMao1oUsHTRZmsLKkZ0q8jHFslVFHYdhUKSje2nLXwA" +
       "Q97MsimmB5uKQyXpkMK0e2GCdeaDYjxCKYx2uxHgVwedKg1MagA4mI/xCNNS" +
       "V8FwlzUFa8OgWDQdbgy0lkmqZSWyhPrmpBpXFh2zFRWHK6FF0KmUupGxaodD" +
       "uG87HY4YVqVsRqFShdEK2zRRV26mXbWmp1VWVrmqa+vDcZkWEqoYzQJ5Nl3I" +
       "niKwtQm6WjCJ5hG9OuLJ5LreA2RomLrAuK8pniyOcQTqSsvZetglJQ2Cu4JD" +
       "c1ovFXiP61YMGBdsbmjVZNAvFik1ikK3WsQSlq2RkUW56WXUVuM+ncqw05Jm" +
       "Dgu6AV/nJ5FrNvyEqBMeIUT2mJ1ndTKr6QueqvZr0cyBZLfeXVeni9loMG4b" +
       "Ejbp65UxOyZXLgPHxXIokXZ50XWXo7ZmVOS5OK3BmMv7ZtS1/diaGfCwYpc4" +
       "fME2uBbZbkxtAOi6jVJ3CYxmLiBinZoXjaggmvdFp6eF6eARq6zbgFZligbM" +
       "VIgysUgHgba1bBeT1awyKGFMnQJnxaiYdovFFYMCpZkXdpaS6ydNmdfHTEdB" +
       "QY2x62ZJ48QSVq4Wu8EMJrhBOhC2WJEiOSgaENN6m9ShBU0xsRRVIKeCid0Z" +
       "wwwHWmdYwtIB8KxTGrAMAnvz4XxeF+dq2zMDfW4otTEr8GJNXi3GJWIyD9B2" +
       "cY1MSVAhhiDTF+Iy0bI68zaHgb0yTiQx0i2ajYE0AaMSbLWq2GxQxzxKKJYj" +
       "K+Rwz+5LFhlyZKk/0QUDHIJQJBbrOKaAWDkpUq2qRrIKoCzWqQ4MywC+Hlc8" +
       "hVXZ+WDVZ+px4sc8N4yKXGcRT8ddN5zX5SXjq8vFRCIo03ApaRQYq4aqcgOI" +
       "SyBqoK8irzoxvNXYjutBiV8J1IRpg+KAJWQa1kQahrAI7DZrK6Az8wBcxkCh" +
       "zsOkPReAQdxd+aYtohC88GJqmtYluYZ8rVRzp6Oa0YCLeV0KmsCWASrE+RLN" +
       "A0C0hIXJjBAmIFqiOgs+JG17OZbVmjjBtXIympTngbZG2wiznBZds11ihg4J" +
       "iMOlqBJDXFu0m1HNW3LlCkDWx6Uq3bK42qLG8rNGi09tAz2qBYu0zEXbhnBh" +
       "XU6VrQeW8DEulSYeDlBKzUUkf6pwGLEMuElNQJx+tdPHabQ1IW1/HFPDirBo" +
       "8R27a3KMoC1JrILJk0U38huMAAtk1+a4kj3pmDIrlTjWg2KuNqURNhpXJ+h4" +
       "NakssgFxn22ClIFYjN+ZqcNhByAFcqXRHVCsVIqi3lNqWp+zylgFxvVQ1yHH" +
       "w/khuDQXJWgVQiHWtw2Ii5SlMG77nbqyFhBuvSZ7XGxHqACAfZciAKridzEh" +
       "XE4bY3i1aCerRZFO6pwAtGQGmluGv3S6Drioj2tWiY5MvJKU/GUAaBZoJGS5" +
       "j9dEfNloTSHb8yAqdQ+Z8qRdJHgElpfOgIaqiDttazDlTseUoZRD1kvtgdkS" +
       "7MW8BK4d3ANFmocD2He4LqsQ8jCMZUYWeH+2JFQ/hCgrthSDtEshH5Gz0bLt" +
       "8FE9qjM+Mydgx+joIBZqaaPRlm61jq+bqgzNVl1mOAocPWyzpRAKQgapa3Wm" +
       "M/BdDBq2TGjY62DF6kKHZtGAQ/ioW6GqCmVVK+mQgyrNYMzoqG11ig1DAGvN" +
       "Z65qtj20hpOpn861Vs0uWhNiExBLqZKXomqX0IYsJgEloCO6wEhotxl+0DRl" +
       "qLkac3p2ti8OCjGDhTw7Fe1mT2kgZsD6QbFTDhqjZQsXij2+qCvWqNqSUMFu" +
       "RZy2NLDypBKN21A07Imy3etNop5sj5JuGPjDtmgNWAdklkWy19RXWNVI8zLS" +
       "vMhF0uiHDST155c9XuT5VpUe0f16ZTGIcLEFJ6DOT22/mfoe3RiaTp0uPh4j" +
       "K0PDFpJdm4aSVGPwsgolmDySkCXRZLGualaWDRwsBoI9KmF4giXByl5AK5Yu" +
       "zaRWPKH1cFxC5Fl1TMC2SyI1j2Qmgiut6yEJp80Yq6zQ+hAajPpSe7JYzAio" +
       "P/LaUWNZ8UaLnlEBJ4INuUOHiZbFdallLwdSoi/SbpdDlFZYbDSx1B0Te2O6" +
       "zRbLSwFX6FKlOgVMRulLCSsk9mC2MEusNF+WOzN+BLWKOF0ZIgNtNVmRUibX" +
       "VnE17C47lhChC2DW9HW8Z/dltDmm8Ta+xByBJjF73KroiuQPB8Soh+EwZ0xL" +
       "rN3kBguJY0lkjAcrMi5HejLopNU8DRQW6NF6ZxEu6lAd8kA1CnUGYvuMBdj9" +
       "JlivqxHYrFYIcT2RGxoLyEEJVOBKMui3lzNfqKpUIIIyM426GL3Q/LKp2ePF" +
       "lE8bSClK/EbgaYSdVGu2M5hZ0FwNkhadDMkVtrCw2FPrWHcsc5UBPCsG1BqN" +
       "F26lM7dMzlyvGNBDUCMiICBGLVVuDsD+IPWuqQEAp+NTscTG7XAZgSKvrZkK" +
       "1e44urNmPHCF+mpjrDu90tj0BYKDQE+JBh4RtmZFaDnSZatZHCelomOXmSVt" +
       "gRUnpdqUtEok9lhTLpfLxTEk+pW1aC4h041NZr3G2lNM7rNKn1s2lunFxjEV" +
       "A0ucXOq1Smu+LMExM0uszngKmkVKr1GhGa1HtNyoQ3C1FqWN2pmvGNKX2NYk" +
       "8kIyGKh1yesztBrW1KmOlgfTZkSP9FBaUWZEsAyEKmPCWFTwWPUgZ2mwM7m3" +
       "siWsxbDTRtpPsyg48hVxhAcW36JGdTimLK49AHgIikug5hdFr9ueBai6dlxm" +
       "sB6TVDYlGECNcasJtGAKxYpyZbZIzQ8Je6BSYWClpBKjCkUI5bSzLleVEFHg" +
       "1L8EpUXDJEG0PzQTJgmmRa2JL3xITGoVEeoWGxXElXDfLabtDU5dojlBTK2O" +
       "xTVaRUqKV1W3tWZX6jz0G/FsAa3NGeIxM5LQLABBPT2AvHk4NLt9Y96x2jyp" +
       "854jL8YLJfFaqpIs/KFEw8Ro2FvPiKrYsWMsNQCpfzVQesvKnLI9PI7NkaS5" +
       "HbMutDABFYehRRqSw1l9ue+1bK+qA6onyxEEliwJbfGltpj6ckHgSaWVJCFl" +
       "ymvivg1TSTyaUWXK0cBiA/N00yIrjI0terlP1BqNo8E0ELEyF5mIEgymdSkJ" +
       "xVlSoXwurIJ9TnKBxoovDbWlqq7S4TpiMt3FcoRrbCjCXQVmFu1Ob1miYHON" +
       "ugmANcpyMq6zlDQwA8ZHkUYoOVUg9jrLpUrI6xqNsbJQnMCrlR0PQL9d8y2w" +
       "0WjqpNzSa+P2pN8VU4s/XyYCTYszTOjAI4cg5Xg6tQeUrTpup0PPRu2K7/tq" +
       "rdqmyRHbKa3rFFCeU81QIdqSMSlqwpodpD5viV4zg2KpjY7wctuKJprMlBFe" +
       "r7GoDrEo7uswztsc0wG8aJ0NF0pzOTbKw1bVmztTkE/U/iQfH+ESWbHqrXJZ" +
       "ohOa5Kep6aHmiQGxth1kPq5iLnQ4MStDRl/zXUb3i9Vqmeu5iZWovOevhg1g" +
       "pacObBPBTRFtFUmULzbJmcca6Rhh5Pc1s9PneDUp08xS7aBgU+soA1iorAGT" +
       "iyWAaa2Ww/pM7ZmUNkoyP2u0XCvVkLFJ");
    public static final java.lang.String jlc$ClassType$jl5$2 =
      ("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" +
       "dMth3udwPDnLgr8N0cv/OSfzmnOIXs+CL83eZ6eFrexMqaO3j377CdPbnlt9" +
       "DtP8xLKXp3D+dsv0b59Kpo1zmL4uC8C09fmapOZU82jPDguNQ16ywWjqY+nH" +
       "SQa5iKpPVOHLKdu7Nmk3n0+mwl99fS6B7jnSyd4WfhUJCw962RlbN3pYm7mR" +
       "nzF2RuubTwbRX9wS/cWniCizO8JRfT986rjCRNG87D0KebrsHPSr5IkQOlR7" +
       "pxCoJyCE/Jy8bHPgt2/Sbj4PaRCvvG2DOCL6yJmzPljJ9iwt366V833LOQqR" +
       "HSt59SvCwvOVtL2E2o5jQo5Kef4tJ4rcFCOX2Fc+CWpz5Re2EvuFp0htznm5" +
       "xNXsaKur82PVGBBcZ6dqWE8G0T/aEv2jp4joV59D9GuyYHlMVE4HszuJ3vYc" +
       "5wsQvfrSTdrN51NA9B3nEM36lav/7JiogjHkTqK3PR3hIkSRLVHkKSL67nOI" +
       "vjcL3nVMVEdIZCfR2x67fBGi7JYo+xQR/cA5RLND865+zzHRWY/ldhL93ieD" +
       "qLolqj5FRD9yDtGPZcGHj4kardZgJ9HbvujvIkSdLVHnKSL6k+cQ/Y9Z8KPH" +
       "RD1MCHYS/bEng+jbt0Tf/hQR/dlziP5cFvwfx0SDZm+36n7iySD6wS3RDz5F" +
       "RP/7OUQ/lQW/dEI0exvDLqK//GQQ/fkt0Z9/ioj+P+cQ/UwW/MYx0bAzCXcS" +
       "ve0u/osQ3b4P7+ot78N7koj+0TlE/yQL/uCEaI/c7Rn94ZNB9PNbop9/ioj+" +
       "1TlE/yYL/vyEKEOxO4l+/kkgem07+XTt7OTTk0T0WmE/0WvZKOPqF46Jrrk9" +
       "qvsPT4Bo9sblbHrr2vYgqc3nEyd6LY+Qvfdocyj22SAneN855O/PgruzVwfm" +
       "457jc22v3HtM/No9T4B4/nIQLIX4dVviX3cA8dtNiFw5njK99JoznJ93DudH" +
       "suDh7F2O+ZGgbCR3DWtD+1R9X3vWE6WdKfY3b2m/86mjveWeU3vsHNqvyIIX" +
       "h/lLHFLaI28n69u+YO52rL8sZfveLev3PImsr+axrp5hfUK9dA71bA3QtWJY" +
       "eHhDHYk1Px267+T/mifAP3+bzMtT3h/e8v/wU1LrtzTw159D/Y1ZAKW17kla" +
       "OBv4mmoooZsfXX3jhPVt3yJ3u1p/Q8r2329Z3/JK+aew1rFzqONZ0AoLzzx6" +
       "BXIqgJ113n6iXRiast6+TvrarxzA/hzLfnce4e6Tenp2WHj2mamnU9b6jFqc" +
       "CIg7R0CTLKDDwjO8zasx8zdlBGeEc9t3yN1OOK8rFO76tU3au371yRbObuZn" +
       "ZCCfI4Ns4u/am8L8xTi5kgRnBfDmJyqAagp1e6b/3bvO9H9CDs6l78lpOOdQ" +
       "zEq6Zhy/Cjw/DfsMR/OJPt15acoN2nKEDuX4yttwvHJvzmN9DsevzoIoLNyj" +
       "uN4qeyPN4mYf5rZnqJ5DMD8g/fkpsTdsCb7hySF46uXCp5T1G85h+Y4seFt2" +
       "WrgWZq8pyP4dnZD8+kNIJmHhrs0DHi/wC88781R3ICnzVE1uKB97/wP3PPf9" +
       "o9+4XLhKFK5mb3rKMnoaUbhnGlnWqVc0nX5d012er02NnPTT8vB+L8f/rrDw" +
       "yos+fQoLV9Iwg33tWzepvyMsPHaR1GHhWv55Ou17wsKLzk+bpso/T6d6X1h4" +
       "3r5UKb40PB37e8LCs3bFTmOm4emY709HG2djpuXnn6fjfTC1Syfx0grbfDkd" +
       "5UNp7mmU7Ov3e0cdBXgbMfn5u5o19ToiB6EvKWGqBcnmOcrzTreBfEnBbd/a" +
       "fGpxwMv2vueMjAbb1+B8/P049VV/Uf/+/DVw1xRLWq+zXO4hCndPXd+WNs9R" +
       "LiVnX6lzOrejvO7CXvWF+//t015+tNzg/g3gk/Z4CtuLT94b0XItK9UTw3WC" +
       "xzq2F66yt4Otf/K5P/b6D7//M1le3v8P458BjSixAAA=");
}
