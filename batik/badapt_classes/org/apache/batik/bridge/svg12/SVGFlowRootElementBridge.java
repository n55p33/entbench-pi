package org.apache.batik.bridge.svg12;
public class SVGFlowRootElementBridge extends org.apache.batik.bridge.svg12.SVG12TextElementBridge {
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
      LINE_HEIGHT =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        LINE_HEIGHT;
    public static final org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute
      TEXTPATH =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        TEXTPATH;
    public static final org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute
      ANCHOR_TYPE =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        ANCHOR_TYPE;
    public static final org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute
      LETTER_SPACING =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        LETTER_SPACING;
    public static final org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute
      WORD_SPACING =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        WORD_SPACING;
    public static final org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute
      KERNING =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        KERNING;
    protected java.util.Map flowRegionNodes;
    protected org.apache.batik.gvt.TextNode
      textNode;
    protected org.apache.batik.gvt.TextNode getTextNode() {
        return textNode;
    }
    protected org.apache.batik.bridge.svg12.SVGFlowRootElementBridge.RegionChangeListener
      regionChangeListener;
    public SVGFlowRootElementBridge() { super(
                                          );
    }
    public java.lang.String getNamespaceURI() {
        return org.apache.batik.util.SVG12Constants.
                 SVG_NAMESPACE_URI;
    }
    public java.lang.String getLocalName() {
        return org.apache.batik.util.SVG12Constants.
                 SVG_FLOW_ROOT_TAG;
    }
    public org.apache.batik.bridge.Bridge getInstance() {
        return new org.apache.batik.bridge.svg12.SVGFlowRootElementBridge(
          );
    }
    public boolean isComposite() { return false;
    }
    public org.apache.batik.gvt.GraphicsNode createGraphicsNode(org.apache.batik.bridge.BridgeContext ctx,
                                                                org.w3c.dom.Element e) {
        if (!org.apache.batik.bridge.SVGUtilities.
              matchUserAgent(
                e,
                ctx.
                  getUserAgent(
                    ))) {
            return null;
        }
        org.apache.batik.gvt.CompositeGraphicsNode cgn =
          new org.apache.batik.gvt.CompositeGraphicsNode(
          );
        java.lang.String s =
          e.
          getAttributeNS(
            null,
            SVG_TRANSFORM_ATTRIBUTE);
        if (s.
              length(
                ) !=
              0) {
            cgn.
              setTransform(
                org.apache.batik.bridge.SVGUtilities.
                  convertTransform(
                    e,
                    SVG_TRANSFORM_ATTRIBUTE,
                    s,
                    ctx));
        }
        cgn.
          setVisible(
            org.apache.batik.bridge.CSSUtilities.
              convertVisibility(
                e));
        java.awt.RenderingHints hints =
          null;
        hints =
          org.apache.batik.bridge.CSSUtilities.
            convertColorRendering(
              e,
              hints);
        hints =
          org.apache.batik.bridge.CSSUtilities.
            convertTextRendering(
              e,
              hints);
        if (hints !=
              null) {
            cgn.
              setRenderingHints(
                hints);
        }
        org.apache.batik.gvt.CompositeGraphicsNode cgn2 =
          new org.apache.batik.gvt.CompositeGraphicsNode(
          );
        cgn.
          add(
            cgn2);
        org.apache.batik.gvt.flow.FlowTextNode tn =
          (org.apache.batik.gvt.flow.FlowTextNode)
            instantiateGraphicsNode(
              );
        tn.
          setLocation(
            getLocation(
              ctx,
              e));
        if (ctx.
              getTextPainter(
                ) !=
              null) {
            tn.
              setTextPainter(
                ctx.
                  getTextPainter(
                    ));
        }
        textNode =
          tn;
        cgn.
          add(
            tn);
        associateSVGContext(
          ctx,
          e,
          cgn);
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
        return cgn;
    }
    protected org.apache.batik.gvt.GraphicsNode instantiateGraphicsNode() {
        return new org.apache.batik.gvt.flow.FlowTextNode(
          );
    }
    protected java.awt.geom.Point2D getLocation(org.apache.batik.bridge.BridgeContext ctx,
                                                org.w3c.dom.Element e) {
        return new java.awt.geom.Point2D.Float(
          0,
          0);
    }
    protected boolean isTextElement(org.w3c.dom.Element e) {
        if (!SVG_NAMESPACE_URI.
              equals(
                e.
                  getNamespaceURI(
                    )))
            return false;
        java.lang.String nodeName =
          e.
          getLocalName(
            );
        return nodeName.
          equals(
            org.apache.batik.util.SVG12Constants.
              SVG_FLOW_DIV_TAG) ||
          nodeName.
          equals(
            org.apache.batik.util.SVG12Constants.
              SVG_FLOW_LINE_TAG) ||
          nodeName.
          equals(
            org.apache.batik.util.SVG12Constants.
              SVG_FLOW_PARA_TAG) ||
          nodeName.
          equals(
            org.apache.batik.util.SVG12Constants.
              SVG_FLOW_REGION_BREAK_TAG) ||
          nodeName.
          equals(
            org.apache.batik.util.SVG12Constants.
              SVG_FLOW_SPAN_TAG);
    }
    protected boolean isTextChild(org.w3c.dom.Element e) {
        if (!SVG_NAMESPACE_URI.
              equals(
                e.
                  getNamespaceURI(
                    )))
            return false;
        java.lang.String nodeName =
          e.
          getLocalName(
            );
        return nodeName.
          equals(
            org.apache.batik.util.SVG12Constants.
              SVG_A_TAG) ||
          nodeName.
          equals(
            org.apache.batik.util.SVG12Constants.
              SVG_FLOW_LINE_TAG) ||
          nodeName.
          equals(
            org.apache.batik.util.SVG12Constants.
              SVG_FLOW_PARA_TAG) ||
          nodeName.
          equals(
            org.apache.batik.util.SVG12Constants.
              SVG_FLOW_REGION_BREAK_TAG) ||
          nodeName.
          equals(
            org.apache.batik.util.SVG12Constants.
              SVG_FLOW_SPAN_TAG);
    }
    public void buildGraphicsNode(org.apache.batik.bridge.BridgeContext ctx,
                                  org.w3c.dom.Element e,
                                  org.apache.batik.gvt.GraphicsNode node) {
        org.apache.batik.gvt.CompositeGraphicsNode cgn =
          (org.apache.batik.gvt.CompositeGraphicsNode)
            node;
        boolean isStatic =
          !ctx.
          isDynamic(
            );
        if (isStatic) {
            flowRegionNodes =
              new java.util.HashMap(
                );
        }
        else {
            regionChangeListener =
              new org.apache.batik.bridge.svg12.SVGFlowRootElementBridge.RegionChangeListener(
                );
        }
        org.apache.batik.gvt.CompositeGraphicsNode cgn2 =
          (org.apache.batik.gvt.CompositeGraphicsNode)
            cgn.
            get(
              0);
        org.apache.batik.bridge.GVTBuilder builder =
          ctx.
          getGVTBuilder(
            );
        for (org.w3c.dom.Node n =
               getFirstChild(
                 e);
             n !=
               null;
             n =
               getNextSibling(
                 n)) {
            if (n instanceof org.apache.batik.dom.svg12.SVGOMFlowRegionElement) {
                for (org.w3c.dom.Node m =
                       getFirstChild(
                         n);
                     m !=
                       null;
                     m =
                       getNextSibling(
                         m)) {
                    if (m.
                          getNodeType(
                            ) !=
                          org.w3c.dom.Node.
                            ELEMENT_NODE) {
                        continue;
                    }
                    org.apache.batik.gvt.GraphicsNode gn =
                      builder.
                      build(
                        ctx,
                        (org.w3c.dom.Element)
                          m);
                    if (gn !=
                          null) {
                        cgn2.
                          add(
                            gn);
                        if (isStatic) {
                            flowRegionNodes.
                              put(
                                m,
                                gn);
                        }
                    }
                }
                if (!isStatic) {
                    org.apache.batik.dom.AbstractNode an =
                      (org.apache.batik.dom.AbstractNode)
                        n;
                    org.apache.batik.dom.svg12.XBLEventSupport es =
                      (org.apache.batik.dom.svg12.XBLEventSupport)
                        an.
                        initializeEventSupport(
                          );
                    es.
                      addImplementationEventListenerNS(
                        SVG_NAMESPACE_URI,
                        "shapechange",
                        regionChangeListener,
                        false);
                }
            }
        }
        org.apache.batik.gvt.GraphicsNode tn =
          (org.apache.batik.gvt.GraphicsNode)
            cgn.
            get(
              1);
        super.
          buildGraphicsNode(
            ctx,
            e,
            tn);
        flowRegionNodes =
          null;
    }
    protected void computeLaidoutText(org.apache.batik.bridge.BridgeContext ctx,
                                      org.w3c.dom.Element e,
                                      org.apache.batik.gvt.GraphicsNode node) {
        super.
          computeLaidoutText(
            ctx,
            getFlowDivElement(
              e),
            node);
    }
    protected void addContextToChild(org.apache.batik.bridge.BridgeContext ctx,
                                     org.w3c.dom.Element e) {
        if (SVG_NAMESPACE_URI.
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
                    org.apache.batik.util.SVG12Constants.
                      SVG_FLOW_DIV_TAG) ||
                  ln.
                  equals(
                    org.apache.batik.util.SVG12Constants.
                      SVG_FLOW_LINE_TAG) ||
                  ln.
                  equals(
                    org.apache.batik.util.SVG12Constants.
                      SVG_FLOW_PARA_TAG) ||
                  ln.
                  equals(
                    org.apache.batik.util.SVG12Constants.
                      SVG_FLOW_SPAN_TAG)) {
                ((org.apache.batik.dom.svg.SVGOMElement)
                   e).
                  setSVGContext(
                    new org.apache.batik.bridge.svg12.SVGFlowRootElementBridge.FlowContentBridge(
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
    protected void removeContextFromChild(org.apache.batik.bridge.BridgeContext ctx,
                                          org.w3c.dom.Element e) {
        if (SVG_NAMESPACE_URI.
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
                    org.apache.batik.util.SVG12Constants.
                      SVG_FLOW_DIV_TAG) ||
                  ln.
                  equals(
                    org.apache.batik.util.SVG12Constants.
                      SVG_FLOW_LINE_TAG) ||
                  ln.
                  equals(
                    org.apache.batik.util.SVG12Constants.
                      SVG_FLOW_PARA_TAG) ||
                  ln.
                  equals(
                    org.apache.batik.util.SVG12Constants.
                      SVG_FLOW_SPAN_TAG)) {
                ((org.apache.batik.bridge.SVGTextElementBridge.AbstractTextChildBridgeUpdateHandler)
                   ((org.apache.batik.dom.svg.SVGOMElement)
                      e).
                   getSVGContext(
                     )).
                  dispose(
                    );
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
                removeContextFromChild(
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
        if (element ==
              null)
            return null;
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
        org.apache.batik.gvt.flow.TextLineBreaks.
          findLineBrk(
            ret);
        return ret;
    }
    protected void dumpACIWord(java.text.AttributedString as) {
        if (as ==
              null)
            return;
        java.lang.StringBuffer chars =
          new java.lang.StringBuffer(
          );
        java.lang.StringBuffer brkStr =
          new java.lang.StringBuffer(
          );
        java.text.AttributedCharacterIterator aci =
          as.
          getIterator(
            );
        java.text.AttributedCharacterIterator.Attribute WORD_LIMIT =
          org.apache.batik.gvt.flow.TextLineBreaks.
            WORD_LIMIT;
        for (char ch =
               aci.
               current(
                 );
             ch !=
               java.text.AttributedCharacterIterator.
                 DONE;
             ch =
               aci.
                 next(
                   )) {
            chars.
              append(
                ch).
              append(
                ' ').
              append(
                ' ');
            int w =
              ((java.lang.Integer)
                 aci.
                 getAttribute(
                   WORD_LIMIT)).
              intValue(
                );
            brkStr.
              append(
                w).
              append(
                ' ');
            if (w <
                  10) {
                brkStr.
                  append(
                    ' ');
            }
        }
        java.lang.System.
          out.
          println(
            chars.
              toString(
                ));
        java.lang.System.
          out.
          println(
            brkStr.
              toString(
                ));
    }
    protected org.w3c.dom.Element getFlowDivElement(org.w3c.dom.Element elem) {
        java.lang.String eNS =
          elem.
          getNamespaceURI(
            );
        if (!eNS.
              equals(
                SVG_NAMESPACE_URI))
            return null;
        java.lang.String nodeName =
          elem.
          getLocalName(
            );
        if (nodeName.
              equals(
                org.apache.batik.util.SVG12Constants.
                  SVG_FLOW_DIV_TAG))
            return elem;
        if (!nodeName.
              equals(
                org.apache.batik.util.SVG12Constants.
                  SVG_FLOW_ROOT_TAG))
            return null;
        for (org.w3c.dom.Node n =
               getFirstChild(
                 elem);
             n !=
               null;
             n =
               getNextSibling(
                 n)) {
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
            if (!SVG_NAMESPACE_URI.
                  equals(
                    nNS))
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
                    org.apache.batik.util.SVG12Constants.
                      SVG_FLOW_DIV_TAG))
                return e;
        }
        return null;
    }
    protected java.text.AttributedString getFlowDiv(org.apache.batik.bridge.BridgeContext ctx,
                                                    org.w3c.dom.Element element) {
        org.w3c.dom.Element flowDiv =
          getFlowDivElement(
            element);
        if (flowDiv ==
              null)
            return null;
        return gatherFlowPara(
                 ctx,
                 flowDiv);
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
               getFirstChild(
                 div);
             n !=
               null;
             n =
               getNextSibling(
                 n)) {
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
                    org.apache.batik.util.SVG12Constants.
                      SVG_FLOW_PARA_TAG)) {
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
                        org.apache.batik.util.SVG12Constants.
                          SVG_FLOW_REGION_BREAK_TAG)) {
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
        if (ret ==
              null)
            return null;
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
                    makeBlockInfo(
                      ctx,
                      elem));
                continue;
            }
            ret.
              addAttribute(
                FLOW_PARAGRAPH,
                makeBlockInfo(
                  ctx,
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
        element =
          (org.w3c.dom.Element)
            element.
            getParentNode(
              );
        java.util.List ret =
          new java.util.LinkedList(
          );
        for (org.w3c.dom.Node n =
               getFirstChild(
                 element);
             n !=
               null;
             n =
               getNextSibling(
                 n)) {
            if (n.
                  getNodeType(
                    ) !=
                  org.w3c.dom.Node.
                    ELEMENT_NODE)
                continue;
            if (!org.apache.batik.util.SVG12Constants.
                   SVG_NAMESPACE_URI.
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
            if (!org.apache.batik.util.SVG12Constants.
                   SVG_FLOW_REGION_TAG.
                  equals(
                    ln))
                continue;
            float verticalAlignment =
              0.0F;
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
        boolean isStatic =
          !ctx.
          isDynamic(
            );
        for (org.w3c.dom.Node n =
               getFirstChild(
                 rgn);
             n !=
               null;
             n =
               getNextSibling(
                 n)) {
            if (n.
                  getNodeType(
                    ) !=
                  org.w3c.dom.Node.
                    ELEMENT_NODE) {
                continue;
            }
            org.apache.batik.gvt.GraphicsNode gn =
              isStatic
              ? (org.apache.batik.gvt.GraphicsNode)
                  flowRegionNodes.
                  get(
                    n)
              : ctx.
              getGraphicsNode(
                n);
            java.awt.Shape s =
              gn.
              getOutline(
                );
            if (s ==
                  null) {
                continue;
            }
            java.awt.geom.AffineTransform at =
              gn.
              getTransform(
                );
            if (at !=
                  null) {
                s =
                  at.
                    createTransformedShape(
                      s);
            }
            regions.
              add(
                new org.apache.batik.gvt.flow.RegionInfo(
                  s,
                  verticalAlign));
        }
    }
    protected int startLen;
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
        if (top) {
            endLimit =
              (startLen =
                 asb.
                   length(
                     ));
        }
        if (preserve) {
            endLimit =
              startLen;
        }
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
        int lineBreak =
          -1;
        if (lnLocs.
              size(
                ) !=
              0) {
            lineBreak =
              ((java.lang.Integer)
                 lnLocs.
                 get(
                   lnLocs.
                     size(
                       ) -
                     1)).
                intValue(
                  );
        }
        for (org.w3c.dom.Node n =
               getFirstChild(
                 element);
             n !=
               null;
             n =
               getNextSibling(
                 n)) {
            if (preserve) {
                prevEndsWithSpace =
                  false;
            }
            else {
                int len =
                  asb.
                  length(
                    );
                if (len ==
                      startLen) {
                    prevEndsWithSpace =
                      true;
                }
                else {
                    prevEndsWithSpace =
                      asb.
                        getLastChar(
                          ) ==
                        ' ';
                    int idx =
                      lnLocs.
                      size(
                        ) -
                      1;
                    if (!prevEndsWithSpace &&
                          idx >=
                          0) {
                        java.lang.Integer i =
                          (java.lang.Integer)
                            lnLocs.
                            get(
                              idx);
                        if (i.
                              intValue(
                                ) ==
                              len) {
                            prevEndsWithSpace =
                              true;
                        }
                    }
                }
            }
            switch (n.
                      getNodeType(
                        )) {
                case org.w3c.dom.Node.
                       ELEMENT_NODE:
                    if (!SVG_NAMESPACE_URI.
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
                            org.apache.batik.util.SVG12Constants.
                              SVG_FLOW_LINE_TAG)) {
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
                        lineBreak =
                          asb.
                            length(
                              );
                        lnLocs.
                          add(
                            new java.lang.Integer(
                              lineBreak));
                        if (before !=
                              lineBreak) {
                            initialAttributes =
                              null;
                        }
                    }
                    else
                        if (ln.
                              equals(
                                org.apache.batik.util.SVG12Constants.
                                  SVG_FLOW_SPAN_TAG) ||
                              ln.
                              equals(
                                org.apache.batik.util.SVG12Constants.
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
                                        java.util.Map m =
                                          new java.util.HashMap(
                                          );
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
                int idx =
                  lnLocs.
                  size(
                    ) -
                  1;
                int len =
                  asb.
                  length(
                    );
                if (idx >=
                      0) {
                    java.lang.Integer i =
                      (java.lang.Integer)
                        lnLocs.
                        get(
                          idx);
                    if (i.
                          intValue(
                            ) >=
                          len) {
                        i =
                          new java.lang.Integer(
                            len -
                              1);
                        lnLocs.
                          set(
                            idx,
                            i);
                        idx--;
                        while (idx >=
                                 0) {
                            i =
                              (java.lang.Integer)
                                lnLocs.
                                get(
                                  idx);
                            if (i.
                                  intValue(
                                    ) <
                                  len -
                                  1)
                                break;
                            lnLocs.
                              remove(
                                idx);
                            idx--;
                        }
                    }
                }
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
        java.util.Map inheritingMap =
          super.
          getAttributeMap(
            ctx,
            element,
            textPath,
            bidiLevel,
            result);
        float fontSize =
          org.apache.batik.bridge.TextUtilities.
          convertFontSize(
            element).
          floatValue(
            );
        float lineHeight =
          getLineHeight(
            ctx,
            element,
            fontSize);
        result.
          put(
            LINE_HEIGHT,
            new java.lang.Float(
              lineHeight));
        return inheritingMap;
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
    int marginTopIndex = -1;
    int marginRightIndex = -1;
    int marginBottomIndex = -1;
    int marginLeftIndex = -1;
    int indentIndex = -1;
    int textAlignIndex = -1;
    int lineHeightIndex = -1;
    protected void initCSSPropertyIndexes(org.w3c.dom.Element e) {
        org.apache.batik.css.engine.CSSEngine eng =
          org.apache.batik.bridge.CSSUtilities.
          getCSSEngine(
            e);
        marginTopIndex =
          eng.
            getPropertyIndex(
              org.apache.batik.util.SVG12CSSConstants.
                CSS_MARGIN_TOP_PROPERTY);
        marginRightIndex =
          eng.
            getPropertyIndex(
              org.apache.batik.util.SVG12CSSConstants.
                CSS_MARGIN_RIGHT_PROPERTY);
        marginBottomIndex =
          eng.
            getPropertyIndex(
              org.apache.batik.util.SVG12CSSConstants.
                CSS_MARGIN_BOTTOM_PROPERTY);
        marginLeftIndex =
          eng.
            getPropertyIndex(
              org.apache.batik.util.SVG12CSSConstants.
                CSS_MARGIN_LEFT_PROPERTY);
        indentIndex =
          eng.
            getPropertyIndex(
              org.apache.batik.util.SVG12CSSConstants.
                CSS_INDENT_PROPERTY);
        textAlignIndex =
          eng.
            getPropertyIndex(
              org.apache.batik.util.SVG12CSSConstants.
                CSS_TEXT_ALIGN_PROPERTY);
        lineHeightIndex =
          eng.
            getPropertyIndex(
              org.apache.batik.util.SVG12CSSConstants.
                CSS_LINE_HEIGHT_PROPERTY);
    }
    public org.apache.batik.gvt.flow.BlockInfo makeBlockInfo(org.apache.batik.bridge.BridgeContext ctx,
                                                             org.w3c.dom.Element element) {
        if (marginTopIndex ==
              -1)
            initCSSPropertyIndexes(
              element);
        org.apache.batik.css.engine.value.Value v;
        v =
          org.apache.batik.bridge.CSSUtilities.
            getComputedStyle(
              element,
              marginTopIndex);
        float top =
          v.
          getFloatValue(
            );
        v =
          org.apache.batik.bridge.CSSUtilities.
            getComputedStyle(
              element,
              marginRightIndex);
        float right =
          v.
          getFloatValue(
            );
        v =
          org.apache.batik.bridge.CSSUtilities.
            getComputedStyle(
              element,
              marginBottomIndex);
        float bottom =
          v.
          getFloatValue(
            );
        v =
          org.apache.batik.bridge.CSSUtilities.
            getComputedStyle(
              element,
              marginLeftIndex);
        float left =
          v.
          getFloatValue(
            );
        v =
          org.apache.batik.bridge.CSSUtilities.
            getComputedStyle(
              element,
              indentIndex);
        float indent =
          v.
          getFloatValue(
            );
        v =
          org.apache.batik.bridge.CSSUtilities.
            getComputedStyle(
              element,
              textAlignIndex);
        if (v ==
              org.apache.batik.css.engine.value.ValueConstants.
                INHERIT_VALUE) {
            v =
              org.apache.batik.bridge.CSSUtilities.
                getComputedStyle(
                  element,
                  org.apache.batik.css.engine.SVGCSSEngine.
                    DIRECTION_INDEX);
            if (v ==
                  org.apache.batik.css.engine.value.ValueConstants.
                    LTR_VALUE)
                v =
                  org.apache.batik.css.engine.value.svg12.SVG12ValueConstants.
                    START_VALUE;
            else
                v =
                  org.apache.batik.css.engine.value.svg12.SVG12ValueConstants.
                    END_VALUE;
        }
        int textAlign;
        if (v ==
              org.apache.batik.css.engine.value.svg12.SVG12ValueConstants.
                START_VALUE)
            textAlign =
              org.apache.batik.gvt.flow.BlockInfo.
                ALIGN_START;
        else
            if (v ==
                  org.apache.batik.css.engine.value.svg12.SVG12ValueConstants.
                    MIDDLE_VALUE)
                textAlign =
                  org.apache.batik.gvt.flow.BlockInfo.
                    ALIGN_MIDDLE;
            else
                if (v ==
                      org.apache.batik.css.engine.value.svg12.SVG12ValueConstants.
                        END_VALUE)
                    textAlign =
                      org.apache.batik.gvt.flow.BlockInfo.
                        ALIGN_END;
                else
                    textAlign =
                      org.apache.batik.gvt.flow.BlockInfo.
                        ALIGN_FULL;
        java.util.Map fontAttrs =
          new java.util.HashMap(
          20);
        java.util.List fontList =
          getFontList(
            ctx,
            element,
            fontAttrs);
        java.lang.Float fs =
          (java.lang.Float)
            fontAttrs.
            get(
              java.awt.font.TextAttribute.
                SIZE);
        float fontSize =
          fs.
          floatValue(
            );
        float lineHeight =
          getLineHeight(
            ctx,
            element,
            fontSize);
        java.lang.String ln =
          element.
          getLocalName(
            );
        boolean rgnBr;
        rgnBr =
          ln.
            equals(
              org.apache.batik.util.SVG12Constants.
                SVG_FLOW_REGION_BREAK_TAG);
        return new org.apache.batik.gvt.flow.BlockInfo(
          top,
          right,
          bottom,
          left,
          indent,
          textAlign,
          lineHeight,
          fontList,
          fontAttrs,
          rgnBr);
    }
    protected float getLineHeight(org.apache.batik.bridge.BridgeContext ctx,
                                  org.w3c.dom.Element element,
                                  float fontSize) {
        if (lineHeightIndex ==
              -1)
            initCSSPropertyIndexes(
              element);
        org.apache.batik.css.engine.value.Value v =
          org.apache.batik.bridge.CSSUtilities.
          getComputedStyle(
            element,
            lineHeightIndex);
        if (v ==
              org.apache.batik.css.engine.value.ValueConstants.
                INHERIT_VALUE ||
              v ==
              org.apache.batik.css.engine.value.svg12.SVG12ValueConstants.
                NORMAL_VALUE) {
            return fontSize *
              1.1F;
        }
        float lineHeight =
          v.
          getFloatValue(
            );
        if (v instanceof org.apache.batik.css.engine.value.ComputedValue)
            v =
              ((org.apache.batik.css.engine.value.ComputedValue)
                 v).
                getComputedValue(
                  );
        if (v instanceof org.apache.batik.css.engine.value.svg12.LineHeightValue &&
              ((org.apache.batik.css.engine.value.svg12.LineHeightValue)
                 v).
              getFontSizeRelative(
                ))
            lineHeight *=
              fontSize;
        return lineHeight;
    }
    protected class FlowContentBridge extends org.apache.batik.bridge.SVGTextElementBridge.AbstractTextChildTextContent {
        public FlowContentBridge(org.apache.batik.bridge.BridgeContext ctx,
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
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "99/5Oy9/s7i7+B9AWZty1x0AAA==");
    }
    protected class RegionChangeListener implements org.w3c.dom.events.EventListener {
        public void handleEvent(org.w3c.dom.events.Event evt) {
            laidoutText =
              null;
            computeLaidoutText(
              ctx,
              e,
              getTextNode(
                ));
        }
        public RegionChangeListener() { super(
                                          );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "neePbHjyf282LSAXFQAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "4IHfe+NvPf/Nokr3PwNNYLogIAAA");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "SAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL18C7DsyFne3HP3vet92Wsva3sf9q7BHnM1D2keLMaMZkbS" +
       "jKSRRtK85JhrvUej92s0I2JjDLFdUHYcWMCk8JKkcGIog6kEYigKylTiAIWT" +
       "KgN5QApsEipAHKdwKCAJAdLSzHncc88512fvmlOlHh2pu/V9///333+3uvXJ" +
       "L5fujMJS2ffsrWF78TVtE19b2ci1eOtr0bUhhbBSGGlq15aiSADXritv+OmH" +
       "/vwvP7J8+KB0l1h6peS6XizFpudGnBZ59lpTqdJDx1f7tuZEcelhaiWtJSiJ" +
       "TRuizCh+nirdf6JoXHqWOoQAAQgQgAAVEKDOcS5Q6BWamzjdvITkxlFQek/p" +
       "ClW6y1dyeHHpmRsr8aVQcvbVsAUDUMM9+f9TQKoovAlLTx9x33G+ifAPlKEX" +
       "fujbHv7nV0sPiaWHTJfP4SgARAweIpYecDRH1sKoo6qaKpYecTVN5bXQlGwz" +
       "K3CLpUcj03ClOAm1IyHlFxNfC4tnHkvuASXnFiZK7IVH9HRTs9XD/+7UbckA" +
       "XF99zHXHEMuvA4L3mQBYqEuKdljkDst01bj01OkSRxyfJUEGUPRuR4uX3tGj" +
       "7nAlcKH06E53tuQaEB+HpmuArHd6CXhKXHri3EpzWfuSYkmGdj0uPX46H7u7" +
       "BXLdWwgiLxKXHjudragJaOmJU1o6oZ8vj775w9/uEu5BgVnVFDvHfw8o9OSp" +
       "Qpyma6HmKtqu4ANvoX5QevUvfvCgVAKZHzuVeZfn03/3K9/61ic/86u7PK89" +
       "Iw8jrzQlvq78mPzg51/XfXP7ag7jHt+LzFz5NzAvzJ/d33l+44OW9+qjGvOb" +
       "1w5vfob7N4v3/oT2pYPSfYPSXYpnJw6wo0cUz/FNWwtxzdVCKdbUQelezVW7" +
       "xf1B6W5wTpmutrvK6HqkxYPSHXZx6S6v+B+ISAdV5CK6G5ybru4dnvtSvCzO" +
       "N36pVLobHKUHwDEr7f6K37hkQkvP0SBJkVzT9SA29HL+EaS5sQxku4RkYPUW" +
       "FHlJCEwQ8kIDkoAdLLX9DTk0VUODorVRrUH8FMdsL+U8L849BagDLW5fy03O" +
       "/9t82CZn/nB65QpQyutOuwQbtCbCs1UtvK68kKD9r/zU9V8/OGoie5nFpQZ4" +
       "/rXd868Vz7+2e/614vnXznt+6cqV4rGvynHs7ABo0QL+AHjKB97Mv3P4rg++" +
       "4SowQD+9A6ggzwqd77C7xx5kUPhJBZhx6TMfTb9z+h2Vg9LBjZ43xw4u3ZcX" +
       "Z3N/eeQXnz3d4s6q96EP/NGff+oH3+0dt70bXPneJdxcMm/Sbzgt5dBTNBU4" +
       "yePq3/K09LPXf/Hdzx6U7gB+AvjGWAK2DNzOk6efcUPTfv7QTeZc7gSEdS90" +
       "JDu/dejb7ouXoZceXynU/2Bx/giQ8f25rb8RHN+3N/7iN7/7Sj9PX7Uzl1xp" +
       "p1gUbvhtvP+x//Tv/rheiPvQYz90og/ktfj5E14ir+yhwh88cmwDQqhpIN/v" +
       "fpT9/h/48gfeURgAyPHGsx74bJ52gXcAKgRi/nu/Gvz2F37vx37r4NhoYtBN" +
       "JrJtKpsjkvn10n0XkARPe9MxHuBlbND4cqt5duI6nmrqpiTbWm6l/++h56o/" +
       "+z8+/PDODmxw5dCM3nrrCo6vfx1aeu+vf9tfPFlUc0XJe7ljmR1n27nOVx7X" +
       "3AlDaZvj2Hznb7z+h39F+hhwwsDxRWamFb6sVMigVCgNKvi/pUivnbpXzZOn" +
       "opPGf2P7OhGNXFc+8lt/8orpn/zSVwq0N4YzJ3VNS/7zO/PKk6c3oPrXnG7p" +
       "hBQtQT74M6O/87D9mb8ENYqgRgX4tIgJgdvZ3GAZ+9x33v07v/yvXv2uz18t" +
       "HWCl+2xPUjGpaGSle4F1a9ESeKyN//Zv3Sk3vQckDxdUSzeR3xnF48V/jwOA" +
       "bz7fv2B5NHLcRB//v4wtv++//O+bhFB4ljM64VPlReiTP/JE91u+VJQ/buJ5" +
       "6Sc3N7tiELkdl639hPNnB2+467MHpbvF0sPKPiycSnaSNxwRhELRYawIQscb" +
       "7t8Y1uz68OePXNjrTruXE4897VyOuwBwnufOz+875U9y2Zd64HjHvqmJp/3J" +
       "lVJx8vaiyDNF+myefH2hk6v56TeANhwVwWcMIJiuZO/b8t+Avyvg+Ov8yCvO" +
       "L+x660e7+5Dh6aOYwQc91YMYxcyusx2ug3MdliiqeSwuQYWN5XHttU4MQj0Z" +
       "BHlqdwmcigKivUGsFd7l2aN7OyeYp7U8+dYdHuRck/umGwUyBMf1vUC+7RyB" +
       "UBcJJE+6edIr5N2PS68qiPVpVlgc08vvEaew0pfE2geHsscqn4OVvxzWhwqs" +
       "1GDUv45y/Q55FkzhkjBRcBh7mPo5MMXLwXyggMn18QEz4s/C+I5LYuyAw9pj" +
       "XJ2DUbocxvsLKRL9AU4IZ0GUv3qIhUP8FnB4e4juORCXl4N4j9CfC2xHOGps" +
       "2E3RorGOd40PnwoXtT8B5DmvDZqXZJorI9ozDc9hGlxSGZ1Rl2C468KC7eeX" +
       "nFMQw0tCzP1muoe4Pgfi5nIQH6T6gtDnrvNspzsY4Weh3F4SZd7yvn2PMjsH" +
       "5XdcsuXNGK53Ecb3XhLj28DxHXuM7zkH4/svh/Fuss+NzoH3ga8e3oP51TeA" +
       "47v38L77HHgfOhseiG/v9UMvBt24ph45WD0fbmkGCEdGngpiqbD0zDmBDSel" +
       "xZTCdeXnx1/8/MeyT31yF8rKEhgzl8rnzU7dPEGWj2yeu2B0djxv8Wf4N33m" +
       "j//r9J0H++Dz/huF8chFwjj0Ia84DgpBQJhf/OgpHXz4kjp4Ghzv3z/2/efo" +
       "4EfO0UF++g+O/F3uyQqx77G+/kx/J+xznYL9sUvCboHjQ3vYHzoH9se/Gtiv" +
       "Cgt7AU7XNYqhTR42HVIgX9oA/1nujDpPEf6nlyT82lLpwNll3f2eQfinvio9" +
       "gZAyjCnNvTjsZ0PTAWPV9X7uDHr3o1+wfuSPfnI3L3Y6xj+VWfvgC9/zN9c+" +
       "/MLBidnIN940IXiyzG5GsoD4igLn5oa2e8ZTihLYH37q3b/wiXd/YIfq0Rvn" +
       "1vpu4vzkf/irz1376Bd/7YzJm6umG5/Syacu6V6fAm5S3mW9el6M+Itn66R0" +
       "1DM5UmiYruD5A1fViqv/8hSsX3oJsPah6+73DFj/+hawHt7B4kxjGZ8L7LMv" +
       "AZi6B6aeA+zXbwHskR0w1ItjzzkX2edeAjJtj0w7B9lv3ALZQztklKafL7Hf" +
       "fAm49D2u88L7374FrvtBQwGu6VxMv/MSMO2HHLvfMzB98VZWn3cWHds03HNh" +
       "/f5LgLXcw1qeA+sPb6XCfOqc0C40+j+6Ja6dA7sCQpQ7a9ea1yr5///zclHW" +
       "a1a28uzhUH4KOiTQnTy7spuHHdPDRRyQz2Vc272iOQWy/1WDBH72wePKKM81" +
       "nv/eP/jI5/7+G78AfOawdOc6nz0BzvXEE0dJ/gLs/Z/8gdff/8IXv7eYcwSd" +
       "zPS9z33pvXmtf3E5qk/kVPliQp+Sopgupgk19YjtvzjB59Nx6Q7buw228dd9" +
       "hICjQefwj6oq3XpnskHcZC5UOG1N03gH69Y688XMG22gYUe3FpymoTg17I/H" +
       "qGtVmGYkjagky1iO7HhU3MfatJJMCZ0ewySXuKGJGqt+VeuZYySpLHndnm63" +
       "gl2zrLiluikznSku0iT9KUNNGFleQ824qdZEV62IEqJLnhMjy2QNJRC0bjSb" +
       "ENRMXK4xVwfmzBmj5pRxyq62xAc1tcX5fG9ID9VtwksLpEOXcYQfYRW/XVur" +
       "06Yrlic9nwgmiqsM+4lTCaxgFhvKwFpPkr5jJ+R2sV54POc5Y080SZpHuOmi" +
       "xVpzJ6hxI0oig6hiVRszut81kAE3JCa8v1g0rIAjVw2zY5lTtNIVOqOOU2HC" +
       "kWwEHF9djpqhNqBkZS7Lgr2gHakqToc83k7j1SRBh9isOsY6VUlJrLG6sFS8" +
       "up6ORn6UDYdOXQ2naUSODGmdBaTR4qKqDrkGFGMSF/UVkmvOycXIbZuOE3qV" +
       "EOa7fiQiNakf0vX+KBlWpigdxzNnSDoLMuQ6vbFk9EVBIqu8R9SmfQvCa+4E" +
       "XzbEgLTqgwDt2NuMDvmJiWMoO10OV8ykTyOYaoo0iaq2JVOTmYhCLCmlTH+V" +
       "1AJoOuGCpWWO8KRNqDNubFiD1bjS9frLmOtRdJXA5O64MU56PiCzMQOfdJtc" +
       "H5o7Na8CLMVSiTKJuduF0DVwqc2a3bXHRag9dDQfx+1GHxcFeF6x+1aD7Khy" +
       "A7N5NtowSifqD7DNYjtAiYXLDUKiSpgLK5gypiDgvp0YHWAdG27cCAJNJj2E" +
       "ag16E2XDcj5hVCqdsoPB7W6FG6i9UdcQh1joK8vq2KcInzS2K1T2SVQ3Z1M0" +
       "wEy6y/GmiGwzXPKG2iwRvOF0Da1Ho2barDfhdnXDQjiaORhWtXtQje9NYLQX" +
       "TLYk6SkdGB6Q0wCmWX7N6GwydtFOyCobwREVpIwkpEs5LRhKB+soWxKOUlkl" +
       "m5nYi9YEF/h6EnDt6nyKBX0RGa+AAbMpjeDbyXLCMdvauMvSWUsd1BY1MSPZ" +
       "EVSvs4umsLWh9pAhCXsQNKreFnXFybCcbJak53O+wk/T7ZBM+hptJcNlOxZ1" +
       "o+UbUGLgtg5XWjXOJN0xYZNRNNFsZh1BE5RHSb9rdsPlHN7026pYHje6ZtOt" +
       "pONxFBoDf5rKPNsioMTmOjW6serbA9rm54N6aIjd5aAOZx0UcVHKUHuLbae6" +
       "aGFCr+obHQtXu7Rk0R2GW844ekZ6sGTwNK2tpLaClQ2tyaymbc+C5qTu4QHJ" +
       "jERBW235eZndJDLHcNnQTcuNIUe5XQQ12sQknMXLDWfOeltdZky4zOipIDsw" +
       "zHU41yZSvuZATlPQsrYfI+VWLYJmUr3tuewGCVSz7qcMjGpEZwR1Og1EsedQ" +
       "5tXqxMyLOsaIFlCuh9V63MbbDgO1usVNm2W3Wz2QICmGsmosQDWrPDACUbUc" +
       "f1xxcVVa8UuYJmy6x1JkXzS34dBeObO6k3ZdtoJP7N6gScnjBReLQgjDAZpt" +
       "HVFqRMuRBC27nQacbT2kzesugYRwk+moUygYsnVmm3ZFKqXLS62zVPVRMB1l" +
       "jsqRSEMqI+XGtu0Sq60xK8PmAhKHguiLlmcuKzNrIbgBjqhzyic13M2a4w1u" +
       "6qjWUPhVr5VidI0ZrQet/iImlTIzoz1U6Y/rC5/EZ7zDkGXT8ybthYCssGpI" +
       "NJNZZxbVMTj0emFHwLQaDzmZ1TYSD5WZUSB20pnMzJqRkGXbZtZulrc+rtYC" +
       "PpAxDIUqpCz3kVGwjdzQSZkojtB0gxlzcs1yQsPfliEFUhgxHI0X1ixB/SiV" +
       "xxqB2pXBiIV63XpcbjXX81WzbsblrZJGW40Y9DuSMBj1/TJwJeVxZRTY9qpp" +
       "4L15itWMqjBdrxbDdsANp/ioMyGqcTuYBki7EULrUJvWPBoXbNRWWXeCVdcj" +
       "Nh72m3qTCqGxOFtNINxUXTPrhvharyhBWZylSK/mLRuCC9UxK2i1qKzSbaUy" +
       "LNms6me9Or8xiCUxl6rjDLL5jdpsmU3UZ6Z+XIfpljanFh0QRrQhRK4Fqa5p" +
       "iWJWskXWaRK1Nj8JKgrLdpHRcBgQDbSS2VW+vPBsLIbWa302S+ottNpb9Udj" +
       "z9hEtdFmbZC8klF9ZkKZbrM5bkMsW67ZcDBYI6OJRHmTpi8sBl0mSylvqmx4" +
       "pYkLJmJBm8yvABr8bMxPRZiitQGNUUpdVbntBsVVt5mZoAEbFXcVNpmwm6GN" +
       "6opGGG1Zb0FpYG6ZOAUERG1d1mZDIAM45Rl0qjW1rIvXW0SrJm1pog5tQiyZ" +
       "06vybDBZZtsxTAi9bTtYlx1WGCFbsrtSR0OrPYUxIXaEubsI2zW1vSgHW93u" +
       "1LiZ7fazBcPbEbdkDH7j+Rbpm3gti1bsio1ha8Twqm/OmWFNDKeOSzZZh6dW" +
       "RMVd6giw8NpoZHWqaXNDdzTF9dZErV9nJ5lF+1KyScZk1a1i2iiiiWhkVQQL" +
       "w1Qe9ntWa5OScOxFeLyKJI/kG3RzidTqXS+WytWg0apW6Wofqw74RU/C0jmS" +
       "aYk1lZctLN5Oe93RpodpEuTEQ6ROV03NrDh402IoCcHrIjJMLQleejMmqW4G" +
       "NcbHOqYk04w7MuYNNyBsF1sHSI+oE37c66he1MtGa7PT4xfDRodJcIFrDgzK" +
       "G1Yy1OSHTjCJxr0JPaG6blxj4FAqr9qiqMwI2TalySgMlh6tkV1OtDaYNZ+E" +
       "OLcMZtyivAoa2kqutxOl248sge/GyqJBInUe6SxWNO55gVTlUyOq2pBK6BWV" +
       "mLAIPeDcDGaqsT9SGMeMZYNaJTytKFw/k/sRwUx6hNjSuiCU86lqX6zKEbGp" +
       "uXU8rvTGCMwsYJRkWIel5czvMM0qx5H4FqnUe9iKWUsDZ61aai0O5fq6joTN" +
       "paHVlj13W6nDxCpbbTZwP00HU09WW9imDW82w/58tOVTpargjLHAmXVClCd4" +
       "3BRq7TllmkTL47uUw0AS0dW7iNAUjY0dNpaIvJEmW6cmlzMR7sgWJGw79dSd" +
       "ERKD1LAtSohGZhnkChmj0jiyo0bZ9VW6l1b0cTYtU2MuDOM+X9eQBYgnRqm4" +
       "WEUbEu8FGNM3hkyKTrTpmOpX+/0pVCWxAVme28bY2aA+FfZNYZqu2luVEEae" +
       "K8ioGs4IpBrFAZKparuh4oTj1ZDuMqxBjUY71XViEzRCTHaWXJxNxS3SnM+3" +
       "oNdrSckW6VYzo59ZfY2ygVGx9R6LNNoVSDTDjhKnFj6JcBl0lkZ1sZLsgKk6" +
       "c2Ge6jMcHszbE5cK601n1amRmw42XZEWD5qbT3cXSWyPeGYyIUIxTZar/qxb" +
       "nTnsqubEzWqz2eYiJFRitWqos7LWjjWNsTlIUhmlPncrxno4WytqhGdxG9kw" +
       "NdLeIBIp8ijUDMMyNEogop352HaNS1aquZXNaI7NZ5ZhzSR2ldbKjm3z5TYs" +
       "jOuVygbOuKQ8Yel1u63MVd0fKuOWL7TkKTtx7CGSii1RE7ccLtenprzWtmh9" +
       "ZpSXbquc9JrdLlzBiHp3FcxacxyBKBBd6RER9vS+3wrKxAzmpLIdqPKsI88R" +
       "eKbqcROjhGxUHw8cCEnb5bhmDaZUBx90R1qFgC1/y6Vex0Mmva0wRAahNw+J" +
       "gKBYHhm461Ef9LgjMuV7oAcaLJghF3uzri5iXVVZ0+1VQy671KSh9YyykCKz" +
       "/nYwr3CJ7uiWnVAGUoWVpO/35BbVqAQoOpw1nXY4WQK/RUwVHeuChptYlXIV" +
       "5RsW6jdXwEp7cW2wSaWuBzc7hh7qK6HeAuMNcxStJCNKvRBNGxA9Y51yq51R" +
       "FVKH8GyQrFWzWsPXULbsZHhcB33u1F/2kXpZZfRuz0r1BLHDqdhs4o2B4S4q" +
       "UKsRMfpoBVU2XoS0I4eassQ2S8RVi2q7rsbCdWhAT0SxG/SIrrmREEqYQzSk" +
       "V4TlRtBCjJhyHXdjjldBtCDafY5lyTSN55BfYesjXDMSO3JbI1hP5Go807aY" +
       "PBdUn3cCJHGrgTrkG+R6S+C8oWBWDZ9zXDmrjpajmk02wlVXFgJbizZTGI6y" +
       "CmZG0SJRpPJ2sknaTSlJnd6kr1Uz0+NAI4WSiG4PagMsBgLImtvqSB3hthjR" +
       "AxnVm25QXvdpFZ00B1Ban1VV3ZS0RI4Hac3tkLI6n0gjYKtTyO+Nxio2rjFJ" +
       "sJQbkpM4Gb/ohEjanEot1E/WW4vVeWmtjjS7VpPbPOwaqlRL5mDYq7ScWboh" +
       "0Oai1VTaTby3hMv4aNPWHSRYzL35tKdOhGltRSYkJQZ2AIbRJmoSisBsR0ZT" +
       "wKHput4BY+A5htcpJKusWCdZwFbFhFzQLrq1sM6rpL8NWQLKep6Hy5wDUTAy" +
       "X04MlQJi0Gt1oZGrCBnrrWa/069DGcNYJkeqPI+P0Tne8Uf4mqAtQsUSu71p" +
       "KsnMX6j99QbZzoKRzczgpYNEHom4WSxi6+VE13grldL+tI/NPJavty1Hg/hg" +
       "IcltJJL0UReMFbUyN7PgtmjWCRJedaIGR4rLhdWy+8uF5qFtL2R1araQBzi3" +
       "GqeVcaxK1rAV1LK4UbGwtTyNmgtuzQ9DZMuZlKdE1Gba6c37CgZGPghdHjuN" +
       "iOhmHIKE4lIRKpZNo8JEnLghIsrrWa3NVaYDj/RlEERnBiPCEDZrmITb7RGu" +
       "03YIYbMQ2S3K2z1pjsqEjk0tejpVUxx2");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "dz1yK9mcsK5CG7f8/MetmtmbSvkLh90TqZdHG/u45BS/1+WVP3Wrp52Q6fQC" +
       "mYp5Mo5L9wDFKtZuG/ZJI+VuVywgRr+62gO96XsZtyWW4KivUy8gqOfJdTAk" +
       "MV0z7vI8G3rFlwuLLXHF6Psk3XfdBt3HSjuDv5rs6SaXpXvh9GtwY//uX8A5" +
       "9zQHVlx6hSNZGmp7ipX3K4dN+Y1nNuX8awPXbsxbSMS+DYm8Kr+Ye6lP7CXy" +
       "iZfHAM6afDh4uqD+ngvEkm/oO9gCseSzikd7I4uyx3yzy/DdxKXHz9s3n3/l" +
       "6/GbPs+5+6Sk8lMvPnTPa16c/Mfi23BHn328lyrdoye2ffKjTCfO7/JDTTcL" +
       "idxbpA/6Ba8PnPV5gpN7+0E4U/zm+A/evyv0PXHpNecUikt3yUcvYw7zfwhE" +
       "Kqfzg3qL35P5PgLCyuN8oKrdycks3x+XroIs+ekL/qFVwrf8OkG1dlM/v9n5" +
       "xsdPmN/udfmjt9LiiRffb7zhdXXx3dXDV8sJu/+uxqdeHI6+/SuNj+++iafY" +
       "UpZPUZfuoUp37z7PV1Sav55+5tzaDuu6i3jzXz740/c+d/gq/cEd4OOmcALb" +
       "U2d/gK7v+HHxybjs517zM9/8z178vWLf6v8H2JzNHRBXAAA=");
}
