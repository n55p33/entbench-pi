package org.apache.batik.gvt.renderer;
public class MacRenderer implements org.apache.batik.gvt.renderer.ImageRenderer {
    static final int COPY_OVERHEAD = 1000;
    static final int COPY_LINE_OVERHEAD = 10;
    static final java.awt.geom.AffineTransform IDENTITY = new java.awt.geom.AffineTransform(
      );
    protected java.awt.RenderingHints renderingHints;
    protected java.awt.geom.AffineTransform usr2dev;
    protected org.apache.batik.gvt.GraphicsNode rootGN;
    protected int offScreenWidth;
    protected int offScreenHeight;
    protected boolean isDoubleBuffered;
    protected java.awt.image.BufferedImage currImg;
    protected java.awt.image.BufferedImage workImg;
    protected org.apache.batik.ext.awt.geom.RectListManager damagedAreas;
    public static int IMAGE_TYPE = java.awt.image.BufferedImage.TYPE_INT_ARGB_PRE;
    public static java.awt.Color TRANSPARENT_WHITE = new java.awt.Color(
      255,
      255,
      255,
      0);
    protected static java.awt.RenderingHints defaultRenderingHints;
    static { defaultRenderingHints = new java.awt.RenderingHints(
                                       null);
             defaultRenderingHints.put(java.awt.RenderingHints.KEY_ANTIALIASING,
                                       java.awt.RenderingHints.
                                         VALUE_ANTIALIAS_ON);
             defaultRenderingHints.put(java.awt.RenderingHints.KEY_INTERPOLATION,
                                       java.awt.RenderingHints.
                                         VALUE_INTERPOLATION_BILINEAR);
    }
    public MacRenderer() { super();
                           renderingHints = new java.awt.RenderingHints(
                                              null);
                           renderingHints.add(defaultRenderingHints);
                           usr2dev = new java.awt.geom.AffineTransform(
                                       ); }
    public MacRenderer(java.awt.RenderingHints rh, java.awt.geom.AffineTransform at) {
        super(
          );
        renderingHints =
          new java.awt.RenderingHints(
            null);
        renderingHints.
          add(
            rh);
        if (at ==
              null)
            at =
              new java.awt.geom.AffineTransform(
                );
        else
            at =
              new java.awt.geom.AffineTransform(
                at);
    }
    public void dispose() { rootGN = null;
                            currImg = null;
                            workImg = null;
                            renderingHints = null;
                            usr2dev = null;
                            if (damagedAreas != null) {
                                damagedAreas.
                                  clear(
                                    );
                            }
                            damagedAreas = null; }
    public void setTree(org.apache.batik.gvt.GraphicsNode treeRoot) {
        rootGN =
          treeRoot;
    }
    public org.apache.batik.gvt.GraphicsNode getTree() {
        return rootGN;
    }
    public void setTransform(java.awt.geom.AffineTransform usr2dev) {
        if (usr2dev ==
              null)
            this.
              usr2dev =
              new java.awt.geom.AffineTransform(
                );
        else
            this.
              usr2dev =
              new java.awt.geom.AffineTransform(
                usr2dev);
        if (workImg ==
              null)
            return;
        synchronized (workImg)  {
            java.awt.Graphics2D g2d =
              workImg.
              createGraphics(
                );
            g2d.
              setComposite(
                java.awt.AlphaComposite.
                  Clear);
            g2d.
              fillRect(
                0,
                0,
                workImg.
                  getWidth(
                    ),
                workImg.
                  getHeight(
                    ));
            g2d.
              dispose(
                );
        }
        damagedAreas =
          null;
    }
    public java.awt.geom.AffineTransform getTransform() {
        return usr2dev;
    }
    public void setRenderingHints(java.awt.RenderingHints rh) {
        this.
          renderingHints =
          new java.awt.RenderingHints(
            null);
        this.
          renderingHints.
          add(
            rh);
        damagedAreas =
          null;
    }
    public java.awt.RenderingHints getRenderingHints() {
        return renderingHints;
    }
    public boolean isDoubleBuffered() { return isDoubleBuffered;
    }
    public void setDoubleBuffered(boolean isDoubleBuffered) {
        if (this.
              isDoubleBuffered ==
              isDoubleBuffered)
            return;
        this.
          isDoubleBuffered =
          isDoubleBuffered;
        if (isDoubleBuffered) {
            workImg =
              null;
        }
        else {
            workImg =
              currImg;
            damagedAreas =
              null;
        }
    }
    public void updateOffScreen(int width, int height) {
        offScreenWidth =
          width;
        offScreenHeight =
          height;
    }
    public java.awt.image.BufferedImage getOffScreen() {
        if (rootGN ==
              null)
            return null;
        return currImg;
    }
    public void clearOffScreen() { if (isDoubleBuffered)
                                       return;
                                   updateWorkingBuffers(
                                     );
                                   if (workImg ==
                                         null) return;
                                   synchronized (workImg)  {
                                       java.awt.Graphics2D g2d =
                                         workImg.
                                         createGraphics(
                                           );
                                       g2d.
                                         setComposite(
                                           java.awt.AlphaComposite.
                                             Clear);
                                       g2d.
                                         fillRect(
                                           0,
                                           0,
                                           workImg.
                                             getWidth(
                                               ),
                                           workImg.
                                             getHeight(
                                               ));
                                       g2d.
                                         dispose(
                                           );
                                   }
                                   damagedAreas =
                                     null; }
    public void flush() {  }
    public void flush(java.awt.Rectangle r) {  }
    public void flush(java.util.Collection areas) {
        
    }
    protected void updateWorkingBuffers() { if (rootGN ==
                                                  null) {
                                                currImg =
                                                  null;
                                                workImg =
                                                  null;
                                                return;
                                            }
                                            int w =
                                              offScreenWidth;
                                            int h =
                                              offScreenHeight;
                                            if (workImg ==
                                                  null ||
                                                  workImg.
                                                  getWidth(
                                                    ) <
                                                  w ||
                                                  workImg.
                                                  getHeight(
                                                    ) <
                                                  h) {
                                                workImg =
                                                  new java.awt.image.BufferedImage(
                                                    w,
                                                    h,
                                                    IMAGE_TYPE);
                                            }
                                            if (!isDoubleBuffered) {
                                                currImg =
                                                  workImg;
                                            }
    }
    public void repaint(java.awt.Shape area) {
        if (area ==
              null)
            return;
        org.apache.batik.ext.awt.geom.RectListManager rlm =
          new org.apache.batik.ext.awt.geom.RectListManager(
          );
        rlm.
          add(
            usr2dev.
              createTransformedShape(
                area).
              getBounds(
                ));
        repaint(
          rlm);
    }
    public void repaint(org.apache.batik.ext.awt.geom.RectListManager devRLM) {
        if (devRLM ==
              null)
            return;
        updateWorkingBuffers(
          );
        if (rootGN ==
              null ||
              workImg ==
              null)
            return;
        try {
            synchronized (workImg)  {
                java.awt.Graphics2D g2d =
                  org.apache.batik.ext.awt.image.GraphicsUtil.
                  createGraphics(
                    workImg,
                    renderingHints);
                java.awt.Rectangle dr;
                dr =
                  new java.awt.Rectangle(
                    0,
                    0,
                    offScreenWidth,
                    offScreenHeight);
                if (isDoubleBuffered &&
                      currImg !=
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
                    java.util.Iterator iter =
                      damagedAreas.
                      iterator(
                        );
                    g2d.
                      setComposite(
                        java.awt.AlphaComposite.
                          Src);
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
                        g2d.
                          setClip(
                            r.
                              x,
                            r.
                              y,
                            r.
                              width,
                            r.
                              height);
                        g2d.
                          setComposite(
                            java.awt.AlphaComposite.
                              Clear);
                        g2d.
                          fillRect(
                            r.
                              x,
                            r.
                              y,
                            r.
                              width,
                            r.
                              height);
                        g2d.
                          setComposite(
                            java.awt.AlphaComposite.
                              SrcOver);
                        g2d.
                          drawImage(
                            currImg,
                            0,
                            0,
                            null);
                    }
                }
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
                    g2d.
                      setTransform(
                        IDENTITY);
                    g2d.
                      setClip(
                        r.
                          x,
                        r.
                          y,
                        r.
                          width,
                        r.
                          height);
                    g2d.
                      setComposite(
                        java.awt.AlphaComposite.
                          Clear);
                    g2d.
                      fillRect(
                        r.
                          x,
                        r.
                          y,
                        r.
                          width,
                        r.
                          height);
                    g2d.
                      setComposite(
                        java.awt.AlphaComposite.
                          SrcOver);
                    g2d.
                      transform(
                        usr2dev);
                    rootGN.
                      paint(
                        g2d);
                }
                g2d.
                  dispose(
                    );
            }
        }
        catch (java.lang.Throwable t) {
            t.
              printStackTrace(
                );
        }
        if (org.apache.batik.util.HaltingThread.
              hasBeenHalted(
                ))
            return;
        if (isDoubleBuffered) {
            java.awt.image.BufferedImage tmpImg =
              workImg;
            workImg =
              currImg;
            currImg =
              tmpImg;
            damagedAreas =
              devRLM;
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "PGSNVOvVenSXguaK0KphdrE/7bQr5npN");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
