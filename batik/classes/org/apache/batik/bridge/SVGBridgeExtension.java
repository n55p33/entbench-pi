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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "UGbsQWzuhwIR8Lh2IBoA4dhMgbAcngFHkoHpg1CKtYygj5UZewKbX3HSCCBc" +
       "zWzFUk23MveB8cgMgFGPYxF4djkS7Zo+GKVYAwKHCgujVeULI+cyXSz/2zLQ" +
       "vYjNJCcNFktBlQd5EE1JW4phE5ZAQAVfNWqoCQ/MZ2YAzLk4hu7muIPI8emD" +
       "WYq1PJhzEcyxi5RwwsiEe2WqIxZ7owx0b2HzKjhl1b56HNJLVXE4BfX1PvgC" +
       "UM6KG4bGqH6mcPfa/wPjHITb4ktUrPgXFf1NI/9aUB460lS78Mi1b4iyNX/9" +
       "3wDlSDKrab5E2p9U15gWS6oCmAZ5S2KKr1OcLCyhquC15IvY+4eS/mMANEgP" +
       "RYD49tP9lZM6jw6mki9+ktOcVAIJvv7NnCKEyv8ZcqHiuwwB//wzwZ9n8V/s" +
       "YVok/iZz09dsv5N9nTyyeeuNp792n7xYVDQ6MYGz1ENBIq8v85X3ipKzuXPV" +
       "bFrzZePDs1e5CVbBxaZ/b0IJQLfEJeDiwE2b3ZG/cHvz6Lqnf7ev5lVIDXeQ" +
       "EAWT2OH7k0oi1ZUzs5Dz74gWF15D1BJXgF1r7hm/cm3y07fENRGRhdqS0vQx" +
       "5fVjO187uOhoWwWp7yPVUAKy3DCpEyY1wJRRa5jMUe3eHPomnatUK6jqGlE5" +
       "KSZCAhcHzjn5Xrxx5qS9uFItvqev04wxZq03snoCp4G6sN7rcW9gCi4vsqYZ" +
       "YPB6fMV5Sho/ngboYyy6xTTd69qqB0xhpempPQG0oWrxim81/wFEeU54Qh8A" +
       "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "g6S8xZD/zGt+8qt/9Pm/LE9S/w+RUAaJiykAAA==");
}
