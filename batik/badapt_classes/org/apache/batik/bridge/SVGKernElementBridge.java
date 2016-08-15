package org.apache.batik.bridge;
public abstract class SVGKernElementBridge extends org.apache.batik.bridge.AbstractSVGBridge {
    public org.apache.batik.gvt.font.Kern createKern(org.apache.batik.bridge.BridgeContext ctx,
                                                     org.w3c.dom.Element kernElement,
                                                     org.apache.batik.bridge.SVGGVTFont font) {
        java.lang.String u1 =
          kernElement.
          getAttributeNS(
            null,
            SVG_U1_ATTRIBUTE);
        java.lang.String u2 =
          kernElement.
          getAttributeNS(
            null,
            SVG_U2_ATTRIBUTE);
        java.lang.String g1 =
          kernElement.
          getAttributeNS(
            null,
            SVG_G1_ATTRIBUTE);
        java.lang.String g2 =
          kernElement.
          getAttributeNS(
            null,
            SVG_G2_ATTRIBUTE);
        java.lang.String k =
          kernElement.
          getAttributeNS(
            null,
            SVG_K_ATTRIBUTE);
        if (k.
              length(
                ) ==
              0) {
            k =
              SVG_KERN_K_DEFAULT_VALUE;
        }
        float kernValue =
          java.lang.Float.
          parseFloat(
            k);
        int firstGlyphLen =
          0;
        int secondGlyphLen =
          0;
        int[] firstGlyphSet =
          null;
        int[] secondGlyphSet =
          null;
        java.util.List firstUnicodeRanges =
          new java.util.ArrayList(
          );
        java.util.List secondUnicodeRanges =
          new java.util.ArrayList(
          );
        java.util.StringTokenizer st =
          new java.util.StringTokenizer(
          u1,
          ",");
        while (st.
                 hasMoreTokens(
                   )) {
            java.lang.String token =
              st.
              nextToken(
                );
            if (token.
                  startsWith(
                    "U+")) {
                firstUnicodeRanges.
                  add(
                    new org.apache.batik.gvt.font.UnicodeRange(
                      token));
            }
            else {
                int[] glyphCodes =
                  font.
                  getGlyphCodesForUnicode(
                    token);
                if (firstGlyphSet ==
                      null) {
                    firstGlyphSet =
                      glyphCodes;
                    firstGlyphLen =
                      glyphCodes.
                        length;
                }
                else {
                    if (firstGlyphLen +
                          glyphCodes.
                            length >
                          firstGlyphSet.
                            length) {
                        int sz =
                          firstGlyphSet.
                            length *
                          2;
                        if (sz <
                              firstGlyphLen +
                              glyphCodes.
                                length)
                            sz =
                              firstGlyphLen +
                                glyphCodes.
                                  length;
                        int[] tmp =
                          new int[sz];
                        java.lang.System.
                          arraycopy(
                            firstGlyphSet,
                            0,
                            tmp,
                            0,
                            firstGlyphLen);
                        firstGlyphSet =
                          tmp;
                    }
                    for (int i =
                           0;
                         i <
                           glyphCodes.
                             length;
                         i++)
                        firstGlyphSet[firstGlyphLen++] =
                          glyphCodes[i];
                }
            }
        }
        st =
          new java.util.StringTokenizer(
            u2,
            ",");
        while (st.
                 hasMoreTokens(
                   )) {
            java.lang.String token =
              st.
              nextToken(
                );
            if (token.
                  startsWith(
                    "U+")) {
                secondUnicodeRanges.
                  add(
                    new org.apache.batik.gvt.font.UnicodeRange(
                      token));
            }
            else {
                int[] glyphCodes =
                  font.
                  getGlyphCodesForUnicode(
                    token);
                if (secondGlyphSet ==
                      null) {
                    secondGlyphSet =
                      glyphCodes;
                    secondGlyphLen =
                      glyphCodes.
                        length;
                }
                else {
                    if (secondGlyphLen +
                          glyphCodes.
                            length >
                          secondGlyphSet.
                            length) {
                        int sz =
                          secondGlyphSet.
                            length *
                          2;
                        if (sz <
                              secondGlyphLen +
                              glyphCodes.
                                length)
                            sz =
                              secondGlyphLen +
                                glyphCodes.
                                  length;
                        int[] tmp =
                          new int[sz];
                        java.lang.System.
                          arraycopy(
                            secondGlyphSet,
                            0,
                            tmp,
                            0,
                            secondGlyphLen);
                        secondGlyphSet =
                          tmp;
                    }
                    for (int i =
                           0;
                         i <
                           glyphCodes.
                             length;
                         i++)
                        secondGlyphSet[secondGlyphLen++] =
                          glyphCodes[i];
                }
            }
        }
        st =
          new java.util.StringTokenizer(
            g1,
            ",");
        while (st.
                 hasMoreTokens(
                   )) {
            java.lang.String token =
              st.
              nextToken(
                );
            int[] glyphCodes =
              font.
              getGlyphCodesForName(
                token);
            if (firstGlyphSet ==
                  null) {
                firstGlyphSet =
                  glyphCodes;
                firstGlyphLen =
                  glyphCodes.
                    length;
            }
            else {
                if (firstGlyphLen +
                      glyphCodes.
                        length >
                      firstGlyphSet.
                        length) {
                    int sz =
                      firstGlyphSet.
                        length *
                      2;
                    if (sz <
                          firstGlyphLen +
                          glyphCodes.
                            length)
                        sz =
                          firstGlyphLen +
                            glyphCodes.
                              length;
                    int[] tmp =
                      new int[sz];
                    java.lang.System.
                      arraycopy(
                        firstGlyphSet,
                        0,
                        tmp,
                        0,
                        firstGlyphLen);
                    firstGlyphSet =
                      tmp;
                }
                for (int i =
                       0;
                     i <
                       glyphCodes.
                         length;
                     i++)
                    firstGlyphSet[firstGlyphLen++] =
                      glyphCodes[i];
            }
        }
        st =
          new java.util.StringTokenizer(
            g2,
            ",");
        while (st.
                 hasMoreTokens(
                   )) {
            java.lang.String token =
              st.
              nextToken(
                );
            int[] glyphCodes =
              font.
              getGlyphCodesForName(
                token);
            if (secondGlyphSet ==
                  null) {
                secondGlyphSet =
                  glyphCodes;
                secondGlyphLen =
                  glyphCodes.
                    length;
            }
            else {
                if (secondGlyphLen +
                      glyphCodes.
                        length >
                      secondGlyphSet.
                        length) {
                    int sz =
                      secondGlyphSet.
                        length *
                      2;
                    if (sz <
                          secondGlyphLen +
                          glyphCodes.
                            length)
                        sz =
                          secondGlyphLen +
                            glyphCodes.
                              length;
                    int[] tmp =
                      new int[sz];
                    java.lang.System.
                      arraycopy(
                        secondGlyphSet,
                        0,
                        tmp,
                        0,
                        secondGlyphLen);
                    secondGlyphSet =
                      tmp;
                }
                for (int i =
                       0;
                     i <
                       glyphCodes.
                         length;
                     i++)
                    secondGlyphSet[secondGlyphLen++] =
                      glyphCodes[i];
            }
        }
        int[] firstGlyphs;
        if (firstGlyphLen ==
              0 ||
              firstGlyphLen ==
              firstGlyphSet.
                length) {
            firstGlyphs =
              firstGlyphSet;
        }
        else {
            firstGlyphs =
              (new int[firstGlyphLen]);
            java.lang.System.
              arraycopy(
                firstGlyphSet,
                0,
                firstGlyphs,
                0,
                firstGlyphLen);
        }
        int[] secondGlyphs;
        if (secondGlyphLen ==
              0 ||
              secondGlyphLen ==
              secondGlyphSet.
                length) {
            secondGlyphs =
              secondGlyphSet;
        }
        else {
            secondGlyphs =
              (new int[secondGlyphLen]);
            java.lang.System.
              arraycopy(
                secondGlyphSet,
                0,
                secondGlyphs,
                0,
                secondGlyphLen);
        }
        org.apache.batik.gvt.font.UnicodeRange[] firstRanges;
        firstRanges =
          (new org.apache.batik.gvt.font.UnicodeRange[firstUnicodeRanges.
                                                        size(
                                                          )]);
        firstUnicodeRanges.
          toArray(
            firstRanges);
        org.apache.batik.gvt.font.UnicodeRange[] secondRanges;
        secondRanges =
          (new org.apache.batik.gvt.font.UnicodeRange[secondUnicodeRanges.
                                                        size(
                                                          )]);
        secondUnicodeRanges.
          toArray(
            secondRanges);
        return new org.apache.batik.gvt.font.Kern(
          firstGlyphs,
          secondGlyphs,
          firstRanges,
          secondRanges,
          kernValue);
    }
    public SVGKernElementBridge() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "DH8HFAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "//67fvvl7+RtsP8F0Nuz7k4fAAA=");
}
