package org.apache.batik.dom.svg;
public class SVGOMFEImageElement extends org.apache.batik.dom.svg.SVGOMFilterPrimitiveStandardAttributes implements org.w3c.dom.svg.SVGFEImageElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGOMFilterPrimitiveStandardAttributes.
                 xmlTraitInformation);
             t.put(null, SVG_EXTERNAL_RESOURCES_REQUIRED_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_BOOLEAN));
             t.put(null, SVG_PRESERVE_ASPECT_RATIO_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_PRESERVE_ASPECT_RATIO_VALUE));
             t.put(XLINK_NAMESPACE_URI, XLINK_HREF_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_URI));
             xmlTraitInformation = t; }
    protected static final org.apache.batik.dom.svg.AttributeInitializer
      attributeInitializer;
    static { attributeInitializer = new org.apache.batik.dom.svg.AttributeInitializer(
                                      4);
             attributeInitializer.addAttribute(org.apache.batik.dom.util.XMLSupport.
                                                 XMLNS_NAMESPACE_URI,
                                               null,
                                               "xmlns:xlink",
                                               org.apache.batik.dom.util.XLinkSupport.
                                                 XLINK_NAMESPACE_URI);
             attributeInitializer.addAttribute(
                                    org.apache.batik.dom.util.XLinkSupport.
                                      XLINK_NAMESPACE_URI,
                                    "xlink",
                                    "type",
                                    "simple");
             attributeInitializer.addAttribute(
                                    org.apache.batik.dom.util.XLinkSupport.
                                      XLINK_NAMESPACE_URI,
                                    "xlink",
                                    "show",
                                    "embed");
             attributeInitializer.addAttribute(
                                    org.apache.batik.dom.util.XLinkSupport.
                                      XLINK_NAMESPACE_URI,
                                    "xlink",
                                    "actuate",
                                    "onLoad");
    }
    protected org.apache.batik.dom.svg.SVGOMAnimatedString
      href;
    protected org.apache.batik.dom.svg.SVGOMAnimatedPreserveAspectRatio
      preserveAspectRatio;
    protected org.apache.batik.dom.svg.SVGOMAnimatedBoolean
      externalResourcesRequired;
    protected SVGOMFEImageElement() { super(
                                        );
    }
    public SVGOMFEImageElement(java.lang.String prefix,
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
        href =
          createLiveAnimatedString(
            XLINK_NAMESPACE_URI,
            XLINK_HREF_ATTRIBUTE);
        preserveAspectRatio =
          createLiveAnimatedPreserveAspectRatio(
            );
        externalResourcesRequired =
          createLiveAnimatedBoolean(
            null,
            SVG_EXTERNAL_RESOURCES_REQUIRED_ATTRIBUTE,
            false);
    }
    public java.lang.String getLocalName() {
        return SVG_FE_IMAGE_TAG;
    }
    public org.w3c.dom.svg.SVGAnimatedString getHref() {
        return href;
    }
    public org.w3c.dom.svg.SVGAnimatedPreserveAspectRatio getPreserveAspectRatio() {
        return preserveAspectRatio;
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
    public org.w3c.dom.svg.SVGAnimatedBoolean getExternalResourcesRequired() {
        return externalResourcesRequired;
    }
    protected org.apache.batik.dom.svg.AttributeInitializer getAttributeInitializer() {
        return attributeInitializer;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMFEImageElement(
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
      ("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" +
       "mM9IZLV1O+tdjUWm+Oya5K+YXPl/c3xw4o4pAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "J47gruW6Tp+7HeP/97eA/6U8M6/3xR3+");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("L779+P/wnLI/zpM/SKDHAP5rHL8dsmP/HHZcr1rBm/92q7r/FHh+esebn377" +
       "efOn55T9eZ58L4HuAbyZMHR+dHVG89+8BXTFnZV8Fv25Hbqfe3vQ7R0ToDnB" +
       "3t71Ie4VUcRfAIjxKYgnnNdf3qoAcwv/6g7iV992Ae7dd07ZpTy5K4HecSDA" +
       "ONT0M75r7+5blWB+pfQbO3jf+GuS4DvPwfiuPHkEYIxPYzwW4d6jt4Axn3qg" +
       "94Pnl3YYf+ntF+EL55S9N0+eTaCngAjxGx3BP3+Ol9qdux9z5blb4Mp7Drny" +
       "azuu/NrNcuWGkdhe7ZyyRp7sJ9DjgCvXu9UyPYYK3wLUh/PMJ8Hzxg7qG28/" +
       "1A+fU5avXPbeDyZo31yzgWEeyvqBk7I+KijgvnwLcPNrtFAbPL+9g/vbbz9c" +
       "5pwyLk9IEFsCyZ69vHV0IWtyjJW6qZt/CfTwNa5055dTn7jqryMHf3fQf/HV" +
       "S3c9/qr4H4tbzUd/Sbibhu6yUtc9eR/uxPvFEIRSTsGIuw9ux4UFOgkAu941" +
       "mQS6DaT5mPfEA2olgR65FjWgBOlJyo/u9OEkZQLdUXyfpLsCZrpjugS6ePBy" +
       "kmQKWgck+aseHirbh29wQ95xgWc6ursxBms7Q4uM4wXB5mAOfuKkzhWz60M3" +
       "Et9RlZN3qfPVbfGPoMOVaHrwn6Ar+tdf7bM/8mbz5w/ucuuulmV5K3fR0J0H" +
       "18qLRvPV7HPXbe2wrYvki9+//xt3v3C48r7/YMDH+n9ibO++9q1p3AuT4p5z" +
       "9s8e/ycf+Puv/l5x1+f/AQsXczuqNQAA");
}
