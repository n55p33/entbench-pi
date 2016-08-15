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
       "bFy6N/aDH3DUteqc6urBIq9cfSKhB67u");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("IRn4/m7wCdDrbwW/L7vejvzBSYWPFxX+2U322T+fJ78Wlx6P1PiGu8LX3Zdc" +
       "+6ZyIoRff6stydMD7zGieHOKgos6ZAR1ZxhxGue/uUnZv8uTLwEe6DfhQcHO" +
       "E7z/8jbwFq8BHgcXd4iXe7t4sbfE+9t7ZXuvvp6/0ZuB4vxSN5PV4PjN1PGb" +
       "MtO/0h8flxXDfCVPfisu3a34Rcv87xdPuPQfbpdL7wOAz+za7u53lkt/cH0u" +
       "5X+/midfK2r9YZ58HXCh4JEA5j80jkNzmcS714WnAH/jdgFfBsO/uWu7u99Z" +
       "wH9yS4D/NE/+KC5dLACfmMIe2G/eBtiHSzvDP3vvru3ufmfB/s+blH03T/48" +
       "Ll0CNt8p3u8Vh31374xfPsH4F7cr0CcBtsNJZ3e/sxj/6iZlf50nfwlmo90L" +
       "zMP3l6cE+P3bBfcUAPXEIbgn7ji4g/M3ntkKRT24J08O4tKFyDYDLjg6e3IC" +
       "8eDMHTDIs88fQnz+zkN86K0gvitP7ge2mEPEfNeVrovzgdvF+TTAd/ha+uw1" +
       "r6VvH+eTt+J4Dp7Ok/fEpXcUjoeWgJfN9oA+dieARodAozsP9IVbAvqBPHnu" +
       "CCibHwTZM86D528X6LMA4JcPgX75zgNt3RJQJE+qcemBAigfSl7kXIu1dgcc" +
       "0bmHd2139zuLtXNLWPE8+SDwRgVWTpacfZwfugOzybnxIc7xncc5uiWcTJ70" +
       "8/OLBU5bTfdgDm4X5jMA3s8cwvyZOw9TfCun+6N5Mo1L9+dOt1Da/Lz5Hkrh" +
       "dlH+AED3S4cof+nOo9RuSZj51yAHUlx6tBAmE6pgFbBW0ShQ5ZjNj6ftoV7e" +
       "Abd016u7trv7nUUdvpVs8wjvwAUeKZftjWLbA+/twMwA+270KUh+rv3Raz4/" +
       "230yJX/htYv3PPLa9D/vjtYefdZ0L1W6R0sc5/Qx5FP580Goart58d7doeSg" +
       "APbRuPTIDZZ1+acCRSYn/WC7q/9xEP3u149LdxX30/U+ATzaST3Q1S5zuspP" +
       "xqWzoEqe/andqT6waLx8ozXm7jzVjj3Z7gzoo6cVpohNH3orAZzan3n2qjOY" +
       "xSeBR+clk91HgS/JX3xtMPro91q/uvuAQ3ak7Tbv5R6qdPfuW5Ki0/zM5Xtv" +
       "2NtRX+fJ97/5wG/e+9zRjs8DO4JPlPcUbU9d/2uJrhvExfcN23/9yL/4oV9/" +
       "7ZvFsbL/B6ajHiOrOQAA");
}
