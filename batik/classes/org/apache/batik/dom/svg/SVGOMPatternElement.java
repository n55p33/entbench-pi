package org.apache.batik.dom.svg;
public class SVGOMPatternElement extends org.apache.batik.dom.svg.SVGStylableElement implements org.w3c.dom.svg.SVGPatternElement {
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
             t.put(null, SVG_PATTERN_UNITS_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_IDENT));
             t.put(null, SVG_PATTERN_CONTENT_UNITS_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_IDENT));
             t.put(null, SVG_PATTERN_TRANSFORM_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_TRANSFORM_LIST));
             t.put(null, SVG_VIEW_BOX_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER_LIST));
             t.put(null, SVG_PRESERVE_ASPECT_RATIO_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_PRESERVE_ASPECT_RATIO_VALUE));
             t.put(null, SVG_EXTERNAL_RESOURCES_REQUIRED_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_BOOLEAN));
             xmlTraitInformation = t; }
    protected static final org.apache.batik.dom.svg.AttributeInitializer
      attributeInitializer;
    static { attributeInitializer = new org.apache.batik.dom.svg.AttributeInitializer(
                                      5);
             attributeInitializer.addAttribute(
                                    null,
                                    null,
                                    SVG_PRESERVE_ASPECT_RATIO_ATTRIBUTE,
                                    "xMidYMid meet");
             attributeInitializer.addAttribute(
                                    org.apache.batik.dom.util.XMLSupport.
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
                                    "other");
             attributeInitializer.addAttribute(
                                    org.apache.batik.dom.util.XLinkSupport.
                                      XLINK_NAMESPACE_URI,
                                    "xlink",
                                    "actuate",
                                    "onLoad");
    }
    protected static final java.lang.String[]
      UNITS_VALUES =
      { "",
    SVG_USER_SPACE_ON_USE_VALUE,
    SVG_OBJECT_BOUNDING_BOX_VALUE };
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      x;
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      y;
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      width;
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      height;
    protected org.apache.batik.dom.svg.SVGOMAnimatedEnumeration
      patternUnits;
    protected org.apache.batik.dom.svg.SVGOMAnimatedEnumeration
      patternContentUnits;
    protected org.apache.batik.dom.svg.SVGOMAnimatedString
      href;
    protected org.apache.batik.dom.svg.SVGOMAnimatedBoolean
      externalResourcesRequired;
    protected org.apache.batik.dom.svg.SVGOMAnimatedPreserveAspectRatio
      preserveAspectRatio;
    protected SVGOMPatternElement() { super(
                                        );
    }
    public SVGOMPatternElement(java.lang.String prefix,
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
            SVG_PATTERN_X_DEFAULT_VALUE,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              HORIZONTAL_LENGTH,
            false);
        y =
          createLiveAnimatedLength(
            null,
            SVG_Y_ATTRIBUTE,
            SVG_PATTERN_Y_DEFAULT_VALUE,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              VERTICAL_LENGTH,
            false);
        width =
          createLiveAnimatedLength(
            null,
            SVG_WIDTH_ATTRIBUTE,
            SVG_PATTERN_WIDTH_DEFAULT_VALUE,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              HORIZONTAL_LENGTH,
            true);
        height =
          createLiveAnimatedLength(
            null,
            SVG_HEIGHT_ATTRIBUTE,
            SVG_PATTERN_WIDTH_DEFAULT_VALUE,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              VERTICAL_LENGTH,
            true);
        patternUnits =
          createLiveAnimatedEnumeration(
            null,
            SVG_PATTERN_UNITS_ATTRIBUTE,
            UNITS_VALUES,
            (short)
              2);
        patternContentUnits =
          createLiveAnimatedEnumeration(
            null,
            SVG_PATTERN_CONTENT_UNITS_ATTRIBUTE,
            UNITS_VALUES,
            (short)
              1);
        href =
          createLiveAnimatedString(
            XLINK_NAMESPACE_URI,
            XLINK_HREF_ATTRIBUTE);
        externalResourcesRequired =
          createLiveAnimatedBoolean(
            null,
            SVG_EXTERNAL_RESOURCES_REQUIRED_ATTRIBUTE,
            false);
        preserveAspectRatio =
          createLiveAnimatedPreserveAspectRatio(
            );
    }
    public java.lang.String getLocalName() {
        return SVG_PATTERN_TAG;
    }
    public org.w3c.dom.svg.SVGAnimatedTransformList getPatternTransform() {
        throw new java.lang.UnsupportedOperationException(
          "SVGPatternElement.getPatternTransform is not implemented");
    }
    public org.w3c.dom.svg.SVGAnimatedEnumeration getPatternUnits() {
        return patternUnits;
    }
    public org.w3c.dom.svg.SVGAnimatedEnumeration getPatternContentUnits() {
        return patternContentUnits;
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
    protected org.apache.batik.util.DoublyIndexedTable getTraitInformationTable() {
        return xmlTraitInformation;
    }
    public org.w3c.dom.svg.SVGAnimatedString getHref() {
        return href;
    }
    public org.w3c.dom.svg.SVGAnimatedRect getViewBox() {
        throw new java.lang.UnsupportedOperationException(
          "SVGFitToViewBox.getViewBox is not implemented");
    }
    public org.w3c.dom.svg.SVGAnimatedPreserveAspectRatio getPreserveAspectRatio() {
        return preserveAspectRatio;
    }
    public org.w3c.dom.svg.SVGAnimatedBoolean getExternalResourcesRequired() {
        return externalResourcesRequired;
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
        return new org.apache.batik.dom.svg.SVGOMPatternElement(
          );
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
       "41ACj1Ts8iZje2h10V4ttXgp4K4O2UJLYyF/09fWczVYVKIyrI6jHtHnDa3b" +
       "lwZxL6DV2BcgY0p5iJHDtenCyxyny1g553FGW+gN172ZmXSqLNI1Z3QyRxrz" +
       "uNXoYNymu6yyQ5yuo0A7/IQzBh1UF1DB8FFz2qbbi+7SdQV8gLFmLo7CalAt" +
       "B8tldxiVGwMncYhohjD8smcLq2HY5cbuWvOIMa2b3SZh2Tzp0w3MozoIY8Jm" +
       "t80Ik4jlSRSvjsx5BY16ZFvgTUHV6nN1YKD+GKs1Rl1CnrCr2jAfsu04wXQN" +
       "GzKk2lga8bpPxwaGrhYTrFZvm+58CLUERhSajuDMaUFGhRTpVxOi1zNXdI53" +
       "SIFAKZNZ6oBT0a3qaZOZVT2/H+jr9WbWSZn5WPYtURL6zXK/Hq67yDwccVzD" +
       "d3O2I7F9boS2rHSGVpy+Zvbn06lC+gnBCZ4y17mJP87LYZtvZPVE6knGYCxs" +
       "Bhvbd2sbKm2zG73NqmuvK02CPO3yITZIq/4mh/LYxPt8q8KJxmYOqQmT9Lqt" +
       "PFosnFwOVtTcDasQMqO45YzxoRVZYauYW15MK6TgTZcVm9ZdSnXbtroUaALx" +
       "5nk6Hod5oPSz/rSXjNYwIsArud1oDLiaDyE2JcbBsk2tpyq1GM8HHl3jMc4d" +
       "SYQ48tV8yHdjV2UhxIywoYxoNY9p4GWKXrKomZtVFZ2u60m95a5Jt2l0fR1L" +
       "qG6bbihIpHfgFFpmJCHGHcOHyGGHUZJOGnWnXp9duoJN8lxGjalxO3Ltalw3" +
       "UwXMHIHAbvhuCvnUIKvnotAfDJCswgztZq+DTiaILdhVbkMMp5gYzeGkz2hV" +
       "0aFhbYjP23LZV1tyBe2NWjyRdpu1psEwKGq37RrLolRt2kPZ3tKpZSGzZvIm" +
       "NSvLba2vTte+juKsJOIjzHZbSqfRClxzlgxa0tqZYR0sKk91p1Ml1mNl0a2t" +
       "Pb/L1GpO3KBcf9wmA1GrNnt9xRfTiGBxOCHXmcr4fQg4PKKOkVE5qw6ArDzg" +
       "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" +
       "aLaH0zK/nCidGVpfef6gjyezOaeKUd0Z");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "Pk0AAA==");
}
