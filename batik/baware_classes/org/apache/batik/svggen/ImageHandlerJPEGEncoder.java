package org.apache.batik.svggen;
public class ImageHandlerJPEGEncoder extends org.apache.batik.svggen.AbstractImageHandlerEncoder {
    public ImageHandlerJPEGEncoder(java.lang.String imageDir, java.lang.String urlRoot)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        super(
          imageDir,
          urlRoot);
    }
    public final java.lang.String getSuffix() { return ".jpg"; }
    public final java.lang.String getPrefix() { return "jpegImage";
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
                    "image/jpeg");
                org.apache.batik.ext.awt.image.spi.ImageWriterParams params =
                  new org.apache.batik.ext.awt.image.spi.ImageWriterParams(
                  );
                params.
                  setJPEGQuality(
                    1,
                    false);
                writer.
                  writeImage(
                    buf,
                    os,
                    params);
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
            TYPE_INT_RGB);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Hwpxr4hPbF79D+1xIr9WGAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "paBMsRR1R1pnQ0WtNByMZyqvVQMan2hCApLkZMozlFyZgCRDez2yp5HrTpvj" +
       "gmhmLfzOygIpd9jme9N5L10kNgandlNq9MTGYGz1164xkMqWUFQqcq1VIOmx" +
       "wcO1PjlfJ2VsNBELldp83dewvjbnO4KdpkiRUVhK4a0eZiTYOozKVR1bphjd" +
       "KrCim6CI1i6TdgkxNLzSaYipptRr666vz9tcbIOFL/RtAg0obq52E1hG6E6J" +
       "Bak+hNuFbqJO+SoobTdtFGkPe24aRmKKYmvd56phqctVZ7pfl+yuNC0X1wXT" +
       "Ughu4LY2qUiaXV+1QM0iph0LQA2aRXxkwcraQ6JArbDmYjYELATzpuORZM+2" +
       "m44YRYXpGpGGHjwv+6uZmBBCb4GamOeGRl2EcbrrTefEqrNYkG3bqI8LY2fV" +
       "c5vlWYI0G51Rq1Rxq00HH/XxVG9uRnW4BGoxFCZaHDJqpWyXZppMWgZV5tqj" +
       "g+w8cWBzq/Jw1W6XRwpfrRawNRmhhO+jSEEkK4OwPXU5TfOWo0GVjW0ynWjY" +
       "aFMga/V+seKHjD6iyu6wn8gTxhxKBcrCpyLBzdrmZLZqz2pytUDDClYkW1W/" +
       "1RVdiVRUEKcGmvYGDEFqxX7s0JNS6PhTBNmwxUINKSq2UI+aNdylxpUZG/Jy" +
       "PbC8qKpt6BZuraOo1Nm0NiO5WfZTUGALbiIXRWJZr80Vo2qwCW813YVaJaRw" +
       "vmiW6hUxIFC7PRPg1YrmGyVyWWl2UnlV5yexlrhafWw6aL/Cd9tcZzDZTGHO" +
       "xdJgSFUKa6STTBJqXna7OEzMCxU0mDBrRWdtd+CrY0wHVRiNdy2xRKbN1dqw" +
       "rKbvF5dmO0JDOzSombzQxoTiigaHYW7AJkatWyzU67O4O50gfjTpp8iQ9Ox2" +
       "kswGoNyKy+0x14NpDbH7ojvvKz3cNKcNGFuos26f3bTiyoqq9IV+gcQZptaN" +
       "3Ngr6yOxXavjcCHuefVZB2yVsi3UlVe3i70z35wfXOB8H9vy7dAjWfOGg3PC" +
       "/HP25KH/0XPCw1MeKNuRPnC9e5l8N/rCu597Xh5+tJDtRjPERQCdCxz3R01l" +
       "o5hHSJ0GlJ64/s6byq+lDk9tPvfuf76PfVJ/26s44n7oBJ8nSf429eIXOm+U" +
       "fmUHuungDOeqC7PjSJePn9yc95Qg9Gz22PnNAweavTfT2CPgecueZt9y7WPm" +
       "a3rBzoEX7DnAiaPL/UO47Hd4g7Eoa8BO/5ymBEyoqkbeix46zPp7bfePUsw7" +
       "rKslJPYkJP6PJHzXDcZ+JmvesZVw5ClXS/j0DyBhflXwJHioPQmpVyHhqVzC" +
       "awp34sz6/vzoS4iCXSO7RdptAkspniLnd0r7QLflQIaz2zZMJaf6S9c+z85+" +
       "lnOA92fNMwF0q5JfRh2S447kCj6ATm8cQz7U2C/8ABp7fdYJg0fe05j8v6Ox" +
       "E2f1dx1oDDcsxfb3T+N/4wae8kLW/DrAFUPDlI/pOBt59lABH341CogD6J7r" +
       "XP5lNxn3XvVvg+0NufSJ5y/ccs/z3F/l918Ht9jnSOgWNTTNoyfER97Pugcu" +
       "fm57XuzmX78DmLjO9UV23Ju/5Jx/bAv/iQC6eBI+gM7k30fhfjeAzh/CAVLb" +
       "l6Mgnw6gmwBI9voZd98+pevdpTREP/AEKTiqsT1txaeOrzUH5rjre5njyPL0" +
       "2LFFJf9DyP4CEG7/EnJF+uTzffrtL1c/ur3Bk0whTTMqt5DQzdvLxINF5JHr" +
       "Utundbb7+Ct3fOrcG/YXvDu2DB86+RHeHrr2dRlhuUF+wZX+wT2ffvNvPv/V" +
       "/MD7fwC+vC2YqSMAAA==");
}
