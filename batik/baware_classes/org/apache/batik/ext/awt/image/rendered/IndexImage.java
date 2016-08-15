package org.apache.batik.ext.awt.image.rendered;
public class IndexImage {
    private static class Counter {
        final int val;
        int count = 1;
        Counter(int val) { super();
                           this.val = val; }
        boolean add(int val) { if (this.val != val) return false;
                               count++;
                               return true; }
        int[] getRgb(int[] rgb) { rgb[org.apache.batik.ext.awt.image.rendered.IndexImage.Cube.
                                        RED] = (val & 16711680) >>
                                                 16;
                                  rgb[org.apache.batik.ext.awt.image.rendered.IndexImage.Cube.
                                        GRN] = (val & 65280) >>
                                                 8;
                                  rgb[org.apache.batik.ext.awt.image.rendered.IndexImage.Cube.
                                        BLU] = val &
                                                 255;
                                  return rgb; }
        public static final java.lang.String jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String jlc$ClassType$jl7 =
          ("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" +
           "sry7n3EnLAE6qyqjIbYfii42H/0H+DTCWkgdAAA=");
        public static final java.lang.String jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String jlc$ClassType$jl5 =
          ("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" +
           "DR9+E2/r+d0HPEqgh8PI2alJlZH60HmuvErePAldOQC7mCs/TwZCZbryuXud" +
           "UVZZ2c9//NXXDOHn0KOTjFAzga6fHB2f8zkCbN5376QiV53Pnmf2vvLx//qs" +
           "9IHVR97E0c47rwh5leU/4V7/jeF36z91BD1wlue74+T4cqeXLmf3Ho3MJI18" +
           "6VKO77mzaa3MUR4ujk6mdXQ1n3Zu1Hsl067kpk9y/VVqrSL48fskrz9ZFh9L" +
           "oAdUw7hbFuhhLQhcU/XPverj3ykHdHGIquKjlzOaZfZweaLt8v+XtsBT3ntv" +
           "T6mORw4HFa/9oxe++qOvvfDHVbb8hhPP1YiI7LucqV/o883Xv/b1333Lc1+s" +
           "Dt8e1NT4YMqrHyPc+a3BpU8IKvEfO5uLx0qVboLA4g9TcbgnkP5XPOhVwzCG" +
           "452tRUEWmxHMB4YpOvrGjETVN93T8+S/jmEqjet3mOosUfgzp8niz90Djc7g" +
           "7wz5rrumbx8O5qu88WfD/Iz/0QlonKRunzpPpPbcwDfLk7bTtsMBsxMcn32b" +
           "Ahrzu0r60YOk1WD3yLNXYt7VOy+G2j+9T9sXyuLny6x4KelBsfuQfzk/3D9z" +
           "H5pfLItPgxmzzWRia+fyV1H8k28minOAAycn9KcTWH/zh/wgRJ+54+uiwxcx" +
           "+hdfu3nj7a/N/v0hwk6/WnmEhW5YqetePCy58Hw9jEzLqZR95HB0Ela3X06g" +
           "7/lLipdAN04fK83+5YHDrybQ8/fnAExV3S/2+rUEeuZevUqEzZKL1P8aeOHd" +
           "qAElKC9SfiWBbl2lBONX94t0/y6BHj2nA5Y/PFwk+W3AHZCUj18N73LGcTjT" +
           "yq9dXszPvObJ7+Q1F9b/Fy7BcfX12ekimx6+P3tZ/9JrNP8j32r+3OHrAN1V" +
           "i6LkcgMg5+FDhbOF+t335HbK6zr14rcf//Ij7z3dUTx+EPh8Qbkg2zvvfiZP" +
           "emFSnaIX/+Lt/+z7f/61P6yOXP4fdG8QzhYoAAA=");
    }
    private static class Cube {
        static final byte[] RGB_BLACK = new byte[] { 0,
        0,
        0 };
        int[] min = { 0, 0, 0 };
        int[] max = { 255, 255, 255 };
        boolean done = false;
        final org.apache.batik.ext.awt.image.rendered.IndexImage.Counter[][]
          colors;
        int count = 0;
        static final int RED = 0;
        static final int GRN = 1;
        static final int BLU = 2;
        Cube(org.apache.batik.ext.awt.image.rendered.IndexImage.Counter[][] colors,
             int count) { super();
                          this.colors = colors;
                          this.count = count;
        }
        public boolean isDone() { return done;
        }
        private boolean contains(int[] val) {
            int vRed =
              val[RED];
            int vGrn =
              val[GRN];
            int vBlu =
              val[BLU];
            return min[RED] <=
              vRed &&
              vRed <=
              max[RED] &&
              (min[GRN] <=
                 vGrn &&
                 vGrn <=
                 max[GRN]) &&
              (min[BLU] <=
                 vBlu &&
                 vBlu <=
                 max[BLU]);
        }
        org.apache.batik.ext.awt.image.rendered.IndexImage.Cube split() {
            int dr =
              max[RED] -
              min[RED] +
              1;
            int dg =
              max[GRN] -
              min[GRN] +
              1;
            int db =
              max[BLU] -
              min[BLU] +
              1;
            int c0;
            int c1;
            int splitChannel;
            if (dr >=
                  dg) {
                if (dr >=
                      db) {
                    splitChannel =
                      RED;
                    c0 =
                      GRN;
                    c1 =
                      BLU;
                }
                else {
                    splitChannel =
                      BLU;
                    c0 =
                      RED;
                    c1 =
                      GRN;
                }
            }
            else
                if (dg >=
                      db) {
                    splitChannel =
                      GRN;
                    c0 =
                      RED;
                    c1 =
                      BLU;
                }
                else {
                    splitChannel =
                      BLU;
                    c0 =
                      GRN;
                    c1 =
                      RED;
                }
            org.apache.batik.ext.awt.image.rendered.IndexImage.Cube ret;
            ret =
              splitChannel(
                splitChannel,
                c0,
                c1);
            if (ret !=
                  null)
                return ret;
            ret =
              splitChannel(
                c0,
                splitChannel,
                c1);
            if (ret !=
                  null)
                return ret;
            ret =
              splitChannel(
                c1,
                splitChannel,
                c0);
            if (ret !=
                  null)
                return ret;
            done =
              true;
            return null;
        }
        private void normalize(int splitChannel,
                               int[] counts) {
            if (count ==
                  0) {
                return;
            }
            int iMin =
              min[splitChannel];
            int iMax =
              max[splitChannel];
            int loBound =
              -1;
            int hiBound =
              -1;
            for (int i =
                   iMin;
                 i <=
                   iMax;
                 i++) {
                if (counts[i] ==
                      0) {
                    continue;
                }
                loBound =
                  i;
                break;
            }
            for (int i =
                   iMax;
                 i >=
                   iMin;
                 i--) {
                if (counts[i] ==
                      0) {
                    continue;
                }
                hiBound =
                  i;
                break;
            }
            boolean flagChangedLo =
              loBound !=
              -1 &&
              iMin !=
              loBound;
            boolean flagChangedHi =
              hiBound !=
              -1 &&
              iMax !=
              hiBound;
            if (flagChangedLo) {
                min[splitChannel] =
                  loBound;
            }
            if (flagChangedHi) {
                max[splitChannel] =
                  hiBound;
            }
        }
        org.apache.batik.ext.awt.image.rendered.IndexImage.Cube splitChannel(int splitChannel,
                                                                             int c0,
                                                                             int c1) {
            if (min[splitChannel] ==
                  max[splitChannel]) {
                return null;
            }
            if (count ==
                  0) {
                return null;
            }
            int half =
              count /
              2;
            int[] counts =
              computeCounts(
                splitChannel,
                c0,
                c1);
            int tcount =
              0;
            int lastAdd =
              -1;
            int splitLo =
              min[splitChannel];
            int splitHi =
              max[splitChannel];
            for (int i =
                   min[splitChannel];
                 i <=
                   max[splitChannel];
                 i++) {
                int c =
                  counts[i];
                if (c ==
                      0) {
                    if (tcount ==
                          0 &&
                          i <
                          max[splitChannel])
                        min[splitChannel] =
                          i +
                            1;
                    continue;
                }
                if (tcount +
                      c <
                      half) {
                    lastAdd =
                      i;
                    tcount +=
                      c;
                    continue;
                }
                if (half -
                      tcount <=
                      tcount +
                      c -
                      half) {
                    if (lastAdd ==
                          -1) {
                        if (c ==
                              count) {
                            max[splitChannel] =
                              i;
                            return null;
                        }
                        else {
                            splitLo =
                              i;
                            splitHi =
                              i +
                                1;
                            tcount +=
                              c;
                            break;
                        }
                    }
                    splitLo =
                      lastAdd;
                    splitHi =
                      i;
                }
                else {
                    if (i ==
                          max[splitChannel]) {
                        if (c ==
                              count) {
                            return null;
                        }
                        else {
                            splitLo =
                              lastAdd;
                            splitHi =
                              i;
                            break;
                        }
                    }
                    tcount +=
                      c;
                    splitLo =
                      i;
                    splitHi =
                      i +
                        1;
                }
                break;
            }
            org.apache.batik.ext.awt.image.rendered.IndexImage.Cube ret =
              new org.apache.batik.ext.awt.image.rendered.IndexImage.Cube(
              colors,
              tcount);
            count =
              count -
                tcount;
            ret.
              min[splitChannel] =
              min[splitChannel];
            ret.
              max[splitChannel] =
              splitLo;
            min[splitChannel] =
              splitHi;
            ret.
              min[c0] =
              min[c0];
            ret.
              max[c0] =
              max[c0];
            ret.
              min[c1] =
              min[c1];
            ret.
              max[c1] =
              max[c1];
            normalize(
              splitChannel,
              counts);
            ret.
              normalize(
                splitChannel,
                counts);
            return ret;
        }
        private int[] computeCounts(int splitChannel,
                                    int c0,
                                    int c1) {
            int splitSh4 =
              (2 -
                 splitChannel) *
              4;
            int c0Sh4 =
              (2 -
                 c0) *
              4;
            int c1Sh4 =
              (2 -
                 c1) *
              4;
            int half =
              count /
              2;
            int[] counts =
              new int[256];
            int tcount =
              0;
            int minR =
              min[0];
            int minG =
              min[1];
            int minB =
              min[2];
            int maxR =
              max[0];
            int maxG =
              max[1];
            int maxB =
              max[2];
            int[] minIdx =
              { minR >>
              4,
            minG >>
              4,
            minB >>
              4 };
            int[] maxIdx =
              { maxR >>
              4,
            maxG >>
              4,
            maxB >>
              4 };
            int[] vals =
              { 0,
            0,
            0 };
            for (int i =
                   minIdx[splitChannel];
                 i <=
                   maxIdx[splitChannel];
                 i++) {
                int idx1 =
                  i <<
                  splitSh4;
                for (int j =
                       minIdx[c0];
                     j <=
                       maxIdx[c0];
                     j++) {
                    int idx2 =
                      idx1 |
                      j <<
                      c0Sh4;
                    for (int k =
                           minIdx[c1];
                         k <=
                           maxIdx[c1];
                         k++) {
                        int idx =
                          idx2 |
                          k <<
                          c1Sh4;
                        org.apache.batik.ext.awt.image.rendered.IndexImage.Counter[] v =
                          colors[idx];
                        for (int iColor =
                               0;
                             iColor <
                               v.
                                 length;
                             iColor++) {
                            org.apache.batik.ext.awt.image.rendered.IndexImage.Counter c =
                              v[iColor];
                            vals =
                              c.
                                getRgb(
                                  vals);
                            if (contains(
                                  vals)) {
                                counts[vals[splitChannel]] +=
                                  c.
                                    count;
                                tcount +=
                                  c.
                                    count;
                            }
                        }
                    }
                }
            }
            return counts;
        }
        public java.lang.String toString() {
            return "Cube: [" +
            min[RED] +
            '-' +
            max[RED] +
            "] [" +
            min[GRN] +
            '-' +
            max[GRN] +
            "] [" +
            min[BLU] +
            '-' +
            max[BLU] +
            "] n:" +
            count;
        }
        public int averageColor() { if (count ==
                                          0) {
                                        return 0;
                                    }
                                    byte[] rgb =
                                      averageColorRGB(
                                        null);
                                    return rgb[RED] <<
                                      16 &
                                      16711680 |
                                      rgb[GRN] <<
                                      8 &
                                      65280 |
                                      rgb[BLU] &
                                      255;
        }
        public byte[] averageColorRGB(byte[] rgb) {
            if (count ==
                  0)
                return RGB_BLACK;
            float red =
              0;
            float grn =
              0;
            float blu =
              0;
            int minR =
              min[0];
            int minG =
              min[1];
            int minB =
              min[2];
            int maxR =
              max[0];
            int maxG =
              max[1];
            int maxB =
              max[2];
            int[] minIdx =
              { minR >>
              4,
            minG >>
              4,
            minB >>
              4 };
            int[] maxIdx =
              { maxR >>
              4,
            maxG >>
              4,
            maxB >>
              4 };
            int[] vals =
              new int[3];
            for (int i =
                   minIdx[0];
                 i <=
                   maxIdx[0];
                 i++) {
                int idx1 =
                  i <<
                  8;
                for (int j =
                       minIdx[1];
                     j <=
                       maxIdx[1];
                     j++) {
                    int idx2 =
                      idx1 |
                      j <<
                      4;
                    for (int k =
                           minIdx[2];
                         k <=
                           maxIdx[2];
                         k++) {
                        int idx =
                          idx2 |
                          k;
                        org.apache.batik.ext.awt.image.rendered.IndexImage.Counter[] v =
                          colors[idx];
                        for (int iColor =
                               0;
                             iColor <
                               v.
                                 length;
                             iColor++) {
                            org.apache.batik.ext.awt.image.rendered.IndexImage.Counter c =
                              v[iColor];
                            vals =
                              c.
                                getRgb(
                                  vals);
                            if (contains(
                                  vals)) {
                                float weight =
                                  c.
                                    count /
                                  (float)
                                    count;
                                red +=
                                  vals[0] *
                                    weight;
                                grn +=
                                  vals[1] *
                                    weight;
                                blu +=
                                  vals[2] *
                                    weight;
                            }
                        }
                    }
                }
            }
            byte[] result =
              rgb ==
              null
              ? (new byte[3])
              : rgb;
            result[RED] =
              (byte)
                (red +
                   0.5F);
            result[GRN] =
              (byte)
                (grn +
                   0.5F);
            result[BLU] =
              (byte)
                (blu +
                   0.5F);
            return result;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "FN9s8IhjZAuJwoYP80d8OvJ/Zva+A14uAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "VHslnCHtrmR64yUiVeHNMiivfKEebYUl");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("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" +
           "AAA=");
    }
    static byte[][] computeRGB(int nCubes,
                               org.apache.batik.ext.awt.image.rendered.IndexImage.Cube[] cubes) {
        byte[] r =
          new byte[nCubes];
        byte[] g =
          new byte[nCubes];
        byte[] b =
          new byte[nCubes];
        byte[] rgb =
          new byte[3];
        for (int i =
               0;
             i <
               nCubes;
             i++) {
            rgb =
              cubes[i].
                averageColorRGB(
                  rgb);
            r[i] =
              rgb[org.apache.batik.ext.awt.image.rendered.IndexImage.Cube.
                    RED];
            g[i] =
              rgb[org.apache.batik.ext.awt.image.rendered.IndexImage.Cube.
                    GRN];
            b[i] =
              rgb[org.apache.batik.ext.awt.image.rendered.IndexImage.Cube.
                    BLU];
        }
        byte[][] result =
          new byte[3][];
        result[org.apache.batik.ext.awt.image.rendered.IndexImage.Cube.
                 RED] =
          r;
        result[org.apache.batik.ext.awt.image.rendered.IndexImage.Cube.
                 GRN] =
          g;
        result[org.apache.batik.ext.awt.image.rendered.IndexImage.Cube.
                 BLU] =
          b;
        return result;
    }
    static void logRGB(byte[] r, byte[] g,
                       byte[] b) { java.lang.StringBuffer buff =
                                     new java.lang.StringBuffer(
                                     100);
                                   int nColors =
                                     r.
                                       length;
                                   for (int i =
                                          0;
                                        i <
                                          nColors;
                                        i++) {
                                       java.lang.String rgbStr =
                                         "(" +
                                       (r[i] +
                                          128) +
                                       ',' +
                                       (g[i] +
                                          128) +
                                       ',' +
                                       (b[i] +
                                          128) +
                                       "),";
                                       buff.
                                         append(
                                           rgbStr);
                                   }
                                   java.lang.System.
                                     out.
                                     println(
                                       "RGB:" +
                                       nColors +
                                       buff);
    }
    static java.util.List[] createColorList(java.awt.image.BufferedImage bi) {
        int w =
          bi.
          getWidth(
            );
        int h =
          bi.
          getHeight(
            );
        java.util.List[] colors =
          new java.util.ArrayList[1 <<
                                    12];
        for (int i_w =
               0;
             i_w <
               w;
             i_w++) {
            for (int i_h =
                   0;
                 i_h <
                   h;
                 i_h++) {
                int rgb =
                  bi.
                  getRGB(
                    i_w,
                    i_h) &
                  16777215;
                int idx =
                  (rgb &
                     15728640) >>>
                  12 |
                  (rgb &
                     61440) >>>
                  8 |
                  (rgb &
                     240) >>>
                  4;
                java.util.List v =
                  colors[idx];
                if (v ==
                      null) {
                    v =
                      new java.util.ArrayList(
                        );
                    v.
                      add(
                        new org.apache.batik.ext.awt.image.rendered.IndexImage.Counter(
                          rgb));
                    colors[idx] =
                      v;
                }
                else {
                    java.util.Iterator i =
                      v.
                      iterator(
                        );
                    while (true) {
                        if (i.
                              hasNext(
                                )) {
                            if (((org.apache.batik.ext.awt.image.rendered.IndexImage.Counter)
                                   i.
                                   next(
                                     )).
                                  add(
                                    rgb))
                                break;
                        }
                        else {
                            v.
                              add(
                                new org.apache.batik.ext.awt.image.rendered.IndexImage.Counter(
                                  rgb));
                            break;
                        }
                    }
                }
            }
        }
        return colors;
    }
    static org.apache.batik.ext.awt.image.rendered.IndexImage.Counter[][] convertColorList(java.util.List[] colors) {
        final org.apache.batik.ext.awt.image.rendered.IndexImage.Counter[] EMPTY_COUNTER =
          new org.apache.batik.ext.awt.image.rendered.IndexImage.Counter[0];
        org.apache.batik.ext.awt.image.rendered.IndexImage.Counter[][] colorTbl =
          new org.apache.batik.ext.awt.image.rendered.IndexImage.Counter[1 <<
                                                                           12][];
        for (int i =
               0;
             i <
               colors.
                 length;
             i++) {
            java.util.List cl =
              colors[i];
            if (cl ==
                  null) {
                colorTbl[i] =
                  EMPTY_COUNTER;
                continue;
            }
            int nSlots =
              cl.
              size(
                );
            colorTbl[i] =
              (org.apache.batik.ext.awt.image.rendered.IndexImage.Counter[])
                cl.
                toArray(
                  new org.apache.batik.ext.awt.image.rendered.IndexImage.Counter[nSlots]);
            colors[i] =
              null;
        }
        return colorTbl;
    }
    public static java.awt.image.BufferedImage getIndexedImage(java.awt.image.BufferedImage bi,
                                                               int nColors) {
        int w =
          bi.
          getWidth(
            );
        int h =
          bi.
          getHeight(
            );
        java.util.List[] colors =
          createColorList(
            bi);
        org.apache.batik.ext.awt.image.rendered.IndexImage.Counter[][] colorTbl =
          convertColorList(
            colors);
        colors =
          null;
        int nCubes =
          1;
        int fCube =
          0;
        org.apache.batik.ext.awt.image.rendered.IndexImage.Cube[] cubes =
          new org.apache.batik.ext.awt.image.rendered.IndexImage.Cube[nColors];
        cubes[0] =
          new org.apache.batik.ext.awt.image.rendered.IndexImage.Cube(
            colorTbl,
            w *
              h);
        while (nCubes <
                 nColors) {
            while (cubes[fCube].
                     isDone(
                       )) {
                fCube++;
                if (fCube ==
                      nCubes)
                    break;
            }
            if (fCube ==
                  nCubes) {
                break;
            }
            org.apache.batik.ext.awt.image.rendered.IndexImage.Cube c =
              cubes[fCube];
            org.apache.batik.ext.awt.image.rendered.IndexImage.Cube nc =
              c.
              split(
                );
            if (nc !=
                  null) {
                if (nc.
                      count >
                      c.
                        count) {
                    org.apache.batik.ext.awt.image.rendered.IndexImage.Cube tmp =
                      c;
                    c =
                      nc;
                    nc =
                      tmp;
                }
                int j =
                  fCube;
                int cnt =
                  c.
                    count;
                for (int i =
                       fCube +
                       1;
                     i <
                       nCubes;
                     i++) {
                    if (cubes[i].
                          count <
                          cnt)
                        break;
                    cubes[j++] =
                      cubes[i];
                }
                cubes[j++] =
                  c;
                cnt =
                  nc.
                    count;
                while (j <
                         nCubes) {
                    if (cubes[j].
                          count <
                          cnt)
                        break;
                    j++;
                }
                for (int i =
                       nCubes;
                     i >
                       j;
                     i--)
                    cubes[i] =
                      cubes[i -
                              1];
                cubes[j++] =
                  nc;
                nCubes++;
            }
        }
        byte[][] rgbTbl =
          computeRGB(
            nCubes,
            cubes);
        java.awt.image.IndexColorModel icm =
          new java.awt.image.IndexColorModel(
          8,
          nCubes,
          rgbTbl[0],
          rgbTbl[1],
          rgbTbl[2]);
        java.awt.image.BufferedImage indexed =
          new java.awt.image.BufferedImage(
          w,
          h,
          java.awt.image.BufferedImage.
            TYPE_BYTE_INDEXED,
          icm);
        java.awt.Graphics2D g2d =
          indexed.
          createGraphics(
            );
        g2d.
          setRenderingHint(
            java.awt.RenderingHints.
              KEY_DITHERING,
            java.awt.RenderingHints.
              VALUE_DITHER_ENABLE);
        g2d.
          drawImage(
            bi,
            0,
            0,
            null);
        g2d.
          dispose(
            );
        int bits;
        for (bits =
               1;
             bits <=
               8;
             bits++) {
            if (1 <<
                  bits >=
                  nCubes)
                break;
        }
        if (bits >
              4) {
            return indexed;
        }
        if (bits ==
              3)
            bits =
              4;
        java.awt.image.ColorModel cm =
          new java.awt.image.IndexColorModel(
          bits,
          nCubes,
          rgbTbl[0],
          rgbTbl[1],
          rgbTbl[2]);
        java.awt.image.SampleModel sm;
        sm =
          new java.awt.image.MultiPixelPackedSampleModel(
            java.awt.image.DataBuffer.
              TYPE_BYTE,
            w,
            h,
            bits);
        java.awt.image.WritableRaster ras =
          java.awt.image.Raster.
          createWritableRaster(
            sm,
            new java.awt.Point(
              0,
              0));
        bi =
          indexed;
        indexed =
          new java.awt.image.BufferedImage(
            cm,
            ras,
            bi.
              isAlphaPremultiplied(
                ),
            null);
        org.apache.batik.ext.awt.image.GraphicsUtil.
          copyData(
            bi,
            indexed);
        return indexed;
    }
    public IndexImage() { super(); }
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
       "xCQx0GCDDdtSZqueg+ErBG3mWANut+et3DPSbsdOhmuXASDiIzMjhXIZW29D" +
       "wVzYaQ6wW9cVe7MxFgt9a+vKvDaKZFFuoeKGNnVdoDZrL2d39LiDyaIF3hzG" +
       "ZDazlt446Zk1YzsTSZi110q/7uNum1VrCrukxlN7ihrinI/HOxnOdak2mNl8" +
       "LVFpvB11sknu8RA+wJxUqmOdudY2IT0GSzjWI2YwY3BG1tgqLiRiPEPVyN04" +
       "ZXiKCGAxtRhEHzH8xlpy5hqoBjEtFWkDkG9jKLnV1rVxe9ZbLdqtCGJpKINp" +
       "x1gawRaNGzFapTBoDvdyEIXDFJY8pLHY9Qx4s406utrmMcJoQL1lb7JDwklt" +
       "ts6VvIGNWqpNmXWXl7vLegdHvVoT7cVIOhn54A11x5thXq37eZoKDtX1Yojh" +
       "pEYXEetrjMW2ojmPeA28BO+GWxGrSfKmWxOpxtYPG2ZDVbuK7/A11FvN8+qq" +
       "NwhrIWruFhiSuy4prFRivLDQ3QKshHNmQaswuub6IyejnD49G6FmlekMVLQ7" +
       "sXvTrQJBMW9Lbk+KegLuVhduxKw3Yx7fzquLOFjjw5BwaByCYUUYLyftxTQY" +
       "pIxAOjUOUnFVMPpZTvWEUMvH9dlyZeckhS4Edjdr83WGNjK0M9hgXRGBA4ze" +
       "2eIkjbUJBbDRo41mbE481GL1pmqFY7I5WYyUvkA7dRUTJCfl7IHTSMkQ2orL" +
       "FAqpmq+G/SkFr/XRwnHqWH3YZShjg2WTzUTI5hG7mSQtNU23waKGpbVsLu0W" +
       "vmCHJDeX2krszpmk68pIrG3pdt+UJuPNou3P0Wmj1g7obl6D8z4aCrPMp5qc" +
       "YaNanBop2p+LqZLV+LDXMiXPAmlpo94KNqKgq9N4CF7kEcnudJddWuzNoX4r" +
       "kFkyE2AbI5N6kuyCIKZbrXjZ5Jw2Vs/buRg4csjOIkar25ha03jc0NGaNawO" +
       "UXLikQKTZXotT/Khwq6iYb3fxNms1U1NlNTF8RziU9Kv6p15JlbR0QLrSu0J" +
       "LABjue0RInA4jr/zncX2yg+9uh2u+8vNvOPT17XTKhr6r2JnZ9/0RFG89fgA" +
       "o/zcfsEBxqlN3kqxW/XozQ5Vy52qj73nuee1yceRg8PN8XlSuSvxg3/o6Bvd" +
       "OcWquEDw9pvvyjHlmfLJpu3vvefPH57+4Ordr+JY6s3n5DzP8l8xL/x+//vU" +
       "nz2o3HK8hXvdaffZTk+f3bi9O9KTNPKmZ7ZvHz227BsKiz1WqRwcWvbgJkdD" +
       "N/SCS6UD7Of+3NnDQUlwUP7nT825mFRusbwEGPatNzdseeix3718/lef/PyP" +
       "Pf/kn5bnBndasShHeGTe4Nj8VJ9vvvCVr3/x3kc/UZ6z3arI8V7z8/cNrr9O" +
       "cOaWQKnWPceGekdhl+pFhjrasG69+jPTq0Sq6EEQ7N0xuuAc59micJPK3cWB" +
       "eZrofL9T0m2OBX2goH0QTA6zF3T/m1Ts7+qhs+oDZ4QDz4TZcb/UgdSLuujo" +
       "jPt7OVx+zgSPFBo/DlT/7UMT/PbeBOprlEmJLA0I0wEeJaiRFSSWZ3a9jRX5" +
       "ngt4HKn+vRgmv1Fk3apsE/3YbS4dnq8fb5X/VH6pUvrq+28czgfHoH6M57c7" +
       "umfu706U1D8Z5DcMceD2rz85NSEc39OL88+jtv1dAMu/dnx9CDTmN5R0vZe0" +
       "HKwonrwgGH7+grZfKIoPJZXb1EKYvewXkH8krxTxd7JGea90+nCaw17yY/97" +
       "XVHZBLYRDrFC+O6A6i0na+9PnhQl6ccv0O3XiuKXi8n0zSO8OO85G9/STpT/" +
       "ldegfIk/TwCltUPlte+O8qedBLjUI6VLnaBqJzWKOxNaCQ4lg9+8wCSfLooX" +
       "k8plNdLlpDin96PilP0ckJQTefkiXc6cjJ1dyHg5K9OOZ9R/y331Cx/dvfjC" +
       "/uCrWJCSCnSza4HX30wsrpdcsFqeujD2rf73v/Rn/0P84aPE5nVF8Znjlem+" +
       "04fz+4sML90cLj5zBBe/+3eEi6L4wDFU/Nb1UFH8/WBR/OwFsf+ZktlvvVLs" +
       "/6cL2j5XFJ8til/cS3IB7efzU0H/ydfg");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("9+Ulm7cBLX/p0Fd+6bvq96UiJcEfXaDNHxfFF5PyysBGj5KbOfZ9RY83gm+0" +
       "F3b/e8axyw5F8aVj//n+7ySz8dMizbq5m33pyM3+9Dtysy9/h272pZLZl1/J" +
       "zb52QdufF8X/OnazL1/kZn9xfn35z6/B1R4vKkH7wacPXe3Tr8LVTux5YeZe" +
       "/P1UaeWS6lsX6PZXRfFNAKamnpQzf4jCJYsTjV9+NRrnIMU98aLiUtRD191m" +
       "3t/AVT/x/OU73/T87I/26f7RLdm76MqdRuo4p++wnHq+PYh0wyrFv2t/oyUo" +
       "f/4mqbzt7+jlSeXOo8dS/L8uORRXYh67mANISsrf071uTSoP3awXeGUC5Wnq" +
       "O0BKdSNqQAnK05R3Ayw4TwnGL39P090L7H1CB3KF/cNpkiuAOyApHu8PjiDh" +
       "1F2Z/VWjfB9jD5323HL6H3il6T/1+v7kmdWuvO1+9IKcsoeL6ovPD8c/+nLz" +
       "4/tbiaoj73YFlzvBa9z+gmTJtHjJfuKm3I543U499e37PnnXW4/Wzfv2Ap9E" +
       "0SnZ3nzja39dN0jKi3q7T7/pN3/g157/k/Ky0P8HLm85Y4YwAAA=");
}
