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
          1471109864000L;
        public static final java.lang.String jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String jlc$ClassType$jl5 =
          ("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" +
           "pLAjUwiPOOXlcMk1HMxv9Puwy2qoZJhzApsQMMsP+ZlSC9ep6iVpUN+sOKIt" +
           "oAjnhtRMYme0zS7bvWbQmc6RqKb6nZipTzCiqQXzOdMcCz1Rglmbhhm41VwZ" +
           "Cw9MDjvBWL0/apGLsC/UbMx3h3Q8wSeWi7mLJZzBjV7ZjeBVA69Um6Eyyipp" +
           "P5VTqhnMyM00iyihF/S0+rCHGExQaknAe11KH0jebDsaj23OAAshXG52OyHS" +
           "7JGCx1lTuodg80otLllBb8GjXpotZqmq6B7blUq+3a00kCxuKB0l7m1iwyYW" +
           "9GQ+mEubOqpYwooQO74XugFKp+tSCxlYcW2+ovrCQm5uO2IjHcy3rBvKJkW0" +
           "Ng27gVYcWmA4jdAtt8WttHIj5ZkMV5h1m6j15k1SkMsaGcsOitQwB2sz3baB" +
           "6Kw57JQ4y8Uxvc7OFLB/qzjOsuoPeiObm1b6EcE0KGduO0JYQXuWIcxUlfZh" +
           "YdhaOUi35HFg3TcyrdLVYosPVHrb7LZwi+Xb+KZcIyd01PSCmMoWArVhNuh2" +
           "pURRZVVdRktjRCdlO2lgnqMGtUnQgscdYVkHsqjFUHV80HW3ZTYXAcxO2yUq" +
           "5JpIhcSFjFupSD1eT0lmQmVyr76edktjSfM1LlATGUPCWT+uNwZNbN2rM4RD" +
           "KQvWlBS27mR1hWX6lU1b6rps1LIxEVug3Fxlk4yccP60NSXYzZyzdFIyezN2" +
           "IKzr86DRaSPThJ2btfnIjpIgqmxWGwJB10GtuR5sJ1a7Y4JdCA0WgYyIxjWx" +
           "IWc8pi51PZ02JyRG16rROJusRjLdKXXooLyJNssNw6lC3SJnOjYvYYtqqM9L" +
           "RCCjcZlttOedKpIoYLf5unwb+u7ntj2+vTgJOLoeBrvivCF5Djvg9Pod7p3o" +
           "6+gopTgOyflO3TSePR6+6/BA0IdedqPL4OLA7GPvevSx5ejjlb2DMxYhhC4e" +
           "3NEfy8nvyV5945NBurgIPz5x/eq7/vlu/vXGW5/DFdnLzyh5VuQn6ce/3nml" +
           "8pt70Pmj89drruhPMz10+tT1Vl8NI9/hT529vuxoWG/Lh6sMHudgWJ2zJ1TH" +
           "/rzGUedOxMOznc4/9gyn87+bFx8GHgAeMnXnuocrsWsuj6Pqd57L+X1R8cHT" +
           "Jl8FzzsOTH7H/43JJy369DO0PZEXnwihy0s3ki2V8tVNpDrKNq/+vWMTP/mc" +
           "rihC6Nbj6+DDs7jX/izXyyD277rmXy+7f2oon3ns8qWXPCb8VXGrevRviluG" +
           "0CUtsqyTZ/4n3i96vqqZxRDcsrsB8IqvL4TQq35KRUPo0uFrYePndxK+GEL3" +
           "PLOEELpQfJ/k+nII3XUjrhA6D8qT1F8JoRddjxpQgvIk5R+H0JWzlKD/4vsk" +
           "3VeBz47p8ugvXk6S/BmQDkjy12941zlh3V3NpOdOY99RCN3xbCF0Ai4fOIVz" +
           "xb+iDjEp2v0v6mHlicf6zNueqn18dymtWFKW5VIuDaGbd/fjR7h23w2lHcq6" +
           "2H3w6ds+e8srDgH4tp3Cx1PvhG4vv/5VMGl7YXF5m33hJX/42t9/7DvFge//" +
           "AFQduy6uJgAA");
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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "j/8fjRQBJbdGAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "jKbmwBsPWz5k1cNoymJdddCIZ+amqFUq");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "7MfzsZ3VeteVa5Gzv09k2ZNXLi7ONWN72bx29v/nzum7Hzzn3A9l2fuyM7+0" +
       "RXJO2Q/s1DRX5u++XmXOLNFXdsr8lWtQ5itkeQLx3pHKvzaH/ZFzKP1Yln0Q" +
       "hDGBEkbeKQb3Q9dLM3tj4R93NP/x60nzp8+h+bNZ9hNh4SZfdGTXPsHxyevg" +
       "mL+M8M0AyIVt3e32WuzSm66O3i+fQ++pLPtFYJwMxwip7Rq1vODJxUlr15CP" +
       "eP/SdfB+aXbwlQDha3a8X3MNvE9f+Xe2BKo5y989RwK/l2W/CXxr8KgU+etj" +
       "rwfnTH/repk+BJCUd0zLzzbTG46KVo+ynNefnMP5T7PsU9mSM8X3ThD+w+sN" +
       "5GlA9PU7wq+/1mH7pqvi+msnuP73c7j+VZZ9BgxgJ4srKtm/Xzli+xfXyxbU" +
       "29u9Brv3zmeR7YW81IUTbLPs23JaXz6H8t9k2RfCwu1byttXYU8Q/+J1EM+C" +
       "/Oylzr2/3hH/669PNx9x/rWc1z+cwzlb0bz3FcA5PHwb+NE8Vjhmrf/P9XY2" +
       "DODL27r7b34WOd+Yl7ox+/uhE8QP2e/fejb7/duy7EJYuHjE/vL+3r/xerm/" +
       "AdDYrYfe/8SzyP2mvNRNZ3I/VPn9558jgBdm2V1h4a4jAZym9vt3X6/aPwx0" +
       "E93W3W6/7mq//7JzeD+YZS8OC8894r2bRp3U/v37nwUNuOGjO+o/8o3W/tec" +
       "IwQoy14VFu6+Qggnev/h6xVBB1Df3d644dP/XwZB6xw5PJJl2UL6K+Rw6lio" +
       "X4c07ssOAhdw4QXbutvtVUrjnEn18YnaZd9Q2X7zYeobYfbaKCsGoeLnpDvn" +
       "CCT7Asr+G7NXll0vxcQwe69qHz+SAHItEkjCwvNO+9RE9vGee6/4Dt/223HS" +
       "k4/fecsLH5/85+1rzAffd7uVKtyiRpZ1/GMbx/Zv8nxFNXL53Jrnd3g5nWFY" +
       "eOVVfhQDcD7YzYjsD7YtcGHhgfNbCAs35tvjtfiwcO9ZtcLCDSA/XloAcjqt" +
       "NCgJ8uMlvxXY65MlwfXz7fFyjwLHdlQOhHLbneNFFqB1UCTblbwD7ale7RdE" +
       "kEUQZgMF9Gay1b17j6t9/mDhnqfTlWPPAh687A3m/FOOB28bR9uPOT4q/eTj" +
       "feY7vtz40e1HtSRL3GyyVm6hCjdvv++VN5q9sfyyM1s7aOum3sNfveOnbn3F" +
       "wdOFO7aAj4bgMWwvOf0LVh3bC/NvTm1+4YU/+7qPPv7n+cuW/w950yoyY1MA" +
       "AA==");
}
