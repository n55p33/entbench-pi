package org.apache.batik.dom.svg;
public class SVGZoomAndPanSupport implements org.apache.batik.util.SVGConstants {
    protected SVGZoomAndPanSupport() { super(); }
    public static void setZoomAndPan(org.w3c.dom.Element elt, short val) throws org.w3c.dom.DOMException {
        switch (val) {
            case org.w3c.dom.svg.SVGZoomAndPan.
                   SVG_ZOOMANDPAN_DISABLE:
                elt.
                  setAttributeNS(
                    null,
                    SVG_ZOOM_AND_PAN_ATTRIBUTE,
                    SVG_DISABLE_VALUE);
                break;
            case org.w3c.dom.svg.SVGZoomAndPan.
                   SVG_ZOOMANDPAN_MAGNIFY:
                elt.
                  setAttributeNS(
                    null,
                    SVG_ZOOM_AND_PAN_ATTRIBUTE,
                    SVG_MAGNIFY_VALUE);
                break;
            default:
                throw ((org.apache.batik.dom.AbstractNode)
                         elt).
                  createDOMException(
                    org.w3c.dom.DOMException.
                      INVALID_MODIFICATION_ERR,
                    "zoom.and.pan",
                    new java.lang.Object[] { new java.lang.Integer(
                      val) });
        }
    }
    public static short getZoomAndPan(org.w3c.dom.Element elt) { java.lang.String s =
                                                                   elt.
                                                                   getAttributeNS(
                                                                     null,
                                                                     SVG_ZOOM_AND_PAN_ATTRIBUTE);
                                                                 if (s.
                                                                       equals(
                                                                         SVG_MAGNIFY_VALUE)) {
                                                                     return org.w3c.dom.svg.SVGZoomAndPan.
                                                                              SVG_ZOOMANDPAN_MAGNIFY;
                                                                 }
                                                                 return org.w3c.dom.svg.SVGZoomAndPan.
                                                                          SVG_ZOOMANDPAN_DISABLE;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "vHjF4YX/AO97BlDOFgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "zN1Zx/aheVfz4Mn90NGj2/OSc2DBni/v1/eLGf9P5lIezturWfNj2zCFoMCN" +
       "ZMsEy+RCkNeegEs3HcnKlT8ZgjSzlKuHGsagFgVxubqw6rmo14HqO0+pzAP7" +
       "2wJui2tZW85FbNOiesMU+vEtVf4Au2MnjHFBLfi+f/zgVz7wxm+AuNLQ+Tjz" +
       "OQjnMY1slJXHv/jCc/e/5tlvvi8HK4BU459/+b4nM6m9G1id3bazhsga8tDU" +
       "+zJTh/lzn5GCsJeDi6bm1r5iOvO+aQMYjg9qP/jpu76x/Oi3PrWt607n7ili" +
       "7Zlnf/kH++9/du9YNf3G6wra4zzbijqf9O0HHvahh19JS85B/NNnnv6j33n6" +
       "vdtZ3XWyNmyDV59P/dV/fWX/w9/80hnlyM2W+78IbHjb9zuVgMIOP0xpppXX" +
       "oySxda5eYJH6WunMpZ47Y7DpxGhOykMpWczKNp0mzQG36swRJ1KLVaTQRZHJ" +
       "GEkXlbrXtweUt1l5szlGjaetaXFQ7WK2K4WDiTzsrobtsunRk6G7Ej1i3PWs" +
       "kauv2uS4uEBdG6nrKVsPkbAiDohpyaMR2YYd2y7ASSGppkypsmBnVTbyFjiF" +
       "pORsWV0WOTyRFmGvoza9SmHTiiRhI+JTtNAgfa0uEcNJuRmSQ7dXo/vGuuQJ" +
       "hKbihO2R/ZpjBF2Fn228qMlGvYoujqoD3/PaczMdOxwZe/aKSdpj1hoyTb28" +
       "6AyFhY2E4yEXlMkpNlT82Qanx+35sN4PIrQhUssyLfWSatWroI01ozUtwokZ" +
       "ShPCcG5wy8mCk+peUVzYDbbWELRaUeiU7P5CrRrcuFqlm4WSMMXr4WLSM9ji" +
       "tJyi1Z5EC3SwXo/oFdmcTWsg3+0JvxoVN+xyLMaqhTsTTVkXhJVnem2Ct2lO" +
       "s7tEv8auJbzPMZOFP5p1iqmSUmJf7bn9Sqx0VyUCH1LLdGIJzWRVrKUMbVaX" +
       "+LxeQtixKmNiOE60kjVeTVbTRS2NQLjWhbIuFbphU6RWZZAPwrzb7HWMJdaf" +
       "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" +
       "3/rbz3893zT9H51/Aa6rIQAA");
}
