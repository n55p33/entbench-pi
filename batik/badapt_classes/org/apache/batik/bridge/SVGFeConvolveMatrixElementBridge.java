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
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "faypZRS+Jkgv7olLaBXFCyXVZ8/R+u8W");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("xU/H5QGqVAvjcr80Onesyu3i/Vi99Pef+OpHX3ri98sd19usSJBCLDSucezo" +
       "VJvvvvKNb3/97oc+V55KKIFUhqmz57WuPo51xSmrUvi7jo1bnLepXK5Ubqb3" +
       "tt1/xxXlBk/BSEEQQVFqyKG/jbQQKjyRsRRbCxnJ05yjwzZ/Ed3s8cSdmk4X" +
       "ceUm6/A4XzGuFw4PuBxvQ72cXaiU2PpH10HV8aR+PJ9fcjTP2B9n+vmi+Nkg" +
       "O4uu46B2siPZc3xPK2LOUd3+MI7lHxyf6AOV2TUltfeSlp2dSgXeaI755XPq" +
       "/nlRfDGu3KIUcu3VOIf8S4fOW7r4Z27AxR8qHsLgeu3QxV97My5e3P6d6/v2" +
       "TSd5WOnbP3vi4L92jnKvFcWvgtE6dPCxFgJE7c9RlQ3+3rH4D1YOg+x7D8V/" +
       "796JFjeKbs9yi/MnfoiBuzJDOnKct4r1NZ3lFt3xpXPc5StH7vL1/093KYrP" +
       "HbvKl692leLnF4ril87B/ldKZl8uin9yzkD+zjl1/74ofrsofmUvyTm0v3sa" +
       "7f/yRie0p8H1+iFcXn8L0f7lE7T/p3OU+1ZR/H5cuecQ7X0rtSK/nMa/eqL1" +
       "H9yo1u8DA3jvvu3++6338f9+jtb/oyi+E5eHdAqteSkE2XXJ4ETp/3YDShf5" +
       "dKUBlO0fKt3/c1T62knLn15f3wtlz/87rrzzipg296yYKmevM3GtULRyD7iM" +
       "Q6AaZ6W/VrS4pPoJmLSCIDjlL39yo7PD+4HxrEMjWm+1ES9cPseI9xXFHXHl" +
       "8qERB2DZMjm10HjPGyw0GEk9Ji9sc+HOG7VNDdjkRw9t86NvuW0eOsc2jxTF" +
       "AyCNObQNE2ogLUs1zAlM6VpguVX2fUeTvBNrvOvNWCOLK4++0Tnn4tDmA1f9" +
       "52L/PwHlcy9dvu2dL81/e59UH53lv52q3KYnjnP6jN2p+0tBqOlWabLb9yfu" +
       "glL7p4FnXWd5C9xif1OocOF9e/r3x5V7z9KD2bb8Pk0HxZU7TugAq/3NaRIE" +
       "pLSApLhFgyMkfuB6a21MjuJQUuLCdOVy7fj81xWWy/aT7QOnoVd68/1vNEan" +
       "XjA9ccWCqPyLzNErnIQ5XCN//iWS/sjrzZ/bH1xWHCnPCy63gbXL/gz14drl" +
       "7Hr7NLcjXpeIp793zxduf+poGXzPXuATNzgl2yPXPiU8cIO4PNeb//I7//EP" +
       "/vxLv1ceFfx/4ISNxbs0AAA=");
}
