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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "x+pmU+DLsdGyzzER5k3iFd+m/Be0IZjTqyAAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
