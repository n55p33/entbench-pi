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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "BQmcZ0P3O3rdP35IirGWgOTFK4LkV9icwQpCQDLCxgKIPD9RiLSCOmcdtc6O" +
       "H5FirCUQOVv8ICjB+B02r3FSZ4+oZjahBwB5/f8BSAaSXoHrUKzjZ+S9c5Hv" +
       "CZTHjjdUTT9+669FhZG9y6+FWiGZ1jR/pel7rjAtlpRJolbWnab4+SOcWook" +
       "abx7Eg9i8W9L+nc4aQzSc1Iufv1074J3eXQgSj74SS5wUgYk+PgX0z0CtBc7" +
       "MaxL4xskCU8mlFsGZvdk6uX2xFc5tuUc18V7MLfoScs3YXHl5PG163Zd/MQD" +
       "8kZQ0ejOnShlcoxUysvJbOE0v6g0V1bFmoWX6h+vvto9LTfJBXsWPstnop1g" +
       "jyZawczAdZndnr01e+PEiqdf3F/xMhQGm0mIgiVtzr+uyJhpqFg3x7ya1fce" +
       "VdzjdSz8xo6VS5J//a24ECJ510BB+rjy6oO3v3JoxomWMJncQ8qhEGAZcY9y" +
       "8w59A1NGrQFSp9rdGVgiSFGp1kOq0rq6Pc16EjFSjwZL8Q2ZwMWBsy7bi/fJ" +
       "nLTmFzj5t/A1mjHGrFVGWk+gmDoocr0et4DOqT3Tphlg8HqyWzklX/e4cvNX" +
       "Gp482Fy2GpwuRx2/+Eo7PZita/3v7ESHrMewSWVwn8H647Fe03RLscq7TOEF" +
       "ISJpsJ+T0CLZGwhUIXH1HQqLR2zK/wdh/ufMjh8AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "z7rcmZXn0uJndt33pOPaPpBSkXc8+Cfgdwxc/5teKbu0YrMEX4fv5AF37CUC" +
       "DliUXucfXHxaoiUDkozZ633ozS9rxdrptIl+aVlMi/s3IqGXtLWfS4tGdAzg" +
       "uLy4XdnOp8+di2O9LL19E4hXXpZHgx5zzRLNTKMNH/iOKZ3bxTcC8gNjO6eb" +
       "lV0cZzM/Sad1e5OMHpG18bJlBX5wep8ZbYO89v3f/cDXfuPuZ4GxUtDl69SQ" +
       "gI0eGJEJ0lT/V5/80K1XPfqd92fhF0ze6JdfuPn+lOvoxRCnBZsWvV2oN6dQ" +
       "+SyLoUXP72YRU5EztC/qoz1XW4KFZb2Tx8IPXPes8ZHvfWqTox51yCPEysOP" +
       "/tpPth95dOvAm8HdFyTnB/ts3g4yoa/Z0bAL3flio2Q9iH956oHPf+KBhzZS" +
       "XXc4z22C17hP/d3/fG37se985SLp1XHTfhUT65/+bKvkteu7P3ok4Gh92I+s" +
       "AFFYBWkEVbTVqiPTSbtd8bFF3C9oDSPoJ7q0iAN22LINulVM1pN5I5FK3W6l" +
       "gOClBV+oU7o6bDc5nVdtY9Qd4EPVGVErdETYttYc2ejYwhbFSCcmWL/BD4VZ" +
       "v6nP4Xlv1k1YOKiv4E4RxCcrgGG4ApdhWIVrtSSKF8JgRixNlbXhsMWLSbuW" +
       "L1fK7DjpUzLpTnxdrk9GuVJgI/BMsiqyPib47rCxUsuWvCrgM3ckCqZbb8VY" +
       "NPITa0SMxfU0jrFWKz/2UKPAu+aqXGeM1dJFnGbEjEYDRYy5aXMZayM7zA+l" +
       "ki8PGsx4WtUXVBftjlRq1AmNompIFVvrj71hKCO60UUSYzIr9QEPVKotJaYr" +
       "FvOjpjiYMCOtKgyXiGzQND1laE7mUBdrx0mjXQvyAldqisUeXdUwez5L1EXe" +
       "a6mRR2CE3J8MlNKwCyshGTXI4pgiSSsEPl8w3Q5iVHMDT9WECt5bOg1kOVBX" +
       "BC92w5UY+P1w7LpFpsz6IxNvjUudsoWPWhhmdZMeMaZ4rTyVupOClvC4qulB" +
       "GS/OONlEx+OyaVq20yIMqYdUimZ14psOSdaZjlruxWhrMRyFS5Kr18mxw41n" +
       "gjU1mnwYc5SaLwZoTej4k6EloSxTW6+MJoqS7myucsNKPhaTiAqVkYv3bCoY" +
       "jVxVFeQRjdtMDDtDixnYzcCoJDI1BFFXyA1pjFSnI4HnnCJawbqk2SpguJws" +
       "okhoyR7c4Ab1sWNqc0ZvD/QR5dQwbLkaUyLBzbW12CgrZoMjnGBRJ0SrG3od" +
       "lY+YlRFztjxt4fmYYyRLLeGr8QLHaCrqNoQ2xc8wuhuyFZQJ5njOH7cYzXRr" +
       "rQZV77sDHSNCeNTDVuK4zgBxlty4nuQ4nR7TU2Pu+J15UQ0NrLQysKlhJWG1" +
       "Jq9Jk4pzRmIshXFdcAuLWjANg15Hk1plsygg9CyOGpTcF/qrouYEc7tihZ6O" +
       "Wg7O6JzNC6Yzbi8iAqn2eNJCasWk2vPWA9wp882RtiLNYRFrDaarftccM+OZ" +
       "FFqj5dDLc73VWCjbRtCtoVhHaZcd1mFrZZShlnBT6RrGYNIfk7l6laOGzSZn" +
       "co2kvFIYJrIMmFKrQhjhPDmq4uNClcyrVY3JsbLBtwYCTzft0WoVlJtKMWkw" +
       "g7lu0E2S63tqmW1Me0N9KPvtcRHHh1JX1MxOuCi2lg1KtycFIW/nRwW2aE47" +
       "07AcBoqHMyuBVZqJQDRaq6qAt6cYLPsNlJnjM2YqjqeEILFCpBQmSOTNF3Te" +
       "bXBkP8qzhNE18jPDwZqROOyzpGaEHW5JREQ0kFodNJlhVDvXCDiiU/F6cNEf" +
       "rREfFbG5YOpGiKkUiTDxwJcnRhTWEVNiZVPykV4uECc9tbs0SHK5xI3aoCEz" +
       "bScZNutDW5AmcUlW67HhSFN0bfD14jQfF7BpPaB4jxuofMeI+86SgIWoWx2a" +
       "YT6alkW6X8prWmlu0eUis5CXFTScCFpTQrrYwDTYKZcIuQTHhZgpKEmdJCh6" +
       "5rFwFYuVXkUXqyKFg7ARS8uuQrEuR7p8sz0oRALTzimanisEBaQ+WSD9pdkL" +
       "6YXWpKUmKtkUo0ZBaShIqyGmMippl1CSksKS5E+ridscz0SKKlsLwuzKJhLa" +
       "pVJFM6uSNRY0tlAUGdkRuHrQJxsVYVarIMsCnCsrXRwkhy2mp/HzBNZbs3JJ" +
       "lTpif9pfVb2oaFeH0zxdQF0WdvtxxSvGIHBpuogbyFRf5icRvp5ydgONi0px" +
       "DbfGQZ9dq3q+gqJ4KV9iQtgzDVPq54Ymg/OC6i9mkqK1PLFfF/PLtTCTZ1iP" +
       "ES2emxbVKVyslJSV6cBo1SZa4oKb1lzV8INZWHfhqr6qagpRmVXt/LiN88up" +
       "nCDdXqMtJB04plqySPhFrFzVpeq8IyloWa/lCXFBYN4qCQStgzanzUbT0fKD" +
       "nFm1ioHXmFaDKJDdIonkgjlssX2kZZY663WhWCjDuSU9dccoFifwZC3zXp4V" +
       "iWRKdzUsp+j1kiu2il0Gk+eIK8+miFgeeguJqxsdFQsr8+FY7cpdfTksFdjx" +
       "SEDgOKF5n0bH/Srp8HZk5D3B7lBxbzRlkG7LnrWXehOWhZ6E0M2ViK2Ildbv" +
       "5WYhi7XUoCQi7sAxpQWNJP0aA3ssjZVyStMUTD5aRd6IKsrNwoToyoWk0pbn" +
       "43lFXBSqFVabDmCJ1vJ8UmdyzLxcmWDrCVwSoorRtksjts01c3VgbrUQTOza" +
       "VEr0HI/1NiJUqEGhzpkNRNGTopSzgpKvUNZ01EY5zB6hBa2qjR1HZroYW3fF" +
       "imkIuldCSxWrxVpLsiwtyISxsCkrzhhV76y7XDvJa0yCjLEyMe6NkUVjznhS" +
       "VCzRwMq4JletLYKhmOcrOGraCFjeZ6ZHqCYf9jVMLlBSH18HdE6nY7K8MEo9" +
       "EIe7iSpIxshBSJKv9iczsoIJHXTeH0qaiMr1QhFPWNoUqh273epYtbBajUd2" +
       "E2Y7k9mSUOaFJuL1WvmcNy/iDsPoS6TFGAzap/RKJWcVak19jeRyHN0yi06w" +
       "ZOTVjOo7a33pSpItETljhE4xa1aExy3ErUS5QgPEuAT18JzpBVJn3YAnBKYN" +
       "J+QajytmMEPWiR+XJEt32XapJ4VMiBmjnA8rfbRYE2ws7Gg1p8UalJIIA7pA" +
       "ES6sD8eLmOohqK5jZBHtzMLZ2vMAMlVh28OJRxW8qZaQpLFQ24pRyNEyWEWG" +
       "puSFHGN6KE6SVYNtzSiFUa3yeFnqLsKy2h/lZYSZlRBJgdG+KMywEiYthLXX" +
       "Q2BTRbuYKoqdeEAi9Coa1Ho0NSQkPzBZtYpTVW7ey9GTGkexcH3CmfFkGMNM" +
       "HAndJTb0ui489DxuuKpV0WAeUCoyW+OJN51PxQEvsuRy3aha6CyE43Vb8PW+" +
       "OHVzxQo963VhuehMWGZVldal4XAaF9Q67Xd0FiEFle9Oy1oocYtBtVAXliE2" +
       "7Pc608pcY8t51hy2LZMqqZqLD/NIVJ3ipSDyKK9CqAO6JdKrcrVkJ92QpHB8" +
       "IuR7I63He0mpTIlKpYnagTTCp91wasIMB3N0Pj+0SdVVomhYs8N5nux4FIfX" +
       "nARf5HoKSLVCc0WXqWRMsNTCKynxEik0w7oRdweatEz0Jd3T1RxYrkOz27NY" +
       "YtyKm43ZXNJbwoI2AhGfzy1N7Zaai9HKkWJUyZW6uNUZLzqDSqHap1ZKqEzj" +
       "gWIDcZsFsaeFFhWuxoGIDfJ+02cn6FRzyfGCneQJqRUPi7FS6vTJkOmsh3i+" +
       "HQvdAcYtJYATYUFMAobT3tAPiE6JNkY1TQo5B+caNB4tOu1eo9bXaB5nl5Ls" +
       "S2W2hRKpHjl2tK62cR3LYfmiixC8UMrZgi6CqIah8LyK8XWRn9gtd9hJdCHH" +
       "1yS0tcaFQUvX5eFgUMuVyzVCFchaXM4RY40UCnofdhSz4up1kGj2KducjS1x" +
       "VsrxrDS2bUOcRZXmoqZVxzU6Z0klkUt4qdAO5utCvlKiEGXCLXi9UuJ5NBwu" +
       "pkaut5jkkzzuY1KlK0Z0KfIMfFhdmoRHCmvZKAeTYkRIqB8MpUJ1VOnSc5uX" +
       "PPCq0zLRHlkoI4IMd7lG1RC4vKKzFq+akh0NY29Nzdhmfl1egEwGvI7Y40lZ" +
       "za3Xvl2jB3MKm3jjnueD1Lmw0GNBDKWkLguWbLn5gpLrNbUVWAoIOOqqHLnM" +
       "L9sLDbyKuLkgplRnRSyQqBKLhbmkjOREl/mkGtnlEY9SMCwWS02cQgt5DMu5" +
       "ely2WWSNUHZkL8ddypK46kptknVBmtbiaojW6gWGdDmCd2quTI4WGk+QTsFg" +
       "V3l3Ve5JhXJTJ3g9FOgqVxTC7hjz4spMg+eURQ+WRKKjPlwvLPUW6RIjcmzk" +
       "FsuGbUtuXvFLDXY1QAaOai6qrVU8TgxzAislac1MSKdULRJxkXTCoB8V4VzT" +
       "rvQEzRdhZF1p8i23q4T8eBRa1Va5VCGUPNKnPWlVGbBNos1TjkflBnmcFsgQ" +
       "vD1OWoUWt6L7RbBqh7IKB/OurlbBS+pb35q+vi5e2Q7Ctdlmyd4xnm5W0ob+" +
       "K3hz3jTdmRZv2NvOyn5XHD36ObhzvL+dCKW7Abde6nQu2wl44n2PPi6zHy9s" +
       "7WzDznzopG87P2sqa8U8wOok4HTvpXc9utnh5P724Jfe9283D96mvusVHHrc" +
       "fkTOoyz/oPvkV8g3Sr+5BV22t1l4wbHp4U73Hd4iPOUqfuBag0MbhbcePnho" +
       "gquyo9nKxQ8eLr5LmFnBZu6P7HIf2ycgM4IHXmQb/D1pEfnQjZ7iX2z3L+v0" +
       "jgOWI/rQ8bWtyfsmFb/UZszBMbOKYE8Hd+ziftuODt722ujgIMRff5G2R9Li" +
       "IQB/cXH4mRL3oT78KqBm+8K37Ez57tS/Iqj4S0J97EjbVta2tbtf+sZL7ftm" +
       "h5PNSFKcPacB5JtTF83ebrN7bdkwv5MWH/ShE7Kd9Uwf37uvpUdfrZZSq3hw" +
       "R0sPvvZa+sTFtZQ+/m5afDSj+mRa/J4PXZXpqCv6rhYdAfrEawH0iztAv/ja" +
       "A/3sywL6R2nx1C7Qfho5j87oZ14t0LuBzKc3fTf/ry3Qp18W0L9Ii8/70OkM" +
       "aObu5oVY//TVYr0diD3fwTp/7bF+7WVh/XpafMmHTmVYeUk0j+L88qvFCRKB" +
       "Yx/bwfmx1x7nt14WzmfS4m/TI7MMp6GER2B+89XCvAtI/MwOzGdee5jfvfTq" +
       "vUH4z2nxrA9d4xmas7dGHUH5nVeCEiz311/k25T0oP2mCz6A23y0JX368TNX" +
       "3vj48O+zzzP2Pqw6SUNXzgPTPHgueuD+CsdV5puoeXJzSupkf8+BBfcSS1H6" +
       "7UJ2k0n9gw39D33o7FF6H7o8+z9I9+/A3vfpAKvNzUGSH/nQZYAkvf2xs7vQ" +
       "nbvUurg549uoJzp2ONPd0/11L6X7A8nx3YdS2uyjxN30M9h8lnheeupxinn3" +
       "8+WPb74okUwxSVIuV9LQic3HLXsp7J2X5LbL64rWPS+c/szJN+ym26c3Au+b" +
       "7QHZbr/45xvNpeNnH1wkf3LjZ9/y+49/Ozvq/D8dIL+jLSoAAA==");
}
