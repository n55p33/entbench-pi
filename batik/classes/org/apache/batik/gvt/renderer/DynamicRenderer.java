package org.apache.batik.gvt.renderer;
public class DynamicRenderer extends org.apache.batik.gvt.renderer.StaticRenderer {
    static final int COPY_OVERHEAD = 1000;
    static final int COPY_LINE_OVERHEAD = 10;
    public DynamicRenderer() { super(); }
    public DynamicRenderer(java.awt.RenderingHints rh, java.awt.geom.AffineTransform at) {
        super(
          rh,
          at);
    }
    org.apache.batik.ext.awt.geom.RectListManager damagedAreas;
    protected org.apache.batik.ext.awt.image.rendered.CachableRed setupCache(org.apache.batik.ext.awt.image.rendered.CachableRed img) {
        return img;
    }
    public void flush(java.awt.Rectangle r) { return; }
    public void flush(java.util.Collection areas) { return;
    }
    protected void updateWorkingBuffers() { if (rootFilter ==
                                                  null) {
                                                rootFilter =
                                                  rootGN.
                                                    getGraphicsNodeRable(
                                                      true);
                                                rootCR =
                                                  null;
                                            }
                                            rootCR = renderGNR(
                                                       );
                                            if (rootCR ==
                                                  null) {
                                                workingRaster =
                                                  null;
                                                workingOffScreen =
                                                  null;
                                                workingBaseRaster =
                                                  null;
                                                currentOffScreen =
                                                  null;
                                                currentBaseRaster =
                                                  null;
                                                currentRaster =
                                                  null;
                                                return;
                                            }
                                            java.awt.image.SampleModel sm =
                                              rootCR.
                                              getSampleModel(
                                                );
                                            int w = offScreenWidth;
                                            int h = offScreenHeight;
                                            if (workingBaseRaster ==
                                                  null ||
                                                  workingBaseRaster.
                                                  getWidth(
                                                    ) <
                                                  w ||
                                                  workingBaseRaster.
                                                  getHeight(
                                                    ) <
                                                  h) { sm =
                                                         sm.
                                                           createCompatibleSampleModel(
                                                             w,
                                                             h);
                                                       workingBaseRaster =
                                                         java.awt.image.Raster.
                                                           createWritableRaster(
                                                             sm,
                                                             new java.awt.Point(
                                                               0,
                                                               0));
                                                       workingRaster =
                                                         workingBaseRaster.
                                                           createWritableChild(
                                                             0,
                                                             0,
                                                             w,
                                                             h,
                                                             0,
                                                             0,
                                                             null);
                                                       workingOffScreen =
                                                         new java.awt.image.BufferedImage(
                                                           rootCR.
                                                             getColorModel(
                                                               ),
                                                           workingRaster,
                                                           rootCR.
                                                             getColorModel(
                                                               ).
                                                             isAlphaPremultiplied(
                                                               ),
                                                           null);
                                            }
                                            if (!isDoubleBuffered) {
                                                currentOffScreen =
                                                  workingOffScreen;
                                                currentBaseRaster =
                                                  workingBaseRaster;
                                                currentRaster =
                                                  workingRaster;
                                            }
    }
    public void repaint(org.apache.batik.ext.awt.geom.RectListManager devRLM) {
        if (devRLM ==
              null)
            return;
        org.apache.batik.ext.awt.image.rendered.CachableRed cr;
        java.awt.image.WritableRaster syncRaster;
        java.awt.image.WritableRaster copyRaster;
        updateWorkingBuffers(
          );
        if (rootCR ==
              null ||
              workingBaseRaster ==
              null) {
            return;
        }
        cr =
          rootCR;
        syncRaster =
          workingBaseRaster;
        copyRaster =
          workingRaster;
        java.awt.Rectangle srcR =
          rootCR.
          getBounds(
            );
        java.awt.Rectangle dstR =
          workingRaster.
          getBounds(
            );
        if (dstR.
              x <
              srcR.
                x ||
              dstR.
                y <
              srcR.
                y ||
              dstR.
                x +
              dstR.
                width >
              srcR.
                x +
              srcR.
                width ||
              dstR.
                y +
              dstR.
                height >
              srcR.
                y +
              srcR.
                height)
            cr =
              new org.apache.batik.ext.awt.image.rendered.PadRed(
                cr,
                dstR,
                org.apache.batik.ext.awt.image.PadMode.
                  ZERO_PAD,
                null);
        boolean repaintAll =
          false;
        java.awt.Rectangle dr =
          copyRaster.
          getBounds(
            );
        synchronized (syncRaster)  {
            if (repaintAll) {
                cr.
                  copyData(
                    copyRaster);
            }
            else {
                java.awt.Graphics2D g2d =
                  null;
                if (false) {
                    java.awt.image.BufferedImage tmpBI =
                      new java.awt.image.BufferedImage(
                      workingOffScreen.
                        getColorModel(
                          ),
                      copyRaster.
                        createWritableTranslatedChild(
                          0,
                          0),
                      workingOffScreen.
                        isAlphaPremultiplied(
                          ),
                      null);
                    g2d =
                      org.apache.batik.ext.awt.image.GraphicsUtil.
                        createGraphics(
                          tmpBI);
                    g2d.
                      translate(
                        -copyRaster.
                          getMinX(
                            ),
                        -copyRaster.
                          getMinY(
                            ));
                }
                if (isDoubleBuffered &&
                      currentRaster !=
                      null &&
                      damagedAreas !=
                      null) {
                    damagedAreas.
                      subtract(
                        devRLM,
                        COPY_OVERHEAD,
                        COPY_LINE_OVERHEAD);
                    damagedAreas.
                      mergeRects(
                        COPY_OVERHEAD,
                        COPY_LINE_OVERHEAD);
                    java.awt.Color fillColor =
                      new java.awt.Color(
                      0,
                      0,
                      255,
                      50);
                    java.awt.Color borderColor =
                      new java.awt.Color(
                      0,
                      0,
                      0,
                      50);
                    java.util.Iterator iter =
                      damagedAreas.
                      iterator(
                        );
                    while (iter.
                             hasNext(
                               )) {
                        java.awt.Rectangle r =
                          (java.awt.Rectangle)
                            iter.
                            next(
                              );
                        if (!dr.
                              intersects(
                                r))
                            continue;
                        r =
                          dr.
                            intersection(
                              r);
                        java.awt.image.Raster src =
                          currentRaster.
                          createWritableChild(
                            r.
                              x,
                            r.
                              y,
                            r.
                              width,
                            r.
                              height,
                            r.
                              x,
                            r.
                              y,
                            null);
                        org.apache.batik.ext.awt.image.GraphicsUtil.
                          copyData(
                            src,
                            copyRaster);
                        if (g2d !=
                              null) {
                            g2d.
                              setPaint(
                                fillColor);
                            g2d.
                              fill(
                                r);
                            g2d.
                              setPaint(
                                borderColor);
                            g2d.
                              draw(
                                r);
                        }
                    }
                }
                java.awt.Color fillColor =
                  new java.awt.Color(
                  255,
                  0,
                  0,
                  50);
                java.awt.Color borderColor =
                  new java.awt.Color(
                  0,
                  0,
                  0,
                  50);
                java.util.Iterator iter =
                  devRLM.
                  iterator(
                    );
                while (iter.
                         hasNext(
                           )) {
                    java.awt.Rectangle r =
                      (java.awt.Rectangle)
                        iter.
                        next(
                          );
                    if (!dr.
                          intersects(
                            r))
                        continue;
                    r =
                      dr.
                        intersection(
                          r);
                    java.awt.image.WritableRaster dst =
                      copyRaster.
                      createWritableChild(
                        r.
                          x,
                        r.
                          y,
                        r.
                          width,
                        r.
                          height,
                        r.
                          x,
                        r.
                          y,
                        null);
                    cr.
                      copyData(
                        dst);
                    if (g2d !=
                          null) {
                        g2d.
                          setPaint(
                            fillColor);
                        g2d.
                          fill(
                            r);
                        g2d.
                          setPaint(
                            borderColor);
                        g2d.
                          draw(
                            r);
                    }
                }
            }
        }
        if (org.apache.batik.util.HaltingThread.
              hasBeenHalted(
                ))
            return;
        java.awt.image.BufferedImage tmpBI =
          workingOffScreen;
        workingBaseRaster =
          currentBaseRaster;
        workingRaster =
          currentRaster;
        workingOffScreen =
          currentOffScreen;
        currentRaster =
          copyRaster;
        currentBaseRaster =
          syncRaster;
        currentOffScreen =
          tmpBI;
        damagedAreas =
          devRLM;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Tf8BarvAg60hAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "5U/pUujKvnKW5C/A6ICkrP5ldByLb7/7");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("Ga79Uc9jxRaXzmcTJxZ75BtZ7EwC8pZzOLM7onr8is9GR3D26RcH3Pd8rf1T" +
       "+5NFmqdud4nS/Qx03/6Q00ma8PQdRzse6wr97Ncf+vkH3nqMWA/tGT518zO8" +
       "vfn2x3hIkL3vDt5sf/mNn/mun37xC7u99f8HlhetoTssAAA=");
}
