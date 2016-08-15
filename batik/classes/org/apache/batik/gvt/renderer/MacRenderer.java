package org.apache.batik.gvt.renderer;
public class MacRenderer implements org.apache.batik.gvt.renderer.ImageRenderer, ent.runtime.ENT_Attributable {
    public int ENT_attribute() { return org.apache.batik.apps.rasterizer.EntMode.
                                          HIGH_MODE; }
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
    protected org.apache.batik.ext.awt.geom.RectListManager
      damagedAreas;
    public static int IMAGE_TYPE = java.awt.image.BufferedImage.
                                     TYPE_INT_ARGB_PRE;
    public static java.awt.Color TRANSPARENT_WHITE = new java.awt.Color(
      255,
      255,
      255,
      0);
    protected static java.awt.RenderingHints defaultRenderingHints;
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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "OAAA");
    public ent.runtime.ENT_Attributable ENT_copy() {
        org.apache.batik.gvt.renderer.MacRenderer ENT_ld =
          new org.apache.batik.gvt.renderer.MacRenderer(
          );
        ENT_ld.
          renderingHints =
          this.
            renderingHints;
        ENT_ld.
          usr2dev =
          this.
            usr2dev;
        ENT_ld.
          rootGN =
          this.
            rootGN;
        ENT_ld.
          offScreenWidth =
          this.
            offScreenWidth;
        ENT_ld.
          offScreenHeight =
          this.
            offScreenHeight;
        ENT_ld.
          isDoubleBuffered =
          this.
            isDoubleBuffered;
        ENT_ld.
          currImg =
          this.
            currImg;
        ENT_ld.
          workImg =
          this.
            workImg;
        ENT_ld.
          damagedAreas =
          this.
            damagedAreas;
        return ENT_ld;
    }
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "qQ0j26Cot0Pll66dyv1ZLA4OdEsFPYXKvz1jOHoiCwb7fC7QDEoSV4Rxjzip" +
       "m332OsFRuc14mdv/PwHcb1wzuBcLHMryPZQDI+YVkaIFYr/FLx4oMJhTOrtN" +
       "+pvXjvqBLDazpI0t6sYpqD9/Bur4GOoHVG0qh2bAveBY+p9eEOfGrJwDg/Vt" +
       "pb3aXiG7/i8nI7nlsP2y4MDheJlhKo/t+7VDzfPBrOUxw6ztN+URJ3vz0HcH" +
       "pHjNIIHrefGwso5jzy6//08/+Pl/8povAzeyte/WZ7n7oFsNf/jbD781u/ji" +
       "9fF5OOPDrx8KdmTQqdYPITT1gNKOKb7VdG6AUvDA71EVn0b3f53hBB+hSsKN" +
       "gpFq8Z2mZdcKTF5ibaJYgv2xgdJMh/bFfED7Lk5QfIRqhjAJ08BRLXlclUai" +
       "sFihbatjK07T0KnemOdntuo3sCHtGPjAbC+Hq4XSHuI0KD5cDQf9GUy36WVf" +
       "9+1kikBMGqZ+6syLjlxelgM7hIIyFEE1qJ7Pa2WvGy1CixRcqT8fjMZTpyAv" +
       "+Gqz3g+rfa6r+hY67hdRsZnWBXqSJIVVUB9WuBYs4K4QB6S3mo3VTkDA434i" +
       "NJ1FIuI4bbYNo04Tg0jwiu1G1WLQxZBbWMqqb5hBc8FL3NiDl7MSiZedntZv" +
       "OUQy4rwWM1+mXQtfuH2loo9aXWde1qrRWGNMdhBMi10EskLYLYWktZIUZbwi" +
       "SdsPh4sxUW1JLd/mKN+c1QRL9djhQBvV20PTImDTWEi2JWAK1bUXxSbR6eeL" +
       "vUYPL2smmS4IP+aaA24xShPgN+jLXmHQ78kjrB2WeJkRK/MAbrcps+PJfkKL" +
       "FaQuY33SUNqzwOO67TyeN3RPEtrTdiI2SwIsyjoagwnVKiYK5f58nA4FAbLJ" +
       "0dKR3IlvY/piJMmjosuveIarFRdyb6rJVmLVBwtamhd01J0hehcn4pgk+2O0" +
       "LUqE7Eyo8YIQ+iuhNRtYGtxYLnSsg1VX0sSQFybejjvECmr0fVEyxCWSEqpH" +
       "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" +
       "A5MnRjAJYJi2vIAaClFGSmE1dvRJAxaY");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("cABMSQmFVxQjRBGqlORlhSZidsgZq+Fc6BlJ3m3U4mYrkeAmAky7YUAYuugE" +
       "cMxrPSV7GSp3RhoCS061toy0UEgmMdIb1WnHcoqdqD8pl5tMXam5MtQsW8kK" +
       "mkirsMDgLQ+tqlAsCRREThaJPZ03dDEPKWNvrAr1pS+D+1pFFMI8vi9SHFob" +
       "NCppmxpBU4gVPWHKi/kktbrdEqSqxY4AFypKt+rn+cqkUSmMRS0olyZpZW4E" +
       "WsOMJYWhOEsdl9ViDCOaAtU6Nc5eDqvFXr5lk0DHC4E6ZmhLgPm27MRKUC1T" +
       "aD4Ne6QMurahjovsTIVSZmoMYpFEJAEqLFRTRcbdeofUG7YfN4sRQvnNGA9J" +
       "peEPpkNO70EswlRrdNmtLs2Yq6EY3l6t4KErRHqU0LO0VFSSOG9h40KhEEIU" +
       "jQ7KITAGypw2B5UiOpUoysY0S3djx8fTuuxUhj1e10atGCKMej1mIDjfzhP9" +
       "RtOC9To8i5rlen7YLfNMseOEs5Bhk8hsAtgJlACVtPWVM/K0lRZO4f5Uy0+R" +
       "KO3G86Ji+Z1OGOlgDGynotrSxW6FSNPCXIea8161sWKCWR94Gk1hYtQTvBxK" +
       "hfFwVpBcTR9X+7hiTzt4MFc1M8Sb+c60ZstDg+1XapzushikCKKE1uooQZX8" +
       "glhjVbMuMPnyAB7kF2BMo+w5GARabuj2aBtY3E5V6dV6NBUN06k04REw6Uij" +
       "Wi8SqtIQSSaFZce3UZQt6IvAUQeWpJU0WRlyStgNU63mIV5Y5KZLCl4mBbPC" +
       "WosVSY2LU5icLaYwOyJJZgApitcJ5XxUrcyVII/XK0KSjnt2suzZE4tkPRoW" +
       "pnIoD6d6PoqrS6RfolcCPJDSETvSSrDKGLBl1eROlPdtJAmZQeCWnYIDIWWY" +
       "zw/oKEUqHb5kFtxlDfh+KsN1ZMeiepXxqFRUy3iJDBJEE1flcafrlSIqEdVu" +
       "GTIKhallmw7XmowTxizgqQLFJFyb1HGfBybaiZdSl/HcZMF0500i5HELTHZl" +
       "soDbczuRJ6wVruCpbiONcZsv5rGWhkiIrRtkpA5cH0YjrVKeW2hfV4hFJOBz" +
       "giDjYr3fZcurnq3NLagolUxyIPttkjUnFN3RjVY/VjSpPS/kgzzDTdRQyDdW" +
       "Qgtia4Uuiq5fHf/Z9T1yfvH6EfrBImrDrGUJf3gdT5U3STsLrda/23M7C2+P" +
       "vHs4slrpYHlV/uxFqes3ePvLUg9e92k2yBLagW5pe9m7FDQIPH0SBtnavWzF" +
       "yCOnLbperxb5xHs//Kza/Zni+e0SrCtB7q7Acd9gapFmHsGYrTZ83ekrY5j1" +
       "mvPDZU2/9d6/eFh4y/xd17Gi9VU7OHer/Fnmuc+Rr1V+9HzuloNFTlethj9e" +
       "6PLxpU0XPC0IPVs4tsDpkQORrddKP5y9FdyKbP0f5N5z9cKhN15ahrKvL0Mn" +
       "0J7YLNy8pNvBpaz95W37a088eendl962ueelqyQru66/58l+oHl6CoRL2Nnr" +
       "Du3dsjV5eo+iSeoK020Ql9/BX3r6Sdc9fUXfgaIdQ52lfhfcIfs/ca3dufNn" +
       "pN2aRf5NkHvRMT7rd4iHXeI717M4bx3xfw9Ar1cwvhwcV7agr+y+mTvC98SX" +
       "tk9s+u8ZJC6ekXZfFtwV5O5Qdd91fO3El0uRo6sHdM9duFG6WbqzpevcHLrn" +
       "DjM8s+b1yBmcX5UFDwHOvhZki5ezy/sP+b38Bvg9lEW+ChzRll9088X55Blp" +
       "+Sx4DFCbHVDLPXNI7fEbFV22/Or7t9S+/6aLDl1zgM/glw1J5wpB7p616Lar" +
       "aXfkV7wBkt+TRWaraD60Jfmhmy8/9Iw0PAveBPjNjvPLoYf83nyjQqyA46Nb" +
       "fh+96UJ8ak2EOYNkNwso4HAAIV61fOCoJOkbYJoNX2tX46e2TH/q5ktyfEba" +
       "27JAACRnJ5DMPXVIcnADJF+SRb4GHD+/JfnzN5+kdkZatuTg3LtOWC6WZX72" +
       "kKN8oyqbrbT7zJbjZ266yj67JrM8g+haM82Nyl7F9KjKvuDa1hdimq0e/fyW" +
       "6edvDtPzh2t41iuf3rGm9PQZdH8gC5Igd2/oqsDL6+6vVNwhu7oBspnPk3sc" +
       "HF/ckv3izVfdf3hG2vuz4Ic3lvYov9wnD/n9yI0K8xI4/mrL769uPr+PnJH2" +
       "E1nwwSB3UTE12TtNgh+6UYYv23G3bzLDf35G2k9nwceybQ9m6M93iH38Rom9" +
       "GmC8ZUvslptDbGtx1tdgvnr/kS1ECpilzcz1srFznzqD87/Mgk+ewvlnb5Qz" +
       "cHzOXdhyvnBzOR/dr3F8zszJ8XoifkX5N/2vfOHj6aef22zHmMjA1ubyp22k" +
       "v3ovf7ZX8/Ez9psebrH+JvnG5//8T4bv2J/q333QDA9ue+3pzbAvvZeetF8w" +
       "k8KvrwX1a2cI8Tez4DOnCPFXbkCI60XATwLUF7foL16vEOMX7JG/e0ba72XB" +
       "50DbbIYN0fEWwOnZjJS7vt1/vFFlBW7Puddseb7m76WDHi6/5eeyu+mcf3QG" +
       "/S9lwX8Fky9Pc+XN/qGjjP/gRhlDANt2P8e5q/Zz3BDj7PJX1xy+ega/v8iC" +
       "PzmV35/eAL/1E6dsa8XxJ07n335tT5x2n/atIxTHXW2ePB3Zw75+qrRONtVL" +
       "b75ka/Gl3dQn9vb2nrz8+ktaJJtPbHJunkUd3zYESgdz3d+JPbHgdk/Pfont" +
       "5cn3WO+0Oah7fXVixuM7W/YLHI89u+Bm28lVJTfRJxbd9fL3y+7Gn1h4uzlj" +
       "v8z28sSs2y0R+1m3lydmPbpRYT//0bis0PbB45FiN/Aw8dw3znyY+M0z0r6V" +
       "Bf8ryN25r51Zpv992IG+fl2bfIPc3Uc0N9to/tBVn37ZfK5E+YVn773zZc8O" +
       "/tv68wQHnxS5q5O7cxqa5tEtr0fOb3c9baqvW+iuzQbYdXOd+26Qe+TMp/OA" +
       "oHfk0fy576zLnT8HxoWTygW5W0B4NOetYEK5mxOMluv/o/nuCHIXDvMFuds3" +
       "J0ezXAC1gyzZ6d3uvl0/shdgs1c42Zj8h47apvWT3ftfSCIHRY5+7yBzPdYf" +
       "69l/fh/2th7Op59tse/+RvVnNt9bUEw5TbNa7uzk7th8+mFdafYO4NFTa9uv" +
       "63bqyW9f/MW7Ht93Yi5uAB9q9BFsrzr54waE5QbrzxGkv/qyX3rTv3j2S+sd" +
       "x/8fFB0QsUVJAAA=");
}
