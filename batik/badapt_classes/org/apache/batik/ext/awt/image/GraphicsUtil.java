package org.apache.batik.ext.awt.image;
public class GraphicsUtil {
    public static java.awt.geom.AffineTransform IDENTITY = new java.awt.geom.AffineTransform(
      );
    public static void drawImage(java.awt.Graphics2D g2d, java.awt.image.RenderedImage ri) {
        drawImage(
          g2d,
          wrap(
            ri));
    }
    public static void drawImage(java.awt.Graphics2D g2d,
                                 org.apache.batik.ext.awt.image.rendered.CachableRed cr) {
        java.awt.geom.AffineTransform at =
          null;
        while (true) {
            if (cr instanceof org.apache.batik.ext.awt.image.rendered.AffineRed) {
                org.apache.batik.ext.awt.image.rendered.AffineRed ar =
                  (org.apache.batik.ext.awt.image.rendered.AffineRed)
                    cr;
                if (at ==
                      null)
                    at =
                      ar.
                        getTransform(
                          );
                else
                    at.
                      concatenate(
                        ar.
                          getTransform(
                            ));
                cr =
                  ar.
                    getSource(
                      );
                continue;
            }
            else
                if (cr instanceof org.apache.batik.ext.awt.image.rendered.TranslateRed) {
                    org.apache.batik.ext.awt.image.rendered.TranslateRed tr =
                      (org.apache.batik.ext.awt.image.rendered.TranslateRed)
                        cr;
                    int dx =
                      tr.
                      getDeltaX(
                        );
                    int dy =
                      tr.
                      getDeltaY(
                        );
                    if (at ==
                          null)
                        at =
                          java.awt.geom.AffineTransform.
                            getTranslateInstance(
                              dx,
                              dy);
                    else
                        at.
                          translate(
                            dx,
                            dy);
                    cr =
                      tr.
                        getSource(
                          );
                    continue;
                }
            break;
        }
        java.awt.geom.AffineTransform g2dAt =
          g2d.
          getTransform(
            );
        if (at ==
              null ||
              at.
              isIdentity(
                ))
            at =
              g2dAt;
        else
            at.
              preConcatenate(
                g2dAt);
        java.awt.image.ColorModel srcCM =
          cr.
          getColorModel(
            );
        java.awt.image.ColorModel g2dCM =
          getDestinationColorModel(
            g2d);
        java.awt.color.ColorSpace g2dCS =
          null;
        if (g2dCM !=
              null)
            g2dCS =
              g2dCM.
                getColorSpace(
                  );
        if (g2dCS ==
              null)
            g2dCS =
              java.awt.color.ColorSpace.
                getInstance(
                  java.awt.color.ColorSpace.
                    CS_sRGB);
        java.awt.image.ColorModel drawCM =
          g2dCM;
        if (g2dCM ==
              null ||
              !g2dCM.
              hasAlpha(
                )) {
            drawCM =
              sRGB_Unpre;
        }
        if (cr instanceof org.apache.batik.ext.awt.image.rendered.BufferedImageCachableRed) {
            if (g2dCS.
                  equals(
                    srcCM.
                      getColorSpace(
                        )) &&
                  drawCM.
                  equals(
                    srcCM)) {
                g2d.
                  setTransform(
                    at);
                org.apache.batik.ext.awt.image.rendered.BufferedImageCachableRed bicr;
                bicr =
                  (org.apache.batik.ext.awt.image.rendered.BufferedImageCachableRed)
                    cr;
                g2d.
                  drawImage(
                    bicr.
                      getBufferedImage(
                        ),
                    bicr.
                      getMinX(
                        ),
                    bicr.
                      getMinY(
                        ),
                    null);
                g2d.
                  setTransform(
                    g2dAt);
                return;
            }
        }
        double determinant =
          at.
          getDeterminant(
            );
        if (!at.
              isIdentity(
                ) &&
              determinant <=
              1.0) {
            if (at.
                  getType(
                    ) !=
                  java.awt.geom.AffineTransform.
                    TYPE_TRANSLATION)
                cr =
                  new org.apache.batik.ext.awt.image.rendered.AffineRed(
                    cr,
                    at,
                    g2d.
                      getRenderingHints(
                        ));
            else {
                int xloc =
                  cr.
                  getMinX(
                    ) +
                  (int)
                    at.
                    getTranslateX(
                      );
                int yloc =
                  cr.
                  getMinY(
                    ) +
                  (int)
                    at.
                    getTranslateY(
                      );
                cr =
                  new org.apache.batik.ext.awt.image.rendered.TranslateRed(
                    cr,
                    xloc,
                    yloc);
            }
        }
        if (g2dCS !=
              srcCM.
              getColorSpace(
                )) {
            if (g2dCS ==
                  java.awt.color.ColorSpace.
                  getInstance(
                    java.awt.color.ColorSpace.
                      CS_sRGB))
                cr =
                  convertTosRGB(
                    cr);
            else
                if (g2dCS ==
                      java.awt.color.ColorSpace.
                      getInstance(
                        java.awt.color.ColorSpace.
                          CS_LINEAR_RGB))
                    cr =
                      convertToLsRGB(
                        cr);
        }
        srcCM =
          cr.
            getColorModel(
              );
        if (!drawCM.
              equals(
                srcCM))
            cr =
              org.apache.batik.ext.awt.image.rendered.FormatRed.
                construct(
                  cr,
                  drawCM);
        if (!at.
              isIdentity(
                ) &&
              determinant >
              1.0)
            cr =
              new org.apache.batik.ext.awt.image.rendered.AffineRed(
                cr,
                at,
                g2d.
                  getRenderingHints(
                    ));
        g2d.
          setTransform(
            IDENTITY);
        java.awt.Composite g2dComposite =
          g2d.
          getComposite(
            );
        if (g2d.
              getRenderingHint(
                org.apache.batik.ext.awt.RenderingHintsKeyExt.
                  KEY_TRANSCODING) ==
              org.apache.batik.ext.awt.RenderingHintsKeyExt.
                VALUE_TRANSCODING_PRINTING) {
            if (org.apache.batik.ext.awt.image.SVGComposite.
                  OVER.
                  equals(
                    g2dComposite)) {
                g2d.
                  setComposite(
                    org.apache.batik.ext.awt.image.SVGComposite.
                      OVER);
            }
        }
        java.awt.Rectangle crR =
          cr.
          getBounds(
            );
        java.awt.Shape clip =
          g2d.
          getClip(
            );
        try {
            java.awt.Rectangle clipR;
            if (clip ==
                  null) {
                clip =
                  crR;
                clipR =
                  crR;
            }
            else {
                clipR =
                  clip.
                    getBounds(
                      );
                if (!clipR.
                      intersects(
                        crR))
                    return;
                clipR =
                  clipR.
                    intersection(
                      crR);
            }
            java.awt.Rectangle gcR =
              getDestinationBounds(
                g2d);
            if (gcR !=
                  null) {
                if (!clipR.
                      intersects(
                        gcR))
                    return;
                clipR =
                  clipR.
                    intersection(
                      gcR);
            }
            boolean useDrawRenderedImage =
              false;
            srcCM =
              cr.
                getColorModel(
                  );
            java.awt.image.SampleModel srcSM =
              cr.
              getSampleModel(
                );
            if (srcSM.
                  getWidth(
                    ) *
                  srcSM.
                  getHeight(
                    ) >=
                  clipR.
                    width *
                  clipR.
                    height)
                useDrawRenderedImage =
                  true;
            java.lang.Object atpHint =
              g2d.
              getRenderingHint(
                org.apache.batik.ext.awt.RenderingHintsKeyExt.
                  KEY_AVOID_TILE_PAINTING);
            if (atpHint ==
                  org.apache.batik.ext.awt.RenderingHintsKeyExt.
                    VALUE_AVOID_TILE_PAINTING_ON)
                useDrawRenderedImage =
                  true;
            if (atpHint ==
                  org.apache.batik.ext.awt.RenderingHintsKeyExt.
                    VALUE_AVOID_TILE_PAINTING_OFF)
                useDrawRenderedImage =
                  false;
            java.awt.image.WritableRaster wr;
            if (useDrawRenderedImage) {
                java.awt.image.Raster r =
                  cr.
                  getData(
                    clipR);
                wr =
                  ((java.awt.image.WritableRaster)
                     r).
                    createWritableChild(
                      clipR.
                        x,
                      clipR.
                        y,
                      clipR.
                        width,
                      clipR.
                        height,
                      0,
                      0,
                      null);
                java.awt.image.BufferedImage bi =
                  new java.awt.image.BufferedImage(
                  srcCM,
                  wr,
                  srcCM.
                    isAlphaPremultiplied(
                      ),
                  null);
                g2d.
                  drawImage(
                    bi,
                    clipR.
                      x,
                    clipR.
                      y,
                    null);
            }
            else {
                wr =
                  java.awt.image.Raster.
                    createWritableRaster(
                      srcSM,
                      new java.awt.Point(
                        0,
                        0));
                java.awt.image.BufferedImage bi =
                  new java.awt.image.BufferedImage(
                  srcCM,
                  wr,
                  srcCM.
                    isAlphaPremultiplied(
                      ),
                  null);
                int xt0 =
                  cr.
                  getMinTileX(
                    );
                int xt1 =
                  xt0 +
                  cr.
                  getNumXTiles(
                    );
                int yt0 =
                  cr.
                  getMinTileY(
                    );
                int yt1 =
                  yt0 +
                  cr.
                  getNumYTiles(
                    );
                int tw =
                  srcSM.
                  getWidth(
                    );
                int th =
                  srcSM.
                  getHeight(
                    );
                java.awt.Rectangle tR =
                  new java.awt.Rectangle(
                  0,
                  0,
                  tw,
                  th);
                java.awt.Rectangle iR =
                  new java.awt.Rectangle(
                  0,
                  0,
                  0,
                  0);
                if (false) {
                    java.lang.System.
                      err.
                      println(
                        "SrcCM: " +
                        srcCM);
                    java.lang.System.
                      err.
                      println(
                        "CR: " +
                        cr);
                    java.lang.System.
                      err.
                      println(
                        "CRR: " +
                        crR +
                        " TG: [" +
                        xt0 +
                        ',' +
                        yt0 +
                        ',' +
                        xt1 +
                        ',' +
                        yt1 +
                        "] Off: " +
                        cr.
                          getTileGridXOffset(
                            ) +
                        ',' +
                        cr.
                          getTileGridYOffset(
                            ));
                }
                int yloc =
                  yt0 *
                  th +
                  cr.
                  getTileGridYOffset(
                    );
                int skip =
                  (clipR.
                     y -
                     yloc) /
                  th;
                if (skip <
                      0)
                    skip =
                      0;
                yt0 +=
                  skip;
                int xloc =
                  xt0 *
                  tw +
                  cr.
                  getTileGridXOffset(
                    );
                skip =
                  (clipR.
                     x -
                     xloc) /
                    tw;
                if (skip <
                      0)
                    skip =
                      0;
                xt0 +=
                  skip;
                int endX =
                  clipR.
                    x +
                  clipR.
                    width -
                  1;
                int endY =
                  clipR.
                    y +
                  clipR.
                    height -
                  1;
                if (false) {
                    java.lang.System.
                      out.
                      println(
                        "clipR: " +
                        clipR +
                        " TG: [" +
                        xt0 +
                        ',' +
                        yt0 +
                        ',' +
                        xt1 +
                        ',' +
                        yt1 +
                        "] Off: " +
                        cr.
                          getTileGridXOffset(
                            ) +
                        ',' +
                        cr.
                          getTileGridYOffset(
                            ));
                }
                yloc =
                  yt0 *
                    th +
                    cr.
                    getTileGridYOffset(
                      );
                int minX =
                  xt0 *
                  tw +
                  cr.
                  getTileGridXOffset(
                    );
                int xStep =
                  tw;
                xloc =
                  minX;
                for (int y =
                       yt0;
                     y <
                       yt1;
                     y++,
                       yloc +=
                         th) {
                    if (yloc >
                          endY)
                        break;
                    for (int x =
                           xt0;
                         x <
                           xt1;
                         x++,
                           xloc +=
                             xStep) {
                        if (xloc <
                              minX ||
                              xloc >
                              endX)
                            break;
                        tR.
                          x =
                          xloc;
                        tR.
                          y =
                          yloc;
                        java.awt.geom.Rectangle2D.
                          intersect(
                            crR,
                            tR,
                            iR);
                        java.awt.image.WritableRaster twr;
                        twr =
                          wr.
                            createWritableChild(
                              0,
                              0,
                              iR.
                                width,
                              iR.
                                height,
                              iR.
                                x,
                              iR.
                                y,
                              null);
                        cr.
                          copyData(
                            twr);
                        java.awt.image.BufferedImage subBI;
                        subBI =
                          bi.
                            getSubimage(
                              0,
                              0,
                              iR.
                                width,
                              iR.
                                height);
                        if (false) {
                            java.lang.System.
                              out.
                              println(
                                "Drawing: " +
                                tR);
                            java.lang.System.
                              out.
                              println(
                                "IR: " +
                                iR);
                        }
                        g2d.
                          drawImage(
                            subBI,
                            iR.
                              x,
                            iR.
                              y,
                            null);
                    }
                    xStep =
                      -xStep;
                    xloc +=
                      xStep;
                }
            }
        }
        finally {
            g2d.
              setTransform(
                g2dAt);
            g2d.
              setComposite(
                g2dComposite);
        }
    }
    public static void drawImage(java.awt.Graphics2D g2d,
                                 java.awt.image.renderable.RenderableImage filter,
                                 java.awt.image.renderable.RenderContext rc) {
        java.awt.geom.AffineTransform origDev =
          g2d.
          getTransform(
            );
        java.awt.Shape origClip =
          g2d.
          getClip(
            );
        java.awt.RenderingHints origRH =
          g2d.
          getRenderingHints(
            );
        java.awt.Shape clip =
          rc.
          getAreaOfInterest(
            );
        if (clip !=
              null)
            g2d.
              clip(
                clip);
        g2d.
          transform(
            rc.
              getTransform(
                ));
        g2d.
          setRenderingHints(
            rc.
              getRenderingHints(
                ));
        drawImage(
          g2d,
          filter);
        g2d.
          setTransform(
            origDev);
        g2d.
          setClip(
            origClip);
        g2d.
          setRenderingHints(
            origRH);
    }
    public static void drawImage(java.awt.Graphics2D g2d,
                                 java.awt.image.renderable.RenderableImage filter) {
        if (filter instanceof org.apache.batik.ext.awt.image.renderable.PaintRable) {
            org.apache.batik.ext.awt.image.renderable.PaintRable pr =
              (org.apache.batik.ext.awt.image.renderable.PaintRable)
                filter;
            if (pr.
                  paintRable(
                    g2d))
                return;
        }
        java.awt.geom.AffineTransform at =
          g2d.
          getTransform(
            );
        java.awt.image.RenderedImage ri =
          filter.
          createRendering(
            new java.awt.image.renderable.RenderContext(
              at,
              g2d.
                getClip(
                  ),
              g2d.
                getRenderingHints(
                  )));
        if (ri ==
              null)
            return;
        g2d.
          setTransform(
            IDENTITY);
        drawImage(
          g2d,
          org.apache.batik.ext.awt.image.GraphicsUtil.
            wrap(
              ri));
        g2d.
          setTransform(
            at);
    }
    public static java.awt.Graphics2D createGraphics(java.awt.image.BufferedImage bi,
                                                     java.awt.RenderingHints hints) {
        java.awt.Graphics2D g2d =
          bi.
          createGraphics(
            );
        if (hints !=
              null)
            g2d.
              addRenderingHints(
                hints);
        g2d.
          setRenderingHint(
            org.apache.batik.ext.awt.RenderingHintsKeyExt.
              KEY_BUFFERED_IMAGE,
            new java.lang.ref.WeakReference(
              bi));
        g2d.
          clip(
            new java.awt.Rectangle(
              0,
              0,
              bi.
                getWidth(
                  ),
              bi.
                getHeight(
                  )));
        return g2d;
    }
    public static java.awt.Graphics2D createGraphics(java.awt.image.BufferedImage bi) {
        java.awt.Graphics2D g2d =
          bi.
          createGraphics(
            );
        g2d.
          setRenderingHint(
            org.apache.batik.ext.awt.RenderingHintsKeyExt.
              KEY_BUFFERED_IMAGE,
            new java.lang.ref.WeakReference(
              bi));
        g2d.
          clip(
            new java.awt.Rectangle(
              0,
              0,
              bi.
                getWidth(
                  ),
              bi.
                getHeight(
                  )));
        return g2d;
    }
    public static final boolean WARN_DESTINATION;
    static { boolean warn = true;
             try { java.lang.String s = java.lang.System.
                     getProperty(
                       "org.apache.batik.warn_destination",
                       "true");
                   warn = java.lang.Boolean.
                            valueOf(
                              s).
                            booleanValue(
                              ); }
             catch (java.lang.SecurityException se) {
                 
             }
             catch (java.lang.NumberFormatException nfe) {
                 
             }
             finally { WARN_DESTINATION =
                         warn; } }
    public static java.awt.image.BufferedImage getDestination(java.awt.Graphics2D g2d) {
        java.lang.Object o =
          g2d.
          getRenderingHint(
            org.apache.batik.ext.awt.RenderingHintsKeyExt.
              KEY_BUFFERED_IMAGE);
        if (o !=
              null)
            return (java.awt.image.BufferedImage)
                     ((java.lang.ref.Reference)
                        o).
                     get(
                       );
        java.awt.GraphicsConfiguration gc =
          g2d.
          getDeviceConfiguration(
            );
        if (gc ==
              null) {
            return null;
        }
        java.awt.GraphicsDevice gd =
          gc.
          getDevice(
            );
        if (WARN_DESTINATION &&
              gd.
              getType(
                ) ==
              java.awt.GraphicsDevice.
                TYPE_IMAGE_BUFFER &&
              g2d.
              getRenderingHint(
                org.apache.batik.ext.awt.RenderingHintsKeyExt.
                  KEY_TRANSCODING) !=
              org.apache.batik.ext.awt.RenderingHintsKeyExt.
                VALUE_TRANSCODING_PRINTING)
            java.lang.System.
              err.
              println(
                "Graphics2D from BufferedImage lacks BUFFERED_IMAGE hint");
        return null;
    }
    public static java.awt.image.ColorModel getDestinationColorModel(java.awt.Graphics2D g2d) {
        java.awt.image.BufferedImage bi =
          getDestination(
            g2d);
        if (bi !=
              null) {
            return bi.
              getColorModel(
                );
        }
        java.awt.GraphicsConfiguration gc =
          g2d.
          getDeviceConfiguration(
            );
        if (gc ==
              null) {
            return null;
        }
        if (gc.
              getDevice(
                ).
              getType(
                ) ==
              java.awt.GraphicsDevice.
                TYPE_IMAGE_BUFFER) {
            if (g2d.
                  getRenderingHint(
                    org.apache.batik.ext.awt.RenderingHintsKeyExt.
                      KEY_TRANSCODING) ==
                  org.apache.batik.ext.awt.RenderingHintsKeyExt.
                    VALUE_TRANSCODING_PRINTING)
                return sRGB_Unpre;
            return null;
        }
        return gc.
          getColorModel(
            );
    }
    public static java.awt.color.ColorSpace getDestinationColorSpace(java.awt.Graphics2D g2d) {
        java.awt.image.ColorModel cm =
          getDestinationColorModel(
            g2d);
        if (cm !=
              null)
            return cm.
              getColorSpace(
                );
        return null;
    }
    public static java.awt.Rectangle getDestinationBounds(java.awt.Graphics2D g2d) {
        java.awt.image.BufferedImage bi =
          getDestination(
            g2d);
        if (bi !=
              null) {
            return new java.awt.Rectangle(
              0,
              0,
              bi.
                getWidth(
                  ),
              bi.
                getHeight(
                  ));
        }
        java.awt.GraphicsConfiguration gc =
          g2d.
          getDeviceConfiguration(
            );
        if (gc ==
              null) {
            return null;
        }
        if (gc.
              getDevice(
                ).
              getType(
                ) ==
              java.awt.GraphicsDevice.
                TYPE_IMAGE_BUFFER) {
            return null;
        }
        return null;
    }
    public static final java.awt.image.ColorModel
      Linear_sRGB =
      new java.awt.image.DirectColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_LINEAR_RGB),
      24,
      16711680,
      65280,
      255,
      0,
      false,
      java.awt.image.DataBuffer.
        TYPE_INT);
    public static final java.awt.image.ColorModel
      Linear_sRGB_Pre =
      new java.awt.image.DirectColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_LINEAR_RGB),
      32,
      16711680,
      65280,
      255,
      -16777216,
      true,
      java.awt.image.DataBuffer.
        TYPE_INT);
    public static final java.awt.image.ColorModel
      Linear_sRGB_Unpre =
      new java.awt.image.DirectColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_LINEAR_RGB),
      32,
      16711680,
      65280,
      255,
      -16777216,
      false,
      java.awt.image.DataBuffer.
        TYPE_INT);
    public static final java.awt.image.ColorModel
      sRGB =
      new java.awt.image.DirectColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_sRGB),
      24,
      16711680,
      65280,
      255,
      0,
      false,
      java.awt.image.DataBuffer.
        TYPE_INT);
    public static final java.awt.image.ColorModel
      sRGB_Pre =
      new java.awt.image.DirectColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_sRGB),
      32,
      16711680,
      65280,
      255,
      -16777216,
      true,
      java.awt.image.DataBuffer.
        TYPE_INT);
    public static final java.awt.image.ColorModel
      sRGB_Unpre =
      new java.awt.image.DirectColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_sRGB),
      32,
      16711680,
      65280,
      255,
      -16777216,
      false,
      java.awt.image.DataBuffer.
        TYPE_INT);
    public static java.awt.image.ColorModel makeLinear_sRGBCM(boolean premult) {
        return premult
          ? Linear_sRGB_Pre
          : Linear_sRGB_Unpre;
    }
    public static java.awt.image.BufferedImage makeLinearBufferedImage(int width,
                                                                       int height,
                                                                       boolean premult) {
        java.awt.image.ColorModel cm =
          makeLinear_sRGBCM(
            premult);
        java.awt.image.WritableRaster wr =
          cm.
          createCompatibleWritableRaster(
            width,
            height);
        return new java.awt.image.BufferedImage(
          cm,
          wr,
          premult,
          null);
    }
    public static org.apache.batik.ext.awt.image.rendered.CachableRed convertToLsRGB(org.apache.batik.ext.awt.image.rendered.CachableRed src) {
        java.awt.image.ColorModel cm =
          src.
          getColorModel(
            );
        java.awt.color.ColorSpace cs =
          cm.
          getColorSpace(
            );
        if (cs ==
              java.awt.color.ColorSpace.
              getInstance(
                java.awt.color.ColorSpace.
                  CS_LINEAR_RGB))
            return src;
        return new org.apache.batik.ext.awt.image.rendered.Any2LsRGBRed(
          src);
    }
    public static org.apache.batik.ext.awt.image.rendered.CachableRed convertTosRGB(org.apache.batik.ext.awt.image.rendered.CachableRed src) {
        java.awt.image.ColorModel cm =
          src.
          getColorModel(
            );
        java.awt.color.ColorSpace cs =
          cm.
          getColorSpace(
            );
        if (cs ==
              java.awt.color.ColorSpace.
              getInstance(
                java.awt.color.ColorSpace.
                  CS_sRGB))
            return src;
        return new org.apache.batik.ext.awt.image.rendered.Any2sRGBRed(
          src);
    }
    public static org.apache.batik.ext.awt.image.rendered.CachableRed wrap(java.awt.image.RenderedImage ri) {
        if (ri instanceof org.apache.batik.ext.awt.image.rendered.CachableRed)
            return (org.apache.batik.ext.awt.image.rendered.CachableRed)
                     ri;
        if (ri instanceof java.awt.image.BufferedImage)
            return new org.apache.batik.ext.awt.image.rendered.BufferedImageCachableRed(
              (java.awt.image.BufferedImage)
                ri);
        return new org.apache.batik.ext.awt.image.rendered.RenderedImageCachableRed(
          ri);
    }
    public static void copyData_INT_PACK(java.awt.image.Raster src,
                                         java.awt.image.WritableRaster dst) {
        int x0 =
          dst.
          getMinX(
            );
        if (x0 <
              src.
              getMinX(
                ))
            x0 =
              src.
                getMinX(
                  );
        int y0 =
          dst.
          getMinY(
            );
        if (y0 <
              src.
              getMinY(
                ))
            y0 =
              src.
                getMinY(
                  );
        int x1 =
          dst.
          getMinX(
            ) +
          dst.
          getWidth(
            ) -
          1;
        if (x1 >
              src.
              getMinX(
                ) +
              src.
              getWidth(
                ) -
              1)
            x1 =
              src.
                getMinX(
                  ) +
                src.
                getWidth(
                  ) -
                1;
        int y1 =
          dst.
          getMinY(
            ) +
          dst.
          getHeight(
            ) -
          1;
        if (y1 >
              src.
              getMinY(
                ) +
              src.
              getHeight(
                ) -
              1)
            y1 =
              src.
                getMinY(
                  ) +
                src.
                getHeight(
                  ) -
                1;
        int width =
          x1 -
          x0 +
          1;
        int height =
          y1 -
          y0 +
          1;
        java.awt.image.SinglePixelPackedSampleModel srcSPPSM;
        srcSPPSM =
          (java.awt.image.SinglePixelPackedSampleModel)
            src.
            getSampleModel(
              );
        final int srcScanStride =
          srcSPPSM.
          getScanlineStride(
            );
        java.awt.image.DataBufferInt srcDB =
          (java.awt.image.DataBufferInt)
            src.
            getDataBuffer(
              );
        final int[] srcPixels =
          srcDB.
          getBankData(
            )[0];
        final int srcBase =
          srcDB.
          getOffset(
            ) +
          srcSPPSM.
          getOffset(
            x0 -
              src.
              getSampleModelTranslateX(
                ),
            y0 -
              src.
              getSampleModelTranslateY(
                ));
        java.awt.image.SinglePixelPackedSampleModel dstSPPSM;
        dstSPPSM =
          (java.awt.image.SinglePixelPackedSampleModel)
            dst.
            getSampleModel(
              );
        final int dstScanStride =
          dstSPPSM.
          getScanlineStride(
            );
        java.awt.image.DataBufferInt dstDB =
          (java.awt.image.DataBufferInt)
            dst.
            getDataBuffer(
              );
        final int[] dstPixels =
          dstDB.
          getBankData(
            )[0];
        final int dstBase =
          dstDB.
          getOffset(
            ) +
          dstSPPSM.
          getOffset(
            x0 -
              dst.
              getSampleModelTranslateX(
                ),
            y0 -
              dst.
              getSampleModelTranslateY(
                ));
        if (srcScanStride ==
              dstScanStride &&
              srcScanStride ==
              width) {
            java.lang.System.
              arraycopy(
                srcPixels,
                srcBase,
                dstPixels,
                dstBase,
                width *
                  height);
        }
        else
            if (width >
                  128) {
                int srcSP =
                  srcBase;
                int dstSP =
                  dstBase;
                for (int y =
                       0;
                     y <
                       height;
                     y++) {
                    java.lang.System.
                      arraycopy(
                        srcPixels,
                        srcSP,
                        dstPixels,
                        dstSP,
                        width);
                    srcSP +=
                      srcScanStride;
                    dstSP +=
                      dstScanStride;
                }
            }
            else {
                for (int y =
                       0;
                     y <
                       height;
                     y++) {
                    int srcSP =
                      srcBase +
                      y *
                      srcScanStride;
                    int dstSP =
                      dstBase +
                      y *
                      dstScanStride;
                    for (int x =
                           0;
                         x <
                           width;
                         x++)
                        dstPixels[dstSP++] =
                          srcPixels[srcSP++];
                }
            }
    }
    public static void copyData_FALLBACK(java.awt.image.Raster src,
                                         java.awt.image.WritableRaster dst) {
        int x0 =
          dst.
          getMinX(
            );
        if (x0 <
              src.
              getMinX(
                ))
            x0 =
              src.
                getMinX(
                  );
        int y0 =
          dst.
          getMinY(
            );
        if (y0 <
              src.
              getMinY(
                ))
            y0 =
              src.
                getMinY(
                  );
        int x1 =
          dst.
          getMinX(
            ) +
          dst.
          getWidth(
            ) -
          1;
        if (x1 >
              src.
              getMinX(
                ) +
              src.
              getWidth(
                ) -
              1)
            x1 =
              src.
                getMinX(
                  ) +
                src.
                getWidth(
                  ) -
                1;
        int y1 =
          dst.
          getMinY(
            ) +
          dst.
          getHeight(
            ) -
          1;
        if (y1 >
              src.
              getMinY(
                ) +
              src.
              getHeight(
                ) -
              1)
            y1 =
              src.
                getMinY(
                  ) +
                src.
                getHeight(
                  ) -
                1;
        int width =
          x1 -
          x0 +
          1;
        int[] data =
          null;
        for (int y =
               y0;
             y <=
               y1;
             y++) {
            data =
              src.
                getPixels(
                  x0,
                  y,
                  width,
                  1,
                  data);
            dst.
              setPixels(
                x0,
                y,
                width,
                1,
                data);
        }
    }
    public static void copyData(java.awt.image.Raster src,
                                java.awt.image.WritableRaster dst) {
        if (is_INT_PACK_Data(
              src.
                getSampleModel(
                  ),
              false) &&
              is_INT_PACK_Data(
                dst.
                  getSampleModel(
                    ),
                false)) {
            copyData_INT_PACK(
              src,
              dst);
            return;
        }
        copyData_FALLBACK(
          src,
          dst);
    }
    public static java.awt.image.WritableRaster copyRaster(java.awt.image.Raster ras) {
        return copyRaster(
                 ras,
                 ras.
                   getMinX(
                     ),
                 ras.
                   getMinY(
                     ));
    }
    public static java.awt.image.WritableRaster copyRaster(java.awt.image.Raster ras,
                                                           int minX,
                                                           int minY) {
        java.awt.image.WritableRaster ret =
          java.awt.image.Raster.
          createWritableRaster(
            ras.
              getSampleModel(
                ),
            new java.awt.Point(
              0,
              0));
        ret =
          ret.
            createWritableChild(
              ras.
                getMinX(
                  ) -
                ras.
                getSampleModelTranslateX(
                  ),
              ras.
                getMinY(
                  ) -
                ras.
                getSampleModelTranslateY(
                  ),
              ras.
                getWidth(
                  ),
              ras.
                getHeight(
                  ),
              minX,
              minY,
              null);
        java.awt.image.DataBuffer srcDB =
          ras.
          getDataBuffer(
            );
        java.awt.image.DataBuffer retDB =
          ret.
          getDataBuffer(
            );
        if (srcDB.
              getDataType(
                ) !=
              retDB.
              getDataType(
                )) {
            throw new java.lang.IllegalArgumentException(
              "New DataBuffer doesn\'t match original");
        }
        int len =
          srcDB.
          getSize(
            );
        int banks =
          srcDB.
          getNumBanks(
            );
        int[] offsets =
          srcDB.
          getOffsets(
            );
        for (int b =
               0;
             b <
               banks;
             b++) {
            switch (srcDB.
                      getDataType(
                        )) {
                case java.awt.image.DataBuffer.
                       TYPE_BYTE:
                    {
                        java.awt.image.DataBufferByte srcDBT =
                          (java.awt.image.DataBufferByte)
                            srcDB;
                        java.awt.image.DataBufferByte retDBT =
                          (java.awt.image.DataBufferByte)
                            retDB;
                        java.lang.System.
                          arraycopy(
                            srcDBT.
                              getData(
                                b),
                            offsets[b],
                            retDBT.
                              getData(
                                b),
                            offsets[b],
                            len);
                        break;
                    }
                case java.awt.image.DataBuffer.
                       TYPE_INT:
                    {
                        java.awt.image.DataBufferInt srcDBT =
                          (java.awt.image.DataBufferInt)
                            srcDB;
                        java.awt.image.DataBufferInt retDBT =
                          (java.awt.image.DataBufferInt)
                            retDB;
                        java.lang.System.
                          arraycopy(
                            srcDBT.
                              getData(
                                b),
                            offsets[b],
                            retDBT.
                              getData(
                                b),
                            offsets[b],
                            len);
                        break;
                    }
                case java.awt.image.DataBuffer.
                       TYPE_SHORT:
                    {
                        java.awt.image.DataBufferShort srcDBT =
                          (java.awt.image.DataBufferShort)
                            srcDB;
                        java.awt.image.DataBufferShort retDBT =
                          (java.awt.image.DataBufferShort)
                            retDB;
                        java.lang.System.
                          arraycopy(
                            srcDBT.
                              getData(
                                b),
                            offsets[b],
                            retDBT.
                              getData(
                                b),
                            offsets[b],
                            len);
                        break;
                    }
                case java.awt.image.DataBuffer.
                       TYPE_USHORT:
                    {
                        java.awt.image.DataBufferUShort srcDBT =
                          (java.awt.image.DataBufferUShort)
                            srcDB;
                        java.awt.image.DataBufferUShort retDBT =
                          (java.awt.image.DataBufferUShort)
                            retDB;
                        java.lang.System.
                          arraycopy(
                            srcDBT.
                              getData(
                                b),
                            offsets[b],
                            retDBT.
                              getData(
                                b),
                            offsets[b],
                            len);
                        break;
                    }
            }
        }
        return ret;
    }
    public static java.awt.image.WritableRaster makeRasterWritable(java.awt.image.Raster ras) {
        return makeRasterWritable(
                 ras,
                 ras.
                   getMinX(
                     ),
                 ras.
                   getMinY(
                     ));
    }
    public static java.awt.image.WritableRaster makeRasterWritable(java.awt.image.Raster ras,
                                                                   int minX,
                                                                   int minY) {
        java.awt.image.WritableRaster ret =
          java.awt.image.Raster.
          createWritableRaster(
            ras.
              getSampleModel(
                ),
            ras.
              getDataBuffer(
                ),
            new java.awt.Point(
              0,
              0));
        ret =
          ret.
            createWritableChild(
              ras.
                getMinX(
                  ) -
                ras.
                getSampleModelTranslateX(
                  ),
              ras.
                getMinY(
                  ) -
                ras.
                getSampleModelTranslateY(
                  ),
              ras.
                getWidth(
                  ),
              ras.
                getHeight(
                  ),
              minX,
              minY,
              null);
        return ret;
    }
    public static java.awt.image.ColorModel coerceColorModel(java.awt.image.ColorModel cm,
                                                             boolean newAlphaPreMult) {
        if (cm.
              isAlphaPremultiplied(
                ) ==
              newAlphaPreMult)
            return cm;
        java.awt.image.WritableRaster wr =
          cm.
          createCompatibleWritableRaster(
            1,
            1);
        return cm.
          coerceData(
            wr,
            newAlphaPreMult);
    }
    public static java.awt.image.ColorModel coerceData(java.awt.image.WritableRaster wr,
                                                       java.awt.image.ColorModel cm,
                                                       boolean newAlphaPreMult) {
        if (!cm.
              hasAlpha(
                ))
            return cm;
        if (cm.
              isAlphaPremultiplied(
                ) ==
              newAlphaPreMult)
            return cm;
        if (newAlphaPreMult) {
            multiplyAlpha(
              wr);
        }
        else {
            divideAlpha(
              wr);
        }
        return coerceColorModel(
                 cm,
                 newAlphaPreMult);
    }
    public static void multiplyAlpha(java.awt.image.WritableRaster wr) {
        if (is_BYTE_COMP_Data(
              wr.
                getSampleModel(
                  )))
            mult_BYTE_COMP_Data(
              wr);
        else
            if (is_INT_PACK_Data(
                  wr.
                    getSampleModel(
                      ),
                  true))
                mult_INT_PACK_Data(
                  wr);
            else {
                int[] pixel =
                  null;
                int bands =
                  wr.
                  getNumBands(
                    );
                float norm =
                  1.0F /
                  255.0F;
                int x0;
                int x1;
                int y0;
                int y1;
                int a;
                int b;
                float alpha;
                x0 =
                  wr.
                    getMinX(
                      );
                x1 =
                  x0 +
                    wr.
                    getWidth(
                      );
                y0 =
                  wr.
                    getMinY(
                      );
                y1 =
                  y0 +
                    wr.
                    getHeight(
                      );
                for (int y =
                       y0;
                     y <
                       y1;
                     y++)
                    for (int x =
                           x0;
                         x <
                           x1;
                         x++) {
                        pixel =
                          wr.
                            getPixel(
                              x,
                              y,
                              pixel);
                        a =
                          pixel[bands -
                                  1];
                        if (a >=
                              0 &&
                              a <
                              255) {
                            alpha =
                              a *
                                norm;
                            for (b =
                                   0;
                                 b <
                                   bands -
                                   1;
                                 b++)
                                pixel[b] =
                                  (int)
                                    (pixel[b] *
                                       alpha +
                                       0.5F);
                            wr.
                              setPixel(
                                x,
                                y,
                                pixel);
                        }
                    }
            }
    }
    public static void divideAlpha(java.awt.image.WritableRaster wr) {
        if (is_BYTE_COMP_Data(
              wr.
                getSampleModel(
                  )))
            divide_BYTE_COMP_Data(
              wr);
        else
            if (is_INT_PACK_Data(
                  wr.
                    getSampleModel(
                      ),
                  true))
                divide_INT_PACK_Data(
                  wr);
            else {
                int x0;
                int x1;
                int y0;
                int y1;
                int a;
                int b;
                float ialpha;
                int bands =
                  wr.
                  getNumBands(
                    );
                int[] pixel =
                  null;
                x0 =
                  wr.
                    getMinX(
                      );
                x1 =
                  x0 +
                    wr.
                    getWidth(
                      );
                y0 =
                  wr.
                    getMinY(
                      );
                y1 =
                  y0 +
                    wr.
                    getHeight(
                      );
                for (int y =
                       y0;
                     y <
                       y1;
                     y++)
                    for (int x =
                           x0;
                         x <
                           x1;
                         x++) {
                        pixel =
                          wr.
                            getPixel(
                              x,
                              y,
                              pixel);
                        a =
                          pixel[bands -
                                  1];
                        if (a >
                              0 &&
                              a <
                              255) {
                            ialpha =
                              255 /
                                (float)
                                  a;
                            for (b =
                                   0;
                                 b <
                                   bands -
                                   1;
                                 b++)
                                pixel[b] =
                                  (int)
                                    (pixel[b] *
                                       ialpha +
                                       0.5F);
                            wr.
                              setPixel(
                                x,
                                y,
                                pixel);
                        }
                    }
            }
    }
    public static void copyData(java.awt.image.BufferedImage src,
                                java.awt.image.BufferedImage dst) {
        java.awt.Rectangle srcRect =
          new java.awt.Rectangle(
          0,
          0,
          src.
            getWidth(
              ),
          src.
            getHeight(
              ));
        copyData(
          src,
          srcRect,
          dst,
          new java.awt.Point(
            0,
            0));
    }
    public static void copyData(java.awt.image.BufferedImage src,
                                java.awt.Rectangle srcRect,
                                java.awt.image.BufferedImage dst,
                                java.awt.Point destP) {
        boolean srcAlpha =
          src.
          getColorModel(
            ).
          hasAlpha(
            );
        boolean dstAlpha =
          dst.
          getColorModel(
            ).
          hasAlpha(
            );
        if (srcAlpha ==
              dstAlpha)
            if (!srcAlpha ||
                  src.
                  isAlphaPremultiplied(
                    ) ==
                  dst.
                  isAlphaPremultiplied(
                    )) {
                copyData(
                  src.
                    getRaster(
                      ),
                  dst.
                    getRaster(
                      ));
                return;
            }
        int[] pixel =
          null;
        java.awt.image.Raster srcR =
          src.
          getRaster(
            );
        java.awt.image.WritableRaster dstR =
          dst.
          getRaster(
            );
        int bands =
          dstR.
          getNumBands(
            );
        int dx =
          destP.
            x -
          srcRect.
            x;
        int dy =
          destP.
            y -
          srcRect.
            y;
        int w =
          srcRect.
            width;
        int x0 =
          srcRect.
            x;
        int y0 =
          srcRect.
            y;
        int y1 =
          y0 +
          srcRect.
            height -
          1;
        if (!srcAlpha) {
            int[] oPix =
              new int[bands *
                        w];
            int out =
              w *
              bands -
              1;
            while (out >=
                     0) {
                oPix[out] =
                  255;
                out -=
                  bands;
            }
            int b;
            int in;
            for (int y =
                   y0;
                 y <=
                   y1;
                 y++) {
                pixel =
                  srcR.
                    getPixels(
                      x0,
                      y,
                      w,
                      1,
                      pixel);
                in =
                  w *
                    (bands -
                       1) -
                    1;
                out =
                  w *
                    bands -
                    2;
                switch (bands) {
                    case 4:
                        while (in >=
                                 0) {
                            oPix[out--] =
                              pixel[in--];
                            oPix[out--] =
                              pixel[in--];
                            oPix[out--] =
                              pixel[in--];
                            out--;
                        }
                        break;
                    default:
                        while (in >=
                                 0) {
                            for (b =
                                   0;
                                 b <
                                   bands -
                                   1;
                                 b++)
                                oPix[out--] =
                                  pixel[in--];
                            out--;
                        }
                }
                dstR.
                  setPixels(
                    x0 +
                      dx,
                    y +
                      dy,
                    w,
                    1,
                    oPix);
            }
        }
        else
            if (dstAlpha &&
                  dst.
                  isAlphaPremultiplied(
                    )) {
                int a;
                int b;
                int alpha;
                int in;
                int fpNorm =
                  (1 <<
                     24) /
                  255;
                int pt5 =
                  1 <<
                  23;
                for (int y =
                       y0;
                     y <=
                       y1;
                     y++) {
                    pixel =
                      srcR.
                        getPixels(
                          x0,
                          y,
                          w,
                          1,
                          pixel);
                    in =
                      bands *
                        w -
                        1;
                    switch (bands) {
                        case 4:
                            while (in >=
                                     0) {
                                a =
                                  pixel[in];
                                if (a ==
                                      255)
                                    in -=
                                      4;
                                else {
                                    in--;
                                    alpha =
                                      fpNorm *
                                        a;
                                    pixel[in] =
                                      pixel[in] *
                                        alpha +
                                        pt5 >>>
                                        24;
                                    in--;
                                    pixel[in] =
                                      pixel[in] *
                                        alpha +
                                        pt5 >>>
                                        24;
                                    in--;
                                    pixel[in] =
                                      pixel[in] *
                                        alpha +
                                        pt5 >>>
                                        24;
                                    in--;
                                }
                            }
                            break;
                        default:
                            while (in >=
                                     0) {
                                a =
                                  pixel[in];
                                if (a ==
                                      255)
                                    in -=
                                      bands;
                                else {
                                    in--;
                                    alpha =
                                      fpNorm *
                                        a;
                                    for (b =
                                           0;
                                         b <
                                           bands -
                                           1;
                                         b++) {
                                        pixel[in] =
                                          pixel[in] *
                                            alpha +
                                            pt5 >>>
                                            24;
                                        in--;
                                    }
                                }
                            }
                    }
                    dstR.
                      setPixels(
                        x0 +
                          dx,
                        y +
                          dy,
                        w,
                        1,
                        pixel);
                }
            }
            else
                if (dstAlpha &&
                      !dst.
                      isAlphaPremultiplied(
                        )) {
                    int a;
                    int b;
                    int ialpha;
                    int in;
                    int fpNorm =
                      16711680;
                    int pt5 =
                      1 <<
                      15;
                    for (int y =
                           y0;
                         y <=
                           y1;
                         y++) {
                        pixel =
                          srcR.
                            getPixels(
                              x0,
                              y,
                              w,
                              1,
                              pixel);
                        in =
                          bands *
                            w -
                            1;
                        switch (bands) {
                            case 4:
                                while (in >=
                                         0) {
                                    a =
                                      pixel[in];
                                    if (a <=
                                          0 ||
                                          a >=
                                          255)
                                        in -=
                                          4;
                                    else {
                                        in--;
                                        ialpha =
                                          fpNorm /
                                            a;
                                        pixel[in] =
                                          pixel[in] *
                                            ialpha +
                                            pt5 >>>
                                            16;
                                        in--;
                                        pixel[in] =
                                          pixel[in] *
                                            ialpha +
                                            pt5 >>>
                                            16;
                                        in--;
                                        pixel[in] =
                                          pixel[in] *
                                            ialpha +
                                            pt5 >>>
                                            16;
                                        in--;
                                    }
                                }
                                break;
                            default:
                                while (in >=
                                         0) {
                                    a =
                                      pixel[in];
                                    if (a <=
                                          0 ||
                                          a >=
                                          255)
                                        in -=
                                          bands;
                                    else {
                                        in--;
                                        ialpha =
                                          fpNorm /
                                            a;
                                        for (b =
                                               0;
                                             b <
                                               bands -
                                               1;
                                             b++) {
                                            pixel[in] =
                                              pixel[in] *
                                                ialpha +
                                                pt5 >>>
                                                16;
                                            in--;
                                        }
                                    }
                                }
                        }
                        dstR.
                          setPixels(
                            x0 +
                              dx,
                            y +
                              dy,
                            w,
                            1,
                            pixel);
                    }
                }
                else
                    if (src.
                          isAlphaPremultiplied(
                            )) {
                        int[] oPix =
                          new int[bands *
                                    w];
                        int a;
                        int b;
                        int ialpha;
                        int in;
                        int out;
                        int fpNorm =
                          16711680;
                        int pt5 =
                          1 <<
                          15;
                        for (int y =
                               y0;
                             y <=
                               y1;
                             y++) {
                            pixel =
                              srcR.
                                getPixels(
                                  x0,
                                  y,
                                  w,
                                  1,
                                  pixel);
                            in =
                              (bands +
                                 1) *
                                w -
                                1;
                            out =
                              bands *
                                w -
                                1;
                            while (in >=
                                     0) {
                                a =
                                  pixel[in];
                                in--;
                                if (a >
                                      0) {
                                    if (a <
                                          255) {
                                        ialpha =
                                          fpNorm /
                                            a;
                                        for (b =
                                               0;
                                             b <
                                               bands;
                                             b++)
                                            oPix[out--] =
                                              pixel[in--] *
                                                ialpha +
                                                pt5 >>>
                                                16;
                                    }
                                    else
                                        for (b =
                                               0;
                                             b <
                                               bands;
                                             b++)
                                            oPix[out--] =
                                              pixel[in--];
                                }
                                else {
                                    in -=
                                      bands;
                                    for (b =
                                           0;
                                         b <
                                           bands;
                                         b++)
                                        oPix[out--] =
                                          255;
                                }
                            }
                            dstR.
                              setPixels(
                                x0 +
                                  dx,
                                y +
                                  dy,
                                w,
                                1,
                                oPix);
                        }
                    }
                    else {
                        java.awt.Rectangle dstRect =
                          new java.awt.Rectangle(
                          destP.
                            x,
                          destP.
                            y,
                          srcRect.
                            width,
                          srcRect.
                            height);
                        for (int b =
                               0;
                             b <
                               bands;
                             b++)
                            copyBand(
                              srcR,
                              srcRect,
                              b,
                              dstR,
                              dstRect,
                              b);
                    }
    }
    public static void copyBand(java.awt.image.Raster src,
                                int srcBand,
                                java.awt.image.WritableRaster dst,
                                int dstBand) {
        java.awt.Rectangle sR =
          src.
          getBounds(
            );
        java.awt.Rectangle dR =
          dst.
          getBounds(
            );
        java.awt.Rectangle cpR =
          sR.
          intersection(
            dR);
        copyBand(
          src,
          cpR,
          srcBand,
          dst,
          cpR,
          dstBand);
    }
    public static void copyBand(java.awt.image.Raster src,
                                java.awt.Rectangle sR,
                                int sBand,
                                java.awt.image.WritableRaster dst,
                                java.awt.Rectangle dR,
                                int dBand) {
        int dy =
          dR.
            y -
          sR.
            y;
        int dx =
          dR.
            x -
          sR.
            x;
        sR =
          sR.
            intersection(
              src.
                getBounds(
                  ));
        dR =
          dR.
            intersection(
              dst.
                getBounds(
                  ));
        int width;
        int height;
        if (dR.
              width <
              sR.
                width)
            width =
              dR.
                width;
        else
            width =
              sR.
                width;
        if (dR.
              height <
              sR.
                height)
            height =
              dR.
                height;
        else
            height =
              sR.
                height;
        int x =
          sR.
            x +
          dx;
        int[] samples =
          null;
        for (int y =
               sR.
                 y;
             y <
               sR.
                 y +
               height;
             y++) {
            samples =
              src.
                getSamples(
                  sR.
                    x,
                  y,
                  width,
                  1,
                  sBand,
                  samples);
            dst.
              setSamples(
                x,
                y +
                  dy,
                width,
                1,
                dBand,
                samples);
        }
    }
    public static boolean is_INT_PACK_Data(java.awt.image.SampleModel sm,
                                           boolean requireAlpha) {
        if (!(sm instanceof java.awt.image.SinglePixelPackedSampleModel))
            return false;
        if (sm.
              getDataType(
                ) !=
              java.awt.image.DataBuffer.
                TYPE_INT)
            return false;
        java.awt.image.SinglePixelPackedSampleModel sppsm;
        sppsm =
          (java.awt.image.SinglePixelPackedSampleModel)
            sm;
        int[] masks =
          sppsm.
          getBitMasks(
            );
        if (masks.
              length ==
              3) {
            if (requireAlpha)
                return false;
        }
        else
            if (masks.
                  length !=
                  4)
                return false;
        if (masks[0] !=
              16711680)
            return false;
        if (masks[1] !=
              65280)
            return false;
        if (masks[2] !=
              255)
            return false;
        if (masks.
              length ==
              4 &&
              masks[3] !=
              -16777216)
            return false;
        return true;
    }
    public static boolean is_BYTE_COMP_Data(java.awt.image.SampleModel sm) {
        if (!(sm instanceof java.awt.image.ComponentSampleModel))
            return false;
        if (sm.
              getDataType(
                ) !=
              java.awt.image.DataBuffer.
                TYPE_BYTE)
            return false;
        return true;
    }
    protected static void divide_INT_PACK_Data(java.awt.image.WritableRaster wr) {
        java.awt.image.SinglePixelPackedSampleModel sppsm;
        sppsm =
          (java.awt.image.SinglePixelPackedSampleModel)
            wr.
            getSampleModel(
              );
        final int width =
          wr.
          getWidth(
            );
        final int scanStride =
          sppsm.
          getScanlineStride(
            );
        java.awt.image.DataBufferInt db =
          (java.awt.image.DataBufferInt)
            wr.
            getDataBuffer(
              );
        final int base =
          db.
          getOffset(
            ) +
          sppsm.
          getOffset(
            wr.
              getMinX(
                ) -
              wr.
              getSampleModelTranslateX(
                ),
            wr.
              getMinY(
                ) -
              wr.
              getSampleModelTranslateY(
                ));
        final int[] pixels =
          db.
          getBankData(
            )[0];
        for (int y =
               0;
             y <
               wr.
               getHeight(
                 );
             y++) {
            int sp =
              base +
              y *
              scanStride;
            final int end =
              sp +
              width;
            while (sp <
                     end) {
                int pixel =
                  pixels[sp];
                int a =
                  pixel >>>
                  24;
                if (a <=
                      0) {
                    pixels[sp] =
                      16777215;
                }
                else
                    if (a <
                          255) {
                        int aFP =
                          16711680 /
                          a;
                        pixels[sp] =
                          a <<
                            24 |
                            ((pixel &
                                16711680) >>
                               16) *
                            aFP &
                            16711680 |
                            (((pixel &
                                 65280) >>
                                8) *
                               aFP &
                               16711680) >>
                            8 |
                            ((pixel &
                                255) *
                               aFP &
                               16711680) >>
                            16;
                    }
                sp++;
            }
        }
    }
    protected static void mult_INT_PACK_Data(java.awt.image.WritableRaster wr) {
        java.awt.image.SinglePixelPackedSampleModel sppsm;
        sppsm =
          (java.awt.image.SinglePixelPackedSampleModel)
            wr.
            getSampleModel(
              );
        final int width =
          wr.
          getWidth(
            );
        final int scanStride =
          sppsm.
          getScanlineStride(
            );
        java.awt.image.DataBufferInt db =
          (java.awt.image.DataBufferInt)
            wr.
            getDataBuffer(
              );
        final int base =
          db.
          getOffset(
            ) +
          sppsm.
          getOffset(
            wr.
              getMinX(
                ) -
              wr.
              getSampleModelTranslateX(
                ),
            wr.
              getMinY(
                ) -
              wr.
              getSampleModelTranslateY(
                ));
        final int[] pixels =
          db.
          getBankData(
            )[0];
        for (int y =
               0;
             y <
               wr.
               getHeight(
                 );
             y++) {
            int sp =
              base +
              y *
              scanStride;
            final int end =
              sp +
              width;
            while (sp <
                     end) {
                int pixel =
                  pixels[sp];
                int a =
                  pixel >>>
                  24;
                if (a >=
                      0 &&
                      a <
                      255) {
                    pixels[sp] =
                      a <<
                        24 |
                        (pixel &
                           16711680) *
                        a >>
                        8 &
                        16711680 |
                        (pixel &
                           65280) *
                        a >>
                        8 &
                        65280 |
                        (pixel &
                           255) *
                        a >>
                        8 &
                        255;
                }
                sp++;
            }
        }
    }
    protected static void divide_BYTE_COMP_Data(java.awt.image.WritableRaster wr) {
        java.awt.image.ComponentSampleModel csm;
        csm =
          (java.awt.image.ComponentSampleModel)
            wr.
            getSampleModel(
              );
        final int width =
          wr.
          getWidth(
            );
        final int scanStride =
          csm.
          getScanlineStride(
            );
        final int pixStride =
          csm.
          getPixelStride(
            );
        final int[] bandOff =
          csm.
          getBandOffsets(
            );
        java.awt.image.DataBufferByte db =
          (java.awt.image.DataBufferByte)
            wr.
            getDataBuffer(
              );
        final int base =
          db.
          getOffset(
            ) +
          csm.
          getOffset(
            wr.
              getMinX(
                ) -
              wr.
              getSampleModelTranslateX(
                ),
            wr.
              getMinY(
                ) -
              wr.
              getSampleModelTranslateY(
                ));
        int aOff =
          bandOff[bandOff.
                    length -
                    1];
        int bands =
          bandOff.
            length -
          1;
        final byte[] pixels =
          db.
          getBankData(
            )[0];
        for (int y =
               0;
             y <
               wr.
               getHeight(
                 );
             y++) {
            int sp =
              base +
              y *
              scanStride;
            final int end =
              sp +
              width *
              pixStride;
            while (sp <
                     end) {
                int a =
                  pixels[sp +
                           aOff] &
                  255;
                if (a ==
                      0) {
                    for (int b =
                           0;
                         b <
                           bands;
                         b++)
                        pixels[sp +
                                 bandOff[b]] =
                          (byte)
                            255;
                }
                else
                    if (a <
                          255) {
                        int aFP =
                          16711680 /
                          a;
                        for (int b =
                               0;
                             b <
                               bands;
                             b++) {
                            int i =
                              sp +
                              bandOff[b];
                            pixels[i] =
                              (byte)
                                ((pixels[i] &
                                    255) *
                                   aFP >>>
                                   16);
                        }
                    }
                sp +=
                  pixStride;
            }
        }
    }
    protected static void mult_BYTE_COMP_Data(java.awt.image.WritableRaster wr) {
        java.awt.image.ComponentSampleModel csm;
        csm =
          (java.awt.image.ComponentSampleModel)
            wr.
            getSampleModel(
              );
        final int width =
          wr.
          getWidth(
            );
        final int scanStride =
          csm.
          getScanlineStride(
            );
        final int pixStride =
          csm.
          getPixelStride(
            );
        final int[] bandOff =
          csm.
          getBandOffsets(
            );
        java.awt.image.DataBufferByte db =
          (java.awt.image.DataBufferByte)
            wr.
            getDataBuffer(
              );
        final int base =
          db.
          getOffset(
            ) +
          csm.
          getOffset(
            wr.
              getMinX(
                ) -
              wr.
              getSampleModelTranslateX(
                ),
            wr.
              getMinY(
                ) -
              wr.
              getSampleModelTranslateY(
                ));
        int aOff =
          bandOff[bandOff.
                    length -
                    1];
        int bands =
          bandOff.
            length -
          1;
        final byte[] pixels =
          db.
          getBankData(
            )[0];
        for (int y =
               0;
             y <
               wr.
               getHeight(
                 );
             y++) {
            int sp =
              base +
              y *
              scanStride;
            final int end =
              sp +
              width *
              pixStride;
            while (sp <
                     end) {
                int a =
                  pixels[sp +
                           aOff] &
                  255;
                if (a !=
                      255)
                    for (int b =
                           0;
                         b <
                           bands;
                         b++) {
                        int i =
                          sp +
                          bandOff[b];
                        pixels[i] =
                          (byte)
                            ((pixels[i] &
                                255) *
                               a >>
                               8);
                    }
                sp +=
                  pixStride;
            }
        }
    }
    public GraphicsUtil() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "QRpLgbozBNTfo7iN8S8fLVBFOH2xUpxWgjWnbatOl41TkMZgTk9zFl8N4XQf" +
       "irsZqZ6CDNiH58uV2rhuASPetY15t2x4gjT6rPftx1r9t71Ek1HDubrUd/Xz" +
       "hsz47RleihN8JITuv6B4iOGzdPp0r8jEZHxgODnY1XMzlna3vpGwm8h/Leqq" +
       "VZZO67McqAM1FkeNBh5F8SiHciIE2LdRfN0LrK8rkeguBHa8UsBuBLO22OZt" +
       "KRuwII0XBOylEGD/iuJZRuocYD5Oz1WA0wq8BktB1S22VbeUjVOQxsAQFznK" +
       "MbwWguhHKL7PSD0isiYuZ+tCeqWSkOzv3azPskAK0lg8k8s5k8gFR/JWCK63" +
       "UbwehutMpXDBXqjqRdu4F8uGK0hjKZ/6VQikX6P4H9hMYeZqQXKWBh+ss5WE" +
       "9bZt2ttlgxWk8cJ96w8h2M6j+N2FYPuwAthQBX6VXPV728jflw3bOVvjuXBs" +
       "npvm/BzfIglVwcSEGoTxJ4YP2VFDooF3k/5cKV6wKFbPsnRan+XgVV1ra6y9" +
       "YDd71AetOQTafBRzeAhDaM6y6OISGiqVPsDevbrdNq69bLiCNAaHMJ45CMtC" +
       "IK1AcQnskNIZhcm6Mt2l6BO+9EFYXClOG8CaTtuqzrJxCtJYitOVIZxiKD7F" +
       "yJyUPCmnaDFKf1MpSteCLXtsm5Jlo5QM0BgcrM5zwXF0hqC6HsWGwGRUuLaC" +
       "3/dXG7ZVetk46QEafQSquapqh1Okjx/xy7CDnJfbQQ5qssq/ThbiIQzxLqPQ" +
       "E8ywt1IMQV/NOktnzVXlYmhpKqIxkKEnn3h0n5NUCDtDiO1CMWQT6xbVlI/Y" +
       "cKWIJcAuO+LUfLZsxD4boNFHoJarqs0R68vH1ueyGw9hJ6MQg9mNVoAdfy1k" +
       "DVg4YFs6UDZ2QRqLRzZnii723eQZEtO6QnNZlpVvZEIoTqPQIEmTzdwNnqQz" +
       "d3e7NPVK3W+Mgc32Y6Q1BQ+oXixNnva1hmgMXE2FSY7jSyGoDqK4nZFmQNW9" +
       "c3hTsmdr/2AxViWf0Z0Bq1a81gUW2WuF9XmhrBiZrRsaoxKjqWIOuCBEcakE" +
       "5HAIsgdRfIWRBVYCUuhhnvl6T6Wo3QhGHbGNO3KRHibcF4QrSGMpXP8cgusY" +
       "iodxjwl5bSisRyoFqxtM+o5t2nfKBitIYylYT4bAwke3hOOMtNq+VTglPby+" +
       "USleoK/ml7Z1vywbryCNpXi9HMLrJIrnGJnPnSuU1vPloJVlpMH7eje+i9hW" +
       "8D8krP97IH3raGPdoqPb3+RPa+f+N0FDgtSNZRTF+7ac57hWN+gY/9aWNHDZ" +
       "zN/WEV5lpD38oVVGamTnoTXhlFXrNUbagmoxUgXSW/rHENSKlYaSIL0lT8Pi" +
       "6i8J7fNPb7kzsOl3yzFSax14i7wJ2qEIHv5Ud1KAJp4C4CuJUeuVxGyEX7rU" +
       "Oz44rKS11LB6HtO/LO/xdv4fQpxH0TPW/whJSieO3jRw27lrv2a9UC0p4v79" +
       "qGVOgsyyXtvmSvFx9hWB2hxdtVtWfzLvydmXOw/+573Q7e0bdy5wev7y82Lf" +
       "G8ZmR+5F47eObXz5R4dqfyKQyC4SgTxx/q7ClzezesYgS3clCl8o2yEa/NXn" +
       "ztX/NH3D2rHfvc1fjyXWC2hLgssnpTOP3fL6/W3H2gUyJw5upqZolr9V2jut" +
       "bqPSpDFC5srmpix0EbTIopL3tto8dH0RH5rkXGycc3Nn8U17RlYWvqxX+P8J" +
       "6hVtihr8ARpUMzdB5rhnrJHxvRGQ0XVfBfeMPZQo+f++iGZxNMAfk4l+XXde" +
       "U5+9ReezXy4SoqznK4T3+SEe/fb/AXz34H09SAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "R3ozICfZc2ZbdU25wWSr1rQmxXDDGl8e");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
