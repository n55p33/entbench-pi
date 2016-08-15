package org.apache.batik.gvt.font;
public class Kern {
    private int[] firstGlyphCodes;
    private int[] secondGlyphCodes;
    private org.apache.batik.gvt.font.UnicodeRange[] firstUnicodeRanges;
    private org.apache.batik.gvt.font.UnicodeRange[] secondUnicodeRanges;
    private float kerningAdjust;
    public Kern(int[] firstGlyphCodes, int[] secondGlyphCodes, org.apache.batik.gvt.font.UnicodeRange[] firstUnicodeRanges,
                org.apache.batik.gvt.font.UnicodeRange[] secondUnicodeRanges,
                float adjustValue) { super();
                                     this.firstGlyphCodes = firstGlyphCodes;
                                     this.secondGlyphCodes = secondGlyphCodes;
                                     this.firstUnicodeRanges = firstUnicodeRanges;
                                     this.secondUnicodeRanges = secondUnicodeRanges;
                                     this.kerningAdjust = adjustValue;
                                     if (firstGlyphCodes != null)
                                         java.util.Arrays.
                                           sort(
                                             this.
                                               firstGlyphCodes);
                                     if (secondGlyphCodes != null)
                                         java.util.Arrays.
                                           sort(
                                             this.
                                               secondGlyphCodes);
    }
    public boolean matchesFirstGlyph(int glyphCode, java.lang.String glyphUnicode) {
        if (firstGlyphCodes !=
              null) {
            int pt =
              java.util.Arrays.
              binarySearch(
                firstGlyphCodes,
                glyphCode);
            if (pt >=
                  0)
                return true;
        }
        if (glyphUnicode.
              length(
                ) <
              1)
            return false;
        char glyphChar =
          glyphUnicode.
          charAt(
            0);
        for (int i =
               0;
             i <
               firstUnicodeRanges.
                 length;
             i++) {
            if (firstUnicodeRanges[i].
                  contains(
                    glyphChar))
                return true;
        }
        return false;
    }
    public boolean matchesFirstGlyph(int glyphCode, char glyphUnicode) {
        if (firstGlyphCodes !=
              null) {
            int pt =
              java.util.Arrays.
              binarySearch(
                firstGlyphCodes,
                glyphCode);
            if (pt >=
                  0)
                return true;
        }
        for (int i =
               0;
             i <
               firstUnicodeRanges.
                 length;
             i++) {
            if (firstUnicodeRanges[i].
                  contains(
                    glyphUnicode))
                return true;
        }
        return false;
    }
    public boolean matchesSecondGlyph(int glyphCode, java.lang.String glyphUnicode) {
        if (secondGlyphCodes !=
              null) {
            int pt =
              java.util.Arrays.
              binarySearch(
                secondGlyphCodes,
                glyphCode);
            if (pt >=
                  0)
                return true;
        }
        if (glyphUnicode.
              length(
                ) <
              1)
            return false;
        char glyphChar =
          glyphUnicode.
          charAt(
            0);
        for (int i =
               0;
             i <
               secondUnicodeRanges.
                 length;
             i++) {
            if (secondUnicodeRanges[i].
                  contains(
                    glyphChar))
                return true;
        }
        return false;
    }
    public boolean matchesSecondGlyph(int glyphCode,
                                      char glyphUnicode) {
        if (secondGlyphCodes !=
              null) {
            int pt =
              java.util.Arrays.
              binarySearch(
                secondGlyphCodes,
                glyphCode);
            if (pt >=
                  0)
                return true;
        }
        for (int i =
               0;
             i <
               secondUnicodeRanges.
                 length;
             i++) {
            if (secondUnicodeRanges[i].
                  contains(
                    glyphUnicode))
                return true;
        }
        return false;
    }
    public float getAdjustValue() { return kerningAdjust;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "k6Wqx6UkAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "5783/J7m5E/v3HehnOp/RZWHDC3a7yeU");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("BwuKt6ec+E/eDIcpcKDiDF9xIOmxW04A70+tKl945dp973hF/J390aCjk6X3" +
       "05X7dJBSTh9GOHV/2Q803Sp5un+/H+mXTFyJKj9wxx1mQE3xV5B54fIe/mpU" +
       "eevt4KPKPaA9DflgVLl+HjKqXCr/T8NdjypXT+CiyuX9zWmQRwF2AFLcvtW/" +
       "zf7I/vRGeuFsgjlWwSOvp4JTOenGmb3f8qz20ZGF3f609gvKF18ZsR/6dvNz" +
       "+/N4ii3leYHlPrpyZX80sERaHHt45o7YjnBdHr77Ow/98v3PHWW5h/YEn1ju" +
       "Kdqeuv3hN9zxo/K4Wv4P3/H33/t3Xvm9crvm/wLF6KUURC8AAA==");
}
