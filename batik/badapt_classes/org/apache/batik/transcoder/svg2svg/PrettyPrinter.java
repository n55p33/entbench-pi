package org.apache.batik.transcoder.svg2svg;
public class PrettyPrinter {
    public static final int DOCTYPE_CHANGE = 0;
    public static final int DOCTYPE_REMOVE = 1;
    public static final int DOCTYPE_KEEP_UNCHANGED = 2;
    protected org.apache.batik.xml.XMLScanner scanner;
    protected org.apache.batik.transcoder.svg2svg.OutputManager output;
    protected java.io.Writer writer;
    protected org.apache.batik.transcoder.ErrorHandler errorHandler = org.apache.batik.transcoder.svg2svg.SVGTranscoder.
                                                                        DEFAULT_ERROR_HANDLER;
    protected java.lang.String newline = "\n";
    protected boolean format = true;
    protected int tabulationWidth = 4;
    protected int documentWidth = 80;
    protected int doctypeOption = DOCTYPE_KEEP_UNCHANGED;
    protected java.lang.String publicId;
    protected java.lang.String systemId;
    protected java.lang.String xmlDeclaration;
    protected int type;
    public void setXMLDeclaration(java.lang.String s) { xmlDeclaration =
                                                          s; }
    public void setDoctypeOption(int i) { doctypeOption = i; }
    public void setPublicId(java.lang.String s) { publicId = s; }
    public void setSystemId(java.lang.String s) { systemId = s; }
    public void setNewline(java.lang.String s) { newline = s; }
    public java.lang.String getNewline() { return newline; }
    public void setFormat(boolean b) { format = b; }
    public boolean getFormat() { return format; }
    public void setTabulationWidth(int i) { tabulationWidth = java.lang.Math.
                                                                max(
                                                                  i,
                                                                  0);
    }
    public int getTabulationWidth() { return tabulationWidth; }
    public void setDocumentWidth(int i) { documentWidth = java.lang.Math.
                                                            max(
                                                              i,
                                                              0);
    }
    public int getDocumentWidth() { return documentWidth; }
    public void print(java.io.Reader r, java.io.Writer w) throws org.apache.batik.transcoder.TranscoderException,
        java.io.IOException { try { scanner = new org.apache.batik.xml.XMLScanner(
                                                r);
                                    output = new org.apache.batik.transcoder.svg2svg.OutputManager(
                                               this,
                                               w);
                                    writer =
                                      w;
                                    type =
                                      scanner.
                                        next(
                                          );
                                    printXMLDecl(
                                      );
                                    misc1: for (;
                                                ;
                                                ) {
                                        switch (type) {
                                            case org.apache.batik.xml.LexicalUnits.
                                                   S:
                                                output.
                                                  printTopSpaces(
                                                    getCurrentValue(
                                                      ));
                                                scanner.
                                                  clearBuffer(
                                                    );
                                                type =
                                                  scanner.
                                                    next(
                                                      );
                                                break;
                                            case org.apache.batik.xml.LexicalUnits.
                                                   COMMENT:
                                                output.
                                                  printComment(
                                                    getCurrentValue(
                                                      ));
                                                scanner.
                                                  clearBuffer(
                                                    );
                                                type =
                                                  scanner.
                                                    next(
                                                      );
                                                break;
                                            case org.apache.batik.xml.LexicalUnits.
                                                   PI_START:
                                                printPI(
                                                  );
                                                break;
                                            default:
                                                break misc1;
                                        }
                                    }
                                    printDoctype(
                                      );
                                    misc2: for (;
                                                ;
                                                ) {
                                        scanner.
                                          clearBuffer(
                                            );
                                        switch (type) {
                                            case org.apache.batik.xml.LexicalUnits.
                                                   S:
                                                output.
                                                  printTopSpaces(
                                                    getCurrentValue(
                                                      ));
                                                scanner.
                                                  clearBuffer(
                                                    );
                                                type =
                                                  scanner.
                                                    next(
                                                      );
                                                break;
                                            case org.apache.batik.xml.LexicalUnits.
                                                   COMMENT:
                                                output.
                                                  printComment(
                                                    getCurrentValue(
                                                      ));
                                                scanner.
                                                  clearBuffer(
                                                    );
                                                type =
                                                  scanner.
                                                    next(
                                                      );
                                                break;
                                            case org.apache.batik.xml.LexicalUnits.
                                                   PI_START:
                                                printPI(
                                                  );
                                                break;
                                            default:
                                                break misc2;
                                        }
                                    }
                                    if (type !=
                                          org.apache.batik.xml.LexicalUnits.
                                            START_TAG) {
                                        throw fatalError(
                                                "element",
                                                null);
                                    }
                                    printElement(
                                      );
                                    misc3: for (;
                                                ;
                                                ) {
                                        switch (type) {
                                            case org.apache.batik.xml.LexicalUnits.
                                                   S:
                                                output.
                                                  printTopSpaces(
                                                    getCurrentValue(
                                                      ));
                                                scanner.
                                                  clearBuffer(
                                                    );
                                                type =
                                                  scanner.
                                                    next(
                                                      );
                                                break;
                                            case org.apache.batik.xml.LexicalUnits.
                                                   COMMENT:
                                                output.
                                                  printComment(
                                                    getCurrentValue(
                                                      ));
                                                scanner.
                                                  clearBuffer(
                                                    );
                                                type =
                                                  scanner.
                                                    next(
                                                      );
                                                break;
                                            case org.apache.batik.xml.LexicalUnits.
                                                   PI_START:
                                                printPI(
                                                  );
                                                break;
                                            default:
                                                break misc3;
                                        }
                                    } }
                              catch (org.apache.batik.xml.XMLException e) {
                                  errorHandler.
                                    fatalError(
                                      new org.apache.batik.transcoder.TranscoderException(
                                        e.
                                          getMessage(
                                            )));
                              } }
    protected void printXMLDecl() throws org.apache.batik.transcoder.TranscoderException,
        org.apache.batik.xml.XMLException,
        java.io.IOException { if (xmlDeclaration ==
                                    null) {
                                  if (type ==
                                        org.apache.batik.xml.LexicalUnits.
                                          XML_DECL_START) {
                                      if (scanner.
                                            next(
                                              ) !=
                                            org.apache.batik.xml.LexicalUnits.
                                              S) {
                                          throw fatalError(
                                                  "space",
                                                  null);
                                      }
                                      char[] space1 =
                                        getCurrentValue(
                                          );
                                      if (scanner.
                                            next(
                                              ) !=
                                            org.apache.batik.xml.LexicalUnits.
                                              VERSION_IDENTIFIER) {
                                          throw fatalError(
                                                  "token",
                                                  new java.lang.Object[] { "version" });
                                      }
                                      type =
                                        scanner.
                                          next(
                                            );
                                      char[] space2 =
                                        null;
                                      if (type ==
                                            org.apache.batik.xml.LexicalUnits.
                                              S) {
                                          space2 =
                                            getCurrentValue(
                                              );
                                          type =
                                            scanner.
                                              next(
                                                );
                                      }
                                      if (type !=
                                            org.apache.batik.xml.LexicalUnits.
                                              EQ) {
                                          throw fatalError(
                                                  "token",
                                                  new java.lang.Object[] { "=" });
                                      }
                                      type =
                                        scanner.
                                          next(
                                            );
                                      char[] space3 =
                                        null;
                                      if (type ==
                                            org.apache.batik.xml.LexicalUnits.
                                              S) {
                                          space3 =
                                            getCurrentValue(
                                              );
                                          type =
                                            scanner.
                                              next(
                                                );
                                      }
                                      if (type !=
                                            org.apache.batik.xml.LexicalUnits.
                                              STRING) {
                                          throw fatalError(
                                                  "string",
                                                  null);
                                      }
                                      char[] version =
                                        getCurrentValue(
                                          );
                                      char versionDelim =
                                        scanner.
                                        getStringDelimiter(
                                          );
                                      char[] space4 =
                                        null;
                                      char[] space5 =
                                        null;
                                      char[] space6 =
                                        null;
                                      char[] encoding =
                                        null;
                                      char encodingDelim =
                                        0;
                                      char[] space7 =
                                        null;
                                      char[] space8 =
                                        null;
                                      char[] space9 =
                                        null;
                                      char[] standalone =
                                        null;
                                      char standaloneDelim =
                                        0;
                                      char[] space10 =
                                        null;
                                      type =
                                        scanner.
                                          next(
                                            );
                                      if (type ==
                                            org.apache.batik.xml.LexicalUnits.
                                              S) {
                                          space4 =
                                            getCurrentValue(
                                              );
                                          type =
                                            scanner.
                                              next(
                                                );
                                          if (type ==
                                                org.apache.batik.xml.LexicalUnits.
                                                  ENCODING_IDENTIFIER) {
                                              type =
                                                scanner.
                                                  next(
                                                    );
                                              if (type ==
                                                    org.apache.batik.xml.LexicalUnits.
                                                      S) {
                                                  space5 =
                                                    getCurrentValue(
                                                      );
                                                  type =
                                                    scanner.
                                                      next(
                                                        );
                                              }
                                              if (type !=
                                                    org.apache.batik.xml.LexicalUnits.
                                                      EQ) {
                                                  throw fatalError(
                                                          "token",
                                                          new java.lang.Object[] { "=" });
                                              }
                                              type =
                                                scanner.
                                                  next(
                                                    );
                                              if (type ==
                                                    org.apache.batik.xml.LexicalUnits.
                                                      S) {
                                                  space6 =
                                                    getCurrentValue(
                                                      );
                                                  type =
                                                    scanner.
                                                      next(
                                                        );
                                              }
                                              if (type !=
                                                    org.apache.batik.xml.LexicalUnits.
                                                      STRING) {
                                                  throw fatalError(
                                                          "string",
                                                          null);
                                              }
                                              encoding =
                                                getCurrentValue(
                                                  );
                                              encodingDelim =
                                                scanner.
                                                  getStringDelimiter(
                                                    );
                                              type =
                                                scanner.
                                                  next(
                                                    );
                                              if (type ==
                                                    org.apache.batik.xml.LexicalUnits.
                                                      S) {
                                                  space7 =
                                                    getCurrentValue(
                                                      );
                                                  type =
                                                    scanner.
                                                      next(
                                                        );
                                              }
                                          }
                                          if (type ==
                                                org.apache.batik.xml.LexicalUnits.
                                                  STANDALONE_IDENTIFIER) {
                                              type =
                                                scanner.
                                                  next(
                                                    );
                                              if (type ==
                                                    org.apache.batik.xml.LexicalUnits.
                                                      S) {
                                                  space8 =
                                                    getCurrentValue(
                                                      );
                                                  type =
                                                    scanner.
                                                      next(
                                                        );
                                              }
                                              if (type !=
                                                    org.apache.batik.xml.LexicalUnits.
                                                      EQ) {
                                                  throw fatalError(
                                                          "token",
                                                          new java.lang.Object[] { "=" });
                                              }
                                              type =
                                                scanner.
                                                  next(
                                                    );
                                              if (type ==
                                                    org.apache.batik.xml.LexicalUnits.
                                                      S) {
                                                  space9 =
                                                    getCurrentValue(
                                                      );
                                                  type =
                                                    scanner.
                                                      next(
                                                        );
                                              }
                                              if (type !=
                                                    org.apache.batik.xml.LexicalUnits.
                                                      STRING) {
                                                  throw fatalError(
                                                          "string",
                                                          null);
                                              }
                                              standalone =
                                                getCurrentValue(
                                                  );
                                              standaloneDelim =
                                                scanner.
                                                  getStringDelimiter(
                                                    );
                                              type =
                                                scanner.
                                                  next(
                                                    );
                                              if (type ==
                                                    org.apache.batik.xml.LexicalUnits.
                                                      S) {
                                                  space10 =
                                                    getCurrentValue(
                                                      );
                                                  type =
                                                    scanner.
                                                      next(
                                                        );
                                              }
                                          }
                                      }
                                      if (type !=
                                            org.apache.batik.xml.LexicalUnits.
                                              PI_END) {
                                          throw fatalError(
                                                  "pi.end",
                                                  null);
                                      }
                                      output.
                                        printXMLDecl(
                                          space1,
                                          space2,
                                          space3,
                                          version,
                                          versionDelim,
                                          space4,
                                          space5,
                                          space6,
                                          encoding,
                                          encodingDelim,
                                          space7,
                                          space8,
                                          space9,
                                          standalone,
                                          standaloneDelim,
                                          space10);
                                      type =
                                        scanner.
                                          next(
                                            );
                                  }
                              }
                              else {
                                  output.
                                    printString(
                                      xmlDeclaration);
                                  output.
                                    printNewline(
                                      );
                                  if (type ==
                                        org.apache.batik.xml.LexicalUnits.
                                          XML_DECL_START) {
                                      if (scanner.
                                            next(
                                              ) !=
                                            org.apache.batik.xml.LexicalUnits.
                                              S) {
                                          throw fatalError(
                                                  "space",
                                                  null);
                                      }
                                      if (scanner.
                                            next(
                                              ) !=
                                            org.apache.batik.xml.LexicalUnits.
                                              VERSION_IDENTIFIER) {
                                          throw fatalError(
                                                  "token",
                                                  new java.lang.Object[] { "version" });
                                      }
                                      type =
                                        scanner.
                                          next(
                                            );
                                      if (type ==
                                            org.apache.batik.xml.LexicalUnits.
                                              S) {
                                          type =
                                            scanner.
                                              next(
                                                );
                                      }
                                      if (type !=
                                            org.apache.batik.xml.LexicalUnits.
                                              EQ) {
                                          throw fatalError(
                                                  "token",
                                                  new java.lang.Object[] { "=" });
                                      }
                                      type =
                                        scanner.
                                          next(
                                            );
                                      if (type ==
                                            org.apache.batik.xml.LexicalUnits.
                                              S) {
                                          type =
                                            scanner.
                                              next(
                                                );
                                      }
                                      if (type !=
                                            org.apache.batik.xml.LexicalUnits.
                                              STRING) {
                                          throw fatalError(
                                                  "string",
                                                  null);
                                      }
                                      type =
                                        scanner.
                                          next(
                                            );
                                      if (type ==
                                            org.apache.batik.xml.LexicalUnits.
                                              S) {
                                          type =
                                            scanner.
                                              next(
                                                );
                                          if (type ==
                                                org.apache.batik.xml.LexicalUnits.
                                                  ENCODING_IDENTIFIER) {
                                              type =
                                                scanner.
                                                  next(
                                                    );
                                              if (type ==
                                                    org.apache.batik.xml.LexicalUnits.
                                                      S) {
                                                  type =
                                                    scanner.
                                                      next(
                                                        );
                                              }
                                              if (type !=
                                                    org.apache.batik.xml.LexicalUnits.
                                                      EQ) {
                                                  throw fatalError(
                                                          "token",
                                                          new java.lang.Object[] { "=" });
                                              }
                                              type =
                                                scanner.
                                                  next(
                                                    );
                                              if (type ==
                                                    org.apache.batik.xml.LexicalUnits.
                                                      S) {
                                                  type =
                                                    scanner.
                                                      next(
                                                        );
                                              }
                                              if (type !=
                                                    org.apache.batik.xml.LexicalUnits.
                                                      STRING) {
                                                  throw fatalError(
                                                          "string",
                                                          null);
                                              }
                                              type =
                                                scanner.
                                                  next(
                                                    );
                                              if (type ==
                                                    org.apache.batik.xml.LexicalUnits.
                                                      S) {
                                                  type =
                                                    scanner.
                                                      next(
                                                        );
                                              }
                                          }
                                          if (type ==
                                                org.apache.batik.xml.LexicalUnits.
                                                  STANDALONE_IDENTIFIER) {
                                              type =
                                                scanner.
                                                  next(
                                                    );
                                              if (type ==
                                                    org.apache.batik.xml.LexicalUnits.
                                                      S) {
                                                  type =
                                                    scanner.
                                                      next(
                                                        );
                                              }
                                              if (type !=
                                                    org.apache.batik.xml.LexicalUnits.
                                                      EQ) {
                                                  throw fatalError(
                                                          "token",
                                                          new java.lang.Object[] { "=" });
                                              }
                                              type =
                                                scanner.
                                                  next(
                                                    );
                                              if (type ==
                                                    org.apache.batik.xml.LexicalUnits.
                                                      S) {
                                                  type =
                                                    scanner.
                                                      next(
                                                        );
                                              }
                                              if (type !=
                                                    org.apache.batik.xml.LexicalUnits.
                                                      STRING) {
                                                  throw fatalError(
                                                          "string",
                                                          null);
                                              }
                                              type =
                                                scanner.
                                                  next(
                                                    );
                                              if (type ==
                                                    org.apache.batik.xml.LexicalUnits.
                                                      S) {
                                                  type =
                                                    scanner.
                                                      next(
                                                        );
                                              }
                                          }
                                      }
                                      if (type !=
                                            org.apache.batik.xml.LexicalUnits.
                                              PI_END) {
                                          throw fatalError(
                                                  "pi.end",
                                                  null);
                                      }
                                      type =
                                        scanner.
                                          next(
                                            );
                                  }
                              } }
    protected void printPI() throws org.apache.batik.transcoder.TranscoderException,
        org.apache.batik.xml.XMLException,
        java.io.IOException { char[] target =
                                getCurrentValue(
                                  );
                              type = scanner.
                                       next(
                                         );
                              char[] space =
                                {  };
                              if (type ==
                                    org.apache.batik.xml.LexicalUnits.
                                      S) {
                                  space =
                                    getCurrentValue(
                                      );
                                  type =
                                    scanner.
                                      next(
                                        );
                              }
                              if (type !=
                                    org.apache.batik.xml.LexicalUnits.
                                      PI_DATA) {
                                  throw fatalError(
                                          "pi.data",
                                          null);
                              }
                              char[] data =
                                getCurrentValue(
                                  );
                              type = scanner.
                                       next(
                                         );
                              if (type !=
                                    org.apache.batik.xml.LexicalUnits.
                                      PI_END) {
                                  throw fatalError(
                                          "pi.end",
                                          null);
                              }
                              output.printPI(
                                       target,
                                       space,
                                       data);
                              type = scanner.
                                       next(
                                         );
    }
    protected void printDoctype() throws org.apache.batik.transcoder.TranscoderException,
        org.apache.batik.xml.XMLException,
        java.io.IOException { switch (doctypeOption) {
                                  default:
                                      if (type ==
                                            org.apache.batik.xml.LexicalUnits.
                                              DOCTYPE_START) {
                                          type =
                                            scanner.
                                              next(
                                                );
                                          if (type !=
                                                org.apache.batik.xml.LexicalUnits.
                                                  S) {
                                              throw fatalError(
                                                      "space",
                                                      null);
                                          }
                                          char[] space1 =
                                            getCurrentValue(
                                              );
                                          type =
                                            scanner.
                                              next(
                                                );
                                          if (type !=
                                                org.apache.batik.xml.LexicalUnits.
                                                  NAME) {
                                              throw fatalError(
                                                      "name",
                                                      null);
                                          }
                                          char[] root =
                                            getCurrentValue(
                                              );
                                          char[] space2 =
                                            null;
                                          java.lang.String externalId =
                                            null;
                                          char[] space3 =
                                            null;
                                          char[] string1 =
                                            null;
                                          char string1Delim =
                                            0;
                                          char[] space4 =
                                            null;
                                          char[] string2 =
                                            null;
                                          char string2Delim =
                                            0;
                                          char[] space5 =
                                            null;
                                          type =
                                            scanner.
                                              next(
                                                );
                                          if (type ==
                                                org.apache.batik.xml.LexicalUnits.
                                                  S) {
                                              space2 =
                                                getCurrentValue(
                                                  );
                                              type =
                                                scanner.
                                                  next(
                                                    );
                                              switch (type) {
                                                  case org.apache.batik.xml.LexicalUnits.
                                                         PUBLIC_IDENTIFIER:
                                                      externalId =
                                                        "PUBLIC";
                                                      type =
                                                        scanner.
                                                          next(
                                                            );
                                                      if (type !=
                                                            org.apache.batik.xml.LexicalUnits.
                                                              S) {
                                                          throw fatalError(
                                                                  "space",
                                                                  null);
                                                      }
                                                      space3 =
                                                        getCurrentValue(
                                                          );
                                                      type =
                                                        scanner.
                                                          next(
                                                            );
                                                      if (type !=
                                                            org.apache.batik.xml.LexicalUnits.
                                                              STRING) {
                                                          throw fatalError(
                                                                  "string",
                                                                  null);
                                                      }
                                                      string1 =
                                                        getCurrentValue(
                                                          );
                                                      string1Delim =
                                                        scanner.
                                                          getStringDelimiter(
                                                            );
                                                      type =
                                                        scanner.
                                                          next(
                                                            );
                                                      if (type !=
                                                            org.apache.batik.xml.LexicalUnits.
                                                              S) {
                                                          throw fatalError(
                                                                  "space",
                                                                  null);
                                                      }
                                                      space4 =
                                                        getCurrentValue(
                                                          );
                                                      type =
                                                        scanner.
                                                          next(
                                                            );
                                                      if (type !=
                                                            org.apache.batik.xml.LexicalUnits.
                                                              STRING) {
                                                          throw fatalError(
                                                                  "string",
                                                                  null);
                                                      }
                                                      string2 =
                                                        getCurrentValue(
                                                          );
                                                      string2Delim =
                                                        scanner.
                                                          getStringDelimiter(
                                                            );
                                                      type =
                                                        scanner.
                                                          next(
                                                            );
                                                      if (type ==
                                                            org.apache.batik.xml.LexicalUnits.
                                                              S) {
                                                          space5 =
                                                            getCurrentValue(
                                                              );
                                                          type =
                                                            scanner.
                                                              next(
                                                                );
                                                      }
                                                      break;
                                                  case org.apache.batik.xml.LexicalUnits.
                                                         SYSTEM_IDENTIFIER:
                                                      externalId =
                                                        "SYSTEM";
                                                      type =
                                                        scanner.
                                                          next(
                                                            );
                                                      if (type !=
                                                            org.apache.batik.xml.LexicalUnits.
                                                              S) {
                                                          throw fatalError(
                                                                  "space",
                                                                  null);
                                                      }
                                                      space3 =
                                                        getCurrentValue(
                                                          );
                                                      type =
                                                        scanner.
                                                          next(
                                                            );
                                                      if (type !=
                                                            org.apache.batik.xml.LexicalUnits.
                                                              STRING) {
                                                          throw fatalError(
                                                                  "string",
                                                                  null);
                                                      }
                                                      string1 =
                                                        getCurrentValue(
                                                          );
                                                      string1Delim =
                                                        scanner.
                                                          getStringDelimiter(
                                                            );
                                                      type =
                                                        scanner.
                                                          next(
                                                            );
                                                      if (type ==
                                                            org.apache.batik.xml.LexicalUnits.
                                                              S) {
                                                          space4 =
                                                            getCurrentValue(
                                                              );
                                                          type =
                                                            scanner.
                                                              next(
                                                                );
                                                      }
                                              }
                                          }
                                          if (doctypeOption ==
                                                DOCTYPE_CHANGE) {
                                              if (publicId !=
                                                    null) {
                                                  externalId =
                                                    "PUBLIC";
                                                  string1 =
                                                    publicId.
                                                      toCharArray(
                                                        );
                                                  string1Delim =
                                                    '\"';
                                                  if (systemId !=
                                                        null) {
                                                      string2 =
                                                        systemId.
                                                          toCharArray(
                                                            );
                                                      string2Delim =
                                                        '\"';
                                                  }
                                              }
                                              else
                                                  if (systemId !=
                                                        null) {
                                                      externalId =
                                                        "SYSTEM";
                                                      string1 =
                                                        systemId.
                                                          toCharArray(
                                                            );
                                                      string1Delim =
                                                        '\"';
                                                      string2 =
                                                        null;
                                                  }
                                          }
                                          output.
                                            printDoctypeStart(
                                              space1,
                                              root,
                                              space2,
                                              externalId,
                                              space3,
                                              string1,
                                              string1Delim,
                                              space4,
                                              string2,
                                              string2Delim,
                                              space5);
                                          if (type ==
                                                org.apache.batik.xml.LexicalUnits.
                                                  LSQUARE_BRACKET) {
                                              output.
                                                printCharacter(
                                                  '[');
                                              type =
                                                scanner.
                                                  next(
                                                    );
                                              dtd: for (;
                                                        ;
                                                        ) {
                                                  switch (type) {
                                                      case org.apache.batik.xml.LexicalUnits.
                                                             S:
                                                          output.
                                                            printSpaces(
                                                              getCurrentValue(
                                                                ),
                                                              true);
                                                          scanner.
                                                            clearBuffer(
                                                              );
                                                          type =
                                                            scanner.
                                                              next(
                                                                );
                                                          break;
                                                      case org.apache.batik.xml.LexicalUnits.
                                                             COMMENT:
                                                          output.
                                                            printComment(
                                                              getCurrentValue(
                                                                ));
                                                          scanner.
                                                            clearBuffer(
                                                              );
                                                          type =
                                                            scanner.
                                                              next(
                                                                );
                                                          break;
                                                      case org.apache.batik.xml.LexicalUnits.
                                                             PI_START:
                                                          printPI(
                                                            );
                                                          break;
                                                      case org.apache.batik.xml.LexicalUnits.
                                                             PARAMETER_ENTITY_REFERENCE:
                                                          output.
                                                            printParameterEntityReference(
                                                              getCurrentValue(
                                                                ));
                                                          scanner.
                                                            clearBuffer(
                                                              );
                                                          type =
                                                            scanner.
                                                              next(
                                                                );
                                                          break;
                                                      case org.apache.batik.xml.LexicalUnits.
                                                             ELEMENT_DECLARATION_START:
                                                          scanner.
                                                            clearBuffer(
                                                              );
                                                          printElementDeclaration(
                                                            );
                                                          break;
                                                      case org.apache.batik.xml.LexicalUnits.
                                                             ATTLIST_START:
                                                          scanner.
                                                            clearBuffer(
                                                              );
                                                          printAttlist(
                                                            );
                                                          break;
                                                      case org.apache.batik.xml.LexicalUnits.
                                                             NOTATION_START:
                                                          scanner.
                                                            clearBuffer(
                                                              );
                                                          printNotation(
                                                            );
                                                          break;
                                                      case org.apache.batik.xml.LexicalUnits.
                                                             ENTITY_START:
                                                          scanner.
                                                            clearBuffer(
                                                              );
                                                          printEntityDeclaration(
                                                            );
                                                          break;
                                                      case org.apache.batik.xml.LexicalUnits.
                                                             RSQUARE_BRACKET:
                                                          output.
                                                            printCharacter(
                                                              ']');
                                                          scanner.
                                                            clearBuffer(
                                                              );
                                                          type =
                                                            scanner.
                                                              next(
                                                                );
                                                          break dtd;
                                                      default:
                                                          throw fatalError(
                                                                  "xml",
                                                                  null);
                                                  }
                                              }
                                          }
                                          char[] endSpace =
                                            null;
                                          if (type ==
                                                org.apache.batik.xml.LexicalUnits.
                                                  S) {
                                              endSpace =
                                                getCurrentValue(
                                                  );
                                              type =
                                                scanner.
                                                  next(
                                                    );
                                          }
                                          if (type !=
                                                org.apache.batik.xml.LexicalUnits.
                                                  END_CHAR) {
                                              throw fatalError(
                                                      "end",
                                                      null);
                                          }
                                          type =
                                            scanner.
                                              next(
                                                );
                                          output.
                                            printDoctypeEnd(
                                              endSpace);
                                      }
                                      else {
                                          if (doctypeOption ==
                                                DOCTYPE_CHANGE) {
                                              java.lang.String externalId =
                                                "PUBLIC";
                                              char[] string1 =
                                                org.apache.batik.util.SVGConstants.
                                                  SVG_PUBLIC_ID.
                                                toCharArray(
                                                  );
                                              char[] string2 =
                                                org.apache.batik.util.SVGConstants.
                                                  SVG_SYSTEM_ID.
                                                toCharArray(
                                                  );
                                              if (publicId !=
                                                    null) {
                                                  string1 =
                                                    publicId.
                                                      toCharArray(
                                                        );
                                                  if (systemId !=
                                                        null) {
                                                      string2 =
                                                        systemId.
                                                          toCharArray(
                                                            );
                                                  }
                                              }
                                              else
                                                  if (systemId !=
                                                        null) {
                                                      externalId =
                                                        "SYSTEM";
                                                      string1 =
                                                        systemId.
                                                          toCharArray(
                                                            );
                                                      string2 =
                                                        null;
                                                  }
                                              output.
                                                printDoctypeStart(
                                                  new char[] { ' ' },
                                                  new char[] { 's',
                                                  'v',
                                                  'g' },
                                                  new char[] { ' ' },
                                                  externalId,
                                                  new char[] { ' ' },
                                                  string1,
                                                  '\"',
                                                  new char[] { ' ' },
                                                  string2,
                                                  '\"',
                                                  null);
                                              output.
                                                printDoctypeEnd(
                                                  null);
                                          }
                                      }
                                      break;
                                  case DOCTYPE_REMOVE:
                                      if (type ==
                                            org.apache.batik.xml.LexicalUnits.
                                              DOCTYPE_START) {
                                          type =
                                            scanner.
                                              next(
                                                );
                                          if (type !=
                                                org.apache.batik.xml.LexicalUnits.
                                                  S) {
                                              throw fatalError(
                                                      "space",
                                                      null);
                                          }
                                          type =
                                            scanner.
                                              next(
                                                );
                                          if (type !=
                                                org.apache.batik.xml.LexicalUnits.
                                                  NAME) {
                                              throw fatalError(
                                                      "name",
                                                      null);
                                          }
                                          type =
                                            scanner.
                                              next(
                                                );
                                          if (type ==
                                                org.apache.batik.xml.LexicalUnits.
                                                  S) {
                                              type =
                                                scanner.
                                                  next(
                                                    );
                                              switch (type) {
                                                  case org.apache.batik.xml.LexicalUnits.
                                                         PUBLIC_IDENTIFIER:
                                                      type =
                                                        scanner.
                                                          next(
                                                            );
                                                      if (type !=
                                                            org.apache.batik.xml.LexicalUnits.
                                                              S) {
                                                          throw fatalError(
                                                                  "space",
                                                                  null);
                                                      }
                                                      type =
                                                        scanner.
                                                          next(
                                                            );
                                                      if (type !=
                                                            org.apache.batik.xml.LexicalUnits.
                                                              STRING) {
                                                          throw fatalError(
                                                                  "string",
                                                                  null);
                                                      }
                                                      type =
                                                        scanner.
                                                          next(
                                                            );
                                                      if (type !=
                                                            org.apache.batik.xml.LexicalUnits.
                                                              S) {
                                                          throw fatalError(
                                                                  "space",
                                                                  null);
                                                      }
                                                      type =
                                                        scanner.
                                                          next(
                                                            );
                                                      if (type !=
                                                            org.apache.batik.xml.LexicalUnits.
                                                              STRING) {
                                                          throw fatalError(
                                                                  "string",
                                                                  null);
                                                      }
                                                      type =
                                                        scanner.
                                                          next(
                                                            );
                                                      if (type ==
                                                            org.apache.batik.xml.LexicalUnits.
                                                              S) {
                                                          type =
                                                            scanner.
                                                              next(
                                                                );
                                                      }
                                                      break;
                                                  case org.apache.batik.xml.LexicalUnits.
                                                         SYSTEM_IDENTIFIER:
                                                      type =
                                                        scanner.
                                                          next(
                                                            );
                                                      if (type !=
                                                            org.apache.batik.xml.LexicalUnits.
                                                              S) {
                                                          throw fatalError(
                                                                  "space",
                                                                  null);
                                                      }
                                                      type =
                                                        scanner.
                                                          next(
                                                            );
                                                      if (type !=
                                                            org.apache.batik.xml.LexicalUnits.
                                                              STRING) {
                                                          throw fatalError(
                                                                  "string",
                                                                  null);
                                                      }
                                                      type =
                                                        scanner.
                                                          next(
                                                            );
                                                      if (type ==
                                                            org.apache.batik.xml.LexicalUnits.
                                                              S) {
                                                          type =
                                                            scanner.
                                                              next(
                                                                );
                                                      }
                                              }
                                          }
                                          if (type ==
                                                org.apache.batik.xml.LexicalUnits.
                                                  LSQUARE_BRACKET) {
                                              do  {
                                                  type =
                                                    scanner.
                                                      next(
                                                        );
                                              }while(type !=
                                                       org.apache.batik.xml.LexicalUnits.
                                                         RSQUARE_BRACKET); 
                                          }
                                          if (type ==
                                                org.apache.batik.xml.LexicalUnits.
                                                  S) {
                                              type =
                                                scanner.
                                                  next(
                                                    );
                                          }
                                          if (type !=
                                                org.apache.batik.xml.LexicalUnits.
                                                  END_CHAR) {
                                              throw fatalError(
                                                      "end",
                                                      null);
                                          }
                                      }
                                      type =
                                        scanner.
                                          next(
                                            );
                              } }
    protected java.lang.String printElement()
          throws org.apache.batik.transcoder.TranscoderException,
        org.apache.batik.xml.XMLException,
        java.io.IOException { char[] name =
                                getCurrentValue(
                                  );
                              java.lang.String nameStr =
                                new java.lang.String(
                                name);
                              java.util.List attributes =
                                new java.util.LinkedList(
                                );
                              char[] space =
                                null;
                              type = scanner.
                                       next(
                                         );
                              while (type ==
                                       org.apache.batik.xml.LexicalUnits.
                                         S) {
                                  space =
                                    getCurrentValue(
                                      );
                                  type =
                                    scanner.
                                      next(
                                        );
                                  if (type ==
                                        org.apache.batik.xml.LexicalUnits.
                                          NAME) {
                                      char[] attName =
                                        getCurrentValue(
                                          );
                                      char[] space1 =
                                        null;
                                      type =
                                        scanner.
                                          next(
                                            );
                                      if (type ==
                                            org.apache.batik.xml.LexicalUnits.
                                              S) {
                                          space1 =
                                            getCurrentValue(
                                              );
                                          type =
                                            scanner.
                                              next(
                                                );
                                      }
                                      if (type !=
                                            org.apache.batik.xml.LexicalUnits.
                                              EQ) {
                                          throw fatalError(
                                                  "token",
                                                  new java.lang.Object[] { "=" });
                                      }
                                      type =
                                        scanner.
                                          next(
                                            );
                                      char[] space2 =
                                        null;
                                      if (type ==
                                            org.apache.batik.xml.LexicalUnits.
                                              S) {
                                          space2 =
                                            getCurrentValue(
                                              );
                                          type =
                                            scanner.
                                              next(
                                                );
                                      }
                                      if (type !=
                                            org.apache.batik.xml.LexicalUnits.
                                              STRING &&
                                            type !=
                                            org.apache.batik.xml.LexicalUnits.
                                              FIRST_ATTRIBUTE_FRAGMENT) {
                                          throw fatalError(
                                                  "string",
                                                  null);
                                      }
                                      char valueDelim =
                                        scanner.
                                        getStringDelimiter(
                                          );
                                      boolean hasEntityRef =
                                        false;
                                      java.lang.StringBuffer sb =
                                        new java.lang.StringBuffer(
                                        );
                                      sb.
                                        append(
                                          getCurrentValue(
                                            ));
                                      loop: for (;
                                                 ;
                                                 ) {
                                          scanner.
                                            clearBuffer(
                                              );
                                          type =
                                            scanner.
                                              next(
                                                );
                                          switch (type) {
                                              case org.apache.batik.xml.LexicalUnits.
                                                     STRING:
                                              case org.apache.batik.xml.LexicalUnits.
                                                     FIRST_ATTRIBUTE_FRAGMENT:
                                              case org.apache.batik.xml.LexicalUnits.
                                                     LAST_ATTRIBUTE_FRAGMENT:
                                              case org.apache.batik.xml.LexicalUnits.
                                                     ATTRIBUTE_FRAGMENT:
                                                  sb.
                                                    append(
                                                      getCurrentValue(
                                                        ));
                                                  break;
                                              case org.apache.batik.xml.LexicalUnits.
                                                     CHARACTER_REFERENCE:
                                                  hasEntityRef =
                                                    true;
                                                  sb.
                                                    append(
                                                      "&#");
                                                  sb.
                                                    append(
                                                      getCurrentValue(
                                                        ));
                                                  sb.
                                                    append(
                                                      ";");
                                                  break;
                                              case org.apache.batik.xml.LexicalUnits.
                                                     ENTITY_REFERENCE:
                                                  hasEntityRef =
                                                    true;
                                                  sb.
                                                    append(
                                                      "&");
                                                  sb.
                                                    append(
                                                      getCurrentValue(
                                                        ));
                                                  sb.
                                                    append(
                                                      ";");
                                                  break;
                                              default:
                                                  break loop;
                                          }
                                      }
                                      attributes.
                                        add(
                                          new org.apache.batik.transcoder.svg2svg.OutputManager.AttributeInfo(
                                            space,
                                            attName,
                                            space1,
                                            space2,
                                            new java.lang.String(
                                              sb),
                                            valueDelim,
                                            hasEntityRef));
                                      space =
                                        null;
                                  }
                              }
                              output.printElementStart(
                                       name,
                                       attributes,
                                       space);
                              switch (type) {
                                  default:
                                      throw fatalError(
                                              "xml",
                                              null);
                                  case org.apache.batik.xml.LexicalUnits.
                                         EMPTY_ELEMENT_END:
                                      output.
                                        printElementEnd(
                                          null,
                                          null);
                                      break;
                                  case org.apache.batik.xml.LexicalUnits.
                                         END_CHAR:
                                      output.
                                        printCharacter(
                                          '>');
                                      type =
                                        scanner.
                                          next(
                                            );
                                      printContent(
                                        allowSpaceAtStart(
                                          nameStr));
                                      if (type !=
                                            org.apache.batik.xml.LexicalUnits.
                                              END_TAG) {
                                          throw fatalError(
                                                  "end.tag",
                                                  null);
                                      }
                                      name =
                                        getCurrentValue(
                                          );
                                      type =
                                        scanner.
                                          next(
                                            );
                                      space =
                                        null;
                                      if (type ==
                                            org.apache.batik.xml.LexicalUnits.
                                              S) {
                                          space =
                                            getCurrentValue(
                                              );
                                          type =
                                            scanner.
                                              next(
                                                );
                                      }
                                      output.
                                        printElementEnd(
                                          name,
                                          space);
                                      if (type !=
                                            org.apache.batik.xml.LexicalUnits.
                                              END_CHAR) {
                                          throw fatalError(
                                                  "end",
                                                  null);
                                      }
                              }
                              type = scanner.
                                       next(
                                         );
                              return nameStr;
    }
    boolean allowSpaceAtStart(java.lang.String tagName) {
        return true;
    }
    protected void printContent(boolean spaceAtStart)
          throws org.apache.batik.transcoder.TranscoderException,
        org.apache.batik.xml.XMLException,
        java.io.IOException { boolean preceedingSpace =
                                false;
                              content: for (;
                                            ;
                                            ) {
                                  switch (type) {
                                      case org.apache.batik.xml.LexicalUnits.
                                             COMMENT:
                                          output.
                                            printComment(
                                              getCurrentValue(
                                                ));
                                          scanner.
                                            clearBuffer(
                                              );
                                          type =
                                            scanner.
                                              next(
                                                );
                                          preceedingSpace =
                                            false;
                                          break;
                                      case org.apache.batik.xml.LexicalUnits.
                                             PI_START:
                                          printPI(
                                            );
                                          preceedingSpace =
                                            false;
                                          break;
                                      case org.apache.batik.xml.LexicalUnits.
                                             CHARACTER_DATA:
                                          preceedingSpace =
                                            output.
                                              printCharacterData(
                                                getCurrentValue(
                                                  ),
                                                spaceAtStart,
                                                preceedingSpace);
                                          scanner.
                                            clearBuffer(
                                              );
                                          type =
                                            scanner.
                                              next(
                                                );
                                          spaceAtStart =
                                            false;
                                          break;
                                      case org.apache.batik.xml.LexicalUnits.
                                             CDATA_START:
                                          type =
                                            scanner.
                                              next(
                                                );
                                          if (type !=
                                                org.apache.batik.xml.LexicalUnits.
                                                  CHARACTER_DATA) {
                                              throw fatalError(
                                                      "character.data",
                                                      null);
                                          }
                                          output.
                                            printCDATASection(
                                              getCurrentValue(
                                                ));
                                          if (scanner.
                                                next(
                                                  ) !=
                                                org.apache.batik.xml.LexicalUnits.
                                                  SECTION_END) {
                                              throw fatalError(
                                                      "section.end",
                                                      null);
                                          }
                                          scanner.
                                            clearBuffer(
                                              );
                                          type =
                                            scanner.
                                              next(
                                                );
                                          preceedingSpace =
                                            false;
                                          spaceAtStart =
                                            false;
                                          break;
                                      case org.apache.batik.xml.LexicalUnits.
                                             START_TAG:
                                          java.lang.String name =
                                            printElement(
                                              );
                                          spaceAtStart =
                                            allowSpaceAtStart(
                                              name);
                                          break;
                                      case org.apache.batik.xml.LexicalUnits.
                                             CHARACTER_REFERENCE:
                                          output.
                                            printCharacterEntityReference(
                                              getCurrentValue(
                                                ),
                                              spaceAtStart,
                                              preceedingSpace);
                                          scanner.
                                            clearBuffer(
                                              );
                                          type =
                                            scanner.
                                              next(
                                                );
                                          spaceAtStart =
                                            false;
                                          preceedingSpace =
                                            false;
                                          break;
                                      case org.apache.batik.xml.LexicalUnits.
                                             ENTITY_REFERENCE:
                                          output.
                                            printEntityReference(
                                              getCurrentValue(
                                                ),
                                              spaceAtStart);
                                          scanner.
                                            clearBuffer(
                                              );
                                          type =
                                            scanner.
                                              next(
                                                );
                                          spaceAtStart =
                                            false;
                                          preceedingSpace =
                                            false;
                                          break;
                                      default:
                                          break content;
                                  }
                              } }
    protected void printNotation() throws org.apache.batik.transcoder.TranscoderException,
        org.apache.batik.xml.XMLException,
        java.io.IOException { int t = scanner.
                                next(
                                  );
                              if (t != org.apache.batik.xml.LexicalUnits.
                                         S) {
                                  throw fatalError(
                                          "space",
                                          null);
                              }
                              char[] space1 =
                                getCurrentValue(
                                  );
                              t = scanner.
                                    next(
                                      );
                              if (t != org.apache.batik.xml.LexicalUnits.
                                         NAME) {
                                  throw fatalError(
                                          "name",
                                          null);
                              }
                              char[] name =
                                getCurrentValue(
                                  );
                              t = scanner.
                                    next(
                                      );
                              if (t != org.apache.batik.xml.LexicalUnits.
                                         S) {
                                  throw fatalError(
                                          "space",
                                          null);
                              }
                              char[] space2 =
                                getCurrentValue(
                                  );
                              t = scanner.
                                    next(
                                      );
                              java.lang.String externalId =
                                null;
                              char[] space3 =
                                null;
                              char[] string1 =
                                null;
                              char string1Delim =
                                0;
                              char[] space4 =
                                null;
                              char[] string2 =
                                null;
                              char string2Delim =
                                0;
                              switch (t) {
                                  default:
                                      throw fatalError(
                                              "notation.definition",
                                              null);
                                  case org.apache.batik.xml.LexicalUnits.
                                         PUBLIC_IDENTIFIER:
                                      externalId =
                                        "PUBLIC";
                                      t =
                                        scanner.
                                          next(
                                            );
                                      if (t !=
                                            org.apache.batik.xml.LexicalUnits.
                                              S) {
                                          throw fatalError(
                                                  "space",
                                                  null);
                                      }
                                      space3 =
                                        getCurrentValue(
                                          );
                                      t =
                                        scanner.
                                          next(
                                            );
                                      if (t !=
                                            org.apache.batik.xml.LexicalUnits.
                                              STRING) {
                                          throw fatalError(
                                                  "string",
                                                  null);
                                      }
                                      string1 =
                                        getCurrentValue(
                                          );
                                      string1Delim =
                                        scanner.
                                          getStringDelimiter(
                                            );
                                      t =
                                        scanner.
                                          next(
                                            );
                                      if (t ==
                                            org.apache.batik.xml.LexicalUnits.
                                              S) {
                                          space4 =
                                            getCurrentValue(
                                              );
                                          t =
                                            scanner.
                                              next(
                                                );
                                          if (t ==
                                                org.apache.batik.xml.LexicalUnits.
                                                  STRING) {
                                              string2 =
                                                getCurrentValue(
                                                  );
                                              string2Delim =
                                                scanner.
                                                  getStringDelimiter(
                                                    );
                                              t =
                                                scanner.
                                                  next(
                                                    );
                                          }
                                      }
                                      break;
                                  case org.apache.batik.xml.LexicalUnits.
                                         SYSTEM_IDENTIFIER:
                                      externalId =
                                        "SYSTEM";
                                      t =
                                        scanner.
                                          next(
                                            );
                                      if (t !=
                                            org.apache.batik.xml.LexicalUnits.
                                              S) {
                                          throw fatalError(
                                                  "space",
                                                  null);
                                      }
                                      space3 =
                                        getCurrentValue(
                                          );
                                      t =
                                        scanner.
                                          next(
                                            );
                                      if (t !=
                                            org.apache.batik.xml.LexicalUnits.
                                              STRING) {
                                          throw fatalError(
                                                  "string",
                                                  null);
                                      }
                                      string1 =
                                        getCurrentValue(
                                          );
                                      string1Delim =
                                        scanner.
                                          getStringDelimiter(
                                            );
                                      t =
                                        scanner.
                                          next(
                                            );
                              }
                              char[] space5 =
                                null;
                              if (t == org.apache.batik.xml.LexicalUnits.
                                         S) {
                                  space5 =
                                    getCurrentValue(
                                      );
                                  t =
                                    scanner.
                                      next(
                                        );
                              }
                              if (t != org.apache.batik.xml.LexicalUnits.
                                         END_CHAR) {
                                  throw fatalError(
                                          "end",
                                          null);
                              }
                              output.printNotation(
                                       space1,
                                       name,
                                       space2,
                                       externalId,
                                       space3,
                                       string1,
                                       string1Delim,
                                       space4,
                                       string2,
                                       string2Delim,
                                       space5);
                              scanner.next(
                                        );
    }
    protected void printAttlist() throws org.apache.batik.transcoder.TranscoderException,
        org.apache.batik.xml.XMLException,
        java.io.IOException { type = scanner.
                                       next(
                                         );
                              if (type !=
                                    org.apache.batik.xml.LexicalUnits.
                                      S) {
                                  throw fatalError(
                                          "space",
                                          null);
                              }
                              char[] space =
                                getCurrentValue(
                                  );
                              type = scanner.
                                       next(
                                         );
                              if (type !=
                                    org.apache.batik.xml.LexicalUnits.
                                      NAME) {
                                  throw fatalError(
                                          "name",
                                          null);
                              }
                              char[] name =
                                getCurrentValue(
                                  );
                              type = scanner.
                                       next(
                                         );
                              output.printAttlistStart(
                                       space,
                                       name);
                              while (type ==
                                       org.apache.batik.xml.LexicalUnits.
                                         S) {
                                  space =
                                    getCurrentValue(
                                      );
                                  type =
                                    scanner.
                                      next(
                                        );
                                  if (type !=
                                        org.apache.batik.xml.LexicalUnits.
                                          NAME) {
                                      break;
                                  }
                                  name =
                                    getCurrentValue(
                                      );
                                  type =
                                    scanner.
                                      next(
                                        );
                                  if (type !=
                                        org.apache.batik.xml.LexicalUnits.
                                          S) {
                                      throw fatalError(
                                              "space",
                                              null);
                                  }
                                  char[] space2 =
                                    getCurrentValue(
                                      );
                                  type =
                                    scanner.
                                      next(
                                        );
                                  output.
                                    printAttName(
                                      space,
                                      name,
                                      space2);
                                  switch (type) {
                                      case org.apache.batik.xml.LexicalUnits.
                                             CDATA_IDENTIFIER:
                                      case org.apache.batik.xml.LexicalUnits.
                                             ID_IDENTIFIER:
                                      case org.apache.batik.xml.LexicalUnits.
                                             IDREF_IDENTIFIER:
                                      case org.apache.batik.xml.LexicalUnits.
                                             IDREFS_IDENTIFIER:
                                      case org.apache.batik.xml.LexicalUnits.
                                             ENTITY_IDENTIFIER:
                                      case org.apache.batik.xml.LexicalUnits.
                                             ENTITIES_IDENTIFIER:
                                      case org.apache.batik.xml.LexicalUnits.
                                             NMTOKEN_IDENTIFIER:
                                      case org.apache.batik.xml.LexicalUnits.
                                             NMTOKENS_IDENTIFIER:
                                          output.
                                            printCharacters(
                                              getCurrentValue(
                                                ));
                                          type =
                                            scanner.
                                              next(
                                                );
                                          break;
                                      case org.apache.batik.xml.LexicalUnits.
                                             NOTATION_IDENTIFIER:
                                          output.
                                            printCharacters(
                                              getCurrentValue(
                                                ));
                                          type =
                                            scanner.
                                              next(
                                                );
                                          if (type !=
                                                org.apache.batik.xml.LexicalUnits.
                                                  S) {
                                              throw fatalError(
                                                      "space",
                                                      null);
                                          }
                                          output.
                                            printSpaces(
                                              getCurrentValue(
                                                ),
                                              false);
                                          type =
                                            scanner.
                                              next(
                                                );
                                          if (type !=
                                                org.apache.batik.xml.LexicalUnits.
                                                  LEFT_BRACE) {
                                              throw fatalError(
                                                      "left.brace",
                                                      null);
                                          }
                                          type =
                                            scanner.
                                              next(
                                                );
                                          java.util.List names =
                                            new java.util.LinkedList(
                                            );
                                          space =
                                            null;
                                          if (type ==
                                                org.apache.batik.xml.LexicalUnits.
                                                  S) {
                                              space =
                                                getCurrentValue(
                                                  );
                                              type =
                                                scanner.
                                                  next(
                                                    );
                                          }
                                          if (type !=
                                                org.apache.batik.xml.LexicalUnits.
                                                  NAME) {
                                              throw fatalError(
                                                      "name",
                                                      null);
                                          }
                                          name =
                                            getCurrentValue(
                                              );
                                          type =
                                            scanner.
                                              next(
                                                );
                                          space2 =
                                            null;
                                          if (type ==
                                                org.apache.batik.xml.LexicalUnits.
                                                  S) {
                                              space2 =
                                                getCurrentValue(
                                                  );
                                              type =
                                                scanner.
                                                  next(
                                                    );
                                          }
                                          names.
                                            add(
                                              new org.apache.batik.transcoder.svg2svg.OutputManager.NameInfo(
                                                space,
                                                name,
                                                space2));
                                          loop: for (;
                                                     ;
                                                     ) {
                                              switch (type) {
                                                  default:
                                                      break loop;
                                                  case org.apache.batik.xml.LexicalUnits.
                                                         PIPE:
                                                      type =
                                                        scanner.
                                                          next(
                                                            );
                                                      space =
                                                        null;
                                                      if (type ==
                                                            org.apache.batik.xml.LexicalUnits.
                                                              S) {
                                                          space =
                                                            getCurrentValue(
                                                              );
                                                          type =
                                                            scanner.
                                                              next(
                                                                );
                                                      }
                                                      if (type !=
                                                            org.apache.batik.xml.LexicalUnits.
                                                              NAME) {
                                                          throw fatalError(
                                                                  "name",
                                                                  null);
                                                      }
                                                      name =
                                                        getCurrentValue(
                                                          );
                                                      type =
                                                        scanner.
                                                          next(
                                                            );
                                                      space2 =
                                                        null;
                                                      if (type ==
                                                            org.apache.batik.xml.LexicalUnits.
                                                              S) {
                                                          space2 =
                                                            getCurrentValue(
                                                              );
                                                          type =
                                                            scanner.
                                                              next(
                                                                );
                                                      }
                                                      names.
                                                        add(
                                                          new org.apache.batik.transcoder.svg2svg.OutputManager.NameInfo(
                                                            space,
                                                            name,
                                                            space2));
                                              }
                                          }
                                          if (type !=
                                                org.apache.batik.xml.LexicalUnits.
                                                  RIGHT_BRACE) {
                                              throw fatalError(
                                                      "right.brace",
                                                      null);
                                          }
                                          output.
                                            printEnumeration(
                                              names);
                                          type =
                                            scanner.
                                              next(
                                                );
                                          break;
                                      case org.apache.batik.xml.LexicalUnits.
                                             LEFT_BRACE:
                                          type =
                                            scanner.
                                              next(
                                                );
                                          names =
                                            new java.util.LinkedList(
                                              );
                                          space =
                                            null;
                                          if (type ==
                                                org.apache.batik.xml.LexicalUnits.
                                                  S) {
                                              space =
                                                getCurrentValue(
                                                  );
                                              type =
                                                scanner.
                                                  next(
                                                    );
                                          }
                                          if (type !=
                                                org.apache.batik.xml.LexicalUnits.
                                                  NMTOKEN) {
                                              throw fatalError(
                                                      "nmtoken",
                                                      null);
                                          }
                                          name =
                                            getCurrentValue(
                                              );
                                          type =
                                            scanner.
                                              next(
                                                );
                                          space2 =
                                            null;
                                          if (type ==
                                                org.apache.batik.xml.LexicalUnits.
                                                  S) {
                                              space2 =
                                                getCurrentValue(
                                                  );
                                              type =
                                                scanner.
                                                  next(
                                                    );
                                          }
                                          names.
                                            add(
                                              new org.apache.batik.transcoder.svg2svg.OutputManager.NameInfo(
                                                space,
                                                name,
                                                space2));
                                          loop: for (;
                                                     ;
                                                     ) {
                                              switch (type) {
                                                  default:
                                                      break loop;
                                                  case org.apache.batik.xml.LexicalUnits.
                                                         PIPE:
                                                      type =
                                                        scanner.
                                                          next(
                                                            );
                                                      space =
                                                        null;
                                                      if (type ==
                                                            org.apache.batik.xml.LexicalUnits.
                                                              S) {
                                                          space =
                                                            getCurrentValue(
                                                              );
                                                          type =
                                                            scanner.
                                                              next(
                                                                );
                                                      }
                                                      if (type !=
                                                            org.apache.batik.xml.LexicalUnits.
                                                              NMTOKEN) {
                                                          throw fatalError(
                                                                  "nmtoken",
                                                                  null);
                                                      }
                                                      name =
                                                        getCurrentValue(
                                                          );
                                                      type =
                                                        scanner.
                                                          next(
                                                            );
                                                      space2 =
                                                        null;
                                                      if (type ==
                                                            org.apache.batik.xml.LexicalUnits.
                                                              S) {
                                                          space2 =
                                                            getCurrentValue(
                                                              );
                                                          type =
                                                            scanner.
                                                              next(
                                                                );
                                                      }
                                                      names.
                                                        add(
                                                          new org.apache.batik.transcoder.svg2svg.OutputManager.NameInfo(
                                                            space,
                                                            name,
                                                            space2));
                                              }
                                          }
                                          if (type !=
                                                org.apache.batik.xml.LexicalUnits.
                                                  RIGHT_BRACE) {
                                              throw fatalError(
                                                      "right.brace",
                                                      null);
                                          }
                                          output.
                                            printEnumeration(
                                              names);
                                          type =
                                            scanner.
                                              next(
                                                );
                                  }
                                  if (type ==
                                        org.apache.batik.xml.LexicalUnits.
                                          S) {
                                      output.
                                        printSpaces(
                                          getCurrentValue(
                                            ),
                                          true);
                                      type =
                                        scanner.
                                          next(
                                            );
                                  }
                                  switch (type) {
                                      default:
                                          throw fatalError(
                                                  "default.decl",
                                                  null);
                                      case org.apache.batik.xml.LexicalUnits.
                                             REQUIRED_IDENTIFIER:
                                      case org.apache.batik.xml.LexicalUnits.
                                             IMPLIED_IDENTIFIER:
                                          output.
                                            printCharacters(
                                              getCurrentValue(
                                                ));
                                          type =
                                            scanner.
                                              next(
                                                );
                                          break;
                                      case org.apache.batik.xml.LexicalUnits.
                                             FIXED_IDENTIFIER:
                                          output.
                                            printCharacters(
                                              getCurrentValue(
                                                ));
                                          type =
                                            scanner.
                                              next(
                                                );
                                          if (type !=
                                                org.apache.batik.xml.LexicalUnits.
                                                  S) {
                                              throw fatalError(
                                                      "space",
                                                      null);
                                          }
                                          output.
                                            printSpaces(
                                              getCurrentValue(
                                                ),
                                              false);
                                          type =
                                            scanner.
                                              next(
                                                );
                                          if (type !=
                                                org.apache.batik.xml.LexicalUnits.
                                                  STRING &&
                                                type !=
                                                org.apache.batik.xml.LexicalUnits.
                                                  FIRST_ATTRIBUTE_FRAGMENT) {
                                              throw fatalError(
                                                      "space",
                                                      null);
                                          }
                                      case org.apache.batik.xml.LexicalUnits.
                                             STRING:
                                      case org.apache.batik.xml.LexicalUnits.
                                             FIRST_ATTRIBUTE_FRAGMENT:
                                          output.
                                            printCharacter(
                                              scanner.
                                                getStringDelimiter(
                                                  ));
                                          output.
                                            printCharacters(
                                              getCurrentValue(
                                                ));
                                          loop: for (;
                                                     ;
                                                     ) {
                                              type =
                                                scanner.
                                                  next(
                                                    );
                                              switch (type) {
                                                  case org.apache.batik.xml.LexicalUnits.
                                                         STRING:
                                                  case org.apache.batik.xml.LexicalUnits.
                                                         ATTRIBUTE_FRAGMENT:
                                                  case org.apache.batik.xml.LexicalUnits.
                                                         FIRST_ATTRIBUTE_FRAGMENT:
                                                  case org.apache.batik.xml.LexicalUnits.
                                                         LAST_ATTRIBUTE_FRAGMENT:
                                                      output.
                                                        printCharacters(
                                                          getCurrentValue(
                                                            ));
                                                      break;
                                                  case org.apache.batik.xml.LexicalUnits.
                                                         CHARACTER_REFERENCE:
                                                      output.
                                                        printString(
                                                          "&#");
                                                      output.
                                                        printCharacters(
                                                          getCurrentValue(
                                                            ));
                                                      output.
                                                        printCharacter(
                                                          ';');
                                                      break;
                                                  case org.apache.batik.xml.LexicalUnits.
                                                         ENTITY_REFERENCE:
                                                      output.
                                                        printCharacter(
                                                          '&');
                                                      output.
                                                        printCharacters(
                                                          getCurrentValue(
                                                            ));
                                                      output.
                                                        printCharacter(
                                                          ';');
                                                      break;
                                                  default:
                                                      break loop;
                                              }
                                          }
                                          output.
                                            printCharacter(
                                              scanner.
                                                getStringDelimiter(
                                                  ));
                                  }
                                  space =
                                    null;
                              }
                              if (type !=
                                    org.apache.batik.xml.LexicalUnits.
                                      END_CHAR) {
                                  throw fatalError(
                                          "end",
                                          null);
                              }
                              output.printAttlistEnd(
                                       space);
                              type = scanner.
                                       next(
                                         );
    }
    protected void printEntityDeclaration()
          throws org.apache.batik.transcoder.TranscoderException,
        org.apache.batik.xml.XMLException,
        java.io.IOException { writer.write(
                                       "<!ENTITY");
                              type = scanner.
                                       next(
                                         );
                              if (type !=
                                    org.apache.batik.xml.LexicalUnits.
                                      S) {
                                  throw fatalError(
                                          "space",
                                          null);
                              }
                              writer.write(
                                       getCurrentValue(
                                         ));
                              type = scanner.
                                       next(
                                         );
                              boolean pe =
                                false;
                              switch (type) {
                                  default:
                                      throw fatalError(
                                              "xml",
                                              null);
                                  case org.apache.batik.xml.LexicalUnits.
                                         NAME:
                                      writer.
                                        write(
                                          getCurrentValue(
                                            ));
                                      type =
                                        scanner.
                                          next(
                                            );
                                      break;
                                  case org.apache.batik.xml.LexicalUnits.
                                         PERCENT:
                                      pe =
                                        true;
                                      writer.
                                        write(
                                          '%');
                                      type =
                                        scanner.
                                          next(
                                            );
                                      if (type !=
                                            org.apache.batik.xml.LexicalUnits.
                                              S) {
                                          throw fatalError(
                                                  "space",
                                                  null);
                                      }
                                      writer.
                                        write(
                                          getCurrentValue(
                                            ));
                                      type =
                                        scanner.
                                          next(
                                            );
                                      if (type !=
                                            org.apache.batik.xml.LexicalUnits.
                                              NAME) {
                                          throw fatalError(
                                                  "name",
                                                  null);
                                      }
                                      writer.
                                        write(
                                          getCurrentValue(
                                            ));
                                      type =
                                        scanner.
                                          next(
                                            );
                              }
                              if (type !=
                                    org.apache.batik.xml.LexicalUnits.
                                      S) {
                                  throw fatalError(
                                          "space",
                                          null);
                              }
                              writer.write(
                                       getCurrentValue(
                                         ));
                              type = scanner.
                                       next(
                                         );
                              switch (type) {
                                  case org.apache.batik.xml.LexicalUnits.
                                         STRING:
                                  case org.apache.batik.xml.LexicalUnits.
                                         FIRST_ATTRIBUTE_FRAGMENT:
                                      char sd =
                                        scanner.
                                        getStringDelimiter(
                                          );
                                      writer.
                                        write(
                                          sd);
                                      loop: for (;
                                                 ;
                                                 ) {
                                          switch (type) {
                                              case org.apache.batik.xml.LexicalUnits.
                                                     STRING:
                                              case org.apache.batik.xml.LexicalUnits.
                                                     ATTRIBUTE_FRAGMENT:
                                              case org.apache.batik.xml.LexicalUnits.
                                                     FIRST_ATTRIBUTE_FRAGMENT:
                                              case org.apache.batik.xml.LexicalUnits.
                                                     LAST_ATTRIBUTE_FRAGMENT:
                                                  writer.
                                                    write(
                                                      getCurrentValue(
                                                        ));
                                                  break;
                                              case org.apache.batik.xml.LexicalUnits.
                                                     ENTITY_REFERENCE:
                                                  writer.
                                                    write(
                                                      '&');
                                                  writer.
                                                    write(
                                                      getCurrentValue(
                                                        ));
                                                  writer.
                                                    write(
                                                      ';');
                                                  break;
                                              case org.apache.batik.xml.LexicalUnits.
                                                     PARAMETER_ENTITY_REFERENCE:
                                                  writer.
                                                    write(
                                                      '&');
                                                  writer.
                                                    write(
                                                      getCurrentValue(
                                                        ));
                                                  writer.
                                                    write(
                                                      ';');
                                                  break;
                                              default:
                                                  break loop;
                                          }
                                          type =
                                            scanner.
                                              next(
                                                );
                                      }
                                      writer.
                                        write(
                                          sd);
                                      if (type ==
                                            org.apache.batik.xml.LexicalUnits.
                                              S) {
                                          writer.
                                            write(
                                              getCurrentValue(
                                                ));
                                          type =
                                            scanner.
                                              next(
                                                );
                                      }
                                      if (type !=
                                            org.apache.batik.xml.LexicalUnits.
                                              END_CHAR) {
                                          throw fatalError(
                                                  "end",
                                                  null);
                                      }
                                      writer.
                                        write(
                                          ">");
                                      type =
                                        scanner.
                                          next(
                                            );
                                      return;
                                  case org.apache.batik.xml.LexicalUnits.
                                         PUBLIC_IDENTIFIER:
                                      writer.
                                        write(
                                          "PUBLIC");
                                      type =
                                        scanner.
                                          next(
                                            );
                                      if (type !=
                                            org.apache.batik.xml.LexicalUnits.
                                              S) {
                                          throw fatalError(
                                                  "space",
                                                  null);
                                      }
                                      type =
                                        scanner.
                                          next(
                                            );
                                      if (type !=
                                            org.apache.batik.xml.LexicalUnits.
                                              STRING) {
                                          throw fatalError(
                                                  "string",
                                                  null);
                                      }
                                      writer.
                                        write(
                                          " \"");
                                      writer.
                                        write(
                                          getCurrentValue(
                                            ));
                                      writer.
                                        write(
                                          "\" \"");
                                      type =
                                        scanner.
                                          next(
                                            );
                                      if (type !=
                                            org.apache.batik.xml.LexicalUnits.
                                              S) {
                                          throw fatalError(
                                                  "space",
                                                  null);
                                      }
                                      type =
                                        scanner.
                                          next(
                                            );
                                      if (type !=
                                            org.apache.batik.xml.LexicalUnits.
                                              STRING) {
                                          throw fatalError(
                                                  "string",
                                                  null);
                                      }
                                      writer.
                                        write(
                                          getCurrentValue(
                                            ));
                                      writer.
                                        write(
                                          '\"');
                                      break;
                                  case org.apache.batik.xml.LexicalUnits.
                                         SYSTEM_IDENTIFIER:
                                      writer.
                                        write(
                                          "SYSTEM");
                                      type =
                                        scanner.
                                          next(
                                            );
                                      if (type !=
                                            org.apache.batik.xml.LexicalUnits.
                                              S) {
                                          throw fatalError(
                                                  "space",
                                                  null);
                                      }
                                      type =
                                        scanner.
                                          next(
                                            );
                                      if (type !=
                                            org.apache.batik.xml.LexicalUnits.
                                              STRING) {
                                          throw fatalError(
                                                  "string",
                                                  null);
                                      }
                                      writer.
                                        write(
                                          " \"");
                                      writer.
                                        write(
                                          getCurrentValue(
                                            ));
                                      writer.
                                        write(
                                          '\"');
                              }
                              type = scanner.
                                       next(
                                         );
                              if (type ==
                                    org.apache.batik.xml.LexicalUnits.
                                      S) {
                                  writer.
                                    write(
                                      getCurrentValue(
                                        ));
                                  type =
                                    scanner.
                                      next(
                                        );
                                  if (!pe &&
                                        type ==
                                        org.apache.batik.xml.LexicalUnits.
                                          NDATA_IDENTIFIER) {
                                      writer.
                                        write(
                                          "NDATA");
                                      type =
                                        scanner.
                                          next(
                                            );
                                      if (type !=
                                            org.apache.batik.xml.LexicalUnits.
                                              S) {
                                          throw fatalError(
                                                  "space",
                                                  null);
                                      }
                                      writer.
                                        write(
                                          getCurrentValue(
                                            ));
                                      type =
                                        scanner.
                                          next(
                                            );
                                      if (type !=
                                            org.apache.batik.xml.LexicalUnits.
                                              NAME) {
                                          throw fatalError(
                                                  "name",
                                                  null);
                                      }
                                      writer.
                                        write(
                                          getCurrentValue(
                                            ));
                                      type =
                                        scanner.
                                          next(
                                            );
                                  }
                                  if (type ==
                                        org.apache.batik.xml.LexicalUnits.
                                          S) {
                                      writer.
                                        write(
                                          getCurrentValue(
                                            ));
                                      type =
                                        scanner.
                                          next(
                                            );
                                  }
                              }
                              if (type !=
                                    org.apache.batik.xml.LexicalUnits.
                                      END_CHAR) {
                                  throw fatalError(
                                          "end",
                                          null);
                              }
                              writer.write(
                                       '>');
                              type = scanner.
                                       next(
                                         );
    }
    protected void printElementDeclaration()
          throws org.apache.batik.transcoder.TranscoderException,
        org.apache.batik.xml.XMLException,
        java.io.IOException { writer.write(
                                       "<!ELEMENT");
                              type = scanner.
                                       next(
                                         );
                              if (type !=
                                    org.apache.batik.xml.LexicalUnits.
                                      S) {
                                  throw fatalError(
                                          "space",
                                          null);
                              }
                              writer.write(
                                       getCurrentValue(
                                         ));
                              type = scanner.
                                       next(
                                         );
                              switch (type) {
                                  default:
                                      throw fatalError(
                                              "name",
                                              null);
                                  case org.apache.batik.xml.LexicalUnits.
                                         NAME:
                                      writer.
                                        write(
                                          getCurrentValue(
                                            ));
                              }
                              type = scanner.
                                       next(
                                         );
                              if (type !=
                                    org.apache.batik.xml.LexicalUnits.
                                      S) {
                                  throw fatalError(
                                          "space",
                                          null);
                              }
                              writer.write(
                                       getCurrentValue(
                                         ));
                              switch (type =
                                        scanner.
                                          next(
                                            )) {
                                  case org.apache.batik.xml.LexicalUnits.
                                         EMPTY_IDENTIFIER:
                                      writer.
                                        write(
                                          "EMPTY");
                                      type =
                                        scanner.
                                          next(
                                            );
                                      break;
                                  case org.apache.batik.xml.LexicalUnits.
                                         ANY_IDENTIFIER:
                                      writer.
                                        write(
                                          "ANY");
                                      type =
                                        scanner.
                                          next(
                                            );
                                      break;
                                  case org.apache.batik.xml.LexicalUnits.
                                         LEFT_BRACE:
                                      writer.
                                        write(
                                          '(');
                                      type =
                                        scanner.
                                          next(
                                            );
                                      if (type ==
                                            org.apache.batik.xml.LexicalUnits.
                                              S) {
                                          writer.
                                            write(
                                              getCurrentValue(
                                                ));
                                          type =
                                            scanner.
                                              next(
                                                );
                                      }
                                      mixed: switch (type) {
                                          case org.apache.batik.xml.LexicalUnits.
                                                 PCDATA_IDENTIFIER:
                                              writer.
                                                write(
                                                  "#PCDATA");
                                              type =
                                                scanner.
                                                  next(
                                                    );
                                              for (;
                                                   ;
                                                   ) {
                                                  switch (type) {
                                                      case org.apache.batik.xml.LexicalUnits.
                                                             S:
                                                          writer.
                                                            write(
                                                              getCurrentValue(
                                                                ));
                                                          type =
                                                            scanner.
                                                              next(
                                                                );
                                                          break;
                                                      case org.apache.batik.xml.LexicalUnits.
                                                             PIPE:
                                                          writer.
                                                            write(
                                                              '|');
                                                          type =
                                                            scanner.
                                                              next(
                                                                );
                                                          if (type ==
                                                                org.apache.batik.xml.LexicalUnits.
                                                                  S) {
                                                              writer.
                                                                write(
                                                                  getCurrentValue(
                                                                    ));
                                                              type =
                                                                scanner.
                                                                  next(
                                                                    );
                                                          }
                                                          if (type !=
                                                                org.apache.batik.xml.LexicalUnits.
                                                                  NAME) {
                                                              throw fatalError(
                                                                      "name",
                                                                      null);
                                                          }
                                                          writer.
                                                            write(
                                                              getCurrentValue(
                                                                ));
                                                          type =
                                                            scanner.
                                                              next(
                                                                );
                                                          break;
                                                      case org.apache.batik.xml.LexicalUnits.
                                                             RIGHT_BRACE:
                                                          writer.
                                                            write(
                                                              ')');
                                                          type =
                                                            scanner.
                                                              next(
                                                                );
                                                          break mixed;
                                                  }
                                              }
                                          case org.apache.batik.xml.LexicalUnits.
                                                 NAME:
                                          case org.apache.batik.xml.LexicalUnits.
                                                 LEFT_BRACE:
                                              printChildren(
                                                );
                                              if (type !=
                                                    org.apache.batik.xml.LexicalUnits.
                                                      RIGHT_BRACE) {
                                                  throw fatalError(
                                                          "right.brace",
                                                          null);
                                              }
                                              writer.
                                                write(
                                                  ')');
                                              type =
                                                scanner.
                                                  next(
                                                    );
                                              if (type ==
                                                    org.apache.batik.xml.LexicalUnits.
                                                      S) {
                                                  writer.
                                                    write(
                                                      getCurrentValue(
                                                        ));
                                                  type =
                                                    scanner.
                                                      next(
                                                        );
                                              }
                                              switch (type) {
                                                  case org.apache.batik.xml.LexicalUnits.
                                                         QUESTION:
                                                      writer.
                                                        write(
                                                          '?');
                                                      type =
                                                        scanner.
                                                          next(
                                                            );
                                                      break;
                                                  case org.apache.batik.xml.LexicalUnits.
                                                         STAR:
                                                      writer.
                                                        write(
                                                          '*');
                                                      type =
                                                        scanner.
                                                          next(
                                                            );
                                                      break;
                                                  case org.apache.batik.xml.LexicalUnits.
                                                         PLUS:
                                                      writer.
                                                        write(
                                                          '+');
                                                      type =
                                                        scanner.
                                                          next(
                                                            );
                                              }
                                      }
                              }
                              if (type ==
                                    org.apache.batik.xml.LexicalUnits.
                                      S) {
                                  writer.
                                    write(
                                      getCurrentValue(
                                        ));
                                  type =
                                    scanner.
                                      next(
                                        );
                              }
                              if (type !=
                                    org.apache.batik.xml.LexicalUnits.
                                      END_CHAR) {
                                  throw fatalError(
                                          "end",
                                          null);
                              }
                              writer.write(
                                       '>');
                              scanner.next(
                                        );
    }
    protected void printChildren() throws org.apache.batik.transcoder.TranscoderException,
        org.apache.batik.xml.XMLException,
        java.io.IOException { int op = 0;
                              loop: for (;
                                         ;
                                         ) {
                                  switch (type) {
                                      default:
                                          throw new java.lang.RuntimeException(
                                            "Invalid XML");
                                      case org.apache.batik.xml.LexicalUnits.
                                             NAME:
                                          writer.
                                            write(
                                              getCurrentValue(
                                                ));
                                          type =
                                            scanner.
                                              next(
                                                );
                                          break;
                                      case org.apache.batik.xml.LexicalUnits.
                                             LEFT_BRACE:
                                          writer.
                                            write(
                                              '(');
                                          type =
                                            scanner.
                                              next(
                                                );
                                          if (type ==
                                                org.apache.batik.xml.LexicalUnits.
                                                  S) {
                                              writer.
                                                write(
                                                  getCurrentValue(
                                                    ));
                                              type =
                                                scanner.
                                                  next(
                                                    );
                                          }
                                          printChildren(
                                            );
                                          if (type !=
                                                org.apache.batik.xml.LexicalUnits.
                                                  RIGHT_BRACE) {
                                              throw fatalError(
                                                      "right.brace",
                                                      null);
                                          }
                                          writer.
                                            write(
                                              ')');
                                          type =
                                            scanner.
                                              next(
                                                );
                                  }
                                  if (type ==
                                        org.apache.batik.xml.LexicalUnits.
                                          S) {
                                      writer.
                                        write(
                                          getCurrentValue(
                                            ));
                                      type =
                                        scanner.
                                          next(
                                            );
                                  }
                                  switch (type) {
                                      case org.apache.batik.xml.LexicalUnits.
                                             RIGHT_BRACE:
                                          break loop;
                                      case org.apache.batik.xml.LexicalUnits.
                                             STAR:
                                          writer.
                                            write(
                                              '*');
                                          type =
                                            scanner.
                                              next(
                                                );
                                          break;
                                      case org.apache.batik.xml.LexicalUnits.
                                             QUESTION:
                                          writer.
                                            write(
                                              '?');
                                          type =
                                            scanner.
                                              next(
                                                );
                                          break;
                                      case org.apache.batik.xml.LexicalUnits.
                                             PLUS:
                                          writer.
                                            write(
                                              '+');
                                          type =
                                            scanner.
                                              next(
                                                );
                                          break;
                                  }
                                  if (type ==
                                        org.apache.batik.xml.LexicalUnits.
                                          S) {
                                      writer.
                                        write(
                                          getCurrentValue(
                                            ));
                                      type =
                                        scanner.
                                          next(
                                            );
                                  }
                                  switch (type) {
                                      case org.apache.batik.xml.LexicalUnits.
                                             PIPE:
                                          if (op !=
                                                0 &&
                                                op !=
                                                type) {
                                              throw new java.lang.RuntimeException(
                                                "Invalid XML");
                                          }
                                          writer.
                                            write(
                                              '|');
                                          op =
                                            type;
                                          type =
                                            scanner.
                                              next(
                                                );
                                          break;
                                      case org.apache.batik.xml.LexicalUnits.
                                             COMMA:
                                          if (op !=
                                                0 &&
                                                op !=
                                                type) {
                                              throw new java.lang.RuntimeException(
                                                "Invalid XML");
                                          }
                                          writer.
                                            write(
                                              ',');
                                          op =
                                            type;
                                          type =
                                            scanner.
                                              next(
                                                );
                                  }
                                  if (type ==
                                        org.apache.batik.xml.LexicalUnits.
                                          S) {
                                      writer.
                                        write(
                                          getCurrentValue(
                                            ));
                                      type =
                                        scanner.
                                          next(
                                            );
                                  }
                              } }
    protected char[] getCurrentValue() { int off =
                                           scanner.
                                           getStart(
                                             ) +
                                           scanner.
                                           getStartOffset(
                                             );
                                         int len =
                                           scanner.
                                           getEnd(
                                             ) +
                                           scanner.
                                           getEndOffset(
                                             ) -
                                           off;
                                         char[] result =
                                           new char[len];
                                         char[] buffer =
                                           scanner.
                                           getBuffer(
                                             );
                                         java.lang.System.
                                           arraycopy(
                                             buffer,
                                             off,
                                             result,
                                             0,
                                             len);
                                         return result;
    }
    protected org.apache.batik.transcoder.TranscoderException fatalError(java.lang.String key,
                                                                         java.lang.Object[] params)
          throws org.apache.batik.transcoder.TranscoderException {
        org.apache.batik.transcoder.TranscoderException result =
          new org.apache.batik.transcoder.TranscoderException(
          key);
        errorHandler.
          fatalError(
            result);
        return result;
    }
    public PrettyPrinter() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "09XKqjekAVdHy6QSd/wOEXHTMTZQLDOW");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("uwsUzKjqZAAvx0ba8todH+Ejgi4KVdDW0FSFHosj7IIW1OICySoxNWz1iiyU" +
       "IbhtYsyip+uLWF33cNelzaGRdmfCyAykRb0mk1E3oztg/LTDgS8FowooxpQG" +
       "oNik02M7aM8dkKk5NjB6IvAKv/AyX+oScFBkUZ+u6NPFkpmZY9ddwhREJLaR" +
       "y9IgGaABrddrMyPCx01VajqtxWhquG1PqFZ8slY3bQlvtfXBCJ3apLUAuYd9" +
       "to7P4ubMVKaNmektjInVHtWzaIEQDDYfT+WiWOewTmkioGZ50MSYYUmi3Iif" +
       "lBJdAMZEtrBVthCp2iiTEpibLzqOVjSq3Xm1TChRrYHUkloz6Bphd9hc4/JK" +
       "Mw0lY5tdEhIbxRkWzzqLROFEZax0oUzPJz6rttjhx2ZtvPZJK6lyYLRJB2Eb" +
       "pUkR+Lg5XudgvGiVyxpd5LiEgwxqrsnF9XrYaFbTRo+DkMm4NpLdptcyI872" +
       "BivFUjB65TgBHMni0vJAiAx3AmRGppMoUefGJFx15IW0rkyMac0YhsJoToyw" +
       "tZZymU2N+YqkRTw70AMnlBJpZXkIrVOL6RxhslIdC9OxNEvNmDRtb1TiSKRJ" +
       "DNghG42CaknrGP3+uOlwgWbXVZXSrLBcdpMKLMAp8PVrtry2nQAbrehVXURo" +
       "MnNnNXw4G4tYucvgzEiZD7JJPYix9SCgUG2qr/10PmZhOCDRrNlvOH16VFo5" +
       "bNCdTny3hZXLg1YU+QMFJklpOZd7lIKg/QbUnXbXCttV5uvOajoS1kunSa4D" +
       "DqPIVkQNTLGPpkzfmTDUIkysWB+ZcltqZ/oizWbgVCXp6UqpTKNZZyqXuNmK" +
       "9ukWrHblBkoPe6akTUib5MeyVJ/pJTPF6VUTKrczgjK0VSueyqOysxD73eW8" +
       "wc8wuBkQXTtZ9iOiimJwuTYIYkQbCSTPKiOFoXpNDo5npA9GYaHs1GdJcaKK" +
       "3mxu4lqtkZbA2L3Igpo4bSDM1J1pKYotoxpFNcuSS5h6n1M7zaipNNbtUm00" +
       "xVBEUwD7IoiPuhzZnw9K626pbMfqYtW0ifEap8Z2LwsUW5A5Wa7j1SVdpeZx" +
       "r9qYKiaNNCWHUhq0BEFZt4jRvZlVHrGVjivJLbxYkfopTsGNfgUPltaKs8sy" +
       "RBZXBFmW4XptiAhwq1j1jLY6qGfD2pjQ+hEsmatYjuoEvl4Ukbnc9z2kv27Y" +
       "LN1mkzYWEmAiYq0XadeK1+FwmWioW5/NaS2cK2XHXMthX6lWnYZW1TMC5hCn" +
       "U9SprMiPq9AKkzVGntGmJY3qFtMUGIafy+lYX5aDhYss1QrbiubxGh0SJdSv" +
       "OY11gDfGzBK347pu9/Rk5Eyy2rxRl5jQJxLYrGqBBAtrXpsEnXKPtkUHJzGo" +
       "XDXhIFxR43KdI6eVVkKuUmLimrzeWyt9Lv9nKCvAQQyL9bqypngweZpGa9t1" +
       "1GLKVdcNiELatUnJhRcchqLoO/J/3X/p1l4pvGLzOuRoHfp38CJk++iNefL0" +
       "0Rujzd+lwumrOTc5H9+tfwuDwutOW16+WUP0wvs+/Lw0/vnywW6l4Dgq3Be5" +
       "3vdY8kq2TlT1alDTW09fL0VuVtcfr2D73Pv+56vZ79XedQtrdF+/h3O/yn9K" +
       "fvK3e28Sf/qgcPFoPdsN6/6vL/Ts9avY7g/kKA4c9rq1bK87kuzLconl69fC" +
       "nWTD/Xdxx7q7+Yu4t2x1v3l2vBDzwnGGD24y/PlehpMrNb+ZJ18D1hPK0Zwk" +
       "TrxpvOl7qJWrS8fG9PWXegV1srXNja9ez/7N4Fjv2K/vOHsyz3DhrtPZX7iU" +
       "3/x2BJqRI2z/dfn/OSJ6oXC7RPMFB+/dEX3vd0fNFx46g+jDefKyqPAyQJQ6" +
       "8fL9BMcH7gTHD+w4fuC7xPG1Z3B8Ik8e23JkTrzKP8Hx8dvlmL/W/9CO44e+" +
       "SxzfcgbHt+bJU1HhfsBxtF1rtEfxym1QfDi/mS88++iO4kfvDMWTDGpnPKvn" +
       "CQTYqdex++Axu9KdUOBzO3bP3XEF/uyGxjvPoNjKk2fBoAcU2N2swdrT39tv" +
       "g+Ejh/p7YcfwhTuvP+KMZ6M86QFy6klyP3tMrn+76nsGHL+4I/eLd1x92wFj" +
       "fgZDPk+YqPAwUB9747q0E3pkb4Pq5fxmvhD3szuqn73zepTOeKbkyTXAUr0p" +
       "S/KY5bvuRATwazuWv/ZdUqh3BtV86egF8ygCuH4t3wl1WrerzteD48Ud0Rfv" +
       "vDp/+IxnP5InCeCo3oTjCWW+5OLf8/TOz+04fu7OcDzYZDjY/D65epmWBWm7" +
       "7veHNxw/cHY56KyVxOzRZScVZe8o+AXlHjlsbzA+erZp7+/nyY9Fhbu9YPdl" +
       "wwlj+du3IcjDRfgXXrctuz3fiiC1lzSWf7j37OLRxPLCTx4yf+Np6/SP5JBn" +
       "/9Cmvo/nyUeiwgMbYeymEXsy+ejtygSMaxe+sZPJN+68TH7hDJnkyXPHdD+R" +
       "Jz8XFe7Z0KUGe0xfcsXvObR/8Mpt2e35zjL95fMz/ed58ulDxe5mSHt0P3Mb" +
       "dF+1o3tx96XDxRu+dLh9ui+en+6/yZNfP6Sb77cgb/v2iQj0N26Dbv4JeAH0" +
       "54uf2tH91C3QLZxv9vC7Z4jiC3nyOTDZFyzLTRjQuWU0YiIh2I/TPn+7JgwD" +
       "cr+xI/kbd0anN4TZf3B+xf5hnvyHQ8Vu9pu4wWl/8XY5Pwka//aO87fvvB3/" +
       "yfnp/rc8+VJUePmG7mj3v7A9vl++A27qruW27PZ8Z/l+7fx8/3eefOVQvWgU" +
       "HX44fYLun90u3WKhcPcPbstuz3eW7l+en+5f5ck3o8KjWzflRHqU7X0icIL4" +
       "X9wu8bcVCpcOtmW35ztK/ODecxM/uD9PLkaFx07651OZH9x1B3r0pXjHPL7z" +
       "zF95fuaP5snlwx7d1nRLCuR9vg/d7kh8BfD8/I7v5+883zec8ezJPHlNVLgM" +
       "5ijtOADktt+Xh0Hh6dNfA2z2K9h+Bf38P37qCz/6/FP/dfPJ/716yAkBGqg3" +
       "2e7mRJmvffJLX/n9l7/uU5stMu5aCuH2//T7+wTduA3Qdbv7bHg/cCTJjcBB" +
       "2Hbhwa0kt+eoYNzmJiz5NkxCEkG6LagylE9XRCjSFQViB90upgdyvmVBdrjl" +
       "y19ja1tT2n9TIGq7jaFOjN2b3/lnKQdv3n1ndHD15ha1+Sh685Lr6P3WJUt2" +
       "1ONv7A7e5KVH9e/N9h45/oCnbbmOnG+OcfjslYczuqONpcDD9KZIv7pFumks" +
       "//3UGfb7N8949vY8QcBcUczBbLGfkf37dr1106dfext9+slD7/3FXZ/+4p3p" +
       "0wfHKtoExgdXdqq4/ovX7WYQN7cB71D/5Dn1n+ctH+l+cKPu89sbicGnKNPb" +
       "CHfwUopkz3jG5QmdJ+/Yojgj7zzdnvunhrEXfnKTIf+X4kE7KtyvCJFgbb5q" +
       "9o8m4htG2K3YQAoGiet2SMq3eHn8ho3ZtpuJiZ96/vK9jz0//U9bD3i44dd9" +
       "ROFeJbaskztynLi+5AWyom/0ct8mfXArWyEqPHWOz+TzPQG2Vxvjede2sBQV" +
       "XnNGYSCf4x8ny4HqHtovB7ra5nwynwFqOM4H3Mn24mQWOypcBFnyS2djnHi6" +
       "tZ3HT/avXCWFh19KJSdeiD913fi12Unv8JVzvN1L75r46efx0Q99vf7z202P" +
       "QECzXue13AuGmu3+S7uh5uQ2Hfu1HdZ1qf/Mtx78zH1PH75if3AL+Livn8D2" +
       "+pvvKtSxvWizD9D6Vx/75bf/k+f/aLMfyv8H83lp3eJQAAA=");
}
