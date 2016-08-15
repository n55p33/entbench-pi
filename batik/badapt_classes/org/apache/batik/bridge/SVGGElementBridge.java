package org.apache.batik.bridge;
public class SVGGElementBridge extends org.apache.batik.bridge.AbstractGraphicsNodeBridge {
    public SVGGElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_G_TAG; }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.bridge.SVGGElementBridge(
                                                            ); }
    public org.apache.batik.gvt.GraphicsNode createGraphicsNode(org.apache.batik.bridge.BridgeContext ctx,
                                                                org.w3c.dom.Element e) {
        org.apache.batik.gvt.CompositeGraphicsNode gn =
          (org.apache.batik.gvt.CompositeGraphicsNode)
            super.
            createGraphicsNode(
              ctx,
              e);
        if (gn ==
              null)
            return null;
        associateSVGContext(
          ctx,
          e,
          gn);
        java.awt.RenderingHints hints =
          null;
        hints =
          org.apache.batik.bridge.CSSUtilities.
            convertColorRendering(
              e,
              hints);
        if (hints !=
              null)
            gn.
              setRenderingHints(
                hints);
        java.awt.geom.Rectangle2D r =
          org.apache.batik.bridge.CSSUtilities.
          convertEnableBackground(
            e);
        if (r !=
              null)
            gn.
              setBackgroundEnable(
                r);
        return gn;
    }
    protected org.apache.batik.gvt.GraphicsNode instantiateGraphicsNode() {
        return new org.apache.batik.gvt.CompositeGraphicsNode(
          );
    }
    public boolean isComposite() { return true; }
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
        else {
            super.
              handleDOMNodeInsertedEvent(
                evt);
        }
    }
    protected void handleElementAdded(org.apache.batik.gvt.CompositeGraphicsNode gn,
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
      ("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" +
       "jhwAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
