package org.apache.batik.ext.awt.image.codec.tiff;
public class TIFFImageEncoder extends org.apache.batik.ext.awt.image.codec.util.ImageEncoderImpl {
    private static final int TIFF_UNSUPPORTED = -1;
    private static final int TIFF_BILEVEL_WHITE_IS_ZERO = 0;
    private static final int TIFF_BILEVEL_BLACK_IS_ZERO = 1;
    private static final int TIFF_GRAY = 2;
    private static final int TIFF_PALETTE = 3;
    private static final int TIFF_RGB = 4;
    private static final int TIFF_CMYK = 5;
    private static final int TIFF_YCBCR = 6;
    private static final int TIFF_CIELAB = 7;
    private static final int TIFF_GENERIC = 8;
    private static final int COMP_NONE = 1;
    private static final int COMP_JPEG_TTN2 = 7;
    private static final int COMP_PACKBITS = 32773;
    private static final int COMP_DEFLATE = 32946;
    private static final int TIFF_JPEG_TABLES = 347;
    private static final int TIFF_YCBCR_SUBSAMPLING = 530;
    private static final int TIFF_YCBCR_POSITIONING = 531;
    private static final int TIFF_REF_BLACK_WHITE = 532;
    private static final int EXTRA_SAMPLE_UNSPECIFIED = 0;
    private static final int EXTRA_SAMPLE_ASSOCIATED_ALPHA = 1;
    private static final int EXTRA_SAMPLE_UNASSOCIATED_ALPHA = 2;
    private static final int DEFAULT_ROWS_PER_STRIP = 8;
    public TIFFImageEncoder(java.io.OutputStream output, org.apache.batik.ext.awt.image.codec.util.ImageEncodeParam param) {
        super(
          output,
          param);
        if (this.
              param ==
              null) {
            this.
              param =
              new org.apache.batik.ext.awt.image.codec.tiff.TIFFEncodeParam(
                );
        }
    }
    public void encode(java.awt.image.RenderedImage im) throws java.io.IOException {
        writeFileHeader(
          );
        org.apache.batik.ext.awt.image.codec.tiff.TIFFEncodeParam encodeParam =
          (org.apache.batik.ext.awt.image.codec.tiff.TIFFEncodeParam)
            param;
        java.util.Iterator iter =
          encodeParam.
          getExtraImages(
            );
        if (iter !=
              null) {
            int ifdOffset =
              8;
            java.awt.image.RenderedImage nextImage =
              im;
            org.apache.batik.ext.awt.image.codec.tiff.TIFFEncodeParam nextParam =
              encodeParam;
            boolean hasNext;
            do  {
                hasNext =
                  iter.
                    hasNext(
                      );
                ifdOffset =
                  encode(
                    nextImage,
                    nextParam,
                    ifdOffset,
                    !hasNext);
                if (hasNext) {
                    java.lang.Object obj =
                      iter.
                      next(
                        );
                    if (obj instanceof java.awt.image.RenderedImage) {
                        nextImage =
                          (java.awt.image.RenderedImage)
                            obj;
                        nextParam =
                          encodeParam;
                    }
                    else
                        if (obj instanceof java.lang.Object[]) {
                            java.lang.Object[] o =
                              (java.lang.Object[])
                                obj;
                            nextImage =
                              (java.awt.image.RenderedImage)
                                o[0];
                            nextParam =
                              (org.apache.batik.ext.awt.image.codec.tiff.TIFFEncodeParam)
                                o[1];
                        }
                }
            }while(hasNext); 
        }
        else {
            encode(
              im,
              encodeParam,
              8,
              true);
        }
    }
    private int encode(java.awt.image.RenderedImage im,
                       org.apache.batik.ext.awt.image.codec.tiff.TIFFEncodeParam encodeParam,
                       int ifdOffset,
                       boolean isLast) throws java.io.IOException {
        int compression =
          encodeParam.
          getCompression(
            );
        boolean isTiled =
          encodeParam.
          getWriteTiled(
            );
        int minX =
          im.
          getMinX(
            );
        int minY =
          im.
          getMinY(
            );
        int width =
          im.
          getWidth(
            );
        int height =
          im.
          getHeight(
            );
        java.awt.image.SampleModel sampleModel =
          im.
          getSampleModel(
            );
        int[] sampleSize =
          sampleModel.
          getSampleSize(
            );
        for (int i =
               1;
             i <
               sampleSize.
                 length;
             i++) {
            if (sampleSize[i] !=
                  sampleSize[0]) {
                throw new java.lang.Error(
                  "TIFFImageEncoder0");
            }
        }
        int numBands =
          sampleModel.
          getNumBands(
            );
        if ((sampleSize[0] ==
               1 ||
               sampleSize[0] ==
               4) &&
              numBands !=
              1) {
            throw new java.lang.Error(
              "TIFFImageEncoder1");
        }
        int dataType =
          sampleModel.
          getDataType(
            );
        switch (dataType) {
            case java.awt.image.DataBuffer.
                   TYPE_BYTE:
                if (sampleSize[0] !=
                      1 &&
                      sampleSize[0] ==
                      4 &&
                      sampleSize[0] !=
                      8) {
                    throw new java.lang.Error(
                      "TIFFImageEncoder2");
                }
                break;
            case java.awt.image.DataBuffer.
                   TYPE_SHORT:
            case java.awt.image.DataBuffer.
                   TYPE_USHORT:
                if (sampleSize[0] !=
                      16) {
                    throw new java.lang.Error(
                      "TIFFImageEncoder3");
                }
                break;
            case java.awt.image.DataBuffer.
                   TYPE_INT:
            case java.awt.image.DataBuffer.
                   TYPE_FLOAT:
                if (sampleSize[0] !=
                      32) {
                    throw new java.lang.Error(
                      "TIFFImageEncoder4");
                }
                break;
            default:
                throw new java.lang.Error(
                  "TIFFImageEncoder5");
        }
        boolean dataTypeIsShort =
          dataType ==
          java.awt.image.DataBuffer.
            TYPE_SHORT ||
          dataType ==
          java.awt.image.DataBuffer.
            TYPE_USHORT;
        java.awt.image.ColorModel colorModel =
          im.
          getColorModel(
            );
        if (colorModel !=
              null &&
              colorModel instanceof java.awt.image.IndexColorModel &&
              dataType !=
              java.awt.image.DataBuffer.
                TYPE_BYTE) {
            throw new java.lang.Error(
              "TIFFImageEncoder6");
        }
        java.awt.image.IndexColorModel icm =
          null;
        int sizeOfColormap =
          0;
        char[] colormap =
          null;
        int imageType =
          TIFF_UNSUPPORTED;
        int numExtraSamples =
          0;
        int extraSampleType =
          EXTRA_SAMPLE_UNSPECIFIED;
        if (colorModel instanceof java.awt.image.IndexColorModel) {
            icm =
              (java.awt.image.IndexColorModel)
                colorModel;
            int mapSize =
              icm.
              getMapSize(
                );
            if (sampleSize[0] ==
                  1 &&
                  numBands ==
                  1) {
                if (mapSize !=
                      2) {
                    throw new java.lang.IllegalArgumentException(
                      "TIFFImageEncoder7");
                }
                byte[] r =
                  new byte[mapSize];
                icm.
                  getReds(
                    r);
                byte[] g =
                  new byte[mapSize];
                icm.
                  getGreens(
                    g);
                byte[] b =
                  new byte[mapSize];
                icm.
                  getBlues(
                    b);
                if ((r[0] &
                       255) ==
                      0 &&
                      (r[1] &
                         255) ==
                      255 &&
                      (g[0] &
                         255) ==
                      0 &&
                      (g[1] &
                         255) ==
                      255 &&
                      (b[0] &
                         255) ==
                      0 &&
                      (b[1] &
                         255) ==
                      255) {
                    imageType =
                      TIFF_BILEVEL_BLACK_IS_ZERO;
                }
                else
                    if ((r[0] &
                           255) ==
                          255 &&
                          (r[1] &
                             255) ==
                          0 &&
                          (g[0] &
                             255) ==
                          255 &&
                          (g[1] &
                             255) ==
                          0 &&
                          (b[0] &
                             255) ==
                          255 &&
                          (b[1] &
                             255) ==
                          0) {
                        imageType =
                          TIFF_BILEVEL_WHITE_IS_ZERO;
                    }
                    else {
                        imageType =
                          TIFF_PALETTE;
                    }
            }
            else
                if (numBands ==
                      1) {
                    imageType =
                      TIFF_PALETTE;
                }
        }
        else
            if (colorModel ==
                  null) {
                if (sampleSize[0] ==
                      1 &&
                      numBands ==
                      1) {
                    imageType =
                      TIFF_BILEVEL_BLACK_IS_ZERO;
                }
                else {
                    imageType =
                      TIFF_GENERIC;
                    if (numBands >
                          1) {
                        numExtraSamples =
                          numBands -
                            1;
                    }
                }
            }
            else {
                java.awt.color.ColorSpace colorSpace =
                  colorModel.
                  getColorSpace(
                    );
                switch (colorSpace.
                          getType(
                            )) {
                    case java.awt.color.ColorSpace.
                           TYPE_CMYK:
                        imageType =
                          TIFF_CMYK;
                        break;
                    case java.awt.color.ColorSpace.
                           TYPE_GRAY:
                        imageType =
                          TIFF_GRAY;
                        break;
                    case java.awt.color.ColorSpace.
                           TYPE_Lab:
                        imageType =
                          TIFF_CIELAB;
                        break;
                    case java.awt.color.ColorSpace.
                           TYPE_RGB:
                        if (compression ==
                              COMP_JPEG_TTN2 &&
                              encodeParam.
                              getJPEGCompressRGBToYCbCr(
                                )) {
                            imageType =
                              TIFF_YCBCR;
                        }
                        else {
                            imageType =
                              TIFF_RGB;
                        }
                        break;
                    case java.awt.color.ColorSpace.
                           TYPE_YCbCr:
                        imageType =
                          TIFF_YCBCR;
                        break;
                    default:
                        imageType =
                          TIFF_GENERIC;
                        break;
                }
                if (imageType ==
                      TIFF_GENERIC) {
                    numExtraSamples =
                      numBands -
                        1;
                }
                else
                    if (numBands >
                          1) {
                        numExtraSamples =
                          numBands -
                            colorSpace.
                            getNumComponents(
                              );
                    }
                if (numExtraSamples ==
                      1 &&
                      colorModel.
                      hasAlpha(
                        )) {
                    extraSampleType =
                      colorModel.
                        isAlphaPremultiplied(
                          )
                        ? EXTRA_SAMPLE_ASSOCIATED_ALPHA
                        : EXTRA_SAMPLE_UNASSOCIATED_ALPHA;
                }
            }
        if (imageType ==
              TIFF_UNSUPPORTED) {
            throw new java.lang.Error(
              "TIFFImageEncoder8");
        }
        if (compression ==
              COMP_JPEG_TTN2) {
            if (imageType ==
                  TIFF_PALETTE) {
                throw new java.lang.Error(
                  "TIFFImageEncoder11");
            }
            else
                if (!(sampleSize[0] ==
                        8 &&
                        (imageType ==
                           TIFF_GRAY ||
                           imageType ==
                           TIFF_RGB ||
                           imageType ==
                           TIFF_YCBCR))) {
                    throw new java.lang.Error(
                      "TIFFImageEncoder9");
                }
        }
        int photometricInterpretation =
          -1;
        switch (imageType) {
            case TIFF_BILEVEL_WHITE_IS_ZERO:
                photometricInterpretation =
                  0;
                break;
            case TIFF_BILEVEL_BLACK_IS_ZERO:
                photometricInterpretation =
                  1;
                break;
            case TIFF_GRAY:
            case TIFF_GENERIC:
                photometricInterpretation =
                  1;
                break;
            case TIFF_PALETTE:
                photometricInterpretation =
                  3;
                icm =
                  (java.awt.image.IndexColorModel)
                    colorModel;
                sizeOfColormap =
                  icm.
                    getMapSize(
                      );
                byte[] r =
                  new byte[sizeOfColormap];
                icm.
                  getReds(
                    r);
                byte[] g =
                  new byte[sizeOfColormap];
                icm.
                  getGreens(
                    g);
                byte[] b =
                  new byte[sizeOfColormap];
                icm.
                  getBlues(
                    b);
                int redIndex =
                  0;
                int greenIndex =
                  sizeOfColormap;
                int blueIndex =
                  2 *
                  sizeOfColormap;
                colormap =
                  (new char[sizeOfColormap *
                              3]);
                for (int i =
                       0;
                     i <
                       sizeOfColormap;
                     i++) {
                    int tmp =
                      255 &
                      r[i];
                    colormap[redIndex++] =
                      (char)
                        (tmp <<
                           8 |
                           tmp);
                    tmp =
                      255 &
                        g[i];
                    colormap[greenIndex++] =
                      (char)
                        (tmp <<
                           8 |
                           tmp);
                    tmp =
                      255 &
                        b[i];
                    colormap[blueIndex++] =
                      (char)
                        (tmp <<
                           8 |
                           tmp);
                }
                sizeOfColormap *=
                  3;
                break;
            case TIFF_RGB:
                photometricInterpretation =
                  2;
                break;
            case TIFF_CMYK:
                photometricInterpretation =
                  5;
                break;
            case TIFF_YCBCR:
                photometricInterpretation =
                  6;
                break;
            case TIFF_CIELAB:
                photometricInterpretation =
                  8;
                break;
            default:
                throw new java.lang.Error(
                  "TIFFImageEncoder8");
        }
        int tileWidth;
        int tileHeight;
        if (isTiled) {
            tileWidth =
              encodeParam.
                getTileWidth(
                  ) >
                0
                ? encodeParam.
                getTileWidth(
                  )
                : im.
                getTileWidth(
                  );
            tileHeight =
              encodeParam.
                getTileHeight(
                  ) >
                0
                ? encodeParam.
                getTileHeight(
                  )
                : im.
                getTileHeight(
                  );
        }
        else {
            tileWidth =
              width;
            tileHeight =
              encodeParam.
                getTileHeight(
                  ) >
                0
                ? encodeParam.
                getTileHeight(
                  )
                : DEFAULT_ROWS_PER_STRIP;
        }
        com.sun.image.codec.jpeg.JPEGEncodeParam jep =
          null;
        if (compression ==
              COMP_JPEG_TTN2) {
            jep =
              encodeParam.
                getJPEGEncodeParam(
                  );
            int maxSubH =
              jep.
              getHorizontalSubsampling(
                0);
            int maxSubV =
              jep.
              getVerticalSubsampling(
                0);
            for (int i =
                   1;
                 i <
                   numBands;
                 i++) {
                int subH =
                  jep.
                  getHorizontalSubsampling(
                    i);
                if (subH >
                      maxSubH) {
                    maxSubH =
                      subH;
                }
                int subV =
                  jep.
                  getVerticalSubsampling(
                    i);
                if (subV >
                      maxSubV) {
                    maxSubV =
                      subV;
                }
            }
            int factorV =
              8 *
              maxSubV;
            tileHeight =
              (int)
                ((float)
                   tileHeight /
                   (float)
                     factorV +
                   0.5F) *
                factorV;
            if (tileHeight <
                  factorV) {
                tileHeight =
                  factorV;
            }
            if (isTiled) {
                int factorH =
                  8 *
                  maxSubH;
                tileWidth =
                  (int)
                    ((float)
                       tileWidth /
                       (float)
                         factorH +
                       0.5F) *
                    factorH;
                if (tileWidth <
                      factorH) {
                    tileWidth =
                      factorH;
                }
            }
        }
        int numTiles;
        if (isTiled) {
            numTiles =
              (width +
                 tileWidth -
                 1) /
                tileWidth *
                ((height +
                    tileHeight -
                    1) /
                   tileHeight);
        }
        else {
            numTiles =
              (int)
                java.lang.Math.
                ceil(
                  (double)
                    height /
                    (double)
                      tileHeight);
        }
        long[] tileByteCounts =
          new long[numTiles];
        long bytesPerRow =
          (long)
            java.lang.Math.
            ceil(
              sampleSize[0] /
                8.0 *
                tileWidth *
                numBands);
        long bytesPerTile =
          bytesPerRow *
          tileHeight;
        for (int i =
               0;
             i <
               numTiles;
             i++) {
            tileByteCounts[i] =
              bytesPerTile;
        }
        if (!isTiled) {
            long lastStripRows =
              height -
              tileHeight *
              (numTiles -
                 1);
            tileByteCounts[numTiles -
                             1] =
              lastStripRows *
                bytesPerRow;
        }
        long totalBytesOfData =
          bytesPerTile *
          (numTiles -
             1) +
          tileByteCounts[numTiles -
                           1];
        long[] tileOffsets =
          new long[numTiles];
        java.util.SortedSet fields =
          new java.util.TreeSet(
          );
        fields.
          add(
            new org.apache.batik.ext.awt.image.codec.tiff.TIFFField(
              org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                TIFF_IMAGE_WIDTH,
              org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                TIFF_LONG,
              1,
              new long[] { width }));
        fields.
          add(
            new org.apache.batik.ext.awt.image.codec.tiff.TIFFField(
              org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                TIFF_IMAGE_LENGTH,
              org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                TIFF_LONG,
              1,
              new long[] { height }));
        char[] shortSampleSize =
          new char[numBands];
        for (int i =
               0;
             i <
               numBands;
             i++)
            shortSampleSize[i] =
              (char)
                sampleSize[i];
        fields.
          add(
            new org.apache.batik.ext.awt.image.codec.tiff.TIFFField(
              org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                TIFF_BITS_PER_SAMPLE,
              org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                TIFF_SHORT,
              numBands,
              shortSampleSize));
        fields.
          add(
            new org.apache.batik.ext.awt.image.codec.tiff.TIFFField(
              org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                TIFF_COMPRESSION,
              org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                TIFF_SHORT,
              1,
              new char[] { (char)
                             compression }));
        fields.
          add(
            new org.apache.batik.ext.awt.image.codec.tiff.TIFFField(
              org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                TIFF_PHOTOMETRIC_INTERPRETATION,
              org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                TIFF_SHORT,
              1,
              new char[] { (char)
                             photometricInterpretation }));
        if (!isTiled) {
            fields.
              add(
                new org.apache.batik.ext.awt.image.codec.tiff.TIFFField(
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                    TIFF_STRIP_OFFSETS,
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                    TIFF_LONG,
                  numTiles,
                  tileOffsets));
        }
        fields.
          add(
            new org.apache.batik.ext.awt.image.codec.tiff.TIFFField(
              org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                TIFF_SAMPLES_PER_PIXEL,
              org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                TIFF_SHORT,
              1,
              new char[] { (char)
                             numBands }));
        if (!isTiled) {
            fields.
              add(
                new org.apache.batik.ext.awt.image.codec.tiff.TIFFField(
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                    TIFF_ROWS_PER_STRIP,
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                    TIFF_LONG,
                  1,
                  new long[] { tileHeight }));
            fields.
              add(
                new org.apache.batik.ext.awt.image.codec.tiff.TIFFField(
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                    TIFF_STRIP_BYTE_COUNTS,
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                    TIFF_LONG,
                  numTiles,
                  tileByteCounts));
        }
        if (colormap !=
              null) {
            fields.
              add(
                new org.apache.batik.ext.awt.image.codec.tiff.TIFFField(
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                    TIFF_COLORMAP,
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                    TIFF_SHORT,
                  sizeOfColormap,
                  colormap));
        }
        if (isTiled) {
            fields.
              add(
                new org.apache.batik.ext.awt.image.codec.tiff.TIFFField(
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                    TIFF_TILE_WIDTH,
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                    TIFF_LONG,
                  1,
                  new long[] { tileWidth }));
            fields.
              add(
                new org.apache.batik.ext.awt.image.codec.tiff.TIFFField(
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                    TIFF_TILE_LENGTH,
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                    TIFF_LONG,
                  1,
                  new long[] { tileHeight }));
            fields.
              add(
                new org.apache.batik.ext.awt.image.codec.tiff.TIFFField(
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                    TIFF_TILE_OFFSETS,
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                    TIFF_LONG,
                  numTiles,
                  tileOffsets));
            fields.
              add(
                new org.apache.batik.ext.awt.image.codec.tiff.TIFFField(
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                    TIFF_TILE_BYTE_COUNTS,
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                    TIFF_LONG,
                  numTiles,
                  tileByteCounts));
        }
        if (numExtraSamples >
              0) {
            char[] extraSamples =
              new char[numExtraSamples];
            for (int i =
                   0;
                 i <
                   numExtraSamples;
                 i++) {
                extraSamples[i] =
                  (char)
                    extraSampleType;
            }
            fields.
              add(
                new org.apache.batik.ext.awt.image.codec.tiff.TIFFField(
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                    TIFF_EXTRA_SAMPLES,
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                    TIFF_SHORT,
                  numExtraSamples,
                  extraSamples));
        }
        if (dataType !=
              java.awt.image.DataBuffer.
                TYPE_BYTE) {
            char[] sampleFormat =
              new char[numBands];
            if (dataType ==
                  java.awt.image.DataBuffer.
                    TYPE_FLOAT) {
                sampleFormat[0] =
                  3;
            }
            else
                if (dataType ==
                      java.awt.image.DataBuffer.
                        TYPE_USHORT) {
                    sampleFormat[0] =
                      1;
                }
                else {
                    sampleFormat[0] =
                      2;
                }
            for (int b =
                   1;
                 b <
                   numBands;
                 b++) {
                sampleFormat[b] =
                  sampleFormat[0];
            }
            fields.
              add(
                new org.apache.batik.ext.awt.image.codec.tiff.TIFFField(
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
                    TIFF_SAMPLE_FORMAT,
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                    TIFF_SHORT,
                  numBands,
                  sampleFormat));
        }
        com.sun.image.codec.jpeg.JPEGEncodeParam jpegEncodeParam =
          null;
        com.sun.image.codec.jpeg.JPEGImageEncoder jpegEncoder =
          null;
        int jpegColorID =
          0;
        if (compression ==
              COMP_JPEG_TTN2) {
            jpegColorID =
              com.sun.image.codec.jpeg.JPEGDecodeParam.
                COLOR_ID_UNKNOWN;
            switch (imageType) {
                case TIFF_GRAY:
                case TIFF_PALETTE:
                    jpegColorID =
                      com.sun.image.codec.jpeg.JPEGDecodeParam.
                        COLOR_ID_GRAY;
                    break;
                case TIFF_RGB:
                    jpegColorID =
                      com.sun.image.codec.jpeg.JPEGDecodeParam.
                        COLOR_ID_RGB;
                    break;
                case TIFF_YCBCR:
                    jpegColorID =
                      com.sun.image.codec.jpeg.JPEGDecodeParam.
                        COLOR_ID_YCbCr;
                    break;
            }
            java.awt.image.Raster tile00 =
              im.
              getTile(
                0,
                0);
            jpegEncodeParam =
              com.sun.image.codec.jpeg.JPEGCodec.
                getDefaultJPEGEncodeParam(
                  tile00,
                  jpegColorID);
            modifyEncodeParam(
              jep,
              jpegEncodeParam,
              numBands);
            jpegEncodeParam.
              setImageInfoValid(
                false);
            jpegEncodeParam.
              setTableInfoValid(
                true);
            java.io.ByteArrayOutputStream tableStream =
              new java.io.ByteArrayOutputStream(
              );
            jpegEncoder =
              com.sun.image.codec.jpeg.JPEGCodec.
                createJPEGEncoder(
                  tableStream,
                  jpegEncodeParam);
            jpegEncoder.
              encode(
                tile00);
            byte[] tableData =
              tableStream.
              toByteArray(
                );
            fields.
              add(
                new org.apache.batik.ext.awt.image.codec.tiff.TIFFField(
                  TIFF_JPEG_TABLES,
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                    TIFF_UNDEFINED,
                  tableData.
                    length,
                  tableData));
            jpegEncoder =
              null;
        }
        if (imageType ==
              TIFF_YCBCR) {
            char subsampleH =
              1;
            char subsampleV =
              1;
            if (compression ==
                  COMP_JPEG_TTN2) {
                subsampleH =
                  (char)
                    jep.
                    getHorizontalSubsampling(
                      0);
                subsampleV =
                  (char)
                    jep.
                    getVerticalSubsampling(
                      0);
                for (int i =
                       1;
                     i <
                       numBands;
                     i++) {
                    char subH =
                      (char)
                        jep.
                        getHorizontalSubsampling(
                          i);
                    if (subH >
                          subsampleH) {
                        subsampleH =
                          subH;
                    }
                    char subV =
                      (char)
                        jep.
                        getVerticalSubsampling(
                          i);
                    if (subV >
                          subsampleV) {
                        subsampleV =
                          subV;
                    }
                }
            }
            fields.
              add(
                new org.apache.batik.ext.awt.image.codec.tiff.TIFFField(
                  TIFF_YCBCR_SUBSAMPLING,
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                    TIFF_SHORT,
                  2,
                  new char[] { subsampleH,
                  subsampleV }));
            fields.
              add(
                new org.apache.batik.ext.awt.image.codec.tiff.TIFFField(
                  TIFF_YCBCR_POSITIONING,
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                    TIFF_SHORT,
                  1,
                  new char[] { (char)
                                 (compression ==
                                    COMP_JPEG_TTN2
                                    ? 1
                                    : 2) }));
            long[][] refbw;
            if (compression ==
                  COMP_JPEG_TTN2) {
                refbw =
                  (new long[][] { { 0,
                   1 },
                   { 255,
                   1 },
                   { 128,
                   1 },
                   { 255,
                   1 },
                   { 128,
                   1 },
                   { 255,
                   1 } });
            }
            else {
                refbw =
                  (new long[][] { { 15,
                   1 },
                   { 235,
                   1 },
                   { 128,
                   1 },
                   { 240,
                   1 },
                   { 128,
                   1 },
                   { 240,
                   1 } });
            }
            fields.
              add(
                new org.apache.batik.ext.awt.image.codec.tiff.TIFFField(
                  TIFF_REF_BLACK_WHITE,
                  org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                    TIFF_RATIONAL,
                  6,
                  refbw));
        }
        org.apache.batik.ext.awt.image.codec.tiff.TIFFField[] extraFields =
          encodeParam.
          getExtraFields(
            );
        if (extraFields !=
              null) {
            java.util.List extantTags =
              new java.util.ArrayList(
              fields.
                size(
                  ));
            java.util.Iterator fieldIter =
              fields.
              iterator(
                );
            while (fieldIter.
                     hasNext(
                       )) {
                org.apache.batik.ext.awt.image.codec.tiff.TIFFField fld =
                  (org.apache.batik.ext.awt.image.codec.tiff.TIFFField)
                    fieldIter.
                    next(
                      );
                extantTags.
                  add(
                    new java.lang.Integer(
                      fld.
                        getTag(
                          )));
            }
            int numExtraFields =
              extraFields.
                length;
            for (int i =
                   0;
                 i <
                   numExtraFields;
                 i++) {
                org.apache.batik.ext.awt.image.codec.tiff.TIFFField fld =
                  extraFields[i];
                java.lang.Integer tagValue =
                  new java.lang.Integer(
                  fld.
                    getTag(
                      ));
                if (!extantTags.
                      contains(
                        tagValue)) {
                    fields.
                      add(
                        fld);
                    extantTags.
                      add(
                        tagValue);
                }
            }
        }
        int dirSize =
          getDirectorySize(
            fields);
        tileOffsets[0] =
          ifdOffset +
            dirSize;
        java.io.OutputStream outCache =
          null;
        byte[] compressBuf =
          null;
        java.io.File tempFile =
          null;
        int nextIFDOffset =
          0;
        boolean skipByte =
          false;
        java.util.zip.Deflater deflater =
          null;
        boolean jpegRGBToYCbCr =
          false;
        if (compression ==
              COMP_NONE) {
            int numBytesPadding =
              0;
            if (sampleSize[0] ==
                  16 &&
                  tileOffsets[0] %
                  2 !=
                  0) {
                numBytesPadding =
                  1;
                tileOffsets[0]++;
            }
            else
                if (sampleSize[0] ==
                      32 &&
                      tileOffsets[0] %
                      4 !=
                      0) {
                    numBytesPadding =
                      (int)
                        (4 -
                           tileOffsets[0] %
                           4);
                    tileOffsets[0] +=
                      numBytesPadding;
                }
            for (int i =
                   1;
                 i <
                   numTiles;
                 i++) {
                tileOffsets[i] =
                  tileOffsets[i -
                                1] +
                    tileByteCounts[i -
                                     1];
            }
            if (!isLast) {
                nextIFDOffset =
                  (int)
                    (tileOffsets[0] +
                       totalBytesOfData);
                if ((nextIFDOffset &
                       1) !=
                      0) {
                    nextIFDOffset++;
                    skipByte =
                      true;
                }
            }
            writeDirectory(
              ifdOffset,
              fields,
              nextIFDOffset);
            if (numBytesPadding !=
                  0) {
                for (int padding =
                       0;
                     padding <
                       numBytesPadding;
                     padding++) {
                    output.
                      write(
                        (byte)
                          0);
                }
            }
        }
        else {
            if (output instanceof org.apache.batik.ext.awt.image.codec.util.SeekableOutputStream) {
                ((org.apache.batik.ext.awt.image.codec.util.SeekableOutputStream)
                   output).
                  seek(
                    tileOffsets[0]);
            }
            else {
                outCache =
                  output;
                try {
                    tempFile =
                      java.io.File.
                        createTempFile(
                          "jai-SOS-",
                          ".tmp");
                    tempFile.
                      deleteOnExit(
                        );
                    java.io.RandomAccessFile raFile =
                      new java.io.RandomAccessFile(
                      tempFile,
                      "rw");
                    output =
                      new org.apache.batik.ext.awt.image.codec.util.SeekableOutputStream(
                        raFile);
                }
                catch (java.lang.Exception e) {
                    output =
                      new java.io.ByteArrayOutputStream(
                        (int)
                          totalBytesOfData);
                }
            }
            int bufSize =
              0;
            switch (compression) {
                case COMP_PACKBITS:
                    bufSize =
                      (int)
                        (bytesPerTile +
                           (bytesPerRow +
                              127) /
                           128 *
                           tileHeight);
                    break;
                case COMP_JPEG_TTN2:
                    bufSize =
                      0;
                    if (imageType ==
                          TIFF_YCBCR &&
                          colorModel !=
                          null &&
                          colorModel.
                          getColorSpace(
                            ).
                          getType(
                            ) ==
                          java.awt.color.ColorSpace.
                            TYPE_RGB) {
                        jpegRGBToYCbCr =
                          true;
                    }
                    break;
                case COMP_DEFLATE:
                    bufSize =
                      (int)
                        bytesPerTile;
                    deflater =
                      new java.util.zip.Deflater(
                        encodeParam.
                          getDeflateLevel(
                            ));
                    break;
                default:
                    bufSize =
                      0;
            }
            if (bufSize !=
                  0) {
                compressBuf =
                  (new byte[bufSize]);
            }
        }
        int[] pixels =
          null;
        float[] fpixels =
          null;
        boolean checkContiguous =
          sampleSize[0] ==
          1 &&
          sampleModel instanceof java.awt.image.MultiPixelPackedSampleModel &&
          dataType ==
          java.awt.image.DataBuffer.
            TYPE_BYTE ||
          sampleSize[0] ==
          8 &&
          sampleModel instanceof java.awt.image.ComponentSampleModel;
        byte[] bpixels =
          null;
        if (compression !=
              COMP_JPEG_TTN2) {
            if (dataType ==
                  java.awt.image.DataBuffer.
                    TYPE_BYTE) {
                bpixels =
                  (new byte[tileHeight *
                              tileWidth *
                              numBands]);
            }
            else
                if (dataTypeIsShort) {
                    bpixels =
                      (new byte[2 *
                                  tileHeight *
                                  tileWidth *
                                  numBands]);
                }
                else
                    if (dataType ==
                          java.awt.image.DataBuffer.
                            TYPE_INT ||
                          dataType ==
                          java.awt.image.DataBuffer.
                            TYPE_FLOAT) {
                        bpixels =
                          (new byte[4 *
                                      tileHeight *
                                      tileWidth *
                                      numBands]);
                    }
        }
        int lastRow =
          minY +
          height;
        int lastCol =
          minX +
          width;
        int tileNum =
          0;
        for (int row =
               minY;
             row <
               lastRow;
             row +=
               tileHeight) {
            int rows =
              isTiled
              ? tileHeight
              : java.lang.Math.
              min(
                tileHeight,
                lastRow -
                  row);
            int size =
              rows *
              tileWidth *
              numBands;
            for (int col =
                   minX;
                 col <
                   lastCol;
                 col +=
                   tileWidth) {
                java.awt.image.Raster src =
                  im.
                  getData(
                    new java.awt.Rectangle(
                      col,
                      row,
                      tileWidth,
                      rows));
                boolean useDataBuffer =
                  false;
                if (compression !=
                      COMP_JPEG_TTN2) {
                    if (checkContiguous) {
                        if (sampleSize[0] ==
                              8) {
                            java.awt.image.ComponentSampleModel csm =
                              (java.awt.image.ComponentSampleModel)
                                src.
                                getSampleModel(
                                  );
                            int[] bankIndices =
                              csm.
                              getBankIndices(
                                );
                            int[] bandOffsets =
                              csm.
                              getBandOffsets(
                                );
                            int pixelStride =
                              csm.
                              getPixelStride(
                                );
                            int lineStride =
                              csm.
                              getScanlineStride(
                                );
                            if (pixelStride !=
                                  numBands ||
                                  lineStride !=
                                  bytesPerRow) {
                                useDataBuffer =
                                  false;
                            }
                            else {
                                useDataBuffer =
                                  true;
                                for (int i =
                                       0;
                                     useDataBuffer &&
                                       i <
                                       numBands;
                                     i++) {
                                    if (bankIndices[i] !=
                                          0 ||
                                          bandOffsets[i] !=
                                          i) {
                                        useDataBuffer =
                                          false;
                                    }
                                }
                            }
                        }
                        else {
                            java.awt.image.MultiPixelPackedSampleModel mpp =
                              (java.awt.image.MultiPixelPackedSampleModel)
                                src.
                                getSampleModel(
                                  );
                            if (mpp.
                                  getNumBands(
                                    ) ==
                                  1 &&
                                  mpp.
                                  getDataBitOffset(
                                    ) ==
                                  0 &&
                                  mpp.
                                  getPixelBitStride(
                                    ) ==
                                  1) {
                                useDataBuffer =
                                  true;
                            }
                        }
                    }
                    if (!useDataBuffer) {
                        if (dataType ==
                              java.awt.image.DataBuffer.
                                TYPE_FLOAT) {
                            fpixels =
                              src.
                                getPixels(
                                  col,
                                  row,
                                  tileWidth,
                                  rows,
                                  fpixels);
                        }
                        else {
                            pixels =
                              src.
                                getPixels(
                                  col,
                                  row,
                                  tileWidth,
                                  rows,
                                  pixels);
                        }
                    }
                }
                int index;
                int pixel =
                  0;
                int k =
                  0;
                switch (sampleSize[0]) {
                    case 1:
                        if (useDataBuffer) {
                            byte[] btmp =
                              ((java.awt.image.DataBufferByte)
                                 src.
                                 getDataBuffer(
                                   )).
                              getData(
                                );
                            java.awt.image.MultiPixelPackedSampleModel mpp =
                              (java.awt.image.MultiPixelPackedSampleModel)
                                src.
                                getSampleModel(
                                  );
                            int lineStride =
                              mpp.
                              getScanlineStride(
                                );
                            int inOffset =
                              mpp.
                              getOffset(
                                col -
                                  src.
                                  getSampleModelTranslateX(
                                    ),
                                row -
                                  src.
                                  getSampleModelTranslateY(
                                    ));
                            if (lineStride ==
                                  (int)
                                    bytesPerRow) {
                                java.lang.System.
                                  arraycopy(
                                    btmp,
                                    inOffset,
                                    bpixels,
                                    0,
                                    (int)
                                      bytesPerRow *
                                      rows);
                            }
                            else {
                                int outOffset =
                                  0;
                                for (int j =
                                       0;
                                     j <
                                       rows;
                                     j++) {
                                    java.lang.System.
                                      arraycopy(
                                        btmp,
                                        inOffset,
                                        bpixels,
                                        outOffset,
                                        (int)
                                          bytesPerRow);
                                    inOffset +=
                                      lineStride;
                                    outOffset +=
                                      (int)
                                        bytesPerRow;
                                }
                            }
                        }
                        else {
                            index =
                              0;
                            for (int i =
                                   0;
                                 i <
                                   rows;
                                 i++) {
                                for (int j =
                                       0;
                                     j <
                                       tileWidth /
                                       8;
                                     j++) {
                                    pixel =
                                      pixels[index++] <<
                                        7 |
                                        pixels[index++] <<
                                        6 |
                                        pixels[index++] <<
                                        5 |
                                        pixels[index++] <<
                                        4 |
                                        pixels[index++] <<
                                        3 |
                                        pixels[index++] <<
                                        2 |
                                        pixels[index++] <<
                                        1 |
                                        pixels[index++];
                                    bpixels[k++] =
                                      (byte)
                                        pixel;
                                }
                                if (tileWidth %
                                      8 >
                                      0) {
                                    pixel =
                                      0;
                                    for (int j =
                                           0;
                                         j <
                                           tileWidth %
                                           8;
                                         j++) {
                                        pixel |=
                                          pixels[index++] <<
                                            7 -
                                            j;
                                    }
                                    bpixels[k++] =
                                      (byte)
                                        pixel;
                                }
                            }
                        }
                        if (compression ==
                              COMP_NONE) {
                            output.
                              write(
                                bpixels,
                                0,
                                rows *
                                  ((tileWidth +
                                      7) /
                                     8));
                        }
                        else
                            if (compression ==
                                  COMP_PACKBITS) {
                                int numCompressedBytes =
                                  compressPackBits(
                                    bpixels,
                                    rows,
                                    (int)
                                      bytesPerRow,
                                    compressBuf);
                                tileByteCounts[tileNum++] =
                                  numCompressedBytes;
                                output.
                                  write(
                                    compressBuf,
                                    0,
                                    numCompressedBytes);
                            }
                            else
                                if (compression ==
                                      COMP_DEFLATE) {
                                    int numCompressedBytes =
                                      deflate(
                                        deflater,
                                        bpixels,
                                        compressBuf);
                                    tileByteCounts[tileNum++] =
                                      numCompressedBytes;
                                    output.
                                      write(
                                        compressBuf,
                                        0,
                                        numCompressedBytes);
                                }
                        break;
                    case 4:
                        index =
                          0;
                        for (int i =
                               0;
                             i <
                               rows;
                             i++) {
                            for (int j =
                                   0;
                                 j <
                                   tileWidth /
                                   2;
                                 j++) {
                                pixel =
                                  pixels[index++] <<
                                    4 |
                                    pixels[index++];
                                bpixels[k++] =
                                  (byte)
                                    pixel;
                            }
                            if ((tileWidth &
                                   1) ==
                                  1) {
                                pixel =
                                  pixels[index++] <<
                                    4;
                                bpixels[k++] =
                                  (byte)
                                    pixel;
                            }
                        }
                        if (compression ==
                              COMP_NONE) {
                            output.
                              write(
                                bpixels,
                                0,
                                rows *
                                  ((tileWidth +
                                      1) /
                                     2));
                        }
                        else
                            if (compression ==
                                  COMP_PACKBITS) {
                                int numCompressedBytes =
                                  compressPackBits(
                                    bpixels,
                                    rows,
                                    (int)
                                      bytesPerRow,
                                    compressBuf);
                                tileByteCounts[tileNum++] =
                                  numCompressedBytes;
                                output.
                                  write(
                                    compressBuf,
                                    0,
                                    numCompressedBytes);
                            }
                            else
                                if (compression ==
                                      COMP_DEFLATE) {
                                    int numCompressedBytes =
                                      deflate(
                                        deflater,
                                        bpixels,
                                        compressBuf);
                                    tileByteCounts[tileNum++] =
                                      numCompressedBytes;
                                    output.
                                      write(
                                        compressBuf,
                                        0,
                                        numCompressedBytes);
                                }
                        break;
                    case 8:
                        if (compression !=
                              COMP_JPEG_TTN2) {
                            if (useDataBuffer) {
                                byte[] btmp =
                                  ((java.awt.image.DataBufferByte)
                                     src.
                                     getDataBuffer(
                                       )).
                                  getData(
                                    );
                                java.awt.image.ComponentSampleModel csm =
                                  (java.awt.image.ComponentSampleModel)
                                    src.
                                    getSampleModel(
                                      );
                                int inOffset =
                                  csm.
                                  getOffset(
                                    col -
                                      src.
                                      getSampleModelTranslateX(
                                        ),
                                    row -
                                      src.
                                      getSampleModelTranslateY(
                                        ));
                                int lineStride =
                                  csm.
                                  getScanlineStride(
                                    );
                                if (lineStride ==
                                      (int)
                                        bytesPerRow) {
                                    java.lang.System.
                                      arraycopy(
                                        btmp,
                                        inOffset,
                                        bpixels,
                                        0,
                                        (int)
                                          bytesPerRow *
                                          rows);
                                }
                                else {
                                    int outOffset =
                                      0;
                                    for (int j =
                                           0;
                                         j <
                                           rows;
                                         j++) {
                                        java.lang.System.
                                          arraycopy(
                                            btmp,
                                            inOffset,
                                            bpixels,
                                            outOffset,
                                            (int)
                                              bytesPerRow);
                                        inOffset +=
                                          lineStride;
                                        outOffset +=
                                          (int)
                                            bytesPerRow;
                                    }
                                }
                            }
                            else {
                                for (int i =
                                       0;
                                     i <
                                       size;
                                     i++) {
                                    bpixels[i] =
                                      (byte)
                                        pixels[i];
                                }
                            }
                        }
                        if (compression ==
                              COMP_NONE) {
                            output.
                              write(
                                bpixels,
                                0,
                                size);
                        }
                        else
                            if (compression ==
                                  COMP_PACKBITS) {
                                int numCompressedBytes =
                                  compressPackBits(
                                    bpixels,
                                    rows,
                                    (int)
                                      bytesPerRow,
                                    compressBuf);
                                tileByteCounts[tileNum++] =
                                  numCompressedBytes;
                                output.
                                  write(
                                    compressBuf,
                                    0,
                                    numCompressedBytes);
                            }
                            else
                                if (compression ==
                                      COMP_JPEG_TTN2) {
                                    long startPos =
                                      getOffset(
                                        output);
                                    if (jpegEncoder ==
                                          null ||
                                          jpegEncodeParam.
                                          getWidth(
                                            ) !=
                                          src.
                                          getWidth(
                                            ) ||
                                          jpegEncodeParam.
                                          getHeight(
                                            ) !=
                                          src.
                                          getHeight(
                                            )) {
                                        jpegEncodeParam =
                                          com.sun.image.codec.jpeg.JPEGCodec.
                                            getDefaultJPEGEncodeParam(
                                              src,
                                              jpegColorID);
                                        modifyEncodeParam(
                                          jep,
                                          jpegEncodeParam,
                                          numBands);
                                        jpegEncoder =
                                          com.sun.image.codec.jpeg.JPEGCodec.
                                            createJPEGEncoder(
                                              output,
                                              jpegEncodeParam);
                                    }
                                    if (jpegRGBToYCbCr) {
                                        java.awt.image.WritableRaster wRas =
                                          null;
                                        if (src instanceof java.awt.image.WritableRaster) {
                                            wRas =
                                              (java.awt.image.WritableRaster)
                                                src;
                                        }
                                        else {
                                            wRas =
                                              src.
                                                createCompatibleWritableRaster(
                                                  );
                                            wRas.
                                              setRect(
                                                src);
                                        }
                                        if (wRas.
                                              getMinX(
                                                ) !=
                                              0 ||
                                              wRas.
                                              getMinY(
                                                ) !=
                                              0) {
                                            wRas =
                                              wRas.
                                                createWritableTranslatedChild(
                                                  0,
                                                  0);
                                        }
                                        java.awt.image.BufferedImage bi =
                                          new java.awt.image.BufferedImage(
                                          colorModel,
                                          wRas,
                                          false,
                                          null);
                                        jpegEncoder.
                                          encode(
                                            bi);
                                    }
                                    else {
                                        jpegEncoder.
                                          encode(
                                            src.
                                              createTranslatedChild(
                                                0,
                                                0));
                                    }
                                    long endPos =
                                      getOffset(
                                        output);
                                    tileByteCounts[tileNum++] =
                                      (int)
                                        (endPos -
                                           startPos);
                                }
                                else
                                    if (compression ==
                                          COMP_DEFLATE) {
                                        int numCompressedBytes =
                                          deflate(
                                            deflater,
                                            bpixels,
                                            compressBuf);
                                        tileByteCounts[tileNum++] =
                                          numCompressedBytes;
                                        output.
                                          write(
                                            compressBuf,
                                            0,
                                            numCompressedBytes);
                                    }
                        break;
                    case 16:
                        int ls =
                          0;
                        for (int i =
                               0;
                             i <
                               size;
                             i++) {
                            int value =
                              pixels[i];
                            bpixels[ls++] =
                              (byte)
                                ((value &
                                    65280) >>
                                   8);
                            bpixels[ls++] =
                              (byte)
                                (value &
                                   255);
                        }
                        if (compression ==
                              COMP_NONE) {
                            output.
                              write(
                                bpixels,
                                0,
                                size *
                                  2);
                        }
                        else
                            if (compression ==
                                  COMP_PACKBITS) {
                                int numCompressedBytes =
                                  compressPackBits(
                                    bpixels,
                                    rows,
                                    (int)
                                      bytesPerRow,
                                    compressBuf);
                                tileByteCounts[tileNum++] =
                                  numCompressedBytes;
                                output.
                                  write(
                                    compressBuf,
                                    0,
                                    numCompressedBytes);
                            }
                            else
                                if (compression ==
                                      COMP_DEFLATE) {
                                    int numCompressedBytes =
                                      deflate(
                                        deflater,
                                        bpixels,
                                        compressBuf);
                                    tileByteCounts[tileNum++] =
                                      numCompressedBytes;
                                    output.
                                      write(
                                        compressBuf,
                                        0,
                                        numCompressedBytes);
                                }
                        break;
                    case 32:
                        if (dataType ==
                              java.awt.image.DataBuffer.
                                TYPE_INT) {
                            int li =
                              0;
                            for (int i =
                                   0;
                                 i <
                                   size;
                                 i++) {
                                int value =
                                  pixels[i];
                                bpixels[li++] =
                                  (byte)
                                    ((value &
                                        -16777216) >>>
                                       24);
                                bpixels[li++] =
                                  (byte)
                                    ((value &
                                        16711680) >>>
                                       16);
                                bpixels[li++] =
                                  (byte)
                                    ((value &
                                        65280) >>>
                                       8);
                                bpixels[li++] =
                                  (byte)
                                    (value &
                                       255);
                            }
                        }
                        else {
                            int lf =
                              0;
                            for (int i =
                                   0;
                                 i <
                                   size;
                                 i++) {
                                int value =
                                  java.lang.Float.
                                  floatToIntBits(
                                    fpixels[i]);
                                bpixels[lf++] =
                                  (byte)
                                    ((value &
                                        -16777216) >>>
                                       24);
                                bpixels[lf++] =
                                  (byte)
                                    ((value &
                                        16711680) >>>
                                       16);
                                bpixels[lf++] =
                                  (byte)
                                    ((value &
                                        65280) >>>
                                       8);
                                bpixels[lf++] =
                                  (byte)
                                    (value &
                                       255);
                            }
                        }
                        if (compression ==
                              COMP_NONE) {
                            output.
                              write(
                                bpixels,
                                0,
                                size *
                                  4);
                        }
                        else
                            if (compression ==
                                  COMP_PACKBITS) {
                                int numCompressedBytes =
                                  compressPackBits(
                                    bpixels,
                                    rows,
                                    (int)
                                      bytesPerRow,
                                    compressBuf);
                                tileByteCounts[tileNum++] =
                                  numCompressedBytes;
                                output.
                                  write(
                                    compressBuf,
                                    0,
                                    numCompressedBytes);
                            }
                            else
                                if (compression ==
                                      COMP_DEFLATE) {
                                    int numCompressedBytes =
                                      deflate(
                                        deflater,
                                        bpixels,
                                        compressBuf);
                                    tileByteCounts[tileNum++] =
                                      numCompressedBytes;
                                    output.
                                      write(
                                        compressBuf,
                                        0,
                                        numCompressedBytes);
                                }
                        break;
                }
            }
        }
        if (compression ==
              COMP_NONE) {
            if (skipByte) {
                output.
                  write(
                    (byte)
                      0);
            }
        }
        else {
            int totalBytes =
              0;
            for (int i =
                   1;
                 i <
                   numTiles;
                 i++) {
                int numBytes =
                  (int)
                    tileByteCounts[i -
                                     1];
                totalBytes +=
                  numBytes;
                tileOffsets[i] =
                  tileOffsets[i -
                                1] +
                    numBytes;
            }
            totalBytes +=
              (int)
                tileByteCounts[numTiles -
                                 1];
            nextIFDOffset =
              isLast
                ? 0
                : ifdOffset +
                dirSize +
                totalBytes;
            if ((nextIFDOffset &
                   1) !=
                  0) {
                nextIFDOffset++;
                skipByte =
                  true;
            }
            if (outCache ==
                  null) {
                if (skipByte) {
                    output.
                      write(
                        (byte)
                          0);
                }
                org.apache.batik.ext.awt.image.codec.util.SeekableOutputStream sos =
                  (org.apache.batik.ext.awt.image.codec.util.SeekableOutputStream)
                    output;
                long savePos =
                  sos.
                  getFilePointer(
                    );
                sos.
                  seek(
                    ifdOffset);
                writeDirectory(
                  ifdOffset,
                  fields,
                  nextIFDOffset);
                sos.
                  seek(
                    savePos);
            }
            else
                if (tempFile !=
                      null) {
                    java.io.FileInputStream fileStream =
                      new java.io.FileInputStream(
                      tempFile);
                    output.
                      close(
                        );
                    output =
                      outCache;
                    writeDirectory(
                      ifdOffset,
                      fields,
                      nextIFDOffset);
                    byte[] copyBuffer =
                      new byte[8192];
                    int bytesCopied =
                      0;
                    while (bytesCopied <
                             totalBytes) {
                        int bytesRead =
                          fileStream.
                          read(
                            copyBuffer);
                        if (bytesRead ==
                              -1) {
                            break;
                        }
                        output.
                          write(
                            copyBuffer,
                            0,
                            bytesRead);
                        bytesCopied +=
                          bytesRead;
                    }
                    fileStream.
                      close(
                        );
                    tempFile.
                      delete(
                        );
                    if (skipByte) {
                        output.
                          write(
                            (byte)
                              0);
                    }
                }
                else
                    if (output instanceof java.io.ByteArrayOutputStream) {
                        java.io.ByteArrayOutputStream memoryStream =
                          (java.io.ByteArrayOutputStream)
                            output;
                        output =
                          outCache;
                        writeDirectory(
                          ifdOffset,
                          fields,
                          nextIFDOffset);
                        memoryStream.
                          writeTo(
                            output);
                        if (skipByte) {
                            output.
                              write(
                                (byte)
                                  0);
                        }
                    }
                    else {
                        throw new java.lang.IllegalStateException(
                          );
                    }
        }
        return nextIFDOffset;
    }
    private int getDirectorySize(java.util.SortedSet fields) {
        int numEntries =
          fields.
          size(
            );
        int dirSize =
          2 +
          numEntries *
          12 +
          4;
        java.util.Iterator iter =
          fields.
          iterator(
            );
        while (iter.
                 hasNext(
                   )) {
            org.apache.batik.ext.awt.image.codec.tiff.TIFFField field =
              (org.apache.batik.ext.awt.image.codec.tiff.TIFFField)
                iter.
                next(
                  );
            int valueSize =
              field.
              getCount(
                ) *
              sizeOfType[field.
                           getType(
                             )];
            if (valueSize >
                  4) {
                dirSize +=
                  valueSize;
            }
        }
        return dirSize;
    }
    private void writeFileHeader() throws java.io.IOException {
        output.
          write(
            'M');
        output.
          write(
            'M');
        output.
          write(
            0);
        output.
          write(
            42);
        writeLong(
          8);
    }
    private void writeDirectory(int thisIFDOffset,
                                java.util.SortedSet fields,
                                int nextIFDOffset)
          throws java.io.IOException { int numEntries =
                                         fields.
                                         size(
                                           );
                                       long offsetBeyondIFD =
                                         thisIFDOffset +
                                         12 *
                                         numEntries +
                                         4 +
                                         2;
                                       java.util.List tooBig =
                                         new java.util.ArrayList(
                                         );
                                       writeUnsignedShort(
                                         numEntries);
                                       java.util.Iterator iter =
                                         fields.
                                         iterator(
                                           );
                                       while (iter.
                                                hasNext(
                                                  )) {
                                           org.apache.batik.ext.awt.image.codec.tiff.TIFFField field =
                                             (org.apache.batik.ext.awt.image.codec.tiff.TIFFField)
                                               iter.
                                               next(
                                                 );
                                           int tag =
                                             field.
                                             getTag(
                                               );
                                           writeUnsignedShort(
                                             tag);
                                           int type =
                                             field.
                                             getType(
                                               );
                                           writeUnsignedShort(
                                             type);
                                           int count =
                                             field.
                                             getCount(
                                               );
                                           int valueSize =
                                             getValueSize(
                                               field);
                                           writeLong(
                                             type ==
                                               org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                                                 TIFF_ASCII
                                               ? valueSize
                                               : count);
                                           if (valueSize >
                                                 4) {
                                               writeLong(
                                                 offsetBeyondIFD);
                                               offsetBeyondIFD +=
                                                 valueSize;
                                               tooBig.
                                                 add(
                                                   field);
                                           }
                                           else {
                                               writeValuesAsFourBytes(
                                                 field);
                                           }
                                       }
                                       writeLong(
                                         nextIFDOffset);
                                       for (int i =
                                              0;
                                            i <
                                              tooBig.
                                              size(
                                                );
                                            i++) {
                                           writeValues(
                                             (org.apache.batik.ext.awt.image.codec.tiff.TIFFField)
                                               tooBig.
                                               get(
                                                 i));
                                       } }
    private static int getValueSize(org.apache.batik.ext.awt.image.codec.tiff.TIFFField field) {
        int type =
          field.
          getType(
            );
        int count =
          field.
          getCount(
            );
        int valueSize =
          0;
        if (type ==
              org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                TIFF_ASCII) {
            for (int i =
                   0;
                 i <
                   count;
                 i++) {
                byte[] stringBytes =
                  field.
                  getAsString(
                    i).
                  getBytes(
                    );
                valueSize +=
                  stringBytes.
                    length;
                if (stringBytes[stringBytes.
                                  length -
                                  1] !=
                      0) {
                    valueSize++;
                }
            }
        }
        else {
            valueSize =
              count *
                sizeOfType[type];
        }
        return valueSize;
    }
    private static final int[] sizeOfType =
      { 0,
    1,
    1,
    2,
    4,
    8,
    1,
    1,
    2,
    4,
    8,
    4,
    8 };
    private void writeValuesAsFourBytes(org.apache.batik.ext.awt.image.codec.tiff.TIFFField field)
          throws java.io.IOException { int dataType =
                                         field.
                                         getType(
                                           );
                                       int count =
                                         field.
                                         getCount(
                                           );
                                       switch (dataType) {
                                           case org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                                                  TIFF_BYTE:
                                               byte[] bytes =
                                                 field.
                                                 getAsBytes(
                                                   );
                                               if (count >
                                                     4)
                                                   count =
                                                     4;
                                               for (int i =
                                                      0;
                                                    i <
                                                      count;
                                                    i++)
                                                   output.
                                                     write(
                                                       bytes[i]);
                                               for (int i =
                                                      0;
                                                    i <
                                                      4 -
                                                      count;
                                                    i++)
                                                   output.
                                                     write(
                                                       0);
                                               break;
                                           case org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                                                  TIFF_SHORT:
                                               char[] chars =
                                                 field.
                                                 getAsChars(
                                                   );
                                               if (count >
                                                     2)
                                                   count =
                                                     2;
                                               for (int i =
                                                      0;
                                                    i <
                                                      count;
                                                    i++)
                                                   writeUnsignedShort(
                                                     chars[i]);
                                               for (int i =
                                                      0;
                                                    i <
                                                      2 -
                                                      count;
                                                    i++)
                                                   writeUnsignedShort(
                                                     0);
                                               break;
                                           case org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                                                  TIFF_LONG:
                                               long[] longs =
                                                 field.
                                                 getAsLongs(
                                                   );
                                               for (int i =
                                                      0;
                                                    i <
                                                      count;
                                                    i++) {
                                                   writeLong(
                                                     longs[i]);
                                               }
                                               break;
                                       } }
    private void writeValues(org.apache.batik.ext.awt.image.codec.tiff.TIFFField field)
          throws java.io.IOException { int dataType =
                                         field.
                                         getType(
                                           );
                                       int count =
                                         field.
                                         getCount(
                                           );
                                       switch (dataType) {
                                           case org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                                                  TIFF_BYTE:
                                           case org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                                                  TIFF_SBYTE:
                                           case org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                                                  TIFF_UNDEFINED:
                                               byte[] bytes =
                                                 field.
                                                 getAsBytes(
                                                   );
                                               for (int i =
                                                      0;
                                                    i <
                                                      count;
                                                    i++) {
                                                   output.
                                                     write(
                                                       bytes[i]);
                                               }
                                               break;
                                           case org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                                                  TIFF_SHORT:
                                               char[] chars =
                                                 field.
                                                 getAsChars(
                                                   );
                                               for (int i =
                                                      0;
                                                    i <
                                                      count;
                                                    i++) {
                                                   writeUnsignedShort(
                                                     chars[i]);
                                               }
                                               break;
                                           case org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                                                  TIFF_SSHORT:
                                               short[] shorts =
                                                 field.
                                                 getAsShorts(
                                                   );
                                               for (int i =
                                                      0;
                                                    i <
                                                      count;
                                                    i++) {
                                                   writeUnsignedShort(
                                                     shorts[i]);
                                               }
                                               break;
                                           case org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                                                  TIFF_LONG:
                                           case org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                                                  TIFF_SLONG:
                                               long[] longs =
                                                 field.
                                                 getAsLongs(
                                                   );
                                               for (int i =
                                                      0;
                                                    i <
                                                      count;
                                                    i++) {
                                                   writeLong(
                                                     longs[i]);
                                               }
                                               break;
                                           case org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                                                  TIFF_FLOAT:
                                               float[] floats =
                                                 field.
                                                 getAsFloats(
                                                   );
                                               for (int i =
                                                      0;
                                                    i <
                                                      count;
                                                    i++) {
                                                   int intBits =
                                                     java.lang.Float.
                                                     floatToIntBits(
                                                       floats[i]);
                                                   writeLong(
                                                     intBits);
                                               }
                                               break;
                                           case org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                                                  TIFF_DOUBLE:
                                               double[] doubles =
                                                 field.
                                                 getAsDoubles(
                                                   );
                                               for (int i =
                                                      0;
                                                    i <
                                                      count;
                                                    i++) {
                                                   long longBits =
                                                     java.lang.Double.
                                                     doubleToLongBits(
                                                       doubles[i]);
                                                   writeLong(
                                                     longBits >>>
                                                       32);
                                                   writeLong(
                                                     longBits &
                                                       4294967295L);
                                               }
                                               break;
                                           case org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                                                  TIFF_RATIONAL:
                                           case org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                                                  TIFF_SRATIONAL:
                                               long[][] rationals =
                                                 field.
                                                 getAsRationals(
                                                   );
                                               for (int i =
                                                      0;
                                                    i <
                                                      count;
                                                    i++) {
                                                   writeLong(
                                                     rationals[i][0]);
                                                   writeLong(
                                                     rationals[i][1]);
                                               }
                                               break;
                                           case org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
                                                  TIFF_ASCII:
                                               for (int i =
                                                      0;
                                                    i <
                                                      count;
                                                    i++) {
                                                   byte[] stringBytes =
                                                     field.
                                                     getAsString(
                                                       i).
                                                     getBytes(
                                                       );
                                                   output.
                                                     write(
                                                       stringBytes);
                                                   if (stringBytes[stringBytes.
                                                                     length -
                                                                     1] !=
                                                         (byte)
                                                           0) {
                                                       output.
                                                         write(
                                                           (byte)
                                                             0);
                                                   }
                                               }
                                               break;
                                           default:
                                               throw new java.lang.Error(
                                                 "TIFFImageEncoder10");
                                       } }
    private void writeUnsignedShort(int s)
          throws java.io.IOException { output.
                                         write(
                                           (s &
                                              65280) >>>
                                             8);
                                       output.
                                         write(
                                           s &
                                             255);
    }
    private void writeLong(long l) throws java.io.IOException {
        output.
          write(
            (int)
              ((l &
                  -16777216) >>>
                 24));
        output.
          write(
            (int)
              ((l &
                  16711680) >>>
                 16));
        output.
          write(
            (int)
              ((l &
                  65280) >>>
                 8));
        output.
          write(
            (int)
              (l &
                 255));
    }
    private long getOffset(java.io.OutputStream out)
          throws java.io.IOException { if (out instanceof java.io.ByteArrayOutputStream) {
                                           return ((java.io.ByteArrayOutputStream)
                                                     out).
                                             size(
                                               );
                                       }
                                       else
                                           if (out instanceof org.apache.batik.ext.awt.image.codec.util.SeekableOutputStream) {
                                               return ((org.apache.batik.ext.awt.image.codec.util.SeekableOutputStream)
                                                         out).
                                                 getFilePointer(
                                                   );
                                           }
                                           else {
                                               throw new java.lang.IllegalStateException(
                                                 );
                                           }
    }
    private static int compressPackBits(byte[] data,
                                        int numRows,
                                        int bytesPerRow,
                                        byte[] compData) {
        int inOffset =
          0;
        int outOffset =
          0;
        for (int i =
               0;
             i <
               numRows;
             i++) {
            outOffset =
              packBits(
                data,
                inOffset,
                bytesPerRow,
                compData,
                outOffset);
            inOffset +=
              bytesPerRow;
        }
        return outOffset;
    }
    private static int packBits(byte[] input,
                                int inOffset,
                                int inCount,
                                byte[] output,
                                int outOffset) {
        int inMax =
          inOffset +
          inCount -
          1;
        int inMaxMinus1 =
          inMax -
          1;
        while (inOffset <=
                 inMax) {
            int run =
              1;
            byte replicate =
              input[inOffset];
            while (run <
                     127 &&
                     inOffset <
                     inMax &&
                     input[inOffset] ==
                     input[inOffset +
                             1]) {
                run++;
                inOffset++;
            }
            if (run >
                  1) {
                inOffset++;
                output[outOffset++] =
                  (byte)
                    -(run -
                        1);
                output[outOffset++] =
                  replicate;
            }
            run =
              0;
            int saveOffset =
              outOffset;
            while (run <
                     128 &&
                     (inOffset <
                        inMax &&
                        input[inOffset] !=
                        input[inOffset +
                                1] ||
                        inOffset <
                        inMaxMinus1 &&
                        input[inOffset] !=
                        input[inOffset +
                                2])) {
                run++;
                output[++outOffset] =
                  input[inOffset++];
            }
            if (run >
                  0) {
                output[saveOffset] =
                  (byte)
                    (run -
                       1);
                outOffset++;
            }
            if (inOffset ==
                  inMax) {
                if (run >
                      0 &&
                      run <
                      128) {
                    output[saveOffset]++;
                    output[outOffset++] =
                      input[inOffset++];
                }
                else {
                    output[outOffset++] =
                      (byte)
                        0;
                    output[outOffset++] =
                      input[inOffset++];
                }
            }
        }
        return outOffset;
    }
    private static int deflate(java.util.zip.Deflater deflater,
                               byte[] inflated,
                               byte[] deflated) {
        deflater.
          setInput(
            inflated);
        deflater.
          finish(
            );
        int numCompressedBytes =
          deflater.
          deflate(
            deflated);
        deflater.
          reset(
            );
        return numCompressedBytes;
    }
    private static void modifyEncodeParam(com.sun.image.codec.jpeg.JPEGEncodeParam src,
                                          com.sun.image.codec.jpeg.JPEGEncodeParam dst,
                                          int nbands) {
        dst.
          setDensityUnit(
            src.
              getDensityUnit(
                ));
        dst.
          setXDensity(
            src.
              getXDensity(
                ));
        dst.
          setYDensity(
            src.
              getYDensity(
                ));
        dst.
          setRestartInterval(
            src.
              getRestartInterval(
                ));
        for (int i =
               0;
             i <
               4;
             i++) {
            com.sun.image.codec.jpeg.JPEGQTable tbl =
              src.
              getQTable(
                i);
            if (tbl !=
                  null)
                dst.
                  setQTable(
                    i,
                    tbl);
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
      ("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" +
       "aiX2+Z65iQbIVp2psmhsU33mTFqKbCQ9");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("rB0YYDCzKrWyyA+T+rhOqVN+lajlRtB1mpydBbBSU9qqJA6kEe95YWMo65Bd" +
       "XXCtaqIhYAhe+crapwRODWtIsnXjsbjdAvd4Dol6Zk/qIq3KMBhfZxOVh+ea" +
       "0hqkw8ytRirsZVG73Bn129XmsNFsU9YmVBzMNSYiWmnDMQvDkNPYsGm8asO1" +
       "qYut1kEEXH6U1j3Eq6zhoKfAsIoFwSIWso1eSWIZrTNzf65bEBfq9ZWYKPxo" +
       "tfAMthqIWHNujbfCyFHggcwnbVOSBg2mQ9XKg4bcZOkmXJVJVNDwCfAhoT5H" +
       "eLEoY4LY7GrzsVHTJstymknqEoxhHXuRAg9nAGfl4WK4agkZM+MZTCB7Nhk5" +
       "Iw3H4KrpJ+PYJDveEGcriwSfrJEqKhmQvlb8Yb0nq2g9UrdGNqxTY6MXj1fG" +
       "CF/Vmj1nrtKiq3WtDUMQiwrZFEPLVIJhi5+mNXPGjGt0ozZol/stmTbwMjsV" +
       "cNiXIjrc6LUsndbryxmqT2tbHnw9qA2R7ZNyoy1iXKDXh8zWGNScYeCNw8TJ" +
       "VRbl9PJISA3R3ri6RVOatUQ6w1Wbng0qlsrFYg9fmfKIdpJN4BBZsxsKouFB" +
       "8yVp862uM6GBrwhMCviW9YCvunBmBFMfNzdlowOE2CXC1horc1wf7zPDpAJv" +
       "LfCxl82dqN3sSKNqGredmTiYmY1yf+OWO7BKZA5kd9VNXexRXn3phxkv1eX+" +
       "cuBZ1syZVRs6DU8NtjwIqjU7qhH6GE7SbR2qx5E+N9gusuZGLcFSieHKi/Vu" +
       "wM7qa4JgOjz4jrXo/gKq1ue2o0OwspkQG6oTcBFab3p+B4mixZJfrVOBbQDj" +
       "1oeB7ATzbchXrUa3ORxNOwMFd6zRGvEbujN2UG8oOjW/LC+aUxzu6KuNONb4" +
       "IYE22ow4menrwEeg0A8519NWieYpsj3j+KBi+fSYrqOUvqJxpuYMmsMFbM3G" +
       "WQPFGZFxmtZ24k+HUyKG11rTQMItxI5oRsM1wqthYmWyqoC6ZhI/iK3hBAyV" +
       "mccidky0u1I33ibqgG6H5JrNpJkP8TWeGjlJ1Otsux1LXfX6ojSzNDeJyHgw" +
       "8kQq2toy1lP8/raxjrTlJqPmYDzFtwazHqfCMBOysrsOG60OP+lCwzTkNxpM" +
       "hZ1xJWxNl57dw2pWhxnMQ3fdC3EC6KUzd/ksEZG2Uu9K6QZIBTyxBReHITps" +
       "uG5vmhreesKRi5Y66TdqYjZAB700cIfrNT2xwU/E9AchGD9UuDrouCvYVh06" +
       "RXkunmwlixGqY1PGm1iT5ik5UoeLALY20YzoitkiljbEWlnT0zopJ7baFbp9" +
       "m7HphtZVUGhBTKAG4ffSoYcOlnJztDRGjMlV2yNSW2BYKHHzWZuiGTrUXMVr" +
       "rTumu1LWdXmhUEa/l1VXEULGGPhuDr0y26qjkt0YzRkB1eA+yzJE0MdFS0t8" +
       "bOnzEeOiTr+c6psVLfRky1enpptCnjDiNvzGgjS3mojobDLQ+vOuNoqJQXnA" +
       "oOxsuu01eXsssFKlOycYGXYgdOG5TJgIbd2xY8EN1eGWmqzVmjDUK2VX2ZbH" +
       "8UJvdCiouhAwFe2qLkwL41mn3zI8sxeYyqq2AUZhiuuqEg437VhPW4rBdDJD" +
       "1FDKr5LSFN1Y0408mbbW7UAyIj6eG5SWkF6kEwMM3+CV6aTmuExrbSqiKQfV" +
       "zXTSrCmN7WID1zO5ma4Tb50uJrqTyX6H7RHg45ogVopveSo1aA84GNoIRssi" +
       "Iaq5HKzFGhySbSmCt7NaddyNx+PRyqzpQxVvTFWOTMA4FQ6TLK7Bdblj4mmj" +
       "HHKUxbOhtzLxFrtYzNqOuY4rdac5aPlUS5TDqQkxZqqJDdWMzLmWIfPRIOTn" +
       "xAqpCPWB0EB68XISujS3JBZzbrVswghHwoD7esvw3aXR2KIz3XUNaQXatsB3" +
       "M8P1aZMZqywQ92xh94X1ViRGvdoEn1PRLOgMligE2wsaUqklmUFi1BS31fpU" +
       "BHV3uJ7CByOtTueHg3rgSyqO9cXcj7qujNfleCWzo77rCFiFwTfA47E7c8/n" +
       "lx40cesaD6MbpVPt2IO0FiRxtUYbVcFf8921rtg9DlWsynAlRlSsU2PcpgJe" +
       "zWh1C1PQ0KlHejKlxlWHnfrrjrStbpF0vNiCwVoGHxY13+7A/hRCgKxOaljQ" +
       "Rte4uRnwNX0yZsLZllQsakrVokkZGlLrIWHFnN9oRn0om6LNDjyly/UtvtHM" +
       "8ZD0Jz2stRkHNpl6guasfV9QXFuOgDUdOYuOqhHNcigSXN3pTkatJJmMG6Ne" +
       "P9yuR7kHMG9FTBurqy1xWeu0YRtmq+22R8lNPWWGXOguxJYyc0VMCVb2rE2u" +
       "hfpoKjVtvVJrD4NGKjsB3fQb7VSoxY2lZ8Fe4GqhW6Y0I94Qrl7XNLFcsZez" +
       "3pjvrnxgV6OAasiGsDT9zjitWNza45IKrlik2+MqK2Usd+UJcL46DO1JDSfx" +
       "R7AuBZQR0e0ONq0vhHhFcf7YqM7CJRVXYpTQ1qMmx8LArZQXQ59NhQk2J3o1" +
       "ajDz1kvgig4raIY3CXSCyVA6W6KtcZZNmyyLbOcbl9/SMT+Cus0G2nXo2jhB" +
       "8qX8S++82HLNw8Xy09FhzaXdzispX2BFJj2xXHe0klzaL69fe8DvxPJ6kfPx" +
       "/fJbGJSevNEZzGIH+8c/9MKLOvuJ6sH+fMs0Kt0bef5X2cbGsE9U9WAev/T4" +
       "EYzieNXbwGPtYVinV/mPCb2OZcVWkbelZy1Bnlw2fn1UemOxrHZ8dIczXN0I" +
       "DL04t1MsLt6kgkcP135JFk81w8/XaIty4zzoR6XLRnH658wVtI1n6ceLluTN" +
       "Fs9OrnueYleR7THwfGTPro9clF3Umey6s8iQb4m+NDwkuXOxc4wnTj+tj1bw" +
       "T3HibtXzbEPZce59Z3M8f8UVGfJVx0vvOWLtca0FG997u2x8ulS6ay/8d50W" +
       "/ltk4/EWgGdusAWAU5JCca5q/2r8O7/2vdmnXtod6cj3h0Sl8o3OwV9/FD8/" +
       "N3nO5pUTJ6T/mHjny5/7PeHrDlXzNUdseCan+h3nseFa8S+Oo/BeEOVn3PND" +
       "J5eSoqPW5yzaZ3lgR6WHTCPqWoGRHxvb8lZ2ujud2+jOYlfMmwH+6Z6O6avT" +
       "nSfp+Ls3k9ZvyoMPRKUHk8CKjJ5lG31D0YvzZZemx3R+8HbprAH6jD2d+qtD" +
       "5x3HA1DRI5eCoybreQvvOmzqBk1eSg6DEl/8/7GbMeuFPPhoVHqgYNaRXJzi" +
       "1d+/DV69IU98FgD+vj3w77sAr4o9RLu9Y69kdKlfzFIW5xILNrx4jsB9fx58" +
       "V1S6HyjO7qDh9Urz3bcrTDBgzM/tGfRzr6oNzBv7voKQl24mDJ/Mgx+ISo8V" +
       "wlDQGiJhz4sDdBsVI+pJofjB26X5qwCtn9/T/Pm/Jpp/8mY0/1Qe/FhUes0J" +
       "mk8R+uO3Syiw7Jf3p0AvX3cK9HYJ3Wv6v7sZob+QBz8blR4pCJ26+WUoYPhY" +
       "gFHkFL0vvwojwGVyTy/5qndssyDnP96M3s/kwaeB91vQS+/2Tp0k81dug8zC" +
       "cX8CkLfftn75um3rt92tlYKK/3YzMn87D34DkAms0+6qkYJHx2T+5u3a7q8A" +
       "5Kl7MtULkHkz2713dYsm7z5q8o15C08DEv/1rsnd7+3veFUDSzcNCAXuHa8F" +
       "FvhucE3c3ViB5zqgjldrY+0raSY9yyO/U92b2LM3237+cLPtF89h9snNtnne" +
       "hwvzkMc+d/1G2zz50Tx4/fU7Zwsp2DVblM6DN54zRP7ZOe/+PA/+JA+e2SE5" +
       "J+9f7DaW8se4i+Q/OKfIX+bB70X5XQCOHxhhmN9ohFq7W6lOjNC/f7tq8CYg" +
       "/vFeDeJXUQ3uKnLddcjnk8SvD637wT035sDBfXlwR7S75ul6yg/uvF3KnwIU" +
       "f2JP+SdeRcr33u6h8/bY8adNZvlXusbcVqKd2/65I1k4eN05nMhF9uBB8HWr" +
       "78qeYsRDt8GIR/PEJmDAj+wZ8cm/Pka8DYjylTB2r3Fal75hXslPuV37eX/w" +
       "7LGQvPkc1rw1D56MSg8Xd7xsr63kxKh48NRFmJTuj9+dvDopvwfm8esuc9td" +
       "QKZ98sUH73nDi9Pf2J3FOLwk7F66dM88tu2T12qciF8Gej23Cs7du7tkwy9o" +
       "+qqo9PZX7PADC5v/5CQcfOWufCUqPfdKyuf74vPfk2XrUemp88uCUsXvyVKt" +
       "qPT4jUpFpTtAeDJ3Jyq97qzcICcIT+Z8F+iH0zlB+8XvyXzvjkr3HeeLSpd3" +
       "kZNZUFA7yJJHMf9QIm/tAp6AdHw73Q1ij59Qq91E6SM3E7QTU57PXjO/Ulwo" +
       "eHjmIh7tp3E+9SI1/IYvtj6xu+BJs5Usn/Eo3UOX7t7dNVVUmp/beOaGtR3W" +
       "dbn/9i898CP3vuVwpuaBHeBjFT+B7U1n36aEO35U3H+U/eQbfvxdP/Dibxf3" +
       "tPx/JxZVdOlRAAA=");
}
