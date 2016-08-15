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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "0lCdImHk+55bE622bo56/iLhZmVmKArr");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "/7Q42vx/ATjkxcikQwAA");
}
