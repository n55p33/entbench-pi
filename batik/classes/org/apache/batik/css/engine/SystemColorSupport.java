package org.apache.batik.css.engine;
public class SystemColorSupport implements org.apache.batik.util.CSSConstants {
    public static org.apache.batik.css.engine.value.Value getSystemColor(java.lang.String ident) {
        ident =
          ident.
            toLowerCase(
              );
        java.awt.SystemColor sc =
          (java.awt.SystemColor)
            factories.
            get(
              ident);
        return new org.apache.batik.css.engine.value.RGBColorValue(
          new org.apache.batik.css.engine.value.FloatValue(
            org.w3c.dom.css.CSSPrimitiveValue.
              CSS_NUMBER,
            sc.
              getRed(
                )),
          new org.apache.batik.css.engine.value.FloatValue(
            org.w3c.dom.css.CSSPrimitiveValue.
              CSS_NUMBER,
            sc.
              getGreen(
                )),
          new org.apache.batik.css.engine.value.FloatValue(
            org.w3c.dom.css.CSSPrimitiveValue.
              CSS_NUMBER,
            sc.
              getBlue(
                )));
    }
    protected static final java.util.Map factories = new java.util.HashMap(
      );
    static { factories.put(CSS_ACTIVEBORDER_VALUE, java.awt.SystemColor.
                                                     windowBorder);
             factories.put(CSS_ACTIVECAPTION_VALUE, java.awt.SystemColor.
                                                      activeCaption);
             factories.put(CSS_APPWORKSPACE_VALUE, java.awt.SystemColor.
                                                     desktop);
             factories.put(CSS_BACKGROUND_VALUE, java.awt.SystemColor.
                                                   desktop);
             factories.put(CSS_BUTTONFACE_VALUE, java.awt.SystemColor.
                                                   control);
             factories.put(CSS_BUTTONHIGHLIGHT_VALUE, java.awt.SystemColor.
                                                        controlLtHighlight);
             factories.put(CSS_BUTTONSHADOW_VALUE, java.awt.SystemColor.
                                                     controlDkShadow);
             factories.put(CSS_BUTTONTEXT_VALUE, java.awt.SystemColor.
                                                   controlText);
             factories.put(CSS_CAPTIONTEXT_VALUE, java.awt.SystemColor.
                                                    activeCaptionText);
             factories.put(CSS_GRAYTEXT_VALUE, java.awt.SystemColor.
                                                 textInactiveText);
             factories.put(CSS_HIGHLIGHT_VALUE, java.awt.SystemColor.
                                                  textHighlight);
             factories.put(CSS_HIGHLIGHTTEXT_VALUE, java.awt.SystemColor.
                                                      textHighlightText);
             factories.put(CSS_INACTIVEBORDER_VALUE, java.awt.SystemColor.
                                                       windowBorder);
             factories.put(CSS_INACTIVECAPTION_VALUE, java.awt.SystemColor.
                                                        inactiveCaption);
             factories.put(CSS_INACTIVECAPTIONTEXT_VALUE, java.awt.SystemColor.
                                                            inactiveCaptionText);
             factories.put(CSS_INFOBACKGROUND_VALUE, java.awt.SystemColor.
                                                       info);
             factories.put(CSS_INFOTEXT_VALUE, java.awt.SystemColor.
                                                 infoText);
             factories.put(CSS_MENU_VALUE, java.awt.SystemColor.menu);
             factories.put(CSS_MENUTEXT_VALUE, java.awt.SystemColor.
                                                 menuText);
             factories.put(CSS_SCROLLBAR_VALUE, java.awt.SystemColor.
                                                  scrollbar);
             factories.put(CSS_THREEDDARKSHADOW_VALUE, java.awt.SystemColor.
                                                         controlDkShadow);
             factories.put(CSS_THREEDFACE_VALUE, java.awt.SystemColor.
                                                   control);
             factories.put(CSS_THREEDHIGHLIGHT_VALUE, java.awt.SystemColor.
                                                        controlHighlight);
             factories.put(CSS_THREEDLIGHTSHADOW_VALUE, java.awt.SystemColor.
                                                          controlLtHighlight);
             factories.put(CSS_THREEDSHADOW_VALUE, java.awt.SystemColor.
                                                     controlShadow);
             factories.put(CSS_WINDOW_VALUE, java.awt.SystemColor.
                                               window);
             factories.put(CSS_WINDOWFRAME_VALUE, java.awt.SystemColor.
                                                    windowBorder);
             factories.put(CSS_WINDOWTEXT_VALUE, java.awt.SystemColor.
                                                   windowText); }
    protected SystemColorSupport() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1YfWwUxxWfO+PzB/4GjGOwMY4B8ZG70IYSakJjHAOmZ3Ax" +
                                                              "sdTj45jbm/Mt3ttddmfts9OkCVIVqraUUiCkKvxFSkpJiKpGbdomchU1H0pa" +
                                                              "iYQ2TaNQ1PSPpClKaJS0Kv16M7N7+3Fn06hqT7q5udk3b+a9+b3fe7Pnr6Jy" +
                                                              "00DtRKVROqETM9qn0kFsmCTdq2DT3AljSemhMvzB3re3rQujSALVZbE5IGGT" +
                                                              "bJKJkjYTqE1WTYpViZjbCEmzGYMGMYkxhqmsqQk0Tzb7c7oiSzId0NKECQxj" +
                                                              "I44aMaWGnLIo6bcVUNQWh53E+E5iPcHH3XFUI2n6hCve4hHv9Txhkjl3LZOi" +
                                                              "hvh+PIZjFpWVWFw2aXfeQCt1TZkYUTQaJXka3a+ssV2wNb6myAWdT9R/dP1I" +
                                                              "toG7YA5WVY1y88wdxNSUMZKOo3p3tE8hOfMAug+VxdFsjzBFXXFn0RgsGoNF" +
                                                              "HWtdKdh9LVGtXK/GzaGOpogusQ1RtNivRMcGztlqBvmeQUMltW3nk8HajoK1" +
                                                              "wsoiE4+vjB17aG/D98tQfQLVy+oQ244Em6CwSAIcSnIpYpg96TRJJ1CjCoc9" +
                                                              "RAwZK/KkfdJNpjyiYmrB8TtuYYOWTgy+pusrOEewzbAkqhkF8zIcUPa/8oyC" +
                                                              "R8DWZtdWYeEmNg4GVsuwMSODAXf2lFmjspqmaFFwRsHGrs+CAEytyBGa1QpL" +
                                                              "zVIxDKAmAREFqyOxIYCeOgKi5RoA0KCodVqlzNc6lkbxCEkyRAbkBsUjkKri" +
                                                              "jmBTKJoXFOOa4JRaA6fkOZ+r29YfvkfdooZRCPacJpLC9j8bJrUHJu0gGWIQ" +
                                                              "iAMxsWZF/ARufvpQGCEQnhcQFjI//MK1O1e1T70gZBaUkNme2k8kmpTOpOou" +
                                                              "Luxdvq6MbaNS10yZHb7Pch5lg/aT7rwODNNc0MgeRp2HUzue+/z958i7YVTd" +
                                                              "jyKSplg5wFGjpOV0WSHGZqISA1OS7kdVRE338uf9qAL6cVklYnR7JmMS2o9m" +
                                                              "KXwoovH/4KIMqGAuqoa+rGY0p69jmuX9vI4QqoAvWgvfpUh8+C9FOJbVciSG" +
                                                              "JazKqhYbNDRmvxkDxkmBb7OxFKB+NGZqlgEQjGnGSAwDDrLEfiCZTHYE9hQb" +
                                                              "mjApgXBWNGPI0nXNALYBqOn/j0XyzNI546EQHMLCIAUoED1bNCVNjKR0zNrY" +
                                                              "d+3x5EsCXiwkbB9RFIV1o2LdKF83CutGxbrR4nVRKMSXm8vWF+cNpzUKcQ/E" +
                                                              "W7N8aM/WfYc6ywBo+vgscDUT7fQloF6XHBxGT0oXmmonF19e/WwYzYqjJixR" +
                                                              "Cyssn/QYI8BU0qgdzDUpSE1uhujwZAiW2gxNImkgqOkyha2lUhsjBhunaK5H" +
                                                              "g5O/WKTGps8eJfePpk6OPzD8xVvDKOxPCmzJcuAzNn2QUXmBsruCZFBKb/2D" +
                                                              "b3904cS9mksLvizjJMeimcyGziAggu5JSis68JPJp+/t4m6vAtqmGE4dDrk9" +
                                                              "uIaPdbodBme2VILBGc3IYYU9cnxcTbOGNu6OcKQ28v5cgEUdC8MO+I7Zccl/" +
                                                              "2dNmnbXzBbIZzgJW8Axxx5B+6je/fOeT3N1OMqn3VAFDhHZ7CIwpa+JU1ejC" +
                                                              "dqdBCMi9eXLwm8evPriLYxYkbi61YBdre4G44AjBzV964cDrv7t85lLYxTlF" +
                                                              "VbqhUQhwks4X7GSPUO0MdsKCS90tQaApoIEBp+tuFSAqZ2ScUgiLrb/XL1n9" +
                                                              "5J8ONwgoKDDiIGnVjRW44zdtRPe/tPcv7VxNSGI52HWbKyaIfY6ruccw8ATb" +
                                                              "R/6BV9oefh6fghQBtGzKk4QzLeJuQPzc1nD7b+XtbYFna1mzxPTi3x9inlop" +
                                                              "KR259H7t8PvPXOO79Rdb3uMewHq3QBhrluZB/fwgP23BZhbkbpvatrtBmboO" +
                                                              "GhOgUQLmNbcbQJJ5Hzhs6fKK3/7s2eZ9F8tQeBOqVjSc3oR5nKEqADgxs8Cv" +
                                                              "ef0zd4rDHa+EpoGbioqMLxpgDl5U+uj6cjrlzp780fwfrD97+jIHmi50LCgQ" +
                                                              "60IfsfKS3Y3tc6+u/dXZb5wYF0l/+fSEFpjX8rftSurg7/9a5HJOZSUKksD8" +
                                                              "ROz8t1t7N7zL57ucwmZ35YvTFPCyO/cT53IfhjsjPw+jigRqkOwSeRgrFovU" +
                                                              "BJSFplM3Qxnte+4v8UQ9013gzIVBPvMsG2QzNz1Cn0mzfm2AwBawI1xnFxdO" +
                                                              "keEjsBDinX4+ZRlvV7DmFn58ZawbpShi8kKcwhZkFSsB5midYQEgnAzHogwI" +
                                                              "NlCbiwWWyIaslEl34HFeYial3csamrvWfdApwNBeQtZTix7+yY8TiWUNkhDu" +
                                                              "LKXYX4M+erZSeiP33B/EhJtKTBBy8x6NfW34tf0vc9quZLl8p+NeT6aGnO/J" +
                                                              "GQ3+nNEI3yu2R66IWm73f1lmwTS4YMk5uBPEdso5kmYXPGaDXcb9T/VzqvKF" +
                                                              "sXto3xtVet67/Tt3CLcuniaCXfmnPnfl4qnJC+dFhmDupWjldFfS4nswqxmW" +
                                                              "zFD3uAD5cPOnp955a3hP2Ob0OtYMC+y2UFTrkhpQKBvcWyC/UIG85vphIjTf" +
                                                              "9eX6nx5pKtsEBUk/qrRU+YBF+tP+mKwwrZQHN+7Ny41TGzT/gk8Ivv9kXwYW" +
                                                              "NiBA09Rr30I6CtcQ4Ff2HCrcFdAV9Qdrb2fNVmFddymqz5cOcSgJIrqVUmTJ" +
                                                              "jWr+iQTvI956wMvwtj87iyp0kTCGhgovERiM2qa7XfKb8ZmDx06ntz+yWoCp" +
                                                              "yX9j61Ot3GO//sfL0ZNXXixxRaiimn6LQsaIEkhAbT7kDvCLt8vmb9Ydfeup" +
                                                              "rpGNH6eoZ2PtNyjb2f9FYMSK6cEa3MrzB//YunNDdt/HqM8XBdwZVPndgfMv" +
                                                              "bl4qHQ3ztwwizRS9nfBP6vYDudog1DJUP3RvLmClxcHHShsrK0vXyCXBF2bd" +
                                                              "/awZCOSUxhk0Buq2kB+HDTyuWX6NilcofAP3zVDsHWRNnqK6EUI9V0lH4bKZ" +
                                                              "rp5jLKtHeW53w3BihjD8DyouNtCjw4aaii+2rBxrKXqNJl79SI+frq+cf/ru" +
                                                              "1ziUC69nagCUGUtRvAWDpx/RDZKRuSNqRPkgaOWrFC2YwXKgDdHh+/+KmPN1" +
                                                              "uKuWmkNRGbReyaNwUEFJKC/4r1fuOEXVrhwsKjpekZOgHURY92G9BApElZUP" +
                                                              "eVjB9jo/rHk3OqzCFO+ti8Uyf+npxJ01aOe3C6e3brvn2qceEbc+ScGTk0zL" +
                                                              "bEgJ4gJaiN3F02pzdEW2LL9e90TVEieFNYoNuxG1wAPjHggCneGjNXAfMrsK" +
                                                              "16LXz6x/5heHIq8Afe5CIUzRnF3F9Whet4A0d8WLUx/wHL+odS//1sSGVZn3" +
                                                              "3uAVf3GdH5RPSpfO7nn1aMsZuNDN7kflwPQkzwvluybUHUQaMxKoVjb78rBF" +
                                                              "0CJjxZdX6xiUMYtl7hfbnbWFUfbOABJQ0XvPEm9a4HY0ToyNmqWm7cw82x3x" +
                                                              "vY116A/iLjDBHfFUgJg1Ul7k7bJkfEDXnTwe+bPOYzoVpCw+yGef513WPPZv" +
                                                              "R5d8PxAZAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AAA=");
}
