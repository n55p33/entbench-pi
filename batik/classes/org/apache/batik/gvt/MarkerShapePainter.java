package org.apache.batik.gvt;
public class MarkerShapePainter implements org.apache.batik.gvt.ShapePainter {
    protected org.apache.batik.ext.awt.geom.ExtendedShape extShape;
    protected org.apache.batik.gvt.Marker startMarker;
    protected org.apache.batik.gvt.Marker middleMarker;
    protected org.apache.batik.gvt.Marker endMarker;
    private org.apache.batik.gvt.ProxyGraphicsNode startMarkerProxy;
    private org.apache.batik.gvt.ProxyGraphicsNode[] middleMarkerProxies;
    private org.apache.batik.gvt.ProxyGraphicsNode endMarkerProxy;
    private org.apache.batik.gvt.CompositeGraphicsNode markerGroup;
    private java.awt.geom.Rectangle2D dPrimitiveBounds;
    private java.awt.geom.Rectangle2D dGeometryBounds;
    public MarkerShapePainter(java.awt.Shape shape) { super();
                                                      if (shape == null) {
                                                          throw new java.lang.IllegalArgumentException(
                                                            );
                                                      }
                                                      if (shape instanceof org.apache.batik.ext.awt.geom.ExtendedShape) {
                                                          this.
                                                            extShape =
                                                            (org.apache.batik.ext.awt.geom.ExtendedShape)
                                                              shape;
                                                      }
                                                      else {
                                                          this.
                                                            extShape =
                                                            new org.apache.batik.ext.awt.geom.ShapeExtender(
                                                              shape);
                                                      }
    }
    public void paint(java.awt.Graphics2D g2d) {
        if (markerGroup ==
              null) {
            buildMarkerGroup(
              );
        }
        if (markerGroup.
              getChildren(
                ).
              size(
                ) >
              0) {
            markerGroup.
              paint(
                g2d);
        }
    }
    public java.awt.Shape getPaintedArea() {
        if (markerGroup ==
              null) {
            buildMarkerGroup(
              );
        }
        return markerGroup.
          getOutline(
            );
    }
    public java.awt.geom.Rectangle2D getPaintedBounds2D() {
        if (markerGroup ==
              null) {
            buildMarkerGroup(
              );
        }
        return markerGroup.
          getPrimitiveBounds(
            );
    }
    public boolean inPaintedArea(java.awt.geom.Point2D pt) {
        if (markerGroup ==
              null) {
            buildMarkerGroup(
              );
        }
        org.apache.batik.gvt.GraphicsNode gn =
          markerGroup.
          nodeHitAt(
            pt);
        return gn !=
          null;
    }
    public java.awt.Shape getSensitiveArea() {
        return null;
    }
    public java.awt.geom.Rectangle2D getSensitiveBounds2D() {
        return null;
    }
    public boolean inSensitiveArea(java.awt.geom.Point2D pt) {
        return false;
    }
    public void setShape(java.awt.Shape shape) {
        if (shape ==
              null) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        if (shape instanceof org.apache.batik.ext.awt.geom.ExtendedShape) {
            this.
              extShape =
              (org.apache.batik.ext.awt.geom.ExtendedShape)
                shape;
        }
        else {
            this.
              extShape =
              new org.apache.batik.ext.awt.geom.ShapeExtender(
                shape);
        }
        this.
          startMarkerProxy =
          null;
        this.
          middleMarkerProxies =
          null;
        this.
          endMarkerProxy =
          null;
        this.
          markerGroup =
          null;
    }
    public org.apache.batik.ext.awt.geom.ExtendedShape getExtShape() {
        return extShape;
    }
    public java.awt.Shape getShape() { return extShape;
    }
    public org.apache.batik.gvt.Marker getStartMarker() {
        return startMarker;
    }
    public void setStartMarker(org.apache.batik.gvt.Marker startMarker) {
        this.
          startMarker =
          startMarker;
        this.
          startMarkerProxy =
          null;
        this.
          markerGroup =
          null;
    }
    public org.apache.batik.gvt.Marker getMiddleMarker() {
        return middleMarker;
    }
    public void setMiddleMarker(org.apache.batik.gvt.Marker middleMarker) {
        this.
          middleMarker =
          middleMarker;
        this.
          middleMarkerProxies =
          null;
        this.
          markerGroup =
          null;
    }
    public org.apache.batik.gvt.Marker getEndMarker() {
        return endMarker;
    }
    public void setEndMarker(org.apache.batik.gvt.Marker endMarker) {
        this.
          endMarker =
          endMarker;
        this.
          endMarkerProxy =
          null;
        this.
          markerGroup =
          null;
    }
    protected void buildMarkerGroup() { if (startMarker !=
                                              null &&
                                              startMarkerProxy ==
                                              null) {
                                            startMarkerProxy =
                                              buildStartMarkerProxy(
                                                );
                                        }
                                        if (middleMarker !=
                                              null &&
                                              middleMarkerProxies ==
                                              null) {
                                            middleMarkerProxies =
                                              buildMiddleMarkerProxies(
                                                );
                                        }
                                        if (endMarker !=
                                              null &&
                                              endMarkerProxy ==
                                              null) {
                                            endMarkerProxy =
                                              buildEndMarkerProxy(
                                                );
                                        }
                                        org.apache.batik.gvt.CompositeGraphicsNode group =
                                          new org.apache.batik.gvt.CompositeGraphicsNode(
                                          );
                                        java.util.List children =
                                          group.
                                          getChildren(
                                            );
                                        if (startMarkerProxy !=
                                              null) {
                                            children.
                                              add(
                                                startMarkerProxy);
                                        }
                                        if (middleMarkerProxies !=
                                              null) {
                                            for (int i =
                                                   0;
                                                 i <
                                                   middleMarkerProxies.
                                                     length;
                                                 i++) {
                                                children.
                                                  add(
                                                    middleMarkerProxies[i]);
                                            }
                                        }
                                        if (endMarkerProxy !=
                                              null) {
                                            children.
                                              add(
                                                endMarkerProxy);
                                        }
                                        markerGroup =
                                          group;
    }
    protected org.apache.batik.gvt.ProxyGraphicsNode buildStartMarkerProxy() {
        org.apache.batik.ext.awt.geom.ExtendedPathIterator iter =
          getExtShape(
            ).
          getExtendedPathIterator(
            );
        double[] coords =
          new double[7];
        int segType =
          0;
        if (iter.
              isDone(
                )) {
            return null;
        }
        segType =
          iter.
            currentSegment(
              coords);
        if (segType !=
              org.apache.batik.ext.awt.geom.ExtendedPathIterator.
                SEG_MOVETO) {
            return null;
        }
        iter.
          next(
            );
        java.awt.geom.Point2D markerPosition =
          new java.awt.geom.Point2D.Double(
          coords[0],
          coords[1]);
        double rotation =
          startMarker.
          getOrient(
            );
        if (java.lang.Double.
              isNaN(
                rotation)) {
            if (!iter.
                  isDone(
                    )) {
                double[] next =
                  new double[7];
                int nextSegType =
                  0;
                nextSegType =
                  iter.
                    currentSegment(
                      next);
                if (nextSegType ==
                      java.awt.geom.PathIterator.
                        SEG_CLOSE) {
                    nextSegType =
                      java.awt.geom.PathIterator.
                        SEG_LINETO;
                    next[0] =
                      coords[0];
                    next[1] =
                      coords[1];
                }
                rotation =
                  computeRotation(
                    null,
                    0,
                    coords,
                    segType,
                    next,
                    nextSegType);
            }
        }
        java.awt.geom.AffineTransform markerTxf =
          computeMarkerTransform(
            startMarker,
            markerPosition,
            rotation);
        org.apache.batik.gvt.ProxyGraphicsNode gn =
          new org.apache.batik.gvt.ProxyGraphicsNode(
          );
        gn.
          setSource(
            startMarker.
              getMarkerNode(
                ));
        gn.
          setTransform(
            markerTxf);
        return gn;
    }
    protected org.apache.batik.gvt.ProxyGraphicsNode buildEndMarkerProxy() {
        org.apache.batik.ext.awt.geom.ExtendedPathIterator iter =
          getExtShape(
            ).
          getExtendedPathIterator(
            );
        int nPoints =
          0;
        if (iter.
              isDone(
                )) {
            return null;
        }
        double[] coords =
          new double[7];
        double[] moveTo =
          new double[2];
        int segType =
          0;
        segType =
          iter.
            currentSegment(
              coords);
        if (segType !=
              org.apache.batik.ext.awt.geom.ExtendedPathIterator.
                SEG_MOVETO) {
            return null;
        }
        nPoints++;
        moveTo[0] =
          coords[0];
        moveTo[1] =
          coords[1];
        iter.
          next(
            );
        double[] lastButOne =
          new double[7];
        double[] last =
          { coords[0],
        coords[1],
        coords[2],
        coords[3],
        coords[4],
        coords[5],
        coords[6] };
        double[] tmp =
          null;
        int lastSegType =
          segType;
        int lastButOneSegType =
          0;
        while (!iter.
                 isDone(
                   )) {
            tmp =
              lastButOne;
            lastButOne =
              last;
            last =
              tmp;
            lastButOneSegType =
              lastSegType;
            lastSegType =
              iter.
                currentSegment(
                  last);
            if (lastSegType ==
                  java.awt.geom.PathIterator.
                    SEG_MOVETO) {
                moveTo[0] =
                  last[0];
                moveTo[1] =
                  last[1];
            }
            else
                if (lastSegType ==
                      java.awt.geom.PathIterator.
                        SEG_CLOSE) {
                    lastSegType =
                      java.awt.geom.PathIterator.
                        SEG_LINETO;
                    last[0] =
                      moveTo[0];
                    last[1] =
                      moveTo[1];
                }
            iter.
              next(
                );
            nPoints++;
        }
        if (nPoints <
              2) {
            return null;
        }
        java.awt.geom.Point2D markerPosition =
          getSegmentTerminatingPoint(
            last,
            lastSegType);
        double rotation =
          endMarker.
          getOrient(
            );
        if (java.lang.Double.
              isNaN(
                rotation)) {
            rotation =
              computeRotation(
                lastButOne,
                lastButOneSegType,
                last,
                lastSegType,
                null,
                0);
        }
        java.awt.geom.AffineTransform markerTxf =
          computeMarkerTransform(
            endMarker,
            markerPosition,
            rotation);
        org.apache.batik.gvt.ProxyGraphicsNode gn =
          new org.apache.batik.gvt.ProxyGraphicsNode(
          );
        gn.
          setSource(
            endMarker.
              getMarkerNode(
                ));
        gn.
          setTransform(
            markerTxf);
        return gn;
    }
    protected org.apache.batik.gvt.ProxyGraphicsNode[] buildMiddleMarkerProxies() {
        org.apache.batik.ext.awt.geom.ExtendedPathIterator iter =
          getExtShape(
            ).
          getExtendedPathIterator(
            );
        double[] prev =
          new double[7];
        double[] curr =
          new double[7];
        double[] next =
          new double[7];
        double[] tmp =
          null;
        int prevSegType =
          0;
        int currSegType =
          0;
        int nextSegType =
          0;
        if (iter.
              isDone(
                )) {
            return null;
        }
        prevSegType =
          iter.
            currentSegment(
              prev);
        double[] moveTo =
          new double[2];
        if (prevSegType !=
              java.awt.geom.PathIterator.
                SEG_MOVETO) {
            return null;
        }
        moveTo[0] =
          prev[0];
        moveTo[1] =
          prev[1];
        iter.
          next(
            );
        if (iter.
              isDone(
                )) {
            return null;
        }
        currSegType =
          iter.
            currentSegment(
              curr);
        if (currSegType ==
              java.awt.geom.PathIterator.
                SEG_MOVETO) {
            moveTo[0] =
              curr[0];
            moveTo[1] =
              curr[1];
        }
        else
            if (currSegType ==
                  java.awt.geom.PathIterator.
                    SEG_CLOSE) {
                currSegType =
                  java.awt.geom.PathIterator.
                    SEG_LINETO;
                curr[0] =
                  moveTo[0];
                curr[1] =
                  moveTo[1];
            }
        iter.
          next(
            );
        java.util.List proxies =
          new java.util.ArrayList(
          );
        while (!iter.
                 isDone(
                   )) {
            nextSegType =
              iter.
                currentSegment(
                  next);
            if (nextSegType ==
                  java.awt.geom.PathIterator.
                    SEG_MOVETO) {
                moveTo[0] =
                  next[0];
                moveTo[1] =
                  next[1];
            }
            else
                if (nextSegType ==
                      java.awt.geom.PathIterator.
                        SEG_CLOSE) {
                    nextSegType =
                      java.awt.geom.PathIterator.
                        SEG_LINETO;
                    next[0] =
                      moveTo[0];
                    next[1] =
                      moveTo[1];
                }
            proxies.
              add(
                createMiddleMarker(
                  prev,
                  prevSegType,
                  curr,
                  currSegType,
                  next,
                  nextSegType));
            tmp =
              prev;
            prev =
              curr;
            prevSegType =
              currSegType;
            curr =
              next;
            currSegType =
              nextSegType;
            next =
              tmp;
            iter.
              next(
                );
        }
        org.apache.batik.gvt.ProxyGraphicsNode[] gn =
          new org.apache.batik.gvt.ProxyGraphicsNode[proxies.
                                                       size(
                                                         )];
        proxies.
          toArray(
            gn);
        return gn;
    }
    private org.apache.batik.gvt.ProxyGraphicsNode createMiddleMarker(double[] prev,
                                                                      int prevSegType,
                                                                      double[] curr,
                                                                      int currSegType,
                                                                      double[] next,
                                                                      int nextSegType) {
        java.awt.geom.Point2D markerPosition =
          getSegmentTerminatingPoint(
            curr,
            currSegType);
        double rotation =
          middleMarker.
          getOrient(
            );
        if (java.lang.Double.
              isNaN(
                rotation)) {
            rotation =
              computeRotation(
                prev,
                prevSegType,
                curr,
                currSegType,
                next,
                nextSegType);
        }
        java.awt.geom.AffineTransform markerTxf =
          computeMarkerTransform(
            middleMarker,
            markerPosition,
            rotation);
        org.apache.batik.gvt.ProxyGraphicsNode gn =
          new org.apache.batik.gvt.ProxyGraphicsNode(
          );
        gn.
          setSource(
            middleMarker.
              getMarkerNode(
                ));
        gn.
          setTransform(
            markerTxf);
        return gn;
    }
    private double computeRotation(double[] prev,
                                   int prevSegType,
                                   double[] curr,
                                   int currSegType,
                                   double[] next,
                                   int nextSegType) {
        double[] inSlope =
          computeInSlope(
            prev,
            prevSegType,
            curr,
            currSegType);
        double[] outSlope =
          computeOutSlope(
            curr,
            currSegType,
            next,
            nextSegType);
        if (inSlope ==
              null) {
            inSlope =
              outSlope;
        }
        if (outSlope ==
              null) {
            outSlope =
              inSlope;
        }
        if (inSlope ==
              null) {
            return 0;
        }
        double dx =
          inSlope[0] +
          outSlope[0];
        double dy =
          inSlope[1] +
          outSlope[1];
        if (dx ==
              0 &&
              dy ==
              0) {
            return java.lang.Math.
              toDegrees(
                java.lang.Math.
                  atan2(
                    inSlope[1],
                    inSlope[0])) +
              90;
        }
        else {
            return java.lang.Math.
              toDegrees(
                java.lang.Math.
                  atan2(
                    dy,
                    dx));
        }
    }
    private double[] computeInSlope(double[] prev,
                                    int prevSegType,
                                    double[] curr,
                                    int currSegType) {
        java.awt.geom.Point2D currEndPoint =
          getSegmentTerminatingPoint(
            curr,
            currSegType);
        double dx =
          0;
        double dy =
          0;
        switch (currSegType) {
            case java.awt.geom.PathIterator.
                   SEG_LINETO:
                {
                    java.awt.geom.Point2D prevEndPoint =
                      getSegmentTerminatingPoint(
                        prev,
                        prevSegType);
                    dx =
                      currEndPoint.
                        getX(
                          ) -
                        prevEndPoint.
                        getX(
                          );
                    dy =
                      currEndPoint.
                        getY(
                          ) -
                        prevEndPoint.
                        getY(
                          );
                }
                break;
            case java.awt.geom.PathIterator.
                   SEG_QUADTO:
                dx =
                  currEndPoint.
                    getX(
                      ) -
                    curr[0];
                dy =
                  currEndPoint.
                    getY(
                      ) -
                    curr[1];
                break;
            case java.awt.geom.PathIterator.
                   SEG_CUBICTO:
                dx =
                  currEndPoint.
                    getX(
                      ) -
                    curr[2];
                dy =
                  currEndPoint.
                    getY(
                      ) -
                    curr[3];
                break;
            case org.apache.batik.ext.awt.geom.ExtendedPathIterator.
                   SEG_ARCTO:
                {
                    java.awt.geom.Point2D prevEndPoint =
                      getSegmentTerminatingPoint(
                        prev,
                        prevSegType);
                    boolean large =
                      curr[3] !=
                      0.0;
                    boolean goLeft =
                      curr[4] !=
                      0.0;
                    java.awt.geom.Arc2D arc =
                      org.apache.batik.ext.awt.geom.ExtendedGeneralPath.
                      computeArc(
                        prevEndPoint.
                          getX(
                            ),
                        prevEndPoint.
                          getY(
                            ),
                        curr[0],
                        curr[1],
                        curr[2],
                        large,
                        goLeft,
                        curr[5],
                        curr[6]);
                    double theta =
                      arc.
                      getAngleStart(
                        ) +
                      arc.
                      getAngleExtent(
                        );
                    theta =
                      java.lang.Math.
                        toRadians(
                          theta);
                    dx =
                      -arc.
                        getWidth(
                          ) /
                        2.0 *
                        java.lang.Math.
                        sin(
                          theta);
                    dy =
                      arc.
                        getHeight(
                          ) /
                        2.0 *
                        java.lang.Math.
                        cos(
                          theta);
                    if (curr[2] !=
                          0) {
                        double ang =
                          java.lang.Math.
                          toRadians(
                            -curr[2]);
                        double sinA =
                          java.lang.Math.
                          sin(
                            ang);
                        double cosA =
                          java.lang.Math.
                          cos(
                            ang);
                        double tdx =
                          dx *
                          cosA -
                          dy *
                          sinA;
                        double tdy =
                          dx *
                          sinA +
                          dy *
                          cosA;
                        dx =
                          tdx;
                        dy =
                          tdy;
                    }
                    if (goLeft) {
                        dx =
                          -dx;
                    }
                    else {
                        dy =
                          -dy;
                    }
                }
                break;
            case java.awt.geom.PathIterator.
                   SEG_CLOSE:
                throw new java.lang.Error(
                  "should not have SEG_CLOSE here");
            case java.awt.geom.PathIterator.
                   SEG_MOVETO:
            default:
                return null;
        }
        if (dx ==
              0 &&
              dy ==
              0) {
            return null;
        }
        return normalize(
                 new double[] { dx,
                 dy });
    }
    private double[] computeOutSlope(double[] curr,
                                     int currSegType,
                                     double[] next,
                                     int nextSegType) {
        java.awt.geom.Point2D currEndPoint =
          getSegmentTerminatingPoint(
            curr,
            currSegType);
        double dx =
          0;
        double dy =
          0;
        switch (nextSegType) {
            case java.awt.geom.PathIterator.
                   SEG_CLOSE:
                break;
            case java.awt.geom.PathIterator.
                   SEG_CUBICTO:
            case java.awt.geom.PathIterator.
                   SEG_LINETO:
            case java.awt.geom.PathIterator.
                   SEG_QUADTO:
                dx =
                  next[0] -
                    currEndPoint.
                    getX(
                      );
                dy =
                  next[1] -
                    currEndPoint.
                    getY(
                      );
                break;
            case org.apache.batik.ext.awt.geom.ExtendedPathIterator.
                   SEG_ARCTO:
                {
                    boolean large =
                      next[3] !=
                      0.0;
                    boolean goLeft =
                      next[4] !=
                      0.0;
                    java.awt.geom.Arc2D arc =
                      org.apache.batik.ext.awt.geom.ExtendedGeneralPath.
                      computeArc(
                        currEndPoint.
                          getX(
                            ),
                        currEndPoint.
                          getY(
                            ),
                        next[0],
                        next[1],
                        next[2],
                        large,
                        goLeft,
                        next[5],
                        next[6]);
                    double theta =
                      arc.
                      getAngleStart(
                        );
                    theta =
                      java.lang.Math.
                        toRadians(
                          theta);
                    dx =
                      -arc.
                        getWidth(
                          ) /
                        2.0 *
                        java.lang.Math.
                        sin(
                          theta);
                    dy =
                      arc.
                        getHeight(
                          ) /
                        2.0 *
                        java.lang.Math.
                        cos(
                          theta);
                    if (next[2] !=
                          0) {
                        double ang =
                          java.lang.Math.
                          toRadians(
                            -next[2]);
                        double sinA =
                          java.lang.Math.
                          sin(
                            ang);
                        double cosA =
                          java.lang.Math.
                          cos(
                            ang);
                        double tdx =
                          dx *
                          cosA -
                          dy *
                          sinA;
                        double tdy =
                          dx *
                          sinA +
                          dy *
                          cosA;
                        dx =
                          tdx;
                        dy =
                          tdy;
                    }
                    if (goLeft) {
                        dx =
                          -dx;
                    }
                    else {
                        dy =
                          -dy;
                    }
                }
                break;
            case java.awt.geom.PathIterator.
                   SEG_MOVETO:
            default:
                return null;
        }
        if (dx ==
              0 &&
              dy ==
              0) {
            return null;
        }
        return normalize(
                 new double[] { dx,
                 dy });
    }
    public double[] normalize(double[] v) {
        double n =
          java.lang.Math.
          sqrt(
            v[0] *
              v[0] +
              v[1] *
              v[1]);
        v[0] /=
          n;
        v[1] /=
          n;
        return v;
    }
    private java.awt.geom.AffineTransform computeMarkerTransform(org.apache.batik.gvt.Marker marker,
                                                                 java.awt.geom.Point2D markerPosition,
                                                                 double rotation) {
        java.awt.geom.Point2D ref =
          marker.
          getRef(
            );
        java.awt.geom.AffineTransform txf =
          new java.awt.geom.AffineTransform(
          );
        txf.
          translate(
            markerPosition.
              getX(
                ) -
              ref.
              getX(
                ),
            markerPosition.
              getY(
                ) -
              ref.
              getY(
                ));
        if (!java.lang.Double.
              isNaN(
                rotation)) {
            txf.
              rotate(
                java.lang.Math.
                  toRadians(
                    rotation),
                ref.
                  getX(
                    ),
                ref.
                  getY(
                    ));
        }
        return txf;
    }
    protected java.awt.geom.Point2D getSegmentTerminatingPoint(double[] coords,
                                                               int segType) {
        switch (segType) {
            case java.awt.geom.PathIterator.
                   SEG_CUBICTO:
                return new java.awt.geom.Point2D.Double(
                  coords[4],
                  coords[5]);
            case java.awt.geom.PathIterator.
                   SEG_LINETO:
                return new java.awt.geom.Point2D.Double(
                  coords[0],
                  coords[1]);
            case java.awt.geom.PathIterator.
                   SEG_MOVETO:
                return new java.awt.geom.Point2D.Double(
                  coords[0],
                  coords[1]);
            case java.awt.geom.PathIterator.
                   SEG_QUADTO:
                return new java.awt.geom.Point2D.Double(
                  coords[2],
                  coords[3]);
            case org.apache.batik.ext.awt.geom.ExtendedPathIterator.
                   SEG_ARCTO:
                return new java.awt.geom.Point2D.Double(
                  coords[5],
                  coords[6]);
            case java.awt.geom.PathIterator.
                   SEG_CLOSE:
            default:
                throw new java.lang.Error(
                  "invalid segmentType:" +
                  segType);
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "DJ6jR/gt3n3o/wDhwSxi/T8AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "rNR8PwJj5cIWMjnrIb3tACGqxkbervva");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "AL946xWWPieNyYNhVLoXKGw3PYE3PIFHXNTn5Bi/tIf3pVsPTzgn7d15MAWi" +
       "00+J7pSvmV0A28N55FPg+p09tt+59di0c9Lys10H4m60wJ3stc2zsicIpYta" +
       "Xw1cv79H+Pu33PrYAkpwDsx85+SBA2CG18A8ZYPuRQWZd4wv7WG+dOsF+V3n" +
       "pL03DzLgR4EgqbNbzU8gbi8qyXxL9Ff3EL/6dZLkD5yD8+/lwfcCnOG1OE+J" +
       "8vsuKsonAUW378ru/m+tKD9yTtpH8+CHo9J9uTu9am/+Cb4fuagcQfrB5T2+" +
       "y18nOf6jc0B+Ig8+BkCGZ0CeEuILFwB5dOTm4HV7kK+7WZDdlxXip89J+2we" +
       "/BQYqEqxae/hFbtaz2B82X2e52B8Ko9EALnv2mN8163H+K/OSfs3efA5MIcp" +
       "MHJnjmrkJawToJ+/KNA6oDndA01vPdBfPCftl/Pg56LSIwXQ7rXbp09g/vwF" +
       "YOZj8dLfART/+h7mr996mL95TtqX8uA/RKXHdjp77ZGVvFB8gvXXLoD1yTyy" +
       "UiodPrkru/u/GazGdbFeKjJcKp7D49ZywgqXoO9a2/1HpdUFT5ZLganoKsTN" +
       "+j0V99wk/2IDJUaBmebfuAC1tIsMRwfZ/zab2zH8zMuAS4oXHx0Kud4JnYMv" +
       "7/eKH/zB9Tm/O6GTB/s3oHnwnXlQDEBevPZwSv74fXnwgWtPmxQqsWu2KJ0/" +
       "/+A5Cvq/zkl7KQ/+JE95fkfJOXn/9+4wxnuPGz11V2T43XMK/588+K2o9LAM" +
       "pqmRenYQcsoX/PYtmJwf7n374U379nPt43rIz/Dgr2/Mg8OckIP/B0Zh+ccn" +
       "4khl9yd/8uj/ccKAr16AAa/OI98MgBt7Bhi3hgG3FxluvxHsw3vOgX1fHtwB" +
       "phF72EOXs71iPnjw4jHqw0sXRQ2m8oc/v0f98387qB89B/VjefDQibDHcXQ9" +
       "2A9fAPar8sgnSqXb7t2V3f3fDOyXfRX1YoHlTefgzKs8fCIq3e0Wn5Ewt2cR" +
       "PnkBhK/PI8E0+LZH9wgfvTWCve1kdSo/untwuTDBAs+Vc7DmB3IO3xaVHt3L" +
       "dOe/+EB0w/wjGkWZV0elJ65+O41pmumqV+cqOPPMBThTMAKMBG67sufMlZvl" +
       "zPVHPSf9z2lFf/s5THlnHqBR6fHixaued6i8GjimC3ybqxev5gsWn+Bu3gzu" +
       "FPQZ134VJv/ExWPXfG5q94kk+dMvPHDXa16Y/ufdMd6jzxjdTZbu0mLbPv3p" +
       "gVP3l/xA1cyCJ3cX4WW/gNeNSq+63gphVLoNhDm5h51dzgGYt5zNGZXuKP5P" +
       "5xtFpXtO8oHhxe7mdBYa1A6y5Lfj4xN9pw5R7b69kO7GAo+d1pBiBedlncpx" +
       "kdNfTMlPrhYf+jo6ZRrvPvX1nPyZFwj6O77S+IndF1tkW9xu81ruIkt37j4e" +
       "U1San1R94w1rO6rr0uBtX7v82bvfcrRUenlH8Im2nqLtDdf/PErX8aPigybb" +
       "f/Gaf/b2n3zhd4tTZP8fUr7oq4FNAAA=");
}
