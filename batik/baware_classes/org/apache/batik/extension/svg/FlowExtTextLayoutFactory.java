package org.apache.batik.extension.svg;
public class FlowExtTextLayoutFactory implements org.apache.batik.gvt.text.TextLayoutFactory {
    public org.apache.batik.gvt.text.TextSpanLayout createTextLayout(java.text.AttributedCharacterIterator aci,
                                                                     int[] charMap,
                                                                     java.awt.geom.Point2D offset,
                                                                     java.awt.font.FontRenderContext frc) {
        return new org.apache.batik.extension.svg.FlowExtGlyphLayout(
          aci,
          charMap,
          offset,
          frc);
    }
    public FlowExtTextLayoutFactory() { super(
                                          );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1YC2wUxxmeOz/xAz/A4DhgwDaoBnIbaCiNTGngsIPpGU4Y" +
       "kGISjr29ubvFe7vL7px9dkqTIEW4kYIoBUKrxJVaKJQSiKJGbdUmcRWVJEoa" +
       "KYQ2TaNAX2ppKSqoalqVtuk/M7u3jzsfiqr2pJvbm51/5n988/3/zNnrqMI0" +
       "UDtWSYiM6dgM9aokKhomToQV0TS3QV9MeqpM/Muuq5vvDaLKITQzLZoDkmji" +
       "PhkrCXMIzZdVk4iqhM3NGCeoRNTAJjZGRCJr6hBqkc3+jK7IkkwGtASmA3aI" +
       "RgQ1iYQYcjxLcL81AUHzI6CJwDQR1vlf90RQnaTpY87wVtfwsOsNHZlx1jIJ" +
       "aozsEUdEIUtkRYjIJunJGWiZriljKUUjIZwjoT3KKssFmyKrClzQ8VzDh7cO" +
       "pRuZC2aJqqoRZp65FZuaMoITEdTg9PYqOGPuRV9AZRFU6xpMUFfEXlSARQVY" +
       "1LbWGQXa12M1mwlrzBxiz1SpS1QhghZ5J9FFQ8xY00SZzjBDNbFsZ8Jg7cK8" +
       "tdzKAhOPLhOOPLWr8fky1DCEGmR1kKojgRIEFhkCh+JMHBvmukQCJ4ZQkwrB" +
       "HsSGLCryuBXpZlNOqSLJQvhtt9DOrI4NtqbjK4gj2GZkJaIZefOSDFDWv4qk" +
       "IqbA1jmOrdzCPtoPBtbIoJiRFAF3lkj5sKwmCFrgl8jb2PU5GACiVRlM0lp+" +
       "qXJVhA7UzCGiiGpKGAToqSkYWqEBAA2C2qadlPpaF6VhMYVjFJG+cVH+CkbN" +
       "YI6gIgS1+IexmSBKbb4oueJzffOagw+rG9UgCoDOCSwpVP9aEGr3CW3FSWxg" +
       "2AdcsG5p5Jg458WJIEIwuMU3mI/57udv3re8feo1PubOImO2xPdgicSkE/GZ" +
       "b88Ld99bRtWo1jVTpsH3WM52WdR605PTgWHm5GekL0P2y6mtFx549Ay+FkQ1" +
       "/ahS0pRsBnDUJGkZXVawcT9WsSESnOhHM7CaCLP3/agKniOyinnvlmTSxKQf" +
       "lSusq1Jj/8FFSZiCuqgGnmU1qdnPukjS7DmnI4Sq4IvWw7cT8Q/7JWiPkNYy" +
       "WBAlUZVVTYgaGrXfFIBx4uDbtBAH1A8LppY1AIKCZqQEEXCQxtYL2DRYNcFG" +
       "wRxJAWq10d4c2Qa9EXEMQNUnUuyPhSjm9P/rajlq+6zRQADCMs9PCgrsp42a" +
       "ksBGTDqSXd9781zsDQ44ukksrxG0GhQIcQVCTIFQXoEQKBCaTgEUCLB1Z1NF" +
       "OBQgkMNACcDJdd2DD23aPdFRBhjUR8shCnRohyc3hR3esMk+Jp1vrh9fdHnF" +
       "K0FUHkHNsFJWVGiqWWekgMSkYWuf18UhaznJY6EredCsZ2gSTgB3TZdErFmq" +
       "tRFs0H6CZrtmsFMb3cTC9ImlqP5o6vjoYzseuTuIgt58QZesAKqj4lHK8nk2" +
       "7/LzRLF5Gw5c/fD8sX2awxieBGTnzQJJakOHHxl+98SkpQvFF2Iv7utibp8B" +
       "jE5E2IFAlu3+NTyE1GOTO7WlGgxOakZGVOgr28c1JG1oo04Pg2wTbVo4eimE" +
       "fAqyvPCZQf2Zn7/1h08yT9oppMGV+wcx6XHRFp2smRFUk4PIbQbGMO6D49Ev" +
       "H71+YCeDI4zoLLZgF23DQFcQHfDg46/tfe/K5ROXgg6ECeTtbBzKnxyzZfZH" +
       "8AnA99/0S6mGdnDKaQ5bvLcwT3w6XXmJoxtQoALEQMHRtV0FGMpJWYwrmO6f" +
       "fzYsXvHCnw428nAr0GOjZfntJ3D671iPHn1j19/a2TQBiaZgx3/OMM7rs5yZ" +
       "1xmGOEb1yD12cf5XXhWfgQwBrGzK45gRLWL+QCyAq5gv7mbtPb53q2mz2HRj" +
       "3LuNXKVSTDp06Ub9jhsv3WTaemstd9wHRL2Ho4hHARYLI6vxED99O0en7dwc" +
       "6DDXT1QbRTMNk90ztfnBRmXqFiw7BMtKQMrmFgNoM+eBkjW6ouoXP3plzu63" +
       "y1CwD9UompjgfAgJDJCOzTQwbk7/7H1cj9FqaBqZP1AJP91X0EsDsqB4qHsz" +
       "OmHBGf/e3O+sOTV5mSFU55i805Jnf5awtps2yzmC6eNdubzf2KeyhN9ccwbY" +
       "cytBywoSRmoENhINbEGSoH6fP10dxGq4E/uPTCa2nFzBq5Vmb23RC6Xzsz/7" +
       "15uh4798vUjqmkE0/S4Fj2DFoycs6Uk0A6xEdMjug5mHf/P9rtT6j5NjaF/7" +
       "bbII/b8AjFg6fc7wq/Lq/j+2bVub3v0x0sUCnzv9U35r4Ozr9y+RDgdZPcwz" +
       "RUEd7RXqcTsWFjUwFP4qNZP21DOIduZB00YxshS+ggUawb/ZOK8zBNKmLy/K" +
       "sFlTQtS3R8pZRMtt5C1mG4IhLX+iTITT4B4JKvt+ghlxew/BNLCD2bhJGKfx" +
       "CvnB2gsvm9/43fMccx1FBvvK7tOnqqX3Mxd+ywXuKCLAx7WcFp7c8e6eN1k4" +
       "qyl+8k50YQdw5sqFjXnvzKTOaIKvRR78l6Cd/31BKYijREhhLQOHGJKGWidF" +
       "0na9+r+cnu7/xdNvB1dMJr/Z+dYjk52/YixcLZuwwcBPRY5RLpkbZ69cu1g/" +
       "/xzbyOXU3ZarvefPwuOl59TIotBAm905szgcooacgSJjxILDyuhuaaIryuBA" +
       "5XbRJkSFu0vcQ3jnEPY1Xxl++uqzHFL+Y59vMJ448sRHoYNHOAfys3FnwfHU" +
       "LcPPxxxgee0WlVqFSfT9/vy+H5zed8C2LEJQmWxdW9ANGchT7Gyvm7ieG77Y" +
       "8MNDzWV9EJB+VJ1V5b1Z3J/wskuVmY27doVzlHa4xtKYVlMEBZbauc2rwDwP" +
       "x7MbLIcEz7yz+qenvnRslHu3RFR8cq3/2KLE9//67wUlCOPjIoHyyQ8JZ59u" +
       "C6+9xuSdOppKd+UKz2gAckd25ZnMX4MdlT8Ooqoh1ChZN0Y7RCVLS9ghgLFp" +
       "XyNFUL3nvffGgx/ve/LsP8+PFNey/greHaly4olKE98iAcSoerx4hRFkFQaB" +
       "SWVVVJhcCMpmhVEC/ceyK3ZFNMjlbI7nVSi1AwoFTcW0oLXf8aOmrIXyl1Xw" +
       "shAb9H+UK8sWc2Uipk+JQmyixLsnaPM4mCZRvbgZJYY/WVjT0Y6wblWCLo3p" +
       "370528oWZiUwaogyaiiqwQZcucF+uyD/NgnoCvVBsxWrUK1at3ts7QdK6HWU" +
       "NtsIIMzAcCxxSjZ7hU+Uru8GdVF1CXyaNtu58mumLXvdSkzrF4Jap7tsoOVw" +
       "a8GtJ7+pk85NNlTPndz+Lk8D9m1aHWTgZFZR3IB2PVfqBk7KzCN1HN46+/ka" +
       "nHlL34gAJULLrJjkMl8nqG16GahT889uqZMQA78UoIv9usedJqjGGQebiT+4" +
       "h3wbdIIh9PGsbsex0dlJnBFygcIjAgtfy+3ClxdxH50pINh9tZ0GsvzGOiad" +
       "n9y0+eGbnzrJj+6SIo6P01lqgfz5BUG+mF007Wz2XJUbu2/NfG7GYjsjea4O" +
       "3LoxEMFmYsfsNt9Z1uzKH2nfO7HmpZ9MVF4Eit6JAiIwzs5C7szpWThF7IwU" +
       "JjngTnbI7un+6tja5ck/v89OX4U5yT8+Jl069dA7h1tPwGG8th9VQLLFOUbq" +
       "G8bUrVgaMYZQvWz25kBFmAXozZNBZ1JYi/Qmm/nFcmd9vpfe6RDUUVgTFN6E" +
       "waF1FBvrtayasHJwrdPjuUi3zwNZXfcJOD2uGkrnaZsXrWWxyICu2xciNe06" +
       "e7u3OPXR9mX2SJup/wAouZB1yxoAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1aeezsRn33++Xl5SDkvSQc6StJCHmhhKU/r72nFaDZ9a69" +
       "9novr/dyKQ9f6/u2117TlENtQUUFRANNJYhaKRSKQkBVUStVVKmqFhAICYR6" +
       "SQVaVSotRYI/SqvSlo69v/sdCCGx0s7Ozsx35nvNZ76er5/7DnRrGEAlz7W2" +
       "quVG+0oa7RtWbT/aekq4TzO1sRCEioxbQhhyoO2q9KpPX/z+D96vXdqDLvDQ" +
       "fYLjuJEQ6a4TskroWhtFZqCLx61dS7HDCLrEGMJGgONIt2BGD6PHGehFJ0gj" +
       "6ApzyAIMWIABC3DBAtw6HgWIXqw4sY3nFIIThT70K9A5BrrgSTl7EfTw6Uk8" +
       "IRDsg2nGhQRghtvz/3MgVEGcBtArj2TfyXyNwB8swU/99psv/eEt0EUeuqg7" +
       "05wdCTARgUV46C5bsUUlCFuyrMg8dI+jKPJUCXTB0rOCbx66N9RVR4jiQDlS" +
       "Ut4Ye0pQrHmsubukXLYgliI3OBJvrSuWfPjv1rUlqEDWlx3LupOQyNuBgHfq" +
       "gLFgLUjKIcl5U3fkCHroLMWRjFf6YAAgvc1WIs09Wuq8I4AG6N6d7SzBUeFp" +
       "FOiOCobe6sZglQi6fMNJc117gmQKqnI1gu4/O2686wKj7igUkZNE0EvPDitm" +
       "Ala6fMZKJ+zzneHr3/tWp+fsFTzLimTl/N8OiB48Q8QqayVQHEnZEd71WuZD" +
       "wss+++49CAKDX3pm8G7MH//y95543YMvfH435mevM2YkGooUXZWeFe/+yivw" +
       "x7BbcjZu99xQz41/SvLC/ccHPY+nHth5LzuaMe/cP+x8gf2r1ds/oXx7D7qT" +
       "gi5IrhXbwI/ukVzb0y0lIBVHCYRIkSnoDsWR8aKfgm4DdUZ3lF3raL0OlYiC" +
       "zltF0wW3+A9UtAZT5Cq6DdR1Z+0e1j0h0op66kEQdBv4Qm3wfQTafYrfCDJg" +
       "zbUVWJAER3dceBy4ufwhrDiRCHSrwSLwehMO3TgALgi7gQoLwA805aADbBrF" +
       "CYGMcLhRgde6STeNONDKCFvgVISQ+/52P/c576e6WprLfik5dw6Y5RVnQcEC" +
       "+6nnWrISXJWeitvd7z1/9Yt7R5vkQGsR1AAM7O8Y2C8Y2D9iYB8wsH8jBqBz" +
       "54p1X5IzsnMFYEgTQAIAy7sem/4S/ZZ3v+oW4INech5YIR8K3xiz8WMQoQqo" +
       "lIAnQy88nbxj/rbyHrR3Gnxz5kHTnTn5OIfMI2i8cnbTXW/ei+/61vc/9aEn" +
       "3ePtdwrND1DhWsp8V7/qrJoDV1JkgJPH07/2lcJnrn72ySt70HkAFQAeIwG4" +
       "M0CeB8+ucWp3P36IlLkstwKB125gC1bedQhvd0Za4CbHLYX97y7q9wAd49BB" +
       "ccr/8977vLx8yc5fcqOdkaJA4jdMvY/87Zf/tVKo+xC0L544BqdK9PgJoMgn" +
       "u1hAwj3HPsAFigLG/cPT49/64Hfe9YuFA4ARj1xvwSt5iQOAACYEav61z/t/" +
       "942vP/u1vWOnicBJGYuWLqU7IX8IPufA9//yby5c3rDb5PfiB0jzyiOo8fKV" +
       "X33MGwAdC2zF3IOuzBzblfW1LoiWknvs/1x8FPnMv7/30s4nLNBy6FKv+9ET" +
       "HLf/TBt6+xff/J8PFtOck/JD71h/x8N2SHrf8cytIBC2OR/pO776wO98TvgI" +
       "wGSAg6GeKQW0QYU+oMKA5UIXpaKEz/ShefFQeHIjnN5rJ4KTq9L7v/bdF8+/" +
       "+2ffK7g9Hd2ctPtA8B7fuVpevDIF07/87K7vCaEGxlVfGL7pkvXCD8CMPJhR" +
       "AggXjgKAQekpLzkYfettf//nf/Gyt3zlFmiPgO60XEHegQs4DYCnK6EG4Cv1" +
       "fuGJnTcnt4PiUiEqdI3wOwe5v/h3C2DwsRtjDZEHJ8fb9f7/HlniO//pv65R" +
       "QoEy1zmTz9Dz8HMfvoy/8dsF/fF2z6kfTK/FZRDIHdOin7D/Y+9VF/5yD7qN" +
       "hy5JB1HiXLDifBPxIDIKD0NHEEme6j8d5eyO9MeP4OwVZ6HmxLJngeb4PAD1" +
       "fHRev/PY4I+l58BGvBXdb+yX8/9PFIQPF+WVvPi5ndbz6mvAjg2LaBNQrHVH" +
       "sIp5HouAx1jSlcM9OgfRJ1DxFcNqFNO8FMTbhXfkwuzvQrYdVuVlZcdFUa/f" +
       "0BseP+QVWP/u48kYF0R/7/nn93/pfY98A5iIhm7d5OoDljmx4jDOA+Jff+6D" +
       "D7zoqW++pwAggD7zX/3B5SfyWfs3kzgvOnnRPRT1ci7qtDjfGSGMBgVOKHIh" +
       "7U09cxzoNoDWzUG0Bz957zfMD3/rk7tI7qwbnhmsvPup3/jh/nuf2jsRPz9y" +
       "TQh7kmYXQxdMv/hAwwH08M1WKSiIf/nUk3/68SfftePq3tPRYBc87Hzyr//3" +
       "S/tPf/ML1wk2zlvuT2DY6O6P96oh1Tr8MMgKR5NZmtrKKIPTVga3qh1NTTqC" +
       "23YoUcD1IUc6akiNPXJWXZkkNTUCFIvFDaE0NkzDSzHZ9Dmqu6iaK8ptz/pB" +
       "Ss+FPj2Z6n2aFOWZLbGLOd11hf5qgnLCsLVEPa8/9V3B8udRbMKDRlwxsnCt" +
       "+wHq0RvRriFwzcGaTbgCZ0Mn8AdUedaJFtOVPqjL6gATXLMP4kPOnczL3LQy" +
       "mWMDxfcG8CCO/dpm0xGYPsVNMoZ3O6Zt6GPNDPDlgMp4eW5WdV8bVIYkrrjs" +
       "kGvRBk+yOB3UtbZvSpWS0W9QppmQUWtqtyoCxaoTRF9NVpKRMhLTRFqzXkbV" +
       "cTrpTFhkY62xMjtxBM5bNRvJPFon4Sgc9ngrRQyKFtws7M7kLjWLTHYFGmKH" +
       "Jhc6H+iW0Z/NDIpPDJer9PthSNjbfoBb2aQ5zzpaQxp5bMzjqED7vsvyXr1G" +
       "8LEwcCmuK3MqNl75I3Ics3OsxbPErJ56gxmx7i6taYudzFcIIy7IyVJA0AFi" +
       "J1aQtVM9Q6beFJloqsbXaIwgJs10VS5P+cxod4YiEfJNWm1I/WYkZ/2WNhoz" +
       "2ggUi6C5NrdIB++SNouYfddQWapLaCaulehBr72xY3OC01V+YiZBuxdOSQYP" +
       "tnF76fHWcORPGXqy0aII64wCqjqMfNHoV1UDJXmTFiheWY+mHaKz2FR9k/LF" +
       "FmLY4JjL8HHkjtuRSLm0zhItomKZRi3sJzZOBKrVNER0PKuRLVyfs9agbHkl" +
       "f0nPtVZjluGkrpNen2xxrj81Vwu/2261UBz1BdkaewJRn2uD1dwgaLIkzXsl" +
       "3BSHK6quUuoUKVFKak/bfVGsurFCZ+v1SFCTUkBiMxBddUb4NPHmY0zokkEF" +
       "X1SI6SJV0ZYshWTNq9FqtdZc0FSXSuLBrGJTcK0Ry5tKoDTXiouMY3FE2SM0" +
       "HcuqLk3NLkzyYrPJyBgmstHCRYw554W9ymJQQxcyWy/Xxpy66Nk1UjGZ8hjd" +
       "1u2ISGtVrLUtEeYEgQVtWvbYsO10ZjRp8su5kEgctgin3akz0nqDBi7gzLgC" +
       "C2rf0Udb3XE2ls1N0/5kbU3j0EdoA24SxJTX8dhXSceeIb7sjGPTmDY64Imy" +
       "OvWr1GaRNCSuOYEb9EIfm8PVdtFuWTN+PudWqkAGyzVBtdNq3BGjdquHtJqM" +
       "562QFtXHeX/S7S7xSRqtGLTDroYSQSZsSrcWPlKWqxI6EbDusjuYDGfOLN6O" +
       "talhY2M4EAzLL9UzdtLq4IMQG+NqEHpVVDDDNsl1/OlSxhpNJAs7k2o1Ns0w" +
       "SMkyqU0oaTLHOYqYLN3upN/GBU7tznCmjfDIkBi1J6o5GLZwqUPLMtrpoBVh" +
       "LBNsWzNmbDPUcId1ta1U0diKEg7MEu0hm0DD1nLPIfplYtYze8OQoBdzUvcX" +
       "C8VUB7ljxWukOdOEzKFX9W6gyHjIo+qUU9sVjpe7AWH7EUuE5V4d54PIDomB" +
       "WJE4HKNsyx/X3PrGcFdZqMRcTKlRrTnhlbDV942q1es3HRNtwEzGMkSNTGoS" +
       "vO40wyUqJKmuAC042YSmBXPU66VWCWtOTW+yIQiU2jTAySF6zbbRrXVRimhZ" +
       "caU05LZdhBxxo8bCItV0JJg8OR+pAdqUEJpEXLdcHatowolzt6rodnfd8reb" +
       "Mc5P1ijvNGBEKze3HOZ63oCclxIprS97LOGhoQ0wx6yOKXEikoNRvVPFupte" +
       "AymtcKVDVTOXYXiVQCudCSFNeuuOWq3D0VqB+zV2tFTVehdXuEhsZ30n3Wb8" +
       "mu81W04Lw+DytG6TstPpC5OauGGkhKsk9eXSpt00mrgtpjsZ9NhoXibIgUcv" +
       "Vklgj+rrdbYKl5se7iRVtOm0gjI5Mvi1E9GVTr2B6OOegxgIBgsoN2nrAq+m" +
       "FXg0GDSCsLblkdQmR10R2XYQVFrXlkttsVYnSTsgs361prLMgilN8G3Lr6mb" +
       "hi1GY7FW8VE7Q3usUWHi4bI/n3Idr1yfiZihhZvKghPya08ZS3osg/bcqtZr" +
       "sSuGqm/SbgfDRmXFaciJVO90lhwyEVluMDSxchatnTZrL31CTxrtQdSfDAKb" +
       "UIfuoKS0TWNRd2N3Oa54VhbXK1sETzrYDISAhrpuqXSHxkcZN0lEswE3eohk" +
       "YIQvtH1+jLToMYYsy92wE/rtqt8Ls5Hda5NrWKmMSuGIm9fsKTGr1fRmuUY7" +
       "65qQRF6IbjMbrytDORazNdpXttoQk6REXEnbqL1N3Clru92hRg3FLjl1e/X1" +
       "GOzolPSrXTgec7iAOkTW9mtzW0QrLF5fZmEGN5BarFUbWHMzM3zb7JbhaZUw" +
       "0A7hbqWwPjPLrXralQdGrNbs3hoeY0HE1Y3a0BAIuCGKFAWLzZZBqPW11Eh8" +
       "mPFho4SK81isbMppOZzhTrbBZpVaUB1lAbYtsR1V5sdSkrGzrtxgl77EhQvC" +
       "mCXEuOoP+TGKdEaUHPPtcnmVhtq0pKozIRFhftRvZu1h32a2cD8kLG4STSts" +
       "0+PZQRTVcMQmq5TGLEs6R3FctV2l+5uopGpWqiRwe8jgHVTUaLK/TvGN00bV" +
       "cGNjcLWyHkhSihDtzabfiEaO7y8rg1QubZNl3MeZVtpYSITXkJoK0DpiVv2t" +
       "VWqatfJqIie10CeMpbPJ+txIoPoblm00rTouwxWk3V/pBtvVNGYy6pF0H4QV" +
       "MlF2BKwUlCQnbsCpPNy0EXlABzBfkleGWUPhlZ5KDB8nidQes6say3imyNcx" +
       "KUZUGE4zcTtaziq8EGyU9TiJR1YN4ygXgLuNlWthpkquK0jqlDZSiulsYy0W" +
       "BCo/7Fu1pcjS5pSIyxtpUjGc7niFLAE+lWI/6xFMaVXDNgO6Wm2GbM9dDXuj" +
       "1nobVggnWfdmjDQep2mqKkp5Yc19YrrmMHizLfVqmSI3cZTp0hN7kcoLrDUk" +
       "JY1rkNuN3dAVstFYNQfDTraYY126XZrTyLwmInyFhpPQjOf2Cm3I7jyzekI1" +
       "jfqruTXotnlRiCU0SDrJOG0MRIaSulljm5V8xdk4bGj14gpLsE3Jr8Bon+li" +
       "MFxvJDMLH40Nyu1tt5MmzdewGK+XsDSeyiMQxsqlWT9D1ZZkymiNdwbL6kC2" +
       "uObI9V0NwTV+WF41WHzOTDFVUxnCW26HxIypOJv1GkAyvFFgJhw3S2NiqGxh" +
       "NVB6grWtula/izX1ljR1wUN/VWMJk5gI7eliPp/TmoQPPFubd3FYUrb9Ck8M" +
       "B4YlUg1nPtWRVuISnLQou8xy3RRGdkAttxayTEKtJWI9wGwzXEjoTPfAUTex" +
       "t3rKhI4wHlRtnGc3osrTqxW8mBtceVVPRGuBM27FqzTKNbTpLnh9lgiuuhV0" +
       "3U8mvBRLRCneduCh6rj4Zt4O00Uw6yNCVInCxkTu13uL2TAKKWqQtSQ8TacG" +
       "39BmpVkQN0l5TiD4cisMo7jWtGObWW7kqZkFRJUWvEYUuqN5IjTJiG6UPLNZ" +
       "Gw4tbuzIWYkxmx3MRoTeglN5gmcrVBsdz9d+22z0M3yI9IbVegk2BadnMZWq" +
       "2qJnDBPQhjmwmo5PInVS0LhmE4t9fjBpNZozl9pgcajItG+Q5EQRda5U1SqJ" +
       "KFOUho3JUAyVtCxbtNMmtqpEGS01Wm9LFdxK5bRXK3vUUMMivkyGm4wc6YLs" +
       "YNtySSFFJwOrlupTyq2Py4jlq+us1p6RJZsolxuLDF3SMzFG4eGabJArIzQU" +
       "oTqqMG7aHRD2KlyHwwjjkTjr91BnPWr0bI/HBnOi2tWjOt3SqSQLa3gjzLwF" +
       "pxENKpnRhqNyDvCC2CnVI0OoSSa8aWKjZXVW23LNEm2V65jcamhINE5Ishlp" +
       "2HzCMMRoJvpkU5wFc1UYrPjJBvBWM9uE3Vq6GT9s8wi90uGJbcMOIdkytvHW" +
       "Sp3tzGZzlSOG9W4iEDm4BZGwFcIenQTy2IhneiVLhvxyLdGjDhqTZuAIfLgM" +
       "Fot0S+Exmkr6UCnXFfDcNxovWcxeolM69uCk5QJYRrapCx5M3/CG/JH1TT/e" +
       "rcE9xQXJUYLLsBp5B/ljPC3vuh7Oi0ePLoWLz4WbXAqfuDg7d3gZU7omKaBu" +
       "ov08e7h/TSIgvzV44Ea5ruLG4Nl3PvWMPPoosndwSbmIoDsi1/t5S9ko1qnl" +
       "A+i1N74dGRSpvuPLs8+9898uc2/U3vJjpAceOsPn2Sn/YPDcF8hXSx/Yg245" +
       "ukq7Jgl5mujx0xdodwZKFAcOd+oa7YEja1zOlf9a8IUPrAFf/4r+up5zrvCc" +
       "nb+cuQM+Xww4f2i/R4urrcJerSgKdDGOQKSvAV1IkRJQkVJcuAN1P3pjdRdX" +
       "0ru7pWd+/5Evv+2ZR/6xuNW9XQ/nQtAK1OvkOE/QfPe5b3z7qy9+4PkiC3Je" +
       "FMKdPs4mh6/N/Z5K6RbC3nWkvrtybV0Egg532tv9RpD0E+bcBM8L83SbGLhJ" +
       "qATw0JWVsS6ZSjAWHMU6TO39NJbZbWL2xF6fR9At+sG7A7mtz53Yq8XdWJae" +
       "gwrvecf1/WbvCHGOwOaCpTjqLnf6ZF5svfRo/r0d0aEv3Xd8TYpbrqPkCY/D" +
       "vl3yT3f3j14fAJ3pdTm1dpwWi+XFIzfJYvzmTfrelxfviaBbpZyZHe83Gf6B" +
       "g0tEwOxLC2bBs8K+qrj2/tgFSkU7h70PHfWuXSfaJ0DBKo6sBAevTRSzRTdZ" +
       "6em8cCPokhQoQqQc4+ThCq+5OahOPcE5QVCgvfej7kZPpUAi6P4bZWvzdNP9" +
       "17w2snvVQXr+mYu3v/yZ2d/sturh6wh3MNDt69iyTmYHTtQveIGy1gvJ79jl" +
       "Crzi5/ci6MGbp5SBO4OyYP93dzTPRtDlG9OA0+KofpLqY0DXZ6mAXxS/J8d9" +
       "IoLuPB4HfH9XOTnkk4AnMCSvPu9dJyOxS6+k504cVgenbWGme3+UmY5ITmZC" +
       "c8MXL/wcHkbx7pWfq9KnnqGHb/1e/aO7TKxkCVmWz3I7AMddUvjoQHv4hrMd" +
       "znWh99gP7v70HY8eHr537xg+PmZO8PbQ9VOdXduLiuRk9icv/6PXf+yZrxcJ" +
       "kv8HguRtv4klAAA=");
}
