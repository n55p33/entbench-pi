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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "5cZz/O/PSPtmHvxbMG8Cjvv5raDwFMO/");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("f70Mfz94PrMH95nvEcP/7eoZ/nWR4b/nwbcAzOAkzBMc/pfrgFk4QQ+A56f2" +
       "MH/qxnP4p1dPOyia+t9gLgUcLq40yd4Cli1ieAz2T66X09wofW4P9nM3mtOD" +
       "cwWqu67B6cGFPLgNwAacLi6n8+D2G0Hnz+0R/twNp/Pg+85Ie1se3L+jUyjk" +
       "cYzrgRvB3Jf3uL78PWLu6Wsx9648eGLHnHCKuSevl7kHwfMre4S/cuOZq56R" +
       "BufBM2C8AeZ6ySnq3nu91OWXz76yB/aV7xF1778WdT+UBy0AMdhDPMld+0Zw" +
       "9+t7iL9+47kjzkjL70Yc9Pbcpae4w24Ed6/vgb3+PeJudi3u5nnA7LlLT3F3" +
       "zYtWZ0B8Rx75A+D5nT3E33mzEK+5+DwQz0iT8+CHw9JDgLur3SkTjqF+8Dqg" +
       "vjWPfAQ8f7CH+gc3Hqp9Rlr+D4SDFViTOGo8dpXdejK/DnrSiT1KKOAab+rm" +
       "Zli6/0p38vPbxQ+/4e8/u7+syF989cJtD706+5fFtfSjv5XcTpZu0yLLOnmh" +
       "8cT7eQ8sqYxCGLfvrjd6BcJk75Ff6bpdWLoJhHmnD+Jd7o+A/l4pN8gJwpM5" +
       "P7oX0smcYCwU3yfzfSws3XGcLyyd372czPKXQe0gS/76I94hA+Wz7ghyYWrl" +
       "97oPt7Z2i4+HT+pY4Znddy2ujoqcvPie72gV/+A63H2Kdv/hek7+0qvD8Ue+" +
       "jfz07uK9bIlZltdyG1m6dfcfgKLSfAfryavWdljX+cG7v3P3z97+9OFu2927" +
       "Dh/r+4m+PX7lK+6Y7YXFpfTsyw/9wvv+7qu/W1wQ/H+1A+uLWjcAAA==");
}
