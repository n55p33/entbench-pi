package org.apache.batik.bridge;
public class SVGAltGlyphHandler implements org.apache.batik.gvt.font.AltGlyphHandler, org.apache.batik.util.SVGConstants {
    private org.apache.batik.bridge.BridgeContext ctx;
    private org.w3c.dom.Element textElement;
    public SVGAltGlyphHandler(org.apache.batik.bridge.BridgeContext ctx, org.w3c.dom.Element textElement) {
        super(
          );
        this.
          ctx =
          ctx;
        this.
          textElement =
          textElement;
    }
    public org.apache.batik.gvt.font.GVTGlyphVector createGlyphVector(java.awt.font.FontRenderContext frc,
                                                                      float fontSize,
                                                                      java.text.AttributedCharacterIterator aci) {
        try {
            if (SVG_NAMESPACE_URI.
                  equals(
                    textElement.
                      getNamespaceURI(
                        )) &&
                  SVG_ALT_GLYPH_TAG.
                  equals(
                    textElement.
                      getLocalName(
                        ))) {
                org.apache.batik.bridge.SVGAltGlyphElementBridge altGlyphBridge =
                  (org.apache.batik.bridge.SVGAltGlyphElementBridge)
                    ctx.
                    getBridge(
                      textElement);
                org.apache.batik.gvt.font.Glyph[] glyphArray =
                  altGlyphBridge.
                  createAltGlyphArray(
                    ctx,
                    textElement,
                    fontSize,
                    aci);
                if (glyphArray !=
                      null) {
                    return new org.apache.batik.gvt.font.SVGGVTGlyphVector(
                      null,
                      glyphArray,
                      frc);
                }
            }
        }
        catch (java.lang.SecurityException e) {
            ctx.
              getUserAgent(
                ).
              displayError(
                e);
            throw e;
        }
        return null;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "EA75JOe+xB/ZcPl/eekVvcYYAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "bxV11v8BmOdRekcjAAA=");
}
