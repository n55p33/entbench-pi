package org.apache.batik.svggen.font.table;
public class Device {
    private int startSize;
    private int endSize;
    private int deltaFormat;
    private int[] deltaValues;
    public Device(java.io.RandomAccessFile raf) throws java.io.IOException {
        super(
          );
        startSize =
          raf.
            readUnsignedShort(
              );
        endSize =
          raf.
            readUnsignedShort(
              );
        deltaFormat =
          raf.
            readUnsignedShort(
              );
        int size =
          startSize -
          endSize;
        switch (deltaFormat) {
            case 1:
                size =
                  size %
                    8 ==
                    0
                    ? size /
                    8
                    : size /
                    8 +
                    1;
                break;
            case 2:
                size =
                  size %
                    4 ==
                    0
                    ? size /
                    4
                    : size /
                    4 +
                    1;
                break;
            case 3:
                size =
                  size %
                    2 ==
                    0
                    ? size /
                    2
                    : size /
                    2 +
                    1;
                break;
        }
        deltaValues =
          (new int[size]);
        for (int i =
               0;
             i <
               size;
             i++) {
            deltaValues[i] =
              raf.
                readUnsignedShort(
                  );
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVZfWwUxxUfn41t/IE/+AzBBoxJZCB3IU1aIdMkYGxwegYL" +
                                                              "g6Magpnbm7tbvLe72Z2zD1KaBDUKrVSUJoTQNvE/JYVEJESoqInapFRRSaJ8" +
                                                              "SCG0aRoF+qWWNo0aVDWtStv0vZnd24+7M0JVLO3c7Ox7b96bee/33oyPf0Sm" +
                                                              "2RZpZzqP8t0ms6O9Oh+kls2SPRq17S0wNqo8Vkn/tuPixlURUj1CZmSoPaBQ" +
                                                              "m/WpTEvaI6RN1W1OdYXZGxlLIsegxWxmjVOuGvoIma3a/VlTUxWVDxhJhgTD" +
                                                              "1IqTFsq5pSZynPU7Ajhpi4MmMaFJbE34c3ecNCiGudsjn+cj7/F9QcqsN5fN" +
                                                              "SXN8Fx2nsRxXtVhctXl33iLLTUPbndYMHmV5Ht2l3eIswR3xW4qWoOO5pk8u" +
                                                              "P5RpFkswk+q6wYV59mZmG9o4S8ZJkzfaq7GsfTf5KqmMk3ofMSedcXfSGEwa" +
                                                              "g0ldaz0q0L6R6blsjyHM4a6kalNBhThZHBRiUotmHTGDQmeQUMsd2wUzWLuo" +
                                                              "YK20ssjER5fHDj62o/lkJWkaIU2qPoTqKKAEh0lGYEFZNsEse00yyZIjpEWH" +
                                                              "zR5ilko1dY+z0622mtYpz8H2u8uCgzmTWWJOb61gH8E2K6dwwyqYlxIO5bxN" +
                                                              "S2k0DbbO8WyVFvbhOBhYp4JiVoqC3zksVWOqnuRkYZijYGPnl4AAWGuyjGeM" +
                                                              "wlRVOoUB0ipdRKN6OjYErqengXSaAQ5ocTK/rFBca5MqYzTNRtEjQ3SD8hNQ" +
                                                              "TRcLgSyczA6TCUmwS/NDu+Tbn482rj5wj75Bj5AK0DnJFA31rwem9hDTZpZi" +
                                                              "FoM4kIwNy+KH6JwX90cIAeLZIWJJ88OvXLp9RfvpVyXNtSVoNiV2MYWPKkcS" +
                                                              "M95e0NO1qhLVqDUNW8XND1guomzQ+dKdNwFh5hQk4seo+/H05jNfvu9p9mGE" +
                                                              "1PWTasXQclnwoxbFyJqqxqz1TGcW5SzZT6YzPdkjvveTGujHVZ3J0U2plM14" +
                                                              "P6nSxFC1Id5hiVIgApeoDvqqnjLcvkl5RvTzJiGkBh7SAE8bkX/il5PtsYyR" +
                                                              "ZTGqUF3VjdigZaD9dgwQJwFrm4klwOvHYraRs8AFY4aVjlHwgwxzP4yn00yP" +
                                                              "pQxEKJrQWGwdG1cVFkUvMz9j+Xm0b+ZERQUs/YJw4GsQMxsMLcmsUeVgbm3v" +
                                                              "pWdHX5dOhYHgrAwnXTBlVE4ZFVNG5ZRRnDIqpozKKUlFhZhpFk4tNxi2ZwwC" +
                                                              "HZC2oWvorjt27u+oBM8yJ6pgbZG0I5Bxejw0cCF8VDnR2rhn8fmVL0dIVZy0" +
                                                              "UoXnqIYJZI2VBmhSxpzobUhALvJSwiJfSsBcZhkKSwIilUsNjpRaY5xZOM7J" +
                                                              "LJ8EN2FhaMbKp4uS+pPThyfuH773xgiJBLMATjkNAAzZBxG7CxjdGY7+UnKb" +
                                                              "Hrz4yYlDew0PBwJpxc2GRZxoQ0fYF8LLM6osW0RPjb64t1Ms+3TAaU4hrgAC" +
                                                              "28NzBGCm24VstKUWDE4ZVpZq+Mld4zqesYwJb0Q4aYvozwK3qMe4a4FnqROI" +
                                                              "4he/zjGxnSudGv0sZIVICV8cMp/45Vt/+pxYbjd7NPnS/hDj3T7EQmGtApta" +
                                                              "PLfdYjEGdB8cHnzk0Y8e3CZ8FiiWlJqwE9seQCrYQljmB169+70L54+ci3h+" +
                                                              "ziFl5xJQ+eQLRuI4qZvCSJjtOk8fQDwNUAG9pnOrDv6pplQMPAysfzctXXnq" +
                                                              "LweapR9oMOK60YorC/DGr1lL7nt9xz/ahZgKBTOut2YemYTxmZ7kNZZFd6Me" +
                                                              "+fvPtn37FfoEJAQAYVvdwwSuVjixjkrNg/QgOFUjupnqSSO7RgFQs/sAocWu" +
                                                              "3iLIbhTtzcXMM13m/k29eYWZqJDgW4XNUtsfOcHg9JVVo8pD5z5uHP74pUvC" +
                                                              "1GBd5neUAWp2S9/E5ro8iJ8bRrYN1M4A3c2nN25v1k5fBokjIFEYtckCZM0H" +
                                                              "3Mqhnlbzq5++PGfn25Uk0kfqNIMm+6iIUDIdQoPZGQDlvHnb7dIzJmqhacZe" +
                                                              "nhQWhoiFIfmiAdydhaX3vTdrcrFTe56f+4PVRyfPCxc1pYxrBX8V5okAJIvq" +
                                                              "3kOFp9/5ws+PfuvQhKwPuspDYYhv3r82aYl9v/1n0ZILECxRu4T4R2LHH5/f" +
                                                              "c+uHgt9DI+TuzBfnNkB0j/emp7N/j3RU/yxCakZIs+JU08NUy2GMj0AFabsl" +
                                                              "NlTcge/BalCWPt0FtF0QRkLftGEc9HIq9JEa+40h6MPyg8yHZ6GDCgvD0FdB" +
                                                              "RGdAsFwv2mXY3OAiTY1pqXDiYiGoqZ9CKIeSlFOLD0HIBlMypr2hXMKG9Klm" +
                                                              "AS3HnUrypsGdyv7Owd9LL7imBIOkm30s9s3hd3e9IbC4FhP0FtdyX/qFRO5L" +
                                                              "BM1S8U/hrwKe/+KDCuOArMhae5yycFGhLkQvntIdQwbE9rZeGHv84jPSgLDv" +
                                                              "hYjZ/oPf+DR64KAEWHm4WFJU3/t55AFDmoPNnajd4qlmERx9fzyx90fH9j4o" +
                                                              "tWoNlsq9cBJ85hf/eSN6+NevlajSKlXngOiHTUiRwb2RBq37etOPH2qt7IPU" +
                                                              "3k9qc7p6d471J4M+WmPnEr7N8g4tnt86puHGcFKxDPZAJmZsV2OzUTrhbWWR" +
                                                              "bH3Q8+fBs8hx0kVlPF+6yvXYDBa7eDluLs4K6OD4OhzSM3OVei6AZ7Ez0+Iy" +
                                                              "eupT6lmOm5P6JNM47cOiiZfS1bhKXdvh6XBm6yija25KXctxu7oKoLSDt0cF" +
                                                              "HBDVgfS67fVnfmJ/7w8npXeXQpnQefXY0Vrl/ewZgTI449aCbjNQFSwRnUWQ" +
                                                              "v5xs+z/PUniLQid4LM2MLJzYeQaOAGmecY9qn6V4RIil5fHLt46T31/y1r2T" +
                                                              "S34jao1a1YakAwha4s7Ax/Px8Qsfnm1se1YU81UIxE5cBy9biu9SAlckYhea" +
                                                              "sNkrusMl67T1ksDxra+VzlQR7EY55EhVp5qQdieUyZpYEHzbjs0+0ytwIpIv" +
                                                              "WApiWo72aIbOsJh1v81yy8TCvRR8zJdAx7ZAqTMgTPXqhg9mPPy7FzrTa6/m" +
                                                              "4Ilj7Vc4WuL7QtivZeW3O6zKK/v+PH/LrZmdV3GGXBjyhrDIpwaOv7b+OuXh" +
                                                              "iLj6kgVN0ZVZkKk7mCLqLMZzlh5MCks899jnwcpyscGh4t4tWfH90BTfDmPz" +
                                                              "CPiKghst/WIK8u8W18Q40Gv6ymfHBfBVCWet8SkQNu8zqYBG4q+ahG6OfEjp" +
                                                              "K7AJxnlbucs9UQUc2XdwMrnpyZUu7O2A+owb5g0aG2daQBQEjLx4waJ/XtG9" +
                                                              "rryLVJ6dbKqdO7n1XRn77n1hAzhkKqdp/rLU1682LZZSxfwNskiV2f0pTjqu" +
                                                              "fB8Ee8ULAXlMch6HenkqTk6q8MfPcoKTuWVYwHTZ8dOf5KQ5TA+qiF8/3SlO" +
                                                              "6jw6ECU7fpLnoaICEuy+YLq40uxhjjwK5CuCW1vwodlXytI+b1gSgAFxie+G" +
                                                              "bE5e448qJybv2HjPpc8/KS81FI3u2YNS6gGg5f1KIewXl5Xmyqre0HV5xnPT" +
                                                              "l7r+1SIV9qLgWl8w9UKUmOhe80MnfruzcPB/78jql97cX30WEtI2UkEBm7cV" +
                                                              "H5ryZg4cf1u8uB4FiBRXEd1d39l964rUX98Xx1IHoReUpx9Vzh29652H5x1p" +
                                                              "j5D6fjINQoflxWlu3W59M1PGrRHSqNq9eVARpEAiCBS7MzASKF7vi3VxlrOx" +
                                                              "MIpXYuDsxXV+8UUiHOEnmLXWyOlJJ63WeyOB/y64yJkzzRCDN+LLtQkBm3lZ" +
                                                              "3FSOxgdM0z0G1febAlyU8pj2huhi8+b/AM4bfQLgGwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "lv0v1ZnyItsmAAA=");
}
