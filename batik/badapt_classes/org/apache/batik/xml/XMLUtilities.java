package org.apache.batik.xml;
public class XMLUtilities extends org.apache.batik.xml.XMLCharacters {
    protected XMLUtilities() { super(); }
    public static boolean isXMLSpace(char c) { return c <= 32 && ((1L << 9 |
                                                                     1L <<
                                                                     10 |
                                                                     1L <<
                                                                     13 |
                                                                     1L <<
                                                                     32) >>
                                                                    c &
                                                                    1L) !=
                                                 0; }
    public static boolean isXMLNameFirstCharacter(char c) { return (NAME_FIRST_CHARACTER[c /
                                                                                           32] &
                                                                      1 <<
                                                                      c %
                                                                      32) !=
                                                              0;
    }
    public static boolean isXML11NameFirstCharacter(char c) {
        return (NAME11_FIRST_CHARACTER[c /
                                         32] &
                  1 <<
                  c %
                  32) !=
          0;
    }
    public static boolean isXMLNameCharacter(char c) { return (NAME_CHARACTER[c /
                                                                                32] &
                                                                 1 <<
                                                                 c %
                                                                 32) !=
                                                         0;
    }
    public static boolean isXML11NameCharacter(char c) {
        return (NAME11_CHARACTER[c /
                                   32] &
                  1 <<
                  c %
                  32) !=
          0;
    }
    public static boolean isXMLCharacter(int c) {
        return (XML_CHARACTER[c >>>
                                5] &
                  1 <<
                  (c &
                     31)) !=
          0 ||
          c >=
          65536 &&
          c <=
          1114111;
    }
    public static boolean isXML11Character(int c) {
        return c >=
          1 &&
          c <=
          55295 ||
          c >=
          57344 &&
          c <=
          65533 ||
          c >=
          65536 &&
          c <=
          1114111;
    }
    public static boolean isXMLPublicIdCharacter(char c) {
        return c <
          128 &&
          (PUBLIC_ID_CHARACTER[c /
                                 32] &
             1 <<
             c %
             32) !=
          0;
    }
    public static boolean isXMLVersionCharacter(char c) {
        return c <
          128 &&
          (VERSION_CHARACTER[c /
                               32] &
             1 <<
             c %
             32) !=
          0;
    }
    public static boolean isXMLAlphabeticCharacter(char c) {
        return c <
          128 &&
          (ALPHABETIC_CHARACTER[c /
                                  32] &
             1 <<
             c %
             32) !=
          0;
    }
    public static java.io.Reader createXMLDocumentReader(java.io.InputStream is)
          throws java.io.IOException { java.io.PushbackInputStream pbis =
                                         new java.io.PushbackInputStream(
                                         is,
                                         128);
                                       byte[] buf =
                                         new byte[4];
                                       int len =
                                         pbis.
                                         read(
                                           buf);
                                       if (len >
                                             0) {
                                           pbis.
                                             unread(
                                               buf,
                                               0,
                                               len);
                                       }
                                       if (len ==
                                             4) {
                                           switch (buf[0] &
                                                     255) {
                                               case 0:
                                                   if (buf[1] ==
                                                         60 &&
                                                         buf[2] ==
                                                         0 &&
                                                         buf[3] ==
                                                         63) {
                                                       return new java.io.InputStreamReader(
                                                         pbis,
                                                         "UnicodeBig");
                                                   }
                                                   break;
                                               case '<':
                                                   switch (buf[1] &
                                                             255) {
                                                       case 0:
                                                           if (buf[2] ==
                                                                 63 &&
                                                                 buf[3] ==
                                                                 0) {
                                                               return new java.io.InputStreamReader(
                                                                 pbis,
                                                                 "UnicodeLittle");
                                                           }
                                                           break;
                                                       case '?':
                                                           if (buf[2] ==
                                                                 'x' &&
                                                                 buf[3] ==
                                                                 'm') {
                                                               java.io.Reader r =
                                                                 createXMLDeclarationReader(
                                                                   pbis,
                                                                   "UTF8");
                                                               java.lang.String enc =
                                                                 getXMLDeclarationEncoding(
                                                                   r,
                                                                   "UTF8");
                                                               return new java.io.InputStreamReader(
                                                                 pbis,
                                                                 enc);
                                                           }
                                                   }
                                                   break;
                                               case 76:
                                                   if (buf[1] ==
                                                         111 &&
                                                         (buf[2] &
                                                            255) ==
                                                         167 &&
                                                         (buf[3] &
                                                            255) ==
                                                         148) {
                                                       java.io.Reader r =
                                                         createXMLDeclarationReader(
                                                           pbis,
                                                           "CP037");
                                                       java.lang.String enc =
                                                         getXMLDeclarationEncoding(
                                                           r,
                                                           "CP037");
                                                       return new java.io.InputStreamReader(
                                                         pbis,
                                                         enc);
                                                   }
                                                   break;
                                               case 254:
                                                   if ((buf[1] &
                                                          255) ==
                                                         255) {
                                                       return new java.io.InputStreamReader(
                                                         pbis,
                                                         "Unicode");
                                                   }
                                                   break;
                                               case 255:
                                                   if ((buf[1] &
                                                          255) ==
                                                         254) {
                                                       return new java.io.InputStreamReader(
                                                         pbis,
                                                         "Unicode");
                                                   }
                                           }
                                       }
                                       return new java.io.InputStreamReader(
                                         pbis,
                                         "UTF8");
    }
    protected static java.io.Reader createXMLDeclarationReader(java.io.PushbackInputStream pbis,
                                                               java.lang.String enc)
          throws java.io.IOException { byte[] buf =
                                         new byte[128];
                                       int len =
                                         pbis.
                                         read(
                                           buf);
                                       if (len >
                                             0) {
                                           pbis.
                                             unread(
                                               buf,
                                               0,
                                               len);
                                       }
                                       return new java.io.InputStreamReader(
                                         new java.io.ByteArrayInputStream(
                                           buf,
                                           4,
                                           len),
                                         enc);
    }
    protected static java.lang.String getXMLDeclarationEncoding(java.io.Reader r,
                                                                java.lang.String e)
          throws java.io.IOException { int c;
                                       if ((c =
                                              r.
                                                read(
                                                  )) !=
                                             'l') {
                                           return e;
                                       }
                                       if (!isXMLSpace(
                                              (char)
                                                (c =
                                                   r.
                                                     read(
                                                       )))) {
                                           return e;
                                       }
                                       while (isXMLSpace(
                                                (char)
                                                  (c =
                                                     r.
                                                       read(
                                                         ))))
                                           ;
                                       if (c !=
                                             'v') {
                                           return e;
                                       }
                                       if ((c =
                                              r.
                                                read(
                                                  )) !=
                                             'e') {
                                           return e;
                                       }
                                       if ((c =
                                              r.
                                                read(
                                                  )) !=
                                             'r') {
                                           return e;
                                       }
                                       if ((c =
                                              r.
                                                read(
                                                  )) !=
                                             's') {
                                           return e;
                                       }
                                       if ((c =
                                              r.
                                                read(
                                                  )) !=
                                             'i') {
                                           return e;
                                       }
                                       if ((c =
                                              r.
                                                read(
                                                  )) !=
                                             'o') {
                                           return e;
                                       }
                                       if ((c =
                                              r.
                                                read(
                                                  )) !=
                                             'n') {
                                           return e;
                                       }
                                       c =
                                         r.
                                           read(
                                             );
                                       while (isXMLSpace(
                                                (char)
                                                  c)) {
                                           c =
                                             r.
                                               read(
                                                 );
                                       }
                                       if (c !=
                                             '=') {
                                           return e;
                                       }
                                       while (isXMLSpace(
                                                (char)
                                                  (c =
                                                     r.
                                                       read(
                                                         ))))
                                           ;
                                       if (c !=
                                             '\"' &&
                                             c !=
                                             '\'') {
                                           return e;
                                       }
                                       char sc =
                                         (char)
                                           c;
                                       for (;
                                            ;
                                            ) {
                                           c =
                                             r.
                                               read(
                                                 );
                                           if (c ==
                                                 sc) {
                                               break;
                                           }
                                           if (!isXMLVersionCharacter(
                                                  (char)
                                                    c)) {
                                               return e;
                                           }
                                       }
                                       if (!isXMLSpace(
                                              (char)
                                                (c =
                                                   r.
                                                     read(
                                                       )))) {
                                           return e;
                                       }
                                       while (isXMLSpace(
                                                (char)
                                                  (c =
                                                     r.
                                                       read(
                                                         ))))
                                           ;
                                       if (c !=
                                             'e') {
                                           return e;
                                       }
                                       if ((c =
                                              r.
                                                read(
                                                  )) !=
                                             'n') {
                                           return e;
                                       }
                                       if ((c =
                                              r.
                                                read(
                                                  )) !=
                                             'c') {
                                           return e;
                                       }
                                       if ((c =
                                              r.
                                                read(
                                                  )) !=
                                             'o') {
                                           return e;
                                       }
                                       if ((c =
                                              r.
                                                read(
                                                  )) !=
                                             'd') {
                                           return e;
                                       }
                                       if ((c =
                                              r.
                                                read(
                                                  )) !=
                                             'i') {
                                           return e;
                                       }
                                       if ((c =
                                              r.
                                                read(
                                                  )) !=
                                             'n') {
                                           return e;
                                       }
                                       if ((c =
                                              r.
                                                read(
                                                  )) !=
                                             'g') {
                                           return e;
                                       }
                                       c =
                                         r.
                                           read(
                                             );
                                       while (isXMLSpace(
                                                (char)
                                                  c)) {
                                           c =
                                             r.
                                               read(
                                                 );
                                       }
                                       if (c !=
                                             '=') {
                                           return e;
                                       }
                                       while (isXMLSpace(
                                                (char)
                                                  (c =
                                                     r.
                                                       read(
                                                         ))))
                                           ;
                                       if (c !=
                                             '\"' &&
                                             c !=
                                             '\'') {
                                           return e;
                                       }
                                       sc =
                                         (char)
                                           c;
                                       java.lang.StringBuffer enc =
                                         new java.lang.StringBuffer(
                                         );
                                       for (;
                                            ;
                                            ) {
                                           c =
                                             r.
                                               read(
                                                 );
                                           if (c ==
                                                 -1) {
                                               return e;
                                           }
                                           if (c ==
                                                 sc) {
                                               return encodingToJavaEncoding(
                                                        enc.
                                                          toString(
                                                            ),
                                                        e);
                                           }
                                           enc.
                                             append(
                                               (char)
                                                 c);
                                       } }
    public static java.lang.String encodingToJavaEncoding(java.lang.String e,
                                                          java.lang.String de) {
        java.lang.String result =
          org.apache.batik.util.EncodingUtilities.
          javaEncoding(
            e);
        return result ==
          null
          ? de
          : result;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVae5AUxRnv3eOe3BuON8frIAFhF1RMrCPqcdzJwR5c7oDS" +
       "AzlmZ3tvh5udGWd6jwWD8ZEUmFQoQlAwFUn+gMKkBKxEK08tLKsUS2MKQ2lM" +
       "AqaiVTEaK5JUmaRMNN/XPbMzO7ezF1K3WzW9s91ff93f73v1Y5/4gJRbJmml" +
       "GouwvQa1Il0a65NMiyY6VcmytkDdkHysTPr7znc33RwmFYOkPiVZvbJk0W6F" +
       "qglrkMxVNItJmkytTZQmsEefSS1qjkpM0bVB0qJYPWlDVWSF9eoJigTbJDNG" +
       "miTGTCWeYbTHZsDI3BjMJMpnEu3wN7fHSK2sG3td8hke8k5PC1Km3bEsRhpj" +
       "u6VRKZphihqNKRZrz5rkOkNX9w6rOovQLIvsVlfbEGyIrR4DwcInGz76+HCq" +
       "kUMwRdI0nXHxrH5q6eooTcRIg1vbpdK0dTe5l5TFyGQPMSNtMWfQKAwahUEd" +
       "aV0qmH0d1TLpTp2LwxxOFYaME2JkQT4TQzKltM2mj88ZOFQxW3beGaSdn5NW" +
       "SDlGxIevix49trPxh2WkYZA0KNoATkeGSTAYZBAApek4Na2ORIImBkmTBsoe" +
       "oKYiqco+W9PNljKsSSwD6ndgwcqMQU0+posV6BFkMzMy082ceEluUPav8qQq" +
       "DYOs01xZhYTdWA8C1igwMTMpgd3ZXSaNKFqCkXn+HjkZ2zYCAXStTFOW0nND" +
       "TdIkqCDNwkRUSRuODoDpacNAWq6DAZqMzApkilgbkjwiDdMhtEgfXZ9oAqpq" +
       "DgR2YaTFT8Y5gZZm+bTk0c8Hm9Ycukdbr4VJCOacoLKK858MnVp9nfppkpoU" +
       "/EB0rF0We0Sa9szBMCFA3OIjFjQ//tLV25a3nr8gaGYXoNkc301lNiSfjNdf" +
       "nNO59OYynEaVoVsKKj9Pcu5lfXZLe9aACDMtxxEbI07j+f4X7rzvB/T9MKnp" +
       "IRWyrmbSYEdNsp42FJWat1ONmhKjiR5STbVEJ2/vIZXwHlM0Kmo3J5MWZT1k" +
       "ksqrKnT+GyBKAguEqAbeFS2pO++GxFL8PWsQQirhIbXwLCbiw78Z2RJN6Wka" +
       "lWRJUzQ92mfqKL8VhYgTB2xT0ThY/UjU0jMmmGBUN4ejEthBitoN2bQavaM3" +
       "thXEBVEBRLQuo0R8syjPlD2hEEA9x+/oKvjIel1NUHNIPppZ23X17NDLwojQ" +
       "8G0kIKrAUBExVIQPFYGhIt6hSCjER5iKQwpFghpGwKEhotYuHbhrw66DC8vA" +
       "gow9kwBDJF2Yl1k6Xa93QvWQfK65bt+CK6ueD5NJMdIsySwjqZgoOsxhCEHy" +
       "iO2ltXHIOW7on+8J/ZizTF2mCYg8QSnA5lKlj1IT6xmZ6uHgJCZ0wWhwWig4" +
       "f3L++J77t315ZZiE86M9DlkOgQq792GMzsXiNr+XF+LbcODdj849sl93/T0v" +
       "fThZb0xPlGGh3wb88AzJy+ZLTw89s7+Nw14N8ZhJ4D8Q6lr9Y+SFk3YnNKMs" +
       "VSBwUjfTkopNDsY1LGXqe9wabpxN/H0qmEU9+tcseJbZDse/sXWageV0Ycxo" +
       "Zz4peOj/woDx2G9e/fMNHG4nSzR40vsAZe2eyITMmnkManLNdotJKdBdPt73" +
       "rYc/OLCd2yxQLCo0YBuWnRCRQIUA81cv3P3mW1dOXgq7ds5ItWHqDNyYJrI5" +
       "ObGJ1BWREwZc4k4JgpsKHNBw2rZqYKJKUpHiKkXf+nfD4lVP/+VQozAFFWoc" +
       "S1o+PgO3fuZact/LO//RytmEZEyuLmwumYjYU1zOHaYp7cV5ZO9/be6jL0qP" +
       "QeyHeGsp+ygPoYTDQLjeVnP5V/LyRl/b57BYbHntP9/FPIugIfnwpQ/rtn34" +
       "7FU+2/xVlFfdvZLRLiwMiyVZYD/dH5/WS1YK6G48v2lHo3r+Y+A4CBxliK/W" +
       "ZhPiYjbPOGzq8srfPvf8tF0Xy0i4m9SoupTolrifkWowcGqlIKRmjVtvE8rd" +
       "UwVFIxeVjBF+TAUCPK+w6rrSBuNg7/vJ9KfWnD5xhRuaIXjM9jL8DC+XYbHC" +
       "McQKIxOHpbZrhfxT4U9vXivM42uSuUErEL56OvnA0ROJzadWiXVCc35W74JF" +
       "65nX//NK5PgfXiqQYKqZbqxQ6ShVPWPW45B5SaKXL87cQHW5/sjbP20bXnst" +
       "+QHrWsfJAPh7HgixLDje+6fy4gPvzdpyS2rXNYT6eT44/Sy/3/vES7cvkY+E" +
       "+UpURPkxK9j8Tu1eYGFQk8KSW0MxsaaOO8OinAFgpCVt8Ky0DWBl4XBb0KLC" +
       "+NoFZmXxzYAvuDUV4eoLA6FCKwLU4kAmbkH2VtIQrEftBev1fbvkg2197wgj" +
       "m1mgg6BreTz6jW1v7H6Fq6MK9Z8DwaN7sBNPHmoUInwKnxA8n+CDU8cKsfBr" +
       "7rRXn/Nzy090P5MsLbJfzBcgur/5rZHvvHtGCOBfnvuI6cGjX/s0cuio8Bix" +
       "h1k0Zhvh7SP2MUIcLHbg7BYUG4X36P7Tuf0/f3z/gbAdjnsYmSSnbM/IV9LU" +
       "fMzFRNc91PCLw81l3eCIPaQqoyl3Z2hPIt8YK61M3KMEd8/jmqY9ZQSckdAy" +
       "wJZX31EkcezG4osM9nwWrEcHDGfTd6ctPX7t9LzHGamM67pKJc0vHP4cFlSf" +
       "x6JfvLf/n3EcKzoMXt+b73Kr4FljO8eaa3Y5LLYWcLcgjoXdDX9u54PdUwTd" +
       "/VhkGJnO0d0EyuxWTIt1gmlAtKUmNqsuYqOlQuwGeNbZ8q2bMMSCOI6H2ENF" +
       "EPs6Fg8yMpMjtmrVuJh9pVSYLYdnoy3hxgnDLIjjeJgdK4LZo1h8E8JrzsqC" +
       "wDpSKrAi8PTbovVPGFhBHMcD61QRsE5j8V3Yo3oMLAiu75UKrs/Cs8MWbseE" +
       "wRXEMWDBgL+LhPkyxT4fHRPi+Qx/VATjn2FxhpF6jnEQumdLhS7uBqmNBZ0w" +
       "dIM4BhvjU3ywF4oAdQGL84w02sYYBNVzpYIK15aaLZg2YVAFcRzPby8Vgep1" +
       "LF6FjTWHqo/vxXoSQYD9qlSAReEZtcUbnTDAgjiOB9gfiwD2Dha/Z3hJBIBt" +
       "o6YF26kgvC6XCq/r4bnXlu7eCcMriON4eH1YBK+/YfEeIzM4Xh2qkZLiFK9p" +
       "AiB7vwSQzcQ29MlDtoCHJgyyII5FksMMZh9VKXqkRzMybICZVErzOXzyv/bb" +
       "3JWVqYFbeewX4pP8J6yIZWDFKCC9TpczadgU9VMpQU2HQb3DwFPNYf9XCWCf" +
       "g203wXPRBunitcIeKQT71CIcffCFBStH+tmO9H0ZKxWX5BEP/A5NI6fBO7WI" +
       "uFPj+DYHukCI79JDM7CoZWSWqwAqq3gACyoSYCNFRQ7xUF2pEF8Nz9s2Pm9P" +
       "GOJBHAsjzmXFooWj0zYefEuwaIX9yTBl+dh1abKeADVwZi5680oVJiATheKC" +
       "p/ieiDARyDEYvRYXveuDw2voRiyWQ/6mNk5b9A1gwAGorZgI1LKM1Hov2fBo" +
       "eMaYu3pxvyyfPdFQNf3E1jf4WWjuDrg2RqqSGVX1nMN4z2QqDJMmFY52rTgp" +
       "N7iwa2B/UejOD1bVUOJ8Q+2C8lZwZD8lI+X820u3lpEal46RCvHiJekC7kCC" +
       "r92GEyUWBl095tKalRVRO+8AnIfalvGU4DnbXpR3gsf/N+GccmXEPyeG5HMn" +
       "Nmy65+pNp8T9EjjOvn3IZXKMVIqrLs4Uj3YXBHJzeFWsX/px/ZPVi50TtyYx" +
       "YdfuZ3tSewcYtIHan+W7ebHachcwb55c8+wvD1a8Fiah7SQkQQrb7vnXgrii" +
       "b88aGZPM3R4be4a3TTL5lVD70m/vvWV58q+/43cLRJz5zQmmH5Ivnb7r10dm" +
       "nGwNk8k9pFzREjQ7iMdx6/ZCOJZHzUFSp1hdWZgicFEkNe+AsD7BAxA4EMfF" +
       "hrMuV4u3k2AEY888x97p1qj6Hmqu1TNaAtnUxchkt0Zoxnc6njEMXwe3xlYl" +
       "lkksdmRRG2ChQ7Few3COhEOjBvfV4UJLNpHQ+A6VG/XgfwFvFBPNUyUAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "wZ956WvVKZv/B2lmOPy4LwAA");
}
