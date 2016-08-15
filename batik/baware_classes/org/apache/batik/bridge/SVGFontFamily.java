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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "0FP50RINt5G/4lvTfwEDPNf5+SIAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "afdS8PtHu/p/HJaun68PELP4PV3vu8D4");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("9/UAqd3LqSoXDsLSRVAlf73o3uawcnftIb1wKl45MotCw4++nYZPmpy+DZWj" +
       "RXF99zgeicgjUHrzdWL6Y9+Gv7i7jSWafJblVK6MS5d3F8NOYprn7kjtmNYl" +
       "/MXvPPxzD7xwjDsP7xjem+gp3p65/dWnnuWGxWWl7B89/g9+6G+9/tvF2en/" +
       "A1NsCKZXLQAA");
}
