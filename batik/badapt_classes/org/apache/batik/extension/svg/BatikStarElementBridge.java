package org.apache.batik.extension.svg;
public class BatikStarElementBridge extends org.apache.batik.bridge.SVGDecoratedShapeElementBridge implements org.apache.batik.extension.svg.BatikExtConstants {
    public BatikStarElementBridge() { super(); }
    public java.lang.String getNamespaceURI() { return BATIK_EXT_NAMESPACE_URI;
    }
    public java.lang.String getLocalName() { return BATIK_EXT_STAR_TAG; }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.extension.svg.BatikStarElementBridge(
                                                            ); }
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
                ) ==
              0)
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              e,
              ERR_ATTRIBUTE_MISSING,
              new java.lang.Object[] { SVG_R_ATTRIBUTE,
              s });
        r =
          org.apache.batik.bridge.UnitProcessor.
            svgOtherLengthToUserSpace(
              s,
              SVG_R_ATTRIBUTE,
              uctx);
        s =
          e.
            getAttributeNS(
              null,
              BATIK_EXT_IR_ATTRIBUTE);
        float ir;
        if (s.
              length(
                ) ==
              0)
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              e,
              ERR_ATTRIBUTE_MISSING,
              new java.lang.Object[] { BATIK_EXT_IR_ATTRIBUTE,
              s });
        ir =
          org.apache.batik.bridge.UnitProcessor.
            svgOtherLengthToUserSpace(
              s,
              BATIK_EXT_IR_ATTRIBUTE,
              uctx);
        int sides =
          convertSides(
            e,
            BATIK_EXT_SIDES_ATTRIBUTE,
            3,
            ctx);
        java.awt.geom.GeneralPath gp =
          new java.awt.geom.GeneralPath(
          );
        double angle;
        double x;
        double y;
        final double SECTOR =
          2.0 *
          java.lang.Math.
            PI /
          sides;
        final double HALF_PI =
          java.lang.Math.
            PI /
          2.0;
        for (int i =
               0;
             i <
               sides;
             i++) {
            angle =
              i *
                SECTOR -
                HALF_PI;
            x =
              cx +
                ir *
                java.lang.Math.
                cos(
                  angle);
            y =
              cy -
                ir *
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
            angle =
              (i +
                 0.5) *
                SECTOR -
                HALF_PI;
            x =
              cx +
                r *
                java.lang.Math.
                cos(
                  angle);
            y =
              cy -
                r *
                java.lang.Math.
                sin(
                  angle);
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
      ("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" +
       "Rl7Je/+Sf7Li3X8D0rNQUKgaAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "fPob+QXL/wJR/M2h6CUAAA==");
}
