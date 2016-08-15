package org.apache.batik.dom.svg;
public abstract class SVGURIReferenceTextPositioningElement extends org.apache.batik.dom.svg.SVGOMTextPositioningElement implements org.w3c.dom.svg.SVGURIReference {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGOMTextPositioningElement.
                 xmlTraitInformation);
             t.put(XLINK_NAMESPACE_URI, XLINK_HREF_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_URI));
             xmlTraitInformation = t; }
    protected org.apache.batik.dom.svg.SVGOMAnimatedString
      href;
    protected SVGURIReferenceTextPositioningElement() { super(
                                                          );
    }
    protected SVGURIReferenceTextPositioningElement(java.lang.String prefix,
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
    private void initializeLiveAttributes() { href =
                                                createLiveAnimatedString(
                                                  XLINK_NAMESPACE_URI,
                                                  XLINK_HREF_ATTRIBUTE);
    }
    public org.w3c.dom.svg.SVGAnimatedString getHref() {
        return href;
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
       "a2MXJSgAAA==");
}
