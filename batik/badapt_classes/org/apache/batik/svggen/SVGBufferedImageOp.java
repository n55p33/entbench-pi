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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "VvUfmgX/MxchAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
