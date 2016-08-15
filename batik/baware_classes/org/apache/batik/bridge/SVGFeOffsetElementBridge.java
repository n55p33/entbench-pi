package org.apache.batik.bridge;
public class SVGFeOffsetElementBridge extends org.apache.batik.bridge.AbstractSVGFilterPrimitiveElementBridge {
    public SVGFeOffsetElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_FE_OFFSET_TAG; }
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
        float dx =
          convertNumber(
            filterElement,
            SVG_DX_ATTRIBUTE,
            0,
            ctx);
        float dy =
          convertNumber(
            filterElement,
            SVG_DY_ATTRIBUTE,
            0,
            ctx);
        java.awt.geom.AffineTransform at =
          java.awt.geom.AffineTransform.
          getTranslateInstance(
            dx,
            dy);
        org.apache.batik.ext.awt.image.renderable.PadRable pad =
          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
          in,
          primitiveRegion,
          org.apache.batik.ext.awt.image.PadMode.
            ZERO_PAD);
        org.apache.batik.ext.awt.image.renderable.Filter filter =
          new org.apache.batik.ext.awt.image.renderable.AffineRable8Bit(
          pad,
          at);
        filter =
          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
            filter,
            primitiveRegion,
            org.apache.batik.ext.awt.image.PadMode.
              ZERO_PAD);
        handleColorInterpolationFilters(
          filter,
          filterElement);
        updateFilterMap(
          filterElement,
          filter,
          filterMap);
        return filter;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "/sqa5/4F8I8AFTgYAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "XmRK/+Du33vzbz33rfze+n8Axd71WTAjAAA=");
}
