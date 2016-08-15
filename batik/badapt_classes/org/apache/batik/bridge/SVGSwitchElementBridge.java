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
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "/wHH1FgwgR4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "b/617/+Fl79Wnvn9PUu+qvofKQAA");
}
