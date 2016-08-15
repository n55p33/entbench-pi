package org.apache.batik.css.parser;
public class DefaultClassCondition extends org.apache.batik.css.parser.DefaultAttributeCondition {
    public DefaultClassCondition(java.lang.String namespaceURI, java.lang.String value) {
        super(
          "class",
          namespaceURI,
          true,
          value);
    }
    public short getConditionType() { return SAC_CLASS_CONDITION;
    }
    public java.lang.String toString() { return "." + getValue();
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1YfWwcRxWfO39/xfYlTtJ8OLbjBMUJdzU0lYLT0tixmwtn" +
                                                              "x9hpBA7JZW5v7m7jvd3N7qx9dmtIiyBuJaIouG1AxH+5akFtUyEqQNAqqBJt" +
                                                              "1YLUElEKaooEEuEjohFS+SNAeTOzX7d3dghCnHRzezNv3pv39Xtv9tnrqMo0" +
                                                              "UDtRaZTO6MSMDqp0FBsmSQ8o2DQPw1xSerIC/+34tZE9YVQ9gVblsDksYZMM" +
                                                              "yURJmxNos6yaFKsSMUcISbMdowYxiTGFqaypE6hNNuN5XZElmQ5racIIjmAj" +
                                                              "gVoxpYacsiiJ2wwo2pyAk8T4SWL7gst9CdQoafqMR77eRz7gW2GUeU+WSVFL" +
                                                              "4iSewjGLykosIZu0r2CgnbqmzGQVjUZJgUZPKrttExxM7C4xQdcLzR/ePJdr" +
                                                              "4SZYjVVVo1w9c4yYmjJF0gnU7M0OKiRvnkJfRBUJ1OAjpqg74QiNgdAYCHW0" +
                                                              "9ajg9E1EtfIDGleHOpyqdYkdiKLOYiY6NnDeZjPKzwwcaqmtO98M2na42got" +
                                                              "S1R8fGds4cnjLd+tQM0TqFlWx9lxJDgEBSETYFCSTxHD3JdOk/QEalXB2ePE" +
                                                              "kLEiz9qejphyVsXUAvc7ZmGTlk4MLtOzFfgRdDMsiWqGq16GB5T9ryqj4Czo" +
                                                              "utbTVWg4xOZBwXoZDmZkMMSdvaVyUlbTFG0J7nB17P4MEMDWmjyhOc0VVali" +
                                                              "mEARESIKVrOxcQg9NQukVRoEoEHRhmWZMlvrWJrEWZJkERmgGxVLQFXHDcG2" +
                                                              "UNQWJOOcwEsbAl7y+ef6yN6zD6oH1DAKwZnTRFLY+RtgU3tg0xjJEINAHoiN" +
                                                              "jT2JJ/Dal+bDCAFxW4BY0Hz/oRv37Wq//Jqg2ViG5lDqJJFoUlpKrXpr08CO" +
                                                              "PRXsGLW6ZsrM+UWa8ywbtVf6CjogzFqXI1uMOouXx376+dPfIX8Oo/o4qpY0" +
                                                              "xcpDHLVKWl6XFWLcT1RiYErScVRH1PQAX4+jGnhOyCoRs4cyGZPQOKpU+FS1" +
                                                              "xv+DiTLAgpmoHp5lNaM5zzqmOf5c0BFCNfBFjfDdhMSH/1KUjuW0PIlhCauy" +
                                                              "qsVGDY3pb8YAcVJg21wsBVE/GTM1y4AQjGlGNoYhDnLEXpBMk2UmAGFsP8lg" +
                                                              "S6Hcl5BPaa56lEWb/n+SU2D6rp4OhcAVm4JAoEAOHdCUNDGS0oLVP3jj+eQb" +
                                                              "IshYYtiWoqgXREeF6CgXHQXRUSE6WlY0CoW4xDXsCMLx4LZJAABA4MYd48cO" +
                                                              "npjvqoCI06crweaMtKuoEg14KOFAe1K6FGma7bza+0oYVSZQBEvUwgorLPuM" +
                                                              "LECWNGlndWMKapRXKjp8pYLVOEOTSBqQarmSYXOp1aaIweYpWuPj4BQylrKx" +
                                                              "5ctI2fOjyxemHz7ypTvDKFxcHZjIKgA2tn2UYbqL3d1BVCjHt/nMtQ8vPTGn" +
                                                              "efhQVG6cKlmyk+nQFYyJoHmSUk8HfjH50lw3N3sd4DfFkG8Aje1BGUXw0+dA" +
                                                              "OdOlFhTOaEYeK2zJsXE9zRnatDfDg7WVP6+BsGhg+dgB3047QfkvW12rs3Gd" +
                                                              "CG4WZwEteKm4Z1y/+Kuf//GT3NxOVWn2tQPjhPb5kIwxi3DMavXC9rBBCNC9" +
                                                              "d2H0649fP3OUxyxQbC0nsJuNA4Bg4EIw81deO/Xu+1eXroS9OKdQyq0UdEQF" +
                                                              "V0k2j+pXUBKkbffOA0ioAEqwqOl+QIX4lDMyTimEJdY/mrf1vviXsy0iDhSY" +
                                                              "ccJo160ZePN39KPTbxz/eztnE5JYJfZs5pEJeF/tcd5nGHiGnaPw8Nubv/Eq" +
                                                              "vgiFAsDZlGcJx9swt0GYa74eGjO+kxXdqCi6bP5u7tLdnOZOPt7FzMF3Ir62" +
                                                              "hw3bTH9qFGefr59KSueufNB05IOXb3BdihsyfyQMY71PBB8btheA/bogdB3A" +
                                                              "Zg7o7ro88oUW5fJN4DgBHCWAZvOQARBaKIobm7qq5tc/eWXtibcqUHgI1Ssa" +
                                                              "Tg9hnoKoDmKfmDlA34L+6fuE66drYWjhqqIS5UsmmPm3lHfsYF6n3BWzP1j3" +
                                                              "vb1PL17lMagLHhv9DD/Ghp1uNPJPdbAm+qOxiIOBNi/XtvCWa+mRhcX0oad6" +
                                                              "RXMRKW4FBqHTfe6X/3wzeuG3r5epOnVU0z+ukCmi+GSGmciiSjHMOzoPrd5b" +
                                                              "df53P+zO9t9OkWBz7bcoA+z/FlCiZ3nQDx7l1Uf+tOHwvbkTt4H3WwLmDLL8" +
                                                              "9vCzr9+/XTof5u2rgPqStrd4U5/fsCDUINCnq0xNNtPEw36rGwCtDgT12AHQ" +
                                                              "Ux5zy8SOi2TLbV0hq4+ssPY5NnwWACNLqNth8KJR1DUwJ49bKRMqvJwHmim7" +
                                                              "Cf7E6Alpvnv09yIG7yizQdC1PRP72pF3Tr7JvVXLwsO1kS80IIx8tapFKP8R" +
                                                              "fELw/Rf7snOzCdFMRgbsjrbDbWlZHhpoxwp30GIFYnOR9ye/de05oUCw5Q8Q" +
                                                              "k/mFxz6Knl0QCSXuRVtLrib+PeJuJNRhwzF2us6VpPAdQ3+4NPejZ+bOhG0v" +
                                                              "xSmqAjgzqOvDkNvbrSk2ujjp/kebf3wuUjEEiRpHtZYqn7JIPF0crDWmlfJ5" +
                                                              "wbtIeaFrn5lZnKJQjwNyn2LDmHi+57/EVzYxoPP5YTfKI2xtA3x77Sjvvf0E" +
                                                              "WW7rCklgrrBmsQEuYrVU81VSzwza/8IMBbi7lu31WRlaX/KKQVyLpecXm2vX" +
                                                              "LT7wDkdj9+raCAmWsRTF52m/16t1g2RkrlqjqMo6/5mjaOMKVxHWXPEHrsJD" +
                                                              "Ys9paN/L7aGoAkY/5ZcBYYKUENP810/3VYrqPToQKh78JI8CdyBhj4/pTr+z" +
                                                              "+z+4RblvvlzrFkKlNZs7te1WTvUV6a1FWMPfGjnpaIn3RnC5Wjw48uCNu58S" +
                                                              "3bKk4NlZxqUBklA07m6N6lyWm8Or+sCOm6teqNvmYEOrOLCXGBt90TsAGKGz" +
                                                              "INoQaCXNbrejfHdp78s/m69+G1DtKAphilYf9b2zES8ooB+1oDk4migFG6jn" +
                                                              "vMft2/HNmXt3Zf76G94O2eC0aXn6pHTl6WO/OL9+CXrhhjiqAtgjhQlUL5v7" +
                                                              "Z9QxIk0ZE6hJNgcLcETgImOlCMlWsXjHLCG5XWxzNrmz7K5FUVcpOpfeUKF1" +
                                                              "nCZGv2apaRsLG7yZotdZTpm3dD2wwZvxVbCsgE9RrCqSiWFdd4pXTb/Ocz8X" +
                                                              "RHQ+yXdf5I9sWPw33m+3e1EWAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1Ze+zsWF3v/d29T5a9dy/ssi773rvo7uCv03l1JgtIp9N2" +
       "ptNpO89Oq3Dpe9rpu52ZzuDislHZQLKiXmBNYP+CqGR5xEg0MZg1RoFATDDE" +
       "VyIQYyKKRPYP0YiKp53f+z4QYpxf5sz5nfP9fs/5Ps7nfM85L38HOhNHUCHw" +
       "nbXp+Mmunia7tlPdTdaBHu/STJWXo1jXcEeO4xFou6Y+9tlL3/v+B2eXd6Cz" +
       "EvQ62fP8RE4s34sHeuw7S11joEuHrYSju3ECXWZseSnDi8RyYMaKk6cZ6DVH" +
       "WBPoKrM/BRhMAQZTgPMpwNghFWB6re4tXDzjkL0kDqH3QKcY6GygZtNLoEeP" +
       "CwnkSHb3xPC5BkDC+ez/CVAqZ04j6JED3bc636Dwhwrw9Y+88/LvnIYuSdAl" +
       "yxtm01HBJBIwiATd6equokcxpmm6JkF3e7quDfXIkh1rk89bgq7ElunJySLS" +
       "D4yUNS4CPcrHPLTcnWqmW7RQEz86UM+wdEfb/++M4cgm0PXeQ123GpJZO1Dw" +
       "ogUmFhmyqu+z3DG3PC2BHj7JcaDj1S4gAKznXD2Z+QdD3eHJoAG6svWdI3sm" +
       "PEwiyzMB6Rl/AUZJoPtvKTSzdSCrc9nUryXQfSfp+G0XoLqQGyJjSaB7TpLl" +
       "koCX7j/hpSP++Q77lhfe7bW9nXzOmq462fzPA6aHTjANdEOPdE/Vt4x3PsV8" +
       "WL7388/vQBAgvucE8Zbm937+1be/+aFXvrileeNNaDjF1tXkmvpx5a6vPoA/" +
       "2TidTeN84MdW5vxjmufhz+/1PJ0GYOXdeyAx69zd73xl8Kfis5/Uv70DXexA" +
       "Z1XfWbggju5WfTewHD2idE+P5ETXOtAF3dPwvL8DnQN1xvL0bStnGLGedKA7" +
       "nLzprJ//D0xkABGZic6BuuUZ/n49kJNZXk8DCILOgS90J/g+AG0/+W8CafDM" +
       "d3VYVmXP8nyYj/xM/xjWvUQBtp3BCoj6ORz7iwiEIOxHJiyDOJjpex1qHGcr" +
       "M9YjuKUb8sJJcl+C9aTlqu9m0Rb8P42TZvpeXp06BVzxwEkgcMAaavuOpkfX" +
       "1OuLJvHqp699eedgYexZKoEQMPTudujdfOhdMPTudujdmw4NnTqVj/j6bApb" +
       "xwO3zQEAAGi888nhO+h3Pf/YaRBxweoOYPOMFL41QuOHkNHJgVEFcQu98uLq" +
       "vZNfKO5AO8ehNps2aLqYsfMZQB4A4dWTS+xmci+971vf+8yHn/EPF9sx7N7D" +
       "gBs5szX82EkDR76qawAVD8U/9Yj8uWuff+bqDnQHAAYAhokMghfgzEMnxzi2" +
       "lp/ex8VMlzNAYcOPXNnJuvbB7GIyi/zVYUvu+bvy+t3Axq/JgvsR8H10L9rz" +
       "36z3dUFWvn4bKZnTTmiR4+5bh8HH/urP/rGcm3sfoi8d2fSGevL0EVjIhF3K" +
       "AeDuwxgYRboO6P72Rf7XP/Sd9/1sHgCA4vGbDXg1K3EAB8CFwMy/9MXwr7/x" +
       "9Y9/becwaBKwLy4Ux1LTAyWzdujibZQEo73pcD4AVhyw5LKouTr2XF+zDEtW" +
       "HD2L0v+89ATyuX9+4fI2DhzQsh9Gb/7hAg7bf6IJPfvld/7bQ7mYU2q2rR3a" +
       "7JBsi5WvO5SMRZG8zuaRvvfPH/yNL8gfA6gLkC62NnoOXju5DXZyze8B6UfO" +
       "me1gu9sdLGsv5i6Fc5qn8nI3M0fOCeV95ax4OD66NI6vviPJyTX1g1/77msn" +
       "3/3DV3Ndjmc3RyOhJwdPb4MvKx5Jgfg3nMSBthzPAF3lFfbnLjuvfB9IlIBE" +
       "FeBczEUAj9JjcbNHfebc3/zRH9/7rq+ehnZI6KLjyxop50sQugBiX49nAMrS" +
       "4GfevnX96jwoLueqQjcovw2Z+/L/ToMJPnlr9CGz5ORwAd/3H5yjPPd3/36D" +
       "EXLcucmefIJfgl/+6P34276d8x8CQMb9UHojRoNE7pC39En3X3ceO/snO9A5" +
       "Cbqs7mWJE9lZZMtKAplRvJ86gkzyWP/xLGe7pT99AHAPnASfI8OehJ7DvQHU" +
       "M+qsfvEo2vwAfE6B739n38zcWcN2b72C723wjxzs8EGQngJr+UxpF90tZvxY" +
       "LuXRvLyaFT+5dVNW/Smw6OM8PQUchuXJTj5wMwEh5qhX96VPQLoKfHLVdtB8" +
       "IWyhLSsrOfnW/egtQ+UtW6p8D7vrcGkxPkgNP/D3H/zKrzz+DeA/GjqzzGwL" +
       "3HZk/bGLLFv+5Zc/9OBrrn/zAzleAbCaPPvEv+S5B3M77bKCyor2vlr3Z2oN" +
       "8xSAkeOkl0OMrmWa3T5s+chyARIv91JB+Jkr35h/9Fuf2qZ5J2P0BLH+/PX3" +
       "/2D3hes7R5Lrx2/Ib4/ybBPsfNKv3bNwBD16u1FyDvIfPvPMH/zWM+/bzurK" +
       "8VSRACehT/3Ff31l98VvfukmWckdjr+FuR/Lscmdz7crcQfb/zCIaAgrdZAK" +
       "BlduwKkhOqOErnOMYjd7Y1rbjIuOyIyKiZW6q8RLG7OgiaG0JFSXqIvaS63M" +
       "omHa0NykY62bC1ru+AsKwdJ2oSrPyWS8JsI+i4Vhk04QkRkTDtGVfZ8gFoTt" +
       "z8hhYchi+ojbTFGtrJkz3GsPNvqGXZaDZbkxTZaNxIvCnl8ct5KBLI24Wm/Y" +
       "a4VBkWzG7rBf90utPr9CUnAs6+BwoVxJJKIhTvoNc6I4cWsei1Kvtx4PaDdl" +
       "/bi2lsluPOyN1c5Q6Wn+SkytEUWG8jogajOWXbDVqUQ4br8ayWqnY7uYbU78" +
       "NBBlNbYsurRa+aVgjc3ro8pQYFCQCTRwre/LRtgboKg+2KCmUKLG+rggDCck" +
       "U7GG+sqmmPXcjzvSohiVcNNTQndD9Sf2WKLNscR3oyQh0rSH4pW0r6nMZgDr" +
       "PK1FlaEk2pPJxEdWDbWyFl2bJoumN0Z7Ra5rDZbenDYGzTGNcJgdhCZa6Vus" +
       "qWEi3haKDdk2GwRCJEanRTl6mwvWoSbONavLcKIl1livpUs2392sVqocugnX" +
       "qPdKnlwpmX4yRAZ1g9LiiurZjFZI+r3iKCQdIW04Kd0yieaQGIkkPhyl7VaZ" +
       "1rg53CdkZ9os6TwxZwhr0wh1O5itJ/F0jC1VVHKpkTOv9JiE25CGOdBavdgS" +
       "QipEalSzOmpE69Cu4Btw5lRGE8GspJzUXE19qeVK815vqC3lyXrsKCOSKtKo" +
       "10RQvtIjei3BtdczTi1OAMZbLoENiGGnO4m4VO2bDba/mE8GPuET7cHMFaSe" +
       "s4wEOiIEiZ4TA9ek0gnTJ6ftlkqVxmxfoDlOXRGxgjnouqAbtTVb27Rqfhtp" +
       "Yd2V5I0GJCMWBok5LidmMbVposNibd9i7VGJpuGW7BSUFo6RqVBpisX2BvYH" +
       "yzIqhDBMh2ZpYlFVpxXSNOmPnaAbTYOoWMc5fjCNKUaoSXHUK4wFub5eKcnE" +
       "qOG2b27IcNpBFj3OX0zTMloraLzRmdY5H/YrYSAWUzVotZlJV3BqU1Jg1BEy" +
       "sEQiGqqTQRvh+9i0UrApb8atcX8AHLmmJL7PdYNxgRwi6bLQskYMZgau3w6q" +
       "Div3qptN6HJGVS02SZw1mqRttLRZb9iGke7YXghFvuPMcHmxDuMJ1RLLgVIX" +
       "MXVCmyVkFTcnBEyNesi6gvVtyqFYX5y1PIaYBs3evDR2MYqM+bpjDmtt1ak2" +
       "eVmu1hxCUGCvMByXWrUoqHAzFZu4FRrzCYxra/iYbVHDos9M+LJtF/S+0oln" +
       "ophYgh+a0wGhkzXcnLb708F4SNQERyzivlBJW9MY7zFphZFoDGtilZ6oVeoq" +
       "5wX2MvTxTrGmRitd7iXdhU+YSKXLkZiOdGsk5cqospELRV+cDKV+k1iOV6Yf" +
       "MfyixxC4wFKOpwm9rhwMpl07qAciM+EIbjRshn05cofilAsQWe6sdDEQFrxd" +
       "afbXTtRNq2rSKRmcvU51t71B18Fo2eqSqdqW7E7XxEqJVxqLSsiUNaQ5we12" +
       "Anu9pF9f8iPK041Zf0LV1K7jrucFr0+Ka9pvu8PxvN427Ha16KzKbDnWKi2D" +
       "nFN1zNaRJjWerooFDeM0ziFnI04mRL1b2tDxlGhsBp6ctIyWiQoTvlZoxtTM" +
       "LGhms1ysoH1jvhSQUhSXKQ2nKoK0IhK961YkZA0XugsDBt4tsyk3EbxS0uft" +
       "Ga9U551VapVbPXk5xRtRs4mzeEMrtYu1SsPgy9w4Xad9BS96Mb1gsUrTrBCd" +
       "VR3RdA6eLgqIPo38YYPrav11WBxrRJ+cFOcluxBMx83uXDEMDitaPkaEq5Bz" +
       "Cv3OtOK0eusRWOW0JsJuZCDLpTWN10WrNRuKqkr7SK0o6TxbbnT5kZJuYH2T" +
       "eESVFmlDiqsBQesknKha1aPaFuXJ/KrOLpQlTIRL0yKxuCU5lEqnjXiVFClR" +
       "Ris6ZXOFeTrVQtyqKXx1gSaM5nESxycouemR5U5UK81WZWXUboQkpRtRtdEd" +
       "LvSFwTaL1Q43VcpNzZrFa2Pd74kowjebdSWZ6Ris+KbWLGOSifpo5Nfr/lio" +
       "GjRbaZnNNi5g0pLrY4Om3O34iouGYTVRYV2YJpaihuO22UGGsTwyGzPP7/ot" +
       "t2u4LQcrV5hCzVgQtZoWiYI9C8POsDqOXZd3y07biEWy5pWbwoZH7PJSQXgG" +
       "QZ2ebDLt2bLRasHULEAWLE/zmoK5hZBLrQ7XZC0Y7Ly4IBfcwUydFsF5ozaY" +
       "9gZdoUI2w/bI0GtTuLza6AuqHFX1gPMm4+KmsJjjrlWghpSrWtbQbve4jc9H" +
       "WlXRjGqZL2y4RtLg5kJzgyqqjxU2MOngllT2+q0UdZCxUUi49mqpzEdJpV0W" +
       "VozbYph6Y4lvokYBno58o7ooRSYfgnOeVhlXYSPGW+MOi3thMWXZhCdW5VpE" +
       "rfCkZY6QEtbuj9PqZl0fclZpxCiT4iysFOKYF6ustxIwnGVCNpnVu/QAaY1X" +
       "dKWhdAe9cEmv2q7loriBEjXMCZbesthYdyh0bW36Go7wAx4tBWR5FKH0cjJl" +
       "VjGHzIf1YqeT1hM5ILt8fWAQzAoeGGjscRtcI3sDU4ntSGkpgiO1Z4GfroJy" +
       "keqQoscNGmsd1vRi1R/jq2q/3p/DLplual3PKfbx4XQxmCRMZCkFXqcXNDuY" +
       "rTZkaRHXJgGPaf1yocLyui0VFG5GFZfp0A1BxrIJuWVrzi6VaDgvLWw7gOe6" +
       "YpRXi7FNENYgaCeSGHoo3eHJohqBrdQx6CrYfTq6TEZe1ZG8Lt23V+zaKzEt" +
       "t20VqihMTDZi6vN8VRwZ3U4pTbByiqJDe7k0ioQgoBE+d8woarpxn1iI0WRc" +
       "RybDzWojw/VOr6lYqLMoI8LAkadwt9ufrJlAV6duaTllRuiqNdfsRiGSccwV" +
       "4sGIrJZcGKkliFkazCMntEH+V4Orri1zve4kbQtTnmhHMd0S40YgszCDypSP" +
       "zUW4KqlNUeyOCZavI0W4PBGjkB/5/e4MrdOdOq6tmzO7AgejqLABf5WB4iyX" +
       "ziYi512HlWI00RFhtBxPajJCCj3eoGwvkDteeeDhVcFeVeoLnF1U68Oy0p1X" +
       "WEdKw3Fz7mBF1K2xNWctuHUuKsQ459YSPWSXrkhwEcfgU6qZNIqjGKO61KbD" +
       "+n0Zn7JKpNtGWwvQegy7tUaBQlpJFwtmliMaDaW0IYZ1328WEL81r7iWSVI1" +
       "21v2jKQEt1l3mpQlA61RjQpX0vGiPPVqQXvk1AQO5phGAZ9Gs5lthVhi2rO+" +
       "M2ZAqi41+mlnXpRAnkuzpsqoxMjsuJyD9xwhntptBqeqUyHdsJG7QbtVcjxR" +
       "Ay4w9HGXRDxcopYlOZAHMQMWguQnmjQK3LLWAhmxtEwnCh6bRGMQ4eHQEkhN" +
       "qwTTkQJz6qY+HbT7hfUUIECnEQv8qlx2C2UdIQRw8nhrdiR5x492Krw7P+we" +
       "vG78GMfcbdejWfHEwfVZ/jl78kb86PXZ4a0JlJ3wHrzVo0V+uvv4c9df0rhP" +
       "IDt7t03TBLqQ+MFPO/pSd46I2gGSnrr1SbaXv9kc3oJ84bl/un/0ttm7foSb" +
       "34dPzPOkyN/uvfwl6k3qr+1Apw/uRG54TTrO9PTxm5CLkZ4sIm907D7kwQPL" +
       "3r1/GfnUnmWfuvnt602j4FQeBVvf3+YyL75N3yIrvAS6bOrJwS39wV3x8Ei0" +
       "CAl0Jp75UXIYR/4PO1UfHS1vmB8ofiVrvB98kT3Fkf97xZ+7Td8vZsUzCXQ+" +
       "8Y9cjB7q9p4fRbc0ge656XtHdnl73w3PrNunQfXTL106/4aXxn+ZX/kfPN9d" +
       "YKDzxsJxjt6mHamfDSLdsHIVLmzv1oL85wMJ9MbbPMdkd+J5JZ/7+7c8LyTQ" +
       "62/Gk0CnQXmU8ldBhJykBPGQ/x6lu55AFw/pwKDbylGSjwDpgCSrvhjsX1NX" +
       "/xcvSVgC/KQsEv3Auump47hz4LwrP8x5R6Dq8WMAk7+c74PBYvt2fk39zEs0" +
       "++5Xa5/YPnKojgyOhEDKeQY6t31vOQCUR28pbV/W2faT37/rsxee2Ae/u7YT" +
       "Poz2I3N7+OYvCoQbJPkbwOb33/C7b/nNl76eXyb+D2pi+BfSIAAA");
}
