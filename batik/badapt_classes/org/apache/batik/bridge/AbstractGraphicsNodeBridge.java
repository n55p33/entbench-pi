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
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "iBc3xGu0kax4y7l40jQLJameCg2DPoCoKt22xyXBgz4S2EVXcboJyRYORZCR" +
       "aiMdUxXI3WslsU53Vhz8r4GIXY/s//wVh5NDzsmOd12Rp4rDsK2pZAgit8ur" +
       "bfbaM7D3B24x4hA190paHKJolmeTF0/x/kKWZYMXS49p6mZuJxWNo9Vri41H" +
       "vjP3HT8dHzy7NauJEvgzphtbVDpF1Tww1hb6NjCzAb6p6GSnlxc+/NpXOpK7" +
       "y9mkwGdts2xD4O/VYFmbvC3LPZSL9725YmTXxMEy9htWu1ByN/npgSef69sg" +
       "PxzkO6h22ly081rI1FkY0+tMytKmVhjF1+U0cxkq4ia4kkIzk24TdIyjSOu5" +
       "AzjuWljX+TTmWoIGbdvJatd6fyV2qfwirD19ncytAl8FgJrwwZ7zWeh+Acnj" +
       "kFLKJgWLcCfr+x0n8OnZ3Jj/MhIfdBn8+ZkcPh1Y1gnX3QKfu8sAO4i3ISSP" +
       "uBBv8WnRB4sLPmXfRPJVRpbab52Y4g/WUxUAqx7LsNqDQrSjPmAh+UyxHh71" +
       "YHVJXsUHUoU/zyP5PBePt/9dH5C+j+RZRppiaUWN58PDq9+GZMwW9yDEoild" +
       "iTuQPVcByBZhGW6ynxJynyofMi9WFw55GcDneauXfYB6BclPGalLUrZHsQxV" +
       "msEnBxw0XqoAGrh8JiG4zgqRzs6CRom1hRervyNbk++aRMAeMWGtxrdkY/b7" +
       "kvO8+zd9YPsPJL9iuOeSMtKM5prI9tNamNF0JRKK5qrF0f23CqDLc7cBuC4K" +
       "iC6Wj64Xq7d57s+Zpw3f+z7w/QHJe4zMh3w6Bwo+e8FB5neVQmYHXC8K8X5Q" +
       "PjI/8GD9kx1XoNYbmUAdkioIoZCS6TL6diejLAQoMKdSAO2C6zUhZdHSeHaA" +
       "funB+qcDtMQHoKVIGhlZpmgK4+/e6Z4ZSKoUOZo2DN10o9RUqfh3E1xXhKhX" +
       "ZkGphDP3Yi3tzEu6L0jIIaMPDaTFmYspkWYF2n3w24CklZEVE3zJsWdwAI+Z" +
       "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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "IBMtmjHJwuW7tRzD2mPXbc2xCBYa4zw3");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "AAA=");
}
