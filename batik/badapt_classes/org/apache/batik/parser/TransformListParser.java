package org.apache.batik.parser;
public class TransformListParser extends org.apache.batik.parser.NumberParser {
    protected org.apache.batik.parser.TransformListHandler transformListHandler;
    public TransformListParser() { super();
                                   transformListHandler = org.apache.batik.parser.DefaultTransformListHandler.
                                                            INSTANCE;
    }
    public void setTransformListHandler(org.apache.batik.parser.TransformListHandler handler) {
        transformListHandler =
          handler;
    }
    public org.apache.batik.parser.TransformListHandler getTransformListHandler() {
        return transformListHandler;
    }
    protected void doParse() throws org.apache.batik.parser.ParseException,
        java.io.IOException { transformListHandler.
                                startTransformList(
                                  );
                              loop: for (; ; ) { try {
                                                     current =
                                                       reader.
                                                         read(
                                                           );
                                                     switch (current) {
                                                         case 13:
                                                         case 10:
                                                         case 32:
                                                         case 9:
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
                                                         case -1:
                                                             break loop;
                                                         default:
                                                             reportUnexpectedCharacterError(
                                                               current);
                                                             skipTransform(
                                                               );
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
                              skipSpaces(
                                );
                              if (current !=
                                    -1) {
                                  reportError(
                                    "end.of.stream.expected",
                                    new java.lang.Object[] { new java.lang.Integer(
                                      current) });
                              }
                              transformListHandler.
                                endTransformList(
                                  ); }
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
                              transformListHandler.
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
                                      transformListHandler.
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
                              transformListHandler.
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
                                      transformListHandler.
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
                              transformListHandler.
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
                                      transformListHandler.
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
                              transformListHandler.
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
                                  transformListHandler.
                                    skewX(
                                      sk);
                              }
                              else {
                                  transformListHandler.
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
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
