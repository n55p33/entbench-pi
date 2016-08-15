package org.apache.batik.bridge;
public class SVGSVGElementBridge extends org.apache.batik.bridge.SVGGElementBridge implements org.apache.batik.dom.svg.SVGSVGContext {
    public SVGSVGElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_SVG_TAG; }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.bridge.SVGSVGElementBridge(
                                                            ); }
    protected org.apache.batik.gvt.GraphicsNode instantiateGraphicsNode() {
        return new org.apache.batik.gvt.CanvasGraphicsNode(
          );
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
        org.apache.batik.gvt.CanvasGraphicsNode cgn;
        cgn =
          (org.apache.batik.gvt.CanvasGraphicsNode)
            instantiateGraphicsNode(
              );
        associateSVGContext(
          ctx,
          e,
          cgn);
        try {
            org.w3c.dom.svg.SVGDocument doc =
              (org.w3c.dom.svg.SVGDocument)
                e.
                getOwnerDocument(
                  );
            org.apache.batik.dom.svg.SVGOMSVGElement se =
              (org.apache.batik.dom.svg.SVGOMSVGElement)
                e;
            boolean isOutermost =
              doc.
              getRootElement(
                ) ==
              e;
            float x =
              0;
            float y =
              0;
            if (!isOutermost) {
                org.apache.batik.dom.svg.AbstractSVGAnimatedLength _x =
                  (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                    se.
                    getX(
                      );
                x =
                  _x.
                    getCheckedValue(
                      );
                org.apache.batik.dom.svg.AbstractSVGAnimatedLength _y =
                  (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                    se.
                    getY(
                      );
                y =
                  _y.
                    getCheckedValue(
                      );
            }
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _width =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                se.
                getWidth(
                  );
            float w =
              _width.
              getCheckedValue(
                );
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _height =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                se.
                getHeight(
                  );
            float h =
              _height.
              getCheckedValue(
                );
            cgn.
              setVisible(
                org.apache.batik.bridge.CSSUtilities.
                  convertVisibility(
                    e));
            org.apache.batik.dom.svg.SVGOMAnimatedRect vb =
              (org.apache.batik.dom.svg.SVGOMAnimatedRect)
                se.
                getViewBox(
                  );
            org.w3c.dom.svg.SVGAnimatedPreserveAspectRatio par =
              se.
              getPreserveAspectRatio(
                );
            java.awt.geom.AffineTransform viewingTransform =
              org.apache.batik.bridge.ViewBox.
              getPreserveAspectRatioTransform(
                e,
                vb,
                par,
                w,
                h,
                ctx);
            float actualWidth =
              w;
            float actualHeight =
              h;
            try {
                java.awt.geom.AffineTransform vtInv =
                  viewingTransform.
                  createInverse(
                    );
                actualWidth =
                  (float)
                    (w *
                       vtInv.
                       getScaleX(
                         ));
                actualHeight =
                  (float)
                    (h *
                       vtInv.
                       getScaleY(
                         ));
            }
            catch (java.awt.geom.NoninvertibleTransformException ex) {
                
            }
            java.awt.geom.AffineTransform positionTransform =
              java.awt.geom.AffineTransform.
              getTranslateInstance(
                x,
                y);
            if (!isOutermost) {
                cgn.
                  setPositionTransform(
                    positionTransform);
            }
            else
                if (doc ==
                      ctx.
                      getDocument(
                        )) {
                    ctx.
                      setDocumentSize(
                        new java.awt.Dimension(
                          (int)
                            (w +
                               0.5F),
                          (int)
                            (h +
                               0.5F)));
                }
            cgn.
              setViewingTransform(
                viewingTransform);
            java.awt.Shape clip =
              null;
            if (org.apache.batik.bridge.CSSUtilities.
                  convertOverflow(
                    e)) {
                float[] offsets =
                  org.apache.batik.bridge.CSSUtilities.
                  convertClip(
                    e);
                if (offsets ==
                      null) {
                    clip =
                      new java.awt.geom.Rectangle2D.Float(
                        x,
                        y,
                        w,
                        h);
                }
                else {
                    clip =
                      new java.awt.geom.Rectangle2D.Float(
                        x +
                          offsets[3],
                        y +
                          offsets[0],
                        w -
                          offsets[1] -
                          offsets[3],
                        h -
                          offsets[2] -
                          offsets[0]);
                }
            }
            if (clip !=
                  null) {
                try {
                    java.awt.geom.AffineTransform at =
                      new java.awt.geom.AffineTransform(
                      positionTransform);
                    at.
                      concatenate(
                        viewingTransform);
                    at =
                      at.
                        createInverse(
                          );
                    clip =
                      at.
                        createTransformedShape(
                          clip);
                    org.apache.batik.ext.awt.image.renderable.Filter filter =
                      cgn.
                      getGraphicsNodeRable(
                        true);
                    cgn.
                      setClip(
                        new org.apache.batik.ext.awt.image.renderable.ClipRable8Bit(
                          filter,
                          clip));
                }
                catch (java.awt.geom.NoninvertibleTransformException ex) {
                    
                }
            }
            java.awt.RenderingHints hints =
              null;
            hints =
              org.apache.batik.bridge.CSSUtilities.
                convertColorRendering(
                  e,
                  hints);
            if (hints !=
                  null)
                cgn.
                  setRenderingHints(
                    hints);
            java.awt.geom.Rectangle2D r =
              org.apache.batik.bridge.CSSUtilities.
              convertEnableBackground(
                e);
            if (r !=
                  null) {
                cgn.
                  setBackgroundEnable(
                    r);
            }
            if (vb.
                  isSpecified(
                    )) {
                org.w3c.dom.svg.SVGRect vbr =
                  vb.
                  getAnimVal(
                    );
                actualWidth =
                  vbr.
                    getWidth(
                      );
                actualHeight =
                  vbr.
                    getHeight(
                      );
            }
            ctx.
              openViewport(
                e,
                new org.apache.batik.bridge.SVGSVGElementBridge.SVGSVGElementViewport(
                  actualWidth,
                  actualHeight));
            return cgn;
        }
        catch (org.apache.batik.dom.svg.LiveAttributeException ex) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              ex);
        }
    }
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
          setPointerEventType(
            org.apache.batik.bridge.CSSUtilities.
              convertPointerEvents(
                e));
        initializeDynamicSupport(
          ctx,
          e,
          node);
        ctx.
          closeViewport(
            e);
    }
    public void dispose() { ctx.removeViewport(
                                  e);
                            super.dispose(
                                    ); }
    public void handleAnimatedAttributeChanged(org.apache.batik.dom.svg.AnimatedLiveAttributeValue alav) {
        try {
            boolean rebuild =
              false;
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
                        SVG_WIDTH_ATTRIBUTE) ||
                      ln.
                      equals(
                        SVG_HEIGHT_ATTRIBUTE)) {
                    rebuild =
                      true;
                }
                else
                    if (ln.
                          equals(
                            SVG_X_ATTRIBUTE) ||
                          ln.
                          equals(
                            SVG_Y_ATTRIBUTE)) {
                        org.w3c.dom.svg.SVGDocument doc =
                          (org.w3c.dom.svg.SVGDocument)
                            e.
                            getOwnerDocument(
                              );
                        org.apache.batik.dom.svg.SVGOMSVGElement se =
                          (org.apache.batik.dom.svg.SVGOMSVGElement)
                            e;
                        boolean isOutermost =
                          doc.
                          getRootElement(
                            ) ==
                          e;
                        if (!isOutermost) {
                            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _x =
                              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                                se.
                                getX(
                                  );
                            float x =
                              _x.
                              getCheckedValue(
                                );
                            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _y =
                              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                                se.
                                getY(
                                  );
                            float y =
                              _y.
                              getCheckedValue(
                                );
                            java.awt.geom.AffineTransform positionTransform =
                              java.awt.geom.AffineTransform.
                              getTranslateInstance(
                                x,
                                y);
                            org.apache.batik.gvt.CanvasGraphicsNode cgn;
                            cgn =
                              (org.apache.batik.gvt.CanvasGraphicsNode)
                                node;
                            cgn.
                              setPositionTransform(
                                positionTransform);
                            return;
                        }
                    }
                    else
                        if (ln.
                              equals(
                                SVG_VIEW_BOX_ATTRIBUTE) ||
                              ln.
                              equals(
                                SVG_PRESERVE_ASPECT_RATIO_ATTRIBUTE)) {
                            org.w3c.dom.svg.SVGDocument doc =
                              (org.w3c.dom.svg.SVGDocument)
                                e.
                                getOwnerDocument(
                                  );
                            org.apache.batik.dom.svg.SVGOMSVGElement se =
                              (org.apache.batik.dom.svg.SVGOMSVGElement)
                                e;
                            boolean isOutermost =
                              doc.
                              getRootElement(
                                ) ==
                              e;
                            float x =
                              0;
                            float y =
                              0;
                            if (!isOutermost) {
                                org.apache.batik.dom.svg.AbstractSVGAnimatedLength _x =
                                  (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                                    se.
                                    getX(
                                      );
                                x =
                                  _x.
                                    getCheckedValue(
                                      );
                                org.apache.batik.dom.svg.AbstractSVGAnimatedLength _y =
                                  (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                                    se.
                                    getY(
                                      );
                                y =
                                  _y.
                                    getCheckedValue(
                                      );
                            }
                            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _width =
                              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                                se.
                                getWidth(
                                  );
                            float w =
                              _width.
                              getCheckedValue(
                                );
                            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _height =
                              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                                se.
                                getHeight(
                                  );
                            float h =
                              _height.
                              getCheckedValue(
                                );
                            org.apache.batik.gvt.CanvasGraphicsNode cgn;
                            cgn =
                              (org.apache.batik.gvt.CanvasGraphicsNode)
                                node;
                            org.apache.batik.dom.svg.SVGOMAnimatedRect vb =
                              (org.apache.batik.dom.svg.SVGOMAnimatedRect)
                                se.
                                getViewBox(
                                  );
                            org.w3c.dom.svg.SVGAnimatedPreserveAspectRatio par =
                              se.
                              getPreserveAspectRatio(
                                );
                            java.awt.geom.AffineTransform newVT =
                              org.apache.batik.bridge.ViewBox.
                              getPreserveAspectRatioTransform(
                                e,
                                vb,
                                par,
                                w,
                                h,
                                ctx);
                            java.awt.geom.AffineTransform oldVT =
                              cgn.
                              getViewingTransform(
                                );
                            if (newVT.
                                  getScaleX(
                                    ) !=
                                  oldVT.
                                  getScaleX(
                                    ) ||
                                  newVT.
                                  getScaleY(
                                    ) !=
                                  oldVT.
                                  getScaleY(
                                    ) ||
                                  newVT.
                                  getShearX(
                                    ) !=
                                  oldVT.
                                  getShearX(
                                    ) ||
                                  newVT.
                                  getShearY(
                                    ) !=
                                  oldVT.
                                  getShearY(
                                    ))
                                rebuild =
                                  true;
                            else {
                                cgn.
                                  setViewingTransform(
                                    newVT);
                                java.awt.Shape clip =
                                  null;
                                if (org.apache.batik.bridge.CSSUtilities.
                                      convertOverflow(
                                        e)) {
                                    float[] offsets =
                                      org.apache.batik.bridge.CSSUtilities.
                                      convertClip(
                                        e);
                                    if (offsets ==
                                          null) {
                                        clip =
                                          new java.awt.geom.Rectangle2D.Float(
                                            x,
                                            y,
                                            w,
                                            h);
                                    }
                                    else {
                                        clip =
                                          new java.awt.geom.Rectangle2D.Float(
                                            x +
                                              offsets[3],
                                            y +
                                              offsets[0],
                                            w -
                                              offsets[1] -
                                              offsets[3],
                                            h -
                                              offsets[2] -
                                              offsets[0]);
                                    }
                                }
                                if (clip !=
                                      null) {
                                    try {
                                        java.awt.geom.AffineTransform at;
                                        at =
                                          cgn.
                                            getPositionTransform(
                                              );
                                        if (at ==
                                              null)
                                            at =
                                              new java.awt.geom.AffineTransform(
                                                );
                                        else
                                            at =
                                              new java.awt.geom.AffineTransform(
                                                at);
                                        at.
                                          concatenate(
                                            newVT);
                                        at =
                                          at.
                                            createInverse(
                                              );
                                        clip =
                                          at.
                                            createTransformedShape(
                                              clip);
                                        org.apache.batik.ext.awt.image.renderable.Filter filter =
                                          cgn.
                                          getGraphicsNodeRable(
                                            true);
                                        cgn.
                                          setClip(
                                            new org.apache.batik.ext.awt.image.renderable.ClipRable8Bit(
                                              filter,
                                              clip));
                                    }
                                    catch (java.awt.geom.NoninvertibleTransformException ex) {
                                        
                                    }
                                }
                            }
                        }
                if (rebuild) {
                    org.apache.batik.gvt.CompositeGraphicsNode gn =
                      node.
                      getParent(
                        );
                    gn.
                      remove(
                        node);
                    disposeTree(
                      e,
                      false);
                    handleElementAdded(
                      gn,
                      e.
                        getParentNode(
                          ),
                      e);
                    return;
                }
            }
        }
        catch (org.apache.batik.dom.svg.LiveAttributeException ex) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              ex);
        }
        super.
          handleAnimatedAttributeChanged(
            alav);
    }
    public static class SVGSVGElementViewport implements org.apache.batik.bridge.Viewport {
        private float width;
        private float height;
        public SVGSVGElementViewport(float w,
                                     float h) {
            super(
              );
            this.
              width =
              w;
            this.
              height =
              h;
        }
        public float getWidth() { return width;
        }
        public float getHeight() { return height;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "sdzu9b9l2CLjfo5N6XDlvwxlx3kuGQAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public java.util.List getIntersectionList(org.w3c.dom.svg.SVGRect svgRect,
                                              org.w3c.dom.Element end) {
        java.util.List ret =
          new java.util.ArrayList(
          );
        java.awt.geom.Rectangle2D rect =
          new java.awt.geom.Rectangle2D.Float(
          svgRect.
            getX(
              ),
          svgRect.
            getY(
              ),
          svgRect.
            getWidth(
              ),
          svgRect.
            getHeight(
              ));
        org.apache.batik.gvt.GraphicsNode svgGN =
          ctx.
          getGraphicsNode(
            e);
        if (svgGN ==
              null)
            return ret;
        java.awt.geom.Rectangle2D svgBounds =
          svgGN.
          getSensitiveBounds(
            );
        if (svgBounds ==
              null)
            return ret;
        if (!rect.
              intersects(
                svgBounds))
            return ret;
        org.w3c.dom.Element base =
          e;
        java.awt.geom.AffineTransform ati =
          svgGN.
          getGlobalTransform(
            );
        try {
            ati =
              ati.
                createInverse(
                  );
        }
        catch (java.awt.geom.NoninvertibleTransformException e) {
            
        }
        org.w3c.dom.Element curr;
        org.w3c.dom.Node next =
          base.
          getFirstChild(
            );
        while (next !=
                 null) {
            if (next instanceof org.w3c.dom.Element)
                break;
            next =
              next.
                getNextSibling(
                  );
        }
        if (next ==
              null)
            return ret;
        curr =
          (org.w3c.dom.Element)
            next;
        java.util.Set ancestors =
          null;
        if (end !=
              null) {
            ancestors =
              getAncestors(
                end,
                base);
            if (ancestors ==
                  null)
                end =
                  null;
        }
        while (curr !=
                 null) {
            java.lang.String nsURI =
              curr.
              getNamespaceURI(
                );
            java.lang.String tag =
              curr.
              getLocalName(
                );
            boolean isGroup;
            isGroup =
              SVG_NAMESPACE_URI.
                equals(
                  nsURI) &&
                (SVG_G_TAG.
                   equals(
                     tag) ||
                   SVG_SVG_TAG.
                   equals(
                     tag) ||
                   SVG_A_TAG.
                   equals(
                     tag));
            org.apache.batik.gvt.GraphicsNode gn =
              ctx.
              getGraphicsNode(
                curr);
            if (gn ==
                  null) {
                if (ancestors !=
                      null &&
                      ancestors.
                      contains(
                        curr))
                    break;
                curr =
                  getNext(
                    curr,
                    base,
                    end);
                continue;
            }
            java.awt.geom.AffineTransform at =
              gn.
              getGlobalTransform(
                );
            java.awt.geom.Rectangle2D gnBounds =
              gn.
              getSensitiveBounds(
                );
            at.
              preConcatenate(
                ati);
            if (gnBounds !=
                  null)
                gnBounds =
                  at.
                    createTransformedShape(
                      gnBounds).
                    getBounds2D(
                      );
            if (gnBounds ==
                  null ||
                  !rect.
                  intersects(
                    gnBounds)) {
                if (ancestors !=
                      null &&
                      ancestors.
                      contains(
                        curr))
                    break;
                curr =
                  getNext(
                    curr,
                    base,
                    end);
                continue;
            }
            if (isGroup) {
                next =
                  curr.
                    getFirstChild(
                      );
                while (next !=
                         null) {
                    if (next instanceof org.w3c.dom.Element)
                        break;
                    next =
                      next.
                        getNextSibling(
                          );
                }
                if (next !=
                      null) {
                    curr =
                      (org.w3c.dom.Element)
                        next;
                    continue;
                }
            }
            else {
                if (curr ==
                      end)
                    break;
                if (SVG_NAMESPACE_URI.
                      equals(
                        nsURI) &&
                      SVG_USE_TAG.
                      equals(
                        tag)) {
                    if (rect.
                          contains(
                            gnBounds))
                        ret.
                          add(
                            curr);
                }
                if (gn instanceof org.apache.batik.gvt.ShapeNode) {
                    org.apache.batik.gvt.ShapeNode sn =
                      (org.apache.batik.gvt.ShapeNode)
                        gn;
                    java.awt.Shape sensitive =
                      sn.
                      getSensitiveArea(
                        );
                    if (sensitive !=
                          null) {
                        sensitive =
                          at.
                            createTransformedShape(
                              sensitive);
                        if (sensitive.
                              intersects(
                                rect))
                            ret.
                              add(
                                curr);
                    }
                }
                else
                    if (gn instanceof org.apache.batik.gvt.TextNode) {
                        org.apache.batik.dom.svg.SVGOMElement svgElem =
                          (org.apache.batik.dom.svg.SVGOMElement)
                            curr;
                        org.apache.batik.bridge.SVGTextElementBridge txtBridge;
                        txtBridge =
                          (org.apache.batik.bridge.SVGTextElementBridge)
                            svgElem.
                            getSVGContext(
                              );
                        java.util.Set elems =
                          txtBridge.
                          getTextIntersectionSet(
                            at,
                            rect);
                        if (ancestors !=
                              null &&
                              ancestors.
                              contains(
                                curr))
                            filterChildren(
                              curr,
                              end,
                              elems,
                              ret);
                        else
                            ret.
                              addAll(
                                elems);
                    }
                    else {
                        ret.
                          add(
                            curr);
                    }
            }
            curr =
              getNext(
                curr,
                base,
                end);
        }
        return ret;
    }
    public java.util.List getEnclosureList(org.w3c.dom.svg.SVGRect svgRect,
                                           org.w3c.dom.Element end) {
        java.util.List ret =
          new java.util.ArrayList(
          );
        java.awt.geom.Rectangle2D rect =
          new java.awt.geom.Rectangle2D.Float(
          svgRect.
            getX(
              ),
          svgRect.
            getY(
              ),
          svgRect.
            getWidth(
              ),
          svgRect.
            getHeight(
              ));
        org.apache.batik.gvt.GraphicsNode svgGN =
          ctx.
          getGraphicsNode(
            e);
        if (svgGN ==
              null)
            return ret;
        java.awt.geom.Rectangle2D svgBounds =
          svgGN.
          getSensitiveBounds(
            );
        if (svgBounds ==
              null)
            return ret;
        if (!rect.
              intersects(
                svgBounds))
            return ret;
        org.w3c.dom.Element base =
          e;
        java.awt.geom.AffineTransform ati =
          svgGN.
          getGlobalTransform(
            );
        try {
            ati =
              ati.
                createInverse(
                  );
        }
        catch (java.awt.geom.NoninvertibleTransformException e) {
            
        }
        org.w3c.dom.Element curr;
        org.w3c.dom.Node next =
          base.
          getFirstChild(
            );
        while (next !=
                 null) {
            if (next instanceof org.w3c.dom.Element)
                break;
            next =
              next.
                getNextSibling(
                  );
        }
        if (next ==
              null)
            return ret;
        curr =
          (org.w3c.dom.Element)
            next;
        java.util.Set ancestors =
          null;
        if (end !=
              null) {
            ancestors =
              getAncestors(
                end,
                base);
            if (ancestors ==
                  null)
                end =
                  null;
        }
        while (curr !=
                 null) {
            java.lang.String nsURI =
              curr.
              getNamespaceURI(
                );
            java.lang.String tag =
              curr.
              getLocalName(
                );
            boolean isGroup;
            isGroup =
              SVG_NAMESPACE_URI.
                equals(
                  nsURI) &&
                (SVG_G_TAG.
                   equals(
                     tag) ||
                   SVG_SVG_TAG.
                   equals(
                     tag) ||
                   SVG_A_TAG.
                   equals(
                     tag));
            org.apache.batik.gvt.GraphicsNode gn =
              ctx.
              getGraphicsNode(
                curr);
            if (gn ==
                  null) {
                if (ancestors !=
                      null &&
                      ancestors.
                      contains(
                        curr))
                    break;
                curr =
                  getNext(
                    curr,
                    base,
                    end);
                continue;
            }
            java.awt.geom.AffineTransform at =
              gn.
              getGlobalTransform(
                );
            java.awt.geom.Rectangle2D gnBounds =
              gn.
              getSensitiveBounds(
                );
            at.
              preConcatenate(
                ati);
            if (gnBounds !=
                  null)
                gnBounds =
                  at.
                    createTransformedShape(
                      gnBounds).
                    getBounds2D(
                      );
            if (gnBounds ==
                  null ||
                  !rect.
                  intersects(
                    gnBounds)) {
                if (ancestors !=
                      null &&
                      ancestors.
                      contains(
                        curr))
                    break;
                curr =
                  getNext(
                    curr,
                    base,
                    end);
                continue;
            }
            if (isGroup) {
                next =
                  curr.
                    getFirstChild(
                      );
                while (next !=
                         null) {
                    if (next instanceof org.w3c.dom.Element)
                        break;
                    next =
                      next.
                        getNextSibling(
                          );
                }
                if (next !=
                      null) {
                    curr =
                      (org.w3c.dom.Element)
                        next;
                    continue;
                }
            }
            else {
                if (curr ==
                      end)
                    break;
                if (SVG_NAMESPACE_URI.
                      equals(
                        nsURI) &&
                      SVG_USE_TAG.
                      equals(
                        tag)) {
                    if (rect.
                          contains(
                            gnBounds))
                        ret.
                          add(
                            curr);
                }
                else
                    if (gn instanceof org.apache.batik.gvt.TextNode) {
                        org.apache.batik.dom.svg.SVGOMElement svgElem =
                          (org.apache.batik.dom.svg.SVGOMElement)
                            curr;
                        org.apache.batik.bridge.SVGTextElementBridge txtBridge;
                        txtBridge =
                          (org.apache.batik.bridge.SVGTextElementBridge)
                            svgElem.
                            getSVGContext(
                              );
                        java.util.Set elems =
                          txtBridge.
                          getTextEnclosureSet(
                            at,
                            rect);
                        if (ancestors !=
                              null &&
                              ancestors.
                              contains(
                                curr))
                            filterChildren(
                              curr,
                              end,
                              elems,
                              ret);
                        else
                            ret.
                              addAll(
                                elems);
                    }
                    else
                        if (rect.
                              contains(
                                gnBounds)) {
                            ret.
                              add(
                                curr);
                        }
            }
            curr =
              getNext(
                curr,
                base,
                end);
        }
        return ret;
    }
    public boolean checkIntersection(org.w3c.dom.Element element,
                                     org.w3c.dom.svg.SVGRect svgRect) {
        org.apache.batik.gvt.GraphicsNode svgGN =
          ctx.
          getGraphicsNode(
            e);
        if (svgGN ==
              null)
            return false;
        java.awt.geom.Rectangle2D rect =
          new java.awt.geom.Rectangle2D.Float(
          svgRect.
            getX(
              ),
          svgRect.
            getY(
              ),
          svgRect.
            getWidth(
              ),
          svgRect.
            getHeight(
              ));
        java.awt.geom.AffineTransform ati =
          svgGN.
          getGlobalTransform(
            );
        try {
            ati =
              ati.
                createInverse(
                  );
        }
        catch (java.awt.geom.NoninvertibleTransformException e) {
            
        }
        org.apache.batik.dom.svg.SVGContext svgctx =
          null;
        if (element instanceof org.apache.batik.dom.svg.SVGOMElement) {
            svgctx =
              ((org.apache.batik.dom.svg.SVGOMElement)
                 element).
                getSVGContext(
                  );
            if (svgctx instanceof org.apache.batik.bridge.SVGTextElementBridge ||
                  svgctx instanceof org.apache.batik.bridge.SVGTextElementBridge.AbstractTextChildSVGContext) {
                return org.apache.batik.bridge.SVGTextElementBridge.
                  getTextIntersection(
                    ctx,
                    element,
                    ati,
                    rect,
                    true);
            }
        }
        java.awt.geom.Rectangle2D gnBounds =
          null;
        org.apache.batik.gvt.GraphicsNode gn =
          ctx.
          getGraphicsNode(
            element);
        if (gn !=
              null)
            gnBounds =
              gn.
                getSensitiveBounds(
                  );
        if (gnBounds ==
              null)
            return false;
        java.awt.geom.AffineTransform at =
          gn.
          getGlobalTransform(
            );
        at.
          preConcatenate(
            ati);
        gnBounds =
          at.
            createTransformedShape(
              gnBounds).
            getBounds2D(
              );
        if (!rect.
              intersects(
                gnBounds))
            return false;
        if (!(gn instanceof org.apache.batik.gvt.ShapeNode))
            return true;
        org.apache.batik.gvt.ShapeNode sn =
          (org.apache.batik.gvt.ShapeNode)
            gn;
        java.awt.Shape sensitive =
          sn.
          getSensitiveArea(
            );
        if (sensitive ==
              null)
            return false;
        sensitive =
          at.
            createTransformedShape(
              sensitive);
        if (sensitive.
              intersects(
                rect))
            return true;
        return false;
    }
    public boolean checkEnclosure(org.w3c.dom.Element element,
                                  org.w3c.dom.svg.SVGRect svgRect) {
        org.apache.batik.gvt.GraphicsNode gn =
          ctx.
          getGraphicsNode(
            element);
        java.awt.geom.Rectangle2D gnBounds =
          null;
        org.apache.batik.dom.svg.SVGContext svgctx =
          null;
        if (element instanceof org.apache.batik.dom.svg.SVGOMElement) {
            svgctx =
              ((org.apache.batik.dom.svg.SVGOMElement)
                 element).
                getSVGContext(
                  );
            if (svgctx instanceof org.apache.batik.bridge.SVGTextElementBridge ||
                  svgctx instanceof org.apache.batik.bridge.SVGTextElementBridge.AbstractTextChildSVGContext) {
                gnBounds =
                  org.apache.batik.bridge.SVGTextElementBridge.
                    getTextBounds(
                      ctx,
                      element,
                      true);
                org.w3c.dom.Element p =
                  (org.w3c.dom.Element)
                    element.
                    getParentNode(
                      );
                while (p !=
                         null &&
                         gn ==
                         null) {
                    gn =
                      ctx.
                        getGraphicsNode(
                          p);
                    p =
                      (org.w3c.dom.Element)
                        p.
                        getParentNode(
                          );
                }
            }
            else
                if (gn !=
                      null)
                    gnBounds =
                      gn.
                        getSensitiveBounds(
                          );
        }
        else
            if (gn !=
                  null)
                gnBounds =
                  gn.
                    getSensitiveBounds(
                      );
        if (gnBounds ==
              null)
            return false;
        org.apache.batik.gvt.GraphicsNode svgGN =
          ctx.
          getGraphicsNode(
            e);
        if (svgGN ==
              null)
            return false;
        java.awt.geom.Rectangle2D rect =
          new java.awt.geom.Rectangle2D.Float(
          svgRect.
            getX(
              ),
          svgRect.
            getY(
              ),
          svgRect.
            getWidth(
              ),
          svgRect.
            getHeight(
              ));
        java.awt.geom.AffineTransform ati =
          svgGN.
          getGlobalTransform(
            );
        try {
            ati =
              ati.
                createInverse(
                  );
        }
        catch (java.awt.geom.NoninvertibleTransformException e) {
            
        }
        java.awt.geom.AffineTransform at =
          gn.
          getGlobalTransform(
            );
        at.
          preConcatenate(
            ati);
        gnBounds =
          at.
            createTransformedShape(
              gnBounds).
            getBounds2D(
              );
        return rect.
          contains(
            gnBounds);
    }
    public boolean filterChildren(org.w3c.dom.Element curr,
                                  org.w3c.dom.Element end,
                                  java.util.Set elems,
                                  java.util.List ret) {
        org.w3c.dom.Node child =
          curr.
          getFirstChild(
            );
        while (child !=
                 null) {
            if (child instanceof org.w3c.dom.Element &&
                  filterChildren(
                    (org.w3c.dom.Element)
                      child,
                    end,
                    elems,
                    ret))
                return true;
            child =
              child.
                getNextSibling(
                  );
        }
        if (curr ==
              end)
            return true;
        if (elems.
              contains(
                curr))
            ret.
              add(
                curr);
        return false;
    }
    protected java.util.Set getAncestors(org.w3c.dom.Element end,
                                         org.w3c.dom.Element base) {
        java.util.Set ret =
          new java.util.HashSet(
          );
        org.w3c.dom.Element p =
          end;
        do  {
            ret.
              add(
                p);
            p =
              (org.w3c.dom.Element)
                p.
                getParentNode(
                  );
        }while(p !=
                 null &&
                 p !=
                 base); 
        if (p ==
              null)
            return null;
        return ret;
    }
    protected org.w3c.dom.Element getNext(org.w3c.dom.Element curr,
                                          org.w3c.dom.Element base,
                                          org.w3c.dom.Element end) {
        org.w3c.dom.Node next;
        next =
          curr.
            getNextSibling(
              );
        while (next !=
                 null) {
            if (next instanceof org.w3c.dom.Element)
                break;
            next =
              next.
                getNextSibling(
                  );
        }
        while (next ==
                 null) {
            curr =
              (org.w3c.dom.Element)
                curr.
                getParentNode(
                  );
            if (curr ==
                  end ||
                  curr ==
                  base) {
                next =
                  null;
                break;
            }
            next =
              curr.
                getNextSibling(
                  );
            while (next !=
                     null) {
                if (next instanceof org.w3c.dom.Element)
                    break;
                next =
                  next.
                    getNextSibling(
                      );
            }
        }
        return (org.w3c.dom.Element)
                 next;
    }
    public void deselectAll() { ctx.getUserAgent(
                                      ).deselectAll(
                                          );
    }
    public int suspendRedraw(int max_wait_milliseconds) {
        org.apache.batik.bridge.UpdateManager um =
          ctx.
          getUpdateManager(
            );
        if (um !=
              null)
            return um.
              addRedrawSuspension(
                max_wait_milliseconds);
        return -1;
    }
    public boolean unsuspendRedraw(int suspend_handle_id) {
        org.apache.batik.bridge.UpdateManager um =
          ctx.
          getUpdateManager(
            );
        if (um !=
              null)
            return um.
              releaseRedrawSuspension(
                suspend_handle_id);
        return false;
    }
    public void unsuspendRedrawAll() { org.apache.batik.bridge.UpdateManager um =
                                         ctx.
                                         getUpdateManager(
                                           );
                                       if (um !=
                                             null)
                                           um.
                                             releaseAllRedrawSuspension(
                                               );
    }
    public void forceRedraw() { org.apache.batik.bridge.UpdateManager um =
                                  ctx.
                                  getUpdateManager(
                                    );
                                if (um !=
                                      null)
                                    um.
                                      forceRepaint(
                                        );
    }
    public void pauseAnimations() { ctx.getAnimationEngine(
                                          ).
                                      pause(
                                        );
    }
    public void unpauseAnimations() { ctx.
                                        getAnimationEngine(
                                          ).
                                        unpause(
                                          );
    }
    public boolean animationsPaused() { return ctx.
                                          getAnimationEngine(
                                            ).
                                          isPaused(
                                            );
    }
    public float getCurrentTime() { return ctx.
                                      getAnimationEngine(
                                        ).
                                      getCurrentTime(
                                        );
    }
    public void setCurrentTime(float t) {
        ctx.
          getAnimationEngine(
            ).
          setCurrentTime(
            t);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "a/FBje/fM7mtJmr0R/wRn87+GxOQozkpMgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "JSBc9Ugmj14lEyMOr1zFmYvlI+cQy/1Z");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("4tPgI+3EIt0YvbiQM1w4hPPk2UO8s1iH3Pdm3ElFye3a7oWNvJUXzpDsZzLy" +
       "C2HhHsXXTgk1y3l+L69fPIe88tcTquDznZ28vn1j5HVx731+OSOfzvucs37u" +
       "DNCfz8ivAfckR6alXqUe7DGnJISFm2LXVPdy+Ox55fCjANKFbdnt9421J186" +
       "I+93MvKbYeFW1Qw8N8iH+Df20H7rvNDeBHp55w7aHTcG2sFJL165rhdHHNPO" +
       "zqPHZqwhYeibchRq+dl5Xu9XzhDLf8jIvwcmdS45qqUd1nRUCwrSDU09Ja0v" +
       "n0NaOdvjANdLO2m99PdiQO47bhJ2oQ4DzHE+V/IK/uQMsfy3jPwRMCy59wk1" +
       "P9i+zpK9uHLiKPhkbMNISR4wPav8Fv2Nr35q89KL25NeWQq0sFC83nuxV7+a" +
       "m7109eQZL47t35j8Xu8nXv6L/86/4zAku/OkWl46S9CHsrrr+Dsu2/eBvrkf" +
       "7P903sF+BAxLfVt2+33DBjv7+bX9iP7lGSP6vzLy52HhMhjRrqNYbhD5+ftQ" +
       "OfefXiW1s3v8zVMy+tY5ZHRvlvgEaOkLuxa/cMNllDuHr+Vcf32GjP4mI98D" +
       "zgGYGGV5XO+v5RxulV3X0iRnL4Xvn1cKj4L+fnsnhRvkJ68phYPbry+Fgzsz" +
       "chOYFbkUjnQlY/3bI6wHN98ArBdfuy27/T4/1ptyhpuOsH76lG4/ljXzJGjv" +
       "vl27913PIrx6bxFYLTMIB/efqutNWdHSWXXt50ku1tecIfIHM3IZiFw3LaB0" +
       "6BzEJr7mnBL53eddzoDl2sU37rr7xlcq8o/9f6lXbogO3nAG1qcy8th24YZk" +
       "i5rsesAp4d6Vcd/9Q3p7cP9+XHL5PH4O+eQaCJZ7F3dm7+IrNtTXls+xMPXT" +
       "p4RUO0NI2WbJAQxsDBASAdzfXptzpKXzRmsZUnqHlL4xk+9495Ez8tCMvBks" +
       "bEHIrWVvySJWfslhH14d/OR512fZHOd28LgbA+94MHrKEVw0t6utA/wM2ExG" +
       "+sCyBFHgaY7KaKovZZsYB8Qe+OC8wN8AAL9tB/xtNxR43tMcydvPQPnOjACR" +
       "XIqc0ziPW7LpefUXAvh2C/CLN2gBfhzG/Iy8RUYUsGw+BfFqNVbPi/IpgM7Y" +
       "oTRuPMrwjLw4I26Y30dQtP0gHoPnnRdeFgF4O3jejYf3vjPyPpCRdwM99aQo" +
       "2K36DsO8YxDfc16Ij2ceYAcxufEQP3pG3scy8iEQzEbO2SA/fN5ILgP53h3I" +
       "9954kJ88I+8XM/JzYFUjHaGjMrDqKYPz/Dkw5scODwNsH9xh/OCNx/iZM/L+" +
       "WUZ+GQSHIBZAIx/EheHEtK+5X3WzbrlSuIf9T8+rv5k/+egO9kdvDOxj/uRX" +
       "c3z/4gzsX8zI5wD24AT2Uxr80iuBmYaFe69xsy27pnP/Vddnt1c+lc+9cOm2" +
       "+17g/iS/3HV0LfP2ceE2PbKs47cqjj3f4vmabuYyuH17x8LLMf2r3ebMNXZ3" +
       "w8It8tEW/sFvb/l/B6j3aX4w1Pn3cb5/Gxbu2POBqrYPx1m+DIIVwJI9/q6X" +
       "SwasdZ464/7fSRml2/Dn/uMKky987/lhA3BU5PilsGxbJ7/XfHiGFVG73aOX" +
       "XhgS7/5u/Ve2l9IUS9psslpuGxdu3d6PyyvNzsEevW5th3Xd0n/qB3d9/vYn" +
       "DzeI7tp2eK+8x/r28LVvgHVtL8zvbG1+874vvPmfv/Bn+TWQ/wdo4UPLcD4A" +
       "AA==");
}
