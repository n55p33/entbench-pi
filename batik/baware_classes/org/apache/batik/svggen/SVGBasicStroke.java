package org.apache.batik.svggen;
public class SVGBasicStroke extends org.apache.batik.svggen.AbstractSVGConverter {
    public SVGBasicStroke(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          generatorContext);
    }
    public org.apache.batik.svggen.SVGDescriptor toSVG(org.apache.batik.ext.awt.g2d.GraphicContext gc) {
        if (gc.
              getStroke(
                ) instanceof java.awt.BasicStroke)
            return toSVG(
                     (java.awt.BasicStroke)
                       gc.
                       getStroke(
                         ));
        else
            return null;
    }
    public final org.apache.batik.svggen.SVGStrokeDescriptor toSVG(java.awt.BasicStroke stroke) {
        java.lang.String strokeWidth =
          doubleString(
            stroke.
              getLineWidth(
                ));
        java.lang.String capStyle =
          endCapToSVG(
            stroke.
              getEndCap(
                ));
        java.lang.String joinStyle =
          joinToSVG(
            stroke.
              getLineJoin(
                ));
        java.lang.String miterLimit =
          doubleString(
            stroke.
              getMiterLimit(
                ));
        float[] array =
          stroke.
          getDashArray(
            );
        java.lang.String dashArray =
          null;
        if (array !=
              null)
            dashArray =
              dashArrayToSVG(
                array);
        else
            dashArray =
              SVG_NONE_VALUE;
        java.lang.String dashOffset =
          doubleString(
            stroke.
              getDashPhase(
                ));
        return new org.apache.batik.svggen.SVGStrokeDescriptor(
          strokeWidth,
          capStyle,
          joinStyle,
          miterLimit,
          dashArray,
          dashOffset);
    }
    private final java.lang.String dashArrayToSVG(float[] dashArray) {
        java.lang.StringBuffer dashArrayBuf =
          new java.lang.StringBuffer(
          dashArray.
            length *
            8);
        if (dashArray.
              length >
              0)
            dashArrayBuf.
              append(
                doubleString(
                  dashArray[0]));
        for (int i =
               1;
             i <
               dashArray.
                 length;
             i++) {
            dashArrayBuf.
              append(
                COMMA);
            dashArrayBuf.
              append(
                doubleString(
                  dashArray[i]));
        }
        return dashArrayBuf.
          toString(
            );
    }
    private static java.lang.String joinToSVG(int lineJoin) {
        switch (lineJoin) {
            case java.awt.BasicStroke.
                   JOIN_BEVEL:
                return SVG_BEVEL_VALUE;
            case java.awt.BasicStroke.
                   JOIN_ROUND:
                return SVG_ROUND_VALUE;
            case java.awt.BasicStroke.
                   JOIN_MITER:
            default:
                return SVG_MITER_VALUE;
        }
    }
    private static java.lang.String endCapToSVG(int endCap) {
        switch (endCap) {
            case java.awt.BasicStroke.
                   CAP_BUTT:
                return SVG_BUTT_VALUE;
            case java.awt.BasicStroke.
                   CAP_ROUND:
                return SVG_ROUND_VALUE;
            default:
            case java.awt.BasicStroke.
                   CAP_SQUARE:
                return SVG_SQUARE_VALUE;
        }
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
