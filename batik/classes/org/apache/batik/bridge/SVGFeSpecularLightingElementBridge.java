package org.apache.batik.bridge;
public class SVGFeSpecularLightingElementBridge extends org.apache.batik.bridge.AbstractSVGLightingElementBridge {
    public SVGFeSpecularLightingElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_FE_SPECULAR_LIGHTING_TAG;
    }
    public org.apache.batik.ext.awt.image.renderable.Filter createFilter(org.apache.batik.bridge.BridgeContext ctx,
                                                                         org.w3c.dom.Element filterElement,
                                                                         org.w3c.dom.Element filteredElement,
                                                                         org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                         org.apache.batik.ext.awt.image.renderable.Filter inputFilter,
                                                                         java.awt.geom.Rectangle2D filterRegion,
                                                                         java.util.Map filterMap) {
        float surfaceScale =
          convertNumber(
            filterElement,
            SVG_SURFACE_SCALE_ATTRIBUTE,
            1,
            ctx);
        float specularConstant =
          convertNumber(
            filterElement,
            SVG_SPECULAR_CONSTANT_ATTRIBUTE,
            1,
            ctx);
        float specularExponent =
          convertSpecularExponent(
            filterElement,
            ctx);
        org.apache.batik.ext.awt.image.Light light =
          extractLight(
            filterElement,
            ctx);
        double[] kernelUnitLength =
          convertKernelUnitLength(
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
        org.apache.batik.ext.awt.image.renderable.Filter filter =
          new org.apache.batik.ext.awt.image.renderable.SpecularLightingRable8Bit(
          in,
          primitiveRegion,
          light,
          specularConstant,
          specularExponent,
          surfaceScale,
          kernelUnitLength);
        handleColorInterpolationFilters(
          filter,
          filterElement);
        updateFilterMap(
          filterElement,
          filter,
          filterMap);
        return filter;
    }
    protected static float convertSpecularExponent(org.w3c.dom.Element filterElement,
                                                   org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            SVG_SPECULAR_EXPONENT_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            return 1;
        }
        else {
            try {
                float v =
                  org.apache.batik.bridge.SVGUtilities.
                  convertSVGNumber(
                    s);
                if (v <
                      1 ||
                      v >
                      128) {
                    throw new org.apache.batik.bridge.BridgeException(
                      ctx,
                      filterElement,
                      ERR_ATTRIBUTE_VALUE_MALFORMED,
                      new java.lang.Object[] { SVG_SPECULAR_CONSTANT_ATTRIBUTE,
                      s });
                }
                return v;
            }
            catch (java.lang.NumberFormatException nfEx) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  filterElement,
                  nfEx,
                  ERR_ATTRIBUTE_VALUE_MALFORMED,
                  new java.lang.Object[] { SVG_SPECULAR_CONSTANT_ATTRIBUTE,
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
       "T+s8ug/nZhDWXuavrPn1vwFNDLmAxRoAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "VmclAAA=");
}
