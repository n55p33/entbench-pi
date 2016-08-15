package org.apache.batik.dom.svg;
public class SVGOMUseElement extends org.apache.batik.dom.svg.SVGURIReferenceGraphicsElement implements org.w3c.dom.svg.SVGUseElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGURIReferenceGraphicsElement.
                 xmlTraitInformation);
             t.put(null, SVG_X_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH,
                     PERCENTAGE_VIEWPORT_WIDTH));
             t.put(null, SVG_Y_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH,
                     PERCENTAGE_VIEWPORT_HEIGHT));
             t.put(null, SVG_WIDTH_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH,
                     PERCENTAGE_VIEWPORT_WIDTH));
             t.put(null, SVG_HEIGHT_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH,
                     PERCENTAGE_VIEWPORT_HEIGHT));
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
                                    "embed");
             attributeInitializer.addAttribute(
                                    org.apache.batik.dom.util.XLinkSupport.
                                      XLINK_NAMESPACE_URI,
                                    "xlink",
                                    "actuate",
                                    "onLoad");
    }
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      x;
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      y;
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      width;
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      height;
    protected org.apache.batik.dom.svg.SVGOMUseShadowRoot
      shadowTree;
    protected SVGOMUseElement() { super();
    }
    public SVGOMUseElement(java.lang.String prefix,
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
        x =
          createLiveAnimatedLength(
            null,
            SVG_X_ATTRIBUTE,
            SVG_USE_X_DEFAULT_VALUE,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              HORIZONTAL_LENGTH,
            false);
        y =
          createLiveAnimatedLength(
            null,
            SVG_Y_ATTRIBUTE,
            SVG_USE_Y_DEFAULT_VALUE,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              VERTICAL_LENGTH,
            false);
        width =
          createLiveAnimatedLength(
            null,
            SVG_WIDTH_ATTRIBUTE,
            null,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              HORIZONTAL_LENGTH,
            true);
        height =
          createLiveAnimatedLength(
            null,
            SVG_HEIGHT_ATTRIBUTE,
            null,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              VERTICAL_LENGTH,
            true);
    }
    public java.lang.String getLocalName() {
        return SVG_USE_TAG;
    }
    public org.w3c.dom.svg.SVGAnimatedLength getX() {
        return x;
    }
    public org.w3c.dom.svg.SVGAnimatedLength getY() {
        return y;
    }
    public org.w3c.dom.svg.SVGAnimatedLength getWidth() {
        return width;
    }
    public org.w3c.dom.svg.SVGAnimatedLength getHeight() {
        return height;
    }
    public org.w3c.dom.svg.SVGElementInstance getInstanceRoot() {
        throw new java.lang.UnsupportedOperationException(
          "SVGUseElement.getInstanceRoot is not implemented");
    }
    public org.w3c.dom.svg.SVGElementInstance getAnimatedInstanceRoot() {
        throw new java.lang.UnsupportedOperationException(
          "SVGUseElement.getAnimatedInstanceRoot is not implemented");
    }
    public org.w3c.dom.Node getCSSFirstChild() {
        if (shadowTree !=
              null) {
            return shadowTree.
              getFirstChild(
                );
        }
        return null;
    }
    public org.w3c.dom.Node getCSSLastChild() {
        return getCSSFirstChild(
                 );
    }
    public boolean isHiddenFromSelectors() {
        return true;
    }
    public void setUseShadowTree(org.apache.batik.dom.svg.SVGOMUseShadowRoot r) {
        shadowTree =
          r;
    }
    protected org.apache.batik.dom.svg.AttributeInitializer getAttributeInitializer() {
        return attributeInitializer;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMUseElement(
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
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "6pnda8+/EZfuij3/WVtPdfvYgPnVhvde");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("/4x0UFz/OnqV+PVP/LeHxz+y/MgN3C957ASfJ7v824Mv/Sb1bvUvnynddvhi" +
       "8XUX065u9NzVrxPPh3qchO74qpeKj1x98F8BabOT/+bkwf/RDJ966n/KW+Wv" +
       "nVL3j/Psq3HpHebhuzPMtvtmqh++VYuKhn/tmHr99bh0e+qZ2pHe/f0beVFd" +
       "FHzlUAR354VlkD6+E8HHb0QEcemcH5qpEutvKId/fkrdv8yzr8elh47kcLUQ" +
       "8vrfOAL8jZsAfF9e+ChIL+4Av3ijc/6BN8T6e6fU/Yc8eyUu3W3ocd9TFXu4" +
       "U1fsCN+/vgl8+ZWl0hMgfW6H73O3Ht9/PaXuD/Psm0BHAb7Zgc964ho+6+p3" +
       "rkfg/9OtAP/LO/C/fOvB/89T6r6bZ9/eBy/lz398hOt/3Cyup0D64g7XF289" +
       "ru9fv26v6OLP49KdANf04C3wMWyv3Sy2fOH79R22X7/l2Pbeckpd/s5t7yxY" +
       "BAE2+vB18hG4vXM3AS53NMVVla/uwH311oN78JS6H8qz++LSBQDuYI3M3zIf" +
       "GOaT1zDMXSRxQH4kiPtvVhAISC/vBPHyrRfEU6fU/XCePR6XHgSCOPA8xwWS" +
       "V7/jCOoTNwG1IHscpN/aQf2tWw+1ekodnGfPxKWLACouCB0zjGJ8ae4+C8gv" +
       "0h2f9KGnHZviZ28W92MgvbLD/cqtx/3BU+rycHzvffu6DnDnr/wL2HkxcgTx" +
       "uZuAeH9emF+oeXUH8dVbD7F3St0gzzpx6QEzok1N091O6DmCnt+I9cJrhorn" +
       "5p5n64p7hJ+6CfzFldAGSH+ww/8Htwb/3hHBXyyAyqcI4cN5BjZlFyM9Prw6" +
       "k1+3yYmPosS9yU0AfVde+D6Qvr0D+u0bBfqGO4O9xSl1+QK7p+zc1XVu2M2P" +
       "oM5vVqfza77f3UH97q2HGp5SV7heB2iqq69zZ3TCXN2bgJZHgqUWSN/bQfve" +
       "rYf20VPqPpZnG7CvAbN48tLo4UXQ2RHW7Q3dOAae7sRnJPmF+Ide94na/mdV" +
       "6q++dOHOB18S/23xJcXhp0939Ut3LhLbPn4H99jzWT/UF2YhhLv2b+T6BbJP" +
       "AlDXu9QWl24Dec7v3s/sU/9sXHrbtagBJciPU/78bnU6ThmX7ij+H6f7TFw6" +
       "f0QXl87uPxwn+QXQOyDJH1/wD5Y+9LSbeCLPHH5EQoWKvzTV6OBYZf/45aHj" +
       "elZEvve90ZQdNjn+3UZ+mlJ8cXhw8pHsf3N4Rf3yS93hT3yn8YX970ZUW9lu" +
       "817u7JfO7X/CUnSan548cd3eDvo6Sz/92j2/dtdTByc99+wzfKTzx3h77Npf" +
       "aJCOHxffVGy/+uDfff/ffOn3izt5/w/59rYuCjoAAA==");
}
