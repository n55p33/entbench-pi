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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "K7g/EK/YfPhvFDLP7fUcAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "b8vTL9z5+2/5nae/lZ+H/x9vToem9icAAA==");
}
