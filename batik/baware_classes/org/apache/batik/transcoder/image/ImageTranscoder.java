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
        org.apache.batik.gvt.renderer.ImageRenderer d_renderer =
          createRenderer(
            );
        d_renderer.
          updateOffScreen(
            w,
            h);
        d_renderer.
          setTransform(
            curTxf);
        d_renderer.
          setTree(
            this.
              root);
        java.lang.String recovstr =
          java.lang.System.
          getenv(
            "PANDA_RECOVER");
        boolean recover =
          true;
        if (recovstr !=
              null &&
              recovstr.
              equals(
                "false")) {
            recover =
              false;
        }
        org.apache.batik.gvt.renderer.ImageRenderer renderer =
          null;
        try {
            renderer =
              ent.runtime.ENT_Snapshot.
                snapshot(
                  d_renderer,
                  org.apache.batik.apps.rasterizer.EntMode.
                    LOW_MODE,
                  ent.runtime.ENT_Runtime.
                    getObjMode(
                      this,
                      0),
                  true);
        }
        catch (java.lang.RuntimeException e) {
            if (recover) {
                width =
                  512;
                super.
                  updateTransform(
                    document,
                    uri);
                w =
                  (int)
                    (width +
                       0.5);
                h =
                  (int)
                    (height +
                       0.5);
                d_renderer.
                  setTransform(
                    curTxf);
            }
            renderer =
              ent.runtime.ENT_Snapshot.
                forceSnapshot(
                  d_renderer,
                  org.apache.batik.apps.rasterizer.EntMode.
                    LOW_MODE,
                  ent.runtime.ENT_Runtime.
                    getObjMode(
                      this,
                      0),
                  true);
        }
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
        return (org.apache.batik.gvt.renderer.StaticRenderer)
                 ent.runtime.ENT_Runtime.
                 putObj(
                   new org.apache.batik.gvt.renderer.StaticRenderer(
                     ),
                   new java.lang.Integer[] { org.apache.batik.apps.rasterizer.EntMode.
                                               DYNAMIC_MODE });
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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "hPhZ/B9hFIoQPx4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "qoB6G9/faeNxz11naZ+uJMqmvcEAGSxEZbhIcEOQ6yFOCKvdWsrEyqzpzpL1" +
       "DF8Ptwtqwrt4opr+xLZmwoxEgx5jzBx2bbSkar/L0ytN6Q9FtyIbnLtyxvVu" +
       "1GDwTPaGUdZSV4kh7mbjpca1F0J94HNYi6vFg4UORkmLZNae3SV02lkNbJxt" +
       "d1khra92fUXXhhOnipmNqTICS6m/MEMMq9WktdkmuDwPbAknd+p+O1ybyYKw" +
       "JjMziQYUNVoHS3qC++hwrdVMe9Vik161Nl9jDNqJ+uSMjIbKYhJXmtWdktbQ" +
       "+bi5S6m0HbUMt0NuHLuVbNqNfeABbqKHEjNQFT2LfLoz9hpksjYEIvN1Yruf" +
       "NIJpc64qkdocryuV1UpscQMnc0TddqN+JDk6EYWDRW+3mfiYuvQjv77H2x3c" +
       "jmeGta6gk2g3IceBKUfrQbuN0aKCeeJ4nO7cak/fMSuWc7U86mUm72z8LmPj" +
       "k1QUmyvD4sMlnSnVMIyl6miXTKhePZU3sTDCxzNWrGSz/q4REzitUgS3aC85" +
       "CrOzyN37njCRZhIpD8UFz3edfbfaHqOV0brVaG2NFr9SZUoaNZTFjhlb7Fwc" +
       "5yN/vecS3ugr073HUPFwEAfyRB7sqH2DwuLWao9RwWLPZWNKYRpBlkVcewrG" +
       "PiEt1BETmLRVS/h+JWjOwu0gnw4ZsbqRxq0G5/PNntHWm6Nhs7FpuzWebq3j" +
       "bEvzC9tKNF0idVLrAtZrdJdJG9WclCZrmw0sNGY6tNuqL/AEa0aamxITX9H3" +
       "8niwJczNQKzXtoDS9gI641dLyejQ1SEx1NIZM+52oQ8QTYrorKv6WtwAE5U2" +
       "FahChXNkyl00gsme7WIzsW31qh6dtxRH5h1FDVYTV06X9IhhdZNzMXRCEPaY" +
       "YLloq+dLIW+ojVabcvamjcuDXoAT8SpqqP0eWanFzaWDt9t7ddXMLC9mmqIx" +
       "5Ol5y+676mIZpCLTyxW8OqvZdshI89Z6wXMsrXge2+OcvkSuYclJNYyhPaN6" +
       "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" +
       "/+yd/+QHfuHlPyk34/4fKRFBqqIpAAA=");
}
