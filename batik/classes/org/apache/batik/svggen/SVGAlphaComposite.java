package org.apache.batik.svggen;
public class SVGAlphaComposite extends org.apache.batik.svggen.AbstractSVGConverter {
    private java.util.Map compositeDefsMap = new java.util.HashMap();
    private boolean backgroundAccessRequired = false;
    public SVGAlphaComposite(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          generatorContext);
        compositeDefsMap.
          put(
            java.awt.AlphaComposite.
              Src,
            compositeToSVG(
              java.awt.AlphaComposite.
                Src));
        compositeDefsMap.
          put(
            java.awt.AlphaComposite.
              SrcIn,
            compositeToSVG(
              java.awt.AlphaComposite.
                SrcIn));
        compositeDefsMap.
          put(
            java.awt.AlphaComposite.
              SrcOut,
            compositeToSVG(
              java.awt.AlphaComposite.
                SrcOut));
        compositeDefsMap.
          put(
            java.awt.AlphaComposite.
              DstIn,
            compositeToSVG(
              java.awt.AlphaComposite.
                DstIn));
        compositeDefsMap.
          put(
            java.awt.AlphaComposite.
              DstOut,
            compositeToSVG(
              java.awt.AlphaComposite.
                DstOut));
        compositeDefsMap.
          put(
            java.awt.AlphaComposite.
              DstOver,
            compositeToSVG(
              java.awt.AlphaComposite.
                DstOver));
        compositeDefsMap.
          put(
            java.awt.AlphaComposite.
              Clear,
            compositeToSVG(
              java.awt.AlphaComposite.
                Clear));
    }
    public java.util.List getAlphaCompositeFilterSet() { return new java.util.LinkedList(
                                                           compositeDefsMap.
                                                             values(
                                                               ));
    }
    public boolean requiresBackgroundAccess() { return backgroundAccessRequired;
    }
    public org.apache.batik.svggen.SVGDescriptor toSVG(org.apache.batik.ext.awt.g2d.GraphicContext gc) {
        return toSVG(
                 (java.awt.AlphaComposite)
                   gc.
                   getComposite(
                     ));
    }
    public org.apache.batik.svggen.SVGCompositeDescriptor toSVG(java.awt.AlphaComposite composite) {
        org.apache.batik.svggen.SVGCompositeDescriptor compositeDesc =
          (org.apache.batik.svggen.SVGCompositeDescriptor)
            descMap.
            get(
              composite);
        if (compositeDesc ==
              null) {
            java.lang.String opacityValue =
              doubleString(
                composite.
                  getAlpha(
                    ));
            java.lang.String filterValue =
              null;
            org.w3c.dom.Element filterDef =
              null;
            if (composite.
                  getRule(
                    ) !=
                  java.awt.AlphaComposite.
                    SRC_OVER) {
                java.awt.AlphaComposite majorComposite =
                  java.awt.AlphaComposite.
                  getInstance(
                    composite.
                      getRule(
                        ));
                filterDef =
                  (org.w3c.dom.Element)
                    compositeDefsMap.
                    get(
                      majorComposite);
                defSet.
                  add(
                    filterDef);
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
                filterValue =
                  filterAttrBuf.
                    toString(
                      );
            }
            else
                filterValue =
                  SVG_NONE_VALUE;
            compositeDesc =
              new org.apache.batik.svggen.SVGCompositeDescriptor(
                opacityValue,
                filterValue,
                filterDef);
            descMap.
              put(
                composite,
                compositeDesc);
        }
        if (composite.
              getRule(
                ) !=
              java.awt.AlphaComposite.
                SRC_OVER)
            backgroundAccessRequired =
              true;
        return compositeDesc;
    }
    private org.w3c.dom.Element compositeToSVG(java.awt.AlphaComposite composite) {
        java.lang.String operator =
          null;
        java.lang.String input1 =
          null;
        java.lang.String input2 =
          null;
        java.lang.String k2 =
          "0";
        java.lang.String id =
          null;
        switch (composite.
                  getRule(
                    )) {
            case java.awt.AlphaComposite.
                   CLEAR:
                operator =
                  SVG_ARITHMETIC_VALUE;
                input1 =
                  SVG_SOURCE_GRAPHIC_VALUE;
                input2 =
                  SVG_BACKGROUND_IMAGE_VALUE;
                id =
                  ID_PREFIX_ALPHA_COMPOSITE_CLEAR;
                break;
            case java.awt.AlphaComposite.
                   SRC:
                operator =
                  SVG_ARITHMETIC_VALUE;
                input1 =
                  SVG_SOURCE_GRAPHIC_VALUE;
                input2 =
                  SVG_BACKGROUND_IMAGE_VALUE;
                id =
                  ID_PREFIX_ALPHA_COMPOSITE_SRC;
                k2 =
                  SVG_DIGIT_ONE_VALUE;
                break;
            case java.awt.AlphaComposite.
                   SRC_IN:
                operator =
                  SVG_IN_VALUE;
                input1 =
                  SVG_SOURCE_GRAPHIC_VALUE;
                input2 =
                  SVG_BACKGROUND_IMAGE_VALUE;
                id =
                  ID_PREFIX_ALPHA_COMPOSITE_SRC_IN;
                break;
            case java.awt.AlphaComposite.
                   SRC_OUT:
                operator =
                  SVG_OUT_VALUE;
                input1 =
                  SVG_SOURCE_GRAPHIC_VALUE;
                input2 =
                  SVG_BACKGROUND_IMAGE_VALUE;
                id =
                  ID_PREFIX_ALPHA_COMPOSITE_SRC_OUT;
                break;
            case java.awt.AlphaComposite.
                   DST_IN:
                operator =
                  SVG_IN_VALUE;
                input2 =
                  SVG_SOURCE_GRAPHIC_VALUE;
                input1 =
                  SVG_BACKGROUND_IMAGE_VALUE;
                id =
                  ID_PREFIX_ALPHA_COMPOSITE_DST_IN;
                break;
            case java.awt.AlphaComposite.
                   DST_OUT:
                operator =
                  SVG_OUT_VALUE;
                input2 =
                  SVG_SOURCE_GRAPHIC_VALUE;
                input1 =
                  SVG_BACKGROUND_IMAGE_VALUE;
                id =
                  ID_PREFIX_ALPHA_COMPOSITE_DST_OUT;
                break;
            case java.awt.AlphaComposite.
                   DST_OVER:
                operator =
                  SVG_OVER_VALUE;
                input2 =
                  SVG_SOURCE_GRAPHIC_VALUE;
                input1 =
                  SVG_BACKGROUND_IMAGE_VALUE;
                id =
                  ID_PREFIX_ALPHA_COMPOSITE_DST_OVER;
                break;
            default:
                throw new java.lang.Error(
                  "invalid rule:" +
                  composite.
                    getRule(
                      ));
        }
        org.w3c.dom.Element compositeFilter =
          generatorContext.
            domFactory.
          createElementNS(
            SVG_NAMESPACE_URI,
            SVG_FILTER_TAG);
        compositeFilter.
          setAttributeNS(
            null,
            SVG_ID_ATTRIBUTE,
            id);
        compositeFilter.
          setAttributeNS(
            null,
            SVG_FILTER_UNITS_ATTRIBUTE,
            SVG_OBJECT_BOUNDING_BOX_VALUE);
        compositeFilter.
          setAttributeNS(
            null,
            SVG_X_ATTRIBUTE,
            SVG_ZERO_PERCENT_VALUE);
        compositeFilter.
          setAttributeNS(
            null,
            SVG_Y_ATTRIBUTE,
            SVG_ZERO_PERCENT_VALUE);
        compositeFilter.
          setAttributeNS(
            null,
            SVG_WIDTH_ATTRIBUTE,
            SVG_HUNDRED_PERCENT_VALUE);
        compositeFilter.
          setAttributeNS(
            null,
            SVG_HEIGHT_ATTRIBUTE,
            SVG_HUNDRED_PERCENT_VALUE);
        org.w3c.dom.Element feComposite =
          generatorContext.
            domFactory.
          createElementNS(
            SVG_NAMESPACE_URI,
            SVG_FE_COMPOSITE_TAG);
        feComposite.
          setAttributeNS(
            null,
            SVG_OPERATOR_ATTRIBUTE,
            operator);
        feComposite.
          setAttributeNS(
            null,
            SVG_IN_ATTRIBUTE,
            input1);
        feComposite.
          setAttributeNS(
            null,
            SVG_IN2_ATTRIBUTE,
            input2);
        feComposite.
          setAttributeNS(
            null,
            SVG_K2_ATTRIBUTE,
            k2);
        feComposite.
          setAttributeNS(
            null,
            SVG_RESULT_ATTRIBUTE,
            SVG_COMPOSITE_VALUE);
        org.w3c.dom.Element feFlood =
          generatorContext.
            domFactory.
          createElementNS(
            SVG_NAMESPACE_URI,
            SVG_FE_FLOOD_TAG);
        feFlood.
          setAttributeNS(
            null,
            SVG_FLOOD_COLOR_ATTRIBUTE,
            "white");
        feFlood.
          setAttributeNS(
            null,
            SVG_FLOOD_OPACITY_ATTRIBUTE,
            "1");
        feFlood.
          setAttributeNS(
            null,
            SVG_RESULT_ATTRIBUTE,
            SVG_FLOOD_VALUE);
        org.w3c.dom.Element feMerge =
          generatorContext.
            domFactory.
          createElementNS(
            SVG_NAMESPACE_URI,
            SVG_FE_MERGE_TAG);
        org.w3c.dom.Element feMergeNodeFlood =
          generatorContext.
            domFactory.
          createElementNS(
            SVG_NAMESPACE_URI,
            SVG_FE_MERGE_NODE_TAG);
        feMergeNodeFlood.
          setAttributeNS(
            null,
            SVG_IN_ATTRIBUTE,
            SVG_FLOOD_VALUE);
        org.w3c.dom.Element feMergeNodeComposite =
          generatorContext.
            domFactory.
          createElementNS(
            SVG_NAMESPACE_URI,
            SVG_FE_MERGE_NODE_TAG);
        feMergeNodeComposite.
          setAttributeNS(
            null,
            SVG_IN_ATTRIBUTE,
            SVG_COMPOSITE_VALUE);
        feMerge.
          appendChild(
            feMergeNodeFlood);
        feMerge.
          appendChild(
            feMergeNodeComposite);
        compositeFilter.
          appendChild(
            feFlood);
        compositeFilter.
          appendChild(
            feComposite);
        compositeFilter.
          appendChild(
            feMerge);
        return compositeFilter;
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
      ("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" +
       "AA==");
}
