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
      1471109864000L;
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
       "gjNiqRL7/djdmEZtgL32x9o1zX4FUNKg8fN+X8YNWBeTfJDb+E38EZ/2/g/d" +
       "H6WdQCsAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "JcnpjkrhBB5Mpt0uYyAVglbNzZRpkZHX");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("6wBLcOhwocq0A3GThgOhK3JW5+wazSd4u2RT0/Z4k0TpRBGtqDmZmIm9iF3B" +
       "WXksUwHTR38VVBroUuzO6mlvklBjtIpE0aKBrqDFxhAjPXbBXBR4656ILuaj" +
       "XnGt91eYoK2EhjRWhcWKQkSuJFHtltMSVIaUyAo1LqkGSbQZte9Pq710sCh2" +
       "wVKQxhENzC2dos5vdI8qC7rf48TBpjxuc30LzMVBW4VEqbQAAd+CMZejfh3S" +
       "FprTkiKjD2KnhldOJ1WSZ3oGOmOKE3TKiE19POsSSrFVQVsSBEMGpHVqojbE" +
       "QwzDns93xP7NzW2ZPZDvBB4emvwR9gCTYy8yDjdX87+Luw3Wg43W685MPHbs" +
       "rdwjUeGZbNt0XVGP75aeOnGWvd964qxjk/m7rS994uVXtMEvli/sXnikUeHO" +
       "yPPfZ+sr3T7W66X8/m+d3A4ugeulncQvnd4OPtLJuXvB57x8+eNz8v4kS/4w" +
       "KrzdPHwhjdl231zph6+qwxtuYq48Uzuy1Ldv5vTHKRXcnT0sguszOxV85mZU" +
       "EBVu9wNzJUf66+rhv52T99+z5M+iwmNHejiphCz/Px0B/t6bAPxg9vBJcH1x" +
       "B/iLN2vz518X61+enbeXd/W/o8Ldhh71PVW2md37Q+wI31+8CXxPHBj0yzt8" +
       "X37L8e1dOifv7iy5LSrcC/Bx17/oefoG4/3k251DNexdfBNqeOZADV/bqeFr" +
       "b70aHjsn7/EseQjwEFADfeJt4rvO0cCxV4hHanj4zarhveD6+k4NX3/r1fCu" +
       "c/KyF797T0eFS5k3HL6L3HvHEbpn3qyvXwHXN3bovvHWo4PPyatmyfsACQJ0" +
       "nWPvAs9z8mPnAXP8+28C/7PZw/eD65s7/N+8WfyvO3/tnXMMca+ZJVejwqMA" +
       "/1mHq5QjqB94E1Afyh5mp4p+dwf1d996qP1z8pgsaQNTu/qa8bTDsy33Hzf1" +
       "YUYOt/Mm4GbfKxQa4PrWDu633nq40jl5H84SECo+Bix7+gzh4bnAyRFW4aYO" +
       "oEaFh2/0aUF2SPqx675i2n55o37llfvuePQV/lvbs2oHX8fc2S/cMYtt+/i5" +
       "zGP3F30wKs1cE3duT2nmh8Syk9qPnfW+PircAtJM6D1lW3oG5L1RaVASpMdL" +
       "mjuHOF4yKtyW/z9ezgaMeFQuKlzc3hwv4oHWQZHs1vcPvK30+p9q5N9zudFB" +
       "7Lx3LPzdeVkeYjz4egY7rHL8EH92LCv/Gu3gCFW8/R7tmvrVV7rMx35Q+8Xt" +
       "RwSqLadp1sod/cLt2+8Z8kazY1hPn9naQVsXO8/98N6v3fnOg3D+3q3ARx5/" +
       "TLanbnxcv+X4UX7APv2nj/6TD/yjV76dHzP4f+ZTzTgmOAAA");
}
