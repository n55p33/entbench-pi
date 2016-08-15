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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "JozOSwXsPm0/7N/eHds4iB+FkN0xAWTNltpmb2QB/v7uCSPzUuFAFunq6+/d" +
       "1t4f6e4q6JGfLxIZ7p+WWWqXeSML8vf3TxiZlwpGpm7r64h1DsY6O/p7I+0F" +
       "MT3w/jHhYRU/pbrQUnhhHibCMw8VhgLbzgpNl8ZgMeNCUe3TKCNVCUk3WESJ" +
       "W2LbMRky8x915HcxUiIpeesD/DfhnrS/WiRsXFteZFl4kQfsMyZsTB7Ox+cl" +
       "zUgNx4cH3mqK7yoecRn7vSKNnQ/Pckvdcg9jH/c11kuakSmCnkyNwnqrpZA3" +
       "PTEBS1dYulZ4WPpjX0u9pB2Wri1k6U+KtBQH9EpL10oPS5/1tdRLmjk2a24r" +
       "nyvSSlzsrbL0rPKw8le+VnpJwzBMyuPaCB+GhZz0bJGmLoJntaVstYepr/ma" +
       "6iUNe8a0IQoyPV+0KI+rsMmk7ytgvD4BeCHLwJAHvD/5wvOSBrvHOTz875zL" +
       "zDeLNBOXZmFLUdjDzHd8zfSShmDPrVzTUsjOdydg5xpL0xoPO//pa6eXdMbO" +
       "ljWF7PxXkXbirqTF0tRS2M5Aqa+dXtIwANNMFxRDhvmzwAAMlE3A1LWWsrUe" +
       "plb7muolDaaO+5paM4FFx8WWsos9TG30NdVLGg+aVMmazdxmTpuAmessRes8" +
       "zJzja6aXdMbMtYXMnOtjZtpjKYbZXnsVxv/KievLSIcBvOa8zMGvThZ4fV/M" +
       "D3lOHT5+Mt59T0vQOiIXYDZmqrZapmNUdjRVjy3lHPl28m/I7fPTs1Nvfe2R" +
       "5uTGYr5rw3dN5/k2Df9fmNbJCu/jNLcpjx/+/dz+y0d2FfG12UIXS+4m7+98" +
       "8IdbLhBvDfLrAObBbt41glyh1twDrCqdspSu5B5ZLc32K/oUuQAewepXwe2W" +
       "ti+hTwYW5/pklY8or2l/JeKYPB/BVgMtrgqO70wCF2OyipFag7LNuat71xxd" +
       "OqZKcdvXV59vSPp/QYEv2jV8H7goi7QOy3AlSi2ktHiSvER9OGjzKWvHZD3w" +
       "k3Tyw7m1udgwCVxwh8EtimQBkornwkv0fA7T5UNIDyYRRuoyDmNvlwKX2JRc" +
       "OVnugQtr2cIlF0+Jl6gP4p0+ZVdhMgBsJPPYcDrI9klgowHLcDesWZC04tnw" +
       "EvVBPOJTthsTEfbRwEZbzu7UpiI+mVQwCw8rngovUR+4KZ+yfZhouVSsdVGx" +
       "d7KomMObMP/SxVPhJeoD97BP2fWYHGSkEsdIdn9t03DtZM4kBywsB4qnwUvU" +
       "B+otPmWfxuQT5kyyJXcDb3PxyUngojHDxSEL0KHiufAS9cF7p0/ZSUxO4EkG" +
       "ZX2OvalNxHnPrv8bIq630FxfPBFeoj5g7/cp+wImpxxEWJtfm4h7JosI3Fgc" +
       "sdAcKZ4IL1EfsF/3KfsmJl+B3QkQsaMve6hi8/DQZPJwswXm5uJ58BL1wfqY" +
       "T9n3MXnU5GGwEA/fncxoecwCc6x4HrxEfbD+1KfsaUyeNKPljv6cIwybi6cm" +
       "k4vjFqDjxXPhJeqD96xP2cuYvGByMejFxYuTxcUMeE5agE4Wz4WXqAtvkBvC" +
       "b1rwUxVzI/J7H1b+iMmv8VoSjpIdLjp+M5l03Gdhuq94OrxE3xcd7/rQ8TdM" +
       "/pyhY9BFx9v/CzrSjDTk3ezGq4az835ZYv4aQvzSybrKWSe3Pc8PjbK/WKiJ" +
       "kspESpadl+Ec+XJNpwmJc1ljXo3jN32CAUaWnP/uOSNl/BNBBIkpWcrIfD9J" +
       "RkrxwylSwcgsDxHkmGec9asYqXfXB1P4p7NeLcz1dj1oysw4q9QzUgJVMNvA" +
       "XRBvxjpu8ZkXENPmt9bznH3GD8pnnK+rHYeHS3MO3fjPiDIHZCnzh0Qx8fTJ" +
       "K7uueesD95i3pkVZ2L8fW6mOkgrzAjdvFA/ZFnu2lmmrfOvy96Z+ecqyzHFk" +
       "g2mwPWzm2R5N2gkJcPea67pPbDRnrxW/eGr9oz86Uv50kAR2koDAyLSd+Vc1" +
       "01pKJwt2RvPvpg0IOr/o3Lr8c+OXr0r86ZfZO5G5V2Dd9WPiM/de9fNbZ59q" +
       "CpLqCCmTcCnP75BuGld6qTimD5FayehIg4nQiiTIORffpuJIEPAHRpwXi87a" +
       "7Fu8cw/Onn/rL/+XClWyuo/qG9WUEsdmaqOk2n5j9ozrnDKlaS4B+43VlZjy" +
       "+kN8Cwj+GIt2alrmUmR1VOMRIZENFO7v64LNPIu5Zf8BvRdHm2I4AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "kMCPU7bSWnaEGczGwLSnXYfz4/qCXNWQ");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
