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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Yv+roovNs/8B8wjYZ3kVAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "GJkbIQAA");
}
