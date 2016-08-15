package org.apache.batik.svggen;
public class CachedImageHandlerPNGEncoder extends org.apache.batik.svggen.DefaultCachedImageHandler {
    public static final java.lang.String CACHED_PNG_PREFIX = "pngImage";
    public static final java.lang.String CACHED_PNG_SUFFIX = ".png";
    protected java.lang.String refPrefix = "";
    public CachedImageHandlerPNGEncoder(java.lang.String imageDir, java.lang.String urlRoot)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        super(
          );
        refPrefix =
          urlRoot +
          "/";
        setImageCacher(
          new org.apache.batik.svggen.ImageCacher.External(
            imageDir,
            CACHED_PNG_PREFIX,
            CACHED_PNG_SUFFIX));
    }
    public void encodeImage(java.awt.image.BufferedImage buf, java.io.OutputStream os)
          throws java.io.IOException { org.apache.batik.ext.awt.image.spi.ImageWriter writer =
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
    public int getBufferedImageType() { return java.awt.image.BufferedImage.
                                                 TYPE_INT_ARGB;
    }
    public java.lang.String getRefPrefix() {
        return refPrefix;
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
       "15/9Sn5h/78+aVGDeCYAAA==");
}
