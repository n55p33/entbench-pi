package org.apache.batik.gvt;
public class Marker {
    protected double orient;
    protected org.apache.batik.gvt.GraphicsNode markerNode;
    protected java.awt.geom.Point2D ref;
    public Marker(org.apache.batik.gvt.GraphicsNode markerNode, java.awt.geom.Point2D ref,
                  double orient) { super();
                                   if (markerNode == null) { throw new java.lang.IllegalArgumentException(
                                                               );
                                   }
                                   if (ref == null) { throw new java.lang.IllegalArgumentException(
                                                        );
                                   }
                                   this.markerNode =
                                     markerNode;
                                   this.ref = ref;
                                   this.orient = orient;
    }
    public java.awt.geom.Point2D getRef() { return (java.awt.geom.Point2D)
                                                     ref.
                                                     clone(
                                                       );
    }
    public double getOrient() { return orient; }
    public org.apache.batik.gvt.GraphicsNode getMarkerNode() {
        return markerNode;
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
      ("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");
}
