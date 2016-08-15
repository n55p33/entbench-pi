package org.apache.batik.ext.awt.image.rendered;
public class BufferedImageCachableRed extends org.apache.batik.ext.awt.image.rendered.AbstractRed {
    java.awt.image.BufferedImage bi;
    public BufferedImageCachableRed(java.awt.image.BufferedImage bi) { super(
                                                                         (org.apache.batik.ext.awt.image.rendered.CachableRed)
                                                                           null,
                                                                         new java.awt.Rectangle(
                                                                           bi.
                                                                             getMinX(
                                                                               ),
                                                                           bi.
                                                                             getMinY(
                                                                               ),
                                                                           bi.
                                                                             getWidth(
                                                                               ),
                                                                           bi.
                                                                             getHeight(
                                                                               )),
                                                                         bi.
                                                                           getColorModel(
                                                                             ),
                                                                         bi.
                                                                           getSampleModel(
                                                                             ),
                                                                         bi.
                                                                           getMinX(
                                                                             ),
                                                                         bi.
                                                                           getMinY(
                                                                             ),
                                                                         null);
                                                                       this.
                                                                         bi =
                                                                         bi;
    }
    public BufferedImageCachableRed(java.awt.image.BufferedImage bi,
                                    int xloc,
                                    int yloc) {
        super(
          (org.apache.batik.ext.awt.image.rendered.CachableRed)
            null,
          new java.awt.Rectangle(
            xloc,
            yloc,
            bi.
              getWidth(
                ),
            bi.
              getHeight(
                )),
          bi.
            getColorModel(
              ),
          bi.
            getSampleModel(
              ),
          xloc,
          yloc,
          null);
        this.
          bi =
          bi;
    }
    public java.awt.Rectangle getBounds() {
        return new java.awt.Rectangle(
          getMinX(
            ),
          getMinY(
            ),
          getWidth(
            ),
          getHeight(
            ));
    }
    public java.awt.image.BufferedImage getBufferedImage() {
        return bi;
    }
    public java.lang.Object getProperty(java.lang.String name) {
        return bi.
          getProperty(
            name);
    }
    public java.lang.String[] getPropertyNames() {
        return bi.
          getPropertyNames(
            );
    }
    public java.awt.image.Raster getTile(int tileX,
                                         int tileY) {
        return bi.
          getTile(
            tileX,
            tileY);
    }
    public java.awt.image.Raster getData() {
        java.awt.image.Raster r =
          bi.
          getData(
            );
        return r.
          createTranslatedChild(
            getMinX(
              ),
            getMinY(
              ));
    }
    public java.awt.image.Raster getData(java.awt.Rectangle rect) {
        java.awt.Rectangle r =
          (java.awt.Rectangle)
            rect.
            clone(
              );
        if (!r.
              intersects(
                getBounds(
                  )))
            return null;
        r =
          r.
            intersection(
              getBounds(
                ));
        r.
          translate(
            -getMinX(
               ),
            -getMinY(
               ));
        java.awt.image.Raster ret =
          bi.
          getData(
            r);
        return ret.
          createTranslatedChild(
            ret.
              getMinX(
                ) +
              getMinX(
                ),
            ret.
              getMinY(
                ) +
              getMinY(
                ));
    }
    public java.awt.image.WritableRaster copyData(java.awt.image.WritableRaster wr) {
        java.awt.image.WritableRaster wr2 =
          wr.
          createWritableTranslatedChild(
            wr.
              getMinX(
                ) -
              getMinX(
                ),
            wr.
              getMinY(
                ) -
              getMinY(
                ));
        org.apache.batik.ext.awt.image.GraphicsUtil.
          copyData(
            bi.
              getRaster(
                ),
            wr2);
        return wr;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Doj8CrAINZHuXbXtPwVq4zG2GJ7Lbdkvn7zaSqGW0cB9ZdaO4HBIeJGjnfWQ" +
       "NCz/ZXy+YeXnJNEeXVH7xG+sH//1QdEdFGuHA9d/hw5Wy69lnnjbyfWX8W50" +
       "cem86tls4iedz1870flnfmSpVizI1JDYi9xTenBOHH7z3Rfr2+7nFaES8z5P" +
       "fMEL3sL7W9+1LGe1wW6cinlgUVdNGk71/mXx6h3G1wiDvkHRJJVv0gsnbJVq" +
       "w+JSsB+Hhw3Xt8L2dZPNxwyXj5iqaxTPwc6auLpS9Ej+XhwWc0UZHRft6MMe" +
       "p+O8lPGZp8qs/Q6Hx0EsGXkSIpQBf65kn0qC3OLPLTk3QO85VXkNc/0mO8o2" +
       "TT5AS6EGtBB2vSDBB0761TK6eg2HY4xMhVDdqLjGbgncRfRLFvizq6iXT6Wi" +
       "ttjSbpm8okqhllHB8TJr7+DwllDPGolJ+PN1Vwtvn0otbLNF2TZ5LZRCLV4G" +
       "8ec3OdX3y6jiQxxOlFTFyVOgilZc64Bn1JZndPKqKIVaviNoC7j/10yF8Zt8" +
       "Hga4bShcWlehKpz8mJFq/KBrKytU4Srrky/k1M3InFKfG/AKbE7BJ1HxGU++" +
       "f6KhevbEpldECXM+tdXB8SSdVVXvKdPzXmWYNK1whdeJMyfP8aHpjJz2OT+O" +
       "gD6cV5QpVC8oNDHSXp4CZH7+34s1E6QvhcVIBYxeaDirziwGDZAweiFboRgH" +
       "IWF//t8L18ZIjQsHRVa8eEEWAnUAwddFhuNZ53zeL0mroNcx4cQJ1swJv5zn" +
       "dQjuRy2f5UeeI3OnryXiX9Wd1iorvqsPyUcmLl1/9clz7xYfCGRV2rULqdRC" +
       "9yK+Vdjdi/dCLUjNoVW1bulH0x+YtthpzJoEw27EzvMklxjEnoFO2xq4Pbe6" +
       "8pforx44/9Hn9la9CN3aVhKSoFnZWnizkjOycKbfmii8eoPmjl/rdy/94c4L" +
       "T0//8zV+9UsKbqyC8EPysYNXvnTrnAPtYVIbB08E++T4lc+anRqcFMfMQVKv" +
       "WD05YBGoQGfku9ebjvElYUvH9WKrsz4/i5+XGOkovNIs/ChXo+rj1OSHViQD" +
       "PWetO+O0mb7TedYwAgjujKcR/ToOvTm0BrjsUKLXMJwb32lzDZ5uthTvnNC3" +
       "V/BXfFv5P/zcorJxIwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "yOGdzIdp6LKWOs7JE+0T75eCSNXMAuHD");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("u/PtInhfuJxA3/dd3qIDuA9fczAXHtpxeCSBnj2fA4iDxf+TvR4D6O/VK4Eu" +
       "gvIk9eMgoN+NGlCC8iTlu0BGP0sJvl/8P0n3VAJdOaYDaWf3cpLkOuAOSPLX" +
       "7w0OLaj63V45bEtxEolyArS5vnB60XNkL098J3s5sU56/tScpLh+fbgSSXcX" +
       "sG/LX3xtwHz8zcYv7C6/yY643eZcLoPpw+4e3tFq5n335HbI6xL54rcf++WH" +
       "XzhceT22E/jYDU/I9t673zTrukFS3A3b/vpTv/rBf/TaHxZH+v8P4z/CfRcv" +
       "AAA=");
}
