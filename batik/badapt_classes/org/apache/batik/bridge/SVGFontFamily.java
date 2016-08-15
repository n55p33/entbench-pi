package org.apache.batik.bridge;
public class SVGFontFamily implements org.apache.batik.gvt.font.GVTFontFamily {
    public static final java.text.AttributedCharacterIterator.Attribute TEXT_COMPOUND_ID =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        TEXT_COMPOUND_ID;
    protected org.apache.batik.gvt.font.GVTFontFace fontFace;
    protected org.w3c.dom.Element fontElement;
    protected org.apache.batik.bridge.BridgeContext ctx;
    protected java.lang.Boolean complex = null;
    public SVGFontFamily(org.apache.batik.gvt.font.GVTFontFace fontFace,
                         org.w3c.dom.Element fontElement,
                         org.apache.batik.bridge.BridgeContext ctx) {
        super(
          );
        this.
          fontFace =
          fontFace;
        this.
          fontElement =
          fontElement;
        this.
          ctx =
          ctx;
    }
    public java.lang.String getFamilyName() { return fontFace.getFamilyName(
                                                                );
    }
    public org.apache.batik.gvt.font.GVTFontFace getFontFace() { return fontFace;
    }
    public org.apache.batik.gvt.font.GVTFont deriveFont(float size,
                                                        java.text.AttributedCharacterIterator aci) {
        return deriveFont(
                 size,
                 aci.
                   getAttributes(
                     ));
    }
    public org.apache.batik.gvt.font.GVTFont deriveFont(float size,
                                                        java.util.Map attrs) {
        org.apache.batik.bridge.SVGFontElementBridge fontBridge;
        fontBridge =
          (org.apache.batik.bridge.SVGFontElementBridge)
            ctx.
            getBridge(
              fontElement);
        java.lang.ref.SoftReference sr =
          (java.lang.ref.SoftReference)
            attrs.
            get(
              TEXT_COMPOUND_ID);
        org.w3c.dom.Element textElement =
          (org.w3c.dom.Element)
            sr.
            get(
              );
        return fontBridge.
          createFont(
            ctx,
            fontElement,
            textElement,
            size,
            fontFace);
    }
    public boolean isComplex() { if (complex != null)
                                     return complex.
                                       booleanValue(
                                         );
                                 boolean ret = isComplex(
                                                 fontElement,
                                                 ctx);
                                 complex = ret ? java.lang.Boolean.
                                                   TRUE
                                             : java.lang.Boolean.
                                                 FALSE;
                                 return ret; }
    public static boolean isComplex(org.w3c.dom.Element fontElement,
                                    org.apache.batik.bridge.BridgeContext ctx) {
        org.w3c.dom.NodeList glyphElements =
          fontElement.
          getElementsByTagNameNS(
            org.apache.batik.util.SVGConstants.
              SVG_NAMESPACE_URI,
            org.apache.batik.util.SVGConstants.
              SVG_GLYPH_TAG);
        int numGlyphs =
          glyphElements.
          getLength(
            );
        for (int i =
               0;
             i <
               numGlyphs;
             i++) {
            org.w3c.dom.Element glyph =
              (org.w3c.dom.Element)
                glyphElements.
                item(
                  i);
            org.w3c.dom.Node child =
              glyph.
              getFirstChild(
                );
            for (;
                 child !=
                   null;
                 child =
                   child.
                     getNextSibling(
                       )) {
                if (child.
                      getNodeType(
                        ) !=
                      org.w3c.dom.Node.
                        ELEMENT_NODE)
                    continue;
                org.w3c.dom.Element e =
                  (org.w3c.dom.Element)
                    child;
                org.apache.batik.bridge.Bridge b =
                  ctx.
                  getBridge(
                    e);
                if (b !=
                      null &&
                      b instanceof org.apache.batik.bridge.GraphicsNodeBridge) {
                    return true;
                }
            }
        }
        return false;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "PZUbLdFwG/krvjX9F+yCiyL5IgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "PX6Hkylx6dLuppD3j3f0fxKXrp+nB4hZ");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("/J+m+y5w/j0dYLW7OUVy4SAuXQQk+e3F4DYblbsjD5sLp/KVI7coLPzo21n4" +
       "pMvpk1A5WhRHd4/zkYQ5AqU3X8epH/t244u7k1iKI2VZzuUKUbq8OxR2ktM8" +
       "d0dux7wuYS9+5+FfeOCFY9x5eCfw3kVPyfbM7Y899d0gLg4qZf/w8b//Q3/z" +
       "9d8p9k3/H/IGLI9TLQAA");
}
