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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Zu6sYruf3o7tbeoPHuzqvp+eAqv1dHm3vlvM+r8x5/JQXl7Mil/YTlP2+mqw" +
       "rMM8JAU9dNOV7HzgN0XAxWzl4j73MQhRwZxcXNj1nM0rQVCeu1Om/e42rtsC" +
       "WlaWcxZbl6he1X1+cUuV71y3HjJjPBAifvAfn/rmrz3yXTCnNHR6ldkbTOWR" +
       "Edk4i5p/9bln7rvp6e99MEcpAFHjdz76b3kMwlxL46zAs4LYV/WeTFUhDwIY" +
       "KYx6ObBoaq7tNV2ZD0wH4O9qLySEn7z9u9ZHv//pbbh30m9PEGvvf/oDP939" +
       "0NM7R4LsRy6Lc4/22QbaudC37Fk4gB661ih5D+KfPvvkH//uk+/bSnX78ZAR" +
       "ByeiT//V/3xz9yPf+/oVIpLrbe9lTGx0682dSkih+39MaaZPklGaTnQOgY0h" +
       "vCHGCSYzRY4x5FUfJW3LCfszsrjhyr0uOonYZMHrTn0ur+pCrR7CsogJZdpw" +
       "0YAY411ML1J6lRQik8DHUq8sz2xlNJzQli12DSsQusuB0K2OCx4qjoVVwZD1" +
       "QKtz9Qjx6yucmA4tRIzVgsw6sK6teKfZLEhVsjbEWNyQR4iDDwuL3oIXPJ1G" +
       "JdqKit1mv6gWWX3aWS4XfLUJwxO1WRnT1SEmupLorIoDtmSGG3qCc1ZJFNmh" +
       "PaYncixi61YvmbHigl4sOrQ4quj0lHXDdcHsMj2nMS2GCc3OmcVg7nt+Ije8" +
       "BTER4bZB8xMSNwRCpPG4wrTdISHQZbc2x7VCgutafRC11t4asUObnhUSoyOx" +
       "A7MRdVlMkldtNrDak5pvrS2CKnUmtNhpm57cGfChSRbDXq+zJlKvsOqMTESY" +
       "94o4PR5rLMZPe9PeZmwvsLHp9zpBfUzM0kWKr6x2d7YcTgaNlNYaqcqiS2bg" +
       "EINxKeaxpbASa8txTZVwLtrY467NdFuou4a7Yo0VDHKmsx6NihwxSAeIkpLy" +
       "QHUiflIKaBRwCrylppUjuAIPGaGHJ5LYGVGpSKAYWmPaFNuaTCScnIhTKsSF" +
       "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" +
       "M6SbL971B6/75LPfyZMu/wf0gmi/AiYAAA==");
}
