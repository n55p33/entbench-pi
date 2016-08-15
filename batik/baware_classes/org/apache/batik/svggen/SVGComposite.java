package org.apache.batik.svggen;
public class SVGComposite implements org.apache.batik.svggen.SVGConverter {
    private org.apache.batik.svggen.SVGAlphaComposite svgAlphaComposite;
    private org.apache.batik.svggen.SVGCustomComposite svgCustomComposite;
    public SVGComposite(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          );
        this.
          svgAlphaComposite =
          new org.apache.batik.svggen.SVGAlphaComposite(
            generatorContext);
        this.
          svgCustomComposite =
          new org.apache.batik.svggen.SVGCustomComposite(
            generatorContext);
    }
    public java.util.List getDefinitionSet() { java.util.List compositeDefs =
                                                 new java.util.LinkedList(
                                                 svgAlphaComposite.
                                                   getDefinitionSet(
                                                     ));
                                               compositeDefs.addAll(
                                                               svgCustomComposite.
                                                                 getDefinitionSet(
                                                                   ));
                                               return compositeDefs;
    }
    public org.apache.batik.svggen.SVGAlphaComposite getAlphaCompositeConverter() {
        return svgAlphaComposite;
    }
    public org.apache.batik.svggen.SVGCustomComposite getCustomCompositeConverter() {
        return svgCustomComposite;
    }
    public org.apache.batik.svggen.SVGDescriptor toSVG(org.apache.batik.ext.awt.g2d.GraphicContext gc) {
        return toSVG(
                 gc.
                   getComposite(
                     ));
    }
    public org.apache.batik.svggen.SVGCompositeDescriptor toSVG(java.awt.Composite composite) {
        if (composite instanceof java.awt.AlphaComposite)
            return svgAlphaComposite.
              toSVG(
                (java.awt.AlphaComposite)
                  composite);
        else
            return svgCustomComposite.
              toSVG(
                composite);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "uN8Xr9h88B9yLaw4ch4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "pRfmzwo2f3rzH7/x9x7/dn6t9f+Bw77i/igAAA==");
}
