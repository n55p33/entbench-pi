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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "bM//AxyQC8nFVwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "lsG7Z4H+5yuAUntQ6gLQoub99asULwB6vhH8xhVw6T0ufQFuUfX+zlVwRbSL" +
       "Mk+xszO1+7tXwB3vcccX4N6dn/zRVWwW79N9hkDPgv0fl4T9JrAxe1jmfNhr" +
       "b8pP/uxysA/mb1r2zRqkS/bPbCp88QrA7B6YPR/44KH85P9eDvjhAvjIGFiE" +
       "mpAEjZ+F/RfPHLvo/D8Kttkee3YTdqk4+ZuzaUuHeKAvmb/yyn9VTuH87SVx" +
       "8pP5Hmd+Ns61226Bc3ds2RprZdoZ+rl2+yWBXgQ2fg/EnwN07630kwNFwlk4" +
       "z/kq4DzvGeGcVW1fe+gKOMIeRzgH55Fb4Dwnx9l9eIqisPTK818+Fe9ud68w" +
       "P/QvX/Gr3/ahV/xB8a7sbiuayyESGmd89DsR58+f/vyf/tpzH/tY8Yng9oUc" +
       "7V7WnP5aevPH0Bu+cRbY9x2p4aFclIdB0b1zp4XdMS695Vl+iFqElmpoEDvH" +
       "Eddydt/FXcNyj750fXUz2NlBo3hEu/Nviku3255r+L5fOmU1X3cFnyPurUY8" +
       "x2pefQuruT+3mu421lBvvfusf+2lp7Bec0ms/COOtMeSzsGCbuV7FM/OvyD5" +
       "BdFjRxk8uM/g2v279HfHuLT8an6v7Fmhlr8S3h7azNcwt7MNSDH3oyhOv5cf" +
       "5upqHmr5dWdrueimvPqGmvFOW3ON3Sfo3Jdda/jpUfoHu0jF76P3/sVrUxQY" +
       "spZ/qzm894LDbwJHozDAzfQm0rD02vO9E1U4ieP307/4rv/1KPd6822X+JD6" +
       "0lPO63SS/4p6+pfxVynfe1C67eht9U1DNG6M9OSN76jvDbV4HbrcDW+qH9sp" +
       "v9DfTvP57pWFiovfx99SSsfmfo284B6d74i4dIeSq3r3ZC4IPk1P+5TKJQvv" +
       "88H2pn3hfdM5hZe7ReG9N5Id//ymw+wK/uTNe6Q3n4N0zkvv48oxH74RalG0" +
       "//R7mukSr7iP1PSWPdNbzmFa3ILpLl+2tTjWTrm4F+dhHgfF5JN7F/fJnYtT" +
       "vjIVVRfU16wSWn5suUbfTazQcx2QxqFv+1pkc7ZTW2x3ujjbqZmHavWeoVPL" +
       "w77hyKEZNzu0/HLef72G3uyh8svYLtsidr4bXlDwkgvuFbv86/y18Y7kgrDZ" +
       "TQVYuULL/617y3zrOZb5jlvVvu7a6crurqV2uqh86xWKytv2QG87B+g7buVR" +
       "FDP0HJldLwZnIX3nFZDkPZJ8DtI578zPQJqfhXSJN+RHPQB1j6Seg/S9t0B6" +
       "bt6G4Bpj/7B6vPaKU1TfdwUqbU+lnUP1g8+IqnUB1Q9dkirvK+h7Kv0cqg/f" +
       "guoe3bLtYlTAWU/vR65AZO2JrHOIfuxWRKB+Uq285XcW0Y9fkujrwWbviexz" +
       "iD52q0pTPTGKJr8GWnivBhXp9Wjt3jDsZulrxvX8PdCJYTen+D9+Sf5Xgs3Z" +
       "8zvn8H/iFvwPFp0I1HMTLYxzvLOqnbsWnmdrsnuK92cvyfsY2Pw9r38O78/f" +
       "yu1arm7LoNN8qOyHj0erZJZ/ndjfPoX67y+Jmn+Ri/ao0Tmo/+lWpmFFXQvU" +
       "66pVaO7aJ08xffYKBWi9Z1qfw/S5WxWgwiQPm+SnC9CvXZLocbAle6LkHKLf" +
       "urWWeNOKNUkLvbO09NtXqNs3e6bNOUyfv5WRqXIsn6ek378k0MvBtt0Dbc8B" +
       "+p+3AHrhoZcpGsNIxJpeuHsRcVpdf3wFo8r2dNk5dF+8Bd0d+fsR9Sya//3M" +
       "afKh3KXXgu0de5p3nENzzvvs4jPoh4/6DTuFHXmJZza28mhoJCanOzd92o9c" +
       "4pV3IdA3gu1b9wJ96zkC/e0zEeheO9v0npVMpMSfLdPf3VKmgiG9dg086tp1" +
       "+Hr+4v3gzrOpzxuB8KKlrTxxOFhzDoQADZ0nljZ8KMyJgWa7SRw3Qh5WRs8A" +
       "MgpL9x8nRnqu8eR3/9H3/Mo/ecXnD0rXhodD2/LQDFDy/Du+/Ogbc3keuJw8" +
       "j+bysEUHj5SjmCqGDWtqLlJwc/PtEvjxY48PGhGBHP6RVaUnIEoqCWtBcbYQ" +
       "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" +
       "txoUXt+kAAehaSdz0azXkkaTic2K/Y2F");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("rXgxM1VjbG6QSotXGvKs7IwWxlYaIE6ez8h2nPGwM4brUx2dIbgNz8smbwTK" +
       "iAs3c5yoDbvstNqLMgE0sGAd1/XIG0boFA9XUNfvEP06tuqA3+kojYjaeKqF" +
       "oHG9NEzNWUg80eo1Gk4WdofL8WpDwR6MOBQbLVB4pA7EZFTxq/Ek7mp2H+kv" +
       "aRcrA/bpoK0xK7FvWJjPUdKwK/NxYi25muZ1hh2/AXlcN2bwmi6ApkFfY1va" +
       "BGUQhrJn9XkXF0E71SSFqblp2zFXg/tBvTPOgpa6nbLuvNIJpUa5Iyhdj5xn" +
       "9rpSnkT8GmqzbpTCKcPOLUSqY7OegDWCWicU+gkzUlCCDtEaX0+nypT1tuA3" +
       "kNVAl90+Oa/TGhxM0k57ayTcatPfpNyy5yBtxzbFzoCxOAuZrzTBpgQX1dBp" +
       "1x2B516dKuM+5GKbAUgCR0b82LJSF5TLFiUEQwU1QMt5zMMZosxZL1Z6Rq7b" +
       "XsWvMGYC6/2xVmv3p13OhcdE2aKXICPJYFCCX3WRlMHqMTdvenXDQaRl7MZq" +
       "ZdCbrQnInIpL0cIGjIIs1aVTN8pIIFIZPOl1097ISjYcPsSHgDoEQnFKVS13" +
       "NvBYnxgBEkh5OK47RyquJztdSrTF2gCe1eOQqZnzsLNCZoHV4CqabrbGZLSO" +
       "WGIartO2GiIWsDFqMCbihZAmJJ+OVDiwNRlrGgxSVaqS6sWMqa03bY7qeUBO" +
       "D5+Wp02+nmgwDot2IxxNVLSztiptHcfRMipuVDcZUX3QUuMqfT9hKRbz1JE7" +
       "0herLgNRjXpbWDuMNpcXlFLueU0xbXW5URLVOLzS4W3RCzyC6XKMxMO2MJBY" +
       "2Hbt7cobrtvwWF6ryGoglDcgkCF1vKDnSPOmtfCNPsVCeGO5XYRz0AMivRVC" +
       "J+QYbF18Uy/z/oDp14e9LsfVDMwAPZbV1oKoaDTz5NQ2skY20Guk1pbbEz4q" +
       "dxNJ6ghY5MJhKxwnNlt28RoMerI4NNpW5b7Xbg/0YJsxIWhGkElZtKBVz/QJ" +
       "eRVM1ESr0Y4/qqkm7U8bAV/fVjbrabpZ82i1PHEa06Y+gGqLeQg3KzrNQxFo" +
       "BMqRENliiottc4k21r1mXONCGK5yVI0td9xAYfn1Mui35E4K6xVQYEwuruH9" +
       "DsXEtK/y25TqLCNl1Uo6TFpfpUPQpmfCkS4tvZkE9TS+UudVje6kNT1xkBFW" +
       "w2BdFKZDGIbkqpr2qxKqenClupzj8Bh4cDusoiTb2WpUJGCrDB5H/bax8MvJ" +
       "Gh0GFkkOl4QXQlzAxag9WZtmSHqTpbBqtsLyrDNNIW5N9IHrn5Howlr2osrC" +
       "bnhc36yujfm4NsZJuCLrmJXMcRmJ+PIWdKrK0029PmdFn1sHVUngo/pWiMNk" +
       "IrSyEcfA7SVHcYOIYwbqvOoBbc1RsSHKrBYMOlFf6ENRORFC0nZwaTM0baaW" +
       "6E7NWi/KIqihSXo288Cjngdqrd1S1overKOPIqcKQ1O9Op1lNqzpPbli2LVW" +
       "uQdtt4gVMtSAJhVvAkPAP8Yt2oCSUY1eZMuhkAyoenmhL7gMlhJLas6ay5he" +
       "cHyjH9ZGXZGjGTZJ+pW6NPSq8XhUbWFzvgpPtG09csdSXKUmayjqNuMQHlp1" +
       "Nm7DZh0lVvrQRoH7xmfCJAbVbDW1F25ZcpfrzpoM4KzfrXbNLawtMpGcmjMB" +
       "Euk5eBZsIC9mticMG5zQJSxfy6xsMh0yIUTN57MpPZpC6+WSWVXK3MKmt1vB" +
       "7CChpGYLXyGlSa0VtjaW7G7K5Gi19RdECA3LGCZpPUHPCCJkyqOZXaZCm+63" +
       "2SEcsGYL4xjTDqp9RSBk3KGmvayip340wAdQ1XN7UISKvkxvN0krVtcKUbW7" +
       "o80S5jlN7UHrmk0w7aSxhaVKH5vEFhZEvDDjiazZJVRYH7fUdDxck6MW6H/j" +
       "vgZBg15vOEDam2anPoTrwAOaa6ileWMCDwmTlOL1ajkNlwIPw7qCrseVcuYE" +
       "+pTuDnRkNp/NqAqHgH7KYtqnWkQsBGSZIlCv7ygOOuM6gVz2CCdwA7KqeUmz" +
       "Y5B2YC1pEp0xnY2tzvrczKYXy0401ttcXB2P+uRCoEd8JFqsXV04EM52YxKq" +
       "2XOpv5jFsCeWK1DVcuKeaQ/WXLtrCCwUAVs2+9WhSuHYfG5rHa0djntNZEgE" +
       "7lCxVhPGFio2VkURf0lX/C6nj7WZ2wLND1Y3xLGt02xXGpUb7Nq3uh67lJil" +
       "vU01o5FBUbPbZqhtNA/ZWA3b615F2PByuuRbFbJahkYpOZOXS1Yg0TrSERsJ" +
       "CThSpVqhUDvOHGPDyYjXWXG9doftcn15PtRqla6/gWzPrqDMpmVXZwIxqehC" +
       "a2rJprnB8OrUls2oRlfqCdwbKHbGEBlWrm0E08gIs9Gn49UmNrUVRZj1immN" +
       "ll20y2esOIhGwZxwxjUcCmix6nYxhNbHitOUDDnjdBw8K5EOqZa28WurdXXT" +
       "nJDVCdsUUErBGktkZYc6C8Jw4xg2Uz6gNy6erpJQklPFJyfOSmzGVbwbInFb" +
       "YuaMkeLuEA2GNhlsuD4mbJYDnBcrwy5WD0Yti3D8YVMN09Ws2cSjetQQq9ak" +
       "RWeBwCwQmVKa9TrerY7ijs9IzKY21d2t5SQjRlEgn20kcSZ1K4qZWfp0Q/gZ" +
       "hGsB3J2WPTN0eQfn6tHURqtxszJZtBZVdOW2e36/PuLl8XwEWVi2rXCdhb0R" +
       "KMdOsBFSjobteoNd+oyJVYc9JViPlyTTJqUwTfxMp6x6ajQT0lqFk6wREpAw" +
       "nnraCmIJthWuVVOjOI7ox3gYjjN6mdLCIKtprTDNkkVtWzFIc1VbVJTqvMlg" +
       "osqps023NWxS0mJhu6KKlalW3AYtWIKKMi+QJW5GAu/th726MjSJlhkJSXsD" +
       "9wnQlLNRQgH1RLMZCmbPymSPiGKq3XIJtYe1O4YhaEuWjJyKWe+BiqbCgb46" +
       "N2+vsIlbrQXSLJZAjTPM3PKqxnu0lApBdb1U6qmsou6gPd2isj4VZx1KG6TC" +
       "OpUJgTAGEyVMgXcMmCUoKwEOu8ORuXbkWsvMXNB2HPuLyLJBpahjdnUU8Aw9" +
       "Z+Qoq/EDmWnbjQTRB8Fwxaij6VRUhkNWC8uDAEembmINs0DyOlibx9uyn7iE" +
       "rzbXQbRhph3QlCJTakosNl1oKbsuxXRwlEcjS+VdojOVBEdudyJYQ5yBDLVG" +
       "k+amalGz5RBmyYU2r3mVRh1UxTHDVnBm3V9yQzVcR4ZgNapOyJVBO6yy7FMR" +
       "LrvlZrclp2RzURtvkm0QTUk5Q2N1qUwrNi2jgknynTG94EVXxxieL7dGK5GK" +
       "WtV0440SQWQxMiCcmoSZeGTPwibKyFzZD91+U6zAPXEWM1jQ69oTb8E1ca27" +
       "JZ2OjYZcC0ebegPKFHIb+nZkEA4fd7DBBMMmUbjtDQ2GdWRZTEEXLB7PFM6e" +
       "r31Vq5HSpjro49kg7tADEVTcqlFFBhlM4mWqi42xLlNrbqfecsxLdoWspVI7" +
       "nvuztiNtNm3EHuo61/VRI6pFKcp6Wbczl7iq1ba3wTTyKV1Clny5U3UqcgL5" +
       "oOcRNYip7ghIV2r4oHwJI57Cu2rithu9PsS3dVTezFwItzYYkxrbljEpB5Bh" +
       "DqHtWldBy6TR3mLqZtod6euwzfML2+uKKqOrZTfltbSMwpgq9H1b6tgmpMyT" +
       "QQ9NJdYQjCVovvnbeYu0tRZOxP1NkpKsTMB0eaS6HVSo9qXVcuyPxg2rLWxR" +
       "NUmGId00W1rHjuJlx5Wlam0rlOegFVFfdUBzY7NWRglXnm4XUKKUtxSvty04" +
       "G8dlMqHXxBB07EEbCGqTVpdZuhV+bvGg/kx6ltRzx30eqlSbXELR0yGLddgR" +
       "NGE10AzqTTJLHLQjqO+sbSQEzQAPZct81vN4mMBInXfE5kCtNFSdM6Xx0psg" +
       "NAyqoRasd6sdvoK0DLGpZdraEwN5snQkk5J4ds03VHvuM6nIJv0pq3bkCqIN" +
       "tok1mS9cT+r7k4Ysmo7ZYbZWY7XRe2wdF62GHZUzN2mvekgjrDYmqjjl9Gy4" +
       "6te30ECTjF5taOgNKXFafQlvIYOoI5aRSTI02GpieC2SFsNRdxXoPOXNB3Nz" +
       "K7S9VRVfQYNQcEJ8NAiRiCaqPoPNJd5XyzPHo0UtQTqhPmrTyYrdROW5ZXVE" +
       "HGpO6gOpqiRjEl5qfDSIoAqT+HY6W9bE+VxwqxmhNKuCQYvUqNVYS9VQydSR" +
       "LPQkNppodZ9E+XmZoKajWFp0uup05rZbHRK0W+tlNe6qPRVacogpwOqcqM7I" +
       "4ZTpz4ddiRvX/MiU3eXc9P3p2IlqM5sMQ8Nt1+RyJhjRShfnLRtjpGG7EcAq" +
       "0ppTA45c+PHMpDqbHrYi2dlCsUJ2jIPueyVkSd+c8Y47EAM9jmgNGibMKq1M" +
       "NvPZfMF1HGG8rsae7YZ8s97ZTrXxolxrNMIKCcNsmZOkma9j6QKf425/W534" +
       "ExyP+Ni31v1QtWPQApXKZTyCK+kCJMa7NWooIEbP2sRlS+5w5mBa6VT4da+u" +
       "SR3dTVS4uhHX44led1Ytf7VBtYpDiA5L1WVBtyPHryl05DD1ZMJxLFxjN4uG" +
       "Vw17tTgc0M1NVi5XkuYSNmY6PBkIizZUVlPVzjpwpU1wbJteMcYm6uuem2bN" +
       "ViUbOariDvvyeFJFTUfeNPsmJs5Ytt4KzTEu2gK6qBvbROhWq2s2afh6TNDo" +
       "TI9HQWewRiodgQrwTUVaEDLpk+Z242WorUWuO4irUT1Ye2tDIeb1oSRFcod3" +
       "BhMRd/AU0sn1ulaF2o4rk5k15LJesph2Ei2bwemCgiAk3U7RtovNN0g+HvXg" +
       "RZf7XPu84vPz0YKCu6+0B8+5xFfa3a3daPWjb/zFXz4L54ZF6E584y9CPrIf" +
       "LhGFpcfOWyewWJLoI+96/4fU8Y9WD/ZjK56MS/fEnv+NtpZo9omkinWRrmFH" +
       "GI8fjp147x7jvaeHGhwL+gwnAhahjsff3lEEzSft7sb5/uuj0R7F8Bg4j3Tw" +
       "2lORTgzaPfiGfPfKuHTvbmDG0UizF8alFxZf64/HLYCWw+H4rvypHLzqVt/O" +
       "T+Z1SjPFlKk83tN7zTx9Cc0cHGnmbKWcGCNdKMUoJL1gGsPBN+W7ely6az+K" +
       "7azBdrcnnqUeS994FtK/9FD6T+yl/8SVpJ+fKf3tRajbj23glDXgF+iByHfd" +
       "uPQyJdSAGiZWqtn5OkShrcmJprLF3AgK2Il9aCSPnjKS00EKXaHPQlf5eOdi" +
       "rNZn9rr6zCV0dXKszimxT60IdsmVGIs1rAqVzS5QZz6/8mASlx4wtLiIgUT5" +
       "uJdCwpceq2f6LNRTzDt+FfAWr9nF3R0vo55XX6SePLNXFLIo5wYovbEIkA/K" +
       "O3hrXHouEHayWz6EwHqH+oUvuQbe4USyYy099Sy09OjeiG67vtfS9a+olg6F" +
       "fOxUYeBDK85nke08Z6Gl4AJzWec7u5hA6G97ciznv084XOfZupzcTuC9BuDL" +
       "upxXx6X7oq2bTx1wrUxTb+F6T7qcd14g9LvyXQZcLzAbbrfC7MH1Y5nf/ixk" +
       "Lkb6vQE0BPaTE+68aXLC1VzHSSGLLB+7MUtwcu2eXZa7Y1wyv8IzdYGHPVwm" +
       "GyTRLe4ezoL6muV15lSoO6LDMbBnzoU6eN9+eOXBBy6ytaB09lyog398tblQ" +
       "INsidnDxXKiDD15w70P57oeC/VwoQHJB2A+nu+N7Lwjzz/Pdu+N8PqasHo0c" +
       "PnjdsfG/59kaPyjkd8Z744+/Nsb/AGh77BdE2R2f/bQ82fcjKEqMRehtIi2E" +
       "6HzItaWstHAiu5r9lZr990yySY/kPtu6P3Zo3T91Jev+6BWt+2OFQX30Vtb9" +
       "by6493P57hNH1v3Ri6z7U3vrfvqCMP8u3/0YqMxy6ybcm2z7lpOCnoltv2dv" +
       "29/1lbHt2446XkXHoXAX+yrsly8Q9bP57jNx6eFi1Qg/1OJ8UYLoxHSAk4Lf" +
       "cuWmWwleBwL/i73gP/LVEfyjx4L/xgWC/2a++y9x6QWnBT/jeX/u2fYBXgbE" +
       "3U8r3h2/4mLvZ9sWov3BBWL/93z3O3Hp/sPZH8pqYe2mfRjHAt9yaaYLBH48" +
       "v/h6IOgX9gJ/4Ssj8Fl9w/3rgkKyL14g9f/Jd1+ISy/Z9Q0R2zflfOKA5wIH" +
       "i+az1W7oGL78VFv4vKCFrv7kMrpK84XnDlfDz5f2fuSmf8Wx+/cRysc+9MDd" +
       "L/rQ7Dd3q70c/ouHe8jS3fratk8u23vi/E5gx7pVqO+eYn+/X8j/13HpNc+4" +
       "ExOXbs8PRSH4q138L8elJ55J/HzBhPx4Mu7fAbVfHBfEKo4nYt12LS49cl6s" +
       "uHQb2J8MfTsox2eFBiHB/mTIu+LSg6dDgvyL48lw94K2zXG4uHTn7uRkkOeC" +
       "1EGQ/PR+/9B0btUXDzVX1UJNvY4sojiUlZgBvZFdJfzIifK0e3d4y+WMTrwF" +
       "fMUNK3sU/wfmcBWO9e4/wTylfPxDQ/rtX2r96G6xfsWWsyxP5W6ydNfu/wYU" +
       "ieYrebzs3NQO07pz8Jov3/+T97zy8L3i/Tvg47J9gu2lZ6+M33f8uFjLPvvZ" +
       "F/30637sQ79XLAD9/wGKlfwLoGcAAA==");
}
