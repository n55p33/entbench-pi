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
           "jtteVKS2sz984Pff+tvPf7tIr/0vApvk9ccfAAA=");
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
           "9of3//5bfvv57xSVtf8FFINxp8EfAAA=");
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
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAALUZC2wcxXXu/I0TfxM7wUmcxHGI8ukdUChQA8UxceL0nLix" +
           "cdsL4bK3N2dvvLe77M7ZZ1O3gKhIixqlNARoIRJSIHwCQS1RoXyUlhaIoFX5" +
           "tEARHxXa8hVJEdCWtvS9md3b271PZFFHytx45r038/7vzR56n1RYJmmjGgux" +
           "CYNaofUa65dMiya6VcmyBmEtJt9QJn146Vubzw2SyiipG5GsPlmyaI9C1YQV" +
           "JYsVzWKSJlNrM6UJxOg3qUXNMYkpuhYlzYrVmzJURVZYn56gCDAkmRHSKDFm" +
           "KvE0o702AUYWR+AmYX6TcJd/uzNC5si6MeGCL8gB787ZQciUe5bFSENkpzQm" +
           "hdNMUcMRxWKdGZOsMXR1YljVWYhmWGinepYtgk2Rs/JE0H5f/cef7hlp4CKY" +
           "K2mazjh71lZq6eoYTURIvbu6XqUp6zLybVIWIbNzgBnpiDiHhuHQMBzqcOtC" +
           "we1rqZZOdeucHeZQqjRkvBAjy7xEDMmUUjaZfn5noFDNbN45MnC7NMut4DKP" +
           "xevXhPfecGnDT8tIfZTUK9oAXkeGSzA4JAoCpak4Na2uRIImoqRRA2UPUFOR" +
           "VGXS1nSTpQxrEkuD+h2x4GLaoCY/05UV6BF4M9My080se0luUPZfFUlVGgZe" +
           "W1xeBYc9uA4M1ihwMTMpgd3ZKOWjipZgZIkfI8tjx1cBAFCrUpSN6NmjyjUJ" +
           "FkiTMBFV0obDA2B62jCAVuhggCYjrUWJoqwNSR6VhmkMLdIH1y+2AGoWFwSi" +
           "MNLsB+OUQEutPi3l6Of9zeftvlzbqAVJAO6coLKK958NSG0+pK00SU0KfiAQ" +
           "56yO7JNaHtkVJASAm33AAubn3zpx4dq2o08KmIUFYLbEd1KZxeQD8bpnFnWv" +
           "OrcMr1Ft6JaCyvdwzr2s397pzBgQYVqyFHEz5Gwe3fr4N6+4i74bJDW9pFLW" +
           "1XQK7KhR1lOGolJzA9WoKTGa6CWzqJbo5vu9pArmEUWjYnVLMmlR1kvKVb5U" +
           "qfO/QURJIIEiqoG5oiV1Z25IbITPMwYhpBn+k1ZCyqOE/xO/jMTCI3qKhiVZ" +
           "0hRND/ebOvJvhSHixEG2I+E4WP1o2NLTJphgWDeHwxLYwQi1N+Kmkhim4YGh" +
           "DYPgPxgRAHMdXwyhoRkzf0QGuZw7HgiAAhb53V8Fz9moqwlqxuS96XXrT9wb" +
           "e0qYFrqDLR9GuuHUkDg1xE8NiVNDhU7tyMbshPCgdekkmCIJBPgd5uGlhAGA" +
           "+kYhEEAknrNqYPumHbvay8DyjPFykD2CtnsyUrcbLZwQH5MPN9VOLnv19MeC" +
           "pDxCmiSZpSUVE0yXOQyhSx61vXtOHHKVmzKW5qQMzHWmLtMERKxiqcOmUq2P" +
           "URPXGZmXQ8FJaOi64eLppOD9ydEbx68c+s5pQRL0Zgk8sgICHKL3Y2zPxvAO" +
           "f3QoRLf+mrc+PrxvSnfjhCftONkyDxN5aPdbiV88MXn1UulI7JGpDi72WRDH" +
           "mQR+ByGyzX+GJwx1OiEdeakGhpO6mZJU3HJkXMNGTH3cXeHm28jn88As6tEv" +
           "V4CDWraj8l/cbTFwnC/MHe3MxwVPGecPGLe8+Lu3v8jF7WSX+pyyYICyzpyI" +
           "hsSaeOxqdM120KQU4F65sf9H179/zTZuswCxvNCBHTh2QyQDFYKYv/vkZS+9" +
           "9uqB54OunTNI6ek4VEaZLJPVyFNdCSbhtFPd+0BEVCFkoNV0XKyBfSpJRYqr" +
           "FB3r3/UrTj/y3u4GYQcqrDhmtPbkBNz1U9aRK5669JM2TiYgY0Z2ZeaCiTA/" +
           "16XcZZrSBN4jc+Wzi296QroFEgYEaUuZpDzuEi4DwpV2Fuf/ND6e6ds7G4cV" +
           "Vq7xe/0rp3KKyXueP147dPzRE/y23tIrV9d9ktEpzAuHUzNAfr4/OG2UrBGA" +
           "O/Po5ksa1KOfAsUoUJQhEltbTAibGY9l2NAVVX/65WMtO54pI8EeUqPqUqJH" +
           "4k5GZoF1U2sEIm7G+MqFQrvjqO4GzirJYz5vAQW8pLDq1qcMxoU9+cD8+887" +
           "uP9VbmWGoLGQ45djEvBEVV7Au45913Nn/+HgD/eNixJgVfFo5sNb8K8tavyq" +
           "P/8jT+Q8jhUoT3z40fChm1u7L3iX47sBBbE7MvmJC4Kyi3vGXamPgu2VvwmS" +
           "qihpkO2CeUhS0+imUSgSLaeKhqLas+8t+ER105kNmIv8wSznWH8ocxMmzBEa" +
           "57W+6NWEKlwCaojZjh3zR68A4ZNejrKSj6tx+IITLGYZps7gljThixeNJcgy" +
           "UmXxVGyB/he7+sfMNZCOW2yrNM6LzJh8ycqGlo5zP2wXBtBWADanGt390C+i" +
           "0ZUNsgBuL0TYW4XecbBafjn1+JsC4ZQCCAKu+Y7wD4Ze2Pk0j9PVmLwHHZHm" +
           "pGZI8jlJoiErjzpiy/pOIQ/xy8gln7PUAjRosZQUCDI8qKRowq57nFJuRunz" +
           "8ORxXVdpd4+qXR+cc/v5QqzLinitC//g115/5pbJw4dEVkDxMrKmWFOa3wlj" +
           "kbCiRKHjGshHG7589O03hrYH7Theh8PFwnIXMFKXG25FatqejXiBbB04z2sn" +
           "gvRF36t/eE9TWQ+UIL2kOq0pl6Vpb8LriFVWOp5jOG7z5TqnbTWfwb8A/P8v" +
           "/kdrwQVhNU3ddiOyNNuJQFDFfUYCq2EqKg4cz8Fhk2Cvs2h87/bGg3Zw2ITt" +
           "uIki8UDY+UocIvluXwybkZrs8wrHGvRddWSaV10Ehyj2YUqRq2olr1oMm5EK" +
           "WU9rzCocRvpN8AqmjNm6P6N/h7yro/9Nx6wGcIijh5TIWD4a4amm10Zvfuse" +
           "O9Dl1bweYLpr7/c/C+3eKxxGPDEsz+vyc3HEM4MwseztlpU6hWP0/O3w1EN3" +
           "TF0jbtXkbZjXa+nUPX/8z9OhG18/VqBLK1PsZ6Ic78E/Jb+F6tNU+2JQmGYr" +
           "Tiui9itKqr0YNhS/KtWGRSvOfNe8ssQ1M4UTZBCnfUDV4u9WborkxdM8f4Of" +
           "W1K7RRJBVS0u9gbD1XTgqr37E1tuO90xwEk40n4ac+lUe5MtROw+/uTkVi6v" +
           "1F33xoMdw+um073iWttJ+lP8ewnYz+ri3uC/yhNXvdM6eMHIjmk0okt8IvKT" +
           "vLPv0LENp8rXBfn7miip8t7lvEid3vhdY1KWNjVvxF6eVep8VFYbKHPKVuqU" +
           "3zhdi+KWuSa/xSqGWqIZuanE3k9w2Av1lmLxcpwDWXYAwJ90znwC4OK6rlJJ" +
           "K+y3ri9cfzKXLd004EKXwdf3ZGUwF/dOAd6vtmVw9fTFVwy1hIjuLrF3Dw63" +
           "e6OCK4SDMyAE/qCwBji41ubk2ukLoRiqj9GgCFFO8dPAix9sPELinYxv9Hur" +
           "WAie5HVBXvzi7hAn/3XB4jdweDhbUtW6JRV0orj4aGHb4nw9UEIXv8LhZ6AL" +
           "yTColihkveVjupJw9XP/TBkp+vg+W8j7pq+fYqglmP99ib1ncXiKkdnDlEUk" +
           "aIhGJNNnqU/PlKUuBTZutdm5dfqSKIZagttXSuy9hsOLUGZid2n0KKao4X/t" +
           "CuKlmRIEdtFHbG6OTF8QxVBLMPtOib33cPgLdOdcEGgUPjn8dQbksBT3zgAm" +
           "jtnMHJu+HIqhluD1kxJ7/8Th79AzMd3/FcAJUK08QOHnxFBBEC6uD2dAXC24" +
           "h5HkuM3z8emLqxhqcZEEKkvsVeMQYKSa6UICCPRgVgyB4P9DDBlGWgp/knFU" +
           "snY6n3egqF2Q9xVZfPmU791fXz1//8Uv8Ho2+3VyDlSmybSq5r6Q5cwrDZMm" +
           "FS78OeK9jLfUgSZG5he5GCQlMUEOAjZ8M6RUPzy0lfw3Fw4YrnHheH7DSS7I" +
           "QmimAASni4wC+Vo8FGYC3qYha73NJ1NbTp+x3FOi86/4Tjmd7refaw7v37T5" +
           "8hNfuk18tZBVaXISqcyOkCrxASVbki8rSs2hVblx1ad1981a4XQujeLCrukv" +
           "zHHnLqgWDHxxbvU96Vsd2Zf9lw6c9+hvd1U+Cw3pNhKQGJm7Lf9JNWOkoRfa" +
           "Fsl/yIH2hX9r6Fz144kL1iY/eJk/WhPx8LOoOHxMfv7g9ueuW3CgLUhm95IK" +
           "aMpohr/1XjShbaXymBkltVCEZ+CKQEWRVM8rUR0ap4SuwOVii7M2u4rfvBhp" +
           "z2/x878U1qj6ODXX6WktgWRqoX1yV5zWzNPVpKGg8iK4K7YqcdyBQzyD2gB7" +
           "jEX6DMN5lap40eDeLRWu7dBww3yKs9P+BydW+0XhIwAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "OZM5vudcylddNz5Oz5LJ0W2KL7405n7y");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("1fYvHm6EqbZcFOUoVxnoyuFy2kmK9+47jnY81v3D93334V974LnjXPThA8On" +
           "9nyGt6dvf/2qyp3KmxLFbzz+6z/6Sy99vToT/X/gipRfBy4AAA==");
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
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "r/NHfLrhv9kvK1Q9JgAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "4FxaZIIQmgbvfs/OuDa5tV0toEI3gd/Z5OPFv4tAwLffPrxheSq0jxCP/y3t" +
           "yB/42t/cpIQisN0iAzjVX4Q/82tPdN/1zaL/PsLkvZ9Kb14bQNq471v9Tfd/" +
           "nX/u3n9/HrpPhK4qhzkpLzlJ7rciyMOio0QV5K03tN+YU+0SiBePI+hbTke3" +
           "E8Oejm37NQk859T58+VT4ezhXMtV4OFfOvT0L50OZ+eg4qFfdHm2KK/lxY8d" +
           "RY/7g9CPgZSaehhAfgg+58D3/+TfnF1esUsQHu4eZinPHKcpAVgwL+detXOT" +
           "nEN1F0LzspkX2I7xi7e1mPfkxTA9B6S5p3qAHpTz//StJb6QP/4dEPSiIlcH" +
           "PXTLk5xCL8MYeICjXDuSkge5OzCZa7aDHrnv1cLa88k52CW8p2Qd/j/LCqz5" +
           "wT2zsQ9y5w9//aNf/IW3fgWY3BC6Z52bA7C0EyNSSb6d+Eef+diTr3v5qx8u" +
           "YjiYAv79z3/z/TlX8SzEecHkBXsE9YkcKlMkSmMpiski7GpqgfZMT5uElgtW" +
           "p/Vhrgy/9PBXlr/2jd/e5cGn3eoUsfahl3/+hwcfefn8id3HW2/aAJzss9uB" +
           "FEK//lDDIfTsWaMUPbC//OxL//LXX/rgTqqHb8yl+2Cr+Nv/+X9/8eATX/3j" +
           "WyRwFx3/DiY2vvp7g3pEtI8+Y17ShY2SzgSdbiq6ImZ1otWi6xZLD3lBQYhG" +
           "304XZFtN0oFKZ4umQAvIhhGrrTUaZmktaWzpqqr38KXJi/x0NbWZPkWMynZT" +
           "6vSZjk+s/FA3p0I87bYdH5MIvNqhGGtqxDNLJUBd2KhFWYKqVU0uOcNYEmSh" +
           "2ULlqqzJLXSeUeiw2WAVcrlkK7y1QFnBxzSUE8atpWCzms+tBGpqtgiYaInq" +
           "GJtrcHU+Wy4xhVpmK3PZUlbMTI64VSTFC3lIlpmNK7GjSsmyKL/MwAxTWdnL" +
           "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" +
           "j70WeGkMvfmMq5Y5eRVs8R6/6cr37pqy");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("8juvXLn0xle4/1LcODy+Snz/GLqkJ45z8q7Nied7g1DTrUIP9+9u3gQFuHoM" +
           "vfE22TBYgOTjfPhcbUePAoM+TQ+yquL3JN2Px9DlPR1gtXs4SfKTMXQBkOSP" +
           "7wqOFrnS7VLztme5UpzfxQOq2uWy6bmi1+MnzaaImg//qOk4sSF/6w076eI2" +
           "/tGuN9ndx7+ufPaVIfW+7zQ+vbsrqThSluVcLo2h+3bXNgum+c752dtyO+J1" +
           "7+Dt33/wc/c/f7TFf3An8N6ET8j29K0vJvbdIC6uEma/98Z//hP/5JUvF/dv" +
           "/i+j1eVoJjEAAA==");
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
          1471028784000L;
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
           "IxXNlrXuX494h1lRsWZ/hu0znJBIeEDT7GKq4rJmnpS/mzKsnyJfh9XrSQs/" +
           "5+pu8EfW/OM/3EjE5RgeAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
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
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "AAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAALU5bawj11Wzb7ObzTbJbpI2CSHf2RQlrt7YnrHH1ral9nhs" +
           "z4xnPJ4ZfwLdzqdn7PnyfHjGU1LSSpCISqGUtBSpza9WQJV+CFGBhIqCELRV" +
           "K6Siii+JpqqQKLSRmh8URIFyZ/ze83tvd1NFCEu+vr73nHPPOfecc8899+XX" +
           "oHOBDxU819rMLTfc15Jwf2FV9sONpwX7VK/CSX6gqbglBYEIxq4pj3/x0o9+" +
           "/BHj8h50fgbdIzmOG0qh6ToBrwWutdbUHnRpN0pYmh2E0OXeQlpLcBSaFtwz" +
           "g/BqD3rLMdQQutI7ZAEGLMCABThnAW7soADSHZoT2XiGITlhsII+AJ3pQec9" +
           "JWMvhB47ScSTfMk+IMPlEgAKF7L/IyBUjpz40KNHsm9lvk7gjxXgF3/7vZf/" +
           "4Cx0aQZdMh0hY0cBTIRgkRl0u63ZsuYHDVXV1Bl0l6NpqqD5pmSZac73DLo7" +
           "MOeOFEa+dqSkbDDyND9fc6e525VMNj9SQtc/Ek83NUs9/HdOt6Q5kPXenaxb" +
           "CdvZOBDwogkY83VJ0Q5RblmajhpCj5zGOJLxCg0AAOqtthYa7tFStzgSGIDu" +
           "3u6dJTlzWAh905kD0HNuBFYJoQduSjTTtScpS2muXQuh+0/DcdspAHVbrogM" +
           "JYTedhospwR26YFTu3Rsf15j3/nC+52us5fzrGqKlfF/ASA9fAqJ13TN1xxF" +
           "2yLe/nTv49K9X35+D4IA8NtOAW9h/uiXX3/POx5+5atbmJ+9AUxfXmhKeE35" +
           "tHznNx/En6qfzdi44LmBmW3+Cclz8+cOZq4mHvC8e48oZpP7h5Ov8H85ffaz" +
           "2vf3oIskdF5xrcgGdnSX4tqeaWl+R3M0Xwo1lYRu0xwVz+dJ6FbQ75mOth3t" +
           "63qghSR0i5UPnXfz/0BFOiCRqehW0Dcd3T3se1Jo5P3EgyDoTvCF7oGgC69C" +
           "+Wf7G0LXYMO1NVhSJMd0XJjz3Uz+ANacUAa6NWAZWP0SDtzIByYIu/4cloAd" +
           "GNrBhOyb6lyDhVFHBP6TxQeA2cwH9zND8/7/l0gyKS/HZ86ADXjwtPtbwHO6" +
           "rqVq/jXlxahJvP75a1/fO3KHA/2EEAZW3d+uup+vur9ddf9Gq14Rgeltu9CZ" +
           "M/m6b80Y2W462LIlcH4QFm9/Svgl6n3PP34WWJsX3wL0nYHCN4/O+C5ckHlQ" +
           "VIDNQq98Iv7g6FeKe9DeyTCbMQ+GLmboXBYcj4LgldPudSO6l5773o++8PFn" +
           "3J2jnYjbB/5/PWbmv4+fVrPvKpoKIuKO/NOPSl+69uVnruxBt4CgAAJhKAHD" +
           "BTHm4dNrnPDjq4cxMZPlHBBYd31bsrKpw0B2MTR8N96N5Pt/Z96/C+j47syw" +
           "HwQW/t0DS89/s9l7vKx969Zesk07JUUec98leJ/6u7/6FyRX92F4vnTswBO0" +
           "8OqxkJARu5Q7/107GxB9TQNw//gJ7rc+9tpzv5AbAIB44kYLXslaHIQCsIVA" +
           "zb/61dXfv/rtT39rb2c0IXSb57shcBpNTY7kvJCJddcbyAkWfPuOJRBVLEAh" +
           "M5wrQ8d2VVM3JdnSMkP9r0tPlr70gxcub03BAiOHlvSOn05gN/4zTejZr7/3" +
           "3x/OyZxRslNtp7Yd2DZU3rOj3PB9aZPxkXzwrx/6na9InwJBFwS6wEy1PHad" +
           "zdVwNpf8bSH05M18deuSB0f5IfQ73oxnHyLdkyHFiLKvuvb+AURuNnAO8XTe" +
           "7mf6zlmD8jksax4JjrvfSQ8/lvxcUz7yrR/eMfrhn76eK+tk9nTc2hjJu7o1" +
           "8Kx5NAHk7zsda7pSYAA49BX2Fy9br/wYUJwBigoIpkHfB5EvOWGbB9Dnbv2H" +
           "P/vze9/3zbPQXhu6aLmS2pZyN4duA/6lBQYImon38+/ZGlecWdvlXFToOuG3" +
           "Nnn/wS750FM3j3DtLPnZBYn7/7NvyR/67n9cp4Q8tt3gzD+FP4Nf/uQD+Lu/" +
           "n+PvgkyG/XBy/WkAEsUdbvmz9r/tPX7+L/agW2fQZeUgCx1JVpS57gxkXsFh" +
           "agoy1RPzJ7Oobcpw9SiIPng6wB1b9nR4251CoJ9BZ/2LxyPaT8DnDPj+T/bN" +
           "1J0NbM/uu/GDBOLRowzC85IzIF6cK+9j+8UMn8ipPJa3V7Lm57bbFII8O5It" +
           "E3jp+SBPgQGWbjqSlS/eDoGZWcqVwxVGICUG+3JlYWGHPnI5N6lMA/vbPHIb" +
           "VrO2lpPYmsXVm5rQe7ZQ+fl5545YzwUp6Yf/6SPf+I0nXgX7SkHn1pnOwXYe" +
           "W5GNsiz9117+2ENvefE7H85jJQiUo2ef/P6zGVXhJlJnXTprelnDHIr6QCaq" +
           "kOcfPSkImTy2aWou7RuaM+ebNjgF1gcpKPzM3a8uP/m9z23Ty9O2ewpYe/7F" +
           "X//J/gsv7h1L6p+4Lq8+jrNN7HOm7zjQsA899kar5Bjtf/7CM3/ye888t+Xq" +
           "7pMpKgFuYJ/7m//+xv4nvvO1G+RFt1ju/2Fjw9u9LhqQjcNPbzSVy7HCJ2M9" +
           "whi1DLdhCpmRU1NNHLyBoVKF71gti2X5sqzoBtY2k2lsO+l4FKmFSoRiiJpq" +
           "G0WfzHwJjwyvG5OkbIQDVtAnzdGgXBJI3MCLzMojxsl4MDbpuYtPSc7A58S0" +
           "PNi4SqOiIAwWIZrjFV1LXHiV9cxG/KSiI/A6lStxozKR272hOC9OZg4xCapk" +
           "q5ks8JKprtbTeqTNezZRW8YEDHPLutrF4pVh4uHIClplc0oFjLTkJ5jgDD1j" +
           "WY7RGY612/ioV1ksmrRcbDoMy/anAyMoaanhV2crM+DbIjVL5kTIoFIgMEOh" +
           "PJuWxelUaQ7GSbw0BxY19ZFmZYaiK6vNSDV0gRQGCwzWQoVZBWpFZocEV2Mp" +
           "rBnwqVhvG0pQsjhnRdatlcN5k7HID22NH8J+M4nFLrnU6Va7mdTWpW69XF12" +
           "lgPKXnQMm9i4s0p9wZo2t+SGfdpHZnO1uPQnnIsXDKG5CesJkZaaFtJCkaYr" +
           "EmiJnYzduOdJqM1vYEkeGIitrFZxG0cHgzSi7ZE5RVdpa7ZMgRbjlS31sXIj" +
           "lWSz7tLYMBjqHY+Tu+1ZES3rrQJeXamD9VhiFIQYEmSvSY7Y+ZCiWML2kZXp" +
           "8V4JXzQUVKNKYitayGut51OlkOzMFla8LgdjzrNTvDkCoXCKcygVsbQSLxN5" +
           "KKB2Q1lXRx4iKE2rJHPtsmW4bK1rCEFp2YjtgByoteo4sB122HSkdpjwxV43" +
           "xYuNxriuWrgSTQ2Jo1uNWFwRdsckq6zaiZVBUCcbZbuCD9pkR13VKIuNpDjw" +
           "i6nBEovYbCD8Qpnb7sodGIWm1GHnMtXE9bgYSQ0LSQuR2K7WuHiR2MRiQZDz" +
           "oOgOHSWCuwup1EynKrmxcFwTmkh7IXYnNSnEkmrPjQdEp8YQRCR100q1hnbq" +
           "mBCuBc8NV/WGIs5QG18G7qZmV1VMLqv14gQdU8PxSgoVTZlIQnUjM8msqljy" +
           "vNUIm9NKjdFA6DNSrMAreiHBKlpijFpVhk5UPh1PzQUfTJix5/WrzUaCM2Nm" +
           "xfRd0zBW69Jc56P1vC+hM55BNVEaBbE7422hatPLNOkWN8OGISs8O4n95tIr" +
           "IuUyw0RkBdu0CXrV6pW9zoojJcKAK5tSw7QWnZQipyO5Y3Y6fLSgQl1fzLsm" +
           "xXTK9mguuA5anXlBBTeJKVNeVg2T6DMBPxPaFCvOuGmhLw6a/QHHx+K0LCi2" +
           "m6YDn4NhYmJHM50N6MagX256jJ4UNxUM91bowLaYkYLUWqyVUOtNvWVWtdbU" +
           "qHa5WLJ4bewNneZq5BVnkz42ShtLiuNW1ECgNth8EJjOAI1sVF42YSGs8h5c" +
           "YExPSYq82Zr54TwN0uESM1feYI0qg94qdiwmZEOdwfyognHTlEZXc4rebLrq" +
           "qDLU7KWEEquZuqCr1NwpbYRALCMlax4qiGR6RHPGS6tSjE5wn+0MwclDMLLe" +
           "TBUykEVWnpXxkTXSfX4j6XKyEWCdKMoGGviNxSbuDvucnKSm1kZwjEHn5Aru" +
           "hByyrru1kOtV5hprgFzYV3ErSpd9Z0CQG9Z1XFFY82V46Rgld9Sfrger2C53" +
           "SXbaatejxoxXWyJaI9FSdSi0ieqMJcPSOhKliPKsVcvx06k5kHmR62wawK3m" +
           "keyOlzDVF50+PfGx2VTvbEakgi16NN6mmxyyKK05OKpM9HpxnfZLY6vr6XTa" +
           "7I/JGpeIZkq57clihE1Fq4nP+1hdKHO61vc7ZZ4xZ27brJTdrrqmk2690Zs0" +
           "DBsk6vKsXsVUZ1IRQrOnoNKq13GBtvtmZR5WRw5d6tiFBZVs0HLCUPN2o9ta" +
           "JHHfrckETUlCwFKO3lIKjl73nfJa7+KFwVTCWws2ovrlOhOza9hi69VeBxHh" +
           "qj+RGxQtxwOtLKcbXKiySKRoG6etlDZ9uM+tQwdJW3oclBpOY2ZFMhVTEVkj" +
           "GULqVih3VvYHwzWxHCtY0LcQJ0CmfT6SIkmerRV/qE4Y3ijShDjtNplhfepv" +
           "JuVSRBqBKMGTdDrT16KfLlq6XpIGvhVXFE7aDOp6tLGZkZrGBYkNm+2gzgSt" +
           "StAKOKwdtWrd+bSc2PMIUa06TXR0bThWqBhfzP35GikPG9bCMcs90RUqeh2O" +
           "9LVa2VS9IonPC6YUIkTVbIylaXVF9gqkM+goaSnS9WKjU9psuHAuGTSI12tb" +
           "wAuILlc9Il32xtMaN6ktSh6scK2KJ4HrnYlQUzTSUUmvBLQywGzaYi0jhbW2" +
           "lpAdM/QnEhl2hZ5YSCJ6oOnjqi63q5JpRWxDM5cTOGV1BOXXutgNS5InJ6P+" +
           "uBCoGyLkxyXC6xjd0J1rXayuqjDX5/p1tq6W+u1CO8W6msvAWA0cx4YWVV2C" +
           "nzgLU66HoB32J8NJczySY2rWtMKaqmmd0FUROpFb7mI8DGkNJMWpXirQRdoo" +
           "kbgV461VzXKk5YTBNgm6rlQwla+j8FRewIP6uIkM+X6nF1QC1pk08DDoUlRE" +
           "oJ1ij+vP5AEdF3HTSGK4H+PJOuZH/XYPxDeLVEykV64VUHbJ0KV6m/L7Gklw" +
           "HaMct0haRBUjXs3iqbQiKqo4HwZwSmsU7nfH6iz0aXa8GVKG7RDTQhg2i7Lu" +
           "y6VSYajwWFCYc0SFTc1RWug7VmHICIU1vwh7sqkXOJ2qUjS/XvbkeqeFGgWu" +
           "OtExa6UTdDkpInXRLRTWKr6s1TaOxOhh0qS6LQ6zagHFrX02ZqPNVHIFIzAs" +
           "cQlryQDZTK0eFsJTgUwEreO3klZphMKFwKJxYiwLK4ytrVbOuscPJ3VwZnEb" +
           "pDEf0CWMkIS+OhRDtV7WWtyiseotvYEd0lXeUhoCV2q441AZtPpkvTq2GpRe" +
           "ZAZxqam5Mp1IBV2eVwKUJZo07MwpxB66A3NQY5T2BpsItXapBMslqooHzeba" +
           "ovWiLI70bkNI1WHZanos3yggztzpwuu5XlZ5010gXaGCVrSB3MLmUq9ZnOma" +
           "aM8qBXE9q5oobFUUsdCpYpWgHweNqMOyslldmwGrhoXsWcC3eNtctFmz5Qnl" +
           "gtis4XSvjVpqrFTJXpAuybTOYptYVQuahJmT4aJDbEzCFZYVdLKWSRoeFwnf" +
           "cjlaMbtRKYG1gtjjHW6E6PYiKrLwmONQA6/WhZU/XotUZeCnKVyrouCGt+qw" +
           "47TAbMxuReii9Gi8Ls8RrsNIPaaIW8NVfdnS+AYfdYxptyiN+kMGW264lmSk" +
           "o5q06MBEmQzIcJGGPt7r1TyG5XncXFn1TegK9pTCRDY1TI9uGANfrsouP03k" +
           "AUKP2+pinvK8EkntYR0VNyjFlTgMGbSbNpHiiZDU6gVnVuq1o5UI18vMCGtI" +
           "BapFC5jZo/rkwoom+KQ2SoSqTJc2A9YpK26pjzAFG/gtEvIBF1W1vthC17XG" +
           "iKibETIdgRvGu7Krh/rmbn935Rfdo9cTcOnLJvpv4taznXosa548qs/ltZE7" +
           "Tlfcj9fndlUTKLvJPXSzR5H8FvfpD734ktr/TGnvoNp0DVzcD96qdnSyq/TT" +
           "N7+uMvmD0K4E8pUP/esD4ruN972J0vIjp5g8TfL3mZe/1nm78tE96OxRQeS6" +
           "p6qTSFdPlkEu+loY+Y54ohjy0JFaL2XqKgF1vnag1h/cuLx7QxM4k5vAduNP" +
           "VfLOHCjwoLqBXFc2zEqBwXq+33BMOyu19MAduxGGvilHoZaXhXK66RtUCD+Q" +
           "NVEIPWxIjmpph5SOqOBgfK5tzXd2zOjeCy7ia9dUd9a4/ml38BP1uRC6uHuy" +
           "yGbLwE7uv+6ldPu6p3z+pUsX7ntp+Ld55f7oBe62HnRBjyzreMHqWP+852u6" +
           "mUt527Z85eU/z4fQfTepwAIDlndV1+e28B8Oocun4UPoXP57HO4FINMODpDa" +
           "do6D/GYInQUgWfej3uG+km/qoachB6EvKWE2gxumpeadrMDshMmZkw58tDd3" +
           "/7S9OebzT5xw1vyJ+9Cxou0j9zXlCy9R7Ptfr35m+yKhWFKaZlQu9KBbt48j" +
           "R8752E2pHdI6333qx3d+8bYnD6PInVuGdy5zjLdHblz7J2wvzKv16R/f94fv" +
           "/N2Xvp1X3/4XI/PxfHsgAAA=");
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
           "ye/f/7sf+a1Xv5sd+P8X9eUDsfIcAAA=");
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
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "AAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "xIAPMXPZJ6IkEQIv6ves6VBp4RExro0LNbTBClqQBJNAHaruQOZSvmcN4dBs" +
           "KykZG+x6GeHGemy45YWFWXBbJ6bj8izi9ADftAdeUXCKbT0u1ChGr83HmzWv" +
           "WLA8IkNw/5yCG8Y7s6uH/MZuf/fmF92j5xNw6cs6Bm/g1rPtejwrnjrKz+W5" +
           "kbtPp9yP5+d2WRMou8k9fLtXkfwW96kPvvSyPPh0ce8g23QDXNwPHqt2fLKr" +
           "9DO3v67S+YvQLgXy5Q/+y0Pjd+nvfQOp5UdPLfI0y9+lX/kq+TbpI3vQ2aOE" +
           "yE1vVScHXT+ZBrnkK2HkO+MTyZCHj9R6OVNXEajz0QO1PnLr9O4tIXAmh8B2" +
           "409l8s4cKPAgu1G6KW2YpQKDWNuvO4adpVr64I5dD0PfWEShkqeFcr6b18kQ" +
           "vj8rohB6RBcd2VIOOR1xIUC7pmzhKxwD3XvARTx2DXmHxvgn3cFP5OdC6E3H" +
           "3iyybhQA5cGb3kq373vS516+fOGBlyd/nafuj97gLvahC2pkWcczVsfq5z1f" +
           "UY1czIvb/JWX/7wQQg/cJgULELzYpV2f39J/KISunKYPoXP573G6F0Po0o4O" +
           "sNpWjpP8egidBSRZ9SPe4cZ239BTT30RhL4ohVkPoRuWnFeyDLMTpmdOWvDR" +
           "5lz9SZtzzOifPGGt+SP3oWVF22fuG9LnX6aY971W+fT2SUKyxM0m43KhD925" +
           "fR05ss7Hb8vtkNf5ztM/uucLF586dCP3bBe8s5lja3v01sn/lu2Febp+84cP" +
           "/P47fvvlb+Xpt/8FGh6db30gAAA=");
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
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "/RoAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
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
      1471028784000L;
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
       "sXfrQWMHY52ZTO47HmU/zLCWfNzbz0HVPov9xF+b/h/syYxS930AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "GPW0gXF9aEPItGSKjcm6TVQjxkDWCyHA");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("22TdRjBRJtc1akrhOOPPan7arulzGmuppmQh8bw0mYr6IuUgZyDqhMe16yjR" +
       "mabzyF5S1U7FmtdLhgMEOQrjXqTbk3VrzPeBXbuQeZhq8xViqEsrw+D0Qaq5" +
       "ak2O4yWXVCNeFEGfUt2R4QQJtSaEdoLyowWHGpLCqeuyDcuhwWEckvZnhBjR" +
       "ixbWS4xuc+72eZLWUwl43iwetT0U7ohooMlYC5VbTYjghowAK516Q1jO6mMX" +
       "okhnVvZxgRx4sNKGeD2RnLBst7R2XWaKTR4mqCHJLZcDBk5tdLUkml0S3XQT" +
       "SKrOZ9MBg0VFulOFUwaZNPUZzboW21twZo9Y6uliGY65fofv1pzVhKpEXHVF" +
       "Bch4VUpUMNS0LTzqYNUFG1F8SOrZ9Jn+aFh0MN+ZrhF+bgxoxw1oRom7+Gyl" +
       "y0ynxQO/abpBIro17+KUPgiUDtQzHLQ2nvSm8NxCqbqtL9ihBeyfbmc570Q4" +
       "ZymO0McbwgiaJJPxdITEY5v0O0YrXDSt9qLDS9062zChOTPmumiwaiz6NBYQ" +
       "FI0zpsVqFavoNopqY9VMHLSa9OR4PMHFuUHq7epioAud4YgIGp0xwGqoxR6z" +
       "avP2LOkELQNiOYxZi10C78mrDTHWax1NwImBMVjhLBLLRrpyyWZ9iXIG38TW" +
       "3GKOgpEe6kndgbkmjLE40TtJN1HkmuYjbQxe63ZX0fv0GG8zHXSsC3aEl4ll" +
       "JVkpSnVQZkXGFiJGMWIkZZuRvGBZZiIQDh2bbaFkdqopp89XytAdDqzWKl2V" +
       "gfOpuO4EjUvtCRcPUGzSQhJt2PWTyWKumClVq4MhnknXPS4pWaqpGsG0CYwi" +
       "f7FstDhgbjQHXhM1Swg5GOhwNWoEtG82B4Y2hRpAknsbKFESnsG4gOnL8nKc" +
       "NlkRp3lgvyND1/IdpMUuSAhYCrqEECpUx9qQSLEIbheb+oBBFAboQEWO5fHG" +
       "HIztTntTl4cVLDKhzsSlLHWEVtURUVXSGaPx3nRFbqjqxKnhEO5aAxZZRtqQ" +
       "bQMHozWqCUHJGuiRSQDflx9bLQJ4zfVlc2nJmmFhmDNRVIOjl2PfaVf6XYy2" +
       "aobcrA9swewMkUYqiMhkY0Ct1pCB3PXQKc3pWrGzmNYafkIMYS+aN5dje0G0" +
       "FIC+x85IpjGd9NdWRcJlTZZb/ZngDuIxlWLVEamWiagroxssZX3QH1XQh9eD" +
       "xXROjZf0pIGkiAYaa8gZZQVrbkJXW6NdZ7VGm83OAhFrAbwCMukyap1rYuNu" +
       "wgsEYdMUxJXS4RQr0gt1OllVgbPH6t4CH3MkM1GZEqHqaFnEVy2jP+2u6MYs" +
       "Zde12SqhpDEz7TDOUGxzE6hTq7ji1Ky6RE8edAwFbataT1QRFcIbwHeH+rrB" +
       "CE7THfF4UJx2I3fTqbteOdL6Mc6ZPh6wTZbp95ZyP9Q75CoZrbpjIFLastMj" +
       "g5FeniXTPrzsJojErqjR2rSkdohCZLctNyXI141VF9i3Ai8N8HK/6C6iyFbE" +
       "GSVyRbi6pIHXS/UnVUaLknhQKwW6t2aahNQuT5Ih5nG9fplOijbdbxHDFWgc" +
       "KKbMbsmfhaTWLwlTryz3dIyV7VI6LzU9qDxrdOLWpIkb0sCUWMqB0xmrB4tN" +
       "b+0MvI016SB8lSBKcFSZ1yynQvBYb8QLGJmKOjBvFxg7rwH7hSOHGCJEJQFv" +
       "jSto1NEadBcYFZWNpzGatlbh+kar0GIEcRy2Hlf9yC/blG4NoG7UZsj2slX0" +
       "kXjGI0uPRtHBoj6wfKYUs8Ga6Itrke8vxIhBuMnCj4rKarAoOqEsd0dTJuXH" +
       "EsEA7SkZBj5eA3t60l4bVpsvDTwW1sOFWTOc9bQ6WTBhFGv1DgN1Gj5sudxs" +
       "2uz1TW3UDjYBPSyzZKttrmE4XRjdygxprRo14DpXF4t0tfJao2SeyqYey4qg" +
       "k0tNjma9Kj7u+gOtO9lMl0trWRprdX8gpVbdUAYKJzME1J8zbrCsc2CAFPqy" +
       "arcWuknBKmkWRbJRaZYFEjaHTbxiYmkiNYBr3xvoHWm8UEuuU+8ovaZLqSKw" +
       "3hDMgbxGslnUirC1hOVRk5YrPgTqk+CaNBF1SMQsuzQM5nNvbg7LMqZWrGV/" +
       "3Q8rq2WK1VYDEgxNi6Q+LffWFb/fDxYQ3oSn6sSdNVMyk/UZW5yb42qbd/22" +
       "v5gmTY/uuNgklp0eM9O0ErWQgYNTLDanPZprlgdjtbhQ3SQlEohpzCGmz8iT" +
       "XnOEhjClx0LkAvoEAygny7XbPCHWQ6dspXJLLXcWyWxYpRMFQ+TyPEEEvgbP" +
       "wiXBEJP6GGoQM6E2pmsLhVhKabdutwftOGCLvhFoXGXZXaZorJvlmjktkwvN" +
       "4JEqcP/HcEK258BMdyHfdFzgkC7rqBvNFikYYHpjYUYJaoUWiHXbiTFzWFx1" +
       "h3Bo11NhwPdDxPcW+nI8NbxJbQkqWlahRmhSOjKvurNajaDIGI2U9poDLgsS" +
       "iRRV6rpraYoYc6e8GBUr0SRx2/0Fvp6IhuNSGrbAp2UjkdYWsm4ngkdg1qJY" +
       "nJTmst+xRwgneXBbIVtwCHRX0wcjRYvA7DLStYmiWp/G1HAzWK5gvYx3qk5L" +
       "IT2xS1ZNWJOaneIMjrlUWdbLCg+c61bDtGRTXC7kgEUYd8KtBl4btFrPsaDI" +
       "Rd11aiwVouUl67FmOKWS2cV0iN7MPT+RV+xUlQyt3Gynquj163U7ogZQxC8c" +
       "bDwcsiNSRGKVkTLTplWccdMhi5U7JVWfJmunNx4bke/Olqgyk+mytcR4q2aR" +
       "qjWwRiJan1Joo9RppkDnzJuo1jBmuly2Z3VvWDLR9SCiRK3PGdbUGvU3Tlmt" +
       "rmndm/pIJRQ77tzhdWnElgDZ3WnXYfpNwWKnaHFWxBnciCk2XC5pq4KCQVXa" +
       "8JA+bKCoszY4CqvaPsIH02mPH7iWgzaEAB6HfK/dVSZuJ+1OkrCtNudJz2aq" +
       "ZYsbKcvZZM6U2gg3jOwRiRJG1V4qg1aj6hiOs47wlijKVc7Ck8mwnoQkWkfK" +
       "aZnqxJWlLfmI39Rx1V6X6j2u7ZuYWg41pQOeW0K9VMXjLjXzq6pH9/oNJdbX" +
       "bqlttlpBx0bSDWREG3EqbybV0rSvs1IlTo2+4fdsjI9QX0PN+bpHcl0v01lz" +
       "MISzej/WaH2VahtGI8eQ1GMGUZmk2MhSTHZCJT5iahoHtElcjTN7MtUcpIi0" +
       "R6wxo7TJoEUQuDHoa6wkV5BFkSXbgaLbDLtYB6KxQlKLAEqzO24RTKNIpX6F" +
       "Edtkf0OXGXy9Snp0f6UOqWXc5Oc9zV4gXlCEyRSMo5u1huKDHmiyuIZgxNKh" +
       "oVbfq+hIuczAGC1LZkStS4OKtq6E40gbUOsqg/pyt8p1YZxyu6XpuDWFgPfY" +
       "Upt6QNRUegi8BAsZBEN8OOT6SVLHKzZbW3PGQq3aiWpRbuLWEbItw7W0z6DK" +
       "tGFmHjXVG2zgDvCHzF6taA/5Zrc2plZDpYjOGy2YB31M1JWYXS5VMEprbiIQ" +
       "Ta+BNbhZmd6g/d6GbpX5GqpDeuD0hZQfiGF3rG6ICUY3ZyuK0NYlthW3dL82" +
       "bnb6pFE3zI3IOMwYFasoEaV0uGqv9FJaNakp4UQKzWFlczDxeRfBMLGkUdWN" +
       "tJoCY7q2acZkt68KPj8OqQq6CTG5E7ZEiORwht0Q8axJ9ntGyx2EDseY4x5U" +
       "xTaxQXWqBg7MM4KUuYXd6jTpDmNCozFUNuXS0CfmBrAwsWroDOTYdDpKMiSL" +
       "vU1ET8f01GgOtWBWGlNmqrqeDZPUulsrT4r6xJtR3emEGNkc5Qm6WxWq6GaC" +
       "AQpWPbgxKIoWAdz2IkctJGOuDhdrpASpZVyd2huE89gVgkxbaZ8ItZiDBmbT" +
       "K27oNasZrf6UkcclzcXn9f5Utjd82F41nZ7BjU2u25lP12ad8D14rqSTAGMr" +
       "QqQlKw8jesHErqUK3i6CUWYNWIR1lxNCZWHVZjRhHYWlKkLF0zhYCMwS1G/i" +
       "s3XHGNRSA2jBZNqcU7za8cMx0qik1RY1Ha4Nx1IWS2PBLKolTe9M68BEIbvq" +
       "UtlUtRa3anAk7TnVyjolGGk0HjN8s+IVtXanoeGQvCQIrmoYjOiUoLZLj1TV" +
       "M+Wex9ZnNalVb1sa0c5n8nzjgvNk89kYxys7dbOR3fizb34WwuEn5FZ1UIVS" +
       "Yhix0BAMDf2YlhRkyK0wSO/h9WHFXKzJ1XjY9/t1BijLoD9rZpqCWdQm026Z" +
       "FqvsekZUV7LKcmGyKI2dYi+w3E4HWMDZyDGqLoHDTYREg10uFKinutJmoZCb" +
       "luuqxYEazesc44a015Y6iO1aCjJVQ8xVQ+Dt4RwYMUobzPeHWMjJUdFT2+W1" +
       "CKEU4UIu0WYWDZKp1sY+Rnsm7hoRWpY42WyN2+wg6tVFqUtGItHFXHGBAElz" +
       "g7BCidOVCJXKhojrS1b2INdl067eZGDb7RkajfR8xsRxCEhai+nAiDbkFXzT" +
       "g+duwzdsAcembSSazRtAchq1ZJKmtcHIJb3Iqk9QVpabAlmpUF1lPUQQvLZk" +
       "pAmapM2pMIInSnE+YOiZ1ABG4khInHVfnlO4RRuepeGmyzVnHJ+46/qCjl2r" +
       "trHVyOXtMdmurLrtSgmLohKJ8wnj4xQNl0Ok7szYsmOM571pgwNORw1CIYFF" +
       "0pZfJZFNmUzWflmd1IbAF+Y7wJ9q94marAUQaZH1aWZRw5Hac9kpIZd1m4/A" +
       "gCb0E3rWMqFhDWlhRdkq4rIVkEsMC2pJ3B2TKIUgxtrWMtsbl2CL5rq9JT0l" +
       "6HIMzdBUIIC1BFuLtN2u6Ansl9ayTZLCRK5joSlWmkzaLrXHdW4Kj4ej4qwC" +
       "RmwyUmIvgLsbvKaWJLmHNGstlY879qaoNkYT3upYMsfKCl5cJbBbZihFWqlc" +
       "t2XXZ2lZW/QSPlxxgzmGsOsFVWOkhJxuiGbSnPMVo9YsDdl4I9AK6rtrgUvH" +
       "U7y5SkdksmS6/fYGmg8qgxbbFZZdnKhgom+3N4Qo9K2QpOOYMkrTVW85r6+J" +
       "pkbSXDHR1k0CaixjYdCxhX6jlooK1y6tG+S8UtlgsGGT4XAgyC2Z7E15fcCl" +
       "XrmcjLUhVmnGkekuPL7oNSxPsipmGBOeaLRmMRRVluSsR3gDtDroUmuV0+Ky" +
       "osDM2g9gZEO4dCrBjURpuJvI57r9uQFs+9YG16ohvOFmbDJYWxCNCc36YhNY" +
       "vgFxpOmmvFKxySEEDaaKrzXF7qbu6sQ8gfujOI5qMrShBSwoAa9R4GhDW6os" +
       "VPKzaQFhPGjJXizOqXapGvv2LBsnMXbaniulpTaorzcrou/F/VATDQ4i0Abw" +
       "o0wwIC0ELW26s0FAN6TlcAm4bjFOTPlVOLLsXjBdVoZLLEJbK4wxlzqEJELF" +
       "nyveeEbhi1p5ydHVBm5N4JREZ8owFdIiPh05m1aMQQK8gv1kEbOtSrHdbr/1" +
       "rZna+ruLacxHb9OYT5UuqjO3t16VJa89nvuX/91b2K2cPjqfmvuX53x8t+R3" +
       "N1vu9bfNBM3mIfob9WgqaL7xgB1kk4ifuNOi+HwC8cfe/cFnJPpnSkfTvz8V" +
       "FG4EjvttpryRzVOPHoCa3njnydJUvifAyZK8z737P72M+47V915gofGTZ+g8" +
       "W+U/pj7xhd7rxP/moHD9eIHebbsV3Frozbcuy7vfk4PQs7lbFuc9cdwSj+zm" +
       "tRZ+etcSP312FuZJW58/BfNbt9KS3zt3Zem1F++591iWPBwUnq/KAemIvDnc" +
       "kf5nx+J17YXPNiSfrjS7cO0Ft+LL1ur/7A7fz149vlftufeaLHl5UHgA4Dtq" +
       "oSOBfsWdpjZvJzOfMOCJSzDgseziq8Hx8zsG/PxFGYA+KwP2LCu+limMa2/c" +
       "MiDrpNmk9CMGPHEbA9RNcPOWXDl+6BL48zWAbwTHZ3b4P3M1AnCQZzg4gvLa" +
       "/W252xMly/x7OVveuodl7SxpBoVHRE/mA2D58u5KE/3TnHvVuZy7LWfOvdYl" +
       "uJev3c3Wo3xpx70vXb30UHvuZesrr+FB4TFtu35ZO8OP7DZ6ArV/CagvyS6+" +
       "Chx/uoP6p1cDdSco2cO+46T9F3tAvy1LuG2XyXTi8RhyvOqIj4KbqgxGv5Gj" +
       "2UG5c8KByWU58BoA5tq27PZ8eQ5cO8mwBa/uAa9liRAUXqD5p5Z3ZDk/eYJS" +
       "vIJ2vvaCHcoXPEco/T0owyyxQRNvUebLdc5gdC6BMd/CowqoefUO4ysvivF8" +
       "pXf92FzcyXLe/3JEP7AH7Q9mSQo8cCEEOG/TUmfXBmwcTTrhwzsuwYdHs4vA" +
       "urn21h0f3no1fDgN7v177n0gS34kb+ZsGUi244l8ppnfd1l4oGmv9Xbwelcq" +
       "ykc65+HT636yVsux/Xd7cD+TJR8CnRhoMEzz/GMBv/aRE+QfvizyrBPTO+T0" +
       "VXfiax/JkXx8D8pMbq/9o6DwIEA5BL2Y1QRzu4jnNMyPXUUDz3YwZ88RzF/a" +
       "A/OfZMmnto0JvBegjY9G3lMoP30JlPlKsO8A9OwWSl9779Wg3KOtPrsH7/+a" +
       "Jb8SFB7XbC3IN6uTOwnwqDSRDV3X8bLB6NoPnUD/1ctCHwIUu/W+125b7/vN" +
       "QT9tdBx1Y+hc/1nO1kf6ebfOl0pyvAfaOWfEb+xh0u9kyeeAPcJLUj5On127" +
       "eZpDn78K4fjlHYf+ydVzKEt+M4f1pT2Q/zBLfh/IhZevqX1W1P/6sgP4SwGA" +
       "f7FD/S8uivrZB64/23Pvz7Pkj4PCfdmMcMeXz0D795dtUARQ+fs7aL//nDTo" +
       "zgj72h6Q/0+WfAWYJUCGdw4a5xyPVKfg/t+XhQvG5Wvf2MH9xnMJ97/cGe5B" +
       "9tBr/zkovGQrvzvEmOdY52H+68tKLzC1Dh7elt2eLy+9Z+ySV562S3Z6jAp3" +
       "u6tm/+aw79/DkmxXsoN7gsLLVrwtmXKHpjI92Ld92Qt2S8dvZcvBvZdlSxuw" +
       "4007trzpStmSkfdADuvxPZBfliWPBoVXHEM+d6+AM7BfdFnYoNwBsYNNPEew" +
       "n9oD+3VZ8mRQeOIY9nn7BJxB/cqraOyd6XZwYdPtLlEX96DOUUC3NvZuP7AO" +
       "H/BH2M/AftNlvevXA7i7zc+258uru7MW68Fb9sDOFOJBAyh2zd8arB0wipl8" +
       "Ip/xsQ+al1XsTYBwtyPWweZqkN7Zaj3A92AeZAmaBQ2BoxkGMnmyXdCZ5u1c" +
       "Vqq/DYD9hR3oT16pVB9p9sodX/W0bc3KdvAjtY18vOdRvqthzgVuD4fmWUIf" +
       "d4ajmo5rAV3DVm/rDKPLcisTkc/vuPX554Rbb7yNW6Lv35RtVbPlmyjLdvNf" +
       "JyOisIdJSpa8PSi8aMukW0ufYc2z7nP3bL2nBVjytR1rvnbVeqLwhzkgdw/Y" +
       "bBbJgQEs+mOwI8/Jtx4/XxaedT+6ZwP8JOjY37Ituz1fHvBpPN+35973Z0kU" +
       "ZO8D8yjcdtuZ0+jiS6DLd2R7OUD1lh26t1wAXeGu4qkH792D7n1Z8kNAbIHv" +
       "ugsZswHvBX17G60q/OEJzh++LM6XAXzIDidy9Tg/uAfnh7Pkx4CWP8HZtaXz" +
       "UH7gEiizzZ+z8PF1boeSuxpZPddnOfjpPXj/hyz5SFB48VZmz9nk7sdPIH/0" +
       "st2zD6DaO8i3bdr6zUG+L89w3/r0aL6zQIDmfvW5r/HyDf2ygXu023a+n+f/" +
       "6DGxOY4SIHK3/+r2fJrYowe84GSTuu3mdAe/eHQLvdDGWmdZj4SKInt5G31i" +
       "T/tlscODnwUOlqKZ5vl1nNFCH79EI744u/hUoXD4xLbs9nz5RjwxybZTX/K9" +
       "uj6ZA9wTSDzIAokHvxIUHrLzLdi1VD4R25PpDQeXiR++ZIf4nsNt2e35Snvq" +
       "R9bHNveegODBb2XJ54LCgzbwJNvZLIfA8WjlRNxzrJeOBIJy97x4h/XRK2/d" +
       "Hz/qote+Iwf1B3sAfylLfg+INi9JPTNxV0dfqDgWc/+MaH/xsuC7APSP7sD/" +
       "yHMO/k/2gM+6wcEfBYUns9BZFj+4Ow58+Qr8rXt+eseBj14NB+7JM9xzKwcq" +
       "R1ry9klnZzS0ZgMjI/9SyI5tf7WHbVnE8eAvwPAN2JYXvSOn/vKynHorwPSL" +
       "O05d2Em7CKcyar96An9PBPJ6RsPBfw4Kjx1JzX4eXCYEefTm955f3/Hg16+6" +
       "v+zG8zNDc246vRo8b+fy3XOey3fwi3mS82RPePJ6Fp68fs92Iki2d2v2puHM" +
       "8/K2fmQfziNJfvD0dxfyb1Rcf+SY19cv");
    public static final java.lang.String jlc$ClassType$jl5$2 =
      ("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");
}
