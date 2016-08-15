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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Pvsync9+uUCIsp6vEN7jh3j0h/8HGbitKT1IAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "G+CVarDV6niAqDVdZOFRCMdbnBiD5tcz");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
