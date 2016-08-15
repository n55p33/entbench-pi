package org.apache.batik.svggen;
public class SVGRescaleOp extends org.apache.batik.svggen.AbstractSVGFilterConverter {
    public SVGRescaleOp(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          generatorContext);
    }
    public org.apache.batik.svggen.SVGFilterDescriptor toSVG(java.awt.image.BufferedImageOp filter,
                                                             java.awt.Rectangle filterRect) {
        if (filter instanceof java.awt.image.RescaleOp)
            return toSVG(
                     (java.awt.image.RescaleOp)
                       filter);
        else
            return null;
    }
    public org.apache.batik.svggen.SVGFilterDescriptor toSVG(java.awt.image.RescaleOp rescaleOp) {
        org.apache.batik.svggen.SVGFilterDescriptor filterDesc =
          (org.apache.batik.svggen.SVGFilterDescriptor)
            descMap.
            get(
              rescaleOp);
        org.w3c.dom.Document domFactory =
          generatorContext.
            domFactory;
        if (filterDesc ==
              null) {
            org.w3c.dom.Element filterDef =
              domFactory.
              createElementNS(
                SVG_NAMESPACE_URI,
                SVG_FILTER_TAG);
            org.w3c.dom.Element feComponentTransferDef =
              domFactory.
              createElementNS(
                SVG_NAMESPACE_URI,
                SVG_FE_COMPONENT_TRANSFER_TAG);
            float[] offsets =
              rescaleOp.
              getOffsets(
                null);
            float[] scaleFactors =
              rescaleOp.
              getScaleFactors(
                null);
            if (offsets.
                  length !=
                  scaleFactors.
                    length)
                throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
                  ERR_SCALE_FACTORS_AND_OFFSETS_MISMATCH);
            if (offsets.
                  length !=
                  1 &&
                  offsets.
                    length !=
                  3 &&
                  offsets.
                    length !=
                  4)
                throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
                  ERR_ILLEGAL_BUFFERED_IMAGE_RESCALE_OP);
            org.w3c.dom.Element feFuncR =
              domFactory.
              createElementNS(
                SVG_NAMESPACE_URI,
                SVG_FE_FUNC_R_TAG);
            org.w3c.dom.Element feFuncG =
              domFactory.
              createElementNS(
                SVG_NAMESPACE_URI,
                SVG_FE_FUNC_G_TAG);
            org.w3c.dom.Element feFuncB =
              domFactory.
              createElementNS(
                SVG_NAMESPACE_URI,
                SVG_FE_FUNC_B_TAG);
            org.w3c.dom.Element feFuncA =
              null;
            java.lang.String type =
              SVG_LINEAR_VALUE;
            if (offsets.
                  length ==
                  1) {
                java.lang.String slope =
                  doubleString(
                    scaleFactors[0]);
                java.lang.String intercept =
                  doubleString(
                    offsets[0]);
                feFuncR.
                  setAttributeNS(
                    null,
                    SVG_TYPE_ATTRIBUTE,
                    type);
                feFuncG.
                  setAttributeNS(
                    null,
                    SVG_TYPE_ATTRIBUTE,
                    type);
                feFuncB.
                  setAttributeNS(
                    null,
                    SVG_TYPE_ATTRIBUTE,
                    type);
                feFuncR.
                  setAttributeNS(
                    null,
                    SVG_SLOPE_ATTRIBUTE,
                    slope);
                feFuncG.
                  setAttributeNS(
                    null,
                    SVG_SLOPE_ATTRIBUTE,
                    slope);
                feFuncB.
                  setAttributeNS(
                    null,
                    SVG_SLOPE_ATTRIBUTE,
                    slope);
                feFuncR.
                  setAttributeNS(
                    null,
                    SVG_INTERCEPT_ATTRIBUTE,
                    intercept);
                feFuncG.
                  setAttributeNS(
                    null,
                    SVG_INTERCEPT_ATTRIBUTE,
                    intercept);
                feFuncB.
                  setAttributeNS(
                    null,
                    SVG_INTERCEPT_ATTRIBUTE,
                    intercept);
            }
            else
                if (offsets.
                      length >=
                      3) {
                    feFuncR.
                      setAttributeNS(
                        null,
                        SVG_TYPE_ATTRIBUTE,
                        type);
                    feFuncG.
                      setAttributeNS(
                        null,
                        SVG_TYPE_ATTRIBUTE,
                        type);
                    feFuncB.
                      setAttributeNS(
                        null,
                        SVG_TYPE_ATTRIBUTE,
                        type);
                    feFuncR.
                      setAttributeNS(
                        null,
                        SVG_SLOPE_ATTRIBUTE,
                        doubleString(
                          scaleFactors[0]));
                    feFuncG.
                      setAttributeNS(
                        null,
                        SVG_SLOPE_ATTRIBUTE,
                        doubleString(
                          scaleFactors[1]));
                    feFuncB.
                      setAttributeNS(
                        null,
                        SVG_SLOPE_ATTRIBUTE,
                        doubleString(
                          scaleFactors[2]));
                    feFuncR.
                      setAttributeNS(
                        null,
                        SVG_INTERCEPT_ATTRIBUTE,
                        doubleString(
                          offsets[0]));
                    feFuncG.
                      setAttributeNS(
                        null,
                        SVG_INTERCEPT_ATTRIBUTE,
                        doubleString(
                          offsets[1]));
                    feFuncB.
                      setAttributeNS(
                        null,
                        SVG_INTERCEPT_ATTRIBUTE,
                        doubleString(
                          offsets[2]));
                    if (offsets.
                          length ==
                          4) {
                        feFuncA =
                          domFactory.
                            createElementNS(
                              SVG_NAMESPACE_URI,
                              SVG_FE_FUNC_A_TAG);
                        feFuncA.
                          setAttributeNS(
                            null,
                            SVG_TYPE_ATTRIBUTE,
                            type);
                        feFuncA.
                          setAttributeNS(
                            null,
                            SVG_SLOPE_ATTRIBUTE,
                            doubleString(
                              scaleFactors[3]));
                        feFuncA.
                          setAttributeNS(
                            null,
                            SVG_INTERCEPT_ATTRIBUTE,
                            doubleString(
                              offsets[3]));
                    }
                }
            feComponentTransferDef.
              appendChild(
                feFuncR);
            feComponentTransferDef.
              appendChild(
                feFuncG);
            feComponentTransferDef.
              appendChild(
                feFuncB);
            if (feFuncA !=
                  null)
                feComponentTransferDef.
                  appendChild(
                    feFuncA);
            filterDef.
              appendChild(
                feComponentTransferDef);
            filterDef.
              setAttributeNS(
                null,
                SVG_ID_ATTRIBUTE,
                generatorContext.
                  idGenerator.
                  generateID(
                    ID_PREFIX_FE_COMPONENT_TRANSFER));
            java.lang.String filterAttrBuf =
              URL_PREFIX +
            SIGN_POUND +
            filterDef.
              getAttributeNS(
                null,
                SVG_ID_ATTRIBUTE) +
            URL_SUFFIX;
            filterDesc =
              new org.apache.batik.svggen.SVGFilterDescriptor(
                filterAttrBuf,
                filterDef);
            defSet.
              add(
                filterDef);
            descMap.
              put(
                rescaleOp,
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
       "S/yWNVf+DUVeeeoUFQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "8Csw0YogAAA=");
}
