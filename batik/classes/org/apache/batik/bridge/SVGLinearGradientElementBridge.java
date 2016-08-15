package org.apache.batik.bridge;
public class SVGLinearGradientElementBridge extends org.apache.batik.bridge.AbstractSVGGradientElementBridge {
    public SVGLinearGradientElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_LINEAR_GRADIENT_TAG;
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
        java.lang.String x1Str =
          org.apache.batik.bridge.SVGUtilities.
          getChainableAttributeNS(
            paintElement,
            null,
            SVG_X1_ATTRIBUTE,
            ctx);
        if (x1Str.
              length(
                ) ==
              0) {
            x1Str =
              SVG_LINEAR_GRADIENT_X1_DEFAULT_VALUE;
        }
        java.lang.String y1Str =
          org.apache.batik.bridge.SVGUtilities.
          getChainableAttributeNS(
            paintElement,
            null,
            SVG_Y1_ATTRIBUTE,
            ctx);
        if (y1Str.
              length(
                ) ==
              0) {
            y1Str =
              SVG_LINEAR_GRADIENT_Y1_DEFAULT_VALUE;
        }
        java.lang.String x2Str =
          org.apache.batik.bridge.SVGUtilities.
          getChainableAttributeNS(
            paintElement,
            null,
            SVG_X2_ATTRIBUTE,
            ctx);
        if (x2Str.
              length(
                ) ==
              0) {
            x2Str =
              SVG_LINEAR_GRADIENT_X2_DEFAULT_VALUE;
        }
        java.lang.String y2Str =
          org.apache.batik.bridge.SVGUtilities.
          getChainableAttributeNS(
            paintElement,
            null,
            SVG_Y2_ATTRIBUTE,
            ctx);
        if (y2Str.
              length(
                ) ==
              0) {
            y2Str =
              SVG_LINEAR_GRADIENT_Y2_DEFAULT_VALUE;
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
        java.awt.geom.Point2D p1 =
          org.apache.batik.bridge.SVGUtilities.
          convertPoint(
            x1Str,
            SVG_X1_ATTRIBUTE,
            y1Str,
            SVG_Y1_ATTRIBUTE,
            coordSystemType,
            uctx);
        java.awt.geom.Point2D p2 =
          org.apache.batik.bridge.SVGUtilities.
          convertPoint(
            x2Str,
            SVG_X2_ATTRIBUTE,
            y2Str,
            SVG_Y2_ATTRIBUTE,
            coordSystemType,
            uctx);
        if (p1.
              getX(
                ) ==
              p2.
              getX(
                ) &&
              p1.
              getY(
                ) ==
              p2.
              getY(
                )) {
            return colors[colors.
                            length -
                            1];
        }
        else {
            return new org.apache.batik.ext.awt.LinearGradientPaint(
              p1,
              p2,
              offsets,
              colors,
              spreadMethod,
              colorSpace,
              transform);
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "4siF7Tv8FZt3/w3rv4IVxx4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AAA=");
}
