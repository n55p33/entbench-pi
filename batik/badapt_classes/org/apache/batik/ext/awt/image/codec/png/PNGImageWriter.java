package org.apache.batik.ext.awt.image.codec.png;
public class PNGImageWriter implements org.apache.batik.ext.awt.image.spi.ImageWriter {
    public void writeImage(java.awt.image.RenderedImage image, java.io.OutputStream out)
          throws java.io.IOException { writeImage(image, out, null);
    }
    public void writeImage(java.awt.image.RenderedImage image, java.io.OutputStream out,
                           org.apache.batik.ext.awt.image.spi.ImageWriterParams params)
          throws java.io.IOException { org.apache.batik.ext.awt.image.codec.png.PNGImageEncoder encoder =
                                         new org.apache.batik.ext.awt.image.codec.png.PNGImageEncoder(
                                         out,
                                         null);
                                       encoder.
                                         encode(
                                           image);
    }
    public java.lang.String getMIMEType() {
        return "image/png";
    }
    public PNGImageWriter() { super(); }
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
      ("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");
}
