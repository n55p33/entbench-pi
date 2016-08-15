package org.apache.batik.bridge;
public class SVGPolylineElementBridge extends org.apache.batik.bridge.SVGDecoratedShapeElementBridge {
    protected static final java.awt.Shape DEFAULT_SHAPE = new java.awt.geom.GeneralPath(
      );
    public SVGPolylineElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_POLYLINE_TAG;
    }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.bridge.SVGPolylineElementBridge(
                                                            );
    }
    protected void buildShape(org.apache.batik.bridge.BridgeContext ctx,
                              org.w3c.dom.Element e,
                              org.apache.batik.gvt.ShapeNode shapeNode) {
        org.apache.batik.dom.svg.SVGOMPolylineElement pe =
          (org.apache.batik.dom.svg.SVGOMPolylineElement)
            e;
        try {
            org.apache.batik.dom.svg.SVGOMAnimatedPoints _points =
              pe.
              getSVGOMAnimatedPoints(
                );
            _points.
              check(
                );
            org.w3c.dom.svg.SVGPointList pl =
              _points.
              getAnimatedPoints(
                );
            int size =
              pl.
              getNumberOfItems(
                );
            if (size ==
                  0) {
                shapeNode.
                  setShape(
                    DEFAULT_SHAPE);
            }
            else {
                org.apache.batik.parser.AWTPolylineProducer app =
                  new org.apache.batik.parser.AWTPolylineProducer(
                  );
                app.
                  setWindingRule(
                    org.apache.batik.bridge.CSSUtilities.
                      convertFillRule(
                        e));
                app.
                  startPoints(
                    );
                for (int i =
                       0;
                     i <
                       size;
                     i++) {
                    org.w3c.dom.svg.SVGPoint p =
                      pl.
                      getItem(
                        i);
                    app.
                      point(
                        p.
                          getX(
                            ),
                        p.
                          getY(
                            ));
                }
                app.
                  endPoints(
                    );
                shapeNode.
                  setShape(
                    app.
                      getShape(
                        ));
            }
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
                    SVG_POINTS_ATTRIBUTE)) {
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
    protected void handleCSSPropertyChanged(int property) {
        switch (property) {
            case org.apache.batik.css.engine.SVGCSSEngine.
                   FILL_RULE_INDEX:
                buildShape(
                  ctx,
                  e,
                  (org.apache.batik.gvt.ShapeNode)
                    node);
                handleGeometryChanged(
                  );
                break;
            default:
                super.
                  handleCSSPropertyChanged(
                    property);
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "/S5/ZcV7/wEQnRospxwAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "26/62DPfyOtC/wsxWVNgTicAAA==");
}
