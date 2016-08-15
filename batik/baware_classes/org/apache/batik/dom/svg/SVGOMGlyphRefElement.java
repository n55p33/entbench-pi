package org.apache.batik.dom.svg;
public class SVGOMGlyphRefElement extends org.apache.batik.dom.svg.SVGStylableElement implements org.w3c.dom.svg.SVGGlyphRefElement {
    protected static final org.apache.batik.dom.svg.AttributeInitializer attributeInitializer;
    static { attributeInitializer = new org.apache.batik.dom.svg.AttributeInitializer(
                                      4);
             attributeInitializer.addAttribute(org.apache.batik.dom.util.XMLSupport.
                                                 XMLNS_NAMESPACE_URI,
                                               null,
                                               "xmlns:xlink",
                                               org.apache.batik.dom.util.XLinkSupport.
                                                 XLINK_NAMESPACE_URI);
             attributeInitializer.addAttribute(org.apache.batik.dom.util.XLinkSupport.
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
    protected org.apache.batik.dom.svg.SVGOMAnimatedString
      href;
    protected SVGOMGlyphRefElement() { super(
                                         );
    }
    public SVGOMGlyphRefElement(java.lang.String prefix,
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
        href =
          createLiveAnimatedString(
            XLINK_NAMESPACE_URI,
            XLINK_HREF_ATTRIBUTE);
    }
    public java.lang.String getLocalName() {
        return SVG_GLYPH_REF_TAG;
    }
    public org.w3c.dom.svg.SVGAnimatedString getHref() {
        return href;
    }
    public java.lang.String getGlyphRef() {
        return getAttributeNS(
                 null,
                 SVG_GLYPH_REF_ATTRIBUTE);
    }
    public void setGlyphRef(java.lang.String glyphRef)
          throws org.w3c.dom.DOMException {
        setAttributeNS(
          null,
          SVG_GLYPH_REF_ATTRIBUTE,
          glyphRef);
    }
    public java.lang.String getFormat() {
        return getAttributeNS(
                 null,
                 SVG_FORMAT_ATTRIBUTE);
    }
    public void setFormat(java.lang.String format)
          throws org.w3c.dom.DOMException {
        setAttributeNS(
          null,
          SVG_FORMAT_ATTRIBUTE,
          format);
    }
    public float getX() { return java.lang.Float.
                            parseFloat(
                              getAttributeNS(
                                null,
                                SVG_X_ATTRIBUTE));
    }
    public void setX(float x) throws org.w3c.dom.DOMException {
        setAttributeNS(
          null,
          SVG_X_ATTRIBUTE,
          java.lang.String.
            valueOf(
              x));
    }
    public float getY() { return java.lang.Float.
                            parseFloat(
                              getAttributeNS(
                                null,
                                SVG_Y_ATTRIBUTE));
    }
    public void setY(float y) throws org.w3c.dom.DOMException {
        setAttributeNS(
          null,
          SVG_Y_ATTRIBUTE,
          java.lang.String.
            valueOf(
              y));
    }
    public float getDx() { return java.lang.Float.
                             parseFloat(
                               getAttributeNS(
                                 null,
                                 SVG_DX_ATTRIBUTE));
    }
    public void setDx(float dx) throws org.w3c.dom.DOMException {
        setAttributeNS(
          null,
          SVG_DX_ATTRIBUTE,
          java.lang.String.
            valueOf(
              dx));
    }
    public float getDy() { return java.lang.Float.
                             parseFloat(
                               getAttributeNS(
                                 null,
                                 SVG_DY_ATTRIBUTE));
    }
    public void setDy(float dy) throws org.w3c.dom.DOMException {
        setAttributeNS(
          null,
          SVG_DY_ATTRIBUTE,
          java.lang.String.
            valueOf(
              dy));
    }
    protected org.apache.batik.dom.svg.AttributeInitializer getAttributeInitializer() {
        return attributeInitializer;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMGlyphRefElement(
          );
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
       "y3slvHzjOf4P5+R9M4/+HZg3Acf9/FZQ");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("fIbhP7hehr8fhM/swX3me8Twf7t6gX9TFPjvefQtADM6CfMEh//1OmAWi6AH" +
       "QfjpPcyfvvEc/tnV8w6Krv43mEsBh4srTbK36I4vxcdg//R6Oc2d0uf2YD93" +
       "ozk9uFCguvsanB5czKPbAWzA6eI0nQd33Ag6f36P8OdvOJ0H33dO3lvy6IEd" +
       "nUKhj2NcD94I5r68x/Xl7xFzb78Wc+/Moyd3zAlnmHvqepl7CIRf3SP81RvP" +
       "XPWcPDiPngHjDTDX25yh7j3XS11++ewre2Bf+R5R99y1qPuhPGoDiNEe4knu" +
       "OjeCu9/YQ/yNG88dcU5efjfioLfnbnuGO+xGcPfaHthr3yPuuGtxN8+jyZ67" +
       "7RnurnnR6hyIb8sTfwCE391D/N03CvGam88D6Zw8JY9+OC49DLi72p0y4Rjq" +
       "+68D6pvzxEdB+MM91D+88VDdc/LyfyAcGGBP4mnpyFd3+8n8OujJRexRRgHX" +
       "fEM3N+PSA1e6k5/fLn7kdX//2f1lRfniKxdvf/gV7l8V19KP/lZyB1W6XU8c" +
       "5+SFxhPPtwZgS2UWyrhjd70xKBBu9ivyK123i0s3gTgX+iDdlf4QkPdKpUFJ" +
       "EJ8s+ZG9kk6WBGOh+D5Z7mNx6c7jcnHp1t3DySI/AloHRfLHHw0OGSifd0eQ" +
       "jbdOfq/78Ghrt/l45KSNFSuz+6/F1VGVkxff8xOt4h9ch6dPye4/XM8rX3qF" +
       "HH3o282f2V28Vxwpy/JWbqdKt+3+A1A0mp9gPXXV1g7bunXwru/c83N3vP3w" +
       "tO2encDH9n5CtieufMUdc4O4uJSeffnhX3zv33vl94oLgv8PMyCOblo3AAA=");
}
