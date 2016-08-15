package org.apache.batik.bridge;
public abstract class SVGShapeElementBridge extends org.apache.batik.bridge.AbstractGraphicsNodeBridge {
    protected SVGShapeElementBridge() { super(); }
    public org.apache.batik.gvt.GraphicsNode createGraphicsNode(org.apache.batik.bridge.BridgeContext ctx,
                                                                org.w3c.dom.Element e) {
        org.apache.batik.gvt.ShapeNode shapeNode =
          (org.apache.batik.gvt.ShapeNode)
            super.
            createGraphicsNode(
              ctx,
              e);
        if (shapeNode ==
              null) {
            return null;
        }
        associateSVGContext(
          ctx,
          e,
          shapeNode);
        buildShape(
          ctx,
          e,
          shapeNode);
        java.awt.RenderingHints hints =
          null;
        hints =
          org.apache.batik.bridge.CSSUtilities.
            convertColorRendering(
              e,
              hints);
        hints =
          org.apache.batik.bridge.CSSUtilities.
            convertShapeRendering(
              e,
              hints);
        if (hints !=
              null)
            shapeNode.
              setRenderingHints(
                hints);
        return shapeNode;
    }
    protected org.apache.batik.gvt.GraphicsNode instantiateGraphicsNode() {
        return new org.apache.batik.gvt.ShapeNode(
          );
    }
    public void buildGraphicsNode(org.apache.batik.bridge.BridgeContext ctx,
                                  org.w3c.dom.Element e,
                                  org.apache.batik.gvt.GraphicsNode node) {
        org.apache.batik.gvt.ShapeNode shapeNode =
          (org.apache.batik.gvt.ShapeNode)
            node;
        shapeNode.
          setShapePainter(
            createShapePainter(
              ctx,
              e,
              shapeNode));
        super.
          buildGraphicsNode(
            ctx,
            e,
            node);
    }
    protected org.apache.batik.gvt.ShapePainter createShapePainter(org.apache.batik.bridge.BridgeContext ctx,
                                                                   org.w3c.dom.Element e,
                                                                   org.apache.batik.gvt.ShapeNode shapeNode) {
        return org.apache.batik.bridge.PaintServer.
          convertFillAndStroke(
            e,
            shapeNode,
            ctx);
    }
    protected abstract void buildShape(org.apache.batik.bridge.BridgeContext ctx,
                                       org.w3c.dom.Element e,
                                       org.apache.batik.gvt.ShapeNode node);
    public boolean isComposite() { return false;
    }
    protected void handleGeometryChanged() {
        super.
          handleGeometryChanged(
            );
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
    protected boolean hasNewShapePainter;
    public void handleCSSEngineEvent(org.apache.batik.css.engine.CSSEngineEvent evt) {
        hasNewShapePainter =
          false;
        super.
          handleCSSEngineEvent(
            evt);
    }
    protected void handleCSSPropertyChanged(int property) {
        switch (property) {
            case org.apache.batik.css.engine.SVGCSSEngine.
                   FILL_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   FILL_OPACITY_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   STROKE_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   STROKE_OPACITY_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   STROKE_WIDTH_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   STROKE_LINECAP_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   STROKE_LINEJOIN_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   STROKE_MITERLIMIT_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   STROKE_DASHARRAY_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   STROKE_DASHOFFSET_INDEX:
                {
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
                }
            case org.apache.batik.css.engine.SVGCSSEngine.
                   SHAPE_RENDERING_INDEX:
                {
                    java.awt.RenderingHints hints =
                      node.
                      getRenderingHints(
                        );
                    hints =
                      org.apache.batik.bridge.CSSUtilities.
                        convertShapeRendering(
                          e,
                          hints);
                    if (hints !=
                          null) {
                        node.
                          setRenderingHints(
                            hints);
                    }
                    break;
                }
            case org.apache.batik.css.engine.SVGCSSEngine.
                   COLOR_RENDERING_INDEX:
                {
                    java.awt.RenderingHints hints =
                      node.
                      getRenderingHints(
                        );
                    hints =
                      org.apache.batik.bridge.CSSUtilities.
                        convertColorRendering(
                          e,
                          hints);
                    if (hints !=
                          null) {
                        node.
                          setRenderingHints(
                            hints);
                    }
                    break;
                }
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
       "/oUpXHlH6aiDpn2WeMW3+f8FB3Kkxk4hAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "8l969J9/xz955XfLW+L/B8jaVWM+LAAA");
}
