package org.apache.batik.parser;
public class FragmentIdentifierParser extends org.apache.batik.parser.NumberParser {
    protected char[] buffer = new char[16];
    protected int bufferSize;
    protected org.apache.batik.parser.FragmentIdentifierHandler fragmentIdentifierHandler;
    public FragmentIdentifierParser() { super();
                                        fragmentIdentifierHandler = org.apache.batik.parser.DefaultFragmentIdentifierHandler.
                                                                      INSTANCE;
    }
    public void setFragmentIdentifierHandler(org.apache.batik.parser.FragmentIdentifierHandler handler) {
        fragmentIdentifierHandler =
          handler;
    }
    public org.apache.batik.parser.FragmentIdentifierHandler getFragmentIdentifierHandler() {
        return fragmentIdentifierHandler;
    }
    protected void doParse() throws org.apache.batik.parser.ParseException,
        java.io.IOException { bufferSize = 0;
                              current = reader.read(
                                                 );
                              fragmentIdentifierHandler.
                                startFragmentIdentifier(
                                  );
                              ident: { java.lang.String id =
                                         null;
                                       switch (current) {
                                           case 'x':
                                               bufferize(
                                                 );
                                               current =
                                                 reader.
                                                   read(
                                                     );
                                               if (current !=
                                                     'p') {
                                                   parseIdentifier(
                                                     );
                                                   break;
                                               }
                                               bufferize(
                                                 );
                                               current =
                                                 reader.
                                                   read(
                                                     );
                                               if (current !=
                                                     'o') {
                                                   parseIdentifier(
                                                     );
                                                   break;
                                               }
                                               bufferize(
                                                 );
                                               current =
                                                 reader.
                                                   read(
                                                     );
                                               if (current !=
                                                     'i') {
                                                   parseIdentifier(
                                                     );
                                                   break;
                                               }
                                               bufferize(
                                                 );
                                               current =
                                                 reader.
                                                   read(
                                                     );
                                               if (current !=
                                                     'n') {
                                                   parseIdentifier(
                                                     );
                                                   break;
                                               }
                                               bufferize(
                                                 );
                                               current =
                                                 reader.
                                                   read(
                                                     );
                                               if (current !=
                                                     't') {
                                                   parseIdentifier(
                                                     );
                                                   break;
                                               }
                                               bufferize(
                                                 );
                                               current =
                                                 reader.
                                                   read(
                                                     );
                                               if (current !=
                                                     'e') {
                                                   parseIdentifier(
                                                     );
                                                   break;
                                               }
                                               bufferize(
                                                 );
                                               current =
                                                 reader.
                                                   read(
                                                     );
                                               if (current !=
                                                     'r') {
                                                   parseIdentifier(
                                                     );
                                                   break;
                                               }
                                               bufferize(
                                                 );
                                               current =
                                                 reader.
                                                   read(
                                                     );
                                               if (current !=
                                                     '(') {
                                                   parseIdentifier(
                                                     );
                                                   break;
                                               }
                                               bufferSize =
                                                 0;
                                               current =
                                                 reader.
                                                   read(
                                                     );
                                               if (current !=
                                                     'i') {
                                                   reportCharacterExpectedError(
                                                     'i',
                                                     current);
                                                   break ident;
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
                                                   break ident;
                                               }
                                               current =
                                                 reader.
                                                   read(
                                                     );
                                               if (current !=
                                                     '(') {
                                                   reportCharacterExpectedError(
                                                     '(',
                                                     current);
                                                   break ident;
                                               }
                                               current =
                                                 reader.
                                                   read(
                                                     );
                                               if (current !=
                                                     '\"' &&
                                                     current !=
                                                     '\'') {
                                                   reportCharacterExpectedError(
                                                     '\'',
                                                     current);
                                                   break ident;
                                               }
                                               char q =
                                                 (char)
                                                   current;
                                               current =
                                                 reader.
                                                   read(
                                                     );
                                               parseIdentifier(
                                                 );
                                               id =
                                                 getBufferContent(
                                                   );
                                               bufferSize =
                                                 0;
                                               fragmentIdentifierHandler.
                                                 idReference(
                                                   id);
                                               if (current !=
                                                     q) {
                                                   reportCharacterExpectedError(
                                                     q,
                                                     current);
                                                   break ident;
                                               }
                                               current =
                                                 reader.
                                                   read(
                                                     );
                                               if (current !=
                                                     ')') {
                                                   reportCharacterExpectedError(
                                                     ')',
                                                     current);
                                                   break ident;
                                               }
                                               current =
                                                 reader.
                                                   read(
                                                     );
                                               if (current !=
                                                     ')') {
                                                   reportCharacterExpectedError(
                                                     ')',
                                                     current);
                                               }
                                               break ident;
                                           case 's':
                                               bufferize(
                                                 );
                                               current =
                                                 reader.
                                                   read(
                                                     );
                                               if (current !=
                                                     'v') {
                                                   parseIdentifier(
                                                     );
                                                   break;
                                               }
                                               bufferize(
                                                 );
                                               current =
                                                 reader.
                                                   read(
                                                     );
                                               if (current !=
                                                     'g') {
                                                   parseIdentifier(
                                                     );
                                                   break;
                                               }
                                               bufferize(
                                                 );
                                               current =
                                                 reader.
                                                   read(
                                                     );
                                               if (current !=
                                                     'V') {
                                                   parseIdentifier(
                                                     );
                                                   break;
                                               }
                                               bufferize(
                                                 );
                                               current =
                                                 reader.
                                                   read(
                                                     );
                                               if (current !=
                                                     'i') {
                                                   parseIdentifier(
                                                     );
                                                   break;
                                               }
                                               bufferize(
                                                 );
                                               current =
                                                 reader.
                                                   read(
                                                     );
                                               if (current !=
                                                     'e') {
                                                   parseIdentifier(
                                                     );
                                                   break;
                                               }
                                               bufferize(
                                                 );
                                               current =
                                                 reader.
                                                   read(
                                                     );
                                               if (current !=
                                                     'w') {
                                                   parseIdentifier(
                                                     );
                                                   break;
                                               }
                                               bufferize(
                                                 );
                                               current =
                                                 reader.
                                                   read(
                                                     );
                                               if (current !=
                                                     '(') {
                                                   parseIdentifier(
                                                     );
                                                   break;
                                               }
                                               bufferSize =
                                                 0;
                                               current =
                                                 reader.
                                                   read(
                                                     );
                                               parseViewAttributes(
                                                 );
                                               if (current !=
                                                     ')') {
                                                   reportCharacterExpectedError(
                                                     ')',
                                                     current);
                                               }
                                               break ident;
                                           default:
                                               if (current ==
                                                     -1 ||
                                                     !org.apache.batik.xml.XMLUtilities.
                                                     isXMLNameFirstCharacter(
                                                       (char)
                                                         current)) {
                                                   break ident;
                                               }
                                               bufferize(
                                                 );
                                               current =
                                                 reader.
                                                   read(
                                                     );
                                               parseIdentifier(
                                                 );
                                       }
                                       id =
                                         getBufferContent(
                                           );
                                       fragmentIdentifierHandler.
                                         idReference(
                                           id);
                              }
                              fragmentIdentifierHandler.
                                endFragmentIdentifier(
                                  ); }
    protected void parseViewAttributes() throws org.apache.batik.parser.ParseException,
        java.io.IOException { boolean first =
                                true;
                              loop: for (;
                                         ;
                                         ) {
                                  switch (current) {
                                      case -1:
                                      case ')':
                                          if (first) {
                                              reportUnexpectedCharacterError(
                                                current);
                                              break loop;
                                          }
                                      default:
                                          break loop;
                                      case ';':
                                          if (first) {
                                              reportUnexpectedCharacterError(
                                                current);
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          break;
                                      case 'v':
                                          first =
                                            false;
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                'i') {
                                              reportCharacterExpectedError(
                                                'i',
                                                current);
                                              break loop;
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
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                'w') {
                                              reportCharacterExpectedError(
                                                'w',
                                                current);
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          switch (current) {
                                              case 'B':
                                                  current =
                                                    reader.
                                                      read(
                                                        );
                                                  if (current !=
                                                        'o') {
                                                      reportCharacterExpectedError(
                                                        'o',
                                                        current);
                                                      break loop;
                                                  }
                                                  current =
                                                    reader.
                                                      read(
                                                        );
                                                  if (current !=
                                                        'x') {
                                                      reportCharacterExpectedError(
                                                        'x',
                                                        current);
                                                      break loop;
                                                  }
                                                  current =
                                                    reader.
                                                      read(
                                                        );
                                                  if (current !=
                                                        '(') {
                                                      reportCharacterExpectedError(
                                                        '(',
                                                        current);
                                                      break loop;
                                                  }
                                                  current =
                                                    reader.
                                                      read(
                                                        );
                                                  float x =
                                                    parseFloat(
                                                      );
                                                  if (current !=
                                                        ',') {
                                                      reportCharacterExpectedError(
                                                        ',',
                                                        current);
                                                      break loop;
                                                  }
                                                  current =
                                                    reader.
                                                      read(
                                                        );
                                                  float y =
                                                    parseFloat(
                                                      );
                                                  if (current !=
                                                        ',') {
                                                      reportCharacterExpectedError(
                                                        ',',
                                                        current);
                                                      break loop;
                                                  }
                                                  current =
                                                    reader.
                                                      read(
                                                        );
                                                  float w =
                                                    parseFloat(
                                                      );
                                                  if (current !=
                                                        ',') {
                                                      reportCharacterExpectedError(
                                                        ',',
                                                        current);
                                                      break loop;
                                                  }
                                                  current =
                                                    reader.
                                                      read(
                                                        );
                                                  float h =
                                                    parseFloat(
                                                      );
                                                  if (current !=
                                                        ')') {
                                                      reportCharacterExpectedError(
                                                        ')',
                                                        current);
                                                      break loop;
                                                  }
                                                  current =
                                                    reader.
                                                      read(
                                                        );
                                                  fragmentIdentifierHandler.
                                                    viewBox(
                                                      x,
                                                      y,
                                                      w,
                                                      h);
                                                  if (current !=
                                                        ')' &&
                                                        current !=
                                                        ';') {
                                                      reportCharacterExpectedError(
                                                        ')',
                                                        current);
                                                      break loop;
                                                  }
                                                  break;
                                              case 'T':
                                                  current =
                                                    reader.
                                                      read(
                                                        );
                                                  if (current !=
                                                        'a') {
                                                      reportCharacterExpectedError(
                                                        'a',
                                                        current);
                                                      break loop;
                                                  }
                                                  current =
                                                    reader.
                                                      read(
                                                        );
                                                  if (current !=
                                                        'r') {
                                                      reportCharacterExpectedError(
                                                        'r',
                                                        current);
                                                      break loop;
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
                                                      break loop;
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
                                                      break loop;
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
                                                      break loop;
                                                  }
                                                  current =
                                                    reader.
                                                      read(
                                                        );
                                                  if (current !=
                                                        '(') {
                                                      reportCharacterExpectedError(
                                                        '(',
                                                        current);
                                                      break loop;
                                                  }
                                                  current =
                                                    reader.
                                                      read(
                                                        );
                                                  fragmentIdentifierHandler.
                                                    startViewTarget(
                                                      );
                                                  id: for (;
                                                           ;
                                                           ) {
                                                      bufferSize =
                                                        0;
                                                      if (current ==
                                                            -1 ||
                                                            !org.apache.batik.xml.XMLUtilities.
                                                            isXMLNameFirstCharacter(
                                                              (char)
                                                                current)) {
                                                          reportUnexpectedCharacterError(
                                                            current);
                                                          break loop;
                                                      }
                                                      bufferize(
                                                        );
                                                      current =
                                                        reader.
                                                          read(
                                                            );
                                                      parseIdentifier(
                                                        );
                                                      java.lang.String s =
                                                        getBufferContent(
                                                          );
                                                      fragmentIdentifierHandler.
                                                        viewTarget(
                                                          s);
                                                      bufferSize =
                                                        0;
                                                      switch (current) {
                                                          case ')':
                                                              current =
                                                                reader.
                                                                  read(
                                                                    );
                                                              break id;
                                                          case ',':
                                                          case ';':
                                                              current =
                                                                reader.
                                                                  read(
                                                                    );
                                                              break;
                                                          default:
                                                              reportUnexpectedCharacterError(
                                                                current);
                                                              break loop;
                                                      }
                                                  }
                                                  fragmentIdentifierHandler.
                                                    endViewTarget(
                                                      );
                                                  break;
                                              default:
                                                  reportUnexpectedCharacterError(
                                                    current);
                                                  break loop;
                                          }
                                          break;
                                      case 'p':
                                          first =
                                            false;
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                'r') {
                                              reportCharacterExpectedError(
                                                'r',
                                                current);
                                              break loop;
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
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                's') {
                                              reportCharacterExpectedError(
                                                's',
                                                current);
                                              break loop;
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
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                'r') {
                                              reportCharacterExpectedError(
                                                'r',
                                                current);
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                'v') {
                                              reportCharacterExpectedError(
                                                'v',
                                                current);
                                              break loop;
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
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                'A') {
                                              reportCharacterExpectedError(
                                                'A',
                                                current);
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                's') {
                                              reportCharacterExpectedError(
                                                's',
                                                current);
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                'p') {
                                              reportCharacterExpectedError(
                                                'p',
                                                current);
                                              break loop;
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
                                              break loop;
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
                                              break loop;
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
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                'R') {
                                              reportCharacterExpectedError(
                                                'R',
                                                current);
                                              break loop;
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
                                              break loop;
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
                                              break loop;
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
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                'o') {
                                              reportCharacterExpectedError(
                                                'o',
                                                current);
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                '(') {
                                              reportCharacterExpectedError(
                                                '(',
                                                current);
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          parsePreserveAspectRatio(
                                            );
                                          if (current !=
                                                ')') {
                                              reportCharacterExpectedError(
                                                ')',
                                                current);
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          break;
                                      case 't':
                                          first =
                                            false;
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                'r') {
                                              reportCharacterExpectedError(
                                                'r',
                                                current);
                                              break loop;
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
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                'n') {
                                              reportCharacterExpectedError(
                                                'n',
                                                current);
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                's') {
                                              reportCharacterExpectedError(
                                                's',
                                                current);
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                'f') {
                                              reportCharacterExpectedError(
                                                'f',
                                                current);
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                'o') {
                                              reportCharacterExpectedError(
                                                'o',
                                                current);
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                'r') {
                                              reportCharacterExpectedError(
                                                'r',
                                                current);
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                'm') {
                                              reportCharacterExpectedError(
                                                'm',
                                                current);
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                '(') {
                                              reportCharacterExpectedError(
                                                '(',
                                                current);
                                              break loop;
                                          }
                                          fragmentIdentifierHandler.
                                            startTransformList(
                                              );
                                          tloop: for (;
                                                      ;
                                                      ) {
                                              try {
                                                  current =
                                                    reader.
                                                      read(
                                                        );
                                                  switch (current) {
                                                      case ',':
                                                          break;
                                                      case 'm':
                                                          parseMatrix(
                                                            );
                                                          break;
                                                      case 'r':
                                                          parseRotate(
                                                            );
                                                          break;
                                                      case 't':
                                                          parseTranslate(
                                                            );
                                                          break;
                                                      case 's':
                                                          current =
                                                            reader.
                                                              read(
                                                                );
                                                          switch (current) {
                                                              case 'c':
                                                                  parseScale(
                                                                    );
                                                                  break;
                                                              case 'k':
                                                                  parseSkew(
                                                                    );
                                                                  break;
                                                              default:
                                                                  reportUnexpectedCharacterError(
                                                                    current);
                                                                  skipTransform(
                                                                    );
                                                          }
                                                          break;
                                                      default:
                                                          break tloop;
                                                  }
                                              }
                                              catch (org.apache.batik.parser.ParseException e) {
                                                  errorHandler.
                                                    error(
                                                      e);
                                                  skipTransform(
                                                    );
                                              }
                                          }
                                          fragmentIdentifierHandler.
                                            endTransformList(
                                              );
                                          break;
                                      case 'z':
                                          first =
                                            false;
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                'o') {
                                              reportCharacterExpectedError(
                                                'o',
                                                current);
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                'o') {
                                              reportCharacterExpectedError(
                                                'o',
                                                current);
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                'm') {
                                              reportCharacterExpectedError(
                                                'm',
                                                current);
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                'A') {
                                              reportCharacterExpectedError(
                                                'A',
                                                current);
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                'n') {
                                              reportCharacterExpectedError(
                                                'n',
                                                current);
                                              break loop;
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
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                'P') {
                                              reportCharacterExpectedError(
                                                'P',
                                                current);
                                              break loop;
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
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                'n') {
                                              reportCharacterExpectedError(
                                                'n',
                                                current);
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          if (current !=
                                                '(') {
                                              reportCharacterExpectedError(
                                                '(',
                                                current);
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                          switch (current) {
                                              case 'm':
                                                  current =
                                                    reader.
                                                      read(
                                                        );
                                                  if (current !=
                                                        'a') {
                                                      reportCharacterExpectedError(
                                                        'a',
                                                        current);
                                                      break loop;
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
                                                      break loop;
                                                  }
                                                  current =
                                                    reader.
                                                      read(
                                                        );
                                                  if (current !=
                                                        'n') {
                                                      reportCharacterExpectedError(
                                                        'n',
                                                        current);
                                                      break loop;
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
                                                      break loop;
                                                  }
                                                  current =
                                                    reader.
                                                      read(
                                                        );
                                                  if (current !=
                                                        'f') {
                                                      reportCharacterExpectedError(
                                                        'f',
                                                        current);
                                                      break loop;
                                                  }
                                                  current =
                                                    reader.
                                                      read(
                                                        );
                                                  if (current !=
                                                        'y') {
                                                      reportCharacterExpectedError(
                                                        'y',
                                                        current);
                                                      break loop;
                                                  }
                                                  current =
                                                    reader.
                                                      read(
                                                        );
                                                  fragmentIdentifierHandler.
                                                    zoomAndPan(
                                                      true);
                                                  break;
                                              case 'd':
                                                  current =
                                                    reader.
                                                      read(
                                                        );
                                                  if (current !=
                                                        'i') {
                                                      reportCharacterExpectedError(
                                                        'i',
                                                        current);
                                                      break loop;
                                                  }
                                                  current =
                                                    reader.
                                                      read(
                                                        );
                                                  if (current !=
                                                        's') {
                                                      reportCharacterExpectedError(
                                                        's',
                                                        current);
                                                      break loop;
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
                                                      break loop;
                                                  }
                                                  current =
                                                    reader.
                                                      read(
                                                        );
                                                  if (current !=
                                                        'b') {
                                                      reportCharacterExpectedError(
                                                        'b',
                                                        current);
                                                      break loop;
                                                  }
                                                  current =
                                                    reader.
                                                      read(
                                                        );
                                                  if (current !=
                                                        'l') {
                                                      reportCharacterExpectedError(
                                                        'l',
                                                        current);
                                                      break loop;
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
                                                      break loop;
                                                  }
                                                  current =
                                                    reader.
                                                      read(
                                                        );
                                                  fragmentIdentifierHandler.
                                                    zoomAndPan(
                                                      false);
                                                  break;
                                              default:
                                                  reportUnexpectedCharacterError(
                                                    current);
                                                  break loop;
                                          }
                                          if (current !=
                                                ')') {
                                              reportCharacterExpectedError(
                                                ')',
                                                current);
                                              break loop;
                                          }
                                          current =
                                            reader.
                                              read(
                                                );
                                  }
                              } }
    protected void parseIdentifier() throws org.apache.batik.parser.ParseException,
        java.io.IOException { for (; ; ) {
                                  if (current ==
                                        -1 ||
                                        !org.apache.batik.xml.XMLUtilities.
                                        isXMLNameCharacter(
                                          (char)
                                            current)) {
                                      break;
                                  }
                                  bufferize(
                                    );
                                  current =
                                    reader.
                                      read(
                                        );
                              } }
    protected java.lang.String getBufferContent() {
        return new java.lang.String(
          buffer,
          0,
          bufferSize);
    }
    protected void bufferize() { if (bufferSize >=
                                       buffer.
                                         length) {
                                     char[] t =
                                       new char[buffer.
                                                  length *
                                                  2];
                                     java.lang.System.
                                       arraycopy(
                                         buffer,
                                         0,
                                         t,
                                         0,
                                         bufferSize);
                                     buffer =
                                       t;
                                 }
                                 buffer[bufferSize++] =
                                   (char)
                                     current;
    }
    protected void skipSpaces() throws java.io.IOException {
        if (current ==
              ',') {
            current =
              reader.
                read(
                  );
        }
    }
    protected void skipCommaSpaces() throws java.io.IOException {
        if (current ==
              ',') {
            current =
              reader.
                read(
                  );
        }
    }
    protected void parseMatrix() throws org.apache.batik.parser.ParseException,
        java.io.IOException { current = reader.
                                          read(
                                            );
                              if (current !=
                                    'a') {
                                  reportCharacterExpectedError(
                                    'a',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              current = reader.
                                          read(
                                            );
                              if (current !=
                                    't') {
                                  reportCharacterExpectedError(
                                    't',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              current = reader.
                                          read(
                                            );
                              if (current !=
                                    'r') {
                                  reportCharacterExpectedError(
                                    'r',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              current = reader.
                                          read(
                                            );
                              if (current !=
                                    'i') {
                                  reportCharacterExpectedError(
                                    'i',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              current = reader.
                                          read(
                                            );
                              if (current !=
                                    'x') {
                                  reportCharacterExpectedError(
                                    'x',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              current = reader.
                                          read(
                                            );
                              skipSpaces(
                                );
                              if (current !=
                                    '(') {
                                  reportCharacterExpectedError(
                                    '(',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              current = reader.
                                          read(
                                            );
                              skipSpaces(
                                );
                              float a = parseFloat(
                                          );
                              skipCommaSpaces(
                                );
                              float b = parseFloat(
                                          );
                              skipCommaSpaces(
                                );
                              float c = parseFloat(
                                          );
                              skipCommaSpaces(
                                );
                              float d = parseFloat(
                                          );
                              skipCommaSpaces(
                                );
                              float e = parseFloat(
                                          );
                              skipCommaSpaces(
                                );
                              float f = parseFloat(
                                          );
                              skipSpaces(
                                );
                              if (current !=
                                    ')') {
                                  reportCharacterExpectedError(
                                    ')',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              fragmentIdentifierHandler.
                                matrix(
                                  a,
                                  b,
                                  c,
                                  d,
                                  e,
                                  f); }
    protected void parseRotate() throws org.apache.batik.parser.ParseException,
        java.io.IOException { current = reader.
                                          read(
                                            );
                              if (current !=
                                    'o') {
                                  reportCharacterExpectedError(
                                    'o',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              current = reader.
                                          read(
                                            );
                              if (current !=
                                    't') {
                                  reportCharacterExpectedError(
                                    't',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              current = reader.
                                          read(
                                            );
                              if (current !=
                                    'a') {
                                  reportCharacterExpectedError(
                                    'a',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              current = reader.
                                          read(
                                            );
                              if (current !=
                                    't') {
                                  reportCharacterExpectedError(
                                    't',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              current = reader.
                                          read(
                                            );
                              if (current !=
                                    'e') {
                                  reportCharacterExpectedError(
                                    'e',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              current = reader.
                                          read(
                                            );
                              skipSpaces(
                                );
                              if (current !=
                                    '(') {
                                  reportCharacterExpectedError(
                                    '(',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              current = reader.
                                          read(
                                            );
                              skipSpaces(
                                );
                              float theta =
                                parseFloat(
                                  );
                              skipSpaces(
                                );
                              switch (current) {
                                  case ')':
                                      fragmentIdentifierHandler.
                                        rotate(
                                          theta);
                                      return;
                                  case ',':
                                      current =
                                        reader.
                                          read(
                                            );
                                      skipSpaces(
                                        );
                              }
                              float cx = parseFloat(
                                           );
                              skipCommaSpaces(
                                );
                              float cy = parseFloat(
                                           );
                              skipSpaces(
                                );
                              if (current !=
                                    ')') {
                                  reportCharacterExpectedError(
                                    ')',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              fragmentIdentifierHandler.
                                rotate(
                                  theta,
                                  cx,
                                  cy); }
    protected void parseTranslate() throws org.apache.batik.parser.ParseException,
        java.io.IOException { current = reader.
                                          read(
                                            );
                              if (current !=
                                    'r') {
                                  reportCharacterExpectedError(
                                    'r',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              current = reader.
                                          read(
                                            );
                              if (current !=
                                    'a') {
                                  reportCharacterExpectedError(
                                    'a',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              current = reader.
                                          read(
                                            );
                              if (current !=
                                    'n') {
                                  reportCharacterExpectedError(
                                    'n',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              current = reader.
                                          read(
                                            );
                              if (current !=
                                    's') {
                                  reportCharacterExpectedError(
                                    's',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              current = reader.
                                          read(
                                            );
                              if (current !=
                                    'l') {
                                  reportCharacterExpectedError(
                                    'l',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              current = reader.
                                          read(
                                            );
                              if (current !=
                                    'a') {
                                  reportCharacterExpectedError(
                                    'a',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              current = reader.
                                          read(
                                            );
                              if (current !=
                                    't') {
                                  reportCharacterExpectedError(
                                    't',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              current = reader.
                                          read(
                                            );
                              if (current !=
                                    'e') {
                                  reportCharacterExpectedError(
                                    'e',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              current = reader.
                                          read(
                                            );
                              skipSpaces(
                                );
                              if (current !=
                                    '(') {
                                  reportCharacterExpectedError(
                                    '(',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              current = reader.
                                          read(
                                            );
                              skipSpaces(
                                );
                              float tx = parseFloat(
                                           );
                              skipSpaces(
                                );
                              switch (current) {
                                  case ')':
                                      fragmentIdentifierHandler.
                                        translate(
                                          tx);
                                      return;
                                  case ',':
                                      current =
                                        reader.
                                          read(
                                            );
                                      skipSpaces(
                                        );
                              }
                              float ty = parseFloat(
                                           );
                              skipSpaces(
                                );
                              if (current !=
                                    ')') {
                                  reportCharacterExpectedError(
                                    ')',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              fragmentIdentifierHandler.
                                translate(
                                  tx,
                                  ty); }
    protected void parseScale() throws org.apache.batik.parser.ParseException,
        java.io.IOException { current = reader.
                                          read(
                                            );
                              if (current !=
                                    'a') {
                                  reportCharacterExpectedError(
                                    'a',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              current = reader.
                                          read(
                                            );
                              if (current !=
                                    'l') {
                                  reportCharacterExpectedError(
                                    'l',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              current = reader.
                                          read(
                                            );
                              if (current !=
                                    'e') {
                                  reportCharacterExpectedError(
                                    'e',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              current = reader.
                                          read(
                                            );
                              skipSpaces(
                                );
                              if (current !=
                                    '(') {
                                  reportCharacterExpectedError(
                                    '(',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              current = reader.
                                          read(
                                            );
                              skipSpaces(
                                );
                              float sx = parseFloat(
                                           );
                              skipSpaces(
                                );
                              switch (current) {
                                  case ')':
                                      fragmentIdentifierHandler.
                                        scale(
                                          sx);
                                      return;
                                  case ',':
                                      current =
                                        reader.
                                          read(
                                            );
                                      skipSpaces(
                                        );
                              }
                              float sy = parseFloat(
                                           );
                              skipSpaces(
                                );
                              if (current !=
                                    ')') {
                                  reportCharacterExpectedError(
                                    ')',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              fragmentIdentifierHandler.
                                scale(
                                  sx,
                                  sy); }
    protected void parseSkew() throws org.apache.batik.parser.ParseException,
        java.io.IOException { current = reader.
                                          read(
                                            );
                              if (current !=
                                    'e') {
                                  reportCharacterExpectedError(
                                    'e',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              current = reader.
                                          read(
                                            );
                              if (current !=
                                    'w') {
                                  reportCharacterExpectedError(
                                    'w',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              current = reader.
                                          read(
                                            );
                              boolean skewX =
                                false;
                              switch (current) {
                                  case 'X':
                                      skewX =
                                        true;
                                  case 'Y':
                                      break;
                                  default:
                                      reportCharacterExpectedError(
                                        'X',
                                        current);
                                      skipTransform(
                                        );
                                      return;
                              }
                              current = reader.
                                          read(
                                            );
                              skipSpaces(
                                );
                              if (current !=
                                    '(') {
                                  reportCharacterExpectedError(
                                    '(',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              current = reader.
                                          read(
                                            );
                              skipSpaces(
                                );
                              float sk = parseFloat(
                                           );
                              skipSpaces(
                                );
                              if (current !=
                                    ')') {
                                  reportCharacterExpectedError(
                                    ')',
                                    current);
                                  skipTransform(
                                    );
                                  return;
                              }
                              if (skewX) {
                                  fragmentIdentifierHandler.
                                    skewX(
                                      sk);
                              }
                              else {
                                  fragmentIdentifierHandler.
                                    skewY(
                                      sk);
                              } }
    protected void skipTransform() throws java.io.IOException {
        loop: for (;
                   ;
                   ) {
            current =
              reader.
                read(
                  );
            switch (current) {
                case ')':
                    break loop;
                default:
                    if (current ==
                          -1) {
                        break loop;
                    }
            }
        }
    }
    protected void parsePreserveAspectRatio()
          throws org.apache.batik.parser.ParseException,
        java.io.IOException { fragmentIdentifierHandler.
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
                                            'n',
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
                                      fragmentIdentifierHandler.
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
                                                      fragmentIdentifierHandler.
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
                                                              fragmentIdentifierHandler.
                                                                xMaxYMid(
                                                                  );
                                                              current =
                                                                reader.
                                                                  read(
                                                                    );
                                                              break;
                                                          case 'n':
                                                              fragmentIdentifierHandler.
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
                                                              fragmentIdentifierHandler.
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
                                                                      fragmentIdentifierHandler.
                                                                        xMidYMid(
                                                                          );
                                                                      current =
                                                                        reader.
                                                                          read(
                                                                            );
                                                                      break;
                                                                  case 'n':
                                                                      fragmentIdentifierHandler.
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
                                                              fragmentIdentifierHandler.
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
                                                                      fragmentIdentifierHandler.
                                                                        xMinYMid(
                                                                          );
                                                                      current =
                                                                        reader.
                                                                          read(
                                                                            );
                                                                      break;
                                                                  case 'n':
                                                                      fragmentIdentifierHandler.
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
                                      fragmentIdentifierHandler.
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
                                      fragmentIdentifierHandler.
                                        slice(
                                          );
                                      current =
                                        reader.
                                          read(
                                            );
                              }
                              fragmentIdentifierHandler.
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
                case -1:
                    break loop;
            }
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "wCluZYZoYw6XL0DGT2FVHrU7C/vI25f/8tA9948Lv7/Yn808cjO/6FYHd/32" +
       "n2mQcx7LEJN45PtDRx+a3X7lGS7vEApKt8TTvRSQsiN7yZHo34NNxS8FSUk/" +
       "qZXtKLlPUmO4TPshMrQSoTNE0inlqVGeCGnakoQ510tmrm69VOZ4R3jG2vhc" +
       "5WGvapzCpXAttBf2Qi97BQh/6OQiX+PpEkwuSpBFmWHqDEZJIx6+qMrSLHDM" +
       "YGwIiDh1b4eOqzc2aDG+TEXgt7ni5Z9Zj/zhaWEATRkqe6LJw4dK5Q+jL/9O" +
       "CMzKICDqTTsc+m7fe9ve4NRbiv54YwIll7cFv+3i/dqkinNQo3lwPW6r+LiI" +
       "yob/x3AJxKKhMTQF3HIpUYkh8fVARLgaHrmNJCKzr6or5KGF/gvPNVcHvt/8" +
       "5k0Hmn/DWalUscA8Ab8MuwaXzNmjp8+crGp4knvuQpwGewpSt1vpu6mUTRKf" +
       "nRpMNsatzGbSYypR8KFjtplc0rNV3t3Sw80E5TaIqf0SfgG4/oMXTilmiKmt" +
       "b7ej/vnJsB/JLCsreToN7aw/PfrQJ08I2/RSkKcy3b33zi9b9+wVrlLsHZvT" +
       "tm9uGbF/FJaKyWYc3YJsvXCJNX88tvMnh3feLkZVn7oT6oCN/hPv/vuN1v2/" +
       "fi1D2F0oj9jxKDqFQDJUnpo6A0Kj1XfU/PTu+oI1MNedpDSmKdfHaGcklatK" +
       "rNigayE6m1KHv2zdcGYYCSxJeBT3APB/uzAHm8FGMzNYEB9bGXCnokkqb34z" +
       "sJNKtWE2witvsZHE2yAjBWCI+Hitq9egaIr/n8nseAMZHLbHukZxWSXKxG5D" +
       "0VuTryagMH38JmlI8Ypd3NYdF/NR9b0f/6hleFUu2wzMa5xgI4H/54ERLPE3" +
       "ae9QXtn159kbrxzZmsOOYZ7HJL1NPtZ19LWrF8n3BvnbD+H70t6apAq1pVpR" +
       "uUlZzNRS7aZZGASfPWENmCzl85sl1rs5S9kuTHaC+cg40cIuslS/LT18woyV" +
       "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" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "PQpL94au90NgvaNZp7p6sMirV59I6IGr");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("c0hGe383+ATo9beC35dcb0f+4KTCx4oK//Qm++yfz5NfCUuPB1p4w13h6+5L" +
       "bl1dPRHCr77VluTpgfcYUbw5xcDFHjKCvTOMOI3zX9+k7N/myZcAD1Y34UHB" +
       "zhO8/+I28BavAR4H1/gQ7/jt4iXeEu9v7pXtvfp6/kZvBorzS51E0bzjN1PH" +
       "b8p09wo1OC4rhvlKnvxGWLpbdYuW+d8vnnDp398ul94HAJ/Ztd3d7yyXfu/6" +
       "XMr/fjVPvlbU+v08+TrgQsGjKZj/wOrU1xdRuHtdeArwN24X8GUw/A92bXf3" +
       "Owv4j24J8B/nyR+EpYsF4BNT2AP7zdsA+3BpZ/hn79213d3vLNj/cZOy7+bJ" +
       "n4alS8Dm8eL9XnHYd/fO+JUTjH92uwJ9EmA7nHR29zuL8S9uUvaXefLnYDba" +
       "vcA8fH95SoDfv11wTwFQTxyCe+KOgzs4f+OZrVDUg3vy5CAsXQhM3Rt7R2dP" +
       "TiAenLkDBnn2+UOIz995iA+9FcR35cn9wBZziIRr2/J1cT5wuzifBvgOX0uf" +
       "vea19O3jfPJWHM/B03nynrD0jsLx9GXgZZM9oI/dCaDBIdDgzgN94ZaAfiBP" +
       "njsCOsoPguwZ58Hztwv0WQDwy4dAv3zngTZuCWgzT5Cw9EABVPBlJ7CuxVq5" +
       "A47o3MO7trv7ncWK3xLWdp58EHijAutYka19nB+6A7PJucEhzsGdx8ndEs5h" +
       "nlD5+cUCp6nFezDp24X5DID3s4cwf/bOw5Teyun+eJ5MwtL9udMtlDY/b76H" +
       "cnq7KH8IoPuFQ5S/cOdRLm9JmPkRlgM5LD1aCHPoa2AVsNWwwNOUcJQfT9tD" +
       "vbgDbumu13Ztd/c7i9p/K9nmEd6BDTxSLtsbxbYHztuBmQD23ehTkPxc+6PX" +
       "fH62+2RK+cLrF+955PXJf9odrT36rOletnTPMrKs08eQT+XPe7623M2L9+4O" +
       "JXsFsI+GpUdusKzLPxUoMjnpB9mu/sdA9LtfPyzdVdxP1/sE8Ggn9UBXu8zp" +
       "Kj8Vls6CKnn2p3en+sCi8fKN1pi781Q79iS7M6CPnlaYIjZ96K0EcGp/5tmr" +
       "zmAWnwQenZeMdh8FvqR88XWa++j3Gr+8+4BDseQsy3u5hy3dvfuWpOg0P3P5" +
       "3hv2dtTXefL9P3jg1+997mjH54EdwSfKe4q2p67/tUTH9sLi+4bsXz3yz3/k" +
       "V1//ZnGs7P8BiPj2/as5AAA=");
}
