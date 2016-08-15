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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "drzycslTgtCzJ8fqLw8dWPaezGIPgO8ze5Z95uY14Jt6wancC7Zrf6J4eKIY" +
       "uS1xiHGwu3cdkA8Kb1NxTLMGnNTPBs6YI/f53JMVNWNU2pUdaze7OlX2bjlz" +
       "v1r/sBP80UnyDuvAENlFDkSA73DPEMPXYogAOu96RiQGyk2tcXqvfrinxX0n" +
       "S0x4qKrK9j5zeiRA5lntynTEvM78Sznn997GZL+SNe8KgOu5rmLLQ8fYM84J" +
       "nmcix5APrfbu12K1JIAuHV7qZBXqB264Ht5eaUqffvHyhftfnP5Nfq9xcO14" +
       "kYYuqKFpHi0OHnk+53qKauTqXNyWCt3858MBdP8tCtpZpS9/yIV9YUv/m8Dn" +
       "TtIDa+a/R+k+BvQ5pAOstg9HSX4rgE4Dkuzxt939JSzerrruia5uSNvaKeHY" +
       "keIFipecOg5SB/a/+4fZ/wiuPXEMjfL7+33kCLc3+Nelz7zYZd75SuUT23sZ" +
       "yRQ3m4zLBRo6v70iOkCfx27JbZ/XOeqpV+/87MUn95Hyzq3Ah6FwRLZHbn4J" +
       "0rLcIL+22PzR/X/w5t958et5VfN/ATnynMdYIQAA");
}
