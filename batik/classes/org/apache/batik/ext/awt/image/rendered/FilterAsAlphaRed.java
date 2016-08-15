package org.apache.batik.ext.awt.image.rendered;
public class FilterAsAlphaRed extends org.apache.batik.ext.awt.image.rendered.AbstractRed {
    public FilterAsAlphaRed(org.apache.batik.ext.awt.image.rendered.CachableRed src) {
        super(
          new org.apache.batik.ext.awt.image.rendered.Any2LumRed(
            src),
          src.
            getBounds(
              ),
          new java.awt.image.ComponentColorModel(
            java.awt.color.ColorSpace.
              getInstance(
                java.awt.color.ColorSpace.
                  CS_GRAY),
            new int[] { 8 },
            false,
            false,
            java.awt.Transparency.
              OPAQUE,
            java.awt.image.DataBuffer.
              TYPE_BYTE),
          new java.awt.image.PixelInterleavedSampleModel(
            java.awt.image.DataBuffer.
              TYPE_BYTE,
            src.
              getSampleModel(
                ).
              getWidth(
                ),
            src.
              getSampleModel(
                ).
              getHeight(
                ),
            1,
            src.
              getSampleModel(
                ).
              getWidth(
                ),
            new int[] { 0 }),
          src.
            getTileGridXOffset(
              ),
          src.
            getTileGridYOffset(
              ),
          null);
        props.
          put(
            org.apache.batik.ext.awt.ColorSpaceHintKey.
              PROPERTY_COLORSPACE,
            org.apache.batik.ext.awt.ColorSpaceHintKey.
              VALUE_COLORSPACE_ALPHA);
    }
    public java.awt.image.WritableRaster copyData(java.awt.image.WritableRaster wr) {
        org.apache.batik.ext.awt.image.rendered.CachableRed srcRed =
          (org.apache.batik.ext.awt.image.rendered.CachableRed)
            getSources(
              ).
            get(
              0);
        java.awt.image.SampleModel sm =
          srcRed.
          getSampleModel(
            );
        if (sm.
              getNumBands(
                ) ==
              1)
            return srcRed.
              copyData(
                wr);
        java.awt.image.Raster srcRas =
          srcRed.
          getData(
            wr.
              getBounds(
                ));
        java.awt.image.PixelInterleavedSampleModel srcSM;
        srcSM =
          (java.awt.image.PixelInterleavedSampleModel)
            srcRas.
            getSampleModel(
              );
        java.awt.image.DataBufferByte srcDB =
          (java.awt.image.DataBufferByte)
            srcRas.
            getDataBuffer(
              );
        byte[] src =
          srcDB.
          getData(
            );
        java.awt.image.PixelInterleavedSampleModel dstSM;
        dstSM =
          (java.awt.image.PixelInterleavedSampleModel)
            wr.
            getSampleModel(
              );
        java.awt.image.DataBufferByte dstDB =
          (java.awt.image.DataBufferByte)
            wr.
            getDataBuffer(
              );
        byte[] dst =
          dstDB.
          getData(
            );
        int srcX0 =
          srcRas.
          getMinX(
            ) -
          srcRas.
          getSampleModelTranslateX(
            );
        int srcY0 =
          srcRas.
          getMinY(
            ) -
          srcRas.
          getSampleModelTranslateY(
            );
        int dstX0 =
          wr.
          getMinX(
            ) -
          wr.
          getSampleModelTranslateX(
            );
        int dstX1 =
          dstX0 +
          wr.
          getWidth(
            ) -
          1;
        int dstY0 =
          wr.
          getMinY(
            ) -
          wr.
          getSampleModelTranslateY(
            );
        int srcStep =
          srcSM.
          getPixelStride(
            );
        int[] offsets =
          srcSM.
          getBandOffsets(
            );
        int srcLOff =
          offsets[0];
        int srcAOff =
          offsets[1];
        if (srcRed.
              getColorModel(
                ).
              isAlphaPremultiplied(
                )) {
            for (int y =
                   0;
                 y <
                   srcRas.
                   getHeight(
                     );
                 y++) {
                int srcI =
                  srcDB.
                  getOffset(
                    ) +
                  srcSM.
                  getOffset(
                    srcX0,
                    srcY0);
                int dstI =
                  dstDB.
                  getOffset(
                    ) +
                  dstSM.
                  getOffset(
                    dstX0,
                    dstY0);
                int dstE =
                  dstDB.
                  getOffset(
                    ) +
                  dstSM.
                  getOffset(
                    dstX1 +
                      1,
                    dstY0);
                srcI +=
                  srcLOff;
                while (dstI <
                         dstE) {
                    dst[dstI++] =
                      src[srcI];
                    srcI +=
                      srcStep;
                }
                srcY0++;
                dstY0++;
            }
        }
        else {
            srcAOff =
              srcAOff -
                srcLOff;
            for (int y =
                   0;
                 y <
                   srcRas.
                   getHeight(
                     );
                 y++) {
                int srcI =
                  srcDB.
                  getOffset(
                    ) +
                  srcSM.
                  getOffset(
                    srcX0,
                    srcY0);
                int dstI =
                  dstDB.
                  getOffset(
                    ) +
                  dstSM.
                  getOffset(
                    dstX0,
                    dstY0);
                int dstE =
                  dstDB.
                  getOffset(
                    ) +
                  dstSM.
                  getOffset(
                    dstX1 +
                      1,
                    dstY0);
                srcI +=
                  srcLOff;
                while (dstI <
                         dstE) {
                    int sl =
                      src[srcI] &
                      255;
                    int sa =
                      src[srcI +
                            srcAOff] &
                      255;
                    dst[dstI++] =
                      (byte)
                        (sl *
                           sa +
                           128 >>
                           8);
                    srcI +=
                      srcStep;
                }
                srcY0++;
                dstY0++;
            }
        }
        return wr;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1Ya2wU1xW+u34bvwFDDTZgDCmP7oASqlKTNGaxg8nauDYh" +
       "6tKw3J256x08OzPM3LHXTtMmkSqIWiFESUIrxb8cRanSJKqaPqQmchWpSZS2" +
       "UlLUNq1CK/VP+kANqpT+oK9z7szszM6uIfRHV5q7s/eee+55fufcfeEaqbMt" +
       "0sd0nuDzJrMTwzqfoJbNlKRGbfsYzGXkp2vo309+ML4/TurTpC1P7TGZ2mxE" +
       "ZZpip0mvqtuc6jKzxxlTcMeExWxmzVKuGnqarFXt0YKpqbLKxwyFIcFxaqVI" +
       "J+XcUrMOZ6MeA056UyCJJCSRhqLLgynSIhvmfEC+PkSeDK0gZSE4y+akI3Wa" +
       "zlLJ4aompVSbDxYtsss0tPlpzeAJVuSJ09o+zwRHUvsqTND/cvtHNy7kO4QJ" +
       "VlNdN7hQz55ktqHNMiVF2oPZYY0V7DPky6QmRVaFiDkZSPmHSnCoBIf62gZU" +
       "IH0r051C0hDqcJ9TvSmjQJxsKWdiUosWPDYTQmbg0Mg93cVm0HZzSVtXywoV" +
       "n9wlXXr6ZMd3a0h7mrSr+hSKI4MQHA5Jg0FZIcsse0hRmJImnTo4e4pZKtXU" +
       "Bc/TXbY6rVPugPt9s+CkYzJLnBnYCvwIulmOzA2rpF5OBJT3qy6n0WnQtTvQ" +
       "1dVwBOdBwWYVBLNyFOLO21I7o+oKJ5uiO0o6DtwPBLC1ocB43igdVatTmCBd" +
       "bohoVJ+WpiD09GkgrTMgAC1OelZkirY2qTxDp1kGIzJCN+EuAVWTMARu4WRt" +
       "lExwAi/1RLwU8s+18QPnH9YP63ESA5kVJmso/yrY1BfZNMlyzGKQB+7Glp2p" +
       "p2j3q+fihADx2gixS/ODL12/d3ff8psuzYYqNEezp5nMM/JStu2djckd+2tQ" +
       "jEbTsFV0fpnmIssmvJXBogkI013iiIsJf3F58qdfePTb7C9x0jxK6mVDcwoQ" +
       "R52yUTBVjVn3MZ1ZlDNllDQxXUmK9VHSAO8pVWfu7NFczmZ8lNRqYqreEL/B" +
       "RDlggSZqhndVzxn+u0l5XrwXTUJIAzykBZ5PEvcjvjmZkfJGgUlUprqqG9KE" +
       "ZaD+tgSIkwXb5qUsRP2MZBuOBSEoGda0RCEO8sxbwMykc1xSC+B+CdyhgE8U" +
       "aUTVIKCG7CHNzNNJpiQw6Mz/73FF1H71XCwGjtkYhQUNMuqwocH2jHzJOTh8" +
       "/cXM227IYZp4duPkMyBBwpUgISQQIAoSJIQECV+CRFQCEouJg9egJG40gC9n" +
       "ABUAllt2TD105NS5/hoIQ3OuFhyBpP1l5SkZQIeP9xn5pa7WhS1X974eJ7Up" +
       "0kVl7lANq82QNQ04Js94qd6ShcIV1I/NofqBhc8yZKYAfK1URzwujcYss3Ce" +
       "kzUhDn51wzyWVq4tVeUny5fnHjv+lT1xEi8vGXhkHaAdbp9AoC8B+kAUKqrx" +
       "bT/7wUcvPfWIEYBGWQ3yS2fFTtShPxoaUfNk5J2b6SuZVx8ZEGZvAlDnFJIQ" +
       "8LIvekYZJg36+I66NILCOcMqUA2XfBs387xlzAUzImY7xfsaCItVmKQb4Nnj" +
       "Za34xtVuE8d1boxjnEW0EPXj7inzmd/84k93CnP7paY91CNMMT4Ygjdk1iWA" +
       "rDMI22MWY0D3/uWJbzx57ewJEbNAsbXagQM4JgHWwIVg5q++eea9319duhIP" +
       "4pxDfXey0CYVS0riPGm+iZJw2vZAHoBHDTADo2bgAR3iU82pNKsxTKx/tm/b" +
       "+8pfz3e4caDBjB9Gu2/NIJj/xEHy6Nsn/9En2MRkLM+BzQIyF/NXB5yHLIvO" +
       "oxzFx97t/eYb9BmoHoDYtrrABAjHvFxHodZzcufHBZckkKCEgCvC4fsEhz1i" +
       "vAuNJfgSsbYfh212OHHKczPUgmXkC1c+bD3+4WvXhablPVw4TsaoOeiGJg7b" +
       "i8B+XRTYDlM7D3R3LY9/sUNbvgEc08BRBhi3j1qgR7Esqjzquobf/uT17lPv" +
       "1JD4CGnWDKqMUJGgpAkyg9l5gOii+bl73cCYa4ShQ6hKKpSvmEDnbKru9uGC" +
       "yYWjFn647nsHnlu8KiLUdHlsCDO8A4ddpVgVn/poGQ3HahkHi/Su1OmILm3p" +
       "8UuLytFn97r9SFd59zAMzfF3fvWvnyUu/+GtKqWpiRvmpzQ2y7TQmVhHesvq" +
       "yJhoAgMse7/t4h9/NDB98HZKCM713aJI4O9NoMTOlUtCVJQ3Hv9zz7F78qdu" +
       "oxpsipgzyvL5sRfeum+7fDEuOl63EFR0yuWbBsOGhUMtBq29jmriTKsI+62l" +
       "AOhBx/bDM+wFwHB1RK4SOyWcW2lrJKsjaNErQjlAhwctlQtQoDZ0HuLY4zfB" +
       "hTQOn+ekEe+Whyin+PtBQfpZHCbdeL/7f8w1nEiaRbiCRjshTMP1Fbcy9yYh" +
       "v7jY3rhu8YFfi2gsdfstEFc5R9NCbgm7qN60WE4VWrW4qGSKrywnd3xMSAU7" +
       "+K9CF+pygFan7+YcOKkT3+FdebgWrLSLkxoYw9Qz0E5VowZKGMOUcN3oiFLC" +
       "+eI7THeGk+aADiqs+xImQe5Agq+Oedv1ZygLjRNABdafWCVGivhZe6v4CYHi" +
       "1jKMEBd7P58d92oPre7ikfGHr3/6Wbd3kTW6sCAugnCvdduoEiZsWZGbz6v+" +
       "8I4bbS83bYt7udDpChxk6oZQoiQh50wM2p5IYbcHSvX9vaUDr/38XP27AMsn" +
       "SIxysvpE6Frt3iGhO3AAjE+kAjgO/TEkOo7BHd+av2d37m+/E+XHg++NK9Nn" +
       "5CvPPfTLi+uXoDNZNQqRCP4ppkmzah+a1yeZPGulSatqDxdBROCiUm2UNDq6" +
       "esZho0qKtGF+UbzyC7t45mwtzWLny0l/xd2+yn0BSvUcsw4ajq4IlAT8DmbK" +
       "/nHwYdUxzciGYKbkyjWVumfkQ0+0//hCV80IYESZOmH2DbaTLUF2+E+IAMM7" +
       "XCD+D3xi8PwbH3Q6Trh34a6kdyHfXLqRQ0/grtVkUmOm6dM2fd90s+gsDk8U" +
       "cZ6T2E5vNoTe+PPr4vyviVcczv8XeXIW+JAUAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "NadvdwkgAAA=");
}
