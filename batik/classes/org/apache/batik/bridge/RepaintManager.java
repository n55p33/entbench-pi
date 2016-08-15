package org.apache.batik.bridge;
public class RepaintManager {
    static final int COPY_OVERHEAD = 10000;
    static final int COPY_LINE_OVERHEAD = 10;
    protected org.apache.batik.gvt.renderer.ImageRenderer renderer;
    public RepaintManager(org.apache.batik.gvt.renderer.ImageRenderer r) {
        super(
          );
        renderer =
          r;
    }
    public java.util.Collection updateRendering(java.util.Collection areas)
          throws java.lang.InterruptedException { renderer.flush(areas);
                                                  java.util.List rects = new java.util.ArrayList(
                                                    areas.
                                                      size(
                                                        ));
                                                  java.awt.geom.AffineTransform at =
                                                    renderer.
                                                    getTransform(
                                                      );
                                                  java.util.Iterator i =
                                                    areas.
                                                    iterator(
                                                      );
                                                  while (i.
                                                           hasNext(
                                                             )) {
                                                      java.awt.Shape s =
                                                        (java.awt.Shape)
                                                          i.
                                                          next(
                                                            );
                                                      s =
                                                        at.
                                                          createTransformedShape(
                                                            s);
                                                      java.awt.geom.Rectangle2D r2d =
                                                        s.
                                                        getBounds2D(
                                                          );
                                                      int x0 =
                                                        (int)
                                                          java.lang.Math.
                                                          floor(
                                                            r2d.
                                                              getX(
                                                                ));
                                                      int y0 =
                                                        (int)
                                                          java.lang.Math.
                                                          floor(
                                                            r2d.
                                                              getY(
                                                                ));
                                                      int x1 =
                                                        (int)
                                                          java.lang.Math.
                                                          ceil(
                                                            r2d.
                                                              getX(
                                                                ) +
                                                              r2d.
                                                              getWidth(
                                                                ));
                                                      int y1 =
                                                        (int)
                                                          java.lang.Math.
                                                          ceil(
                                                            r2d.
                                                              getY(
                                                                ) +
                                                              r2d.
                                                              getHeight(
                                                                ));
                                                      java.awt.Rectangle r =
                                                        new java.awt.Rectangle(
                                                        x0 -
                                                          1,
                                                        y0 -
                                                          1,
                                                        x1 -
                                                          x0 +
                                                          3,
                                                        y1 -
                                                          y0 +
                                                          3);
                                                      rects.
                                                        add(
                                                          r);
                                                  }
                                                  org.apache.batik.ext.awt.geom.RectListManager devRLM =
                                                    null;
                                                  try {
                                                      devRLM =
                                                        new org.apache.batik.ext.awt.geom.RectListManager(
                                                          rects);
                                                      devRLM.
                                                        mergeRects(
                                                          COPY_OVERHEAD,
                                                          COPY_LINE_OVERHEAD);
                                                  }
                                                  catch (java.lang.Exception e) {
                                                      e.
                                                        printStackTrace(
                                                          );
                                                  }
                                                  renderer.
                                                    repaint(
                                                      devRLM);
                                                  return devRLM;
    }
    public void setupRenderer(java.awt.geom.AffineTransform u2d,
                              boolean dbr,
                              java.awt.Shape aoi,
                              int width,
                              int height) {
        renderer.
          setTransform(
            u2d);
        renderer.
          setDoubleBuffered(
            dbr);
        renderer.
          updateOffScreen(
            width,
            height);
        renderer.
          clearOffScreen(
            );
    }
    public java.awt.image.BufferedImage getOffScreen() {
        return renderer.
          getOffScreen(
            );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "MJxSOnSLwT2UFkZobD/gXWw+/A9uuKYIaR4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "v15lRf8feCRNOO8oAAA=");
}
