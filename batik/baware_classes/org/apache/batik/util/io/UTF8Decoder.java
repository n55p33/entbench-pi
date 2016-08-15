package org.apache.batik.util.io;
public class UTF8Decoder extends org.apache.batik.util.io.AbstractCharDecoder {
    protected static final byte[] UTF8_BYTES = { 1, 1, 1, 1, 1, 1, 1, 1, 1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    3,
    3,
    3,
    3,
    3,
    3,
    3,
    3,
    3,
    3,
    3,
    3,
    3,
    3,
    3,
    3,
    4,
    4,
    4,
    4,
    4,
    4,
    4,
    4,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0 };
    protected int nextChar = -1;
    public UTF8Decoder(java.io.InputStream is) { super(is); }
    public int readChar() throws java.io.IOException { if (nextChar != -1) {
                                                           int result =
                                                             nextChar;
                                                           nextChar =
                                                             -1;
                                                           return result;
                                                       }
                                                       if (position == count) {
                                                           fillBuffer(
                                                             );
                                                       }
                                                       if (count == -1) {
                                                           return END_OF_STREAM;
                                                       }
                                                       int b1 = buffer[position++] &
                                                         255;
                                                       switch (UTF8_BYTES[b1]) {
                                                           default:
                                                               charError(
                                                                 "UTF-8");
                                                           case 1:
                                                               return b1;
                                                           case 2:
                                                               if (position ==
                                                                     count) {
                                                                   fillBuffer(
                                                                     );
                                                               }
                                                               if (count ==
                                                                     -1) {
                                                                   endOfStreamError(
                                                                     "UTF-8");
                                                               }
                                                               return (b1 &
                                                                         31) <<
                                                                 6 |
                                                                 buffer[position++] &
                                                                 63;
                                                           case 3:
                                                               if (position ==
                                                                     count) {
                                                                   fillBuffer(
                                                                     );
                                                               }
                                                               if (count ==
                                                                     -1) {
                                                                   endOfStreamError(
                                                                     "UTF-8");
                                                               }
                                                               int b2 =
                                                                 buffer[position++];
                                                               if (position ==
                                                                     count) {
                                                                   fillBuffer(
                                                                     );
                                                               }
                                                               if (count ==
                                                                     -1) {
                                                                   endOfStreamError(
                                                                     "UTF-8");
                                                               }
                                                               int b3 =
                                                                 buffer[position++];
                                                               if ((b2 &
                                                                      192) !=
                                                                     128 ||
                                                                     (b3 &
                                                                        192) !=
                                                                     128) {
                                                                   charError(
                                                                     "UTF-8");
                                                               }
                                                               return (b1 &
                                                                         31) <<
                                                                 12 |
                                                                 (b2 &
                                                                    63) <<
                                                                 6 |
                                                                 b3 &
                                                                 31;
                                                           case 4:
                                                               if (position ==
                                                                     count) {
                                                                   fillBuffer(
                                                                     );
                                                               }
                                                               if (count ==
                                                                     -1) {
                                                                   endOfStreamError(
                                                                     "UTF-8");
                                                               }
                                                               b2 =
                                                                 buffer[position++];
                                                               if (position ==
                                                                     count) {
                                                                   fillBuffer(
                                                                     );
                                                               }
                                                               if (count ==
                                                                     -1) {
                                                                   endOfStreamError(
                                                                     "UTF-8");
                                                               }
                                                               b3 =
                                                                 buffer[position++];
                                                               if (position ==
                                                                     count) {
                                                                   fillBuffer(
                                                                     );
                                                               }
                                                               if (count ==
                                                                     -1) {
                                                                   endOfStreamError(
                                                                     "UTF-8");
                                                               }
                                                               int b4 =
                                                                 buffer[position++];
                                                               if ((b2 &
                                                                      192) !=
                                                                     128 ||
                                                                     (b3 &
                                                                        192) !=
                                                                     128 ||
                                                                     (b4 &
                                                                        192) !=
                                                                     128) {
                                                                   charError(
                                                                     "UTF-8");
                                                               }
                                                               int c =
                                                                 (b1 &
                                                                    31) <<
                                                                 18 |
                                                                 (b2 &
                                                                    63) <<
                                                                 12 |
                                                                 (b3 &
                                                                    31) <<
                                                                 6 |
                                                                 b4 &
                                                                 31;
                                                               nextChar =
                                                                 (c -
                                                                    65536) %
                                                                   1024 +
                                                                   56320;
                                                               return (c -
                                                                         65536) /
                                                                 1024 +
                                                                 55296;
                                                       }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "cU7/EX/E5sf/BmcmLWfCGwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
