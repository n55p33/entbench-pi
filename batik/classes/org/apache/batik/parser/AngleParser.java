package org.apache.batik.parser;
public class AngleParser extends org.apache.batik.parser.NumberParser {
    protected org.apache.batik.parser.AngleHandler angleHandler = org.apache.batik.parser.DefaultAngleHandler.
                                                                    INSTANCE;
    public void setAngleHandler(org.apache.batik.parser.AngleHandler handler) {
        angleHandler =
          handler;
    }
    public org.apache.batik.parser.AngleHandler getAngleHandler() {
        return angleHandler;
    }
    protected void doParse() throws org.apache.batik.parser.ParseException,
        java.io.IOException { angleHandler.startAngle();
                              current = reader.read();
                              skipSpaces();
                              try { float f = parseFloat();
                                    angleHandler.angleValue(f);
                                    s: if (current != -1) { switch (current) {
                                                                case 13:
                                                                case 10:
                                                                case 32:
                                                                case 9:
                                                                    break s;
                                                            }
                                                            switch (current) {
                                                                case 'd':
                                                                    current =
                                                                      reader.
                                                                        read(
                                                                          );
                                                                    if (current !=
                                                                          'e') {
                                                                        reportCharacterExpectedError(
                                                                          'e',
                                                                          current);
                                                                        break;
                                                                    }
                                                                    current =
                                                                      reader.
                                                                        read(
                                                                          );
                                                                    if (current !=
                                                                          'g') {
                                                                        reportCharacterExpectedError(
                                                                          'g',
                                                                          current);
                                                                        break;
                                                                    }
                                                                    angleHandler.
                                                                      deg(
                                                                        );
                                                                    current =
                                                                      reader.
                                                                        read(
                                                                          );
                                                                    break;
                                                                case 'g':
                                                                    current =
                                                                      reader.
                                                                        read(
                                                                          );
                                                                    if (current !=
                                                                          'r') {
                                                                        reportCharacterExpectedError(
                                                                          'r',
                                                                          current);
                                                                        break;
                                                                    }
                                                                    current =
                                                                      reader.
                                                                        read(
                                                                          );
                                                                    if (current !=
                                                                          'a') {
                                                                        reportCharacterExpectedError(
                                                                          'a',
                                                                          current);
                                                                        break;
                                                                    }
                                                                    current =
                                                                      reader.
                                                                        read(
                                                                          );
                                                                    if (current !=
                                                                          'd') {
                                                                        reportCharacterExpectedError(
                                                                          'd',
                                                                          current);
                                                                        break;
                                                                    }
                                                                    angleHandler.
                                                                      grad(
                                                                        );
                                                                    current =
                                                                      reader.
                                                                        read(
                                                                          );
                                                                    break;
                                                                case 'r':
                                                                    current =
                                                                      reader.
                                                                        read(
                                                                          );
                                                                    if (current !=
                                                                          'a') {
                                                                        reportCharacterExpectedError(
                                                                          'a',
                                                                          current);
                                                                        break;
                                                                    }
                                                                    current =
                                                                      reader.
                                                                        read(
                                                                          );
                                                                    if (current !=
                                                                          'd') {
                                                                        reportCharacterExpectedError(
                                                                          'd',
                                                                          current);
                                                                        break;
                                                                    }
                                                                    angleHandler.
                                                                      rad(
                                                                        );
                                                                    current =
                                                                      reader.
                                                                        read(
                                                                          );
                                                                    break;
                                                                default:
                                                                    reportUnexpectedCharacterError(
                                                                      current);
                                                            }
                                    }
                                    skipSpaces(
                                      );
                                    if (current !=
                                          -1) {
                                        reportError(
                                          "end.of.stream.expected",
                                          new java.lang.Object[] { new java.lang.Integer(
                                            current) });
                                    } }
                              catch (java.lang.NumberFormatException e) {
                                  reportUnexpectedCharacterError(
                                    current);
                              }
                              angleHandler.
                                endAngle(
                                  ); }
    public AngleParser() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "GAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "8soT+ZCH8/JKVrxpP5QvuL4TAilVJef9WAjdJmb7SUe0FRC3+YjXASR+2c1n" +
       "j3gLZFlZyQpsu/y1m7rK1XzG5BQQ42x5F90tZu/dG4t6Oqv+HICeIE99wQjN" +
       "sEVzX+h7lqZ8ZR9sWCA38JUrSxPdl/9y7ubZquxu88cTsj72v5YVuPEdh8xo" +
       "B6SiH/iHD33zNx/9LvC1LnR2nfkBcLEjMw6iLDt/3/Mfvf/WZ773gRxJge3Z" +
       "X33pvicyrrOX0zgrBlkx3Ff1vkxVJk9AaDEI+zngqUqu7cuG2Mg3LLBHrPdS" +
       "T/ipu767+tT3P79NK0/G0wli9f3P/PpPdj/4zM6RZP7R6/Lpo2O2CX0u9O17" +
       "Fvahh19ulnwE8Y9ffOoPf/upp7dS3XU8NcXBl9fn//K/vrn7ie99/QYZ0hnT" +
       "+SkWNrz9yQ4SUNj+j2Z5FUlmbLKC+3BYoOuh70ptDHW6AmMpmNFYBLxFoq1i" +
       "aHfQbhGPNVoeSmo/Hc7X89G6qlRTpSzP2dJ6thiV2xTWM9vivDDm+wznepbb" +
       "dMNF2SpKomNJGjGZivZkVBz7gTzhl+KyNCyoBbQQ91ehPkDDFVqtpHahjlYK" +
       "dkWLJmrkbNz2JCnhzhSv+RN8WfLg8UyMpclwMw24TrDwrVmdXBBwFKlifVSZ" +
       "EEQJX87toI2veKrfZ/Axt2QmYtdYkQnvYkuSaE1oYcm2ZLLIyInJjk1jIvQS" +
       "q6muNmzTWQ09prlsDgf8VGzWLLarMV2Daw8Ww55pzBfdDlFYrQ2u3umuseWs" +
       "5y2lcCVp6GYU1ntIvEHrq02PdAdofzgdklWG4RG7S43KhD0pujWpVyyZgjsl" +
       "GIcmGvWFJDXbAUMibr84MoNNLFeWBUGMxrbFF9lJj9VGZXzVZwVkxS96JZUe" +
       "NfrBSio0yPkMn7UGmkH1VHc4xOkl1R4Px3opHDEOok0Gk7Sz0TYhp7c9xZty" +
       "WMexdHNFWaQibCplPt3042GHs3w/Xart0AhliSmGRmlclzmtXugNUM4t+ONW" +
       "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" +
       "Xt3X7p35h/3BLRH4yM06xq/iK2/b9XBWvOHg5CT/nXuZU9kjJ1dQ9uV6/80u" +
       "f/Kv1ufe+8yzyvAzpZ29Ez8xhC6EjvvzprpWzSOsTgNOb775F3o/v/s6PIn6" +
       "6nv/+b7p4/qTr+Ks/cETcp5k+Tv9579OvlH+8A50+uBc6rpbueODrh4/jbro" +
       "q2Hk29NjZ1L3H1j21sxiVfAU9yxbvPF5940PpHIv2K79iQPVU4cERE7wzpc5" +
       "cX1XVsQhdClQQ+zkcdbbjnjMkyF0Zu0YyqErJa90YHB0rrwhPND93qzxTeBB" +
       "93RH/290P6raB16m7zey4n1A7cVxtXOjHar49E+hYn7k+HrwPL6n4uOvVsX2" +
       "K6r48RN9O3nfzv5Z3htvdhaZ34Hhiay6B0ECyLcH+oazSw0P+vJpPpkVHw6h" +
       "84qTj8xe331opY+8GislIXTrkXu47CLh3usu9bcX0fIXnr10yz3Pzv4qv4o6" +
       "uCy+QEO3aJFpHj33PVI/5/qqZuRyX9ieArv5n+dC6J6b2CO7p8krubS/taX/" +
       "bAhdPkkfQmfzv0fpPhdCFw/pAKtt5SjJ50PoNCDJql9wX/GgeHsIujVPcuo4" +
       "vB7Y/K5XsvkRRH70GI7m/2ixj3nR9l8trslffLY7eMeLtc9sb89kU0zTjMst" +
       "NHR+e5F3gJsP35TbPq9zncdeuuNLF96wj/F3bAU+dPcjsj144+sp3HLD/EIp" +
       "/YN7fu+tn332O/lZ8P8Ai6AjEQEjAAA=");
}
