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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Sq4398BLPM5b+2HnTw7efPk/HJTuXpQeUvYu6FSy47xjLoDbFR76pcBNveb9" +
       "tS7Uzl94/shEvvG0+TpR7WnjdTzMgHhOncfvO2WvviyX8rvB8559V37PaXtV" +
       "jDC7Ns4hXRkBj1HXgkd+7598/M++8cOdg7zD3LXJoQOpPHRMR8a5p/vNL33H" +
       "k6954Xc/WhiUvwZ/eaGDovpnivC5PPiKon3viEp3+4GxAb4KMDph4TlHgCfD" +
       "ley98clLuASev8qfHGmesHM1Hhns/Z2njxweHwyvD+WD5lWB5ASaplgegc9X" +
       "IjowHGBZN3uvD/rAI5+1vvcPf2Tn0Z3WmFPE2re88JG/vvKtLxyc8KOfvc6V" +
       "PZln50sXTfLaPCDyPvjMebUUOdD/9akP/MwPfeDDO1SPXOsVIuCj50f+y//7" +
       "1Svf9bu/coa7cQfw+HdDUB628gDeCbd7ww751deqS+7b7Ul3v6fUJY8gh+mL" +
       "G7R1Hh3nwSQP8EIGBPhEKJqrP8KRKYJfnQ1HPHJ1xF1dICyVU3CnoL/3FqD3" +
       "9tB750C/lEfk24Hex3uDyXnQlVuA3t9D758D/SCPmBeDfm8BHWN74llIrVtA" +
       "OtgjHZyDtEATXAzp/QVSuocjPI+cBTa8BbDwHix8Dtg780h2MbD3FGBZrH8W" +
       "0K+/BaDIHihyDtC78siHbqX9B4Q4OQvp37sFpOgeKXoO0st55CMXQ3pfgVQc" +
       "9AfsWVA/egtQsT1U7Byod+eRb7sY1NfshDpC8N6ZCvDtt4B1uMc6PAfrPXnk" +
       "e26lW2EIibCjwVlg//EFwVbAM9mDnZwDtjC0P3BBbR1QBH2VpMgzDcA/vQWk" +
       "+B4pfjMV+OGLIX2gQDqmEewqz5O1s+D+iwvCbYCH2MMlbgz3g4UZ+LGLwX1t" +
       "AZcGA1d/xHNnof3xW0BL7tGS56D9sTzy0xfU2QItjKB47+yh4GcuCPad4GH2" +
       "YJkbg7303jzy7y4GdueG7jSh18eRM6X7C7cAmN0DZm8M+OCRPPIfLwb4sWND" +
       "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" +
       "Ak0qKxFvczrhVJ2aWg/DedW3yg7oXn0h");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "d4q7Wv4/Q1ZeIu1RAAA=");
}
