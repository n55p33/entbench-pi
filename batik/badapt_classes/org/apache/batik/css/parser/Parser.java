package org.apache.batik.css.parser;
public class Parser implements org.apache.batik.css.parser.ExtendedParser, org.apache.batik.i18n.Localizable {
    public static final java.lang.String BUNDLE_CLASSNAME = "org.apache.batik.css.parser.resources.Messages";
    protected org.apache.batik.i18n.LocalizableSupport localizableSupport =
      new org.apache.batik.i18n.LocalizableSupport(
      BUNDLE_CLASSNAME,
      org.apache.batik.css.parser.Parser.class.
        getClassLoader(
          ));
    protected org.apache.batik.css.parser.Scanner scanner;
    protected int current;
    protected org.w3c.css.sac.DocumentHandler documentHandler = org.apache.batik.css.parser.DefaultDocumentHandler.
                                                                  INSTANCE;
    protected org.w3c.css.sac.SelectorFactory selectorFactory = org.apache.batik.css.parser.DefaultSelectorFactory.
                                                                  INSTANCE;
    protected org.w3c.css.sac.ConditionFactory conditionFactory =
      org.apache.batik.css.parser.DefaultConditionFactory.
        INSTANCE;
    protected org.w3c.css.sac.ErrorHandler errorHandler =
      org.apache.batik.css.parser.DefaultErrorHandler.
        INSTANCE;
    protected java.lang.String pseudoElement;
    protected java.lang.String documentURI;
    public java.lang.String getParserVersion() { return "http://www.w3.org/TR/REC-CSS2";
    }
    public void setLocale(java.util.Locale locale)
          throws org.w3c.css.sac.CSSException { localizableSupport.
                                                  setLocale(
                                                    locale);
    }
    public java.util.Locale getLocale() { return localizableSupport.
                                            getLocale(
                                              ); }
    public java.lang.String formatMessage(java.lang.String key,
                                          java.lang.Object[] args)
          throws java.util.MissingResourceException {
        return localizableSupport.
          formatMessage(
            key,
            args);
    }
    public void setDocumentHandler(org.w3c.css.sac.DocumentHandler handler) {
        documentHandler =
          handler;
    }
    public void setSelectorFactory(org.w3c.css.sac.SelectorFactory factory) {
        selectorFactory =
          factory;
    }
    public void setConditionFactory(org.w3c.css.sac.ConditionFactory factory) {
        conditionFactory =
          factory;
    }
    public void setErrorHandler(org.w3c.css.sac.ErrorHandler handler) {
        errorHandler =
          handler;
    }
    public void parseStyleSheet(org.w3c.css.sac.InputSource source)
          throws org.w3c.css.sac.CSSException,
        java.io.IOException { scanner = createScanner(
                                          source);
                              try { documentHandler.
                                      startDocument(
                                        source);
                                    current = scanner.
                                                next(
                                                  );
                                    switch (current) {
                                        case org.apache.batik.css.parser.LexicalUnits.
                                               CHARSET_SYMBOL:
                                            if (nextIgnoreSpaces(
                                                  ) !=
                                                  org.apache.batik.css.parser.LexicalUnits.
                                                    STRING) {
                                                reportError(
                                                  "charset.string");
                                            }
                                            else {
                                                if (nextIgnoreSpaces(
                                                      ) !=
                                                      org.apache.batik.css.parser.LexicalUnits.
                                                        SEMI_COLON) {
                                                    reportError(
                                                      "semicolon");
                                                }
                                                next(
                                                  );
                                            }
                                            break;
                                        case org.apache.batik.css.parser.LexicalUnits.
                                               COMMENT:
                                            documentHandler.
                                              comment(
                                                scanner.
                                                  getStringValue(
                                                    ));
                                    }
                                    skipSpacesAndCDOCDC(
                                      );
                                    for (;
                                         ;
                                         ) {
                                        if (current ==
                                              org.apache.batik.css.parser.LexicalUnits.
                                                IMPORT_SYMBOL) {
                                            nextIgnoreSpaces(
                                              );
                                            parseImportRule(
                                              );
                                            nextIgnoreSpaces(
                                              );
                                        }
                                        else {
                                            break;
                                        }
                                    }
                                    loop: for (;
                                               ;
                                               ) {
                                        switch (current) {
                                            case org.apache.batik.css.parser.LexicalUnits.
                                                   PAGE_SYMBOL:
                                                nextIgnoreSpaces(
                                                  );
                                                parsePageRule(
                                                  );
                                                break;
                                            case org.apache.batik.css.parser.LexicalUnits.
                                                   MEDIA_SYMBOL:
                                                nextIgnoreSpaces(
                                                  );
                                                parseMediaRule(
                                                  );
                                                break;
                                            case org.apache.batik.css.parser.LexicalUnits.
                                                   FONT_FACE_SYMBOL:
                                                nextIgnoreSpaces(
                                                  );
                                                parseFontFaceRule(
                                                  );
                                                break;
                                            case org.apache.batik.css.parser.LexicalUnits.
                                                   AT_KEYWORD:
                                                nextIgnoreSpaces(
                                                  );
                                                parseAtRule(
                                                  );
                                                break;
                                            case org.apache.batik.css.parser.LexicalUnits.
                                                   EOF:
                                                break loop;
                                            default:
                                                parseRuleSet(
                                                  );
                                        }
                                        skipSpacesAndCDOCDC(
                                          );
                                    } }
                              finally { documentHandler.
                                          endDocument(
                                            source);
                                        scanner =
                                          null;
                              } }
    public void parseStyleSheet(java.lang.String uri)
          throws org.w3c.css.sac.CSSException,
        java.io.IOException { parseStyleSheet(
                                new org.w3c.css.sac.InputSource(
                                  uri)); }
    public void parseStyleDeclaration(org.w3c.css.sac.InputSource source)
          throws org.w3c.css.sac.CSSException,
        java.io.IOException { scanner = createScanner(
                                          source);
                              parseStyleDeclarationInternal(
                                ); }
    protected void parseStyleDeclarationInternal()
          throws org.w3c.css.sac.CSSException,
        java.io.IOException { nextIgnoreSpaces(
                                );
                              try { parseStyleDeclaration(
                                      false);
                              }
                              catch (org.w3c.css.sac.CSSParseException e) {
                                  reportError(
                                    e);
                              }
                              finally {
                                  scanner =
                                    null;
                              } }
    public void parseRule(org.w3c.css.sac.InputSource source)
          throws org.w3c.css.sac.CSSException,
        java.io.IOException { scanner = createScanner(
                                          source);
                              parseRuleInternal(
                                ); }
    protected void parseRuleInternal() throws org.w3c.css.sac.CSSException,
        java.io.IOException { nextIgnoreSpaces(
                                );
                              parseRule();
                              scanner = null;
    }
    public org.w3c.css.sac.SelectorList parseSelectors(org.w3c.css.sac.InputSource source)
          throws org.w3c.css.sac.CSSException,
        java.io.IOException { scanner = createScanner(
                                          source);
                              return parseSelectorsInternal(
                                       );
    }
    protected org.w3c.css.sac.SelectorList parseSelectorsInternal()
          throws org.w3c.css.sac.CSSException,
        java.io.IOException { nextIgnoreSpaces(
                                );
                              org.w3c.css.sac.SelectorList ret =
                                parseSelectorList(
                                  );
                              scanner = null;
                              return ret;
    }
    public org.w3c.css.sac.LexicalUnit parsePropertyValue(org.w3c.css.sac.InputSource source)
          throws org.w3c.css.sac.CSSException,
        java.io.IOException { scanner = createScanner(
                                          source);
                              return parsePropertyValueInternal(
                                       );
    }
    protected org.w3c.css.sac.LexicalUnit parsePropertyValueInternal()
          throws org.w3c.css.sac.CSSException,
        java.io.IOException { nextIgnoreSpaces(
                                );
                              org.w3c.css.sac.LexicalUnit exp =
                                null;
                              try { exp =
                                      parseExpression(
                                        false);
                              }
                              catch (org.w3c.css.sac.CSSParseException e) {
                                  reportError(
                                    e);
                                  throw e;
                              }
                              org.w3c.css.sac.CSSParseException exception =
                                null;
                              if (current !=
                                    org.apache.batik.css.parser.LexicalUnits.
                                      EOF)
                                  exception =
                                    createCSSParseException(
                                      "eof.expected");
                              scanner = null;
                              if (exception !=
                                    null) {
                                  errorHandler.
                                    fatalError(
                                      exception);
                              }
                              return exp;
    }
    public boolean parsePriority(org.w3c.css.sac.InputSource source)
          throws org.w3c.css.sac.CSSException,
        java.io.IOException { scanner = createScanner(
                                          source);
                              return parsePriorityInternal(
                                       );
    }
    protected boolean parsePriorityInternal()
          throws org.w3c.css.sac.CSSException,
        java.io.IOException { nextIgnoreSpaces(
                                );
                              scanner = null;
                              switch (current) {
                                  case org.apache.batik.css.parser.LexicalUnits.
                                         EOF:
                                      return false;
                                  case org.apache.batik.css.parser.LexicalUnits.
                                         IMPORT_SYMBOL:
                                      return true;
                                  default:
                                      reportError(
                                        "token",
                                        new java.lang.Object[] { new java.lang.Integer(
                                          current) });
                                      return false;
                              } }
    protected void parseRule() { switch (scanner.
                                           getType(
                                             )) {
                                     case org.apache.batik.css.parser.LexicalUnits.
                                            IMPORT_SYMBOL:
                                         nextIgnoreSpaces(
                                           );
                                         parseImportRule(
                                           );
                                         break;
                                     case org.apache.batik.css.parser.LexicalUnits.
                                            AT_KEYWORD:
                                         nextIgnoreSpaces(
                                           );
                                         parseAtRule(
                                           );
                                         break;
                                     case org.apache.batik.css.parser.LexicalUnits.
                                            FONT_FACE_SYMBOL:
                                         nextIgnoreSpaces(
                                           );
                                         parseFontFaceRule(
                                           );
                                         break;
                                     case org.apache.batik.css.parser.LexicalUnits.
                                            MEDIA_SYMBOL:
                                         nextIgnoreSpaces(
                                           );
                                         parseMediaRule(
                                           );
                                         break;
                                     case org.apache.batik.css.parser.LexicalUnits.
                                            PAGE_SYMBOL:
                                         nextIgnoreSpaces(
                                           );
                                         parsePageRule(
                                           );
                                         break;
                                     default:
                                         parseRuleSet(
                                           );
                                 } }
    protected void parseAtRule() { scanner.
                                     scanAtRule(
                                       );
                                   documentHandler.
                                     ignorableAtRule(
                                       scanner.
                                         getStringValue(
                                           ));
                                   nextIgnoreSpaces(
                                     ); }
    protected void parseImportRule() { java.lang.String uri =
                                         null;
                                       switch (current) {
                                           default:
                                               reportError(
                                                 "string.or.uri");
                                               return;
                                           case org.apache.batik.css.parser.LexicalUnits.
                                                  STRING:
                                           case org.apache.batik.css.parser.LexicalUnits.
                                                  URI:
                                               uri =
                                                 scanner.
                                                   getStringValue(
                                                     );
                                               nextIgnoreSpaces(
                                                 );
                                       }
                                       org.apache.batik.css.parser.CSSSACMediaList ml;
                                       if (current !=
                                             org.apache.batik.css.parser.LexicalUnits.
                                               IDENTIFIER) {
                                           ml =
                                             new org.apache.batik.css.parser.CSSSACMediaList(
                                               );
                                           ml.
                                             append(
                                               "all");
                                       }
                                       else {
                                           ml =
                                             parseMediaList(
                                               );
                                       }
                                       documentHandler.
                                         importStyle(
                                           uri,
                                           ml,
                                           null);
                                       if (current !=
                                             org.apache.batik.css.parser.LexicalUnits.
                                               SEMI_COLON) {
                                           reportError(
                                             "semicolon");
                                       }
                                       else {
                                           next(
                                             );
                                       } }
    protected org.apache.batik.css.parser.CSSSACMediaList parseMediaList() {
        org.apache.batik.css.parser.CSSSACMediaList result =
          new org.apache.batik.css.parser.CSSSACMediaList(
          );
        result.
          append(
            scanner.
              getStringValue(
                ));
        nextIgnoreSpaces(
          );
        while (current ==
                 org.apache.batik.css.parser.LexicalUnits.
                   COMMA) {
            nextIgnoreSpaces(
              );
            switch (current) {
                default:
                    reportError(
                      "identifier");
                    break;
                case org.apache.batik.css.parser.LexicalUnits.
                       IDENTIFIER:
                    result.
                      append(
                        scanner.
                          getStringValue(
                            ));
                    nextIgnoreSpaces(
                      );
            }
        }
        return result;
    }
    protected void parseFontFaceRule() { try {
                                             documentHandler.
                                               startFontFace(
                                                 );
                                             if (current !=
                                                   org.apache.batik.css.parser.LexicalUnits.
                                                     LEFT_CURLY_BRACE) {
                                                 reportError(
                                                   "left.curly.brace");
                                             }
                                             else {
                                                 nextIgnoreSpaces(
                                                   );
                                                 try {
                                                     parseStyleDeclaration(
                                                       true);
                                                 }
                                                 catch (org.w3c.css.sac.CSSParseException e) {
                                                     reportError(
                                                       e);
                                                 }
                                             }
                                         }
                                         finally {
                                             documentHandler.
                                               endFontFace(
                                                 );
                                         }
    }
    protected void parsePageRule() { java.lang.String page =
                                       null;
                                     java.lang.String ppage =
                                       null;
                                     if (current ==
                                           org.apache.batik.css.parser.LexicalUnits.
                                             IDENTIFIER) {
                                         page =
                                           scanner.
                                             getStringValue(
                                               );
                                         nextIgnoreSpaces(
                                           );
                                         if (current ==
                                               org.apache.batik.css.parser.LexicalUnits.
                                                 COLON) {
                                             nextIgnoreSpaces(
                                               );
                                             if (current !=
                                                   org.apache.batik.css.parser.LexicalUnits.
                                                     IDENTIFIER) {
                                                 reportError(
                                                   "identifier");
                                                 return;
                                             }
                                             ppage =
                                               scanner.
                                                 getStringValue(
                                                   );
                                             nextIgnoreSpaces(
                                               );
                                         }
                                     }
                                     try {
                                         documentHandler.
                                           startPage(
                                             page,
                                             ppage);
                                         if (current !=
                                               org.apache.batik.css.parser.LexicalUnits.
                                                 LEFT_CURLY_BRACE) {
                                             reportError(
                                               "left.curly.brace");
                                         }
                                         else {
                                             nextIgnoreSpaces(
                                               );
                                             try {
                                                 parseStyleDeclaration(
                                                   true);
                                             }
                                             catch (org.w3c.css.sac.CSSParseException e) {
                                                 reportError(
                                                   e);
                                             }
                                         }
                                     }
                                     finally {
                                         documentHandler.
                                           endPage(
                                             page,
                                             ppage);
                                     } }
    protected void parseMediaRule() { if (current !=
                                            org.apache.batik.css.parser.LexicalUnits.
                                              IDENTIFIER) {
                                          reportError(
                                            "identifier");
                                          return;
                                      }
                                      org.apache.batik.css.parser.CSSSACMediaList ml =
                                        parseMediaList(
                                          );
                                      try {
                                          documentHandler.
                                            startMedia(
                                              ml);
                                          if (current !=
                                                org.apache.batik.css.parser.LexicalUnits.
                                                  LEFT_CURLY_BRACE) {
                                              reportError(
                                                "left.curly.brace");
                                          }
                                          else {
                                              nextIgnoreSpaces(
                                                );
                                              loop: for (;
                                                         ;
                                                         ) {
                                                  switch (current) {
                                                      case org.apache.batik.css.parser.LexicalUnits.
                                                             EOF:
                                                      case org.apache.batik.css.parser.LexicalUnits.
                                                             RIGHT_CURLY_BRACE:
                                                          break loop;
                                                      default:
                                                          parseRuleSet(
                                                            );
                                                  }
                                              }
                                              nextIgnoreSpaces(
                                                );
                                          }
                                      }
                                      finally {
                                          documentHandler.
                                            endMedia(
                                              ml);
                                      } }
    protected void parseRuleSet() { org.w3c.css.sac.SelectorList sl =
                                      null;
                                    try {
                                        sl =
                                          parseSelectorList(
                                            );
                                    }
                                    catch (org.w3c.css.sac.CSSParseException e) {
                                        reportError(
                                          e);
                                        return;
                                    }
                                    try {
                                        documentHandler.
                                          startSelector(
                                            sl);
                                        if (current !=
                                              org.apache.batik.css.parser.LexicalUnits.
                                                LEFT_CURLY_BRACE) {
                                            reportError(
                                              "left.curly.brace");
                                            if (current ==
                                                  org.apache.batik.css.parser.LexicalUnits.
                                                    RIGHT_CURLY_BRACE) {
                                                nextIgnoreSpaces(
                                                  );
                                            }
                                        }
                                        else {
                                            nextIgnoreSpaces(
                                              );
                                            try {
                                                parseStyleDeclaration(
                                                  true);
                                            }
                                            catch (org.w3c.css.sac.CSSParseException e) {
                                                reportError(
                                                  e);
                                            }
                                        }
                                    }
                                    finally {
                                        documentHandler.
                                          endSelector(
                                            sl);
                                    } }
    protected org.w3c.css.sac.SelectorList parseSelectorList() {
        org.apache.batik.css.parser.CSSSelectorList result =
          new org.apache.batik.css.parser.CSSSelectorList(
          );
        result.
          append(
            parseSelector(
              ));
        for (;
             ;
             ) {
            if (current !=
                  org.apache.batik.css.parser.LexicalUnits.
                    COMMA) {
                return result;
            }
            nextIgnoreSpaces(
              );
            result.
              append(
                parseSelector(
                  ));
        }
    }
    protected org.w3c.css.sac.Selector parseSelector() {
        pseudoElement =
          null;
        org.w3c.css.sac.Selector result =
          parseSimpleSelector(
            );
        loop: for (;
                   ;
                   ) {
            switch (current) {
                default:
                    break loop;
                case org.apache.batik.css.parser.LexicalUnits.
                       IDENTIFIER:
                case org.apache.batik.css.parser.LexicalUnits.
                       ANY:
                case org.apache.batik.css.parser.LexicalUnits.
                       HASH:
                case org.apache.batik.css.parser.LexicalUnits.
                       DOT:
                case org.apache.batik.css.parser.LexicalUnits.
                       LEFT_BRACKET:
                case org.apache.batik.css.parser.LexicalUnits.
                       COLON:
                    if (pseudoElement !=
                          null) {
                        throw createCSSParseException(
                                "pseudo.element.position");
                    }
                    result =
                      selectorFactory.
                        createDescendantSelector(
                          result,
                          parseSimpleSelector(
                            ));
                    break;
                case org.apache.batik.css.parser.LexicalUnits.
                       PLUS:
                    if (pseudoElement !=
                          null) {
                        throw createCSSParseException(
                                "pseudo.element.position");
                    }
                    nextIgnoreSpaces(
                      );
                    result =
                      selectorFactory.
                        createDirectAdjacentSelector(
                          (short)
                            1,
                          result,
                          parseSimpleSelector(
                            ));
                    break;
                case org.apache.batik.css.parser.LexicalUnits.
                       PRECEDE:
                    if (pseudoElement !=
                          null) {
                        throw createCSSParseException(
                                "pseudo.element.position");
                    }
                    nextIgnoreSpaces(
                      );
                    result =
                      selectorFactory.
                        createChildSelector(
                          result,
                          parseSimpleSelector(
                            ));
            }
        }
        if (pseudoElement !=
              null) {
            result =
              selectorFactory.
                createChildSelector(
                  result,
                  selectorFactory.
                    createPseudoElementSelector(
                      null,
                      pseudoElement));
        }
        return result;
    }
    protected org.w3c.css.sac.SimpleSelector parseSimpleSelector() {
        org.w3c.css.sac.SimpleSelector result;
        switch (current) {
            case org.apache.batik.css.parser.LexicalUnits.
                   IDENTIFIER:
                result =
                  selectorFactory.
                    createElementSelector(
                      null,
                      scanner.
                        getStringValue(
                          ));
                next(
                  );
                break;
            case org.apache.batik.css.parser.LexicalUnits.
                   ANY:
                next(
                  );
            default:
                result =
                  selectorFactory.
                    createElementSelector(
                      null,
                      null);
        }
        org.w3c.css.sac.Condition cond =
          null;
        loop: for (;
                   ;
                   ) {
            org.w3c.css.sac.Condition c =
              null;
            switch (current) {
                case org.apache.batik.css.parser.LexicalUnits.
                       HASH:
                    c =
                      conditionFactory.
                        createIdCondition(
                          scanner.
                            getStringValue(
                              ));
                    next(
                      );
                    break;
                case org.apache.batik.css.parser.LexicalUnits.
                       DOT:
                    if (next(
                          ) !=
                          org.apache.batik.css.parser.LexicalUnits.
                            IDENTIFIER) {
                        throw createCSSParseException(
                                "identifier");
                    }
                    c =
                      conditionFactory.
                        createClassCondition(
                          null,
                          scanner.
                            getStringValue(
                              ));
                    next(
                      );
                    break;
                case org.apache.batik.css.parser.LexicalUnits.
                       LEFT_BRACKET:
                    if (nextIgnoreSpaces(
                          ) !=
                          org.apache.batik.css.parser.LexicalUnits.
                            IDENTIFIER) {
                        throw createCSSParseException(
                                "identifier");
                    }
                    java.lang.String name =
                      scanner.
                      getStringValue(
                        );
                    int op =
                      nextIgnoreSpaces(
                        );
                    switch (op) {
                        default:
                            throw createCSSParseException(
                                    "right.bracket");
                        case org.apache.batik.css.parser.LexicalUnits.
                               RIGHT_BRACKET:
                            nextIgnoreSpaces(
                              );
                            c =
                              conditionFactory.
                                createAttributeCondition(
                                  name,
                                  null,
                                  false,
                                  null);
                            break;
                        case org.apache.batik.css.parser.LexicalUnits.
                               EQUAL:
                        case org.apache.batik.css.parser.LexicalUnits.
                               INCLUDES:
                        case org.apache.batik.css.parser.LexicalUnits.
                               DASHMATCH:
                            java.lang.String val =
                              null;
                            switch (nextIgnoreSpaces(
                                      )) {
                                default:
                                    throw createCSSParseException(
                                            "identifier.or.string");
                                case org.apache.batik.css.parser.LexicalUnits.
                                       STRING:
                                case org.apache.batik.css.parser.LexicalUnits.
                                       IDENTIFIER:
                                    val =
                                      scanner.
                                        getStringValue(
                                          );
                                    nextIgnoreSpaces(
                                      );
                            }
                            if (current !=
                                  org.apache.batik.css.parser.LexicalUnits.
                                    RIGHT_BRACKET) {
                                throw createCSSParseException(
                                        "right.bracket");
                            }
                            next(
                              );
                            switch (op) {
                                case org.apache.batik.css.parser.LexicalUnits.
                                       EQUAL:
                                    c =
                                      conditionFactory.
                                        createAttributeCondition(
                                          name,
                                          null,
                                          false,
                                          val);
                                    break;
                                case org.apache.batik.css.parser.LexicalUnits.
                                       INCLUDES:
                                    c =
                                      conditionFactory.
                                        createOneOfAttributeCondition(
                                          name,
                                          null,
                                          false,
                                          val);
                                    break;
                                default:
                                    c =
                                      conditionFactory.
                                        createBeginHyphenAttributeCondition(
                                          name,
                                          null,
                                          false,
                                          val);
                            }
                    }
                    break;
                case org.apache.batik.css.parser.LexicalUnits.
                       COLON:
                    switch (nextIgnoreSpaces(
                              )) {
                        case org.apache.batik.css.parser.LexicalUnits.
                               IDENTIFIER:
                            java.lang.String val2 =
                              scanner.
                              getStringValue(
                                );
                            if (isPseudoElement(
                                  val2)) {
                                if (pseudoElement !=
                                      null) {
                                    throw createCSSParseException(
                                            "duplicate.pseudo.element");
                                }
                                pseudoElement =
                                  val2;
                            }
                            else {
                                c =
                                  conditionFactory.
                                    createPseudoClassCondition(
                                      null,
                                      val2);
                            }
                            next(
                              );
                            break;
                        case org.apache.batik.css.parser.LexicalUnits.
                               FUNCTION:
                            java.lang.String func =
                              scanner.
                              getStringValue(
                                );
                            if (nextIgnoreSpaces(
                                  ) !=
                                  org.apache.batik.css.parser.LexicalUnits.
                                    IDENTIFIER) {
                                throw createCSSParseException(
                                        "identifier");
                            }
                            java.lang.String lang =
                              scanner.
                              getStringValue(
                                );
                            if (nextIgnoreSpaces(
                                  ) !=
                                  org.apache.batik.css.parser.LexicalUnits.
                                    RIGHT_BRACE) {
                                throw createCSSParseException(
                                        "right.brace");
                            }
                            if (!func.
                                  equalsIgnoreCase(
                                    "lang")) {
                                throw createCSSParseException(
                                        "pseudo.function");
                            }
                            c =
                              conditionFactory.
                                createLangCondition(
                                  lang);
                            next(
                              );
                            break;
                        default:
                            throw createCSSParseException(
                                    "identifier");
                    }
                    break;
                default:
                    break loop;
            }
            if (c !=
                  null) {
                if (cond ==
                      null) {
                    cond =
                      c;
                }
                else {
                    cond =
                      conditionFactory.
                        createAndCondition(
                          cond,
                          c);
                }
            }
        }
        skipSpaces(
          );
        if (cond !=
              null) {
            result =
              selectorFactory.
                createConditionalSelector(
                  result,
                  cond);
        }
        return result;
    }
    protected boolean isPseudoElement(java.lang.String s) {
        switch (s.
                  charAt(
                    0)) {
            case 'a':
            case 'A':
                return s.
                  equalsIgnoreCase(
                    "after");
            case 'b':
            case 'B':
                return s.
                  equalsIgnoreCase(
                    "before");
            case 'f':
            case 'F':
                return s.
                  equalsIgnoreCase(
                    "first-letter") ||
                  s.
                  equalsIgnoreCase(
                    "first-line");
        }
        return false;
    }
    protected void parseStyleDeclaration(boolean inSheet)
          throws org.w3c.css.sac.CSSException {
        for (;
             ;
             ) {
            switch (current) {
                case org.apache.batik.css.parser.LexicalUnits.
                       EOF:
                    if (inSheet) {
                        throw createCSSParseException(
                                "eof");
                    }
                    return;
                case org.apache.batik.css.parser.LexicalUnits.
                       RIGHT_CURLY_BRACE:
                    if (!inSheet) {
                        throw createCSSParseException(
                                "eof.expected");
                    }
                    nextIgnoreSpaces(
                      );
                    return;
                case org.apache.batik.css.parser.LexicalUnits.
                       SEMI_COLON:
                    nextIgnoreSpaces(
                      );
                    continue;
                default:
                    throw createCSSParseException(
                            "identifier");
                case org.apache.batik.css.parser.LexicalUnits.
                       IDENTIFIER:
            }
            java.lang.String name =
              scanner.
              getStringValue(
                );
            if (nextIgnoreSpaces(
                  ) !=
                  org.apache.batik.css.parser.LexicalUnits.
                    COLON) {
                throw createCSSParseException(
                        "colon");
            }
            nextIgnoreSpaces(
              );
            org.w3c.css.sac.LexicalUnit exp =
              null;
            try {
                exp =
                  parseExpression(
                    false);
            }
            catch (org.w3c.css.sac.CSSParseException e) {
                reportError(
                  e);
            }
            if (exp !=
                  null) {
                boolean important =
                  false;
                if (current ==
                      org.apache.batik.css.parser.LexicalUnits.
                        IMPORTANT_SYMBOL) {
                    important =
                      true;
                    nextIgnoreSpaces(
                      );
                }
                documentHandler.
                  property(
                    name,
                    exp,
                    important);
            }
        }
    }
    protected org.w3c.css.sac.LexicalUnit parseExpression(boolean param) {
        org.w3c.css.sac.LexicalUnit result =
          parseTerm(
            null);
        org.w3c.css.sac.LexicalUnit curr =
          result;
        for (;
             ;
             ) {
            boolean op =
              false;
            switch (current) {
                case org.apache.batik.css.parser.LexicalUnits.
                       COMMA:
                    op =
                      true;
                    curr =
                      org.apache.batik.css.parser.CSSLexicalUnit.
                        createSimple(
                          org.w3c.css.sac.LexicalUnit.
                            SAC_OPERATOR_COMMA,
                          curr);
                    nextIgnoreSpaces(
                      );
                    break;
                case org.apache.batik.css.parser.LexicalUnits.
                       DIVIDE:
                    op =
                      true;
                    curr =
                      org.apache.batik.css.parser.CSSLexicalUnit.
                        createSimple(
                          org.w3c.css.sac.LexicalUnit.
                            SAC_OPERATOR_SLASH,
                          curr);
                    nextIgnoreSpaces(
                      );
            }
            if (param) {
                if (current ==
                      org.apache.batik.css.parser.LexicalUnits.
                        RIGHT_BRACE) {
                    if (op) {
                        throw createCSSParseException(
                                "token",
                                new java.lang.Object[] { new java.lang.Integer(
                                  current) });
                    }
                    return result;
                }
                curr =
                  parseTerm(
                    curr);
            }
            else {
                switch (current) {
                    case org.apache.batik.css.parser.LexicalUnits.
                           IMPORTANT_SYMBOL:
                    case org.apache.batik.css.parser.LexicalUnits.
                           SEMI_COLON:
                    case org.apache.batik.css.parser.LexicalUnits.
                           RIGHT_CURLY_BRACE:
                    case org.apache.batik.css.parser.LexicalUnits.
                           EOF:
                        if (op) {
                            throw createCSSParseException(
                                    "token",
                                    new java.lang.Object[] { new java.lang.Integer(
                                      current) });
                        }
                        return result;
                    default:
                        curr =
                          parseTerm(
                            curr);
                }
            }
        }
    }
    protected org.w3c.css.sac.LexicalUnit parseTerm(org.w3c.css.sac.LexicalUnit prev) {
        boolean plus =
          true;
        boolean sgn =
          false;
        switch (current) {
            case org.apache.batik.css.parser.LexicalUnits.
                   MINUS:
                plus =
                  false;
            case org.apache.batik.css.parser.LexicalUnits.
                   PLUS:
                next(
                  );
                sgn =
                  true;
            default:
                switch (current) {
                    case org.apache.batik.css.parser.LexicalUnits.
                           INTEGER:
                        java.lang.String sval =
                          scanner.
                          getStringValue(
                            );
                        if (!plus)
                            sval =
                              "-" +
                              sval;
                        long lVal =
                          java.lang.Long.
                          parseLong(
                            sval);
                        if (lVal >=
                              java.lang.Integer.
                                MIN_VALUE &&
                              lVal <=
                              java.lang.Integer.
                                MAX_VALUE) {
                            int iVal =
                              (int)
                                lVal;
                            nextIgnoreSpaces(
                              );
                            return org.apache.batik.css.parser.CSSLexicalUnit.
                              createInteger(
                                iVal,
                                prev);
                        }
                    case org.apache.batik.css.parser.LexicalUnits.
                           REAL:
                        return org.apache.batik.css.parser.CSSLexicalUnit.
                          createFloat(
                            org.w3c.css.sac.LexicalUnit.
                              SAC_REAL,
                            number(
                              plus),
                            prev);
                    case org.apache.batik.css.parser.LexicalUnits.
                           PERCENTAGE:
                        return org.apache.batik.css.parser.CSSLexicalUnit.
                          createFloat(
                            org.w3c.css.sac.LexicalUnit.
                              SAC_PERCENTAGE,
                            number(
                              plus),
                            prev);
                    case org.apache.batik.css.parser.LexicalUnits.
                           PT:
                        return org.apache.batik.css.parser.CSSLexicalUnit.
                          createFloat(
                            org.w3c.css.sac.LexicalUnit.
                              SAC_POINT,
                            number(
                              plus),
                            prev);
                    case org.apache.batik.css.parser.LexicalUnits.
                           PC:
                        return org.apache.batik.css.parser.CSSLexicalUnit.
                          createFloat(
                            org.w3c.css.sac.LexicalUnit.
                              SAC_PICA,
                            number(
                              plus),
                            prev);
                    case org.apache.batik.css.parser.LexicalUnits.
                           PX:
                        return org.apache.batik.css.parser.CSSLexicalUnit.
                          createFloat(
                            org.w3c.css.sac.LexicalUnit.
                              SAC_PIXEL,
                            number(
                              plus),
                            prev);
                    case org.apache.batik.css.parser.LexicalUnits.
                           CM:
                        return org.apache.batik.css.parser.CSSLexicalUnit.
                          createFloat(
                            org.w3c.css.sac.LexicalUnit.
                              SAC_CENTIMETER,
                            number(
                              plus),
                            prev);
                    case org.apache.batik.css.parser.LexicalUnits.
                           MM:
                        return org.apache.batik.css.parser.CSSLexicalUnit.
                          createFloat(
                            org.w3c.css.sac.LexicalUnit.
                              SAC_MILLIMETER,
                            number(
                              plus),
                            prev);
                    case org.apache.batik.css.parser.LexicalUnits.
                           IN:
                        return org.apache.batik.css.parser.CSSLexicalUnit.
                          createFloat(
                            org.w3c.css.sac.LexicalUnit.
                              SAC_INCH,
                            number(
                              plus),
                            prev);
                    case org.apache.batik.css.parser.LexicalUnits.
                           EM:
                        return org.apache.batik.css.parser.CSSLexicalUnit.
                          createFloat(
                            org.w3c.css.sac.LexicalUnit.
                              SAC_EM,
                            number(
                              plus),
                            prev);
                    case org.apache.batik.css.parser.LexicalUnits.
                           EX:
                        return org.apache.batik.css.parser.CSSLexicalUnit.
                          createFloat(
                            org.w3c.css.sac.LexicalUnit.
                              SAC_EX,
                            number(
                              plus),
                            prev);
                    case org.apache.batik.css.parser.LexicalUnits.
                           DEG:
                        return org.apache.batik.css.parser.CSSLexicalUnit.
                          createFloat(
                            org.w3c.css.sac.LexicalUnit.
                              SAC_DEGREE,
                            number(
                              plus),
                            prev);
                    case org.apache.batik.css.parser.LexicalUnits.
                           RAD:
                        return org.apache.batik.css.parser.CSSLexicalUnit.
                          createFloat(
                            org.w3c.css.sac.LexicalUnit.
                              SAC_RADIAN,
                            number(
                              plus),
                            prev);
                    case org.apache.batik.css.parser.LexicalUnits.
                           GRAD:
                        return org.apache.batik.css.parser.CSSLexicalUnit.
                          createFloat(
                            org.w3c.css.sac.LexicalUnit.
                              SAC_GRADIAN,
                            number(
                              plus),
                            prev);
                    case org.apache.batik.css.parser.LexicalUnits.
                           S:
                        return org.apache.batik.css.parser.CSSLexicalUnit.
                          createFloat(
                            org.w3c.css.sac.LexicalUnit.
                              SAC_SECOND,
                            number(
                              plus),
                            prev);
                    case org.apache.batik.css.parser.LexicalUnits.
                           MS:
                        return org.apache.batik.css.parser.CSSLexicalUnit.
                          createFloat(
                            org.w3c.css.sac.LexicalUnit.
                              SAC_MILLISECOND,
                            number(
                              plus),
                            prev);
                    case org.apache.batik.css.parser.LexicalUnits.
                           HZ:
                        return org.apache.batik.css.parser.CSSLexicalUnit.
                          createFloat(
                            org.w3c.css.sac.LexicalUnit.
                              SAC_HERTZ,
                            number(
                              plus),
                            prev);
                    case org.apache.batik.css.parser.LexicalUnits.
                           KHZ:
                        return org.apache.batik.css.parser.CSSLexicalUnit.
                          createFloat(
                            org.w3c.css.sac.LexicalUnit.
                              SAC_KILOHERTZ,
                            number(
                              plus),
                            prev);
                    case org.apache.batik.css.parser.LexicalUnits.
                           DIMENSION:
                        return dimension(
                                 plus,
                                 prev);
                    case org.apache.batik.css.parser.LexicalUnits.
                           FUNCTION:
                        return parseFunction(
                                 plus,
                                 prev);
                }
                if (sgn) {
                    throw createCSSParseException(
                            "token",
                            new java.lang.Object[] { new java.lang.Integer(
                              current) });
                }
        }
        switch (current) {
            case org.apache.batik.css.parser.LexicalUnits.
                   STRING:
                java.lang.String val =
                  scanner.
                  getStringValue(
                    );
                nextIgnoreSpaces(
                  );
                return org.apache.batik.css.parser.CSSLexicalUnit.
                  createString(
                    org.w3c.css.sac.LexicalUnit.
                      SAC_STRING_VALUE,
                    val,
                    prev);
            case org.apache.batik.css.parser.LexicalUnits.
                   IDENTIFIER:
                val =
                  scanner.
                    getStringValue(
                      );
                nextIgnoreSpaces(
                  );
                if (val.
                      equalsIgnoreCase(
                        "inherit")) {
                    return org.apache.batik.css.parser.CSSLexicalUnit.
                      createSimple(
                        org.w3c.css.sac.LexicalUnit.
                          SAC_INHERIT,
                        prev);
                }
                else {
                    return org.apache.batik.css.parser.CSSLexicalUnit.
                      createString(
                        org.w3c.css.sac.LexicalUnit.
                          SAC_IDENT,
                        val,
                        prev);
                }
            case org.apache.batik.css.parser.LexicalUnits.
                   URI:
                val =
                  scanner.
                    getStringValue(
                      );
                nextIgnoreSpaces(
                  );
                return org.apache.batik.css.parser.CSSLexicalUnit.
                  createString(
                    org.w3c.css.sac.LexicalUnit.
                      SAC_URI,
                    val,
                    prev);
            case org.apache.batik.css.parser.LexicalUnits.
                   HASH:
                return hexcolor(
                         prev);
            default:
                throw createCSSParseException(
                        "token",
                        new java.lang.Object[] { new java.lang.Integer(
                          current) });
        }
    }
    protected org.w3c.css.sac.LexicalUnit parseFunction(boolean positive,
                                                        org.w3c.css.sac.LexicalUnit prev) {
        java.lang.String name =
          scanner.
          getStringValue(
            );
        nextIgnoreSpaces(
          );
        org.w3c.css.sac.LexicalUnit params =
          parseExpression(
            true);
        if (current !=
              org.apache.batik.css.parser.LexicalUnits.
                RIGHT_BRACE) {
            throw createCSSParseException(
                    "token",
                    new java.lang.Object[] { new java.lang.Integer(
                      current) });
        }
        nextIgnoreSpaces(
          );
        predefined: switch (name.
                              charAt(
                                0)) {
            case 'r':
            case 'R':
                org.w3c.css.sac.LexicalUnit lu;
                if (name.
                      equalsIgnoreCase(
                        "rgb")) {
                    lu =
                      params;
                    if (lu ==
                          null) {
                        break;
                    }
                    switch (lu.
                              getLexicalUnitType(
                                )) {
                        default:
                            break predefined;
                        case org.w3c.css.sac.LexicalUnit.
                               SAC_INTEGER:
                        case org.w3c.css.sac.LexicalUnit.
                               SAC_PERCENTAGE:
                            lu =
                              lu.
                                getNextLexicalUnit(
                                  );
                    }
                    if (lu ==
                          null) {
                        break;
                    }
                    switch (lu.
                              getLexicalUnitType(
                                )) {
                        default:
                            break predefined;
                        case org.w3c.css.sac.LexicalUnit.
                               SAC_OPERATOR_COMMA:
                            lu =
                              lu.
                                getNextLexicalUnit(
                                  );
                    }
                    if (lu ==
                          null) {
                        break;
                    }
                    switch (lu.
                              getLexicalUnitType(
                                )) {
                        default:
                            break predefined;
                        case org.w3c.css.sac.LexicalUnit.
                               SAC_INTEGER:
                        case org.w3c.css.sac.LexicalUnit.
                               SAC_PERCENTAGE:
                            lu =
                              lu.
                                getNextLexicalUnit(
                                  );
                    }
                    if (lu ==
                          null) {
                        break;
                    }
                    switch (lu.
                              getLexicalUnitType(
                                )) {
                        default:
                            break predefined;
                        case org.w3c.css.sac.LexicalUnit.
                               SAC_OPERATOR_COMMA:
                            lu =
                              lu.
                                getNextLexicalUnit(
                                  );
                    }
                    if (lu ==
                          null) {
                        break;
                    }
                    switch (lu.
                              getLexicalUnitType(
                                )) {
                        default:
                            break predefined;
                        case org.w3c.css.sac.LexicalUnit.
                               SAC_INTEGER:
                        case org.w3c.css.sac.LexicalUnit.
                               SAC_PERCENTAGE:
                            lu =
                              lu.
                                getNextLexicalUnit(
                                  );
                    }
                    if (lu !=
                          null) {
                        break;
                    }
                    return org.apache.batik.css.parser.CSSLexicalUnit.
                      createPredefinedFunction(
                        org.w3c.css.sac.LexicalUnit.
                          SAC_RGBCOLOR,
                        params,
                        prev);
                }
                else
                    if (name.
                          equalsIgnoreCase(
                            "rect")) {
                        lu =
                          params;
                        if (lu ==
                              null) {
                            break;
                        }
                        switch (lu.
                                  getLexicalUnitType(
                                    )) {
                            default:
                                break predefined;
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_INTEGER:
                                if (lu.
                                      getIntegerValue(
                                        ) !=
                                      0) {
                                    break predefined;
                                }
                                lu =
                                  lu.
                                    getNextLexicalUnit(
                                      );
                                break;
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_IDENT:
                                if (!lu.
                                      getStringValue(
                                        ).
                                      equalsIgnoreCase(
                                        "auto")) {
                                    break predefined;
                                }
                                lu =
                                  lu.
                                    getNextLexicalUnit(
                                      );
                                break;
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_EM:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_EX:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_PIXEL:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_CENTIMETER:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_MILLIMETER:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_INCH:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_POINT:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_PICA:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_PERCENTAGE:
                                lu =
                                  lu.
                                    getNextLexicalUnit(
                                      );
                        }
                        if (lu ==
                              null) {
                            break;
                        }
                        switch (lu.
                                  getLexicalUnitType(
                                    )) {
                            default:
                                break predefined;
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_OPERATOR_COMMA:
                                lu =
                                  lu.
                                    getNextLexicalUnit(
                                      );
                        }
                        if (lu ==
                              null) {
                            break;
                        }
                        switch (lu.
                                  getLexicalUnitType(
                                    )) {
                            default:
                                break predefined;
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_INTEGER:
                                if (lu.
                                      getIntegerValue(
                                        ) !=
                                      0) {
                                    break predefined;
                                }
                                lu =
                                  lu.
                                    getNextLexicalUnit(
                                      );
                                break;
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_IDENT:
                                if (!lu.
                                      getStringValue(
                                        ).
                                      equalsIgnoreCase(
                                        "auto")) {
                                    break predefined;
                                }
                                lu =
                                  lu.
                                    getNextLexicalUnit(
                                      );
                                break;
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_EM:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_EX:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_PIXEL:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_CENTIMETER:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_MILLIMETER:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_INCH:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_POINT:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_PICA:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_PERCENTAGE:
                                lu =
                                  lu.
                                    getNextLexicalUnit(
                                      );
                        }
                        if (lu ==
                              null) {
                            break;
                        }
                        switch (lu.
                                  getLexicalUnitType(
                                    )) {
                            default:
                                break predefined;
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_OPERATOR_COMMA:
                                lu =
                                  lu.
                                    getNextLexicalUnit(
                                      );
                        }
                        if (lu ==
                              null) {
                            break;
                        }
                        switch (lu.
                                  getLexicalUnitType(
                                    )) {
                            default:
                                break predefined;
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_INTEGER:
                                if (lu.
                                      getIntegerValue(
                                        ) !=
                                      0) {
                                    break predefined;
                                }
                                lu =
                                  lu.
                                    getNextLexicalUnit(
                                      );
                                break;
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_IDENT:
                                if (!lu.
                                      getStringValue(
                                        ).
                                      equalsIgnoreCase(
                                        "auto")) {
                                    break predefined;
                                }
                                lu =
                                  lu.
                                    getNextLexicalUnit(
                                      );
                                break;
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_EM:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_EX:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_PIXEL:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_CENTIMETER:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_MILLIMETER:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_INCH:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_POINT:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_PICA:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_PERCENTAGE:
                                lu =
                                  lu.
                                    getNextLexicalUnit(
                                      );
                        }
                        if (lu ==
                              null) {
                            break;
                        }
                        switch (lu.
                                  getLexicalUnitType(
                                    )) {
                            default:
                                break predefined;
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_OPERATOR_COMMA:
                                lu =
                                  lu.
                                    getNextLexicalUnit(
                                      );
                        }
                        if (lu ==
                              null) {
                            break;
                        }
                        switch (lu.
                                  getLexicalUnitType(
                                    )) {
                            default:
                                break predefined;
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_INTEGER:
                                if (lu.
                                      getIntegerValue(
                                        ) !=
                                      0) {
                                    break predefined;
                                }
                                lu =
                                  lu.
                                    getNextLexicalUnit(
                                      );
                                break;
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_IDENT:
                                if (!lu.
                                      getStringValue(
                                        ).
                                      equalsIgnoreCase(
                                        "auto")) {
                                    break predefined;
                                }
                                lu =
                                  lu.
                                    getNextLexicalUnit(
                                      );
                                break;
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_EM:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_EX:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_PIXEL:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_CENTIMETER:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_MILLIMETER:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_INCH:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_POINT:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_PICA:
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_PERCENTAGE:
                                lu =
                                  lu.
                                    getNextLexicalUnit(
                                      );
                        }
                        if (lu !=
                              null) {
                            break;
                        }
                        return org.apache.batik.css.parser.CSSLexicalUnit.
                          createPredefinedFunction(
                            org.w3c.css.sac.LexicalUnit.
                              SAC_RECT_FUNCTION,
                            params,
                            prev);
                    }
                break;
            case 'c':
            case 'C':
                if (name.
                      equalsIgnoreCase(
                        "counter")) {
                    lu =
                      params;
                    if (lu ==
                          null) {
                        break;
                    }
                    switch (lu.
                              getLexicalUnitType(
                                )) {
                        default:
                            break predefined;
                        case org.w3c.css.sac.LexicalUnit.
                               SAC_IDENT:
                            lu =
                              lu.
                                getNextLexicalUnit(
                                  );
                    }
                    if (lu ==
                          null) {
                        break;
                    }
                    switch (lu.
                              getLexicalUnitType(
                                )) {
                        default:
                            break predefined;
                        case org.w3c.css.sac.LexicalUnit.
                               SAC_OPERATOR_COMMA:
                            lu =
                              lu.
                                getNextLexicalUnit(
                                  );
                    }
                    if (lu ==
                          null) {
                        break;
                    }
                    switch (lu.
                              getLexicalUnitType(
                                )) {
                        default:
                            break predefined;
                        case org.w3c.css.sac.LexicalUnit.
                               SAC_IDENT:
                            lu =
                              lu.
                                getNextLexicalUnit(
                                  );
                    }
                    if (lu !=
                          null) {
                        break;
                    }
                    return org.apache.batik.css.parser.CSSLexicalUnit.
                      createPredefinedFunction(
                        org.w3c.css.sac.LexicalUnit.
                          SAC_COUNTER_FUNCTION,
                        params,
                        prev);
                }
                else
                    if (name.
                          equalsIgnoreCase(
                            "counters")) {
                        lu =
                          params;
                        if (lu ==
                              null) {
                            break;
                        }
                        switch (lu.
                                  getLexicalUnitType(
                                    )) {
                            default:
                                break predefined;
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_IDENT:
                                lu =
                                  lu.
                                    getNextLexicalUnit(
                                      );
                        }
                        if (lu ==
                              null) {
                            break;
                        }
                        switch (lu.
                                  getLexicalUnitType(
                                    )) {
                            default:
                                break predefined;
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_OPERATOR_COMMA:
                                lu =
                                  lu.
                                    getNextLexicalUnit(
                                      );
                        }
                        if (lu ==
                              null) {
                            break;
                        }
                        switch (lu.
                                  getLexicalUnitType(
                                    )) {
                            default:
                                break predefined;
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_STRING_VALUE:
                                lu =
                                  lu.
                                    getNextLexicalUnit(
                                      );
                        }
                        if (lu ==
                              null) {
                            break;
                        }
                        switch (lu.
                                  getLexicalUnitType(
                                    )) {
                            default:
                                break predefined;
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_OPERATOR_COMMA:
                                lu =
                                  lu.
                                    getNextLexicalUnit(
                                      );
                        }
                        if (lu ==
                              null) {
                            break;
                        }
                        switch (lu.
                                  getLexicalUnitType(
                                    )) {
                            default:
                                break predefined;
                            case org.w3c.css.sac.LexicalUnit.
                                   SAC_IDENT:
                                lu =
                                  lu.
                                    getNextLexicalUnit(
                                      );
                        }
                        if (lu !=
                              null) {
                            break;
                        }
                        return org.apache.batik.css.parser.CSSLexicalUnit.
                          createPredefinedFunction(
                            org.w3c.css.sac.LexicalUnit.
                              SAC_COUNTERS_FUNCTION,
                            params,
                            prev);
                    }
                break;
            case 'a':
            case 'A':
                if (name.
                      equalsIgnoreCase(
                        "attr")) {
                    lu =
                      params;
                    if (lu ==
                          null) {
                        break;
                    }
                    switch (lu.
                              getLexicalUnitType(
                                )) {
                        default:
                            break predefined;
                        case org.w3c.css.sac.LexicalUnit.
                               SAC_IDENT:
                            lu =
                              lu.
                                getNextLexicalUnit(
                                  );
                    }
                    if (lu !=
                          null) {
                        break;
                    }
                    return org.apache.batik.css.parser.CSSLexicalUnit.
                      createString(
                        org.w3c.css.sac.LexicalUnit.
                          SAC_ATTR,
                        params.
                          getStringValue(
                            ),
                        prev);
                }
        }
        return org.apache.batik.css.parser.CSSLexicalUnit.
          createFunction(
            name,
            params,
            prev);
    }
    protected org.w3c.css.sac.LexicalUnit hexcolor(org.w3c.css.sac.LexicalUnit prev) {
        java.lang.String val =
          scanner.
          getStringValue(
            );
        int len =
          val.
          length(
            );
        org.w3c.css.sac.LexicalUnit params =
          null;
        switch (len) {
            case 3:
                char rc =
                  java.lang.Character.
                  toLowerCase(
                    val.
                      charAt(
                        0));
                char gc =
                  java.lang.Character.
                  toLowerCase(
                    val.
                      charAt(
                        1));
                char bc =
                  java.lang.Character.
                  toLowerCase(
                    val.
                      charAt(
                        2));
                if (!org.apache.batik.css.parser.ScannerUtilities.
                      isCSSHexadecimalCharacter(
                        rc) ||
                      !org.apache.batik.css.parser.ScannerUtilities.
                      isCSSHexadecimalCharacter(
                        gc) ||
                      !org.apache.batik.css.parser.ScannerUtilities.
                      isCSSHexadecimalCharacter(
                        bc)) {
                    throw createCSSParseException(
                            "rgb.color",
                            new java.lang.Object[] { val });
                }
                int t;
                int r =
                  t =
                  rc >=
                    '0' &&
                    rc <=
                    '9'
                    ? rc -
                    '0'
                    : rc -
                    'a' +
                    10;
                t <<=
                  4;
                r |=
                  t;
                int g =
                  t =
                  gc >=
                    '0' &&
                    gc <=
                    '9'
                    ? gc -
                    '0'
                    : gc -
                    'a' +
                    10;
                t <<=
                  4;
                g |=
                  t;
                int b =
                  t =
                  bc >=
                    '0' &&
                    bc <=
                    '9'
                    ? bc -
                    '0'
                    : bc -
                    'a' +
                    10;
                t <<=
                  4;
                b |=
                  t;
                params =
                  org.apache.batik.css.parser.CSSLexicalUnit.
                    createInteger(
                      r,
                      null);
                org.w3c.css.sac.LexicalUnit tmp;
                tmp =
                  org.apache.batik.css.parser.CSSLexicalUnit.
                    createSimple(
                      org.w3c.css.sac.LexicalUnit.
                        SAC_OPERATOR_COMMA,
                      params);
                tmp =
                  org.apache.batik.css.parser.CSSLexicalUnit.
                    createInteger(
                      g,
                      tmp);
                tmp =
                  org.apache.batik.css.parser.CSSLexicalUnit.
                    createSimple(
                      org.w3c.css.sac.LexicalUnit.
                        SAC_OPERATOR_COMMA,
                      tmp);
                tmp =
                  org.apache.batik.css.parser.CSSLexicalUnit.
                    createInteger(
                      b,
                      tmp);
                break;
            case 6:
                char rc1 =
                  java.lang.Character.
                  toLowerCase(
                    val.
                      charAt(
                        0));
                char rc2 =
                  java.lang.Character.
                  toLowerCase(
                    val.
                      charAt(
                        1));
                char gc1 =
                  java.lang.Character.
                  toLowerCase(
                    val.
                      charAt(
                        2));
                char gc2 =
                  java.lang.Character.
                  toLowerCase(
                    val.
                      charAt(
                        3));
                char bc1 =
                  java.lang.Character.
                  toLowerCase(
                    val.
                      charAt(
                        4));
                char bc2 =
                  java.lang.Character.
                  toLowerCase(
                    val.
                      charAt(
                        5));
                if (!org.apache.batik.css.parser.ScannerUtilities.
                      isCSSHexadecimalCharacter(
                        rc1) ||
                      !org.apache.batik.css.parser.ScannerUtilities.
                      isCSSHexadecimalCharacter(
                        rc2) ||
                      !org.apache.batik.css.parser.ScannerUtilities.
                      isCSSHexadecimalCharacter(
                        gc1) ||
                      !org.apache.batik.css.parser.ScannerUtilities.
                      isCSSHexadecimalCharacter(
                        gc2) ||
                      !org.apache.batik.css.parser.ScannerUtilities.
                      isCSSHexadecimalCharacter(
                        bc1) ||
                      !org.apache.batik.css.parser.ScannerUtilities.
                      isCSSHexadecimalCharacter(
                        bc2)) {
                    throw createCSSParseException(
                            "rgb.color");
                }
                r =
                  rc1 >=
                    '0' &&
                    rc1 <=
                    '9'
                    ? rc1 -
                    '0'
                    : rc1 -
                    'a' +
                    10;
                r <<=
                  4;
                r |=
                  rc2 >=
                    '0' &&
                    rc2 <=
                    '9'
                    ? rc2 -
                    '0'
                    : rc2 -
                    'a' +
                    10;
                g =
                  gc1 >=
                    '0' &&
                    gc1 <=
                    '9'
                    ? gc1 -
                    '0'
                    : gc1 -
                    'a' +
                    10;
                g <<=
                  4;
                g |=
                  gc2 >=
                    '0' &&
                    gc2 <=
                    '9'
                    ? gc2 -
                    '0'
                    : gc2 -
                    'a' +
                    10;
                b =
                  bc1 >=
                    '0' &&
                    bc1 <=
                    '9'
                    ? bc1 -
                    '0'
                    : bc1 -
                    'a' +
                    10;
                b <<=
                  4;
                b |=
                  bc2 >=
                    '0' &&
                    bc2 <=
                    '9'
                    ? bc2 -
                    '0'
                    : bc2 -
                    'a' +
                    10;
                params =
                  org.apache.batik.css.parser.CSSLexicalUnit.
                    createInteger(
                      r,
                      null);
                tmp =
                  org.apache.batik.css.parser.CSSLexicalUnit.
                    createSimple(
                      org.w3c.css.sac.LexicalUnit.
                        SAC_OPERATOR_COMMA,
                      params);
                tmp =
                  org.apache.batik.css.parser.CSSLexicalUnit.
                    createInteger(
                      g,
                      tmp);
                tmp =
                  org.apache.batik.css.parser.CSSLexicalUnit.
                    createSimple(
                      org.w3c.css.sac.LexicalUnit.
                        SAC_OPERATOR_COMMA,
                      tmp);
                tmp =
                  org.apache.batik.css.parser.CSSLexicalUnit.
                    createInteger(
                      b,
                      tmp);
                break;
            default:
                throw createCSSParseException(
                        "rgb.color",
                        new java.lang.Object[] { val });
        }
        nextIgnoreSpaces(
          );
        return org.apache.batik.css.parser.CSSLexicalUnit.
          createPredefinedFunction(
            org.w3c.css.sac.LexicalUnit.
              SAC_RGBCOLOR,
            params,
            prev);
    }
    protected org.apache.batik.css.parser.Scanner createScanner(org.w3c.css.sac.InputSource source) {
        documentURI =
          source.
            getURI(
              );
        if (documentURI ==
              null) {
            documentURI =
              "";
        }
        java.io.Reader r =
          source.
          getCharacterStream(
            );
        if (r !=
              null) {
            return new org.apache.batik.css.parser.Scanner(
              r);
        }
        java.io.InputStream is =
          source.
          getByteStream(
            );
        if (is !=
              null) {
            return new org.apache.batik.css.parser.Scanner(
              is,
              source.
                getEncoding(
                  ));
        }
        java.lang.String uri =
          source.
          getURI(
            );
        if (uri ==
              null) {
            throw new org.w3c.css.sac.CSSException(
              formatMessage(
                "empty.source",
                null));
        }
        try {
            org.apache.batik.util.ParsedURL purl =
              new org.apache.batik.util.ParsedURL(
              uri);
            is =
              purl.
                openStreamRaw(
                  org.apache.batik.util.CSSConstants.
                    CSS_MIME_TYPE);
            return new org.apache.batik.css.parser.Scanner(
              is,
              source.
                getEncoding(
                  ));
        }
        catch (java.io.IOException e) {
            throw new org.w3c.css.sac.CSSException(
              e);
        }
    }
    protected int skipSpaces() { int lex =
                                   scanner.
                                   getType(
                                     );
                                 while (lex ==
                                          org.apache.batik.css.parser.LexicalUnits.
                                            SPACE) {
                                     lex =
                                       next(
                                         );
                                 }
                                 return lex;
    }
    protected int skipSpacesAndCDOCDC() {
        loop: for (;
                   ;
                   ) {
            switch (current) {
                default:
                    break loop;
                case org.apache.batik.css.parser.LexicalUnits.
                       COMMENT:
                case org.apache.batik.css.parser.LexicalUnits.
                       SPACE:
                case org.apache.batik.css.parser.LexicalUnits.
                       CDO:
                case org.apache.batik.css.parser.LexicalUnits.
                       CDC:
            }
            scanner.
              clearBuffer(
                );
            next(
              );
        }
        return current;
    }
    protected float number(boolean positive) {
        try {
            float sgn =
              positive
              ? 1
              : -1;
            java.lang.String val =
              scanner.
              getStringValue(
                );
            nextIgnoreSpaces(
              );
            return sgn *
              java.lang.Float.
              parseFloat(
                val);
        }
        catch (java.lang.NumberFormatException e) {
            throw createCSSParseException(
                    "number.format");
        }
    }
    protected org.w3c.css.sac.LexicalUnit dimension(boolean positive,
                                                    org.w3c.css.sac.LexicalUnit prev) {
        try {
            float sgn =
              positive
              ? 1
              : -1;
            java.lang.String val =
              scanner.
              getStringValue(
                );
            int i;
            loop: for (i =
                         0;
                       i <
                         val.
                         length(
                           );
                       i++) {
                switch (val.
                          charAt(
                            i)) {
                    default:
                        break loop;
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
                    case '.':
                }
            }
            nextIgnoreSpaces(
              );
            return org.apache.batik.css.parser.CSSLexicalUnit.
              createDimension(
                sgn *
                  java.lang.Float.
                  parseFloat(
                    val.
                      substring(
                        0,
                        i)),
                val.
                  substring(
                    i),
                prev);
        }
        catch (java.lang.NumberFormatException e) {
            throw createCSSParseException(
                    "number.format");
        }
    }
    protected int next() { try { for (; ;
                                      ) {
                                     scanner.
                                       clearBuffer(
                                         );
                                     current =
                                       scanner.
                                         next(
                                           );
                                     if (current ==
                                           org.apache.batik.css.parser.LexicalUnits.
                                             COMMENT) {
                                         documentHandler.
                                           comment(
                                             scanner.
                                               getStringValue(
                                                 ));
                                     }
                                     else {
                                         break;
                                     }
                                 }
                                 return current;
                           }
                           catch (org.apache.batik.css.parser.ParseException e) {
                               reportError(
                                 e.
                                   getMessage(
                                     ));
                               return current;
                           } }
    protected int nextIgnoreSpaces() { try {
                                           loop: for (;
                                                      ;
                                                      ) {
                                               scanner.
                                                 clearBuffer(
                                                   );
                                               current =
                                                 scanner.
                                                   next(
                                                     );
                                               switch (current) {
                                                   case org.apache.batik.css.parser.LexicalUnits.
                                                          COMMENT:
                                                       documentHandler.
                                                         comment(
                                                           scanner.
                                                             getStringValue(
                                                               ));
                                                       break;
                                                   default:
                                                       break loop;
                                                   case org.apache.batik.css.parser.LexicalUnits.
                                                          SPACE:
                                               }
                                           }
                                           return current;
                                       }
                                       catch (org.apache.batik.css.parser.ParseException e) {
                                           errorHandler.
                                             error(
                                               createCSSParseException(
                                                 e.
                                                   getMessage(
                                                     )));
                                           return current;
                                       } }
    protected void reportError(java.lang.String key) {
        reportError(
          key,
          null);
    }
    protected void reportError(java.lang.String key,
                               java.lang.Object[] params) {
        reportError(
          createCSSParseException(
            key,
            params));
    }
    protected void reportError(org.w3c.css.sac.CSSParseException e) {
        errorHandler.
          error(
            e);
        int cbraces =
          1;
        for (;
             ;
             ) {
            switch (current) {
                case org.apache.batik.css.parser.LexicalUnits.
                       EOF:
                    return;
                case org.apache.batik.css.parser.LexicalUnits.
                       SEMI_COLON:
                case org.apache.batik.css.parser.LexicalUnits.
                       RIGHT_CURLY_BRACE:
                    if (--cbraces ==
                          0) {
                        nextIgnoreSpaces(
                          );
                        return;
                    }
                case org.apache.batik.css.parser.LexicalUnits.
                       LEFT_CURLY_BRACE:
                    cbraces++;
            }
            nextIgnoreSpaces(
              );
        }
    }
    protected org.w3c.css.sac.CSSParseException createCSSParseException(java.lang.String key) {
        return createCSSParseException(
                 key,
                 null);
    }
    protected org.w3c.css.sac.CSSParseException createCSSParseException(java.lang.String key,
                                                                        java.lang.Object[] params) {
        return new org.w3c.css.sac.CSSParseException(
          formatMessage(
            key,
            params),
          documentURI,
          scanner.
            getLine(
              ),
          scanner.
            getColumn(
              ));
    }
    public void parseStyleDeclaration(java.lang.String source)
          throws org.w3c.css.sac.CSSException,
        java.io.IOException { scanner = new org.apache.batik.css.parser.Scanner(
                                          source);
                              parseStyleDeclarationInternal(
                                ); }
    public void parseRule(java.lang.String source)
          throws org.w3c.css.sac.CSSException,
        java.io.IOException { scanner = new org.apache.batik.css.parser.Scanner(
                                          source);
                              parseRuleInternal(
                                ); }
    public org.w3c.css.sac.SelectorList parseSelectors(java.lang.String source)
          throws org.w3c.css.sac.CSSException,
        java.io.IOException { scanner = new org.apache.batik.css.parser.Scanner(
                                          source);
                              return parseSelectorsInternal(
                                       );
    }
    public org.w3c.css.sac.LexicalUnit parsePropertyValue(java.lang.String source)
          throws org.w3c.css.sac.CSSException,
        java.io.IOException { scanner = new org.apache.batik.css.parser.Scanner(
                                          source);
                              return parsePropertyValueInternal(
                                       );
    }
    public boolean parsePriority(java.lang.String source)
          throws org.w3c.css.sac.CSSException,
        java.io.IOException { scanner = new org.apache.batik.css.parser.Scanner(
                                          source);
                              return parsePriorityInternal(
                                       );
    }
    public org.w3c.css.sac.SACMediaList parseMedia(java.lang.String mediaText)
          throws org.w3c.css.sac.CSSException,
        java.io.IOException { org.apache.batik.css.parser.CSSSACMediaList result =
                                new org.apache.batik.css.parser.CSSSACMediaList(
                                );
                              if (!"all".
                                    equalsIgnoreCase(
                                      mediaText)) {
                                  java.util.StringTokenizer st =
                                    new java.util.StringTokenizer(
                                    mediaText,
                                    " ,");
                                  while (st.
                                           hasMoreTokens(
                                             )) {
                                      result.
                                        append(
                                          st.
                                            nextToken(
                                              ));
                                  }
                              }
                              return result;
    }
    public Parser() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "BR250WQ2uKOS59nB7PUo+4rfPvo/FDD0+pNdAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "bsp2TX7iijl70XFTc+i2xw3NgekH53nt/PzWY7blvlzKzd0CuX9+xLZcALP1" +
       "8mnrBhjQ7Up2mQJaAVyhTeev2dCHNvTRnHzzZgwv5qcvA/M/3DifEWDZdGV7" +
       "w9XjwL1uj2mM7DyJki2Oo1tUZ9P+m0DBRslymVzeum5bk5fTSk5aW0WpXVOp" +
       "nrgC+c786qvA0dpBfvVVkAubE/JkCEAet/iBF4GB0bV9xu+xPXXjKAOzwcW+" +
       "7wXRPusvu0p4ZqnhXiavanAMEvUMIT0ADnwHCb8GJOEakPJTZh/LTSHwXICq" +
       "7wN45LTR57Z1j/E+eYa83w+OwY73wTV4f/K6eFfjACy90emmgglMB6x1yc5/" +
       "ht5wzxcWP/qXP7f1jY/bhWOV9Xe893u/cfld7907FJE8clVQcLjNNirZcHjH" +
       "hs3c0j502l02LfC/+OgbfvVn3vD2LVf3HPWvOyB8/Ln//s+/ffmH/uTTJzh6" +
       "F0HsdGxIXvcMh+Rl4BjthoS5xpC41zMkd2meGjtgTHqyq9kHavWSXK1WFXWj" +
       "TaGsXsaO1jvGv/cv4H+y41+4Bv+r6+I/1PPl3Qu2i9j6mvxzR+sd4z99hvw/" +
       "Do7v3PH/Hdfg/83Xw3++/mgbz+4YgAePA0CPVTyG4C3PEEEXHMoOgXINBO+8" +
       "HgS360HgBcfU50XHue8cqnSM8+99hpw/Ag5jx7lxDc7fcz2c3+GHeqx5+cMj" +
       "fTsje8dY+4FnyNpD4LB3rNnXYO2Hr4e12/an5ZglTmLsA0/L2NaW5f7BjeXL" +
       "9ctw/v+Pn7bs56STE3yfiXstW31038MXwOAC5XvUsusnMfT4dTMEzOudB/4C" +
       "6bnGE9/35+/+7X/9yBeAqewXbkxyRwvY1ENOBR3nz76+58Pve/Ft7/2T79uE" +
       "KkBgwpsf+9+bJwk//cxg3Z/D4jZeESmHEbWJKHQtR7bpQjuEZx6BuMS7yqG5" +
       "frTRi27vVUOitf9HCiqKrMap5CTOpNuTJjhCMsRoOsVtatZfCaV2o0cs25Kg" +
       "iu1obrWpSm3Si+ogXgUSiJX63C+vuijKVCseImZmtZKtYohaDZbkgiFL1aHM" +
       "LCx0IK8bQo/HWLaTNiuIZ4iU0vQYqoRUSprGaBWeak6yut6szepQUQrkIFkG" +
       "NagIVud6bRnEbrOHtOTyekCbC0SpYRIfComsaZ49UWROblKLclZl6olIRLXJ" +
       "gillayjysoXJa7w6HXLMVJ4oAwGzRVZ1pxVH7i1pX4AnSk8cLLwhrXhhKshh" +
       "wPYFTCkrPE5G2QLnx+WJEFj4GnWU6QBfSNSia5bwfr1R4n2kJYwok8LIiW2D" +
       "Q+stUt0xcUuiGBVxJrNamOjIImm7BK2L/NSuZkPFH5Q4GaktJ07UjXSXMxbj" +
       "iUPI5UBoZDIRcR5aViJ0ohr2ROpPxmO6V6pUKH1W4Vsr1+6sxlq/ZGT9atMN" +
       "cDrgIs5EsNS1K+VMsGEaQUlT97G2G63htK825Chqj5fKVBiICquTzryZyKTb" +
       "boZU29NrfVmgu2zUWesZN1pk/YUhIZRQDjOhjZK6OHX4geEKQqdWa4VGxSKN" +
       "SNGiEryG/M64q2l0urRruB9aozXlCTRBz9Ellkx9m2xAto2vgIzbmFRWBQ4Z" +
       "wxqfJLWRpNQ11Xa8WayV3bZTscEYmlrPno2sKkavw2QcEsGq6M/bjVlzWbQ4" +
       "v1dvD5tBq4ZiyYox0HBcw+eC3+hooSawTjppsiubqlIyO83o5bqDLYmqKgzN" +
       "1lhOl3O03sY00nAIw6nNytGEbzUTtrguzeeG0Z7acJXDiUh3+t3ipOiP9Yia" +
       "txKz6qLigJ4uOAM1J7wR2VNOa5PwatBEhvEMa8q6rpXsYmDXFiZnZLyNlwKs" +
       "6cFdn5JRWIxtnmyJXUOmqpJbdwTHXWOVqY1Oe9RiNZBcPpsVoYAN1kjIMKa6" +
       "KOpV1HUnzQnCSbRn1YuwViyScOTark+2pEiW5sumhfRVSxoME3MwDsm+a07X" +
       "6pijlB7O8+sqFDnJTBzOVJPt1yy/P7FkGEKxKTzipS7GCrzSG45FHl8sTa62" +
       "5iwcq4hpRNTXY6vqAvZTxakHS4gRHMPtyt10UnYwaNQYN8cdlsM72gyflZiQ" +
       "aSoLHzZ6cOIQQF1ElE2qWIAPyUY4bg7oYDTsEvRguWbJeOkpgVCeGDMrEpJW" +
       "NVGxaNQNkwlTcYQoISZlFA2milBZL9u90cpjOt2ywq6lamuulAU0m0RoIyON" +
       "AWmipjke9tv9VpPhrTHNGjaS+jIf4DWEriC4Xur1igiy4jsW3asM25xAj3Gd" +
       "HJdUclkL8ZrjpzWXbMzHYw4VFJwSTBdGZqMOEs15guZ7PJXoUHfJVdSSr6JE" +
       "NuiwI5R2FG4pifSyYQBbVEvryKjDNJuRnZCuV+PG0oIjqAVcXy+qwjqtDL0e" +
       "uWYTxKBLPNqkhki94hbFDLLm0WQqhwiFIWZ32hYXyygUJmkDq9opNB+oQ9Xp" +
       "EZOo6jvzaZL0V1rc05x6I13Y/YWZlor43MZmxlIYNlG6VILTRqVtCDW/0sPF" +
       "BIJSQ4gqXbo2IhG7XSGchG9TKd2a0ERnzlhZCtkJmBGrZpnGGJmt4qQ/Jyhi" +
       "1i5baqfGWdlgHKl1ApHkFp26E2LIzReLOK0I8AobdBMsoYambjjD0XTg+yOP" +
       "6FGhVBRoHSqm42ZRz/oW7MNYmiycei1FbShoYHNlssIyqk01zKxOjduzQVMV" +
       "EzFTtIbKTPCsvZqnSDrAedlSWjTUqsMYhtdLlb4iVlw/q6+jflYd+TyZIaI3" +
       "n6FGRlIC1BJXgxhqjMnZSNTVXtodpVFFJIcDN0w6jgdVysa0yBPM3AoVNul0" +
       "elSJrwsDWxxXsMYMQ+L6kuzN3JmmD/Q6rVjWJEzQmiFUm9WmNlLqyMqczGiy" +
       "b3YscuixCCRaSo8aQzBnI/FEI8pKR5sjcJhBsTzSML2q99AgCnxtKtU4CqsS" +
       "tUbLtoiYd7CVvehNZTNwypWGRM6RTlKKHVapWPYKWtK9DEHAIlGmcWvdhEJ5" +
       "LWTLSb/HoyVMGod93NRn3RK1cNbmApep4dgbUDWhTvQ8ss1jy1pTJtNyAxt6" +
       "0Txe2mpPKMdh2OijeMdmzHgSdZOkjvlrbVZ0BoM+FhHuRCLiUa2P8cYaNVMt" +
       "HM1aMatQYR1aRt2hh4dsNTVUf1qzwnaioBkVNMsZ4o2jqVVOi7NGbErNYglZ" +
       "II5dk9i0Rw+TUaU5qzq4JA6rdMOFExeSs2K51tBUUyrrep8RopZSDKCApmtB" +
       "xarzZbG5clN5LhuWR0NanBRjeVIhLavdzOqOobnD+Yyoou1ixSejaqVIaYsx" +
       "tJT6bVfiVYVkWnV90LWRHj3TOkwiKW6LCsV+X3cWKrIaRVw1GaqVYBTOnCWm" +
       "eCWlXOvUEUNJmmpP6bWWWtyRGKK/SpDZdNoiVK6TTNNW4FThrEROklbbxIGU" +
       "Jsk06Vf7sT6fUGZtWBVm/IoTJZLx3M6AF4QKB1adLiXFctWSFyOPNkiFNVfN" +
       "peDMZD0Ks7XSU6KGJUZ8b7HsY62AHfZlt4VNVW3s8bCelpcuWEq7WrBelafr" +
       "TBdHiqhGNSpsRFVCz8iiJKQtx7F4KjbgXjQgPTSumOV4FPRGkOTNw2zcL1Js" +
       "WLFGtFkPqrxpBW1XZGuiT/qL1dxgYtQkDaWqBwamr0bVIVJSB4xHeqoLL6WF" +
       "3yqlRHVl4c2hStHMYOguMHXIEepAaUeSV5HJcSuLpdEQ7UcGyrjkyAjlrqOa" +
       "JD6lo2YwgtcuFhKNBJkkUluqiFyQyDFSK0G4nZakkcr06TiASgFY2mb0kJmw" +
       "LGuWepau16tNddLp4JWa5zNg8vurtWGli2mvHA0RT+8mmag3IIQcubV2C3Mk" +
       "QYtrUNOLJ7WKWg/ry1RAkFGEQ3Atc70STAbSVBmvrGkdYkjMEov1maqIPFhu" +
       "OFvQ6+682ajRYwiqW3bTbsyCoNXhBnYjWeHusjNK51bRsbteD6b8ILVK6Qge" +
       "LlsNssfbA6XUHEe6PM6EoldlmwEizqFKZR5M1dpU7S4k1kZ5ZwWNJiGex7ll" +
       "vUVrM9VLgk5kBZndrtfZvjeCTY4q8g2CbKfBknfpbmOahex82OPWWUeekeoi" +
       "GsBJ1ubaWoMbG67aUCKh06pp/ohrh3jZwPqChRkUunJ9euHM+6MoY/VWE1dZ" +
       "Qi1jtTKpL4mws+hWh3ORY0f9eL1Ae72SobZ5cog6tId2R0NDW6gdbYSoiZJK" +
       "yag/0qoTtOPYPLWQU5KiBmW6AhODdlmsTVsOGVqGv8CErJnwQaOVkeX5tMPL" +
       "Ns0pkU8yXWXOoh7VUcpTLJiVhimtDOeLxGpOHLQUVxlFLhEOQrL1pTULyVo2" +
       "tsMZ6tjBiMWMKq3yiWp2IXnS17GeZUIOr8QQgyFJo7yKxrBID7LIAQ6b4AjV" +
       "clvtDyRCW3alNkNVzKhcbzhRXNHYhQlV0TmYhSrVGAvD8sBfJq6szTlOCBaZ" +
       "EFabY7JJN6Z6k6pDzUxN1uQgNSBdrq3X0ZSBsirfB6a+OjAaZURrCVAmRkl3" +
       "jNmwMl0hC2mK2lOkRQfNeaOIVCzEN3lFEqUJ0Z3U4Zow4ODYzTKf9ESbJBF4" +
       "haQc7Rt45LcWsZPGdI9nG1kJlUp8U5YToUTI3hyFMncUDXQW6sDxsF1MRWck" +
       "deFOtUjVacFO1szaKyetoZgxlsWOnRgC3pZGezw19FUr6UUYXOtxpNDqjir0" +
       "cGDJQZrYK7y3CPvLou1Ux76bKGHklFfxerokpXDU10cQznfxctVTKwNJ8akI" +
       "M0MM74DyeI5YqSNW1+3JRPLSRre0aA4zKltmRDQeTSE/4miPxYcNlIbgmK5Y" +
       "ljAt9ppF0pxyklqqtFYlmHdH8khe9X1YJOFM6Xg6zE7FYTnDMs/FyTRo1nGm" +
       "XIGgHgHXKbG88HHR8LTcdZoRSRtpNkuQOJ/AGVysMDgU9cWyVE8yxu3TkEIV" +
       "RxVlWIsEZYa1qmQrYMjKuiYC37YGW2RTZPT+HCnOe16G2Bia1cuDSnEpQIMV" +
       "4LTUoxutQbOcqqRUG3i1ks1NmVZ7sGg4PDXBqsAa6YE3nXDRQPEgFcm8Jewx" +
       "lkquZCTtZj1WhjlFio0Bv+zHDlhSWEyQTa85KI9SZSkJzHAUz7JKpbtqembP" +
       "GPaLPgqrnLUcDBw2HMPDeR8LMZlgq+0wRLnmuizghjWDqxWKKukTJLUmgbKM" +
       "apDrNMv2zAQ35alZypmjZLowZn0QjaFUQ8BVaiXFhAZ12sDVglUQlJHjNT2z" +
       "kii1vCHXbVKshhPrMV1ljCBA+dmAHHBOe+EOKtpK7mkdCZ4sBo5i657S8Nvt" +
       "Cb6kp1WyzU353nJaFubiYK22NbXZo70mLCzY5dSXYgmeM+u4Yys067aQGMVN" +
       "H3hiJVjsd0VyFBqTcJbWp8nQhE2B70Szhm4Eq+W8Px2a7qSUwEPULHe0Plta" +
       "j91WJhIpOJodvyM73WEzswwTt/1y3ZElGQEB/6CoE14VErniKHMCCin5k3pt" +
       "NOcDQxiUV2EGBmLJ9YTWuLtswd1Ut9EiVpszzJoT2QEr++agEa7LLWrudns1" +
       "lsvE/pxdC2J/rYJIJ6s4xWrLhMxObcjhAsHHBNq2QojsDbrjvjnmGZKYjFxy" +
       "KmZO5utdxluW006LLa/7MobCM0Ti/RkhjQSyCvXxEa2O+yJGxNqg1Au9Lttl" +
       "xWmN4shJn6u04FhIu9qg32LwKZaI0zUxXQiDksPRKmPWPGUsrElspbPLRECk" +
       "pggiB3FJJ5xIS3XLUwS6h0e8NqTAGEynWamCTZ0RY0ah5wjtBdttraLGrJXh" +
       "nOhMx2olJL22SXPBZLrCVmvSNTS2PhAWATYs6zTrxRVaK7M1ylnRjChaaoUN" +
       "Ma1uaqP5tO3nzxJQkQ3Gy0XXAcvLqkhGcdEqdtQBIokjxBpGaYfSmSnUHbWK" +
       "+lRFe2zLLhohhlhdSSYiYeknIhViRm0+JAyyo07ZUnmyUqtIWKK8lWuEXsqO" +
       "c1+5NgiY2K1OW5VKFW7Xsr4gpZgt4dG6xgKTWEp4IkRsBG/oxTGPRm7mNOfz" +
       "rDyYzT2MZalUYRWjWi36HWfMxLKvOB2z5HhiU7KNRjJlTAEy4WyI92luLQyN" +
       "RjbhhQbWtMoztmhKXS6ZTsyBj+sDuaeOmU59ZhI9fi0ZXVUMUITiprBaGvpt" +
       "39TcxhT3SxDL9GbKnF/CsVOJGbWhudWZ");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("sMZYlEZjpI0mFpXrkUjx/qDjo3jPVJtoaxkw1SLRZtP6DIPtcRle+iuCJugR" +
       "COl7kt8JNHJRn4yt7rRBDmY2j7K9VBU6VKNdXVA0CAc9Pre5EU2j8FK2QIwV" +
       "S1jYa4zbYBGfOmmj1e35K6vTUh0xRkeiZ4H11ii1GVwcReRqMO6u11N4Vlob" +
       "iMAtu3MLa5Oreb0VFSfZRBYjRFxSw7qTkjahSyHf6ElwfcEtidla7fpkN0SR" +
       "tb2eavNFtd4nHdSCF7HlhcykC9tMPDEYrzKcw+B+PVrhcK9uOiJeA7FK0ODx" +
       "soin1Eh1wKAOHRVx+2itszTxagyTXAnYGpEfxAMfZc1pTJVHLNOwYmLt1T3B" +
       "1DC/7aHF4WAUtatjvNRa+5bRl6qUMm84SaqMO22xqAjYQqd5T8jlE/cjFLZa" +
       "FLdexhmEJmmgjwPM4WdiNxpOOmXeAfOIlHAEHi66Xh8ZoCO6V+wsSE1z8fbM" +
       "nCCZL9V8r9ggrfW01vZTB4AetGZ9E5vxRo1fk0IHrRVxaVBGG8KQM6c1ZuBg" +
       "vq10BYeSJkVR6nY1wSpqxbIksmKnz/mZbw/9IjtsD5dt1+gzIU5U5n200oU9" +
       "xWuv+Pqk3nLU9UwF6y1RSnWdyFqdhps2x5ILzNfSR7m0F1JNq2RmNuJ2Z7IZ" +
       "96KqtV5zepGUV9KiB6N1t4MWmcxDiIj16m2YoJB5c1TvMWK7CONwqR/OQoyJ" +
       "ykMeLJUxZ7ZaHFsx4hbS8WFuMVgqC4pgmmzLsPkaWXWDmGAWxbRt0AumXRW7" +
       "QqMtoWpV4pezhWqMloa8AkGMb87UBmvUehRDoOa8iMAlqSf6mh9PF41OqgYd" +
       "RhHrPWygYVUr5PpjYIvMoDodNYxwTJb63LDWGksdKgtaLZFsjEuI2l4tRUdv" +
       "VbzicK7ma4eoEFRWHFcJvDzH1vysPeyy5EK2zCIiyAk8IyaVjlZBVkOZQFZC" +
       "Rzc76z6Hqb36dGzJ7NocjvG+q5QUOhgu9Bkzwok6cFBWBsE6XhFxjKK1qHU4" +
       "bNyp95sYHCCtBqc2Unu0mAaOLpdiJHBK9qSKsnyZNtpoE+45btHGGho0RVtj" +
       "Uhwo/XjZaYKV1huac38Au46eVBqdBiEmEC2WZUKaaEYoQDM+gZYiR6kVuoY6" +
       "wA91RygrA+2cIhwM01MFxBptTvHc1jJVRAde+J5cWrewHpLqWRdEDGGNyPms" +
       "1dejqDX2HHMheVyIT6zlcuwylme0nSo0QnqUioAhHS2nSgujnTGPdUNzbUhW" +
       "ysLNOO76AruOa+60afJg6Z7q1nIBImqwTstdXtXk1lJC6TXLxvxAnox5Uh67" +
       "aMVNy2Lay3TUVIVyXVmMQ4xLs16JlcEcRX24q9aYJnCy4g5VHuDD6kiygTn1" +
       "+woZ8/3V0BiNkBDYMJeIxEE/JItapSF1GQMZ+3qWMpTWWpTxenfo9Nsjcd4j" +
       "JmmmOGRnVcdG7Vk6xWe4BGeLybI0lSc4THR5fgD00LSHLp50+2tpVrU7WQcF" +
       "LmdRqSbzstb1e8uQUKbRvF0kF3R73igxzLLKW0grmnFqT5+owiwMGKM1F5aI" +
       "PVSxOKsuuzjeRULfnQ6VtLHE1VnXn8XBOmF1y6UTjfA7y2jsxa49xekyWrWC" +
       "tAsCyybf0WfjLEHAmsLWNNwHDpQdNDTcrFQ80szqQ8uyfdIFfl99aq3rdqVG" +
       "tSqrcGipZmkSqAw2ChWjZsQkZJYVOPK5GGuXiYYuScWFRzcoy4Py9RTqpdCE" +
       "WTUMfZBWKScjOZFp4ySE0/pqNQcux7SejHvskh0EwhJbwCRQSA8CEV+8bPSb" +
       "GvDRhKITWFxjCo1hqDFL2mOP40MopFRx3YEjvR4nDViSi3qnWS0v3TrtrlQw" +
       "UlERUaYNbcF1SzMxYhpBZmWzcVGxo4FLLZUehTltiJ+WmjwBwZxXbRD9hDPX" +
       "RQUlS4slkw1MsSfQg3m/JXIuRJUm/RGugrm/yurNoljFK70E8XDSNTOInJRa" +
       "NYnqJklZakCKa6Sk2ysKLp6ZKL90he5YFSHgujZ0nq3X62SdKsaNBmCll7gt" +
       "1xYCMotqtaAy7K7TuRfVir1xKLlcx3Jn2iJckGmT7WZzeYJIssi4s5lUHhaH" +
       "TpwUOTJZYFJQjKwuv0KHvNxK+NayCUf9mFQqUkPRixIP1ZUgYUlOGlQX6GjB" +
       "mZI+YWrlhBhIUcOk0Iyx65VMHuBuKEo0iYDYQtFcNIkgaBGUmU5LY2tCSBiQ" +
       "XUfwWRxDlu3UlFgZrzlYKi/YSMg4r9tMHcim3XKTcIqleOE05UAVPcIemabv" +
       "97niuOtHVmtaXDYzWh/2K6VUSaog8B44YTDzBbE4ioxaxs65oC10xbA5p2Zj" +
       "iYqW9SrEUtUWiBA0EMz35hUd100IWw5sgyy3o7nOl2VaBgjbbBmBJ6NyPBhy" +
       "SNNt15mxV6wGMybxIBzD4KJPa61W65X5a8H/8MxeVz5n8xb2ShL9v+D967bo" +
       "oZw8duV99ebvUuHaeauHcvv29l/rv/y0ZKNOGumupmvbVOX9Jg89bYJVnnDz" +
       "4msl3m+SbT741vc+pQ1/qrS3S7g0o8Itked/i60nun2Izzro6eXXTiyiNvsO" +
       "DhIBP/XWv76ff9X8dc8g1fklx/g83uW/oz786e5L1ffsFS5eSQu8akfE0UZP" +
       "HE0GvDXQozhw+SMpgS++Mmz35KP0MDjC3bCFx9MMDhTj5ByDl20V65R81v9y" +
       "Stnv5OQ3o8Ldhh5tB3qXGLBRygN9/PTTvSE/3PHmwm9cwXhbfjHPEMp2GLPz" +
       "wXhhlxS/08y7D6XT5tqobxr94emNrkpsQTkOOG26nyvOpoM/zsnvAQ3Nt0Fs" +
       "+j0xqyDxTO1AXL9/BnFtVOKF4HjLTlxvOX+V+JtTyv4uJ38BABv7gPMLf3QA" +
       "7i/PCu4l4HjnDtw7zwfc3tawbbU2KDx2bauxyRLfZhc+9W8f+eybnnrkTzeJ" +
       "1jeboSAHrcA4Yd/QoTZf+vAXvvi5O178kc3GhBsUOdxO6+Mbrq7eT3Vkm9QG" +
       "w+1+elR3N8kx2yzkE/X1CX8/6egbJwto78qac2W5uWTrrrHdobPJevna7qaH" +
       "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");
}
