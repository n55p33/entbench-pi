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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "d/f9F96fCerNKwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "WCb8yvWWCQ4sE/yNWObt5zl7WcBvnmOg");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("3y6if37aQEXSbxzb4Ku3YIO3FInF7lB8YIP4jbHBxdMd/sHTTckFlp/scfzb" +
       "MvvXz7HAN4roXyeVy8ACJzMeG+Brt2CAckuxA8JHDwzw3Os1APdaDPC2M05Q" +
       "bkYNA+2AjR4stiZOSwiKF7p6KVJW8MfnmOg/F9EfJZUr6kpXnfIQTWItXf2G" +
       "expgyaQd2+6bt2C7txaJT4Lw+QPbff4NtV1x+60i+k4p9b1zDPA/i+i7SeWe" +
       "Ymf/EH2R9r5jpH96q17SAOGlA6QvvTFILxwL7EH+1Tkg/7qI/vz6Vi6S/+sx" +
       "zr+4BZyPFolVEL5+gPPrbwwdnIBx4a5znl0uoktgsgL6Ol8eNLR8kwZ9Pr5+" +
       "TnCD5wX+C7fdKv7iDMY3DvB/443Bf6Kdv1ICfegcIzxSRPcDRlAjXUn044Ym" +
       "9DjZj6uH1njsDGnMIispzqOdkCpt8sAt2ORtRSIMwjcPbPLNN8YmJ3r5b5Vd" +
       "vQR/9RzDvKuIngBkeiPDlMNpWdgx7CdvFfZTILxyAPuV1wG7RHVy/n0G1aXj" +
       "qXrjKHpfCbJ2jgHgIqomlbusuKsnyf441DHFXXjvrVIcDsJfHuD9y9fbzK9K" +
       "5l8pdHy0RPL+c1AWp+0ugBn7/XGoq5bilqdq45gPstNMd6F9q3BJoNiP7PPu" +
       "//+m4NLnwO0XEZ6AldIpuPuz8GcQE7fKbU8Cr8P2eff/b2g/PoF4eg5iqYjG" +
       "SfFBiLt34guPHmPkbrXTPlGp3P7Dfd79/xvPVb9V4vjIORiXRfThkxhPEtOr" +
       "ni07dQgTzGtOHrYvTg4/ct3HPvsPVNRfe+HKXQ+/IP6H8rz50Uckd7OVu4zU" +
       "dU+eSTxxfUcY6YZVIr97f0IxLEFYSeVHX+PnAICUDi8LABdW+xLAavbx80tI" +
       "KreX/ydzBUnlkZvlSiqXQHxSOgJ950bSQBLEJyXTpHLfWUlQf/l/Ug5Y/PKx" +
       "HGjE/cVJkedA6UCkuPzo0QuLE+eW9kdH8/0q8JGT3lpO0l51QD7KcvK4fGGC" +
       "8mOww5cJ6f5zsGfVL7/QHz33/dYv74/rq66y2xWl3MVW7tx/OVAWWryQeOqm" +
       "pR2WdQf97h/c++t3v/Pw5cm9e4WPe84J3Z648dn4nhcm5Wn23T99+J+8/x++" +
       "8K3y4Nb/BTwYj+alNwAA");
}
