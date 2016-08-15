package org.apache.batik.bridge;
public class SVGFeDisplacementMapElementBridge extends org.apache.batik.bridge.AbstractSVGFilterPrimitiveElementBridge {
    public SVGFeDisplacementMapElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_FE_DISPLACEMENT_MAP_TAG;
    }
    public org.apache.batik.ext.awt.image.renderable.Filter createFilter(org.apache.batik.bridge.BridgeContext ctx,
                                                                         org.w3c.dom.Element filterElement,
                                                                         org.w3c.dom.Element filteredElement,
                                                                         org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                         org.apache.batik.ext.awt.image.renderable.Filter inputFilter,
                                                                         java.awt.geom.Rectangle2D filterRegion,
                                                                         java.util.Map filterMap) {
        float scale =
          convertNumber(
            filterElement,
            SVG_SCALE_ATTRIBUTE,
            0,
            ctx);
        org.apache.batik.ext.awt.image.ARGBChannel xChannelSelector =
          convertChannelSelector(
            filterElement,
            SVG_X_CHANNEL_SELECTOR_ATTRIBUTE,
            org.apache.batik.ext.awt.image.ARGBChannel.
              A,
            ctx);
        org.apache.batik.ext.awt.image.ARGBChannel yChannelSelector =
          convertChannelSelector(
            filterElement,
            SVG_Y_CHANNEL_SELECTOR_ATTRIBUTE,
            org.apache.batik.ext.awt.image.ARGBChannel.
              A,
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
        org.apache.batik.ext.awt.image.renderable.Filter in2 =
          getIn2(
            filterElement,
            filteredElement,
            filteredNode,
            inputFilter,
            filterMap,
            ctx);
        if (in2 ==
              null) {
            return null;
        }
        java.awt.geom.Rectangle2D defaultRegion;
        defaultRegion =
          (java.awt.geom.Rectangle2D)
            in.
            getBounds2D(
              ).
            clone(
              );
        defaultRegion.
          add(
            in2.
              getBounds2D(
                ));
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
        java.util.List srcs =
          new java.util.ArrayList(
          2);
        srcs.
          add(
            pad);
        srcs.
          add(
            in2);
        org.apache.batik.ext.awt.image.renderable.Filter displacementMap =
          new org.apache.batik.ext.awt.image.renderable.DisplacementMapRable8Bit(
          srcs,
          scale,
          xChannelSelector,
          yChannelSelector);
        handleColorInterpolationFilters(
          displacementMap,
          filterElement);
        org.apache.batik.ext.awt.image.renderable.PadRable filter =
          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
          displacementMap,
          primitiveRegion,
          org.apache.batik.ext.awt.image.PadMode.
            ZERO_PAD);
        updateFilterMap(
          filterElement,
          filter,
          filterMap);
        return filter;
    }
    protected static org.apache.batik.ext.awt.image.ARGBChannel convertChannelSelector(org.w3c.dom.Element filterElement,
                                                                                       java.lang.String attrName,
                                                                                       org.apache.batik.ext.awt.image.ARGBChannel defaultChannel,
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
            return defaultChannel;
        }
        if (SVG_A_VALUE.
              equals(
                s)) {
            return org.apache.batik.ext.awt.image.ARGBChannel.
                     A;
        }
        if (SVG_R_VALUE.
              equals(
                s)) {
            return org.apache.batik.ext.awt.image.ARGBChannel.
                     R;
        }
        if (SVG_G_VALUE.
              equals(
                s)) {
            return org.apache.batik.ext.awt.image.ARGBChannel.
                     G;
        }
        if (SVG_B_VALUE.
              equals(
                s)) {
            return org.apache.batik.ext.awt.image.ARGBChannel.
                     B;
        }
        throw new org.apache.batik.bridge.BridgeException(
          ctx,
          filterElement,
          ERR_ATTRIBUTE_VALUE_MALFORMED,
          new java.lang.Object[] { attrName,
          s });
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "//Du33/Tp577Vn4p8b8eUn+HKCUAAA==");
}
