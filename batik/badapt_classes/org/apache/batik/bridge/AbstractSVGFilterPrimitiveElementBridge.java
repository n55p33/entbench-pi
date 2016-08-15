package org.apache.batik.bridge;
public abstract class AbstractSVGFilterPrimitiveElementBridge extends org.apache.batik.bridge.AnimatableGenericSVGBridge implements org.apache.batik.bridge.FilterPrimitiveBridge, org.apache.batik.bridge.ErrorConstants {
    protected AbstractSVGFilterPrimitiveElementBridge() { super(); }
    protected static org.apache.batik.ext.awt.image.renderable.Filter getIn(org.w3c.dom.Element filterElement,
                                                                            org.w3c.dom.Element filteredElement,
                                                                            org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                            org.apache.batik.ext.awt.image.renderable.Filter inputFilter,
                                                                            java.util.Map filterMap,
                                                                            org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            SVG_IN_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            return inputFilter;
        }
        else {
            return getFilterSource(
                     filterElement,
                     s,
                     filteredElement,
                     filteredNode,
                     filterMap,
                     ctx);
        }
    }
    protected static org.apache.batik.ext.awt.image.renderable.Filter getIn2(org.w3c.dom.Element filterElement,
                                                                             org.w3c.dom.Element filteredElement,
                                                                             org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                             org.apache.batik.ext.awt.image.renderable.Filter inputFilter,
                                                                             java.util.Map filterMap,
                                                                             org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            SVG_IN2_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              filterElement,
              ERR_ATTRIBUTE_MISSING,
              new java.lang.Object[] { SVG_IN2_ATTRIBUTE });
        }
        return getFilterSource(
                 filterElement,
                 s,
                 filteredElement,
                 filteredNode,
                 filterMap,
                 ctx);
    }
    protected static void updateFilterMap(org.w3c.dom.Element filterElement,
                                          org.apache.batik.ext.awt.image.renderable.Filter filter,
                                          java.util.Map filterMap) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            SVG_RESULT_ATTRIBUTE);
        if (s.
              length(
                ) !=
              0 &&
              s.
              trim(
                ).
              length(
                ) !=
              0) {
            filterMap.
              put(
                s,
                filter);
        }
    }
    protected static void handleColorInterpolationFilters(org.apache.batik.ext.awt.image.renderable.Filter filter,
                                                          org.w3c.dom.Element filterElement) {
        if (filter instanceof org.apache.batik.ext.awt.image.renderable.FilterColorInterpolation) {
            boolean isLinear =
              org.apache.batik.bridge.CSSUtilities.
              convertColorInterpolationFilters(
                filterElement);
            ((org.apache.batik.ext.awt.image.renderable.FilterColorInterpolation)
               filter).
              setColorSpaceLinear(
                isLinear);
        }
    }
    static org.apache.batik.ext.awt.image.renderable.Filter getFilterSource(org.w3c.dom.Element filterElement,
                                                                            java.lang.String s,
                                                                            org.w3c.dom.Element filteredElement,
                                                                            org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                            java.util.Map filterMap,
                                                                            org.apache.batik.bridge.BridgeContext ctx) {
        org.apache.batik.ext.awt.image.renderable.Filter srcG =
          (org.apache.batik.ext.awt.image.renderable.Filter)
            filterMap.
            get(
              SVG_SOURCE_GRAPHIC_VALUE);
        java.awt.geom.Rectangle2D filterRegion =
          srcG.
          getBounds2D(
            );
        int length =
          s.
          length(
            );
        org.apache.batik.ext.awt.image.renderable.Filter source =
          null;
        switch (length) {
            case 13:
                if (SVG_SOURCE_GRAPHIC_VALUE.
                      equals(
                        s)) {
                    source =
                      srcG;
                }
                break;
            case 11:
                if (s.
                      charAt(
                        1) ==
                      SVG_SOURCE_ALPHA_VALUE.
                      charAt(
                        1)) {
                    if (SVG_SOURCE_ALPHA_VALUE.
                          equals(
                            s)) {
                        source =
                          srcG;
                        source =
                          new org.apache.batik.ext.awt.image.renderable.FilterAlphaRable(
                            source);
                    }
                }
                else
                    if (SVG_STROKE_PAINT_VALUE.
                          equals(
                            s)) {
                        java.awt.Paint paint =
                          org.apache.batik.bridge.PaintServer.
                          convertStrokePaint(
                            filteredElement,
                            filteredNode,
                            ctx);
                        source =
                          new org.apache.batik.ext.awt.image.renderable.FloodRable8Bit(
                            filterRegion,
                            paint);
                    }
                break;
            case 15:
                if (s.
                      charAt(
                        10) ==
                      SVG_BACKGROUND_IMAGE_VALUE.
                      charAt(
                        10)) {
                    if (SVG_BACKGROUND_IMAGE_VALUE.
                          equals(
                            s)) {
                        source =
                          new org.apache.batik.gvt.filter.BackgroundRable8Bit(
                            filteredNode);
                        source =
                          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
                            source,
                            filterRegion,
                            org.apache.batik.ext.awt.image.PadMode.
                              ZERO_PAD);
                    }
                }
                else
                    if (SVG_BACKGROUND_ALPHA_VALUE.
                          equals(
                            s)) {
                        source =
                          new org.apache.batik.gvt.filter.BackgroundRable8Bit(
                            filteredNode);
                        source =
                          new org.apache.batik.ext.awt.image.renderable.FilterAlphaRable(
                            source);
                        source =
                          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
                            source,
                            filterRegion,
                            org.apache.batik.ext.awt.image.PadMode.
                              ZERO_PAD);
                    }
                break;
            case 9:
                if (SVG_FILL_PAINT_VALUE.
                      equals(
                        s)) {
                    java.awt.Paint paint =
                      org.apache.batik.bridge.PaintServer.
                      convertFillPaint(
                        filteredElement,
                        filteredNode,
                        ctx);
                    if (paint ==
                          null) {
                        paint =
                          new java.awt.Color(
                            0,
                            0,
                            0,
                            0);
                    }
                    source =
                      new org.apache.batik.ext.awt.image.renderable.FloodRable8Bit(
                        filterRegion,
                        paint);
                }
                break;
        }
        if (source ==
              null) {
            source =
              (org.apache.batik.ext.awt.image.renderable.Filter)
                filterMap.
                get(
                  s);
        }
        return source;
    }
    static final java.awt.geom.Rectangle2D
      INFINITE_FILTER_REGION =
      new java.awt.geom.Rectangle2D.Float(
      -java.lang.Float.
         MAX_VALUE /
        2,
      -java.lang.Float.
         MAX_VALUE /
        2,
      java.lang.Float.
        MAX_VALUE,
      java.lang.Float.
        MAX_VALUE);
    protected static int convertInteger(org.w3c.dom.Element filterElement,
                                        java.lang.String attrName,
                                        int defaultValue,
                                        org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            attrName);
        if (s.
              length(
                ) ==
              0) {
            return defaultValue;
        }
        else {
            try {
                return org.apache.batik.bridge.SVGUtilities.
                  convertSVGInteger(
                    s);
            }
            catch (java.lang.NumberFormatException nfEx) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  filterElement,
                  nfEx,
                  ERR_ATTRIBUTE_VALUE_MALFORMED,
                  new java.lang.Object[] { attrName,
                  s });
            }
        }
    }
    protected static float convertNumber(org.w3c.dom.Element filterElement,
                                         java.lang.String attrName,
                                         float defaultValue,
                                         org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            attrName);
        if (s.
              length(
                ) ==
              0) {
            return defaultValue;
        }
        else {
            try {
                return org.apache.batik.bridge.SVGUtilities.
                  convertSVGNumber(
                    s);
            }
            catch (java.lang.NumberFormatException nfEx) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  filterElement,
                  nfEx,
                  ERR_ATTRIBUTE_VALUE_MALFORMED,
                  new java.lang.Object[] { attrName,
                  s,
                  nfEx });
            }
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "ASMAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "XbrtSWf08d9vo49vFMV/icsrA4U+9oe8");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("ReWfHdTxp69EHXkMvfNlXggrrra88YYbq/tblsovPX/5njc8P/+j8k7U6U3I" +
       "eynoHj2x7bM3Ec68X/JDTbdKye7d30vwy6//GUNvuMWSD9Yi+ZBEv7Sn/1YM" +
       "XTlPDxRbfp+l++sYuu9AB4bav5wl+Q5wT0BSvP6Nf5J/1G95lc4F6VlcpGXl" +
       "TQZLASrcKyu/cCbvPva60joPfTfrnHY5e6mqSL7KO8UneXUyPc7xvvD8iHn6" +
       "pfbP7i91Kba02xWj3ENBd+/vl53m5o/dcrSTsS4N3vWdB7547xMnadwDe4YP" +
       "EXCGt7fe/PoU4fhxeeFp96tv+Oc/9HPP/0l58+D/AiCdJyvsLQAA");
}
