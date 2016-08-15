package org.apache.batik.transcoder.wmf.tosvg;
public class TextureFactory {
    private static org.apache.batik.transcoder.wmf.tosvg.TextureFactory fac =
      null;
    private java.util.Map textures = new java.util.HashMap(1);
    private static final int SIZE = 10;
    private float scale = 1.0F;
    private TextureFactory(float scale) { super(); }
    public static org.apache.batik.transcoder.wmf.tosvg.TextureFactory getInstance() {
        if (fac ==
              null)
            fac =
              new org.apache.batik.transcoder.wmf.tosvg.TextureFactory(
                1.0F);
        return fac;
    }
    public static org.apache.batik.transcoder.wmf.tosvg.TextureFactory getInstance(float scale) {
        if (fac ==
              null)
            fac =
              new org.apache.batik.transcoder.wmf.tosvg.TextureFactory(
                scale);
        return fac;
    }
    public void reset() { textures.clear(); }
    public java.awt.Paint getTexture(int textureId) { java.lang.Integer _itexture =
                                                        new java.lang.Integer(
                                                        textureId);
                                                      if (textures.
                                                            containsKey(
                                                              _itexture)) {
                                                          java.awt.Paint paint =
                                                            (java.awt.Paint)
                                                              textures.
                                                              get(
                                                                _itexture);
                                                          return paint;
                                                      }
                                                      else {
                                                          java.awt.Paint paint =
                                                            createTexture(
                                                              textureId,
                                                              null,
                                                              null);
                                                          if (paint !=
                                                                null)
                                                              textures.
                                                                put(
                                                                  _itexture,
                                                                  paint);
                                                          return paint;
                                                      }
    }
    public java.awt.Paint getTexture(int textureId,
                                     java.awt.Color foreground) {
        org.apache.batik.transcoder.wmf.tosvg.TextureFactory.ColoredTexture _ctexture =
          new org.apache.batik.transcoder.wmf.tosvg.TextureFactory.ColoredTexture(
          textureId,
          foreground,
          null);
        if (textures.
              containsKey(
                _ctexture)) {
            java.awt.Paint paint =
              (java.awt.Paint)
                textures.
                get(
                  _ctexture);
            return paint;
        }
        else {
            java.awt.Paint paint =
              createTexture(
                textureId,
                foreground,
                null);
            if (paint !=
                  null)
                textures.
                  put(
                    _ctexture,
                    paint);
            return paint;
        }
    }
    public java.awt.Paint getTexture(int textureId,
                                     java.awt.Color foreground,
                                     java.awt.Color background) {
        org.apache.batik.transcoder.wmf.tosvg.TextureFactory.ColoredTexture _ctexture =
          new org.apache.batik.transcoder.wmf.tosvg.TextureFactory.ColoredTexture(
          textureId,
          foreground,
          background);
        if (textures.
              containsKey(
                _ctexture)) {
            java.awt.Paint paint =
              (java.awt.Paint)
                textures.
                get(
                  _ctexture);
            return paint;
        }
        else {
            java.awt.Paint paint =
              createTexture(
                textureId,
                foreground,
                background);
            if (paint !=
                  null)
                textures.
                  put(
                    _ctexture,
                    paint);
            return paint;
        }
    }
    private java.awt.Paint createTexture(int textureId,
                                         java.awt.Color foreground,
                                         java.awt.Color background) {
        java.awt.image.BufferedImage img =
          new java.awt.image.BufferedImage(
          SIZE,
          SIZE,
          java.awt.image.BufferedImage.
            TYPE_INT_ARGB);
        java.awt.Graphics2D g2d =
          img.
          createGraphics(
            );
        java.awt.geom.Rectangle2D rec =
          new java.awt.geom.Rectangle2D.Float(
          0,
          0,
          SIZE,
          SIZE);
        java.awt.Paint paint =
          null;
        boolean ok =
          false;
        if (background !=
              null) {
            g2d.
              setColor(
                background);
            g2d.
              fillRect(
                0,
                0,
                SIZE,
                SIZE);
        }
        if (foreground ==
              null)
            g2d.
              setColor(
                java.awt.Color.
                  black);
        else
            g2d.
              setColor(
                foreground);
        if (textureId ==
              org.apache.batik.transcoder.wmf.WMFConstants.
                HS_VERTICAL) {
            for (int i =
                   0;
                 i <
                   5;
                 i++) {
                g2d.
                  drawLine(
                    i *
                      10,
                    0,
                    i *
                      10,
                    SIZE);
            }
            ok =
              true;
        }
        else
            if (textureId ==
                  org.apache.batik.transcoder.wmf.WMFConstants.
                    HS_HORIZONTAL) {
                for (int i =
                       0;
                     i <
                       5;
                     i++) {
                    g2d.
                      drawLine(
                        0,
                        i *
                          10,
                        SIZE,
                        i *
                          10);
                }
                ok =
                  true;
            }
            else
                if (textureId ==
                      org.apache.batik.transcoder.wmf.WMFConstants.
                        HS_BDIAGONAL) {
                    for (int i =
                           0;
                         i <
                           5;
                         i++) {
                        g2d.
                          drawLine(
                            0,
                            i *
                              10,
                            i *
                              10,
                            0);
                    }
                    ok =
                      true;
                }
                else
                    if (textureId ==
                          org.apache.batik.transcoder.wmf.WMFConstants.
                            HS_FDIAGONAL) {
                        for (int i =
                               0;
                             i <
                               5;
                             i++) {
                            g2d.
                              drawLine(
                                0,
                                i *
                                  10,
                                SIZE -
                                  i *
                                  10,
                                SIZE);
                        }
                        ok =
                          true;
                    }
                    else
                        if (textureId ==
                              org.apache.batik.transcoder.wmf.WMFConstants.
                                HS_DIAGCROSS) {
                            for (int i =
                                   0;
                                 i <
                                   5;
                                 i++) {
                                g2d.
                                  drawLine(
                                    0,
                                    i *
                                      10,
                                    i *
                                      10,
                                    0);
                                g2d.
                                  drawLine(
                                    0,
                                    i *
                                      10,
                                    SIZE -
                                      i *
                                      10,
                                    SIZE);
                            }
                            ok =
                              true;
                        }
                        else
                            if (textureId ==
                                  org.apache.batik.transcoder.wmf.WMFConstants.
                                    HS_CROSS) {
                                for (int i =
                                       0;
                                     i <
                                       5;
                                     i++) {
                                    g2d.
                                      drawLine(
                                        i *
                                          10,
                                        0,
                                        i *
                                          10,
                                        SIZE);
                                    g2d.
                                      drawLine(
                                        0,
                                        i *
                                          10,
                                        SIZE,
                                        i *
                                          10);
                                }
                                ok =
                                  true;
                            }
        img.
          flush(
            );
        if (ok)
            paint =
              new java.awt.TexturePaint(
                img,
                rec);
        return paint;
    }
    private class ColoredTexture {
        final int textureId;
        final java.awt.Color foreground;
        final java.awt.Color background;
        ColoredTexture(int textureId, java.awt.Color foreground,
                       java.awt.Color background) {
            super(
              );
            this.
              textureId =
              textureId;
            this.
              foreground =
              foreground;
            this.
              background =
              background;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "fJFzf4M/sts3/wtoPEza7hYAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "kRYhAAA=");
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
      ("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" +
       "sdfr3FOx13vPREzFrd7j6CYeH52Mf/4l");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("ivmx15o/vbt3Jdvitogar9Glq7srYCcR0tP3rO24riv9Z7/1yC888MxxNPfI" +
       "TuH9CDml21N3v+OEO35U3Era/urjv/TBn3npK8W58v8DTHr3BW4tAAA=");
}
