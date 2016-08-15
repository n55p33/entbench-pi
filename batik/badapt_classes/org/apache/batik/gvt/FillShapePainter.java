package org.apache.batik.gvt;
public class FillShapePainter implements org.apache.batik.gvt.ShapePainter {
    protected java.awt.Shape shape;
    protected java.awt.Paint paint;
    public FillShapePainter(java.awt.Shape shape) { super();
                                                    if (shape == null) throw new java.lang.IllegalArgumentException(
                                                                         "Shape can not be null!");
                                                    this.shape = shape;
    }
    public void setPaint(java.awt.Paint newPaint) { this.paint = newPaint;
    }
    public java.awt.Paint getPaint() { return paint; }
    public void paint(java.awt.Graphics2D g2d) { if (paint != null) {
                                                     g2d.
                                                       setPaint(
                                                         paint);
                                                     g2d.
                                                       fill(
                                                         shape);
                                                 } }
    public java.awt.Shape getPaintedArea() { if (paint == null) return null;
                                             return shape; }
    public java.awt.geom.Rectangle2D getPaintedBounds2D() { if (paint ==
                                                                  null ||
                                                                  shape ==
                                                                  null)
                                                                return null;
                                                            return shape.
                                                              getBounds2D(
                                                                );
    }
    public boolean inPaintedArea(java.awt.geom.Point2D pt) { if (paint ==
                                                                   null ||
                                                                   shape ==
                                                                   null)
                                                                 return false;
                                                             return shape.
                                                               contains(
                                                                 pt);
    }
    public java.awt.Shape getSensitiveArea() { return shape; }
    public java.awt.geom.Rectangle2D getSensitiveBounds2D() { if (shape ==
                                                                    null)
                                                                  return null;
                                                              return shape.
                                                                getBounds2D(
                                                                  );
    }
    public boolean inSensitiveArea(java.awt.geom.Point2D pt) { if (shape ==
                                                                     null)
                                                                   return false;
                                                               return shape.
                                                                 contains(
                                                                   pt);
    }
    public void setShape(java.awt.Shape shape) { if (shape == null) {
                                                     throw new java.lang.IllegalArgumentException(
                                                       );
                                                 }
                                                 this.shape =
                                                   shape;
    }
    public java.awt.Shape getShape() { return shape; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "OE3QuCIAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
