package org.apache.batik.svggen;
public class SVGCustomPaint extends org.apache.batik.svggen.AbstractSVGConverter {
    public SVGCustomPaint(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          generatorContext);
    }
    public org.apache.batik.svggen.SVGDescriptor toSVG(org.apache.batik.ext.awt.g2d.GraphicContext gc) {
        return toSVG(
                 gc.
                   getPaint(
                     ));
    }
    public org.apache.batik.svggen.SVGPaintDescriptor toSVG(java.awt.Paint paint) {
        org.apache.batik.svggen.SVGPaintDescriptor paintDesc =
          (org.apache.batik.svggen.SVGPaintDescriptor)
            descMap.
            get(
              paint);
        if (paintDesc ==
              null) {
            paintDesc =
              generatorContext.
                extensionHandler.
                handlePaint(
                  paint,
                  generatorContext);
            if (paintDesc !=
                  null) {
                org.w3c.dom.Element def =
                  paintDesc.
                  getDef(
                    );
                if (def !=
                      null)
                    defSet.
                      add(
                        def);
                descMap.
                  put(
                    paint,
                    paintDesc);
            }
        }
        return paintDesc;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "JhUAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AAA=");
}
