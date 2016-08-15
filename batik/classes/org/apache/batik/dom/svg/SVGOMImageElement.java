package org.apache.batik.dom.svg;
public class SVGOMImageElement extends org.apache.batik.dom.svg.SVGURIReferenceGraphicsElement implements org.w3c.dom.svg.SVGImageElement {
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
                                      5);
             attributeInitializer.addAttribute(
                                    null,
                                    null,
                                    SVG_PRESERVE_ASPECT_RATIO_ATTRIBUTE,
                                    "xMidYMid meet");
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
    protected org.apache.batik.dom.svg.SVGOMAnimatedPreserveAspectRatio
      preserveAspectRatio;
    protected SVGOMImageElement() { super(
                                      ); }
    public SVGOMImageElement(java.lang.String prefix,
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
            SVG_IMAGE_X_DEFAULT_VALUE,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              HORIZONTAL_LENGTH,
            false);
        y =
          createLiveAnimatedLength(
            null,
            SVG_Y_ATTRIBUTE,
            SVG_IMAGE_Y_DEFAULT_VALUE,
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
        preserveAspectRatio =
          createLiveAnimatedPreserveAspectRatio(
            );
    }
    public java.lang.String getLocalName() {
        return SVG_IMAGE_TAG;
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
    public org.w3c.dom.svg.SVGAnimatedPreserveAspectRatio getPreserveAspectRatio() {
        return preserveAspectRatio;
    }
    protected org.apache.batik.dom.svg.AttributeInitializer getAttributeInitializer() {
        return attributeInitializer;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMImageElement(
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
       "MhLt5qtK4o9Yyf8HlzpBSRsoAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "M36hzXrM0ux2SSLI0goLuEAuqFTGm3U5T4IcaVQINFba3qIqM3ngeNOwTroj" +
       "nictq2kFJMw20kY4izbcvCHb9aCtttBVMJPaRI5nVDDu8EnF7CB+qC5b8dYa" +
       "OlG4jue9TTVZLCh67pFO216MJEpd1RIJOJY6MYsjDKkYaWMtITicSU2KJe2a" +
       "XMs5g8XkVaeJ0TMe9upNczC2MxjGdCpBJ2ys+o15JdMYsgVrZgrTTROBK5TR" +
       "pmC+OqXGa6zSNddrvJEO81ift3LT0jka1YtFFwkNLDdIOBf5oKX1Ejms9UR+" +
       "k2/HRuyFU04Y7datldPDVX3tkrnFYfzCVbEFa8577nAJrCIn0QhOGiTXC9kK" +
       "IW9NCkP80VSOqWZAz7PMHcCzGQaTq34lHHJ1sW7uRgJTUU2CXGtG4qSj7qg1" +
       "mE60RNW7PSsRfF4OXJkwjdZ21G5VpKHujYbZUma9paOuWHo3Rmw7RslKEmNt" +
       "WA1bPtduqUajrSlzu+5LsJ8ZA8dGyUkoDdbi3Bany4kswY0mwVEpidJ6Veyt" +
       "6zbFNwK1tUV36ApBejGZLn2y3uj0d5MqgdkZy+QZYXQTUaLng6o3Gc4q6LCN" +
       "5GBrEwi50exL/nTl8zRO4BPG7ncYvVcJgeza/tCvRc0h442ikcVTWaaktLZb" +
       "1yV0YvdIvk1GYahKmMKvAqmrVFyKHNWxYWfMdgJMxf0GiOOt1U7Bsvoak/pE" +
       "sKjW64oAHANwoMvAjyV9iog5VQ0GlLW2vYq8IFpFGwkEkpuFGkyG1Q4xV5vT" +
       "VFaTquPBTtXjet11SvXTNOW40EN9duL24YHVny+joKVbQSSqo9Vcz6gthzaY" +
       "BquKpoZ3+Vk2RHdVJmk1sTCBhbo2IdJGwspsJpkVWPBqE3ENo9ska1F4kuid" +
       "6pRLmNkImamMTueDYVTbaprVbLFwP6hXtAUfNPJhUqkM+BrCb/1+j9sF5rTT" +
       "RvrNZNwZNXjSnC5WM2OOw25Fj+a53kh3Y84lwpbW93vm1kyqY602HPNJJ+Hw" +
       "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" +
       "Nx/8/zij7i+K7L/twUvF858e4/rvbxTX");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("kyB9+QDXl998XN+/ft25coi/iqDbAK754avJE9hefaPYCtf38gG2l990bOfu" +
       "OKOueONz7gJwggBb/+gd5zG4c7e+AXBPF4VFv988APebbz64B8+o+6Eiuy+C" +
       "HgDgrvGq83B9Xj5jfV6vW8mb+98Ab95VFL4PpN854M3v3ChvXtP7nnvyjLof" +
       "LrLHI+hBwJvrXa1Qj6E+8Qag3l8UPgzSNw6gfuPNh4qcUYcW2XuBt3aNlPV0" +
       "41Du95yU+1FFCfeZNwC3sMBQC6RvHsD95psP94Nn1BWh+bn3gXgCSPb0DaKj" +
       "W0GLY6zP3tD1M7AhuOpWcXE/8qGr/rewv2uvffmlu2978KXpvy4v1h7dh799" +
       "CN1mxrZ98krWiecLfmCYVsmG2/cXtPwSWx/Aut7Vhgi6CeQFxeeofetBBL31" +
       "Wq1BS5CfbMkeaMPJlhF0S/l9sp0QQReP20XQhf3DySYTMDpoUjxO/UNVw8+6" +
       "jzEd00d3iqlA8VeWFh5uaPZbn4dOalrpc+57LaEddTl5jbfYx5R/Qzncc8T7" +
       "P6I8r33lJYb98e81vrC/RqzZSp4Xo9w2hG7d32guBy32LU9cd7TDsS70n3r1" +
       "rl+9/cnDPdZde4KPtf4EbY9d+8Ju1/Gj8opt/msP/sP3f/GlPyrvYvw/eGHk" +
       "hx80AAA=");
}
