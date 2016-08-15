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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "DxbrGVW4LwAA");
}
