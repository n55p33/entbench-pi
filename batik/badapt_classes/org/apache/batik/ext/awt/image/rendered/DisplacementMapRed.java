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
        public static final long jlc$SourceLastModified$jl7 = 1471028785000L;
        public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1YC2wU1xV9u/6w/n/4OYAN2IaIT3dKfiQ1IQFjg8kaHEyQ" +
                                                                  "snyW2dm33sGzM8PMW3vthHyQWmilIkoJIVGwKoUEgvhEUaO2apM6ikoSJY0U" +
                                                                  "QpqmUaA/tbQUFVQ1rUrb9L73ZnY+u2uaqu1K+3b2zX333fvuvefe+05eQWWm" +
                                                                  "gVqwSsJkRMdmuEslfaJh4kSnIprmRpiLSU+WiH/admndXUFUHkW1KdHslUQT" +
                                                                  "d8tYSZhR1CyrJhFVCZvrME7QFX0GNrExJBJZU6Noqmz2pHVFlmTSqyUwJdgk" +
                                                                  "GhHUIBJiyPEMwT0WA4KaIyCJwCQRVvhfd0RQtaTpIw55k4u80/WGUqadvUyC" +
                                                                  "6iM7xCFRyBBZESKySTqyBlqka8rIgKKRMM6S8A7ldusI1kZuzzuC1hfrPr2+" +
                                                                  "P1XPjmCyqKoaYeqZG7CpKUM4EUF1zmyXgtPmTvQIKomgKhcxQe0Re1MBNhVg" +
                                                                  "U1tbhwqkr8FqJt2pMXWIzalcl6hABM31MtFFQ0xbbPqYzMAhRCzd2WLQdk5O" +
                                                                  "W65lnopPLBIOPrmt/qUSVBdFdbLaT8WRQAgCm0ThQHE6jg1zRSKBE1HUoIKx" +
                                                                  "+7Ehi4o8alm60ZQHVJFkwPz2sdDJjI4NtqdzVmBH0M3ISEQzcuolmUNZ/8qS" +
                                                                  "ijgAuk5zdOUadtN5ULBSBsGMpAh+Zy0pHZTVBEGz/StyOrbfBwSwdFIak5SW" +
                                                                  "26pUFWECNXIXUUR1QOgH11MHgLRMAwc0CJpRlCk9a12UBsUBHKMe6aPr46+A" +
                                                                  "qoIdBF1C0FQ/GeMEVprhs5LLPlfWLdv3kLpGDaIAyJzAkkLlr4JFLb5FG3AS" +
                                                                  "GxjigC+sXhg5JE57ZW8QISCe6iPmNN95+Nq9i1vG3+Q0MwvQrI/vwBKJSUfj" +
                                                                  "te/N6lxwVwkVI6RrpkyN79GcRVmf9aYjqwPCTMtxpC/D9svxDWcffOwEvhxE" +
                                                                  "lT2oXNKUTBr8qEHS0rqsYGM1VrEhEpzoQRVYTXSy9z1oEjxHZBXz2fXJpIlJ" +
                                                                  "DypV2FS5xv7DESWBBT2iSniW1aRmP+siSbHnrI4QqoIvqofvFsQ/7JegtJDS" +
                                                                  "0lgQJVGVVU3oMzSqvykA4sThbFNCHLx+UDC1jAEuKGjGgCCCH6Sw9YJGpjhM" +
                                                                  "BDkN5hfAHAmwSUJYJZu6Ak6bBj69or4BJ8LU7fT/94ZZegKThwMBMM4sPzRQ" +
                                                                  "+jWaAgxi0sHMyq5rp2Nvc7ejoWKdHUHdIEOYyxBmMjAgBRnCTIawLUM4X4b2" +
                                                                  "jWAcbjkTBQJMjClULu4fYN1BwAkA6uoF/VvXbt/bWgKOqQ+XgmkoaasnYXU6" +
                                                                  "YGJngJh0prFmdO6FJa8HUWkENYoSyYgKzT8rjAFANmnQCv7qOKQyJ6PMcWUU" +
                                                                  "mgoNTcIJALRimcXiEtKGsEHnCZri4mDnOxrZQvFsU1B+NH54+PFNj34xiILe" +
                                                                  "JEK3LAP8o8v7KPTnIL7dDx6F+NbtufTpmUO7NAdGPFnJTqZ5K6kOrX5H8R9P" +
                                                                  "TFo4R3w59squdnbsFQDzRISwBARt8e/hQakOG/GpLiFQOKkZaVGhr+wzriQp" +
                                                                  "Qxt2ZpgHN7DnKeAWIRq2k+Ebs+KY/dK303Q6TuceT/3MpwXLKHf360d++u7v" +
                                                                  "bmXHbSefOlfV0I9JhwvwKLNGBm0NjttuNDAGuk8O933ziSt7NjOfBYq2Qhu2" +
                                                                  "07ETgA5MCMf85Td3fnTxwtHzwZyfo6xXt9AEusEm8x0xACcVgA7qLO0PqOCW" +
                                                                  "clIW4wqm8fT3unlLXv7DvnpufgVmbO9ZfGMGzvxNK9Fjb2/7SwtjE5BonnaO" +
                                                                  "yiHj4D/Z4bzCMMQRKkf28XPNT70hHoE0AtBtyqOYoXGIqR7yhjgNo/5M3IRw" +
                                                                  "lNNw+kNWYrulb7u0t73v1zxp3VRgAaebelz4+qYPd7zDbBuiAU/nqd41rnAG" +
                                                                  "YHA5Vj0//M/gE4DvP+mXHjqd4AmisdPKUnNyaUrXsyD5ggnqSq8Cwq7Gi4PP" +
                                                                  "XDrFFfCncR8x3nvwa5+F9x3kluO1TlteueFew+sdrg4d7qTSzZ1oF7ai+7dn" +
                                                                  "dn3/+K49XKpGb+bugsL01E/+8U748M/fKpASSmSrXr2VInUOr6d4bcMVWvXV" +
                                                                  "uh/sbyzpBqjoQaGMKu/M4J6EmyOUamYm7jKWU0OxCbdq1DAEBRaCDejE0okH" +
                                                                  "RnMbk1TIyYusuKP/V9NhnukGVa81XQV7TNp//mrNpquvXmMn4q343RgCuY+b" +
                                                                  "o4EO86k5pvuT3hrRTAHdbePrttQr49eBYxQ4SpDyzfUGpNOsB3Es6rJJP3vt" +
                                                                  "9Wnb3ytBwW5UqWhioltk4I0qADWxmYJkntXvuZejx3DIKnlQFuUpnzdBI3h2" +
                                                                  "YWzoSuuERfPod6d/e9mxsQsMvXTOYyZbH6T1hSdbs77RSRgn3l/6wbFvHBrm" +
                                                                  "3jZB7PjWNf1tvRLf/cu/5h05y48Fwsm3PiqcfGZG5/LLbL2TqOjq9mx+TQTJ" +
                                                                  "3ll7y4n0n4Ot5T8KoklRVC9ZfdomUclQ+I9Cb2LazRv0cp733j6DF9UduUQ8" +
                                                                  "yx/Prm39KdIdJqXEExK+rEgftlqZY6s/KwYQe3iQLbmZDovy806x1QR2Bgj0" +
                                                                  "XiHk0JeBPY/1LVVnf2g++5uXuJULYbuvaTl+LCR9nD7LsJ1udUdOqFoqQwN8" +
                                                                  "LW/mvwRt/i/VzwNYS0PbRlJQyA2QlF2e/y/ZUyCYV9zzXec49nzbu4+Otf2C" +
                                                                  "wUJINsE/IG8VaBxda66evHj5XE3zaVaSldL0Z6Gpt+POb6g9fTKzQh0deO+w" +
                                                                  "NA/m6f9+TmA5VYo7FRsX0uELHBMIKtczcUWGuqEsKauiwjjeCdMKOxT67246" +
                                                                  "JHUHj4IWntD/TcQqKmgUQZOsqZjWJ/Y73knIWjh3QQEvswXyUrMHmXqZuk6Y" +
                                                                  "f1J74Fffax9Y+XlaCDrXcoMmgf6fDTZbWNzkflHe2P37GRuXp7Z/jm5gts8j" +
                                                                  "/Cxf6D351ur50oEguwPh+JN3d+Jd1OFFnUoDk4yhetNxm+MiycLmD9DHQW7y" +
                                                                  "CTLwwxO8e4QOWfAeiZqee8oE5I/nJzU6cb/uyn8BR7ZVVqtAxzV0iHLfua9o" +
                                                                  "Au3Pb0O2Wei0rQjgfmVCwC22GiosLZmkj9t9Mu6ZQMZsEUNAwJnsls9pNdjx" +
                                                                  "VCLfdYi71XByO6K41VzsxorVkkd3HxxLrH9uiQ3j98CW1kWimw9BVa4LATuM" +
                                                                  "v/Sf3y+AYE15F578kk46PVYXmj72wIccD+2LtGoI0GRGUdxZ1fVcrhs4KTMd" +
                                                                  "qnmO5XXm0wTd/G+KSVDIfmQaPsU5HIHeeGIO4Ofs173qWwQ1FVsFTgKjm/pZ" +
                                                                  "wMRC1EAJo5vyeYLq/ZSwP/t1071AUKVDB1blD26Sk9RZjQH6eEq3bVrvwDYv" +
                                                                  "frIBr0flHHrqjYLO5YRtHiRlF+I26mX4lXhMOjO2dt1D1+54jnf4kiKOjlIu" +
                                                                  "VZDn+GVDDjnnFuVm8ypfs+B67YsV82y3buACOyE504U+90Ok6bSKnuHrg832" +
                                                                  "XDv80dFlr/54b/k5yOubUUCE9LY5v0zM6hmIt82R/GYKsgxr0DsWPD2yfHHy" +
                                                                  "jx+zQtxKcrOK08ek88e2vn+g6Sg08lU94GbgnllWv64aUTdgaciIohrZ7MqC" +
                                                                  "iMAFcqmnU6ulwSPSq3J2LtZx1uRm6f0QQa35TWr+rRo0LcPYWKll1IRVnVQ5" +
                                                                  "M56bejv5ZHTdt8CZcZUsnSzPZHmNWBKL9Oq63cNXfKAzTFtVPAmMs0c6vPYv" +
                                                                  "dDFZsiwbAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "kZ+s/R9ILuMt9SUAAA==");
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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Xvd1aChtdabZwBggc6cd+VYTaZGmuyy3");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("+nrKA/MiC3bGxv6yJTEyx4WCz03G/TpKNMZ6bLWclTpLSAjWBSTUBMnWnUFW" +
       "Nee+2m67jWazL5ANMOZ78VjgsQ1MuezQl5oL3Ff9rBv50/liOax1moo1NuL+" +
       "2mSCST+uJlo03mbOsk4nyXary2MfhCR1euFGtTFcZgSLkHWzFaIo+oF8Cewr" +
       "b2xp7sFiFfLwROTaKrbWXn0Dq2+7V0/lybOH67TF71zpxCm6Y+u0xzbmS/nR" +
       "gcdvd9CxOEjx+Y+/+JJG/1xlb38B93pUui9yvR+29I1uHavqPKjp+dsvwFPF" +
       "OvjRRvuvf/xPH+U/uPrwGzgS9t4TOE9W+U+pl38T+wH17++V7jncdr/lBOrN" +
       "ha7fvNl+MdCjGDjHm7bcHz+U7KO5xJ4G1yv7kn3l5Ar4Ud+dvk34Q7u+P3Fe" +
       "5Mz+wbr91efHD8+a7Fb3xcCIimNAchjpQVHDf7/DiZM/zZM/jEoXVNdLe3Ik" +
       "589/fKRQf3S35dzjFRYZXz2UwJU8M99E+uV9Cfzy2yOBvYJgL38strheLKj+" +
       "9x24/Fae/FlUOr/Uo3yL40B47zkhvJ3Qjrj/5lvg/uGD/v/KPvdfeVv7/5Dx" +
       "M3u3Z/zM2TzzL6LSOwDjs2MbKV884vEv3w4eX9vn8bXvEo8P3IHHy3ly347H" +
       "+ak8nrn4FngsjlfWAJp378qeufL28HiuIDiXP377aNC9fNhucdLgUql0drxr" +
       "d/cfldS3eNxY9rwQDjdLJXC3oR7AY1fTGUM19YCRHd06ONX8vWimkMuLp1q2" +
       "fJfozGP7m4RnnjxduoUJKHzl0RkdS3eWu2PiuW048/1ectJuHAz+dx3tonUt" +
       "19Fzq3nwbne82XCvHX4pAV4mpyL96g5p0dgxD3talx/X2h++wzs4T56PSveq" +
       "Oa4dG3cgryalguYoKbIfvUORfCPvDODzwsKwgMXrjE7d3tu4hnY0iB56q4MI" +
       "ASL77f1B9OXv0iA6IYgjaaB3kEY3T94PLMiBNJigkDpyxPwH3gYLsveZXdm9" +
       "n/peM0/dgXk6T/BDVSjOtx3nfPhGOE+i0pVbjxXkJ6AfueUzpt2nN+orL126" +
       "8PBL0/+4Oy1x8HnMfSMAKLas44cbj92f8wJ9YRRSuW931NErmBGi0g++zuMP" +
       "gOOD25yNM9NdDfOo9MSdazg4JXW81I9FpUduVyoq3QPS49Q3gIE5jRpQgvQ4" +
       "pRKVLp+kBO0X/8fpAKiLR3TADO5ujpOsQO2AJL81vAM797pPl6NKGAWyGoHe" +
       "TM7cPCc40JTSlbtpyrFpxDM3Bf/Fl3AHgXq8+xbuhvqFl4jxR15Dfm73ZYJq" +
       "yVmW13JhVDq/+0jiMNh/6ra1HdR1Dn/uOw988b5nDyYmD+wAHw28Y9jee/pn" +
       "AH3bi4qD+9m/ePhX3v/zL321OG3x/wHolAN/ojgAAA==");
}
