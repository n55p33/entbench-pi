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
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "vsi5v8kf2e1b/wVv0miA7hYAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL1Za+wj11Wf3U12N9tkd5O2SUjTPLeg1OU/tsce20oLscdj" +
           "e8bj8czYM54x0O143va8H/Z4SqCtCq1aKRSRPoA2n1qBqrZJgQokVBSEgKJW" +
           "SEUVL4m2QkgUlUrNBwoiQLkz/r93N2mLhKUZ37n3nHPPOfec33195jvQ7VEI" +
           "lXzP3hq2F+9paby3tOt78dbXoj2SqjNyGGkqZstRNAV115XHXrjyvZc/ZF49" +
           "C52fQ6+VXdeL5djy3IjTIs9eayoFXTmqxW3NiWLoKrWU1zKcxJYNU1YUP0lB" +
           "rznGGkPXqAMVYKACDFSACxXg9hEVYLpLcxMHyzlkN44C6BegMxR03ldy9WLo" +
           "0ZNCfDmUnX0xTGEBkHAx/xaAUQVzGkKPHNq+s/kGgz9cgp/96Nuv/s456Moc" +
           "umK5k1wdBSgRg07m0J2O5iy0MGqrqqbOobtdTVMnWmjJtpUVes+heyLLcOU4" +
           "CbVDJ+WVia+FRZ9HnrtTyW0LEyX2wkPzdEuz1YOv23VbNoCt9x7ZurOwl9cD" +
           "Ay9ZQLFQlxXtgOW2leWqMfTwaY5DG68NAQFgveBosekddnWbK4MK6J7d2Nmy" +
           "a8CTOLRcA5De7iWglxh64JZCc1/7srKSDe16DN1/mo7ZNQGqOwpH5Cwx9PrT" +
           "ZIUkMEoPnBqlY+PzHfqtz7zTHbhnC51VTbFz/S8CpodOMXGaroWaq2g7xjvf" +
           "TH1EvveL7z8LQYD49aeIdzS///MvPfWWh1780o7mDTehGS+WmhJfVz65uPzV" +
           "B7EnWudyNS76XmTlg3/C8iL8mf2WJ1MfZN69hxLzxr2Dxhe5P5Pe9Wnt22eh" +
           "SwR0XvHsxAFxdLfiOb5la2Ffc7VQjjWVgO7QXBUr2gnoAihTlqvtase6Hmkx" +
           "Ad1mF1XnveIbuEgHInIXXQBly9W9g7Ivx2ZRTn0Igu4ED3Q3eD4L7X7FfwwZ" +
           "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" +
           "hnjUqMHViiDZ0to1rB6BtVsbUTZYS4wrPZ5d+STTCxVGHESl1twnaEHS4rDp" +
           "WdEgAYnfsMdNTRU1ZpPUubW75tdIpHN4DWlzGT40gl7SrlNOj7CICaZIrbbk" +
           "dUfIIrXqekszHbVGzIdEyrPjVBpOWow3GSYq0pX1lV/iSXfbmsrbeqxj8lju" +
           "jAN8KcXSXMKyTEk7wzozaPT99dSgqwmHbVNjZHaZeCROpHmZwmWbNif9NZdK" +
           "IVmx/HmN7BrttOzPA6O2bpYCpr6qM8yAMjy+1OdVi+k7GTVzzNpyUJVaur+d" +
           "lpqU6q3rdUpSE5gyTYGZJnGE6N3uyusrPbIxNum6YbO6tqoTlbBJJL6NLhoJ" +
           "HYmsUHL7Y4+dJXJQ66ClOJ6u44HpTDYjyaVFum0v5sOmPlhOuTVqMgm2gvXu" +
           "Gm126KFlqIJPVzI9YhNRb4wRhJUbVCr62ZqIpPZssBqVRn0chkumCid+tVEt" +
           "9xd0VJJGOOmtUb07mvXVNalWkr7TyLYsjg7qiLZepiRa0/olvo6l07AeJ5tl" +
           "q7Is0yvDHHcdrtJsNSO0YVeVtanE9SVwfzX1ZlG7XE1UW2g3fcqUGp1VIKzX" +
           "m7kfzFjB7UlkgKpwLCM6PB7qy4ZGNYfJpuZMGd+MKIVW11WvpukJYiAVNR1N" +
           "+vP2ggmHvjpSmXUvTLjY91auw6E216orJX2m1wKlQ6Mdcdb0+JpWRjarKlPC" +
           "E8VWe8RoVumMJ16vyaC15WyCdLnSZA4HfSQFU7U6anaJYYJWXH+40TVmvUGX" +
           "1XJ3iFjVLEmT5pzN6PackUKeqiNN3E07ClzFRSXzFzixZIEHTZkvz+3Ndtkh" +
           "/fWsj7GtTmRMRa00hhe8rTOYgXWSTm1JZqPVWufYlm6T+NTYIOg2dLBtiekP" +
           "MHysZVVZXqhVT6jWuG1Xb2w2sES7fq1JhtOwxXfL7VVpWRdhpNHSlj4Ct6LB" +
           "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" +
           "kgH92xYhAAA=");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Lp0NpE4697HX6txTsde7z0RMxcne4+gm");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("GR59Hf/iiwz3Y6/Uf3F39kp15G0RNV5jS1d3x8BOIqSn71nbcV1XqGdefeRX" +
       "H3jPcTT3yE7h/Qg5pdtTdz/n1HHB0j4/mbT9jcd/7QO/9OLXim/L/w8nrGJD" +
       "ci0AAA==");
}
