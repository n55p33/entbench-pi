package org.apache.batik.gvt.renderer;
public class StaticRenderer implements org.apache.batik.gvt.renderer.ImageRenderer, ent.runtime.ENT_Attributable {
    public int ENT_attribute() { if (this.nodeCount >= 2000) { return org.apache.batik.apps.rasterizer.EntMode.
                                                                        HIGH_MODE;
                                 }
                                 else
                                     if (this.
                                           nodeCount >=
                                           500) {
                                         return org.apache.batik.apps.rasterizer.EntMode.
                                                  MID_MODE;
                                     }
                                     else {
                                         return org.apache.batik.apps.rasterizer.EntMode.
                                                  LOW_MODE;
                                     } }
    protected org.apache.batik.gvt.GraphicsNode
      rootGN;
    protected org.apache.batik.ext.awt.image.renderable.Filter
      rootFilter;
    protected org.apache.batik.ext.awt.image.rendered.CachableRed
      rootCR;
    protected java.lang.ref.SoftReference
      lastCR;
    protected java.lang.ref.SoftReference
      lastCache;
    protected int nodeCount;
    protected boolean isDoubleBuffered = false;
    protected java.awt.image.WritableRaster
      currentBaseRaster;
    protected java.awt.image.WritableRaster
      currentRaster;
    protected java.awt.image.BufferedImage
      currentOffScreen;
    protected java.awt.image.WritableRaster
      workingBaseRaster;
    protected java.awt.image.WritableRaster
      workingRaster;
    protected java.awt.image.BufferedImage
      workingOffScreen;
    protected int offScreenWidth;
    protected int offScreenHeight;
    protected java.awt.RenderingHints renderingHints;
    protected java.awt.geom.AffineTransform
      usr2dev;
    protected static java.awt.RenderingHints
      defaultRenderingHints;
    static { defaultRenderingHints = new java.awt.RenderingHints(
                                       null);
             defaultRenderingHints.put(java.awt.RenderingHints.
                                         KEY_ANTIALIASING,
                                       java.awt.RenderingHints.
                                         VALUE_ANTIALIAS_ON);
             defaultRenderingHints.put(java.awt.RenderingHints.
                                         KEY_INTERPOLATION,
                                       java.awt.RenderingHints.
                                         VALUE_INTERPOLATION_BILINEAR);
    }
    public StaticRenderer(java.awt.RenderingHints rh,
                          java.awt.geom.AffineTransform at) {
        super(
          );
        renderingHints =
          new java.awt.RenderingHints(
            null);
        renderingHints.
          add(
            rh);
        usr2dev =
          new java.awt.geom.AffineTransform(
            at);
    }
    public StaticRenderer() { super();
                              renderingHints =
                                new java.awt.RenderingHints(
                                  null);
                              renderingHints.
                                add(
                                  defaultRenderingHints);
                              usr2dev = new java.awt.geom.AffineTransform(
                                          );
    }
    public void dispose() { rootGN = null;
                            rootFilter = null;
                            rootCR = null;
                            workingOffScreen =
                              null;
                            workingBaseRaster =
                              null;
                            workingRaster =
                              null;
                            currentOffScreen =
                              null;
                            currentBaseRaster =
                              null;
                            currentRaster =
                              null;
                            renderingHints =
                              null;
                            lastCache = null;
                            lastCR = null;
    }
    public void setTree(org.apache.batik.gvt.GraphicsNode rootGN) {
        this.
          rootGN =
          rootGN;
        rootFilter =
          null;
        rootCR =
          null;
        workingOffScreen =
          null;
        workingRaster =
          null;
        currentOffScreen =
          null;
        currentRaster =
          null;
        this.
          nodeCount =
          this.
            countNodes(
              rootGN);
    }
    private int countNodes(org.apache.batik.gvt.GraphicsNode node) {
        int c =
          0;
        if (node instanceof org.apache.batik.gvt.CompositeGraphicsNode) {
            org.apache.batik.gvt.CompositeGraphicsNode cn =
              (org.apache.batik.gvt.CompositeGraphicsNode)
                node;
            if (cn.
                  children ==
                  null) {
                return c;
            }
            c +=
              cn.
                children.
                length;
            for (int i =
                   0;
                 i <
                   cn.
                     children.
                     length;
                 i++) {
                if (cn.
                      children[i] !=
                      null) {
                    c +=
                      this.
                        countNodes(
                          cn.
                            children[i]);
                }
            }
        }
        return c;
    }
    public org.apache.batik.gvt.GraphicsNode getTree() {
        return rootGN;
    }
    public void setRenderingHints(java.awt.RenderingHints rh) {
        renderingHints =
          new java.awt.RenderingHints(
            null);
        renderingHints.
          add(
            rh);
        rootFilter =
          null;
        rootCR =
          null;
        workingOffScreen =
          null;
        workingRaster =
          null;
        currentOffScreen =
          null;
        currentRaster =
          null;
    }
    public java.awt.RenderingHints getRenderingHints() {
        return renderingHints;
    }
    public void setTransform(java.awt.geom.AffineTransform usr2dev) {
        if (this.
              usr2dev.
              equals(
                usr2dev))
            return;
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
        rootCR =
          null;
    }
    public java.awt.geom.AffineTransform getTransform() {
        return usr2dev;
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
            currentOffScreen =
              null;
            currentBaseRaster =
              null;
            currentRaster =
              null;
        }
        else {
            currentOffScreen =
              workingOffScreen;
            currentBaseRaster =
              workingBaseRaster;
            currentRaster =
              workingRaster;
        }
    }
    public void updateOffScreen(int width,
                                int height) {
        offScreenWidth =
          width;
        offScreenHeight =
          height;
    }
    public java.awt.image.BufferedImage getOffScreen() {
        if (rootGN ==
              null)
            return null;
        return currentOffScreen;
    }
    public void clearOffScreen() { if (isDoubleBuffered)
                                       return;
                                   updateWorkingBuffers(
                                     );
                                   if (rootCR ==
                                         null ||
                                         workingBaseRaster ==
                                         null)
                                       return;
                                   java.awt.image.ColorModel cm =
                                     rootCR.
                                     getColorModel(
                                       );
                                   java.awt.image.WritableRaster syncRaster =
                                     workingBaseRaster;
                                   synchronized (syncRaster)  {
                                       java.awt.image.BufferedImage bi =
                                         new java.awt.image.BufferedImage(
                                         cm,
                                         workingBaseRaster,
                                         cm.
                                           isAlphaPremultiplied(
                                             ),
                                         null);
                                       java.awt.Graphics2D g2d =
                                         bi.
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
                                           bi.
                                             getWidth(
                                               ),
                                           bi.
                                             getHeight(
                                               ));
                                       g2d.
                                         dispose(
                                           );
                                   } }
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
    public void repaint(org.apache.batik.ext.awt.geom.RectListManager areas) {
        if (areas ==
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
              null)
            return;
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
        synchronized (syncRaster)  {
            cr.
              copyData(
                copyRaster);
        }
        if (!org.apache.batik.util.HaltingThread.
              hasBeenHalted(
                )) {
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
        }
    }
    public void flush() { if (lastCache ==
                                null) return;
                          java.lang.Object o =
                            lastCache.
                            get(
                              );
                          if (o == null) return;
                          org.apache.batik.ext.awt.image.rendered.TileCacheRed tcr =
                            (org.apache.batik.ext.awt.image.rendered.TileCacheRed)
                              o;
                          tcr.flushCache(
                                tcr.
                                  getBounds(
                                    )); }
    public void flush(java.util.Collection areas) {
        java.awt.geom.AffineTransform at =
          getTransform(
            );
        java.util.Iterator i =
          areas.
          iterator(
            );
        while (i.
                 hasNext(
                   )) {
            java.awt.Shape s =
              (java.awt.Shape)
                i.
                next(
                  );
            java.awt.Rectangle r =
              at.
              createTransformedShape(
                s).
              getBounds(
                );
            flush(
              r);
        }
    }
    public void flush(java.awt.Rectangle r) {
        if (lastCache ==
              null)
            return;
        java.lang.Object o =
          lastCache.
          get(
            );
        if (o ==
              null)
            return;
        org.apache.batik.ext.awt.image.rendered.TileCacheRed tcr =
          (org.apache.batik.ext.awt.image.rendered.TileCacheRed)
            o;
        r =
          (java.awt.Rectangle)
            r.
            clone(
              );
        r.
          x -=
          java.lang.Math.
            round(
              (float)
                usr2dev.
                getTranslateX(
                  ));
        r.
          y -=
          java.lang.Math.
            round(
              (float)
                usr2dev.
                getTranslateY(
                  ));
        tcr.
          flushCache(
            r);
    }
    protected org.apache.batik.ext.awt.image.rendered.CachableRed setupCache(org.apache.batik.ext.awt.image.rendered.CachableRed img) {
        if (lastCR ==
              null ||
              img !=
              lastCR.
              get(
                )) {
            lastCR =
              new java.lang.ref.SoftReference(
                img);
            lastCache =
              null;
        }
        java.lang.Object o =
          null;
        if (lastCache !=
              null)
            o =
              lastCache.
                get(
                  );
        if (o !=
              null)
            return (org.apache.batik.ext.awt.image.rendered.CachableRed)
                     o;
        img =
          new org.apache.batik.ext.awt.image.rendered.TileCacheRed(
            img);
        lastCache =
          new java.lang.ref.SoftReference(
            img);
        return img;
    }
    protected org.apache.batik.ext.awt.image.rendered.CachableRed renderGNR() {
        java.awt.geom.AffineTransform at;
        java.awt.geom.AffineTransform rcAT;
        at =
          usr2dev;
        rcAT =
          new java.awt.geom.AffineTransform(
            at.
              getScaleX(
                ),
            at.
              getShearY(
                ),
            at.
              getShearX(
                ),
            at.
              getScaleY(
                ),
            0,
            0);
        java.awt.image.renderable.RenderContext rc =
          new java.awt.image.renderable.RenderContext(
          rcAT,
          null,
          renderingHints);
        java.awt.image.RenderedImage ri =
          rootFilter.
          createRendering(
            rc);
        if (ri ==
              null)
            return null;
        org.apache.batik.ext.awt.image.rendered.CachableRed ret;
        ret =
          org.apache.batik.ext.awt.image.GraphicsUtil.
            wrap(
              ri);
        ret =
          setupCache(
            ret);
        int dx =
          java.lang.Math.
          round(
            (float)
              at.
              getTranslateX(
                ));
        int dy =
          java.lang.Math.
          round(
            (float)
              at.
              getTranslateY(
                ));
        ret =
          new org.apache.batik.ext.awt.image.rendered.TranslateRed(
            ret,
            ret.
              getMinX(
                ) +
              dx,
            ret.
              getMinY(
                ) +
              dy);
        ret =
          org.apache.batik.ext.awt.image.GraphicsUtil.
            convertTosRGB(
              ret);
        return ret;
    }
    protected void updateWorkingBuffers() {
        if (rootFilter ==
              null) {
            rootFilter =
              rootGN.
                getGraphicsNodeRable(
                  true);
            rootCR =
              null;
        }
        rootCR =
          renderGNR(
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
        int w =
          offScreenWidth;
        int h =
          offScreenHeight;
        int tw =
          sm.
          getWidth(
            );
        int th =
          sm.
          getHeight(
            );
        w =
          ((w +
              tw -
              1) /
             tw +
             1) *
            tw;
        h =
          ((h +
              th -
              1) /
             th +
             1) *
            th;
        if (workingBaseRaster ==
              null ||
              workingBaseRaster.
              getWidth(
                ) <
              w ||
              workingBaseRaster.
              getHeight(
                ) <
              h) {
            sm =
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
        }
        int tgx =
          -rootCR.
          getTileGridXOffset(
            );
        int tgy =
          -rootCR.
          getTileGridYOffset(
            );
        int xt;
        int yt;
        if (tgx >=
              0)
            xt =
              tgx /
                tw;
        else
            xt =
              (tgx -
                 tw +
                 1) /
                tw;
        if (tgy >=
              0)
            yt =
              tgy /
                th;
        else
            yt =
              (tgy -
                 th +
                 1) /
                th;
        int xloc =
          xt *
          tw -
          tgx;
        int yloc =
          yt *
          th -
          tgy;
        workingRaster =
          workingBaseRaster.
            createWritableChild(
              0,
              0,
              w,
              h,
              xloc,
              yloc,
              null);
        workingOffScreen =
          new java.awt.image.BufferedImage(
            rootCR.
              getColorModel(
                ),
            workingRaster.
              createWritableChild(
                0,
                0,
                offScreenWidth,
                offScreenHeight,
                0,
                0,
                null),
            rootCR.
              getColorModel(
                ).
              isAlphaPremultiplied(
                ),
            null);
        if (!isDoubleBuffered) {
            currentOffScreen =
              workingOffScreen;
            currentBaseRaster =
              workingBaseRaster;
            currentRaster =
              workingRaster;
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "PpIcyCGuiPiWxLf7+M/c/wGuIKLxKD8AAA==");
    public ent.runtime.ENT_Attributable ENT_copy() {
        org.apache.batik.gvt.renderer.StaticRenderer ENT_ld =
          new org.apache.batik.gvt.renderer.StaticRenderer(
          );
        ENT_ld.
          rootGN =
          this.
            rootGN;
        ENT_ld.
          rootFilter =
          this.
            rootFilter;
        ENT_ld.
          rootCR =
          this.
            rootCR;
        ENT_ld.
          lastCR =
          this.
            lastCR;
        ENT_ld.
          lastCache =
          this.
            lastCache;
        ENT_ld.
          nodeCount =
          this.
            nodeCount;
        ENT_ld.
          isDoubleBuffered =
          this.
            isDoubleBuffered;
        ENT_ld.
          currentBaseRaster =
          this.
            currentBaseRaster;
        ENT_ld.
          currentRaster =
          this.
            currentRaster;
        ENT_ld.
          currentOffScreen =
          this.
            currentOffScreen;
        ENT_ld.
          workingBaseRaster =
          this.
            workingBaseRaster;
        ENT_ld.
          workingRaster =
          this.
            workingRaster;
        ENT_ld.
          workingOffScreen =
          this.
            workingOffScreen;
        ENT_ld.
          offScreenWidth =
          this.
            offScreenWidth;
        ENT_ld.
          offScreenHeight =
          this.
            offScreenHeight;
        ENT_ld.
          renderingHints =
          this.
            renderingHints;
        ENT_ld.
          usr2dev =
          this.
            usr2dev;
        return ENT_ld;
    }
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "2s+9BL2/ewft3RdA+8Xr0vsO2rHes/yf2UP3728Q3evB8Z4duvdcgO7Xrwfd" +
       "/fYRrLkmbh/mvbCH7bM3iO0N4OB32PgLsH3+erA9cIxtIGmKGpwH7jduENzb" +
       "wCHvwMkXgPvt6xo478xjgiy3tIftd24Q25vBoeywKRdg++L1YLsr9L2KKOXx" +
       "SWUP1JeuH9SrstzsGa62A6VdAOq/ng/qIAcFol0/f7R5hO5VoiTzoRHQLzqA" +
       "f/iiWPMm4yvgLu+OymHjMG/gz85Hc1t2+nSW/DGQljWLN44QPaobwlNHd34s" +
       "uOaB2/CndKNx5KEfPIlqt68z9nAy140TRED3nzRG2Jby7At/8MHPff8bvwii" +
       "mWHhjk12iw3CnlM9kmH2sui7P/lDT7zsQ196IX96B/TNfufXHv/GrNW/fFG2" +
       "WfI/jqg+nlFl8sfgBPCVo/yBmyQes92LT2437JtgGzzypUHNx1pHfwS76lRb" +
       "sxi2wsWyN2nppUkDFlrzVRp7RjMajzCq19J6Q76PgZvt+qTtkU23hnKWjI4a" +
       "VUZZk1oxqcXjKYRjAh175hCBBdKKE77tDHFcXq7FRWcN1YyOUxxjQsKWOAdp" +
       "CBZX7Yk8h4haQ21YKVRtjtNRGjYoeZgsDJbkG3wDKjYgCPLA0WiMGFka0mSg" +
       "pdNpFwvjVsKXl2U/8fpSvBo6djlerKqKAStFZ+HC02qz0RCFSmXGtoqTojro" +
       "N4wla1Y5m+1By1aFUQ0P5dYG6lRnpNPSjDoxd6Z8mVZNp8dh3VE5TMmg7riu" +
       "P6/pk9WgQ/gLFwtGs1iLg/EosJ2K1lovWTHqmYIQEzLaicN6Mpyywgip9edy" +
       "rb6RGtqmbZrmhoBD4AbgZuIqTJoOSb0qOiTIns+ZMi8pg5nntZf6dLDcbErB" +
       "BO802LKnJW17LC6imjAb0LENt8kxOx1xyqKbNPSmi1Jre7rgp+2kWdFKDbo5" +
       "hta+K9narJqw6NwKBD0kJ3UxrpMMW3b9fpWU6Wl3Ja6sdmySARPwa21Si3x8" +
       "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" +
       "3jAgmaEMwKcR0jQ4nBFXHaRWm9SdaoJw");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("HTpx2DVFy0KnNTDEdVoZTXE2LHMx025MdKjERuioaIS9OGkX+7MBuKeIkAx/" +
       "zYrWTlSt9pO22lozbk9x06o9UtkW5jnzwZLT+/qMF4FBxsvZLMAmwgpZzqzl" +
       "Zmg1uaWHjHEYSmqUijhMYnTnjNNLCdaYFAd6nw5xXqpVW8X+ksKiodFMquia" +
       "xgdwOmYxZ0Yu214S9rjOBm+XWKDLFlx3q3qRIpAZ02hWa0sFSRUzrnT6Vjqb" +
       "9iiiRpa7SNiN+RYbRXpHJCa8Xp54ehmWRhoWVehin8YqCyGSRCfGamyDoWuz" +
       "WhEGJuriRGsJx4RRdMbqPKLUSTa+8aAUOuN4YHbTLkNU3BkyZ+rCPDUmWFfm" +
       "bWNIEAAbic4Dd4iQzXRCrpCmRUAaOmR0f+xhtN7sDkcLbN4pu7jRGrUxQILF" +
       "FXrUtTxEGVJxpyh1MWZEtUM2rpeXhFyWQh33yRUnlnF6bdBakUrrcdev+t21" +
       "yBiVTT2aiR7ZdsZCvzUqLnS4MiJ7UyYoUbhsb4bzCIRzlUWwnrRQOAn7LYEO" +
       "16zUx/DiXK+hQJaGGr5WjVRh4U3bw8WCBv66lvqhMA1bRYqNutFSg8rVJpus" +
       "qs1ZoIwGUKPZ8qniZFOaxXZzQk7xOPHZyVIoF8cuMhlgkpf0mNWGEafGxF3M" +
       "nMlsSXU2KISmcF3D9O5CqE5XdS/SnOlIM8VikbQ9OpHwPqxps5rfnRVLoYF5" +
       "HNs1k8FarUFGXOusi32nwyQhKTaMRBdK45aJQcNuj3MxsUGaG3M15PhB7Me4" +
       "vexNmzWx47Qgggb6QDXC951O0ucUfzlnEh8aQwEvbJQeSbQXXQUuzbxoNQcR" +
       "1saSy+sa0zO6HFGqO2gUDPVBxPTqS7nm1/SQJ7BuoOBUn4L7tTLdH/erkawa" +
       "8gSmRUQdB9DYFZF62WilxaZOcpAZM1SjEbiG6IBb5fJiATXmA1lqsE6Jn6IR" +
       "l7rVzsIMGolWTtFkRE1rKtzjm/EC1itwVEdrPbnn0SMW67urpjlOko2SLtoN" +
       "uQtBli0usaFEzXjXokXImMH2gPeUenU1FRd1srqZNeCmU043KIFAFRspUm1B" +
       "KtWmRQJSWjOdhBqGOwjH62KJ7cdtahBsJAGR+uISaQya2Tt9IsKIZeIsg5Hg" +
       "NYzasjzvs2WzSchmYMybK2nRLxrjqdFwLQ6IqHrVsIpNByfXHaI2t7jSQm61" +
       "im5Iy3NyNJFMYGRaKE6V5SZSmI0VrOyYdsskra+6ZNpw7a4erMB85koqV4Im" +
       "i3axrgmNmhl5FAjgWB8dST3gYpMNvK6qFTuc6wtIZpBNUu/Bo3So0r2QNCkY" +
       "2Yw2GDOeoKUonel223WIWU8EDr4zpNtxf9LvbfBks4o7kFnFIM7rUnV/LpOW" +
       "UoyZlRwJJZdoFOMhLA+GRrrpGrhjMYxGe0vahiHU68KTFm9Wy31PIWmn6SyF" +
       "mJInmruy2wsBrjf7YAATGp6MNk18Flq1jWykA2ZmRYQHad4G3I6YRcIIUXIh" +
       "9GtLtCcoyADveepS7TcslqTWvoKse5SDCUkHDTVKm8eE3CiOIAGK0BDDiRjv" +
       "Iq1W6x3vcAvfcuX2G3sE/1D+tuF4J4UOVAcK/tcNPGXfFu0tj8z/7izsrb4/" +
       "9bYml3zs7KrX4uVr0vNX0EdL0o/fV0sWEAmtQDOlwx45fa4VBJ62CvPlANka" +
       "jycu2nmRr+/40W//0MfF8SfKR8uM/m5QuCewna8zpI1knML4KGjprRevZRnl" +
       "G09OljT+yrf/8ePTd6rvuYHV7E/u4dxv8sdHn/w19M3CDxwUbjte4HjNlpiz" +
       "lZ49u6zxXk8KQs+anlnc+MSxyvINE49nr+92Ksv/B1eIa1chvv2qG/K+5oZ2" +
       "ID29XbR9VbOCq9n487vxl55+5up7r36TJl99OlA1//B4VdDVd77jaqVUKmXF" +
       "W0RXr9E77zj+oZe/PtdSoPqelb0ckt7Lm6vnDwcYOnhuNO72nr36/FWgJenq" +
       "+Z3AN9HHCOue7eIltkOM50ftvIu5+vwzjnPxkuLjOXNGAdmcfg3oIpM6d8nw" +
       "lScvKcu6uPLqoHDfGdXk766PZ/eVx29kjXGWceWRY9DHS6hf2IF+Yf+17Cm+" +
       "574ofnrrii4hUbyk7Ouy5M1B4S5R8x3bl859b7ixNfGE7ltulm722v5HdnR/" +
       "5NbQvXIiwOa83n4J56/PEhhw9qUg24OR/YRO+NVvgt+DR07gZ3b8fuZG+AFI" +
       "jqdtgIu4PpLoJSSz97ZXWkHhXiGbz9kyZn/PbNs3wfOxLPNJcPzSjucv3Xqz" +
       "vaxsliUkGC/lWIUF9oTaiy7RfjETrYHjcztqn7vlJlrKOTx3CT8+SzgQXgAT" +
       "vWZpxWljfdEF3Jcwzew0X7X1hR3TL9x6Ja4vKTOzRAYklXNIFkonJJWbVScM" +
       "ji/vSH75lquzkrOJLmGaZIkXFF6ee5zdNqM9Tfo3QTJb4pwvaP+rHcm/uvWa" +
       "/I5Lyr4rS74F8FPO8itUTvh9603we0WW+UYA9WBbd/v/1vL7/kvK/l6WfO85" +
       "y4Az4Q+fcHzhZg31WQD3vh3H+265oX44J/MPLiH6sSz54a3fuYbpaWv98M0y" +
       "rQNMT++YPn1rmB6cLFTLVxa+kFP6sUvo/niW/EhQeCB0RHDVPb2q8zTZf3QT" +
       "ZLPYrvAmgBvZkUVuven+s0vKPp0lP7WdmmdXrZ7w+9TNKvNqIVvwtuV3zRan" +
       "m+f37y4p+4Us+TdB4X7BkHjvIg3+7M0yzJyPt2Po3dKJmf8Gd+L3H68cZ1Te" +
       "ySPAK5+9hPh/zJJfBiGQJzn8dqvEaca/crOMQfmV794x/u6/FcZfd+Gmr3xX" +
       "Li0JQbbld8RbvCJ5OenfuWRAfjdLfvPCAflPNzsgjwLoP78bkJ+/9Ub+h5eU" +
       "fTlLfi9b6WqEvrpH7PdvlhgIHK78+o7Yr996TZ9sx3oka/zqZb0dmcYrz9tU" +
       "nkH/aj4e//OSsfqrLPmzC8bqv9/sWL0BoP6tHfrf+luZFQ+f2rsuBLylGLkv" +
       "OLjtYs4Hd2VI//oCzn9zs7cITwF0f7Dj/Ac3ypl+saBEzRk8dAm7V2TJy8Gt" +
       "LAhKQiff55dXPKZ4cN/NUszc+1d3FL96ayieZvDEJWVPZsljQeGe7YNalKT3" +
       "yL36JsjlWxGeAUHRK7d1t/9vLblnLikrZslTYD5vA6z5bt9RHlP6Z+304E03" +
       "wfOu3dzce/h6++uu7+Hr/oPvPEOwnWT7EPbs11zyJ5O5hCFefcdVS4quniPw" +
       "9OHh4TPPvu2qtOGNp7fC20ea293noGL+xHX760LB7abt08LbnAsrdOjTwh36" +
       "XMHthuUjwe2viwWz+XZGNss4V/zk8fFO/DjjXPH9m6mjWvv551a+Zm/jUe1r" +
       "Ci6rfm7VF692HGbu1TzOP7fyNbvujmpfU3BZ9XOrvni1ayDv559b+eyGsqOq" +
       "Z3Mvr7jd7XVNzW32+WZ85lHQsTmfyT234m6j1FGN3c9MdPfu4ZTwsy/9dcJB" +
       "5bLXCQf1S8qQLCkFhbuP/EvmxU7eEx6Ub+hrJeCe4azjyT6a89g137PbfoNN" +
       "+KmPP3D3ox+f/Vb+qaXj76TdQxTulkPDOP35jlPndzqeJGv5IN2z/ZhHPmIH" +
       "3xAUnrj0bSPg6J161Xjwzm29NrgUnFcvKNwG0tOSvaDw4L4kCHDy/6flBiAu" +
       "OJELCnduT06L4KB1IJKdEs5RmHVqU9b2uyfxNgJ77PSnbvKXtw+/mFKOq5z+" +
       "dlN2K5N/gfDofWRI7b4B8amPD8n3fqX+ie23owSDT9OslbuJwl3bz1jljWbv" +
       "NF9/YWtHbd05eOZr9//0PW86ev96/xbwiVGfwvbk+R9q6plOkH9aKf1Xj/7z" +
       "r/+xj38h35X2/wF9QHCeGlIAAA==");
}
