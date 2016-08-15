package org.apache.batik.ext.awt.image.codec.jpeg;
public class JPEGImageWriter implements org.apache.batik.ext.awt.image.spi.ImageWriter {
    public void writeImage(java.awt.image.RenderedImage image, java.io.OutputStream out)
          throws java.io.IOException { writeImage(image, out, null);
    }
    public void writeImage(java.awt.image.RenderedImage image, java.io.OutputStream out,
                           org.apache.batik.ext.awt.image.spi.ImageWriterParams params)
          throws java.io.IOException { java.awt.image.BufferedImage bi;
                                       if (image instanceof java.awt.image.BufferedImage) {
                                           bi =
                                             (java.awt.image.BufferedImage)
                                               image;
                                       }
                                       else {
                                           bi =
                                             org.apache.batik.ext.awt.image.GraphicsUtil.
                                               makeLinearBufferedImage(
                                                 image.
                                                   getWidth(
                                                     ),
                                                 image.
                                                   getHeight(
                                                     ),
                                                 false);
                                       }
                                       com.sun.image.codec.jpeg.JPEGImageEncoder encoder =
                                         com.sun.image.codec.jpeg.JPEGCodec.
                                         createJPEGEncoder(
                                           out);
                                       if (params !=
                                             null) {
                                           com.sun.image.codec.jpeg.JPEGEncodeParam param =
                                             encoder.
                                             getDefaultJPEGEncodeParam(
                                               bi);
                                           if (params.
                                                 getJPEGQuality(
                                                   ) !=
                                                 null) {
                                               param.
                                                 setQuality(
                                                   params.
                                                     getJPEGQuality(
                                                       ).
                                                     floatValue(
                                                       ),
                                                   params.
                                                     getJPEGForceBaseline(
                                                       ).
                                                     booleanValue(
                                                       ));
                                           }
                                           encoder.
                                             encode(
                                               bi,
                                               param);
                                       }
                                       else {
                                           encoder.
                                             encode(
                                               bi);
                                       } }
    public java.lang.String getMIMEType() {
        return "image/jpeg";
    }
    public JPEGImageWriter() { super(); }
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
