package org.apache.batik.bridge;
public class SVGSwitchElementBridge extends org.apache.batik.bridge.SVGGElementBridge {
    protected org.w3c.dom.Element selectedChild;
    public SVGSwitchElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_SWITCH_TAG; }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.bridge.SVGSwitchElementBridge(
                                                            ); }
    public org.apache.batik.gvt.GraphicsNode createGraphicsNode(org.apache.batik.bridge.BridgeContext ctx,
                                                                org.w3c.dom.Element e) {
        org.apache.batik.gvt.GraphicsNode refNode =
          null;
        org.apache.batik.bridge.GVTBuilder builder =
          ctx.
          getGVTBuilder(
            );
        selectedChild =
          null;
        for (org.w3c.dom.Node n =
               e.
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
                    ) ==
                  org.w3c.dom.Node.
                    ELEMENT_NODE) {
                org.w3c.dom.Element ref =
                  (org.w3c.dom.Element)
                    n;
                if (n instanceof org.w3c.dom.svg.SVGTests &&
                      org.apache.batik.bridge.SVGUtilities.
                      matchUserAgent(
                        ref,
                        ctx.
                          getUserAgent(
                            ))) {
                    selectedChild =
                      ref;
                    refNode =
                      builder.
                        build(
                          ctx,
                          ref);
                    break;
                }
            }
        }
        if (refNode ==
              null) {
            return null;
        }
        org.apache.batik.gvt.CompositeGraphicsNode group =
          (org.apache.batik.gvt.CompositeGraphicsNode)
            super.
            createGraphicsNode(
              ctx,
              e);
        if (group ==
              null) {
            return null;
        }
        group.
          add(
            refNode);
        return group;
    }
    public boolean isComposite() { return false; }
    public void dispose() { selectedChild = null;
                            super.dispose(); }
    protected void handleElementAdded(org.apache.batik.gvt.CompositeGraphicsNode gn,
                                      org.w3c.dom.Node parent,
                                      org.w3c.dom.Element childElt) {
        for (org.w3c.dom.Node n =
               childElt.
               getPreviousSibling(
                 );
             n !=
               null;
             n =
               n.
                 getPreviousSibling(
                   )) {
            if (n ==
                  childElt) {
                return;
            }
        }
        if (childElt instanceof org.w3c.dom.svg.SVGTests &&
              org.apache.batik.bridge.SVGUtilities.
              matchUserAgent(
                childElt,
                ctx.
                  getUserAgent(
                    ))) {
            if (selectedChild !=
                  null) {
                gn.
                  remove(
                    0);
                disposeTree(
                  selectedChild);
            }
            selectedChild =
              childElt;
            org.apache.batik.bridge.GVTBuilder builder =
              ctx.
              getGVTBuilder(
                );
            org.apache.batik.gvt.GraphicsNode refNode =
              builder.
              build(
                ctx,
                childElt);
            if (refNode !=
                  null) {
                gn.
                  add(
                    refNode);
            }
        }
    }
    protected void handleChildElementRemoved(org.w3c.dom.Element e) {
        org.apache.batik.gvt.CompositeGraphicsNode gn =
          (org.apache.batik.gvt.CompositeGraphicsNode)
            node;
        if (selectedChild ==
              e) {
            gn.
              remove(
                0);
            disposeTree(
              selectedChild);
            selectedChild =
              null;
            org.apache.batik.gvt.GraphicsNode refNode =
              null;
            org.apache.batik.bridge.GVTBuilder builder =
              ctx.
              getGVTBuilder(
                );
            for (org.w3c.dom.Node n =
                   e.
                   getNextSibling(
                     );
                 n !=
                   null;
                 n =
                   n.
                     getNextSibling(
                       )) {
                if (n.
                      getNodeType(
                        ) ==
                      org.w3c.dom.Node.
                        ELEMENT_NODE) {
                    org.w3c.dom.Element ref =
                      (org.w3c.dom.Element)
                        n;
                    if (n instanceof org.w3c.dom.svg.SVGTests &&
                          org.apache.batik.bridge.SVGUtilities.
                          matchUserAgent(
                            ref,
                            ctx.
                              getUserAgent(
                                ))) {
                        refNode =
                          builder.
                            build(
                              ctx,
                              ref);
                        selectedChild =
                          ref;
                        break;
                    }
                }
            }
            if (refNode !=
                  null) {
                gn.
                  add(
                    refNode);
            }
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "/wG7WLkqgR4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Fux+6Y0/95U/+tKnyjO//wUhGlgXHykAAA==");
}
