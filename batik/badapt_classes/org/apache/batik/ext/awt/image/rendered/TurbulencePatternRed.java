package org.apache.batik.ext.awt.image.rendered;
public final class TurbulencePatternRed extends org.apache.batik.ext.awt.image.rendered.AbstractRed {
    static final class StitchInfo {
        int width;
        int height;
        int wrapX;
        int wrapY;
        StitchInfo() { super(); }
        StitchInfo(org.apache.batik.ext.awt.image.rendered.TurbulencePatternRed.StitchInfo stitchInfo) {
            super(
              );
            this.
              width =
              stitchInfo.
                width;
            this.
              height =
              stitchInfo.
                height;
            this.
              wrapX =
              stitchInfo.
                wrapX;
            this.
              wrapY =
              stitchInfo.
                wrapY;
        }
        final void assign(org.apache.batik.ext.awt.image.rendered.TurbulencePatternRed.StitchInfo stitchInfo) {
            this.
              width =
              stitchInfo.
                width;
            this.
              height =
              stitchInfo.
                height;
            this.
              wrapX =
              stitchInfo.
                wrapX;
            this.
              wrapY =
              stitchInfo.
                wrapY;
        }
        final void doubleFrequency() { width *= 2;
                                       height *= 2;
                                       wrapX *= 2;
                                       wrapY *= 2;
                                       wrapX -= PerlinN;
                                       wrapY -= PerlinN; }
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
           "k92Tvfb6J4NMfhF+eOL61Xf/093jN5pvfwlXZPedEPIky08yT3+deLX6GzvQ" +
           "2YPz12uu6I93evT4qevFQI/iwBkfO3u952Bab8mmqwgeZ29anZMnVIf2vMZQ" +
           "Z474wwudzj/1PKfzv5MVHwYWABayZs6physr19IOveq3X8r5fV7xweMqXwHP" +
           "43sqP/5/o/JRjT79PG3PZMUnIuiS5saKrXcC3Y91R91k1b97qOInX9IVRQRd" +
           "PLwO3j+Le/3Pcr0MfP+ua/71sv2nhvqZpy5duPMp/i/zW9WDf1PcREMXjNi2" +
           "j575H3k/7wW6YeVTcNP2BsDLv74QQa95kYJG0IX911zHz285fDGC7n1+DhF0" +
           "Lv8+2uvLEXTX9XpF0FlQHqX+SgS94jRqQAnKo5R/FEGXT1KC8fPvo3RfBTY7" +
           "pMu8P385SvKngDsgyV6/4Z1ywrq9mknOHMe+Axe67YVc6AhcPnQM5/J/Re1j" +
           "Urz9X9RV9Zmnuv13PFf7+PZSWrXlNM24XKChG7f34we49sB1ue3zOk8+8pNb" +
           "PnvTw/sAfMtW4MPQOyLbfadfBeNLL8ovb9Mv3PkHr/+9p76TH/j+Dwc9tneu" +
           "JgAA");
    }
    private org.apache.batik.ext.awt.image.rendered.TurbulencePatternRed.StitchInfo
      stitchInfo =
      null;
    private static final java.awt.geom.AffineTransform
      IDENTITY =
      new java.awt.geom.AffineTransform(
      );
    private double baseFrequencyX;
    private double baseFrequencyY;
    private int numOctaves;
    private int seed;
    private java.awt.geom.Rectangle2D tile;
    private java.awt.geom.AffineTransform txf;
    private boolean isFractalNoise;
    private int[] channels;
    double[] tx = { 1, 0 };
    double[] ty = { 0, 1 };
    private static final int RAND_m = 2147483647;
    private static final int RAND_a = 16807;
    private static final int RAND_q = 127773;
    private static final int RAND_r = 2836;
    private static final int BSize = 256;
    private static final int BM = 255;
    private static final double PerlinN = 4096;
    private final int[] latticeSelector = new int[BSize +
                                                    1];
    private final double[] gradient = new double[(BSize +
                                                    1) *
                                                   8];
    public double getBaseFrequencyX() { return baseFrequencyX;
    }
    public double getBaseFrequencyY() { return baseFrequencyY;
    }
    public int getNumOctaves() { return numOctaves;
    }
    public int getSeed() { return seed; }
    public java.awt.geom.Rectangle2D getTile() { return (java.awt.geom.Rectangle2D)
                                                          tile.
                                                          clone(
                                                            );
    }
    public boolean isFractalNoise() { return isFractalNoise;
    }
    public boolean[] getChannels() { boolean[] channels =
                                       new boolean[4];
                                     for (int i =
                                            0;
                                          i <
                                            this.
                                              channels.
                                              length;
                                          i++)
                                         channels[this.
                                                    channels[i]] =
                                           true;
                                     return channels;
    }
    public final int setupSeed(int seed) {
        if (seed <=
              0)
            seed =
              -(seed %
                  (RAND_m -
                     1)) +
                1;
        if (seed >
              RAND_m -
              1)
            seed =
              RAND_m -
                1;
        return seed;
    }
    public final int random(int seed) { int result =
                                          RAND_a *
                                          (seed %
                                             RAND_q) -
                                          RAND_r *
                                          (seed /
                                             RAND_q);
                                        if (result <=
                                              0)
                                            result +=
                                              RAND_m;
                                        return result;
    }
    private void initLattice(int seed) { double u;
                                         double v;
                                         double s;
                                         int i;
                                         int j;
                                         int k;
                                         int s1;
                                         int s2;
                                         seed =
                                           setupSeed(
                                             seed);
                                         for (k =
                                                0;
                                              k <
                                                4;
                                              k++) {
                                             for (i =
                                                    0;
                                                  i <
                                                    BSize;
                                                  i++) {
                                                 u =
                                                   (seed =
                                                      random(
                                                        seed)) %
                                                     (BSize +
                                                        BSize) -
                                                     BSize;
                                                 v =
                                                   (seed =
                                                      random(
                                                        seed)) %
                                                     (BSize +
                                                        BSize) -
                                                     BSize;
                                                 s =
                                                   1 /
                                                     java.lang.Math.
                                                     sqrt(
                                                       u *
                                                         u +
                                                         v *
                                                         v);
                                                 gradient[i *
                                                            8 +
                                                            k *
                                                            2] =
                                                   u *
                                                     s;
                                                 gradient[i *
                                                            8 +
                                                            k *
                                                            2 +
                                                            1] =
                                                   v *
                                                     s;
                                             }
                                         }
                                         for (i =
                                                0;
                                              i <
                                                BSize;
                                              i++)
                                             latticeSelector[i] =
                                               i;
                                         while (--i >
                                                  0) {
                                             k =
                                               latticeSelector[i];
                                             j =
                                               (seed =
                                                  random(
                                                    seed)) %
                                                 BSize;
                                             latticeSelector[i] =
                                               latticeSelector[j];
                                             latticeSelector[j] =
                                               k;
                                             s1 =
                                               i <<
                                                 3;
                                             s2 =
                                               j <<
                                                 3;
                                             for (j =
                                                    0;
                                                  j <
                                                    8;
                                                  j++) {
                                                 s =
                                                   gradient[s1 +
                                                              j];
                                                 gradient[s1 +
                                                            j] =
                                                   gradient[s2 +
                                                              j];
                                                 gradient[s2 +
                                                            j] =
                                                   s;
                                             }
                                         }
                                         latticeSelector[BSize] =
                                           latticeSelector[0];
                                         for (j =
                                                0;
                                              j <
                                                8;
                                              j++)
                                             gradient[BSize *
                                                        8 +
                                                        j] =
                                               gradient[j];
    }
    private static final double s_curve(final double t) {
        return t *
          t *
          (3 -
             2 *
             t);
    }
    private static final double lerp(double t,
                                     double a,
                                     double b) {
        return a +
          t *
          (b -
             a);
    }
    private final void noise2(final double[] noise,
                              double vec0,
                              double vec1) {
        int b0;
        int b1;
        final int i;
        final int j;
        final double rx0;
        final double rx1;
        final double ry0;
        final double ry1;
        final double sx;
        final double sy;
        vec0 +=
          PerlinN;
        b0 =
          (int)
            vec0 &
            BM;
        i =
          latticeSelector[b0];
        j =
          latticeSelector[b0 +
                            1];
        rx0 =
          vec0 -
            (int)
              vec0;
        rx1 =
          rx0 -
            1.0;
        sx =
          s_curve(
            rx0);
        vec1 +=
          PerlinN;
        b0 =
          (int)
            vec1;
        b1 =
          (j +
             b0 &
             BM) <<
            3;
        b0 =
          (i +
             b0 &
             BM) <<
            3;
        ry0 =
          vec1 -
            (int)
              vec1;
        ry1 =
          ry0 -
            1.0;
        sy =
          s_curve(
            ry0);
        switch (channels.
                  length) {
            case 4:
                noise[3] =
                  lerp(
                    sy,
                    lerp(
                      sx,
                      rx0 *
                        gradient[b0 +
                                   6] +
                        ry0 *
                        gradient[b0 +
                                   7],
                      rx1 *
                        gradient[b1 +
                                   6] +
                        ry0 *
                        gradient[b1 +
                                   7]),
                    lerp(
                      sx,
                      rx0 *
                        gradient[b0 +
                                   8 +
                                   6] +
                        ry1 *
                        gradient[b0 +
                                   8 +
                                   7],
                      rx1 *
                        gradient[b1 +
                                   8 +
                                   6] +
                        ry1 *
                        gradient[b1 +
                                   8 +
                                   7]));
            case 3:
                noise[2] =
                  lerp(
                    sy,
                    lerp(
                      sx,
                      rx0 *
                        gradient[b0 +
                                   4] +
                        ry0 *
                        gradient[b0 +
                                   5],
                      rx1 *
                        gradient[b1 +
                                   4] +
                        ry0 *
                        gradient[b1 +
                                   5]),
                    lerp(
                      sx,
                      rx0 *
                        gradient[b0 +
                                   8 +
                                   4] +
                        ry1 *
                        gradient[b0 +
                                   8 +
                                   5],
                      rx1 *
                        gradient[b1 +
                                   8 +
                                   4] +
                        ry1 *
                        gradient[b1 +
                                   8 +
                                   5]));
            case 2:
                noise[1] =
                  lerp(
                    sy,
                    lerp(
                      sx,
                      rx0 *
                        gradient[b0 +
                                   2] +
                        ry0 *
                        gradient[b0 +
                                   3],
                      rx1 *
                        gradient[b1 +
                                   2] +
                        ry0 *
                        gradient[b1 +
                                   3]),
                    lerp(
                      sx,
                      rx0 *
                        gradient[b0 +
                                   8 +
                                   2] +
                        ry1 *
                        gradient[b0 +
                                   8 +
                                   3],
                      rx1 *
                        gradient[b1 +
                                   8 +
                                   2] +
                        ry1 *
                        gradient[b1 +
                                   8 +
                                   3]));
            case 1:
                noise[0] =
                  lerp(
                    sy,
                    lerp(
                      sx,
                      rx0 *
                        gradient[b0 +
                                   0] +
                        ry0 *
                        gradient[b0 +
                                   1],
                      rx1 *
                        gradient[b1 +
                                   0] +
                        ry0 *
                        gradient[b1 +
                                   1]),
                    lerp(
                      sx,
                      rx0 *
                        gradient[b0 +
                                   8 +
                                   0] +
                        ry1 *
                        gradient[b0 +
                                   8 +
                                   1],
                      rx1 *
                        gradient[b1 +
                                   8 +
                                   0] +
                        ry1 *
                        gradient[b1 +
                                   8 +
                                   1]));
        }
    }
    private final void noise2Stitch(final double[] noise,
                                    final double vec0,
                                    final double vec1,
                                    final org.apache.batik.ext.awt.image.rendered.TurbulencePatternRed.StitchInfo stitchInfo) {
        int b0;
        int b1;
        final int i;
        final int j;
        final int b00;
        final int b10;
        final int b01;
        final int b11;
        double t;
        final double rx0;
        final double rx1;
        final double ry0;
        final double ry1;
        final double sx;
        final double sy;
        t =
          vec0 +
            PerlinN;
        b0 =
          (int)
            t;
        b1 =
          b0 +
            1;
        if (b1 >=
              stitchInfo.
                wrapX) {
            if (b0 >=
                  stitchInfo.
                    wrapX) {
                b0 -=
                  stitchInfo.
                    width;
                b1 -=
                  stitchInfo.
                    width;
            }
            else {
                b1 -=
                  stitchInfo.
                    width;
            }
        }
        i =
          latticeSelector[b0 &
                            BM];
        j =
          latticeSelector[b1 &
                            BM];
        rx0 =
          t -
            (int)
              t;
        rx1 =
          rx0 -
            1.0;
        sx =
          s_curve(
            rx0);
        t =
          vec1 +
            PerlinN;
        b0 =
          (int)
            t;
        b1 =
          b0 +
            1;
        if (b1 >=
              stitchInfo.
                wrapY) {
            if (b0 >=
                  stitchInfo.
                    wrapY) {
                b0 -=
                  stitchInfo.
                    height;
                b1 -=
                  stitchInfo.
                    height;
            }
            else {
                b1 -=
                  stitchInfo.
                    height;
            }
        }
        b00 =
          (i +
             b0 &
             BM) <<
            3;
        b10 =
          (j +
             b0 &
             BM) <<
            3;
        b01 =
          (i +
             b1 &
             BM) <<
            3;
        b11 =
          (j +
             b1 &
             BM) <<
            3;
        ry0 =
          t -
            (int)
              t;
        ry1 =
          ry0 -
            1.0;
        sy =
          s_curve(
            ry0);
        switch (channels.
                  length) {
            case 4:
                noise[3] =
                  lerp(
                    sy,
                    lerp(
                      sx,
                      rx0 *
                        gradient[b00 +
                                   6] +
                        ry0 *
                        gradient[b00 +
                                   7],
                      rx1 *
                        gradient[b10 +
                                   6] +
                        ry0 *
                        gradient[b10 +
                                   7]),
                    lerp(
                      sx,
                      rx0 *
                        gradient[b01 +
                                   6] +
                        ry1 *
                        gradient[b01 +
                                   7],
                      rx1 *
                        gradient[b11 +
                                   6] +
                        ry1 *
                        gradient[b11 +
                                   7]));
            case 3:
                noise[2] =
                  lerp(
                    sy,
                    lerp(
                      sx,
                      rx0 *
                        gradient[b00 +
                                   4] +
                        ry0 *
                        gradient[b00 +
                                   5],
                      rx1 *
                        gradient[b10 +
                                   4] +
                        ry0 *
                        gradient[b10 +
                                   5]),
                    lerp(
                      sx,
                      rx0 *
                        gradient[b01 +
                                   4] +
                        ry1 *
                        gradient[b01 +
                                   5],
                      rx1 *
                        gradient[b11 +
                                   4] +
                        ry1 *
                        gradient[b11 +
                                   5]));
            case 2:
                noise[1] =
                  lerp(
                    sy,
                    lerp(
                      sx,
                      rx0 *
                        gradient[b00 +
                                   2] +
                        ry0 *
                        gradient[b00 +
                                   3],
                      rx1 *
                        gradient[b10 +
                                   2] +
                        ry0 *
                        gradient[b10 +
                                   3]),
                    lerp(
                      sx,
                      rx0 *
                        gradient[b01 +
                                   2] +
                        ry1 *
                        gradient[b01 +
                                   3],
                      rx1 *
                        gradient[b11 +
                                   2] +
                        ry1 *
                        gradient[b11 +
                                   3]));
            case 1:
                noise[0] =
                  lerp(
                    sy,
                    lerp(
                      sx,
                      rx0 *
                        gradient[b00 +
                                   0] +
                        ry0 *
                        gradient[b00 +
                                   1],
                      rx1 *
                        gradient[b10 +
                                   0] +
                        ry0 *
                        gradient[b10 +
                                   1]),
                    lerp(
                      sx,
                      rx0 *
                        gradient[b01 +
                                   0] +
                        ry1 *
                        gradient[b01 +
                                   1],
                      rx1 *
                        gradient[b11 +
                                   0] +
                        ry1 *
                        gradient[b11 +
                                   1]));
        }
    }
    private final int turbulence_4(double pointX,
                                   double pointY,
                                   final double[] fSum) {
        double n;
        double ratio =
          255;
        int i;
        int j;
        int b0;
        int b1;
        int nOctave;
        double px;
        double py;
        double rx0;
        double rx1;
        double ry0;
        double ry1;
        double sx;
        double sy;
        pointX *=
          baseFrequencyX;
        pointY *=
          baseFrequencyY;
        fSum[0] =
          (fSum[1] =
             (fSum[2] =
                (fSum[3] =
                   0)));
        for (nOctave =
               numOctaves;
             nOctave >
               0;
             nOctave--) {
            px =
              pointX +
                PerlinN;
            b0 =
              (int)
                px &
                BM;
            i =
              latticeSelector[b0];
            j =
              latticeSelector[b0 +
                                1];
            rx0 =
              px -
                (int)
                  px;
            rx1 =
              rx0 -
                1.0;
            sx =
              s_curve(
                rx0);
            py =
              pointY +
                PerlinN;
            b0 =
              (int)
                py &
                BM;
            b1 =
              b0 +
                1 &
                BM;
            b1 =
              (j +
                 b0 &
                 BM) <<
                3;
            b0 =
              (i +
                 b0 &
                 BM) <<
                3;
            ry0 =
              py -
                (int)
                  py;
            ry1 =
              ry0 -
                1.0;
            sy =
              s_curve(
                ry0);
            n =
              lerp(
                sy,
                lerp(
                  sx,
                  rx0 *
                    gradient[b0 +
                               0] +
                    ry0 *
                    gradient[b0 +
                               1],
                  rx1 *
                    gradient[b1 +
                               0] +
                    ry0 *
                    gradient[b1 +
                               1]),
                lerp(
                  sx,
                  rx0 *
                    gradient[b0 +
                               8 +
                               0] +
                    ry1 *
                    gradient[b0 +
                               8 +
                               1],
                  rx1 *
                    gradient[b1 +
                               8 +
                               0] +
                    ry1 *
                    gradient[b1 +
                               8 +
                               1]));
            if (n <
                  0)
                fSum[0] -=
                  n *
                    ratio;
            else
                fSum[0] +=
                  n *
                    ratio;
            n =
              lerp(
                sy,
                lerp(
                  sx,
                  rx0 *
                    gradient[b0 +
                               2] +
                    ry0 *
                    gradient[b0 +
                               3],
                  rx1 *
                    gradient[b1 +
                               2] +
                    ry0 *
                    gradient[b1 +
                               3]),
                lerp(
                  sx,
                  rx0 *
                    gradient[b0 +
                               8 +
                               2] +
                    ry1 *
                    gradient[b0 +
                               8 +
                               3],
                  rx1 *
                    gradient[b1 +
                               8 +
                               2] +
                    ry1 *
                    gradient[b1 +
                               8 +
                               3]));
            if (n <
                  0)
                fSum[1] -=
                  n *
                    ratio;
            else
                fSum[1] +=
                  n *
                    ratio;
            n =
              lerp(
                sy,
                lerp(
                  sx,
                  rx0 *
                    gradient[b0 +
                               4] +
                    ry0 *
                    gradient[b0 +
                               5],
                  rx1 *
                    gradient[b1 +
                               4] +
                    ry0 *
                    gradient[b1 +
                               5]),
                lerp(
                  sx,
                  rx0 *
                    gradient[b0 +
                               8 +
                               4] +
                    ry1 *
                    gradient[b0 +
                               8 +
                               5],
                  rx1 *
                    gradient[b1 +
                               8 +
                               4] +
                    ry1 *
                    gradient[b1 +
                               8 +
                               5]));
            if (n <
                  0)
                fSum[2] -=
                  n *
                    ratio;
            else
                fSum[2] +=
                  n *
                    ratio;
            n =
              lerp(
                sy,
                lerp(
                  sx,
                  rx0 *
                    gradient[b0 +
                               6] +
                    ry0 *
                    gradient[b0 +
                               7],
                  rx1 *
                    gradient[b1 +
                               6] +
                    ry0 *
                    gradient[b1 +
                               7]),
                lerp(
                  sx,
                  rx0 *
                    gradient[b0 +
                               8 +
                               6] +
                    ry1 *
                    gradient[b0 +
                               8 +
                               7],
                  rx1 *
                    gradient[b1 +
                               8 +
                               6] +
                    ry1 *
                    gradient[b1 +
                               8 +
                               7]));
            if (n <
                  0)
                fSum[3] -=
                  n *
                    ratio;
            else
                fSum[3] +=
                  n *
                    ratio;
            ratio *=
              0.5;
            pointX *=
              2;
            pointY *=
              2;
        }
        i =
          (int)
            fSum[0];
        if ((i &
               -256) ==
              0)
            j =
              i <<
                16;
        else
            j =
              (i &
                 -2147483648) !=
                0
                ? 0
                : 16711680;
        i =
          (int)
            fSum[1];
        if ((i &
               -256) ==
              0)
            j |=
              i <<
                8;
        else
            j |=
              (i &
                 -2147483648) !=
                0
                ? 0
                : 65280;
        i =
          (int)
            fSum[2];
        if ((i &
               -256) ==
              0)
            j |=
              i;
        else
            j |=
              (i &
                 -2147483648) !=
                0
                ? 0
                : 255;
        i =
          (int)
            fSum[3];
        if ((i &
               -256) ==
              0)
            j |=
              i <<
                24;
        else
            j |=
              (i &
                 -2147483648) !=
                0
                ? 0
                : -16777216;
        return j;
    }
    private final void turbulence(final int[] rgb,
                                  double pointX,
                                  double pointY,
                                  final double[] fSum,
                                  final double[] noise) {
        fSum[0] =
          (fSum[1] =
             (fSum[2] =
                (fSum[3] =
                   0)));
        double ratio =
          255;
        pointX *=
          baseFrequencyX;
        pointY *=
          baseFrequencyY;
        switch (channels.
                  length) {
            case 4:
                for (int nOctave =
                       0;
                     nOctave <
                       numOctaves;
                     nOctave++) {
                    noise2(
                      noise,
                      pointX,
                      pointY);
                    if (noise[0] <
                          0)
                        fSum[0] -=
                          noise[0] *
                            ratio;
                    else
                        fSum[0] +=
                          noise[0] *
                            ratio;
                    if (noise[1] <
                          0)
                        fSum[1] -=
                          noise[1] *
                            ratio;
                    else
                        fSum[1] +=
                          noise[1] *
                            ratio;
                    if (noise[2] <
                          0)
                        fSum[2] -=
                          noise[2] *
                            ratio;
                    else
                        fSum[2] +=
                          noise[2] *
                            ratio;
                    if (noise[3] <
                          0)
                        fSum[3] -=
                          noise[3] *
                            ratio;
                    else
                        fSum[3] +=
                          noise[3] *
                            ratio;
                    ratio *=
                      0.5;
                    pointX *=
                      2;
                    pointY *=
                      2;
                }
                rgb[0] =
                  (int)
                    fSum[0];
                if ((rgb[0] &
                       -256) !=
                      0)
                    rgb[0] =
                      (rgb[0] &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
                rgb[1] =
                  (int)
                    fSum[1];
                if ((rgb[1] &
                       -256) !=
                      0)
                    rgb[1] =
                      (rgb[1] &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
                rgb[2] =
                  (int)
                    fSum[2];
                if ((rgb[2] &
                       -256) !=
                      0)
                    rgb[2] =
                      (rgb[2] &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
                rgb[3] =
                  (int)
                    fSum[3];
                if ((rgb[3] &
                       -256) !=
                      0)
                    rgb[3] =
                      (rgb[3] &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
                break;
            case 3:
                for (int nOctave =
                       0;
                     nOctave <
                       numOctaves;
                     nOctave++) {
                    noise2(
                      noise,
                      pointX,
                      pointY);
                    if (noise[2] <
                          0)
                        fSum[2] -=
                          noise[2] *
                            ratio;
                    else
                        fSum[2] +=
                          noise[2] *
                            ratio;
                    if (noise[1] <
                          0)
                        fSum[1] -=
                          noise[1] *
                            ratio;
                    else
                        fSum[1] +=
                          noise[1] *
                            ratio;
                    if (noise[0] <
                          0)
                        fSum[0] -=
                          noise[0] *
                            ratio;
                    else
                        fSum[0] +=
                          noise[0] *
                            ratio;
                    ratio *=
                      0.5;
                    pointX *=
                      2;
                    pointY *=
                      2;
                }
                rgb[2] =
                  (int)
                    fSum[2];
                if ((rgb[2] &
                       -256) !=
                      0)
                    rgb[2] =
                      (rgb[2] &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
                rgb[1] =
                  (int)
                    fSum[1];
                if ((rgb[1] &
                       -256) !=
                      0)
                    rgb[1] =
                      (rgb[1] &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
                rgb[0] =
                  (int)
                    fSum[0];
                if ((rgb[0] &
                       -256) !=
                      0)
                    rgb[0] =
                      (rgb[0] &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
                break;
            case 2:
                for (int nOctave =
                       0;
                     nOctave <
                       numOctaves;
                     nOctave++) {
                    noise2(
                      noise,
                      pointX,
                      pointY);
                    if (noise[1] <
                          0)
                        fSum[1] -=
                          noise[1] *
                            ratio;
                    else
                        fSum[1] +=
                          noise[1] *
                            ratio;
                    if (noise[0] <
                          0)
                        fSum[0] -=
                          noise[0] *
                            ratio;
                    else
                        fSum[0] +=
                          noise[0] *
                            ratio;
                    ratio *=
                      0.5;
                    pointX *=
                      2;
                    pointY *=
                      2;
                }
                rgb[1] =
                  (int)
                    fSum[1];
                if ((rgb[1] &
                       -256) !=
                      0)
                    rgb[1] =
                      (rgb[1] &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
                rgb[0] =
                  (int)
                    fSum[0];
                if ((rgb[0] &
                       -256) !=
                      0)
                    rgb[0] =
                      (rgb[0] &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
                break;
            case 1:
                for (int nOctave =
                       0;
                     nOctave <
                       numOctaves;
                     nOctave++) {
                    noise2(
                      noise,
                      pointX,
                      pointY);
                    if (noise[0] <
                          0)
                        fSum[0] -=
                          noise[0] *
                            ratio;
                    else
                        fSum[0] +=
                          noise[0] *
                            ratio;
                    ratio *=
                      0.5;
                    pointX *=
                      2;
                    pointY *=
                      2;
                }
                rgb[0] =
                  (int)
                    fSum[0];
                if ((rgb[0] &
                       -256) !=
                      0)
                    rgb[0] =
                      (rgb[0] &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
                break;
        }
    }
    private final void turbulenceStitch(final int[] rgb,
                                        double pointX,
                                        double pointY,
                                        final double[] fSum,
                                        final double[] noise,
                                        org.apache.batik.ext.awt.image.rendered.TurbulencePatternRed.StitchInfo stitchInfo) {
        double ratio =
          1;
        pointX *=
          baseFrequencyX;
        pointY *=
          baseFrequencyY;
        fSum[0] =
          (fSum[1] =
             (fSum[2] =
                (fSum[3] =
                   0)));
        switch (channels.
                  length) {
            case 4:
                for (int nOctave =
                       0;
                     nOctave <
                       numOctaves;
                     nOctave++) {
                    noise2Stitch(
                      noise,
                      pointX,
                      pointY,
                      stitchInfo);
                    if (noise[3] <
                          0)
                        fSum[3] -=
                          noise[3] *
                            ratio;
                    else
                        fSum[3] +=
                          noise[3] *
                            ratio;
                    if (noise[2] <
                          0)
                        fSum[2] -=
                          noise[2] *
                            ratio;
                    else
                        fSum[2] +=
                          noise[2] *
                            ratio;
                    if (noise[1] <
                          0)
                        fSum[1] -=
                          noise[1] *
                            ratio;
                    else
                        fSum[1] +=
                          noise[1] *
                            ratio;
                    if (noise[0] <
                          0)
                        fSum[0] -=
                          noise[0] *
                            ratio;
                    else
                        fSum[0] +=
                          noise[0] *
                            ratio;
                    ratio *=
                      0.5;
                    pointX *=
                      2;
                    pointY *=
                      2;
                    stitchInfo.
                      doubleFrequency(
                        );
                }
                rgb[3] =
                  (int)
                    (fSum[3] *
                       255);
                if ((rgb[3] &
                       -256) !=
                      0)
                    rgb[3] =
                      (rgb[3] &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
                rgb[2] =
                  (int)
                    (fSum[2] *
                       255);
                if ((rgb[2] &
                       -256) !=
                      0)
                    rgb[2] =
                      (rgb[2] &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
                rgb[1] =
                  (int)
                    (fSum[1] *
                       255);
                if ((rgb[1] &
                       -256) !=
                      0)
                    rgb[1] =
                      (rgb[1] &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
                rgb[0] =
                  (int)
                    (fSum[0] *
                       255);
                if ((rgb[0] &
                       -256) !=
                      0)
                    rgb[0] =
                      (rgb[0] &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
                break;
            case 3:
                for (int nOctave =
                       0;
                     nOctave <
                       numOctaves;
                     nOctave++) {
                    noise2Stitch(
                      noise,
                      pointX,
                      pointY,
                      stitchInfo);
                    if (noise[2] <
                          0)
                        fSum[2] -=
                          noise[2] *
                            ratio;
                    else
                        fSum[2] +=
                          noise[2] *
                            ratio;
                    if (noise[1] <
                          0)
                        fSum[1] -=
                          noise[1] *
                            ratio;
                    else
                        fSum[1] +=
                          noise[1] *
                            ratio;
                    if (noise[0] <
                          0)
                        fSum[0] -=
                          noise[0] *
                            ratio;
                    else
                        fSum[0] +=
                          noise[0] *
                            ratio;
                    ratio *=
                      0.5;
                    pointX *=
                      2;
                    pointY *=
                      2;
                    stitchInfo.
                      doubleFrequency(
                        );
                }
                rgb[2] =
                  (int)
                    (fSum[2] *
                       255);
                if ((rgb[2] &
                       -256) !=
                      0)
                    rgb[2] =
                      (rgb[2] &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
                rgb[1] =
                  (int)
                    (fSum[1] *
                       255);
                if ((rgb[1] &
                       -256) !=
                      0)
                    rgb[1] =
                      (rgb[1] &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
                rgb[0] =
                  (int)
                    (fSum[0] *
                       255);
                if ((rgb[0] &
                       -256) !=
                      0)
                    rgb[0] =
                      (rgb[0] &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
                break;
            case 2:
                for (int nOctave =
                       0;
                     nOctave <
                       numOctaves;
                     nOctave++) {
                    noise2Stitch(
                      noise,
                      pointX,
                      pointY,
                      stitchInfo);
                    if (noise[1] <
                          0)
                        fSum[1] -=
                          noise[1] *
                            ratio;
                    else
                        fSum[1] +=
                          noise[1] *
                            ratio;
                    if (noise[0] <
                          0)
                        fSum[0] -=
                          noise[0] *
                            ratio;
                    else
                        fSum[0] +=
                          noise[0] *
                            ratio;
                    ratio *=
                      0.5;
                    pointX *=
                      2;
                    pointY *=
                      2;
                    stitchInfo.
                      doubleFrequency(
                        );
                }
                rgb[1] =
                  (int)
                    (fSum[1] *
                       255);
                if ((rgb[1] &
                       -256) !=
                      0)
                    rgb[1] =
                      (rgb[1] &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
                rgb[0] =
                  (int)
                    (fSum[0] *
                       255);
                if ((rgb[0] &
                       -256) !=
                      0)
                    rgb[0] =
                      (rgb[0] &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
                break;
            case 1:
                for (int nOctave =
                       0;
                     nOctave <
                       numOctaves;
                     nOctave++) {
                    noise2Stitch(
                      noise,
                      pointX,
                      pointY,
                      stitchInfo);
                    if (noise[0] <
                          0)
                        fSum[0] -=
                          noise[0] *
                            ratio;
                    else
                        fSum[0] +=
                          noise[0] *
                            ratio;
                    ratio *=
                      0.5;
                    pointX *=
                      2;
                    pointY *=
                      2;
                    stitchInfo.
                      doubleFrequency(
                        );
                }
                rgb[0] =
                  (int)
                    (fSum[0] *
                       255);
                if ((rgb[0] &
                       -256) !=
                      0)
                    rgb[0] =
                      (rgb[0] &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
                break;
        }
    }
    private final int turbulenceFractal_4(double pointX,
                                          double pointY,
                                          final double[] fSum) {
        int b0;
        int b1;
        int nOctave;
        int i;
        int j;
        double px;
        double py;
        double rx0;
        double rx1;
        double ry0;
        double ry1;
        double sx;
        double sy;
        double ratio =
          127.5;
        pointX *=
          baseFrequencyX;
        pointY *=
          baseFrequencyY;
        fSum[0] =
          (fSum[1] =
             (fSum[2] =
                (fSum[3] =
                   127.5)));
        for (nOctave =
               numOctaves;
             nOctave >
               0;
             nOctave--) {
            px =
              pointX +
                PerlinN;
            b0 =
              (int)
                px &
                BM;
            i =
              latticeSelector[b0];
            j =
              latticeSelector[b0 +
                                1];
            rx0 =
              px -
                (int)
                  px;
            rx1 =
              rx0 -
                1.0;
            sx =
              s_curve(
                rx0);
            py =
              pointY +
                PerlinN;
            b0 =
              (int)
                py &
                BM;
            b1 =
              b0 +
                1 &
                BM;
            b1 =
              (j +
                 b0 &
                 BM) <<
                3;
            b0 =
              (i +
                 b0 &
                 BM) <<
                3;
            ry0 =
              py -
                (int)
                  py;
            ry1 =
              ry0 -
                1.0;
            sy =
              s_curve(
                ry0);
            fSum[0] +=
              lerp(
                sy,
                lerp(
                  sx,
                  rx0 *
                    gradient[b0 +
                               0] +
                    ry0 *
                    gradient[b0 +
                               1],
                  rx1 *
                    gradient[b1 +
                               0] +
                    ry0 *
                    gradient[b1 +
                               1]),
                lerp(
                  sx,
                  rx0 *
                    gradient[b0 +
                               8 +
                               0] +
                    ry1 *
                    gradient[b0 +
                               8 +
                               1],
                  rx1 *
                    gradient[b1 +
                               8 +
                               0] +
                    ry1 *
                    gradient[b1 +
                               8 +
                               1])) *
                ratio;
            fSum[1] +=
              lerp(
                sy,
                lerp(
                  sx,
                  rx0 *
                    gradient[b0 +
                               2] +
                    ry0 *
                    gradient[b0 +
                               3],
                  rx1 *
                    gradient[b1 +
                               2] +
                    ry0 *
                    gradient[b1 +
                               3]),
                lerp(
                  sx,
                  rx0 *
                    gradient[b0 +
                               8 +
                               2] +
                    ry1 *
                    gradient[b0 +
                               8 +
                               3],
                  rx1 *
                    gradient[b1 +
                               8 +
                               2] +
                    ry1 *
                    gradient[b1 +
                               8 +
                               3])) *
                ratio;
            fSum[2] +=
              lerp(
                sy,
                lerp(
                  sx,
                  rx0 *
                    gradient[b0 +
                               4] +
                    ry0 *
                    gradient[b0 +
                               5],
                  rx1 *
                    gradient[b1 +
                               4] +
                    ry0 *
                    gradient[b1 +
                               5]),
                lerp(
                  sx,
                  rx0 *
                    gradient[b0 +
                               8 +
                               4] +
                    ry1 *
                    gradient[b0 +
                               8 +
                               5],
                  rx1 *
                    gradient[b1 +
                               8 +
                               4] +
                    ry1 *
                    gradient[b1 +
                               8 +
                               5])) *
                ratio;
            fSum[3] +=
              lerp(
                sy,
                lerp(
                  sx,
                  rx0 *
                    gradient[b0 +
                               6] +
                    ry0 *
                    gradient[b0 +
                               7],
                  rx1 *
                    gradient[b1 +
                               6] +
                    ry0 *
                    gradient[b1 +
                               7]),
                lerp(
                  sx,
                  rx0 *
                    gradient[b0 +
                               8 +
                               6] +
                    ry1 *
                    gradient[b0 +
                               8 +
                               7],
                  rx1 *
                    gradient[b1 +
                               8 +
                               6] +
                    ry1 *
                    gradient[b1 +
                               8 +
                               7])) *
                ratio;
            ratio *=
              0.5;
            pointX *=
              2;
            pointY *=
              2;
        }
        i =
          (int)
            fSum[0];
        if ((i &
               -256) ==
              0)
            j =
              i <<
                16;
        else
            j =
              (i &
                 -2147483648) !=
                0
                ? 0
                : 16711680;
        i =
          (int)
            fSum[1];
        if ((i &
               -256) ==
              0)
            j |=
              i <<
                8;
        else
            j |=
              (i &
                 -2147483648) !=
                0
                ? 0
                : 65280;
        i =
          (int)
            fSum[2];
        if ((i &
               -256) ==
              0)
            j |=
              i;
        else
            j |=
              (i &
                 -2147483648) !=
                0
                ? 0
                : 255;
        i =
          (int)
            fSum[3];
        if ((i &
               -256) ==
              0)
            j |=
              i <<
                24;
        else
            j |=
              (i &
                 -2147483648) !=
                0
                ? 0
                : -16777216;
        return j;
    }
    private final void turbulenceFractal(final int[] rgb,
                                         double pointX,
                                         double pointY,
                                         final double[] fSum,
                                         final double[] noise) {
        double ratio =
          127.5;
        int nOctave;
        fSum[0] =
          (fSum[1] =
             (fSum[2] =
                (fSum[3] =
                   127.5)));
        pointX *=
          baseFrequencyX;
        pointY *=
          baseFrequencyY;
        for (nOctave =
               numOctaves;
             nOctave >
               0;
             nOctave--) {
            noise2(
              noise,
              pointX,
              pointY);
            switch (channels.
                      length) {
                case 4:
                    fSum[3] +=
                      noise[3] *
                        ratio;
                case 3:
                    fSum[2] +=
                      noise[2] *
                        ratio;
                case 2:
                    fSum[1] +=
                      noise[1] *
                        ratio;
                case 1:
                    fSum[0] +=
                      noise[0] *
                        ratio;
            }
            ratio *=
              0.5;
            pointX *=
              2;
            pointY *=
              2;
        }
        switch (channels.
                  length) {
            case 4:
                rgb[3] =
                  (int)
                    fSum[3];
                if ((rgb[3] &
                       -256) !=
                      0)
                    rgb[3] =
                      (rgb[3] &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
            case 3:
                rgb[2] =
                  (int)
                    fSum[2];
                if ((rgb[2] &
                       -256) !=
                      0)
                    rgb[2] =
                      (rgb[2] &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
            case 2:
                rgb[1] =
                  (int)
                    fSum[1];
                if ((rgb[1] &
                       -256) !=
                      0)
                    rgb[1] =
                      (rgb[1] &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
            case 1:
                rgb[0] =
                  (int)
                    fSum[0];
                if ((rgb[0] &
                       -256) !=
                      0)
                    rgb[0] =
                      (rgb[0] &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
        }
    }
    private final void turbulenceFractalStitch(final int[] rgb,
                                               double pointX,
                                               double pointY,
                                               final double[] fSum,
                                               final double[] noise,
                                               org.apache.batik.ext.awt.image.rendered.TurbulencePatternRed.StitchInfo stitchInfo) {
        double ratio =
          127.5;
        int nOctave;
        fSum[0] =
          (fSum[1] =
             (fSum[2] =
                (fSum[3] =
                   127.5)));
        pointX *=
          baseFrequencyX;
        pointY *=
          baseFrequencyY;
        for (nOctave =
               numOctaves;
             nOctave >
               0;
             nOctave--) {
            noise2Stitch(
              noise,
              pointX,
              pointY,
              stitchInfo);
            switch (channels.
                      length) {
                case 4:
                    fSum[3] +=
                      noise[3] *
                        ratio;
                case 3:
                    fSum[2] +=
                      noise[2] *
                        ratio;
                case 2:
                    fSum[1] +=
                      noise[1] *
                        ratio;
                case 1:
                    fSum[0] +=
                      noise[0] *
                        ratio;
            }
            ratio *=
              0.5;
            pointX *=
              2;
            pointY *=
              2;
            stitchInfo.
              doubleFrequency(
                );
        }
        switch (channels.
                  length) {
            case 4:
                rgb[3] =
                  (int)
                    fSum[3];
                if ((rgb[3] &
                       -256) !=
                      0)
                    rgb[3] =
                      (rgb[3] &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
            case 3:
                rgb[2] =
                  (int)
                    fSum[2];
                if ((rgb[2] &
                       -256) !=
                      0)
                    rgb[2] =
                      (rgb[2] &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
            case 2:
                rgb[1] =
                  (int)
                    fSum[1];
                if ((rgb[1] &
                       -256) !=
                      0)
                    rgb[1] =
                      (rgb[1] &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
            case 1:
                rgb[0] =
                  (int)
                    fSum[0];
                if ((rgb[0] &
                       -256) !=
                      0)
                    rgb[0] =
                      (rgb[0] &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
        }
    }
    public java.awt.image.WritableRaster copyData(java.awt.image.WritableRaster dest) {
        if (dest ==
              null)
            throw new java.lang.IllegalArgumentException(
              "Cannot generate a noise pattern into a null raster");
        int w =
          dest.
          getWidth(
            );
        int h =
          dest.
          getHeight(
            );
        java.awt.image.DataBufferInt dstDB =
          (java.awt.image.DataBufferInt)
            dest.
            getDataBuffer(
              );
        java.awt.image.SinglePixelPackedSampleModel sppsm;
        int minX =
          dest.
          getMinX(
            );
        int minY =
          dest.
          getMinY(
            );
        sppsm =
          (java.awt.image.SinglePixelPackedSampleModel)
            dest.
            getSampleModel(
              );
        int dstOff =
          dstDB.
          getOffset(
            ) +
          sppsm.
          getOffset(
            minX -
              dest.
              getSampleModelTranslateX(
                ),
            minY -
              dest.
              getSampleModelTranslateY(
                ));
        final int[] destPixels =
          dstDB.
          getBankData(
            )[0];
        int dstAdjust =
          sppsm.
          getScanlineStride(
            ) -
          w;
        int i;
        int end;
        int dp =
          dstOff;
        final int[] rgb =
          new int[4];
        final double[] fSum =
          { 0,
        0,
        0,
        0 };
        final double[] noise =
          { 0,
        0,
        0,
        0 };
        final double tx0;
        final double tx1;
        final double ty0;
        final double ty1;
        tx0 =
          tx[0];
        tx1 =
          tx[1];
        ty0 =
          ty[0] -
            w *
            tx0;
        ty1 =
          ty[1] -
            w *
            tx1;
        double[] p =
          { minX,
        minY };
        txf.
          transform(
            p,
            0,
            p,
            0,
            1);
        double point_0 =
          p[0];
        double point_1 =
          p[1];
        if (isFractalNoise) {
            if (stitchInfo ==
                  null) {
                if (channels.
                      length ==
                      4) {
                    for (i =
                           0;
                         i <
                           h;
                         i++) {
                        for (end =
                               dp +
                                 w;
                             dp <
                               end;
                             dp++) {
                            destPixels[dp] =
                              turbulenceFractal_4(
                                point_0,
                                point_1,
                                fSum);
                            point_0 +=
                              tx0;
                            point_1 +=
                              tx1;
                        }
                        point_0 +=
                          ty0;
                        point_1 +=
                          ty1;
                        dp +=
                          dstAdjust;
                    }
                }
                else {
                    for (i =
                           0;
                         i <
                           h;
                         i++) {
                        for (end =
                               dp +
                                 w;
                             dp <
                               end;
                             dp++) {
                            turbulenceFractal(
                              rgb,
                              point_0,
                              point_1,
                              fSum,
                              noise);
                            destPixels[dp] =
                              rgb[3] <<
                                24 |
                                rgb[0] <<
                                16 |
                                rgb[1] <<
                                8 |
                                rgb[2];
                            point_0 +=
                              tx0;
                            point_1 +=
                              tx1;
                        }
                        point_0 +=
                          ty0;
                        point_1 +=
                          ty1;
                        dp +=
                          dstAdjust;
                    }
                }
            }
            else {
                org.apache.batik.ext.awt.image.rendered.TurbulencePatternRed.StitchInfo si =
                  new org.apache.batik.ext.awt.image.rendered.TurbulencePatternRed.StitchInfo(
                  );
                for (i =
                       0;
                     i <
                       h;
                     i++) {
                    for (end =
                           dp +
                             w;
                         dp <
                           end;
                         dp++) {
                        si.
                          assign(
                            this.
                              stitchInfo);
                        turbulenceFractalStitch(
                          rgb,
                          point_0,
                          point_1,
                          fSum,
                          noise,
                          si);
                        destPixels[dp] =
                          rgb[3] <<
                            24 |
                            rgb[0] <<
                            16 |
                            rgb[1] <<
                            8 |
                            rgb[2];
                        point_0 +=
                          tx0;
                        point_1 +=
                          tx1;
                    }
                    point_0 +=
                      ty0;
                    point_1 +=
                      ty1;
                    dp +=
                      dstAdjust;
                }
            }
        }
        else {
            if (stitchInfo ==
                  null) {
                if (channels.
                      length ==
                      4) {
                    for (i =
                           0;
                         i <
                           h;
                         i++) {
                        for (end =
                               dp +
                                 w;
                             dp <
                               end;
                             dp++) {
                            destPixels[dp] =
                              turbulence_4(
                                point_0,
                                point_1,
                                fSum);
                            point_0 +=
                              tx0;
                            point_1 +=
                              tx1;
                        }
                        point_0 +=
                          ty0;
                        point_1 +=
                          ty1;
                        dp +=
                          dstAdjust;
                    }
                }
                else {
                    for (i =
                           0;
                         i <
                           h;
                         i++) {
                        for (end =
                               dp +
                                 w;
                             dp <
                               end;
                             dp++) {
                            turbulence(
                              rgb,
                              point_0,
                              point_1,
                              fSum,
                              noise);
                            destPixels[dp] =
                              rgb[3] <<
                                24 |
                                rgb[0] <<
                                16 |
                                rgb[1] <<
                                8 |
                                rgb[2];
                            point_0 +=
                              tx0;
                            point_1 +=
                              tx1;
                        }
                        point_0 +=
                          ty0;
                        point_1 +=
                          ty1;
                        dp +=
                          dstAdjust;
                    }
                }
            }
            else {
                org.apache.batik.ext.awt.image.rendered.TurbulencePatternRed.StitchInfo si =
                  new org.apache.batik.ext.awt.image.rendered.TurbulencePatternRed.StitchInfo(
                  );
                for (i =
                       0;
                     i <
                       h;
                     i++) {
                    for (end =
                           dp +
                             w;
                         dp <
                           end;
                         dp++) {
                        si.
                          assign(
                            this.
                              stitchInfo);
                        turbulenceStitch(
                          rgb,
                          point_0,
                          point_1,
                          fSum,
                          noise,
                          si);
                        destPixels[dp] =
                          rgb[3] <<
                            24 |
                            rgb[0] <<
                            16 |
                            rgb[1] <<
                            8 |
                            rgb[2];
                        point_0 +=
                          tx0;
                        point_1 +=
                          tx1;
                    }
                    point_0 +=
                      ty0;
                    point_1 +=
                      ty1;
                    dp +=
                      dstAdjust;
                }
            }
        }
        return dest;
    }
    public TurbulencePatternRed(double baseFrequencyX,
                                double baseFrequencyY,
                                int numOctaves,
                                int seed,
                                boolean isFractalNoise,
                                java.awt.geom.Rectangle2D tile,
                                java.awt.geom.AffineTransform txf,
                                java.awt.Rectangle devRect,
                                java.awt.color.ColorSpace cs,
                                boolean alpha) {
        super(
          );
        this.
          baseFrequencyX =
          baseFrequencyX;
        this.
          baseFrequencyY =
          baseFrequencyY;
        this.
          seed =
          seed;
        this.
          isFractalNoise =
          isFractalNoise;
        this.
          tile =
          tile;
        this.
          txf =
          txf;
        if (this.
              txf ==
              null)
            this.
              txf =
              IDENTITY;
        int nChannels =
          cs.
          getNumComponents(
            );
        if (alpha)
            nChannels++;
        channels =
          (new int[nChannels]);
        for (int i =
               0;
             i <
               channels.
                 length;
             i++)
            channels[i] =
              i;
        txf.
          deltaTransform(
            tx,
            0,
            tx,
            0,
            1);
        txf.
          deltaTransform(
            ty,
            0,
            ty,
            0,
            1);
        double[] vecX =
          { 0.5,
        0 };
        double[] vecY =
          { 0,
        0.5 };
        txf.
          deltaTransform(
            vecX,
            0,
            vecX,
            0,
            1);
        txf.
          deltaTransform(
            vecY,
            0,
            vecY,
            0,
            1);
        double dx =
          java.lang.Math.
          max(
            java.lang.Math.
              abs(
                vecX[0]),
            java.lang.Math.
              abs(
                vecY[0]));
        int maxX =
          -((int)
              java.lang.Math.
              round(
                (java.lang.Math.
                   log(
                     dx) +
                   java.lang.Math.
                   log(
                     baseFrequencyX)) /
                  java.lang.Math.
                  log(
                    2)));
        double dy =
          java.lang.Math.
          max(
            java.lang.Math.
              abs(
                vecX[1]),
            java.lang.Math.
              abs(
                vecY[1]));
        int maxY =
          -((int)
              java.lang.Math.
              round(
                (java.lang.Math.
                   log(
                     dy) +
                   java.lang.Math.
                   log(
                     baseFrequencyY)) /
                  java.lang.Math.
                  log(
                    2)));
        this.
          numOctaves =
          numOctaves >
            maxX
            ? maxX
            : numOctaves;
        this.
          numOctaves =
          this.
            numOctaves >
            maxY
            ? maxY
            : this.
                numOctaves;
        if (this.
              numOctaves <
              1 &&
              numOctaves >
              1)
            this.
              numOctaves =
              1;
        if (this.
              numOctaves >
              8)
            this.
              numOctaves =
              8;
        if (tile !=
              null) {
            double lowFreq =
              java.lang.Math.
              floor(
                tile.
                  getWidth(
                    ) *
                  baseFrequencyX) /
              tile.
              getWidth(
                );
            double highFreq =
              java.lang.Math.
              ceil(
                tile.
                  getWidth(
                    ) *
                  baseFrequencyX) /
              tile.
              getWidth(
                );
            if (baseFrequencyX /
                  lowFreq <
                  highFreq /
                  baseFrequencyX)
                this.
                  baseFrequencyX =
                  lowFreq;
            else
                this.
                  baseFrequencyX =
                  highFreq;
            lowFreq =
              java.lang.Math.
                floor(
                  tile.
                    getHeight(
                      ) *
                    baseFrequencyY) /
                tile.
                getHeight(
                  );
            highFreq =
              java.lang.Math.
                ceil(
                  tile.
                    getHeight(
                      ) *
                    baseFrequencyY) /
                tile.
                getHeight(
                  );
            if (baseFrequencyY /
                  lowFreq <
                  highFreq /
                  baseFrequencyY)
                this.
                  baseFrequencyY =
                  lowFreq;
            else
                this.
                  baseFrequencyY =
                  highFreq;
            stitchInfo =
              new org.apache.batik.ext.awt.image.rendered.TurbulencePatternRed.StitchInfo(
                );
            stitchInfo.
              width =
              (int)
                (tile.
                   getWidth(
                     ) *
                   this.
                     baseFrequencyX);
            stitchInfo.
              height =
              (int)
                (tile.
                   getHeight(
                     ) *
                   this.
                     baseFrequencyY);
            stitchInfo.
              wrapX =
              (int)
                (tile.
                   getX(
                     ) *
                   this.
                     baseFrequencyX +
                   PerlinN +
                   stitchInfo.
                     width);
            stitchInfo.
              wrapY =
              (int)
                (tile.
                   getY(
                     ) *
                   this.
                     baseFrequencyY +
                   PerlinN +
                   stitchInfo.
                     height);
            if (stitchInfo.
                  width ==
                  0)
                stitchInfo.
                  width =
                  1;
            if (stitchInfo.
                  height ==
                  0)
                stitchInfo.
                  height =
                  1;
        }
        initLattice(
          seed);
        java.awt.image.ColorModel cm;
        if (alpha)
            cm =
              new java.awt.image.DirectColorModel(
                cs,
                32,
                16711680,
                65280,
                255,
                -16777216,
                false,
                java.awt.image.DataBuffer.
                  TYPE_INT);
        else
            cm =
              new java.awt.image.DirectColorModel(
                cs,
                24,
                16711680,
                65280,
                255,
                0,
                false,
                java.awt.image.DataBuffer.
                  TYPE_INT);
        int tileSize =
          org.apache.batik.ext.awt.image.rendered.AbstractTiledRed.
          getDefaultTileSize(
            );
        init(
          (org.apache.batik.ext.awt.image.rendered.CachableRed)
            null,
          devRect,
          cm,
          cm.
            createCompatibleSampleModel(
              tileSize,
              tileSize),
          0,
          0,
          null);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Pfl/hCxTabdGAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "KHKC2qOalo01i5bah9wFqYxXqEMhWkmc");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("9WeNDm1zdahssEVjtdHG8Gxqx3Ct2peFEW2n0CqtDfpesd4yiZQrq2uWHLlu" +
       "TTU8TSk1zXqADofwZp3O8IXVAUMvxurpwPXsTpqC4G2CV0s9hJhU1mS/xlZI" +
       "HK8IY39d7gnFaacpW3BpuURCT20GiKBQVm+aOgghSFxYEVTFIahIBe1tBm5A" +
       "z8owkcYkXev0yepCx0gxnrCSIuPqfA0PAi8mkRCXk9Fmss6vZVDNWcWsrawG" +
       "AWbXUZ9j6r16Ug7cxQyZML1qk6PocapgSrJMDCuaShK1oIxxoFOEXMMZqD/g" +
       "Q0auiuE8LXLlNgN3RMlcritVWxvNTL2EUASWqKqyxvjEVSbO0LfmaI9KtW6l" +
       "5TT1Tcgj/BiEDB1LMPi2bGuGvam3A2VgNRtpb0FxYmKDvvI3M9NZpEYwXxO9" +
       "frlb1WaqOLbWvbAVQ/omDZYdoQUVWYPjhwQKyf3OmCHRVbOEqFidBWoosPNx" +
       "kS0t036jPYTRwPX6Yt1QhQoxq8lrQ2JYvrkyyTIjLkm+VRnFEZ6m3oaspKKi" +
       "wGGqxaybVsulQTdE56tlXyS6Sivy6qFi6tbS002mQW9ovM40sCKFcQQUd/tE" +
       "haj308ZKsIimswn1mUWhEl3lSrgymomCRfbNsFlEJ+4YzHGCdkTZyUzoDpoW" +
       "uis7rI5katiiK5MxZ9SqEaG4zqQUbvrpnBrX48V63R6FntZpFOetGVnUOFTR" +
       "Gn2xJVbRsGfC3aY17CxmbkucphVM7JdTMPTRYc0rtmC6izL9hCkBp4TBMM6V" +
       "o6WkGjo2hIhWMp+HCcS2/JrouUUZ2Hto3Mrm/5FfnFNCszIdqejcgDYtSiyO" +
       "gGOouMALTCcVbdNG2qGMj9ojIBs90QdtJvRbAykIB6hf0VAc2dATFMY0qqhu" +
       "EKtGBquKqA+WCoZXy9og5MoCmE+Z7NwZL0sq26x5w7Kjl3r0QEKcjTR1DCPl" +
       "4BGLVVf4wNZ90dV6E0+YNIZ80cBnBoQj3qSIRWgFbYtQKsmsOxi2VuEMsWl1" +
       "tQZgLXFUq5i0RwfFBBtVSAMtr8eTruXUS2uDwPv9gZ4Q6bxDJrrRXHsCWWqN" +
       "Zc4reYKWkgzkdNY0terXbGDi+LDXtyZwN1nQ1UEyNJpkt8ZwzhgnnJRCS+1V" +
       "zegaTW+0IHudxKJHlpv0evRqNJ1ExbmxxtKB0RnAFTLF+bkC5um+3UY6Ajcb" +
       "IfAQA95EVddonWghYxaoqVntb4qSrCLwaOyp3VGjUbMgHVPWHbTOJW1kCtoZ" +
       "quOVtNRFarQU17CCgQmURNYWS0OlMHsBpsdz1Rk1cB1reapuxForVocYFKLY" +
       "vD6YjBclRupSo0klAp0785EBj1M13rbn05rYFsR20LHrOMQRanNMc90Wyulm" +
       "4iUcs+wZvm7QLrwcY4JE1s3WNJzXdbNWKjbabU0JRxMRQuZiynljdUl21721" +
       "mLRWPcnkuNWAwKvT2XozMsq+1rdRlFtzxXFbqa+Y6aJRVWmaLRJYA2fZDT3G" +
       "jHFLMy1BTbqJ4y7DcEatG8N5NVl1kBnhShjTbixoilLSJE5Q0ybb4yaBp4bf" +
       "VYxyXW0uUXc8nZRaU4YSzLXhazK6kenlrDaOqwOmo9uqSK82tTAh4Xjc7KFA" +
       "Lxa8PiZdkmb5RDCidEli0oQbxnMblksB0uAVCaFjQfV9JITmCd2ZVr3pqmyU" +
       "2h5daaVTgVv0sRYIGbCeFFWmk1o5KHaMgT5tJlVFgdgqN28M/BoYXYjqWGF3" +
       "PuDHcqcfVEiACZJ8lFmbuOC2vQrUbdS49mYNGzBexcXUSFf6OHSraLuzUZzu" +
       "Ai23hykqJTE+XQy7cLE+pmzMt3yiWZz3Q1czpU5Jg6GqmWCQrBpcvz5Q8Nqc" +
       "o+ZGsTVxZ0i3GmpxZ+FJy6Im2S1k4rSRvqqGuGjXpNiSwASvmbKJJFmD3qwp" +
       "GiRCkWlVX3YMaQSjmgAlPjOKsSaPTbiI0Lg2C9fTdVxck5pFAtVeiR7k4n29" +
       "RgUrPGbMNZQsxkErCWqYrpKzWsrG3nIcOy3cxpumqzcnOmMq1YVMWK2uD4OQ" +
       "ue1X1k2P0bmG32gkPF3TERJp0COtUUSMvovWxzo6VJqpBs3r3jjVkRVfhCM9" +
       "YDow3Eypqp44nhNztaFqhqgOLz1p0dLUVSkcMqOI4VaV1doN/TXOQmST1fDl" +
       "CAXTPj0a1pRNozVtWDwm9BV6OWEwc4pBw/JsMmdmwWDjMEjF4ZXJuglmH/00" +
       "rJWg+jysepvGcCMwas3BJy117k64iufozXKfLkaTYKkgNXXIbcgiEgIVdrxx" +
       "yRrg7Q08QGsdm2bY1LQ0iyohVbiniWR76k+00SjuC7UZVYca2rCY1AYIMHk+" +
       "HMKNJjvq95P5Qquwm/kYW4MYT+4MQrQ2aDoNPlxWkrI6LnrVIbeuSJuubXSJ" +
       "gDB8shQPJwFsV1EoEsm5GGKSuwwwrCH6jtSohc7CkYt124xAtMbF5Tnlr2dD" +
       "fsLFCocMpulosJZL/emoRcx6guWFdqWXErgTtJhA6fEVuw7JjahDQWXf8eWZ" +
       "JDO8MiiP1rNKB9ZHMxuad1JWVrReq9XKFrPtvfb6Hqfckz8eOnztb2E3skYe" +
       "uI4nJmes4zy+5OnwCVv+y9aL7drZ/h97wpaXvG+3lCIMCvef9ZJf/t7Ch779" +
       "sce14Y+U93frLhpR4bbI819r6yvdPtbU8/Ptf33lg75sWeEf7WD80ckHfUf8" +
       "T1+39+qt/M5eGLTXOudcJ8teD4Rv6FH76oXBR08I3/B0T6qOt3wWyT/dkfzT" +
       "Z58kdc65YZb1TyEpniCJ3wDJu7KDLwHp0zuSn372SYrnnMue9u6xUeE5gCR9" +
       "5VLlI4LcjRJ8AUif2RH8zLNPUD/nXPbsdO8tUeEWQJA5WPN8RE2+AWovzA4+" +
       "ANJnd9Q+++xTW55zLju4Z2+psQeLp4+oOTdA7bnZwZeD9Pkdtc8/+9Tees65" +
       "t2VZevqK5yOGT7t6/hyG2Ur6fKn4F3cMv/jsM/xn55x7V5b906hwO+i8zsHS" +
       "6azgiSWQYPxcescW4fY/Kjz6rK1JZPU0OnXZ49f6EulRT562HnnvPQcrVd77" +
       "9M4574Us+7F8bGe13n31WuRs94kse/LqxcW5Zmwvm9fO9n/2nL77vnPOfX+W" +
       "vT8784tbJOeU/YGdmubK/B03qsyZJfryTpm/fB3KfJUsTyDeO1L51+WwP3wO" +
       "pR/Nsh8CYUyoR7F/isH94I3SzN5Y+IcdzX/4WtL8qXNo/kyW/XhUuDmQXc1z" +
       "TnB88gY45i8jfCMAcnFbd/t/PXbpzddG75fOofdUlv0CME6ma0bkdo1aXvDk" +
       "4qSVZ2pHvH/xBni/LDv4KoDwtTver70O3qev/DtbAnDO8nfOkcDvZtlvAN8a" +
       "PqrGwerY68E509+8UaYPASTlHdPys830wlFR+CjLef3xOZz/JMs+mS050wP/" +
       "BOE/uNFAngJE37Aj/IbrHbZvviauv3qC6387h+tfZtmnwQB2s7iiku398hHb" +
       "P79RtqDe3u412L13PYtsL+alLp5gm2XfktP60jmU/zrLPh8V7thS3r4Ke4L4" +
       "F26AeBbkZy917v3VjvhffW26+Yjzr+a8/v4cztmK5r0vA87R4dvAj+axwjFr" +
       "/X9utLMbAL62rbv/lmeR8015qZuy3Q+eIH7Ifv+2s9nv355lF6PCpSP2V/b3" +
       "/k03yv2NgMZuPfT+x59F7jfnpW4+k/uhyu8//xwBvDDL7o4Kdx8J4DS137/n" +
       "RtX+YaCb7W3d7f/XXO33X34O7wez7CVR4blHvHfTqJPav3//s6ABFz6yo/7D" +
       "X2/tf+05QoCy7NVR4Z6rhHCi9x++URF0AfXd7Y0Ln/r/Mgia58jhkSzLFtJf" +
       "JYdTx0LtBqTx4uwgcAEXX7Ctu/2/RmmcM6k+PlG74hsq228+CIEZZa+NTuQw" +
       "0oOcdPccgWRfQNl/U/bKsuevUTnK3qvax44k0LoeCaRR4XmnfWoi+3jPfVd9" +
       "h2/77Tj1ycfvuvWFj3P/afsa88H33W4jC7fOYts+/rGNY9s3+4E+M3P53Jbn" +
       "d/o5nVFUeNU1fhQDcD7YzIjsD7ctMFHhgfNbiAo35f/Ha/FR4b6zakWFCyA/" +
       "XloEcjqtNCgJ8uMlvxnY65MlwfXz/+PlHgWO7agcCOW2G8eLKKB1UCTbVP0D" +
       "7YGv9QsiLSWMsoECejPd6t59x9U+f7Bw79PpyrFnAQ9e8QZz/inHg7eN4+3H" +
       "HB9Vf+LxAf1tX6r/yPajWqotbzZZK7eShVu23/fKG83eWH75ma0dtHVz/+Gv" +
       "3PmTt73y4OnCnVvAR0PwGLaXnv4Fq67jR/k3pzY//8Kfef1HHv+z/GXL/wdB" +
       "XbUoY1MAAA==");
}
