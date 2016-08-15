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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "a3EU00SkMIJTTF2oNQJtamHDa8+awwlb");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "OAjbLjy4leT2NyisbnMTlnwbJjkOIN2SFxqUT1cUKNDnc4in2m1c97R8y4L0" +
       "cMuXv8HWtqa0/6ZAWe42hjoxdm+u889SDt64+87o4OrNLWrzUfTmJdfR+61L" +
       "pmYvjr+xO3iDmxzVvzfbe+T4A56W6dhavjnG4bOXH87ojjaWAg+TmyL92hbp" +
       "prH8+ukz7Pdvn/HsrXlSB3NFJQezxX5G9h/c9dZNn37VbfTppw6995d3ffrL" +
       "d6ZPHxyraBMYH1zZqeL6L163m0Hc3AbcQ/3T59R/nhc+0j11o+7z2xuJoaco" +
       "090Il3oxRfJnPBvnyShPvn+L4oy8YrL97Zwaxl74uU2G/F+KB62gcP9cDmRz" +
       "81Xz+mgivmGE34oNJGCQuG6HpHyLl8dv2Jhtu5mY8snnLt/72HPCf956wMMN" +
       "v+7rF+6dh6Z5ckeOE+eXXE+b6xu93LdJH9zKVg4KT5/jM/l8T4Dt2cZ43r4t" +
       "rAaFV55RGMjn+OJkOVDdQ/vlQFfb/J7MtwI1HOcD7mR7cjKLFRQugiz5qb0x" +
       "zm6ytZ3HT/avXCWFh19MJSdeiD993fi12Unv8JVzuN1L75ryqee6zI9+o/rL" +
       "202PQECTZXkt94KhZrv/0m6oOblNx35th3Vd6jzz7Qc/fd/rD1+xP7gFfNzX" +
       "T2B7zc13FSIsN9jsA5T9xmO/9tZ/+twfbfZD+f8+OxCW4lAAAA==");
}
