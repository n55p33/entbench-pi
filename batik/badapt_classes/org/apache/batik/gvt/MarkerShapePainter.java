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
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Fxg8R4/yW7z72P8BQNy8gP0/AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "JIB5k303aLKIgMYzyuEqTHvch1i6ZnUqmj6h9UUwcvs93nNX4YyhjObCXzAr" +
       "hkYIFmtV8JHrk+a8owv+IKQrEdG3kaBj6zg9o2ZqH2dmUtdxJqKBek17tlyo" +
       "+jp1kzbvhKv6dj6GGlu4XhOpRkwgotPlmgIynRMCC1X9SX09YTrKkBEdetmq" +
       "9DbLRdWcLTx2iOJEe0m121VAguCuIY2EOzCkqSrR8O20YU97DWZTm7jLaj/Y" +
       "qiLvZIsYEbKWGLBi2VzoAaIZte04MruNIFNCnVYEpxexA2Q4qvm8YVbxShUe" +
       "VyzODMhtByxEa27FbVEYMsMlTl8NeWViCT7nY3Zr4OOr7bSujiutFdqpGyIx" +
       "warTSk2cd5FJO5hDK0OsNcot33b9pumu9GpMuDinqJWh2ePr2nCiG0O+zXaw" +
       "Huz4OgQFZTbijd4UH6FMNxHBZJHS8yEFEUt5PEC7MpP0pmhnTqGppEbLbhfN" +
       "wprDyk0LCHYaW2IQEq0tn9GgyszooyztSeImjbO2ETbmXhe2llNz0om30LbD" +
       "+3waOUPexieyg+JevJ5rajXEbKvpU80J0kO3WCddDcyJYK0H3eWwpYcS0+rS" +
       "4VZpKeamToS+Sw826YCihquNkGhjBJLVOnBjrsU4vWVr0VcSbTjkkYSqtmW8" +
       "YWDrkE8rdMBL6xRxiInL9SI7Qrc2GnMpLGzawXaixQMl3mymg0lSsyujhdCh" +
       "motBdSEwUZdvzSo9xUTgsjWBsalttbMNPCIG804UoFiXZecUvkU1UqDr42rV" +
       "aDoVPoOsCrzQ1biNcVQFsbx1dTTQcIxfAecH4ZI2HleDpZLBzao/NTN6QNi+" +
       "aSAIxmheSNakuVJxNHJddVEDH5Q72aaiV2pkDdcCaTseb7RJPTNWKdzs65wC" +
       "D7ht4I7YjI8ELsgaxjihvVENkvubdraSZRbedPmYli1oWUbNJj4mNqspm3kb" +
       "v0xONz5LWbUuDmEkpqHUpIFVxEzAaM0XMx6tJ5vIkRJHFRtCuKaC1rQHaf3U" +
       "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" +
       "jZ9gi82ynlitdRdp14D2VMSyU8l1bUKh");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "0t1e8RkJMzuL8MkLIHxjngmWwbc9ukf46K0R7G0nu1P5q7sHlwsTLPBcOQdr" +
       "/kLO4Tvi0qN7me781zQUvSj/iEbR5rVx6Ymrn043Nc301KtrFZx59gKcKRgB" +
       "IoHbruw5c+VmOXP9qOdk/jmt6O88hynvypNGXHq8ePCq5xPqVA1d0wO+zdOL" +
       "R/MFi09wYzeDOwVzxrVfhck/cfHYNZ+b2n0iSf7Miw/c9boXZ/959xrv0WeM" +
       "7u6X7tISxzn96YFT95eCUNXMgid3F+nloIDXjUuvud4OYVy6DaQ5uYedXU0K" +
       "rFvO1oxLdxT/T9frxaV7TuqB8GJ3c7rKEPQOquS3o+M3+k69RLX79kK6iwUe" +
       "O60hxQ7OKzqV4yanv5iSv7lafOjr6C3TZPepr+flz77IDL/jq/Wf2H2xRXbE" +
       "LMt7uatfunP38Zii0/xN1TffsLejvi5R7/iLy5+7+5mjrdLLO4JPtPUUbW+6" +
       "/udRum4QFx80yf7F6/7ZOz/54u8Wb5H9f+NFQ1aBTQAA");
}
