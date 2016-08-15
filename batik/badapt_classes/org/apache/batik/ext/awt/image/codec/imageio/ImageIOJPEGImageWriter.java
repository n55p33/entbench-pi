package org.apache.batik.ext.awt.image.codec.imageio;
public class ImageIOJPEGImageWriter extends org.apache.batik.ext.awt.image.codec.imageio.ImageIOImageWriter {
    private static final java.lang.String JPEG_NATIVE_FORMAT = "javax_imageio_jpeg_image_1.0";
    public ImageIOJPEGImageWriter() { super("image/jpeg"); }
    protected javax.imageio.metadata.IIOMetadata updateMetadata(javax.imageio.metadata.IIOMetadata meta,
                                                                org.apache.batik.ext.awt.image.spi.ImageWriterParams params) {
        if (JPEG_NATIVE_FORMAT.
              equals(
                meta.
                  getNativeMetadataFormatName(
                    ))) {
            meta =
              addAdobeTransform(
                meta);
            javax.imageio.metadata.IIOMetadataNode root =
              (javax.imageio.metadata.IIOMetadataNode)
                meta.
                getAsTree(
                  JPEG_NATIVE_FORMAT);
            javax.imageio.metadata.IIOMetadataNode jv =
              getChildNode(
                root,
                "JPEGvariety");
            if (jv ==
                  null) {
                jv =
                  new javax.imageio.metadata.IIOMetadataNode(
                    "JPEGvariety");
                root.
                  appendChild(
                    jv);
            }
            javax.imageio.metadata.IIOMetadataNode child;
            if (params.
                  getResolution(
                    ) !=
                  null) {
                child =
                  getChildNode(
                    jv,
                    "app0JFIF");
                if (child ==
                      null) {
                    child =
                      new javax.imageio.metadata.IIOMetadataNode(
                        "app0JFIF");
                    jv.
                      appendChild(
                        child);
                }
                child.
                  setAttribute(
                    "majorVersion",
                    null);
                child.
                  setAttribute(
                    "minorVersion",
                    null);
                child.
                  setAttribute(
                    "resUnits",
                    "1");
                child.
                  setAttribute(
                    "Xdensity",
                    params.
                      getResolution(
                        ).
                      toString(
                        ));
                child.
                  setAttribute(
                    "Ydensity",
                    params.
                      getResolution(
                        ).
                      toString(
                        ));
                child.
                  setAttribute(
                    "thumbWidth",
                    null);
                child.
                  setAttribute(
                    "thumbHeight",
                    null);
            }
            try {
                meta.
                  setFromTree(
                    JPEG_NATIVE_FORMAT,
                    root);
            }
            catch (javax.imageio.metadata.IIOInvalidTreeException e) {
                throw new java.lang.RuntimeException(
                  "Cannot update image metadata: " +
                  e.
                    getMessage(
                      ),
                  e);
            }
        }
        return meta;
    }
    private static javax.imageio.metadata.IIOMetadata addAdobeTransform(javax.imageio.metadata.IIOMetadata meta) {
        javax.imageio.metadata.IIOMetadataNode root =
          (javax.imageio.metadata.IIOMetadataNode)
            meta.
            getAsTree(
              JPEG_NATIVE_FORMAT);
        javax.imageio.metadata.IIOMetadataNode markerSequence =
          getChildNode(
            root,
            "markerSequence");
        if (markerSequence ==
              null) {
            throw new java.lang.RuntimeException(
              "Invalid metadata!");
        }
        javax.imageio.metadata.IIOMetadataNode adobeTransform =
          getChildNode(
            markerSequence,
            "app14Adobe");
        if (adobeTransform ==
              null) {
            adobeTransform =
              new javax.imageio.metadata.IIOMetadataNode(
                "app14Adobe");
            adobeTransform.
              setAttribute(
                "transform",
                "1");
            adobeTransform.
              setAttribute(
                "version",
                "101");
            adobeTransform.
              setAttribute(
                "flags0",
                "0");
            adobeTransform.
              setAttribute(
                "flags1",
                "0");
            markerSequence.
              appendChild(
                adobeTransform);
        }
        else {
            adobeTransform.
              setAttribute(
                "transform",
                "1");
        }
        try {
            meta.
              setFromTree(
                JPEG_NATIVE_FORMAT,
                root);
        }
        catch (javax.imageio.metadata.IIOInvalidTreeException e) {
            throw new java.lang.RuntimeException(
              "Cannot update image metadata: " +
              e.
                getMessage(
                  ),
              e);
        }
        return meta;
    }
    protected javax.imageio.ImageWriteParam getDefaultWriteParam(javax.imageio.ImageWriter iiowriter,
                                                                 java.awt.image.RenderedImage image,
                                                                 org.apache.batik.ext.awt.image.spi.ImageWriterParams params) {
        javax.imageio.plugins.jpeg.JPEGImageWriteParam param =
          new javax.imageio.plugins.jpeg.JPEGImageWriteParam(
          iiowriter.
            getLocale(
              ));
        return param;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456836489000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "ii42V/8N91vSDlgaAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456836489000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/lZ2yvC/fqDw/ewlAAA=");
}
