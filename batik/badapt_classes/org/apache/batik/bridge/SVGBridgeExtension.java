package org.apache.batik.bridge;
public class SVGBridgeExtension implements org.apache.batik.bridge.BridgeExtension {
    public float getPriority() { return 0.0F; }
    public java.util.Iterator getImplementedExtensions() { return java.util.Collections.
                                                                    EMPTY_LIST.
                                                             iterator(
                                                               );
    }
    public java.lang.String getAuthor() { return "The Apache Batik Team.";
    }
    public java.lang.String getContactAddress() { return "batik-dev@xmlgraphics.apache.org";
    }
    public java.lang.String getURL() { return "http://xml.apache.org/batik";
    }
    public java.lang.String getDescription() { return "The required SVG 1.0 tags";
    }
    public void registerTags(org.apache.batik.bridge.BridgeContext ctx) {
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGAElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGAltGlyphElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGCircleElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGClipPathElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGColorProfileElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGDescElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGEllipseElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeBlendElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeColorMatrixElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeComponentTransferElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeCompositeElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeComponentTransferElementBridge.SVGFeFuncAElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeComponentTransferElementBridge.SVGFeFuncRElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeComponentTransferElementBridge.SVGFeFuncGElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeComponentTransferElementBridge.SVGFeFuncBElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeConvolveMatrixElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeDiffuseLightingElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeDisplacementMapElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.AbstractSVGLightingElementBridge.SVGFeDistantLightElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeFloodElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeGaussianBlurElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeImageElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeMergeElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeMergeElementBridge.SVGFeMergeNodeElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeMorphologyElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeOffsetElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.AbstractSVGLightingElementBridge.SVGFePointLightElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeSpecularLightingElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.AbstractSVGLightingElementBridge.SVGFeSpotLightElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeTileElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFeTurbulenceElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFontElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFontFaceElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGFilterElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGGElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGGlyphElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGHKernElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGImageElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGLineElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGLinearGradientElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGMarkerElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGMaskElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGMissingGlyphElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGPathElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGPatternElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGPolylineElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGPolygonElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGRadialGradientElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGRectElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.AbstractSVGGradientElementBridge.SVGStopElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGSVGElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGSwitchElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGTextElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGTextPathElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGTitleElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGUseElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGVKernElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGSetElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGAnimateElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGAnimateColorElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGAnimateTransformElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.SVGAnimateMotionElementBridge(
              ));
    }
    public boolean isDynamicElement(org.w3c.dom.Element e) {
        java.lang.String ns =
          e.
          getNamespaceURI(
            );
        if (!org.apache.batik.util.SVGConstants.
               SVG_NAMESPACE_URI.
              equals(
                ns)) {
            return false;
        }
        java.lang.String ln =
          e.
          getLocalName(
            );
        if (ln.
              equals(
                org.apache.batik.util.SVGConstants.
                  SVG_SCRIPT_TAG) ||
              ln.
              startsWith(
                "animate") ||
              ln.
              equals(
                org.apache.batik.util.SVGConstants.
                  SVG_SET_TAG)) {
            return true;
        }
        return false;
    }
    public SVGBridgeExtension() { super();
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
