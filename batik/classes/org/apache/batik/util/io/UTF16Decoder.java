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
    public static final long jlc$SourceLastModified$jl7 = 1471109864000L;
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
                                                              "uarcGd/bUCfQWboe2ODOeGrquIgbzBqA1dFYn6475XR1l86dfKRwIGHj8/yR" +
                                                              "Dd/6D7ddBTWQGAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "6p8+8+wffeLZ92zFuOf4moAES95P/dV/f2X3hW9+6QZl6aziebYub323cUKx" +
       "+6bNnntZ89b8VTVr3rY1OPZD+cYW9oH86fZbm4jKlquHaf+B/+zbyrv/4T+u" +
       "C5C8Wt3AaifwJfilj1wm3vbtHP+wbGTYD6XXV3OwtD/ELX/S+bedx8782Q50" +
       "VoIuqXv7BkG2kywZS2CtHO1vJsDe4tj74+ve7SLv6kFZfONJtzky7cmCdWgu" +
       "0M+gs/6FEzXqrkzLj4Dvlb2IuXIy2E5BeWe6jbe8vZI1P7ZfEs77oRcDLnUt" +
       "p02DEcUySVez5LwmUYfhmttf/EH253Iy6SlA+3R5t7ZbzJ6fufH8t2XdHwd1" +
       "Kcp3RwDDsFzZ3ufk/rmtXtmPDwHsloADXJnbtf1kfCnPa5mqd7dbjBO80j80" +
       "r8A37zok1vXAbuW9//iBr7z/8W8AB2pDp5eZcYHfHJmxl2QbuF966YMPvu75" +
       "b743L7NAocIvvHr56Yzq4lYSZ42WNfq+qJczUbl8hdqVo5jNK6OuHUhLHJGn" +
       "FYP66v0fpI3v/ASDRC18/9MVRB1JeSFdwCwcFwblxoworIg10pwVpRJHrMSp" +
       "PGEkSTL6A6cx82r9CaquNXaTTJfTwRLV0I1W1itFU+vhqN/q4G1K0TRY7lik" +
       "HShy0CPLDqkofjxZdIUg7IyFoGUH7bYqBaNOxeiDhVsiFqSp2B1xusK6036h" +
       "jlY2hgYvdazYLZWItiw3Jl7cLvcDfhzVSl1fHIgs6az5Ou0kQ8MZBVPGghsG" +
       "ZlfiSjqi/SnFO3XJcZFRr2gVx+2JS/NiEjkzLiTnTI3gnTUjsjQrLlIzW/JO" +
       "Gb7dTjBaKI/akluWeZcgWnJK8mzPodrNsW3xWM9jO3TQXvFlCyaUUagy9nxm" +
       "BfZ8hK0tYYn5jYpui6Kkiti6ynkDV8THBcIbTXib9nu9sk+WipSv8VWFplrl" +
       "8mKdxoNqI4qoyYqtibPxSog3mIBp/R6S+NVQbKATQSyt6+pGS3scT0gd1hv7" +
       "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" +
       "Nl3VySqv2+uCkehwTNZLYBde9av80CFlv2sT02nN7gYK1+jRTG/akmx1Epoz" +
       "VepsECKQ5JnbZKcLbb3U5kHIur3IlXUvVOr6nIHbw3kRpDOy3JEkOW4liRyC" +
       "ZSus8IQxnCieXu43+zodBknLVDaNAC9plOhWkRo6HZXselUzOqNVi2bmdXg9" +
       "ampwtVnTtMZ4MqTB1izbsq1e21by7nzXfHBLB3aQ2YvXsltMb3Q6l3/OQCdu" +
       "dk6ezj2wfyoYQg/e7PItP7z62Luff1Hrf7y0s3fO1I6h87Hn/4StL3X7CKls" +
       "a/7UzY+N2Pzu8fDs5gvv/pfL47fNnnkNtxwPn+DzJMnfZV/6Ev0m9dd2oNsO" +
       "TnKuuxU9jnT1+PnNhVCPk9AdHzvFefBAsxf3j0yHe5od3uLI9LojnNwLtra/" +
       "xTHer974WDt7RHKA92fNczF0LtRljZjtXXWfOHa4zdq7P89d6Jdf01FgDN1x" +
       "9MYrO75/4LpL9O3Fr/rpFy+eu/9F/q/zS5+Dy9nzXeickdj20ZOxI/0zfqgb" +
       "Vi7M+e05mZ//fDiGHrjZJVwM7VhezusLW+CPxNC9NwSOoduzn6OwvxlDl07C" +
       "xtDp/Pco3G/F0IVDuBg6s+0cBfk40C0Aybq/7e8fb735pleHuBLFoazGmZ32" +
       "9JmeOh5/B1a65wdZ6UjIPn4s0PJ/QuwHRbL9L8Q19TMvtnvveKX68e3FlmrL" +
       "m01G5VwXOru9YzsIrEdvSm2f1hnmyVfv+uz5J/aTwF1bhg/d/QhvD9/4Fol0" +
       "/Di/99n84f2//5bfefHr+Unc/wKfEc+loiIAAA==");
}
