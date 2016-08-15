package org.apache.batik.dom.svg;
public class SVGOMFEConvolveMatrixElement extends org.apache.batik.dom.svg.SVGOMFilterPrimitiveStandardAttributes implements org.w3c.dom.svg.SVGFEConvolveMatrixElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGOMFilterPrimitiveStandardAttributes.
                 xmlTraitInformation);
             t.put(null, SVG_IN_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_CDATA));
             t.put(null, SVG_ORDER_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER_OPTIONAL_NUMBER));
             t.put(null, SVG_KERNEL_UNIT_LENGTH_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER_OPTIONAL_NUMBER));
             t.put(null, SVG_KERNEL_MATRIX_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER_LIST));
             t.put(null, SVG_DIVISOR_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_BIAS_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_TARGET_X_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_INTEGER));
             t.put(null, SVG_TARGET_Y_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_INTEGER));
             t.put(null, SVG_EDGE_MODE_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_IDENT));
             t.put(null, SVG_PRESERVE_ALPHA_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_BOOLEAN));
             xmlTraitInformation = t; }
    protected static final java.lang.String[]
      EDGE_MODE_VALUES =
      { "",
    SVG_DUPLICATE_VALUE,
    SVG_WRAP_VALUE,
    SVG_NONE_VALUE };
    protected org.apache.batik.dom.svg.SVGOMAnimatedString
      in;
    protected org.apache.batik.dom.svg.SVGOMAnimatedEnumeration
      edgeMode;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      bias;
    protected org.apache.batik.dom.svg.SVGOMAnimatedBoolean
      preserveAlpha;
    protected SVGOMFEConvolveMatrixElement() {
        super(
          );
    }
    public SVGOMFEConvolveMatrixElement(java.lang.String prefix,
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
        in =
          createLiveAnimatedString(
            null,
            SVG_IN_ATTRIBUTE);
        edgeMode =
          createLiveAnimatedEnumeration(
            null,
            SVG_EDGE_MODE_ATTRIBUTE,
            EDGE_MODE_VALUES,
            (short)
              1);
        bias =
          createLiveAnimatedNumber(
            null,
            SVG_BIAS_ATTRIBUTE,
            0.0F);
        preserveAlpha =
          createLiveAnimatedBoolean(
            null,
            SVG_PRESERVE_ALPHA_ATTRIBUTE,
            false);
    }
    public java.lang.String getLocalName() {
        return SVG_FE_CONVOLVE_MATRIX_TAG;
    }
    public org.w3c.dom.svg.SVGAnimatedString getIn1() {
        return in;
    }
    public org.w3c.dom.svg.SVGAnimatedEnumeration getEdgeMode() {
        return edgeMode;
    }
    public org.w3c.dom.svg.SVGAnimatedNumberList getKernelMatrix() {
        throw new java.lang.UnsupportedOperationException(
          ("SVGFEConvolveMatrixElement.getKernelMatrix is not implemente" +
           "d"));
    }
    public org.w3c.dom.svg.SVGAnimatedInteger getOrderX() {
        throw new java.lang.UnsupportedOperationException(
          "SVGFEConvolveMatrixElement.getOrderX is not implemented");
    }
    public org.w3c.dom.svg.SVGAnimatedInteger getOrderY() {
        throw new java.lang.UnsupportedOperationException(
          "SVGFEConvolveMatrixElement.getOrderY is not implemented");
    }
    public org.w3c.dom.svg.SVGAnimatedInteger getTargetX() {
        throw new java.lang.UnsupportedOperationException(
          "SVGFEConvolveMatrixElement.getTargetX is not implemented");
    }
    public org.w3c.dom.svg.SVGAnimatedInteger getTargetY() {
        throw new java.lang.UnsupportedOperationException(
          "SVGFEConvolveMatrixElement.getTargetY is not implemented");
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getDivisor() {
        throw new java.lang.UnsupportedOperationException(
          "SVGFEConvolveMatrixElement.getDivisor is not implemented");
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getBias() {
        return bias;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getKernelUnitLengthX() {
        throw new java.lang.UnsupportedOperationException(
          ("SVGFEConvolveMatrixElement.getKernelUnitLengthX is not imple" +
           "mented"));
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getKernelUnitLengthY() {
        throw new java.lang.UnsupportedOperationException(
          ("SVGFEConvolveMatrixElement.getKernelUnitLengthY is not imple" +
           "mented"));
    }
    public org.w3c.dom.svg.SVGAnimatedBoolean getPreserveAlpha() {
        return preserveAlpha;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMFEConvolveMatrixElement(
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
       "/IHwYvURttOHthqLNicQbotoH6rgjivjmCXNsfyB8GL1EXa9D60Hi7UmEEul" +
       "fsmwLvgMEuBNz2ujNegZ+BdFqxae45bIx/NHy4vVBxHVh7YJiw2wPQe0GiSe" +
       "QwbsTCKwcahQwLT4lCXKqfxR8GL1kXSrD+06LAYYGZ0O2ashd4jwk+UrXZAk" +
       "hxKSM5ZcZ/KHxIvVR+xbfWi3YXFTbkiuckFy81C52BA8H1hyfZA/JF6sPmLv" +
       "9qHtweJORqoAko5cJy9+GxXruMUGbecQgDYKafjB7BNL8k8GAS3HkYYXqw8w" +
       "D/jQDmCxDxyMQgfaHNlDlROrNIEj872hyhMWExIoMPs0f/NCxpPVR/rHfWg/" +
       "wuIwI+MxYru+4Ka/yvbYsDz6pdwaYGSS3y05vNsxPuuirnm5VHxkb2XJuL2r" +
       "3zY/JqYugJZHSEksIcvOL+WO9yJNpzGJw1tufjfnJ/uBZ0Byr5NKRgqg5MHo" +
       "abP1c+CJcrWGllA6W/7csi1nS0YK+a+z3YuwRbDbMVJkvjib/BJ6hyb4+rKW" +
       "MtxLB7l9KMmM6umve51MUKKCHrVPn5LmKehEp6L4kcKYwfSbZnHe9cIvYfz+" +
       "deq7TMK8gd0tHt67ou3ac199wLxrJsrCli3YS1mEFJvX3nin+OVrmmdvqb6K" +
       "ls/5eMSjw2emzlhHmhO218xE27BJPawRDQ1pgusWllGbvoz1zv4lz7y6o+j1" +
       "IAmsJQGBkVFrs29sJLWETmrWRrK/Oq0RdH49rG7OvZsvmR/7+3F+z4iYX6km" +
       "ebfvFt88cPUbO8fvnxwkZS2kUMJLEPwqydLNykoq9utdpEIympIwRehFEuSM" +
       "T1oj0OYFPAniuFhwVqRr8aYihIHsr8PZ9ztLZXWA6g1qQoliNxURUmbXmJpx" +
       "fTxMaJqLwa6xVInlvVhsSaI2wHy7I62alvqIXjJG427gO2nvYH3a45Xc5E/w" +
       "V3w7+T8l5OQYmzEAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "j7GIEeBSTBHlBdXJRhN3Oxwl1TBSNoo9");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
