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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "jhwAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "zWYVbozm7bHgGLxL5BeTiRdWejWF95Bq4ot+jkPFtoEMqLHMRXIQj9WkFcjC" +
       "ymRiL1r7eMvoce2hXeJnvO6adbtsMj1zybmTKj+eaNgwXke5Xk7VtILgI31h" +
       "FfP2rMd7rp/M3cSqKeV2bT4OvchlCGSem1M03mVMjsWbfRipyIHCwEZUUXPs" +
       "QmvTWDU3XMO1EszrrKEvG1JsAEA0luAl8o1vTF8v3/Ly3vBvyjYzDs6hwIt9" +
       "2tB8GW+2m6Z70+KBgw3Q7Hf6+NnF4Q3Q7a4YlL6t33ml46XsTf3D73rqGZX5" +
       "SGFnbzdxEkPXxX7ws4620JxDrM4ATg9deVeCzk7XtrtcX3zXv94++nnjsZex" +
       "d3/3sXkeZ/mH9LNfpl6n/NYOdPJgz+uSc7+jnR4+utN1NtTiOYDPI/tddx5o" +
       "9kKqsbvAtbun2d3L759f1gtOZF6wsf1VNmujq7TN08KLoRumWtz1Fcnp7U29" +
       "uXUX/6U2Qg4zzSrso/LdCa7ynnzln7x8b79K2zvTYh1D1wP59i20v7N315UO" +
       "njanTVsFvO0VKOC2tPIhcO313dxfuQJ2MoKdfVkeuLose6fr+9Q3p9TLorKr" +
       "+u7u3hFbNspvXEWV70uLJ2LoghJqUqxRoRQYphL1fPVAo/deMovpIt69hDJT" +
       "6q+9AqW+Nq1EwCXsKVV4OUoFaBOEfqwpsaa+pHP9/lXa/iAtfjeGbjU3G+bm" +
       "MbWkzU9vJf69VyDxzfs48diexI/95OPo2au0fTItPgriKD0pcLPjuI0th4cW" +
       "FD6Gzsi+72iSt5X6Y69A6ux08Y3gMvekNn8yUp/YOx/ec9t7DocDWIO8GKwE" +
       "870Pbhb7sfG5q6jnz9PiT2LodkPyVEcjGDq1PwAcLQROlvG4nLauWfimulXV" +
       "Z1+Bqm5MK6sZ6ea3eLmqeuayqjq5d9S1p6qHLhvhBy5xOVA4f1i7+2HxZDbY" +
       "V6+i0q+nxRcB3GxUuodS2VdBacsXtmr70stRWwKSpEs+LEhPSW+75Lulzbc2" +
       "yiefOXftrc+M/zY7Wz/4Hua6LnStPnecw4dah55PB6Gmm5kg122OuILs9i2A" +
       "FleA6hg6LW8Xnm9u6P9+T3+H6WPoVHY/TPd8DJ3d0gFWm4fDJN+NoZOAJH38" +
       "x2DfOMiV1g1UjuJQUuLDFt0oKzlxNNs7sMOFl7LDoQTx/iNpXfZl2X4KNt98" +
       "W/ao8qln2r23vVD5yObjAMWR1uuUy7Vd6MzmO4WDNO7eK3Lb53W6+eCLN376" +
       "ugf2U84bNxPexsShud19+ZP4hhvE2dn5+k9v/eM3fPSZb2fHcf8H0VutR/In" +
       "AAA=");
}
