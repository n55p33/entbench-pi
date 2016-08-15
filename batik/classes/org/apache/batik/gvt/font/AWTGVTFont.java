package org.apache.batik.gvt.font;
public class AWTGVTFont implements org.apache.batik.gvt.font.GVTFont {
    protected java.awt.Font awtFont;
    protected float size;
    protected float scale;
    public AWTGVTFont(java.awt.Font font) { super();
                                            this.size = font.getSize2D();
                                            this.awtFont = font.deriveFont(
                                                                  FONT_SIZE);
                                            this.scale = size / awtFont.getSize2D(
                                                                          );
                                            initializeFontCache(awtFont);
    }
    public AWTGVTFont(java.awt.Font font, float scale) { super();
                                                         this.size =
                                                           font.
                                                             getSize2D(
                                                               ) *
                                                             scale;
                                                         this.awtFont =
                                                           font.
                                                             deriveFont(
                                                               FONT_SIZE);
                                                         this.scale =
                                                           size /
                                                             awtFont.
                                                             getSize2D(
                                                               );
                                                         initializeFontCache(
                                                           awtFont);
    }
    public AWTGVTFont(java.util.Map attributes) { super();
                                                  java.lang.Float sz =
                                                    (java.lang.Float)
                                                      attributes.
                                                      get(
                                                        java.awt.font.TextAttribute.
                                                          SIZE);
                                                  if (sz !=
                                                        null) {
                                                      this.
                                                        size =
                                                        sz.
                                                          floatValue(
                                                            );
                                                      attributes.
                                                        put(
                                                          java.awt.font.TextAttribute.
                                                            SIZE,
                                                          new java.lang.Float(
                                                            FONT_SIZE));
                                                      this.
                                                        awtFont =
                                                        new java.awt.Font(
                                                          attributes);
                                                  }
                                                  else {
                                                      this.
                                                        awtFont =
                                                        new java.awt.Font(
                                                          attributes);
                                                      this.
                                                        size =
                                                        awtFont.
                                                          getSize2D(
                                                            );
                                                  }
                                                  this.
                                                    scale =
                                                    size /
                                                      awtFont.
                                                      getSize2D(
                                                        );
                                                  initializeFontCache(
                                                    awtFont);
    }
    public AWTGVTFont(java.lang.String name, int style,
                      int size) { super();
                                  this.awtFont = new java.awt.Font(
                                                   name,
                                                   style,
                                                   (int)
                                                     FONT_SIZE);
                                  this.size = size;
                                  this.scale = size /
                                                 awtFont.
                                                 getSize2D(
                                                   );
                                  initializeFontCache(
                                    awtFont); }
    public boolean canDisplay(char c) { return awtFont.
                                          canDisplay(
                                            c); }
    public int canDisplayUpTo(char[] text, int start,
                              int limit) { return awtFont.
                                             canDisplayUpTo(
                                               text,
                                               start,
                                               limit);
    }
    public int canDisplayUpTo(java.text.CharacterIterator iter,
                              int start,
                              int limit) { return awtFont.
                                             canDisplayUpTo(
                                               iter,
                                               start,
                                               limit);
    }
    public int canDisplayUpTo(java.lang.String str) {
        return awtFont.
          canDisplayUpTo(
            str);
    }
    public org.apache.batik.gvt.font.GVTGlyphVector createGlyphVector(java.awt.font.FontRenderContext frc,
                                                                      char[] chars) {
        java.text.StringCharacterIterator sci =
          new java.text.StringCharacterIterator(
          new java.lang.String(
            chars));
        java.awt.font.GlyphVector gv =
          awtFont.
          createGlyphVector(
            frc,
            chars);
        return new org.apache.batik.gvt.font.AWTGVTGlyphVector(
          gv,
          this,
          scale,
          sci);
    }
    public org.apache.batik.gvt.font.GVTGlyphVector createGlyphVector(java.awt.font.FontRenderContext frc,
                                                                      java.text.CharacterIterator ci) {
        if (ci instanceof java.text.AttributedCharacterIterator) {
            java.text.AttributedCharacterIterator aci =
              (java.text.AttributedCharacterIterator)
                ci;
            if (org.apache.batik.gvt.text.ArabicTextHandler.
                  containsArabic(
                    aci)) {
                java.lang.String str =
                  org.apache.batik.gvt.text.ArabicTextHandler.
                  createSubstituteString(
                    aci);
                return createGlyphVector(
                         frc,
                         str);
            }
        }
        java.awt.font.GlyphVector gv =
          awtFont.
          createGlyphVector(
            frc,
            ci);
        return new org.apache.batik.gvt.font.AWTGVTGlyphVector(
          gv,
          this,
          scale,
          ci);
    }
    public org.apache.batik.gvt.font.GVTGlyphVector createGlyphVector(java.awt.font.FontRenderContext frc,
                                                                      int[] glyphCodes,
                                                                      java.text.CharacterIterator ci) {
        return new org.apache.batik.gvt.font.AWTGVTGlyphVector(
          awtFont.
            createGlyphVector(
              frc,
              glyphCodes),
          this,
          scale,
          ci);
    }
    public org.apache.batik.gvt.font.GVTGlyphVector createGlyphVector(java.awt.font.FontRenderContext frc,
                                                                      java.lang.String str) {
        java.text.StringCharacterIterator sci =
          new java.text.StringCharacterIterator(
          str);
        return new org.apache.batik.gvt.font.AWTGVTGlyphVector(
          awtFont.
            createGlyphVector(
              frc,
              str),
          this,
          scale,
          sci);
    }
    public org.apache.batik.gvt.font.GVTFont deriveFont(float size) {
        return new org.apache.batik.gvt.font.AWTGVTFont(
          awtFont,
          size /
            this.
              size);
    }
    public java.lang.String getFamilyName() {
        return awtFont.
          getFamily(
            );
    }
    public org.apache.batik.gvt.font.GVTLineMetrics getLineMetrics(char[] chars,
                                                                   int beginIndex,
                                                                   int limit,
                                                                   java.awt.font.FontRenderContext frc) {
        return new org.apache.batik.gvt.font.GVTLineMetrics(
          awtFont.
            getLineMetrics(
              chars,
              beginIndex,
              limit,
              frc),
          scale);
    }
    public org.apache.batik.gvt.font.GVTLineMetrics getLineMetrics(java.text.CharacterIterator ci,
                                                                   int beginIndex,
                                                                   int limit,
                                                                   java.awt.font.FontRenderContext frc) {
        return new org.apache.batik.gvt.font.GVTLineMetrics(
          awtFont.
            getLineMetrics(
              ci,
              beginIndex,
              limit,
              frc),
          scale);
    }
    public org.apache.batik.gvt.font.GVTLineMetrics getLineMetrics(java.lang.String str,
                                                                   java.awt.font.FontRenderContext frc) {
        return new org.apache.batik.gvt.font.GVTLineMetrics(
          awtFont.
            getLineMetrics(
              str,
              frc),
          scale);
    }
    public org.apache.batik.gvt.font.GVTLineMetrics getLineMetrics(java.lang.String str,
                                                                   int beginIndex,
                                                                   int limit,
                                                                   java.awt.font.FontRenderContext frc) {
        return new org.apache.batik.gvt.font.GVTLineMetrics(
          awtFont.
            getLineMetrics(
              str,
              beginIndex,
              limit,
              frc),
          scale);
    }
    public float getSize() { return size;
    }
    public float getHKern(int glyphCode1,
                          int glyphCode2) {
        return 0.0F;
    }
    public float getVKern(int glyphCode1,
                          int glyphCode2) {
        return 0.0F;
    }
    public static final float FONT_SIZE =
      48.0F;
    public static org.apache.batik.gvt.font.AWTGlyphGeometryCache.Value getGlyphGeometry(org.apache.batik.gvt.font.AWTGVTFont font,
                                                                                         char c,
                                                                                         java.awt.font.GlyphVector gv,
                                                                                         int glyphIndex,
                                                                                         java.awt.geom.Point2D glyphPos) {
        org.apache.batik.gvt.font.AWTGlyphGeometryCache glyphCache =
          (org.apache.batik.gvt.font.AWTGlyphGeometryCache)
            fontCache.
            get(
              font.
                awtFont);
        org.apache.batik.gvt.font.AWTGlyphGeometryCache.Value v =
          glyphCache.
          get(
            c);
        if (v ==
              null) {
            java.awt.Shape outline =
              gv.
              getGlyphOutline(
                glyphIndex);
            java.awt.font.GlyphMetrics metrics =
              gv.
              getGlyphMetrics(
                glyphIndex);
            java.awt.geom.Rectangle2D gmB =
              metrics.
              getBounds2D(
                );
            if (org.apache.batik.gvt.font.AWTGVTGlyphVector.
                  outlinesPositioned(
                    )) {
                java.awt.geom.AffineTransform tr =
                  java.awt.geom.AffineTransform.
                  getTranslateInstance(
                    -glyphPos.
                      getX(
                        ),
                    -glyphPos.
                      getY(
                        ));
                outline =
                  tr.
                    createTransformedShape(
                      outline);
            }
            v =
              new org.apache.batik.gvt.font.AWTGlyphGeometryCache.Value(
                outline,
                gmB);
            glyphCache.
              put(
                c,
                v);
        }
        return v;
    }
    static java.util.Map fontCache = new java.util.HashMap(
      11);
    static void initializeFontCache(java.awt.Font awtFont) {
        if (!fontCache.
              containsKey(
                awtFont)) {
            fontCache.
              put(
                awtFont,
                new org.apache.batik.gvt.font.AWTGlyphGeometryCache(
                  ));
        }
    }
    static void putAWTGVTFont(org.apache.batik.gvt.font.AWTGVTFont font) {
        fontCache.
          put(
            font.
              awtFont,
            font);
    }
    static org.apache.batik.gvt.font.AWTGVTFont getAWTGVTFont(java.awt.Font awtFont) {
        return (org.apache.batik.gvt.font.AWTGVTFont)
                 fontCache.
                 get(
                   awtFont);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "A35lfwoYPQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "yqmHoRfsnxVrbncBH39tSMlLP9urx33i8DNAVGpOaLk8T+cmosTrzFzA7hwO" +
       "aTej1Hix4nedfq/tWpIaD1iaWSQUH1t2TV5UW+mO43guiuSsToynjOCyK4qi" +
       "YdZs68yiwVscPSXT5rDTY4ZTuZ01BvYS7w2ZLURg08CZ4Nw0JdYTaz6w0dTT" +
       "URkc46TZ2UkqX2v5qZmgrY2PbVpGagrzreLSjudNcYT2enY7mlrYOIpcZzvI" +
       "k2S6VZlmf4YQZtTuQCk1m+bphgyFrWkzyXjANmXOs3qjUKojC1iR+lWr6ikT" +
       "tsa7nDIOWqlD21KPUdRgZkNyIFk6OeUluS8hzXmXbZuBw1XVNaPJnDyhGIXV" +
       "dULkec5YMa6gOWmsqOg4sKe1ud7tGewO7UsqKrgLzutUGyot0ki82o3WY5nn" +
       "pgqX5zM2YWUu5tExYoKOZwvRm3XFXhqvu3UhWqxXWd8LoTVs2BoadppUTFdF" +
       "na/m8WzHu/xAquqh0JHXvj6uuaIS1/DlXOx4nDSIWa7VF8Wdpqymil3trpTZ" +
       "Wpu2Bs2uErsdD8foheEp22VVHuKTfpDmLMV5046/QFB1J0w7nBvX5v6OpJIs" +
       "2FZHcaB1jJbZS1C0ziIIuq2uErPmSAndjKl4q/eZdh+uEmynyk0TXunU4YlB" +
       "QSFSIzOjaYUiu95ucyxsO7GMWOJsNaSFrM4y4mKobDrVHpuveg6HcFsnQzmo" +
       "z2uL2dZsTPm13s+2fBRsycDBuHa1M2izy0VTHuXAAjVETF1hXA+yGO8xjtzd" +
       "NohRQCjVGRmvOq0qIoaM0yGVMbEOnEjRBqOe1MHV1Zpxh5a13GpLDa0GY6U6" +
       "FPVqROkEgVTdYTqrjdtr0dHI7ngl9xW0y+LM2POGcmOs1VG+WW/NUbODqUFf" +
       "Ykgh0EKMZWEF74YbxwhjpGoxwRTrENnErc6Mantt9hqC1yYCgeMnM2bScHHI" +
       "3BhNEZrq8ICLuJ3Ee1WIGLIR14Y0apnwppeItdZ6KWLTmR+4AUv522kjwZh0" +
       "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" +
       "HQXME0cTdqUjVgqRhMC41JiqIwsS97cM");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
