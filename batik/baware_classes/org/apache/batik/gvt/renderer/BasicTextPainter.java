package org.apache.batik.gvt.renderer;
public abstract class BasicTextPainter implements org.apache.batik.gvt.TextPainter {
    private static org.apache.batik.gvt.text.TextLayoutFactory textLayoutFactory =
      new org.apache.batik.gvt.text.ConcreteTextLayoutFactory(
      );
    protected java.awt.font.FontRenderContext fontRenderContext =
      new java.awt.font.FontRenderContext(
      new java.awt.geom.AffineTransform(
        ),
      true,
      true);
    protected java.awt.font.FontRenderContext aaOffFontRenderContext =
      new java.awt.font.FontRenderContext(
      new java.awt.geom.AffineTransform(
        ),
      false,
      true);
    protected org.apache.batik.gvt.text.TextLayoutFactory getTextLayoutFactory() {
        return textLayoutFactory;
    }
    public org.apache.batik.gvt.text.Mark selectAt(double x,
                                                   double y,
                                                   org.apache.batik.gvt.TextNode node) {
        return hitTest(
                 x,
                 y,
                 node);
    }
    public org.apache.batik.gvt.text.Mark selectTo(double x,
                                                   double y,
                                                   org.apache.batik.gvt.text.Mark beginMark) {
        if (beginMark ==
              null) {
            return null;
        }
        else {
            return hitTest(
                     x,
                     y,
                     beginMark.
                       getTextNode(
                         ));
        }
    }
    public java.awt.geom.Rectangle2D getGeometryBounds(org.apache.batik.gvt.TextNode node) {
        return getOutline(
                 node).
          getBounds2D(
            );
    }
    protected abstract org.apache.batik.gvt.text.Mark hitTest(double x,
                                                              double y,
                                                              org.apache.batik.gvt.TextNode node);
    protected static class BasicMark implements org.apache.batik.gvt.text.Mark {
        private org.apache.batik.gvt.TextNode
          node;
        private org.apache.batik.gvt.text.TextHit
          hit;
        protected BasicMark(org.apache.batik.gvt.TextNode node,
                            org.apache.batik.gvt.text.TextHit hit) {
            super(
              );
            this.
              hit =
              hit;
            this.
              node =
              node;
        }
        public org.apache.batik.gvt.text.TextHit getHit() {
            return hit;
        }
        public org.apache.batik.gvt.TextNode getTextNode() {
            return node;
        }
        public int getCharIndex() { return hit.
                                      getCharIndex(
                                        );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "3D8WXWwu/Qdu1jAvthoAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "O9WN2bBUVCATVNmUqWWc6B1PbnaSNbWm5wMHQwvFdWewwmIeLAa6Nk9DuG6a" +
           "MS3VsaiOEYY2ng1xtqZ1aYOsFSix7qBa1EJrrItR1SHWLDR0moyqGOKwTm2k" +
           "WFKNbOurSdEEa6WmbZDJgC+I9JjseJTBYh1Kx2pVp+MirKfM5Fjtt7VeihKF" +
           "sDeh56axqE95H5abbriwiLXOdhOdpZNG16R0sjUQaXPOWyOjjtaGCjMqMWUX" +
           "b2uFBTNrk16TYo1edQQSF6ZSEqttISSnMpeOZ6OCtFobTMEiEHLlLqINJkUA" +
           "wlKLSbspawmsIehKuQ7WKJBv4J1pqV1vVvt8eTXFO5y8QCzZNDgHHlXa3GqE" +
           "yC3cwZAOKa/9ATsexfxsBVc7qTpn1yvSKSOROreLFseG0UQpEp2akNIwPK9U" +
           "2tM1WgnHDWvOK7A6J9ChTJTkXrM8DpM+2lewkKIJqYqKI0kyOUpf9ygbYxi1" +
           "B5u1VsuSOWMjwsMhvC5QXViKoik1S0yhs7ZqlYmGVUlcQFI+ssrldjyZj5OQ" +
           "qa1KZMSiSqSFPI9TlUrFF2WiUxJxYYh1myQxmceChjktgY3izhAdF9Nep4uy" +
           "ZqEZDlutOK6t24wc07zXxZskLzqrtq6OSjBrF7hSZU52m6iHkAzmEDMLHXdb" +
           "tCTbantVbU6COjpe9GZtV4qIaQ8d4kKVGi47g9TkjHKjgsRkCm9GdEqK2ETD" +
           "w7CGClohUoekIG5CDx+oPMXDJD9A57oplJc9i4utwK7bTHuID7nFIExMrDlm" +
           "0wldYmqUUhRQZiNW3WqStKNVsaEX5/P6Mi2btdG6inqK1yO58lIumdOUb0wX" +
           "i2hcK854AW72as0CXRn1CiuyAeuEgLZoeJZsKDqM9C5HJJqPC8Vm2Ytm9Rqj" +
           "rh2fJGtNWaLtQalGLRa9Mkv1pLmOOF5t5vkoHNFWMKnoRI/aULwkEoyNmBHu" +
           "FmAUA1EKMi9SF6naGGmGVrAuRiYRzJNRRZ2hI0WKHGzTpUZoCstsyPeoEUav" +
           "wuFqja9HhYjCZh3B82xKpee4trLiZZByXQ0lmRllsUarj/TW9bXX5rv+ci54" +
           "G9pBGqlSCgO8MGzUq5XeVPWSqbNYCzN8jmL90dqEyaBQbs6acZdnWtEwhPGk" +
           "3gqLesIty3yjstqkU7C+CXwozyYpR628JAooTjALNXlQKXUK3Sbhahwzj1rL" +
           "hIUHjOSU68qgvsRI0dpgOkp5ZUYqj4puux0lsLuwVWlC23Rntu6vLD1tsHVs" +
           "jCfVEiqmqFxK1C7ctrtrU1TcQUJMEQovrpxpAVM13KigMiwpaH/Ac9S0QrEz" +
           "3cArKHDGsr4eMj5Y1GexKM9Ghr7mEiyVRYJnFauTrnVNVM0OoRBpJaVphZNL" +
           "UXUwRxxu5M9hf7DhXbQvRuhyg1sCLZXgkVsAiYuhhq6asDV02Fu0B5JXjTnV" +
           "QVbIEKateXktLL2C2iqvmUUxmk/xKoJ4dJGdE4JfKNrYYqj7hFGkp0NLsqcT" +
           "YzFoVkpqOtL7rj4RheHULKM8bkw1YjzT/J4yE2pKrMnydOGnRcaBO+M4sj2a" +
           "LA1Bdi+Zo6Y/jxiyAtZusufN50pcaFFqE6+JsdiYdZvKyHCFYo/trbthRWm0" +
           "W3NYWdiGzqJ4bTafbSJ4rETIorEODRdsDN/61mzLuHp1u/Zb8gOKgzs/sFnP" +
           "XrzjVexW42t3uJNV35R3eHjOnB8J3n7y+ujoOfPhYeGp/TOS+65/+ppdm2T7" +
           "93uvdxGY792fe/LpZxXqU8jO3lmsFUJn9+5nD7s7DcQ8ev1DCjK/BD08IPzi" +
           "k/9yz/RtxuOv4ibl/hODPCnyN8nnv9x9o/zRHej0wXHhVdezx5keO35IeMFX" +
           "w8h3pseOCu89sP5dmbHvzSdt+4mvfZtx/fO1+dZtXuGc+4Ov8O4XsuIpYHxd" +
           "zc7M8/O5Qx973w87ETkqLm948kCzu/cPD9+9p9m7f/yaffwV3j2TFb8UQq8B" +
           "mu1fHuTnoYfqffRHUO+2rPF+8Dy1p95TP371fu0V3j2XFZ8MoZuAei0jO7BW" +
           "9g6L9SPosAyh0+beHzBylZ99NSrHIXT+4Cp0P/R3X91dKgjhu6/648b2zwby" +
           "Z5+9eO6uZ9m/zu8QD/4QcJ6AzmmRZR09aT9SP+v5qmbmNji/PXf38q/PXe/m" +
           "aH9oIXRuv5rr8sKW77dD6PZr8QHLgfIo5e+G0KWTlCF0Jv8+SvcHIXThkA7E" +
           "1rZylOSPgHRAklW/4F3j4Hl7RRGfOgKGex6Yz+KtP2wWD1iOXkpmAJr/1WYf" +
           "7KLtn22uyC88Oxi966XKp7aXorIlpmkm5RwB3bi9nz0AzAevK21f1tneIy/f" +
           "/Lnzb9hH9pu3Az6MhiNju//a149t2wvzC8P09+/6nbf8+rPfyM/B/xez5JLY" +
           "AyUAAA==");
    }
    public BasicTextPainter() { super(); }
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
       "uZSa1ZkUfr47/dzdt9wFNfEubPgT3wob8qc25L+lNqwNdV78dE36pXsY4+er" +
       "4p+eG0OuLxH89IWqr38Tqj5VNVYHJ8qpqsq3RtVrFwT/sCb4lXso+GtV8YsA" +
       "mkFu0GYUmFlyGER5aKRnbv/280MJG7w/mQIzqKHtm23ywgy/9E2Y4b1V4wfA" +
       "o56aQX0bZqiBX6yKj//F3X60yr+8h1W+XBW/nkEPOS5AjOOJ7yWv/8bbUXef" +
       "QTevXpGoznifftOFrOMlIv3nXrvx8FOvzf9NfUvg/KLPIzz0sJX7/uUjuUv1" +
       "B+PEtNxa+EeOB3Rx/e9f3w0Pzq5vgNg+q9ai/96R7w8AXN6JL4PuA+Vlyj8E" +
       "+l2lzKAH6v+X6f59Bj16QQeg61i5TPIV0Dsgqapfje9wcnM8y9xfuzR9noZT" +
       "7ZYn3sot5yyXrx1U+FVfoTubHvPjJbqX9S++xo6//+vdnzpee9B9tSyrXh7m" +
       "oYeONzDOp9j33bW3s74eHL34jce+9Mh3nC0HHjsKfBHal2R7/s73Cqggzuqb" +
       "AOUvPfXPvvsfvfZH9UHS/wO2Q/IG2ygAAA==");
}
