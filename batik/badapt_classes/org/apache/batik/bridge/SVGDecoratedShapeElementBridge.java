package org.apache.batik.bridge;
public abstract class SVGDecoratedShapeElementBridge extends org.apache.batik.bridge.SVGShapeElementBridge {
    protected SVGDecoratedShapeElementBridge() { super(); }
    org.apache.batik.gvt.ShapePainter createFillStrokePainter(org.apache.batik.bridge.BridgeContext ctx,
                                                              org.w3c.dom.Element e,
                                                              org.apache.batik.gvt.ShapeNode shapeNode) {
        return super.
          createShapePainter(
            ctx,
            e,
            shapeNode);
    }
    org.apache.batik.gvt.ShapePainter createMarkerPainter(org.apache.batik.bridge.BridgeContext ctx,
                                                          org.w3c.dom.Element e,
                                                          org.apache.batik.gvt.ShapeNode shapeNode) {
        return org.apache.batik.bridge.PaintServer.
          convertMarkers(
            e,
            shapeNode,
            ctx);
    }
    protected org.apache.batik.gvt.ShapePainter createShapePainter(org.apache.batik.bridge.BridgeContext ctx,
                                                                   org.w3c.dom.Element e,
                                                                   org.apache.batik.gvt.ShapeNode shapeNode) {
        org.apache.batik.gvt.ShapePainter fillAndStroke;
        fillAndStroke =
          createFillStrokePainter(
            ctx,
            e,
            shapeNode);
        org.apache.batik.gvt.ShapePainter markerPainter =
          createMarkerPainter(
            ctx,
            e,
            shapeNode);
        java.awt.Shape shape =
          shapeNode.
          getShape(
            );
        org.apache.batik.gvt.ShapePainter painter;
        if (markerPainter !=
              null) {
            if (fillAndStroke !=
                  null) {
                org.apache.batik.gvt.CompositeShapePainter cp =
                  new org.apache.batik.gvt.CompositeShapePainter(
                  shape);
                cp.
                  addShapePainter(
                    fillAndStroke);
                cp.
                  addShapePainter(
                    markerPainter);
                painter =
                  cp;
            }
            else {
                painter =
                  markerPainter;
            }
        }
        else {
            painter =
              fillAndStroke;
        }
        return painter;
    }
    protected void handleCSSPropertyChanged(int property) {
        switch (property) {
            case org.apache.batik.css.engine.SVGCSSEngine.
                   MARKER_START_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   MARKER_MID_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   MARKER_END_INDEX:
                if (!hasNewShapePainter) {
                    hasNewShapePainter =
                      true;
                    org.apache.batik.gvt.ShapeNode shapeNode =
                      (org.apache.batik.gvt.ShapeNode)
                        node;
                    shapeNode.
                      setShapePainter(
                        createShapePainter(
                          ctx,
                          e,
                          shapeNode));
                }
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
       "X/tzg4fzWT/w8U4++yX+yZof/xvzB6+iSxkAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "n+7/H7WTT5pvJAAA");
}
