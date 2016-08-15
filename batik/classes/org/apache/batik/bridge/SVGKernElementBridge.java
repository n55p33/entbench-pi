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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "WugHFAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "p394/++/+7df+nbeBvtfODXmcU4fAAA=");
}
