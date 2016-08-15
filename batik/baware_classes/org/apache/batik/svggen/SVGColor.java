package org.apache.batik.svggen;
public class SVGColor extends org.apache.batik.svggen.AbstractSVGConverter {
    public static final java.awt.Color aqua = java.awt.Color.cyan;
    public static final java.awt.Color black = java.awt.Color.black;
    public static final java.awt.Color blue = java.awt.Color.blue;
    public static final java.awt.Color fuchsia = java.awt.Color.magenta;
    public static final java.awt.Color gray = java.awt.Color.gray;
    public static final java.awt.Color green = new java.awt.Color(0, 128,
                                                                  0);
    public static final java.awt.Color lime = java.awt.Color.green;
    public static final java.awt.Color maroon = new java.awt.Color(128, 0,
                                                                   0);
    public static final java.awt.Color navy = new java.awt.Color(0, 0, 128);
    public static final java.awt.Color olive = new java.awt.Color(128, 128,
                                                                  0);
    public static final java.awt.Color purple = new java.awt.Color(128, 0,
                                                                   128);
    public static final java.awt.Color red = java.awt.Color.red;
    public static final java.awt.Color silver = new java.awt.Color(192, 192,
                                                                   192);
    public static final java.awt.Color teal = new java.awt.Color(0, 128, 128);
    public static final java.awt.Color white = java.awt.Color.white;
    public static final java.awt.Color yellow = java.awt.Color.yellow;
    private static java.util.Map colorMap = new java.util.HashMap();
    static { colorMap.put(black, "black");
             colorMap.put(silver, "silver");
             colorMap.put(gray, "gray");
             colorMap.put(white, "white");
             colorMap.put(maroon, "maroon");
             colorMap.put(red, "red");
             colorMap.put(purple, "purple");
             colorMap.put(fuchsia, "fuchsia");
             colorMap.put(green, "green");
             colorMap.put(lime, "lime");
             colorMap.put(olive, "olive");
             colorMap.put(yellow, "yellow");
             colorMap.put(navy, "navy");
             colorMap.put(blue, "blue");
             colorMap.put(teal, "teal");
             colorMap.put(aqua, "aqua"); }
    public SVGColor(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          generatorContext);
    }
    public org.apache.batik.svggen.SVGDescriptor toSVG(org.apache.batik.ext.awt.g2d.GraphicContext gc) {
        java.awt.Paint paint =
          gc.
          getPaint(
            );
        return toSVG(
                 (java.awt.Color)
                   paint,
                 generatorContext);
    }
    public static org.apache.batik.svggen.SVGPaintDescriptor toSVG(java.awt.Color color,
                                                                   org.apache.batik.svggen.SVGGeneratorContext gc) {
        java.lang.String cssColor =
          (java.lang.String)
            colorMap.
            get(
              color);
        if (cssColor ==
              null) {
            java.lang.StringBuffer cssColorBuffer =
              new java.lang.StringBuffer(
              RGB_PREFIX);
            cssColorBuffer.
              append(
                color.
                  getRed(
                    ));
            cssColorBuffer.
              append(
                COMMA);
            cssColorBuffer.
              append(
                color.
                  getGreen(
                    ));
            cssColorBuffer.
              append(
                COMMA);
            cssColorBuffer.
              append(
                color.
                  getBlue(
                    ));
            cssColorBuffer.
              append(
                RGB_SUFFIX);
            cssColor =
              cssColorBuffer.
                toString(
                  );
        }
        float alpha =
          color.
          getAlpha(
            ) /
          255.0F;
        java.lang.String alphaString =
          gc.
          doubleString(
            alpha);
        return new org.apache.batik.svggen.SVGPaintDescriptor(
          cssColor,
          alphaString);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "nMa9jk8X/geCdcUGNSYAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "7D5EV24sE8c5W19z5v56EBpLuxTRQ/tq");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("m6Dk9tG48sQlrBU/xpU3BdRrt/fj3xtXbp8fX5ScFP/Pjnsirtw8HQdI7W/O" +
       "DnkqrtwHhhS3Pxgcy/mFy+SMLqI4VLW4FJG3NcLYCLNrd7uqE3V87O0Ef8a7" +
       "feQun1TWvR/7j4Q/+snn669R7I+/2f7ZfVWj5qh5XlC5QVce3BdYnvigD11K" +
       "7ZjWdeK57z/yjYeePfaXj+wBn+r4GWwfvLiEcOgGcVn0l//yE3/3pb/52m+X" +
       "v1n8X5vPdw+QMAAA");
}
