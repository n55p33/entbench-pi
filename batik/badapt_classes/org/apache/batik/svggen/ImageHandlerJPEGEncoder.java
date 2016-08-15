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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Hwpxr4hPbF79D5P816dWGAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "sfHjhdG2Crh8kBnvP5m1jkx7MmcdLingPYPO3s8fTVPfBZ9T4Pnv7MnUnXVs" +
       "l+O7Wns1wcMHRYHrxqdAEjhT2q3tIhl+K6fySN5eypof3pope/0RkC38vKIF" +
       "GKphC2Y+cTsALmZKl/apT0GFC2xyaWnW8gja5sSsRXPwrfnr13WVp7ZQ+eJ3" +
       "x2FMkg6oJt/z9+/94i899lVgvz50ZpPpFpjtSODSYVZg/9xL73/g1ue/9p48" +
       "0YE4nT7z+L/k5Qp9I+myppc1/X2x7svEYvK6gRT8gMpzkyJnkt3YbUeeYYEU" +
       "vtmrHuGn7/rq6kNf/9i2MjzpoyeAlWef/4Xv7j73/M6Revyxq0riozjbmjxn" +
       "+vY9DXvQIzeaJcfo/MMnnv6D33z63Vuu7jpeXeJg8/Sxv/ivL+5+8Gufv0Yx" +
       "c9p0tvnx+zJscDvWrfi9xv6HLPLqLOLieKYOy3W4MsYKUUVq8uiykjQRpMGv" +
       "BIZqSZHCUCSXOII+GIZyqRpi01qIbUK7i5RcDjGmiybnOMZYHwi0y7mEIPir" +
       "SWe2pAmE4bjpGl/PArPJFFkhHDOb0rLeoIpBh0SbpTJbL4klcaOWVHzBsRws" +
       "lESkLNZRrF4Q6VqttKiiKEv4kmVLqYazVZ1iJIaCtXEwKVn10OOkcaVFCjg2" +
       "5eawGrICvC7q3DJoVS3GodDmWIenLttRZFzsU1QcD9s8Vy3EJitJzDidxNay" +
       "SISWxINaEKvCU5MsxgzdrmrrcWXRLvZQFuy0qh4zTe3RrNZY6ouOJtPOasCi" +
       "VFWTkYJEt0KLVoiYhAdxHXbRVXvkpco0QnQenviyQ1NScTTx5l0aZQPMRJP6" +
       "2EY8r99L0lEPU5FUqJB1nyubNUtDsflsWSooqTjud7DE1K1Owi+qqda2rJEv" +
       "ckPCLq7bhLxYlJdVPFwNVqigUokkUxK5QhY6YujUzGvPKhEZzKrGJIEFIdJj" +
       "ZdWZeANBG/eTgNSnS841zXnab48JhuWkulyiJoY/nxLI1HQXi7DHoujItlOP" +
       "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" +
       "kh94/w9s02GsqSMAAA==");
}
