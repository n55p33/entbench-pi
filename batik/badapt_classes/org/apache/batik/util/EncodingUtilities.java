package org.apache.batik.util;
public class EncodingUtilities {
    protected static final java.util.Map ENCODINGS = new java.util.HashMap(
      );
    static { ENCODINGS.put("UTF-8", "UTF8");
             ENCODINGS.put("UTF-16", "Unicode");
             ENCODINGS.put("US-ASCII", "ASCII");
             ENCODINGS.put("ISO-8859-1", "8859_1");
             ENCODINGS.put("ISO-8859-2", "8859_2");
             ENCODINGS.put("ISO-8859-3", "8859_3");
             ENCODINGS.put("ISO-8859-4", "8859_4");
             ENCODINGS.put("ISO-8859-5", "8859_5");
             ENCODINGS.put("ISO-8859-6", "8859_6");
             ENCODINGS.put("ISO-8859-7", "8859_7");
             ENCODINGS.put("ISO-8859-8", "8859_8");
             ENCODINGS.put("ISO-8859-9", "8859_9");
             ENCODINGS.put("ISO-2022-JP", "JIS");
             ENCODINGS.put("WINDOWS-31J", "MS932");
             ENCODINGS.put("EUC-JP", "EUCJIS");
             ENCODINGS.put("GB2312", "GB2312");
             ENCODINGS.put("BIG5", "Big5");
             ENCODINGS.put("EUC-KR", "KSC5601");
             ENCODINGS.put("ISO-2022-KR", "ISO2022KR");
             ENCODINGS.put("KOI8-R", "KOI8_R");
             ENCODINGS.put("EBCDIC-CP-US", "Cp037");
             ENCODINGS.put("EBCDIC-CP-CA", "Cp037");
             ENCODINGS.put("EBCDIC-CP-NL", "Cp037");
             ENCODINGS.put("EBCDIC-CP-WT", "Cp037");
             ENCODINGS.put("EBCDIC-CP-DK", "Cp277");
             ENCODINGS.put("EBCDIC-CP-NO", "Cp277");
             ENCODINGS.put("EBCDIC-CP-FI", "Cp278");
             ENCODINGS.put("EBCDIC-CP-SE", "Cp278");
             ENCODINGS.put("EBCDIC-CP-IT", "Cp280");
             ENCODINGS.put("EBCDIC-CP-ES", "Cp284");
             ENCODINGS.put("EBCDIC-CP-GB", "Cp285");
             ENCODINGS.put("EBCDIC-CP-FR", "Cp297");
             ENCODINGS.put("EBCDIC-CP-AR1", "Cp420");
             ENCODINGS.put("EBCDIC-CP-HE", "Cp424");
             ENCODINGS.put("EBCDIC-CP-BE", "Cp500");
             ENCODINGS.put("EBCDIC-CP-CH", "Cp500");
             ENCODINGS.put("EBCDIC-CP-ROECE", "Cp870");
             ENCODINGS.put("EBCDIC-CP-YU", "Cp870");
             ENCODINGS.put("EBCDIC-CP-IS", "Cp871");
             ENCODINGS.put("EBCDIC-CP-AR2", "Cp918");
             ENCODINGS.put("CP1252", "Cp1252"); }
    protected EncodingUtilities() { super(); }
    public static java.lang.String javaEncoding(java.lang.String encoding) {
        return (java.lang.String)
                 ENCODINGS.
                 get(
                   encoding.
                     toUpperCase(
                       ));
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVYe2wUxxmfO7+NH2eDDRhswBgQj/hCG5pQExpjDBw9P4rB" +
                                                              "VY/HMbc351u8t7vsztpnJ7QJUgVVVUQoIbQq/AUhpTREVaM2bRO5ipqHklYi" +
                                                              "oU3TKBQ1/SNpihIUJa1KX9/M7N0+7mwaVbG0c+PZb76Z75vf9/u+2Us3UJlp" +
                                                              "oDai0k46oROzs1elg9gwSbJHwaa5E8bi0qMl+MN97/SvD6LyGKpLY7NPwibZ" +
                                                              "IhMlacZQq6yaFKsSMfsJSbIZgwYxiTGGqaypMdQkm5GMrsiSTPu0JGECw9iI" +
                                                              "ogZMqSEnLEoitgKKWqOwkzDfSbjb/7orimokTZ9wxOe5xHtcb5hkxlnLpCgU" +
                                                              "PYDHcNiishKOyibtyhpota4pEyOKRjtJlnYeUNbZLtgeXVfggvYn6z++dTwd" +
                                                              "4i6YjVVVo9w8cwcxNWWMJKOo3hntVUjGPIi+ikqiaJZLmKKOaG7RMCwahkVz" +
                                                              "1jpSsPtaolqZHo2bQ3OaynWJbYiiJV4lOjZwxlYzyPcMGiqpbTufDNYuzlsr" +
                                                              "rCww8ZHV4ZOP7gv9qATVx1C9rA6x7UiwCQqLxMChJJMghtmdTJJkDDWocNhD" +
                                                              "xJCxIk/aJ91oyiMqphYcf84tbNDSicHXdHwF5wi2GZZENSNvXooDyv6vLKXg" +
                                                              "EbC12bFVWLiFjYOB1TJszEhhwJ09pXRUVpMULfLPyNvY8UUQgKkVGULTWn6p" +
                                                              "UhXDAGoUEFGwOhIeAuipIyBapgEADYpaplXKfK1jaRSPkDhDpE9uULwCqSru" +
                                                              "CDaFoia/GNcEp9TiOyXX+dzo33DsfnWbGkQB2HOSSArb/yyY1OabtIOkiEEg" +
                                                              "DsTEmlXRU7j5maNBhEC4yScsZH7ywM371rRNvShkFhSRGUgcIBKNS+cSdVcW" +
                                                              "9qxcX8K2UalrpswO32M5j7JB+01XVgeGac5rZC87cy+ndjz/lQcvkveCqDqC" +
                                                              "yiVNsTKAowZJy+iyQoytRCUGpiQZQVVETfbw9xFUAf2orBIxOpBKmYRGUKnC" +
                                                              "h8o1/j+4KAUqmIuqoS+rKS3X1zFN835WRwhVwINq4GlD4o//UhQLp7UMCWMJ" +
                                                              "q7KqhQcNjdlvhoFxEuDbdDgBqB8Nm5plAATDmjESxoCDNLFfcCf0qpKWBCTt" +
                                                              "gn/AYHAlw5j+qWrPMttmjwcC4PaF/qBXIF62aUqSGHHppLWp9+YT8ZcFoFgQ" +
                                                              "2F6haAUs2CkW7OQLimMrWBAFAnydOWxhIQMHMwohDhxbs3Jo7/b9R9tLAFP6" +
                                                              "eCl4lYm2e3JNj8MDOfKOS5cbayeXXFv7XBCVRlEjlqiFFZY6uo0RICVp1I7b" +
                                                              "mgRkIScZLHYlA5bFDE0iSeCi6ZKCraVSGyMGG6dojktDLlWxoAxPnyiK7h9N" +
                                                              "nR5/aPhrdwZR0Mv/bMkyoC42fZCxdp6dO/xxX0xv/ZF3Pr586pDmMIAnoeTy" +
                                                              "YMFMZkO7Hwl+98SlVYvxU/FnDnVwt1cBQ1MMEQXk1+Zfw0MwXTmyZrZUgsEp" +
                                                              "zchghb3K+biapg1t3BnhEG3g/TkAizoWcYvg+bIdgvyXvW3WWTtXQJrhzGcF" +
                                                              "Twb3Dulnfv+bdz/L3Z3LG/WuhD9EaJeLq5iyRs5KDQ5sdxqEgNxbpwe//ciN" +
                                                              "I7s5ZkFiabEFO1jbAxwFRwhu/vqLB9/447VzV4MOzimq0g2NQkiTZDZvJ3uF" +
                                                              "amewExZc7mwJ6E4BDQw4HbtUgKicknFCISy2/lm/bO1Tfz0WElBQYCSHpDW3" +
                                                              "V+CMz9+EHnx539/auJqAxNKt4zZHTHD4bEdzt2HgCbaP7EOvtn7nBXwGsgEw" +
                                                              "sClPEk6qiLsB8XNbx+2/k7d3+d7dzZplphv/3hBzlUVx6fjVD2qHP3j2Jt+t" +
                                                              "t65yH3cf1rsEwlizPAvq5/r5aRs20yB311T/npAydQs0xkCjBFxrDhjAjlkP" +
                                                              "OGzpsoo//PK55v1XSlBwC6pWNJzcgnmcoSoAODHTQKxZ/Qv3icMdr4QmxE1F" +
                                                              "BcYXDDAHLyp+dL0ZnXJnT/507o83XDh7jQNNFzoW5Il1oYdYeXXuxPbF1+7+" +
                                                              "7YWHT42L/L5yekLzzZv3jwElcfhPfy9wOaeyIrWHb34sfOl7LT0b3+PzHU5h" +
                                                              "szuyhfkJeNmZ+5mLmY+C7eW/CqKKGApJdjU8jBWLRWoMKkAzVyJDxex5763m" +
                                                              "ROnSlefMhX4+cy3rZzMnL0KfSbN+rY/AFrAjXA/PUjuwl/oJLIB4J8KnrODt" +
                                                              "KtbcwY+vhHU7KSo3ec1NYQuyihUfc7TMsAAQTm9/z8DmSP/WIcBCq4MFlsiG" +
                                                              "rIRJd+BxXk3GpT0rQs0d6z9sF2BoKyLrKjuP/fxnsdiKkCSE24sp9pabj1+o" +
                                                              "lN7MPP9nMWF+kQlCrunx8LeGXz/wCqftSpbLd+bc68rUkPNdOSPkzRkN8Fy3" +
                                                              "PXJdlG17/s/CCqbBXUrOQJUT3ilnSJLd5ZgNduH2qernVOUJY+fQfjCqdL9/" +
                                                              "z2P3CrcumSaCHfmnv3T9ypnJy5dEhmDupWj1dLfPwisvqxmWzVD3OAD5aOvn" +
                                                              "p959e3hv0Ob0OtYMC+zOo6jWITWgUDa4L09+gTx5zfHCRGje/I36XxxvLNkC" +
                                                              "BUkEVVqqfNAikaQ3JitMK+HCjXPJcuLUBs1/4C8Az7/Zw8DCBgRoGnvsC8fi" +
                                                              "/I0D+JW9pyiwCrqi/mDtPazZLqzrKkb12eIhDiVBuW4lFFlyopr/lfuvHu56" +
                                                              "wGF4xLDROt3tkN9szx0+eTY5cH6tQEij98bVq1qZH/7uX690nr7+UpGCv4pq" +
                                                              "+h0KGSOKL6u0euDYxy/ODkW/VXfi7ac7RjZ9kkqdjbXdphZn/y8CI1ZNj0D/" +
                                                              "Vl44/JeWnRvT+z9B0b3I506/yu/3XXpp63LpRJB/JRC5o+DrgndSlxed1Qah" +
                                                              "lqF68bg0D4D57GCXwRO3ARAvXvgWRVSQdQ+wps+XKBpm0OgrxnIRaAdriAcr" +
                                                              "S5qd4hMI38ADM1RwD7JmjKIaNjN3P2Rjh5xwGZ8hXP6HyogNdOtZihoK7p+s" +
                                                              "appX8GFLfIyRnjhbXzn37K7XOTjzH0xqAGYpS1Hced3VL9cNkpK5aTUiy4vo" +
                                                              "P0pRU9FLMUWl7Idv+4iQ/SY40i8LOZ3/uuWOUVTtyAFBiI5b5GGKSkCEdU/o" +
                                                              "RU5JlDbZgJcp8p5vup3nXeSy1BNr/KNiLi6sQTupXD67vf/+m587L65akoIn" +
                                                              "J5mWWcDD4taXj60l02rL6SrftvJW3ZNVy3J5o0Fs2EH8AhfMugGkOjvtFt8l" +
                                                              "xOzI30XeOLfh2V8fLX8V6G03CmCKZu8uLAKzugWktjtamG+Ah/jtqGvldyc2" +
                                                              "rkm9/yYvswuLa798XLp6Ye9rJ+adg1vUrAgqAyYmWV6dbp5QdxBpzIihWtns" +
                                                              "zcIWQYuMFU8yq2PAxCzWuF9sd9bmR9lFnaL2gu+KRT5vwJVknBibNEtN2ulw" +
                                                              "ljPi+dqZoydL130TnBFX2YVZI2VFsiyJR/t0PZc8axp1HqAJP6XwQT77PO+y" +
                                                              "5rH/AhN3TfhwGAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
