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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "g4wCAqPOyOJwrEFmjFcZ8nxd1qI1Y86YnpEGcdZFxHVrEqjRcDSaRMSOEjpN" +
       "phcJ+QQWCVROt/bMd+G1Op0g+EBj0y1p0HjNsaL6jKd7xJh0pogypICX+ZlU" +
       "S5UgEASLQZtTG1lZajQerlObX9Q71KTfScxMnNp9siaNd6NJMhrru8yfkvMM" +
       "D+xMDywKozfuGNN4V80Jjw97kcOr4tY3VUScNtWtNE7lRJ0kLO2zY2Y2tdGg" +
       "6zW6GGkLQ3845aZzCdO42byKy/ISw0Uvq1p1fhRvZI/ZWjN6sBRJGVO2FosJ" +
       "fDhfz0PAd70lmvnaitxeVOFbTtIm8xbsyU5docyhpY6XxDyftOE8Xdbw/pJl" +
       "Mj4n6TXeGIK3q8BVlFlUnUY9A+ulybqbepSDoG11x/mNDcqOeWm7ndpeI23M" +
       "c4MR5/XGbtOtRmit2VQ2jOgxSU1J2ztm268h9SaTVqVqDbPppTptJkzcZCmj" +
       "CbfrzqIRrrSeN0JXQtcmra3do5S5O428OStKkTTz8xGpD1cWTXcIfgdyxalp" +
       "Xc7f+DM3j2e8tEtX1sgwZcKfwAk72rrdbm06pVZTgROBnyQu62oUZ7v8RN4Z" +
       "A5xG2CnXXDsNvDtIWdLeiu7EEQQ2G/Ysl8rqaR9zehuAygMeR+PVhjXIdD2Y" +
       "bXBDHG1pvGfKSyYlGzWCH03nChnZzSmrYEaKTZdxbcsYHWqeczA1tOy5xjWr" +
       "4tRSk2iwxsnNmtNChlbJ0KYG67Dl7CpcPZVQoekCX43jwbbHxWRTaRqh2Fm2" +
       "jDDemW1vlHIKrfY6zUWjp8zr3UbCJTW/rcWLvGXNtLrljg1bYwSXdLctNaEn" +
       "dFUf0+aAssbjqKcwAZXmSIUx5gZhBcLMIGXP4MZ2OnfxeebPNjknpF2iphv9" +
       "jWGm2LJupr3lZIv5/dE0ifv8spqk3bbaFPXeBmGWuw47HaC6Me1w+RbFG7Ma" +
       "0tHirE9MdhaOKXqI9/Jec84MmjNn0Fr73cmMrMxmertdsad1FEm5/mZg5sNY" +
       "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" +
       "vikAAA==");
}
