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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "vD3Ezfs2fot3+/4HT2/PgMcrAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "kvK1QR9CJWS+EIWZOAe61GNVJG73Gq0J");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("5w9XsMW3IIXQBgydtGb5BF3y9VhtVLV+5inJDDXz3JyOnFYaGMwwX+jycMDX" +
       "cQOEdb2R4Wj9QW3oDhAtQEwWAl5mlGdIaFcXkwkmqoncUQdqjefZKcV5Uj6Z" +
       "LJ3qxhwlMQHVkPYGbANytWHYjYEV+R0SJ6UA7LjKRDPzJEmvsRtxAzZ0DVyE" +
       "oUWMpVAZjTfZEl4mmLOEVTZnhmVK6ZrrpjBvI62GqEJTHRW4QdDomL1u2uJ8" +
       "iJftzRrta4bONjobZ24OF4MIM3K9u0S62GbIQdFsgM31dWeV2o62rMXKmsTw" +
       "fNKC8yQjA1sV8CBojSupB1V4e2R1u0MSHuSJNRLjvlwneqlrG0E2Wpisq2cB" +
       "VtnAwxYVSEuZMURaZhlUaCPT1ngwriftKpkvI2TpxdUyVOtOEGikD5QQw7AP" +
       "FMdc/+LWjt/euj1VPLqg+Zc4T8zOeXcexqW7pIMrFcf3hLZ/l0oHN/0O/584" +
       "2z1xLWLv8ID2yeKANq0qJ89lz1x9K969PXaz+5vb925f/uSLL6nDX4IvHLx6" +
       "2cSlu2PP/wlbSzT7xKz3bJ8/efo0ugLSZw4o/szZ0+hjhp17FH3Oa6A/Pafu" +
       "PxbZq3HpHcbR+3LMthkj0Y7epEc3PC1NPEM9FuO3b+VyyhkW3FsUlkH6/AEL" +
       "Pn8rLIhLd/qhkUix9pp8+O/n1P2wyP5bXHrkmA+nmVDUf+cY8J+9AcBXi8Im" +
       "SF85APyVW5X5a75F3CudU7c1oB/FpYd0LT5U9EkouVFxheTU7ZEzVnH4ruKo" +
       "cXGR7Zgnf/4GeFJc4SohIL1ywJNX3nye3H9O3eUiuzsuXT7Bk1Ov/959Dj9O" +
       "vPM74sbePW+UGzBIXzvgxtfefG6885y6x4vs4bh0CXCDP/3ycO+BY4iPvAGI" +
       "j5UOLOG3DyD+9psP8Zlz6p4tsqeA9wAQuyfeQj5xjpxP3PPb4r/6BvA/XhS+" +
       "D6RvHOD/xpuPv3FOXbPI4Lj0ToCffK13mDdaIs+8uDzmCvIGuPLUIVe+ecCV" +
       "b94qV15zOdxrn1PXKbIPxaWHAVdudpXs+WOoH34DUB8sCotLVN86gPqtNx/q" +
       "6Jy6Ilrb6wMDcLWU9dSjazyXT8r6qGILl3kDcIvvMEotkF49gPvqmw/3Y+fU" +
       "PV9kC7DAA8mevTF5dAtSOMYq3tJ12+Jayw0+mSgufz9y3ddZuy+KlK++dOmu" +
       "h1+a/qvd1bzDr37uZkp3Lde2ffIW6onni8AbL40tJ+7e3Und3onb0wGym100" +
       "iEu3gbwgem+5a20Cem/UGrQE+cmWzoFCnGwZl+7Y/j/Zzo9L9xy3i0sXdw8n" +
       "m0RgdNCkeIz9Q20rn3c7go83diGawyh870QgfaBg28DjgdeS1VGXk98lFJfP" +
       "th/YHV4UW+8+sbumvPJSj/34Dxq/tPsuQrGlPC9GuYsp3bn7RGM7aHHZ7Imb" +
       "jnY41sXue350/6/f/fThxuD+HcHHyn6Ctnfd+AsE0vHj7TcD+T98+B+8/++9" +
       "9CfbmxH/D76vl2P5OAAA");
}
