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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "9cdf/bPq6PT/AGvWTC/SJgAA");
}
