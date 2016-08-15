package org.apache.batik.gvt.filter;
public class GraphicsNodeRed8Bit extends org.apache.batik.ext.awt.image.rendered.AbstractRed {
    private org.apache.batik.gvt.GraphicsNode node;
    private java.awt.geom.AffineTransform node2dev;
    private java.awt.RenderingHints hints;
    private boolean usePrimitivePaint;
    public GraphicsNodeRed8Bit(org.apache.batik.gvt.GraphicsNode node, java.awt.geom.AffineTransform node2dev,
                               boolean usePrimitivePaint,
                               java.awt.RenderingHints hints) { super(
                                                                  );
                                                                this.
                                                                  node =
                                                                  node;
                                                                this.
                                                                  node2dev =
                                                                  node2dev;
                                                                this.
                                                                  hints =
                                                                  hints;
                                                                this.
                                                                  usePrimitivePaint =
                                                                  usePrimitivePaint;
                                                                java.awt.geom.AffineTransform at =
                                                                  node2dev;
                                                                java.awt.geom.Rectangle2D bounds2D =
                                                                  node.
                                                                  getPrimitiveBounds(
                                                                    );
                                                                if (bounds2D ==
                                                                      null)
                                                                    bounds2D =
                                                                      new java.awt.geom.Rectangle2D.Float(
                                                                        0,
                                                                        0,
                                                                        1,
                                                                        1);
                                                                if (!usePrimitivePaint) {
                                                                    java.awt.geom.AffineTransform nodeAt =
                                                                      node.
                                                                      getTransform(
                                                                        );
                                                                    if (nodeAt !=
                                                                          null) {
                                                                        at =
                                                                          (java.awt.geom.AffineTransform)
                                                                            at.
                                                                            clone(
                                                                              );
                                                                        at.
                                                                          concatenate(
                                                                            nodeAt);
                                                                    }
                                                                }
                                                                java.awt.Rectangle bounds =
                                                                  at.
                                                                  createTransformedShape(
                                                                    bounds2D).
                                                                  getBounds(
                                                                    );
                                                                java.awt.image.ColorModel cm =
                                                                  createColorModel(
                                                                    );
                                                                int defSz =
                                                                  org.apache.batik.ext.awt.image.rendered.AbstractTiledRed.
                                                                  getDefaultTileSize(
                                                                    );
                                                                int tgX =
                                                                  defSz *
                                                                  (int)
                                                                    java.lang.Math.
                                                                    floor(
                                                                      bounds.
                                                                        x /
                                                                        defSz);
                                                                int tgY =
                                                                  defSz *
                                                                  (int)
                                                                    java.lang.Math.
                                                                    floor(
                                                                      bounds.
                                                                        y /
                                                                        defSz);
                                                                int tw =
                                                                  bounds.
                                                                    x +
                                                                  bounds.
                                                                    width -
                                                                  tgX;
                                                                if (tw >
                                                                      defSz)
                                                                    tw =
                                                                      defSz;
                                                                int th =
                                                                  bounds.
                                                                    y +
                                                                  bounds.
                                                                    height -
                                                                  tgY;
                                                                if (th >
                                                                      defSz)
                                                                    th =
                                                                      defSz;
                                                                if (tw <=
                                                                      0 ||
                                                                      th <=
                                                                      0) {
                                                                    tw =
                                                                      1;
                                                                    th =
                                                                      1;
                                                                }
                                                                java.awt.image.SampleModel sm =
                                                                  cm.
                                                                  createCompatibleSampleModel(
                                                                    tw,
                                                                    th);
                                                                init(
                                                                  (org.apache.batik.ext.awt.image.rendered.CachableRed)
                                                                    null,
                                                                  bounds,
                                                                  cm,
                                                                  sm,
                                                                  tgX,
                                                                  tgY,
                                                                  null);
    }
    public java.awt.image.WritableRaster copyData(java.awt.image.WritableRaster wr) {
        genRect(
          wr);
        return wr;
    }
    public void genRect(java.awt.image.WritableRaster wr) {
        java.awt.image.BufferedImage offScreen =
          new java.awt.image.BufferedImage(
          cm,
          wr.
            createWritableTranslatedChild(
              0,
              0),
          cm.
            isAlphaPremultiplied(
              ),
          null);
        java.awt.Graphics2D g =
          org.apache.batik.ext.awt.image.GraphicsUtil.
          createGraphics(
            offScreen,
            hints);
        g.
          setComposite(
            java.awt.AlphaComposite.
              Clear);
        g.
          fillRect(
            0,
            0,
            wr.
              getWidth(
                ),
            wr.
              getHeight(
                ));
        g.
          setComposite(
            java.awt.AlphaComposite.
              SrcOver);
        g.
          translate(
            -wr.
              getMinX(
                ),
            -wr.
              getMinY(
                ));
        g.
          transform(
            node2dev);
        if (usePrimitivePaint) {
            node.
              primitivePaint(
                g);
        }
        else {
            node.
              paint(
                g);
        }
        g.
          dispose(
            );
    }
    static final boolean onMacOSX;
    static { onMacOSX = "Mac OS X".equals(
                                     java.lang.System.
                                       getProperty(
                                         "os.name"));
    }
    public java.awt.image.ColorModel createColorModel() {
        if (onMacOSX)
            return org.apache.batik.ext.awt.image.GraphicsUtil.
                     sRGB_Pre;
        return org.apache.batik.ext.awt.image.GraphicsUtil.
                 sRGB_Unpre;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "r+B+R7xi8+6/AbD5ZHn1HAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
