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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1ZfZAUxRXv3eO+77gPvr8OPA4IqLtCRGIOP+D4Ol2OKw6v" +
       "4qEevbO9ewOzM+NM791ySiLmQ2KVFiGIJlH+CRaEQiGpWCZloEhMopaaKj8S" +
       "YxI0Fa0KiVJIpSQfmpj3umd2Zmc/8Kpyuarpnet+73W/1+/93uueY+dIpW2R" +
       "NqbzCN9pMjuyVue91LJZokujtr0F+gaVhyvo3+4423NtmFQNkIlD1N6oUJut" +
       "U5mWsAfIHFW3OdUVZvcwlkCOXovZzBqmXDX0ATJFtbvTpqYqKt9oJBgS9FMr" +
       "Rloo55Yaz3DW7QjgZE4MVhIVK4muCg53xkiDYpg7PfLpPvIu3whSpr25bE6a" +
       "Y9vpMI1muKpFY6rNO7MWudw0tJ0pzeARluWR7dpyxwQ3xZYXmKD9RNPFj/YO" +
       "NQsTTKK6bnChnr2Z2YY2zBIx0uT1rtVY2r6TfJFUxEi9j5iTjpg7aRQmjcKk" +
       "rrYeFay+kemZdJch1OGupCpTwQVxclm+EJNaNO2I6RVrBgk13NFdMIO283La" +
       "Si0LVHzo8uj+h+9o/kEFaRogTareh8tRYBEcJhkAg7J0nFn2qkSCJQZIiw6b" +
       "3ccslWrqqLPTrbaa0inPwPa7ZsHOjMksMadnK9hH0M3KKNywcuolhUM5/1Um" +
       "NZoCXad6ukoN12E/KFinwsKsJAW/c1gm7FD1BCdzgxw5HTtuBgJgrU4zPmTk" +
       "ppqgU+ggrdJFNKqnon3genoKSCsNcECLk5klhaKtTarsoCk2iB4ZoOuVQ0BV" +
       "KwyBLJxMCZIJSbBLMwO75Nufcz0rH7xL36CHSQjWnGCKhuuvB6a2ANNmlmQW" +
       "gziQjA1LYgfo1JN7woQA8ZQAsaR5+u4LN17Rdvp5STOrCM2m+Ham8EHlUHzi" +
       "K7O7Fl9bgcuoMQ1bxc3P01xEWa8z0pk1AWGm5iTiYMQdPL35l7fec5S9FyZ1" +
       "3aRKMbRMGvyoRTHSpqoxaz3TmUU5S3STWqYnusR4N6mG95iqM9m7KZm0Ge8m" +
       "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" +
       "XH2qeMW3af8FEVq75w8hAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "w2gDhhEsAAA=");
}
