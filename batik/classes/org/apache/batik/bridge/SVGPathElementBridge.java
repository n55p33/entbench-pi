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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "eQJEUkBSvD7pH1tS+y539HBN8cpbEuUq");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("fE5h6cGZPPtoCkrLe+w7TcdJl7OXuIrcvLyKfJxHx/vLyDeVL742Yn7kjfbn" +
       "95fIFFvK84LLAxR0//4+20ku/sIduR3zuky++K1HfuXKe4+/Gx7ZC3xqzmdk" +
       "e+72N7b6jh+Vd6zyf/zkP/z+v/Pa75Xn8v8PiwszmiMuAAA=");
}
