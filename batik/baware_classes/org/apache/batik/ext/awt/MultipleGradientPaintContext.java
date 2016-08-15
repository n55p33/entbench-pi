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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "4bA4XglY0eI50SNX635XQMQWmZrRQPZXJZ1kZyVNl7VxI7ERt90trZNiMBq0" +
       "5xQJ86E3X2hNv8bzzdjpwDK0xkuDdtXs9lDBQaCwvvHreiDOIqy1mLQbmOOO" +
       "O4vhvN+tYlNkohgDB+lWqxuMGpotTdNsvWKSSRyNDVpHGUGMNtJKsNMKM1X8" +
       "msJYbksLdFVLpxC2Vrq8gIdrbmTJ3IIYtFetKtVYKtoU77foTrPGbxQ1rXDj" +
       "oAqndt2nOUSu2nanGpIRVzd6xJxZ86NJexKySRFTML7pxTHJTRO157dq1bKM" +
       "J6g4Y7q0uW4TiTqwW32o1kirsKB3it1+CJH1TqPajJyi04hN0iedvrPobsQV" +
       "PgyFeqNJUxzFFlWKA0zRuOHQUBok07G6fVeG9TFNVZuB0BobETzhvXHCL6Kw" +
       "F9fH8+UUTuWB59TxwbCzYKZNPS3i3qI7bK8VtIjVJaMsttzIWtaGUy7CegtH" +
       "sUtTYtArajBhFIstddWXNr1qY2zbpTkva+iqlOgTYdk1ys0ytOgrA01ZG2SZ" +
       "iVvGTFIUKK5GJkxLq35v0in2NMmoGBu9Qxns1IfL82IrjmOHqS6U9qJWY2l2" +
       "7tbnei9KB7jEKD18gcAjLDX1umtgCwvroLZR1cYBOyWJ1YQQ6gNk0i9bzVVt" +
       "XS62qFbsD0nbxXpDhbedTglC1lzRMvW0rurhhE5taYknXJCA19Vyo5gshzVe" +
       "6SxxabSIOcFvTVTIT0vYcDpoDkQ7WjLzhjdr07jnMZ7I8uU5paHSiimtFZKY" +
       "R1VkwTXavmCPXS1p47ZcgglFW/t1pjwsSg7VGLvlCsfLVbiXVCCxZ3U64+6w" +
       "LPPlJMAiZIiPx1NUatAbvM7zsj8U8BZhT71mz68sq77tbJQYalaw4kJT6gKj" +
       "0JvZTBPXDciPizWoiAy4uOslQ2BYTGjNpfEsZhJL8h2rTleTfpHX6jAhVhlJ" +
       "TerT1bTU4Ep9z064yYxezWozvN4oIpzTFxdiv9LVysgc3vQZiS+v5iypz7Gi" +
       "TMTy2qeShkZDurBKGoPZuBmEbsSv1lJVDTp9oimtw5kTrKlgFnNypbbs2xXc" +
       "HUtGbDaGSGkAKTRqLqWiJ04prKhAtjJSVotWtYf3qA5dDaDSWudb2nBDd5TB" +
       "DIuKNaWIxO0WpzcDOkgMGHRZhRbwJjxsYw5B9AkFo9DVWpzKFcFpNfxpg3FM" +
       "pFKrwiYz5oVYCSKooRTnMaxyMxQvVmpDtRdFSYUJ/aU1nRPduj7FVBELhXjj" +
       "1enaDKZmm6FZy5wTtYJQlGvMipDcjMvjVrXRUovuyK5qXdis13mr3k02rsph" +
       "DbRhkCYMjXSRG5TViT/tDBWTsVZTts7IYinVkpIrQAMgT9/rLFOGDhOyqmlI" +
       "uT8cRevuBOnaEs2vlaETcOQMjqEqEzcc2IornclQRDoxW7IhvzxclZ1WChWt" +
       "dW+MbeBqi7SdmTBbrtswB7yzVjpwG6WNWfGXsdN2jcQg1hWp1ZhBJbEaxpxE" +
       "o46PW+I6FDiN7C09p71uTHFz2opdwfIHUk2zKEqpRzJtYiQ3bI4jwawnJQPu" +
       "lAWOGtQlLpnNzD5aW0ZEKC2YkitOHboLvKB0zkvwqiSMJIXXBmzb83tVIeB4" +
       "p1RaNMQpWbbi2YIb8ctxp19vKpNBWSNMLlirIyYuznUfRUopTXIrodIbFRFB" +
       "KRUD2OyNFkVupS7XNjeh482iCsENFV40gSbPFAuDlia83MyrVtictaQSs6RS" +
       "QXG7+qQGz5plZVZZx0G8RnuEo/MbioVIR642mlEs8LpYnPpqsTbV2aDeoJWB" +
       "yCpJZd5x2eViyZX5GkwuphTsKCk2j/FySlbalrnBW6Oy0W14EIeIfIMmuwbf" +
       "ISqMovPG0AXA8NTwfKtfi8otVPXMulRhOg1rOWMiZjYammuWk3Wy3IdSGKvN" +
       "1skymfK9Wt8aa9JUbXdnaEPSXGKjTYvz1FkJLMrQciJNp9GsJzhB12yH8+aA" +
       "wcjQnCdaketPdaMrDfxSPB31CZ1olE1kyTGVJtMMY9yxmHp1UkRaNiUZLtwb" +
       "JabIsGbTgdVNCYOCuCc5ULQEPveyloRy");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "YAAA");
}
