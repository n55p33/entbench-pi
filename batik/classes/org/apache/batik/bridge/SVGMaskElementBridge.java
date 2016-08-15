package org.apache.batik.bridge;
public class SVGMaskElementBridge extends org.apache.batik.bridge.AnimatableGenericSVGBridge implements org.apache.batik.bridge.MaskBridge {
    public SVGMaskElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_MASK_TAG; }
    public org.apache.batik.gvt.filter.Mask createMask(org.apache.batik.bridge.BridgeContext ctx,
                                                       org.w3c.dom.Element maskElement,
                                                       org.w3c.dom.Element maskedElement,
                                                       org.apache.batik.gvt.GraphicsNode maskedNode) {
        java.lang.String s;
        java.awt.geom.Rectangle2D maskRegion =
          org.apache.batik.bridge.SVGUtilities.
          convertMaskRegion(
            maskElement,
            maskedElement,
            maskedNode,
            ctx);
        org.apache.batik.bridge.GVTBuilder builder =
          ctx.
          getGVTBuilder(
            );
        org.apache.batik.gvt.CompositeGraphicsNode maskNode =
          new org.apache.batik.gvt.CompositeGraphicsNode(
          );
        org.apache.batik.gvt.CompositeGraphicsNode maskNodeContent =
          new org.apache.batik.gvt.CompositeGraphicsNode(
          );
        maskNode.
          getChildren(
            ).
          add(
            maskNodeContent);
        boolean hasChildren =
          false;
        for (org.w3c.dom.Node node =
               maskElement.
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
            org.apache.batik.gvt.GraphicsNode gn =
              builder.
              build(
                ctx,
                child);
            if (gn ==
                  null) {
                continue;
            }
            hasChildren =
              true;
            maskNodeContent.
              getChildren(
                ).
              add(
                gn);
        }
        if (!hasChildren) {
            return null;
        }
        java.awt.geom.AffineTransform Tx;
        s =
          maskElement.
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
                  maskElement,
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
          maskElement.
            getAttributeNS(
              null,
              SVG_MASK_CONTENT_UNITS_ATTRIBUTE);
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
                  maskElement,
                  SVG_MASK_CONTENT_UNITS_ATTRIBUTE,
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
                  maskedNode);
        }
        maskNodeContent.
          setTransform(
            Tx);
        org.apache.batik.ext.awt.image.renderable.Filter filter =
          maskedNode.
          getFilter(
            );
        if (filter ==
              null) {
            filter =
              maskedNode.
                getGraphicsNodeRable(
                  true);
        }
        return new org.apache.batik.gvt.filter.MaskRable8Bit(
          filter,
          maskNode,
          maskRegion);
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
       "Lwg2f3D/773lt174Zn7m+D9Bswt14CAAAA==");
}
