package org.apache.batik.bridge;
public class SVGClipPathElementBridge extends org.apache.batik.bridge.AnimatableGenericSVGBridge implements org.apache.batik.bridge.ClipBridge {
    public SVGClipPathElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_CLIP_PATH_TAG; }
    public org.apache.batik.ext.awt.image.renderable.ClipRable createClip(org.apache.batik.bridge.BridgeContext ctx,
                                                                          org.w3c.dom.Element clipElement,
                                                                          org.w3c.dom.Element clipedElement,
                                                                          org.apache.batik.gvt.GraphicsNode clipedNode) {
        java.lang.String s;
        java.awt.geom.AffineTransform Tx;
        s =
          clipElement.
            getAttributeNS(
              null,
              SVG_TRANSFORM_ATTRIBUTE);
        if (s.
              length(
                ) !=
              0) {
            Tx =
              org.apache.batik.bridge.SVGUtilities.
                convertTransform(
                  clipElement,
                  SVG_TRANSFORM_ATTRIBUTE,
                  s,
                  ctx);
        }
        else {
            Tx =
              new java.awt.geom.AffineTransform(
                );
        }
        short coordSystemType;
        s =
          clipElement.
            getAttributeNS(
              null,
              SVG_CLIP_PATH_UNITS_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            coordSystemType =
              org.apache.batik.bridge.SVGUtilities.
                USER_SPACE_ON_USE;
        }
        else {
            coordSystemType =
              org.apache.batik.bridge.SVGUtilities.
                parseCoordinateSystem(
                  clipElement,
                  SVG_CLIP_PATH_UNITS_ATTRIBUTE,
                  s,
                  ctx);
        }
        if (coordSystemType ==
              org.apache.batik.bridge.SVGUtilities.
                OBJECT_BOUNDING_BOX) {
            Tx =
              org.apache.batik.bridge.SVGUtilities.
                toObjectBBox(
                  Tx,
                  clipedNode);
        }
        java.awt.geom.Area clipPath =
          new java.awt.geom.Area(
          );
        org.apache.batik.bridge.GVTBuilder builder =
          ctx.
          getGVTBuilder(
            );
        boolean hasChildren =
          false;
        for (org.w3c.dom.Node node =
               clipElement.
               getFirstChild(
                 );
             node !=
               null;
             node =
               node.
                 getNextSibling(
                   )) {
            if (node.
                  getNodeType(
                    ) !=
                  org.w3c.dom.Node.
                    ELEMENT_NODE) {
                continue;
            }
            org.w3c.dom.Element child =
              (org.w3c.dom.Element)
                node;
            org.apache.batik.gvt.GraphicsNode clipNode =
              builder.
              build(
                ctx,
                child);
            if (clipNode ==
                  null) {
                continue;
            }
            hasChildren =
              true;
            if (child instanceof org.apache.batik.dom.svg.SVGOMUseElement) {
                org.w3c.dom.Node shadowChild =
                  ((org.apache.batik.dom.svg.SVGOMUseElement)
                     child).
                  getCSSFirstChild(
                    );
                if (shadowChild !=
                      null &&
                      shadowChild.
                      getNodeType(
                        ) ==
                      org.w3c.dom.Node.
                        ELEMENT_NODE) {
                    child =
                      (org.w3c.dom.Element)
                        shadowChild;
                }
            }
            int wr =
              org.apache.batik.bridge.CSSUtilities.
              convertClipRule(
                child);
            java.awt.geom.GeneralPath path =
              new java.awt.geom.GeneralPath(
              clipNode.
                getOutline(
                  ));
            path.
              setWindingRule(
                wr);
            java.awt.geom.AffineTransform at =
              clipNode.
              getTransform(
                );
            if (at ==
                  null)
                at =
                  Tx;
            else
                at.
                  preConcatenate(
                    Tx);
            java.awt.Shape outline =
              at.
              createTransformedShape(
                path);
            org.apache.batik.gvt.ShapeNode outlineNode =
              new org.apache.batik.gvt.ShapeNode(
              );
            outlineNode.
              setShape(
                outline);
            org.apache.batik.ext.awt.image.renderable.ClipRable clip =
              org.apache.batik.bridge.CSSUtilities.
              convertClipPath(
                child,
                outlineNode,
                ctx);
            if (clip !=
                  null) {
                java.awt.geom.Area area =
                  new java.awt.geom.Area(
                  outline);
                area.
                  subtract(
                    new java.awt.geom.Area(
                      clip.
                        getClipPath(
                          )));
                outline =
                  area;
            }
            clipPath.
              add(
                new java.awt.geom.Area(
                  outline));
        }
        if (!hasChildren) {
            return null;
        }
        org.apache.batik.gvt.ShapeNode clipPathNode =
          new org.apache.batik.gvt.ShapeNode(
          );
        clipPathNode.
          setShape(
            clipPath);
        org.apache.batik.ext.awt.image.renderable.ClipRable clipElementClipPath =
          org.apache.batik.bridge.CSSUtilities.
          convertClipPath(
            clipElement,
            clipPathNode,
            ctx);
        if (clipElementClipPath !=
              null) {
            clipPath.
              subtract(
                new java.awt.geom.Area(
                  clipElementClipPath.
                    getClipPath(
                      )));
        }
        org.apache.batik.ext.awt.image.renderable.Filter filter =
          clipedNode.
          getFilter(
            );
        if (filter ==
              null) {
            filter =
              clipedNode.
                getGraphicsNodeRable(
                  true);
        }
        boolean useAA =
          false;
        java.awt.RenderingHints hints;
        hints =
          org.apache.batik.bridge.CSSUtilities.
            convertShapeRendering(
              clipElement,
              null);
        if (hints !=
              null) {
            java.lang.Object o =
              hints.
              get(
                java.awt.RenderingHints.
                  KEY_ANTIALIASING);
            useAA =
              o ==
                java.awt.RenderingHints.
                  VALUE_ANTIALIAS_ON;
        }
        return new org.apache.batik.ext.awt.image.renderable.ClipRable8Bit(
          filter,
          clipPath,
          useAA);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1YfWwcRxWfO387/k5shyS2E8cJihPuElIDlUOp7dqJw9kx" +
       "dmqBQ3OZ252723hvd7M7Z59dAkmlquGfKkqTJlTUf7mqQKWtEBUg0cqoEm1V" +
       "QGqJgIIakPinfEQ0Qip/hK/3Zj9vz5coCHHSzs7NvHkz7+v33uwLN0mVZZJu" +
       "pvEYXzKYFRvV+BQ1LSaPqNSyjsNYUrpaQf928oPJ+6Okeo40Zak1IVGLjSlM" +
       "la050qVoFqeaxKxJxmRcMWUyi5kLlCu6NkfaFWs8Z6iKpPAJXWZIMEvNBGml" +
       "nJtKKs/ZuMOAk64EnCQuThIfCk8PJkiDpBtLPvnmAPlIYAYpc/5eFictidN0" +
       "gcbzXFHjCcXigwWT7DV0dSmj6jzGCjx2Wh1wVHA0MVCigt6Xmz+6fTHbIlSw" +
       "kWqazoV41jSzdHWByQnS7I+OqixnnSFfJRUJsiFAzElfwt00DpvGYVNXWp8K" +
       "Tt/ItHxuRBficJdTtSHhgTjZUczEoCbNOWymxJmBQy13ZBeLQdrtnrS2lCUi" +
       "Xtkbv3z1ZMt3K0jzHGlWtBk8jgSH4LDJHCiU5VLMtIZkmclzpFUDY88wU6Gq" +
       "suxYus1SMhrleTC/qxYczBvMFHv6ugI7gmxmXuK66YmXFg7l/KtKqzQDsnb4" +
       "stoSjuE4CFivwMHMNAW/c5ZUziuazElPeIUnY9/ngQCW1uQYz+reVpUahQHS" +
       "ZruISrVMfAZcT8sAaZUODmhysqUsU9S1QaV5mmFJ9MgQ3ZQ9BVR1QhG4hJP2" +
       "MJngBFbaErJSwD43Jw89+ah2RIuSCJxZZpKK598Ai7pDi6ZZmpkM4sBe2NCf" +
       "eJp2vHohSggQt4eIbZrvf+XWg/u61960abauQ3MsdZpJPCmtppre2Tay5/4K" +
       "PEatoVsKGr9IchFlU87MYMEAhOnwOOJkzJ1cm/7Jl859m/05SurHSbWkq/kc" +
       "+FGrpOcMRWXmYaYxk3Imj5M6pskjYn6c1EA/oWjMHj2WTluMj5NKVQxV6+I/" +
       "qCgNLFBF9dBXtLTu9g3Ks6JfMAghNfCQLnj2EvvXjw0nUjyr51icSlRTND0+" +
       "ZeoovxUHxEmBbrPxFHj9fNzS8ya4YFw3M3EKfpBlzkTKVOQMi8/MHh5RFWMK" +
       "9kRUgNXDYiKGzmb8f7YpoLQbFyMRMMS2MAyoEEFHdFVmZlK6nB8evfVi8m3b" +
       "xTAsHD1xsh92jtk7x8TOMXvnWLmdSSQiNtyEJ7CtDjabh+gH+G3YM/PI0VMX" +
       "eivA3YzFSlA4kvYWpaERHyJcXE9KL7U1Lu+4ceD1KKlMkDYq8TxVMasMmRnA" +
       "K2neCemGFCQoP09sD+QJTHCmLjEZYKpcvnC41OoLzMRxTjYFOLhZDOM1Xj6H" +
       "rHt+snZt8fzs1/ZHSbQ4NeCWVYBquHwKAd0D7r4wJKzHt/mJDz566emzug8O" +
       "RbnGTZElK1GG3rBLhNWTlPq301eSr57tE2qvA/DmFIINcLE7vEcR9gy6OI6y" +
       "1ILAad3MURWnXB3X86ypL/ojwldbRX8TuMUGDMad8Ox3olO8cbbDwLbT9m30" +
       "s5AUIk98dsZ49tc//+NBoW43pTQHaoEZxgcDMIbM2gRgtfpue9xkDOjevzb1" +
       "1JWbT5wQPgsUO9fbsA/bEYAvMCGo+fE3z7z3uxur16O+n3PI4/kUlEMFT0gc" +
       "J/V3EBJ22+2fB2BQBYxAr+l7WAP/VNIKTakMA+sfzbsOvPKXJ1tsP1BhxHWj" +
       "fXdn4I9/bJice/vk37sFm4iEadjXmU9mY/tGn/OQadIlPEfh/Ltd33iDPgtZ" +
       "ApDZUpaZAFsidECE0QaE/PtFe19o7tPY7LKCzl8cX4FyKSldvP5h4+yHr90S" +
       "py2ut4K2nqDGoO1e2OwuAPvOMDgdoVYW6O5bm/xyi7p2GzjOAUcJoNc6ZgJG" +
       "Foo8w6GuqvnNj1/vOPVOBYmOkXpVp/IYFUFG6sC7mZUFeC0Yn3vQNu5iLTQt" +
       "QlRSInzJACq4Z33TjeYMLpS9/IPO7x16fuWG8DLD5rE1yPDj2Oz1/E38qt1U" +
       "576D/uZziIj+Zk56yyUARH8b8lGjXeUKGFF8rT52eUU+9twBu8xoKy4KRqHm" +
       "/c4v//nT2LXfv7VOBqrjuvEJlS0wNXC8KG5ZlDYmRG3nQ9f7TZf+8MO+zPC9" +
       "ZAwc675LTsD/PSBEf/kMED7KG4/9acvxB7Kn7gH8e0LqDLP81sQLbx3eLV2K" +
       "ikLWxv2SArh40WBQsbCpyaBi11BMHGkUEbLT85U2dI1ueAYcXxlYH4DXcTMP" +
       "1sotvQMAzN5h7ovYfIGThgyUebpE1UmQxnXTFhErWMTH7CJeTHwGm2k7GAb/" +
       "y0DEgSFDjE94MrbjXA88Q46MQ/eunnJLQyqoFAepdAXdVS4e7Vh07m0u9Uak" +
       "XjwoxWQ9F3PqNJzKugQ7SthlFnjssEmNrCJZk+DwQhJ2B7vksDnFSb1kMija" +
       "ERdc7gdLuGOw0EUeU3JwO4pBxQDgijlIwMk09nzD0f+F4QpwRSlXqyLIbi65" +
       "H9t3OunFlebazpWHfyUAxLt3NQAUpPOqGoikYFRVGyZLK0ItDXbOMcRrkZPO" +
       "MoaDwsDuCAkWbPpl8OgwPSdV4h2kOwtq9+mAld0JkpzjpAJIsHveM8wny3nR" +
       "kAaW4WgHcQlTJNCdg/KR0gQjzNR+NzN5S4LFEzqC+ILhIlze/oYBtf7K0clH" +
       "b33qObt4k1S6vCxuvHCBt+tIDyV3lOXm8qo+sud208t1u6KOr7baB/aDc2vA" +
       "kSEQIwb6xJZQZWP1eQXOe6uHXvvZhep3IVGdIBEKEXYi8P3AvixDeZSH9HQi" +
       "4SeowBcwUXIN7nlm6YF96b/+VuRuYt+DtpWnT0rXn3/kF5c2r0JptmGcVEFO" +
       "ZYU5Uq9YDy1p00xaMOdIo2KNFuCIwEWh6jipzWvKmTwblxOkCd2XIiwKvTjq" +
       "bPRGsfSHVF/yEWOdCxPUOYvMHNbzmizyBmQ0f6To04qbaPKGEVrgj3im3FQq" +
       "e1J66OvNP7rYVjEGIVgkTpB9jZVPeUks+LXFz2otNvb+G34ReP6FDxodB/DN" +
       "SduI8+Vhu/fpAQoqe64imZgwDJe26puGHURPYXOlgOOcRPqdUQSgiF1A4d9r" +
       "Yv+roovNM/8BC94q23kVAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Wy9+I7+i/B/EQUFhGyEAAA==");
}
