package org.apache.batik.svggen;
public class SVGLinearGradient extends org.apache.batik.svggen.AbstractSVGConverter {
    public SVGLinearGradient(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          generatorContext);
    }
    public org.apache.batik.svggen.SVGDescriptor toSVG(org.apache.batik.ext.awt.g2d.GraphicContext gc) {
        java.awt.Paint paint =
          gc.
          getPaint(
            );
        return toSVG(
                 (java.awt.GradientPaint)
                   paint);
    }
    public org.apache.batik.svggen.SVGPaintDescriptor toSVG(java.awt.GradientPaint gradient) {
        org.apache.batik.svggen.SVGPaintDescriptor gradientDesc =
          (org.apache.batik.svggen.SVGPaintDescriptor)
            descMap.
            get(
              gradient);
        org.w3c.dom.Document domFactory =
          generatorContext.
            domFactory;
        if (gradientDesc ==
              null) {
            org.w3c.dom.Element gradientDef =
              domFactory.
              createElementNS(
                SVG_NAMESPACE_URI,
                SVG_LINEAR_GRADIENT_TAG);
            gradientDef.
              setAttributeNS(
                null,
                SVG_GRADIENT_UNITS_ATTRIBUTE,
                SVG_USER_SPACE_ON_USE_VALUE);
            java.awt.geom.Point2D p1 =
              gradient.
              getPoint1(
                );
            java.awt.geom.Point2D p2 =
              gradient.
              getPoint2(
                );
            gradientDef.
              setAttributeNS(
                null,
                SVG_X1_ATTRIBUTE,
                doubleString(
                  p1.
                    getX(
                      )));
            gradientDef.
              setAttributeNS(
                null,
                SVG_Y1_ATTRIBUTE,
                doubleString(
                  p1.
                    getY(
                      )));
            gradientDef.
              setAttributeNS(
                null,
                SVG_X2_ATTRIBUTE,
                doubleString(
                  p2.
                    getX(
                      )));
            gradientDef.
              setAttributeNS(
                null,
                SVG_Y2_ATTRIBUTE,
                doubleString(
                  p2.
                    getY(
                      )));
            java.lang.String spreadMethod =
              SVG_PAD_VALUE;
            if (gradient.
                  isCyclic(
                    ))
                spreadMethod =
                  SVG_REFLECT_VALUE;
            gradientDef.
              setAttributeNS(
                null,
                SVG_SPREAD_METHOD_ATTRIBUTE,
                spreadMethod);
            org.w3c.dom.Element gradientStop =
              domFactory.
              createElementNS(
                SVG_NAMESPACE_URI,
                SVG_STOP_TAG);
            gradientStop.
              setAttributeNS(
                null,
                SVG_OFFSET_ATTRIBUTE,
                SVG_ZERO_PERCENT_VALUE);
            org.apache.batik.svggen.SVGPaintDescriptor colorDesc =
              org.apache.batik.svggen.SVGColor.
              toSVG(
                gradient.
                  getColor1(
                    ),
                generatorContext);
            gradientStop.
              setAttributeNS(
                null,
                SVG_STOP_COLOR_ATTRIBUTE,
                colorDesc.
                  getPaintValue(
                    ));
            gradientStop.
              setAttributeNS(
                null,
                SVG_STOP_OPACITY_ATTRIBUTE,
                colorDesc.
                  getOpacityValue(
                    ));
            gradientDef.
              appendChild(
                gradientStop);
            gradientStop =
              domFactory.
                createElementNS(
                  SVG_NAMESPACE_URI,
                  SVG_STOP_TAG);
            gradientStop.
              setAttributeNS(
                null,
                SVG_OFFSET_ATTRIBUTE,
                SVG_HUNDRED_PERCENT_VALUE);
            colorDesc =
              org.apache.batik.svggen.SVGColor.
                toSVG(
                  gradient.
                    getColor2(
                      ),
                  generatorContext);
            gradientStop.
              setAttributeNS(
                null,
                SVG_STOP_COLOR_ATTRIBUTE,
                colorDesc.
                  getPaintValue(
                    ));
            gradientStop.
              setAttributeNS(
                null,
                SVG_STOP_OPACITY_ATTRIBUTE,
                colorDesc.
                  getOpacityValue(
                    ));
            gradientDef.
              appendChild(
                gradientStop);
            gradientDef.
              setAttributeNS(
                null,
                SVG_ID_ATTRIBUTE,
                generatorContext.
                  idGenerator.
                  generateID(
                    ID_PREFIX_LINEAR_GRADIENT));
            java.lang.StringBuffer paintAttrBuf =
              new java.lang.StringBuffer(
              URL_PREFIX);
            paintAttrBuf.
              append(
                SIGN_POUND);
            paintAttrBuf.
              append(
                gradientDef.
                  getAttributeNS(
                    null,
                    SVG_ID_ATTRIBUTE));
            paintAttrBuf.
              append(
                URL_SUFFIX);
            gradientDesc =
              new org.apache.batik.svggen.SVGPaintDescriptor(
                paintAttrBuf.
                  toString(
                    ),
                SVG_OPAQUE_VALUE,
                gradientDef);
            descMap.
              put(
                gradient,
                gradientDesc);
            defSet.
              add(
                gradientDef);
        }
        return gradientDesc;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "u/of1PyqVDoVAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "rCAAAA==");
}
