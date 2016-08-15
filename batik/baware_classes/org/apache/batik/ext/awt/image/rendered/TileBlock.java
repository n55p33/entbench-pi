package org.apache.batik.ext.awt.image.rendered;
public class TileBlock {
    int occX;
    int occY;
    int occW;
    int occH;
    int xOff;
    int yOff;
    int w;
    int h;
    int benefit;
    boolean[] occupied;
    TileBlock(int occX, int occY, int occW, int occH, boolean[] occupied,
              int xOff,
              int yOff,
              int w,
              int h) { super();
                       this.occX = occX;
                       this.occY = occY;
                       this.occW = occW;
                       this.occH = occH;
                       this.xOff = xOff;
                       this.yOff = yOff;
                       this.w = w;
                       this.h = h;
                       this.occupied = occupied;
                       for (int y = 0; y < h; y++) for (int x = 0; x < w;
                                                        x++) if (!occupied[x +
                                                                             xOff +
                                                                             occW *
                                                                             (y +
                                                                                yOff)])
                                                                 benefit++;
    }
    public java.lang.String toString() { java.lang.String ret =
                                           "";
                                         for (int y =
                                                0;
                                              y <
                                                occH;
                                              y++) {
                                             for (int x =
                                                    0;
                                                  x <
                                                    occW +
                                                    1;
                                                  x++) {
                                                 if (x ==
                                                       xOff ||
                                                       x ==
                                                       xOff +
                                                       w) {
                                                     if (y ==
                                                           yOff ||
                                                           y ==
                                                           yOff +
                                                           h -
                                                           1)
                                                         ret +=
                                                           "+";
                                                     else
                                                         if (y >
                                                               yOff &&
                                                               y <
                                                               yOff +
                                                               h -
                                                               1)
                                                             ret +=
                                                               "|";
                                                         else
                                                             ret +=
                                                               " ";
                                                 }
                                                 else
                                                     if (y ==
                                                           yOff &&
                                                           x >
                                                           xOff &&
                                                           x <
                                                           xOff +
                                                           w)
                                                         ret +=
                                                           "-";
                                                     else
                                                         if (y ==
                                                               yOff +
                                                               h -
                                                               1 &&
                                                               x >
                                                               xOff &&
                                                               x <
                                                               xOff +
                                                               w)
                                                             ret +=
                                                               "_";
                                                         else
                                                             ret +=
                                                               " ";
                                                 if (x ==
                                                       occW)
                                                     continue;
                                                 if (occupied[x +
                                                                y *
                                                                occW])
                                                     ret +=
                                                       "*";
                                                 else
                                                     ret +=
                                                       ".";
                                             }
                                             ret +=
                                               "\n";
                                         }
                                         return ret;
    }
    int getXLoc() { return occX + xOff; }
    int getYLoc() { return occY + yOff; }
    int getWidth() { return w; }
    int getHeight() { return h; }
    int getBenefit() { return benefit; }
    int getWork() { return w * h + 1; }
    static int getWork(org.apache.batik.ext.awt.image.rendered.TileBlock[] blocks) {
        int ret =
          0;
        for (int i =
               0;
             i <
               blocks.
                 length;
             i++)
            ret +=
              blocks[i].
                getWork(
                  );
        return ret;
    }
    org.apache.batik.ext.awt.image.rendered.TileBlock[] getBestSplit() {
        if (simplify(
              ))
            return null;
        if (benefit ==
              w *
              h)
            return new org.apache.batik.ext.awt.image.rendered.TileBlock[] { this };
        return splitOneGo(
                 );
    }
    public org.apache.batik.ext.awt.image.rendered.TileBlock[] splitOneGo() {
        boolean[] filled =
          (boolean[])
            occupied.
            clone(
              );
        java.util.List items =
          new java.util.ArrayList(
          );
        for (int y =
               yOff;
             y <
               yOff +
               h;
             y++)
            for (int x =
                   xOff;
                 x <
                   xOff +
                   w;
                 x++) {
                if (!filled[x +
                              y *
                              occW]) {
                    int cw =
                      xOff +
                      w -
                      x;
                    for (int cx =
                           x;
                         cx <
                           x +
                           cw;
                         cx++)
                        if (filled[cx +
                                     y *
                                     occW])
                            cw =
                              cx -
                                x;
                        else
                            filled[cx +
                                     y *
                                     occW] =
                              true;
                    int ch =
                      1;
                    for (int cy =
                           y +
                           1;
                         cy <
                           yOff +
                           h;
                         cy++) {
                        int cx =
                          x;
                        for (;
                             cx <
                               x +
                               cw;
                             cx++)
                            if (filled[cx +
                                         cy *
                                         occW])
                                break;
                        if (cx !=
                              x +
                              cw)
                            break;
                        for (cx =
                               x;
                             cx <
                               x +
                               cw;
                             cx++)
                            filled[cx +
                                     cy *
                                     occW] =
                              true;
                        ch++;
                    }
                    items.
                      add(
                        new org.apache.batik.ext.awt.image.rendered.TileBlock(
                          occX,
                          occY,
                          occW,
                          occH,
                          occupied,
                          x,
                          y,
                          cw,
                          ch));
                    x +=
                      cw -
                        1;
                }
            }
        org.apache.batik.ext.awt.image.rendered.TileBlock[] ret =
          new org.apache.batik.ext.awt.image.rendered.TileBlock[items.
                                                                  size(
                                                                    )];
        items.
          toArray(
            ret);
        return ret;
    }
    public boolean simplify() { boolean[] workOccupied =
                                  occupied;
                                for (int y =
                                       0;
                                     y <
                                       h;
                                     y++) {
                                    int x;
                                    for (x =
                                           0;
                                         x <
                                           w;
                                         x++)
                                        if (!workOccupied[x +
                                                            xOff +
                                                            occW *
                                                            (y +
                                                               yOff)])
                                            break;
                                    if (x !=
                                          w)
                                        break;
                                    yOff++;
                                    y--;
                                    h--;
                                }
                                if (h == 0)
                                    return true;
                                for (int y =
                                       h -
                                       1;
                                     y >=
                                       0;
                                     y--) {
                                    int x;
                                    for (x =
                                           0;
                                         x <
                                           w;
                                         x++)
                                        if (!workOccupied[x +
                                                            xOff +
                                                            occW *
                                                            (y +
                                                               yOff)])
                                            break;
                                    if (x !=
                                          w)
                                        break;
                                    h--;
                                }
                                for (int x =
                                       0;
                                     x <
                                       w;
                                     x++) {
                                    int y;
                                    for (y =
                                           0;
                                         y <
                                           h;
                                         y++)
                                        if (!workOccupied[x +
                                                            xOff +
                                                            occW *
                                                            (y +
                                                               yOff)])
                                            break;
                                    if (y !=
                                          h)
                                        break;
                                    xOff++;
                                    x--;
                                    w--;
                                }
                                for (int x =
                                       w -
                                       1;
                                     x >=
                                       0;
                                     x--) {
                                    int y;
                                    for (y =
                                           0;
                                         y <
                                           h;
                                         y++)
                                        if (!workOccupied[x +
                                                            xOff +
                                                            occW *
                                                            (y +
                                                               yOff)])
                                            break;
                                    if (y !=
                                          h)
                                        break;
                                    w--;
                                }
                                return false;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL0aCZAU1fXP7LL3sgfXCuxy7KIBcSaoeGQVhQXcxYHdsIC6" +
       "KEtvz5/dZnu6m+4/7CwEDyrGzaGFiHhEqUqCYgyKsWKOSjSkTDyisUo0McZS" +
       "TGIZE6UiZcUkmmje+79n+piZxk0yTlX/6f7/vf/O/977v/vQcTLBMkkL1ViE" +
       "jRrUiqzQWI9kWjTeoUqWtQ76+uXbSqT3Nr215vwwKesjE4cka7UsWXSlQtW4" +
       "1UeaFc1ikiZTaw2lccToMalFzW0SU3Stj0xRrK6koSqywlbrcYoAGyQzRhok" +
       "xkxlIMVolz0BI80x4CTKOYku9Q+3x0iNrBujDniTC7zDNYKQSYeWxUh9bIu0" +
       "TYqmmKJGY4rF2tMmOd3Q1dFBVWcRmmaRLepiWwWrYotzVDD3obr3P9w9VM9V" +
       "MEnSNJ1x8ay11NLVbTQeI3VO7wqVJq2t5GpSEiPVLmBG2mIZolEgGgWiGWkd" +
       "KOC+lmqpZIfOxWGZmcoMGRliZI53EkMypaQ9TQ/nGWaoYLbsHBmknZ2VVkiZ" +
       "I+Ktp0f33rap/uESUtdH6hStF9mRgQkGRPpAoTQ5QE1raTxO432kQQNj91JT" +
       "kVRlu23pRksZ1CSWAvNn1IKdKYOanKajK7AjyGamZKabWfES3KHspwkJVRoE" +
       "Wac6sgoJV2I/CFilAGNmQgK/s1FKhxUtzsgsP0ZWxrZLAQBQy5OUDelZUqWa" +
       "BB2kUbiIKmmD0V5wPW0QQCfo4IAmI9MLToq6NiR5WBqk/eiRPrgeMQRQlVwR" +
       "iMLIFD8YnwmsNN1nJZd9jq+54KYdWqcWJiHgOU5lFfmvBqQWH9JamqAmhXUg" +
       "EGsWxPZJUx8dCxMCwFN8wALmB184cfHCliNPCZgZeWC6B7ZQmfXLBwYmPj+z" +
       "Y/75JchGhaFbChrfIzlfZT32SHvagAgzNTsjDkYyg0fWPnHFtffTt8OkqouU" +
       "ybqaSoIfNch60lBUal5CNWpKjMa7SCXV4h18vIuUw31M0ajo7U4kLMq6SKnK" +
       "u8p0/gwqSsAUqKIquFe0hJ65NyQ2xO/TBiGkHC5SA9ccIn78n5F4dEhP0qgk" +
       "S5qi6dEeU0f5rShEnAHQ7VB0ALx+OGrpKRNcMKqbg1EJ/GCI2gO4MqURFlWS" +
       "YP4omCMONolH1wFTy1RdHo6gtxmfEp00yjtpJBQCU8z0BwIV1lCnrgJev7w3" +
       "tWzFiQf7nxFOhgvD1hQji4B0RJCOcNI8bALpCCcdyZCOZEmTUIhTnIwsCMOD" +
       "2YYhAEAErpnfe9WqzWNzS8DjjJFS0DmCzvVkog4nSmRCe798uLF2+5zXFj0e" +
       "JqUx0ijJLCWpmFiWmoMQsuRhe1XXDECOclLFbFeqwBxn6jKNQ6QqlDLsWSr0" +
       "bdTEfkYmu2bIJDJcstHCaSQv/+TI7SPXbbjms2ES9mYHJDkBAhui92BMz8bu" +
       "Nn9UyDdv3Q1vvX94307diQ+edJPJkjmYKMNcv0/41dMvL5gtPdL/6M42rvZK" +
       "iN9MgvUGobHFT8MTftozoRxlqQCBE7qZlFQcyui4ig2Z+ojTw521gd9PBrdA" +
       "1yC1cC2yFyj/x9GpBrbThHOjn/mk4Kniwl7j7t8+9+ezuLozWaXOVQ70Utbu" +
       "imQ4WSOPWQ2O264zKQW4V2/vueXW4zds5D4LEK35CLZh2wERDEwIar7+qa0v" +
       "H3vtwIvhrJ+TtFe20gDZgMipDhsQAFUIDugsbes1cEsloUgDKsX19K+6eYse" +
       "eeememF+FXoy3rPw5BM4/acsI9c+s+nvLXyakIwJ2FGVAyai+iRn5qWmKY0i" +
       "H+nrjjbf8aR0N+QHiMmWsp3yMFvJRa/0LnFcRr2pAQuWo5IE7W+zM9aZPZvl" +
       "sbaeN0Q2OiUPgoCbcl/0xg0vbXmW27YCFzz2o9y1ruUMgcHlWPVC+R/DLwTX" +
       "R3ih0rFDRP7GDjv9zM7mH8NIA+fzAwpGrwDRnY3Hhu966wEhgD8/+4Dp2N6v" +
       "fBy5aa+wnChiWnPqCDeOKGSEONich9zNCaLCMVb+6fDOH9+38wbBVaM3Ja+A" +
       "ivOB3/z72cjtrz+dJ/qXKHYhehZG6my8nuy1jRBo+ZfrfrK7sWQlhIouUpHS" +
       "lK0p2hV3zwg1mJUacBnLKY54h1s0NAwjoQVgA+w412m8O5esb3BXFJxcWf3E" +
       "T61vvfmwkDif5/lqpfsOVsivJJ/gnoc0zsku1UZ0jlOgXmBipYp/Ri7/H/N3" +
       "XE9GlwIjJmSy5bqcSiKTdm1QtLnRX+YV9maXBvff2/rcNftbfw8u0UcqFAty" +
       "I6ynPJWqC+fdQ8fePlrb/CBPFaW4LG0re0v83AreU5hz/ddh0yUC5mLb1fHv" +
       "c677JYyUD+i6SiXN76H4uDydx29neuoMvpV1Ut39L5z764M37xsRXhOw6n14" +
       "TR90qwO7/vAPvnxyMnueQODD74seumt6x5K3Ob6TYhG7LZ1buIEpHNwz70/+" +
       "LTy37BdhUt5H6mV767hBUlOYuPpA2VZmPwnbS8+4d+sj6vz2bAkx0x+JXGT9" +
       "yd29wEuZZzE3CEOGCM9rGznGabxdgM0Z3DJhBpvc1ICqQN6ZkFA0SeW450G3" +
       "SrVBUbZfiM0aw7FqWODy5yZmJyWUBXZPukYxv2XGRCWq6JHszhUG8/lHs8c/" +
       "VnO3dJT96sQ9f/xR2+Cy8ZSg2NdykiITn2eBpRcUdjk/K0/u+sv0dUuGNo+j" +
       "mpzl8yP/lN9efejpS06V94T55lh4Qc6m2ovU7rV9lUlZytS84bxVeAC3Xn7z" +
       "8+W6SZicj0WzliF25YTPesDYVmyGwXtkNL3wlABwltOLZc2s/AXTiqTBeImz" +
       "/YfTvnfBwf2v8ZLOSJP8UceXrHjDO88OYGg7NvMsd8nvdQHXOVG/vPvFd2s3" +
       "vPvYiZyA461wV0tGu7MIT8XgP82/JeuUrCGAO/vImivr1SMf8nBfLckQm61u" +
       "E/Z1aU89bENPKP/dzx6fuvn5EhJeSapUXYqvlPjWglRCTU+tIdhVpo2LLhYZ" +
       "c6QCmnouKskRPtcQ2DFiL/MZvLOK36/3Vs+z4Gq1q+dW/87ADjdfFP6Gzem5" +
       "tXchbEZKdVm+PGu9SRx1BzbXC7auLijaf8HkV7H5kiB6RT6iXysC0d0uopfl" +
       "I3pzEYje6iLamY/ovnESnQtXm020rQDROwN9oBA2MJnuTiTyMfn1IjD5DWzu" +
       "AqKjBYh+swhE77WJhkbyUTxYBIrfyVAcykfxUBEoPmRTLIe6mSYUlo/ud8dJ" +
       "twmueTbdeQXoPhLodYWwGZQEspwyFBrH504fo98PYDTtEExmCfJfGfGdcboI" +
       "uoIswfTQXOgYmu8jD+zauz/efc+izCbpIgbxXjfOUOk2qrqmqub3g94t1HS4" +
       "LrXZuNSvNUdQnwScs6oA1ICc+lTA2C+xeRz0zXRx5p+pFOudKtI1wNX/85P5" +
       "ySfJaz7V4BSkDi7Nlk87iWryeFMh1ADxXwoYexmbo7BkBim7PKbLfMk4Wnih" +
       "mFqwbFGs8WuhEGqApG8EjL2JzTGhhStytfB6sbRQz6cQv/T4tVAINUDSEwFj" +
       "72HzDiwT0MJlSlxsxFxqOF4sNTTAtdOWZef41VAINUDUjwqPhfgU/4RoB2ro" +
       "pMrgEPPp4YNi6QFD5y5bmF3j10Mh1ABZqwPGarEpY6QK9LDMlVCzigiVFzM6" +
       "jNnSjI1fEYVQA4RtChibjs0kER0u081hnxYmF0ELqAAyFa4bbVFuDNACb907" +
       "bEbKLP5e3/cOoipgQp/8mUMSfF6Zs1rDM8Qk4p+R4eK83sycauK7xvhaGs+c" +
       "mH6a5IQKY2jo+S6l+3W0XgCIgjAUyW+YMN5uwqZfnH9gsxkbPO4KLcw97sLH" +
       "AWziuedX3GOyfIUW4rMa4MaLA8awSg6dhSOm4CQA9vxCPlzojIRjnRYwI5d+" +
       "dsEFNqcICwxTDmmG6w57Pdwx/jBTCDVA0s6AsVXYdDBSw+OtxXoNlUfc0Gcc" +
       "VSwvgipwh8O3VwdseQ6cRBV5CvZCqAHirg8Yw0OKUA+kHgt10K3RS3SfIj5f" +
       "BEVMwjGMaEdtaY6OXxGFUAOEHQgYw51h6CooySwFv65LjCJQt6OGTf8PNaSh" +
       "1sl+zoFHo005X5GJL5/kB/fXVUzbv/4l8c4n83VSTYxUJFKq6n4v4LovM0yo" +
       "HbjuasQBJX/HF1IZOe0Tfm0CCsjcohChYTGDzkhL8AyMTOD/biyTkaZCWIyU" +
       "QOuGTjEyOR80QELrhgQ11vshgT7/d8PtAL924CBXixs3yNUwO4Dg7TXCS72b" +
       "VfH6Ji1ywAy3eXmBOuVkXuE6BGj1HEHzrwwzbwxS4jvDfvnw/lVrdpw45x7x" +
       "dYWsStv5CXZ1jJSLDz34pPjWYU7B2TJzlXXO/3DiQ5XzMscKDYJhZ2XNcNyf" +
       "jEAOMdAjp/u+QbDasp8ivHzggsd+NVZ2NExCG0lIYmTSxtwXXWkjZZLmjbHc" +
       "F9kbJJN/HNE+/87RJQsTf32Fn/eTnBeIfvh++cWDV72wp+lAS5hUd4GbgXum" +
       "+Ru45aPaWipvM/tIrWKtSAOLMIsiqZ635BNx8Uh45MD1YquzNtuL3+YwMjf3" +
       "A4HcL5qqVH2Emsv0lMbPkWpjpNrpEZbxvbhJGYYPwemxTYltBzbn8c0l+GN/" +
       "bLVhZL6fqHzS4MFjef6Mj467h9/i3S3/Ad1MYi6BLAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "77TNr9jj8MoLL72sTH6pdGH/ISgWQfdH");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("nv8TtrpR7WNDvaOos4dsPJwP/xg4hvtsDE8/cj0C+sO+YPz9c9r+XV78qwi6" +
       "HHlHz0C/fiTX37vbU8HjA57CdrDtAXL3sblvABt0V1j/8Zy2b+fFH0XQJV2N" +
       "FpRXQCkfofrjtwJVuI8qfEtR/fdz2v5HXnx3h2p5O6r/9mZRXStId3/pW4rq" +
       "z+7ctlfM8n+ACQJUvKns70s4gvWnbxZWXnl+H9bzbyWsvSvntD2QF/cBNwBg" +
       "9VRTN6KTuPYuvllcue94YR/XC28prkfOaXs0Lx6KoCsAV+vYa6cjYA+/Favr" +
       "xX1gL76lwJ4+py0faO/x3erivWB1CtUTbwJVDgh6BBy/sI/qF94AqsLLf+1M" +
       "aAdbbPLz5uFsxVu7GxB0Yf+N+O43glZvz7ZlXAqjQJSjfA+xMlOVg61nf5HT" +
       "HZPfabnkr6320P03l3vVs2V8Ia8Wycd+3pEXo8IC8l7I7Ruk8tNJXtC373gq" +
       "lL+btuidny/Osbyb57T9ZF4085aP7Dg5h/ZD6e73nK0+e3kKtvfcHa38A2/C" +
       "you06nFwfGHfyr/wlq7d4Tltuar2OhH0QOGUwojx7cIt7SFH0LpvAlr+Urx4" +
       "U//KPrRX3ugCvmuatsef05bv2NmbAacb5sAmrtr1TqFj3gS6d+UXfwQc39xH" +
       "9823Hp18Tlu+sW3vIyADCE0H4NO2OdGHjrDdeiPYUhByDz9nyDdpP3rbV1S7" +
       "L3/kr7x89fJ7X+b+9W6v78HXOfdT0GUttu3juy+P1S/6AQh5Bdz7d7vb/AKD" +
       "HUE/9jq/tgBAD6o593ur3QheBD1x/ggRdF/xe7xXEEGP3qlXBN0DyuPUcQS9" +
       "+yxqQAnK45RAjNdOU4L5i9/jdB8DRnlEF0EXd5XjJD8LRgckefXjO/d1cvPF" +
       "bpNsuvObjx430SL/u2s6cewm7ZkT+xeLr+wOdoXGu+/sbslffXkw/tj3sV/a" +
       "fRAh22KW5aNcpqBLu28zikHznaVP3XG0g7Eu9p77wTt/5f5nD2773rlj+Gi5" +
       "HOPtybM/QyAdPyo+HMj+yXv/8Qf/7st/UOwF+f+9ZS1a/jgAAA==");
}
