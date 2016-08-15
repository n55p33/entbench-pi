package org.apache.batik.dom.svg;
public abstract class SVGOMAnimationElement extends org.apache.batik.dom.svg.SVGOMElement implements org.w3c.dom.svg.SVGAnimationElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGOMElement.
                 xmlTraitInformation);
             t.put(null, SVG_EXTERNAL_RESOURCES_REQUIRED_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_BOOLEAN));
             xmlTraitInformation = t; }
    protected org.apache.batik.dom.svg.SVGOMAnimatedBoolean externalResourcesRequired;
    protected SVGOMAnimationElement() { super(); }
    protected SVGOMAnimationElement(java.lang.String prefix, org.apache.batik.dom.AbstractDocument owner) {
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
    public org.w3c.dom.svg.SVGElement getTargetElement() {
        return ((org.apache.batik.dom.svg.SVGAnimationContext)
                  getSVGContext(
                    )).
          getTargetElement(
            );
    }
    public float getStartTime() { return ((org.apache.batik.dom.svg.SVGAnimationContext)
                                            getSVGContext(
                                              )).
                                    getStartTime(
                                      ); }
    public float getCurrentTime() { return ((org.apache.batik.dom.svg.SVGAnimationContext)
                                              getSVGContext(
                                                )).
                                      getCurrentTime(
                                        );
    }
    public float getSimpleDuration() throws org.w3c.dom.DOMException {
        float dur =
          ((org.apache.batik.dom.svg.SVGAnimationContext)
             getSVGContext(
               )).
          getSimpleDuration(
            );
        if (dur ==
              org.apache.batik.anim.timing.TimedElement.
                INDEFINITE) {
            throw createDOMException(
                    org.w3c.dom.DOMException.
                      NOT_SUPPORTED_ERR,
                    "animation.dur.indefinite",
                    null);
        }
        return dur;
    }
    public float getHyperlinkBeginTime() {
        return ((org.apache.batik.dom.svg.SVGAnimationContext)
                  getSVGContext(
                    )).
          getHyperlinkBeginTime(
            );
    }
    public boolean beginElement() throws org.w3c.dom.DOMException {
        return ((org.apache.batik.dom.svg.SVGAnimationContext)
                  getSVGContext(
                    )).
          beginElement(
            );
    }
    public boolean beginElementAt(float offset)
          throws org.w3c.dom.DOMException {
        return ((org.apache.batik.dom.svg.SVGAnimationContext)
                  getSVGContext(
                    )).
          beginElementAt(
            offset);
    }
    public boolean endElement() throws org.w3c.dom.DOMException {
        return ((org.apache.batik.dom.svg.SVGAnimationContext)
                  getSVGContext(
                    )).
          endElement(
            );
    }
    public boolean endElementAt(float offset)
          throws org.w3c.dom.DOMException {
        return ((org.apache.batik.dom.svg.SVGAnimationContext)
                  getSVGContext(
                    )).
          endElementAt(
            offset);
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
    protected org.apache.batik.util.DoublyIndexedTable getTraitInformationTable() {
        return xmlTraitInformation;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "fKH5Ge7Y3+KP+PTt/wIoNR0CGywAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "+znw5Rvk/U5O/nkM3Q+w87ESxoLl6mep");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("+V2G4ysnQH/pVkE/DR53D9q9/aD/9Q3yfj8nX4uhBwHoXhKGQJo57Dz1K8cI" +
       "v36rCPNbXfEeYXz7Ef77U3kHV09Qj59U3f6YGmSqHuSTQFH5Wzn5QzDf5nK3" +
       "3MDR+0moHF6eOcGFb94qF3Lz/qk9F37q9nPhT26Q92c5+c8x9CgAiYNpJ3Qs" +
       "b9nVTcs7Q9z/5RaAPnKo0D+zB/oztx/od88Wd/7z20WBv8jJm8CU5znCk17q" +
       "lCmfn+/OnY+x//dbxf4MeF7dY3/19mA/ge8reYGDu27CgIPzOQGW9uBJBiDF" +
       "vam/PMJ6cHCrWHNv/Zk91s/cdjkfPHQzmI/k5P4Yuk/3tD3IUxAfuB2q/Lk9" +
       "xM/9PxLnkzfD+XROHgf6fIzzGmG+4xaQPpUn/hB4Xt8jff32C/OFG+SVcnIp" +
       "ht6Zhx03u1Hy7HWXG0fXSI658vwtcOUdeeJ7wfPbe6789u3nSusGeZ2cVGPo" +
       "EcCVQyag+u5W/yEznjyDGbu7bfmNxWM+1G6VD3n+l/d8+PLt58PgBnlYTj68" +
       "m7sO+ZBriRft13EHLx0DRW4V6Ivg+eoe6FdvP1D2Bnl8Tsh9JLKJYt0lFc9M" +
       "FFM/BZK6HV7tG3uQ37g9IE84rQ8VaH7kBkiv5GQKHNpCiY5EecqhzW4BZD4J" +
       "FzfbvrkH+c23CvKmK+gD6wZ5y5xoIPLMV1OnLvsdXeCTjrHqb+mmKDCFM6/7" +
       "5xeXH7/mz0W7P8SoX3jtwj1vf038w+LG+9GfVu4loXuMxHFO3qA88X53EOqG" +
       "VbDi3t19yqDAF+6D6rMu9sXQHYAWdrnalU5i6G1nlQYlAT1ZEkC7eLokWHAV" +
       "3yfLfRTM+cflYuju3cvJIj8GWgdF8tcfDw7d5dkXfY9uIx5uVu1WDo+f1K0i" +
       "OHz4ZmI6qnLyNn2+R1X8M+xwPynZ/Tfsivr6awT90Tebn9vd5lcdZbvNW7mH" +
       "hM7v/lhQNJrvST1z3dYO27obf+F7D/7Wvc8f7p89uBvwsZ6fGNvTZ9+bH7hB" +
       "XNx03/7Tt//j9//qa98qLh/+XxEK/mKyNwAA");
}
