package org.apache.batik.extension.svg;
public class HistogramRed extends org.apache.batik.ext.awt.image.rendered.AbstractRed {
    boolean[] computed;
    int tallied = 0;
    int[] bins = new int[256];
    public HistogramRed(org.apache.batik.ext.awt.image.rendered.CachableRed src) {
        super(
          src,
          null);
        int tiles =
          getNumXTiles(
            ) *
          getNumYTiles(
            );
        computed =
          (new boolean[tiles]);
    }
    public void tallyTile(java.awt.image.Raster r) { final int minX =
                                                       r.
                                                       getMinX(
                                                         );
                                                     final int minY =
                                                       r.
                                                       getMinY(
                                                         );
                                                     final int w =
                                                       r.
                                                       getWidth(
                                                         );
                                                     final int h =
                                                       r.
                                                       getHeight(
                                                         );
                                                     int[] samples =
                                                       null;
                                                     int val;
                                                     for (int y =
                                                            minY;
                                                          y <
                                                            minY +
                                                            h;
                                                          y++) { samples =
                                                                   r.
                                                                     getPixels(
                                                                       minX,
                                                                       y,
                                                                       w,
                                                                       1,
                                                                       samples);
                                                                 for (int x =
                                                                        0;
                                                                      x <
                                                                        3 *
                                                                        w;
                                                                      x++) {
                                                                     val =
                                                                       samples[x++] *
                                                                         5;
                                                                     val +=
                                                                       samples[x++] *
                                                                         9;
                                                                     val +=
                                                                       samples[x++] *
                                                                         2;
                                                                     bins[val >>
                                                                            4]++;
                                                                 }
                                                     }
                                                     tallied++;
    }
    public int[] getHistogram() { if (tallied ==
                                        computed.
                                          length)
                                      return bins;
                                  org.apache.batik.ext.awt.image.rendered.CachableRed src =
                                    (org.apache.batik.ext.awt.image.rendered.CachableRed)
                                      getSources(
                                        ).
                                      get(
                                        0);
                                  int yt0 =
                                    src.
                                    getMinTileY(
                                      );
                                  int xtiles =
                                    src.
                                    getNumXTiles(
                                      );
                                  int xt0 =
                                    src.
                                    getMinTileX(
                                      );
                                  for (int y =
                                         0;
                                       y <
                                         src.
                                         getNumYTiles(
                                           );
                                       y++) {
                                      for (int x =
                                             0;
                                           x <
                                             xtiles;
                                           x++) {
                                          int idx =
                                            x +
                                            xt0 +
                                            y *
                                            xtiles;
                                          if (computed[idx])
                                              continue;
                                          java.awt.image.Raster r =
                                            src.
                                            getTile(
                                              x +
                                                xt0,
                                              y +
                                                yt0);
                                          tallyTile(
                                            r);
                                          computed[idx] =
                                            true;
                                      }
                                  }
                                  return bins;
    }
    public java.awt.image.WritableRaster copyData(java.awt.image.WritableRaster wr) {
        copyToRaster(
          wr);
        return wr;
    }
    public java.awt.image.Raster getTile(int tileX,
                                         int tileY) {
        int yt =
          tileY -
          getMinTileY(
            );
        int xt =
          tileX -
          getMinTileX(
            );
        org.apache.batik.ext.awt.image.rendered.CachableRed src =
          (org.apache.batik.ext.awt.image.rendered.CachableRed)
            getSources(
              ).
            get(
              0);
        java.awt.image.Raster r =
          src.
          getTile(
            tileX,
            tileY);
        int idx =
          xt +
          yt *
          getNumXTiles(
            );
        if (computed[idx])
            return r;
        tallyTile(
          r);
        computed[idx] =
          true;
        return r;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "l4pMFa/4Nu1/h3Try/IhAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "+z7/I4Yeu3sf4O7H+dO9/jSGbpzvFUP3");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("l/+n2/15DF07aRdDl/eZ002+DWgCTYrsXwRHRvtXvnSDK1EcympcXLq5cBam" +
       "j7X3yOtp7xSyP3Pmo2p55/foA2iyv/V7S/38K73RB77V/Ln9hS3VkfO8GOXq" +
       "ALqyvzt2/BH1XXcd7Wisy8xz337olx549miteGhP8Indn6LtyTvfjqLcIC7v" +
       "M+X/7B3/5L3/8JU/KD9E/F9fXLKIjC0AAA==");
}
