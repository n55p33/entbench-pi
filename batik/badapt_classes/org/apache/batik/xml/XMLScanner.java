package org.apache.batik.xml;
public class XMLScanner implements org.apache.batik.i18n.Localizable {
    public static final int DOCUMENT_START_CONTEXT = 0;
    public static final int TOP_LEVEL_CONTEXT = 1;
    public static final int PI_CONTEXT = 2;
    public static final int XML_DECL_CONTEXT = 3;
    public static final int DOCTYPE_CONTEXT = 4;
    public static final int START_TAG_CONTEXT = 5;
    public static final int CONTENT_CONTEXT = 6;
    public static final int DTD_DECLARATIONS_CONTEXT = 7;
    public static final int CDATA_SECTION_CONTEXT = 8;
    public static final int END_TAG_CONTEXT = 9;
    public static final int ATTRIBUTE_VALUE_CONTEXT = 10;
    public static final int ATTLIST_CONTEXT = 11;
    public static final int ELEMENT_DECLARATION_CONTEXT = 12;
    public static final int ENTITY_CONTEXT = 13;
    public static final int NOTATION_CONTEXT = 14;
    public static final int NOTATION_TYPE_CONTEXT = 15;
    public static final int ENUMERATION_CONTEXT = 16;
    public static final int ENTITY_VALUE_CONTEXT = 17;
    protected static final java.lang.String BUNDLE_CLASSNAME = "org.apache.batik.xml.resources.Messages";
    protected org.apache.batik.i18n.LocalizableSupport localizableSupport =
      new org.apache.batik.i18n.LocalizableSupport(
      BUNDLE_CLASSNAME,
      org.apache.batik.xml.XMLScanner.class.
        getClassLoader(
          ));
    protected org.apache.batik.util.io.NormalizingReader reader;
    protected int current;
    protected int type;
    protected char[] buffer = new char[1024];
    protected int position;
    protected int start;
    protected int end;
    protected int context;
    protected int depth;
    protected boolean piEndRead;
    protected boolean inDTD;
    protected char attrDelimiter;
    protected boolean cdataEndRead;
    public XMLScanner(java.io.Reader r) throws org.apache.batik.xml.XMLException {
        super(
          );
        context =
          DOCUMENT_START_CONTEXT;
        try {
            reader =
              new org.apache.batik.util.io.StreamNormalizingReader(
                r);
            current =
              nextChar(
                );
        }
        catch (java.io.IOException e) {
            throw new org.apache.batik.xml.XMLException(
              e);
        }
    }
    public XMLScanner(java.io.InputStream is, java.lang.String enc)
          throws org.apache.batik.xml.XMLException { super();
                                                     context = DOCUMENT_START_CONTEXT;
                                                     try { reader =
                                                             new org.apache.batik.util.io.StreamNormalizingReader(
                                                               is,
                                                               enc);
                                                           current =
                                                             nextChar(
                                                               );
                                                     }
                                                     catch (java.io.IOException e) {
                                                         throw new org.apache.batik.xml.XMLException(
                                                           e);
                                                     }
    }
    public XMLScanner(java.lang.String s)
          throws org.apache.batik.xml.XMLException {
        super(
          );
        context =
          DOCUMENT_START_CONTEXT;
        try {
            reader =
              new org.apache.batik.util.io.StringNormalizingReader(
                s);
            current =
              nextChar(
                );
        }
        catch (java.io.IOException e) {
            throw new org.apache.batik.xml.XMLException(
              e);
        }
    }
    public void setLocale(java.util.Locale l) {
        localizableSupport.
          setLocale(
            l);
    }
    public java.util.Locale getLocale() {
        return localizableSupport.
          getLocale(
            );
    }
    public java.lang.String formatMessage(java.lang.String key,
                                          java.lang.Object[] args)
          throws java.util.MissingResourceException {
        return localizableSupport.
          formatMessage(
            key,
            args);
    }
    public void setDepth(int i) { depth =
                                    i; }
    public int getDepth() { return depth;
    }
    public void setContext(int c) { context =
                                      c; }
    public int getContext() { return context;
    }
    public int getType() { return type; }
    public int getLine() { return reader.
                             getLine(
                               ); }
    public int getColumn() { return reader.
                               getColumn(
                                 ); }
    public char[] getBuffer() { return buffer;
    }
    public int getStart() { return start;
    }
    public int getEnd() { return end; }
    public char getStringDelimiter() { return attrDelimiter;
    }
    public int getStartOffset() { switch (type) {
                                      case org.apache.batik.xml.LexicalUnits.
                                             SECTION_END:
                                          return -3;
                                      case org.apache.batik.xml.LexicalUnits.
                                             PI_END:
                                          return -2;
                                      case org.apache.batik.xml.LexicalUnits.
                                             STRING:
                                      case org.apache.batik.xml.LexicalUnits.
                                             ENTITY_REFERENCE:
                                      case org.apache.batik.xml.LexicalUnits.
                                             PARAMETER_ENTITY_REFERENCE:
                                      case org.apache.batik.xml.LexicalUnits.
                                             START_TAG:
                                      case org.apache.batik.xml.LexicalUnits.
                                             FIRST_ATTRIBUTE_FRAGMENT:
                                          return 1;
                                      case org.apache.batik.xml.LexicalUnits.
                                             PI_START:
                                      case org.apache.batik.xml.LexicalUnits.
                                             END_TAG:
                                      case org.apache.batik.xml.LexicalUnits.
                                             CHARACTER_REFERENCE:
                                          return 2;
                                      case org.apache.batik.xml.LexicalUnits.
                                             COMMENT:
                                          return 4;
                                      default:
                                          return 0;
                                  } }
    public int getEndOffset() { switch (type) {
                                    case org.apache.batik.xml.LexicalUnits.
                                           STRING:
                                    case org.apache.batik.xml.LexicalUnits.
                                           ENTITY_REFERENCE:
                                    case org.apache.batik.xml.LexicalUnits.
                                           CHARACTER_REFERENCE:
                                    case org.apache.batik.xml.LexicalUnits.
                                           PARAMETER_ENTITY_REFERENCE:
                                    case org.apache.batik.xml.LexicalUnits.
                                           LAST_ATTRIBUTE_FRAGMENT:
                                        return -1;
                                    case org.apache.batik.xml.LexicalUnits.
                                           PI_DATA:
                                        return -2;
                                    case org.apache.batik.xml.LexicalUnits.
                                           COMMENT:
                                        return -3;
                                    case org.apache.batik.xml.LexicalUnits.
                                           CHARACTER_DATA:
                                        if (cdataEndRead) {
                                            return -3;
                                        }
                                        return 0;
                                    default:
                                        return 0;
                                } }
    public void clearBuffer() { if (position <=
                                      0) {
                                    position =
                                      0;
                                }
                                else {
                                    buffer[0] =
                                      buffer[position -
                                               1];
                                    position =
                                      1;
                                } }
    public int next() throws org.apache.batik.xml.XMLException {
        return next(
                 context);
    }
    public int next(int ctx) throws org.apache.batik.xml.XMLException {
        start =
          position -
            1;
        try {
            switch (ctx) {
                case DOCUMENT_START_CONTEXT:
                    type =
                      nextInDocumentStart(
                        );
                    break;
                case TOP_LEVEL_CONTEXT:
                    type =
                      nextInTopLevel(
                        );
                    break;
                case PI_CONTEXT:
                    type =
                      nextInPI(
                        );
                    break;
                case START_TAG_CONTEXT:
                    type =
                      nextInStartTag(
                        );
                    break;
                case ATTRIBUTE_VALUE_CONTEXT:
                    type =
                      nextInAttributeValue(
                        );
                    break;
                case CONTENT_CONTEXT:
                    type =
                      nextInContent(
                        );
                    break;
                case END_TAG_CONTEXT:
                    type =
                      nextInEndTag(
                        );
                    break;
                case CDATA_SECTION_CONTEXT:
                    type =
                      nextInCDATASection(
                        );
                    break;
                case XML_DECL_CONTEXT:
                    type =
                      nextInXMLDecl(
                        );
                    break;
                case DOCTYPE_CONTEXT:
                    type =
                      nextInDoctype(
                        );
                    break;
                case DTD_DECLARATIONS_CONTEXT:
                    type =
                      nextInDTDDeclarations(
                        );
                    break;
                case ELEMENT_DECLARATION_CONTEXT:
                    type =
                      nextInElementDeclaration(
                        );
                    break;
                case ATTLIST_CONTEXT:
                    type =
                      nextInAttList(
                        );
                    break;
                case NOTATION_CONTEXT:
                    type =
                      nextInNotation(
                        );
                    break;
                case ENTITY_CONTEXT:
                    type =
                      nextInEntity(
                        );
                    break;
                case ENTITY_VALUE_CONTEXT:
                    return nextInEntityValue(
                             );
                case NOTATION_TYPE_CONTEXT:
                    return nextInNotationType(
                             );
                case ENUMERATION_CONTEXT:
                    return nextInEnumeration(
                             );
                default:
                    throw new java.lang.IllegalArgumentException(
                      "unexpected ctx:" +
                      ctx);
            }
        }
        catch (java.io.IOException e) {
            throw new org.apache.batik.xml.XMLException(
              e);
        }
        end =
          position -
            (current ==
               -1
               ? 0
               : 1);
        return type;
    }
    protected int nextInDocumentStart() throws java.io.IOException,
        org.apache.batik.xml.XMLException {
        switch (current) {
            case 9:
            case 10:
            case 13:
            case 32:
                do  {
                    nextChar(
                      );
                }while(current !=
                         -1 &&
                         org.apache.batik.xml.XMLUtilities.
                         isXMLSpace(
                           (char)
                             current)); 
                context =
                  depth ==
                    0
                    ? TOP_LEVEL_CONTEXT
                    : CONTENT_CONTEXT;
                return org.apache.batik.xml.LexicalUnits.
                         S;
            case '<':
                switch (nextChar(
                          )) {
                    case '?':
                        int c1 =
                          nextChar(
                            );
                        if (c1 ==
                              -1 ||
                              !org.apache.batik.xml.XMLUtilities.
                              isXMLNameFirstCharacter(
                                (char)
                                  c1)) {
                            throw createXMLException(
                                    "invalid.pi.target");
                        }
                        context =
                          PI_CONTEXT;
                        int c2 =
                          nextChar(
                            );
                        if (c2 ==
                              -1 ||
                              !org.apache.batik.xml.XMLUtilities.
                              isXMLNameCharacter(
                                (char)
                                  c2)) {
                            return org.apache.batik.xml.LexicalUnits.
                                     PI_START;
                        }
                        int c3 =
                          nextChar(
                            );
                        if (c3 ==
                              -1 ||
                              !org.apache.batik.xml.XMLUtilities.
                              isXMLNameCharacter(
                                (char)
                                  c3)) {
                            return org.apache.batik.xml.LexicalUnits.
                                     PI_START;
                        }
                        int c4 =
                          nextChar(
                            );
                        if (c4 !=
                              -1 &&
                              org.apache.batik.xml.XMLUtilities.
                              isXMLNameCharacter(
                                (char)
                                  c4)) {
                            do  {
                                nextChar(
                                  );
                            }while(current !=
                                     -1 &&
                                     org.apache.batik.xml.XMLUtilities.
                                     isXMLNameCharacter(
                                       (char)
                                         current)); 
                            return org.apache.batik.xml.LexicalUnits.
                                     PI_START;
                        }
                        if (c1 ==
                              'x' &&
                              c2 ==
                              'm' &&
                              c3 ==
                              'l') {
                            context =
                              XML_DECL_CONTEXT;
                            return org.apache.batik.xml.LexicalUnits.
                                     XML_DECL_START;
                        }
                        if ((c1 ==
                               'x' ||
                               c1 ==
                               'X') &&
                              (c2 ==
                                 'm' ||
                                 c2 ==
                                 'M') &&
                              (c3 ==
                                 'l' ||
                                 c3 ==
                                 'L')) {
                            throw createXMLException(
                                    "xml.reserved");
                        }
                        return org.apache.batik.xml.LexicalUnits.
                                 PI_START;
                    case '!':
                        switch (nextChar(
                                  )) {
                            case '-':
                                return readComment(
                                         );
                            case 'D':
                                context =
                                  DOCTYPE_CONTEXT;
                                return readIdentifier(
                                         "OCTYPE",
                                         org.apache.batik.xml.LexicalUnits.
                                           DOCTYPE_START,
                                         -1);
                            default:
                                throw createXMLException(
                                        "invalid.doctype");
                        }
                    default:
                        context =
                          START_TAG_CONTEXT;
                        depth++;
                        return readName(
                                 org.apache.batik.xml.LexicalUnits.
                                   START_TAG);
                }
            case -1:
                return org.apache.batik.xml.LexicalUnits.
                         EOF;
            default:
                if (depth ==
                      0) {
                    throw createXMLException(
                            "invalid.character");
                }
                else {
                    return nextInContent(
                             );
                }
        }
    }
    protected int nextInTopLevel() throws java.io.IOException,
        org.apache.batik.xml.XMLException {
        switch (current) {
            case 9:
            case 10:
            case 13:
            case 32:
                do  {
                    nextChar(
                      );
                }while(current !=
                         -1 &&
                         org.apache.batik.xml.XMLUtilities.
                         isXMLSpace(
                           (char)
                             current)); 
                return org.apache.batik.xml.LexicalUnits.
                         S;
            case '<':
                switch (nextChar(
                          )) {
                    case '?':
                        context =
                          PI_CONTEXT;
                        return readPIStart(
                                 );
                    case '!':
                        switch (nextChar(
                                  )) {
                            case '-':
                                return readComment(
                                         );
                            case 'D':
                                context =
                                  DOCTYPE_CONTEXT;
                                return readIdentifier(
                                         "OCTYPE",
                                         org.apache.batik.xml.LexicalUnits.
                                           DOCTYPE_START,
                                         -1);
                            default:
                                throw createXMLException(
                                        "invalid.character");
                        }
                    default:
                        context =
                          START_TAG_CONTEXT;
                        depth++;
                        return readName(
                                 org.apache.batik.xml.LexicalUnits.
                                   START_TAG);
                }
            case -1:
                return org.apache.batik.xml.LexicalUnits.
                         EOF;
            default:
                throw createXMLException(
                        "invalid.character");
        }
    }
    protected int nextInPI() throws java.io.IOException,
        org.apache.batik.xml.XMLException {
        if (piEndRead) {
            piEndRead =
              false;
            context =
              depth ==
                0
                ? TOP_LEVEL_CONTEXT
                : CONTENT_CONTEXT;
            return org.apache.batik.xml.LexicalUnits.
                     PI_END;
        }
        switch (current) {
            case 9:
            case 10:
            case 13:
            case 32:
                do  {
                    nextChar(
                      );
                }while(current !=
                         -1 &&
                         org.apache.batik.xml.XMLUtilities.
                         isXMLSpace(
                           (char)
                             current)); 
                return org.apache.batik.xml.LexicalUnits.
                         S;
            case '?':
                if (nextChar(
                      ) !=
                      '>') {
                    throw createXMLException(
                            "pi.end.expected");
                }
                nextChar(
                  );
                if (inDTD) {
                    context =
                      DTD_DECLARATIONS_CONTEXT;
                }
                else
                    if (depth ==
                          0) {
                        context =
                          TOP_LEVEL_CONTEXT;
                    }
                    else {
                        context =
                          CONTENT_CONTEXT;
                    }
                return org.apache.batik.xml.LexicalUnits.
                         PI_END;
            default:
                do  {
                    do  {
                        nextChar(
                          );
                    }while(current !=
                             -1 &&
                             current !=
                             '?'); 
                    nextChar(
                      );
                }while(current !=
                         -1 &&
                         current !=
                         '>'); 
                nextChar(
                  );
                piEndRead =
                  true;
                return org.apache.batik.xml.LexicalUnits.
                         PI_DATA;
        }
    }
    protected int nextInStartTag() throws java.io.IOException,
        org.apache.batik.xml.XMLException {
        switch (current) {
            case 9:
            case 10:
            case 13:
            case 32:
                do  {
                    nextChar(
                      );
                }while(current !=
                         -1 &&
                         org.apache.batik.xml.XMLUtilities.
                         isXMLSpace(
                           (char)
                             current)); 
                return org.apache.batik.xml.LexicalUnits.
                         S;
            case '/':
                if (nextChar(
                      ) !=
                      '>') {
                    throw createXMLException(
                            "malformed.tag.end");
                }
                nextChar(
                  );
                context =
                  --depth ==
                    0
                    ? TOP_LEVEL_CONTEXT
                    : CONTENT_CONTEXT;
                return org.apache.batik.xml.LexicalUnits.
                         EMPTY_ELEMENT_END;
            case '>':
                nextChar(
                  );
                context =
                  CONTENT_CONTEXT;
                return org.apache.batik.xml.LexicalUnits.
                         END_CHAR;
            case '=':
                nextChar(
                  );
                return org.apache.batik.xml.LexicalUnits.
                         EQ;
            case '\"':
                attrDelimiter =
                  '\"';
                nextChar(
                  );
                for (;
                     ;
                     ) {
                    switch (current) {
                        case '\"':
                            nextChar(
                              );
                            return org.apache.batik.xml.LexicalUnits.
                                     STRING;
                        case '&':
                            context =
                              ATTRIBUTE_VALUE_CONTEXT;
                            return org.apache.batik.xml.LexicalUnits.
                                     FIRST_ATTRIBUTE_FRAGMENT;
                        case '<':
                            throw createXMLException(
                                    "invalid.character");
                        case -1:
                            throw createXMLException(
                                    "unexpected.eof");
                    }
                    nextChar(
                      );
                }
            case '\'':
                attrDelimiter =
                  '\'';
                nextChar(
                  );
                for (;
                     ;
                     ) {
                    switch (current) {
                        case '\'':
                            nextChar(
                              );
                            return org.apache.batik.xml.LexicalUnits.
                                     STRING;
                        case '&':
                            context =
                              ATTRIBUTE_VALUE_CONTEXT;
                            return org.apache.batik.xml.LexicalUnits.
                                     FIRST_ATTRIBUTE_FRAGMENT;
                        case '<':
                            throw createXMLException(
                                    "invalid.character");
                        case -1:
                            throw createXMLException(
                                    "unexpected.eof");
                    }
                    nextChar(
                      );
                }
            default:
                return readName(
                         org.apache.batik.xml.LexicalUnits.
                           NAME);
        }
    }
    protected int nextInAttributeValue() throws java.io.IOException,
        org.apache.batik.xml.XMLException {
        if (current ==
              -1) {
            return org.apache.batik.xml.LexicalUnits.
                     EOF;
        }
        if (current ==
              '&') {
            return readReference(
                     );
        }
        else {
            loop: for (;
                       ;
                       ) {
                switch (current) {
                    case '&':
                    case '<':
                    case -1:
                        break loop;
                    case '\"':
                    case '\'':
                        if (current ==
                              attrDelimiter) {
                            break loop;
                        }
                }
                nextChar(
                  );
            }
            switch (current) {
                case -1:
                    break;
                case '<':
                    throw createXMLException(
                            "invalid.character");
                case '&':
                    return org.apache.batik.xml.LexicalUnits.
                             ATTRIBUTE_FRAGMENT;
                case '\'':
                case '\"':
                    nextChar(
                      );
                    if (inDTD) {
                        context =
                          ATTLIST_CONTEXT;
                    }
                    else {
                        context =
                          START_TAG_CONTEXT;
                    }
            }
            return org.apache.batik.xml.LexicalUnits.
                     LAST_ATTRIBUTE_FRAGMENT;
        }
    }
    protected int nextInContent() throws java.io.IOException,
        org.apache.batik.xml.XMLException {
        switch (current) {
            case -1:
                return org.apache.batik.xml.LexicalUnits.
                         EOF;
            case '&':
                return readReference(
                         );
            case '<':
                switch (nextChar(
                          )) {
                    case '?':
                        context =
                          PI_CONTEXT;
                        return readPIStart(
                                 );
                    case '!':
                        switch (nextChar(
                                  )) {
                            case '-':
                                return readComment(
                                         );
                            case '[':
                                context =
                                  CDATA_SECTION_CONTEXT;
                                return readIdentifier(
                                         "CDATA[",
                                         org.apache.batik.xml.LexicalUnits.
                                           CDATA_START,
                                         -1);
                            default:
                                throw createXMLException(
                                        "invalid.character");
                        }
                    case '/':
                        nextChar(
                          );
                        context =
                          END_TAG_CONTEXT;
                        return readName(
                                 org.apache.batik.xml.LexicalUnits.
                                   END_TAG);
                    default:
                        depth++;
                        context =
                          START_TAG_CONTEXT;
                        return readName(
                                 org.apache.batik.xml.LexicalUnits.
                                   START_TAG);
                }
            default:
                loop: for (;
                           ;
                           ) {
                    switch (current) {
                        default:
                            nextChar(
                              );
                            break;
                        case -1:
                        case '&':
                        case '<':
                            break loop;
                    }
                }
                return org.apache.batik.xml.LexicalUnits.
                         CHARACTER_DATA;
        }
    }
    protected int nextInEndTag() throws java.io.IOException,
        org.apache.batik.xml.XMLException {
        switch (current) {
            case 9:
            case 10:
            case 13:
            case 32:
                do  {
                    nextChar(
                      );
                }while(current !=
                         -1 &&
                         org.apache.batik.xml.XMLUtilities.
                         isXMLSpace(
                           (char)
                             current)); 
                return org.apache.batik.xml.LexicalUnits.
                         S;
            case '>':
                if (--depth <
                      0) {
                    throw createXMLException(
                            "unexpected.end.tag");
                }
                else
                    if (depth ==
                          0) {
                        context =
                          TOP_LEVEL_CONTEXT;
                    }
                    else {
                        context =
                          CONTENT_CONTEXT;
                    }
                nextChar(
                  );
                return org.apache.batik.xml.LexicalUnits.
                         END_CHAR;
            default:
                throw createXMLException(
                        "invalid.character");
        }
    }
    protected int nextInCDATASection() throws java.io.IOException,
        org.apache.batik.xml.XMLException {
        if (cdataEndRead) {
            cdataEndRead =
              false;
            context =
              CONTENT_CONTEXT;
            return org.apache.batik.xml.LexicalUnits.
                     SECTION_END;
        }
        while (current !=
                 -1) {
            while (current !=
                     ']' &&
                     current !=
                     -1) {
                nextChar(
                  );
            }
            if (current !=
                  -1) {
                nextChar(
                  );
                if (current ==
                      ']') {
                    nextChar(
                      );
                    if (current ==
                          '>') {
                        break;
                    }
                }
            }
        }
        if (current ==
              -1) {
            throw createXMLException(
                    "unexpected.eof");
        }
        nextChar(
          );
        cdataEndRead =
          true;
        return org.apache.batik.xml.LexicalUnits.
                 CHARACTER_DATA;
    }
    protected int nextInXMLDecl() throws java.io.IOException,
        org.apache.batik.xml.XMLException {
        switch (current) {
            case 9:
            case 10:
            case 13:
            case 32:
                do  {
                    nextChar(
                      );
                }while(current !=
                         -1 &&
                         org.apache.batik.xml.XMLUtilities.
                         isXMLSpace(
                           (char)
                             current)); 
                return org.apache.batik.xml.LexicalUnits.
                         S;
            case 'v':
                return readIdentifier(
                         "ersion",
                         org.apache.batik.xml.LexicalUnits.
                           VERSION_IDENTIFIER,
                         -1);
            case 'e':
                return readIdentifier(
                         "ncoding",
                         org.apache.batik.xml.LexicalUnits.
                           ENCODING_IDENTIFIER,
                         -1);
            case 's':
                return readIdentifier(
                         "tandalone",
                         org.apache.batik.xml.LexicalUnits.
                           STANDALONE_IDENTIFIER,
                         -1);
            case '=':
                nextChar(
                  );
                return org.apache.batik.xml.LexicalUnits.
                         EQ;
            case '?':
                nextChar(
                  );
                if (current !=
                      '>') {
                    throw createXMLException(
                            "pi.end.expected");
                }
                nextChar(
                  );
                context =
                  TOP_LEVEL_CONTEXT;
                return org.apache.batik.xml.LexicalUnits.
                         PI_END;
            case '\"':
                attrDelimiter =
                  '\"';
                return readString(
                         );
            case '\'':
                attrDelimiter =
                  '\'';
                return readString(
                         );
            default:
                throw createXMLException(
                        "invalid.character");
        }
    }
    protected int nextInDoctype() throws java.io.IOException,
        org.apache.batik.xml.XMLException {
        switch (current) {
            case 9:
            case 10:
            case 13:
            case 32:
                do  {
                    nextChar(
                      );
                }while(current !=
                         -1 &&
                         org.apache.batik.xml.XMLUtilities.
                         isXMLSpace(
                           (char)
                             current)); 
                return org.apache.batik.xml.LexicalUnits.
                         S;
            case '>':
                nextChar(
                  );
                context =
                  TOP_LEVEL_CONTEXT;
                return org.apache.batik.xml.LexicalUnits.
                         END_CHAR;
            case 'S':
                return readIdentifier(
                         "YSTEM",
                         org.apache.batik.xml.LexicalUnits.
                           SYSTEM_IDENTIFIER,
                         org.apache.batik.xml.LexicalUnits.
                           NAME);
            case 'P':
                return readIdentifier(
                         "UBLIC",
                         org.apache.batik.xml.LexicalUnits.
                           PUBLIC_IDENTIFIER,
                         org.apache.batik.xml.LexicalUnits.
                           NAME);
            case '\"':
                attrDelimiter =
                  '\"';
                return readString(
                         );
            case '\'':
                attrDelimiter =
                  '\'';
                return readString(
                         );
            case '[':
                nextChar(
                  );
                context =
                  DTD_DECLARATIONS_CONTEXT;
                inDTD =
                  true;
                return org.apache.batik.xml.LexicalUnits.
                         LSQUARE_BRACKET;
            default:
                return readName(
                         org.apache.batik.xml.LexicalUnits.
                           NAME);
        }
    }
    protected int nextInDTDDeclarations()
          throws java.io.IOException,
        org.apache.batik.xml.XMLException {
        switch (current) {
            case 9:
            case 10:
            case 13:
            case 32:
                do  {
                    nextChar(
                      );
                }while(current !=
                         -1 &&
                         org.apache.batik.xml.XMLUtilities.
                         isXMLSpace(
                           (char)
                             current)); 
                return org.apache.batik.xml.LexicalUnits.
                         S;
            case ']':
                nextChar(
                  );
                context =
                  DOCTYPE_CONTEXT;
                inDTD =
                  false;
                return org.apache.batik.xml.LexicalUnits.
                         RSQUARE_BRACKET;
            case '%':
                return readPEReference(
                         );
            case '<':
                switch (nextChar(
                          )) {
                    case '?':
                        context =
                          PI_CONTEXT;
                        return readPIStart(
                                 );
                    case '!':
                        switch (nextChar(
                                  )) {
                            case '-':
                                return readComment(
                                         );
                            case 'E':
                                switch (nextChar(
                                          )) {
                                    case 'L':
                                        context =
                                          ELEMENT_DECLARATION_CONTEXT;
                                        return readIdentifier(
                                                 "EMENT",
                                                 org.apache.batik.xml.LexicalUnits.
                                                   ELEMENT_DECLARATION_START,
                                                 -1);
                                    case 'N':
                                        context =
                                          ENTITY_CONTEXT;
                                        return readIdentifier(
                                                 "TITY",
                                                 org.apache.batik.xml.LexicalUnits.
                                                   ENTITY_START,
                                                 -1);
                                    default:
                                        throw createXMLException(
                                                "invalid.character");
                                }
                            case 'A':
                                context =
                                  ATTLIST_CONTEXT;
                                return readIdentifier(
                                         "TTLIST",
                                         org.apache.batik.xml.LexicalUnits.
                                           ATTLIST_START,
                                         -1);
                            case 'N':
                                context =
                                  NOTATION_CONTEXT;
                                return readIdentifier(
                                         "OTATION",
                                         org.apache.batik.xml.LexicalUnits.
                                           NOTATION_START,
                                         -1);
                            default:
                                throw createXMLException(
                                        "invalid.character");
                        }
                    default:
                        throw createXMLException(
                                "invalid.character");
                }
            default:
                throw createXMLException(
                        "invalid.character");
        }
    }
    protected int readString() throws java.io.IOException,
        org.apache.batik.xml.XMLException {
        do  {
            nextChar(
              );
        }while(current !=
                 -1 &&
                 current !=
                 attrDelimiter); 
        if (current ==
              -1) {
            throw createXMLException(
                    "unexpected.eof");
        }
        nextChar(
          );
        return org.apache.batik.xml.LexicalUnits.
                 STRING;
    }
    protected int readComment() throws java.io.IOException,
        org.apache.batik.xml.XMLException {
        if (nextChar(
              ) !=
              '-') {
            throw createXMLException(
                    "malformed.comment");
        }
        int c =
          nextChar(
            );
        while (c !=
                 -1) {
            while (c !=
                     -1 &&
                     c !=
                     '-') {
                c =
                  nextChar(
                    );
            }
            c =
              nextChar(
                );
            if (c ==
                  '-') {
                break;
            }
        }
        if (c ==
              -1) {
            throw createXMLException(
                    "unexpected.eof");
        }
        c =
          nextChar(
            );
        if (c !=
              '>') {
            throw createXMLException(
                    "malformed.comment");
        }
        nextChar(
          );
        return org.apache.batik.xml.LexicalUnits.
                 COMMENT;
    }
    protected int readIdentifier(java.lang.String s,
                                 int type,
                                 int ntype)
          throws java.io.IOException,
        org.apache.batik.xml.XMLException {
        int len =
          s.
          length(
            );
        for (int i =
               0;
             i <
               len;
             i++) {
            nextChar(
              );
            if (current !=
                  s.
                  charAt(
                    i)) {
                if (ntype ==
                      -1) {
                    throw createXMLException(
                            "invalid.character");
                }
                else {
                    while (current !=
                             -1 &&
                             org.apache.batik.xml.XMLUtilities.
                             isXMLNameCharacter(
                               (char)
                                 current)) {
                        nextChar(
                          );
                    }
                    return ntype;
                }
            }
        }
        nextChar(
          );
        return type;
    }
    protected int readName(int type) throws java.io.IOException,
        org.apache.batik.xml.XMLException {
        if (current ==
              -1) {
            throw createXMLException(
                    "unexpected.eof");
        }
        if (!org.apache.batik.xml.XMLUtilities.
              isXMLNameFirstCharacter(
                (char)
                  current)) {
            throw createXMLException(
                    "invalid.name");
        }
        do  {
            nextChar(
              );
        }while(current !=
                 -1 &&
                 org.apache.batik.xml.XMLUtilities.
                 isXMLNameCharacter(
                   (char)
                     current)); 
        return type;
    }
    protected int readPIStart() throws java.io.IOException,
        org.apache.batik.xml.XMLException {
        int c1 =
          nextChar(
            );
        if (c1 ==
              -1) {
            throw createXMLException(
                    "unexpected.eof");
        }
        if (!org.apache.batik.xml.XMLUtilities.
              isXMLNameFirstCharacter(
                (char)
                  current)) {
            throw createXMLException(
                    "malformed.pi.target");
        }
        int c2 =
          nextChar(
            );
        if (c2 ==
              -1 ||
              !org.apache.batik.xml.XMLUtilities.
              isXMLNameCharacter(
                (char)
                  c2)) {
            return org.apache.batik.xml.LexicalUnits.
                     PI_START;
        }
        int c3 =
          nextChar(
            );
        if (c3 ==
              -1 ||
              !org.apache.batik.xml.XMLUtilities.
              isXMLNameCharacter(
                (char)
                  c3)) {
            return org.apache.batik.xml.LexicalUnits.
                     PI_START;
        }
        int c4 =
          nextChar(
            );
        if (c4 !=
              -1 &&
              org.apache.batik.xml.XMLUtilities.
              isXMLNameCharacter(
                (char)
                  c4)) {
            do  {
                nextChar(
                  );
            }while(current !=
                     -1 &&
                     org.apache.batik.xml.XMLUtilities.
                     isXMLNameCharacter(
                       (char)
                         current)); 
            return org.apache.batik.xml.LexicalUnits.
                     PI_START;
        }
        if ((c1 ==
               'x' ||
               c1 ==
               'X') &&
              (c2 ==
                 'm' ||
                 c2 ==
                 'M') &&
              (c3 ==
                 'l' ||
                 c3 ==
                 'L')) {
            throw createXMLException(
                    "xml.reserved");
        }
        return org.apache.batik.xml.LexicalUnits.
                 PI_START;
    }
    protected int nextInElementDeclaration()
          throws java.io.IOException,
        org.apache.batik.xml.XMLException {
        switch (current) {
            case 9:
            case 10:
            case 13:
            case 32:
                do  {
                    nextChar(
                      );
                }while(current !=
                         -1 &&
                         org.apache.batik.xml.XMLUtilities.
                         isXMLSpace(
                           (char)
                             current)); 
                return org.apache.batik.xml.LexicalUnits.
                         S;
            case '>':
                nextChar(
                  );
                context =
                  DTD_DECLARATIONS_CONTEXT;
                return org.apache.batik.xml.LexicalUnits.
                         END_CHAR;
            case '%':
                nextChar(
                  );
                int t =
                  readName(
                    org.apache.batik.xml.LexicalUnits.
                      PARAMETER_ENTITY_REFERENCE);
                if (current !=
                      ';') {
                    throw createXMLException(
                            "malformed.parameter.entity");
                }
                nextChar(
                  );
                return t;
            case 'E':
                return readIdentifier(
                         "MPTY",
                         org.apache.batik.xml.LexicalUnits.
                           EMPTY_IDENTIFIER,
                         org.apache.batik.xml.LexicalUnits.
                           NAME);
            case 'A':
                return readIdentifier(
                         "NY",
                         org.apache.batik.xml.LexicalUnits.
                           ANY_IDENTIFIER,
                         org.apache.batik.xml.LexicalUnits.
                           NAME);
            case '?':
                nextChar(
                  );
                return org.apache.batik.xml.LexicalUnits.
                         QUESTION;
            case '+':
                nextChar(
                  );
                return org.apache.batik.xml.LexicalUnits.
                         PLUS;
            case '*':
                nextChar(
                  );
                return org.apache.batik.xml.LexicalUnits.
                         STAR;
            case '(':
                nextChar(
                  );
                return org.apache.batik.xml.LexicalUnits.
                         LEFT_BRACE;
            case ')':
                nextChar(
                  );
                return org.apache.batik.xml.LexicalUnits.
                         RIGHT_BRACE;
            case '|':
                nextChar(
                  );
                return org.apache.batik.xml.LexicalUnits.
                         PIPE;
            case ',':
                nextChar(
                  );
                return org.apache.batik.xml.LexicalUnits.
                         COMMA;
            case '#':
                return readIdentifier(
                         "PCDATA",
                         org.apache.batik.xml.LexicalUnits.
                           PCDATA_IDENTIFIER,
                         -1);
            default:
                return readName(
                         org.apache.batik.xml.LexicalUnits.
                           NAME);
        }
    }
    protected int nextInAttList() throws java.io.IOException,
        org.apache.batik.xml.XMLException {
        switch (current) {
            case 9:
            case 10:
            case 13:
            case 32:
                do  {
                    nextChar(
                      );
                }while(current !=
                         -1 &&
                         org.apache.batik.xml.XMLUtilities.
                         isXMLSpace(
                           (char)
                             current)); 
                return org.apache.batik.xml.LexicalUnits.
                         S;
            case '>':
                nextChar(
                  );
                context =
                  DTD_DECLARATIONS_CONTEXT;
                return type =
                  org.apache.batik.xml.LexicalUnits.
                    END_CHAR;
            case '%':
                int t =
                  readName(
                    org.apache.batik.xml.LexicalUnits.
                      PARAMETER_ENTITY_REFERENCE);
                if (current !=
                      ';') {
                    throw createXMLException(
                            "malformed.parameter.entity");
                }
                nextChar(
                  );
                return t;
            case 'C':
                return readIdentifier(
                         "DATA",
                         org.apache.batik.xml.LexicalUnits.
                           CDATA_IDENTIFIER,
                         org.apache.batik.xml.LexicalUnits.
                           NAME);
            case 'I':
                nextChar(
                  );
                if (current !=
                      'D') {
                    do  {
                        nextChar(
                          );
                    }while(current !=
                             -1 &&
                             org.apache.batik.xml.XMLUtilities.
                             isXMLNameCharacter(
                               (char)
                                 current)); 
                    return org.apache.batik.xml.LexicalUnits.
                             NAME;
                }
                nextChar(
                  );
                if (current ==
                      -1 ||
                      !org.apache.batik.xml.XMLUtilities.
                      isXMLNameCharacter(
                        (char)
                          current)) {
                    return org.apache.batik.xml.LexicalUnits.
                             ID_IDENTIFIER;
                }
                if (current !=
                      'R') {
                    do  {
                        nextChar(
                          );
                    }while(current !=
                             -1 &&
                             org.apache.batik.xml.XMLUtilities.
                             isXMLNameCharacter(
                               (char)
                                 current)); 
                    return org.apache.batik.xml.LexicalUnits.
                             NAME;
                }
                nextChar(
                  );
                if (current ==
                      -1 ||
                      !org.apache.batik.xml.XMLUtilities.
                      isXMLNameCharacter(
                        (char)
                          current)) {
                    return org.apache.batik.xml.LexicalUnits.
                             NAME;
                }
                if (current !=
                      'E') {
                    do  {
                        nextChar(
                          );
                    }while(current !=
                             -1 &&
                             org.apache.batik.xml.XMLUtilities.
                             isXMLNameCharacter(
                               (char)
                                 current)); 
                    return org.apache.batik.xml.LexicalUnits.
                             NAME;
                }
                nextChar(
                  );
                if (current ==
                      -1 ||
                      !org.apache.batik.xml.XMLUtilities.
                      isXMLNameCharacter(
                        (char)
                          current)) {
                    return org.apache.batik.xml.LexicalUnits.
                             NAME;
                }
                if (current !=
                      'F') {
                    do  {
                        nextChar(
                          );
                    }while(current !=
                             -1 &&
                             org.apache.batik.xml.XMLUtilities.
                             isXMLNameCharacter(
                               (char)
                                 current)); 
                    return org.apache.batik.xml.LexicalUnits.
                             NAME;
                }
                nextChar(
                  );
                if (current ==
                      -1 ||
                      !org.apache.batik.xml.XMLUtilities.
                      isXMLNameCharacter(
                        (char)
                          current)) {
                    return org.apache.batik.xml.LexicalUnits.
                             IDREF_IDENTIFIER;
                }
                if (current !=
                      'S') {
                    do  {
                        nextChar(
                          );
                    }while(current !=
                             -1 &&
                             org.apache.batik.xml.XMLUtilities.
                             isXMLNameCharacter(
                               (char)
                                 current)); 
                    return org.apache.batik.xml.LexicalUnits.
                             NAME;
                }
                nextChar(
                  );
                if (current ==
                      -1 ||
                      !org.apache.batik.xml.XMLUtilities.
                      isXMLNameCharacter(
                        (char)
                          current)) {
                    return org.apache.batik.xml.LexicalUnits.
                             IDREFS_IDENTIFIER;
                }
                do  {
                    nextChar(
                      );
                }while(current !=
                         -1 &&
                         org.apache.batik.xml.XMLUtilities.
                         isXMLNameCharacter(
                           (char)
                             current)); 
                return type =
                  org.apache.batik.xml.LexicalUnits.
                    NAME;
            case 'N':
                switch (nextChar(
                          )) {
                    default:
                        do  {
                            nextChar(
                              );
                        }while(current !=
                                 -1 &&
                                 org.apache.batik.xml.XMLUtilities.
                                 isXMLNameCharacter(
                                   (char)
                                     current)); 
                        return org.apache.batik.xml.LexicalUnits.
                                 NAME;
                    case 'O':
                        context =
                          NOTATION_TYPE_CONTEXT;
                        return readIdentifier(
                                 "TATION",
                                 org.apache.batik.xml.LexicalUnits.
                                   NOTATION_IDENTIFIER,
                                 org.apache.batik.xml.LexicalUnits.
                                   NAME);
                    case 'M':
                        nextChar(
                          );
                        if (current ==
                              -1 ||
                              !org.apache.batik.xml.XMLUtilities.
                              isXMLNameCharacter(
                                (char)
                                  current)) {
                            return org.apache.batik.xml.LexicalUnits.
                                     NAME;
                        }
                        if (current !=
                              'T') {
                            do  {
                                nextChar(
                                  );
                            }while(current !=
                                     -1 &&
                                     org.apache.batik.xml.XMLUtilities.
                                     isXMLNameCharacter(
                                       (char)
                                         current)); 
                            return org.apache.batik.xml.LexicalUnits.
                                     NAME;
                        }
                        nextChar(
                          );
                        if (current ==
                              -1 ||
                              !org.apache.batik.xml.XMLUtilities.
                              isXMLNameCharacter(
                                (char)
                                  current)) {
                            return org.apache.batik.xml.LexicalUnits.
                                     NAME;
                        }
                        if (current !=
                              'O') {
                            do  {
                                nextChar(
                                  );
                            }while(current !=
                                     -1 &&
                                     org.apache.batik.xml.XMLUtilities.
                                     isXMLNameCharacter(
                                       (char)
                                         current)); 
                            return org.apache.batik.xml.LexicalUnits.
                                     NAME;
                        }
                        nextChar(
                          );
                        if (current ==
                              -1 ||
                              !org.apache.batik.xml.XMLUtilities.
                              isXMLNameCharacter(
                                (char)
                                  current)) {
                            return org.apache.batik.xml.LexicalUnits.
                                     NAME;
                        }
                        if (current !=
                              'K') {
                            do  {
                                nextChar(
                                  );
                            }while(current !=
                                     -1 &&
                                     org.apache.batik.xml.XMLUtilities.
                                     isXMLNameCharacter(
                                       (char)
                                         current)); 
                            return org.apache.batik.xml.LexicalUnits.
                                     NAME;
                        }
                        nextChar(
                          );
                        if (current ==
                              -1 ||
                              !org.apache.batik.xml.XMLUtilities.
                              isXMLNameCharacter(
                                (char)
                                  current)) {
                            return org.apache.batik.xml.LexicalUnits.
                                     NAME;
                        }
                        if (current !=
                              'E') {
                            do  {
                                nextChar(
                                  );
                            }while(current !=
                                     -1 &&
                                     org.apache.batik.xml.XMLUtilities.
                                     isXMLNameCharacter(
                                       (char)
                                         current)); 
                            return org.apache.batik.xml.LexicalUnits.
                                     NAME;
                        }
                        nextChar(
                          );
                        if (current ==
                              -1 ||
                              !org.apache.batik.xml.XMLUtilities.
                              isXMLNameCharacter(
                                (char)
                                  current)) {
                            return org.apache.batik.xml.LexicalUnits.
                                     NAME;
                        }
                        if (current !=
                              'N') {
                            do  {
                                nextChar(
                                  );
                            }while(current !=
                                     -1 &&
                                     org.apache.batik.xml.XMLUtilities.
                                     isXMLNameCharacter(
                                       (char)
                                         current)); 
                            return org.apache.batik.xml.LexicalUnits.
                                     NAME;
                        }
                        nextChar(
                          );
                        if (current ==
                              -1 ||
                              !org.apache.batik.xml.XMLUtilities.
                              isXMLNameCharacter(
                                (char)
                                  current)) {
                            return org.apache.batik.xml.LexicalUnits.
                                     NMTOKEN_IDENTIFIER;
                        }
                        if (current !=
                              'S') {
                            do  {
                                nextChar(
                                  );
                            }while(current !=
                                     -1 &&
                                     org.apache.batik.xml.XMLUtilities.
                                     isXMLNameCharacter(
                                       (char)
                                         current)); 
                            return org.apache.batik.xml.LexicalUnits.
                                     NAME;
                        }
                        nextChar(
                          );
                        if (current ==
                              -1 ||
                              !org.apache.batik.xml.XMLUtilities.
                              isXMLNameCharacter(
                                (char)
                                  current)) {
                            return org.apache.batik.xml.LexicalUnits.
                                     NMTOKENS_IDENTIFIER;
                        }
                        do  {
                            nextChar(
                              );
                        }while(current !=
                                 -1 &&
                                 org.apache.batik.xml.XMLUtilities.
                                 isXMLNameCharacter(
                                   (char)
                                     current)); 
                        return org.apache.batik.xml.LexicalUnits.
                                 NAME;
                }
            case 'E':
                nextChar(
                  );
                if (current !=
                      'N') {
                    do  {
                        nextChar(
                          );
                    }while(current !=
                             -1 &&
                             org.apache.batik.xml.XMLUtilities.
                             isXMLNameCharacter(
                               (char)
                                 current)); 
                    return org.apache.batik.xml.LexicalUnits.
                             NAME;
                }
                nextChar(
                  );
                if (current ==
                      -1 ||
                      !org.apache.batik.xml.XMLUtilities.
                      isXMLNameCharacter(
                        (char)
                          current)) {
                    return org.apache.batik.xml.LexicalUnits.
                             NAME;
                }
                if (current !=
                      'T') {
                    do  {
                        nextChar(
                          );
                    }while(current !=
                             -1 &&
                             org.apache.batik.xml.XMLUtilities.
                             isXMLNameCharacter(
                               (char)
                                 current)); 
                    return org.apache.batik.xml.LexicalUnits.
                             NAME;
                }
                nextChar(
                  );
                if (current ==
                      -1 ||
                      !org.apache.batik.xml.XMLUtilities.
                      isXMLNameCharacter(
                        (char)
                          current)) {
                    return org.apache.batik.xml.LexicalUnits.
                             NAME;
                }
                if (current !=
                      'I') {
                    do  {
                        nextChar(
                          );
                    }while(current !=
                             -1 &&
                             org.apache.batik.xml.XMLUtilities.
                             isXMLNameCharacter(
                               (char)
                                 current)); 
                    return org.apache.batik.xml.LexicalUnits.
                             NAME;
                }
                nextChar(
                  );
                if (current ==
                      -1 ||
                      !org.apache.batik.xml.XMLUtilities.
                      isXMLNameCharacter(
                        (char)
                          current)) {
                    return org.apache.batik.xml.LexicalUnits.
                             NAME;
                }
                if (current !=
                      'T') {
                    do  {
                        nextChar(
                          );
                    }while(current !=
                             -1 &&
                             org.apache.batik.xml.XMLUtilities.
                             isXMLNameCharacter(
                               (char)
                                 current)); 
                    return type =
                      org.apache.batik.xml.LexicalUnits.
                        NAME;
                }
                nextChar(
                  );
                if (current ==
                      -1 ||
                      !org.apache.batik.xml.XMLUtilities.
                      isXMLNameCharacter(
                        (char)
                          current)) {
                    return org.apache.batik.xml.LexicalUnits.
                             NAME;
                }
                switch (current) {
                    case 'Y':
                        nextChar(
                          );
                        if (current ==
                              -1 ||
                              !org.apache.batik.xml.XMLUtilities.
                              isXMLNameCharacter(
                                (char)
                                  current)) {
                            return org.apache.batik.xml.LexicalUnits.
                                     ENTITY_IDENTIFIER;
                        }
                        do  {
                            nextChar(
                              );
                        }while(current !=
                                 -1 &&
                                 org.apache.batik.xml.XMLUtilities.
                                 isXMLNameCharacter(
                                   (char)
                                     current)); 
                        return org.apache.batik.xml.LexicalUnits.
                                 NAME;
                    case 'I':
                        nextChar(
                          );
                        if (current ==
                              -1 ||
                              !org.apache.batik.xml.XMLUtilities.
                              isXMLNameCharacter(
                                (char)
                                  current)) {
                            return org.apache.batik.xml.LexicalUnits.
                                     NAME;
                        }
                        if (current !=
                              'E') {
                            do  {
                                nextChar(
                                  );
                            }while(current !=
                                     -1 &&
                                     org.apache.batik.xml.XMLUtilities.
                                     isXMLNameCharacter(
                                       (char)
                                         current)); 
                            return org.apache.batik.xml.LexicalUnits.
                                     NAME;
                        }
                        nextChar(
                          );
                        if (current ==
                              -1 ||
                              !org.apache.batik.xml.XMLUtilities.
                              isXMLNameCharacter(
                                (char)
                                  current)) {
                            return org.apache.batik.xml.LexicalUnits.
                                     NAME;
                        }
                        if (current !=
                              'S') {
                            do  {
                                nextChar(
                                  );
                            }while(current !=
                                     -1 &&
                                     org.apache.batik.xml.XMLUtilities.
                                     isXMLNameCharacter(
                                       (char)
                                         current)); 
                            return org.apache.batik.xml.LexicalUnits.
                                     NAME;
                        }
                        return org.apache.batik.xml.LexicalUnits.
                                 ENTITIES_IDENTIFIER;
                    default:
                        if (current ==
                              -1 ||
                              !org.apache.batik.xml.XMLUtilities.
                              isXMLNameCharacter(
                                (char)
                                  current)) {
                            return org.apache.batik.xml.LexicalUnits.
                                     NAME;
                        }
                        do  {
                            nextChar(
                              );
                        }while(current !=
                                 -1 &&
                                 org.apache.batik.xml.XMLUtilities.
                                 isXMLNameCharacter(
                                   (char)
                                     current)); 
                        return org.apache.batik.xml.LexicalUnits.
                                 NAME;
                }
            case '\"':
                attrDelimiter =
                  '\"';
                nextChar(
                  );
                if (current ==
                      -1) {
                    throw createXMLException(
                            "unexpected.eof");
                }
                if (current !=
                      '\"' &&
                      current !=
                      '&') {
                    do  {
                        nextChar(
                          );
                    }while(current !=
                             -1 &&
                             current !=
                             '\"' &&
                             current !=
                             '&'); 
                }
                switch (current) {
                    case '&':
                        context =
                          ATTRIBUTE_VALUE_CONTEXT;
                        return org.apache.batik.xml.LexicalUnits.
                                 FIRST_ATTRIBUTE_FRAGMENT;
                    case '\"':
                        nextChar(
                          );
                        return org.apache.batik.xml.LexicalUnits.
                                 STRING;
                    default:
                        throw createXMLException(
                                "invalid.character");
                }
            case '\'':
                attrDelimiter =
                  '\'';
                nextChar(
                  );
                if (current ==
                      -1) {
                    throw createXMLException(
                            "unexpected.eof");
                }
                if (current !=
                      '\'' &&
                      current !=
                      '&') {
                    do  {
                        nextChar(
                          );
                    }while(current !=
                             -1 &&
                             current !=
                             '\'' &&
                             current !=
                             '&'); 
                }
                switch (current) {
                    case '&':
                        context =
                          ATTRIBUTE_VALUE_CONTEXT;
                        return org.apache.batik.xml.LexicalUnits.
                                 FIRST_ATTRIBUTE_FRAGMENT;
                    case '\'':
                        nextChar(
                          );
                        return org.apache.batik.xml.LexicalUnits.
                                 STRING;
                    default:
                        throw createXMLException(
                                "invalid.character");
                }
            case '#':
                switch (nextChar(
                          )) {
                    case 'R':
                        return readIdentifier(
                                 "EQUIRED",
                                 org.apache.batik.xml.LexicalUnits.
                                   REQUIRED_IDENTIFIER,
                                 -1);
                    case 'I':
                        return readIdentifier(
                                 "MPLIED",
                                 org.apache.batik.xml.LexicalUnits.
                                   IMPLIED_IDENTIFIER,
                                 -1);
                    case 'F':
                        return readIdentifier(
                                 "IXED",
                                 org.apache.batik.xml.LexicalUnits.
                                   FIXED_IDENTIFIER,
                                 -1);
                    default:
                        throw createXMLException(
                                "invalid.character");
                }
            case '(':
                nextChar(
                  );
                context =
                  ENUMERATION_CONTEXT;
                return org.apache.batik.xml.LexicalUnits.
                         LEFT_BRACE;
            default:
                return readName(
                         org.apache.batik.xml.LexicalUnits.
                           NAME);
        }
    }
    protected int nextInNotation() throws java.io.IOException,
        org.apache.batik.xml.XMLException {
        switch (current) {
            case 9:
            case 10:
            case 13:
            case 32:
                do  {
                    nextChar(
                      );
                }while(current !=
                         -1 &&
                         org.apache.batik.xml.XMLUtilities.
                         isXMLSpace(
                           (char)
                             current)); 
                return org.apache.batik.xml.LexicalUnits.
                         S;
            case '>':
                nextChar(
                  );
                context =
                  DTD_DECLARATIONS_CONTEXT;
                return org.apache.batik.xml.LexicalUnits.
                         END_CHAR;
            case '%':
                int t =
                  readName(
                    org.apache.batik.xml.LexicalUnits.
                      PARAMETER_ENTITY_REFERENCE);
                if (current !=
                      ';') {
                    throw createXMLException(
                            "malformed.parameter.entity");
                }
                nextChar(
                  );
                return t;
            case 'S':
                return readIdentifier(
                         "YSTEM",
                         org.apache.batik.xml.LexicalUnits.
                           SYSTEM_IDENTIFIER,
                         org.apache.batik.xml.LexicalUnits.
                           NAME);
            case 'P':
                return readIdentifier(
                         "UBLIC",
                         org.apache.batik.xml.LexicalUnits.
                           PUBLIC_IDENTIFIER,
                         org.apache.batik.xml.LexicalUnits.
                           NAME);
            case '\"':
                attrDelimiter =
                  '\"';
                return readString(
                         );
            case '\'':
                attrDelimiter =
                  '\'';
                return readString(
                         );
            default:
                return readName(
                         org.apache.batik.xml.LexicalUnits.
                           NAME);
        }
    }
    protected int nextInEntity() throws java.io.IOException,
        org.apache.batik.xml.XMLException {
        switch (current) {
            case 9:
            case 10:
            case 13:
            case 32:
                do  {
                    nextChar(
                      );
                }while(current !=
                         -1 &&
                         org.apache.batik.xml.XMLUtilities.
                         isXMLSpace(
                           (char)
                             current)); 
                return org.apache.batik.xml.LexicalUnits.
                         S;
            case '>':
                nextChar(
                  );
                context =
                  DTD_DECLARATIONS_CONTEXT;
                return org.apache.batik.xml.LexicalUnits.
                         END_CHAR;
            case '%':
                nextChar(
                  );
                return org.apache.batik.xml.LexicalUnits.
                         PERCENT;
            case 'S':
                return readIdentifier(
                         "YSTEM",
                         org.apache.batik.xml.LexicalUnits.
                           SYSTEM_IDENTIFIER,
                         org.apache.batik.xml.LexicalUnits.
                           NAME);
            case 'P':
                return readIdentifier(
                         "UBLIC",
                         org.apache.batik.xml.LexicalUnits.
                           PUBLIC_IDENTIFIER,
                         org.apache.batik.xml.LexicalUnits.
                           NAME);
            case 'N':
                return readIdentifier(
                         "DATA",
                         org.apache.batik.xml.LexicalUnits.
                           NDATA_IDENTIFIER,
                         org.apache.batik.xml.LexicalUnits.
                           NAME);
            case '\"':
                attrDelimiter =
                  '\"';
                nextChar(
                  );
                if (current ==
                      -1) {
                    throw createXMLException(
                            "unexpected.eof");
                }
                if (current !=
                      '\"' &&
                      current !=
                      '&' &&
                      current !=
                      '%') {
                    do  {
                        nextChar(
                          );
                    }while(current !=
                             -1 &&
                             current !=
                             '\"' &&
                             current !=
                             '&' &&
                             current !=
                             '%'); 
                }
                switch (current) {
                    default:
                        throw createXMLException(
                                "invalid.character");
                    case '&':
                    case '%':
                        context =
                          ENTITY_VALUE_CONTEXT;
                        break;
                    case '\"':
                        nextChar(
                          );
                        return org.apache.batik.xml.LexicalUnits.
                                 STRING;
                }
                return org.apache.batik.xml.LexicalUnits.
                         FIRST_ATTRIBUTE_FRAGMENT;
            case '\'':
                attrDelimiter =
                  '\'';
                nextChar(
                  );
                if (current ==
                      -1) {
                    throw createXMLException(
                            "unexpected.eof");
                }
                if (current !=
                      '\'' &&
                      current !=
                      '&' &&
                      current !=
                      '%') {
                    do  {
                        nextChar(
                          );
                    }while(current !=
                             -1 &&
                             current !=
                             '\'' &&
                             current !=
                             '&' &&
                             current !=
                             '%'); 
                }
                switch (current) {
                    default:
                        throw createXMLException(
                                "invalid.character");
                    case '&':
                    case '%':
                        context =
                          ENTITY_VALUE_CONTEXT;
                        break;
                    case '\'':
                        nextChar(
                          );
                        return org.apache.batik.xml.LexicalUnits.
                                 STRING;
                }
                return org.apache.batik.xml.LexicalUnits.
                         FIRST_ATTRIBUTE_FRAGMENT;
            default:
                return readName(
                         org.apache.batik.xml.LexicalUnits.
                           NAME);
        }
    }
    protected int nextInEntityValue() throws java.io.IOException,
        org.apache.batik.xml.XMLException {
        switch (current) {
            case '&':
                return readReference(
                         );
            case '%':
                int t =
                  nextChar(
                    );
                readName(
                  org.apache.batik.xml.LexicalUnits.
                    PARAMETER_ENTITY_REFERENCE);
                if (current !=
                      ';') {
                    throw createXMLException(
                            "invalid.parameter.entity");
                }
                nextChar(
                  );
                return t;
            default:
                while (current !=
                         -1 &&
                         current !=
                         attrDelimiter &&
                         current !=
                         '&' &&
                         current !=
                         '%') {
                    nextChar(
                      );
                }
                switch (current) {
                    case -1:
                        throw createXMLException(
                                "unexpected.eof");
                    case '\'':
                    case '\"':
                        nextChar(
                          );
                        context =
                          ENTITY_CONTEXT;
                        return org.apache.batik.xml.LexicalUnits.
                                 STRING;
                }
                return org.apache.batik.xml.LexicalUnits.
                         FIRST_ATTRIBUTE_FRAGMENT;
        }
    }
    protected int nextInNotationType() throws java.io.IOException,
        org.apache.batik.xml.XMLException {
        switch (current) {
            case 9:
            case 10:
            case 13:
            case 32:
                do  {
                    nextChar(
                      );
                }while(current !=
                         -1 &&
                         org.apache.batik.xml.XMLUtilities.
                         isXMLSpace(
                           (char)
                             current)); 
                return org.apache.batik.xml.LexicalUnits.
                         S;
            case '|':
                nextChar(
                  );
                return org.apache.batik.xml.LexicalUnits.
                         PIPE;
            case '(':
                nextChar(
                  );
                return org.apache.batik.xml.LexicalUnits.
                         LEFT_BRACE;
            case ')':
                nextChar(
                  );
                context =
                  ATTLIST_CONTEXT;
                return org.apache.batik.xml.LexicalUnits.
                         RIGHT_BRACE;
            default:
                return readName(
                         org.apache.batik.xml.LexicalUnits.
                           NAME);
        }
    }
    protected int nextInEnumeration() throws java.io.IOException,
        org.apache.batik.xml.XMLException {
        switch (current) {
            case 9:
            case 10:
            case 13:
            case 32:
                do  {
                    nextChar(
                      );
                }while(current !=
                         -1 &&
                         org.apache.batik.xml.XMLUtilities.
                         isXMLSpace(
                           (char)
                             current)); 
                return org.apache.batik.xml.LexicalUnits.
                         S;
            case '|':
                nextChar(
                  );
                return org.apache.batik.xml.LexicalUnits.
                         PIPE;
            case ')':
                nextChar(
                  );
                context =
                  ATTLIST_CONTEXT;
                return org.apache.batik.xml.LexicalUnits.
                         RIGHT_BRACE;
            default:
                return readNmtoken(
                         );
        }
    }
    protected int readReference() throws java.io.IOException,
        org.apache.batik.xml.XMLException {
        nextChar(
          );
        if (current ==
              '#') {
            nextChar(
              );
            int i =
              0;
            switch (current) {
                case 'x':
                    do  {
                        i++;
                        nextChar(
                          );
                    }while(current >=
                             '0' &&
                             current <=
                             '9' ||
                             current >=
                             'a' &&
                             current <=
                             'f' ||
                             current >=
                             'A' &&
                             current <=
                             'F'); 
                    break;
                default:
                    do  {
                        i++;
                        nextChar(
                          );
                    }while(current >=
                             '0' &&
                             current <=
                             '9'); 
                    break;
                case -1:
                    throw createXMLException(
                            "unexpected.eof");
            }
            if (i ==
                  1 ||
                  current !=
                  ';') {
                throw createXMLException(
                        "character.reference");
            }
            nextChar(
              );
            return org.apache.batik.xml.LexicalUnits.
                     CHARACTER_REFERENCE;
        }
        else {
            int t =
              readName(
                org.apache.batik.xml.LexicalUnits.
                  ENTITY_REFERENCE);
            if (current !=
                  ';') {
                throw createXMLException(
                        "character.reference");
            }
            nextChar(
              );
            return t;
        }
    }
    protected int readPEReference() throws java.io.IOException,
        org.apache.batik.xml.XMLException {
        nextChar(
          );
        if (current ==
              -1) {
            throw createXMLException(
                    "unexpected.eof");
        }
        if (!org.apache.batik.xml.XMLUtilities.
              isXMLNameFirstCharacter(
                (char)
                  current)) {
            throw createXMLException(
                    "invalid.parameter.entity");
        }
        do  {
            nextChar(
              );
        }while(current !=
                 -1 &&
                 org.apache.batik.xml.XMLUtilities.
                 isXMLNameCharacter(
                   (char)
                     current)); 
        if (current !=
              ';') {
            throw createXMLException(
                    "invalid.parameter.entity");
        }
        nextChar(
          );
        return org.apache.batik.xml.LexicalUnits.
                 PARAMETER_ENTITY_REFERENCE;
    }
    protected int readNmtoken() throws java.io.IOException,
        org.apache.batik.xml.XMLException {
        if (current ==
              -1) {
            throw createXMLException(
                    "unexpected.eof");
        }
        while (org.apache.batik.xml.XMLUtilities.
                 isXMLNameCharacter(
                   (char)
                     current)) {
            nextChar(
              );
        }
        return org.apache.batik.xml.LexicalUnits.
                 NMTOKEN;
    }
    protected int nextChar() throws java.io.IOException {
        current =
          reader.
            read(
              );
        if (current ==
              -1) {
            return current;
        }
        if (position ==
              buffer.
                length) {
            char[] t =
              new char[1 +
                         position +
                         position /
                         2];
            java.lang.System.
              arraycopy(
                buffer,
                0,
                t,
                0,
                position);
            buffer =
              t;
        }
        return buffer[position++] =
          (char)
            current;
    }
    protected org.apache.batik.xml.XMLException createXMLException(java.lang.String message) {
        java.lang.String m;
        try {
            m =
              formatMessage(
                message,
                new java.lang.Object[] { new java.lang.Integer(
                  reader.
                    getLine(
                      )),
                new java.lang.Integer(
                  reader.
                    getColumn(
                      )) });
        }
        catch (java.util.MissingResourceException e) {
            m =
              message;
        }
        return new org.apache.batik.xml.XMLException(
          m);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1dCXQcxZmumZElWbIkWz7xfcgQXxpMgMQYCLI0NoLRSLHG" +
       "WmwO0ZppSYPnoqdGkg0m2GRjh+wSA+ZIHnb2EbPmcLjCtY8A5rFcgYQjJIHk" +
       "gQlhgQ3HciSEBLLs/1fVTPf0TNVMD8z6va4pd9Vf9X9f/VX1V3V16+C7ZFzK" +
       "IHP1OG2lW5J6qtUXpz2akdLD7VEtlQrCvf7QNR7to3PeCqxyk+pNpHFYS3WF" +
       "tJS+NqJHw6lNZE4knqJaPKSnAroeRokeQ0/pxohGI4n4JjI1kuqMJaORUIR2" +
       "JcI6ZujTDD+ZpFFqRAbSVO8UBVAyxw+aeJkm3jZ78mo/mRBKJLeY2WdYsrdb" +
       "UjBnzKwrRclE/3naiOZN00jU64+k6OoxgyxLJqJbhqIJ2qqP0dbzoscJCk7z" +
       "H5dHwcLbmz7+dPfwREbBZC0eT1AGL7VeTyWiI3rYT5rMu76oHkudTy4iHj+p" +
       "t2SmpMWfqdQLlXqh0gxaMxdo36DH07H2BINDMyVVJ0OoECULcgtJaoYWE8X0" +
       "MJ2hhFoqsDNhQDs/i5ajzIN41TLvnmvOmXinhzRtIk2ReC+qEwIlKFSyCQjV" +
       "YwO6kWoLh/XwJjIpDo3dqxsRLRrZKlq6ORUZims0Dc2foQVvppO6weo0uYJ2" +
       "BGxGOkQTRhbeIDMo8b9xg1FtCLBOM7FyhGvxPgCsi4BixqAGdidEqjZH4mFK" +
       "5tklshhbTocMIFoT0+lwIltVVVyDG6SZm0hUiw95e8H04kOQdVwCDNCgZKa0" +
       "UOQ6qYU2a0N6P1qkLV8PT4Jc4xkRKELJVHs2VhK00kxbK1na593AiZddED81" +
       "7iYu0Dmsh6Kofz0IzbUJrdcHdUOHfsAFJyz1X61Ne2CXmxDIPNWWmee598IP" +
       "Tlk+99ATPM+sAnm6B87TQ7Q/tH+g8bnZ7UtWeVCN2mQiFcHGz0HOelmPSFk9" +
       "loQRZlq2RExszSQeWv/Yxotv1t92k7pOUh1KRNMxsKNJoUQsGYnqxjo9rhsa" +
       "1cOdZLweD7ez9E5SA3F/JK7zu92DgymddpKqKLtVnWD/B4oGoQikqA7ikfhg" +
       "IhNPanSYxceShJAauEgrXEcR/o/9UrLeO5yI6V4tpMUj8YS3x0gg/pQXRpwB" +
       "4HbYOwBWv9mbSqQNMEFvwhjyamAHw7pIGItFvWd0+XtBHkC0om0lK1LqGGKZ" +
       "POpyAc2z7Z08Cv3j1EQ0rBv9oT3pNb4Pbu1/ihsQGr1gAfoMVNTKK2plFbVC" +
       "Ra1mRcTlYuVPwQp5E0IDbIauDGPphCW9Z5927q6FHrCd5GgVsOeBrAtz5pR2" +
       "s79nBun+0G3NDVsXvLLyETep8pNmLUTTWhSniDZjCAaf0GbRPycMwGxjDvrz" +
       "LYM+zlZGIqSHYcyRDf6ilNrEiG7gfUqmWErITEnY+bzyCaGg/uTQtaPb+751" +
       "tJu4c8d5rHIcDFEo3oOjc3YUbrH370LlNu186+Pbrt6WMHt6zsSRme/yJBHD" +
       "QrsF2OnpDy2dr93d/8C2Fkb7eBiJqQY9Bwa5ufY6cgaS1ZlBGbHUAuDBhBHT" +
       "opiU4biODhuJUfMOM81JLD4FzKIee9ZUuH4tuhr7xdRpSQync1NGO7OhYIP+" +
       "Sb3JvS/+8r+/yujOzA9Nlom9V6erLWMSFtbMRp9JptkGDV2HfC9f23PlVe/u" +
       "PJPZLORYVKjCFgzbYSyCJgSa//mJ8186/Mr+F9xZO3dRmJTTA+DbjGVB4n1S" +
       "pwAJtR1p6gNjWhRGALSalg1xsM/IYEQbiOrYsT5rWrzy7ncum8jtIAp3Mma0" +
       "vHgB5v0j1pCLnzrnr3NZMa4QzqkmZ2Y2PlBPNktuMwxtC+oxtv35OT94XNsL" +
       "Qz4Ms6nIVp2NnC7OAUM+g5JGJhlJwPSjwXjD2vI4lng0C4/NF1kgG3Z8YyE9" +
       "iUqxUlZhsDhl7T25HdTiPPWHdr/wfkPf+w9+wODmel9WY+nSkqu5fWJw5BgU" +
       "P90+up2qpYYh37GHAmdNjB76FErcBCWGYGROdRuIMce0RO5xNb97+JFp5z7n" +
       "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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL19CbjrWH2f371v5s0Msw+zZGAGBt5AwPBky3smkGizLVmy" +
       "ZUmWLSVhkLVYsrVLtmUDYWkCaUkohSEhX2FoE9Jsk5AFUlKaZvgSmgWaFLI3" +
       "C1loSkJIIAu0JUuPbN/l+d13373zbnq/T8e6Oot+v/P/n//5n6Ojo6c+n7kh" +
       "CjNZ37MXI9uLL+lJfGlsly7FC1+PLlF0iVXCSNcwW4kiAVx7XH3Bj93xpa+8" +
       "3bxzJ3OjnLlHcV0vVmLLcyNOjzx7pmt05o6Dq4StO1GcuZMeKzMFmsaWDdFW" +
       "FD9GZ551KGucuUjvQYAABAhAgFYQIOQgFch0m+5OHSzNobhxFGS+OXOOztzo" +
       "qym8OPPI5YX4Sqg4m2LYFQNQwk3p/yIgtcqchJnn73Nfc76C8Luy0BPf9ao7" +
       "f2I3c4ecucNy+RSOCkDE4CZy5lZHd4Z6GCGapmty5i5X1zVeDy3FtpYr3HLm" +
       "7sgauUo8DfX9SkovTn09XN3zoOZuVVNu4VSNvXCfnmHptrb33w2GrYwA1/sO" +
       "uK4Z1tPrgOAtFgAWGoqq72U5P7FcLc48bzvHPseLLZAAZL3g6LHp7d/qvKuA" +
       "C5m717KzFXcE8XFouSOQ9AZvCu4SZx68aqFpXfuKOlFG+uNx5oHtdOw6CqS6" +
       "eVURaZY4c+92slVJQEoPbknpkHw+3/7at73Gbbo7K8yartop/ptApoe3MnG6" +
       "oYe6q+rrjLe+lP5O5b6f+badTAYkvncr8TrNf3ztF7/+ZQ8//YvrNM85Ik1n" +
       "ONbV+HH1/cPbP/lc7CW13RTGTb4XWanwL2O+Un92E/NY4oOWd99+iWnkpb3I" +
       "p7n/Kr3hh/TP7WRuITM3qp49dYAe3aV6jm/ZetjQXT1UYl0jMzfrroat4snM" +
       "BXBOW66+vtoxjEiPycx5e3XpRm/1P6giAxSRVtEFcG65hrd37iuxuTpP/Ewm" +
       "cwEcmUvgeHFm/bf6jTMcZHqODimq4lquB7Ghl/KPIN2Nh6BuTWgItH4CRd40" +
       "BCoIeeEIUoAemPomInFsaMDQPMgPSFxKdcv/Zyk1SbncOT93DlTzc7cbuQ3a" +
       "R9OzNT18XH1iihJf/NHHP76zr/SbWgBtBtzo0vpGl1Y3ugRudOngRplz51bl" +
       "Pzu94VqEQAAT0JSBkbv1Jfw3Ua/+thfsAt3x5+dB7e2CpNDVbS120PjJlYlT" +
       "gQZmnn73/I3i63M7mZ3LjWYKEly6Jc3OpqZu36Rd3G4sR5V7x1s++6UPfOfr" +
       "vINmc5kV3rTmK3OmrfEF29UZeqquAft2UPxLn6986PGfed3Fncx50MSBWYsV" +
       "oIbAYjy8fY/LWuVjexYu5XIDIGx4oaPYadSeWbolNkNvfnBlJefbV+d3gTp+" +
       "Vqqm94LjNzZ6u/pNY+/x0/DZa71IhbbFYmVBX8H77/3tX/mzwqq694ztHYe6" +
       "L16PHzvUwNPC7lg15bsOdEAIdR2k+/13s+981+ff8g0rBQApXnjUDS+mIQYa" +
       "NhAhqOZv/cXgdz79B+//9Z19pTkXgx5uOrQtNdknmV7P3HIMSXC3Fx3gAQbC" +
       "Bs0p1ZqLPdfxNMuwlKGtp1r693c8mv/QX7ztzrUe2ODKnhq97NoFHFz/KjTz" +
       "ho+/6ssPr4o5p6Yd1EGdHSRbW717DkpGwlBZpDiSN37qoe/+BeW9wH4CmxVZ" +
       "S31lhs6t62DF/N44c/sqp+UBW66AxruSJbSKfOkqvHRllkeu1oaJRNX9FNSq" +
       "lEIaPC863Houb6CHPJHH1bf/+hduE7/wX764onu5K3NYWRjFf2ytn2nw/AQU" +
       "f/+2qWgqkQnSFZ9uf+Od9tNfASXKoEQVmLmoE6YcL1OtTeobLvyPj/7cfa/+" +
       "5G5mp565xfYUra6sWmnmZtA89MgEti3xv+7r19oxvwkEd6ZnSWa/mjKrasqs" +
       "lerBK9vPZzaq9Zmj208aPpIGj16plVfLuiWonRWCnT1B3bMnW9L1pzFwNfSN" +
       "TQNxd67iUh/k0toHWaFAj5Z8+m9xlaCZBq9YxZfT4JVrtrXrqpi/3rD769NX" +
       "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" +
       "4lVIdBEEIx9tIlpXKgRjvDaV5sADR8TG");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
