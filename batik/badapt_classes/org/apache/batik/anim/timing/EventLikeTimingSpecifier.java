package org.apache.batik.anim.timing;
public abstract class EventLikeTimingSpecifier extends org.apache.batik.anim.timing.OffsetTimingSpecifier {
    public EventLikeTimingSpecifier(org.apache.batik.anim.timing.TimedElement owner,
                                    boolean isBegin,
                                    float offset) { super(owner, isBegin,
                                                          offset);
    }
    public boolean isEventCondition() { return true; }
    public abstract void resolve(org.w3c.dom.events.Event e);
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1Ye2wUxxkfnx8YP/ALA+FhwBgqA7kLJFRNDWnAscH0jE+Y" +
                                                              "IGEKx9zunG/x3u6yO2efTWkeUgWJFIQIAVI1/OUoaZqEqGrUVm0iqkhNoqSV" +
                                                              "kqKmaRVSqZVKH6hBldI/aJt+38zu7d7e+VCqqifd3N7MN998z9/3zb54g9Q6" +
                                                              "NuliBo/yaYs50QGDJ6jtMLVfp46zD+aSyoVq+vfD1/fcGyF1Y2RBhjrDCnXY" +
                                                              "oMZ01RkjKzTD4dRQmLOHMRV3JGzmMHuScs00xkin5gxlLV1TND5sqgwJ9lM7" +
                                                              "Ttoo57aWynE25DLgZEUcJIkJSWLbw8t9cdKkmNa0T74kQN4fWEHKrH+Ww0lr" +
                                                              "/CidpLEc1/RYXHN4X94mGyxTnx7XTR5leR49qm9xTbA7vqXEBN2vtHx660ym" +
                                                              "VZiggxqGyYV6zl7mmPokU+OkxZ8d0FnWOUa+QarjpDFAzElP3Ds0BofG4FBP" +
                                                              "W58KpG9mRi7bbwp1uMepzlJQIE5WFzOxqE2zLpuEkBk41HNXd7EZtF1V0FZq" +
                                                              "WaLiUxti5y4cbv1eNWkZIy2aMYriKCAEh0PGwKAsm2K2s11VmTpG2gxw9iiz" +
                                                              "NaprM66n2x1t3KA8B+73zIKTOYvZ4kzfVuBH0M3OKdy0C+qlRUC5/2rTOh0H" +
                                                              "XRf5ukoNB3EeFGzQQDA7TSHu3C01E5qhcrIyvKOgY89XgQC2zssynjELR9UY" +
                                                              "FCZIuwwRnRrjsVEIPWMcSGtNCECbk6VzMkVbW1SZoOMsiREZokvIJaCaLwyB" +
                                                              "WzjpDJMJTuClpSEvBfxzY8/W08eNXUaEVIHMKlN0lL8RNnWFNu1laWYzyAO5" +
                                                              "sWl9/Dxd9NqpCCFA3BkiljQ/+PrN+zd2XXlL0iwrQzOSOsoUnlRmUwveW97f" +
                                                              "e281ilFvmY6Gzi/SXGRZwl3py1uAMIsKHHEx6i1e2fuzAw+/wP4SIQ1DpE4x" +
                                                              "9VwW4qhNMbOWpjN7JzOYTTlTh8h8Zqj9Yn2IzIPnuGYwOTuSTjuMD5EaXUzV" +
                                                              "meI/mCgNLNBEDfCsGWnTe7Yoz4jnvEUIaYUv6YTvCiI/4peTTCxjZlmMKtTQ" +
                                                              "DDOWsE3U34kB4qTAtplYCqJ+IuaYORtCMGba4zEKcZBh7gJsg6TUshBHsYFJ" +
                                                              "2BXXJtg+8X/UYooG0W5HMeKs/+NZedS7Y6qqClyyPAwIOuTSLlNXmZ1UzuV2" +
                                                              "DNx8OfmODDZMENdinGyB46Py+Kg4PorHR+Xx0bmOJ1VV4tSFKIYMAnDhBIAB" +
                                                              "oHFT7+ih3UdOdVdD9FlTNWB/JO0uqkr9PmJ4MJ9ULrc3z6y+tumNCKmJk3aq" +
                                                              "8BzVschst8cBvpQJN8ObUlCv/LKxKlA2sN7ZpsJUQK25yofLpd6cZDbOc7Iw" +
                                                              "wMErapi+sblLSln5yZWLU4/sf+iuCIkUVwo8shZADrcnEN8LON4TRohyfFtO" +
                                                              "Xv/08vkTpo8VRaXHq5glO1GH7nBchM2TVNavoq8mXzvRI8w+H7CcU8g9gMmu" +
                                                              "8BlFUNTnwTrqUg8Kp007S3Vc8mzcwDO2OeXPiIBtE88LISwaMTfXwLfbTVbx" +
                                                              "i6uLLBwXywDHOAtpIcrGtlHrmV//4k93C3N7FaYl0BqMMt4XQDVk1i7wq80P" +
                                                              "2302Y0D30cXEk0/dOHlQxCxQrCl3YA+O/YBm4EIw8zffOvbhx9dmr0b8OOdQ" +
                                                              "1nMp6I7yBSVxnjRUUBJOW+fLA6ioA1pg1PQ8aEB8Qr7RlM4wsf7ZsnbTq389" +
                                                              "3SrjQIcZL4w23p6BP3/HDvLwO4f/0SXYVClYlX2b+WQS6jt8ztttm06jHPlH" +
                                                              "3l/x9Jv0GSgaANSONsME9lYLG1QLzZdw0lsRWQBQmIqdFaReMTpgBo7mUg5k" +
                                                              "MpBybdItfJsTR5RTPYk/yKJ2R5kNkq7z+dgT+z84+q4Ii3rECpxHoZoDSACY" +
                                                              "EojJVumuz+BTBd9/4xfdhBOygLT3u1VsVaGMWVYeJO+t0HcWKxA70f7xxLev" +
                                                              "vyQVCJf5EDE7de7xz6Knz0lfy15oTUk7Etwj+yGpDg59KN3qSqeIHYN/vHzi" +
                                                              "x8+fOCmlai+u7APQuL70q3+9G734u7fLFI95KdPUGZUAdw8mQAHuFxb7Ryr1" +
                                                              "wGMtPznTXj0ISDNE6nOGdizHhtQgV2jnnFwq4DC/zxITQfXQOZxUrUc/4MyX" +
                                                              "XK3xZ1vgeTtHdDApD4uJf3fmBcstYu2uAgURFESsjeCw1gmCdbGrA91+Ujlz" +
                                                              "9ZPm/Z+8flOYq/i6EMSmYWpJX7XhsA59tThcTHdRJwN091zZ87VW/cot4DgG" +
                                                              "HBVoGpwRGwp7vgjJXOraeb/56RuLjrxXTSKDpAHUVgepKApkPqAxczLQE+St" +
                                                              "r9wvwWiq3mua8qRE+ZIJBISV5aFmIGtxAQ4zP1z8/a3PXbomUNH1zLIgwy+I" +
                                                              "cT0Od4r5CD5GOamnkMM2COuDp/i0hNu5IHgWsbfJirk6bhHrs4+eu6SOPLsp" +
                                                              "4np2BwejmNadOptkeoBVBDkV9SvD4o7h18yPFpz9/Y96xnd8nlYF57pu04zg" +
                                                              "/5Xg1/Vzo0pYlDcf/fPSffdljnyOrmNlyEphlt8ZfvHtneuUsxFxoZINR8lF" +
                                                              "rHhTX3EWN9gMbo5Gcd6uKfi1w6v8G1y/bihf+UW84LChtJ7OtbVCJmcrrIkL" +
                                                              "RYaTVs0RXS/0U2qhbfiy2JLAQZPROfpfZhBOHLDEvFrQSYR6L3w3uzptrmCO" +
                                                              "8umDw6FQ19FRgWPIEh5wu7V7CdbuqbuVqGpmowzN4ci7gBDkeAUzPoRDDkqD" +
                                                              "LV8PlEPjmklTU32LTv4vLJoHoee6rSBsLSl5YSIv+crLl1rqF1968AORyYWL" +
                                                              "eBPkZDqn64GQDoZ3nWWztCYUbpIobomfxzlZXqntgf5QPgg1HpObnuCks+wm" +
                                                              "sBT+BGnPQICGaaG8id8g3ZOcNPh0cKx8CJKc56QaSPDxguU5fnPFpk1ezkPW" +
                                                              "zVeVYrzwa+ft/BrA7TVFeCfegXnYlJNvweB6eGn3nuM3v/is7PcVnc7MIJdG" +
                                                              "6Bnk1aOAb6vn5ObxqtvVe2vBK/PXepWgTQrsp9myQEwfgMywMIiWhpphp6fQ" +
                                                              "E384u/X1n5+qex+K9EFSRTnpOBh4AyVft0BHnYPCcjBe2htBLRBdel/vt6bv" +
                                                              "25j+229F+SSyl1o+N31SufrcoV+eXTIL3XzjEKmFIsfyY6RBcx6YNvYyZdIe" +
                                                              "I82AaHkQEbhoVC9qvBZgvFN8Oybs4pqzuTCLt0VOukv7ztI7NrQaU8zeYeYM" +
                                                              "1W3dGv2ZopdzXonIWVZogz8T6M0HJXigNyBik/Fhy/LacrLNEum/s3xnh+ML" +
                                                              "4hGH7/4H6X+YpB8XAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1aeazr2Fn3u2/eMq/TeW9mOtNhmH1eCzMu11mcxNG0pbHj" +
       "JE4cO4vjxAb66niLE+9L7LgMnVaUFipKBdMF1I6QmAqoposQFUioaBCCtmqF" +
       "VFSxSbQVQqJQKjp/UCoKlGPn3pt771uqERKRfOIcf98533Z+5/N38uK3oXOB" +
       "D8GuY2500wn31STcX5qV/XDjqsF+l64MJD9QFcKUgoADfdfkxz9z+bvf/8Di" +
       "yh50XoTukWzbCaXQcOxgpAaOuVYVGrq86yVN1QpC6Aq9lNYSEoWGidBGED5N" +
       "Q686xhpCV+lDERAgAgJEQHIRkMaOCjC9WrUji8g4JDsMPOjnoDM0dN6VM/FC" +
       "6LGTg7iSL1kHwwxyDcAIF7PfPFAqZ0586NEj3bc6X6fwB2HkuQ+/9crvnYUu" +
       "i9Blwx5n4shAiBBMIkJ3WKo1V/2goSiqIkJ32aqqjFXfkEwjzeUWobsDQ7el" +
       "MPLVIyNlnZGr+vmcO8vdIWe6+ZEcOv6Repqhmsrhr3OaKelA1/t2um41bGX9" +
       "QMFLBhDM1yRZPWS5bWXYSgg9cprjSMerPUAAWC9Yarhwjqa6zZZAB3T31nem" +
       "ZOvIOPQNWwek55wIzBJCD9x00MzWriSvJF29FkL3n6YbbB8BqttzQ2QsIXTv" +
       "abJ8JOClB0556Zh/vs288f1vtzv2Xi6zospmJv9FwPTwKaaRqqm+asvqlvGO" +
       "p+gPSfd97r17EASI7z1FvKX5g599+S1vePilL2xpfvQGNOx8qcrhNfmF+Z1f" +
       "eZB4sn42E+Oi6wRG5vwTmufhPzh48nTigpV339GI2cP9w4cvjf5cePYT6rf2" +
       "oEsUdF52zMgCcXSX7FiuYap+W7VVXwpVhYJuV22FyJ9T0AVwTxu2uu1lNS1Q" +
       "Qwq6zcy7zjv5b2AiDQyRmegCuDdszTm8d6Vwkd8nLgRBV8AF3Quuh6DtJ/8O" +
       "oQWycCwVkWTJNmwHGfhOpn+AqHY4B7ZdIHMQ9SskcCIfhCDi+DoigThYqAcP" +
       "ABtYlIYF4ggh14CLNlYql/8eu6psgGj397OIc/8f50oyva/EZ84Alzx4GhBM" +
       "sJY6jqmo/jX5uQgnX/7UtS/tHS2QA4uFUAVMv7+dfj+ffj+bfn87/f7NpofO" +
       "nMlnfU0mxjYIgAtXAAwATN7x5Phnum977+NnQfS58W3A/hkpcnO0JnbwQeUg" +
       "KYMYhl76SPxO/h2FPWjvJOxmooOuSxn7IAPLI1C8enq53Wjcy+/55nc//aFn" +
       "nN3CO4HjB3hwPWe2nh8/bWTfkVUFIORu+KcelT577XPPXN2DbgMgAYAxlEAg" +
       "A8x5+PQcJ9b104cYmelyDiisOb4lmdmjQ2C7FC58J9715N6/M7+/C9j4VVmg" +
       "PwGuxw8iP//Ont7jZu1rttGSOe2UFjkGv2nsfuxv/uKfy7m5D+H68rENcKyG" +
       "Tx+DiGywyzkY3LWLAc5XVUD39x8Z/NoHv/2en8oDAFA8caMJr2YtAaABuBCY" +
       "+d1f8P7261974at7u6AJwR4ZzU1DTo6UzPqhS7dQEsz2+p08AGJMsPSyqLk6" +
       "sS1HAcErzU01i9L/uvy64mf/9f1XtnFggp7DMHrDDx9g1/8jOPTsl976Hw/n" +
       "w5yRsy1uZ7Md2RY379mN3PB9aZPJkbzzLx/69c9LHwMIDFAvMFI1B7KzuQ3O" +
       "5prfG0JP3nKZgtWpKlnSAlYrmObJWyRGPuAIjfXBZoI8c/fXVx/95ie3G8Xp" +
       "necUsfre537pB/vvf27v2Pb8xHU75HGe7RadB96rtz78AficAdf/ZFfmu6xj" +
       "C9F3Ewf7xKNHG4XrJkCdx24lVj5F658+/cwf/c4z79mqcffJ3YkEydcn/+q/" +
       "v7z/kW988QYAeGHuOKYqbXGllDXVbbxhYbYOHCnM5Ufyvqfydj8TOPcPlD97" +
       "S9Y8EhwHoJOGP5YOXpM/8NXvvJr/zh+/nMtyMp88vt76kru13J1Z82hmiNee" +
       "RtuOFCwAHfoS89NXzJe+D0YUwYgy2FUC1gfIn5xYnQfU5y783Z/86X1v+8pZ" +
       "aK8FXQIKKi0pBzrodoAwarAAm0bi/uRbtgssvni4qybQdcpvDXX/QajeMvBa" +
       "WTq4g8n7/5M15+/6h+9dZ4Qc3W8Qi6f4ReTFjz5AvPlbOf8OZjPuh5Prd0OQ" +
       "Ou94S5+w/n3v8fN/tgddEKEr8kFezktmlIGXCHLR4DBZB7n7iecn88ptEvX0" +
       "0Tby4OnFcGza0wC/C0Jwn1Fn95d2Dq8mZwAAnivt1/YL2W8mZ3wsb69mzY9t" +
       "rZ7d/jhAyiDP77OQNWzJzMephiBiTPnq4briQb4PTHx1adYOYeVKHh2ZMvvb" +
       "JHm7R2Rt49hSaN40GqhDWYH379wNRjsg337fP37gy7/yxNeBi7rQuXVmPuCZ" +
       "YzMyUfYK8gsvfvChVz33jfflwA9Qn3/2df+WJ3TCrTTOmlHWjA9VfSBTdZzn" +
       "VLQUhP0cq1XlSNtTS/s20/k/aBve8b0OGlCNww9dFNRSPEmSlWYnmDBAGnQD" +
       "bi1iXPcatRXdbY2Y5tRuBHKnsCRhgWqTvaSeRnYbScpRdcOWVI2brtSJPu22" +
       "qCHV4Kkiwk4cSfRIr+1PeKtgeKsF43hjfuX1LGnEjz2R73WqCxysCkTqhnAZ" +
       "S6OaUlNhnvA8Q1PKTK3P1OtYWkfK6byC6vVhlYlMA3eQjSQElcKw3exWl2Gf" +
       "5jUXraZNWBpvHN6D11qziGhye9MqCqURvlj6TcKeCU5fLBRHq2Uv5ZqoMhpa" +
       "NNvpj/hyt51a/U40loNCIQGbQkVPTJovckyzEnh63K2b/RoXOk6lJk03Nlmq" +
       "NGldJCdyl1p1x1N6HmNhXVZ6K4uRClwNXQ0ZVJuSnZ7fgadxwfQRwlBcmpSL" +
       "yEiYdRh0Vket9ibh7KQ240YVUx2hdc+qJ9y8UVt7MxJnSuuwk1SrhY3Fi4au" +
       "J157I/DV1KxZ1sBZTWB2lYiYUmjZU3YiwUPJX7rNViMlzUG5GRRwR2ujLXww" +
       "rWA9t123RkZtPo/dYtRX3dTsDimyMm2lbOKRpZR2I3KFr9Bih5kpNVIMW0W+" +
       "0BK9qUQbkyQ0KhtUnq+LKjNdidSmJPUF3+gRDXJRGLTjXiOwSr1SUCzyFue2" +
       "S3oS1w0jZSTX71erdikphuVeA8PhWjmlehwrrEV0lWp8hHcK/TLbUzYFAvbM" +
       "0YSoICWfYxeFzmykVaKVw+BlUm210+Gw2ahx405UJgpFsuItZJ/arHusLmD1" +
       "mT4kSmkQbOwlSY/qE6FFiFQUxyN75C8DnqQG0748bocMQRLzVZVP+yt+Pi2O" +
       "RYftB8aIFJ3VmupKhETHG3yaAhN2+10uIkx3TK5xLUkFDJkWMJWZTSSSpzr9" +
       "nskUTBobMfa0xURFU5oK6abBVoKpWUeaiVJnPJcgWo0yvjLM5RCBBz4Dp0pp" +
       "NjPpghH7w5Qds4Ezsc2RNYnX6rRe09QSVjTM1toSqu3UQMaz9kiMzbK7KUaN" +
       "PhX0Oh0yqRpFtaRFaSOGkXiAjqlhsemSaFLn4ynqLZj+nJ26S6bWTVmB40xu" +
       "gS0w0VvWBbtEpdTAjtpCzHLRmFtG/WaFlGaTlLdUCrEInaEZnGxqRNCe2pxa" +
       "E5wUXdprckJJwmRdFbg1YVAI6qocRyRL0bT6vZAbNpvsNCDLkzK6wlGPa4Su" +
       "KRBeF6YiSWBHIdFvzyU0JXuyiC9qejfQq9wkWOCdQGh1S/hs1g11GJshE8Fx" +
       "2oVppdNXewECM6KqjGtC1fMIc7MZNGKKjbgxbTIzSyxO0ogvNZkEYzWLbTbF" +
       "Pskoht3e4Gh1sIF7Ojpw/M4IniWFucV2izyPhuNWjxL6Dbu5wKkG7nRaXA02" +
       "FuWJwiq80qy3TI6Z4kiXLUTeyq8PrC7a79YntC+X0+oGDiOLIXpWd1WWPAxP" +
       "+UBeBCEm42t32GUwdj4xiTVC95Ke2SgFTE10g+5k2CtVNo5Gu0pVFptzVq5R" +
       "cdwnfck14GBu0mPTrmzEKT1BkUCDjYigVhM+drBgITaavmyTDEazDMqNnMVG" +
       "a4XsbI0UsPWKcx2MH0mzjlfRTbbY7tRsXF70SxzPSGvHw6xZuh5RWAx3aoQ8" +
       "wfS63rciDDdbE4azY873JjrAgUKhNi7zMmalctxkS6w6GxgUHpIYRlPjWOpz" +
       "2iymtTnHzxOjGtE0Hs82cbPDAu9Sst8OzY5v8QiCruplAgBzSxLMAu71+yE6" +
       "Gzb5VdGoxR5WGJTKhZJQaJYL8oxcFRCF7ZjDhEiGPmGWhQbMIgJuoSQVY6mm" +
       "sev5Iqkrll+YYyyrDIt2361StQ0+5hN7OZpM8C47hTW6UTWcRtHVi4MhJpE4" +
       "NvRrI7OPxoFWEwN7znllrF4e+8shJYs0GpfKbhUflJFOc03HLKohhfFM4AlT" +
       "MGelOTwdjsGWgaVhGFqF6rIzMDtlE0nq3XWhPdalBjNmmaBP1k2BbheHdCoq" +
       "AMKD0XSIDy3KA4nmSO1zro47NWuiV1Z9F9/MFSrUugGA8hE3EFbIptctjSor" +
       "ZuXVUljROTjFUNhDKaPsk4SbdBzRaY4bhEA6yy4fWVEK4xyu1BE00ZQFzm50" +
       "mitHRT7gpXZ/ygtql4XDQkee9pJGraDVkoRW1+vNkCe6WoVskjVFrSVptWen" +
       "BVPbFCsON1nVyDBewpu229Qr9R5T9saeSnUEBll3UiPBYI0lLFMy4KjWGAwj" +
       "ulbwynC9XSujUU2jW1S90lMGk7Y4aSgxZg0bnaiVzGujjV+M2/1wkNrcbFmg" +
       "xk2GrNpsWzHSziIc6nxpadut2EObBJImFDfUZkNWTCb+REbQ/mY265UTsbjW" +
       "VS7sKM2G20SjrlbWLFwOQiEqRQ19MmqR42CpEnFRtwhl3vYb9SI8WZppXRxY" +
       "iAhjmskKHmJUyf7YEqZud1abLYJGpR5yC5nrKKNuzBTqxVTEavwUkZ0Qbert" +
       "Ds47bTcetWO3ttaX3RnrS+ocqVRHEb30kxk37jXdRmfC66rba7irgddI5JQe" +
       "kjDIKOvxOp4aXtmKJMwbkbBIdXFqzFeklkW1w6QxRNNBMcUQqTyYzR1rwnSK" +
       "KU3p8QamZK7AKqhfIZqVNitZ9qrfLxFs1HQRo7BgogrV0afBXOsa/qo6X3T8" +
       "AIXVqDpmB3TgorZbwmN1CXIKhXXDlergPN5c8fXxuok6tUUR2wxaLsiMhHo1" +
       "sRXMNoVWpeZGBTTVkcpMLyJ86hRcwWzKGqINxpqmmEt7w/oWY25Id2GGmKit" +
       "O6GtRpMgaSWOSDEjzGz5nQU3K5NTBqDI3Km0ZaUa9TSjGFfXWLu4QebGQoMn" +
       "UwyliUXYrbHhHIShJfs+taJHgsTxQWE0GyOFSclbzDVjU+rSjaE4GLGaq4kg" +
       "uDt0k1y3/OFYGFXpclyOUjf0LYLFIqsZV1vDYr010qcDilxU4qjG10AQRN48" +
       "4r22azlxyqCyUdOBIdTGJB04o2Zz5TVpHhuY5GBprUxuUi7R3Bpd012n46hq" +
       "1R/jAQDeijCm1rDs02bR91rFehVrsKONMKVVfLASm55dRdvDpiOW7ek0DQlh" +
       "MncpB7gTZAGmOPPsUNcqw4GuFzsuO7cjYhXAsRXgHIy37cGQItqS1MYMBdPL" +
       "Iiszg0VB7iUY0e3JlepQGg+aiR5NKpoNXLYqqulqME15lRf8NJZgLURwHyQ5" +
       "fEslNFWf2YLZZdaxilfVtl22o355jRhBbSDztlzrU12lXcXtVVFiG/Pq2q6w" +
       "88QL17xaWuM9ZDBT3anODf3ArVubIRlren8T9yljunDdhVvVhmQZQyNkVrQr" +
       "sKcmcK9OtsYjznZZfIE2NrwWFvCOLQwIeYmrpUWI0yNcUU1kHVbn61JlCZdK" +
       "9RY8Hm/MogMz5eI40nzZ4WF1xlF0eZYuyZ7VogJtI1RHuJxUBWYtbESFUims" +
       "1JA6qyE5Xzg8UffWuKivW2An3cwD1PXSiCPosMCz0WpdS0OqxvhDaYKlqqAK" +
       "/eK0rLTXJdFxlXTm2NSUFx09xbhqv9Dpzgyd2eDGCmktNggtARczZGQhQTmx" +
       "F3CfRhdgv0TQTnUGCy6OzcCbzpuyVyD1lb2a3ZW/hR6d24A3suzB5BW8fSU3" +
       "nnDv4O33ojQPQl+Sw12lMP9cPn0QcLxSuCtdQFlx5aGbndXkFaYX3vXc8wr7" +
       "8eLeQcmnHkK3h477E6a6Vs1jQ+2BkZ66eRWknx9V7UoRn3/XvzzAvXnxtldQ" +
       "5H7klJynh/zd/otfbL9e/tU96OxRYeK6Q7STTE+fLEdc8tUw8m3uRFHioSPL" +
       "3nNYaIYPLAvfuNB8Q4+dyT22DYxbVNSeucWzd2RNEkJXjCA/niAcWzkqSVd2" +
       "8bT5YW/zxwfOO6IjHV+TdT4JrtKBjqVXoOPe0TKwb6jomYMzkYMazP1ZaTcu" +
       "y/uKY+2rmUbB9twlZ/7FW1jil7Pm50Pogr89ir1hnWPtGMrOKO9+JUYBRr7/" +
       "ZidAWTn7/usOobcHp/Knnr988bXPT/46PwQ5Oty8nYYuapFpHq98Hbs/7/qq" +
       "ZuSK3b6tg7n514dD6MFbVb9D6Pz2Jpf/Q1um3wihe2/IBCySfR2n/RiIpdO0" +
       "IXQu/z5O95shdGlHB6bd3hwn+a0QOgtIstsX3EMHl25Zu98eeJ6ybnLmJDwd" +
       "+e/uH+a/Y4j2xAkcyv9XcIgZ0fafBdfkTz/fZd7+cvXj22Mf2ZTSNBvlIg1d" +
       "2J5AHeHOYzcd7XCs850nv3/nZ25/3SFG3rkVeLdSjsn2yI3PWEjLDfNTkfQP" +
       "X/v7b/zt57+WVwX/F/WnFpTwIQAA");
}
