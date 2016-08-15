package org.apache.batik.bridge;
public class SVGFeMorphologyElementBridge extends org.apache.batik.bridge.AbstractSVGFilterPrimitiveElementBridge {
    public SVGFeMorphologyElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_FE_MORPHOLOGY_TAG;
    }
    public org.apache.batik.ext.awt.image.renderable.Filter createFilter(org.apache.batik.bridge.BridgeContext ctx,
                                                                         org.w3c.dom.Element filterElement,
                                                                         org.w3c.dom.Element filteredElement,
                                                                         org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                         org.apache.batik.ext.awt.image.renderable.Filter inputFilter,
                                                                         java.awt.geom.Rectangle2D filterRegion,
                                                                         java.util.Map filterMap) {
        float[] radii =
          convertRadius(
            filterElement,
            ctx);
        if (radii[0] ==
              0 ||
              radii[1] ==
              0) {
            return null;
        }
        boolean isDilate =
          convertOperator(
            filterElement,
            ctx);
        org.apache.batik.ext.awt.image.renderable.Filter in =
          getIn(
            filterElement,
            filteredElement,
            filteredNode,
            inputFilter,
            filterMap,
            ctx);
        if (in ==
              null) {
            return null;
        }
        java.awt.geom.Rectangle2D defaultRegion =
          in.
          getBounds2D(
            );
        java.awt.geom.Rectangle2D primitiveRegion =
          org.apache.batik.bridge.SVGUtilities.
          convertFilterPrimitiveRegion(
            filterElement,
            filteredElement,
            filteredNode,
            defaultRegion,
            filterRegion,
            ctx);
        org.apache.batik.ext.awt.image.renderable.PadRable pad =
          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
          in,
          primitiveRegion,
          org.apache.batik.ext.awt.image.PadMode.
            ZERO_PAD);
        org.apache.batik.ext.awt.image.renderable.Filter morphology =
          new org.apache.batik.ext.awt.image.renderable.MorphologyRable8Bit(
          pad,
          radii[0],
          radii[1],
          isDilate);
        handleColorInterpolationFilters(
          morphology,
          filterElement);
        org.apache.batik.ext.awt.image.renderable.PadRable filter =
          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
          morphology,
          primitiveRegion,
          org.apache.batik.ext.awt.image.PadMode.
            ZERO_PAD);
        updateFilterMap(
          filterElement,
          filter,
          filterMap);
        return filter;
    }
    protected static float[] convertRadius(org.w3c.dom.Element filterElement,
                                           org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            SVG_RADIUS_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            return new float[] { 0,
            0 };
        }
        float[] radii =
          new float[2];
        java.util.StringTokenizer tokens =
          new java.util.StringTokenizer(
          s,
          " ,");
        try {
            radii[0] =
              org.apache.batik.bridge.SVGUtilities.
                convertSVGNumber(
                  tokens.
                    nextToken(
                      ));
            if (tokens.
                  hasMoreTokens(
                    )) {
                radii[1] =
                  org.apache.batik.bridge.SVGUtilities.
                    convertSVGNumber(
                      tokens.
                        nextToken(
                          ));
            }
            else {
                radii[1] =
                  radii[0];
            }
        }
        catch (java.lang.NumberFormatException nfEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              filterElement,
              nfEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_RADIUS_ATTRIBUTE,
              s,
              nfEx });
        }
        if (tokens.
              hasMoreTokens(
                ) ||
              radii[0] <
              0 ||
              radii[1] <
              0) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              filterElement,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_RADIUS_ATTRIBUTE,
              s });
        }
        return radii;
    }
    protected static boolean convertOperator(org.w3c.dom.Element filterElement,
                                             org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            SVG_OPERATOR_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            return false;
        }
        if (SVG_ERODE_VALUE.
              equals(
                s)) {
            return false;
        }
        if (SVG_DILATE_VALUE.
              equals(
                s)) {
            return true;
        }
        throw new org.apache.batik.bridge.BridgeException(
          ctx,
          filterElement,
          ERR_ATTRIBUTE_VALUE_MALFORMED,
          new java.lang.Object[] { SVG_OPERATOR_ATTRIBUTE,
          s });
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "SYO7987cEILtZ/wVm8//DVe3V4/AIAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "cuNnL4Ty8qbmSfYZ88fL+xuvDbmPfafz");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("K4e7NJqt5HnB5QEYdQ/Xek4z2KfvyO2E1zX6A9995NcffP5kBX/kIPAZ+s/J" +
       "9tTtL670HT8qr5rkv/mef/Cjf/u1r5en1/8HHeuERkIrAAA=");
}
