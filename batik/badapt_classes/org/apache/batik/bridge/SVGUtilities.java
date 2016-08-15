package org.apache.batik.bridge;
public abstract class SVGUtilities implements org.apache.batik.util.SVGConstants, org.apache.batik.bridge.ErrorConstants {
    protected SVGUtilities() { super(); }
    public static org.w3c.dom.Element getParentElement(org.w3c.dom.Element elt) {
        org.w3c.dom.Node n =
          org.apache.batik.css.engine.CSSEngine.
          getCSSParentNode(
            elt);
        while (n !=
                 null &&
                 n.
                 getNodeType(
                   ) !=
                 org.w3c.dom.Node.
                   ELEMENT_NODE) {
            n =
              org.apache.batik.css.engine.CSSEngine.
                getCSSParentNode(
                  n);
        }
        return (org.w3c.dom.Element)
                 n;
    }
    public static float[] convertSVGNumberList(org.w3c.dom.svg.SVGNumberList l) {
        int n =
          l.
          getNumberOfItems(
            );
        if (n ==
              0) {
            return null;
        }
        float[] fl =
          new float[n];
        for (int i =
               0;
             i <
               n;
             i++) {
            fl[i] =
              l.
                getItem(
                  i).
                getValue(
                  );
        }
        return fl;
    }
    public static float convertSVGNumber(java.lang.String s) {
        return java.lang.Float.
          parseFloat(
            s);
    }
    public static int convertSVGInteger(java.lang.String s) {
        return java.lang.Integer.
          parseInt(
            s);
    }
    public static float convertRatio(java.lang.String v) {
        float d =
          1;
        if (v.
              endsWith(
                "%")) {
            v =
              v.
                substring(
                  0,
                  v.
                    length(
                      ) -
                    1);
            d =
              100;
        }
        float r =
          java.lang.Float.
          parseFloat(
            v) /
          d;
        if (r <
              0) {
            r =
              0;
        }
        else
            if (r >
                  1) {
                r =
                  1;
            }
        return r;
    }
    public static java.lang.String getDescription(org.w3c.dom.svg.SVGElement elt) {
        java.lang.String result =
          "";
        boolean preserve =
          false;
        org.w3c.dom.Node n =
          elt.
          getFirstChild(
            );
        if (n !=
              null &&
              n.
              getNodeType(
                ) ==
              org.w3c.dom.Node.
                ELEMENT_NODE) {
            java.lang.String name =
              n.
              getPrefix(
                ) ==
              null
              ? n.
              getNodeName(
                )
              : n.
              getLocalName(
                );
            if (name.
                  equals(
                    SVG_DESC_TAG)) {
                preserve =
                  ((org.w3c.dom.svg.SVGLangSpace)
                     n).
                    getXMLspace(
                      ).
                    equals(
                      SVG_PRESERVE_VALUE);
                for (n =
                       n.
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
                            TEXT_NODE) {
                        result +=
                          n.
                            getNodeValue(
                              );
                    }
                }
            }
        }
        return preserve
          ? org.apache.batik.dom.util.XMLSupport.
          preserveXMLSpace(
            result)
          : org.apache.batik.dom.util.XMLSupport.
          defaultXMLSpace(
            result);
    }
    public static boolean matchUserAgent(org.w3c.dom.Element elt,
                                         org.apache.batik.bridge.UserAgent ua) {
        test: if (elt.
                    hasAttributeNS(
                      null,
                      SVG_SYSTEM_LANGUAGE_ATTRIBUTE)) {
            java.lang.String sl =
              elt.
              getAttributeNS(
                null,
                SVG_SYSTEM_LANGUAGE_ATTRIBUTE);
            if (sl.
                  length(
                    ) ==
                  0)
                return false;
            java.util.StringTokenizer st =
              new java.util.StringTokenizer(
              sl,
              ", ");
            while (st.
                     hasMoreTokens(
                       )) {
                java.lang.String s =
                  st.
                  nextToken(
                    );
                if (matchUserLanguage(
                      s,
                      ua.
                        getLanguages(
                          ))) {
                    break test;
                }
            }
            return false;
        }
        if (elt.
              hasAttributeNS(
                null,
                SVG_REQUIRED_FEATURES_ATTRIBUTE)) {
            java.lang.String rf =
              elt.
              getAttributeNS(
                null,
                SVG_REQUIRED_FEATURES_ATTRIBUTE);
            if (rf.
                  length(
                    ) ==
                  0)
                return false;
            java.util.StringTokenizer st =
              new java.util.StringTokenizer(
              rf,
              " ");
            while (st.
                     hasMoreTokens(
                       )) {
                java.lang.String s =
                  st.
                  nextToken(
                    );
                if (!ua.
                      hasFeature(
                        s)) {
                    return false;
                }
            }
        }
        if (elt.
              hasAttributeNS(
                null,
                SVG_REQUIRED_EXTENSIONS_ATTRIBUTE)) {
            java.lang.String re =
              elt.
              getAttributeNS(
                null,
                SVG_REQUIRED_EXTENSIONS_ATTRIBUTE);
            if (re.
                  length(
                    ) ==
                  0)
                return false;
            java.util.StringTokenizer st =
              new java.util.StringTokenizer(
              re,
              " ");
            while (st.
                     hasMoreTokens(
                       )) {
                java.lang.String s =
                  st.
                  nextToken(
                    );
                if (!ua.
                      supportExtension(
                        s)) {
                    return false;
                }
            }
        }
        return true;
    }
    protected static boolean matchUserLanguage(java.lang.String s,
                                               java.lang.String userLanguages) {
        java.util.StringTokenizer st =
          new java.util.StringTokenizer(
          userLanguages,
          ", ");
        while (st.
                 hasMoreTokens(
                   )) {
            java.lang.String t =
              st.
              nextToken(
                );
            if (s.
                  startsWith(
                    t)) {
                if (s.
                      length(
                        ) >
                      t.
                      length(
                        )) {
                    return s.
                      charAt(
                        t.
                          length(
                            )) ==
                      '-';
                }
                return true;
            }
        }
        return false;
    }
    public static java.lang.String getChainableAttributeNS(org.w3c.dom.Element element,
                                                           java.lang.String namespaceURI,
                                                           java.lang.String attrName,
                                                           org.apache.batik.bridge.BridgeContext ctx) {
        org.apache.batik.bridge.DocumentLoader loader =
          ctx.
          getDocumentLoader(
            );
        org.w3c.dom.Element e =
          element;
        java.util.List refs =
          new java.util.LinkedList(
          );
        for (;
             ;
             ) {
            java.lang.String v =
              e.
              getAttributeNS(
                namespaceURI,
                attrName);
            if (v.
                  length(
                    ) >
                  0) {
                return v;
            }
            java.lang.String uriStr =
              org.apache.batik.dom.util.XLinkSupport.
              getXLinkHref(
                e);
            if (uriStr.
                  length(
                    ) ==
                  0) {
                return "";
            }
            java.lang.String baseURI =
              ((org.apache.batik.dom.AbstractNode)
                 e).
              getBaseURI(
                );
            org.apache.batik.util.ParsedURL purl =
              new org.apache.batik.util.ParsedURL(
              baseURI,
              uriStr);
            java.util.Iterator iter =
              refs.
              iterator(
                );
            while (iter.
                     hasNext(
                       )) {
                if (purl.
                      equals(
                        iter.
                          next(
                            )))
                    throw new org.apache.batik.bridge.BridgeException(
                      ctx,
                      e,
                      ERR_XLINK_HREF_CIRCULAR_DEPENDENCIES,
                      new java.lang.Object[] { uriStr });
            }
            try {
                org.w3c.dom.svg.SVGDocument svgDoc =
                  (org.w3c.dom.svg.SVGDocument)
                    e.
                    getOwnerDocument(
                      );
                org.apache.batik.bridge.URIResolver resolver =
                  ctx.
                  createURIResolver(
                    svgDoc,
                    loader);
                e =
                  resolver.
                    getElement(
                      purl.
                        toString(
                          ),
                      e);
                refs.
                  add(
                    purl);
            }
            catch (java.io.IOException ioEx) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  e,
                  ioEx,
                  ERR_URI_IO,
                  new java.lang.Object[] { uriStr });
            }
            catch (java.lang.SecurityException secEx) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  e,
                  secEx,
                  ERR_URI_UNSECURE,
                  new java.lang.Object[] { uriStr });
            }
        }
    }
    public static java.awt.geom.Point2D convertPoint(java.lang.String xStr,
                                                     java.lang.String xAttr,
                                                     java.lang.String yStr,
                                                     java.lang.String yAttr,
                                                     short unitsType,
                                                     org.apache.batik.parser.UnitProcessor.Context uctx) {
        float x;
        float y;
        switch (unitsType) {
            case OBJECT_BOUNDING_BOX:
                x =
                  org.apache.batik.bridge.UnitProcessor.
                    svgHorizontalCoordinateToObjectBoundingBox(
                      xStr,
                      xAttr,
                      uctx);
                y =
                  org.apache.batik.bridge.UnitProcessor.
                    svgVerticalCoordinateToObjectBoundingBox(
                      yStr,
                      yAttr,
                      uctx);
                break;
            case USER_SPACE_ON_USE:
                x =
                  org.apache.batik.bridge.UnitProcessor.
                    svgHorizontalCoordinateToUserSpace(
                      xStr,
                      xAttr,
                      uctx);
                y =
                  org.apache.batik.bridge.UnitProcessor.
                    svgVerticalCoordinateToUserSpace(
                      yStr,
                      yAttr,
                      uctx);
                break;
            default:
                throw new java.lang.IllegalArgumentException(
                  "Invalid unit type");
        }
        return new java.awt.geom.Point2D.Float(
          x,
          y);
    }
    public static float convertLength(java.lang.String length,
                                      java.lang.String attr,
                                      short unitsType,
                                      org.apache.batik.parser.UnitProcessor.Context uctx) {
        switch (unitsType) {
            case OBJECT_BOUNDING_BOX:
                return org.apache.batik.bridge.UnitProcessor.
                  svgOtherLengthToObjectBoundingBox(
                    length,
                    attr,
                    uctx);
            case USER_SPACE_ON_USE:
                return org.apache.batik.bridge.UnitProcessor.
                  svgOtherLengthToUserSpace(
                    length,
                    attr,
                    uctx);
            default:
                throw new java.lang.IllegalArgumentException(
                  "Invalid unit type");
        }
    }
    public static java.awt.geom.Rectangle2D convertMaskRegion(org.w3c.dom.Element maskElement,
                                                              org.w3c.dom.Element maskedElement,
                                                              org.apache.batik.gvt.GraphicsNode maskedNode,
                                                              org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String xStr =
          maskElement.
          getAttributeNS(
            null,
            SVG_X_ATTRIBUTE);
        if (xStr.
              length(
                ) ==
              0) {
            xStr =
              SVG_MASK_X_DEFAULT_VALUE;
        }
        java.lang.String yStr =
          maskElement.
          getAttributeNS(
            null,
            SVG_Y_ATTRIBUTE);
        if (yStr.
              length(
                ) ==
              0) {
            yStr =
              SVG_MASK_Y_DEFAULT_VALUE;
        }
        java.lang.String wStr =
          maskElement.
          getAttributeNS(
            null,
            SVG_WIDTH_ATTRIBUTE);
        if (wStr.
              length(
                ) ==
              0) {
            wStr =
              SVG_MASK_WIDTH_DEFAULT_VALUE;
        }
        java.lang.String hStr =
          maskElement.
          getAttributeNS(
            null,
            SVG_HEIGHT_ATTRIBUTE);
        if (hStr.
              length(
                ) ==
              0) {
            hStr =
              SVG_MASK_HEIGHT_DEFAULT_VALUE;
        }
        short unitsType;
        java.lang.String units =
          maskElement.
          getAttributeNS(
            null,
            SVG_MASK_UNITS_ATTRIBUTE);
        if (units.
              length(
                ) ==
              0) {
            unitsType =
              OBJECT_BOUNDING_BOX;
        }
        else {
            unitsType =
              parseCoordinateSystem(
                maskElement,
                SVG_MASK_UNITS_ATTRIBUTE,
                units,
                ctx);
        }
        org.apache.batik.parser.UnitProcessor.Context uctx =
          org.apache.batik.bridge.UnitProcessor.
          createContext(
            ctx,
            maskedElement);
        return convertRegion(
                 xStr,
                 yStr,
                 wStr,
                 hStr,
                 unitsType,
                 maskedNode,
                 uctx);
    }
    public static java.awt.geom.Rectangle2D convertPatternRegion(org.w3c.dom.Element patternElement,
                                                                 org.w3c.dom.Element paintedElement,
                                                                 org.apache.batik.gvt.GraphicsNode paintedNode,
                                                                 org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String xStr =
          getChainableAttributeNS(
            patternElement,
            null,
            SVG_X_ATTRIBUTE,
            ctx);
        if (xStr.
              length(
                ) ==
              0) {
            xStr =
              SVG_PATTERN_X_DEFAULT_VALUE;
        }
        java.lang.String yStr =
          getChainableAttributeNS(
            patternElement,
            null,
            SVG_Y_ATTRIBUTE,
            ctx);
        if (yStr.
              length(
                ) ==
              0) {
            yStr =
              SVG_PATTERN_Y_DEFAULT_VALUE;
        }
        java.lang.String wStr =
          getChainableAttributeNS(
            patternElement,
            null,
            SVG_WIDTH_ATTRIBUTE,
            ctx);
        if (wStr.
              length(
                ) ==
              0) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              patternElement,
              ERR_ATTRIBUTE_MISSING,
              new java.lang.Object[] { SVG_WIDTH_ATTRIBUTE });
        }
        java.lang.String hStr =
          getChainableAttributeNS(
            patternElement,
            null,
            SVG_HEIGHT_ATTRIBUTE,
            ctx);
        if (hStr.
              length(
                ) ==
              0) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              patternElement,
              ERR_ATTRIBUTE_MISSING,
              new java.lang.Object[] { SVG_HEIGHT_ATTRIBUTE });
        }
        short unitsType;
        java.lang.String units =
          getChainableAttributeNS(
            patternElement,
            null,
            SVG_PATTERN_UNITS_ATTRIBUTE,
            ctx);
        if (units.
              length(
                ) ==
              0) {
            unitsType =
              OBJECT_BOUNDING_BOX;
        }
        else {
            unitsType =
              parseCoordinateSystem(
                patternElement,
                SVG_PATTERN_UNITS_ATTRIBUTE,
                units,
                ctx);
        }
        org.apache.batik.parser.UnitProcessor.Context uctx =
          org.apache.batik.bridge.UnitProcessor.
          createContext(
            ctx,
            paintedElement);
        return convertRegion(
                 xStr,
                 yStr,
                 wStr,
                 hStr,
                 unitsType,
                 paintedNode,
                 uctx);
    }
    public static float[] convertFilterRes(org.w3c.dom.Element filterElement,
                                           org.apache.batik.bridge.BridgeContext ctx) {
        float[] filterRes =
          new float[2];
        java.lang.String s =
          getChainableAttributeNS(
            filterElement,
            null,
            SVG_FILTER_RES_ATTRIBUTE,
            ctx);
        java.lang.Float[] vals =
          convertSVGNumberOptionalNumber(
            filterElement,
            SVG_FILTER_RES_ATTRIBUTE,
            s,
            ctx);
        if (filterRes[0] <
              0 ||
              filterRes[1] <
              0) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              filterElement,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_FILTER_RES_ATTRIBUTE,
              s });
        }
        if (vals[0] ==
              null)
            filterRes[0] =
              -1;
        else {
            filterRes[0] =
              vals[0].
                floatValue(
                  );
            if (filterRes[0] <
                  0)
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  filterElement,
                  ERR_ATTRIBUTE_VALUE_MALFORMED,
                  new java.lang.Object[] { SVG_FILTER_RES_ATTRIBUTE,
                  s });
        }
        if (vals[1] ==
              null)
            filterRes[1] =
              filterRes[0];
        else {
            filterRes[1] =
              vals[1].
                floatValue(
                  );
            if (filterRes[1] <
                  0)
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  filterElement,
                  ERR_ATTRIBUTE_VALUE_MALFORMED,
                  new java.lang.Object[] { SVG_FILTER_RES_ATTRIBUTE,
                  s });
        }
        return filterRes;
    }
    public static java.lang.Float[] convertSVGNumberOptionalNumber(org.w3c.dom.Element elem,
                                                                   java.lang.String attrName,
                                                                   java.lang.String attrValue,
                                                                   org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.Float[] ret =
          new java.lang.Float[2];
        if (attrValue.
              length(
                ) ==
              0)
            return ret;
        try {
            java.util.StringTokenizer tokens =
              new java.util.StringTokenizer(
              attrValue,
              " ");
            ret[0] =
              new java.lang.Float(
                java.lang.Float.
                  parseFloat(
                    tokens.
                      nextToken(
                        )));
            if (tokens.
                  hasMoreTokens(
                    )) {
                ret[1] =
                  new java.lang.Float(
                    java.lang.Float.
                      parseFloat(
                        tokens.
                          nextToken(
                            )));
            }
            if (tokens.
                  hasMoreTokens(
                    )) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  elem,
                  ERR_ATTRIBUTE_VALUE_MALFORMED,
                  new java.lang.Object[] { attrName,
                  attrValue });
            }
        }
        catch (java.lang.NumberFormatException nfEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              elem,
              nfEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { attrName,
              attrValue,
              nfEx });
        }
        return ret;
    }
    public static java.awt.geom.Rectangle2D convertFilterChainRegion(org.w3c.dom.Element filterElement,
                                                                     org.w3c.dom.Element filteredElement,
                                                                     org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                     org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String xStr =
          getChainableAttributeNS(
            filterElement,
            null,
            SVG_X_ATTRIBUTE,
            ctx);
        if (xStr.
              length(
                ) ==
              0) {
            xStr =
              SVG_FILTER_X_DEFAULT_VALUE;
        }
        java.lang.String yStr =
          getChainableAttributeNS(
            filterElement,
            null,
            SVG_Y_ATTRIBUTE,
            ctx);
        if (yStr.
              length(
                ) ==
              0) {
            yStr =
              SVG_FILTER_Y_DEFAULT_VALUE;
        }
        java.lang.String wStr =
          getChainableAttributeNS(
            filterElement,
            null,
            SVG_WIDTH_ATTRIBUTE,
            ctx);
        if (wStr.
              length(
                ) ==
              0) {
            wStr =
              SVG_FILTER_WIDTH_DEFAULT_VALUE;
        }
        java.lang.String hStr =
          getChainableAttributeNS(
            filterElement,
            null,
            SVG_HEIGHT_ATTRIBUTE,
            ctx);
        if (hStr.
              length(
                ) ==
              0) {
            hStr =
              SVG_FILTER_HEIGHT_DEFAULT_VALUE;
        }
        short unitsType;
        java.lang.String units =
          getChainableAttributeNS(
            filterElement,
            null,
            SVG_FILTER_UNITS_ATTRIBUTE,
            ctx);
        if (units.
              length(
                ) ==
              0) {
            unitsType =
              OBJECT_BOUNDING_BOX;
        }
        else {
            unitsType =
              parseCoordinateSystem(
                filterElement,
                SVG_FILTER_UNITS_ATTRIBUTE,
                units,
                ctx);
        }
        org.apache.batik.parser.UnitProcessor.Context uctx =
          org.apache.batik.bridge.UnitProcessor.
          createContext(
            ctx,
            filteredElement);
        java.awt.geom.Rectangle2D region =
          convertRegion(
            xStr,
            yStr,
            wStr,
            hStr,
            unitsType,
            filteredNode,
            uctx);
        units =
          getChainableAttributeNS(
            filterElement,
            null,
            org.apache.batik.util.SVG12Constants.
              SVG_FILTER_MARGINS_UNITS_ATTRIBUTE,
            ctx);
        if (units.
              length(
                ) ==
              0) {
            unitsType =
              USER_SPACE_ON_USE;
        }
        else {
            unitsType =
              parseCoordinateSystem(
                filterElement,
                org.apache.batik.util.SVG12Constants.
                  SVG_FILTER_MARGINS_UNITS_ATTRIBUTE,
                units,
                ctx);
        }
        java.lang.String dxStr =
          filterElement.
          getAttributeNS(
            null,
            org.apache.batik.util.SVG12Constants.
              SVG_MX_ATRIBUTE);
        if (dxStr.
              length(
                ) ==
              0) {
            dxStr =
              org.apache.batik.util.SVG12Constants.
                SVG_FILTER_MX_DEFAULT_VALUE;
        }
        java.lang.String dyStr =
          filterElement.
          getAttributeNS(
            null,
            org.apache.batik.util.SVG12Constants.
              SVG_MY_ATRIBUTE);
        if (dyStr.
              length(
                ) ==
              0) {
            dyStr =
              org.apache.batik.util.SVG12Constants.
                SVG_FILTER_MY_DEFAULT_VALUE;
        }
        java.lang.String dwStr =
          filterElement.
          getAttributeNS(
            null,
            org.apache.batik.util.SVG12Constants.
              SVG_MW_ATRIBUTE);
        if (dwStr.
              length(
                ) ==
              0) {
            dwStr =
              org.apache.batik.util.SVG12Constants.
                SVG_FILTER_MW_DEFAULT_VALUE;
        }
        java.lang.String dhStr =
          filterElement.
          getAttributeNS(
            null,
            org.apache.batik.util.SVG12Constants.
              SVG_MH_ATRIBUTE);
        if (dhStr.
              length(
                ) ==
              0) {
            dhStr =
              org.apache.batik.util.SVG12Constants.
                SVG_FILTER_MH_DEFAULT_VALUE;
        }
        return extendRegion(
                 dxStr,
                 dyStr,
                 dwStr,
                 dhStr,
                 unitsType,
                 filteredNode,
                 region,
                 uctx);
    }
    protected static java.awt.geom.Rectangle2D extendRegion(java.lang.String dxStr,
                                                            java.lang.String dyStr,
                                                            java.lang.String dwStr,
                                                            java.lang.String dhStr,
                                                            short unitsType,
                                                            org.apache.batik.gvt.GraphicsNode filteredNode,
                                                            java.awt.geom.Rectangle2D region,
                                                            org.apache.batik.parser.UnitProcessor.Context uctx) {
        float dx;
        float dy;
        float dw;
        float dh;
        switch (unitsType) {
            case USER_SPACE_ON_USE:
                dx =
                  org.apache.batik.bridge.UnitProcessor.
                    svgHorizontalCoordinateToUserSpace(
                      dxStr,
                      org.apache.batik.util.SVG12Constants.
                        SVG_MX_ATRIBUTE,
                      uctx);
                dy =
                  org.apache.batik.bridge.UnitProcessor.
                    svgVerticalCoordinateToUserSpace(
                      dyStr,
                      org.apache.batik.util.SVG12Constants.
                        SVG_MY_ATRIBUTE,
                      uctx);
                dw =
                  org.apache.batik.bridge.UnitProcessor.
                    svgHorizontalCoordinateToUserSpace(
                      dwStr,
                      org.apache.batik.util.SVG12Constants.
                        SVG_MW_ATRIBUTE,
                      uctx);
                dh =
                  org.apache.batik.bridge.UnitProcessor.
                    svgVerticalCoordinateToUserSpace(
                      dhStr,
                      org.apache.batik.util.SVG12Constants.
                        SVG_MH_ATRIBUTE,
                      uctx);
                break;
            case OBJECT_BOUNDING_BOX:
                java.awt.geom.Rectangle2D bounds =
                  filteredNode.
                  getGeometryBounds(
                    );
                if (bounds ==
                      null) {
                    dx =
                      (dy =
                         (dw =
                            (dh =
                               0)));
                }
                else {
                    dx =
                      org.apache.batik.bridge.UnitProcessor.
                        svgHorizontalCoordinateToObjectBoundingBox(
                          dxStr,
                          org.apache.batik.util.SVG12Constants.
                            SVG_MX_ATRIBUTE,
                          uctx);
                    dx *=
                      bounds.
                        getWidth(
                          );
                    dy =
                      org.apache.batik.bridge.UnitProcessor.
                        svgVerticalCoordinateToObjectBoundingBox(
                          dyStr,
                          org.apache.batik.util.SVG12Constants.
                            SVG_MY_ATRIBUTE,
                          uctx);
                    dy *=
                      bounds.
                        getHeight(
                          );
                    dw =
                      org.apache.batik.bridge.UnitProcessor.
                        svgHorizontalCoordinateToObjectBoundingBox(
                          dwStr,
                          org.apache.batik.util.SVG12Constants.
                            SVG_MW_ATRIBUTE,
                          uctx);
                    dw *=
                      bounds.
                        getWidth(
                          );
                    dh =
                      org.apache.batik.bridge.UnitProcessor.
                        svgVerticalCoordinateToObjectBoundingBox(
                          dhStr,
                          org.apache.batik.util.SVG12Constants.
                            SVG_MH_ATRIBUTE,
                          uctx);
                    dh *=
                      bounds.
                        getHeight(
                          );
                }
                break;
            default:
                throw new java.lang.IllegalArgumentException(
                  "Invalid unit type");
        }
        region.
          setRect(
            region.
              getX(
                ) +
              dx,
            region.
              getY(
                ) +
              dy,
            region.
              getWidth(
                ) +
              dw,
            region.
              getHeight(
                ) +
              dh);
        return region;
    }
    public static java.awt.geom.Rectangle2D getBaseFilterPrimitiveRegion(org.w3c.dom.Element filterPrimitiveElement,
                                                                         org.w3c.dom.Element filteredElement,
                                                                         org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                         java.awt.geom.Rectangle2D defaultRegion,
                                                                         org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s;
        org.apache.batik.parser.UnitProcessor.Context uctx;
        uctx =
          org.apache.batik.bridge.UnitProcessor.
            createContext(
              ctx,
              filteredElement);
        double x =
          defaultRegion.
          getX(
            );
        s =
          filterPrimitiveElement.
            getAttributeNS(
              null,
              SVG_X_ATTRIBUTE);
        if (s.
              length(
                ) !=
              0) {
            x =
              org.apache.batik.bridge.UnitProcessor.
                svgHorizontalCoordinateToUserSpace(
                  s,
                  SVG_X_ATTRIBUTE,
                  uctx);
        }
        double y =
          defaultRegion.
          getY(
            );
        s =
          filterPrimitiveElement.
            getAttributeNS(
              null,
              SVG_Y_ATTRIBUTE);
        if (s.
              length(
                ) !=
              0) {
            y =
              org.apache.batik.bridge.UnitProcessor.
                svgVerticalCoordinateToUserSpace(
                  s,
                  SVG_Y_ATTRIBUTE,
                  uctx);
        }
        double w =
          defaultRegion.
          getWidth(
            );
        s =
          filterPrimitiveElement.
            getAttributeNS(
              null,
              SVG_WIDTH_ATTRIBUTE);
        if (s.
              length(
                ) !=
              0) {
            w =
              org.apache.batik.bridge.UnitProcessor.
                svgHorizontalLengthToUserSpace(
                  s,
                  SVG_WIDTH_ATTRIBUTE,
                  uctx);
        }
        double h =
          defaultRegion.
          getHeight(
            );
        s =
          filterPrimitiveElement.
            getAttributeNS(
              null,
              SVG_HEIGHT_ATTRIBUTE);
        if (s.
              length(
                ) !=
              0) {
            h =
              org.apache.batik.bridge.UnitProcessor.
                svgVerticalLengthToUserSpace(
                  s,
                  SVG_HEIGHT_ATTRIBUTE,
                  uctx);
        }
        return new java.awt.geom.Rectangle2D.Double(
          x,
          y,
          w,
          h);
    }
    public static java.awt.geom.Rectangle2D convertFilterPrimitiveRegion(org.w3c.dom.Element filterPrimitiveElement,
                                                                         org.w3c.dom.Element filterElement,
                                                                         org.w3c.dom.Element filteredElement,
                                                                         org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                         java.awt.geom.Rectangle2D defaultRegion,
                                                                         java.awt.geom.Rectangle2D filterRegion,
                                                                         org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String units =
          "";
        if (filterElement !=
              null) {
            units =
              getChainableAttributeNS(
                filterElement,
                null,
                SVG_PRIMITIVE_UNITS_ATTRIBUTE,
                ctx);
        }
        short unitsType;
        if (units.
              length(
                ) ==
              0) {
            unitsType =
              USER_SPACE_ON_USE;
        }
        else {
            unitsType =
              parseCoordinateSystem(
                filterElement,
                SVG_FILTER_UNITS_ATTRIBUTE,
                units,
                ctx);
        }
        java.lang.String xStr =
          "";
        java.lang.String yStr =
          "";
        java.lang.String wStr =
          "";
        java.lang.String hStr =
          "";
        if (filterPrimitiveElement !=
              null) {
            xStr =
              filterPrimitiveElement.
                getAttributeNS(
                  null,
                  SVG_X_ATTRIBUTE);
            yStr =
              filterPrimitiveElement.
                getAttributeNS(
                  null,
                  SVG_Y_ATTRIBUTE);
            wStr =
              filterPrimitiveElement.
                getAttributeNS(
                  null,
                  SVG_WIDTH_ATTRIBUTE);
            hStr =
              filterPrimitiveElement.
                getAttributeNS(
                  null,
                  SVG_HEIGHT_ATTRIBUTE);
        }
        double x =
          defaultRegion.
          getX(
            );
        double y =
          defaultRegion.
          getY(
            );
        double w =
          defaultRegion.
          getWidth(
            );
        double h =
          defaultRegion.
          getHeight(
            );
        org.apache.batik.parser.UnitProcessor.Context uctx =
          org.apache.batik.bridge.UnitProcessor.
          createContext(
            ctx,
            filteredElement);
        switch (unitsType) {
            case OBJECT_BOUNDING_BOX:
                java.awt.geom.Rectangle2D bounds =
                  filteredNode.
                  getGeometryBounds(
                    );
                if (bounds !=
                      null) {
                    if (xStr.
                          length(
                            ) !=
                          0) {
                        x =
                          org.apache.batik.bridge.UnitProcessor.
                            svgHorizontalCoordinateToObjectBoundingBox(
                              xStr,
                              SVG_X_ATTRIBUTE,
                              uctx);
                        x =
                          bounds.
                            getX(
                              ) +
                            x *
                            bounds.
                            getWidth(
                              );
                    }
                    if (yStr.
                          length(
                            ) !=
                          0) {
                        y =
                          org.apache.batik.bridge.UnitProcessor.
                            svgVerticalCoordinateToObjectBoundingBox(
                              yStr,
                              SVG_Y_ATTRIBUTE,
                              uctx);
                        y =
                          bounds.
                            getY(
                              ) +
                            y *
                            bounds.
                            getHeight(
                              );
                    }
                    if (wStr.
                          length(
                            ) !=
                          0) {
                        w =
                          org.apache.batik.bridge.UnitProcessor.
                            svgHorizontalLengthToObjectBoundingBox(
                              wStr,
                              SVG_WIDTH_ATTRIBUTE,
                              uctx);
                        w *=
                          bounds.
                            getWidth(
                              );
                    }
                    if (hStr.
                          length(
                            ) !=
                          0) {
                        h =
                          org.apache.batik.bridge.UnitProcessor.
                            svgVerticalLengthToObjectBoundingBox(
                              hStr,
                              SVG_HEIGHT_ATTRIBUTE,
                              uctx);
                        h *=
                          bounds.
                            getHeight(
                              );
                    }
                }
                break;
            case USER_SPACE_ON_USE:
                if (xStr.
                      length(
                        ) !=
                      0) {
                    x =
                      org.apache.batik.bridge.UnitProcessor.
                        svgHorizontalCoordinateToUserSpace(
                          xStr,
                          SVG_X_ATTRIBUTE,
                          uctx);
                }
                if (yStr.
                      length(
                        ) !=
                      0) {
                    y =
                      org.apache.batik.bridge.UnitProcessor.
                        svgVerticalCoordinateToUserSpace(
                          yStr,
                          SVG_Y_ATTRIBUTE,
                          uctx);
                }
                if (wStr.
                      length(
                        ) !=
                      0) {
                    w =
                      org.apache.batik.bridge.UnitProcessor.
                        svgHorizontalLengthToUserSpace(
                          wStr,
                          SVG_WIDTH_ATTRIBUTE,
                          uctx);
                }
                if (hStr.
                      length(
                        ) !=
                      0) {
                    h =
                      org.apache.batik.bridge.UnitProcessor.
                        svgVerticalLengthToUserSpace(
                          hStr,
                          SVG_HEIGHT_ATTRIBUTE,
                          uctx);
                }
                break;
            default:
                throw new java.lang.Error(
                  "invalid unitsType:" +
                  unitsType);
        }
        java.awt.geom.Rectangle2D region =
          new java.awt.geom.Rectangle2D.Double(
          x,
          y,
          w,
          h);
        units =
          "";
        if (filterElement !=
              null) {
            units =
              getChainableAttributeNS(
                filterElement,
                null,
                org.apache.batik.util.SVG12Constants.
                  SVG_FILTER_PRIMITIVE_MARGINS_UNITS_ATTRIBUTE,
                ctx);
        }
        if (units.
              length(
                ) ==
              0) {
            unitsType =
              USER_SPACE_ON_USE;
        }
        else {
            unitsType =
              parseCoordinateSystem(
                filterElement,
                org.apache.batik.util.SVG12Constants.
                  SVG_FILTER_PRIMITIVE_MARGINS_UNITS_ATTRIBUTE,
                units,
                ctx);
        }
        java.lang.String dxStr =
          "";
        java.lang.String dyStr =
          "";
        java.lang.String dwStr =
          "";
        java.lang.String dhStr =
          "";
        if (filterPrimitiveElement !=
              null) {
            dxStr =
              filterPrimitiveElement.
                getAttributeNS(
                  null,
                  org.apache.batik.util.SVG12Constants.
                    SVG_MX_ATRIBUTE);
            dyStr =
              filterPrimitiveElement.
                getAttributeNS(
                  null,
                  org.apache.batik.util.SVG12Constants.
                    SVG_MY_ATRIBUTE);
            dwStr =
              filterPrimitiveElement.
                getAttributeNS(
                  null,
                  org.apache.batik.util.SVG12Constants.
                    SVG_MW_ATRIBUTE);
            dhStr =
              filterPrimitiveElement.
                getAttributeNS(
                  null,
                  org.apache.batik.util.SVG12Constants.
                    SVG_MH_ATRIBUTE);
        }
        if (dxStr.
              length(
                ) ==
              0) {
            dxStr =
              org.apache.batik.util.SVG12Constants.
                SVG_FILTER_MX_DEFAULT_VALUE;
        }
        if (dyStr.
              length(
                ) ==
              0) {
            dyStr =
              org.apache.batik.util.SVG12Constants.
                SVG_FILTER_MY_DEFAULT_VALUE;
        }
        if (dwStr.
              length(
                ) ==
              0) {
            dwStr =
              org.apache.batik.util.SVG12Constants.
                SVG_FILTER_MW_DEFAULT_VALUE;
        }
        if (dhStr.
              length(
                ) ==
              0) {
            dhStr =
              org.apache.batik.util.SVG12Constants.
                SVG_FILTER_MH_DEFAULT_VALUE;
        }
        region =
          extendRegion(
            dxStr,
            dyStr,
            dwStr,
            dhStr,
            unitsType,
            filteredNode,
            region,
            uctx);
        java.awt.geom.Rectangle2D.
          intersect(
            region,
            filterRegion,
            region);
        return region;
    }
    public static java.awt.geom.Rectangle2D convertFilterPrimitiveRegion(org.w3c.dom.Element filterPrimitiveElement,
                                                                         org.w3c.dom.Element filteredElement,
                                                                         org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                         java.awt.geom.Rectangle2D defaultRegion,
                                                                         java.awt.geom.Rectangle2D filterRegion,
                                                                         org.apache.batik.bridge.BridgeContext ctx) {
        org.w3c.dom.Node parentNode =
          filterPrimitiveElement.
          getParentNode(
            );
        org.w3c.dom.Element filterElement =
          null;
        if (parentNode !=
              null &&
              parentNode.
              getNodeType(
                ) ==
              org.w3c.dom.Node.
                ELEMENT_NODE) {
            filterElement =
              (org.w3c.dom.Element)
                parentNode;
        }
        return convertFilterPrimitiveRegion(
                 filterPrimitiveElement,
                 filterElement,
                 filteredElement,
                 filteredNode,
                 defaultRegion,
                 filterRegion,
                 ctx);
    }
    public static final short USER_SPACE_ON_USE =
      1;
    public static final short OBJECT_BOUNDING_BOX =
      2;
    public static final short STROKE_WIDTH =
      3;
    public static short parseCoordinateSystem(org.w3c.dom.Element e,
                                              java.lang.String attr,
                                              java.lang.String coordinateSystem,
                                              org.apache.batik.bridge.BridgeContext ctx) {
        if (SVG_USER_SPACE_ON_USE_VALUE.
              equals(
                coordinateSystem)) {
            return USER_SPACE_ON_USE;
        }
        else
            if (SVG_OBJECT_BOUNDING_BOX_VALUE.
                  equals(
                    coordinateSystem)) {
                return OBJECT_BOUNDING_BOX;
            }
            else {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  e,
                  ERR_ATTRIBUTE_VALUE_MALFORMED,
                  new java.lang.Object[] { attr,
                  coordinateSystem });
            }
    }
    public static short parseMarkerCoordinateSystem(org.w3c.dom.Element e,
                                                    java.lang.String attr,
                                                    java.lang.String coordinateSystem,
                                                    org.apache.batik.bridge.BridgeContext ctx) {
        if (SVG_USER_SPACE_ON_USE_VALUE.
              equals(
                coordinateSystem)) {
            return USER_SPACE_ON_USE;
        }
        else
            if (SVG_STROKE_WIDTH_VALUE.
                  equals(
                    coordinateSystem)) {
                return STROKE_WIDTH;
            }
            else {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  e,
                  ERR_ATTRIBUTE_VALUE_MALFORMED,
                  new java.lang.Object[] { attr,
                  coordinateSystem });
            }
    }
    protected static java.awt.geom.Rectangle2D convertRegion(java.lang.String xStr,
                                                             java.lang.String yStr,
                                                             java.lang.String wStr,
                                                             java.lang.String hStr,
                                                             short unitsType,
                                                             org.apache.batik.gvt.GraphicsNode targetNode,
                                                             org.apache.batik.parser.UnitProcessor.Context uctx) {
        double x;
        double y;
        double w;
        double h;
        switch (unitsType) {
            case OBJECT_BOUNDING_BOX:
                x =
                  org.apache.batik.bridge.UnitProcessor.
                    svgHorizontalCoordinateToObjectBoundingBox(
                      xStr,
                      SVG_X_ATTRIBUTE,
                      uctx);
                y =
                  org.apache.batik.bridge.UnitProcessor.
                    svgVerticalCoordinateToObjectBoundingBox(
                      yStr,
                      SVG_Y_ATTRIBUTE,
                      uctx);
                w =
                  org.apache.batik.bridge.UnitProcessor.
                    svgHorizontalLengthToObjectBoundingBox(
                      wStr,
                      SVG_WIDTH_ATTRIBUTE,
                      uctx);
                h =
                  org.apache.batik.bridge.UnitProcessor.
                    svgVerticalLengthToObjectBoundingBox(
                      hStr,
                      SVG_HEIGHT_ATTRIBUTE,
                      uctx);
                java.awt.geom.Rectangle2D bounds =
                  targetNode.
                  getGeometryBounds(
                    );
                if (bounds !=
                      null) {
                    x =
                      bounds.
                        getX(
                          ) +
                        x *
                        bounds.
                        getWidth(
                          );
                    y =
                      bounds.
                        getY(
                          ) +
                        y *
                        bounds.
                        getHeight(
                          );
                    w *=
                      bounds.
                        getWidth(
                          );
                    h *=
                      bounds.
                        getHeight(
                          );
                }
                else {
                    x =
                      (y =
                         (w =
                            (h =
                               0)));
                }
                break;
            case USER_SPACE_ON_USE:
                x =
                  org.apache.batik.bridge.UnitProcessor.
                    svgHorizontalCoordinateToUserSpace(
                      xStr,
                      SVG_X_ATTRIBUTE,
                      uctx);
                y =
                  org.apache.batik.bridge.UnitProcessor.
                    svgVerticalCoordinateToUserSpace(
                      yStr,
                      SVG_Y_ATTRIBUTE,
                      uctx);
                w =
                  org.apache.batik.bridge.UnitProcessor.
                    svgHorizontalLengthToUserSpace(
                      wStr,
                      SVG_WIDTH_ATTRIBUTE,
                      uctx);
                h =
                  org.apache.batik.bridge.UnitProcessor.
                    svgVerticalLengthToUserSpace(
                      hStr,
                      SVG_HEIGHT_ATTRIBUTE,
                      uctx);
                break;
            default:
                throw new java.lang.Error(
                  "invalid unitsType:" +
                  unitsType);
        }
        return new java.awt.geom.Rectangle2D.Double(
          x,
          y,
          w,
          h);
    }
    public static java.awt.geom.AffineTransform convertTransform(org.w3c.dom.Element e,
                                                                 java.lang.String attr,
                                                                 java.lang.String transform,
                                                                 org.apache.batik.bridge.BridgeContext ctx) {
        try {
            return org.apache.batik.parser.AWTTransformProducer.
              createAffineTransform(
                transform);
        }
        catch (org.apache.batik.parser.ParseException pEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              e,
              pEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { attr,
              transform,
              pEx });
        }
    }
    public static java.awt.geom.AffineTransform toObjectBBox(java.awt.geom.AffineTransform Tx,
                                                             org.apache.batik.gvt.GraphicsNode node) {
        java.awt.geom.AffineTransform Mx =
          new java.awt.geom.AffineTransform(
          );
        java.awt.geom.Rectangle2D bounds =
          node.
          getGeometryBounds(
            );
        if (bounds !=
              null) {
            Mx.
              translate(
                bounds.
                  getX(
                    ),
                bounds.
                  getY(
                    ));
            Mx.
              scale(
                bounds.
                  getWidth(
                    ),
                bounds.
                  getHeight(
                    ));
        }
        Mx.
          concatenate(
            Tx);
        return Mx;
    }
    public static java.awt.geom.Rectangle2D toObjectBBox(java.awt.geom.Rectangle2D r,
                                                         org.apache.batik.gvt.GraphicsNode node) {
        java.awt.geom.Rectangle2D bounds =
          node.
          getGeometryBounds(
            );
        if (bounds !=
              null) {
            return new java.awt.geom.Rectangle2D.Double(
              bounds.
                getX(
                  ) +
                r.
                getX(
                  ) *
                bounds.
                getWidth(
                  ),
              bounds.
                getY(
                  ) +
                r.
                getY(
                  ) *
                bounds.
                getHeight(
                  ),
              r.
                getWidth(
                  ) *
                bounds.
                getWidth(
                  ),
              r.
                getHeight(
                  ) *
                bounds.
                getHeight(
                  ));
        }
        else {
            return new java.awt.geom.Rectangle2D.Double(
              );
        }
    }
    public static float convertSnapshotTime(org.w3c.dom.Element e,
                                            org.apache.batik.bridge.BridgeContext ctx) {
        if (!e.
              hasAttributeNS(
                null,
                SVG_SNAPSHOT_TIME_ATTRIBUTE)) {
            return 0.0F;
        }
        java.lang.String t =
          e.
          getAttributeNS(
            null,
            SVG_SNAPSHOT_TIME_ATTRIBUTE);
        if (t.
              equals(
                SVG_NONE_VALUE)) {
            return 0.0F;
        }
        class Handler implements org.apache.batik.parser.ClockHandler {
            float
              time;
            public void clockValue(float t) {
                time =
                  t;
            }
            public Handler() {
                super(
                  );
            }
        }
        ;
        org.apache.batik.parser.ClockParser p =
          new org.apache.batik.parser.ClockParser(
          false);
        Handler h =
          new Handler(
          );
        p.
          setClockHandler(
            h);
        try {
            p.
              parse(
                t);
        }
        catch (org.apache.batik.parser.ParseException pEx) {
            throw new org.apache.batik.bridge.BridgeException(
              null,
              e,
              pEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_SNAPSHOT_TIME_ATTRIBUTE,
              t,
              pEx });
        }
        return h.
                 time;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "+fm+Rz8AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL18C9Dr6Fmez9lz9sZmr2R3s8lusptNIBEc2ZZs2V0CsWzr" +
       "Yku+SLZkqzQH3S3rat0si6YJTEtC6aRpmpC0Q7bMNFCa2ZAMAy0zlM7SDg0p" +
       "TDpc2lJKCTAMpE3TSdI2FNJCP8n///v//z3nX3bOWTyjT/J3fd/ne9/3ez9/" +
       "r/XClytXo7ACBb6zMx0/vqZn8bW107gW7wI9ujZgGhM5jHSt68hRNAN519Vn" +
       "PvPA17/xwdWDlyt3SpVHZM/zYzm2fC/i9Mh3Ul1jKg8ccvuO7kZx5UFmLacy" +
       "nMSWAzNWFD/HVL7pVNO48ixzTAIMSIABCXBJAtw51AKNXqN7idstWsheHG0q" +
       "f6NyiancGagFeXHl6bOdBHIou0fdTEoOQA93F98FwFTZOAsrbzrhfc/zSxj+" +
       "CAR/+KPvevCn7qg8IFUesDy+IEcFRMRgEKlyn6u7ih5GHU3TNanykKfrGq+H" +
       "luxYeUm3VHk4skxPjpNQPwGpyEwCPSzHPCB3n1rwFiZq7Icn7BmW7mjH364a" +
       "jmwCXh898LrnkCjyAYP3WoCw0JBV/bjJFdvytLjyxvMtTnh8dggqgKZ3uXq8" +
       "8k+GuuLJIKPy8H7uHNkzYT4OLc8EVa/6CRglrjxx004LrANZtWVTvx5XHj9f" +
       "b7IvArXuKYEomsSV156vVvYEZumJc7N0an6+PPqOD3yvR3mXS5o1XXUK+u8G" +
       "jZ4614jTDT3UPVXfN7zv7cwPy4/+/PsvVyqg8mvPVd7X+ed//avv/LanXvyl" +
       "fZ3X36DOWFnranxd/YRy/6++ofu29h0FGXcHfmQVk3+G81L8J0clz2UB0LxH" +
       "T3osCq8dF77I/Zvlez+pf+ly5V66cqfqO4kL5Ogh1XcDy9FDUvf0UI51ja7c" +
       "o3tatyynK3eBZ8by9H3u2DAiPaYrV5wy606//A4gMkAXBUR3gWfLM/zj50CO" +
       "V+VzFlQqlQfBVRmAq1XZf8p7XBHhle/qsKzKnuX58CT0C/4jWPdiBWC7ghUg" +
       "9TYc+UkIRBD2QxOWgRys9KMCJbQ0U4d5gZwDjgG3AMdCwIJXr+us4OrB7aVL" +
       "APA3nFd3B2gK5TuaHl5XP5zg/a/+5PVfvnwi/kd4AAMFRru2H+1aOdq1/WjX" +
       "To9WuXSpHOSbi1H3MwrmwwaaDWzefW/j/9rge97/zB1AlILtFQBmURW+uent" +
       "HmwBXVo8FQhk5cWPbb9PeE/1cuXyWRtaUAqy7i2aTwrLd2Lhnj2vOzfq94H3" +
       "ffHrn/7hd/sHLTpjlI+U+6UtC+V85jymoa/qGjB3h+7f/ib5Z67//LufvVy5" +
       "AjQeWLlYBlIJDMhT58c4o6TPHRu8gpergGHDD13ZKYqOrdS98Sr0t4eccrLv" +
       "L58fAhjfX0jtE+B6x5EYl/ei9JGgSL95LxzFpJ3jojSo7+CDj//m5/8rUsJ9" +
       "bHsfOLWa8Xr83Cl9Lzp7oNTshw4yMAt1HdT7Lx+b/P2PfPl9f7UUAFDjzTca" +
       "8Nki7QI9B1MIYP5bv7T5T1/4nU/8xuWD0MSVe4LQj4Fm6Fp2wmdRVHnNBXyC" +
       "Ad96IAmYDAf0UAjOs3PP9TXLsGTF0QtB/b8PvKX2M//9Aw/uRcEBOceS9G0v" +
       "38Eh/3V45b2//K4/fqrs5pJaLFkH2A7V9nbwkUPPnTCUdwUd2ff92pP/4LPy" +
       "x4FFBVYssnK9NEyVEoZKOW9wyf/by/TaubJakbwxOi3/Z1XslGtxXf3gb3zl" +
       "NcJX/uVXS2rP+ianp5uVg+f2ElYkb8pA94+dV3ZKjlagHvri6LsfdF78BuhR" +
       "Aj2qwGRF4xDYmeyMcBzVvnrXb/3Cv370e371jsplonKv48saIZd6VrkHCLge" +
       "rYCJyoLveud+crd3H1vorPIS5vdC8Xj57U5A4NtubmKIwrU4aOnjfzp2lO//" +
       "/f/zEhBK43KDFfVcewl+4Uee6H7nl8r2By0vWj+VvdT2Ajfs0Lb+Sfd/X37m" +
       "zl+8XLlLqjyoHvl4guwkhe5IwK+Jjh0/4AeeKT/ro+wX5OdOrNgbzluYU8Oe" +
       "ty8Hmw+ei9rF873nTMrjBcooULn79pOxv582KeUisJ/jgqRrNHDJTD18+Pd/" +
       "9BN//H3va10uBPpqWpAOUHnwUG+UFK7kD7zwkSe/6cO/+0OlzhcaX3T6XeXw" +
       "T5fps0XyLeX83hED9zdRHAvo151R6ZnGgCXLk50j2/Dn4HMJXH9WXAWhRcZ+" +
       "KX+4e+RPvOnEoQjAUvfQnO9z1/lJp9u/Ph5dB98uFqJJaLnA+KVHbhX87oe/" +
       "YP/IFz+1d5nOS8y5yvr7P/y3//zaBz58+ZSj+uaX+Iqn2+yd1XJKXlMkdKGD" +
       "T180StmC+KNPv/vnfuLd79tT9fBZt6sPdhWf+g//71eufex3P3eDtf8q0L4w" +
       "3q8TRVovknfu8W3cVCX/ylmBaQJBeeBIYB64gcAUDx2Qfbl4EG4y28UjUSRk" +
       "kVAlCnRceWSMD/rd2XV8PB/16BEJHhZF0fgczeIrpBkGtD58RPPDF9Bc0vWu" +
       "V0bzffyMGw/710W6N6NuROz1lyV2P/2XwIp4tX4Nu1YtvhuvjIrH1o767LEa" +
       "CGAbB6zds2sHK9u/Nj6tnPu9zzki6b8wkUBK7z90xvhgG/VDf/DBX/m7b/4C" +
       "kLjBsTkoauNA5YX3vuVL7y2++K+MnycKfvjSQWbkKGbLdVnXTlhiThE9icHq" +
       "7t8CS/FjVyg0ojvHH0ZQushUrS1cKEHCJq2nqwG2dNI6NyPbwGRMp5upNYwl" +
       "IXYZ3uXh4Ypl+nIuNJOMyye9nKgFmMoN0B5f4wV6rE53q6EhBbNt1aXwOB8P" +
       "ycmo72mquUH9medUeX7aIb0uP7cHeCOedjxKaU/g1NOcBsY2/WEYNSWoOW7E" +
       "GIbAMIylUFODmqrhp3OxKwV+FjBRhyVjjtHIJFnM6NidbwJbnE+2Sn8GicGi" +
       "2sRqaXuELgfYoieNmqhE1heDZZwIG0uOltJg0xxIs9HAllOBd6M+2HzItU3P" +
       "Dtj5YrGKnG6mbySW4AghXtUn83G2nWOD2WDkWjNiRqrVrO6ys+VwWutJW3vM" +
       "G4PcxWtcI2SdxWJtjuKWJWuNnTPuMbyhRnxGujGDBX07cMXx0LW3IZGktAtN" +
       "QQ/qRCJEbSBa+sCQA7JepePNHCFscguFFNneYRrbxvq0ZKayFI4Tai2C+apq" +
       "0sCtbmacoW3iqumFWjqQ5sHcVfPdiBSdyRhl3aXWsXvjgG5iyy62SnwniOmm" +
       "sFUbTnczEjnbGhCCYQ1Jqe/PRoED5evRdEPqdYzZ5jyT7OhhfRrZ677ebNNU" +
       "msrIRqE21fWaJZ153Cdsbrt0yc5216N7vCUQGzGoSz22ytr15WjgJVPX39hD" +
       "04hdsZk5w60bcRmbbllmEm2l2phbJ84an9CDSLIbbuLYUwXdhs6kZuSSuZHm" +
       "lMjJzWgaMSMI3/a9YbWzhOQlTgWe1gSLXt2UOGfZ1zPOVpgWQdq9RWJ6wyxd" +
       "dOcjUcY7bdqqdThBG+52c2I64avMTIyrc2BubVlccTgRThsMwtfsprnyJXmk" +
       "pptNT2A6aF9zCXupdKRgy+dxb7rlG1hDl1MkCCM4FBEBtabkhNT9sMvAahOf" +
       "ic3erIPX1wNzjvVxxFPstTHYIc086KO0hqNLuZvJk9HCwzzU4lMlX1fXdWsb" +
       "VmUp1XBIqC9XLdWb6WornjXrUDRdK5ueVuPVyaBte2zYxLRwnNKkPlgR+DJY" +
       "uovOJt9WW+2pbhgoD5G8nutVKw6HSaOrddeS4xoszguuk/icXR9U59uJOxdr" +
       "MzpctBudZtJvheRKmEAthWTYoMkziyHVXmxgCurInYym+3yOChiXeTMPCXrL" +
       "MQNPSJSfDsI1PQpXCT0eTuB8uBvmbjJrd+1BP5H9xBsYzoiC5KqtDzJuSy1b" +
       "42kgp3k7aM7smdDrBm7btXEK7PmS+nAuTAYS6ezUsS5SfCfjOxHq+7Tk8GON" +
       "a3rurCVYncl65zNuuOw6igZ6yDmqIQ6bIQQN13S7Ndv4s40CsXjPDEgeXXN9" +
       "b1dd4WaMcvVRRg5admeOboIV59JweznyTDHREwrO53GcjMMh2hVmQ3djEqzC" +
       "hDJRH/BhamMTL+5P4pRXqZ6waastkjcEWaOtHb/1NpyZjaNqBHUHjbReT9Sq" +
       "uoIYM1sO5x7u9rasJ0pS1CFW6rwLlLM9sZ2RwWJ0x2wRg+pwxfBKD62OBnDk" +
       "NqCmkdQnbmMDsTbmGdiYnI70bh4hPjxOku68jk7chR8kKNRHkHWMITtKGy0y" +
       "g6Ko7qJGTBySqM079W6LzmmyJg1naNZq1DrYCqmKY3LpmjyJ5/WIWSdUPszq" +
       "43VVkpo2ZbJaXbUJPlLXXT1XpZGhBu1tKuau1ko7jLhcoXKdGDYndUmhDIyo" +
       "20vKWW6oyYZU8eHCZKGRZapGRgG77Ghclgxq26qeMC2anGvUSicyYoOy9aBe" +
       "Wyh0gM/kdDGA4ZqRGnq6pTbNvEoORpsppUTzHS6joMrAgltsDqwjUm9G9gJt" +
       "NnU2ZxiWmpOZvc2h5VAV+3OZTvh+R9MbDE0u5mi/O7QxrGfW5gLuzAKCFHwX" +
       "aQvQRJYbGFrTaqPpSpjr44FfDRazPtI1Fm2JmKRQO1XaAVrnLNaWJCKXEXfR" +
       "01o1ZOjJy4Cad6CWp7YQ2Pdm1ZSip1YHxcS52Zhh82iwoqlcH3lMI4QUp70k" +
       "m+v6MKulzCZtw/3JyJtaVD6xMlXWHAzF7MU4nEFay8YQLfL8Pr4hM8Vv2URL" +
       "bffbykCM1LpTg8PUEAfpQh3IHbSHc06LGYje1k1YvT3rhXFtpiGMAcO2Hyf6" +
       "ZsdkucjXN3Yi5dwQYXOaIQaZjEK40Gop1GTXd7VmqHf5oDG3uFZ1yvb1/iLY" +
       "6InO4iYFQbjBwJg7k7VxyvpCznWqTkpBgr72jWVTGEBioszg3dY24LbGLbAg" +
       "4peLWjvps0ybSHf1vFFrs00jFVr98UJzBsJwPJ3Aq8bYppyNlBjBBNGQ6rDt" +
       "YhNiq3otNk6QemS4xnoCjUPZQHezxKX4wSgetPqNQS6TTs+eWFLuSiw/G6Ze" +
       "APctdef4zW5e2+ptUteXy4med+pDlYbiloKuULYrovisqxDKhBDY1Air43Vf" +
       "G/gCRc83NKXGy2gkxFDbVT0DmVAol1pyD63ZLbPpjxg7TtLRUsbaHGBDkWo5" +
       "NtQMdDWewKY4aKe9FQMZDm7tkv4m7Cyp+pREBYeIs+WEEjx6MLR4Mez0d/Xx" +
       "cmBxjVW9h0zZtQnXtY3e5FJgeSC2ZaQ9otNLJJKZWtWdOUNrcxvbKbs6nCsN" +
       "nkrhJliKGCvlpgqnQFRvt0YMSB1BOUKmi+XONNS4V8NJn4ak5rTKT/sQjrQy" +
       "vdeksN1UXWxNOxRFZ1DNQmtnr0kzsHnf6HfxxmYs1uAp1FLnS7o/mqVTctRs" +
       "jMyF0dBRqLHebuuMFslLv20Y9b4YTegpKiYNEhMEct3CmwoMI5GvtNvQCF9t" +
       "BZGZoGmysheWy8GtNjYeQEi7mdrTjbAd6ztxSjgZGzZImoEZds2NgqoAjRGs" +
       "7gZ1MwumHSjI694Qm3myDRPKNKgLJCywDpZYqoz0CLPprQJqiQcm0Vf5LO2Q" +
       "jDKntXGVaUtqkC6yFj4S69WaImYrClnlPLId0yiC7ijSVIy2SG15C+3zxKpf" +
       "x7uTHMI2dU3WSS4Mm1rKJc3E0zprHYuAMzjt4c7Kp52lMhX1Ni922T7awgw4" +
       "3c4ZEh1yyXLU6yB1RKPhqBnb1ZgR5xwp97mJx/cmhNQkdXthDpnRjmCTVZ5N" +
       "0Nkibvd2gU0kSzrNoZ3Iht2GvPZ6o1VLoJcLoy8rfqKMF7wibZqiaI21WJXj" +
       "KHRHnrHLXdZjvepksRojUSYsa1HbSjxS4C09aLrEjhSYHafBsUHAeE8U07yX" +
       "NltYO8gRZST1xV7e3riiMjHhXdqh6lu6XW/gQtCEWjkk9uJqy4gjlrDUsGOZ" +
       "BL9orCHIy0Vgcjho1OpXF/06YIVAIK8XtmBXrPHOmq2lW02atzvLBZ5Mews8" +
       "jmeCK7dxdkHPR9U5l5AmGcp00yT7K5mS2sGmDThlSDAq1+eCNo12l0beAw4O" +
       "H3E74DCK1A4418sok2tCk2SQbKxRCzHFWt4MovMNl3V0DffaUJ1um50NuhLb" +
       "zVVk9Zfcui9vhWVqxpJNWDVp0Itb4pKM4fW2u9vqGUSMlpE9kXFM6RgM0ibb" +
       "LpHSbCraPJsgi/EcaXuwOk+plcHFBCf222ZTh1fz1MjXwCfXtVqOz9bQbgh1" +
       "mwgr4zCCoSmH+COfYNgREq16ceInC3lk+us118gUxfRaOo6gm34NrHmqNVvA" +
       "WayN2kufSE1HFZdOzFcho9vUDB2eNFaxRCVTKOLstidtYQjWMAsTcoOxalSa" +
       "kQyHThNshTfwsGW04zzN5O2i5q4IfQpDbstd1Nhk7uPRekFPYHUdhOS4BzyI" +
       "ZUtsCrLj1xfohhj2Dald87rUehL36sgWQeZQkNhSZunY3FpWa9y8NddiaxWt" +
       "Z/lquwCD93iPmnDQFqyFilLT+jNN53c6Tq6cBjGliZhq1Wc9pDEh7EybdFO9" +
       "0yOMbncyQpoTxdzFm5q7S5bEdrci9So14W2oJesdNsV5vNmNlynbQ/V47UGT" +
       "XmO5a7SY2rKT2uJYr43ipSbutpxGRjOuBY1hxmBwg7N7tcFqCUvA6G6X1HDh" +
       "SRg11UWkEYxJAUqd3rC+zYVglzek0XrWG/abVMNUOZnAumissylG9EYddauY" +
       "/ByLq8MtxUs+wlHKkBw7HbAzo0NuFCZVbqxY/JRYa3rfzBLJ7Isjm9rwHbdp" +
       "Oi4arrC+BS/oDnBZ2vOObyXYjlCatDHEXXaZTTtjVTLm86nBCCLBxFxVHM2S" +
       "vLfh8LnToJ06xfUGeJe2xhMCDkZOls7X+qYJNkIxGSWTWOBMxtlkvWCSee01" +
       "DYu8qzb6/ohTGdqyyLy1AEiMJwvOxlkUXYpbYxx38JzcDMRZFFj9FR5qUxJL" +
       "CRpCyQ2KhBMCqFW0W8UkO8WJEa8JubRYcGqNQzFhJcc5YUC7dT/LKQSFOxC5" +
       "BNZGs9mFRdUYy5YH64iYN+F2ByURdkbyoTvQxA4lbBMZDVWVpzW+18H5XdUT" +
       "EquHWbXquOGowlLEzCm3zKP5aJaxsbFrMyPNguv13XCLAR/dzlId8haEZtHb" +
       "mj3UA9uZMQPSQSdcA1FEBRl4fuhwzQhXtmTIZeQuV2Y0x/VGWqMHoz62q6qR" +
       "E63REXBu5hi5aEWmR4KdMTsUldCf1mtzvD7abBnT6zYVearHjtltsuhaTugu" +
       "pUi8pCyXdkgm3YGSijTGtCSjp87qnNhlmnM6QiG5Vt8JIbztjcZejLKjgWN4" +
       "Vc0Hm1apWePDFsbzPgEzc7ya+cpmNvI6PdA/ZZh+00MXtVa7j04Ciekq2kQW" +
       "ILD/38jmQA57I7U9XG5MvEnSGD2UqJxyUlGLNgQC9nUoy/ltBQ3dZaoQXXYH" +
       "rdm5kUQply/9odup0/AyThNq1faFYdY0FVNruOZwgTGmoPqZ0Z4JScfSkFZf" +
       "dWAKtcy1opKEgbeNvm1tIBpGJsLCtBmoJXJbh623m7hvG3meQv6I0qTYYsX6" +
       "kFzOdwicMZhsCq7Sw8TFlFCDep7Ms3Y922yAzQ51SZhEbuyyuIH0mktT0jOe" +
       "WWUrCY1HNW9jCW2c9IZ+zxxudlg3mbakVowpmyW9sqra1LLJ/tDzgnEArDfG" +
       "9nLLrI/SMcGggqlvkMgw3QHRnAZCP55nzGCw23QGA6aDSQYK7LdKIdlywWfo" +
       "GgbWKmlTdM3r8Zo4r/YXPUFdefSmhw12OWRKlBMRmI+aRjbn+4y01YbT1LFx" +
       "GWiaQ00JBnZMhhkatqAKBi1Ey3hIAf1ooOzOGqpUDW/3zYm/Bg4NMZ0Ikj7j" +
       "/bw252udqI7jQN+TUBlFIuJXqVrI8u7WmNS6vQw2VTFkW5M8nm/ioIXnQqgO" +
       "3WSIUJRFzoNsFaf4GKfDdJn2Q5H2dpzYGNZadda3Xba3am7JAdKhwliFRs0N" +
       "QeWLjhEpithHHLMOsbSfm7v2eJuQDL0dZwjYT6/ZMbKYMcgU6o7xlOADGXTg" +
       "z/x4vkg83qWXWh9zyCHqo7sxss62GaQRS9qn0jFTw1ZD2OkuKAnsCjNNWOLN" +
       "lG2GceTqrY2725BzabcaWs2JOayOrOoisVyPdnpTZt3aYrvFJjRgSh/PZFce" +
       "zQzLHmMJwUzBflyP0T66WEv+dmeSPjDV");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "yxdM5D/72E9/xz95/nfKP9r/f7DQa3oLSwAA");
}
