package org.apache.batik.ext.awt.image.rendered;
public class MorphologyOp implements java.awt.image.BufferedImageOp, java.awt.image.RasterOp {
    private int radiusX;
    private int radiusY;
    private boolean doDilation;
    private final int rangeX;
    private final int rangeY;
    private final java.awt.color.ColorSpace sRGB = java.awt.color.ColorSpace.
      getInstance(
        java.awt.color.ColorSpace.
          CS_sRGB);
    private final java.awt.color.ColorSpace lRGB = java.awt.color.ColorSpace.
      getInstance(
        java.awt.color.ColorSpace.
          CS_LINEAR_RGB);
    public MorphologyOp(int radiusX, int radiusY, boolean doDilation) { super(
                                                                          );
                                                                        if (radiusX <=
                                                                              0 ||
                                                                              radiusY <=
                                                                              0) {
                                                                            throw new java.lang.IllegalArgumentException(
                                                                              ("The radius of X-axis or Y-axis should not be Zero or Negativ" +
                                                                               "es."));
                                                                        }
                                                                        else {
                                                                            this.
                                                                              radiusX =
                                                                              radiusX;
                                                                            this.
                                                                              radiusY =
                                                                              radiusY;
                                                                            this.
                                                                              doDilation =
                                                                              doDilation;
                                                                            rangeX =
                                                                              2 *
                                                                                radiusX +
                                                                                1;
                                                                            rangeY =
                                                                              2 *
                                                                                radiusY +
                                                                                1;
                                                                        }
    }
    public java.awt.geom.Rectangle2D getBounds2D(java.awt.image.Raster src) {
        checkCompatible(
          src.
            getSampleModel(
              ));
        return new java.awt.Rectangle(
          src.
            getMinX(
              ),
          src.
            getMinY(
              ),
          src.
            getWidth(
              ),
          src.
            getHeight(
              ));
    }
    public java.awt.geom.Rectangle2D getBounds2D(java.awt.image.BufferedImage src) {
        return new java.awt.Rectangle(
          0,
          0,
          src.
            getWidth(
              ),
          src.
            getHeight(
              ));
    }
    public java.awt.geom.Point2D getPoint2D(java.awt.geom.Point2D srcPt,
                                            java.awt.geom.Point2D destPt) {
        if (destPt ==
              null)
            destPt =
              new java.awt.geom.Point2D.Float(
                );
        destPt.
          setLocation(
            srcPt.
              getX(
                ),
            srcPt.
              getY(
                ));
        return destPt;
    }
    private void checkCompatible(java.awt.image.ColorModel colorModel,
                                 java.awt.image.SampleModel sampleModel) {
        java.awt.color.ColorSpace cs =
          colorModel.
          getColorSpace(
            );
        if (!cs.
              equals(
                sRGB) &&
              !cs.
              equals(
                lRGB))
            throw new java.lang.IllegalArgumentException(
              "Expected CS_sRGB or CS_LINEAR_RGB color model");
        if (!(colorModel instanceof java.awt.image.DirectColorModel))
            throw new java.lang.IllegalArgumentException(
              "colorModel should be an instance of DirectColorModel");
        if (sampleModel.
              getDataType(
                ) !=
              java.awt.image.DataBuffer.
                TYPE_INT)
            throw new java.lang.IllegalArgumentException(
              "colorModel\'s transferType should be DataBuffer.TYPE_INT");
        java.awt.image.DirectColorModel dcm =
          (java.awt.image.DirectColorModel)
            colorModel;
        if (dcm.
              getRedMask(
                ) !=
              16711680)
            throw new java.lang.IllegalArgumentException(
              "red mask in source should be 0x00ff0000");
        if (dcm.
              getGreenMask(
                ) !=
              65280)
            throw new java.lang.IllegalArgumentException(
              "green mask in source should be 0x0000ff00");
        if (dcm.
              getBlueMask(
                ) !=
              255)
            throw new java.lang.IllegalArgumentException(
              "blue mask in source should be 0x000000ff");
        if (dcm.
              getAlphaMask(
                ) !=
              -16777216)
            throw new java.lang.IllegalArgumentException(
              "alpha mask in source should be 0xff000000");
    }
    private boolean isCompatible(java.awt.image.ColorModel colorModel,
                                 java.awt.image.SampleModel sampleModel) {
        java.awt.color.ColorSpace cs =
          colorModel.
          getColorSpace(
            );
        if (cs !=
              java.awt.color.ColorSpace.
              getInstance(
                java.awt.color.ColorSpace.
                  CS_sRGB) &&
              cs !=
              java.awt.color.ColorSpace.
              getInstance(
                java.awt.color.ColorSpace.
                  CS_LINEAR_RGB))
            return false;
        if (!(colorModel instanceof java.awt.image.DirectColorModel))
            return false;
        if (sampleModel.
              getDataType(
                ) !=
              java.awt.image.DataBuffer.
                TYPE_INT)
            return false;
        java.awt.image.DirectColorModel dcm =
          (java.awt.image.DirectColorModel)
            colorModel;
        if (dcm.
              getRedMask(
                ) !=
              16711680)
            return false;
        if (dcm.
              getGreenMask(
                ) !=
              65280)
            return false;
        if (dcm.
              getBlueMask(
                ) !=
              255)
            return false;
        if (dcm.
              getAlphaMask(
                ) !=
              -16777216)
            return false;
        return true;
    }
    private void checkCompatible(java.awt.image.SampleModel model) {
        if (!(model instanceof java.awt.image.SinglePixelPackedSampleModel))
            throw new java.lang.IllegalArgumentException(
              "MorphologyOp only works with Rasters " +
              "using SinglePixelPackedSampleModels");
        int nBands =
          model.
          getNumBands(
            );
        if (nBands !=
              4)
            throw new java.lang.IllegalArgumentException(
              "MorphologyOp only words with Rasters having 4 bands");
        if (model.
              getDataType(
                ) !=
              java.awt.image.DataBuffer.
                TYPE_INT)
            throw new java.lang.IllegalArgumentException(
              "MorphologyOp only works with Rasters using DataBufferInt");
        int[] bitOffsets =
          ((java.awt.image.SinglePixelPackedSampleModel)
             model).
          getBitOffsets(
            );
        for (int i =
               0;
             i <
               bitOffsets.
                 length;
             i++) {
            if (bitOffsets[i] %
                  8 !=
                  0)
                throw new java.lang.IllegalArgumentException(
                  "MorphologyOp only works with Rasters using 8 bits " +
                  "per band : " +
                  i +
                  " : " +
                  bitOffsets[i]);
        }
    }
    public java.awt.RenderingHints getRenderingHints() {
        return null;
    }
    public java.awt.image.WritableRaster createCompatibleDestRaster(java.awt.image.Raster src) {
        checkCompatible(
          src.
            getSampleModel(
              ));
        return src.
          createCompatibleWritableRaster(
            );
    }
    public java.awt.image.BufferedImage createCompatibleDestImage(java.awt.image.BufferedImage src,
                                                                  java.awt.image.ColorModel destCM) {
        java.awt.image.BufferedImage dest =
          null;
        if (destCM ==
              null)
            destCM =
              src.
                getColorModel(
                  );
        java.awt.image.WritableRaster wr;
        wr =
          destCM.
            createCompatibleWritableRaster(
              src.
                getWidth(
                  ),
              src.
                getHeight(
                  ));
        checkCompatible(
          destCM,
          wr.
            getSampleModel(
              ));
        dest =
          new java.awt.image.BufferedImage(
            destCM,
            wr,
            destCM.
              isAlphaPremultiplied(
                ),
            null);
        return dest;
    }
    static final boolean isBetter(final int v1,
                                  final int v2,
                                  final boolean doDilation) {
        if (v1 >
              v2)
            return doDilation;
        if (v1 <
              v2)
            return !doDilation;
        return true;
    }
    private void specialProcessRow(java.awt.image.Raster src,
                                   java.awt.image.WritableRaster dest) {
        final int w =
          src.
          getWidth(
            );
        final int h =
          src.
          getHeight(
            );
        java.awt.image.DataBufferInt srcDB =
          (java.awt.image.DataBufferInt)
            src.
            getDataBuffer(
              );
        java.awt.image.DataBufferInt dstDB =
          (java.awt.image.DataBufferInt)
            dest.
            getDataBuffer(
              );
        java.awt.image.SinglePixelPackedSampleModel sppsm;
        sppsm =
          (java.awt.image.SinglePixelPackedSampleModel)
            src.
            getSampleModel(
              );
        final int srcOff =
          srcDB.
          getOffset(
            ) +
          sppsm.
          getOffset(
            src.
              getMinX(
                ) -
              src.
              getSampleModelTranslateX(
                ),
            src.
              getMinY(
                ) -
              src.
              getSampleModelTranslateY(
                ));
        sppsm =
          (java.awt.image.SinglePixelPackedSampleModel)
            dest.
            getSampleModel(
              );
        final int dstOff =
          dstDB.
          getOffset(
            ) +
          sppsm.
          getOffset(
            dest.
              getMinX(
                ) -
              dest.
              getSampleModelTranslateX(
                ),
            dest.
              getMinY(
                ) -
              dest.
              getSampleModelTranslateY(
                ));
        final int srcScanStride =
          ((java.awt.image.SinglePixelPackedSampleModel)
             src.
             getSampleModel(
               )).
          getScanlineStride(
            );
        final int dstScanStride =
          ((java.awt.image.SinglePixelPackedSampleModel)
             dest.
             getSampleModel(
               )).
          getScanlineStride(
            );
        final int[] srcPixels =
          srcDB.
          getBankData(
            )[0];
        final int[] destPixels =
          dstDB.
          getBankData(
            )[0];
        int sp;
        int dp;
        int bufferHead;
        int maxIndexA;
        int maxIndexR;
        int maxIndexG;
        int maxIndexB;
        int pel;
        int currentPixel;
        int lastPixel;
        int a;
        int r;
        int g;
        int b;
        int a1;
        int r1;
        int g1;
        int b1;
        if (w <=
              radiusX) {
            for (int i =
                   0;
                 i <
                   h;
                 i++) {
                sp =
                  srcOff +
                    i *
                    srcScanStride;
                dp =
                  dstOff +
                    i *
                    dstScanStride;
                pel =
                  srcPixels[sp++];
                a =
                  pel >>>
                    24;
                r =
                  pel &
                    16711680;
                g =
                  pel &
                    65280;
                b =
                  pel &
                    255;
                for (int k =
                       1;
                     k <
                       w;
                     k++) {
                    currentPixel =
                      srcPixels[sp++];
                    a1 =
                      currentPixel >>>
                        24;
                    r1 =
                      currentPixel &
                        16711680;
                    g1 =
                      currentPixel &
                        65280;
                    b1 =
                      currentPixel &
                        255;
                    if (isBetter(
                          a1,
                          a,
                          doDilation)) {
                        a =
                          a1;
                    }
                    if (isBetter(
                          r1,
                          r,
                          doDilation)) {
                        r =
                          r1;
                    }
                    if (isBetter(
                          g1,
                          g,
                          doDilation)) {
                        g =
                          g1;
                    }
                    if (isBetter(
                          b1,
                          b,
                          doDilation)) {
                        b =
                          b1;
                    }
                }
                for (int k =
                       0;
                     k <
                       w;
                     k++) {
                    destPixels[dp++] =
                      a <<
                        24 |
                        r |
                        g |
                        b;
                }
            }
        }
        else {
            final int[] bufferA =
              new int[w];
            final int[] bufferR =
              new int[w];
            final int[] bufferG =
              new int[w];
            final int[] bufferB =
              new int[w];
            for (int i =
                   0;
                 i <
                   h;
                 i++) {
                sp =
                  srcOff +
                    i *
                    srcScanStride;
                dp =
                  dstOff +
                    i *
                    dstScanStride;
                bufferHead =
                  0;
                maxIndexA =
                  0;
                maxIndexR =
                  0;
                maxIndexG =
                  0;
                maxIndexB =
                  0;
                pel =
                  srcPixels[sp++];
                a =
                  pel >>>
                    24;
                r =
                  pel &
                    16711680;
                g =
                  pel &
                    65280;
                b =
                  pel &
                    255;
                bufferA[0] =
                  a;
                bufferR[0] =
                  r;
                bufferG[0] =
                  g;
                bufferB[0] =
                  b;
                for (int k =
                       1;
                     k <=
                       radiusX;
                     k++) {
                    currentPixel =
                      srcPixels[sp++];
                    a1 =
                      currentPixel >>>
                        24;
                    r1 =
                      currentPixel &
                        16711680;
                    g1 =
                      currentPixel &
                        65280;
                    b1 =
                      currentPixel &
                        255;
                    bufferA[k] =
                      a1;
                    bufferR[k] =
                      r1;
                    bufferG[k] =
                      g1;
                    bufferB[k] =
                      b1;
                    if (isBetter(
                          a1,
                          a,
                          doDilation)) {
                        a =
                          a1;
                        maxIndexA =
                          k;
                    }
                    if (isBetter(
                          r1,
                          r,
                          doDilation)) {
                        r =
                          r1;
                        maxIndexR =
                          k;
                    }
                    if (isBetter(
                          g1,
                          g,
                          doDilation)) {
                        g =
                          g1;
                        maxIndexG =
                          k;
                    }
                    if (isBetter(
                          b1,
                          b,
                          doDilation)) {
                        b =
                          b1;
                        maxIndexB =
                          k;
                    }
                }
                destPixels[dp++] =
                  a <<
                    24 |
                    r |
                    g |
                    b;
                for (int j =
                       1;
                     j <=
                       w -
                       radiusX -
                       1;
                     j++) {
                    lastPixel =
                      srcPixels[sp++];
                    a =
                      bufferA[maxIndexA];
                    a1 =
                      lastPixel >>>
                        24;
                    bufferA[j +
                              radiusX] =
                      a1;
                    if (isBetter(
                          a1,
                          a,
                          doDilation)) {
                        a =
                          a1;
                        maxIndexA =
                          j +
                            radiusX;
                    }
                    r =
                      bufferR[maxIndexR];
                    r1 =
                      lastPixel &
                        16711680;
                    bufferR[j +
                              radiusX] =
                      r1;
                    if (isBetter(
                          r1,
                          r,
                          doDilation)) {
                        r =
                          r1;
                        maxIndexR =
                          j +
                            radiusX;
                    }
                    g =
                      bufferG[maxIndexG];
                    g1 =
                      lastPixel &
                        65280;
                    bufferG[j +
                              radiusX] =
                      g1;
                    if (isBetter(
                          g1,
                          g,
                          doDilation)) {
                        g =
                          g1;
                        maxIndexG =
                          j +
                            radiusX;
                    }
                    b =
                      bufferB[maxIndexB];
                    b1 =
                      lastPixel &
                        255;
                    bufferB[j +
                              radiusX] =
                      b1;
                    if (isBetter(
                          b1,
                          b,
                          doDilation)) {
                        b =
                          b1;
                        maxIndexB =
                          j +
                            radiusX;
                    }
                    destPixels[dp++] =
                      a <<
                        24 |
                        r |
                        g |
                        b;
                }
                for (int j =
                       w -
                       radiusX;
                     j <=
                       radiusX;
                     j++) {
                    destPixels[dp] =
                      destPixels[dp -
                                   1];
                    dp++;
                }
                for (int j =
                       radiusX +
                       1;
                     j <
                       w;
                     j++) {
                    if (maxIndexA ==
                          bufferHead) {
                        a =
                          bufferA[bufferHead +
                                    1];
                        maxIndexA =
                          bufferHead +
                            1;
                        for (int m =
                               bufferHead +
                               2;
                             m <
                               w;
                             m++) {
                            a1 =
                              bufferA[m];
                            if (isBetter(
                                  a1,
                                  a,
                                  doDilation)) {
                                a =
                                  a1;
                                maxIndexA =
                                  m;
                            }
                        }
                    }
                    else {
                        a =
                          bufferA[maxIndexA];
                    }
                    if (maxIndexR ==
                          bufferHead) {
                        r =
                          bufferR[bufferHead +
                                    1];
                        maxIndexR =
                          bufferHead +
                            1;
                        for (int m =
                               bufferHead +
                               2;
                             m <
                               w;
                             m++) {
                            r1 =
                              bufferR[m];
                            if (isBetter(
                                  r1,
                                  r,
                                  doDilation)) {
                                r =
                                  r1;
                                maxIndexR =
                                  m;
                            }
                        }
                    }
                    else {
                        r =
                          bufferR[maxIndexR];
                    }
                    if (maxIndexG ==
                          bufferHead) {
                        g =
                          bufferG[bufferHead +
                                    1];
                        maxIndexG =
                          bufferHead +
                            1;
                        for (int m =
                               bufferHead +
                               2;
                             m <
                               w;
                             m++) {
                            g1 =
                              bufferG[m];
                            if (isBetter(
                                  g1,
                                  g,
                                  doDilation)) {
                                g =
                                  g1;
                                maxIndexG =
                                  m;
                            }
                        }
                    }
                    else {
                        g =
                          bufferG[maxIndexG];
                    }
                    if (maxIndexB ==
                          bufferHead) {
                        b =
                          bufferB[bufferHead +
                                    1];
                        maxIndexB =
                          bufferHead +
                            1;
                        for (int m =
                               bufferHead +
                               2;
                             m <
                               w;
                             m++) {
                            b1 =
                              bufferB[m];
                            if (isBetter(
                                  b1,
                                  b,
                                  doDilation)) {
                                b =
                                  b1;
                                maxIndexB =
                                  m;
                            }
                        }
                    }
                    else {
                        b =
                          bufferB[maxIndexB];
                    }
                    bufferHead++;
                    destPixels[dp++] =
                      a <<
                        24 |
                        r |
                        g |
                        b;
                }
            }
        }
    }
    private void specialProcessColumn(java.awt.image.Raster src,
                                      java.awt.image.WritableRaster dest) {
        final int w =
          src.
          getWidth(
            );
        final int h =
          src.
          getHeight(
            );
        java.awt.image.DataBufferInt dstDB =
          (java.awt.image.DataBufferInt)
            dest.
            getDataBuffer(
              );
        final int dstOff =
          dstDB.
          getOffset(
            );
        final int dstScanStride =
          ((java.awt.image.SinglePixelPackedSampleModel)
             dest.
             getSampleModel(
               )).
          getScanlineStride(
            );
        final int[] destPixels =
          dstDB.
          getBankData(
            )[0];
        int dp;
        int cp;
        int bufferHead;
        int maxIndexA;
        int maxIndexR;
        int maxIndexG;
        int maxIndexB;
        int pel;
        int currentPixel;
        int lastPixel;
        int a;
        int r;
        int g;
        int b;
        int a1;
        int r1;
        int g1;
        int b1;
        if (h <=
              radiusY) {
            for (int j =
                   0;
                 j <
                   w;
                 j++) {
                dp =
                  dstOff +
                    j;
                cp =
                  dstOff +
                    j;
                pel =
                  destPixels[cp];
                cp +=
                  dstScanStride;
                a =
                  pel >>>
                    24;
                r =
                  pel &
                    16711680;
                g =
                  pel &
                    65280;
                b =
                  pel &
                    255;
                for (int k =
                       1;
                     k <
                       h;
                     k++) {
                    currentPixel =
                      destPixels[cp];
                    cp +=
                      dstScanStride;
                    a1 =
                      currentPixel >>>
                        24;
                    r1 =
                      currentPixel &
                        16711680;
                    g1 =
                      currentPixel &
                        65280;
                    b1 =
                      currentPixel &
                        255;
                    if (isBetter(
                          a1,
                          a,
                          doDilation)) {
                        a =
                          a1;
                    }
                    if (isBetter(
                          r1,
                          r,
                          doDilation)) {
                        r =
                          r1;
                    }
                    if (isBetter(
                          g1,
                          g,
                          doDilation)) {
                        g =
                          g1;
                    }
                    if (isBetter(
                          b1,
                          b,
                          doDilation)) {
                        b =
                          b1;
                    }
                }
                for (int k =
                       0;
                     k <
                       h;
                     k++) {
                    destPixels[dp] =
                      a <<
                        24 |
                        r |
                        g |
                        b;
                    dp +=
                      dstScanStride;
                }
            }
        }
        else {
            final int[] bufferA =
              new int[h];
            final int[] bufferR =
              new int[h];
            final int[] bufferG =
              new int[h];
            final int[] bufferB =
              new int[h];
            for (int j =
                   0;
                 j <
                   w;
                 j++) {
                dp =
                  dstOff +
                    j;
                cp =
                  dstOff +
                    j;
                bufferHead =
                  0;
                maxIndexA =
                  0;
                maxIndexR =
                  0;
                maxIndexG =
                  0;
                maxIndexB =
                  0;
                pel =
                  destPixels[cp];
                cp +=
                  dstScanStride;
                a =
                  pel >>>
                    24;
                r =
                  pel &
                    16711680;
                g =
                  pel &
                    65280;
                b =
                  pel &
                    255;
                bufferA[0] =
                  a;
                bufferR[0] =
                  r;
                bufferG[0] =
                  g;
                bufferB[0] =
                  b;
                for (int k =
                       1;
                     k <=
                       radiusY;
                     k++) {
                    currentPixel =
                      destPixels[cp];
                    cp +=
                      dstScanStride;
                    a1 =
                      currentPixel >>>
                        24;
                    r1 =
                      currentPixel &
                        16711680;
                    g1 =
                      currentPixel &
                        65280;
                    b1 =
                      currentPixel &
                        255;
                    bufferA[k] =
                      a1;
                    bufferR[k] =
                      r1;
                    bufferG[k] =
                      g1;
                    bufferB[k] =
                      b1;
                    if (isBetter(
                          a1,
                          a,
                          doDilation)) {
                        a =
                          a1;
                        maxIndexA =
                          k;
                    }
                    if (isBetter(
                          r1,
                          r,
                          doDilation)) {
                        r =
                          r1;
                        maxIndexR =
                          k;
                    }
                    if (isBetter(
                          g1,
                          g,
                          doDilation)) {
                        g =
                          g1;
                        maxIndexG =
                          k;
                    }
                    if (isBetter(
                          b1,
                          b,
                          doDilation)) {
                        b =
                          b1;
                        maxIndexB =
                          k;
                    }
                }
                destPixels[dp] =
                  a <<
                    24 |
                    r |
                    g |
                    b;
                dp +=
                  dstScanStride;
                for (int i =
                       1;
                     i <=
                       h -
                       radiusY -
                       1;
                     i++) {
                    lastPixel =
                      destPixels[cp];
                    cp +=
                      dstScanStride;
                    a =
                      bufferA[maxIndexA];
                    a1 =
                      lastPixel >>>
                        24;
                    bufferA[i +
                              radiusY] =
                      a1;
                    if (isBetter(
                          a1,
                          a,
                          doDilation)) {
                        a =
                          a1;
                        maxIndexA =
                          i +
                            radiusY;
                    }
                    r =
                      bufferR[maxIndexR];
                    r1 =
                      lastPixel &
                        16711680;
                    bufferR[i +
                              radiusY] =
                      r1;
                    if (isBetter(
                          r1,
                          r,
                          doDilation)) {
                        r =
                          r1;
                        maxIndexR =
                          i +
                            radiusY;
                    }
                    g =
                      bufferG[maxIndexG];
                    g1 =
                      lastPixel &
                        65280;
                    bufferG[i +
                              radiusY] =
                      g1;
                    if (isBetter(
                          g1,
                          g,
                          doDilation)) {
                        g =
                          g1;
                        maxIndexG =
                          i +
                            radiusY;
                    }
                    b =
                      bufferB[maxIndexB];
                    b1 =
                      lastPixel &
                        255;
                    bufferB[i +
                              radiusY] =
                      b1;
                    if (isBetter(
                          b1,
                          b,
                          doDilation)) {
                        b =
                          b1;
                        maxIndexB =
                          i +
                            radiusY;
                    }
                    destPixels[dp] =
                      a <<
                        24 |
                        r |
                        g |
                        b;
                    dp +=
                      dstScanStride;
                }
                for (int i =
                       h -
                       radiusY;
                     i <=
                       radiusY;
                     i++) {
                    destPixels[dp] =
                      destPixels[dp -
                                   dstScanStride];
                    dp +=
                      dstScanStride;
                }
                for (int i =
                       radiusY +
                       1;
                     i <
                       h;
                     i++) {
                    if (maxIndexA ==
                          bufferHead) {
                        a =
                          bufferA[bufferHead +
                                    1];
                        maxIndexA =
                          bufferHead +
                            1;
                        for (int m =
                               bufferHead +
                               2;
                             m <
                               h;
                             m++) {
                            a1 =
                              bufferA[m];
                            if (isBetter(
                                  a1,
                                  a,
                                  doDilation)) {
                                a =
                                  a1;
                                maxIndexA =
                                  m;
                            }
                        }
                    }
                    else {
                        a =
                          bufferA[maxIndexA];
                    }
                    if (maxIndexR ==
                          bufferHead) {
                        r =
                          bufferR[bufferHead +
                                    1];
                        maxIndexR =
                          bufferHead +
                            1;
                        for (int m =
                               bufferHead +
                               2;
                             m <
                               h;
                             m++) {
                            r1 =
                              bufferR[m];
                            if (isBetter(
                                  r1,
                                  r,
                                  doDilation)) {
                                r =
                                  r1;
                                maxIndexR =
                                  m;
                            }
                        }
                    }
                    else {
                        r =
                          bufferR[maxIndexR];
                    }
                    if (maxIndexG ==
                          bufferHead) {
                        g =
                          bufferG[bufferHead +
                                    1];
                        maxIndexG =
                          bufferHead +
                            1;
                        for (int m =
                               bufferHead +
                               2;
                             m <
                               h;
                             m++) {
                            g1 =
                              bufferG[m];
                            if (isBetter(
                                  g1,
                                  g,
                                  doDilation)) {
                                g =
                                  g1;
                                maxIndexG =
                                  m;
                            }
                        }
                    }
                    else {
                        g =
                          bufferG[maxIndexG];
                    }
                    if (maxIndexB ==
                          bufferHead) {
                        b =
                          bufferB[bufferHead +
                                    1];
                        maxIndexB =
                          bufferHead +
                            1;
                        for (int m =
                               bufferHead +
                               2;
                             m <
                               h;
                             m++) {
                            b1 =
                              bufferB[m];
                            if (isBetter(
                                  b1,
                                  b,
                                  doDilation)) {
                                b =
                                  b1;
                                maxIndexB =
                                  m;
                            }
                        }
                    }
                    else {
                        b =
                          bufferB[maxIndexB];
                    }
                    bufferHead++;
                    destPixels[dp] =
                      a <<
                        24 |
                        r |
                        g |
                        b;
                    dp +=
                      dstScanStride;
                }
            }
        }
    }
    public java.awt.image.WritableRaster filter(java.awt.image.Raster src,
                                                java.awt.image.WritableRaster dest) {
        if (dest !=
              null)
            checkCompatible(
              dest.
                getSampleModel(
                  ));
        else {
            if (src ==
                  null)
                throw new java.lang.IllegalArgumentException(
                  "src should not be null when dest is null");
            else
                dest =
                  createCompatibleDestRaster(
                    src);
        }
        final int w =
          src.
          getWidth(
            );
        final int h =
          src.
          getHeight(
            );
        java.awt.image.DataBufferInt srcDB =
          (java.awt.image.DataBufferInt)
            src.
            getDataBuffer(
              );
        java.awt.image.DataBufferInt dstDB =
          (java.awt.image.DataBufferInt)
            dest.
            getDataBuffer(
              );
        final int srcOff =
          srcDB.
          getOffset(
            );
        final int dstOff =
          dstDB.
          getOffset(
            );
        final int srcScanStride =
          ((java.awt.image.SinglePixelPackedSampleModel)
             src.
             getSampleModel(
               )).
          getScanlineStride(
            );
        final int dstScanStride =
          ((java.awt.image.SinglePixelPackedSampleModel)
             dest.
             getSampleModel(
               )).
          getScanlineStride(
            );
        final int[] srcPixels =
          srcDB.
          getBankData(
            )[0];
        final int[] destPixels =
          dstDB.
          getBankData(
            )[0];
        int sp;
        int dp;
        int cp;
        int bufferHead;
        int maxIndexA;
        int maxIndexR;
        int maxIndexG;
        int maxIndexB;
        int pel;
        int currentPixel;
        int lastPixel;
        int a;
        int r;
        int g;
        int b;
        int a1;
        int r1;
        int g1;
        int b1;
        if (w <=
              2 *
              radiusX) {
            specialProcessRow(
              src,
              dest);
        }
        else {
            final int[] bufferA =
              new int[rangeX];
            final int[] bufferR =
              new int[rangeX];
            final int[] bufferG =
              new int[rangeX];
            final int[] bufferB =
              new int[rangeX];
            for (int i =
                   0;
                 i <
                   h;
                 i++) {
                sp =
                  srcOff +
                    i *
                    srcScanStride;
                dp =
                  dstOff +
                    i *
                    dstScanStride;
                bufferHead =
                  0;
                maxIndexA =
                  0;
                maxIndexR =
                  0;
                maxIndexG =
                  0;
                maxIndexB =
                  0;
                pel =
                  srcPixels[sp++];
                a =
                  pel >>>
                    24;
                r =
                  pel &
                    16711680;
                g =
                  pel &
                    65280;
                b =
                  pel &
                    255;
                bufferA[0] =
                  a;
                bufferR[0] =
                  r;
                bufferG[0] =
                  g;
                bufferB[0] =
                  b;
                for (int k =
                       1;
                     k <=
                       radiusX;
                     k++) {
                    currentPixel =
                      srcPixels[sp++];
                    a1 =
                      currentPixel >>>
                        24;
                    r1 =
                      currentPixel &
                        16711680;
                    g1 =
                      currentPixel &
                        65280;
                    b1 =
                      currentPixel &
                        255;
                    bufferA[k] =
                      a1;
                    bufferR[k] =
                      r1;
                    bufferG[k] =
                      g1;
                    bufferB[k] =
                      b1;
                    if (isBetter(
                          a1,
                          a,
                          doDilation)) {
                        a =
                          a1;
                        maxIndexA =
                          k;
                    }
                    if (isBetter(
                          r1,
                          r,
                          doDilation)) {
                        r =
                          r1;
                        maxIndexR =
                          k;
                    }
                    if (isBetter(
                          g1,
                          g,
                          doDilation)) {
                        g =
                          g1;
                        maxIndexG =
                          k;
                    }
                    if (isBetter(
                          b1,
                          b,
                          doDilation)) {
                        b =
                          b1;
                        maxIndexB =
                          k;
                    }
                }
                destPixels[dp++] =
                  a <<
                    24 |
                    r |
                    g |
                    b;
                for (int j =
                       1;
                     j <=
                       radiusX;
                     j++) {
                    lastPixel =
                      srcPixels[sp++];
                    a =
                      bufferA[maxIndexA];
                    a1 =
                      lastPixel >>>
                        24;
                    bufferA[j +
                              radiusX] =
                      a1;
                    if (isBetter(
                          a1,
                          a,
                          doDilation)) {
                        a =
                          a1;
                        maxIndexA =
                          j +
                            radiusX;
                    }
                    r =
                      bufferR[maxIndexR];
                    r1 =
                      lastPixel &
                        16711680;
                    bufferR[j +
                              radiusX] =
                      r1;
                    if (isBetter(
                          r1,
                          r,
                          doDilation)) {
                        r =
                          r1;
                        maxIndexR =
                          j +
                            radiusX;
                    }
                    g =
                      bufferG[maxIndexG];
                    g1 =
                      lastPixel &
                        65280;
                    bufferG[j +
                              radiusX] =
                      g1;
                    if (isBetter(
                          g1,
                          g,
                          doDilation)) {
                        g =
                          g1;
                        maxIndexG =
                          j +
                            radiusX;
                    }
                    b =
                      bufferB[maxIndexB];
                    b1 =
                      lastPixel &
                        255;
                    bufferB[j +
                              radiusX] =
                      b1;
                    if (isBetter(
                          b1,
                          b,
                          doDilation)) {
                        b =
                          b1;
                        maxIndexB =
                          j +
                            radiusX;
                    }
                    destPixels[dp++] =
                      a <<
                        24 |
                        r |
                        g |
                        b;
                }
                for (int j =
                       radiusX +
                       1;
                     j <=
                       w -
                       1 -
                       radiusX;
                     j++) {
                    lastPixel =
                      srcPixels[sp++];
                    a1 =
                      lastPixel >>>
                        24;
                    r1 =
                      lastPixel &
                        16711680;
                    g1 =
                      lastPixel &
                        65280;
                    b1 =
                      lastPixel &
                        255;
                    bufferA[bufferHead] =
                      a1;
                    bufferR[bufferHead] =
                      r1;
                    bufferG[bufferHead] =
                      g1;
                    bufferB[bufferHead] =
                      b1;
                    if (maxIndexA ==
                          bufferHead) {
                        a =
                          bufferA[0];
                        maxIndexA =
                          0;
                        for (int m =
                               1;
                             m <
                               rangeX;
                             m++) {
                            a1 =
                              bufferA[m];
                            if (isBetter(
                                  a1,
                                  a,
                                  doDilation)) {
                                a =
                                  a1;
                                maxIndexA =
                                  m;
                            }
                        }
                    }
                    else {
                        a =
                          bufferA[maxIndexA];
                        if (isBetter(
                              a1,
                              a,
                              doDilation)) {
                            a =
                              a1;
                            maxIndexA =
                              bufferHead;
                        }
                    }
                    if (maxIndexR ==
                          bufferHead) {
                        r =
                          bufferR[0];
                        maxIndexR =
                          0;
                        for (int m =
                               1;
                             m <
                               rangeX;
                             m++) {
                            r1 =
                              bufferR[m];
                            if (isBetter(
                                  r1,
                                  r,
                                  doDilation)) {
                                r =
                                  r1;
                                maxIndexR =
                                  m;
                            }
                        }
                    }
                    else {
                        r =
                          bufferR[maxIndexR];
                        if (isBetter(
                              r1,
                              r,
                              doDilation)) {
                            r =
                              r1;
                            maxIndexR =
                              bufferHead;
                        }
                    }
                    if (maxIndexG ==
                          bufferHead) {
                        g =
                          bufferG[0];
                        maxIndexG =
                          0;
                        for (int m =
                               1;
                             m <
                               rangeX;
                             m++) {
                            g1 =
                              bufferG[m];
                            if (isBetter(
                                  g1,
                                  g,
                                  doDilation)) {
                                g =
                                  g1;
                                maxIndexG =
                                  m;
                            }
                        }
                    }
                    else {
                        g =
                          bufferG[maxIndexG];
                        if (isBetter(
                              g1,
                              g,
                              doDilation)) {
                            g =
                              g1;
                            maxIndexG =
                              bufferHead;
                        }
                    }
                    if (maxIndexB ==
                          bufferHead) {
                        b =
                          bufferB[0];
                        maxIndexB =
                          0;
                        for (int m =
                               1;
                             m <
                               rangeX;
                             m++) {
                            b1 =
                              bufferB[m];
                            if (isBetter(
                                  b1,
                                  b,
                                  doDilation)) {
                                b =
                                  b1;
                                maxIndexB =
                                  m;
                            }
                        }
                    }
                    else {
                        b =
                          bufferB[maxIndexB];
                        if (isBetter(
                              b1,
                              b,
                              doDilation)) {
                            b =
                              b1;
                            maxIndexB =
                              bufferHead;
                        }
                    }
                    destPixels[dp++] =
                      a <<
                        24 |
                        r |
                        g |
                        b;
                    bufferHead =
                      (bufferHead +
                         1) %
                        rangeX;
                }
                int head;
                final int tail =
                  bufferHead ==
                  0
                  ? rangeX -
                  1
                  : bufferHead -
                  1;
                int count =
                  rangeX -
                  1;
                for (int j =
                       w -
                       radiusX;
                     j <
                       w;
                     j++) {
                    head =
                      (bufferHead +
                         1) %
                        rangeX;
                    if (maxIndexA ==
                          bufferHead) {
                        a =
                          bufferA[tail];
                        int hd =
                          head;
                        for (int m =
                               1;
                             m <
                               count;
                             m++) {
                            a1 =
                              bufferA[hd];
                            if (isBetter(
                                  a1,
                                  a,
                                  doDilation)) {
                                a =
                                  a1;
                                maxIndexA =
                                  hd;
                            }
                            hd =
                              (hd +
                                 1) %
                                rangeX;
                        }
                    }
                    if (maxIndexR ==
                          bufferHead) {
                        r =
                          bufferR[tail];
                        int hd =
                          head;
                        for (int m =
                               1;
                             m <
                               count;
                             m++) {
                            r1 =
                              bufferR[hd];
                            if (isBetter(
                                  r1,
                                  r,
                                  doDilation)) {
                                r =
                                  r1;
                                maxIndexR =
                                  hd;
                            }
                            hd =
                              (hd +
                                 1) %
                                rangeX;
                        }
                    }
                    if (maxIndexG ==
                          bufferHead) {
                        g =
                          bufferG[tail];
                        int hd =
                          head;
                        for (int m =
                               1;
                             m <
                               count;
                             m++) {
                            g1 =
                              bufferG[hd];
                            if (isBetter(
                                  g1,
                                  g,
                                  doDilation)) {
                                g =
                                  g1;
                                maxIndexG =
                                  hd;
                            }
                            hd =
                              (hd +
                                 1) %
                                rangeX;
                        }
                    }
                    if (maxIndexB ==
                          bufferHead) {
                        b =
                          bufferB[tail];
                        int hd =
                          head;
                        for (int m =
                               1;
                             m <
                               count;
                             m++) {
                            b1 =
                              bufferB[hd];
                            if (isBetter(
                                  b1,
                                  b,
                                  doDilation)) {
                                b =
                                  b1;
                                maxIndexB =
                                  hd;
                            }
                            hd =
                              (hd +
                                 1) %
                                rangeX;
                        }
                    }
                    destPixels[dp++] =
                      a <<
                        24 |
                        r |
                        g |
                        b;
                    bufferHead =
                      (bufferHead +
                         1) %
                        rangeX;
                    count--;
                }
            }
        }
        if (h <=
              2 *
              radiusY) {
            specialProcessColumn(
              src,
              dest);
        }
        else {
            final int[] bufferA =
              new int[rangeY];
            final int[] bufferR =
              new int[rangeY];
            final int[] bufferG =
              new int[rangeY];
            final int[] bufferB =
              new int[rangeY];
            for (int j =
                   0;
                 j <
                   w;
                 j++) {
                dp =
                  dstOff +
                    j;
                cp =
                  dstOff +
                    j;
                bufferHead =
                  0;
                maxIndexA =
                  0;
                maxIndexR =
                  0;
                maxIndexG =
                  0;
                maxIndexB =
                  0;
                pel =
                  destPixels[cp];
                cp +=
                  dstScanStride;
                a =
                  pel >>>
                    24;
                r =
                  pel &
                    16711680;
                g =
                  pel &
                    65280;
                b =
                  pel &
                    255;
                bufferA[0] =
                  a;
                bufferR[0] =
                  r;
                bufferG[0] =
                  g;
                bufferB[0] =
                  b;
                for (int k =
                       1;
                     k <=
                       radiusY;
                     k++) {
                    currentPixel =
                      destPixels[cp];
                    cp +=
                      dstScanStride;
                    a1 =
                      currentPixel >>>
                        24;
                    r1 =
                      currentPixel &
                        16711680;
                    g1 =
                      currentPixel &
                        65280;
                    b1 =
                      currentPixel &
                        255;
                    bufferA[k] =
                      a1;
                    bufferR[k] =
                      r1;
                    bufferG[k] =
                      g1;
                    bufferB[k] =
                      b1;
                    if (isBetter(
                          a1,
                          a,
                          doDilation)) {
                        a =
                          a1;
                        maxIndexA =
                          k;
                    }
                    if (isBetter(
                          r1,
                          r,
                          doDilation)) {
                        r =
                          r1;
                        maxIndexR =
                          k;
                    }
                    if (isBetter(
                          g1,
                          g,
                          doDilation)) {
                        g =
                          g1;
                        maxIndexG =
                          k;
                    }
                    if (isBetter(
                          b1,
                          b,
                          doDilation)) {
                        b =
                          b1;
                        maxIndexB =
                          k;
                    }
                }
                destPixels[dp] =
                  a <<
                    24 |
                    r |
                    g |
                    b;
                dp +=
                  dstScanStride;
                for (int i =
                       1;
                     i <=
                       radiusY;
                     i++) {
                    int maxI =
                      i +
                      radiusY;
                    lastPixel =
                      destPixels[cp];
                    cp +=
                      dstScanStride;
                    a =
                      bufferA[maxIndexA];
                    a1 =
                      lastPixel >>>
                        24;
                    bufferA[maxI] =
                      a1;
                    if (isBetter(
                          a1,
                          a,
                          doDilation)) {
                        a =
                          a1;
                        maxIndexA =
                          maxI;
                    }
                    r =
                      bufferR[maxIndexR];
                    r1 =
                      lastPixel &
                        16711680;
                    bufferR[maxI] =
                      r1;
                    if (isBetter(
                          r1,
                          r,
                          doDilation)) {
                        r =
                          r1;
                        maxIndexR =
                          maxI;
                    }
                    g =
                      bufferG[maxIndexG];
                    g1 =
                      lastPixel &
                        65280;
                    bufferG[maxI] =
                      g1;
                    if (isBetter(
                          g1,
                          g,
                          doDilation)) {
                        g =
                          g1;
                        maxIndexG =
                          maxI;
                    }
                    b =
                      bufferB[maxIndexB];
                    b1 =
                      lastPixel &
                        255;
                    bufferB[maxI] =
                      b1;
                    if (isBetter(
                          b1,
                          b,
                          doDilation)) {
                        b =
                          b1;
                        maxIndexB =
                          maxI;
                    }
                    destPixels[dp] =
                      a <<
                        24 |
                        r |
                        g |
                        b;
                    dp +=
                      dstScanStride;
                }
                for (int i =
                       radiusY +
                       1;
                     i <=
                       h -
                       1 -
                       radiusY;
                     i++) {
                    lastPixel =
                      destPixels[cp];
                    cp +=
                      dstScanStride;
                    a1 =
                      lastPixel >>>
                        24;
                    r1 =
                      lastPixel &
                        16711680;
                    g1 =
                      lastPixel &
                        65280;
                    b1 =
                      lastPixel &
                        255;
                    bufferA[bufferHead] =
                      a1;
                    bufferR[bufferHead] =
                      r1;
                    bufferG[bufferHead] =
                      g1;
                    bufferB[bufferHead] =
                      b1;
                    if (maxIndexA ==
                          bufferHead) {
                        a =
                          bufferA[0];
                        maxIndexA =
                          0;
                        for (int m =
                               1;
                             m <=
                               2 *
                               radiusY;
                             m++) {
                            a1 =
                              bufferA[m];
                            if (isBetter(
                                  a1,
                                  a,
                                  doDilation)) {
                                a =
                                  a1;
                                maxIndexA =
                                  m;
                            }
                        }
                    }
                    else {
                        a =
                          bufferA[maxIndexA];
                        if (isBetter(
                              a1,
                              a,
                              doDilation)) {
                            a =
                              a1;
                            maxIndexA =
                              bufferHead;
                        }
                    }
                    if (maxIndexR ==
                          bufferHead) {
                        r =
                          bufferR[0];
                        maxIndexR =
                          0;
                        for (int m =
                               1;
                             m <=
                               2 *
                               radiusY;
                             m++) {
                            r1 =
                              bufferR[m];
                            if (isBetter(
                                  r1,
                                  r,
                                  doDilation)) {
                                r =
                                  r1;
                                maxIndexR =
                                  m;
                            }
                        }
                    }
                    else {
                        r =
                          bufferR[maxIndexR];
                        if (isBetter(
                              r1,
                              r,
                              doDilation)) {
                            r =
                              r1;
                            maxIndexR =
                              bufferHead;
                        }
                    }
                    if (maxIndexG ==
                          bufferHead) {
                        g =
                          bufferG[0];
                        maxIndexG =
                          0;
                        for (int m =
                               1;
                             m <=
                               2 *
                               radiusY;
                             m++) {
                            g1 =
                              bufferG[m];
                            if (isBetter(
                                  g1,
                                  g,
                                  doDilation)) {
                                g =
                                  g1;
                                maxIndexG =
                                  m;
                            }
                        }
                    }
                    else {
                        g =
                          bufferG[maxIndexG];
                        if (isBetter(
                              g1,
                              g,
                              doDilation)) {
                            g =
                              g1;
                            maxIndexG =
                              bufferHead;
                        }
                    }
                    if (maxIndexB ==
                          bufferHead) {
                        b =
                          bufferB[0];
                        maxIndexB =
                          0;
                        for (int m =
                               1;
                             m <=
                               2 *
                               radiusY;
                             m++) {
                            b1 =
                              bufferB[m];
                            if (isBetter(
                                  b1,
                                  b,
                                  doDilation)) {
                                b =
                                  b1;
                                maxIndexB =
                                  m;
                            }
                        }
                    }
                    else {
                        b =
                          bufferB[maxIndexB];
                        if (isBetter(
                              b1,
                              b,
                              doDilation)) {
                            b =
                              b1;
                            maxIndexB =
                              bufferHead;
                        }
                    }
                    destPixels[dp] =
                      a <<
                        24 |
                        r |
                        g |
                        b;
                    dp +=
                      dstScanStride;
                    bufferHead =
                      (bufferHead +
                         1) %
                        rangeY;
                }
                int head;
                final int tail =
                  bufferHead ==
                  0
                  ? 2 *
                  radiusY
                  : bufferHead -
                  1;
                int count =
                  rangeY -
                  1;
                for (int i =
                       h -
                       radiusY;
                     i <
                       h -
                       1;
                     i++) {
                    head =
                      (bufferHead +
                         1) %
                        rangeY;
                    if (maxIndexA ==
                          bufferHead) {
                        a =
                          bufferA[tail];
                        int hd =
                          head;
                        for (int m =
                               1;
                             m <
                               count;
                             m++) {
                            a1 =
                              bufferA[hd];
                            if (isBetter(
                                  a1,
                                  a,
                                  doDilation)) {
                                a =
                                  a1;
                                maxIndexA =
                                  hd;
                            }
                            hd =
                              (hd +
                                 1) %
                                rangeY;
                        }
                    }
                    if (maxIndexR ==
                          bufferHead) {
                        r =
                          bufferR[tail];
                        int hd =
                          head;
                        for (int m =
                               1;
                             m <
                               count;
                             m++) {
                            r1 =
                              bufferR[hd];
                            if (isBetter(
                                  r1,
                                  r,
                                  doDilation)) {
                                r =
                                  r1;
                                maxIndexR =
                                  hd;
                            }
                            hd =
                              (hd +
                                 1) %
                                rangeY;
                        }
                    }
                    if (maxIndexG ==
                          bufferHead) {
                        g =
                          bufferG[tail];
                        int hd =
                          head;
                        for (int m =
                               1;
                             m <
                               count;
                             m++) {
                            g1 =
                              bufferG[hd];
                            if (isBetter(
                                  g1,
                                  g,
                                  doDilation)) {
                                g =
                                  g1;
                                maxIndexG =
                                  hd;
                            }
                            hd =
                              (hd +
                                 1) %
                                rangeY;
                        }
                    }
                    if (maxIndexB ==
                          bufferHead) {
                        b =
                          bufferB[tail];
                        int hd =
                          head;
                        for (int m =
                               1;
                             m <
                               count;
                             m++) {
                            b1 =
                              bufferB[hd];
                            if (isBetter(
                                  b1,
                                  b,
                                  doDilation)) {
                                b =
                                  b1;
                                maxIndexB =
                                  hd;
                            }
                            hd =
                              (hd +
                                 1) %
                                rangeY;
                        }
                    }
                    destPixels[dp] =
                      a <<
                        24 |
                        r |
                        g |
                        b;
                    dp +=
                      dstScanStride;
                    bufferHead =
                      (bufferHead +
                         1) %
                        rangeY;
                    count--;
                }
            }
        }
        return dest;
    }
    public java.awt.image.BufferedImage filter(java.awt.image.BufferedImage src,
                                               java.awt.image.BufferedImage dest) {
        if (src ==
              null)
            throw new java.lang.NullPointerException(
              "Source image should not be null");
        java.awt.image.BufferedImage origSrc =
          src;
        java.awt.image.BufferedImage finalDest =
          dest;
        if (!isCompatible(
               src.
                 getColorModel(
                   ),
               src.
                 getSampleModel(
                   ))) {
            src =
              new java.awt.image.BufferedImage(
                src.
                  getWidth(
                    ),
                src.
                  getHeight(
                    ),
                java.awt.image.BufferedImage.
                  TYPE_INT_ARGB_PRE);
            org.apache.batik.ext.awt.image.GraphicsUtil.
              copyData(
                origSrc,
                src);
        }
        else
            if (!src.
                  isAlphaPremultiplied(
                    )) {
                java.awt.image.ColorModel srcCM;
                java.awt.image.ColorModel srcCMPre;
                srcCM =
                  src.
                    getColorModel(
                      );
                srcCMPre =
                  org.apache.batik.ext.awt.image.GraphicsUtil.
                    coerceColorModel(
                      srcCM,
                      true);
                src =
                  new java.awt.image.BufferedImage(
                    srcCMPre,
                    src.
                      getRaster(
                        ),
                    true,
                    null);
                org.apache.batik.ext.awt.image.GraphicsUtil.
                  copyData(
                    origSrc,
                    src);
            }
        if (dest ==
              null) {
            dest =
              createCompatibleDestImage(
                src,
                null);
            finalDest =
              dest;
        }
        else
            if (!isCompatible(
                   dest.
                     getColorModel(
                       ),
                   dest.
                     getSampleModel(
                       ))) {
                dest =
                  createCompatibleDestImage(
                    src,
                    null);
            }
            else
                if (!dest.
                      isAlphaPremultiplied(
                        )) {
                    java.awt.image.ColorModel dstCM;
                    java.awt.image.ColorModel dstCMPre;
                    dstCM =
                      dest.
                        getColorModel(
                          );
                    dstCMPre =
                      org.apache.batik.ext.awt.image.GraphicsUtil.
                        coerceColorModel(
                          dstCM,
                          true);
                    dest =
                      new java.awt.image.BufferedImage(
                        dstCMPre,
                        finalDest.
                          getRaster(
                            ),
                        true,
                        null);
                }
        filter(
          src.
            getRaster(
              ),
          dest.
            getRaster(
              ));
        if (src.
              getRaster(
                ) ==
              origSrc.
              getRaster(
                ) &&
              src.
              isAlphaPremultiplied(
                ) !=
              origSrc.
              isAlphaPremultiplied(
                )) {
            org.apache.batik.ext.awt.image.GraphicsUtil.
              copyData(
                src,
                origSrc);
        }
        if (dest.
              getRaster(
                ) !=
              finalDest.
              getRaster(
                ) ||
              dest.
              isAlphaPremultiplied(
                ) !=
              finalDest.
              isAlphaPremultiplied(
                )) {
            org.apache.batik.ext.awt.image.GraphicsUtil.
              copyData(
                dest,
                finalDest);
        }
        return finalDest;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "cI72Px3f+9OH9+4XWtXnJuk2qEEf/83nL4Xu+8MLBTJBiWKXpivRlbOBe2ru" +
       "3AiD1n+j5md31Ze0Q8zoJBUpTdmZop0xt0SoyqxU1DVZTrnEO9ym4cQwElgC" +
       "c4Adq7gWV9pm40+z6/5aRsqjuq5SSfNqi/+2pbmMK/izZVkKwikIf9aFzUWW" +
       "O/rmzrardh+Q73rjo0mbP3r6HEcst/h3B5suyRDTVYfNxThdM7zZcYNkDQLd" +
       "ypMbv1qrnvwMJPaDRBlqAKvbhCybzglNNnVp+W9//uz07a+VkGA7qVR1KdYu" +
       "8ShPJkJ4pRbk5FjauHatiC4jFdDUclNJnvF5HbjC5xWOHW1Jg/HVvvvHM354" +
       "9UNHzvAwZwgZczh/OZYdOWmdbyGdzPLoqat+/dDd944Ibyyytjx8M//VrUZv" +
       "f/eTPMh5Ii2w3Dz8/eHH7p/duuYDzu9kNORuSueXSlAVOLwrHk3+I7iw7JdB" +
       "Ut5PamV7y7ZZUlOYJ/phm2Jl9nGwrct5nrvlEPV1czZjz/Wud9ew3lzqXkYT" +
       "WM6ScdJnNU7hTLhW2pllpTd9Bgi/GeAsl/B2CTaXZbJVuWEqsK2nnnRVVUQo" +
       "MJlSTElZX+FLVWRobDdis11I2uTrjlvy1V9lj7TKR/1BoT420Xw9/bizem4p" +
       "pKcyRj3nwXWNPdI1PnrqRfX042akMqavV1QpU6J0eFQ1LlzVeuxtgKvFHqzF" +
       "R9Xhwh4RxFsoCErjiiapHqeoKyIX6h4TfJ4W9ImRL2BAhz1Qh48BtxYzAJvd" +
       "BbT3E5rRvqCn7Buj9t1wReyBIj7a7/8i2vsJZVCC9Xa0cIaZjMzi4Rz3b7D7" +
       "1k2M6brZB/s76jHswBgNuwGuTbYOm3wMu/uLGOYnFAxTwTC8v8Oj+8Eiuqed" +
       "Zbg0Oxj/KyOeQwHXYK60FsxA2ZiFUmyFW1Jx3P/EOvG/biNDNsND1itZjJrd" +
       "vJ5s8Dv+4dXa0dsPHYl1P7g8aBcmaxnkdN24TKXDVHVpNBkl5STaLn7g5WSt" +
       "tycf/OOTTYmWsWydsa9xlM0x/j8PUuYS/9ztVeW52/8y+/o1g9vHsAue50HJ" +
       "K/KRrsde6LhYPhjkp3sineadCuYyNecm0UqTspSp5Vafi7LugZtQshCuHbZ7" +
       "7PA6uOOAHs/K7u/8WD2FaKawtp1nWkHn4cM9XqSE/R42DzNSlaCsRU9pMWvF" +
       "+vwIkKB6MtQLVQhEN5XaFHwBPTLa4i9eNmLHjWIBHM0HUbeR0McOoh9rcRDn" +
       "FluofNSni2D5C2yezMUSu37gwPWTcYBrCj7DXGfZNltjh8uP1WNtMDeuTct1" +
       "kB4dNn7C5Ff4mC8XAes1bJ6HogXAcjM6WL0wDljxGmw1XDfbBu8ZBasCBdge" +
       "H9biWM3yuBZPpxhZ1QzFbA9Fn5Q0VMpJuFa/L4Lmu9i8CRtJeZDKQ/xoiSlR" +
       "lRba9E4Y1pWYA/Nb4wAzz5Tz4TpsY3V47DD7sRaGGf99G5t3uOiPimD1N2w+" +
       "YKQaN2AZoLCvwwHlw/HyvcvhOmFbdmLsoPixFg5rDh6fF8HjPDaf5PsOdr/n" +
       "QPLpOEAyG58thetV265XR4GkQOjyY/W3OFBZ5Fk1NqWM1EFc6uWvLBQtsQFP" +
       "tPLLtALPEapA2XhBhWSnbHtPjR0qP1Z/7znGMZlVBK852EyF6CWbVGLUcZ/1" +
       "1GKiCMkA1+AJcDeaCsMTZRcVh2/aOMA3C5+tgOu0jcHpscPnx+ofkZ7hYYnj" +
       "9KUiGOIOJ7AIckQhDHntwYU5CDWNF0IL4Dprm3m2CEK8dW/MYOtr8c8CsM+7" +
       "OastItUDi332j/+uyjYdHKWriiC4GptljFQoVgtlTBzROfE8sHy84nkrXJ/a" +
       "pn06iksViOd+rP4udQzNaeBGry8CSDs2kOzrLIPKiqTy13WW1auP7MwJ64G1" +
       "44VMOyg8R8gUv2NCxpf1gpDZVASZPmwijEzNRUZ8QuABp2u8Avl88PF1Qqb4" +
       "HVMk8mW9IHC2FQFnOzZbGH5yo4pVFGhw4Ogfr7Azj5DS80Km+B0THL6sowTm" +
       "Z7jJQ0XgSGITd8PhjsKJ/wUcaShE3V9E4JuUmXlfZImviORjR2oqZhy54U1+" +
       "OpP90qc6QiriKVV1n/W77ssMk8YVDmO1OPnnb8cCKUYuucBvNiCwZm7RjgAT" +
       "EkD3xuISGCnlv26uPYzM9ONipARaN/UtsFILUQMltG7K2xip9VLC+PzXTfc1" +
       "2HQ6dDC54sZNsh+kAwneHsgez9Xy8gVfyYTEK5m0ODeY455hXiqPWsBkWdwf" +
       "CCAE/Iu9zOFVSnyzNyAfP3Ldxj3nrnxQfKAgq9Lu3SilKkLKxbcSXCgegC3w" +
       "lZaRVbZh8WeTn5h4UeaosE4o7CyyOY7/kxuhDOQeOdvz9t5qyr7EP3306qdf" +
       "PlD2epAEtpKAxMiUrfkvr9JGyiQNWyP5r4A3Syb/rKB58Xd2rbk0/tff8deD" +
       "RLwynutPPyC/8dBNpw7OPNoYJFWd4Gbgnmn+Vm39Lq2XysNmP5mkWG1pUBGk" +
       "QKDPeb88GRePhLU7x8WGc1K2F7MCIwvzX63nfxRUqeoj1OQHPihmUoRUOT1i" +
       "ZjxniCnD8DA4PfZUYssPRFancTbAHwciXYaR+fJg4hmDx4+2QkV7G/fh7/Jb" +
       "vLv/v+8qaUHNKwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "fuV6y/gHlvH/Rizz9vOcvWzgN88x0G8X");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("2T87baCi6DeObfDVW7DBW4rCYncoOrBB9MbY4OLpCf/A6aFkfcuL9zj+TVn9" +
       "6+dY4BtF9q/iymVggZMVjw3wtVswQLml2AHpIwcGeO71GoB9LQZ42xknKDej" +
       "aF87YKMHiq2J0xIzxQ0cvRQpO/jjc0z0n4rsj+LKFdXUVbs8RBNbS0e/4Z5G" +
       "6lvase2+eQu2e2tR+ARInz+w3effUNsVP79VZN8ppb53jgH+Z5F9N67cU+zs" +
       "H6Ivyt53jPRPb9VLmiC9dID0pTcG6YVjgT3IvzoH5F8X2Z9fP8pF8X85xvkX" +
       "t4DzkaKwCtLXD3B+/Y2hgxMwLtx1zr3LRXYJBCtgrnPlQUPLM0gw56PrY4Ib" +
       "3C/wX7jtVvEXZzC+cYD/G28M/hPj/JUS6IPnGOHhIrsPMIIa6kqsHw90V4/i" +
       "/bp6aI1Hz5AGeLKKi/NoJ6RKm9x/CzZ5W1HYAOmbBzb55htjkxOz/LfKqV6C" +
       "f/ocw7yryB4HZHojw5TLadnYMewnbhX2kyC9cgD7ldcBu0R1Mv4+g+rScaje" +
       "PMreV4KsnWOARpFV48pdVoTrcbw/DnVMcRfee6sUR4D0lwd4//L1DvOrkvlX" +
       "Ch0fKZG8/xyUxWm7CyBivy8KdNVSnPJUbRRxfnaa6S60bxVuHyj2I/u6+++/" +
       "KbjkOXBHRUbE4EnpFNz9WfgziLu3ym1PAK/D9nX332/oPD6BmD8HsVhkTFz8" +
       "IcTZO/GFR44xsrc6aR+vVG7/4b7u/vuN56rfKnF8+ByMyyL70EmMJ4npVc+W" +
       "nTqECeKak4fti5PDD1/3Z5/9H1TUX3vhyl0PvSD8+/K8+dGfSO6mKnetEsc5" +
       "eSbxxPUdQaivrBL53fsTikEJwoorP/oa/w4ASOnwsgBwwdy3AJ5mHzu/hbhy" +
       "e/l9spYfVx6+Wa24cgnkJ6VDMHduJA0kQX5SMokrV89Kgv7L75NywOKXj+XA" +
       "IO4vToo8B1oHIsXlR45eWJw4t7Q/OrrdPwU+fNJbyyDtVRfkoyonj8sXJij/" +
       "DHb4MiHZ/x3sWfXLL4wmz32/9cv74/qqo+R50cpdVOXO/T8HykaLFxJP3rS1" +
       "w7buIN/9g3t//e53Hr48uXev8PHMOaHb4zc+G99zg7g8zZ7/k4f+8fv/wQvf" +
       "Kg9u/V/lSZE6pTcAAA==");
}
