package org.apache.batik.gvt.filter;
public class BackgroundRable8Bit extends org.apache.batik.ext.awt.image.renderable.AbstractRable {
    private org.apache.batik.gvt.GraphicsNode node;
    public org.apache.batik.gvt.GraphicsNode getGraphicsNode() { return node;
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
    public BackgroundRable8Bit(org.apache.batik.gvt.GraphicsNode node) { super(
                                                                           );
                                                                         if (node ==
                                                                               null)
                                                                             throw new java.lang.IllegalArgumentException(
                                                                               );
                                                                         this.
                                                                           node =
                                                                           node;
    }
    static java.awt.geom.Rectangle2D addBounds(org.apache.batik.gvt.CompositeGraphicsNode cgn,
                                               org.apache.batik.gvt.GraphicsNode child,
                                               java.awt.geom.Rectangle2D init) {
        java.util.List children =
          cgn.
          getChildren(
            );
        java.util.Iterator i =
          children.
          iterator(
            );
        java.awt.geom.Rectangle2D r2d =
          null;
        while (i.
                 hasNext(
                   )) {
            org.apache.batik.gvt.GraphicsNode gn =
              (org.apache.batik.gvt.GraphicsNode)
                i.
                next(
                  );
            if (gn ==
                  child)
                break;
            java.awt.geom.Rectangle2D cr2d =
              gn.
              getBounds(
                );
            java.awt.geom.AffineTransform at =
              gn.
              getTransform(
                );
            if (at !=
                  null)
                cr2d =
                  at.
                    createTransformedShape(
                      cr2d).
                    getBounds2D(
                      );
            if (r2d ==
                  null)
                r2d =
                  (java.awt.geom.Rectangle2D)
                    cr2d.
                    clone(
                      );
            else
                r2d.
                  add(
                    cr2d);
        }
        if (r2d ==
              null) {
            if (init ==
                  null)
                return org.apache.batik.gvt.CompositeGraphicsNode.
                         VIEWPORT;
            return init;
        }
        if (init ==
              null)
            return r2d;
        init.
          add(
            r2d);
        return init;
    }
    static java.awt.geom.Rectangle2D getViewportBounds(org.apache.batik.gvt.GraphicsNode gn,
                                                       org.apache.batik.gvt.GraphicsNode child) {
        java.awt.geom.Rectangle2D r2d =
          null;
        if (gn instanceof org.apache.batik.gvt.CompositeGraphicsNode) {
            org.apache.batik.gvt.CompositeGraphicsNode cgn =
              (org.apache.batik.gvt.CompositeGraphicsNode)
                gn;
            r2d =
              cgn.
                getBackgroundEnable(
                  );
        }
        if (r2d ==
              null)
            r2d =
              getViewportBounds(
                gn.
                  getParent(
                    ),
                gn);
        if (r2d ==
              null)
            return null;
        if (r2d ==
              org.apache.batik.gvt.CompositeGraphicsNode.
                VIEWPORT) {
            if (child ==
                  null)
                return (java.awt.geom.Rectangle2D)
                         gn.
                         getPrimitiveBounds(
                           ).
                         clone(
                           );
            org.apache.batik.gvt.CompositeGraphicsNode cgn =
              (org.apache.batik.gvt.CompositeGraphicsNode)
                gn;
            return addBounds(
                     cgn,
                     child,
                     null);
        }
        java.awt.geom.AffineTransform at =
          gn.
          getTransform(
            );
        if (at !=
              null) {
            try {
                at =
                  at.
                    createInverse(
                      );
                r2d =
                  at.
                    createTransformedShape(
                      r2d).
                    getBounds2D(
                      );
            }
            catch (java.awt.geom.NoninvertibleTransformException nte) {
                r2d =
                  null;
            }
        }
        if (child !=
              null) {
            org.apache.batik.gvt.CompositeGraphicsNode cgn =
              (org.apache.batik.gvt.CompositeGraphicsNode)
                gn;
            r2d =
              addBounds(
                cgn,
                child,
                r2d);
        }
        else {
            java.awt.geom.Rectangle2D gnb =
              gn.
              getPrimitiveBounds(
                );
            if (gnb !=
                  null)
                r2d.
                  add(
                    gnb);
        }
        return r2d;
    }
    static java.awt.geom.Rectangle2D getBoundsRecursive(org.apache.batik.gvt.GraphicsNode gn,
                                                        org.apache.batik.gvt.GraphicsNode child) {
        java.awt.geom.Rectangle2D r2d =
          null;
        if (gn ==
              null) {
            return null;
        }
        if (gn instanceof org.apache.batik.gvt.CompositeGraphicsNode) {
            org.apache.batik.gvt.CompositeGraphicsNode cgn =
              (org.apache.batik.gvt.CompositeGraphicsNode)
                gn;
            r2d =
              cgn.
                getBackgroundEnable(
                  );
        }
        if (r2d !=
              null)
            return r2d;
        r2d =
          getBoundsRecursive(
            gn.
              getParent(
                ),
            gn);
        if (r2d ==
              null) {
            return new java.awt.geom.Rectangle2D.Float(
              0,
              0,
              0,
              0);
        }
        if (r2d ==
              org.apache.batik.gvt.CompositeGraphicsNode.
                VIEWPORT)
            return r2d;
        java.awt.geom.AffineTransform at =
          gn.
          getTransform(
            );
        if (at !=
              null) {
            try {
                at =
                  at.
                    createInverse(
                      );
                r2d =
                  at.
                    createTransformedShape(
                      r2d).
                    getBounds2D(
                      );
            }
            catch (java.awt.geom.NoninvertibleTransformException nte) {
                r2d =
                  null;
            }
        }
        return r2d;
    }
    public java.awt.geom.Rectangle2D getBounds2D() {
        java.awt.geom.Rectangle2D r2d =
          getBoundsRecursive(
            node,
            null);
        if (r2d ==
              org.apache.batik.gvt.CompositeGraphicsNode.
                VIEWPORT) {
            r2d =
              getViewportBounds(
                node,
                null);
        }
        return r2d;
    }
    public org.apache.batik.ext.awt.image.renderable.Filter getBackground(org.apache.batik.gvt.GraphicsNode gn,
                                                                          org.apache.batik.gvt.GraphicsNode child,
                                                                          java.awt.geom.Rectangle2D aoi) {
        if (gn ==
              null) {
            throw new java.lang.IllegalArgumentException(
              "BackgroundImage requested yet no parent has " +
              "\'enable-background:new\'");
        }
        java.awt.geom.Rectangle2D r2d =
          null;
        if (gn instanceof org.apache.batik.gvt.CompositeGraphicsNode) {
            org.apache.batik.gvt.CompositeGraphicsNode cgn =
              (org.apache.batik.gvt.CompositeGraphicsNode)
                gn;
            r2d =
              cgn.
                getBackgroundEnable(
                  );
        }
        java.util.List srcs =
          new java.util.ArrayList(
          );
        if (r2d ==
              null) {
            java.awt.geom.Rectangle2D paoi =
              aoi;
            java.awt.geom.AffineTransform at =
              gn.
              getTransform(
                );
            if (at !=
                  null)
                paoi =
                  at.
                    createTransformedShape(
                      aoi).
                    getBounds2D(
                      );
            org.apache.batik.ext.awt.image.renderable.Filter f =
              getBackground(
                gn.
                  getParent(
                    ),
                gn,
                paoi);
            if (f !=
                  null &&
                  f.
                  getBounds2D(
                    ).
                  intersects(
                    aoi)) {
                srcs.
                  add(
                    f);
            }
        }
        if (child !=
              null) {
            org.apache.batik.gvt.CompositeGraphicsNode cgn =
              (org.apache.batik.gvt.CompositeGraphicsNode)
                gn;
            java.util.List children =
              cgn.
              getChildren(
                );
            java.util.Iterator i =
              children.
              iterator(
                );
            while (i.
                     hasNext(
                       )) {
                org.apache.batik.gvt.GraphicsNode childGN =
                  (org.apache.batik.gvt.GraphicsNode)
                    i.
                    next(
                      );
                if (childGN ==
                      child)
                    break;
                java.awt.geom.Rectangle2D cbounds =
                  childGN.
                  getBounds(
                    );
                java.awt.geom.AffineTransform at =
                  childGN.
                  getTransform(
                    );
                if (at !=
                      null)
                    cbounds =
                      at.
                        createTransformedShape(
                          cbounds).
                        getBounds2D(
                          );
                if (aoi.
                      intersects(
                        cbounds)) {
                    srcs.
                      add(
                        childGN.
                          getEnableBackgroundGraphicsNodeRable(
                            true));
                }
            }
        }
        if (srcs.
              size(
                ) ==
              0)
            return null;
        org.apache.batik.ext.awt.image.renderable.Filter ret =
          null;
        if (srcs.
              size(
                ) ==
              1)
            ret =
              (org.apache.batik.ext.awt.image.renderable.Filter)
                srcs.
                get(
                  0);
        else
            ret =
              new org.apache.batik.ext.awt.image.renderable.CompositeRable8Bit(
                srcs,
                org.apache.batik.ext.awt.image.CompositeRule.
                  OVER,
                false);
        if (child !=
              null) {
            java.awt.geom.AffineTransform at =
              child.
              getTransform(
                );
            if (at !=
                  null) {
                try {
                    at =
                      at.
                        createInverse(
                          );
                    ret =
                      new org.apache.batik.ext.awt.image.renderable.AffineRable8Bit(
                        ret,
                        at);
                }
                catch (java.awt.geom.NoninvertibleTransformException nte) {
                    ret =
                      null;
                }
            }
        }
        return ret;
    }
    public boolean isDynamic() { return false;
    }
    public java.awt.image.RenderedImage createRendering(java.awt.image.renderable.RenderContext renderContext) {
        java.awt.geom.Rectangle2D r2d =
          getBounds2D(
            );
        java.awt.Shape aoi =
          renderContext.
          getAreaOfInterest(
            );
        if (aoi !=
              null) {
            java.awt.geom.Rectangle2D aoiR2d =
              aoi.
              getBounds2D(
                );
            if (!r2d.
                  intersects(
                    aoiR2d))
                return null;
            java.awt.geom.Rectangle2D.
              intersect(
                r2d,
                aoiR2d,
                r2d);
        }
        org.apache.batik.ext.awt.image.renderable.Filter background =
          getBackground(
            node,
            null,
            r2d);
        if (background ==
              null)
            return null;
        background =
          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
            background,
            r2d,
            org.apache.batik.ext.awt.image.PadMode.
              ZERO_PAD);
        java.awt.image.RenderedImage ri =
          background.
          createRendering(
            new java.awt.image.renderable.RenderContext(
              renderContext.
                getTransform(
                  ),
              r2d,
              renderContext.
                getRenderingHints(
                  )));
        return ri;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "q08Vr/g27b9mZVIrDyEAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "uDza/r98VWm5ESwAAA==");
}
