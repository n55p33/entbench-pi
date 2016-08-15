package org.apache.batik.svggen.font.table;
public class CmapTable implements org.apache.batik.svggen.font.table.Table {
    private int version;
    private int numTables;
    private org.apache.batik.svggen.font.table.CmapIndexEntry[] entries;
    private org.apache.batik.svggen.font.table.CmapFormat[] formats;
    protected CmapTable(org.apache.batik.svggen.font.table.DirectoryEntry de,
                        java.io.RandomAccessFile raf) throws java.io.IOException {
        super(
          );
        raf.
          seek(
            de.
              getOffset(
                ));
        long fp =
          raf.
          getFilePointer(
            );
        version =
          raf.
            readUnsignedShort(
              );
        numTables =
          raf.
            readUnsignedShort(
              );
        entries =
          (new org.apache.batik.svggen.font.table.CmapIndexEntry[numTables]);
        formats =
          (new org.apache.batik.svggen.font.table.CmapFormat[numTables]);
        for (int i =
               0;
             i <
               numTables;
             i++) {
            entries[i] =
              new org.apache.batik.svggen.font.table.CmapIndexEntry(
                raf);
        }
        for (int i =
               0;
             i <
               numTables;
             i++) {
            raf.
              seek(
                fp +
                  entries[i].
                  getOffset(
                    ));
            int format =
              raf.
              readUnsignedShort(
                );
            formats[i] =
              org.apache.batik.svggen.font.table.CmapFormat.
                create(
                  format,
                  raf);
        }
    }
    public org.apache.batik.svggen.font.table.CmapFormat getCmapFormat(short platformId,
                                                                       short encodingId) {
        for (int i =
               0;
             i <
               numTables;
             i++) {
            if (entries[i].
                  getPlatformId(
                    ) ==
                  platformId &&
                  entries[i].
                  getEncodingId(
                    ) ==
                  encodingId) {
                return formats[i];
            }
        }
        return null;
    }
    public int getType() { return cmap; }
    public java.lang.String toString() { java.lang.StringBuffer sb =
                                           new java.lang.StringBuffer(
                                           numTables *
                                             8).
                                           append(
                                             "cmap\n");
                                         for (int i =
                                                0;
                                              i <
                                                numTables;
                                              i++) {
                                             sb.
                                               append(
                                                 '\t').
                                               append(
                                                 entries[i].
                                                   toString(
                                                     )).
                                               append(
                                                 '\n');
                                         }
                                         for (int i =
                                                0;
                                              i <
                                                numTables;
                                              i++) {
                                             sb.
                                               append(
                                                 '\t').
                                               append(
                                                 formats[i].
                                                   toString(
                                                     )).
                                               append(
                                                 '\n');
                                         }
                                         return sb.
                                           toString(
                                             ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "g/kMtx4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV6e8zj2HUfZ2Z3ZnazuzO7tne3233vOI4t+6NelChsnFqi" +
       "REkUKUoiRUpM4jHf7/dDlJx1YsOpjQZwjWaduECyBVrnZawfCZLUQGFj+0ic" +
       "xIYBB0bTJGicFgXycAzYfzQt6ibpJfW9Z2YfSCqAV5eX59x7zj3n/HjuvXz5" +
       "29DdcQRVAt/Z6o6fHKh5cmA5yEGyDdT4gCCRmRjFqoI5YhyzoO2m/Oznr/31" +
       "9z5uXL8IXRagN4me5ydiYvpevFBj38lUhYSunbQOHNWNE+g6aYmZCKeJ6cCk" +
       "GSfPk9D3nWJNoBvkkQgwEAEGIsClCHD3hAow3a96qYsVHKKXxCH0AegCCV0O" +
       "5EK8BHrmbCeBGInuYTezUgPQw9XingNKlcx5BD19rPte51sU/kQFfvFn33v9" +
       "1y5B1wTomukxhTgyECIBgwjQfa7qSmoUdxVFVQToQU9VFUaNTNExd6XcAvRQ" +
       "bOqemKSRejxJRWMaqFE55snM3ScXukWpnPjRsXqaqTrK0d3dmiPqQNeHT3Td" +
       "a4gX7UDBe00gWKSJsnrEcpdtekoCPXWe41jHGxNAAFivuGpi+MdD3eWJoAF6" +
       "aG87R/R0mEki09MB6d1+CkZJoMfu2Gkx14Eo26Ku3kygR8/TzfaPANU95UQU" +
       "LAn0lvNkZU/ASo+ds9Ip+3x7+oMfe7838i6WMiuq7BTyXwVMT55jWqiaGqme" +
       "rO4Z73sH+TPiw1/86EUIAsRvOUe8p/m3P/bd97zzyVd+Z0/zj29DQ0uWKic3" +
       "5U9JD3z9ceztnUuFGFcDPzYL45/RvHT/2eGT5/MARN7Dxz0WDw+OHr6y+O31" +
       "T3xa/dZF6N4xdFn2ndQFfvSg7LuB6ajRUPXUSExUZQzdo3oKVj4fQ1dAnTQ9" +
       "dd9Ka1qsJmPoLqdsuuyX92CKNNBFMUVXQN30NP+oHoiJUdbzAIKgK+CC3gau" +
       "x6H9r/xPoJuw4bsqLMqiZ3o+PIv8Qv8YVr1EAnNrwBLwehuO/TQCLgj7kQ6L" +
       "wA8M9ehBpuuqB2tgbuBElBwVxlwxYIvaQeFowf//IfJCy+ubCxeAAR4/H/4O" +
       "iJyR7yhqdFN+Me0NvvvZm1+5eBwOh/OTQO8Eox7sRz0oRz3Yj3pQjHpQjnpw" +
       "PCp04UI52JuL0feWBnayQcQDLLzv7cyPEu/76LOXgIsFm7vAJBek8J0hGTvB" +
       "iHGJhDJwVOiVT24+yP149SJ08Sy2FhKDpnsL9lmBiMfId+N8TN2u32sf+fO/" +
       "/tzPvOCfRNcZsD4M+ls5i6B99vzcRr6sKgAGT7p/x9Pib9z84gs3LkJ3ASQA" +
       "6JeIwFsBsDx5fowzwfv8ERAWutwNFNb8yBWd4tERet2bGJG/OWkpjf5AWX8Q" +
       "zPEDhTc/Aq7nDt27/C+evikoyjfvnaQw2jktSqB9NxP8/H/52l80yuk+wuRr" +
       "p95yjJo8fwoHis6ulRH/4IkPsJGqArr/+snZT3/i2x/54dIBAMVztxvwRlFi" +
       "IP6BCcE0/+TvhH/4zT/51DcunjhNAt0TRH4CIkVV8mM9i0fQ/a+iJxjw+09E" +
       "AlDigB4Kx7mx9FxfMTWz8ODCUf/vtbfWfuOvPnZ97woOaDnypHe+dgcn7f+o" +
       "B/3EV977v54su7kgF6+yk2k7Idvj45tOeu5Gkbgt5Mg/+PtP/Msviz8PkBag" +
       "W2zu1BKwLpbTcLHU/C0JVHsdAdo3I7Vw2u3AS6LtEeej5Zimf7AQPcV3uzIA" +
       "mRgHoFm6BFySvaMsD4p5PwzZQ+Y3HTGP6UEuq0GhSsmHFMVT8emwOxvZpzKd" +
       "m/LHv/Gd+7nvfOm75SSdTZVOexklBs/vHbsons5B94+cx5iRGBuArvnK9Eeu" +
       "O698D/QogB5LpegIwFx+xicPqe++8kf//j8+/L6vX4Iu4tC9ji8quFiGN3QP" +
       "iCs1NgBC5sE/ec/epzZXQXG9qOXQ8cRA5cRA+d4XHy3vrgAB335nZMOLTOcE" +
       "HB79P7Qjfei//+9bJqHEtNu84M/xC/DLP/cY9kPfKvlPwKXgfjK/FfpBVnjC" +
       "W/+0+z8vPnv5ty5CVwTounyYcnKikxYhK4A0Kz7KQ0Faeub52ZRpnx88fwye" +
       "j58HtlPDnoe1k1cOqBfURf3ec0h2XzHLj4LrycMIf/I8kl2AysqgZHmmLG8U" +
       "xduOgONKEJkZyCcOYePvwO8CuP62uIrOiob92/8h7DAFefo4BwnA2/BKBjLg" +
       "wjKvat5ZZLoADbPD/At+4aFv2j/355/Z51bnbXmOWP3oi//s7w4+9uLFUxnt" +
       "c7cklad59lltOVn3FwVRRMczrzZKyYH/2ede+He//MJH9lI9dDY/G4Dlx2f+" +
       "89989eCTf/q7t0kKLoHce//aKEq0KPD9nD5/x1B5z1lDPgaupw4N+dQdDMnf" +
       "wZBFdVwqTICXARC1TD5Kstk5sVZvUKy3guvpQ7GevoNY7309YoEcFawhAPZE" +
       "0Fvv7Ckl1u8N/9IvPve1H3/puf9W4tZVMwbh0o302ywJTvF85+Vvfuv373/i" +
       "s2VWcZckxvvAOb+WunWpdGYFVIp8363mueM8vJFXT5Ebjj1FzctXTxAE0DkL" +
       "3XyDFnrm8Dqq385C9uuyUJlLJXFJJZ8d5OFXG+RI/Xe9TvXxcpzbqO68pur7" +
       "eL4AoOvu+kH7oFrcZ7dX7lICXQ5SyTFBpnE5LtfugEszPdE50vgRy5FvHAEb" +
       "t0eyG5bTPlLoevl6LND8YL8APicv8brlBV7/wElnpA/W0j/1Pz7+1X/+3DeB" +
       "exPQ3Vnx/gC+fWrEaVpsL/zTlz/xxPe9+Kc/VeZ7wGLch7/3WNnrh+6gdVHd" +
       "FcX7i+LHjlR9rFCVKRdOpBgnVJmfqcqxttQpfeYJyPL8v4e2ybUPj5rxuHv0" +
       "IzlB4zfLPF9q3g7Np5bkbiuj/nA4HY9X3VU16bpUCB7rEtutpesqNbdHdNqh" +
       "V4khNTTBk2azoD/vhWuCn4T8coCPcbgznM8NrIf3uSS0xAHmL23G9rl5ENqT" +
       "aTdLpPkSX/i1aBlJHbIuNJR0hub1pmi3xVTyhE5dcjPN7URt1+Kqbi4I41YY" +
       "DTbDHePjfJvjJ4rNW6zq2yGfzKXhOhuzhjIZtbaVLLWUARNFhNtvE7zpkLhb" +
       "Y8Ne2Ehju7qQ6HVAeUve5oJR326xfLCIax3TDJGavXEnNaFZ5QYcXx/4HTbA" +
       "9YhfDLecSVDcLGDYkSjZcHdLzv02xmJKTgT9CEnNYDzhWXm40gix33BJZFNj" +
       "iKReIwdi6Oepo5kus/Z90WR8XqyGEtJF+txGaXNCHReFEJ+2fFJa8LGJtaml" +
       "PeqjtaXWUCyFQ2scNWgzU6KWo+KOq01JTjPCmW0GjQTnHYaPdxV2HFgEuRi5" +
       "xHAYzmjfwNfT7oSkk0mLI/ttJgwd26y28KaMUMhyTbmtsb3wKsx8RzgEWQd9" +
       "o7tdrz+Upg6CbnRpVRvyJu44vjlr5COhgrKtlkHjwSSUOMwR8ToyMuzqhp/M" +
       "JXwQsjOFqbrpNB+mqLveLZttDAknBTGJz9JYYFSLJwK13xxJK31NhTrhwGxt" +
       "wctj1HADl3Hd3MsHRj7vhLBpYFFNDzfsinNxY1ht9vUJP2l3c2o76LXdLe/b" +
       "9QnuKrYadK1xfWbhzW6XH6SsM1sFrsgDt7KHzLjeNbEgyIRBqhNtHmuxOK33" +
       "58Jwsd3ZzqLWXNsSQrTE+WYxFPsRPql0RWOx6pHjDWXi49xVsSXiyzS2mlW4" +
       "XEl4azXuBFtyOZ+sqU4+CdMm3Bl1uZ6i83aVrU0Weq85ydcuUvV2bB4IVWPu" +
       "95rgWldnuw3T0TK3pjRaFtej6su167dUi1u4lOboO8RsBJFEpZI8T2q42yJE" +
       "zKhUWA9PhACuuxO+3jUQd+0ucM0I6qugJmqqhuVjeDExCaZh54QAnILYTPE1" +
       "v0RF046mAsdYQbzwM6JO+U6IGlInI1qrubX1RVykFHO9wHk2DpaZMzdlBNab" +
       "PkN1+TDs7VpmIM09qWnEbFtl83Rg40RzSzc2LLYyN21UMJerVgdjpgw5sSeC" +
       "r7bYRc2ZViY6pQVdpVFfrPxuR4hNJ2huu+vxoqFup8wY68/SEG3RcBJwvu2L" +
       "9Mj2guXQdQgmXovt8XIhUmsvq87FYLFpLPFut7fr1sRZM+QpZLta11hqK2Us" +
       "UwuyVTPu+GIXD8J+tOgMkXgYriU8dCeoiIfpUFaWm9WOl3lhucRnfTxPZ2Ez" +
       "ZA2vL/by9YyMBIvtaNikz8YSpuNmbncXk55DDBtbI0C5GtZsZhbqjcRt2NiR" +
       "ZrM5Ysb4gCMshtk5k4VJDO26iuKjrZDEVKvt62Lfzn2hxdZ3XX8ohZRf74uo" +
       "z40rubDNFhUxHTfHFapD7cwFVq9WbStJ+2QCy24Eb0ixZnWawtjEYZrqOiY6" +
       "ZMer2KOzIRXXm1TqjwwkbIiy5lpNOK23QqSPUssVsc1dWRxT/eWg2ZsuWbui" +
       "8cwWHqwSkGRNlxXM2NRttN/d9DS+p2ibihC7eUO1yOFSlwfjho1MJlG+UZw2" +
       "VVnmnc1iZ9A5TFbUcR8f9tkuo/WpBKszWmUmmXOxbm+YdMDLvcnKiCv4diWr" +
       "WCduwOgUVxuDqhjOZkPYbI9dq5JhWz5s2nkUbTxxyjDeXJMwGK2ls1Wnnlsu" +
       "xU+Gazqpd63EbOhx2h3P5Zqm8o1dBZHTkbXRZG9EbzGrX+vZ62mz7lEN0pzU" +
       "JsKiiqxlUmwTWq8yibfdzdBFVxt6PNFt3JojSavW4eJcRFFaUWrz8WTib5oM" +
       "ETTQjSejSsrbFBhmBjdoC5nq692iVuMlZivIFctoIK7EOl0hH1WcBGmtOxUx" +
       "qHbH4z49XJD15QSxNrV8umaaCMlTJKnjXptYUoyLKUYvruV5lR5miOv76sqs" +
       "BTLbEMjxVEumUXfXmI5JemErMFmXEqbd5rkY8Qa03EhGYi10e36EVYRw4/Ic" +
       "spORrC60bRKTsplXSeS0XrM7KmJnO8FbKM5ky1vMvCu5HSdwRwhTxaqp09pU" +
       "fDJr1ybhKEw4dloHEB4AP+twhu4qdGXXC5a5uoKziRdslVSdpHNjGoxTMSBR" +
       "ViTcnSz0VgIescim5XoWCssE260v5xw9zViWmIyFTS70qjUdU1swawwUWpz2" +
       "dLi5rWZsFlV8e9rHd26lz45GOIVoxmg0RNAOYqlYy8GmmQaLyrwDy9MttrX6" +
       "LgLzZjeCRW3ER7NOAqPjauY0xhRtbwZ4hYytBVIRGyTZxFKlsVo422lL3K23" +
       "9KCLaI3InBFZcykyTpOwFSJdmg2JBstxZlk39Io5nE0X24G3GtcbjQxmXYeZ" +
       "YCIVIi0xwaZqsJ7SzqBBACcIJVwbapiEr8xBovWXda1lk6newDZWpowwvt6w" +
       "2ziSIQBAw+lyg7estSjjEwutbiZsr5uT7Ga62rEjc+pyrWigo2ZAyCTbUSyh" +
       "xVXkocorFlJBBz23KRn2aM6yulzRIlHZqZWtUmsOZak+XbdlL9an9LrrGQ5D" +
       "SiuU8jZEE/apmWTIowUurKr1iedkvNDojXOvp1Ld+cDk63EqraIQ9aaYjvW3" +
       "3RhERaeVaYudmnByU3CG+o7ahgNpg/q2vmi6/d2YRtJFhHD0QJNGTSSDtZER" +
       "sdkgciO0tVpHHDGbwSqpSU2pAVei2no1QefxMqWiGj1oTSK4vh3MBynMZzzb" +
       "YHlcErpcQtBbZyLEbDKqp72KEXBimDemawlEsJ+s+f68MrTXE0Turs3ApdtD" +
       "IqG78sj1Rq24sYbbW61HJdtBazbXUnyNtyVc8Lq7zWq6WWTLHjyTdh7bbQ4V" +
       "ydgZrKv1lvVKxgkdK6hKqqdKpuDowlxdTprytBEgdE72Wl4OUHA6i6htR2Kz" +
       "HWqg/YncmIvhlqJH23RObtmZLHnDGojEaNZSljFRE1K1Qcat1GijTbRSseY7" +
       "HN4xuOnydJfZyJNRuI47s6lKr6JgG3mkSAktDw+HVjwaeVmtP85MeLOaTzeu" +
       "GG4YURnZoaK3FTrNeVdEtu5wLWA6oeKzoc82EGOICb7UoWcNY05SCVk3tvJ8" +
       "6qtjiSapFouGaJtSKi1vNJ+7eVXw5Dq8EOo1lOUynoMltKJHHkvLzsIMRg6/" +
       "aPDWcLZd2ks6by/rzYaLerYlVFo9YdhUq5jMoklNl+lOhxolalMzRzIay+Pc" +
       "7+70VWBkO04JZpwMiwZrsiQyFbfSKAzMpWZNvV09R0E23BQYbkitG8vGZJXl" +
       "ncZ8k5Iu0mb5psOpDbjubd2Y6wyrwrxRbc5EzG4iEhVZ7VZFIkWUQNkMqTIV" +
       "Z8RnSF0J0VjV5aDwGw/xgar9Xndea+/UNJaHG6vWk8m4i/SkWl/q4I6qGH1u" +
       "bjRSwosWjQXKp0qQA/v3dEbZUVGfzIZof5FlOb1uDAC+a+qu3sv1gJysqEQb" +
       "wJbWV7Ba1hqK6sTr9PT5jFz0jTYVzrBJrNZIkuPSEWvXYxh3baU3Q61d2+bA" +
       "QlijBwTr6fS6x21ib6YPkhrdbVtERkrckLdqGzLlrB0z8lu7drKK+x7B9Dw2" +
       "X/BNHUHClbEwR4tZPaOxUNU82Bf8Kk2R1JQheF8C66uaOp40JKSO97i6yBiV" +
       "Dso1lRbSC9EujgjjUAwbbEZWmc2WJYx5uvZ537VZrLKaDocukuJ1TCaJWcUD" +
       "uTPSwrpbVAPj4xWV89Q1v2D6xnrMiaQVrNBZrdeyjVZjI21hpbeUJis2XDMe" +
       "gxI92djOZaaNN7eG5bBLIXWx3cbY9puRFs9ZyZMGw4WU4Qt72M/amkPP7GWF" +
       "1ELBQLWhhYe2mmqVtSAvl17YmfAka5GtiamYLVOY9wcWUt/RK2xFIp3NGoW3" +
       "Pr9ExiMmrreJiMa7lYrTxMnpoqfaG3rF1QQL0dsRvKZJ4C2xgNrIdjBa2fMJ" +
       "Ya9GURxmzYQYYhhZTV2nas65vpPUg6ncbnbSkaE2TXRV6VeJAQO6mu6qlOah" +
       "/lrTGs60HWPIYBGp7FrnWcZrdeLRYs5XG44W0WANE/BiHtYxkvLtNIwyVNSJ" +
       "peG73CZLLD+iWtPmZp7ou22zE7dgfFvjOjoRkB1iziOtAatHfruZZexu7NYm" +
       "MjWmSN3ysnmLNMeqp0s6tRAUcWHQAodUNhVMBf5E6yPYWfGbCoxVIh22qSQH" +
       "C5fuu99dLMc/9sa2CR4sd0SOvw+wnHbx4ANvYCcgf5Wtpt3J8VT5uwydO2U+" +
       "tat06vDg+IzlB17HBlO59Vns+D5xpy8Hyt3eT33oxZcU+hdqxb5K0fsige5J" +
       "/OBdjpqpzqmxL4Ge3nHn/Uqq3DY8OT348of+8jH2h4z3vYHT2KfOyXm+y1+h" +
       "Xv7d4ffL/+IidOn4LOGWTzrOMj1/9gTh3khNUoDwZ84Rnjg2RbG3V54Oooem" +
       "QM9v8J2Y/052Lb3i3AHZ6XO5c9tLd8eGH5U75r9csv7SOdajI6Ti/uWi+NcJ" +
       "dL+uJie7h0VjdOKR/+a19qZO91o2/Ktj/a8dbXD2D/Xv/8Pof1qJ33yVZ18o" +
       "il9NoCtAwSMbzU5U+7W/h2oPFY3F1vXoULXRP7xq/+FVnv2novhiAl1N/JMN" +
       "1A+c6PalN6JbDkL0+MuK4oz40Vu+4Np/dSR/9qVrVx95afkH+2OAoy+D7iGh" +
       "q1rqOKfP1k7VLweRqpml2PfsT9qC8u8rCfTsa+MO8Onk+NDl9/acX0ugx1+N" +
       "M4HuKv5Os3w9gR65A0uxi11WTtN/I4Gun6cHopT/p+n+IIHuPaEDXe0rp0n+" +
       "KIEuAZKi+sfBbXbA9+eZ+YVT4Hjob6UpH3otUx6znP7QoQDU8nO9I/BL9x/s" +
       "3ZQ/9xIxff93W7+w/9BCdsRd+bq6Sh6eUzjHAPrMHXs76uvy6O3fe+Dz97z1" +
       "COwf2At84vunZHvq9p80DNwgKT9C2H3hkV//wV966U/KDfn/BzFNR9pHKQAA");
}
