package org.apache.batik.dom.svg;
public abstract class SVGOMElement extends org.apache.batik.dom.svg.AbstractElement implements org.w3c.dom.svg.SVGElement, org.apache.batik.dom.svg.ExtendedTraitAccess, org.apache.batik.dom.anim.AnimationTarget {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               );
             t.put(null, SVG_ID_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     false,
                     org.apache.batik.util.SVGTypes.
                       TYPE_CDATA));
             t.put(XML_NAMESPACE_URI, XML_BASE_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     false,
                     org.apache.batik.util.SVGTypes.
                       TYPE_URI));
             t.put(XML_NAMESPACE_URI, XML_SPACE_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     false,
                     org.apache.batik.util.SVGTypes.
                       TYPE_IDENT));
             t.put(XML_NAMESPACE_URI, XML_ID_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     false,
                     org.apache.batik.util.SVGTypes.
                       TYPE_CDATA));
             t.put(XML_NAMESPACE_URI, XML_LANG_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     false,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LANG));
             xmlTraitInformation = t; }
    protected transient boolean readonly;
    protected java.lang.String prefix;
    protected transient org.apache.batik.dom.svg.SVGContext
      svgContext;
    protected org.apache.batik.util.DoublyIndexedTable
      targetListeners;
    protected org.apache.batik.parser.UnitProcessor.Context
      unitContext;
    protected SVGOMElement() { super(); }
    protected SVGOMElement(java.lang.String prefix,
                           org.apache.batik.dom.AbstractDocument owner) {
        super(
          prefix,
          owner);
    }
    protected void initializeAllLiveAttributes() {
        
    }
    public java.lang.String getId() { if (((org.apache.batik.dom.svg.SVGOMDocument)
                                             ownerDocument).
                                            isSVG12) {
                                          org.w3c.dom.Attr a =
                                            getAttributeNodeNS(
                                              XML_NAMESPACE_URI,
                                              SVG_ID_ATTRIBUTE);
                                          if (a !=
                                                null) {
                                              return a.
                                                getNodeValue(
                                                  );
                                          }
                                      }
                                      return getAttributeNS(
                                               null,
                                               SVG_ID_ATTRIBUTE);
    }
    public void setId(java.lang.String id) {
        if (((org.apache.batik.dom.svg.SVGOMDocument)
               ownerDocument).
              isSVG12) {
            setAttributeNS(
              XML_NAMESPACE_URI,
              SVG_ID_ATTRIBUTE,
              id);
            org.w3c.dom.Attr a =
              getAttributeNodeNS(
                null,
                SVG_ID_ATTRIBUTE);
            if (a !=
                  null) {
                a.
                  setNodeValue(
                    id);
            }
        }
        else {
            setAttributeNS(
              null,
              SVG_ID_ATTRIBUTE,
              id);
        }
    }
    public java.lang.String getXMLbase() {
        return getAttributeNS(
                 XML_NAMESPACE_URI,
                 XML_BASE_ATTRIBUTE);
    }
    public void setXMLbase(java.lang.String xmlbase)
          throws org.w3c.dom.DOMException {
        setAttributeNS(
          XML_NAMESPACE_URI,
          XML_BASE_QNAME,
          xmlbase);
    }
    public org.w3c.dom.svg.SVGSVGElement getOwnerSVGElement() {
        for (org.w3c.dom.Element e =
               org.apache.batik.css.engine.CSSEngine.
               getParentCSSStylableElement(
                 this);
             e !=
               null;
             e =
               org.apache.batik.css.engine.CSSEngine.
                 getParentCSSStylableElement(
                   e)) {
            if (e instanceof org.w3c.dom.svg.SVGSVGElement) {
                return (org.w3c.dom.svg.SVGSVGElement)
                         e;
            }
        }
        return null;
    }
    public org.w3c.dom.svg.SVGElement getViewportElement() {
        for (org.w3c.dom.Element e =
               org.apache.batik.css.engine.CSSEngine.
               getParentCSSStylableElement(
                 this);
             e !=
               null;
             e =
               org.apache.batik.css.engine.CSSEngine.
                 getParentCSSStylableElement(
                   e)) {
            if (e instanceof org.w3c.dom.svg.SVGFitToViewBox) {
                return (org.w3c.dom.svg.SVGElement)
                         e;
            }
        }
        return null;
    }
    public java.lang.String getNodeName() {
        if (prefix ==
              null ||
              prefix.
              equals(
                "")) {
            return getLocalName(
                     );
        }
        return prefix +
        ':' +
        getLocalName(
          );
    }
    public java.lang.String getNamespaceURI() {
        return org.apache.batik.dom.svg.SVGDOMImplementation.
                 SVG_NAMESPACE_URI;
    }
    public void setPrefix(java.lang.String prefix)
          throws org.w3c.dom.DOMException {
        if (isReadonly(
              )) {
            throw createDOMException(
                    org.w3c.dom.DOMException.
                      NO_MODIFICATION_ALLOWED_ERR,
                    "readonly.node",
                    new java.lang.Object[] { new java.lang.Integer(
                      getNodeType(
                        )),
                    getNodeName(
                      ) });
        }
        if (prefix !=
              null &&
              !prefix.
              equals(
                "") &&
              !org.apache.batik.dom.util.DOMUtilities.
              isValidName(
                prefix)) {
            throw createDOMException(
                    org.w3c.dom.DOMException.
                      INVALID_CHARACTER_ERR,
                    "prefix",
                    new java.lang.Object[] { new java.lang.Integer(
                      getNodeType(
                        )),
                    getNodeName(
                      ),
                    prefix });
        }
        this.
          prefix =
          prefix;
    }
    protected java.lang.String getCascadedXMLBase(org.w3c.dom.Node node) {
        java.lang.String base =
          null;
        org.w3c.dom.Node n =
          node.
          getParentNode(
            );
        while (n !=
                 null) {
            if (n.
                  getNodeType(
                    ) ==
                  org.w3c.dom.Node.
                    ELEMENT_NODE) {
                base =
                  getCascadedXMLBase(
                    n);
                break;
            }
            if (n instanceof org.apache.batik.css.engine.CSSNavigableNode) {
                n =
                  ((org.apache.batik.css.engine.CSSNavigableNode)
                     n).
                    getCSSParentNode(
                      );
            }
            else {
                n =
                  n.
                    getParentNode(
                      );
            }
        }
        if (base ==
              null) {
            org.apache.batik.dom.AbstractDocument doc;
            if (node.
                  getNodeType(
                    ) ==
                  org.w3c.dom.Node.
                    DOCUMENT_NODE) {
                doc =
                  (org.apache.batik.dom.AbstractDocument)
                    node;
            }
            else {
                doc =
                  (org.apache.batik.dom.AbstractDocument)
                    node.
                    getOwnerDocument(
                      );
            }
            base =
              doc.
                getDocumentURI(
                  );
        }
        while (node !=
                 null &&
                 node.
                 getNodeType(
                   ) !=
                 org.w3c.dom.Node.
                   ELEMENT_NODE) {
            node =
              node.
                getParentNode(
                  );
        }
        if (node ==
              null) {
            return base;
        }
        org.w3c.dom.Element e =
          (org.w3c.dom.Element)
            node;
        org.w3c.dom.Attr attr =
          e.
          getAttributeNodeNS(
            XML_NAMESPACE_URI,
            XML_BASE_ATTRIBUTE);
        if (attr !=
              null) {
            if (base ==
                  null) {
                base =
                  attr.
                    getNodeValue(
                      );
            }
            else {
                base =
                  new org.apache.batik.util.ParsedURL(
                    base,
                    attr.
                      getNodeValue(
                        )).
                    toString(
                      );
            }
        }
        return base;
    }
    public void setSVGContext(org.apache.batik.dom.svg.SVGContext ctx) {
        svgContext =
          ctx;
    }
    public org.apache.batik.dom.svg.SVGContext getSVGContext() {
        return svgContext;
    }
    public org.w3c.dom.svg.SVGException createSVGException(short type,
                                                           java.lang.String key,
                                                           java.lang.Object[] args) {
        try {
            return new org.apache.batik.dom.svg.SVGOMException(
              type,
              getCurrentDocument(
                ).
                formatMessage(
                  key,
                  args));
        }
        catch (java.lang.Exception e) {
            return new org.apache.batik.dom.svg.SVGOMException(
              type,
              key);
        }
    }
    public boolean isReadonly() { return readonly;
    }
    public void setReadonly(boolean v) { readonly =
                                           v;
    }
    protected org.apache.batik.util.DoublyIndexedTable getTraitInformationTable() {
        return xmlTraitInformation;
    }
    protected org.apache.batik.dom.svg.SVGOMAnimatedTransformList createLiveAnimatedTransformList(java.lang.String ns,
                                                                                                  java.lang.String ln,
                                                                                                  java.lang.String def) {
        org.apache.batik.dom.svg.SVGOMAnimatedTransformList v =
          new org.apache.batik.dom.svg.SVGOMAnimatedTransformList(
          this,
          ns,
          ln,
          def);
        liveAttributeValues.
          put(
            ns,
            ln,
            v);
        v.
          addAnimatedAttributeListener(
            ((org.apache.batik.dom.svg.SVGOMDocument)
               ownerDocument).
              getAnimatedAttributeListener(
                ));
        return v;
    }
    protected org.apache.batik.dom.svg.SVGOMAnimatedBoolean createLiveAnimatedBoolean(java.lang.String ns,
                                                                                      java.lang.String ln,
                                                                                      boolean def) {
        org.apache.batik.dom.svg.SVGOMAnimatedBoolean v =
          new org.apache.batik.dom.svg.SVGOMAnimatedBoolean(
          this,
          ns,
          ln,
          def);
        liveAttributeValues.
          put(
            ns,
            ln,
            v);
        v.
          addAnimatedAttributeListener(
            ((org.apache.batik.dom.svg.SVGOMDocument)
               ownerDocument).
              getAnimatedAttributeListener(
                ));
        return v;
    }
    protected org.apache.batik.dom.svg.SVGOMAnimatedString createLiveAnimatedString(java.lang.String ns,
                                                                                    java.lang.String ln) {
        org.apache.batik.dom.svg.SVGOMAnimatedString v =
          new org.apache.batik.dom.svg.SVGOMAnimatedString(
          this,
          ns,
          ln);
        liveAttributeValues.
          put(
            ns,
            ln,
            v);
        v.
          addAnimatedAttributeListener(
            ((org.apache.batik.dom.svg.SVGOMDocument)
               ownerDocument).
              getAnimatedAttributeListener(
                ));
        return v;
    }
    protected org.apache.batik.dom.svg.SVGOMAnimatedPreserveAspectRatio createLiveAnimatedPreserveAspectRatio() {
        org.apache.batik.dom.svg.SVGOMAnimatedPreserveAspectRatio v =
          new org.apache.batik.dom.svg.SVGOMAnimatedPreserveAspectRatio(
          this);
        liveAttributeValues.
          put(
            null,
            SVG_PRESERVE_ASPECT_RATIO_ATTRIBUTE,
            v);
        v.
          addAnimatedAttributeListener(
            ((org.apache.batik.dom.svg.SVGOMDocument)
               ownerDocument).
              getAnimatedAttributeListener(
                ));
        return v;
    }
    protected org.apache.batik.dom.svg.SVGOMAnimatedMarkerOrientValue createLiveAnimatedMarkerOrientValue(java.lang.String ns,
                                                                                                          java.lang.String ln) {
        org.apache.batik.dom.svg.SVGOMAnimatedMarkerOrientValue v =
          new org.apache.batik.dom.svg.SVGOMAnimatedMarkerOrientValue(
          this,
          ns,
          ln);
        liveAttributeValues.
          put(
            ns,
            ln,
            v);
        v.
          addAnimatedAttributeListener(
            ((org.apache.batik.dom.svg.SVGOMDocument)
               ownerDocument).
              getAnimatedAttributeListener(
                ));
        return v;
    }
    protected org.apache.batik.dom.svg.SVGOMAnimatedPathData createLiveAnimatedPathData(java.lang.String ns,
                                                                                        java.lang.String ln,
                                                                                        java.lang.String def) {
        org.apache.batik.dom.svg.SVGOMAnimatedPathData v =
          new org.apache.batik.dom.svg.SVGOMAnimatedPathData(
          this,
          ns,
          ln,
          def);
        liveAttributeValues.
          put(
            ns,
            ln,
            v);
        v.
          addAnimatedAttributeListener(
            ((org.apache.batik.dom.svg.SVGOMDocument)
               ownerDocument).
              getAnimatedAttributeListener(
                ));
        return v;
    }
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber createLiveAnimatedNumber(java.lang.String ns,
                                                                                    java.lang.String ln,
                                                                                    float def) {
        return createLiveAnimatedNumber(
                 ns,
                 ln,
                 def,
                 false);
    }
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber createLiveAnimatedNumber(java.lang.String ns,
                                                                                    java.lang.String ln,
                                                                                    float def,
                                                                                    boolean allowPercentage) {
        org.apache.batik.dom.svg.SVGOMAnimatedNumber v =
          new org.apache.batik.dom.svg.SVGOMAnimatedNumber(
          this,
          ns,
          ln,
          def,
          allowPercentage);
        liveAttributeValues.
          put(
            ns,
            ln,
            v);
        v.
          addAnimatedAttributeListener(
            ((org.apache.batik.dom.svg.SVGOMDocument)
               ownerDocument).
              getAnimatedAttributeListener(
                ));
        return v;
    }
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumberList createLiveAnimatedNumberList(java.lang.String ns,
                                                                                            java.lang.String ln,
                                                                                            java.lang.String def,
                                                                                            boolean canEmpty) {
        org.apache.batik.dom.svg.SVGOMAnimatedNumberList v =
          new org.apache.batik.dom.svg.SVGOMAnimatedNumberList(
          this,
          ns,
          ln,
          def,
          canEmpty);
        liveAttributeValues.
          put(
            ns,
            ln,
            v);
        v.
          addAnimatedAttributeListener(
            ((org.apache.batik.dom.svg.SVGOMDocument)
               ownerDocument).
              getAnimatedAttributeListener(
                ));
        return v;
    }
    protected org.apache.batik.dom.svg.SVGOMAnimatedPoints createLiveAnimatedPoints(java.lang.String ns,
                                                                                    java.lang.String ln,
                                                                                    java.lang.String def) {
        org.apache.batik.dom.svg.SVGOMAnimatedPoints v =
          new org.apache.batik.dom.svg.SVGOMAnimatedPoints(
          this,
          ns,
          ln,
          def);
        liveAttributeValues.
          put(
            ns,
            ln,
            v);
        v.
          addAnimatedAttributeListener(
            ((org.apache.batik.dom.svg.SVGOMDocument)
               ownerDocument).
              getAnimatedAttributeListener(
                ));
        return v;
    }
    protected org.apache.batik.dom.svg.SVGOMAnimatedLengthList createLiveAnimatedLengthList(java.lang.String ns,
                                                                                            java.lang.String ln,
                                                                                            java.lang.String def,
                                                                                            boolean emptyAllowed,
                                                                                            short dir) {
        org.apache.batik.dom.svg.SVGOMAnimatedLengthList v =
          new org.apache.batik.dom.svg.SVGOMAnimatedLengthList(
          this,
          ns,
          ln,
          def,
          emptyAllowed,
          dir);
        liveAttributeValues.
          put(
            ns,
            ln,
            v);
        v.
          addAnimatedAttributeListener(
            ((org.apache.batik.dom.svg.SVGOMDocument)
               ownerDocument).
              getAnimatedAttributeListener(
                ));
        return v;
    }
    protected org.apache.batik.dom.svg.SVGOMAnimatedInteger createLiveAnimatedInteger(java.lang.String ns,
                                                                                      java.lang.String ln,
                                                                                      int def) {
        org.apache.batik.dom.svg.SVGOMAnimatedInteger v =
          new org.apache.batik.dom.svg.SVGOMAnimatedInteger(
          this,
          ns,
          ln,
          def);
        liveAttributeValues.
          put(
            ns,
            ln,
            v);
        v.
          addAnimatedAttributeListener(
            ((org.apache.batik.dom.svg.SVGOMDocument)
               ownerDocument).
              getAnimatedAttributeListener(
                ));
        return v;
    }
    protected org.apache.batik.dom.svg.SVGOMAnimatedEnumeration createLiveAnimatedEnumeration(java.lang.String ns,
                                                                                              java.lang.String ln,
                                                                                              java.lang.String[] val,
                                                                                              short def) {
        org.apache.batik.dom.svg.SVGOMAnimatedEnumeration v =
          new org.apache.batik.dom.svg.SVGOMAnimatedEnumeration(
          this,
          ns,
          ln,
          val,
          def);
        liveAttributeValues.
          put(
            ns,
            ln,
            v);
        v.
          addAnimatedAttributeListener(
            ((org.apache.batik.dom.svg.SVGOMDocument)
               ownerDocument).
              getAnimatedAttributeListener(
                ));
        return v;
    }
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength createLiveAnimatedLength(java.lang.String ns,
                                                                                    java.lang.String ln,
                                                                                    java.lang.String val,
                                                                                    short dir,
                                                                                    boolean nonneg) {
        org.apache.batik.dom.svg.SVGOMAnimatedLength v =
          new org.apache.batik.dom.svg.SVGOMAnimatedLength(
          this,
          ns,
          ln,
          val,
          dir,
          nonneg);
        liveAttributeValues.
          put(
            ns,
            ln,
            v);
        v.
          addAnimatedAttributeListener(
            ((org.apache.batik.dom.svg.SVGOMDocument)
               ownerDocument).
              getAnimatedAttributeListener(
                ));
        return v;
    }
    protected org.apache.batik.dom.svg.SVGOMAnimatedRect createLiveAnimatedRect(java.lang.String ns,
                                                                                java.lang.String ln,
                                                                                java.lang.String value) {
        org.apache.batik.dom.svg.SVGOMAnimatedRect v =
          new org.apache.batik.dom.svg.SVGOMAnimatedRect(
          this,
          ns,
          ln,
          value);
        liveAttributeValues.
          put(
            ns,
            ln,
            v);
        v.
          addAnimatedAttributeListener(
            ((org.apache.batik.dom.svg.SVGOMDocument)
               ownerDocument).
              getAnimatedAttributeListener(
                ));
        return v;
    }
    public boolean hasProperty(java.lang.String pn) {
        org.apache.batik.dom.AbstractStylableDocument doc =
          (org.apache.batik.dom.AbstractStylableDocument)
            ownerDocument;
        org.apache.batik.css.engine.CSSEngine eng =
          doc.
          getCSSEngine(
            );
        return eng.
          getPropertyIndex(
            pn) !=
          -1 ||
          eng.
          getShorthandIndex(
            pn) !=
          -1;
    }
    public boolean hasTrait(java.lang.String ns,
                            java.lang.String ln) {
        return false;
    }
    public boolean isPropertyAnimatable(java.lang.String pn) {
        org.apache.batik.dom.AbstractStylableDocument doc =
          (org.apache.batik.dom.AbstractStylableDocument)
            ownerDocument;
        org.apache.batik.css.engine.CSSEngine eng =
          doc.
          getCSSEngine(
            );
        int idx =
          eng.
          getPropertyIndex(
            pn);
        if (idx !=
              -1) {
            org.apache.batik.css.engine.value.ValueManager[] vms =
              eng.
              getValueManagers(
                );
            return vms[idx].
              isAnimatableProperty(
                );
        }
        idx =
          eng.
            getShorthandIndex(
              pn);
        if (idx !=
              -1) {
            org.apache.batik.css.engine.value.ShorthandManager[] sms =
              eng.
              getShorthandManagers(
                );
            return sms[idx].
              isAnimatableProperty(
                );
        }
        return false;
    }
    public final boolean isAttributeAnimatable(java.lang.String ns,
                                               java.lang.String ln) {
        org.apache.batik.util.DoublyIndexedTable t =
          getTraitInformationTable(
            );
        org.apache.batik.dom.svg.TraitInformation ti =
          (org.apache.batik.dom.svg.TraitInformation)
            t.
            get(
              ns,
              ln);
        if (ti !=
              null) {
            return ti.
              isAnimatable(
                );
        }
        return false;
    }
    public boolean isPropertyAdditive(java.lang.String pn) {
        org.apache.batik.dom.AbstractStylableDocument doc =
          (org.apache.batik.dom.AbstractStylableDocument)
            ownerDocument;
        org.apache.batik.css.engine.CSSEngine eng =
          doc.
          getCSSEngine(
            );
        int idx =
          eng.
          getPropertyIndex(
            pn);
        if (idx !=
              -1) {
            org.apache.batik.css.engine.value.ValueManager[] vms =
              eng.
              getValueManagers(
                );
            return vms[idx].
              isAdditiveProperty(
                );
        }
        idx =
          eng.
            getShorthandIndex(
              pn);
        if (idx !=
              -1) {
            org.apache.batik.css.engine.value.ShorthandManager[] sms =
              eng.
              getShorthandManagers(
                );
            return sms[idx].
              isAdditiveProperty(
                );
        }
        return false;
    }
    public boolean isAttributeAdditive(java.lang.String ns,
                                       java.lang.String ln) {
        return true;
    }
    public boolean isTraitAnimatable(java.lang.String ns,
                                     java.lang.String tn) {
        return false;
    }
    public boolean isTraitAdditive(java.lang.String ns,
                                   java.lang.String tn) {
        return false;
    }
    public int getPropertyType(java.lang.String pn) {
        org.apache.batik.dom.AbstractStylableDocument doc =
          (org.apache.batik.dom.AbstractStylableDocument)
            ownerDocument;
        org.apache.batik.css.engine.CSSEngine eng =
          doc.
          getCSSEngine(
            );
        int idx =
          eng.
          getPropertyIndex(
            pn);
        if (idx !=
              -1) {
            org.apache.batik.css.engine.value.ValueManager[] vms =
              eng.
              getValueManagers(
                );
            return vms[idx].
              getPropertyType(
                );
        }
        return org.apache.batik.util.SVGTypes.
                 TYPE_UNKNOWN;
    }
    public final int getAttributeType(java.lang.String ns,
                                      java.lang.String ln) {
        org.apache.batik.util.DoublyIndexedTable t =
          getTraitInformationTable(
            );
        org.apache.batik.dom.svg.TraitInformation ti =
          (org.apache.batik.dom.svg.TraitInformation)
            t.
            get(
              ns,
              ln);
        if (ti !=
              null) {
            return ti.
              getType(
                );
        }
        return org.apache.batik.util.SVGTypes.
                 TYPE_UNKNOWN;
    }
    public org.w3c.dom.Element getElement() {
        return this;
    }
    public void updatePropertyValue(java.lang.String pn,
                                    org.apache.batik.anim.values.AnimatableValue val) {
        
    }
    public void updateAttributeValue(java.lang.String ns,
                                     java.lang.String ln,
                                     org.apache.batik.anim.values.AnimatableValue val) {
        org.apache.batik.dom.svg.LiveAttributeValue a =
          getLiveAttributeValue(
            ns,
            ln);
        ((org.apache.batik.dom.svg.AbstractSVGAnimatedValue)
           a).
          updateAnimatedValue(
            val);
    }
    public void updateOtherValue(java.lang.String type,
                                 org.apache.batik.anim.values.AnimatableValue val) {
        
    }
    public org.apache.batik.anim.values.AnimatableValue getUnderlyingValue(java.lang.String ns,
                                                                           java.lang.String ln) {
        org.apache.batik.dom.svg.LiveAttributeValue a =
          getLiveAttributeValue(
            ns,
            ln);
        if (!(a instanceof org.apache.batik.dom.svg.AnimatedLiveAttributeValue)) {
            return null;
        }
        return ((org.apache.batik.dom.svg.AnimatedLiveAttributeValue)
                  a).
          getUnderlyingValue(
            this);
    }
    protected org.apache.batik.anim.values.AnimatableValue getBaseValue(org.w3c.dom.svg.SVGAnimatedInteger n,
                                                                        org.w3c.dom.svg.SVGAnimatedInteger on) {
        return new org.apache.batik.anim.values.AnimatableNumberOptionalNumberValue(
          this,
          n.
            getBaseVal(
              ),
          on.
            getBaseVal(
              ));
    }
    protected org.apache.batik.anim.values.AnimatableValue getBaseValue(org.w3c.dom.svg.SVGAnimatedNumber n,
                                                                        org.w3c.dom.svg.SVGAnimatedNumber on) {
        return new org.apache.batik.anim.values.AnimatableNumberOptionalNumberValue(
          this,
          n.
            getBaseVal(
              ),
          on.
            getBaseVal(
              ));
    }
    public short getPercentageInterpretation(java.lang.String ns,
                                             java.lang.String an,
                                             boolean isCSS) {
        if (isCSS ||
              ns ==
              null) {
            if (an.
                  equals(
                    org.apache.batik.util.CSSConstants.
                      CSS_BASELINE_SHIFT_PROPERTY) ||
                  an.
                  equals(
                    org.apache.batik.util.CSSConstants.
                      CSS_FONT_SIZE_PROPERTY)) {
                return PERCENTAGE_FONT_SIZE;
            }
        }
        if (!isCSS) {
            org.apache.batik.util.DoublyIndexedTable t =
              getTraitInformationTable(
                );
            org.apache.batik.dom.svg.TraitInformation ti =
              (org.apache.batik.dom.svg.TraitInformation)
                t.
                get(
                  ns,
                  an);
            if (ti !=
                  null) {
                return ti.
                  getPercentageInterpretation(
                    );
            }
            return PERCENTAGE_VIEWPORT_SIZE;
        }
        return PERCENTAGE_VIEWPORT_SIZE;
    }
    protected final short getAttributePercentageInterpretation(java.lang.String ns,
                                                               java.lang.String ln) {
        return PERCENTAGE_VIEWPORT_SIZE;
    }
    public boolean useLinearRGBColorInterpolation() {
        return false;
    }
    public float svgToUserSpace(float v, short type,
                                short pcInterp) {
        if (unitContext ==
              null) {
            unitContext =
              new org.apache.batik.dom.svg.SVGOMElement.UnitContext(
                );
        }
        if (pcInterp ==
              PERCENTAGE_FONT_SIZE &&
              type ==
              org.w3c.dom.svg.SVGLength.
                SVG_LENGTHTYPE_PERCENTAGE) {
            return 0.0F;
        }
        else {
            return org.apache.batik.parser.UnitProcessor.
              svgToUserSpace(
                v,
                type,
                (short)
                  (3 -
                     pcInterp),
                unitContext);
        }
    }
    public void addTargetListener(java.lang.String ns,
                                  java.lang.String an,
                                  boolean isCSS,
                                  org.apache.batik.dom.anim.AnimationTargetListener l) {
        if (!isCSS) {
            if (targetListeners ==
                  null) {
                targetListeners =
                  new org.apache.batik.util.DoublyIndexedTable(
                    );
            }
            java.util.LinkedList ll =
              (java.util.LinkedList)
                targetListeners.
                get(
                  ns,
                  an);
            if (ll ==
                  null) {
                ll =
                  new java.util.LinkedList(
                    );
                targetListeners.
                  put(
                    ns,
                    an,
                    ll);
            }
            ll.
              add(
                l);
        }
    }
    public void removeTargetListener(java.lang.String ns,
                                     java.lang.String an,
                                     boolean isCSS,
                                     org.apache.batik.dom.anim.AnimationTargetListener l) {
        if (!isCSS) {
            java.util.LinkedList ll =
              (java.util.LinkedList)
                targetListeners.
                get(
                  ns,
                  an);
            ll.
              remove(
                l);
        }
    }
    void fireBaseAttributeListeners(java.lang.String ns,
                                    java.lang.String ln) {
        if (targetListeners !=
              null) {
            java.util.LinkedList ll =
              (java.util.LinkedList)
                targetListeners.
                get(
                  ns,
                  ln);
            java.util.Iterator it =
              ll.
              iterator(
                );
            while (it.
                     hasNext(
                       )) {
                org.apache.batik.dom.anim.AnimationTargetListener l =
                  (org.apache.batik.dom.anim.AnimationTargetListener)
                    it.
                    next(
                      );
                l.
                  baseValueChanged(
                    this,
                    ns,
                    ln,
                    false);
            }
        }
    }
    protected org.w3c.dom.Node export(org.w3c.dom.Node n,
                                      org.apache.batik.dom.AbstractDocument d) {
        super.
          export(
            n,
            d);
        org.apache.batik.dom.svg.SVGOMElement e =
          (org.apache.batik.dom.svg.SVGOMElement)
            n;
        e.
          prefix =
          prefix;
        e.
          initializeAllLiveAttributes(
            );
        return n;
    }
    protected org.w3c.dom.Node deepExport(org.w3c.dom.Node n,
                                          org.apache.batik.dom.AbstractDocument d) {
        super.
          deepExport(
            n,
            d);
        org.apache.batik.dom.svg.SVGOMElement e =
          (org.apache.batik.dom.svg.SVGOMElement)
            n;
        e.
          prefix =
          prefix;
        e.
          initializeAllLiveAttributes(
            );
        return n;
    }
    protected org.w3c.dom.Node copyInto(org.w3c.dom.Node n) {
        super.
          copyInto(
            n);
        org.apache.batik.dom.svg.SVGOMElement e =
          (org.apache.batik.dom.svg.SVGOMElement)
            n;
        e.
          prefix =
          prefix;
        e.
          initializeAllLiveAttributes(
            );
        return n;
    }
    protected org.w3c.dom.Node deepCopyInto(org.w3c.dom.Node n) {
        super.
          deepCopyInto(
            n);
        org.apache.batik.dom.svg.SVGOMElement e =
          (org.apache.batik.dom.svg.SVGOMElement)
            n;
        e.
          prefix =
          prefix;
        e.
          initializeAllLiveAttributes(
            );
        return n;
    }
    protected class UnitContext implements org.apache.batik.parser.UnitProcessor.Context {
        public org.w3c.dom.Element getElement() {
            return SVGOMElement.this;
        }
        public float getPixelUnitToMillimeter() {
            return getSVGContext(
                     ).
              getPixelUnitToMillimeter(
                );
        }
        public float getPixelToMM() { return getPixelUnitToMillimeter(
                                               );
        }
        public float getFontSize() { return getSVGContext(
                                              ).
                                       getFontSize(
                                         );
        }
        public float getXHeight() { return 0.5F;
        }
        public float getViewportWidth() {
            return getSVGContext(
                     ).
              getViewportWidth(
                );
        }
        public float getViewportHeight() {
            return getSVGContext(
                     ).
              getViewportHeight(
                );
        }
        public UnitContext() { super(); }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "AA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "hqQpFwl7TaQGU+qsqPbISGxrgJmCFzTxUbEZkstub1mc4UW6Xo1EVljP5CbZ" +
           "4gSw2fUG4sikWKs0olg5IltdXOrgtWS4DoxFXKqRcqo6ASWOMW+Bwo2SMS0g" +
           "cdCPOBakSooY+2V35dN0rWUUynhNbIxJsjFeDVuypLbhkY80p7qyHuJjmYtl" +
           "Re1yUTP2RxTcQQtEcy71qKUVLYSUD7jWeL1Zzt1y0E0xVmvzG6tisdMCN/eL" +
           "m0k7toxBAQUKGft0Y9qW+3M1IZhFoy0uyvR6zcKDcNbBZmYNeNaSSuMeKfmh" +
           "xLkjqmDW1QHdx6f0fDJpVfR6rzuspRsetQfwxCe70cgWu0LQ7cbmAJSbWswP" +
           "Rhjf7UocuSyMKjbFtryNrqnLWK0ENqaq8Lyuz1it2xrPFYz3yNjTG6O01/el" +
           "iGGnYd1pzUk5GhsePFeKKNZq1FpmPaqmFGNrRRiNHEwsEM6EYsu9ZbVeaMKp" +
           "3XArLpWoPmNirkzYC7I3ctmkOEuVfj+00tZ4Cm8KnrvuKn12PVq00nEdr6jr" +
           "klPG4DKhTycJvXQ9bkS78ljo1vTiMCITiy9KdtHkAtaVqm1uFBIFmYqmxJrf" +
           "oEIc4ssNp4aq2Ys5VepObW/p9iqCWmvX2EGj3WrrdIRvWgZiY0Inneg01RVG" +
           "Sa0qCYVF2i0IlSVRwWJBGfXSbjioj32fcAd40GKjXoXjlalUIzcLl+8ksE/y" +
           "syEfKSzJT/kSSfeNutNcMqMhOwhdvW7pbkmdqAYf1hQzxWzB74ftHogwfOg2" +
           "GnUdrVXR5piyQrzdtgfiYGGOypFVJformlQbU7ZWUwZCNKupSxKbiPWwjQrR" +
           "PKirBSZSK5sSvvbKS77r02kX34x4EUs6tQqfNt0laQdjJ1iVCSZIepRZaaQb" +
           "qSbNTXzAhGuPs7GwVzCXFXeZFMRuJYpnG1vvNtkGxZL+qgaiqVGbMTUSqMXj" +
           "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" +
           "prZB2TJ3CKuPpvV4RGC250YJsdws2NQIVcmdtWFUrjlTC10sKxMCH1SW3Yrb" +
           "gnuzaIElhNTvrxcKO5B7i+natFpLv6Q3HCrqq0xl6THrdaCWO3QVcydrTLO4" +
           "bhz2UjmeKQ3HpdnBIilv9IWKxRtrE5Y3JYyIxuWmN4SbQplvWlTLFVYaOlmy" +
           "VsEsetm2QEclo9ObtYg5bcoaWfSmglvWYnNVjiK4iw9tPgjXNUQfDTGVC+BJ" +
           "iqsq0fX4hksM+WVhONyI4M0N+BY20AeRYPhFUPOWZWJo8S156IrsytdKAW8O" +
           "l3CxFimdphmwRA9taeJSHqMrCwmXjbZebo2lqEdReJsVa1hR8Da2UO2jLYGs" +
           "i1QB4dO4yWlVa8Qmg6FWXxkLqpdadmw57ozeeO4CG00QhFpP22iimy1UQZCa" +
           "zoGtivCNELzIvfKV2Sveq3+2t+yb8gOF/Wse8HKdDZA/w9tleukFj0XQdV7g" +
           "RpoSaWq6f7qanzPdcIXT1UMnUMf2TjVeftG5upddwQU72Ul6fnYchm5wdvdM" +
           "PXsBv+tyl0H5y/cH3vD4kyr3weLx3fO+cQSd3L2jO1j9GsDmpZc/ZWDzi7CD" +
           "Q6gvvOGf7xReZbz2Zzhmv+eIkEdZ/j771JfIlyi/eRw6sX8kddEV3YWTzl14" +
           "EHUq0KI4cIQLjqPu2jfG7Znu7wNGeMuuMd5y6aPuSxs496itH13hLHV1hbG8" +
           "8SPoFNiMdi9H9kx+S2bypKzkNyiHx3J/DH7aacfhlfIOZx/0rVnnywHYd+yC" +
           "fsfzD/o3rjD2pqz59Qi6A4Dum6lmZU4suKxpWaatRbs+ODgUdmJ2Cmi58iEF" +
           "PPJcFZBZ/T27CnjP86+Ad15h7ImseSyCrt9TAADPZn2PHuB723PFdy/A9f5d" +
           "fO9//vH97hXG3p8174mgFwB8bZCSQJWqHYH3O88V3j0A1od34X34+Yf3B1cY" +
           "+2jW/N42aCcdzZwb0RF0H3qu6B4AqJ7eRff084/u01cY+5Os+UQEnQHoRFNL" +
           "PDeIxqa6vfY+hPEPnyvGlwBsn9rF+KnnH+PnrjD2+az5LNj7D2G8pCH/7GcB" +
           "mQKPP3SzvZfIH/g/3YmDvfaOi35ls/1liPKxJ09fe/uTo2/kN8H7v964joGu" +
           "1WPLOnztcuj5pBdoupnDvW57CePlH18FifdyEkXQCdDmgv/llvprEfTCS1ED" +
           "StAepvw6cJmjlCBt55+H6b4BAueADtQd24fDJN8C3AFJ9vi33iUudra3VOmx" +
           "Q7XKrovlRrv5pxltf8rhC+Wsvsl/DbVXi8Tb30OdV55+kuq97ln8g9sLbcWS" +
           "N5uMy7UMdM32bn2/nrnvstz2eJ3sPPjjGz9+3QN7hdeNW4EP3P2QbPdc+sa4" +
           "ZXtRfse7+ePb/+gVH3ry2/k90/8CTrAKJKYmAAA=");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVdCXgcxZWumZFt2bIt+T7lUzbYGMnG4YqMQZZlW6xkaX3F" +
       "iENuzbSkwa3ucXeNPHZiCOQDnLAxhjVH8mHvx4dZCDGYZZ2EOyQmBAPLB4bF" +
       "sCxmOTaBNeziZCH5cDbse9XV0z09XaVpktb39VOrq151vb9evffq6NKBT8gg" +
       "yyTTVJ3W0m0Z1apt0mm7YlpqqlFTLGsdPOtM3p5Qfn/Fh6vPj5PBHWRkr2K1" +
       "JhVLXZFWtZTVQarTukUVPalaq1U1hRztpmqpZr9C04beQcalrea+jJZOpmmr" +
       "kVIxwwbFbCGjFErNdFeWqs28AEqqW6AmdawmdQ3+5PoWMjxpZLa52Sd6sjd6" +
       "UjBnn/sui5KqliuVfqUuS9NaXUvaovU5k5yRMbRtPZpBa9Ucrb1SO5tDcHHL" +
       "2UUQzHqo8vNTu3urGARjFF03KBPPWqNahtavplpIpfu0SVP7rC3kKpJoIRWe" +
       "zJTUtDgvrYOX1sFLHWndXFD7Eaqe7Ws0mDjUKWlwJokVomRmYSEZxVT6eDHt" +
       "rM5QQjnlsjNmkHZGXlpbyiIRbz2jbs/tV1Q9nCCVHaQyra/F6iShEhRe0gGA" +
       "qn1dqmk1pFJqqoOM0qGx16pmWtHS23lLj7bSPbpCs9D8Diz4MJtRTfZOFyto" +
       "R5DNzCapYebF62YKxf8a1K0pPSDreFdWW8IV+BwEHJaGipndCugdZynbnNZT" +
       "lEz3c+RlrPkbyACsQ/pU2mvkX1WmK/CAjLZVRFP0nrq1oHp6D2QdZIACmpRM" +
       "FhaKWGeU5GalR+1EjfTla7eTINdQBgSyUDLOn42VBK002ddKnvb5ZPWSXd/U" +
       "V+lxEoM6p9SkhvWvAKZpPqY1ardqqtAPbMbh81tuU8Y/uTNOCGQe58ts5/nZ" +
       "t05etGDa08/ZeaYE5GnrulJN0s7k/q6Rr0xtnHd+AqtRnjGsNDZ+geSsl7Xz" +
       "lPpcBizM+HyJmFjrJD695tlLvn2/eiJOhjWTwUlDy/aBHo1KGn2ZtKaaK1Vd" +
       "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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "hpgt4musOOn6/aJkSOVlU8j3/H5dRxpj");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "HjhDAflgifEBf8jbpWvUupPZMrr+9iLM2E9v6frpG0RXFnN6uLQwbD57V8H+" +
       "bVfncD99ScD+wZkGbrMZ+DoN3IlMKX/7N10Efz+35e/nLoa/m7IEN12mbvu3" +
       "u4cd5/6Ld/D1klQ8fwdfafzdx/hfcA78r0wDEQDl17f4f/3G4T/hOOw/tgP/" +
       "q1LxMBgZXQ3/SXereD06c5mvtf/yi9Cbz255++yNNlP75R2Uwam4dKbK0DYY" +
       "oR89o77GJnYiU0ZV4SJU7Etbqr50MVTdnCW4+SwVS63qRs+aO0hDU/HkmXpG" +
       "ZvMd/ww9O5UxI+91F+HTf3VL3ldvnJ7tZRMs+4MdlA1T0T3Tp+9Ygawc2/Jr" +
       "9OlP5srI6p2DrFelgRjwkG7f5N38vwHGLI3ZWxzd9/npbdK3b23n2zf/g9xT" +
       "V76t6Gsfdle8r7orO5C/ZvO6joc3Lz96OHtdx8Mb7/2Nb3qYGmD4U/0mhbMP" +
       "v+5hS462MW/lTeFtb7x06dKbnnjcySps2zdfMc+XsvnUdq5vXzgb9BVzfSkw" +
       "O9OFNNebr5zUS+OyCb/wKrN0m9tmudNkyQ5tUnfE6alIX9Wx942bkuxIa8a5" +
       "4xb/ph0JU2T7syD34JXqm76AKK2iEzNzpWtT4dM5MzWeX0Dfsv+irRq/6AYb" +
       "zL3slTEb+t66g763pSI8s5chjyeIr72XOZEpIy06B2kPp4FVQNZjW9Ieu3GG" +
       "ctsh/6sdVL0rFd8U5F54JVXM4cw8IOrV10bUUZaMpm8+71TwQ4Ce8pam8vXS" +
       "dG1PQPffu4Oc70vFdwW5O5e8T3t29pbkTAOPMX73eTG+BGB73Rbj6y4G45nD" +
       "7/0f2AH0B1PxTJC7DQDNpk1Pofz+86IEPd4+vkWJ36Ca/MgOgD+eih8Jcs9X" +
       "jypyo7OHc8InwH7ovOtsQPz+bAt2dh1gr+jkrqleP7ED9idT8RNB7gWqf7QG" +
       "8Kq4f/K8lQws2b60xS3doEr+xR1oP5OKnwty956oZEnKXu53CurPnxfqK9Pa" +
       "2EKNbmSr/a0deH8nFb8a5O47WbtnA/618wJ+FBTt7VvAb7+RgD+3A/AXUvEH" +
       "Qe556sZKXVWV//C8cIFrs/8tW7jfciPhfnEH3C+n4k+C3N2HcM+u2z89B9h0" +
       "SXrWzT69Bfv0DWq3f7cD59+n4q82C6oOG+52kfWec4zzr8+70ii1Tx/Y4vzA" +
       "deD8Z9nlg4OrIz5Ifdv9fwxy9wDER033DMj/dAEP0/c/tIX8oYup2pM47t4R" +
       "97xU3LFZ1Htqqed9J5cSnF7geXDneZ+xowDsdq3v/gWt9T1ZxYcorhw8ZFso" +
       "sldJ+peObVP20CGj5MEddKVvuz64H3CzciTgSh+2gyxzmv74Af3Bi89LUANA" +
       "2S4E3v8PF0PQWcOPg4cyZPkdqF+bilcCv2yD+qgtnAX7VeeFjQC4v7CF/QsX" +
       "rxfHiGs7EDdSAYGmv0E8CJaydxba8jnQviQNfC0o1y9t0f7SDUG7NXToDrR4" +
       "Kl6/WUg5tiTZM9aqpRziPXjoGO8bzoE3/ThIugJvf7vgef+6FzzvfI552OBf" +
       "ccYKqFPzgykSOkO+Y3bygE1FN8jdBVhJ15Sexcd55heP+PjClo8v3BA+Xr6D" +
       "j6MHQAfZK58Pdsx2HfCpmO2m4zzzVNkGvNeAgn9xS8cXL6Y5XH29yYG+A66Z" +
       "ikWQe0nq7sieCDo/XpFTBfIcT97sc3PTya5j9Mo50KfzvbnXg3Lub/Ju/l8j" +
       "+uM3d1+P6xPtQJ9OoBx4Qe7Rk67PNdLgn9cdKgH4d25puPNilOAktn+5I+6b" +
       "U/H2IPfQypfTTyPxHtNGUNtIv16TQraNQ8QnfPuDbziv2r8MIL1/i/j+i1b7" +
       "7EHx3vFTrIPv2EHAd6bi24Pcc4GlGNljX/bYdONEdpljwO86byf/JCjaq7eA" +
       "H78YwGc+IxYPreDZs+9n7aY9fFt8Rse/2UHV96fie8E4l5eky7OmqU84Ce89" +
       "L1tvACw9uWXr9JbkC2UrLe37M3A/vAP4h1LxQeAOerJph/JO7D94DuxZIPCC" +
       "D9pb7O3rwJ67Dkv48R1gfzIVHw1yDyxUT077vSNzeNlnBU5A/vHz2r8XA6jb" +
       "b38cXPHtj2er7mdb67X3ujSsmWH72R24fz4V/zHI3SLHzmYXw97rjjF+8gKG" +
       "vAfCFqNwIzH+1x0Yfy0VnwaDX0mWHfwsnJ+5gAcHB9YWp3UxOI9nbfZel8H4" +
       "/R0Q/zAVvx3kbhNtZw36MPsUwN85L8C060q2AJMbBPB/7AD4p6n4PHBL0zpE" +
       "zwb5hesBGYNrnfxCX/qtsfuv+Ojn5kOV4o89c/dtL3pm/LubrTeHH5O8nczd" +
       "tlgZxsmPHp04P/G5l9sz+dzsyfvBX2x3H5/1BC/IHQCZFvbgy5vUXwEG+KzU" +
       "ICWQJ1P+7+3mupMpg9zN2f+T6f4OtITjdKDpb05OJvkHcHWQJD39qnPYt175" +
       "TaTDocbh97m2VMabh/r3n1SnbLfwvc9WQUdZTn4DL91HlX209fBdEqvNZ1uf" +
       "Ej/yTLf/1q9Uf3DzDT7R4JMkvcptZO7WzecAs4um76N4+VWvdnitW4jHv/rc" +
       "j97+2OG7M567KfCxap8o28vO/todbjpB9n265Kde9LEn/90zn82+U/L/AYA2" +
       "s71NdwAA");
}
