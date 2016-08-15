package org.apache.batik.bridge;
public class SVGFeBlendElementBridge extends org.apache.batik.bridge.AbstractSVGFilterPrimitiveElementBridge {
    public SVGFeBlendElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_FE_BLEND_TAG; }
    public org.apache.batik.ext.awt.image.renderable.Filter createFilter(org.apache.batik.bridge.BridgeContext ctx,
                                                                         org.w3c.dom.Element filterElement,
                                                                         org.w3c.dom.Element filteredElement,
                                                                         org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                         org.apache.batik.ext.awt.image.renderable.Filter inputFilter,
                                                                         java.awt.geom.Rectangle2D filterRegion,
                                                                         java.util.Map filterMap) {
        org.apache.batik.ext.awt.image.CompositeRule rule =
          convertMode(
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
        java.util.List srcs =
          new java.util.ArrayList(
          2);
        srcs.
          add(
            in2);
        srcs.
          add(
            in);
        org.apache.batik.ext.awt.image.renderable.Filter filter =
          new org.apache.batik.ext.awt.image.renderable.CompositeRable8Bit(
          srcs,
          rule,
          true);
        handleColorInterpolationFilters(
          filter,
          filterElement);
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
        return filter;
    }
    protected static org.apache.batik.ext.awt.image.CompositeRule convertMode(org.w3c.dom.Element filterElement,
                                                                              org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String rule =
          filterElement.
          getAttributeNS(
            null,
            SVG_MODE_ATTRIBUTE);
        if (rule.
              length(
                ) ==
              0) {
            return org.apache.batik.ext.awt.image.CompositeRule.
                     OVER;
        }
        if (SVG_NORMAL_VALUE.
              equals(
                rule)) {
            return org.apache.batik.ext.awt.image.CompositeRule.
                     OVER;
        }
        if (SVG_MULTIPLY_VALUE.
              equals(
                rule)) {
            return org.apache.batik.ext.awt.image.CompositeRule.
                     MULTIPLY;
        }
        if (SVG_SCREEN_VALUE.
              equals(
                rule)) {
            return org.apache.batik.ext.awt.image.CompositeRule.
                     SCREEN;
        }
        if (SVG_DARKEN_VALUE.
              equals(
                rule)) {
            return org.apache.batik.ext.awt.image.CompositeRule.
                     DARKEN;
        }
        if (SVG_LIGHTEN_VALUE.
              equals(
                rule)) {
            return org.apache.batik.ext.awt.image.CompositeRule.
                     LIGHTEN;
        }
        throw new org.apache.batik.bridge.BridgeException(
          ctx,
          filterElement,
          ERR_ATTRIBUTE_VALUE_MALFORMED,
          new java.lang.Object[] { SVG_MODE_ATTRIBUTE,
          rule });
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "z4lXbJ7/N9z2E2GaGQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "eNfvv+VTz38rv1P4X+Due+XJJAAA");
}
