package org.apache.batik.css.parser;
public class DefaultBeginHyphenAttributeCondition extends org.apache.batik.css.parser.DefaultAttributeCondition {
    public DefaultBeginHyphenAttributeCondition(java.lang.String localName,
                                                java.lang.String namespaceURI,
                                                boolean specified,
                                                java.lang.String value) {
        super(
          localName,
          namespaceURI,
          specified,
          value);
    }
    public short getConditionType() { return SAC_BEGIN_HYPHEN_ATTRIBUTE_CONDITION;
    }
    public java.lang.String toString() { return "[" + getLocalName(
                                                        ) + "|=\"" +
                                         getValue(
                                           ) +
                                         "\"]"; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAMVYe2wUxxmfO7/fDzAQAwaMoeJ1G1qIGpmkYGODydmcsINU" +
                                                              "Uzjm9ubuFu/tLruz9tmp24AU4bQqRZQkNEr4oyVKWiUhqhq1VZuIKlKTKGml" +
                                                              "pKhpWoVUaqXSB2pQpfQP2qbfzOzt684Gqko9aef2Zr755nv+vm/u+euoyjJR" +
                                                              "F9FojE4bxIoNaDSBTYuk+1VsWWMwl5SfqMB/P3Jt5N4oqh5HzTlsDcvYIoMK" +
                                                              "UdPWOFqpaBbFmkysEULSbEfCJBYxJzFVdG0cdSjWUN5QFVmhw3qaMIKD2Iyj" +
                                                              "NkypqaRsSoYcBhStjIMkEpdE2hVe7o2jRlk3pj3yZT7yft8Ko8x7Z1kUtcaP" +
                                                              "4Uks2VRRpbhi0d6CiTYZujqdVXUaIwUaO6Zud0ywL769xATdL7V8fPNMrpWb" +
                                                              "YBHWNJ1y9awDxNLVSZKOoxZvdkAlees4+hKqiKMGHzFFPfHioRIcKsGhRW09" +
                                                              "KpC+iWh2vl/n6tAip2pDZgJRtCbIxMAmzjtsElxm4FBLHd35ZtB2taut0LJE" +
                                                              "xcc2SeeeONL6vQrUMo5aFG2UiSODEBQOGQeDknyKmNaudJqkx1GbBs4eJaaC" +
                                                              "VWXG8XS7pWQ1TG1wf9EsbNI2iMnP9GwFfgTdTFumuumql+EB5fyqyqg4C7ou" +
                                                              "8XQVGg6yeVCwXgHBzAyGuHO2VE4oWpqiVeEdro49DwABbK3JE5rT3aMqNQwT" +
                                                              "qF2EiIq1rDQKoadlgbRKhwA0KeqclymztYHlCZwlSRaRIbqEWAKqOm4ItoWi" +
                                                              "jjAZ5wRe6gx5yeef6yM7Tj+k7dWiKAIyp4msMvkbYFNXaNMBkiEmgTwQGxs3" +
                                                              "xh/HS16ZiyIExB0hYkHzgy/e2Lm56/IbgmZ5GZr9qWNEpkn5Yqr5nRX9G+6t" +
                                                              "YGLUGrqlMOcHNOdZlnBWegsGIMwSlyNbjBUXLx/42ecf/i75SxTVD6FqWVft" +
                                                              "PMRRm6znDUUl5h6iERNTkh5CdURL9/P1IVQD73FFI2J2fyZjETqEKlU+Va3z" +
                                                              "32CiDLBgJqqHd0XL6MV3A9Mcfy8YCKEaeFAjPCuQ+PBviiwpp+eJhGWsKZou" +
                                                              "JUyd6W9JgDgpsG1OSkHUT0iWbpsQgpJuZiUMcZAjzoJsWSwzAQil3SSDbZX2" +
                                                              "kayi7Z02ckRzsQ3SK80tEWPBZ/x/ji0wayyaikTAUSvCMKFChu3V1TQxk/I5" +
                                                              "u2/gxovJt0QIsrRx7EjRTpAkJiSJcUliIElMSBK7HUlQJMIFWMwkElECPp4A" +
                                                              "tAC4btwwenjf0bnuCghPY6oSHMRIuwNlq9+DlGIdSMqX2ptm1lzd+loUVcZR" +
                                                              "O5apjVVWhXaZWcA3ecKBgMYUFDSvrqz21RVWEE1dJmmAtfnqi8OlVp8kJpun" +
                                                              "aLGPQ7HqsfyW5q85ZeVHl89PnTj45bujKBosJezIKkBBtj3BCoAL9D1hCCnH" +
                                                              "t+XUtY8vPT6re2ASqE3Fklqyk+nQHQ6RsHmS8sbV+OXkK7M93Ox1APYUQ3IC" +
                                                              "jnaFzwhgVW8R95kutaBwRjfzWGVLRRvX05ypT3kzPHbb+PtiCIsGlrwSPN1O" +
                                                              "NvNvtrrEYONSEesszkJa8Lpy36jx9K9/8afPcHMXS1CLr3cYJbTXB3uMWTsH" +
                                                              "uDYvbMdMQoDug/OJbzx2/dQhHrNAsbbcgT1s7Ae4AxeCmR954/j7H169eCXq" +
                                                              "xTmFum+noH0quEqyeVS/gJJw2npPHoBNFTCERU3PgxrEp5JRcEolLLH+2bJu" +
                                                              "68t/Pd0q4kCFmWIYbb41A2/+rj708FtH/tHF2URkVrY9m3lkohYs8jjvMk08" +
                                                              "zeQonHh35Tdfx09DVQEkt5QZwsG5ktugkmu+DLo4vpNV6Jio0Gz+niASsGwb" +
                                                              "tVMWZK2SBydNOlXw04mj8lxP4g+iwt1VZoOg63hO+trB9469zUOgluECm2cH" +
                                                              "NfmyHvDDF3+twjWfwCcCz7/Zw1zCJkQ1ae93Stpqt6YZRgEk37BAExpUQJpt" +
                                                              "/3DiqWsvCAXCNT9ETObOfeWT2Olzwq+iMVpb0pv494jmSKjDhl4m3ZqFTuE7" +
                                                              "Bv94afbHz82eElK1B8v8AHSxL/zqX2/Hzv/uzTI1oyal6yrBAsy2sWB3oX1x" +
                                                              "0D9Cqd2PtvzkTHvFIKDKEKq1NeW4TYbSfq7Q21l2yucwr+niE371mHMoimwE" +
                                                              "P/Aw4uN2LsvdrkSIS4T42j42rLP8CBv0ma+HT8pnrnzUdPCjV29wvYOXAD+g" +
                                                              "DGNDGL2NDeuZ0ZeGK+BebOWAbtvlkS+0qpdvAsdx4ChD/bf2m1CYCwH4cair" +
                                                              "an7z09eWHH2nAkUHUb2q4/Qg5kiO6gBCiZWDml4wPrdTIMhULQytXFVUonzJ" +
                                                              "BMviVeXxYSBvUJ7RMz9c+v0dz164yqHMEDyW+xl+ig2bXFDjn+pwH+YHtQAH" +
                                                              "E62cr1XmcXnx5LkL6f3PbI06zuujoLdubFHJJFF9rKKMU6CPGOaXA6+WfdB8" +
                                                              "9vc/6sn23UkLwea6btEksN+rwHUb50eAsCivn/xz59j9uaN30A2sClkpzPI7" +
                                                              "w8+/uWe9fDbKb0KiESi5QQU39QYzrt4kcOXTgjm21vVrG/PXGni2OH7dUr4i" +
                                                              "lwkJt87Nt3WBZM0ssMa7fwzlJEuo23+6LcVnHfRjX/f53ndRVAVZY9IwXLGf" +
                                                              "ewTNA2xIifeR/zK32MSYwecPu6ZoZ2ud8GxzTLHtzq0439YFLFVYYG2GDYBm" +
                                                              "tVT3F2PXDPR/YYYCtKW3c3tgiLSs5B8OcSuXX7zQUrv0woPv8Qx2b86NkIsZ" +
                                                              "W1V9oewP62rDJBmFa9ooAFrUiZMULV/grsPaNf7CNToh9jwCF4JyeyiqgNFP" +
                                                              "OQdRGaaEuOPffrqvUlTv0cGh4sVPchq4Awl7/bpR7KC238Y1rdS6hUgpfHMf" +
                                                              "d9zKxz68XhvAOf6nVRGTbPG3FVzXLuwbeejGPc+I/ltW8QyPsgao6+Iq4OLa" +
                                                              "mnm5FXlV791ws/mlunXFCtAmBPbyZLkvmMcgjw0WRJ2h5tTqcXvU9y/uePXn" +
                                                              "c9XvQv09hCKAH4sO+f4yEv+PQIdrQ0E5FC/tX6AG8K65d8OT0/dvzvztt7wy" +
                                                              "ItHvrJifPilfefbwL88uuwjddcMQqoLiRgrjqF6xdk9rB4g8aY6jJsUaKICI" +
                                                              "wEXBaqA5ambxjll+crs45mxyZ9ntjaLu0t6w9M4LXcQUMft0W0s77VWDNxP4" +
                                                              "N61YGmzDCG3wZnz986CAWeYNCNpkfNgwiq1zzU6DQ8Ge8qjLxm/xVzZ8+z9I" +
                                                              "Jc000BYAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAMVZe8wrx1Xf+yX3kds09yZt05Cmed4UErff2uv12qu0pev1" +
       "2mt7ba9f6wfQm33a633vzj68EEgrlVRUhALpA2jzVyugSh9CrUBCRUEI2qoV" +
       "UlHFS6KtEBKFUtH8QUEUKLPr+z3vze1DSFja8ezMOWfOOXPmN7NnXvgWcjbw" +
       "kYLrmNuV6YB9NQH7G7OyD7auGux3uAov+oGq0KYYBBPYdlV++FOXvvPd964v" +
       "7yHnlsirRNt2gAh0xw5GauCYkapwyKWjVsZUrQAgl7mNGIloCHQT5fQAPMEh" +
       "rzjGCpAr3IEKKFQBhSqguQoodUQFmV6p2qFFZxyiDQIP+XnkDIecc+VMPYA8" +
       "dFKIK/qidU0Mn1sAJVzI3gVoVM6c+MiDh7bvbL7O4PcV0Oc+8PbLv3cLcmmJ" +
       "XNLtcaaODJUAcJAlcrulWpLqB5SiqMoSudNWVWWs+rpo6mmu9xK5K9BXtghC" +
       "Xz10UtYYuqqfj3nkudvlzDY/lIHjH5qn6aqpHLyd1UxxBW29+8jWnYXNrB0a" +
       "eFGHivmaKKsHLLcauq0A5IHTHIc2XulCAsh63lLB2jkc6lZbhA3IXbu5M0V7" +
       "hY6Br9srSHrWCeEoALn3ZYVmvnZF2RBX6lWA3HOajt91QarbckdkLAB5zWmy" +
       "XBKcpXtPzdKx+flW/83P/qzN2nu5zooqm5n+FyDT/aeYRqqm+qotqzvG2x/n" +
       "3i/e/dl37yEIJH7NKeIdze//3Etve+P9L35+R/O6G9AMpI0qg6vyR6Q7vnwf" +
       "/Rh5S6bGBdcJ9GzyT1iehz9/reeJxIUr7+5DiVnn/kHni6M/Wzz9MfWbe8jF" +
       "NnJOdszQgnF0p+xYrm6qfku1VV8EqtJGblNthc7728h5WOd0W921DjQtUEEb" +
       "udXMm845+Tt0kQZFZC46D+u6rTkHdVcE67yeuAiCnIcPcjt87kN2v/wfIAG6" +
       "diwVFWXR1m0H5X0nsz9AVRtI0LdrVIJRb6CBE/owBFHHX6EijIO1eq1DDoJs" +
       "ZQaqjzZUTQxNUFdXus1u3bVqUwAGmARDCy4vJffEfhZ87v/PsEnmjcvxmTNw" +
       "ou47DRMmXGGsYyqqf1V+LqwzL33i6hf3DpfNNT8C5G1Qk/2dJvu5JvtQk/2d" +
       "Jvs/iCbImTO5Aq/ONNpFCZxjA6IFxNHbHxv/TOfJdz98CwxPN74VTlBGir48" +
       "nNNH+NLOUVSGQY68+MH4HcIvFPeQvZO4nFkBmy5m7HyGpoeoeeX0eryR3EvP" +
       "fOM7n3z/U87RyjwB9NcA43rObME/fNrfviOrCoTQI/GPPyh+5upnn7qyh9wK" +
       "UQQiJxBhpENQuv/0GCcW/hMHIJrZchYarDm+JZpZ1wHyXQRr34mPWvJAuCOv" +
       "3wl9/IpsJaDwefja0sj/s95XuVn56l3gZJN2yoocpN8ydj/813/+T+Xc3Qd4" +
       "funYDjlWwRPHMCQTdilHizuPYmDiqyqk+7sP8r/+vm8981N5AECKR2404JWs" +
       "pCF2wCmEbn7X572/+dpXP/KVvaOgAXATDSVTl5NDI7N25OJNjISjveFIH4hB" +
       "JlyQWdRcmdqWo+iaLkqmmkXpf116tPSZf3n28i4OTNhyEEZv/P4Cjtp/rI48" +
       "/cW3//v9uZgzcrYHHvnsiGwHrK86kkz5vrjN9Eje8Rev/43PiR+GEA1hMdBT" +
       "NUe6W3Mf3Jpb/hp4Vsk5s+1uf7fdZe1FKPKxm5ySfN2CcxVd21nQp+76mvGh" +
       "b3x8t2uc3oZOEavvfu6Xvrf/7HN7x/bqR67bLo/z7PbrPMheuZuv78HfGfj8" +
       "T/Zk85Q17PD6LvrapvHg4a7hugk056GbqZUP0fzHTz71h7/z1DM7M+46uVUx" +
       "8CT28b/87y/tf/DrX7gB7p2XHMdUxTx4i7mqaK7q43m5n+mWux3J+96SFQ8E" +
       "x3HlpI+PHQOvyu/9yrdfKXz7j17Khz15jjy+jHqiu3PSHVnxYGbza0+DKCsG" +
       "a0iHv9j/6cvmi9+FEpdQogy3kGDgQ2xPTiy6a9Rnz//tH//J3U9++RZkr4lc" +
       "NB1RaYo5fiG3QeBQgzXcFhL3J9+2WzfxBVhczk1FrjN+t97uyd9uuXmMNbNj" +
       "4BH63fOfA1N659//x3VOyEH7BmF3in+JvvChe+m3fjPnP0LPjPv+5Pr9Dh6Z" +
       "j3ixj1n/tvfwuT/dQ84vkcvytfO4IJphhklLeAYNDg7p8Mx+ov/keXJ3eHri" +
       "cHe473TcHxv2NG4fxRusZ9RZ/eLRhBPJGYhrZ7H96n4xe+/mjA/l5ZWs+PGd" +
       "17PqT0AADPJzPeTQdFs0czkEgBFjylcOlpAAz/nQxVc2ZjWP6x3MZ+VbdyPm" +
       "deplZ755oBec6TuOYIZz4Jn6Pf/w3i/9yiNfg9PRQc5GmavgLBzDon6YfWb8" +
       "4gvve/0rnvv6e3LshsAtPP3ov+aHtsnNrMuKQVbwB2bdm5k1zg9LnBiAXg63" +
       "qpJZlovAjtlTAxC0nR0O/kjWgts/zeJBmzr49YSFisXTJLG0QRXVGik1pGKx" +
       "56idUqvktVuuZSxag8ZWseSg3Z9O041FhlLYDFHA+WFKAsvFcGqKS0NvtBwa" +
       "fcbHna3QnenTtbf2SsIybHfN7qTbsky3u3ZnjjAVvfm4jrlDVxvymCdp6SAF" +
       "RA1veYZDiqqGLf1qpWJHhchCw4IaOttNZ9Qkm86GwaWk7fTFxrg+WYRGoSQE" +
       "s1kvNitjzevVUb7cAZU+7njrCptOzKAhR4u20+tOFX42aHquWJealrENmCk3" +
       "lhiN7tQXSSdtCkqrKCvjzWzarwybgrWOy57Ya3cbWHu76Rtb1xNHwdhZyPX1" +
       "GGzaPYNxFQZbC2rVwTYj0yi7m/J2OaluNVDrOrWkuiwZUyCLPD41AkwYjVxp" +
       "rRcVgtYni2W48RRhPhXb8VQcEMtQKW5jrkqQCTVRuKpQ0/h+z3dn0qLOzvqd" +
       "0pYU40bS54TxsjtwkmWkGJSpqgFeWHc9vdtrsWmzyWus7ozacjdorUezItl1" +
       "6YI+W2ORidoEoHQXcxvLVWcEaKmd9Cgr3YCAMRMLb9Y5VilXlqCOATEERa7D" +
       "JLKMjVVVHfQ5Ihr6055TEZstbKqPBw2mPhy0hmrDsLddqy+GSsczklJLqge4" +
       "2hFFWpjNW7X5uOrOhqVJqxRrJBNI/Tam92yebMVNbTVRJs3QCkPLMwtMvaJt" +
       "va23wumqE9bmQ6G1IraqQMfzFVtPqW0rZAeYwODOzPV0QWUU38HJRkzVpW65" +
       "w1T8SVnsef1hPPGaGKO3vZLfGHYh/psradRdx1Sxq3qyubVSsGBNehmb45E4" +
       "akseM6O63sDC28CZ6ZsNtazEI5VYJZWtqmrEtledbApGVZnpXaq9dXEr6EWG" +
       "tGj252K/Vzd0xlpN4mErCcrJGmXHJWKpb9tMUi+uFwabrraoinFWhUDb0spa" +
       "VlpLn/RmfcY17MrC8yv2aE62CgRYtLhpy/fM3kBm+wNladr1mboKWu1ePDa3" +
       "fWlTn865BMUxVdZQvVoZJxOhQTS9maABvjcaWURqN6ZTs7ImdGbUnxjrCq1M" +
       "RxyJ8qW2MGxUy81mG+tg2na5YSYe0zWnBUEsp2WM1htcfdXxPFYpzjmiJ5Qp" +
       "sidr29qC7jKi2qQ2PB0OC3w90vXYdQtqZ92aBd2lE3amW4WYkZ1VY+UGrdJg" +
       "bLDTSVGfSW4wXLmdcKlPe/KS2qROJ5iNY4gkulkejxvSco4Z4lavLouYbIzS" +
       "YFged2tFwMz4+hJN0I1ejMXtVtSNCTUdR3Sv26TXYVkoTYaJgbYrIYauEifq" +
       "gOKwHfijpMpsRhOXMjr6uCNPTb3NmL1xvVtlp+aw02s3ISQYjMnQvItTgKJx" +
       "CcSxam+0omSH9GrNLwhnzPZG7TDumx5ZaJittjLueXPMBVbJTJWC6UwFeTka" +
       "VER3Iwiz9VxczmSqrMrd+qq3mDYb48j3Uqw0EmYMU1I6lkUBzfb02sAU3JrR" +
       "cUNb5Fr8sMp6gbadVbxaZakKrFkjeXuywStSuOnWnaCjpu2uUa+DTblOOxRH" +
       "NkprmrZZUJhPwaIW8RPCVzFq7DHlpmF6W6NgD9khMQpYa1wLJKEwmBvdao8s" +
       "D5ISxS+mw3Kb3thiM43XK2FWG5EVIwRiPR5ttHTWErjRKJoXK1t3UjZSnpWk" +
       "Ag90uh20TD8e8/3SoB/1I+D7zGLQHzPw0JUaHbHGudsysUnILonWRI2X2d58" +
       "XKI5vywvOtJkXi+HvdkkYMPGIpJ6Sm/oNEJ4lOhIaYKhynDN+n0qkCR5NSkF" +
       "VUrFqUSlLagZjm6qbIkgVXruJRMLokLBdtiiFzIexIAxuup0Ysx2edap95sT" +
       "mhlNy/wq8Rm30hnJjGNyHFvApE5I1ADKK0UPN+imNWsvJAkvURha8DfVYq0J" +
       "WBSwTWw6MgR/QVpl03DWi6C22UQ9o1hL1aFjs+tyZaJoSZFsCEPGAJXhMg5a" +
       "FQOEK8MKCw3OwSO3LxAd3Sm20oKtU+OgFUtA6M2WXWxc3yr9gTmPi7i1qZkJ" +
       "j68KegzgtucMVkR5PSgAv07iBJlOByszZGgLg+tds7Zs1Gg0ywUQb2ZaTMt0" +
       "WkWXcSmlO8awJKpkeQxcDxCL5WjFGOVqnWISdzrsuAAtN3RvFkQ0Naf7E5KZ" +
       "DKSBps4m2MBMY6+g9wRXKroRTuIba9zdNNYmbpWXXnMSMtV6ROKiJrFpDVMZ" +
       "s1uq16IaxY4TDk1h8KNsGqFhOmmXnK1oElu/TgVbLJjVy868lBQbJO0pGA+i" +
       "1JiwURNuj12m65X66gyfLCS4AVeHWMnEtqEc+9BLTLlastieo1sxw6NUjId9" +
       "jAsixTfG7TE+wbENjvkcX6PrUdESC+yk5tq+ncKtmt4IGBlHi8GcahRWjVa/" +
       "0eKwfkMNl8Wl2uoW6qo0mFESiExjXCh6rhJRgZLg9LqBShpmlegFHbO4LOq+" +
       "aFfTIqnOWBazKWPKTiXMw9HhqmLoA2JVp/XlrGGZeMz7yqTdW0+54RbMm8LU" +
       "sdNOvRfBPWeeLMb1aNqpjnopKReiopKWCHzrsT2msZ0VErOgrzBp3mxs7IIb" +
       "s4UFC4YUyxCY7Jfmljy3kwpncIRW5qV2kUjDcONwSig12U6n2ST9brc3JWi+" +
       "NRDnFFGYaUq9RkYySgQ2Vp4aXKyKhAQYI+gX/BhqXymqVEDrkY0maYXckKHY" +
       "LxcpLKBNw035djWuFdBwppJaQ+pKxa7OjPXKcDgtk8NF6gPckAfzyWpjYaVI" +
       "8FsoP2/ZOjZgq8rUx3UzNjqgVu2D8qy+7BWDoCdWtTg1O0zoYOUCwcmCzWqj" +
       "zRzVKmVbGQmUsFyQ7XjOtTQ1nvQpLGnrmjpC024Z640XsSrzIbF0llio1FpJ" +
       "OuFYkHpFvEwumlxTWCxaWKuxqFtAmJSbGD9v8CN0sVjQoDsry2Ww0rlxUKnX" +
       "BvI4nM+r6XDqR8XY4aPaMMGkGtE32sFyVhJIR415AvMbnbrVFEnHoZr+VF/2" +
       "ppyArvyAF/taFa4TZ01uYrqJd7bqVvdW/SY/GCqjligy4YDXNN+LpuYkKsqt" +
       "NR4IvLz2cCo2q6jkjqpdGivXFiVfGRPr6crV2J6mkGk3SYnafB1RA42whVFr" +
       "IvGtclNI51wYS6q6afFyoY2aYFYbbvlgJTpEoe3hA060bKvSnJtClSzFAWqZ" +
       "oT1v0oCy6ry0XXJGZPXk1SYuzkYdbF0BE0+eR1Nyi4YqP7dlch4NoyK5prsU" +
       "PMMPChq+ZaICP2wr/rDIVJo0CuYE1ap1iYpSG0yKqBKlUQpANd62ARv5HV3j" +
       "dVNTNSnmarUwjDeKIveGnsPpo5W/8ZpEohikX8dXNXFBbDrBVOy26XbMzOui" +
       "R1VES0o2plmQ/QCvWMl2SdpgI3JhERAx2cO5uTyc9jRQnBWDalWYNfoQDvtE" +
       "adGy0gbdKsdLOyVrBE3N1EWf7ruG1l/FuldK0ynRGNZaas3bcImFJkK6rBVS" +
       "st2Ri8VifQE/Ut6S5ySe/OE+q+7MvxYP71V+hO/EXddDWfHoYS4u/507nYs/" +
       "nos7yiIgWZ7j9S93XZLndT7yzueeVwYfLe1dy76QALkNOO6bTDVSzWOi9qCk" +
       "x18+IdHLb4uOsgKfe+c/3zt56/rJHyKN/MApPU+L/N3eC19ovUH+tT3klsMc" +
       "wXX3WCeZnjiZGbjoqyD07cmJ/MDrDz2be/ch+LzpmmffdONU7g2j4EweBbu5" +
       "v0lyK7pJX154ALm8UsFhyv8w8XzqK/xssHZ8cBRH/vf7Aj8+Wt5gHxp+V9Z4" +
       "L3zwa4bj//eGv+smfc9kxdMAuQCc41nWQ9ve8cPYlgDkyg9yl5Ilhu+57r53" +
       "d0cpf+L5Sxde+/z0r/LrhMN7xNs45IIWmubxZNOx+jnXVzU9t+i2XerJzf+e" +
       "BcjrbnLzk+Xb80puyi/veH4VIK++EQ9AboHlccrnYMCcpoThkf8fp/sAQC4e" +
       "0cFBd5XjJL8JpUOSrPpb7kEKvPIDXFpd793kzEkYOpzLu77fXB5DrkdO4E1+" +
       "hX+ADeHuEv+q/MnnO/2ffYn46O4CRTbFNM2kXOCQ87u7nEN8eehlpR3IOsc+" +
       "9t07PnXbowdYeMdO4aPgP6bbAze+rWAsF+T3C+kfvPbTb/7t57+aJ+f+F+IZ" +
       "2gJbIQAA");
}
