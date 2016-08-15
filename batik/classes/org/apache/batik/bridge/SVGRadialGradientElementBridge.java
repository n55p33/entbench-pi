package org.apache.batik.bridge;
public class SVGRadialGradientElementBridge extends org.apache.batik.bridge.AbstractSVGGradientElementBridge {
    public SVGRadialGradientElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_RADIAL_GRADIENT_TAG;
    }
    protected java.awt.Paint buildGradient(org.w3c.dom.Element paintElement,
                                           org.w3c.dom.Element paintedElement,
                                           org.apache.batik.gvt.GraphicsNode paintedNode,
                                           org.apache.batik.ext.awt.MultipleGradientPaint.CycleMethodEnum spreadMethod,
                                           org.apache.batik.ext.awt.MultipleGradientPaint.ColorSpaceEnum colorSpace,
                                           java.awt.geom.AffineTransform transform,
                                           java.awt.Color[] colors,
                                           float[] offsets,
                                           org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String cxStr =
          org.apache.batik.bridge.SVGUtilities.
          getChainableAttributeNS(
            paintElement,
            null,
            SVG_CX_ATTRIBUTE,
            ctx);
        if (cxStr.
              length(
                ) ==
              0) {
            cxStr =
              SVG_RADIAL_GRADIENT_CX_DEFAULT_VALUE;
        }
        java.lang.String cyStr =
          org.apache.batik.bridge.SVGUtilities.
          getChainableAttributeNS(
            paintElement,
            null,
            SVG_CY_ATTRIBUTE,
            ctx);
        if (cyStr.
              length(
                ) ==
              0) {
            cyStr =
              SVG_RADIAL_GRADIENT_CY_DEFAULT_VALUE;
        }
        java.lang.String rStr =
          org.apache.batik.bridge.SVGUtilities.
          getChainableAttributeNS(
            paintElement,
            null,
            SVG_R_ATTRIBUTE,
            ctx);
        if (rStr.
              length(
                ) ==
              0) {
            rStr =
              SVG_RADIAL_GRADIENT_R_DEFAULT_VALUE;
        }
        java.lang.String fxStr =
          org.apache.batik.bridge.SVGUtilities.
          getChainableAttributeNS(
            paintElement,
            null,
            SVG_FX_ATTRIBUTE,
            ctx);
        if (fxStr.
              length(
                ) ==
              0) {
            fxStr =
              cxStr;
        }
        java.lang.String fyStr =
          org.apache.batik.bridge.SVGUtilities.
          getChainableAttributeNS(
            paintElement,
            null,
            SVG_FY_ATTRIBUTE,
            ctx);
        if (fyStr.
              length(
                ) ==
              0) {
            fyStr =
              cyStr;
        }
        short coordSystemType;
        java.lang.String s =
          org.apache.batik.bridge.SVGUtilities.
          getChainableAttributeNS(
            paintElement,
            null,
            SVG_GRADIENT_UNITS_ATTRIBUTE,
            ctx);
        if (s.
              length(
                ) ==
              0) {
            coordSystemType =
              org.apache.batik.bridge.SVGUtilities.
                OBJECT_BOUNDING_BOX;
        }
        else {
            coordSystemType =
              org.apache.batik.bridge.SVGUtilities.
                parseCoordinateSystem(
                  paintElement,
                  SVG_GRADIENT_UNITS_ATTRIBUTE,
                  s,
                  ctx);
        }
        org.apache.batik.dom.svg.SVGContext bridge =
          org.apache.batik.bridge.BridgeContext.
          getSVGContext(
            paintedElement);
        if (coordSystemType ==
              org.apache.batik.bridge.SVGUtilities.
                OBJECT_BOUNDING_BOX &&
              bridge instanceof org.apache.batik.bridge.AbstractGraphicsNodeBridge) {
            java.awt.geom.Rectangle2D bbox =
              ((org.apache.batik.bridge.AbstractGraphicsNodeBridge)
                 bridge).
              getBBox(
                );
            if (bbox !=
                  null &&
                  bbox.
                  getWidth(
                    ) ==
                  0 ||
                  bbox.
                  getHeight(
                    ) ==
                  0) {
                return null;
            }
        }
        if (coordSystemType ==
              org.apache.batik.bridge.SVGUtilities.
                OBJECT_BOUNDING_BOX) {
            transform =
              org.apache.batik.bridge.SVGUtilities.
                toObjectBBox(
                  transform,
                  paintedNode);
        }
        org.apache.batik.parser.UnitProcessor.Context uctx =
          org.apache.batik.bridge.UnitProcessor.
          createContext(
            ctx,
            paintElement);
        float r =
          org.apache.batik.bridge.SVGUtilities.
          convertLength(
            rStr,
            SVG_R_ATTRIBUTE,
            coordSystemType,
            uctx);
        if (r ==
              0) {
            return colors[colors.
                            length -
                            1];
        }
        else {
            java.awt.geom.Point2D c =
              org.apache.batik.bridge.SVGUtilities.
              convertPoint(
                cxStr,
                SVG_CX_ATTRIBUTE,
                cyStr,
                SVG_CY_ATTRIBUTE,
                coordSystemType,
                uctx);
            java.awt.geom.Point2D f =
              org.apache.batik.bridge.SVGUtilities.
              convertPoint(
                fxStr,
                SVG_FX_ATTRIBUTE,
                fyStr,
                SVG_FY_ATTRIBUTE,
                coordSystemType,
                uctx);
            return new org.apache.batik.ext.awt.RadialGradientPaint(
              c,
              r,
              f,
              offsets,
              colors,
              spreadMethod,
              org.apache.batik.ext.awt.RadialGradientPaint.
                SRGB,
              transform);
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "jlzYvs1fsXnnP50WWS3HHgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "dnI0yEqmG9/u7RVbOyCh3OM7YfMjb5WNZ3vhEtBr57k8U+3Elr22GtCsq+um" +
       "q3Gh5EblQRnwkhfv7SXVUcthC/T1X3jh937i9Rf+fXVa8YgZ8VLYDbd3Oaw/" +
       "1+dbb3z9G3/w2DNfrE70HpSl6ADjy7cc7rzEcOFuQmW8Ry+i4inwQMeogA67" +
       "69L3eHpcXiIBswTfdW5Pjqj/7AfJT+z2+KndKruewvbK8bnw6e7tp/Irtcof" +
       "Xru7J1w9jfenof4hW3O3sVFRLs9FdSGuPWAeYP/Tfn465NXjiHriKWd7+z3b" +
       "c7XyWO+k7XCsbXpHp7diQGN+V+Gtg/DVYOcWju8WkT5/n7ZfKIu/HdeuKaVc" +
       "BzXuQ/5LxzHok6fgerpsew487zsG1/sO4BK+R7uDbg5c2bEL3qqV5QRSf1as" +
       "87tZ95pue1J8byz98gmWfu3/EUtl8bNl8dmy+MKdoCl/fq4sXr8PCn65YvaF" +
       "svg797HXP7hP22+WxW+UxS8eJLkP7ZeP7Q7w+uK9bnEcbmscX/yqen3kPhx/" +
       "qyyKuPaYnJi2euLVd7py5ednq+OH38rqmMe1Z+9/t6Q8KH/XHTfcDreylC++" +
       "fvORd76++leHYHxyc+o6XXtET2z7/LnmufeH/FDTzUrF64dTTr/6+qdx7Z33" +
       "mDkQXQ4vlQJfOdD/s7h26zI9QGP1fZ7un8e1G2d0gNXh5TzJvwAxCpCUr1/z" +
       "T2YYv5cZu3IUh5ISg4m765TlVy6mn6emefK7meZcxvrChRW0uol4khMmh7uI" +
       "ryhfen3MfPjbrZ8/3BJRbKkoSi6PgMXucGHlNK98/p7cTng9RL30ncd/9fqL" +
       "Jznw4weBz7Khc7I9d/crGQPHj6tLFMXff+ff++FffP0Pq3PZ/wvwPxuxIioA" +
       "AA==");
}
