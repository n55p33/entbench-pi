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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
