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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1YaYwcRxWunb0v7+EzPtbX2shHZmwcWzK7OLH3sNeZPeR1" +
       "jFgnHtf01My0t6e73V2zO7vGkERCdoJkLMdJTCArIa0VQEkcIaIQSCKjSCRR" +
       "AMnBAgKKg8QPzGERCyn8MBDeq+qe7umZWcuIMNLU9Lx69areq6++96qfv0Gq" +
       "bYt0MJ2H+ZTJ7HCfzkeoZbNEj0Zt+yDIYsrTlfTvR64P7QyRmjEyL03tQYXa" +
       "rF9lWsIeIytU3eZUV5g9xFgCR4xYzGbWBOWqoY+Rhao9kDE1VVH5oJFgqHCI" +
       "WlHSRjm31HiWswHHACcrorCSiFhJZHewuytKmhTDnPLUl/jUe3w9qJnx5rI5" +
       "aY0eoxM0kuWqFomqNu/KWWSTaWhTKc3gYZbj4WPadicE+6Pbi0Kw5qWWj2+d" +
       "TbeKEMynum5w4Z59gNmGNsESUdLiSfs0lrGPky+Tyihp9Clz0hl1J43ApBGY" +
       "1PXW04LVNzM9m+kxhDvctVRjKrggTlYXGjGpRTOOmRGxZrBQxx3fxWDwdlXe" +
       "W+llkYtPboqcf/pI6/crScsYaVH1UVyOAovgMMkYBJRl4syydycSLDFG2nTY" +
       "7FFmqVRTp52dbrfVlE55FrbfDQsKsyazxJxerGAfwTcrq3DDyruXFIBy/lUn" +
       "NZoCXxd5vkoP+1EODjaosDArSQF3zpCqcVVPcLIyOCLvY+f9oABDazOMp438" +
       "VFU6BQFplxDRqJ6KjAL09BSoVhsAQIuTpWWNYqxNqozTFIshIgN6I7ILtOpF" +
       "IHAIJwuDasIS7NLSwC759ufGUPeZE/o+PUQqYM0Jpmi4/kYY1BEYdIAlmcXg" +
       "HMiBTRujT9FFr58OEQLKCwPKUueVL928b3PH5belzrISOsPxY0zhMWU2Pu/K" +
       "8p4NOytxGXWmYau4+QWei1M24vR05UxgmEV5i9gZdjsvH/jpFx/+HvtLiDQM" +
       "kBrF0LIZwFGbYmRMVWPWXqYzi3KWGCD1TE/0iP4BUgvPUVVnUjqcTNqMD5Aq" +
       "TYhqDPEfQpQEExiiBnhW9aThPpuUp8VzziSE1MKXNMF3E5Ef8csJjaSNDItQ" +
       "heqqbkRGLAP9tyPAOHGIbToSB9SPR2wjawEEI4aVilDAQZq5HROpFNMjAxnY" +
       "/X1UT4A7I0N7+3QFeMkKI9TM/8ckOfR0/mRFBWzC8iAFaHB69hka6MaU89k9" +
       "fTdfjL0r4YVHwokRJ2GYNyznDYt5w3LecOl5SUWFmG4Bzi/3G3ZrHM49EG/T" +
       "htGH9h89vaYSgGZOVkGoUXVNQQLq8cjBZfSYcqm9eXr1ta1vhkhVlLRThWep" +
       "hvlkt5UCplLGncPcFIfU5GWIVb4MganNMhSWAIIqlykcK3XGBLNQzskCnwU3" +
       "f+FJjZTPHiXXTy5fmHzk0Fe2hEioMCnglNXAZzh8BKk8T9mdQTIoZbfl1PWP" +
       "Lz110vBooSDLuMmxaCT6sCYIiGB4YsrGVfTl2OsnO0XY64G2OYVjBozYEZyj" +
       "gHW6XAZHX+rA4aRhZaiGXW6MG3jaMiY9iUBqm3heALBoxGO4Gr7bnHMpfrF3" +
       "kYntYolsxFnAC5EhPj9qPvubX/xpmwi3m0xafFXAKONdPgJDY+2Cqto82B60" +
       "GAO9Dy6MPPHkjVOHBWZBY22pCTux7QHigi2EMH/17ePvf3ht9mrIwzmHDJ6N" +
       "QyGUyzuJctIwh5Mw23pvPUCAGvADoqbzAR3wqSZVGtcYHqx/tqzb+vJfz7RK" +
       "HGggcWG0+fYGPPlde8jD7x75R4cwU6FgAvZi5qlJVp/vWd5tWXQK15F75L0V" +
       "33iLPgv5ATjZVqeZoNmQiEFIeL4E6jExEnNtWOZalO8QW7pd6GwR7T0YN4cl" +
       "nJFbypHR6KG9ey1qplXF/mzvwHBfTmEmLlUY3YnNOtt/pgqPra/+iilnr37U" +
       "fOijN26KIBQWcH4IDVKzS6IWm/U5ML84yHn7qJ0GvXsuDz3Yql2+BRbHwKIC" +
       "bG4PW0CWuQLAOdrVtb/9yZuLjl6pJKF+0qAZNNFPxdkl9XBomJ0Gzs6Z994n" +
       "MTNZB00rPuVIPmpERI3kigS4bytLI6IvY3Kxh9M/XPyD7udmrgnwmtLGMr/B" +
       "z2CzKQ9j8akJ5lA/jAssWGRFuTJHlGizj56fSQxf3CqLkfbC0qEPKuMXfvWv" +
       "n4Uv/P6dErmqnhvm3RqbYJpvziqcsiDFDIoK0KO5D+ad+8Ornak9d5JdUNZx" +
       "m/yB/1eCExvLZ4vgUt569M9LD+5KH72DRLEyEM6gye8OPv/O3vXKuZAod2WO" +
       "KCqTCwd1+QMLk1oM6nod3URJs4D92jwAlrhk3e0AoLs0WQvsiHYjNndLUsDH" +
       "MAeWVnWqBcixdQ6jAaJwEY7/x+boexCbUYBKivHRbDKpCukOoduNzUG5hnv/" +
       "ywOGgj5TyIeLI9TrONN7xxHC5gslwlPO4hwhSM/RdwybuAwP3OSLw6N8CuER" +
       "2X4XfKOOM9E5wlNIPvkcWm5owNdAJlouuJBO8rCK1Wx4DyAC6piEqG1dpSah" +
       "pBrhfrhTiKVkS2cp/Ps5oXACGyCkRiaqYmnOIhvmeOlgqRmoRSaca1vkZPuH" +
       "49+6/oJkweAdL6DMTp9//JPwmfOSEeVFeG3RXdQ/Rl6GxVJbZSw/gU8FfP+N" +
       "X4whCvAX7sY9zo1sVf5KhnnBIqvnWpaYov+Pl07++DsnT4UceN3PSdWEoSY8" +
       "PB3/FPB0F/ZhFqIOKOid46nc0Lnrk/Y8nnrVDNNttwL5+hxH7glsHoex8ayq" +
       "JQoQiD0TXqy+9r+IVQ6qutJXNywOlhS9KJIvN5QXZ1rqFs888GuRI/MvIJog" +
       "2yWzmuZLFv7EUWPmKaRJ1kqm+PkmJ4vLVHJQJ8sHsf5npP4M1IxBfUgZ4tev" +
       "921OGjw9MCUf/CqznFSCCj5eNN1t21aurNwdh5sTFAT+gDnRylUUV0Zilxbe" +
       "bpd8pdDaAkIQ7/LcLJ6Vb/Pg7juzf+jEzR0X5WVG0ej0NFppjJJaea/KVwKr" +
       "y1pzbdXs23Br3kv169zz2CYX7B2HZT5g9gGwTQTF0kClb3fmC/73Z7vf+Pnp" +
       "mveAeg6TCsrJ/MO+N2nytRFcF7JQgh2OekWY712wuIJ0bXhmatfm5N9+J4pO" +
       "It8LLC+vH1OuPvfQL88tmYWrSuMAqQaqYbkx0qDavVP6AaZMWGOkWbX7crBE" +
       "sKJSbYDUZXX1eJYNJKJkHuKX4s1DxMUJZ3NeildhTtYUU2jxCwQo0CeZtcfI" +
       "6gk00wxVmycpeMnonImGrGkGBniS/FYuKPY9pvQ+1vLa2fbKfjiDBe74zdfa" +
       "2Xi+UPO/dxQCyfjYPJKT5F4Ziw6apkv2DVdMeShekToo56RioyMN5LofCXOv" +
       "ikdsXvsPMxu1EVIYAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "uulTr6EjAAA=");
}
