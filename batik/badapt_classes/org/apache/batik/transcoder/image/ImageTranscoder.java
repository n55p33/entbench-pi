package org.apache.batik.transcoder.image;
public abstract class ImageTranscoder extends org.apache.batik.transcoder.SVGAbstractTranscoder implements ent.runtime.ENT_Attributable {
    protected ImageTranscoder() { super(); }
    protected void transcode(org.w3c.dom.Document document, java.lang.String uri,
                             org.apache.batik.transcoder.TranscoderOutput output)
          throws org.apache.batik.transcoder.TranscoderException {
        super.
          transcode(
            document,
            uri,
            output);
        int w =
          (int)
            (width +
               0.5);
        int h =
          (int)
            (height +
               0.5);
        org.apache.batik.gvt.renderer.ImageRenderer renderer =
          createRenderer(
            );
        renderer.
          updateOffScreen(
            w,
            h);
        renderer.
          setTransform(
            curTxf);
        renderer.
          setTree(
            this.
              root);
        this.
          root =
          null;
        try {
            java.awt.Shape raoi =
              new java.awt.geom.Rectangle2D.Float(
              0,
              0,
              width,
              height);
            renderer.
              repaint(
                curTxf.
                  createInverse(
                    ).
                  createTransformedShape(
                    raoi));
            java.awt.image.BufferedImage rend =
              renderer.
              getOffScreen(
                );
            renderer =
              null;
            java.awt.image.BufferedImage dest =
              createImage(
                w,
                h);
            java.awt.Graphics2D g2d =
              org.apache.batik.ext.awt.image.GraphicsUtil.
              createGraphics(
                dest);
            if (hints.
                  containsKey(
                    KEY_BACKGROUND_COLOR)) {
                java.awt.Paint bgcolor =
                  (java.awt.Paint)
                    hints.
                    get(
                      KEY_BACKGROUND_COLOR);
                g2d.
                  setComposite(
                    java.awt.AlphaComposite.
                      SrcOver);
                g2d.
                  setPaint(
                    bgcolor);
                g2d.
                  fillRect(
                    0,
                    0,
                    w,
                    h);
            }
            if (rend !=
                  null) {
                g2d.
                  drawRenderedImage(
                    rend,
                    new java.awt.geom.AffineTransform(
                      ));
            }
            g2d.
              dispose(
                );
            rend =
              null;
            writeImage(
              dest,
              output);
        }
        catch (java.lang.Exception ex) {
            throw new org.apache.batik.transcoder.TranscoderException(
              ex);
        }
    }
    protected org.apache.batik.gvt.renderer.ImageRenderer createRenderer() {
        org.apache.batik.gvt.renderer.ImageRendererFactory rendFactory =
          new org.apache.batik.gvt.renderer.ConcreteImageRendererFactory(
          );
        return rendFactory.
          createStaticImageRenderer(
            );
    }
    protected void forceTransparentWhite(java.awt.image.BufferedImage img,
                                         java.awt.image.SinglePixelPackedSampleModel sppsm) {
        int w =
          img.
          getWidth(
            );
        int h =
          img.
          getHeight(
            );
        java.awt.image.DataBufferInt biDB =
          (java.awt.image.DataBufferInt)
            img.
            getRaster(
              ).
            getDataBuffer(
              );
        int scanStride =
          sppsm.
          getScanlineStride(
            );
        int dbOffset =
          biDB.
          getOffset(
            );
        int[] pixels =
          biDB.
          getBankData(
            )[0];
        int p =
          dbOffset;
        int adjust =
          scanStride -
          w;
        int a =
          0;
        int r =
          0;
        int g =
          0;
        int b =
          0;
        int pel =
          0;
        for (int i =
               0;
             i <
               h;
             i++) {
            for (int j =
                   0;
                 j <
                   w;
                 j++) {
                pel =
                  pixels[p];
                a =
                  pel >>
                    24 &
                    255;
                r =
                  pel >>
                    16 &
                    255;
                g =
                  pel >>
                    8 &
                    255;
                b =
                  pel &
                    255;
                r =
                  (255 *
                     (255 -
                        a) +
                     a *
                     r) /
                    255;
                g =
                  (255 *
                     (255 -
                        a) +
                     a *
                     g) /
                    255;
                b =
                  (255 *
                     (255 -
                        a) +
                     a *
                     b) /
                    255;
                pixels[p++] =
                  a <<
                    24 &
                    -16777216 |
                    r <<
                    16 &
                    16711680 |
                    g <<
                    8 &
                    65280 |
                    b &
                    255;
            }
            p +=
              adjust;
        }
    }
    public abstract java.awt.image.BufferedImage createImage(int width,
                                                             int height);
    public abstract void writeImage(java.awt.image.BufferedImage img,
                                    org.apache.batik.transcoder.TranscoderOutput output)
          throws org.apache.batik.transcoder.TranscoderException;
    public static final org.apache.batik.transcoder.TranscodingHints.Key
      KEY_BACKGROUND_COLOR =
      new org.apache.batik.transcoder.keys.PaintKey(
      );
    public static final org.apache.batik.transcoder.TranscodingHints.Key
      KEY_FORCE_TRANSPARENT_WHITE =
      new org.apache.batik.transcoder.keys.BooleanKey(
      );
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "4mfxf6a6s40/HgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "hWl5mGH3S2/7D9/80y//RbkR9/8AFIgkwp4pAAA=");
}
