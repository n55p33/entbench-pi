package org.apache.batik.bridge;
public class SVGFeGaussianBlurElementBridge extends org.apache.batik.bridge.AbstractSVGFilterPrimitiveElementBridge {
    public SVGFeGaussianBlurElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_FE_GAUSSIAN_BLUR_TAG;
    }
    public org.apache.batik.ext.awt.image.renderable.Filter createFilter(org.apache.batik.bridge.BridgeContext ctx,
                                                                         org.w3c.dom.Element filterElement,
                                                                         org.w3c.dom.Element filteredElement,
                                                                         org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                         org.apache.batik.ext.awt.image.renderable.Filter inputFilter,
                                                                         java.awt.geom.Rectangle2D filterRegion,
                                                                         java.util.Map filterMap) {
        float[] stdDeviationXY =
          convertStdDeviation(
            filterElement,
            ctx);
        if (stdDeviationXY[0] <
              0 ||
              stdDeviationXY[1] <
              0) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              filterElement,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_STD_DEVIATION_ATTRIBUTE,
              java.lang.String.
                valueOf(
                  stdDeviationXY[0]) +
              stdDeviationXY[1] });
        }
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
        org.apache.batik.ext.awt.image.renderable.Filter blur =
          new org.apache.batik.ext.awt.image.renderable.GaussianBlurRable8Bit(
          pad,
          stdDeviationXY[0],
          stdDeviationXY[1]);
        handleColorInterpolationFilters(
          blur,
          filterElement);
        org.apache.batik.ext.awt.image.renderable.PadRable filter =
          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
          blur,
          primitiveRegion,
          org.apache.batik.ext.awt.image.PadMode.
            ZERO_PAD);
        updateFilterMap(
          filterElement,
          filter,
          filterMap);
        return filter;
    }
    protected static float[] convertStdDeviation(org.w3c.dom.Element filterElement,
                                                 org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            SVG_STD_DEVIATION_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            return new float[] { 0,
            0 };
        }
        float[] stdDevs =
          new float[2];
        java.util.StringTokenizer tokens =
          new java.util.StringTokenizer(
          s,
          " ,");
        try {
            stdDevs[0] =
              org.apache.batik.bridge.SVGUtilities.
                convertSVGNumber(
                  tokens.
                    nextToken(
                      ));
            if (tokens.
                  hasMoreTokens(
                    )) {
                stdDevs[1] =
                  org.apache.batik.bridge.SVGUtilities.
                    convertSVGNumber(
                      tokens.
                        nextToken(
                          ));
            }
            else {
                stdDevs[1] =
                  stdDevs[0];
            }
        }
        catch (java.lang.NumberFormatException nfEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              filterElement,
              nfEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_STD_DEVIATION_ATTRIBUTE,
              s,
              nfEx });
        }
        if (tokens.
              hasMoreTokens(
                )) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              filterElement,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_STD_DEVIATION_ATTRIBUTE,
              s });
        }
        return stdDevs;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "vPcfbmvW4GYfAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "OllDi03ejopOITPDCWJanp2Tzbw5dl0NXeuTmauNuboxLrwps0ixZYfrW81g" +
       "6wNL5hQJe9PZWtDC5lJfLNr7mAuyuU9zM7dBrpuc1HPaGziH1XQyHw3lWMVy" +
       "fExnIqdPuPUq2Q/XceZqE6hRb8YQK0+3utAo/J6vdkaz+sZGMx6x5wnT6hbm" +
       "1Bx39Snd4ia62gWAtRy0p20bK6JksMqUFSY4a3g3TNOGZ3WmdrbBmDYioyxD" +
       "dFFGHMEkNm22NJrn5A2zBclVasvNthP169g8mrkevo/8FjeuNza5OZDHeWcS" +
       "KqO8QXtbzoFc3J7s2rAMjWN5Fe3atGoj22THBklBI5MW5jWIMGTzfa/QgUsh" +
       "Z51FiNcZev1RE8awibGf+T032CRQzndoShFMj+Dam1xgNpN1uFWSvcTomUuH" +
       "0diMhMQAeXu4kteKqEAg/2WzJspsCJAmx/K6VxCKvG0u6KhIyPGsiQ+HY5nD" +
       "WRzpJ26WSZCFJ17W7TFjfI+NCAlVCHlIdzpUw2n0ZZzPEoCZ5HZf3+K7XM+A" +
       "zwRhPegojJD1J6qx6cSxAHfQNBwBLvvtUN+KNkbNm+a042JympJOm2zSvfWq" +
       "GHTb2KQH1s1xINC5JqC0oalIoSSa3WzMOQaOzKKJhqRh7xmUmeKyqHkFplMN" +
       "267PUrQDNQwoq3tEY2tDUofprJC+3py3G7rFrsz2aIXx+JzFqMLtj3Yy1Cg2" +
       "cbpNNTSLm6iDYhRJJXknZuf1aNmlRFJnhjnXSBtcSily3o9ZaCOHjf0A1U1d" +
       "UQfUzA9tfN1UEUtLExosST2a8USG39eJBJ7Dom4nWQuSutrEBjlQn4XgJOKJ" +
       "kFZgFVUYhSOV9X5hdOFuYnlhw8r0bjuxG30MG/lIhI27vbRrd9AdyzZgzks1" +
       "Qal7FrLukJABo/0tytWLxMLgTE/aZEZtkgKV9Y5CotS07XlqA0omsxW0tukl" +
       "XQfZ0RZqN7szki40Zq/3qLlYWMuOM1m00bTRyLRRHhPc2u10Jsyu56EcvrT6" +
       "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");
}
