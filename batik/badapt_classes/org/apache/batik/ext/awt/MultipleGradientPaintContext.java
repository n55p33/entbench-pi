package org.apache.batik.ext.awt;
abstract class MultipleGradientPaintContext implements java.awt.PaintContext {
    protected static final boolean DEBUG = false;
    protected java.awt.image.ColorModel dataModel;
    protected java.awt.image.ColorModel model;
    private static java.awt.image.ColorModel lrgbmodel_NA = new java.awt.image.DirectColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_LINEAR_RGB),
      24,
      16711680,
      65280,
      255,
      0,
      false,
      java.awt.image.DataBuffer.
        TYPE_INT);
    private static java.awt.image.ColorModel srgbmodel_NA = new java.awt.image.DirectColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_sRGB),
      24,
      16711680,
      65280,
      255,
      0,
      false,
      java.awt.image.DataBuffer.
        TYPE_INT);
    private static java.awt.image.ColorModel lrgbmodel_A =
      new java.awt.image.DirectColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_LINEAR_RGB),
      32,
      16711680,
      65280,
      255,
      -16777216,
      false,
      java.awt.image.DataBuffer.
        TYPE_INT);
    private static java.awt.image.ColorModel srgbmodel_A =
      new java.awt.image.DirectColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_sRGB),
      32,
      16711680,
      65280,
      255,
      -16777216,
      false,
      java.awt.image.DataBuffer.
        TYPE_INT);
    protected static java.awt.image.ColorModel cachedModel;
    protected static java.lang.ref.WeakReference cached;
    protected java.awt.image.WritableRaster saved;
    protected org.apache.batik.ext.awt.MultipleGradientPaint.CycleMethodEnum
      cycleMethod;
    protected org.apache.batik.ext.awt.MultipleGradientPaint.ColorSpaceEnum
      colorSpace;
    protected float a00;
    protected float a01;
    protected float a10;
    protected float a11;
    protected float a02;
    protected float a12;
    protected boolean isSimpleLookup = true;
    protected boolean hasDiscontinuity = false;
    protected int fastGradientArraySize;
    protected int[] gradient;
    protected int[][] gradients;
    protected int gradientAverage;
    protected int gradientUnderflow;
    protected int gradientOverflow;
    protected int gradientsLength;
    protected float[] normalizedIntervals;
    protected float[] fractions;
    private int transparencyTest;
    private static final int[] SRGBtoLinearRGB = new int[256];
    private static final int[] LinearRGBtoSRGB = new int[256];
    static { for (int k = 0; k < 256; k++) { SRGBtoLinearRGB[k] =
                                               convertSRGBtoLinearRGB(
                                                 k);
                                             LinearRGBtoSRGB[k] =
                                               convertLinearRGBtoSRGB(
                                                 k); } }
    protected static final int GRADIENT_SIZE = 256;
    protected static final int GRADIENT_SIZE_INDEX = GRADIENT_SIZE -
      1;
    private static final int MAX_GRADIENT_ARRAY_SIZE = 5000;
    protected MultipleGradientPaintContext(java.awt.image.ColorModel cm,
                                           java.awt.Rectangle deviceBounds,
                                           java.awt.geom.Rectangle2D userBounds,
                                           java.awt.geom.AffineTransform t,
                                           java.awt.RenderingHints hints,
                                           float[] fractions,
                                           java.awt.Color[] colors,
                                           org.apache.batik.ext.awt.MultipleGradientPaint.CycleMethodEnum cycleMethod,
                                           org.apache.batik.ext.awt.MultipleGradientPaint.ColorSpaceEnum colorSpace)
          throws java.awt.geom.NoninvertibleTransformException {
        super(
          );
        boolean fixFirst =
          false;
        boolean fixLast =
          false;
        int len =
          fractions.
            length;
        if (fractions[0] !=
              0.0F) {
            fixFirst =
              true;
            len++;
        }
        if (fractions[fractions.
                        length -
                        1] !=
              1.0F) {
            fixLast =
              true;
            len++;
        }
        for (int i =
               0;
             i <
               fractions.
                 length -
               1;
             i++)
            if (fractions[i] ==
                  fractions[i +
                              1])
                len--;
        this.
          fractions =
          (new float[len]);
        java.awt.Color[] loColors =
          new java.awt.Color[len -
                               1];
        java.awt.Color[] hiColors =
          new java.awt.Color[len -
                               1];
        normalizedIntervals =
          (new float[len -
                       1]);
        gradientUnderflow =
          colors[0].
            getRGB(
              );
        gradientOverflow =
          colors[colors.
                   length -
                   1].
            getRGB(
              );
        int idx =
          0;
        if (fixFirst) {
            this.
              fractions[0] =
              0;
            loColors[0] =
              colors[0];
            hiColors[0] =
              colors[0];
            normalizedIntervals[0] =
              fractions[0];
            idx++;
        }
        for (int i =
               0;
             i <
               fractions.
                 length -
               1;
             i++) {
            if (fractions[i] ==
                  fractions[i +
                              1]) {
                if (!colors[i].
                      equals(
                        colors[i +
                                 1])) {
                    hasDiscontinuity =
                      true;
                }
                continue;
            }
            this.
              fractions[idx] =
              fractions[i];
            loColors[idx] =
              colors[i];
            hiColors[idx] =
              colors[i +
                       1];
            normalizedIntervals[idx] =
              fractions[i +
                          1] -
                fractions[i];
            idx++;
        }
        this.
          fractions[idx] =
          fractions[fractions.
                      length -
                      1];
        if (fixLast) {
            loColors[idx] =
              (hiColors[idx] =
                 colors[colors.
                          length -
                          1]);
            normalizedIntervals[idx] =
              1 -
                fractions[fractions.
                            length -
                            1];
            idx++;
            this.
              fractions[idx] =
              1;
        }
        java.awt.geom.AffineTransform tInv =
          t.
          createInverse(
            );
        double[] m =
          new double[6];
        tInv.
          getMatrix(
            m);
        a00 =
          (float)
            m[0];
        a10 =
          (float)
            m[1];
        a01 =
          (float)
            m[2];
        a11 =
          (float)
            m[3];
        a02 =
          (float)
            m[4];
        a12 =
          (float)
            m[5];
        this.
          cycleMethod =
          cycleMethod;
        this.
          colorSpace =
          colorSpace;
        if (cm.
              getColorSpace(
                ) ==
              lrgbmodel_A.
              getColorSpace(
                ))
            dataModel =
              lrgbmodel_A;
        else
            if (cm.
                  getColorSpace(
                    ) ==
                  srgbmodel_A.
                  getColorSpace(
                    ))
                dataModel =
                  srgbmodel_A;
            else
                throw new java.lang.IllegalArgumentException(
                  "Unsupported ColorSpace for interpolation");
        calculateGradientFractions(
          loColors,
          hiColors);
        model =
          org.apache.batik.ext.awt.image.GraphicsUtil.
            coerceColorModel(
              dataModel,
              cm.
                isAlphaPremultiplied(
                  ));
    }
    protected final void calculateGradientFractions(java.awt.Color[] loColors,
                                                    java.awt.Color[] hiColors) {
        if (colorSpace ==
              org.apache.batik.ext.awt.LinearGradientPaint.
                LINEAR_RGB) {
            int[] workTbl =
              SRGBtoLinearRGB;
            for (int i =
                   0;
                 i <
                   loColors.
                     length;
                 i++) {
                loColors[i] =
                  interpolateColor(
                    workTbl,
                    loColors[i]);
                hiColors[i] =
                  interpolateColor(
                    workTbl,
                    hiColors[i]);
            }
        }
        transparencyTest =
          -16777216;
        if (cycleMethod ==
              org.apache.batik.ext.awt.MultipleGradientPaint.
                NO_CYCLE) {
            transparencyTest &=
              gradientUnderflow;
            transparencyTest &=
              gradientOverflow;
        }
        gradients =
          (new int[fractions.
                     length -
                     1][]);
        gradientsLength =
          gradients.
            length;
        int n =
          normalizedIntervals.
            length;
        float Imin =
          1;
        float[] workTbl =
          normalizedIntervals;
        for (int i =
               0;
             i <
               n;
             i++) {
            Imin =
              Imin >
                workTbl[i]
                ? workTbl[i]
                : Imin;
        }
        int estimatedSize =
          0;
        if (Imin ==
              0) {
            estimatedSize =
              java.lang.Integer.
                MAX_VALUE;
            hasDiscontinuity =
              true;
        }
        else {
            for (int i =
                   0;
                 i <
                   workTbl.
                     length;
                 i++) {
                estimatedSize +=
                  workTbl[i] /
                    Imin *
                    GRADIENT_SIZE;
            }
        }
        if (estimatedSize >
              MAX_GRADIENT_ARRAY_SIZE) {
            calculateMultipleArrayGradient(
              loColors,
              hiColors);
            if (cycleMethod ==
                  org.apache.batik.ext.awt.MultipleGradientPaint.
                    REPEAT &&
                  gradients[0][0] !=
                  gradients[gradients.
                              length -
                              1][GRADIENT_SIZE_INDEX])
                hasDiscontinuity =
                  true;
        }
        else {
            calculateSingleArrayGradient(
              loColors,
              hiColors,
              Imin);
            if (cycleMethod ==
                  org.apache.batik.ext.awt.MultipleGradientPaint.
                    REPEAT &&
                  gradient[0] !=
                  gradient[fastGradientArraySize])
                hasDiscontinuity =
                  true;
        }
        if (transparencyTest >>>
              24 ==
              255) {
            if (dataModel.
                  getColorSpace(
                    ) ==
                  lrgbmodel_NA.
                  getColorSpace(
                    ))
                dataModel =
                  lrgbmodel_NA;
            else
                if (dataModel.
                      getColorSpace(
                        ) ==
                      srgbmodel_NA.
                      getColorSpace(
                        ))
                    dataModel =
                      srgbmodel_NA;
            model =
              dataModel;
        }
    }
    private static java.awt.Color interpolateColor(int[] workTbl,
                                                   java.awt.Color inColor) {
        int oldColor =
          inColor.
          getRGB(
            );
        int newColorValue =
          (workTbl[oldColor >>
                     24 &
                     255] &
             255) <<
          24 |
          (workTbl[oldColor >>
                     16 &
                     255] &
             255) <<
          16 |
          (workTbl[oldColor >>
                     8 &
                     255] &
             255) <<
          8 |
          workTbl[oldColor &
                    255] &
          255;
        return new java.awt.Color(
          newColorValue,
          true);
    }
    private void calculateSingleArrayGradient(java.awt.Color[] loColors,
                                              java.awt.Color[] hiColors,
                                              float Imin) {
        isSimpleLookup =
          true;
        int gradientsTot =
          1;
        int aveA =
          32768;
        int aveR =
          32768;
        int aveG =
          32768;
        int aveB =
          32768;
        for (int i =
               0;
             i <
               gradients.
                 length;
             i++) {
            int nGradients =
              (int)
                (normalizedIntervals[i] /
                   Imin *
                   255.0F);
            gradientsTot +=
              nGradients;
            gradients[i] =
              (new int[nGradients]);
            int rgb1 =
              loColors[i].
              getRGB(
                );
            int rgb2 =
              hiColors[i].
              getRGB(
                );
            interpolate(
              rgb1,
              rgb2,
              gradients[i]);
            int argb =
              gradients[i][GRADIENT_SIZE /
                             2];
            float norm =
              normalizedIntervals[i];
            aveA +=
              (int)
                ((argb >>
                    8 &
                    16711680) *
                   norm);
            aveR +=
              (int)
                ((argb &
                    16711680) *
                   norm);
            aveG +=
              (int)
                ((argb <<
                    8 &
                    16711680) *
                   norm);
            aveB +=
              (int)
                ((argb <<
                    16 &
                    16711680) *
                   norm);
            transparencyTest &=
              rgb1 &
                rgb2;
        }
        gradientAverage =
          (aveA &
             16711680) <<
            8 |
            aveR &
            16711680 |
            (aveG &
               16711680) >>
            8 |
            (aveB &
               16711680) >>
            16;
        gradient =
          (new int[gradientsTot]);
        int curOffset =
          0;
        for (int i =
               0;
             i <
               gradients.
                 length;
             i++) {
            java.lang.System.
              arraycopy(
                gradients[i],
                0,
                gradient,
                curOffset,
                gradients[i].
                  length);
            curOffset +=
              gradients[i].
                length;
        }
        gradient[gradient.
                   length -
                   1] =
          hiColors[hiColors.
                     length -
                     1].
            getRGB(
              );
        if (colorSpace ==
              org.apache.batik.ext.awt.LinearGradientPaint.
                LINEAR_RGB) {
            if (dataModel.
                  getColorSpace(
                    ) ==
                  java.awt.color.ColorSpace.
                  getInstance(
                    java.awt.color.ColorSpace.
                      CS_sRGB)) {
                for (int i =
                       0;
                     i <
                       gradient.
                         length;
                     i++) {
                    gradient[i] =
                      convertEntireColorLinearRGBtoSRGB(
                        gradient[i]);
                }
                gradientAverage =
                  convertEntireColorLinearRGBtoSRGB(
                    gradientAverage);
            }
        }
        else {
            if (dataModel.
                  getColorSpace(
                    ) ==
                  java.awt.color.ColorSpace.
                  getInstance(
                    java.awt.color.ColorSpace.
                      CS_LINEAR_RGB)) {
                for (int i =
                       0;
                     i <
                       gradient.
                         length;
                     i++) {
                    gradient[i] =
                      convertEntireColorSRGBtoLinearRGB(
                        gradient[i]);
                }
                gradientAverage =
                  convertEntireColorSRGBtoLinearRGB(
                    gradientAverage);
            }
        }
        fastGradientArraySize =
          gradient.
            length -
            1;
    }
    private void calculateMultipleArrayGradient(java.awt.Color[] loColors,
                                                java.awt.Color[] hiColors) {
        isSimpleLookup =
          false;
        int rgb1;
        int rgb2;
        int aveA =
          32768;
        int aveR =
          32768;
        int aveG =
          32768;
        int aveB =
          32768;
        for (int i =
               0;
             i <
               gradients.
                 length;
             i++) {
            if (normalizedIntervals[i] ==
                  0)
                continue;
            gradients[i] =
              (new int[GRADIENT_SIZE]);
            rgb1 =
              loColors[i].
                getRGB(
                  );
            rgb2 =
              hiColors[i].
                getRGB(
                  );
            interpolate(
              rgb1,
              rgb2,
              gradients[i]);
            int argb =
              gradients[i][GRADIENT_SIZE /
                             2];
            float norm =
              normalizedIntervals[i];
            aveA +=
              (int)
                ((argb >>
                    8 &
                    16711680) *
                   norm);
            aveR +=
              (int)
                ((argb &
                    16711680) *
                   norm);
            aveG +=
              (int)
                ((argb <<
                    8 &
                    16711680) *
                   norm);
            aveB +=
              (int)
                ((argb <<
                    16 &
                    16711680) *
                   norm);
            transparencyTest &=
              rgb1;
            transparencyTest &=
              rgb2;
        }
        gradientAverage =
          (aveA &
             16711680) <<
            8 |
            aveR &
            16711680 |
            (aveG &
               16711680) >>
            8 |
            (aveB &
               16711680) >>
            16;
        if (colorSpace ==
              org.apache.batik.ext.awt.LinearGradientPaint.
                LINEAR_RGB) {
            if (dataModel.
                  getColorSpace(
                    ) ==
                  java.awt.color.ColorSpace.
                  getInstance(
                    java.awt.color.ColorSpace.
                      CS_sRGB)) {
                for (int j =
                       0;
                     j <
                       gradients.
                         length;
                     j++) {
                    for (int i =
                           0;
                         i <
                           gradients[j].
                             length;
                         i++) {
                        gradients[j][i] =
                          convertEntireColorLinearRGBtoSRGB(
                            gradients[j][i]);
                    }
                }
                gradientAverage =
                  convertEntireColorLinearRGBtoSRGB(
                    gradientAverage);
            }
        }
        else {
            if (dataModel.
                  getColorSpace(
                    ) ==
                  java.awt.color.ColorSpace.
                  getInstance(
                    java.awt.color.ColorSpace.
                      CS_LINEAR_RGB)) {
                for (int j =
                       0;
                     j <
                       gradients.
                         length;
                     j++) {
                    for (int i =
                           0;
                         i <
                           gradients[j].
                             length;
                         i++) {
                        gradients[j][i] =
                          convertEntireColorSRGBtoLinearRGB(
                            gradients[j][i]);
                    }
                }
                gradientAverage =
                  convertEntireColorSRGBtoLinearRGB(
                    gradientAverage);
            }
        }
    }
    private void interpolate(int rgb1, int rgb2,
                             int[] output) {
        int nSteps =
          output.
            length;
        float stepSize =
          1 /
          (float)
            nSteps;
        int a1 =
          rgb1 >>
          24 &
          255;
        int r1 =
          rgb1 >>
          16 &
          255;
        int g1 =
          rgb1 >>
          8 &
          255;
        int b1 =
          rgb1 &
          255;
        int da =
          (rgb2 >>
             24 &
             255) -
          a1;
        int dr =
          (rgb2 >>
             16 &
             255) -
          r1;
        int dg =
          (rgb2 >>
             8 &
             255) -
          g1;
        int db =
          (rgb2 &
             255) -
          b1;
        float tempA =
          2.0F *
          da *
          stepSize;
        float tempR =
          2.0F *
          dr *
          stepSize;
        float tempG =
          2.0F *
          dg *
          stepSize;
        float tempB =
          2.0F *
          db *
          stepSize;
        output[0] =
          rgb1;
        nSteps--;
        output[nSteps] =
          rgb2;
        for (int i =
               1;
             i <
               nSteps;
             i++) {
            float fI =
              i;
            output[i] =
              (a1 +
                 ((int)
                    (fI *
                       tempA) +
                    1 >>
                    1) &
                 255) <<
                24 |
                (r1 +
                   ((int)
                      (fI *
                         tempR) +
                      1 >>
                      1) &
                   255) <<
                16 |
                (g1 +
                   ((int)
                      (fI *
                         tempG) +
                      1 >>
                      1) &
                   255) <<
                8 |
                b1 +
                ((int)
                   (fI *
                      tempB) +
                   1 >>
                   1) &
                255;
        }
    }
    private static int convertEntireColorLinearRGBtoSRGB(int rgb) {
        int a1 =
          rgb >>
          24 &
          255;
        int r1 =
          rgb >>
          16 &
          255;
        int g1 =
          rgb >>
          8 &
          255;
        int b1 =
          rgb &
          255;
        int[] workTbl =
          LinearRGBtoSRGB;
        r1 =
          workTbl[r1];
        g1 =
          workTbl[g1];
        b1 =
          workTbl[b1];
        return a1 <<
          24 |
          r1 <<
          16 |
          g1 <<
          8 |
          b1;
    }
    private static int convertEntireColorSRGBtoLinearRGB(int rgb) {
        int a1 =
          rgb >>
          24 &
          255;
        int r1 =
          rgb >>
          16 &
          255;
        int g1 =
          rgb >>
          8 &
          255;
        int b1 =
          rgb &
          255;
        int[] workTbl =
          SRGBtoLinearRGB;
        r1 =
          workTbl[r1];
        g1 =
          workTbl[g1];
        b1 =
          workTbl[b1];
        return a1 <<
          24 |
          r1 <<
          16 |
          g1 <<
          8 |
          b1;
    }
    protected final int indexIntoGradientsArrays(float position) {
        if (cycleMethod ==
              org.apache.batik.ext.awt.MultipleGradientPaint.
                NO_CYCLE) {
            if (position >=
                  1) {
                return gradientOverflow;
            }
            else
                if (position <=
                      0) {
                    return gradientUnderflow;
                }
        }
        else
            if (cycleMethod ==
                  org.apache.batik.ext.awt.MultipleGradientPaint.
                    REPEAT) {
                position =
                  position -
                    (int)
                      position;
                if (position <
                      0) {
                    position =
                      position +
                        1;
                }
                int w =
                  0;
                int c1 =
                  0;
                int c2 =
                  0;
                if (isSimpleLookup) {
                    position *=
                      gradient.
                        length;
                    int idx1 =
                      (int)
                        position;
                    if (idx1 +
                          1 <
                          gradient.
                            length)
                        return gradient[idx1];
                    w =
                      (int)
                        ((position -
                            idx1) *
                           (1 <<
                              16));
                    c1 =
                      gradient[idx1];
                    c2 =
                      gradient[0];
                }
                else {
                    for (int i =
                           0;
                         i <
                           gradientsLength;
                         i++) {
                        if (position <
                              fractions[i +
                                          1]) {
                            float delta =
                              position -
                              fractions[i];
                            delta =
                              delta /
                                normalizedIntervals[i] *
                                GRADIENT_SIZE;
                            int index =
                              (int)
                                delta;
                            if (index +
                                  1 <
                                  gradients[i].
                                    length ||
                                  i +
                                  1 <
                                  gradientsLength)
                                return gradients[i][index];
                            w =
                              (int)
                                ((delta -
                                    index) *
                                   (1 <<
                                      16));
                            c1 =
                              gradients[i][index];
                            c2 =
                              gradients[0][0];
                            break;
                        }
                    }
                }
                return ((c1 >>
                           8 &
                           16711680) +
                          ((c2 >>>
                              24) -
                             (c1 >>>
                                24)) *
                          w &
                          16711680) <<
                  8 |
                  (c1 &
                     16711680) +
                  ((c2 >>
                      16 &
                      255) -
                     (c1 >>
                        16 &
                        255)) *
                  w &
                  16711680 |
                  ((c1 <<
                      8 &
                      16711680) +
                     ((c2 >>
                         8 &
                         255) -
                        (c1 >>
                           8 &
                           255)) *
                     w &
                     16711680) >>
                  8 |
                  ((c1 <<
                      16 &
                      16711680) +
                     ((c2 &
                         255) -
                        (c1 &
                           255)) *
                     w &
                     16711680) >>
                  16;
            }
            else {
                if (position <
                      0) {
                    position =
                      -position;
                }
                int part =
                  (int)
                    position;
                position =
                  position -
                    part;
                if ((part &
                       1) ==
                      1) {
                    position =
                      1 -
                        position;
                }
            }
        if (isSimpleLookup) {
            return gradient[(int)
                              (position *
                                 fastGradientArraySize)];
        }
        else {
            for (int i =
                   0;
                 i <
                   gradientsLength;
                 i++) {
                if (position <
                      fractions[i +
                                  1]) {
                    float delta =
                      position -
                      fractions[i];
                    int index =
                      (int)
                        (delta /
                           normalizedIntervals[i] *
                           GRADIENT_SIZE_INDEX);
                    return gradients[i][index];
                }
            }
        }
        return gradientOverflow;
    }
    protected final int indexGradientAntiAlias(float position,
                                               float sz) {
        if (cycleMethod ==
              org.apache.batik.ext.awt.MultipleGradientPaint.
                NO_CYCLE) {
            if (DEBUG)
                java.lang.System.
                  out.
                  println(
                    "NO_CYCLE");
            float p1 =
              position -
              sz /
              2;
            float p2 =
              position +
              sz /
              2;
            if (p1 >=
                  1)
                return gradientOverflow;
            if (p2 <=
                  0)
                return gradientUnderflow;
            int interior;
            float top_weight =
              0;
            float bottom_weight =
              0;
            float frac;
            if (p2 >=
                  1) {
                top_weight =
                  (p2 -
                     1) /
                    sz;
                if (p1 <=
                      0) {
                    bottom_weight =
                      -p1 /
                        sz;
                    frac =
                      1;
                    interior =
                      gradientAverage;
                }
                else {
                    frac =
                      1 -
                        p1;
                    interior =
                      getAntiAlias(
                        p1,
                        true,
                        1,
                        false,
                        1 -
                          p1,
                        1);
                }
            }
            else
                if (p1 <=
                      0) {
                    bottom_weight =
                      -p1 /
                        sz;
                    frac =
                      p2;
                    interior =
                      getAntiAlias(
                        0,
                        true,
                        p2,
                        false,
                        p2,
                        1);
                }
                else
                    return getAntiAlias(
                             p1,
                             true,
                             p2,
                             false,
                             sz,
                             1);
            int norm =
              (int)
                ((1 <<
                    16) *
                   frac /
                   sz);
            int pA =
              (interior >>>
                 20 &
                 4080) *
              norm >>
              16;
            int pR =
              (interior >>
                 12 &
                 4080) *
              norm >>
              16;
            int pG =
              (interior >>
                 4 &
                 4080) *
              norm >>
              16;
            int pB =
              (interior <<
                 4 &
                 4080) *
              norm >>
              16;
            if (bottom_weight !=
                  0) {
                int bPix =
                  gradientUnderflow;
                norm =
                  (int)
                    ((1 <<
                        16) *
                       bottom_weight);
                pA +=
                  (bPix >>>
                     20 &
                     4080) *
                    norm >>
                    16;
                pR +=
                  (bPix >>
                     12 &
                     4080) *
                    norm >>
                    16;
                pG +=
                  (bPix >>
                     4 &
                     4080) *
                    norm >>
                    16;
                pB +=
                  (bPix <<
                     4 &
                     4080) *
                    norm >>
                    16;
            }
            if (top_weight !=
                  0) {
                int tPix =
                  gradientOverflow;
                norm =
                  (int)
                    ((1 <<
                        16) *
                       top_weight);
                pA +=
                  (tPix >>>
                     20 &
                     4080) *
                    norm >>
                    16;
                pR +=
                  (tPix >>
                     12 &
                     4080) *
                    norm >>
                    16;
                pG +=
                  (tPix >>
                     4 &
                     4080) *
                    norm >>
                    16;
                pB +=
                  (tPix <<
                     4 &
                     4080) *
                    norm >>
                    16;
            }
            return (pA &
                      4080) <<
              20 |
              (pR &
                 4080) <<
              12 |
              (pG &
                 4080) <<
              4 |
              (pB &
                 4080) >>
              4;
        }
        int intSz =
          (int)
            sz;
        float weight =
          1.0F;
        if (intSz !=
              0) {
            sz -=
              intSz;
            weight =
              sz /
                (intSz +
                   sz);
            if (weight <
                  0.1)
                return gradientAverage;
        }
        if (sz >
              0.99)
            return gradientAverage;
        float p1 =
          position -
          sz /
          2;
        float p2 =
          position +
          sz /
          2;
        if (DEBUG)
            java.lang.System.
              out.
              println(
                "P1: " +
                p1 +
                " P2: " +
                p2);
        boolean p1_up =
          true;
        boolean p2_up =
          false;
        if (cycleMethod ==
              org.apache.batik.ext.awt.MultipleGradientPaint.
                REPEAT) {
            if (DEBUG)
                java.lang.System.
                  out.
                  println(
                    "REPEAT");
            p1 =
              p1 -
                (int)
                  p1;
            p2 =
              p2 -
                (int)
                  p2;
            if (p1 <
                  0)
                p1 +=
                  1;
            if (p2 <
                  0)
                p2 +=
                  1;
        }
        else {
            if (DEBUG)
                java.lang.System.
                  out.
                  println(
                    "REFLECT");
            if (p2 <
                  0) {
                p1 =
                  -p1;
                p1_up =
                  !p1_up;
                p2 =
                  -p2;
                p2_up =
                  !p2_up;
            }
            else
                if (p1 <
                      0) {
                    p1 =
                      -p1;
                    p1_up =
                      !p1_up;
                }
            int part1;
            int part2;
            part1 =
              (int)
                p1;
            p1 =
              p1 -
                part1;
            part2 =
              (int)
                p2;
            p2 =
              p2 -
                part2;
            if ((part1 &
                   1) ==
                  1) {
                p1 =
                  1 -
                    p1;
                p1_up =
                  !p1_up;
            }
            if ((part2 &
                   1) ==
                  1) {
                p2 =
                  1 -
                    p2;
                p2_up =
                  !p2_up;
            }
            if (p1 >
                  p2 &&
                  !p1_up &&
                  p2_up) {
                float t =
                  p1;
                p1 =
                  p2;
                p2 =
                  t;
                p1_up =
                  true;
                p2_up =
                  false;
            }
        }
        return getAntiAlias(
                 p1,
                 p1_up,
                 p2,
                 p2_up,
                 sz,
                 weight);
    }
    private final int getAntiAlias(float p1,
                                   boolean p1_up,
                                   float p2,
                                   boolean p2_up,
                                   float sz,
                                   float weight) {
        int ach =
          0;
        int rch =
          0;
        int gch =
          0;
        int bch =
          0;
        if (isSimpleLookup) {
            p1 *=
              fastGradientArraySize;
            p2 *=
              fastGradientArraySize;
            int idx1 =
              (int)
                p1;
            int idx2 =
              (int)
                p2;
            int i;
            int pix;
            if (p1_up &&
                  !p2_up &&
                  idx1 <=
                  idx2) {
                if (idx1 ==
                      idx2)
                    return gradient[idx1];
                for (i =
                       idx1 +
                         1;
                     i <
                       idx2;
                     i++) {
                    pix =
                      gradient[i];
                    ach +=
                      pix >>>
                        20 &
                        4080;
                    rch +=
                      pix >>>
                        12 &
                        4080;
                    gch +=
                      pix >>>
                        4 &
                        4080;
                    bch +=
                      pix <<
                        4 &
                        4080;
                }
            }
            else {
                int iStart;
                int iEnd;
                if (p1_up) {
                    iStart =
                      idx1 +
                        1;
                    iEnd =
                      fastGradientArraySize;
                }
                else {
                    iStart =
                      0;
                    iEnd =
                      idx1;
                }
                for (i =
                       iStart;
                     i <
                       iEnd;
                     i++) {
                    pix =
                      gradient[i];
                    ach +=
                      pix >>>
                        20 &
                        4080;
                    rch +=
                      pix >>>
                        12 &
                        4080;
                    gch +=
                      pix >>>
                        4 &
                        4080;
                    bch +=
                      pix <<
                        4 &
                        4080;
                }
                if (p2_up) {
                    iStart =
                      idx2 +
                        1;
                    iEnd =
                      fastGradientArraySize;
                }
                else {
                    iStart =
                      0;
                    iEnd =
                      idx2;
                }
                for (i =
                       iStart;
                     i <
                       iEnd;
                     i++) {
                    pix =
                      gradient[i];
                    ach +=
                      pix >>>
                        20 &
                        4080;
                    rch +=
                      pix >>>
                        12 &
                        4080;
                    gch +=
                      pix >>>
                        4 &
                        4080;
                    bch +=
                      pix <<
                        4 &
                        4080;
                }
            }
            int norm;
            int isz;
            isz =
              (int)
                ((1 <<
                    16) /
                   (sz *
                      fastGradientArraySize));
            ach =
              ach *
                isz >>
                16;
            rch =
              rch *
                isz >>
                16;
            gch =
              gch *
                isz >>
                16;
            bch =
              bch *
                isz >>
                16;
            if (p1_up)
                norm =
                  (int)
                    ((1 -
                        (p1 -
                           idx1)) *
                       isz);
            else
                norm =
                  (int)
                    ((p1 -
                        idx1) *
                       isz);
            pix =
              gradient[idx1];
            ach +=
              (pix >>>
                 20 &
                 4080) *
                norm >>
                16;
            rch +=
              (pix >>>
                 12 &
                 4080) *
                norm >>
                16;
            gch +=
              (pix >>>
                 4 &
                 4080) *
                norm >>
                16;
            bch +=
              (pix <<
                 4 &
                 4080) *
                norm >>
                16;
            if (p2_up)
                norm =
                  (int)
                    ((1 -
                        (p2 -
                           idx2)) *
                       isz);
            else
                norm =
                  (int)
                    ((p2 -
                        idx2) *
                       isz);
            pix =
              gradient[idx2];
            ach +=
              (pix >>>
                 20 &
                 4080) *
                norm >>
                16;
            rch +=
              (pix >>>
                 12 &
                 4080) *
                norm >>
                16;
            gch +=
              (pix >>>
                 4 &
                 4080) *
                norm >>
                16;
            bch +=
              (pix <<
                 4 &
                 4080) *
                norm >>
                16;
            ach =
              ach +
                8 >>
                4;
            rch =
              rch +
                8 >>
                4;
            gch =
              gch +
                8 >>
                4;
            bch =
              bch +
                8 >>
                4;
        }
        else {
            int idx1 =
              0;
            int idx2 =
              0;
            int i1 =
              -1;
            int i2 =
              -1;
            float f1 =
              0;
            float f2 =
              0;
            for (int i =
                   0;
                 i <
                   gradientsLength;
                 i++) {
                if (p1 <
                      fractions[i +
                                  1] &&
                      i1 ==
                      -1) {
                    i1 =
                      i;
                    f1 =
                      p1 -
                        fractions[i];
                    f1 =
                      f1 /
                        normalizedIntervals[i] *
                        GRADIENT_SIZE_INDEX;
                    idx1 =
                      (int)
                        f1;
                    if (i2 !=
                          -1)
                        break;
                }
                if (p2 <
                      fractions[i +
                                  1] &&
                      i2 ==
                      -1) {
                    i2 =
                      i;
                    f2 =
                      p2 -
                        fractions[i];
                    f2 =
                      f2 /
                        normalizedIntervals[i] *
                        GRADIENT_SIZE_INDEX;
                    idx2 =
                      (int)
                        f2;
                    if (i1 !=
                          -1)
                        break;
                }
            }
            if (i1 ==
                  -1) {
                i1 =
                  gradients.
                    length -
                    1;
                f1 =
                  (idx1 =
                     GRADIENT_SIZE_INDEX);
            }
            if (i2 ==
                  -1) {
                i2 =
                  gradients.
                    length -
                    1;
                f2 =
                  (idx2 =
                     GRADIENT_SIZE_INDEX);
            }
            if (DEBUG)
                java.lang.System.
                  out.
                  println(
                    "I1: " +
                    i1 +
                    " Idx1: " +
                    idx1 +
                    " I2: " +
                    i2 +
                    " Idx2: " +
                    idx2);
            if (i1 ==
                  i2 &&
                  idx1 <=
                  idx2 &&
                  p1_up &&
                  !p2_up)
                return gradients[i1][idx1 +
                                       idx2 +
                                       1 >>
                                       1];
            int pix;
            int norm;
            int base =
              (int)
                ((1 <<
                    16) /
                   sz);
            if (i1 <
                  i2 &&
                  p1_up &&
                  !p2_up) {
                norm =
                  (int)
                    (base *
                       normalizedIntervals[i1] *
                       (GRADIENT_SIZE_INDEX -
                          f1) /
                       GRADIENT_SIZE_INDEX);
                pix =
                  gradients[i1][idx1 +
                                  GRADIENT_SIZE >>
                                  1];
                ach +=
                  (pix >>>
                     20 &
                     4080) *
                    norm >>
                    16;
                rch +=
                  (pix >>>
                     12 &
                     4080) *
                    norm >>
                    16;
                gch +=
                  (pix >>>
                     4 &
                     4080) *
                    norm >>
                    16;
                bch +=
                  (pix <<
                     4 &
                     4080) *
                    norm >>
                    16;
                for (int i =
                       i1 +
                       1;
                     i <
                       i2;
                     i++) {
                    norm =
                      (int)
                        (base *
                           normalizedIntervals[i]);
                    pix =
                      gradients[i][GRADIENT_SIZE >>
                                     1];
                    ach +=
                      (pix >>>
                         20 &
                         4080) *
                        norm >>
                        16;
                    rch +=
                      (pix >>>
                         12 &
                         4080) *
                        norm >>
                        16;
                    gch +=
                      (pix >>>
                         4 &
                         4080) *
                        norm >>
                        16;
                    bch +=
                      (pix <<
                         4 &
                         4080) *
                        norm >>
                        16;
                }
                norm =
                  (int)
                    (base *
                       normalizedIntervals[i2] *
                       f2 /
                       GRADIENT_SIZE_INDEX);
                pix =
                  gradients[i2][idx2 +
                                  1 >>
                                  1];
                ach +=
                  (pix >>>
                     20 &
                     4080) *
                    norm >>
                    16;
                rch +=
                  (pix >>>
                     12 &
                     4080) *
                    norm >>
                    16;
                gch +=
                  (pix >>>
                     4 &
                     4080) *
                    norm >>
                    16;
                bch +=
                  (pix <<
                     4 &
                     4080) *
                    norm >>
                    16;
            }
            else {
                if (p1_up) {
                    norm =
                      (int)
                        (base *
                           normalizedIntervals[i1] *
                           (GRADIENT_SIZE_INDEX -
                              f1) /
                           GRADIENT_SIZE_INDEX);
                    pix =
                      gradients[i1][idx1 +
                                      GRADIENT_SIZE >>
                                      1];
                }
                else {
                    norm =
                      (int)
                        (base *
                           normalizedIntervals[i1] *
                           f1 /
                           GRADIENT_SIZE_INDEX);
                    pix =
                      gradients[i1][idx1 +
                                      1 >>
                                      1];
                }
                ach +=
                  (pix >>>
                     20 &
                     4080) *
                    norm >>
                    16;
                rch +=
                  (pix >>>
                     12 &
                     4080) *
                    norm >>
                    16;
                gch +=
                  (pix >>>
                     4 &
                     4080) *
                    norm >>
                    16;
                bch +=
                  (pix <<
                     4 &
                     4080) *
                    norm >>
                    16;
                if (p2_up) {
                    norm =
                      (int)
                        (base *
                           normalizedIntervals[i2] *
                           (GRADIENT_SIZE_INDEX -
                              f2) /
                           GRADIENT_SIZE_INDEX);
                    pix =
                      gradients[i2][idx2 +
                                      GRADIENT_SIZE >>
                                      1];
                }
                else {
                    norm =
                      (int)
                        (base *
                           normalizedIntervals[i2] *
                           f2 /
                           GRADIENT_SIZE_INDEX);
                    pix =
                      gradients[i2][idx2 +
                                      1 >>
                                      1];
                }
                ach +=
                  (pix >>>
                     20 &
                     4080) *
                    norm >>
                    16;
                rch +=
                  (pix >>>
                     12 &
                     4080) *
                    norm >>
                    16;
                gch +=
                  (pix >>>
                     4 &
                     4080) *
                    norm >>
                    16;
                bch +=
                  (pix <<
                     4 &
                     4080) *
                    norm >>
                    16;
                int iStart;
                int iEnd;
                if (p1_up) {
                    iStart =
                      i1 +
                        1;
                    iEnd =
                      gradientsLength;
                }
                else {
                    iStart =
                      0;
                    iEnd =
                      i1;
                }
                for (int i =
                       iStart;
                     i <
                       iEnd;
                     i++) {
                    norm =
                      (int)
                        (base *
                           normalizedIntervals[i]);
                    pix =
                      gradients[i][GRADIENT_SIZE >>
                                     1];
                    ach +=
                      (pix >>>
                         20 &
                         4080) *
                        norm >>
                        16;
                    rch +=
                      (pix >>>
                         12 &
                         4080) *
                        norm >>
                        16;
                    gch +=
                      (pix >>>
                         4 &
                         4080) *
                        norm >>
                        16;
                    bch +=
                      (pix <<
                         4 &
                         4080) *
                        norm >>
                        16;
                }
                if (p2_up) {
                    iStart =
                      i2 +
                        1;
                    iEnd =
                      gradientsLength;
                }
                else {
                    iStart =
                      0;
                    iEnd =
                      i2;
                }
                for (int i =
                       iStart;
                     i <
                       iEnd;
                     i++) {
                    norm =
                      (int)
                        (base *
                           normalizedIntervals[i]);
                    pix =
                      gradients[i][GRADIENT_SIZE >>
                                     1];
                    ach +=
                      (pix >>>
                         20 &
                         4080) *
                        norm >>
                        16;
                    rch +=
                      (pix >>>
                         12 &
                         4080) *
                        norm >>
                        16;
                    gch +=
                      (pix >>>
                         4 &
                         4080) *
                        norm >>
                        16;
                    bch +=
                      (pix <<
                         4 &
                         4080) *
                        norm >>
                        16;
                }
            }
            ach =
              ach +
                8 >>
                4;
            rch =
              rch +
                8 >>
                4;
            gch =
              gch +
                8 >>
                4;
            bch =
              bch +
                8 >>
                4;
            if (DEBUG)
                java.lang.System.
                  out.
                  println(
                    "Pix: [" +
                    ach +
                    ", " +
                    rch +
                    ", " +
                    gch +
                    ", " +
                    bch +
                    ']');
        }
        if (weight !=
              1) {
            int aveW =
              (int)
                ((1 <<
                    16) *
                   (1 -
                      weight));
            int aveA =
              (gradientAverage >>>
                 24 &
                 255) *
              aveW;
            int aveR =
              (gradientAverage >>
                 16 &
                 255) *
              aveW;
            int aveG =
              (gradientAverage >>
                 8 &
                 255) *
              aveW;
            int aveB =
              (gradientAverage &
                 255) *
              aveW;
            int iw =
              (int)
                (weight *
                   (1 <<
                      16));
            ach =
              ach *
                iw +
                aveA >>
                16;
            rch =
              rch *
                iw +
                aveR >>
                16;
            gch =
              gch *
                iw +
                aveG >>
                16;
            bch =
              bch *
                iw +
                aveB >>
                16;
        }
        return ach <<
          24 |
          rch <<
          16 |
          gch <<
          8 |
          bch;
    }
    private static int convertSRGBtoLinearRGB(int color) {
        float output;
        float input =
          color /
          255.0F;
        if (input <=
              0.04045F) {
            output =
              input /
                12.92F;
        }
        else {
            output =
              (float)
                java.lang.Math.
                pow(
                  (input +
                     0.055) /
                    1.055,
                  2.4);
        }
        int o =
          java.lang.Math.
          round(
            output *
              255.0F);
        return o;
    }
    private static int convertLinearRGBtoSRGB(int color) {
        float output;
        float input =
          color /
          255.0F;
        if (input <=
              0.0031308F) {
            output =
              input *
                12.92F;
        }
        else {
            output =
              1.055F *
                (float)
                  java.lang.Math.
                  pow(
                    input,
                    1.0 /
                      2.4) -
                0.055F;
        }
        int o =
          java.lang.Math.
          round(
            output *
              255.0F);
        return o;
    }
    public final java.awt.image.Raster getRaster(int x,
                                                 int y,
                                                 int w,
                                                 int h) {
        if (w ==
              0 ||
              h ==
              0) {
            return null;
        }
        java.awt.image.WritableRaster raster =
          saved;
        if (raster ==
              null ||
              raster.
              getWidth(
                ) <
              w ||
              raster.
              getHeight(
                ) <
              h) {
            raster =
              getCachedRaster(
                dataModel,
                w,
                h);
            saved =
              raster;
            raster =
              raster.
                createWritableChild(
                  raster.
                    getMinX(
                      ),
                  raster.
                    getMinY(
                      ),
                  w,
                  h,
                  0,
                  0,
                  null);
        }
        java.awt.image.DataBufferInt rasterDB =
          (java.awt.image.DataBufferInt)
            raster.
            getDataBuffer(
              );
        int[] pixels =
          rasterDB.
          getBankData(
            )[0];
        int off =
          rasterDB.
          getOffset(
            );
        int scanlineStride =
          ((java.awt.image.SinglePixelPackedSampleModel)
             raster.
             getSampleModel(
               )).
          getScanlineStride(
            );
        int adjust =
          scanlineStride -
          w;
        fillRaster(
          pixels,
          off,
          adjust,
          x,
          y,
          w,
          h);
        org.apache.batik.ext.awt.image.GraphicsUtil.
          coerceData(
            raster,
            dataModel,
            model.
              isAlphaPremultiplied(
                ));
        return raster;
    }
    protected abstract void fillRaster(int[] pixels,
                                       int off,
                                       int adjust,
                                       int x,
                                       int y,
                                       int w,
                                       int h);
    protected static final synchronized java.awt.image.WritableRaster getCachedRaster(java.awt.image.ColorModel cm,
                                                                                      int w,
                                                                                      int h) {
        if (cm ==
              cachedModel) {
            if (cached !=
                  null) {
                java.awt.image.WritableRaster ras =
                  (java.awt.image.WritableRaster)
                    cached.
                    get(
                      );
                if (ras !=
                      null &&
                      ras.
                      getWidth(
                        ) >=
                      w &&
                      ras.
                      getHeight(
                        ) >=
                      h) {
                    cached =
                      null;
                    return ras;
                }
            }
        }
        if (w <
              32)
            w =
              32;
        if (h <
              32)
            h =
              32;
        return cm.
          createCompatibleWritableRaster(
            w,
            h);
    }
    protected static final synchronized void putCachedRaster(java.awt.image.ColorModel cm,
                                                             java.awt.image.WritableRaster ras) {
        if (cached !=
              null) {
            java.awt.image.WritableRaster cras =
              (java.awt.image.WritableRaster)
                cached.
                get(
                  );
            if (cras !=
                  null) {
                int cw =
                  cras.
                  getWidth(
                    );
                int ch =
                  cras.
                  getHeight(
                    );
                int iw =
                  ras.
                  getWidth(
                    );
                int ih =
                  ras.
                  getHeight(
                    );
                if (cw >=
                      iw &&
                      ch >=
                      ih) {
                    return;
                }
                if (cw *
                      ch >=
                      iw *
                      ih) {
                    return;
                }
            }
        }
        cachedModel =
          cm;
        cached =
          new java.lang.ref.WeakReference(
            ras);
    }
    public final void dispose() { if (saved !=
                                        null) {
                                      putCachedRaster(
                                        model,
                                        saved);
                                      saved =
                                        null;
                                  } }
    public final java.awt.image.ColorModel getColorModel() {
        return model;
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
       "61cTC5/GdYk0ioihtNZNk6/gqtxYraCS");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
