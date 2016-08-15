package org.apache.batik.extension.svg;
public class ColorSwitchBridge extends org.apache.batik.bridge.AbstractSVGBridge implements org.apache.batik.bridge.PaintBridge, org.apache.batik.extension.svg.BatikExtConstants {
    public ColorSwitchBridge() { super(); }
    public java.lang.String getNamespaceURI() { return BATIK_EXT_NAMESPACE_URI;
    }
    public java.lang.String getLocalName() { return BATIK_EXT_COLOR_SWITCH_TAG;
    }
    public java.awt.Paint createPaint(org.apache.batik.bridge.BridgeContext ctx,
                                      org.w3c.dom.Element paintElement,
                                      org.w3c.dom.Element paintedElement,
                                      org.apache.batik.gvt.GraphicsNode paintedNode,
                                      float opacity) { org.w3c.dom.Element clrDef =
                                                         null;
                                                       for (org.w3c.dom.Node n =
                                                              paintElement.
                                                              getFirstChild(
                                                                );
                                                            n !=
                                                              null;
                                                            n =
                                                              n.
                                                                getNextSibling(
                                                                  )) {
                                                           if (n.
                                                                 getNodeType(
                                                                   ) !=
                                                                 org.w3c.dom.Node.
                                                                   ELEMENT_NODE)
                                                               continue;
                                                           org.w3c.dom.Element ref =
                                                             (org.w3c.dom.Element)
                                                               n;
                                                           if (org.apache.batik.bridge.SVGUtilities.
                                                                 matchUserAgent(
                                                                   ref,
                                                                   ctx.
                                                                     getUserAgent(
                                                                       ))) {
                                                               clrDef =
                                                                 ref;
                                                               break;
                                                           }
                                                       }
                                                       if (clrDef ==
                                                             null)
                                                           return java.awt.Color.
                                                                    black;
                                                       org.apache.batik.bridge.Bridge bridge =
                                                         ctx.
                                                         getBridge(
                                                           clrDef);
                                                       if (bridge ==
                                                             null ||
                                                             !(bridge instanceof org.apache.batik.bridge.PaintBridge))
                                                           return java.awt.Color.
                                                                    black;
                                                       return ((org.apache.batik.bridge.PaintBridge)
                                                                 bridge).
                                                         createPaint(
                                                           ctx,
                                                           clrDef,
                                                           paintedElement,
                                                           paintedNode,
                                                           opacity);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
