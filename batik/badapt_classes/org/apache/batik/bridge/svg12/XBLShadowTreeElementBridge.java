package org.apache.batik.bridge.svg12;
public class XBLShadowTreeElementBridge extends org.apache.batik.bridge.AbstractGraphicsNodeBridge {
    public XBLShadowTreeElementBridge() { super(); }
    public java.lang.String getLocalName() { return org.apache.batik.util.XBLConstants.
                                                      XBL_SHADOW_TREE_TAG;
    }
    public java.lang.String getNamespaceURI() { return org.apache.batik.util.XBLConstants.
                                                         XBL_NAMESPACE_URI;
    }
    public org.apache.batik.bridge.Bridge getInstance() {
        return new org.apache.batik.bridge.svg12.XBLShadowTreeElementBridge(
          );
    }
    public org.apache.batik.gvt.GraphicsNode createGraphicsNode(org.apache.batik.bridge.BridgeContext ctx,
                                                                org.w3c.dom.Element e) {
        if (!org.apache.batik.bridge.SVGUtilities.
              matchUserAgent(
                e,
                ctx.
                  getUserAgent(
                    ))) {
            return null;
        }
        org.apache.batik.gvt.CompositeGraphicsNode cgn =
          new org.apache.batik.gvt.CompositeGraphicsNode(
          );
        associateSVGContext(
          ctx,
          e,
          cgn);
        return cgn;
    }
    protected org.apache.batik.gvt.GraphicsNode instantiateGraphicsNode() {
        return null;
    }
    public void buildGraphicsNode(org.apache.batik.bridge.BridgeContext ctx,
                                  org.w3c.dom.Element e,
                                  org.apache.batik.gvt.GraphicsNode node) {
        initializeDynamicSupport(
          ctx,
          e,
          node);
    }
    public boolean getDisplay(org.w3c.dom.Element e) {
        return true;
    }
    public boolean isComposite() { return true;
    }
    public void handleDOMNodeInsertedEvent(org.w3c.dom.events.MutationEvent evt) {
        if (evt.
              getTarget(
                ) instanceof org.w3c.dom.Element) {
            handleElementAdded(
              (org.apache.batik.gvt.CompositeGraphicsNode)
                node,
              e,
              (org.w3c.dom.Element)
                evt.
                getTarget(
                  ));
        }
    }
    public void handleElementAdded(org.apache.batik.gvt.CompositeGraphicsNode gn,
                                   org.w3c.dom.Node parent,
                                   org.w3c.dom.Element childElt) {
        org.apache.batik.bridge.GVTBuilder builder =
          ctx.
          getGVTBuilder(
            );
        org.apache.batik.gvt.GraphicsNode childNode =
          builder.
          build(
            ctx,
            childElt);
        if (childNode ==
              null) {
            return;
        }
        int idx =
          -1;
        for (org.w3c.dom.Node ps =
               childElt.
               getPreviousSibling(
                 );
             ps !=
               null;
             ps =
               ps.
                 getPreviousSibling(
                   )) {
            if (ps.
                  getNodeType(
                    ) !=
                  org.w3c.dom.Node.
                    ELEMENT_NODE)
                continue;
            org.w3c.dom.Element pse =
              (org.w3c.dom.Element)
                ps;
            org.apache.batik.gvt.GraphicsNode psgn =
              ctx.
              getGraphicsNode(
                pse);
            while (psgn !=
                     null &&
                     psgn.
                     getParent(
                       ) !=
                     gn) {
                psgn =
                  psgn.
                    getParent(
                      );
            }
            if (psgn ==
                  null)
                continue;
            idx =
              gn.
                indexOf(
                  psgn);
            if (idx ==
                  -1)
                continue;
            break;
        }
        idx++;
        gn.
          add(
            idx,
            childNode);
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
      ("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" +
       "7ysAAA==");
}
