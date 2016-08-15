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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "MTGEzoeu9zpLX+rWsS2j19z6xbydnTVt922+9PZ/va//BuPNL2Fn+qFjeh4X" +
       "+an2019pvkp9/w508mAX54ZTsKNM147u3Vzw9TDynf6RHZwHDgJyW+r/Crhe" +
       "txeQ1918d/imyXMiS55NyhzbftzJCHb2Q3h/tquyDVlXdzTd17UsbPtEm0MD" +
       "093lotCLwl7o67KdSQ+PST9xNEHu3mekufpK1b3U6RlfkjZuCF2I08zYDtY9" +
       "lLzDEDq1dE1tm9Xei+09HN5izDqso/58DFz4nj+LPxl/ntxWa5Q28b7t2Esr" +
       "jk36ZUP86s2dmv58S0bw62nzjiPeS3t+aeupd/4Ynrqcdj4ALn7PU/xPxlOH" +
       "N74//ALPPpo27w+h26Z62Kbb9f0KaW7N+8BLMW8VQhePnYal2/n33nA4vzlQ" +
       "Vj/71MVzr3hq8DfZgdDBoe95Fjo3iSzr8O7rofsznq9PzEz/85u9WC/7+q0Q" +
       "uvojH9qBhE+/Mgt+c8P/2yF05UfhD6HT2fdh3t8JoQdfmBdwmQe1t8f1qRC6" +
       "91ZcIXQStIepnwbocDNqQAnaw5TPhNCl45Rg/Oz7MN3nQV5v6ULozObmMMkX" +
       "gHRAkt7+gXeTHenN9vrqxKEZYy/Ls+y5/GLZc8By+CQsdUH2t4/9GSHa/PHj" +
       "uvrMU63OW57DP7k5iVMtOcng7RwLnd0cCh7MKo/cUtq+rDPU1efv/Nz5x/Zn" +
       "wDs3Cm8r7pBuD938qKtue2F2OJX80St+//W/+9Q3sw3y/wMnlR3RjyMAAA==");
}
