package org.apache.batik.ext.awt.image.renderable;
public class FilterAlphaRable extends org.apache.batik.ext.awt.image.renderable.AbstractRable {
    public FilterAlphaRable(org.apache.batik.ext.awt.image.renderable.Filter src) {
        super(
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
    public java.awt.geom.Rectangle2D getBounds2D() { return getSource(
                                                              ).getBounds2D(
                                                                  );
    }
    public java.awt.image.RenderedImage createRendering(java.awt.image.renderable.RenderContext rc) {
        java.awt.geom.AffineTransform at =
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
        rh.
          put(
            org.apache.batik.ext.awt.RenderingHintsKeyExt.
              KEY_COLORSPACE,
            org.apache.batik.ext.awt.ColorSpaceHintKey.
              VALUE_COLORSPACE_ALPHA);
        java.awt.image.RenderedImage ri;
        ri =
          getSource(
            ).
            createRendering(
              new java.awt.image.renderable.RenderContext(
                at,
                aoi,
                rh));
        if (ri ==
              null) {
            return null;
        }
        org.apache.batik.ext.awt.image.rendered.CachableRed cr =
          org.apache.batik.ext.awt.image.rendered.RenderedImageCachableRed.
          wrap(
            ri);
        java.lang.Object val =
          cr.
          getProperty(
            org.apache.batik.ext.awt.ColorSpaceHintKey.
              PROPERTY_COLORSPACE);
        if (val ==
              org.apache.batik.ext.awt.ColorSpaceHintKey.
                VALUE_COLORSPACE_ALPHA)
            return cr;
        return new org.apache.batik.ext.awt.image.rendered.FilterAlphaRed(
          cr);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Dtf+DUkNf8v7FgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "9gQhqygexor/w3bLRyXmFfaBcfdklY+C5w17xr3hJ2/cO27S9ktZ8bYIuh0Y" +
       "R7ixo4VIc//451X5YUx2Vmrorr071FUweoal71Hktj/9Y9j+qqzydeB5as/2" +
       "p34ytp84An7tgRnXHPkO89e9u95c1vtv4qsPZsV7IuiCGuhypG+ZTcfY7+j+" +
       "Ex1tCXStm/06dNl7X4rL1hF08eQlUnYifu8119rbq1j1M89euO2eZ0d/nd+j" +
       "HFyXnqOh22axZR09hzzyfsYL9JmZG3lueyrp5V8fjaAnfuQD9CibyPs/ckN+" +
       "YyvlNyPowZtLiaDT5oGT9rh+K4LuvRFXBN0CyqPUn4igV1yPGlCC8ijlJ4FH" +
       "T1KC/vPvo3S/C+w5pIugM9uXoySfAdIBSfb6vLcfBdiPfuNQV8IokNUoH9X1" +
       "qeMrxEG8XPph8XJkUXns2FKQ/0NiH7bj7X8krqrPP0sxb32x+ontjZVqyWma" +
       "SbmNhs5uL88OoP+RG0rbl3Wm88T37/zsucf3l6k7twofztsjuj10/euhlu1F" +
       "+YVO+of3/P4bf/vZr+dHvf8H1brtpLoiAAA=");
}
