package org.apache.batik.svggen;
public class SVGCustomComposite extends org.apache.batik.svggen.AbstractSVGConverter {
    public SVGCustomComposite(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          generatorContext);
    }
    public org.apache.batik.svggen.SVGDescriptor toSVG(org.apache.batik.ext.awt.g2d.GraphicContext gc) {
        return toSVG(
                 gc.
                   getComposite(
                     ));
    }
    public org.apache.batik.svggen.SVGCompositeDescriptor toSVG(java.awt.Composite composite) {
        if (composite ==
              null)
            throw new java.lang.NullPointerException(
              );
        org.apache.batik.svggen.SVGCompositeDescriptor compositeDesc =
          (org.apache.batik.svggen.SVGCompositeDescriptor)
            descMap.
            get(
              composite);
        if (compositeDesc ==
              null) {
            org.apache.batik.svggen.SVGCompositeDescriptor desc =
              generatorContext.
                extensionHandler.
              handleComposite(
                composite,
                generatorContext);
            if (desc !=
                  null) {
                org.w3c.dom.Element def =
                  desc.
                  getDef(
                    );
                if (def !=
                      null)
                    defSet.
                      add(
                        def);
                descMap.
                  put(
                    composite,
                    desc);
            }
        }
        return compositeDesc;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "PhUAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "qCAAAA==");
}
