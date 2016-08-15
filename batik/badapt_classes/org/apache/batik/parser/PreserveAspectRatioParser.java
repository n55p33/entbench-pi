package org.apache.batik.parser;
public class PreserveAspectRatioParser extends org.apache.batik.parser.AbstractParser {
    protected org.apache.batik.parser.PreserveAspectRatioHandler preserveAspectRatioHandler;
    public PreserveAspectRatioParser() { super();
                                         preserveAspectRatioHandler = org.apache.batik.parser.DefaultPreserveAspectRatioHandler.
                                                                        INSTANCE;
    }
    public void setPreserveAspectRatioHandler(org.apache.batik.parser.PreserveAspectRatioHandler handler) {
        preserveAspectRatioHandler =
          handler;
    }
    public org.apache.batik.parser.PreserveAspectRatioHandler getPreserveAspectRatioHandler() {
        return preserveAspectRatioHandler;
    }
    protected void doParse() throws org.apache.batik.parser.ParseException,
        java.io.IOException { current = reader.
                                          read(
                                            );
                              skipSpaces(
                                );
                              parsePreserveAspectRatio(
                                ); }
    protected void parsePreserveAspectRatio()
          throws org.apache.batik.parser.ParseException,
        java.io.IOException { preserveAspectRatioHandler.
                                startPreserveAspectRatio(
                                  );
                              align: switch (current) {
                                  case 'n':
                                      current =
                                        reader.
                                          read(
                                            );
                                      if (current !=
                                            'o') {
                                          reportCharacterExpectedError(
                                            'o',
                                            current);
                                          skipIdentifier(
                                            );
                                          break align;
                                      }
                                      current =
                                        reader.
                                          read(
                                            );
                                      if (current !=
                                            'n') {
                                          reportCharacterExpectedError(
                                            'o',
                                            current);
                                          skipIdentifier(
                                            );
                                          break align;
                                      }
                                      current =
                                        reader.
                                          read(
                                            );
                                      if (current !=
                                            'e') {
                                          reportCharacterExpectedError(
                                            'e',
                                            current);
                                          skipIdentifier(
                                            );
                                          break align;
                                      }
                                      current =
                                        reader.
                                          read(
                                            );
                                      skipSpaces(
                                        );
                                      preserveAspectRatioHandler.
                                        none(
                                          );
                                      break;
                                  case 'x':
                                      current =
                                        reader.
                                          read(
                                            );
                                      if (current !=
                                            'M') {
                                          reportCharacterExpectedError(
                                            'M',
                                            current);
                                          skipIdentifier(
                                            );
                                          break;
                                      }
                                      current =
                                        reader.
                                          read(
                                            );
                                      switch (current) {
                                          case 'a':
                                              current =
                                                reader.
                                                  read(
                                                    );
                                              if (current !=
                                                    'x') {
                                                  reportCharacterExpectedError(
                                                    'x',
                                                    current);
                                                  skipIdentifier(
                                                    );
                                                  break align;
                                              }
                                              current =
                                                reader.
                                                  read(
                                                    );
                                              if (current !=
                                                    'Y') {
                                                  reportCharacterExpectedError(
                                                    'Y',
                                                    current);
                                                  skipIdentifier(
                                                    );
                                                  break align;
                                              }
                                              current =
                                                reader.
                                                  read(
                                                    );
                                              if (current !=
                                                    'M') {
                                                  reportCharacterExpectedError(
                                                    'M',
                                                    current);
                                                  skipIdentifier(
                                                    );
                                                  break align;
                                              }
                                              current =
                                                reader.
                                                  read(
                                                    );
                                              switch (current) {
                                                  case 'a':
                                                      current =
                                                        reader.
                                                          read(
                                                            );
                                                      if (current !=
                                                            'x') {
                                                          reportCharacterExpectedError(
                                                            'x',
                                                            current);
                                                          skipIdentifier(
                                                            );
                                                          break align;
                                                      }
                                                      preserveAspectRatioHandler.
                                                        xMaxYMax(
                                                          );
                                                      current =
                                                        reader.
                                                          read(
                                                            );
                                                      break;
                                                  case 'i':
                                                      current =
                                                        reader.
                                                          read(
                                                            );
                                                      switch (current) {
                                                          case 'd':
                                                              preserveAspectRatioHandler.
                                                                xMaxYMid(
                                                                  );
                                                              current =
                                                                reader.
                                                                  read(
                                                                    );
                                                              break;
                                                          case 'n':
                                                              preserveAspectRatioHandler.
                                                                xMaxYMin(
                                                                  );
                                                              current =
                                                                reader.
                                                                  read(
                                                                    );
                                                              break;
                                                          default:
                                                              reportUnexpectedCharacterError(
                                                                current);
                                                              skipIdentifier(
                                                                );
                                                              break align;
                                                      }
                                              }
                                              break;
                                          case 'i':
                                              current =
                                                reader.
                                                  read(
                                                    );
                                              switch (current) {
                                                  case 'd':
                                                      current =
                                                        reader.
                                                          read(
                                                            );
                                                      if (current !=
                                                            'Y') {
                                                          reportCharacterExpectedError(
                                                            'Y',
                                                            current);
                                                          skipIdentifier(
                                                            );
                                                          break align;
                                                      }
                                                      current =
                                                        reader.
                                                          read(
                                                            );
                                                      if (current !=
                                                            'M') {
                                                          reportCharacterExpectedError(
                                                            'M',
                                                            current);
                                                          skipIdentifier(
                                                            );
                                                          break align;
                                                      }
                                                      current =
                                                        reader.
                                                          read(
                                                            );
                                                      switch (current) {
                                                          case 'a':
                                                              current =
                                                                reader.
                                                                  read(
                                                                    );
                                                              if (current !=
                                                                    'x') {
                                                                  reportCharacterExpectedError(
                                                                    'x',
                                                                    current);
                                                                  skipIdentifier(
                                                                    );
                                                                  break align;
                                                              }
                                                              preserveAspectRatioHandler.
                                                                xMidYMax(
                                                                  );
                                                              current =
                                                                reader.
                                                                  read(
                                                                    );
                                                              break;
                                                          case 'i':
                                                              current =
                                                                reader.
                                                                  read(
                                                                    );
                                                              switch (current) {
                                                                  case 'd':
                                                                      preserveAspectRatioHandler.
                                                                        xMidYMid(
                                                                          );
                                                                      current =
                                                                        reader.
                                                                          read(
                                                                            );
                                                                      break;
                                                                  case 'n':
                                                                      preserveAspectRatioHandler.
                                                                        xMidYMin(
                                                                          );
                                                                      current =
                                                                        reader.
                                                                          read(
                                                                            );
                                                                      break;
                                                                  default:
                                                                      reportUnexpectedCharacterError(
                                                                        current);
                                                                      skipIdentifier(
                                                                        );
                                                                      break align;
                                                              }
                                                      }
                                                      break;
                                                  case 'n':
                                                      current =
                                                        reader.
                                                          read(
                                                            );
                                                      if (current !=
                                                            'Y') {
                                                          reportCharacterExpectedError(
                                                            'Y',
                                                            current);
                                                          skipIdentifier(
                                                            );
                                                          break align;
                                                      }
                                                      current =
                                                        reader.
                                                          read(
                                                            );
                                                      if (current !=
                                                            'M') {
                                                          reportCharacterExpectedError(
                                                            'M',
                                                            current);
                                                          skipIdentifier(
                                                            );
                                                          break align;
                                                      }
                                                      current =
                                                        reader.
                                                          read(
                                                            );
                                                      switch (current) {
                                                          case 'a':
                                                              current =
                                                                reader.
                                                                  read(
                                                                    );
                                                              if (current !=
                                                                    'x') {
                                                                  reportCharacterExpectedError(
                                                                    'x',
                                                                    current);
                                                                  skipIdentifier(
                                                                    );
                                                                  break align;
                                                              }
                                                              preserveAspectRatioHandler.
                                                                xMinYMax(
                                                                  );
                                                              current =
                                                                reader.
                                                                  read(
                                                                    );
                                                              break;
                                                          case 'i':
                                                              current =
                                                                reader.
                                                                  read(
                                                                    );
                                                              switch (current) {
                                                                  case 'd':
                                                                      preserveAspectRatioHandler.
                                                                        xMinYMid(
                                                                          );
                                                                      current =
                                                                        reader.
                                                                          read(
                                                                            );
                                                                      break;
                                                                  case 'n':
                                                                      preserveAspectRatioHandler.
                                                                        xMinYMin(
                                                                          );
                                                                      current =
                                                                        reader.
                                                                          read(
                                                                            );
                                                                      break;
                                                                  default:
                                                                      reportUnexpectedCharacterError(
                                                                        current);
                                                                      skipIdentifier(
                                                                        );
                                                                      break align;
                                                              }
                                                      }
                                                      break;
                                                  default:
                                                      reportUnexpectedCharacterError(
                                                        current);
                                                      skipIdentifier(
                                                        );
                                                      break align;
                                              }
                                              break;
                                          default:
                                              reportUnexpectedCharacterError(
                                                current);
                                              skipIdentifier(
                                                );
                                      }
                                      break;
                                  default:
                                      if (current !=
                                            -1) {
                                          reportUnexpectedCharacterError(
                                            current);
                                          skipIdentifier(
                                            );
                                      }
                              }
                              skipCommaSpaces(
                                );
                              switch (current) {
                                  case 'm':
                                      current =
                                        reader.
                                          read(
                                            );
                                      if (current !=
                                            'e') {
                                          reportCharacterExpectedError(
                                            'e',
                                            current);
                                          skipIdentifier(
                                            );
                                          break;
                                      }
                                      current =
                                        reader.
                                          read(
                                            );
                                      if (current !=
                                            'e') {
                                          reportCharacterExpectedError(
                                            'e',
                                            current);
                                          skipIdentifier(
                                            );
                                          break;
                                      }
                                      current =
                                        reader.
                                          read(
                                            );
                                      if (current !=
                                            't') {
                                          reportCharacterExpectedError(
                                            't',
                                            current);
                                          skipIdentifier(
                                            );
                                          break;
                                      }
                                      preserveAspectRatioHandler.
                                        meet(
                                          );
                                      current =
                                        reader.
                                          read(
                                            );
                                      break;
                                  case 's':
                                      current =
                                        reader.
                                          read(
                                            );
                                      if (current !=
                                            'l') {
                                          reportCharacterExpectedError(
                                            'l',
                                            current);
                                          skipIdentifier(
                                            );
                                          break;
                                      }
                                      current =
                                        reader.
                                          read(
                                            );
                                      if (current !=
                                            'i') {
                                          reportCharacterExpectedError(
                                            'i',
                                            current);
                                          skipIdentifier(
                                            );
                                          break;
                                      }
                                      current =
                                        reader.
                                          read(
                                            );
                                      if (current !=
                                            'c') {
                                          reportCharacterExpectedError(
                                            'c',
                                            current);
                                          skipIdentifier(
                                            );
                                          break;
                                      }
                                      current =
                                        reader.
                                          read(
                                            );
                                      if (current !=
                                            'e') {
                                          reportCharacterExpectedError(
                                            'e',
                                            current);
                                          skipIdentifier(
                                            );
                                          break;
                                      }
                                      preserveAspectRatioHandler.
                                        slice(
                                          );
                                      current =
                                        reader.
                                          read(
                                            );
                                      break;
                                  default:
                                      if (current !=
                                            -1) {
                                          reportUnexpectedCharacterError(
                                            current);
                                          skipIdentifier(
                                            );
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
                              }
                              preserveAspectRatioHandler.
                                endPreserveAspectRatio(
                                  ); }
    protected void skipIdentifier() throws java.io.IOException {
        loop: for (;
                   ;
                   ) {
            current =
              reader.
                read(
                  );
            switch (current) {
                case 13:
                case 10:
                case 32:
                case 9:
                    current =
                      reader.
                        read(
                          );
                    break loop;
                default:
                    if (current ==
                          -1) {
                        break loop;
                    }
            }
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AA==");
}
