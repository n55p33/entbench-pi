package org.apache.batik.extension.svg;
public class BatikHistogramNormalizationElementBridge extends org.apache.batik.bridge.AbstractSVGFilterPrimitiveElementBridge implements org.apache.batik.extension.svg.BatikExtConstants {
    public BatikHistogramNormalizationElementBridge() { super(); }
    public java.lang.String getNamespaceURI() { return BATIK_EXT_NAMESPACE_URI;
    }
    public java.lang.String getLocalName() { return BATIK_EXT_HISTOGRAM_NORMALIZATION_TAG;
    }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.extension.svg.BatikHistogramNormalizationElementBridge(
                                                            );
    }
    public org.apache.batik.ext.awt.image.renderable.Filter createFilter(org.apache.batik.bridge.BridgeContext ctx,
                                                                         org.w3c.dom.Element filterElement,
                                                                         org.w3c.dom.Element filteredElement,
                                                                         org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                         org.apache.batik.ext.awt.image.renderable.Filter inputFilter,
                                                                         java.awt.geom.Rectangle2D filterRegion,
                                                                         java.util.Map filterMap) {
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
        org.apache.batik.ext.awt.image.renderable.Filter sourceGraphics =
          (org.apache.batik.ext.awt.image.renderable.Filter)
            filterMap.
            get(
              SVG_SOURCE_GRAPHIC_VALUE);
        java.awt.geom.Rectangle2D defaultRegion;
        if (in ==
              sourceGraphics) {
            defaultRegion =
              filterRegion;
        }
        else {
            defaultRegion =
              in.
                getBounds2D(
                  );
        }
        java.awt.geom.Rectangle2D primitiveRegion =
          org.apache.batik.bridge.SVGUtilities.
          convertFilterPrimitiveRegion(
            filterElement,
            filteredElement,
            filteredNode,
            defaultRegion,
            filterRegion,
            ctx);
        float trim =
          1;
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            BATIK_EXT_TRIM_ATTRIBUTE);
        if (s.
              length(
                ) !=
              0) {
            try {
                trim =
                  org.apache.batik.bridge.SVGUtilities.
                    convertSVGNumber(
                      s);
            }
            catch (java.lang.NumberFormatException nfEx) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  filterElement,
                  nfEx,
                  ERR_ATTRIBUTE_VALUE_MALFORMED,
                  new java.lang.Object[] { BATIK_EXT_TRIM_ATTRIBUTE,
                  s });
            }
        }
        if (trim <
              0)
            trim =
              0;
        else
            if (trim >
                  100)
                trim =
                  100;
        org.apache.batik.ext.awt.image.renderable.Filter filter =
          in;
        filter =
          new org.apache.batik.extension.svg.BatikHistogramNormalizationFilter8Bit(
            filter,
            trim /
              100);
        filter =
          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
            filter,
            primitiveRegion,
            org.apache.batik.ext.awt.image.PadMode.
              ZERO_PAD);
        updateFilterMap(
          filterElement,
          filter,
          filterMap);
        handleColorInterpolationFilters(
          filter,
          filterElement);
        return filter;
    }
    protected static int convertSides(org.w3c.dom.Element filterElement,
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
            int ret =
              0;
            try {
                ret =
                  org.apache.batik.bridge.SVGUtilities.
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
            if (ret <
                  3)
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  filterElement,
                  ERR_ATTRIBUTE_VALUE_MALFORMED,
                  new java.lang.Object[] { attrName,
                  s });
            return ret;
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Y+kT2RX2Soc//BsjzeqEox0AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "H39xv2G7kiMthiq3+2Tm5q92irPTp+9w/nvyMcW/9r7+pX/4G+FtR3h8/3Fo" +
       "Hy8i+RS4bhyG9sb50B7Z+oqTY6eRXI79dCnrR++QuR8rmg+AlamEmhxre+cV" +
       "fT92kpg//CUk5uuKzqfB9dFD7T/6MhLzIngo+aEXg6BpatFN3jJJ7y6J7y5T" +
       "6wRU+JJ0r88ihu4y9sn3oVLEr9zBJb9RND8fl98EpVoY88ZhHv7qiUt+4eW4" +
       "JIuhr/liPzAoTktfe9OXUfuveZSPvXD13te8MP/T8oz9+Iub+xjo3nVi26cP" +
       "t07dX/JDbW2Ult23P+ryy5/fuRU0nakrgNNAW5rz23ueT8TQI7fnAdE6vj/N" +
       "9ckYunaeK4buKX9P0/1hDF05oYuhS/ub0ySfAjoBkuL2j/yjvH/L7VAJX0Vx" +
       "KCsxL/T2iX18ZHPG59mFUwXPYQaXUX74C0X5mOX0WX+xzMtP4I4KmoQ9RJOP" +
       "vzAYf8vnsB/ff2ug2HKeF1LuZaDL+88ejouiJ28r7UjWpf4zn3/wZ+97+ggw" +
       "HtwrfLKaTun2+K0P9knHj8uj+PyXX/MLb/qJF/6qPN37Pxg+liCbKAAA");
}
