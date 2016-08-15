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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL16eezk1n0fdyXtSmtbu5LPyrZk2Ssn0iTLGXI4nIlix7zm" +
       "4BycITlnGq95Djk8hzeZKk2ctjYawDViOXGAWH85aJoqsRE0SIo2gYqicQKn" +
       "BZwGTRogsdEzl4G4RdzDad1Hzu/an/a30sJGB+Aj552f7/d93+d93/Hy16CH" +
       "wgCq+Z6db20vuqVl0a2djd2Kcl8Lb7EjbCoFoaZSthSGIoi7rbz3C9e/8c1P" +
       "GjcuQ1c20Jsl1/UiKTI9N+S10LMTTR1B109jGVtzwgi6MdpJiQTHkWnDIzOM" +
       "nh9BbzhTNIJujo4hwAACDCDAFQSYOM0FCr1Jc2OHKktIbhTuoR+BLo2gK75S" +
       "wougp++sxJcCyTmqZlpJAGp4uPy/AEJVhbMAes+J7AeZXyXwp2vwiz/94Ru/" +
       "/AB0fQNdN12hhKMAEBFoZAO90dEcWQtCQlU1dQM95mqaKmiBKdlmUeHeQI+H" +
       "5taVojjQTpRURsa+FlRtnmrujUopWxArkReciKebmq0e/3tIt6UtkPVtp7Ie" +
       "JOyW8UDAayYAFuiSoh0XedAyXTWCnjpf4kTGm0OQARS96miR4Z009aArgQjo" +
       "8UPf2ZK7hYUoMN0tyPqQF4NWIuiJCystde1LiiVttdsR9I7z+aaHJJDrkUoR" +
       "ZZEIeuv5bFVNoJeeONdLZ/rna5Pv/8QPu333coVZ1RS7xP8wKPTkuUK8pmuB" +
       "5iraoeAbnxv9lPS2X//4ZQgCmd96LvMhz6/+ra9/6HuefOW3DnneeZc8nLzT" +
       "lOi28jn50S+/i3q280AJ42HfC82y8++QvDL/6VHK85kPRt7bTmosE28dJ77C" +
       "/+b6R39B+/PL0LUBdEXx7NgBdvSY4jm+aWtBT3O1QIo0dQA9orkqVaUPoKvg" +
       "e2S62iGW0/VQiwbQg3YVdcWr/gMV6aCKUkVXwbfp6t7xty9FRvWd+RAEXQUP" +
       "9BR4cOjww8ogglzY8BwNlhTJNV0PngZeKX8Ia24kA90asAys3oJDLw6ACcJe" +
       "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" +
       "LRg8njf1rEXv2y4hZNlopLewrorBaV0j5Fm679FdE0H6wQ5LxxMbR3KP9Jqy" +
       "MrCpvm3hKqzoUzd1dXjqi+TSGy3mKVrYot/rzjtNC2dVUSOQJablKCcmDc1Z" +
       "6bqzzeu7FnCqiTFVy/yJ0tb7MC/RjOlQ65q1wJrxHi6MaD3B/Q7j6hgvYkVt" +
       "r7U94J7MMSW0pfaorQztnAkKym9h4hDBmGETGc5jeWlintjumH7aM+pbccoB" +
       "amvBBZnNly6NypsZuWOW8aym1jU+lOOUm/GriO8Nbd7WRK1JGnxhNZJxsUtt" +
       "fDnhI1SaFEjbMaWkF3RXUt2UaLjZyqUxSoY9nmEHaBe4G5oxmKzNhWtu84lB" +
       "I9N8bG2cYWO21lYI2wRsNt7wS84rGDHdsmLmFElU7JGVisuMm4zaUrRao+PI" +
       "TQhTLXC9zzIdWoKjhFtFca0BXE+lkZs9R0s77U4zSZPt1MQGiQBrNtZYjZNd" +
       "vtOpXJNtqeUj1F7x4HHCw0Ct01iTsmIie90gxah43xAFeMiQcAfRFa1boGA+" +
       "LDK26e3WPc/n+mJGBsx6107C3VpZZjWi2WVTqY2jfY/T+rTFqMpWxNrUFqbD" +
       "Wj23wmBhWoUyoBC6MVygPVKwi/5YE9ZmL0nkGrzF21iDC91+Tsp9ehIbNLZY" +
       "UHCMmbLNJQiWs632VqmPmpOsxy0T2BgvPCpMPHfq8z0YbrbzqJeHmzqruXHd" +
       "i13J19OdK3RkLehYnZoNz3qhsVJYGK13nY6WgmqdGk4NEL3VK+R4NmUIKt+G" +
       "LZfzokYhJ7DQCa20u1rWTJGMZBOLN51NttLJeIHT0WZR7KxmjWCnIhgEOOJt" +
       "M97g9q09uox5bFSoY26fpY2lz+Bz0zKwdh4m4khfhaTKEdNFbalvE7vgfZ/L" +
       "txmaBr2QmC12lMyM+FlvrFCahfu9TNMohJPHMzrn7Hrf8/O0H+nWfrZNOq2W" +
       "5K33K9lfd/tZ01z6W9UhyW4noDWFcNEo3+ILck3PjE1NnDHiSjLnOcvCbcuN" +
       "t2kL4Wd5wALrANzILXScRQh3gG/UlrkjC72x6rsmOkmYKDU29kpOMttx0mBB" +
       "66TMbsCSdCuPMQVbJKspvon6cWDvDFLGvRlCI7t2gfT9bYNym/21qylBoxtG" +
       "yCroCE0l1qcCqrVj3VhRHWPDD3bjYm3ZbQ/4Fb4wrqH8lEsWGMm38/YgUCJ4" +
       "MurHO46ZrmLJlqhhvE5jqsVP83ZTSzSu1YrXijRD+H0Xs6j2JnM0YoGmTXHJ" +
       "1+bZuI7tu1K4I/IRNRrsLSwqVD9mMqsgXKwPLH3hyLgyT5brtI61FLWmwvDe" +
       "XnRcNgg6MlgM55u0hiX7zs5EjU3GcEh9Pd1KaNaY2LUB8FwEtm0LkomuZQMl" +
       "V6PRjmpmHVvnul1So2AngHfLDtnubQZKXAhjgiA+8IFym+Qz97dT9Vi1KXdy" +
       "b2Vn42XCj9/HDs0h6ekyeOZkc7L6XYGO7jgcv89sTp45D7t0vAGIvPYZ//mj" +
       "/XLD6t0X3WSpNqs+99EXX1K5n2scb6B+KoIeiTz/e23QxfYZFOWtrecu3pgb" +
       "Vxd5To/GvvjRP3tC/KDxkfs48H/qHM7zVf6j8cu/3Xu/8pOXoQdODspedcXo" +
       "zkLP33k8di3QojhwxTsOyd590imPl33wNHg+eNQpHzy/Y3za7Xff2//ug9nc" +
       "44T3C/dI++Uy+McRdH2rRdPAqy5rTY7Q//ipsb38WtuBZ+utIn7+RMQ3l5Hf" +
       "BR3OoqDj93dWxH9+j7TfKINfjaC3mCHhmo4Ulefvx7JWJT5xZjz9ZARdlT3P" +
       "1iT3VPxf+3bFfwY8oyPxR9958b90j7R/XQa/GUGPm+XtvWrX+Fj4MuWVUym/" +
       "+G1IWR1TfW+ZfCRl9J2R8sEqw4PHdPTMveiIEgSm+jrOTd4/ed081k0fxNmH" +
       "M/mKeV+p4P3+PRT9R2XwuxF0w6iKCnkYaU559+luNvZg4pnqqer/7ber+vKE" +
       "8FNHqv/kd1T15d8/KIM/LIPeqS7+7B66+Isy+M+A1kPtcPegyvWVU4H/y/0I" +
       "nIHBe7dLZOWNmHe86mbr4Tam8ksvXX/4");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("7S/Nf7+6R3VyY/KREfSwHtv22QsMZ76v+IGmm5UIjxyuM/jV679H0Ptf3203" +
       "0LXlq5Lhvx0KfyOCnn7NwtHREdjZgv/r6L7CBQUj6Ip2au9HZf4a6OpuZSLo" +
       "ARCezfktYKrncwIU1ftMvkuXI+jaaT7Q6OHjbJaHQO0gS/l5xT8efa3XVhgh" +
       "h1EgKQcTOVzkybNLZzyAI2OvTObx1zKZkyJnL4yVXkN1R/p4ho+nR+fFn3+J" +
       "nfzw11s/d7iwpthSUR3BPjyCrh7uzp14CU9fWNtxXVf6z37z0S888syxR/Po" +
       "AfDpwDuD7am73w5jHD+q7nMVv/b2f/L9//ClP64OPP8f65mGuLwuAAA=");
}
