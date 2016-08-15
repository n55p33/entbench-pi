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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "3as3NgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "w+sB5bKCPAZK3QjQbduH8l93AxV96uqxqpslqMfu/qH/zZjCe//0L64wgzxK" +
       "nZKX7fVfQp/5pYext38n738cLrLej8ZXxnCQzB/3rXza+p9nHj/3W2cKdywL" +
       "F8XdSmHKm1HmhJcgOw4Olw9gNXFZ/eWZ7jate+YoHL5+P1SdmHY/UB3nDuA6" +
       "a51dn9+LTfdmXP5xcDy1E/9T+5pzUMgvfmqrPHn5ZFb8+GEouMv1nRBQKUu7" +
       "aPDX4O8AHH+VHdlw2Y3sDLBhu9zxsaPk0QWJzTk/951X94+5fwHmR+exV0uB" +
       "lW3d7bFe57r1zuvp1vxy5A+D49IO+aWrINeugjy73KZ1Qli4Q4x8kDKE11ZR" +
       "1tcsEKPXu9Qfev7+bxq/9O1f26b1+/q411h+34s/+9eXPvDimROLqSeuWM+c" +
       "7LNdUOUUvionM/Pxb7zWLHmP7n/73PP/9leff2FL1f2XLw06YOX7a3/wl1+9" +
       "9LE/+d1TMtSzYNm3JxL9BkXyFnBUdyKpXkUk8SsRyTkhUkAeBzC/6eoSyYP9" +
       "lsEv/bMnfu9dLz3xX/Iod6cWANNCfPWUVd+JPt//zDe/8/VXPfLZPKe8TeCD" +
       "rZHtL5evXA1ftsjNKb7niA05cx4AcO7dcmF7Dgv6Ta5MsqcR/CaENAsseSHR" +
       "AS4FCjVFgcZEt9vWfDmL0snhOuj/42xbcdo7Hc1OICu/TVztno/sZ1DzrHj3" +
       "oS68cLounMkufyIELlGzefNIJ0zZVrfrSy8r3uXG1w75eVjHTMeWs+TysO6B" +
       "w3Tg6BELqIyvINYvPH11zaNyBTiOGV9+758/PH776rkbWFW9YU8x94f8FPWZ" +
       "3+29WfzwmcLZowhyxfOXyzs9c3ncOO/LYeTb48uixyNb/uf8O5FS5CzeSwYO" +
       "w3j2+2PXqPvFrPgIkJaYsXormWs0/3hc2PMyyQ16mdeBo7nzMs2reJl//Eq8" +
       "zGXLLm+Pqn9yg1S9Fhxv21H1tqtQ9SuvhKqjeL9P0a/eIEUPgQPdUYRehaLP" +
       "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" +
       "TMGbegWiu0OkP5chLVwP4k4LsyPW0Del");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "/ZWXvpFvFv2/y9trAF5CAAA=");
}
