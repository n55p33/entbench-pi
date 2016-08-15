package org.apache.batik.util.io;
public class UTF16Decoder extends org.apache.batik.util.io.AbstractCharDecoder {
    protected boolean bigEndian;
    public UTF16Decoder(java.io.InputStream is) throws java.io.IOException {
        super(
          is);
        int b1 =
          is.
          read(
            );
        if (b1 ==
              -1) {
            endOfStreamError(
              "UTF-16");
        }
        int b2 =
          is.
          read(
            );
        if (b2 ==
              -1) {
            endOfStreamError(
              "UTF-16");
        }
        int m =
          (b1 &
             255) <<
          8 |
          b2 &
          255;
        switch (m) {
            case 65279:
                bigEndian =
                  true;
                break;
            case 65534:
                break;
            default:
                charError(
                  "UTF-16");
        }
    }
    public UTF16Decoder(java.io.InputStream is, boolean be) { super(is);
                                                              bigEndian =
                                                                be; }
    public int readChar() throws java.io.IOException { if (position == count) {
                                                           fillBuffer(
                                                             );
                                                       }
                                                       if (count == -1) {
                                                           return END_OF_STREAM;
                                                       }
                                                       byte b1 = buffer[position++];
                                                       if (position == count) {
                                                           fillBuffer(
                                                             );
                                                       }
                                                       if (count == -1) {
                                                           endOfStreamError(
                                                             "UTF-16");
                                                       }
                                                       byte b2 = buffer[position++];
                                                       int c = bigEndian ? (b1 &
                                                                              255) <<
                                                         8 |
                                                         b2 &
                                                         255
                                                         : (b2 &
                                                              255) <<
                                                         8 |
                                                         b1 &
                                                         255;
                                                       if (c == 65534) {
                                                           charError(
                                                             "UTF-16");
                                                       }
                                                       return c; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVYe4xUVxk/M/t+P2BhC+wCy4Dh0Z1SCwYXaWHZZZfOPmBh" +
                                                              "o7OW5cydMzuXvXPv5d5zd2e30gdNA5pIKAJFbdd/aKiElqbaqNE2mEbbptWk" +
                                                              "LVqrKTVqIlqJJcZqRK3fOefeuY+ZXYLRSebMnXO+853zfd/ve90L11CJaaBW" +
                                                              "otJ2OqUTs71LpYPYMEmyU8GmuQfmRqXHi/Bf9l3t3xRGpXFUm8Zmn4RN0i0T" +
                                                              "JWnGUYusmhSrEjH7CUmyHYMGMYkxgamsqXHUJJu9GV2RJZn2aUnCCIaxEUMN" +
                                                              "mFJDTliU9NoMKGqJwU2i/CbRrcHljhiqljR9yiVv9pB3elYYZcY9y6SoPnYA" +
                                                              "T+CoRWUlGpNN2pE10FpdU6bGFI22kyxtP6BssFWwM7YhTwVtz9V9dON4up6r" +
                                                              "YB5WVY1y8czdxNSUCZKMoTp3tkshGfMgegAVxVCVh5iiSMw5NAqHRuFQR1qX" +
                                                              "Cm5fQ1Qr06lxcajDqVSX2IUoWu5nomMDZ2w2g/zOwKGc2rLzzSDtspy0Qso8" +
                                                              "EU+tjZ58fF/980WoLo7qZHWIXUeCS1A4JA4KJZkEMcytySRJxlGDCsYeIoaM" +
                                                              "FXnatnSjKY+pmFpgfkctbNLSicHPdHUFdgTZDEuimpETL8UBZf8rSSl4DGRd" +
                                                              "4MoqJOxm8yBgpQwXM1IYcGdvKR6X1SRFS4M7cjJG7gUC2FqWITSt5Y4qVjFM" +
                                                              "oEYBEQWrY9EhgJ46BqQlGgDQoGjRrEyZrnUsjeMxMsoQGaAbFEtAVcEVwbZQ" +
                                                              "1BQk45zASosCVvLY51r/5mP3qz1qGIXgzkkiKez+VbCpNbBpN0kRg4AfiI3V" +
                                                              "a2Kn8YIXj4YRAuKmALGg+c4Xrt+zrvXSq4JmcQGagcQBItFR6Wyi9s0lnas3" +
                                                              "FbFrlOuaKTPj+yTnXjZor3RkdYgwC3Ic2WK7s3hp948/99B58kEYVfaiUklT" +
                                                              "rAzgqEHSMrqsEGMHUYmBKUn2ogqiJjv5ei8qg+eYrBIxO5BKmYT2omKFT5Vq" +
                                                              "/D+oKAUsmIoq4VlWU5rzrGOa5s9ZHSFUBl9UDd+lSHz4L0Wfjaa1DIliCauy" +
                                                              "qkUHDY3Jb0Yh4iRAt+loAlA/HjU1ywAIRjVjLIoBB2liL3AlyFp0757u9Ru3" +
                                                              "EwnCkdHOEKb/H3lnmVzzJkMhUPmSoMMr4Cs9mgK0o9JJa1vX9WdHXxdgYg5g" +
                                                              "a4SilXBcuziunR8nTCZr7d7jUCjET5nPjhUUYJJxcG6IrtWrh+7buf9oWxGg" +
                                                              "SZ8sBn2GgbTNl2U63QjghO1R6WJjzfTyK+tfDqPiGGrEErWwwpLGVmMMwpE0" +
                                                              "bntsdQLyj5sGlnnSAMtfhiaRJESh2dKBzaVcmyAGm6dovoeDk6SYO0ZnTxEF" +
                                                              "748unZl8ePjBO8Io7I/87MgSCFps+yCL17m4HAl6fCG+dUeufnTx9CHN9X1f" +
                                                              "KnEyYN5OJkNbEAdB9YxKa5bhF0ZfPBThaq+A2Ewx+BKEvdbgGb7Q0uGEaSZL" +
                                                              "OQic0owMVtiSo+NKmja0SXeGA7SBP88HWFQxX1sI37W28/FftrpAZ+NCAWiG" +
                                                              "s4AUPA18Zkh/8hc//cMnubqdjFHnSfVDhHZ4ohRj1sjjUYML2z0GIUD33pnB" +
                                                              "r5y6dmSEYxYoVhQ6MMLGTohOYEJQ86OvHnz3/StnL4dzOA9RSNNWAqqdbE5I" +
                                                              "No8q5xASTlvl3geinALRgKEmslcFfMopGScUwhzrn3Ur17/wp2P1AgcKzDgw" +
                                                              "WndzBu78bdvQQ6/v+1srZxOSWJZ1deaSidA9z+W81TDwFLtH9uG3Wr76Cn4S" +
                                                              "kgAEXlOeJjyWhoQOuOTN1N4JgaNX1S0KOZXgDDfoBk5xBx/vmmvfQFdWIjq7" +
                                                              "C9+3iQ0rTa/T+P3SU0WNSscvf1gz/OFL17mU/jLMi5E+rHcIWLJhVRbYLwwG" +
                                                              "tR5spoHurkv9n69XLt0AjnHgKEFwNgcMiIZZH6Js6pKyX/7w5QX73yxC4W5U" +
                                                              "qWg42Y25c6IK8ApipiEWZ/W77xGgmCyHoZ49ZVFOMYgrBmXzJphhlhY2eVdG" +
                                                              "p9xI099d+O3N52aucHTqnEVLvuf12KDsKex5bPwEG9bm43m2rQHrhkUGYH83" +
                                                              "+tMAC7VDVsKEkC1nwEMn7IrlzsH90tHI4O9ENXJbgQ2Crunp6JeH3znwBvf/" +
                                                              "cpYU2Dw7qMYT8iF5eIJPvZDjY/iE4Ptv9mX3ZxMi8zd22uXHslz9oesMFqvn" +
                                                              "aBj8AkQPNb4//sTVZ4QAwfosQEyOnvzSx+3HTgqnFkXsirw60rtHFLJCHDYM" +
                                                              "sNstn+sUvqP79xcPff/pQ0fErRr9JVkXdBzP/Pxfb7Sf+fVrBaqCsoSmKQSr" +
                                                              "eT4LodlvHyHU9i/W/eB4Y1E3pJReVG6p8kGL9Ca9XKEON62Ex2BugcwnvOIx" +
                                                              "41AUWgN24NP3BiDmuAX7v48N3XxpMxt2CO+5+790NDbRpYuFxTmZl/hqGd4K" +
                                                              "u+n0/Nuf+tm5x05PCj3PgZrAvuZ/DCiJw7/5e17A4tVDASAF9sejF55Y1Lnl" +
                                                              "A77fTeNsdySbXxBCKeTuvfN85q/httIfhVFZHNVLdus5jBWLJcc4tFum049C" +
                                                              "e+pb97dOok/oyJUpS4JI9hwbLCC84CimPiC4NUMts8sy+Ebs8BMJRq4Q4g8H" +
                                                              "RPDi4xo23O6k6Ard0CjckiQDWbpmDrawLSGPdalJGfNCot8NkBxn43PgLFso" +
                                                              "jvJPKQp0HsE4uthBpoFaZmsOuXefPXxyJjnw1Pqw7QfDcGGq6bcrZIIoAfi2" +
                                                              "+ODbx9thFwvv1Z747fciY9tupQpnc603qbPZ/6UAxDWze0TwKq8c/uOiPVvS" +
                                                              "+2+hoF4a0FKQ5Tf7Lry2Y5V0Isx7fwHSvHcG/k0dfmhWGoRahuqPVCtydq1z" +
                                                              "Uusu2667bj21zrZ1jrj3SOGiiv39NCd4lA0PUFQOdViyM20bKGYnEPazy/O8" +
                                                              "l6Ii2X75FGA3knVR/+D/JLpSVO1tLll105z3vkq8Y5GenakrXziz9x2Oztx7" +
                                                              "kGrAWcpSFG8E8TyX6gZJyVwN1SKe6PznBEXNs/W7FIVljV/5MUF8iqKmgsQU" +
                                                              "FbMfL+0ZiuqDtBSV8F8v3dcpqnTpoHsQD16SGbAEkLDHb+hOjbxu1i59K5RH" +
                                                              "Bjgts7Ctz2zIH0py1mu6mfU80WeFz2v5S0fHwyzx2hH695md/fdf3/iUaMgk" +
                                                              "BU9PMy5VkOtFb5jz0uWzcnN4lfasvlH7XMVKJ541iAu7vrPYA/4ugKbOYLMo" +
                                                              "0K2YkVzT8u7ZzS/95GjpW5AeR1AIQ58xkp+3sroF4XEkll/TQETjbVTH6q9N" +
                                                              "bVmX+vOveF2dXw8E6Uely+fue/tE81lot6p6UQmEapLlCXX7lLqbSBNGHNXI" +
                                                              "ZlcWrghcZKz4CqZahnDMXkdyvdjqrMnNsnaeorb8ejH/JQj0IJPE2KZZatIu" +
                                                              "uarcGd/bUCfQWboe2ODOeGrquIgbzBqA1dFYn6475XS1pHMnHykcSNj4PH9k" +
                                                              "w7f+AwHmCjmQGAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "3/ts/uD+33vTb7/4tfwk7n8Bf2a/zaIiAAA=");
}
