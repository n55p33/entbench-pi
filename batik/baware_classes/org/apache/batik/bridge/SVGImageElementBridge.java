package org.apache.batik.bridge;
public class SVGImageElementBridge extends org.apache.batik.bridge.AbstractGraphicsNodeBridge {
    protected org.w3c.dom.svg.SVGDocument imgDocument;
    protected org.w3c.dom.events.EventListener listener = null;
    protected org.apache.batik.bridge.BridgeContext subCtx = null;
    protected boolean hitCheckChildren = false;
    public SVGImageElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_IMAGE_TAG; }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.bridge.SVGImageElementBridge(
                                                            ); }
    public org.apache.batik.gvt.GraphicsNode createGraphicsNode(org.apache.batik.bridge.BridgeContext ctx,
                                                                org.w3c.dom.Element e) {
        org.apache.batik.gvt.ImageNode imageNode =
          (org.apache.batik.gvt.ImageNode)
            super.
            createGraphicsNode(
              ctx,
              e);
        if (imageNode ==
              null) {
            return null;
        }
        associateSVGContext(
          ctx,
          e,
          imageNode);
        hitCheckChildren =
          false;
        org.apache.batik.gvt.GraphicsNode node =
          buildImageGraphicsNode(
            ctx,
            e);
        if (node ==
              null) {
            org.w3c.dom.svg.SVGImageElement ie =
              (org.w3c.dom.svg.SVGImageElement)
                e;
            java.lang.String uriStr =
              ie.
              getHref(
                ).
              getAnimVal(
                );
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              e,
              ERR_URI_IMAGE_INVALID,
              new java.lang.Object[] { uriStr });
        }
        imageNode.
          setImage(
            node);
        imageNode.
          setHitCheckChildren(
            hitCheckChildren);
        java.awt.RenderingHints hints =
          null;
        hints =
          org.apache.batik.bridge.CSSUtilities.
            convertImageRendering(
              e,
              hints);
        hints =
          org.apache.batik.bridge.CSSUtilities.
            convertColorRendering(
              e,
              hints);
        if (hints !=
              null)
            imageNode.
              setRenderingHints(
                hints);
        return imageNode;
    }
    protected org.apache.batik.gvt.GraphicsNode buildImageGraphicsNode(org.apache.batik.bridge.BridgeContext ctx,
                                                                       org.w3c.dom.Element e) {
        org.w3c.dom.svg.SVGImageElement ie =
          (org.w3c.dom.svg.SVGImageElement)
            e;
        java.lang.String uriStr =
          ie.
          getHref(
            ).
          getAnimVal(
            );
        if (uriStr.
              length(
                ) ==
              0) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              e,
              ERR_ATTRIBUTE_MISSING,
              new java.lang.Object[] { "xlink:href" });
        }
        if (uriStr.
              indexOf(
                '#') !=
              -1) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              e,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { "xlink:href",
              uriStr });
        }
        java.lang.String baseURI =
          org.apache.batik.dom.AbstractNode.
          getBaseURI(
            e);
        org.apache.batik.util.ParsedURL purl;
        if (baseURI ==
              null) {
            purl =
              new org.apache.batik.util.ParsedURL(
                uriStr);
        }
        else {
            purl =
              new org.apache.batik.util.ParsedURL(
                baseURI,
                uriStr);
        }
        return createImageGraphicsNode(
                 ctx,
                 e,
                 purl);
    }
    protected org.apache.batik.gvt.GraphicsNode createImageGraphicsNode(org.apache.batik.bridge.BridgeContext ctx,
                                                                        org.w3c.dom.Element e,
                                                                        org.apache.batik.util.ParsedURL purl) {
        java.awt.geom.Rectangle2D bounds =
          getImageBounds(
            ctx,
            e);
        if (bounds.
              getWidth(
                ) ==
              0 ||
              bounds.
              getHeight(
                ) ==
              0) {
            org.apache.batik.gvt.ShapeNode sn =
              new org.apache.batik.gvt.ShapeNode(
              );
            sn.
              setShape(
                bounds);
            return sn;
        }
        org.w3c.dom.svg.SVGDocument svgDoc =
          (org.w3c.dom.svg.SVGDocument)
            e.
            getOwnerDocument(
              );
        java.lang.String docURL =
          svgDoc.
          getURL(
            );
        org.apache.batik.util.ParsedURL pDocURL =
          null;
        if (docURL !=
              null)
            pDocURL =
              new org.apache.batik.util.ParsedURL(
                docURL);
        org.apache.batik.bridge.UserAgent userAgent =
          ctx.
          getUserAgent(
            );
        try {
            userAgent.
              checkLoadExternalResource(
                purl,
                pDocURL);
        }
        catch (java.lang.SecurityException secEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              e,
              secEx,
              ERR_URI_UNSECURE,
              new java.lang.Object[] { purl });
        }
        org.apache.batik.bridge.DocumentLoader loader =
          ctx.
          getDocumentLoader(
            );
        org.apache.batik.ext.awt.image.spi.ImageTagRegistry reg =
          org.apache.batik.ext.awt.image.spi.ImageTagRegistry.
          getRegistry(
            );
        org.apache.batik.ext.awt.color.ICCColorSpaceExt colorspace =
          extractColorSpace(
            e,
            ctx);
        {
            try {
                org.w3c.dom.Document doc =
                  loader.
                  checkCache(
                    purl.
                      toString(
                        ));
                if (doc !=
                      null) {
                    imgDocument =
                      (org.w3c.dom.svg.SVGDocument)
                        doc;
                    return createSVGImageNode(
                             ctx,
                             e,
                             imgDocument);
                }
            }
            catch (org.apache.batik.bridge.BridgeException ex) {
                throw ex;
            }
            catch (java.lang.Exception ex) {
                
            }
            org.apache.batik.ext.awt.image.renderable.Filter img =
              reg.
              checkCache(
                purl,
                colorspace);
            if (img !=
                  null) {
                return createRasterImageNode(
                         ctx,
                         e,
                         img,
                         purl);
            }
        }
        org.apache.batik.bridge.SVGImageElementBridge.ProtectedStream reference =
          null;
        try {
            reference =
              openStream(
                e,
                purl);
        }
        catch (java.lang.SecurityException secEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              e,
              secEx,
              ERR_URI_UNSECURE,
              new java.lang.Object[] { purl });
        }
        catch (java.io.IOException ioe) {
            return createBrokenImageNode(
                     ctx,
                     e,
                     purl.
                       toString(
                         ),
                     ioe.
                       getLocalizedMessage(
                         ));
        }
        {
            org.apache.batik.ext.awt.image.renderable.Filter img =
              reg.
              readURL(
                reference,
                purl,
                colorspace,
                false,
                false);
            if (img !=
                  null) {
                return createRasterImageNode(
                         ctx,
                         e,
                         img,
                         purl);
            }
        }
        try {
            reference.
              retry(
                );
        }
        catch (java.io.IOException ioe) {
            reference.
              release(
                );
            reference =
              null;
            try {
                reference =
                  openStream(
                    e,
                    purl);
            }
            catch (java.io.IOException ioe2) {
                return createBrokenImageNode(
                         ctx,
                         e,
                         purl.
                           toString(
                             ),
                         ioe2.
                           getLocalizedMessage(
                             ));
            }
        }
        try {
            org.w3c.dom.Document doc =
              loader.
              loadDocument(
                purl.
                  toString(
                    ),
                reference);
            imgDocument =
              (org.w3c.dom.svg.SVGDocument)
                doc;
            return createSVGImageNode(
                     ctx,
                     e,
                     imgDocument);
        }
        catch (org.apache.batik.bridge.BridgeException ex) {
            throw ex;
        }
        catch (java.lang.SecurityException secEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              e,
              secEx,
              ERR_URI_UNSECURE,
              new java.lang.Object[] { purl });
        }
        catch (java.io.InterruptedIOException iioe) {
            if (org.apache.batik.util.HaltingThread.
                  hasBeenHalted(
                    ))
                throw new org.apache.batik.bridge.InterruptedBridgeException(
                  );
        }
        catch (org.apache.batik.bridge.InterruptedBridgeException ibe) {
            throw ibe;
        }
        catch (java.lang.Exception ex) {
            
        }
        try {
            reference.
              retry(
                );
        }
        catch (java.io.IOException ioe) {
            reference.
              release(
                );
            reference =
              null;
            try {
                reference =
                  openStream(
                    e,
                    purl);
            }
            catch (java.io.IOException ioe2) {
                return createBrokenImageNode(
                         ctx,
                         e,
                         purl.
                           toString(
                             ),
                         ioe2.
                           getLocalizedMessage(
                             ));
            }
        }
        try {
            org.apache.batik.ext.awt.image.renderable.Filter img =
              reg.
              readURL(
                reference,
                purl,
                colorspace,
                true,
                true);
            if (img !=
                  null) {
                return createRasterImageNode(
                         ctx,
                         e,
                         img,
                         purl);
            }
        }
        finally {
            reference.
              release(
                );
        }
        return null;
    }
    public static class ProtectedStream extends java.io.BufferedInputStream {
        static final int BUFFER_SIZE = 8192;
        ProtectedStream(java.io.InputStream is) {
            super(
              is,
              BUFFER_SIZE);
            super.
              mark(
                BUFFER_SIZE);
        }
        ProtectedStream(java.io.InputStream is,
                        int size) { super(
                                      is,
                                      size);
                                    super.
                                      mark(
                                        size);
        }
        public boolean markSupported() { return false;
        }
        public void mark(int sz) {  }
        public void reset() throws java.io.IOException {
            throw new java.io.IOException(
              "Reset unsupported");
        }
        public void retry() throws java.io.IOException {
            super.
              reset(
                );
        }
        public void close() throws java.io.IOException {
            
        }
        public void release() { try { super.
                                        close(
                                          );
                                }
                                catch (java.io.IOException ioe) {
                                    
                                } }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "a4bjGT7F4ZP/AlAZha5iHgAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "B9koAAA=");
    }
    protected org.apache.batik.bridge.SVGImageElementBridge.ProtectedStream openStream(org.w3c.dom.Element e,
                                                                                       org.apache.batik.util.ParsedURL purl)
          throws java.io.IOException { java.util.List mimeTypes =
                                         new java.util.ArrayList(
                                         org.apache.batik.ext.awt.image.spi.ImageTagRegistry.
                                           getRegistry(
                                             ).
                                           getRegisteredMimeTypes(
                                             ));
                                       mimeTypes.
                                         add(
                                           org.apache.batik.util.MimeTypeConstants.
                                             MIME_TYPES_SVG);
                                       java.io.InputStream reference =
                                         purl.
                                         openStream(
                                           mimeTypes.
                                             iterator(
                                               ));
                                       return new org.apache.batik.bridge.SVGImageElementBridge.ProtectedStream(
                                         reference);
    }
    protected org.apache.batik.gvt.GraphicsNode instantiateGraphicsNode() {
        return new org.apache.batik.gvt.ImageNode(
          );
    }
    public boolean isComposite() { return false;
    }
    protected void initializeDynamicSupport(org.apache.batik.bridge.BridgeContext ctx,
                                            org.w3c.dom.Element e,
                                            org.apache.batik.gvt.GraphicsNode node) {
        if (!ctx.
              isInteractive(
                ))
            return;
        ctx.
          bind(
            e,
            node);
        if (ctx.
              isDynamic(
                )) {
            this.
              e =
              e;
            this.
              node =
              node;
            this.
              ctx =
              ctx;
            ((org.apache.batik.dom.svg.SVGOMElement)
               e).
              setSVGContext(
                this);
        }
    }
    public void handleAnimatedAttributeChanged(org.apache.batik.dom.svg.AnimatedLiveAttributeValue alav) {
        try {
            java.lang.String ns =
              alav.
              getNamespaceURI(
                );
            java.lang.String ln =
              alav.
              getLocalName(
                );
            if (ns ==
                  null) {
                if (ln.
                      equals(
                        SVG_X_ATTRIBUTE) ||
                      ln.
                      equals(
                        SVG_Y_ATTRIBUTE)) {
                    updateImageBounds(
                      );
                    return;
                }
                else
                    if (ln.
                          equals(
                            SVG_WIDTH_ATTRIBUTE) ||
                          ln.
                          equals(
                            SVG_HEIGHT_ATTRIBUTE)) {
                        org.w3c.dom.svg.SVGImageElement ie =
                          (org.w3c.dom.svg.SVGImageElement)
                            e;
                        org.apache.batik.gvt.ImageNode imageNode =
                          (org.apache.batik.gvt.ImageNode)
                            node;
                        org.apache.batik.dom.svg.AbstractSVGAnimatedLength _attr;
                        if (ln.
                              charAt(
                                0) ==
                              'w') {
                            _attr =
                              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                                ie.
                                getWidth(
                                  );
                        }
                        else {
                            _attr =
                              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                                ie.
                                getHeight(
                                  );
                        }
                        float val =
                          _attr.
                          getCheckedValue(
                            );
                        if (val ==
                              0 ||
                              imageNode.
                              getImage(
                                ) instanceof org.apache.batik.gvt.ShapeNode) {
                            rebuildImageNode(
                              );
                        }
                        else {
                            updateImageBounds(
                              );
                        }
                        return;
                    }
                    else
                        if (ln.
                              equals(
                                SVG_PRESERVE_ASPECT_RATIO_ATTRIBUTE)) {
                            updateImageBounds(
                              );
                            return;
                        }
            }
            else
                if (ns.
                      equals(
                        XLINK_NAMESPACE_URI) &&
                      ln.
                      equals(
                        XLINK_HREF_ATTRIBUTE)) {
                    rebuildImageNode(
                      );
                    return;
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
    protected void updateImageBounds() { java.awt.geom.Rectangle2D bounds =
                                           getImageBounds(
                                             ctx,
                                             e);
                                         org.apache.batik.gvt.GraphicsNode imageNode =
                                           ((org.apache.batik.gvt.ImageNode)
                                              node).
                                           getImage(
                                             );
                                         float[] vb =
                                           null;
                                         if (imageNode instanceof org.apache.batik.gvt.RasterImageNode) {
                                             java.awt.geom.Rectangle2D imgBounds =
                                               ((org.apache.batik.gvt.RasterImageNode)
                                                  imageNode).
                                               getImageBounds(
                                                 );
                                             vb =
                                               (new float[4]);
                                             vb[0] =
                                               0;
                                             vb[1] =
                                               0;
                                             vb[2] =
                                               (float)
                                                 imgBounds.
                                                 getWidth(
                                                   );
                                             vb[3] =
                                               (float)
                                                 imgBounds.
                                                 getHeight(
                                                   );
                                         }
                                         else {
                                             if (imgDocument !=
                                                   null) {
                                                 org.w3c.dom.Element svgElement =
                                                   imgDocument.
                                                   getRootElement(
                                                     );
                                                 java.lang.String viewBox =
                                                   svgElement.
                                                   getAttributeNS(
                                                     null,
                                                     SVG_VIEW_BOX_ATTRIBUTE);
                                                 vb =
                                                   org.apache.batik.bridge.ViewBox.
                                                     parseViewBoxAttribute(
                                                       e,
                                                       viewBox,
                                                       ctx);
                                             }
                                         }
                                         if (imageNode !=
                                               null) {
                                             initializeViewport(
                                               ctx,
                                               e,
                                               imageNode,
                                               vb,
                                               bounds);
                                         }
    }
    protected void rebuildImageNode() { if (imgDocument !=
                                              null &&
                                              listener !=
                                              null) {
                                            org.apache.batik.dom.events.NodeEventTarget tgt =
                                              (org.apache.batik.dom.events.NodeEventTarget)
                                                imgDocument.
                                                getRootElement(
                                                  );
                                            tgt.
                                              removeEventListenerNS(
                                                org.apache.batik.util.XMLConstants.
                                                  XML_EVENTS_NAMESPACE_URI,
                                                SVG_EVENT_CLICK,
                                                listener,
                                                false);
                                            tgt.
                                              removeEventListenerNS(
                                                org.apache.batik.util.XMLConstants.
                                                  XML_EVENTS_NAMESPACE_URI,
                                                SVG_EVENT_KEYDOWN,
                                                listener,
                                                false);
                                            tgt.
                                              removeEventListenerNS(
                                                org.apache.batik.util.XMLConstants.
                                                  XML_EVENTS_NAMESPACE_URI,
                                                SVG_EVENT_KEYPRESS,
                                                listener,
                                                false);
                                            tgt.
                                              removeEventListenerNS(
                                                org.apache.batik.util.XMLConstants.
                                                  XML_EVENTS_NAMESPACE_URI,
                                                SVG_EVENT_KEYUP,
                                                listener,
                                                false);
                                            tgt.
                                              removeEventListenerNS(
                                                org.apache.batik.util.XMLConstants.
                                                  XML_EVENTS_NAMESPACE_URI,
                                                SVG_EVENT_MOUSEDOWN,
                                                listener,
                                                false);
                                            tgt.
                                              removeEventListenerNS(
                                                org.apache.batik.util.XMLConstants.
                                                  XML_EVENTS_NAMESPACE_URI,
                                                SVG_EVENT_MOUSEMOVE,
                                                listener,
                                                false);
                                            tgt.
                                              removeEventListenerNS(
                                                org.apache.batik.util.XMLConstants.
                                                  XML_EVENTS_NAMESPACE_URI,
                                                SVG_EVENT_MOUSEOUT,
                                                listener,
                                                false);
                                            tgt.
                                              removeEventListenerNS(
                                                org.apache.batik.util.XMLConstants.
                                                  XML_EVENTS_NAMESPACE_URI,
                                                SVG_EVENT_MOUSEOVER,
                                                listener,
                                                false);
                                            tgt.
                                              removeEventListenerNS(
                                                org.apache.batik.util.XMLConstants.
                                                  XML_EVENTS_NAMESPACE_URI,
                                                SVG_EVENT_MOUSEUP,
                                                listener,
                                                false);
                                            listener =
                                              null;
                                        }
                                        if (imgDocument !=
                                              null) {
                                            org.w3c.dom.svg.SVGSVGElement svgElement =
                                              imgDocument.
                                              getRootElement(
                                                );
                                            disposeTree(
                                              svgElement);
                                        }
                                        imgDocument =
                                          null;
                                        subCtx =
                                          null;
                                        org.apache.batik.gvt.GraphicsNode inode =
                                          buildImageGraphicsNode(
                                            ctx,
                                            e);
                                        org.apache.batik.gvt.ImageNode imgNode =
                                          (org.apache.batik.gvt.ImageNode)
                                            node;
                                        imgNode.
                                          setImage(
                                            inode);
                                        if (inode ==
                                              null) {
                                            org.w3c.dom.svg.SVGImageElement ie =
                                              (org.w3c.dom.svg.SVGImageElement)
                                                e;
                                            java.lang.String uriStr =
                                              ie.
                                              getHref(
                                                ).
                                              getAnimVal(
                                                );
                                            throw new org.apache.batik.bridge.BridgeException(
                                              ctx,
                                              e,
                                              ERR_URI_IMAGE_INVALID,
                                              new java.lang.Object[] { uriStr });
                                        }
    }
    protected void handleCSSPropertyChanged(int property) {
        switch (property) {
            case org.apache.batik.css.engine.SVGCSSEngine.
                   IMAGE_RENDERING_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   COLOR_INTERPOLATION_INDEX:
                java.awt.RenderingHints hints =
                  org.apache.batik.bridge.CSSUtilities.
                  convertImageRendering(
                    e,
                    null);
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
            default:
                super.
                  handleCSSPropertyChanged(
                    property);
        }
    }
    protected org.apache.batik.gvt.GraphicsNode createRasterImageNode(org.apache.batik.bridge.BridgeContext ctx,
                                                                      org.w3c.dom.Element e,
                                                                      org.apache.batik.ext.awt.image.renderable.Filter img,
                                                                      org.apache.batik.util.ParsedURL purl) {
        java.awt.geom.Rectangle2D bounds =
          getImageBounds(
            ctx,
            e);
        if (bounds.
              getWidth(
                ) ==
              0 ||
              bounds.
              getHeight(
                ) ==
              0) {
            org.apache.batik.gvt.ShapeNode sn =
              new org.apache.batik.gvt.ShapeNode(
              );
            sn.
              setShape(
                bounds);
            return sn;
        }
        if (org.apache.batik.ext.awt.image.spi.BrokenLinkProvider.
              hasBrokenLinkProperty(
                img)) {
            java.lang.Object o =
              img.
              getProperty(
                org.apache.batik.ext.awt.image.spi.BrokenLinkProvider.
                  BROKEN_LINK_PROPERTY);
            java.lang.String msg =
              "unknown";
            if (o instanceof java.lang.String)
                msg =
                  (java.lang.String)
                    o;
            org.w3c.dom.svg.SVGDocument doc =
              ctx.
              getUserAgent(
                ).
              getBrokenLinkDocument(
                e,
                purl.
                  toString(
                    ),
                msg);
            return createSVGImageNode(
                     ctx,
                     e,
                     doc);
        }
        org.apache.batik.gvt.RasterImageNode node =
          new org.apache.batik.gvt.RasterImageNode(
          );
        node.
          setImage(
            img);
        java.awt.geom.Rectangle2D imgBounds =
          img.
          getBounds2D(
            );
        float[] vb =
          new float[4];
        vb[0] =
          0;
        vb[1] =
          0;
        vb[2] =
          (float)
            imgBounds.
            getWidth(
              );
        vb[3] =
          (float)
            imgBounds.
            getHeight(
              );
        initializeViewport(
          ctx,
          e,
          node,
          vb,
          bounds);
        return node;
    }
    protected org.apache.batik.gvt.GraphicsNode createSVGImageNode(org.apache.batik.bridge.BridgeContext ctx,
                                                                   org.w3c.dom.Element e,
                                                                   org.w3c.dom.svg.SVGDocument imgDocument) {
        org.apache.batik.css.engine.CSSEngine eng =
          ((org.apache.batik.dom.svg.SVGOMDocument)
             imgDocument).
          getCSSEngine(
            );
        subCtx =
          ctx.
            createSubBridgeContext(
              (org.apache.batik.dom.svg.SVGOMDocument)
                imgDocument);
        org.apache.batik.gvt.CompositeGraphicsNode result =
          new org.apache.batik.gvt.CompositeGraphicsNode(
          );
        java.awt.geom.Rectangle2D bounds =
          getImageBounds(
            ctx,
            e);
        if (bounds.
              getWidth(
                ) ==
              0 ||
              bounds.
              getHeight(
                ) ==
              0) {
            org.apache.batik.gvt.ShapeNode sn =
              new org.apache.batik.gvt.ShapeNode(
              );
            sn.
              setShape(
                bounds);
            result.
              getChildren(
                ).
              add(
                sn);
            return result;
        }
        java.awt.geom.Rectangle2D r =
          org.apache.batik.bridge.CSSUtilities.
          convertEnableBackground(
            e);
        if (r !=
              null) {
            result.
              setBackgroundEnable(
                r);
        }
        org.w3c.dom.svg.SVGSVGElement svgElement =
          imgDocument.
          getRootElement(
            );
        org.apache.batik.gvt.CanvasGraphicsNode node;
        node =
          (org.apache.batik.gvt.CanvasGraphicsNode)
            subCtx.
            getGVTBuilder(
              ).
            build(
              subCtx,
              svgElement);
        if (eng ==
              null &&
              ctx.
              isInteractive(
                )) {
            subCtx.
              addUIEventListeners(
                imgDocument);
        }
        node.
          setClip(
            null);
        node.
          setViewingTransform(
            new java.awt.geom.AffineTransform(
              ));
        result.
          getChildren(
            ).
          add(
            node);
        java.lang.String viewBox =
          svgElement.
          getAttributeNS(
            null,
            SVG_VIEW_BOX_ATTRIBUTE);
        float[] vb =
          org.apache.batik.bridge.ViewBox.
          parseViewBoxAttribute(
            e,
            viewBox,
            ctx);
        initializeViewport(
          ctx,
          e,
          result,
          vb,
          bounds);
        if (ctx.
              isInteractive(
                )) {
            listener =
              new org.apache.batik.bridge.SVGImageElementBridge.ForwardEventListener(
                svgElement,
                e);
            org.apache.batik.dom.events.NodeEventTarget tgt =
              (org.apache.batik.dom.events.NodeEventTarget)
                svgElement;
            tgt.
              addEventListenerNS(
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                SVG_EVENT_CLICK,
                listener,
                false,
                null);
            subCtx.
              storeEventListenerNS(
                tgt,
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                SVG_EVENT_CLICK,
                listener,
                false);
            tgt.
              addEventListenerNS(
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                SVG_EVENT_KEYDOWN,
                listener,
                false,
                null);
            subCtx.
              storeEventListenerNS(
                tgt,
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                SVG_EVENT_KEYDOWN,
                listener,
                false);
            tgt.
              addEventListenerNS(
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                SVG_EVENT_KEYPRESS,
                listener,
                false,
                null);
            subCtx.
              storeEventListenerNS(
                tgt,
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                SVG_EVENT_KEYPRESS,
                listener,
                false);
            tgt.
              addEventListenerNS(
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                SVG_EVENT_KEYUP,
                listener,
                false,
                null);
            subCtx.
              storeEventListenerNS(
                tgt,
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                SVG_EVENT_KEYUP,
                listener,
                false);
            tgt.
              addEventListenerNS(
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                SVG_EVENT_MOUSEDOWN,
                listener,
                false,
                null);
            subCtx.
              storeEventListenerNS(
                tgt,
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                SVG_EVENT_MOUSEDOWN,
                listener,
                false);
            tgt.
              addEventListenerNS(
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                SVG_EVENT_MOUSEMOVE,
                listener,
                false,
                null);
            subCtx.
              storeEventListenerNS(
                tgt,
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                SVG_EVENT_MOUSEMOVE,
                listener,
                false);
            tgt.
              addEventListenerNS(
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                SVG_EVENT_MOUSEOUT,
                listener,
                false,
                null);
            subCtx.
              storeEventListenerNS(
                tgt,
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                SVG_EVENT_MOUSEOUT,
                listener,
                false);
            tgt.
              addEventListenerNS(
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                SVG_EVENT_MOUSEOVER,
                listener,
                false,
                null);
            subCtx.
              storeEventListenerNS(
                tgt,
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                SVG_EVENT_MOUSEOVER,
                listener,
                false);
            tgt.
              addEventListenerNS(
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                SVG_EVENT_MOUSEUP,
                listener,
                false,
                null);
            subCtx.
              storeEventListenerNS(
                tgt,
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                SVG_EVENT_MOUSEUP,
                listener,
                false);
        }
        return result;
    }
    public void dispose() { if (imgDocument !=
                                  null &&
                                  listener !=
                                  null) {
                                org.apache.batik.dom.events.NodeEventTarget tgt =
                                  (org.apache.batik.dom.events.NodeEventTarget)
                                    imgDocument.
                                    getRootElement(
                                      );
                                tgt.
                                  removeEventListenerNS(
                                    org.apache.batik.util.XMLConstants.
                                      XML_EVENTS_NAMESPACE_URI,
                                    SVG_EVENT_CLICK,
                                    listener,
                                    false);
                                tgt.
                                  removeEventListenerNS(
                                    org.apache.batik.util.XMLConstants.
                                      XML_EVENTS_NAMESPACE_URI,
                                    SVG_EVENT_KEYDOWN,
                                    listener,
                                    false);
                                tgt.
                                  removeEventListenerNS(
                                    org.apache.batik.util.XMLConstants.
                                      XML_EVENTS_NAMESPACE_URI,
                                    SVG_EVENT_KEYPRESS,
                                    listener,
                                    false);
                                tgt.
                                  removeEventListenerNS(
                                    org.apache.batik.util.XMLConstants.
                                      XML_EVENTS_NAMESPACE_URI,
                                    SVG_EVENT_KEYUP,
                                    listener,
                                    false);
                                tgt.
                                  removeEventListenerNS(
                                    org.apache.batik.util.XMLConstants.
                                      XML_EVENTS_NAMESPACE_URI,
                                    SVG_EVENT_MOUSEDOWN,
                                    listener,
                                    false);
                                tgt.
                                  removeEventListenerNS(
                                    org.apache.batik.util.XMLConstants.
                                      XML_EVENTS_NAMESPACE_URI,
                                    SVG_EVENT_MOUSEMOVE,
                                    listener,
                                    false);
                                tgt.
                                  removeEventListenerNS(
                                    org.apache.batik.util.XMLConstants.
                                      XML_EVENTS_NAMESPACE_URI,
                                    SVG_EVENT_MOUSEOUT,
                                    listener,
                                    false);
                                tgt.
                                  removeEventListenerNS(
                                    org.apache.batik.util.XMLConstants.
                                      XML_EVENTS_NAMESPACE_URI,
                                    SVG_EVENT_MOUSEOVER,
                                    listener,
                                    false);
                                tgt.
                                  removeEventListenerNS(
                                    org.apache.batik.util.XMLConstants.
                                      XML_EVENTS_NAMESPACE_URI,
                                    SVG_EVENT_MOUSEUP,
                                    listener,
                                    false);
                                listener =
                                  null;
                            }
                            if (imgDocument !=
                                  null) {
                                org.w3c.dom.svg.SVGSVGElement svgElement =
                                  imgDocument.
                                  getRootElement(
                                    );
                                disposeTree(
                                  svgElement);
                                imgDocument =
                                  null;
                                subCtx =
                                  null;
                            }
                            super.dispose(
                                    ); }
    protected static class ForwardEventListener implements org.w3c.dom.events.EventListener {
        protected org.w3c.dom.Element svgElement;
        protected org.w3c.dom.Element imgElement;
        public ForwardEventListener(org.w3c.dom.Element svgElement,
                                    org.w3c.dom.Element imgElement) {
            super(
              );
            this.
              svgElement =
              svgElement;
            this.
              imgElement =
              imgElement;
        }
        public void handleEvent(org.w3c.dom.events.Event e) {
            org.apache.batik.dom.events.DOMMouseEvent evt =
              (org.apache.batik.dom.events.DOMMouseEvent)
                e;
            org.apache.batik.dom.events.DOMMouseEvent newMouseEvent =
              (org.apache.batik.dom.events.DOMMouseEvent)
                ((org.w3c.dom.events.DocumentEvent)
                   imgElement.
                   getOwnerDocument(
                     )).
                createEvent(
                  "MouseEvents");
            newMouseEvent.
              initMouseEventNS(
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                evt.
                  getType(
                    ),
                evt.
                  getBubbles(
                    ),
                evt.
                  getCancelable(
                    ),
                evt.
                  getView(
                    ),
                evt.
                  getDetail(
                    ),
                evt.
                  getScreenX(
                    ),
                evt.
                  getScreenY(
                    ),
                evt.
                  getClientX(
                    ),
                evt.
                  getClientY(
                    ),
                evt.
                  getButton(
                    ),
                (org.w3c.dom.events.EventTarget)
                  imgElement,
                evt.
                  getModifiersString(
                    ));
            ((org.w3c.dom.events.EventTarget)
               imgElement).
              dispatchEvent(
                newMouseEvent);
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
           "qBNaIgAA");
    }
    protected static void initializeViewport(org.apache.batik.bridge.BridgeContext ctx,
                                             org.w3c.dom.Element e,
                                             org.apache.batik.gvt.GraphicsNode node,
                                             float[] vb,
                                             java.awt.geom.Rectangle2D bounds) {
        float x =
          (float)
            bounds.
            getX(
              );
        float y =
          (float)
            bounds.
            getY(
              );
        float w =
          (float)
            bounds.
            getWidth(
              );
        float h =
          (float)
            bounds.
            getHeight(
              );
        try {
            org.w3c.dom.svg.SVGImageElement ie =
              (org.w3c.dom.svg.SVGImageElement)
                e;
            org.apache.batik.dom.svg.SVGOMAnimatedPreserveAspectRatio _par =
              (org.apache.batik.dom.svg.SVGOMAnimatedPreserveAspectRatio)
                ie.
                getPreserveAspectRatio(
                  );
            _par.
              check(
                );
            java.awt.geom.AffineTransform at =
              org.apache.batik.bridge.ViewBox.
              getPreserveAspectRatioTransform(
                e,
                vb,
                w,
                h,
                _par,
                ctx);
            at.
              preConcatenate(
                java.awt.geom.AffineTransform.
                  getTranslateInstance(
                    x,
                    y));
            node.
              setTransform(
                at);
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
                    at =
                      at.
                        createInverse(
                          );
                    org.apache.batik.ext.awt.image.renderable.Filter filter =
                      node.
                      getGraphicsNodeRable(
                        true);
                    clip =
                      at.
                        createTransformedShape(
                          clip);
                    node.
                      setClip(
                        new org.apache.batik.ext.awt.image.renderable.ClipRable8Bit(
                          filter,
                          clip));
                }
                catch (java.awt.geom.NoninvertibleTransformException ex) {
                    
                }
            }
        }
        catch (org.apache.batik.dom.svg.LiveAttributeException ex) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              ex);
        }
    }
    protected static org.apache.batik.ext.awt.color.ICCColorSpaceExt extractColorSpace(org.w3c.dom.Element element,
                                                                                       org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String colorProfileProperty =
          org.apache.batik.bridge.CSSUtilities.
          getComputedStyle(
            element,
            org.apache.batik.css.engine.SVGCSSEngine.
              COLOR_PROFILE_INDEX).
          getStringValue(
            );
        org.apache.batik.ext.awt.color.ICCColorSpaceExt colorSpace =
          null;
        if (CSS_SRGB_VALUE.
              equalsIgnoreCase(
                colorProfileProperty)) {
            colorSpace =
              new org.apache.batik.ext.awt.color.ICCColorSpaceExt(
                java.awt.color.ICC_Profile.
                  getInstance(
                    java.awt.color.ColorSpace.
                      CS_sRGB),
                org.apache.batik.ext.awt.color.ICCColorSpaceExt.
                  AUTO);
        }
        else
            if (!CSS_AUTO_VALUE.
                  equalsIgnoreCase(
                    colorProfileProperty) &&
                  !"".
                  equalsIgnoreCase(
                    colorProfileProperty)) {
                org.apache.batik.bridge.SVGColorProfileElementBridge profileBridge =
                  (org.apache.batik.bridge.SVGColorProfileElementBridge)
                    ctx.
                    getBridge(
                      SVG_NAMESPACE_URI,
                      SVG_COLOR_PROFILE_TAG);
                if (profileBridge !=
                      null) {
                    colorSpace =
                      profileBridge.
                        createICCColorSpaceExt(
                          ctx,
                          element,
                          colorProfileProperty);
                }
            }
        return colorSpace;
    }
    protected static java.awt.geom.Rectangle2D getImageBounds(org.apache.batik.bridge.BridgeContext ctx,
                                                              org.w3c.dom.Element element) {
        try {
            org.w3c.dom.svg.SVGImageElement ie =
              (org.w3c.dom.svg.SVGImageElement)
                element;
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _x =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                ie.
                getX(
                  );
            float x =
              _x.
              getCheckedValue(
                );
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _y =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                ie.
                getY(
                  );
            float y =
              _y.
              getCheckedValue(
                );
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _width =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                ie.
                getWidth(
                  );
            float w =
              _width.
              getCheckedValue(
                );
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _height =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                ie.
                getHeight(
                  );
            float h =
              _height.
              getCheckedValue(
                );
            return new java.awt.geom.Rectangle2D.Float(
              x,
              y,
              w,
              h);
        }
        catch (org.apache.batik.dom.svg.LiveAttributeException ex) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              ex);
        }
    }
    org.apache.batik.gvt.GraphicsNode createBrokenImageNode(org.apache.batik.bridge.BridgeContext ctx,
                                                            org.w3c.dom.Element e,
                                                            java.lang.String uri,
                                                            java.lang.String message) {
        org.w3c.dom.svg.SVGDocument doc =
          ctx.
          getUserAgent(
            ).
          getBrokenLinkDocument(
            e,
            uri,
            org.apache.batik.bridge.Messages.
              formatMessage(
                URI_IMAGE_ERROR,
                new java.lang.Object[] { message }));
        return createSVGImageNode(
                 ctx,
                 e,
                 doc);
    }
    static org.apache.batik.bridge.SVGBrokenLinkProvider
      brokenLinkProvider =
      new org.apache.batik.bridge.SVGBrokenLinkProvider(
      );
    static { org.apache.batik.ext.awt.image.spi.ImageTagRegistry.
               setBrokenLinkProvider(
                 brokenLinkProvider); }
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
       "2EXU4HW0K5HdLaFmWbKp0BndRwcg6u4Q");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
