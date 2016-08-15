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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "gX571gOe+Pe6kH9NPOLwzH8ABLINU1YVAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "f/edv/nSN/Prwv8Bril/0cYgAAA=");
}
