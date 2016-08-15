package org.apache.batik.svggen;
public class DefaultImageHandler implements org.apache.batik.svggen.ImageHandler, org.apache.batik.svggen.ErrorConstants, org.apache.batik.util.XMLConstants {
    public DefaultImageHandler() { super(); }
    public void handleImage(java.awt.Image image, org.w3c.dom.Element imageElement,
                            org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        imageElement.
          setAttributeNS(
            null,
            SVG_WIDTH_ATTRIBUTE,
            java.lang.String.
              valueOf(
                image.
                  getWidth(
                    null)));
        imageElement.
          setAttributeNS(
            null,
            SVG_HEIGHT_ATTRIBUTE,
            java.lang.String.
              valueOf(
                image.
                  getHeight(
                    null)));
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
    }
    public void handleImage(java.awt.image.RenderedImage image,
                            org.w3c.dom.Element imageElement,
                            org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        imageElement.
          setAttributeNS(
            null,
            SVG_WIDTH_ATTRIBUTE,
            java.lang.String.
              valueOf(
                image.
                  getWidth(
                    )));
        imageElement.
          setAttributeNS(
            null,
            SVG_HEIGHT_ATTRIBUTE,
            java.lang.String.
              valueOf(
                image.
                  getHeight(
                    )));
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
    }
    public void handleImage(java.awt.image.renderable.RenderableImage image,
                            org.w3c.dom.Element imageElement,
                            org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        imageElement.
          setAttributeNS(
            null,
            SVG_WIDTH_ATTRIBUTE,
            java.lang.String.
              valueOf(
                image.
                  getWidth(
                    )));
        imageElement.
          setAttributeNS(
            null,
            SVG_HEIGHT_ATTRIBUTE,
            java.lang.String.
              valueOf(
                image.
                  getHeight(
                    )));
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
    }
    protected void handleHREF(java.awt.Image image,
                              org.w3c.dom.Element imageElement,
                              org.apache.batik.svggen.SVGGeneratorContext generatorContext)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        imageElement.
          setAttributeNS(
            XLINK_NAMESPACE_URI,
            XLINK_HREF_QNAME,
            image.
              toString(
                ));
    }
    protected void handleHREF(java.awt.image.RenderedImage image,
                              org.w3c.dom.Element imageElement,
                              org.apache.batik.svggen.SVGGeneratorContext generatorContext)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        imageElement.
          setAttributeNS(
            XLINK_NAMESPACE_URI,
            XLINK_HREF_QNAME,
            image.
              toString(
                ));
    }
    protected void handleHREF(java.awt.image.renderable.RenderableImage image,
                              org.w3c.dom.Element imageElement,
                              org.apache.batik.svggen.SVGGeneratorContext generatorContext)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        imageElement.
          setAttributeNS(
            XLINK_NAMESPACE_URI,
            XLINK_HREF_QNAME,
            image.
              toString(
                ));
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "FOo+EI/YXPsvhvHC0jEbAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
