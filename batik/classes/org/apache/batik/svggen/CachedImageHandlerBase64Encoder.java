package org.apache.batik.svggen;
public class CachedImageHandlerBase64Encoder extends org.apache.batik.svggen.DefaultCachedImageHandler {
    public CachedImageHandlerBase64Encoder() { super();
                                               setImageCacher(new org.apache.batik.svggen.ImageCacher.Embedded(
                                                                ));
    }
    public org.w3c.dom.Element createElement(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        org.w3c.dom.Element imageElement =
          generatorContext.
          getDOMFactory(
            ).
          createElementNS(
            SVG_NAMESPACE_URI,
            SVG_USE_TAG);
        return imageElement;
    }
    public java.lang.String getRefPrefix() { return ""; }
    protected java.awt.geom.AffineTransform handleTransform(org.w3c.dom.Element imageElement,
                                                            double x,
                                                            double y,
                                                            double srcWidth,
                                                            double srcHeight,
                                                            double dstWidth,
                                                            double dstHeight,
                                                            org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        java.awt.geom.AffineTransform af =
          new java.awt.geom.AffineTransform(
          );
        double hRatio =
          dstWidth /
          srcWidth;
        double vRatio =
          dstHeight /
          srcHeight;
        af.
          translate(
            x,
            y);
        if (hRatio !=
              1 ||
              vRatio !=
              1) {
            af.
              scale(
                hRatio,
                vRatio);
        }
        if (!af.
              isIdentity(
                )) {
            return af;
        }
        else {
            return null;
        }
    }
    public void encodeImage(java.awt.image.BufferedImage buf,
                            java.io.OutputStream os)
          throws java.io.IOException { org.apache.batik.util.Base64EncoderStream b64Encoder =
                                         new org.apache.batik.util.Base64EncoderStream(
                                         os);
                                       org.apache.batik.ext.awt.image.spi.ImageWriter writer =
                                         org.apache.batik.ext.awt.image.spi.ImageWriterRegistry.
                                         getInstance(
                                           ).
                                         getWriterFor(
                                           "image/png");
                                       writer.
                                         writeImage(
                                           buf,
                                           b64Encoder);
                                       b64Encoder.
                                         close(
                                           );
    }
    public int getBufferedImageType() { return java.awt.image.BufferedImage.
                                                 TYPE_INT_ARGB;
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
       "8a4/fOMnn/1OnnT5P2GwnC8CJgAA");
}
