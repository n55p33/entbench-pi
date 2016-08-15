package org.apache.batik.ext.awt.image.rendered;
public class SpecularLightingRed extends org.apache.batik.ext.awt.image.rendered.AbstractTiledRed {
    private double ks;
    private double specularExponent;
    private org.apache.batik.ext.awt.image.Light light;
    private org.apache.batik.ext.awt.image.rendered.BumpMap bumpMap;
    private double scaleX;
    private double scaleY;
    private java.awt.Rectangle litRegion;
    private boolean linear;
    public SpecularLightingRed(double ks, double specularExponent, org.apache.batik.ext.awt.image.Light light,
                               org.apache.batik.ext.awt.image.rendered.BumpMap bumpMap,
                               java.awt.Rectangle litRegion,
                               double scaleX,
                               double scaleY,
                               boolean linear) { super();
                                                 this.ks =
                                                   ks;
                                                 this.specularExponent =
                                                   specularExponent;
                                                 this.light =
                                                   light;
                                                 this.bumpMap =
                                                   bumpMap;
                                                 this.litRegion =
                                                   litRegion;
                                                 this.scaleX =
                                                   scaleX;
                                                 this.scaleY =
                                                   scaleY;
                                                 this.linear =
                                                   linear;
                                                 java.awt.image.ColorModel cm;
                                                 if (linear)
                                                     cm =
                                                       org.apache.batik.ext.awt.image.GraphicsUtil.
                                                         Linear_sRGB_Unpre;
                                                 else
                                                     cm =
                                                       org.apache.batik.ext.awt.image.GraphicsUtil.
                                                         sRGB_Unpre;
                                                 int tw =
                                                   litRegion.
                                                     width;
                                                 int th =
                                                   litRegion.
                                                     height;
                                                 int defSz =
                                                   org.apache.batik.ext.awt.image.rendered.AbstractTiledRed.
                                                   getDefaultTileSize(
                                                     );
                                                 if (tw >
                                                       defSz)
                                                     tw =
                                                       defSz;
                                                 if (th >
                                                       defSz)
                                                     th =
                                                       defSz;
                                                 java.awt.image.SampleModel sm =
                                                   cm.
                                                   createCompatibleSampleModel(
                                                     tw,
                                                     th);
                                                 init(
                                                   (org.apache.batik.ext.awt.image.rendered.CachableRed)
                                                     null,
                                                   litRegion,
                                                   cm,
                                                   sm,
                                                   litRegion.
                                                     x,
                                                   litRegion.
                                                     y,
                                                   null);
    }
    public java.awt.image.WritableRaster copyData(java.awt.image.WritableRaster wr) {
        copyToRaster(
          wr);
        return wr;
    }
    public void genRect(java.awt.image.WritableRaster wr) {
        final double scaleX =
          this.
            scaleX;
        final double scaleY =
          this.
            scaleY;
        final double[] lightColor =
          light.
          getColor(
            linear);
        final int w =
          wr.
          getWidth(
            );
        final int h =
          wr.
          getHeight(
            );
        final int minX =
          wr.
          getMinX(
            );
        final int minY =
          wr.
          getMinY(
            );
        final java.awt.image.DataBufferInt db =
          (java.awt.image.DataBufferInt)
            wr.
            getDataBuffer(
              );
        final int[] pixels =
          db.
          getBankData(
            )[0];
        final java.awt.image.SinglePixelPackedSampleModel sppsm;
        sppsm =
          (java.awt.image.SinglePixelPackedSampleModel)
            wr.
            getSampleModel(
              );
        final int offset =
          db.
          getOffset(
            ) +
          sppsm.
          getOffset(
            minX -
              wr.
              getSampleModelTranslateX(
                ),
            minY -
              wr.
              getSampleModelTranslateY(
                ));
        final int scanStride =
          sppsm.
          getScanlineStride(
            );
        final int adjust =
          scanStride -
          w;
        int p =
          offset;
        int a =
          0;
        int i =
          0;
        int j =
          0;
        double x =
          scaleX *
          minX;
        double y =
          scaleY *
          minY;
        double norm =
          0;
        int pixel =
          0;
        int tmp;
        double mult;
        mult =
          lightColor[0] >
            lightColor[1]
            ? lightColor[0]
            : lightColor[1];
        mult =
          mult >
            lightColor[2]
            ? mult
            : lightColor[2];
        double scale =
          255 /
          mult;
        pixel =
          (int)
            (lightColor[0] *
               scale +
               0.5);
        tmp =
          (int)
            (lightColor[1] *
               scale +
               0.5);
        pixel =
          pixel <<
            8 |
            tmp;
        tmp =
          (int)
            (lightColor[2] *
               scale +
               0.5);
        pixel =
          pixel <<
            8 |
            tmp;
        mult *=
          255 *
            ks;
        final double[][][] NA =
          bumpMap.
          getNormalArray(
            minX,
            minY,
            w,
            h);
        if (light instanceof org.apache.batik.ext.awt.image.SpotLight) {
            org.apache.batik.ext.awt.image.SpotLight slight =
              (org.apache.batik.ext.awt.image.SpotLight)
                light;
            final double[][] LA =
              new double[w][4];
            for (i =
                   0;
                 i <
                   h;
                 i++) {
                final double[][] NR =
                  NA[i];
                slight.
                  getLightRow4(
                    x,
                    y +
                      i *
                      scaleY,
                    scaleX,
                    w,
                    NR,
                    LA);
                for (j =
                       0;
                     j <
                       w;
                     j++) {
                    final double[] N =
                      NR[j];
                    final double[] L =
                      LA[j];
                    double vs =
                      L[3];
                    if (vs ==
                          0) {
                        a =
                          0;
                    }
                    else {
                        L[2] +=
                          1;
                        norm =
                          L[0] *
                            L[0] +
                            L[1] *
                            L[1] +
                            L[2] *
                            L[2];
                        norm =
                          java.lang.Math.
                            sqrt(
                              norm);
                        double dot =
                          N[0] *
                          L[0] +
                          N[1] *
                          L[1] +
                          N[2] *
                          L[2];
                        vs =
                          vs *
                            java.lang.Math.
                            pow(
                              dot /
                                norm,
                              specularExponent);
                        a =
                          (int)
                            (mult *
                               vs +
                               0.5);
                        if ((a &
                               -256) !=
                              0)
                            a =
                              (a &
                                 -2147483648) !=
                                0
                                ? 0
                                : 255;
                    }
                    pixels[p++] =
                      a <<
                        24 |
                        pixel;
                }
                p +=
                  adjust;
            }
        }
        else
            if (!light.
                  isConstant(
                    )) {
                final double[][] LA =
                  new double[w][4];
                for (i =
                       0;
                     i <
                       h;
                     i++) {
                    final double[][] NR =
                      NA[i];
                    light.
                      getLightRow(
                        x,
                        y +
                          i *
                          scaleY,
                        scaleX,
                        w,
                        NR,
                        LA);
                    for (j =
                           0;
                         j <
                           w;
                         j++) {
                        final double[] N =
                          NR[j];
                        final double[] L =
                          LA[j];
                        L[2] +=
                          1;
                        norm =
                          L[0] *
                            L[0] +
                            L[1] *
                            L[1] +
                            L[2] *
                            L[2];
                        norm =
                          java.lang.Math.
                            sqrt(
                              norm);
                        double dot =
                          N[0] *
                          L[0] +
                          N[1] *
                          L[1] +
                          N[2] *
                          L[2];
                        norm =
                          java.lang.Math.
                            pow(
                              dot /
                                norm,
                              specularExponent);
                        a =
                          (int)
                            (mult *
                               norm +
                               0.5);
                        if ((a &
                               -256) !=
                              0)
                            a =
                              (a &
                                 -2147483648) !=
                                0
                                ? 0
                                : 255;
                        pixels[p++] =
                          a <<
                            24 |
                            pixel;
                    }
                    p +=
                      adjust;
                }
            }
            else {
                final double[] L =
                  new double[3];
                light.
                  getLight(
                    0,
                    0,
                    0,
                    L);
                L[2] +=
                  1;
                norm =
                  java.lang.Math.
                    sqrt(
                      L[0] *
                        L[0] +
                        L[1] *
                        L[1] +
                        L[2] *
                        L[2]);
                if (norm >
                      0) {
                    L[0] /=
                      norm;
                    L[1] /=
                      norm;
                    L[2] /=
                      norm;
                }
                for (i =
                       0;
                     i <
                       h;
                     i++) {
                    final double[][] NR =
                      NA[i];
                    for (j =
                           0;
                         j <
                           w;
                         j++) {
                        final double[] N =
                          NR[j];
                        a =
                          (int)
                            (mult *
                               java.lang.Math.
                               pow(
                                 N[0] *
                                   L[0] +
                                   N[1] *
                                   L[1] +
                                   N[2] *
                                   L[2],
                                 specularExponent) +
                               0.5);
                        if ((a &
                               -256) !=
                              0)
                            a =
                              (a &
                                 -2147483648) !=
                                0
                                ? 0
                                : 255;
                        pixels[p++] =
                          a <<
                            24 |
                            pixel;
                    }
                    p +=
                      adjust;
                }
            }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL0Za2wcxXl8dvyKEz/yMnk4ieMQOcAd7waZBhLHIYZzYtkh" +
       "FKfhMrc359t4b3ezO2tfAmkhFJFSlaY0BFpBfgUlIEhoVQRVAaVCLSBoK14F" +
       "SoGqVCotRRBVpVVpS79vZvf2cY9gqe1JO7s7+33ffO/vm7mHPyQzbIt0MZ3H" +
       "+R6T2fEBnQ9Ty2aZfo3a9laYSyn31NK/3PD+5stipH6MzM5Re0ihNtuoMi1j" +
       "j5Elqm5zqivM3sxYBjGGLWYza5Jy1dDHyDzVHsybmqqofMjIMATYRq0kaaec" +
       "W2ra4WzQJcDJkiRwkhCcJNZFP/clSYtimHt88M4AeH/gC0Lm/bVsTtqSu+gk" +
       "TThc1RJJ1eZ9BYucYxrannHN4HFW4PFd2iWuCq5OXlKigu5HWz/59GCuTahg" +
       "DtV1gwvx7BFmG9okyyRJqz87oLG8vZt8hdQmycwAMCc9SW/RBCyagEU9aX0o" +
       "4H4W0518vyHE4R6lelNBhjhZHiZiUovmXTLDgmeg0Mhd2QUySLusKK2UskTE" +
       "u89JHLrnhrYf1JLWMdKq6qPIjgJMcFhkDBTK8mlm2esyGZYZI+06GHuUWSrV" +
       "1L2upTtsdVyn3AHze2rBScdklljT1xXYEWSzHIUbVlG8rHAo921GVqPjIOt8" +
       "X1Yp4UacBwGbVWDMylLwOxelbkLVM5wsjWIUZey5BgAAtSHPeM4oLlWnU5gg" +
       "HdJFNKqPJ0bB9fRxAJ1hgANanCysSBR1bVJlgo6zFHpkBG5YfgKoJqEIROFk" +
       "XhRMUAIrLYxYKWCfDzdffueN+iY9RmqA5wxTNOR/JiB1RZBGWJZZDOJAIras" +
       "Th6m8586ECMEgOdFgCXM4zedvvLcrlPPSZhFZWC2pHcxhaeUo+nZLy3u772s" +
       "FtloNA1bReOHJBdRNux+6SuYkGHmFynix7j38dTIz66/+SH2QYw0D5J6xdCc" +
       "PPhRu2LkTVVj1lVMZxblLDNImpie6RffB0kDPCdVncnZLdmszfggqdPEVL0h" +
       "3kFFWSCBKmqGZ1XPGt6zSXlOPBdMQkgDXKQFrpVE/sSdEz2RM/IsQRWqq7qR" +
       "GLYMlN9OQMZJg25ziTR4/UTCNhwLXDBhWOMJCn6QY+4HjEw6xRNqHsyfAHNk" +
       "wCaZxKjJFEeD/KeO5zj42AjLxNHvzP/7igXUwZypmhowz+JoctAgrjYZGlBI" +
       "KYec9QOnT6RekI6HweJqj5M+YCIumYgLJkQqBSbigom4x0S8DBOkpkasPReZ" +
       "kW4BRp2A9AD5uaV3dMfVOw9014I/mlN1YBEE7Q7VqX4/h3iJP6Wc7Ji1d/k7" +
       "FzwTI3VJ0kEV7lANy846axwSmjLhxnxLGiqYX0iWBQoJVkDLUFgG8lilguJS" +
       "aTQmmYXznMwNUPDKHAZ0onKRKcs/OXXv1C3bvnp+jMTCtQOXnAFpD9GHMeMX" +
       "M3tPNGeUo9t6+/ufnDy8z/CzR6gYeTW0BBNl6I56R1Q9KWX1MvpY6ql9PULt" +
       "TZDdOYVohMTZFV0jlJz6vESPsjSCwFnDylMNP3k6buY5y5jyZ4TbtovnueAW" +
       "MzFau+C6xg1fccev800cF0g3Rz+LSCEKyRdHzfvf+MUfLxLq9mpOa6BZGGW8" +
       "L5DnkFiHyGjtvttutRgDuLfvHf7O3R/evl34LECsKLdgD479kN/AhKDm257b" +
       "/ea77xx9Neb7OYdC76ShXyoUhcR50lxFSFjtbJ8fyJMaZA70mp5rdfBPNavS" +
       "tMYwsP7ZuvKCx/58Z5v0Aw1mPDc698wE/Pmz1pObX7jhb12CTI2CddrXmQ8m" +
       "k/8cn/I6y6J7kI/CLS8v+e6z9H4oI5C6bXUvE9m4UeigMRzrGE+jTtqGuFTz" +
       "YIZJt7BdOLxTOdAz/HtZtM4qgyDh5h1PfHPb67teFEZuxMjHeZR7ViCuIUME" +
       "PKxNKv8z+NXA9W+8UOk4IQtER79bpZYVy5RpFoDz3ip9ZViAxL6Odyfue/8R" +
       "KUC0jEeA2YFDd3wWv/OQtJzsdVaUtBtBHNnvSHFwuAy5W15tFYGx8Q8n9/34" +
       "+L7bJVcd4co9AI3pI7/614vxe3/7fJmCUJ8xwHdlqF6M3lzM3XPD5pEybfh6" +
       "65MHO2o3QtoYJI2Oru522GAmSBS6NdtJB+zlt1FiIigd2oaTmtVgBpxYI7jo" +
       "hDx3hiolipIHnPi8JW29kzeHqOnhdQgnR7gR8H1oImXzscbn5FLXBnjrCzxf" +
       "wUlD2jA0RvWo3vB1oCCkuUR8O78IQQQEEd9GcVhpB0tB2PUCu4uUcvDVj2dt" +
       "+/jp08J84e1JMPOBbNJ32nE4G31nQbRUb6J2DuAuPrX5y23aqU+B4hhQVKA9" +
       "sbdYoKZCKE+60DMafv2TZ+bvfKmWxDaSZs2gmY1UlBzSBLme2TnoOwrmFVfK" +
       "VDfVCEObEJWUCF8ygelmaflENpA3uUg9e59Y8MPLjx15R+RcU9JYVMw7i0M9" +
       "htjk+mXuoVe+8Nqxbx+ekqFRJdAjeJ3/2KKl9//u7yUqF1W9TOxH8McSD9+3" +
       "sH/tBwLfL6+I3VMobd+gRfFxL3wo/9dYd/1PY6RhjLQp7qZyG9UcLFpjsJGy" +
       "vZ0mbDxD38ObIrkD6Cu2D4ujySewbLSwBwO6joeC16/l2IWT+XD1umWuN1rL" +
       "a4h4kPlllRhX43CeVzobTEudhFQcqZ0zqxDlJDZhF0N1jnjcikNWErmuoiem" +
       "wpz3wBV3F4lX4FxafBUOuVIWK2FzKEduAz1QMA0dXLQcw8Y0Ge6E6yJ3yYsq" +
       "MOxUZbgSNiczNEyq+HJVhMvJaXK5GK417jprKnB5U1UuK2Fj3pVJHF8HI3zu" +
       "myaf3XCtdVdaW4HPW6vyWQkbyqqtUI19qZzRv/Y/YPMOHG7zlr2+3LLfmOay" +
       "y+Dqd5ftr7Dst6pqpxI2J02aykfYuNueXxPh9OA0OV0E1yZ3rU0VOD1cldNK" +
       "2KBQPKOgIm8PRdi8pwqbBX+5c4rLiV89iRxcBJYLFDaC1XtJpbMl0fUd3X/o" +
       "SGbLAxfE3J7iStArN8zzNDbJtACpGFIK1cghcZrmF5y3Z9/13o96xtdPZwuO" +
       "c11n2GTj+1Kodqsrl90oK8/u/9PCrWtzO6exm14a0VKU5INDDz9/1dnKXTFx" +
       "dCgrYcmRYxipL1z/mi3GHUsPt7ArinZd6EWp5tpVizqh7zkRlyjuEyuhRnpI" +
       "rzvHd2hhlxRbWNnqXmepHLd9I9Tm0Msh1CNVutDv43Cck0Y8pN9AOcX3E76H" +
       "P3imQKze2eHEDtluHw1v/1cLIeVv9/SVVQm1vLKEUILqk1V08TQOj0OBGWc6" +
       "7gfKNf11k4aa8dXzxH9DPQVO5pQ5a8O2uLPkDwB5aK2cONLauODIta+LeC0e" +
       "LLdA5GUdTQs2boHnetNiWVXI2iLbOLnpep6TVZ9zBwWe4j0KcZ6TFF7kpKs6" +
       "BeguxD2I9UtOOithcVILYxD6ZU7mloMGSBiDkK9B7xWFhPXFPQj3BifNPhxk" +
       "evkQBHkLqAMIPv6muG1c83m3m+vSNrcgmW5VNZYBkxZqwvm96EfzzuRHgZKw" +
       "IpRKxR9JXtpz5F9JKeXkkas333j60gfkEZmi0b17kcpM2JnL07pi6lxekZpH" +
       "q35T76ezH21a6RWZdsmwH6OLAjG0A6LNRM9dGDk/snuKx0hvHr386Z8fqH8Z" +
       "NkbbSQ0F799eumMpmA7UrO3J0hMIKDPiYKuv93t71p6b/egtsSck8sRicWX4" +
       "lPLqsR2v3NV5tCtGZg6CO4KRCmIrtWEPxvukNUZmqfZAAVgEKirVQscbszHI" +
       "KP7FJPTiqnNWcRYPWDnpLj3cKT2Whv3zFLPWG46eEcUEypw/E/qHy6s+jmlG" +
       "EPyZwAHYBpms0Brgt6nkkGl6Z19N75ki3QyUP67A8SPxiMPH/wHd7vnKZB4A" +
       "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "UjO6hD/CJ7uaIhsBquCgwfHOR5EhA6MCWWnEiR1SGJdzDVGv2tYwSQPORlar" +
       "Rtdde418bW84NM4WxKrfZ2eLXGnQO0QjqR2ZS1S8W3rrdWBwqwHXnizEddVR" +
       "FF2d1SKlPstHtErSji1uHauj0kO5J8CqO14ktkclrRZXb+sUbHaqrAcvpXiS" +
       "rMdpxXQmE0tFRJpGdBknFqm6yCIwuaGGdao3qws9rWbP0s66wc9dxjbTBjXL" +
       "4Qbe76QTxTLJRELM7SZrEj2vjwfObifS67zVDNh+ayMnLUsbeTt12+Y6Kj6e" +
       "wSLR2Slmd4or82pQp+qzagNpbXZUty5iru4OCWtlyZQt29Ng480nLGl6ulnl" +
       "LK02mu7GbBozTG0aO5Nu2sJpio18K1oYCM3OOI1ZY2thsDJpTu1ZDklMmJbn" +
       "ejU93vXlhTyoVLE+lU5n40hC2FoaTpJYk4BS2lSu1yJirGqO664mSDZfdGfj" +
       "nBpMl5Lbb0VUO8BrSF9aC6sBn7TmyCKsTxWV2PaX0ozkdi675TPdXTqsxDW2" +
       "8Wo2mMr6rkGY7XYypgSdqwesO/OnDdOkNLo3ZNYCXV0SuCFmbRqxzPZQ8Tu7" +
       "eEyIyFKiXTPA8h4VOkS/sTBMJqDX3YHI95y5JXLT9iBiF9mCmXUMMtcMI9WH" +
       "FXuBi9663dhmkyEvwrRNIKJM9Ge0LJM8DWoo8cTCvFajhXU7XNfktZ7ZmXP1" +
       "XNc2G1aNXEEYy1ZPnnVqIaVmlqJPg4ovszs0bTZrcS9xg2EbWYo6T9GEJg7T" +
       "rIKN04XTp7zezrez5gptaZNBjmFwZUzVRottlWzQWKZ1VEGwxLTGOhNJWiGu" +
       "xMnZ0mXJ4QD4Sh0TDYOoOqTQ0SRfBe1pXpwbprnWhK7EVi3U6fVm4w7BeOu+" +
       "jMyFfoLl47nLC4TGjRyTnDOjXhRKXTgea928JnLwIB6Js/W6uRb77IJzhzg/" +
       "4mTarDVyeyLW4emkM7S27JwkrBnP0R0fGy0qdWrV3WKZOFyDcWW0qaGz7Shy" +
       "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" +
       "FyblzYX8Z975k+/9d69+qdyt/v958qPepikAAA==");
}
