package org.apache.batik.gvt.flow;
public class TextLineBreaks {
    public static final java.text.AttributedCharacterIterator.Attribute WORD_LIMIT =
      new org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute(
      "WORD_LIMIT");
    public static final java.text.AttributedCharacterIterator.Attribute
      FLOW_PARAGRAPH =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        FLOW_PARAGRAPH;
    public static final java.text.AttributedCharacterIterator.Attribute
      FLOW_LINE_BREAK =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        FLOW_LINE_BREAK;
    static java.util.Set lineBrks = new java.util.HashSet(
      );
    static { lineBrks.add(FLOW_PARAGRAPH);
             lineBrks.add(FLOW_LINE_BREAK); }
    static int findComplexBreak(java.text.AttributedCharacterIterator aci) {
        int cnt =
          0;
        for (char ch =
               aci.
               current(
                 );
             ch ==
               java.text.AttributedCharacterIterator.
                 DONE;
             ch =
               aci.
                 next(
                   ),
               cnt++) {
            if (getCharCharClass(
                  ch) !=
                  CHAR_CLASS_SA)
                break;
        }
        return cnt;
    }
    public static void findLineBrk(java.text.AttributedString as) {
        java.text.AttributedCharacterIterator aci =
          as.
          getIterator(
            );
        if (aci.
              getEndIndex(
                ) ==
              0)
            return;
        char ch =
          aci.
          current(
            );
        char prevCh =
          (char)
            -1;
        byte cls =
          getCharCharClass(
            ch);
        if (cls ==
              CHAR_CLASS_LF)
            cls =
              CHAR_CLASS_BK;
        byte curCls =
          cls;
        byte prevCls =
          cls;
        byte prevPrevCls =
          -1;
        int wordCnt =
          0;
        int wordBegin =
          aci.
          getBeginIndex(
            );
        int ich =
          wordBegin +
          1;
        int lineEnd =
          aci.
          getRunLimit(
            lineBrks);
        if (cls >=
              CHAR_CLASS_CM)
            cls =
              CHAR_CLASS_AL;
        for (ch =
               aci.
                 next(
                   );
             ch !=
               java.text.AttributedCharacterIterator.
                 DONE;
             ich++,
               prevCh =
                 ch,
               ch =
                 aci.
                   next(
                     ),
               prevPrevCls =
                 prevCls,
               prevCls =
                 curCls) {
            if (ich ==
                  lineEnd) {
                as.
                  addAttribute(
                    WORD_LIMIT,
                    new java.lang.Integer(
                      wordCnt++),
                    wordBegin,
                    ich);
                wordBegin =
                  ich;
                cls =
                  getCharCharClass(
                    ch);
                curCls =
                  cls;
                prevCls =
                  cls;
                if (cls >=
                      CHAR_CLASS_CM)
                    cls =
                      CHAR_CLASS_AL;
                lineEnd =
                  aci.
                    getRunLimit(
                      lineBrks);
                continue;
            }
            curCls =
              getCharCharClass(
                ch);
            if (curCls ==
                  CHAR_CLASS_SP) {
                continue;
            }
            if (curCls ==
                  CHAR_CLASS_SA) {
                ich +=
                  findComplexBreak(
                    aci);
                ch =
                  aci.
                    previous(
                      );
                if (ch !=
                      java.text.AttributedCharacterIterator.
                        DONE)
                    prevCls =
                      getCharCharClass(
                        ch);
                ch =
                  aci.
                    next(
                      );
                if (ch !=
                      java.text.AttributedCharacterIterator.
                        DONE)
                    curCls =
                      (cls =
                         getCharCharClass(
                           ch));
                continue;
            }
            if (ch ==
                  CHAR_ZERO_WIDTH_JOINER ||
                  prevCh ==
                  CHAR_ZERO_WIDTH_JOINER)
                continue;
            if (curCls ==
                  CHAR_CLASS_BK ||
                  curCls ==
                  CHAR_CLASS_LF) {
                as.
                  addAttribute(
                    WORD_LIMIT,
                    new java.lang.Integer(
                      wordCnt++),
                    wordBegin,
                    ich);
                wordBegin =
                  ich;
                cls =
                  CHAR_CLASS_BK;
                continue;
            }
            if (prevCls ==
                  CHAR_CLASS_CR) {
                as.
                  addAttribute(
                    WORD_LIMIT,
                    new java.lang.Integer(
                      wordCnt++),
                    wordBegin,
                    ich -
                      1);
                wordBegin =
                  ich -
                    1;
                cls =
                  CHAR_CLASS_BK;
                continue;
            }
            if (curCls ==
                  CHAR_CLASS_CR) {
                continue;
            }
            if (curCls ==
                  CHAR_CLASS_CM) {
                if (prevCls ==
                      CHAR_CLASS_SP) {
                    cls =
                      CHAR_CLASS_ID;
                    if (prevPrevCls !=
                          -1) {
                        if (brkPairs[prevPrevCls][CHAR_CLASS_ID] ==
                              BREAK_ACTION_DIRECT) {
                            as.
                              addAttribute(
                                WORD_LIMIT,
                                new java.lang.Integer(
                                  wordCnt++),
                                wordBegin,
                                ich -
                                  1);
                            wordBegin =
                              ich -
                                1;
                        }
                        else {
                            
                        }
                    }
                }
                continue;
            }
            if (cls ==
                  CHAR_CLASS_BK) {
                cls =
                  curCls;
                continue;
            }
            byte brk =
              brkPairs[cls][curCls];
            if (brk ==
                  BREAK_ACTION_DIRECT) {
                as.
                  addAttribute(
                    WORD_LIMIT,
                    new java.lang.Integer(
                      wordCnt++),
                    wordBegin,
                    ich);
                wordBegin =
                  ich;
            }
            else
                if (brk ==
                      BREAK_ACTION_INDIRECT) {
                    if (prevCls ==
                          CHAR_CLASS_SP) {
                        as.
                          addAttribute(
                            WORD_LIMIT,
                            new java.lang.Integer(
                              wordCnt++),
                            wordBegin,
                            ich);
                        wordBegin =
                          ich;
                    }
                }
            cls =
              curCls;
        }
        as.
          addAttribute(
            WORD_LIMIT,
            new java.lang.Integer(
              wordCnt++),
            wordBegin,
            ich);
        wordBegin =
          ich;
        return;
    }
    public static byte[] stringToLineBreakClasses(java.lang.String s) {
        int len =
          s.
          length(
            );
        byte[] ret =
          new byte[len];
        for (int i =
               0;
             i <
               len;
             i++) {
            ret[i] =
              getCharCharClass(
                s.
                  charAt(
                    i));
        }
        return ret;
    }
    public static byte getCharCharClass(char ch) { if (ch <
                                                         QUICK_LUT_SIZE) {
                                                       if (quickLut ==
                                                             null)
                                                           buildQuickLut(
                                                             );
                                                       return quickLut[ch];
                                                   }
                                                   int len =
                                                     raw_data.
                                                       length;
                                                   int l =
                                                     0;
                                                   int r =
                                                     len /
                                                     2 -
                                                     1;
                                                   int entry =
                                                     (l +
                                                        r) /
                                                     2;
                                                   while (l <=
                                                            r) {
                                                       char min =
                                                         raw_data[2 *
                                                                    entry];
                                                       char max =
                                                         raw_data[2 *
                                                                    entry +
                                                                    1];
                                                       if (ch <
                                                             min)
                                                           r =
                                                             entry -
                                                               1;
                                                       else
                                                           if (ch >
                                                                 max)
                                                               l =
                                                                 entry +
                                                                   1;
                                                           else
                                                               break;
                                                       entry =
                                                         (l +
                                                            r) /
                                                           2;
                                                   }
                                                   return raw_classes[entry];
    }
    public static final char CHAR_ZERO_WIDTH_JOINER = 8205;
    protected static final int QUICK_LUT_SIZE = 256;
    protected static void buildQuickLut() { int entry = 0;
                                            quickLut = (new byte[QUICK_LUT_SIZE]);
                                            int i = 0;
                                            while (i < QUICK_LUT_SIZE) {
                                                int max =
                                                  raw_data[2 *
                                                             entry +
                                                             1];
                                                byte cls =
                                                  raw_classes[entry];
                                                while (i <=
                                                         max) {
                                                    quickLut[i] =
                                                      cls;
                                                    i++;
                                                    if (i >=
                                                          QUICK_LUT_SIZE)
                                                        break;
                                                }
                                                entry++;
                                            } }
    public static final byte BREAK_ACTION_DIRECT = 0;
    public static final byte BREAK_ACTION_INDIRECT = 1;
    public static final byte BREAK_ACTION_PROHIBITED = 2;
    public static final java.lang.String[] brkStrs = { "DB",
    "IB",
    "PB" };
    public static final byte CHAR_CLASS_OP = 0;
    public static final byte CHAR_CLASS_CL = 1;
    public static final byte CHAR_CLASS_QU = 2;
    public static final byte CHAR_CLASS_GL = 3;
    public static final byte CHAR_CLASS_NS = 4;
    public static final byte CHAR_CLASS_EX = 5;
    public static final byte CHAR_CLASS_SY = 6;
    public static final byte CHAR_CLASS_IS = 7;
    public static final byte CHAR_CLASS_PR = 8;
    public static final byte CHAR_CLASS_PO = 9;
    public static final byte CHAR_CLASS_NU = 10;
    public static final byte CHAR_CLASS_AL = 11;
    public static final byte CHAR_CLASS_ID = 12;
    public static final byte CHAR_CLASS_IN = 13;
    public static final byte CHAR_CLASS_HY = 14;
    public static final byte CHAR_CLASS_BA = 15;
    public static final byte CHAR_CLASS_BB = 16;
    public static final byte CHAR_CLASS_B2 = 17;
    public static final byte CHAR_CLASS_ZW = 18;
    public static final byte CHAR_CLASS_CM = 19;
    public static final byte CHAR_CLASS_SA = 20;
    public static final byte CHAR_CLASS_SP = 21;
    public static final byte CHAR_CLASS_BK = 22;
    public static final byte CHAR_CLASS_AI = CHAR_CLASS_AL;
    public static final byte CHAR_CLASS_CR = 24;
    public static final byte CHAR_CLASS_LF = 25;
    public static final byte CHAR_CLASS_SG = CHAR_CLASS_AL;
    public static final byte CHAR_CLASS_XX = CHAR_CLASS_AL;
    public static final byte CHAR_CLASS_CB = 28;
    public static final java.lang.String[] clsStrs = { "OP",
    "CL",
    "QU",
    "GL",
    "NS",
    "EX",
    "SY",
    "IS",
    "PR",
    "PO",
    "NU",
    "AL",
    "ID",
    "IN",
    "HY",
    "BA",
    "BB",
    "B2",
    "ZW",
    "CM",
    "SA",
    "SP",
    "BK",
    "AI",
    "CR",
    "LF",
    "SG",
    "XX",
    "CB" };
    static byte[][] brkPairs = { { 2, 2, 2, 2, 2, 2, 2, 2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    2,
    1 },
    { 0,
    2,
    1,
    1,
    2,
    2,
    2,
    2,
    0,
    1,
    0,
    0,
    0,
    0,
    1,
    1,
    0,
    0,
    2,
    1 },
    { 2,
    2,
    1,
    1,
    1,
    2,
    2,
    2,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    2,
    1 },
    { 1,
    2,
    1,
    1,
    1,
    2,
    2,
    2,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    2,
    1 },
    { 0,
    2,
    1,
    1,
    1,
    2,
    2,
    2,
    0,
    0,
    0,
    0,
    0,
    0,
    1,
    1,
    0,
    0,
    2,
    1 },
    { 0,
    2,
    1,
    1,
    1,
    2,
    2,
    2,
    0,
    0,
    0,
    0,
    0,
    0,
    1,
    1,
    0,
    0,
    2,
    1 },
    { 0,
    2,
    1,
    1,
    1,
    2,
    2,
    2,
    0,
    0,
    1,
    0,
    0,
    0,
    1,
    1,
    0,
    0,
    2,
    1 },
    { 0,
    2,
    1,
    1,
    1,
    2,
    2,
    2,
    0,
    0,
    1,
    0,
    0,
    0,
    1,
    1,
    0,
    0,
    2,
    1 },
    { 1,
    2,
    1,
    1,
    1,
    2,
    2,
    2,
    0,
    0,
    1,
    1,
    1,
    0,
    1,
    1,
    0,
    0,
    2,
    1 },
    { 0,
    2,
    1,
    1,
    1,
    2,
    2,
    2,
    0,
    0,
    0,
    0,
    0,
    0,
    1,
    1,
    0,
    0,
    2,
    1 },
    { 0,
    2,
    1,
    1,
    1,
    2,
    2,
    2,
    0,
    1,
    1,
    1,
    0,
    1,
    1,
    1,
    0,
    0,
    2,
    1 },
    { 0,
    2,
    1,
    1,
    1,
    2,
    2,
    2,
    0,
    0,
    1,
    1,
    0,
    1,
    1,
    1,
    0,
    0,
    2,
    1 },
    { 0,
    2,
    1,
    1,
    1,
    2,
    2,
    2,
    0,
    1,
    0,
    0,
    0,
    1,
    1,
    1,
    0,
    0,
    2,
    1 },
    { 0,
    2,
    1,
    1,
    1,
    2,
    2,
    2,
    0,
    0,
    0,
    0,
    0,
    1,
    1,
    1,
    0,
    0,
    2,
    1 },
    { 0,
    2,
    1,
    1,
    1,
    2,
    2,
    2,
    0,
    0,
    0,
    0,
    0,
    0,
    1,
    1,
    0,
    0,
    2,
    1 },
    { 0,
    2,
    1,
    1,
    1,
    2,
    2,
    2,
    0,
    0,
    0,
    0,
    0,
    0,
    1,
    1,
    0,
    0,
    2,
    1 },
    { 1,
    2,
    1,
    1,
    1,
    2,
    2,
    2,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    2,
    1 },
    { 0,
    2,
    1,
    1,
    1,
    2,
    2,
    2,
    0,
    0,
    0,
    0,
    0,
    0,
    1,
    1,
    0,
    2,
    2,
    1 },
    { 0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    2,
    1 },
    { 0,
    2,
    1,
    1,
    1,
    2,
    2,
    2,
    0,
    0,
    1,
    1,
    0,
    1,
    1,
    1,
    0,
    0,
    2,
    1 } };
    static byte[] quickLut = null;
    static final char[] raw_data = { 0, 8, 9, 9, 10, 10, 11,
    11,
    12,
    12,
    13,
    13,
    14,
    31,
    32,
    32,
    33,
    33,
    34,
    34,
    35,
    35,
    36,
    36,
    37,
    37,
    38,
    38,
    39,
    39,
    40,
    40,
    41,
    41,
    42,
    42,
    43,
    43,
    44,
    44,
    45,
    45,
    46,
    46,
    47,
    47,
    48,
    57,
    58,
    59,
    60,
    62,
    63,
    63,
    64,
    90,
    91,
    91,
    92,
    92,
    93,
    93,
    94,
    122,
    123,
    123,
    124,
    124,
    125,
    125,
    126,
    126,
    127,
    159,
    160,
    160,
    161,
    161,
    162,
    162,
    163,
    165,
    166,
    166,
    167,
    168,
    169,
    169,
    170,
    170,
    171,
    171,
    172,
    172,
    173,
    173,
    174,
    175,
    176,
    176,
    177,
    177,
    178,
    179,
    180,
    180,
    181,
    181,
    182,
    186,
    187,
    187,
    188,
    191,
    192,
    197,
    198,
    198,
    199,
    207,
    208,
    208,
    209,
    214,
    215,
    216,
    217,
    221,
    222,
    225,
    226,
    229,
    230,
    230,
    231,
    231,
    232,
    234,
    235,
    235,
    236,
    237,
    238,
    239,
    240,
    240,
    241,
    241,
    242,
    243,
    244,
    246,
    247,
    250,
    251,
    251,
    252,
    252,
    253,
    253,
    254,
    254,
    255,
    256,
    257,
    257,
    258,
    272,
    273,
    273,
    274,
    274,
    275,
    275,
    276,
    282,
    283,
    283,
    284,
    293,
    294,
    295,
    296,
    298,
    299,
    299,
    300,
    304,
    305,
    307,
    308,
    311,
    312,
    312,
    313,
    318,
    319,
    322,
    323,
    323,
    324,
    324,
    325,
    327,
    328,
    330,
    331,
    332,
    333,
    333,
    334,
    337,
    338,
    339,
    340,
    357,
    358,
    359,
    360,
    362,
    363,
    363,
    364,
    461,
    462,
    462,
    463,
    463,
    464,
    464,
    465,
    465,
    466,
    466,
    467,
    467,
    468,
    468,
    469,
    469,
    470,
    470,
    471,
    471,
    472,
    472,
    473,
    473,
    474,
    474,
    475,
    475,
    476,
    476,
    477,
    592,
    593,
    593,
    594,
    608,
    609,
    609,
    610,
    710,
    711,
    711,
    712,
    712,
    713,
    715,
    716,
    716,
    717,
    717,
    718,
    719,
    720,
    720,
    721,
    727,
    728,
    731,
    732,
    732,
    733,
    733,
    734,
    750,
    768,
    879,
    884,
    912,
    913,
    937,
    938,
    944,
    945,
    961,
    962,
    962,
    963,
    969,
    970,
    1024,
    1025,
    1025,
    1026,
    1039,
    1040,
    1103,
    1104,
    1104,
    1105,
    1105,
    1106,
    1154,
    1155,
    1161,
    1162,
    1415,
    1417,
    1417,
    1418,
    1418,
    1425,
    1469,
    1470,
    1470,
    1471,
    1471,
    1472,
    1472,
    1473,
    1474,
    1475,
    1475,
    1476,
    1476,
    1488,
    1610,
    1611,
    1621,
    1632,
    1641,
    1642,
    1647,
    1648,
    1648,
    1649,
    1749,
    1750,
    1764,
    1765,
    1766,
    1767,
    1768,
    1769,
    1769,
    1770,
    1773,
    1776,
    1785,
    1786,
    1805,
    1807,
    1807,
    1808,
    1808,
    1809,
    1809,
    1810,
    1836,
    1840,
    1866,
    1920,
    1957,
    1958,
    1968,
    1969,
    1969,
    2305,
    2307,
    2309,
    2361,
    2364,
    2364,
    2365,
    2365,
    2366,
    2381,
    2384,
    2384,
    2385,
    2388,
    2392,
    2401,
    2402,
    2403,
    2404,
    2405,
    2406,
    2415,
    2416,
    2416,
    2433,
    2435,
    2437,
    2489,
    2492,
    2519,
    2524,
    2529,
    2530,
    2531,
    2534,
    2543,
    2544,
    2545,
    2546,
    2547,
    2548,
    2554,
    2562,
    2562,
    2565,
    2617,
    2620,
    2637,
    2649,
    2654,
    2662,
    2671,
    2672,
    2673,
    2674,
    2676,
    2689,
    2691,
    2693,
    2745,
    2748,
    2748,
    2749,
    2749,
    2750,
    2765,
    2768,
    2784,
    2790,
    2799,
    2817,
    2819,
    2821,
    2873,
    2876,
    2876,
    2877,
    2877,
    2878,
    2903,
    2908,
    2913,
    2918,
    2927,
    2928,
    2928,
    2946,
    2946,
    2947,
    3001,
    3006,
    3031,
    3047,
    3055,
    3056,
    3058,
    3073,
    3075,
    3077,
    3129,
    3134,
    3158,
    3168,
    3169,
    3174,
    3183,
    3202,
    3203,
    3205,
    3257,
    3262,
    3286,
    3294,
    3297,
    3302,
    3311,
    3330,
    3331,
    3333,
    3385,
    3390,
    3415,
    3424,
    3425,
    3430,
    3439,
    3458,
    3459,
    3461,
    3526,
    3530,
    3571,
    3572,
    3572,
    3585,
    3632,
    3633,
    3633,
    3634,
    3635,
    3636,
    3642,
    3647,
    3647,
    3648,
    3654,
    3655,
    3662,
    3663,
    3663,
    3664,
    3673,
    3674,
    3675,
    3713,
    3760,
    3761,
    3761,
    3762,
    3763,
    3764,
    3772,
    3773,
    3782,
    3784,
    3789,
    3792,
    3801,
    3804,
    3805,
    3840,
    3850,
    3851,
    3851,
    3852,
    3852,
    3853,
    3863,
    3864,
    3865,
    3866,
    3871,
    3872,
    3881,
    3882,
    3892,
    3893,
    3893,
    3894,
    3894,
    3895,
    3895,
    3896,
    3896,
    3897,
    3897,
    3898,
    3898,
    3899,
    3899,
    3900,
    3900,
    3901,
    3901,
    3902,
    3903,
    3904,
    3946,
    3953,
    3972,
    3973,
    3973,
    3974,
    3975,
    3976,
    3979,
    3984,
    4028,
    4030,
    4037,
    4038,
    4038,
    4039,
    4047,
    4096,
    4138,
    4140,
    4153,
    4160,
    4169,
    4170,
    4175,
    4176,
    4181,
    4182,
    4185,
    4256,
    4347,
    4352,
    4447,
    4448,
    4601,
    4608,
    4954,
    4961,
    4961,
    4962,
    4968,
    4969,
    4977,
    4978,
    5750,
    5760,
    5760,
    5761,
    5786,
    5787,
    5787,
    5788,
    5788,
    5792,
    5905,
    5906,
    5908,
    5920,
    5937,
    5938,
    5940,
    5941,
    5969,
    5970,
    5971,
    5984,
    6000,
    6002,
    6003,
    6016,
    6067,
    6068,
    6099,
    6100,
    6100,
    6101,
    6101,
    6102,
    6106,
    6107,
    6107,
    6108,
    6108,
    6112,
    6121,
    6144,
    6149,
    6150,
    6150,
    6151,
    6154,
    6155,
    6158,
    6160,
    6169,
    6176,
    6312,
    6313,
    6313,
    7680,
    8190,
    8192,
    8198,
    8199,
    8199,
    8200,
    8202,
    8203,
    8203,
    8204,
    8207,
    8208,
    8208,
    8209,
    8209,
    8210,
    8211,
    8212,
    8212,
    8213,
    8214,
    8215,
    8215,
    8216,
    8217,
    8218,
    8218,
    8219,
    8221,
    8222,
    8222,
    8223,
    8223,
    8224,
    8225,
    8226,
    8227,
    8228,
    8230,
    8231,
    8231,
    8232,
    8233,
    8234,
    8238,
    8239,
    8239,
    8240,
    8247,
    8248,
    8248,
    8249,
    8250,
    8251,
    8251,
    8252,
    8252,
    8253,
    8259,
    8260,
    8260,
    8261,
    8261,
    8262,
    8262,
    8263,
    8279,
    8287,
    8287,
    8288,
    8288,
    8289,
    8291,
    8298,
    8303,
    8304,
    8305,
    8308,
    8308,
    8309,
    8316,
    8317,
    8317,
    8318,
    8318,
    8319,
    8319,
    8320,
    8320,
    8321,
    8324,
    8325,
    8332,
    8333,
    8333,
    8334,
    8334,
    8352,
    8358,
    8359,
    8359,
    8360,
    8369,
    8400,
    8426,
    8448,
    8450,
    8451,
    8451,
    8452,
    8452,
    8453,
    8453,
    8454,
    8456,
    8457,
    8457,
    8458,
    8466,
    8467,
    8467,
    8468,
    8469,
    8470,
    8470,
    8471,
    8480,
    8481,
    8482,
    8483,
    8485,
    8486,
    8486,
    8487,
    8490,
    8491,
    8491,
    8492,
    8511,
    8512,
    8512,
    8513,
    8531,
    8532,
    8533,
    8534,
    8538,
    8539,
    8539,
    8540,
    8541,
    8542,
    8542,
    8543,
    8543,
    8544,
    8555,
    8556,
    8559,
    8560,
    8569,
    8570,
    8579,
    8592,
    8601,
    8602,
    8657,
    8658,
    8658,
    8659,
    8659,
    8660,
    8660,
    8661,
    8703,
    8704,
    8704,
    8705,
    8705,
    8706,
    8707,
    8708,
    8710,
    8711,
    8712,
    8713,
    8714,
    8715,
    8715,
    8716,
    8718,
    8719,
    8719,
    8720,
    8720,
    8721,
    8721,
    8722,
    8723,
    8724,
    8724,
    8725,
    8725,
    8726,
    8729,
    8730,
    8730,
    8731,
    8732,
    8733,
    8736,
    8737,
    8738,
    8739,
    8739,
    8740,
    8740,
    8741,
    8741,
    8742,
    8742,
    8743,
    8748,
    8749,
    8749,
    8750,
    8750,
    8751,
    8755,
    8756,
    8759,
    8760,
    8763,
    8764,
    8765,
    8766,
    8775,
    8776,
    8776,
    8777,
    8779,
    8780,
    8780,
    8781,
    8785,
    8786,
    8786,
    8787,
    8799,
    8800,
    8801,
    8802,
    8803,
    8804,
    8807,
    8808,
    8809,
    8810,
    8811,
    8812,
    8813,
    8814,
    8815,
    8816,
    8833,
    8834,
    8835,
    8836,
    8837,
    8838,
    8839,
    8840,
    8852,
    8853,
    8853,
    8854,
    8856,
    8857,
    8857,
    8858,
    8868,
    8869,
    8869,
    8870,
    8894,
    8895,
    8895,
    8896,
    8977,
    8978,
    8978,
    8979,
    9000,
    9001,
    9001,
    9002,
    9002,
    9003,
    9139,
    9140,
    9140,
    9141,
    9141,
    9142,
    9142,
    9143,
    9290,
    9312,
    9407,
    9408,
    9423,
    9424,
    9449,
    9450,
    9450,
    9451,
    9547,
    9548,
    9551,
    9552,
    9588,
    9589,
    9599,
    9600,
    9615,
    9616,
    9617,
    9618,
    9621,
    9622,
    9631,
    9632,
    9633,
    9634,
    9634,
    9635,
    9641,
    9642,
    9649,
    9650,
    9651,
    9652,
    9653,
    9654,
    9655,
    9656,
    9659,
    9660,
    9661,
    9662,
    9663,
    9664,
    9665,
    9666,
    9669,
    9670,
    9672,
    9673,
    9674,
    9675,
    9675,
    9676,
    9677,
    9678,
    9681,
    9682,
    9697,
    9698,
    9701,
    9702,
    9710,
    9711,
    9711,
    9712,
    9732,
    9733,
    9734,
    9735,
    9736,
    9737,
    9737,
    9738,
    9741,
    9742,
    9743,
    9744,
    9747,
    9750,
    9751,
    9753,
    9755,
    9756,
    9756,
    9757,
    9757,
    9758,
    9758,
    9759,
    9791,
    9792,
    9792,
    9793,
    9793,
    9794,
    9794,
    9795,
    9823,
    9824,
    9825,
    9826,
    9826,
    9827,
    9829,
    9830,
    9830,
    9831,
    9834,
    9835,
    9835,
    9836,
    9837,
    9838,
    9838,
    9839,
    9839,
    9840,
    10074,
    10075,
    10078,
    10081,
    10081,
    10082,
    10083,
    10084,
    10087,
    10088,
    10088,
    10089,
    10089,
    10090,
    10090,
    10091,
    10091,
    10092,
    10092,
    10093,
    10093,
    10094,
    10094,
    10095,
    10095,
    10096,
    10096,
    10097,
    10097,
    10098,
    10098,
    10099,
    10099,
    10100,
    10100,
    10101,
    10101,
    10102,
    10213,
    10214,
    10214,
    10215,
    10215,
    10216,
    10216,
    10217,
    10217,
    10218,
    10218,
    10219,
    10219,
    10224,
    10626,
    10627,
    10627,
    10628,
    10628,
    10629,
    10629,
    10630,
    10630,
    10631,
    10631,
    10632,
    10632,
    10633,
    10633,
    10634,
    10634,
    10635,
    10635,
    10636,
    10636,
    10637,
    10637,
    10638,
    10638,
    10639,
    10639,
    10640,
    10640,
    10641,
    10641,
    10642,
    10642,
    10643,
    10643,
    10644,
    10644,
    10645,
    10645,
    10646,
    10646,
    10647,
    10647,
    10648,
    10648,
    10649,
    10711,
    10712,
    10712,
    10713,
    10713,
    10714,
    10714,
    10715,
    10715,
    10716,
    10747,
    10748,
    10748,
    10749,
    10749,
    10750,
    11007,
    11904,
    12288,
    12289,
    12290,
    12291,
    12292,
    12293,
    12293,
    12294,
    12295,
    12296,
    12296,
    12297,
    12297,
    12298,
    12298,
    12299,
    12299,
    12300,
    12300,
    12301,
    12301,
    12302,
    12302,
    12303,
    12303,
    12304,
    12304,
    12305,
    12305,
    12306,
    12307,
    12308,
    12308,
    12309,
    12309,
    12310,
    12310,
    12311,
    12311,
    12312,
    12312,
    12313,
    12313,
    12314,
    12314,
    12315,
    12315,
    12316,
    12316,
    12317,
    12317,
    12318,
    12319,
    12320,
    12329,
    12330,
    12335,
    12336,
    12346,
    12347,
    12348,
    12349,
    12351,
    12353,
    12353,
    12354,
    12354,
    12355,
    12355,
    12356,
    12356,
    12357,
    12357,
    12358,
    12358,
    12359,
    12359,
    12360,
    12360,
    12361,
    12361,
    12362,
    12386,
    12387,
    12387,
    12388,
    12418,
    12419,
    12419,
    12420,
    12420,
    12421,
    12421,
    12422,
    12422,
    12423,
    12423,
    12424,
    12429,
    12430,
    12430,
    12431,
    12436,
    12437,
    12438,
    12441,
    12442,
    12443,
    12446,
    12447,
    12447,
    12448,
    12449,
    12450,
    12450,
    12451,
    12451,
    12452,
    12452,
    12453,
    12453,
    12454,
    12454,
    12455,
    12455,
    12456,
    12456,
    12457,
    12457,
    12458,
    12482,
    12483,
    12483,
    12484,
    12514,
    12515,
    12515,
    12516,
    12516,
    12517,
    12517,
    12518,
    12518,
    12519,
    12519,
    12520,
    12525,
    12526,
    12526,
    12527,
    12532,
    12533,
    12534,
    12535,
    12538,
    12539,
    12539,
    12540,
    12540,
    12541,
    12541,
    12542,
    12727,
    12784,
    12799,
    12800,
    55203,
    55296,
    57343,
    57344,
    63743,
    63744,
    64106,
    64256,
    64285,
    64286,
    64286,
    64287,
    64829,
    64830,
    64830,
    64831,
    64831,
    64848,
    65019,
    65020,
    65020,
    65024,
    65059,
    65072,
    65076,
    65077,
    65077,
    65078,
    65078,
    65079,
    65079,
    65080,
    65080,
    65081,
    65081,
    65082,
    65082,
    65083,
    65083,
    65084,
    65084,
    65085,
    65085,
    65086,
    65086,
    65087,
    65087,
    65088,
    65088,
    65089,
    65089,
    65090,
    65090,
    65091,
    65091,
    65092,
    65092,
    65093,
    65103,
    65104,
    65104,
    65105,
    65105,
    65106,
    65106,
    65108,
    65109,
    65110,
    65111,
    65112,
    65112,
    65113,
    65113,
    65114,
    65114,
    65115,
    65115,
    65116,
    65116,
    65117,
    65117,
    65118,
    65118,
    65119,
    65128,
    65129,
    65129,
    65130,
    65130,
    65131,
    65131,
    65136,
    65276,
    65279,
    65279,
    65281,
    65281,
    65282,
    65283,
    65284,
    65284,
    65285,
    65285,
    65286,
    65287,
    65288,
    65288,
    65289,
    65289,
    65290,
    65291,
    65292,
    65292,
    65293,
    65293,
    65294,
    65294,
    65295,
    65305,
    65306,
    65307,
    65308,
    65310,
    65311,
    65311,
    65312,
    65338,
    65339,
    65339,
    65340,
    65340,
    65341,
    65341,
    65342,
    65370,
    65371,
    65371,
    65372,
    65372,
    65373,
    65373,
    65374,
    65374,
    65375,
    65375,
    65376,
    65377,
    65378,
    65378,
    65379,
    65380,
    65381,
    65381,
    65382,
    65382,
    65383,
    65392,
    65393,
    65437,
    65438,
    65439,
    65440,
    65500,
    65504,
    65504,
    65505,
    65505,
    65506,
    65508,
    65509,
    65510,
    65512,
    65518,
    65529,
    65531,
    65532,
    65532,
    65533,
    65535 };
    static final byte[] raw_classes = { CHAR_CLASS_CM, CHAR_CLASS_BA,
    CHAR_CLASS_LF,
    CHAR_CLASS_CM,
    CHAR_CLASS_BK,
    CHAR_CLASS_CR,
    CHAR_CLASS_CM,
    CHAR_CLASS_SP,
    CHAR_CLASS_EX,
    CHAR_CLASS_QU,
    CHAR_CLASS_AL,
    CHAR_CLASS_PR,
    CHAR_CLASS_PO,
    CHAR_CLASS_AL,
    CHAR_CLASS_QU,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_AL,
    CHAR_CLASS_PR,
    CHAR_CLASS_IS,
    CHAR_CLASS_HY,
    CHAR_CLASS_IS,
    CHAR_CLASS_SY,
    CHAR_CLASS_NU,
    CHAR_CLASS_IS,
    CHAR_CLASS_AL,
    CHAR_CLASS_EX,
    CHAR_CLASS_AL,
    CHAR_CLASS_OP,
    CHAR_CLASS_PR,
    CHAR_CLASS_CL,
    CHAR_CLASS_AL,
    CHAR_CLASS_OP,
    CHAR_CLASS_BA,
    CHAR_CLASS_CL,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_GL,
    CHAR_CLASS_AI,
    CHAR_CLASS_PO,
    CHAR_CLASS_PR,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_QU,
    CHAR_CLASS_AL,
    CHAR_CLASS_BA,
    CHAR_CLASS_AL,
    CHAR_CLASS_PO,
    CHAR_CLASS_PR,
    CHAR_CLASS_AI,
    CHAR_CLASS_BB,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_QU,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_BB,
    CHAR_CLASS_AI,
    CHAR_CLASS_BB,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_IS,
    CHAR_CLASS_BA,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_NU,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_NU,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_NU,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_NU,
    CHAR_CLASS_AL,
    CHAR_CLASS_PR,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_NU,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_NU,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_NU,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_NU,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_NU,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_NU,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_NU,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_SA,
    CHAR_CLASS_CM,
    CHAR_CLASS_SA,
    CHAR_CLASS_CM,
    CHAR_CLASS_PR,
    CHAR_CLASS_SA,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_NU,
    CHAR_CLASS_NS,
    CHAR_CLASS_SA,
    CHAR_CLASS_CM,
    CHAR_CLASS_SA,
    CHAR_CLASS_CM,
    CHAR_CLASS_SA,
    CHAR_CLASS_CM,
    CHAR_CLASS_NU,
    CHAR_CLASS_SA,
    CHAR_CLASS_AL,
    CHAR_CLASS_BA,
    CHAR_CLASS_GL,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_NU,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_SA,
    CHAR_CLASS_CM,
    CHAR_CLASS_NU,
    CHAR_CLASS_AL,
    CHAR_CLASS_SA,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_ID,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_BA,
    CHAR_CLASS_AL,
    CHAR_CLASS_NU,
    CHAR_CLASS_AL,
    CHAR_CLASS_BA,
    CHAR_CLASS_AL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_SA,
    CHAR_CLASS_CM,
    CHAR_CLASS_NS,
    CHAR_CLASS_BA,
    CHAR_CLASS_NS,
    CHAR_CLASS_PR,
    CHAR_CLASS_AL,
    CHAR_CLASS_NU,
    CHAR_CLASS_AL,
    CHAR_CLASS_BB,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_NU,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_BA,
    CHAR_CLASS_GL,
    CHAR_CLASS_BA,
    CHAR_CLASS_ZW,
    CHAR_CLASS_CM,
    CHAR_CLASS_BA,
    CHAR_CLASS_GL,
    CHAR_CLASS_BA,
    CHAR_CLASS_B2,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_QU,
    CHAR_CLASS_OP,
    CHAR_CLASS_QU,
    CHAR_CLASS_OP,
    CHAR_CLASS_QU,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_IN,
    CHAR_CLASS_BA,
    CHAR_CLASS_BK,
    CHAR_CLASS_CM,
    CHAR_CLASS_GL,
    CHAR_CLASS_PO,
    CHAR_CLASS_AL,
    CHAR_CLASS_QU,
    CHAR_CLASS_AI,
    CHAR_CLASS_NS,
    CHAR_CLASS_AL,
    CHAR_CLASS_NS,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_AL,
    CHAR_CLASS_BA,
    CHAR_CLASS_GL,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_PR,
    CHAR_CLASS_PO,
    CHAR_CLASS_PR,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_PO,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_PO,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_PR,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_PO,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_PR,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_AL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_QU,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_AI,
    CHAR_CLASS_AL,
    CHAR_CLASS_QU,
    CHAR_CLASS_AL,
    CHAR_CLASS_EX,
    CHAR_CLASS_AL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_AL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_AL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_AL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_AL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_AL,
    CHAR_CLASS_ID,
    CHAR_CLASS_CL,
    CHAR_CLASS_ID,
    CHAR_CLASS_NS,
    CHAR_CLASS_ID,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_ID,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_NS,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_ID,
    CHAR_CLASS_CM,
    CHAR_CLASS_ID,
    CHAR_CLASS_NS,
    CHAR_CLASS_ID,
    CHAR_CLASS_NS,
    CHAR_CLASS_ID,
    CHAR_CLASS_NS,
    CHAR_CLASS_ID,
    CHAR_CLASS_NS,
    CHAR_CLASS_ID,
    CHAR_CLASS_NS,
    CHAR_CLASS_ID,
    CHAR_CLASS_NS,
    CHAR_CLASS_ID,
    CHAR_CLASS_NS,
    CHAR_CLASS_ID,
    CHAR_CLASS_NS,
    CHAR_CLASS_ID,
    CHAR_CLASS_NS,
    CHAR_CLASS_ID,
    CHAR_CLASS_NS,
    CHAR_CLASS_ID,
    CHAR_CLASS_NS,
    CHAR_CLASS_ID,
    CHAR_CLASS_NS,
    CHAR_CLASS_CM,
    CHAR_CLASS_NS,
    CHAR_CLASS_ID,
    CHAR_CLASS_NS,
    CHAR_CLASS_ID,
    CHAR_CLASS_NS,
    CHAR_CLASS_ID,
    CHAR_CLASS_NS,
    CHAR_CLASS_ID,
    CHAR_CLASS_NS,
    CHAR_CLASS_ID,
    CHAR_CLASS_NS,
    CHAR_CLASS_ID,
    CHAR_CLASS_NS,
    CHAR_CLASS_ID,
    CHAR_CLASS_NS,
    CHAR_CLASS_ID,
    CHAR_CLASS_NS,
    CHAR_CLASS_ID,
    CHAR_CLASS_NS,
    CHAR_CLASS_ID,
    CHAR_CLASS_NS,
    CHAR_CLASS_ID,
    CHAR_CLASS_NS,
    CHAR_CLASS_ID,
    CHAR_CLASS_NS,
    CHAR_CLASS_ID,
    CHAR_CLASS_NS,
    CHAR_CLASS_ID,
    CHAR_CLASS_NS,
    CHAR_CLASS_ID,
    CHAR_CLASS_SG,
    CHAR_CLASS_XX,
    CHAR_CLASS_ID,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_AL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_AL,
    CHAR_CLASS_PO,
    CHAR_CLASS_CM,
    CHAR_CLASS_ID,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_ID,
    CHAR_CLASS_CL,
    CHAR_CLASS_ID,
    CHAR_CLASS_CL,
    CHAR_CLASS_NS,
    CHAR_CLASS_EX,
    CHAR_CLASS_ID,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_ID,
    CHAR_CLASS_PR,
    CHAR_CLASS_PO,
    CHAR_CLASS_ID,
    CHAR_CLASS_AL,
    CHAR_CLASS_GL,
    CHAR_CLASS_EX,
    CHAR_CLASS_ID,
    CHAR_CLASS_PR,
    CHAR_CLASS_PO,
    CHAR_CLASS_ID,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_ID,
    CHAR_CLASS_CL,
    CHAR_CLASS_ID,
    CHAR_CLASS_CL,
    CHAR_CLASS_ID,
    CHAR_CLASS_NS,
    CHAR_CLASS_ID,
    CHAR_CLASS_EX,
    CHAR_CLASS_ID,
    CHAR_CLASS_OP,
    CHAR_CLASS_ID,
    CHAR_CLASS_CL,
    CHAR_CLASS_ID,
    CHAR_CLASS_OP,
    CHAR_CLASS_ID,
    CHAR_CLASS_CL,
    CHAR_CLASS_ID,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_OP,
    CHAR_CLASS_CL,
    CHAR_CLASS_NS,
    CHAR_CLASS_AL,
    CHAR_CLASS_NS,
    CHAR_CLASS_AL,
    CHAR_CLASS_NS,
    CHAR_CLASS_AL,
    CHAR_CLASS_PO,
    CHAR_CLASS_PR,
    CHAR_CLASS_ID,
    CHAR_CLASS_PR,
    CHAR_CLASS_AL,
    CHAR_CLASS_CM,
    CHAR_CLASS_CB,
    CHAR_CLASS_AI };
    public TextLineBreaks() { super(); }
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
       "gtByxFba2DxgSKvHlmNFmTr9pCFKVold");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
