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
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "nXdR8c/zmci/5Pc2nnpt3WLpYEA8c1gYkPM84mVq9Z78CoPxlKF6M+3CrFNn" +
           "orOawZk3bafe9IenE1EiNpfl1rL5WAtkz68WmNuPzT5OpiQYb3fjhRPWY3c6" +
           "f4UTFg5s18X4F72WWABq3LLVuXX3lsjHWkDbJwrMfQubcY7potd9yB1DHPpf" +
           "GaIFtLhta3P77g2Rj7WAst8tMHcCm29zUgUhEfYis2OL7/w3bJGGTTyPG4Jw" +
           "Fier/uPHEoCwWTlPt9Zzo/Ts0ZqymUcfekugV/ZJsBJwKJ5SFHcCd/VLdYPF" +
           "ZWGYSiud6+LrebikF5YSynpohUrft3jOcNKQn4eT8mzfzfUCJ7V+LqjGxbeb" +
           "7kWIXYcOAN7quEnOgkxAgt2f6Blj14pyEiugoFUBpYu8ySXr9Ol3crorHy30" +
           "QLl4dM/Absp6do9Ip49u2PTI9fuftp4RJIWOjuIqU+ACY71oZKF7Qd7VMmuV" +
           "rl9yo/q58kWZDFdnCeycnjmuEN8OVw8dS+kG3x3bbMletd8+tvrsL8ZKz0NJ" +
           "uo0UUU6mbsutFdN6CnLmtnDuRQ3SnLj8ty755sia5fGrvxPVOLEudo356SPS" +
           "xeMPXzg461hTgEzpJpMgebO0KGLXjqi9TBoy+kmVbHamQURYRaaK5xZYjWFN" +
           "8Tle2MU2Z1V2FB+hOGnOvQDnPt3BzWWYGe1aSo2JZAZp1hnx/Dcgk/1Suu5j" +
           "cEZcjwRrsVmVRm9APEbCG3U98z5QMU0X2NA58UUR2/Oii82FfwOblWIjkBsA" +
           "AA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
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
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "O37r5W8WFxn/A1mTEZXyHQAA");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "dd0+6619X2c+4Lxn7B5czx7xKfQ/i74tkeA6AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "dcT2wW0RbEOr1roNDf01zvQTX2e6C8+r");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "/9F/+uwXil1R/xeAgN0EmkgAAA==");
}
