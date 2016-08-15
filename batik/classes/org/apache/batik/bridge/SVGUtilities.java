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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "uNtNRz8AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "a7ZoBO0YsdhVd0i4wagV9wVEwmmgsoBr");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "xPYXH/7cD/yTZ/6g+KP9/wdVpRmaC0sAAA==");
}
