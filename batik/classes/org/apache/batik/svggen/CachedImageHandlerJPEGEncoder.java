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
      1471109864000L;
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
       "EhhlWG7OpMZM0wvT7U+Y4kZ/N4rVYlBwvym62Lz1b+zUJ0DWGwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "QddCVWCDtMuSlXEh4sW5E3rjxZyemLiMlCMn3HBFXVtbYyxGI4zpOXYbc9Ek" +
       "mVEhDgst2qTVsFS2ZrxTp+TqlB7AFqu4mjXvV9uMEvqlCdMgmdWc9MatxqrX" +
       "q/B8wdb0tbFoT+ZGcxlOHabl9abKcEz5Mj6epd0GWM9XhXEQrFoKXKY6HZSM" +
       "wtI6lHvRSqbCkscSznxcqPIdThCrbjcZLxZChV7IZsQvkxGhNhybn/LmDNM6" +
       "a34tLgS0buEEq1UCuK7NU5rxB45YDwhOZnqSzoVTTiyUpbqJY3BS5rRIK6G0" +
       "Oik5eo8qNbQIXYm9tDtGqqRVmE1Za8ZKIlVOrA4XqBVmWK0HErrqtQi8O/b7" +
       "aF0bLCfkiuLWk/pcp6VRUq6WpnGj028Yi6Ylu1PdXyY+KVAtC633TLm9LNYm" +
       "XBjrDSoO7HqXtoe1roLSHbqrqWxR6Kl2oUAOOWQ4F+ZUpVg0DEIlSK27XMfm" +
       "qFYONiAOyss5rJawFoYSo0FnTgyr5TlFBQJXLBuR45NJTFZ4ZhkJ5bY5Mgsi" +
       "1iM4x1I6YrRCgw6G4VOzH7r9ISZupB4r8MVoKq/kNm+IWqPKdDf0phcV+47n" +
       "E8lojDt2Vd0sTbLbtrhGD/U0DumPiQSEk98rBAt0YXUG0mqwNBW7OBw1ET5a" +
       "VNnSbDWiSoMi0isQpf7SMoT2VEs3bTQZ1zYt13VEd4X7Spl17eJ4xjHFqLls" +
       "ODG1wOPpGF86iGl7tOa2jenUrfqTiYxRXh1tVERppDX0RdBGN8vhdI0Xlbgh" +
       "SfUWGs8nRqsWD+FuSkdzRufnjm42XXnj1mcbTR+4xXHbIwf+MlzxQXWEzSVW" +
       "IstsqTjhfNxJ0yEWL5qBOezWa47sbfr1an/Vk2Rxbo9SeKpMlqU2RgyxQhe4" +
       "A2MROJC4pcEMOC/3sUTpN6b0REJq4lhztDor1QrVqtBPiuKaEcgZ2GYX3DaZ" +
       "9p2F26ksZ9ykW3f7sGvq8WzTHsiOKE8blrKJVLPYWnRlmmkpxWFjzvZaq6Ba" +
       "7s4CqVAhFhvRsLhyYaKN6rVgTiZYbd6w6v5srceeOBTQclqXxuSgPjZjTfcU" +
       "HB1Vli06ReDRmB31cFL1BV03aJ3vtRhzKQ6r5AIlzHWLS9dmQjcZ0ZH1lCSK" +
       "A06uxajaRbv6hojmk0XixqWVO0NH/SXWmfqlGrugiWKhjvRwbTFPDUdi5w16" +
       "HWkCxWvA6aqyPF22dHXQngiUMHKWBTGSW0nR3HDEqJHqbEUqV8PBuhapGgG3" +
       "KynT9YsbedWmSZ7xiIHuNHmsWWBNw+s4SIojBbhcZiQ84DwzGraXccLqtWqf" +
       "G027SM13IrgwSPC2NiBlpULjOOtwrozXF0TLkAW0BZNNudbgQcANASvGqACc" +
       "QSrkpl/owg4Ooh4lwN6rn3DjpUTDaN+iRpN0reLVkuFWJysNQzjVm/eRlWNP" +
       "Fua03YIDFZ8GBXbd6RTw1bJT0GLCdzh9Kk0JClaj4kyCWRpTYXQ099yx2VvB" +
       "6SxO6uosVSVLZKh1tMELYxH3woKIrlE20IVqbViA3RrtV3HajofNorvWDa4v" +
       "tamqGQRVczCYGQYr022tYLBzPqQjpmmQju6s5n3G8gupwNjLySTgy0pbx1hL" +
       "n9iEJbTQXhRPp70OiY2IgibwgbtJ4E2gyjBegvvOKNZMsHKS7tBmxx26phhl" +
       "vLjg6kiX8opUZRhVQ9Ty8EU5GksAUizKqXbpul0n2SlRm9KLRiOS+bRIpgas" +
       "KDPSdLDpnG8nYmgvW2mMjaSZTLUtQlxw80YUOE7LkmlnYa30ktRS7AkfcO5o" +
       "wjPWqtqrhMq0wPL0oscEZBy3BszaR4rxlF3XFQnz5mla65RTzusNp9RaiHsK" +
       "0yxVEEJCO2t8NjN7cYSF404yNFXCh1mhYosqUsC7Xo9RugkHj0eEt+myOCMv" +
       "yyzF1kSYHZdNeVYqDTSqgbER0qJRDzEEbAXP2r2UXgIzr0QDhg3bHeBq7Cej" +
       "Ssig9ZbaKBc6EmovBlVsLHV0r1XvNRJ0zqEuXEab8orsyK1hp7npGE1FIWGm" +
       "hWDcuB3X7bYjCmS3Xu8RRN8QCIzwCuxoPkvAmi7qcZxwIs0Sqrxq+BMqNLJV" +
       "RnDZtWYFba7YqrY1vGyzi6bU8TEBbw/otK9HG1votDpeazZX5Za1iKuNoo83" +
       "ZzOsRccTJ1l3uYZZWgql+WhQS6fDvqf4tJlomCJP4o4wjWAJnthRuBBLBbLU" +
       "d1fe3HTRvr8i6LZgBZ1aiGmRuwxnVbJTXfjNsjXQi+Fkw+hgjWspo/HUjqNV" +
       "N3YRy6NoqjnQjUDtDs06IdKl/rzkpgSpqiw3F9dJzeQoXwn62HDDdImlqsKR" +
       "5JdnIVyZdPsYw/fb8KLV9kJ7qvGy5c6GwjgZq0hxouJqtATbE5eB48o0Sfha" +
       "6g/QgWIw8EzbMH4p7ityPVjjbNKhR8GagYmiQXCxIvHSeNFkzRRPUF9MLb63" +
       "GStht9FdrZZSv1ctdJaCKM1b7KyU6g3YrxLOYqIQkwpPrswpH+greIxaWMlv" +
       "tWOHWM4n2mqoCzIxa040vgBjkmVGhuU3qQo10ROwtazg0cACgR7PmfkyxOUq" +
       "sVqY695YTHUvim1FWGqEI3ArctrrlixGHDfbyhSdFptOYy3AaxiGG5vShNWJ" +
       "/lwH2LU2XSyFGRxfjGE/LBOYLlekeFikO+tOu+uzMjN2yi21iaewzpXR3pDU" +
       "+klXnBaS9ao1Ett9NAx8hguDIR+TZVJRG54eE8rQnMRtDqsqfW8opSWwRYrp" +
       "xiZ06JEx7PemxERtL0StYupWorZHHimXwHBOkxITloBhoi0hsiHFnORLNSKp" +
       "yi2KG6wWtdaM9gpByg8ctdMqmXiXYBFMLHGMg9n1oVwNFN7ZpFglJGebZhWd" +
       "r6gJY0+ro2G9WPXHoxSf43U/VNBIQ2JsYFszXB11XASrVnRZmfExIhfWeKOA" +
       "RyBUmjaH2r5bWs8GhRhtEUJ3IAqjxjSlVIRNNImVGzNXo1HcX084Hu4FMhL3" +
       "kZI0LbJroxdREiytRXjswpg2LpcxuxFJ01gproYjpD02WtSmMi6mhAj2XmnP" +
       "TvSgnNistvYdF0AXvAA/OpEVzDrieiVyzVk3gQeOUsOVsTrSVpbn9ivGxB95" +
       "FmWvumJJIWyOc3i3X0Zxrjl1y13FVnXHjXkNKa5YbYCaOMOLIVsr0UsaNZMO" +
       "qxWX7QbOlYQOqa99a75pMM2ybE4U0ZfjcWoPVxw500ZNacJ3ilOd6DYVxsfB" +
       "gdHswOU0CSyzgKuSxPp8DR6musBw1Vge8posMYhljF2n0oXDbrnAY2Y3JeUB" +
       "aYrToGzShNOHExLpLGtrNK2TI5WjF4um4BjkGmO6a7xfLpM9hJXTpO3yJi7w" +
       "9NAzpdkED6wm2lmuSHk1defaaEOzdaLns+sCEgTrlEU8q9SV5HbLEWZ4yWSZ" +
       "tgYWYdUebcoiMS9xAOKSTjlgum7sioXSpt+zRcHmaXlFl6OYW9SNsVFojmcs" +
       "pyQ23B0aZDQQg5WbGtRGclYlvyGsZyOKHim9cioIpl5Kl9NiwykvK41yi8Gx" +
       "ZNQAElHl5px1yaauW9M2OfB6ix4ar0fkGJ4TywXSJ/zJ3KrF68QuFZgUE+F0" +
       "TKONaTuuVrNjbPzybhJuzy9IDjKr38fVyPbVQ1nx6MF9Uv45B53Ixh29rj+8" +
       "bIWyW4H7rpcwzW8Enn3n08/Ig49i2Y1A1tEPofOh6/2IpawV6wir04DT49e/" +
       "/ejl+eLDy9PPvfNf7h29UX/ry8g0PXBCzpMsf6P33Bfar5F+aQc6fXCVelUm" +
       "+3inJ45foF7wlTDyndGxa9T7jmd73rR3u7h/y3iNbM+1r+lyL9jO/YnkwYm0" +
       "w6vzqyshDneN7DJ2F2yCs6TVNi24T7RNAhru7iAKvSjkQ18R7Jz7L9w4NXHn" +
       "fseT2Yf3Z8VTIXSLkqcbD0ezj7jhKoTOrF1DPvTPn3upG56jF/15w7sODHpx" +
       "3z0bewZt/GAMuj9c9vtXb/Du2az4CDCmpoTHrHyQ8Duh+2lj778kuerP/B9U" +
       "vyNrvB88nT3VOz941X/zBu9+OyueC6FbgercsbviQ/0+/nL024TQfTdMX2e5" +
       "uHuu+gfN9l8f0ieeuXjz3c+M/zrP4B78M+M8A92sRpZ1NMdxpH7OO5D6/Dbj" +
       "4eVffxBCd18nAZclLvJKLv/vb+k/E0KXTtKH0Nn8+yjd8yF04ZAOsNpWjpJ8" +
       "FvgIIMmqf+rthxx2vWxgQ1GFyAqvNtvm1HGQPpiSO15qSo7g+iPH0Dj/i9M+" +
       "ckbbPzldkT75DN1/2wulj24z0JIlpGnG5WYGummbDD9A34euy22f17nOYy/e" +
       "9qnzj+6vFLdtBT704yOyPXDtdG/T9sI8QZv+3t2/84Zfe+ar+W39/wJlmKHo" +
       "eyYAAA==");
}
