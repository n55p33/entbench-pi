package org.apache.batik.svggen.font.table;
public class GlyfCompositeComp {
    public static final short ARG_1_AND_2_ARE_WORDS = 1;
    public static final short ARGS_ARE_XY_VALUES = 2;
    public static final short ROUND_XY_TO_GRID = 4;
    public static final short WE_HAVE_A_SCALE = 8;
    public static final short MORE_COMPONENTS = 32;
    public static final short WE_HAVE_AN_X_AND_Y_SCALE = 64;
    public static final short WE_HAVE_A_TWO_BY_TWO = 128;
    public static final short WE_HAVE_INSTRUCTIONS = 256;
    public static final short USE_MY_METRICS = 512;
    private int firstIndex;
    private int firstContour;
    private short argument1;
    private short argument2;
    private short flags;
    private int glyphIndex;
    private double xscale = 1.0;
    private double yscale = 1.0;
    private double scale01 = 0.0;
    private double scale10 = 0.0;
    private int xtranslate = 0;
    private int ytranslate = 0;
    private int point1 = 0;
    private int point2 = 0;
    protected GlyfCompositeComp(java.io.ByteArrayInputStream bais) { super(
                                                                       );
                                                                     flags =
                                                                       (short)
                                                                         (bais.
                                                                            read(
                                                                              ) <<
                                                                            8 |
                                                                            bais.
                                                                            read(
                                                                              ));
                                                                     glyphIndex =
                                                                       bais.
                                                                         read(
                                                                           ) <<
                                                                         8 |
                                                                         bais.
                                                                         read(
                                                                           );
                                                                     if ((flags &
                                                                            ARG_1_AND_2_ARE_WORDS) !=
                                                                           0) {
                                                                         argument1 =
                                                                           (short)
                                                                             (bais.
                                                                                read(
                                                                                  ) <<
                                                                                8 |
                                                                                bais.
                                                                                read(
                                                                                  ));
                                                                         argument2 =
                                                                           (short)
                                                                             (bais.
                                                                                read(
                                                                                  ) <<
                                                                                8 |
                                                                                bais.
                                                                                read(
                                                                                  ));
                                                                     }
                                                                     else {
                                                                         argument1 =
                                                                           (short)
                                                                             bais.
                                                                             read(
                                                                               );
                                                                         argument2 =
                                                                           (short)
                                                                             bais.
                                                                             read(
                                                                               );
                                                                     }
                                                                     if ((flags &
                                                                            ARGS_ARE_XY_VALUES) !=
                                                                           0) {
                                                                         xtranslate =
                                                                           argument1;
                                                                         ytranslate =
                                                                           argument2;
                                                                     }
                                                                     else {
                                                                         point1 =
                                                                           argument1;
                                                                         point2 =
                                                                           argument2;
                                                                     }
                                                                     if ((flags &
                                                                            WE_HAVE_A_SCALE) !=
                                                                           0) {
                                                                         int i =
                                                                           (short)
                                                                             (bais.
                                                                                read(
                                                                                  ) <<
                                                                                8 |
                                                                                bais.
                                                                                read(
                                                                                  ));
                                                                         xscale =
                                                                           (yscale =
                                                                              (double)
                                                                                i /
                                                                                (double)
                                                                                  16384);
                                                                     }
                                                                     else
                                                                         if ((flags &
                                                                                WE_HAVE_AN_X_AND_Y_SCALE) !=
                                                                               0) {
                                                                             short i =
                                                                               (short)
                                                                                 (bais.
                                                                                    read(
                                                                                      ) <<
                                                                                    8 |
                                                                                    bais.
                                                                                    read(
                                                                                      ));
                                                                             xscale =
                                                                               (double)
                                                                                 i /
                                                                                 (double)
                                                                                   16384;
                                                                             i =
                                                                               (short)
                                                                                 (bais.
                                                                                    read(
                                                                                      ) <<
                                                                                    8 |
                                                                                    bais.
                                                                                    read(
                                                                                      ));
                                                                             yscale =
                                                                               (double)
                                                                                 i /
                                                                                 (double)
                                                                                   16384;
                                                                         }
                                                                         else
                                                                             if ((flags &
                                                                                    WE_HAVE_A_TWO_BY_TWO) !=
                                                                                   0) {
                                                                                 int i =
                                                                                   (short)
                                                                                     (bais.
                                                                                        read(
                                                                                          ) <<
                                                                                        8 |
                                                                                        bais.
                                                                                        read(
                                                                                          ));
                                                                                 xscale =
                                                                                   (double)
                                                                                     i /
                                                                                     (double)
                                                                                       16384;
                                                                                 i =
                                                                                   (short)
                                                                                     (bais.
                                                                                        read(
                                                                                          ) <<
                                                                                        8 |
                                                                                        bais.
                                                                                        read(
                                                                                          ));
                                                                                 scale01 =
                                                                                   (double)
                                                                                     i /
                                                                                     (double)
                                                                                       16384;
                                                                                 i =
                                                                                   (short)
                                                                                     (bais.
                                                                                        read(
                                                                                          ) <<
                                                                                        8 |
                                                                                        bais.
                                                                                        read(
                                                                                          ));
                                                                                 scale10 =
                                                                                   (double)
                                                                                     i /
                                                                                     (double)
                                                                                       16384;
                                                                                 i =
                                                                                   (short)
                                                                                     (bais.
                                                                                        read(
                                                                                          ) <<
                                                                                        8 |
                                                                                        bais.
                                                                                        read(
                                                                                          ));
                                                                                 yscale =
                                                                                   (double)
                                                                                     i /
                                                                                     (double)
                                                                                       16384;
                                                                             }
    }
    public void setFirstIndex(int idx) { firstIndex =
                                           idx;
    }
    public int getFirstIndex() { return firstIndex;
    }
    public void setFirstContour(int idx) {
        firstContour =
          idx;
    }
    public int getFirstContour() { return firstContour;
    }
    public short getArgument1() { return argument1;
    }
    public short getArgument2() { return argument2;
    }
    public short getFlags() { return flags;
    }
    public int getGlyphIndex() { return glyphIndex;
    }
    public double getScale01() { return scale01;
    }
    public double getScale10() { return scale10;
    }
    public double getXScale() { return xscale;
    }
    public double getYScale() { return yscale;
    }
    public int getXTranslate() { return xtranslate;
    }
    public int getYTranslate() { return ytranslate;
    }
    public int scaleX(int x, int y) { return java.lang.Math.
                                        round(
                                          (float)
                                            (x *
                                               xscale +
                                               y *
                                               scale10));
    }
    public int scaleY(int x, int y) { return java.lang.Math.
                                        round(
                                          (float)
                                            (x *
                                               scale01 +
                                               y *
                                               yscale));
    }
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
      ("H4sIAAAAAAAAAL18C7Drxnke75V09bCsK8uWrSiSrMf1Q6J9QALgq7ITA+AD" +
       "IPEgCQIkkTbHeJHEG8SDBBE7kV2nVuOMoySy40xtTadxJo7r2GlaT9Nm0ijT" +
       "qZ2M006dZuqkM7UzadOmtT2N2+YxUdp0AfLcc+655xzdI92UM1gud//d/b7d" +
       "f//9F2f3fO7bhdvCoFD0PXszt71oT0+iPdOu7EUbXw/3unSlLwehrhG2HIYj" +
       "kLavPv6Ll//0pecW914sXJIKr5dd14vkyPDccKiHnr3SNbpw+TC1ZetOGBXu" +
       "pU15JUNxZNgQbYTR03ThNUeKRoUr9AEECECAAAQohwBhh1Kg0Gt1N3aIrITs" +
       "RuGy8IOFC3Thkq9m8KLCY9dW4suB7Oyq6ecMQA13ZL9FQCovnASFR69y33K+" +
       "jvDHitDzP/X99/7SLYXLUuGy4fIZHBWAiEAjUuFuR3cUPQgxTdM1qfA6V9c1" +
       "Xg8M2TbSHLdUuC805q4cxYF+tZOyxNjXg7zNw567W824BbEaecFVejNDt7WD" +
       "X7fNbHkOuL7xkOuWYTtLBwTvMgCwYCar+kGRWy3D1aLCm4+XuMrxSg8IgKK3" +
       "O3q08K42dasrg4TCfduxs2V3DvFRYLhzIHqbF4NWosKDp1aa9bUvq5Y81/ej" +
       "wgPH5frbLCB1Z94RWZGocP9xsbwmMEoPHhulI+PzbfZdH/0Bl3Qv5pg1XbUz" +
       "/HeAQo8cKzTUZ3qgu6q+LXj3U/TH5Tf+6rMXCwUgfP8x4a3MP33fd97zjkde" +
       "/I2tzHefIMMppq5G++qnlXu++hDxZOOWDMYdvhca2eBfwzxX//4u5+nEBzPv" +
       "jVdrzDL3DjJfHH5p+sxn9W9eLNxFFS6pnh07QI9ep3qOb9h60NFdPZAjXaMK" +
       "d+quRuT5VOF2EKcNV9+mcrNZqEdU4VY7T7rk5b9BF81AFVkX3Q7ihjvzDuK+" +
       "HC3yeOIXCoXbwVO4GzzfXdh+8u+oMIcWnqNDsiq7hutB/cDL+IeQ7kYK6NsF" +
       "pACtt6DQiwOggpAXzCEZ6MFCP8hYzee6C81A30CRrNg61LE3MwIwy7jrWWQv" +
       "Uzj//19TScb63vWFC2BAHjpuDmwwk0jP1vRgX30+xlvf+fz+Vy5enR67/ooK" +
       "KGh9b9v6Xt763rb1vaz1vbz1vetaL1y4kDf6hgzFVgPA+FnAEgAbefeT/N/q" +
       "vvfZx28BquevbwWdn4lCp5tq4tB2ULmFVIECF178xPoD4g+VLhYuXmtzM+Qg" +
       "6a6seD+zlFct4pXjc+2kei9/+I/+9Asff793OOuuMeI7Y3B9yWwyP368jwNP" +
       "1TVgHg+rf+pR+Yv7v/r+KxcLtwILAaxiJAMtBgbnkeNtXDOpnz4wkBmX2wDh" +
       "mRc4sp1lHVi1u6JF4K0PU/LBvyePvw708T2Zlr8ZPNWd2uffWe7r/Sx8w1ZZ" +
       "skE7xiI3wO/m/U/97r/5b0je3Qe2+vKR1Y/Xo6eP2Iesssu5JXjdoQ6MAl0H" +
       "cv/xE/2f/Ni3P/x9uQIAiSdOavBKFma6BIYQdPMP/8by977x9U//zsVDpYkK" +
       "d/qBF4GZo2vJVZ5ZVuG1Z/AEDb71EBIwMTaoIVOcK4LreJoxMzKdzhT1Ly+/" +
       "pfzFb3303q0q2CDlQJPe8fIVHKZ/F1545ivf/2eP5NVcULMl7rDbDsW2dvP1" +
       "hzVjQSBvMhzJB3774Z/+svwpYIGB1QuNVM8N2YXd3MlA3R8VHspLGt4evon0" +
       "vCzl+nEEVjZddvLBhXLRp/JwL+uVvIJCnodkwZvDo5Pk2nl4xF/ZV5/7nT9+" +
       "rfjH/+I7OaVrHZ6jOsHI/tNbNcyCRxNQ/ZuOWwRSDhdADn2R/Zv32i++BGqU" +
       "QI0qsHshFwDjlFyjQTvp227/D7/+L9/43q/eUrjYLtxle7LWlvPJWLgTzAI9" +
       "XAC7lvjf+56tBqzvAMG9OdXCdeS3mvNA/utBAPDJ0+1QO/NXDqfyA3/B2coH" +
       "/+DPr+uE3AKdsEwfKy9Bn/vkg8T3fDMvf2gKstKPJNcbbODbHZaFP+v8ycXH" +
       "L/2ri4XbpcK96s5xFGU7ziaYBJyl8MCbBM7lNfnXOj7bVf7pq6buoeNm6Eiz" +
       "x43Q4UIB4pl0Fr/rmN15IOvld4Pn4d18fPi43clXiu0YZ5D2KODnzfXgvj/4" +
       "+5/+sw98uH4x0/rbVhl00Cv3Hsqxceaf/p3Pfezh1zz/+x/JDUM2H7JKsbz5" +
       "x/LwSha8LR/fWyLgU8eKbYBJeCnM3d0IUDJc2d4ZkL8Cnwvg+b/ZkwHNErb+" +
       "wX3Ezkl59KqX4oP18X5s2Nkv72Nscx/ex4at/TE3bPJnK1I/MBxgJVc7fw16" +
       "/33fsD75R7+w9cWOa80xYf3Z53/kr/Y++vzFIx7wE9c5oUfLbL3gfFhemwW9" +
       "bB4+dlYreYn2f/3C+3/lM+//8BbVfdf6cy2wXfmFf/9/fmvvE7//myc4DbeB" +
       "GRhE2wUlC9EswLd9XDt1Wr7rWqX5G+B5ZKc0j5ygNFmEAMkXs8jklBHPomQW" +
       "UFnQzXuhBwYTjBqfD9dkui9itNDis5zBMcjTc0Ku79bYg7X2NMi3ZpH3ng/y" +
       "vUNOAEoG8I64/c6Qap4EWD4n4Bp4Ht0BfvQMwHdkkcX5AF8et/ZJTGztY/s8" +
       "gdGtk/AarwDvYzu8j52B99Es4p8TL8MBfSA4ps+xLXZ0okIsz4k3E3t8h/fx" +
       "M/C+J4sk58P7wNX+ZfcnuQGant7Rm3MCfxd4ntgBf+IM4M9kkWfOB/wNh4ox" +
       "GnP7+DT7Ogn0B14B6Cs70FdOB30hT3/2FYKmWH40FIgRxbEnqsjfPSfozD99" +
       "yw70W04HfTFPf+58oO8R+NY+M91nWqMhRZwI98dvHG62ac53y2/bwX3bdXAL" +
       "eeQTJ6MEHvvtfmCswNJ5APCumRGEEeVq+hYGm6dv48OocIvhHl9FfvqceDN3" +
       "4+07vG8/Be/PnII3i37yAOrdOdTs9RjYlmdpLxxD9ulzInsIPE/ukD15CrLP" +
       "3giyO+VgHju6G5VPGuB/+ApgPbWD9dQpsP7RuWDBJ8H6pXPCyuZKcQereAqs" +
       "X74RWIcu7HFI/+yckDKn5B07SO84BdKv3Qiku+b2xl/ks+AkxXrxnLgeBc87" +
       "d7jeeQquL90IrktJqMq2ftLMvKR5wJHWjyH98itAurdDuncK0n97Q0g3OdLs" +
       "11eOYfrqOTFlbgW0wwSdgulrN4Lp9hxSqXwSqN99BaBKO1ClU0B9/cZBlUsn" +
       "gfrGOUFlHm55B6p8Cqg/vCH9T6JAdkMbLAwn6f9/eQW44B0u+BRc37ohXJsz" +
       "cX37FSydyA4Xcgqu/3VD2u57xs7aH8f0v18BJnSHCT0F01/cOCb4JEwvvSym" +
       "rW25AByE2+C92l6mnTvP54ZdnTeZtnrlYIsu6kFoeO4V067l5e+Pjr442P6x" +
       "5xjI3g2DBLvnew4roz13/vRH/vNzv/VjT3wD7IS7B68qMukm6CTxQy89mHn3" +
       "F+46H58HMz58/hcAWg4jJn+xqGtXKR2zx7fa3qugFL3hkyQaUtjBhy4rxART" +
       "k+EkmkjIeDpEOnhas/i1FNbaCO20uQ7FxJvVWCrbxIi255twWOMay1qbZOos" +
       "E9SSjdqhvJYZYWsca47mvuoznjCsLYjBvCcOWskQJ+YUMVItTKQqhKDi3qDb" +
       "JbpNSIclRHI0JFmu+aE4GcGVIEagIlSuNSCyEdUqtdhKWbzbKotTgyoHZWxR" +
       "7vUSsoSVZKWittdFg9RSMlks6MV6vZrVml7KM0tyww6Ga30u4FMutqtzlUUV" +
       "qt+yEqdHUGXOMFgK5fsjr7xsog7TssVFuChtpgYjB5TFL5ORKXIhQzQ9QaPm" +
       "TE+i1xu7Q5WnTZPZ0HNDXCiWg6YionYMoewtlyzcEF1OXiJcabmuLI1oAxNW" +
       "P/CbHbxP9Hili8oLK2Tl0siqjUXSqvfkMByyTBi1mGJZ7s4FaCT0MW+MiCuk" +
       "xKvkMPYquMa0hmJLWsCzkmBxYgLP63wMvNKktCFHQkzZ9UVXbPM12WR4kil5" +
       "6YDhQ27OUv1xMJ+My2XKZrVlrJrzsFTuVbrLLm4SKaMIg5HWIQV5KZPweh2J" +
       "TYrmErUTYfFGbsGCPiRWXGrX69SUrhbrATURm36rwhcjTG1Nk7nXGVBEb2yu" +
       "ywMEjrtJZ1E3mgO/pC0gsSt0xpodNpDxguIFcd7TzWKTQFBmKQ5dPS7F024R" +
       "7yRV3uGXrjeeoFjFhkR9bFGCNe2WF9NUGAbhDMFovIeF/dICw4sS6gg1nxc4" +
       "op8iw65kMog7GAiDYGjYSmvELg1fxMkF3rFKE2sg2B0dbZbLHC/QIoMPZkJH" +
       "ApaKX2yCgWuMjHZ3WjSGges1pAUpOGGvO8DbHT+Ig7okz21YrumhO+wXG3Cg" +
       "uMtN3e90hTkxJTnVMGl5si4TI766mPjLOeeJyRQLxjQV6XQ9QWWyOGj15nVE" +
       "nEhBv28aaR3VEHdU4mcM5zK9MmfpiNVutxdcv9lqNDSnViuZLF2ikt5oJFi1" +
       "/lqtkBuhIc7tYGyxVLhhFCqadsBcImOkUdSbOlc0lYFIiZQ+NnpLrbOe1uUh" +
       "KQoWzC+VKtYrD8QOmrQ2Cz5INBvVqeF4YJa8Hqs14G5CdaRhm++t2EmFDyBy" +
       "s+gNcJYShhOry48X0qonr1sS2l+WhgMjmFOjyTolSIeEGlYXt3RB0PwxjrWH" +
       "Ii2oVDGmXNRs4m23Q881YlBslot1pgP7PTxRmSXibWgKm5kszqzF+YaXxPUg" +
       "FKjuIKVZOsFJq1jCUro1MlujgTcbQW5xWfIWVXhZwbCmbwVmqG6aBM8u/Y3L" +
       "eUl9jC8VVSW1uq4zdoldoLN2e8MFg8mKKuM1A7Y4p7HAl02EjLxRGnXx5pz3" +
       "Gs1ead2f92sKIbWwgUuypQClWQeZrarz1qQFKeIgsKYNsc2JLB8npZgxW8Vu" +
       "VBuN6aiG6mFkrqWuLA1KhNGlgenjmE652nJ6k5hlZMScNJm2K6n1KZFUNrhV" +
       "gWPDHHCUGgW1AJeX4ohcUrVVZ+RyJaHrDEMu6UCyPloH8ghFddiddNdtbYJb" +
       "1lqr+Jg9FgaoSNRxlK2x3hyJ62zTmyhBI0AqpREyqZXJaNBtpTWYdzZp0k3o" +
       "JlUbSrHu0EY4nxCQ0iEb5jCFlxpGdVSi2dxQllCOyZGdLJvCqJS0aaDs3LK/" +
       "9KgOO1zEzJJd9oK4uEaQdl3R+yiqUrHPNZvuGuFkVqQr3YrClZqEJs88pOhb" +
       "NC7V0zSujRQ3sB2lqK9jlxsRjbLpgikIjyPTJzrmaLJBWXEewzA0MlxBL5YH" +
       "aU2PdWQ2Y+NqKnTYhJpOWKdH1waJSqRio4YuuxMEMRsbLMLhel1yZNrveX18" +
       "FPd9ugUWq0Aoci1yQShSt4WLtoy1NB9xUswAJfmBujANGLJhxOcmRa1aXbLl" +
       "Mr4wVWlU9os1TAkbdX3VncSzeNU0u1GFGTBDCZYVNnDkTtGx4Q0MV2lvY5K6" +
       "Tbv+CqmpetuBm/y8hUc8HfpmrYTLNcMUFGbqqKHdHY1Lmp8M6UU0jHC+uZHm" +
       "Pa+WpKOiKIpQt8QqNNHZEPVaK2HshckNJKrWXJTpoLtAUWqCyOuZPoPmzaZh" +
       "I6aulAyhgsvpRGt1mVEpatZHpDqAN/MpUO5VQ+vE9eLK9ioNzCj1B97cWMCx" +
       "OaakqqOmKbW0y+O6HpGkDyeQZvEtO+kvnaFo9OqTYgezBBgThA7TGrhtudjo" +
       "Vfz5LFx6vOVajK3rzXTiYKuUgNRVApudmGmEqxh3Rg1VLa4W5ZqFyM5UUWvz" +
       "ehzNVJczaRHyYYw2zaLGzlb9sVxFdElGxzZik/3uaBZMGsim3htDUEnVK6NU" +
       "b4smGXM8uXZnOkevGi6tV1Z4GRVor+KOiuZgRsCSONOYWYCgPXqToD1r6pmC" +
       "0VB6ukUMhNRQFzBWlsf8GK41q6nh9idDR95Um2OlQ2jVdaXaDCax1Zn1/W6T" +
       "hH1jpQnjylgz2lKdSdMkaNQbydC0irZv6QteblE0xY/EDlSH1DLZDyoWktg4" +
       "2WHtKTyvhu3uqlyMeuiALlYRTWerUBXlijGKw31vXVf602LQr3TcTYpLaxFe" +
       "LJiOQ6UCo6czqkOuoTVG8D5mbHrllG00W1M7iKLVMDJopQMH7jgRwTfi1aZ2" +
       "XNO1CVwJ05TzAerpgHWkjiVgK2IaTXytrLAawkJqvTQbwSi6ojrNsYNUlGI3" +
       "bNLFBup4M4T307SYMgwHS6UxHqIVX6q26iO3jutYJWXrJXJRn8oo0WnEka8b" +
       "RK0N/DI0XsG1EFv01dIqINPEnK2YeQedaYno6Cik913Xk0POmZMKwmJhGkUj" +
       "rjNhRtNSF68wi6hTXbjJNA5n6KpRTCubMfDWfHvM6tM4TaN5A3EnfKVeJEdB" +
       "Kd6odICRNNUMfBqPYCyy2zDSqazGLDFe6Wzs13WZSKRmMW4TPZvpad12b7js" +
       "VtBqhzCYco2bx3o1sswEo0lyCty2tl3CVo5CQf5YWrRGwPrCKetoMc+FSn8u" +
       "K101WrpYh2GZbm3NTR2ZTNZNXCHqzkwyS+1kLk6MAItgXGj0yUVICms2wsaI" +
       "lgK3xC6hmi91e2gatEVeCibWQg4Fpi631InjT3vABULC1CQHWFmra3ADU8ai" +
       "SrX5kC/r7pqmcYFe4bg4dSRjozMbK2wH2BLWmAEczculhPWNmV6OStMK4fUl" +
       "BmOHBF9kCbKM0UyfKxPT/kaYd+ZcsMIhbVnjkLgap8tqcb6qIg2dxoEj1rYt" +
       "uQ05GLdQU7FUmtpdtTd0JFuvekHki33O6+uTiVS2dHO8pvtTIUCmeKOsp+x6" +
       "PZ0M9Z7TRORZtIAqSgyzPg4RRqvGYi2rKSqyHzeswQQtVkLXZBJ6MWAlvxev" +
       "VqBzdKRoATTzIVJF+A6Pzsq+sRQRw+RTCmnUi9MxqHthSHHgrKjGtNLhVmGV" +
       "K7IRPmtpjDpJUJ4UZxuhag1pdGpXHMzsI211SjjrWi8dah2v3zaxqB0JRdNs" +
       "D+wuW563eDE2xgguMSbjFiFKgXVr2KY35fkMVepUQ54V5zxroJGZdsMVZjUb" +
       "C3KkGVOkW+ynpVi2hkuuuS7Wy8PRTBylHrOSh5QHa0S9wfONMt+EmVkjnYz5" +
       "ynLYm/b0EYUQ+jK2rabaYAZt2i47Vdu1p0Vvs/LFGt+0oklboUt2SZSNeb8q" +
       "tVaTzbA6XsWLYCmpJRVOxwgwsWIPAGcXihLbUs0hbQWBo0a315lKhpDUhGF/" +
       "vqY53Q6G0rKKdVHRDiiRXCrFtaYJNOxOmeqUFaSmH8rdti5u2iNeaQzmpGkm" +
       "HNauUUyTdDG9Xp+4vlqCmwiH6m1IqQXMjG5QDNL228FUWIwQBmLMCVibfaKv" +
       "qBtfiBZ6WtexLhwEg1Iw49f1MjvjarDFIDIcEAlwX7Q27Dk1ayHRQilacGvO" +
       "XrlSlVcZbNRkNQFbS5WwTmApPmDn7ZFYdnui60zHcTlYAixOM4hBTSyOTzW/" +
       "bPZGq9Y60siJCDD0Owu+Ow5htRJWlEHXCQDGYDZd15HFjMkwwHLcc0aOgtfT" +
       "UlKhGTWF4WW4hmyNm7QbHW6ezllds5pupcyEUFCEu8UN2bdKHkeiDRiJMD6i" +
       "EAqXHM6RjcjiLMkelvtluE1z1rjuQqii9s1GQ9GX5RlirDnFgR0OkuttZMQo" +
       "FXYNQa6PjDdpP0TBKPbQil5klRXkdsloOEkiNoLaVrDqwulqNSPpJqEDV3uC" +
       "autmOk2VqGMRK8FxY0yUxZEd9USE4DIHvDiU6ka3jpnjfmkZswjfMCaljdok" +
       "Jt1iWF+QNqvDqyG+GVXQ/lReNtuiSiau4M7brc2YKXcDgZ4WNWSycpbAay4P" +
       "fGW1qhoOw/Kz+qrXx9sxqqywjWZbmrToyJXWcjoW2laRB3vePg6XipIOTwOs" +
       "XbSsSpGjVbgNa31sMVOnE4KmbAfzuV6ljlMNO2RLxSHwd0pOy1KWzLphKr5K" +
       "+KwxVrph2FA7rWhcMy3UcJPWSsRXDOzWsC6DewQr4agyms8kZg5q6WBSzZuW" +
       "iUp33Mcj3TOr1BBJe5qDGWsTleGOSYMtvywyA9da+w46JttCsQXgMkhF5GAi" +
       "YSIb9UXa8GLHWC/NWGPBBsRHl+66tRrjetXuw+PxtNbpWK1QozS3EZUgQtxI" +
       "SZcO5PWkva43xarRt4lVw3BquN+nU8m2BkW0g8SKYVju3DPJZiKidImtGfEM" +
       "4xtqu+aVIGkqJPG6yzCblafqZU4xOpw+");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("mdWRYTtxPMUJdaJXH5IIhsSVUcMsM6ZpUGFThthFBxnh02FMk1OlSkqTdD2c" +
       "LKnilIQsAZpi3ahIIgNrECrCSq8ujDrSnEn97tofTJxN3AX9T5fXs6U3atim" +
       "00zCuolPDUqfjcZyqd8hcE7E6s1yxgmYbbEPk4TUd7T2RkYgrjVV2ETjRhtV" +
       "xIlGE0eDrJ8meLHi9+FhPF11uhtGN9uJHI8SVSwBr0CZY+gkRceTJRatLHxF" +
       "KOVgLSRiSkG9cXOzWk37lLvqyi0P5gMDRaHRZqpFZeAEGrHeNKAhXRqRSVop" +
       "QTg3WsETr0OOhnWdhOYeWqLW5QpbWyXLuBOu2sWxQxc7La5enLTVSh1qOjbk" +
       "LIQZ0L5UHAq+TW0UOmX8tTmp1nyWaCe0swJ7R7LuW/X1mjGMKfDcgAViZpse" +
       "RTVbNp84UnUz6/KEDfYDwrLTdX1qSql1dJPOFoLZ0GtVsCeHNFYOFoqrB3Og" +
       "P0NgxSd+h19iPWkRo0SRZseMGvVXDHC0gnrZXXJhHUIHM7c0RcZlFMLXqlpd" +
       "APdQEnQZozuTokXMHcRlUaGhT/qpGbWB4xsRczpGNLPXAFycto6CLRNqkMog" +
       "hMaMA4tKOa1utGHN36RdsqXCDqYoa1jmalrHciUM06qQFKxWraELVHrVCYaN" +
       "aR2iVo2KWm/zY0whBgYzYuPxrCykgSyWGKehsP1GDHvEvI6uuECIIQapcfVw" +
       "WFvVXd1QNw0sjmMyYWdxf0xUqkVNkwc+3/NMv5US/mgDDWp+POEcMMXmxWHH" +
       "s70Nw3YtKrCMpjshN2CCsPgar09VEQUOYJwqEMn1R4satIQhqF1fioy7pJfL" +
       "lSiyPbIb+6bUXRZRRGKqlXTj8048GIVsWZpMwyBoQq2I6i9MGmziZcmmLW1C" +
       "szg6bEU2hs6qRToymbCyUOqLekpN/PXUnGMY9u53Z69P7z/f69PX5a+Dr14E" +
       "MO1aVsmlc7whPeU0Rv7Wmzw8b5p/LhWOHSc/8hY9l3xgd9owDAoPn3biPz91" +
       "9ekPPv+Cxv1s+eLuXCYfFe6MPP+dtr7S7SNVZQd1nzr9hBmTX3g4PC/45Q/+" +
       "9wdH37N47zlOS7/5GM7jVf4887nf7LxV/YmLhVuunh687irGtYWevvbM4F2B" +
       "HsWBO7rm5ODDV3v2NVmPvRU88q5n5eN/nzgczdOGKR/kPO/w2OuFQ4EXMoEL" +
       "7zgmcORc7IW9LHhbVHhtqEftM88q3LryDO2qal14+8u9fD/aUpZw4cpV5pez" +
       "xOzv8PqOuX5zmB8l9vQZefmEqwLS86Ok8w47JFh7FQTzoc1OYxg7gsZf09B2" +
       "zmCZGYwLeFS4fDC0h2c7LpQOeRKvdiCzYwL2jqd98weSPyNPyAIWUJxfR/Ho" +
       "UHKvgmJuA7NDNv6Oon/zKe6fkSdngRQV7gYUsWvOwRzy+76bwS/a8YtuPj/r" +
       "jDwnC2bX8oOP8Zu/Wn7flYtuP8nN57c+I2+TBUFUuCNT0asncw65hTfDjr5v" +
       "x+19N5/b3z4j74ez4Ae3drRz7RGfQ4I/9CoI3ndA8JkdwWduPsEfOyPvx7Pg" +
       "R7IDTHrEHzntcsjuIzeD3Yd27D5089n9vTPyPpUFHz/Cbnds5pDdT71adpmz" +
       "+OyO3bM3n93PnZH381nwD4B7CdhN+Kunpw7J/czNIPejO3I/evPJ/eMz8r6Y" +
       "BZ/fkpueRO4LN8OsPLcj99zNJ/drZ+T9ehb8861ZmYyuOaF0SPBXbgbB53cE" +
       "n7/5BL9yRt6/zoIvbQlOTyP4smcNX47g/eB5YUfwhZtD8GIukF9IyQ9BbZ3Q" +
       "r51B9fey4Lez60iZkk6Ocfx3N4PjZ3YcP/PXyfE/ncHxD7Pg6wccp8c4vuyp" +
       "w2tu64Gd/XW3jbN7kw9c998Otjf01c+/cPmON70gfC2/cHv1Fv2ddOGOWWzb" +
       "R2+wHYlf8gN9ZuT079zeZ/NzJt+KCo+//H3oqHBb/p0PyDe3Jf9HVHjorJJg" +
       "/5h9HS3yP6PCm04pkvVlHjkq/ydR4d7j8gBK/n1U7s/BinYoB6raRo6KvBQV" +
       "bgEiWfQvt7dorj1Bt701mGyP6D1wRP+2r1Xue7khPfI65IlrXmLk/9ri4IVD" +
       "vP3nFvvqF17osj/wnerPbi8fq7acplktd9CF27f3oPNKs5cWj51a20Fdl8gn" +
       "X7rnF+98y8ELlnu2gA/nwhFsbz75mm/L8aP8Ym76y2/6J+/6uRe+nt89/H8t" +
       "Xhxqc0QAAA==");
}
