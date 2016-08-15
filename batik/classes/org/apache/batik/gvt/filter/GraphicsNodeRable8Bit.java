package org.apache.batik.gvt.filter;
public class GraphicsNodeRable8Bit extends org.apache.batik.ext.awt.image.renderable.AbstractRable implements org.apache.batik.gvt.filter.GraphicsNodeRable, org.apache.batik.ext.awt.image.renderable.PaintRable {
    private java.awt.geom.AffineTransform cachedGn2dev = null;
    private java.awt.geom.AffineTransform cachedUsr2dev = null;
    private org.apache.batik.ext.awt.image.rendered.CachableRed cachedRed =
      null;
    private java.awt.geom.Rectangle2D cachedBounds = null;
    private boolean usePrimitivePaint = true;
    public boolean getUsePrimitivePaint() { return usePrimitivePaint; }
    public void setUsePrimitivePaint(boolean usePrimitivePaint) { this.usePrimitivePaint =
                                                                    usePrimitivePaint;
    }
    private org.apache.batik.gvt.GraphicsNode node;
    public org.apache.batik.gvt.GraphicsNode getGraphicsNode() {
        return node;
    }
    public void setGraphicsNode(org.apache.batik.gvt.GraphicsNode node) {
        if (node ==
              null) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        this.
          node =
          node;
    }
    public void clearCache() { cachedRed = null;
                               cachedUsr2dev = null;
                               cachedGn2dev = null;
                               cachedBounds = null; }
    public GraphicsNodeRable8Bit(org.apache.batik.gvt.GraphicsNode node) {
        super(
          );
        if (node ==
              null)
            throw new java.lang.IllegalArgumentException(
              );
        this.
          node =
          node;
        this.
          usePrimitivePaint =
          true;
    }
    public GraphicsNodeRable8Bit(org.apache.batik.gvt.GraphicsNode node,
                                 java.util.Map props) { super(
                                                          (org.apache.batik.ext.awt.image.renderable.Filter)
                                                            null,
                                                          props);
                                                        if (node ==
                                                              null)
                                                            throw new java.lang.IllegalArgumentException(
                                                              );
                                                        this.
                                                          node =
                                                          node;
                                                        this.
                                                          usePrimitivePaint =
                                                          true;
    }
    public GraphicsNodeRable8Bit(org.apache.batik.gvt.GraphicsNode node,
                                 boolean usePrimitivePaint) {
        super(
          );
        if (node ==
              null)
            throw new java.lang.IllegalArgumentException(
              );
        this.
          node =
          node;
        this.
          usePrimitivePaint =
          usePrimitivePaint;
    }
    public java.awt.geom.Rectangle2D getBounds2D() {
        if (usePrimitivePaint) {
            java.awt.geom.Rectangle2D primitiveBounds =
              node.
              getPrimitiveBounds(
                );
            if (primitiveBounds ==
                  null)
                return new java.awt.geom.Rectangle2D.Double(
                  0,
                  0,
                  0,
                  0);
            return (java.awt.geom.Rectangle2D)
                     primitiveBounds.
                     clone(
                       );
        }
        java.awt.geom.Rectangle2D bounds =
          node.
          getBounds(
            );
        if (bounds ==
              null) {
            return new java.awt.geom.Rectangle2D.Double(
              0,
              0,
              0,
              0);
        }
        java.awt.geom.AffineTransform at =
          node.
          getTransform(
            );
        if (at !=
              null) {
            bounds =
              at.
                createTransformedShape(
                  bounds).
                getBounds2D(
                  );
        }
        return bounds;
    }
    public boolean isDynamic() { return false;
    }
    public boolean paintRable(java.awt.Graphics2D g2d) {
        java.awt.Composite c =
          g2d.
          getComposite(
            );
        if (!org.apache.batik.ext.awt.image.SVGComposite.
               OVER.
              equals(
                c))
            return false;
        java.awt.color.ColorSpace g2dCS =
          org.apache.batik.ext.awt.image.GraphicsUtil.
          getDestinationColorSpace(
            g2d);
        if (g2dCS ==
              null ||
              g2dCS !=
              java.awt.color.ColorSpace.
              getInstance(
                java.awt.color.ColorSpace.
                  CS_sRGB)) {
            return false;
        }
        org.apache.batik.gvt.GraphicsNode gn =
          getGraphicsNode(
            );
        if (getUsePrimitivePaint(
              )) {
            gn.
              primitivePaint(
                g2d);
        }
        else {
            gn.
              paint(
                g2d);
        }
        return true;
    }
    public java.awt.image.RenderedImage createRendering(java.awt.image.renderable.RenderContext renderContext) {
        java.awt.geom.AffineTransform usr2dev =
          renderContext.
          getTransform(
            );
        java.awt.geom.AffineTransform gn2dev;
        if (usr2dev ==
              null) {
            usr2dev =
              new java.awt.geom.AffineTransform(
                );
            gn2dev =
              usr2dev;
        }
        else {
            gn2dev =
              (java.awt.geom.AffineTransform)
                usr2dev.
                clone(
                  );
        }
        java.awt.geom.AffineTransform gn2usr =
          node.
          getTransform(
            );
        if (gn2usr !=
              null) {
            gn2dev.
              concatenate(
                gn2usr);
        }
        java.awt.geom.Rectangle2D bounds2D =
          getBounds2D(
            );
        if (cachedBounds !=
              null &&
              cachedGn2dev !=
              null &&
              cachedBounds.
              equals(
                bounds2D) &&
              gn2dev.
              getScaleX(
                ) ==
              cachedGn2dev.
              getScaleX(
                ) &&
              gn2dev.
              getScaleY(
                ) ==
              cachedGn2dev.
              getScaleY(
                ) &&
              gn2dev.
              getShearX(
                ) ==
              cachedGn2dev.
              getShearX(
                ) &&
              gn2dev.
              getShearY(
                ) ==
              cachedGn2dev.
              getShearY(
                )) {
            double deltaX =
              usr2dev.
              getTranslateX(
                ) -
              cachedUsr2dev.
              getTranslateX(
                );
            double deltaY =
              usr2dev.
              getTranslateY(
                ) -
              cachedUsr2dev.
              getTranslateY(
                );
            if (deltaX ==
                  0 &&
                  deltaY ==
                  0)
                return cachedRed;
            if (deltaX ==
                  (int)
                    deltaX &&
                  deltaY ==
                  (int)
                    deltaY) {
                return new org.apache.batik.ext.awt.image.rendered.TranslateRed(
                  cachedRed,
                  (int)
                    java.lang.Math.
                    round(
                      cachedRed.
                        getMinX(
                          ) +
                        deltaX),
                  (int)
                    java.lang.Math.
                    round(
                      cachedRed.
                        getMinY(
                          ) +
                        deltaY));
            }
        }
        if (false) {
            java.lang.System.
              out.
              println(
                "Not using Cached Red: " +
                usr2dev);
            java.lang.System.
              out.
              println(
                "Old:                  " +
                cachedUsr2dev);
        }
        if (bounds2D.
              getWidth(
                ) >
              0 &&
              bounds2D.
              getHeight(
                ) >
              0) {
            cachedUsr2dev =
              (java.awt.geom.AffineTransform)
                usr2dev.
                clone(
                  );
            cachedGn2dev =
              gn2dev;
            cachedBounds =
              bounds2D;
            cachedRed =
              new org.apache.batik.gvt.filter.GraphicsNodeRed8Bit(
                node,
                usr2dev,
                usePrimitivePaint,
                renderContext.
                  getRenderingHints(
                    ));
            return cachedRed;
        }
        cachedUsr2dev =
          null;
        cachedGn2dev =
          null;
        cachedBounds =
          null;
        cachedRed =
          null;
        return null;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "K5TiZzXu/d35isduDnU+dzfe0f8CLVXqYigpAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "4yR0havOfp48FubDhezeDRJ+KEz87Mvn");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("E3W5/pvn9+zV7SaHf//mJnVfK7LfjCtv09V4dt0X6yea+lu3fKD8G1cfKH8I" +
       "JOoQJ/XW4Dx30mBeNviDm4D9wyL7OgAbXQfsdd8Wp56pnDDg994EAx47EvT8" +
       "kAHzt17Q//UmdX9SZN+MKxeBoE/be3lUcQLxP75ZGReHbR85hPiRt1zGtbLB" +
       "6zfB+e0i+wuAM7oW5x+d4PzWm8X5BEjGIU7jrRfl39yk7ntF9p24co9sq1JY" +
       "nCyeRfc/3gS6R4vCZ0H62UN0P/uWozt34SZ19xbZ7XHlXqCo+7PJ/dnjp47h" +
       "nbvjTcB7+Eh4XzmE95W3Ht4jN6l7tMgugQXPjHo7sE6Y5eHSiZc99+CbBfck" +
       "SF89BPfVt9QCj8KCh48PiY8sDO6V4J65CfDniuwJoLX+caRwBvmTbwL5O4rC" +
       "94D07UPk3/5/gvzdx8ivCYC48vHw5n+J+CY3Bs8hRfY8cFNyCLbW6r6z6epH" +
       "Ez1xZiLu8CIBWfw6YVn1lu7xxJVHrnvluLg/+dg1/3TY386Xf+mVi3c/+srs" +
       "35W3bo9v0F+gK3driW2fvt9y6vlOP1Q1s+Tohf1tF7+E/cG48gM3iUTj4v8M" +
       "xUNB+7kr+z4fAgv29frEldtAfrplJ65cOtsyrtxRfp9u1wdaeNIOTLp/ON2E" +
       "AKODJsUj6R8JpfXGw2F8HcWhJB9GxOdOBbWHqlv66Ye+n/iOu5y+6VtMWv59" +
       "5ShoTdjDO45feoUa/8jr6M/vbxrLtpTnxSh305W79peejwPfZ2442tFYdxLv" +
       "/e4DX77w3FGQ/sCe4BMzOkXbO69/rbfv+HF5ETf/1Uf/xQf/ySt/XB72/x+y" +
       "of32VzQAAA==");
}
