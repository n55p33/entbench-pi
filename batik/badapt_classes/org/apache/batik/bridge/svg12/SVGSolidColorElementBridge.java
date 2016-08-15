package org.apache.batik.bridge.svg12;
public class SVGSolidColorElementBridge extends org.apache.batik.bridge.AnimatableGenericSVGBridge implements org.apache.batik.bridge.PaintBridge {
    public SVGSolidColorElementBridge() { super(); }
    public java.lang.String getNamespaceURI() { return org.apache.batik.util.SVG12Constants.
                                                         SVG_NAMESPACE_URI;
    }
    public java.lang.String getLocalName() { return org.apache.batik.util.SVG12Constants.
                                                      SVG_SOLID_COLOR_TAG;
    }
    public java.awt.Paint createPaint(org.apache.batik.bridge.BridgeContext ctx,
                                      org.w3c.dom.Element paintElement,
                                      org.w3c.dom.Element paintedElement,
                                      org.apache.batik.gvt.GraphicsNode paintedNode,
                                      float opacity) {
        opacity =
          extractOpacity(
            paintElement,
            opacity,
            ctx);
        return extractColor(
                 paintElement,
                 opacity,
                 ctx);
    }
    protected static float extractOpacity(org.w3c.dom.Element paintElement,
                                          float opacity,
                                          org.apache.batik.bridge.BridgeContext ctx) {
        java.util.Map refs =
          new java.util.HashMap(
          );
        org.apache.batik.css.engine.CSSEngine eng =
          org.apache.batik.bridge.CSSUtilities.
          getCSSEngine(
            paintElement);
        int pidx =
          eng.
          getPropertyIndex(
            org.apache.batik.util.SVG12CSSConstants.
              CSS_SOLID_OPACITY_PROPERTY);
        for (;
             ;
             ) {
            org.apache.batik.css.engine.value.Value opacityVal =
              org.apache.batik.bridge.CSSUtilities.
              getComputedStyle(
                paintElement,
                pidx);
            org.apache.batik.css.engine.StyleMap sm =
              ((org.apache.batik.css.engine.CSSStylableElement)
                 paintElement).
              getComputedStyleMap(
                null);
            if (!sm.
                  isNullCascaded(
                    pidx)) {
                float attr =
                  org.apache.batik.bridge.PaintServer.
                  convertOpacity(
                    opacityVal);
                return opacity *
                  attr;
            }
            java.lang.String uri =
              org.apache.batik.dom.util.XLinkSupport.
              getXLinkHref(
                paintElement);
            if (uri.
                  length(
                    ) ==
                  0) {
                return opacity;
            }
            org.apache.batik.dom.svg.SVGOMDocument doc =
              (org.apache.batik.dom.svg.SVGOMDocument)
                paintElement.
                getOwnerDocument(
                  );
            org.apache.batik.util.ParsedURL purl =
              new org.apache.batik.util.ParsedURL(
              doc.
                getURL(
                  ),
              uri);
            if (refs.
                  containsKey(
                    purl)) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  paintElement,
                  org.apache.batik.bridge.ErrorConstants.
                    ERR_XLINK_HREF_CIRCULAR_DEPENDENCIES,
                  new java.lang.Object[] { uri });
            }
            refs.
              put(
                purl,
                purl);
            paintElement =
              ctx.
                getReferencedElement(
                  paintElement,
                  uri);
        }
    }
    protected static java.awt.Color extractColor(org.w3c.dom.Element paintElement,
                                                 float opacity,
                                                 org.apache.batik.bridge.BridgeContext ctx) {
        java.util.Map refs =
          new java.util.HashMap(
          );
        org.apache.batik.css.engine.CSSEngine eng =
          org.apache.batik.bridge.CSSUtilities.
          getCSSEngine(
            paintElement);
        int pidx =
          eng.
          getPropertyIndex(
            org.apache.batik.util.SVG12CSSConstants.
              CSS_SOLID_COLOR_PROPERTY);
        for (;
             ;
             ) {
            org.apache.batik.css.engine.value.Value colorDef =
              org.apache.batik.bridge.CSSUtilities.
              getComputedStyle(
                paintElement,
                pidx);
            org.apache.batik.css.engine.StyleMap sm =
              ((org.apache.batik.css.engine.CSSStylableElement)
                 paintElement).
              getComputedStyleMap(
                null);
            if (!sm.
                  isNullCascaded(
                    pidx)) {
                if (colorDef.
                      getCssValueType(
                        ) ==
                      org.w3c.dom.css.CSSValue.
                        CSS_PRIMITIVE_VALUE) {
                    return org.apache.batik.bridge.PaintServer.
                      convertColor(
                        colorDef,
                        opacity);
                }
                else {
                    return org.apache.batik.bridge.PaintServer.
                      convertRGBICCColor(
                        paintElement,
                        colorDef.
                          item(
                            0),
                        (org.apache.batik.css.engine.value.svg.ICCColor)
                          colorDef.
                          item(
                            1),
                        opacity,
                        ctx);
                }
            }
            java.lang.String uri =
              org.apache.batik.dom.util.XLinkSupport.
              getXLinkHref(
                paintElement);
            if (uri.
                  length(
                    ) ==
                  0) {
                return new java.awt.Color(
                  0,
                  0,
                  0,
                  opacity);
            }
            org.apache.batik.dom.svg.SVGOMDocument doc =
              (org.apache.batik.dom.svg.SVGOMDocument)
                paintElement.
                getOwnerDocument(
                  );
            org.apache.batik.util.ParsedURL purl =
              new org.apache.batik.util.ParsedURL(
              doc.
                getURL(
                  ),
              uri);
            if (refs.
                  containsKey(
                    purl)) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  paintElement,
                  org.apache.batik.bridge.ErrorConstants.
                    ERR_XLINK_HREF_CIRCULAR_DEPENDENCIES,
                  new java.lang.Object[] { uri });
            }
            refs.
              put(
                purl,
                purl);
            paintElement =
              ctx.
                getReferencedElement(
                  paintElement,
                  uri);
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
