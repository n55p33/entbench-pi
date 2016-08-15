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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "3ML+/pyzu8I/WfP2fwHJVyMFsxkAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "21+0HSc6Ab31dHGntpNP+78543J/Vl5Ii5/eqil9fS10ay/LOGEPVbckIxv4" +
       "MR+amCFf2OPOwwwU6uTC0qhlbF4Jc+7MnFLpd7Zp2zagpWUxY7E1icoVzedn" +
       "tlTZynXzATPKhhnge//p/V9/34PfhjrtIac3Kd5QlYdGHARpUvxLz33o7hue" +
       "/s57sygFQxT/Cy/e9VjKlbqaxGlBpAW5J+pdqajjbLmnJM+ns8AClEzaq5oy" +
       "6+omjL+b3YwPffzWb68+8t1PbbO543Z7jBg8+fSv/GjnqadPHsqhH7wkjT3c" +
       "Z5tHZ5O+aRdhF7n/aqNkPch//szjn//tx9+zndWtRzNCAm54PvXX//P1nWe+" +
       "89XLpCHXGPbLUKx/0zs6Za/b3PtQ/AwUQy6KTDVA2dpcpb0ZS8c+lQRDbeGv" +
       "hJU0K4YhM/IoIu8VWrIq1/xEKbslRZyqArsMFpg07OYWGB4RRrdoYHx3tZ5j" +
       "1RHPkUFBlzTdUPCVIfZ131zx3NpAjVZlqMVrQ200i6ggmo2SuKmV23a8WtWC" +
       "RE2SiZqg85qVEF6Jo3jD1qt6fqwrA1vja4pq462Z390Ap0hRxaHRwIG+xtFa" +
       "B81tcIHu2+IozovzZqFXxLst3ICLaBQV+o5DeuPZSKpoQ1POz+iZQSaEQZN8" +
       "fj5CaU5KMHfdXa/yOKn07Ehr9fyo0C07A1FYTWRTC8u4niyXXo8WS0TgDVob" +
       "leBEZtVu0CDHdVUgNjYLkjQ3cw6u/q6OocRq6RscJwyiSOo2mBHj06VRgVmX" +
       "1gPCiQcdZ1gCUdPDg1ww1HFSyuVVa+LyfWkwTJodqeIwwXQpdEzKqerjUbm6" +
       "5Ku5wnSszKoLqkp0rQ5XxRlz3doE1GLdGglMuMYDfxQKtXksSRYoTYLJkqvw" +
       "o+W4HbVIPL8R2z2NKMrKQB/Ukzq+WC7Xcb2+0mrzft0nqH530VYFDMxVwUGL" +
       "qLxcdzjZH7tSfxAwWC/QPForN4l1PBZ60mbeoyudDufa7XhUNp0ZKYjyZKLM" +
       "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" +
       "NCUAAA==");
}
