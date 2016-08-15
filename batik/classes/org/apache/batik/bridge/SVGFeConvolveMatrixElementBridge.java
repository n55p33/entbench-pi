package org.apache.batik.bridge;
public class SVGFeConvolveMatrixElementBridge extends org.apache.batik.bridge.AbstractSVGFilterPrimitiveElementBridge {
    public SVGFeConvolveMatrixElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_FE_CONVOLVE_MATRIX_TAG;
    }
    public org.apache.batik.ext.awt.image.renderable.Filter createFilter(org.apache.batik.bridge.BridgeContext ctx,
                                                                         org.w3c.dom.Element filterElement,
                                                                         org.w3c.dom.Element filteredElement,
                                                                         org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                         org.apache.batik.ext.awt.image.renderable.Filter inputFilter,
                                                                         java.awt.geom.Rectangle2D filterRegion,
                                                                         java.util.Map filterMap) {
        int[] orderXY =
          convertOrder(
            filterElement,
            ctx);
        float[] kernelMatrix =
          convertKernelMatrix(
            filterElement,
            orderXY,
            ctx);
        float divisor =
          convertDivisor(
            filterElement,
            kernelMatrix,
            ctx);
        float bias =
          convertNumber(
            filterElement,
            SVG_BIAS_ATTRIBUTE,
            0,
            ctx);
        int[] targetXY =
          convertTarget(
            filterElement,
            orderXY,
            ctx);
        org.apache.batik.ext.awt.image.PadMode padMode =
          convertEdgeMode(
            filterElement,
            ctx);
        double[] kernelUnitLength =
          convertKernelUnitLength(
            filterElement,
            ctx);
        boolean preserveAlpha =
          convertPreserveAlpha(
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
        org.apache.batik.ext.awt.image.renderable.ConvolveMatrixRable convolve =
          new org.apache.batik.ext.awt.image.renderable.ConvolveMatrixRable8Bit(
          pad);
        for (int i =
               0;
             i <
               kernelMatrix.
                 length;
             i++) {
            kernelMatrix[i] /=
              divisor;
        }
        convolve.
          setKernel(
            new java.awt.image.Kernel(
              orderXY[0],
              orderXY[1],
              kernelMatrix));
        convolve.
          setTarget(
            new java.awt.Point(
              targetXY[0],
              targetXY[1]));
        convolve.
          setBias(
            bias);
        convolve.
          setEdgeMode(
            padMode);
        convolve.
          setKernelUnitLength(
            kernelUnitLength);
        convolve.
          setPreserveAlpha(
            preserveAlpha);
        handleColorInterpolationFilters(
          convolve,
          filterElement);
        org.apache.batik.ext.awt.image.renderable.PadRable filter =
          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
          convolve,
          primitiveRegion,
          org.apache.batik.ext.awt.image.PadMode.
            ZERO_PAD);
        updateFilterMap(
          filterElement,
          filter,
          filterMap);
        return filter;
    }
    protected static int[] convertOrder(org.w3c.dom.Element filterElement,
                                        org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            SVG_ORDER_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            return new int[] { 3,
            3 };
        }
        int[] orderXY =
          new int[2];
        java.util.StringTokenizer tokens =
          new java.util.StringTokenizer(
          s,
          " ,");
        try {
            orderXY[0] =
              org.apache.batik.bridge.SVGUtilities.
                convertSVGInteger(
                  tokens.
                    nextToken(
                      ));
            if (tokens.
                  hasMoreTokens(
                    )) {
                orderXY[1] =
                  org.apache.batik.bridge.SVGUtilities.
                    convertSVGInteger(
                      tokens.
                        nextToken(
                          ));
            }
            else {
                orderXY[1] =
                  orderXY[0];
            }
        }
        catch (java.lang.NumberFormatException nfEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              filterElement,
              nfEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_ORDER_ATTRIBUTE,
              s,
              nfEx });
        }
        if (tokens.
              hasMoreTokens(
                ) ||
              orderXY[0] <=
              0 ||
              orderXY[1] <=
              0) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              filterElement,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_ORDER_ATTRIBUTE,
              s });
        }
        return orderXY;
    }
    protected static float[] convertKernelMatrix(org.w3c.dom.Element filterElement,
                                                 int[] orderXY,
                                                 org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            SVG_KERNEL_MATRIX_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              filterElement,
              ERR_ATTRIBUTE_MISSING,
              new java.lang.Object[] { SVG_KERNEL_MATRIX_ATTRIBUTE });
        }
        int size =
          orderXY[0] *
          orderXY[1];
        float[] kernelMatrix =
          new float[size];
        java.util.StringTokenizer tokens =
          new java.util.StringTokenizer(
          s,
          " ,");
        int i =
          0;
        try {
            while (tokens.
                     hasMoreTokens(
                       ) &&
                     i <
                     size) {
                kernelMatrix[i++] =
                  org.apache.batik.bridge.SVGUtilities.
                    convertSVGNumber(
                      tokens.
                        nextToken(
                          ));
            }
        }
        catch (java.lang.NumberFormatException nfEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              filterElement,
              nfEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_KERNEL_MATRIX_ATTRIBUTE,
              s,
              nfEx });
        }
        if (i !=
              size) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              filterElement,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_KERNEL_MATRIX_ATTRIBUTE,
              s });
        }
        return kernelMatrix;
    }
    protected static float convertDivisor(org.w3c.dom.Element filterElement,
                                          float[] kernelMatrix,
                                          org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            SVG_DIVISOR_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            float sum =
              0;
            for (int i =
                   0;
                 i <
                   kernelMatrix.
                     length;
                 ++i) {
                sum +=
                  kernelMatrix[i];
            }
            return sum ==
              0
              ? 1.0F
              : sum;
        }
        else {
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
                  new java.lang.Object[] { SVG_DIVISOR_ATTRIBUTE,
                  s,
                  nfEx });
            }
        }
    }
    protected static int[] convertTarget(org.w3c.dom.Element filterElement,
                                         int[] orderXY,
                                         org.apache.batik.bridge.BridgeContext ctx) {
        int[] targetXY =
          new int[2];
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            SVG_TARGET_X_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            targetXY[0] =
              orderXY[0] /
                2;
        }
        else {
            try {
                int v =
                  org.apache.batik.bridge.SVGUtilities.
                  convertSVGInteger(
                    s);
                if (v <
                      0 ||
                      v >=
                      orderXY[0]) {
                    throw new org.apache.batik.bridge.BridgeException(
                      ctx,
                      filterElement,
                      ERR_ATTRIBUTE_VALUE_MALFORMED,
                      new java.lang.Object[] { SVG_TARGET_X_ATTRIBUTE,
                      s });
                }
                targetXY[0] =
                  v;
            }
            catch (java.lang.NumberFormatException nfEx) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  filterElement,
                  nfEx,
                  ERR_ATTRIBUTE_VALUE_MALFORMED,
                  new java.lang.Object[] { SVG_TARGET_X_ATTRIBUTE,
                  s,
                  nfEx });
            }
        }
        s =
          filterElement.
            getAttributeNS(
              null,
              SVG_TARGET_Y_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            targetXY[1] =
              orderXY[1] /
                2;
        }
        else {
            try {
                int v =
                  org.apache.batik.bridge.SVGUtilities.
                  convertSVGInteger(
                    s);
                if (v <
                      0 ||
                      v >=
                      orderXY[1]) {
                    throw new org.apache.batik.bridge.BridgeException(
                      ctx,
                      filterElement,
                      ERR_ATTRIBUTE_VALUE_MALFORMED,
                      new java.lang.Object[] { SVG_TARGET_Y_ATTRIBUTE,
                      s });
                }
                targetXY[1] =
                  v;
            }
            catch (java.lang.NumberFormatException nfEx) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  filterElement,
                  nfEx,
                  ERR_ATTRIBUTE_VALUE_MALFORMED,
                  new java.lang.Object[] { SVG_TARGET_Y_ATTRIBUTE,
                  s,
                  nfEx });
            }
        }
        return targetXY;
    }
    protected static double[] convertKernelUnitLength(org.w3c.dom.Element filterElement,
                                                      org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            SVG_KERNEL_UNIT_LENGTH_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            return null;
        }
        double[] units =
          new double[2];
        java.util.StringTokenizer tokens =
          new java.util.StringTokenizer(
          s,
          " ,");
        try {
            units[0] =
              org.apache.batik.bridge.SVGUtilities.
                convertSVGNumber(
                  tokens.
                    nextToken(
                      ));
            if (tokens.
                  hasMoreTokens(
                    )) {
                units[1] =
                  org.apache.batik.bridge.SVGUtilities.
                    convertSVGNumber(
                      tokens.
                        nextToken(
                          ));
            }
            else {
                units[1] =
                  units[0];
            }
        }
        catch (java.lang.NumberFormatException nfEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              filterElement,
              nfEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_KERNEL_UNIT_LENGTH_ATTRIBUTE,
              s });
        }
        if (tokens.
              hasMoreTokens(
                ) ||
              units[0] <=
              0 ||
              units[1] <=
              0) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              filterElement,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_KERNEL_UNIT_LENGTH_ATTRIBUTE,
              s });
        }
        return units;
    }
    protected static org.apache.batik.ext.awt.image.PadMode convertEdgeMode(org.w3c.dom.Element filterElement,
                                                                            org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            SVG_EDGE_MODE_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            return org.apache.batik.ext.awt.image.PadMode.
                     REPLICATE;
        }
        if (SVG_DUPLICATE_VALUE.
              equals(
                s)) {
            return org.apache.batik.ext.awt.image.PadMode.
                     REPLICATE;
        }
        if (SVG_WRAP_VALUE.
              equals(
                s)) {
            return org.apache.batik.ext.awt.image.PadMode.
                     WRAP;
        }
        if (SVG_NONE_VALUE.
              equals(
                s)) {
            return org.apache.batik.ext.awt.image.PadMode.
                     ZERO_PAD;
        }
        throw new org.apache.batik.bridge.BridgeException(
          ctx,
          filterElement,
          ERR_ATTRIBUTE_VALUE_MALFORMED,
          new java.lang.Object[] { SVG_EDGE_MODE_ATTRIBUTE,
          s });
    }
    protected static boolean convertPreserveAlpha(org.w3c.dom.Element filterElement,
                                                  org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            SVG_PRESERVE_ALPHA_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            return false;
        }
        if (SVG_TRUE_VALUE.
              equals(
                s)) {
            return true;
        }
        if (SVG_FALSE_VALUE.
              equals(
                s)) {
            return false;
        }
        throw new org.apache.batik.bridge.BridgeException(
          ctx,
          filterElement,
          ERR_ATTRIBUTE_VALUE_MALFORMED,
          new java.lang.Object[] { SVG_PRESERVE_ALPHA_ATTRIBUTE,
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
       "6DRdK6PwNUF6cU9cQqsoPlJSffYcrX+2");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("KH4qLg9QbfUwLvdLo3P7qtwu3vfVi3//ia9++MUn/qDccb3NigQ5xEPzGseO" +
       "TrX57svf+PbX737oc+WphBJIZZg6e17r6uNYV5yyKoW/69i4xXmbyuVK5ebJ" +
       "3rb777ii3uApGDkIIijamkrop5EeQoUnMmDSp4eM7OnO0WGbv4zX7PE0PzWc" +
       "inHlJuvwOF/RrxcOD7gcb0O9lF2olNj6R9dB1fGgfjyeX3J0z9wfZ/qFovi5" +
       "IDuLruOgdrIjSTi+pxcx56hufxjH8g+OT/SByuyaktp7ScuXnUoFXm+M+ZVz" +
       "6v55UXwxrtyiFnLt1TiH/EuHzlu6+GduwMUfKh7C4Hr10MVffSMuXtz+9PV9" +
       "+6aTPKz07Z87cfBfP0e5V4vi10BvHTr4WA8BovbnqMoGf+9Y/Acrh0H23Yfi" +
       "v3vvROKNohtMeIvzJ36Ig7syQzpynDeL9TWd5RbD8eVz3OUrR+7y9f9PdymK" +
       "zx27ypevdpXi5xeK4pfPwf5XSmZfLop/ck5H/u45df++KH6nKH51L8k5tL93" +
       "Gu3/8kYHtKfB9dohXF57E9H+5RO0/6dzlPtWUfxBXLnnEO1da2tFfjmMf/VE" +
       "6z+8Ua3fAzrw3n3b/feb7+P//Ryt/0dRfCcuD+kUWnNyCLLrksGJ0v/tBpQu" +
       "8ulKAyjbPVS6+xeo9LWTlj+7vr4Xyjf/77jy9itiGu9ZMVWOXmfiWqFo5R5w" +
       "mYdANc9Kf61ocUnzEzBoBUFwyl/+9EZHh/cC41mHRrTebCNeuHyOEe8rijvi" +
       "yuVDI/bAtIU+NdF41+tMNBhZOyYvbHPhzhu1DQJs8rFD23zsTbfNQ+fY5pGi" +
       "eACkMYe2YUIdpGVbHXeClXwtsNyq+L6jy96JNd7xRqyRxZVHX++cc3Fo84Gr" +
       "/nOx/5+A+rkXL9/29hf539kn1Udn+W+nKrcZieOcPmN36v5SEOqGVZrs9v2J" +
       "u6DU/mngWdeZ3gK32N8UKlx4z57+vXHl3rP0YLQtv0/TQXHljhM6wGp/c5qk" +
       "BlJaQFLcosEREt93vbk2rkRxKKtxYbpyunZ8/usKy2X7wfaB09Arvfn+1+uj" +
       "UwtMT1wxISr/InO0hJMwh3Pkz79ITj70WvPn9weXVUfO84LLbWDusj9DfTh3" +
       "OTvfPs3tiNel4dPfu+cLtz91NA2+Zy/wiRucku2Ra58S7rlBXJ7rzX/l7f/4" +
       "B3/hxd8vjwr+PxuzoTq7NAAA");
}
