package org.apache.batik.svggen;
public class SVGPolygon extends org.apache.batik.svggen.SVGGraphicObjectConverter {
    public SVGPolygon(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          generatorContext);
    }
    public org.w3c.dom.Element toSVG(java.awt.Polygon polygon) { org.w3c.dom.Element svgPolygon =
                                                                   generatorContext.
                                                                     domFactory.
                                                                   createElementNS(
                                                                     SVG_NAMESPACE_URI,
                                                                     SVG_POLYGON_TAG);
                                                                 java.lang.StringBuffer points =
                                                                   new java.lang.StringBuffer(
                                                                   " ");
                                                                 java.awt.geom.PathIterator pi =
                                                                   polygon.
                                                                   getPathIterator(
                                                                     null);
                                                                 float[] seg =
                                                                   new float[6];
                                                                 while (!pi.
                                                                          isDone(
                                                                            )) {
                                                                     int segType =
                                                                       pi.
                                                                       currentSegment(
                                                                         seg);
                                                                     switch (segType) {
                                                                         case java.awt.geom.PathIterator.
                                                                                SEG_MOVETO:
                                                                             appendPoint(
                                                                               points,
                                                                               seg[0],
                                                                               seg[1]);
                                                                             break;
                                                                         case java.awt.geom.PathIterator.
                                                                                SEG_LINETO:
                                                                             appendPoint(
                                                                               points,
                                                                               seg[0],
                                                                               seg[1]);
                                                                             break;
                                                                         case java.awt.geom.PathIterator.
                                                                                SEG_CLOSE:
                                                                             break;
                                                                         case java.awt.geom.PathIterator.
                                                                                SEG_QUADTO:
                                                                         case java.awt.geom.PathIterator.
                                                                                SEG_CUBICTO:
                                                                         default:
                                                                             throw new java.lang.Error(
                                                                               "invalid segmentType:" +
                                                                               segType);
                                                                     }
                                                                     pi.
                                                                       next(
                                                                         );
                                                                 }
                                                                 svgPolygon.
                                                                   setAttributeNS(
                                                                     null,
                                                                     SVG_POINTS_ATTRIBUTE,
                                                                     points.
                                                                       substring(
                                                                         0,
                                                                         points.
                                                                           length(
                                                                             ) -
                                                                           1));
                                                                 return svgPolygon;
    }
    private void appendPoint(java.lang.StringBuffer points,
                             float x,
                             float y) { points.
                                          append(
                                            doubleString(
                                              x));
                                        points.
                                          append(
                                            SPACE);
                                        points.
                                          append(
                                            doubleString(
                                              y));
                                        points.
                                          append(
                                            SPACE);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "oe8brOcGvYi2VjxfTA20TCqNoIRZy82A8CZWDfPL1IoYCSoVsKVVKjQHs5q7" +
       "4S1ktlmWQnQ11BAh6ZVjv2N29fm6gnnqxmnQIxd12XVjoeIss5I2daKpY8XI" +
       "V8sxrURzfjyrYpjYASZVlCeDzhKTLEWmWGXU5Ht4KnerRhUPZ8NwhGwaw346" +
       "aAm0Um3Nh+O41ampDub7A33WGtIIac0JRR7WIhS13OaiFPU0hir1JuyQ8sIo" +
       "WZuN5dTssdMKp+P95sZMuAWZCqLXQMyU6bTaIaYYhEk16nWBb7CoH0YpZ8z9" +
       "WBXS1sbC1nVvvukTPcfj5ILZm/UEyh47JcyWZHth9H2Hrq1VOZ3SeJWueMkI" +
       "L49RvVIe1QtwoYWW5gXNwc1+ETPxijptUUlpyMyouT43auao7KeGUdLa05QU" +
       "/SixxT65iq05hw5QZVKxRmi5M7QoqgvulYtqW0OHStNAmdak4Fr6pC5WyFSx" +
       "lMhc0lPJUvvYJvE0Oe2vkPJkEDv4mmbtqTWfj5O+kyLtWm06jWcKV2cRdd0k" +
       "FzomBjHRbymx106xqV0etlvREhvKHOpoXI8isTWCNto6lsIJPKSrKrX0rX7S" +
       "jRu+E7u4Px0s/DEhhH7QI9jSrBiXYQvBkwGO9dBFt5L6Sm2hCcDTWcwPi2Wv" +
       "xle6fQpLk9ZYYrh4bY2m5aTNz3jftNawhfa4QO42OzOTa5bKHWaxmNP0Qtbh" +
       "mFxxk2FFqLJVebEI0BLtzJhBZ23NV2p7LMTzsBrX/UEzrSmcS8crWvfhAh8T" +
       "vl6yiJFKsy15yAE/L7OqO8JYTiVTkWiqbh3tU5Q5UOBRPa3IKFFBJ1TbLhYK" +
       "fcTVjCVN0o0lNi/0kO54gJjLSi0udwpGo1paN4RCRM7K+gTvyR0Gr1MDucik" +
       "yHKOLFt4D3UGizFf0IgqJ5qSvVjhZZyeLJlp01t5GN+gYlpt9PRQJ6ZFRRhV" +
       "Y82YtfsC3JutEgXnxgUdaVkqqspNr2UnattTTKmNo6SGI1JtxqYLWp/qm/WA" +
       "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");
}
