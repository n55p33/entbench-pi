package org.apache.batik.bridge;
public class SVGRectElementBridge extends org.apache.batik.bridge.SVGShapeElementBridge {
    public SVGRectElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_RECT_TAG; }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.bridge.SVGRectElementBridge(
                                                            ); }
    protected void buildShape(org.apache.batik.bridge.BridgeContext ctx,
                              org.w3c.dom.Element e,
                              org.apache.batik.gvt.ShapeNode shapeNode) {
        try {
            org.apache.batik.dom.svg.SVGOMRectElement re =
              (org.apache.batik.dom.svg.SVGOMRectElement)
                e;
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _x =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                re.
                getX(
                  );
            float x =
              _x.
              getCheckedValue(
                );
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _y =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                re.
                getY(
                  );
            float y =
              _y.
              getCheckedValue(
                );
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _width =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                re.
                getWidth(
                  );
            float w =
              _width.
              getCheckedValue(
                );
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _height =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                re.
                getHeight(
                  );
            float h =
              _height.
              getCheckedValue(
                );
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _rx =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                re.
                getRx(
                  );
            float rx =
              _rx.
              getCheckedValue(
                );
            if (rx >
                  w /
                  2) {
                rx =
                  w /
                    2;
            }
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _ry =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                re.
                getRy(
                  );
            float ry =
              _ry.
              getCheckedValue(
                );
            if (ry >
                  h /
                  2) {
                ry =
                  h /
                    2;
            }
            java.awt.Shape shape;
            if (rx ==
                  0 ||
                  ry ==
                  0) {
                shape =
                  new java.awt.geom.Rectangle2D.Float(
                    x,
                    y,
                    w,
                    h);
            }
            else {
                shape =
                  new java.awt.geom.RoundRectangle2D.Float(
                    x,
                    y,
                    w,
                    h,
                    rx *
                      2,
                    ry *
                      2);
            }
            shapeNode.
              setShape(
                shape);
        }
        catch (org.apache.batik.dom.svg.LiveAttributeException ex) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              ex);
        }
    }
    public void handleAnimatedAttributeChanged(org.apache.batik.dom.svg.AnimatedLiveAttributeValue alav) {
        if (alav.
              getNamespaceURI(
                ) ==
              null) {
            java.lang.String ln =
              alav.
              getLocalName(
                );
            if (ln.
                  equals(
                    SVG_X_ATTRIBUTE) ||
                  ln.
                  equals(
                    SVG_Y_ATTRIBUTE) ||
                  ln.
                  equals(
                    SVG_WIDTH_ATTRIBUTE) ||
                  ln.
                  equals(
                    SVG_HEIGHT_ATTRIBUTE) ||
                  ln.
                  equals(
                    SVG_RX_ATTRIBUTE) ||
                  ln.
                  equals(
                    SVG_RY_ATTRIBUTE)) {
                buildShape(
                  ctx,
                  e,
                  (org.apache.batik.gvt.ShapeNode)
                    node);
                handleGeometryChanged(
                  );
                return;
            }
        }
        super.
          handleAnimatedAttributeChanged(
            alav);
    }
    protected org.apache.batik.gvt.ShapePainter createShapePainter(org.apache.batik.bridge.BridgeContext ctx,
                                                                   org.w3c.dom.Element e,
                                                                   org.apache.batik.gvt.ShapeNode shapeNode) {
        java.awt.Shape shape =
          shapeNode.
          getShape(
            );
        java.awt.geom.Rectangle2D r2d =
          shape.
          getBounds2D(
            );
        if (r2d.
              getWidth(
                ) ==
              0 ||
              r2d.
              getHeight(
                ) ==
              0)
            return null;
        return super.
          createShapePainter(
            ctx,
            e,
            shapeNode);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "yy3s7885uyv8kzVv/RfefRQosxkAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AA==");
}
