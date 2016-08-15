package org.apache.batik.gvt.font;
public class UnicodeRange {
    private int firstUnicodeValue;
    private int lastUnicodeValue;
    public UnicodeRange(java.lang.String unicodeRange) { super();
                                                         if (unicodeRange.
                                                               startsWith(
                                                                 "U+") &&
                                                               unicodeRange.
                                                               length(
                                                                 ) >
                                                               2) { unicodeRange =
                                                                      unicodeRange.
                                                                        substring(
                                                                          2);
                                                                    int dashIndex =
                                                                      unicodeRange.
                                                                      indexOf(
                                                                        '-');
                                                                    java.lang.String firstValue;
                                                                    java.lang.String lastValue;
                                                                    if (dashIndex !=
                                                                          -1) {
                                                                        firstValue =
                                                                          unicodeRange.
                                                                            substring(
                                                                              0,
                                                                              dashIndex);
                                                                        lastValue =
                                                                          unicodeRange.
                                                                            substring(
                                                                              dashIndex +
                                                                                1);
                                                                    }
                                                                    else {
                                                                        firstValue =
                                                                          unicodeRange;
                                                                        lastValue =
                                                                          unicodeRange;
                                                                        if (unicodeRange.
                                                                              indexOf(
                                                                                '?') !=
                                                                              -1) {
                                                                            firstValue =
                                                                              firstValue.
                                                                                replace(
                                                                                  '?',
                                                                                  '0');
                                                                            lastValue =
                                                                              lastValue.
                                                                                replace(
                                                                                  '?',
                                                                                  'F');
                                                                        }
                                                                    }
                                                                    try {
                                                                        firstUnicodeValue =
                                                                          java.lang.Integer.
                                                                            parseInt(
                                                                              firstValue,
                                                                              16);
                                                                        lastUnicodeValue =
                                                                          java.lang.Integer.
                                                                            parseInt(
                                                                              lastValue,
                                                                              16);
                                                                    }
                                                                    catch (java.lang.NumberFormatException e) {
                                                                        firstUnicodeValue =
                                                                          -1;
                                                                        lastUnicodeValue =
                                                                          -1;
                                                                    }
                                                         }
                                                         else {
                                                             firstUnicodeValue =
                                                               -1;
                                                             lastUnicodeValue =
                                                               -1;
                                                         }
    }
    public boolean contains(java.lang.String unicode) {
        if (unicode.
              length(
                ) ==
              1) {
            int unicodeVal =
              unicode.
              charAt(
                0);
            return contains(
                     unicodeVal);
        }
        return false;
    }
    public boolean contains(int unicodeVal) {
        return unicodeVal >=
          firstUnicodeValue &&
          unicodeVal <=
          lastUnicodeValue;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "2zSzZWZ5jSkimRZmTmxfEl1sXv4ve9VXFxsZAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AA==");
}
