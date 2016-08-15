package org.apache.batik.bridge;
public class SVGPolygonElementBridge extends org.apache.batik.bridge.SVGDecoratedShapeElementBridge {
    protected static final java.awt.Shape DEFAULT_SHAPE = new java.awt.geom.GeneralPath(
      );
    public SVGPolygonElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_POLYGON_TAG;
    }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.bridge.SVGPolygonElementBridge(
                                                            );
    }
    protected void buildShape(org.apache.batik.bridge.BridgeContext ctx,
                              org.w3c.dom.Element e,
                              org.apache.batik.gvt.ShapeNode shapeNode) {
        org.apache.batik.dom.svg.SVGOMPolygonElement pe =
          (org.apache.batik.dom.svg.SVGOMPolygonElement)
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
                org.apache.batik.parser.AWTPolygonProducer app =
                  new org.apache.batik.parser.AWTPolygonProducer(
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
       "4r3/APHG+OajHAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "x0H/Fyeyu9lCJwAA");
}
