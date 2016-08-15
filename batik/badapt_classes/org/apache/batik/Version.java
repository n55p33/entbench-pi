package org.apache.batik;
public final class Version {
    public static java.lang.String getVersion() { java.lang.Package pkg =
                                                    org.apache.batik.Version.class.
                                                    getPackage(
                                                      );
                                                  java.lang.String version =
                                                    null;
                                                  if (pkg != null) {
                                                      version =
                                                        pkg.
                                                          getImplementationVersion(
                                                            );
                                                  }
                                                  java.lang.String headURL =
                                                    ("$HeadURL: https://svn.apache.org/repos/asf/xmlgraphics/batik" +
                                                     "/tags/batik-1_7/sources/org/apache/batik/Version.java $");
                                                  java.lang.String prefix =
                                                    "$HeadURL: ";
                                                  java.lang.String suffix =
                                                    "/sources/org/apache/batik/Version.java $";
                                                  if (headURL.
                                                        startsWith(
                                                          prefix) &&
                                                        headURL.
                                                        endsWith(
                                                          suffix)) {
                                                      headURL =
                                                        headURL.
                                                          substring(
                                                            prefix.
                                                              length(
                                                                ),
                                                            headURL.
                                                              length(
                                                                ) -
                                                              suffix.
                                                              length(
                                                                ));
                                                      if (!headURL.
                                                            endsWith(
                                                              "/trunk")) {
                                                          int index1 =
                                                            headURL.
                                                            lastIndexOf(
                                                              '/');
                                                          int index2 =
                                                            headURL.
                                                            lastIndexOf(
                                                              '/',
                                                              index1 -
                                                                1);
                                                          java.lang.String name =
                                                            headURL.
                                                            substring(
                                                              index1 +
                                                                1);
                                                          java.lang.String type =
                                                            headURL.
                                                            substring(
                                                              index2 +
                                                                1,
                                                              index1);
                                                          java.lang.String tagPrefix =
                                                            "batik-";
                                                          if (type.
                                                                equals(
                                                                  "tags") &&
                                                                name.
                                                                startsWith(
                                                                  tagPrefix)) {
                                                              version =
                                                                name.
                                                                  substring(
                                                                    tagPrefix.
                                                                      length(
                                                                        )).
                                                                  replace(
                                                                    '_',
                                                                    '.');
                                                          }
                                                          else
                                                              if (type.
                                                                    equals(
                                                                      "branches")) {
                                                                  version +=
                                                                    "; " +
                                                                    name;
                                                              }
                                                      }
                                                  }
                                                  if (version ==
                                                        null) {
                                                      version =
                                                        "development version";
                                                  }
                                                  return version;
    }
    public Version() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAK1YfWwcxRWfu/N3bJ99SZyQxE7iOJEcwh1RSQtySomNTS6c" +
       "HcsOkTiXXOZ25+423tvdzM7aZ1NoQlUR/kFRGiCthP8yQkV8qSpqKxXkCqmA" +
       "aCtBo7a0Iq3Uf+hHVKJK9I/0683M7u3enu2IqpZub+/Nmzfv8/fe+OXrqNGm" +
       "qI8YLMkWLGInRw02ialN1BEd2/YJoOWU52L476c+mbgnipqyqLOE7XEF22RM" +
       "I7pqZ1GvZtgMGwqxJwhR+Y5JSmxC5zDTTCOLNmt2umzpmqKxcVMlnOEkphnU" +
       "jRmjWt5hJO0KYKg3A5qkhCapI+HloQxqV0xrwWffGmAfCaxwzrJ/ls1QV+YM" +
       "nsMph2l6KqPZbKhC0e2WqS8UdZMlSYUlz+iHXBccyxyqc0H/6/HPbl4sdQkX" +
       "bMSGYTJhnj1FbFOfI2oGxX3qqE7K9ln0OIpl0IYAM0MDGe/QFByagkM9a30u" +
       "0L6DGE55xBTmME9Sk6VwhRjaXSvEwhSXXTGTQmeQ0MJc28VmsHZX1VppZZ2J" +
       "z9yeuvzcqa7vxVA8i+KaMc3VUUAJBodkwaGknCfUPqKqRM2ibgOCPU2ohnVt" +
       "0Y10wtaKBmYOhN9zCyc6FqHiTN9XEEewjToKM2nVvIJIKPdXY0HHRbC1x7dV" +
       "WjjG6WBgmwaK0QKGvHO3NMxqhsrQzvCOqo0DDwIDbG0uE1Yyq0c1GBgIKCFT" +
       "RMdGMTUNqWcUgbXRhASkDG1bUyj3tYWVWVwkOZ6RIb5JuQRcrcIRfAtDm8Ns" +
       "QhJEaVsoSoH4XJ84/PSjxlEjiiKgs0oUneu/ATb1hTZNkQKhBOpAbmzfn3kW" +
       "97x5IYoQMG8OMUueH3ztxn0H+lbelTzbV+E5nj9DFJZTlvOdH+wYGbwnxtVo" +
       "sUxb48GvsVxU2aS7MlSxAGF6qhL5YtJbXJn66cPnXiJ/iaK2NGpSTN0pQx51" +
       "K2bZ0nRCHyAGoZgRNY1aiaGOiPU0aob3jGYQST1eKNiEpVGDLkhNpvgNLiqA" +
       "CO6iNnjXjILpvVuYlcR7xUIIdcAHJeCzHck/8c3Qg6mSWSYprGBDM8zUJDW5" +
       "/XYKECcPvi2l8pD1synbdCikYMqkxRSGPCgRd+Ek1ApYmORJZf1/xVW49hvn" +
       "IxFw7I5wWetQEUdNXSU0p1x2hkdvvJp7X6YMT3PXbggXnJCUJyTFCUn3BBSJ" +
       "CMGb+EkyWuDrWahagM32welHjp2+0B+DNLHmG8BRnLW/pn2M+KXt4XFOeS3R" +
       "sbj72sG3o6ghgxJYYQ7WeTc4QouAM8qsW4rteWgsPr7vCuA7b0zUVIgK8LIW" +
       "zrtSWsw5QjmdoU0BCV734XWWWhv7V9UfrVyZP3/y63dGUbQW0vmRjYBGfPsk" +
       "B+Iq4A6ES3k1ufEnP/nstWcfM/2irukRXmur28lt6A+HPuyenLJ/F34j9+Zj" +
       "A8LtrQC6DEORAJ71hc+owYwhD3+5LS1gcMGkZazzJc/HbaxEzXmfInKymz82" +
       "y/TkKRRSUED3l6et53/ziz99QXjSQ/l4oD1PEzYUQBYuLCEwpNvPyBOUEOD7" +
       "+Mrkt565/uSMSEfg2LPagQP8OQKIAtEBD37z3bMf/f7a8tWon8IMWquThwml" +
       "ImzZ9B/4i8Dn3/zD0YATJCokRlxo2lXFJoufvM/XDVBKh9LmyTHwkAFpqBU0" +
       "nNcJr59/xvcefOOvT3fJcOtA8bLlwK0F+PTbhtG590/9o0+IiSi8S/r+89kk" +
       "9G70JR+hFC9wPSrnP+z99jv4eQBxAE5bWyQCC5HwBxIBPCR8cad43hVa+xJ/" +
       "7LWDOV5bRoFpJqdcvPppx8lP37ohtK0dh4JxH8fWkMwiGQUPireHsZmv9lj8" +
       "uaUCOmwJA9VRbJdA2F0rE1/t0lduwrFZOFYBWLWPU8DFSk0qudyNzb/9yds9" +
       "pz+IoegYatNNrI5hUXCoFTKd2CWA1Ir1lfukHvMt8OgS/kB1Hqoj8CjsXD2+" +
       "o2WLiYgs/nDL9w+/uHRNpKUlZWwPCtwnnoP8cUDQo/z1DgY1pBlYr1SdJv7a" +
       "13FarWyKeteaOcS8tPzE5SX1+AsH5WSQqO3jozCmvvKrf/0seeUP763SZFqZ" +
       "ad2hkzmiB87kHaO3pmOMi3HMR62POy/98UcDxeHP0yw4re8W7YD/3glG7F8b" +
       "/MOqvPPEn7eduLd0+nPg/s6QO8Mivzv+8nsP7FMuRcXsKSG/bmat3TQUdCwc" +
       "SgkM2QY3k1M6RNXsqSbAbTywe+Az6ibAaLhqJECvm1VNthj//bQS6dK9jtR1" +
       "8OLhddZm+GOKobYiYe4IIvi2wqVN1AwfyJNyIBcLd/PHtFTs8P9YkJwwbFUY" +
       "anaP5CW6te6GJKd65dWleMuWpYd+LfKxOnm3Q2YVHF0PBCYYpCaLkoImTGyX" +
       "sGaJLxhKusKzFxSx+BaKqpKvBC7x+SAg8iXIAvtiwMJfdWsVp8mRvRKpB5O7" +
       "ZaO+hQ8DGLGnpmTEjdNLb0feOWHGWzo28eiNL74gOzvcVRcXxQ0FLlxyfqiW" +
       "yO41pXmymo4O3ux8vXVv1M2SmskiqJuIJICK6MLbQq3OHqh2vI+WD7/18wtN" +
       "HwJKzaAIZmjjTOC+Jz0F/dIBbJrJ+OgU+I+F6MFDg99ZuPdA4W+/EzjtotmO" +
       "tflzytUXH/nlpa3L0Ks3pFEjACqpZOHyat+/YEwRZY5mUYdmj1ZARZACt+k0" +
       "anEM7axD0nBP7uTJhnnqC7+47uyoUvnIx1B/3aVzlUEZeto8ocOmY6gCNADO" +
       "fErNVdhDGceyQht8SjWUm+ptzyn3PxX/8cVEbAwKpsacoPhm28lXESx4O/Yh" +
       "rYs/khU5ecVymXHL8iYx1GnJjH9c8nA6Q5H9LpUXe0R2G/7zvBB3Trzyxzf+" +
       "C0rOSkn4EgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Ls3rYxntdAYqXkhr+kiaz8mq1Jw5iUKjfZpcdbhSj02XZhj0NyucW3poq5V0" +
       "WyqJxkRBXi9RrUA2Z10abw8HrE6yQ7G3lDRxpo4HZkNYtMiCKq7npUiWRtIo" +
       "WXCT6qCrVqi4P9ACrTuYNqKWg/XCvkkRyij0BK9THlNYGeGFeWoTc8uiZyHq" +
       "ia4RI42hWjCHk96iT5tNzm+owDjd0kKq19JKV/b6LIlxrBgbndImSl20A9uq" +
       "YQ836ggmKu683mpTk6G94vQOnMikmrhpNPJCMVXLGLkKR6lYVIQasIi0Qbar" +
       "S5OpyBGljim3WtV4d2xRiKXQxR7pC8Me6vfTSoEuqhPUHeCddYP0JrNBTy4o" +
       "lkJyFi+iiqeW5qTcF4YFg+5ZhD8iW8zC7PmrWY+xlg2cq1o9dz6edxl/NYpl" +
       "WxvUUrHb1bVGhzLwTUdbIJhW6s+qjiAJsh+QzRaLbUSqJVWQsUwTuMavrKKN" +
       "+a1CuHZVHbcWMrtcpAOB5PHZQIeJRaHhyw43oCbTApKOpHLdXLndtJ3UupVE" +
       "MqI+Ieq9sSCifiEtmgt9taL82rgqs8MSP1Zns7FL4SK1HrZx0S01mwKFs6QK" +
       "yK6luBVIiqnM2FIxMezO3C/CaBNu9ZiOQ2LNgctIiO8WWZgeR+VxmzOE0iBU" +
       "57ViSJa86sycpZQs92uSMdTKfS9usNgylMpBZEizkA9qKzxu1FR0I466Mxpj" +
       "utImiAQpTCr9uaN7ItrER7VSeSxJkrmqjeriNBitJ3wJWVdLOimqfQldOYO5" +
       "3CSnfLhowt1luVElhNKiEE8Jl0dA4iBpUxYpWkG8GIydOChidlRtwB0+Xhsu" +
       "QyHtUnlehyfzBsZEQR+vtghu0KBqBVODvUROzFYJrjBCYaax5GKibDaUhnRU" +
       "JSU2Y2fadem1s8GKa2S4oAcDQSRaJbtqRJUSsrE29Xp/PBf6iF32WgWe2Mhi" +
       "vynHDE4kfm/Fr5ucSHCtGswGi6hSrSCxwArEdFZkeGXW5zGuT3cbEdFslWqb" +
       "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" +
       "2LAdAAA=");
}
