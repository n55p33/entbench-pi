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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1cC3AcxZnuXT0sS9bT74f8lB38QAtJbDAyBluWZNlrWWfZ" +
       "qouMkUezI2ns2Z3xTK+0MufjURfwUQnhbAdIAiZXcWKOM4+EoxLuCPFdKgbH" +
       "kCvAzsOu4CN3dXGOOMFHQVIhgfv/7p6d2dmdWVZkb6umZ3a6/+7///p/de/M" +
       "nrhMyiyTzFUStJmOGYrV3Jag3ZJpKbFWTbKs7XCvX36wRHrn1ktdq8OkvI/U" +
       "DEvWFlmylHZV0WJWH2lUExaVErJidSlKDCm6TcVSzBGJqnqij0xVrc64oamy" +
       "SrfoMQUb9EpmlNRLlJrqQJIqnaIDShqjwEmEcRJZ561uiZJJsm6MOc1nuJq3" +
       "umqwZdwZy6KkLrpHGpEiSapqkahq0ZaUSZYbujY2pOm0WUnR5j3aSgHBpujK" +
       "LAgWPl373vv3D9cxCCZLiYROmXjWNsXStRElFiW1zt02TYlb+8hfk5IoqXI1" +
       "pqQpag8agUEjMKgtrdMKuK9WEsl4q87EoXZP5YaMDFGyILMTQzKluOimm/EM" +
       "PVRQITsjBmnnp6XlUmaJ+MXlkSMP3lr3rRJS20dq1UQPsiMDExQG6QNAlfiA" +
       "YlrrYjEl1kfqEzDZPYqpSpq6X8x0g6UOJSSahOm3YcGbSUMx2ZgOVjCPIJuZ" +
       "lKlupsUbZAolvpUNatIQyDrNkZVL2I73QcBKFRgzByXQO0FSuldNxCiZ56VI" +
       "y9i0GRoA6YS4Qof19FClCQlukAauIpqUGIr0gOolhqBpmQ4KaFIyy7dTxNqQ" +
       "5L3SkNKPGulp182roNVEBgSSUDLV24z1BLM0yzNLrvm53LXmvtsSGxNhEgKe" +
       "Y4qsIf9VQDTXQ7RNGVRMBeyAE05aFn1Amvbdg2FCoPFUT2Pe5tt/deXmFXNP" +
       "vsTbzM7RZuvAHkWm/fKxgZpX57QuXV2CbFQYuqXi5GdIzqysW9S0pAzwMNPS" +
       "PWJls115ctupz9zxuPJWmFR2knJZ15Jx0KN6WY8bqqaYHUpCMSWqxDrJRCUR" +
       "a2X1nWQCXEfVhMLvbh0ctBTaSUo1dqtcZ98BokHoAiGqhGs1Majb14ZEh9l1" +
       "yiCEVMNB1sKxkvAPO1OyIzKsx5WIJEsJNaFHuk0d5bci4HEGANvhyABo/d6I" +
       "pSdNUMGIbg5FJNCDYUVUDJhqbEiJ9PR2dPRubweEmlG9jGJ1nEKJJo+GQgD2" +
       "HK+pa2AlG3Utppj98pHk+rYrT/af4WqEqi+woGQhjNXMx2pmYzXzsZqdsUgo" +
       "xIaYgmPyuYSZ2As2DU510tKeXZt2H1xYAkpkjJYCjNh0YUZwaXUM3/bW/fJT" +
       "DdX7F7xx7ffDpDRKGiSZJiUNY8U6cwi8kLxXGOqkAQg7jvef7/L+GLZMXVZi" +
       "4Hz8ooDopUIfUUy8T8kUVw92bEIrjPhHhpz8k5MPjd7Ze/s1YRLOdPg4ZBn4" +
       "KiTvRjeddsdNXkPP1W/tPZfee+qBA7pj8hkRxA58WZQow0KvEnjh6ZeXzZee" +
       "7f/ugSYG+0RwyVQCEwJvN9c7RoZHabG9M8pSAQIP6mZc0rDKxriSDpv6qHOH" +
       "aWc9u54CalGFJjYVDlnYHDtj7TQDy+lcm1HPPFIw739jj/HIT3/0q08xuO1A" +
       "UeuK8D0KbXE5J+ysgbmhekdtt5uKAu1+/lD34S9evmcn01losSjXgE1YtoJT" +
       "gikEmD/70r6fXXzj2Nmwo+cUonNyAJKcVFpIvE8qA4SE0ZY4/IBz08APoNY0" +
       "7UiAfqqDqjSgKWhYf6xdfO2zv76vjuuBBndsNVqRvwPn/sz15I4zt/5uLusm" +
       "JGNwdTBzmnGPPdnpeZ1pSmPIR+rO1xq/9KL0CPh+8LeWul/hLpRhUJ1p62hP" +
       "PckBC+xSjcM0jIho9Mnu3fLBpu7/4pFmZg4C3m7qY5HP9/5kz8tskivQ8vE+" +
       "yl3tsmvwEC4Nq+PgfwifEBwf4IGg4w3u1RtaRWiZn44thpECzpcGJIOZAkQO" +
       "NFzc+/ClJ7gA3tjraawcPHLvh833HeEzxxOURVk5gpuGJylcHCxWI3cLgkZh" +
       "FO2/fOrAvzx24B7OVUNmuG2DbPKJH//p5eaH/uN0Dr8PJqRLPM38NCpz2nVP" +
       "yZwdLtKGv619/v6GknbwGp2kIplQ9yWVzpi7T8iwrOSAa7qc1IfdcAuHUwNR" +
       "ZRnOAt6ZQcnirDA0NEKbBzHSiSjUjllfxrIlrTxMVzmjt1Sd+p71tf/+Fock" +
       "l2p6EqXHjlfIF+KnmGoiL9cxzVjsrxmuwY5+Y9GPbj+66E2At49UqBYEHNDN" +
       "HBmdi+btExffeq268Unmf0tRxQVemalwdqabkcAyVmsd+OqY4WIa28zT2BwT" +
       "OycjJrOVnBMWHn/9unPH/+6BUY5bgGF46Gb8Yas2cNcvfs80LCsK5rAVD31f" +
       "5MTDs1rXvsXonXCE1E2p7KwGEHZoP/l4/N3wwvIfhMmEPlIni5VTr6Ql0cn3" +
       "AYaWvZyC1VVGfWbmz9PclnS4neM1Vtew3kDotoBSmqHt9UYqRJjb/0vW+hOs" +
       "XIbF1WxWwnjZjLaoJiSN0ayGoKIpiSE6zBq3CG+Ap5soKQGtwMsuMfM4wWHe" +
       "la0Jkx1NaNX0hILRwK7jCZyqN6fXcFCZyqEqjRmqsoUpnoP7z2sO/edzTUPr" +
       "C8nc8N7cPLkZfp8Hk77MX/u8rLx41//M2r52eHcBSdg8j0p5u/yHLSdOdyyR" +
       "D4XZMpErRNbyMpOoJVMNKk0F1sOJTNe3yGCnLq4JWCxnc8u+X5OeA8LmgLui" +
       "eEAdW9jsAdWRcZK5TgQ0N7PuYriflzuRaIsblIX+/d+Z/k9rjh99g+U8Rop4" +
       "NQW/trH+N3sKf7cuVhfr2UlsNLDWnekkqgIZrIUjKpKoKI/j/X+2RRTGE9yv" +
       "AUrOiL1OK/YQ3NiiWOxPO+/JCNLop+TmmB5vFjRZRonft3E64VTuDHIqWOzk" +
       "HgWLW7DYhcWBbNeBXyUs5GxfgN8H+bCMGou9AYp2MKDuXizuxsLgnAS0/Vy2" +
       "wuKNpK8WBoGJVWPp4gtsgJUBgx/CYrHlXrBleiLXxl2/fP/Zt6t7337hSlYI" +
       "zFyfbJEMnuHVY7EEs4zp3gX1RskahnafPtl1S5128n2WV1RJMqiatdWElXwq" +
       "YzUjWpdNOP+v35+2+9USEm4nlZDVxSBVwoUhmQgrMsUa1rVYyrjpZm5Lo2hd" +
       "dUxUkiW8L+isYja7OYWrYtpaZ2DD9XBcL6z1Ou+6Tujrw7n1tUQEwXKL7T1y" +
       "xc1cUE23e83ROyWV3es6u7b3d3a1b7WVIMJAQtfSnN5RjrUOQxyQIavqpApb" +
       "0jWl65BsMiM+jMUjfPwHfDFzpJ+Ed2fDcYPg7wYf6Y/nlh4WkRMMUx2BRYlH" +
       "6KqATimpwNS4BxZj+P16D/+PFcj/AjhaxFAtPvw/7QSux7MZ9aMWjGLujt87" +
       "PIx+s0BGF8GxRgy1xofRbwcy6kdNSfWQNmYM70ioMqQiVjqUubj9ToHczofj" +
       "RjHejT7cvhDIrR81KD3jtguSjpysfm8crK4Vg631YfUHgaz6UdusRiWxKPGy" +
       "eqpAVj8Bx01isJt8WH05kFU/akrqGatbTRWChpNHejl+ZRzgiqb8nIPj1wM5" +
       "9qO2wW3XzXhOVs8WyGoTHOvEYOt8WD0fyKoftW1g7vxmzMPthXFwu16Mt96H" +
       "2zcDufWjBm6H9ypmIojbX4yD21YxXqsPt5cCufWjBm5H8nH7qwK5nQvHBjHe" +
       "Bh9ufxvIrR81LGNlyjKhUQ+Pb4/DsNrEKG0+PL4XyKMfNSVVmD248scveHj9" +
       "XYG8XgVHuxit3YfXPwXy6kcNOW9ctSw1MdThMrBcPH8wDlfbIUbtyM1zqDSQ" +
       "Zz9qtK/NoLHA9Hb3DsUS/21Ad/NMuUJl45Bro+Bso49c1YFy+VGjJXoYDU30" +
       "cFtTILdz4OgU43X6cDslkFs/asjOcKMoKQ2lJyBrI9HD/NQCmZ8HxyYx/CYf" +
       "5hsDmfejBhPVnUCN/cz08Dq3QF5nwrFZjLbZh9emQF79qCkps2RJy5WshxYX" +
       "yOUK4tkYycHl8kAu/agBUfw5fYsCEy9btkZcFbgzH3UIPHKtCJCLVwVuXaTZ" +
       "Zh+UPOO3ehfbrOXszF3QBXl/TrBbZv/+zdbWPb0d6UdxcKne6PeMBvsh5thd" +
       "R47Gtn79WvtHhJsprL1142pNGVE0F3+z2PVg5oQugeOwkO2wd0IdUP1m04+U" +
       "tcy5vxFqC6jDJVoI+J8smwosSjOcNCPwbEmXjuhqzJn1dfm0+aNsN3hQqreN" +
       "81kh6rN5UFqeiVJlAKkHCfdm+iouKJa70g28O5+hXlbuCED0M1h0g68dUuhG" +
       "xJN5AQeyvygmZGeE3GcKh8yPNDdkDAsHkFgAILifGOrngPTmAGR3sQBZDMdF" +
       "IdXFwgHxI/WI6qhIaCaTd18AFngzpFEyBbBg6Vsr7j7Aei69tHf2xWuIEETg" +
       "ws+U7PyYm9b4PKE0SiNDih6PdEt0OMp+gLL3xIvZvbMfHhrh5uSFkYdA3kBE" +
       "t9vyRw9mulikN75DY+Pb+BZ8seVUwMZ36K6Aur/B4g6sMTgnAW3v9lPowI1v" +
       "ZjfxYtkNrl3eFTr3buF240eaz24OBcB0BIvPUzLdazdiAw+rkw409xUBGpac" +
       "LAKO63if/BwATXbw9iXNB82jAdD8PRZfpqTWzu23SBSs0XIHtVyRfMKArmuK" +
       "lMinZl8pFpaQCIWWCUCWFY6lH2k+LL8ZgOUzWJygpMG11BBwYs3XHFSeKBYq" +
       "sIIKie31UNbmfH5U/Eg9QpcyRkr3iWVUaKadHy/+SD+l7EsH/hcC0Pw3LJ6j" +
       "/OHB3DD+cxFgnGwr16MCi0fzwJjtw3xJ8ynXKwFw/DsWL2GqLSU2qJahSWMd" +
       "6oiS6OKPErhhOV0sWBqB22eEbM8UDosfaW5Y8nmgUnlYMnNgCe6HAXY+AMw3" +
       "sThHSaUDpgfDHxcBw1obw9MCiNOFY+hH6hG2hP9a6skJ8adHtsnyj7wXfqZk" +
       "6GMmbUAWj4zgo1L4mooalyiuADF72wCX7BkqOz/8/xrKlSv+hk35Bf9c8Td2" +
       "rvjOuHLFK+PMFTlfV/B7UK74h4C6P2Lxe6wxOCcBbT8oNFfcl7lI+7V/32G2" +
       "oPslJTWOPe0wtuv70jk6s6lLxbSp88IwzhduU36kATYFsW62E+tyR7g0dOHq" +
       "AOjwAY9wRR7owhOLCF24kffJzwVB50uaJ9KF5wQgMheL6fkQmVEERGZh3XIQ" +
       "Z7kQa3nhiPiRegT2PIjJH66DhS/fdsQ9x21KIqaY4qE3FP4yQ2dpAHJXY9FE" +
       "ST3fjmNLnV4l/Qpd3v1ZLwEDOu+W88cBWiSc4Xy5ag6g/UhzA42SoEsP1zCk" +
       "bghAcQ0WK3OhiBURB5lVxUTmuBDveOHI+JHm9mc2MqGkA09HADydWKz/CPC0" +
       "FhOe54WMzxcOjx9psOIIx7U9ABn0+OGtHwGZ7iIm6OEfCvF+WDgyfqS+3pxc" +
       "zwSXAkDBZ/TCt0CqDc4M1ivo2RBNZwc3vKsIaDRgHWS64VeFSK8WjoYfaYCw" +
       "iYA6JA6r+GSLQtuluKqN2Uu3mQ4We4qARaNtM+eEQOcCsGBl5iOHEw1Tp6DG" +
       "Sszz0GF1QJ++xuTOiw4EwHU7FiOQBQBcmb8bhq5x8Botlo+5Crj9UMj2YeG6" +
       "40fqEdi1kXLZwYa5HAbCvQEAfQ6Lz+YD6O4iAlRSy/vk54IA8iX1BShckwug" +
       "BwMA+hIWh/IBdLiYAM0RUs4pHCA/Un/DmunAciwAlm9g8Wg+WL5aTFhEjlxS" +
       "eHrtS+pvWDNz6U3ANm74GSxO5AOoGFu47PeTGSDdKiHlqsIB8iMNEDhgFzZ8" +
       "EovnKJkAYKSfIHdQKMYOLIvdoCslok9+LgwFP9IASc8E1L2CxSlKKqieftDJ" +
       "HbZf/HPAkIIkyfkfBXzlakbWP7LwfxGRnzxaWzH96I6f8PdC7X/6mBQlFYNJ" +
       "TXO/ZOi6LjdMZVBl4E2yXzlE5s9RMt3nzStKyvkF8hw+y9v/lJI6b3tKytjZ" +
       "3e4CyOO0g674hbvJG5SUQBO8vMjVIPOpMv6uZYpvms1244ewk7zPl6VJ3K/t" +
       "444N+0cc+52+JP9PnH75qaObum67surr/G8DZE3avx97qYqSCfwfDFin+F7g" +
       "At/e7L7KNy59v+bpiYvtp3zqOcOO6s529IskIdEycMZned6pt5rSr9b/7Nia" +
       "F145WP5amIR2kpBEyeSd2W+lpoykSRp3RrNfy+6VTPayf8vSL4+tXTH42wvs" +
       "PT2S9bavt32/fPb4rtcPzTg2N0yqOkmZmogpKfa67IaxxDZFHjH7SLVqtaWA" +
       "RehFlbSMd75rUDklNBmGi4CzOn0X/3SCkoXZL7xn/1VHpaaPKuZ6PZmIYTfV" +
       "UVLl3OEz43m1MmkYHgLnjphKLDdgsTqFswH62B/dYhj2/wGUnTKYdbaljda7" +
       "RRr+X3aJV+/8H7VJj94tSwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Ng3Lsx7DUF18OCF0TV1BDa8uV2Rbnk6E5aIe2wIs1qFiA4IgD5IViHICnVob" +
       "6/Gmy3NR32Z682AC90UNFvreYNGdjheDsDFrr2ZwPRnhgVNeRrLfZJYrAuI7" +
       "2Gratey1hQuT0rQ/xSsWj6XiBAv6hsxZg07bro+lCbdBe33f8Q2zlE4CqV51" +
       "RXvNBapLDflFC/Nsix6RVj/wh33Cd0Siw+m+mWA2Jo36Qq1ejg2h3w/tOsVI" +
       "ZSfu+3Bs+4kgJ8K6PliSgYf3PMzgRM9firpfEkSeE+aL2JxXPMYuTXlnVDNh" +
       "kdNw1IvNAYloU9aCG/BqBXdaUtpuC6QxHzH2zJzS4YyLRpjVNablTVSqjOfW" +
       "otjU1WWNcP0ZUfb8oSdqTVHjMZMaaFEgU4N40JpioVX1mw3MnQlsbS5SnW5v" +
       "TZDUeLgZWDFj2DaEUexkNCTGoYnajuPVZxZvi/0iNbOWHMXCVgAHoz5XKcl+" +
       "mR+yoUF1sHTYqw9pxFINZG4FwdzErPJS9bFNR2Dnvsd5fn3WTEtanWf6HCfq" +
       "jA3Ppd6C46m0ImjMxGyzRD8WLADBC/mFgLjWyuNpMSKG605AL4UJWSEa8FBC" +
       "B92RtkHXsyFT6nKxJdNp2wB6nxDrllHqjVykPueqQ1ctt7ptqz204iUixoTn" +
       "8z0iKGmMa+k+6tnD6kDsEut1Qx6ntD+skTC3pAdsL7a8crMSuPQEQzWO4zvk" +
       "pFLdlFGSKq03NBms7BpMzuxVFHK9lNYxbaDMq35IqK3JsDOeDRsjujcZUaiy" +
       "RrBSTew6ZcReLWSt0m27bJcfV1ilFkXAlmd2d0azq3C82FCNkRCvEHw5tSF1" +
       "kGqCN6s1hvFsUmkvusN57M+MWk8mNv46nLa4kodsEopmOXbat8JyuSZFsbdp" +
       "bdKY7U/t7qiydPpCudZPSwO6Pp03F74vznHea1Pc1E87QX/U5kdiZVZ2psP2" +
       "DFMnOkWuFnpJitCxyPFuWfYjSWg1UXeJu4jR8/VeWKZEc1GuCpjesspro41N" +
       "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" +
       "RHV24vBtGpJAGNPx4WG35iRBF/jshaC3");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "Eyd1b/VZAAA=");
}
