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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "fwdoiNTfHQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "gDYZKAAA");
}
