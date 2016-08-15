package org.apache.batik.extension.svg;
public class BatikFlowTextElementBridge extends org.apache.batik.bridge.SVGTextElementBridge implements org.apache.batik.extension.svg.BatikExtConstants {
    public static final java.text.AttributedCharacterIterator.Attribute FLOW_PARAGRAPH =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        FLOW_PARAGRAPH;
    public static final java.text.AttributedCharacterIterator.Attribute
      FLOW_EMPTY_PARAGRAPH =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        FLOW_EMPTY_PARAGRAPH;
    public static final java.text.AttributedCharacterIterator.Attribute
      FLOW_LINE_BREAK =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        FLOW_LINE_BREAK;
    public static final java.text.AttributedCharacterIterator.Attribute
      FLOW_REGIONS =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        FLOW_REGIONS;
    public static final java.text.AttributedCharacterIterator.Attribute
      PREFORMATTED =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        PREFORMATTED;
    public BatikFlowTextElementBridge() { super(); }
    public java.lang.String getNamespaceURI() { return BATIK_12_NAMESPACE_URI;
    }
    public java.lang.String getLocalName() { return BATIK_EXT_FLOW_TEXT_TAG;
    }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.extension.svg.BatikFlowTextElementBridge(
                                                            );
    }
    public boolean isComposite() { return false; }
    protected org.apache.batik.gvt.GraphicsNode instantiateGraphicsNode() {
        return new org.apache.batik.extension.svg.FlowExtTextNode(
          );
    }
    protected java.awt.geom.Point2D getLocation(org.apache.batik.bridge.BridgeContext ctx,
                                                org.w3c.dom.Element e) {
        return new java.awt.geom.Point2D.Float(
          0,
          0);
    }
    protected void addContextToChild(org.apache.batik.bridge.BridgeContext ctx,
                                     org.w3c.dom.Element e) {
        if (getNamespaceURI(
              ).
              equals(
                e.
                  getNamespaceURI(
                    ))) {
            java.lang.String ln =
              e.
              getLocalName(
                );
            if (ln.
                  equals(
                    BATIK_EXT_FLOW_PARA_TAG) ||
                  ln.
                  equals(
                    BATIK_EXT_FLOW_REGION_BREAK_TAG) ||
                  ln.
                  equals(
                    BATIK_EXT_FLOW_LINE_TAG) ||
                  ln.
                  equals(
                    BATIK_EXT_FLOW_SPAN_TAG) ||
                  ln.
                  equals(
                    SVG_A_TAG) ||
                  ln.
                  equals(
                    SVG_TREF_TAG)) {
                ((org.apache.batik.dom.svg.SVGOMElement)
                   e).
                  setSVGContext(
                    new org.apache.batik.extension.svg.BatikFlowTextElementBridge.BatikFlowContentBridge(
                      ctx,
                      this,
                      e));
            }
        }
        org.w3c.dom.Node child =
          getFirstChild(
            e);
        while (child !=
                 null) {
            if (child.
                  getNodeType(
                    ) ==
                  org.w3c.dom.Node.
                    ELEMENT_NODE) {
                addContextToChild(
                  ctx,
                  (org.w3c.dom.Element)
                    child);
            }
            child =
              getNextSibling(
                child);
        }
    }
    protected java.text.AttributedString buildAttributedString(org.apache.batik.bridge.BridgeContext ctx,
                                                               org.w3c.dom.Element element) {
        java.util.List rgns =
          getRegions(
            ctx,
            element);
        java.text.AttributedString ret =
          getFlowDiv(
            ctx,
            element);
        if (ret ==
              null)
            return ret;
        ret.
          addAttribute(
            FLOW_REGIONS,
            rgns,
            0,
            1);
        return ret;
    }
    protected void addGlyphPositionAttributes(java.text.AttributedString as,
                                              org.w3c.dom.Element element,
                                              org.apache.batik.bridge.BridgeContext ctx) {
        if (element.
              getNodeType(
                ) !=
              org.w3c.dom.Node.
                ELEMENT_NODE)
            return;
        java.lang.String eNS =
          element.
          getNamespaceURI(
            );
        if (!eNS.
              equals(
                getNamespaceURI(
                  )) &&
              !eNS.
              equals(
                SVG_NAMESPACE_URI))
            return;
        if (element.
              getLocalName(
                ) !=
              BATIK_EXT_FLOW_TEXT_TAG) {
            super.
              addGlyphPositionAttributes(
                as,
                element,
                ctx);
            return;
        }
        for (org.w3c.dom.Node n =
               element.
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
            java.lang.String nNS =
              n.
              getNamespaceURI(
                );
            if (!getNamespaceURI(
                   ).
                  equals(
                    nNS) &&
                  !SVG_NAMESPACE_URI.
                  equals(
                    nNS)) {
                continue;
            }
            org.w3c.dom.Element e =
              (org.w3c.dom.Element)
                n;
            java.lang.String ln =
              e.
              getLocalName(
                );
            if (ln.
                  equals(
                    BATIK_EXT_FLOW_DIV_TAG)) {
                super.
                  addGlyphPositionAttributes(
                    as,
                    e,
                    ctx);
                return;
            }
        }
    }
    protected void addChildGlyphPositionAttributes(java.text.AttributedString as,
                                                   org.w3c.dom.Element element,
                                                   org.apache.batik.bridge.BridgeContext ctx) {
        for (org.w3c.dom.Node child =
               element.
               getFirstChild(
                 );
             child !=
               null;
             child =
               child.
                 getNextSibling(
                   )) {
            if (child.
                  getNodeType(
                    ) !=
                  org.w3c.dom.Node.
                    ELEMENT_NODE) {
                continue;
            }
            java.lang.String cNS =
              child.
              getNamespaceURI(
                );
            if (!getNamespaceURI(
                   ).
                  equals(
                    cNS) &&
                  !SVG_NAMESPACE_URI.
                  equals(
                    cNS)) {
                continue;
            }
            java.lang.String ln =
              child.
              getLocalName(
                );
            if (ln.
                  equals(
                    BATIK_EXT_FLOW_PARA_TAG) ||
                  ln.
                  equals(
                    BATIK_EXT_FLOW_REGION_BREAK_TAG) ||
                  ln.
                  equals(
                    BATIK_EXT_FLOW_LINE_TAG) ||
                  ln.
                  equals(
                    BATIK_EXT_FLOW_SPAN_TAG) ||
                  ln.
                  equals(
                    SVG_A_TAG) ||
                  ln.
                  equals(
                    SVG_TREF_TAG)) {
                addGlyphPositionAttributes(
                  as,
                  (org.w3c.dom.Element)
                    child,
                  ctx);
            }
        }
    }
    protected void addPaintAttributes(java.text.AttributedString as,
                                      org.w3c.dom.Element element,
                                      org.apache.batik.gvt.TextNode node,
                                      org.apache.batik.gvt.text.TextPaintInfo parentPI,
                                      org.apache.batik.bridge.BridgeContext ctx) {
        if (element.
              getNodeType(
                ) !=
              org.w3c.dom.Node.
                ELEMENT_NODE)
            return;
        java.lang.String eNS =
          element.
          getNamespaceURI(
            );
        if (!eNS.
              equals(
                getNamespaceURI(
                  )) &&
              !eNS.
              equals(
                SVG_NAMESPACE_URI))
            return;
        if (element.
              getLocalName(
                ) !=
              BATIK_EXT_FLOW_TEXT_TAG) {
            super.
              addPaintAttributes(
                as,
                element,
                node,
                parentPI,
                ctx);
            return;
        }
        for (org.w3c.dom.Node n =
               element.
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
            if (!getNamespaceURI(
                   ).
                  equals(
                    n.
                      getNamespaceURI(
                        )))
                continue;
            org.w3c.dom.Element e =
              (org.w3c.dom.Element)
                n;
            java.lang.String ln =
              e.
              getLocalName(
                );
            if (ln.
                  equals(
                    BATIK_EXT_FLOW_DIV_TAG)) {
                super.
                  addPaintAttributes(
                    as,
                    e,
                    node,
                    parentPI,
                    ctx);
                return;
            }
        }
    }
    protected void addChildPaintAttributes(java.text.AttributedString as,
                                           org.w3c.dom.Element element,
                                           org.apache.batik.gvt.TextNode node,
                                           org.apache.batik.gvt.text.TextPaintInfo parentPI,
                                           org.apache.batik.bridge.BridgeContext ctx) {
        for (org.w3c.dom.Node child =
               element.
               getFirstChild(
                 );
             child !=
               null;
             child =
               child.
                 getNextSibling(
                   )) {
            if (child.
                  getNodeType(
                    ) !=
                  org.w3c.dom.Node.
                    ELEMENT_NODE) {
                continue;
            }
            java.lang.String cNS =
              child.
              getNamespaceURI(
                );
            if (!getNamespaceURI(
                   ).
                  equals(
                    cNS) &&
                  !SVG_NAMESPACE_URI.
                  equals(
                    cNS)) {
                continue;
            }
            java.lang.String ln =
              child.
              getLocalName(
                );
            if (ln.
                  equals(
                    BATIK_EXT_FLOW_PARA_TAG) ||
                  ln.
                  equals(
                    BATIK_EXT_FLOW_REGION_BREAK_TAG) ||
                  ln.
                  equals(
                    BATIK_EXT_FLOW_LINE_TAG) ||
                  ln.
                  equals(
                    BATIK_EXT_FLOW_SPAN_TAG) ||
                  ln.
                  equals(
                    SVG_A_TAG) ||
                  ln.
                  equals(
                    SVG_TREF_TAG)) {
                org.w3c.dom.Element childElement =
                  (org.w3c.dom.Element)
                    child;
                org.apache.batik.gvt.text.TextPaintInfo pi =
                  getTextPaintInfo(
                    childElement,
                    node,
                    parentPI,
                    ctx);
                addPaintAttributes(
                  as,
                  childElement,
                  node,
                  pi,
                  ctx);
            }
        }
    }
    protected java.text.AttributedString getFlowDiv(org.apache.batik.bridge.BridgeContext ctx,
                                                    org.w3c.dom.Element element) {
        for (org.w3c.dom.Node n =
               element.
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
            if (!getNamespaceURI(
                   ).
                  equals(
                    n.
                      getNamespaceURI(
                        )))
                continue;
            org.w3c.dom.Element e =
              (org.w3c.dom.Element)
                n;
            java.lang.String ln =
              n.
              getLocalName(
                );
            if (ln.
                  equals(
                    BATIK_EXT_FLOW_DIV_TAG)) {
                return gatherFlowPara(
                         ctx,
                         e);
            }
        }
        return null;
    }
    protected java.text.AttributedString gatherFlowPara(org.apache.batik.bridge.BridgeContext ctx,
                                                        org.w3c.dom.Element div) {
        org.apache.batik.gvt.text.TextPaintInfo divTPI =
          new org.apache.batik.gvt.text.TextPaintInfo(
          );
        divTPI.
          visible =
          true;
        divTPI.
          fillPaint =
          java.awt.Color.
            black;
        elemTPI.
          put(
            div,
            divTPI);
        org.apache.batik.bridge.SVGTextElementBridge.AttributedStringBuffer asb =
          new org.apache.batik.bridge.SVGTextElementBridge.AttributedStringBuffer(
          );
        java.util.List paraEnds =
          new java.util.ArrayList(
          );
        java.util.List paraElems =
          new java.util.ArrayList(
          );
        java.util.List lnLocs =
          new java.util.ArrayList(
          );
        for (org.w3c.dom.Node n =
               div.
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
                    ELEMENT_NODE ||
                  !getNamespaceURI(
                     ).
                  equals(
                    n.
                      getNamespaceURI(
                        ))) {
                continue;
            }
            org.w3c.dom.Element e =
              (org.w3c.dom.Element)
                n;
            java.lang.String ln =
              e.
              getLocalName(
                );
            if (ln.
                  equals(
                    BATIK_EXT_FLOW_PARA_TAG)) {
                fillAttributedStringBuffer(
                  ctx,
                  e,
                  true,
                  null,
                  null,
                  asb,
                  lnLocs);
                paraElems.
                  add(
                    e);
                paraEnds.
                  add(
                    new java.lang.Integer(
                      asb.
                        length(
                          )));
            }
            else
                if (ln.
                      equals(
                        BATIK_EXT_FLOW_REGION_BREAK_TAG)) {
                    fillAttributedStringBuffer(
                      ctx,
                      e,
                      true,
                      null,
                      null,
                      asb,
                      lnLocs);
                    paraElems.
                      add(
                        e);
                    paraEnds.
                      add(
                        new java.lang.Integer(
                          asb.
                            length(
                              )));
                }
        }
        divTPI.
          startChar =
          0;
        divTPI.
          endChar =
          asb.
            length(
              ) -
            1;
        java.text.AttributedString ret =
          asb.
          toAttributedString(
            );
        int prevLN =
          0;
        java.util.Iterator lnIter =
          lnLocs.
          iterator(
            );
        while (lnIter.
                 hasNext(
                   )) {
            int nextLN =
              ((java.lang.Integer)
                 lnIter.
                 next(
                   )).
              intValue(
                );
            if (nextLN ==
                  prevLN)
                continue;
            ret.
              addAttribute(
                FLOW_LINE_BREAK,
                new java.lang.Object(
                  ),
                prevLN,
                nextLN);
            prevLN =
              nextLN;
        }
        int start =
          0;
        int end;
        java.util.List emptyPara =
          null;
        for (int i =
               0;
             i <
               paraElems.
               size(
                 );
             i++,
               start =
                 end) {
            org.w3c.dom.Element elem =
              (org.w3c.dom.Element)
                paraElems.
                get(
                  i);
            end =
              ((java.lang.Integer)
                 paraEnds.
                 get(
                   i)).
                intValue(
                  );
            if (start ==
                  end) {
                if (emptyPara ==
                      null)
                    emptyPara =
                      new java.util.LinkedList(
                        );
                emptyPara.
                  add(
                    makeMarginInfo(
                      elem));
                continue;
            }
            ret.
              addAttribute(
                FLOW_PARAGRAPH,
                makeMarginInfo(
                  elem),
                start,
                end);
            if (emptyPara !=
                  null) {
                ret.
                  addAttribute(
                    FLOW_EMPTY_PARAGRAPH,
                    emptyPara,
                    start,
                    end);
                emptyPara =
                  null;
            }
        }
        return ret;
    }
    protected java.util.List getRegions(org.apache.batik.bridge.BridgeContext ctx,
                                        org.w3c.dom.Element element) {
        java.util.List ret =
          new java.util.LinkedList(
          );
        for (org.w3c.dom.Node n =
               element.
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
            if (!getNamespaceURI(
                   ).
                  equals(
                    n.
                      getNamespaceURI(
                        )))
                continue;
            org.w3c.dom.Element e =
              (org.w3c.dom.Element)
                n;
            java.lang.String ln =
              e.
              getLocalName(
                );
            if (!BATIK_EXT_FLOW_REGION_TAG.
                  equals(
                    ln))
                continue;
            float verticalAlignment =
              0.0F;
            java.lang.String verticalAlignmentAttribute =
              e.
              getAttribute(
                BATIK_EXT_VERTICAL_ALIGN_ATTRIBUTE);
            if (verticalAlignmentAttribute !=
                  null &&
                  verticalAlignmentAttribute.
                  length(
                    ) >
                  0) {
                if (BATIK_EXT_ALIGN_TOP_VALUE.
                      equals(
                        verticalAlignmentAttribute)) {
                    verticalAlignment =
                      0.0F;
                }
                else
                    if (BATIK_EXT_ALIGN_MIDDLE_VALUE.
                          equals(
                            verticalAlignmentAttribute)) {
                        verticalAlignment =
                          0.5F;
                    }
                    else
                        if (BATIK_EXT_ALIGN_BOTTOM_VALUE.
                              equals(
                                verticalAlignmentAttribute)) {
                            verticalAlignment =
                              1.0F;
                        }
            }
            gatherRegionInfo(
              ctx,
              e,
              verticalAlignment,
              ret);
        }
        return ret;
    }
    protected void gatherRegionInfo(org.apache.batik.bridge.BridgeContext ctx,
                                    org.w3c.dom.Element rgn,
                                    float verticalAlign,
                                    java.util.List regions) {
        for (org.w3c.dom.Node n =
               rgn.
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
            if (!getNamespaceURI(
                   ).
                  equals(
                    n.
                      getNamespaceURI(
                        )))
                continue;
            org.w3c.dom.Element e =
              (org.w3c.dom.Element)
                n;
            java.lang.String ln =
              n.
              getLocalName(
                );
            if (ln.
                  equals(
                    org.apache.batik.util.SVGConstants.
                      SVG_RECT_TAG)) {
                org.apache.batik.parser.UnitProcessor.Context uctx;
                uctx =
                  org.apache.batik.bridge.UnitProcessor.
                    createContext(
                      ctx,
                      e);
                org.apache.batik.extension.svg.RegionInfo ri =
                  buildRegion(
                    uctx,
                    e,
                    verticalAlign);
                if (ri !=
                      null)
                    regions.
                      add(
                        ri);
            }
        }
    }
    protected org.apache.batik.extension.svg.RegionInfo buildRegion(org.apache.batik.parser.UnitProcessor.Context uctx,
                                                                    org.w3c.dom.Element e,
                                                                    float verticalAlignment) {
        java.lang.String s;
        s =
          e.
            getAttribute(
              BATIK_EXT_X_ATTRIBUTE);
        float x =
          0;
        if (s.
              length(
                ) !=
              0) {
            x =
              org.apache.batik.bridge.UnitProcessor.
                svgHorizontalCoordinateToUserSpace(
                  s,
                  BATIK_EXT_X_ATTRIBUTE,
                  uctx);
        }
        s =
          e.
            getAttribute(
              BATIK_EXT_Y_ATTRIBUTE);
        float y =
          0;
        if (s.
              length(
                ) !=
              0) {
            y =
              org.apache.batik.bridge.UnitProcessor.
                svgVerticalCoordinateToUserSpace(
                  s,
                  BATIK_EXT_Y_ATTRIBUTE,
                  uctx);
        }
        s =
          e.
            getAttribute(
              BATIK_EXT_WIDTH_ATTRIBUTE);
        float w;
        if (s.
              length(
                ) !=
              0) {
            w =
              org.apache.batik.bridge.UnitProcessor.
                svgHorizontalLengthToUserSpace(
                  s,
                  BATIK_EXT_WIDTH_ATTRIBUTE,
                  uctx);
        }
        else {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              e,
              ERR_ATTRIBUTE_MISSING,
              new java.lang.Object[] { BATIK_EXT_WIDTH_ATTRIBUTE,
              s });
        }
        if (w ==
              0) {
            return null;
        }
        s =
          e.
            getAttribute(
              BATIK_EXT_HEIGHT_ATTRIBUTE);
        float h;
        if (s.
              length(
                ) !=
              0) {
            h =
              org.apache.batik.bridge.UnitProcessor.
                svgVerticalLengthToUserSpace(
                  s,
                  BATIK_EXT_HEIGHT_ATTRIBUTE,
                  uctx);
        }
        else {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              e,
              ERR_ATTRIBUTE_MISSING,
              new java.lang.Object[] { BATIK_EXT_HEIGHT_ATTRIBUTE,
              s });
        }
        if (h ==
              0) {
            return null;
        }
        return new org.apache.batik.extension.svg.RegionInfo(
          x,
          y,
          w,
          h,
          verticalAlignment);
    }
    protected void fillAttributedStringBuffer(org.apache.batik.bridge.BridgeContext ctx,
                                              org.w3c.dom.Element element,
                                              boolean top,
                                              java.lang.Integer bidiLevel,
                                              java.util.Map initialAttributes,
                                              org.apache.batik.bridge.SVGTextElementBridge.AttributedStringBuffer asb,
                                              java.util.List lnLocs) {
        if (!org.apache.batik.bridge.SVGUtilities.
              matchUserAgent(
                element,
                ctx.
                  getUserAgent(
                    )) ||
              !org.apache.batik.bridge.CSSUtilities.
              convertDisplay(
                element)) {
            return;
        }
        java.lang.String s =
          org.apache.batik.dom.util.XMLSupport.
          getXMLSpace(
            element);
        boolean preserve =
          s.
          equals(
            SVG_PRESERVE_VALUE);
        boolean prevEndsWithSpace;
        org.w3c.dom.Element nodeElement =
          element;
        int elementStartChar =
          asb.
          length(
            );
        if (top)
            endLimit =
              0;
        if (preserve)
            endLimit =
              asb.
                length(
                  );
        java.util.Map map =
          initialAttributes ==
          null
          ? new java.util.HashMap(
          )
          : new java.util.HashMap(
          initialAttributes);
        initialAttributes =
          getAttributeMap(
            ctx,
            element,
            null,
            bidiLevel,
            map);
        java.lang.Object o =
          map.
          get(
            java.awt.font.TextAttribute.
              BIDI_EMBEDDING);
        java.lang.Integer subBidiLevel =
          bidiLevel;
        if (o !=
              null) {
            subBidiLevel =
              (java.lang.Integer)
                o;
        }
        for (org.w3c.dom.Node n =
               element.
               getFirstChild(
                 );
             n !=
               null;
             n =
               n.
                 getNextSibling(
                   )) {
            if (preserve) {
                prevEndsWithSpace =
                  false;
            }
            else {
                if (asb.
                      length(
                        ) ==
                      0) {
                    prevEndsWithSpace =
                      true;
                }
                else {
                    prevEndsWithSpace =
                      asb.
                        getLastChar(
                          ) ==
                        ' ';
                }
            }
            switch (n.
                      getNodeType(
                        )) {
                case org.w3c.dom.Node.
                       ELEMENT_NODE:
                    if (!getNamespaceURI(
                           ).
                          equals(
                            n.
                              getNamespaceURI(
                                )) &&
                          !SVG_NAMESPACE_URI.
                          equals(
                            n.
                              getNamespaceURI(
                                )))
                        break;
                    nodeElement =
                      (org.w3c.dom.Element)
                        n;
                    java.lang.String ln =
                      n.
                      getLocalName(
                        );
                    if (ln.
                          equals(
                            BATIK_EXT_FLOW_LINE_TAG)) {
                        int before =
                          asb.
                          length(
                            );
                        fillAttributedStringBuffer(
                          ctx,
                          nodeElement,
                          false,
                          subBidiLevel,
                          initialAttributes,
                          asb,
                          lnLocs);
                        lnLocs.
                          add(
                            new java.lang.Integer(
                              asb.
                                length(
                                  )));
                        if (asb.
                              length(
                                ) !=
                              before) {
                            initialAttributes =
                              null;
                        }
                    }
                    else
                        if (ln.
                              equals(
                                BATIK_EXT_FLOW_SPAN_TAG) ||
                              ln.
                              equals(
                                SVG_ALT_GLYPH_TAG)) {
                            int before =
                              asb.
                              length(
                                );
                            fillAttributedStringBuffer(
                              ctx,
                              nodeElement,
                              false,
                              subBidiLevel,
                              initialAttributes,
                              asb,
                              lnLocs);
                            if (asb.
                                  length(
                                    ) !=
                                  before) {
                                initialAttributes =
                                  null;
                            }
                        }
                        else
                            if (ln.
                                  equals(
                                    SVG_A_TAG)) {
                                if (ctx.
                                      isInteractive(
                                        )) {
                                    org.apache.batik.dom.events.NodeEventTarget target =
                                      (org.apache.batik.dom.events.NodeEventTarget)
                                        nodeElement;
                                    org.apache.batik.bridge.UserAgent ua =
                                      ctx.
                                      getUserAgent(
                                        );
                                    org.apache.batik.bridge.SVGAElementBridge.CursorHolder ch;
                                    ch =
                                      new org.apache.batik.bridge.SVGAElementBridge.CursorHolder(
                                        org.apache.batik.bridge.CursorManager.
                                          DEFAULT_CURSOR);
                                    target.
                                      addEventListenerNS(
                                        org.apache.batik.util.XMLConstants.
                                          XML_EVENTS_NAMESPACE_URI,
                                        SVG_EVENT_CLICK,
                                        new org.apache.batik.bridge.SVGAElementBridge.AnchorListener(
                                          ua,
                                          ch),
                                        false,
                                        null);
                                    target.
                                      addEventListenerNS(
                                        org.apache.batik.util.XMLConstants.
                                          XML_EVENTS_NAMESPACE_URI,
                                        SVG_EVENT_MOUSEOVER,
                                        new org.apache.batik.bridge.SVGAElementBridge.CursorMouseOverListener(
                                          ua,
                                          ch),
                                        false,
                                        null);
                                    target.
                                      addEventListenerNS(
                                        org.apache.batik.util.XMLConstants.
                                          XML_EVENTS_NAMESPACE_URI,
                                        SVG_EVENT_MOUSEOUT,
                                        new org.apache.batik.bridge.SVGAElementBridge.CursorMouseOutListener(
                                          ua,
                                          ch),
                                        false,
                                        null);
                                }
                                int before =
                                  asb.
                                  length(
                                    );
                                fillAttributedStringBuffer(
                                  ctx,
                                  nodeElement,
                                  false,
                                  subBidiLevel,
                                  initialAttributes,
                                  asb,
                                  lnLocs);
                                if (asb.
                                      length(
                                        ) !=
                                      before) {
                                    initialAttributes =
                                      null;
                                }
                            }
                            else
                                if (ln.
                                      equals(
                                        SVG_TREF_TAG)) {
                                    java.lang.String uriStr =
                                      org.apache.batik.dom.util.XLinkSupport.
                                      getXLinkHref(
                                        (org.w3c.dom.Element)
                                          n);
                                    org.w3c.dom.Element ref =
                                      ctx.
                                      getReferencedElement(
                                        (org.w3c.dom.Element)
                                          n,
                                        uriStr);
                                    s =
                                      org.apache.batik.bridge.TextUtilities.
                                        getElementContent(
                                          ref);
                                    s =
                                      normalizeString(
                                        s,
                                        preserve,
                                        prevEndsWithSpace);
                                    if (s.
                                          length(
                                            ) !=
                                          0) {
                                        int trefStart =
                                          asb.
                                          length(
                                            );
                                        java.util.HashMap m =
                                          initialAttributes ==
                                          null
                                          ? new java.util.HashMap(
                                          )
                                          : new java.util.HashMap(
                                          initialAttributes);
                                        getAttributeMap(
                                          ctx,
                                          nodeElement,
                                          null,
                                          bidiLevel,
                                          m);
                                        asb.
                                          append(
                                            s,
                                            m);
                                        int trefEnd =
                                          asb.
                                          length(
                                            ) -
                                          1;
                                        org.apache.batik.gvt.text.TextPaintInfo tpi;
                                        tpi =
                                          (org.apache.batik.gvt.text.TextPaintInfo)
                                            elemTPI.
                                            get(
                                              nodeElement);
                                        tpi.
                                          startChar =
                                          trefStart;
                                        tpi.
                                          endChar =
                                          trefEnd;
                                        initialAttributes =
                                          null;
                                    }
                                }
                    break;
                case org.w3c.dom.Node.
                       TEXT_NODE:
                case org.w3c.dom.Node.
                       CDATA_SECTION_NODE:
                    s =
                      n.
                        getNodeValue(
                          );
                    s =
                      normalizeString(
                        s,
                        preserve,
                        prevEndsWithSpace);
                    if (s.
                          length(
                            ) !=
                          0) {
                        asb.
                          append(
                            s,
                            map);
                        if (preserve) {
                            endLimit =
                              asb.
                                length(
                                  );
                        }
                        initialAttributes =
                          null;
                    }
            }
        }
        if (top) {
            boolean strippedSome =
              false;
            while (endLimit <
                     asb.
                     length(
                       ) &&
                     asb.
                     getLastChar(
                       ) ==
                     ' ') {
                asb.
                  stripLast(
                    );
                strippedSome =
                  true;
            }
            if (strippedSome) {
                java.util.Iterator iter =
                  elemTPI.
                  values(
                    ).
                  iterator(
                    );
                while (iter.
                         hasNext(
                           )) {
                    org.apache.batik.gvt.text.TextPaintInfo tpi =
                      (org.apache.batik.gvt.text.TextPaintInfo)
                        iter.
                        next(
                          );
                    if (tpi.
                          endChar >=
                          asb.
                          length(
                            )) {
                        tpi.
                          endChar =
                          asb.
                            length(
                              ) -
                            1;
                        if (tpi.
                              startChar >
                              tpi.
                                endChar)
                            tpi.
                              startChar =
                              tpi.
                                endChar;
                    }
                }
            }
        }
        int elementEndChar =
          asb.
          length(
            ) -
          1;
        org.apache.batik.gvt.text.TextPaintInfo tpi =
          (org.apache.batik.gvt.text.TextPaintInfo)
            elemTPI.
            get(
              element);
        tpi.
          startChar =
          elementStartChar;
        tpi.
          endChar =
          elementEndChar;
    }
    protected java.util.Map getAttributeMap(org.apache.batik.bridge.BridgeContext ctx,
                                            org.w3c.dom.Element element,
                                            org.apache.batik.gvt.text.TextPath textPath,
                                            java.lang.Integer bidiLevel,
                                            java.util.Map result) {
        java.util.Map initialMap =
          super.
          getAttributeMap(
            ctx,
            element,
            textPath,
            bidiLevel,
            result);
        java.lang.String s;
        s =
          element.
            getAttribute(
              BATIK_EXT_PREFORMATTED_ATTRIBUTE);
        if (s.
              length(
                ) !=
              0) {
            if (s.
                  equals(
                    "true")) {
                result.
                  put(
                    PREFORMATTED,
                    java.lang.Boolean.
                      TRUE);
            }
        }
        return initialMap;
    }
    protected void checkMap(java.util.Map attrs) {
        if (attrs.
              containsKey(
                TEXTPATH)) {
            return;
        }
        if (attrs.
              containsKey(
                ANCHOR_TYPE)) {
            return;
        }
        if (attrs.
              containsKey(
                LETTER_SPACING)) {
            return;
        }
        if (attrs.
              containsKey(
                WORD_SPACING)) {
            return;
        }
        if (attrs.
              containsKey(
                KERNING)) {
            return;
        }
    }
    protected static final org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute
      TEXTPATH =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        TEXTPATH;
    protected static final org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute
      ANCHOR_TYPE =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        ANCHOR_TYPE;
    protected static final org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute
      LETTER_SPACING =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        LETTER_SPACING;
    protected static final org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute
      WORD_SPACING =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        WORD_SPACING;
    protected static final org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute
      KERNING =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        KERNING;
    public static class LineBreakInfo {
        int breakIdx;
        float lineAdvAdj;
        boolean relative;
        public LineBreakInfo(int breakIdx,
                             float lineAdvAdj,
                             boolean relative) {
            super(
              );
            this.
              breakIdx =
              breakIdx;
            this.
              lineAdvAdj =
              lineAdvAdj;
            this.
              relative =
              relative;
        }
        public int getBreakIdx() { return breakIdx;
        }
        public boolean isRelative() { return relative;
        }
        public float getLineAdvAdj() { return lineAdvAdj;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "aMddVPzzfCbyL/m97lOvrV8sHQyIZw4LA7KeR7xMrd6TX24wnjRUb6ZdmHFq" +
           "PTqrGZx503bqTX94OhElYnNZdi2bizVP9vxqnrn92OzlZGqc8TY3Xjhhve9O" +
           "5y9/wsKBbboY/6LXEgtAjVu2Orfu3hK5WPNo+0SeuW9hM8ExXfS6D7ljiEP/" +
           "K0O0gBa3bW1u370hcrHmUfa7eeZOYPNtTiohJMJeZHZs8Z3/hi1SsInncUMQ" +
           "zuJk1X/8WAIQNivr6dZ6bpSePVpdWn/0obcEemWeBCsAh2JJRXEncFe/RDdY" +
           "TBaGqbDSuS6+nodLen4poayHVqj0fYvnDCcNuXk4Kcv03VwvcFLj54JqXHy7" +
           "6V6E2HXoAOCtjpvkLMgEJNj9iZ42do0oJ7ECCloVUKrAm1wyTp9xJ6e78tFC" +
           "D5SLR/c07CatZ/dB6fTRjZseuX7/09YzgqTQ8XFcZSpcYKwXjQx0L8i5Wnqt" +
           "kg1LblQ9V7YoneFqLYGd0zPHFeLb4OqhYynd4Ltjmy2Zq/bbx1af/cW+kvNQ" +
           "km4lBZSTaVuza8WUnoScuTWcfVGDNCcu/61Lvjm2Znns6u9ENU6si11jbvpB" +
           "6eLxhy8cnHWsKUCmdpFiSN4sJYrYdWNqL5NGjAFSKZsdKRARVpGp4rkFVmFY" +
           "U3yOF3axzVmZGcVHKE6asy/A2U93cHMZZUabllSjIplBmnVGPP8NSGe/pK77" +
           "GJwR1yPBOmxWpdAbEI+D4W5dT78PlK/UBTZ0TH5RxPa86GJz4d9L+23zkBsA" +
           "AA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public org.apache.batik.extension.svg.MarginInfo makeMarginInfo(org.w3c.dom.Element e) {
        java.lang.String s;
        float top =
          0;
        float right =
          0;
        float bottom =
          0;
        float left =
          0;
        s =
          e.
            getAttribute(
              BATIK_EXT_MARGIN_ATTRIBUTE);
        try {
            if (s.
                  length(
                    ) !=
                  0) {
                float f =
                  java.lang.Float.
                  parseFloat(
                    s);
                top =
                  (right =
                     (bottom =
                        (left =
                           f)));
            }
        }
        catch (java.lang.NumberFormatException nfe) {
            
        }
        s =
          e.
            getAttribute(
              BATIK_EXT_TOP_MARGIN_ATTRIBUTE);
        try {
            if (s.
                  length(
                    ) !=
                  0) {
                float f =
                  java.lang.Float.
                  parseFloat(
                    s);
                top =
                  f;
            }
        }
        catch (java.lang.NumberFormatException nfe) {
            
        }
        s =
          e.
            getAttribute(
              BATIK_EXT_RIGHT_MARGIN_ATTRIBUTE);
        try {
            if (s.
                  length(
                    ) !=
                  0) {
                float f =
                  java.lang.Float.
                  parseFloat(
                    s);
                right =
                  f;
            }
        }
        catch (java.lang.NumberFormatException nfe) {
            
        }
        s =
          e.
            getAttribute(
              BATIK_EXT_BOTTOM_MARGIN_ATTRIBUTE);
        try {
            if (s.
                  length(
                    ) !=
                  0) {
                float f =
                  java.lang.Float.
                  parseFloat(
                    s);
                bottom =
                  f;
            }
        }
        catch (java.lang.NumberFormatException nfe) {
            
        }
        s =
          e.
            getAttribute(
              BATIK_EXT_LEFT_MARGIN_ATTRIBUTE);
        try {
            if (s.
                  length(
                    ) !=
                  0) {
                float f =
                  java.lang.Float.
                  parseFloat(
                    s);
                left =
                  f;
            }
        }
        catch (java.lang.NumberFormatException nfe) {
            
        }
        float indent =
          0;
        s =
          e.
            getAttribute(
              BATIK_EXT_INDENT_ATTRIBUTE);
        try {
            if (s.
                  length(
                    ) !=
                  0) {
                float f =
                  java.lang.Float.
                  parseFloat(
                    s);
                indent =
                  f;
            }
        }
        catch (java.lang.NumberFormatException nfe) {
            
        }
        int justification =
          org.apache.batik.extension.svg.MarginInfo.
            JUSTIFY_START;
        s =
          e.
            getAttribute(
              BATIK_EXT_JUSTIFICATION_ATTRIBUTE);
        try {
            if (s.
                  length(
                    ) !=
                  0) {
                if (BATIK_EXT_JUSTIFICATION_START_VALUE.
                      equals(
                        s)) {
                    justification =
                      org.apache.batik.extension.svg.MarginInfo.
                        JUSTIFY_START;
                }
                else
                    if (BATIK_EXT_JUSTIFICATION_MIDDLE_VALUE.
                          equals(
                            s)) {
                        justification =
                          org.apache.batik.extension.svg.MarginInfo.
                            JUSTIFY_MIDDLE;
                    }
                    else
                        if (BATIK_EXT_JUSTIFICATION_END_VALUE.
                              equals(
                                s)) {
                            justification =
                              org.apache.batik.extension.svg.MarginInfo.
                                JUSTIFY_END;
                        }
                        else
                            if (BATIK_EXT_JUSTIFICATION_FULL_VALUE.
                                  equals(
                                    s)) {
                                justification =
                                  org.apache.batik.extension.svg.MarginInfo.
                                    JUSTIFY_FULL;
                            }
            }
        }
        catch (java.lang.NumberFormatException nfe) {
            
        }
        java.lang.String ln =
          e.
          getLocalName(
            );
        boolean rgnBr =
          ln.
          equals(
            BATIK_EXT_FLOW_REGION_BREAK_TAG);
        return new org.apache.batik.extension.svg.MarginInfo(
          top,
          right,
          bottom,
          left,
          indent,
          justification,
          rgnBr);
    }
    protected class BatikFlowContentBridge extends org.apache.batik.bridge.SVGTextElementBridge.AbstractTextChildTextContent {
        public BatikFlowContentBridge(org.apache.batik.bridge.BridgeContext ctx,
                                      org.apache.batik.bridge.SVGTextElementBridge parent,
                                      org.w3c.dom.Element e) {
            super(
              ctx,
              parent,
              e);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL1Ze8wj11Wf/Ta7yW6T7CZp0hDaPDdA4ugb22N7bG0LHY9n" +
           "7LHHnrHHHnsG6HbeD8/L87BnXAJpC7SiUqlEUoLU5q9WoKptKkQFEioKQkBR" +
           "K6SiipdEWyEkikpF8wcFUaDcGX/v3U1VkLDk8fW955x7Xvd3z73z6W9DF6IQ" +
           "KgW+kxmOH+9rabxvO/X9OAu0aL9P11kpjDQVd6QomoK+G8qTn7vy3e99xLy6" +
           "B10UoQckz/NjKbZ8L5poke+sNZWGrhz3Eo7mRjF0lbaltQQnseXAtBXF12no" +
           "TSdYY+gafagCDFSAgQpwoQKMHVMBpns0L3HxnEPy4mgF/Tx0joYuBkquXgw9" +
           "cVpIIIWSeyCGLSwAEu7K//PAqII5DaHHj2zf2XyTwS+V4Bd//V1Xf/s8dEWE" +
           "rlgel6ujACViMIkI3e1qrqyFEaaqmipC93mapnJaaEmOtS30FqH7I8vwpDgJ" +
           "tSMn5Z1JoIXFnMeeu1vJbQsTJfbDI/N0S3PUw38XdEcygK0PHdu6s5DM+4GB" +
           "ly2gWKhLinbIcsfS8tQYeuwsx5GN1waAALDe6Wqx6R9NdYcngQ7o/l3sHMkz" +
           "YC4OLc8ApBf8BMwSQ4/cVmju60BSlpKh3Yihh8/SsbshQHWpcETOEkMPniUr" +
           "JIEoPXImSifi8+3R2z/8Hq/n7RU6q5ri5PrfBZgePcM00XQt1DxF2zHe/Sz9" +
           "UemhL3xwD4IA8YNniHc0v/tzr7/zuUdf++KO5kdvQcPItqbEN5RPyPd+5a34" +
           "M63zuRp3BX5k5cE/ZXmR/uzByPU0ACvvoSOJ+eD+4eBrkz8RXviU9q096DIF" +
           "XVR8J3FBHt2n+G5gOVrY1TwtlGJNpaBLmqfixTgF3QnatOVpu15G1yMtpqA7" +
           "nKLrol/8By7SgYjcRXeCtuXp/mE7kGKzaKcBBEH3gi/0AASdp6His/uNIQc2" +
           "fVeDJUXyLM+H2dDP7Y9gzYtl4FsTlkHWL+HIT0KQgrAfGrAE8sDUDgbAotG8" +
           "CNgIR2sDbud9pONvpqA/Bwsgph1aqqHt51kX/D/Pl+b2X92cOwdC89azwOCA" +
           "NdXzHVULbygvJm3i9c/e+NLe0UI58FwMsUCF/Z0K+4UK+0cq7AMV9m+vwrWj" +
           "oQJdDruhc+cKhd6ca7jLExDlJcALgKR3P8P9bP/dH3zyPEjQYHMHCFFOCt8e" +
           "0PFjhKEKHFVAmkOvvbx5L/8L5T1o7zQy51aBrss5O5vj6RFuXju7Im8l98oH" +
           "vvndVz/6vH+8Nk9B/QFk3MyZL/knz/o/9BVNBSB6LP7Zx6XP3/jC89f2oDsA" +
           "jgDsjCWQ6wCWHj07x6mlf/0QRnNbLgCDdT90JScfOsS+y7EZgggd9RSJcW/R" +
           "vg/4+Eq+Fp4Gi2JysDiK33z0gSB/vnmXSHnQzlhRwPQ7uODjf/3n/4QU7j5E" +
           "9Csn9khOi6+fQJFc2JUCL+47zoFpqGmA7u9eZn/tpW9/4KeLBAAUT91qwmv5" +
           "EwfoAUII3PxLX1z9zde/9omv7h0nTQy20UR2LCU9MvIuaAcDtzUSzPZjx/oA" +
           "FHLAysyz5trMc33V0i1JdrQ8S//zytOVz//zh6/u8sABPYdp9NwPFnDc/yNt" +
           "6IUvvevfHi3EnFPyXfDYZ8dkO2h94FgyFoZSluuRvvcv3vYbfyp9HIA0AMbI" +
           "2moF1p0vfHC+sPzBGHr6phUs7yBitx4Ptv5D6uduR83x3ZuW+CHTAznTBlH2" +
           "Vd/dP6AocgYuKJ4tnvu5vwvVoGIMzR+PRSfX3unlfaJYuqF85KvfuYf/zh+8" +
           "XjjrdLV1MtWGUnB9l9354/EUiH/LWaDpSZEJ6GqvjX7mqvPa94BEEUhUAN5G" +
           "TAjwMD2VmAfUF+782z/8o4fe/ZXz0B4JXXZ8SSWlYo1Dl8Di0iITQGka/NQ7" +
           "d8m1ybPtamEqdJPxu5x8+CBKIfTM7eGNzIulY4R4+D8YR37f3//7TU4ogO0W" +
           "NcIZfhH+9McewX/yWwX/McLk3I+mN+8RoLA85q1+yv3XvScv/vEedKcIXVUO" +
           "qlZecpJ83YqgUosOS1lQ2Z4aP1117UqM60cI+taz6HZi2rPYdrw3gXZOnbcv" +
           "n4Sz74PPOfD97/ybuzvv2O319+MHBcfjRxVHEKTnAFhcqO6j++WcnyikPFE8" +
           "r+WPH9+FKW/+BECVqCiXAYdueZJTTEzGIMUc5dqhdB6UzyAm12wHPVwfV4t0" +
           "yq3f39WcOzzNn81CxC4lrt82fd65oyo2znuPhdE+KF8/9A8f+fKvPvV1ENM+" +
           "dGGd+xuE8sSMoySv6H/50y+97U0vfuNDBUgChORfePpfivpo8kYW549B/qAP" +
           "TX0kN5UryhNaiuJhgWuaWlj7hqnMhpYL4H99UK7Cz9//9eXHvvmZXSl6Nm/P" +
           "EGsffPFXvr//4Rf3ThwAnrqpBj/JszsEFErfc+DhEHrijWYpOMh/fPX53/+t" +
           "5z+w0+r+0+UsAU5rn/nL//ry/svf+LNbVEp3OP7/IbDxm5q9WkRhhx+6IsjV" +
           "jTJJ53qCDtUqSrbgYFijZoiSdsqL/riK2KJvTGZ1GpUSddEx0P42qtSW/cxV" +
           "EzVpxTUZUbZMNdF7Yyom3LARCL4hj0ccrDh8fzyJTcmWOug4W8XjOSm2JWqF" +
           "GZhZoqkBNZmtl2N4PR1tGTRGguoa79SNhia7SJjWm62G3ELQtS23YBydoSRV" +
           "Hi+zhWgtq0q9P+1HgdGYEJFY7ZEMllXXrLnu6Ns1UtO2kwETUr5cy1RXnKH9" +
           "duBNLGlZHqHqaGRWSa4/LCdU6qnLwYKgFkp/GDc3SnVVQxtCEDcGISNa2Uih" +
           "BHLaGflYZ9RtCTTNjfzpZoRrna5l4UR1Zimy0xxvVzOugvbnHb0777MmL9TE" +
           "bFbLql2fRYZtGignyitT7HE9m1eCJCpV7f6cE2RiuZLpZVtjqHptMHW50Yg2" +
           "zRajo6knrR096eLUPJNIk3WZBUtEwsbxXX7MDtpMV5paC2Kij1FiWDUDS7Ss" +
           "SXPc4mskRnbW87gjm1ipUreSYD7rK6m5Xo2ZeWk2GMrceuFbo4FUrwlhHxfr" +
           "nXE23crpXNqoLjyau46zrDks0lAVDRYVeNOyB/16R1GBv0sr38e4zhihjRlJ" +
           "BQQTDKV2OFFcGzOHidavTHtmiK4QnTP8ujrckllNj5uxx9iSSflbrAK3WaEf" +
           "V8i5OJmvXXLGY5oMS9ZGSAwJ6YAvt3Edpr1hUJXHh6TdIzxZc2SeQEaCnMhx" +
           "Oom2vXQyx7GQj1Zmfx5XHTLuGwLeDcam4OLbYJh2Gv2lI3SrCEjwYIzGEp7M" +
           "S3HYbVhEtNxmTGZwzdCp4SG3tXC5SvpaxshLjEPiwdp0ljSiVNfVKskstu2R" +
           "SxI8JtaqfjtW4UF1I0mqUZ7UVgQRGZ1E7nljRhBZdttwOBPf0FnL4L1szYZ8" +
           "ddPUeyOnNoFpJR577EqhSD8cNBMH9bVqC5HW8KRLanYZFRSPb5U8bWZlKK1l" +
           "ns23/bEYLr2lVXZgZc4mIdeEWzaS1TN7NV0NmcqUVvBoOjG6AS+PykarY6S4" +
           "Mh9KXW82mW3ivipPJWw9HKJBv8/ys0gzxs5SjE2rXZkzFJIMDIoKLTpxu4lb" +
           "XtBeKxEcZd6ULIYoJXjHNDG2zRLeOl1mDt3nqXEwjyRXdoKBQ4a6Phu3Uzzp" +
           "yJEzwFZka9YbJg5BDQaTWTQwbcMnqs320peEDigXGCJyRJGeBkYlLE2nY2aa" +
           "YS7hrqRsztVJ0oPrMLtCaNSsCzYhWxIiIJhAtBlPxoa2ije1qKp6dNgS1nW1" +
           "uxg3Z9MtOxTHJCn2OVOajCnemVLj5apPJuFyYMT4YppmnMER4yCupeGAoUh5" +
           "AQKODTtJddqCW8m0PmgMU5xso8m4mlg0w1TMecJj2Eq3FtQqa45aKzRJEM/f" +
           "cuYqa7TbYYdadNENM1UxjupnjQZFYtMNOZg7bbHlCys8K/Ur5KDfjjrzVdSv" +
           "zexV3J9RdU8iY2rslBBtKIYhlzDBemVvpYTelkpNdoH6mSktytvaUqtiBpKi" +
           "TqBhXZAs3SW5HKJe2t+izdKA92gnanujCd9HS/4oQZYjf1M1l5mtwfTKkJGa" +
           "o29DJ2VxlC9jrU3a0YwBZ9ucNhPUeW2LZkolamw03Jpwa6FGJCUbjUV31h9X" +
           "OMNyDJ3Q2wkxETMPTe1lU8wW29JADjeorI82plCHe3NhyIPis8l0QR7WYx1m" +
           "lu3avAHjQ76DKMOmoA3NGsPibWNBdMYTU6v7HOZl8LqOtloxg3i2YQumUENj" +
           "L9pgY322adcUamHU3VJJgbsdtpUq65QY1YK0XV8odJlo81JZrFK+o9BClSiX" +
           "aqMW1jNGWHuojcbLnj0z2fXcso2oWxO8ig3bgs/rpabDwTYI9KBXE3r6lsUM" +
           "uiFm8kQolbQSnFBEezTRNILR29Imm/sbkrA0v82tlU51ZaMluL6N17WSZoQG" +
           "Pmdgf0XomEJsGxSuxMjQns7bHZ+05j43DtMk1ZRSlQpQPSFrRBbW3ZpcC5JZ" +
           "rzKYuLxIaWbNEqkabes2odXXtfnK6qYtC9PTIN2g8dxTGxacNeKFjGxnCdyZ" +
           "dFGNjEq+nPZwfztvowtCQHqlRmysDdVWzRpmx06tkzSHesLrLmt3lvbQmI15" +
           "zp9sLWNA8KUIL5dAdsC07KGbus42Wl0qYPwq2tnEfpm0XSax8LpFDrutASwt" +
           "EFNox0pmo2JJ4ILVMGz0NwyMoFHZFhuBNUR6i1UDjkujbkq2xATsdkggZOjG" +
           "oOBBU+jorKV4m4k6CmeChfelJaZaXLVlN8eoNxYrvrWWyo1Vi5BRu2TP47C6" +
           "8rxOc5lINF4S6y7urDe9NRx62zq9gGF7OlUCsPMpurkpEfTIalZYN1XXEzhc" +
           "kUbWbLigvKv62oqW4B7Tmycs7ASG3KhMUaw3G4Sr7kwdNmSMhBd8m6sQ81pL" +
           "sYyouVg4GzxjKxW6nbj1fptExxraHyusohktRZyXNcSbzT3XHSWpCaCsZa4B" +
           "bKpjtVnrLeu4PMTgiMPMWbNSRdRqKWy1jeaEwDhfFzFe50S+Mk6HU03weK7H" +
           "UmzE9dAFVSpP+5XxiqxN0wpnEZqi1oktsLQ71pkMgFm1nCAsm5VCYrqFeUcl" +
           "y5vWuksuBWnLw4tyDFAiYwh4vW6BrWg0kStUN8YGVhYKvIGwdpMZzPUtP0J5" +
           "bMQzvi8LvcZG10qsx29DzayOa0ZGCUt2NGxgSwfZJFgrqy8R0RmWBxYJG0tD" +
           "iuwanJQStsdtSiNdx6fTTTdcq6HubRt+ebFdo9l8C8oEVYym0qiakTG3VUi0" +
           "3HOWqbixGyY98nlUdaUVblkY2VuZQYVxpdJyvgiYXlBV9C2ms56n43S9iWrd" +
           "YIEMjWw0ChF7lCwxbOoucLFaXpCsLXh+O9uMBoi25jKUTCqoII8MblZ1+ERC" +
           "hVYI8Etktz1+o9rlemeqahKRzlspgoFtyx33OuV6m2B1iW70tgiMLQylBJco" +
           "VWcsnVKbLSPz4iYqVVtrA7fqvB95dTeVxRJSQrFYqSb9Tmu2CrbDGaO1Jxrf" +
           "pTi244LY9JvlRW2R0J36rInVurVQWWw4UCm/Iy+hlR/uFHNfcWA7emMADi/5" +
           "wOiHqN7TW08IDpOXgtCPwQlXU48vn4qD/z1nr59PXj4dXwlA+VHlbbd7Q1Ac" +
           "Uz7xvhdfUZlPVvYOrlLeBU6mBy9uTsqJoYdufQd7eC5t/a8vd4GKD9/0qmn3" +
           "ekT57CtX7nrLK7O/Ku4xj15hXKKhu/TEcU6e4E+0LwahpluFNZd25/mg+NnE" +
           "0KNvrGUMnQfPwqT1jmcLjqm35wEROmqf5HoenNPPcoGDfvF7ku6FGLp8TAc8" +
           "v2ucJHk/0AmQ5M1fDA6dTf0wN2vXMDmKQ0mJ8xHctBy1aOyCmJ47nS5HCXv/" +
           "Dzpunsiwp04d1Yu3iweBHCa794s3lFdf6Y/e83rjk7ubXcWRttvibRQN3bm7" +
           "ZD66P3/ittIOZV3sPfO9ez936enDnL13p/Dxkjuh22O3vkYl3CAuLj63v/eW" +
           "33n7b77yteIy438A9Kz1avYdAAA=");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "dd0+661t1ZkPOOcZuwfXs0d8Cv0PPrsDr+A6AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL18efDr2l2ff/ftS94WshCS9/LCfYFE5Mq75TxeiGzJsmxZ" +
       "liUvkiA8tEvWai2WLBoaMlOSKW2gECCdIe8PGlrKBMLSAB0K89q0JSzDTAql" +
       "NJ0mFBgIoQykDNAWSnok+7fc372/383tvalndCyf9fP9nO/5nu85OvJH/6Ry" +
       "XxRWoMB3dobjx9e0LL62dlrX4l2gRddGVIuRwkhT+44URXMQ96Lypp94/C//" +
       "+rvNJ65U7hcrr5Q8z4+l2PK9iNUi39lqKlV5/DQWdzQ3iitPUGtpK8FJbDkw" +
       "ZUXx81TlkTNF48pV6hgCDCDAAAJcQoDR01yg0Cs0L3H7RQnJi6NN5dsqR1Tl" +
       "/kAp4MWVZ6+vJJBCyT1Uw5QSgBoeLH4vgVBl4SysvPFE9r3MNwj8fRD8wR/4" +
       "5id+6p7K42LlccvjCjgKABGDRsTKo67myloYoaqqqWLlSU/TVE4LLcmx8hK3" +
       "WHkqsgxPipNQOyGpiEwCLSzbPGXuUaWQLUyU2A9PxNMtzVGPf92nO5IBZH31" +
       "qax7CQdFPBDwYQsAC3VJ0Y6L3GtbnhpXnjlf4kTGq2OQARR9wNVi0z9p6l5P" +
       "AhGVp/Z950ieAXNxaHkGyHqfn4BW4srrLqy04DqQFFsytBfjymvP52P2SSDX" +
       "QyURRZG48qrz2cqaQC+97lwvnemfP6G//gPf6g29KyVmVVOcAv+DoNDT5wqx" +
       "mq6Fmqdo+4KPvpX6funVv/D+K5UKyPyqc5n3eX7273zhnV/39Muf3Of5qpvk" +
       "mcprTYlfVD4iP/ap1/ff0r2ngPFg4EdW0fnXSV6qP3NIeT4LwMh79UmNReK1" +
       "48SX2X8vvOdHtT++UnmYrNyv+E7iAj16UvHdwHK0kNA8LZRiTSUrD2me2i/T" +
       "ycoD4J6yPG0fO9X1SIvJyr1OGXW/X/4GFOmgioKiB8C95en+8X0gxWZ5nwWV" +
       "SuUBcFXeCK5+Zf/pFUFccWDTdzVYUiTP8nyYCf1C/gjWvFgG3JqwDLTehiM/" +
       "CYEKwn5owBLQA1M7JIBBo3kRkBGOtgbcK+IGjp/OQXxhLEA1vdBSDe1aoXXB" +
       "/+f2skL+J9KjI9A1rz9vGBwwpoa+o2rhi8oHkx7+hR9/8VevnAyUA3NxpQsg" +
       "XNtDuFZCuHYC4RqAcO1iCJWjo7Llryig7BUCdKcNDAMwmY++hXvX6Fve/6Z7" +
       "gCYG6b2gL4qs8MWWu39qSsjSYCpAnysvfyj99uXfrV6pXLneBBfwQdTDRXGm" +
       "MJwnBvLq+aF3s3off9/n/vJj3/9u/3QQXmfTD7bhxpLF2H7TeaJDX9FUYC1P" +
       "q3/rG6WPv/gL7756pXIvMBjASMYSUGpgf54+38Z1Y/z5Y3tZyHIfEFj3Q1dy" +
       "iqRjI/dwbIagK05iSg14rLx/EnD8SKH0z4GLP4yC8rtIfWVQhF+x15ii085J" +
       "UdrjF7jgw7/963/UKOk+Nt2Pn5kMOS1+/oy5KCp7vDQMT57qwDzUNJDvv36I" +
       "+d7v+5P3fWOpACDHV9+swatF2AdmAnQhoPnvfXLznz/7mY/85pVTpYnBfJnI" +
       "jqVkJ0IW8ZWHLxEStPbmUzzA3DhgCBZac3Xhub5q6ZYkO1qhpX/z+HO1j//3" +
       "Dzyx1wMHxByr0dfduoLT+K/sVd7zq9/8V0+X1RwpxXR3ytlptr0NfeVpzWgY" +
       "SrsCR/bt/+EN//iXpA8DawwsYGTlWmnUKiUHlbLT4FL+t5bhtXNptSJ4Jjqr" +
       "/NePrzNuyYvKd//mn71i+We/+IUS7fV+zdm+nkjB83v1KoI3ZqD615wf6UMp" +
       "MkG+5sv0Nz3hvPzXoEYR1KgAyxZNQ2B5sus045D7vgc+/a8/8epv+dQ9lSuD" +
       "ysOOL6kDqRxklYeAdmuRCYxWFnzDO/edmz4IgidKUSs3CL9XiteWv14BAL7l" +
       "YvsyKNyS0yH62v89deT3/u7/vIGE0rLcZDY+V16EP/qDr+u/44/L8qdDvCj9" +
       "dHajNQYu3GnZ+o+6f3HlTff/uyuVB8TKE8rBP1xKTlIMHBH4RNGx0wh8yOvS" +
       "r/dv9pP58ycm7PXnzcuZZs8bl9NZANwXuYv7h8/Zk9cWLA8OV/HBz9uTo0p5" +
       "8w1lkWfL8GoRfE3ZJ/cUt18LxnBUeqExgGB5knMYy18EnyNw/W1xFRUXEftp" +
       "+6n+wXd444nzEIDJ6rEBNV29yKAsSrAoMyyreVVcgUsdKxzca2gMfD4ZeHtq" +
       "3wRGRQFuHxlrpXW5epK2N4JFWC+Cd+7xtC5UubdfTwgFrtGBkOEFhFCXEVIE" +
       "/SLASr7xuPIVpWD4hJkLp+IVacNzWCe3iZUA1+SAlboAK3d7WB8vsVIkjb/Y" +
       "Y3F0fDOY89uEiYGLOcCcXgBTvD2Yj5YwWZwgpzR3M4zf+P+AkTtgZC/AKN0m" +
       "RobFB1N2gs7nOHYzjPKXjrG0iO+oVK78l33WK5++AKN5Aca48lAQ+jGwKJp6" +
       "I9QH5zg/Z9D5yaAb3OA4Gtt4PwiJ5fyycVh4kheNRes2BUaBoJ89CPyZCwQO" +
       "L+kU50ZJH0Hp/nDKvjgXGLyI8s5BjG4TItCbK793gPi7F0Dc3R7ExygcaAz7" +
       "IsegfZImboYyv02UYL105Q8PKP/gApTvuT2Uj66mLHYZxm+/TYwvAGx/fMD4" +
       "+Qswvu/2MD4wxln6AnjvvyW8spLsCHip99Wvda5Vi98fuD0T8Jq1o1w9nu2W" +
       "WlgsvK6unc7xMHuinNuK6f7afjvjHEj8SwYJ/KPHTiujfM94/jt//7t/7bu+" +
       "+rPAiRlV7tsWDgbwXc60SCfFZtF3fPT73vDIB3/nO0u3HPjky/c896fl0vsH" +
       "bk/U1xWicuXKl5KieFJ60ppaSnup78aElgsWHNvDTgj87qc+a//g535sv8tx" +
       "3lE7l1l7/wf//hevfeCDV87sLX31Dds7Z8vs95dK0K84MBxWnr2slbLE4A8/" +
       "9u6f/5F3v2+P6qnrd0pwL3F/7Lf+z69d+9Dv/PJNFuH3Ov4ddGz86h8ZNiMS" +
       "Pf5QNVlroEomelt+aTPt+nKUbUlql3ZtHhObg1aWpizu2hq3pKgpR1uxaEz6" +
       "ZFXLfFqVo3xoucua31JmLUVFhqOaTozRanMDMa1s0seneRSPOJRyhiNlaOOK" +
       "mEwise9ONMZDm7uN1LSpBBsxapeZVztJZ9IR2vC263C1rcQEcNhJGm0Ihrdh" +
       "mGUtyKxxUs9158vexoo6gW1a5GY9c4kxt2oPFLxqQkPVZUzD1DFNXiG0jO64" +
       "jTPkpn1XgKWRwa3ru6A/nyzk0WRpVzeb8cjGbJNDraVluuw4C1lUXFTV0Sy2" +
       "ox3kjDukX200Y3JF9HCFIG1X6i3siTavTYP1LjHEgb1YmSOXmjmNJJx0/A2r" +
       "1RhWDGDL8qaUOp07wiThF+KS4gZ01ZyjW5MerZbKYFaXFjpBDnTfXY/lJTaT" +
       "7DVZjfFpy3SmKc0HNDpbhds1v4VncOKtMmswSfnlYLXGRk3RqWa0KwrcYk4x" +
       "GhuzwYhr2Y3daomzI37RMrl4s1Y3S3ODzSaOGvjekppBhjiaS1qbnknDerDZ" +
       "qD1cZifeWO+v2gJqBGB+JepGKknWepj7s15H8KOVETuoMtvy7FDrQr14rkIB" +
       "ydDEbp6JQ4VyLRol+8Fqgm4GnOSku3zSwmf2ZmK7wnLqxeTEZXs2r2ee28xa" +
       "0mxTxdjqtlqltnYe2tFwo1JWXzfYiHU2thsQAxrBJ9a2y08lnOQUTGq7/RrO" +
       "yIaW9oRxlcHWqN3rkG0qH7lcbTZzdt0qtxLymK6iPXxcm3I8y+1qQo3NeKO3" +
       "crM5PmNrBNvs4xkzX1AsZ1Qn1XHPtiSVaw18Puvb5liom6wcjjMpjcbYiscF" +
       "3HL6WTqoTyV/pK2SoR8EDVgj5HXSsaFw1Z0Z/UVfxltjX2C24Wy8pkcsx48s" +
       "FjO8gdFXpa2VN40Ya2d01SAHg44xdndLSBl4jW3DdlaNoe66y9VyY+dTrInZ" +
       "ri1AVA9R5LXTkLaNpdXLpTVLLxkij7pYbovieqpWxeE8nYxr4lo0xGg9ZTK+" +
       "CyFZneFcZMitqvqGJWsjsdqf1v1VLM6ScYtix22XI5doUF3oLuduLBfiG/Yq" +
       "aK6jzUakqqo3MtKRGgxb1jpaijwBGxoYEehg4cyoHBDtqx6T2KhX52li1GQX" +
       "aVOLDBxpRHq7PRkP8P6iuxlzdmSR5GZT85uia5GNdIdlmT2ULR1r1rHaoj6Y" +
       "c1lsGO6Q5khhEJH0yFrpqD8aLPC8T+SaYyfoVu9yaynH+ggLK6gU+pOpSCxm" +
       "rlmDtt1cZz2caSAuTvaTRJ3HRG8mLGpRdcThogCNIXWg2w1FJ7xwNcEMZSw2" +
       "29xa7eM2vcJxIu6P6QTHsZnZoqs4blipa8G9wDEIVK22ekKzxwyZbn0zjFd1" +
       "WE/afp8aELo7o7vGYsm3lNqsIXQa0aABuUPLDlZDfhfQPJMtbKU9tlm2F6yc" +
       "XpomdtVOsDHQKaiebIeC1toFAbqcLidk7tWJke2PEKKnLVKPX2xomkslKIA4" +
       "bog26j1SxaZa2t2ybMzkbl2H5KktQ9DYtvqQPCGWjj3CDHggQOswytvdhlaN" +
       "rcRV1a4qd7JuS6B0FyLriKRYGjOLgJmdbOJ6vdlm7XmtXZ2t/WY3khO1Om/y" +
       "MOYvhd6uv6tnea019Jx1EA2aXUEysNQkJLuHrnKZbIVtadarBXQ3be7q7rym" +
       "o67ImhBdpfksaRpTXl/RyabZCWbRlqwqLWVMG4vIdUgdMnW9wbhkM0u0jiQ6" +
       "2cTFcLdKIjrmy+SqFSXSUJ6otDUb7cI6wsDygOrU8tquMRE3Q1xUFht5olWJ" +
       "PJXV/nAGUxrcGHqWI06GfGq0VbtlWjbEzNrcYidQeLc9X/V284UaevPhtj/r" +
       "ewYdj8K6zIVCkKdmH5qOTZQJ04Ybhnmn3WkojRUvGWlvK6/HTWSbUh6skYkS" +
       "aXkM17O1ZI8szMSmrbSVcbsG04XZBmELqbWrkw3GU5AEgoEdJ0UTTQlXRqz2" +
       "CFoN+9N+P6q2WyY07lrthapqLIyJ1EqU4LzV3EWebfrzTqNh8hOGTDhdF6UG" +
       "jSHLHdQJ9CoWRQhC2Yix83nIrM+dCFcyaqzrcyEd1+hdiDOz6cSXevMeISZY" +
       "b72m5qOWg9DjZY2Doe7YW9WbXd4mUGazXFRJFV9H+IBo+aMaBwk2RLsT2HeY" +
       "VVDtLFJ6hDfpcT9C+S3e7zuZvk2AGQyaecTPuwpENULMrDZ3UjaJG7NI1Me1" +
       "NhPm275PtUf1Hqyt8yG89Waw0p0Q00GPSLpb0aHkeABju3Ct1TqdPKXGLouE" +
       "+KbdbOE6ZnagdsBs23HLRZq13ixZ1+bTQb23aIg2ne8kyKbTpcozxoZtOxg3" +
       "YkhUw8VZFYtptt8L6Gl7Q5BYtGVyBI3HY3W9ybEtPY/z4XgDXJCd2Nrg4m5H" +
       "52k16XQWZNLpD3XQSc2tqKEKqUHBmiQCKUnrs2670xzr6K6X5T3RxdtmXyY3" +
       "436HidTeih/P+pwZdHx/0lhHCwC+3kWUjjCwpLY1ItNo504gmxHppWVpGaU4" +
       "hpUpPWjpMt1NDomibMpzKR+KUrgy0+7UT2Bg6yYjb1yH1wMD4eKtyxq4DY8M" +
       "elAl4KyK5jltT/S2gNANKEuNoasrBi6N2cGMauRtTV6yWBWTqSyY1fAJmC5m" +
       "xJj2G3jPCy1gfeSdRbRkgYtWO2LezPnp1OqxcuBT5ERzLTcQa2vLVttQKhCm" +
       "YKMuZVAkPkaSDgChqgO0abYldGFEw8QW14zawIzukDYVzHeaTXwgq11hhvOd" +
       "8bjnwFV0RNVRnBrxdGM2Hhr1sUaMxNT2mQgPpwMCDepCU4npNBxOmu1drd0P" +
       "gJVZORtNgDV7hcO9JhWiFuJNnKo1bjVm9YHa9KvddjQcD+ewPoViCiicjgD5" +
       "VVWsYo1lRDTrDEYjigVN/Zwys4bjG1iOzZvTDRzTM0TRdoiUtWMFaUeDaW+z" +
       "xufYDKLNWUhNO3K73yBGc8ZJjUEtHvbohjuAIaHXUtuU6Y0lKW+p0+koGZLZ" +
       "tmvQO77poLSN12SY2egJ0hOZ7gDNPYwWkQAdjLqz3QxqkkNzlzeFcJzW3MGO" +
       "DQW4u2QJaLsawK0ux+OZT3SoQbcmLCKEm4huXA+ySa/lqspqEMfQtGN6jeYQ" +
       "DD8tiTfU2NlmsS9Y0txr5DzcqW66GLSoInydJwQuX3a33IjmqsFUyFTD4Z1M" +
       "xmC5wU/7aaDInQbcRXTRXu5sGYWtpDPPKB3O4KnQE1pZVUpa252V12E+HyGw" +
       "No9HUp45na2vjreItoXNoBFtBxDCRJsacCv8uI5S9AAKyXVtEGKC62L8oknV" +
       "xl2KiFrUyvDHEJF7y+1U3SqCQuRzkZ+LNSnhNxOk3elEkLZQMm2WWt6GxXtp" +
       "n+xzwkYWto06L8tZfyRgYHVfs9vJpNGfegScQjuoheArL4+bsBt1Z0Qj5YaE" +
       "ZKmkhLDDmgDhmr4dwv0W6qRm1Jste5OBKGCNbooowFhFg4ynmhgzQBa75dxf" +
       "8RsUVhpwaA8V3SZEa2PMgk6PtoiqIxvNiRTPl6PQ71JmO7Z3CsbrtJlgaC6O" +
       "W0hA1UiNsfNWK8jRFrrMzenaG8Rh24bpGq+OMqzNE/PMSFujJd1yTWQnk2uV" +
       "SlrxulMzIZ0fsDMuUoxI6+twdzft1mEyaKW9oJosXRgY3ySdL/Ne0wzsJt+h" +
       "YJQ3JpCOCDSdmXoTW2wbsteyov6oI5L9zlDuyAOriTbVahxWs25Xqm1XBqZo" +
       "GZekMaXpS7jJQetEVwXgGVY7/FJMu6NJKLSq3RWPplOhHq8gh++3GF/TGbJj" +
       "InC0TRJyChnmDo8IWqmyLLWQUYWIwq3tQPO5HC5rCKSDeXCuOb6vuUynzeE1" +
       "yeE1N5BbOGyyM1mShwoc9qZSsBsZc01KOMWO0LaWT0drocnvcrTtuJTW25oT" +
       "JZvqXdNWO6ERGiSUh64VpgtNzFvrZrWvb/OWhcwRp99Od8rO7bW2wPuYIxtr" +
       "OkO7ApOIzmLBc7OFQ4gOTKFTMRQt0LahrT2Y0ZY5rWdLrrXjN76lk4Q5rtoS" +
       "XO92MESj7YRhu1TeyHCsv6ouSUsnVsM56vGax2Ioo8aoo/GGInWonsMZCkpQ" +
       "PXImEnYw9jHgpXOhGmEOpW76bYwAbp/ZjLiJ502JqT5u1SKqO7TE/pTT7FQi" +
       "uEHMuFycErNspNT6ZDQcDbsSmCKXELJtul2wcOzOBUdpC7WpRqSxNJvI/caQ" +
       "6Wd1G59AKyyQ+Q3JZwOZNNv1cDKwKXHNaT1fUnJhp2x644mMuxm2pPlmzxGW" +
       "uxY1azT01oxFksY82SZVs+2OHTJMNGyVGQ0MXxELV9bRNdLryzxqLw05bIxD" +
       "rBV4cOZZi3GW9jfDoNlwmgZYirRgTyAhHqyeMqyLU626G2LVLjvvj1Mlok1L" +
       "YrI0Wm/GrCrWEMpjhE5Tnjq2py9m6nww27EB1xZ7zrptOqymUg0Mm3hLntcI" +
       "pCvEhIBO2lDeCZupvDXYAEnqZGs0JEajNkq67chrLyhHAEOe5TpTZ9LtzSZJ" +
       "suJ6QxbpENPdoi6ssWAy1/00nk3muERq9dq6215sFlJXFPq1Na8geci1dYqD" +
       "ub7o16tYjuTu1FrU8BFqmKpBR9v5mtgN7aCYNri0h4kZP4rHAcJSXZL06xqN" +
       "7dSuEQUJl21YdLRbYCtlEFOmEnu7Bj/2IlGgNkOhk3jqYIOwfYh0vBiRKJux" +
       "d13BMce8bVrNltv1REdnlBVByBI3tWQtkVZB3IDX2jhszaglWW91KaMxh6Gq" +
       "tvZdS2bHThYNNahNMWvSZ8MsUOdMo4Py3hj2tN0a2DG3nQlyba64MYwklLTr" +
       "r/oODZY64Qih+optkkgnVLZZsFwynW1gy2qn08O6a851EGhXw+rQLhlsg0hk" +
       "DGcII4u2NmU683BHDMJF2m/QltVKkwSSIdwROtk2Bs5zHqznGx72Yd3KQNcx" +
       "MqV3LMxLezlTj2lL0BrTQUMnRzDOrCCDmkJbS4maJAMP6q0gnGmbad7RGUOh" +
       "wBJzWOiIUA+mUmoqrR2bNUZa2pwBNzGlXMQfsSztK0txls4mESzITJWpTkdG" +
       "d1512RZNbKv1eEDkSdbYoPmEiiREddfppLXTxGrg1eykqmFZWO/KbSPoUewu" +
       "qs/ieFGXfUQSNxJYi/DOehu3p2TqQ+lomAewFdmMwA6ZpRMqA3g0rrU6HjEJ" +
       "zcZm2EV4UuxO9F7aVcWpP12OVDqx2Bmr");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("LgfzHOh4hzWqYpiZeJeKwLxVRdUBWOrXpj25LTRq48kI74q1paevCAFemlq6" +
       "NhCMR4Z2IuVraYgqbAdGd2HDaOYq6tNxqNRVP6B0o+ZCHa3eUByxLQiM1oaI" +
       "dWctdFtbcj2qdsAcOUKX2TJm89DsBM7OI3aJ2YUta7pct7U4ntewmMzhgZ8y" +
       "7gYB/lZ9ytdTAsmmSrs5hRpYO3MmczBcpaUjaZqiq4iJxMvdus2PjKblTXcD" +
       "MJgh22nbVET0Ia+FdZHx0NbtznRRQzGsac49MtLSPFiGeiYoms2jVdfpQo0e" +
       "q/Xm9lgL6Z4QM0Y62FL+KBpCNAZWE1xqcoIJ1u7DudpBhY44UoY+1GXgHl8V" +
       "EXSubXcwanUIqu91EpGp4Wwjj1JqJ5kzrQ4LHbUXraH1WIA413er/obTGou8" +
       "1XHGdHs2cvllf8uv2EVdR+jerDOL8rUxoZSpUq+jAlNz7HQe0zXZDMatuqYq" +
       "G92eSbLlkGRmNjqes3LxrCly62AStHf9+o6gfZzVe5m1ajVa4spJmPFEnNOU" +
       "0khG3rIaTQewV3hYFOKuO3USFkKGHyW2gLVdZkgbbWTqNGAoCGvWsrtgB3Ww" +
       "9IiB3nCyXtOMvhuP0TWjdHgx2WzqIVM3kGUMvLqYVTrMUiBUg+IXk2FH36J5" +
       "KFVZisd4KWf4hIWVea/d6iBdtb1p7TBt21zgPTx0G7VR08itdVAf9NRqUkUI" +
       "NmExTKjpm2m8hMSt3hlb8mQbzbdShoWjpMt14NG6mW6Gcd6F4DbRk216XrMX" +
       "gThfGKIaLltIO5UchA2E1qy6I8AqoVpfILg53s23danKzQcNTBKpLJ2ayU7O" +
       "CRIorotg/RwhlSyeY83RmKa49jai3QHm0LOW3N5pilqtclrS5pBeK+1EXLUz" +
       "FbxJy5Cb/Xht8x1VrULtdi2uiTYznSpikup8VFWR/rbKMGGEhRDaRlH0hWLL" +
       "+kdu76nBk+UDkpPDn2unUyR8723slu+Tni2C504eKJWf+yuHg4LH32ceKJ05" +
       "WnJ0/DCm+qUclsOz+OTMb/Ho4A0XHQYtHxt85L0ffEmd/nDtyuEszz+JKw/F" +
       "fvA2R9tqzhkMrwI1vfXiRyST8izs6RmTX3rv5183f4f5Lbdxcu6ZczjPV/nP" +
       "Jx/9ZeLNyvdcqdxzcuLkhlO61xd6/vpzJg+HWpyE3vy60yZvOOmSp4oeeBZc" +
       "7zp0ybvOP+M77fQb1OeoVJ+90lxyVOrlS9L+TRH8fFx53NBiGqCOQEdrC5Ys" +
       "9e1U1f7VrR7MnK23jPi560V8GlzqQUT17ov4a5ek/XoR/FJceRSISPmK5NCH" +
       "3jkj3yfvVL43gMs+yGffffl++5K0TxfBb8SVR4B8x0p4PHifvmHwyvujtPvj" +
       "rKcE/OYdEPDK4w4ODwSEd5+AP7gk7XNF8N8AAcUZMrc8qLmX7KUzVvKH4soD" +
       "su87muSdSv27dyD1VxWRdXBtD1Jvb1dq55ZS/8UlaX9VBH8WV15j7e2uJcUa" +
       "EUqBCTxa2ldPVODZm55ZuSFnyccX7oCPVxeRhSV774GP994dPq6UGa4ci/Pc" +
       "5Rp9eOnjOPcri9xpQ7mm+u61w0nuopWjey5m9uihIvJv9wOqMBgncwio8FXl" +
       "QQEpja8ZGqiS8S0vrmOnDH7xDhh8rIhEwfUdBwa/464yWIh2bxHcX0r5qksY" +
       "eE0RPAH8EElVD4zO/b5pHV5yOTeu7t36lnpCwdGTd0DBM0VkE1wfOVDwkS8n" +
       "BVcvoeDNRfAM6HA5AWKfHu3aH0g5VofX3ewU5pksJSFvvFOdKMr99IGQn7w7" +
       "hNxz4n8efW1JSElNKXn9ElaaRfA2IDdQDMLZBebx6zAn0hfFjr7yVPhrdyp8" +
       "cfz2Nw7Cf+rLLvw7LhH+nUXQBQ5gMSqKwfClMfD2O2UAAdefHxj407vDwH1l" +
       "hvtOGThW6DfcdLYoTi+enVO+5uJzkEVWRgJWkdy/t3TgdXQJr0wRgFXPU4DX" +
       "suiFVA7ulMoXACuHldDRK75MVBZBcUD4aHIqvniJ+N9UBAswkR+r1eUcLO/U" +
       "vL4FiPO2Awdvuzsc3Ny86pcIXZylO5LiysNgji3etMKsbcngqZy3PAZ8KzmB" +
       "bEcvHOR84cspZ3iJnMXLNUduXHnMkGJTCwtRixXoOVm9O/W+wfLj6LsOsn7X" +
       "l1PWb7tE1vcUwW7fp6xmFF7TdacIr1/As1Ja7gq8qPzL2e986sP5xz66PyQo" +
       "S5EWV6CL3ja+8YXn4gW15y55ye70PdS/IN7+8h/93vJdx/sOj1xvHJ66jMRj" +
       "0/fY2feBynenjt532pG3PIF8KwM1AG3/zAHDx+9OR95bZrj3tCNv5sPdpzu+" +
       "VLrNR+89QdQtALxwBtHP3ATR0fvKoLz9R5dox4eK4B/ElSf2I2GvIMeTxBn7" +
       "9g/vgMKvLCKvAqC/cgD8K3eHwoPDcKwDb7th+gsKlQyvLTwrLt+NjCI/vHrw" +
       "nDfHk8L3lDz80CUc/dMi+DBYeZRO52EMHRp9yy324U4JPeXypTtVx7cDC/DI" +
       "vuyV++4Olw+UGR44Vcci4fPHUj55ehCbBOwZWnhOJ0vENQDnoQOshy4aqa84" +
       "HakTqUg7+tnjpP5Fi0huSdzwzu/V8559L9H1m+Oqn6HrkVuMlZ+6RA9+sQh+" +
       "DLjZuuU4N2/+3Kj58TvdwAIr9ys/eYB+l9YYZzyjM4YH0P+mW7mP5VvuRz99" +
       "juI3FbCeA/g+fsB5MwN59LNlUN5+8hKKi13Bo0/sNz5PGAZ6cq7NchQ8eQtu" +
       "Dm2e9sa/vdNx92bQ0icOLX7i7vTG0em2/hn5Xl9U/swtWjvL6acv4fQzRfAf" +
       "48qDoGMV+zDozijpb93p9hIw7fcc7cvuv2+HlptvMh6dZDh4OJ+7RMDPF8Hv" +
       "ASfAlWygLKFhnRrcL8FEnytRcvL7t8NJBkzCxX9OULxp/dob/itl//8eyo+/" +
       "9PiDr3lp8Z/K9/NP/oPjIaryoJ44ztkXY8/c3x+Emm6VvD20f002KHn485vt" +
       "LF8nawxmy225B3L0P/Zl/hJgv7hMXHno5P5sqf8FHIbzpYC3Un6fzfc3wO08" +
       "zRdX7t/fnM3yRYAJZAG3VyrBcZd93e3MBNn+odhrz2pouev31K068aTI2T8F" +
       "KOxd+Q84xw+fEubgEX/spRH9rV9o//D+TwkUR8rzopYHqcoD+/9HKCstHmA9" +
       "e2Ftx3XdP3zLXz/2Ew89d+z0PrYHfDpazmB75ub/AIC7QVy+s5//3Gv+xdf/" +
       "s5c+U74V9X8BvTC0rppIAAA=");
}
