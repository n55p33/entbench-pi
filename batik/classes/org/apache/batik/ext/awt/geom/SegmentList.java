package org.apache.batik.ext.awt.geom;
public class SegmentList {
    java.util.List segments = new java.util.LinkedList();
    public SegmentList() { super(); }
    public SegmentList(java.awt.Shape s) { super();
                                           java.awt.geom.PathIterator pi =
                                             s.
                                             getPathIterator(
                                               null);
                                           float[] pts = new float[6];
                                           int type;
                                           java.awt.geom.Point2D.Double loc =
                                             null;
                                           java.awt.geom.Point2D.Double openLoc =
                                             null;
                                           while (!pi.isDone()) {
                                               type =
                                                 pi.
                                                   currentSegment(
                                                     pts);
                                               switch (type) {
                                                   case java.awt.geom.PathIterator.
                                                          SEG_MOVETO:
                                                       openLoc =
                                                         (loc =
                                                            new java.awt.geom.Point2D.Double(
                                                              pts[0],
                                                              pts[1]));
                                                       break;
                                                   case java.awt.geom.PathIterator.
                                                          SEG_LINETO:
                                                       {
                                                           java.awt.geom.Point2D.Double p0 =
                                                             new java.awt.geom.Point2D.Double(
                                                             pts[0],
                                                             pts[1]);
                                                           segments.
                                                             add(
                                                               new org.apache.batik.ext.awt.geom.Linear(
                                                                 loc,
                                                                 p0));
                                                           loc =
                                                             p0;
                                                       }
                                                       break;
                                                   case java.awt.geom.PathIterator.
                                                          SEG_QUADTO:
                                                       {
                                                           java.awt.geom.Point2D.Double p0 =
                                                             new java.awt.geom.Point2D.Double(
                                                             pts[0],
                                                             pts[1]);
                                                           java.awt.geom.Point2D.Double p1 =
                                                             new java.awt.geom.Point2D.Double(
                                                             pts[2],
                                                             pts[3]);
                                                           segments.
                                                             add(
                                                               new org.apache.batik.ext.awt.geom.Quadradic(
                                                                 loc,
                                                                 p0,
                                                                 p1));
                                                           loc =
                                                             p1;
                                                       }
                                                       break;
                                                   case java.awt.geom.PathIterator.
                                                          SEG_CUBICTO:
                                                       {
                                                           java.awt.geom.Point2D.Double p0 =
                                                             new java.awt.geom.Point2D.Double(
                                                             pts[0],
                                                             pts[1]);
                                                           java.awt.geom.Point2D.Double p1 =
                                                             new java.awt.geom.Point2D.Double(
                                                             pts[2],
                                                             pts[3]);
                                                           java.awt.geom.Point2D.Double p2 =
                                                             new java.awt.geom.Point2D.Double(
                                                             pts[4],
                                                             pts[5]);
                                                           segments.
                                                             add(
                                                               new org.apache.batik.ext.awt.geom.Cubic(
                                                                 loc,
                                                                 p0,
                                                                 p1,
                                                                 p2));
                                                           loc =
                                                             p2;
                                                       }
                                                       break;
                                                   case java.awt.geom.PathIterator.
                                                          SEG_CLOSE:
                                                       segments.
                                                         add(
                                                           new org.apache.batik.ext.awt.geom.Linear(
                                                             loc,
                                                             openLoc));
                                                       loc =
                                                         openLoc;
                                                       break;
                                               }
                                               pi.
                                                 next(
                                                   );
                                           }
    }
    public java.awt.geom.Rectangle2D getBounds2D() {
        java.util.Iterator iter =
          iterator(
            );
        if (!iter.
              hasNext(
                ))
            return null;
        java.awt.geom.Rectangle2D ret;
        ret =
          (java.awt.geom.Rectangle2D)
            ((org.apache.batik.ext.awt.geom.Segment)
               iter.
               next(
                 )).
            getBounds2D(
              ).
            clone(
              );
        while (iter.
                 hasNext(
                   )) {
            org.apache.batik.ext.awt.geom.Segment seg =
              (org.apache.batik.ext.awt.geom.Segment)
                iter.
                next(
                  );
            java.awt.geom.Rectangle2D segB =
              seg.
              getBounds2D(
                );
            java.awt.geom.Rectangle2D.
              union(
                segB,
                ret,
                ret);
        }
        return ret;
    }
    public void add(org.apache.batik.ext.awt.geom.Segment s) {
        segments.
          add(
            s);
    }
    public java.util.Iterator iterator() {
        return segments.
          iterator(
            );
    }
    public int size() { return segments.size(
                                          );
    }
    public org.apache.batik.ext.awt.geom.SegmentList.SplitResults split(double y) {
        java.util.Iterator iter =
          segments.
          iterator(
            );
        org.apache.batik.ext.awt.geom.SegmentList above =
          new org.apache.batik.ext.awt.geom.SegmentList(
          );
        org.apache.batik.ext.awt.geom.SegmentList below =
          new org.apache.batik.ext.awt.geom.SegmentList(
          );
        while (iter.
                 hasNext(
                   )) {
            org.apache.batik.ext.awt.geom.Segment seg =
              (org.apache.batik.ext.awt.geom.Segment)
                iter.
                next(
                  );
            org.apache.batik.ext.awt.geom.Segment.SplitResults results =
              seg.
              split(
                y);
            if (results ==
                  null) {
                java.awt.geom.Rectangle2D bounds =
                  seg.
                  getBounds2D(
                    );
                if (bounds.
                      getY(
                        ) >
                      y) {
                    below.
                      add(
                        seg);
                }
                else
                    if (bounds.
                          getY(
                            ) ==
                          y) {
                        if (bounds.
                              getHeight(
                                ) !=
                              0) {
                            below.
                              add(
                                seg);
                        }
                    }
                    else {
                        above.
                          add(
                            seg);
                    }
                continue;
            }
            org.apache.batik.ext.awt.geom.Segment[] resAbove =
              results.
              getAbove(
                );
            for (int i =
                   0;
                 i <
                   resAbove.
                     length;
                 i++) {
                above.
                  add(
                    resAbove[i]);
            }
            org.apache.batik.ext.awt.geom.Segment[] resBelow =
              results.
              getBelow(
                );
            for (int i =
                   0;
                 i <
                   resBelow.
                     length;
                 i++) {
                below.
                  add(
                    resBelow[i]);
            }
        }
        return new org.apache.batik.ext.awt.geom.SegmentList.SplitResults(
          above,
          below);
    }
    public static class SplitResults {
        final org.apache.batik.ext.awt.geom.SegmentList
          above;
        final org.apache.batik.ext.awt.geom.SegmentList
          below;
        public SplitResults(org.apache.batik.ext.awt.geom.SegmentList above,
                            org.apache.batik.ext.awt.geom.SegmentList below) {
            super(
              );
            if (above !=
                  null &&
                  above.
                  size(
                    ) >
                  0) {
                this.
                  above =
                  above;
            }
            else {
                this.
                  above =
                  null;
            }
            if (below !=
                  null &&
                  below.
                  size(
                    ) >
                  0) {
                this.
                  below =
                  below;
            }
            else {
                this.
                  below =
                  null;
            }
        }
        public org.apache.batik.ext.awt.geom.SegmentList getAbove() {
            return above;
        }
        public org.apache.batik.ext.awt.geom.SegmentList getBelow() {
            return below;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "iG8huyvEfy+L/V8Qrzhc/Q/MPws0+hcAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "8xed9A/u/r23/M4z383rmP8D2bp7NZUiAAA=");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Gv4HFKl0b6YgAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "qDoI+3/k+kx01CkAAA==");
}
