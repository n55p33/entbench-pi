package org.apache.batik.bridge;
public class SVGMarkerElementBridge extends org.apache.batik.bridge.AnimatableGenericSVGBridge implements org.apache.batik.bridge.MarkerBridge, org.apache.batik.bridge.ErrorConstants {
    protected SVGMarkerElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_MARKER_TAG; }
    public org.apache.batik.gvt.Marker createMarker(org.apache.batik.bridge.BridgeContext ctx,
                                                    org.w3c.dom.Element markerElement,
                                                    org.w3c.dom.Element paintedElement) {
        org.apache.batik.bridge.GVTBuilder builder =
          ctx.
          getGVTBuilder(
            );
        org.apache.batik.gvt.CompositeGraphicsNode markerContentNode =
          new org.apache.batik.gvt.CompositeGraphicsNode(
          );
        boolean hasChildren =
          false;
        for (org.w3c.dom.Node n =
               markerElement.
               getFirstChild(
                 );
             n !=
               null;
             n =
               n.
                 getNextSibling(
                   )) {
            if (n.
                  getNodeType(
                    ) !=
                  org.w3c.dom.Node.
                    ELEMENT_NODE) {
                continue;
            }
            org.w3c.dom.Element child =
              (org.w3c.dom.Element)
                n;
            org.apache.batik.gvt.GraphicsNode markerNode =
              builder.
              build(
                ctx,
                child);
            if (markerNode ==
                  null) {
                continue;
            }
            hasChildren =
              true;
            markerContentNode.
              getChildren(
                ).
              add(
                markerNode);
        }
        if (!hasChildren) {
            return null;
        }
        java.lang.String s;
        org.apache.batik.parser.UnitProcessor.Context uctx =
          org.apache.batik.bridge.UnitProcessor.
          createContext(
            ctx,
            paintedElement);
        float markerWidth =
          3;
        s =
          markerElement.
            getAttributeNS(
              null,
              SVG_MARKER_WIDTH_ATTRIBUTE);
        if (s.
              length(
                ) !=
              0) {
            markerWidth =
              org.apache.batik.bridge.UnitProcessor.
                svgHorizontalLengthToUserSpace(
                  s,
                  SVG_MARKER_WIDTH_ATTRIBUTE,
                  uctx);
        }
        if (markerWidth ==
              0) {
            return null;
        }
        float markerHeight =
          3;
        s =
          markerElement.
            getAttributeNS(
              null,
              SVG_MARKER_HEIGHT_ATTRIBUTE);
        if (s.
              length(
                ) !=
              0) {
            markerHeight =
              org.apache.batik.bridge.UnitProcessor.
                svgVerticalLengthToUserSpace(
                  s,
                  SVG_MARKER_HEIGHT_ATTRIBUTE,
                  uctx);
        }
        if (markerHeight ==
              0) {
            return null;
        }
        double orient;
        s =
          markerElement.
            getAttributeNS(
              null,
              SVG_ORIENT_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            orient =
              0;
        }
        else
            if (SVG_AUTO_VALUE.
                  equals(
                    s)) {
                orient =
                  java.lang.Double.
                    NaN;
            }
            else {
                try {
                    orient =
                      org.apache.batik.bridge.SVGUtilities.
                        convertSVGNumber(
                          s);
                }
                catch (java.lang.NumberFormatException nfEx) {
                    throw new org.apache.batik.bridge.BridgeException(
                      ctx,
                      markerElement,
                      nfEx,
                      ERR_ATTRIBUTE_VALUE_MALFORMED,
                      new java.lang.Object[] { SVG_ORIENT_ATTRIBUTE,
                      s });
                }
            }
        org.apache.batik.css.engine.value.Value val =
          org.apache.batik.bridge.CSSUtilities.
          getComputedStyle(
            paintedElement,
            org.apache.batik.css.engine.SVGCSSEngine.
              STROKE_WIDTH_INDEX);
        float strokeWidth =
          val.
          getFloatValue(
            );
        short unitsType;
        s =
          markerElement.
            getAttributeNS(
              null,
              SVG_MARKER_UNITS_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            unitsType =
              org.apache.batik.bridge.SVGUtilities.
                STROKE_WIDTH;
        }
        else {
            unitsType =
              org.apache.batik.bridge.SVGUtilities.
                parseMarkerCoordinateSystem(
                  markerElement,
                  SVG_MARKER_UNITS_ATTRIBUTE,
                  s,
                  ctx);
        }
        java.awt.geom.AffineTransform markerTxf;
        if (unitsType ==
              org.apache.batik.bridge.SVGUtilities.
                STROKE_WIDTH) {
            markerTxf =
              new java.awt.geom.AffineTransform(
                );
            markerTxf.
              scale(
                strokeWidth,
                strokeWidth);
        }
        else {
            markerTxf =
              new java.awt.geom.AffineTransform(
                );
        }
        java.awt.geom.AffineTransform preserveAspectRatioTransform =
          org.apache.batik.bridge.ViewBox.
          getPreserveAspectRatioTransform(
            markerElement,
            markerWidth,
            markerHeight,
            ctx);
        if (preserveAspectRatioTransform ==
              null) {
            return null;
        }
        else {
            markerTxf.
              concatenate(
                preserveAspectRatioTransform);
        }
        markerContentNode.
          setTransform(
            markerTxf);
        if (org.apache.batik.bridge.CSSUtilities.
              convertOverflow(
                markerElement)) {
            java.awt.geom.Rectangle2D markerClip;
            float[] offsets =
              org.apache.batik.bridge.CSSUtilities.
              convertClip(
                markerElement);
            if (offsets ==
                  null) {
                markerClip =
                  new java.awt.geom.Rectangle2D.Float(
                    0,
                    0,
                    strokeWidth *
                      markerWidth,
                    strokeWidth *
                      markerHeight);
            }
            else {
                markerClip =
                  new java.awt.geom.Rectangle2D.Float(
                    offsets[3],
                    offsets[0],
                    strokeWidth *
                      markerWidth -
                      offsets[1] -
                      offsets[3],
                    strokeWidth *
                      markerHeight -
                      offsets[2] -
                      offsets[0]);
            }
            org.apache.batik.gvt.CompositeGraphicsNode comp =
              new org.apache.batik.gvt.CompositeGraphicsNode(
              );
            comp.
              getChildren(
                ).
              add(
                markerContentNode);
            org.apache.batik.ext.awt.image.renderable.Filter clipSrc =
              comp.
              getGraphicsNodeRable(
                true);
            comp.
              setClip(
                new org.apache.batik.ext.awt.image.renderable.ClipRable8Bit(
                  clipSrc,
                  markerClip));
            markerContentNode =
              comp;
        }
        float refX =
          0;
        s =
          markerElement.
            getAttributeNS(
              null,
              SVG_REF_X_ATTRIBUTE);
        if (s.
              length(
                ) !=
              0) {
            refX =
              org.apache.batik.bridge.UnitProcessor.
                svgHorizontalCoordinateToUserSpace(
                  s,
                  SVG_REF_X_ATTRIBUTE,
                  uctx);
        }
        float refY =
          0;
        s =
          markerElement.
            getAttributeNS(
              null,
              SVG_REF_Y_ATTRIBUTE);
        if (s.
              length(
                ) !=
              0) {
            refY =
              org.apache.batik.bridge.UnitProcessor.
                svgVerticalCoordinateToUserSpace(
                  s,
                  SVG_REF_Y_ATTRIBUTE,
                  uctx);
        }
        float[] ref =
          { refX,
        refY };
        markerTxf.
          transform(
            ref,
            0,
            ref,
            0,
            1);
        org.apache.batik.gvt.Marker marker =
          new org.apache.batik.gvt.Marker(
          markerContentNode,
          new java.awt.geom.Point2D.Float(
            ref[0],
            ref[1]),
          orient);
        return marker;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "1uatG3sVAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
