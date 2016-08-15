package org.apache.batik.gvt.font;
public class UnicodeRange {
    private int firstUnicodeValue;
    private int lastUnicodeValue;
    public UnicodeRange(java.lang.String unicodeRange) { super();
                                                         if (unicodeRange.
                                                               startsWith(
                                                                 "U+") &&
                                                               unicodeRange.
                                                               length(
                                                                 ) >
                                                               2) { unicodeRange =
                                                                      unicodeRange.
                                                                        substring(
                                                                          2);
                                                                    int dashIndex =
                                                                      unicodeRange.
                                                                      indexOf(
                                                                        '-');
                                                                    java.lang.String firstValue;
                                                                    java.lang.String lastValue;
                                                                    if (dashIndex !=
                                                                          -1) {
                                                                        firstValue =
                                                                          unicodeRange.
                                                                            substring(
                                                                              0,
                                                                              dashIndex);
                                                                        lastValue =
                                                                          unicodeRange.
                                                                            substring(
                                                                              dashIndex +
                                                                                1);
                                                                    }
                                                                    else {
                                                                        firstValue =
                                                                          unicodeRange;
                                                                        lastValue =
                                                                          unicodeRange;
                                                                        if (unicodeRange.
                                                                              indexOf(
                                                                                '?') !=
                                                                              -1) {
                                                                            firstValue =
                                                                              firstValue.
                                                                                replace(
                                                                                  '?',
                                                                                  '0');
                                                                            lastValue =
                                                                              lastValue.
                                                                                replace(
                                                                                  '?',
                                                                                  'F');
                                                                        }
                                                                    }
                                                                    try {
                                                                        firstUnicodeValue =
                                                                          java.lang.Integer.
                                                                            parseInt(
                                                                              firstValue,
                                                                              16);
                                                                        lastUnicodeValue =
                                                                          java.lang.Integer.
                                                                            parseInt(
                                                                              lastValue,
                                                                              16);
                                                                    }
                                                                    catch (java.lang.NumberFormatException e) {
                                                                        firstUnicodeValue =
                                                                          -1;
                                                                        lastUnicodeValue =
                                                                          -1;
                                                                    }
                                                         }
                                                         else {
                                                             firstUnicodeValue =
                                                               -1;
                                                             lastUnicodeValue =
                                                               -1;
                                                         }
    }
    public boolean contains(java.lang.String unicode) {
        if (unicode.
              length(
                ) ==
              1) {
            int unicodeVal =
              unicode.
              charAt(
                0);
            return contains(
                     unicodeVal);
        }
        return false;
    }
    public boolean contains(int unicodeVal) {
        return unicodeVal >=
          firstUnicodeValue &&
          unicodeVal <=
          lastUnicodeValue;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "2zSzZWZ5iykimRZmTmxfEl1sXv4vaj++BxsZAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALU6e+wsV1lzf7f3Sdt720JbCn3fVtrF3+xj9pULyO7Ozu7O" +
       "zu7s7szO7o7KZd6Pnfd7B6uFBIuSQKMXxAQaE0GFlEeMRBODqTEKBGKCIb4S" +
       "gRgTUSShf4hGVDwz+3vfe1shuvnN2bPnfN93vvf55pzfi9+FzvgeVHBsY6MY" +
       "drArJcGublR3g40j+bs4UZ1wni+JHYPzfRqMXRMe+9yl7//gefXyDnSWhe7h" +
       "LMsOuECzLX8m+bYRSSIBXToc7RqS6QfQZULnIg4OA82ACc0PrhLQa46gBtAV" +
       "Yp8FGLAAAxbgnAW4dQgFkO6QrNDsZBicFfgu9PPQKQI66wgZewH06HEiDudx" +
       "5h6ZSS4BoHA++80AoXLkxIMeOZB9K/MNAn+oAF//tXdc/t3T0CUWuqRZVMaO" +
       "AJgIwCIsdLspmbzk+S1RlEQWusuSJJGSPI0ztDTnm4Xu9jXF4oLQkw6UlA2G" +
       "juTlax5q7nYhk80LhcD2DsSTNckQ93+dkQ1OAbLeeyjrVkIsGwcCXtQAY57M" +
       "CdI+ym1rzRID6OGTGAcyXhkCAIB6zpQC1T5Y6jaLAwPQ3VvbGZylwFTgaZYC" +
       "QM/YIVglgB64JdFM1w4nrDlFuhZA95+Em2ynANSFXBEZSgC97iRYTglY6YET" +
       "Vjpin++O3/KBd1l9ayfnWZQEI+P/PEB66ATSTJIlT7IEaYt4+9PEh7l7v/C+" +
       "HQgCwK87AbyF+f2fe/ntb37opS9tYd5wExiS1yUhuCZ8nL/za2/sPNU8nbFx" +
       "3rF9LTP+Mclz95/szVxNHBB59x5QzCZ39ydfmv3Z6tlPSd/ZgS4OoLOCbYQm" +
       "8KO7BNt0NEPyepIleVwgiQPogmSJnXx+AJ0DfUKzpO0oKcu+FAyg24x86Kyd" +
       "/wYqkgGJTEXnQF+zZHu/73CBmvcTB4Kgc+CBbgfPQ9D2k38H0ApWbVOCOYGz" +
       "NMuGJ56dye/DkhXwQLcqzAOvX8O+HXrABWHbU2AO+IEq7U0oUQDLQDHw3NIE" +
       "W5RmwK+k3czFnP9P4kkm2eX41Cmg9DeeDHkDREvfNkTJuyZcD9vdlz9z7Ss7" +
       "ByGwp5MAehKst7tdbzdfbxest5utt3t0PejUqXyZ12brbu0KrLIG8Q0y3+1P" +
       "UT+Lv/N9j50GDuXEtwGVZqDwrRNw5zAjDPK8JwC3hF76SPxu5heKO9DO8Uya" +
       "8QqGLmbokyz/HeS5Kycj6GZ0Lz337e9/9sPP2IexdCw174X4jZhZiD52Uque" +
       "LUgiSHqH5J9+hPv8tS88c2UHug3EPch1AQd8E6SRh06ucSxUr+6nvUyWM0Bg" +
       "2fZMzsim9nPVxUD17PhwJDf3nXn/LqDj12S+ex94ntxz5vw7m73HydrXbt0j" +
       "M9oJKfK0+lbK+dhf//k/VXJ172fgS0f2NEoKrh6J+ozYpTy+7zr0AdqTJAD3" +
       "dx+Z/OqHvvvcT+cOACAev9mCV7K2A6IdmBCo+b1fcv/mm9/4+Nd3Dp0mANte" +
       "yBuakBwImY1DF19BSLDak4f8gKxhgODKvObK3DJtUZM1jjekzEv/89ITpc//" +
       "ywcub/3AACP7bvTmVydwOP76NvTsV97xbw/lZE4J2a51qLNDsG0qvOeQcsvz" +
       "uE3GR/Luv3jw17/IfQwkVZDIfC2V8tx0ai9wMqZeB6qLHDPboHa3G1RuTTif" +
       "fjpvdzNN5EhQPlfJmof9o1FxPPCOlB3XhOe//r07mO/90cu5GMfrlqNOMOKc" +
       "q1u/y5pHEkD+vpMpoM/5KoBDXhr/zGXjpR8AiiygKIBk5pMeyD/JMZfZgz5z" +
       "7m//+E/ufefXTkM7GHTRsDkR4/Logy4At5d8FaSuxPmpt2+tHp8HzeVcVOgG" +
       "4bfecn/+K6v8nrp14sGysuMwdu//D9Lg3/P3/36DEvKUc5Pd9gQ+C7/40Qc6" +
       "b/tOjn8Y+xn2Q8mNORmUaIe45U+Z/7rz2Nk/3YHOsdBlYa/+YzgjzCKKBTWP" +
       "v18Ughrx2Pzx+mW7WV89yG1vPJl3jix7Musc7gWgn0Fn/YsnEk22YUKPgeeR" +
       "vRh85GSiOQXlnVaO8mjeXsman9iP63OOp0Vgc98L7B+Czynw/Hf2ZMSyge1W" +
       "fHdnrx545KAgcMA2dZeseX6wtyPlSnhlQ088zQRpK9ori+Bn7v7m+qPf/vS2" +
       "5Dlp1RPA0vuu//IPdz9wfedIofn4DbXeUZxtsZmr7Y6swbI4efSVVskxsH/8" +
       "7DN/+DvPPLfl6u7jZVMXvBV8+i//66u7H/nWl2+yb58GJfE2v2ctkjXtrXbr" +
       "twyatxw36aN7z37/ZialbmHSrNvNBcZArgKF6zHbZOPECe7oV+Vuq7lTwF3O" +
       "lHfru8XsN3vz9U9n3TeB/cLPX1wAhqxZnLHP0H26IVzZdyQGvMiAmL6iG/Vs" +
       "uniCL+x/zRew6Z2HWZmwwUvD+//h+a9+8PFvAvvg0JkoEx0Y8kjqHofZe9Qv" +
       "vvihB19z/Vvvz7c6oDzm2Se+82xGVXgl6bLmHVlzbV+sBzKxqLxOJIDGR/nu" +
       "JImZZDmJwRF5RgHY4wCLP7a0wR0v9RF/0Nr/EMwKXcTzJFlIJAxrfThF4Woj" +
       "SVQ0WdfD6VRz3KlCkv15SibeYMzMNx1TDHk/kaM6VasLMM92KBNnul0NY7Ch" +
       "QnC4M3d6zkDruj1vPusVNddVx7ZLMeugY3IzhgpYZmjWBj1mXvaKOtvky3zU" +
       "DOVQx1FuXWFDPuLHZsWIokhqjiuy2tPMlBCJrtiuq90Nlw6SYq1eWyzSGRH0" +
       "vGXQmin8fF1bFgk4DJtuSs7TYbth+d2FUxk2Z6ZFeXQ3WikLjnfHrlSLw1hK" +
       "1AFiN0Vt7E16Q0wYyyw6mhfKoTEE3uW7dX06QxW6Mtecbm/jmUYSkIJIr4ck" +
       "tl4o1VI3mde0MjKMyuXheqb3Rx1GbNhzqVGRRz2cmYQLfWU1+S4qDpJesZQy" +
       "tt5nqmaR1Wpxii5K2gIdI2qPQaqDTnmz7LfTQDMnbakYYWiltqroA3jZaS9J" +
       "21MDwezJlZEYTRND0WbAS4rT2tiRNmgVw6iuNmH6JkYuzAk748iYa08XKeN5" +
       "lN8Puaop0d6cj9WNVGJm4dBTVNrgEYPV57Zm9GkOXo3Kml0d1IOVjq/K1U3K" +
       "GC7LFnC6VhtYdKHgwWUEd2f+WuQ8SW8Gs1V7JGDquqvW8bmFWeVgTXXwKYsr" +
       "ca1fERq+sfBcpz+hdH5V8zBSUsPJJFTm/SKwW4K7oVdoCTG98rwlim4cc4kN" +
       "2hvZmRtj2h4FfrXCs/OFGA6QHqYZsc/5eGspkMx4OCvNm7FgbZDBRtC5SkWJ" +
       "2yNvriQTk1gbmscMp5vpTAGmkDy0uKy1LB0Z2ea81xqjGtvHZo6keuuNq4u4" +
       "Mh5QA1TwKhtsro+7dr01ZNNRB7FxetkeajFpVVFT5tISr+tlv95EUbw1q9N6" +
       "G4vh0jKuUWY8nBYMc7pQUm3aLUcLECizAtcQ0NmoE0fgMQizgDSFqCw2i7V5" +
       "xRltqJY+rCOKtIptaV6TdV+scmWvaQhKENrjVolPhEllQdU0byxWi9VVoiz6" +
       "ZjWltU1RL1e5RcFKk7iApnWyu3HDtVZdmbqDkR17SmOU49pJLa2ZIyTYGKGi" +
       "+VVN4tpyFBYVrNkj3TSkwUsITbHehjB6juaO42nUAM7DdNqE63Yi17b0RSo7" +
       "/aTbREfmgJt2+sYApRNy1of74810MutSE8w2KDV0bb7I1InpJAqGaJvs9+N6" +
       "1y6itbWkB06v3BrgszhxybmPtjv9sYQO4IRrD4Rusxy4sRPPZ7CirefTVcjD" +
       "88q6R7B+2lfcdrEq9KalGsqNDZVrGSZKra1i0697egNu4ly3i3AtJBmTjD+u" +
       "dUHhPhvGS0WeayFW74YJgqvCdCNUMFHiqvHQHU0rxU48XkS1ftOtwmWV6EzR" +
       "Yb/TwIwabmsbeBYQ/nrdW4YDidFWhcpa03x+qYR0UVUdp+VM5nElTXTW67VV" +
       "vLdcdAJtRQ4FfdwelSV60HJSdDA3lJY2dFazfqfMJKqWCviGDmfIuExvsO5s" +
       "HVjafFh3mgKpTwplHIkqSddc0XAVqeJGjPlINBMcsiiPPaGnEDWqUvd1ht4U" +
       "JNKkEESCCTxYr01UoPmFgre0vm1pmMHT46Ygacy0VunUeRL4uYkJLcLkYjdE" +
       "FuQy0BLa3pSZVR+lfAyfxyWR7ZfkpCv4K7EodKdq0JU39Zateig/7TbcagXp" +
       "NmFE9Gp4fTrEudGMjVvurCPVw3EVrlYFuFBALbVuppQ7Ga8LlXqvnCZdVbC5" +
       "NjUvhURL9NsKGk7hSbNfb7qLoN9UvJHi08OpEpZXgU+2W0y/06sXNqrfn8C6" +
       "vYlowx8EKeqsa/2V1MGro7Tri3hpmvRi0/UqcrFVXFitNqJxpaBYQ7Dx2NWp" +
       "cDTd+HJzEZQjVLMQmKGSxB7hQ6wou/ywgvaxctFSmzDXhAXTprj1aoiXZIkb" +
       "UjInIWVPYg2j2IqkmSSlIis2EYtGUGnaQUqllWVyKL1uT7xwaGLzvoSbrEoP" +
       "0qGlBRMBx+ryQHTHtdY60VZqxaxjLLsM9VgFNNaOQ6FGocBOuAlbaEhGeYVQ" +
       "hVLUQW3H5PikXSyDHUmR171psGSnUkyvx6Bikfi2FFam6LhV68yUJVJqVo3W" +
       "gjFlvJ04I9+Vo4VeKvCRXJO6KhrgxoKfzjoCU5yLZkvasJMp7ptpD5YGjUZT" +
       "xoYc6WIuRU8KRNxuTtJNDFLYmh5WycESNxK2wTfCqkv5HaCquT+nR2h51GmM" +
       "e8FwrIsaCsOVUITlsOo5DdbYGE3aIledRsIXhKqwkOFNBW6oaUh1kFbIDFaT" +
       "qtIcEbTWDCuylpphcYP6JT8tzNdEeeyKUkGulsZwh5DmMOqQwykzjMjWctN3" +
       "XWO0RPo2pRX90jzFxr0CcL0OXVqlPL02lzNnTQqFzXRVTdebZXE+8+rBFONi" +
       "xO0EI5Sud2cNoYouputZsa6KNK9OgoWZhGkdH6gL0xEGhtaauY617jp4XMIx" +
       "CanTjr1Qo4gmXK4MW7SgqpTj2K1ZUo21hlCXYMGblYK6TKVTf6i32xu/VB9H" +
       "HjORGrKERTFPzU1k1fPbaexgzrCkFlLPmfbkmBK6aQWOY7BXK51NuReEouY2" +
       "qgw8UE1T6rJCp1Ub9nt6kZOjyBXGnc4gXrVisuJtNkJDS4rVYddZVlSHqTp8" +
       "UNG9uE71ybi8KtcXaZ8emnivmjTCfuS1fUQiN1ixVHAjBfX09USWCLneEEmZ" +
       "5MdxOF9RC1eAZb5GYgw1mBT8ardXkYNuZVqYjKtscRp54cBhnCVdXrFGEZ+U" +
       "Vl69TwtCSQ9lgca88ojrK7Fl80zc1onqKvIxvjeg9L6wZPkpCYT1BbzqR6VW" +
       "d0N4ythMag0Xk3iUX2OewhfYDonEZBulRKvcR3vLpSryZj8ZUlK7gLQqDO8L" +
       "VAJwEUcsT6ctR23AJLtciUsWLXeNCK0QA3TAVsMG3zPbnFIrzwshyGZGiVoW" +
       "0pogS3iFqAskXy8wsar3TbNKFUIiqk5RMhAYlOA1ppTAcLEwbHvUpM7X+r3l" +
       "rB7PDdQQ63YU9S2ZC5nuYpwOcMqyKhLdXDe9RmNY2/S6TT5U4emwMrFAlE64" +
       "eN0YSaKwKnaR0FfwaQdfRrMF39NUy8J0zKoIuLeCR3Oy0dD8IoJXGRL3KIzB" +
       "YXQk6yV83oRBLsfCHmbrICYNd8RisMmayNJNR/M+6lH8KkhJsTBsIYjZXlRE" +
       "zedAJUUrStCu8fHK6vtLq4MU6YYs6qWEncCdUnNNDq2kYhWSiRGumrUCB3fE" +
       "gbSsuZ5FtEtkvTLjaRN2y47Cq4SjL8eLIoYUQhAd7ND1h2qvpJKUMmrGvqvb" +
       "Fruh51FMhSkSVPkGVmoanYbTpu0JM6SV3ritzavD2UReekYklAhj43fHswrX" +
       "GASk0p9TsdRc+fMJTKw1n25EY6tu62ZF2gwmOFUvrkUGieAJMSyvq3RBmTY8" +
       "zGWLTbRUgGu1TaPXsTmLTbqEuJi2C3NxDP6GiONuCrZbqfdBNMdL1q0M15YG" +
       "3KJDNKm5RBCr7MWgm4DNxhOMMGXK0sTRpUboTPQqUEXJgInYmNHgtSSlmuSo" +
       "vOIEn5AW/VqhndjLUt0sj8WCUCZskKdFWYOH8mbiKNyyXwVK3IQrWSLrWNxz" +
       "q80SU16jkwG9QTS3ICJ4tGo4q+ZKcZlloCuJ3+Upm5mMmG59NEvUWSQIg0jX" +
       "A0+oTZAgHliEbJSYSU0eLdtMz5QXokYGeDXZOGNbbMjFxCwvK0Fv3cM9RbcM" +
       "J402M2LSqrSQUscvp1TKLtiqtllr5ow1aTORu0bJX0ZIxOkFIIvPgje2t2av" +
       "cvaP9op5V/7mfHCJ9mO8M2+nHs2aJw7OG/LPWejExcvRY9zDIzwoOzx58FZ3" +
       "Y/nBycffc/0FkfxEaWfv6HMcQBcC2/lJQ4ok4wipHUDp6VsfEo3yq8HDI7kv" +
       "vuefH6Dfpr7zR7iBePgEnydJfnL04pd7Twq/sgOdPjigu+HS8jjS1ePHchc9" +
       "KQg9iz52OPfggWbvyTT2BvAQe5olTp7kHNru5sc4b9ra/sTJ8qlDgGIO8N5X" +
       "OHp+LmueDaDze0eg/s2OI87xtm1InHXoRu9+tcOIo+vkA8/cKDe9Jzf9fy43" +
       "kQNcfwW5P5w1Hzwid/b7lw4FfP5HETAJoNuPXrll9wf333CRv718Fj7zwqXz" +
       "970w/6v81unggvgCAZ2XQ8M4eqp7pH/W8SRZyzm/sD3jdfKvjwXQ6295DRhA" +
       "t2VfObsf3cL/RgC99mbwAXQatEchfzOALp+EDKAz+fdRuN8KoIuHcAF0dts5" +
       "CvJJQB2AZN1POTe5JdkegyenjmeSA1Pc/WqmOJJ8Hj+WMvJ/udgP73D7TxfX" +
       "hM++gI/f9XLtE9vrM8Hg0jSjcp6Azm1v8g5SxKO3pLZP62z/qR/c+bkLT+yn" +
       "szu3DB868BHeHr75XVXXdIL8din9g/t+7y2//cI38rPG/wED9Pk1CyMAAA==");
}
