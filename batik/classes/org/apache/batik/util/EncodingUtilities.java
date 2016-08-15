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
    public static final long jlc$SourceLastModified$jl7 = 1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVYe2wUxxmfO7/fZ4MNGGzAGBCP+EIbmlATGmMMHD0/isFV" +
                                                              "j8cxtzdnL97bXXZn7bMTWoIUQVUVEUoIrQp/QUgpDVHVqE3bRK6i5qGklUho" +
                                                              "0zQKRU3/SJqiBKVJq9LXNzN7t487m0ZVLO3cePabb+b75vf9vm/20g1UYhqo" +
                                                              "lai0g07oxOzoUekANkyS7Fawae6Asbj0aBH+cO87feuCqDSGakew2Sthk2yW" +
                                                              "iZI0Y6hFVk2KVYmYfYQk2YwBg5jEGMNU1tQYapTNSFpXZEmmvVqSMIEhbERR" +
                                                              "PabUkBMWJRFbAUUtUdhJmO8k3OV/3RlF1ZKmTzjic13i3a43TDLtrGVSFIru" +
                                                              "x2M4bFFZCUdlk3ZmDLRK15SJYUWjHSRDO/Yra20XbIuuzXNB25N1H986PhLi" +
                                                              "LpiFVVWj3DxzOzE1ZYwko6jOGe1RSNo8gL6KiqKoyiVMUXs0u2gYFg3Dollr" +
                                                              "HSnYfQ1RrXS3xs2hWU2lusQ2RNFirxIdGzhtqxngewYN5dS2nU8GaxflrBVW" +
                                                              "5pn4yKrwyUf3hn5YhOpiqE5WB9l2JNgEhUVi4FCSThDD7EomSTKG6lU47EFi" +
                                                              "yFiRJ+2TbjDlYRVTC44/6xY2aOnE4Gs6voJzBNsMS6KakTMvxQFl/1eSUvAw" +
                                                              "2Nrk2Cos3MzGwcBKGTZmpDDgzp5SPCqrSYoW+mfkbGz/IgjA1LI0oSNabqli" +
                                                              "FcMAahAQUbA6HB4E6KnDIFqiAQANipqnVcp8rWNpFA+TOEOkT25AvAKpCu4I" +
                                                              "NoWiRr8Y1wSn1Ow7Jdf53Ohbf+x+dasaRAHYc5JICtt/FUxq9U3aTlLEIBAH" +
                                                              "YmL1yugp3PTM0SBCINzoExYyP37g5n2rW6deFDLzC8j0J/YTicalc4naKwu6" +
                                                              "V6wrYtso1zVTZofvsZxH2YD9pjOjA8M05TSylx3Zl1Pbn//KoYvkvSCqjKBS" +
                                                              "SVOsNOCoXtLSuqwQYwtRiYEpSUZQBVGT3fx9BJVBPyqrRIz2p1ImoRFUrPCh" +
                                                              "Uo3/Dy5KgQrmokroy2pKy/Z1TEd4P6MjhMrgQdXwtCLxx38pioVHtDQJYwmr" +
                                                              "sqqFBwyN2W+GgXES4NuRcAJQPxo2NcsACIY1YziMAQcjxH7BndCjSloSkLQT" +
                                                              "/gGDwZUMY/qnqj3DbJs1HgiA2xf4g16BeNmqKUlixKWT1saem0/EXxaAYkFg" +
                                                              "e4Wi5bBgh1iwgy8oji1vQRQI8HVms4WFDBzMKIQ4cGz1isE92/YdbSsCTOnj" +
                                                              "xeBVJtrmyTXdDg9kyTsuXW6omVx8bc1zQVQcRQ1YohZWWOroMoaBlKRRO26r" +
                                                              "E5CFnGSwyJUMWBYzNIkkgYumSwq2lnJtjBhsnKLZLg3ZVMWCMjx9oii4fzR1" +
                                                              "evzBoa/dGURBL/+zJUuAutj0AcbaOXZu98d9Ib11R975+PKpg5rDAJ6Eks2D" +
                                                              "eTOZDW1+JPjdE5dWLsJPxZ852M7dXgEMTTFEFJBfq38ND8F0Zsma2VIOBqc0" +
                                                              "I40V9irr40o6YmjjzgiHaD3vzwZY1LKIWwjPl+0Q5L/sbZPO2jkC0gxnPit4" +
                                                              "Mrh3UD/zu1+/+1nu7mzeqHMl/EFCO11cxZQ1cFaqd2C7wyAE5N46PfCtR24c" +
                                                              "2cUxCxJLCi3Yztpu4Cg4QnDzQy8eeOMP185dDTo4p6hCNzQKIU2SmZyd7BWq" +
                                                              "mcFOWHCZsyWgOwU0MOC071QBonJKxgmFsNj6Z93SNU/95VhIQEGBkSySVt9e" +
                                                              "gTM+byM69PLev7VyNQGJpVvHbY6Y4PBZjuYuw8ATbB+ZB19t+fYL+AxkA2Bg" +
                                                              "U54knFQRdwPi57aW238nb+/yvbubNUtNN/69IeYqi+LS8asf1Ax98OxNvltv" +
                                                              "XeU+7l6sdwqEsWZZBtTP8fPTVmyOgNxdU327Q8rULdAYA40ScK3ZbwA7Zjzg" +
                                                              "sKVLyn7/i+ea9l0pQsHNqFLRcHIz5nGGKgDgxBwBYs3oX7hPHO54OTQhbirK" +
                                                              "Mz5vgDl4YeGj60nrlDt78idzfrT+wtlrHGi60DE/R6wLPMTKq3Mnti++dvdv" +
                                                              "Ljx8alzk9xXTE5pv3tx/9CuJw3/8e57LOZUVqD1882PhS99t7t7wHp/vcAqb" +
                                                              "3Z7Jz0/Ay87cz1xMfxRsK/1lEJXFUEiyq+EhrFgsUmNQAZrZEhkqZs97bzUn" +
                                                              "SpfOHGcu8POZa1k/mzl5EfpMmvVrfAQ2nx3hOniW2IG9xE9gAcQ7ET5lOW9X" +
                                                              "suYOfnxFrNtBUanJa24KW5BVrPiYo3mGBYBwevq6+zdF+rYMAhZaHCywRDZo" +
                                                              "JUy6HY/zajIu7V4eampf92GbAENrAVlX2XnsZz+NxZaHJCHcVkixt9x8/EK5" +
                                                              "9Gb6+T+JCfMKTBByjY+Hvzn0+v5XOG2Xs1y+I+teV6aGnO/KGSFvzqiH57rt" +
                                                              "keuibNv9fxZWMA3uUnIaqpzwDjlNkuwux2ywC7dPVT+nKk8YO4f2/VGl6/17" +
                                                              "HrtXuHXxNBHsyD/9petXzkxeviQyBHMvRaumu33mX3lZzbB0hrrHAchHWz4/" +
                                                              "9e7bQ3uCNqfXsmZIYHcuRTUOqQGFssG9OfIL5MhrthcmQvOmr9f9/HhD0WYo" +
                                                              "SCKo3FLlAxaJJL0xWWZaCRdunEuWE6c2aP4DfwF4/s0eBhY2IEDT0G1fOBbl" +
                                                              "bhzAr+w9RYGV0BX1B2vvYc02YV1nIarPFA5xKAlKdSuhyJIT1fyv1H/1cNcD" +
                                                              "DsMjho2W6W6H/GZ77vDJs8n+82sEQhq8N64e1Ur/4Lf/eqXj9PWXChT8FVTT" +
                                                              "71DIGFF8WaXFA8defnF2KPqt2hNvP90+vPGTVOpsrPU2tTj7fyEYsXJ6BPq3" +
                                                              "8sLhPzfv2DCy7xMU3Qt97vSr/F7vpZe2LJNOBPlXApE78r4ueCd1etFZaRBq" +
                                                              "GaoXj0tyAJjHDnYpPHEbAPHChW9BRAVZdz9ren2Jon4Gjb5iLBuBdrCGeLCy" +
                                                              "pNkhPoHwDTwwQwV3iDVjFFWzmdn7IRs76ITL+Azh8j9URmygS89QVJ93/2RV" +
                                                              "09y8D1viY4z0xNm68jlnd77OwZn7YFINMEtZiuLO665+qW6QlMxNqxZZXkT/" +
                                                              "UYoaC16KKSpmP3zbR4TsN8CRflnI6fzXLXeMokpHDghCdNwiD1NUBCKse0Iv" +
                                                              "cEqitMkEvEyR83zj7TzvIpclnljjHxWzcWEN2Enl8tltffff/Nx5cdWSFDw5" +
                                                              "ybRUAQ+LW18uthZPqy2rq3Trilu1T1YszeaNerFhB/HzXTDrApDq7LSbfZcQ" +
                                                              "sz13F3nj3Ppnf3W09FWgt10ogCmatSu/CMzoFpDarmh+vgEe4rejzhXfmdiw" +
                                                              "OvX+m7zMzi+u/fJx6eqFPa+dmHsOblFVEVQCTEwyvDrdNKFuJ9KYEUM1stmT" +
                                                              "gS2CFhkrnmRWy4CJWaxxv9jurMmNsos6RW153xULfN6AK8k4MTZqlpq002GV" +
                                                              "M+L52pmlJ0vXfROcEVfZhVkjZUSyLIpHe3U9mzyr/qrzAE34KYUP8tnneZc1" +
                                                              "j/0XFJlponAYAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "IgAA");
}
