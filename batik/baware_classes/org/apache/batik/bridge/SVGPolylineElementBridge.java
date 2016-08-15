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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1Ze5AURxnv3eOOe794hsfxOkjx2uUREskh5jju4HDv2OKA" +
       "Kg/D0jvbuzswOzPM9N4tF1GIpaBVUkguBK1wf1hEkIIQLVMalRRWjCFFjJUE" +
       "jdEKsRKrRCNlKMtoiRq/7p7ZeewDqRK3anpnu7/+ur+vf/37vu49dwNVmgZq" +
       "IyoN0X06MUPdKo1iwySJLgWb5laoi0lPVOC/7LzevzqIqgZRYxqbfRI2SY9M" +
       "lIQ5iGbKqkmxKhGzn5AE6xE1iEmMIUxlTR1Ek2SzN6MrsiTTPi1BmMB2bERQ" +
       "C6bUkONZSnotBRTNjMBMwnwm4U5/c0cE1Uuavs8Rn+oS73K1MMmMM5ZJUXNk" +
       "Nx7C4SyVlXBENmlHzkCLdU3Zl1I0GiI5GtqtrLJcsCmyqsAFc59p+vDW0XQz" +
       "d8EErKoa5eaZW4ipKUMkEUFNTm23QjLmXvRZVBFBdS5hitoj9qBhGDQMg9rW" +
       "OlIw+waiZjNdGjeH2pqqdIlNiKI5XiU6NnDGUhPlcwYN1dSynXcGa2fnrRVW" +
       "Fpj4+OLw6BM7m79TgZoGUZOsDrDpSDAJCoMMgkNJJk4MszORIIlB1KLCYg8Q" +
       "Q8aKPGKtdKspp1RMs7D8tltYZVYnBh/T8RWsI9hmZCWqGXnzkhxQ1q/KpIJT" +
       "YOtkx1ZhYQ+rBwNrZZiYkcSAO6vLuD2ymqBolr9H3sb2T4IAdB2fITSt5Yca" +
       "p2KoQK0CIgpWU+EBgJ6aAtFKDQBoUDStpFLmax1Le3CKxBgifXJR0QRSNdwR" +
       "rAtFk/xiXBOs0jTfKrnW50b/miOPqBvVIArAnBNEUtj866BTm6/TFpIkBoF9" +
       "IDrWL4ocx5MvHg4iBMKTfMJC5nufufnQkrZLl4XM9CIym+O7iURj0ql442sz" +
       "uhaurmDTqNY1U2aL77Gc77Ko1dKR04FhJuc1ssaQ3Xhpy08/deAseT+IantR" +
       "laQp2QzgqEXSMrqsEGMDUYmBKUn0ohqiJrp4ey8aD+8RWSWidnMyaRLai8Yp" +
       "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" +
       "/JUV7/0HOOvWyaccAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "PJ5cQIqb7ym6PF6U1/Li24s5uSNC7vUDL4JSApi4XQqLjDOCkpiuZB+G9Nfg" +
       "7wK8/ie/cv55xX6JfrB9mCe85jhR8OFS9dJOl2oJzOz6tN8adwsur4iQ+wtP" +
       "k9LoYGpIe32uFm2VvHjTfjT8ln71hrygthcg5NxVOSAOSvkzewu98tvvyItO" +
       "XnQLs1ERDBBbuXYk8xzm0tCjrq1t4kjEq4WI+dwd7BPQc0JS/2chobPff8KM" +
       "8WAu+55/eN9nfvyJz0OPHCB3Jbm3QEc8NeIoztP7H3n+g4++5Nm/e0+BsRBg" +
       "5z/01UfelHOdvzhVH8lVnRZJCyOFEVvAIlALbW8biOPAdODqkRzmrtgzD37e" +
       "+sl/+qV9Xno+6s4Rg3c/+2NfO3jvsxdPvQ08cUNCfrrP/o2gEPqlhxYOkMdv" +
       "N0rRg/rHjz/zmz//zLv2Uj14Nrftwle3X/rz//7MwUf+7lM3SaTutL1vYGKj" +
       "+/+yXwvp1tGPKa8A3hL4rZtUAccBolkzQm3LWettJRb4bmgZ+Hod1/qdpMIN" +
       "W0Md65TWiRxnYcplY7Y5qkVUuUf7EjkXLD0mh+VUKxtdi6YnzJyVbJ4X122K" +
       "Wg+E7lrtDkN+GPDtkT1kI8/kNxjhEysA0s6GH1Yl13djAkPjAE00rEokca2p" +
       "pqO5o6829M4blRalOiuM1aFXNtPddMDooozbkmeW7PGca2MEk4Ek29AbfcUv" +
       "txtZ4+nKdNlkbXqCmz15uLGc7dDoZS7e6ta33bLZdVha2Nozvty1KtNsVGdh" +
       "RM1mY7NMOixZkbv8pF2XBYsbraYQwEl+NlqzJJu6qVMTcEwpKd2yEEtJ2OBd" +
       "1JsS1WGZZR2WxVcDYTGyRluiXZvu5vaC7I4cu59ZbUYVqiu7TJd6Jo33ok0U" +
       "MAMlbDu7TdiiFLzpo0lHLC0mmdrodoOhJ+FAWok10x8KrNUVqNHMqVQna8ZZ" +
       "JPxqTlKkOsUNM/LWzQ1p9DoTVm8GImfTKZpK5mo9Untr0K/4m41K2yNzSOML" +
       "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" +
       "8l0/99zfFmdC/wspbab6SicAAA==");
}
