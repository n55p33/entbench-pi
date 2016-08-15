package org.apache.batik.dom.svg;
public class SVGOMTextPathElement extends org.apache.batik.dom.svg.SVGOMTextContentElement implements org.w3c.dom.svg.SVGTextPathElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGOMTextContentElement.
                 xmlTraitInformation);
             t.put(null, SVG_METHOD_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_IDENT));
             t.put(null, SVG_SPACING_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_IDENT));
             t.put(null, SVG_START_OFFSET_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH));
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
      METHOD_VALUES =
      { "",
    SVG_ALIGN_VALUE,
    SVG_STRETCH_VALUE };
    protected static final java.lang.String[]
      SPACING_VALUES =
      { "",
    SVG_AUTO_VALUE,
    SVG_EXACT_VALUE };
    protected org.apache.batik.dom.svg.SVGOMAnimatedEnumeration
      method;
    protected org.apache.batik.dom.svg.SVGOMAnimatedEnumeration
      spacing;
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      startOffset;
    protected org.apache.batik.dom.svg.SVGOMAnimatedString
      href;
    protected SVGOMTextPathElement() { super(
                                         );
    }
    public SVGOMTextPathElement(java.lang.String prefix,
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
        method =
          createLiveAnimatedEnumeration(
            null,
            SVG_METHOD_ATTRIBUTE,
            METHOD_VALUES,
            (short)
              1);
        spacing =
          createLiveAnimatedEnumeration(
            null,
            SVG_SPACING_ATTRIBUTE,
            SPACING_VALUES,
            (short)
              2);
        startOffset =
          createLiveAnimatedLength(
            null,
            SVG_START_OFFSET_ATTRIBUTE,
            SVG_TEXT_PATH_START_OFFSET_DEFAULT_VALUE,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              OTHER_LENGTH,
            true);
        href =
          createLiveAnimatedString(
            XLINK_NAMESPACE_URI,
            XLINK_HREF_ATTRIBUTE);
    }
    public java.lang.String getLocalName() {
        return SVG_TEXT_PATH_TAG;
    }
    public org.w3c.dom.svg.SVGAnimatedLength getStartOffset() {
        return startOffset;
    }
    public org.w3c.dom.svg.SVGAnimatedEnumeration getMethod() {
        return method;
    }
    public org.w3c.dom.svg.SVGAnimatedEnumeration getSpacing() {
        return spacing;
    }
    public org.w3c.dom.svg.SVGAnimatedString getHref() {
        return href;
    }
    protected org.apache.batik.dom.svg.AttributeInitializer getAttributeInitializer() {
        return attributeInitializer;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMTextPathElement(
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
       "P36p+KEGcN4TMNeLXScYkEJHOqAQtg2o2m1AmQkuma5zIBn8NoJcCu2kxd7J" +
       "8UvGDzWAezFgDsN3aBNkOmAv3lv5zE37gCOW/k/lTRAjU/J98YDv6WbkfFxl" +
       "fhAkPjhaVTJ9dMNJ82bU/minIkZKEilZdr/1cD0XaeAuJC7WCvMdCL+mCCWB" +
       "Y7/ShpEC6JH2kGxCa0BvPmiAhN4NaVg25YZkpJD/d8MNg1d34KCoNx/cINth" +
       "dQDBxx2abbDLx/6ChH9mpjC79jELpVlujfA8bepYisyguF/U4z0e/0jOvlVK" +
       "mZ/J9YtHRtd1XHv6c/eZHwqIsrCDX6KUx0ix+c0CXxTv7eb5rmavVbR20ZmJ" +
       "R0sX2OXYJJNg53DMciyYNEFtoKHlzPS8QjcaMm/SX9m/8vFf7Sl6MUxCG0lI" +
       "YGTyxtzXbWktBXXixljunVmvoPN3+42Lvr398qWJf7zKXxIT845ttj98v/jy" +
       "gWteunXG/rowKW8jhRK+weLvAVdvV9ZTcVjvI5WS0ZIGEmEVcNFZF3IT0cgF" +
       "DGNcLpY4KzOj+JkJFMC5d9u5H+eUyeoI1VepKSWOy1TGSLkzYmrGc/WZ0jQP" +
       "gjNiqRL7/djdmEZtgL32x9o1zX4FUNKi8fN+X8YNWBeTfJDb+E38EZ/2/g81" +
       "/JiqQCsAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "JDndUSmcwIPJtNtlDKRC0Kq5mTItMvJ6");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("HWAJDh0uVJl2IG7ScCB0Rc7qnF2j+QRvl2xq2h5vkiidKKIVNScTM7EXsSs4" +
       "K49lKmD66K+CSgNdit1ZPe1NEmqMVpEoWjTQFbTYGGKkxy6YiwJv3RPRxXzU" +
       "K671/goTtJXQkMaqsFhRiMiVJKrdclqCypASWaHGJdUgiTaj9v1ptZcOFsUu" +
       "WArSOKKBuaVT1PmN7lFlQfd7nDjYlMdtrm+BuThoq5AolRYg4Fsw5nLUr0Pa" +
       "QnNaUmT0QezU8MrppEryTM9EZ0xxgk4ZsamPZ11CKbYqaEuCYMhAy1DXXA7x" +
       "EMOwF/IdsX99c1tm9+c7gYeHJn+MPcDk2IuMw83V/O/8boP1YKP1mjMTjx57" +
       "K/dwVHg62zZdV9Tju6WnTpxl77cev9Gxyfzd1pc/+cqr2uAXyud2LzzSqHBn" +
       "5Pnvt/WVbh/r9UJ+/zdObgeXwPXyTuKXT28HH+nkzL3gM16+/NEZeX+cJX8Q" +
       "Fd5pHr6Qxmy7b670w1fV4XU3MVeeqR1Z6js3c/rjlAruzh4WwfXZnQo+ezMq" +
       "iAq3+4G5kiP9DfXw387I++9Z8qdR4dEjPZxUQpb/H48Af/8tAH4ge/gEuL60" +
       "A/ylm7X5C2+I9S9unLeXd/W/o8Ldhh71PVW2md37Q+wI35+/BXyPHxj0Kzt8" +
       "X3nb8e1dOCPv7iy5LSrcC/Bx177oeeo64/3k251DNeydfwtqePpADV/fqeHr" +
       "b78aHj0j77EseRDwEFADfeJt4rvP0MCxV4hHanjorarhfeD6xk4N33j71fDu" +
       "M/KyF797T0WFC5k3HL6L3HvXEbqn36qvXwbXN3fovvn2o4PPyKtmyfsBCQJ0" +
       "nWPvAs9y8mPnAXP8+28B/zPZww+A61s7/N+6WfxvOH/tnXEMca+ZJVeiwiMA" +
       "/40OVylHUJ9/C1AfzB5mp4p+Zwf1d95+qP0z8pgsaQNTu/qa8bTDsy33HTf1" +
       "YUYOt/MW4GbfKxQa4Pr2Du6333640hl5H84SECo+Cix7+gzh4bnAyRFW4aYO" +
       "oEaFh673aUF2SPrRa75i2n55o3711Yt3PPIq/+3tWbWDr2Pu7BfumMW2ffxc" +
       "5rH78z4YlWauiTu3pzTzQ2LZSe1Hb/S+PircAtJM6D1lW3oG5L1eaVASpMdL" +
       "mjuHOF4yKtyW/z9ezgaMeFQuKpzf3hwv4oHWQZHs1vcPvK30xp9q5N9zudFB" +
       "7Lx3LPzdeVkeYjzwRgY7rHL8EH92LCv/Gu3gCFW8/R7tqvq1V7vMx35Y+4Xt" +
       "RwSqLadp1sod/cLt2+8Z8kazY1hP3bC1g7bOd5770b1fv/PZg3D+3q3ARx5/" +
       "TLYnr39cv+X4UX7APv0nj/zj5//hq9/Jjxn8P1xlvDQmOAAA");
}
