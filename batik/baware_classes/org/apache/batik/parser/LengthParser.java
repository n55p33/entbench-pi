package org.apache.batik.parser;
public class LengthParser extends org.apache.batik.parser.AbstractParser {
    protected org.apache.batik.parser.LengthHandler lengthHandler;
    public LengthParser() { super();
                            lengthHandler = org.apache.batik.parser.DefaultLengthHandler.
                                              INSTANCE; }
    public void setLengthHandler(org.apache.batik.parser.LengthHandler handler) {
        lengthHandler =
          handler;
    }
    public org.apache.batik.parser.LengthHandler getLengthHandler() {
        return lengthHandler;
    }
    protected void doParse() throws org.apache.batik.parser.ParseException,
        java.io.IOException { lengthHandler.startLength();
                              current = reader.read();
                              skipSpaces();
                              parseLength();
                              skipSpaces();
                              if (current != -1) { reportError(
                                                     "end.of.stream.expected",
                                                     new java.lang.Object[] { new java.lang.Integer(
                                                       current) });
                              }
                              lengthHandler.endLength(
                                              ); }
    protected void parseLength() throws org.apache.batik.parser.ParseException,
        java.io.IOException { int mant = 0;
                              int mantDig = 0;
                              boolean mantPos = true;
                              boolean mantRead = false;
                              int exp = 0;
                              int expDig = 0;
                              int expAdj = 0;
                              boolean expPos = true;
                              int unitState = 0;
                              switch (current) { case '-':
                                                     mantPos =
                                                       false;
                                                 case '+':
                                                     current =
                                                       reader.
                                                         read(
                                                           );
                              }
                              m1: switch (current) {
                                  default:
                                      reportUnexpectedCharacterError(
                                        current);
                                      return;
                                  case '.':
                                      break;
                                  case '0':
                                      mantRead =
                                        true;
                                      l: for (;
                                              ;
                                              ) {
                                          current =
                                            reader.
                                              read(
                                                );
                                          switch (current) {
                                              case '1':
                                              case '2':
                                              case '3':
                                              case '4':
                                              case '5':
                                              case '6':
                                              case '7':
                                              case '8':
                                              case '9':
                                                  break l;
                                              default:
                                                  break m1;
                                              case '0':
                                          }
                                      }
                                  case '1':
                                  case '2':
                                  case '3':
                                  case '4':
                                  case '5':
                                  case '6':
                                  case '7':
                                  case '8':
                                  case '9':
                                      mantRead =
                                        true;
                                      l: for (;
                                              ;
                                              ) {
                                          if (mantDig <
                                                9) {
                                              mantDig++;
                                              mant =
                                                mant *
                                                  10 +
                                                  (current -
                                                     '0');
                                          }
                                          else {
                                              expAdj++;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          switch (current) {
                                              default:
                                                  break l;
                                              case '0':
                                              case '1':
                                              case '2':
                                              case '3':
                                              case '4':
                                              case '5':
                                              case '6':
                                              case '7':
                                              case '8':
                                              case '9':
                                          }
                                      }
                              }
                              if (current == '.') {
                                  current =
                                    reader.
                                      read(
                                        );
                                  m2: switch (current) {
                                      default:
                                      case 'e':
                                      case 'E':
                                          if (!mantRead) {
                                              reportUnexpectedCharacterError(
                                                current);
                                              return;
                                          }
                                          break;
                                      case '0':
                                          if (mantDig ==
                                                0) {
                                              l: for (;
                                                      ;
                                                      ) {
                                                  current =
                                                    reader.
                                                      read(
                                                        );
                                                  expAdj--;
                                                  switch (current) {
                                                      case '1':
                                                      case '2':
                                                      case '3':
                                                      case '4':
                                                      case '5':
                                                      case '6':
                                                      case '7':
                                                      case '8':
                                                      case '9':
                                                          break l;
                                                      default:
                                                          break m2;
                                                      case '0':
                                                  }
                                              }
                                          }
                                      case '1':
                                      case '2':
                                      case '3':
                                      case '4':
                                      case '5':
                                      case '6':
                                      case '7':
                                      case '8':
                                      case '9':
                                          l: for (;
                                                  ;
                                                  ) {
                                              if (mantDig <
                                                    9) {
                                                  mantDig++;
                                                  mant =
                                                    mant *
                                                      10 +
                                                      (current -
                                                         '0');
                                                  expAdj--;
                                              }
                                              current =
                                                reader.
                                                  read(
                                                    );
                                              switch (current) {
                                                  default:
                                                      break l;
                                                  case '0':
                                                  case '1':
                                                  case '2':
                                                  case '3':
                                                  case '4':
                                                  case '5':
                                                  case '6':
                                                  case '7':
                                                  case '8':
                                                  case '9':
                                              }
                                          }
                                  }
                              }
                              boolean le = false;
                              es: switch (current) {
                                  case 'e':
                                      le =
                                        true;
                                  case 'E':
                                      current =
                                        reader.
                                          read(
                                            );
                                      switch (current) {
                                          default:
                                              reportUnexpectedCharacterError(
                                                current);
                                              return;
                                          case 'm':
                                              if (!le) {
                                                  reportUnexpectedCharacterError(
                                                    current);
                                                  return;
                                              }
                                              unitState =
                                                1;
                                              break es;
                                          case 'x':
                                              if (!le) {
                                                  reportUnexpectedCharacterError(
                                                    current);
                                                  return;
                                              }
                                              unitState =
                                                2;
                                              break es;
                                          case '-':
                                              expPos =
                                                false;
                                          case '+':
                                              current =
                                                reader.
                                                  read(
                                                    );
                                              switch (current) {
                                                  default:
                                                      reportUnexpectedCharacterError(
                                                        current);
                                                      return;
                                                  case '0':
                                                  case '1':
                                                  case '2':
                                                  case '3':
                                                  case '4':
                                                  case '5':
                                                  case '6':
                                                  case '7':
                                                  case '8':
                                                  case '9':
                                              }
                                          case '0':
                                          case '1':
                                          case '2':
                                          case '3':
                                          case '4':
                                          case '5':
                                          case '6':
                                          case '7':
                                          case '8':
                                          case '9':
                                      }
                                      en: switch (current) {
                                          case '0':
                                              l: for (;
                                                      ;
                                                      ) {
                                                  current =
                                                    reader.
                                                      read(
                                                        );
                                                  switch (current) {
                                                      case '1':
                                                      case '2':
                                                      case '3':
                                                      case '4':
                                                      case '5':
                                                      case '6':
                                                      case '7':
                                                      case '8':
                                                      case '9':
                                                          break l;
                                                      default:
                                                          break en;
                                                      case '0':
                                                  }
                                              }
                                          case '1':
                                          case '2':
                                          case '3':
                                          case '4':
                                          case '5':
                                          case '6':
                                          case '7':
                                          case '8':
                                          case '9':
                                              l: for (;
                                                      ;
                                                      ) {
                                                  if (expDig <
                                                        3) {
                                                      expDig++;
                                                      exp =
                                                        exp *
                                                          10 +
                                                          (current -
                                                             '0');
                                                  }
                                                  current =
                                                    reader.
                                                      read(
                                                        );
                                                  switch (current) {
                                                      default:
                                                          break l;
                                                      case '0':
                                                      case '1':
                                                      case '2':
                                                      case '3':
                                                      case '4':
                                                      case '5':
                                                      case '6':
                                                      case '7':
                                                      case '8':
                                                      case '9':
                                                  }
                                              }
                                      }
                                  default:
                              }
                              if (!expPos) {
                                  exp =
                                    -exp;
                              }
                              exp += expAdj;
                              if (!mantPos) {
                                  mant =
                                    -mant;
                              }
                              lengthHandler.
                                lengthValue(
                                  org.apache.batik.parser.NumberParser.
                                    buildFloat(
                                      mant,
                                      exp));
                              switch (unitState) {
                                  case 1:
                                      lengthHandler.
                                        em(
                                          );
                                      current =
                                        reader.
                                          read(
                                            );
                                      return;
                                  case 2:
                                      lengthHandler.
                                        ex(
                                          );
                                      current =
                                        reader.
                                          read(
                                            );
                                      return;
                              }
                              switch (current) {
                                  case 'e':
                                      current =
                                        reader.
                                          read(
                                            );
                                      switch (current) {
                                          case 'm':
                                              lengthHandler.
                                                em(
                                                  );
                                              current =
                                                reader.
                                                  read(
                                                    );
                                              break;
                                          case 'x':
                                              lengthHandler.
                                                ex(
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
                                      break;
                                  case 'p':
                                      current =
                                        reader.
                                          read(
                                            );
                                      switch (current) {
                                          case 'c':
                                              lengthHandler.
                                                pc(
                                                  );
                                              current =
                                                reader.
                                                  read(
                                                    );
                                              break;
                                          case 't':
                                              lengthHandler.
                                                pt(
                                                  );
                                              current =
                                                reader.
                                                  read(
                                                    );
                                              break;
                                          case 'x':
                                              lengthHandler.
                                                px(
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
                                      break;
                                  case 'i':
                                      current =
                                        reader.
                                          read(
                                            );
                                      if (current !=
                                            'n') {
                                          reportCharacterExpectedError(
                                            'n',
                                            current);
                                          break;
                                      }
                                      lengthHandler.
                                        in(
                                          );
                                      current =
                                        reader.
                                          read(
                                            );
                                      break;
                                  case 'c':
                                      current =
                                        reader.
                                          read(
                                            );
                                      if (current !=
                                            'm') {
                                          reportCharacterExpectedError(
                                            'm',
                                            current);
                                          break;
                                      }
                                      lengthHandler.
                                        cm(
                                          );
                                      current =
                                        reader.
                                          read(
                                            );
                                      break;
                                  case 'm':
                                      current =
                                        reader.
                                          read(
                                            );
                                      if (current !=
                                            'm') {
                                          reportCharacterExpectedError(
                                            'm',
                                            current);
                                          break;
                                      }
                                      lengthHandler.
                                        mm(
                                          );
                                      current =
                                        reader.
                                          read(
                                            );
                                      break;
                                  case '%':
                                      lengthHandler.
                                        percentage(
                                          );
                                      current =
                                        reader.
                                          read(
                                            );
                                      break;
                              } }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "9AMu7nneZc0P/wuQiFqF9xkAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Zs1P7pvvWc93Q0ClquxZ8A/B5xR4/id7MnTZwDba3orthfz7DmK+B6LRTVYe" +
       "dQjRUcBcjuUNIfTQK8eoPeitv8vactY8viWielXt+umsaSenAOXXlnfru8Xs" +
       "d//K3F2Tdd8MPFSQJ8lghWY6opXLsB0Ca7Hki/sccYBwoF4XF1Z9n4ELuWVk" +
       "B7m7zTRP0Nr+P9MKNP/mQ2SUC5LW9//jB772aw9+C6gnCV0bZ6oDtPLIjsMo" +
       "y+N/+YUP3X3DM99+f+5wwXFxv/jynY9nWLlX4jhrRllD77N6Z8bqOM9UKDEI" +
       "B7mPVJWc21e0Sto3bRBK4r0kFX7i1m8tP/KdT24T0JMmeAJYfeqZX/nh7tPP" +
       "7BxJ+x+8LPM+umab+udE37QnYR+6/5V2yVfg//TpJ77w8See3FJ16/EktgPe" +
       "0T75V//9td1nv/2VK2RSpy33RzjY8KbPEpWgh+5/KG6uVtEpmzgxMotgIt2M" +
       "Gu2FXjfbKjMT260FXjIpu470Zjit1vpok7Hmqq3UlaIiOYJtj+xmOQ0aEw6l" +
       "Jpg7rSy7PTLeGCy6xns8L0yXwcTkuhNuOF6RtNnjXNPSKkZ3Y2F8ke2VtLDY" +
       "jGB6Xi7yK6Ef2WFNqxfq9aheiLVmQa+qa46zUWFFbtxhEbMVu4e3rHnVXG8m" +
       "CcrwUtWZz83iirZGXbju1xrNaQVeuRs9MZiyseGCpdkV+kQn1T2JXC3tpG/g" +
       "aX+DJ8kCX3XIwbxTXfRtw2thZSa1hnOOFygvaM2dRRd1hkHfbXHD1YbqDMgx" +
       "TqGdGbX2sUlv2CSDQaOOsGG3KfTtSdNZmkm6RCsVgfXscinteaJejxN2ULH7" +
       "3U1HTykyQoZd2xz6pjUZT/kFKvQtXUL6IKx1+AblY8WUacwmk6ipjjxyVcVU" +
       "weCUqcs1YJldJkN73E4G3dWGXcvcciEh7rRgBAtsJSetSak1G1HsqsPOR2ux" +
       "U5XstVdGiu3phPDQSsFnnD7bn/E9ybVNi6+Yo7awKSe9dEPPRx3R9r3Us1rl" +
       "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" +
       "q+n/C8XYggVtJAAA");
}
