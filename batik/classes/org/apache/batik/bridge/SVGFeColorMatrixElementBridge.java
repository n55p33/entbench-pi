package org.apache.batik.bridge;
public class SVGFeColorMatrixElementBridge extends org.apache.batik.bridge.AbstractSVGFilterPrimitiveElementBridge {
    public SVGFeColorMatrixElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_FE_COLOR_MATRIX_TAG;
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
        int type =
          convertType(
            filterElement,
            ctx);
        org.apache.batik.ext.awt.image.renderable.ColorMatrixRable colorMatrix;
        switch (type) {
            case org.apache.batik.ext.awt.image.renderable.ColorMatrixRable.
                   TYPE_HUE_ROTATE:
                float a =
                  convertValuesToHueRotate(
                    filterElement,
                    ctx);
                colorMatrix =
                  org.apache.batik.ext.awt.image.renderable.ColorMatrixRable8Bit.
                    buildHueRotate(
                      a);
                break;
            case org.apache.batik.ext.awt.image.renderable.ColorMatrixRable.
                   TYPE_LUMINANCE_TO_ALPHA:
                colorMatrix =
                  org.apache.batik.ext.awt.image.renderable.ColorMatrixRable8Bit.
                    buildLuminanceToAlpha(
                      );
                break;
            case org.apache.batik.ext.awt.image.renderable.ColorMatrixRable.
                   TYPE_MATRIX:
                float[][] matrix =
                  convertValuesToMatrix(
                    filterElement,
                    ctx);
                colorMatrix =
                  org.apache.batik.ext.awt.image.renderable.ColorMatrixRable8Bit.
                    buildMatrix(
                      matrix);
                break;
            case org.apache.batik.ext.awt.image.renderable.ColorMatrixRable.
                   TYPE_SATURATE:
                float s =
                  convertValuesToSaturate(
                    filterElement,
                    ctx);
                colorMatrix =
                  org.apache.batik.ext.awt.image.renderable.ColorMatrixRable8Bit.
                    buildSaturate(
                      s);
                break;
            default:
                throw new java.lang.Error(
                  "invalid convertType:" +
                  type);
        }
        colorMatrix.
          setSource(
            in);
        handleColorInterpolationFilters(
          colorMatrix,
          filterElement);
        org.apache.batik.ext.awt.image.renderable.Filter filter =
          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
          colorMatrix,
          primitiveRegion,
          org.apache.batik.ext.awt.image.PadMode.
            ZERO_PAD);
        updateFilterMap(
          filterElement,
          filter,
          filterMap);
        return filter;
    }
    protected static float[][] convertValuesToMatrix(org.w3c.dom.Element filterElement,
                                                     org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            SVG_VALUES_ATTRIBUTE);
        float[][] matrix =
          new float[4][5];
        if (s.
              length(
                ) ==
              0) {
            matrix[0][0] =
              1;
            matrix[1][1] =
              1;
            matrix[2][2] =
              1;
            matrix[3][3] =
              1;
            return matrix;
        }
        java.util.StringTokenizer tokens =
          new java.util.StringTokenizer(
          s,
          " ,");
        int n =
          0;
        try {
            while (n <
                     20 &&
                     tokens.
                     hasMoreTokens(
                       )) {
                matrix[n /
                         5][n %
                              5] =
                  org.apache.batik.bridge.SVGUtilities.
                    convertSVGNumber(
                      tokens.
                        nextToken(
                          ));
                n++;
            }
        }
        catch (java.lang.NumberFormatException nfEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              filterElement,
              nfEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_VALUES_ATTRIBUTE,
              s,
              nfEx });
        }
        if (n !=
              20 ||
              tokens.
              hasMoreTokens(
                )) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              filterElement,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_VALUES_ATTRIBUTE,
              s });
        }
        for (int i =
               0;
             i <
               4;
             ++i) {
            matrix[i][4] *=
              255;
        }
        return matrix;
    }
    protected static float convertValuesToSaturate(org.w3c.dom.Element filterElement,
                                                   org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            SVG_VALUES_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0)
            return 1;
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
              new java.lang.Object[] { SVG_VALUES_ATTRIBUTE,
              s });
        }
    }
    protected static float convertValuesToHueRotate(org.w3c.dom.Element filterElement,
                                                    org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            SVG_VALUES_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0)
            return 0;
        try {
            return (float)
                     java.lang.Math.
                     toRadians(
                       org.apache.batik.bridge.SVGUtilities.
                         convertSVGNumber(
                           s));
        }
        catch (java.lang.NumberFormatException nfEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              filterElement,
              nfEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_VALUES_ATTRIBUTE,
              s });
        }
    }
    protected static int convertType(org.w3c.dom.Element filterElement,
                                     org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            SVG_TYPE_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            return org.apache.batik.ext.awt.image.renderable.ColorMatrixRable.
                     TYPE_MATRIX;
        }
        if (SVG_HUE_ROTATE_VALUE.
              equals(
                s)) {
            return org.apache.batik.ext.awt.image.renderable.ColorMatrixRable.
                     TYPE_HUE_ROTATE;
        }
        if (SVG_LUMINANCE_TO_ALPHA_VALUE.
              equals(
                s)) {
            return org.apache.batik.ext.awt.image.renderable.ColorMatrixRable.
                     TYPE_LUMINANCE_TO_ALPHA;
        }
        if (SVG_MATRIX_VALUE.
              equals(
                s)) {
            return org.apache.batik.ext.awt.image.renderable.ColorMatrixRable.
                     TYPE_MATRIX;
        }
        if (SVG_SATURATE_VALUE.
              equals(
                s)) {
            return org.apache.batik.ext.awt.image.renderable.ColorMatrixRable.
                     TYPE_SATURATE;
        }
        throw new org.apache.batik.bridge.BridgeException(
          ctx,
          filterElement,
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
       "J7fR/E+L4osx9MgFzXuJzhfh3UXV/+h1");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("qP7WovI6eL5ypPpXvuuq/9ltVP9KUXwphu47Uv04hPxHp9q++lq0zWLosdum" +
       "hxW5Lo/ckKG6z6pUP/Pi1Xve8uLsT/bbw3Hm470MdI+ROM7Z1IQz75eDUDes" +
       "Upt794kKQfnzl8CVbxGxATzbv5Tyf3VP/19j6NpFegAM5e9Zuv8WQ1dO6QCr" +
       "/ctZkm8CVAQkxeu3gmOge9etwkdMieJQVuNi3soI5OTa/NzMZZfOfwCdGOjh" +
       "72SgM99MT5/b2suE4uOvkoQ7Cvs+++KAfd83Wp/a53upjpznBZd7wC68Tz07" +
       "+bJ58pbcjnld7r3j2w/+6r3PHEd2D+4FPvXxM7I9cfPkKtIN4jIdKv9nb/kn" +
       "P/wPXvxSmWHxfwElPv3u6S0AAA==");
}
