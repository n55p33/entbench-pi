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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "H2EqLQAA");
}
