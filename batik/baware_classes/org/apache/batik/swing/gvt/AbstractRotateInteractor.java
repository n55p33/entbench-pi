package org.apache.batik.swing.gvt;
public class AbstractRotateInteractor extends org.apache.batik.swing.gvt.InteractorAdapter {
    protected boolean finished;
    protected double initialRotation;
    public boolean endInteraction() { return finished; }
    public void mousePressed(java.awt.event.MouseEvent e) { finished = false;
                                                            org.apache.batik.swing.gvt.JGVTComponent c =
                                                              (org.apache.batik.swing.gvt.JGVTComponent)
                                                                e.
                                                                getSource(
                                                                  );
                                                            java.awt.Dimension d =
                                                              c.
                                                              getSize(
                                                                );
                                                            double dx =
                                                              e.
                                                              getX(
                                                                ) -
                                                              d.
                                                                width /
                                                              2;
                                                            double dy =
                                                              e.
                                                              getY(
                                                                ) -
                                                              d.
                                                                height /
                                                              2;
                                                            double cos =
                                                              -dy /
                                                              java.lang.Math.
                                                              sqrt(
                                                                dx *
                                                                  dx +
                                                                  dy *
                                                                  dy);
                                                            initialRotation =
                                                              dx >
                                                                0
                                                                ? java.lang.Math.
                                                                acos(
                                                                  cos)
                                                                : -java.lang.Math.
                                                                acos(
                                                                  cos);
    }
    public void mouseReleased(java.awt.event.MouseEvent e) {
        finished =
          true;
        org.apache.batik.swing.gvt.JGVTComponent c =
          (org.apache.batik.swing.gvt.JGVTComponent)
            e.
            getSource(
              );
        java.awt.geom.AffineTransform at =
          rotateTransform(
            c.
              getSize(
                ),
            e.
              getX(
                ),
            e.
              getY(
                ));
        at.
          concatenate(
            c.
              getRenderingTransform(
                ));
        c.
          setRenderingTransform(
            at);
    }
    public void mouseExited(java.awt.event.MouseEvent e) {
        finished =
          true;
        org.apache.batik.swing.gvt.JGVTComponent c =
          (org.apache.batik.swing.gvt.JGVTComponent)
            e.
            getSource(
              );
        c.
          setPaintingTransform(
            null);
    }
    public void mouseDragged(java.awt.event.MouseEvent e) {
        org.apache.batik.swing.gvt.JGVTComponent c =
          (org.apache.batik.swing.gvt.JGVTComponent)
            e.
            getSource(
              );
        c.
          setPaintingTransform(
            rotateTransform(
              c.
                getSize(
                  ),
              e.
                getX(
                  ),
              e.
                getY(
                  )));
    }
    protected java.awt.geom.AffineTransform rotateTransform(java.awt.Dimension d,
                                                            int x,
                                                            int y) {
        double dx =
          x -
          d.
            width /
          2;
        double dy =
          y -
          d.
            height /
          2;
        double cos =
          -dy /
          java.lang.Math.
          sqrt(
            dx *
              dx +
              dy *
              dy);
        double angle =
          dx >
          0
          ? java.lang.Math.
          acos(
            cos)
          : -java.lang.Math.
          acos(
            cos);
        angle -=
          initialRotation;
        return java.awt.geom.AffineTransform.
          getRotateInstance(
            angle,
            d.
              width /
              2,
            d.
              height /
              2);
    }
    public AbstractRotateInteractor() { super(
                                          );
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
