package org.apache.batik.extension.svg;
public class BatikRegularPolygonElementBridge extends org.apache.batik.bridge.SVGDecoratedShapeElementBridge implements org.apache.batik.extension.svg.BatikExtConstants {
    public BatikRegularPolygonElementBridge() { super(); }
    public java.lang.String getNamespaceURI() { return BATIK_EXT_NAMESPACE_URI;
    }
    public java.lang.String getLocalName() { return BATIK_EXT_REGULAR_POLYGON_TAG;
    }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.extension.svg.BatikRegularPolygonElementBridge(
                                                            );
    }
    protected void buildShape(org.apache.batik.bridge.BridgeContext ctx,
                              org.w3c.dom.Element e,
                              org.apache.batik.gvt.ShapeNode shapeNode) {
        org.apache.batik.parser.UnitProcessor.Context uctx =
          org.apache.batik.bridge.UnitProcessor.
          createContext(
            ctx,
            e);
        java.lang.String s;
        s =
          e.
            getAttributeNS(
              null,
              SVG_CX_ATTRIBUTE);
        float cx =
          0;
        if (s.
              length(
                ) !=
              0) {
            cx =
              org.apache.batik.bridge.UnitProcessor.
                svgHorizontalCoordinateToUserSpace(
                  s,
                  SVG_CX_ATTRIBUTE,
                  uctx);
        }
        s =
          e.
            getAttributeNS(
              null,
              SVG_CY_ATTRIBUTE);
        float cy =
          0;
        if (s.
              length(
                ) !=
              0) {
            cy =
              org.apache.batik.bridge.UnitProcessor.
                svgVerticalCoordinateToUserSpace(
                  s,
                  SVG_CY_ATTRIBUTE,
                  uctx);
        }
        s =
          e.
            getAttributeNS(
              null,
              SVG_R_ATTRIBUTE);
        float r;
        if (s.
              length(
                ) !=
              0) {
            r =
              org.apache.batik.bridge.UnitProcessor.
                svgOtherLengthToUserSpace(
                  s,
                  SVG_R_ATTRIBUTE,
                  uctx);
        }
        else {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              e,
              ERR_ATTRIBUTE_MISSING,
              new java.lang.Object[] { SVG_R_ATTRIBUTE,
              s });
        }
        int sides =
          convertSides(
            e,
            BATIK_EXT_SIDES_ATTRIBUTE,
            3,
            ctx);
        java.awt.geom.GeneralPath gp =
          new java.awt.geom.GeneralPath(
          );
        for (int i =
               0;
             i <
               sides;
             i++) {
            double angle =
              (i +
                 0.5) *
              (2 *
                 java.lang.Math.
                   PI /
                 sides) -
              java.lang.Math.
                PI /
              2;
            double x =
              cx +
              r *
              java.lang.Math.
              cos(
                angle);
            double y =
              cy -
              r *
              java.lang.Math.
              sin(
                angle);
            if (i ==
                  0)
                gp.
                  moveTo(
                    (float)
                      x,
                    (float)
                      y);
            else
                gp.
                  lineTo(
                    (float)
                      x,
                    (float)
                      y);
        }
        gp.
          closePath(
            );
        shapeNode.
          setShape(
            gp);
    }
    protected static int convertSides(org.w3c.dom.Element filterElement,
                                      java.lang.String attrName,
                                      int defaultValue,
                                      org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            attrName);
        if (s.
              length(
                ) ==
              0) {
            return defaultValue;
        }
        else {
            int ret =
              0;
            try {
                ret =
                  org.apache.batik.bridge.SVGUtilities.
                    convertSVGInteger(
                      s);
            }
            catch (java.lang.NumberFormatException nfEx) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  filterElement,
                  nfEx,
                  ERR_ATTRIBUTE_VALUE_MALFORMED,
                  new java.lang.Object[] { attrName,
                  s });
            }
            if (ret <
                  3)
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  filterElement,
                  ERR_ATTRIBUTE_VALUE_MALFORMED,
                  new java.lang.Object[] { attrName,
                  s });
            return ret;
        }
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
      ("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");
}
