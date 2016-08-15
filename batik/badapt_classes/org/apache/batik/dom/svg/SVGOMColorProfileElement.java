package org.apache.batik.dom.svg;
public class SVGOMColorProfileElement extends org.apache.batik.dom.svg.SVGOMURIReferenceElement implements org.w3c.dom.svg.SVGColorProfileElement {
    protected static final org.apache.batik.dom.svg.AttributeInitializer attributeInitializer;
    static { attributeInitializer = new org.apache.batik.dom.svg.AttributeInitializer(
                                      5);
             attributeInitializer.addAttribute(null, null, SVG_RENDERING_INTENT_ATTRIBUTE,
                                               SVG_AUTO_VALUE);
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
                                    "other");
             attributeInitializer.addAttribute(
                                    org.apache.batik.dom.util.XLinkSupport.
                                      XLINK_NAMESPACE_URI,
                                    "xlink",
                                    "actuate",
                                    "onLoad");
    }
    protected SVGOMColorProfileElement() {
        super(
          );
    }
    public SVGOMColorProfileElement(java.lang.String prefix,
                                    org.apache.batik.dom.AbstractDocument owner) {
        super(
          prefix,
          owner);
    }
    public java.lang.String getLocalName() {
        return SVG_COLOR_PROFILE_TAG;
    }
    public java.lang.String getLocal() { return getAttributeNS(
                                                  null,
                                                  SVG_LOCAL_ATTRIBUTE);
    }
    public void setLocal(java.lang.String local)
          throws org.w3c.dom.DOMException {
        setAttributeNS(
          null,
          SVG_LOCAL_ATTRIBUTE,
          local);
    }
    public java.lang.String getName() { return getAttributeNS(
                                                 null,
                                                 SVG_NAME_ATTRIBUTE);
    }
    public void setName(java.lang.String name)
          throws org.w3c.dom.DOMException {
        setAttributeNS(
          null,
          SVG_NAME_ATTRIBUTE,
          name);
    }
    public short getRenderingIntent() { org.w3c.dom.Attr attr =
                                          getAttributeNodeNS(
                                            null,
                                            SVG_RENDERING_INTENT_ATTRIBUTE);
                                        if (attr ==
                                              null) {
                                            return RENDERING_INTENT_AUTO;
                                        }
                                        java.lang.String val =
                                          attr.
                                          getValue(
                                            );
                                        switch (val.
                                                  length(
                                                    )) {
                                            case 4:
                                                if (val.
                                                      equals(
                                                        SVG_AUTO_VALUE)) {
                                                    return RENDERING_INTENT_AUTO;
                                                }
                                                break;
                                            case 10:
                                                if (val.
                                                      equals(
                                                        SVG_PERCEPTUAL_VALUE)) {
                                                    return RENDERING_INTENT_PERCEPTUAL;
                                                }
                                                if (val.
                                                      equals(
                                                        SVG_SATURATE_VALUE)) {
                                                    return RENDERING_INTENT_SATURATION;
                                                }
                                                break;
                                            case 21:
                                                if (val.
                                                      equals(
                                                        SVG_ABSOLUTE_COLORIMETRIC_VALUE)) {
                                                    return RENDERING_INTENT_ABSOLUTE_COLORIMETRIC;
                                                }
                                                if (val.
                                                      equals(
                                                        SVG_RELATIVE_COLORIMETRIC_VALUE)) {
                                                    return RENDERING_INTENT_RELATIVE_COLORIMETRIC;
                                                }
                                        }
                                        return RENDERING_INTENT_UNKNOWN;
    }
    public void setRenderingIntent(short renderingIntent)
          throws org.w3c.dom.DOMException {
        switch (renderingIntent) {
            case RENDERING_INTENT_AUTO:
                setAttributeNS(
                  null,
                  SVG_RENDERING_INTENT_ATTRIBUTE,
                  SVG_AUTO_VALUE);
                break;
            case RENDERING_INTENT_PERCEPTUAL:
                setAttributeNS(
                  null,
                  SVG_RENDERING_INTENT_ATTRIBUTE,
                  SVG_PERCEPTUAL_VALUE);
                break;
            case RENDERING_INTENT_RELATIVE_COLORIMETRIC:
                setAttributeNS(
                  null,
                  SVG_RENDERING_INTENT_ATTRIBUTE,
                  SVG_RELATIVE_COLORIMETRIC_VALUE);
                break;
            case RENDERING_INTENT_SATURATION:
                setAttributeNS(
                  null,
                  SVG_RENDERING_INTENT_ATTRIBUTE,
                  SVG_SATURATE_VALUE);
                break;
            case RENDERING_INTENT_ABSOLUTE_COLORIMETRIC:
                setAttributeNS(
                  null,
                  SVG_RENDERING_INTENT_ATTRIBUTE,
                  SVG_ABSOLUTE_COLORIMETRIC_VALUE);
        }
    }
    protected org.apache.batik.dom.svg.AttributeInitializer getAttributeInitializer() {
        return attributeInitializer;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMColorProfileElement(
          );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Sr/ZIQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "5vyQhRddLCTDTtAza6aT9/Q23CSkTZfJqdZ0MqpXWGdcZeFdBWsINNzcKSOD" +
       "APpoLfhMFzpNlTFa8caZx3VMGqcgMlqL5lwDnzJMqK/rPcfVa2rGDNgwx1dz" +
       "gW0AWKkFyztjVMVyur2xKca2JlWmv6pG8Kjfj3rjRZbjhtIOuZZQ24KUSkTx" +
       "HaM2CKOFwxsYX0tBf9qy233NkRmrRsRNAlPqvNFqLod1c9xLJnISL2REWCJ5" +
       "q8nRFT/rgbCUus5IrtV7fkU1t5UlE+JexmZ8xxI1J5HbS0HKdCqSNtHaGCb1" +
       "fjtOpelq0dghmhLNtvB4uKUbCGk5YxOs2SOU3Yp8N6EZzSLNBG02+6B4vXTd" +
       "po+sp4jJB1jdrAz8eCFIeYYrc0MJRRNV+aWOSO0B42WL2YZIM9QOTa9mRUbe" +
       "bzVQNBlZjYTrdKJFW8lpWaqStcSRwo4QRYw2xdJFfbc10vp8M1CCCecQK3TO" +
       "KRE8XeeteqOT2HpsZhnHYbsWbUxXWoVqSqO2QPnqRG50ArTLJLLQljm4Nclh" +
       "0V4DmEpvRnTHu1m1kVU6DZJadg19jqjMOFuzNXWnx2uxguQRNx0HnYastjNv" +
       "YtYEp9FcJgO/LamKmmCNIbmilhPb3OyGCSHZlcma9be1iaIH1SZdNVe9sdAP" +
       "MT3AxosJw84Mk2O7FR2OV41Q5je2Ag9FfLfIEZhsgNg4yMSpsIS5le9b/RaL" +
       "NbO4mi1Dfm14sdDwEq3jbHeaFHGt2XqJzfAq7blILphk1wwRMaHXM40LJllu" +
       "SrAWJNG6PWhoBhPA/JjCyg2d+NXtpDxSbhCdngf/PbaG9lVPFuT9p9t45d9l" +
       "6HB2ePL/4hbwfhv10sl22nuK7bS0Jp0/RrvNIVqxifL2O50Klxson/rw8y/I" +
       "i0+jR4cdXy+CrkSu902WkijWuZGvgJ7ed+fNoll5KH62i/obH/6vjy+/dfvs" +
       "qzhae8cFOS92+ZnZZ18avkf6oSPontM91VuO629u9PTNO6lXAyWKA2d5037q" +
       "208N8Wih9yfA8+zBEM++ms390mn2rnKXDfUfuEvdDxbkoxH0IIg0U1cSrPlB" +
       "dOzMu/7Jq9mALwu+72Z8j4NHO+DTXn98P3KXuh8tyPMR9MAJvgvYPvEasJUH" +
       "M8XRpHPA5rw+2C6dMWAlw6dvz3AyLx87Py97i1k/kxSvcPyy8U8W5CeABsKD" +
       "Bspm5rmw4UbQvYmry2da+Rev1eJfB574oJX49bf4v7lL3S8V5F9F0P3A4rdx" +
       "5p9/rQYvIuUHD9A++P/I4P/+zgw/VTL8akE+D0CGZyD/5RnIX3kNIMvloThu" +
       "/N4DyO99/e33u3ep+0JBXoqgR4H9aMWRleKIcexEyuFe2QXPvS/cukF0Bv23" +
       "Xqt9O+D5zAH6Z153+/5+yfCnr2TfLxbkj4ESwluUcMHUf/Ia8BZWhr4ZPC8d" +
       "8L70avF+wyua+q/uUvelgvxFBL0VmPpOJ3KbM6j/+TVAfWNRWKxDXzhA/cLr" +
       "D/Wv71L3twX5CpiwjpLOXVk5id3Xz8fu04oS7suv6twbLAN3utVU3M947JbL" +
       "lPsLgNLPvnDtgbe+wP5RebHn9JLelSn0gBpb1vkj4XPvl71AUfUS2JX9AbFX" +
       "/LsEHRaj2525RtA9gJaCf23PfU8Evel23IAT0POclw+KOs8Jpn75/zzflQi6" +
       "esYXQZf3L+dZHgS9A5bi9SHvxAqvcFOMpcent5pOktxL5/LUg7eVVnv0lax2" +
       "2uT8BaIity1vxZ7kofH+Xuwz0udeIObf9XLz0/sLTJIl5HnRywNT6P79XarT" +
       "XPbJO/Z20tfl0Xu/+vDPXXnqJO9+eC/wmeefk+0dt78q1Le9qLzck//SW//1" +
       "+3/yhT8rj4r/L2DqTYiuLAAA");
}
