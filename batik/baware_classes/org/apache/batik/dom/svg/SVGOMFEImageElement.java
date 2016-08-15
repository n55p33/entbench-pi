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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "MJ+RyGrrdta7GotM8dk1yV8xufL/6i3wLI4pAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "iSO4a7mu0+dux/j/wy3gfzHPzOt9cYf/");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("i28//j88p+yP8+QPEugxgP8ax2+H7Ng/hx3Xq1bw5r/fqu4/BZ6f3vHmp99+" +
       "3vzpOWV/niffS6B7AG+mDJ0fXZ3R/DdvAV1xZyWfRX9uh+7n3h50e8cEaE6w" +
       "t3d9iHtFFPEXAGJ8CuIJ5/WXtyrA3MK/uoP41bddgHv3nVN2KU/uSqB3HAgw" +
       "DlXtjO/au/tWJZhfKf3GDt43/pok+M5zML4rTx4BGOPTGI9FuPfoLWDMpx7o" +
       "A+D5pR3GX3r7Rfjec8relyfPJtBTQIT4jY7gnz/HS+3O3Y+58twtcOU9h1z5" +
       "tR1Xfu1muXLDSGyvdk5ZI0/2E+hxwJXr3WqZHUOFbwHqw3nmk+B5Ywf1jbcf" +
       "6kfOKctXLnsfABO0b6zZQDcOZf3ASVkfFRRwX7oFuPk1WqgNnt/ewf3ttx8u" +
       "c07ZME9IEFsCyZ69vHV0IWt6jJW6qZt/CfTwNa5055dTn7jqryMHf3fQfvHV" +
       "S3c9/qrwn4pbzUd/Sbibhu4yU9c9eR/uxPvFEIRSdsGIuw9ux4UFOhEAu941" +
       "mQS6DaT5mPeEA2o5gR65FjWgBOlJyo/t9OEkZQLdUXyfpLsCZrpjugS6ePBy" +
       "kmQGWgck+asWHirbR25wQ952gWc6ursxAWs7XY304wXB5mAOfuKkzhWz60M3" +
       "Et9RlZN3qfPVbfGPoMOVaHrwn6Ar2tdf7bM/8mbz5w/ucmuummV5K3fR0J0H" +
       "18qLRvPV7HPXbe2wrYvkC9+//xt3v/dw5X3/wYCP9f/E2N597VvTuBcmxT3n" +
       "7J8//k8/+A9e/b3irs//AxSUxDiqNQAA");
}
