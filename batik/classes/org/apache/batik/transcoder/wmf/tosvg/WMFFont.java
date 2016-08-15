package org.apache.batik.transcoder.wmf.tosvg;
public class WMFFont {
    public java.awt.Font font;
    public int charset;
    public int underline = 0;
    public int strikeOut = 0;
    public int italic = 0;
    public int weight = 0;
    public int orientation = 0;
    public int escape = 0;
    public WMFFont(java.awt.Font font, int charset) { super();
                                                      this.font = font;
                                                      this.charset = charset;
    }
    public WMFFont(java.awt.Font font, int charset, int underline, int strikeOut,
                   int italic,
                   int weight,
                   int orient,
                   int escape) { super();
                                 this.font = font;
                                 this.charset = charset;
                                 this.underline = underline;
                                 this.strikeOut = strikeOut;
                                 this.italic = italic;
                                 this.weight = weight;
                                 this.orientation = orient;
                                 this.escape = escape; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1YfWwcxRWfO39/xR+Jk5DEju2cQfngllBCRZ1SEmMTh4tt" +
                                                              "xYmrXiCXub0538Z7u5vdWd/Z1BQQKOlXlEIIAUH+CkoaBYJQo1K1oFSoLRWh" +
                                                              "EpCWUtRQVZWaikYlqkqrpi19M7t3+3G3l5I/amnn1rPvzfu9N2/ex5y+jGoM" +
                                                              "HXUThUbprEaM6JBCx7FukNSgjA1jB8wlxKeq8F93Xxq9I4xq42hBBhvbRGyQ" +
                                                              "YYnIKSOOuiTFoFgRiTFKSIpxjOvEIPoMppKqxFGnZIxkNVkSJbpNTRFGMIn1" +
                                                              "GGrHlOpS0qRkxF6Aoq4YIBE4EmGT//NADDWLqjbrkC91kQ+6vjDKrCPLoKgt" +
                                                              "thfPYMGkkizEJIMO5HW0VlPl2SlZpVGSp9G98gbbBFtjG0pM0PdS6ydXD2Xa" +
                                                              "uAkWYkVRKVfP2E4MVZ4hqRhqdWaHZJI19qEHUVUMNbmIKYrECkIFECqA0IK2" +
                                                              "DhWgbyGKmR1UuTq0sFKtJjJAFPV6F9GwjrP2MuMcM6xQT23dOTNo21PU1tKy" +
                                                              "RMUn1wqHn9rd9nIVao2jVkmZYHBEAEFBSBwMSrJJohubUimSiqN2BTZ7gugS" +
                                                              "lqU5e6c7DGlKwdSE7S+YhU2aGtG5TMdWsI+gm26KVNWL6qW5Q9n/1aRlPAW6" +
                                                              "LnZ0tTQcZvOgYKMEwPQ0Br+zWaqnJSVF0Uo/R1HHyL1AAKx1WUIzalFUtYJh" +
                                                              "AnVYLiJjZUqYANdTpoC0RgUH1ClaFrgos7WGxWk8RRLMI31049YnoGrghmAs" +
                                                              "FHX6yfhKsEvLfLvk2p/LoxsPPqBsUcIoBJhTRJQZ/iZg6vYxbSdpohM4BxZj" +
                                                              "85rYEbz41QNhhIC400ds0Xz/q1fuWtd97g2LZnkZmrHkXiLShHg8ueDtFYOr" +
                                                              "76hiMOo11ZDY5ns056ds3P4ykNcgwiwursg+Rgsfz23/6VceOkU+CqPGEVQr" +
                                                              "qrKZBT9qF9WsJslEv4coRMeUpEZQA1FSg/z7CKqD95ikEGt2LJ02CB1B1TKf" +
                                                              "qlX5/2CiNCzBTNQI75KSVgvvGqYZ/p7XEEJ18KBmeLqQ9cd/KdojZNQsEbCI" +
                                                              "FUlRhXFdZfobAkScJNg2IyTB66cFQzV1cEFB1acEDH6QIfYHqmPFECEI6UIu" +
                                                              "mxaoasxMCV/eNjwMxooyT9P+DzLyTM+FuVAItmCFPwDIcHa2qDJwJ8TD5uah" +
                                                              "Ky8m3rScix0I20IU3Qxio5bYKBcbdcRGQWyUi43aYlEoxKUtYuKtzYatmoZD" +
                                                              "D1G3efXE/Vv3HOirAi/TctVg5zCQ9nmyz6ATGQrhPCGe6WiZ6724/vUwqo6h" +
                                                              "DixSE8ssmWzSpyBMidP2SW5OQl5y0kOPKz2wvKarIklBdApKE/Yq9eoM0dk8" +
                                                              "RYtcKxSSFzumQnDqKIsfnTuae3jya7eEUdibEZjIGghmjH2cxfFivI74I0G5" +
                                                              "dVv3X/rkzJF51YkJnhRTyIwlnEyHPr8/+M2TENf04LOJV+cj3OwNELMphjMG" +
                                                              "4bDbL8MTcgYK4ZvpUg8Kp1U9i2X2qWDjRprR1Zwzwx21nb8vArdoYmewA56b" +
                                                              "7EPJf9nXxRobl1iOzfzMpwVPD1+c0J779S/+9Dlu7kImaXWVABOEDriiF1us" +
                                                              "g8epdsdtd+iEAN1vj44/8eTl/bu4zwLFqnICI2wchKgFWwhmfuyNfe9/ePH4" +
                                                              "hXDRz0MU0reZhCooX1SSzaPGCkqCtBsdPBD9ZIgOzGsiOxXwTykt4aRM2MH6" +
                                                              "V2v/+rN/Pthm+YEMMwU3WnftBZz5Gzajh97c/fduvkxIZNnXsZlDZoX0hc7K" +
                                                              "m3QdzzIc+Yff6Xr6Z/g5SA4QkA1pjvAYG7bPOgO1lKIWzolzNMoihjcCsFM2" +
                                                              "YSYNOK1SFjZnxk5it47vEQ9Exv9gJagbyjBYdJ0nhW9Pvrf3PN/6ehYP2DwT" +
                                                              "3OI67RA3XH7XZm3Jp/AXguc/7GFbwSasZNAxaGeknmJK0rQ8IF9doYb0KiDM" +
                                                              "d3w4/eylFywF/CnbR0wOHP7Gp9GDh639tOqaVSWlhZvHqm0sddgwwND1VpLC" +
                                                              "OYb/eGb+hyfn91uoOrxZegiK0Bd+9e/z0aO/+3mZxFAl2bXpbczBLTdnJ9K7" +
                                                              "N5ZCd3+99UeHOqqGIZKMoHpTkfaZZCTlXhHKMsNMujbLqZf4hFs1tjGQadbA" +
                                                              "HvDpDRzGLUUwiINB/NtWNvQb7oDq3SpX5Z0QD134uGXy49eucHW9pbs7fmzD" +
                                                              "mmXrdjbcyGy9xJ/wtmAjA3S3nRu9r00+dxVWjMOKIiRyY0yH3Jn3RBubuqbu" +
                                                              "Nz9+ffGet6tQeBg1yipODWMeuFEDRExiZCBf57Uv3WUFjFw9DG1cVVSifMkE" +
                                                              "O7Qry4eDoaxG+QGee2XJ9zaeOHaRRy6NL9FVGpXX2QFrXfmozMab2LC2NNYF" +
                                                              "sfp2sJ5jrmf/3s6GL1QeuOB4BS+4jw07+ad72TBpmWf0Oi3JJnZo1oflFlRW" +
                                                              "YXkKGd4fO7n01Luf/+WJ7xzJWSetQtzw8S3955icfOT3/yjxSF46lAklPv64" +
                                                              "cPrZZYN3fsT5nRzOuCP50qoQ6iCH99ZT2b+F+2p/EkZ1cdQm2v3oJJZNlhnj" +
                                                              "0IMZhSYVelbPd28/ZTUPA8UaZYU/lrnE+qsHd4iopp5w4CsYOuHptv2r2++a" +
                                                              "IcRfMhW9M4ibQjcBliu640LHk6RreVLSC3IJPCttMSsDQKoVQQZxU1QnZlhX" +
                                                              "T4sHw4VT+4w4WRvUY0vqCcA5UxFnEDdFDaYCAZD1a+WQ5q4Daa8tqzcA6XxF" +
                                                              "pEHcgBQqZ2majJllbfrgZ0S6DJ4+W1ZfANJHKyIN4obyUqIYystyMB+7Dpir" +
                                                              "bEGrAmB+syLMIG6AmSPSVKasNb/1GWEy/4/YgiIBMB+vCDOIm6ImVZcgmuNC" +
                                                              "d+DH+sR1mLTfltYfgPXpiliDuMGkxBCxVvYoPVMBZr6cOP5Xi3y3IS5xrpSH" +
                                                              "WNnTFXRhxcvL448cPpYae3592E7Dm+FEUVW7WSYzRPYsBcHLvkFgZcrSkstK" +
                                                              "64JNfPFYa/2SYzvf4x1p8RKsGUr9tCnL7kzheq/VdJKWOIBmK29o/Oe7FPX/" +
                                                              "T5cbFNXwX474pMV8mqKV12CGEhlGN9MZipZXYKLQFxf/cfO9TFGbnw9A8V83" +
                                                              "3VlYwaED17Be3CSvACogYa8/0AodWRsvC1mqjlqpOh/ybnTRozqv5fgu31jl" +
                                                              "KXL4NXWhMTCti+qEeObY1tEHrtz+vNWqizKem2OrNEE7YN0aFC9EegNXK6xV" +
                                                              "u2X11QUvNfQXvK3dAuycieWuinAHdCsa87Vlvj7WiBTb2fePb3ztrQO170Dt" +
                                                              "tAuFMEULd5UWNXnNhGOwK1ba9kBRwxvsgdXPzN65Lv2XD3hVjaw2aUUwfUK8" +
                                                              "cOL+dx9fehwa8aYRVAMHieR5tXX3rLKdiDN6HLVIxlAeIMIqEpY9PdUCdiww" +
                                                              "u8DmdrHN2VKcZRc9FPWVtpOl12PQgeSIvlmFfM2Wga6syZnx3J/bR63R1DQf" +
                                                              "gzPjarmH2TCQZ7sB/piIbdO0Qrfd9IHGQ809/t6ST3Lu8/yVDW/9FzUhWE/C" +
                                                              "GgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
