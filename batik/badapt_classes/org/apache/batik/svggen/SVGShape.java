package org.apache.batik.svggen;
public class SVGShape extends org.apache.batik.svggen.SVGGraphicObjectConverter {
    private org.apache.batik.svggen.SVGArc svgArc;
    private org.apache.batik.svggen.SVGEllipse svgEllipse;
    private org.apache.batik.svggen.SVGLine svgLine;
    private org.apache.batik.svggen.SVGPath svgPath;
    private org.apache.batik.svggen.SVGPolygon svgPolygon;
    private org.apache.batik.svggen.SVGRectangle svgRectangle;
    public SVGShape(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          generatorContext);
        svgArc =
          new org.apache.batik.svggen.SVGArc(
            generatorContext);
        svgEllipse =
          new org.apache.batik.svggen.SVGEllipse(
            generatorContext);
        svgLine =
          new org.apache.batik.svggen.SVGLine(
            generatorContext);
        svgPath =
          new org.apache.batik.svggen.SVGPath(
            generatorContext);
        svgPolygon =
          new org.apache.batik.svggen.SVGPolygon(
            generatorContext);
        svgRectangle =
          new org.apache.batik.svggen.SVGRectangle(
            generatorContext);
    }
    public org.w3c.dom.Element toSVG(java.awt.Shape shape) { if (shape instanceof java.awt.Polygon)
                                                                 return svgPolygon.
                                                                   toSVG(
                                                                     (java.awt.Polygon)
                                                                       shape);
                                                             else
                                                                 if (shape instanceof java.awt.geom.Rectangle2D)
                                                                     return svgRectangle.
                                                                       toSVG(
                                                                         (java.awt.geom.Rectangle2D)
                                                                           shape);
                                                                 else
                                                                     if (shape instanceof java.awt.geom.RoundRectangle2D)
                                                                         return svgRectangle.
                                                                           toSVG(
                                                                             (java.awt.geom.RoundRectangle2D)
                                                                               shape);
                                                                     else
                                                                         if (shape instanceof java.awt.geom.Ellipse2D)
                                                                             return svgEllipse.
                                                                               toSVG(
                                                                                 (java.awt.geom.Ellipse2D)
                                                                                   shape);
                                                                         else
                                                                             if (shape instanceof java.awt.geom.Line2D)
                                                                                 return svgLine.
                                                                                   toSVG(
                                                                                     (java.awt.geom.Line2D)
                                                                                       shape);
                                                                             else
                                                                                 if (shape instanceof java.awt.geom.Arc2D)
                                                                                     return svgArc.
                                                                                       toSVG(
                                                                                         (java.awt.geom.Arc2D)
                                                                                           shape);
                                                                                 else
                                                                                     return svgPath.
                                                                                       toSVG(
                                                                                         shape);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "ytb3GQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "XPF/AePnUBU9JQAA");
}
