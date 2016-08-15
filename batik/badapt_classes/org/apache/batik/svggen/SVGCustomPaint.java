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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "JhUAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
