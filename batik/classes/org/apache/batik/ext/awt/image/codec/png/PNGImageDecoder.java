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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "q1ENTlLjfprlg1z72/yWXb7zX4Jbf8uKFgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "2z98ze+/+bef/XZRofxfm8B+mI4hAAA=");
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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "O769Quwvj/DVzuB7/Z3Alx3gy741+Pbe");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("dQ6++/Pi8hG++ml8e1feLrXkX95eOsD30rcI36Pn4HtvXjwUlK4BfDvyLCAe" +
       "s+few28D4sN5Zc6eP3gA8QffcYifKmA8ew7E5/LiyaB0WfOPtiee+Sh2hbdt" +
       "Q+KsY9RPvRXUSVC6erj3NN9R99htG+B3m7aFL7xy/eqjr6x+f7dF63Bj9b2T" +
       "0lU5NIyT+2VOnF92PEnWCjvcu9ue4BS4oKD0HW92a2xQuujsPsnu7e9614LS" +
       "zTfTO9+7kf+e7Ass9uT5fUGv4vdkLyQoPXa3XkA/UJ6UvhWU3n0naSAJypOS" +
       "HwpKN85KgvsXvyflOiDKj+VAPOxOTor0wOhAJD/t7/apnP6AvdsOleydToqP" +
       "2O6hNwqaE3n0s6c2rhT/seJw/0+4+68VLwhffGU8/b5vNH98t+tVMLgsy0e5" +
       "Oild2W3ALQbN9xA9c9fRDse6PHr+9Qd+5t7nDjPzB3YKH8+/E7o9dee9pn3T" +
       "CYrdodk/f/SfffCfvPKHxafr/w8+nEaL8TIAAA==");
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
      1471109864000L;
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
       "98/AD2EvmdGNZKR9hdeMcnsZFLCviKrElP3G51r2biM03q7GJtPMbDazV8xk" +
       "DsrwGE344tLij9kpnn3y/4RiKD3ulgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL29Cbjr2FWg6zvVlJpSQ4YiCZWkEpI4ubItW7aphMSDZFuD" +
       "JUuyZIuEi0ZL1mgNtmRIQmhC6GbK9xJCoENoIDRDB5LHFOA16QDNDMkjTTM8" +
       "ukPg8TVhbNKBbh5p4Emy7znnnmufe3yrivN92vaxtrb+tfbaa68tbW198C8L" +
       "VwK/UPRcK5lZbnhVjcOrc6t2NUw8NbiK4jVK9ANV6VhiELDpb9fkl3z4gf/5" +
       "+XfqD14s3CEUHhYdxw3F0HCdgFYD11qqCl544PhX2FLtICw8iM/FpQhEoWEB" +
       "uBGET+KFZ504NCw8gV9HAFIEIEUAcgSgdZwrPeg+1YnsTnaE6ITBovCWwgW8" +
       "cIcnZ3hh4cU3FuKJvmhvi6FyCdIS7sr+51Kh8oNjv/D4kewbmW8S+FuKwLu/" +
       "9cse/JFLhQeEwgOGw2Q4cgoRpicRCvfaqi2pftBSFFURCs92VFVhVN8QLWOd" +
       "cwuFhwJj5ohh5KtHSsp+jDzVz895rLl75Uw2P5JD1z8STzNUS7n+3xXNEmep" +
       "rM85lnUjIZL9ngp4j5GC+Zooq9cPuWwajhIWvvD0EUcyPoGlGdJD77TVUHeP" +
       "TnXZEdMfCg9t6s4SnRnAhL7hzNKsV9woPUtYeGxvoZmuPVE2xZl6LSw873Q+" +
       "arMrzXV3rojskLDw6OlseUlpLT12qpZO1M9fDl/7TV/h9J2LObOiylbGf1d6" +
       "0ItOHUSrmuqrjqxuDrz3Vfh7xOf8zNddLBTSzI+eyrzJ85Gv/OwbXv2ij/3y" +
       "Js8X7MhDSnNVDq/JH5Du/80XdF7ZvJRh3OW5gZFV/g2S5+ZPbfc8GXtpy3vO" +
       "UYnZzqvXd36M/sXpV/2g+ucXC/cMCnfIrhXZqR09W3Ztz7BUv6c6qi+GqjIo" +
       "3K06SiffPyjcmX7HDUfd/EpqWqCGg8JlK//pDjf/P1WRlhaRqejO9LvhaO71" +
       "754Y6vn32Cts/66k27u33/PPsGACumurgCiLjuG4AOW7mfwBoDqhlOpWB6TU" +
       "6k0gcCM/NUHA9WeAmNqBrm53ZC1TXIWAYafVD8huWmGAl5oWNewNsp+6avab" +
       "fzUzOu+f93RxJv2DqwsX0op5wWm3YKUtqu9aad5r8rujNvzZH772axePmslW" +
       "b2GhnBJc3RBczQlyl5oSXM0JruYEV1OCq9cJChcu5Gd8JEPYmEFaiWbqDlJH" +
       "ee8rmTehX/51L7mU2p+3upzWQJYV2O+vO8cOZJC7STm14sLH3rt6G/fW0sXC" +
       "xRsdb4ad/nRPdjiVucsjt/jE6Qa3q9wH3vGZ//mh97zZPW56N3jyrUe4+cis" +
       "Rb/ktIJ9V1aV1EceF/+qx8Ufv/Yzb37iYuFy6iZS1xiKqSmnXudFp89xQ8t+" +
       "8rqXzGS5kgqsub4tWtmu667tnlD33dXxL3nN359/f3aq42dlpv5wquvZxvQ3" +
       "n9neh70sfWRjKVmlnZIi98KvY7zv+N2P/ymYq/u6w37gRBfIqOGTJ5xEVtgD" +
       "uTt49rENsL6qpvn+63upd33LX77jS3MDSHO8dNcJn8jSTuoc0ipM1fz2X178" +
       "3h986gO/dfHYaMK0l4wky5DjIyGz3wv3nCFkeraXH/OkTsZKW15mNU+MHdtV" +
       "DM0QJUvNrPR/P/Cy8o//xTc9uLEDK/3luhm9+tYFHP/+/Hbhq37ty/7Xi/Ji" +
       "LshZJ3ess+NsG8/58HHJLd8Xk4wjftsnX/htvyR+R+qDU78XGGs1d2UXcx1c" +
       "zCV/NNweabhXB44XhWmXpm7tPt1XP6T5bnxH3m5ygwDyUl6Vp1czjW4b7E3n" +
       "JeFYVr1Mlvy4WpZ8YXCy0d3Yrk8EQdfkd/7WX9/H/fVHP5tr6cYo6qSNEaL3" +
       "5Mass+TxOC3+uac9TF8M9DRf9WPDNz5ofezzaYlCWqKcOtKA9FNPF99gkdvc" +
       "V+78f37255/z5b95qXARKdxjuaKCiHnjLtydtio10FMnGXuvf8PGqlZ3pcmD" +
       "2be4cKSYQq6YQrwxxufl/+kp4Cv3+zUkC4KOXcPz/p60pK/+o7+7SQm5R9vR" +
       "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" +
       "G6sVbNgLVEShheVMpsmcFiPTA2l/tEAR");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "u2zPpiYWWw1VFCicmxsc05gUwSKGLEwu");
    public static final java.lang.String jlc$ClassType$jl5$2 =
      ("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" +
       "ny+p0YLsEqsSo0vIKJJ9dtDEmGVVc4RRYrciHo+FFr42RIgKOqaN4jqE8QiC" +
       "4IEXgOEAA0Nhbi5ocxCpoWh2wDCV2Kyv9Wg4wVI0cTCs2m7acGtWedawIc4i" +
       "DXbZa3jpPs0sVcZzAgiaCz91dMCiY1eHSOqb/RbZqqwmoyXaKMlIG/SW8qiB" +
       "63B5wNf0tsWsTF1HIIUhQqvcbFJ62S71JlysLqJ2QiTTyXiNizV06aTDtCJG" +
       "q9QKnNabYz0dJOjDxlgJmg1wbpAlJh03U6DB1CBqoc8WVYmQbDKYl2B+OMQj" +
       "yVwUkdp6jFVnfMMyJ4YENAme45CRaLhjVZjOlxzejpFEBAVfUaSgxUMiNq8O" +
       "Gq021unidCS1rTnsGIGlKhEUkbMqiqok4fJuByrPkzLS74DWYCWbc3uY9KEa" +
       "VzLcZbMxBHCpW089mV/tYYwZ4nxtvkRCz1glZY1f0GLAT0aKpowny8ocqyhk" +
       "I1yU69Zy3SHVMj1riYTI8BZF6jVQ6tTTmEs39J7jUZNVWOkY/NyWgZ4FNtDO" +
       "uN/VxjFmjGlzXZRxB+ow6+aQ0ayRR/X76cZiWhCgLMUFRhehvDKzLhMJx0yR" +
       "ptlfrKmSgQpkQzaHJIOWakqjK69qJbaJDymhXpusYHBaZGbCalyU+YnQgYQW" +
       "wpYbayKpF6FOj15TYltktVWHXmqLMk8F2nSVtIF+TU3U1aS6kh1Mt1Lnr1RU" +
       "UkHUiecwPt+KipK8jNcKUFUIM5RQUqraulypz2gmdgQG9lYKCA2pKoTXsJKv" +
       "pC04HQzCgLRaxmHSLDfXRKXUnUcyUhk26/26jQTrhGBtoFxSS6SMBUtmuGDT" +
       "6EmJZAAXywtCBQAeGYAizKj6GHYHLUXFPK0VSNpAkJKJLPFszfWMUlJtsj1w" +
       "WOo4eKThaBMEp8K8ttQaxck4dVF0Q655zZpm110D0KLlFLRKgELOhwQ9F1p2" +
       "g1HgtYfaAiIGTJ/2TLnvw9WkYs65bhpAjAcLPabDgch6uoM6fK+CJUue69WK" +
       "q3DUsFJ7BlrdCry0ld5QwOimrqiE7AQCgneWBubDFgX2amW/IhlpX7io99CQ" +
       "IqSuuOYasdkN/FUPBqvVEDfmTdNzHDABqrSBdcHImrWyNQov/dfDIuaHb4qY" +
       "nygfGjPHu0+5/f3ZhRN/7z75eWJid57z+go3gV944ak3BB8TZu+T/8BXv/v9" +
       "Cvm95euLWXBh4e7Q9V5jqUvVOlHUC/Pv7zrCOFoA57Ubis3nyfnlx1Kf+dx3" +
       "vu94Dd4LxxnYLMOlz57KcGKR3kufy5K/CAv3Go4R9rZP6e+cQL10DeV4fvpf" +
       "3mrUcvJEuwR/eSF7TfdGcOGZEfxyYb/gl7OlAC59Piw8Kxf86LH5S397LOP/" +
       "fgoyPnZdxu1y4xduWm78DBmPlynAbyHoxR/Nhbn3DEHvz5I7szdkqWEnW6Xm" +
       "+vsMv/ZI0su3fCPfGZLmb4B7WYrzD1tJ/+GZlPR5Z0j6WJY8nLY+XxWVXNQ8" +
       "26NhoXzIsv3HR+a6ueW6Cbey9HIq5r2bYzefT6elX35BLvrLz1BL5mcvvzgs" +
       "POhly/VcG/S79LV8uaIbzf3yLZcsOI+gH98K+vFnSNDK7gzXK/rE6+bhWFa9" +
       "bEn2/LhqlrzmWAnwsLtTCVefghLy5TCzR9i+eXPs5vOQlvCKW7aE64I+dmpF" +
       "Cka0PUvNHyrK5X3DGQbRzZInw8Lz5bShhOqOxSyun+X5N617cUOOXGOvfRrM" +
       "5tIvbjX2i8+Q2VBnqIPOEuzINCichXeaBv50CLp9i8elm97i8TQJ+sYzBP2y" +
       "LOGPBJWw3u42MHkaBL38+ObYzeczIKh+hqDzLJGPBJX7NLFTUOXpEPT1W0Ff" +
       "/wwJGp4h6DJL3CNBZy2itVPQW74h7jyCjraCjp4hQb/qDEG/Oku+4khQfcCw" +
       "OwX9yqdDUGkrqPQMCfoNZwiavcTj8juOBDU6HWqnoF/3dAi6XTZ08/kMCPre" +
       "MwT99ix515GgXn8a7BT0lg+5n0fQt28FffszJOgHzhD032bJdx4JGrQHu033" +
       "3zwdgn7nVtDvfIYE/fAZgv5Ilvy7Y0Gzhd13CfrBp0PQ7dshL9/0dsinSdB/" +
       "f4agH82SjxwJGsKTcKegt1y+9TyC/s5W0N95hgT95TME/dUs+fljQQfE7sjo" +
       "Pz4dgm5fMHX5phdMPU2C/tYZgv52lnziWFB6yOwU9JbvRjuHoFe2l3uuPO2X" +
       "e7aCfvoMQf8oS37/SNA1u8d0/8tTEDR7eWt2XevK9vLOlafp8s6VPEP2CpUC" +
       "uyvJBfyLM4T/qyz5k+wtZPm452iJzIv/dCz4LV+Ndobg+Wsy+iniW7aCv+UA" +
       "wW91JeTS0YXTzXu6T8j8d2fI/PdZ8rnstXD5WxaZSEIMayP2yfr+m6cqdmbY" +
       "/2or9r985sTeyp5lvXJ5v9hXsnfWXP6nMF8PPhV77O2S+krhqUqdxvxXtheR" +
       "r7zraZT6cp7r8impj0V/8AzRH8qSZ4WFhzeit5aqnw7dd8p/71OV/3Wp3N+/" +
       "lf/7/hnlf8EZ8r8oS54bFp59/b2iaqjvlP55T9WZ91KpP7aV/qZ3uJ8h/Rk+" +
       "7s48w525pPmPj4aFR09dhDnht47VckpBrzhDQa/OkpeGhfu8zfvm8uXng1PK" +
       "eeKpKueLC4U7ti8Zv+NjT7dydkt+SgfQGTrIZSyH+dsmciMJTivglsuN3koB" +
       "1RT10c2xm8+nroDjrv7CO3Mx2meImF3lu/K6o/frDjLbOSXjlzwFGfPVkZ+f" +
       "yvayrYw3vaHmVjK+YqeMJ15oeaIuT+c6KWj2zporg2zxYzXMlsbO/n3lsZDo" +
       "IULGYeEuatjLleUFfuF5p+78UaJspruuyT/8/gfueu77x79zsXAZL1zO3i+S" +
       "FXU3XrhLiyzrxItBTr4k5A7PVzUjF/vuPL3fyyXgw8IrznuHIixcStMM/Aq3" +
       "OVoIC0+c5+iwcCX/PHnsm8LCi84+Nj0q/zx51JeHheftOyrlS9OTudMTP7Ir" +
       "d5ozTU/m1NLA9HTO9Pz558l8Rtpwj/OFhTs2X05msdLS0yzZV9u77klfdy4l" +
       "56/dYYzsevrmlaGqkttDvLn4/ryT7SGzsMJDt7KwE7eSX7r3PTtERG1fw/Ch" +
       "96PDr/gs9L35a4iuyJa4Xmel3IUX7sxehS5uLr5fiE+/0uFkadfLuqP/ys/f" +
       "/+G7X3b95vT9G+DjtnmC7QuP3zrUcS1r86b14AnY9sIkezvN+ief+2Ov/b73" +
       "fyory/v/AZCjLqHTqgAA");
}
