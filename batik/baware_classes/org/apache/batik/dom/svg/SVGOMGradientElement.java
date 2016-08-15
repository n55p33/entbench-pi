package org.apache.batik.dom.svg;
public abstract class SVGOMGradientElement extends org.apache.batik.dom.svg.SVGStylableElement implements org.w3c.dom.svg.SVGGradientElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGStylableElement.
                 xmlTraitInformation);
             t.put(null, SVG_GRADIENT_UNITS_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_IDENT));
             t.put(null, SVG_SPREAD_METHOD_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_IDENT));
             t.put(null, SVG_GRADIENT_TRANSFORM_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_TRANSFORM_LIST));
             t.put(null, SVG_EXTERNAL_RESOURCES_REQUIRED_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_BOOLEAN));
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
    protected static final java.lang.String[]
      SPREAD_METHOD_VALUES =
      { "",
    SVG_PAD_VALUE,
    SVG_REFLECT_VALUE,
    SVG_REPEAT_VALUE };
    protected org.apache.batik.dom.svg.SVGOMAnimatedEnumeration
      gradientUnits;
    protected org.apache.batik.dom.svg.SVGOMAnimatedEnumeration
      spreadMethod;
    protected org.apache.batik.dom.svg.SVGOMAnimatedString
      href;
    protected org.apache.batik.dom.svg.SVGOMAnimatedBoolean
      externalResourcesRequired;
    protected SVGOMGradientElement() { super(
                                         );
    }
    protected SVGOMGradientElement(java.lang.String prefix,
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
        gradientUnits =
          createLiveAnimatedEnumeration(
            null,
            SVG_GRADIENT_UNITS_ATTRIBUTE,
            UNITS_VALUES,
            (short)
              2);
        spreadMethod =
          createLiveAnimatedEnumeration(
            null,
            SVG_SPREAD_METHOD_ATTRIBUTE,
            SPREAD_METHOD_VALUES,
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
    }
    public org.w3c.dom.svg.SVGAnimatedTransformList getGradientTransform() {
        throw new java.lang.UnsupportedOperationException(
          "SVGGradientElement.getGradientTransform is not implemented");
    }
    public org.w3c.dom.svg.SVGAnimatedEnumeration getGradientUnits() {
        return gradientUnits;
    }
    public org.w3c.dom.svg.SVGAnimatedEnumeration getSpreadMethod() {
        return spreadMethod;
    }
    public org.w3c.dom.svg.SVGAnimatedString getHref() {
        return href;
    }
    public org.w3c.dom.svg.SVGAnimatedBoolean getExternalResourcesRequired() {
        return externalResourcesRequired;
    }
    protected org.apache.batik.dom.svg.AttributeInitializer getAttributeInitializer() {
        return attributeInitializer;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMAElement(
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
       "20PcvG/lt3i373+WkOaixysAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "IAoZRiUEoQfTbICzyKoyA3a0WNmrshLa");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("g1TroCu9G7ToiQ05GCFns3KMhkhloDFQY7EU1ylidD3VG5pFI5rhoznTn4ql" +
       "qs5rGSkLQ4iVSBnzPdtrkUq16zUdd43xLZ7CEE3JDIQuIYw3KmXpumGWLHEw" +
       "9RWmVUNRPq75KwHtTSDUwm2jGFUn80CyeY3siZbCqLOJtyTCtlq3w85s7OFR" +
       "NUp6pjkBw5skzLIajJdV1CtSy0rklh1vsu5QWdfkwunarC0ZSE0132eMWjOb" +
       "zzDTR6CgsQIW4XSzHlNzYZET5xFwf0QlpeIqZY09ny0JLsGnIzLFmijfxYfR" +
       "iOSoclCsltHUHqxM34IHps+Mh5NKozdfsTPPVucKWmlEYtzG6y1MlsqjMRuJ" +
       "rpypMKFq6hyZye3u0hEZR8LgZa3fwiiRX1NIqasDGZ0YtcFKWhzOO6qdrSKC" +
       "ID784fyY65/f3PHbvZtTxcMLmn+J88TsjHfnYVy4Q91dqTi6J7T5u1jY3fQ7" +
       "+H/sbPfYtYi9gwPaJ/ID2hTVj5/Lnrr6lr97e/RG9zc3792+8umXXjY6vwyf" +
       "2716WcWFO2M/+DHHXJrOsV4vbJ4/ffI0ugTCizuJXzx9Gn2ksDOPos94DfRn" +
       "Z+T9hzx6PS681z58X044jmAvzcM36dF1T0uXvm0cDeO3b+ZyyikV3JUnFkH4" +
       "wk4FX7gZFcSF24MQeByx+aZ6+O9n5P0wj/5rXHjoSA8nlZDnf+cI8H97G4Cv" +
       "5Ik4CF/dAf7qzY75m75F3CuckbeZQG/EhQcsMz4wdDlUvSi/QnLi9sipWXHw" +
       "ruKwcH6R7Ugnf/42dJJf4SogILy608mr77xO7jkj71Ie3RkXLh3TyYnXf+8/" +
       "Qx/H3vkdamPvwtvVBgzC13fa+Po7r41Hzsh7LI8ejAsXgTakky8P9+47gvjQ" +
       "24D4aGE3E35nB/F33nmIT5+R92wePQnYA0Bkj72FfPyMcT52z2+D/8rbwP9Y" +
       "nvhBEL6xw/+Ndx5/5Yw8PI/guPAIwE+/2TvM6y2Rp15cHmkFeRtaefJAK9/c" +
       "aeWbN6uVN10O96gz8hp59NG48CDQyo2ukj1/BPVjbwPq/XlifonqWzuo33rn" +
       "oXbPyMu9tb0mmACembZ94/Aaz6XjY32YsYErvA24+XcYhRoIr+/gvv7Ow/3k" +
       "GXnP59EYLPBgZE/fmDy8BTk4wqrc1HXb/FrLdT6ZyC9/P3TN11nbL4r0r718" +
       "8Y4HX+7/y+3VvIOvfu4UCndMEsc5fgv12PN5wMYTe6OJO7d3Ujd34vYsgOxG" +
       "Fw3iwi0gzoXem2xLz4C81ysNSoL4eEl3ZxDHS8aF2zb/j5cL4sKFo3Jx4fz2" +
       "4XiRCLQOiuSPcXBgbcWzbkdI8crJh+bAC9875kjvDGzjeNz3ZmN1WOX4dwn5" +
       "5bPNB3YHF8WS7Sd2V/VXX+bbn/pB5Ze330Xojrpe563cIRRu336isWk0v2z2" +
       "+A1bO2jrPPvMG/f8xp1PHWwM7tkKfGTsx2R73/W/QKDdIN58M7D+Bw/+/Q/9" +
       "3Zf/dHMz4v8BC/ccOvk4AAA=");
}
