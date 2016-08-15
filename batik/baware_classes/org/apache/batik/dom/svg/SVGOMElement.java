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
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "AA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "x3KD/I43/ZPb//iVH338e/k90/8ChHsfjaYmAAA=");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "STNr10NeNrayLMOsCW6MOyTC5QTag2oMficNMXq5wiMoV4/YTyXh0xbOb48U" +
       "nmgn4cgwGWXYujjp1R4+rneyLBBqWlMOGi8FDhCdZwMLnB2meYFMip6G2A8I" +
       "87HrmAqgfawWzXUx23jgur37U233LorzWDCLvs7InK2p/armEWoJllQQwrWy" +
       "2T03Hnpn5K0fPFbTsyzMpAI+mzbAtAH+PR3s9nyxF/JX5dfX/efkdUt7N4WY" +
       "H5juQ8lf5I9aDx5dOTd5a5xNZdqBWtEUaCFTfaHVH2aqNGvqhXZ+dnEvu5Zr" +
       "2LX+XuYquaiLiVglsf+jkrTHkfwzJVPS0OfYDLTaoGkt4Frziwa2Tma4M8Zf" +
       "lJKyfiOdcnvj4b/GcII9P5QXeTSmoV2/hYt8iwQtf1+P4e3dPicxTFKYBKOj" +
       "krQXkRyhZBD0xOYUc48uKs9GgEoFps2Aaz8XZP8AOvRcMQYiVp+cMRfJVazU" +
       "NyRAvInkVQDCcoB40gXiWFTqgSHPg1yaB8MDIWKVyPmBJO0/kJyAcAOUYWNr" +
       "C1pBn0a8G5VGzIfrMJfmcHggRKwDacRnwRkcLzbR6x2Xt7U25ZJqBq00Y/4d" +
       "kpMYnRXA5dGbTyKAaxKmnQXXE1zmJ8LDJWKV6MaX4rQYA/RPMDoDvWnbCuFc" +
       "cRBRHRBn+HIxxE5HgNh4TDsTrqNc7KPhEROxSlAZKUnDsVNsqI3YhrS6NWOY" +
       "lGOB2e/NAxIbFpXpqYbrOJfqeHhARKwSoadI0qqRjIc4GwBZDRHVah6UuLYn" +
       "NiEqJGbC9T4X5/3wSIhYJdKeKUnDICA2G0ZIiASgYEEQra5f0+xDoyYqS4wd" +
       "5WMu0sfh0RCxDmCJY/4VAk+G37MMuEwQWwihP1jb9vxg3jW2sUURIMKmJc+A" +
       "esTsMu3fEkSKI14hq9z1VHkNJvYIBsIyieKsQHKRbVMaFSupwMgM3NKyIi8e" +
       "WxqV7pwNAizi4i4KrTtCVrFq3MQk/1sJKmuRtFAyAtSmcGbEozqtUXmd2VDP" +
       "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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "zxj1apo+hju+DKHtMtK0W2zTGfVAdE6p");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "usWOXgf23HV4wg/uAPvzqXh/kHtAMzw17feO3OFlrxU4Aflnz+v/Xgygbt/9" +
       "cXDFuz+erbmfba3X3uvSc3CG7Vd24P7VVPznIHeLGrmbXQx7rzvG+KELGPIe" +
       "TLcYpzcS43/fgfG3UvHrYPCrqKrbPQvnxy7gh4MDe4vTvhicx7M2e6/LYPzx" +
       "Doh/morfD3K3yY4bgz7MOQXwD84LMO26ki3A5AYB/F87AH42FZ8GYWnahu2z" +
       "QX7mekBG4Fon39CXvmvs/ite+rl5UaX8M8/cfduLnmH/cLP15vBlkrcPcrdp" +
       "oWmefOnRic8nXvdyeyafm/3yfvBX293HZ/2CF+QOgEwre/DFTe4vAwd8Vm6Q" +
       "E8iTOf/PdnPdyZxB7ubs/8l8fw8s4TgfMP3Nh5NZvgKuDrKkH7/qHvatV74T" +
       "6XCocfh+ri2V0eZH/ftPqlO2W/jeZ2ugoyIn34GX7qPKXtp6+CyJcPPa1qfk" +
       "9z2Dk2/+cu3HN+/gk00pSdKr3DbI3bp5HWB20fR5FC+/6tUOr3VL7/GvPvf9" +
       "tz92+OyM524qfKzaJ+r2srPfdte13CB7P13yCy/6wJP/4ZlPZu8p+f+EasMb" +
       "TXcAAA==");
}
