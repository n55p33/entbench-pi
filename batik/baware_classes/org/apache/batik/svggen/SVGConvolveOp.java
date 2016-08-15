package org.apache.batik.svggen;
public class SVGConvolveOp extends org.apache.batik.svggen.AbstractSVGFilterConverter {
    public SVGConvolveOp(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          generatorContext);
    }
    public org.apache.batik.svggen.SVGFilterDescriptor toSVG(java.awt.image.BufferedImageOp filter,
                                                             java.awt.Rectangle filterRect) {
        if (filter instanceof java.awt.image.ConvolveOp)
            return toSVG(
                     (java.awt.image.ConvolveOp)
                       filter);
        else
            return null;
    }
    public org.apache.batik.svggen.SVGFilterDescriptor toSVG(java.awt.image.ConvolveOp convolveOp) {
        org.apache.batik.svggen.SVGFilterDescriptor filterDesc =
          (org.apache.batik.svggen.SVGFilterDescriptor)
            descMap.
            get(
              convolveOp);
        org.w3c.dom.Document domFactory =
          generatorContext.
            domFactory;
        if (filterDesc ==
              null) {
            java.awt.image.Kernel kernel =
              convolveOp.
              getKernel(
                );
            org.w3c.dom.Element filterDef =
              domFactory.
              createElementNS(
                SVG_NAMESPACE_URI,
                SVG_FILTER_TAG);
            org.w3c.dom.Element feConvolveMatrixDef =
              domFactory.
              createElementNS(
                SVG_NAMESPACE_URI,
                SVG_FE_CONVOLVE_MATRIX_TAG);
            feConvolveMatrixDef.
              setAttributeNS(
                null,
                SVG_ORDER_ATTRIBUTE,
                kernel.
                  getWidth(
                    ) +
                SPACE +
                kernel.
                  getHeight(
                    ));
            float[] data =
              kernel.
              getKernelData(
                null);
            java.lang.StringBuffer kernelMatrixBuf =
              new java.lang.StringBuffer(
              data.
                length *
                8);
            for (int i =
                   0;
                 i <
                   data.
                     length;
                 i++) {
                kernelMatrixBuf.
                  append(
                    doubleString(
                      data[i]));
                kernelMatrixBuf.
                  append(
                    SPACE);
            }
            feConvolveMatrixDef.
              setAttributeNS(
                null,
                SVG_KERNEL_MATRIX_ATTRIBUTE,
                kernelMatrixBuf.
                  toString(
                    ).
                  trim(
                    ));
            filterDef.
              appendChild(
                feConvolveMatrixDef);
            filterDef.
              setAttributeNS(
                null,
                SVG_ID_ATTRIBUTE,
                generatorContext.
                  idGenerator.
                  generateID(
                    ID_PREFIX_FE_CONVOLVE_MATRIX));
            if (convolveOp.
                  getEdgeCondition(
                    ) ==
                  java.awt.image.ConvolveOp.
                    EDGE_NO_OP)
                feConvolveMatrixDef.
                  setAttributeNS(
                    null,
                    SVG_EDGE_MODE_ATTRIBUTE,
                    SVG_DUPLICATE_VALUE);
            else
                feConvolveMatrixDef.
                  setAttributeNS(
                    null,
                    SVG_EDGE_MODE_ATTRIBUTE,
                    SVG_NONE_VALUE);
            java.lang.StringBuffer filterAttrBuf =
              new java.lang.StringBuffer(
              URL_PREFIX);
            filterAttrBuf.
              append(
                SIGN_POUND);
            filterAttrBuf.
              append(
                filterDef.
                  getAttributeNS(
                    null,
                    SVG_ID_ATTRIBUTE));
            filterAttrBuf.
              append(
                URL_SUFFIX);
            filterDesc =
              new org.apache.batik.svggen.SVGFilterDescriptor(
                filterAttrBuf.
                  toString(
                    ),
                filterDef);
            defSet.
              add(
                filterDef);
            descMap.
              put(
                convolveOp,
                filterDesc);
        }
        return filterDesc;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "vyRueXPl3xVSsdAZFQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/77ffcdvvvT1rAb437p2dMmPIAAA");
}
