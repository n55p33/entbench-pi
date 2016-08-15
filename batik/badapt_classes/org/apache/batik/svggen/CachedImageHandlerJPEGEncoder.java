package org.apache.batik.svggen;
public class CachedImageHandlerJPEGEncoder extends org.apache.batik.svggen.DefaultCachedImageHandler {
    public static final java.lang.String CACHED_JPEG_PREFIX = "jpegImage";
    public static final java.lang.String CACHED_JPEG_SUFFIX = ".jpg";
    protected java.lang.String refPrefix = "";
    public CachedImageHandlerJPEGEncoder(java.lang.String imageDir, java.lang.String urlRoot)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        super(
          );
        refPrefix =
          urlRoot +
          "/";
        setImageCacher(
          new org.apache.batik.svggen.ImageCacher.External(
            imageDir,
            CACHED_JPEG_PREFIX,
            CACHED_JPEG_SUFFIX));
    }
    public void encodeImage(java.awt.image.BufferedImage buf, java.io.OutputStream os)
          throws java.io.IOException { org.apache.batik.ext.awt.image.spi.ImageWriter writer =
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
    public int getBufferedImageType() { return java.awt.image.BufferedImage.
                                                 TYPE_INT_RGB;
    }
    public java.lang.String getRefPrefix() {
        return refPrefix;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1ZfWwcxRUfnxPHn7HjkA9C4nw5pAlwl1BChZwCiX2OnZ7j" +
       "kx0icAqXub25u032dpfdWfsSmhaQUEKrIhrCVwX5ow0CIiCoKoKKgkJRCwha" +
       "ie/SCqjaSqWlqERVaVXa0vdmdm8/7iON1NbSzc3NvPdm3ps3v/fe+JGPyGzb" +
       "In1M53G+32R2PKnzNLVslhvUqG3vhLGMcncz/fN1H+y4LEZapsjcIrXHFGqz" +
       "YZVpOXuKLFN1m1NdYfYOxnLIkbaYzaxpylVDnyILVHu0ZGqqovIxI8eQYBe1" +
       "UmQe5dxSsw5no64ATpalYCcJsZPEluj0QIp0Koa53ydfHCAfDMwgZclfy+ak" +
       "J7WXTtOEw1UtkVJtPlC2yAWmoe0vaAaPszKP79U2uSbYntpUZYJVj3d/8unt" +
       "xR5hgvlU1w0u1LMnmG1o0yyXIt3+aFJjJft68lXSnCIdAWJO+lPeoglYNAGL" +
       "etr6VLD7LqY7pUFDqMM9SS2mghviZGVYiEktWnLFpMWeQUIrd3UXzKDtioq2" +
       "UssqFe+8IHH07ut6vtdMuqdIt6pP4nYU2ASHRabAoKyUZZa9JZdjuSkyT4fD" +
       "nmSWSjX1gHvSvbZa0Cl34Pg9s+CgYzJLrOnbCs4RdLMchRtWRb28cCj31+y8" +
       "Rgug60JfV6nhMI6Dgu0qbMzKU/A7l2XWPlXPcbI8ylHRsf9LQACsc0qMF43K" +
       "UrN0CgOkV7qIRvVCYhJcTy8A6WwDHNDiZEldoWhrkyr7aIFl0CMjdGk5BVRt" +
       "whDIwsmCKJmQBKe0JHJKgfP5aMfm227QR/QYaYI955ii4f47gKkvwjTB8sxi" +
       "cA8kY+f61F104TOHY4QA8YIIsaR58iunr7yw79SLkua8GjTj2b1M4RnleHbu" +
       "q0sH113WjNtoNQ1bxcMPaS5uWdqdGSibgDALKxJxMu5Nnpr4yTU3nmAfxkj7" +
       "KGlRDM0pgR/NU4ySqWrM2sZ0ZlHOcqOkjem5QTE/SuZAP6XqTI6O5/M246Nk" +
       "liaGWgzxG0yUBxFoonboq3re8Pom5UXRL5uEkDnwIZ3wWU3kn/jmpJgoGiWW" +
       "oArVVd1IpC0D9bcTgDhZsG0xkQWv35ewDccCF0wYViFBwQ+KzJuYLhSYnhjE" +
       "odxoCXxghOo5UGp7OrktqSsAT1YcPc78P65VRr3nzzQ1wZEsjQKCBndpxNCA" +
       "NqMcdbYmTz+WeVk6G14Q12KcbILl43L5uFg+LpePN1yeNDWJVc/BbUgngCPc" +
       "B2AAaNy5bvLa7XsOr2oG7zNnZoH9kXRVKCoN+ojhwXxGOdnbdWDlexufj5FZ" +
       "KdJLFe5QDYPMFqsA8KXsc294ZxbilR82VgTCBsY7y1BYDlCrXvhwpbQa08zC" +
       "cU7OCUjwghpe30T9kFJz/+TUPTM37frahhiJhSMFLjkbQA7Z04jvFRzvjyJE" +
       "Lbndhz745ORdBw0fK0Khx4uYVZyow6qoX0TNk1HWr6BPZJ452C/M3gZYzinc" +
       "PYDJvugaISga8GAddWkFhfOGVaIaTnk2budFy5jxR4TDzhP9c8AtOvBufg4+" +
       "G9zLKr5xdqGJ7SLp4OhnES1E2PjipHn/z3/2+88Lc3sRpjuQGkwyPhBANRTW" +
       "K/Brnu+2Oy3GgO7de9J33PnRod3CZ4Fida0F+7EdBDSDIwQz3/Li9e+8/97x" +
       "N2K+n3MI604WsqNyRUkcJ+0NlITVzvf3A6ioAVqg1/RfpYN/qnmVZjWGF+sf" +
       "3Ws2PvHH23qkH2gw4rnRhWcW4I+fu5Xc+PJ1f+0TYpoUjMq+zXwyCfXzfclb" +
       "LIvux32Ub3pt2b0v0PshaABQ2+oBJrA3JmwQE5ovhiRNcGIAjssAjOOXiiPd" +
       "JGg2iPYStJuLEi7nhnqYNLlr2zaLmkVVsS8eGh1PlhVm4laF0MuwWWMH71T4" +
       "2gaSsoxy+xsfd+36+NnTwgjhrC7oQmPUHJBei835ZRC/KIp5I9QuAt0lp3Z8" +
       "uUc79SlInAKJCmC7PW4BWJZDDudSz57zi+eeX7jn1WYSGybtmkFzw1TcXdIG" +
       "l4bZRYDusnnFldJnZlqh6cFemVSsRoTVSLlqAM9teW2PSJZMLs7wwFOLvr/5" +
       "wWPvCec1pYzzBH8zRpMQWIvawMeLE69/4c0Hv3XXjMwu1tUHyQjf4r+Pa9mb" +
       "f/23KpMLeKyR+UT4pxKP3Ldk8PIPBb+PU8jdX66OgID1Pu/FJ0p/ia1q+XGM" +
       "zJkiPYqbi++imoO3fwryT9tL0CFfD82Hc0mZOA1UcHhpFCMDy0YR0o+80Edq" +
       "7HdFQHExHiEee7+LF/1RUGwCmGnba7KCCM44Nia414p2PTYXyZPEbhwwyRbJ" +
       "P4fdqDrVIti0qMFaoPvglsGR5FAGg38mPZEcHr1a3GOJzNhuxmaHFHpFXYfd" +
       "FlZwAD5r3EXX1FJwVnyvKRDj6ka6YTOBzWQNperJjyg1edVwHaWu+c+VmutZ" +
       "b6276NoqpYjo0Nrq4JGalsHBt1guoktXA7HAZrE8lOh5tVxLhWwDFeTUWmwu" +
       "qKwo/lpIJIEOhisfKQjC4bJ6NY6oz47ffPRYbvyBjRIresN1QxLK4kff+ucr" +
       "8Xt+9VKN1LSNG+ZFGptmWgSdloXQaUyUf/5Vf3fukd/8oL+w9WyySBzrO0Oe" +
       "iL+XgxLr6wNedCsv3PyHJTsvL+45i4RwecScUZEPjz3y0rbzlSMxUetKDKqq" +
       "kcNMA2HkabcYFPX6zhD+rA4nZVe4V9S7qjWSshq+U0l16rFGwn4kYVgqQhad" +
       "4XEVgS2+1cljuilrEI9IVhyqER93uOlwyCwYLYkt3dA4qZjvMUbzhpuwmeak" +
       "g4naRq7WMK6lLbUEGeW0W5EnDva+v+++Dx6VPh4NYhFidvjo1z+L33ZU+rt8" +
       "41hd9cwQ5JHvHGKrPdLUn8FfE3z+hR80MQ7gNyKbW2yvqFTbGN0tsrLRtsQS" +
       "w787efDphw4eQjVwGR1AeNpQcz6YzJwJDxtnJTiQNMW4VfGZbg9jhlyfGTp7" +
       "d6vHGnEIbyP4++4Gc/dicwRcrcB4yAdFIROqZBFXJp2szSOnfHF6j3K4P/1b" +
       "6RLn1mCQdAseSnxz19t7XxEA0YqIVLmWATQC5ArUTz3Y3Crte0ug/w1OmlX3" +
       "fTHo/1A9hdeXSw/d2v3D23ubhwEmR0mro6vXO2w0F4aKObaTDWzIf/PygcPd" +
       "DXogJ03rvVRS+Msd/wN/6cW5PviMuIc+cvb+Uo+1gU881mDucWwe5qQT/GUi" +
       "FIx9U5z4b5iizMmyhs8ymPgvrnoZlq+ZymPHulsXHbvqbREXKy+OneB3eUfT" +
       "gqlpoN9iVrTplImqKb6e4mRRnSoN803REWo8KemfhnowSg/5qPgO0j3LSbtP" +
       "B6JkJ0jyHPg5kGD3R6aH7hvrlYxDLE8djVebrdwUzmQqR7XgTEcVSH5Wh4KE" +
       "eLr3LpojH+8zyslj23fccPrSB+QzhaLRAwdQSgdcL/liUon9K+tK82S1jKz7" +
       "dO7jbWs8jJ4nN+y7/HkBv0zC7TfRJZZEani7v1LKv3N887M/PdzyGoSj3aSJ" +
       "QpjcXV3slE0Hkq7dqWoYgTxJPC4MrPv2/ssvzP/pl6KcdGFnaX36jPLGg9e+" +
       "fmTx8b4Y6RglsyH8sLKowob26xNMmbamSJdqJ8uwRZCiUi2EUXPReym+KQi7" +
       "uObsqoziIxcnq6rDavXTIJTeM8zaajh6zkW5Dn8k9D8FL31yTDPC4I8EYPo7" +
       "EhhlWG7OpMZM0wvT7W+b4kZ/N4rVYlBwvym62Lz1b5FJ0UjWGwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AAA=");
}
