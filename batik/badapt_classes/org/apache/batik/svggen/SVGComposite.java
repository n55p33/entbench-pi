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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "cL8nXrF5/z+JryKFch4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ZAEp/ZOb/+iB333iW/m11v8DF7wo6P4oAAA=");
}
