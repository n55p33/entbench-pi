package org.apache.batik.svggen;
public class SimpleImageHandler implements org.apache.batik.svggen.GenericImageHandler, org.apache.batik.svggen.SVGSyntax, org.apache.batik.svggen.ErrorConstants {
    static final java.lang.String XLINK_NAMESPACE_URI = "http://www.w3.org/1999/xlink";
    protected org.apache.batik.svggen.ImageHandler imageHandler;
    public SimpleImageHandler(org.apache.batik.svggen.ImageHandler imageHandler) {
        super(
          );
        if (imageHandler ==
              null) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        this.
          imageHandler =
          imageHandler;
    }
    public void setDOMTreeManager(org.apache.batik.svggen.DOMTreeManager domTreeManager) {
        
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
            imageHandler.
              handleImage(
                image,
                imageElement,
                generatorContext);
            setImageAttributes(
              imageElement,
              x,
              y,
              width,
              height,
              generatorContext);
        }
        return null;
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
            imageHandler.
              handleImage(
                image,
                imageElement,
                generatorContext);
            setImageAttributes(
              imageElement,
              x,
              y,
              width,
              height,
              generatorContext);
        }
        return null;
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
            imageHandler.
              handleImage(
                image,
                imageElement,
                generatorContext);
            setImageAttributes(
              imageElement,
              x,
              y,
              width,
              height,
              generatorContext);
        }
        return null;
    }
    protected void setImageAttributes(org.w3c.dom.Element imageElement,
                                      double x,
                                      double y,
                                      double width,
                                      double height,
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
                width));
        imageElement.
          setAttributeNS(
            null,
            SVG_HEIGHT_ATTRIBUTE,
            generatorContext.
              doubleString(
                height));
        imageElement.
          setAttributeNS(
            null,
            SVG_PRESERVE_ASPECT_RATIO_ATTRIBUTE,
            SVG_NONE_VALUE);
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
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "4K/4Nud/oDtHbM8gAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
