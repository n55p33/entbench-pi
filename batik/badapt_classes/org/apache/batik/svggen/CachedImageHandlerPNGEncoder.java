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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "3b/7+l9/7iv5pf3/Any5oMt8JgAA");
}
