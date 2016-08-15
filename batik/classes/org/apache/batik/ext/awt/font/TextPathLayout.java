package org.apache.batik.ext.awt.font;
public class TextPathLayout {
    public static final int ALIGN_START = 0;
    public static final int ALIGN_MIDDLE = 1;
    public static final int ALIGN_END = 2;
    public static final int ADJUST_SPACING = 0;
    public static final int ADJUST_GLYPHS = 1;
    public static java.awt.Shape layoutGlyphVector(java.awt.font.GlyphVector glyphs,
                                                   java.awt.Shape path,
                                                   int align,
                                                   float startOffset,
                                                   float textLength,
                                                   int lengthAdjustMode) {
        java.awt.geom.GeneralPath newPath =
          new java.awt.geom.GeneralPath(
          );
        org.apache.batik.ext.awt.geom.PathLength pl =
          new org.apache.batik.ext.awt.geom.PathLength(
          path);
        float pathLength =
          pl.
          lengthOfPath(
            );
        if (glyphs ==
              null) {
            return newPath;
        }
        float glyphsLength =
          (float)
            glyphs.
            getVisualBounds(
              ).
            getWidth(
              );
        if (path ==
              null ||
              glyphs.
              getNumGlyphs(
                ) ==
              0 ||
              pl.
              lengthOfPath(
                ) ==
              0.0F ||
              glyphsLength ==
              0.0F) {
            return newPath;
        }
        float lengthRatio =
          textLength /
          glyphsLength;
        float currentPosition =
          startOffset;
        if (align ==
              ALIGN_END) {
            currentPosition +=
              pathLength -
                textLength;
        }
        else
            if (align ==
                  ALIGN_MIDDLE) {
                currentPosition +=
                  (pathLength -
                     textLength) /
                    2;
            }
        for (int i =
               0;
             i <
               glyphs.
               getNumGlyphs(
                 );
             i++) {
            java.awt.font.GlyphMetrics gm =
              glyphs.
              getGlyphMetrics(
                i);
            float charAdvance =
              gm.
              getAdvance(
                );
            java.awt.Shape glyph =
              glyphs.
              getGlyphOutline(
                i);
            if (lengthAdjustMode ==
                  ADJUST_GLYPHS) {
                java.awt.geom.AffineTransform scale =
                  java.awt.geom.AffineTransform.
                  getScaleInstance(
                    lengthRatio,
                    1.0F);
                glyph =
                  scale.
                    createTransformedShape(
                      glyph);
                charAdvance *=
                  lengthRatio;
            }
            float glyphWidth =
              (float)
                glyph.
                getBounds2D(
                  ).
                getWidth(
                  );
            float charMidPos =
              currentPosition +
              glyphWidth /
              2.0F;
            java.awt.geom.Point2D charMidPoint =
              pl.
              pointAtLength(
                charMidPos);
            if (charMidPoint !=
                  null) {
                float angle =
                  pl.
                  angleAtLength(
                    charMidPos);
                java.awt.geom.AffineTransform glyphTrans =
                  new java.awt.geom.AffineTransform(
                  );
                glyphTrans.
                  translate(
                    charMidPoint.
                      getX(
                        ),
                    charMidPoint.
                      getY(
                        ));
                glyphTrans.
                  rotate(
                    angle);
                glyphTrans.
                  translate(
                    charAdvance /
                      -2.0F,
                    0.0F);
                glyph =
                  glyphTrans.
                    createTransformedShape(
                      glyph);
                newPath.
                  append(
                    glyph,
                    false);
            }
            if (lengthAdjustMode ==
                  ADJUST_SPACING) {
                currentPosition +=
                  charAdvance *
                    lengthRatio;
            }
            else {
                currentPosition +=
                  charAdvance;
            }
        }
        return newPath;
    }
    public static java.awt.Shape layoutGlyphVector(java.awt.font.GlyphVector glyphs,
                                                   java.awt.Shape path,
                                                   int align) {
        return layoutGlyphVector(
                 glyphs,
                 path,
                 align,
                 0.0F,
                 (float)
                   glyphs.
                   getVisualBounds(
                     ).
                   getWidth(
                     ),
                 ADJUST_SPACING);
    }
    public static java.awt.Shape layoutGlyphVector(java.awt.font.GlyphVector glyphs,
                                                   java.awt.Shape path) {
        return layoutGlyphVector(
                 glyphs,
                 path,
                 ALIGN_START);
    }
    public TextPathLayout() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "+T9NDGiJ3x0AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "O5YZiHheIJaUdlGyacStjawpkryczvtxvZc3bHtfF+O+I8XNoFHsxwvXFxsT" +
       "ZbaaRnk27XTxRK/vM3oZoPYsWjS7awz2jWYgJX2iIc+WgtEaj8GGkspJqrFm" +
       "RpTT4OGo7oSDlBlgTl0azDv7oRuQE2WQ+z2f78/ccL0IZmxMoa5RrGdKZu4N" +
       "tM5vR7vNjGmlmNDPd8iqIBlLRnqbdr3JDnQBl8NBrkSOtFq4y20nlylS7xYz" +
       "LOB2yDYfuY7UpTiJn+H2ZGarPX++F1aMqtvIfo8SZlBfULmJuo5oN3VUyRG3" +
       "3Zi0Zd5brb1CjYa9cGxHtD6tD5Rs26BkZ7BAV701N6d3hLascwJlIuSiYXRi" +
       "22frNbpFDYDPuszCslltIk3czkCoM4TGbrbjEefJBp7NMl3aUZjK831SGgRF" +
       "D2+4c1oZzNZWlpPtibOdkaG0wQlkwjhgV+K1GzthJGxDqmVaPK7uVmtcEpGW" +
       "uNVwkKq1GHtjTiIkLvCR5y3QWsOsq2sjGMHLWXs20vutPS9Ou+3GYM43yDkT" +
       "yNbA57o0oTVYOjL8cLxumJjVo02vt9o4hVaDtVTdoXzDG6IaMkCVTUPerjIe" +
       "2GSr5bpBW65347osLHbiIgI7qh3b6XBahx2tsPaqI2csURBoljNrEx6ngttE" +
       "u02t2YxCnQioNl4nLMqJ6viQFXd8JIvcQolXxa4YUWsGF0Z6W3MMbNnGBZqr" +
       "SdxCHnKN1Tx2xySKB65p7cYan2qD/mgxIoBXEGnbsrfNQguEVlwrrHlfoCdD" +
       "bgyGr+ltunUZvstQpr3wZ54kcXs63yNkpzPbbIQNg7mtlk1PgibvZlsF6dP8" +
       "Jg/ZPm2SMTs2Vv2OjXSyOb7T+rnbWxb9GdVeCP1BzyRJoYhyg5/tY08Y8FI2" +
       "Y8dEA4XJpToxbI4dW0kyHO+TttDtjNO2TRJNjfRReDKwJ2LEzRXHpAcLnBGj" +
       "sc8Z++V8t9uZLCGPBo2EGxWCEG9znLW5pTZdql2rtm726yazQcezhbYdzdm1" +
       "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" +
       "vuOff/CnX/2D6mbx/wI3+9CpHSgAAA==");
}
