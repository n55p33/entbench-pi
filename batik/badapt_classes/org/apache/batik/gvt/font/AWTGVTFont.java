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
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "B3ddLUYYPQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Uw/TKNg/K9bc7gI+/saQkpd+pleP+8Thh0M0akbouTJLZxaixuvMmsPuDA5p" +
       "N6O0eL4Udp1+r+3ashZzLM3ME0qIbaemzKutdMfzAh9FSlYnRhNGdNklRdEw" +
       "a7UNZt4QbJ6ekGlz0Okxg4nSzhqcs8B7A2YLEdgkWI1xfpIS67E94xw09QxU" +
       "AccoaXZ2sibUWn5qJWhr42Oblpla4myruvTK8yY4Qns9px1NbGwURe5qy+VJ" +
       "MtlqTLM/RQgraneglJpO8nRDhuLWcphkxLFNhffs3jCU68gcVuV+1a566pit" +
       "CS6vjoJWuqIduceoWjB1ICWQbYOcCLLSl5HmrMu2rWDFV7U1oyu8MqYYlTUM" +
       "QhIE3lwyrqiv0ljV0FHgTGozo9sz2R3alzVUdOe816k2NFqikXi5G65HisBP" +
       "VD7Pp2zCKnwsoCPEAh1P55I37Uq9NF5362I0Xy+zvhdCa9h0dDTsNKmYrkqG" +
       "UM3j6U5wBU6uGqHYUda+Maq5khrX8MVM6ni8zMUs3+pL0k5XlxPVqXaX6nSt" +
       "T1pcs6vGbsfDMXpueup2UVUG+LgfpDlL8d6k488RVNuJkw7vxrWZvyOpJAu2" +
       "1WEc6B2zZfUSFK2zCIJuq8vEqq3khG7GVLw1+ky7D1cJtlPlJ4mgdurw2KSg" +
       "EKmRmdm0Q4ldb7c5FrZXsYLY0nQ5oMWszjLSfKBuOtUemy97Kx7ht6sM5aG+" +
       "oM+nW6sxEdZGP9sKUbAlgxXGt6sdrs0u5k1lmAML1BEpdcVRPchivMeslO62" +
       "QQwDQq1OyXjZaVURKWRWHVIdEetgFak6N+zJHVxbrhl3YNuLrb7Q0WowUqsD" +
       "yahGlEEQSNUdpNPaqL2WVjrZHS2Vvop2WZwZed5AaYz0Oio0660ZanUwLejL" +
       "DCkGeoixLKzi3XCzMsMYqdpMMME6RDZ2q1Oz2l5bvYbotYlA5IXxlBk3XByy" +
       "NmZTgiYGzPERv5MFrwoRAzbi25BOLRLB8hKp1lovJGwy9QM3YCl/O2kkGJMO" +
       "mjqizMmequ8mNuONjIE22kmwYYkbp8VVs7UZrBoamzLLwWIET7e+Q0xcJYrW" +
       "E0WwDbrONFwymS20HYSvaIswJ0AXJ44uULI3MRRGciVTbsIZOqSGHVlqd2SL" +
       "TNWO0ISS2rBGLOFx7nVWRFjfUkyds2d2huFKKq2agW0EMtN3x0avqnJmGMD5" +
       "lKZ2g36XwDrLaicycCWxpBUpBXNER5drYtTkO1ziDOgRvaySc5aJtDQ00Jal" +
       "ESo+kinSMempP2GjcN7sDAkKE1Wovp7yQXc2R8Z6lTJdZKdZG41ZyGaHXfea" +
       "NdQmFnVu2l+zCNnFE2KN0DH4Wc0DZjlbOHSNjOar0VLsqaQyFyJfW1cbDS1K" +
       "oFbILWiZjxUWeD+JFda6oE+rA1O1WsmKwsNu13NrHOpi+TC0J/nKphhusAoH" +
       "LB/rc73t4isMGwuGGSzGFDbocdRQGFqLRne25oMaRcKsRkK5ym7kker1m/3c" +
       "rKsrR5x0bW5iwY3+FIa3wFvkKRZAEOPOR9zA2GzmStutc93xZuSZhq4HycwX" +
       "RbkGJzNVhwYbjtCSag6zeYOh0FZjRtoUj5iCRZH8lthMt4sWD1M4tpwPoHyU" +
       "7ToZOcxYS2jB2ihULHWCYioY7s5iaFbjWifsMtNuyq8Fj1vPq8DC8VYT9uvt" +
       "dWeCdJOAN9lmlZu34Hmt6QAP41W71oSv4xOLaNbD2Ki3uJYJ66jbG2BVg+5F" +
       "XmpgbDdBUsmOo34HC9Cwp80SQVr3dHtuNjeoBje1tKaHNboTbHaCYZMJgeid" +
       "LFtm4tbtteAajlqmuGk3B6zo94fKzuj1h8MQmYxWS55BJu3hionoXdQiRqa/" +
       "sFtENPWVIKAhdjVgBXYpCWwGI1JDwfUd1moNGVEmloyKdN1qbi4UHjK3tQas" +
       "yJrYwMR15jMDftL0KJ9eCpCJJRKeO5Krm3mvGTSc8RCGpV4wURZUlobq1kaZ" +
       "XnfZn+u86wNnSw3USU6vumI2N7a0DmGOIIp9AngYmMTXDSKOjcxbTREkWrTD" +
       "oYBhUOipG4eHB3zibvvNDG1HQ+BkkmHqDWeMTTY9ozkz5t3taN3WQ7yR+rTm" +
       "z6JqTxjPqd2MrffsZCwp9S0iTTdgJr7dhhCu87NuZMLyigMOYsQiqlxf4iPB" +
       "qWZtX7WmJOWobq+XGFOun2/XbaRHj6Q5lg2Gqz5U53CitTb59sJauCg82Ijh" +
       "OoMTq7GJ/LgbqfwaWaOK1jCiXS2fSTbAtGvJUxHRRLKvNHxcrONAE5g6NEhI" +
       "vaH2aUpeMgurKdR4jt2aWIqHzRnmbrmhx9R6Q0XScNmprlFkg1kLJoEarCF6" +
       "c2eBymk7a46Jaoogfb8hLjqiTdfhIBNbS3ycs2Oz2lV69CLeBXN5GdBBTMkL" +
       "TiHiIWqg2S5u9MZOddkWye4sxEiDh6B0BzEoJ4geu+2Pc8tf9pdpb9l1SL87" +
       "BGa3oRdTJHNWTctHVi10IGJag2uxwXLQCtdLfNbp1GAIreI21UDwgQ5NKKwx" +
       "dpGlNxaEGtWtoyYqdaTBBgosDQNzb3bgkc0mKcnSpNbgJiusDtWbfZ2srYJB" +
       "Wp/17VkDW9CLZq8ds4wyJliRW+2yjhwPMXagoNWppKWZP91AQ0eklpRi1TB/" +
       "JASERmK6ISKqqBLYYDzz4jnHV3NPhImZr41mU5AMGK1qN4tmTHMbrWakqLda" +
       "EQbDgRMqNN/wnQZGZ9NBj01njq2YdXHKiVrs9Pmshs0yWJTk1FzhwGo3Nbkq" +
       "pVk2DWS67UynGsIuYiUHmZXR5OygZfFhn4wnxpyCdqsGsjOhVOzZQtZtjpyq" +
       "kW2dFlbH/VkvQZAGR2TsbDRyyB06bcG+ZocLk5uv+vyo2t7MqJaCt6AwQaFa" +
       "g3FanSpDJePamE8SVJp7DjXC7UCBo1yZCsvhoj8VwCRJJ/M4DoOJUJsGiMzZ" +
       "NKTRzRG5WfYkl6kj456uc4g1kWIM9bstTZ3lakuINro5WgUTTtcT0pZGaOyH" +
       "vSGdoQG6wrOmnu5wYdCZdYHs+iZq7eJIUjQ8aMQW6ohwigkZZkA4OZ8MPELS" +
       "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" +
       "jgrmicMxuzQQO4VIQmRcakTVkTmJ+1sG");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
