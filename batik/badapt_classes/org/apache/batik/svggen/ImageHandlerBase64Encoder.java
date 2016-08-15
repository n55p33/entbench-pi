package org.apache.batik.svggen;
public class ImageHandlerBase64Encoder extends org.apache.batik.svggen.DefaultImageHandler {
    public ImageHandlerBase64Encoder() { super(); }
    public void handleHREF(java.awt.Image image, org.w3c.dom.Element imageElement,
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
                  new java.awt.image.BufferedImage(
                  width,
                  height,
                  java.awt.image.BufferedImage.
                    TYPE_INT_ARGB);
                java.awt.Graphics2D g =
                  buf.
                  createGraphics(
                    );
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
    public void handleHREF(java.awt.image.renderable.RenderableImage image,
                           org.w3c.dom.Element imageElement,
                           org.apache.batik.svggen.SVGGeneratorContext generatorContext)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        if (image ==
              null) {
            throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
              ERR_IMAGE_NULL);
        }
        java.awt.image.RenderedImage r =
          image.
          createDefaultRendering(
            );
        if (r ==
              null) {
            handleEmptyImage(
              imageElement);
        }
        else {
            handleHREF(
              r,
              imageElement,
              generatorContext);
        }
    }
    protected void handleEmptyImage(org.w3c.dom.Element imageElement) {
        imageElement.
          setAttributeNS(
            XLINK_NAMESPACE_URI,
            XLINK_HREF_QNAME,
            DATA_PROTOCOL_PNG_PREFIX);
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
    public void handleHREF(java.awt.image.RenderedImage image,
                           org.w3c.dom.Element imageElement,
                           org.apache.batik.svggen.SVGGeneratorContext generatorContext)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        java.io.ByteArrayOutputStream os =
          new java.io.ByteArrayOutputStream(
          );
        org.apache.batik.util.Base64EncoderStream b64Encoder =
          new org.apache.batik.util.Base64EncoderStream(
          os);
        try {
            encodeImage(
              image,
              b64Encoder);
            b64Encoder.
              close(
                );
        }
        catch (java.io.IOException e) {
            throw new org.apache.batik.svggen.SVGGraphics2DIOException(
              ERR_UNEXPECTED,
              e);
        }
        imageElement.
          setAttributeNS(
            XLINK_NAMESPACE_URI,
            XLINK_HREF_QNAME,
            DATA_PROTOCOL_PNG_PREFIX +
            os.
              toString(
                ));
    }
    public void encodeImage(java.awt.image.RenderedImage buf,
                            java.io.OutputStream os)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        try {
            org.apache.batik.ext.awt.image.spi.ImageWriter writer =
              org.apache.batik.ext.awt.image.spi.ImageWriterRegistry.
              getInstance(
                ).
              getWriterFor(
                "image/png");
            writer.
              writeImage(
                buf,
                os);
        }
        catch (java.io.IOException e) {
            throw new org.apache.batik.svggen.SVGGraphics2DIOException(
              ERR_UNEXPECTED);
        }
    }
    public java.awt.image.BufferedImage buildBufferedImage(java.awt.Dimension size) {
        return new java.awt.image.BufferedImage(
          size.
            width,
          size.
            height,
          java.awt.image.BufferedImage.
            TYPE_INT_ARGB);
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
       "+j8Znajz5SYAAA==");
}
