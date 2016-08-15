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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "07jX8OnC/wCuxCWHNSYAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "62x9zZn7656vamapoof21TZeKe2jYeWJ");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("S0Qrfowrbwqo127v6d8bVm6fpy9KTor/Z+meCCs3T+kAq/3NWZKnwsp9gKS4" +
       "/X7vWM8vXKZnbB2EviSHpYqcWPVD1U+v3R2qTszxsbdT/Jno9pG7YlJZ934c" +
       "P6LJ0U8+X3ttMPqxN5s/t69qlC0pzwsuN5jKg/sCy5MY9KFLuR3zut5/7nuP" +
       "fP2hZ4/j5SN7wKc2fgbbBy8uISRtLyyL/vJfeeLvvPQ3Xvud8jeL/wvf4pc0" +
       "kDAAAA==");
}
