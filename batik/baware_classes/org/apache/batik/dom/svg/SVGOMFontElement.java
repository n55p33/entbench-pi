package org.apache.batik.dom.svg;
public class SVGOMFontElement extends org.apache.batik.dom.svg.SVGStylableElement implements org.w3c.dom.svg.SVGFontElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGStylableElement.
                 xmlTraitInformation);
             t.put(null, SVG_EXTERNAL_RESOURCES_REQUIRED_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_BOOLEAN));
             xmlTraitInformation = t; }
    protected org.apache.batik.dom.svg.SVGOMAnimatedBoolean externalResourcesRequired;
    protected SVGOMFontElement() { super(); }
    public SVGOMFontElement(java.lang.String prefix, org.apache.batik.dom.AbstractDocument owner) {
        super(
          prefix,
          owner);
        initializeLiveAttributes(
          );
    }
    protected void initializeAllLiveAttributes() { super.
                                                     initializeAllLiveAttributes(
                                                       );
                                                   initializeLiveAttributes(
                                                     );
    }
    private void initializeLiveAttributes() { externalResourcesRequired =
                                                createLiveAnimatedBoolean(
                                                  null,
                                                  SVG_EXTERNAL_RESOURCES_REQUIRED_ATTRIBUTE,
                                                  false);
    }
    public java.lang.String getLocalName() {
        return SVG_FONT_TAG;
    }
    public org.w3c.dom.svg.SVGAnimatedBoolean getExternalResourcesRequired() {
        return externalResourcesRequired;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMFontElement(
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
       "YBT/6J2/8vLPvfb71RXY/wOQbjkjOyoAAA==");
}
