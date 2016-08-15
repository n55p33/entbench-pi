package org.apache.batik.ext.awt.image.rendered;
public class DisplacementMapRed extends org.apache.batik.ext.awt.image.rendered.AbstractRed {
    private static final boolean TIME = false;
    private static final boolean USE_NN = false;
    private float scaleX;
    private float scaleY;
    private org.apache.batik.ext.awt.image.ARGBChannel xChannel;
    private org.apache.batik.ext.awt.image.ARGBChannel yChannel;
    org.apache.batik.ext.awt.image.rendered.CachableRed image;
    org.apache.batik.ext.awt.image.rendered.CachableRed offsets;
    int maxOffX;
    int maxOffY;
    java.awt.RenderingHints hints;
    org.apache.batik.ext.awt.image.rendered.DisplacementMapRed.TileOffsets[]
      xOffsets;
    org.apache.batik.ext.awt.image.rendered.DisplacementMapRed.TileOffsets[]
      yOffsets;
    static class TileOffsets {
        int[] tile;
        int[] off;
        TileOffsets(int len, int base, int stride, int loc, int endLoc, int slop,
                    int tile,
                    int endTile) { super();
                                   this.tile = (new int[len + 1]);
                                   this.off = (new int[len + 1]);
                                   if (tile == endTile) endLoc -=
                                                          slop;
                                   for (int i = 0; i < len; i++) {
                                       this.
                                         tile[i] =
                                         tile;
                                       this.
                                         off[i] =
                                         base +
                                           loc *
                                           stride;
                                       loc++;
                                       if (loc ==
                                             endLoc) {
                                           loc =
                                             0;
                                           tile++;
                                           if (tile ==
                                                 endTile)
                                               endLoc -=
                                                 slop;
                                       }
                                   }
                                   this.tile[len] = this.tile[len -
                                                                1];
                                   this.off[len] = this.off[len -
                                                              1];
        }
        public static final java.lang.String jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 = 1471109864000L;
        public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1YC2wU1xV9u/6w/n/4OYAN2IaIT3dKfiQ1IQFjg8kaHEyQ" +
                                                                  "Yj7L7Ozb3cGzM8PMW3vthHyQWmilIkoJIVGwKoUEgvhEUaK2apM6ikoSJY0U" +
                                                                  "QpumUaA/tbQUFVQ1rUrb9L73ZnY+u2uaqu1K+3b2zX333fvuvefe+05eQWWm" +
                                                                  "gVqwSsJkRMdmuEslfaJh4ninIprmRpiLSk+WiH/admndXUFUPoBqU6LZK4km" +
                                                                  "7paxEjcHULOsmkRUJWyuwzhOV/QZ2MTGkEhkTR1AU2WzJ60rsiSTXi2OKcEm" +
                                                                  "0YigBpEQQ45lCO6xGBDUHAFJBCaJsML/uiOCqiVNH3HIm1zkna43lDLt7GUS" +
                                                                  "VB/ZIQ6JQobIihCRTdKRNdAiXVNGkopGwjhLwjuU260jWBu5Pe8IWl+s+/T6" +
                                                                  "/lQ9O4LJoqpqhKlnbsCmpgzheATVObNdCk6bO9EjqCSCqlzEBLVH7E0F2FSA" +
                                                                  "TW1tHSqQvgarmXSnxtQhNqdyXaICETTXy0QXDTFtseljMgOHELF0Z4tB2zk5" +
                                                                  "bbmWeSo+sUg4+OS2+pdKUN0AqpPVfiqOBEIQ2GQADhSnY9gwV8TjOD6AGlQw" +
                                                                  "dj82ZFGRRy1LN5pyUhVJBsxvHwudzOjYYHs6ZwV2BN2MjEQ0I6degjmU9a8s" +
                                                                  "oYhJ0HWaoyvXsJvOg4KVMghmJETwO2tJ6aCsxgma7V+R07H9PiCApZPSmKS0" +
                                                                  "3FalqggTqJG7iCKqSaEfXE9NAmmZBg5oEDSjKFN61rooDYpJHKUe6aPr46+A" +
                                                                  "qoIdBF1C0FQ/GeMEVprhs5LLPlfWLdv3kLpGDaIAyBzHkkLlr4JFLb5FG3AC" +
                                                                  "GxjigC+sXhg5JE57dW8QISCe6iPmNN9++Nq9i1vG3+I0MwvQrI/twBKJSkdj" +
                                                                  "te/P6lxwVwkVI6RrpkyN79GcRVmf9aYjqwPCTMtxpC/D9svxDWcffOwEvhxE" +
                                                                  "lT2oXNKUTBr8qEHS0rqsYGM1VrEhEhzvQRVYjXey9z1oEjxHZBXz2fWJhIlJ" +
                                                                  "DypV2FS5xv7DESWABT2iSniW1YRmP+siSbHnrI4QqoIvqofvFsQ/7JegtJDS" +
                                                                  "0lgQJVGVVU3oMzSqvykA4sTgbFNCDLx+UDC1jAEuKGhGUhDBD1LYekEjUxwm" +
                                                                  "gpwG8wtgjjjYJC6skk1dAadNA59eUd+A42Hqdvr/e8MsPYHJw4EAGGeWHxoo" +
                                                                  "/RpNAQZR6WBmZde109F3uNvRULHOjqBukCHMZQgzGRiQggxhJkPYliGcL0P7" +
                                                                  "RjAOt5yJAgEmxhQqF/cPsO4g4AQAdfWC/q1rt+9tLQHH1IdLwTSUtNWTsDod" +
                                                                  "MLEzQFQ601gzOvfCkjeCqDSCGkWJZESF5p8VRhKQTRq0gr86BqnMyShzXBmF" +
                                                                  "pkJDk3AcAK1YZrG4hLQhbNB5gqa4ONj5jka2UDzbFJQfjR8efnzTo18MoqA3" +
                                                                  "idAtywD/6PI+Cv05iG/3g0chvnV7Ln165tAuzYERT1ayk2neSqpDq99R/McT" +
                                                                  "lRbOEV+JvrqrnR17BcA8ESEsAUFb/Ht4UKrDRnyqSwgUTmhGWlToK/uMK0nK" +
                                                                  "0IadGebBDex5CrhFiIbtZPhGrThmv/TtNJ2O07nHUz/zacEyyt39+pGfvve7" +
                                                                  "W9lx28mnzlU19GPS4QI8yqyRQVuD47YbDYyB7pPDfd984sqezcxngaKt0Ibt" +
                                                                  "dOwEoAMTwjF/+a2dH128cPR8MOfnKOvVLTSBbrDJfEcMwEkFoIM6S/sDKril" +
                                                                  "nJDFmIJpPP29bt6SV/6wr56bX4EZ23sW35iBM3/TSvTYO9v+0sLYBCSap52j" +
                                                                  "csg4+E92OK8wDHGEypF9/FzzU2+KRyCNAHSb8ihmaBxiqoe8IU7DqD8TMyEc" +
                                                                  "5TSc/pCV2G7p2y7tbe/7NU9aNxVYwOmmHhe+vunDHe8y24ZowNN5qneNK5wB" +
                                                                  "GFyOVc8P/zP4BOD7T/qlh04neIJo7LSy1JxcmtL1LEi+YIK60quAsKvx4uAz" +
                                                                  "l05xBfxp3EeM9x782mfhfQe55Xit05ZXbrjX8HqHq0OHO6l0cyfaha3o/u2Z" +
                                                                  "Xd87vmsPl6rRm7m7oDA99ZN/vBs+/PO3C6SEEtmqV2+lSJ3D6yle23CFVn21" +
                                                                  "7vv7G0u6ASp6UCijyjszuCfu5gilmpmJuYzl1FBswq0aNQxBgYVgAzqxdOKB" +
                                                                  "0dzGJBVy8iIr7uj/1XSYZ7pB1WtNV8Eelfafv1qz6epr19iJeCt+N4ZA7uPm" +
                                                                  "aKDDfGqO6f6kt0Y0U0B32/i6LfXK+HXgOAAcJUj55noD0mnWgzgWddmkn73+" +
                                                                  "xrTt75egYDeqVDQx3i0y8EYVgJrYTEEyz+r33MvRYzhklTwoi/KUz5ugETy7" +
                                                                  "MDZ0pXXConn0O9NfXnZs7AJDL53zmMnWB2l94cnWrG90EsaJD5b++Ng3Dg1z" +
                                                                  "b5sgdnzrmv62Xont/uVf846c5ccC4eRbPyCcfGZG5/LLbL2TqOjq9mx+TQTJ" +
                                                                  "3ll7y4n0n4Ot5T8MokkDqF6y+rRNopKh8D8AvYlpN2/Qy3nee/sMXlR35BLx" +
                                                                  "LH88u7b1p0h3mJQST0j4siJ92Gpljq3+rBhA7OFBtuRmOizKzzvFVhPYGSDQ" +
                                                                  "e4WQQ18G9jzWt1Sd/YH57G9e4lYuhO2+puX4sZD0cfosw3a61R05oWqpDA3w" +
                                                                  "tbyZ/xK0+b9UPyexloa2jaSgkEuSlF2e/y/ZUyCYV9zzXec49nzbe4+Otf2C" +
                                                                  "wUJINsE/IG8VaBxda66evHj5XE3zaVaSldL0Z6Gpt+POb6g9fTKzQh0deO+w" +
                                                                  "NA/m6f9+TmA5VYo7FRsX0uELHBMIKtczMUWGuqEsIauiwjjeCdMKOxT67246" +
                                                                  "JHQHj4IWntD/TcQqKmgUQZOsqZjWJ/Y73knIWjh3QQEvswXyUrMHmXqZuk6Y" +
                                                                  "f1J74FffbU+u/DwtBJ1ruUGTQP/PBpstLG5yvyhv7v79jI3LU9s/Rzcw2+cR" +
                                                                  "fpYv9J58e/V86UCQ3YFw/Mm7O/Eu6vCiTqWBScZQvem4zXGRRGHzB+jjIDf5" +
                                                                  "BBn44QnePUKHLHiPRE3PPWUC8sfzkxqduF935b+AI9sqq1Wg4xo6DHDfua9o" +
                                                                  "Au3Pb0O2Wei0rQjgfmVCwC22GiosLZGgj9t9Mu6ZQMZsEUNAwJnsls9pNdjx" +
                                                                  "VCLfdYi71XByO6K41VzsxorVkkd3HxyLr39uiQ3j98CW1kWimw9BVa4LATuM" +
                                                                  "v/Sf3y+AYE15F578kk46PVYXmj72wIccD+2LtGoI0ERGUdxZ1fVcrhs4ITMd" +
                                                                  "qnmO5XXm0wTd/G+KSVDIfmQaPsU5HIHeeGIO4Ofs173qWwQ1FVsFTgKjm/pZ" +
                                                                  "wMRC1EAJo5vyeYLq/ZSwP/t1071AUKVDB1blD26Sk9RZjSR9PKXbNq13YJsX" +
                                                                  "P9mA16NyDj31RkHncsI2D5KyC3Eb9TL8SjwqnRlbu+6ha3c8xzt8SRFHRymX" +
                                                                  "Kshz/LIhh5xzi3KzeZWvWXC99sWKebZbN3CBnZCc6UKf+yHSdFpFz/D1wWZ7" +
                                                                  "rh3+6Oiy1360t/wc5PXNKCBCetucXyZm9QzE2+ZIfjMFWYY16B0Lnh5Zvjjx" +
                                                                  "x49ZIW4luVnF6aPS+WNbPzjQdBQa+aoecDNwzyyrX1eNqBuwNGQMoBrZ7MqC" +
                                                                  "iMAFcqmnU6ulwSPSq3J2LtZx1uRm6f0QQa35TWr+rRo0LcPYWKll1LhVnVQ5" +
                                                                  "M56bejv5ZHTdt8CZcZUsnSzPZHmNWBKN9Oq63cNXvKwzTFtVPAmMs0c6vP4v" +
                                                                  "nNJkhSwbAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "BJOlVmaZckUZV/mWQKm43re6XaJQ6HqEjq4bWKGFdOI177fgMK61WWGlGKEK" +
           "93EzicV4Jbbwge+uNt0K0ZAHorUgpKnhxX1q2AkTl4JpIlgn9FheLHoxs14m" +
           "jDksOpNuezSs+VWPaQqI7wXTRgcVfWbJLNM1PxCnxkTdECnqMEbSnNUmaXEx" +
           "Zpctk6U3rgh8pJysKzQjjMnasKgLtj5GpwOrXwCeP2/afqvEg3lZe85iXQ94" +
           "uMKqWsjSAmJqPCs2RHGEOZ1U8NabFVkKhtq83qVoLimMaAo1SCZqN5aN0ZKu" +
           "0Sg3VVeMMUpiS3PjRjUONcMwpiyFB6sVqpCS0iXLhDpSCmSp2PSUtQ+r1U7Q" +
           "nzbZuMSQjYY6biaOAw/cLsnPBvi4Zs0UFUWIOhZ114MR1+wZXi1aUc3OjNfS" +
           "xkDnNS1Zsqv+1NQbMof0KwOD7IXlDUtqjJUsea8Oy/2gV9JKJE8qizEFe6gf" +
           "FoiQ45tNtKVw8VAYhd3xMKAdpcMxKV/ncQTV0t56Qa0MlfJogWqsxuyMEepl" +
           "tyoOlm1+OPAQza/iNc/ubIRlOqlZdXfF0iuMlMk2Op35jdKS45fzbq2seVKp" +
           "1zXKxkoqjuh0Xmf5hTGoqgs7HTpoteN4JKYrZLiJaRjvtwrUGinrDRjTEHm5" +
           "tsUKZ6N4OSSjdMoMhqi0WRVtVfBc2iOIAdyRh+Zg3mPEArv2Pd8eoJWaTFYZ" +
           "gQnIUX0ON8PSqO3TA3vjCbE2GlrLxtgcOm046rQRu420JKWhzmu0mpQpf1nX" +
           "W/Nw1l82/OHSWsPDsMsWe0jFbo5SOJVkZrMJMaLgNhbrtVoZE2ZSrFp2ao5Q" +
           "otEXSnyruvE2A16M6FJlOqenm1rF7dMLhaiWAk9N5cTWpHaIgDEU4NcO2RnG" +
           "Rh0uSEWliRarcn9Q7fQWdru3FrmhUJv7NLtg5E7MrOpOq4MLcEC3fd20Wbpu" +
           "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" +
           "XvlGvrP2f5LwerD1JQAA");
    }
    public DisplacementMapRed(org.apache.batik.ext.awt.image.rendered.CachableRed image,
                              org.apache.batik.ext.awt.image.rendered.CachableRed offsets,
                              org.apache.batik.ext.awt.image.ARGBChannel xChannel,
                              org.apache.batik.ext.awt.image.ARGBChannel yChannel,
                              float scaleX,
                              float scaleY,
                              java.awt.RenderingHints rh) {
        super(
          );
        if (xChannel ==
              null) {
            throw new java.lang.IllegalArgumentException(
              "Must provide xChannel");
        }
        if (yChannel ==
              null) {
            throw new java.lang.IllegalArgumentException(
              "Must provide yChannel");
        }
        this.
          offsets =
          offsets;
        this.
          scaleX =
          scaleX;
        this.
          scaleY =
          scaleY;
        this.
          xChannel =
          xChannel;
        this.
          yChannel =
          yChannel;
        this.
          hints =
          rh;
        maxOffX =
          (int)
            java.lang.Math.
            ceil(
              scaleX /
                2);
        maxOffY =
          (int)
            java.lang.Math.
            ceil(
              scaleY /
                2);
        java.awt.Rectangle rect =
          image.
          getBounds(
            );
        java.awt.Rectangle r =
          image.
          getBounds(
            );
        r.
          x -=
          maxOffX;
        r.
          width +=
          2 *
            maxOffX;
        r.
          y -=
          maxOffY;
        r.
          height +=
          2 *
            maxOffY;
        image =
          new org.apache.batik.ext.awt.image.rendered.PadRed(
            image,
            r,
            org.apache.batik.ext.awt.image.PadMode.
              ZERO_PAD,
            null);
        image =
          new org.apache.batik.ext.awt.image.rendered.TileCacheRed(
            image);
        this.
          image =
          image;
        java.awt.image.ColorModel cm =
          image.
          getColorModel(
            );
        if (!USE_NN)
            cm =
              org.apache.batik.ext.awt.image.GraphicsUtil.
                coerceColorModel(
                  cm,
                  true);
        init(
          image,
          rect,
          cm,
          image.
            getSampleModel(
              ),
          rect.
            x,
          rect.
            y,
          null);
        xOffsets =
          (new org.apache.batik.ext.awt.image.rendered.DisplacementMapRed.TileOffsets[getNumXTiles(
                                                                                        )]);
        yOffsets =
          (new org.apache.batik.ext.awt.image.rendered.DisplacementMapRed.TileOffsets[getNumYTiles(
                                                                                        )]);
    }
    public java.awt.image.WritableRaster copyData(java.awt.image.WritableRaster wr) {
        copyToRaster(
          wr);
        return wr;
    }
    public java.awt.image.Raster getTile(int tileX,
                                         int tileY) {
        java.awt.image.WritableRaster dest =
          makeTile(
            tileX,
            tileY);
        java.awt.Rectangle srcR =
          dest.
          getBounds(
            );
        java.awt.image.Raster mapRas =
          offsets.
          getData(
            srcR);
        java.awt.image.ColorModel mapCM =
          offsets.
          getColorModel(
            );
        org.apache.batik.ext.awt.image.GraphicsUtil.
          coerceData(
            (java.awt.image.WritableRaster)
              mapRas,
            mapCM,
            false);
        org.apache.batik.ext.awt.image.rendered.DisplacementMapRed.TileOffsets xinfo =
          getXOffsets(
            tileX);
        org.apache.batik.ext.awt.image.rendered.DisplacementMapRed.TileOffsets yinfo =
          getYOffsets(
            tileY);
        if (USE_NN)
            filterNN(
              mapRas,
              dest,
              xinfo.
                tile,
              xinfo.
                off,
              yinfo.
                tile,
              yinfo.
                off);
        else
            if (image.
                  getColorModel(
                    ).
                  isAlphaPremultiplied(
                    ))
                filterBL(
                  mapRas,
                  dest,
                  xinfo.
                    tile,
                  xinfo.
                    off,
                  yinfo.
                    tile,
                  yinfo.
                    off);
            else
                filterBLPre(
                  mapRas,
                  dest,
                  xinfo.
                    tile,
                  xinfo.
                    off,
                  yinfo.
                    tile,
                  yinfo.
                    off);
        return dest;
    }
    public org.apache.batik.ext.awt.image.rendered.DisplacementMapRed.TileOffsets getXOffsets(int xTile) {
        org.apache.batik.ext.awt.image.rendered.DisplacementMapRed.TileOffsets ret =
          xOffsets[xTile -
                     getMinTileX(
                       )];
        if (ret !=
              null)
            return ret;
        java.awt.image.SinglePixelPackedSampleModel sppsm;
        sppsm =
          (java.awt.image.SinglePixelPackedSampleModel)
            getSampleModel(
              );
        int base =
          sppsm.
          getOffset(
            0,
            0);
        int tw =
          sppsm.
          getWidth(
            );
        int width =
          tw +
          2 *
          maxOffX;
        int x0 =
          getTileGridXOffset(
            ) +
          xTile *
          tw -
          maxOffX -
          image.
          getTileGridXOffset(
            );
        int x1 =
          x0 +
          width -
          1;
        int tile =
          (int)
            java.lang.Math.
            floor(
              x0 /
                (double)
                  tw);
        int endTile =
          (int)
            java.lang.Math.
            floor(
              x1 /
                (double)
                  tw);
        int loc =
          x0 -
          tile *
          tw;
        int endLoc =
          tw;
        int slop =
          (endTile +
             1) *
          tw -
          1 -
          x1;
        ret =
          new org.apache.batik.ext.awt.image.rendered.DisplacementMapRed.TileOffsets(
            width,
            base,
            1,
            loc,
            endLoc,
            slop,
            tile,
            endTile);
        xOffsets[xTile -
                   getMinTileX(
                     )] =
          ret;
        return ret;
    }
    public org.apache.batik.ext.awt.image.rendered.DisplacementMapRed.TileOffsets getYOffsets(int yTile) {
        org.apache.batik.ext.awt.image.rendered.DisplacementMapRed.TileOffsets ret =
          yOffsets[yTile -
                     getMinTileY(
                       )];
        if (ret !=
              null)
            return ret;
        java.awt.image.SinglePixelPackedSampleModel sppsm;
        sppsm =
          (java.awt.image.SinglePixelPackedSampleModel)
            getSampleModel(
              );
        int stride =
          sppsm.
          getScanlineStride(
            );
        int th =
          sppsm.
          getHeight(
            );
        int height =
          th +
          2 *
          maxOffY;
        int y0 =
          getTileGridYOffset(
            ) +
          yTile *
          th -
          maxOffY -
          image.
          getTileGridYOffset(
            );
        int y1 =
          y0 +
          height -
          1;
        int tile =
          (int)
            java.lang.Math.
            floor(
              y0 /
                (double)
                  th);
        int endTile =
          (int)
            java.lang.Math.
            floor(
              y1 /
                (double)
                  th);
        int loc =
          y0 -
          tile *
          th;
        int endLoc =
          th;
        int slop =
          (endTile +
             1) *
          th -
          1 -
          y1;
        ret =
          new org.apache.batik.ext.awt.image.rendered.DisplacementMapRed.TileOffsets(
            height,
            0,
            stride,
            loc,
            endLoc,
            slop,
            tile,
            endTile);
        yOffsets[yTile -
                   getMinTileY(
                     )] =
          ret;
        return ret;
    }
    public void filterBL(java.awt.image.Raster off,
                         java.awt.image.WritableRaster dst,
                         int[] xTile,
                         int[] xOff,
                         int[] yTile,
                         int[] yOff) { final int w =
                                         dst.
                                         getWidth(
                                           );
                                       final int h =
                                         dst.
                                         getHeight(
                                           );
                                       final int xStart =
                                         maxOffX;
                                       final int yStart =
                                         maxOffY;
                                       final int xEnd =
                                         xStart +
                                         w;
                                       final int yEnd =
                                         yStart +
                                         h;
                                       java.awt.image.DataBufferInt dstDB =
                                         (java.awt.image.DataBufferInt)
                                           dst.
                                           getDataBuffer(
                                             );
                                       java.awt.image.DataBufferInt offDB =
                                         (java.awt.image.DataBufferInt)
                                           off.
                                           getDataBuffer(
                                             );
                                       java.awt.image.SinglePixelPackedSampleModel dstSPPSM;
                                       java.awt.image.SinglePixelPackedSampleModel offSPPSM;
                                       dstSPPSM =
                                         (java.awt.image.SinglePixelPackedSampleModel)
                                           dst.
                                           getSampleModel(
                                             );
                                       final int dstOff =
                                         dstDB.
                                         getOffset(
                                           ) +
                                         dstSPPSM.
                                         getOffset(
                                           dst.
                                             getMinX(
                                               ) -
                                             dst.
                                             getSampleModelTranslateX(
                                               ),
                                           dst.
                                             getMinY(
                                               ) -
                                             dst.
                                             getSampleModelTranslateY(
                                               ));
                                       offSPPSM =
                                         (java.awt.image.SinglePixelPackedSampleModel)
                                           off.
                                           getSampleModel(
                                             );
                                       final int offOff =
                                         offDB.
                                         getOffset(
                                           ) +
                                         offSPPSM.
                                         getOffset(
                                           dst.
                                             getMinX(
                                               ) -
                                             off.
                                             getSampleModelTranslateX(
                                               ),
                                           dst.
                                             getMinY(
                                               ) -
                                             off.
                                             getSampleModelTranslateY(
                                               ));
                                       final int dstScanStride =
                                         dstSPPSM.
                                         getScanlineStride(
                                           );
                                       final int offScanStride =
                                         offSPPSM.
                                         getScanlineStride(
                                           );
                                       final int dstAdjust =
                                         dstScanStride -
                                         w;
                                       final int offAdjust =
                                         offScanStride -
                                         w;
                                       final int[] dstPixels =
                                         dstDB.
                                         getBankData(
                                           )[0];
                                       final int[] offPixels =
                                         offDB.
                                         getBankData(
                                           )[0];
                                       final int xShift =
                                         xChannel.
                                         toInt(
                                           ) *
                                         8;
                                       final int yShift =
                                         yChannel.
                                         toInt(
                                           ) *
                                         8;
                                       int dp =
                                         dstOff;
                                       int ip =
                                         offOff;
                                       final int fpScaleX =
                                         (int)
                                           (scaleX /
                                              255.0 *
                                              (1 <<
                                                 15) +
                                              0.5);
                                       final int fpAdjX =
                                         (int)
                                           (-127.5 *
                                              fpScaleX -
                                              0.5);
                                       final int fpScaleY =
                                         (int)
                                           (scaleY /
                                              255.0 *
                                              (1 <<
                                                 15) +
                                              0.5);
                                       final int fpAdjY =
                                         (int)
                                           (-127.5 *
                                              fpScaleY -
                                              0.5);
                                       long start =
                                         java.lang.System.
                                         currentTimeMillis(
                                           );
                                       int pel00;
                                       int pel01;
                                       int pel10;
                                       int pel11;
                                       int xFrac;
                                       int yFrac;
                                       int newPel;
                                       int sp0;
                                       int sp1;
                                       int pel0;
                                       int pel1;
                                       int x;
                                       int y;
                                       int x0;
                                       int y0;
                                       int xDisplace;
                                       int yDisplace;
                                       int dPel;
                                       int xt =
                                         xTile[0] -
                                         1;
                                       int yt =
                                         yTile[0] -
                                         1;
                                       int xt1;
                                       int yt1;
                                       int[] imgPix =
                                         null;
                                       for (y =
                                              yStart;
                                            y <
                                              yEnd;
                                            y++) {
                                           for (x =
                                                  xStart;
                                                x <
                                                  xEnd;
                                                x++,
                                                  dp++,
                                                  ip++) {
                                               dPel =
                                                 offPixels[ip];
                                               xDisplace =
                                                 fpScaleX *
                                                   (dPel >>
                                                      xShift &
                                                      255) +
                                                   fpAdjX;
                                               yDisplace =
                                                 fpScaleY *
                                                   (dPel >>
                                                      yShift &
                                                      255) +
                                                   fpAdjY;
                                               x0 =
                                                 x +
                                                   (xDisplace >>
                                                      15);
                                               y0 =
                                                 y +
                                                   (yDisplace >>
                                                      15);
                                               if (xt !=
                                                     xTile[x0] ||
                                                     yt !=
                                                     yTile[y0]) {
                                                   xt =
                                                     xTile[x0];
                                                   yt =
                                                     yTile[y0];
                                                   imgPix =
                                                     ((java.awt.image.DataBufferInt)
                                                        image.
                                                        getTile(
                                                          xt,
                                                          yt).
                                                        getDataBuffer(
                                                          )).
                                                       getBankData(
                                                         )[0];
                                               }
                                               pel00 =
                                                 imgPix[xOff[x0] +
                                                          yOff[y0]];
                                               xt1 =
                                                 xTile[x0 +
                                                         1];
                                               yt1 =
                                                 yTile[y0 +
                                                         1];
                                               if (yt ==
                                                     yt1) {
                                                   if (xt ==
                                                         xt1) {
                                                       pel10 =
                                                         imgPix[xOff[x0 +
                                                                       1] +
                                                                  yOff[y0]];
                                                       pel01 =
                                                         imgPix[xOff[x0] +
                                                                  yOff[y0 +
                                                                         1]];
                                                       pel11 =
                                                         imgPix[xOff[x0 +
                                                                       1] +
                                                                  yOff[y0 +
                                                                         1]];
                                                   }
                                                   else {
                                                       pel01 =
                                                         imgPix[xOff[x0] +
                                                                  yOff[y0 +
                                                                         1]];
                                                       imgPix =
                                                         ((java.awt.image.DataBufferInt)
                                                            image.
                                                            getTile(
                                                              xt1,
                                                              yt).
                                                            getDataBuffer(
                                                              )).
                                                           getBankData(
                                                             )[0];
                                                       pel10 =
                                                         imgPix[xOff[x0 +
                                                                       1] +
                                                                  yOff[y0]];
                                                       pel11 =
                                                         imgPix[xOff[x0 +
                                                                       1] +
                                                                  yOff[y0 +
                                                                         1]];
                                                       xt =
                                                         xt1;
                                                   }
                                               }
                                               else {
                                                   if (xt ==
                                                         xt1) {
                                                       pel10 =
                                                         imgPix[xOff[x0 +
                                                                       1] +
                                                                  yOff[y0]];
                                                       imgPix =
                                                         ((java.awt.image.DataBufferInt)
                                                            image.
                                                            getTile(
                                                              xt,
                                                              yt1).
                                                            getDataBuffer(
                                                              )).
                                                           getBankData(
                                                             )[0];
                                                       pel01 =
                                                         imgPix[xOff[x0] +
                                                                  yOff[y0 +
                                                                         1]];
                                                       pel11 =
                                                         imgPix[xOff[x0 +
                                                                       1] +
                                                                  yOff[y0 +
                                                                         1]];
                                                       yt =
                                                         yt1;
                                                   }
                                                   else {
                                                       imgPix =
                                                         ((java.awt.image.DataBufferInt)
                                                            image.
                                                            getTile(
                                                              xt,
                                                              yt1).
                                                            getDataBuffer(
                                                              )).
                                                           getBankData(
                                                             )[0];
                                                       pel01 =
                                                         imgPix[xOff[x0] +
                                                                  yOff[y0 +
                                                                         1]];
                                                       imgPix =
                                                         ((java.awt.image.DataBufferInt)
                                                            image.
                                                            getTile(
                                                              xt1,
                                                              yt1).
                                                            getDataBuffer(
                                                              )).
                                                           getBankData(
                                                             )[0];
                                                       pel11 =
                                                         imgPix[xOff[x0 +
                                                                       1] +
                                                                  yOff[y0 +
                                                                         1]];
                                                       imgPix =
                                                         ((java.awt.image.DataBufferInt)
                                                            image.
                                                            getTile(
                                                              xt1,
                                                              yt).
                                                            getDataBuffer(
                                                              )).
                                                           getBankData(
                                                             )[0];
                                                       pel10 =
                                                         imgPix[xOff[x0 +
                                                                       1] +
                                                                  yOff[y0]];
                                                       xt =
                                                         xt1;
                                                   }
                                               }
                                               xFrac =
                                                 xDisplace &
                                                   32767;
                                               yFrac =
                                                 yDisplace &
                                                   32767;
                                               sp0 =
                                                 pel00 >>>
                                                   16 &
                                                   65280;
                                               sp1 =
                                                 pel10 >>>
                                                   16 &
                                                   65280;
                                               pel0 =
                                                 sp0 +
                                                   ((sp1 -
                                                       sp0) *
                                                      xFrac +
                                                      16384 >>
                                                      15) &
                                                   65535;
                                               sp0 =
                                                 pel01 >>>
                                                   16 &
                                                   65280;
                                               sp1 =
                                                 pel11 >>>
                                                   16 &
                                                   65280;
                                               pel1 =
                                                 sp0 +
                                                   ((sp1 -
                                                       sp0) *
                                                      xFrac +
                                                      16384 >>
                                                      15) &
                                                   65535;
                                               newPel =
                                                 ((pel0 <<
                                                     15) +
                                                    (pel1 -
                                                       pel0) *
                                                    yFrac +
                                                    4194304 &
                                                    2139095040) <<
                                                   1;
                                               sp0 =
                                                 pel00 >>
                                                   8 &
                                                   65280;
                                               sp1 =
                                                 pel10 >>
                                                   8 &
                                                   65280;
                                               pel0 =
                                                 sp0 +
                                                   ((sp1 -
                                                       sp0) *
                                                      xFrac +
                                                      16384 >>
                                                      15) &
                                                   65535;
                                               sp0 =
                                                 pel01 >>
                                                   8 &
                                                   65280;
                                               sp1 =
                                                 pel11 >>
                                                   8 &
                                                   65280;
                                               pel1 =
                                                 sp0 +
                                                   ((sp1 -
                                                       sp0) *
                                                      xFrac +
                                                      16384 >>
                                                      15) &
                                                   65535;
                                               newPel |=
                                                 ((pel0 <<
                                                     15) +
                                                    (pel1 -
                                                       pel0) *
                                                    yFrac +
                                                    4194304 &
                                                    2139095040) >>>
                                                   7;
                                               sp0 =
                                                 pel00 &
                                                   65280;
                                               sp1 =
                                                 pel10 &
                                                   65280;
                                               pel0 =
                                                 sp0 +
                                                   ((sp1 -
                                                       sp0) *
                                                      xFrac +
                                                      16384 >>
                                                      15) &
                                                   65535;
                                               sp0 =
                                                 pel01 &
                                                   65280;
                                               sp1 =
                                                 pel11 &
                                                   65280;
                                               pel1 =
                                                 sp0 +
                                                   ((sp1 -
                                                       sp0) *
                                                      xFrac +
                                                      16384 >>
                                                      15) &
                                                   65535;
                                               newPel |=
                                                 ((pel0 <<
                                                     15) +
                                                    (pel1 -
                                                       pel0) *
                                                    yFrac +
                                                    4194304 &
                                                    2139095040) >>>
                                                   15;
                                               sp0 =
                                                 pel00 <<
                                                   8 &
                                                   65280;
                                               sp1 =
                                                 pel10 <<
                                                   8 &
                                                   65280;
                                               pel0 =
                                                 sp0 +
                                                   ((sp1 -
                                                       sp0) *
                                                      xFrac +
                                                      16384 >>
                                                      15) &
                                                   65535;
                                               sp0 =
                                                 pel01 <<
                                                   8 &
                                                   65280;
                                               sp1 =
                                                 pel11 <<
                                                   8 &
                                                   65280;
                                               pel1 =
                                                 sp0 +
                                                   ((sp1 -
                                                       sp0) *
                                                      xFrac +
                                                      16384 >>
                                                      15) &
                                                   65535;
                                               newPel |=
                                                 ((pel0 <<
                                                     15) +
                                                    (pel1 -
                                                       pel0) *
                                                    yFrac +
                                                    4194304 &
                                                    2139095040) >>>
                                                   23;
                                               dstPixels[dp] =
                                                 newPel;
                                           }
                                           dp +=
                                             dstAdjust;
                                           ip +=
                                             offAdjust;
                                       }
                                       if (TIME) {
                                           long end =
                                             java.lang.System.
                                             currentTimeMillis(
                                               );
                                           java.lang.System.
                                             out.
                                             println(
                                               "Time: " +
                                               (end -
                                                  start));
                                       } }
    public void filterBLPre(java.awt.image.Raster off,
                            java.awt.image.WritableRaster dst,
                            int[] xTile,
                            int[] xOff,
                            int[] yTile,
                            int[] yOff) {
        final int w =
          dst.
          getWidth(
            );
        final int h =
          dst.
          getHeight(
            );
        final int xStart =
          maxOffX;
        final int yStart =
          maxOffY;
        final int xEnd =
          xStart +
          w;
        final int yEnd =
          yStart +
          h;
        java.awt.image.DataBufferInt dstDB =
          (java.awt.image.DataBufferInt)
            dst.
            getDataBuffer(
              );
        java.awt.image.DataBufferInt offDB =
          (java.awt.image.DataBufferInt)
            off.
            getDataBuffer(
              );
        java.awt.image.SinglePixelPackedSampleModel dstSPPSM;
        java.awt.image.SinglePixelPackedSampleModel offSPPSM;
        dstSPPSM =
          (java.awt.image.SinglePixelPackedSampleModel)
            dst.
            getSampleModel(
              );
        final int dstOff =
          dstDB.
          getOffset(
            ) +
          dstSPPSM.
          getOffset(
            dst.
              getMinX(
                ) -
              dst.
              getSampleModelTranslateX(
                ),
            dst.
              getMinY(
                ) -
              dst.
              getSampleModelTranslateY(
                ));
        offSPPSM =
          (java.awt.image.SinglePixelPackedSampleModel)
            off.
            getSampleModel(
              );
        final int offOff =
          offDB.
          getOffset(
            ) +
          offSPPSM.
          getOffset(
            dst.
              getMinX(
                ) -
              off.
              getSampleModelTranslateX(
                ),
            dst.
              getMinY(
                ) -
              off.
              getSampleModelTranslateY(
                ));
        final int dstScanStride =
          dstSPPSM.
          getScanlineStride(
            );
        final int offScanStride =
          offSPPSM.
          getScanlineStride(
            );
        final int dstAdjust =
          dstScanStride -
          w;
        final int offAdjust =
          offScanStride -
          w;
        final int[] dstPixels =
          dstDB.
          getBankData(
            )[0];
        final int[] offPixels =
          offDB.
          getBankData(
            )[0];
        final int xShift =
          xChannel.
          toInt(
            ) *
          8;
        final int yShift =
          yChannel.
          toInt(
            ) *
          8;
        int dp =
          dstOff;
        int ip =
          offOff;
        final int fpScaleX =
          (int)
            (scaleX /
               255.0 *
               (1 <<
                  15) +
               0.5);
        final int fpAdjX =
          (int)
            (-127.5 *
               fpScaleX -
               0.5);
        final int fpScaleY =
          (int)
            (scaleY /
               255.0 *
               (1 <<
                  15) +
               0.5);
        final int fpAdjY =
          (int)
            (-127.5 *
               fpScaleY -
               0.5);
        long start =
          java.lang.System.
          currentTimeMillis(
            );
        int pel00;
        int pel01;
        int pel10;
        int pel11;
        int xFrac;
        int yFrac;
        int newPel;
        int sp0;
        int sp1;
        int pel0;
        int pel1;
        int a00;
        int a01;
        int a10;
        int a11;
        int x;
        int y;
        int x0;
        int y0;
        int xDisplace;
        int yDisplace;
        int dPel;
        final int norm =
          (1 <<
             24) /
          255;
        int xt =
          xTile[0] -
          1;
        int yt =
          yTile[0] -
          1;
        int xt1;
        int yt1;
        int[] imgPix =
          null;
        for (y =
               yStart;
             y <
               yEnd;
             y++) {
            for (x =
                   xStart;
                 x <
                   xEnd;
                 x++,
                   dp++,
                   ip++) {
                dPel =
                  offPixels[ip];
                xDisplace =
                  fpScaleX *
                    (dPel >>
                       xShift &
                       255) +
                    fpAdjX;
                yDisplace =
                  fpScaleY *
                    (dPel >>
                       yShift &
                       255) +
                    fpAdjY;
                x0 =
                  x +
                    (xDisplace >>
                       15);
                y0 =
                  y +
                    (yDisplace >>
                       15);
                if (xt !=
                      xTile[x0] ||
                      yt !=
                      yTile[y0]) {
                    xt =
                      xTile[x0];
                    yt =
                      yTile[y0];
                    imgPix =
                      ((java.awt.image.DataBufferInt)
                         image.
                         getTile(
                           xt,
                           yt).
                         getDataBuffer(
                           )).
                        getBankData(
                          )[0];
                }
                pel00 =
                  imgPix[xOff[x0] +
                           yOff[y0]];
                xt1 =
                  xTile[x0 +
                          1];
                yt1 =
                  yTile[y0 +
                          1];
                if (yt ==
                      yt1) {
                    if (xt ==
                          xt1) {
                        pel10 =
                          imgPix[xOff[x0 +
                                        1] +
                                   yOff[y0]];
                        pel01 =
                          imgPix[xOff[x0] +
                                   yOff[y0 +
                                          1]];
                        pel11 =
                          imgPix[xOff[x0 +
                                        1] +
                                   yOff[y0 +
                                          1]];
                    }
                    else {
                        pel01 =
                          imgPix[xOff[x0] +
                                   yOff[y0 +
                                          1]];
                        imgPix =
                          ((java.awt.image.DataBufferInt)
                             image.
                             getTile(
                               xt1,
                               yt).
                             getDataBuffer(
                               )).
                            getBankData(
                              )[0];
                        pel10 =
                          imgPix[xOff[x0 +
                                        1] +
                                   yOff[y0]];
                        pel11 =
                          imgPix[xOff[x0 +
                                        1] +
                                   yOff[y0 +
                                          1]];
                        xt =
                          xt1;
                    }
                }
                else {
                    if (xt ==
                          xt1) {
                        pel10 =
                          imgPix[xOff[x0 +
                                        1] +
                                   yOff[y0]];
                        imgPix =
                          ((java.awt.image.DataBufferInt)
                             image.
                             getTile(
                               xt,
                               yt1).
                             getDataBuffer(
                               )).
                            getBankData(
                              )[0];
                        pel01 =
                          imgPix[xOff[x0] +
                                   yOff[y0 +
                                          1]];
                        pel11 =
                          imgPix[xOff[x0 +
                                        1] +
                                   yOff[y0 +
                                          1]];
                        yt =
                          yt1;
                    }
                    else {
                        imgPix =
                          ((java.awt.image.DataBufferInt)
                             image.
                             getTile(
                               xt,
                               yt1).
                             getDataBuffer(
                               )).
                            getBankData(
                              )[0];
                        pel01 =
                          imgPix[xOff[x0] +
                                   yOff[y0 +
                                          1]];
                        imgPix =
                          ((java.awt.image.DataBufferInt)
                             image.
                             getTile(
                               xt1,
                               yt1).
                             getDataBuffer(
                               )).
                            getBankData(
                              )[0];
                        pel11 =
                          imgPix[xOff[x0 +
                                        1] +
                                   yOff[y0 +
                                          1]];
                        imgPix =
                          ((java.awt.image.DataBufferInt)
                             image.
                             getTile(
                               xt1,
                               yt).
                             getDataBuffer(
                               )).
                            getBankData(
                              )[0];
                        pel10 =
                          imgPix[xOff[x0 +
                                        1] +
                                   yOff[y0]];
                        xt =
                          xt1;
                    }
                }
                xFrac =
                  xDisplace &
                    32767;
                yFrac =
                  yDisplace &
                    32767;
                sp0 =
                  pel00 >>>
                    16 &
                    65280;
                sp1 =
                  pel10 >>>
                    16 &
                    65280;
                pel0 =
                  sp0 +
                    ((sp1 -
                        sp0) *
                       xFrac +
                       16384 >>
                       15) &
                    65535;
                a00 =
                  (sp0 >>
                     8) *
                    norm +
                    128 >>
                    8;
                a10 =
                  (sp1 >>
                     8) *
                    norm +
                    128 >>
                    8;
                sp0 =
                  pel01 >>>
                    16 &
                    65280;
                sp1 =
                  pel11 >>>
                    16 &
                    65280;
                pel1 =
                  sp0 +
                    ((sp1 -
                        sp0) *
                       xFrac +
                       16384 >>
                       15) &
                    65535;
                a01 =
                  (sp0 >>
                     8) *
                    norm +
                    128 >>
                    8;
                a11 =
                  (sp1 >>
                     8) *
                    norm +
                    128 >>
                    8;
                newPel =
                  ((pel0 <<
                      15) +
                     (pel1 -
                        pel0) *
                     yFrac +
                     4194304 &
                     2139095040) <<
                    1;
                sp0 =
                  (pel00 >>
                     16 &
                     255) *
                    a00 +
                    128 >>
                    8;
                sp1 =
                  (pel10 >>
                     16 &
                     255) *
                    a10 +
                    128 >>
                    8;
                pel0 =
                  sp0 +
                    ((sp1 -
                        sp0) *
                       xFrac +
                       16384 >>
                       15) &
                    65535;
                sp0 =
                  (pel01 >>
                     16 &
                     255) *
                    a01 +
                    128 >>
                    8;
                sp1 =
                  (pel11 >>
                     16 &
                     255) *
                    a11 +
                    128 >>
                    8;
                pel1 =
                  sp0 +
                    ((sp1 -
                        sp0) *
                       xFrac +
                       16384 >>
                       15) &
                    65535;
                newPel |=
                  ((pel0 <<
                      15) +
                     (pel1 -
                        pel0) *
                     yFrac +
                     4194304 &
                     2139095040) >>>
                    7;
                sp0 =
                  (pel00 >>
                     8 &
                     255) *
                    a00 +
                    128 >>
                    8;
                sp1 =
                  (pel10 >>
                     8 &
                     255) *
                    a10 +
                    128 >>
                    8;
                pel0 =
                  sp0 +
                    ((sp1 -
                        sp0) *
                       xFrac +
                       16384 >>
                       15) &
                    65535;
                sp0 =
                  (pel01 >>
                     8 &
                     255) *
                    a01 +
                    128 >>
                    8;
                sp1 =
                  (pel11 >>
                     8 &
                     255) *
                    a11 +
                    128 >>
                    8;
                pel1 =
                  sp0 +
                    ((sp1 -
                        sp0) *
                       xFrac +
                       16384 >>
                       15) &
                    65535;
                newPel |=
                  ((pel0 <<
                      15) +
                     (pel1 -
                        pel0) *
                     yFrac +
                     4194304 &
                     2139095040) >>>
                    15;
                sp0 =
                  (pel00 &
                     255) *
                    a00 +
                    128 >>
                    8;
                sp1 =
                  (pel10 &
                     255) *
                    a10 +
                    128 >>
                    8;
                pel0 =
                  sp0 +
                    ((sp1 -
                        sp0) *
                       xFrac +
                       16384 >>
                       15) &
                    65535;
                sp0 =
                  (pel01 &
                     255) *
                    a01 +
                    128 >>
                    8;
                sp1 =
                  (pel11 &
                     255) *
                    a11 +
                    128 >>
                    8;
                pel1 =
                  sp0 +
                    ((sp1 -
                        sp0) *
                       xFrac +
                       16384 >>
                       15) &
                    65535;
                newPel |=
                  ((pel0 <<
                      15) +
                     (pel1 -
                        pel0) *
                     yFrac +
                     4194304 &
                     2139095040) >>>
                    23;
                dstPixels[dp] =
                  newPel;
            }
            dp +=
              dstAdjust;
            ip +=
              offAdjust;
        }
        if (TIME) {
            long end =
              java.lang.System.
              currentTimeMillis(
                );
            java.lang.System.
              out.
              println(
                "Time: " +
                (end -
                   start));
        }
    }
    public void filterNN(java.awt.image.Raster off,
                         java.awt.image.WritableRaster dst,
                         int[] xTile,
                         int[] xOff,
                         int[] yTile,
                         int[] yOff) { final int w =
                                         dst.
                                         getWidth(
                                           );
                                       final int h =
                                         dst.
                                         getHeight(
                                           );
                                       final int xStart =
                                         maxOffX;
                                       final int yStart =
                                         maxOffY;
                                       final int xEnd =
                                         xStart +
                                         w;
                                       final int yEnd =
                                         yStart +
                                         h;
                                       java.awt.image.DataBufferInt dstDB =
                                         (java.awt.image.DataBufferInt)
                                           dst.
                                           getDataBuffer(
                                             );
                                       java.awt.image.DataBufferInt offDB =
                                         (java.awt.image.DataBufferInt)
                                           off.
                                           getDataBuffer(
                                             );
                                       java.awt.image.SinglePixelPackedSampleModel dstSPPSM;
                                       java.awt.image.SinglePixelPackedSampleModel offSPPSM;
                                       dstSPPSM =
                                         (java.awt.image.SinglePixelPackedSampleModel)
                                           dst.
                                           getSampleModel(
                                             );
                                       final int dstOff =
                                         dstDB.
                                         getOffset(
                                           ) +
                                         dstSPPSM.
                                         getOffset(
                                           dst.
                                             getMinX(
                                               ) -
                                             dst.
                                             getSampleModelTranslateX(
                                               ),
                                           dst.
                                             getMinY(
                                               ) -
                                             dst.
                                             getSampleModelTranslateY(
                                               ));
                                       offSPPSM =
                                         (java.awt.image.SinglePixelPackedSampleModel)
                                           off.
                                           getSampleModel(
                                             );
                                       final int offOff =
                                         offDB.
                                         getOffset(
                                           ) +
                                         offSPPSM.
                                         getOffset(
                                           off.
                                             getMinX(
                                               ) -
                                             off.
                                             getSampleModelTranslateX(
                                               ),
                                           off.
                                             getMinY(
                                               ) -
                                             off.
                                             getSampleModelTranslateY(
                                               ));
                                       final int dstScanStride =
                                         dstSPPSM.
                                         getScanlineStride(
                                           );
                                       final int offScanStride =
                                         offSPPSM.
                                         getScanlineStride(
                                           );
                                       final int dstAdjust =
                                         dstScanStride -
                                         w;
                                       final int offAdjust =
                                         offScanStride -
                                         w;
                                       final int[] dstPixels =
                                         dstDB.
                                         getBankData(
                                           )[0];
                                       final int[] offPixels =
                                         offDB.
                                         getBankData(
                                           )[0];
                                       final int xShift =
                                         xChannel.
                                         toInt(
                                           ) *
                                         8;
                                       final int yShift =
                                         yChannel.
                                         toInt(
                                           ) *
                                         8;
                                       final int fpScaleX =
                                         (int)
                                           (scaleX /
                                              255.0 *
                                              (1 <<
                                                 15) +
                                              0.5);
                                       final int fpScaleY =
                                         (int)
                                           (scaleY /
                                              255.0 *
                                              (1 <<
                                                 15) +
                                              0.5);
                                       final int fpAdjX =
                                         (int)
                                           (-127.5 *
                                              fpScaleX -
                                              0.5) +
                                         16384;
                                       final int fpAdjY =
                                         (int)
                                           (-127.5 *
                                              fpScaleY -
                                              0.5) +
                                         16384;
                                       int dp =
                                         dstOff;
                                       int ip =
                                         offOff;
                                       long start =
                                         java.lang.System.
                                         currentTimeMillis(
                                           );
                                       int y =
                                         yStart;
                                       int xt =
                                         xTile[0] -
                                         1;
                                       int yt =
                                         yTile[0] -
                                         1;
                                       int[] imgPix =
                                         null;
                                       int x0;
                                       int y0;
                                       int xDisplace;
                                       int yDisplace;
                                       int dPel;
                                       while (y <
                                                yEnd) {
                                           int x =
                                             xStart;
                                           while (x <
                                                    xEnd) {
                                               dPel =
                                                 offPixels[ip];
                                               xDisplace =
                                                 fpScaleX *
                                                   (dPel >>
                                                      xShift &
                                                      255) +
                                                   fpAdjX;
                                               yDisplace =
                                                 fpScaleY *
                                                   (dPel >>
                                                      yShift &
                                                      255) +
                                                   fpAdjY;
                                               x0 =
                                                 x +
                                                   (xDisplace >>
                                                      15);
                                               y0 =
                                                 y +
                                                   (yDisplace >>
                                                      15);
                                               if (xt !=
                                                     xTile[x0] ||
                                                     yt !=
                                                     yTile[y0]) {
                                                   xt =
                                                     xTile[x0];
                                                   yt =
                                                     yTile[y0];
                                                   imgPix =
                                                     ((java.awt.image.DataBufferInt)
                                                        image.
                                                        getTile(
                                                          xt,
                                                          yt).
                                                        getDataBuffer(
                                                          )).
                                                       getBankData(
                                                         )[0];
                                               }
                                               dstPixels[dp] =
                                                 imgPix[xOff[x0] +
                                                          yOff[y0]];
                                               dp++;
                                               ip++;
                                               x++;
                                           }
                                           dp +=
                                             dstAdjust;
                                           ip +=
                                             offAdjust;
                                           y++;
                                       }
                                       if (TIME) {
                                           long end =
                                             java.lang.System.
                                             currentTimeMillis(
                                               );
                                           java.lang.System.
                                             out.
                                             println(
                                               "Time: " +
                                               (end -
                                                  start));
                                       } }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1aC3AV1Rk+9yYkISHkwVMeAULQ4WGu+KDV4ANCAsEbkkki" +
       "haCGzd5zc5fs3V12z00uWFql0xGdqYOKSh2lnSkKVQRH6minVek4og5qfdZa" +
       "B622o1ZrC9NRW21r//+c3bt79969IYw0M3uy9+z5//P9j/P/5z+7Bz4lYyyT" +
       "1FGNNbItBrUaWzTWKZkWjTWrkmX1QF+ffFeR9I9rP1pzcZiU9JLxCclqlyWL" +
       "tipUjVm9ZKaiWUzSZGqtoTSGFJ0mtag5JDFF13rJJMVqSxqqIiusXY9RHLBW" +
       "MqOkRmLMVPpTjLbZDBiZGQUkEY4kssz/uClKxsm6scUdPtUzvNnzBEcm3bks" +
       "Rqqjm6QhKZJiihqJKhZrSptkoaGrWwZUnTXSNGvcpF5kq2B19KIcFdQ/XPX5" +
       "VzsT1VwFEyRN0xkXz+qilq4O0ViUVLm9LSpNWpvJ90hRlFR4BjPSEHUmjcCk" +
       "EZjUkdYdBegrqZZKNutcHOZwKjFkBMTInGwmhmRKSZtNJ8cMHMqYLTsnBmln" +
       "Z6QVUuaIeMfCyK67rq1+pIhU9ZIqRetGODKAYDBJLyiUJvupaS2LxWisl9Ro" +
       "YOxuaiqSqmy1LV1rKQOaxFJgfkct2JkyqMnndHUFdgTZzJTMdDMjXpw7lP1r" +
       "TFyVBkDWya6sQsJW7AcByxUAZsYl8DubpHhQ0WKMzPJTZGRsuBIGAGlpkrKE" +
       "npmqWJOgg9QKF1ElbSDSDa6nDcDQMTo4oMnItECmqGtDkgelAdqHHukb1yke" +
       "waixXBFIwsgk/zDOCaw0zWclj30+XbP0luu0VVqYhABzjMoq4q8AojofUReN" +
       "U5PCOhCE4xZE75QmP7EjTAgMnuQbLMY89t2TVyyqO/KcGDM9z5iO/k1UZn3y" +
       "3v7xr8xonn9xEcIoM3RLQeNnSc5XWaf9pCltQISZnOGIDxudh0e6jq6//gH6" +
       "SZiUt5ESWVdTSfCjGllPGopKzZVUo6bEaKyNjKVarJk/byOlcB9VNCp6O+Jx" +
       "i7I2UqzyrhKd/wYVxYEFqqgc7hUtrjv3hsQS/D5tEEJK4SLj4JpPxB//z0gy" +
       "ktCTNCLJkqZoeqTT1FF+KwIRpx90m4j0g9cPRiw9ZYILRnRzICKBHySo/QBX" +
       "pjTMIkoSzB8Bc8TAJrHICsUyVHDaJPBpl4wuGmtEtzP+3xOmUQMThkMhMM4M" +
       "f2jA8at0FRj0ybtSy1tOHuw7JtwOl4qtO0YuAQyNAkMjx8ADKWBo5BgaHQyN" +
       "uRhIKMSnnohYhE+ARQchNkBwHje/+5rVG3fUF4EzGsPFYA4cWp+VpJrdAOJE" +
       "/T75UG3l1jnvLH46TIqjpFaSWUpSMecsMwcgmsmD9oIf1w/py80isz1ZBNOf" +
       "qcs0BkEsKJvYXMr0IWpiPyMTPRycHIerORKcYfLiJ0d2D9+w9vvnhUk4O3Hg" +
       "lGMg5iF5J4b7TFhv8AeMfHyrbvzo80N3btPd0JGViZwEmkOJMtT7ncOvnj55" +
       "wWzp0b4ntjVwtY+F0M4kWIoQNev8c2RFpiYnyqMsZSBwXDeTkoqPHB2Xs4Sp" +
       "D7s93Gtr+P1EcIsKXKoz4brBXrv8Pz6dbGA7RXg5+plPCp5FLu027v39S3+5" +
       "gKvbSThVnp1CN2VNniCHzGp5OKtx3bbHpBTGHd/defsdn964gfssjJibb8IG" +
       "bJshuIEJQc0/fG7zW+++s/f1sOvnDLJ8qh82S+mMkNhPygsICbOd7eKBIKlC" +
       "3ECvabhKA/9U4orUr1JcWP+umrf40b/eUi38QIUex40WjczA7T9rObn+2LVf" +
       "1HE2IRmTtKszd5iI/BNczstMU9qCONI3vDrzx89K90IOgbhtKVupCMVcB6Vc" +
       "8qmMXHCq4aUZhiBCiCtIusRhsGAEBsu6Vi5vTsAyozyVfjs7yOBC7k71WxAQ" +
       "lCTYf8hOp+d3bpR3NHT+WaTKs/IQiHGT9kd+tPbNTS9w7yrDkIP9OFGlJ6BA" +
       "aPK4drWw+tfwF4Lrv3ihtbFDpKXaZjs3zs4kR8NIA/L5BXaz2QJEttW+O3jP" +
       "Rw8JAfybB99gumPXzV833rJLuIzYYc3N2eR4acQuS4iDzaWIbk6hWThF64eH" +
       "tv1q/7YbBara7P1CC2yHH/rdf15o3P3H5/MkIli7uiT2yRfiKsrkjInZ1hEi" +
       "rbip6tc7a4taIVy1kbKUpmxO0baYlydsEa1Uv8dc7t6Nd3iFQ9MwEloAVsCO" +
       "pY7zTeF+j87Wxf0U9pOrYMtq8VEX8VHnZRATjpjwZ2uwmWd5Q3u2RT2lQp+8" +
       "8/UTlWtPPHmSayW71vBGMsi6wiQ12JyNJpniT72rJCsB4y48subqavXIV8Cx" +
       "FzjKsNmwOkyQIJ0V9+zRY0r/8JunJ298pYiEW0k5mCHWKvEUQsZC7KZWArYR" +
       "aePyK0ToGi6DppqLSnKEz+nA8DErf2BqSRqMh5Ktj0/5xdJ9e97hMdQQPKZz" +
       "+krc2WTtGXjF6qatB1771hv7br1zWHhcgfXjo5v6ZYfav/39f+aonGfpPEvK" +
       "R98bOXDPtObLPuH0brpE6oZ07m4Mthwu7fkPJD8L15c8EyalvaRativEtZKa" +
       "wiTUC1WR5ZSNUEVmPc+ucMR2vimzHZjhX9Oeaf2J2rtQilnWonBz81lowvPg" +
       "WminrYX+3Mw3gMKjEFLjcl1XqaS9ONu8/o17vvwb978xQwgdsgOSbOTMz+Ht" +
       "AmzO5YYuYqTUMJUhiIWQPi1etmJMUDRJ9aXRqQXwMFLc09bewgkusQMX/rvc" +
       "c98MU/ULmP5ogz/b7P0Gth3YSIKsK9D/e3P1tcjGtyhXX/hfxsYM0ATexrEZ" +
       "wCaRR/og7qC5q7pb+tbw6DPoE8M6dTGwkuKyLLYnWpwjBuE3W/OLwGWM+4BX" +
       "FOCHJpclla7j0dcH/LrTAL7EnmhJAPDtAjg223JhBlE7MNfng/mDUcKcA1eT" +
       "PVFTAMybCsIMomakLO3dEvmA3nwaQO2h4n8eoDsLAg2iBqBbCgC99dSB8qkm" +
       "w9ViT9USAPSu/B5LfM5aXIAVhCW+9cQfS3yQd48SMq7m1fY8qwMg/8TV7d25" +
       "KIOoIciJQxQrH86fjhInrqkOe6aOAJz3F8QZRA04k1K6Ix5fN1LQLlK0nO0h" +
       "/swJ2PvOgHCPYLM/A5ZHgAd98x4+jXl77Hl7AuZ9rKBSg6jBRROOtq70oXx8" +
       "lChnwLXenmd9AMonC6IMosY4JQ7+rOz3F5kijBebYsN/dcXRp6yfffCI2Ojl" +
       "K/F8J6b795XJbyeP8hIPp2vKBlZVSCyAMy94K+lBtef+uS99f8/c9/g+p0yx" +
       "YMMFxWCeM2APzYkD737yauXMg/ykpRhrSpy00n94nns2nnXkzWWqwuZo2ilX" +
       "Wk//LK+hB+pR2xiGYZBTWmhPnYYr9do67w1wpd8WdKUgaswkHW64e8YH9OUC" +
       "QNPuhAszE/K/EuI7UPZM6KlRCLrLzKAzf14X792+a0+s477Fji+uYFBZ6ca5" +
       "Kh2iqodVKXLKKnfaucnd2uH4+Nv+9MuGgeWjOR3FvroRzj/x9yzw2wXBbu+H" +
       "8uz2j6f1XJbYOIqDzlk+LflZ/rz9wPMrz5ZvC/NXOqKoyXkVlE3UlF3KlJuU" +
       "pUwtu8qfm7HrNLRXPVwHbbse9Luh6zk+l8gc4QWR+o4DnAMMe23OzBwliLX4" +
       "HVNh/LxLsmCZ82k/KHCg8DE274Gb48vTFRKT8PeHroe/P9JSLFykY8c6g/cf" +
       "z0hci88wSR22JT48emUFkfpEDXMg4UxWfZCz/qyAQr7A5gQk5AHKMHY5ep7k" +
       "07PQr6uok2dAUVMcr3rZlvbl0SsqiDS/V2V0FCoO1lGoBDu/ZqQCdLTOybTf" +
       "bK7IKDZEzqRiT9raOTl6xQaRjqTYCQUUOwmb8UKx6928Eypz1VF1BtTBX5Vc" +
       "ACjtFBWqHbU6BEkeUp+0JRwId6B/uaHm6Qy/8UheQ3y1HSMbvqEXoANUT0Y6" +
       "JZaIUm2AJZz3q2eSvbDCs2i8eq7IB/PG8l4xQGxXQufkryd5JGvEJsFZXcpI" +
       "icqnwl8HkHKe4ZrdDn/O2pzgnqc1q7pGMU84z8TLVkVvzHy3AQ/TeZEez4gS" +
       "mufxCY6ngHNfWOAZ1pGhxVBeyIhLiFFg+MVBjp0O3mCG5rgN/z27wASXYjMd" +
       "0mJcUSHML4/mKxyLh3Ql5q7MGWdqZS4BMV60l9ex0a/MYwGkI61Mn85cxV1Z" +
       "QHHt2LRCBHMU12lyc17u6mnlGYxg4TsEz/Dto9aTIMlDetp6WldAT3y1d2cc" +
       "jB+tepXU800oKc1IbW6axTcnU3M++BIfKckH91SVTdlz1ZuiiHQ+JBoHO/p4" +
       "SlW9Z/ue+xLDpHGFq3icOOnn77tC/Yycc4rbAdCEc8szniQ4UEbqCnNwTs28" +
       "VAlGpgZRMVIErXf0IAS/fKNhJLTekRoj1f6RMD//7x23mZFydxyEaHHjHYLc" +
       "YQjepgwnBp/yS+1l/RYzoUgDa6ZD2SWj40Fk0kge5Kky52ZVZ/ybQaeSSomv" +
       "BvvkQ3tWr7nu5JL7xAcRsipt3YpcKqKkVHybkanG5gRyc3iVrJr/1fiHx85z" +
       "6tYaAdhdo9PdpULWQewy0Gmn+b4WsBoyHw28tXfpky/uKHk1TEIbSEiCVLch" +
       "931W2khBGbwhmvveFypX/hlD0/y7t1y2KP73t/kbQyLeE88IHt8nv77vmtdu" +
       "m7q3Lkwq2sATwT5p/qJtxRati8pDZi+pVKyWNEAELpBXs14qj8f1JeHbX64X" +
       "W52VmV78nIaR+tw36rkfIZWr+jCEWz2l8c8cKqFydnucqjyroE0Zho/A7bFN" +
       "ie0qkfPQGuCyfdF2w3A+OBh72OCBpi045+7gt3h30/8AlEzxMk8sAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "xFriIEGDs9IAjnAxFVs+FDDxrkgpUL8j");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("mVV/xmbzQRfvcj6xiOrNYIOu6oxOKYt2czFvwTNnhqAuLY+rcdpoh9aKluZh" +
       "dUN25zlsoyoK+AbydRM12GSh161JhgfhiNIbmHotsFbDUT8hs5XWg9MGXhUI" +
       "A4EFkvDNWrNVRdZxw2jUIBS3u/mOt9AIx/H3F1tgX3l9W3P3lruQRyciN3b5" +
       "au3l17H7tn/0eFG852iftvxcqJw6RXdin/bEi/lKcXTgkZsddCwPUnz+48+/" +
       "oAk/Xz9/sIH7bFy5M/b8H7b1rW6f6Ooi6OmZm2/A8+U++PGL9t/4+J89JH7A" +
       "+PDrOBL27lM4T3f5T/gXf6v/A+rfO1+57ei1+w0nUK9v9Oz1L9vvCvU4CV3x" +
       "ulfujxxJ9qFCYk+A66UDyb50egf8eO7Ofk34Q/u5P3Ve5NzBwbqD3edHjs6a" +
       "7Hf356EZl8eA5CjWw7KH/3aLEyd/VhR/FFcuqZ6fdeRYLn7/ybFC/fGrbeee" +
       "7LCs+OqRBO4rKouXSL9yIIFfeWskcL4kOF/8LF9xPV9S/e9bcPmtovhfceXi" +
       "Wo+LVxyHwnvXKeHthXbM/TffBPcPHM7/Vw64/8pbOv9HjJ87f3PGz91eVP5F" +
       "XHkbYHxx4kXKF495/Mu3gsdXDnh85bvE4z234PFKUdy553F5Jo/n7noTPJbH" +
       "KxsAzTv3bc/d99bweKEkuFD8/Pax0b14NG550uBypXL7YD/u/juuqG/yuLHs" +
       "+xEUbddK6KWRHkIDT9OHpmrp4VB2dfvwVPP3YphSLs+f6dmKt0TnHj54SXju" +
       "sbOlW7qAMlYen9GxdXe9PyZe+IZz3+/vTvuNQ+N/x/FbNNL2XL3wmofP9seb" +
       "Te/q0T8lwMPdmUi/ukdaDnYiwp415Se19odv8Qwqimfiyh1qgWvPxi3I4V2l" +
       "pDkuyuqHbtGkeJF3DvB5aWXawOMR3Jmv97aeqR0b0f1v1ojaQGS/c2BEX/4u" +
       "GdEpQRxLA7+FNMiieB/wIIfSGIal1NvHzL//LfAg5z+zb3v+p7/XzPO3YF4o" +
       "CupIFcrzbSc5p18P57u4ct+NxwqKE9AP3vA3pv1fb9SXXrh86YEXpv9hf1ri" +
       "8O8xd3IAUGLbJw83nri/4If6yiylcuf+qKNfMjOLKz/4Go8/AI4Pbws2zk33" +
       "PSzjyqO37uHwlNTJVj8aVx68Wau4chsoT1JfAw7mLGpACcqTlEpcuXKaEoxf" +
       "fp+kA6DuOqYDbnB/c5LEAL0DkuLW9A/93Gs+XY4rURzKagxmc3fu+jXBoaZU" +
       "7ns1TTmxjHjyuuS//CfcYaKe7P8Ld039wgvM4COvtH9+/88E1ZbzvOjlEle5" +
       "uP+TxFGy//hNezvs6wL19Hfu+eKd7zlcmNyzB3xseCewvfvsvwF0HT8uD+7n" +
       "//yBX33fL7zw1fK0xf8HZ2rJUqI4AAA=");
}
