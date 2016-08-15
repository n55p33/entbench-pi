package org.apache.batik.ext.awt.image.rendered;
public class PadRed extends org.apache.batik.ext.awt.image.rendered.AbstractRed {
    static final boolean DEBUG = false;
    org.apache.batik.ext.awt.image.PadMode padMode;
    java.awt.RenderingHints hints;
    public PadRed(org.apache.batik.ext.awt.image.rendered.CachableRed src,
                  java.awt.Rectangle bounds,
                  org.apache.batik.ext.awt.image.PadMode padMode,
                  java.awt.RenderingHints hints) { super(src, bounds, src.
                                                           getColorModel(
                                                             ),
                                                         fixSampleModel(
                                                           src,
                                                           bounds),
                                                         bounds.
                                                           x,
                                                         bounds.
                                                           y,
                                                         null);
                                                   this.padMode = padMode;
                                                   if (DEBUG) { java.lang.System.
                                                                  out.
                                                                  println(
                                                                    "Src: " +
                                                                    src +
                                                                    " Bounds: " +
                                                                    bounds +
                                                                    " Off: " +
                                                                    src.
                                                                      getTileGridXOffset(
                                                                        ) +
                                                                    ", " +
                                                                    src.
                                                                      getTileGridYOffset(
                                                                        ));
                                                   }
                                                   this.
                                                     hints =
                                                     hints;
    }
    public java.awt.image.WritableRaster copyData(java.awt.image.WritableRaster wr) {
        org.apache.batik.ext.awt.image.rendered.CachableRed src =
          (org.apache.batik.ext.awt.image.rendered.CachableRed)
            getSources(
              ).
            get(
              0);
        java.awt.Rectangle srcR =
          src.
          getBounds(
            );
        java.awt.Rectangle wrR =
          wr.
          getBounds(
            );
        if (wrR.
              intersects(
                srcR)) {
            java.awt.Rectangle r =
              wrR.
              intersection(
                srcR);
            java.awt.image.WritableRaster srcWR;
            srcWR =
              wr.
                createWritableChild(
                  r.
                    x,
                  r.
                    y,
                  r.
                    width,
                  r.
                    height,
                  r.
                    x,
                  r.
                    y,
                  null);
            src.
              copyData(
                srcWR);
        }
        if (padMode ==
              org.apache.batik.ext.awt.image.PadMode.
                ZERO_PAD) {
            handleZero(
              wr);
        }
        else
            if (padMode ==
                  org.apache.batik.ext.awt.image.PadMode.
                    REPLICATE) {
                handleReplicate(
                  wr);
            }
            else
                if (padMode ==
                      org.apache.batik.ext.awt.image.PadMode.
                        WRAP) {
                    handleWrap(
                      wr);
                }
        return wr;
    }
    protected static class ZeroRecter {
        java.awt.image.WritableRaster wr;
        int bands;
        static int[] zeros = null;
        public ZeroRecter(java.awt.image.WritableRaster wr) {
            super(
              );
            this.
              wr =
              wr;
            this.
              bands =
              wr.
                getSampleModel(
                  ).
                getNumBands(
                  );
        }
        public void zeroRect(java.awt.Rectangle r) {
            synchronized (this)  {
                if (zeros ==
                      null ||
                      zeros.
                        length <
                      r.
                        width *
                      bands)
                    zeros =
                      (new int[r.
                                 width *
                                 bands]);
            }
            for (int y =
                   0;
                 y <
                   r.
                     height;
                 y++) {
                wr.
                  setPixels(
                    r.
                      x,
                    r.
                      y +
                      y,
                    r.
                      width,
                    1,
                    zeros);
            }
        }
        public static org.apache.batik.ext.awt.image.rendered.PadRed.ZeroRecter getZeroRecter(java.awt.image.WritableRaster wr) {
            if (org.apache.batik.ext.awt.image.GraphicsUtil.
                  is_INT_PACK_Data(
                    wr.
                      getSampleModel(
                        ),
                    false))
                return new org.apache.batik.ext.awt.image.rendered.PadRed.ZeroRecter_INT_PACK(
                  wr);
            else
                return new org.apache.batik.ext.awt.image.rendered.PadRed.ZeroRecter(
                  wr);
        }
        public static void zeroRect(java.awt.image.WritableRaster wr) {
            org.apache.batik.ext.awt.image.rendered.PadRed.ZeroRecter zr =
              getZeroRecter(
                wr);
            zr.
              zeroRect(
                wr.
                  getBounds(
                    ));
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "vTM6JV5x+Oi/tfARqHofAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "5L/x1l99z8+/+hflZvv/A2VFJMZnKgAA");
    }
    protected static class ZeroRecter_INT_PACK extends org.apache.batik.ext.awt.image.rendered.PadRed.ZeroRecter {
        final int base;
        final int scanStride;
        final int[] pixels;
        final int[] zeros;
        final int x0;
        final int y0;
        public ZeroRecter_INT_PACK(java.awt.image.WritableRaster wr) {
            super(
              wr);
            java.awt.image.SinglePixelPackedSampleModel sppsm;
            sppsm =
              (java.awt.image.SinglePixelPackedSampleModel)
                wr.
                getSampleModel(
                  );
            scanStride =
              sppsm.
                getScanlineStride(
                  );
            java.awt.image.DataBufferInt db =
              (java.awt.image.DataBufferInt)
                wr.
                getDataBuffer(
                  );
            x0 =
              wr.
                getMinY(
                  );
            y0 =
              wr.
                getMinX(
                  );
            base =
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
            pixels =
              db.
                getBankData(
                  )[0];
            if (wr.
                  getWidth(
                    ) >
                  10)
                zeros =
                  (new int[wr.
                             getWidth(
                               )]);
            else
                zeros =
                  null;
        }
        public void zeroRect(java.awt.Rectangle r) {
            final int rbase =
              base +
              (r.
                 x -
                 x0) +
              (r.
                 y -
                 y0) *
              scanStride;
            if (r.
                  width >
                  10) {
                for (int y =
                       0;
                     y <
                       r.
                         height;
                     y++) {
                    int sp =
                      rbase +
                      y *
                      scanStride;
                    java.lang.System.
                      arraycopy(
                        zeros,
                        0,
                        pixels,
                        sp,
                        r.
                          width);
                }
            }
            else {
                int sp =
                  rbase;
                int end =
                  sp +
                  r.
                    width;
                int adj =
                  scanStride -
                  r.
                    width;
                for (int y =
                       0;
                     y <
                       r.
                         height;
                     y++) {
                    while (sp <
                             end)
                        pixels[sp++] =
                          0;
                    sp +=
                      adj;
                    end +=
                      scanStride;
                }
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "AAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "iPmmys+AmyhpFFOIvM79neSFa35CcipIvOcpWZekzjpHYdY2fT1cV3h7O8Ji" +
           "u5XiyqJJuarJk6Gfye20DTIFLeH6tLjsd1wlYeXIN5udjpdj7CTXeDQnGna7" +
           "hS6cbD4KaiNSbBuYPexgS3buolx1wjCx0MEFqUP2Fu18YBPqZINR2gh14cR1" +
           "x7s4w5YddgViPWEmQjueYrvFWI88lB1uKL5NN+uhprfMqqdYID/CuEbdVBvd" +
           "5qTfk1vw1p13Em6EpLEXV7HZPJ6u4ahSX+phq71ck14NJvUFUChXYkSUFrzX" +
           "YJadTrXSNCJuZ0etqcRZ9d3aZt3pvG2MssVotRQac2cX+HKC7ObOql2jCX7q" +
           "VfmgNVy2dRxJshmOzuWMdqZasxKOWqalynIGtzuUo8+ZibqGG9m46aw3/Zk8" +
           "27XpnrPSvGGWe+mk3jVrTDJMw2XaYiIwjeVoXrFCkyXlkbWweyIXLNp6YjWr" +
           "cFPWWpg1CWR0Yu169jY0caDoeIq2xzXSnolM0Mmm2FTEepaQGmFfmUf13Exb" +
           "1iC1LLkmzJRsHutzy6etlmMz8IJxLGIUMsJwuYGtIWt2fTTKAWptWdGVnb7O" +
           "DMgxWq8l47hijie1DlYfrWbNCnCWieCxw/rIHo0ErdHjsl7EUkibAR45q2gT" +
           "DazUv71Ywv/8a9taeKTcRTm5ZWPZraLiE69h9yC7yzZtDD3oh15c3CVQy35P" +
           "T3bLLb83QBfubZzZiDpzkAcVJypP3u1qTXma8qn3vfiSyv509eBoH5GJoStH" +
           "N55O+ex3mP3zR+jPguenjmT4qYubYadjcOedsG/N7rQ3euEs99GTs9ziVoXk" +
           "GrZWNvvNe+yD/lZR/KcYupofXca44yZP6pnqqYX+89fb3zl3UBpDr7/DRY9j" +
           "mQ9f250RYJ/Hb7ugtr9UpXz6petXH3uJ/5P9IcnxxacHaeiqntj22UPHM+9X" +
           "fIA1ZjkUD+6PIP3y57Mx9C2vUjQweMevpVb/bc/hczH01L05xNDl8vdsq8/H" +
           "0ON3axVD94HyLPWfxNAb7kQNKEF5lvLPY+jGRUrQf/l7lu4vYujaKR1w7v3L" +
           "WZIvAu6ApHj9K//Yjp1/892f7NL5CDxxs0e/npudCdpnzp2SlDcdj080kv1d" +
           "x1vKZ16imPd8tfnT+5soii3lecHlKg09sL8Uc3Iq8ra7cjvmdYV49msP/9KD" +
           "bz+GgYf3Ap+G8RnZ3nLnax8Dx4/Lixr5rz/2K+/82Zf+sty5/VfRHTnYgioA" +
           "AA==");
    }
    protected void handleZero(java.awt.image.WritableRaster wr) {
        org.apache.batik.ext.awt.image.rendered.CachableRed src =
          (org.apache.batik.ext.awt.image.rendered.CachableRed)
            getSources(
              ).
            get(
              0);
        java.awt.Rectangle srcR =
          src.
          getBounds(
            );
        java.awt.Rectangle wrR =
          wr.
          getBounds(
            );
        org.apache.batik.ext.awt.image.rendered.PadRed.ZeroRecter zr =
          org.apache.batik.ext.awt.image.rendered.PadRed.ZeroRecter.
          getZeroRecter(
            wr);
        java.awt.Rectangle ar =
          new java.awt.Rectangle(
          wrR.
            x,
          wrR.
            y,
          wrR.
            width,
          wrR.
            height);
        java.awt.Rectangle dr =
          new java.awt.Rectangle(
          wrR.
            x,
          wrR.
            y,
          wrR.
            width,
          wrR.
            height);
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "WrR: " +
                wrR +
                " srcR: " +
                srcR);
        }
        if (ar.
              x <
              srcR.
                x) {
            int w =
              srcR.
                x -
              ar.
                x;
            if (w >
                  ar.
                    width)
                w =
                  ar.
                    width;
            dr.
              width =
              w;
            zr.
              zeroRect(
                dr);
            ar.
              x +=
              w;
            ar.
              width -=
              w;
        }
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "WrR: [" +
                ar.
                  x +
                "," +
                ar.
                  y +
                "," +
                ar.
                  width +
                "," +
                ar.
                  height +
                "] s rcR: " +
                srcR);
        }
        if (ar.
              y <
              srcR.
                y) {
            int h =
              srcR.
                y -
              ar.
                y;
            if (h >
                  ar.
                    height)
                h =
                  ar.
                    height;
            dr.
              x =
              ar.
                x;
            dr.
              y =
              ar.
                y;
            dr.
              width =
              ar.
                width;
            dr.
              height =
              h;
            zr.
              zeroRect(
                dr);
            ar.
              y +=
              h;
            ar.
              height -=
              h;
        }
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "WrR: [" +
                ar.
                  x +
                "," +
                ar.
                  y +
                "," +
                ar.
                  width +
                "," +
                ar.
                  height +
                "] srcR: " +
                srcR);
        }
        if (ar.
              y +
              ar.
                height >
              srcR.
                y +
              srcR.
                height) {
            int h =
              ar.
                y +
              ar.
                height -
              (srcR.
                 y +
                 srcR.
                   height);
            if (h >
                  ar.
                    height)
                h =
                  ar.
                    height;
            int y0 =
              ar.
                y +
              ar.
                height -
              h;
            dr.
              x =
              ar.
                x;
            dr.
              y =
              y0;
            dr.
              width =
              ar.
                width;
            dr.
              height =
              h;
            zr.
              zeroRect(
                dr);
            ar.
              height -=
              h;
        }
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "WrR: [" +
                ar.
                  x +
                "," +
                ar.
                  y +
                "," +
                ar.
                  width +
                "," +
                ar.
                  height +
                "] srcR: " +
                srcR);
        }
        if (ar.
              x +
              ar.
                width >
              srcR.
                x +
              srcR.
                width) {
            int w =
              ar.
                x +
              ar.
                width -
              (srcR.
                 x +
                 srcR.
                   width);
            if (w >
                  ar.
                    width)
                w =
                  ar.
                    width;
            int x0 =
              ar.
                x +
              ar.
                width -
              w;
            dr.
              x =
              x0;
            dr.
              y =
              ar.
                y;
            dr.
              width =
              w;
            dr.
              height =
              ar.
                height;
            zr.
              zeroRect(
                dr);
            ar.
              width -=
              w;
        }
    }
    protected void handleReplicate(java.awt.image.WritableRaster wr) {
        org.apache.batik.ext.awt.image.rendered.CachableRed src =
          (org.apache.batik.ext.awt.image.rendered.CachableRed)
            getSources(
              ).
            get(
              0);
        java.awt.Rectangle srcR =
          src.
          getBounds(
            );
        java.awt.Rectangle wrR =
          wr.
          getBounds(
            );
        int x =
          wrR.
            x;
        int y =
          wrR.
            y;
        int width =
          wrR.
            width;
        int height =
          wrR.
            height;
        java.awt.Rectangle r;
        {
            int minX =
              srcR.
                x >
              x
              ? srcR.
                  x
              : x;
            int maxX =
              srcR.
                x +
              srcR.
                width -
              1 <
              x +
              width -
              1
              ? srcR.
                  x +
              srcR.
                width -
              1
              : x +
              width -
              1;
            int minY =
              srcR.
                y >
              y
              ? srcR.
                  y
              : y;
            int maxY =
              srcR.
                y +
              srcR.
                height -
              1 <
              y +
              height -
              1
              ? srcR.
                  y +
              srcR.
                height -
              1
              : y +
              height -
              1;
            int x0 =
              minX;
            int w =
              maxX -
              minX +
              1;
            int y0 =
              minY;
            int h =
              maxY -
              minY +
              1;
            if (w <
                  0) {
                x0 =
                  0;
                w =
                  0;
            }
            if (h <
                  0) {
                y0 =
                  0;
                h =
                  0;
            }
            r =
              new java.awt.Rectangle(
                x0,
                y0,
                w,
                h);
        }
        if (y <
              srcR.
                y) {
            int repW =
              r.
                width;
            int repX =
              r.
                x;
            int wrX =
              r.
                x;
            int wrY =
              y;
            if (x +
                  width -
                  1 <=
                  srcR.
                    x) {
                repW =
                  1;
                repX =
                  srcR.
                    x;
                wrX =
                  x +
                    width -
                    1;
            }
            else
                if (x >=
                      srcR.
                        x +
                      srcR.
                        width) {
                    repW =
                      1;
                    repX =
                      srcR.
                        x +
                        srcR.
                          width -
                        1;
                    wrX =
                      x;
                }
            java.awt.image.WritableRaster wr1 =
              wr.
              createWritableChild(
                wrX,
                wrY,
                repW,
                1,
                repX,
                srcR.
                  y,
                null);
            src.
              copyData(
                wr1);
            wrY++;
            int endY =
              srcR.
                y;
            if (y +
                  height <
                  endY)
                endY =
                  y +
                    height;
            if (wrY <
                  endY) {
                int[] pixels =
                  wr.
                  getPixels(
                    wrX,
                    wrY -
                      1,
                    repW,
                    1,
                    (int[])
                      null);
                while (wrY <
                         srcR.
                           y) {
                    wr.
                      setPixels(
                        wrX,
                        wrY,
                        repW,
                        1,
                        pixels);
                    wrY++;
                }
            }
        }
        if (y +
              height >
              srcR.
                y +
              srcR.
                height) {
            int repW =
              r.
                width;
            int repX =
              r.
                x;
            int repY =
              srcR.
                y +
              srcR.
                height -
              1;
            int wrX =
              r.
                x;
            int wrY =
              srcR.
                y +
              srcR.
                height;
            if (wrY <
                  y)
                wrY =
                  y;
            if (x +
                  width <=
                  srcR.
                    x) {
                repW =
                  1;
                repX =
                  srcR.
                    x;
                wrX =
                  x +
                    width -
                    1;
            }
            else
                if (x >=
                      srcR.
                        x +
                      srcR.
                        width) {
                    repW =
                      1;
                    repX =
                      srcR.
                        x +
                        srcR.
                          width -
                        1;
                    wrX =
                      x;
                }
            if (DEBUG) {
                java.lang.System.
                  out.
                  println(
                    "wr: " +
                    wr.
                      getBounds(
                        ));
                java.lang.System.
                  out.
                  println(
                    "req: [" +
                    wrX +
                    ", " +
                    wrY +
                    ", " +
                    repW +
                    ", 1]");
            }
            java.awt.image.WritableRaster wr1 =
              wr.
              createWritableChild(
                wrX,
                wrY,
                repW,
                1,
                repX,
                repY,
                null);
            src.
              copyData(
                wr1);
            wrY++;
            int endY =
              y +
              height;
            if (wrY <
                  endY) {
                int[] pixels =
                  wr.
                  getPixels(
                    wrX,
                    wrY -
                      1,
                    repW,
                    1,
                    (int[])
                      null);
                while (wrY <
                         endY) {
                    wr.
                      setPixels(
                        wrX,
                        wrY,
                        repW,
                        1,
                        pixels);
                    wrY++;
                }
            }
        }
        if (x <
              srcR.
                x) {
            int wrX =
              srcR.
                x;
            if (x +
                  width <=
                  srcR.
                    x) {
                wrX =
                  x +
                    width -
                    1;
            }
            int xLoc =
              x;
            int[] pixels =
              wr.
              getPixels(
                wrX,
                y,
                1,
                height,
                (int[])
                  null);
            while (xLoc <
                     wrX) {
                wr.
                  setPixels(
                    xLoc,
                    y,
                    1,
                    height,
                    pixels);
                xLoc++;
            }
        }
        if (x +
              width >
              srcR.
                x +
              srcR.
                width) {
            int wrX =
              srcR.
                x +
              srcR.
                width -
              1;
            if (x >=
                  srcR.
                    x +
                  srcR.
                    width) {
                wrX =
                  x;
            }
            int xLoc =
              wrX +
              1;
            int endX =
              x +
              width -
              1;
            int[] pixels =
              wr.
              getPixels(
                wrX,
                y,
                1,
                height,
                (int[])
                  null);
            while (xLoc <
                     endX) {
                wr.
                  setPixels(
                    xLoc,
                    y,
                    1,
                    height,
                    pixels);
                xLoc++;
            }
        }
    }
    protected void handleWrap(java.awt.image.WritableRaster wr) {
        handleZero(
          wr);
    }
    protected static java.awt.image.SampleModel fixSampleModel(org.apache.batik.ext.awt.image.rendered.CachableRed src,
                                                               java.awt.Rectangle bounds) {
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
              bounds.
                width)
            w =
              bounds.
                width;
        int h =
          sm.
          getHeight(
            );
        if (h <
              defSz)
            h =
              defSz;
        if (h >
              bounds.
                height)
            h =
              bounds.
                height;
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
      ("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" +
       "7XCqHgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "+p+/9T+8/Ifl+c0/AgZWP066KQAA");
}
