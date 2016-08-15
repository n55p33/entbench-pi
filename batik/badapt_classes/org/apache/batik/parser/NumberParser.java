package org.apache.batik.parser;
public abstract class NumberParser extends org.apache.batik.parser.AbstractParser {
    protected float parseFloat() throws org.apache.batik.parser.ParseException,
        java.io.IOException { int mant = 0;
                              int mantDig = 0;
                              boolean mantPos = true;
                              boolean mantRead = false;
                              int exp = 0;
                              int expDig = 0;
                              int expAdj = 0;
                              boolean expPos = true;
                              switch (current) { case '-': mantPos = false;
                                                 case '+':
                                                     current =
                                                       reader.
                                                         read(
                                                           ); }
                              m1: switch (current) { default: reportUnexpectedCharacterError(
                                                                current);
                                                              return 0.0F;
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
                                                                 case '.':
                                                                 case 'e':
                                                                 case 'E':
                                                                     break m1;
                                                                 default:
                                                                     return 0.0F;
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
                              if (current == '.') { current =
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
                                                                return 0.0F;
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
                                                                            if (!mantRead) {
                                                                                return 0.0F;
                                                                            }
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
                              switch (current) {
                                  case 'e':
                                  case 'E':
                                      current =
                                        reader.
                                          read(
                                            );
                                      switch (current) {
                                          default:
                                              reportUnexpectedCharacterError(
                                                current);
                                              return 0.0F;
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
                                                      return 0.0F;
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
                              return buildFloat(
                                       mant,
                                       exp);
    }
    public static float buildFloat(int mant,
                                   int exp) {
        if (exp <
              -125 ||
              mant ==
              0) {
            return 0.0F;
        }
        if (exp >=
              128) {
            return mant >
              0
              ? java.lang.Float.
                  POSITIVE_INFINITY
              : java.lang.Float.
                  NEGATIVE_INFINITY;
        }
        if (exp ==
              0) {
            return mant;
        }
        if (mant >=
              1 <<
              26) {
            mant++;
        }
        return (float)
                 (exp >
                    0
                    ? mant *
                    pow10[exp]
                    : mant /
                    pow10[-exp]);
    }
    private static final double[] pow10 =
      new double[128];
    static { for (int i = 0; i < pow10.length;
                  i++) { pow10[i] = java.lang.Math.
                                      pow(
                                        10,
                                        i);
             } }
    public NumberParser() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "/VUXqCZdRRei3NI42oUN45VDz+4dSfS8uMBmTOCvcqJqD8p4EMsuVXznDGfN" +
       "YKY0wafZMqPZX1A4XsiNIUyi6SqBRIYTvvKhqoDOAkH6uu+db7/PHu3SgF0X" +
       "dGRErGU3RJYegAK6erLv2DQHabOXoAo2vBMqbH75ucHFQD42gmLNlspBigOS" +
       "fQVA8l/U5hyQvhg12D68bPnz8n3EyKHcHl+EagtoLBAFy0W01UbfN99i7akC" +
       "kf4ObY5BCOKmJCdYCGjPC44vj/8/fJkhqNJ9o0SPPw05N9T8VlU8MVJdNmlk" +
       "zTu83rFvPiuBtZOmLLsLdNdziabjJF91JS/XNfZ1hqBJo8CVnvHZA7P6NJd/" +
       "haAavzzAjn275X4MPnPkQBV/cIuch+QJIvTxgnbPvbPEIifuoEzAyzzZcNTf" +
       "KxwusmrxJDX2fwM7AZn8Pwcx8eTIipVP3fnoi/zuRZSFrVuplrFQlfAbnmwS" +
       "mzmqNltXyfI5d8e9VD7Lpj/P3Y/bNgYKQCq7J5niu4wwWrN3Eu8eWnTmpztL" +
       "LkIZtg4FBKCSdbnnvIxmAi+vi+RWX5Dw2S1J25yvDS+el7x1hZ2kUc752S8f" +
       "Ey8d3vD2noZDTUE0tgsVA7PjDDuALhtWVmFxUO9DVZLRkQETQQuUNZ7SbhyF" +
       "rED/o8D8YrmzKttLL+UIas4tbHOvMitkdQjrS1VTSVA1UByOdXo8/9CwtkGF" +
       "qWm+AU6P6yCQ4vxBowEojUW6Nc2+0SqOa2zXSqPzyhX2SJtf/geuu3gfUxwA" +
       "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "6V/+zp9+7S+q49P/BYZTl8DWJgAA");
}
