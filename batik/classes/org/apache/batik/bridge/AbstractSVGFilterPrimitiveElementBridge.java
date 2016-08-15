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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "ASMAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "dd1OX4UdONdHfB+voRyNouj7319seRivbtfpwXKD7fSoeG0jRQP7KnZb8lvs" +
       "WpYTxtA90vFZ2OHsofxcPjlzPPk+e/Zw2JC+eLLT975bnbWdO2Dbn6yd9HrX" +
       "rXoRYeiFp1cNij2st93qDLrcv/rix557Xp38fO3i8WmBHEP3xp7/PltLNfsM" +
       "v3eDkZ689V4dXR7BH3axf+tj/+MR/gPmR1/F8dzbz/F5fsh/RL/wVfJdyt+7" +
       "CN1xuqd9w+WA6zs9df1O9n2hFiehy1+3n/22U/O9tbDWY+D5wLH5PnDzI7Jb" +
       "u8UPlX64d8FzJzKXSqpLJ/Z7Q2G/rKEcqZ5zdHx2WjR9/ITgsRsMbKTxERlK" +
       "vmkpEeOpp65QvYGysE6x2W05EvCIUHNVLSzOpI5d6rp9zestyUpZ6R7XlN+Y" +
       "feNrn9996YX9tqUsRVoMVW512+XGCzfFcegTtznSPdyD+A75wy/+6X8VPnzi" +
       "gK87tcfjhfqfAA92bA/svD1OVHD/4RiJlsq2T580PXGrQNnH0/F9mHLmn7zN" +
       "IdpzRfGjMXSXocXD8nTz2QOK/Nj32rM9O1pZ8fT1TldI+pFjIT/y/Xe60rFO" +
       "i586cP/JUzbeWcz6LvDIx2zIN2Pj06fF3y1/P38bjX2hKH42hi6VGqufU9k/" +
       "fA0qe2NRWVzxePqY1+33UWV3HFaVj99MUSWkv+/M5E/fWlHl6wu30dGXi+IX" +
       "Yuhy4qtSrO3DE3hwSfzhMwuUFEN3pp6lHhT4i69VgVPwfPJYhr/zfVTgxQPV" +
       "s6UWS6qv3EYL/7wofh2AuSm5anlyXlyrAJoA+FEuGsewVZD96kEDv/EaNPBQ" +
       "UVlA/fPHGnj+VWjgwisPOPYQdef86BTcvnDMwRdeScB99TZq/DdF8a+AM4GA" +
       "22tsf+h2LvJ+8zWo7S1F5bvB891jpr/7fXScO/cH9Qfd3SwK7rD26+ReHX9w" +
       "G3X8p6L4vRh6QPHcVAvjwqOM/Rn8Hx608e9egzZ+sKj8IeAPD+/77r//X2rj" +
       "Lt32pDP6+O+30ce3iuK/xOWVgUIf+0Pe");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("ovJPDur441ejjjyG3v0KL4QVV1vefMON1f0tS+VXnr98z5uen/9BeSfq9Cbk" +
       "vRR0j57Y9tmbCGfeL/mhplulZPfu7yX45df/jKE33WLJB2uRfEiiX9rTfyeG" +
       "rpynB4otv8/S/WUM3XegA0PtX86SvAzcE5AUr3/ln+Qf9VtepXNBehYXaVl5" +
       "k8FSgAr3ysovnMm7j72utM5D38s6p13OXqoqkq/yTvFJXp1Mj3O8Lz0/Yp5+" +
       "qf3z+0tdii3tdsUo91DQ3fv7Zae5+WO3HO1krEuD97z8wJfvfeIkjXtgz/Ah" +
       "As7w9vabX58iHD8uLzztfv1N//hHfuH5PypvHvxfjsGc/OwtAAA=");
}
