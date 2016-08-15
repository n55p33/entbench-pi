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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "BR25xGQ2uKOS59nB7PUo+4rfPvo/JYWUUZNdAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "oIrtaG61qWp90osaIF4FEoiVxtyvrLooytSqHixmZq2arWKIWg2W5IIhy7Wh" +
       "zCwsdCCvm0KPx1i2k7aqsGeIlNLyGKoMV8uaxmhVnmpNsobeqs8aUFEK5CBZ" +
       "BnWoCFbnRn0ZxG6rByNyZT2gzQWs1DGJD4VE1jTPnigyJ7eoRSWrMY1EJKL6" +
       "ZMGUszUUednC5DVenQ45ZipPlIGA2SKrutOqI/eWtC+UJkpPHCy8Ia14YSrI" +
       "YcD2BUypKDxORtkC58eViRBY+Bp1lOkAX0jUomuW8X6jWeZ9GBFGlElh5MS2" +
       "waH1FqnumLglUYwKO5NZPUx0eJG0XYLWRX5q17Kh4g/KnAzXlxMn6ka6yxmL" +
       "8cQh5EogNDOZiDgPrSgROlENeyL1J+Mx3StXq5Q+q/LIyrU7q7HWLxtZv9Zy" +
       "A5wOuIgzYSx17WolE+wSDaOkqftY243WpbSvNuUoao+XylQYiAqrk868lcik" +
       "226FVNvT631ZoLts1FnrGTdaZP2FIcGUUAkzoY2Sujh1+IHhCkKnXkdCo2qR" +
       "RqRoUbm0hvzOuKtpdLq067gfWqM15Qk0Qc/RJZZMfZtsQraNr4CM25hUUQUO" +
       "Hpc0PknqI0lpaKrteLNYq7htp2qDMTS1nj0bWTWMXofJOCSCVdGft5uz1rJo" +
       "cX6v0R62AqSOYsmKMdBwXMfngt/saKEmsE46abErm6pRMjvN6OW6gy2JmioM" +
       "TWQsp8s52mhjGmk4hOHUZ5VowiOthC2uy/O5YbSndqnG4USkO/1ucVL0x3pE" +
       "zZHErLmoOKCnC85AzQlvRPaU09pkaTVowcN4hrVkXdfKdjGw6wuTMzLexssB" +
       "1vJKXZ+S0ZIY2zyJiF1DpmqS23AEx11j1amNTnvUYjWQXD6bFaGADdZwyDCm" +
       "uijqNdR1J60JzEm0ZzWKJa1YJEuRa7s+iUiRLM2XLQvuq5Y0GCbmYBySfdec" +
       "rtUxRyk9nOfXNShykpk4nKkm269bfn9iySUIxaalES91MVbgld5wLPL4Ymly" +
       "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" +
       "+m3f1NzmFPfLEMv0ZsqcX5ZipxozalNz");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "JS7i2kJAZlG9HlSH3XU696J6sTcOJZfrWO5MW4QLMm2x3WwuT2BJFhl3NpMq" +
       "w+LQiZMiRyYLTAqKkdXlV+iQl5GER5atUtSPSaUqNRW9KPFQQwkSluSkQW2B" +
       "jhacKekTpl5JiIEUNU0KzRi7Uc3kAe6GokSTMIgtFM1FkwiCFkGF6SAaWxdC" +
       "woDsBozP4hiybKeuxMp4zZWkyoKNhIzzuq3UgWzarbQIp1iOF05LDlTRI+yR" +
       "afp+nyuOu35kIdPispXR+rBfLadKUgOB98AJg5kviMVRZNQzds4FbaErhq05" +
       "NRtLVLRs1CCWqiEgQtBAMN+bV3VcNyFsObANstKO5jpfkWkZIGyzFRBrjCrx" +
       "YMjBLbfdYMZesRbMmMSD+tPJeCzRGoIgr85fC/7HZ/a68rmbt7BXkuj/Fe9f" +
       "t0UP5uRlV95Xb/4uFa6dt3oot29v/7X+K09LNuqkke5qurZNVd5v8uDTJljl" +
       "CTcvuVbi/SbZ5sNve/8T2vCny3u7hEszKtwSef632Hqi24f4bICeXnntxCJq" +
       "s+/gIBHwU2/7m/v418zf8AxSnV96jM/jXf576slPd1+uvm+vcPFKWuBVOyKO" +
       "NnrsaDLgrYEexYHLH0kJfMmVYbs7H6WHwBHuhi08nmZwoBgn5xi8YqtYp+Sz" +
       "/tdTyn43J78VFe4y9Gg70LvEgI1SHujjp5/uDfnhjjcXfvMKxufkF/MMoWyH" +
       "MTsfjBd2SfE7zbzrUDptro36ptEfnd7oqsQWlOOA06b7ueJsOviTnPw+0NB8" +
       "G8Sm3xOzChLP1A7E9QdnENdGJV4EjrfuxPXW81eJvz2l7O9z8pcAsLEPOL/w" +
       "xwfg/uqs4F4KjnfvwL37fMDtbQ3bVmuDwsuubTU2WeLb7MIn/t3Dn/3uJx7+" +
       "s02i9c1mKMgBEhgn7Bs61OZLT37hi5+7/SUf3WxMuEGRw+20Pr7h6ur9VEe2" +
       "SW0w3OanR3V3kxyzzUI+UV8f8/eTjr5xsoD2rqw5V5abS7buGtsdOpusl6/t" +
       "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" +
       "g/lkU/v3pwD/Uk7+Gqwomgl8oRPWzL85qwYDU3SpsoNZOX8N/udTyr6ek3+I" +
       "Cje4ehodU9mvnBUXWD4udXe4uueO6+KlU8puzsmFqHBXjoswXC/QT7I+F/fO" +
       "6sq+EmB7fIfx8fOelluX/eLdpwB9fk5ujwrPCfT8yeAmZyWvd+C7XrzjrBgf" +
       "A9hmO4yz856G2zz1r23AnJJbdjHPLbv4wlOBniWpbAO0CgA6O6DOuQ7m5v/9" +
       "XPdjycHM1iM/lF5z8ZTMs4uXc/KyUwVxlpSzB/KLDSCAd+wE8Y5nSaubp2D8" +
       "1pxUo8I9W7/oKiHlxcUDvLXzwPv9O7zf/2xqOHYKaDwnr71u0K87a9pJDYD9" +
       "0R3oH32moK8vt+oic22pHLyIu5hnk10cXF8ofpE8h30Dlz68w/3hZwn3d1wX" +
       "7tfnZHLt93IXxXPIP7n05A7rk88S1vl1YbVyol6Vf7I88iD1onYOuRaXPrYD" +
       "/LFnCXB0XYCTnHgn5losjziQF/1zSCq49Ikd6E88S6Dfcl2g35aTNx5PKlge" +
       "eX548bvOqtW5Y/mpHd5PPUt4v/+68L4nJ+8E8e3BO579pf7qjKqT3lNefNcz" +
       "EUYK4q/tnqr8hwruveoXg7a/cqN+9Ik7b77nifH/3O4o2f8lmlvIws2z2LYP" +
       "f6/8ofNLfqDPzI1wbtnQOza7Li7+0C4n6BpvYPPfgriyne/iB7dtPhQVnn9S" +
       "m6hwEdDDNX8c+OjHa4JIcvN5uN5PABkf1AM33Z4crvJToHdQJT/98EYXvp5u" +
       "/a57D6tSLvTC3U8n9CtNDv9GRr7xZ/NbTvtb++Ltrzk9rj71RJ9+45frP739" +
       "jQ6wcmVZ3svNZOGm7c+FbDrNtwc+eM3e9vu61Hv0a3f8wi0v29/KeMeW4QO1" +
       "PsTbS0/+EYyO40ebn63IfvWeX/q2n3ni85svxP3/jNz5R2RrAAA=");
}
