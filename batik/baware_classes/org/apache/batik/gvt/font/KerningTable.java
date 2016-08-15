package org.apache.batik.gvt.font;
public class KerningTable {
    private org.apache.batik.gvt.font.Kern[] entries;
    public KerningTable(org.apache.batik.gvt.font.Kern[] entries) { super(
                                                                      );
                                                                    this.
                                                                      entries =
                                                                      entries;
    }
    public float getKerningValue(int glyphCode1, int glyphCode2, java.lang.String glyphUnicode1,
                                 java.lang.String glyphUnicode2) {
        for (int i =
               0;
             i <
               entries.
                 length;
             i++) {
            if (entries[i].
                  matchesFirstGlyph(
                    glyphCode1,
                    glyphUnicode1) &&
                  entries[i].
                  matchesSecondGlyph(
                    glyphCode2,
                    glyphUnicode2)) {
                return entries[i].
                  getAdjustValue(
                    );
            }
        }
        return 0.0F;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVYe2wUxxmfOz/xAz94P2yMbWh55DakoYWakoBjg8kZTthY" +
                                                              "ikk49vbm7hbv7S67c/bZqfNAiqCVgigxhFSJ/ykEgghEtFFbtUmpokKipJFC" +
                                                              "aNM0CvQRtbQUFVQ1rUqb9JuZ3dvHnU2jKifd3t7MN9/M9/p93zenrqMS00CN" +
                                                              "WCUhMqxjM9ShkohomDjeroim2QtjUenpIvFvO65uXh1Epf1oako0uyXRxJ0y" +
                                                              "VuJmP2qQVZOIqoTNzRjH6YqIgU1sDIpE1tR+NEM2u9K6Iksy6dbimBL0iUYY" +
                                                              "1YmEGHIsQ3CXxYCghjCcRGAnEdb5p9vCqErS9GGHfLaLvN01QynTzl4mQbXh" +
                                                              "XeKgKGSIrAhh2SRtWQMt0zVlOKloJISzJLRLWWmpYFN4ZZ4Kml+q+fjWgVQt" +
                                                              "U8E0UVU1wsQzt2JTUwZxPIxqnNEOBafN3egRVBRGlS5iglrD9qYCbCrApra0" +
                                                              "DhWcvhqrmXS7xsQhNqdSXaIHImihl4kuGmLaYhNhZwYO5cSSnS0GaZty0nIp" +
                                                              "80Q8tEwYe3pH7dkiVNOPamS1hx5HgkMQ2KQfFIrTMWyY6+JxHO9HdSoYuwcb" +
                                                              "sqjII5al6005qYokA+a31UIHMzo22J6OrsCOIJuRkYhm5MRLMIey/pUkFDEJ" +
                                                              "ss50ZOUSdtJxELBChoMZCRH8zlpSPCCrcYIW+FfkZGy9HwhgaVkak5SW26pY" +
                                                              "FWEA1XMXUUQ1KfSA66lJIC3RwAENguZOyJTqWhelATGJo9QjfXQRPgVUU5gi" +
                                                              "6BKCZvjJGCew0lyflVz2ub55zf6H1Y1qEAXgzHEsKfT8lbCo0bdoK05gA0Mc" +
                                                              "8IVVS8OHxZmv7AsiBMQzfMSc5vtfv3nv8sZzr3OaeQVotsR2YYlEpaOxqe/M" +
                                                              "b1+yuogeo1zXTJka3yM5i7KINdOW1QFhZuY40smQPXlu6/kHHjuJrwVRRRcq" +
                                                              "lTQlkwY/qpO0tC4r2NiAVWyIBMe70BSsxtvZfBcqg/ewrGI+uiWRMDHpQsUK" +
                                                              "GyrV2H9QUQJYUBVVwLusJjT7XRdJir1ndYRQGXxRFXwbEf+wX4IeEFJaGgui" +
                                                              "JKqyqgkRQ6PymwIgTgx0mxJi4PUDgqllDHBBQTOSggh+kMLWRHKQCAlQjHA/" +
                                                              "NoBDsleMKThEXUz/PJlnqWTThgIBUPp8f8grEC0bNSWOjag0llnfcfN09E3u" +
                                                              "TjQELJ0QtBj2C/H9Qmy/EOwXovuF3PuhQIBtM53uy+0KVhmA+AaArVrS89Cm" +
                                                              "nfuai8Ch9KFiUCklbfYkmnYHBGzkjkpn6qtHFl5e8VoQFYdRvSiRjKjQvLHO" +
                                                              "SAIiSQNW0FbFIAU5maDJlQloCjM0CccBiCbKCBaXcm0QG3ScoOkuDnaeohEp" +
                                                              "TJwlCp4fnTsy9Hjfo3cGUdAL/nTLEsAtujxCITsHza3+oC/Et2bv1Y/PHB7V" +
                                                              "nPD3ZBM7CeatpDI0+x3Br56otLRJfDn6ymgrU/sUgGciQjgB8jX69/CgS5uN" +
                                                              "1FSWchA4oRlpUaFTto4rSMrQhpwR5qF17H06uEUlDbdZ8P2iFX/sl87O1Olz" +
                                                              "Fvdo6mc+KVgm+FqP/tyv3v7Tl5i67aRR48r2PZi0uYCKMqtnkFTnuG2vgTHQ" +
                                                              "fXgk8tSh63u3M58FipZCG7bSZzsAFJgQ1PzE67vfv3L56KWg4+cEMnUmBgVP" +
                                                              "NickHUcVkwgJuy12zgNApwAeUK9p3aaCf8oJmUYcDax/1yxa8fJf9tdyP1Bg" +
                                                              "xHaj5bdn4IzPWY8ee3PHPxoZm4BEE62jM4eMo/c0h/M6wxCH6Tmyj19seOaC" +
                                                              "+BzkAcBeUx7BDE4DuVh3FZU0nnoyMZOw1TzjPFh5/ifmd/5wlmec5gLEvjR2" +
                                                              "4ni59EH6/Ed8wZwCCzjdjBPCk33v7XqLeUQ5hQk6TpVU7QIBgBOXO9bmLFVu" +
                                                              "p4NDlqUO8XSw7f9E7Jghx5NY6OnbsKGvt5NCqZUKPh/GWTDAoomRy2WH8edb" +
                                                              "3n50vOW34Aj9qFw2AR1BNwVKEdeaG6euXLtY3XCagUUxVbGlXm8Nl1+ieSov" +
                                                              "pvka+vgqj5TZgDaTpx5GdrfHzeZ7UgprShxUO/nuV35x/FuHh7jPLJlYIb51" +
                                                              "s/+1RYnt+d0/WXTkgXiBksu3vl849ezc9rXX2HoHTenq1mx+YgadO2vvOpn+" +
                                                              "e7C59GdBVNaPaiWrCegTlQzFqH7Qqml3BtAoeOa9RSyv2Npy2WK+H8ld2/px" +
                                                              "3CkI4J3Y8cOhm1ssgBhydbEVX2DPpfRxB7NMkL6GCDCVVVGxgPBT+ATg+wn9" +
                                                              "0rCiAzy86tutkq8pV/PpEBylClaTJGVOaruIIacB2wctnBBG668MPHv1RW5z" +
                                                              "v6F8xHjf2Dc/De0f42jKG4iWvBrevYY3ERw16KObhtrCyXZhKzr/eGb0RydG" +
                                                              "9/JT1XvL4Q7o9l785X/eCh35zRsF6rEiiCP65x49mwuAIFezHTccoanZoWXQ" +
                                                              "VEzB3p7j9ZmshXLtGkxmC4RSgyeUulmoOn754dSDv/9ha3L9ZynM6FjjbUov" +
                                                              "+n8B6GTpxBb2H+XCnj/P7V2b2vkZaqwFPgv5Wb7QfeqNDYulg0HWEfKAyesk" +
                                                              "vYvavGFSYWBofdVeT7C08GBh1uORQh/LmOOw/3fm7ICYHRCjxZPMJekjBqEl" +
                                                              "UUNzv5iEfFfeKM3oCwrXCh1pnbDsPvKDWd9bc3z8Mitr9Cwq4C3TvRmYx9N9" +
                                                              "36j58YH6ok5wki5UnlHl3RncFfcqqszMxFwp2emLHbVZkUXxgaDAUjgBG145" +
                                                              "iZxscJHprqa9fuS6YYlKBy7dqO678erNPID3Fo/dot7mgN5iGuqz/N3ORtFM" +
                                                              "Ad3d5zY/WKucu8XyaKUoQdIztxjQamU9paZFXVL265++NnPnO0Uo2IkqFE2M" +
                                                              "d4qsakdToFzGZgq6tKx+z728BhmiVUktExXlCZ9vXzqQtrBinmUv+t6eq3Jo" +
                                                              "gYPmwbfJqnKa/EW3Be+jheEdatwy3ZAHAad9RW7lJEwJ7dyJIXPvXs3revpk" +
                                                              "6PYI5zRUSOisK3Zy+7FPKfJ17u6i2lEAoqZrmOhyhSH00T1j4/Etx1YELYfa" +
                                                              "RsAWmn6HggexkqfLHblj1NmirrKOscqvS0dQnwS5tmCipT5/L2YHKDYL18u+" +
                                                              "1HZXZKe0rzXykS3PKh5T9NnjD2f6V2dTY3bWqHUyCr8No+OHGc3BScLwGfp4" +
                                                              "EqIoiYl1WcBKE0b8lJUw6U/E9d5LCwUIAlL4XI6P7J/ER/73wCCoyn2PQfFw" +
                                                              "dt7tKL/Rk06P15TPGt/2Hi917Vu3KshfiYyiuKsk13upbuCEzPRRxeGDK/d5" +
                                                              "guZMWOASVEx/2KmPcfoXIHkXooeSAJ5uylNgMD8lKJX9uunOEFTh0EGBxV/c" +
                                                              "JGeBO5DQ1+/qBbyBl5XZgDe6ciaacTsTuQKyxQPV7B7bduoMv8mOSmfGN21+" +
                                                              "+OaXj/EGX1LEkRHKpRLyCL9ryKX4hRNys3mVblxya+pLUxbZIVHHD+zE5zyX" +
                                                              "J6fB/3TqG3N93a/ZmmuC3z+65tWf7yu9CKC/HQVEqMO25xfgWT0D2LM9nJ8v" +
                                                              "oRxibXnbkm8Pr12e+OsHLN2ivMbGTx+VLh1/6N2Ds49C+17ZhUoAvXCWdQb3" +
                                                              "DatbsTRo9KNq2ezIwhGBCxR9nmQ8lbqxSGOa6cVSZ3VulF4PEdScXwbnX6pB" +
                                                              "6hrCxnoto8atdF7pjHgu2K3QqMjoum+BM+LqCzUOD9Qa4I/RcLeu291CySc6" +
                                                              "i2R9YhQ7z17p48J/AcI/z1TjGgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "nlO95rxfqsWFErWYLXpKMdjM1iaLjHs6OqkPnWWzrGJ8WZ7MEXHqU9yaCGpD" +
       "tzCi2hKCs1J/1Va9Cul3XGNulaYS3iOLYs3qciuMg8m6jPaJFddpWP3KrION" +
       "q12YZOAqAiKpu3bKY5BlruSoGvX6MGMWsXEJnYzbEVymjHqpysdIL9RVY742" +
       "4l5olpDYE2OC3IwZJlXazR4soyDvG0xHDZYnU7jcs8eS6s46lDlzXYVtdNF4" +
       "bQ21QbNm9bqzehw7I7I10YtkG095WOq2FXyENulSAfZxcY1b6AzESwWTDEGQ" +
       "JuEkpnvrlB7zVbwqyrE7SGr2iLXV9rBcKhRGwmwJk+1ZqU+aIAHymP6a6NeD" +
       "dW9W0ZnhOkRsXrTStVDw+lwqLjo8RTULGxLdrGddTMVhZOK3EeAXAryw7ZhA" +
       "NgUMjaZqdR3XiR7IfkCE8AejMpqq2nRSbJb7g7rTrSUukxrizBFNuzYOSmWl" +
       "MAqp/rBsJAOxPUkLfF8vwdiw3AwrdaJQqi50zm0kM2Iq0yLSFCIxnDBuvTf0" +
       "y8qms9LbOJEydcemQc7rp2x7JGASzy4QPrZalTEpsxJID50Z5uGYHhCp40Zu" +
       "TYjkVtVbUlpc7iG0P1i6sV3AB4W+T2y4UbNOC5UOzEh9JS7XS8SalYDRMvW5" +
       "Tlc3papXqXXhhtSBN6XJsq01Gtl29X0/2Tb6zvzE4OA2Guyes474J9gpp0fO" +
       "vg4OWPLfOejEDebR+5DDwxkoOz66/0aXzPkZ5/PvfeY5efTJ0s7eoRYVQbdE" +
       "rvfTlpIo1hFUp/I6fUDGnftnO7U9Mmonz3kOGb32kCcXWXq987wz21Ol7LN1" +
       "UORCi3P4Z29yIPcbWfGRCLqkKdHe1WV+xH69U4uzquUK0aEenvlxJxbHDsAi" +
       "6Lajd6PZRc+91/zjYvsvAemzz126cM9z3F9ur1z2b/Jv6UMX1BhsK46c2R+p" +
       "n/MCRTVyrm7ZHgd6+ev5CHrtDe9QIuhM9srJ/c0t/Kci6NXXg4+g06A8Cvnp" +
       "CLp8EhKIKX8fhftMBF08hIugc9vKUZDPA+wAJKv+rnedA7LtJUd66rilHqji" +
       "rh+niiPG/eixo9f8vzH7R9Xx9t8xV6XPPdcdvvNl7JPbe07JEjabDMuFPnR+" +
       "e+V6cNz98A2x7eM6Rz3+yh2fv+WxfXe5Y0vwoa0foe3B618qkrYX5deAmz+8" +
       "5/ff/Knnvp2f1/0PtkMnW7QkAAA=");
}
