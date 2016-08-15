package org.apache.batik.ext.awt.image.codec.tiff;
public class TIFFLZWDecoder {
    byte[][] stringTable;
    byte[] data = null;
    byte[] uncompData;
    int tableIndex;
    int bitsToGet = 9;
    int bytePointer;
    int bitPointer;
    int dstIndex;
    int w;
    int h;
    int predictor;
    int samplesPerPixel;
    int nextData = 0;
    int nextBits = 0;
    int[] andTable = { 511, 1023, 2047, 4095 };
    public TIFFLZWDecoder(int w, int predictor, int samplesPerPixel) { super(
                                                                         );
                                                                       this.
                                                                         w =
                                                                         w;
                                                                       this.
                                                                         predictor =
                                                                         predictor;
                                                                       this.
                                                                         samplesPerPixel =
                                                                         samplesPerPixel;
    }
    public byte[] decode(byte[] data, byte[] uncompData,
                         int h) { if (data[0] == (byte)
                                                   0 &&
                                        data[1] ==
                                        (byte)
                                          1) { throw new java.lang.UnsupportedOperationException(
                                                 "TIFFLZWDecoder0");
                                  }
                                  initializeStringTable(
                                    );
                                  this.data =
                                    data;
                                  this.h =
                                    h;
                                  this.uncompData =
                                    uncompData;
                                  bytePointer =
                                    0;
                                  bitPointer =
                                    0;
                                  dstIndex =
                                    0;
                                  nextData =
                                    0;
                                  nextBits =
                                    0;
                                  int code;
                                  int oldCode =
                                    0;
                                  byte[] string;
                                  while ((code =
                                            getNextCode(
                                              )) !=
                                           257 &&
                                           dstIndex !=
                                           uncompData.
                                             length) {
                                      if (code ==
                                            256) {
                                          initializeStringTable(
                                            );
                                          code =
                                            getNextCode(
                                              );
                                          if (code ==
                                                257) {
                                              break;
                                          }
                                          writeString(
                                            stringTable[code]);
                                          oldCode =
                                            code;
                                      }
                                      else {
                                          if (code <
                                                tableIndex) {
                                              string =
                                                stringTable[code];
                                              writeString(
                                                string);
                                              addStringToTable(
                                                stringTable[oldCode],
                                                string[0]);
                                              oldCode =
                                                code;
                                          }
                                          else {
                                              string =
                                                stringTable[oldCode];
                                              string =
                                                composeString(
                                                  string,
                                                  string[0]);
                                              writeString(
                                                string);
                                              addStringToTable(
                                                string);
                                              oldCode =
                                                code;
                                          }
                                      }
                                  }
                                  if (predictor ==
                                        2) {
                                      int count;
                                      for (int j =
                                             0;
                                           j <
                                             h;
                                           j++) {
                                          count =
                                            samplesPerPixel *
                                              (j *
                                                 w +
                                                 1);
                                          for (int i =
                                                 samplesPerPixel;
                                               i <
                                                 w *
                                                 samplesPerPixel;
                                               i++) {
                                              uncompData[count] +=
                                                uncompData[count -
                                                             samplesPerPixel];
                                              count++;
                                          }
                                      }
                                  }
                                  return uncompData;
    }
    public void initializeStringTable() {
        stringTable =
          (new byte[4096][]);
        for (int i =
               0;
             i <
               256;
             i++) {
            stringTable[i] =
              (new byte[1]);
            stringTable[i][0] =
              (byte)
                i;
        }
        tableIndex =
          258;
        bitsToGet =
          9;
    }
    public void writeString(byte[] string) {
        for (int i =
               0;
             i <
               string.
                 length;
             i++) {
            uncompData[dstIndex++] =
              string[i];
        }
    }
    public void addStringToTable(byte[] oldString,
                                 byte newString) {
        int length =
          oldString.
            length;
        byte[] string =
          new byte[length +
                     1];
        java.lang.System.
          arraycopy(
            oldString,
            0,
            string,
            0,
            length);
        string[length] =
          newString;
        stringTable[tableIndex++] =
          string;
        if (tableIndex ==
              511) {
            bitsToGet =
              10;
        }
        else
            if (tableIndex ==
                  1023) {
                bitsToGet =
                  11;
            }
            else
                if (tableIndex ==
                      2047) {
                    bitsToGet =
                      12;
                }
    }
    public void addStringToTable(byte[] string) {
        stringTable[tableIndex++] =
          string;
        if (tableIndex ==
              511) {
            bitsToGet =
              10;
        }
        else
            if (tableIndex ==
                  1023) {
                bitsToGet =
                  11;
            }
            else
                if (tableIndex ==
                      2047) {
                    bitsToGet =
                      12;
                }
    }
    public byte[] composeString(byte[] oldString,
                                byte newString) {
        int length =
          oldString.
            length;
        byte[] string =
          new byte[length +
                     1];
        java.lang.System.
          arraycopy(
            oldString,
            0,
            string,
            0,
            length);
        string[length] =
          newString;
        return string;
    }
    public int getNextCode() { try { nextData =
                                       nextData <<
                                         8 |
                                         data[bytePointer++] &
                                         255;
                                     nextBits +=
                                       8;
                                     if (nextBits <
                                           bitsToGet) {
                                         nextData =
                                           nextData <<
                                             8 |
                                             data[bytePointer++] &
                                             255;
                                         nextBits +=
                                           8;
                                     }
                                     int code =
                                       nextData >>
                                       nextBits -
                                       bitsToGet &
                                       andTable[bitsToGet -
                                                  9];
                                     nextBits -=
                                       bitsToGet;
                                     return code;
                               }
                               catch (java.lang.ArrayIndexOutOfBoundsException e) {
                                   return 257;
                               } }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL0aC3AV1fW+JISQEPLhF/mETwIK6nti/TFBlIREgg9IScQ2" +
       "KGGz775kyb7ddfe+5IHih44DdaaKNip2lNYpilUUx+pop37oOKJW6wxotZYR" +
       "+7Gt1TLKtLWOtrXn3Lvv7ee9XUg1vpm9u+/ec+753nPOvbv7jpExlknqqcai" +
       "bLNBrWirxjok06KJFlWyrC7o65HvLJb+vuH91YuLSGk3mdAvWatkyaJtClUT" +
       "VjeZqWgWkzSZWqspTSBGh0ktag5KTNG1bjJZsdpThqrIClulJygCrJPMOKmR" +
       "GDOV3jSj7fYEjMyMAycxzklsmX+4KU7Gy7qx2QGvc4G3uEYQMuXQshipjm+S" +
       "BqVYmilqLK5YrCljktMNXd3cp+osSjMsukk911bByvi5eSqY+2jVJ5/v7K/m" +
       "KpgoaZrOuHjWWmrp6iBNxEmV09uq0pR1FbmWFMdJhQuYkcZ4lmgMiMaAaFZa" +
       "Bwq4r6RaOtWic3FYdqZSQ0aGGJnjncSQTCllT9PBeYYZypgtO0cGaWfnpBVS" +
       "5ol4++mx4Ts3VD9WTKq6SZWidSI7MjDBgEg3KJSmeqlpLUskaKKb1Ghg7E5q" +
       "KpKqbLEtXWspfZrE0mD+rFqwM21Qk9N0dAV2BNnMtMx0MydekjuU/W9MUpX6" +
       "QNYpjqxCwjbsBwHLFWDMTErgdzZKyYCiJRiZ5cfIydh4KQAA6tgUZf16jlSJ" +
       "JkEHqRUuokpaX6wTXE/rA9AxOjigyci0wElR14YkD0h9tAc90gfXIYYAahxX" +
       "BKIwMtkPxmcCK03zWclln2Orl9x8tbZCKyIR4DlBZRX5rwCkeh/SWpqkJoV1" +
       "IBDHL4zfIU15ZkcRIQA82QcsYJ685vjFZ9QfeEnATC8As6Z3E5VZj7ynd8Kh" +
       "GS0LFhcjG2WGbilofI/kfJV12CNNGQMizJTcjDgYzQ4eWHvw29c/SD8sIuXt" +
       "pFTW1XQK/KhG1lOGolLzEqpRU2I00U7GUS3RwsfbyVh4jisaFb1rkkmLsnZS" +
       "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" +
       "NziRW/gjPu38H+v+/I7RLQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "2rSv2tp8plZbtXlikF0UzVQZGWM27duL");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("OSQE/dZ8Q8UN4JW7HLIIsg2iNcFqySZ6flaZZ9qETzBCsVhv01MEabYR9W46" +
       "TelQntd4i1ltFiFjqqbEZdxKw1NumUZE3bPqvcFKandw24PFztpYTptsgxmj" +
       "xKYRzjW0PVngRj/aLOdNJmyTFFPdLKEAYQbA7as0J0iCQ31emzsu6Y+Yeo+N" +
       "K0G3ozTQUdIKhq5FuOlCkxmdLsNstFjAcDNhEny1dbaUA4vLYMSlQxu4RpUh" +
       "mJSZUFPwzJfUNTzrLcOmy3T9eBHIgIfx4bgWZXEwbm97azLdyI2mOdPnacQL" +
       "ZdQ0ZR2m+25tnkVUN9Wm277HWmCtHXdRSOZ1gsWH86Tb0KCyD7n8bJtVHKmX" +
       "pMtmi8ysVVNFtPLMWJj2EBsKiaWWhXJ5HrRafNTQykaPrSzrySqc9qCuHDVD" +
       "wH9bb+SMGjYXjIRh2DayyQi2y1J92TYQFOOGZhWJoyz0FRpG+XRoKhAOhqDZ" +
       "JKiqXiV5r9aoWdFSBbJbTq+yHYYIHM6trjDsI/RMqIcs30xTrsMbI6Wta2Uq" +
       "6GIMmioOkm4qmlb1uqPMmPLQ0mRiuNkvJ2WIRKf0pN3Ot8f+7Oa27e4tdigP" +
       "jrWbNpon/Leb2JnbJe3e3h9srpf2d++PHYU+sntf5Hx4b5c2DEqPnnZavTiM" +
       "98VPvPyKOv7Z6tm9LV00Kt0Ref7321qi2Uequm23yXwAozj58zC4XtiD8cLJ" +
       "lwiHgl6lsjOFynaKOrG9fO5Qp7ODoDjod+be03eiz9yfB3dFpfNqcVSnKHmg" +
       "5DN332j782h1JwQtzt2+D1yf2xP0c2+PoEfRP3qdtMfz4OGo9IDhGlFxmEVj" +
       "jxwZu9YGcOIZ6qHw736rwj8Hrp/ZE/5n3h7hzxxmmBVSfuA6GriSB++LSndu" +
       "AiPSDnbzzzx5KOP736qMHXD94p6Mv/j2yHjkvU1hxItCmOZ1BP1LeQBHpUuS" +
       "qu71sVf08glpb7ibfyNp81PVr+1J+9o71KPd6wjay4MP3ljQD70FQQuCyk/q" +
       "vL4n6OvvZLcy15F2mgdUlB9YdXwvPLTgoxRFvwVRL+aRj4DrD/ZE/YO3R9Sj" +
       "Qnz4OmkfyQMeDNClFo20NML2GBg+FG9xM+KlUeme49+j5IfrH77q27jd91zK" +
       "l1+5ePtDr3D/eneydf+bqzvo0u16bNtHT/MeeT7vB5puFGLfsTvb6xeyaFHp" +
       "2Tf91Qzg2vyWC3BG3ZVfRaXLb6Z8fpYuvx8ta0Wlx65fFpQq7kdL5Z91nVYq" +
       "Kp0D4dHc66j0rmvlBjlBeDQniLp0Midov7gfzbeJShcO84EpePdwNEsGagdZ" +
       "8seP+dd4Q7s7rp2eOe667BtP6b4bGc8Rb+fpYyc6i68u909fxrvvLl9UvvLK" +
       "YPSx7zR+dvctjGJLWZbXcjtdum33WU5RaX6C88lTa9uv63z/2e/e80t3PLPv" +
       "P92zA3w44I5ge/zaH57gjh8Vn4pk/+ihX37h51/5w+KF8f8HgEhGKg47AAA=");
}
