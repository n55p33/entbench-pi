package org.apache.batik.ext.awt.image.rendered;
public class AffineRed extends org.apache.batik.ext.awt.image.rendered.AbstractRed {
    java.awt.RenderingHints hints;
    java.awt.geom.AffineTransform src2me;
    java.awt.geom.AffineTransform me2src;
    public java.awt.geom.AffineTransform getTransform() { return (java.awt.geom.AffineTransform)
                                                                   src2me.
                                                                   clone(
                                                                     );
    }
    public org.apache.batik.ext.awt.image.rendered.CachableRed getSource() {
        return (org.apache.batik.ext.awt.image.rendered.CachableRed)
                 getSources(
                   ).
                 get(
                   0);
    }
    public AffineRed(org.apache.batik.ext.awt.image.rendered.CachableRed src,
                     java.awt.geom.AffineTransform src2me,
                     java.awt.RenderingHints hints) { super();
                                                      this.src2me =
                                                        src2me;
                                                      this.hints =
                                                        hints;
                                                      try { me2src =
                                                              src2me.
                                                                createInverse(
                                                                  );
                                                      }
                                                      catch (java.awt.geom.NoninvertibleTransformException nite) {
                                                          me2src =
                                                            null;
                                                      }
                                                      java.awt.Rectangle srcBounds =
                                                        src.
                                                        getBounds(
                                                          );
                                                      java.awt.Rectangle myBounds;
                                                      myBounds =
                                                        src2me.
                                                          createTransformedShape(
                                                            srcBounds).
                                                          getBounds(
                                                            );
                                                      java.awt.image.ColorModel cm =
                                                        fixColorModel(
                                                          src);
                                                      java.awt.image.SampleModel sm =
                                                        fixSampleModel(
                                                          src,
                                                          cm,
                                                          myBounds);
                                                      java.awt.geom.Point2D pt =
                                                        new java.awt.geom.Point2D.Float(
                                                        src.
                                                          getTileGridXOffset(
                                                            ),
                                                        src.
                                                          getTileGridYOffset(
                                                            ));
                                                      pt =
                                                        src2me.
                                                          transform(
                                                            pt,
                                                            null);
                                                      init(
                                                        src,
                                                        myBounds,
                                                        cm,
                                                        sm,
                                                        (int)
                                                          pt.
                                                          getX(
                                                            ),
                                                        (int)
                                                          pt.
                                                          getY(
                                                            ),
                                                        null);
    }
    public java.awt.image.WritableRaster copyData(java.awt.image.WritableRaster wr) {
        org.apache.batik.ext.awt.image.rendered.PadRed.ZeroRecter zr =
          org.apache.batik.ext.awt.image.rendered.PadRed.ZeroRecter.
          getZeroRecter(
            wr);
        zr.
          zeroRect(
            new java.awt.Rectangle(
              wr.
                getMinX(
                  ),
              wr.
                getMinY(
                  ),
              wr.
                getWidth(
                  ),
              wr.
                getHeight(
                  )));
        genRect(
          wr);
        return wr;
    }
    public java.awt.image.Raster getTile(int x,
                                         int y) {
        if (me2src ==
              null)
            return null;
        int tx =
          tileGridXOff +
          x *
          tileWidth;
        int ty =
          tileGridYOff +
          y *
          tileHeight;
        java.awt.Point pt =
          new java.awt.Point(
          tx,
          ty);
        java.awt.image.WritableRaster wr =
          java.awt.image.Raster.
          createWritableRaster(
            sm,
            pt);
        genRect(
          wr);
        return wr;
    }
    public void genRect(java.awt.image.WritableRaster wr) {
        if (me2src ==
              null)
            return;
        java.awt.Rectangle srcR =
          me2src.
          createTransformedShape(
            wr.
              getBounds(
                )).
          getBounds(
            );
        srcR.
          setBounds(
            srcR.
              x -
              1,
            srcR.
              y -
              1,
            srcR.
              width +
              2,
            srcR.
              height +
              2);
        org.apache.batik.ext.awt.image.rendered.CachableRed src =
          (org.apache.batik.ext.awt.image.rendered.CachableRed)
            getSources(
              ).
            get(
              0);
        if (!srcR.
              intersects(
                src.
                  getBounds(
                    )))
            return;
        java.awt.image.Raster srcRas =
          src.
          getData(
            srcR.
              intersection(
                src.
                  getBounds(
                    )));
        if (srcRas ==
              null)
            return;
        java.awt.geom.AffineTransform aff =
          (java.awt.geom.AffineTransform)
            src2me.
            clone(
              );
        aff.
          concatenate(
            java.awt.geom.AffineTransform.
              getTranslateInstance(
                srcRas.
                  getMinX(
                    ),
                srcRas.
                  getMinY(
                    )));
        java.awt.geom.Point2D srcPt =
          new java.awt.geom.Point2D.Float(
          wr.
            getMinX(
              ),
          wr.
            getMinY(
              ));
        srcPt =
          me2src.
            transform(
              srcPt,
              null);
        java.awt.geom.Point2D destPt =
          new java.awt.geom.Point2D.Double(
          srcPt.
            getX(
              ) -
            srcRas.
            getMinX(
              ),
          srcPt.
            getY(
              ) -
            srcRas.
            getMinY(
              ));
        destPt =
          aff.
            transform(
              destPt,
              null);
        aff.
          preConcatenate(
            java.awt.geom.AffineTransform.
              getTranslateInstance(
                -destPt.
                  getX(
                    ),
                -destPt.
                  getY(
                    )));
        java.awt.image.AffineTransformOp op =
          new java.awt.image.AffineTransformOp(
          aff,
          hints);
        java.awt.image.BufferedImage srcBI;
        java.awt.image.BufferedImage myBI;
        java.awt.image.ColorModel srcCM =
          src.
          getColorModel(
            );
        java.awt.image.ColorModel myCM =
          getColorModel(
            );
        java.awt.image.WritableRaster srcWR =
          (java.awt.image.WritableRaster)
            srcRas;
        srcCM =
          org.apache.batik.ext.awt.image.GraphicsUtil.
            coerceData(
              srcWR,
              srcCM,
              true);
        srcBI =
          new java.awt.image.BufferedImage(
            srcCM,
            srcWR.
              createWritableTranslatedChild(
                0,
                0),
            srcCM.
              isAlphaPremultiplied(
                ),
            null);
        myBI =
          new java.awt.image.BufferedImage(
            myCM,
            wr.
              createWritableTranslatedChild(
                0,
                0),
            myCM.
              isAlphaPremultiplied(
                ),
            null);
        op.
          filter(
            srcBI,
            myBI);
    }
    protected static java.awt.image.ColorModel fixColorModel(org.apache.batik.ext.awt.image.rendered.CachableRed src) {
        java.awt.image.ColorModel cm =
          src.
          getColorModel(
            );
        if (cm.
              hasAlpha(
                )) {
            if (!cm.
                  isAlphaPremultiplied(
                    ))
                cm =
                  org.apache.batik.ext.awt.image.GraphicsUtil.
                    coerceColorModel(
                      cm,
                      true);
            return cm;
        }
        java.awt.color.ColorSpace cs =
          cm.
          getColorSpace(
            );
        int b =
          src.
          getSampleModel(
            ).
          getNumBands(
            ) +
          1;
        if (b ==
              4) {
            int[] masks =
              new int[4];
            for (int i =
                   0;
                 i <
                   b -
                   1;
                 i++)
                masks[i] =
                  16711680 >>
                    8 *
                    i;
            masks[3] =
              255 <<
                8 *
                (b -
                   1);
            return new java.awt.image.DirectColorModel(
              cs,
              8 *
                b,
              masks[0],
              masks[1],
              masks[2],
              masks[3],
              true,
              java.awt.image.DataBuffer.
                TYPE_INT);
        }
        int[] bits =
          new int[b];
        for (int i =
               0;
             i <
               b;
             i++)
            bits[i] =
              8;
        return new java.awt.image.ComponentColorModel(
          cs,
          bits,
          true,
          true,
          java.awt.Transparency.
            TRANSLUCENT,
          java.awt.image.DataBuffer.
            TYPE_INT);
    }
    protected java.awt.image.SampleModel fixSampleModel(org.apache.batik.ext.awt.image.rendered.CachableRed src,
                                                        java.awt.image.ColorModel cm,
                                                        java.awt.Rectangle bounds) {
        java.awt.image.SampleModel sm =
          src.
          getSampleModel(
            );
        int defSz =
          org.apache.batik.ext.awt.image.rendered.AbstractTiledRed.
          getDefaultTileSize(
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
        if (w <=
              0 ||
              h <=
              0) {
            w =
              1;
            h =
              1;
        }
        return cm.
          createCompatibleSampleModel(
            w,
            h);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1ZDXBU1RW+uwn5IyEhEH4CBAhBC8qu/EjVKDWEv9AFMgli" +
       "GyrLzdu7yYO37z3eu5ssWFDpONA/BikitUpnWhx/RsF26rS21aHjtErFzvhX" +
       "a63a36mttUo7Wqe02nPufW/fz2YX0yndmXf37b3nnHvOued+59y7D75FxtgW" +
       "aWE6j/GdJrNjK3XeTS2bpTo1atsboS+p3FFG/77ljfVXRklFHxk3SO11CrXZ" +
       "KpVpKbuPzFB1m1NdYfZ6xlLI0W0xm1lDlKuG3keaVLsrY2qqovJ1RoohwSZq" +
       "Jch4yrml9mc563IEcDIjAZrEhSbxjvBwe4LUKoa50yOf4iPv9I0gZcaby+ak" +
       "IbGNDtF4lqtaPKHavD1nkUtMQ9s5oBk8xnI8tk273HHB2sTlBS5ofbj+vXMH" +
       "BxuECyZQXTe4MM/uYbahDbFUgtR7vSs1lrF3kD2kLEHG+og5aUu4k8Zh0jhM" +
       "6lrrUYH2dUzPZjoNYQ53JVWYCirEyeygEJNaNOOI6RY6g4Qq7tgumMHaWXlr" +
       "pZUFJt5+SfzwHVsavl1G6vtIvar3ojoKKMFhkj5wKMv0M8vuSKVYqo+M12Gx" +
       "e5mlUk3d5ax0o60O6JRnYfldt2Bn1mSWmNPzFawj2GZlFW5YefPSIqCcX2PS" +
       "Gh0AWyd5tkoLV2E/GFijgmJWmkLcOSzl21U9xcnMMEfexrZPAgGwVmYYHzTy" +
       "U5XrFDpIowwRjeoD8V4IPX0ASMcYEIAWJ81FhaKvTapspwMsiREZouuWQ0BV" +
       "LRyBLJw0hcmEJFil5tAq+dbnrfVXH7hRX6NHSQR0TjFFQ/3HAlNLiKmHpZnF" +
       "YB9Ixtr5iSN00mP7o4QAcVOIWNJ897Nnr7205dRTkmbaCDQb+rcxhSeV4/3j" +
       "np3eOe/KMlSjyjRsFRc/YLnYZd3OSHvOBISZlJeIgzF38FTPTz598wPszSip" +
       "6SIViqFlMxBH4xUjY6oas1YznVmUs1QXqWZ6qlOMd5FKeE+oOpO9G9Jpm/Eu" +
       "Uq6JrgpD/AYXpUEEuqgG3lU9bbjvJuWD4j1nEkIq4SG18FxG5Ed8c5KKDxoZ" +
       "FqcK1VXdiHdbBtpvxwFx+sG3g/F+iPrtcdvIWhCCccMaiFOIg0HmDODOpMM8" +
       "rmZg+eOwHClYk1S8I50GNXtYKobRZv6f5smhvROGIxFYiulhINBgD60xNOBL" +
       "Koezy1eePZF8WgYZbgzHU5wshKljcuqYmFrAJkwdE1PH3Klj+alJJCJmnIgq" +
       "yIWHZdsOAAAIXDuv94a1W/e3lkHEmcPl4HMkbQ1kok4PJVxoTyonG+t2zX5t" +
       "4RNRUp4gjVThWaphYumwBgCylO3Orq7thxzlpYpZvlSBOc4yFJYCpCqWMhwp" +
       "VcYQs7Cfk4k+CW4iwy0bL55GRtSfnDo6fMummy6LkmgwO+CUYwDYkL0bMT2P" +
       "3W1hVBhJbv2+N947eWS34eFDIN24WbKAE21oDcdE2D1JZf4s+kjysd1twu3V" +
       "gN+cwioDNLaE5wjAT7sL5WhLFRicNqwM1XDI9XENH7SMYa9HBOt48T4RwmIs" +
       "7kd8WeZsUPGNo5NMbCfL4MY4C1khUsU1vebdv/jZnxYLd7tZpd5XDvQy3u5D" +
       "MhTWKDBrvBe2Gy3GgO7Vo91fuf2tfZtFzALFnJEmbMO2ExAMlhDcfOtTO15+" +
       "/bXjL0S9OOeQyrP9UBHl8kZiP6kpYSTMdpGnDyChBiiBUdN2nQ7xqaZV2q8x" +
       "3Fj/qp+78JG/HGiQcaBBjxtGl55fgNc/dTm5+ekt/2gRYiIKZmLPZx6ZhPcJ" +
       "nuQOy6I7UY/cLc/N+OqT9G5IFADOtrqLCbwtEz4oE5ZP4WTxR0WVTiBBDQFX" +
       "XN4ZYlakHWBGxsGdjRbVbQwyl2pynqpHyILEvgZqB1uEzeWC6jLRLkGXC+2I" +
       "GLsGm7m2f/sFd7ivZksqB194p27TO4+fFf4KFn3+aFtHzXYZ4NhclAPxk8Pw" +
       "uIbag0C35NT6zzRop86BxD6QqAD82xsssCAXiE2HekzlL3/0xKStz5aR6CpS" +
       "oxk0tYqKbU6qYX8xexAQPmd+4loZXsNV0DQIU0mB8QUduMQzRw6elRmTi+Xe" +
       "9b3J37n63mOviTg3pYxpzlpD0gngujg6eNDywPMff/He244My+JjXnE8DfFN" +
       "+ecGrX/vb98vcLlA0hEKoxB/X/zBu5o7l70p+D1IQ+62XGGihLTg8S56IPNu" +
       "tLXix1FS2UcaFKdU30S1LAJFH5Sntlu/QzkfGA+WmrKuas9D9vQwnPqmDYOp" +
       "l6DhHanxvS6En2IJm+FZ5EDLojB+Roh42SBYLhbtfGwW+OMhL6q8hChOxgyq" +
       "zonlKgnL2C7DplvK6Sgagl3BeabBs9iZZ3ERla+XKmPTU6hlMW7AX9tSFknX" +
       "XRFS81P/hZpLnImWFFFzS0k1i3GDmhm2CDQdSc1kCTVz3nSX5KcTnwoSqnP9" +
       "GcbbsQRhaUaxo4g4Rh3fe/hYasM9C+WebQyW9yvh9PrQz/99Jnb016dHqCSr" +
       "uWEu0NgQ03xzVuKUAZRYJ05p3pZ7ddyh3z3aNrB8NIUf9rWcp7TD3zPBiPnF" +
       "gSesypN7/9y8cdng1lHUcDND7gyLvH/dg6dXX6QcioojqcSCgqNskKk9iAA1" +
       "FoOzt74xgANz8gGAgUouhmepEwBLw9HqhVgodvLVSTHWEll0qMSYaHZwUjvA" +
       "eD5vi2j3At06334snbmwY7Up+jN5eybj2Cx4rnLsuWr0rijGWsLcz5UYuxWb" +
       "PbA3wBW94qyHHUs9P9x0AfyAWYG0wsMcY9jo/VCMNWRrxDni4e9A6SbLvOst" +
       "lYvqjtocChykOljCW4ex+SInVXgfuIJyir9v85z1pQvgrEYcmyqMlJ8do3dW" +
       "MdaQqVGhSDR4Hkao683223B2VTNwVBlyrncWdW9V9rd1/14i8dQRGCRd033x" +
       "L296adsZgVlVCJJ5pPABJICp7xTWIE34ED4ReD7AB1XHDvyGUqbTuauZlb+s" +
       "weqvZBkXMiC+u/H17Xe98ZA0IFyzhYjZ/sNf+DB24LBMK/LGb07BpZufR976" +
       "SXOw+SZqN7vULIJj1R9P7v7Bfbv3RZ2QUzkpc0sbf0DDsTPocqnnis/X//Bg" +
       "Y9kqSFZdpCqrqzuyrCsVBOxKO9vvWwPvgtCDb0dj9DcnkfngWuz4hmi/XmKD" +
       "fAubOzmpRGSF5XH3XVNo38n95m2cr12AjSMO8PPh2eNE/57Rb5xirCOjjEAD" +
       "IfXxEj46hc2jwkd6D9654e97nBDBr/s5KR8y1JTnnu9fAPfMwrEF8JxxbDxT" +
       "wj3h4jwKGcO0DA7qsxTWteLSPlSxTywhvLgDl4p5ny3hwOexOc1JXVrNwZnQ" +
       "sDD8NTfUpoZCLUQh/PnTC5XUPgbPWcfks6Pwp7D8mZD/6koIC7nHud0Q/sPm" +
       "Rdcbjb5bCAWqtwGNCT1+U8K/f8DmFU7GgX97acbUWMDBzSEHh0mEh3/1v/Bw" +
       "DqIsf6uLlwFTCv5Mkn+AKCeO1VdNPnbdS6JGz/9JUQsJJ53VNP9x1fdeYVoM" +
       "TBSU8vAqYe5tTi7+iNdDUAq4r8KIv0oJf+OkpbQEOLGKbz/Xu5xMKcYFWQBa" +
       "P/X7nEwciRooofVTnuOkIUwJ84tvP90HnNR4dLCr5YuPJBIB6UCCr1HTDYiP" +
       "fJfWAUWBBQcoWM1cJHjuywdO0/kCx3dUnBPI9eL/SDchZuU/kknl5LG16288" +
       "u/QeeQ+raHTXLpQyFtKgvBLOn5RmF5XmyqpYM+/cuIer57q5ebxU2NvX03y7" +
       "aDXsahODtjl0SWm35e8qXz5+9ePP7K94DqqKzSRCOZmwufCKJmdm4Yi6OVGY" +
       "7uFUKW5P2+fduXPZpem3XxGXYESWB9OL0yeVF+694flDU463RMnYLohEWJ+c" +
       "uDtasRNT0pDVR+pUe2UOVAQpKtUCtcQ43F8ULzSFXxx31uV78Rafk9bC6qjw" +
       "v48azRhm1nIjq6dQDFQjY70e98QcOGxmTTPE4PX4KsiHZD7F1YCQTSbWmaZb" +
       "PFZfYQp8OTFS9jkhwrxJvOLbpP8A6ePnYKsgAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
