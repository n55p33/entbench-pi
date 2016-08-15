package org.apache.batik.bridge;
public class SVGTextElementBridge extends org.apache.batik.bridge.AbstractGraphicsNodeBridge implements org.apache.batik.dom.svg.SVGTextContent {
    protected static final java.lang.Integer ZERO = new java.lang.Integer(
      0);
    public static final java.text.AttributedCharacterIterator.Attribute TEXT_COMPOUND_DELIMITER =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        TEXT_COMPOUND_DELIMITER;
    public static final java.text.AttributedCharacterIterator.Attribute
      TEXT_COMPOUND_ID =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        TEXT_COMPOUND_ID;
    public static final java.text.AttributedCharacterIterator.Attribute
      PAINT_INFO =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        PAINT_INFO;
    public static final java.text.AttributedCharacterIterator.Attribute
      ALT_GLYPH_HANDLER =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        ALT_GLYPH_HANDLER;
    public static final java.text.AttributedCharacterIterator.Attribute
      TEXTPATH =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        TEXTPATH;
    public static final java.text.AttributedCharacterIterator.Attribute
      ANCHOR_TYPE =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        ANCHOR_TYPE;
    public static final java.text.AttributedCharacterIterator.Attribute
      GVT_FONT_FAMILIES =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        GVT_FONT_FAMILIES;
    public static final java.text.AttributedCharacterIterator.Attribute
      GVT_FONTS =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        GVT_FONTS;
    public static final java.text.AttributedCharacterIterator.Attribute
      BASELINE_SHIFT =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        BASELINE_SHIFT;
    protected java.text.AttributedString laidoutText;
    protected java.util.WeakHashMap elemTPI = new java.util.WeakHashMap(
      );
    protected boolean usingComplexSVGFont = false;
    public SVGTextElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_TEXT_TAG;
    }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.bridge.SVGTextElementBridge(
                                                            );
    }
    protected org.apache.batik.gvt.TextNode getTextNode() {
        return (org.apache.batik.gvt.TextNode)
                 node;
    }
    public org.apache.batik.gvt.GraphicsNode createGraphicsNode(org.apache.batik.bridge.BridgeContext ctx,
                                                                org.w3c.dom.Element e) {
        org.apache.batik.gvt.TextNode node =
          (org.apache.batik.gvt.TextNode)
            super.
            createGraphicsNode(
              ctx,
              e);
        if (node ==
              null)
            return null;
        associateSVGContext(
          ctx,
          e,
          node);
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
        if (ctx.
              getTextPainter(
                ) !=
              null)
            node.
              setTextPainter(
                ctx.
                  getTextPainter(
                    ));
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
              null)
            node.
              setRenderingHints(
                hints);
        node.
          setLocation(
            getLocation(
              ctx,
              e));
        return node;
    }
    protected org.apache.batik.gvt.GraphicsNode instantiateGraphicsNode() {
        return new org.apache.batik.gvt.TextNode(
          );
    }
    protected java.awt.geom.Point2D getLocation(org.apache.batik.bridge.BridgeContext ctx,
                                                org.w3c.dom.Element e) {
        try {
            org.apache.batik.dom.svg.SVGOMTextPositioningElement te =
              (org.apache.batik.dom.svg.SVGOMTextPositioningElement)
                e;
            org.apache.batik.dom.svg.SVGOMAnimatedLengthList _x =
              (org.apache.batik.dom.svg.SVGOMAnimatedLengthList)
                te.
                getX(
                  );
            _x.
              check(
                );
            org.w3c.dom.svg.SVGLengthList xs =
              _x.
              getAnimVal(
                );
            float x =
              0;
            if (xs.
                  getNumberOfItems(
                    ) >
                  0) {
                x =
                  xs.
                    getItem(
                      0).
                    getValue(
                      );
            }
            org.apache.batik.dom.svg.SVGOMAnimatedLengthList _y =
              (org.apache.batik.dom.svg.SVGOMAnimatedLengthList)
                te.
                getY(
                  );
            _y.
              check(
                );
            org.w3c.dom.svg.SVGLengthList ys =
              _y.
              getAnimVal(
                );
            float y =
              0;
            if (ys.
                  getNumberOfItems(
                    ) >
                  0) {
                y =
                  ys.
                    getItem(
                      0).
                    getValue(
                      );
            }
            return new java.awt.geom.Point2D.Float(
              x,
              y);
        }
        catch (org.apache.batik.dom.svg.LiveAttributeException ex) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              ex);
        }
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
            SVG_TEXT_TAG) ||
          nodeName.
          equals(
            SVG_TSPAN_TAG) ||
          nodeName.
          equals(
            SVG_ALT_GLYPH_TAG) ||
          nodeName.
          equals(
            SVG_A_TAG) ||
          nodeName.
          equals(
            SVG_TEXT_PATH_TAG) ||
          nodeName.
          equals(
            SVG_TREF_TAG);
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
            SVG_TSPAN_TAG) ||
          nodeName.
          equals(
            SVG_ALT_GLYPH_TAG) ||
          nodeName.
          equals(
            SVG_A_TAG) ||
          nodeName.
          equals(
            SVG_TEXT_PATH_TAG) ||
          nodeName.
          equals(
            SVG_TREF_TAG);
    }
    public void buildGraphicsNode(org.apache.batik.bridge.BridgeContext ctx,
                                  org.w3c.dom.Element e,
                                  org.apache.batik.gvt.GraphicsNode node) {
        e.
          normalize(
            );
        computeLaidoutText(
          ctx,
          e,
          node);
        node.
          setComposite(
            org.apache.batik.bridge.CSSUtilities.
              convertOpacity(
                e));
        node.
          setFilter(
            org.apache.batik.bridge.CSSUtilities.
              convertFilter(
                e,
                node,
                ctx));
        node.
          setMask(
            org.apache.batik.bridge.CSSUtilities.
              convertMask(
                e,
                node,
                ctx));
        node.
          setClip(
            org.apache.batik.bridge.CSSUtilities.
              convertClipPath(
                e,
                node,
                ctx));
        node.
          setPointerEventType(
            org.apache.batik.bridge.CSSUtilities.
              convertPointerEvents(
                e));
        initializeDynamicSupport(
          ctx,
          e,
          node);
        if (!ctx.
              isDynamic(
                )) {
            elemTPI.
              clear(
                );
        }
    }
    public boolean isComposite() { return false;
    }
    protected org.w3c.dom.Node getFirstChild(org.w3c.dom.Node n) {
        return n.
          getFirstChild(
            );
    }
    protected org.w3c.dom.Node getNextSibling(org.w3c.dom.Node n) {
        return n.
          getNextSibling(
            );
    }
    protected org.w3c.dom.Node getParentNode(org.w3c.dom.Node n) {
        return n.
          getParentNode(
            );
    }
    protected org.apache.batik.bridge.SVGTextElementBridge.DOMChildNodeRemovedEventListener
      childNodeRemovedEventListener;
    protected class DOMChildNodeRemovedEventListener implements org.w3c.dom.events.EventListener {
        public void handleEvent(org.w3c.dom.events.Event evt) {
            handleDOMChildNodeRemovedEvent(
              (org.w3c.dom.events.MutationEvent)
                evt);
        }
        public DOMChildNodeRemovedEventListener() {
            super(
              );
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
           "Orzj1d3e7ikuqocvGsClLd/ovopbS3rzA8El+oIfejG4qOtaeti1K/oXd71M" +
           "1+5YZ+PMwW350byXu0HUfc1z9vW8Lxvtn2jP5ne5h271BqK4x33mfc8+p40+" +
           "W9m73joSwdX9+ouh4weG0JO3vrAOircvR/2Mr77vXx6cvt1816vo2D5yisnT" +
           "JH938PzXu29Wf30POnvY3bjhvdBJpKsnexoXQz1OQnd6orPx0KH+L+XqfhKI" +
           "uryu/+XNu6Y3t2nhRDvXOdWWO3PSYg/cymIF8vplenrbfAhi6DWm7Gq2XiAV" +
           "gOwxRxTA5XrtWdqRh4avdK8+0T4DLvVKHf8DSd7yat4jAP954IbXlbtXbOoX" +
           "nrt0/v7n+L8uGuWHr8EuMNB5kObt412pY/Pb/VA3rEIxF3Y9Kr/4+WAM3X8L" +
           "xoBj7yaFBB/Ywf9KDF0+DR9D54rf43C/FkMXj+AAqd3kOMjHYugsAMmnz/g3" +
           "6WftmnPpmWNxdT1HFIa695UMdYhyvI+ex2LxuvggbpLdC+Nr6hef6w3f/WLj" +
           "s7s+vmrL28KDzjPQHbtXCoex99gtqR3Qup164qW7v3ThTQdJ4u4dw0cRcYy3" +
           "R27eKCccPy5a29s/vP/33/rbz32naK/9L4YarNLHHwAA");
    }
    protected org.apache.batik.bridge.SVGTextElementBridge.DOMSubtreeModifiedEventListener
      subtreeModifiedEventListener;
    protected class DOMSubtreeModifiedEventListener implements org.w3c.dom.events.EventListener {
        public void handleEvent(org.w3c.dom.events.Event evt) {
            handleDOMSubtreeModifiedEvent(
              (org.w3c.dom.events.MutationEvent)
                evt);
        }
        public DOMSubtreeModifiedEventListener() {
            super(
              );
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
           "w/t+/22//fx3isra/wJ4wiLJwR8AAA==");
    }
    protected void initializeDynamicSupport(org.apache.batik.bridge.BridgeContext ctx,
                                            org.w3c.dom.Element e,
                                            org.apache.batik.gvt.GraphicsNode node) {
        super.
          initializeDynamicSupport(
            ctx,
            e,
            node);
        if (ctx.
              isDynamic(
                )) {
            addTextEventListeners(
              ctx,
              (org.apache.batik.dom.events.NodeEventTarget)
                e);
        }
    }
    protected void addTextEventListeners(org.apache.batik.bridge.BridgeContext ctx,
                                         org.apache.batik.dom.events.NodeEventTarget e) {
        if (childNodeRemovedEventListener ==
              null) {
            childNodeRemovedEventListener =
              new org.apache.batik.bridge.SVGTextElementBridge.DOMChildNodeRemovedEventListener(
                );
        }
        if (subtreeModifiedEventListener ==
              null) {
            subtreeModifiedEventListener =
              new org.apache.batik.bridge.SVGTextElementBridge.DOMSubtreeModifiedEventListener(
                );
        }
        e.
          addEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMNodeRemoved",
            childNodeRemovedEventListener,
            true,
            null);
        ctx.
          storeEventListenerNS(
            e,
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMNodeRemoved",
            childNodeRemovedEventListener,
            true);
        e.
          addEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMSubtreeModified",
            subtreeModifiedEventListener,
            false,
            null);
        ctx.
          storeEventListenerNS(
            e,
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMSubtreeModified",
            subtreeModifiedEventListener,
            false);
    }
    protected void removeTextEventListeners(org.apache.batik.bridge.BridgeContext ctx,
                                            org.apache.batik.dom.events.NodeEventTarget e) {
        e.
          removeEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMNodeRemoved",
            childNodeRemovedEventListener,
            true);
        e.
          removeEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMSubtreeModified",
            subtreeModifiedEventListener,
            false);
    }
    public void dispose() { removeTextEventListeners(
                              ctx,
                              (org.apache.batik.dom.events.NodeEventTarget)
                                e);
                            super.dispose(
                                    ); }
    protected void addContextToChild(org.apache.batik.bridge.BridgeContext ctx,
                                     org.w3c.dom.Element e) {
        if (SVG_NAMESPACE_URI.
              equals(
                e.
                  getNamespaceURI(
                    ))) {
            if (e.
                  getLocalName(
                    ).
                  equals(
                    SVG_TSPAN_TAG)) {
                ((org.apache.batik.dom.svg.SVGOMElement)
                   e).
                  setSVGContext(
                    new org.apache.batik.bridge.SVGTextElementBridge.TspanBridge(
                      ctx,
                      this,
                      e));
            }
            else
                if (e.
                      getLocalName(
                        ).
                      equals(
                        SVG_TEXT_PATH_TAG)) {
                    ((org.apache.batik.dom.svg.SVGOMElement)
                       e).
                      setSVGContext(
                        new org.apache.batik.bridge.SVGTextElementBridge.TextPathBridge(
                          ctx,
                          this,
                          e));
                }
                else
                    if (e.
                          getLocalName(
                            ).
                          equals(
                            SVG_TREF_TAG)) {
                        ((org.apache.batik.dom.svg.SVGOMElement)
                           e).
                          setSVGContext(
                            new org.apache.batik.bridge.SVGTextElementBridge.TRefBridge(
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
            if (e.
                  getLocalName(
                    ).
                  equals(
                    SVG_TSPAN_TAG)) {
                ((org.apache.batik.bridge.SVGTextElementBridge.AbstractTextChildBridgeUpdateHandler)
                   ((org.apache.batik.dom.svg.SVGOMElement)
                      e).
                   getSVGContext(
                     )).
                  dispose(
                    );
            }
            else
                if (e.
                      getLocalName(
                        ).
                      equals(
                        SVG_TEXT_PATH_TAG)) {
                    ((org.apache.batik.bridge.SVGTextElementBridge.AbstractTextChildBridgeUpdateHandler)
                       ((org.apache.batik.dom.svg.SVGOMElement)
                          e).
                       getSVGContext(
                         )).
                      dispose(
                        );
                }
                else
                    if (e.
                          getLocalName(
                            ).
                          equals(
                            SVG_TREF_TAG)) {
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
    public void handleDOMNodeInsertedEvent(org.w3c.dom.events.MutationEvent evt) {
        org.w3c.dom.Node childNode =
          (org.w3c.dom.Node)
            evt.
            getTarget(
              );
        switch (childNode.
                  getNodeType(
                    )) {
            case org.w3c.dom.Node.
                   TEXT_NODE:
            case org.w3c.dom.Node.
                   CDATA_SECTION_NODE:
                laidoutText =
                  null;
                break;
            case org.w3c.dom.Node.
                   ELEMENT_NODE:
                {
                    org.w3c.dom.Element childElement =
                      (org.w3c.dom.Element)
                        childNode;
                    if (isTextChild(
                          childElement)) {
                        addContextToChild(
                          ctx,
                          childElement);
                        laidoutText =
                          null;
                    }
                    break;
                }
        }
        if (laidoutText ==
              null) {
            computeLaidoutText(
              ctx,
              e,
              getTextNode(
                ));
        }
    }
    public void handleDOMChildNodeRemovedEvent(org.w3c.dom.events.MutationEvent evt) {
        org.w3c.dom.Node childNode =
          (org.w3c.dom.Node)
            evt.
            getTarget(
              );
        switch (childNode.
                  getNodeType(
                    )) {
            case org.w3c.dom.Node.
                   TEXT_NODE:
            case org.w3c.dom.Node.
                   CDATA_SECTION_NODE:
                if (isParentDisplayed(
                      childNode)) {
                    laidoutText =
                      null;
                }
                break;
            case org.w3c.dom.Node.
                   ELEMENT_NODE:
                {
                    org.w3c.dom.Element childElt =
                      (org.w3c.dom.Element)
                        childNode;
                    if (isTextChild(
                          childElt)) {
                        laidoutText =
                          null;
                        removeContextFromChild(
                          ctx,
                          childElt);
                    }
                    break;
                }
            default:
        }
    }
    public void handleDOMSubtreeModifiedEvent(org.w3c.dom.events.MutationEvent evt) {
        if (laidoutText ==
              null) {
            computeLaidoutText(
              ctx,
              e,
              getTextNode(
                ));
        }
    }
    public void handleDOMCharacterDataModified(org.w3c.dom.events.MutationEvent evt) {
        org.w3c.dom.Node childNode =
          (org.w3c.dom.Node)
            evt.
            getTarget(
              );
        if (isParentDisplayed(
              childNode)) {
            laidoutText =
              null;
        }
    }
    protected boolean isParentDisplayed(org.w3c.dom.Node childNode) {
        org.w3c.dom.Node parentNode =
          getParentNode(
            childNode);
        return isTextElement(
                 (org.w3c.dom.Element)
                   parentNode);
    }
    protected void computeLaidoutText(org.apache.batik.bridge.BridgeContext ctx,
                                      org.w3c.dom.Element e,
                                      org.apache.batik.gvt.GraphicsNode node) {
        org.apache.batik.gvt.TextNode tn =
          (org.apache.batik.gvt.TextNode)
            node;
        elemTPI.
          clear(
            );
        java.text.AttributedString as =
          buildAttributedString(
            ctx,
            e);
        if (as ==
              null) {
            tn.
              setAttributedCharacterIterator(
                null);
            return;
        }
        addGlyphPositionAttributes(
          as,
          e,
          ctx);
        if (ctx.
              isDynamic(
                )) {
            laidoutText =
              new java.text.AttributedString(
                as.
                  getIterator(
                    ));
        }
        tn.
          setAttributedCharacterIterator(
            as.
              getIterator(
                ));
        org.apache.batik.gvt.text.TextPaintInfo pi =
          new org.apache.batik.gvt.text.TextPaintInfo(
          );
        setBaseTextPaintInfo(
          pi,
          e,
          node,
          ctx);
        setDecorationTextPaintInfo(
          pi,
          e);
        addPaintAttributes(
          as,
          e,
          tn,
          pi,
          ctx);
        if (usingComplexSVGFont) {
            tn.
              setAttributedCharacterIterator(
                as.
                  getIterator(
                    ));
        }
        if (ctx.
              isDynamic(
                )) {
            checkBBoxChange(
              );
        }
    }
    private boolean hasNewACI;
    private org.w3c.dom.Element cssProceedElement;
    public void handleAnimatedAttributeChanged(org.apache.batik.dom.svg.AnimatedLiveAttributeValue alav) {
        if (alav.
              getNamespaceURI(
                ) ==
              null) {
            java.lang.String ln =
              alav.
              getLocalName(
                );
            if (ln.
                  equals(
                    SVG_X_ATTRIBUTE) ||
                  ln.
                  equals(
                    SVG_Y_ATTRIBUTE) ||
                  ln.
                  equals(
                    SVG_DX_ATTRIBUTE) ||
                  ln.
                  equals(
                    SVG_DY_ATTRIBUTE) ||
                  ln.
                  equals(
                    SVG_ROTATE_ATTRIBUTE) ||
                  ln.
                  equals(
                    SVG_TEXT_LENGTH_ATTRIBUTE) ||
                  ln.
                  equals(
                    SVG_LENGTH_ADJUST_ATTRIBUTE)) {
                char c =
                  ln.
                  charAt(
                    0);
                if (c ==
                      'x' ||
                      c ==
                      'y') {
                    getTextNode(
                      ).
                      setLocation(
                        getLocation(
                          ctx,
                          e));
                }
                computeLaidoutText(
                  ctx,
                  e,
                  getTextNode(
                    ));
                return;
            }
        }
        super.
          handleAnimatedAttributeChanged(
            alav);
    }
    public void handleCSSEngineEvent(org.apache.batik.css.engine.CSSEngineEvent evt) {
        hasNewACI =
          false;
        int[] properties =
          evt.
          getProperties(
            );
        for (int i =
               0;
             i <
               properties.
                 length;
             ++i) {
            switch (properties[i]) {
                case org.apache.batik.css.engine.SVGCSSEngine.
                       BASELINE_SHIFT_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       DIRECTION_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       DISPLAY_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       FONT_FAMILY_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       FONT_SIZE_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       FONT_STRETCH_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       FONT_STYLE_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       FONT_WEIGHT_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       GLYPH_ORIENTATION_HORIZONTAL_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       GLYPH_ORIENTATION_VERTICAL_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       KERNING_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       LETTER_SPACING_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       TEXT_ANCHOR_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       UNICODE_BIDI_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       WORD_SPACING_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       WRITING_MODE_INDEX:
                    {
                        if (!hasNewACI) {
                            hasNewACI =
                              true;
                            computeLaidoutText(
                              ctx,
                              e,
                              getTextNode(
                                ));
                        }
                        break;
                    }
            }
        }
        cssProceedElement =
          evt.
            getElement(
              );
        super.
          handleCSSEngineEvent(
            evt);
        cssProceedElement =
          null;
    }
    protected void handleCSSPropertyChanged(int property) {
        switch (property) {
            case org.apache.batik.css.engine.SVGCSSEngine.
                   FILL_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   FILL_OPACITY_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   STROKE_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   STROKE_OPACITY_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   STROKE_WIDTH_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   STROKE_LINECAP_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   STROKE_LINEJOIN_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   STROKE_MITERLIMIT_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   STROKE_DASHARRAY_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   STROKE_DASHOFFSET_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   TEXT_DECORATION_INDEX:
                rebuildACI(
                  );
                break;
            case org.apache.batik.css.engine.SVGCSSEngine.
                   VISIBILITY_INDEX:
                rebuildACI(
                  );
                super.
                  handleCSSPropertyChanged(
                    property);
                break;
            case org.apache.batik.css.engine.SVGCSSEngine.
                   TEXT_RENDERING_INDEX:
                {
                    java.awt.RenderingHints hints =
                      node.
                      getRenderingHints(
                        );
                    hints =
                      org.apache.batik.bridge.CSSUtilities.
                        convertTextRendering(
                          e,
                          hints);
                    if (hints !=
                          null) {
                        node.
                          setRenderingHints(
                            hints);
                    }
                    break;
                }
            case org.apache.batik.css.engine.SVGCSSEngine.
                   COLOR_RENDERING_INDEX:
                {
                    java.awt.RenderingHints hints =
                      node.
                      getRenderingHints(
                        );
                    hints =
                      org.apache.batik.bridge.CSSUtilities.
                        convertColorRendering(
                          e,
                          hints);
                    if (hints !=
                          null) {
                        node.
                          setRenderingHints(
                            hints);
                    }
                    break;
                }
            default:
                super.
                  handleCSSPropertyChanged(
                    property);
        }
    }
    protected void rebuildACI() { if (hasNewACI)
                                      return;
                                  org.apache.batik.gvt.TextNode textNode =
                                    getTextNode(
                                      );
                                  if (textNode.
                                        getAttributedCharacterIterator(
                                          ) ==
                                        null)
                                      return;
                                  org.apache.batik.gvt.text.TextPaintInfo pi;
                                  org.apache.batik.gvt.text.TextPaintInfo oldPI;
                                  if (cssProceedElement ==
                                        e) {
                                      pi =
                                        new org.apache.batik.gvt.text.TextPaintInfo(
                                          );
                                      setBaseTextPaintInfo(
                                        pi,
                                        e,
                                        node,
                                        ctx);
                                      setDecorationTextPaintInfo(
                                        pi,
                                        e);
                                      oldPI =
                                        (org.apache.batik.gvt.text.TextPaintInfo)
                                          elemTPI.
                                          get(
                                            e);
                                  }
                                  else {
                                      org.apache.batik.gvt.text.TextPaintInfo parentPI;
                                      parentPI =
                                        getParentTextPaintInfo(
                                          cssProceedElement);
                                      pi =
                                        getTextPaintInfo(
                                          cssProceedElement,
                                          textNode,
                                          parentPI,
                                          ctx);
                                      oldPI =
                                        (org.apache.batik.gvt.text.TextPaintInfo)
                                          elemTPI.
                                          get(
                                            cssProceedElement);
                                  }
                                  if (oldPI ==
                                        null)
                                      return;
                                  textNode.
                                    swapTextPaintInfo(
                                      pi,
                                      oldPI);
                                  if (usingComplexSVGFont)
                                      textNode.
                                        setAttributedCharacterIterator(
                                          textNode.
                                            getAttributedCharacterIterator(
                                              ));
    }
    int getElementStartIndex(org.w3c.dom.Element element) {
        org.apache.batik.gvt.text.TextPaintInfo tpi =
          (org.apache.batik.gvt.text.TextPaintInfo)
            elemTPI.
            get(
              element);
        if (tpi ==
              null)
            return -1;
        return tpi.
                 startChar;
    }
    int getElementEndIndex(org.w3c.dom.Element element) {
        org.apache.batik.gvt.text.TextPaintInfo tpi =
          (org.apache.batik.gvt.text.TextPaintInfo)
            elemTPI.
            get(
              element);
        if (tpi ==
              null)
            return -1;
        return tpi.
                 endChar;
    }
    protected java.text.AttributedString buildAttributedString(org.apache.batik.bridge.BridgeContext ctx,
                                                               org.w3c.dom.Element element) {
        org.apache.batik.bridge.SVGTextElementBridge.AttributedStringBuffer asb =
          new org.apache.batik.bridge.SVGTextElementBridge.AttributedStringBuffer(
          );
        fillAttributedStringBuffer(
          ctx,
          element,
          true,
          null,
          null,
          null,
          asb);
        return asb.
          toAttributedString(
            );
    }
    protected int endLimit;
    protected void fillAttributedStringBuffer(org.apache.batik.bridge.BridgeContext ctx,
                                              org.w3c.dom.Element element,
                                              boolean top,
                                              org.apache.batik.gvt.text.TextPath textPath,
                                              java.lang.Integer bidiLevel,
                                              java.util.Map initialAttributes,
                                              org.apache.batik.bridge.SVGTextElementBridge.AttributedStringBuffer asb) {
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
              0;
        }
        if (preserve) {
            endLimit =
              asb.
                length(
                  );
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
            textPath,
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
                            SVG_TSPAN_TAG) ||
                          ln.
                          equals(
                            SVG_ALT_GLYPH_TAG)) {
                        int before =
                          asb.
                            count;
                        fillAttributedStringBuffer(
                          ctx,
                          nodeElement,
                          false,
                          textPath,
                          subBidiLevel,
                          initialAttributes,
                          asb);
                        if (asb.
                              count !=
                              before) {
                            initialAttributes =
                              null;
                        }
                    }
                    else
                        if (ln.
                              equals(
                                SVG_TEXT_PATH_TAG)) {
                            org.apache.batik.bridge.SVGTextPathElementBridge textPathBridge =
                              (org.apache.batik.bridge.SVGTextPathElementBridge)
                                ctx.
                                getBridge(
                                  nodeElement);
                            org.apache.batik.gvt.text.TextPath newTextPath =
                              textPathBridge.
                              createTextPath(
                                ctx,
                                nodeElement);
                            if (newTextPath !=
                                  null) {
                                int before =
                                  asb.
                                    count;
                                fillAttributedStringBuffer(
                                  ctx,
                                  nodeElement,
                                  false,
                                  newTextPath,
                                  subBidiLevel,
                                  initialAttributes,
                                  asb);
                                if (asb.
                                      count !=
                                      before) {
                                    initialAttributes =
                                      null;
                                }
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
                                      initialAttributes ==
                                      null
                                      ? new java.util.HashMap(
                                      )
                                      : new java.util.HashMap(
                                      initialAttributes);
                                    getAttributeMap(
                                      ctx,
                                      nodeElement,
                                      textPath,
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
                            else
                                if (ln.
                                      equals(
                                        SVG_A_TAG)) {
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
                                    org.w3c.dom.events.EventListener l;
                                    l =
                                      new org.apache.batik.bridge.SVGAElementBridge.AnchorListener(
                                        ua,
                                        ch);
                                    target.
                                      addEventListenerNS(
                                        org.apache.batik.util.XMLConstants.
                                          XML_EVENTS_NAMESPACE_URI,
                                        SVG_EVENT_CLICK,
                                        l,
                                        false,
                                        null);
                                    ctx.
                                      storeEventListenerNS(
                                        target,
                                        org.apache.batik.util.XMLConstants.
                                          XML_EVENTS_NAMESPACE_URI,
                                        SVG_EVENT_CLICK,
                                        l,
                                        false);
                                    int before =
                                      asb.
                                        count;
                                    fillAttributedStringBuffer(
                                      ctx,
                                      nodeElement,
                                      false,
                                      textPath,
                                      subBidiLevel,
                                      initialAttributes,
                                      asb);
                                    if (asb.
                                          count !=
                                          before) {
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
    protected java.lang.String normalizeString(java.lang.String s,
                                               boolean preserve,
                                               boolean stripfirst) {
        java.lang.StringBuffer sb =
          new java.lang.StringBuffer(
          s.
            length(
              ));
        if (preserve) {
            for (int i =
                   0;
                 i <
                   s.
                   length(
                     );
                 i++) {
                char c =
                  s.
                  charAt(
                    i);
                switch (c) {
                    case 10:
                    case 13:
                    case '\t':
                        sb.
                          append(
                            ' ');
                        break;
                    default:
                        sb.
                          append(
                            c);
                }
            }
            return sb.
              toString(
                );
        }
        int idx =
          0;
        if (stripfirst) {
            loop: while (idx <
                           s.
                           length(
                             )) {
                switch (s.
                          charAt(
                            idx)) {
                    default:
                        break loop;
                    case 10:
                    case 13:
                    case ' ':
                    case '\t':
                        idx++;
                }
            }
        }
        boolean space =
          false;
        for (int i =
               idx;
             i <
               s.
               length(
                 );
             i++) {
            char c =
              s.
              charAt(
                i);
            switch (c) {
                case 10:
                case 13:
                    break;
                case ' ':
                case '\t':
                    if (!space) {
                        sb.
                          append(
                            ' ');
                        space =
                          true;
                    }
                    break;
                default:
                    sb.
                      append(
                        c);
                    space =
                      false;
            }
        }
        return sb.
          toString(
            );
    }
    protected static class AttributedStringBuffer {
        protected java.util.List strings;
        protected java.util.List attributes;
        protected int count;
        protected int length;
        public AttributedStringBuffer() {
            super(
              );
            strings =
              new java.util.ArrayList(
                );
            attributes =
              new java.util.ArrayList(
                );
            count =
              0;
            length =
              0;
        }
        public boolean isEmpty() { return count ==
                                     0; }
        public int length() { return length;
        }
        public void append(java.lang.String s,
                           java.util.Map m) {
            if (s.
                  length(
                    ) ==
                  0)
                return;
            strings.
              add(
                s);
            attributes.
              add(
                m);
            count++;
            length +=
              s.
                length(
                  );
        }
        public int getLastChar() { if (count ==
                                         0) {
                                       return -1;
                                   }
                                   java.lang.String s =
                                     (java.lang.String)
                                       strings.
                                       get(
                                         count -
                                           1);
                                   return s.
                                     charAt(
                                       s.
                                         length(
                                           ) -
                                         1);
        }
        public void stripFirst() { java.lang.String s =
                                     (java.lang.String)
                                       strings.
                                       get(
                                         0);
                                   if (s.
                                         charAt(
                                           s.
                                             length(
                                               ) -
                                             1) !=
                                         ' ')
                                       return;
                                   length--;
                                   if (s.
                                         length(
                                           ) ==
                                         1) {
                                       attributes.
                                         remove(
                                           0);
                                       strings.
                                         remove(
                                           0);
                                       count--;
                                       return;
                                   }
                                   strings.
                                     set(
                                       0,
                                       s.
                                         substring(
                                           1));
        }
        public void stripLast() { java.lang.String s =
                                    (java.lang.String)
                                      strings.
                                      get(
                                        count -
                                          1);
                                  if (s.charAt(
                                          s.
                                            length(
                                              ) -
                                            1) !=
                                        ' ')
                                      return;
                                  length--;
                                  if (s.length(
                                          ) ==
                                        1) {
                                      attributes.
                                        remove(
                                          --count);
                                      strings.
                                        remove(
                                          count);
                                      return;
                                  }
                                  strings.
                                    set(
                                      count -
                                        1,
                                      s.
                                        substring(
                                          0,
                                          s.
                                            length(
                                              ) -
                                            1));
        }
        public java.text.AttributedString toAttributedString() {
            switch (count) {
                case 0:
                    return null;
                case 1:
                    return new java.text.AttributedString(
                      (java.lang.String)
                        strings.
                        get(
                          0),
                      (java.util.Map)
                        attributes.
                        get(
                          0));
            }
            java.lang.StringBuffer sb =
              new java.lang.StringBuffer(
              strings.
                size(
                  ) *
                5);
            java.util.Iterator it =
              strings.
              iterator(
                );
            while (it.
                     hasNext(
                       )) {
                sb.
                  append(
                    (java.lang.String)
                      it.
                      next(
                        ));
            }
            java.text.AttributedString result =
              new java.text.AttributedString(
              sb.
                toString(
                  ));
            java.util.Iterator sit =
              strings.
              iterator(
                );
            java.util.Iterator ait =
              attributes.
              iterator(
                );
            int idx =
              0;
            while (sit.
                     hasNext(
                       )) {
                java.lang.String s =
                  (java.lang.String)
                    sit.
                    next(
                      );
                int nidx =
                  idx +
                  s.
                  length(
                    );
                java.util.Map m =
                  (java.util.Map)
                    ait.
                    next(
                      );
                java.util.Iterator kit =
                  m.
                  keySet(
                    ).
                  iterator(
                    );
                java.util.Iterator vit =
                  m.
                  values(
                    ).
                  iterator(
                    );
                while (kit.
                         hasNext(
                           )) {
                    java.text.AttributedCharacterIterator.Attribute attr =
                      (java.text.AttributedCharacterIterator.Attribute)
                        kit.
                        next(
                          );
                    java.lang.Object val =
                      vit.
                      next(
                        );
                    result.
                      addAttribute(
                        attr,
                        val,
                        idx,
                        nidx);
                }
                idx =
                  nidx;
            }
            return result;
        }
        public java.lang.String toString() {
            switch (count) {
                case 0:
                    return "";
                case 1:
                    return (java.lang.String)
                             strings.
                             get(
                               0);
            }
            java.lang.StringBuffer sb =
              new java.lang.StringBuffer(
              strings.
                size(
                  ) *
                5);
            java.util.Iterator it =
              strings.
              iterator(
                );
            while (it.
                     hasNext(
                       )) {
                sb.
                  append(
                    (java.lang.String)
                      it.
                      next(
                        ));
            }
            return sb.
              toString(
                );
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
           "vvLK8VF6tp0e3qj44ssj+idfa/3S/laY");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("Ysu7XTHKVQq6sr+gdpzivfueox2NdZl833cf+fWHnjvKRR/ZM3xiz6d4e/ru" +
           "V7DK3Km4LbH7zcd/40d/+eWvl+ei/w8wR8lNCy4AAA==");
    }
    protected boolean nodeAncestorOf(org.w3c.dom.Node node1,
                                     org.w3c.dom.Node node2) {
        if (node2 ==
              null ||
              node1 ==
              null) {
            return false;
        }
        org.w3c.dom.Node parent =
          getParentNode(
            node2);
        while (parent !=
                 null &&
                 parent !=
                 node1) {
            parent =
              getParentNode(
                parent);
        }
        return parent ==
          node1;
    }
    protected void addGlyphPositionAttributes(java.text.AttributedString as,
                                              org.w3c.dom.Element element,
                                              org.apache.batik.bridge.BridgeContext ctx) {
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
        if (element.
              getLocalName(
                ).
              equals(
                SVG_TEXT_PATH_TAG)) {
            addChildGlyphPositionAttributes(
              as,
              element,
              ctx);
            return;
        }
        int firstChar =
          getElementStartIndex(
            element);
        if (firstChar ==
              -1)
            return;
        int lastChar =
          getElementEndIndex(
            element);
        if (!(element instanceof org.w3c.dom.svg.SVGTextPositioningElement)) {
            addChildGlyphPositionAttributes(
              as,
              element,
              ctx);
            return;
        }
        org.w3c.dom.svg.SVGTextPositioningElement te =
          (org.w3c.dom.svg.SVGTextPositioningElement)
            element;
        try {
            org.apache.batik.dom.svg.SVGOMAnimatedLengthList _x =
              (org.apache.batik.dom.svg.SVGOMAnimatedLengthList)
                te.
                getX(
                  );
            _x.
              check(
                );
            org.apache.batik.dom.svg.SVGOMAnimatedLengthList _y =
              (org.apache.batik.dom.svg.SVGOMAnimatedLengthList)
                te.
                getY(
                  );
            _y.
              check(
                );
            org.apache.batik.dom.svg.SVGOMAnimatedLengthList _dx =
              (org.apache.batik.dom.svg.SVGOMAnimatedLengthList)
                te.
                getDx(
                  );
            _dx.
              check(
                );
            org.apache.batik.dom.svg.SVGOMAnimatedLengthList _dy =
              (org.apache.batik.dom.svg.SVGOMAnimatedLengthList)
                te.
                getDy(
                  );
            _dy.
              check(
                );
            org.apache.batik.dom.svg.SVGOMAnimatedNumberList _rotate =
              (org.apache.batik.dom.svg.SVGOMAnimatedNumberList)
                te.
                getRotate(
                  );
            _rotate.
              check(
                );
            org.w3c.dom.svg.SVGLengthList xs =
              _x.
              getAnimVal(
                );
            org.w3c.dom.svg.SVGLengthList ys =
              _y.
              getAnimVal(
                );
            org.w3c.dom.svg.SVGLengthList dxs =
              _dx.
              getAnimVal(
                );
            org.w3c.dom.svg.SVGLengthList dys =
              _dy.
              getAnimVal(
                );
            org.w3c.dom.svg.SVGNumberList rs =
              _rotate.
              getAnimVal(
                );
            int len;
            len =
              xs.
                getNumberOfItems(
                  );
            for (int i =
                   0;
                 i <
                   len &&
                   firstChar +
                   i <=
                   lastChar;
                 i++) {
                as.
                  addAttribute(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      X,
                    new java.lang.Float(
                      xs.
                        getItem(
                          i).
                        getValue(
                          )),
                    firstChar +
                      i,
                    firstChar +
                      i +
                      1);
            }
            len =
              ys.
                getNumberOfItems(
                  );
            for (int i =
                   0;
                 i <
                   len &&
                   firstChar +
                   i <=
                   lastChar;
                 i++) {
                as.
                  addAttribute(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      Y,
                    new java.lang.Float(
                      ys.
                        getItem(
                          i).
                        getValue(
                          )),
                    firstChar +
                      i,
                    firstChar +
                      i +
                      1);
            }
            len =
              dxs.
                getNumberOfItems(
                  );
            for (int i =
                   0;
                 i <
                   len &&
                   firstChar +
                   i <=
                   lastChar;
                 i++) {
                as.
                  addAttribute(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      DX,
                    new java.lang.Float(
                      dxs.
                        getItem(
                          i).
                        getValue(
                          )),
                    firstChar +
                      i,
                    firstChar +
                      i +
                      1);
            }
            len =
              dys.
                getNumberOfItems(
                  );
            for (int i =
                   0;
                 i <
                   len &&
                   firstChar +
                   i <=
                   lastChar;
                 i++) {
                as.
                  addAttribute(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      DY,
                    new java.lang.Float(
                      dys.
                        getItem(
                          i).
                        getValue(
                          )),
                    firstChar +
                      i,
                    firstChar +
                      i +
                      1);
            }
            len =
              rs.
                getNumberOfItems(
                  );
            if (len ==
                  1) {
                java.lang.Float rad =
                  new java.lang.Float(
                  java.lang.Math.
                    toRadians(
                      rs.
                        getItem(
                          0).
                        getValue(
                          )));
                as.
                  addAttribute(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      ROTATION,
                    rad,
                    firstChar,
                    lastChar +
                      1);
            }
            else
                if (len >
                      1) {
                    for (int i =
                           0;
                         i <
                           len &&
                           firstChar +
                           i <=
                           lastChar;
                         i++) {
                        java.lang.Float rad =
                          new java.lang.Float(
                          java.lang.Math.
                            toRadians(
                              rs.
                                getItem(
                                  i).
                                getValue(
                                  )));
                        as.
                          addAttribute(
                            org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                              ROTATION,
                            rad,
                            firstChar +
                              i,
                            firstChar +
                              i +
                              1);
                    }
                }
            addChildGlyphPositionAttributes(
              as,
              element,
              ctx);
        }
        catch (org.apache.batik.dom.svg.LiveAttributeException ex) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              ex);
        }
    }
    protected void addChildGlyphPositionAttributes(java.text.AttributedString as,
                                                   org.w3c.dom.Element element,
                                                   org.apache.batik.bridge.BridgeContext ctx) {
        for (org.w3c.dom.Node child =
               getFirstChild(
                 element);
             child !=
               null;
             child =
               getNextSibling(
                 child)) {
            if (child.
                  getNodeType(
                    ) !=
                  org.w3c.dom.Node.
                    ELEMENT_NODE)
                continue;
            org.w3c.dom.Element childElement =
              (org.w3c.dom.Element)
                child;
            if (isTextChild(
                  childElement)) {
                addGlyphPositionAttributes(
                  as,
                  childElement,
                  ctx);
            }
        }
    }
    protected void addPaintAttributes(java.text.AttributedString as,
                                      org.w3c.dom.Element element,
                                      org.apache.batik.gvt.TextNode node,
                                      org.apache.batik.gvt.text.TextPaintInfo pi,
                                      org.apache.batik.bridge.BridgeContext ctx) {
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
        java.lang.Object o =
          elemTPI.
          get(
            element);
        if (o !=
              null) {
            node.
              swapTextPaintInfo(
                pi,
                (org.apache.batik.gvt.text.TextPaintInfo)
                  o);
        }
        addChildPaintAttributes(
          as,
          element,
          node,
          pi,
          ctx);
    }
    protected void addChildPaintAttributes(java.text.AttributedString as,
                                           org.w3c.dom.Element element,
                                           org.apache.batik.gvt.TextNode node,
                                           org.apache.batik.gvt.text.TextPaintInfo parentPI,
                                           org.apache.batik.bridge.BridgeContext ctx) {
        for (org.w3c.dom.Node child =
               getFirstChild(
                 element);
             child !=
               null;
             child =
               getNextSibling(
                 child)) {
            if (child.
                  getNodeType(
                    ) !=
                  org.w3c.dom.Node.
                    ELEMENT_NODE) {
                continue;
            }
            org.w3c.dom.Element childElement =
              (org.w3c.dom.Element)
                child;
            if (isTextChild(
                  childElement)) {
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
    protected java.util.List getFontList(org.apache.batik.bridge.BridgeContext ctx,
                                         org.w3c.dom.Element element,
                                         java.util.Map result) {
        result.
          put(
            TEXT_COMPOUND_ID,
            new java.lang.ref.SoftReference(
              element));
        java.lang.Float fsFloat =
          org.apache.batik.bridge.TextUtilities.
          convertFontSize(
            element);
        float fontSize =
          fsFloat.
          floatValue(
            );
        result.
          put(
            java.awt.font.TextAttribute.
              SIZE,
            fsFloat);
        result.
          put(
            java.awt.font.TextAttribute.
              WIDTH,
            org.apache.batik.bridge.TextUtilities.
              convertFontStretch(
                element));
        result.
          put(
            java.awt.font.TextAttribute.
              POSTURE,
            org.apache.batik.bridge.TextUtilities.
              convertFontStyle(
                element));
        result.
          put(
            java.awt.font.TextAttribute.
              WEIGHT,
            org.apache.batik.bridge.TextUtilities.
              convertFontWeight(
                element));
        org.apache.batik.css.engine.value.Value v =
          org.apache.batik.bridge.CSSUtilities.
          getComputedStyle(
            element,
            org.apache.batik.css.engine.SVGCSSEngine.
              FONT_WEIGHT_INDEX);
        java.lang.String fontWeightString =
          v.
          getCssText(
            );
        java.lang.String fontStyleString =
          org.apache.batik.bridge.CSSUtilities.
          getComputedStyle(
            element,
            org.apache.batik.css.engine.SVGCSSEngine.
              FONT_STYLE_INDEX).
          getStringValue(
            );
        result.
          put(
            TEXT_COMPOUND_DELIMITER,
            element);
        org.apache.batik.css.engine.value.Value val =
          org.apache.batik.bridge.CSSUtilities.
          getComputedStyle(
            element,
            org.apache.batik.css.engine.SVGCSSEngine.
              FONT_FAMILY_INDEX);
        java.util.List fontFamilyList =
          new java.util.ArrayList(
          );
        java.util.List fontList =
          new java.util.ArrayList(
          );
        int len =
          val.
          getLength(
            );
        for (int i =
               0;
             i <
               len;
             i++) {
            org.apache.batik.css.engine.value.Value it =
              val.
              item(
                i);
            java.lang.String fontFamilyName =
              it.
              getStringValue(
                );
            org.apache.batik.gvt.font.GVTFontFamily fontFamily;
            fontFamily =
              org.apache.batik.bridge.SVGFontUtilities.
                getFontFamily(
                  element,
                  ctx,
                  fontFamilyName,
                  fontWeightString,
                  fontStyleString);
            if (fontFamily ==
                  null)
                continue;
            if (fontFamily instanceof org.apache.batik.gvt.font.UnresolvedFontFamily) {
                fontFamily =
                  org.apache.batik.gvt.font.FontFamilyResolver.
                    resolve(
                      (org.apache.batik.gvt.font.UnresolvedFontFamily)
                        fontFamily);
                if (fontFamily ==
                      null)
                    continue;
            }
            fontFamilyList.
              add(
                fontFamily);
            if (fontFamily instanceof org.apache.batik.bridge.SVGFontFamily) {
                org.apache.batik.bridge.SVGFontFamily svgFF =
                  (org.apache.batik.bridge.SVGFontFamily)
                    fontFamily;
                if (svgFF.
                      isComplex(
                        )) {
                    usingComplexSVGFont =
                      true;
                }
            }
            org.apache.batik.gvt.font.GVTFont ft =
              fontFamily.
              deriveFont(
                fontSize,
                result);
            fontList.
              add(
                ft);
        }
        result.
          put(
            GVT_FONT_FAMILIES,
            fontFamilyList);
        if (!ctx.
              isDynamic(
                )) {
            result.
              remove(
                TEXT_COMPOUND_DELIMITER);
        }
        return fontList;
    }
    protected java.util.Map getAttributeMap(org.apache.batik.bridge.BridgeContext ctx,
                                            org.w3c.dom.Element element,
                                            org.apache.batik.gvt.text.TextPath textPath,
                                            java.lang.Integer bidiLevel,
                                            java.util.Map result) {
        org.w3c.dom.svg.SVGTextContentElement tce =
          null;
        if (element instanceof org.w3c.dom.svg.SVGTextContentElement) {
            tce =
              (org.w3c.dom.svg.SVGTextContentElement)
                element;
        }
        java.util.Map inheritMap =
          null;
        java.lang.String s;
        if (SVG_NAMESPACE_URI.
              equals(
                element.
                  getNamespaceURI(
                    )) &&
              element.
              getLocalName(
                ).
              equals(
                SVG_ALT_GLYPH_TAG)) {
            result.
              put(
                ALT_GLYPH_HANDLER,
                new org.apache.batik.bridge.SVGAltGlyphHandler(
                  ctx,
                  element));
        }
        org.apache.batik.gvt.text.TextPaintInfo pi =
          new org.apache.batik.gvt.text.TextPaintInfo(
          );
        pi.
          visible =
          true;
        pi.
          fillPaint =
          java.awt.Color.
            black;
        result.
          put(
            PAINT_INFO,
            pi);
        elemTPI.
          put(
            element,
            pi);
        if (textPath !=
              null) {
            result.
              put(
                TEXTPATH,
                textPath);
        }
        org.apache.batik.gvt.TextNode.Anchor a =
          org.apache.batik.bridge.TextUtilities.
          convertTextAnchor(
            element);
        result.
          put(
            ANCHOR_TYPE,
            a);
        java.util.List fontList =
          getFontList(
            ctx,
            element,
            result);
        result.
          put(
            GVT_FONTS,
            fontList);
        java.lang.Object bs =
          org.apache.batik.bridge.TextUtilities.
          convertBaselineShift(
            element);
        if (bs !=
              null) {
            result.
              put(
                BASELINE_SHIFT,
                bs);
        }
        org.apache.batik.css.engine.value.Value val =
          org.apache.batik.bridge.CSSUtilities.
          getComputedStyle(
            element,
            org.apache.batik.css.engine.SVGCSSEngine.
              UNICODE_BIDI_INDEX);
        s =
          val.
            getStringValue(
              );
        if (s.
              charAt(
                0) ==
              'n') {
            if (bidiLevel !=
                  null)
                result.
                  put(
                    java.awt.font.TextAttribute.
                      BIDI_EMBEDDING,
                    bidiLevel);
        }
        else {
            val =
              org.apache.batik.bridge.CSSUtilities.
                getComputedStyle(
                  element,
                  org.apache.batik.css.engine.SVGCSSEngine.
                    DIRECTION_INDEX);
            java.lang.String rs =
              val.
              getStringValue(
                );
            int cbidi =
              0;
            if (bidiLevel !=
                  null)
                cbidi =
                  bidiLevel.
                    intValue(
                      );
            if (cbidi <
                  0)
                cbidi =
                  -cbidi;
            switch (rs.
                      charAt(
                        0)) {
                case 'l':
                    result.
                      put(
                        java.awt.font.TextAttribute.
                          RUN_DIRECTION,
                        java.awt.font.TextAttribute.
                          RUN_DIRECTION_LTR);
                    if ((cbidi &
                           1) ==
                          1)
                        cbidi++;
                    else
                        cbidi +=
                          2;
                    break;
                case 'r':
                    result.
                      put(
                        java.awt.font.TextAttribute.
                          RUN_DIRECTION,
                        java.awt.font.TextAttribute.
                          RUN_DIRECTION_RTL);
                    if ((cbidi &
                           1) ==
                          1)
                        cbidi +=
                          2;
                    else
                        cbidi++;
                    break;
            }
            switch (s.
                      charAt(
                        0)) {
                case 'b':
                    cbidi =
                      -cbidi;
                    break;
            }
            result.
              put(
                java.awt.font.TextAttribute.
                  BIDI_EMBEDDING,
                new java.lang.Integer(
                  cbidi));
        }
        val =
          org.apache.batik.bridge.CSSUtilities.
            getComputedStyle(
              element,
              org.apache.batik.css.engine.SVGCSSEngine.
                WRITING_MODE_INDEX);
        s =
          val.
            getStringValue(
              );
        switch (s.
                  charAt(
                    0)) {
            case 'l':
                result.
                  put(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      WRITING_MODE,
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      WRITING_MODE_LTR);
                break;
            case 'r':
                result.
                  put(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      WRITING_MODE,
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      WRITING_MODE_RTL);
                break;
            case 't':
                result.
                  put(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      WRITING_MODE,
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      WRITING_MODE_TTB);
                break;
        }
        val =
          org.apache.batik.bridge.CSSUtilities.
            getComputedStyle(
              element,
              org.apache.batik.css.engine.SVGCSSEngine.
                GLYPH_ORIENTATION_VERTICAL_INDEX);
        int primitiveType =
          val.
          getPrimitiveType(
            );
        switch (primitiveType) {
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_IDENT:
                result.
                  put(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      VERTICAL_ORIENTATION,
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      ORIENTATION_AUTO);
                break;
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_DEG:
                result.
                  put(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      VERTICAL_ORIENTATION,
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      ORIENTATION_ANGLE);
                result.
                  put(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      VERTICAL_ORIENTATION_ANGLE,
                    new java.lang.Float(
                      val.
                        getFloatValue(
                          )));
                break;
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_RAD:
                result.
                  put(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      VERTICAL_ORIENTATION,
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      ORIENTATION_ANGLE);
                result.
                  put(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      VERTICAL_ORIENTATION_ANGLE,
                    new java.lang.Float(
                      java.lang.Math.
                        toDegrees(
                          val.
                            getFloatValue(
                              ))));
                break;
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_GRAD:
                result.
                  put(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      VERTICAL_ORIENTATION,
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      ORIENTATION_ANGLE);
                result.
                  put(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      VERTICAL_ORIENTATION_ANGLE,
                    new java.lang.Float(
                      val.
                        getFloatValue(
                          ) *
                        9 /
                        5));
                break;
            default:
                throw new java.lang.IllegalStateException(
                  "unexpected primitiveType (V):" +
                  primitiveType);
        }
        val =
          org.apache.batik.bridge.CSSUtilities.
            getComputedStyle(
              element,
              org.apache.batik.css.engine.SVGCSSEngine.
                GLYPH_ORIENTATION_HORIZONTAL_INDEX);
        primitiveType =
          val.
            getPrimitiveType(
              );
        switch (primitiveType) {
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_DEG:
                result.
                  put(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      HORIZONTAL_ORIENTATION_ANGLE,
                    new java.lang.Float(
                      val.
                        getFloatValue(
                          )));
                break;
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_RAD:
                result.
                  put(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      HORIZONTAL_ORIENTATION_ANGLE,
                    new java.lang.Float(
                      java.lang.Math.
                        toDegrees(
                          val.
                            getFloatValue(
                              ))));
                break;
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_GRAD:
                result.
                  put(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      HORIZONTAL_ORIENTATION_ANGLE,
                    new java.lang.Float(
                      val.
                        getFloatValue(
                          ) *
                        9 /
                        5));
                break;
            default:
                throw new java.lang.IllegalStateException(
                  "unexpected primitiveType (H):" +
                  primitiveType);
        }
        java.lang.Float sp =
          org.apache.batik.bridge.TextUtilities.
          convertLetterSpacing(
            element);
        if (sp !=
              null) {
            result.
              put(
                org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                  LETTER_SPACING,
                sp);
            result.
              put(
                org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                  CUSTOM_SPACING,
                java.lang.Boolean.
                  TRUE);
        }
        sp =
          org.apache.batik.bridge.TextUtilities.
            convertWordSpacing(
              element);
        if (sp !=
              null) {
            result.
              put(
                org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                  WORD_SPACING,
                sp);
            result.
              put(
                org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                  CUSTOM_SPACING,
                java.lang.Boolean.
                  TRUE);
        }
        sp =
          org.apache.batik.bridge.TextUtilities.
            convertKerning(
              element);
        if (sp !=
              null) {
            result.
              put(
                org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                  KERNING,
                sp);
            result.
              put(
                org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                  CUSTOM_SPACING,
                java.lang.Boolean.
                  TRUE);
        }
        if (tce ==
              null) {
            return inheritMap;
        }
        try {
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength textLength =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                tce.
                getTextLength(
                  );
            if (textLength.
                  isSpecified(
                    )) {
                if (inheritMap ==
                      null) {
                    inheritMap =
                      new java.util.HashMap(
                        );
                }
                java.lang.Object value =
                  new java.lang.Float(
                  textLength.
                    getCheckedValue(
                      ));
                result.
                  put(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      BBOX_WIDTH,
                    value);
                inheritMap.
                  put(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      BBOX_WIDTH,
                    value);
                org.apache.batik.dom.svg.SVGOMAnimatedEnumeration _lengthAdjust =
                  (org.apache.batik.dom.svg.SVGOMAnimatedEnumeration)
                    tce.
                    getLengthAdjust(
                      );
                if (_lengthAdjust.
                      getCheckedVal(
                        ) ==
                      org.w3c.dom.svg.SVGTextContentElement.
                        LENGTHADJUST_SPACINGANDGLYPHS) {
                    result.
                      put(
                        org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                          LENGTH_ADJUST,
                        org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                          ADJUST_ALL);
                    inheritMap.
                      put(
                        org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                          LENGTH_ADJUST,
                        org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                          ADJUST_ALL);
                }
                else {
                    result.
                      put(
                        org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                          LENGTH_ADJUST,
                        org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                          ADJUST_SPACING);
                    inheritMap.
                      put(
                        org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                          LENGTH_ADJUST,
                        org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                          ADJUST_SPACING);
                    result.
                      put(
                        org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                          CUSTOM_SPACING,
                        java.lang.Boolean.
                          TRUE);
                    inheritMap.
                      put(
                        org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                          CUSTOM_SPACING,
                        java.lang.Boolean.
                          TRUE);
                }
            }
        }
        catch (org.apache.batik.dom.svg.LiveAttributeException ex) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              ex);
        }
        return inheritMap;
    }
    protected org.apache.batik.gvt.text.TextPaintInfo getParentTextPaintInfo(org.w3c.dom.Element child) {
        org.w3c.dom.Node parent =
          getParentNode(
            child);
        while (parent !=
                 null) {
            org.apache.batik.gvt.text.TextPaintInfo tpi =
              (org.apache.batik.gvt.text.TextPaintInfo)
                elemTPI.
                get(
                  parent);
            if (tpi !=
                  null)
                return tpi;
            parent =
              getParentNode(
                parent);
        }
        return null;
    }
    protected org.apache.batik.gvt.text.TextPaintInfo getTextPaintInfo(org.w3c.dom.Element element,
                                                                       org.apache.batik.gvt.GraphicsNode node,
                                                                       org.apache.batik.gvt.text.TextPaintInfo parentTPI,
                                                                       org.apache.batik.bridge.BridgeContext ctx) {
        org.apache.batik.bridge.CSSUtilities.
          getComputedStyle(
            element,
            org.apache.batik.css.engine.SVGCSSEngine.
              TEXT_DECORATION_INDEX);
        org.apache.batik.gvt.text.TextPaintInfo pi =
          new org.apache.batik.gvt.text.TextPaintInfo(
          parentTPI);
        org.apache.batik.css.engine.StyleMap sm =
          ((org.apache.batik.css.engine.CSSStylableElement)
             element).
          getComputedStyleMap(
            null);
        if (sm.
              isNullCascaded(
                org.apache.batik.css.engine.SVGCSSEngine.
                  TEXT_DECORATION_INDEX) &&
              sm.
              isNullCascaded(
                org.apache.batik.css.engine.SVGCSSEngine.
                  FILL_INDEX) &&
              sm.
              isNullCascaded(
                org.apache.batik.css.engine.SVGCSSEngine.
                  STROKE_INDEX) &&
              sm.
              isNullCascaded(
                org.apache.batik.css.engine.SVGCSSEngine.
                  STROKE_WIDTH_INDEX) &&
              sm.
              isNullCascaded(
                org.apache.batik.css.engine.SVGCSSEngine.
                  OPACITY_INDEX)) {
            return pi;
        }
        setBaseTextPaintInfo(
          pi,
          element,
          node,
          ctx);
        if (!sm.
              isNullCascaded(
                org.apache.batik.css.engine.SVGCSSEngine.
                  TEXT_DECORATION_INDEX))
            setDecorationTextPaintInfo(
              pi,
              element);
        return pi;
    }
    public void setBaseTextPaintInfo(org.apache.batik.gvt.text.TextPaintInfo pi,
                                     org.w3c.dom.Element element,
                                     org.apache.batik.gvt.GraphicsNode node,
                                     org.apache.batik.bridge.BridgeContext ctx) {
        if (!element.
              getLocalName(
                ).
              equals(
                SVG_TEXT_TAG))
            pi.
              composite =
              org.apache.batik.bridge.CSSUtilities.
                convertOpacity(
                  element);
        else
            pi.
              composite =
              java.awt.AlphaComposite.
                SrcOver;
        pi.
          visible =
          org.apache.batik.bridge.CSSUtilities.
            convertVisibility(
              element);
        pi.
          fillPaint =
          org.apache.batik.bridge.PaintServer.
            convertFillPaint(
              element,
              node,
              ctx);
        pi.
          strokePaint =
          org.apache.batik.bridge.PaintServer.
            convertStrokePaint(
              element,
              node,
              ctx);
        pi.
          strokeStroke =
          org.apache.batik.bridge.PaintServer.
            convertStroke(
              element);
    }
    public void setDecorationTextPaintInfo(org.apache.batik.gvt.text.TextPaintInfo pi,
                                           org.w3c.dom.Element element) {
        org.apache.batik.css.engine.value.Value val =
          org.apache.batik.bridge.CSSUtilities.
          getComputedStyle(
            element,
            org.apache.batik.css.engine.SVGCSSEngine.
              TEXT_DECORATION_INDEX);
        switch (val.
                  getCssValueType(
                    )) {
            case org.w3c.dom.css.CSSValue.
                   CSS_VALUE_LIST:
                org.apache.batik.css.engine.value.ListValue lst =
                  (org.apache.batik.css.engine.value.ListValue)
                    val;
                int len =
                  lst.
                  getLength(
                    );
                for (int i =
                       0;
                     i <
                       len;
                     i++) {
                    org.apache.batik.css.engine.value.Value v =
                      lst.
                      item(
                        i);
                    java.lang.String s =
                      v.
                      getStringValue(
                        );
                    switch (s.
                              charAt(
                                0)) {
                        case 'u':
                            if (pi.
                                  fillPaint !=
                                  null) {
                                pi.
                                  underlinePaint =
                                  pi.
                                    fillPaint;
                            }
                            if (pi.
                                  strokePaint !=
                                  null) {
                                pi.
                                  underlineStrokePaint =
                                  pi.
                                    strokePaint;
                            }
                            if (pi.
                                  strokeStroke !=
                                  null) {
                                pi.
                                  underlineStroke =
                                  pi.
                                    strokeStroke;
                            }
                            break;
                        case 'o':
                            if (pi.
                                  fillPaint !=
                                  null) {
                                pi.
                                  overlinePaint =
                                  pi.
                                    fillPaint;
                            }
                            if (pi.
                                  strokePaint !=
                                  null) {
                                pi.
                                  overlineStrokePaint =
                                  pi.
                                    strokePaint;
                            }
                            if (pi.
                                  strokeStroke !=
                                  null) {
                                pi.
                                  overlineStroke =
                                  pi.
                                    strokeStroke;
                            }
                            break;
                        case 'l':
                            if (pi.
                                  fillPaint !=
                                  null) {
                                pi.
                                  strikethroughPaint =
                                  pi.
                                    fillPaint;
                            }
                            if (pi.
                                  strokePaint !=
                                  null) {
                                pi.
                                  strikethroughStrokePaint =
                                  pi.
                                    strokePaint;
                            }
                            if (pi.
                                  strokeStroke !=
                                  null) {
                                pi.
                                  strikethroughStroke =
                                  pi.
                                    strokeStroke;
                            }
                            break;
                    }
                }
                break;
            default:
                pi.
                  underlinePaint =
                  null;
                pi.
                  underlineStrokePaint =
                  null;
                pi.
                  underlineStroke =
                  null;
                pi.
                  overlinePaint =
                  null;
                pi.
                  overlineStrokePaint =
                  null;
                pi.
                  overlineStroke =
                  null;
                pi.
                  strikethroughPaint =
                  null;
                pi.
                  strikethroughStrokePaint =
                  null;
                pi.
                  strikethroughStroke =
                  null;
                break;
        }
    }
    public abstract class AbstractTextChildSVGContext extends org.apache.batik.bridge.AnimatableSVGBridge {
        protected org.apache.batik.bridge.SVGTextElementBridge
          textBridge;
        public AbstractTextChildSVGContext(org.apache.batik.bridge.BridgeContext ctx,
                                           org.apache.batik.bridge.SVGTextElementBridge parent,
                                           org.w3c.dom.Element e) {
            super(
              );
            this.
              ctx =
              ctx;
            this.
              textBridge =
              parent;
            this.
              e =
              e;
        }
        public java.lang.String getNamespaceURI() {
            return null;
        }
        public java.lang.String getLocalName() {
            return null;
        }
        public org.apache.batik.bridge.Bridge getInstance() {
            return null;
        }
        public org.apache.batik.bridge.SVGTextElementBridge getTextBridge() {
            return textBridge;
        }
        public float getPixelUnitToMillimeter() {
            return ctx.
              getUserAgent(
                ).
              getPixelUnitToMillimeter(
                );
        }
        public float getPixelToMM() { return getPixelUnitToMillimeter(
                                               );
        }
        public java.awt.geom.Rectangle2D getBBox() {
            return null;
        }
        public java.awt.geom.AffineTransform getCTM() {
            return null;
        }
        public java.awt.geom.AffineTransform getGlobalTransform() {
            return null;
        }
        public java.awt.geom.AffineTransform getScreenTransform() {
            return null;
        }
        public void setScreenTransform(java.awt.geom.AffineTransform at) {
            return;
        }
        public float getViewportWidth() {
            return ctx.
              getBlockWidth(
                e);
        }
        public float getViewportHeight() {
            return ctx.
              getBlockHeight(
                e);
        }
        public float getFontSize() { return org.apache.batik.bridge.CSSUtilities.
                                       getComputedStyle(
                                         e,
                                         org.apache.batik.css.engine.SVGCSSEngine.
                                           FONT_SIZE_INDEX).
                                       getFloatValue(
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
           "1/kjPt3wX7xgZgA9JgAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "YkivtXEXG+QYHsHtqII1ZWRaE5MqX1G6UbWp0m5j26GrWxoxhoNFc5Ayg1TN" +
           "u/EqacyIeDwMtXmtljG9mNKWi1BhmanFYdrUmOBzd7sw8r43WcbzftVY1OdY" +
           "Y7aIUKPH1iqdSp0Ies2VyeQByU7YmezT4rSlqgzVaXG7kaFHkSX7tQ1sUn3G" +
           "CcnBqr/0Im3hjZOMdwh4tx4jjiQSpDxoWzKlS2zeX6xmIdPIevXeespZzcnI" +
           "Vkd6nYHJzWjL+6PdAF4koU+MV4rYaRqIuEsjYqPw5HJrZtO5NJYnId/vKA2m" +
           "Q3nYcDMaOGN/EIvIth1YvrvORUTu8UtkbXjU0nfEqGotEaLXqZAIrTFjF9k1" +
           "6cZkgVTr3SGzmtts1x/kWR7iooNG5ppstSSy3+uZNUZwIhDPtnFdc0KxHaAI" +
           "OYsrItvSnWpLy9JGS17XU5jaADRIQlTns247zUcMkWcbpd91kY2tzzY1ZNRQ" +
           "NEEc1OSZ2MVkJZVlhusO/DkWITZrpr0lwbnWmI1heLbhhqhLzXi1IS23iDpx" +
           "Z+J84SfkFOsglrWx/Brb6Zj2Tgnq7qq/oVqjibKa5s5Cm4uxVOnNqaRV29W2" +
           "7GKqyo25pIr1aNC1hYDi1SgkukicoJHUqlZgu2qZCcZI1mKby5sNgbVd1Ml1" +
           "Xm7CNirh9HCnztVaWGcUTuNHO7vVaBuqFguKlw0rsa6sfHjrDie2htXJGqXu" +
           "eMXf0hauesM+S+SjXeL1trg1JFxnMkbR0JmEjMt2LYJyKtIWwdHBTG2umZqR" +
           "u8t1w6p5Tt+0B+tBVW93NV1W2krUbGs1aUPCIzNGsglni91pZjRk2veUth6i" +
           "03CwbnfXM0L3VHtOIKnTkGb0YD6u7BgEsSOC42wscPvJmGRWk77eTKhAXJtq" +
           "c143635ziLQzlMtNrZqSCZlOoziYtpujhtvktAaRTwfBOPBzfb2ZNtTajtfl" +
           "rKZ41iT0UatbaadVK9loS3eiIpV16O9qjfY4GLoh4vKrFsnwmj/fRII/6o/7" +
           "GbFW+n7WCU0Y7XRNfqcRg9moZfT7tV0P6WhUotdh2HdhZt6sE9XVggbrVMcY" +
           "K95mWrEHaNvpDDroZByKY7HZmuC1XOsLlgBvo7q3qUYCEw0FrZYQlVp/Gca9" +
           "UR9nFnrsSRw1qY/tidFIx1N5UNMqdA1fdZJci+VB1TdDDOF2JMLVtPa8rnZn" +
           "a2zo7KRlOw7zWjfpYI0JPFszjmKx60EuBr6UVOsihXRHK9/AW+3IVjUPZ6VF" +
           "tzF11QRVeKo/MB2mDsujrbv2EsZFUDmgG4OBvpzEFN33DRQhaN9y1q021w9l" +
           "h++m9WQtDcUc63AZrFpcNrPNTa2taji7JmcJka+WHAy3bbohcJuNYrCsJK6U" +
           "WmA4VrK1vZ0y6inDqmZYSOQ2065tLxo6IvGMoLIoLaGTdNyHheqgnyaU1ZSQ" +
           "EQNvYMQVGoacIbipUNN5RUYc3G65SFPhjKgi9SZ+e4cHlmXWhyOi7nPsGh0t" +
           "DUacdv0xY+PSCq3Ybhy1cEWBZ8imjoStzmRNSItkp8LtTBXQ6ZJv5K0q1Vcp" +
           "h2u5Hid3ycVsSdOhazUq4rISNibMVMW76lBEjZz3q50GUiFrqcvP7H5F7jV7" +
           "sd63Km1db2cWN+0R/DATVvbAQVSKdUIsmDjraBdyM63SqreneM4QXZGeqBU6" +
           "dRuK07Cc5cjh1nOzo9OmmzQr/HjSIxrbwTiYiY1a1VhLacXC9KwnEAnn+M3l" +
           "CM74jjSX8I3SbTTmXFsAPpITQl+as82VqhKNtM80ugSJ0vJcGNn1SYhK7lZe" +
           "THkU5epZv1KrzMhGlix62xZhCxJbX4zkbNKuSVNp6gnd5TJoVnvsQJ7Ou7NV" +
           "jtQEwWB1LelVaHYjbrx5ZVBJO3JdbvMsNurFIIvYcdZASZEcW3ZYQnNoZo43" +
           "R1u0mydBK0unFN5vDTfbbgcOGFvpo/VG35pOmkg9Nyq7nJ1yUtirhHp3ODec" +
           "ysK1h20EQVR9gKWVds6w4/6iDbct2xlvd1TNgTd9QvGArS93jXmTj0iO7Um5" +
           "acSotsZFZdyy65zdnm/mIIK1zTqj57ZJeh7qjiaR1vebKrmW4riJpoHfXm2D" +
           "ljqKAtKchn3RCxdiCl7NVplPxoSx0YGV9qpGXUTDgDemam82bTbzBeLxOeeN" +
           "ut35qBoTq/GoPcKNcDSOXeBVYB5hvOkPeL3tuHOKq6op2qcXPJdj2NRp4gN9" +
           "Zjm1Yh/Cnwe9wG9F3NrpV+pIvZ/TQt/DEnkl+v5sl/coa4k7It3PRg3N6Qwn" +
           "YWWEN6fr1SDvoUTObPv8NOK7bWnGa+ONJvUzvJhjlXPEfqVqsBHaoyadiTlp" +
           "18fzea25o6fLqYtZynDi9Sd03OYNj2jNRtpkjksWPiMAB50F6f1k6NgAx9jK" +
           "KsIGn1XBywSwIBCvupjjbdZqr8M0x1hMj2uyZ3RIUsJtTazUSbveE1WlK2D9" +
           "ZLkKpbkzsTsNjOxvOwqm6MqAiM2pks27EwEVQM65q68JsqGPenVGiDBjUM1z" +
           "adGIfK6zZB0L94LOjlmlPalCaiE26q6MkBsMB+vUlNHUd5aF7jB2GExqa0zk" +
           "60YPLOqLxaSlW/NVpRkIRKWSIN2tFFGdcEzoXTqt18UUIbY1gqzhtictUL1H" +
           "pSt+HeUNdjHyTDxrJgNX02dbGZuNUNYbobzM8Tvg082qy8VirU4LVKc+UOIY" +
           "72pq2FoSbg5XMSc3Fo6Pmk3RIZP2grYobJPbgTpXQoR2s10cS4vtjLFimA3i" +
           "DhK1e3Pg+5oQaR660dy6MhA0djTcilHCe2GH6OorcwmSb2IiRJw2bdNzPcHh" +
           "qrZldx1YGrudcXO9mTeJkbetDPA5rNFUoo0muGyzmTPuOelI5YVFS11SqrqR" +
           "t9gGk8jWdjSVtUqHyzOBVdpCKkuWPkLoMVicFDJp8aQDNJ2Tjp+HdduEWaLV" +
           "aijtLbOsSaE+D4erCTPs2YSVu62WpqGbzYhpqk0pVexamOvjXMpjf4VEmcoa" +
           "bWJleHxjzmAgE6D6fBNZ8FpgbOkAtTgFRqbO1qaVYCTWpw1h2XW0dc7BkZul" +
           "IZ4Lm/5Yt+uYvlzmlV6UougERmbeblZhDLsC0vjlxhhtkwQmY3i3JaubYS1s" +
           "bHoS2dwIk6nrtKoiQIRWOlKDaVkMaVCpPEqFKSs0eJ7AfXasIlLA1kYWqQyN" +
           "2XARM+1qI0qnvBfnYtNt0i0slpS6sAo3Va87G6oW1mE7doqLG3fNm+xA1Ybb" +
           "cT1LM3qWVQUhM6vYNKtT6CIaGEDXtkHPER9trTd8BfBAavDS5VJkq7SzuTbH" +
           "UGqOYcUWxvK17SI9Um6YXT8udr1yr1p6Dbsn2a0HPH+4UXdBPzwgOz6fKPeG" +
           "Hzt9/njyfOJ41xgqtoueut0RcblV9KkPvPyKOf507fzhbrudQvcfntwf83kY" +
           "sHnh9ntiTHk8frwF/Psf+O9XxHcv3vcaztWeOSXkaZa/ynzmDwdvN/7Reeie" +
           "6xvCNx3c39jpxRu3gS/GVrqOffGGzeCnrqv1iUJdbwPq/PqhWr9+67OtW+8E" +
           "l9O1t4ozTjJ+9oy2nyuKn0yhS3MrZYHUSagb1pQnS4M6tqWf+mE7cSf5lhXv" +
           "vxHi8wDaNw8hfvPuQ/yFM9r+YVH8fAo9BCDSgaF77OHsnMD34TvF9xzA9Z1D" +
           "fN+5+/h+6Yy2TxbFx1PodQDfkREebZ0/ffbh2rECfvEOFHC1qKwB4N89VMB3" +
           "774CfvWMtn9WFJ9KodcDBYg3nmocA/z0HQB8vKh8FwD2/UOA37/7AD9/Rttv" +
           "FsXnUuhJAJBzMsub+k4qBozjec7KSg9jpn4i6FvFGYsX6OmxAv75nSoAmPiF" +
           "+/Z99793VwH/7oy23yuKf7134VIBADxT1P32Mb5X7wDfm4tKEKIuXDrEd+nu" +
           "4/tPZ7T9UVF8IYUeAPi63SA7ct83ledQ+jY9mFvB6oC3DODdc8+q949xf/EO" +
           "cD9TVILV58KVQ9xX7j7uL5/R9tWi+FOw9APcPZE5gv3UjbAx23Z8S4x1Pynu" +
           "jhxD/7M7hQ6C1oWrh9Cv3n3o3zyj7X8UxZ+n0KMA+sALZrp3HWDR8rVjlN+4" +
           "GyjfdYjyXXcf5V+f0fY3RfGdPUrBiC3Lvx3K/3kHKEtv/VGArnWIsnV3UJ47" +
           "JvhaQXDu3ttDPXd/UfkDADW5CeqtwvO9m8Axr8M/B91pdC68+D2H8N9z1yf5" +
           "3GNntD1eFA+n0GUwyZJjbcMgTmXH3N9ePI7Q5y7dKca3A2yDQ4yDu4/xmTPa" +
           "niuKK+DV6wTGoeXMF+kpkG++U5DPAnDsIUj27oOsnNH2rqJ4+z6TJAI/FZzc" +
           "OgXvR14LvCyF3nzGVcuCvA5e8Z686cr3");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("/pqy8RuvXLrwxlem/6W8cXj9KvGDNHTBXnveybs2J57vD2PLdko9PLi/eROW" +
           "4Bop9MbbZMNgAZpdz4fPIXv6NjDo0/Qgqyp/T9L9aApdPKYDrPYPJ0l+PIXu" +
           "ASTF47vDo0WucrvUHPOdlZ4Wd/GAqva5bHau7PXkSbMpo+ajP2w6TryQv/WG" +
           "N+nyNv7RW+96fx//mvHZVyj2/d9ufXp/V9Lw9DwvuFygoQf21zZLpsWb83O3" +
           "5XbE6/7hO7738OcefNvRK/7De4GPTfiEbM/c+mIivgrT8iph/ltv/Jc/9iuv" +
           "fLm8f/N/AR/cj2ImMQAA");
    }
    protected abstract class AbstractTextChildBridgeUpdateHandler extends org.apache.batik.bridge.SVGTextElementBridge.AbstractTextChildSVGContext implements org.apache.batik.bridge.BridgeUpdateHandler {
        protected AbstractTextChildBridgeUpdateHandler(org.apache.batik.bridge.BridgeContext ctx,
                                                       org.apache.batik.bridge.SVGTextElementBridge parent,
                                                       org.w3c.dom.Element e) {
            super(
              ctx,
              parent,
              e);
        }
        public void handleDOMAttrModifiedEvent(org.w3c.dom.events.MutationEvent evt) {
            
        }
        public void handleDOMNodeInsertedEvent(org.w3c.dom.events.MutationEvent evt) {
            textBridge.
              handleDOMNodeInsertedEvent(
                evt);
        }
        public void handleDOMNodeRemovedEvent(org.w3c.dom.events.MutationEvent evt) {
            
        }
        public void handleDOMCharacterDataModified(org.w3c.dom.events.MutationEvent evt) {
            textBridge.
              handleDOMCharacterDataModified(
                evt);
        }
        public void handleCSSEngineEvent(org.apache.batik.css.engine.CSSEngineEvent evt) {
            textBridge.
              handleCSSEngineEvent(
                evt);
        }
        public void handleAnimatedAttributeChanged(org.apache.batik.dom.svg.AnimatedLiveAttributeValue alav) {
            
        }
        public void handleOtherAnimationChanged(java.lang.String type) {
            
        }
        public void dispose() { ((org.apache.batik.dom.svg.SVGOMElement)
                                   e).setSVGContext(
                                        null);
                                elemTPI.remove(
                                          e);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "QXFi5iieKDK0NIob8lBkQc9IxyFDlpLMuYfBg2dveXdjOUX4Ys6WgPNl1jyX" +
           "paetKasFyKrE8+j5/GzS85SFzqmZA1tsaGlgG3nOze4pg+Y9JZ/pfAnU3mDN" +
           "qxQtMlEbogmim9BB3lEYstdmC7IlYO/Tlt1PzxyyYkNLWP9OiXfvsuYiRVWi" +
           "ZECtTzwoXPp/oJCh6L+6GPtytayOFuTd7Ju30cLZ0w2B1tO7PuDFQ/bGuBbK" +
           "gFhKll1ZtDujrtR0EpM4OLVmSarxjw8pai2yMMiTo05h/YEp/zEQ1StPUQX/" +
           "dMtdoajGkQNV5oNb5LcUlYEIe/ydZqPU979dTIKUdYWQ8eVXpXzz599q87ND" +
           "3Hc+LOHmv8jYNU/K/E0mIpw7vX3wwet3PmPeOQkynuR52pwwqjKvv7J10/Ki" +
           "2mxdlX1rbta/VL3KznebzAU752eRi+TbwHlorFpf6LmNMdqzlzIfndn0+i+O" +
           "VL4Pqf0e5MMUzd3j+j3EvPzvzGgpKFj3hJ2S1fWLHr8m6lxzamLzuthfP+YF" +
           "PzKvbxcXl48Il5994JfHF5xp86M5/agCUnmSGUU1krF1QtlBhLQ+iuokoycD" +
           "SwQtEpb7USClSAdSpF8Mo3pGasx8IMfFgrMu28tuLClakV+i5N/z1sjqONG3" +
           "qCmFu8I6qHGdHrt+zik9U5rmGeD0ZLdyXr7tEWHrow0/O9Zc1gsHM8cct/oq" +
           "IxXNlrXuX494h1lRsWZ/hu0znJBIeEDT7GKq4rxmnpS/mzKsnyJfh9XrSQs/" +
           "5+pu8EfW/OM/y2LzyBgeAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "djJo8OZ0sY7imTkcT8w5RQC4+vrTQYD6PcimbAFrD8AWyFuejiWt3osrRZWd" +
           "FzflVgnw9UFM0gKqtOOWwhj0knGc0hyQsRWCYZEK+lWeHbuiHCbWBg9ks7zt" +
           "903JL9aW6IwK0JQSSiIYjIQpqvWB5stW2xa4cc3nlBqrjpwZ1dXRrTZfDUaN" +
           "ekOTuswIpn8Cro+nwTRNa43GCq9zZKWjFli+465xa8aNUAalim432NTX08pm" +
           "o4PKwB3ovGBvvXhYKwebzcpi1ut6r1REGbPsJpozLYUKkNExW2FST1fS5qhe" +
           "K+tDsyApm47jh3SwwFiX62ur1Em7C0/zigWzwI/Z6mC1KOq1fn+UahWrYFWo" +
           "9SBdp20jYGirsuyVxdJiwnZC3MUcOCNcNo3BcjEozOhByqyVRJ06VbzrQCDV" +
           "3qJD15IAx/o1VDaIkeeK7dGoZId0SQBOa8kKBTP2bX+rkuJGAFSg1Eci4YhN" +
           "TQxovO9XgrYcJXi3v6CNsB+XcRCzhCPb44JZ49C0FFkrnmtXVoRLx3gXW3Xa" +
           "WicEhdS0G6Na6LZ1sjhnte00rANq0gn9TRHlG3O1ZESdPq6qAPVX3WTKOeE0" +
           "nlYb1WXJGUaTObqMi6nXa3V1ipTqbWZVDRPXC0TUTZnI2/YWy8Y0FIUIrRWC" +
           "GKcWE5Tvo5BK0m3L0OFT5Uuzx03tsT3x355vbhyepcEH/ewG/xiedJOrN3g2" +
           "u/xFgJyX908PjjZs882yOw8OZQ5+j2/YHm2jnTnYZSlcf7PzxGFEth1wz7XO" +
           "3PKtgPe/7uFHNP4DpbP7W5aXAXJu/yj0qO3z0Mz9197z6OfnjUf7aJ973ffu" +
           "ll62fOVjOJ94zqlOnjb5of5HvtB+ofrbZ5EbDnfVrjgJPan0wMm9tFtDHcSh" +
           "J53YUbvncCguZJ5vQqj+/lD4Vz8juOoQn8ljahdJp7aDz5wcvPuObyPra/g4" +
           "DbHG+4fs64M95VdfZ0/5dVmxBcjdy3yISb7fBCA82KDKbeR682Ph+gqA3Lj2" +
           "Te0ojtOftWNzvNm8Yn2lq9b7rlr/XF2V/X1NLvCW67jht7LiTcfdwPladtik" +
           "h2DfDZnE648gP/R4IUO98w/uQ37wCYL8u9eB/N6seAdAnnkC8lB3/fXVEb/z" +
           "8SKmINLX7yN+/ROE+IPXQfyhrPg9gNx7iJhYyhmF6iEpA/kg6E/B/v3HC/sl" +
           "EO5D+7AfekJo4P4rOFyNoj3dM0xP3yNEkcqvjgjhj67jpE9lxccA8rSdk05q" +
           "n3LNxx+va0rQJQ/vu+ZtT4hrKle4JqPKaG3sNT3TzU40WHOtZ5xnKjHQ89OX" +
           "3O5nruOjz2bFnx0G0oGlQyswrDzjikD69M8jkN697613/9znD58L/M11YH85" +
           "K/4KIM/awebBUg932OFyc3XMX3y8mO+BWN+3j/l9Px/MxyH943XufT0rvgqQ" +
           "mzUzCvxIPwXta48FWgKQ/9frHpleGaZHz7ji/bPdO1Pqxx65cP6uR0Zfy996" +
           "OHyv6RYWOb+IHef4Yd+x63NBqC/MHNQtu6O/IP/5NkDuukb6B/M25ejE+p93" +
           "8t8ByMXT8gC5Kf89Lvc9gNx6JAdN7S6Oi/wAIDdAkezy34KDydp5fK/PQKn9" +
           "s/nkzLF0cz+w8kG742cN2qHK8ZcpshQ1f2/wIJ2Md28OXlY//kiPe9WPsA/s" +
           "XuZQHTlNMyvnWeTm3Xslhynpc69p7cDWuc6LfnLbJ255wUHufNuuw0dBfqxv" +
           "z7n6axOUG4D8RYf0T+7645d88JFv5AeX/wcN344Q0CkAAA==");
    }
    protected class AbstractTextChildTextContent extends org.apache.batik.bridge.SVGTextElementBridge.AbstractTextChildBridgeUpdateHandler implements org.apache.batik.dom.svg.SVGTextContent {
        protected AbstractTextChildTextContent(org.apache.batik.bridge.BridgeContext ctx,
                                               org.apache.batik.bridge.SVGTextElementBridge parent,
                                               org.w3c.dom.Element e) {
            super(
              ctx,
              parent,
              e);
        }
        public int getNumberOfChars() { return textBridge.
                                          getNumberOfChars(
                                            e);
        }
        public java.awt.geom.Rectangle2D getExtentOfChar(int charnum) {
            return textBridge.
              getExtentOfChar(
                e,
                charnum);
        }
        public java.awt.geom.Point2D getStartPositionOfChar(int charnum) {
            return textBridge.
              getStartPositionOfChar(
                e,
                charnum);
        }
        public java.awt.geom.Point2D getEndPositionOfChar(int charnum) {
            return textBridge.
              getEndPositionOfChar(
                e,
                charnum);
        }
        public void selectSubString(int charnum,
                                    int nchars) {
            textBridge.
              selectSubString(
                e,
                charnum,
                nchars);
        }
        public float getRotationOfChar(int charnum) {
            return textBridge.
              getRotationOfChar(
                e,
                charnum);
        }
        public float getComputedTextLength() {
            return textBridge.
              getComputedTextLength(
                e);
        }
        public float getSubStringLength(int charnum,
                                        int nchars) {
            return textBridge.
              getSubStringLength(
                e,
                charnum,
                nchars);
        }
        public int getCharNumAtPosition(float x,
                                        float y) {
            return textBridge.
              getCharNumAtPosition(
                e,
                x,
                y);
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
          ("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");
    }
    protected class TRefBridge extends org.apache.batik.bridge.SVGTextElementBridge.AbstractTextChildTextContent {
        protected TRefBridge(org.apache.batik.bridge.BridgeContext ctx,
                             org.apache.batik.bridge.SVGTextElementBridge parent,
                             org.w3c.dom.Element e) {
            super(
              ctx,
              parent,
              e);
        }
        public void handleAnimatedAttributeChanged(org.apache.batik.dom.svg.AnimatedLiveAttributeValue alav) {
            if (alav.
                  getNamespaceURI(
                    ) ==
                  null) {
                java.lang.String ln =
                  alav.
                  getLocalName(
                    );
                if (ln.
                      equals(
                        SVG_X_ATTRIBUTE) ||
                      ln.
                      equals(
                        SVG_Y_ATTRIBUTE) ||
                      ln.
                      equals(
                        SVG_DX_ATTRIBUTE) ||
                      ln.
                      equals(
                        SVG_DY_ATTRIBUTE) ||
                      ln.
                      equals(
                        SVG_ROTATE_ATTRIBUTE) ||
                      ln.
                      equals(
                        SVG_TEXT_LENGTH_ATTRIBUTE) ||
                      ln.
                      equals(
                        SVG_LENGTH_ADJUST_ATTRIBUTE)) {
                    textBridge.
                      computeLaidoutText(
                        ctx,
                        textBridge.
                          e,
                        textBridge.
                          getTextNode(
                            ));
                    return;
                }
            }
            super.
              handleAnimatedAttributeChanged(
                alav);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAALVYb2wcRxWfu7Md2/F/J3ZIYidxnCA74a5RGlDlNK3t2o7D" +
           "2bFixxJOm8vc7tzdxnu7m9k5++zW0FZCCXwIIbhtQNSfXBVQ21SIChC0MqpE" +
           "WxWQWiKgoCYIPhCgEY2QyocA5c3M7u3enp0olTjp5vZm3rx5f3/vzb5wA5Xb" +
           "FLUTg0XZnEXs6IDBxjC1idqvY9uegLmE8kwE//Pk9dH7wqhiCtVlsD2iYJsM" +
           "akRX7SnUphk2w4ZC7FFCVL5jjBKb0BnMNNOYQhs1ezhr6ZqisRFTJZxgEtM4" +
           "asSMUS2ZY2TYYcBQWxwkiQlJYr3B5Z44qlFMa84j3+Qj7/etcMqsd5bNUEP8" +
           "NJ7BsRzT9Fhcs1lPnqI9lqnPpXWTRUmeRU/rBxwTHIkfKDFBx8v1H926kGkQ" +
           "JmjGhmEyoZ59jNimPkPUOKr3Zgd0krXPoC+iSByt9xEz1Bl3D43BoTE41NXW" +
           "owLpa4mRy/abQh3mcqqwFC4QQzuKmViY4qzDZkzIDBwqmaO72Azabi9oK7Us" +
           "UfGpPbHFZ042fD+C6qdQvWaMc3EUEILBIVNgUJJNEmr3qipRp1CjAc4eJ1TD" +
           "ujbveLrJ1tIGZjlwv2sWPpmzCBVnerYCP4JuNKcwkxbUS4mAcv6Vp3ScBl1b" +
           "PF2lhoN8HhSs1kAwmsIQd86WsmnNUBnaFtxR0LHz80AAW9dlCcuYhaPKDAwT" +
           "qEmGiI6NdGwcQs9IA2m5CQFIGdq8JlNuawsr0zhNEjwiA3RjcgmoqoQh+BaG" +
           "NgbJBCfw0uaAl3z+uTF68PyjxmEjjEIgs0oUncu/Hja1BzYdIylCCeSB3FjT" +
           "HX8at7x6LowQEG8MEEuaHz5288G97StvSpotq9AcTZ4mCksoy8m6d7b2d90X" +
           "4WJUWqatcecXaS6ybMxZ6clbgDAtBY58Meourhz7+Rce/x75exhVD6MKxdRz" +
           "WYijRsXMWppO6BAxCMWMqMOoihhqv1gfRuvgOa4ZRM4eTaVswoZRmS6mKkzx" +
           "H0yUAhbcRNXwrBkp0322MMuI57yFEKqDL2pGqPIaEh/5y1AiljGzJIYVbGiG" +
           "GRujJtffjgHiJMG2mVgSon46Zps5CiEYM2k6hiEOMsRZSFJNTZPY+OTQBOQP" +
           "RwTY2ScmozzQrP//EXmuZfNsKAQO2BpMfx0y57Cpq4QmlMVc38DNlxJvy9Di" +
           "6eDYh6HPwalReWpUnBqVp0ZXO7VzAkJPPqJQSJy7gQsinQ4um4bkB/St6Rp/" +
           "5Mipcx0RiDZrtgzszUk7iqpQv4cQLqwnlMtNtfM7ru57PYzK4qgJKyyHdV5U" +
           "emka4EqZdjK6Jgn1ySsT231lgtc3aipEBZRaq1w4XCrNGUL5PEMbfBzcIsbT" +
           "NbZ2CVlVfrRyafaJyS/dE0bh4srAjywHUOPbxzieF3C7M4gIq/GtP3v9o8tP" +
           "L5geNhSVGrdCluzkOnQEIyNonoTSvR2/knh1oVOYvQqwm2HINYDF9uAZRdDT" +
           "48I416USFE6ZNIt1vuTauJplqDnrzYiQbRTPGyAsmnguboWk/JOTnOKXr7ZY" +
           "fGyVIc7jLKCFKBP3j1vP/u5Xf90vzO1WlHpfKzBOWI8PxTizJoFXjV7YTlBC" +
           "gO79S2PfeOrG2RMiZoFi52oHdvKxH9ALXAhm/vKbZ967dnX5StiLc4aqLGoy" +
           "yHOi5gt6VnK1Gm+jJxy42xMJgFAHDjxwOo8bEKJaSsNJnfDc+nf9rn2vfHC+" +
           "QYaCDjNuJO29MwNv/lN96PG3T/6rXbAJKbwQe2bzyCS6N3uceynFc1yO/BPv" +
           "tn3zDfws1AnAZlubJwJuI8IMEaH5JoZ2rQUvEkWc7sOl3ns3YORuauabZvcr" +
           "UdXMRh0KETYHBMU9YryX21uIhsTa/XzYZfvTrzjDff1aQrlw5cPayQ9fuymM" +
           "Vdzw+aNtBFs9MsD5sDsP7FuD8HgY2xmgu3dl9OEGfeUWcJwCjgrgv32UAljn" +
           "i2LToS5f9/ufvd5y6p0ICg+iat3E6iAWaY6qIL+InQGcz1sPPCiDa5ZHW4NQ" +
           "FZUoXzLB/btt9cgZyFpM+Hr+R60/OPj80lUR55bkscXP8NN82FMId7FSG6y5" +
           "/nAv4kBR21ptkWjplp9cXFKPPrdPNi9Nxa3GAHTSL/7mP7+IXvrjW6vUtwqn" +
           "rfUO5KWoragUjYh20YPD9+su/vnHnem+u6lCfK79DnWG/98GGnSvXVWCorzx" +
           "5N82TxzKnLqLgrItYMsgy++OvPDW0G7lYlj0xrKWlPTUxZt6/FaFQymBS4DB" +
           "1eQztSLmdxa8X8+9ug+8fsPx/gerg7oIHDF28+EzLoBWWLkkXCcD6FnnMlqF" +
           "YSDRQ46fHYDYX4IqHCnsmTQkuZbl7WdcmyGF6+gk1nNEiPjwbQDkFB+OQ4XM" +
           "YEPVicupwKUf5tNEhVjrus01lGpZKEwzTiMfW2i6Nv3t6y/KOA92/QFicm7x" +
           "qx9Hzy/KmJdXo50ltxP/Hnk9EtI3SNt+DJ8QfP/Lv1w1PiHb46Z+p0ffXmjS" +
           "eeZTtON2YokjBv9yeeEn31k4G3ZMNcJQ2YypyfvYIT5MSt/2fkLE4hNDVp6h" +
           "aq8f/WQlhKJNJddmedVTXlqqr2xdOv5bAQKF61gNpHMqp+u+bPBnRoVFSUoT" +
           "WtfISmCJHygUrWsIBvGe9DSgkn6GoYYgPUPl4tdPNwc28OiAlXzwkzzGUARI" +
           "+OOC5Vpp+K66/t4k9JUAg3ylP6PpqnjgpRsqbai0Gggfb7yTj33wv7MoRcT7" +
           "Dhe8cvKNB1wNlo6MPnrzs8/JXk/R8fy8uB/DdV+2nQUA3LEmN5dXxeGuW3Uv" +
           "V+1yI7RRCuzB0hZfpg8BlFi8Sm4OdEF2Z6EZem/54Gu/PFfxLiTjCRTC0JSc" +
           "8L1tkFdraKVyUHlOxL3a43tfJtqznq5vzR3am/rHH0ShdWrV1rXpE8qV5x/5" +
           "9cVNy9DGrR9G5ZB8JD+FqjX7oTnjGFFm6BSq1eyBPIgIXDSsD6PKnKGdyZFh" +
           "NY7qeFRj/iZE2MUxZ21hlt8UGOooBZXS+xU0JbOE9pk5QxUlAYqVN1P0Isat" +
           "ITnLCmzwZgqu3FCqe0J56Cv1P73QFBmEzCxSx89+nZ1LFuqT/92MV7Aa+JDK" +
           "S7iLJOIjluXCX8UDlkyVr0kaPs9QqNuZ9dUY/veiYPd18ciHxf8BkkMIl3YV" +
           "AAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "iYUclEzW9sim6dmsO5+NRxNLHU1gH03W4y650nptAk0acanbRGqrzmpIWcvO" +
           "wsI3jlBtLhnDYlfsZNDzy4KuFFf+nHWwgsGhm7CZ4GkJNcvtShl1xnilxMxn" +
           "zrrvihVrtIFFabgoW7LnrQmsMhymUc+aGnzFS9vCKgVaXHuWOKgjrVSUjKbT" +
           "q0+CidZxWalLCMUKorULWM1ThvFMpOUyPsHJPkpOGX1CUQxu+WXPcEduCVu2" +
           "5IpKlcbtaCnFat+nSiHZEZbmOkaCGetaKYZOQSjkMbZCRUxPXq8SacJVrJYc" +
           "16ZumZNRsySxBGIuHKbRXXBBadVaWwE5VBq1WWDZzAS1RSJMRsV+N20UW61Z" +
           "UzExOeIXIttrt9ZjD7c6BlljlM5aHgZNsoVYVWxIkB3Fa1AmE4nrwC+mCwZf" +
           "ro1WebSUdcvxnOGigIodRpcoFNPWxUhsmeW0EI2JWoPdLBMLXy5xUg+KzsSW" +
           "I7i7FEtoyivkxsQwlUPLxHLcnTfEsJ7U+s56iHcaNI5HYjetIo1Gp1nnwphz" +
           "ndBrtuSxULGwVeBsGlZNqUuI0izOKzNqMvPEUFblucjVNhKdCDXZlPR2K0T5" +
           "aoNWQehbpPXCSFbhpF5Vk8W0XaN7iTJKZ7yxHAVzeua6gxraSjB6Rnv0wDEW" +
           "Cy8u6dooivWBWBFGdEUdi9Ng7Qgji6tZvVWadIubSWshySNmvvbRlVssIwhN" +
           "R2S1viHwntfuI27HY0kRX8DVTallmMtOSpH8VOoYnc4oWlKhpi31rkHRHcSa" +
           "6pxjV2qCG1QxA+dpZFVbGPiADkYCR1DMWGD5wmA8RAdDdrQe8wgnW06aDn0W" +
           "hvG5FQkaE/RawwGCurSWFDfVOuZ6laFl0lO53GgzZkLFm2bbqKltflHrsmvR" +
           "HKkzd2Kj3tQtCvNBfZq2VhTLetSQozZ1fRgY9rASWRVphcJcWBu5cJU2XDkp" +
           "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" +
           "4rfz6tv/Al09Zrx7IAAA");
    }
    protected class TextPathBridge extends org.apache.batik.bridge.SVGTextElementBridge.AbstractTextChildTextContent {
        protected TextPathBridge(org.apache.batik.bridge.BridgeContext ctx,
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
           "6+VvFAf+/wUMEwei8hwAAA==");
    }
    protected class TspanBridge extends org.apache.batik.bridge.SVGTextElementBridge.AbstractTextChildTextContent {
        protected TspanBridge(org.apache.batik.bridge.BridgeContext ctx,
                              org.apache.batik.bridge.SVGTextElementBridge parent,
                              org.w3c.dom.Element e) {
            super(
              ctx,
              parent,
              e);
        }
        public void handleAnimatedAttributeChanged(org.apache.batik.dom.svg.AnimatedLiveAttributeValue alav) {
            if (alav.
                  getNamespaceURI(
                    ) ==
                  null) {
                java.lang.String ln =
                  alav.
                  getLocalName(
                    );
                if (ln.
                      equals(
                        SVG_X_ATTRIBUTE) ||
                      ln.
                      equals(
                        SVG_Y_ATTRIBUTE) ||
                      ln.
                      equals(
                        SVG_DX_ATTRIBUTE) ||
                      ln.
                      equals(
                        SVG_DY_ATTRIBUTE) ||
                      ln.
                      equals(
                        SVG_ROTATE_ATTRIBUTE) ||
                      ln.
                      equals(
                        SVG_TEXT_LENGTH_ATTRIBUTE) ||
                      ln.
                      equals(
                        SVG_LENGTH_ADJUST_ATTRIBUTE)) {
                    textBridge.
                      computeLaidoutText(
                        ctx,
                        textBridge.
                          e,
                        textBridge.
                          getTextNode(
                            ));
                    return;
                }
            }
            super.
              handleAnimatedAttributeChanged(
                alav);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAALVYfWwcRxWfu7Md2/Hn5cMhie18OEFxwl2jNIjKSajt2sml" +
           "Z8eKHUs4bS5zu3N3G+/tbmbn7LNbQ1sJJeWPEILbBtT6L1cF1DYVogIErYwq" +
           "0VYFpJYIKKgpEn8QPiIaIZU/ApQ3M7u3e3t2olTipJvbm3nz5n3+3pt98Qaq" +
           "tinqIAaLsRmL2LEBg41gahO1X8e2PQZzKeWZCP7nqevD94VRzQRqymF7SME2" +
           "GdSIrtoTqF0zbIYNhdjDhKh8xwglNqFTmGmmMYHWaXYib+maorEhUyWcYBzT" +
           "JGrFjFEtXWAk4TBgqD0JksSFJPHe4HJPEjUopjXjkW/wkff7Vjhl3jvLZqgl" +
           "eQZP4XiBaXo8qdmsp0jRbsvUZ7K6yWKkyGJn9P2OCY4m91eYYNsrzR/fuphr" +
           "ESZYgw3DZEI9+zixTX2KqEnU7M0O6CRvn0VfRpEkWu0jZqgr6R4ah0PjcKir" +
           "rUcF0jcSo5DvN4U6zOVUYylcIIa2ljOxMMV5h82IkBk41DJHd7EZtN1S0lZq" +
           "WaHiU7vj88+cavl+BDVPoGbNGOXiKCAEg0MmwKAknybU7lVVok6gVgOcPUqo" +
           "hnVt1vF01NayBmYFcL9rFj5ZsAgVZ3q2Aj+CbrSgMJOW1MuIgHL+VWd0nAVd" +
           "13u6Sg0H+TwoWK+BYDSDIe6cLVWTmqEy1BncUdKx60EggK2r8oTlzNJRVQaG" +
           "CRSVIaJjIxsfhdAzskBabUIAUoY2rsiU29rCyiTOkhSPyADdiFwCqjphCL6F" +
           "oXVBMsEJvLQx4CWff24MH7jwiHHECKMQyKwSRefyr4ZNHYFNx0mGUAJ5IDc2" +
           "dCefxutfOx9GCIjXBYglzQ8fvXn/no6ltyTNpmVojqXPEIWllMV007ub+3fd" +
           "F+Fi1FqmrXHnl2kusmzEWekpWoAw60sc+WLMXVw6/vMvPfY98rcwqk+gGsXU" +
           "C3mIo1bFzFuaTuhhYhCKGVETqI4Yar9YT6BV8JzUDCJnj2UyNmEJVKWLqRpT" +
           "/AcTZYAFN1E9PGtGxnSfLcxy4rloIYSa4IvWIFTXisRH/jKUiufMPIljBRua" +
           "YcZHqMn1t+OAOGmwbS6ehqifjNtmgUIIxk2ajWOIgxxxFtJUU7MkPjp+eAzy" +
           "hyMC7OwTkzEeaNb//4gi13LNdCgEDtgcTH8dMueIqauEppT5Qt/AzZdT78jQ" +
           "4ung2IehL8CpMXlqTJwak6fGlju1a8y2sCGfUSgkDl7LJZFeB59NQvYD/Dbs" +
           "Gn346Onz2yIQbtZ0FRick24rK0P9HkS4uJ5SrkQbZ7de2/tGGFUlURQrrIB1" +
           "XlV6aRbwSpl0UrohDQXKqxNbfHWCFzhqKkQFmFqpXjhcas0pQvk8Q2t9HNwq" +
           "xvM1vnINWVZ+tHR5+vHxr9wTRuHy0sCPrAZU49tHOKCXgLsrCAnL8W0+d/3j" +
           "K0/PmR44lNUat0RW7OQ6bAuGRtA8KaV7C3419dpclzB7HYA3w5BsgIsdwTPK" +
           "sKfHxXGuSy0onDFpHut8ybVxPctRc9qbETHbKp7XQlhEeTK2Q1audbJT/PLV" +
           "9RYf22SM8zgLaCHqxMFR67nf/eov+4S53ZLS7OsFRgnr8cEYZxYVgNXqhe0Y" +
           "JQToPrg88s2nbpw7KWIWKLYvd2AXH/sBvsCFYOavvnX2/Q+vLV4Ne3HOUJ1F" +
           "TQaJTtRiSc9arlbrbfSEA3d6IgES6sCBB07XCQNCVMtoOK0Tnlv/bt6x99W/" +
           "X2iRoaDDjBtJe+7MwJv/TB967J1T/+oQbEIKr8Se2TwyCe9rPM69lOIZLkfx" +
           "8ffav/Umfg4KBYCzrc0SgbcRYYaI0HwDQztWwheJIk774VLvuRs0cjet4Zum" +
           "9ykx1czHHAoRNvsFxT1ivJfbW4iGxNpBPuyw/elXnuG+hi2lXLz6UeP4R6/f" +
           "FMYq7/j80TaErR4Z4HzYWQT2bUF4PILtHNDduzT8UIu+dAs4TgBHBQqAfYwC" +
           "WhfLYtOhrl71+5+9sf70uxEUHkT1uonVQSzSHNVBfhE7B0BftL54vwyuaR5t" +
           "LUJVVKF8xQT3b+fykTOQt5jw9eyP2n5w4IWFayLOLcljk5/hZ/mwuxTuYqUx" +
           "WHT94V7GgaL2lfoi0dMtPjG/oB57fq/sXqLlvcYAtNIv/eY/v4hd/uPbyxS4" +
           "Gqev9Q7kpai9rBQNiX7Rg8MPmi796cdd2b67qUJ8ruMOdYb/7wQNuleuKkFR" +
           "3nzirxvHDuVO30VB6QzYMsjyu0Mvvn14p3IpLJpjWUsqmuryTT1+q8KhlMAt" +
           "wOBq8plGEfPbS95v5l7dC17vdLzfsTyoi8ARYzcfPucCaI1VSMN9MoCeTS6j" +
           "ZRgGEj3k+NkBiH0VqMKRwp7KQpJred5/JrUpUrqPjmO9QISID90GQE7z4QRU" +
           "yBw2VJ24nEpc+mE+S1SItV23uYdSLQ+Facrp5ONz0Q8nn73+kozzYNsfICbn" +
           "57/2SezCvIx5eTfaXnE98e+R9yMhfYu07SfwCcH3v/zLVeMTsj+O9jtN+pZS" +
           "l84zn6KttxNLHDH45ytzP/nO3LmwY6ohhqqmTE1eyA7xYVz6tvdTIhafOGwV" +
           "GVrta0g/XQ2haEPFxVle9pSXF5pr2xZO/FagQOlC1gD5nCnoui8d/KlRY1GS" +
           "0YTaDbIUWOIHKkXbCoJBwKc9Daikn2KoJUjPULX49dPNMFTv0QEr+eAneZSh" +
           "CJDwxznLtVLirvr+3jQ0loCDfKU/p+mqeOC1G0ptqLIcCCevu5OTffi/vSxH" +
           "xBsPF70K8p0H3A0Wjg4/cvPzz8tmT9Hx7Ky4IcOFX/adJQTcuiI3l1fNkV23" +
           "ml6p2+GGaKsU2MOlTb5UPwxYYvEyuTHQBtldpW7o/cUDr//yfM17kI0nUQhD" +
           "V3LS975BXq6hlypA6TmZ9IqP742Z6M96dn175tCezD/+ICqtU6w2r0yfUq6+" +
           "8PCvL21YhD5udQJVQ/aR4gSq1+wHZozjRJmiE6hRsweKICJw0bCeQLUFQztb" +
           "IAk1iZp4VGP+LkTYxTFnY2mWXxUY2laJKpUXLOhKpgntMwuGKmoCVCtvpuxV" +
           "jFtECpYV2ODNlFy5tlL3lPLAk80/vRiNDEJmlqnjZ7/KLqRLBcr/dsarWC18" +
           "yBQl3kVSySHLcvGv5qAlU+XrkobPMxTqdmZ9RYb/vSTYfUM88mH+f7CWOxN4" +
           "FQAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAALU5a6wj11mzd7Ob3W2S3WzaJITmvSlKXN0Zjx9ja0upPfZ4" +
           "xjN+zsMeA93O0zP2vF8eu6S0FZCISqGUtBSpza9WQJU+hKhAQkVBCNqqFVJR" +
           "xUuirRAShVKp+UFBBChnxvde33t3N1WEsOTj43O+7zvne57vfOfl70PnwgAq" +
           "eK61nltutK+l0f7CquxHa08L97tMZSgFoabilhSGHBi7oTzxhcs/fO3DxpU9" +
           "6PwMuk9yHDeSItN1wrEWulaiqQx0eTfatjQ7jKArzEJKJDiOTAtmzDC6zkBv" +
           "OoYaQdeYwy3AYAsw2AKcbwFu7KAA0t2aE9t4hiE5UehD74POMNB5T8m2F0GP" +
           "nyTiSYFkH5AZ5hwAChey/wJgKkdOA+ixI963PN/E8EcL8Iu/+e4rv3cWujyD" +
           "LpsOm21HAZuIwCIz6C5bs2UtCBuqqqkz6F5H01RWC0zJMjf5vmfQ1dCcO1IU" +
           "B9qRkLLB2NOCfM2d5O5SMt6CWInc4Ig93dQs9fDfOd2S5oDX+3e8bjkksnHA" +
           "4CUTbCzQJUU7RLljaTpqBD16GuOIx2s0AACod9paZLhHS93hSGAAurrVnSU5" +
           "c5iNAtOZA9BzbgxWiaCHbks0k7UnKUtprt2IoAdPww23UwDqYi6IDCWC3nIa" +
           "LKcEtPTQKS0d08/3++944b0O6ezle1Y1xcr2fwEgPXIKaazpWqA5irZFvOsZ" +
           "5mPS/V96fg+CAPBbTgFvYf7gF15919sfeeUrW5ifvAXMQF5oSnRD+ZR8zzfe" +
           "ij9dP5tt44Lnhmam/BOc5+Y/PJi5nnrA8+4/ophN7h9OvjL+c/H9n9G+twdd" +
           "oqDzimvFNrCjexXX9kxLCzqaowVSpKkUdFFzVDyfp6A7QZ8xHW07OtD1UIso" +
           "6A4rHzrv5v+BiHRAIhPRnaBvOrp72PekyMj7qQdB0D3gC90HQRfvhfLP9jeC" +
           "bsCGa2uwpEiO6bjwMHAz/kNYcyIZyNaAZWD1Szh04wCYIOwGc1gCdmBoBxNy" +
           "YKpzDWaFDgf8J4sPALOZD+5nhub9/y+RZlxeWZ05AxTw1tPubwHPIV1L1YIb" +
           "yotxs/3q5258be/IHQ7kE0E1sOr+dtX9fNX97ar7t1r1Ghd6krPtQ2fO5Au/" +
           "OdvJVutAZ0vg/SAu3vU0+/Pd9zz/xFlgbt7qDiDwDBS+fXjGd/GCyqOiAowW" +
           "euXjqw8Iv4jsQXsn42y2ezB0KUMfZtHxKApeO+1ft6J7+bnv/vDzH3vW3Xna" +
           "icB9EABuxswc+InTcg5cRVNBSNyRf+Yx6Ys3vvTstT3oDhAVQCSMJGC5IMg8" +
           "cnqNE458/TAoZrycAwzrbmBLVjZ1GMkuRUbgrnYjuQHck/czq76aWfbDwMTf" +
           "fGDq+W82e5+XtW/eGkymtFNc5EH3p1nvk3/zF/9cysV9GJ8vHzvxWC26fiwm" +
           "ZMQu595/784GuEDTANzff3z4Gx/9/nM/mxsAgHjyVgtey1ocxAKgQiDmX/6K" +
           "/7ff/tanvrm3M5oIuugFbgS8RlPTIz4vZGzd+zp8ggXfttsSCCsWoJAZzjXe" +
           "sV3V1E1JtrTMUP/r8lPFL/7rC1e2pmCBkUNLevuPJ7Ab/4km9P6vvfvfH8nJ" +
           "nFGyY20nth3YNlbet6PcCAJpne0j/cBfPvxbX5Y+CaIuiHShudHy4HU2F8PZ" +
           "nPO3RNBTt3PWrUsenOWH0G9/I659iHRfhrQqKfuqa+8fQORmA+cQz+Ttfibv" +
           "fGtQPodlzaPhcfc76eHHsp8byoe/+YO7hR/88au5sE6mT8etrSd517cGnjWP" +
           "pYD8A6djDSmFBoArv9L/uSvWK68BijNAUQHRNBwEIPSlJ2zzAPrcnX/3J396" +
           "/3u+cRbaI6BLliuphJS7OXQR+JcWGiBqpt7PvGtrXKvM2q7krEI3Mb+1yQcP" +
           "tBRAT98+whFZ9rMLEg/+58CSP/gP/3GTEPLYdotD/xT+DH75Ew/h7/xejr8L" +
           "Mhn2I+nNxwHIFHe46Gfsf9t74vyf7UF3zqArykEaKkhWnLnuDKRe4WFuClLV" +
           "E/Mn06htznD9KIi+9XSAO7bs6fC2O4ZAP4PO+peOR7Qfgc8Z8P2f7JuJOxvY" +
           "Ht5X8YMM4rGjFMLz0jMgXpxD97F9JMNv51Qez9trWfNTWzVFINGOZcsEXno+" +
           "zHNggKWbjmTlixMRMDNLuXa4ggByYqCXawsLO/SRK7lJZRLY3yaS27CatbWc" +
           "xNYsrt/WhN61hcrPz3t2xBgX5KQf+scPf/3Xnvw20GsXOpdkMgfqPLZiP87S" +
           "9F95+aMPv+nF73woj5UgUAq/9NpDOVX2NlxnXTprmKzpHbL6UMYqmycgjBRG" +
           "vTy2aWrO7eua8zAwbXAKJAc5KPzs1W8vP/Hdz27zy9O2ewpYe/7FX/3R/gsv" +
           "7h3L6p+8KbE+jrPN7PNN330g4QB6/PVWyTGIf/r8s3/0O88+t93V1ZM5ahtc" +
           "wT77V//99f2Pf+ert0iM7rDc/4Nio7s8shxSjcMPI4j6ZKWM04keYz0VhUmn" +
           "ovQMUyvWBm0iXVnook8taFZaRGhoW7OaRpN8WJbZyiYu9UudAhzJtuxgTF8e" +
           "FcNuV5sM2xQjNyOuyhQVotgSBXdOtQNx5SOCSHhdkaLpudd2aqOhSUnUjIcb" +
           "3qjUw+KSVopQ1+JMr5vIdsnZVJxSoeRF9dpI8iPT8amGxIRjm0GZdnNeLs4l" +
           "Y1Cc1jR0OJptaG0yw4eY42tJq14WxpvR2F/bBMb22mhHZakgcjmfQDYyJfYN" +
           "ddEyaKOWruZW3yc4u2PbPZGcSFPRlAu25AZtg19PFLG54bqdgFgQ7Wg6aSzL" +
           "XHPut5DuMmSJ7pDUymR32F7wrreYLpYTeLXUdUxYGFZpkTAzf25po9mwPDWb" +
           "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" +
           "b/8L7G7L3n0gAAA=");
    }
    public int getNumberOfChars() { return getNumberOfChars(
                                             e);
    }
    public java.awt.geom.Rectangle2D getExtentOfChar(int charnum) {
        return getExtentOfChar(
                 e,
                 charnum);
    }
    public java.awt.geom.Point2D getStartPositionOfChar(int charnum) {
        return getStartPositionOfChar(
                 e,
                 charnum);
    }
    public java.awt.geom.Point2D getEndPositionOfChar(int charnum) {
        return getEndPositionOfChar(
                 e,
                 charnum);
    }
    public void selectSubString(int charnum,
                                int nchars) {
        selectSubString(
          e,
          charnum,
          nchars);
    }
    public float getRotationOfChar(int charnum) {
        return getRotationOfChar(
                 e,
                 charnum);
    }
    public float getComputedTextLength() {
        return getComputedTextLength(
                 e);
    }
    public float getSubStringLength(int charnum,
                                    int nchars) {
        return getSubStringLength(
                 e,
                 charnum,
                 nchars);
    }
    public int getCharNumAtPosition(float x,
                                    float y) {
        return getCharNumAtPosition(
                 e,
                 x,
                 y);
    }
    protected int getNumberOfChars(org.w3c.dom.Element element) {
        java.text.AttributedCharacterIterator aci;
        aci =
          getTextNode(
            ).
            getAttributedCharacterIterator(
              );
        if (aci ==
              null)
            return 0;
        int firstChar =
          getElementStartIndex(
            element);
        if (firstChar ==
              -1)
            return 0;
        int lastChar =
          getElementEndIndex(
            element);
        return lastChar -
          firstChar +
          1;
    }
    protected java.awt.geom.Rectangle2D getExtentOfChar(org.w3c.dom.Element element,
                                                        int charnum) {
        org.apache.batik.gvt.TextNode textNode =
          getTextNode(
            );
        java.text.AttributedCharacterIterator aci;
        aci =
          textNode.
            getAttributedCharacterIterator(
              );
        if (aci ==
              null)
            return null;
        int firstChar =
          getElementStartIndex(
            element);
        if (firstChar ==
              -1)
            return null;
        java.util.List list =
          getTextRuns(
            textNode);
        org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation info;
        info =
          getCharacterInformation(
            list,
            firstChar,
            charnum,
            aci);
        if (info ==
              null)
            return null;
        org.apache.batik.gvt.font.GVTGlyphVector it =
          info.
            layout.
          getGlyphVector(
            );
        java.awt.Shape b =
          null;
        if (info.
              glyphIndexStart ==
              info.
                glyphIndexEnd) {
            if (it.
                  isGlyphVisible(
                    info.
                      glyphIndexStart)) {
                b =
                  it.
                    getGlyphCellBounds(
                      info.
                        glyphIndexStart);
            }
        }
        else {
            java.awt.geom.GeneralPath path =
              null;
            for (int k =
                   info.
                     glyphIndexStart;
                 k <=
                   info.
                     glyphIndexEnd;
                 k++) {
                if (it.
                      isGlyphVisible(
                        k)) {
                    java.awt.geom.Rectangle2D gb =
                      it.
                      getGlyphCellBounds(
                        k);
                    if (path ==
                          null) {
                        path =
                          new java.awt.geom.GeneralPath(
                            gb);
                    }
                    else {
                        path.
                          append(
                            gb,
                            false);
                    }
                }
            }
            b =
              path;
        }
        if (b ==
              null) {
            return null;
        }
        return b.
          getBounds2D(
            );
    }
    protected java.awt.geom.Point2D getStartPositionOfChar(org.w3c.dom.Element element,
                                                           int charnum) {
        org.apache.batik.gvt.TextNode textNode =
          getTextNode(
            );
        java.text.AttributedCharacterIterator aci;
        aci =
          textNode.
            getAttributedCharacterIterator(
              );
        if (aci ==
              null)
            return null;
        int firstChar =
          getElementStartIndex(
            element);
        if (firstChar ==
              -1)
            return null;
        java.util.List list =
          getTextRuns(
            textNode);
        org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation info;
        info =
          getCharacterInformation(
            list,
            firstChar,
            charnum,
            aci);
        if (info ==
              null)
            return null;
        return getStartPoint(
                 info);
    }
    protected java.awt.geom.Point2D getStartPoint(org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation info) {
        org.apache.batik.gvt.font.GVTGlyphVector it =
          info.
            layout.
          getGlyphVector(
            );
        if (!it.
              isGlyphVisible(
                info.
                  glyphIndexStart))
            return null;
        java.awt.geom.Point2D b =
          it.
          getGlyphPosition(
            info.
              glyphIndexStart);
        java.awt.geom.AffineTransform glyphTransform;
        glyphTransform =
          it.
            getGlyphTransform(
              info.
                glyphIndexStart);
        java.awt.geom.Point2D.Float result =
          new java.awt.geom.Point2D.Float(
          0,
          0);
        if (glyphTransform !=
              null)
            glyphTransform.
              transform(
                result,
                result);
        result.
          x +=
          b.
            getX(
              );
        result.
          y +=
          b.
            getY(
              );
        return result;
    }
    protected java.awt.geom.Point2D getEndPositionOfChar(org.w3c.dom.Element element,
                                                         int charnum) {
        org.apache.batik.gvt.TextNode textNode =
          getTextNode(
            );
        java.text.AttributedCharacterIterator aci;
        aci =
          textNode.
            getAttributedCharacterIterator(
              );
        if (aci ==
              null)
            return null;
        int firstChar =
          getElementStartIndex(
            element);
        if (firstChar ==
              -1)
            return null;
        java.util.List list =
          getTextRuns(
            textNode);
        org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation info;
        info =
          getCharacterInformation(
            list,
            firstChar,
            charnum,
            aci);
        if (info ==
              null)
            return null;
        return getEndPoint(
                 info);
    }
    protected java.awt.geom.Point2D getEndPoint(org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation info) {
        org.apache.batik.gvt.font.GVTGlyphVector it =
          info.
            layout.
          getGlyphVector(
            );
        if (!it.
              isGlyphVisible(
                info.
                  glyphIndexEnd))
            return null;
        java.awt.geom.Point2D b =
          it.
          getGlyphPosition(
            info.
              glyphIndexEnd);
        java.awt.geom.AffineTransform glyphTransform;
        glyphTransform =
          it.
            getGlyphTransform(
              info.
                glyphIndexEnd);
        org.apache.batik.gvt.font.GVTGlyphMetrics metrics =
          it.
          getGlyphMetrics(
            info.
              glyphIndexEnd);
        java.awt.geom.Point2D.Float result =
          new java.awt.geom.Point2D.Float(
          metrics.
            getHorizontalAdvance(
              ),
          0);
        if (glyphTransform !=
              null)
            glyphTransform.
              transform(
                result,
                result);
        result.
          x +=
          b.
            getX(
              );
        result.
          y +=
          b.
            getY(
              );
        return result;
    }
    protected float getRotationOfChar(org.w3c.dom.Element element,
                                      int charnum) {
        org.apache.batik.gvt.TextNode textNode =
          getTextNode(
            );
        java.text.AttributedCharacterIterator aci;
        aci =
          textNode.
            getAttributedCharacterIterator(
              );
        if (aci ==
              null)
            return 0;
        int firstChar =
          getElementStartIndex(
            element);
        if (firstChar ==
              -1)
            return 0;
        java.util.List list =
          getTextRuns(
            textNode);
        org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation info;
        info =
          getCharacterInformation(
            list,
            firstChar,
            charnum,
            aci);
        double angle =
          0.0;
        int nbGlyphs =
          0;
        if (info !=
              null) {
            org.apache.batik.gvt.font.GVTGlyphVector it =
              info.
                layout.
              getGlyphVector(
                );
            for (int k =
                   info.
                     glyphIndexStart;
                 k <=
                   info.
                     glyphIndexEnd;
                 k++) {
                if (!it.
                      isGlyphVisible(
                        k))
                    continue;
                nbGlyphs++;
                java.awt.geom.AffineTransform glyphTransform =
                  it.
                  getGlyphTransform(
                    k);
                if (glyphTransform ==
                      null)
                    continue;
                double glyphAngle =
                  0.0;
                double cosTheta =
                  glyphTransform.
                  getScaleX(
                    );
                double sinTheta =
                  glyphTransform.
                  getShearX(
                    );
                if (cosTheta ==
                      0.0) {
                    if (sinTheta >
                          0)
                        glyphAngle =
                          java.lang.Math.
                            PI;
                    else
                        glyphAngle =
                          -java.lang.Math.
                             PI;
                }
                else {
                    glyphAngle =
                      java.lang.Math.
                        atan(
                          sinTheta /
                            cosTheta);
                    if (cosTheta <
                          0)
                        glyphAngle +=
                          java.lang.Math.
                            PI;
                }
                glyphAngle =
                  java.lang.Math.
                    toDegrees(
                      -glyphAngle) %
                    360.0;
                angle +=
                  glyphAngle -
                    info.
                    getComputedOrientationAngle(
                      );
            }
        }
        if (nbGlyphs ==
              0)
            return 0;
        return (float)
                 (angle /
                    nbGlyphs);
    }
    protected float getComputedTextLength(org.w3c.dom.Element e) {
        return getSubStringLength(
                 e,
                 0,
                 getNumberOfChars(
                   e));
    }
    protected float getSubStringLength(org.w3c.dom.Element element,
                                       int charnum,
                                       int nchars) {
        if (nchars ==
              0) {
            return 0;
        }
        float length =
          0;
        org.apache.batik.gvt.TextNode textNode =
          getTextNode(
            );
        java.text.AttributedCharacterIterator aci;
        aci =
          textNode.
            getAttributedCharacterIterator(
              );
        if (aci ==
              null)
            return -1;
        int firstChar =
          getElementStartIndex(
            element);
        if (firstChar ==
              -1)
            return -1;
        java.util.List list =
          getTextRuns(
            textNode);
        org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation currentInfo;
        currentInfo =
          getCharacterInformation(
            list,
            firstChar,
            charnum,
            aci);
        org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation lastCharacterInRunInfo =
          null;
        int chIndex =
          currentInfo.
            characterIndex +
          1;
        org.apache.batik.gvt.font.GVTGlyphVector vector =
          currentInfo.
            layout.
          getGlyphVector(
            );
        float[] advs =
          currentInfo.
            layout.
          getGlyphAdvances(
            );
        boolean[] glyphTrack =
          new boolean[advs.
                        length];
        for (int k =
               charnum +
               1;
             k <
               charnum +
               nchars;
             k++) {
            if (currentInfo.
                  layout.
                  isOnATextPath(
                    )) {
                for (int gi =
                       currentInfo.
                         glyphIndexStart;
                     gi <=
                       currentInfo.
                         glyphIndexEnd;
                     gi++) {
                    if (vector.
                          isGlyphVisible(
                            gi) &&
                          !glyphTrack[gi])
                        length +=
                          advs[gi +
                                 1] -
                            advs[gi];
                    glyphTrack[gi] =
                      true;
                }
                org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation newInfo;
                newInfo =
                  getCharacterInformation(
                    list,
                    firstChar,
                    k,
                    aci);
                if (newInfo.
                      layout !=
                      currentInfo.
                        layout) {
                    vector =
                      newInfo.
                        layout.
                        getGlyphVector(
                          );
                    advs =
                      newInfo.
                        layout.
                        getGlyphAdvances(
                          );
                    glyphTrack =
                      (new boolean[advs.
                                     length]);
                    chIndex =
                      currentInfo.
                        characterIndex +
                        1;
                }
                currentInfo =
                  newInfo;
            }
            else {
                if (currentInfo.
                      layout.
                      hasCharacterIndex(
                        chIndex)) {
                    chIndex++;
                    continue;
                }
                lastCharacterInRunInfo =
                  getCharacterInformation(
                    list,
                    firstChar,
                    k -
                      1,
                    aci);
                length +=
                  distanceFirstLastCharacterInRun(
                    currentInfo,
                    lastCharacterInRunInfo);
                currentInfo =
                  getCharacterInformation(
                    list,
                    firstChar,
                    k,
                    aci);
                chIndex =
                  currentInfo.
                    characterIndex +
                    1;
                vector =
                  currentInfo.
                    layout.
                    getGlyphVector(
                      );
                advs =
                  currentInfo.
                    layout.
                    getGlyphAdvances(
                      );
                glyphTrack =
                  (new boolean[advs.
                                 length]);
                lastCharacterInRunInfo =
                  null;
            }
        }
        if (currentInfo.
              layout.
              isOnATextPath(
                )) {
            for (int gi =
                   currentInfo.
                     glyphIndexStart;
                 gi <=
                   currentInfo.
                     glyphIndexEnd;
                 gi++) {
                if (vector.
                      isGlyphVisible(
                        gi) &&
                      !glyphTrack[gi])
                    length +=
                      advs[gi +
                             1] -
                        advs[gi];
                glyphTrack[gi] =
                  true;
            }
        }
        else {
            if (lastCharacterInRunInfo ==
                  null) {
                lastCharacterInRunInfo =
                  getCharacterInformation(
                    list,
                    firstChar,
                    charnum +
                      nchars -
                      1,
                    aci);
            }
            length +=
              distanceFirstLastCharacterInRun(
                currentInfo,
                lastCharacterInRunInfo);
        }
        return length;
    }
    protected float distanceFirstLastCharacterInRun(org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation first,
                                                    org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation last) {
        float[] advs =
          first.
            layout.
          getGlyphAdvances(
            );
        int firstStart =
          first.
            glyphIndexStart;
        int firstEnd =
          first.
            glyphIndexEnd;
        int lastStart =
          last.
            glyphIndexStart;
        int lastEnd =
          last.
            glyphIndexEnd;
        int start =
          firstStart <
          lastStart
          ? firstStart
          : lastStart;
        int end =
          firstEnd <
          lastEnd
          ? lastEnd
          : firstEnd;
        return advs[end +
                      1] -
          advs[start];
    }
    protected float distanceBetweenRun(org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation last,
                                       org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation first) {
        float distance;
        java.awt.geom.Point2D startPoint;
        java.awt.geom.Point2D endPoint;
        org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation info =
          new org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation(
          );
        info.
          layout =
          last.
            layout;
        info.
          glyphIndexEnd =
          last.
            layout.
            getGlyphCount(
              ) -
            1;
        startPoint =
          getEndPoint(
            info);
        info.
          layout =
          first.
            layout;
        info.
          glyphIndexStart =
          0;
        endPoint =
          getStartPoint(
            info);
        if (first.
              isVertical(
                )) {
            distance =
              (float)
                (endPoint.
                   getY(
                     ) -
                   startPoint.
                   getY(
                     ));
        }
        else {
            distance =
              (float)
                (endPoint.
                   getX(
                     ) -
                   startPoint.
                   getX(
                     ));
        }
        return distance;
    }
    protected void selectSubString(org.w3c.dom.Element element,
                                   int charnum,
                                   int nchars) {
        org.apache.batik.gvt.TextNode textNode =
          getTextNode(
            );
        java.text.AttributedCharacterIterator aci;
        aci =
          textNode.
            getAttributedCharacterIterator(
              );
        if (aci ==
              null)
            return;
        int firstChar =
          getElementStartIndex(
            element);
        if (firstChar ==
              -1)
            return;
        java.util.List list =
          getTextRuns(
            textNode);
        int lastChar =
          getElementEndIndex(
            element);
        org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation firstInfo;
        org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation lastInfo;
        firstInfo =
          getCharacterInformation(
            list,
            firstChar,
            charnum,
            aci);
        lastInfo =
          getCharacterInformation(
            list,
            firstChar,
            charnum +
              nchars -
              1,
            aci);
        org.apache.batik.gvt.text.Mark firstMark;
        org.apache.batik.gvt.text.Mark lastMark;
        firstMark =
          textNode.
            getMarkerForChar(
              firstInfo.
                characterIndex,
              true);
        if (lastInfo !=
              null &&
              lastInfo.
                characterIndex <=
              lastChar) {
            lastMark =
              textNode.
                getMarkerForChar(
                  lastInfo.
                    characterIndex,
                  false);
        }
        else {
            lastMark =
              textNode.
                getMarkerForChar(
                  lastChar,
                  false);
        }
        ctx.
          getUserAgent(
            ).
          setTextSelection(
            firstMark,
            lastMark);
    }
    protected int getCharNumAtPosition(org.w3c.dom.Element e,
                                       float x,
                                       float y) {
        org.apache.batik.gvt.TextNode textNode =
          getTextNode(
            );
        java.text.AttributedCharacterIterator aci;
        aci =
          textNode.
            getAttributedCharacterIterator(
              );
        if (aci ==
              null)
            return -1;
        java.util.List list =
          getTextRuns(
            textNode);
        org.apache.batik.gvt.text.TextHit hit =
          null;
        for (int i =
               list.
               size(
                 ) -
               1;
             i >=
               0 &&
               hit ==
               null;
             i--) {
            org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun textRun;
            textRun =
              (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
                list.
                get(
                  i);
            hit =
              textRun.
                getLayout(
                  ).
                hitTestChar(
                  x,
                  y);
        }
        if (hit ==
              null)
            return -1;
        int first =
          getElementStartIndex(
            e);
        int last =
          getElementEndIndex(
            e);
        int hitIndex =
          hit.
          getCharIndex(
            );
        if (hitIndex >=
              first &&
              hitIndex <=
              last)
            return hitIndex -
              first;
        return -1;
    }
    protected java.util.List getTextRuns(org.apache.batik.gvt.TextNode node) {
        if (node.
              getTextRuns(
                ) ==
              null) {
            node.
              getPrimitiveBounds(
                );
        }
        return node.
          getTextRuns(
            );
    }
    protected org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation getCharacterInformation(java.util.List list,
                                                                                                        int startIndex,
                                                                                                        int charnum,
                                                                                                        java.text.AttributedCharacterIterator aci) {
        org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation info =
          new org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation(
          );
        info.
          characterIndex =
          startIndex +
            charnum;
        for (int i =
               0;
             i <
               list.
               size(
                 );
             i++) {
            org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun run;
            run =
              (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
                list.
                get(
                  i);
            if (!run.
                  getLayout(
                    ).
                  hasCharacterIndex(
                    info.
                      characterIndex))
                continue;
            info.
              layout =
              run.
                getLayout(
                  );
            aci.
              setIndex(
                info.
                  characterIndex);
            if (aci.
                  getAttribute(
                    ALT_GLYPH_HANDLER) !=
                  null) {
                info.
                  glyphIndexStart =
                  0;
                info.
                  glyphIndexEnd =
                  info.
                    layout.
                    getGlyphCount(
                      ) -
                    1;
            }
            else {
                info.
                  glyphIndexStart =
                  info.
                    layout.
                    getGlyphIndex(
                      info.
                        characterIndex);
                if (info.
                      glyphIndexStart ==
                      -1) {
                    info.
                      glyphIndexStart =
                      0;
                    info.
                      glyphIndexEnd =
                      info.
                        layout.
                        getGlyphCount(
                          ) -
                        1;
                }
                else {
                    info.
                      glyphIndexEnd =
                      info.
                        glyphIndexStart;
                }
            }
            return info;
        }
        return null;
    }
    protected static class CharacterInformation {
        org.apache.batik.gvt.text.TextSpanLayout
          layout;
        int glyphIndexStart;
        int glyphIndexEnd;
        int characterIndex;
        public boolean isVertical() { return layout.
                                        isVertical(
                                          );
        }
        public double getComputedOrientationAngle() {
            return layout.
              getComputedOrientationAngle(
                characterIndex);
        }
        public CharacterInformation() { super(
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
           "i/0aAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "NGKdJeulXtIklgzVa3H9ZTdzyuWBMB75MNyKAL1xupqUhgmjxapa39bQbbSO" +
           "thgV6ZKEhEhQaeBqws+2leawm8F9corFiVgPtEFVqPc2g9CoCLWI7gQorqP0" +
           "rAcjvJUkC2sCD0lM784VQtdLXbKTJJ2eLdd6vVJr2W5P+HRoubPVqjdquv6g" +
           "CrJTxlyWOaE+oY10KQhNebEgA8RhWpxe6aCI440m23K8GGqq1g+VKKyUZY3z" +
           "bayezk1vhI4b1dgwtbEy4jcSprPbiBsFJNnQ/GV9NJ4Rg1m1nqgZNhqrpSZN" +
           "+FuOMhcITJhwFg+sQY3oYHWvlPYwEgAsicTpciVJcUwtaLhcXzu9tVdmg/V4" +
           "FvjzlUuyA9IpUQpZnmGRsukbTWyRucssSpUOC0KzB1gedaOaWZFwkl2hLrNm" +
           "M2uZEaOeb0X+sKKw+rhBVc1JqDAq462G7oQr62Z9HGJu2uCHG8fOYKSeKstR" +
           "m7S9VoNB6lLaXDAdjFnwSR/1rVWVwbNgMKVVvSlgG7qGmFu0yZtWNx1FygBZ" +
           "zMIOcLIm3hkOaxsz6UjqYhZlFb7kTvr9ubOus9QkqTsO4RC0NVHdLCmlcJNN" +
           "B4OZ27UExUjrg8YcjVvleGM1+azSoXXHKqupV2sC8SwvZZcm7qBNXW3zUW1h" +
           "+hlCV2gK32bj6WwV0t1OnDUoJGC8KhzBizDolyYzQeErC96YSTNdFfubuOzO" +
           "dSNeM9RmFhuGrGKNJppoqCb2zZlD9YOl0UAJXBCdLhwv40nbDeZIU+zx0lho" +
           "lLbTBrVmE4XO1qOMN10kbVpVNxCDgeQxrWnUbypsLwFKtaYtaUC2a2yFFUhT" +
           "SvyyQK+MykJEWbybKFtko451ZeMmRKRXeyLHd1Y8OUWTlIxFYuQZdb/U5umF" +
           "sxHa5TrT2ig6a1tzzy13qRrldQCgDRKnU2vMqrYaN3CftifkNFObnbBXnZPl" +
           "rhFmaE2trZkB32edRTUo1WIha7Xl5crxpdQkBotyEmhaZPEzeePCZIa0a0gL" +
           "mbgzq7ZV1x2TRvRGaSSWpEqXGtJIRCNg13U6EdOEDcAR4bqlps+rRFrP1FRX" +
           "x7UVMg6ccac8Ezc1RWFVmKrZKtI3W8GAIyqeLJVMzcnA7lQeDAWKEdeOntSE" +
           "KEZCuBb75dUGzWJGFYdk1LSkauxuUHKt2DWTlYaCwDDj0kzh2HBo1vysjKvL" +
           "NEEGodckh4vZsj7ZDs2xue2scXzs89iY182BFLGa2VzM5aHZL6H0wLaFMi5V" +
           "plMrRb1mU6YTdsggmlNFKKfZFmucF6FVnuI5T95WabVLKHRPo1ejeGHq5kSx" +
           "m0qZIVpsyjpe2/TTdrItE1pJ7E/pddyY9rNRKRnEA0SHhdGkVOltSvJI5SQK" +
           "tZBFCcsSvklvEATuji2vgbDooOxh5XZHnQozbT2fleWOPkW6esKbGYJqSVk1" +
           "Z+02vHBiE5YtBTfTjMyYLBlnUpo5pfncncmrKGm5vSALFWS+XFS9edqma3o9" +
           "7Kv0UE26pLJO5Gq93Rq327StwnQ0rtPMphZmDMGsRhWXn099blNutSJJjIUB" +
           "Mqs4NQ6myca00gHo2GutyXTha7iLeKX6bD4Qlv2lukHYmFMFLyxXtcZIMmpD" +
           "t0dZiIKIGblpzitaJVy3qrO0ESNtrRaL5mhtDrIoUkac57ZrRnkotklxpaK0" +
           "Ac6HHALie9WZ8rVMYkhu3A4iemBIbKXa1oi1X6N6tt8oqWhF21Y7VK/Hc5Pq" +
           "asmtJ1uq4608Yg3jcsV2lEXmtMi0JdO9lbloBgmDamwpJJOGaPrVkaQvup3N" +
           "tLacK4te1adgBbHaNbeMYEm5WUGCznxJlDYpTlXpoCVR2LyhLnpq1VtVV8RS" +
           "TqOa7nMKVrMx1VU1eLQRK57lwkqi6yMFzJY4skK5pbrON31jGcd4yR6E2ylf" +
           "dZK5RyarbaaZgTub44iHjFiUCXwurE62k3q4XNgiX0Y1jUEyHh9U+JnXYhxj" +
           "Mel4i4Flcau+WPM6vNyetHtm3G6jozk2xxYDLR5hNO1vQHauWk4rlMdLQq75" +
           "Zc+OzFZd2oqOYQjpBoVJih+U64tWN5RXAd528FJFG6lOt5m29aRB94NpCIKy" +
           "Xfb1xGJcbjTTZQKkuTZhTLDayBfmLKZQFFgr4ODW2ByLJtmorRO2J48HVcRt" +
           "ToF4A5fvbiMYY6abjFTmZAveqH4bZSnRDvSggw/EcRiQujzcLgRzTbHSNq2I" +
           "absxWkS4NSQVZtprw316Ffax2aZlgIxGUbzRuIq13Bo7x0H6SzF0nx61bIKj" +
           "uqg+bJaCMd+eT1oxLjKb3qYLNsZ5Vq9NHQEvE6hURhE+ktYTXYnJCb7a4DUk" +
           "QOvSAhlmlhyrG2ylbvqLFY81HZCVaoGA0tu2xQ3RysKxfV5YiFQVmW/sbkra" +
           "5XDRadGzqLJsWugg1KOmUZIEkWBcMQRbGOm2mlGY+Uq7ayHTYUnoVQmyOVMl" +
           "EhdYgXOzqo7QS3A0EBC3JlfpHl9ZcXRIIG1Hzsx+tenaJcXt1SM+6wEAlmJr" +
           "FU/kRVuYsAaziuXNYkWtFyHIhsHBZLUejSc1lF13sb4zXYiVBcFVKE1stCdI" +
           "e4mss1FG4gt8mR8pNxQylMox1aaWQUUkF47aaVdEe1YzFdensXQ0K2fJpO1t" +
           "zXJrKU14rYyjcM+bYiSLlGybTpfLqoTYegg3hwamyoSOqK3udj0jDbgsgFPk" +
           "W/Lj5aMv7dh7e3HCP3wTBafdvMN5CSfb9NoL7kXQzX7gRYoUKcX1ipkeXpcU" +
           "Vx6vfIEXh2O3slB+I/Xa6z2EFrdRz77nyWdk6mOVvf17FDaCzu+/Tx/R2QNk" +
           "3nj9a7dJ8Qh8dMX6xff8092zt+rveAmPSPedYvI0yd+ZPPflweulX9mDzh5e" +
           "uF71PH1y0iMnr1lvCZQoBrB14rL1tYdqvStX1wNAnU/uq/XJ07dQR2a9yl5n" +
           "CgfZucULvBQ89QJ9H86LJ6L8+nmuBJEhCfa1rk5uFD3PVgT3yL0++GIXJ8dX" +
           "Khp+6VDoO/PGChD26X2hn/6/F/rZF+j7zbz49Qh6jaZE+U1ZDNydCgzF3flL" +
           "x9Vs5VpaOC97sbjfVSjhN16KEtIIeuW1nlcPLube9FIeakFkvPqq34PsfsMg" +
           "ffKZCzfd9Qz3l8Wr5OHvDG4moJvU2LaPPwEcq5/3A0U1CvXcvHsQ8IuPz0TQ" +
           "XddhDChkVykk+N3d+M9G0MXT4yPoXPF5fNzngM8djQOkdpXjQz4fQWfBkLz6" +
           "B/41ri93LyHpmZPIc2icO17MOMfA6qETKFP8HucAEeLdL3KuSJ96ZkS+8/vN" +
           "j+0eTSVbyLKcyk0EdOPu/fYQVR64LrUDWueHD//wtk/f/LoD+Lttx/CR2x/j" +
           "7b5rv0r2HT8q3hGzz931e2/+rWe+Udym/jfhgk6kKCUAAA==");
    }
    public java.util.Set getTextIntersectionSet(java.awt.geom.AffineTransform at,
                                                java.awt.geom.Rectangle2D rect) {
        java.util.Set elems =
          new java.util.HashSet(
          );
        org.apache.batik.gvt.TextNode tn =
          getTextNode(
            );
        java.util.List list =
          tn.
          getTextRuns(
            );
        if (list ==
              null)
            return elems;
        for (int i =
               0;
             i <
               list.
               size(
                 );
             i++) {
            org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun run;
            run =
              (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
                list.
                get(
                  i);
            org.apache.batik.gvt.text.TextSpanLayout layout =
              run.
              getLayout(
                );
            java.text.AttributedCharacterIterator aci =
              run.
              getACI(
                );
            aci.
              first(
                );
            java.lang.ref.SoftReference sr;
            sr =
              (java.lang.ref.SoftReference)
                aci.
                getAttribute(
                  TEXT_COMPOUND_ID);
            org.w3c.dom.Element elem =
              (org.w3c.dom.Element)
                sr.
                get(
                  );
            if (elem ==
                  null)
                continue;
            if (elems.
                  contains(
                    elem))
                continue;
            if (!isTextSensitive(
                   elem))
                continue;
            java.awt.geom.Rectangle2D glBounds =
              layout.
              getBounds2D(
                );
            if (glBounds !=
                  null) {
                glBounds =
                  at.
                    createTransformedShape(
                      glBounds).
                    getBounds2D(
                      );
                if (!rect.
                      intersects(
                        glBounds)) {
                    continue;
                }
            }
            org.apache.batik.gvt.font.GVTGlyphVector gv =
              layout.
              getGlyphVector(
                );
            for (int g =
                   0;
                 g <
                   gv.
                   getNumGlyphs(
                     );
                 g++) {
                java.awt.Shape gBounds =
                  gv.
                  getGlyphLogicalBounds(
                    g);
                if (gBounds !=
                      null) {
                    gBounds =
                      at.
                        createTransformedShape(
                          gBounds).
                        getBounds2D(
                          );
                    if (gBounds.
                          intersects(
                            rect)) {
                        elems.
                          add(
                            elem);
                        break;
                    }
                }
            }
        }
        return elems;
    }
    public java.util.Set getTextEnclosureSet(java.awt.geom.AffineTransform at,
                                             java.awt.geom.Rectangle2D rect) {
        org.apache.batik.gvt.TextNode tn =
          getTextNode(
            );
        java.util.Set elems =
          new java.util.HashSet(
          );
        java.util.List list =
          tn.
          getTextRuns(
            );
        if (list ==
              null)
            return elems;
        java.util.Set reject =
          new java.util.HashSet(
          );
        for (int i =
               0;
             i <
               list.
               size(
                 );
             i++) {
            org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun run;
            run =
              (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
                list.
                get(
                  i);
            org.apache.batik.gvt.text.TextSpanLayout layout =
              run.
              getLayout(
                );
            java.text.AttributedCharacterIterator aci =
              run.
              getACI(
                );
            aci.
              first(
                );
            java.lang.ref.SoftReference sr;
            sr =
              (java.lang.ref.SoftReference)
                aci.
                getAttribute(
                  TEXT_COMPOUND_ID);
            org.w3c.dom.Element elem =
              (org.w3c.dom.Element)
                sr.
                get(
                  );
            if (elem ==
                  null)
                continue;
            if (reject.
                  contains(
                    elem))
                continue;
            if (!isTextSensitive(
                   elem)) {
                reject.
                  add(
                    elem);
                continue;
            }
            java.awt.geom.Rectangle2D glBounds =
              layout.
              getBounds2D(
                );
            if (glBounds ==
                  null) {
                continue;
            }
            glBounds =
              at.
                createTransformedShape(
                  glBounds).
                getBounds2D(
                  );
            if (rect.
                  contains(
                    glBounds)) {
                elems.
                  add(
                    elem);
            }
            else {
                reject.
                  add(
                    elem);
                elems.
                  remove(
                    elem);
            }
        }
        return elems;
    }
    public static boolean getTextIntersection(org.apache.batik.bridge.BridgeContext ctx,
                                              org.w3c.dom.Element elem,
                                              java.awt.geom.AffineTransform ati,
                                              java.awt.geom.Rectangle2D rect,
                                              boolean checkSensitivity) {
        org.apache.batik.dom.svg.SVGContext svgCtx =
          null;
        if (elem instanceof org.apache.batik.dom.svg.SVGOMElement)
            svgCtx =
              ((org.apache.batik.dom.svg.SVGOMElement)
                 elem).
                getSVGContext(
                  );
        if (svgCtx ==
              null)
            return false;
        org.apache.batik.bridge.SVGTextElementBridge txtBridge =
          null;
        if (svgCtx instanceof org.apache.batik.bridge.SVGTextElementBridge)
            txtBridge =
              (org.apache.batik.bridge.SVGTextElementBridge)
                svgCtx;
        else
            if (svgCtx instanceof org.apache.batik.bridge.SVGTextElementBridge.AbstractTextChildSVGContext) {
                org.apache.batik.bridge.SVGTextElementBridge.AbstractTextChildSVGContext childCtx;
                childCtx =
                  (org.apache.batik.bridge.SVGTextElementBridge.AbstractTextChildSVGContext)
                    svgCtx;
                txtBridge =
                  childCtx.
                    getTextBridge(
                      );
            }
        if (txtBridge ==
              null)
            return false;
        org.apache.batik.gvt.TextNode tn =
          txtBridge.
          getTextNode(
            );
        java.util.List list =
          tn.
          getTextRuns(
            );
        if (list ==
              null)
            return false;
        org.w3c.dom.Element txtElem =
          txtBridge.
            e;
        java.awt.geom.AffineTransform at =
          tn.
          getGlobalTransform(
            );
        at.
          preConcatenate(
            ati);
        java.awt.geom.Rectangle2D tnRect;
        tnRect =
          tn.
            getBounds(
              );
        tnRect =
          at.
            createTransformedShape(
              tnRect).
            getBounds2D(
              );
        if (!rect.
              intersects(
                tnRect))
            return false;
        for (int i =
               0;
             i <
               list.
               size(
                 );
             i++) {
            org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun run;
            run =
              (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
                list.
                get(
                  i);
            org.apache.batik.gvt.text.TextSpanLayout layout =
              run.
              getLayout(
                );
            java.text.AttributedCharacterIterator aci =
              run.
              getACI(
                );
            aci.
              first(
                );
            java.lang.ref.SoftReference sr;
            sr =
              (java.lang.ref.SoftReference)
                aci.
                getAttribute(
                  TEXT_COMPOUND_ID);
            org.w3c.dom.Element runElem =
              (org.w3c.dom.Element)
                sr.
                get(
                  );
            if (runElem ==
                  null)
                continue;
            if (checkSensitivity &&
                  !isTextSensitive(
                     runElem))
                continue;
            org.w3c.dom.Element p =
              runElem;
            while (p !=
                     null &&
                     p !=
                     txtElem &&
                     p !=
                     elem) {
                p =
                  (org.w3c.dom.Element)
                    txtBridge.
                    getParentNode(
                      p);
            }
            if (p !=
                  elem)
                continue;
            java.awt.geom.Rectangle2D glBounds =
              layout.
              getBounds2D(
                );
            if (glBounds ==
                  null)
                continue;
            glBounds =
              at.
                createTransformedShape(
                  glBounds).
                getBounds2D(
                  );
            if (!rect.
                  intersects(
                    glBounds))
                continue;
            org.apache.batik.gvt.font.GVTGlyphVector gv =
              layout.
              getGlyphVector(
                );
            for (int g =
                   0;
                 g <
                   gv.
                   getNumGlyphs(
                     );
                 g++) {
                java.awt.Shape gBounds =
                  gv.
                  getGlyphLogicalBounds(
                    g);
                if (gBounds !=
                      null) {
                    gBounds =
                      at.
                        createTransformedShape(
                          gBounds).
                        getBounds2D(
                          );
                    if (gBounds.
                          intersects(
                            rect)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static java.awt.geom.Rectangle2D getTextBounds(org.apache.batik.bridge.BridgeContext ctx,
                                                          org.w3c.dom.Element elem,
                                                          boolean checkSensitivity) {
        org.apache.batik.dom.svg.SVGContext svgCtx =
          null;
        if (elem instanceof org.apache.batik.dom.svg.SVGOMElement)
            svgCtx =
              ((org.apache.batik.dom.svg.SVGOMElement)
                 elem).
                getSVGContext(
                  );
        if (svgCtx ==
              null)
            return null;
        org.apache.batik.bridge.SVGTextElementBridge txtBridge =
          null;
        if (svgCtx instanceof org.apache.batik.bridge.SVGTextElementBridge)
            txtBridge =
              (org.apache.batik.bridge.SVGTextElementBridge)
                svgCtx;
        else
            if (svgCtx instanceof org.apache.batik.bridge.SVGTextElementBridge.AbstractTextChildSVGContext) {
                org.apache.batik.bridge.SVGTextElementBridge.AbstractTextChildSVGContext childCtx;
                childCtx =
                  (org.apache.batik.bridge.SVGTextElementBridge.AbstractTextChildSVGContext)
                    svgCtx;
                txtBridge =
                  childCtx.
                    getTextBridge(
                      );
            }
        if (txtBridge ==
              null)
            return null;
        org.apache.batik.gvt.TextNode tn =
          txtBridge.
          getTextNode(
            );
        java.util.List list =
          tn.
          getTextRuns(
            );
        if (list ==
              null)
            return null;
        org.w3c.dom.Element txtElem =
          txtBridge.
            e;
        java.awt.geom.Rectangle2D ret =
          null;
        for (int i =
               0;
             i <
               list.
               size(
                 );
             i++) {
            org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun run;
            run =
              (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
                list.
                get(
                  i);
            org.apache.batik.gvt.text.TextSpanLayout layout =
              run.
              getLayout(
                );
            java.text.AttributedCharacterIterator aci =
              run.
              getACI(
                );
            aci.
              first(
                );
            java.lang.ref.SoftReference sr;
            sr =
              (java.lang.ref.SoftReference)
                aci.
                getAttribute(
                  TEXT_COMPOUND_ID);
            org.w3c.dom.Element runElem =
              (org.w3c.dom.Element)
                sr.
                get(
                  );
            if (runElem ==
                  null)
                continue;
            if (checkSensitivity &&
                  !isTextSensitive(
                     runElem))
                continue;
            org.w3c.dom.Element p =
              runElem;
            while (p !=
                     null &&
                     p !=
                     txtElem &&
                     p !=
                     elem) {
                p =
                  (org.w3c.dom.Element)
                    txtBridge.
                    getParentNode(
                      p);
            }
            if (p !=
                  elem)
                continue;
            java.awt.geom.Rectangle2D glBounds =
              layout.
              getBounds2D(
                );
            if (glBounds !=
                  null) {
                if (ret ==
                      null)
                    ret =
                      (java.awt.geom.Rectangle2D)
                        glBounds.
                        clone(
                          );
                else
                    ret.
                      add(
                        glBounds);
            }
        }
        return ret;
    }
    public static boolean isTextSensitive(org.w3c.dom.Element e) {
        int ptrEvts =
          org.apache.batik.bridge.CSSUtilities.
          convertPointerEvents(
            e);
        switch (ptrEvts) {
            case org.apache.batik.gvt.GraphicsNode.
                   VISIBLE_PAINTED:
            case org.apache.batik.gvt.GraphicsNode.
                   VISIBLE_FILL:
            case org.apache.batik.gvt.GraphicsNode.
                   VISIBLE_STROKE:
            case org.apache.batik.gvt.GraphicsNode.
                   VISIBLE:
                return org.apache.batik.bridge.CSSUtilities.
                  convertVisibility(
                    e);
            case org.apache.batik.gvt.GraphicsNode.
                   PAINTED:
            case org.apache.batik.gvt.GraphicsNode.
                   FILL:
            case org.apache.batik.gvt.GraphicsNode.
                   STROKE:
            case org.apache.batik.gvt.GraphicsNode.
                   ALL:
                return true;
            case org.apache.batik.gvt.GraphicsNode.
                   NONE:
            default:
                return false;
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "4kkRco1+ApOPggrleGrS6W5d96AmiKAr");
    public static final java.lang.String jlc$ClassType$jl7$1 =
      ("e94J4+zKNwS+N/xTIxOdfBNThF+jGH6N3lYqLhQNIsI6R+jNtIW8TL73RY5U" +
       "VE2Oc4SqWK4hegSTuyY1Qo0GtmpDDcATZfK9P4ZkotKuK7SZYf+GgpdvYfLv" +
       "9ppg0JgwX6TRpuOrAdDBnpmfBVguFpgu9k+HTNSF1vFssNFuTew0rgA2qc+C" +
       "MKp+pKARY7LR45QsFOrlHpkwC2dTel9QASJwG6cdELwcKEFpcYBIKuptu3Mc" +
       "Vhc+12kcHjZSer+ppSzEj8R/npGkiOBGsRlHH+EDX9RD/BiNafHvG/Xp7skn" +
       "bHFVABwWX7kJ575yUzz5JPpLrwm6UCSee8bL33MEfqNBBH5ZRdUCyz8VbP/U" +
       "f0XJROWd7ON2PbyoqIeXMHmOkrmiHlpT8WTaypq6YOxpm5vngwpanQLA3hEA" +
       "31Fww1LHayRsHMO/2uB6oWS2okQXGV7TdQR5+C+bSBz9s4LBv2Lyqs2gU5NZ" +
       "CTaDrwXAIK5eit+LmL6Vl8n3/wgGpSVKe2jnawR42bIyOW9l+N5B9F0em0He" +
       "mtLZFFt5yxEQLCMBBkqniw+TTHd/mOTEGZOVKO2x+WCzbK6Cp/mYzAA3jy/s" +
       "1qenLLbUe6Fulc38RzA1AQ6TV/QNP0W3qOjLwfxrt/EvH5g1deGB859gaxDn" +
       "v0g7PUamDmeTSefH0hy/p2RMfdhgTE9n6Wz2iYGyauhTJXFBSqYM5RdyLVvK" +
       "8y8Xa3k581NSxvbOfCspqbTzQVH8hzPLyZREIAv+XJ3J9SEbZEHK3FcsnAvK" +
       "cbImuLOxxMk1VhGZX6qK8iLOT0yiq8K+7ZxbJDnbI75zcfTA1q7LX33vF/kn" +
       "LuNJbe9eLGVajJTzr22yQiNF38xwlpYra0r7mrdm3luxKrck9Wx+w3ZLWGKr" +
       "JC4JEMqgTix2ff/Rqst/BvKpOzd/7yf7pvwsTEIXk5AG9vHi4u/vTWSyJqm+" +
       "OFb86Yvtmsk+TLlpzaf3nLN++JVfsi8cEv6pjKXy/IPxxw5e+vObFt1ZEybT" +
       "OkiZgS+1sQ8DtuxJ9erxcXMA14xsnWBLAeFSVAXf1ZiJ6qvhKIrxIuickT+K" +
       "C7BTUlv8xYbiz8pWJtO7dZNZNSxmRoxMs4/wmnGtVZ3NZFwC9hFRlZj+Byb3" +
       "sXfrQWMHY52ZTO47HmVHMqwlH/f2c1C1z2I/8dem/weje1d5930AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "2sC4PrQhZFoyxcZk3SaqEWMg64UQ4G2y");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "dwCwv7gD/clLlepDzV6546uetq1Z2Q5+pLaRj/Y8ync1zLnA7eHQPEvoo85w" +
       "WNNRLaBr2OptnWF0UW5lIvL5Hbc+/5xw6w23cUv0/RuyrWq2fANl2W7+63hE" +
       "FPYwScmStweFF22ZdGvpU6x51n3unq33tABLvrZjzdcuW08U/igH5O4Bm80i" +
       "OTCARX8EduQ5+dbjZ8vCs+5H92yAnwId+9u2ZbfniwM+ief799z7gSyJgux9" +
       "YB6F2247cxJdfAF0+Y5sLwOo3rxD9+ZzoCvcVTz14L170L0vS34EiC3wXXch" +
       "YzbgvaBvb6NVhT86xvnui+J8AuBDdjiRy8f5wT04P5wlPw60/DHOri2dhfID" +
       "F0CZbf6chY+vcjuU3OXI6pk+y8HP7MH7P2TJR4LCi7cye8Ymdz9xDPmjF+2e" +
       "fQDV3kG+bdPWbw3yfXmG+9YnR/OdBQI096vOfI2Xb+iXDdyj3bbz/Tz/R4+I" +
       "zXGUAJG7/Ve355PEHj7gBceb1G03pzv4pcNb6Lk21jrNeiRUFNnL2+gTe9ov" +
       "ix0e/BxwsBTNNM+u45QW+vgFGvHF2cWnC4VrT27Lbs8Xb8Rjk2w79SXfq+uT" +
       "OcA9gcSDLJB48KtB4SE734JdS+VjsT2e3nBwkfjhS3aI77m2Lbs9X2pP/cj6" +
       "yObeExA8+O0s+VxQeNAGnmQ7m+UQOB6tHIt7jvXCkUBQ7p4X77A+eumt+xOH" +
       "XfTKd+Wg/nAP4C9lye8D0eYlqWcm7urwCxVHYu6fEu0vXhR8F4D+sR34H33O" +
       "wf/pHvBZNzj446DwVBY6y+IHd8eBL1+Cv3XPz+w48NHL4cA9eYZ7buVA5VBL" +
       "3j7p7JSG1mxgZORfCtmx7a/3sC2LOB78JRi+Advyonfk1F9dlFNvAZh+acep" +
       "cztp5+FURu1Xj+HviUBezWg4+M9B4bFDqdnPg4uEIA/f/N7zGzse/MZl95fd" +
       "eH5qaM5Np1eB5+1cvnvOcvkOfilPcp7sCU9ezcKTV+/ZTgTJ9m7N3jScel7e" +
       "1o/sw3koyQ+e/O5C/o2Kq48c8frqReKa");
    public static final java.lang.String jlc$ClassType$jl5$2 =
      ("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");
}
