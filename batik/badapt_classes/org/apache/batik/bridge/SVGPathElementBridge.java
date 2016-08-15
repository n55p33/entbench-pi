package org.apache.batik.bridge;
public class SVGPathElementBridge extends org.apache.batik.bridge.SVGDecoratedShapeElementBridge implements org.apache.batik.dom.svg.SVGPathContext {
    protected static final java.awt.Shape DEFAULT_SHAPE = new java.awt.geom.GeneralPath(
      );
    public SVGPathElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_PATH_TAG;
    }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.bridge.SVGPathElementBridge(
                                                            );
    }
    protected void buildShape(org.apache.batik.bridge.BridgeContext ctx,
                              org.w3c.dom.Element e,
                              org.apache.batik.gvt.ShapeNode shapeNode) {
        org.apache.batik.dom.svg.SVGOMPathElement pe =
          (org.apache.batik.dom.svg.SVGOMPathElement)
            e;
        org.apache.batik.parser.AWTPathProducer app =
          new org.apache.batik.parser.AWTPathProducer(
          );
        try {
            org.apache.batik.dom.svg.SVGOMAnimatedPathData _d =
              pe.
              getAnimatedPathData(
                );
            _d.
              check(
                );
            org.w3c.dom.svg.SVGPathSegList p =
              _d.
              getAnimatedPathSegList(
                );
            app.
              setWindingRule(
                org.apache.batik.bridge.CSSUtilities.
                  convertFillRule(
                    e));
            org.apache.batik.dom.svg.SVGAnimatedPathDataSupport.
              handlePathSegList(
                p,
                app);
        }
        catch (org.apache.batik.dom.svg.LiveAttributeException ex) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              ex);
        }
        finally {
            shapeNode.
              setShape(
                app.
                  getShape(
                    ));
        }
    }
    public void handleAnimatedAttributeChanged(org.apache.batik.dom.svg.AnimatedLiveAttributeValue alav) {
        if (alav.
              getNamespaceURI(
                ) ==
              null &&
              alav.
              getLocalName(
                ).
              equals(
                SVG_D_ATTRIBUTE)) {
            buildShape(
              ctx,
              e,
              (org.apache.batik.gvt.ShapeNode)
                node);
            handleGeometryChanged(
              );
        }
        else {
            super.
              handleAnimatedAttributeChanged(
                alav);
        }
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
    protected java.awt.Shape pathLengthShape;
    protected org.apache.batik.ext.awt.geom.PathLength
      pathLength;
    protected org.apache.batik.ext.awt.geom.PathLength getPathLengthObj() {
        java.awt.Shape s =
          ((org.apache.batik.gvt.ShapeNode)
             node).
          getShape(
            );
        if (pathLengthShape !=
              s) {
            pathLength =
              new org.apache.batik.ext.awt.geom.PathLength(
                s);
            pathLengthShape =
              s;
        }
        return pathLength;
    }
    public float getTotalLength() { org.apache.batik.ext.awt.geom.PathLength pl =
                                      getPathLengthObj(
                                        );
                                    return pl.
                                      lengthOfPath(
                                        );
    }
    public java.awt.geom.Point2D getPointAtLength(float distance) {
        org.apache.batik.ext.awt.geom.PathLength pl =
          getPathLengthObj(
            );
        return pl.
          pointAtLength(
            distance);
    }
    public int getPathSegAtLength(float distance) {
        org.apache.batik.ext.awt.geom.PathLength pl =
          getPathLengthObj(
            );
        return pl.
          segmentAtLength(
            distance);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "BSDF6+P+kSU173BHr6MpXnlLopyFzwgs");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("v3Aqzz5UQWl5j3wzdRx3OX2Jq8jNy6vIR3l0sr+MfEP53KuD8fe/3vzM/hKZ" +
       "Ysu7XYHlPga6d3+f7TgXf+622I5wXeq98PWHfvHy80frhof2BJ+Y8ynanrn1" +
       "jS3K8ePyjtXuVx//pe/8p6/+SXku//8A/pa0eyMuAAA=");
}
