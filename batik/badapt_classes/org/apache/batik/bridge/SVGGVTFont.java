package org.apache.batik.bridge;
public final class SVGGVTFont implements org.apache.batik.gvt.font.GVTFont, org.apache.batik.util.SVGConstants {
    public static final java.text.AttributedCharacterIterator.Attribute PAINT_INFO =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        PAINT_INFO;
    private float fontSize;
    private org.apache.batik.gvt.font.GVTFontFace fontFace;
    private java.lang.String[] glyphUnicodes;
    private java.lang.String[] glyphNames;
    private java.lang.String[] glyphLangs;
    private java.lang.String[] glyphOrientations;
    private java.lang.String[] glyphForms;
    private org.w3c.dom.Element[] glyphElements;
    private org.w3c.dom.Element[] hkernElements;
    private org.w3c.dom.Element[] vkernElements;
    private org.apache.batik.bridge.BridgeContext ctx;
    private org.w3c.dom.Element textElement;
    private org.w3c.dom.Element missingGlyphElement;
    private org.apache.batik.gvt.font.KerningTable hKerningTable;
    private org.apache.batik.gvt.font.KerningTable vKerningTable;
    private java.lang.String language;
    private java.lang.String orientation;
    private float scale;
    private org.apache.batik.gvt.font.GVTLineMetrics lineMetrics =
      null;
    public SVGGVTFont(float fontSize, org.apache.batik.gvt.font.GVTFontFace fontFace,
                      java.lang.String[] glyphUnicodes,
                      java.lang.String[] glyphNames,
                      java.lang.String[] glyphLangs,
                      java.lang.String[] glyphOrientations,
                      java.lang.String[] glyphForms,
                      org.apache.batik.bridge.BridgeContext ctx,
                      org.w3c.dom.Element[] glyphElements,
                      org.w3c.dom.Element missingGlyphElement,
                      org.w3c.dom.Element[] hkernElements,
                      org.w3c.dom.Element[] vkernElements,
                      org.w3c.dom.Element textElement) { super(
                                                           );
                                                         this.
                                                           fontFace =
                                                           fontFace;
                                                         this.
                                                           fontSize =
                                                           fontSize;
                                                         this.
                                                           glyphUnicodes =
                                                           glyphUnicodes;
                                                         this.
                                                           glyphNames =
                                                           glyphNames;
                                                         this.
                                                           glyphLangs =
                                                           glyphLangs;
                                                         this.
                                                           glyphOrientations =
                                                           glyphOrientations;
                                                         this.
                                                           glyphForms =
                                                           glyphForms;
                                                         this.
                                                           ctx =
                                                           ctx;
                                                         this.
                                                           glyphElements =
                                                           glyphElements;
                                                         this.
                                                           missingGlyphElement =
                                                           missingGlyphElement;
                                                         this.
                                                           hkernElements =
                                                           hkernElements;
                                                         this.
                                                           vkernElements =
                                                           vkernElements;
                                                         this.
                                                           scale =
                                                           fontSize /
                                                             fontFace.
                                                             getUnitsPerEm(
                                                               );
                                                         this.
                                                           textElement =
                                                           textElement;
                                                         this.
                                                           language =
                                                           org.apache.batik.dom.util.XMLSupport.
                                                             getXMLLang(
                                                               textElement);
                                                         org.apache.batik.css.engine.value.Value v =
                                                           org.apache.batik.bridge.CSSUtilities.
                                                           getComputedStyle(
                                                             textElement,
                                                             org.apache.batik.css.engine.SVGCSSEngine.
                                                               WRITING_MODE_INDEX);
                                                         if (v.
                                                               getStringValue(
                                                                 ).
                                                               startsWith(
                                                                 CSS_TB_VALUE)) {
                                                             this.
                                                               orientation =
                                                               SVG_V_VALUE;
                                                         }
                                                         else {
                                                             this.
                                                               orientation =
                                                               SVG_H_VALUE;
                                                         }
                                                         createKerningTables(
                                                           );
    }
    private void createKerningTables() { org.apache.batik.gvt.font.Kern[] hEntries =
                                           new org.apache.batik.gvt.font.Kern[hkernElements.
                                                                                length];
                                         for (int i =
                                                0;
                                              i <
                                                hkernElements.
                                                  length;
                                              i++) {
                                             org.w3c.dom.Element hkernElement =
                                               hkernElements[i];
                                             org.apache.batik.bridge.SVGHKernElementBridge hkernBridge =
                                               (org.apache.batik.bridge.SVGHKernElementBridge)
                                                 ctx.
                                                 getBridge(
                                                   hkernElement);
                                             org.apache.batik.gvt.font.Kern hkern =
                                               hkernBridge.
                                               createKern(
                                                 ctx,
                                                 hkernElement,
                                                 this);
                                             hEntries[i] =
                                               hkern;
                                         }
                                         hKerningTable =
                                           new org.apache.batik.gvt.font.KerningTable(
                                             hEntries);
                                         org.apache.batik.gvt.font.Kern[] vEntries =
                                           new org.apache.batik.gvt.font.Kern[vkernElements.
                                                                                length];
                                         for (int i =
                                                0;
                                              i <
                                                vkernElements.
                                                  length;
                                              i++) {
                                             org.w3c.dom.Element vkernElement =
                                               vkernElements[i];
                                             org.apache.batik.bridge.SVGVKernElementBridge vkernBridge =
                                               (org.apache.batik.bridge.SVGVKernElementBridge)
                                                 ctx.
                                                 getBridge(
                                                   vkernElement);
                                             org.apache.batik.gvt.font.Kern vkern =
                                               vkernBridge.
                                               createKern(
                                                 ctx,
                                                 vkernElement,
                                                 this);
                                             vEntries[i] =
                                               vkern;
                                         }
                                         vKerningTable =
                                           new org.apache.batik.gvt.font.KerningTable(
                                             vEntries);
    }
    public float getHKern(int glyphCode1,
                          int glyphCode2) {
        if (glyphCode1 <
              0 ||
              glyphCode1 >=
              glyphUnicodes.
                length ||
              glyphCode2 <
              0 ||
              glyphCode2 >=
              glyphUnicodes.
                length) {
            return 0.0F;
        }
        float ret;
        ret =
          hKerningTable.
            getKerningValue(
              glyphCode1,
              glyphCode2,
              glyphUnicodes[glyphCode1],
              glyphUnicodes[glyphCode2]);
        return ret *
          scale;
    }
    public float getVKern(int glyphCode1,
                          int glyphCode2) {
        if (glyphCode1 <
              0 ||
              glyphCode1 >=
              glyphUnicodes.
                length ||
              glyphCode2 <
              0 ||
              glyphCode2 >=
              glyphUnicodes.
                length) {
            return 0.0F;
        }
        float ret;
        ret =
          vKerningTable.
            getKerningValue(
              glyphCode1,
              glyphCode2,
              glyphUnicodes[glyphCode1],
              glyphUnicodes[glyphCode2]);
        return ret *
          scale;
    }
    public int[] getGlyphCodesForName(java.lang.String name) {
        java.util.List glyphCodes =
          new java.util.ArrayList(
          );
        for (int i =
               0;
             i <
               glyphNames.
                 length;
             i++) {
            if (glyphNames[i] !=
                  null &&
                  glyphNames[i].
                  equals(
                    name)) {
                glyphCodes.
                  add(
                    new java.lang.Integer(
                      i));
            }
        }
        int[] glyphCodeArray =
          new int[glyphCodes.
                    size(
                      )];
        for (int i =
               0;
             i <
               glyphCodes.
               size(
                 );
             i++) {
            glyphCodeArray[i] =
              ((java.lang.Integer)
                 glyphCodes.
                 get(
                   i)).
                intValue(
                  );
        }
        return glyphCodeArray;
    }
    public int[] getGlyphCodesForUnicode(java.lang.String unicode) {
        java.util.List glyphCodes =
          new java.util.ArrayList(
          );
        for (int i =
               0;
             i <
               glyphUnicodes.
                 length;
             i++) {
            if (glyphUnicodes[i] !=
                  null &&
                  glyphUnicodes[i].
                  equals(
                    unicode)) {
                glyphCodes.
                  add(
                    new java.lang.Integer(
                      i));
            }
        }
        int[] glyphCodeArray =
          new int[glyphCodes.
                    size(
                      )];
        for (int i =
               0;
             i <
               glyphCodes.
               size(
                 );
             i++) {
            glyphCodeArray[i] =
              ((java.lang.Integer)
                 glyphCodes.
                 get(
                   i)).
                intValue(
                  );
        }
        return glyphCodeArray;
    }
    private boolean languageMatches(java.lang.String glyphLang) {
        if (glyphLang ==
              null ||
              glyphLang.
              length(
                ) ==
              0) {
            return true;
        }
        java.util.StringTokenizer st =
          new java.util.StringTokenizer(
          glyphLang,
          ",");
        while (st.
                 hasMoreTokens(
                   )) {
            java.lang.String s =
              st.
              nextToken(
                );
            if (s.
                  equals(
                    language) ||
                  s.
                  startsWith(
                    language) &&
                  s.
                  length(
                    ) >
                  language.
                  length(
                    ) &&
                  s.
                  charAt(
                    language.
                      length(
                        )) ==
                  '-') {
                return true;
            }
        }
        return false;
    }
    private boolean orientationMatches(java.lang.String glyphOrientation) {
        if (glyphOrientation ==
              null ||
              glyphOrientation.
              length(
                ) ==
              0) {
            return true;
        }
        return glyphOrientation.
          equals(
            orientation);
    }
    private boolean formMatches(java.lang.String glyphUnicode,
                                java.lang.String glyphForm,
                                java.text.AttributedCharacterIterator aci,
                                int currentIndex) {
        if (aci ==
              null ||
              glyphForm ==
              null ||
              glyphForm.
              length(
                ) ==
              0) {
            return true;
        }
        char c =
          aci.
          setIndex(
            currentIndex);
        java.lang.Integer form =
          (java.lang.Integer)
            aci.
            getAttribute(
              org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                ARABIC_FORM);
        if (form ==
              null ||
              form.
              equals(
                org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                  ARABIC_NONE)) {
            return false;
        }
        if (glyphUnicode.
              length(
                ) >
              1) {
            boolean matched =
              true;
            for (int j =
                   1;
                 j <
                   glyphUnicode.
                   length(
                     );
                 j++) {
                c =
                  aci.
                    next(
                      );
                if (glyphUnicode.
                      charAt(
                        j) !=
                      c) {
                    matched =
                      false;
                    break;
                }
            }
            aci.
              setIndex(
                currentIndex);
            if (matched) {
                aci.
                  setIndex(
                    currentIndex +
                      glyphUnicode.
                      length(
                        ) -
                      1);
                java.lang.Integer lastForm =
                  (java.lang.Integer)
                    aci.
                    getAttribute(
                      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                        ARABIC_FORM);
                aci.
                  setIndex(
                    currentIndex);
                if (form !=
                      null &&
                      lastForm !=
                      null) {
                    if (form.
                          equals(
                            org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                              ARABIC_TERMINAL) &&
                          lastForm.
                          equals(
                            org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                              ARABIC_INITIAL)) {
                        return glyphForm.
                          equals(
                            org.apache.batik.util.SVGConstants.
                              SVG_ISOLATED_VALUE);
                    }
                    else
                        if (form.
                              equals(
                                org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                                  ARABIC_TERMINAL)) {
                            return glyphForm.
                              equals(
                                org.apache.batik.util.SVGConstants.
                                  SVG_TERMINAL_VALUE);
                        }
                        else
                            if (form.
                                  equals(
                                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                                      ARABIC_MEDIAL) &&
                                  lastForm.
                                  equals(
                                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                                      ARABIC_MEDIAL)) {
                                return glyphForm.
                                  equals(
                                    org.apache.batik.util.SVGConstants.
                                      SVG_MEDIAL_VALUE);
                            }
                }
            }
        }
        if (form.
              equals(
                org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                  ARABIC_ISOLATED)) {
            return glyphForm.
              equals(
                org.apache.batik.util.SVGConstants.
                  SVG_ISOLATED_VALUE);
        }
        if (form.
              equals(
                org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                  ARABIC_TERMINAL)) {
            return glyphForm.
              equals(
                org.apache.batik.util.SVGConstants.
                  SVG_TERMINAL_VALUE);
        }
        if (form.
              equals(
                org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                  ARABIC_INITIAL)) {
            return glyphForm.
              equals(
                org.apache.batik.util.SVGConstants.
                  SVG_INITIAL_VALUE);
        }
        if (form.
              equals(
                org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                  ARABIC_MEDIAL)) {
            return glyphForm.
              equals(
                org.apache.batik.util.SVGConstants.
                  SVG_MEDIAL_VALUE);
        }
        return false;
    }
    public boolean canDisplayGivenName(java.lang.String name) {
        for (int i =
               0;
             i <
               glyphNames.
                 length;
             i++) {
            if (glyphNames[i] !=
                  null &&
                  glyphNames[i].
                  equals(
                    name) &&
                  languageMatches(
                    glyphLangs[i]) &&
                  orientationMatches(
                    glyphOrientations[i])) {
                return true;
            }
        }
        return false;
    }
    public boolean canDisplay(char c) { for (int i =
                                               0;
                                             i <
                                               glyphUnicodes.
                                                 length;
                                             i++) {
                                            if (glyphUnicodes[i].
                                                  indexOf(
                                                    c) !=
                                                  -1 &&
                                                  languageMatches(
                                                    glyphLangs[i]) &&
                                                  orientationMatches(
                                                    glyphOrientations[i])) {
                                                return true;
                                            }
                                        }
                                        return false;
    }
    public int canDisplayUpTo(char[] text,
                              int start,
                              int limit) {
        java.text.StringCharacterIterator sci =
          new java.text.StringCharacterIterator(
          new java.lang.String(
            text));
        return canDisplayUpTo(
                 sci,
                 start,
                 limit);
    }
    public int canDisplayUpTo(java.text.CharacterIterator iter,
                              int start,
                              int limit) {
        java.text.AttributedCharacterIterator aci =
          null;
        if (iter instanceof java.text.AttributedCharacterIterator) {
            aci =
              (java.text.AttributedCharacterIterator)
                iter;
        }
        char c =
          iter.
          setIndex(
            start);
        int currentIndex =
          start;
        while (c !=
                 java.text.CharacterIterator.
                   DONE &&
                 currentIndex <
                 limit) {
            boolean foundMatchingGlyph =
              false;
            for (int i =
                   0;
                 i <
                   glyphUnicodes.
                     length;
                 i++) {
                if (glyphUnicodes[i].
                      indexOf(
                        c) ==
                      0 &&
                      languageMatches(
                        glyphLangs[i]) &&
                      orientationMatches(
                        glyphOrientations[i]) &&
                      formMatches(
                        glyphUnicodes[i],
                        glyphForms[i],
                        aci,
                        currentIndex)) {
                    if (glyphUnicodes[i].
                          length(
                            ) ==
                          1) {
                        foundMatchingGlyph =
                          true;
                        break;
                    }
                    else {
                        boolean matched =
                          true;
                        for (int j =
                               1;
                             j <
                               glyphUnicodes[i].
                               length(
                                 );
                             j++) {
                            c =
                              iter.
                                next(
                                  );
                            if (glyphUnicodes[i].
                                  charAt(
                                    j) !=
                                  c) {
                                matched =
                                  false;
                                break;
                            }
                        }
                        if (matched) {
                            foundMatchingGlyph =
                              true;
                            break;
                        }
                        else {
                            c =
                              iter.
                                setIndex(
                                  currentIndex);
                        }
                    }
                }
            }
            if (!foundMatchingGlyph) {
                return currentIndex;
            }
            c =
              iter.
                next(
                  );
            currentIndex =
              iter.
                getIndex(
                  );
        }
        return -1;
    }
    public int canDisplayUpTo(java.lang.String str) {
        java.text.StringCharacterIterator sci =
          new java.text.StringCharacterIterator(
          str);
        return canDisplayUpTo(
                 sci,
                 0,
                 str.
                   length(
                     ));
    }
    public org.apache.batik.gvt.font.GVTGlyphVector createGlyphVector(java.awt.font.FontRenderContext frc,
                                                                      char[] chars) {
        java.text.StringCharacterIterator sci =
          new java.text.StringCharacterIterator(
          new java.lang.String(
            chars));
        return createGlyphVector(
                 frc,
                 sci);
    }
    public org.apache.batik.gvt.font.GVTGlyphVector createGlyphVector(java.awt.font.FontRenderContext frc,
                                                                      java.text.CharacterIterator ci) {
        java.text.AttributedCharacterIterator aci =
          null;
        if (ci instanceof java.text.AttributedCharacterIterator) {
            aci =
              (java.text.AttributedCharacterIterator)
                ci;
        }
        java.util.List glyphs =
          new java.util.ArrayList(
          );
        char c =
          ci.
          first(
            );
        while (c !=
                 java.text.CharacterIterator.
                   DONE) {
            boolean foundMatchingGlyph =
              false;
            for (int i =
                   0;
                 i <
                   glyphUnicodes.
                     length;
                 i++) {
                if (glyphUnicodes[i].
                      indexOf(
                        c) ==
                      0 &&
                      languageMatches(
                        glyphLangs[i]) &&
                      orientationMatches(
                        glyphOrientations[i]) &&
                      formMatches(
                        glyphUnicodes[i],
                        glyphForms[i],
                        aci,
                        ci.
                          getIndex(
                            ))) {
                    if (glyphUnicodes[i].
                          length(
                            ) ==
                          1) {
                        org.w3c.dom.Element glyphElement =
                          glyphElements[i];
                        org.apache.batik.bridge.SVGGlyphElementBridge glyphBridge =
                          (org.apache.batik.bridge.SVGGlyphElementBridge)
                            ctx.
                            getBridge(
                              glyphElement);
                        org.apache.batik.gvt.text.TextPaintInfo tpi =
                          null;
                        if (aci !=
                              null) {
                            tpi =
                              (org.apache.batik.gvt.text.TextPaintInfo)
                                aci.
                                getAttribute(
                                  PAINT_INFO);
                        }
                        org.apache.batik.gvt.font.Glyph glyph =
                          glyphBridge.
                          createGlyph(
                            ctx,
                            glyphElement,
                            textElement,
                            i,
                            fontSize,
                            fontFace,
                            tpi);
                        glyphs.
                          add(
                            glyph);
                        foundMatchingGlyph =
                          true;
                        break;
                    }
                    else {
                        int current =
                          ci.
                          getIndex(
                            );
                        boolean matched =
                          true;
                        for (int j =
                               1;
                             j <
                               glyphUnicodes[i].
                               length(
                                 );
                             j++) {
                            c =
                              ci.
                                next(
                                  );
                            if (glyphUnicodes[i].
                                  charAt(
                                    j) !=
                                  c) {
                                matched =
                                  false;
                                break;
                            }
                        }
                        if (matched) {
                            org.w3c.dom.Element glyphElement =
                              glyphElements[i];
                            org.apache.batik.bridge.SVGGlyphElementBridge glyphBridge =
                              (org.apache.batik.bridge.SVGGlyphElementBridge)
                                ctx.
                                getBridge(
                                  glyphElement);
                            org.apache.batik.gvt.text.TextPaintInfo tpi =
                              null;
                            if (aci !=
                                  null) {
                                aci.
                                  setIndex(
                                    ci.
                                      getIndex(
                                        ));
                                tpi =
                                  (org.apache.batik.gvt.text.TextPaintInfo)
                                    aci.
                                    getAttribute(
                                      PAINT_INFO);
                            }
                            org.apache.batik.gvt.font.Glyph glyph =
                              glyphBridge.
                              createGlyph(
                                ctx,
                                glyphElement,
                                textElement,
                                i,
                                fontSize,
                                fontFace,
                                tpi);
                            glyphs.
                              add(
                                glyph);
                            foundMatchingGlyph =
                              true;
                            break;
                        }
                        else {
                            c =
                              ci.
                                setIndex(
                                  current);
                        }
                    }
                }
            }
            if (!foundMatchingGlyph) {
                org.apache.batik.bridge.SVGGlyphElementBridge glyphBridge =
                  (org.apache.batik.bridge.SVGGlyphElementBridge)
                    ctx.
                    getBridge(
                      missingGlyphElement);
                org.apache.batik.gvt.text.TextPaintInfo tpi =
                  null;
                if (aci !=
                      null) {
                    aci.
                      setIndex(
                        ci.
                          getIndex(
                            ));
                    tpi =
                      (org.apache.batik.gvt.text.TextPaintInfo)
                        aci.
                        getAttribute(
                          PAINT_INFO);
                }
                org.apache.batik.gvt.font.Glyph glyph =
                  glyphBridge.
                  createGlyph(
                    ctx,
                    missingGlyphElement,
                    textElement,
                    -1,
                    fontSize,
                    fontFace,
                    tpi);
                glyphs.
                  add(
                    glyph);
            }
            c =
              ci.
                next(
                  );
        }
        int numGlyphs =
          glyphs.
          size(
            );
        org.apache.batik.gvt.font.Glyph[] glyphArray =
          (org.apache.batik.gvt.font.Glyph[])
            glyphs.
            toArray(
              new org.apache.batik.gvt.font.Glyph[numGlyphs]);
        return new org.apache.batik.gvt.font.SVGGVTGlyphVector(
          this,
          glyphArray,
          frc);
    }
    public org.apache.batik.gvt.font.GVTGlyphVector createGlyphVector(java.awt.font.FontRenderContext frc,
                                                                      int[] glyphCodes,
                                                                      java.text.CharacterIterator ci) {
        int nGlyphs =
          glyphCodes.
            length;
        java.lang.StringBuffer workBuff =
          new java.lang.StringBuffer(
          nGlyphs);
        for (int i =
               0;
             i <
               nGlyphs;
             i++) {
            workBuff.
              append(
                glyphUnicodes[glyphCodes[i]]);
        }
        java.text.StringCharacterIterator sci =
          new java.text.StringCharacterIterator(
          workBuff.
            toString(
              ));
        return createGlyphVector(
                 frc,
                 sci);
    }
    public org.apache.batik.gvt.font.GVTGlyphVector createGlyphVector(java.awt.font.FontRenderContext frc,
                                                                      java.lang.String str) {
        java.text.StringCharacterIterator sci =
          new java.text.StringCharacterIterator(
          str);
        return createGlyphVector(
                 frc,
                 sci);
    }
    public org.apache.batik.gvt.font.GVTFont deriveFont(float size) {
        return new org.apache.batik.bridge.SVGGVTFont(
          size,
          fontFace,
          glyphUnicodes,
          glyphNames,
          glyphLangs,
          glyphOrientations,
          glyphForms,
          ctx,
          glyphElements,
          missingGlyphElement,
          hkernElements,
          vkernElements,
          textElement);
    }
    public java.lang.String getFamilyName() {
        return fontFace.
          getFamilyName(
            );
    }
    protected org.apache.batik.gvt.font.GVTLineMetrics getLineMetrics(int beginIndex,
                                                                      int limit) {
        if (lineMetrics !=
              null)
            return lineMetrics;
        float fontHeight =
          fontFace.
          getUnitsPerEm(
            );
        float scale =
          fontSize /
          fontHeight;
        float ascent =
          fontFace.
          getAscent(
            ) *
          scale;
        float descent =
          fontFace.
          getDescent(
            ) *
          scale;
        float[] baselineOffsets =
          new float[3];
        baselineOffsets[java.awt.Font.
                          ROMAN_BASELINE] =
          0;
        baselineOffsets[java.awt.Font.
                          CENTER_BASELINE] =
          (ascent +
             descent) /
            2 -
            ascent;
        baselineOffsets[java.awt.Font.
                          HANGING_BASELINE] =
          -ascent;
        float stOffset =
          fontFace.
          getStrikethroughPosition(
            ) *
          -scale;
        float stThickness =
          fontFace.
          getStrikethroughThickness(
            ) *
          scale;
        float ulOffset =
          fontFace.
          getUnderlinePosition(
            ) *
          scale;
        float ulThickness =
          fontFace.
          getUnderlineThickness(
            ) *
          scale;
        float olOffset =
          fontFace.
          getOverlinePosition(
            ) *
          -scale;
        float olThickness =
          fontFace.
          getOverlineThickness(
            ) *
          scale;
        lineMetrics =
          new org.apache.batik.gvt.font.GVTLineMetrics(
            ascent,
            java.awt.Font.
              ROMAN_BASELINE,
            baselineOffsets,
            descent,
            fontHeight,
            fontHeight,
            limit -
              beginIndex,
            stOffset,
            stThickness,
            ulOffset,
            ulThickness,
            olOffset,
            olThickness);
        return lineMetrics;
    }
    public org.apache.batik.gvt.font.GVTLineMetrics getLineMetrics(char[] chars,
                                                                   int beginIndex,
                                                                   int limit,
                                                                   java.awt.font.FontRenderContext frc) {
        return getLineMetrics(
                 beginIndex,
                 limit);
    }
    public org.apache.batik.gvt.font.GVTLineMetrics getLineMetrics(java.text.CharacterIterator ci,
                                                                   int beginIndex,
                                                                   int limit,
                                                                   java.awt.font.FontRenderContext frc) {
        return getLineMetrics(
                 beginIndex,
                 limit);
    }
    public org.apache.batik.gvt.font.GVTLineMetrics getLineMetrics(java.lang.String str,
                                                                   java.awt.font.FontRenderContext frc) {
        java.text.StringCharacterIterator sci =
          new java.text.StringCharacterIterator(
          str);
        return getLineMetrics(
                 sci,
                 0,
                 str.
                   length(
                     ),
                 frc);
    }
    public org.apache.batik.gvt.font.GVTLineMetrics getLineMetrics(java.lang.String str,
                                                                   int beginIndex,
                                                                   int limit,
                                                                   java.awt.font.FontRenderContext frc) {
        java.text.StringCharacterIterator sci =
          new java.text.StringCharacterIterator(
          str);
        return getLineMetrics(
                 sci,
                 beginIndex,
                 limit,
                 frc);
    }
    public float getSize() { return fontSize;
    }
    public java.lang.String toString() { return fontFace.
                                           getFamilyName(
                                             ) +
                                         " " +
                                         fontFace.
                                           getFontWeight(
                                             ) +
                                         " " +
                                         fontFace.
                                           getFontStyle(
                                             );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1cC3AcxZnuXT0sS9bT74f8lB38QAtJbDAyBluWZNlrWWfZ" +
       "qouMkUezI2ns2Z3xTK+0MufjURfwUQnhbAdIDsxdxYk5zjwSjkq4I8R3qRgc" +
       "Q64AOw+7wEfu6uIccYKPgqRCAvf/3T07s7M7s6zI3lZNz+x0/93///X/6t6Z" +
       "PXGZlFkmmaskaDMdMxSruS1BuyXTUmKtmmRZ2+Fev/xgifTurZe6VodJeR+p" +
       "GZasLbJkKe2qosWsPtKoJiwqJWTF6lKUGFJ0m4qlmCMSVfVEH5mqWp1xQ1Nl" +
       "lW7RYwo26JXMKKmXKDXVgSRVOkUHlDRGgZMI4ySyzlvdEiWTZN0Yc5rPcDVv" +
       "ddVgy7gzlkVJXXSPNCJFklTVIlHVoi0pkyw3dG1sSNNps5KizXu0lQKCTdGV" +
       "WRAsfLr2/Q/uH65jEEyWEgmdMvGsbYqlayNKLEpqnbttmhK39pG/JCVRUuVq" +
       "TElT1B40AoNGYFBbWqcVcF+tJJLxVp2JQ+2eyg0ZGaJkQWYnhmRKcdFNN+MZ" +
       "eqigQnZGDNLOT0vLpcwS8cvLI0cevLXuWyWkto/UqokeZEcGJigM0geAKvEB" +
       "xbTWxWJKrI/UJ2CyexRTlTR1v5jpBksdSkg0CdNvw4I3k4ZisjEdrGAeQTYz" +
       "KVPdTIs3yBRKfCsb1KQhkHWaIyuXsB3vg4CVKjBmDkqgd4KkdK+aiFEyz0uR" +
       "lrFpMzQA0glxhQ7r6aFKExLcIA1cRTQpMRTpAdVLDEHTMh0U0KRklm+niLUh" +
       "yXulIaUfNdLTrptXQauJDAgkoWSqtxnrCWZplmeWXPNzuWvNfbclNibCJAQ8" +
       "xxRZQ/6rgGiuh2ibMqiYCtgBJ5y0LPqANO27B8OEQOOpnsa8zbf/4srNK+ae" +
       "fIm3mZ2jzdaBPYpM++VjAzWvzmlduroE2agwdEvFyc+QnFlZt6hpSRngYaal" +
       "e8TKZrvy5LZTn7vjceXtMKnsJOWyriXjoEf1sh43VE0xO5SEYkpUiXWSiUoi" +
       "1srqO8kEuI6qCYXf3To4aCm0k5Rq7Fa5zr4DRIPQBUJUCddqYlC3rw2JDrPr" +
       "lEEIqYaDrIVjJeEfdqZkR2RYjysRSZYSakKPdJs6ym9FwOMMALbDkQHQ+r0R" +
       "S0+aoIIR3RyKSKAHw4qoGDDV2JAS6ent6Ojd3g4INaN6GcXqOIUSTR4NhQDs" +
       "OV5T18BKNupaTDH75SPJ9W1Xnuw/w9UIVV9gQclCGKuZj9XMxmrmYzU7Y5FQ" +
       "iA0xBcfkcwkzsRdsGpzqpKU9uzbtPriwBJTIGC0FGLHpwozg0uoYvu2t++Wn" +
       "Gqr3L3jz2u+HSWmUNEgyTUoaxop15hB4IXmvMNRJAxB2HO8/3+X9MWyZuqzE" +
       "wPn4RQHRS4U+oph4n5Iprh7s2IRWGPGPDDn5JycfGr2z9/ZrwiSc6fBxyDLw" +
       "VUjejW467Y6bvIaeq9/aey69/9QDB3TH5DMiiB34sihRhoVeJfDC0y8vmy89" +
       "2//dA00M9ongkqkEJgTebq53jAyP0mJ7Z5SlAgQe1M24pGGVjXElHTb1UecO" +
       "0856dj0F1KIKTWwqHLKwOXbG2mkGltO5NqOeeaRg3v/GHuORn/7ol59hcNuB" +
       "otYV4XsU2uJyTthZA3ND9Y7abjcVBdq98VD34S9fvmcn01losSjXgE1YtoJT" +
       "gikEmD//0r6fXXzz2Nmwo+cUonNyAJKcVFpIvE8qA4SE0ZY4/IBz08APoNY0" +
       "7UiAfqqDqjSgKWhYf6hdfO2zv7qvjuuBBndsNVqRvwPn/sz15I4zt/52Lusm" +
       "JGNwdTBzmnGPPdnpeZ1pSmPIR+rO1xq/8qL0CPh+8LeWul/hLpRhUJ1p62hP" +
       "PckBC+xSjcM0jIho9Onu3fLBpu7/4pFmZg4C3m7qY5Ev9v5kz8tskivQ8vE+" +
       "yl3tsmvwEC4Nq+PgfwSfEBwf4oGg4w3u1RtaRWiZn44thpECzpcGJIOZAkQO" +
       "NFzc+/ClJ7gA3tjraawcPHLvR833HeEzxxOURVk5gpuGJylcHCxWI3cLgkZh" +
       "FO2/eOrAvzx24B7OVUNmuG2DbPKJH//x5eaH/uN0Dr8PJqRLPM38LCpz2nVP" +
       "yZwdLtKGv659/v6GknbwGp2kIplQ9yWVzpi7T8iwrOSAa7qc1IfdcAuHUwNR" +
       "ZRnOAt6ZQcnirDA0NEKbBzHSiSjUjllfxrIlrTxMVzmjt1Sd+p71tf/+Fock" +
       "l2p6EqXHjlfIF+KnmGoiL9cxzVjsrxmuwY5+Y9GPbj+66C2At49UqBYEHNDN" +
       "HBmdi+adExfffq268Unmf0tRxQVemalwdqabkcAyVmsd+OqY4WIa28zT2BwT" +
       "OycjJrOVnBMWHn/9unPH/+aBUY5bgGF46Gb8fqs2cNfPf8c0LCsK5rAVD31f" +
       "5MTDs1rXvs3onXCE1E2p7KwGEHZoP/14/L3wwvIfhMmEPlIni5VTr6Ql0cn3" +
       "AYaWvZyC1VVGfWbmz9PclnS4neM1Vtew3kDotoBSmqHt9UYqRJjb/3PW+lOs" +
       "XIbF1WxWwnjZjLaoJiSN0ayGoKIpiSE6zBq3CG+Ap5soKQGtwMsuMfM4wWHe" +
       "la0Jkx1NaNX0hILRwK7jCZyqN6fXcFCZyqEqjRmqsoUpnoP7GzWH/vO5pqH1" +
       "hWRueG9untwMv8+DSV/mr31eVl68639mbV87vLuAJGyeR6W8Xf7DlhOnO5bI" +
       "h8JsmcgVImt5mUnUkqkGlaYC6+FEputbZLBTF9cELJazuWXfr0nPAWFzwF1R" +
       "PKCOLWz2gOrIOMlcJwKam1l3MdzPy51ItMUNykL//u9M/6c1x4++yXIeI0W8" +
       "moJf21j/mz2Fv1sXq4v17CQ2GljrznQSVYEM1sIRFUlUlMfx/j/ZIgrjCe7X" +
       "ACVnxF6nFXsIbmxRLPannfdkBGn0M3JzTI83C5oso8Tv2zidcCp3BjkVLHZy" +
       "j4LFLVjswuJAtuvArxIWcrYvwO+DfFhGjcXeAEU7GFB3LxZ3Y2FwTgLafiFb" +
       "YfFG0lcLg8DEqrF08SU2wMqAwQ9hsdhyL9gyPZFr465fvv/sO9W977xwJSsE" +
       "Zq5PtkgGz/DqsViCWcZ074J6o2QNQ7vPnuy6pU47+QHLK6okGVTN2mrCSj6V" +
       "sZoRrcsmnP/X70/b/WoJCbeTSsjqYpAq4cKQTIQVmWIN61osZdx0M7elUbSu" +
       "OiYqyRLeF3RWMZvdnMJVMW2tM7DhejiuF9Z6nXddJ/T14dz6WiKCYLnF9h65" +
       "4mYuqKbbvebonZLK7nWdXdv7O7vat9pKEGEgoWtpTu8ox1qHIQ7IkFV1UoUt" +
       "6ZrSdUg2mREfxuIRPv4Dvpg50k/Cu7PhuEHwd4OP9MdzSw+LyAmGqY7AosQj" +
       "dFVAp5RUYGrcA4sx/H69h//HCuR/ARwtYqgWH/6fdgLX49mM+lELRjF3x+8d" +
       "Hka/WSCji+BYI4Za48PotwMZ9aOmpHpIGzOGdyRUGVIRKx3KXNx+p0Bu58Nx" +
       "oxjvRh9uXwjk1o8alJ5x2wVJR05WvzcOVteKwdb6sPqDQFb9qG1Wo5JYlHhZ" +
       "PVUgq5+C4yYx2E0+rL4cyKofNSX1jNWtpgpBw8kjvRy/Mg5wRVN+zsHx64Ec" +
       "+1Hb4LbrZjwnq2cLZLUJjnVisHU+rJ4PZNWP2jYwd34z5uH2wji4XS/GW+/D" +
       "7VuB3PpRA7fDexUzEcTtz8fBbasYr9WH20uB3PpRA7cj+bj9ZYHczoVjgxhv" +
       "gw+3vwnk1o8alrEyZZnQqIfHd8ZhWG1ilDYfHt8P5NGPmpIqzB5c+eOXPLz+" +
       "tkBer4KjXYzW7sPrHwN59aOGnDeuWpaaGOpwGVgunj8ch6vtEKN25OY5VBrI" +
       "sx812tdm0Fhgert7h2KJ/zagu3mmXKGycci1UXC20Ueu6kC5/KjREj2MhiZ6" +
       "uK0pkNs5cHSK8Tp9uJ0SyK0fNWRnuFGUlIbSE5C1kehhfmqBzM+DY5MYfpMP" +
       "842BzPtRg4nqTqDGfmZ6eJ1bIK8z4dgsRtvsw2tTIK9+1JSUWbKk5UrWQ4sL" +
       "5HIF8WyM5OByeSCXftSAKP6cvkWBiZctWyOuCtyZjzoEHrlWBMjFqwK3LtJs" +
       "sw9KnvFbvYtt1nJ25i7ogrw/J9gts3//Zmvrnt6O9KM4uFRv9HtGg/0Qc+yu" +
       "I0djW79+rf0jws0U1t66cbWmjCiai79Z7Howc0KXwHFYyHbYO6EOqH6z6UfK" +
       "Wubc3wi1BdThEi0E/E+WTQUWpRlOmhF4tqRLR3Q15sz6unza/HG2Gzwo1dvG" +
       "+awQ9dk8KC3PRKkygNSDhHszfRUXFMtd6Qbenc9QLyt3BCD6OSy6wdcOKXQj" +
       "4sm8gAPZnxUTsjNC7jOFQ+ZHmhsyhoUDSCwAENxPDPVzQHpzALK7WIAshuOi" +
       "kOpi4YD4kXpEdVQkNJPJuy8AC7wZ0iiZAliw9K0Vdx9gPZde2jv74jVECCJw" +
       "4WdKdn7CTWt8nlAapZEhRY9HuiU6HGU/QNl74sXs3tkPD41wc/LCyEMgbyCi" +
       "2235owczXSzSG9+hsfFtfAu+2HIqYOM7dFdA3V9hcQfWGJyTgLZ3+yl04MY3" +
       "s5t4sewG1y7vCZ17r3C78SPNZzeHAmA6gsUXKZnutRuxgYfVSQea+4oADUtO" +
       "FgHHdbxPfg6AJjt4+5Lmg+bRAGj+HouvUlJr5/ZbJArWaLmDWq5IPmFA1zVF" +
       "SuRTs78tFpaQCIWWCUCWFY6lH2k+LL8ZgOUzWJygpMG11BBwYs3XHFSeKBYq" +
       "sIIKie31UNbmfH5U/Eg9QpcyRkr3iWVUaKadHy/+WD+l7EsH/hcC0Pw3LJ6j" +
       "/OHB3DD+cxFgnGwr16MCi0fzwJjtw3xJ8ynXKwFw/DsWL2GqLSU2qJahSWMd" +
       "6oiS6OKPErhhOV0sWBqB22eEbM8UDosfaW5Y8nmgUnlYMnNgCe6HAXY+AMy3" +
       "sDhHSaUDpgfDHxcBw1obw9MCiNOFY+hH6hG2hP9a6skJ8adHtsnyj7wXfqZk" +
       "6BMmbUAWj4zgo1L4mooalyiuADF72wCX7BkqOz/8/xrKlSv+mk35Bf9c8dd2" +
       "rvjuuHLFK+PMFTlfV/B7UK74+4C6P2DxO6wxOCcBbT8sNFfcl7lI+5V/32G2" +
       "oPsFJTWOPe0wtuv70jk6s6lLxbSp88IwzhduU36kATYFsW62E+tyR7g0dOHq" +
       "AOjwAY9wRR7owhOLCF24kffJzwVB50uaJ9KF5wQgMheL6fkQmVEERGZh3XIQ" +
       "Z7kQa3nhiPiRegT2PIjJH66DhS/fdsQ9x21KIqaY4qE3FP4yQ2dpAHJXY9FE" +
       "ST3fjmNLnV4l/Qpd3v1ZLwEDOu+W8ycBWiSc4Xy5ag6g/UhzA42SoEsP1zCk" +
       "bghAcQ0WK3OhiBURB5lVxUTmuBDveOHI+JHm9mc2MqGkA09HADydWKz/GPC0" +
       "FhOe54WMzxcOjx9psOIIx7U9ABn0+OGtHwOZ7iIm6OEfCvF+WDgyfqS+3pxc" +
       "zwSXAkDBZ/TCt0CqDc4M1ivo2RBNZwc3vKsIaDRgHWS64VeFSK8WjoYfaYCw" +
       "iYA6JA6r+GSLQtuluKqN2Uu3mQ4We4qARaNtM+eEQOcCsGBl5iOHEw1Tp6DG" +
       "Sszz0GF1QJ++xuTOiw4EwHU7FiOQBQBcmb8bhq5x8Botlo+5Crj9SMj2UeG6" +
       "40fqEdi1kXLZwYa5HAbCvQEAfQGLz+cD6O4iAlRSy/vk54IA8iX1BShckwug" +
       "BwMA+goWh/IBdLiYAM0RUs4pHCA/Un/DmunAciwAlm9g8Wg+WP6umLCIHLmk" +
       "8PTal9TfsGbm0puAbdzwM1icyAdQMbZw2e8nM0C6VULKVYUD5EcaIHDALmz4" +
       "JBbPUTIBwEg/Qe6gUIwdWBa7QVdKRJ/8XBgKfqQBkp4JqHsFi1OUVFA9/aCT" +
       "O2y/+KeAIQVJkvM/CvjK1Yysf2Th/yIiP3m0tmL60R0/4e+F2v/0MSlKKgaT" +
       "muZ+ydB1XW6YyqDKwJtkv3KIzJ+jZLrPm1eUlPML5Dl8lrf/KSV13vaUlLGz" +
       "u90FkMdpB13xC3eTNykpgSZ4eZGrQeZTZfxdyxTfNJvtxg9hJ3mfL0uTuF/b" +
       "xx0b9o849jt9Sf6fOP3yU0c3dd12ZdXX+d8GyJq0fz/2UhUlE/g/GLBO8b3A" +
       "Bb692X2Vb1z6Qc3TExfbT/nUc4Yd1Z3t6BdJQqJl4IzP8rxTbzWlX63/2bE1" +
       "L7xysPy1MAntJCGJksk7s99KTRlJkzTujGa/lt0rmexl/5alXx1bu2LwNxfY" +
       "e3ok621fb/t++ezxXa8fmnFsbphUdZIyNRFTUux12Q1jiW2KPGL2kWrVaksB" +
       "i9CLKmkZ73zXoHJKaDIMFwFndfou/ukEJQuzX3jP/quOSk0fVcz1ejIRw26q" +
       "o6TKucNnxvNqZdIwPATOHTGVWG7AYnUKZwP0sT+6xTDs/wMoe8Ng1tmWNlrv" +
       "Fmn4f9klXr37f8nFbsQtSwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "l+4JzbAl84mtj/OOdz7R7bfxF3tYFx898bYnbDXexXyLZM1ffseFCxfe+dyb" +
       "sxbcifbeXJUzL+nCNl0ecSHDcmDyz9BcIiN/aDUf+j99c/6eP/qrvEUvMfYn" +
       "KPOx/CL0sQ8/3Hrhi3n+Q6ub5X4suXQkBA13mBf+qPUXe2+89Zf2CreJhXvl" +
       "nbc9kcwos2UiaJpg3wUHHvlF8Rd7i1vX6LmDUeWR473pSLXH7f2hFoPzLHWu" +
       "JVsTnwVvT84VcgtH5TnekIdPZcE35OLey06fyfQ/a9Q8HwLsp6naerjIE5fy" +
       "e9v2Q8PCTUDhstMXdk2atdzetqj9Jn7gsIlbpmOrmeHbj9sO/IZz4cD3B5HJ" +
       "CTrw7Ok60M0V/LAhfuU9//3h8QuLl65ixH/8WMMeL/LHux/7NPkm+R/tFW46" +
       "aJZLJgYXZ3ru4sa401fBTMYeX9Qkj26bJJfftj2y4Olcwvn1sweSKOSSKORp" +
       "33lG3ItZIIIGlDNRb1vmjOTzJB/1XjgWnG74di5cM//bzeby1M8fWJXbs9LP" +
       "g+MTO6vyia1Vmd8YTzVY62UYaquaFJnhtMl2JRvMiPx9f/hvoJYD4/VAJp64" +
       "Il9QHOtCNmdXd9Pro7qbXbezQNvve+ZZfS8L2G3Hy4JuFvSyQL20h2WXwywY" +
       "X9plsmthW22eOwvecYYmBGfERVngZcFLWyRnpI23GmUcVJoHRh4HnZFvkwWP" +
       "B0e974t7+pFHGi/K7/+tP7178qe/8OVLDP3FzmZXcp87NH5PZH7Dg8enGh0p" +
       "WIB0yKd633Sv+amv5IPyayQZKEfQ98EcJ7nINd2lvuW2z/3iv3v9S5+9qbBH" +
       "FO4EvoICPIDMyy/cAdxrNViA6VHivv0btx0gzrrEvTnVwiXkt033UH714FZb" +
       "DrrSQ1mKJjjqu65UO+6M71TqPSer1E07c37rdqg+olth4U4Oo3rjF6ke0d/X" +
       "ZyjnmXXpC1gIRuN5BEb+1gKYShl4FVSo5i72Uwdx25lAFqZZ8He2VF4+lfYh" +
       "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" +
       "HYGbKRcOdcT2xl6b1CwRVenynGLqKaLo");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "tHdclAevys9Z+yspvMvb4rxtsuBgmf0589qW2YNq89zZ9RnL7M8lZ8Tl6rrO" +
       "Yl7aIjkj7bfulDfPo1yvimdry/5ip+J/8TVS8W8/g817s+DdYeHB4yq+W6Kc" +
       "i+OQ77ddB9/8m7cnAbJ7t3m3/1fD9+SR6RK+33MG3w9kwXeHhfP7K7G6Ugh6" +
       "wYlD021zxzFVyT6kf9nF7JejDwbmc8/u6D/7NaL/T86g/0NZ8P1h4f4jS752" +
       "EshiPnhI9bLL0C9H9XEAareQ/9wlC/mvjerNeYKbc6p5sO9xPX1Fn094B6Pa" +
       "x84Q0cez4CPh9gPuk2XzY9chmwf21eAHd7L5wa9Rr/9XZ3D8uSz4ZOakSXbb" +
       "CFxT2pDGWrV728/mjnL9l9fL9VGA6qd3XH/6hnI90Z2UQavnHH/5DP6fyYJf" +
       "DAt3HvI/RvvfXgft8/u0P72j/ekbQ/um7RTqmOORgwI97tw9u9ry/7CwvE6P" +
       "INuRRopDyLCAlYSysUCGQkPToDFFEG3DV7Ovrjb7/sffYG15C/7K6W7I7+67" +
       "Ib93TW7I71yjG/K7Oa7fya7PckP+6Iy4P86CP8hiXtoiOSPtf91+7XfEVf/t" +
       "M1J/IQv+Q1i451DheXec76TSO1T6z94Ipf/cTg0/d+OVHlj6rz+09Cfb90N5" +
       "/NkZ8vjLLPjS5eTxP2+APPYe3ebd/t8w2+ft2/m9wuk09zLNPfeVy9H86+ug" +
       "me1hUCgCesUdzeKNoXnsS/bH82YHBmL7wCV72jJUbUX1dx9C590lp3zXGeK4" +
       "NwtuCwv3bZ9N5P7uRD3Yu+qyS7mPZ8ikt3f7jZDezlHau2pH6XJz+b27M9H8" +
       "eU7/kTNE81gWPHiSaLKI+w/pPnQj6H5kR/cjN9RGHNA1Dzk/cwbnZ7PgySvg" +
       "/NSN4PxzO84/9zVp4p0xOOOp3R6aBdAV0C3dAJdv79d2dH/txtA9YvYqOZtv" +
       "PINpMwueA+4dMBDArc2sRaYRyCHF56+D4v3ZTTC72fvsjuJnbwzFowzYM+Ky" +
       "IW6PzD6kVENCsgxzs3Pbd/OhnGDnOgg+uq+yv70j+NtXQzAs3OH6TggUS1Wu" +
       "/EHj3uwMxu/IghEYxgDjiz+nOXdEbcfX20ufAai+uqP81RvTpocz1q1n2NsP" +
       "9u7OmalnsM6+V9l76XKspRvA+qbz27zb/xvK+s9PYu2dwTq7uWdejrV1I1g/" +
       "smP9yI1hfUSvsUOuL5/B9V1ZkFyO6+ZGcN25ZzfdIPfs+JOY4y38985g/V1Z" +
       "8Hcvx/rbr/fJ6kOALbpjjd4Y1kdZfPCMuO/LgveHhdsAw4N9MQ6pfc/1Dj6g" +
       "VW/a5d3+31hq//SMuB/Ogg+HhdtDZ7trWK4Ch9x+4Gq4AdW/83BLymx/vYcu" +
       "2dx2uyGr/JOvnr/9wVf5393uwra/aeodbOF2LTLNo3tvHTm/1fVVbbsBzh15" +
       "eI+bk/hoWHjwlP2VwsKt25PcDv34Nv1PhIV7j6cPC7fk/0fTfRzwOUwHitqe" +
       "HE3y02HhJpAkO/3Ednp/8VZs2y3Iku1zhYeO6kD+Bvz+y4n3IMvRTRuz2XK+" +
       "ufD+JlvRdnvhF+WfepXufcuX0R/dbhopm1KaV3M7W7htu39lXmi2UdcbTi1t" +
       "v6xbO2/+yj0fv+Pp/TfW92wBH+rjEWyPn7xDI265Yb6nYvqzD37i+Y+8+vv5" +
       "Z6L/H0fyTIT1WQAA");
}
