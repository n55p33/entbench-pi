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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "vlvKMRFyY+1BfyaOHDuSHbNY4GhcMLxTnu4a/qM4R2eV6CDk5j4Q/fb213e9" +
       "xMmyFtm5QFEeZgYW9+R/rVjsFejd7Hn/KiNVir0ZXhuB7M8/v5j6yq+3PLm/" +
       "vWoDuIwYqc1qyg1ZGkv6abPGyo55FuReybkkaq8Gjy0jodVwQrHiB/7idl75" +
       "/QpGdwyLexhpSHP3zfF2tmFJYRvGKRhdXwoiNLrVlDQLM2bX+O49k8an2Rak" +
       "zdz4ynWtbHyLC1rz4CuyhWqQNdGka4olgPag/WQFtI9j8Zgfbaz6sQvm42cS" +
       "zGkbkemZg1mua2UwuwNgmhxMTOttXPHVc8ixPFz+nFUn9Sx0CB41/HmU6/Cy" +
       "vxA78mKFHTmBxbMVd+S5M7AjPKXYBM8RG9b7TrMjO4rThvvKdA1oW80XUl2w" +
       "3JfL4vRuBZx+h8WbEBzgHTaCVPjbi4vf6sL11pmCqweeJ2ydn5g5XOW6lvbw" +
       "HC4+6gcVUPkrFu9Bsimsh19nFEzIg8nJ/wcmeUC/+EYbb1cWFP1nJv7nkR8+" +
       "1FI7/9C213l6UvgvphFcXiqrqt783/NebZg0pXD9GsVtgPAtnzAyv0y8g2k8" +
       "f+Fr/1jI/wtwCcpDms+/vXKfMVLvysFQ4sUrAi6uCkTgFTLtEhm+uAbJhzy5" +
       "m40jh3/u6eAvdPFeoGLMzv+zdFx4VvxrmZCPHbp66MZTF98vLnBlVdq9G0dp" +
       "AMct7pILGdbysqM5Y1Vv7P60+ZG6lU7I3CYW7NrzIo+99YNlGrjjCwO3m1ZX" +
       "4ZLzjcOXPv3L6epXITvYQUISRI47ii+M8kYWUtsd8eIABbJRfu3a2/29qcvP" +
       "Tf3tLX4lR0RAs7i8fEI+ceS61+5YcLgzTBpiZDZkAzTPb7KunNK2UHnSHCVN" +
       "ijWQhyXCKIqk+qKfZjROCe9pOC42nE2FWrz+Z2RFcZZT/KdJvarnqLlez2pJ" +
       "HAbipwa3xsm0fUlq1jACHdwaTwD4I+GMcDfAHhPxQcNwsqb6Pxn8lB4t65pC" +
       "HfwV3+b8DyvbQfHPIAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
