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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "5XcUas+2CSNVe3EcGlISq1E5MD5jX1kM3Zl6hnJqeB9+NQf9ZcMHT0RwX9FY" +
       "AeX6kQiuvxoRxNDdfmikYqy+ohz+1W36PlVUvxBDj5zK4bwQiv5/ecrwL34X" +
       "DD9UNBb3opsjhjevVudvf0Vev3Cbvi8W1Wdj6D5djQkPbDjJI3PtnfL3ue+C" +
       "v4I16EdACY/4C7/3/P36bfpeLqp/E0NvBvyNXul4/smbBLMLZ/KnUvm334VU" +
       "Hi4aHwVldySV3ffe0792m77fLqqvAHdx1S3pKerJneBZAZx0lOx+9btg94mi" +
       "sQvKC0fsvvC9Z/cPbtP3X4vqPwOHBkZw8bbp5AZpfcrr776qq0ogtosfoBRX" +
       "6Y/c8H3b/pss+XMvXb3njS+xv1d+g3Hy3dS9BHSPltj22du7M8+X/VDV9hnA" +
       "vfu7PL/8+1PA1a0ulWLoDlCXBP/JHvq/x9DrbgYNIEF9FvLPj4zhLGQM3VX+" +
       "n4X7yxi6cgoXQ5f3D2dB/gpgByDF47f8Y0ur3O4mjI53dqGW4yTi0pk84Mi4" +
       "Sj099Ep6Ohly9iuPIncoP1E8XueT/UeK1+XPvzQhf/LbrV/af2Ui22KeF1ju" +
       "IaC79x+8nOQKT9wS2zGuy9jT37n/V+596jivuX9P8Kmhn6HtLTf/nmPk+HH5" +
       "BUb+a2/84nP/+qU/Kq/A/j952yMeOyoAAA==");
}
