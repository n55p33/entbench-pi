package org.apache.batik.bridge;
public class SVGFeDiffuseLightingElementBridge extends org.apache.batik.bridge.AbstractSVGLightingElementBridge {
    public SVGFeDiffuseLightingElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_FE_DIFFUSE_LIGHTING_TAG;
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
        float diffuseConstant =
          convertNumber(
            filterElement,
            SVG_DIFFUSE_CONSTANT_ATTRIBUTE,
            1,
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
          new org.apache.batik.ext.awt.image.renderable.DiffuseLightingRable8Bit(
          in,
          primitiveRegion,
          light,
          diffuseConstant,
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
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "+yn+ypqn/wXY1hVZVRgAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "F9+so/cq3vy2XQ9lxaMHB4T55+zJu4CjB4SHp0ZQ9jZ737Wua/I32U8//cxz" +
       "2vAzpZ2907ZJBN0Uef7P2vpKt4+w2gGcHr/2WzuV31YdngJ9+el/uZd/q/nO" +
       "V3G2/cAJOU+y/B3q+a/ib1A/ugOdPjgTuuIe7figJ46fBJ0P9CgOXP7YedB9" +
       "B5a9I7PY/eAp7lm2ePXz5atGwak8Cra+v85hZnidvjgr3Ai6ZaZHpKfKNr0n" +
       "eu8wXLxXOig4yjRvWFypH7anH/Z/o9+5nODc/iHWo9e6c9lerOxd1u5T35lR" +
       "ryvqruY5u3s3MFnX0/sED13BbraKdvFA9k1LDWlP0/cpi1dQZmEqr6Ndy5HB" +
       "/IHuanqQHW7vYpYd6cH+wNflh2AZ4UwHUrC6CqJnZuvlzrHDoONBz8rrfCVd" +
       "Vv9w9J1vfCp94fntWY8ih3oEFa51h37lNX527fLoda6ODm9Xf4S/6cXv/aPw" +
       "9v21evOBax/IPPkweMg915InXbuv662HJ9aUnPd9OOf17usE5kezIgWBqQa6" +
       "HOlb42Vt7zsMzHe9msBMgFtf8QYuu06454o/BGwvsdXPP3fhxrufG/91fgl1" +
       "cNF8EwndaMS2ffT090j9rB/ohpWrdNP2LNjPvz4RQXdfI2gj6Oy2kuvw7Jb+" +
       "kxF08SR9BJ3Jv4/S/XoEnT+kA6y2laMkvxFBpwFJVv1Nf99HzWutoJYSRoGs" +
       "RsB2VzVZcuo4+B94545X8s6R/eKRY7GY/3FjH5FjZi/kX3iuT7/rpfpntndp" +
       "qi2nacblRhI6t73WO0D1h67JbZ/X2d5jL9/2hZse3Y/q27YCH2LREdkeuPrF" +
       "Vdfxo/yqKf2Du3/vzb/13Lfy0+v/AZkQGA1RIwAA");
}
