package org.apache.batik.svggen;
public abstract class DefaultCachedImageHandler implements org.apache.batik.svggen.CachedImageHandler, org.apache.batik.svggen.SVGSyntax, org.apache.batik.svggen.ErrorConstants {
    static final java.lang.String XLINK_NAMESPACE_URI = "http://www.w3.org/1999/xlink";
    static final java.awt.geom.AffineTransform IDENTITY = new java.awt.geom.AffineTransform(
      );
    private static java.lang.reflect.Method createGraphics = null;
    private static boolean initDone = false;
    private static final java.lang.Class[] paramc = new java.lang.Class[] { java.awt.image.BufferedImage.class };
    private static java.lang.Object[] paramo = null;
    protected org.apache.batik.svggen.ImageCacher imageCacher;
    public org.apache.batik.svggen.ImageCacher getImageCacher() {
        return imageCacher;
    }
    void setImageCacher(org.apache.batik.svggen.ImageCacher imageCacher) {
        if (imageCacher ==
              null) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        org.apache.batik.svggen.DOMTreeManager dtm =
          null;
        if (this.
              imageCacher !=
              null) {
            dtm =
              this.
                imageCacher.
                getDOMTreeManager(
                  );
        }
        this.
          imageCacher =
          imageCacher;
        if (dtm !=
              null) {
            this.
              imageCacher.
              setDOMTreeManager(
                dtm);
        }
    }
    public void setDOMTreeManager(org.apache.batik.svggen.DOMTreeManager domTreeManager) {
        imageCacher.
          setDOMTreeManager(
            domTreeManager);
    }
    private static java.awt.Graphics2D createGraphics(java.awt.image.BufferedImage buf) {
        if (!initDone) {
            try {
                java.lang.Class clazz =
                  java.lang.Class.
                  forName(
                    "org.apache.batik.ext.awt.image.GraphicsUtil");
                createGraphics =
                  clazz.
                    getMethod(
                      "createGraphics",
                      paramc);
                paramo =
                  (new java.lang.Object[1]);
            }
            catch (java.lang.Throwable t) {
                
            }
            finally {
                initDone =
                  true;
            }
        }
        if (createGraphics ==
              null)
            return buf.
              createGraphics(
                );
        else {
            paramo[0] =
              buf;
            java.awt.Graphics2D g2d =
              null;
            try {
                g2d =
                  (java.awt.Graphics2D)
                    createGraphics.
                    invoke(
                      null,
                      paramo);
            }
            catch (java.lang.Exception e) {
                
            }
            return g2d;
        }
    }
    public org.w3c.dom.Element createElement(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        org.w3c.dom.Element imageElement =
          generatorContext.
          getDOMFactory(
            ).
          createElementNS(
            SVG_NAMESPACE_URI,
            SVG_IMAGE_TAG);
        return imageElement;
    }
    public java.awt.geom.AffineTransform handleImage(java.awt.Image image,
                                                     org.w3c.dom.Element imageElement,
                                                     int x,
                                                     int y,
                                                     int width,
                                                     int height,
                                                     org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        int imageWidth =
          image.
          getWidth(
            null);
        int imageHeight =
          image.
          getHeight(
            null);
        java.awt.geom.AffineTransform af =
          null;
        if (imageWidth ==
              0 ||
              imageHeight ==
              0 ||
              width ==
              0 ||
              height ==
              0) {
            handleEmptyImage(
              imageElement);
        }
        else {
            try {
                handleHREF(
                  image,
                  imageElement,
                  generatorContext);
            }
            catch (org.apache.batik.svggen.SVGGraphics2DIOException e) {
                try {
                    generatorContext.
                      errorHandler.
                      handleError(
                        e);
                }
                catch (org.apache.batik.svggen.SVGGraphics2DIOException io) {
                    throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
                      io);
                }
            }
            af =
              handleTransform(
                imageElement,
                x,
                y,
                imageWidth,
                imageHeight,
                width,
                height,
                generatorContext);
        }
        return af;
    }
    public java.awt.geom.AffineTransform handleImage(java.awt.image.RenderedImage image,
                                                     org.w3c.dom.Element imageElement,
                                                     int x,
                                                     int y,
                                                     int width,
                                                     int height,
                                                     org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        int imageWidth =
          image.
          getWidth(
            );
        int imageHeight =
          image.
          getHeight(
            );
        java.awt.geom.AffineTransform af =
          null;
        if (imageWidth ==
              0 ||
              imageHeight ==
              0 ||
              width ==
              0 ||
              height ==
              0) {
            handleEmptyImage(
              imageElement);
        }
        else {
            try {
                handleHREF(
                  image,
                  imageElement,
                  generatorContext);
            }
            catch (org.apache.batik.svggen.SVGGraphics2DIOException e) {
                try {
                    generatorContext.
                      errorHandler.
                      handleError(
                        e);
                }
                catch (org.apache.batik.svggen.SVGGraphics2DIOException io) {
                    throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
                      io);
                }
            }
            af =
              handleTransform(
                imageElement,
                x,
                y,
                imageWidth,
                imageHeight,
                width,
                height,
                generatorContext);
        }
        return af;
    }
    public java.awt.geom.AffineTransform handleImage(java.awt.image.renderable.RenderableImage image,
                                                     org.w3c.dom.Element imageElement,
                                                     double x,
                                                     double y,
                                                     double width,
                                                     double height,
                                                     org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        double imageWidth =
          image.
          getWidth(
            );
        double imageHeight =
          image.
          getHeight(
            );
        java.awt.geom.AffineTransform af =
          null;
        if (imageWidth ==
              0 ||
              imageHeight ==
              0 ||
              width ==
              0 ||
              height ==
              0) {
            handleEmptyImage(
              imageElement);
        }
        else {
            try {
                handleHREF(
                  image,
                  imageElement,
                  generatorContext);
            }
            catch (org.apache.batik.svggen.SVGGraphics2DIOException e) {
                try {
                    generatorContext.
                      errorHandler.
                      handleError(
                        e);
                }
                catch (org.apache.batik.svggen.SVGGraphics2DIOException io) {
                    throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
                      io);
                }
            }
            af =
              handleTransform(
                imageElement,
                x,
                y,
                imageWidth,
                imageHeight,
                width,
                height,
                generatorContext);
        }
        return af;
    }
    protected java.awt.geom.AffineTransform handleTransform(org.w3c.dom.Element imageElement,
                                                            double x,
                                                            double y,
                                                            double srcWidth,
                                                            double srcHeight,
                                                            double dstWidth,
                                                            double dstHeight,
                                                            org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        imageElement.
          setAttributeNS(
            null,
            SVG_X_ATTRIBUTE,
            generatorContext.
              doubleString(
                x));
        imageElement.
          setAttributeNS(
            null,
            SVG_Y_ATTRIBUTE,
            generatorContext.
              doubleString(
                y));
        imageElement.
          setAttributeNS(
            null,
            SVG_WIDTH_ATTRIBUTE,
            generatorContext.
              doubleString(
                dstWidth));
        imageElement.
          setAttributeNS(
            null,
            SVG_HEIGHT_ATTRIBUTE,
            generatorContext.
              doubleString(
                dstHeight));
        return null;
    }
    protected void handleEmptyImage(org.w3c.dom.Element imageElement) {
        imageElement.
          setAttributeNS(
            XLINK_NAMESPACE_URI,
            XLINK_HREF_QNAME,
            "");
        imageElement.
          setAttributeNS(
            null,
            SVG_WIDTH_ATTRIBUTE,
            "0");
        imageElement.
          setAttributeNS(
            null,
            SVG_HEIGHT_ATTRIBUTE,
            "0");
    }
    public void handleHREF(java.awt.Image image,
                           org.w3c.dom.Element imageElement,
                           org.apache.batik.svggen.SVGGeneratorContext generatorContext)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        if (image ==
              null)
            throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
              ERR_IMAGE_NULL);
        int width =
          image.
          getWidth(
            null);
        int height =
          image.
          getHeight(
            null);
        if (width ==
              0 ||
              height ==
              0) {
            handleEmptyImage(
              imageElement);
        }
        else {
            if (image instanceof java.awt.image.RenderedImage) {
                handleHREF(
                  (java.awt.image.RenderedImage)
                    image,
                  imageElement,
                  generatorContext);
            }
            else {
                java.awt.image.BufferedImage buf =
                  buildBufferedImage(
                    new java.awt.Dimension(
                      width,
                      height));
                java.awt.Graphics2D g =
                  createGraphics(
                    buf);
                g.
                  drawImage(
                    image,
                    0,
                    0,
                    null);
                g.
                  dispose(
                    );
                handleHREF(
                  (java.awt.image.RenderedImage)
                    buf,
                  imageElement,
                  generatorContext);
            }
        }
    }
    public java.awt.image.BufferedImage buildBufferedImage(java.awt.Dimension size) {
        return new java.awt.image.BufferedImage(
          size.
            width,
          size.
            height,
          getBufferedImageType(
            ));
    }
    protected void handleHREF(java.awt.image.RenderedImage image,
                              org.w3c.dom.Element imageElement,
                              org.apache.batik.svggen.SVGGeneratorContext generatorContext)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        java.awt.image.BufferedImage buf =
          null;
        if (image instanceof java.awt.image.BufferedImage &&
              ((java.awt.image.BufferedImage)
                 image).
              getType(
                ) ==
              getBufferedImageType(
                )) {
            buf =
              (java.awt.image.BufferedImage)
                image;
        }
        else {
            java.awt.Dimension size =
              new java.awt.Dimension(
              image.
                getWidth(
                  ),
              image.
                getHeight(
                  ));
            buf =
              buildBufferedImage(
                size);
            java.awt.Graphics2D g =
              createGraphics(
                buf);
            g.
              drawRenderedImage(
                image,
                IDENTITY);
            g.
              dispose(
                );
        }
        cacheBufferedImage(
          imageElement,
          buf,
          generatorContext);
    }
    protected void handleHREF(java.awt.image.renderable.RenderableImage image,
                              org.w3c.dom.Element imageElement,
                              org.apache.batik.svggen.SVGGeneratorContext generatorContext)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        java.awt.Dimension size =
          new java.awt.Dimension(
          (int)
            java.lang.Math.
            ceil(
              image.
                getWidth(
                  )),
          (int)
            java.lang.Math.
            ceil(
              image.
                getHeight(
                  )));
        java.awt.image.BufferedImage buf =
          buildBufferedImage(
            size);
        java.awt.Graphics2D g =
          createGraphics(
            buf);
        g.
          drawRenderableImage(
            image,
            IDENTITY);
        g.
          dispose(
            );
        handleHREF(
          (java.awt.image.RenderedImage)
            buf,
          imageElement,
          generatorContext);
    }
    protected void cacheBufferedImage(org.w3c.dom.Element imageElement,
                                      java.awt.image.BufferedImage buf,
                                      org.apache.batik.svggen.SVGGeneratorContext generatorContext)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        java.io.ByteArrayOutputStream os;
        if (generatorContext ==
              null)
            throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
              ERR_CONTEXT_NULL);
        try {
            os =
              new java.io.ByteArrayOutputStream(
                );
            encodeImage(
              buf,
              os);
            os.
              flush(
                );
            os.
              close(
                );
        }
        catch (java.io.IOException e) {
            throw new org.apache.batik.svggen.SVGGraphics2DIOException(
              ERR_UNEXPECTED,
              e);
        }
        java.lang.String ref =
          imageCacher.
          lookup(
            os,
            buf.
              getWidth(
                ),
            buf.
              getHeight(
                ),
            generatorContext);
        imageElement.
          setAttributeNS(
            XLINK_NAMESPACE_URI,
            XLINK_HREF_QNAME,
            getRefPrefix(
              ) +
            ref);
    }
    public abstract java.lang.String getRefPrefix();
    public abstract void encodeImage(java.awt.image.BufferedImage buf,
                                     java.io.OutputStream os)
          throws java.io.IOException;
    public abstract int getBufferedImageType();
    public DefaultCachedImageHandler() { super(
                                           );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "OoUVf2Nnni8qfa4lWctWdV4HK1Z35Ko9");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("VaUoGqMSqubG/rTSrPZpb0XhAhEaekpPBCeKSK+buvxQ7BNEo1YxOjzPUTbf" +
       "ScKQQmPaaaxcvV6u+z2GEtIRiiLGEnf0FTvuSwNtpG+MVmOErNkG1aegyWKK" +
       "ZTNZGW6Vst/gXKftEsJ6GIZxU+zOtnhnkXArf861hWalCUd90oVFMlkuJ4NR" +
       "Pykz1YoQLlgxZi3JGEJirywYJEu7uAm3t2Db5M0FFhGhlHQWoi2YMgciiUri" +
       "DLuTDQXXZsPMroBNacfkSTrpBKE4ZKEm1otSlEq2U4PSyAaDzewIzQihGfM6" +
       "yTZdbRWGPIUlAysZOH1xayyGa8st4749QcvrEebHcR8GcV+jE8yqc8Fs93o1" +
       "acTrZUYdY6qLeYymTqbdxCunLTvLGlsDzZZVfNwE+3RxFJgLqtaG7ERplfsd" +
       "W4+olTiJ5xyBZ4t+T6H6HdNRO2oWqRCixFDSTcg23E8UrZo5HdTYJF2wwA0W" +
       "3rxpCSOUSyze3059oOGRSRJMY4DUmmk0lFNqra46o01bTbmBpozrFLHaRnUS" +
       "Y/GGsWyas16gTHGRdziMD+r4lG+KssQtMJOzNvC24panuID6NWg+lNExjuBo" +
       "PSoPKAwZQvNUhvWuoNRMf1OvzwZ1pB8OdTEY0XWBKld4NaWWo6yLdoMNq9LT" +
       "KkmnbQKDpDHpRlwyF2UbpwloI3qz1iCtVXocik8MT/bHpB83A2o8t6Z0a1ye" +
       "diF9BDZ0Rs1qdXQaauouLoUhVBPsObWOKNacYyFubOBOZ0FAuLstD8j6dttf" +
       "VPBlH2G2XtPXRHjGVj0O9zpzBAuESTSFqxI0nSOIzcdzamw0yHBKhMiw3pA6" +
       "dVm3Oi7nbyaYhYWQZvcGxrxMONREq9g83GL4Vpj5I0WaNmdRO+HHkZH1LbZa" +
       "hfmtAilRXC4HTCew4qkBwQ5EuXaLg8A+cz7tYK2NE2X1pMYMhGBsb5XUYNbD" +
       "Zn0qcQg8CId+gxUdh+yQcnUZTfQFSZN91F83/TpXBZO9p25XWBVNG9QqQOgt" +
       "DmtIF496KtefIqgUTeZyX5EgiUzjcq8KgoYBSXQkUq001Mhsk60m8JVwT5nN" +
       "E56bcO2wQVRm2/lMXUy7cTyS2ISKMENeVqZyMuot5skESVUCRLRmP7Eh1mw0" +
       "8ke5X35+j5hfXDw5Pzpu+//wzDy96JVMVLqsqGEUKFqUHr2uKP5dKR2c2zz8" +
       "e+J1xYlTPzccvnp49LxXD1cfYjxs8przmvCTNr91IuXoNdTrz6vZCgI3ODrV" +
       "nb8rfuC8477FS/1PvufJp/Thp6qHr2+XUenWyPV+0jI2hnUC1t27l0xHlNyb" +
       "M/C60u60Sunw78k3OMcaufr1TUH1TqMXvGL69gVl38mTP4tKd5pGdOZdzueP" +
       "zeBbz/Yy4WS3ZxAWmfl5FvoAIf08EJauCW7vGP3niwr//QKE/yNPvgcQhqcQ" +
       "XvM9ysZd6seo/9sLQH17npm3e9sB6rddH72efFV5kf1SQyY/u8koDkAc5F3t" +
       "7Z1P0t5NeeZfAa8ASDrdNC/44TEnf/0COCkOtObngowDToznwclVr5YvJuaV" +
       "R6ezireZ+814nh/O3bmLAvKVC+i4J09uO/fM1D1HnR+WwNQRRXu3vwCKihfw" +
       "D4LrvQcUvffHYjblCxzkwXnbwvvln5MUhLz6ArIeypP7o9KLdmTln9cYB1/C" +
       "5FzlQyWItq+79v7JsoKrV7wArl6RZ+Yvvz98wNWHrw9XtxQVbjkEcOeRsgvb" +
       "yaV+XV707quTvQcLQqALyCpQPxqVbl8US9Zhl6XxMSfl68HJFw84+eKPhZOz" +
       "swvsrPSj2fUcGHrzBQzlwcwefiFDxPVg6NsHDH37x8LQI2cYCgqG8sNPB2Tl" +
       "t8d0XWs1ull3Y7X4LGaPPZ3sSOxfQCKXJ/SFJLZfqCf/ScDHPbu2u7/Ph8Tf" +
       "uiaJl4sKlw8t6Czua9Lw0xfQ8I48kaLSlR0Np07nnqBi+gKoKI7gEADVGw+o" +
       "eOP1oeI4xtl7XYFlcQHOVZ5oUemuHc6W7UXbI50fr957+nWIaPYOziXv1a/P" +
       "xLnhaJuyVzlS/E610cWrWOWiVexoYe4OW6lmePkBwaLTTZ64Uem2HVcdrkWf" +
       "Ycl7ASwVx2vBtmZPPGBJvD4snYF+95F7oZZgRQ0Pwb3nAiN5b548Adqq8dLS" +
       "TwVEecnxrm/v517ofCCBqO84IODt12c+nDCTt5wxkw+dP3WSokJ+Cm/vAxep" +
       "/JeuB+InDhD/7HVHPDiD+OPPhvipPPnoRYif9ZThsyHugwE/eID4l6474gLs" +
       "XceIf+3ZEH86T/4hsG4t9wdnrfsk8k++0OjhDWDg3zxA/pvPA/nxYdWvP9ue" +
       "fe/zF5T9kzx5OirdAfbsnDEfBcZ8WXTYOQb5uRcA8iV5ZgeA+8IByC9cR5DH" +
       "x3APPM7JQ+LDOPLiiI/ARsIuoD5zsRu857DhWSf/L/Pkd0H8YziaqxvXMoMv" +
       "vgCG7sszwUK/96UDhr70YzKDf3NB2dfy5MuAPWAGp+z98Az6u4/BfuX5gE2j" +
       "0svP/VA4/9Lxvqv+f4LdN/XaZ5+6cvnep8R/t/tA4/C791sHpcvz2LJOfph2" +
       "4v5m78iAb919plYcwd77k6h07zkrfP59WXGTy773x7v6/wHEP2frR6Wbir8n" +
       "630DuMXjeqCr3c3JKt+KSjeAKvntnxcK/US6s7n7TtpDzmzp7mdj9qjJyc9m" +
       "828cioPxh98jxKODD06efqrH/swPap/afbarWUqW5b1cHpRu2X1BXHSaf9Pw" +
       "mnN7O+zr5s4jP7rzc7e+7vCh5J07gY9t84Rsr772d7FFKJl/yZr9zr2f/6lf" +
       "fepPi6PN/xeFfQI/pEMAAA==");
}
