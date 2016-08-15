package org.apache.batik.css.parser;
public class Scanner {
    protected org.apache.batik.util.io.NormalizingReader reader;
    protected int current;
    protected char[] buffer = new char[128];
    protected int position;
    protected int type;
    protected int start;
    protected int end;
    protected int blankCharacters;
    public Scanner(java.io.Reader r) throws org.apache.batik.css.parser.ParseException {
        super(
          );
        try {
            reader =
              new org.apache.batik.util.io.StreamNormalizingReader(
                r);
            current =
              nextChar(
                );
        }
        catch (java.io.IOException e) {
            throw new org.apache.batik.css.parser.ParseException(
              e);
        }
    }
    public Scanner(java.io.InputStream is, java.lang.String enc) throws org.apache.batik.css.parser.ParseException {
        super(
          );
        try {
            reader =
              new org.apache.batik.util.io.StreamNormalizingReader(
                is,
                enc);
            current =
              nextChar(
                );
        }
        catch (java.io.IOException e) {
            throw new org.apache.batik.css.parser.ParseException(
              e);
        }
    }
    public Scanner(java.lang.String s) throws org.apache.batik.css.parser.ParseException {
        super(
          );
        try {
            reader =
              new org.apache.batik.util.io.StringNormalizingReader(
                s);
            current =
              nextChar(
                );
        }
        catch (java.io.IOException e) {
            throw new org.apache.batik.css.parser.ParseException(
              e);
        }
    }
    public int getLine() { return reader.getLine(
                                           ); }
    public int getColumn() { return reader.getColumn(
                                             ); }
    public char[] getBuffer() { return buffer; }
    public int getStart() { return start; }
    public int getEnd() { return end; }
    public void clearBuffer() { if (position <= 0) {
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
    public int getType() { return type; }
    public java.lang.String getStringValue() { return new java.lang.String(
                                                 buffer,
                                                 start,
                                                 end -
                                                   start);
    }
    public void scanAtRule() throws org.apache.batik.css.parser.ParseException {
        try {
            loop: for (;
                       ;
                       ) {
                switch (current) {
                    case '{':
                        int brackets =
                          1;
                        for (;
                             ;
                             ) {
                            nextChar(
                              );
                            switch (current) {
                                case '}':
                                    if (--brackets >
                                          0) {
                                        break;
                                    }
                                case -1:
                                    break loop;
                                case '{':
                                    brackets++;
                            }
                        }
                    case -1:
                    case ';':
                        break loop;
                }
                nextChar(
                  );
            }
            end =
              position;
        }
        catch (java.io.IOException e) {
            throw new org.apache.batik.css.parser.ParseException(
              e);
        }
    }
    public int next() throws org.apache.batik.css.parser.ParseException {
        blankCharacters =
          0;
        start =
          position -
            1;
        nextToken(
          );
        end =
          position -
            endGap(
              );
        return type;
    }
    protected int endGap() { int result = current ==
                               -1
                               ? 0
                               : 1;
                             switch (type) { case org.apache.batik.css.parser.LexicalUnits.
                                                    FUNCTION:
                                             case org.apache.batik.css.parser.LexicalUnits.
                                                    STRING:
                                             case org.apache.batik.css.parser.LexicalUnits.
                                                    S:
                                             case org.apache.batik.css.parser.LexicalUnits.
                                                    PERCENTAGE:
                                                 result +=
                                                   1;
                                                 break;
                                             case org.apache.batik.css.parser.LexicalUnits.
                                                    COMMENT:
                                             case org.apache.batik.css.parser.LexicalUnits.
                                                    HZ:
                                             case org.apache.batik.css.parser.LexicalUnits.
                                                    EM:
                                             case org.apache.batik.css.parser.LexicalUnits.
                                                    EX:
                                             case org.apache.batik.css.parser.LexicalUnits.
                                                    PC:
                                             case org.apache.batik.css.parser.LexicalUnits.
                                                    PT:
                                             case org.apache.batik.css.parser.LexicalUnits.
                                                    PX:
                                             case org.apache.batik.css.parser.LexicalUnits.
                                                    CM:
                                             case org.apache.batik.css.parser.LexicalUnits.
                                                    MM:
                                             case org.apache.batik.css.parser.LexicalUnits.
                                                    IN:
                                             case org.apache.batik.css.parser.LexicalUnits.
                                                    MS:
                                                 result +=
                                                   2;
                                                 break;
                                             case org.apache.batik.css.parser.LexicalUnits.
                                                    KHZ:
                                             case org.apache.batik.css.parser.LexicalUnits.
                                                    DEG:
                                             case org.apache.batik.css.parser.LexicalUnits.
                                                    RAD:
                                                 result +=
                                                   3;
                                                 break;
                                             case org.apache.batik.css.parser.LexicalUnits.
                                                    GRAD:
                                                 result +=
                                                   4;
                             }
                             return result +
                               blankCharacters;
    }
    protected void nextToken() throws org.apache.batik.css.parser.ParseException {
        try {
            switch (current) {
                case -1:
                    type =
                      org.apache.batik.css.parser.LexicalUnits.
                        EOF;
                    return;
                case '{':
                    nextChar(
                      );
                    type =
                      org.apache.batik.css.parser.LexicalUnits.
                        LEFT_CURLY_BRACE;
                    return;
                case '}':
                    nextChar(
                      );
                    type =
                      org.apache.batik.css.parser.LexicalUnits.
                        RIGHT_CURLY_BRACE;
                    return;
                case '=':
                    nextChar(
                      );
                    type =
                      org.apache.batik.css.parser.LexicalUnits.
                        EQUAL;
                    return;
                case '+':
                    nextChar(
                      );
                    type =
                      org.apache.batik.css.parser.LexicalUnits.
                        PLUS;
                    return;
                case ',':
                    nextChar(
                      );
                    type =
                      org.apache.batik.css.parser.LexicalUnits.
                        COMMA;
                    return;
                case ';':
                    nextChar(
                      );
                    type =
                      org.apache.batik.css.parser.LexicalUnits.
                        SEMI_COLON;
                    return;
                case '>':
                    nextChar(
                      );
                    type =
                      org.apache.batik.css.parser.LexicalUnits.
                        PRECEDE;
                    return;
                case '[':
                    nextChar(
                      );
                    type =
                      org.apache.batik.css.parser.LexicalUnits.
                        LEFT_BRACKET;
                    return;
                case ']':
                    nextChar(
                      );
                    type =
                      org.apache.batik.css.parser.LexicalUnits.
                        RIGHT_BRACKET;
                    return;
                case '*':
                    nextChar(
                      );
                    type =
                      org.apache.batik.css.parser.LexicalUnits.
                        ANY;
                    return;
                case '(':
                    nextChar(
                      );
                    type =
                      org.apache.batik.css.parser.LexicalUnits.
                        LEFT_BRACE;
                    return;
                case ')':
                    nextChar(
                      );
                    type =
                      org.apache.batik.css.parser.LexicalUnits.
                        RIGHT_BRACE;
                    return;
                case ':':
                    nextChar(
                      );
                    type =
                      org.apache.batik.css.parser.LexicalUnits.
                        COLON;
                    return;
                case ' ':
                case '\t':
                case '\r':
                case '\n':
                case '\f':
                    do  {
                        nextChar(
                          );
                    }while(org.apache.batik.css.parser.ScannerUtilities.
                             isCSSSpace(
                               (char)
                                 current)); 
                    type =
                      org.apache.batik.css.parser.LexicalUnits.
                        SPACE;
                    return;
                case '/':
                    nextChar(
                      );
                    if (current !=
                          '*') {
                        type =
                          org.apache.batik.css.parser.LexicalUnits.
                            DIVIDE;
                        return;
                    }
                    nextChar(
                      );
                    start =
                      position -
                        1;
                    do  {
                        while (current !=
                                 -1 &&
                                 current !=
                                 '*') {
                            nextChar(
                              );
                        }
                        do  {
                            nextChar(
                              );
                        }while(current !=
                                 -1 &&
                                 current ==
                                 '*'); 
                    }while(current !=
                             -1 &&
                             current !=
                             '/'); 
                    if (current ==
                          -1) {
                        throw new org.apache.batik.css.parser.ParseException(
                          "eof",
                          reader.
                            getLine(
                              ),
                          reader.
                            getColumn(
                              ));
                    }
                    nextChar(
                      );
                    type =
                      org.apache.batik.css.parser.LexicalUnits.
                        COMMENT;
                    return;
                case '\'':
                    type =
                      string1(
                        );
                    return;
                case '\"':
                    type =
                      string2(
                        );
                    return;
                case '<':
                    nextChar(
                      );
                    if (current !=
                          '!') {
                        throw new org.apache.batik.css.parser.ParseException(
                          "character",
                          reader.
                            getLine(
                              ),
                          reader.
                            getColumn(
                              ));
                    }
                    nextChar(
                      );
                    if (current ==
                          '-') {
                        nextChar(
                          );
                        if (current ==
                              '-') {
                            nextChar(
                              );
                            type =
                              org.apache.batik.css.parser.LexicalUnits.
                                CDO;
                            return;
                        }
                    }
                    throw new org.apache.batik.css.parser.ParseException(
                      "character",
                      reader.
                        getLine(
                          ),
                      reader.
                        getColumn(
                          ));
                case '-':
                    nextChar(
                      );
                    if (current !=
                          '-') {
                        type =
                          org.apache.batik.css.parser.LexicalUnits.
                            MINUS;
                        return;
                    }
                    nextChar(
                      );
                    if (current ==
                          '>') {
                        nextChar(
                          );
                        type =
                          org.apache.batik.css.parser.LexicalUnits.
                            CDC;
                        return;
                    }
                    throw new org.apache.batik.css.parser.ParseException(
                      "character",
                      reader.
                        getLine(
                          ),
                      reader.
                        getColumn(
                          ));
                case '|':
                    nextChar(
                      );
                    if (current ==
                          '=') {
                        nextChar(
                          );
                        type =
                          org.apache.batik.css.parser.LexicalUnits.
                            DASHMATCH;
                        return;
                    }
                    throw new org.apache.batik.css.parser.ParseException(
                      "character",
                      reader.
                        getLine(
                          ),
                      reader.
                        getColumn(
                          ));
                case '~':
                    nextChar(
                      );
                    if (current ==
                          '=') {
                        nextChar(
                          );
                        type =
                          org.apache.batik.css.parser.LexicalUnits.
                            INCLUDES;
                        return;
                    }
                    throw new org.apache.batik.css.parser.ParseException(
                      "character",
                      reader.
                        getLine(
                          ),
                      reader.
                        getColumn(
                          ));
                case '#':
                    nextChar(
                      );
                    if (org.apache.batik.css.parser.ScannerUtilities.
                          isCSSNameCharacter(
                            (char)
                              current)) {
                        start =
                          position -
                            1;
                        do  {
                            nextChar(
                              );
                            while (current ==
                                     '\\') {
                                nextChar(
                                  );
                                escape(
                                  );
                            }
                        }while(current !=
                                 -1 &&
                                 org.apache.batik.css.parser.ScannerUtilities.
                                 isCSSNameCharacter(
                                   (char)
                                     current)); 
                        type =
                          org.apache.batik.css.parser.LexicalUnits.
                            HASH;
                        return;
                    }
                    throw new org.apache.batik.css.parser.ParseException(
                      "character",
                      reader.
                        getLine(
                          ),
                      reader.
                        getColumn(
                          ));
                case '@':
                    nextChar(
                      );
                    switch (current) {
                        case 'c':
                        case 'C':
                            start =
                              position -
                                1;
                            if (isEqualIgnoreCase(
                                  nextChar(
                                    ),
                                  'h') &&
                                  isEqualIgnoreCase(
                                    nextChar(
                                      ),
                                    'a') &&
                                  isEqualIgnoreCase(
                                    nextChar(
                                      ),
                                    'r') &&
                                  isEqualIgnoreCase(
                                    nextChar(
                                      ),
                                    's') &&
                                  isEqualIgnoreCase(
                                    nextChar(
                                      ),
                                    'e') &&
                                  isEqualIgnoreCase(
                                    nextChar(
                                      ),
                                    't')) {
                                nextChar(
                                  );
                                type =
                                  org.apache.batik.css.parser.LexicalUnits.
                                    CHARSET_SYMBOL;
                                return;
                            }
                            break;
                        case 'f':
                        case 'F':
                            start =
                              position -
                                1;
                            if (isEqualIgnoreCase(
                                  nextChar(
                                    ),
                                  'o') &&
                                  isEqualIgnoreCase(
                                    nextChar(
                                      ),
                                    'n') &&
                                  isEqualIgnoreCase(
                                    nextChar(
                                      ),
                                    't') &&
                                  isEqualIgnoreCase(
                                    nextChar(
                                      ),
                                    '-') &&
                                  isEqualIgnoreCase(
                                    nextChar(
                                      ),
                                    'f') &&
                                  isEqualIgnoreCase(
                                    nextChar(
                                      ),
                                    'a') &&
                                  isEqualIgnoreCase(
                                    nextChar(
                                      ),
                                    'c') &&
                                  isEqualIgnoreCase(
                                    nextChar(
                                      ),
                                    'e')) {
                                nextChar(
                                  );
                                type =
                                  org.apache.batik.css.parser.LexicalUnits.
                                    FONT_FACE_SYMBOL;
                                return;
                            }
                            break;
                        case 'i':
                        case 'I':
                            start =
                              position -
                                1;
                            if (isEqualIgnoreCase(
                                  nextChar(
                                    ),
                                  'm') &&
                                  isEqualIgnoreCase(
                                    nextChar(
                                      ),
                                    'p') &&
                                  isEqualIgnoreCase(
                                    nextChar(
                                      ),
                                    'o') &&
                                  isEqualIgnoreCase(
                                    nextChar(
                                      ),
                                    'r') &&
                                  isEqualIgnoreCase(
                                    nextChar(
                                      ),
                                    't')) {
                                nextChar(
                                  );
                                type =
                                  org.apache.batik.css.parser.LexicalUnits.
                                    IMPORT_SYMBOL;
                                return;
                            }
                            break;
                        case 'm':
                        case 'M':
                            start =
                              position -
                                1;
                            if (isEqualIgnoreCase(
                                  nextChar(
                                    ),
                                  'e') &&
                                  isEqualIgnoreCase(
                                    nextChar(
                                      ),
                                    'd') &&
                                  isEqualIgnoreCase(
                                    nextChar(
                                      ),
                                    'i') &&
                                  isEqualIgnoreCase(
                                    nextChar(
                                      ),
                                    'a')) {
                                nextChar(
                                  );
                                type =
                                  org.apache.batik.css.parser.LexicalUnits.
                                    MEDIA_SYMBOL;
                                return;
                            }
                            break;
                        case 'p':
                        case 'P':
                            start =
                              position -
                                1;
                            if (isEqualIgnoreCase(
                                  nextChar(
                                    ),
                                  'a') &&
                                  isEqualIgnoreCase(
                                    nextChar(
                                      ),
                                    'g') &&
                                  isEqualIgnoreCase(
                                    nextChar(
                                      ),
                                    'e')) {
                                nextChar(
                                  );
                                type =
                                  org.apache.batik.css.parser.LexicalUnits.
                                    PAGE_SYMBOL;
                                return;
                            }
                            break;
                        default:
                            if (!org.apache.batik.css.parser.ScannerUtilities.
                                  isCSSIdentifierStartCharacter(
                                    (char)
                                      current)) {
                                throw new org.apache.batik.css.parser.ParseException(
                                  "identifier.character",
                                  reader.
                                    getLine(
                                      ),
                                  reader.
                                    getColumn(
                                      ));
                            }
                            start =
                              position -
                                1;
                    }
                    do  {
                        nextChar(
                          );
                        while (current ==
                                 '\\') {
                            nextChar(
                              );
                            escape(
                              );
                        }
                    }while(current !=
                             -1 &&
                             org.apache.batik.css.parser.ScannerUtilities.
                             isCSSNameCharacter(
                               (char)
                                 current)); 
                    type =
                      org.apache.batik.css.parser.LexicalUnits.
                        AT_KEYWORD;
                    return;
                case '!':
                    do  {
                        nextChar(
                          );
                    }while(current !=
                             -1 &&
                             org.apache.batik.css.parser.ScannerUtilities.
                             isCSSSpace(
                               (char)
                                 current)); 
                    if (isEqualIgnoreCase(
                          current,
                          'i') &&
                          isEqualIgnoreCase(
                            nextChar(
                              ),
                            'm') &&
                          isEqualIgnoreCase(
                            nextChar(
                              ),
                            'p') &&
                          isEqualIgnoreCase(
                            nextChar(
                              ),
                            'o') &&
                          isEqualIgnoreCase(
                            nextChar(
                              ),
                            'r') &&
                          isEqualIgnoreCase(
                            nextChar(
                              ),
                            't') &&
                          isEqualIgnoreCase(
                            nextChar(
                              ),
                            'a') &&
                          isEqualIgnoreCase(
                            nextChar(
                              ),
                            'n') &&
                          isEqualIgnoreCase(
                            nextChar(
                              ),
                            't')) {
                        nextChar(
                          );
                        type =
                          org.apache.batik.css.parser.LexicalUnits.
                            IMPORTANT_SYMBOL;
                        return;
                    }
                    if (current ==
                          -1) {
                        throw new org.apache.batik.css.parser.ParseException(
                          "eof",
                          reader.
                            getLine(
                              ),
                          reader.
                            getColumn(
                              ));
                    }
                    else {
                        throw new org.apache.batik.css.parser.ParseException(
                          "character",
                          reader.
                            getLine(
                              ),
                          reader.
                            getColumn(
                              ));
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
                    type =
                      number(
                        );
                    return;
                case '.':
                    switch (nextChar(
                              )) {
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
                            type =
                              dotNumber(
                                );
                            return;
                        default:
                            type =
                              org.apache.batik.css.parser.LexicalUnits.
                                DOT;
                            return;
                    }
                case 'u':
                case 'U':
                    nextChar(
                      );
                    switch (current) {
                        case '+':
                            boolean range =
                              false;
                            for (int i =
                                   0;
                                 i <
                                   6;
                                 i++) {
                                nextChar(
                                  );
                                switch (current) {
                                    case '?':
                                        range =
                                          true;
                                        break;
                                    default:
                                        if (range &&
                                              !org.apache.batik.css.parser.ScannerUtilities.
                                              isCSSHexadecimalCharacter(
                                                (char)
                                                  current)) {
                                            throw new org.apache.batik.css.parser.ParseException(
                                              "character",
                                              reader.
                                                getLine(
                                                  ),
                                              reader.
                                                getColumn(
                                                  ));
                                        }
                                }
                            }
                            nextChar(
                              );
                            if (range) {
                                type =
                                  org.apache.batik.css.parser.LexicalUnits.
                                    UNICODE_RANGE;
                                return;
                            }
                            if (current ==
                                  '-') {
                                nextChar(
                                  );
                                if (!org.apache.batik.css.parser.ScannerUtilities.
                                      isCSSHexadecimalCharacter(
                                        (char)
                                          current)) {
                                    throw new org.apache.batik.css.parser.ParseException(
                                      "character",
                                      reader.
                                        getLine(
                                          ),
                                      reader.
                                        getColumn(
                                          ));
                                }
                                nextChar(
                                  );
                                if (!org.apache.batik.css.parser.ScannerUtilities.
                                      isCSSHexadecimalCharacter(
                                        (char)
                                          current)) {
                                    type =
                                      org.apache.batik.css.parser.LexicalUnits.
                                        UNICODE_RANGE;
                                    return;
                                }
                                nextChar(
                                  );
                                if (!org.apache.batik.css.parser.ScannerUtilities.
                                      isCSSHexadecimalCharacter(
                                        (char)
                                          current)) {
                                    type =
                                      org.apache.batik.css.parser.LexicalUnits.
                                        UNICODE_RANGE;
                                    return;
                                }
                                nextChar(
                                  );
                                if (!org.apache.batik.css.parser.ScannerUtilities.
                                      isCSSHexadecimalCharacter(
                                        (char)
                                          current)) {
                                    type =
                                      org.apache.batik.css.parser.LexicalUnits.
                                        UNICODE_RANGE;
                                    return;
                                }
                                nextChar(
                                  );
                                if (!org.apache.batik.css.parser.ScannerUtilities.
                                      isCSSHexadecimalCharacter(
                                        (char)
                                          current)) {
                                    type =
                                      org.apache.batik.css.parser.LexicalUnits.
                                        UNICODE_RANGE;
                                    return;
                                }
                                nextChar(
                                  );
                                if (!org.apache.batik.css.parser.ScannerUtilities.
                                      isCSSHexadecimalCharacter(
                                        (char)
                                          current)) {
                                    type =
                                      org.apache.batik.css.parser.LexicalUnits.
                                        UNICODE_RANGE;
                                    return;
                                }
                                nextChar(
                                  );
                                type =
                                  org.apache.batik.css.parser.LexicalUnits.
                                    UNICODE_RANGE;
                                return;
                            }
                        case 'r':
                        case 'R':
                            nextChar(
                              );
                            switch (current) {
                                case 'l':
                                case 'L':
                                    nextChar(
                                      );
                                    switch (current) {
                                        case '(':
                                            do  {
                                                nextChar(
                                                  );
                                            }while(current !=
                                                     -1 &&
                                                     org.apache.batik.css.parser.ScannerUtilities.
                                                     isCSSSpace(
                                                       (char)
                                                         current)); 
                                            switch (current) {
                                                case '\'':
                                                    string1(
                                                      );
                                                    blankCharacters +=
                                                      2;
                                                    while (current !=
                                                             -1 &&
                                                             org.apache.batik.css.parser.ScannerUtilities.
                                                             isCSSSpace(
                                                               (char)
                                                                 current)) {
                                                        blankCharacters++;
                                                        nextChar(
                                                          );
                                                    }
                                                    if (current ==
                                                          -1) {
                                                        throw new org.apache.batik.css.parser.ParseException(
                                                          "eof",
                                                          reader.
                                                            getLine(
                                                              ),
                                                          reader.
                                                            getColumn(
                                                              ));
                                                    }
                                                    if (current !=
                                                          ')') {
                                                        throw new org.apache.batik.css.parser.ParseException(
                                                          "character",
                                                          reader.
                                                            getLine(
                                                              ),
                                                          reader.
                                                            getColumn(
                                                              ));
                                                    }
                                                    nextChar(
                                                      );
                                                    type =
                                                      org.apache.batik.css.parser.LexicalUnits.
                                                        URI;
                                                    return;
                                                case '\"':
                                                    string2(
                                                      );
                                                    blankCharacters +=
                                                      2;
                                                    while (current !=
                                                             -1 &&
                                                             org.apache.batik.css.parser.ScannerUtilities.
                                                             isCSSSpace(
                                                               (char)
                                                                 current)) {
                                                        blankCharacters++;
                                                        nextChar(
                                                          );
                                                    }
                                                    if (current ==
                                                          -1) {
                                                        throw new org.apache.batik.css.parser.ParseException(
                                                          "eof",
                                                          reader.
                                                            getLine(
                                                              ),
                                                          reader.
                                                            getColumn(
                                                              ));
                                                    }
                                                    if (current !=
                                                          ')') {
                                                        throw new org.apache.batik.css.parser.ParseException(
                                                          "character",
                                                          reader.
                                                            getLine(
                                                              ),
                                                          reader.
                                                            getColumn(
                                                              ));
                                                    }
                                                    nextChar(
                                                      );
                                                    type =
                                                      org.apache.batik.css.parser.LexicalUnits.
                                                        URI;
                                                    return;
                                                case ')':
                                                    throw new org.apache.batik.css.parser.ParseException(
                                                      "character",
                                                      reader.
                                                        getLine(
                                                          ),
                                                      reader.
                                                        getColumn(
                                                          ));
                                                default:
                                                    if (!org.apache.batik.css.parser.ScannerUtilities.
                                                          isCSSURICharacter(
                                                            (char)
                                                              current)) {
                                                        throw new org.apache.batik.css.parser.ParseException(
                                                          "character",
                                                          reader.
                                                            getLine(
                                                              ),
                                                          reader.
                                                            getColumn(
                                                              ));
                                                    }
                                                    start =
                                                      position -
                                                        1;
                                                    do  {
                                                        nextChar(
                                                          );
                                                    }while(current !=
                                                             -1 &&
                                                             org.apache.batik.css.parser.ScannerUtilities.
                                                             isCSSURICharacter(
                                                               (char)
                                                                 current)); 
                                                    blankCharacters++;
                                                    while (current !=
                                                             -1 &&
                                                             org.apache.batik.css.parser.ScannerUtilities.
                                                             isCSSSpace(
                                                               (char)
                                                                 current)) {
                                                        blankCharacters++;
                                                        nextChar(
                                                          );
                                                    }
                                                    if (current ==
                                                          -1) {
                                                        throw new org.apache.batik.css.parser.ParseException(
                                                          "eof",
                                                          reader.
                                                            getLine(
                                                              ),
                                                          reader.
                                                            getColumn(
                                                              ));
                                                    }
                                                    if (current !=
                                                          ')') {
                                                        throw new org.apache.batik.css.parser.ParseException(
                                                          "character",
                                                          reader.
                                                            getLine(
                                                              ),
                                                          reader.
                                                            getColumn(
                                                              ));
                                                    }
                                                    nextChar(
                                                      );
                                                    type =
                                                      org.apache.batik.css.parser.LexicalUnits.
                                                        URI;
                                                    return;
                                            }
                                    }
                            }
                    }
                    while (current !=
                             -1 &&
                             org.apache.batik.css.parser.ScannerUtilities.
                             isCSSNameCharacter(
                               (char)
                                 current)) {
                        nextChar(
                          );
                    }
                    if (current ==
                          '(') {
                        nextChar(
                          );
                        type =
                          org.apache.batik.css.parser.LexicalUnits.
                            FUNCTION;
                        return;
                    }
                    type =
                      org.apache.batik.css.parser.LexicalUnits.
                        IDENTIFIER;
                    return;
                default:
                    if (current ==
                          '\\') {
                        do  {
                            nextChar(
                              );
                            escape(
                              );
                        }while(current ==
                                 '\\'); 
                    }
                    else
                        if (!org.apache.batik.css.parser.ScannerUtilities.
                              isCSSIdentifierStartCharacter(
                                (char)
                                  current)) {
                            nextChar(
                              );
                            throw new org.apache.batik.css.parser.ParseException(
                              "identifier.character",
                              reader.
                                getLine(
                                  ),
                              reader.
                                getColumn(
                                  ));
                        }
                    while (current !=
                             -1 &&
                             org.apache.batik.css.parser.ScannerUtilities.
                             isCSSNameCharacter(
                               (char)
                                 current)) {
                        nextChar(
                          );
                        while (current ==
                                 '\\') {
                            nextChar(
                              );
                            escape(
                              );
                        }
                    }
                    if (current ==
                          '(') {
                        nextChar(
                          );
                        type =
                          org.apache.batik.css.parser.LexicalUnits.
                            FUNCTION;
                        return;
                    }
                    type =
                      org.apache.batik.css.parser.LexicalUnits.
                        IDENTIFIER;
                    return;
            }
        }
        catch (java.io.IOException e) {
            throw new org.apache.batik.css.parser.ParseException(
              e);
        }
    }
    protected int string1() throws java.io.IOException {
        start =
          position;
        loop: for (;
                   ;
                   ) {
            switch (nextChar(
                      )) {
                case -1:
                    throw new org.apache.batik.css.parser.ParseException(
                      "eof",
                      reader.
                        getLine(
                          ),
                      reader.
                        getColumn(
                          ));
                case '\'':
                    break loop;
                case '\"':
                    break;
                case '\\':
                    switch (nextChar(
                              )) {
                        case '\n':
                        case '\f':
                            break;
                        default:
                            escape(
                              );
                    }
                    break;
                default:
                    if (!org.apache.batik.css.parser.ScannerUtilities.
                          isCSSStringCharacter(
                            (char)
                              current)) {
                        throw new org.apache.batik.css.parser.ParseException(
                          "character",
                          reader.
                            getLine(
                              ),
                          reader.
                            getColumn(
                              ));
                    }
            }
        }
        nextChar(
          );
        return org.apache.batik.css.parser.LexicalUnits.
                 STRING;
    }
    protected int string2() throws java.io.IOException {
        start =
          position;
        loop: for (;
                   ;
                   ) {
            switch (nextChar(
                      )) {
                case -1:
                    throw new org.apache.batik.css.parser.ParseException(
                      "eof",
                      reader.
                        getLine(
                          ),
                      reader.
                        getColumn(
                          ));
                case '\'':
                    break;
                case '\"':
                    break loop;
                case '\\':
                    switch (nextChar(
                              )) {
                        case '\n':
                        case '\f':
                            break;
                        default:
                            escape(
                              );
                    }
                    break;
                default:
                    if (!org.apache.batik.css.parser.ScannerUtilities.
                          isCSSStringCharacter(
                            (char)
                              current)) {
                        throw new org.apache.batik.css.parser.ParseException(
                          "character",
                          reader.
                            getLine(
                              ),
                          reader.
                            getColumn(
                              ));
                    }
            }
        }
        nextChar(
          );
        return org.apache.batik.css.parser.LexicalUnits.
                 STRING;
    }
    protected int number() throws java.io.IOException {
        loop: for (;
                   ;
                   ) {
            switch (nextChar(
                      )) {
                case '.':
                    switch (nextChar(
                              )) {
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
                            return dotNumber(
                                     );
                    }
                    throw new org.apache.batik.css.parser.ParseException(
                      "character",
                      reader.
                        getLine(
                          ),
                      reader.
                        getColumn(
                          ));
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
            }
        }
        return numberUnit(
                 true);
    }
    protected int dotNumber() throws java.io.IOException {
        loop: for (;
                   ;
                   ) {
            switch (nextChar(
                      )) {
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
            }
        }
        return numberUnit(
                 false);
    }
    protected int numberUnit(boolean integer)
          throws java.io.IOException { switch (current) {
                                           case '%':
                                               nextChar(
                                                 );
                                               return org.apache.batik.css.parser.LexicalUnits.
                                                        PERCENTAGE;
                                           case 'c':
                                           case 'C':
                                               switch (nextChar(
                                                         )) {
                                                   case 'm':
                                                   case 'M':
                                                       nextChar(
                                                         );
                                                       if (current !=
                                                             -1 &&
                                                             org.apache.batik.css.parser.ScannerUtilities.
                                                             isCSSNameCharacter(
                                                               (char)
                                                                 current)) {
                                                           do  {
                                                               nextChar(
                                                                 );
                                                           }while(current !=
                                                                    -1 &&
                                                                    org.apache.batik.css.parser.ScannerUtilities.
                                                                    isCSSNameCharacter(
                                                                      (char)
                                                                        current)); 
                                                           return org.apache.batik.css.parser.LexicalUnits.
                                                                    DIMENSION;
                                                       }
                                                       return org.apache.batik.css.parser.LexicalUnits.
                                                                CM;
                                                   default:
                                                       while (current !=
                                                                -1 &&
                                                                org.apache.batik.css.parser.ScannerUtilities.
                                                                isCSSNameCharacter(
                                                                  (char)
                                                                    current)) {
                                                           nextChar(
                                                             );
                                                       }
                                                       return org.apache.batik.css.parser.LexicalUnits.
                                                                DIMENSION;
                                               }
                                           case 'd':
                                           case 'D':
                                               switch (nextChar(
                                                         )) {
                                                   case 'e':
                                                   case 'E':
                                                       switch (nextChar(
                                                                 )) {
                                                           case 'g':
                                                           case 'G':
                                                               nextChar(
                                                                 );
                                                               if (current !=
                                                                     -1 &&
                                                                     org.apache.batik.css.parser.ScannerUtilities.
                                                                     isCSSNameCharacter(
                                                                       (char)
                                                                         current)) {
                                                                   do  {
                                                                       nextChar(
                                                                         );
                                                                   }while(current !=
                                                                            -1 &&
                                                                            org.apache.batik.css.parser.ScannerUtilities.
                                                                            isCSSNameCharacter(
                                                                              (char)
                                                                                current)); 
                                                                   return org.apache.batik.css.parser.LexicalUnits.
                                                                            DIMENSION;
                                                               }
                                                               return org.apache.batik.css.parser.LexicalUnits.
                                                                        DEG;
                                                       }
                                                   default:
                                                       while (current !=
                                                                -1 &&
                                                                org.apache.batik.css.parser.ScannerUtilities.
                                                                isCSSNameCharacter(
                                                                  (char)
                                                                    current)) {
                                                           nextChar(
                                                             );
                                                       }
                                                       return org.apache.batik.css.parser.LexicalUnits.
                                                                DIMENSION;
                                               }
                                           case 'e':
                                           case 'E':
                                               switch (nextChar(
                                                         )) {
                                                   case 'm':
                                                   case 'M':
                                                       nextChar(
                                                         );
                                                       if (current !=
                                                             -1 &&
                                                             org.apache.batik.css.parser.ScannerUtilities.
                                                             isCSSNameCharacter(
                                                               (char)
                                                                 current)) {
                                                           do  {
                                                               nextChar(
                                                                 );
                                                           }while(current !=
                                                                    -1 &&
                                                                    org.apache.batik.css.parser.ScannerUtilities.
                                                                    isCSSNameCharacter(
                                                                      (char)
                                                                        current)); 
                                                           return org.apache.batik.css.parser.LexicalUnits.
                                                                    DIMENSION;
                                                       }
                                                       return org.apache.batik.css.parser.LexicalUnits.
                                                                EM;
                                                   case 'x':
                                                   case 'X':
                                                       nextChar(
                                                         );
                                                       if (current !=
                                                             -1 &&
                                                             org.apache.batik.css.parser.ScannerUtilities.
                                                             isCSSNameCharacter(
                                                               (char)
                                                                 current)) {
                                                           do  {
                                                               nextChar(
                                                                 );
                                                           }while(current !=
                                                                    -1 &&
                                                                    org.apache.batik.css.parser.ScannerUtilities.
                                                                    isCSSNameCharacter(
                                                                      (char)
                                                                        current)); 
                                                           return org.apache.batik.css.parser.LexicalUnits.
                                                                    DIMENSION;
                                                       }
                                                       return org.apache.batik.css.parser.LexicalUnits.
                                                                EX;
                                                   default:
                                                       while (current !=
                                                                -1 &&
                                                                org.apache.batik.css.parser.ScannerUtilities.
                                                                isCSSNameCharacter(
                                                                  (char)
                                                                    current)) {
                                                           nextChar(
                                                             );
                                                       }
                                                       return org.apache.batik.css.parser.LexicalUnits.
                                                                DIMENSION;
                                               }
                                           case 'g':
                                           case 'G':
                                               switch (nextChar(
                                                         )) {
                                                   case 'r':
                                                   case 'R':
                                                       switch (nextChar(
                                                                 )) {
                                                           case 'a':
                                                           case 'A':
                                                               switch (nextChar(
                                                                         )) {
                                                                   case 'd':
                                                                   case 'D':
                                                                       nextChar(
                                                                         );
                                                                       if (current !=
                                                                             -1 &&
                                                                             org.apache.batik.css.parser.ScannerUtilities.
                                                                             isCSSNameCharacter(
                                                                               (char)
                                                                                 current)) {
                                                                           do  {
                                                                               nextChar(
                                                                                 );
                                                                           }while(current !=
                                                                                    -1 &&
                                                                                    org.apache.batik.css.parser.ScannerUtilities.
                                                                                    isCSSNameCharacter(
                                                                                      (char)
                                                                                        current)); 
                                                                           return org.apache.batik.css.parser.LexicalUnits.
                                                                                    DIMENSION;
                                                                       }
                                                                       return org.apache.batik.css.parser.LexicalUnits.
                                                                                GRAD;
                                                               }
                                                       }
                                                   default:
                                                       while (current !=
                                                                -1 &&
                                                                org.apache.batik.css.parser.ScannerUtilities.
                                                                isCSSNameCharacter(
                                                                  (char)
                                                                    current)) {
                                                           nextChar(
                                                             );
                                                       }
                                                       return org.apache.batik.css.parser.LexicalUnits.
                                                                DIMENSION;
                                               }
                                           case 'h':
                                           case 'H':
                                               nextChar(
                                                 );
                                               switch (current) {
                                                   case 'z':
                                                   case 'Z':
                                                       nextChar(
                                                         );
                                                       if (current !=
                                                             -1 &&
                                                             org.apache.batik.css.parser.ScannerUtilities.
                                                             isCSSNameCharacter(
                                                               (char)
                                                                 current)) {
                                                           do  {
                                                               nextChar(
                                                                 );
                                                           }while(current !=
                                                                    -1 &&
                                                                    org.apache.batik.css.parser.ScannerUtilities.
                                                                    isCSSNameCharacter(
                                                                      (char)
                                                                        current)); 
                                                           return org.apache.batik.css.parser.LexicalUnits.
                                                                    DIMENSION;
                                                       }
                                                       return org.apache.batik.css.parser.LexicalUnits.
                                                                HZ;
                                                   default:
                                                       while (current !=
                                                                -1 &&
                                                                org.apache.batik.css.parser.ScannerUtilities.
                                                                isCSSNameCharacter(
                                                                  (char)
                                                                    current)) {
                                                           nextChar(
                                                             );
                                                       }
                                                       return org.apache.batik.css.parser.LexicalUnits.
                                                                DIMENSION;
                                               }
                                           case 'i':
                                           case 'I':
                                               switch (nextChar(
                                                         )) {
                                                   case 'n':
                                                   case 'N':
                                                       nextChar(
                                                         );
                                                       if (current !=
                                                             -1 &&
                                                             org.apache.batik.css.parser.ScannerUtilities.
                                                             isCSSNameCharacter(
                                                               (char)
                                                                 current)) {
                                                           do  {
                                                               nextChar(
                                                                 );
                                                           }while(current !=
                                                                    -1 &&
                                                                    org.apache.batik.css.parser.ScannerUtilities.
                                                                    isCSSNameCharacter(
                                                                      (char)
                                                                        current)); 
                                                           return org.apache.batik.css.parser.LexicalUnits.
                                                                    DIMENSION;
                                                       }
                                                       return org.apache.batik.css.parser.LexicalUnits.
                                                                IN;
                                                   default:
                                                       while (current !=
                                                                -1 &&
                                                                org.apache.batik.css.parser.ScannerUtilities.
                                                                isCSSNameCharacter(
                                                                  (char)
                                                                    current)) {
                                                           nextChar(
                                                             );
                                                       }
                                                       return org.apache.batik.css.parser.LexicalUnits.
                                                                DIMENSION;
                                               }
                                           case 'k':
                                           case 'K':
                                               switch (nextChar(
                                                         )) {
                                                   case 'h':
                                                   case 'H':
                                                       switch (nextChar(
                                                                 )) {
                                                           case 'z':
                                                           case 'Z':
                                                               nextChar(
                                                                 );
                                                               if (current !=
                                                                     -1 &&
                                                                     org.apache.batik.css.parser.ScannerUtilities.
                                                                     isCSSNameCharacter(
                                                                       (char)
                                                                         current)) {
                                                                   do  {
                                                                       nextChar(
                                                                         );
                                                                   }while(current !=
                                                                            -1 &&
                                                                            org.apache.batik.css.parser.ScannerUtilities.
                                                                            isCSSNameCharacter(
                                                                              (char)
                                                                                current)); 
                                                                   return org.apache.batik.css.parser.LexicalUnits.
                                                                            DIMENSION;
                                                               }
                                                               return org.apache.batik.css.parser.LexicalUnits.
                                                                        KHZ;
                                                       }
                                                   default:
                                                       while (current !=
                                                                -1 &&
                                                                org.apache.batik.css.parser.ScannerUtilities.
                                                                isCSSNameCharacter(
                                                                  (char)
                                                                    current)) {
                                                           nextChar(
                                                             );
                                                       }
                                                       return org.apache.batik.css.parser.LexicalUnits.
                                                                DIMENSION;
                                               }
                                           case 'm':
                                           case 'M':
                                               switch (nextChar(
                                                         )) {
                                                   case 'm':
                                                   case 'M':
                                                       nextChar(
                                                         );
                                                       if (current !=
                                                             -1 &&
                                                             org.apache.batik.css.parser.ScannerUtilities.
                                                             isCSSNameCharacter(
                                                               (char)
                                                                 current)) {
                                                           do  {
                                                               nextChar(
                                                                 );
                                                           }while(current !=
                                                                    -1 &&
                                                                    org.apache.batik.css.parser.ScannerUtilities.
                                                                    isCSSNameCharacter(
                                                                      (char)
                                                                        current)); 
                                                           return org.apache.batik.css.parser.LexicalUnits.
                                                                    DIMENSION;
                                                       }
                                                       return org.apache.batik.css.parser.LexicalUnits.
                                                                MM;
                                                   case 's':
                                                   case 'S':
                                                       nextChar(
                                                         );
                                                       if (current !=
                                                             -1 &&
                                                             org.apache.batik.css.parser.ScannerUtilities.
                                                             isCSSNameCharacter(
                                                               (char)
                                                                 current)) {
                                                           do  {
                                                               nextChar(
                                                                 );
                                                           }while(current !=
                                                                    -1 &&
                                                                    org.apache.batik.css.parser.ScannerUtilities.
                                                                    isCSSNameCharacter(
                                                                      (char)
                                                                        current)); 
                                                           return org.apache.batik.css.parser.LexicalUnits.
                                                                    DIMENSION;
                                                       }
                                                       return org.apache.batik.css.parser.LexicalUnits.
                                                                MS;
                                                   default:
                                                       while (current !=
                                                                -1 &&
                                                                org.apache.batik.css.parser.ScannerUtilities.
                                                                isCSSNameCharacter(
                                                                  (char)
                                                                    current)) {
                                                           nextChar(
                                                             );
                                                       }
                                                       return org.apache.batik.css.parser.LexicalUnits.
                                                                DIMENSION;
                                               }
                                           case 'p':
                                           case 'P':
                                               switch (nextChar(
                                                         )) {
                                                   case 'c':
                                                   case 'C':
                                                       nextChar(
                                                         );
                                                       if (current !=
                                                             -1 &&
                                                             org.apache.batik.css.parser.ScannerUtilities.
                                                             isCSSNameCharacter(
                                                               (char)
                                                                 current)) {
                                                           do  {
                                                               nextChar(
                                                                 );
                                                           }while(current !=
                                                                    -1 &&
                                                                    org.apache.batik.css.parser.ScannerUtilities.
                                                                    isCSSNameCharacter(
                                                                      (char)
                                                                        current)); 
                                                           return org.apache.batik.css.parser.LexicalUnits.
                                                                    DIMENSION;
                                                       }
                                                       return org.apache.batik.css.parser.LexicalUnits.
                                                                PC;
                                                   case 't':
                                                   case 'T':
                                                       nextChar(
                                                         );
                                                       if (current !=
                                                             -1 &&
                                                             org.apache.batik.css.parser.ScannerUtilities.
                                                             isCSSNameCharacter(
                                                               (char)
                                                                 current)) {
                                                           do  {
                                                               nextChar(
                                                                 );
                                                           }while(current !=
                                                                    -1 &&
                                                                    org.apache.batik.css.parser.ScannerUtilities.
                                                                    isCSSNameCharacter(
                                                                      (char)
                                                                        current)); 
                                                           return org.apache.batik.css.parser.LexicalUnits.
                                                                    DIMENSION;
                                                       }
                                                       return org.apache.batik.css.parser.LexicalUnits.
                                                                PT;
                                                   case 'x':
                                                   case 'X':
                                                       nextChar(
                                                         );
                                                       if (current !=
                                                             -1 &&
                                                             org.apache.batik.css.parser.ScannerUtilities.
                                                             isCSSNameCharacter(
                                                               (char)
                                                                 current)) {
                                                           do  {
                                                               nextChar(
                                                                 );
                                                           }while(current !=
                                                                    -1 &&
                                                                    org.apache.batik.css.parser.ScannerUtilities.
                                                                    isCSSNameCharacter(
                                                                      (char)
                                                                        current)); 
                                                           return org.apache.batik.css.parser.LexicalUnits.
                                                                    DIMENSION;
                                                       }
                                                       return org.apache.batik.css.parser.LexicalUnits.
                                                                PX;
                                                   default:
                                                       while (current !=
                                                                -1 &&
                                                                org.apache.batik.css.parser.ScannerUtilities.
                                                                isCSSNameCharacter(
                                                                  (char)
                                                                    current)) {
                                                           nextChar(
                                                             );
                                                       }
                                                       return org.apache.batik.css.parser.LexicalUnits.
                                                                DIMENSION;
                                               }
                                           case 'r':
                                           case 'R':
                                               switch (nextChar(
                                                         )) {
                                                   case 'a':
                                                   case 'A':
                                                       switch (nextChar(
                                                                 )) {
                                                           case 'd':
                                                           case 'D':
                                                               nextChar(
                                                                 );
                                                               if (current !=
                                                                     -1 &&
                                                                     org.apache.batik.css.parser.ScannerUtilities.
                                                                     isCSSNameCharacter(
                                                                       (char)
                                                                         current)) {
                                                                   do  {
                                                                       nextChar(
                                                                         );
                                                                   }while(current !=
                                                                            -1 &&
                                                                            org.apache.batik.css.parser.ScannerUtilities.
                                                                            isCSSNameCharacter(
                                                                              (char)
                                                                                current)); 
                                                                   return org.apache.batik.css.parser.LexicalUnits.
                                                                            DIMENSION;
                                                               }
                                                               return org.apache.batik.css.parser.LexicalUnits.
                                                                        RAD;
                                                       }
                                                   default:
                                                       while (current !=
                                                                -1 &&
                                                                org.apache.batik.css.parser.ScannerUtilities.
                                                                isCSSNameCharacter(
                                                                  (char)
                                                                    current)) {
                                                           nextChar(
                                                             );
                                                       }
                                                       return org.apache.batik.css.parser.LexicalUnits.
                                                                DIMENSION;
                                               }
                                           case 's':
                                           case 'S':
                                               nextChar(
                                                 );
                                               return org.apache.batik.css.parser.LexicalUnits.
                                                        S;
                                           default:
                                               if (current !=
                                                     -1 &&
                                                     org.apache.batik.css.parser.ScannerUtilities.
                                                     isCSSIdentifierStartCharacter(
                                                       (char)
                                                         current)) {
                                                   do  {
                                                       nextChar(
                                                         );
                                                   }while(current !=
                                                            -1 &&
                                                            org.apache.batik.css.parser.ScannerUtilities.
                                                            isCSSNameCharacter(
                                                              (char)
                                                                current)); 
                                                   return org.apache.batik.css.parser.LexicalUnits.
                                                            DIMENSION;
                                               }
                                               return integer
                                                 ? org.apache.batik.css.parser.LexicalUnits.
                                                     INTEGER
                                                 : org.apache.batik.css.parser.LexicalUnits.
                                                     REAL;
                                       } }
    protected void escape() throws java.io.IOException {
        if (org.apache.batik.css.parser.ScannerUtilities.
              isCSSHexadecimalCharacter(
                (char)
                  current)) {
            nextChar(
              );
            if (!org.apache.batik.css.parser.ScannerUtilities.
                  isCSSHexadecimalCharacter(
                    (char)
                      current)) {
                if (org.apache.batik.css.parser.ScannerUtilities.
                      isCSSSpace(
                        (char)
                          current)) {
                    nextChar(
                      );
                }
                return;
            }
            nextChar(
              );
            if (!org.apache.batik.css.parser.ScannerUtilities.
                  isCSSHexadecimalCharacter(
                    (char)
                      current)) {
                if (org.apache.batik.css.parser.ScannerUtilities.
                      isCSSSpace(
                        (char)
                          current)) {
                    nextChar(
                      );
                }
                return;
            }
            nextChar(
              );
            if (!org.apache.batik.css.parser.ScannerUtilities.
                  isCSSHexadecimalCharacter(
                    (char)
                      current)) {
                if (org.apache.batik.css.parser.ScannerUtilities.
                      isCSSSpace(
                        (char)
                          current)) {
                    nextChar(
                      );
                }
                return;
            }
            nextChar(
              );
            if (!org.apache.batik.css.parser.ScannerUtilities.
                  isCSSHexadecimalCharacter(
                    (char)
                      current)) {
                if (org.apache.batik.css.parser.ScannerUtilities.
                      isCSSSpace(
                        (char)
                          current)) {
                    nextChar(
                      );
                }
                return;
            }
            nextChar(
              );
            if (!org.apache.batik.css.parser.ScannerUtilities.
                  isCSSHexadecimalCharacter(
                    (char)
                      current)) {
                if (org.apache.batik.css.parser.ScannerUtilities.
                      isCSSSpace(
                        (char)
                          current)) {
                    nextChar(
                      );
                }
                return;
            }
        }
        if (current >=
              ' ' &&
              current <=
              '~' ||
              current >=
              128) {
            nextChar(
              );
            return;
        }
        throw new org.apache.batik.css.parser.ParseException(
          "character",
          reader.
            getLine(
              ),
          reader.
            getColumn(
              ));
    }
    protected static boolean isEqualIgnoreCase(int i,
                                               char c) {
        return i ==
          -1
          ? false
          : java.lang.Character.
          toLowerCase(
            (char)
              i) ==
          c;
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
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1bCXAcxRXtXZ2WrMPyfcingNiYXcwRIDKHLWQjWMvCspVE" +
       "BuTRbEsaa3ZmPNMrrwUOmBSxQnEFjDkCrhzmPuwiUJDiiCkSjnBUYZxwuIAQ" +
       "UuZwnNhFAhQkkP+7Z3dmZ3dGtQkbVU3P7HT/7v9f/6t7WvcfImWWSWZSjUXY" +
       "JoNakVaNdUimReMtqmRZq+Fdj3xTifTJRR+2nxYm5d2kdkCyVsiSRZcpVI1b" +
       "3aRR0SwmaTK12imNI0WHSS1qDklM0bVuMlGx2hKGqsgKW6HHKTbokswYGScx" +
       "Ziq9SUbb7A4YaYwBJ1HOSXSJt7o5RsbKurHJaT7F1bzFVYMtE85YFiP1sfXS" +
       "kBRNMkWNxhSLNadMcqyhq5v6VZ1FaIpF1qsn2xCcGzs5B4K5u+s+/fK6gXoO" +
       "wXhJ03TGxbNWUUtXh2g8Ruqct60qTVgbyA9ISYxUuxoz0hRLDxqFQaMwaFpa" +
       "pxVwX0O1ZKJF5+KwdE/lhowMMTInuxNDMqWE3U0H5xl6qGS27JwYpJ2dkVZI" +
       "mSPijcdGt910Uf1DJaSum9QpWieyIwMTDAbpBkBpopea1pJ4nMa7yTgNJruT" +
       "moqkKsP2TDdYSr8msSRMfxoWfJk0qMnHdLCCeQTZzKTMdDMjXh9XKPtXWZ8q" +
       "9YOskxxZhYTL8D0IWKUAY2afBHpnk5QOKlqckVleioyMTedBAyCtSFA2oGeG" +
       "KtUkeEEahIqoktYf7QTV0/qhaZkOCmgyMs23U8TakORBqZ/2oEZ62nWIKmg1" +
       "hgOBJIxM9DbjPcEsTfPMkmt+DrUvvuZi7RwtTELAc5zKKvJfDUQzPUSraB81" +
       "KdiBIBy7ILZdmvTkSJgQaDzR01i0efSSI2ctnLnnedFmep42K3vXU5n1yDt7" +
       "a1+d0TL/tBJko9LQLQUnP0tybmUddk1zygAPMynTI1ZG0pV7Vj37/cvupQfD" +
       "pKqNlMu6mkyAHo2T9YShqNRcTjVqSozG28gYqsVbeH0bqYDnmKJR8XZlX59F" +
       "WRspVfmrcp3/Boj6oAuEqAqeFa1PTz8bEhvgzymDEFIBFxkLVxMRf/zOSFd0" +
       "QE/QqCRLmqLp0Q5TR/mtKHicXsB2INoLWj8YtfSkCSoY1c3+qAR6MEDtCtmy" +
       "0DLBEUY7oQ8QJIL6ZRSt5xTKNH5jKARwz/Aauwp2co6uxqnZI29LLm098mDP" +
       "i0KRUPltNBiZB4NFxGARPlgEBouIwSL2YCQU4mNMwEHFdMJkDIJZg18dO7/z" +
       "wnPXjcwtAT0yNpYCkiXQdG5WfGlxbD/tsHvkXQ01w3PeWfRMmJTGSIMks6Sk" +
       "YrhYYvaDI5IHbVsd2wuRxwkAs10BACOXqcs0Dv7HLxDYvVTqQ9TE94xMcPWQ" +
       "Dk9oiFH/4JCXf7Ln5o1bui49PkzC2T4fhywDd4XkHeipMx65yWvr+fqt2/rh" +
       "p7u2b9Ydq88KIunYl0OJMsz1aoEXnh55wWzpkZ4nNzdx2MeAV2YSWBE4vJne" +
       "MbKcSnPaQaMslSBwn24mJBWr0hhXsQFT3+i84eo5jj9PALWoRitrgKvTNjt+" +
       "x9pJBpaThTqjnnmk4AHg9E7j9jde+ehEDnc6VtS5gnwnZc0u/4SdNXBPNM5R" +
       "29UmpdDu7Zs7brjx0Na1XGehxbx8AzZh2QJ+CaYQYL7i+Q1vvvvOzn3hjJ6H" +
       "GAToZC/kOamMkPieVAUICaMd7fAD/k0FT4Ba07RGA/1U+hSpV6VoWP+qO2rR" +
       "I3+9pl7ogQpv0mq0cPQOnPdTl5LLXrzos5m8m5CM8dXBzGkmnPZ4p+clpilt" +
       "Qj5SW/Y23vKcdDu4f3C5ljJMuRcNCQy45FMYqeWUig6hSAKfw+fyZF55PC9P" +
       "yiVZEOR6eLLSmpKpgdzx7k7D4ijLbUbZlurKqHrk6/Ydruk6/NQRLnd2SubW" +
       "mhWS0SwUFYujU9D9ZK+bO0eyBqDdSXvaL6hX93wJPXZDjzK4amulicJm6Zjd" +
       "uqziraefmbTu1RISXkaqVF2KL5O4uZIxYCfUGgDfnDLOPEuoycZKKOrxKUUy" +
       "eBGOF0nlvMCpmpVfCVoTBuPTNvzY5IcX37XjHa6vBu+iMdcWJVtNpfy2iOUx" +
       "WBybq+F+pJ5JD3Oew+lJH5/WkzbNSDLIuqjtH6GuntdhOhYR6Rjn4rz8WoQ/" +
       "v8MbnI/FMl6/GIvlArAz/0ts8UWrL2CaLbVWOGB+pP7ytfNe144GwIVYdDkA" +
       "fPebAEBUTOcvKzHByIrofCnoBJV7XzvlD3f9ZPtGkUzO94+kHropX6xUey//" +
       "8+c5RspjaJ5E10PfHb3/tmktZxzk9E4wQ+qmVG5SBAmBQ3vCvYl/hueW/y5M" +
       "KrpJvWwvvbokNYkhohuWG1Z6PQbLs6z67KWDyJObM8F6hjeQuob1hlEnGYNn" +
       "bI3PNZ7IWYvzcgxc820Nmu9VvhDhD4rQP14uwOK4dKAaY5g6Ay5p3BOragK6" +
       "hfhmcm/u77G5/wFrbufZgDIMRisCgGMOXCXXj6aScra00+CK2GxFfKRljrWp" +
       "uUL5UTNSISdNyGtYdpqKqWBnsteClFJJQAYxZK+lTuhYJ480dfxFqPbUPASi" +
       "3cS7o1d3vb7+JZ6fVGLSujo9na6UFJJbV3JUL9j+Gv5CcH2FF7KLL/AOetZi" +
       "L4xmZ1ZGhoFBKsDGPAJENze8O3jbhw8IAbwG5WlMR7Zd+XXkmm0i6RDL63k5" +
       "K1w3jVhiC3GwuAS5mxM0CqdY9sGuzY/fvXmr4Kohe7HYqiUTD/zx3y9Fbv7T" +
       "C3nWLCWKvUXiTiogbcyeGyHQ2T+ue+K6hpJlkO62kcqkpmxI0rZ4tuFVWMle" +
       "12Q5y3bHGG3RcGIYCS2AOfAoeLJABV8I14m2ip7oo+BXBSq4HzVYbW+yD1L3" +
       "7G2+jLryxE6Ac0H1s7+xfnngITEJ+YzBs7Fw912V8v7Es9wYcLDhDFvTkYtZ" +
       "cN1ns3WfUOD+/3HpC2SJ6BA6XdwxUxISw/S2Axb0Z8Mj98bpVfb/ayhU8KP8" +
       "zc+F7447571y6Y557/GMsVKxIBCAA8iz6eOiOXz/uwf31jQ+yNdnpehHbLXM" +
       "3i3L3QzL2uPis1OHxTahmJts28TbD1zPlzNSKg/YC2VPdjGSyrEyrsmiW1tJ" +
       "f5Y/5oTxMcIg2imapHJ2LgHNVKnWL/ZitmBxi+EMkTdR5Mlgi6prFOciXTch" +
       "nURmtiOhMpdZkzRmJS0rOEBOBvB27fXv/7qpf2khOxD4buYoewz4exbM8gJ/" +
       "JfGy8tzlH09bfcbAugI2E2Z5dMjb5T0r7n9h+dHy9WG+4ylSk5yd0myi5my/" +
       "WGVSljS1bE84T8w+nz1Xussn2JOopjNK/P1QQN3DWOwCXZFxooVeBDR/1Ddl" +
       "Jfm12OOqry7QVaNrO9X2aqf6uOonAl21HzXL3q642MPokwUyOhmu0+2hTvdh" +
       "9JlARv2omZOcepn8bYFMToFrqT3MUh8mfx/IpB81KBCoscnycfligVxOgmu5" +
       "Pc5yHy5fDeTSjxrSF6rF8/G4t0Ae58K1wh5lhQ+PbwTy6EfNSF0veN7BFggM" +
       "4BbtBYCX3zcD+E3lWwnzv3Li2Xh3jetachKMso1+30Z4Crnz8m074ivvWJRO" +
       "Rn4IyxymG8epdIiqrq4m8Of7MmzUpSd42GZj2AueI6jfWt6PNMBtHQyoO4TF" +
       "AVia9FOG3zk43A7SH3xjOxoeFNAYt9iibCkcBT/SAEk/D6j7AotPYBYBBfHl" +
       "x4PDP4qAA27qcBc/YgszUjgOfqT+sobKAuoqsCACh6U8lcdWN2RwCIWKpQ8Y" +
       "Qa61hbm2cBz8SANkbQiom4BFDQRJwKEz49kdGGqLBcNEuLbbsmwvHAY/0gBR" +
       "ZwXUzcFiGiTPAEOrHTocEKYXAQS+29kI1+22JLcXDoIfaYCgCwPqIlgcw0i1" +
       "rFLJFFaRdzEzpCtxB51vFUtFMH7cY4t4T+Ho+JEGILA4oO4MLE4R8SOdrrt0" +
       "5NRi+c3ZcO22RdldOAp+pAGStgXUnYfF2YzUcn+BHxD4oh2btjtgtBbLYGbA" +
       "9Zgt0WOFg+FHGiBwl6fO+2Ug9D0szmekypIlbQlbleTnI0LHO2isKpaBjIdr" +
       "vy3S/sLR8CMNQEMeDQ0u+0XgIzRYj3tMpKdYJoIp1gFbmAOj4JAnRfcjDcAh" +
       "YO0cwkwiNAixBNYgyyXDA4JaBBD4UmUmzEOV6FPcCwLBlzRA0M2jKcOlWKQg" +
       "yUJlWK0PUs1jGZuKpRFTCSmZIvoU94LA8CUNAOPK/GDw31nfZFdmfXEPXYXF" +
       "FRBWLO5NF3nU5UfFRGixLebiwhHyIw1A6BZfdQldzRv8FIttGShO8EBxYxHd" +
       "R8k6W551hUPhRxoAxZ2jQXE3Fj8HH6Il8XyoB4lfFHGNVpKyxUkVjoQfaQAS" +
       "vxoNiUeweBB8SFxn7fnA2FUsMCDXKNlqS7S1cDD8SAP8RMAHhIpeXYesXMvn" +
       "bEdSHKk9o0H5HBaPQ6YilGqNpngj9BPFCk6gWKWvij7FvSAsfUkDFGvvaGjs" +
       "w+JlDNOQuBnenO2VIiCBqz38Vl5WIvoUdx8keOn92JMAdi1+gtxzxGBCQK8e" +
       "IMJOd3y38VaOxnsBUL6PxVuMjFOs1g1JSW3r13STtojPZqGnHdD2F8sUp4FY" +
       "1bZ41QWrjy9pgMx/G019DmPxESOVmNvgJq7HlD7+Rg4IgeHbB4TxPNqUnP82" +
       "ECfk5Qd31FVO3rHmdfFBM32KfWyMVPYlVdV9/sX1XG6YtE/h8I0Vp2H4F/fQ" +
       "54xMDzg2iCcy+QMyHfpM0HzJyIR8NIyUQOlu+RUj9d6WjJTxu6tdOAR+ymkH" +
       "g4oHd5NS6B2a4GOZkU60XAfcxKGhlPCt091Q853OiaPNkGuXfF7WZ0b+vyHp" +
       "T4JJ8d8hPfKuHee2X3zk23eI07OyKg0PYy/VMVIhDvLyTvGz4hzf3tJ9lZ8z" +
       "/8va3WOOSu+7jxMMO6o+3dFV0gqKaaB+TPMcLbWaMidM39y5+KmXR8r3hklo" +
       "LQlJkJCuzT1elTKSJmlcG8s95NElmfzMa/P8WzedsbDv7/v5kUcivgDP8G/f" +
       "I++768LXrp+yc2aYVLeRMkWL0xQ/93X2Jm0VlYfMblIDbiUFLEIvCjgX9wmS" +
       "WlRlCZNBjosNZ03mLZ69ZmRu7uGZ3BPrVaq+kZpL9aTY3auJkWrnjZgZz5fZ" +
       "pGF4CJw39lRiuXUDD9Q4G6CPPbEVhpE+W1SxxuCGPJI/aqPiTuGP+DT1P+Mc" +
       "4Jw3NgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "WJ0hPYpQR3VoeIobbXSVVppTqzbL5kuJ");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "TL/4+l97+y+/9I38sOj/BVvi/oleQgAA");
}
