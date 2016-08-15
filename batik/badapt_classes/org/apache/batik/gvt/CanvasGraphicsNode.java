package org.apache.batik.gvt;
public class CanvasGraphicsNode extends org.apache.batik.gvt.CompositeGraphicsNode {
    protected java.awt.geom.AffineTransform positionTransform;
    protected java.awt.geom.AffineTransform viewingTransform;
    protected java.awt.Paint backgroundPaint;
    public CanvasGraphicsNode() { super(); }
    public void setBackgroundPaint(java.awt.Paint newBackgroundPaint) { this.
                                                                          backgroundPaint =
                                                                          newBackgroundPaint;
    }
    public java.awt.Paint getBackgroundPaint() { return backgroundPaint;
    }
    public void setPositionTransform(java.awt.geom.AffineTransform at) {
        fireGraphicsNodeChangeStarted(
          );
        invalidateGeometryCache(
          );
        this.
          positionTransform =
          at;
        if (positionTransform !=
              null) {
            transform =
              new java.awt.geom.AffineTransform(
                positionTransform);
            if (viewingTransform !=
                  null)
                transform.
                  concatenate(
                    viewingTransform);
        }
        else
            if (viewingTransform !=
                  null)
                transform =
                  new java.awt.geom.AffineTransform(
                    viewingTransform);
            else
                transform =
                  new java.awt.geom.AffineTransform(
                    );
        if (transform.
              getDeterminant(
                ) !=
              0) {
            try {
                inverseTransform =
                  transform.
                    createInverse(
                      );
            }
            catch (java.awt.geom.NoninvertibleTransformException e) {
                throw new java.lang.Error(
                  e.
                    getMessage(
                      ));
            }
        }
        else {
            inverseTransform =
              transform;
        }
        fireGraphicsNodeChangeCompleted(
          );
    }
    public java.awt.geom.AffineTransform getPositionTransform() {
        return positionTransform;
    }
    public void setViewingTransform(java.awt.geom.AffineTransform at) {
        fireGraphicsNodeChangeStarted(
          );
        invalidateGeometryCache(
          );
        this.
          viewingTransform =
          at;
        if (positionTransform !=
              null) {
            transform =
              new java.awt.geom.AffineTransform(
                positionTransform);
            if (viewingTransform !=
                  null)
                transform.
                  concatenate(
                    viewingTransform);
        }
        else
            if (viewingTransform !=
                  null)
                transform =
                  new java.awt.geom.AffineTransform(
                    viewingTransform);
            else
                transform =
                  new java.awt.geom.AffineTransform(
                    );
        if (transform.
              getDeterminant(
                ) !=
              0) {
            try {
                inverseTransform =
                  transform.
                    createInverse(
                      );
            }
            catch (java.awt.geom.NoninvertibleTransformException e) {
                throw new java.lang.Error(
                  e.
                    getMessage(
                      ));
            }
        }
        else {
            inverseTransform =
              transform;
        }
        fireGraphicsNodeChangeCompleted(
          );
    }
    public java.awt.geom.AffineTransform getViewingTransform() {
        return viewingTransform;
    }
    public void primitivePaint(java.awt.Graphics2D g2d) {
        if (backgroundPaint !=
              null) {
            g2d.
              setPaint(
                backgroundPaint);
            g2d.
              fill(
                g2d.
                  getClip(
                    ));
        }
        super.
          primitivePaint(
            g2d);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
