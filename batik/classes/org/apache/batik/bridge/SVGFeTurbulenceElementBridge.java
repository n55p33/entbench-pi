package org.apache.batik.bridge;
public class SVGFeTurbulenceElementBridge extends org.apache.batik.bridge.AbstractSVGFilterPrimitiveElementBridge {
    public SVGFeTurbulenceElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_FE_TURBULENCE_TAG;
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
        java.awt.geom.Rectangle2D defaultRegion =
          filterRegion;
        java.awt.geom.Rectangle2D primitiveRegion =
          org.apache.batik.bridge.SVGUtilities.
          convertFilterPrimitiveRegion(
            filterElement,
            filteredElement,
            filteredNode,
            defaultRegion,
            filterRegion,
            ctx);
        float[] baseFrequency =
          convertBaseFrenquency(
            filterElement,
            ctx);
        int numOctaves =
          convertInteger(
            filterElement,
            SVG_NUM_OCTAVES_ATTRIBUTE,
            1,
            ctx);
        int seed =
          convertInteger(
            filterElement,
            SVG_SEED_ATTRIBUTE,
            0,
            ctx);
        boolean stitchTiles =
          convertStitchTiles(
            filterElement,
            ctx);
        boolean isFractalNoise =
          convertType(
            filterElement,
            ctx);
        org.apache.batik.ext.awt.image.renderable.TurbulenceRable turbulenceRable =
          new org.apache.batik.ext.awt.image.renderable.TurbulenceRable8Bit(
          primitiveRegion);
        turbulenceRable.
          setBaseFrequencyX(
            baseFrequency[0]);
        turbulenceRable.
          setBaseFrequencyY(
            baseFrequency[1]);
        turbulenceRable.
          setNumOctaves(
            numOctaves);
        turbulenceRable.
          setSeed(
            seed);
        turbulenceRable.
          setStitched(
            stitchTiles);
        turbulenceRable.
          setFractalNoise(
            isFractalNoise);
        handleColorInterpolationFilters(
          turbulenceRable,
          filterElement);
        updateFilterMap(
          filterElement,
          turbulenceRable,
          filterMap);
        return turbulenceRable;
    }
    protected static float[] convertBaseFrenquency(org.w3c.dom.Element e,
                                                   org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          e.
          getAttributeNS(
            null,
            SVG_BASE_FREQUENCY_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            return new float[] { 0.001F,
            0.001F };
        }
        float[] v =
          new float[2];
        java.util.StringTokenizer tokens =
          new java.util.StringTokenizer(
          s,
          " ,");
        try {
            v[0] =
              org.apache.batik.bridge.SVGUtilities.
                convertSVGNumber(
                  tokens.
                    nextToken(
                      ));
            if (tokens.
                  hasMoreTokens(
                    )) {
                v[1] =
                  org.apache.batik.bridge.SVGUtilities.
                    convertSVGNumber(
                      tokens.
                        nextToken(
                          ));
            }
            else {
                v[1] =
                  v[0];
            }
            if (tokens.
                  hasMoreTokens(
                    )) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  e,
                  ERR_ATTRIBUTE_VALUE_MALFORMED,
                  new java.lang.Object[] { SVG_BASE_FREQUENCY_ATTRIBUTE,
                  s });
            }
        }
        catch (java.lang.NumberFormatException nfEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              e,
              nfEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_BASE_FREQUENCY_ATTRIBUTE,
              s });
        }
        if (v[0] <
              0 ||
              v[1] <
              0) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              e,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_BASE_FREQUENCY_ATTRIBUTE,
              s });
        }
        return v;
    }
    protected static boolean convertStitchTiles(org.w3c.dom.Element e,
                                                org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          e.
          getAttributeNS(
            null,
            SVG_STITCH_TILES_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            return false;
        }
        if (SVG_STITCH_VALUE.
              equals(
                s)) {
            return true;
        }
        if (SVG_NO_STITCH_VALUE.
              equals(
                s)) {
            return false;
        }
        throw new org.apache.batik.bridge.BridgeException(
          ctx,
          e,
          ERR_ATTRIBUTE_VALUE_MALFORMED,
          new java.lang.Object[] { SVG_STITCH_TILES_ATTRIBUTE,
          s });
    }
    protected static boolean convertType(org.w3c.dom.Element e,
                                         org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          e.
          getAttributeNS(
            null,
            SVG_TYPE_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            return false;
        }
        if (SVG_FRACTAL_NOISE_VALUE.
              equals(
                s)) {
            return true;
        }
        if (SVG_TURBULENCE_VALUE.
              equals(
                s)) {
            return false;
        }
        throw new org.apache.batik.bridge.BridgeException(
          ctx,
          e,
          ERR_ATTRIBUTE_VALUE_MALFORMED,
          new java.lang.Object[] { SVG_TYPE_ATTRIBUTE,
          s });
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "3afFlnX+7Pzc+71eoGpmJcz9h5N0r/r6");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("o6j29tukJMDDDy/V9L9+oP/jqHb9Mj1wler7PN2fRLUHzugAq8PLeZI/B3EC" +
       "kJSv3/BOXP99t8uPiG0YBZIclWqrltjTc90LmsuuXMzwT+3z+Hezz7k/Bc9d" +
       "WLuq664naXc8O85rvvDKaPKhb7d+8XAhSbakoii53AeWmcPdqNPU/Znbcjvh" +
       "de/gPd955Nfuf/4kdXnkMOEziJ+b29O3vv3Ts72ouq9T/Mbb/9kP/eNX/rC6" +
       "AvB/ATlc6LyHLAAA");
}
