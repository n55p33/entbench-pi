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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL17C8wjx30fv5PudDrL0km2HlYsyZIlx9bat3zvMpLVcJfk" +
       "cl/kkrtckps0p+W+yX0/yOU6ah0Xrd0EcN1WTp0iEdLCQdtUiYO0gRsEKVT0" +
       "4QQJiqYIWrdAY6MNUDepERto3aDOo7NLfo/j3XfSRUo/fDNczv5n5veb+c9/" +
       "/vPg698sXYzCEuR79tawvfialsbXlnbjWrz1tegaxTQ4OYw0FbflKBJA2nXl" +
       "mV944Dvf/Zx59ULpklR6j+y6XizHludGYy3y7LWmMqUHTlO7tuZEcekqs5TX" +
       "MpzElg0zVhS/wJTedSZrXHqWOYYAAwgwgAAXEOD2qRTI9G7NTRw8zyG7cRSU" +
       "/lLpiCld8pUcXlx6+sZCfDmUnX0xXMEAlHA5/y4CUkXmNCx94IT7jvNNhD8P" +
       "wa/+nR+6+ot3lR6QSg9YLp/DUQCIGFQile5zNGehhVFbVTVVKj3oaprKa6El" +
       "21ZW4JZKD0WW4cpxEmonjZQnJr4WFnWettx9Ss4tTJTYC0/o6ZZmq8ffLuq2" +
       "bACuj5xy3THs5emA4BULAAt1WdGOs9y9slw1Lj11mOOE47M0EABZ73G02PRO" +
       "qrrblUFC6aFd39mya8B8HFquAUQvegmoJS49fm6heVv7srKSDe16XHrsUI7b" +
       "vQJS9xYNkWeJSw8fihUlgV56/KCXzvTPNwcvfvYTbt+9UGBWNcXO8V8GmZ48" +
       "yDTWdC3UXEXbZbzveebH5Ud+9TMXSiUg/PCB8E7myz/87e//6JNv/NpO5ntu" +
       "ITNcLDUlvq58cXH/b70f/0jrrhzGZd+LrLzzb2BeqD+3f/NC6oOR98hJifnL" +
       "a8cv3xj/m/knf1b7/QulK2TpkuLZiQP06EHFc3zL1kJCc7VQjjWVLN2ruSpe" +
       "vCdL94BnxnK1XepQ1yMtJkt320XSJa/4DppIB0XkTXQPeLZc3Tt+9uXYLJ5T" +
       "v1Qq3QNCqQ0CXNr9FZ9xaQGbnqPBsiK7luvBXOjl/CNYc+MFaFsTXgCtX8GR" +
       "l4RABWEvNGAZ6IGp7V/kI1PexLDlgO6HQXeooE9UWACgxpp6Ldc1//9LLWnO" +
       "9erm6Ah0w/sPjYANxk/fs0Gu68qrCdb99s9f/40LJ4Ni30pxKa/42q7ia0XF" +
       "hQEFFV8rKr52XPG1fcWlo6OivvfmAHZdDjpsBYY+MIr3fYT/i9TLn3nmLqBr" +
       "/uZu0Np3A1H4fNuMnxoLsjCJCtDY0htf2PyI+JfLF0oXbjSyOWiQdCXPzuWm" +
       "8cQEPns4uG5V7gOf/sZ3vvTjr3inw+wGq70f/TfnzEfvM4fNG3qKpgJ7eFr8" +
       "8x+Qf+n6r77y7IXS3cAkADMYy0BtgYV58rCOG0bxC8cWMedyERDWvdCR7fzV" +
       "sRm7EpuhtzlNKfr9/uL5QdDG78rV+iEQiL2eF5/52/f4efzenZ7knXbAorC4" +
       "H+f9n/rqv/0ftaK5j43zA2emO16LXzhjEPLCHiiG/oOnOiCEmgbk/ssXuL/9" +
       "+W9++gcKBQASH7xVhc/mMQ4MAehC0Mx/9deC//S13/nib184UZqjGMyIycK2" +
       "lPSEZJ5eunIbkqC2D53iAQbFBsMt15pnJ67jqZZuyQtby7X0jx54rvJL//Oz" +
       "V3d6YIOUYzX66JsXcJr+Pqz0yd/4of/zZFHMkZJPaKdtdiq2s5LvOS25HYby" +
       "NseR/si/f+InviL/FLC3wMZFVqYVZutC0QYXCuYPx6X3FzlPB+R4PyDJ/Nux" +
       "0EMnQmNQK5jnbK3odLgQeL6Ir+UNVpRdKt418uip6OzguXF8nnFcriuf++1v" +
       "vVv81j//dsH2Rs/nrK6wsv/CTj3z6AMpKP7RQ0vRlyMTyNXfGPzgVfuN74IS" +
       "JVCiAqxgNAwBt/QGzdpLX7znP/+Lf/nIy791V+lCr3TF9mS1JxeDtHQvGB1a" +
       "ZAJTl/p/4ft3yrG5DKKrBdXSTeSLhMdvHj7MXrOYWw+fPH46j567WSnPy3rQ" +
       "/HcVCO7Kv5bzqHrcf4+e6b+8e4GL0gdeUFRUjd2mE3t59PHiVTOPXtqxa72t" +
       "hhjv2YzvvCHOy3pA4e7d5HCmIcLSR27jwoeWA2zPeu/2wK889LXVT37j53Yu" +
       "zaGPdCCsfebVH/3Ta5999cIZR/KDN/lyZ/PsnMmC7Lt3DP8U/B2B8Cd5yJnl" +
       "CTtn4iF879F84MSl8f1c7Z++Hayiit5//9Irv/IPX/n0jsZDN/pRXbBM+Ln/" +
       "8Me/ee0LX//1W0zbdwHtyL/wBczhbTTkB/KIOtUQ+p3QkNm+m2d3riHnZT2g" +
       "cLFAcPFUQwq2JxFe1KTehreeR9dPeb98J7x3so8V3+67vW728rXNqRfw2P8d" +
       "2otP/dc/vMlOFs7LLdT1IL8Ev/6Tj+Mv/X6R/9SLyHM/md7s5oF14Gne6s86" +
       "//vCM5f+9YXSPVLpqrJfZIqyneRzswQWVtHxyhMsRG94f+MiabcieOHES3r/" +
       "4Xg5U+2h/3Kqp+A5l86frxy4LHkoYSCU99pQPlSko1Lx4O90qYifzaPv3c2O" +
       "wEOIilVsDGq3XNkuKhDi0mWy0x0IpDA/Nq1PnJhWQ/Oca20diGtCKLtR7mid" +
       "6muhJMGbKcnqRoV+HITGnkLjHAqfuDWF0jHid4Hhrqljzdj7VtUDTD98h5ju" +
       "BwHZY0LOwfSpN8F0MeVjzT8ZbWfQ/JU/Axp0jwY9B81ffzM02/PQ/Ogdonkv" +
       "CN+3R/N956D53JuhyfsrOlavyp2sn3jgsGgHFP7mW6dwX576DAgv7im8eA6F" +
       "n7g1BeBX3+OH1hpMUidkTGu/DYUf4Pq7bx1XbtZLT4Lw0h7XS+fg+nvn4Mof" +
       "k5PxYEXXyYFwnWvjdCHJFS92cERAYeF5tia7B3j//h2qwtMg4Hu8+Dl4//Gb" +
       "qMLd8X4jonwA5vU/A5jOHkznHDC/+CZgLoVyFGvhzXZvp4jT0IrzBcy4kDrA" +
       "+0/eFO+uD46ACl2sXkOuFYR/5daICv/2w3kU39Cxjy5t5dljd0kESIHBe3Zp" +
       "I8eIrxaI8wno2m6X7gCk8JZBghn7/tPCGM81Xvix3/3cb/6ND34NTKtU6eI6" +
       "n/LAbHqmxkGS74H+tdc//8S7Xv36jxVrUaCY4ief+4NiR+lf3RnVx3OqfLG1" +
       "w4D2Zovlo6aesD1Q6btt722wjR/8o349ItvHf0xZXkw3SjqbJTBXa600dE3V" +
       "uoqMMRZfx0fGYNiu1+FufUotYp/lKYjYxpnqLhC6lrQcNUIhbEJaNE5N6bZp" +
       "kD1ZQPF2pTfqYaJIk1O77WOjLm638drIsttY18ZpkvCZydQxEbSW1BIkrkmN" +
       "pdlf81lSG67XurMW9LVcXVSjSYtayYSABcFGWsrORB42RlWiZTjIaEpFEcHO" +
       "263urAttgu66AsMTXRNHIonydNDHpsOQxqzypEltM8xY4VuhNydJaxIMF2XT" +
       "tFrDcOJxAbnBxyLBjzKKZkNPcXiaIWLZ21ibvoR1GmzTEHqqZc0lZEGSLEMa" +
       "HWrbHeKaKSZwaC9xv9cT46xN6MiIWitIBduSo8yOeuRiZq1ZnO6uVlt+VO1T" +
       "c7zsu3I2Evt2xPckiS1X00ZY2xKrqDdFqTCyhRFECINeBVUJGbFp33BoMqST" +
       "vkn0M3GizQViEwhEU6uOZIWZC9W6hU17fH1EOT5uR500wEcTdhPg1bi9mSli" +
       "pWs7U1NIhCXr23xkKcaIrEeZNbVwxhpFbFhVpCY22lqZNBQoMtkaccjbtu0t" +
       "a2HbGtRqagvhUYZny0YgERPdGfcxfD7vdEgSD6YUPZgOKrbFpoZEuSNaqE1a" +
       "FV4C/dyS2Eq65lc4vaG6WzgcLyKB8CeNKttMPKqBDdyyz5oTjq9oLpZMWuJo" +
       "Ytcn5qo/dchm5M95vWrUO3Z3iTvpZroZbhJboaBViplSkxXJbcssM6N2W145" +
       "eOR0K5zIm+Sq3Q8EdTDG5IkntmGHqm8xGuvRpmVkkanMmrQnl8uj1sbuDEhy" +
       "2pz3w4GIYiJmzzCa3LARy6SWizFsrZJRVKgvkXjmwv2O4jvUxMA3/SFrLZnt" +
       "bNMjO+PmijMDd2hMYBbrhnZdX/emc0jJTBJvdzi0jS9YBoJQfVOxM17RY6Lr" +
       "SErHt7SmXfci0mxyog+pNWQRbQ1q5VXGQme0crnyYIs401bFT8CYmY8lR5bJ" +
       "sBHFNqQhbmymaJUrryDcZ7ZMj0wCt7tt99UpJa9oQaL9tWeEIjaRljOZZ+mw" +
       "W4XDJmOzWGvao72qGgnLNJmoUg93gGoE8EYSsVG/G1iWElozmzGDWjXCCWhR" +
       "o+fl0cQgZ/J8Eo7ZjQ5XlRVh+tNuNlpZYPzQ08ATK+pYt9hul1foxCwPx0o/" +
       "aNUn7EB2Ovhcmui8sTKwMjuBop4WzDfbFcW3gzmMDdixkTmUOZLbgVCX5bK0" +
       "KMP1tdccjyqOszRGGLuppesu1cH0TA5ZB+ulXH+VekgmlMfawCizrsLwXYut" +
       "KwzbUDqs7pAqSzCW1GmlUREmG7wtIJpKCG23T8+jfs2ATAyhG3oFaTW3jRq2" +
       "bKuWPLA9smrVu2VWZvsDwUnbChJ09e4KFkUslfUpXFFWGE/wizJYrIyMedn3" +
       "K3PFmJIuwvShZNmlqorPdEngp22GWyfY0oPRPNvy6Xxqi1TFHIbzDDXLvc0E" +
       "MWUiM9cbge8i0FZzlh6iRjBEBGTbdhrGRIkMEycCpjZfjrkxVHYWWUaOF7oT" +
       "exA07LvrEejnDuZQadTkppLhjZrcjAyzwJovmd7G5sZSHQwvQZwZ8tjZuCBu" +
       "TwgkXUptXustE9Lbbm2yjymV8RBf0q2oL2nZXCyr6iyoB+oihSDb6Jkzz9LF" +
       "zWJBKSsYXlYbKzkOB2y5PEfQ8hJboUINQib9Ghy20oaaquq64bOSiHNjoZLQ" +
       "9HxiRe5KC4eRGmG1Md3WmqqHVGo1mPMXQtLIRkx3ZW86A6e/wMIu45udiT5M" +
       "GKjVAv9ZOqhT/nCDbvghA2zLGA8WwGx2YRrdGJRXqa3QNptOyDlpiAsh7pYx" +
       "qCFYKxMXaSGc6tVgGrpIsKjpE8edG6N6Kx77KiuwHd9FhuMal21beiuoEyOc" +
       "TCRjXFWGDubO/cyZTGuiSnRZaBJqaJx0IBalOyucNBhszbcVb7mQOiHJGraL" +
       "1kidRPyUakN0XSrXJXYgUijR9AZjUpgxdhduEkZzY4XazEPJ+kJh9HiKZ5V+" +
       "GxGaEpw4QWz1l6ulAoWxC0NIf5UspjKYA2QxnDPTue+5A1OzDW4TLWqdBYMt" +
       "O+2+3mhqDTXWGT+sdyyy156Qs/aCE0LSjoIN006awXDMrWtx0vCbGcYLc17x" +
       "bXFuVvA4pfixXceyKUEKgRvTyZqdV5YxxstTqx5sxyQUbFhXJvpJoLVImUy5" +
       "ike4ElwJ4Lm9bCCWKPtZ13A2XKe3JggFiQ3V1JZslV4w6+oInoHZt+8mo7Ye" +
       "opjjTst4VNk4BjbHTdV2Aq7Mcmtg5LWtgTXiIex4rYEfs5hYazGzKdUfVyE8" +
       "CTJ/uF2sSQaddKpWTwr8cjA1ljRPWfIKJoSJsZmsKItQluJarMkaqqEzTEA2" +
       "qiMJiovVSWoADcflLlRdI26tN67HfEb05kt0KA5FekVhwUwmmhVTcAjY6NU5" +
       "T2bSET5EN0EQIgM6mUz9adQQJpw7lSQXlSb+aGga8GKN9NdLTxHZ9qIJpkNZ" +
       "7qc1GBV0Vq1X5+QAU7o8QgXKUhsmvLFJlZ4zqNG14QD1+jSXbRpsX4c5cqPG" +
       "bJh4QPmi4ZQpt+BIh9cxhbZwdN2QLQe3xuFkrgvEsp21t3KaMWCamwbwWpNr" +
       "Y8hjhla/ofp93seZWGjRiUNFVkhorDQYVaZKAzdqWn2sDKk5z4Mpat4e1hap" +
       "ulK0PkSFy3a/byLSwB+1VClzcVXiaqTQmiyrZs+lulZa1+q9mBo4JFperRR9" +
       "PXDXzS4HM+uxufaX/SGabPgI9Ux9BVmV4YDTw2Z1CSkJx2kTldugoTXGqnB1" +
       "XVuvmnS/to4yWkGyejbsSf11hpUJlsuI2gIFVlht+u2UaNCSjEYeBewm3moN" +
       "uD43J7gULfd4dmUG42msz5HIoBCiSnh8ZU301qo3pkRlgWT9aSMZmTEvag0U" +
       "qSbIOJxOa1CTk+WRNLP6kxozrS/SyCQSEVikcM3M5ySXOePmvIG688bAWg+a" +
       "xjzgyMHa7bTnM5HsVkXOr2iymU1MX6zF/Va5M9u06wjEV0gKQc3AkuUpNGiv" +
       "NohnOJQx0Gp1TNCJ6VbZpn601aQVU0kDxs4mkGIiFMPrqQUcATMdLXvA/sry" +
       "luvYtthaely9pg5X616QDCTZa9Yqc33rAdcoyZKF2Eljh1FnXEDNhzhfTxAY" +
       "nc7oZpbarruBZhzqAlO5qSjLtZ1CanuVKPwiaKYpIGmiidpIdKGDWY20ZtQW" +
       "tq1ykjk0+2XfaJr9OCWnjOg5reUMj+OGuUC2nLxVs2qHTyrdVXU2DjADFc3m" +
       "eNy0SI7YuOq6009kfd3vOKxMjLHQqE6Hgwgl+pA8hh1Ul6qdVsvWNAszyz7h" +
       "0zFCDphF1ZGnFZKbIx3JH/eyWneg0l7gBZNyP7WXnTpNT9C5D8l+Z5WYwXow" +
       "D7nBGMpctBEs+5ncCQg4xnuIOdfp3gLtrZJMZJMNJITQ2C4b6KLsKQlBZkF1" +
       "5LZVitSbGNNpzDzdhBkSnXoaGOqNpqVD9FbWsgk645oITRF4FhPzre5sRVgO" +
       "hpI+wdetSjyzSZ3LxhAzWGToMDDEaYw1RYQQiaotdDUPIehVDwd+cNdcQLMm" +
       "NKlC6KRWm0FNoCxLaSgF7AhKPafaDruNujhC8KwWIgEaUptGa6A12mlCtMqp" +
       "lVUhc1yOtVUIz6HYZJxtnUc24XazSbIu6zVbrNmVo1Wko35l69PNVWh3gVdd" +
       "xYFZ1zgM3TI0bSKbKhJb6qzcT0wo8EOxata3WxdyCK2+jpeLQbNDGzbXVqMe" +
       "5bbLKZzpMApWapDOtxOiabJbrNkY2WXapZooyVX4YRALELGEZN6kOGicNns6" +
       "2R9IKT42t2ZHQtiWSko1GS1TtJiO3TJke1EDuD5NaU0DG423upN5F9fLkx5E" +
       "hmu5WfckBaPbNtqE1qaDrwXM1UxEYSo2rs+mDW5mAtzrJcKi6xkhyTDneWlz" +
       "ga/koN4gI6e1GAdyQgl9lBa7TWwatj3K17DtFq3IUghzTkhNpKkoL0J63q6Q" +
       "8wbS9C2Py0YOLjiY2bcnMVh/oIHhixVpsGJseFvpTntk05soyKgmNYMyVhHd" +
       "OT2xm0qIjs3p3G6WV1yLp2xMoL2mIFbx1JUImVjFpEgtGmrdMZ1UHAeUE1C9" +
       "RhWV1umIajEstNzK1XlnULWygcrIxCZNssFikOBLvpPy4VSd91IeyVJ+ZiiY" +
       "P2vr/Q2EcEStOVt52lowa7PZojF16l64WE14OvFHTMz1tjbkTbuUPYwazgip" +
       "KbWK34nWeE+N05q2nWwUP+2EVhoOxaro6hVqqRtzk+vTke/OxKjaSNB2twIH" +
       "lS7lT0corayTJb+c6QvCKSNWw6C9ctyc1RmnYgy37GxW7VCdxXSszyMLY2Sp" +
       "159vyj6ut4NUofS1kikLOVXMiNumBB5glVFZmTtSnSEsMKVPBgQhu5VRxNTh" +
       "ATrAyltxWMM37JJa1/BOZ4RV2mhvwS/6wzrSZWZUszI2IGcz9DqS0BYVfJOG" +
       "sGv7LMFaUdlZJm2op0w6EJh31Y2lDzoIa9UjezlF/PWwD/c2kGzGOHDDNnXD" +
       "nnsbWuhzaYtjDHYKVYhUTqVkpouzljSweQ3tTaSMiRKORcVmbd6eNQNP7Q9b" +
       "UjYnVjXfaCW1ZbMFt+JZJ5XRHj9tu/jIYoVBIq11Ry779AaOPSlbNmMDnwhc" +
       "GSzC9IUQjaqztAMjbNYSqOHCT90UhshlPfVcNWyhFahmdla9cdngZzhMC/XQ" +
       "7SDOgOqn414LpFPjlUJP26NgZWFunxQnXg2lNBwhW1MazCChajXQMjug5/oo" +
       "mMA8WNXJ2+HErS4de2zx9Jy2nXS4RMpK1jMpSpgNDKhTnvaGFKPDhtxXaGkz" +
       "YAcmowWOWyVFV8LSgGNsOsFYrjPSMEL34hoGo33YxuAyQ/rtdvvj+TbQv7uz" +
       "7akHi524k8tzSxvJX7xxBztQ6a3O+Iq/S6WDC1dntjLPnKodHe/6Ne5kA31/" +
       "xuqF+QnrE+fdqCtOV7/4qVdfU4c/U7mw3yGdxqV7Y8//mK2tNfsMkMugpOfP" +
       "P95jiwuFp2dsX/nU7z0uvGS+fAeXk546");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("wHlY5D9iX/914kPK37pQuuvkxO2mq443ZnrhxnO2K6EWJ6Er3HDa9sRJvzx+" +
       "fG7w0/t++enDLebTnr/15vyHd5pzcNx6dCrw5ULgG7c5j/29PPpvcemy4vnb" +
       "jhzLRbZTbfvdOz6X/voJwfxIuvQ+EH55T/CX3xmC+6s4+dfd0XMh9b9uw/I7" +
       "efQHcekeQ4tzhT3W8ocPb/Gc7tUX7L/1TrD/yp79V/4c2R9dOJ/9UXGh448L" +
       "9q6wPxr5w1OSf/I2SBY6/GEQvron+dV3nOSX86hcELn/NiSv5tG9cel+3bLt" +
       "XT/2Qs+5UZ2PrrwNrvmZaakGYD+3y7v7fKtcgZ3zQy/WlFhT39KwPfqe27B9" +
       "Io+AAr87ZztM4jOKe3iIsfYs9bQBHnm7DfAiwPixfQN87A47++h9b43587dh" +
       "/tE8ei4uPXID85OjyfztU6d0P/RO0F3s6S7+nOg2b0MXzaPKTXR7bYbBbqZb" +
       "fRt088PO3DU4enVP99U7oHuhoJt/j2/J+fDeEH8QFVxvc6PuqJNHHy+Gd8rL" +
       "jm9rrKfuPYaH85O9Gw35oUjROnd0Cy8F9nJ/uTq/KfrYTb/m2P0CQfn51x64" +
       "/Ohrk/9Y3C8++ZXAvUzpsp7Y9tlbN2eeL/mhBogUkrs7OH7Bko1L3/sWHS8w" +
       "ZR8/5tiPmF0JXFx68vYlxKWL1vEl1eNcfFx67LxccekuEJ+VBlblvbeSBpIg" +
       "Pis5j0tXDyVB/cXnWbkfjEtXTuXi0qXdw1mR66B0IJI/vuwfd3vtrXqp7UUU" +
       "h7ISg95Mj864mftRUMyDD72ZepxkOXuDOq+w+EHQsRuZ7H4SdF350mvU4BPf" +
       "bv7M7ga3YstZlpdymSnds7tMfuKKPn1uacdlXep/5Lv3/8K9zx27zffvAJ+O" +
       "yDPYnrr1demu48fFBefsnz36T1/8B6/9TnGa/v8AN62FS6k1AAA=");
}
