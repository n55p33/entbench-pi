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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "iUhQS01eXzLSwlKWM2ogC0WlVGpUnMVG");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "+r63ftuHP5l/iur/A3scoKezfgAA");
}
