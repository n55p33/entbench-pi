package org.apache.batik.gvt.font;
public class AWTFontFamily implements org.apache.batik.gvt.font.GVTFontFamily {
    public static final java.text.AttributedCharacterIterator.Attribute TEXT_COMPOUND_DELIMITER =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        TEXT_COMPOUND_DELIMITER;
    protected org.apache.batik.gvt.font.GVTFontFace fontFace;
    protected java.awt.Font font;
    public AWTFontFamily(org.apache.batik.gvt.font.GVTFontFace fontFace) {
        super(
          );
        this.
          fontFace =
          fontFace;
    }
    public AWTFontFamily(java.lang.String familyName) { this(new org.apache.batik.gvt.font.GVTFontFace(
                                                               familyName));
    }
    public AWTFontFamily(org.apache.batik.gvt.font.GVTFontFace fontFace,
                         java.awt.Font font) { super();
                                               this.fontFace =
                                                 fontFace;
                                               this.font =
                                                 font; }
    public java.lang.String getFamilyName() { return fontFace.
                                                getFamilyName(
                                                  ); }
    public org.apache.batik.gvt.font.GVTFontFace getFontFace() {
        return fontFace;
    }
    public org.apache.batik.gvt.font.GVTFont deriveFont(float size,
                                                        java.text.AttributedCharacterIterator aci) {
        if (font !=
              null)
            return new org.apache.batik.gvt.font.AWTGVTFont(
              font,
              size);
        return deriveFont(
                 size,
                 aci.
                   getAttributes(
                     ));
    }
    public org.apache.batik.gvt.font.GVTFont deriveFont(float size,
                                                        java.util.Map attrs) {
        if (font !=
              null)
            return new org.apache.batik.gvt.font.AWTGVTFont(
              font,
              size);
        java.util.Map fontAttributes =
          new java.util.HashMap(
          attrs);
        fontAttributes.
          put(
            java.awt.font.TextAttribute.
              SIZE,
            new java.lang.Float(
              size));
        fontAttributes.
          put(
            java.awt.font.TextAttribute.
              FAMILY,
            fontFace.
              getFamilyName(
                ));
        fontAttributes.
          remove(
            TEXT_COMPOUND_DELIMITER);
        return new org.apache.batik.gvt.font.AWTGVTFont(
          fontAttributes);
    }
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
       "vZ0TC4qyxdWIr5oTe0JKK5GsqQt6uNqwlrod2wEnuQKtKTFtm3ivm7as3phx" +
       "RoEgUMtJ0p91XVWcNPBpfzT20/a2iUwSMxE10V8avWZv3c02eYRHWb3T6ysK" +
       "lWaEKgzEhUyptmsOWu3dSqbq/jYaOUmywjk2w+sVkWEmUuJ4m0VIMXVrE8Iw" +
       "PKxLGDfPZxtMlKaDzZQdrIbksLEbT6gFUl8yGlttK7UmmbmUy6xIFmcxfNic" +
       "iqNcGZv1nejF45xEOtKUjphUZEyUEZVYmAwEyp1JGRWtTLzuM1N6uuthwsoX" +
       "RHSSy5FXUTxOEZM+PxhxSr8DtAImAxvQKVNha8xSTmKzLGG6GzP0hjK5GrQS" +
       "YTsJKVdRiKmTjJWIMe0NNxMMbeHajp10tyqfAySYO1mxLaTDzwg5d7ZDOZgM" +
       "lyvdGAjIEE/g7WqaON1hkrR28lT0UJZo9hls1k2W1aiL1eUWyQ7okYjhHLPG" +
       "rOZgzBuYiXWDwvSGcz9triy8h2EzN5+6Y8njemPAos52wQIdN5WQRYcmTZBi" +
       "KijUok2FjsIReobbTYvu1uYYQXVDR0VrZoAN1arJ8MNpMGpWpwa9zDJxt4iM" +
       "jOoFFid6NAmPXGzV3na5Kj6VhoaN2VMr1mbCmh1V6GDexLuknWEdu1/R5jV6" +
       "24ZXFYRSt0s2t6kcFvjlSnXsRjiYWKsRkznxTLK7y5ocrQTSaTCJ3/Sqs9RT" +
       "WwlmEf48atiMKe/sqjoI1kHWM4yJA29dzt2uJsR8FLGDke+KtVh0t7WpJlh6" +
       "iIcNN18pxDAMs7XV9lid6lC4IwWVJkebKJX7ArlbCSsJztsrwaRoiein6346" +
       "FJN6R8lppm3oycS0ZXzcbpLNZn2xRjfzqmyHsqBENoER2IQWRW4yF+dNZ4L1" +
       "A4wcL4Ww2vUWMOEwotNt+AOCqVXlbleLcLuWMOGom3jj6cDSJHXUUbG108Rn" +
       "TdY165FVn628QFwu5f6uYazI+qRW8bw2rXGraGvq3k51a4FhGAxW6Wb+WOlP" +
       "Z0RkyZiUDHpjpMdTnIliVr+nspmzcHkLNuS8mS2xRkqy+SLrOf064WpmR0uQ" +
       "WNmtx3QiRNmiK61ABMPqUguNkozrMoFDblQ27Ug840QImtIwa9Pd2Xg2lsfq" +
       "UkzEhmEpXdfxvMqonvSTCNd69KLlmoTPSlVJGdO2qPjughhEUqJHznrE7khi" +
       "vB2KK42Nxi1xMvHIzlbm4L6j8gbf1nh4hDacWjobZxbewa0BOt9Ue4HTWVsO" +
       "WMmtDRje5YhVX5FjQsWF2RzLkxwEknq8lRq1CTuXtm2JDKtwIvDdmtTo9eWQ" +
       "bhD9Mcyt2jpq4tOBms2GbFITsFxM51Mz3DCjCTJPIiGbpuYO6QvLipGoLJW0" +
       "OozTbNMbJxN68EaTmoOwlUau7wRz322wgVl1yRR1YLi94HfZMtrpCj9xjS45" +
       "1NPqBg/dWjJ0xJhLU5dtReMeUovR0Kk0GqrBzpYxC9x4t7DMvpptsUE+GeB+" +
       "AOcII63XJJLkw3VlTSPoAJ/Gu66j6ku6Sc0Heo1eTPqBvFQMtpeIrYFNYbM+" +
       "auFdIxPdiMopj6vGZLseOw5SXcKp4jDpmFLkAPM1bRbinXUut9oux9R3nTCs" +
       "T9sLf6HUwUQzw/wu3UnFWitotSm3HQ06bX1O8EhzlmGp0F1MjHFzZfNDpjXF" +
       "avlWV3fJiq4ynNtYsqLgGpSzjnpOwPIkXut2AoyxlHq6mQ36jbk6T51FYykR" +
       "2zaqSXwrVGHdoFyvXetgc06ZrCqmJscDmwXYaWzdWSjb6WI46cYm46wnGiKM" +
       "jcqECjchbuMDUm5xquUOZE3zJ5jURtvbSkUPYiNVuvNNp4kps4koULjQoocu" +
       "Nm9hQLB0DqQ6ayqLaEpMe1V2QtDjOU5Ud6Yq5JGR9jRlgWzCZtDS9GLK2alG" +
       "Y7eMWJlmcLSaorPZUGmkqN9uxAltTZW+5FWZWjDskUQUNuqIQ+BRNGeY5jRj" +
       "t5tOZZibQkdz+iNktegwcNWQGuJkLszrSdqYKDxS63h9pmaPloHDOxukkW6F" +
       "VRAIVt+fYbhm6p2aPPG5JUtYObekGpxu9eectZg2GQahPUVCV/VFYK89vdJW" +
       "9F5aqWgsXmFIZbYLc20NO3CrKQ+WyNpDTYnfrgnHpbI15jTEEbKcmS10yI+Y" +
       "lhZiXdTF6220jwspQvLZFu74y0qnZXYqrMMNfFeIUyycNbvbATyxxX5VyZCQ" +
       "2W7RecaYCKsjWMCb/XXblskNutRrA8tIsq4WGoMOErFc27AoZpfHjMwpQPsD" +
       "stJf06knGcSWyzuB39aJuN8bjvNx0sDsDWXbGMp6/ZjvErHZwIJuVVYsdLUe" +
       "hBHSMbRBpQWH9U3PqGJVutNQyMzUtrS1tukwIxZTzIhsvSVGXX4i2PM83G03" +
       "mEPFnaCSV6t1TVhNCYNhuayXqIEzSmmzkzTGdWfEKCYxUcOKuzJ3IwdftEet" +
       "JBvLyrilKKKPrnIdaKRKS2Z32tBrkqjSuNJCuu1Ng1JGXoK54ijphmsP9hZz" +
       "mhwIym6jUDLcSuzAi6lBuzrLfK7lS6EVdCobKem5WWyJYOnGtHMWQTXfaDFw" +
       "MO+NspSxmI3f8FwENdN5pTPgNgjMuzYhJpyIzkAOEI3ksc6zCMZI22nclGcw" +
       "OVnqSup0UH+EVY35dDiV8jiripvxtLLOhf6MqLZGZCTrhuL3QDCfg9DBhfXV" +
       "YuGRgdQS1hWz0+F3A0+nM77e2fn8YBX2EHuSRdVJC6xdlkM2NrfNRTrfrtlB" +
       "NSSriSlo9kDc9ZVOFuyirSeymZszNa+2XlpqL3VrErEaSC2DVpt+fcfVjXod" +
       "sYn1rhvPfXKwHPd9K6/EYWhJ0QCJKtJsmZAWXGdrw34WcCRbSyb8tMH6csYr" +
       "wMzrs4xOgmXDF1b92bpaaVbyOMypkdxfcIQmuBytVRq1MUjm0IhDMJ9a+8bA" +
       "242GFG3laqXNIdO4XVkv5pkAImBlHaAabHWsrk1yUuJuA1yCe4FZMYwK3otH" +
       "1ABWqSBM4kgRYC5lRKQXEo7fzcQJxQhOU69vsk4TzrFpV6+tQcYz0nQEbUjz" +
       "3px0uIUfI5PmeJ4Kgj6qT9q1jUpafX2SzZaeNuov+XkOr3V+p5NTA2WUDMWU" +
       "tiryIF7YYRcPbKTq1kZcZydUuPVyZkctCpApzKWBq6Bclezh5MLyB5E72WyD" +
       "xU4aowzhtsP2Qm4ryCzuJ6m36sG1+YzoI37o9NYdMjTQgeITK7MtmlhLqtdJ" +
       "eSiPTHQ+JKcrg3Ekr8Lu5I63zYhZvOpXFBFdV5aa0scXDdrtMF6rs/I9fTGq" +
       "B6i8JIiQqGmMhfBGazkbbCS3buIEwoXTuoEiIS81onUkd1BmpqE91E3n7G5H" +
       "MgrIx6rNRseAZS2fVTXKxjCQGbG44CljCu4IIBPzYCTlmAAdB3NNlWcdvua0" +
       "4xW/hoOdUEU0Rkgmor9rbNDmDh45mthQeV/rY4tN7ijVqBPgMchgF+lmInn1" +
       "FVMP5616W6ccEs1Ro49kDhYBR0bW/lqqUy1u3uDl+g5L6m2uEiTWrqlgwdro" +
       "6iRRQ3R7yvN1CkWqqSYMxzwfW41G6vM+gQAH2rUpewxny9YmQ+Yw0YI3Fd/o" +
       "hGy+FgSHcrbt5rbKE3qku9XhfGDJUUCEqgzz/tR1aHqzAd414hLD57vBgPam" +
       "Pbo1wS1bc+l2Xs0EwsKdkdGs5UGDbi2ndsiq1TnddoIxVuu2eZGJRcfYtLZG" +
       "skNJTqsJnFNxMkVtgXA3THY+gyUmbFYW+MSWV3UjsGB5jcZOCtL2mq/WbNFS" +
       "3CgiKHKgzhOxoq6r7SLHXU9WaSy2Z/PeeCfG6mqpLnt0MukoRC/gk26ylqq9" +
       "xUzvrYKJ3TPGJOLkuMSvY2EHAlue20if3nW3ejW1ou0gloXecBm6ouw2Qp60" +
       "mBTlHbo5mgfyvF3pIzq6ZLeowghtktzUFvx8zdAoHPbrfMtl3GpMNaZTZrbt" +
       "LulIxIYhGrMStR5oNXmBDUKBYhIhSTiFXeBaVmnM7U2tlmlBG8yAVKVOSA0E" +
       "7+2GtcSJsI4hrSaut7CXyChIXElSmiAn4CLSnKCboK/pnWEbb1rYekvpLW1W" +
       "Rfr1JHGXTrzeiO2p2Qtbldm6Qi+RebsLjKTfxymr2+1+U7Fd8P1vbMfm4XIj" +
       "6uS6wT9hC2pzqy338ncZunBEfXHL/bHzBwx3OMI9OSkqjnCL3ZonbnfroNyp" +
       "+eQHX3pZG/1k7eBoO/57U+j+NIy+wdPXundm6LsBpudvvyvFlpcuTre4f+uD" +
       "f/X49Jut97+Bg92nLtB5EeXPsK/89uBd6g8cQHedbHjfdB3kfKcXzm9zX4n1" +
       "NIuD6bnN7idONPFIIfinwMMcaYK5uGt6qutbb5m+e28rdzjt+Kk7tP1MUfx4" +
       "Cj1o6kfq445o757a10+84YOhHzth8NFj8xKOGBS++gz+4h3aPl0Un0qhBwoG" +
       "z+50n7L36j+DvTcXlU+A531H7L3vq8Pe0SFX+f3dZ3z8e4rjDC9U0pPz23/U" +
       "6UM5xm/cQUy/WRT/JoWuaHpsr/VCUscjPP26fn8qyl/9aojSPRKl+1UVZfH5" +
       "2rmN5PMBZaLkZZS6of7r8ec/+4ndq6/s94mXSqKnUOV21+xuvulX3Od49g53" +
       "Uk4vYP3N4Btf+8v/In3bcRx84EQWzxesf8OdZHH+5LPc42aVsu2PS1y/fwdl" +
       "/0lR/Idzyi5qPnOqx997QweigIpzl3iKGwmP3XQ7cH+jTf3Uy1fve/Rl8Y/K" +
       "eywnt87uZ6D7jMzzzh4Qnnm/HMW6YZfE378/LozKvz9Poa+5rXkenSKV9P7n" +
       "Pfx/S6G33Ao+he4C5VnIL6TQtYuQwPfK/7NwXwRiPIVLocv7l7Mg/wNgByDF" +
       "6/+MbnFcvz9R3Vw6M/MdOUepi0deTxcnXc5eiCnsrrzHeTyzZfyReb/6Ms19" +
       "+5dbP7m/kKN6ym5XYLmPge7d3w06mR2fvi22Y1yXyee+8tDP3//ssQU/tCf4" +
       "1FHP0PbUrW+/9P0oLe+r7H7l0V96z0+9/GflKdc/AMUSx31gKwAA");
}
