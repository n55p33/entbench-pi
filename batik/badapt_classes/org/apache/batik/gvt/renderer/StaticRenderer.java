package org.apache.batik.gvt.renderer;
public class StaticRenderer implements org.apache.batik.gvt.renderer.ImageRenderer {
    protected org.apache.batik.gvt.GraphicsNode rootGN;
    protected org.apache.batik.ext.awt.image.renderable.Filter rootFilter;
    protected org.apache.batik.ext.awt.image.rendered.CachableRed rootCR;
    protected java.lang.ref.SoftReference lastCR;
    protected java.lang.ref.SoftReference lastCache;
    protected boolean isDoubleBuffered = false;
    protected java.awt.image.WritableRaster currentBaseRaster;
    protected java.awt.image.WritableRaster currentRaster;
    protected java.awt.image.BufferedImage currentOffScreen;
    protected java.awt.image.WritableRaster workingBaseRaster;
    protected java.awt.image.WritableRaster workingRaster;
    protected java.awt.image.BufferedImage workingOffScreen;
    protected int offScreenWidth;
    protected int offScreenHeight;
    protected java.awt.RenderingHints renderingHints;
    protected java.awt.geom.AffineTransform usr2dev;
    protected static java.awt.RenderingHints defaultRenderingHints;
    static { defaultRenderingHints = new java.awt.RenderingHints(null);
             defaultRenderingHints.put(java.awt.RenderingHints.KEY_ANTIALIASING,
                                       java.awt.RenderingHints.
                                         VALUE_ANTIALIAS_ON);
             defaultRenderingHints.put(java.awt.RenderingHints.KEY_INTERPOLATION,
                                       java.awt.RenderingHints.
                                         VALUE_INTERPOLATION_BILINEAR);
    }
    public StaticRenderer(java.awt.RenderingHints rh, java.awt.geom.AffineTransform at) {
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
                              renderingHints = new java.awt.RenderingHints(
                                                 null);
                              renderingHints.add(defaultRenderingHints);
                              usr2dev = new java.awt.geom.AffineTransform(
                                          ); }
    public void dispose() { rootGN = null;
                            rootFilter = null;
                            rootCR = null;
                            workingOffScreen = null;
                            workingBaseRaster = null;
                            workingRaster = null;
                            currentOffScreen = null;
                            currentBaseRaster = null;
                            currentRaster = null;
                            renderingHints = null;
                            lastCache = null;
                            lastCR = null; }
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
    }
    public org.apache.batik.gvt.GraphicsNode getTree() { return rootGN;
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
    public java.awt.RenderingHints getRenderingHints() { return renderingHints;
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
    public void updateOffScreen(int width, int height) { offScreenWidth =
                                                           width;
                                                         offScreenHeight =
                                                           height;
    }
    public java.awt.image.BufferedImage getOffScreen() { if (rootGN ==
                                                               null)
                                                             return null;
                                                         return currentOffScreen;
    }
    public void clearOffScreen() { if (isDoubleBuffered)
                                       return;
                                   updateWorkingBuffers(
                                     );
                                   if (rootCR == null ||
                                         workingBaseRaster ==
                                         null) return;
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
    public void repaint(java.awt.Shape area) { if (area ==
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
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "geJlwyg7AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "s/26UGqipdEkHmpKPZghfQdHinxv1OXb");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("kLKOiqLZw3FDhQdcnaJSfbCGyPJKCuq21CJRdUhai8q0vMQ7nXREd8gBWRyW" +
       "6/I49SKGJaikDKZZusSteVVnm30o0psDNegqXZoYqu6gy8nQaLhpAH+dKuuL" +
       "9kSd4epEGfHI0p5tYngeKH6jzlnDReSzZFeO+OZGo7p2oM8NygjrlThtQai1" +
       "HAwXaEd3Z9isWscTnfCcoD5BmvKcgZhZZSwgm86yngrzOjMaVvsiJUxcMl7I" +
       "NQwvRoM1WJ7qWGIPmMVSGPsbY7oerWulIrOauzbm20tVVI0OVXTI9jxU48rC" +
       "mzU7q0Qf1KxOS05sfYy7Sg8sCmlEoYnKHDOH5U6HVJeVIuG0HALWIJ52Jhop" +
       "lJlhuemuBsBP25i1Wbqx0eVgk8K0qJp9CmqTBmoNwFI96VNqQs+lajjG9dKs" +
       "3HLqECraCVCMWRrFAt6O+MrQdxQx1ukJBxS9Qg2mKwF8j6ZStkqb1QyGLMOM" +
       "5ClaEUNmy56PV/oOtpykC36irsfQjLEosZ6m3aAyQFF6AvUtJWjVBxBRIXRb" +
       "rYxTsGLhiHRmdtZJaJdFv+Vb7nSNlqg1PsTNfhysCQYeNUFnUOXhhKqGLqHL" +
       "CkGNN2taaDqNdT3dCMCVggQ+KeLxuCFpCb92Objb1JqTUUWAu2p71RpjXl9Y" +
       "jVTMmGmCyFdWy0oC1fDRGNIqGLzBq0yrZ3Nye1zDG93FWoojRWs1ktBRgXPP" +
       "VepauA5DWRkU8U6JXKAu0oRVLrKipFfu6WqbZJBGfepIxJAeSbW+Sq3wOK0b" +
       "XZSv0wluRWqFnsgTzyYqMt4eR1VxCcsx7CzQvgjMUjkZjpsBx1h2OSyN7CqY" +
       "08tQ6rXLLtRWUwMLF7SFaXrg1SYsKjUtNOb6BtEELcUoNVxO20IXTWtrXlca" +
       "aJcDPk8x2myUQI+hpZUsa+w4bqhBCFYInM4alebCqw6aFltrtporL07ZUIOk" +
       "VRokJawS2XAfeLaqP29ofm+wDq3QVUbo1GUdZN6L+qW+3cSbpV5dgTcahFTD" +
       "CGPRiYO6kCZBEycNx0li0PgE8oIE1Wow1GgmtYCU2x7sKMt6VRfLsk4FNUee" +
       "ad3lmg9tJtWx7mziD+bLqcdPDaYVtdSmllbL2LrTdwxnAjeM7mRTtJEy01sV" +
       "DdFjY7HZDeaVNou3S7wjNjboJErGoYxW/A4iyhDR3PSVRshxE6NOUHZIYe1G" +
       "yDqkgi2LJdzqizXIxTZ4TS62SQwSYkgyDHimd+31ZoYRBPET2SPev76+R8/3" +
       "5E/ZD7bqWzaWJXz7Op4ub5NO7L/LP7cXTmzvPvKWIs+53Qp3bv+JPnT2puf8" +
       "bez+nudsY8BDp+3azzcFfOq9zzyr9X8Z2d+i8vejwl2R5/+Yra90+0jz2U68" +
       "N5++AYLJDy0cbof7nff++YPiU+Y7rmMn9MMncJ6s8p8wz/1e643qh/cKtxxs" +
       "jrviOMXxQk8e3xJ3PgDLp8AVj22Me+hAGgcbKd+9k8a7T74zOpT31d9i/ehW" +
       "X/K0q+6MPHffGWn3Z8HFqHCHNg99L9Sv+lJj5c21A407d8/1bKzMIs694jjd" +
       "7J3iR3d0P3pz6J47zDDKeV06g/Mbs+BhwDnUo2wndvbzNYf8HrkBfg9kkQ+D" +
       "69M7fp+++eIsnpGWvb08BwFqswNqhdEhtSduVHTZsZDP7Kh95qaLrphzeMsZ" +
       "/J7KAgzYRiC6K96HHhUifgNMH8wis90Xz++YPn/zhdg+I62bBSQgObsKyULx" +
       "kCR1o+KsgOuFHckXbro4Szkb8QymoyzoR4WX5yNxtwn/hCS5GyCZbQDMt3t+" +
       "dUfyqzdfku84I22aBW8D/GbH+RVKh/x+6gb4vTKLfAO4vrHj942bz88+Iy3b" +
       "rnNudpWdi1nmDxxyNG9UUZ8E11/sOP7FTVfUD+RkkjOIplkQbu3OFUyPamt0" +
       "o0yrANP5bdnt940z3TvcXZJvB/pCTulnz6D7c1nw7qhwIfY1JdKP7s46SvY9" +
       "N0A283kKjwPcD+7IPnjzVfdDZ6R9OAs+sB2ax3efHfL7+RsV5iMA6hM7fk/c" +
       "fH6fOCPt2Sz4WFS4W7V1JThNgh+/UYbA+Jzb7bU7d8VeuxsamPlvsPS4+2AH" +
       "qGAqvp6T+5UziD+XBb8EXKBA95Xt7ryjjD91o4xB+jlzx9j8oTD+sVOPRORn" +
       "1nhdjbIDcYziglVXkJP+l2d0yG9mwT87tUM+d6Mdcj+A/ou7DvnFm6/k/+GM" +
       "tC9mwb/LtqfZcWieIPb8jRIDjsO553bEnrv5kj48rPDqrPJHzmptXzVedbUj" +
       "lxn0/5L3x38+o6/+MAteOKWvvnSjffUYQP35HfrP/1BGxb1HTnaqYKU9s7e2" +
       "4OtncP5GFnz1FM7//UaXCJcAui/uOH/xejnzL+aUmDmD/30Gu+9kwTejwnng" +
       "lMR+fgomL3hI8c9vlGJm3r+yo/iVm0PxKIO/PCPtr7Lge1Hhru1TphbLnyD3" +
       "/Rsgl+8ffhPA+f0due/fdHJ7t5+RdmcWnAPjeetgjXfnB3KfMjyup3t713WQ" +
       "FUyYx/+CIDtP/cAVf3Wy/XsO9TPPXrjz/meH/zU/hX/wFxp30YU7jdi2j57s" +
       "PHJ/ux/oxjznf9f2nKefk7oQFR468zlhVLhz/zYDvrcrdy/oh6uViwq3gPBo" +
       "zmxv8cmcYHTn30fzPQAGxWG+qHD79uZolteC2kGW7PZ1/r6NObKNeHskNtma" +
       "nweOnoLOH7ve+2JCOShy9Fh/No/nf06z/7gx5nbHAz/7bJd953erv7z9WwHV" +
       "VtJsyVG4ky7csf2Hg7zS7JHlo6fWtl/X7e03/eDuX7/r8f3Hq3dvAR9q9BFs" +
       "D1/9DH/D8aP81H36r+//F2/59LN/nO+j/v/Lt8KJNUgAAA==");
}
