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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
