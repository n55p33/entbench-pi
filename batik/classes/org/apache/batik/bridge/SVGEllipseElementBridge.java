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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "OkWhDQ7Vl17Y359xcZf5J2ve/g92DYEdvxkAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "QBJIJQAA");
}
