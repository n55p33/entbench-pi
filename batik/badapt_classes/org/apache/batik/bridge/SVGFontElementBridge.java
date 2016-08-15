package org.apache.batik.bridge;
public class SVGFontElementBridge extends org.apache.batik.bridge.AbstractSVGBridge {
    public SVGFontElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_FONT_TAG; }
    public org.apache.batik.bridge.SVGGVTFont createFont(org.apache.batik.bridge.BridgeContext ctx,
                                                         org.w3c.dom.Element fontElement,
                                                         org.w3c.dom.Element textElement,
                                                         float size,
                                                         org.apache.batik.gvt.font.GVTFontFace fontFace) {
        org.w3c.dom.NodeList glyphElements =
          fontElement.
          getElementsByTagNameNS(
            SVG_NAMESPACE_URI,
            SVG_GLYPH_TAG);
        int numGlyphs =
          glyphElements.
          getLength(
            );
        java.lang.String[] glyphCodes =
          new java.lang.String[numGlyphs];
        java.lang.String[] glyphNames =
          new java.lang.String[numGlyphs];
        java.lang.String[] glyphLangs =
          new java.lang.String[numGlyphs];
        java.lang.String[] glyphOrientations =
          new java.lang.String[numGlyphs];
        java.lang.String[] glyphForms =
          new java.lang.String[numGlyphs];
        org.w3c.dom.Element[] glyphElementArray =
          new org.w3c.dom.Element[numGlyphs];
        for (int i =
               0;
             i <
               numGlyphs;
             i++) {
            org.w3c.dom.Element glyphElement =
              (org.w3c.dom.Element)
                glyphElements.
                item(
                  i);
            glyphCodes[i] =
              glyphElement.
                getAttributeNS(
                  null,
                  SVG_UNICODE_ATTRIBUTE);
            if (glyphCodes[i].
                  length(
                    ) >
                  1) {
                if (org.apache.batik.gvt.text.ArabicTextHandler.
                      arabicChar(
                        glyphCodes[i].
                          charAt(
                            0))) {
                    glyphCodes[i] =
                      new java.lang.StringBuffer(
                        glyphCodes[i]).
                        reverse(
                          ).
                        toString(
                          );
                }
            }
            glyphNames[i] =
              glyphElement.
                getAttributeNS(
                  null,
                  SVG_GLYPH_NAME_ATTRIBUTE);
            glyphLangs[i] =
              glyphElement.
                getAttributeNS(
                  null,
                  SVG_LANG_ATTRIBUTE);
            glyphOrientations[i] =
              glyphElement.
                getAttributeNS(
                  null,
                  SVG_ORIENTATION_ATTRIBUTE);
            glyphForms[i] =
              glyphElement.
                getAttributeNS(
                  null,
                  SVG_ARABIC_FORM_ATTRIBUTE);
            glyphElementArray[i] =
              glyphElement;
        }
        org.w3c.dom.NodeList missingGlyphElements =
          fontElement.
          getElementsByTagNameNS(
            SVG_NAMESPACE_URI,
            SVG_MISSING_GLYPH_TAG);
        org.w3c.dom.Element missingGlyphElement =
          null;
        if (missingGlyphElements.
              getLength(
                ) >
              0) {
            missingGlyphElement =
              (org.w3c.dom.Element)
                missingGlyphElements.
                item(
                  0);
        }
        org.w3c.dom.NodeList hkernElements =
          fontElement.
          getElementsByTagNameNS(
            SVG_NAMESPACE_URI,
            SVG_HKERN_TAG);
        org.w3c.dom.Element[] hkernElementArray =
          new org.w3c.dom.Element[hkernElements.
                                    getLength(
                                      )];
        for (int i =
               0;
             i <
               hkernElementArray.
                 length;
             i++) {
            org.w3c.dom.Element hkernElement =
              (org.w3c.dom.Element)
                hkernElements.
                item(
                  i);
            hkernElementArray[i] =
              hkernElement;
        }
        org.w3c.dom.NodeList vkernElements =
          fontElement.
          getElementsByTagNameNS(
            SVG_NAMESPACE_URI,
            SVG_VKERN_TAG);
        org.w3c.dom.Element[] vkernElementArray =
          new org.w3c.dom.Element[vkernElements.
                                    getLength(
                                      )];
        for (int i =
               0;
             i <
               vkernElementArray.
                 length;
             i++) {
            org.w3c.dom.Element vkernElement =
              (org.w3c.dom.Element)
                vkernElements.
                item(
                  i);
            vkernElementArray[i] =
              vkernElement;
        }
        return new org.apache.batik.bridge.SVGGVTFont(
          size,
          fontFace,
          glyphCodes,
          glyphNames,
          glyphLangs,
          glyphOrientations,
          glyphForms,
          ctx,
          glyphElementArray,
          missingGlyphElement,
          hkernElementArray,
          vkernElementArray,
          textElement);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "zQsGT+DZIDnyQb762/yVPb7zH6PWaUejFgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
