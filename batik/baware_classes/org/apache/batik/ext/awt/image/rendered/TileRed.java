package org.apache.batik.ext.awt.image.rendered;
public class TileRed extends org.apache.batik.ext.awt.image.rendered.AbstractRed implements org.apache.batik.ext.awt.image.rendered.TileGenerator {
    static final java.awt.geom.AffineTransform IDENTITY = new java.awt.geom.AffineTransform(
      );
    java.awt.Rectangle tiledRegion;
    int xStep;
    int yStep;
    org.apache.batik.ext.awt.image.rendered.TileStore tiles;
    private java.awt.RenderingHints hints;
    final boolean is_INT_PACK;
    java.awt.image.RenderedImage tile = null;
    java.awt.image.WritableRaster raster = null;
    public TileRed(java.awt.image.RenderedImage tile, java.awt.Rectangle tiledRegion) {
        this(
          tile,
          tiledRegion,
          tile.
            getWidth(
              ),
          tile.
            getHeight(
              ),
          null);
    }
    public TileRed(java.awt.image.RenderedImage tile, java.awt.Rectangle tiledRegion,
                   java.awt.RenderingHints hints) {
        this(
          tile,
          tiledRegion,
          tile.
            getWidth(
              ),
          tile.
            getHeight(
              ),
          hints);
    }
    public TileRed(java.awt.image.RenderedImage tile,
                   java.awt.Rectangle tiledRegion,
                   int xStep,
                   int yStep) { this(tile, tiledRegion,
                                     xStep,
                                     yStep,
                                     null); }
    public TileRed(java.awt.image.RenderedImage tile,
                   java.awt.Rectangle tiledRegion,
                   int xStep,
                   int yStep,
                   java.awt.RenderingHints hints) {
        super(
          );
        if (tiledRegion ==
              null) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        if (tile ==
              null) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        this.
          tiledRegion =
          tiledRegion;
        this.
          xStep =
          xStep;
        this.
          yStep =
          yStep;
        this.
          hints =
          hints;
        java.awt.image.SampleModel sm =
          fixSampleModel(
            tile,
            xStep,
            yStep,
            tiledRegion.
              width,
            tiledRegion.
              height);
        java.awt.image.ColorModel cm =
          tile.
          getColorModel(
            );
        double smSz =
          org.apache.batik.ext.awt.image.rendered.AbstractTiledRed.
          getDefaultTileSize(
            );
        smSz =
          smSz *
            smSz;
        double stepSz =
          xStep *
          (double)
            yStep;
        if (16.1 *
              smSz >
              stepSz) {
            int xSz =
              xStep;
            int ySz =
              yStep;
            if (4 *
                  stepSz <=
                  smSz) {
                int mult =
                  (int)
                    java.lang.Math.
                    ceil(
                      java.lang.Math.
                        sqrt(
                          smSz /
                            stepSz));
                xSz *=
                  mult;
                ySz *=
                  mult;
            }
            sm =
              sm.
                createCompatibleSampleModel(
                  xSz,
                  ySz);
            raster =
              java.awt.image.Raster.
                createWritableRaster(
                  sm,
                  new java.awt.Point(
                    tile.
                      getMinX(
                        ),
                    tile.
                      getMinY(
                        )));
        }
        is_INT_PACK =
          org.apache.batik.ext.awt.image.GraphicsUtil.
            is_INT_PACK_Data(
              sm,
              false);
        init(
          (org.apache.batik.ext.awt.image.rendered.CachableRed)
            null,
          tiledRegion,
          cm,
          sm,
          tile.
            getMinX(
              ),
          tile.
            getMinY(
              ),
          null);
        if (raster !=
              null) {
            java.awt.image.WritableRaster fromRaster =
              raster.
              createWritableChild(
                tile.
                  getMinX(
                    ),
                tile.
                  getMinY(
                    ),
                xStep,
                yStep,
                tile.
                  getMinX(
                    ),
                tile.
                  getMinY(
                    ),
                null);
            fillRasterFrom(
              fromRaster,
              tile);
            fillOutRaster(
              raster);
        }
        else {
            this.
              tile =
              new org.apache.batik.ext.awt.image.rendered.TileCacheRed(
                org.apache.batik.ext.awt.image.GraphicsUtil.
                  wrap(
                    tile));
        }
    }
    public java.awt.image.WritableRaster copyData(java.awt.image.WritableRaster wr) {
        int xOff =
          (int)
            java.lang.Math.
            floor(
              wr.
                getMinX(
                  ) /
                xStep) *
          xStep;
        int yOff =
          (int)
            java.lang.Math.
            floor(
              wr.
                getMinY(
                  ) /
                yStep) *
          yStep;
        int x0 =
          wr.
          getMinX(
            ) -
          xOff;
        int y0 =
          wr.
          getMinY(
            ) -
          yOff;
        int tx0 =
          getXTile(
            x0);
        int ty0 =
          getYTile(
            y0);
        int tx1 =
          getXTile(
            x0 +
              wr.
              getWidth(
                ) -
              1);
        int ty1 =
          getYTile(
            y0 +
              wr.
              getHeight(
                ) -
              1);
        for (int y =
               ty0;
             y <=
               ty1;
             y++)
            for (int x =
                   tx0;
                 x <=
                   tx1;
                 x++) {
                java.awt.image.Raster r =
                  getTile(
                    x,
                    y);
                r =
                  r.
                    createChild(
                      r.
                        getMinX(
                          ),
                      r.
                        getMinY(
                          ),
                      r.
                        getWidth(
                          ),
                      r.
                        getHeight(
                          ),
                      r.
                        getMinX(
                          ) +
                        xOff,
                      r.
                        getMinY(
                          ) +
                        yOff,
                      null);
                if (is_INT_PACK)
                    org.apache.batik.ext.awt.image.GraphicsUtil.
                      copyData_INT_PACK(
                        r,
                        wr);
                else
                    org.apache.batik.ext.awt.image.GraphicsUtil.
                      copyData_FALLBACK(
                        r,
                        wr);
            }
        return wr;
    }
    public java.awt.image.Raster getTile(int x,
                                         int y) {
        if (raster !=
              null) {
            int tx =
              tileGridXOff +
              x *
              tileWidth;
            int ty =
              tileGridYOff +
              y *
              tileHeight;
            return raster.
              createTranslatedChild(
                tx,
                ty);
        }
        return genTile(
                 x,
                 y);
    }
    public java.awt.image.Raster genTile(int x,
                                         int y) {
        int tx =
          tileGridXOff +
          x *
          tileWidth;
        int ty =
          tileGridYOff +
          y *
          tileHeight;
        if (raster !=
              null) {
            return raster.
              createTranslatedChild(
                tx,
                ty);
        }
        java.awt.Point pt =
          new java.awt.Point(
          tx,
          ty);
        java.awt.image.WritableRaster wr =
          java.awt.image.Raster.
          createWritableRaster(
            sm,
            pt);
        fillRasterFrom(
          wr,
          tile);
        return wr;
    }
    public java.awt.image.WritableRaster fillRasterFrom(java.awt.image.WritableRaster wr,
                                                        java.awt.image.RenderedImage src) {
        java.awt.image.ColorModel cm =
          getColorModel(
            );
        java.awt.image.BufferedImage bi =
          new java.awt.image.BufferedImage(
          cm,
          wr.
            createWritableTranslatedChild(
              0,
              0),
          cm.
            isAlphaPremultiplied(
              ),
          null);
        java.awt.Graphics2D g =
          org.apache.batik.ext.awt.image.GraphicsUtil.
          createGraphics(
            bi,
            hints);
        int minX =
          wr.
          getMinX(
            );
        int minY =
          wr.
          getMinY(
            );
        int maxX =
          wr.
          getWidth(
            );
        int maxY =
          wr.
          getHeight(
            );
        g.
          setComposite(
            java.awt.AlphaComposite.
              Clear);
        g.
          setColor(
            new java.awt.Color(
              0,
              0,
              0,
              0));
        g.
          fillRect(
            0,
            0,
            maxX,
            maxY);
        g.
          setComposite(
            java.awt.AlphaComposite.
              SrcOver);
        g.
          translate(
            -minX,
            -minY);
        int x1 =
          src.
          getMinX(
            ) +
          src.
          getWidth(
            ) -
          1;
        int y1 =
          src.
          getMinY(
            ) +
          src.
          getHeight(
            ) -
          1;
        int tileTx =
          (int)
            java.lang.Math.
            ceil(
              (minX -
                 x1) /
                xStep) *
          xStep;
        int tileTy =
          (int)
            java.lang.Math.
            ceil(
              (minY -
                 y1) /
                yStep) *
          yStep;
        g.
          translate(
            tileTx,
            tileTy);
        int curX =
          tileTx -
          wr.
          getMinX(
            ) +
          src.
          getMinX(
            );
        int curY =
          tileTy -
          wr.
          getMinY(
            ) +
          src.
          getMinY(
            );
        minX =
          curX;
        while (curY <
                 maxY) {
            if (org.apache.batik.util.HaltingThread.
                  hasBeenHalted(
                    ))
                return wr;
            while (curX <
                     maxX) {
                org.apache.batik.ext.awt.image.GraphicsUtil.
                  drawImage(
                    g,
                    src);
                curX +=
                  xStep;
                g.
                  translate(
                    xStep,
                    0);
            }
            curY +=
              yStep;
            g.
              translate(
                minX -
                  curX,
                yStep);
            curX =
              minX;
        }
        return wr;
    }
    protected void fillOutRaster(java.awt.image.WritableRaster wr) {
        if (is_INT_PACK)
            fillOutRaster_INT_PACK(
              wr);
        else
            fillOutRaster_FALLBACK(
              wr);
    }
    protected void fillOutRaster_INT_PACK(java.awt.image.WritableRaster wr) {
        int x0 =
          wr.
          getMinX(
            );
        int y0 =
          wr.
          getMinY(
            );
        int width =
          wr.
          getWidth(
            );
        int height =
          wr.
          getHeight(
            );
        java.awt.image.SinglePixelPackedSampleModel sppsm;
        sppsm =
          (java.awt.image.SinglePixelPackedSampleModel)
            wr.
            getSampleModel(
              );
        final int scanStride =
          sppsm.
          getScanlineStride(
            );
        java.awt.image.DataBufferInt db =
          (java.awt.image.DataBufferInt)
            wr.
            getDataBuffer(
              );
        final int[] pixels =
          db.
          getBankData(
            )[0];
        final int base =
          db.
          getOffset(
            ) +
          sppsm.
          getOffset(
            x0 -
              wr.
              getSampleModelTranslateX(
                ),
            y0 -
              wr.
              getSampleModelTranslateY(
                ));
        int step =
          xStep;
        for (int x =
               xStep;
             x <
               width;
             x +=
               step,
               step *=
                 2) {
            int w =
              step;
            if (x +
                  w >
                  width)
                w =
                  width -
                    x;
            if (w >=
                  128) {
                int srcSP =
                  base;
                int dstSP =
                  base +
                  x;
                for (int y =
                       0;
                     y <
                       yStep;
                     y++) {
                    java.lang.System.
                      arraycopy(
                        pixels,
                        srcSP,
                        pixels,
                        dstSP,
                        w);
                    srcSP +=
                      scanStride;
                    dstSP +=
                      scanStride;
                }
            }
            else {
                int srcSP =
                  base;
                int dstSP =
                  base +
                  x;
                for (int y =
                       0;
                     y <
                       yStep;
                     y++) {
                    int end =
                      srcSP;
                    srcSP +=
                      w -
                        1;
                    dstSP +=
                      w -
                        1;
                    while (srcSP >=
                             end)
                        pixels[dstSP--] =
                          pixels[srcSP--];
                    srcSP +=
                      scanStride +
                        1;
                    dstSP +=
                      scanStride +
                        1;
                }
            }
        }
        step =
          yStep;
        for (int y =
               yStep;
             y <
               height;
             y +=
               step,
               step *=
                 2) {
            int h =
              step;
            if (y +
                  h >
                  height)
                h =
                  height -
                    y;
            int dstSP =
              base +
              y *
              scanStride;
            java.lang.System.
              arraycopy(
                pixels,
                base,
                pixels,
                dstSP,
                h *
                  scanStride);
        }
    }
    protected void fillOutRaster_FALLBACK(java.awt.image.WritableRaster wr) {
        int width =
          wr.
          getWidth(
            );
        int height =
          wr.
          getHeight(
            );
        java.lang.Object data =
          null;
        int step =
          xStep;
        for (int x =
               xStep;
             x <
               width;
             x +=
               step,
               step *=
                 4) {
            int w =
              step;
            if (x +
                  w >
                  width)
                w =
                  width -
                    x;
            data =
              wr.
                getDataElements(
                  0,
                  0,
                  w,
                  yStep,
                  data);
            wr.
              setDataElements(
                x,
                0,
                w,
                yStep,
                data);
            x +=
              w;
            if (x >=
                  width)
                break;
            if (x +
                  w >
                  width)
                w =
                  width -
                    x;
            wr.
              setDataElements(
                x,
                0,
                w,
                yStep,
                data);
            x +=
              w;
            if (x >=
                  width)
                break;
            if (x +
                  w >
                  width)
                w =
                  width -
                    x;
            wr.
              setDataElements(
                x,
                0,
                w,
                yStep,
                data);
        }
        step =
          yStep;
        for (int y =
               yStep;
             y <
               height;
             y +=
               step,
               step *=
                 4) {
            int h =
              step;
            if (y +
                  h >
                  height)
                h =
                  height -
                    y;
            data =
              wr.
                getDataElements(
                  0,
                  0,
                  width,
                  h,
                  data);
            wr.
              setDataElements(
                0,
                y,
                width,
                h,
                data);
            y +=
              h;
            if (h >=
                  height)
                break;
            if (y +
                  h >
                  height)
                h =
                  height -
                    y;
            wr.
              setDataElements(
                0,
                y,
                width,
                h,
                data);
            y +=
              h;
            if (h >=
                  height)
                break;
            if (y +
                  h >
                  height)
                h =
                  height -
                    y;
            wr.
              setDataElements(
                0,
                y,
                width,
                h,
                data);
            y +=
              h;
        }
    }
    protected static java.awt.image.SampleModel fixSampleModel(java.awt.image.RenderedImage src,
                                                               int stepX,
                                                               int stepY,
                                                               int width,
                                                               int height) {
        int defSz =
          org.apache.batik.ext.awt.image.rendered.AbstractTiledRed.
          getDefaultTileSize(
            );
        java.awt.image.SampleModel sm =
          src.
          getSampleModel(
            );
        int w =
          sm.
          getWidth(
            );
        if (w <
              defSz)
            w =
              defSz;
        if (w >
              stepX)
            w =
              stepX;
        int h =
          sm.
          getHeight(
            );
        if (h <
              defSz)
            h =
              defSz;
        if (h >
              stepY)
            h =
              stepY;
        return sm.
          createCompatibleSampleModel(
            w,
            h);
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
       "/vzjvVFxofD0jO0rn/q9x9mX9Jfv4HLS");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("Uwc4D4v8h6PXf73/IelvXijddXLidtNVxxszvXDjOduVUImT0GVvOG174qRf" +
       "Hj8+N/jpfb/89OEW82nP33pz/sM7zTk4bj06FfhyIfCN25zH/l4e/de4dFny" +
       "/KwjxmKR7VTbfveOz6W/fkIwP5IuvQ+EX94T/OV3huD+Kk7+c3f0XEj9r9uw" +
       "/E4e/c+4dI+mxLnCHmv5w4e3eE736gv233on2H9lz/4rf4bsjy6cz/6ouNDx" +
       "RwV7l90fjfzBKck/fhskCx3+MAhf3ZP86jtO8st5VC6I3H8bklfz6N64dL9q" +
       "2PauH3uh59yozkdX3gbX/My0VAOwn9vl3X2/Va7AzvmhFytSrMhvadgefc9t" +
       "2D6RR0CB352znSTxGcU9PMRYe4Z82gCPvN0GeBFg/Ni+AT52h5199L63xvz5" +
       "2zD/aB49F5ceuYH5ydFk/vapU7ofeiforvZ0V39GdBu3odvMo8pNdHsYRbVv" +
       "plt9G3Tzw87cNTh6dU/31Tuge6Ggm/+Ob8n58N4QcxAVXG9zo+6ok0cfL4Z3" +
       "yoiObysjT957DA/nJ3s3GvJDkaJ17ugWXgrs5f5ydX5T9LGb/s2x+weC9POv" +
       "PXD50de4/1DcLz75l8C9VOmymtj22Vs3Z54v+aECiBSSuzs4fsFyFJe+9y06" +
       "XmDKPn7MsR9RuxKmcenJ25cQly4ax5dUj3Mxcemx83LFpbtAfFYaWJX33koa" +
       "SIL4rOQyLl09lAT1F99n5X4gLl05lYtLl3YPZ0Wug9KBSP74sn/c7bW36qVi" +
       "qygORSkGvZkenXEz96OgmAcfejP1OMly9gZ1XmHxh6BjNzLZ/SXouvSl14bj" +
       "T3678TO7G9ySLW63eSmXqdI9u8vkJ67o0+eWdlzWpcFHvnv/L9z73LHbfP8O" +
       "8OmIPIPtqVtfl+46flxccN7+00f/yYt//7XfKU7T/x+wacJqqTUAAA==");
}
