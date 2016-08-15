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
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "MF+nexUAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
