package org.apache.batik.ext.awt.image.renderable;
public class ClipRable8Bit extends org.apache.batik.ext.awt.image.renderable.AbstractRable implements org.apache.batik.ext.awt.image.renderable.ClipRable {
    protected boolean useAA;
    protected java.awt.Shape clipPath;
    public ClipRable8Bit(org.apache.batik.ext.awt.image.renderable.Filter src,
                         java.awt.Shape clipPath) { super(src, null);
                                                    setClipPath(clipPath);
                                                    setUseAntialiasedClip(
                                                      false); }
    public ClipRable8Bit(org.apache.batik.ext.awt.image.renderable.Filter src,
                         java.awt.Shape clipPath,
                         boolean useAA) { super(src, null);
                                          setClipPath(clipPath);
                                          setUseAntialiasedClip(useAA); }
    public void setSource(org.apache.batik.ext.awt.image.renderable.Filter src) {
        init(
          src,
          null);
    }
    public org.apache.batik.ext.awt.image.renderable.Filter getSource() {
        return (org.apache.batik.ext.awt.image.renderable.Filter)
                 getSources(
                   ).
                 get(
                   0);
    }
    public void setUseAntialiasedClip(boolean useAA) { touch();
                                                       this.useAA =
                                                         useAA; }
    public boolean getUseAntialiasedClip() { return useAA; }
    public void setClipPath(java.awt.Shape clipPath) { touch();
                                                       this.clipPath =
                                                         clipPath;
    }
    public java.awt.Shape getClipPath() { return clipPath; }
    public java.awt.geom.Rectangle2D getBounds2D() { return getSource(
                                                              ).getBounds2D(
                                                                  );
    }
    public java.awt.image.RenderedImage createRendering(java.awt.image.renderable.RenderContext rc) {
        java.awt.geom.AffineTransform usr2dev =
          rc.
          getTransform(
            );
        java.awt.RenderingHints rh =
          rc.
          getRenderingHints(
            );
        if (rh ==
              null)
            rh =
              new java.awt.RenderingHints(
                null);
        java.awt.Shape aoi =
          rc.
          getAreaOfInterest(
            );
        if (aoi ==
              null)
            aoi =
              getBounds2D(
                );
        java.awt.geom.Rectangle2D rect =
          getBounds2D(
            );
        java.awt.geom.Rectangle2D clipRect =
          clipPath.
          getBounds2D(
            );
        java.awt.geom.Rectangle2D aoiRect =
          aoi.
          getBounds2D(
            );
        if (!rect.
              intersects(
                clipRect))
            return null;
        java.awt.geom.Rectangle2D.
          intersect(
            rect,
            clipRect,
            rect);
        if (!rect.
              intersects(
                aoiRect))
            return null;
        java.awt.geom.Rectangle2D.
          intersect(
            rect,
            aoi.
              getBounds2D(
                ),
            rect);
        java.awt.Rectangle devR =
          usr2dev.
          createTransformedShape(
            rect).
          getBounds(
            );
        if (devR.
              width ==
              0 ||
              devR.
                height ==
              0)
            return null;
        java.awt.image.BufferedImage bi =
          new java.awt.image.BufferedImage(
          devR.
            width,
          devR.
            height,
          java.awt.image.BufferedImage.
            TYPE_BYTE_GRAY);
        java.awt.Shape devShape =
          usr2dev.
          createTransformedShape(
            getClipPath(
              ));
        java.awt.Rectangle devAOIR;
        devAOIR =
          usr2dev.
            createTransformedShape(
              aoi).
            getBounds(
              );
        java.awt.Graphics2D g2d =
          org.apache.batik.ext.awt.image.GraphicsUtil.
          createGraphics(
            bi,
            rh);
        if (false) {
            java.util.Set s =
              rh.
              keySet(
                );
            java.util.Iterator i =
              s.
              iterator(
                );
            while (i.
                     hasNext(
                       )) {
                java.lang.Object o =
                  i.
                  next(
                    );
                java.lang.System.
                  out.
                  println(
                    "XXX: " +
                    o +
                    " -> " +
                    rh.
                      get(
                        o));
            }
        }
        g2d.
          translate(
            -devR.
               x,
            -devR.
               y);
        g2d.
          setPaint(
            java.awt.Color.
              white);
        g2d.
          fill(
            devShape);
        g2d.
          dispose(
            );
        java.awt.image.RenderedImage ri;
        ri =
          getSource(
            ).
            createRendering(
              new java.awt.image.renderable.RenderContext(
                usr2dev,
                rect,
                rh));
        org.apache.batik.ext.awt.image.rendered.CachableRed cr;
        org.apache.batik.ext.awt.image.rendered.CachableRed clipCr;
        cr =
          org.apache.batik.ext.awt.image.rendered.RenderedImageCachableRed.
            wrap(
              ri);
        clipCr =
          new org.apache.batik.ext.awt.image.rendered.BufferedImageCachableRed(
            bi,
            devR.
              x,
            devR.
              y);
        org.apache.batik.ext.awt.image.rendered.CachableRed ret =
          new org.apache.batik.ext.awt.image.rendered.MultiplyAlphaRed(
          cr,
          clipCr);
        ret =
          new org.apache.batik.ext.awt.image.rendered.PadRed(
            ret,
            devAOIR,
            org.apache.batik.ext.awt.image.PadMode.
              ZERO_PAD,
            rh);
        return ret;
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
