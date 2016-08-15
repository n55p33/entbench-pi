package org.apache.batik.gvt.flow;
class WordInfo {
    int index = -1;
    float ascent = -1;
    float descent = -1;
    float lineHeight = -1;
    org.apache.batik.gvt.flow.GlyphGroupInfo[] glyphGroups = null;
    java.lang.Object flowLine = null;
    WordInfo(int index) { super();
                          this.index = index; }
    WordInfo(int index, float ascent, float descent, float lineHeight, org.apache.batik.gvt.flow.GlyphGroupInfo[] glyphGroups) {
        super(
          );
        this.
          index =
          index;
        this.
          ascent =
          ascent;
        this.
          descent =
          descent;
        this.
          lineHeight =
          lineHeight;
        this.
          glyphGroups =
          glyphGroups;
    }
    public int getIndex() { return index; }
    public float getAscent() { return ascent; }
    public void setAscent(float ascent) { this.ascent = ascent; }
    public float getDescent() { return descent; }
    public void setDescent(float descent) { this.descent = descent;
    }
    public void addLineMetrics(org.apache.batik.gvt.font.GVTFont font,
                               org.apache.batik.gvt.font.GVTLineMetrics lm) {
        if (ascent <
              lm.
              getAscent(
                ))
            ascent =
              lm.
                getAscent(
                  );
        if (descent <
              lm.
              getDescent(
                ))
            descent =
              lm.
                getDescent(
                  );
    }
    public float getLineHeight() { return this.lineHeight; }
    public void setLineHeight(float lineHeight) { this.lineHeight =
                                                    lineHeight; }
    public void addLineHeight(float lineHeight) { if (this.lineHeight <
                                                        lineHeight)
                                                      this.
                                                        lineHeight =
                                                        lineHeight;
    }
    public java.lang.Object getFlowLine() { return this.flowLine;
    }
    public void setFlowLine(java.lang.Object fl) { this.flowLine =
                                                     fl; }
    public int getNumGlyphGroups() { if (glyphGroups == null) return -1;
                                     return glyphGroups.length; }
    public void setGlyphGroups(org.apache.batik.gvt.flow.GlyphGroupInfo[] glyphGroups) {
        this.
          glyphGroups =
          glyphGroups;
    }
    public org.apache.batik.gvt.flow.GlyphGroupInfo getGlyphGroup(int idx) {
        if (glyphGroups ==
              null)
            return null;
        return glyphGroups[idx];
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV7e+zr1n2ffte+9rVj+147D7tu7Phx3cZWeylKoh65SRpS" +
       "D4oSKVISSUlcWocUSfFNig/x0XpxAzQJViwLNqfLsNToH+nWBW5SDCs2bOjg" +
       "YdiaoF2HFtmjG9akw4q2y4IlwJYNS7fukNLveX/357i+FnCOyHO+55zv5/v9" +
       "nu/5HvLwtW+XLgd+qey5Vrq23PCGkoQ3DAu5EaaeEtwYkggj+oEidywxCFhQ" +
       "9uLqmV+7+r3vf1a7dql0j1B6p+g4biiGuusEUyVwra0ik6Wrx6U9S7GDsHSN" +
       "NMStCEWhbkGkHoQ3ydI7TjQNS9fJQxYgwAIEWIAKFiD0mAo0elBxIruTtxCd" +
       "MNiU/nLpgCzd461y9sLS06c78URftPfdMAUC0MOV/J4HoIrGiV966gj7DvMt" +
       "gD9Xhl75mz917e/fVboqlK7qzixnZwWYCMEgQukBW7ElxQ9QWVZkofSwoyjy" +
       "TPF10dKzgm+h9Eigrx0xjHzlSEh5YeQpfjHmseQeWOXY/GgVuv4RPFVXLPnw" +
       "7rJqiWuA9T3HWHcI+3k5AHi/DhjzVXGlHDa529QdOSy972yLI4zXR4AANL3X" +
       "VkLNPRrqbkcEBaVHdrqzRGcNzUJfd9aA9LIbgVHC0uO37TSXtSeuTHGtvBiW" +
       "HjtLx+yqANV9hSDyJmHp3WfJip6Alh4/o6UT+vn2+IOf+Wln4FwqeJaVlZXz" +
       "fwU0evJMo6miKr7irJRdwwdeIH9BfM9vfPpSqQSI332GeEfzD3/mux/5sSdf" +
       "/+qO5ofPoaElQ1mFL66+KD30u+/tPN++K2fjiucGeq78U8gL82f2NTcTD8y8" +
       "9xz1mFfeOKx8ffovly9/SfnWpdL9ROmelWtFNrCjh1eu7emW4uOKo/hiqMhE" +
       "6T7FkTtFPVG6F1yTuqPsSmlVDZSQKN1tFUX3uMU9EJEKushFdC+41h3VPbz2" +
       "xFArrhOvtP9dBunp/XXxH5Y4SHNtBRJXoqM7LsT4bo4/gBQnlIBsNUgCVm9C" +
       "gRv5wAQh119DIrADTdlXrLchpFpuDM1dXybA8Ddy8/Lero6THNG1+OAACPu9" +
       "Z6e6BWbJwLVkxX9x9UqE9b775Rd/69KR6e9lEZaeAWPd2I11oxjrBhjrRj7W" +
       "jcOxSgcHxRDvysfc6RJowgRzGni7B56f/eTwY59+5i5gRF58NxDjJUAK3d7p" +
       "do69AFH4uhUwxdLrn49/lv945VLp0mnvmfMJiu7PmzO5zzvybdfPzprz+r36" +
       "qT/53ld+4SX3eP6ccsf7aX1ry3xaPnNWor67UmTg6I67f+Ep8ddf/I2Xrl8q" +
       "3Q3mOvBvoQjsEbiOJ8+OcWp63jx0dTmWywCw6vq2aOVVh/7p/lDz3fi4pFD1" +
       "Q8X1w0DGuZxLD4D0o3sDLv7z2nd6ef6unWnkSjuDonClH5p5v/jvf+dPa4W4" +
       "D73u1RPr2EwJb56Y6XlnV4s5/fCxDbC+ogC6//R55m987tuf+kuFAQCKZ88b" +
       "8Hqed8AMByoEYv65r25+/xt/8MWvXzoymlJyGtvdF2ADg/zIMRvAQVhgLuXG" +
       "cp1zbFfWVV2ULCU3zj+7+hz86//tM9d26rdAyaH1/Ngbd3Bc/kNY6eXf+qn/" +
       "9WTRzcEqX6CORXVMtvN67zzuGfV9Mc35SH729574W78p/iLwn8BnBXqmFG7o" +
       "oICeT63nLwhSfN0GStjuHTv00iPfML/wJ7+6c9pnV4EzxMqnX/krf37jM69c" +
       "OrFUPnvLanWyzW65LKznwZ1G/hz8DkD6f3nKNZEX7NzlI529z37qyGl7XgLg" +
       "PH0RW8UQ/T/+ykv/5Fde+tQOxiOnV4oeCIR+9d/+39++8flvfu0cl3UXiAIK" +
       "Dm8UHD5f5D+es7Q3pfz+A3n2vuCknzgt2hPB14urz379Ow/y3/mn3y1GOx29" +
       "nZwWlOjtZPNQnj2VQ330rFMciIEG6Oqvjz96zXr9+6BHAfS4Am49oH3gjZNT" +
       "k2hPffne//DP/vl7Pva7d5Uu9Uv3W64o98XCH5XuA45ACTTgyBPvJz6ymxDx" +
       "FZBdK6CWbgFfFDx+q6co72dT+XxPkedP59lzt07E2zU9I/7LBQeX89tqUQjl" +
       "WW3HERLmjsYVixk4KDIgvedub/fF5NmZ8at/59nf+firz/5hIcsregBCXNRf" +
       "nxM5nWjznde+8a3fe/CJLxeu+W5JDAr7uf9syHlrRHkqUCyE88CRRHI5lh4H" +
       "U/aPdgLZ/Yelj96p5b0PMhaIghELvg7Dh7e1/51+3h2W3n/7UAC3Uk/DfTfy" +
       "8oDgSOM/kAPr5/I+XjMf+z+0JX3iP//vW6ZasdSf49POtBeg177weOfD3yra" +
       "H6+5eesnk1vjIGArx22rX7L/56Vn7vkXl0r3CqVrq/1eixetKF/JBGANweEG" +
       "DOzHTtWf3ivsAuObRzHFe8861RPDnl3tj50ZuM6pC8M8divj5KBUzK/lblIW" +
       "+fU8+9FdfBWCXWEkWfoqn1K6I1pF2xoothRnvYtzq3lGecmRqi7tY7O9rner" +
       "VI4FbDdcR8kXvMO6XZynuzeOtnqgMjlH6S/cXulUMYmOJf+bn/ivj7Mf1j72" +
       "JgK8953R5Nku/x712tfwH1n99Uulu470cMs+8HSjm6elf7+vgI2rw57SwRM7" +
       "HRTyO18BB/nlR3dCv2AFsi6oKyIqDehvlQt/p6sLyDfJ7h+/gKYoxIr8Zp51" +
       "dhr78A+0aOxoHyvu7iuu2dPLwGMgPbNfBp45u4Ls7TU5X1ylQ/O8DNZ9JTmy" +
       "zmvHvKZvxOsZbqogPbvn5tnbcPPxN+DmHjFYAf95tBydYOflt4GdT74BO/fK" +
       "ym35+dTbwM9ffQN+7s931gNFX2vnsvSZN8lSHsNf37N0/TYsvfIGLL1jfbQK" +
       "FTTUGZ4+9yZ5yvl4bs/Tc7fh6W+/AU9X8uUxfy5x6DyvHTvW3SJxhskvvCGT" +
       "Rc/JwQGYMNUbzRuV/P6L57NxV+GJgC0HxXO7/O4nDzl71LBW1w8DdF7xA+Bt" +
       "rxtW8xxGd0++zjBa+4EZBSvBQ8edka6zvvnz/+Wzv/3Xnv0GWKOHpcvbfP0E" +
       "Dv3EiOMof674ydc+98Q7XvnmzxfbQOBX+Zef+9bLea9fvghunv3KKaiP51Bn" +
       "RfBDikFIFVs4RT5CeyYOvRv43L842vCR7qAeEOjhj+TF7mLCwVO+HEGmNiTY" +
       "VqsTTdCeNUHlCt/net0RMeth3ZXWM1HR7HYElTNxwVZwW5K1mB/1By5UMWC/" +
       "V6t69BzuBVMJV8Rwy4o+rrhaI2TUJj+PQsafw2GFH7tsowrivmpbqgo11RGc" +
       "lS8NMtbZNpVZW26Xm+3mtlZbbFU7c6rozEzk/pDpTwUtyqabad/lYb3mYm61" +
       "lhJDzSfoKrPFq0TU387bTT8yptTM2Q7LnQHWwCb9dVMY8kRd2opTmlvH9qhD" +
       "wJGuj4nKvMauq5tuHFKcxyuUaaa0NhJJwpw1YNboo3LQYybLzbS3rDQW5eGI" +
       "kuH1jIKpOWqmhjMk/VW1XVkR5XGPl0Ori0AbfNzUGxQ+7SyCcI0MNtWuoM2J" +
       "tW3PpoMlQmK2RTVssey1Ngg2n3NT2x5NJXXY6dRJPljyQq87afHMQkuy1Zhf" +
       "UMRwrY9cg4gcH5/jG7fF0lTC2fNaGLiVpRKvnXTcp3hSw6mE4NK0LWKTubEa" +
       "6eLcCbkV1h7y85k+FXm9xcwohN8QBtlL8aw2HG7WndjybbtJU61kkuiZQLN9" +
       "gk4Dw59ZluXqtYxoKZENk+3VuO+NNgu+Z426TcJANYrqR2Z/gtu6U/bxlqOv" +
       "EiccGhNy1NzgjSFlzCRzy4bLZWWDroOO4jFxfTSeLWsbtVeRRm3USEdLZypK" +
       "G1zt4VGvL0AIR6UUsU67vmCFcy5Aa9JkhaWdqcFi8Sym65GpkJGZYLbQEBdE" +
       "OtYqw0mMVozeMHUlLuuTfX2Njr3xstLjrQm2odrLgT8i0BjIoYfKnGiXucZo" +
       "jkedqF9ZegPYNQUkqc2XCwPzyTWHzqa6gGgQLkx6W5bpe2mDVrq+zg18ayFa" +
       "LDpEV+1kFPiEGnMTeBERcEhgG4tZYqmkRQM7mdcXQ6NcYXrxqDusmbhdpctQ" +
       "28x4JFmo5aG3amWVAc7M23gZaDRgu5DCqNU+nrYTUkc6Y8qswMP+rDyrjcpp" +
       "cxM6kchhGmKvbAFvEqlJV8oBowL8dWjGVfuzmtkfTXmeHgYdWjQnsMuZKczL" +
       "U01xOy7UoylvuWlNJaUGRo0HY4rbGEJkC+t41AnWCUtuRxaHqK3uFKVijBty" +
       "3aA8ozYd28nmWFcdOFZPDLYJ4QYN2IGCLVGO9Im9waaT6YSb8bhRkzajlhZO" +
       "W12jvabhSYiVA9XZctwQ2DiOcfBEMdDQwHok18BcWZB72FyuiFt+y9exNFYn" +
       "KjPrGHzS0edi0KU41McchVQaXaDnhbAweLrFdlN+EQ4RJKDbQqWeTdqdSoDj" +
       "NhrOSHuu4WV+zc71CBNNdSoOMVafVbLemIPltS5WY6SOexnYZwQteNNUIyld" +
       "d4j2sNpf09Ryaoh11I1IVcLZ2tZntv26pCyi6rwVKd0hpdu0yWuYwHlowuvZ" +
       "Amv1SF2OQoPdRIPWiG6qsENLMaTpsNyfmyuHaKt9ML1HPD3YLJuh0Usq2bBD" +
       "s9KadKHGlJipEEKxIQ3JUUQ3OhRqNwdsPZpPRuVOYDcrHOzUBjgrNxjH9tVN" +
       "sl2VmUHTH4QLpbWpE+Yaac2FiTupM4sOmcVtwsmEtc20u9WqV3e6jCasKG28" +
       "7tTx2gZSorpKuNnc2RrkiFuv0O7Gq08EOhkt4YzWnCnstWsdX6JxptLqBZUu" +
       "S9D02sGZkFYb5FagYH+kLGE3qSIe3lGgssXIvryt+WU2kZNoTGNu4E7ri8AV" +
       "a8v6EEkDy480PAwDuGxzsb+uSVG5XBaWjBRmPWkq4GNaEAPU8fsONnJ7I7S8" +
       "FB25mVVhLxosYsRpDlOzRhI81lrjOpKEQdwrs0spNFrSLOzXsQCZ4MNRX/V8" +
       "XYWsCiy0ekYzKbvjkNtOKltRCeqSOhk1ITHmEcZzQgg4aLPF9gwwDa2uEFeS" +
       "AbPCFUWyo04zmhhtVumXt5HS29RxOC5HfatbNasIEidJhWMictmUNh1VkFpY" +
       "1cJGKOSjvNZpBjXdj6SyV4bjOBbK3Jqi5HFkQA1rUt1KDtBsc0mNs7TqtlPe" +
       "iCqUEfS1+Zizy0MIXcTGSG321o2xtqa3jNjXIz2jNr1+DyZRRc7Q2hAN4+6U" +
       "kfitJEH+diJTqBRrQGXLpgFVEq6lY3FDsA0mMwMxgClsuCwvbc/QliQnRcJa" +
       "CWOwmYYcrZXVoahWo42Un4d0a1OdaCQSdyCoBWdm21fUVBlEejrxw2ZGeKt0" +
       "KIXVJbqptSbhnJEaYGe7Hi8q3GBkupsKUTGb9aAuEGIlNbcVWpAdpGu3Y90V" +
       "R8vZpNKtsaidQrbUm2QZhvlceQBtmh1xma3bnhXyRpAibDPzEJnm8UodUl2R" +
       "bFQabWfS0Lk2Rvl4FNNalDjRaCzS1Q41YQ3SaE5DyRKZbS/JxmuSqrsTs16B" +
       "aZedWVQkz0djMtlmDX22cqRaVdMJVgIuIehse9X1IrQpMB8IY44T6MYJqWhL" +
       "9WvdzBi5G992h71t3UellWOMMwnK5hol1fmw1l6njjqvDU2kV4tsY1Ke8tVq" +
       "FYG3kSghkVyJ4Ehej1lI2kD2VDGmy9gxo3jRWrRWYt+yBkZWndNIlaMYab0R" +
       "+qYO+dGMas5AVIUYYiD4q45sVSPD1j0KbOqbSNxi7EVgWGaWDlsqPEgDdtFL" +
       "FYRtETAZ2IQOVj9x1e03K7CX8W187LTFiA8knt6ihh/0VTcZIvVl35mWQ5Vo" +
       "QNsataYXQ7UOMQuDZctWGLbs+RRtryfKuKUmSa+flUNN8uBG4A+iyTBh+g1y" +
       "HTJltAxXObUKpw4lNgajTVq1t8vEEvoZJDMzXiUiaa7zvr6E2R6S0SQlAGjs" +
       "AnaW5RU0tRKxvYqmfliuV7qz5bo/MFxvi/iGnEJNpMoEXkyxkJxO0RWjzqFK" +
       "tV9j554o17fTas1dcKzoBG2sNgmr5pYZ+nWlqWttXNaojbjgie28v+rhEw7R" +
       "xyFFljHfU+rUcrNg4aheriOOHdHCeJFtO/iwpaQ1N2Ma6py0V9sujOiNTjKI" +
       "+mbKOxTjK7wuS0mdxDsOb26r6ZAmIyuZYog/I13ettMNhjD9aNSX+YBJ9Kqh" +
       "zeZzQRc6gdvxqlPeFYyKx2ypet02pwZR6487Qmr3VHnWbDbo2VwkmHay1btb" +
       "KNQq5c5IpepWtb+E0sDsQkhraHtNYKtDhfeaYrssew1kOZZWNUPvDthlRVVG" +
       "EiQrSirwc4XEWgxwzLPKepORvUyeBvC2hrCeNePhJIE0vBKP6m1n5DtQWK3x" +
       "U2RCs5Da66pdXpOx9tIAG8zxLDaXW6PVtHGyywuu0fR9vbtRGrTdxckqDVuO" +
       "Ai/bvDEPFR6qym7YNLSBPEaWqQVZYTxVOhsO04POuKZ3w+bC6a4lXMramzVG" +
       "zmYrz5pXZw7KA1upKGy2YiyNR0V/wYmqpLcIBCOZqhf3CEKLveYYQTl6HLUC" +
       "dLhVY9r3DSIdcu02vIVtVFbKMIjnByDoro7WFRrhs8bWSBeJP3bNJl8xW9Bs" +
       "GlNwvaKOZxS/HmpaFhh1xm9DQxOWV8slaKjF6sJvSekoAERjy+7W1v050Vj2" +
       "WSleTSgDa9qDGFkz3pzUV6nagP1pDIKATcJQGQ0aOk2EVqB4a1JGi13USFN3" +
       "Nt4qo/sdt7o104EopsuGn0CMI3axkKeZCjdCg3CsCQ1TmvSRKRnIq/FyAPZH" +
       "dQxmsO2kbcgc6xJjLDXclAwUvLxRVE1X4bjf6apClzEr8zlJbFOthTPjXpez" +
       "YrKxCAYbhUeNmOyu2nql2vVbLorW+epgFVnUfE4R2ywB9HCH9gkkiRCSLg8m" +
       "XZyG9XbXRpcii6WD6YzUYM6T1kzFrhBC6kxcC7ZmC28JTQYNE1VHajcymiNY" +
       "dAhshrpiakazzIK4oZAasZsJy0qmmt06t2rYm0VrGHfGbLPb6IzReIHrLbHB" +
       "JFllpK1Ym/MEgZhB40FchziikTlWl2q2y71F5qZTfrqdh6IzZ7c9aGgFBiVr" +
       "GLlpk66Lt7TAb1OTpkbyVVcbDpKJkUXugDEGHTeEGdHX2mCDIs9FpoWUPbTX" +
       "YWPI3bTGG0qnweSE9abNUok9HLnzLEJ1LbRMLCzPGW2a+aPuOpXxGCUG0bRj" +
       "TDpEfbLoLafJWJvMzJow2jCLNgr1tAFanWpoB6svUE9GCWxZTTmHQIMR2luH" +
       "7ZDHGtLMbAQxmFbQDB1YC4yZhQnueoP10hWb41TCstqGqPUCk7THPHD+/RpC" +
       "lPuDht0SjdpoCscsupry803co+O4OoizTkSiwAnSkYqJC8ncmE01M1ozlDZr" +
       "02wSxnN/k9geoHBnujCPVuWRvHXVqrV2W/C6I0gVC2b8VktF8/CFYfRGvY+i" +
       "o4Xewesa5sZs3NK760DDlmiPjcmWHKGGICxxoJ+EgLgB0u8vaF9De9N6uKKp" +
       "UEN6LafOxtSAZRC+SbN66PllNJbkmGvSZY+lISghVBAFbOxslELWIhtyRgNv" +
       "wAnFE1VzOLWQRhWpNy2uUrbRBO2pQruhiUmKq8t0hcyC2CGkGMtMuskuBrVW" +
       "l0j6mYHP7E7VsFImZfiah1MWg6lIc72dCAiI9xhyDDXXgwGBCu5KKzMGbwwb" +
       "qWSNZ4Rch2tLM2PbS8cQl0oSw0O3HFWdAQTbZFNgPV9lVHGYVOS5DMNNxBs2" +
       "M67dnfad5XYaOpulPqUUYTFyktkWq6pNNpSUTXPW9k3VqLXd5jCrOFwEFNtp" +
       "U6IkaWYUoRqzqHRFW2Eba2ropjUYb8mOMaxnkLqAPN0mJlVT6KIpMR1XZ22T" +
       "s7zZsDaXlqG1rbMrgt6WU7fmRI4UzR1Wja22iszgxqwtkiTdRBiVcYjxDHQ5" +
       "2NQZM97Qm6S52DZskeYiYVbhNYhXON0UwJ583ZuLU2zswLrTatk+jtYq43TR" +
       "ATvrjA7LeG9KxDVhkcmmWkf4riaQ7Sm/4VwQ5Qy5hLPxmj30ky2OEaK3GcR4" +
       "I+EJC+7AItidrccBpZTnI8X2WKg8GpfdFl9tUZ7crevl5aQN6QakVTKohVpj" +
       "I1livRBF0Q/lj5P+8Zt7zPVw8UTv6GCbYTXzii+9iSdZyXmveY9+pw5DnXgW" +
       "euLdQCl/5f3E7c6rFW/2v/iJV16V6V+G");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("L+0fkjbC0n2h6/24pWwV60RXu8MsyhEbV/PuHwUJ2bOBnH0kewz0L/pK5l9d" +
       "UPev8+yrYekK2AgQRy8qjuX6tTfzPuUMtkLMj4PU3GNr3nlsv39B3X/Ms68D" +
       "RQBs6PFrhmNw/+YtgHtHXvh+kFp7cK07A+7gmGBQEPzRBQj/OM++CRAGhwjP" +
       "ffK7dXX5GPUfvlWV/jBIH9ij/sCdV+n/uKDue3n238PS/UClXeU8nX7nrer0" +
       "BZBu7tHdfHt0elC6PcSDS3nh9wHE4BTEPz2G+GdvFeJPgPShPcQP3RmIZ160" +
       "P33+oQrXCW/gPNt394Z6++MXe8r8HROlhL6+CgrhPHCB4B7Js3vD0kOiLJ9o" +
       "d1p4B1feqvU/CVJvL7zeHbf+g/deUPdknj0alh4E1k+eflF5DPCxt2odFZD6" +
       "e4D9t2kCvP8ClC/k2bMAZXAW5Qk1Xr8TKAd7lIO3CWX9ApSNPIMAyr21nouy" +
       "8hZQPpIXPgEStUdJ3Xlj/cgFdVie3czfXythf/+6OKf7pWN4H7wT6+94D298" +
       "x5X4SwUO8gKM4zzDAcbgNMYTKhy8BYxFcPgUSMweI3PnVbi4oE7IsxkIwYEK" +
       "x5GNnz6IcBwlHrBvVZEfBInbg+TuuCKpAo18AVI1z14EawdQ5BmYJ3T5sbcA" +
       "M4+Di/Mgiz3MxR2HWS2gXHCi6iA/L3hg7haQY5g55eQYpfWmjlCBrcPhFxP5" +
       "OfDHbvn2ave90OrLr1698uir3L/bnUw9/KbnPrJ0RY0s6+ThwBPX93i+ouoF" +
       "7vt2RwW9Akcaln7otsc2QcCb/+WsHiQ7+p8JS+86jz4s3QXyk5QfD0vXzlKG" +
       "pcvF/0m6T4AA7ZguP1dVXJwk+TnQOyDJLz/p7fzJQSG/x05aSBHRPfJGIj+x" +
       "D3321PHD4ou4w6OC0e6buBdXX3l1OP7p7zZ+efelw8oSsyzv5QpZunf30UXR" +
       "aX7c8Onb9nbY1z2D57//0K/d99zhzvahHcPH1nqCt/ed/31Bz/bC4ouA7B89" +
       "+g8++Hdf/YPi6Mv/B2QdcS2qOAAA");
}
