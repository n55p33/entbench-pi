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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "3rQ6aT/bvf7Nj/23Z7gPbT/yJs7x3nOJzsso/970td8efb/ys1drD5zuZd9x" +
       "B+DioJcu7mBfD7U4CV3uwj72u08lW0n9RfCsjiW7urwnerZ2d98Q/cHD2t/n" +
       "EOaT9+n7VFn89bj2jKHFFw9eCdOOtZDVDldExhdP/27cj+KTbb7Hzx/KHA69" +
       "XjlTwp9+o22v86RWDT91SsNTZSMEntvHNNz+s5faq/fp+9tl8Qtx7enwsOcc" +
       "YZf2ost+8YzXv/U98Pp9ZeOz4HGOeXX+bHh9w2O/0t6kLD4yEPVoFEr+9vTC" +
       "ToXvi/eRz5fK4vNx7aHYY4XRyRTP3+dkcaBFSmj6J1d2Kql94XuQ2nNl4w+A" +
       "Jz2WWvrnIrXDuWMppYvGU439p/eR0K+VxVcuS+joPhLCzw6b7hTVP/weRPW2" +
       "2rG8vnAsqi+8WVEN7yeq8vVXKoB/cR95fLUsfh34jNMzNe68YJ4qBZOhypHq" +
       "OUflfTjt+Opaxf1vvBnucxAl77hlUh7dPX3HJbbDxSvlS6/eeOSdr/L/trpo" +
       "cXo56tFJ7RE9se3zp5Xn6g/7oaabFW+PHs4u/ervXwOluccql+cpVaWi+esH" +
       "+N+NazcvwwO1qf7Pw/2HuHb9DA6gOlTOg3wjrj0AQMrqN/0TyX7gXirXl6M4" +
       "lJS4Uj031UIQDfIrFwP96Qo8+UYrcC43eP+FiF5dMDyJvsn8+JD0y69Ssx//" +
       "Tvvzhzsiii0VRYnlkUnt2uG6ymkEf989sZ3geph84buP//Kjz59kG48fCD5T" +
       "6nO0vefuFzKGjh9XVyiKf/zOf/DBv/PqN6pjo/8HzZcRY/kpAAA=");
}
