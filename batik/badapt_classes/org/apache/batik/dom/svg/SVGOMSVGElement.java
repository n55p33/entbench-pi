package org.apache.batik.dom.svg;
public class SVGOMSVGElement extends org.apache.batik.dom.svg.SVGStylableElement implements org.w3c.dom.svg.SVGSVGElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGStylableElement.
                 xmlTraitInformation);
             t.put(null, SVG_X_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH,
                     PERCENTAGE_VIEWPORT_WIDTH));
             t.put(null, SVG_Y_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH,
                     PERCENTAGE_VIEWPORT_HEIGHT));
             t.put(null, SVG_WIDTH_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH,
                     PERCENTAGE_VIEWPORT_WIDTH));
             t.put(null, SVG_HEIGHT_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH,
                     PERCENTAGE_VIEWPORT_HEIGHT));
             t.put(null, SVG_PRESERVE_ASPECT_RATIO_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_PRESERVE_ASPECT_RATIO_VALUE));
             t.put(null, SVG_VIEW_BOX_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_RECT));
             t.put(null, SVG_EXTERNAL_RESOURCES_REQUIRED_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_BOOLEAN));
             xmlTraitInformation = t; }
    protected static final org.apache.batik.dom.svg.AttributeInitializer
      attributeInitializer;
    static { attributeInitializer = new org.apache.batik.dom.svg.AttributeInitializer(
                                      7);
             attributeInitializer.addAttribute(
                                    org.apache.batik.dom.util.XMLSupport.
                                      XMLNS_NAMESPACE_URI,
                                    null,
                                    "xmlns",
                                    SVG_NAMESPACE_URI);
             attributeInitializer.addAttribute(
                                    org.apache.batik.dom.util.XMLSupport.
                                      XMLNS_NAMESPACE_URI,
                                    "xmlns",
                                    "xlink",
                                    org.apache.batik.dom.util.XLinkSupport.
                                      XLINK_NAMESPACE_URI);
             attributeInitializer.addAttribute(
                                    null,
                                    null,
                                    SVG_PRESERVE_ASPECT_RATIO_ATTRIBUTE,
                                    "xMidYMid meet");
             attributeInitializer.addAttribute(
                                    null,
                                    null,
                                    SVG_ZOOM_AND_PAN_ATTRIBUTE,
                                    SVG_MAGNIFY_VALUE);
             attributeInitializer.addAttribute(
                                    null,
                                    null,
                                    SVG_VERSION_ATTRIBUTE,
                                    SVG_VERSION);
             attributeInitializer.addAttribute(
                                    null,
                                    null,
                                    SVG_CONTENT_SCRIPT_TYPE_ATTRIBUTE,
                                    "text/ecmascript");
             attributeInitializer.addAttribute(
                                    null,
                                    null,
                                    SVG_CONTENT_STYLE_TYPE_ATTRIBUTE,
                                    "text/css");
    }
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      x;
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      y;
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      width;
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      height;
    protected org.apache.batik.dom.svg.SVGOMAnimatedBoolean
      externalResourcesRequired;
    protected org.apache.batik.dom.svg.SVGOMAnimatedPreserveAspectRatio
      preserveAspectRatio;
    protected org.apache.batik.dom.svg.SVGOMAnimatedRect
      viewBox;
    protected SVGOMSVGElement() { super();
    }
    public SVGOMSVGElement(java.lang.String prefix,
                           org.apache.batik.dom.AbstractDocument owner) {
        super(
          prefix,
          owner);
        initializeLiveAttributes(
          );
    }
    protected void initializeAllLiveAttributes() {
        super.
          initializeAllLiveAttributes(
            );
        initializeLiveAttributes(
          );
    }
    private void initializeLiveAttributes() {
        x =
          createLiveAnimatedLength(
            null,
            SVG_X_ATTRIBUTE,
            SVG_SVG_X_DEFAULT_VALUE,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              HORIZONTAL_LENGTH,
            false);
        y =
          createLiveAnimatedLength(
            null,
            SVG_Y_ATTRIBUTE,
            SVG_SVG_Y_DEFAULT_VALUE,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              VERTICAL_LENGTH,
            false);
        width =
          createLiveAnimatedLength(
            null,
            SVG_WIDTH_ATTRIBUTE,
            SVG_SVG_WIDTH_DEFAULT_VALUE,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              HORIZONTAL_LENGTH,
            true);
        height =
          createLiveAnimatedLength(
            null,
            SVG_HEIGHT_ATTRIBUTE,
            SVG_SVG_HEIGHT_DEFAULT_VALUE,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              VERTICAL_LENGTH,
            true);
        externalResourcesRequired =
          createLiveAnimatedBoolean(
            null,
            SVG_EXTERNAL_RESOURCES_REQUIRED_ATTRIBUTE,
            false);
        preserveAspectRatio =
          createLiveAnimatedPreserveAspectRatio(
            );
        viewBox =
          createLiveAnimatedRect(
            null,
            SVG_VIEW_BOX_ATTRIBUTE,
            null);
    }
    public java.lang.String getLocalName() {
        return SVG_SVG_TAG;
    }
    public org.w3c.dom.svg.SVGAnimatedLength getX() {
        return x;
    }
    public org.w3c.dom.svg.SVGAnimatedLength getY() {
        return y;
    }
    public org.w3c.dom.svg.SVGAnimatedLength getWidth() {
        return width;
    }
    public org.w3c.dom.svg.SVGAnimatedLength getHeight() {
        return height;
    }
    public java.lang.String getContentScriptType() {
        return getAttributeNS(
                 null,
                 SVG_CONTENT_SCRIPT_TYPE_ATTRIBUTE);
    }
    public void setContentScriptType(java.lang.String type) {
        setAttributeNS(
          null,
          SVG_CONTENT_SCRIPT_TYPE_ATTRIBUTE,
          type);
    }
    public java.lang.String getContentStyleType() {
        return getAttributeNS(
                 null,
                 SVG_CONTENT_STYLE_TYPE_ATTRIBUTE);
    }
    public void setContentStyleType(java.lang.String type) {
        setAttributeNS(
          null,
          SVG_CONTENT_STYLE_TYPE_ATTRIBUTE,
          type);
    }
    public org.w3c.dom.svg.SVGRect getViewport() {
        org.apache.batik.dom.svg.SVGContext ctx =
          getSVGContext(
            );
        return new org.apache.batik.dom.svg.SVGOMRect(
          0,
          0,
          ctx.
            getViewportWidth(
              ),
          ctx.
            getViewportHeight(
              ));
    }
    public float getPixelUnitToMillimeterX() {
        return getSVGContext(
                 ).
          getPixelUnitToMillimeter(
            );
    }
    public float getPixelUnitToMillimeterY() {
        return getSVGContext(
                 ).
          getPixelUnitToMillimeter(
            );
    }
    public float getScreenPixelToMillimeterX() {
        return getSVGContext(
                 ).
          getPixelUnitToMillimeter(
            );
    }
    public float getScreenPixelToMillimeterY() {
        return getSVGContext(
                 ).
          getPixelUnitToMillimeter(
            );
    }
    public boolean getUseCurrentView() { throw new java.lang.UnsupportedOperationException(
                                           "SVGSVGElement.getUseCurrentView is not implemented");
    }
    public void setUseCurrentView(boolean useCurrentView)
          throws org.w3c.dom.DOMException {
        throw new java.lang.UnsupportedOperationException(
          "SVGSVGElement.setUseCurrentView is not implemented");
    }
    public org.w3c.dom.svg.SVGViewSpec getCurrentView() {
        throw new java.lang.UnsupportedOperationException(
          "SVGSVGElement.getCurrentView is not implemented");
    }
    public float getCurrentScale() { java.awt.geom.AffineTransform scrnTrans =
                                       getSVGContext(
                                         ).
                                       getScreenTransform(
                                         );
                                     if (scrnTrans !=
                                           null) {
                                         return (float)
                                                  java.lang.Math.
                                                  sqrt(
                                                    scrnTrans.
                                                      getDeterminant(
                                                        ));
                                     }
                                     return 1;
    }
    public void setCurrentScale(float currentScale)
          throws org.w3c.dom.DOMException {
        org.apache.batik.dom.svg.SVGContext context =
          getSVGContext(
            );
        java.awt.geom.AffineTransform scrnTrans =
          context.
          getScreenTransform(
            );
        float scale =
          1;
        if (scrnTrans !=
              null) {
            scale =
              (float)
                java.lang.Math.
                sqrt(
                  scrnTrans.
                    getDeterminant(
                      ));
        }
        float delta =
          currentScale /
          scale;
        scrnTrans =
          new java.awt.geom.AffineTransform(
            scrnTrans.
              getScaleX(
                ) *
              delta,
            scrnTrans.
              getShearY(
                ) *
              delta,
            scrnTrans.
              getShearX(
                ) *
              delta,
            scrnTrans.
              getScaleY(
                ) *
              delta,
            scrnTrans.
              getTranslateX(
                ),
            scrnTrans.
              getTranslateY(
                ));
        context.
          setScreenTransform(
            scrnTrans);
    }
    public org.w3c.dom.svg.SVGPoint getCurrentTranslate() {
        return new org.w3c.dom.svg.SVGPoint(
          ) {
            protected java.awt.geom.AffineTransform getScreenTransform() {
                org.apache.batik.dom.svg.SVGContext context =
                  getSVGContext(
                    );
                return context.
                  getScreenTransform(
                    );
            }
            public float getX() {
                java.awt.geom.AffineTransform scrnTrans =
                  getScreenTransform(
                    );
                return (float)
                         scrnTrans.
                         getTranslateX(
                           );
            }
            public float getY() {
                java.awt.geom.AffineTransform scrnTrans =
                  getScreenTransform(
                    );
                return (float)
                         scrnTrans.
                         getTranslateY(
                           );
            }
            public void setX(float newX) {
                org.apache.batik.dom.svg.SVGContext context =
                  getSVGContext(
                    );
                java.awt.geom.AffineTransform scrnTrans =
                  context.
                  getScreenTransform(
                    );
                scrnTrans =
                  new java.awt.geom.AffineTransform(
                    scrnTrans.
                      getScaleX(
                        ),
                    scrnTrans.
                      getShearY(
                        ),
                    scrnTrans.
                      getShearX(
                        ),
                    scrnTrans.
                      getScaleY(
                        ),
                    newX,
                    scrnTrans.
                      getTranslateY(
                        ));
                context.
                  setScreenTransform(
                    scrnTrans);
            }
            public void setY(float newY) {
                org.apache.batik.dom.svg.SVGContext context =
                  getSVGContext(
                    );
                java.awt.geom.AffineTransform scrnTrans =
                  context.
                  getScreenTransform(
                    );
                scrnTrans =
                  new java.awt.geom.AffineTransform(
                    scrnTrans.
                      getScaleX(
                        ),
                    scrnTrans.
                      getShearY(
                        ),
                    scrnTrans.
                      getShearX(
                        ),
                    scrnTrans.
                      getScaleY(
                        ),
                    scrnTrans.
                      getTranslateX(
                        ),
                    newY);
                context.
                  setScreenTransform(
                    scrnTrans);
            }
            public org.w3c.dom.svg.SVGPoint matrixTransform(org.w3c.dom.svg.SVGMatrix mat) {
                java.awt.geom.AffineTransform scrnTrans =
                  getScreenTransform(
                    );
                float x =
                  (float)
                    scrnTrans.
                    getTranslateX(
                      );
                float y =
                  (float)
                    scrnTrans.
                    getTranslateY(
                      );
                float newX =
                  mat.
                  getA(
                    ) *
                  x +
                  mat.
                  getC(
                    ) *
                  y +
                  mat.
                  getE(
                    );
                float newY =
                  mat.
                  getB(
                    ) *
                  x +
                  mat.
                  getD(
                    ) *
                  y +
                  mat.
                  getF(
                    );
                return new org.apache.batik.dom.svg.SVGOMPoint(
                  newX,
                  newY);
            }
        };
    }
    public int suspendRedraw(int max_wait_milliseconds) {
        if (max_wait_milliseconds >
              60000) {
            max_wait_milliseconds =
              60000;
        }
        else
            if (max_wait_milliseconds <
                  0) {
                max_wait_milliseconds =
                  0;
            }
        org.apache.batik.dom.svg.SVGSVGContext ctx =
          (org.apache.batik.dom.svg.SVGSVGContext)
            getSVGContext(
              );
        return ctx.
          suspendRedraw(
            max_wait_milliseconds);
    }
    public void unsuspendRedraw(int suspend_handle_id)
          throws org.w3c.dom.DOMException {
        org.apache.batik.dom.svg.SVGSVGContext ctx =
          (org.apache.batik.dom.svg.SVGSVGContext)
            getSVGContext(
              );
        if (!ctx.
              unsuspendRedraw(
                suspend_handle_id)) {
            throw createDOMException(
                    org.w3c.dom.DOMException.
                      NOT_FOUND_ERR,
                    "invalid.suspend.handle",
                    new java.lang.Object[] { new java.lang.Integer(
                      suspend_handle_id) });
        }
    }
    public void unsuspendRedrawAll() { org.apache.batik.dom.svg.SVGSVGContext ctx =
                                         (org.apache.batik.dom.svg.SVGSVGContext)
                                           getSVGContext(
                                             );
                                       ctx.
                                         unsuspendRedrawAll(
                                           );
    }
    public void forceRedraw() { org.apache.batik.dom.svg.SVGSVGContext ctx =
                                  (org.apache.batik.dom.svg.SVGSVGContext)
                                    getSVGContext(
                                      );
                                ctx.forceRedraw(
                                      ); }
    public void pauseAnimations() { org.apache.batik.dom.svg.SVGSVGContext ctx =
                                      (org.apache.batik.dom.svg.SVGSVGContext)
                                        getSVGContext(
                                          );
                                    ctx.pauseAnimations(
                                          );
    }
    public void unpauseAnimations() { org.apache.batik.dom.svg.SVGSVGContext ctx =
                                        (org.apache.batik.dom.svg.SVGSVGContext)
                                          getSVGContext(
                                            );
                                      ctx.
                                        unpauseAnimations(
                                          );
    }
    public boolean animationsPaused() { org.apache.batik.dom.svg.SVGSVGContext ctx =
                                          (org.apache.batik.dom.svg.SVGSVGContext)
                                            getSVGContext(
                                              );
                                        return ctx.
                                          animationsPaused(
                                            );
    }
    public float getCurrentTime() { org.apache.batik.dom.svg.SVGSVGContext ctx =
                                      (org.apache.batik.dom.svg.SVGSVGContext)
                                        getSVGContext(
                                          );
                                    return ctx.
                                      getCurrentTime(
                                        );
    }
    public void setCurrentTime(float seconds) {
        org.apache.batik.dom.svg.SVGSVGContext ctx =
          (org.apache.batik.dom.svg.SVGSVGContext)
            getSVGContext(
              );
        ctx.
          setCurrentTime(
            seconds);
    }
    public org.w3c.dom.NodeList getIntersectionList(org.w3c.dom.svg.SVGRect rect,
                                                    org.w3c.dom.svg.SVGElement referenceElement) {
        org.apache.batik.dom.svg.SVGSVGContext ctx =
          (org.apache.batik.dom.svg.SVGSVGContext)
            getSVGContext(
              );
        java.util.List list =
          ctx.
          getIntersectionList(
            rect,
            referenceElement);
        return new org.apache.batik.dom.util.ListNodeList(
          list);
    }
    public org.w3c.dom.NodeList getEnclosureList(org.w3c.dom.svg.SVGRect rect,
                                                 org.w3c.dom.svg.SVGElement referenceElement) {
        org.apache.batik.dom.svg.SVGSVGContext ctx =
          (org.apache.batik.dom.svg.SVGSVGContext)
            getSVGContext(
              );
        java.util.List list =
          ctx.
          getEnclosureList(
            rect,
            referenceElement);
        return new org.apache.batik.dom.util.ListNodeList(
          list);
    }
    public boolean checkIntersection(org.w3c.dom.svg.SVGElement element,
                                     org.w3c.dom.svg.SVGRect rect) {
        org.apache.batik.dom.svg.SVGSVGContext ctx =
          (org.apache.batik.dom.svg.SVGSVGContext)
            getSVGContext(
              );
        return ctx.
          checkIntersection(
            element,
            rect);
    }
    public boolean checkEnclosure(org.w3c.dom.svg.SVGElement element,
                                  org.w3c.dom.svg.SVGRect rect) {
        org.apache.batik.dom.svg.SVGSVGContext ctx =
          (org.apache.batik.dom.svg.SVGSVGContext)
            getSVGContext(
              );
        return ctx.
          checkEnclosure(
            element,
            rect);
    }
    public void deselectAll() { ((org.apache.batik.dom.svg.SVGSVGContext)
                                   getSVGContext(
                                     )).deselectAll(
                                          );
    }
    public org.w3c.dom.svg.SVGNumber createSVGNumber() {
        return new org.w3c.dom.svg.SVGNumber(
          ) {
            protected float
              value;
            public float getValue() {
                return value;
            }
            public void setValue(float f) {
                value =
                  f;
            }
        };
    }
    public org.w3c.dom.svg.SVGLength createSVGLength() {
        return new org.apache.batik.dom.svg.SVGOMLength(
          this);
    }
    public org.w3c.dom.svg.SVGAngle createSVGAngle() {
        return new org.apache.batik.dom.svg.SVGOMAngle(
          );
    }
    public org.w3c.dom.svg.SVGPoint createSVGPoint() {
        return new org.apache.batik.dom.svg.SVGOMPoint(
          0,
          0);
    }
    public org.w3c.dom.svg.SVGMatrix createSVGMatrix() {
        return new org.apache.batik.dom.svg.AbstractSVGMatrix(
          ) {
            protected java.awt.geom.AffineTransform
              at =
              new java.awt.geom.AffineTransform(
              );
            protected java.awt.geom.AffineTransform getAffineTransform() {
                return at;
            }
        };
    }
    public org.w3c.dom.svg.SVGRect createSVGRect() {
        return new org.apache.batik.dom.svg.SVGOMRect(
          0,
          0,
          0,
          0);
    }
    public org.w3c.dom.svg.SVGTransform createSVGTransform() {
        org.apache.batik.dom.svg.SVGOMTransform ret =
          new org.apache.batik.dom.svg.SVGOMTransform(
          );
        ret.
          setType(
            org.w3c.dom.svg.SVGTransform.
              SVG_TRANSFORM_MATRIX);
        return ret;
    }
    public org.w3c.dom.svg.SVGTransform createSVGTransformFromMatrix(org.w3c.dom.svg.SVGMatrix matrix) {
        org.apache.batik.dom.svg.SVGOMTransform tr =
          new org.apache.batik.dom.svg.SVGOMTransform(
          );
        tr.
          setMatrix(
            matrix);
        return tr;
    }
    public org.w3c.dom.Element getElementById(java.lang.String elementId) {
        return ownerDocument.
          getChildElementById(
            this,
            elementId);
    }
    public org.w3c.dom.svg.SVGElement getNearestViewportElement() {
        return org.apache.batik.dom.svg.SVGLocatableSupport.
          getNearestViewportElement(
            this);
    }
    public org.w3c.dom.svg.SVGElement getFarthestViewportElement() {
        return org.apache.batik.dom.svg.SVGLocatableSupport.
          getFarthestViewportElement(
            this);
    }
    public org.w3c.dom.svg.SVGRect getBBox() {
        return org.apache.batik.dom.svg.SVGLocatableSupport.
          getBBox(
            this);
    }
    public org.w3c.dom.svg.SVGMatrix getCTM() {
        return org.apache.batik.dom.svg.SVGLocatableSupport.
          getCTM(
            this);
    }
    public org.w3c.dom.svg.SVGMatrix getScreenCTM() {
        return org.apache.batik.dom.svg.SVGLocatableSupport.
          getScreenCTM(
            this);
    }
    public org.w3c.dom.svg.SVGMatrix getTransformToElement(org.w3c.dom.svg.SVGElement element)
          throws org.w3c.dom.svg.SVGException {
        return org.apache.batik.dom.svg.SVGLocatableSupport.
          getTransformToElement(
            this,
            element);
    }
    public org.w3c.dom.views.DocumentView getDocument() {
        return (org.w3c.dom.views.DocumentView)
                 getOwnerDocument(
                   );
    }
    public org.w3c.dom.css.CSSStyleDeclaration getComputedStyle(org.w3c.dom.Element elt,
                                                                java.lang.String pseudoElt) {
        org.w3c.dom.views.AbstractView av =
          ((org.w3c.dom.views.DocumentView)
             getOwnerDocument(
               )).
          getDefaultView(
            );
        return ((org.w3c.dom.css.ViewCSS)
                  av).
          getComputedStyle(
            elt,
            pseudoElt);
    }
    public org.w3c.dom.events.Event createEvent(java.lang.String eventType)
          throws org.w3c.dom.DOMException {
        return ((org.w3c.dom.events.DocumentEvent)
                  getOwnerDocument(
                    )).
          createEvent(
            eventType);
    }
    public boolean canDispatch(java.lang.String namespaceURI,
                               java.lang.String type)
          throws org.w3c.dom.DOMException {
        org.apache.batik.dom.AbstractDocument doc =
          (org.apache.batik.dom.AbstractDocument)
            getOwnerDocument(
              );
        return doc.
          canDispatch(
            namespaceURI,
            type);
    }
    public org.w3c.dom.stylesheets.StyleSheetList getStyleSheets() {
        return ((org.w3c.dom.stylesheets.DocumentStyle)
                  getOwnerDocument(
                    )).
          getStyleSheets(
            );
    }
    public org.w3c.dom.css.CSSStyleDeclaration getOverrideStyle(org.w3c.dom.Element elt,
                                                                java.lang.String pseudoElt) {
        return ((org.w3c.dom.css.DocumentCSS)
                  getOwnerDocument(
                    )).
          getOverrideStyle(
            elt,
            pseudoElt);
    }
    public java.lang.String getXMLlang() {
        return org.apache.batik.dom.util.XMLSupport.
          getXMLLang(
            this);
    }
    public void setXMLlang(java.lang.String lang) {
        setAttributeNS(
          XML_NAMESPACE_URI,
          XML_LANG_QNAME,
          lang);
    }
    public java.lang.String getXMLspace() {
        return org.apache.batik.dom.util.XMLSupport.
          getXMLSpace(
            this);
    }
    public void setXMLspace(java.lang.String space) {
        setAttributeNS(
          XML_NAMESPACE_URI,
          XML_SPACE_QNAME,
          space);
    }
    public short getZoomAndPan() { return org.apache.batik.dom.svg.SVGZoomAndPanSupport.
                                     getZoomAndPan(
                                       this);
    }
    public void setZoomAndPan(short val) {
        org.apache.batik.dom.svg.SVGZoomAndPanSupport.
          setZoomAndPan(
            this,
            val);
    }
    public org.w3c.dom.svg.SVGAnimatedRect getViewBox() {
        return viewBox;
    }
    public org.w3c.dom.svg.SVGAnimatedPreserveAspectRatio getPreserveAspectRatio() {
        return preserveAspectRatio;
    }
    public org.w3c.dom.svg.SVGAnimatedBoolean getExternalResourcesRequired() {
        return externalResourcesRequired;
    }
    public org.w3c.dom.svg.SVGStringList getRequiredFeatures() {
        return org.apache.batik.dom.svg.SVGTestsSupport.
          getRequiredFeatures(
            this);
    }
    public org.w3c.dom.svg.SVGStringList getRequiredExtensions() {
        return org.apache.batik.dom.svg.SVGTestsSupport.
          getRequiredExtensions(
            this);
    }
    public org.w3c.dom.svg.SVGStringList getSystemLanguage() {
        return org.apache.batik.dom.svg.SVGTestsSupport.
          getSystemLanguage(
            this);
    }
    public boolean hasExtension(java.lang.String extension) {
        return org.apache.batik.dom.svg.SVGTestsSupport.
          hasExtension(
            this,
            extension);
    }
    protected org.apache.batik.dom.svg.AttributeInitializer getAttributeInitializer() {
        return attributeInitializer;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMSVGElement(
          );
    }
    protected org.apache.batik.util.DoublyIndexedTable getTraitInformationTable() {
        return xmlTraitInformation;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "aqnJ60tGWljKckYNZKGolEqNirPYiCOD");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "aV6kPDq6KuWjoMK/sKP8hcNTPrAn7xVZck+Qv6dIUm7WiEf3XhUPTCCv/coO" +
       "71cOj/fYnrwnsuTVQE9dIfSVbZz15E7MOcRHror4elDbT+4QP3l4xGf25L05" +
       "S54GblRo74d8w1W96Qzy0zvITx8esr4nD8mSclC4XzilozJYObMyHz5jrFzV" +
       "U3ocVPf3d4y/f3hGdE9eO0vedsFVZDTrkqN09MVXVdW3gMp+dkf42cMQXnaU" +
       "jsZ7MKksGQBM/zLmeWXFD+EifW6H+bnDYO5eC5VhvvPE1XnkJq7Oyf3njIPf" +
       "I4kvzRJ260oNsvdh+tsXjGWvEjs5/yvOn3/syMppZi6m2VXFBAbYo7u2x27/" +
       "P6yYsjq+PYfV9wgiG1CPFNC7gSA6tmQ6fujloNn+d53RqgeIBxw9tKN96NC0" +
       "R3nk8p050Z4g11GerIHBllaKZJxv+EvG7CrBrRwXDLxHj+1wH/t84u4Jcx1l" +
       "Ya6jd4P+nuOeNu8l1qtEtk58qKM37FjfcBjW8xR7IltHWWTr6GuBDyUrvpK9" +
       "JPD5LuJVIlkPnWjuW3Z4bzk83p5I1lEWyTr6APChJE8Bkzxg4LbvXjkxUa++" +
       "iQk8VyLnv0o065T/rTv+tx6e/3v35H1/lvyD8/zn7tPfgv/Snfyjj1zVTr8O" +
       "cO+WRh1dXhp1AP5/uifvx7Pkh7MOfMLfspfm3sn+WYGc/kcOQb97/97R896/" +
       "d3X6f7Mn76ez5F+dp88jGZn5+m9nhB8/hH5PdoSTwxP+4p68/5glnziv3yMh" +
       "8LTTN1LdTL/Plcj5f/6qQ9UTgPudO/53Hp7/k3vyfiNLfi0o3HPKv3u51s7L" +
       "ywGvss7q4WznMwBM3gHKhwf8X3vyfjdL/ntQeOAUMI/YZa+RPGnj196kjS8W" +
       "yqXw6atKAQb09k4K9mGkcDb5OPrlHPdP94jiz7LkjwDv80XR9Rxrq9ZZmd8/" +
       "g/4/h3DD4h10fGjo7cKB4+u3hj6+PaP43HZiuZuboMng9K2AD55v+13+Kf1x" +
       "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" +
       "W7/nw5/MP0X1/wGQ02j0s34AAA==");
}
