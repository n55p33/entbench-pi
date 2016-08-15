package org.apache.batik.dom.svg;
public abstract class SVGOMComponentTransferFunctionElement extends org.apache.batik.dom.svg.SVGOMElement implements org.w3c.dom.svg.SVGComponentTransferFunctionElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGOMElement.
                 xmlTraitInformation);
             t.put(null, SVG_TYPE_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_IDENT));
             t.put(null, SVG_TABLE_VALUES_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER_LIST));
             t.put(null, SVG_SLOPE_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_INTERCEPT_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_AMPLITUDE_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_EXPONENT_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_OFFSET_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             xmlTraitInformation = t; }
    protected static final java.lang.String[]
      TYPE_VALUES =
      { "",
    SVG_IDENTITY_VALUE,
    SVG_TABLE_VALUE,
    SVG_DISCRETE_VALUE,
    SVG_LINEAR_VALUE,
    SVG_GAMMA_VALUE };
    protected org.apache.batik.dom.svg.SVGOMAnimatedEnumeration
      type;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumberList
      tableValues;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      slope;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      intercept;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      amplitude;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      exponent;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      offset;
    protected SVGOMComponentTransferFunctionElement() {
        super(
          );
    }
    protected SVGOMComponentTransferFunctionElement(java.lang.String prefix,
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
        type =
          createLiveAnimatedEnumeration(
            null,
            SVG_TYPE_ATTRIBUTE,
            TYPE_VALUES,
            (short)
              1);
        tableValues =
          createLiveAnimatedNumberList(
            null,
            SVG_TABLE_VALUES_ATTRIBUTE,
            SVG_COMPONENT_TRANSFER_FUNCTION_TABLE_VALUES_DEFAULT_VALUE,
            false);
        slope =
          createLiveAnimatedNumber(
            null,
            SVG_SLOPE_ATTRIBUTE,
            1.0F);
        intercept =
          createLiveAnimatedNumber(
            null,
            SVG_INTERCEPT_ATTRIBUTE,
            0.0F);
        amplitude =
          createLiveAnimatedNumber(
            null,
            SVG_AMPLITUDE_ATTRIBUTE,
            1.0F);
        exponent =
          createLiveAnimatedNumber(
            null,
            SVG_EXPONENT_ATTRIBUTE,
            1.0F);
        offset =
          createLiveAnimatedNumber(
            null,
            SVG_EXPONENT_ATTRIBUTE,
            0.0F);
    }
    public org.w3c.dom.svg.SVGAnimatedEnumeration getType() {
        return type;
    }
    public org.w3c.dom.svg.SVGAnimatedNumberList getTableValues() {
        throw new java.lang.UnsupportedOperationException(
          ("SVGComponentTransferFunctionElement.getTableValues is not im" +
           "plemented"));
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getSlope() {
        return slope;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getIntercept() {
        return intercept;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getAmplitude() {
        return amplitude;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getExponent() {
        return exponent;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getOffset() {
        return offset;
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
       "G1BdHZDtThIHFSvacHJ7Sfi0OtyIgxKi");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("OxJWT5ketFzOfZqDzLFeFopQELRG3LxNUhzvDLoMLPoNxiiGroS4FdSnGIEK" +
       "uva4aE3aS2cZ9fhNJYRasQ/hpZQWmkENWrZbVS/G/YZhzktpuzXtcTyYD4rj" +
       "dXdkQiVZt6YDs5NMei29PCJGq0DiiJHq9GNiGBYVnRTCajsYUbpK2ehUnM4T" +
       "EMD26hVSwSMVRHi073UG/MzbrMxlGE6SDoix4YGX2EPYHhCldpVIhfqKS9Jw" +
       "3evUl4MAJTR4EFqWBAkbU3QrvThO6XG7Qw17c06tUO1Kk4+aEWRCZN9Ba3LV" +
       "RxDkQ9lS1Bt3tkT2cL7yd3gw8wdY80vO2AA3wsJFaXcu4uiwT/53qbA74Xfw" +
       "/9ja6bGzDXsHa/OVbG1+XVGOL8nf6kBbtl/45GkHOfO9wq98+pVX1eHPlM/t" +
       "tovcsHBv6Lh/xtRizTwmxn35/eb65d8SuH5sB+HHTi7/HmnwzLXfM7au/uiM" +
       "vO9kyR+EhfcYthHmO40aYpqUEWtIGPoGmD7vNmdOLnHGjqEe2fU/3MmRkxMq" +
       "eOBgXf5zOxV87k5UEBbucX0jlkLtlnr4n2fkvZkl/yUsPH6kh+uVkOV/9wjw" +
       "f30LgJ85WPL/8g7wl+/U5rfc+dw7f0bePVlSAIpbaOH42Fbi+2/SM26yf3io" +
       "hL29t6CEp7OHELi+ulPCV99+JTx6Rt5jWfJgWHgwU8KNG5HPnaGLo93HI1Vc" +
       "eguqeDJ7+By4vrlTxTffflU8fUbes1nyXsCwQBXc8W3Mp2+phCMFPPlWFZB1" +
       "iF/cKeAX334FnHFEci87Irn3Ylh4ACiAOLYJuvfcEb7i24Hvl3f4fvntx3f1" +
       "jLxsPN+rb/Ehx3ZTj+NrvFV82Vb6b+zw/cbbj693Rl62dbaHhoX7Ab7O0bbs" +
       "cXjYW4WXfUzwxg7eG28/vLPyJlkyAAEFgDc82N89Du6W5/BuxcMtcH1rB+5b" +
       "dwrulgHI3rUz8qQsEcHAm/HwifOJh2cO+SOstzx1c93hVkDkt/XFQnb2+vEb" +
       "vqfafgOkfP3VSxff/erkX23P/R18p3MvVbg4j0zz+CHQY/cXXF+bb+1+7/ZI" +
       "aH7gbk8HUE87HRIW7gJphmJvsS29CgvvvFlpUBKkx0vaYeGhkyXDwvn8//Fy" +
       "Xli476hcWLiwvTleJAStgyLZbeReNyCefqTlIFDeOxbr7nwtj5ceuZXZDqsc" +
       "/yAgO9OWfwx3cP4s2n4Od035xqvk4JPfr//M9oMExZTSNGvlIlW4Z/ttRN5o" +
       "dobt6VNbO2jrAv7Cmw/+3L3PHcTuD24FPvL7Y7K97+ZH/zuWG+aH9dNfePc/" +
       "+OBXX/29/MTB/wPirC4NpTgAAA==");
}
