package org.apache.batik.svggen;
public abstract class SVGGraphicObjectConverter implements org.apache.batik.svggen.SVGSyntax {
    protected org.apache.batik.svggen.SVGGeneratorContext generatorContext;
    public SVGGraphicObjectConverter(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          );
        if (generatorContext ==
              null)
            throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
              org.apache.batik.svggen.ErrorConstants.
                ERR_CONTEXT_NULL);
        this.
          generatorContext =
          generatorContext;
    }
    public final java.lang.String doubleString(double value) { return generatorContext.
                                                                 doubleString(
                                                                   value);
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
