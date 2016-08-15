package org.apache.batik.svggen;
public abstract class AbstractSVGFilterConverter implements org.apache.batik.svggen.SVGFilterConverter, org.apache.batik.svggen.ErrorConstants {
    protected org.apache.batik.svggen.SVGGeneratorContext generatorContext;
    protected java.util.Map descMap = new java.util.HashMap();
    protected java.util.List defSet = new java.util.LinkedList();
    public AbstractSVGFilterConverter(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          );
        if (generatorContext ==
              null)
            throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
              ERR_CONTEXT_NULL);
        this.
          generatorContext =
          generatorContext;
    }
    public java.util.List getDefinitionSet() { return defSet; }
    public final java.lang.String doubleString(double value) { return generatorContext.
                                                                 doubleString(
                                                                   value);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Kx0AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "LGFuJycAAA==");
}
