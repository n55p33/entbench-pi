package org.apache.batik.gvt;
public class UpdateTracker extends org.apache.batik.gvt.event.GraphicsNodeChangeAdapter {
    java.util.Map dirtyNodes = null;
    java.util.Map fromBounds = new java.util.HashMap();
    protected static java.awt.geom.Rectangle2D NULL_RECT = new java.awt.Rectangle(
      );
    public UpdateTracker() { super(); }
    public boolean hasChanged() { return dirtyNodes != null; }
    public java.util.List getDirtyAreas() { if (dirtyNodes == null)
                                                return null;
                                            java.util.List ret = new java.util.LinkedList(
                                              );
                                            java.util.Set keys =
                                              dirtyNodes.
                                              keySet(
                                                );
                                            java.util.Iterator i =
                                              keys.
                                              iterator(
                                                );
                                            while (i.hasNext(
                                                       )) {
                                                java.lang.ref.WeakReference gnWRef =
                                                  (java.lang.ref.WeakReference)
                                                    i.
                                                    next(
                                                      );
                                                org.apache.batik.gvt.GraphicsNode gn =
                                                  (org.apache.batik.gvt.GraphicsNode)
                                                    gnWRef.
                                                    get(
                                                      );
                                                if (gn ==
                                                      null)
                                                    continue;
                                                java.awt.geom.AffineTransform oat;
                                                oat =
                                                  (java.awt.geom.AffineTransform)
                                                    dirtyNodes.
                                                    get(
                                                      gnWRef);
                                                if (oat !=
                                                      null) {
                                                    oat =
                                                      new java.awt.geom.AffineTransform(
                                                        oat);
                                                }
                                                java.awt.geom.Rectangle2D srcORgn =
                                                  (java.awt.geom.Rectangle2D)
                                                    fromBounds.
                                                    remove(
                                                      gnWRef);
                                                java.awt.geom.Rectangle2D srcNRgn =
                                                  null;
                                                java.awt.geom.AffineTransform nat =
                                                  null;
                                                if (!(srcORgn instanceof org.apache.batik.gvt.UpdateTracker.ChngSrcRect)) {
                                                    srcNRgn =
                                                      gn.
                                                        getBounds(
                                                          );
                                                    nat =
                                                      gn.
                                                        getTransform(
                                                          );
                                                    if (nat !=
                                                          null)
                                                        nat =
                                                          new java.awt.geom.AffineTransform(
                                                            nat);
                                                }
                                                do  {
                                                    gn =
                                                      gn.
                                                        getParent(
                                                          );
                                                    if (gn ==
                                                          null)
                                                        break;
                                                    org.apache.batik.ext.awt.image.renderable.Filter f =
                                                      gn.
                                                      getFilter(
                                                        );
                                                    if (f !=
                                                          null) {
                                                        srcNRgn =
                                                          f.
                                                            getBounds2D(
                                                              );
                                                        nat =
                                                          null;
                                                    }
                                                    java.awt.geom.AffineTransform at =
                                                      gn.
                                                      getTransform(
                                                        );
                                                    gnWRef =
                                                      gn.
                                                        getWeakReference(
                                                          );
                                                    java.awt.geom.AffineTransform poat =
                                                      (java.awt.geom.AffineTransform)
                                                        dirtyNodes.
                                                        get(
                                                          gnWRef);
                                                    if (poat ==
                                                          null)
                                                        poat =
                                                          at;
                                                    if (poat !=
                                                          null) {
                                                        if (oat !=
                                                              null)
                                                            oat.
                                                              preConcatenate(
                                                                poat);
                                                        else
                                                            oat =
                                                              new java.awt.geom.AffineTransform(
                                                                poat);
                                                    }
                                                    if (at !=
                                                          null) {
                                                        if (nat !=
                                                              null)
                                                            nat.
                                                              preConcatenate(
                                                                at);
                                                        else
                                                            nat =
                                                              new java.awt.geom.AffineTransform(
                                                                at);
                                                    }
                                                }while(true); 
                                                if (gn ==
                                                      null) {
                                                    java.awt.Shape oRgn =
                                                      srcORgn;
                                                    if (oRgn !=
                                                          null &&
                                                          oRgn !=
                                                          NULL_RECT) {
                                                        if (oat !=
                                                              null)
                                                            oRgn =
                                                              oat.
                                                                createTransformedShape(
                                                                  srcORgn);
                                                        ret.
                                                          add(
                                                            oRgn);
                                                    }
                                                    if (srcNRgn !=
                                                          null) {
                                                        java.awt.Shape nRgn =
                                                          srcNRgn;
                                                        if (nat !=
                                                              null)
                                                            nRgn =
                                                              nat.
                                                                createTransformedShape(
                                                                  srcNRgn);
                                                        if (nRgn !=
                                                              null)
                                                            ret.
                                                              add(
                                                                nRgn);
                                                    }
                                                }
                                            }
                                            fromBounds.
                                              clear(
                                                );
                                            dirtyNodes.
                                              clear(
                                                );
                                            return ret;
    }
    public java.awt.geom.Rectangle2D getNodeDirtyRegion(org.apache.batik.gvt.GraphicsNode gn,
                                                        java.awt.geom.AffineTransform at) {
        java.lang.ref.WeakReference gnWRef =
          gn.
          getWeakReference(
            );
        java.awt.geom.AffineTransform nat =
          (java.awt.geom.AffineTransform)
            dirtyNodes.
            get(
              gnWRef);
        if (nat ==
              null)
            nat =
              gn.
                getTransform(
                  );
        if (nat !=
              null) {
            at =
              new java.awt.geom.AffineTransform(
                at);
            at.
              concatenate(
                nat);
        }
        org.apache.batik.ext.awt.image.renderable.Filter f =
          gn.
          getFilter(
            );
        java.awt.geom.Rectangle2D ret =
          null;
        if (gn instanceof org.apache.batik.gvt.CompositeGraphicsNode) {
            org.apache.batik.gvt.CompositeGraphicsNode cgn =
              (org.apache.batik.gvt.CompositeGraphicsNode)
                gn;
            java.util.Iterator iter =
              cgn.
              iterator(
                );
            while (iter.
                     hasNext(
                       )) {
                org.apache.batik.gvt.GraphicsNode childGN =
                  (org.apache.batik.gvt.GraphicsNode)
                    iter.
                    next(
                      );
                java.awt.geom.Rectangle2D r2d =
                  getNodeDirtyRegion(
                    childGN,
                    at);
                if (r2d !=
                      null) {
                    if (f !=
                          null) {
                        java.awt.Shape s =
                          at.
                          createTransformedShape(
                            f.
                              getBounds2D(
                                ));
                        ret =
                          s.
                            getBounds2D(
                              );
                        break;
                    }
                    if (ret ==
                          null ||
                          ret ==
                          NULL_RECT)
                        ret =
                          r2d;
                    else
                        ret.
                          add(
                            r2d);
                }
            }
        }
        else {
            ret =
              (java.awt.geom.Rectangle2D)
                fromBounds.
                remove(
                  gnWRef);
            if (ret ==
                  null) {
                if (f !=
                      null)
                    ret =
                      f.
                        getBounds2D(
                          );
                else
                    ret =
                      gn.
                        getBounds(
                          );
            }
            else
                if (ret ==
                      NULL_RECT)
                    ret =
                      null;
            if (ret !=
                  null)
                ret =
                  at.
                    createTransformedShape(
                      ret).
                    getBounds2D(
                      );
        }
        return ret;
    }
    public java.awt.geom.Rectangle2D getNodeDirtyRegion(org.apache.batik.gvt.GraphicsNode gn) {
        return getNodeDirtyRegion(
                 gn,
                 new java.awt.geom.AffineTransform(
                   ));
    }
    public void changeStarted(org.apache.batik.gvt.event.GraphicsNodeChangeEvent gnce) {
        org.apache.batik.gvt.GraphicsNode gn =
          gnce.
          getGraphicsNode(
            );
        java.lang.ref.WeakReference gnWRef =
          gn.
          getWeakReference(
            );
        boolean doPut =
          false;
        if (dirtyNodes ==
              null) {
            dirtyNodes =
              new java.util.HashMap(
                );
            doPut =
              true;
        }
        else
            if (!dirtyNodes.
                  containsKey(
                    gnWRef))
                doPut =
                  true;
        if (doPut) {
            java.awt.geom.AffineTransform at =
              gn.
              getTransform(
                );
            if (at !=
                  null)
                at =
                  (java.awt.geom.AffineTransform)
                    at.
                    clone(
                      );
            else
                at =
                  new java.awt.geom.AffineTransform(
                    );
            dirtyNodes.
              put(
                gnWRef,
                at);
        }
        org.apache.batik.gvt.GraphicsNode chngSrc =
          gnce.
          getChangeSrc(
            );
        java.awt.geom.Rectangle2D rgn =
          null;
        if (chngSrc !=
              null) {
            java.awt.geom.Rectangle2D drgn =
              getNodeDirtyRegion(
                chngSrc);
            if (drgn !=
                  null)
                rgn =
                  new org.apache.batik.gvt.UpdateTracker.ChngSrcRect(
                    drgn);
        }
        else {
            rgn =
              gn.
                getBounds(
                  );
        }
        java.awt.geom.Rectangle2D r2d =
          (java.awt.geom.Rectangle2D)
            fromBounds.
            remove(
              gnWRef);
        if (rgn !=
              null) {
            if (r2d !=
                  null &&
                  r2d !=
                  NULL_RECT) {
                r2d.
                  add(
                    rgn);
            }
            else
                r2d =
                  rgn;
        }
        if (r2d ==
              null)
            r2d =
              NULL_RECT;
        fromBounds.
          put(
            gnWRef,
            r2d);
    }
    class ChngSrcRect extends java.awt.geom.Rectangle2D.Float {
        ChngSrcRect(java.awt.geom.Rectangle2D r2d) {
            super(
              (float)
                r2d.
                getX(
                  ),
              (float)
                r2d.
                getY(
                  ),
              (float)
                r2d.
                getWidth(
                  ),
              (float)
                r2d.
                getHeight(
                  ));
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "BnFxBZf9wUO/957ffuWbxXn9fwG3UYmwJxwAAA==");
    }
    public void clear() { dirtyNodes = null;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "D2js+O7Kn/hA66thr/St9r+q+M8JKyEAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "L5UrAAA=");
}
