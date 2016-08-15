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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "nNN/xB+x+fG/AdGdImvCGwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "LQ1LhwWwIlClKqxWq3WmvkmY4kjY9MNyfdRY1idDb7UchTPELxQHK0EatrR2" +
       "qYWJOlmurRZ8uTowEzIcOCgyKjjjYjRodfAhVavroV8j9A3TEqatEVlfqj7Z" +
       "IlawUSxNukMh9oByNGDe5nQS46ksr6dqarEcrA0JYGeJhxvcprognVl1rGA1" +
       "vOgL6Uwei6leLZfItVNWV5wdLlAYlcW221o6qyka48SGmpS7LDpoi6lUTYYg" +
       "Yyi7vD6kOyWRIrhWstQ3BFFV5KjXrJpLZ+KP1sUhKquc3qCYRRHxE2/DexI/" +
       "H+uYhFZKWuqxtF5VXSyudkm3VwM5wIputa1CTdeRVQGLQJS2ip2kUli505Za" +
       "qHQUkWAW5kwjJKvoDky9rnV6U6ucDClhYlbQaWdQ0KZmI173G8ONRvJKs7ee" +
       "rZeaHkmb8lCcqT1rtRCW7ViIVnJjOOB6NtIsjrtIp4N2cW6U6MVuOujjFs2u" +
       "1oWk1rQJyRuu28y8jqyTMrZgS8FibbUTUu9MrXGoG93KkBZXMAnyyW5ZqJZG" +
       "sbjA6poeIGhNtJqwNNRUOqGmG4Zur5D6PIWpQKtow0HcA6mGpBF8tYTWB5Jr" +
       "egu51XH4yIFJgfUW7Czs2+O1u1l7VWdDTxHFR+k6yC0QadguwWbaldUKZTqj" +
       "qSKPaBtDgOxIhoj8KKXgWrm1LtUKFbG6xks4J+OjBc7h8GAO8n1uAvjRZQ92" +
       "gS2BhCaZjwYxHIzKSsIxNX8+RUcU229wRj0m0UFCRuXiJqn4i0LS8vs9zsT6" +
       "S69jFxI7TP0eYte9lshWPX65KfaFyljsDpJaz0dSg8SoPoyjUyHd8LFarY+q" +
       "A0uR6z0DBIYFNmzMmMm0h7oRBiKO34TL49ocXhWUiNJTc4BhUV3lxonSr1li" +
       "gnVEs6gKRGXMNfkp0UprC8mlaThtFtLCnIAxlVC7ToITKwzLtsi/8uq27rfl" +
       "pxT73xqAHXvW8a5XsTtPD5017R/mQHuH7Q/u1h88dphz6LIDyg4x77veJwT5" +
       "AeYz737qaXX48dLO7kETH0FnI8//KVtLNPsQqu3BpL5PxvkM/V3gwXbJwI6f" +
       "KR0weu0DpTekr3R+9syxvutegg3bqaL52dlhPu4TWfGbEXQm0CR1/6TqQOa/" +
       "9UonIkcujyLopkNX3dm93d1XfTqz/dxDee7p82fuenryZ9ubgL1PMs72oTPz" +
       "2LYPX6Ucqp/2A21u5ISf3V6s+Pnr+Qi6+3qX7xG0Y3g5qc9tgT8TQXdcEziC" +
       "TmWvw7CfjaALx2Ej6Ib8fRjucxF07gAugk5vK4dBPh9BJwFIVv2Cv6eXN173" +
       "kwFMDqNAUvLTw115pieO2uu+km5/JSUdMvFHjhw6598/7R0Qx9svoK4ozz9N" +
       "0W97qfrx7Y22YkubTYblTB+6cXu5vn/I/NB1se3hOk0+9qNbP3320T2nuXVL" +
       "8IHFH6LtgWtfH7cdP8ovfDefu+v3nvjtp7+dnxT+F9jSX4yYJgAA");
}
