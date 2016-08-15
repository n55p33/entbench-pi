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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Vg7ZIQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Ko+K/w5jvNJKriwAAA==");
}
