package org.apache.batik.svggen;
public class SVGPath extends org.apache.batik.svggen.SVGGraphicObjectConverter {
    public SVGPath(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          generatorContext);
    }
    public org.w3c.dom.Element toSVG(java.awt.Shape path) { java.lang.String dAttr =
                                                              toSVGPathData(
                                                                path,
                                                                generatorContext);
                                                            if (dAttr ==
                                                                  null ||
                                                                  dAttr.
                                                                  length(
                                                                    ) ==
                                                                  0) {
                                                                return null;
                                                            }
                                                            org.w3c.dom.Element svgPath =
                                                              generatorContext.
                                                                domFactory.
                                                              createElementNS(
                                                                SVG_NAMESPACE_URI,
                                                                SVG_PATH_TAG);
                                                            svgPath.
                                                              setAttributeNS(
                                                                null,
                                                                SVG_D_ATTRIBUTE,
                                                                dAttr);
                                                            if (path.
                                                                  getPathIterator(
                                                                    null).
                                                                  getWindingRule(
                                                                    ) ==
                                                                  java.awt.geom.GeneralPath.
                                                                    WIND_EVEN_ODD)
                                                                svgPath.
                                                                  setAttributeNS(
                                                                    null,
                                                                    SVG_FILL_RULE_ATTRIBUTE,
                                                                    SVG_EVEN_ODD_VALUE);
                                                            return svgPath;
    }
    public static java.lang.String toSVGPathData(java.awt.Shape path,
                                                 org.apache.batik.svggen.SVGGeneratorContext gc) {
        java.lang.StringBuffer d =
          new java.lang.StringBuffer(
          40);
        java.awt.geom.PathIterator pi =
          path.
          getPathIterator(
            null);
        float[] seg =
          new float[6];
        int segType =
          0;
        while (!pi.
                 isDone(
                   )) {
            segType =
              pi.
                currentSegment(
                  seg);
            switch (segType) {
                case java.awt.geom.PathIterator.
                       SEG_MOVETO:
                    d.
                      append(
                        PATH_MOVE);
                    appendPoint(
                      d,
                      seg[0],
                      seg[1],
                      gc);
                    break;
                case java.awt.geom.PathIterator.
                       SEG_LINETO:
                    d.
                      append(
                        PATH_LINE_TO);
                    appendPoint(
                      d,
                      seg[0],
                      seg[1],
                      gc);
                    break;
                case java.awt.geom.PathIterator.
                       SEG_CLOSE:
                    d.
                      append(
                        PATH_CLOSE);
                    break;
                case java.awt.geom.PathIterator.
                       SEG_QUADTO:
                    d.
                      append(
                        PATH_QUAD_TO);
                    appendPoint(
                      d,
                      seg[0],
                      seg[1],
                      gc);
                    appendPoint(
                      d,
                      seg[2],
                      seg[3],
                      gc);
                    break;
                case java.awt.geom.PathIterator.
                       SEG_CUBICTO:
                    d.
                      append(
                        PATH_CUBIC_TO);
                    appendPoint(
                      d,
                      seg[0],
                      seg[1],
                      gc);
                    appendPoint(
                      d,
                      seg[2],
                      seg[3],
                      gc);
                    appendPoint(
                      d,
                      seg[4],
                      seg[5],
                      gc);
                    break;
                default:
                    throw new java.lang.Error(
                      "invalid segmentType:" +
                      segType);
            }
            pi.
              next(
                );
        }
        if (d.
              length(
                ) >
              0)
            return d.
              toString(
                ).
              trim(
                );
        else {
            return "";
        }
    }
    private static void appendPoint(java.lang.StringBuffer d,
                                    float x,
                                    float y,
                                    org.apache.batik.svggen.SVGGeneratorContext gc) {
        d.
          append(
            gc.
              doubleString(
                x));
        d.
          append(
            SPACE);
        d.
          append(
            gc.
              doubleString(
                y));
        d.
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
      ("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");
}
