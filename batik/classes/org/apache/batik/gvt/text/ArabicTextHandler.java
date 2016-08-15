package org.apache.batik.gvt.text;
public class ArabicTextHandler {
    private static final int arabicStart = 1536;
    private static final int arabicEnd = 1791;
    private static final java.text.AttributedCharacterIterator.Attribute ARABIC_FORM =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        ARABIC_FORM;
    private static final java.lang.Integer ARABIC_NONE = org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                                                           ARABIC_NONE;
    private static final java.lang.Integer ARABIC_ISOLATED =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        ARABIC_ISOLATED;
    private static final java.lang.Integer ARABIC_TERMINAL =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        ARABIC_TERMINAL;
    private static final java.lang.Integer ARABIC_INITIAL =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        ARABIC_INITIAL;
    private static final java.lang.Integer ARABIC_MEDIAL =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        ARABIC_MEDIAL;
    private ArabicTextHandler() { super(); }
    public static java.text.AttributedString assignArabicForms(java.text.AttributedString as) {
        if (!containsArabic(
               as)) {
            return as;
        }
        java.text.AttributedCharacterIterator aci =
          as.
          getIterator(
            );
        int numChars =
          aci.
          getEndIndex(
            ) -
          aci.
          getBeginIndex(
            );
        int[] charOrder =
          null;
        if (numChars >=
              3) {
            char prevChar =
              aci.
              first(
                );
            char c =
              aci.
              next(
                );
            int i =
              1;
            for (char nextChar =
                   aci.
                   next(
                     );
                 nextChar !=
                   java.text.AttributedCharacterIterator.
                     DONE;
                 prevChar =
                   c,
                   c =
                     nextChar,
                   nextChar =
                     aci.
                       next(
                         ),
                   i++) {
                if (arabicCharTransparent(
                      c)) {
                    if (hasSubstitute(
                          prevChar,
                          nextChar)) {
                        if (charOrder ==
                              null) {
                            charOrder =
                              (new int[numChars]);
                            for (int j =
                                   0;
                                 j <
                                   numChars;
                                 j++) {
                                charOrder[j] =
                                  j +
                                    aci.
                                    getBeginIndex(
                                      );
                            }
                        }
                        int temp =
                          charOrder[i];
                        charOrder[i] =
                          charOrder[i -
                                      1];
                        charOrder[i -
                                    1] =
                          temp;
                    }
                }
            }
        }
        if (charOrder !=
              null) {
            java.lang.StringBuffer reorderedString =
              new java.lang.StringBuffer(
              numChars);
            char c;
            for (int i =
                   0;
                 i <
                   numChars;
                 i++) {
                c =
                  aci.
                    setIndex(
                      charOrder[i]);
                reorderedString.
                  append(
                    c);
            }
            java.text.AttributedString reorderedAS;
            reorderedAS =
              new java.text.AttributedString(
                reorderedString.
                  toString(
                    ));
            for (int i =
                   0;
                 i <
                   numChars;
                 i++) {
                aci.
                  setIndex(
                    charOrder[i]);
                java.util.Map attributes =
                  aci.
                  getAttributes(
                    );
                reorderedAS.
                  addAttributes(
                    attributes,
                    i,
                    i +
                      1);
            }
            if (charOrder[0] !=
                  aci.
                  getBeginIndex(
                    )) {
                aci.
                  setIndex(
                    charOrder[0]);
                java.lang.Float x =
                  (java.lang.Float)
                    aci.
                    getAttribute(
                      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                        X);
                java.lang.Float y =
                  (java.lang.Float)
                    aci.
                    getAttribute(
                      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                        Y);
                if (x !=
                      null &&
                      !x.
                      isNaN(
                        )) {
                    reorderedAS.
                      addAttribute(
                        org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                          X,
                        new java.lang.Float(
                          java.lang.Float.
                            NaN),
                        charOrder[0],
                        charOrder[0] +
                          1);
                    reorderedAS.
                      addAttribute(
                        org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                          X,
                        x,
                        0,
                        1);
                }
                if (y !=
                      null &&
                      !y.
                      isNaN(
                        )) {
                    reorderedAS.
                      addAttribute(
                        org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                          Y,
                        new java.lang.Float(
                          java.lang.Float.
                            NaN),
                        charOrder[0],
                        charOrder[0] +
                          1);
                    reorderedAS.
                      addAttribute(
                        org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                          Y,
                        y,
                        0,
                        1);
                }
            }
            as =
              reorderedAS;
        }
        aci =
          as.
            getIterator(
              );
        int runStart =
          -1;
        int idx =
          aci.
          getBeginIndex(
            );
        for (int c =
               aci.
               first(
                 );
             c !=
               java.text.AttributedCharacterIterator.
                 DONE;
             c =
               aci.
                 next(
                   ),
               idx++) {
            if (c >=
                  arabicStart &&
                  c <=
                  arabicEnd) {
                if (runStart ==
                      -1)
                    runStart =
                      idx;
            }
            else
                if (runStart !=
                      -1) {
                    as.
                      addAttribute(
                        ARABIC_FORM,
                        ARABIC_NONE,
                        runStart,
                        idx);
                    runStart =
                      -1;
                }
        }
        if (runStart !=
              -1)
            as.
              addAttribute(
                ARABIC_FORM,
                ARABIC_NONE,
                runStart,
                idx);
        aci =
          as.
            getIterator(
              );
        int end =
          aci.
          getBeginIndex(
            );
        java.lang.Integer currentForm =
          ARABIC_NONE;
        while (aci.
                 setIndex(
                   end) !=
                 java.text.AttributedCharacterIterator.
                   DONE) {
            int start =
              aci.
              getRunStart(
                ARABIC_FORM);
            end =
              aci.
                getRunLimit(
                  ARABIC_FORM);
            char currentChar =
              aci.
              setIndex(
                start);
            currentForm =
              (java.lang.Integer)
                aci.
                getAttribute(
                  ARABIC_FORM);
            if (currentForm ==
                  null) {
                continue;
            }
            int currentIndex =
              start;
            int prevCharIndex =
              start -
              1;
            while (currentIndex <
                     end) {
                char prevChar =
                  currentChar;
                currentChar =
                  aci.
                    setIndex(
                      currentIndex);
                while (arabicCharTransparent(
                         currentChar) &&
                         currentIndex <
                         end) {
                    currentIndex++;
                    currentChar =
                      aci.
                        setIndex(
                          currentIndex);
                }
                if (currentIndex >=
                      end) {
                    break;
                }
                java.lang.Integer prevForm =
                  currentForm;
                currentForm =
                  ARABIC_NONE;
                if (prevCharIndex >=
                      start) {
                    if (arabicCharShapesRight(
                          prevChar) &&
                          arabicCharShapesLeft(
                            currentChar)) {
                        prevForm =
                          new java.lang.Integer(
                            prevForm.
                              intValue(
                                ) +
                              1);
                        as.
                          addAttribute(
                            ARABIC_FORM,
                            prevForm,
                            prevCharIndex,
                            prevCharIndex +
                              1);
                        currentForm =
                          ARABIC_INITIAL;
                    }
                    else
                        if (arabicCharShaped(
                              currentChar)) {
                            currentForm =
                              ARABIC_ISOLATED;
                        }
                }
                else
                    if (arabicCharShaped(
                          currentChar)) {
                        currentForm =
                          ARABIC_ISOLATED;
                    }
                if (currentForm !=
                      ARABIC_NONE)
                    as.
                      addAttribute(
                        ARABIC_FORM,
                        currentForm,
                        currentIndex,
                        currentIndex +
                          1);
                prevCharIndex =
                  currentIndex;
                currentIndex++;
            }
        }
        return as;
    }
    public static boolean arabicChar(char c) {
        if (c >=
              arabicStart &&
              c <=
              arabicEnd) {
            return true;
        }
        return false;
    }
    public static boolean containsArabic(java.text.AttributedString as) {
        return containsArabic(
                 as.
                   getIterator(
                     ));
    }
    public static boolean containsArabic(java.text.AttributedCharacterIterator aci) {
        for (char c =
               aci.
               first(
                 );
             c !=
               java.text.AttributedCharacterIterator.
                 DONE;
             c =
               aci.
                 next(
                   )) {
            if (arabicChar(
                  c)) {
                return true;
            }
        }
        return false;
    }
    public static boolean arabicCharTransparent(char c) {
        int charVal =
          c;
        if (charVal <
              1611 ||
              charVal >
              1773)
            return false;
        if (charVal <=
              1621 ||
              charVal ==
              1648 ||
              charVal >=
              1750 &&
              charVal <=
              1764 ||
              charVal >=
              1767 &&
              charVal <=
              1768 ||
              charVal >=
              1770) {
            return true;
        }
        return false;
    }
    private static boolean arabicCharShapesRight(char c) {
        int charVal =
          c;
        if (charVal >=
              1570 &&
              charVal <=
              1573 ||
              charVal ==
              1575 ||
              charVal ==
              1577 ||
              charVal >=
              1583 &&
              charVal <=
              1586 ||
              charVal ==
              1608 ||
              charVal >=
              1649 &&
              charVal <=
              1651 ||
              charVal >=
              1653 &&
              charVal <=
              1655 ||
              charVal >=
              1672 &&
              charVal <=
              1689 ||
              charVal ==
              1728 ||
              charVal >=
              1730 &&
              charVal <=
              1739 ||
              charVal ==
              1741 ||
              charVal ==
              1743 ||
              charVal >=
              1746 &&
              charVal <=
              1747 ||
              arabicCharShapesDuel(
                c)) {
            return true;
        }
        return false;
    }
    private static boolean arabicCharShapesDuel(char c) {
        int charVal =
          c;
        if (charVal ==
              1574 ||
              charVal ==
              1576 ||
              charVal >=
              1578 &&
              charVal <=
              1582 ||
              charVal >=
              1587 &&
              charVal <=
              1594 ||
              charVal >=
              1601 &&
              charVal <=
              1607 ||
              charVal >=
              1609 &&
              charVal <=
              1610 ||
              charVal >=
              1656 &&
              charVal <=
              1671 ||
              charVal >=
              1690 &&
              charVal <=
              1727 ||
              charVal ==
              1729 ||
              charVal ==
              1740 ||
              charVal ==
              1742 ||
              charVal >=
              1744 &&
              charVal <=
              1745 ||
              charVal >=
              1786 &&
              charVal <=
              1788) {
            return true;
        }
        return false;
    }
    private static boolean arabicCharShapesLeft(char c) {
        return arabicCharShapesDuel(
                 c);
    }
    private static boolean arabicCharShaped(char c) {
        return arabicCharShapesRight(
                 c);
    }
    public static boolean hasSubstitute(char ch1,
                                        char ch2) {
        if (ch1 <
              doubleCharFirst ||
              ch1 >
              doubleCharLast)
            return false;
        int[][] remaps =
          doubleCharRemappings[ch1 -
                                 doubleCharFirst];
        if (remaps ==
              null)
            return false;
        for (int i =
               0;
             i <
               remaps.
                 length;
             i++) {
            if (remaps[i][0] ==
                  ch2)
                return true;
        }
        return false;
    }
    public static int getSubstituteChar(char ch1,
                                        char ch2,
                                        int form) {
        if (form ==
              0)
            return -1;
        if (ch1 <
              doubleCharFirst ||
              ch1 >
              doubleCharLast)
            return -1;
        int[][] remaps =
          doubleCharRemappings[ch1 -
                                 doubleCharFirst];
        if (remaps ==
              null)
            return -1;
        for (int i =
               0;
             i <
               remaps.
                 length;
             i++) {
            if (remaps[i][0] ==
                  ch2)
                return remaps[i][form];
        }
        return -1;
    }
    public static int getSubstituteChar(char ch,
                                        int form) {
        if (form ==
              0)
            return -1;
        if (ch <
              singleCharFirst ||
              ch >
              singleCharLast)
            return -1;
        int[] chars =
          singleCharRemappings[ch -
                                 singleCharFirst];
        if (chars ==
              null)
            return -1;
        return chars[form -
                       1];
    }
    public static java.lang.String createSubstituteString(java.text.AttributedCharacterIterator aci) {
        int start =
          aci.
          getBeginIndex(
            );
        int end =
          aci.
          getEndIndex(
            );
        int numChar =
          end -
          start;
        java.lang.StringBuffer substString =
          new java.lang.StringBuffer(
          numChar);
        for (int i =
               start;
             i <
               end;
             i++) {
            char c =
              aci.
              setIndex(
                i);
            if (!arabicChar(
                   c)) {
                substString.
                  append(
                    c);
                continue;
            }
            java.lang.Integer form =
              (java.lang.Integer)
                aci.
                getAttribute(
                  ARABIC_FORM);
            if (charStartsLigature(
                  c) &&
                  i +
                  1 <
                  end) {
                char nextChar =
                  aci.
                  setIndex(
                    i +
                      1);
                java.lang.Integer nextForm =
                  (java.lang.Integer)
                    aci.
                    getAttribute(
                      ARABIC_FORM);
                if (form !=
                      null &&
                      nextForm !=
                      null) {
                    if (form.
                          equals(
                            ARABIC_TERMINAL) &&
                          nextForm.
                          equals(
                            ARABIC_INITIAL)) {
                        int substChar =
                          org.apache.batik.gvt.text.ArabicTextHandler.
                          getSubstituteChar(
                            c,
                            nextChar,
                            ARABIC_ISOLATED.
                              intValue(
                                ));
                        if (substChar >
                              -1) {
                            substString.
                              append(
                                (char)
                                  substChar);
                            i++;
                            continue;
                        }
                    }
                    else
                        if (form.
                              equals(
                                ARABIC_TERMINAL)) {
                            int substChar =
                              org.apache.batik.gvt.text.ArabicTextHandler.
                              getSubstituteChar(
                                c,
                                nextChar,
                                ARABIC_TERMINAL.
                                  intValue(
                                    ));
                            if (substChar >
                                  -1) {
                                substString.
                                  append(
                                    (char)
                                      substChar);
                                i++;
                                continue;
                            }
                        }
                        else
                            if (form.
                                  equals(
                                    ARABIC_MEDIAL) &&
                                  nextForm.
                                  equals(
                                    ARABIC_MEDIAL)) {
                                int substChar =
                                  org.apache.batik.gvt.text.ArabicTextHandler.
                                  getSubstituteChar(
                                    c,
                                    nextChar,
                                    ARABIC_MEDIAL.
                                      intValue(
                                        ));
                                if (substChar >
                                      -1) {
                                    substString.
                                      append(
                                        (char)
                                          substChar);
                                    i++;
                                    continue;
                                }
                            }
                }
            }
            if (form !=
                  null &&
                  form.
                  intValue(
                    ) >
                  0) {
                int substChar =
                  getSubstituteChar(
                    c,
                    form.
                      intValue(
                        ));
                if (substChar >
                      -1) {
                    c =
                      (char)
                        substChar;
                }
            }
            substString.
              append(
                c);
        }
        return substString.
          toString(
            );
    }
    public static boolean charStartsLigature(char c) {
        int charVal =
          c;
        if (charVal ==
              1611 ||
              charVal ==
              1612 ||
              charVal ==
              1613 ||
              charVal ==
              1614 ||
              charVal ==
              1615 ||
              charVal ==
              1616 ||
              charVal ==
              1617 ||
              charVal ==
              1618 ||
              charVal ==
              1570 ||
              charVal ==
              1571 ||
              charVal ==
              1573 ||
              charVal ==
              1575) {
            return true;
        }
        return false;
    }
    public static int getNumChars(char c) {
        if (isLigature(
              c))
            return 2;
        return 1;
    }
    public static boolean isLigature(char c) {
        int charVal =
          c;
        if (charVal <
              65136 ||
              charVal >
              65276)
            return false;
        if (charVal <=
              65138 ||
              charVal ==
              65140 ||
              charVal >=
              65142 &&
              charVal <=
              65151 ||
              charVal >=
              65269) {
            return true;
        }
        return false;
    }
    static int singleCharFirst = 1569;
    static int singleCharLast = 1610;
    static int[][] singleCharRemappings =
      { { 65152,
    -1,
    -1,
    -1 },
    { 65153,
    65154,
    -1,
    -1 },
    { 65155,
    65156,
    -1,
    -1 },
    { 65157,
    65158,
    -1,
    -1 },
    { 65159,
    65160,
    -1,
    -1 },
    { 65161,
    65162,
    65163,
    65164 },
    { 65165,
    65166,
    -1,
    -1 },
    { 65167,
    65168,
    65169,
    65170 },
    { 65171,
    65172,
    -1,
    -1 },
    { 65173,
    65174,
    65175,
    65176 },
    { 65177,
    65178,
    65179,
    65180 },
    { 65181,
    65182,
    65183,
    65184 },
    { 65185,
    65186,
    65187,
    65188 },
    { 65189,
    65190,
    65191,
    65192 },
    { 65193,
    65194,
    -1,
    -1 },
    { 65195,
    65196,
    -1,
    -1 },
    { 65197,
    65198,
    -1,
    -1 },
    { 65199,
    65200,
    -1,
    -1 },
    { 65201,
    65202,
    65203,
    65204 },
    { 65205,
    65206,
    65207,
    65208 },
    { 65209,
    65210,
    65211,
    65212 },
    { 65213,
    65214,
    65215,
    65216 },
    { 65217,
    65218,
    65219,
    65220 },
    { 65221,
    65222,
    65223,
    65224 },
    { 65225,
    65226,
    65227,
    65228 },
    { 65229,
    65230,
    65231,
    65232 },
    null,
    null,
    null,
    null,
    null,
    null,
    { 65233,
    65234,
    65235,
    65236 },
    { 65237,
    65238,
    65239,
    65240 },
    { 65241,
    65242,
    65243,
    65244 },
    { 65245,
    65246,
    65247,
    65248 },
    { 65249,
    65250,
    65251,
    65252 },
    { 65253,
    65254,
    65255,
    65256 },
    { 65257,
    65258,
    65259,
    65260 },
    { 65261,
    65262,
    -1,
    -1 },
    { 65263,
    65264,
    -1,
    -1 },
    { 65265,
    65266,
    65267,
    65268 } };
    static int doubleCharFirst = 1570;
    static int doubleCharLast = 1618;
    static int[][][] doubleCharRemappings =
      { { { 1604,
    65269,
    65270,
    -1,
    -1 } },
    { { 1604,
    65271,
    65272,
    -1,
    -1 } },
    null,
    { { 1604,
    65273,
    65274,
    -1,
    -1 } },
    null,
    { { 1604,
    65275,
    65276,
    -1,
    -1 } },
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    { { 32,
    65136,
    -1,
    -1,
    -1 },
    { 1600,
    -1,
    -1,
    -1,
    65137 } },
    { { 32,
    65138,
    -1,
    -1,
    -1 } },
    { { 32,
    65140,
    -1,
    -1,
    -1 } },
    { { 32,
    65142,
    -1,
    -1,
    -1 },
    { 1600,
    -1,
    -1,
    -1,
    65143 } },
    { { 32,
    65144,
    -1,
    -1,
    -1 },
    { 1600,
    -1,
    -1,
    -1,
    65145 } },
    { { 32,
    65146,
    -1,
    -1,
    -1 },
    { 1600,
    -1,
    -1,
    -1,
    65147 } },
    { { 32,
    65148,
    -1,
    -1,
    -1 },
    { 1600,
    -1,
    -1,
    -1,
    65149 } },
    { { 32,
    65150,
    -1,
    -1,
    -1 },
    { 1600,
    -1,
    -1,
    -1,
    65151 } } };
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVbC3AcxZnuXcmSLFkPyw/8fsoOfrBrTAikRAiyLMULq0cs" +
       "ISoyWJ6dbe2OPTsznumV1uZ8PCqcfQ8IR2zC3RlXUjExoQzOcUmFKwL4Khcg" +
       "B0kqPEIIAfKgEhJCBedycAeXcP/fPbMzO7szsnTSVk3v7HT33//39d9//93T" +
       "e/ptMssyyQqqsRg7YFAr1qWxfsm0aLpTlSxrEJ6NyF+okv5z95u9H4+SmmHS" +
       "lJWsHlmyaLdC1bQ1TJYrmsUkTaZWL6VprNFvUouaYxJTdG2YLFCsRM5QFVlh" +
       "PXqaYoEhyUySuRJjppLKM5qwBTCyPAmaxLkm8Q5/dnuSzJF144BbfJGneKcn" +
       "B0vm3LYsRlqSe6UxKZ5nihpPKhZrL5hkk6GrBzKqzmK0wGJ71UttCq5OXlpG" +
       "wZqvNb/7wZ3ZFk7BPEnTdMbhWTuppatjNJ0kze7TLpXmrP3kL0lVkjR4CjPS" +
       "lnQajUOjcWjUQeuWAu0bqZbPdeocDnMk1RgyKsTI6lIhhmRKOVtMP9cZJNQx" +
       "GzuvDGhXFdEKlGUQj22KH/3C7paHq0jzMGlWtAFURwYlGDQyDITSXIqaVkc6" +
       "TdPDZK4GnT1ATUVSlYN2T7daSkaTWB6636EFH+YNavI2Xa6gHwGbmZeZbhbh" +
       "jXKDsn/NGlWlDGBd6GIVCLvxOQCsV0Axc1QCu7OrVO9TtDQjK/01ihjbroEC" +
       "ULU2R1lWLzZVrUnwgLQKE1ElLRMfANPTMlB0lg4GaDKyJFAocm1I8j4pQ0fQ" +
       "In3l+kUWlJrNicAqjCzwF+OSoJeW+HrJ0z9v915xx43aDi1KIqBzmsoq6t8A" +
       "lVb4Ku2ko9SkMA5ExTkbk3dLCx87EiUECi/wFRZlvvkX567avOLs06LM0gpl" +
       "+lJ7qcxG5JOpph8u69zw8SpUo87QLQU7vwQ5H2X9dk57wQAPs7AoETNjTubZ" +
       "nU9+5uYH6FtRUp8gNbKu5nNgR3NlPWcoKjU/RTVqSoymE2Q21dKdPD9BauE+" +
       "qWhUPO0bHbUoS5BqlT+q0flvoGgURCBF9XCvaKO6c29ILMvvCwYhpBYuMgeu" +
       "tUR8+Dcju+NZPUfjkixpiqbH+00d8Vtx8Dgp4DYbT4HV74tbet4EE4zrZiYu" +
       "gR1kqZ2RGYO+xeHZYUopRR6E2x2SlgZUMbQzY8ZbKCDGeeORCNC/zD/4VRg3" +
       "O3Q1Tc0R+Wh+W9e5h0aeEYaFg8Fmh5FN0GhMNBrjjcag0Rg2GitrlEQivK35" +
       "2LjoZuikfTDcwd/O2TBww9V7jqypAvsyxquBYSy6pmTe6XR9guPIR+QzrY0H" +
       "V7928bejpDpJWiWZ5SUVp5EOMwMOSt5nj+E5KZiR3IlhlWdiwBnN1GWaBr8U" +
       "NEHYUur0MWric0bmeyQ40xYO0HjwpFFRf3L2nvFbhm7aEiXR0rkAm5wFbgyr" +
       "96MHL3rqNr8PqCS3+fCb7565+5DueoOSycWZE8tqIoY1fmvw0zMib1wlfWPk" +
       "sUNtnPbZ4K2ZBKMLHOEKfxslzqbdcdyIpQ4Aj+pmTlIxy+G4nmVNfdx9ws10" +
       "Lr+fb49Eshyuy+3hyL8xd6GB6QXCrNHOfCj4xPCJAePeH3//N5dwup05pNkz" +
       "+Q9Q1u7xWyislXuoua7ZDpqUQrlX7+n//LG3D+/iNgsl1lZqsA3TTvBX0IVA" +
       "821P73/59ddOvhB17ZyRWsNUIBqihSJKzCANISihufWuQuD4VHANaDZt12pg" +
       "oMqoIqVUiiPrf5vXXfyN393RIgxBhSeOHW2eWID7fPE2cvMzu99bwcVEZJx4" +
       "XdLcYsKbz3Mld5imdAD1KNzy3PJ/eEq6F+YF8MWWcpBy90o4CYT32qUc/xae" +
       "ftSXdxkm6yyv9ZcOME+ANCLf+cI7jUPvPH6Oa1saYXk7u0cy2oV9YbK+AOIv" +
       "8HunHZKVhXIfPdt7fYt69gOQOAwSZfC4Vp8J/rFQYhp26Vm1P/m3by/c88Mq" +
       "Eu0m9aoupbslPsrIbDBvamXBtRaMT14lOne8DpIWDpWUgS97gASvrNx1XTmD" +
       "cbIPPnLB1684deI1bmaGkLGU129Cb1/iVnmc7o7sB56/7MVTf3/3uJjpNwS7" +
       "M1+9Re/3qalbf/HfZZRzR1YhCvHVH46fPr6k88q3eH3Xo2DttkL5DAVe2a27" +
       "9YHcf0XX1HwnSmqHSYtsx8VDkprHcToMsaDlBMsQO5fkl8Z1IohpL3rMZX5v" +
       "5mnW78vcmRHusTTeN/rc12Lswq1wrbMH9jq/++JzpLAoVCmWgDA2Q83WX3zx" +
       "5Hu3HL48isNn1hiqDqy0uOV68xh+/9XpY8sbjv7sb3nHE1LDRSd48x/h6UZM" +
       "LuKmUIW3MUZqLB7JM4CjaJLq80KLQpRl0NF8moep1mSlEzZOigP5lAWTq5ID" +
       "XzpmR5tb+/fIR9r63xD2tbhCBVFuwf3x24de2vss99R1OH0POpx6JmeY5j3T" +
       "RItQ/UP4ROD6M16oMj4QUVtrpx06rirGjjg+Qg3dByB+qPX1fcfffFAA8Fu1" +
       "rzA9cvRvPozdcVR4X7EAWVu2BvDWEYsQAQeT61C71WGt8Brdvz5z6NH7Dx0W" +
       "WrWWhtNdsFp88Ed/ejZ2z8++WyGKq1LsRSS6mUgx+ppf2jcC0Pa/bv7Wna1V" +
       "3TDxJ0hdXlP252kiXWr9tVY+5eksd2HjjggbGnYMI5GN0Adi2sb0ckyuFmbY" +
       "HugjO0vH1Ba41ttmur7CmMKba2BAfIg3mbABgUk/Jp+uMBKCmmBkthgJXVoa" +
       "Hwz54GQnCacDrg12WxeWwSH8xpgyigsDJMN47tjZsS3ROdLdt7OH11vESJw7" +
       "GRHUO3su6c4s4JVh7ZtglEc2bcU8H/T9U4C+yVZwYwD0g1OGvjFAsgu9t6+3" +
       "y4Fe7od94G6cJLguuC6yVdgcAO6zUwa3OUAyRD02uMRAX7JjsGs7Pr7Zh+W2" +
       "KWCJ2y3GArD83ZSxxAIku1gGu3b2JHo7kpWw3D5JLNvhuthucUsAlqNTxrIl" +
       "QDIjTU6/9CYGE5WhHJsklE64LrEb3BoA5fiUoWwNkMxIow2lp2t7AJJ7zx8J" +
       "rn3QyUbtThHfFZCcrIwkwkH49K8PkQdmZSlaBpY84Ni6FVMsk/xu/L4pILAZ" +
       "iwb1xWmBAJNT5foG1QbTcfVNSpXVfXCS6oJTjO6xG7wkQN1/CVX3koDajMx3" +
       "1d1Jc5JhwE+r9N1CMQLki0YRb1zf8OQT1pd/9bCIayrFl77dzPtP1cmv5J7k" +
       "8SU2fW0pxKYQJTHSWhccB3q0OvGVtd+/6cTan/PVYJ1iwbIAItEK+7OeOu+c" +
       "fv2t5xqXP8S3TKoxoMVGG/0b2+X71iXb0RxTMyaPis79VhFfE8KZC5fd2+Kb" +
       "kV3/z31E3EKUxlk8Q/VcvF9i2STVMizrbFPOpHiOdqgsNuWmi8lZxyr/vbIb" +
       "iMLqxsinVEUW/gzT6+CZypvAX9dj8oThLrOjoqITAcxzI4BOVdco7oo4eWIn" +
       "U9FjxfcckFko09Yky0sW3D28O93V66tNd/3yX9sy2yazhYnPVkywSYm/V4JN" +
       "bgw2ab8qT9362yWDV2b3TGI3cqXP4v0iv9pz+rufWi/fFeWvUsSyuuwVTGml" +
       "9tLlRL1JWd7UShcQa0X3894LmQKeEl0esrH0Ukjey5g8DwtjGbteWEpI8Z+W" +
       "79Xggw7Ds61TZsKPOib8eoAJcxge88Xk6aLpPl5uuvjzPzB5ttwW8fcPRLO8" +
       "NiYvhED6VUjem5i8gclPhCYhZX97/tTgT9m/HPz6FCbelO3mUwEz2e9DZ7Kg" +
       "2hAopPV8aoJA4Z0p6CvbLcoB+r4bqm9QbQgUXH2DAoX3Jqnux6Che+wG0wHq" +
       "/ilU3XRAbfCqrrqeQAEzHymfyoPE2HMjJBExZT5uGMb5mdqfQ7gouJheLCrD" +
       "PzXE94bQowwvudTZz4XpIOglLt/JOXnr0RPpvvsudgKY3YzMZrpxkUrHqOoR" +
       "JTa7flBUg7eK4Lbbamz3c+ICDfEy/qB5bohE34D3OhmYHpdU2jcQb85RlciC" +
       "YH8RWYxJMyzAgRklo4mXid26yeedyMJib0VaJrLc8L104YR8TC7BvDa4/mjj" +
       "/uO0MRkkMYTJQUyuE7I+47m/gZFqOWvP+2VGzVlcF8LwZkxWMlIv9q06HUkh" +
       "zdWmdF2lkla5RbdPVs1Un1wIjUWETPE9HX0SKLFyn3D74wx+IoTdT2JyGfhe" +
       "+0WGJSwYn8Zcoi6fSaIabFgN00ZUkMRwN7DuvLYPOWvXhDDah0nXRIx2zxSj" +
       "cUC0zMa/bNoYDZIYbHrrORm7Qoi6AZNrGVngDuxBEwatIcEqmfn4GpoBvpZi" +
       "3hbQ1967iJTtfEzEV6wSX60hEifiSwnhC9dX+ELbw9dAVsLjaEom6+crPVN8" +
       "oX312uh6p42vIIkT8TUewtcBTPZDnObna3ueqj66zJmka68Nbu+00RUkcSK6" +
       "bguh6zAmN1WgK0lH/dZ180zRtYmfMxHg2LTRFSRxIro+H0LXMUxuZ6TFR1fa" +
       "R9UdM+XoPwKqFmxghclSFejogyT6mHBX8JH1Ll9fCuHry5j8EyONWcni26EK" +
       "E6/gvGQdnwGyFjpkfc6G9rlpIytIoo+GquI7C5sszBjirJwJYeyfMfkqLC0y" +
       "lLmMoaHx+i5rD8wka8dtjMenjbUgieEmZhP2WAhhT2DyzfMg7JEZIIy/0kJv" +
       "/7AN7+FpIyxIYrD7SnI+ngnh6nuYfIeRhbJJJUZdusS614mJPed2PBmcxCdn" +
       "yrFtBhDv25DfnzYSgyRONAe8EkLiq5i8yEgrLm/F0aKkkuF/HPA5th/N1BBd" +
       "DbgbhUzxPR1kBUqciKzfhJD1Fia/ZKQBRmdvPldcx3vG5RszuEcStZcw0Wlb" +
       "FAVKnIil90JY+h9MzjE8CRhgSn+YDpIK4CXLDr7jgc1FZf+uEf8IkR860Vx3" +
       "wYlrXxJvBZ1/bcxJkrrRvKp6jxR67msMk44qnOE54oAhPz8VhUhsceCJfEaq" +
       "8QtVjxJRvhrC0krlGamC1FuyFnyWvyQjs/i3t1w9UOyWY6RG3HiLNIJ0KIK3" +
       "TUYFhyjOYBbE/sFSL+F8e3bBRP3k2WhdW/Lmi/8PynlLlRf/hBqRz5y4uvfG" +
       "cx+7T5wIl1Xp4EGU0pAkteJwOheKb7pWB0pzZNXs2PBB09dmr3O2bucKhd2R" +
       "sNQ1STznFDHQNpb4TktbbcVD0y+fvOLx7x2peS5KIrtIRGJk3q7y06oFI2+S" +
       "5buS5cf1hiSTH+Nu3/CPB67cPPr7V+xjofyl5LLg8iPyC6dueP6uRSdXRElD" +
       "gsxStDQt8GO02w9oO6k8Zg6TRsXqKoCKIEWR1JKzgE1oxhJOa5wXm87G4lP8" +
       "PwEja8qPQZb/C6Ne1cepuU3Pi2N1jUnS4D4RPeN7WZg3DF8F94ndlZimMLmO" +
       "h+NgjyPJHsNwTonWJww+nOUKrka8Loiu5rd4t+b/AO5222cjOQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL18C9DsVn3f3mv7+u1rG2yMYwPGNsFecvXalbRxStiHdlda" +
       "7a5WK+1DSTB6S6vn6rGr3dThMRCY0gGGmIR0iCedmjZhzKMMadKhZNx0WmCg" +
       "TMnQhrZTSJjOJC0wAzNp0oG29Ei73+N+997Pvr4434yOtNJ5/H7/8///z/8c" +
       "HX3Pfb90QxyVymHgbkw3SC7oWXJh4VYvJJtQjy8wbJWTo1jXmq4cxwK496T6" +
       "+s+c/5sff8i682zpnFR6hez7QSInduDHvB4H7krX2NL5o7uUq3txUrqTXcgr" +
       "GUoT24VYO06eYEu3HiualB5hDyBAAAIEIEAFBKh+lAsUul33U6+Zl5D9JF6W" +
       "fq10hi2dC9UcXlJ66OJKQjmSvX01XMEA1HBT/nsCSBWFs6j0ukPuO86XEP5I" +
       "GXr6t95652evK52XSudtf5zDUQGIBDQilW7zdE/Ro7iuabomle7ydV0b65Et" +
       "u/a2wC2V7o5t05eTNNIPhZTfTEM9Kto8ktxtas4tStUkiA7pGbbuage/bjBc" +
       "2QRc7z3iumPYzu8DgrfYAFhkyKp+UOR6x/a1pPTakyUOOT7SAxlA0Rs9PbGC" +
       "w6au92Vwo3T3ru9c2TehcRLZvgmy3hCkoJWkdP8VK81lHcqqI5v6k0npvpP5" +
       "uN0jkOvmQhB5kaR0z8lsRU2gl+4/0UvH+uf7g1/4wK/6Xf9sgVnTVTfHfxMo" +
       "9JoThXjd0CPdV/VdwdseZ39TvvcL7ztbKoHM95zIvMvzh3//h29502ue/9Iu" +
       "z89cJs9QWehq8qT6rHLH1x9oPla7LodxUxjEdt75FzEv1J/bP3kiC4Hl3XtY" +
       "Y/7wwsHD5/l/N3/HJ/Tvni3dQpfOqYGbekCP7lIDL7RdPerovh7Jia7RpZt1" +
       "X2sWz+nSjeCatX19d3doGLGe0KXr3eLWuaD4DURkgCpyEd0Irm3fCA6uQzmx" +
       "iussLJVKN4KjdBs4Hi7t/opzUnorZAWeDsmq7Nt+AHFRkPOPId1PFCBbC1KA" +
       "1jtQHKQRUEEoiExIBnpg6fsH5gr0bW6e9UhWbFUAl13Z1wCrC7mehS97C1nO" +
       "8c71mTNA/A+cNH4X2E03cDU9elJ9Om1QP/zUk185e2gMe+kkpTJo9MKu0QtF" +
       "oxdAoxfyRi9c0mjpzJmirVfmje+6GXSSA8wdOMLbHhv/CvO2973+OqBf4fp6" +
       "IOE8K3Rlf9w8chB04QZVoKWl5z+6fufk7fDZ0tmLHWsOGNy6JS/O5e7w0O09" +
       "ctKgLlfv+ff+1d98+jefCo5M6yJPvbf4S0vmFvv6k6KNAlXXgA88qv7x18l/" +
       "8OQXnnrkbOl64AaA60tkoKrAq7zmZBsXWe4TB14w53IDIGwEkSe7+aMD13VL" +
       "YkXB+uhO0ed3FNd37dW69CA4yL1uF+f86SvCPH3lTkfyTjvBovCyf28c/s43" +
       "v/Y/sELcBw75/LEhbqwnTxxzAnll5wtzv+tIB4RI10G+//ZR7jc+8v33/lKh" +
       "ACDHw5dr8JE8bQLjB10IxPyeLy3/87e/9ew3zh4pTVK6MYzsFfAJ2SHL/EHp" +
       "1lNYgubecAQIeBEX2FmuNo+IvhdotmHLiqvnavp/zj+K/MH3PnDnThFccOdA" +
       "j970whUc3X91o/SOr7z1b19TVHNGzUexI6EdZdu5xlcc1VyPInmT48je+acP" +
       "/vYX5d8BThY4ttje6oWvKhVCKBW9BhX8Hy/SCyeeIXny2vi49l9sYMeijSfV" +
       "D33jB7dPfvDHPyzQXhyuHO/svhw+sdOvPHldBqp/1UlT78qxBfJVnh/88p3u" +
       "8z8GNUqgRhW4r3gYAWeTXaQa+9w33Phf/vW/ufdtX7+udLZdusUNZK0tF1ZW" +
       "uhmotx5bwE9l4S++Zde565tAcmdBtXQJ+Z1S3Ff8ugsAfOzKDqadRxtHNnrf" +
       "j4au8q7v/O9LhFC4lssMsifKS9BzH7u/+ebvFuWPbDwv/ZrsUgcMIrOjsugn" +
       "vP919vXn/u3Z0o1S6U51H/ZNZDfNLUcCoU58EAuC0PCi5xeHLbsx+olDH/bA" +
       "Sf9yrNmT3uXI8YPrPHd+fcsJh/LqXMooOB7dm9qjJx1KMQTs+jiHdIEGUZqp" +
       "R3d/53ef/dt3vpc8myv0DascOpDKnUf5BmkeXf76cx958Nan//z9hcWXSueK" +
       "qn+xaP6hIn0kT3626N/r8ss3JqVzcRGoJoCO7cvu3i/8BPydAcf/y48cZH5j" +
       "N7Lf3dyHF687jC9CMNbdKhcjGgh7o+R01eEi2wMOb7WPr6Cn7v6287G/+uQu" +
       "djqpJycy6+97+h/85MIHnj57LGJ9+JKg8XiZXdRadMTtedLNLe+h01opSrT/" +
       "8tNPff73nnrvDtXdF8dfFJhefPI//d+vXvjon3/5MsP+dSC23o0MeYrmyVt2" +
       "cq1e0Qx//mIlgcHxhr2SvOEySpJf1EEP/yS/EE/r4Txp50mnkEE3Kd286ynK" +
       "1/IbgxNIJ1eJFKAoPbZH+sZLkJaKi1+5OoC31vl6g24+2R7y/aLMPUkJKnR9" +
       "FzolYHqhgImF1rQAFRXMMOhEL4a8Rw6fnWD11pfAqrxn9fgVWBkvjdVgOKAO" +
       "WF1q6Sdwm1eJmwLHz+1xv+kKuIOrw31+j5seD9m6QLXy284JmOFLgAntYV64" +
       "AszVS4MpUHyfHtTZy8FcXyXMFjiQPUz4CjCfujqYdxxIc0AL9OVR/tpVomyC" +
       "A9ujRK+A8t1Xh/L2Pco+1boCyPe8eJB5bJk7sbN7Ue7OlwH5/suDPFPgO+zn" +
       "2PZNEC0C02/b0S7CPOnD/uFLAIfuwV1Jgh9+MeDuOALHypfH9htXiQ14n7Nv" +
       "22PDroDtt18MtlceYeN1Tw5D8DMGY+GjVx6pi4B6N/A+808f/trbn3n4L4qY" +
       "9CY7BqFQPTIvs+RyrMwPnvv2d//09gc/VUzcrlfkeBcUnVyrunQp6qIVpgL/" +
       "bYdCuSOXQX7xnr3KF+ekZF3jckC+EiCvE6ifuokdunonkjUbFOZAIJrsl/EO" +
       "lh7+ztra6cozF89Iz4M522DHfXdOSuo1AgLaEEPxylTAdDjWI2gQaDpnq44e" +
       "cbKvuwe8/y6aKbp7cDg1ObNf7SgsI08+fqD0v395pT8LQtowVVxbvcijnXN1" +
       "39wtXBUW+ex+yMrbOLsreDAov+JoUG66ga/nk9ODZ7vVGTu4cLh2Cx5ml6CN" +
       "So9f2ar6hXIfzV+++K7/eb/wZuttV7Es89oTRneyyt/vP/flzhvUD58tXXc4" +
       "m7lkYffiQk9cPIe5JdKTNPKFi2YyD+46oJDfKS7nuZ3QT5lhf/6UZ1/Ikz8E" +
       "8xE1F/6ur07J/vyxeewlyvKPD5TlT66gLAXcY4qSJ588VJLfvVRJ8p+fzpN/" +
       "fmmv578/t2u2KJ0nf3QK9C+f8uwrefLFPPnjHZJT8v77rHRikPlHL2EAVPaD" +
       "jHKFQeY/vKjRWQtS5QVG56+/BHDqHpx6BXB/9qJG5yNwVxqdv3mV2HCA6aN7" +
       "bNoVsH3rRY3OR9iOjc4Xe/+ixTsOWrpciztVCcOT+vDtF6RVwAAzS2B36AXi" +
       "Apz//stTgsbCaC4OGl+1cNVHDhYHJnoUAx/2yMIlDnznseWK3QuiEyC7Lxok" +
       "8K93HFXGBr75xPv/+4e++sGHvw3CE+ZggSTP3QBynrz7x/e/Jf/xg6vjc3/O" +
       "Z1yMZbm69IuVSl07pNQ7BnqYlK4H7uqlU0ruYbuVmK4f/LETpYnV1Uzy05nq" +
       "jdm2w23WEGnEwdCIGpFQtx2+bm/YvsguYTWmx8FmyuCaoqNDToi3fupNkFQi" +
       "ueZSNUYkzaPbJsa7M3FBZcFoO1RFr91bs5WepZoN2FlyFE3XjZ5JWUyzoWsb" +
       "ta7PVA4yOKW/HRLxNvaF8cTBVkRXwDAIwmpaDYJqmKBDYdKP481mtFzGvEnM" +
       "2/UIWU4zI/ZgmQ0Fd5xFFIMPNu1y4Kyq21o1rXUr5bHndccuM427rreRWa2J" +
       "KCNEYOaRF4uOIEtTFp+E0aC9EoNUnmeMoHXQOdtuxny/OmpPXIubLeV5QFkb" +
       "cTNOeWYRhmyvX12uG0Jzw9U9OWMdjxxVIc1Px1umjVQqDcVgOr7eU/0GvPIw" +
       "dh7z7nKs42LWk6q+bYVcz5Iitmo5Dt6JGtvecuv14HWHIRAxSZrL6nDmhp21" +
       "tFwNFIhYS5jUdogGR/mC1lesqZCGoZwsBgzsbHVCYMOZF3GYw8LuxFnwleaC" +
       "G7v+SF6Iw4U6XYgjPZ3WU1hZSgqn6YHa8vsOwpubXizQuEtblsf3hpOkz9VU" +
       "iRmMss42XbU61qytUT23I44WKNrrQliTCOXuEl5s+x13mtTbIr+eu53WaNOi" +
       "hfGMXsoTR8UFjWtJvUrHF5C6IE7G7nyACoQmjx1ZmDZwHMOpdrc8H8grGp3J" +
       "uNlddxRP0iXFUqzFrNeKfWgAqndbnYaGd+hJk11lw1EznsD1TEVGzZQYRpNh" +
       "TUhao0UPghHbWoAAj2qKrIjyiDtlt9IkEv21yY56FEK5LN836gNO6LsN2DUr" +
       "HbnV2zDteqB6CE0uKuEINka0j7llR5y6TDSw1fpy0dyu2+XhOGD0abkbMfC2" +
       "tqoh1SyrYHLLRnr0srH14mCJJ2TdnSiVXoo6QW3s9OtVKhMcxcE0tpmRBGWL" +
       "VNOG1m1eclcrZ1bFCXk1ZGMYZ/uwGbpllyGWatapMsMwtMgUr23X5DgUA5IY" +
       "sSORWK1H1S46q2lOlViP6lxM1ANKGCyEVJF8sVaupvMu3k54MSTNgdJLq/7A" +
       "5LGBy03VoLcQIV6YLIGpehQ6QhGtB3qm1pBTqrycWiI3hJWuIgbjamPpCuUl" +
       "bLiroGOKfLPRrs2aK7k3xFW0RrP91aq5nlthY572TT1NRJ4st9RFWh5InGgs" +
       "HDsL7aXSLcOwRk6SjGyZYaU1V4RKd0JUQKSeVCiqso0ke56aPOIsJZTvzIfl" +
       "TO9KczEIeR6n0Awdu6Yk9pXRdk5KSq/Z6uj6kG8OmtC2BVUmvIkNMWCzKsyX" +
       "p1Z5WtOrFizr1Fxum2Tbs6rtAdyx+oNGtFiosgnzJtqxk8ilRvaqh1VRdhFI" +
       "qe0YQktda9AQFRrrdW1CLJabsL6KN9kybczHGzz0BB2f8TUz5Wi+PNpGcxiQ" +
       "qKGkoi/CVshM7alUHYuTsEoN++v+cJxU/UWZqvYkm8do13Knmr1u+AOkM5Ub" +
       "ESkOqO5cTCO4P41sFVY8fTOqwNl8CHcX67Dd5g2MRf1VW7E8QqbsGQ9HTt2r" +
       "rtuKuYlqeL/LYtFyEJHcsjnGykZTIap4tVxtpXowHG/UqUSRyZIO5ojhrdbw" +
       "tm8ryNo1ppwTi4PE5xSp0kOlRq/PdodUz8hid7tUNFXb0OGoUl+UAVuXzjbl" +
       "TsX3JgNDy2rrGIHZqGwolRoVW5t0U8asDUtmwBAb+GjWjAbdodFcVDKuydR1" +
       "Tu8C5zyoaus0hKvhwNmWR7URkhLZdGPH7iwF3pSQWuFSHEXujCj7EMR2sFYZ" +
       "sgdm7CKutIzrmCCsGjOYntRJFOEIDKrWNG24shoIIW34aTwQ6cbStsZMb9us" +
       "D+ixbaXGNB2lrcqkWx/ILSlB0NAM+suAXk5E2+Yio7qazYzNAKthPG1mDWus" +
       "D7tTVJ/SLcLgKFRd9bdpraas1QklMVllprHqPO4pW6zvalXb0+otpDfYbjCO" +
       "gXRqibfL8zbZn07VsLGpwUGlORcwdCmqUCbrRjKeaZnj4ZvNqiapwz5Vrg+a" +
       "rFFWaWIhciuuiw9lJJbnM4dIYXWDBpPaXOmV60N6RXZTvyv1JtaMNjgtIYx5" +
       "gtfM4WhYX48lo1mZhCQDRe0RsDwUn3gIB3mYsoFUkuwvqRT2anKQhkrscnFE" +
       "K63GSvZmjYSX+wJScYe+TrZCetoKp6I5rhFmfbyKBhkyE7yWqtAc57MNBCcr" +
       "mk4jiid3HLYjImitqSCQPfE9lQiIuFHFIaI/EQwMwlIw5A3WY6KPlGu8DmFL" +
       "2VUMqGtIEr/lkbnVXHUn3QpucBHukOQSA4oxC9BWkjhstVWf6KiMErV5VzXg" +
       "2Qzprv2xt+yO50mckZOWE0ZdVQj6sdxyG/14NKwajktKCB1YIdD/vjSrrqqe" +
       "PyXIlerx3TQWBH0ARSqCsvF6iawjpd+tLZZQucxsQ7YeTJre1GzV0RGJTWfY" +
       "Nqt2U6zLVkg7HviIZS9byw2cDic4mVllqDYL52SsLFZErGB+l0LYFj/WKmQG" +
       "Wbgo9dm054n0FOuL0pJtEEwfjKwywy5JuMeOQt6FB23SC/QQ8cYutZWGtslV" +
       "3fpUWFbp1mwbenw1UcqQQfO1CMeyFpooVrMxaadrA8tQIH10Fce1Go8MuzA3" +
       "DDOc8fR5dYEJPJ2MIJGr8MMW3kfwoL+ojMRJEoUZjEd21FkszPLIxLTGplFe" +
       "cjPEUA3DaNfrZDtFom29pq74FRdsNXXCV2YEVZ9OUrSxak2peTyqj3QBR5oE" +
       "Mu0kZCPSVtvqFh90iVYGT6fRdGolAy1uhyRJaZC+kNAtWS5PN53eEmFjfjzG" +
       "PdHMymFooAu1CXMypKyIqS8jE0xoZQxsaTOXQ6uoY8+mUS2ZzMtV3Yk1tAsg" +
       "m0rHn/fpamcA1zUbjRVYdTZp21Pm3dRcDOFVF2nIFSRJvDQiml6/p8hoo27Q" +
       "JuYp9YYpOhATltN+o9f0vIaTWCYzmwRyd72tVjojvymrrchE0GmmT9fjLpmF" +
       "5sY24xbTH1SIZCHFY4wfaiywtGEXQVbUmFkTHb4rDrE4xdVKXGEmFiElpkup" +
       "qKKKZBcSamKlWd5MpPV83YJNZNhZLdr12ExrCV7GNpW2TgRardLBVYY107SJ" +
       "byaaqdaH+FZcy9hQrG/4Foymfb4+I5hF3IkJLiIkMHqhvWmTQTdYpx61SEwa" +
       "Z1mddlLE7KSYgjLdgHDC6RprVRl2sLLSxEpVMa67y4GQRbQ7atELQcShWnPe" +
       "oapTq8vEjkvhFTaiFKwR1KuGLQbT9cDpZ3SwRt0QTYg6wxDbjGQiHxttRCUR" +
       "rK7RlppqRK+dtdOt1Hok54w0Txq7cgNYRGVg4+1JP3agLIXYSkizdcleK0g2" +
       "9Rp1ZiBUjaCDjBRBNSaDcTibGLPmGA8YYTHEsw6xdkYDBGpOZpgTtORFP8MQ" +
       "DWHUKmOtqXJUGyDN/oh1bHjOK8jWIIcjAQk1qKY0aXkTtV2C0LZcwiGqt6oy" +
       "hEOORdSYwmHWm48YoTueWqrawJbwcNWZJFoZwlVB9iFuMmcQAJGu0wnVKxND" +
       "fZiWVWOFJtVsOePIMSb0gizoTzodCFbQ8oxA7JkC85nQ38icHRO1idU2KLIn" +
       "NauGhpZ7ijPBoC2GUBjVEzPXIUfQRF21azY6FiZ9exspbWCyXXuoLc14kE49" +
       "m3SlbBNBK4VW7D67zGLbn1DiFDK3Al5uSptwVQeR3IIMBIuNhotgSQtgxrWl" +
       "K43hRFMDIggqYJACYV17kRmq6rSdAK7NnQ0cT7EWSg5r2ATHgXFC2GZWizfo" +
       "Rt5ac5+bOJv1eO5BkwozUMw1KivkUqhhOLqZtiaoggkdGlOBCCor2F7Vwm05" +
       "AiOoDRltfboS4/EmTdcToeO5tYR1eRZhphohji11JMMzjKxVWG/U0ykX1uOo" +
       "C4vOQt9UTbK1ThYdJdGnVEiTUnlK1GamuSZaMY4IUtzjhrZC6kGdUTNTJ8mZ" +
       "g4PJGedW03S12HLbRjVJ1lPSUDmeHZIDe76yqBY+ERe6V7VJU3U5qzm3pFmN" +
       "gBLBFGoe1OW2eLup6O4Q88Q1tUX1WksieiZq1YOQm5BywNQrEhzizZXCqkGj" +
       "HFWUpVcbKSNTnHXRVj2YYczSTzO8aenldQded5eQ7YrYjK8rRnMZRUt9VKe2" +
       "3Y1nbAIQJHT7C6ZBZZJQTTt9peppS2NEmEHKWDrbjFrcdkbVKsooWK9XqSZI" +
       "28ospIemyyYQM5z5Ecxz4WoVp5rZm2PzbV8CntsRo+5yGPCMIBOG2xBNQu9V" +
       "WEWRvS2mlulmy6A20LJRVQKLwiotbGh5826oicDPjhSyyruq3Zx3SX4KJqj9" +
       "zbZu8o4bVLyZraH4RgeT6D5jK/BEZiJWJVkErsx5UmgSwO3LFchbLKB0CPd5" +
       "x+nPBWYkblKKoMsVwoNMqb0cTldcGZ10thNXbZPsWnKyad+lV7UljHdFx9pq" +
       "U09ro67jylVe0bhJjIg+sqYX4pQSOKrWncHjHtve+FiLqKyzMh0ImoAym44B" +
       "xA1PO8x4PfdJSQ1s3BjLtKy0zQEMS6LT");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
