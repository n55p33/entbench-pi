package org.apache.batik.css.engine.value.css2;
public class FontShorthandManager extends org.apache.batik.css.engine.value.AbstractValueFactory implements org.apache.batik.css.engine.value.ShorthandManager {
    public FontShorthandManager() { super(); }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_FONT_PROPERTY;
    }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    static org.w3c.css.sac.LexicalUnit NORMAL_LU = org.apache.batik.css.parser.CSSLexicalUnit.
      createString(
        org.w3c.css.sac.LexicalUnit.
          SAC_IDENT,
        org.apache.batik.util.CSSConstants.
          CSS_NORMAL_VALUE,
        null);
    static org.w3c.css.sac.LexicalUnit BOLD_LU = org.apache.batik.css.parser.CSSLexicalUnit.
      createString(
        org.w3c.css.sac.LexicalUnit.
          SAC_IDENT,
        org.apache.batik.util.CSSConstants.
          CSS_BOLD_VALUE,
        null);
    static org.w3c.css.sac.LexicalUnit MEDIUM_LU =
      org.apache.batik.css.parser.CSSLexicalUnit.
      createString(
        org.w3c.css.sac.LexicalUnit.
          SAC_IDENT,
        org.apache.batik.util.CSSConstants.
          CSS_MEDIUM_VALUE,
        null);
    static org.w3c.css.sac.LexicalUnit SZ_10PT_LU =
      org.apache.batik.css.parser.CSSLexicalUnit.
      createFloat(
        org.w3c.css.sac.LexicalUnit.
          SAC_POINT,
        10,
        null);
    static org.w3c.css.sac.LexicalUnit SZ_8PT_LU =
      org.apache.batik.css.parser.CSSLexicalUnit.
      createFloat(
        org.w3c.css.sac.LexicalUnit.
          SAC_POINT,
        8,
        null);
    static org.w3c.css.sac.LexicalUnit FONT_FAMILY_LU;
    static { org.w3c.css.sac.LexicalUnit lu;
             FONT_FAMILY_LU = org.apache.batik.css.parser.CSSLexicalUnit.
                                createString(
                                  org.w3c.css.sac.LexicalUnit.
                                    SAC_IDENT,
                                  "Dialog",
                                  null);
             lu = org.apache.batik.css.parser.CSSLexicalUnit.
                    createString(
                      org.w3c.css.sac.LexicalUnit.
                        SAC_IDENT,
                      "Helvetica",
                      FONT_FAMILY_LU);
             org.apache.batik.css.parser.CSSLexicalUnit.
               createString(
                 org.w3c.css.sac.LexicalUnit.
                   SAC_IDENT,
                 org.apache.batik.util.CSSConstants.
                   CSS_SANS_SERIF_VALUE,
                 lu); }
    protected static final java.util.Set values =
      new java.util.HashSet(
      );
    static { values.add(org.apache.batik.util.CSSConstants.
                          CSS_CAPTION_VALUE);
             values.add(org.apache.batik.util.CSSConstants.
                          CSS_ICON_VALUE);
             values.add(org.apache.batik.util.CSSConstants.
                          CSS_MENU_VALUE);
             values.add(org.apache.batik.util.CSSConstants.
                          CSS_MESSAGE_BOX_VALUE);
             values.add(org.apache.batik.util.CSSConstants.
                          CSS_SMALL_CAPTION_VALUE);
             values.add(org.apache.batik.util.CSSConstants.
                          CSS_STATUS_BAR_VALUE); }
    public void handleSystemFont(org.apache.batik.css.engine.CSSEngine eng,
                                 org.apache.batik.css.engine.value.ShorthandManager.PropertyHandler ph,
                                 java.lang.String s,
                                 boolean imp) {
        org.w3c.css.sac.LexicalUnit fontStyle =
          NORMAL_LU;
        org.w3c.css.sac.LexicalUnit fontVariant =
          NORMAL_LU;
        org.w3c.css.sac.LexicalUnit fontWeight =
          NORMAL_LU;
        org.w3c.css.sac.LexicalUnit lineHeight =
          NORMAL_LU;
        org.w3c.css.sac.LexicalUnit fontFamily =
          FONT_FAMILY_LU;
        org.w3c.css.sac.LexicalUnit fontSize;
        if (s.
              equals(
                org.apache.batik.util.CSSConstants.
                  CSS_SMALL_CAPTION_VALUE)) {
            fontSize =
              SZ_8PT_LU;
        }
        else {
            fontSize =
              SZ_10PT_LU;
        }
        ph.
          property(
            org.apache.batik.util.CSSConstants.
              CSS_FONT_FAMILY_PROPERTY,
            fontFamily,
            imp);
        ph.
          property(
            org.apache.batik.util.CSSConstants.
              CSS_FONT_STYLE_PROPERTY,
            fontStyle,
            imp);
        ph.
          property(
            org.apache.batik.util.CSSConstants.
              CSS_FONT_VARIANT_PROPERTY,
            fontVariant,
            imp);
        ph.
          property(
            org.apache.batik.util.CSSConstants.
              CSS_FONT_WEIGHT_PROPERTY,
            fontWeight,
            imp);
        ph.
          property(
            org.apache.batik.util.CSSConstants.
              CSS_FONT_SIZE_PROPERTY,
            fontSize,
            imp);
        ph.
          property(
            org.apache.batik.util.CSSConstants.
              CSS_LINE_HEIGHT_PROPERTY,
            lineHeight,
            imp);
    }
    public void setValues(org.apache.batik.css.engine.CSSEngine eng,
                          org.apache.batik.css.engine.value.ShorthandManager.PropertyHandler ph,
                          org.w3c.css.sac.LexicalUnit lu,
                          boolean imp) { switch (lu.
                                                   getLexicalUnitType(
                                                     )) {
                                             case org.w3c.css.sac.LexicalUnit.
                                                    SAC_INHERIT:
                                                 return;
                                             case org.w3c.css.sac.LexicalUnit.
                                                    SAC_IDENT:
                                                 {
                                                     java.lang.String s =
                                                       lu.
                                                       getStringValue(
                                                         ).
                                                       toLowerCase(
                                                         );
                                                     if (values.
                                                           contains(
                                                             s)) {
                                                         handleSystemFont(
                                                           eng,
                                                           ph,
                                                           s,
                                                           imp);
                                                         return;
                                                     }
                                                 }
                                         }
                                         org.w3c.css.sac.LexicalUnit fontStyle =
                                           null;
                                         org.w3c.css.sac.LexicalUnit fontVariant =
                                           null;
                                         org.w3c.css.sac.LexicalUnit fontWeight =
                                           null;
                                         org.w3c.css.sac.LexicalUnit fontSize =
                                           null;
                                         org.w3c.css.sac.LexicalUnit lineHeight =
                                           null;
                                         org.w3c.css.sac.LexicalUnit fontFamily =
                                           null;
                                         org.apache.batik.css.engine.value.ValueManager[] vMgrs =
                                           eng.
                                           getValueManagers(
                                             );
                                         int fst;
                                         int fv;
                                         int fw;
                                         int fsz;
                                         int lh;
                                         fst =
                                           eng.
                                             getPropertyIndex(
                                               org.apache.batik.util.CSSConstants.
                                                 CSS_FONT_STYLE_PROPERTY);
                                         fv =
                                           eng.
                                             getPropertyIndex(
                                               org.apache.batik.util.CSSConstants.
                                                 CSS_FONT_VARIANT_PROPERTY);
                                         fw =
                                           eng.
                                             getPropertyIndex(
                                               org.apache.batik.util.CSSConstants.
                                                 CSS_FONT_WEIGHT_PROPERTY);
                                         fsz =
                                           eng.
                                             getPropertyIndex(
                                               org.apache.batik.util.CSSConstants.
                                                 CSS_FONT_SIZE_PROPERTY);
                                         lh =
                                           eng.
                                             getPropertyIndex(
                                               org.apache.batik.util.CSSConstants.
                                                 CSS_LINE_HEIGHT_PROPERTY);
                                         org.apache.batik.css.engine.value.IdentifierManager fstVM =
                                           (org.apache.batik.css.engine.value.IdentifierManager)
                                             vMgrs[fst];
                                         org.apache.batik.css.engine.value.IdentifierManager fvVM =
                                           (org.apache.batik.css.engine.value.IdentifierManager)
                                             vMgrs[fv];
                                         org.apache.batik.css.engine.value.IdentifierManager fwVM =
                                           (org.apache.batik.css.engine.value.IdentifierManager)
                                             vMgrs[fw];
                                         org.apache.batik.css.engine.value.css2.FontSizeManager fszVM =
                                           (org.apache.batik.css.engine.value.css2.FontSizeManager)
                                             vMgrs[fsz];
                                         org.apache.batik.css.engine.value.StringMap fstSM =
                                           fstVM.
                                           getIdentifiers(
                                             );
                                         org.apache.batik.css.engine.value.StringMap fvSM =
                                           fvVM.
                                           getIdentifiers(
                                             );
                                         org.apache.batik.css.engine.value.StringMap fwSM =
                                           fwVM.
                                           getIdentifiers(
                                             );
                                         org.apache.batik.css.engine.value.StringMap fszSM =
                                           fszVM.
                                           getIdentifiers(
                                             );
                                         boolean svwDone =
                                           false;
                                         org.w3c.css.sac.LexicalUnit intLU =
                                           null;
                                         while (!svwDone &&
                                                  lu !=
                                                  null) {
                                             switch (lu.
                                                       getLexicalUnitType(
                                                         )) {
                                                 case org.w3c.css.sac.LexicalUnit.
                                                        SAC_IDENT:
                                                     {
                                                         java.lang.String s =
                                                           lu.
                                                           getStringValue(
                                                             ).
                                                           toLowerCase(
                                                             ).
                                                           intern(
                                                             );
                                                         if (fontStyle ==
                                                               null &&
                                                               fstSM.
                                                               get(
                                                                 s) !=
                                                               null) {
                                                             fontStyle =
                                                               lu;
                                                             if (intLU !=
                                                                   null) {
                                                                 if (fontWeight ==
                                                                       null) {
                                                                     fontWeight =
                                                                       intLU;
                                                                     intLU =
                                                                       null;
                                                                 }
                                                                 else {
                                                                     throw createInvalidLexicalUnitDOMException(
                                                                             intLU.
                                                                               getLexicalUnitType(
                                                                                 ));
                                                                 }
                                                             }
                                                             break;
                                                         }
                                                         if (fontVariant ==
                                                               null &&
                                                               fvSM.
                                                               get(
                                                                 s) !=
                                                               null) {
                                                             fontVariant =
                                                               lu;
                                                             if (intLU !=
                                                                   null) {
                                                                 if (fontWeight ==
                                                                       null) {
                                                                     fontWeight =
                                                                       intLU;
                                                                     intLU =
                                                                       null;
                                                                 }
                                                                 else {
                                                                     throw createInvalidLexicalUnitDOMException(
                                                                             intLU.
                                                                               getLexicalUnitType(
                                                                                 ));
                                                                 }
                                                             }
                                                             break;
                                                         }
                                                         if (intLU ==
                                                               null &&
                                                               fontWeight ==
                                                               null &&
                                                               fwSM.
                                                               get(
                                                                 s) !=
                                                               null) {
                                                             fontWeight =
                                                               lu;
                                                             break;
                                                         }
                                                         svwDone =
                                                           true;
                                                         break;
                                                     }
                                                 case org.w3c.css.sac.LexicalUnit.
                                                        SAC_INTEGER:
                                                     if (intLU ==
                                                           null &&
                                                           fontWeight ==
                                                           null) {
                                                         intLU =
                                                           lu;
                                                         break;
                                                     }
                                                     svwDone =
                                                       true;
                                                     break;
                                                 default:
                                                     svwDone =
                                                       true;
                                                     break;
                                             }
                                             if (!svwDone)
                                                 lu =
                                                   lu.
                                                     getNextLexicalUnit(
                                                       );
                                         }
                                         if (lu ==
                                               null)
                                             throw createMalformedLexicalUnitDOMException(
                                                     );
                                         switch (lu.
                                                   getLexicalUnitType(
                                                     )) {
                                             case org.w3c.css.sac.LexicalUnit.
                                                    SAC_IDENT:
                                                 {
                                                     java.lang.String s =
                                                       lu.
                                                       getStringValue(
                                                         ).
                                                       toLowerCase(
                                                         ).
                                                       intern(
                                                         );
                                                     if (fszSM.
                                                           get(
                                                             s) !=
                                                           null) {
                                                         fontSize =
                                                           lu;
                                                         lu =
                                                           lu.
                                                             getNextLexicalUnit(
                                                               );
                                                     }
                                                 }
                                                 break;
                                             case org.w3c.css.sac.LexicalUnit.
                                                    SAC_EM:
                                             case org.w3c.css.sac.LexicalUnit.
                                                    SAC_EX:
                                             case org.w3c.css.sac.LexicalUnit.
                                                    SAC_PIXEL:
                                             case org.w3c.css.sac.LexicalUnit.
                                                    SAC_CENTIMETER:
                                             case org.w3c.css.sac.LexicalUnit.
                                                    SAC_MILLIMETER:
                                             case org.w3c.css.sac.LexicalUnit.
                                                    SAC_INCH:
                                             case org.w3c.css.sac.LexicalUnit.
                                                    SAC_POINT:
                                             case org.w3c.css.sac.LexicalUnit.
                                                    SAC_PICA:
                                             case org.w3c.css.sac.LexicalUnit.
                                                    SAC_INTEGER:
                                             case org.w3c.css.sac.LexicalUnit.
                                                    SAC_REAL:
                                             case org.w3c.css.sac.LexicalUnit.
                                                    SAC_PERCENTAGE:
                                                 fontSize =
                                                   lu;
                                                 lu =
                                                   lu.
                                                     getNextLexicalUnit(
                                                       );
                                                 break;
                                         }
                                         if (fontSize ==
                                               null) {
                                             if (intLU !=
                                                   null) {
                                                 fontSize =
                                                   intLU;
                                                 intLU =
                                                   null;
                                             }
                                             else {
                                                 throw createInvalidLexicalUnitDOMException(
                                                         lu.
                                                           getLexicalUnitType(
                                                             ));
                                             }
                                         }
                                         if (intLU !=
                                               null) {
                                             if (fontWeight ==
                                                   null) {
                                                 fontWeight =
                                                   intLU;
                                             }
                                             else {
                                                 throw createInvalidLexicalUnitDOMException(
                                                         intLU.
                                                           getLexicalUnitType(
                                                             ));
                                             }
                                         }
                                         if (lu ==
                                               null)
                                             throw createMalformedLexicalUnitDOMException(
                                                     );
                                         switch (lu.
                                                   getLexicalUnitType(
                                                     )) {
                                             case org.w3c.css.sac.LexicalUnit.
                                                    SAC_OPERATOR_SLASH:
                                                 lu =
                                                   lu.
                                                     getNextLexicalUnit(
                                                       );
                                                 if (lu ==
                                                       null)
                                                     throw createMalformedLexicalUnitDOMException(
                                                             );
                                                 lineHeight =
                                                   lu;
                                                 lu =
                                                   lu.
                                                     getNextLexicalUnit(
                                                       );
                                                 break;
                                         }
                                         if (lu ==
                                               null)
                                             throw createMalformedLexicalUnitDOMException(
                                                     );
                                         fontFamily =
                                           lu;
                                         if (fontStyle ==
                                               null)
                                             fontStyle =
                                               NORMAL_LU;
                                         if (fontVariant ==
                                               null)
                                             fontVariant =
                                               NORMAL_LU;
                                         if (fontWeight ==
                                               null)
                                             fontWeight =
                                               NORMAL_LU;
                                         if (lineHeight ==
                                               null)
                                             lineHeight =
                                               NORMAL_LU;
                                         ph.
                                           property(
                                             org.apache.batik.util.CSSConstants.
                                               CSS_FONT_FAMILY_PROPERTY,
                                             fontFamily,
                                             imp);
                                         ph.
                                           property(
                                             org.apache.batik.util.CSSConstants.
                                               CSS_FONT_STYLE_PROPERTY,
                                             fontStyle,
                                             imp);
                                         ph.
                                           property(
                                             org.apache.batik.util.CSSConstants.
                                               CSS_FONT_VARIANT_PROPERTY,
                                             fontVariant,
                                             imp);
                                         ph.
                                           property(
                                             org.apache.batik.util.CSSConstants.
                                               CSS_FONT_WEIGHT_PROPERTY,
                                             fontWeight,
                                             imp);
                                         ph.
                                           property(
                                             org.apache.batik.util.CSSConstants.
                                               CSS_FONT_SIZE_PROPERTY,
                                             fontSize,
                                             imp);
                                         if (lh !=
                                               -1) {
                                             ph.
                                               property(
                                                 org.apache.batik.util.CSSConstants.
                                                   CSS_LINE_HEIGHT_PROPERTY,
                                                 lineHeight,
                                                 imp);
                                         }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1ZfXAbxRVfyd+OHTvOJ/lwYuMkkwQkEgiQGlIcxyZOZVtY" +
       "tgeUEOV0Wltnn+4udytbNk0LmXaSdtrUQPhoBzL9IzR8BMK0MOWjMGmZ8lFo" +
       "OwFaoJSPAWYKBQZSBtpCKX27e6c7nXQynjb1zK3Ou+/tvvf2t++9fXfsfVRm" +
       "6KgRKyRAJjRsBDoUEhZ0AyfaZcEw+qEvJt5UIny06+2eTX5UHkWzk4LRLQoG" +
       "7pSwnDCiaJmkGERQRGz0YJygHGEdG1gfE4ikKlE0XzK6UposiRLpVhOYEgwK" +
       "egjNEQjRpXia4C5zAoKWhUCSIJMk2OYebg2hGlHVJmzyRQ7ydscIpUzZaxkE" +
       "1YdGhDEhmCaSHAxJBmnN6GidpsoTw7JKAjhDAiPyRtME20Mb80zQfG/dJ59N" +
       "JeuZCeYKiqISpp7Rhw1VHsOJEKqzeztknDL2oG+gkhCa5SAmqCVkLRqERYOw" +
       "qKWtTQXS12IlnWpXmTrEmqlcE6lABDXlTqIJupAypwkzmWGGSmLqzphB2xVZ" +
       "bbmWeSresC546KZd9T8tQXVRVCcpESqOCEIQWCQKBsWpONaNtkQCJ6JojgKb" +
       "HcG6JMjSpLnTDYY0rAgkDdtvmYV2pjWsszVtW8E+gm56WiSqnlVviAHK/K9s" +
       "SBaGQdcFtq5cw07aDwpWSyCYPiQA7kyW0lFJSRC03M2R1bHla0AArBUpTJJq" +
       "dqlSRYAO1MAhIgvKcDAC0FOGgbRMBQDqBC32nJTaWhPEUWEYxygiXXRhPgRU" +
       "VcwQlIWg+W4yNhPs0mLXLjn25/2eiw5epWxT/MgHMiewKFP5ZwFTo4upDw9h" +
       "HcM54Iw1a0M3CgseOeBHCIjnu4g5zc+/fuqSsxpPPMlplhSg6Y2PYJHExCPx" +
       "2SeXtq/ZVELFqNRUQ6Kbn6M5O2Vhc6Q1o4GHWZCdkQ4GrMETfY9fcfWd+F0/" +
       "qu5C5aIqp1OAozmimtIkGeuXYgXrAsGJLlSFlUQ7G+9CFfAekhTMe3uHhgxM" +
       "ulCpzLrKVfY/mGgIpqAmqoZ3SRlSrXdNIEn2ntEQQhXwoOXwXID430baEKQE" +
       "k2oKBwVRUCRFDYZ1lepvBMHjxMG2yWAcUD8aNNS0DhAMqvpwUAAcJLE5IBqU" +
       "dhhkCo4JchrTjg3BTjBVJKnqJCkoiW5BAWjoAYo77f++YobaYO64zwfbs9Tt" +
       "HGQ4V9tUOYH1mHgovaXj1D2xpznw6GExrUdQKwgR4EIEmBABWDPAhQgwIWjH" +
       "hkAhIZDPx9aeR4XhsIBNHQX3AP65Zk3kyu27DzSXAB618VLYEUranBOn2m0f" +
       "Yjn+mHi8oXay6dX1j/lRaQg1CCJJCzINO236MDg0cdQ88zVxiGB2IFnhCCQ0" +
       "AuqqiBPgx7wCijlLpTqGddpP0DzHDFaYowc66B1kCsqPTtw8fs3gN8/xI39u" +
       "7KBLloHbo+xh6vGznr3F7TMKzVu3/+1Pjt+4V7W9R04wsmJoHifVodmNDrd5" +
       "YuLaFcL9sUf2tjCzV4F3JwJAABxno3uNHOfUajl6qkslKDyk6ilBpkOWjatJ" +
       "UlfH7R4G2znsfR7AYpZ1fDeZx5f90tEFGm0XcphTnLm0YIHk4oh264u/e+dc" +
       "Zm4r5tQ5koUIJq0OP0cna2AebY4N234dY6B75ebw9Te8v38HwyxQnFlowRba" +
       "toN/gy0EM3/7yT0vvfbqkef9Ns4JBPp0HPKlTFZJ2o+qiygJq62y5QE/KYPn" +
       "oKhpGVAAn9KQJMRlTA/Wv+pWrr//vYP1HAcy9FgwOmv6Cez+M7agq5/e9fdG" +
       "No1PpHHatplNxp3/XHvmNl0XJqgcmWueXfbDJ4RbIYyA6zakScy8MWI2QGzT" +
       "NjL9z2Htea6xC2iz0nCCP/d8OfKpmDj1/Ie1gx8+eopJm5uQOfe6W9BaObxo" +
       "syoD0y90O6dtgpEEuvNO9Oysl098BjNGYUYRHLLRq4O7zOQgw6Quq/jTLx9b" +
       "sPtkCfJ3ompZFRKdAjtkqArQjY0keNqM9tVL+OaOV0JTz1RFecrndVADLy+8" +
       "dR0pjTBjTz6w8L6Ljh5+laFM43MsYfwV1PnneFWW1tsH+87nLvjD0WtvHOeJ" +
       "wRpvb+biW/Rprxzf98Y/8kzO/FiBpMXFHw0eu2Vx++Z3Gb/tUCh3SyY/YIFT" +
       "tnk33Jn62N9c/ms/qoiietFMowdpOIJjGoXU0bBya0i1c8Zz00Ce87RmHeZS" +
       "tzNzLOt2ZXaghHdKTd9rC3mvDnguMw922O29fIi9dDGW1axdS5uzs87CYHl6" +
       "AWcR9piToKqe3r7utlAsNMC4FhG0hAby8XNFFr8NQQyEcEYSBXlAkQh3oLS9" +
       "kDbb+VKtnnBtz1WvHZ6IKUqfh3r9XD3ahPIV6fPgJqhiS29oK6hB/w275ByY" +
       "oZx0GwbNlQY85NxRVM4BD24weHfH1q6Bbg9Jd85Q0rXwXGGudbmHpPGikl7u" +
       "wU1QdSQaW39OuN9DVHGGoq6BZ4e5WNRDVKmoqFEPbjAqiHqhp6QjM5R0FTy7" +
       "zLV2eUiqFZXUi5ug2Z29Pf2xzrburtAVHuLu+fLiLqG958MzYi444iHueGGn" +
       "UQKm03SVgGvDCdrdTcB1SYogu5zI4iJrgONh+b0BAWSZHUBo6htJxw3SJ4yz" +
       "u2tM3Lm6fkHLpo+aeQRpLEDruOQefPihaHR1vciJmwtNnHu5vf1opfhy6vG3" +
       "OMMZBRg43fzbg98ffGHkGZboVdLsv9/yyY7cHm4JjiyzPmuOGqp9HUJ+zK3B" +
       "fwna+V9e2YAtFSRSSoJg0y+lcIJWjqgO5pXwtM7P8puc2G9v2l2jctsHF/7k" +
       "Ym7WJo+wb9M/eNnrJ2+dPH6Mp5XUvASt86p15RfY6C1jZZGbkg2Qjy/9yol3" +
       "3hy80m8mgrNp862MFcdq7UwIQj3t/F42Y/Jl75HzcmHCZ976nbpfTDWUdMIV" +
       "pgtVphVpTxp3JXIDeYWRjjtwY5d07OBuguYL+PPB82/6ULDQDg6ahnazvLEi" +
       "W9+ApIyOE+RbC68u15Ap4hoytkdal0Ur+ytHZinD+nUcXkcC6LMst2H6q7z7" +
       "Bk8BtMyrYMWKbUf2HTqc6L1tPYdRQ24RqENJp+7+4+fPBG5+/akCtYUqompn" +
       "y3gMyw5xy3LdDWC2m9Xy7OTvldnXvflgy/CWmRQAaF/jNFd8+v9yUGKtN0zd" +
       "ojyx76+L+zcnd8/gLr/cZU73lHd0H3vq0lXidX5WuORZaV7BM5epNRfC1Tom" +
       "aV3JBe2ZWew0UKg0wbPZxM5md3Cx0emCXTYQerEWuc/dUWTsLtocgavaMKaV" +
       "GVZN7gGFLOTWszNPE/YAr9vaR+e26aJq8asV7WjjQf/HWTXn0rHViCeMyPqd" +
       "mYW8WItY4YEiYw/R5mcEzZOMNvD4AqGXdctURuE4GtYhLBBpzPR+G8K7xQMt" +
       "4bcsv7qPNtfSE17kzueaI7i34bXRW96+24z0eVWjHGJ84NB3vwgcPMRPPi/d" +
       "n5lXPXfy8PI9d7JZ6ZqKrcI4Ov9yfO/Dt+/db2l2C1wb4qoqY0Fxhwb671TG" +
       "hs99pws+K+EJmRgIzRw+XqxFIPL7ImMnafMbCEwS/brDrGeBh448Yhvk6dNg" +
       "EJZ9n02pTK3IzA1CPFhdSpcyQUotx7GyWMhrj0Q62JtFvWXmAbLFMuM26JN5" +
       "9eJuZlKm05+L7MkbtHkBnFuSsUYmDIJTtIzOqB818U9/fkVQ6ZgqJexdevF0" +
       "7RK9I11vmnpq5rs05cFaeJfov6/Q5jXahG2zfVjEbH+jzbuQPEACygo6jOot" +
       "2zbv/S9skwFXW+iTBq3FLcr7zsq/DYr3HK6rXHh44AWWmGS/39VAijGUlmVn" +
       "tcjxXq7peEhiqtXw2hFPDz8laNWX+/YC6KA/TJV/cubPCWqalhnuhGNZA3JG" +
       "HzILRR6McCfE9pExeeC2Oa8QD0El0DopywHtbkqQgv066aoIqrbpYFH+4iSp" +
       "gdmBhL7WatYBPn96g7VBYNQhZ2TQ4TXaiYzPkX8iR3SYPx2UsizObwE0iLIv" +
       "9lZATofNO9Txw9t7rjp1/m38W4QoC5OTdJZZcO3gn0WyWWKT52zWXOXb1nw2" +
       "+96qlVbQm8MFts/oEsehaYPQp1HsLnYV6o2WbL3+pSMXPfrbA+XPQrjegXwC" +
       "QXN35BdKM1oa0vMdofzrFWTU7AtC65ofTWw+a+iDl1kpGvHr2FJv+pj4/NEr" +
       "n7tu0ZFGP5rVhcognuMMq+BunVD6sDimR1GtZHRkQESYRRLknLvbbHrMBJoT" +
       "MruY5qzN9tIvWQQ156cd+d//qmV1HOtb1LTCaiZw+5tl91i3hZxEO61pLga7" +
       "x1Fl+AH35Tx8lcRC3Zpm3RVLIxrzOFOFExUK7xXslb41/QdJ1lwFzSMAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "CLwDg/dul8jKGzHveNXN1sNtTO0XX7r+");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("8Ntfmv9edY/q5MbkI2ztYTNz3bMXGM68Xwljw3QqER45XGcIq7//ntbe//pu" +
       "u4GuLf8qGf7bofA309rTr1k4PToCO1vwfx3dV7igYFq7Ypza+1GZvwK6uluZ" +
       "tPYACM/m/DYw1fM5AYrq/0y+S5fT2rXTfKDRw8vZLA+B2kGW8vVKeDz6sNdW" +
       "GK4maaxoBxM5XOTZ7y6d8QCOjL0ymcdfy2ROipy9MFZ6DdUd6eMZPuOPzou/" +
       "8BIz/tFvYD97uLCmuUpRHcE+zNauHu7OnXgJT19Y23FdV+hnv/XoFx955tij" +
       "efQA+HTgncH21N1vh5FemFb3uYpfffs//sF/8NIfVQee/w9BDTjEvC4AAA==");
}
