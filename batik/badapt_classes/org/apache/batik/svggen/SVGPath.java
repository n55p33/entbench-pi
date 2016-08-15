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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "qfff6LIlP6F+/D0vvKTSn0B39qpoUgRdiFzvpy0t0awThaUnbnwaH+R3TYfV" +
       "nS++51/u4942f9drqHM/eILPkyQ/OXj5y/iblA/uQKcPaj3X3IIdR3ryeIXn" +
       "YqBFceBwx+o89x9o9q5MY/eC56k9zT51/Vrzda3gVG4F27U/UaQ8UfTc1lvk" +
       "VbTLzmVwXs2645vUNddZ40XQ2chlBXyfyl1Z6XRVUnZV197N7mW1vSvU3Kr8" +
       "H1UnODpJ3mEfqOG+rPPN4OH31MC/BjXsHDrDdXWxcwiVZA2SQ733JuI/lzXP" +
       "RNBtufjZNU1HjuTclQ7lffbHkDdf9neA5/k9eZ9/LfJG0HkvMBM50m4s9Jkc" +
       "9Mz+0t19snrXinVd294Q80digpiVBUF+k5fwXzzU1gdvoq2PZM2vRMDlPE9z" +
       "VMY198ziBOEziWuqh/r71deivxTIvLcUWfn/3muu3LfXxMpnXrp0yz0v8X+d" +
       "XxodXOVeoKBb9NiyjlZej7yf8wJNN3NZLmzrsF7+9VsRdM8NbguyMmr+knP6" +
       "m1v4346gyyfhgT7z76Nwn4ygi4dwgNT25SjIyxF0GoBkr5/29hcRvdnVRSB7" +
       "c1PZFqbbrpNoQaQF6anjkflA+Xf+KOUfCeaPHgvB+X8i9sNlvP1XxFXlsy/1" +
       "h+9+tfqJ7aWXYsmbTUblFgo6v71/Owi5D9+Q2j6tc8TjP7j9cxce298ebt8y" +
       "fOgRR3h78Po3TF3bi/I7oc0f3vP7T/3OS9/IS8b/B8eklKqsIgAA");
}
