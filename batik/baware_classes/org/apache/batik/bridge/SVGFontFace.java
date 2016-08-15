package org.apache.batik.bridge;
public class SVGFontFace extends org.apache.batik.bridge.FontFace {
    org.w3c.dom.Element fontFaceElement;
    org.apache.batik.gvt.font.GVTFontFamily fontFamily = null;
    public SVGFontFace(org.w3c.dom.Element fontFaceElement, java.util.List srcs,
                       java.lang.String familyName,
                       float unitsPerEm,
                       java.lang.String fontWeight,
                       java.lang.String fontStyle,
                       java.lang.String fontVariant,
                       java.lang.String fontStretch,
                       float slope,
                       java.lang.String panose1,
                       float ascent,
                       float descent,
                       float strikethroughPosition,
                       float strikethroughThickness,
                       float underlinePosition,
                       float underlineThickness,
                       float overlinePosition,
                       float overlineThickness) { super(srcs, familyName,
                                                        unitsPerEm,
                                                        fontWeight,
                                                        fontStyle,
                                                        fontVariant,
                                                        fontStretch,
                                                        slope,
                                                        panose1,
                                                        ascent,
                                                        descent,
                                                        strikethroughPosition,
                                                        strikethroughThickness,
                                                        underlinePosition,
                                                        underlineThickness,
                                                        overlinePosition,
                                                        overlineThickness);
                                                  this.fontFaceElement = fontFaceElement;
    }
    public org.apache.batik.gvt.font.GVTFontFamily getFontFamily(org.apache.batik.bridge.BridgeContext ctx) {
        if (fontFamily !=
              null)
            return fontFamily;
        org.w3c.dom.Element fontElt =
          org.apache.batik.bridge.SVGUtilities.
          getParentElement(
            fontFaceElement);
        if (fontElt.
              getNamespaceURI(
                ).
              equals(
                SVG_NAMESPACE_URI) &&
              fontElt.
              getLocalName(
                ).
              equals(
                SVG_FONT_TAG)) {
            return new org.apache.batik.bridge.SVGFontFamily(
              this,
              fontElt,
              ctx);
        }
        fontFamily =
          super.
            getFontFamily(
              ctx);
        return fontFamily;
    }
    public org.w3c.dom.Element getFontFaceElement() { return fontFaceElement;
    }
    protected org.w3c.dom.Element getBaseElement(org.apache.batik.bridge.BridgeContext ctx) {
        if (fontFaceElement !=
              null)
            return fontFaceElement;
        return super.
          getBaseElement(
            ctx);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "js9lVzXmrt2FT3Ln2SttLvwXEdGMcgodAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "9lc++nfe/P3q+Pp/A6B13WC4JgAA");
}
