package org.apache.batik.ext.awt.image.codec.tiff;
public class TIFFImage extends org.apache.batik.ext.awt.image.rendered.AbstractRed {
    public static final int COMP_NONE = 1;
    public static final int COMP_FAX_G3_1D = 2;
    public static final int COMP_FAX_G3_2D = 3;
    public static final int COMP_FAX_G4_2D = 4;
    public static final int COMP_LZW = 5;
    public static final int COMP_JPEG_OLD = 6;
    public static final int COMP_JPEG_TTN2 = 7;
    public static final int COMP_PACKBITS = 32773;
    public static final int COMP_DEFLATE = 32946;
    private static final int TYPE_UNSUPPORTED = -1;
    private static final int TYPE_BILEVEL = 0;
    private static final int TYPE_GRAY_4BIT = 1;
    private static final int TYPE_GRAY = 2;
    private static final int TYPE_GRAY_ALPHA = 3;
    private static final int TYPE_PALETTE = 4;
    private static final int TYPE_RGB = 5;
    private static final int TYPE_RGB_ALPHA = 6;
    private static final int TYPE_YCBCR_SUB = 7;
    private static final int TYPE_GENERIC = 8;
    private static final int TIFF_JPEG_TABLES = 347;
    private static final int TIFF_YCBCR_SUBSAMPLING = 530;
    org.apache.batik.ext.awt.image.codec.util.SeekableStream stream;
    int tileSize;
    int tilesX;
    int tilesY;
    long[] tileOffsets;
    long[] tileByteCounts;
    char[] colormap;
    int sampleSize;
    int compression;
    byte[] palette;
    int numBands;
    int chromaSubH;
    int chromaSubV;
    long tiffT4Options;
    long tiffT6Options;
    int fillOrder;
    int predictor;
    com.sun.image.codec.jpeg.JPEGDecodeParam decodeParam = null;
    boolean colorConvertJPEG = false;
    java.util.zip.Inflater inflater = null;
    boolean isBigEndian;
    int imageType;
    boolean isWhiteZero = false;
    int dataType;
    boolean decodePaletteAsShorts;
    boolean tiled;
    private org.apache.batik.ext.awt.image.codec.tiff.TIFFFaxDecoder decoder =
      null;
    private org.apache.batik.ext.awt.image.codec.tiff.TIFFLZWDecoder lzwDecoder =
      null;
    private static final java.awt.image.Raster decodeJPEG(byte[] data,
                                                          com.sun.image.codec.jpeg.JPEGDecodeParam decodeParam,
                                                          boolean colorConvert,
                                                          int minX,
                                                          int minY) {
        java.io.ByteArrayInputStream jpegStream =
          new java.io.ByteArrayInputStream(
          data);
        com.sun.image.codec.jpeg.JPEGImageDecoder decoder =
          decodeParam ==
          null
          ? com.sun.image.codec.jpeg.JPEGCodec.
          createJPEGDecoder(
            jpegStream)
          : com.sun.image.codec.jpeg.JPEGCodec.
          createJPEGDecoder(
            jpegStream,
            decodeParam);
        java.awt.image.Raster jpegRaster;
        try {
            jpegRaster =
              colorConvert
                ? decoder.
                decodeAsBufferedImage(
                  ).
                getWritableTile(
                  0,
                  0)
                : decoder.
                decodeAsRaster(
                  );
        }
        catch (java.io.IOException ioe) {
            throw new java.lang.RuntimeException(
              "TIFFImage13");
        }
        return jpegRaster.
          createTranslatedChild(
            minX,
            minY);
    }
    private final void inflate(byte[] deflated, byte[] inflated) {
        inflater.
          setInput(
            deflated);
        try {
            inflater.
              inflate(
                inflated);
        }
        catch (java.util.zip.DataFormatException dfe) {
            throw new java.lang.RuntimeException(
              "TIFFImage17" +
              ": " +
              dfe.
                getMessage(
                  ));
        }
        inflater.
          reset(
            );
    }
    private static java.awt.image.SampleModel createPixelInterleavedSampleModel(int dataType,
                                                                                int tileWidth,
                                                                                int tileHeight,
                                                                                int bands) {
        int[] bandOffsets =
          new int[bands];
        for (int i =
               0;
             i <
               bands;
             i++)
            bandOffsets[i] =
              i;
        return new java.awt.image.PixelInterleavedSampleModel(
          dataType,
          tileWidth,
          tileHeight,
          bands,
          tileWidth *
            bands,
          bandOffsets);
    }
    private long[] getFieldAsLongs(org.apache.batik.ext.awt.image.codec.tiff.TIFFField field) {
        long[] value =
          null;
        if (field.
              getType(
                ) ==
              org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                TIFF_SHORT) {
            char[] charValue =
              field.
              getAsChars(
                );
            value =
              (new long[charValue.
                          length]);
            for (int i =
                   0;
                 i <
                   charValue.
                     length;
                 i++) {
                value[i] =
                  charValue[i] &
                    65535;
            }
        }
        else
            if (field.
                  getType(
                    ) ==
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                    TIFF_LONG) {
                value =
                  field.
                    getAsLongs(
                      );
            }
            else {
                throw new java.lang.RuntimeException(
                  );
            }
        return value;
    }
    public TIFFImage(org.apache.batik.ext.awt.image.codec.util.SeekableStream stream,
                     org.apache.batik.ext.awt.image.codec.tiff.TIFFDecodeParam param,
                     int directory) throws java.io.IOException {
        super(
          );
        this.
          stream =
          stream;
        if (param ==
              null) {
            param =
              new org.apache.batik.ext.awt.image.codec.tiff.TIFFDecodeParam(
                );
        }
        decodePaletteAsShorts =
          param.
            getDecodePaletteAsShorts(
              );
        org.apache.batik.ext.awt.image.codec.tiff.TIFFDirectory dir =
          param.
          getIFDOffset(
            ) ==
          null
          ? new org.apache.batik.ext.awt.image.codec.tiff.TIFFDirectory(
          stream,
          directory)
          : new org.apache.batik.ext.awt.image.codec.tiff.TIFFDirectory(
          stream,
          param.
            getIFDOffset(
              ).
            longValue(
              ),
          directory);
        org.apache.batik.ext.awt.image.codec.tiff.TIFFField sfield =
          dir.
          getField(
            org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
              TIFF_SAMPLES_PER_PIXEL);
        int samplesPerPixel =
          sfield ==
          null
          ? 1
          : (int)
              sfield.
              getAsLong(
                0);
        org.apache.batik.ext.awt.image.codec.tiff.TIFFField planarConfigurationField =
          dir.
          getField(
            org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
              TIFF_PLANAR_CONFIGURATION);
        char[] planarConfiguration =
          planarConfigurationField ==
          null
          ? (new char[] { 1 })
          : planarConfigurationField.
          getAsChars(
            );
        if (planarConfiguration[0] !=
              1 &&
              samplesPerPixel !=
              1) {
            throw new java.lang.RuntimeException(
              "TIFFImage0");
        }
        org.apache.batik.ext.awt.image.codec.tiff.TIFFField bitsField =
          dir.
          getField(
            org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
              TIFF_BITS_PER_SAMPLE);
        char[] bitsPerSample =
          null;
        if (bitsField !=
              null) {
            bitsPerSample =
              bitsField.
                getAsChars(
                  );
        }
        else {
            bitsPerSample =
              (new char[] { 1 });
            for (int i =
                   1;
                 i <
                   bitsPerSample.
                     length;
                 i++) {
                if (bitsPerSample[i] !=
                      bitsPerSample[0]) {
                    throw new java.lang.RuntimeException(
                      "TIFFImage1");
                }
            }
        }
        sampleSize =
          bitsPerSample[0];
        org.apache.batik.ext.awt.image.codec.tiff.TIFFField sampleFormatField =
          dir.
          getField(
            org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
              TIFF_SAMPLE_FORMAT);
        char[] sampleFormat =
          null;
        if (sampleFormatField !=
              null) {
            sampleFormat =
              sampleFormatField.
                getAsChars(
                  );
            for (int l =
                   1;
                 l <
                   sampleFormat.
                     length;
                 l++) {
                if (sampleFormat[l] !=
                      sampleFormat[0]) {
                    throw new java.lang.RuntimeException(
                      "TIFFImage2");
                }
            }
        }
        else {
            sampleFormat =
              (new char[] { 1 });
        }
        boolean isValidDataFormat =
          false;
        switch (sampleSize) {
            case 1:
            case 4:
            case 8:
                if (sampleFormat[0] !=
                      3) {
                    dataType =
                      java.awt.image.DataBuffer.
                        TYPE_BYTE;
                    isValidDataFormat =
                      true;
                }
                break;
            case 16:
                if (sampleFormat[0] !=
                      3) {
                    dataType =
                      sampleFormat[0] ==
                        2
                        ? java.awt.image.DataBuffer.
                            TYPE_SHORT
                        : java.awt.image.DataBuffer.
                            TYPE_USHORT;
                    isValidDataFormat =
                      true;
                }
                break;
            case 32:
                if (sampleFormat[0] ==
                      3)
                    isValidDataFormat =
                      false;
                else {
                    dataType =
                      java.awt.image.DataBuffer.
                        TYPE_INT;
                    isValidDataFormat =
                      true;
                }
                break;
        }
        if (!isValidDataFormat) {
            throw new java.lang.RuntimeException(
              "TIFFImage3");
        }
        org.apache.batik.ext.awt.image.codec.tiff.TIFFField compField =
          dir.
          getField(
            org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
              TIFF_COMPRESSION);
        compression =
          compField ==
            null
            ? COMP_NONE
            : compField.
            getAsInt(
              0);
        int photometricType =
          (int)
            dir.
            getFieldAsLong(
              org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                TIFF_PHOTOMETRIC_INTERPRETATION);
        imageType =
          TYPE_UNSUPPORTED;
        switch (photometricType) {
            case 0:
                isWhiteZero =
                  true;
            case 1:
                if (sampleSize ==
                      1 &&
                      samplesPerPixel ==
                      1) {
                    imageType =
                      TYPE_BILEVEL;
                }
                else
                    if (sampleSize ==
                          4 &&
                          samplesPerPixel ==
                          1) {
                        imageType =
                          TYPE_GRAY_4BIT;
                    }
                    else
                        if (sampleSize %
                              8 ==
                              0) {
                            if (samplesPerPixel ==
                                  1) {
                                imageType =
                                  TYPE_GRAY;
                            }
                            else
                                if (samplesPerPixel ==
                                      2) {
                                    imageType =
                                      TYPE_GRAY_ALPHA;
                                }
                                else {
                                    imageType =
                                      TYPE_GENERIC;
                                }
                        }
                break;
            case 2:
                if (sampleSize %
                      8 ==
                      0) {
                    if (samplesPerPixel ==
                          3) {
                        imageType =
                          TYPE_RGB;
                    }
                    else
                        if (samplesPerPixel ==
                              4) {
                            imageType =
                              TYPE_RGB_ALPHA;
                        }
                        else {
                            imageType =
                              TYPE_GENERIC;
                        }
                }
                break;
            case 3:
                if (samplesPerPixel ==
                      1 &&
                      (sampleSize ==
                         4 ||
                         sampleSize ==
                         8 ||
                         sampleSize ==
                         16)) {
                    imageType =
                      TYPE_PALETTE;
                }
                break;
            case 4:
                if (sampleSize ==
                      1 &&
                      samplesPerPixel ==
                      1) {
                    imageType =
                      TYPE_BILEVEL;
                }
                break;
            case 6:
                if (compression ==
                      COMP_JPEG_TTN2 &&
                      sampleSize ==
                      8 &&
                      samplesPerPixel ==
                      3) {
                    colorConvertJPEG =
                      param.
                        getJPEGDecompressYCbCrToRGB(
                          );
                    imageType =
                      colorConvertJPEG
                        ? TYPE_RGB
                        : TYPE_GENERIC;
                }
                else {
                    org.apache.batik.ext.awt.image.codec.tiff.TIFFField chromaField =
                      dir.
                      getField(
                        TIFF_YCBCR_SUBSAMPLING);
                    if (chromaField !=
                          null) {
                        chromaSubH =
                          chromaField.
                            getAsInt(
                              0);
                        chromaSubV =
                          chromaField.
                            getAsInt(
                              1);
                    }
                    else {
                        chromaSubH =
                          (chromaSubV =
                             2);
                    }
                    if (chromaSubH *
                          chromaSubV ==
                          1) {
                        imageType =
                          TYPE_GENERIC;
                    }
                    else
                        if (sampleSize ==
                              8 &&
                              samplesPerPixel ==
                              3) {
                            imageType =
                              TYPE_YCBCR_SUB;
                        }
                }
                break;
            default:
                if (sampleSize %
                      8 ==
                      0) {
                    imageType =
                      TYPE_GENERIC;
                }
        }
        if (imageType ==
              TYPE_UNSUPPORTED) {
            throw new java.lang.RuntimeException(
              "TIFFImage4");
        }
        java.awt.Rectangle bounds =
          new java.awt.Rectangle(
          0,
          0,
          (int)
            dir.
            getFieldAsLong(
              org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                TIFF_IMAGE_WIDTH),
          (int)
            dir.
            getFieldAsLong(
              org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                TIFF_IMAGE_LENGTH));
        numBands =
          samplesPerPixel;
        org.apache.batik.ext.awt.image.codec.tiff.TIFFField efield =
          dir.
          getField(
            org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
              TIFF_EXTRA_SAMPLES);
        int extraSamples =
          efield ==
          null
          ? 0
          : (int)
              efield.
              getAsLong(
                0);
        int tileWidth;
        int tileHeight;
        if (dir.
              getField(
                org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                  TIFF_TILE_OFFSETS) !=
              null) {
            tiled =
              true;
            tileWidth =
              (int)
                dir.
                getFieldAsLong(
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                    TIFF_TILE_WIDTH);
            tileHeight =
              (int)
                dir.
                getFieldAsLong(
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                    TIFF_TILE_LENGTH);
            tileOffsets =
              dir.
                getField(
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                    TIFF_TILE_OFFSETS).
                getAsLongs(
                  );
            tileByteCounts =
              getFieldAsLongs(
                dir.
                  getField(
                    org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                      TIFF_TILE_BYTE_COUNTS));
        }
        else {
            tiled =
              false;
            tileWidth =
              dir.
                getField(
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                    TIFF_TILE_WIDTH) !=
                null
                ? (int)
                    dir.
                    getFieldAsLong(
                      org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                        TIFF_TILE_WIDTH)
                : bounds.
                    width;
            org.apache.batik.ext.awt.image.codec.tiff.TIFFField field =
              dir.
              getField(
                org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                  TIFF_ROWS_PER_STRIP);
            if (field ==
                  null) {
                tileHeight =
                  dir.
                    getField(
                      org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                        TIFF_TILE_LENGTH) !=
                    null
                    ? (int)
                        dir.
                        getFieldAsLong(
                          org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                            TIFF_TILE_LENGTH)
                    : bounds.
                        height;
            }
            else {
                long l =
                  field.
                  getAsLong(
                    0);
                long infinity =
                  1;
                infinity =
                  (infinity <<
                     32) -
                    1;
                if (l ==
                      infinity) {
                    tileHeight =
                      bounds.
                        height;
                }
                else {
                    tileHeight =
                      (int)
                        l;
                }
            }
            org.apache.batik.ext.awt.image.codec.tiff.TIFFField tileOffsetsField =
              dir.
              getField(
                org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                  TIFF_STRIP_OFFSETS);
            if (tileOffsetsField ==
                  null) {
                throw new java.lang.RuntimeException(
                  "TIFFImage5");
            }
            else {
                tileOffsets =
                  getFieldAsLongs(
                    tileOffsetsField);
            }
            org.apache.batik.ext.awt.image.codec.tiff.TIFFField tileByteCountsField =
              dir.
              getField(
                org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                  TIFF_STRIP_BYTE_COUNTS);
            if (tileByteCountsField ==
                  null) {
                throw new java.lang.RuntimeException(
                  "TIFFImage6");
            }
            else {
                tileByteCounts =
                  getFieldAsLongs(
                    tileByteCountsField);
            }
        }
        tilesX =
          (bounds.
             width +
             tileWidth -
             1) /
            tileWidth;
        tilesY =
          (bounds.
             height +
             tileHeight -
             1) /
            tileHeight;
        tileSize =
          tileWidth *
            tileHeight *
            numBands;
        isBigEndian =
          dir.
            isBigEndian(
              );
        org.apache.batik.ext.awt.image.codec.tiff.TIFFField fillOrderField =
          dir.
          getField(
            org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
              TIFF_FILL_ORDER);
        if (fillOrderField !=
              null) {
            fillOrder =
              fillOrderField.
                getAsInt(
                  0);
        }
        else {
            fillOrder =
              1;
        }
        switch (compression) {
            case COMP_NONE:
            case COMP_PACKBITS:
                break;
            case COMP_DEFLATE:
                inflater =
                  new java.util.zip.Inflater(
                    );
                break;
            case COMP_FAX_G3_1D:
            case COMP_FAX_G3_2D:
            case COMP_FAX_G4_2D:
                if (sampleSize !=
                      1) {
                    throw new java.lang.RuntimeException(
                      "TIFFImage7");
                }
                if (compression ==
                      3) {
                    org.apache.batik.ext.awt.image.codec.tiff.TIFFField t4OptionsField =
                      dir.
                      getField(
                        org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                          TIFF_T4_OPTIONS);
                    if (t4OptionsField !=
                          null) {
                        tiffT4Options =
                          t4OptionsField.
                            getAsLong(
                              0);
                    }
                    else {
                        tiffT4Options =
                          0;
                    }
                }
                if (compression ==
                      4) {
                    org.apache.batik.ext.awt.image.codec.tiff.TIFFField t6OptionsField =
                      dir.
                      getField(
                        org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                          TIFF_T6_OPTIONS);
                    if (t6OptionsField !=
                          null) {
                        tiffT6Options =
                          t6OptionsField.
                            getAsLong(
                              0);
                    }
                    else {
                        tiffT6Options =
                          0;
                    }
                }
                decoder =
                  new org.apache.batik.ext.awt.image.codec.tiff.TIFFFaxDecoder(
                    fillOrder,
                    tileWidth,
                    tileHeight);
                break;
            case COMP_LZW:
                org.apache.batik.ext.awt.image.codec.tiff.TIFFField predictorField =
                  dir.
                  getField(
                    org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                      TIFF_PREDICTOR);
                if (predictorField ==
                      null) {
                    predictor =
                      1;
                }
                else {
                    predictor =
                      predictorField.
                        getAsInt(
                          0);
                    if (predictor !=
                          1 &&
                          predictor !=
                          2) {
                        throw new java.lang.RuntimeException(
                          "TIFFImage8");
                    }
                    if (predictor ==
                          2 &&
                          sampleSize !=
                          8) {
                        throw new java.lang.RuntimeException(
                          sampleSize +
                          "TIFFImage9");
                    }
                }
                lzwDecoder =
                  new org.apache.batik.ext.awt.image.codec.tiff.TIFFLZWDecoder(
                    tileWidth,
                    predictor,
                    samplesPerPixel);
                break;
            case COMP_JPEG_OLD:
                throw new java.lang.RuntimeException(
                  "TIFFImage15");
            case COMP_JPEG_TTN2:
                if (!(sampleSize ==
                        8 &&
                        (imageType ==
                           TYPE_GRAY &&
                           samplesPerPixel ==
                           1 ||
                           imageType ==
                           TYPE_PALETTE &&
                           samplesPerPixel ==
                           1 ||
                           imageType ==
                           TYPE_RGB &&
                           samplesPerPixel ==
                           3))) {
                    throw new java.lang.RuntimeException(
                      "TIFFImage16");
                }
                if (dir.
                      isTagPresent(
                        TIFF_JPEG_TABLES)) {
                    org.apache.batik.ext.awt.image.codec.tiff.TIFFField jpegTableField =
                      dir.
                      getField(
                        TIFF_JPEG_TABLES);
                    byte[] jpegTable =
                      jpegTableField.
                      getAsBytes(
                        );
                    java.io.ByteArrayInputStream tableStream =
                      new java.io.ByteArrayInputStream(
                      jpegTable);
                    com.sun.image.codec.jpeg.JPEGImageDecoder decoder =
                      com.sun.image.codec.jpeg.JPEGCodec.
                      createJPEGDecoder(
                        tableStream);
                    decoder.
                      decodeAsRaster(
                        );
                    decodeParam =
                      decoder.
                        getJPEGDecodeParam(
                          );
                }
                break;
            default:
                throw new java.lang.RuntimeException(
                  "TIFFImage10");
        }
        java.awt.image.ColorModel colorModel =
          null;
        java.awt.image.SampleModel sampleModel =
          null;
        switch (imageType) {
            case TYPE_BILEVEL:
            case TYPE_GRAY_4BIT:
                sampleModel =
                  new java.awt.image.MultiPixelPackedSampleModel(
                    dataType,
                    tileWidth,
                    tileHeight,
                    sampleSize);
                if (imageType ==
                      TYPE_BILEVEL) {
                    byte[] map =
                      new byte[] { (byte)
                                     (isWhiteZero
                                        ? 255
                                        : 0),
                    (byte)
                      (isWhiteZero
                         ? 0
                         : 255) };
                    colorModel =
                      new java.awt.image.IndexColorModel(
                        1,
                        2,
                        map,
                        map,
                        map);
                }
                else {
                    byte[] map =
                      new byte[16];
                    if (isWhiteZero) {
                        for (int i =
                               0;
                             i <
                               map.
                                 length;
                             i++)
                            map[i] =
                              (byte)
                                (255 -
                                   16 *
                                   i);
                    }
                    else {
                        for (int i =
                               0;
                             i <
                               map.
                                 length;
                             i++)
                            map[i] =
                              (byte)
                                (16 *
                                   i);
                    }
                    colorModel =
                      new java.awt.image.IndexColorModel(
                        4,
                        16,
                        map,
                        map,
                        map);
                }
                break;
            case TYPE_GRAY:
            case TYPE_GRAY_ALPHA:
            case TYPE_RGB:
            case TYPE_RGB_ALPHA:
                int[] reverseOffsets =
                  new int[numBands];
                for (int i =
                       0;
                     i <
                       numBands;
                     i++) {
                    reverseOffsets[i] =
                      numBands -
                        1 -
                        i;
                }
                sampleModel =
                  new java.awt.image.PixelInterleavedSampleModel(
                    dataType,
                    tileWidth,
                    tileHeight,
                    numBands,
                    numBands *
                      tileWidth,
                    reverseOffsets);
                if (imageType ==
                      TYPE_GRAY) {
                    colorModel =
                      new java.awt.image.ComponentColorModel(
                        java.awt.color.ColorSpace.
                          getInstance(
                            java.awt.color.ColorSpace.
                              CS_GRAY),
                        new int[] { sampleSize },
                        false,
                        false,
                        java.awt.Transparency.
                          OPAQUE,
                        dataType);
                }
                else
                    if (imageType ==
                          TYPE_RGB) {
                        colorModel =
                          new java.awt.image.ComponentColorModel(
                            java.awt.color.ColorSpace.
                              getInstance(
                                java.awt.color.ColorSpace.
                                  CS_sRGB),
                            new int[] { sampleSize,
                            sampleSize,
                            sampleSize },
                            false,
                            false,
                            java.awt.Transparency.
                              OPAQUE,
                            dataType);
                    }
                    else {
                        int transparency =
                          java.awt.Transparency.
                            OPAQUE;
                        if (extraSamples ==
                              1) {
                            transparency =
                              java.awt.Transparency.
                                TRANSLUCENT;
                        }
                        else
                            if (extraSamples ==
                                  2) {
                                transparency =
                                  java.awt.Transparency.
                                    BITMASK;
                            }
                        colorModel =
                          createAlphaComponentColorModel(
                            dataType,
                            numBands,
                            extraSamples ==
                              1,
                            transparency);
                    }
                break;
            case TYPE_GENERIC:
            case TYPE_YCBCR_SUB:
                int[] bandOffsets =
                  new int[numBands];
                for (int i =
                       0;
                     i <
                       numBands;
                     i++) {
                    bandOffsets[i] =
                      i;
                }
                sampleModel =
                  new java.awt.image.PixelInterleavedSampleModel(
                    dataType,
                    tileWidth,
                    tileHeight,
                    numBands,
                    numBands *
                      tileWidth,
                    bandOffsets);
                colorModel =
                  null;
                break;
            case TYPE_PALETTE:
                org.apache.batik.ext.awt.image.codec.tiff.TIFFField cfield =
                  dir.
                  getField(
                    org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                      TIFF_COLORMAP);
                if (cfield ==
                      null) {
                    throw new java.lang.RuntimeException(
                      "TIFFImage11");
                }
                else {
                    colormap =
                      cfield.
                        getAsChars(
                          );
                }
                if (decodePaletteAsShorts) {
                    numBands =
                      3;
                    if (dataType ==
                          java.awt.image.DataBuffer.
                            TYPE_BYTE) {
                        dataType =
                          java.awt.image.DataBuffer.
                            TYPE_USHORT;
                    }
                    sampleModel =
                      createPixelInterleavedSampleModel(
                        dataType,
                        tileWidth,
                        tileHeight,
                        numBands);
                    colorModel =
                      new java.awt.image.ComponentColorModel(
                        java.awt.color.ColorSpace.
                          getInstance(
                            java.awt.color.ColorSpace.
                              CS_sRGB),
                        new int[] { 16,
                        16,
                        16 },
                        false,
                        false,
                        java.awt.Transparency.
                          OPAQUE,
                        dataType);
                }
                else {
                    numBands =
                      1;
                    if (sampleSize ==
                          4) {
                        sampleModel =
                          new java.awt.image.MultiPixelPackedSampleModel(
                            java.awt.image.DataBuffer.
                              TYPE_BYTE,
                            tileWidth,
                            tileHeight,
                            sampleSize);
                    }
                    else
                        if (sampleSize ==
                              8) {
                            sampleModel =
                              createPixelInterleavedSampleModel(
                                java.awt.image.DataBuffer.
                                  TYPE_BYTE,
                                tileWidth,
                                tileHeight,
                                numBands);
                        }
                        else
                            if (sampleSize ==
                                  16) {
                                dataType =
                                  java.awt.image.DataBuffer.
                                    TYPE_USHORT;
                                sampleModel =
                                  createPixelInterleavedSampleModel(
                                    java.awt.image.DataBuffer.
                                      TYPE_USHORT,
                                    tileWidth,
                                    tileHeight,
                                    numBands);
                            }
                    int bandLength =
                      colormap.
                        length /
                      3;
                    byte[] r =
                      new byte[bandLength];
                    byte[] g =
                      new byte[bandLength];
                    byte[] b =
                      new byte[bandLength];
                    int gIndex =
                      bandLength;
                    int bIndex =
                      bandLength *
                      2;
                    if (dataType ==
                          java.awt.image.DataBuffer.
                            TYPE_SHORT) {
                        for (int i =
                               0;
                             i <
                               bandLength;
                             i++) {
                            r[i] =
                              param.
                                decodeSigned16BitsTo8Bits(
                                  (short)
                                    colormap[i]);
                            g[i] =
                              param.
                                decodeSigned16BitsTo8Bits(
                                  (short)
                                    colormap[gIndex +
                                               i]);
                            b[i] =
                              param.
                                decodeSigned16BitsTo8Bits(
                                  (short)
                                    colormap[bIndex +
                                               i]);
                        }
                    }
                    else {
                        for (int i =
                               0;
                             i <
                               bandLength;
                             i++) {
                            r[i] =
                              param.
                                decode16BitsTo8Bits(
                                  colormap[i] &
                                    65535);
                            g[i] =
                              param.
                                decode16BitsTo8Bits(
                                  colormap[gIndex +
                                             i] &
                                    65535);
                            b[i] =
                              param.
                                decode16BitsTo8Bits(
                                  colormap[bIndex +
                                             i] &
                                    65535);
                        }
                    }
                    colorModel =
                      new java.awt.image.IndexColorModel(
                        sampleSize,
                        bandLength,
                        r,
                        g,
                        b);
                }
                break;
            default:
                throw new java.lang.RuntimeException(
                  "TIFFImage4");
        }
        java.util.Map properties =
          new java.util.HashMap(
          );
        properties.
          put(
            "tiff_directory",
            dir);
        init(
          (org.apache.batik.ext.awt.image.rendered.CachableRed)
            null,
          bounds,
          colorModel,
          sampleModel,
          0,
          0,
          properties);
    }
    public org.apache.batik.ext.awt.image.codec.tiff.TIFFDirectory getPrivateIFD(long offset)
          throws java.io.IOException { return new org.apache.batik.ext.awt.image.codec.tiff.TIFFDirectory(
                                         stream,
                                         offset,
                                         0);
    }
    public java.awt.image.WritableRaster copyData(java.awt.image.WritableRaster wr) {
        copyToRaster(
          wr);
        return wr;
    }
    public synchronized java.awt.image.Raster getTile(int tileX,
                                                      int tileY) {
        if (tileX <
              0 ||
              tileX >=
              tilesX ||
              tileY <
              0 ||
              tileY >=
              tilesY) {
            throw new java.lang.IllegalArgumentException(
              "TIFFImage12");
        }
        byte[] bdata =
          null;
        short[] sdata =
          null;
        int[] idata =
          null;
        java.awt.image.SampleModel sampleModel =
          getSampleModel(
            );
        java.awt.image.WritableRaster tile =
          makeTile(
            tileX,
            tileY);
        java.awt.image.DataBuffer buffer =
          tile.
          getDataBuffer(
            );
        int dataType =
          sampleModel.
          getDataType(
            );
        if (dataType ==
              java.awt.image.DataBuffer.
                TYPE_BYTE) {
            bdata =
              ((java.awt.image.DataBufferByte)
                 buffer).
                getData(
                  );
        }
        else
            if (dataType ==
                  java.awt.image.DataBuffer.
                    TYPE_USHORT) {
                sdata =
                  ((java.awt.image.DataBufferUShort)
                     buffer).
                    getData(
                      );
            }
            else
                if (dataType ==
                      java.awt.image.DataBuffer.
                        TYPE_SHORT) {
                    sdata =
                      ((java.awt.image.DataBufferShort)
                         buffer).
                        getData(
                          );
                }
                else
                    if (dataType ==
                          java.awt.image.DataBuffer.
                            TYPE_INT) {
                        idata =
                          ((java.awt.image.DataBufferInt)
                             buffer).
                            getData(
                              );
                    }
        byte bswap;
        short sswap;
        int iswap;
        long save_offset =
          0;
        try {
            save_offset =
              stream.
                getFilePointer(
                  );
            stream.
              seek(
                tileOffsets[tileY *
                              tilesX +
                              tileX]);
        }
        catch (java.io.IOException ioe) {
            throw new java.lang.RuntimeException(
              "TIFFImage13");
        }
        int byteCount =
          (int)
            tileByteCounts[tileY *
                             tilesX +
                             tileX];
        java.awt.Rectangle newRect;
        if (!tiled)
            newRect =
              tile.
                getBounds(
                  );
        else
            newRect =
              new java.awt.Rectangle(
                tile.
                  getMinX(
                    ),
                tile.
                  getMinY(
                    ),
                tileWidth,
                tileHeight);
        int unitsInThisTile =
          newRect.
            width *
          newRect.
            height *
          numBands;
        byte[] data =
          compression !=
          COMP_NONE ||
          imageType ==
          TYPE_PALETTE
          ? (new byte[byteCount])
          : null;
        if (imageType ==
              TYPE_BILEVEL) {
            try {
                if (compression ==
                      COMP_PACKBITS) {
                    stream.
                      readFully(
                        data,
                        0,
                        byteCount);
                    int bytesInThisTile;
                    if (newRect.
                          width %
                          8 ==
                          0) {
                        bytesInThisTile =
                          newRect.
                            width /
                            8 *
                            newRect.
                              height;
                    }
                    else {
                        bytesInThisTile =
                          (newRect.
                             width /
                             8 +
                             1) *
                            newRect.
                              height;
                    }
                    decodePackbits(
                      data,
                      bytesInThisTile,
                      bdata);
                }
                else
                    if (compression ==
                          COMP_LZW) {
                        stream.
                          readFully(
                            data,
                            0,
                            byteCount);
                        lzwDecoder.
                          decode(
                            data,
                            bdata,
                            newRect.
                              height);
                    }
                    else
                        if (compression ==
                              COMP_FAX_G3_1D) {
                            stream.
                              readFully(
                                data,
                                0,
                                byteCount);
                            decoder.
                              decode1D(
                                bdata,
                                data,
                                0,
                                newRect.
                                  height);
                        }
                        else
                            if (compression ==
                                  COMP_FAX_G3_2D) {
                                stream.
                                  readFully(
                                    data,
                                    0,
                                    byteCount);
                                decoder.
                                  decode2D(
                                    bdata,
                                    data,
                                    0,
                                    newRect.
                                      height,
                                    tiffT4Options);
                            }
                            else
                                if (compression ==
                                      COMP_FAX_G4_2D) {
                                    stream.
                                      readFully(
                                        data,
                                        0,
                                        byteCount);
                                    decoder.
                                      decodeT6(
                                        bdata,
                                        data,
                                        0,
                                        newRect.
                                          height,
                                        tiffT6Options);
                                }
                                else
                                    if (compression ==
                                          COMP_DEFLATE) {
                                        stream.
                                          readFully(
                                            data,
                                            0,
                                            byteCount);
                                        inflate(
                                          data,
                                          bdata);
                                    }
                                    else
                                        if (compression ==
                                              COMP_NONE) {
                                            stream.
                                              readFully(
                                                bdata,
                                                0,
                                                byteCount);
                                        }
                stream.
                  seek(
                    save_offset);
            }
            catch (java.io.IOException ioe) {
                throw new java.lang.RuntimeException(
                  "TIFFImage13");
            }
        }
        else
            if (imageType ==
                  TYPE_PALETTE) {
                if (sampleSize ==
                      16) {
                    if (decodePaletteAsShorts) {
                        short[] tempData =
                          null;
                        int unitsBeforeLookup =
                          unitsInThisTile /
                          3;
                        int entries =
                          unitsBeforeLookup *
                          2;
                        try {
                            if (compression ==
                                  COMP_PACKBITS) {
                                stream.
                                  readFully(
                                    data,
                                    0,
                                    byteCount);
                                byte[] byteArray =
                                  new byte[entries];
                                decodePackbits(
                                  data,
                                  entries,
                                  byteArray);
                                tempData =
                                  (new short[unitsBeforeLookup]);
                                interpretBytesAsShorts(
                                  byteArray,
                                  tempData,
                                  unitsBeforeLookup);
                            }
                            else
                                if (compression ==
                                      COMP_LZW) {
                                    stream.
                                      readFully(
                                        data,
                                        0,
                                        byteCount);
                                    byte[] byteArray =
                                      new byte[entries];
                                    lzwDecoder.
                                      decode(
                                        data,
                                        byteArray,
                                        newRect.
                                          height);
                                    tempData =
                                      (new short[unitsBeforeLookup]);
                                    interpretBytesAsShorts(
                                      byteArray,
                                      tempData,
                                      unitsBeforeLookup);
                                }
                                else
                                    if (compression ==
                                          COMP_DEFLATE) {
                                        stream.
                                          readFully(
                                            data,
                                            0,
                                            byteCount);
                                        byte[] byteArray =
                                          new byte[entries];
                                        inflate(
                                          data,
                                          byteArray);
                                        tempData =
                                          (new short[unitsBeforeLookup]);
                                        interpretBytesAsShorts(
                                          byteArray,
                                          tempData,
                                          unitsBeforeLookup);
                                    }
                                    else
                                        if (compression ==
                                              COMP_NONE) {
                                            tempData =
                                              (new short[byteCount /
                                                           2]);
                                            readShorts(
                                              byteCount /
                                                2,
                                              tempData);
                                        }
                            stream.
                              seek(
                                save_offset);
                        }
                        catch (java.io.IOException ioe) {
                            throw new java.lang.RuntimeException(
                              "TIFFImage13");
                        }
                        if (dataType ==
                              java.awt.image.DataBuffer.
                                TYPE_USHORT) {
                            int cmapValue;
                            int count =
                              0;
                            int lookup;
                            int len =
                              colormap.
                                length /
                              3;
                            int len2 =
                              len *
                              2;
                            for (int i =
                                   0;
                                 i <
                                   unitsBeforeLookup;
                                 i++) {
                                lookup =
                                  tempData[i] &
                                    65535;
                                cmapValue =
                                  colormap[lookup +
                                             len2];
                                sdata[count++] =
                                  (short)
                                    (cmapValue &
                                       65535);
                                cmapValue =
                                  colormap[lookup +
                                             len];
                                sdata[count++] =
                                  (short)
                                    (cmapValue &
                                       65535);
                                cmapValue =
                                  colormap[lookup];
                                sdata[count++] =
                                  (short)
                                    (cmapValue &
                                       65535);
                            }
                        }
                        else
                            if (dataType ==
                                  java.awt.image.DataBuffer.
                                    TYPE_SHORT) {
                                int cmapValue;
                                int count =
                                  0;
                                int lookup;
                                int len =
                                  colormap.
                                    length /
                                  3;
                                int len2 =
                                  len *
                                  2;
                                for (int i =
                                       0;
                                     i <
                                       unitsBeforeLookup;
                                     i++) {
                                    lookup =
                                      tempData[i] &
                                        65535;
                                    cmapValue =
                                      colormap[lookup +
                                                 len2];
                                    sdata[count++] =
                                      (short)
                                        cmapValue;
                                    cmapValue =
                                      colormap[lookup +
                                                 len];
                                    sdata[count++] =
                                      (short)
                                        cmapValue;
                                    cmapValue =
                                      colormap[lookup];
                                    sdata[count++] =
                                      (short)
                                        cmapValue;
                                }
                            }
                    }
                    else {
                        try {
                            if (compression ==
                                  COMP_PACKBITS) {
                                stream.
                                  readFully(
                                    data,
                                    0,
                                    byteCount);
                                int bytesInThisTile =
                                  unitsInThisTile *
                                  2;
                                byte[] byteArray =
                                  new byte[bytesInThisTile];
                                decodePackbits(
                                  data,
                                  bytesInThisTile,
                                  byteArray);
                                interpretBytesAsShorts(
                                  byteArray,
                                  sdata,
                                  unitsInThisTile);
                            }
                            else
                                if (compression ==
                                      COMP_LZW) {
                                    stream.
                                      readFully(
                                        data,
                                        0,
                                        byteCount);
                                    byte[] byteArray =
                                      new byte[unitsInThisTile *
                                                 2];
                                    lzwDecoder.
                                      decode(
                                        data,
                                        byteArray,
                                        newRect.
                                          height);
                                    interpretBytesAsShorts(
                                      byteArray,
                                      sdata,
                                      unitsInThisTile);
                                }
                                else
                                    if (compression ==
                                          COMP_DEFLATE) {
                                        stream.
                                          readFully(
                                            data,
                                            0,
                                            byteCount);
                                        byte[] byteArray =
                                          new byte[unitsInThisTile *
                                                     2];
                                        inflate(
                                          data,
                                          byteArray);
                                        interpretBytesAsShorts(
                                          byteArray,
                                          sdata,
                                          unitsInThisTile);
                                    }
                                    else
                                        if (compression ==
                                              COMP_NONE) {
                                            readShorts(
                                              byteCount /
                                                2,
                                              sdata);
                                        }
                            stream.
                              seek(
                                save_offset);
                        }
                        catch (java.io.IOException ioe) {
                            throw new java.lang.RuntimeException(
                              "TIFFImage13");
                        }
                    }
                }
                else
                    if (sampleSize ==
                          8) {
                        if (decodePaletteAsShorts) {
                            byte[] tempData =
                              null;
                            int unitsBeforeLookup =
                              unitsInThisTile /
                              3;
                            try {
                                if (compression ==
                                      COMP_PACKBITS) {
                                    stream.
                                      readFully(
                                        data,
                                        0,
                                        byteCount);
                                    tempData =
                                      (new byte[unitsBeforeLookup]);
                                    decodePackbits(
                                      data,
                                      unitsBeforeLookup,
                                      tempData);
                                }
                                else
                                    if (compression ==
                                          COMP_LZW) {
                                        stream.
                                          readFully(
                                            data,
                                            0,
                                            byteCount);
                                        tempData =
                                          (new byte[unitsBeforeLookup]);
                                        lzwDecoder.
                                          decode(
                                            data,
                                            tempData,
                                            newRect.
                                              height);
                                    }
                                    else
                                        if (compression ==
                                              COMP_JPEG_TTN2) {
                                            stream.
                                              readFully(
                                                data,
                                                0,
                                                byteCount);
                                            java.awt.image.Raster tempTile =
                                              decodeJPEG(
                                                data,
                                                decodeParam,
                                                colorConvertJPEG,
                                                tile.
                                                  getMinX(
                                                    ),
                                                tile.
                                                  getMinY(
                                                    ));
                                            int[] tempPixels =
                                              new int[unitsBeforeLookup];
                                            tempTile.
                                              getPixels(
                                                tile.
                                                  getMinX(
                                                    ),
                                                tile.
                                                  getMinY(
                                                    ),
                                                tile.
                                                  getWidth(
                                                    ),
                                                tile.
                                                  getHeight(
                                                    ),
                                                tempPixels);
                                            tempData =
                                              (new byte[unitsBeforeLookup]);
                                            for (int i =
                                                   0;
                                                 i <
                                                   unitsBeforeLookup;
                                                 i++) {
                                                tempData[i] =
                                                  (byte)
                                                    tempPixels[i];
                                            }
                                        }
                                        else
                                            if (compression ==
                                                  COMP_DEFLATE) {
                                                stream.
                                                  readFully(
                                                    data,
                                                    0,
                                                    byteCount);
                                                tempData =
                                                  (new byte[unitsBeforeLookup]);
                                                inflate(
                                                  data,
                                                  tempData);
                                            }
                                            else
                                                if (compression ==
                                                      COMP_NONE) {
                                                    tempData =
                                                      (new byte[byteCount]);
                                                    stream.
                                                      readFully(
                                                        tempData,
                                                        0,
                                                        byteCount);
                                                }
                                stream.
                                  seek(
                                    save_offset);
                            }
                            catch (java.io.IOException ioe) {
                                throw new java.lang.RuntimeException(
                                  "TIFFImage13");
                            }
                            int cmapValue;
                            int count =
                              0;
                            int lookup;
                            int len =
                              colormap.
                                length /
                              3;
                            int len2 =
                              len *
                              2;
                            for (int i =
                                   0;
                                 i <
                                   unitsBeforeLookup;
                                 i++) {
                                lookup =
                                  tempData[i] &
                                    255;
                                cmapValue =
                                  colormap[lookup +
                                             len2];
                                sdata[count++] =
                                  (short)
                                    (cmapValue &
                                       65535);
                                cmapValue =
                                  colormap[lookup +
                                             len];
                                sdata[count++] =
                                  (short)
                                    (cmapValue &
                                       65535);
                                cmapValue =
                                  colormap[lookup];
                                sdata[count++] =
                                  (short)
                                    (cmapValue &
                                       65535);
                            }
                        }
                        else {
                            try {
                                if (compression ==
                                      COMP_PACKBITS) {
                                    stream.
                                      readFully(
                                        data,
                                        0,
                                        byteCount);
                                    decodePackbits(
                                      data,
                                      unitsInThisTile,
                                      bdata);
                                }
                                else
                                    if (compression ==
                                          COMP_LZW) {
                                        stream.
                                          readFully(
                                            data,
                                            0,
                                            byteCount);
                                        lzwDecoder.
                                          decode(
                                            data,
                                            bdata,
                                            newRect.
                                              height);
                                    }
                                    else
                                        if (compression ==
                                              COMP_JPEG_TTN2) {
                                            stream.
                                              readFully(
                                                data,
                                                0,
                                                byteCount);
                                            tile.
                                              setRect(
                                                decodeJPEG(
                                                  data,
                                                  decodeParam,
                                                  colorConvertJPEG,
                                                  tile.
                                                    getMinX(
                                                      ),
                                                  tile.
                                                    getMinY(
                                                      )));
                                        }
                                        else
                                            if (compression ==
                                                  COMP_DEFLATE) {
                                                stream.
                                                  readFully(
                                                    data,
                                                    0,
                                                    byteCount);
                                                inflate(
                                                  data,
                                                  bdata);
                                            }
                                            else
                                                if (compression ==
                                                      COMP_NONE) {
                                                    stream.
                                                      readFully(
                                                        bdata,
                                                        0,
                                                        byteCount);
                                                }
                                stream.
                                  seek(
                                    save_offset);
                            }
                            catch (java.io.IOException ioe) {
                                throw new java.lang.RuntimeException(
                                  "TIFFImage13");
                            }
                        }
                    }
                    else
                        if (sampleSize ==
                              4) {
                            int padding =
                              newRect.
                                width %
                              2 ==
                              0
                              ? 0
                              : 1;
                            int bytesPostDecoding =
                              (newRect.
                                 width /
                                 2 +
                                 padding) *
                              newRect.
                                height;
                            if (decodePaletteAsShorts) {
                                byte[] tempData =
                                  null;
                                try {
                                    stream.
                                      readFully(
                                        data,
                                        0,
                                        byteCount);
                                    stream.
                                      seek(
                                        save_offset);
                                }
                                catch (java.io.IOException ioe) {
                                    throw new java.lang.RuntimeException(
                                      "TIFFImage13");
                                }
                                if (compression ==
                                      COMP_PACKBITS) {
                                    tempData =
                                      (new byte[bytesPostDecoding]);
                                    decodePackbits(
                                      data,
                                      bytesPostDecoding,
                                      tempData);
                                }
                                else
                                    if (compression ==
                                          COMP_LZW) {
                                        tempData =
                                          (new byte[bytesPostDecoding]);
                                        lzwDecoder.
                                          decode(
                                            data,
                                            tempData,
                                            newRect.
                                              height);
                                    }
                                    else
                                        if (compression ==
                                              COMP_DEFLATE) {
                                            tempData =
                                              (new byte[bytesPostDecoding]);
                                            inflate(
                                              data,
                                              tempData);
                                        }
                                        else
                                            if (compression ==
                                                  COMP_NONE) {
                                                tempData =
                                                  data;
                                            }
                                int bytes =
                                  unitsInThisTile /
                                  3;
                                data =
                                  (new byte[bytes]);
                                int srcCount =
                                  0;
                                int dstCount =
                                  0;
                                for (int j =
                                       0;
                                     j <
                                       newRect.
                                         height;
                                     j++) {
                                    for (int i =
                                           0;
                                         i <
                                           newRect.
                                             width /
                                           2;
                                         i++) {
                                        data[dstCount++] =
                                          (byte)
                                            ((tempData[srcCount] &
                                                240) >>
                                               4);
                                        data[dstCount++] =
                                          (byte)
                                            (tempData[srcCount++] &
                                               15);
                                    }
                                    if (padding ==
                                          1) {
                                        data[dstCount++] =
                                          (byte)
                                            ((tempData[srcCount++] &
                                                240) >>
                                               4);
                                    }
                                }
                                int len =
                                  colormap.
                                    length /
                                  3;
                                int len2 =
                                  len *
                                  2;
                                int cmapValue;
                                int lookup;
                                int count =
                                  0;
                                for (int i =
                                       0;
                                     i <
                                       bytes;
                                     i++) {
                                    lookup =
                                      data[i] &
                                        255;
                                    cmapValue =
                                      colormap[lookup +
                                                 len2];
                                    sdata[count++] =
                                      (short)
                                        (cmapValue &
                                           65535);
                                    cmapValue =
                                      colormap[lookup +
                                                 len];
                                    sdata[count++] =
                                      (short)
                                        (cmapValue &
                                           65535);
                                    cmapValue =
                                      colormap[lookup];
                                    sdata[count++] =
                                      (short)
                                        (cmapValue &
                                           65535);
                                }
                            }
                            else {
                                try {
                                    if (compression ==
                                          COMP_PACKBITS) {
                                        stream.
                                          readFully(
                                            data,
                                            0,
                                            byteCount);
                                        decodePackbits(
                                          data,
                                          bytesPostDecoding,
                                          bdata);
                                    }
                                    else
                                        if (compression ==
                                              COMP_LZW) {
                                            stream.
                                              readFully(
                                                data,
                                                0,
                                                byteCount);
                                            lzwDecoder.
                                              decode(
                                                data,
                                                bdata,
                                                newRect.
                                                  height);
                                        }
                                        else
                                            if (compression ==
                                                  COMP_DEFLATE) {
                                                stream.
                                                  readFully(
                                                    data,
                                                    0,
                                                    byteCount);
                                                inflate(
                                                  data,
                                                  bdata);
                                            }
                                            else
                                                if (compression ==
                                                      COMP_NONE) {
                                                    stream.
                                                      readFully(
                                                        bdata,
                                                        0,
                                                        byteCount);
                                                }
                                    stream.
                                      seek(
                                        save_offset);
                                }
                                catch (java.io.IOException ioe) {
                                    throw new java.lang.RuntimeException(
                                      "TIFFImage13");
                                }
                            }
                        }
            }
            else
                if (imageType ==
                      TYPE_GRAY_4BIT) {
                    try {
                        if (compression ==
                              COMP_PACKBITS) {
                            stream.
                              readFully(
                                data,
                                0,
                                byteCount);
                            int bytesInThisTile;
                            if (newRect.
                                  width %
                                  8 ==
                                  0) {
                                bytesInThisTile =
                                  newRect.
                                    width /
                                    2 *
                                    newRect.
                                      height;
                            }
                            else {
                                bytesInThisTile =
                                  (newRect.
                                     width /
                                     2 +
                                     1) *
                                    newRect.
                                      height;
                            }
                            decodePackbits(
                              data,
                              bytesInThisTile,
                              bdata);
                        }
                        else
                            if (compression ==
                                  COMP_LZW) {
                                stream.
                                  readFully(
                                    data,
                                    0,
                                    byteCount);
                                lzwDecoder.
                                  decode(
                                    data,
                                    bdata,
                                    newRect.
                                      height);
                            }
                            else
                                if (compression ==
                                      COMP_DEFLATE) {
                                    stream.
                                      readFully(
                                        data,
                                        0,
                                        byteCount);
                                    inflate(
                                      data,
                                      bdata);
                                }
                                else {
                                    stream.
                                      readFully(
                                        bdata,
                                        0,
                                        byteCount);
                                }
                        stream.
                          seek(
                            save_offset);
                    }
                    catch (java.io.IOException ioe) {
                        throw new java.lang.RuntimeException(
                          "TIFFImage13");
                    }
                }
                else {
                    try {
                        if (sampleSize ==
                              8) {
                            if (compression ==
                                  COMP_NONE) {
                                stream.
                                  readFully(
                                    bdata,
                                    0,
                                    byteCount);
                            }
                            else
                                if (compression ==
                                      COMP_LZW) {
                                    stream.
                                      readFully(
                                        data,
                                        0,
                                        byteCount);
                                    lzwDecoder.
                                      decode(
                                        data,
                                        bdata,
                                        newRect.
                                          height);
                                }
                                else
                                    if (compression ==
                                          COMP_PACKBITS) {
                                        stream.
                                          readFully(
                                            data,
                                            0,
                                            byteCount);
                                        decodePackbits(
                                          data,
                                          unitsInThisTile,
                                          bdata);
                                    }
                                    else
                                        if (compression ==
                                              COMP_JPEG_TTN2) {
                                            stream.
                                              readFully(
                                                data,
                                                0,
                                                byteCount);
                                            tile.
                                              setRect(
                                                decodeJPEG(
                                                  data,
                                                  decodeParam,
                                                  colorConvertJPEG,
                                                  tile.
                                                    getMinX(
                                                      ),
                                                  tile.
                                                    getMinY(
                                                      )));
                                        }
                                        else
                                            if (compression ==
                                                  COMP_DEFLATE) {
                                                stream.
                                                  readFully(
                                                    data,
                                                    0,
                                                    byteCount);
                                                inflate(
                                                  data,
                                                  bdata);
                                            }
                        }
                        else
                            if (sampleSize ==
                                  16) {
                                if (compression ==
                                      COMP_NONE) {
                                    readShorts(
                                      byteCount /
                                        2,
                                      sdata);
                                }
                                else
                                    if (compression ==
                                          COMP_LZW) {
                                        stream.
                                          readFully(
                                            data,
                                            0,
                                            byteCount);
                                        byte[] byteArray =
                                          new byte[unitsInThisTile *
                                                     2];
                                        lzwDecoder.
                                          decode(
                                            data,
                                            byteArray,
                                            newRect.
                                              height);
                                        interpretBytesAsShorts(
                                          byteArray,
                                          sdata,
                                          unitsInThisTile);
                                    }
                                    else
                                        if (compression ==
                                              COMP_PACKBITS) {
                                            stream.
                                              readFully(
                                                data,
                                                0,
                                                byteCount);
                                            int bytesInThisTile =
                                              unitsInThisTile *
                                              2;
                                            byte[] byteArray =
                                              new byte[bytesInThisTile];
                                            decodePackbits(
                                              data,
                                              bytesInThisTile,
                                              byteArray);
                                            interpretBytesAsShorts(
                                              byteArray,
                                              sdata,
                                              unitsInThisTile);
                                        }
                                        else
                                            if (compression ==
                                                  COMP_DEFLATE) {
                                                stream.
                                                  readFully(
                                                    data,
                                                    0,
                                                    byteCount);
                                                byte[] byteArray =
                                                  new byte[unitsInThisTile *
                                                             2];
                                                inflate(
                                                  data,
                                                  byteArray);
                                                interpretBytesAsShorts(
                                                  byteArray,
                                                  sdata,
                                                  unitsInThisTile);
                                            }
                            }
                            else
                                if (sampleSize ==
                                      32 &&
                                      dataType ==
                                      java.awt.image.DataBuffer.
                                        TYPE_INT) {
                                    if (compression ==
                                          COMP_NONE) {
                                        readInts(
                                          byteCount /
                                            4,
                                          idata);
                                    }
                                    else
                                        if (compression ==
                                              COMP_LZW) {
                                            stream.
                                              readFully(
                                                data,
                                                0,
                                                byteCount);
                                            byte[] byteArray =
                                              new byte[unitsInThisTile *
                                                         4];
                                            lzwDecoder.
                                              decode(
                                                data,
                                                byteArray,
                                                newRect.
                                                  height);
                                            interpretBytesAsInts(
                                              byteArray,
                                              idata,
                                              unitsInThisTile);
                                        }
                                        else
                                            if (compression ==
                                                  COMP_PACKBITS) {
                                                stream.
                                                  readFully(
                                                    data,
                                                    0,
                                                    byteCount);
                                                int bytesInThisTile =
                                                  unitsInThisTile *
                                                  4;
                                                byte[] byteArray =
                                                  new byte[bytesInThisTile];
                                                decodePackbits(
                                                  data,
                                                  bytesInThisTile,
                                                  byteArray);
                                                interpretBytesAsInts(
                                                  byteArray,
                                                  idata,
                                                  unitsInThisTile);
                                            }
                                            else
                                                if (compression ==
                                                      COMP_DEFLATE) {
                                                    stream.
                                                      readFully(
                                                        data,
                                                        0,
                                                        byteCount);
                                                    byte[] byteArray =
                                                      new byte[unitsInThisTile *
                                                                 4];
                                                    inflate(
                                                      data,
                                                      byteArray);
                                                    interpretBytesAsInts(
                                                      byteArray,
                                                      idata,
                                                      unitsInThisTile);
                                                }
                                }
                        stream.
                          seek(
                            save_offset);
                    }
                    catch (java.io.IOException ioe) {
                        throw new java.lang.RuntimeException(
                          "TIFFImage13");
                    }
                    switch (imageType) {
                        case TYPE_GRAY:
                        case TYPE_GRAY_ALPHA:
                            if (isWhiteZero) {
                                if (dataType ==
                                      java.awt.image.DataBuffer.
                                        TYPE_BYTE &&
                                      !(getColorModel(
                                          ) instanceof java.awt.image.IndexColorModel)) {
                                    for (int l =
                                           0;
                                         l <
                                           bdata.
                                             length;
                                         l +=
                                           numBands) {
                                        bdata[l] =
                                          (byte)
                                            (255 -
                                               bdata[l]);
                                    }
                                }
                                else
                                    if (dataType ==
                                          java.awt.image.DataBuffer.
                                            TYPE_USHORT) {
                                        int ushortMax =
                                          java.lang.Short.
                                            MAX_VALUE -
                                          java.lang.Short.
                                            MIN_VALUE;
                                        for (int l =
                                               0;
                                             l <
                                               sdata.
                                                 length;
                                             l +=
                                               numBands) {
                                            sdata[l] =
                                              (short)
                                                (ushortMax -
                                                   sdata[l]);
                                        }
                                    }
                                    else
                                        if (dataType ==
                                              java.awt.image.DataBuffer.
                                                TYPE_SHORT) {
                                            for (int l =
                                                   0;
                                                 l <
                                                   sdata.
                                                     length;
                                                 l +=
                                                   numBands) {
                                                sdata[l] =
                                                  (short)
                                                    ~sdata[l];
                                            }
                                        }
                                        else
                                            if (dataType ==
                                                  java.awt.image.DataBuffer.
                                                    TYPE_INT) {
                                                long uintMax =
                                                  (long)
                                                    java.lang.Integer.
                                                      MAX_VALUE -
                                                  (long)
                                                    java.lang.Integer.
                                                      MIN_VALUE;
                                                for (int l =
                                                       0;
                                                     l <
                                                       idata.
                                                         length;
                                                     l +=
                                                       numBands) {
                                                    idata[l] =
                                                      (int)
                                                        (uintMax -
                                                           idata[l]);
                                                }
                                            }
                            }
                            break;
                        case TYPE_RGB:
                            if (sampleSize ==
                                  8 &&
                                  compression !=
                                  COMP_JPEG_TTN2) {
                                for (int i =
                                       0;
                                     i <
                                       unitsInThisTile;
                                     i +=
                                       3) {
                                    bswap =
                                      bdata[i];
                                    bdata[i] =
                                      bdata[i +
                                              2];
                                    bdata[i +
                                            2] =
                                      bswap;
                                }
                            }
                            else
                                if (sampleSize ==
                                      16) {
                                    for (int i =
                                           0;
                                         i <
                                           unitsInThisTile;
                                         i +=
                                           3) {
                                        sswap =
                                          sdata[i];
                                        sdata[i] =
                                          sdata[i +
                                                  2];
                                        sdata[i +
                                                2] =
                                          sswap;
                                    }
                                }
                                else
                                    if (sampleSize ==
                                          32) {
                                        if (dataType ==
                                              java.awt.image.DataBuffer.
                                                TYPE_INT) {
                                            for (int i =
                                                   0;
                                                 i <
                                                   unitsInThisTile;
                                                 i +=
                                                   3) {
                                                iswap =
                                                  idata[i];
                                                idata[i] =
                                                  idata[i +
                                                          2];
                                                idata[i +
                                                        2] =
                                                  iswap;
                                            }
                                        }
                                    }
                            break;
                        case TYPE_RGB_ALPHA:
                            if (sampleSize ==
                                  8) {
                                for (int i =
                                       0;
                                     i <
                                       unitsInThisTile;
                                     i +=
                                       4) {
                                    bswap =
                                      bdata[i];
                                    bdata[i] =
                                      bdata[i +
                                              3];
                                    bdata[i +
                                            3] =
                                      bswap;
                                    bswap =
                                      bdata[i +
                                              1];
                                    bdata[i +
                                            1] =
                                      bdata[i +
                                              2];
                                    bdata[i +
                                            2] =
                                      bswap;
                                }
                            }
                            else
                                if (sampleSize ==
                                      16) {
                                    for (int i =
                                           0;
                                         i <
                                           unitsInThisTile;
                                         i +=
                                           4) {
                                        sswap =
                                          sdata[i];
                                        sdata[i] =
                                          sdata[i +
                                                  3];
                                        sdata[i +
                                                3] =
                                          sswap;
                                        sswap =
                                          sdata[i +
                                                  1];
                                        sdata[i +
                                                1] =
                                          sdata[i +
                                                  2];
                                        sdata[i +
                                                2] =
                                          sswap;
                                    }
                                }
                                else
                                    if (sampleSize ==
                                          32) {
                                        if (dataType ==
                                              java.awt.image.DataBuffer.
                                                TYPE_INT) {
                                            for (int i =
                                                   0;
                                                 i <
                                                   unitsInThisTile;
                                                 i +=
                                                   4) {
                                                iswap =
                                                  idata[i];
                                                idata[i] =
                                                  idata[i +
                                                          3];
                                                idata[i +
                                                        3] =
                                                  iswap;
                                                iswap =
                                                  idata[i +
                                                          1];
                                                idata[i +
                                                        1] =
                                                  idata[i +
                                                          2];
                                                idata[i +
                                                        2] =
                                                  iswap;
                                            }
                                        }
                                    }
                            break;
                        case TYPE_YCBCR_SUB:
                            int pixelsPerDataUnit =
                              chromaSubH *
                              chromaSubV;
                            int numH =
                              newRect.
                                width /
                              chromaSubH;
                            int numV =
                              newRect.
                                height /
                              chromaSubV;
                            byte[] tempData =
                              new byte[numH *
                                         numV *
                                         (pixelsPerDataUnit +
                                            2)];
                            java.lang.System.
                              arraycopy(
                                bdata,
                                0,
                                tempData,
                                0,
                                tempData.
                                  length);
                            int samplesPerDataUnit =
                              pixelsPerDataUnit *
                              3;
                            int[] pixels =
                              new int[samplesPerDataUnit];
                            int bOffset =
                              0;
                            int offsetCb =
                              pixelsPerDataUnit;
                            int offsetCr =
                              offsetCb +
                              1;
                            int y =
                              newRect.
                                y;
                            for (int j =
                                   0;
                                 j <
                                   numV;
                                 j++) {
                                int x =
                                  newRect.
                                    x;
                                for (int i =
                                       0;
                                     i <
                                       numH;
                                     i++) {
                                    int Cb =
                                      tempData[bOffset +
                                                 offsetCb];
                                    int Cr =
                                      tempData[bOffset +
                                                 offsetCr];
                                    int k =
                                      0;
                                    while (k <
                                             samplesPerDataUnit) {
                                        pixels[k++] =
                                          tempData[bOffset++];
                                        pixels[k++] =
                                          Cb;
                                        pixels[k++] =
                                          Cr;
                                    }
                                    bOffset +=
                                      2;
                                    tile.
                                      setPixels(
                                        x,
                                        y,
                                        chromaSubH,
                                        chromaSubV,
                                        pixels);
                                    x +=
                                      chromaSubH;
                                }
                                y +=
                                  chromaSubV;
                            }
                            break;
                    }
                }
        return tile;
    }
    private void readShorts(int shortCount,
                            short[] shortArray) {
        int byteCount =
          2 *
          shortCount;
        byte[] byteArray =
          new byte[byteCount];
        try {
            stream.
              readFully(
                byteArray,
                0,
                byteCount);
        }
        catch (java.io.IOException ioe) {
            throw new java.lang.RuntimeException(
              "TIFFImage13");
        }
        interpretBytesAsShorts(
          byteArray,
          shortArray,
          shortCount);
    }
    private void readInts(int intCount, int[] intArray) {
        int byteCount =
          4 *
          intCount;
        byte[] byteArray =
          new byte[byteCount];
        try {
            stream.
              readFully(
                byteArray,
                0,
                byteCount);
        }
        catch (java.io.IOException ioe) {
            throw new java.lang.RuntimeException(
              "TIFFImage13");
        }
        interpretBytesAsInts(
          byteArray,
          intArray,
          intCount);
    }
    private void interpretBytesAsShorts(byte[] byteArray,
                                        short[] shortArray,
                                        int shortCount) {
        int j =
          0;
        int firstByte;
        int secondByte;
        if (isBigEndian) {
            for (int i =
                   0;
                 i <
                   shortCount;
                 i++) {
                firstByte =
                  byteArray[j++] &
                    255;
                secondByte =
                  byteArray[j++] &
                    255;
                shortArray[i] =
                  (short)
                    ((firstByte <<
                        8) +
                       secondByte);
            }
        }
        else {
            for (int i =
                   0;
                 i <
                   shortCount;
                 i++) {
                firstByte =
                  byteArray[j++] &
                    255;
                secondByte =
                  byteArray[j++] &
                    255;
                shortArray[i] =
                  (short)
                    ((secondByte <<
                        8) +
                       firstByte);
            }
        }
    }
    private void interpretBytesAsInts(byte[] byteArray,
                                      int[] intArray,
                                      int intCount) {
        int j =
          0;
        if (isBigEndian) {
            for (int i =
                   0;
                 i <
                   intCount;
                 i++) {
                intArray[i] =
                  (byteArray[j++] &
                     255) <<
                    24 |
                    (byteArray[j++] &
                       255) <<
                    16 |
                    (byteArray[j++] &
                       255) <<
                    8 |
                    byteArray[j++] &
                    255;
            }
        }
        else {
            for (int i =
                   0;
                 i <
                   intCount;
                 i++) {
                intArray[i] =
                  byteArray[j++] &
                    255 |
                    (byteArray[j++] &
                       255) <<
                    8 |
                    (byteArray[j++] &
                       255) <<
                    16 |
                    (byteArray[j++] &
                       255) <<
                    24;
            }
        }
    }
    private byte[] decodePackbits(byte[] data,
                                  int arraySize,
                                  byte[] dst) {
        if (dst ==
              null) {
            dst =
              (new byte[arraySize]);
        }
        int srcCount =
          0;
        int dstCount =
          0;
        byte repeat;
        byte b;
        try {
            while (dstCount <
                     arraySize) {
                b =
                  data[srcCount++];
                if (b >=
                      0 &&
                      b <=
                      127) {
                    for (int i =
                           0;
                         i <
                           b +
                           1;
                         i++) {
                        dst[dstCount++] =
                          data[srcCount++];
                    }
                }
                else
                    if (b <=
                          -1 &&
                          b >=
                          -127) {
                        repeat =
                          data[srcCount++];
                        for (int i =
                               0;
                             i <
                               -b +
                               1;
                             i++) {
                            dst[dstCount++] =
                              repeat;
                        }
                    }
                    else {
                        srcCount++;
                    }
            }
        }
        catch (java.lang.ArrayIndexOutOfBoundsException ae) {
            throw new java.lang.RuntimeException(
              "TIFFImage14");
        }
        return dst;
    }
    private java.awt.image.ComponentColorModel createAlphaComponentColorModel(int dataType,
                                                                              int numBands,
                                                                              boolean isAlphaPremultiplied,
                                                                              int transparency) {
        java.awt.image.ComponentColorModel ccm =
          null;
        int[] RGBBits =
          null;
        java.awt.color.ColorSpace cs =
          null;
        switch (numBands) {
            case 2:
                cs =
                  java.awt.color.ColorSpace.
                    getInstance(
                      java.awt.color.ColorSpace.
                        CS_GRAY);
                break;
            case 4:
                cs =
                  java.awt.color.ColorSpace.
                    getInstance(
                      java.awt.color.ColorSpace.
                        CS_sRGB);
                break;
            default:
                throw new java.lang.IllegalArgumentException(
                  );
        }
        int componentSize =
          0;
        switch (dataType) {
            case java.awt.image.DataBuffer.
                   TYPE_BYTE:
                componentSize =
                  8;
                break;
            case java.awt.image.DataBuffer.
                   TYPE_USHORT:
            case java.awt.image.DataBuffer.
                   TYPE_SHORT:
                componentSize =
                  16;
                break;
            case java.awt.image.DataBuffer.
                   TYPE_INT:
                componentSize =
                  32;
                break;
            default:
                throw new java.lang.IllegalArgumentException(
                  );
        }
        RGBBits =
          (new int[numBands]);
        for (int i =
               0;
             i <
               numBands;
             i++) {
            RGBBits[i] =
              componentSize;
        }
        ccm =
          new java.awt.image.ComponentColorModel(
            cs,
            RGBBits,
            true,
            isAlphaPremultiplied,
            transparency,
            dataType);
        return ccm;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "bM//A8z+BBnFVwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "VdcJwEEoyk6dTtptiMPx2GKE3tpEl5yQ");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "hTt3o9hOGmx3NXZN5VD62vOQ/vF96T+5k/6Tl5J+dqL0V/NQVw9t4Jg1YGfo" +
       "Ac927ajwKjlQgRrGZqJa2TpEgaVKsaow+dwIEtiJtW8kjx4zkuNBcl11noeu" +
       "svHO+Vitz+509dkL6OroWJ1jYh9bEeyCKzHma1jlKpueoc5sfuXeOCo8oKtR" +
       "HgMJs3EvuYSPH6pn8jzUk887fi3wFq/fxt0eL6Ke152lniyzJ3NZ5FMDFL4l" +
       "D5ANytt7e1S4Dwg73i4fgqPdff3CF1wDb38i2aGWrj8PLT26M6Lbru20dO0F" +
       "1dK+kI8dKwxcYEbZLLKt58y15J9hLqtsZ+UTCL1NV4qk7PcRh2s/X5eT2Qm8" +
       "0wB8UZfzuqhwb7hxsqkDjpmqyjmu96jLefcZQr8n26XA9QKzYbcrzO5dO5T5" +
       "nc9D5nyk35tBQ2A3OeGOmyYnXM51HBUyz/KxG7MEJ1fu3ma5PUYF4wWeqQs8" +
       "7P4y2SCJdn53fxbU1yyvE6dC3R7uj4E9cS7U3gd2wyv3PnSWrfmFk+dC7f2T" +
       "y82FAtnmsf2z50LtffiMe89mux/0d3OhAMkZYT+SbI/vPyPMv8h2742y+ZiS" +
       "cjByeO+Nh8b/vudr/KCQ3xHtjD/62hj/A6DtsVsQZXt8/tPyJM8LoTDW54G7" +
       "DtUAorIh16a8VIOx5KjWCzX771aySQ7kPtm6P75v3T95Kev+2CWt++O5QX3s" +
       "POv+t2fc+9ls98kD6/7YWdb96Z11P3dGmH+f7X4UVGaZdePOTbZ97qSgW7Ht" +
       "9+1s+ztfGNu+7aDjlXcccnexq8J+6QxRP5ftPhsVHs5XjfACNcoWJQiPTAc4" +
       "Kvi5KzedJ3gVCPwvd4L/8FdH8I8dCv7rZwj+G9nuv0aFlx4X/ITn/fnn2wd4" +
       "FRB3N614e3zBxd7Nts1F+/0zxP4f2e63o8L9+7M/5OXc3E770A8FPndppjME" +
       "fiK7+CYg6Bd3An/xhRH4pL7h7nVBLtmXzpD6z7LdF6PCK7d9Q8TyDCmbOOA6" +
       "wMF2stlqN3QMX32sLXxa0FxXf3wRXSXZwnP7q+FnS3s/ctO/4tj++wj5488+" +
       "cNfLn53+xna1l/1/8XA3UbhLW1nW0WV7j5zfAexYM3P13Z3v7/dy+f86Krz+" +
       "ljsxUeFqdsgLwV9t438lKjx1K/GzBROy49G4fwfUfnZcECs/Hol125Wo8Mhp" +
       "saLCbWB/NPRVUI5PCg1Cgv3RkHdGhQePhwT558ej4e4BbZvDcFHhju3J0SD3" +
       "gdRBkOz0fm/fdM7riweqo6iBqlxD5mEUSHJEg97IthJ+5Eh52r47PHc5oyNv" +
       "AZ+8YWWP/P/A7K/Csdr+J5jr8ieeHVDv/HLjR7aL9cuWlKZZKncRhTu3/zcg" +
       "TzRbyeNVp6a2n9Yd/dd/5f6fuPs1++8V798CH5btI2yPn7wyfs/2onwt+/Rn" +
       "Xv5Tb/zRZ383XwD6/wMzK4BUoGcAAA==");
}
