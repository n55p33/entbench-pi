package org.apache.batik.bridge;
public class SVGFeBlendElementBridge extends org.apache.batik.bridge.AbstractSVGFilterPrimitiveElementBridge {
    public SVGFeBlendElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_FE_BLEND_TAG; }
    public org.apache.batik.ext.awt.image.renderable.Filter createFilter(org.apache.batik.bridge.BridgeContext ctx,
                                                                         org.w3c.dom.Element filterElement,
                                                                         org.w3c.dom.Element filteredElement,
                                                                         org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                         org.apache.batik.ext.awt.image.renderable.Filter inputFilter,
                                                                         java.awt.geom.Rectangle2D filterRegion,
                                                                         java.util.Map filterMap) {
        org.apache.batik.ext.awt.image.CompositeRule rule =
          convertMode(
            filterElement,
            ctx);
        org.apache.batik.ext.awt.image.renderable.Filter in =
          getIn(
            filterElement,
            filteredElement,
            filteredNode,
            inputFilter,
            filterMap,
            ctx);
        if (in ==
              null) {
            return null;
        }
        org.apache.batik.ext.awt.image.renderable.Filter in2 =
          getIn2(
            filterElement,
            filteredElement,
            filteredNode,
            inputFilter,
            filterMap,
            ctx);
        if (in2 ==
              null) {
            return null;
        }
        java.awt.geom.Rectangle2D defaultRegion;
        defaultRegion =
          (java.awt.geom.Rectangle2D)
            in.
            getBounds2D(
              ).
            clone(
              );
        defaultRegion.
          add(
            in2.
              getBounds2D(
                ));
        java.awt.geom.Rectangle2D primitiveRegion =
          org.apache.batik.bridge.SVGUtilities.
          convertFilterPrimitiveRegion(
            filterElement,
            filteredElement,
            filteredNode,
            defaultRegion,
            filterRegion,
            ctx);
        java.util.List srcs =
          new java.util.ArrayList(
          2);
        srcs.
          add(
            in2);
        srcs.
          add(
            in);
        org.apache.batik.ext.awt.image.renderable.Filter filter =
          new org.apache.batik.ext.awt.image.renderable.CompositeRable8Bit(
          srcs,
          rule,
          true);
        handleColorInterpolationFilters(
          filter,
          filterElement);
        filter =
          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
            filter,
            primitiveRegion,
            org.apache.batik.ext.awt.image.PadMode.
              ZERO_PAD);
        updateFilterMap(
          filterElement,
          filter,
          filterMap);
        return filter;
    }
    protected static org.apache.batik.ext.awt.image.CompositeRule convertMode(org.w3c.dom.Element filterElement,
                                                                              org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String rule =
          filterElement.
          getAttributeNS(
            null,
            SVG_MODE_ATTRIBUTE);
        if (rule.
              length(
                ) ==
              0) {
            return org.apache.batik.ext.awt.image.CompositeRule.
                     OVER;
        }
        if (SVG_NORMAL_VALUE.
              equals(
                rule)) {
            return org.apache.batik.ext.awt.image.CompositeRule.
                     OVER;
        }
        if (SVG_MULTIPLY_VALUE.
              equals(
                rule)) {
            return org.apache.batik.ext.awt.image.CompositeRule.
                     MULTIPLY;
        }
        if (SVG_SCREEN_VALUE.
              equals(
                rule)) {
            return org.apache.batik.ext.awt.image.CompositeRule.
                     SCREEN;
        }
        if (SVG_DARKEN_VALUE.
              equals(
                rule)) {
            return org.apache.batik.ext.awt.image.CompositeRule.
                     DARKEN;
        }
        if (SVG_LIGHTEN_VALUE.
              equals(
                rule)) {
            return org.apache.batik.ext.awt.image.CompositeRule.
                     LIGHTEN;
        }
        throw new org.apache.batik.bridge.BridgeException(
          ctx,
          filterElement,
          ERR_ATTRIBUTE_VALUE_MALFORMED,
          new java.lang.Object[] { SVG_MODE_ATTRIBUTE,
          rule });
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "efGKzQv/BvSA34SaGQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "EXuH9/0Hp7fvJ6eAt15X2sV2kWz923IsD+Tthaz5+a2asu4bgVuHeeoJVhim" +
       "K9v5xo9HwMRs9cI+dgGkokAnFxY2lqN5LUi+c3PKuN/d5m/bgJa1pRzF1iQq" +
       "VzSfN2+h8pPrlkNkXQ+kgh/856e+8eGHvgN0ykDXrTJ5A1Ue2ZGLs+z4fc9/" +
       "9J4bn/7uB/MoBUKU8Gsv3/14hrV7NY6zppk1rX1W785Y5fNDvyuHEZsHFl3L" +
       "ub2qKfcD0wHxd7WX+sFP3PYd6xPf+9w2rTtptyeA9Q88/Rs/3f3Q0ztHkumH" +
       "Lslnj67ZJtQ50TfvSTiAHrjaLvmK1r+88MQff+aJ92+puu14atgEbz6f++v/" +
       "/sbuM9/92mUykWtt72dQbHTz9yg0pPH9T7c4lUvrcTERC5O4Xy6hjUo7xdsb" +
       "s4chTVyRV531YoA4cqEvJ60uN8UsTC9r5VovZVmqP5lYaSp0goFgibTlDcW1" +
       "Tdt+nRDny/my2JEqm5Zo9RkeaZr20rHkOd9z+j5R7Iy5EdIolzS1pDlSWSoV" +
       "UbO0lMVKD8PKZaq/6uk6Vk7tctdeLyRZaoi+25nBGy8Nk9mi5lFLsb0Ruxox" +
       "mrCrelO0GGTlM2sVbnMzke6JC5+sMOmkyjjLZCJZAUsRk67ETSyBEac9tTEl" +
       "2yrbDhMrWSzscCn3rJWzKUkG3xIcXldq4nQzWw88ZC3LHbVdppFUcIxgSowk" +
       "kZry40XIcCOfKqC0VfQZBC1U0VlYR6OS3pSGbCzGkkvybbLOJW3LT8WB05Ik" +
       "rizhm81A08fe2m6hSFtEVYrc2IrSUFakCHMq0pfYdVUtj8ypMh+snLE9EWKS" +
       "7FPtjuN7m1RkZkjcReqEFUvD2oz0ySErL1LC7fKUOxbIsD2jW64YarIwq5cF" +
       "diTrVU5s9rSUF6oJE5tMT4jHPiJHxDgQpQHWsBCB6iraoikFrdIw0uQNG8LN" +
       "JNWbo0W9Evabri8P5zY5oquLRjxEGU5tza1WI+2M7ZbjMKWkTcecZU6F2aLM" +
       "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" +
       "AZj+4Z2//5ZPP/ft/E7hfwGuGH2dySQAAA==");
}
