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
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "9sLsCm79Bw/+3sd/+/XvZuf1/wVwZK7GJxwAAA==");
    }
    public void clear() { dirtyNodes = null;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "n9DY8d2eP/GB1lfDXulb7X8BSaj66CshAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "kniysvFsJq7baEgqKDwHYRCtzZZhzAeGFQTermmK23aXg2NUjWwwQ1TmmU5q" +
       "45XqikE4rDhEr16bBQyWxTkm7xZDZ9ONxAWb7Xad9RYX+rpnIYyUzxBml0qk" +
       "bjiz9bbjapUqlQ9hbbVpVJPJCpUnbI1j9Y6CNtAZqxJoLg4EG+u085leo+gV" +
       "i7NsgDIdrJ33JbjnOmETFaqz/mq4wGzbmNuYQGxn+KIL1jVjFlMjZ7mICMmd" +
       "t+pVVmIHHiXVwiwVV3W501T1TopmO2puTNHNIrYHjWTAaZOWGBs1kuQlhORF" +
       "31+4nRZhjAJE9Wl0N+jh7rAptLtjNejpGRoO2wgd9vgE+LIxmA0C1VntppbL" +
       "OTEZNH1rhtUldUlZ3VYtJcftyUQP5dm0vl2QRk3eUmJl5Ii9DSN4m66RISHq" +
       "jPClXkmNoD1t2U6rJtu7iiSPmtVtNFU6wCDt1kaITDlLtY21qFWcfOwwu82I" +
       "F5IUrVu1FW0OYTaLN+nQSrRaB08nvRzLyBpsVcRKn6XNyFvSuQbv1C5BsCQW" +
       "LxkvUwc7QtgxirCby3kwGCM7febWzVRO5tush/TFYmES0LZVqwtdhRSrzNoG" +
       "QSkNcVUdVqh+b+YYtZ2+zc3O0ND9EdfRtw0qkruVRVMYEYsqXV3ktbWC6mt0" +
       "ji7VEGso40lKVlGfG0ZwlQtCxK066DyP6vxKa5FYg6xiFXmcd9PYWNhTnrXH" +
       "MrwlCSeEe91x2N/YckNvtOaNtCoJYX9sW2N4QW9XTXYrVimfqlqeunTNeOrl" +
       "VSLSQ9QbJ7rm2LWKnIzUVpUeei2jO413K2K0m5le19yhZo33ZMWtolU1yXBa" +
       "IcJqXYYrhqo6Gq9RUiXJ6YbYzhuksJoTvokF/dlQdv1Raybag94gQeNVNO1S" +
       "VqvRZgOuvkvWg1TsUBaz6oKJvOIi9Nwb4vOeECwwnOg2GgzZNmJ/tyF1ZYgG" +
       "wXIuSTiey/6sa9S7lUzDUzyzJcZn5/0UZWsDBp/xcUojMULl3JJp5fN+YhKp" +
       "22AXpIpqQ7hFV22dnSf2ipiT9Fhe4zgTmRRFfbDYWvjRt7a783C5kXV81L62" +
       "iaLBegu7Gvump4ri2eMNwvJ3CTp3PHv64OfkNAAqdmqeuNMJerlL84WPv/Sy" +
       "Ovhi9WgndxdDV2LP/z5b22r2uYOF5++8I9UrLxCc7O7/7sf/y+OTHzQ/+hbO" +
       "LN93js/zKH+h98rvt75X+amL0D3He/23XG042+mFszv8V0MtTkJ3cmaf/4lj" +
       "zb6z0NgT4CEPNUveboP3+u2t4EJpBfuxv8sh1Ut3aftsUfxkDF015YgxZdfQ" +
       "9jcy4lN2ksXQ5ZXn2ZrsntjQp99sZ+w0pbLiJ46Fvn4k9IcOhf7Q2y/0375L" +
       "2xeL4uUYetDQwCI8jHdUqMnnt97LE91rd2PyaHf4odOHc/uDzF84UdTPfxeK" +
       "erSofA48Xz7k4ctvj6Iu7rftjwR46rZXDlqh7JuWEpVHQYeQT5zduad03XKL" +
       "WwluVJyYl7S+fBfF/1pRfCmGHgGKL9CWyhc14/BE++aJ1l59O7T2+qHWXn97" +
       "tHbhBOBXSoDfuouov10Uv/GdiPqPvgtRSyN9ATxvHIr6xtsq6tGwo7c1EBCt" +
       "3bNmso8gXFFfov2nd1HQPy+KfwycUCk7jWM5jG8ffO7depZ6oq+vfLf6AvZx" +
       "4fl93/377Y08r9+l7Y+L4t/F0H0KiKblmfW/OBHs378VwYBeHjxzKai44fDY" +
       "LdcL91filC+9fO3+R1+W/lV5L+b42toVAbpfT2z79IH0qe9LfqjpVsn3lf3x" +
       "tF++vh5D77qdQcTQPaAsOX1jD/knMXT9PCQQvnyfhvuvYAI6gYuhS/uP0yD/" +
       "DWAHIMXnf/eP7LL+luySUmU/1sLswtls5Vj/j7yZ/k8lOM+cSUvKy59HKUQy" +
       "PDwZf/XlTv9HvoV/cX+pR7HlPC+w3C9Al/f3i47TkKfuiO0I16X2c99+6Jev" +
       "PHuUMj20Z/jEWk/x9r7b36DhHD8u77zk/+DRX/mBv/PyH5VHif8PRAYc/ZUr" +
       "AAA=");
}
