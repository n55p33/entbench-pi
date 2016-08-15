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
           "77/jd176RnF38T9oJg7O1x0AAA==");
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
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "5/kjG574H8CdhTkXFQAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "VMizP3jg9974W899s6jS/Q+CBkR0ICAAAA==");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "XUgAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "67QdQtgsRHaL8nZPmqMyoWNTi55O1RSH");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
