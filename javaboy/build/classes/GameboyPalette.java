class GameboyPalette {
    short[] data = new short[4];
    int[] gbcData = new int[4];
    int[] colours = { -1, -5592406, -11184811, -16777216 };
    public GameboyPalette(int c1, int c2, int c3, int c4) { super();
                                                            data[0] = (short)
                                                                        c1;
                                                            data[1] = (short)
                                                                        c2;
                                                            data[2] = (short)
                                                                        c3;
                                                            data[3] = (short)
                                                                        c4;
    }
    public GameboyPalette(int pal) { super();
                                     decodePalette(pal); }
    public void setColours(int c1, int c2, int c3, int c4) { colours[0] =
                                                               c1;
                                                             colours[1] =
                                                               c2;
                                                             colours[2] =
                                                               c3;
                                                             colours[3] =
                                                               c4; }
    public byte getGbcColours(int entryNo, boolean high) { if (high) { return (byte)
                                                                                (gbcData[entryNo] >>
                                                                                   8);
                                                           }
                                                           else {
                                                               return (byte)
                                                                        (gbcData[entryNo] &
                                                                           255);
                                                           }
    }
    public void setGbcColours(int entryNo,
                              boolean high,
                              int dat) { if (high) {
                                             gbcData[entryNo] =
                                               gbcData[entryNo] &
                                                 255 |
                                                 dat <<
                                                 8;
                                         }
                                         else {
                                             gbcData[entryNo] =
                                               gbcData[entryNo] &
                                                 65280 |
                                                 dat;
                                         }
                                         int red =
                                           (gbcData[entryNo] &
                                              31) <<
                                           3;
                                         int green =
                                           (gbcData[entryNo] &
                                              992) >>
                                           2;
                                         int blue =
                                           (gbcData[entryNo] &
                                              31744) >>
                                           7;
                                         data[0] =
                                           0;
                                         data[1] =
                                           1;
                                         data[2] =
                                           2;
                                         data[3] =
                                           3;
                                         java.awt.Color c =
                                           new java.awt.Color(
                                           red,
                                           green,
                                           blue);
                                         colours[entryNo] =
                                           c.
                                             getRGB(
                                               );
    }
    public void decodePalette(int pal) { data[0] =
                                           (short)
                                             (pal &
                                                3);
                                         data[1] =
                                           (short)
                                             ((pal &
                                                 12) >>
                                                2);
                                         data[2] =
                                           (short)
                                             ((pal &
                                                 48) >>
                                                4);
                                         data[3] =
                                           (short)
                                             ((pal &
                                                 192) >>
                                                6);
    }
    public int getRgbEntry(int e) { return colours[data[e]];
    }
    public short getEntry(int e) { return data[e];
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1470933729000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "7chbdAQq+Cu+Vf4Pjx1B95QgAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1470933729000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "2271yzuRHoj/wt7Dz/TTv4t+6KIgylfvKorunvEf+64w7tu+oXy67+7eRBXp" +
       "4lkkf8P/HXvKB/7H/7lF0eUEdBsHO6CX4Bc+9jjx7q+X9GczQUH95ObWmRik" +
       "1me09V/3//fRW+/77FHlklS5qh7n7YLsrYr4KoFcNT1J5kFuf+79+bxzn2Q9" +
       "fTrTvfHQw28a9nAOOvMscF+0Lu4vH0w7peafAFf9WPP1Q6O5UClvZnu7Kctr" +
       "RfFDN6m4kQEG5UwGCnrbnRVUxsx99Hr+V576/Z9+/qm/LH3mfjsFMDqJeZt8" +
       "9yaab77w0tf/4KEnPlFOzRcVOd0DOlwo3LoOOJfel/w+eB7/feBqH+Nvv/Js" +
       "Dwd5VVKO+o/J9g6o9wZfLaW6v29lYK1qhUkWRVHlzIVLX5q/nC+NzyN9I7ga" +
       "x0gbd9C09jKavmQqardQdvEsnvZfhI/KZXAds7L/zyrN71IWhJyARZZmnqbM" +
       "/zjCkkvkNqLSX6GocHChx1DQO4gqfDlRgRVMuNqvaO0DfqKX5WdvAxdAInVv" +
       "/Tp6vbSJ/PYj3lPc/jDIuNJykQ4oDDuQvRM+Xu946rWTGV0Ai3YQB685Hlp2" +
       "87qscrWcpoqIc32/0j3gtfFd8woiwMNnnTEhWDT//F99+Ev/+qmXgKvTlXvz" +
       "IsYBP79pxNGq2Ef4Vy985InXPPcXP18mkEAFwu59P/XVotf33w1xUeyK4n0n" +
       "UB8voPJA6KrOyGnGljmfrp2iPfCsi174KtBmV5b9RjronPwYQSIQfF6butAK" +
       "8XmX0AmCmLTJ1W7NDtM5PljbA37iaha7JRZLeTrxELTZTJlsi2EIk9cXfNeZ" +
       "YLGFTcf9RTaV57rYmjjU2HYWscCiiSSPk8WwNnN7WSai4iLWa3NXl2Z+PciS" +
       "JWy0US0XMcyiupK/zOuoEwRwG272IQOFYThNDY22Fwt+GscbypH8+XDlTeoj" +
       "zPWD6YJJ44UmLlr4ao5uIR5OFAzRWrWJMJAH2rLrZnOH3yiZMDTldDt0JxqZ" +
       "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");
}
