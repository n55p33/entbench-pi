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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "KjJVvOLbtP8B2raUePIhAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/7bv8z8S6LG79wHufpw/3etPEujG+V4J");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("dH/5f7rdnyXQtZN2CXR5nznd5DVAE2hSZP88ODLav/SlG0yJk0hWk+LSzYWz" +
       "MH2svUdeT3unkP2ZMx9Vyzu/Rx9A0/2t31vqF18ejj/4ndZP7y9sqY682xWj" +
       "XGWgK/u7Y8cfUd9119GOxrpMPvfaQz//wLNHa8VDe4JP7P4UbU/e+XYU4QZJ" +
       "eZ9p9y/e8c/e+49f/r3yQ8T/BUKnNZSMLQAA");
}
