package org.apache.batik.svggen;
public class SVGRenderingHints extends org.apache.batik.svggen.AbstractSVGConverter {
    public SVGRenderingHints(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          generatorContext);
    }
    public org.apache.batik.svggen.SVGDescriptor toSVG(org.apache.batik.ext.awt.g2d.GraphicContext gc) {
        return toSVG(
                 gc.
                   getRenderingHints(
                     ));
    }
    public static org.apache.batik.svggen.SVGHintsDescriptor toSVG(java.awt.RenderingHints hints) {
        java.lang.String colorInterpolation =
          SVG_AUTO_VALUE;
        java.lang.String colorRendering =
          SVG_AUTO_VALUE;
        java.lang.String textRendering =
          SVG_AUTO_VALUE;
        java.lang.String shapeRendering =
          SVG_AUTO_VALUE;
        java.lang.String imageRendering =
          SVG_AUTO_VALUE;
        if (hints !=
              null) {
            java.lang.Object rendering =
              hints.
              get(
                java.awt.RenderingHints.
                  KEY_RENDERING);
            if (rendering ==
                  java.awt.RenderingHints.
                    VALUE_RENDER_DEFAULT) {
                colorInterpolation =
                  SVG_AUTO_VALUE;
                colorRendering =
                  SVG_AUTO_VALUE;
                textRendering =
                  SVG_AUTO_VALUE;
                shapeRendering =
                  SVG_AUTO_VALUE;
                imageRendering =
                  SVG_AUTO_VALUE;
            }
            else
                if (rendering ==
                      java.awt.RenderingHints.
                        VALUE_RENDER_SPEED) {
                    colorInterpolation =
                      SVG_SRGB_VALUE;
                    colorRendering =
                      SVG_OPTIMIZE_SPEED_VALUE;
                    textRendering =
                      SVG_OPTIMIZE_SPEED_VALUE;
                    shapeRendering =
                      SVG_GEOMETRIC_PRECISION_VALUE;
                    imageRendering =
                      SVG_OPTIMIZE_SPEED_VALUE;
                }
                else
                    if (rendering ==
                          java.awt.RenderingHints.
                            VALUE_RENDER_QUALITY) {
                        colorInterpolation =
                          SVG_LINEAR_RGB_VALUE;
                        colorRendering =
                          SVG_OPTIMIZE_QUALITY_VALUE;
                        textRendering =
                          SVG_OPTIMIZE_QUALITY_VALUE;
                        shapeRendering =
                          SVG_GEOMETRIC_PRECISION_VALUE;
                        imageRendering =
                          SVG_OPTIMIZE_QUALITY_VALUE;
                    }
            java.lang.Object fractionalMetrics =
              hints.
              get(
                java.awt.RenderingHints.
                  KEY_FRACTIONALMETRICS);
            if (fractionalMetrics ==
                  java.awt.RenderingHints.
                    VALUE_FRACTIONALMETRICS_ON) {
                textRendering =
                  SVG_OPTIMIZE_QUALITY_VALUE;
                shapeRendering =
                  SVG_GEOMETRIC_PRECISION_VALUE;
            }
            else
                if (fractionalMetrics ==
                      java.awt.RenderingHints.
                        VALUE_FRACTIONALMETRICS_OFF) {
                    textRendering =
                      SVG_OPTIMIZE_SPEED_VALUE;
                    shapeRendering =
                      SVG_OPTIMIZE_SPEED_VALUE;
                }
                else
                    if (fractionalMetrics ==
                          java.awt.RenderingHints.
                            VALUE_FRACTIONALMETRICS_DEFAULT) {
                        textRendering =
                          SVG_AUTO_VALUE;
                        shapeRendering =
                          SVG_AUTO_VALUE;
                    }
            java.lang.Object antialiasing =
              hints.
              get(
                java.awt.RenderingHints.
                  KEY_ANTIALIASING);
            if (antialiasing ==
                  java.awt.RenderingHints.
                    VALUE_ANTIALIAS_ON) {
                textRendering =
                  SVG_OPTIMIZE_LEGIBILITY_VALUE;
                shapeRendering =
                  SVG_AUTO_VALUE;
            }
            else
                if (antialiasing ==
                      java.awt.RenderingHints.
                        VALUE_ANTIALIAS_OFF) {
                    textRendering =
                      SVG_GEOMETRIC_PRECISION_VALUE;
                    shapeRendering =
                      SVG_CRISP_EDGES_VALUE;
                }
                else
                    if (antialiasing ==
                          java.awt.RenderingHints.
                            VALUE_ANTIALIAS_DEFAULT) {
                        textRendering =
                          SVG_AUTO_VALUE;
                        shapeRendering =
                          SVG_AUTO_VALUE;
                    }
            java.lang.Object textAntialiasing =
              hints.
              get(
                java.awt.RenderingHints.
                  KEY_TEXT_ANTIALIASING);
            if (textAntialiasing ==
                  java.awt.RenderingHints.
                    VALUE_TEXT_ANTIALIAS_ON)
                textRendering =
                  SVG_GEOMETRIC_PRECISION_VALUE;
            else
                if (textAntialiasing ==
                      java.awt.RenderingHints.
                        VALUE_TEXT_ANTIALIAS_OFF)
                    textRendering =
                      SVG_OPTIMIZE_SPEED_VALUE;
                else
                    if (textAntialiasing ==
                          java.awt.RenderingHints.
                            VALUE_TEXT_ANTIALIAS_DEFAULT)
                        textRendering =
                          SVG_AUTO_VALUE;
            java.lang.Object colorRenderingHint =
              hints.
              get(
                java.awt.RenderingHints.
                  KEY_COLOR_RENDERING);
            if (colorRenderingHint ==
                  java.awt.RenderingHints.
                    VALUE_COLOR_RENDER_DEFAULT)
                colorRendering =
                  SVG_AUTO_VALUE;
            else
                if (colorRenderingHint ==
                      java.awt.RenderingHints.
                        VALUE_COLOR_RENDER_QUALITY)
                    colorRendering =
                      SVG_OPTIMIZE_QUALITY_VALUE;
                else
                    if (colorRenderingHint ==
                          java.awt.RenderingHints.
                            VALUE_COLOR_RENDER_SPEED)
                        colorRendering =
                          SVG_OPTIMIZE_SPEED_VALUE;
            java.lang.Object interpolation =
              hints.
              get(
                java.awt.RenderingHints.
                  KEY_INTERPOLATION);
            if (interpolation ==
                  java.awt.RenderingHints.
                    VALUE_INTERPOLATION_NEAREST_NEIGHBOR)
                imageRendering =
                  SVG_OPTIMIZE_SPEED_VALUE;
            else
                if (interpolation ==
                      java.awt.RenderingHints.
                        VALUE_INTERPOLATION_BICUBIC ||
                      interpolation ==
                      java.awt.RenderingHints.
                        VALUE_INTERPOLATION_BILINEAR)
                    imageRendering =
                      SVG_OPTIMIZE_QUALITY_VALUE;
        }
        return new org.apache.batik.svggen.SVGHintsDescriptor(
          colorInterpolation,
          colorRendering,
          textRendering,
          shapeRendering,
          imageRendering);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "gX571gOe+Pe6kH9NPOLwzH8Aej/4S1YVAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "D976e+/8rRe/lV8X/g+e+16AxiAAAA==");
}
