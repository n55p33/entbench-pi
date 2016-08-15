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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL18C7Dk2Fle37uzr9nHzL7X6/V61jsLXgSjfqhbLRaDpX5I" +
       "aknderTUD2PGar279X60Wg0L2AFMxSnihDUxCWxBygRwGexQUAQCxBQhQEFc" +
       "BXGCSQVMCEkgxgVOBUhiCJG6+947986duzt3gK7SkVrnnP98/3/+/z//0ZHO" +
       "xz5fujsKS4Dv2Zlhe/E1bRVfm9v1a3Hma9G1Hl1n5TDS1JYtR9Ewv3ddedsn" +
       "Lv3ZFz9oXt4v3TMtPSa7rhfLseW5Ea9Fnr3UVLp06ehux9acKC5dpufyUgaT" +
       "2LJB2oril+nSAzdUjUtX6QMIYA4BzCGAGwggelQqr/SQ5iZOq6ghu3EUlL6x" +
       "tEeX7vGVAl5cev44EV8OZWdHht1wkFO4r/gv5UxtKq/C0pVD3rc838TwhwDw" +
       "1X/0dZd/7K7SpWnpkuUKBRwlBxHnjUxLDzqaM9PCCFVVTZ2WHnE1TRW00JJt" +
       "a73BPS09GlmGK8dJqB0KqbiZ+Fq4afNIcg8qBW9hosReeMiebmm2evDvbt2W" +
       "jZzXJ4943XLYLe7nDF60cmChLivaQZULC8tV49JbT9Y45PEqlRfIq97raLHp" +
       "HTZ1wZXzG6VHt31ny64BCnFouUZe9G4vyVuJS8/ckmgha19WFrKhXY9LT58s" +
       "x26z8lL3bwRRVIlLT5wstqGU99IzJ3rphv75fP+rvuPrXcLd32BWNcUu8N+X" +
       "V3ruRCVe07VQcxVtW/HBL6O/S37yZ799v1TKCz9xovC2zE9+wxfe+eXPffKX" +
       "t2XefEqZwWyuKfF15SOzh3/92dZLyF0FjPt8L7KKzj/G+Ub92V3Oyys/t7wn" +
       "DykWmdcOMj/J/5vJN39U+9x+6SJZukfx7MTJ9egRxXN8y9ZCXHO1UI41lSzd" +
       "r7lqa5NPlu7Nr2nL1bZ3B7oeaTFZumBvbt3jbf7nItJzEoWI7s2vLVf3Dq59" +
       "OTY31yu/VCrdmx+lB/Pj+dL2tznHpXeBpudooKzIruV6IBt6Bf8RqLnxLJet" +
       "Cc5yrV+AkZeEuQqCXmiAcq4HprbLMJYxqNteCg5z8ynQYqEmL6JrhZL5f7Pk" +
       "VwV3l9O9vVzwz540ezu3GMKzVS28rryaYJ0v/Oj1X90/NIOdXOLS2/MWr21b" +
       "vLZp8Vre4rWixWvHWyzt7W0aerxoedu7eeYit/Lc/z34kvDu3nu+/W135Wrl" +
       "pxdywRZFwVu74daRXyA33k/JlbP0yQ+n75W+qbxf2j/uTwu0+a2LRXW28IKH" +
       "3u7qSTs6je6l9//Bn338u17xjizqmIPeGfrNNQtDfdtJuYaeoqm56zsi/2VX" +
       "5J+4/rOvXN0vXcitP/d4sZxLLXcmz51s45jBvnzg/Ape7s4Z1r3Qke0i68Bj" +
       "XYzN0EuP7mw6/OHN9SO5jJ8t7ZJjKl3kPuYX6eNbBSk67QQXG+f6DsH/3s98" +
       "6g9rG3Ef+OFLN4xsgha/fIPtF8Qubaz8kSMdGIaalpf77Q+z3/mhz7//XRsF" +
       "yEu8cFqDV4u0ldt83oW5mL/1l4Pf+uzvfOTT+0dKE+eDXzKzLWW1ZfKv8t9e" +
       "fvy/4iiYK25s7fbR1s55XDn0Hn7R8pccYcv9iJ0bW6FBV0XX8VRLt+SZrRUa" +
       "+xeXXqz8xB99x+WtTtj5nQOV+vLXJ3B0/01Y6Zt/9ev+/LkNmT2lGMeO5HdU" +
       "bOscHzuijIahnBU4Vu/9jbd89y/J35u72dy1RdZa23ir0kYepU0HljeyADYp" +
       "eCKvWiRvjW40hOO2dkO8cV354Kf/5CHpT37uCxu0xwOWG/udkf2Xt6pWJFdW" +
       "OfmnTlo9IUdmXg76ZP9rL9uf/GJOcZpTVHIfFg3C3OmsjmnJrvTd9/7Hn/+F" +
       "J9/z63eV9ruli7Ynq115Y3Cl+3NN1yIz91cr/2veudXm9L48ubxhtXQT81sF" +
       "eXrzD8wBvnRrX9Mt4o0jc336/w7s2ft+73/fJISNlzllmD1Rfwp+7HueaX31" +
       "5zb1j8y9qP3c6mZHnMdmR3WrH3X+dP9t9/zifuneaemysgv8JNlOCiOa5sFO" +
       "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" +
       "lqxkPfAaTdelMYCYQktclTmuzTBiFeuO");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
