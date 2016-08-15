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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "PhUAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AA==");
}
