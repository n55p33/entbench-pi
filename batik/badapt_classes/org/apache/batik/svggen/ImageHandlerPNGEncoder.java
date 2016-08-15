package org.apache.batik.svggen;
public class ImageHandlerPNGEncoder extends org.apache.batik.svggen.AbstractImageHandlerEncoder {
    public ImageHandlerPNGEncoder(java.lang.String imageDir, java.lang.String urlRoot)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        super(
          imageDir,
          urlRoot);
    }
    public final java.lang.String getSuffix() { return ".png"; }
    public final java.lang.String getPrefix() { return "pngImage";
    }
    public void encodeImage(java.awt.image.BufferedImage buf, java.io.File imageFile)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        try {
            java.io.OutputStream os =
              new java.io.FileOutputStream(
              imageFile);
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
            finally {
                os.
                  close(
                    );
            }
        }
        catch (java.io.IOException e) {
            throw new org.apache.batik.svggen.SVGGraphics2DIOException(
              ERR_WRITE +
              imageFile.
                getName(
                  ));
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
      ("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" +
       "i0dsXvkPTZZACVIYAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "JT/r/h9MHh99oSMAAA==");
}
