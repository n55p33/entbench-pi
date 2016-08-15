package org.apache.batik.xml;
public class XMLStreamNormalizingReader extends org.apache.batik.util.io.StreamNormalizingReader {
    public XMLStreamNormalizingReader(java.io.InputStream is, java.lang.String encod)
          throws java.io.IOException { super();
                                       java.io.PushbackInputStream pbis =
                                         new java.io.PushbackInputStream(
                                         is,
                                         128);
                                       byte[] buf = new byte[4];
                                       int len = pbis.read(buf);
                                       if (len > 0) { pbis.unread(
                                                             buf,
                                                             0,
                                                             len);
                                       }
                                       if (len == 4) { switch (buf[0] &
                                                                 255) {
                                                           case 0:
                                                               if (buf[1] ==
                                                                     60 &&
                                                                     buf[2] ==
                                                                     0 &&
                                                                     buf[3] ==
                                                                     63) {
                                                                   charDecoder =
                                                                     new org.apache.batik.util.io.UTF16Decoder(
                                                                       pbis,
                                                                       true);
                                                                   return;
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
                                                                           charDecoder =
                                                                             new org.apache.batik.util.io.UTF16Decoder(
                                                                               pbis,
                                                                               false);
                                                                           return;
                                                                       }
                                                                       break;
                                                                   case '?':
                                                                       if (buf[2] ==
                                                                             'x' &&
                                                                             buf[3] ==
                                                                             'm') {
                                                                           java.io.Reader r =
                                                                             org.apache.batik.xml.XMLUtilities.
                                                                             createXMLDeclarationReader(
                                                                               pbis,
                                                                               "UTF8");
                                                                           java.lang.String enc =
                                                                             org.apache.batik.xml.XMLUtilities.
                                                                             getXMLDeclarationEncoding(
                                                                               r,
                                                                               "UTF-8");
                                                                           charDecoder =
                                                                             createCharDecoder(
                                                                               pbis,
                                                                               enc);
                                                                           return;
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
                                                                     org.apache.batik.xml.XMLUtilities.
                                                                     createXMLDeclarationReader(
                                                                       pbis,
                                                                       "CP037");
                                                                   java.lang.String enc =
                                                                     org.apache.batik.xml.XMLUtilities.
                                                                     getXMLDeclarationEncoding(
                                                                       r,
                                                                       "EBCDIC-CP-US");
                                                                   charDecoder =
                                                                     createCharDecoder(
                                                                       pbis,
                                                                       enc);
                                                                   return;
                                                               }
                                                               break;
                                                           case 254:
                                                               if ((buf[1] &
                                                                      255) ==
                                                                     255) {
                                                                   charDecoder =
                                                                     createCharDecoder(
                                                                       pbis,
                                                                       "UTF-16");
                                                                   return;
                                                               }
                                                               break;
                                                           case 255:
                                                               if ((buf[1] &
                                                                      255) ==
                                                                     254) {
                                                                   charDecoder =
                                                                     createCharDecoder(
                                                                       pbis,
                                                                       "UTF-16");
                                                                   return;
                                                               }
                                                       }
                                       }
                                       encod =
                                         encod ==
                                           null
                                           ? "UTF-8"
                                           : encod;
                                       charDecoder =
                                         createCharDecoder(
                                           pbis,
                                           encod);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Z2QdXv4PyeagfW0RAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "iyb+fwG8ZxWSdxwAAA==");
}
