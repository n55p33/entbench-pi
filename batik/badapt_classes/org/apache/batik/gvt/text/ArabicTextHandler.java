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
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AHHD0w4zXs99UlIDGzfGMi0rbXMAw5Lo");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "vhjiH9sT/9gr19F7zh87hfMzefJbL4LzR6+Bc7G/O3den91z/uzLyPmYKRff" +
       "x5z5vVPofiJP/klSuleNdDnRjxgfbeX53hHnZ6/VoN8CgP1oz/lHrwznnS1/" +
       "7hTO/yJPPp2U7s7D9t2HTaxtFl/onzDoz1yrXj8EoN++K7s7v1J8nz+F75/k" +
       "yeeT0q1ApQepdzjxOKbM/+plmHWd3UeYZ1/RCPOrpxD9Wp58Mcm/DLxCh37p" +
       "anhmwAtc8j13/m3qfZf804jdPzpQP/XM+Zte84z4Z7ud8Qf/jOBmtnSTkbru" +
       "8U8Jj12fCyPdsAv2N+8+LAwLNv8xKb32ih+ag0lnfsoxn/nGLv83QQhyufxJ" +
       "6TqQHs/5X8HQfTJnUrqhOB/P9y0gyqN8Senc7uJ4lr8AtYMs+eV3dntZL94R" +
       "uPv2MtvNm+47rkDFssvdL9QfxxZQHr5o63Xx7z0Otkmnu3/w8aT66WeYwa/8" +
       "EP/47tts1ZW3eaxSuokt3bj7TLyoNN9q/dAVazuo61z3sR/f8ZmbHz1Ykrlj" +
       "B/hImY9he/3lv4OmvDApvlze/tFrPvdz/+yZbxVfcP5/to2yindFAAA=");
}
