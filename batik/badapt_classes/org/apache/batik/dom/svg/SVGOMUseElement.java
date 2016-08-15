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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "5dHlRw69xRVN41PUZ5RrDE4zleuT+bct/yHC+gu8XoDVYlthy7RUDOJ0j7ZW" +
       "Bkzo2dewZeLxdx0E3VwYDKiazIDK7pib17m0xMBqAZorVTGFnoVz2xGgOmux" +
       "WsG7vohVq8l582eEHxtaNLNjGm8sRwea5ax40uPYy6OvXvrrI98+MGyGTfP9" +
       "nYSHru7fa+XYrj/+M0eNuXvIE9J56Psi9x2c2nr5u5zesdNI3ZjOdfrg6xza" +
       "C48mz4Rnlz0TJuV9pEa0koxeQU6h9euDwNqwMw9IRLL6s4NkMyJszvih6V4f" +
       "4VrW6yGcYAOecTQ+j/U4hUm4L8uhLLbUb7FXn0OEP2zMr9JhfGwCvTZ4KuPR" +
       "64kBEzMyIZ2U1+uCxDoU7swyu1OXLzbiB3alCscHctA4TUMejFbWOW5cP689" +
       "l35uyHA4DVvboFxhcXiFj+gD+UUv4aJjBUlJ6YCkCLJH/KkBk0Mc5ErOwWNi" +
       "kkd1W/7FvrFhSx4qDwiD/z8IPChohNJt8dntA8I2EwSsFua6Wj9qCF3TtkiL" +
       "gsPdFkVKYh4C0eGgmTy4JNI/g0QbLJ42+Ei0PVAiP2qQaAQfhjwcXl8gh5gK" +
       "9Vlr9PlwuDOQQz9qUMZhKW5C6OVyV4FczofSb63T78Pl7kAu/ajBZCSoNJhg" +
       "+di8pUA2F0GJWwvFfdj8ViCbftSMVBoJIQ5hNUSutiYvPGfi1sNp1qkq80i2" +
       "J0CytMNhW4ZD/ldGrJzZ/u/i0OVLQzaD9cjg8EWimy8nncRQrd7vEoRf4Bze" +
       "te9QfO09S0yfW5t9sdCmpJL3/+Y/LzXd8fvn82S1o5mqLZbpEJVdnNXgklle" +
       "vpPfDzku881xe//0k8bBFYVko9jWcI58E3/PACEW+AcOXlae3fXXqesvT2wu" +
       "ILGc4YHTO+UPO+97ftU8cW+YX4aZvjznEi2bqDnbg1fqlKV0ZX2WH5+TfQwu" +
       "gDJiqcmI9xg4iuh3BvxIA8LDHwX03Y/VDxiZJmUcVYssR6UhmnFhhhEY0XXr" +
       "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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AzHUSh1BsrYByYvq2FxicZi1yw15aNFxs5PQHFGvUqzQoH20X88sJZqXV1II" +
       "pcNeWYvaSxfleCvU0xbNouS4YraERXedubCsxIKSr36lX+NiHp0YYjZCJy3P" +
       "WAH/V0mm3Q0iuD43xwaOy2VwgmmkHSWLAGttXZ3btK1GG1b6wyQUCZwwMbsd" +
       "0LECLEJSr0QUnzbJ7XILXGOnXZ5iKTZXqY7DM0M/aqliecn7JlSeVhQiWm5H" +
       "/c640aQCo5PAEuz4jaiRKYFMjGqCScqqrzWTTOzV23ZWpx0rq8zHEdfx+mJl" +
       "7SbKjG3qHSVCY2ITT+POiMbxZlAn1tN0HGRbQ29ydbXO+Ytmikk8QirSfFY2" +
       "Ibaus3Ydb0c6jq/YVWuwdCpkn4Kzqd8Z6yoW97Zz4J8iim7W190+cLUjAWaB" +
       "LvQSYNhaQZxGVXKJZyujWxOtXiANpRCpz9mpYg5WC3LRkKhmu2PVGlE6ROoo" +
       "t125g0SXlsbALGtomWW3dXFsdllr3OR76x4+HkKTdXddmUqNvk/GC8JYr+Xq" +
       "AmoNtv5AZ5L6Bo0NFMraI6qnuzoxDtuyEyLtEdyPmWAQic2F2dn0BrV5uDZw" +
       "LaDkwZqb8DpwrAqm2fO0PiZGkFaZrfBxHS73jQrFIQYFb2YiMlN1M5aWVlvT" +
       "G9qkw1l+h7LiCCVns6yzYaeCPlk0ek2SS7n6QMpclVk1a/NWm7JaaySCRLMr" +
       "9BiXGOtaWTbaHovAgwo2XsTbgSqbbc7ordSQmXJddzyaNXSCZUBczG8pTDWq" +
       "AeFVN+tNu2LA40ovDaeEvqgLKGTJmD/OBCiCjArJ4bNMRDuSqbX7C8NO244j" +
       "0TNfbm37Lq3Wu5kSKp2ZSlY6TCVVF42wE8g92xvjNajMQ3i2lNvq1mnDTNVt" +
       "2BtcWHn9MSc7xFJbW5ay9SgVzdZRu11NFAiqrNur7oDn1m7HXICQoN2vQRTS" +
       "6y/KiEQuLVGpqcvlRgmAv4+jEY5JdX44J8ssRZY7LTVk29KizC/rorA1M6dv" +
       "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" +
       "x55/MyzdGbreMyAoUawTE+ZXG95z7T3S");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("aXH9a3+U+LWP//eH5z+if/g67pe84xSdp4f8O9Mv/gb2LumvnCvdcnyw+JqL" +
       "aVd2evbK48QLvhJGvjO/4lDxkSs3/isgpTv+p6c3/vcrfOau/xmnyl89o+6f" +
       "5NlXwtLbjOOzM8SycGOrHJ+qBUXHv35CvP5GWLp16xryXu7+wfUcVBcFXz5m" +
       "wV15YRmkj+1Y8LHrYUFYut3zja0YKq/Lh39xRt2/yrOvhaWH9ny4kgl5/a/v" +
       "AX/9BgDflxc+CtKLO8AvXu+av/91sf7uGXX/Mc9eCUt3aUqIu5JoETtxRfb4" +
       "/s0N4MuvLJUeB+mzO3yfvfn4/tsZdX+QZ98AMgrwLY9s1uNXsVlXnrnuwf/n" +
       "mwH+l3bgf+nmg/+fZ9R9J8++dQiez5//aI/rT24U15MgfWGH6ws3H9f3r113" +
       "UAzx52HpDoBrcXQKfALbd28UW+74fm2H7dduOraDN51Rl5+5HZwHThBgGx4f" +
       "J+/BHdx+A+ByQ1NcVfnKDtxXbj64B8+o+6E8uy8s3QPAHfnI/JT5SDGfuIpi" +
       "7iKJo+Z7Rtx/o4xogPTyjhEv33xGPHlG3Q/n2WNh6UHAiCPLc5IhefXb9lAf" +
       "vwGoRbPHQPrNHdTfvPlQq2fU1fLs6bB0EUDtMczA8IOwpxu7zwLyi3QnF51w" +
       "5RNL/MyN4n4HSK/scL9y83F/4Iy6PBw/eO+hrAPc+ZF/ATsvbuwhPnsDEO/P" +
       "C/MLNa/uIL568yFOzqib5tkgLD1gBENDlhVn4Ls2o+Q3Yl3/qqHi7SvXtRTR" +
       "2ePHbgB/cSW0CdLv7/D//s3Bf7Bv8JcKoMIZTPhQnoGXsouBEh5fncmv2+SN" +
       "91HiAXcDQN+ZF74XpG/tgH7reoG+7pvBgXpGXe5gD8SdubrGDbvVHurqRmU6" +
       "v+b7nR3U79x8qP4ZdYXptYGkOkqcG6NT6urcALQ8Eix1QPreDtr3bj60j5xR" +
       "99E8S8F7DVjF05dGjy+CLvdYs+u6cQws3anPSPIL8Q+95hO1w8+qpF956Z47" +
       "HnyJ/XfFlxTHnz7diZfuUCPLOnkH98Tzec9XVKNgwp2HN3K9AtknAKhrXWoL" +
       "S7eAPKf34KcPW/9MWHrL1VqDliA/2fLndt7pZMuwdFvx/2S7T4elC/t2Yen8" +
       "4cPJJj8PRgdN8scXvCPX1zrrJh5Lj44/IsF80dMNKTjaVjncfnnopJwVke99" +
       "r7dkx11OfreR76YUXxwe7XxEh98cPid96aUx8RPfbn7+8LsRyRKzLB/lDrx0" +
       "++EnLMWg+e7J49cc7Wis88Onvnv3r9755NFOz92HBO9l/gRt77j6Fxp92wuL" +
       "byqyrzz49973t176veJO3v8DsIN5oAo6AAA=");
}
