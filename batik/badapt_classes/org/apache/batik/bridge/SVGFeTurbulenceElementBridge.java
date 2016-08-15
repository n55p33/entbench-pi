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
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "jn/Pdll//RN/8sT8x1cffQtnR09fovMyyn/Mvfa1wQ/pn71au+t0z/Wmg+mL" +
       "g164uNN6LTbTLA7mF/ZbnzyV7OOlxJ4CD3IsWeTW5ze3tIIrlRUcdH+Hw4Lk" +
       "Dn1ZWQRp7SEbZLqhrnrjY9LpM3MJv99G3HmkVcP6Zv76x/z1/9/wd18FcN/J" +
       "JvHztzvOPBxcHt9+OIF+RwmdN/QjI/SPjk84y65PnAA8cxM6e5seDWI1Wjl6" +
       "Mg4N8wQSuQmyNFM1T48c8FFrHsVmYJhxeXh01He81IxPBv5gtclcAtomoEIw" +
       "dWA9tmeivQubrReNXlDzypNe1P/F9FtvfGH/5dcOe6mamphpDbrdpZSb78WU" +
       "x5rP3+Fo9uy6wp8OfvT1P/6v0kdOfPXBU9U+XWryWfCwx6plL6v2hNeHz06E" +
       "OLXq+5kK18fvYJifLYs9MEw9NtXUPAivbPupM8P82NswzCfLRhQ8nz2m/rNv" +
       "wTCvgoAVxWEKlGYaVRS+pZFePQBXplUWL1dQX7gD13+vLH4urb1TD4OtCb4u" +
       "gGL7wIY2mRnou+SOSqvOFg9Ke/UfPPdbH3/1ud+vjufudxJJjYnYvsW9lHNj" +
       "vvPaN9/87Yef/FJ1hF1ZVBWvLl/oufm+zoVrOBUXD51K+YnasaG8/1jK1Tut" +
       "Ld7mVQkwzC/PWcOYALUqyp/cwviLQn0woNm59XNRHmV5oZqeqvLK8b2H09OJ" +
       "LxZXapU5/ZPbGNLpOn66hN/rmYGdrm41213OIU79/ai4bGOnoe3s7Ir0wsAs" +
       "I89J3+HahhMend73Ap3FLYlfH4ivJjuXEHy/leYrd+j7aln8KhCZXtJ1YOMO" +
       "4K8fu3Dl6J9/u44Og+crxyb4lbfi6GX1775VD//aHfj6eln8m7T2+LGHz1In" +
       "1VdzB6jpViq/TwtDz1SDM1n82tuVxQ+D541jWbzxFy6L37mDLH63LP59Wnvw" +
       "WBYnSdK/O+P2G2+F2yKtvfdO95fKyxjvuen+5OHOn/6lVx+9/92viv/xEP9O" +
       "7uU9wNbutzLPO392fq5+bxSDL5SKmQcO");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("J+lR9fr9tPbu26QkwMMPlYr8bx3g/yCtXb8MD1ylep+H+8O0du0MDqA6VM6D" +
       "/AmIEwCkrL4Znbj+h26XHxFaksbgi6wUW7XEnp7rXpBcceVihn+qn8e/n37O" +
       "fRQ8d2Htqq67nqTdGX+c13z5VWb8se+2fuFwIUn31P2+xHI/WGYOd6NOU/dn" +
       "bovtBNe99Ae+98gvP/D8SeryyIHgMxM/R9vTt779Q/lRWt3X2f/qu//Zj/3D" +
       "V3+vugLwfwEcXkHbhywAAA==");
}
