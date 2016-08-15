package org.apache.batik.ext.awt.image.codec.imageio;
public class PNGTranscoderImageIOWriteAdapter implements org.apache.batik.transcoder.image.PNGTranscoder.WriteAdapter {
    public void writeImage(org.apache.batik.transcoder.image.PNGTranscoder transcoder,
                           java.awt.image.BufferedImage img,
                           org.apache.batik.transcoder.TranscoderOutput output)
          throws org.apache.batik.transcoder.TranscoderException {
        org.apache.batik.transcoder.TranscodingHints hints =
          transcoder.
          getTranscodingHints(
            );
        int n =
          -1;
        if (hints.
              containsKey(
                org.apache.batik.transcoder.image.PNGTranscoder.
                  KEY_INDEXED)) {
            n =
              ((java.lang.Integer)
                 hints.
                 get(
                   org.apache.batik.transcoder.image.PNGTranscoder.
                     KEY_INDEXED)).
                intValue(
                  );
            if (n ==
                  1 ||
                  n ==
                  2 ||
                  n ==
                  4 ||
                  n ==
                  8)
                img =
                  org.apache.batik.ext.awt.image.rendered.IndexImage.
                    getIndexedImage(
                      img,
                      1 <<
                        n);
        }
        org.apache.batik.ext.awt.image.spi.ImageWriter writer =
          org.apache.batik.ext.awt.image.spi.ImageWriterRegistry.
          getInstance(
            ).
          getWriterFor(
            "image/png");
        org.apache.batik.ext.awt.image.spi.ImageWriterParams params =
          new org.apache.batik.ext.awt.image.spi.ImageWriterParams(
          );
        float PixSzMM =
          transcoder.
          getUserAgent(
            ).
          getPixelUnitToMillimeter(
            );
        int PixSzInch =
          (int)
            (25.4 /
               PixSzMM +
               0.5);
        params.
          setResolution(
            PixSzInch);
        try {
            java.io.OutputStream ostream =
              output.
              getOutputStream(
                );
            writer.
              writeImage(
                img,
                ostream,
                params);
            ostream.
              flush(
                );
        }
        catch (java.io.IOException ex) {
            throw new org.apache.batik.transcoder.TranscoderException(
              ex);
        }
    }
    public PNGTranscoderImageIOWriteAdapter() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1456836489000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAM1YfWwcRxWfu/N3/J3ECWniJI4T4dS5TUQCrWxKbddOLj1/" +
                                                              "KHYDODSXud0538Z7u5vdWfvs4pKWjwT+iKLgtim0/stVAbVNhagAQSujSrRV" +
                                                              "AaklAgpqisQfhI+IRkjljwDlzczu7d6ePwh/cdLN7c289+a9N++935t97gYq" +
                                                              "ty3USnQapzMmseP9Oh3Blk2UPg3b9hjMpeQnYvjvJ68P3R1FFeOoPovtQRnb" +
                                                              "ZEAlmmKPo22qblOsy8QeIkRhHCMWsYk1halq6ONoo2oncqamyiodNBTCCI5j" +
                                                              "K4maMKWWmnYoSbgCKNqWBE0kronUE17uSqJa2TBnfPLNAfK+wAqjzPl72RQ1" +
                                                              "Jk/jKSw5VNWkpGrTrryF7jQNbWZCM2ic5Gn8tHbIdcHR5KESF7S92PDBrYvZ" +
                                                              "Ru6C9VjXDcrNs48R29CmiJJEDf5sv0Zy9hn0MIol0boAMUXtSW9TCTaVYFPP" +
                                                              "Wp8KtK8jupPrM7g51JNUYcpMIYp2FgsxsYVzrpgRrjNIqKKu7ZwZrN1RsFZY" +
                                                              "WWLiY3dK80+cbPxuDDWMowZVH2XqyKAEhU3GwaEklyaW3aMoRBlHTToc9iix" +
                                                              "VKyps+5JN9vqhI6pA8fvuYVNOiax+J6+r+AcwTbLkalhFczL8IBy/5VnNDwB" +
                                                              "trb4tgoLB9g8GFijgmJWBkPcuSxlk6quULQ9zFGwsf1+IADWyhyhWaOwVZmO" +
                                                              "YQI1ixDRsD4hjULo6RNAWm5AAFoUbVlRKPO1ieVJPEFSLCJDdCNiCaiquSMY" +
                                                              "C0Ubw2RcEpzSltApBc7nxlD3hYf0I3oURUBnhcga038dMLWGmI6RDLEI5IFg" +
                                                              "rN2bfBy3vHw+ihAQbwwRC5rvf/7mvZ2tS68LmjuWoRlOnyYyTcmL6fq3tvZ1" +
                                                              "3B1jalSZhq2ywy+ynGfZiLvSlTehwrQUJLLFuLe4dOynnz37HfKXKKpJoArZ" +
                                                              "0JwcxFGTbORMVSPWYaITC1OiJFA10ZU+vp5AlfCcVHUiZoczGZvQBCrT+FSF" +
                                                              "wf+DizIggrmoBp5VPWN4zyamWf6cNxFClfBFbfDtQOLzUTZQ9CUpa+SIhGWs" +
                                                              "q7ohjVgGs9+WoOKkwbdZKQ1RPynZhmNBCO47ED8oGdaEhCEWssRdZNmJp6mk" +
                                                              "5iAEJBkqkiyeVRA4dHjMwrrNZq0Em0wMf9pSKelRsAkxF2fRaP6f6JFn/lo/" +
                                                              "HYnAUW4NFxINcvCIoQF7Sp53evtvvpB6UwQpSyzX0xQNglpxoVacq8XLLqgV" +
                                                              "56rEuVpxV634WmqhSIRrs4GpJ4IKQmISigtU99qO0QePnjrfFoNoNqfL4DwZ" +
                                                              "aVsRyvX5FciDjZR8pbludue1A69GUVkSNWOZOlhjoNVjTUA5lCfdilGbBvzz" +
                                                              "YWhHAIYYflqGTBSogivBkSulypgiFpunaENAggeSrBxIK0PUsvqjpcvTjxz/" +
                                                              "wv4oihYjD9uyHIomYx9heFHAhfZwxVlObsO56x9ceXzO8GtPEZR5CFzCyWxo" +
                                                              "C8dL2D0pee8O/FLq5bl27vZqwAaKIZeh7LaG9ygqbV0eTDBbqsDgjGHlsMaW" +
                                                              "PB/X0KxlTPszPJCb2LBRxDQLoZCCHGE+OWo+/Ztf/Olj3JMeGDUEuohRQrsC" +
                                                              "BZAJa+alrsmPyDGLEKB79/LI1x+7ce4ED0eg2LXchu1s7IPCB6cDHvzy62fe" +
                                                              "ee/a4tWoH8IUOgAnDY1Untuy4UP4ROD7b/ZlRYtNiOLV3OdW0B2FEmqynff4" +
                                                              "ukEx1aCQsOBof0CHMFQzKk5rhOXPPxt2H3jprxcaxXFrMONFS+faAvz5j/Si" +
                                                              "s2+e/EcrFxORGZj7/vPJBEKs9yX3WBaeYXrkH3l725Ov4acBa6C+2+os4SUb" +
                                                              "cX8gfoCHuC/28/FgaO0TbNhtB2O8OI0CTVdKvnj1/brj779yk2tb3LUFz30Q" +
                                                              "m10iisQpwGa7kDt4EMJ/2WqLycZNedBhU7hQHcF2FoQdXBr6XKO2dAu2HYdt" +
                                                              "ZSji9rAFRS9fFEoudXnlb3/yasupt2IoOoBqNAMrA5gnHKqGSCd2Fupw3vzU" +
                                                              "vUKP6SoYGrk/UImHSibYKWxf/nz7cyblJzL7g03f63524RoPS1PIuCMocA8f" +
                                                              "O9jQKcKWPe7LF5zFPxUeznq/AWcFZEb482aKukuwgxbAwYWPIsBoD0IF8/62" +
                                                              "lfoq3hMuPjq/oAw/c0B0P83FvUo/tOLP/+pfP4tf/v0by8BaNTXMfRqZIlqR" +
                                                              "4rBlEdwM8pbTL3nv1l/6ww/bJ3pvB2nYXOsaWML+bwcj9q6MHGFVXnv0z1vG" +
                                                              "7smeug3Q2B5yZ1jktwefe+PwHvlSlPfXAi9K+vJipq6gY2FTi8BFQmdmspk6" +
                                                              "nnK7ClG0jgVNO3z3u1EkhVNOVHcekmzoL7DyYK3xWJZhDVWUGD/RmBeK0m2G" +
                                                              "ose3lWeW3+70OhkGZQrvbTyiztWE+zKHHWo6lJv4mZC2keLEWVVbX2B/XiYm" +
                                                              "O3Mu8xQbRimqmWZZJBS0UMcq12VLzQEKTrkXDmmu+b3Jp64/L9IpfDsJEZPz" +
                                                              "81/7MH5hXqSWuMLtKrlFBXnENY5r2siGOEvwnavtwjkG/nhl7kffmjsXddHh" +
                                                              "forKpgxVXAPvYsOYqFLd/2P5ZBO9Zh76wbWaV1ZpN5fcx8UdUn5hoaFq08ID" +
                                                              "v+aVoXDPq4UczziaFkiRYLpUmBbJqNyuWoFOJv85s1xMrdJ3U1TpPnH7TCGF" +
                                                              "Qrf330ihqJz/BnmnoYtbnRe41EISuFyzcKFciYuiGIxB6jnooJejBkoYg5Rn" +
                                                              "KWoMU8L+/DdI90WIfp8OOi/xECT5CkgHEvZ4zvTyrZFnOXuHEBcX5nykFCPv" +
                                                              "Ev3nGsFWYAk2jMwF/H2PV3gd8cYHri4LR4ceuvnxZ0TDKmt4dpa/H0iiStEW" +
                                                              "F4r3zhWlebIqjnTcqn+xereXKkUNc1A3HvJQbnhzuSXUwdnthUbuncXuV35+" +
                                                              "vuJtSPITKIIpWn8i8LZFeAraQAdQ80TSx83A+0LeWnZ1fGPmns7M337H2w8X" +
                                                              "Z7euTJ+Srz774C8vbV6EFnRdAsJMV0h+HNWo9n0z+jEiT1njqE61+/OgIkhR" +
                                                              "sZZAVY6unnFIQkmiepZ8mL0J4n5x3VlXmGU3GYraSotV6f0PWrVpYvUajq5w" +
                                                              "OAOg9WeKXkR5+OeYZojBnykc5YZS21PyfV9t+PHF5tgAFJAic4LiK20nXcDW" +
                                                              "4LspH2zd2iouFLFUctA0vQtG7cOmiPgnBQ2bpyiy150N4BD7+xQX903+yIaF" +
                                                              "/wDOKo9EdhYAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456836489000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAM1afazjWHX3vNmZ2R2WndkFlu12v3egLIFnx86nBii2EyeO" +
       "ndiJkzhxKYM/Yyf+ir/iBLYFRLurIm1pO3y0gv0L1BYtLKqKilRRbVW1gECV" +
       "qFC/pAKqKpWWIrF/lFalLb123nt5783Mblf9p0/Kzc295xyfc+85v3t87nvu" +
       "B9C5MIAKvmevZ7YX7etptD+3y/vR2tfD/Q5b5uUg1DXSlsNwCMauqY994dKP" +
       "fvwR8/IedF6CXiO7rhfJkeW54UAPPTvRNRa6tBtt2roTRtBldi4nMhxHlg2z" +
       "VhhdZaFXHWONoCvsoQowUAEGKsC5CjC+owJMr9bd2CEzDtmNwiX0C9AZFjrv" +
       "q5l6EfToSSG+HMjOgRg+twBIuD37PQZG5cxpAD1yZPvW5hsM/mgBvv7xd1/+" +
       "vbPQJQm6ZLlCpo4KlIjAQyToTkd3FD0IcU3TNQm629V1TdADS7atTa63BN0T" +
       "WjNXjuJAP1qkbDD29SB/5m7l7lQz24JYjbzgyDzD0m3t8Nc5w5ZnwNZ7d7Zu" +
       "LaSycWDgRQsoFhiyqh+y3LawXC2CHj7NcWTjFQYQANYLjh6Z3tGjbnNlMADd" +
       "s907W3ZnsBAFljsDpOe8GDwlgu6/pdBsrX1ZXcgz/VoE3Xeajt9OAao78oXI" +
       "WCLodafJcklgl+4/tUvH9ucHvbc981637e7lOmu6amf63w6YHjrFNNANPdBd" +
       "Vd8y3vlm9mPyvV9+eg+CAPHrThFvaf7gfS++8y0PvfDVLc1P34SGU+a6Gl1T" +
       "P63c9c0HyCfqZzM1bve90Mo2/4TlufvzBzNXUx9E3r1HErPJ/cPJFwZ/Nn3/" +
       "Z/Xv70EXaei86tmxA/zobtVzfMvWg5bu6oEc6RoN3aG7GpnP09AF0GctV9+O" +
       "coYR6hEN3WbnQ+e9/DdYIgOIyJboAuhbruEd9n05MvN+6kMQdAF8oMfA5wlo" +
       "+/emrImgD8Gm5+iwrMqu5XowH3iZ/SGsu5EC1taEFeD1Czj04gC44FuL+yXY" +
       "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" +
       "jh/llxebL73+99/2289+Oy+g/g+dTNtn8yEAAA==");
}
