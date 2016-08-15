package org.apache.batik.svggen.font.table;
public class Ligature {
    private int ligGlyph;
    private int compCount;
    private int[] components;
    public Ligature(java.io.RandomAccessFile raf) throws java.io.IOException {
        super(
          );
        ligGlyph =
          raf.
            readUnsignedShort(
              );
        compCount =
          raf.
            readUnsignedShort(
              );
        components =
          (new int[compCount -
                     1]);
        for (int i =
               0;
             i <
               compCount -
               1;
             i++) {
            components[i] =
              raf.
                readUnsignedShort(
                  );
        }
    }
    public int getGlyphCount() { return compCount; }
    public int getGlyphId(int i) { return i == 0 ? ligGlyph : components[i -
                                                                           1];
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVZC2wUxxken41t/MAP3g+bl0nE6y6koRUyJQHHBqdnsDA4" +
                                                              "qiGYvb25u4W93WV3zj5DaR5ShVO1lKTk0SqxWpUUighEKFFb5UUbhRBBI4XQ" +
                                                              "pmkUSB9qaSkqqGpaNW3T/5/ZvX3cA6E2J+3c3Oz/z/z/P////f/MHbtKxlkm" +
                                                              "aaUaC7MRg1rhTo31SqZF4x2qZFmbYGxQfqJc+uu2y+tXhEjlAJmQkqweWbJo" +
                                                              "l0LVuDVAWhTNYpImU2s9pXHk6DWpRc0hiSm6NkAmK1Z32lAVWWE9epwiQb9k" +
                                                              "RkmTxJipxDKMdtsTMNISBUkiXJLI6uDr9iipk3VjxCWf5iHv8LxByrS7lsVI" +
                                                              "Y3SHNCRFMkxRI1HFYu1Zkyw2dHUkqeosTLMsvENdbpvgnujyPBPMe67ho48P" +
                                                              "pBq5CSZKmqYzrp61kVq6OkTjUdLgjnaqNG3tIl8m5VFS6yFmpC3qLBqBRSOw" +
                                                              "qKOtSwXS11Mtk+7QuTrMmanSkFEgRub6JzEkU0rb0/RymWGGambrzplB2zk5" +
                                                              "bYWWeSo+tjhy8IltjSfLScMAaVC0PhRHBiEYLDIABqXpGDWt1fE4jQ+QJg02" +
                                                              "u4+aiqQqu+2dbraUpCaxDGy/YxYczBjU5Gu6toJ9BN3MjMx0M6degjuU/Wtc" +
                                                              "QpWSoOsUV1ehYReOg4I1CghmJiTwO5ulYqeixRmZHeTI6dj2BSAA1qo0ZSk9" +
                                                              "t1SFJsEAaRYuokpaMtIHrqclgXScDg5oMjKj6KRoa0OSd0pJOogeGaDrFa+A" +
                                                              "ajw3BLIwMjlIxmeCXZoR2CXP/lxdv3L/Hm2dFiJlIHOcyirKXwtMrQGmjTRB" +
                                                              "TQpxIBjrFkUfl6a8PBoiBIgnB4gFzQ+/dP2uJa2nzgiamQVoNsR2UJkNyodi" +
                                                              "E96e1bFwRTmKUW3oloKb79OcR1mv/aY9awDCTMnNiC/DzstTG09/8YGj9EqI" +
                                                              "1HSTSllXM2nwoyZZTxuKSs21VKOmxGi8m4ynWryDv+8mVdCPKhoVoxsSCYuy" +
                                                              "blKh8qFKnf8GEyVgCjRRDfQVLaE7fUNiKd7PGoSQKnhIHTwtRHz4NyPbIik9" +
                                                              "TSOSLGmKpkd6TR31tyKAODGwbSoSA6/fGbH0jAkuGNHNZEQCP0hR58VQMkm1" +
                                                              "SEJHhJJiKgXcSfLgCKOfGZ/6ClnUceJwWRmYf1Yw+FWIm3W6GqfmoHwws6bz" +
                                                              "+vHBs8KxMBhs6zCyGBYNi0XDfNGwWDSMi4b5omFnUVJWxteahIuLbYZN2gnh" +
                                                              "Dnhbt7Dvvnu2j84rB/8yhivAwkg6z5d3OlxMcIB8UD7RXL977sVlr4VIRZQ0" +
                                                              "SzLLSCqmkdVmEgBK3mnHcF0MMpKbGOZ4EgNmNFOXaRxkLJYg7Fmq9SFq4jgj" +
                                                              "kzwzOGkLAzRSPGkUlJ+cenL4wf77bwuRkD8X4JLjAMaQvRcRPIfUbUEMKDRv" +
                                                              "w77LH514fK/uooEvuTg5MY8TdZgX9IageQblRXOkFwZf3tvGzT4e0JpJEF0A" +
                                                              "hK3BNXxg0+4AN+pSDQondDMtqfjKsXENS5n6sDvC3bSJ9yeBW9Ri9E2Ep80O" +
                                                              "R/6Nb6cY2E4Vbo1+FtCCJ4bP9xlP//KtP36Gm9vJIQ2e5N9HWbsHt3CyZo5Q" +
                                                              "Ta7bbjIpBboPnuz95mNX923hPgsU8wst2IZtB+AVbCGY+Stndr136eKhCyHX" +
                                                              "zxkk7kwM6p9sTkkcJzUllITVbnHlAdxTARnQa9o2a+CfSkLB0MPA+lfDgmUv" +
                                                              "/Hl/o/ADFUYcN1py4wnc8elryANnt/29lU9TJmPedW3mkgkwn+jOvNo0pRGU" +
                                                              "I/vg+ZZvvSE9DWkBoNhSdlOOrmV2rKNQ0yBJcE5FD2+UtLieXi0DsFldgNN8" +
                                                              "V5dzstt4e0c+80SHuXtDZ1amBgrE+VZgs8DyRo4/OD3F1aB84MK1+v5rr1zn" +
                                                              "qvqrM6+j9EhGu/BNbG7JwvRTg8i2TrJSQHfHqfVbG9VTH8OMAzAjV2qDCdia" +
                                                              "9bmVTT2u6lc/eW3K9rfLSaiL1Ki6FO+SeISS8RAa1EoBLGeNO+8SnjFcDU0j" +
                                                              "9rIkZxjCDUOyeQO4O7ML73tn2mB8p3b/aOrzKw+PXeQuaog5ZnL+cswUPkjm" +
                                                              "Nb6LCkff+dzPDz/y+LCoEhYWh8IA37R/blBjD/3mH3km5yBYoIIJ8A9Ejj01" +
                                                              "o2PVFc7vohFyt2Xzsxsgust7+9H030LzKl8PkaoB0ijbNXW/pGYwxgegjrSc" +
                                                              "Qhvqbt97f00oCqD2HNrOCiKhZ9kgDrpZFfpIjf36APRhEUKmwzPbRoXZQegr" +
                                                              "I7zTw1lu5e0ibJY6SFNlmAqcu2gAampLTMpItaok16ojRsqfkTHr9WViFmRP" +
                                                              "JQ1gOWSXk7f3bpdH23p/J5xgegEGQTf5SOTr/e/uOMehuBrz8yZHcU/2hTzu" +
                                                              "yQONQu5P4FMGz3/wQXlxQJRlzR12bTgnVxyiE5f0xoACkb3Nl3Y+dflZoUDQ" +
                                                              "9QLEdPTgVz8J7z8o8FWcMObnFfleHnHKEOpgcy9KN7fUKpyj6w8n9r54ZO8+" +
                                                              "IVWzv17uhOPgs7/497nwkx++WaBMK1fsU6IXNSFD+vdGKHT3ww0vHWgu74LM" +
                                                              "3k2qM5qyK0O7434XrbIyMc9muScX121t1XBjGClbBHsg8jK2K7FZL3zwzqJA" +
                                                              "ttbv+DPgmWP76Jwiji9c5VZsevM9vBg3Q8hIGx16RuPJsT8gaeomJcUDwlx7" +
                                                              "rblFJNVKSlqMm5EalFTXYOMs/71MLrh4xhVbubX29KvW935/UrhModANnASP" +
                                                              "HK6W30+f5qGLC27OiTYBJWmCx7aB+GZky/94RsH7CWmYRZJUT8NZmKWgrE6y" +
                                                              "lHME+jSnx7BbUBwUPHYc+/78t+4fm/9rnr+rFQuAHGCpwGncw3Pt2KUr5+tb" +
                                                              "jvMCuQLRzQ4W/zVG/i2F7/KB70IDNkO821+w9lkrCGzX2lsY/UPYDTPIO4om" +
                                                              "qXy2e6H0VLlB8NdWbPYYbtEQEnz+8gpTXbhDBRfEAtF5N8kpvXI3PvAyWwBy" +
                                                              "WnzlQw9X1c3FH0x49Lc/bkuuuZnDHI613uC4hr9nw34tKr7dQVHeeOhPMzat" +
                                                              "Sm2/iXPZ7IA3BKf8Qc+xN9feIj8a4pdKokjIu4zyM7X7cbfGpHCS1vxIO991" +
                                                              "jz0uqizmGxwomJ0yEH9/o8S7R7D5GviKjBst/KIE+cH8OhMHOg1PSWq7AP6U" +
                                                              "g6lALwGwWY9KOTTin0oSuJPxAKWnaCUY5y3Frs14aj300MGx+IZnljmwtw0y" +
                                                              "AtONpSodoqpnKhEKozkxGnD6WfAstcVYGkR7V9GABrkTXjHWEuZ+psS7w9h8" +
                                                              "h5H6JGW8ZnOzmmvv794ooZU+Q4i9LWQLLE6X2Qotu3lbFGMtfOzjSvFZT5Yw" +
                                                              "yPPYPAuJ0zFIdzxgjeP/D2tkoUx2LrrwkDUt7zZd3ADLx8caqqeObX5X5AXn" +
                                                              "lrYOwCqRUVXvMcDTrzRMmlC4PnXiUCDKqZcYmXfjGziIY5YD6xcF56twPinF" +
                                                              "yUgFfnlZfsrI1CIskEdEx0v/OiONQXoQhX976c7A5rh0MJXoeEnOQgkLJNg9" +
                                                              "Zzg5p9HNR+LolS3zh31uhyffaIc9SDHflyL4XycOnGfEnyeD8omxe9bvuf7Z" +
                                                              "Z8QlkqxKu3fjLLWQvMV9Vi4lzC06mzNX5bqFH094bvwCB3uahMBusMz0OHMn" +
                                                              "uL2B7jUjcMNiteUuWt47tPKVn41WnodiZQspkyBvb8k/pGaNDIDilmj+AQDS" +
                                                              "J7/6aV/47ZFVSxJ/eZ9fAxCRvWcVpx+ULxy+751Hpx1qDZHabjIOYJVm+en5" +
                                                              "7hFtI5WHzAFSr1idWRARZoEiwXe6mICRIOGfKtwutjnrc6N4BQnOnn+wyr+4" +
                                                              "rVH1YWquAdzjkQ4lV6074vtPx8mqGcMIMLgjnjosxlNqFncD/HEw2mMYzrmz" +
                                                              "dpPBgUAunu8u8S42H/4XB4So81YdAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
