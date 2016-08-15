package org.apache.batik.anim.values;
public class AnimatableIntegerValue extends org.apache.batik.anim.values.AnimatableValue {
    protected int value;
    protected AnimatableIntegerValue(org.apache.batik.dom.anim.AnimationTarget target) {
        super(
          target);
    }
    public AnimatableIntegerValue(org.apache.batik.dom.anim.AnimationTarget target,
                                  int v) { super(target);
                                           value = v; }
    public org.apache.batik.anim.values.AnimatableValue interpolate(org.apache.batik.anim.values.AnimatableValue result,
                                                                    org.apache.batik.anim.values.AnimatableValue to,
                                                                    float interpolation,
                                                                    org.apache.batik.anim.values.AnimatableValue accumulation,
                                                                    int multiplier) {
        org.apache.batik.anim.values.AnimatableIntegerValue res;
        if (result ==
              null) {
            res =
              new org.apache.batik.anim.values.AnimatableIntegerValue(
                target);
        }
        else {
            res =
              (org.apache.batik.anim.values.AnimatableIntegerValue)
                result;
        }
        int v =
          value;
        if (to !=
              null) {
            org.apache.batik.anim.values.AnimatableIntegerValue toInteger =
              (org.apache.batik.anim.values.AnimatableIntegerValue)
                to;
            v +=
              value +
                interpolation *
                (toInteger.
                   getValue(
                     ) -
                   value);
        }
        if (accumulation !=
              null) {
            org.apache.batik.anim.values.AnimatableIntegerValue accInteger =
              (org.apache.batik.anim.values.AnimatableIntegerValue)
                accumulation;
            v +=
              multiplier *
                accInteger.
                getValue(
                  );
        }
        if (res.
              value !=
              v) {
            res.
              value =
              v;
            res.
              hasChanged =
              true;
        }
        return res;
    }
    public int getValue() { return value;
    }
    public boolean canPace() { return true;
    }
    public float distanceTo(org.apache.batik.anim.values.AnimatableValue other) {
        org.apache.batik.anim.values.AnimatableIntegerValue o =
          (org.apache.batik.anim.values.AnimatableIntegerValue)
            other;
        return java.lang.Math.
          abs(
            value -
              o.
                value);
    }
    public org.apache.batik.anim.values.AnimatableValue getZeroValue() {
        return new org.apache.batik.anim.values.AnimatableIntegerValue(
          target,
          0);
    }
    public java.lang.String getCssText() {
        return java.lang.Integer.
          toString(
            value);
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
      ("H4sIAAAAAAAAAL06eezkVnneX7K7yRKym0COLrmzQJOhP4/H9sxYyzX2HPaM" +
       "PYftOduy+LZnfB/jmaFpAdEmKuVQCTRIkP4T1EK51IKKWtGmasshUFUQaqFq" +
       "AaEetBQJ/iitCi199vyu/e1mIUrUkfzm+b3vfe999/fe84e/C52MQqjge/ba" +
       "sL14V1vFu3Mb343Xvhbttlm8L4WRplK2FEUiaLukPPDxsz/44TvNczvQqRn0" +
       "Isl1vViKLc+NeC3y7KWmstDZw9aGrTlRDJ1j59JSgpPYsmHWiuKLLPSCI0Nj" +
       "6AK7vwQYLAEGS4DzJcC1Qygw6IWamzhUNkJy4yiAfhk6wUKnfCVbXgzdfzkS" +
       "XwolZw9NP6cAYLghex8BovLBqxC674D2Lc1XEPzuAvz4b73u3O9fB52dQWct" +
       "V8iWo4BFxGCSGXSTozmyFkY1VdXUGXSLq2mqoIWWZFubfN0z6NbIMlwpTkLt" +
       "gElZY+JrYT7nIeduUjLawkSJvfCAPN3SbHX/7aRuSwag9fZDWrcUNrN2QOAZ" +
       "Cyws1CVF2x9y/cJy1Ri69/iIAxovdAAAGHra0WLTO5jqelcCDdCtW9nZkmvA" +
       "QhxargFAT3oJmCWGzj8j0ozXvqQsJEO7FEN3Hofrb7sA1I05I7IhMXTbcbAc" +
       "E5DS+WNSOiKf73Zf+fY3uLS7k69Z1RQ7W/8NYNA9xwbxmq6Fmqto24E3Pcy+" +
       "R7r904/tQBAAvu0Y8BbmD3/p+699xT1Pf24L85KrwPTkuabEl5Sn5Ju/dBf1" +
       "EHFdtowbfC+yMuFfRnmu/v29nosrH1je7QcYs87d/c6n+c9M3/gh7Ts70BkG" +
       "OqV4duIAPbpF8RzfsrWwpblaKMWaykA3aq5K5f0MdBrUWcvVtq09XY+0mIGu" +
       "t/OmU17+DlikAxQZi06DuuXq3n7dl2Izr698CIJOgwe6CTx3Q9tf/h9DOmx6" +
       "jgZLiuRargf3Qy+jP4I1N5YBb01YBlq/gCMvCYEKwl5owBLQA1Pb6wDDHHgp" +
       "2Ulu3JYjxZJsawxQWkMLR1n7bqZv/v/bTKuM5nPpiRNAHHcddwY2sCPas1Ut" +
       "vKQ8npCN73/00hd2Doxjj1sxhILJd7eT7+aT72aT724n37365NCJE/mcL84W" +
       "sRU/EN4CuAHgIG96SPjF9usfe+A6oHd+ej3g/A4AhZ/ZT1OHjoPJ3aMCtBd6" +
       "+on0TaNfKe5AO5c73GzhoOlMNryfuckDd3jhuKFdDe/ZR7/9g4+95xHv0OQu" +
       "8+B7nuDKkZklP3CcxaGnaCrwjYfoH75P+uSlTz9yYQe6HrgH4BJjCagw8Db3" +
       "HJ/jMou+uO8dM1pOAoJ1L3QkO+vad2lnYjP00sOWXPY35/VbAI9vzlT8Anhe" +
       "vqfz+X/W+yI/K1+81ZVMaMeoyL3vqwT//V/9q39Fc3bvO+qzR0KfoMUXjziH" +
       "DNnZ3A3ccqgDYqhpAO4fnui/693fffTncwUAEA9ebcILWUkBpwBECNj8q58L" +
       "vvaNrz/1lZ0DpTkRQzf6oRcDu9HU1QGdWRf0wmvQCSZ82eGSgH+xAYZMcS4M" +
       "XcdTLd3KtDlT1B+dfSnyyX9/+7mtKtigZV+TXvGTERy2/wwJvfELr/vPe3I0" +
       "J5Qsvh2y7RBs6zRfdIi5FobSOlvH6k1fvvu9n5XeD9wvcHmRtdFyL3Ziy4ac" +
       "8tti6KEr7FT1nK2tbo0UzCFKoaHFuaThfNzDebmbsSjHBuV9aFbcGx21mMuN" +
       "8kjmckl551e+98LR9/7k+zl9l6c+RxWEk/yLW53MivtWAP0dx90DLUUmgMOe" +
       "7v7COfvpHwKMM4BRAS4w6oXAUa0uU6c96JOn/+7P/vz213/pOminCZ2xPUlt" +
       "SrllQjcCk9AiE/i4lf+a127VIb0BFOdyUqEriM8bzh/o0guyxvvBs7unS7tX" +
       "t5msvD8vL2TFy/f185SfyLalHFPOM9dAeEwoO1v3mL0WAb8eukYuG1oOMLzl" +
       "XvyHH7n1G4v3ffsj29h+PFk4Bqw99viv/3j37Y/vHMmoHrwiqTk6ZptV5dS/" +
       "cEvcj8HvBHj+N3syorKGbVS9ldoL7fcdxHbfz8R//7WWlU/R/JePPfLHv/vI" +
       "o1sybr08oWiAfPkjf/M/X9x94pufv0rcug4ki/kKyWtoejcrLuZdWFa8ciur" +
       "yk+lLVvYO/O3668tnmaW5x5GgTv/u2fLb/7Wf11hMnnwuorEjo2fwR9+33nq" +
       "1d/Jxx9GkWz0PasrQz3YExyOLX3I+Y+dB0795Q50egadU/Y2HHnYBr55BpLs" +
       "aH8XAjYll/VfnjBvs8OLB1HyruMqc2Ta4/HrUFSgnkFn9TNXC1l3gueBPWt5" +
       "4Lj5nYDyyuQZLDCr/myOtBVDJ/OMJXtpHlptLvTpTxK6kKNYnQAmfbK0W9kt" +
       "Zu+Xrj7pdVn1NcD2o3wvBUbolivZ+6u4Y24rF/YNYgT2VkDqF+Z2Zd+Ln8vd" +
       "W8bf3e2G5NhaWz/1WoFC3nyIjPXA3uat//jOL77jwW8ArWnvsQMoy5EZu0m2" +
       "3fu1D7/77hc8/s235qEWcHH0lh+ef22GdX4tirNCyQp1n9TzGalCnsGyUhRz" +
       "eWjU1ANqqSP0MDEIsN5zoDa++Uc0FjG1/R+LzCQsVVY8naCTZZkOy3R1wMGb" +
       "pYxzLLNKKpvIIlOsxCkzF3F0doNvOr2loWpEVCEq2MzRW1wFQSWME2WSNpna" +
       "cDaNqHZar1pMalBzimUGaXNhkozRIMUaJTb4Ojb0FmRtGFJWw6SEReDGDl5p" +
       "9BWT7gkxVykhyAgdTRB1NEIqWH+5SGWZmSMcvmkVViW+JDfrLkMI6/F4VvMq" +
       "ElHXfWFtIwhBVSuoWSp0G560KIlOjx2iHYJ3WojgzLR0MZbEoBto5TRZmas5" +
       "y3BjZuUgjmh3kpZrCZvRJPLkUhB4S7bLe1Mz5S2kEQis4pT98qDtDjCsJppT" +
       "e0qNVtGMxZIlmepYp9iZSvhq3dPxNadXmaIxU8vyuiAtuEqLFeM2ZoC8v9+h" +
       "pSVLeAu9yw2IRCymqTYtDrVSeRyri3XakVvlTU0g5ihfLfRbZnWIm4ZtD5G0" +
       "mCBsD+Xi5aBtL5yBGFTRRauLa6iKU8mCXTQlXREUgpoogsalEp86qjxBglYd" +
       "qQzTJV5TOG+Ao21xLFFWmVmURyQjSIjUxXhuzY7rZEdKpF5lWpvFNi4U7VEw" +
       "DiZzWtPpulpAPbiJqeWhJdTtob7Shl5UM3qLtUh61Fqf+RLB+l3TEUS/GNEz" +
       "r7oSAklOVHGjylKEuzpDJd0qQqHTsdiS2j0RkQ2eILvlxFA4Lghmysig24Xu" +
       "eIA4RlfFUassGEV0Wq96pQ5LpUEakWqKs/2hGPgVc0a3pl6Zn6PEqFbrrLqa" +
       "ItNztT0kxKBZj5mYkdp8n1d0Upv7PYGMuRpVa1r6Jkj95hiPh45Uw+1Fu2Em" +
       "ZgsnycGGp1oDctabeXrbpMS0uFwPbHRT0CYwFtnJEtnowZDvkN2xNvUSujzG" +
       "Wn67CngEFG81rukCJ5Xs6aJSnqVufTFt1zR2xozb7SrGyaJdWAWJ3ojwtjMY" +
       "jCUWhCWx1/DxkVnGFxFLIjNl7OmsVJ92x8WJS24Gk6S0abS0xdIxSRP3BwvM" +
       "qXO0uF4RkqonywZJ2OVhXFvzfDQZUK4LLE218AYymhKzkdhSxriQbvjWNO2L" +
       "nLHyVKZRSd1RG22jFjoLORRrdNwJ39TmzKRct2TGqC3QYS0pBO58oqh4f63o" +
       "Ta1bW5iiTg26rjFu6AsexVcLrNBtudHYH7ijUbfAzG2PLpfQFtNrOWllYlTr" +
       "EvBX3biVDhhmZRTDZlmrGSjt1Guk3J/j7XjKTtFWoCl+OGbas5Xt9Metvkw3" +
       "WrADl0oOk3hVae0JtYkS1WtKva7LPL/osxyV2DRVjujNhlB6Pk6JokIzZaTH" +
       "AmZ7cHs97lpV0+zRfk9crf2+aDE8p6mzpDb3dbeukcyAtLhu3ClKy1JF3Exb" +
       "VRXjykpg6CyPtYpdnOqT4WqKDWTMpjvVBEWXxbmS6HW/UzZ7C2cdVAf1EccW" +
       "koiuDZKZws5KJcRfN3ktteeWsLKmZWFVn/IOMyKGgrnu2aWZuWguZxvFn/UN" +
       "f9lTev1WsNZEK4ncNoZzFR6ulI0R3zBQh2qv1zWFkSOPMGYU0ayyeCp3jEVc" +
       "6DvqplrVE6WQYpFgSOIcj7y1GAtmF1t3ItoW1pFnEyw9bMDLstm13QEpuk16" +
       "qpKcpVXJNcl0xSXpikOfXww3pj8GGy4M7waYOSXklS9OmEJdaquVfs2ec6sm" +
       "OiOrBXwzn47QjVFeVflS6A1QzFovzKExtbGCRMCb8kokFJbbxLg/7U2QRrp2" +
       "LZjFy2bUwvhE9qol4MJatV4ZwQqc3u/1iBKssfMa2+SiQFQtujKoN7hJzXT6" +
       "drgpYAVCm8qrIt4SNlZfqbP1uJb2xjhiW9aQUKZWESFqYtveJOzApjxjKjTq" +
       "JoEUjNpQHIeYITeW+qQ/d7lE7636MTrrdFrzAbZu+4iksNV+2J8siESnKzSK" +
       "Bg2HsaiOutg4RcXB4DQSYaa8LrcrCok2YaG6LMTTDUFWmBZJ2fJkuGxgDZSJ" +
       "ika3DdPrabAutplVdd6prlmDUkrr+cjDV5jmjoykShVHZaptsoJFWpVmO97I" +
       "/UKPGuOdSaU1GhplFe6QRIXhXDFdEkY8lug1JQfqYslN3W7V6jDuKulJZOL3" +
       "B3jRxtMp7HZcNWnPF22jYQ38hjxJWFJuIS2GEgcEOiC6vihW4VlhxKjWGDPY" +
       "mU9yq8QrgQBBOml75hH1MVWWJhWTSp1W0Jr5PU/w/GGlHNWQ0jphOxsS5pxm" +
       "oTIrVHv4HMFLKNFAyTrfBf6Lp6bluNOa+v16g56HdKeUVmSlOK40/OVmMgWK" +
       "6w2Ldh8zdVYfNsj5WkIGDqmv8bZvzLh+0GvGTImnG0gdj0tFy0ZZM5wF/CYC" +
       "5q6yrUkvBEGkPJZ1GoZbpU5SmZg10+PdDdmX53yvVGBrdXxFav1eMNTcas2t" +
       "RQW4qtDIFFOiVsWj3a5vC5KNccNiY415YBtcMmrLJoGOiR7aR5MB0iEVujFh" +
       "nCldJ+C1oG3GKdoR16mPjUcLvpxo/EgmhyQexQkb2PF4ytPkUuvJleUK1pcJ" +
       "4iTBHChEilKKNjYnMBqaqsXHeDkc1uVhoGA+brL6EvhYWhe6o968E6JKVQ+s" +
       "imx0Fw5FC5NufYQOhiW732TNGquxAU9slkwgEbQ5SotqWgSRSDdrapNQmdIm" +
       "SnuzDqfzuFyb2pIFw3RF0VRjPVUckhQ0rWmo7ZbbaRGVfljr4HAFn5RQVFzY" +
       "8iitc0KroOnw1AuGfbgvzSOz5ljeosPUwlW7wPXROQJPe0jFiGG2HM3V0Xq9" +
       "bAaNddU1lppVh5GSucSKBcun7HbPnLgbygv6VWskiJZb0nCyGZURQ6cNZxhp" +
       "XN9nR8qS4hifKGJySIlVrOwualSnIUxNrLocVrzyAKUjw+DZSrzocX1n2WeB" +
       "MEryIp3xZKHXnwrVgLLMLsKQQnG2jIO4HWFxlxkEmqC0TQVj2D7jJQHNb5pA" +
       "OUtYv85v2rMKi6XlIVmoYx4n48uF5JQESUQGc8HwDJXlsI67THQXdSpjGA6o" +
       "AqrPfaQLy4je8O25XJ3UiNl4ZKiERrl9uj+fwy0kXKFqz8N4jWbbwrjHo90N" +
       "jKHNCWuryRyz8RoW1qO+RTMISTQm2LKpcbRgVJveWHGWFAG0vtCcYbCJiFOk" +
       "2vL4RmfSHU/TUjM2ZLM4kNClHSKTVUVd2SlHryiFEtQm1lUmugZPlO6aJK0S" +
       "W4bNTULULaNrtDF3BM9lskJtpqjSZQLWFWuIX9ssdbdJxC46HvJWUauOGLOI" +
       "dU1Nk1bIZjKPCRHh56FEx7Q4aVUi1mlQenfYE8ZovR45WqvElajWWDRKNF4e" +
       "esU4KDiSt7L9OqLBw1Y9aW3EktKl7CGN0kuiFBoRZcctMphrznChJdOKZsgc" +
       "go3mScfezA1kXdyoeleVBtZkJdE8KdBlxEwLxFzB16LtgcyNGJQUHUEWJa3L" +
       "V8u17pAHKW8vxCRzIXarEjIyw04/Hs5lkFpMHGWxkafAqzgtiU7bi81qRS5S" +
       "XtR67JR3i3HTVZaBE3AzaUAUJxK2IWr+0q2RXcMyGl7dqpNJ5JhDPOWjwZpd" +
       "S/FyszHgQnEdTBsVZ8Ri6orsB0u2A7cTHkmWbFqcVpxkqC210XDYKg/Dymbq" +
       "tSpMU9T7E52toHzctcajkYdS03DQ7FaXg6k9k4oKxaijgtAZAgc/myTqQl0M" +
       "HTEJV+siXAFCX4m1eDZ0N5WyirWaqFnkOki1OutX6QjnBkxnWcHN9aqoUc0R" +
       "3O5XwD5LLBQYtznzWEOAVwlujkgSdnvDoYfpqMhXYW2BENVA5hbjuQZrlt2c" +
       "YqpiswnCrGJZCLpNdYxVpyO6SlRn3BSXY3fW5vWImRTIOo7VG90VZ3L9apEs" +
       "CehIKwvAJios4+poOa2Oh1jQSt2GErbDHmq3McsaT2uB6iYWTA/apqRhaM/X" +
       "q1qRkBDVhuFUBl6JXC9wZwpSY2XZKZSRMq6r5ZVrmT4tMN1hs7Xx5nMJWBCN" +
       "VoOhIMTtkj2qRDWTJalFgAzaNII7zIQJZSGeN7mxWgl4fTkWXZ8VC4hNEL24" +
       "NG81WZAjpkPCKLFGtbsMCNlsqlKWYZuOxdFhVUWidmvU48fVGmF32htJ9idO" +
       "MEjLcg3ry4Gv4jRmjuUlXKXrA2XsNDkN7HZflW2Dl89ue35LfhJxcE8KduVZ" +
       "h/4sduDbrvuz4tUHhzb57xR07G7t+BHnnfsHriF09zNdf+YngE+9+fEn1d4H" +
       "kJ29A7t2DN0Ye/7P2UDH7SOoTgFMDz/z+RuX3/4eHoJ99s3/dl58tfn6Z3F7" +
       "dO+xdR5H+UHuw59vvUz5zR3ouoMjsSvupS8fdPHyg7AzoRYnoStedhx29wFn" +
       "X5Jx7GXgKe9xtvxsTqNzLdjK/th56Mkc4OT+CdQrfsr7vtH+cdrbrnaac1K3" +
       "PSm/L3lbfuSWz/wb1ziJfVdWPBpDL8jv+AHbpPgI9lwXH3s2h7N5w1sOmHc2" +
       "a7wDPOM95o2fH+YdJeH91+j77ax4IoZuMLT4gHPNQ9re+xxoe1HWeB48l/Zo" +
       "u/T80/bBa/T9XlY8FUOnFcnt73+ccUwfTsueZ2uSe0jxB54DxbmjyezB2KPY" +
       "eH4oPnEI8LYc4FPXIPuPsuIPYuiMam3NWcw/N3jHIYmfeA4k5tae3V16eyR6" +
       "z79Q/+IafZ/Jij+NoZuAws600Dtm7jl9Tz8H+m7NGu8Cz3KPvuXzT99fX6Pv" +
       "y1nxBSA9QB8FAg4IGVmLfkjdF5/VXVAM3X71byGyW907r/gQa/vxkPLRJ8/e" +
       "cMeTw7/NPwc4+MDnRha6QU9s++glyZH6KT/UdCun4sbtlYmf/30thu66lvOO" +
       "oVPbSr76r24H/X0M3XbVQTF0ffZ3FPYbMXTuOCxw9fn/UbhvAbYewoFpt5Wj" +
       "IP8UQ9cBkKz6z/7W3k5cnhkcyOHWnySHI8nEg5elAPlXcvvhOtl+J3dJ+diT" +
       "7e4bvl/+wPZTBsWWNpsMyw0sdHr7VcVByL//GbHt4zpFP/TDmz9+40v305Ob" +
       "tws+VN0ja7v36h8NNBw/zq/5N5+64xOv/J0nv57fu/wfuaXYub4oAAA=");
}
