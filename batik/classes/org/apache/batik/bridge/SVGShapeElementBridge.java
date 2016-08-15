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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "/oEpXHlH6aiDpn2WeMW3+f8FBmOz1E4hAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "9JAa63KqE2B9t2w1YUJNP8b75C1UmOv08BbI0oC/5xttj52dv2w4NddvLhoR" +
       "8IyPhDp+rUJ9722FepbdH75L30tF8YMp9Ki936S3L8ij6P7oKasfex2svqlo" +
       "bIBHOmJ1/sbYzz2nMejDRfEPS5pL0JfvwvlPFcWPgyClZCBzu0WzF7dF16Gt" +
       "ncrhk69X5e8Dj3UkB+uNUfktcji25Sdua8vloUTBbonss3eR1D8rip89cZdz" +
       "pxl3dZdbIEvZffp1yO7RorEFno8cye5Dr0F25arx3qJY/c0N6XMl6BfuIp5/" +
       "WxS/mELXSkMqeS5a/skpx//qdXD8cNH4BHheOOL4hTfGa85y8MW79H2pKP5D" +
       "Cr2pONPzy7Pzkj3ylL1feh3slQd0xaLy4hF7L74xznCWhV+/S99vFsV/TqFH" +
       "LDnQPJ3QQ19P4y0GXk1du6DHL7/e6NcBz08fMfrTb4weLx1dTzlyxGducUQ1" +
       "SQ71wLQD/RDj+X5Z66+Pl8n/cRfZ/EFR/PcUeuteNudHXxDNb79eG+iC59NH" +
       "ovn0G2MDZ0VzIZzfYx/x/2d34f9/FsWfpNBjJ/xzcVjeEby9eXz1tcggBzZ3" +
       "24tJxRWLx265A7m/t6d+7uXr9z/6svib5d2ck7t1VynofiPzvLMn4mfqV6JY" +
       "N+ySpav78/Go/HsVLPt3SLZS6Mq+UtL9l3v4v0qhGxfhU+hy+X8GrjijvXYK" +
       "B1DtK2dB7gUqACBF9XJ0bLvInTK/3lGWf3aR3gsrv3Q+nT/RxUPfSBdnvgCe" +
       "Ope3l7dUj3PsbH9P9Tn18y+PmA9+vfUz+8tFqifvdgWW+ynovv09p5M8/ck7" +
       "YjvGdWX49KsP/PzV9xx/UzywJ/jUyM/Q9s7bX+Pp+1FaXrzZ/eKj/+Lb/unL" +
       "v1OeEv9/Y7mR7j4sAAA=");
}
