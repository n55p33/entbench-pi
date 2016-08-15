package org.apache.batik.ext.awt.image.renderable;
public class FilterResRable8Bit extends org.apache.batik.ext.awt.image.renderable.AbstractRable implements org.apache.batik.ext.awt.image.renderable.FilterResRable, org.apache.batik.ext.awt.image.renderable.PaintRable {
    private int filterResolutionX = -1;
    private int filterResolutionY = -1;
    public FilterResRable8Bit() { super(); }
    public FilterResRable8Bit(org.apache.batik.ext.awt.image.renderable.Filter src,
                              int filterResX,
                              int filterResY) { super();
                                                init(src, null);
                                                setFilterResolutionX(
                                                  filterResX);
                                                setFilterResolutionY(
                                                  filterResY); }
    public org.apache.batik.ext.awt.image.renderable.Filter getSource() {
        return (org.apache.batik.ext.awt.image.renderable.Filter)
                 srcs.
                 get(
                   0);
    }
    public void setSource(org.apache.batik.ext.awt.image.renderable.Filter src) {
        init(
          src,
          null);
    }
    public int getFilterResolutionX() { return filterResolutionX;
    }
    public void setFilterResolutionX(int filterResolutionX) {
        if (filterResolutionX <
              0) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        touch(
          );
        this.
          filterResolutionX =
          filterResolutionX;
    }
    public int getFilterResolutionY() { return filterResolutionY;
    }
    public void setFilterResolutionY(int filterResolutionY) {
        touch(
          );
        this.
          filterResolutionY =
          filterResolutionY;
    }
    public boolean allPaintRable(java.awt.image.renderable.RenderableImage ri) {
        if (!(ri instanceof org.apache.batik.ext.awt.image.renderable.PaintRable))
            return false;
        java.util.List v =
          ri.
          getSources(
            );
        if (v ==
              null)
            return true;
        java.util.Iterator i =
          v.
          iterator(
            );
        while (i.
                 hasNext(
                   )) {
            java.awt.image.renderable.RenderableImage nri =
              (java.awt.image.renderable.RenderableImage)
                i.
                next(
                  );
            if (!allPaintRable(
                   nri))
                return false;
        }
        return true;
    }
    public boolean distributeAcross(java.awt.image.renderable.RenderableImage src,
                                    java.awt.Graphics2D g2d) {
        boolean ret;
        if (src instanceof org.apache.batik.ext.awt.image.renderable.PadRable) {
            org.apache.batik.ext.awt.image.renderable.PadRable pad =
              (org.apache.batik.ext.awt.image.renderable.PadRable)
                src;
            java.awt.Shape clip =
              g2d.
              getClip(
                );
            g2d.
              clip(
                pad.
                  getPadRect(
                    ));
            ret =
              distributeAcross(
                pad.
                  getSource(
                    ),
                g2d);
            g2d.
              setClip(
                clip);
            return ret;
        }
        if (src instanceof org.apache.batik.ext.awt.image.renderable.CompositeRable) {
            org.apache.batik.ext.awt.image.renderable.CompositeRable comp =
              (org.apache.batik.ext.awt.image.renderable.CompositeRable)
                src;
            if (comp.
                  getCompositeRule(
                    ) !=
                  org.apache.batik.ext.awt.image.CompositeRule.
                    OVER)
                return false;
            if (false) {
                java.awt.color.ColorSpace crCS =
                  comp.
                  getOperationColorSpace(
                    );
                java.awt.color.ColorSpace g2dCS =
                  org.apache.batik.ext.awt.image.GraphicsUtil.
                  getDestinationColorSpace(
                    g2d);
                if (g2dCS ==
                      null ||
                      g2dCS !=
                      crCS)
                    return false;
            }
            java.util.List v =
              comp.
              getSources(
                );
            if (v ==
                  null)
                return true;
            java.util.ListIterator li =
              v.
              listIterator(
                v.
                  size(
                    ));
            while (li.
                     hasPrevious(
                       )) {
                java.awt.image.renderable.RenderableImage csrc =
                  (java.awt.image.renderable.RenderableImage)
                    li.
                    previous(
                      );
                if (!allPaintRable(
                       csrc)) {
                    li.
                      next(
                        );
                    break;
                }
            }
            if (!li.
                  hasPrevious(
                    )) {
                org.apache.batik.ext.awt.image.GraphicsUtil.
                  drawImage(
                    g2d,
                    comp);
                return true;
            }
            if (!li.
                  hasNext(
                    ))
                return false;
            int idx =
              li.
              nextIndex(
                );
            org.apache.batik.ext.awt.image.renderable.Filter f =
              new org.apache.batik.ext.awt.image.renderable.CompositeRable8Bit(
              v.
                subList(
                  0,
                  idx),
              comp.
                getCompositeRule(
                  ),
              comp.
                isColorSpaceLinear(
                  ));
            f =
              new org.apache.batik.ext.awt.image.renderable.FilterResRable8Bit(
                f,
                getFilterResolutionX(
                  ),
                getFilterResolutionY(
                  ));
            org.apache.batik.ext.awt.image.GraphicsUtil.
              drawImage(
                g2d,
                f);
            while (li.
                     hasNext(
                       )) {
                org.apache.batik.ext.awt.image.renderable.PaintRable pr =
                  (org.apache.batik.ext.awt.image.renderable.PaintRable)
                    li.
                    next(
                      );
                if (!pr.
                      paintRable(
                        g2d)) {
                    org.apache.batik.ext.awt.image.renderable.Filter prf =
                      (org.apache.batik.ext.awt.image.renderable.Filter)
                        pr;
                    prf =
                      new org.apache.batik.ext.awt.image.renderable.FilterResRable8Bit(
                        prf,
                        getFilterResolutionX(
                          ),
                        getFilterResolutionY(
                          ));
                    org.apache.batik.ext.awt.image.GraphicsUtil.
                      drawImage(
                        g2d,
                        prf);
                }
            }
            return true;
        }
        return false;
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
        org.apache.batik.ext.awt.image.renderable.Filter src =
          getSource(
            );
        return distributeAcross(
                 src,
                 g2d);
    }
    java.lang.ref.Reference resRed = null;
    float resScale = 0;
    private float getResScale() { return resScale;
    }
    private java.awt.image.RenderedImage getResRed(java.awt.RenderingHints hints) {
        java.awt.geom.Rectangle2D imageRect =
          getBounds2D(
            );
        double resScaleX =
          getFilterResolutionX(
            ) /
          imageRect.
          getWidth(
            );
        double resScaleY =
          getFilterResolutionY(
            ) /
          imageRect.
          getHeight(
            );
        float resScale =
          (float)
            java.lang.Math.
            min(
              resScaleX,
              resScaleY);
        java.awt.image.RenderedImage ret;
        if (resScale ==
              this.
                resScale) {
            ret =
              (java.awt.image.RenderedImage)
                resRed.
                get(
                  );
            if (ret !=
                  null)
                return ret;
        }
        java.awt.geom.AffineTransform resUsr2Dev;
        resUsr2Dev =
          java.awt.geom.AffineTransform.
            getScaleInstance(
              resScale,
              resScale);
        java.awt.image.renderable.RenderContext newRC =
          new java.awt.image.renderable.RenderContext(
          resUsr2Dev,
          null,
          hints);
        ret =
          getSource(
            ).
            createRendering(
              newRC);
        ret =
          new org.apache.batik.ext.awt.image.rendered.TileCacheRed(
            org.apache.batik.ext.awt.image.GraphicsUtil.
              wrap(
                ret));
        this.
          resScale =
          resScale;
        this.
          resRed =
          new java.lang.ref.SoftReference(
            ret);
        return ret;
    }
    public java.awt.image.RenderedImage createRendering(java.awt.image.renderable.RenderContext renderContext) {
        java.awt.geom.AffineTransform usr2dev =
          renderContext.
          getTransform(
            );
        if (usr2dev ==
              null) {
            usr2dev =
              new java.awt.geom.AffineTransform(
                );
        }
        java.awt.RenderingHints hints =
          renderContext.
          getRenderingHints(
            );
        int filterResolutionX =
          getFilterResolutionX(
            );
        int filterResolutionY =
          getFilterResolutionY(
            );
        if (filterResolutionX <=
              0 ||
              filterResolutionY ==
              0)
            return null;
        java.awt.geom.Rectangle2D imageRect =
          getBounds2D(
            );
        java.awt.Rectangle devRect;
        devRect =
          usr2dev.
            createTransformedShape(
              imageRect).
            getBounds(
              );
        float scaleX =
          1;
        if (filterResolutionX <
              devRect.
                width)
            scaleX =
              filterResolutionX /
                (float)
                  devRect.
                    width;
        float scaleY =
          1;
        if (filterResolutionY <
              0)
            scaleY =
              scaleX;
        else
            if (filterResolutionY <
                  devRect.
                    height)
                scaleY =
                  filterResolutionY /
                    (float)
                      devRect.
                        height;
        if (scaleX >=
              1 &&
              scaleY >=
              1)
            return getSource(
                     ).
              createRendering(
                renderContext);
        java.awt.image.RenderedImage resRed =
          getResRed(
            hints);
        float resScale =
          getResScale(
            );
        java.awt.geom.AffineTransform residualAT;
        residualAT =
          new java.awt.geom.AffineTransform(
            usr2dev.
              getScaleX(
                ) /
              resScale,
            usr2dev.
              getShearY(
                ) /
              resScale,
            usr2dev.
              getShearX(
                ) /
              resScale,
            usr2dev.
              getScaleY(
                ) /
              resScale,
            usr2dev.
              getTranslateX(
                ),
            usr2dev.
              getTranslateY(
                ));
        return new org.apache.batik.ext.awt.image.rendered.AffineRed(
          org.apache.batik.ext.awt.image.GraphicsUtil.
            wrap(
              resRed),
          residualAT,
          hints);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Zw0ecLbmLlHRvm/mt3h3y/8Ai5mSeiMrAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "hPEBwlNfLa8C2zhC/XfeAOoreeU7wfWR");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("fdQfufMm/eYZbd/Ki3+alN4ETNo69dPcEc7feKPWfRZc1j5O645bd/ex+V+d" +
       "AfZ38+JfALDxbcD++hHYb98Joy73wS7vvFH/wxltf5AX//50o8onjPp7d8Ko" +
       "n9jH+Yn/R0b9wRlg/ygvvne6UeUTRv3+GwD7UF75FLh+eh/sT99RsAez6DPF" +
       "57NTZ03h8JbNmwpu//MMzfxZXvy3pHS/6rpHM+5pCe2SFgSuqfpHmvrRG9VU" +
       "7v6/tK+pX7ozmjq3W7Dkj396oK6HDtXVjtRwbusxUrjM3uXbK2YvPyO1dyEp" +
       "XTXsOIlsLU1MQo+C3ZfgVw6VsHfxjSohP930yr4SXrnTsbF3bwHmkTOAPpoX" +
       "DyWly+Gh+U9AfNMbgHhtH+Le23Z9d7+vB6Lyamlu7/oZbe/KiyeT0r0gzQn7" +
       "H+lzus0RvKfeALxH991478l9eE/eGXgnAv7hQw/exbftz8AGK4kLiJUz4Nfy" +
       "orxbjQm7wyH7LB87kUN2jE2jSBtHynnfG1BOcZriPaX8gMlOOdwdde8DJO9+" +
       "tWy4/z8ThUI+fIay8iM8e88mpSt6ZKqJeajqvBo7Usn7X9fxs6R07daD1vmp" +
       "0Udu+QeQ3T8t6F998crdD784/t3irPHhPxbcw5XutlLXPX4m69j9xTAyLbtQ" +
       "1z27E1phgakLZovXvOdK8s3FwUMOZa+z49JLSk+czSUpXbAPPOeg1zApPXK7" +
       "XknpPCiPU4/A9HwaNaAE5XHKCcjKJynB+MXvcToF4DmiS0oXdzfHST4KuAOS" +
       "/PZj4YFD4a99k0poYHJQ9f196s4lHzkeDcVEee3VPOawy/FT1fmgxf8SHWwl" +
       "08H+2a2vvdjpfeKH2M/tTnXrrpplOZe7udKl3QHzgmm+HX37bbkd8LrIPPPj" +
       "B75+z9MHW+cHdgIfReYx2Z48/Qg17YVJceg5+3sP/+r7f/7F3y9O8fwfuLD9" +
       "t+Q1AAA=");
}
