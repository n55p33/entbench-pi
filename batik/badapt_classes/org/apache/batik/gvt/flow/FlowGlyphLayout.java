package org.apache.batik.gvt.flow;
public class FlowGlyphLayout extends org.apache.batik.gvt.text.GlyphLayout {
    public static final char SOFT_HYPHEN = 173;
    public static final char ZERO_WIDTH_SPACE = 8203;
    public static final char ZERO_WIDTH_JOINER = 8205;
    public static final char SPACE = ' ';
    public FlowGlyphLayout(java.text.AttributedCharacterIterator aci, int[] charMap,
                           java.awt.geom.Point2D offset,
                           java.awt.font.FontRenderContext frc) {
        super(
          aci,
          charMap,
          offset,
          frc);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALUZDXAU1fnlEkLID/mRPyMJEAIaxDu10GpDrRAScngkNwnS" +
                                                              "MSDHZu/d3ZK93XX3XXLB4t9UoXXKWAtoO5p2pliog+I4dVrbauk4RR2tMyKt" +
                                                              "RUewttPSWqcynWqntrXf997u7c/dxdGON7Pv9t77ft73876fd0ffITMsk7RT" +
                                                              "jYXZpEGtcK/G4pJp0WSPKlnWZphLyPdVSn/ffm7g6hCpHiGzM5K1SZYs2qdQ" +
                                                              "NWmNkDZFs5ikydQaoDSJGHGTWtQcl5iiayNkrmJFs4aqyArbpCcpAmyRzBhp" +
                                                              "lhgzldEco1GbACNtMdhJhO8ksja43B0j9bJuTLrgCzzgPZ4VhMy6vCxGmmI7" +
                                                              "pXEpkmOKGokpFuvOm+RSQ1cn06rOwjTPwjvV1bYKNsZWF6mg47HG9z64J9PE" +
                                                              "VXCBpGk64+JZQ9TS1XGajJFGd7ZXpVnrJnILqYyROg8wI50xh2kEmEaAqSOt" +
                                                              "CwW7b6BaLtujc3GYQ6nakHFDjCzxEzEkU8raZOJ8z0Chhtmyc2SQdnFBWiFl" +
                                                              "kYgHLo3sv2970+OVpHGENCraMG5Hhk0wYDICCqXZUWpaa5NJmhwhzRoYe5ia" +
                                                              "iqQqu2xLt1hKWpNYDszvqAUncwY1OU9XV2BHkM3MyUw3C+KluEPZv2akVCkN" +
                                                              "ss5zZRUS9uE8CFirwMbMlAR+Z6NUjSlakpFFQYyCjJ3XAQCgzsxSltELrKo0" +
                                                              "CSZIi3ARVdLSkWFwPS0NoDN0cECTkdayRFHXhiSPSWmaQI8MwMXFEkDN4opA" +
                                                              "FEbmBsE4JbBSa8BKHvu8M7Bm381avxYiFbDnJJVV3H8dILUHkIZoipoUzoFA" +
                                                              "rF8ROyjNe2pviBAAnhsAFjA/+vL5a1e2H39OwFxUAmZwdCeVWUI+NDr75YU9" +
                                                              "XVdX4jZqDN1S0Pg+yfkpi9sr3XkDIsy8AkVcDDuLx4dO3HDbw/TtEKmNkmpZ" +
                                                              "V3NZ8KNmWc8aikrNDVSjpsRoMkpmUS3Zw9ejZCa8xxSNitnBVMqiLEqqVD5V" +
                                                              "rfPfoKIUkEAV1cK7oqV0592QWIa/5w1CyEx4SD08nUR8+Dcj2yIZPUsjkixp" +
                                                              "iqZH4qaO8lsRiDijoNtMZBS8fixi6TkTXDCim+mIBH6QofZCepxFUqo+AQ6r" +
                                                              "T2xQJ41MTJoEbwqjlxmfMv08ynfBREUFqH5h8OCrcGb6dTVJzYS8P7eu9/yj" +
                                                              "iReEU+FBsDXDSBewDAuWYc4yDCzDyDIcYEkqKjinOchaGBjMMwYHHSJtfdfw" +
                                                              "jRt37O2oBM8yJqpAtwja4cs4PW40cEJ4Qj7W0rBryZkrngmRqhhpkWSWk1RM" +
                                                              "IGvNNIQmecw+vfWjkIvclLDYkxIwl5m6TJMQkcqlBptKjT5OTZxnZI6HgpOw" +
                                                              "8GhGyqeLkvsnx++fuH3LrZeHSMifBZDlDAhgiB7H2F2I0Z3B01+KbuOec+8d" +
                                                              "O7hbd+OAL6042bAIE2XoCPpCUD0JecVi6YnEU7s7udpnQZxmEpwrCIHtQR6+" +
                                                              "MNPthGyUpQYETulmVlJxydFxLcuY+oQ7w520mb/PAbeow3PXCs9K+yDyb1yd" +
                                                              "Z+A4Xzg1+llACp4SvjBsPPjbl/78Ga5uJ3s0etL+MGXdnoiFxFp4bGp23Xaz" +
                                                              "SSnAvXF//JsH3tmzlfssQCwtxbATxx6IVGBCUPOdz910+uyZQ6dCrp8zSNm5" +
                                                              "Uah88gUhcZ7UTiMkcFvu7gcingpRAb2m83oN/FNJKdKoSvFg/btx2RVP/HVf" +
                                                              "k/ADFWYcN1r50QTc+QvXkdte2P5+OydTIWPGdXXmgokwfoFLea1pSpO4j/zt" +
                                                              "J9u+9az0ICQECMKWsovyuFrFdVDFJV/AyDKOiaVEuFDYJXsyoDsZEmyUUa5E" +
                                                              "fy2Kp284N2oxzkskqm11J35ufe+Pj4tE1VECOJD9jhyukV/PnviDQLiwBIKA" +
                                                              "m3sk8vUtr+58kftPDQYVnMfdN3hCBgQfj/M2Few6G83YDM+1tl2vFVlk6/8Z" +
                                                              "5bG+kyZYJE31LNQSLAPBKc0yThL5NMnnwRjLysc8j02mvr/0pVunlv4OXGiE" +
                                                              "1CgWxFXQU4lqxoPz7tGzb59saHuUh5kqVLetan8ZWFzl+Yo3boVGHNbkrdLu" +
                                                              "EDeVLBz4cdsdrozvkPd2xrk7IN7nhQk/hE8FPP/FB02HE8KELT12NbK4UI4Y" +
                                                              "BnLrmqZ/8DON7G45O/bAuUeEDwbLtQAw3bv/ax+G9+0X51rUtEuLykovjqhr" +
                                                              "hUfisB53t2Q6Lhyj70/Hdv/0yO49Ylct/gqtFxqQR37znxfD97/5fInioFKx" +
                                                              "+5JVGOgKaX2O3wBCoPVfbfzZPS2VfWDqKKnJacpNORpNeimCVa3cqOe8ubUy" +
                                                              "n/CKhoaBimMF2qB4Awt9dQVvUd3U9vArn/v14W8cnBACT2O+AN6Cfw2qo3e8" +
                                                              "9U+uh6JMXsKiAfyRyNEHWnuueZvjuykVsTvzxQUaHB8X98qHs/8IdVT/MkRm" +
                                                              "jpAm2W4Jt0hqDhPVCBwQy+kToW30rftbGlG/dxdKhoVBl/KwDSZzr6WqmM8q" +
                                                              "zeLwVRCevm7gGBfzcQUOl3HLhPA1zICookkqx1sPyVHlwQZ/RXFY67FoSOA5" +
                                                              "2UPkHZQDOiJdo5jCnDVRdSp6uNCNwmIp32jz+cYmHkZcRb8x+97fP9mZXvdx" +
                                                              "yk2ca/+IghJ/LwIrryjvbsGtPHvHX1o3X5PZ8TEqx0UBHwqS/MGmo89vWC7f" +
                                                              "G+INr/CAokbZj9Ttt3utSaGz1/xncqmwPreeMD0Ol3ID89+XF+xAuB1E0B2b" +
                                                              "Zi2LQwZ8RUZDC7+YBtwomsU6ZVHpCqg3azBes+z68fwfrjk8dYYXa0aeBL0F" +
                                                              "f8bzjofN5dQgT4YxT0LzCsHvyvXO6qLCagpOdrgPhiFoS6lpX53wba6eRoRd" +
                                                              "OCyzvOW/30U8d0MJ+Z5T7zZseffp80XByF/tbpKMbveALseMMD/YnvVLVgbg" +
                                                              "Vh0f2NakHv+Ap+86SYZcaw2aIEDeVxvb0DNmvvaLZ+bteLmShPpIrapLyT6J" +
                                                              "txlkFtT31MpAZ5k3vmjXQRM1MDRxUUmR8MWmwwnLDgMXeQrI4UKhtQABr4Jn" +
                                                              "uV1oLQ92CbwVbXYDRhSskKZmy1vfPfT+7XuuCmGZOmMcAyTI1+TCDeTwfuuu" +
                                                              "owfa6va/eTf3DKD8CBL9SumwVmmHtWqLX5Xhr22BUn/+NDtlpG54sG9zov+G" +
                                                              "eH/vAMdbZ6dv/OrzvG9kpErO2NGlyE9FX4TjzTjcKXBuKWuDEtq82N7jxSW0" +
                                                              "iS93EbK4Dl8OTKcKHO4up4ZyLBhpGukdGkx8Kbp+c39iOL62pxfn9wWkOvgJ" +
                                                              "pLrEZnnJNFI14MvUJ5aqHAtGmj1SbRyMDvQOlRLrOx9TrNXwdNk8u0q6vjdX" +
                                                              "Ov3Vqrs3nB5rXZ4H5+9xnN8gixHr8CcWvdw2IHaXteKRacTNezJIgRv/VJPA" +
                                                              "9ZyHmydWEIxybeVuUHnNe+iO/VPJwYeucMr/6xiELd24TKXjVPWRgnAauObC" +
                                                              "xLKg6BZd3PzKj0411syfuv5V0c84t7P1UAikcqrqrZ8879WGSVMK30i9CNYG" +
                                                              "//oJIxeWvX2DUIBffLNPCvinoAoqBQ91OoxeyONw2oKQYC/+7YV7hpFaFw5C" +
                                                              "nHjxgpwA6gCCr88ahTa/5LZ52+/RZL7Cb7WCe8z9qNPgMfRSX7bkf4I4xU9O" +
                                                              "/A2SkI9NbRy4+fxnHxKXQrIq7eLJtg4aDnE/VSiglpSl5tCq7u/6YPZjs5Y5" +
                                                              "rtMsNuw6+EWenG5BcDbQYVoDNyZWZ+Hi5PShNU//am/1STiUW0mFBFXu1uJ6" +
                                                              "PW/kwKe3xoobKyg2+VVOd9e3J69Zmfrb607KCvRBQfiEfOrwja/cu+BQe4jU" +
                                                              "QSqEU0HzvJFYP6kNUXncHCENitWbhy0CFSipfV3bbPRtCf8e4Xqx1dlQmMUr" +
                                                              "RUY6ihvW4otYqB4mqLlOz2lJJAN9X5074/t3xj4vtTnDCCC4M54bgUGROtEa" +
                                                              "4KSJ2CbDcPr52iGDx414+VT6Gn/F4fX/Aef9mOogHQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "+t3Pv+vff+jfvPaH5Yn63wD7fspUWCgAAA==");
}
