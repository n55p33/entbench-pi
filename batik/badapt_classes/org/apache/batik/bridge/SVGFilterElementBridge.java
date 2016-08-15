package org.apache.batik.bridge;
public class SVGFilterElementBridge extends org.apache.batik.bridge.AnimatableGenericSVGBridge implements org.apache.batik.bridge.FilterBridge, org.apache.batik.bridge.ErrorConstants {
    protected static final java.awt.Color TRANSPARENT_BLACK = new java.awt.Color(
      0,
      true);
    public SVGFilterElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_FILTER_TAG;
    }
    public org.apache.batik.ext.awt.image.renderable.Filter createFilter(org.apache.batik.bridge.BridgeContext ctx,
                                                                         org.w3c.dom.Element filterElement,
                                                                         org.w3c.dom.Element filteredElement,
                                                                         org.apache.batik.gvt.GraphicsNode filteredNode) {
        java.awt.geom.Rectangle2D filterRegion =
          org.apache.batik.bridge.SVGUtilities.
          convertFilterChainRegion(
            filterElement,
            filteredElement,
            filteredNode,
            ctx);
        if (filterRegion ==
              null) {
            return null;
        }
        org.apache.batik.ext.awt.image.renderable.Filter sourceGraphic =
          filteredNode.
          getGraphicsNodeRable(
            true);
        sourceGraphic =
          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
            sourceGraphic,
            filterRegion,
            org.apache.batik.ext.awt.image.PadMode.
              ZERO_PAD);
        org.apache.batik.ext.awt.image.renderable.FilterChainRable filterChain =
          new org.apache.batik.ext.awt.image.renderable.FilterChainRable8Bit(
          sourceGraphic,
          filterRegion);
        float[] filterRes =
          org.apache.batik.bridge.SVGUtilities.
          convertFilterRes(
            filterElement,
            ctx);
        filterChain.
          setFilterResolutionX(
            (int)
              filterRes[0]);
        filterChain.
          setFilterResolutionY(
            (int)
              filterRes[1]);
        java.util.Map filterNodeMap =
          new java.util.HashMap(
          11);
        filterNodeMap.
          put(
            SVG_SOURCE_GRAPHIC_VALUE,
            sourceGraphic);
        org.apache.batik.ext.awt.image.renderable.Filter in =
          buildFilterPrimitives(
            filterElement,
            filterRegion,
            filteredElement,
            filteredNode,
            sourceGraphic,
            filterNodeMap,
            ctx);
        if (in ==
              null) {
            return null;
        }
        else
            if (in ==
                  sourceGraphic) {
                in =
                  createEmptyFilter(
                    filterElement,
                    filterRegion,
                    filteredElement,
                    filteredNode,
                    ctx);
            }
        filterChain.
          setSource(
            in);
        return filterChain;
    }
    protected static org.apache.batik.ext.awt.image.renderable.Filter createEmptyFilter(org.w3c.dom.Element filterElement,
                                                                                        java.awt.geom.Rectangle2D filterRegion,
                                                                                        org.w3c.dom.Element filteredElement,
                                                                                        org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                                        org.apache.batik.bridge.BridgeContext ctx) {
        java.awt.geom.Rectangle2D primitiveRegion =
          org.apache.batik.bridge.SVGUtilities.
          convertFilterPrimitiveRegion(
            null,
            filterElement,
            filteredElement,
            filteredNode,
            filterRegion,
            filterRegion,
            ctx);
        return new org.apache.batik.ext.awt.image.renderable.FloodRable8Bit(
          primitiveRegion,
          TRANSPARENT_BLACK);
    }
    protected static org.apache.batik.ext.awt.image.renderable.Filter buildFilterPrimitives(org.w3c.dom.Element filterElement,
                                                                                            java.awt.geom.Rectangle2D filterRegion,
                                                                                            org.w3c.dom.Element filteredElement,
                                                                                            org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                                            org.apache.batik.ext.awt.image.renderable.Filter in,
                                                                                            java.util.Map filterNodeMap,
                                                                                            org.apache.batik.bridge.BridgeContext ctx) {
        java.util.List refs =
          new java.util.LinkedList(
          );
        for (;
             ;
             ) {
            org.apache.batik.ext.awt.image.renderable.Filter newIn =
              buildLocalFilterPrimitives(
                filterElement,
                filterRegion,
                filteredElement,
                filteredNode,
                in,
                filterNodeMap,
                ctx);
            if (newIn !=
                  in) {
                return newIn;
            }
            java.lang.String uri =
              org.apache.batik.dom.util.XLinkSupport.
              getXLinkHref(
                filterElement);
            if (uri.
                  length(
                    ) ==
                  0) {
                return in;
            }
            org.apache.batik.dom.svg.SVGOMDocument doc =
              (org.apache.batik.dom.svg.SVGOMDocument)
                filterElement.
                getOwnerDocument(
                  );
            org.apache.batik.util.ParsedURL url =
              new org.apache.batik.util.ParsedURL(
              doc.
                getURLObject(
                  ),
              uri);
            if (refs.
                  contains(
                    url)) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  filterElement,
                  ERR_XLINK_HREF_CIRCULAR_DEPENDENCIES,
                  new java.lang.Object[] { uri });
            }
            refs.
              add(
                url);
            filterElement =
              ctx.
                getReferencedElement(
                  filterElement,
                  uri);
        }
    }
    protected static org.apache.batik.ext.awt.image.renderable.Filter buildLocalFilterPrimitives(org.w3c.dom.Element filterElement,
                                                                                                 java.awt.geom.Rectangle2D filterRegion,
                                                                                                 org.w3c.dom.Element filteredElement,
                                                                                                 org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                                                 org.apache.batik.ext.awt.image.renderable.Filter in,
                                                                                                 java.util.Map filterNodeMap,
                                                                                                 org.apache.batik.bridge.BridgeContext ctx) {
        for (org.w3c.dom.Node n =
               filterElement.
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
                    ELEMENT_NODE) {
                continue;
            }
            org.w3c.dom.Element e =
              (org.w3c.dom.Element)
                n;
            org.apache.batik.bridge.Bridge bridge =
              ctx.
              getBridge(
                e);
            if (bridge ==
                  null ||
                  !(bridge instanceof org.apache.batik.bridge.FilterPrimitiveBridge)) {
                continue;
            }
            org.apache.batik.bridge.FilterPrimitiveBridge filterBridge =
              (org.apache.batik.bridge.FilterPrimitiveBridge)
                bridge;
            org.apache.batik.ext.awt.image.renderable.Filter filterNode =
              filterBridge.
              createFilter(
                ctx,
                e,
                filteredElement,
                filteredNode,
                in,
                filterRegion,
                filterNodeMap);
            if (filterNode ==
                  null) {
                return null;
            }
            else {
                in =
                  filterNode;
            }
        }
        return in;
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
