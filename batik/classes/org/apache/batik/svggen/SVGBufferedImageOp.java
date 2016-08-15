package org.apache.batik.svggen;
public class SVGBufferedImageOp extends org.apache.batik.svggen.AbstractSVGFilterConverter {
    private org.apache.batik.svggen.SVGLookupOp svgLookupOp;
    private org.apache.batik.svggen.SVGRescaleOp svgRescaleOp;
    private org.apache.batik.svggen.SVGConvolveOp svgConvolveOp;
    private org.apache.batik.svggen.SVGCustomBufferedImageOp svgCustomBufferedImageOp;
    public SVGBufferedImageOp(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          generatorContext);
        this.
          svgLookupOp =
          new org.apache.batik.svggen.SVGLookupOp(
            generatorContext);
        this.
          svgRescaleOp =
          new org.apache.batik.svggen.SVGRescaleOp(
            generatorContext);
        this.
          svgConvolveOp =
          new org.apache.batik.svggen.SVGConvolveOp(
            generatorContext);
        this.
          svgCustomBufferedImageOp =
          new org.apache.batik.svggen.SVGCustomBufferedImageOp(
            generatorContext);
    }
    public java.util.List getDefinitionSet() { java.util.List filterSet =
                                                 new java.util.LinkedList(
                                                 svgLookupOp.
                                                   getDefinitionSet(
                                                     ));
                                               filterSet.addAll(svgRescaleOp.
                                                                  getDefinitionSet(
                                                                    ));
                                               filterSet.
                                                 addAll(
                                                   svgConvolveOp.
                                                     getDefinitionSet(
                                                       ));
                                               filterSet.
                                                 addAll(
                                                   svgCustomBufferedImageOp.
                                                     getDefinitionSet(
                                                       ));
                                               return filterSet;
    }
    public org.apache.batik.svggen.SVGLookupOp getLookupOpConverter() {
        return svgLookupOp;
    }
    public org.apache.batik.svggen.SVGRescaleOp getRescaleOpConverter() {
        return svgRescaleOp;
    }
    public org.apache.batik.svggen.SVGConvolveOp getConvolveOpConverter() {
        return svgConvolveOp;
    }
    public org.apache.batik.svggen.SVGCustomBufferedImageOp getCustomBufferedImageOpConverter() {
        return svgCustomBufferedImageOp;
    }
    public org.apache.batik.svggen.SVGFilterDescriptor toSVG(java.awt.image.BufferedImageOp op,
                                                             java.awt.Rectangle filterRect) {
        org.apache.batik.svggen.SVGFilterDescriptor filterDesc =
          svgCustomBufferedImageOp.
          toSVG(
            op,
            filterRect);
        if (filterDesc ==
              null) {
            if (op instanceof java.awt.image.LookupOp)
                filterDesc =
                  svgLookupOp.
                    toSVG(
                      op,
                      filterRect);
            else
                if (op instanceof java.awt.image.RescaleOp)
                    filterDesc =
                      svgRescaleOp.
                        toSVG(
                          op,
                          filterRect);
                else
                    if (op instanceof java.awt.image.ConvolveOp)
                        filterDesc =
                          svgConvolveOp.
                            toSVG(
                              op,
                              filterRect);
        }
        return filterDesc;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "VvUfFDPC2BchAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AA==");
}
