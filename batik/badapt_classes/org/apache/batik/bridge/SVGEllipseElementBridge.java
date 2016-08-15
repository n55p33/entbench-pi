package org.apache.batik.bridge;
public class SVGEllipseElementBridge extends org.apache.batik.bridge.SVGShapeElementBridge {
    public SVGEllipseElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_ELLIPSE_TAG; }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.bridge.SVGEllipseElementBridge(
                                                            ); }
    protected void buildShape(org.apache.batik.bridge.BridgeContext ctx,
                              org.w3c.dom.Element e,
                              org.apache.batik.gvt.ShapeNode shapeNode) {
        try {
            org.apache.batik.dom.svg.SVGOMEllipseElement ee =
              (org.apache.batik.dom.svg.SVGOMEllipseElement)
                e;
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _cx =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                ee.
                getCx(
                  );
            float cx =
              _cx.
              getCheckedValue(
                );
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _cy =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                ee.
                getCy(
                  );
            float cy =
              _cy.
              getCheckedValue(
                );
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _rx =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                ee.
                getRx(
                  );
            float rx =
              _rx.
              getCheckedValue(
                );
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _ry =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                ee.
                getRy(
                  );
            float ry =
              _ry.
              getCheckedValue(
                );
            shapeNode.
              setShape(
                new java.awt.geom.Ellipse2D.Float(
                  cx -
                    rx,
                  cy -
                    ry,
                  rx *
                    2,
                  ry *
                    2));
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
                    SVG_CX_ATTRIBUTE) ||
                  ln.
                  equals(
                    SVG_CY_ATTRIBUTE) ||
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
        java.awt.geom.Rectangle2D r2d =
          shapeNode.
          getShape(
            ).
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
       "6BSF1jtUX3phf3/GxV3mn6x5+z+O23OhvxkAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "x577Rn6l8X9yzUZdSCUAAA==");
}
