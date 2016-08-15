package org.apache.batik.bridge;
public abstract class AbstractGraphicsNodeBridge extends org.apache.batik.bridge.AnimatableSVGBridge implements org.apache.batik.dom.svg.SVGContext, org.apache.batik.bridge.BridgeUpdateHandler, org.apache.batik.bridge.GraphicsNodeBridge, org.apache.batik.bridge.ErrorConstants {
    protected org.apache.batik.gvt.GraphicsNode node;
    protected boolean isSVG12;
    protected org.apache.batik.parser.UnitProcessor.Context unitContext;
    protected AbstractGraphicsNodeBridge() { super(); }
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
        org.apache.batik.gvt.GraphicsNode node =
          instantiateGraphicsNode(
            );
        setTransform(
          node,
          e,
          ctx);
        node.
          setVisible(
            org.apache.batik.bridge.CSSUtilities.
              convertVisibility(
                e));
        associateSVGContext(
          ctx,
          e,
          node);
        return node;
    }
    protected abstract org.apache.batik.gvt.GraphicsNode instantiateGraphicsNode();
    public void buildGraphicsNode(org.apache.batik.bridge.BridgeContext ctx,
                                  org.w3c.dom.Element e,
                                  org.apache.batik.gvt.GraphicsNode node) {
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
    }
    public boolean getDisplay(org.w3c.dom.Element e) { return org.apache.batik.bridge.CSSUtilities.
                                                         convertDisplay(
                                                           e);
    }
    protected java.awt.geom.AffineTransform computeTransform(org.w3c.dom.svg.SVGTransformable te,
                                                             org.apache.batik.bridge.BridgeContext ctx) {
        try {
            java.awt.geom.AffineTransform at =
              new java.awt.geom.AffineTransform(
              );
            org.apache.batik.dom.svg.SVGOMAnimatedTransformList atl =
              (org.apache.batik.dom.svg.SVGOMAnimatedTransformList)
                te.
                getTransform(
                  );
            if (atl.
                  isSpecified(
                    )) {
                atl.
                  check(
                    );
                org.apache.batik.dom.svg.AbstractSVGTransformList tl =
                  (org.apache.batik.dom.svg.AbstractSVGTransformList)
                    te.
                    getTransform(
                      ).
                    getAnimVal(
                      );
                at.
                  concatenate(
                    tl.
                      getAffineTransform(
                        ));
            }
            if (e instanceof org.apache.batik.dom.svg.SVGMotionAnimatableElement) {
                org.apache.batik.dom.svg.SVGMotionAnimatableElement mae =
                  (org.apache.batik.dom.svg.SVGMotionAnimatableElement)
                    e;
                java.awt.geom.AffineTransform mat =
                  mae.
                  getMotionTransform(
                    );
                if (mat !=
                      null) {
                    at.
                      concatenate(
                        mat);
                }
            }
            return at;
        }
        catch (org.apache.batik.dom.svg.LiveAttributeException ex) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              ex);
        }
    }
    protected void setTransform(org.apache.batik.gvt.GraphicsNode n,
                                org.w3c.dom.Element e,
                                org.apache.batik.bridge.BridgeContext ctx) {
        n.
          setTransform(
            computeTransform(
              (org.w3c.dom.svg.SVGTransformable)
                e,
              ctx));
    }
    protected void associateSVGContext(org.apache.batik.bridge.BridgeContext ctx,
                                       org.w3c.dom.Element e,
                                       org.apache.batik.gvt.GraphicsNode node) {
        this.
          e =
          e;
        this.
          node =
          node;
        this.
          ctx =
          ctx;
        this.
          unitContext =
          org.apache.batik.bridge.UnitProcessor.
            createContext(
              ctx,
              e);
        this.
          isSVG12 =
          ctx.
            isSVG12(
              );
        ((org.apache.batik.dom.svg.SVGOMElement)
           e).
          setSVGContext(
            this);
    }
    protected void initializeDynamicSupport(org.apache.batik.bridge.BridgeContext ctx,
                                            org.w3c.dom.Element e,
                                            org.apache.batik.gvt.GraphicsNode node) {
        if (ctx.
              isInteractive(
                )) {
            ctx.
              bind(
                e,
                node);
        }
    }
    public void handleDOMAttrModifiedEvent(org.w3c.dom.events.MutationEvent evt) {
        
    }
    protected void handleGeometryChanged() {
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
        if (isSVG12) {
            if (!SVG_USE_TAG.
                  equals(
                    e.
                      getLocalName(
                        ))) {
                fireShapeChangeEvent(
                  );
            }
            fireBBoxChangeEvent(
              );
        }
    }
    protected void fireShapeChangeEvent() {
        org.w3c.dom.events.DocumentEvent d =
          (org.w3c.dom.events.DocumentEvent)
            e.
            getOwnerDocument(
              );
        org.apache.batik.dom.events.AbstractEvent evt =
          (org.apache.batik.dom.events.AbstractEvent)
            d.
            createEvent(
              "SVGEvents");
        evt.
          initEventNS(
            SVG_NAMESPACE_URI,
            "shapechange",
            true,
            false);
        try {
            ((org.w3c.dom.events.EventTarget)
               e).
              dispatchEvent(
                evt);
        }
        catch (java.lang.RuntimeException ex) {
            ctx.
              getUserAgent(
                ).
              displayError(
                ex);
        }
    }
    public void handleDOMNodeInsertedEvent(org.w3c.dom.events.MutationEvent evt) {
        if (evt.
              getTarget(
                ) instanceof org.w3c.dom.Element) {
            org.w3c.dom.Element e2 =
              (org.w3c.dom.Element)
                evt.
                getTarget(
                  );
            org.apache.batik.bridge.Bridge b =
              ctx.
              getBridge(
                e2);
            if (b instanceof org.apache.batik.bridge.GenericBridge) {
                ((org.apache.batik.bridge.GenericBridge)
                   b).
                  handleElement(
                    ctx,
                    e2);
            }
        }
    }
    public void handleDOMNodeRemovedEvent(org.w3c.dom.events.MutationEvent evt) {
        org.w3c.dom.Node parent =
          e.
          getParentNode(
            );
        if (parent instanceof org.apache.batik.dom.svg.SVGOMElement) {
            org.apache.batik.dom.svg.SVGContext bridge =
              ((org.apache.batik.dom.svg.SVGOMElement)
                 parent).
              getSVGContext(
                );
            if (bridge instanceof org.apache.batik.bridge.SVGSwitchElementBridge) {
                ((org.apache.batik.bridge.SVGSwitchElementBridge)
                   bridge).
                  handleChildElementRemoved(
                    e);
                return;
            }
        }
        org.apache.batik.gvt.CompositeGraphicsNode gn =
          node.
          getParent(
            );
        gn.
          remove(
            node);
        disposeTree(
          e);
    }
    public void handleDOMCharacterDataModified(org.w3c.dom.events.MutationEvent evt) {
        
    }
    public void dispose() { org.apache.batik.dom.svg.SVGOMElement elt =
                              (org.apache.batik.dom.svg.SVGOMElement)
                                e;
                            elt.setSVGContext(
                                  null);
                            ctx.unbind(e);
                            bboxShape = null;
    }
    protected void disposeTree(org.w3c.dom.Node node) {
        disposeTree(
          node,
          true);
    }
    protected void disposeTree(org.w3c.dom.Node node,
                               boolean removeContext) {
        if (node instanceof org.apache.batik.dom.svg.SVGOMElement) {
            org.apache.batik.dom.svg.SVGOMElement elt =
              (org.apache.batik.dom.svg.SVGOMElement)
                node;
            org.apache.batik.dom.svg.SVGContext ctx =
              elt.
              getSVGContext(
                );
            if (ctx instanceof org.apache.batik.bridge.BridgeUpdateHandler) {
                org.apache.batik.bridge.BridgeUpdateHandler h =
                  (org.apache.batik.bridge.BridgeUpdateHandler)
                    ctx;
                if (removeContext) {
                    elt.
                      setSVGContext(
                        null);
                }
                h.
                  dispose(
                    );
            }
        }
        for (org.w3c.dom.Node n =
               node.
               getFirstChild(
                 );
             n !=
               null;
             n =
               n.
                 getNextSibling(
                   )) {
            disposeTree(
              n,
              removeContext);
        }
    }
    public void handleCSSEngineEvent(org.apache.batik.css.engine.CSSEngineEvent evt) {
        try {
            org.apache.batik.css.engine.SVGCSSEngine eng =
              (org.apache.batik.css.engine.SVGCSSEngine)
                evt.
                getSource(
                  );
            int[] properties =
              evt.
              getProperties(
                );
            for (int i =
                   0;
                 i <
                   properties.
                     length;
                 i++) {
                int idx =
                  properties[i];
                handleCSSPropertyChanged(
                  idx);
                java.lang.String pn =
                  eng.
                  getPropertyName(
                    idx);
                fireBaseAttributeListeners(
                  pn);
            }
        }
        catch (java.lang.Exception ex) {
            ctx.
              getUserAgent(
                ).
              displayError(
                ex);
        }
    }
    protected void handleCSSPropertyChanged(int property) {
        switch (property) {
            case org.apache.batik.css.engine.SVGCSSEngine.
                   VISIBILITY_INDEX:
                node.
                  setVisible(
                    org.apache.batik.bridge.CSSUtilities.
                      convertVisibility(
                        e));
                break;
            case org.apache.batik.css.engine.SVGCSSEngine.
                   OPACITY_INDEX:
                node.
                  setComposite(
                    org.apache.batik.bridge.CSSUtilities.
                      convertOpacity(
                        e));
                break;
            case org.apache.batik.css.engine.SVGCSSEngine.
                   FILTER_INDEX:
                node.
                  setFilter(
                    org.apache.batik.bridge.CSSUtilities.
                      convertFilter(
                        e,
                        node,
                        ctx));
                break;
            case org.apache.batik.css.engine.SVGCSSEngine.
                   MASK_INDEX:
                node.
                  setMask(
                    org.apache.batik.bridge.CSSUtilities.
                      convertMask(
                        e,
                        node,
                        ctx));
                break;
            case org.apache.batik.css.engine.SVGCSSEngine.
                   CLIP_PATH_INDEX:
                node.
                  setClip(
                    org.apache.batik.bridge.CSSUtilities.
                      convertClipPath(
                        e,
                        node,
                        ctx));
                break;
            case org.apache.batik.css.engine.SVGCSSEngine.
                   POINTER_EVENTS_INDEX:
                node.
                  setPointerEventType(
                    org.apache.batik.bridge.CSSUtilities.
                      convertPointerEvents(
                        e));
                break;
            case org.apache.batik.css.engine.SVGCSSEngine.
                   DISPLAY_INDEX:
                if (!getDisplay(
                       e)) {
                    org.apache.batik.gvt.CompositeGraphicsNode parent =
                      node.
                      getParent(
                        );
                    parent.
                      remove(
                        node);
                    disposeTree(
                      e,
                      false);
                }
                break;
        }
    }
    public void handleAnimatedAttributeChanged(org.apache.batik.dom.svg.AnimatedLiveAttributeValue alav) {
        if (alav.
              getNamespaceURI(
                ) ==
              null &&
              alav.
              getLocalName(
                ).
              equals(
                SVG_TRANSFORM_ATTRIBUTE)) {
            setTransform(
              node,
              e,
              ctx);
            handleGeometryChanged(
              );
        }
    }
    public void handleOtherAnimationChanged(java.lang.String type) {
        if (type.
              equals(
                "motion")) {
            setTransform(
              node,
              e,
              ctx);
            handleGeometryChanged(
              );
        }
    }
    protected void checkBBoxChange() { if (e !=
                                             null) {
                                           fireBBoxChangeEvent(
                                             );
                                       } }
    protected void fireBBoxChangeEvent() {
        org.w3c.dom.events.DocumentEvent d =
          (org.w3c.dom.events.DocumentEvent)
            e.
            getOwnerDocument(
              );
        org.apache.batik.dom.events.AbstractEvent evt =
          (org.apache.batik.dom.events.AbstractEvent)
            d.
            createEvent(
              "SVGEvents");
        evt.
          initEventNS(
            SVG_NAMESPACE_URI,
            "RenderedBBoxChange",
            true,
            false);
        try {
            ((org.w3c.dom.events.EventTarget)
               e).
              dispatchEvent(
                evt);
        }
        catch (java.lang.RuntimeException ex) {
            ctx.
              getUserAgent(
                ).
              displayError(
                ex);
        }
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
    protected java.lang.ref.SoftReference
      bboxShape =
      null;
    protected java.awt.geom.Rectangle2D bbox =
      null;
    public java.awt.geom.Rectangle2D getBBox() {
        if (node ==
              null) {
            return null;
        }
        java.awt.Shape s =
          node.
          getOutline(
            );
        if (bboxShape !=
              null &&
              s ==
              bboxShape.
              get(
                ))
            return bbox;
        bboxShape =
          new java.lang.ref.SoftReference(
            s);
        bbox =
          null;
        if (s ==
              null)
            return bbox;
        org.apache.batik.ext.awt.geom.SegmentList sl =
          new org.apache.batik.ext.awt.geom.SegmentList(
          s);
        bbox =
          sl.
            getBounds2D(
              );
        return bbox;
    }
    public java.awt.geom.AffineTransform getCTM() {
        org.apache.batik.gvt.GraphicsNode gn =
          node;
        java.awt.geom.AffineTransform ctm =
          new java.awt.geom.AffineTransform(
          );
        org.w3c.dom.Element elt =
          e;
        while (elt !=
                 null) {
            if (elt instanceof org.w3c.dom.svg.SVGFitToViewBox) {
                java.awt.geom.AffineTransform at;
                if (gn instanceof org.apache.batik.gvt.CanvasGraphicsNode) {
                    at =
                      ((org.apache.batik.gvt.CanvasGraphicsNode)
                         gn).
                        getViewingTransform(
                          );
                }
                else {
                    at =
                      gn.
                        getTransform(
                          );
                }
                if (at !=
                      null) {
                    ctm.
                      preConcatenate(
                        at);
                }
                break;
            }
            java.awt.geom.AffineTransform at =
              gn.
              getTransform(
                );
            if (at !=
                  null)
                ctm.
                  preConcatenate(
                    at);
            elt =
              org.apache.batik.css.engine.SVGCSSEngine.
                getParentCSSStylableElement(
                  elt);
            gn =
              gn.
                getParent(
                  );
        }
        return ctm;
    }
    public java.awt.geom.AffineTransform getScreenTransform() {
        return ctx.
          getUserAgent(
            ).
          getTransform(
            );
    }
    public void setScreenTransform(java.awt.geom.AffineTransform at) {
        ctx.
          getUserAgent(
            ).
          setTransform(
            at);
    }
    public java.awt.geom.AffineTransform getGlobalTransform() {
        return node.
          getGlobalTransform(
            );
    }
    public float getViewportWidth() { return ctx.
                                        getBlockWidth(
                                          e);
    }
    public float getViewportHeight() { return ctx.
                                         getBlockHeight(
                                           e);
    }
    public float getFontSize() { return org.apache.batik.bridge.CSSUtilities.
                                   getComputedStyle(
                                     e,
                                     org.apache.batik.css.engine.SVGCSSEngine.
                                       FONT_SIZE_INDEX).
                                   getFloatValue(
                                     ); }
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
       "zFigtQ7Cz7jWkNahWd0qdzMyB8vQNZlE");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "AAA=");
}
