package org.apache.batik.extension.svg;
public class GlyphIterator {
    public static final java.text.AttributedCharacterIterator.Attribute PREFORMATTED =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        PREFORMATTED;
    public static final java.text.AttributedCharacterIterator.Attribute
      FLOW_LINE_BREAK =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        FLOW_LINE_BREAK;
    public static final java.text.AttributedCharacterIterator.Attribute
      TEXT_COMPOUND_ID =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        TEXT_COMPOUND_ID;
    public static final java.text.AttributedCharacterIterator.Attribute
      GVT_FONT =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        GVT_FONT;
    public static final char SOFT_HYPHEN = 173;
    public static final char ZERO_WIDTH_SPACE = 8203;
    public static final char ZERO_WIDTH_JOINER = 8205;
    int idx = -1;
    int chIdx = -1;
    int lineIdx = -1;
    int aciIdx = -1;
    int charCount = -1;
    float adv = 0;
    float adj = 0;
    int runLimit = 0;
    int lineBreakRunLimit = 0;
    int lineBreakCount = 0;
    org.apache.batik.gvt.font.GVTFont font = null;
    int fontStart = 0;
    float maxAscent = 0;
    float maxDescent = 0;
    float maxFontSize = 0;
    float width = 0;
    char ch = 0;
    int numGlyphs = 0;
    java.text.AttributedCharacterIterator aci;
    org.apache.batik.gvt.font.GVTGlyphVector gv;
    float[] gp;
    java.awt.font.FontRenderContext frc;
    int[] leftShiftIdx = null;
    float[] leftShiftAmt = null;
    int leftShift = 0;
    java.awt.geom.Point2D gvBase = null;
    public GlyphIterator(java.text.AttributedCharacterIterator aci,
                         org.apache.batik.gvt.font.GVTGlyphVector gv) {
        super(
          );
        this.
          aci =
          aci;
        this.
          gv =
          gv;
        this.
          idx =
          0;
        this.
          chIdx =
          0;
        this.
          lineIdx =
          0;
        this.
          aciIdx =
          aci.
            getBeginIndex(
              );
        this.
          charCount =
          gv.
            getCharacterCount(
              idx,
              idx);
        this.
          ch =
          aci.
            first(
              );
        this.
          frc =
          gv.
            getFontRenderContext(
              );
        this.
          font =
          (org.apache.batik.gvt.font.GVTFont)
            aci.
            getAttribute(
              GVT_FONT);
        if (font ==
              null) {
            font =
              new org.apache.batik.gvt.font.AWTGVTFont(
                aci.
                  getAttributes(
                    ));
        }
        fontStart =
          aciIdx;
        this.
          maxFontSize =
          -java.lang.Float.
             MAX_VALUE;
        this.
          maxAscent =
          -java.lang.Float.
             MAX_VALUE;
        this.
          maxDescent =
          -java.lang.Float.
             MAX_VALUE;
        this.
          runLimit =
          aci.
            getRunLimit(
              TEXT_COMPOUND_ID);
        this.
          lineBreakRunLimit =
          aci.
            getRunLimit(
              FLOW_LINE_BREAK);
        java.lang.Object o =
          aci.
          getAttribute(
            FLOW_LINE_BREAK);
        this.
          lineBreakCount =
          o ==
            null
            ? 0
            : 1;
        this.
          numGlyphs =
          gv.
            getNumGlyphs(
              );
        this.
          gp =
          gv.
            getGlyphPositions(
              0,
              this.
                numGlyphs +
                1,
              null);
        this.
          gvBase =
          new java.awt.geom.Point2D.Float(
            gp[0],
            gp[1]);
        this.
          adv =
          getCharWidth(
            );
        this.
          adj =
          getCharAdvance(
            );
    }
    public GlyphIterator(org.apache.batik.extension.svg.GlyphIterator gi) {
        super(
          );
        gi.
          copy1(
            this);
    }
    public org.apache.batik.extension.svg.GlyphIterator copy1() {
        return new org.apache.batik.extension.svg.GlyphIterator(
          this);
    }
    public org.apache.batik.extension.svg.GlyphIterator copy1(org.apache.batik.extension.svg.GlyphIterator gi) {
        if (gi ==
              null)
            return new org.apache.batik.extension.svg.GlyphIterator(
              this);
        gi.
          idx =
          this.
            idx;
        gi.
          chIdx =
          this.
            chIdx;
        gi.
          aciIdx =
          this.
            aciIdx;
        gi.
          charCount =
          this.
            charCount;
        gi.
          adv =
          this.
            adv;
        gi.
          adj =
          this.
            adj;
        gi.
          runLimit =
          this.
            runLimit;
        gi.
          ch =
          this.
            ch;
        gi.
          numGlyphs =
          this.
            numGlyphs;
        gi.
          gp =
          this.
            gp;
        gi.
          gvBase =
          this.
            gvBase;
        gi.
          lineBreakRunLimit =
          this.
            lineBreakRunLimit;
        gi.
          lineBreakCount =
          this.
            lineBreakCount;
        gi.
          frc =
          this.
            frc;
        gi.
          font =
          this.
            font;
        gi.
          fontStart =
          this.
            fontStart;
        gi.
          maxAscent =
          this.
            maxAscent;
        gi.
          maxDescent =
          this.
            maxDescent;
        gi.
          maxFontSize =
          this.
            maxFontSize;
        gi.
          leftShift =
          this.
            leftShift;
        gi.
          leftShiftIdx =
          this.
            leftShiftIdx;
        gi.
          leftShiftAmt =
          this.
            leftShiftAmt;
        return gi;
    }
    public int getGlyphIndex() { return idx; }
    public char getChar() { return ch; }
    public int getACIIndex() { return aciIdx; }
    public float getAdv() { return adv; }
    public java.awt.geom.Point2D getOrigin() { return gvBase;
    }
    public float getAdj() { return adj; }
    public float getMaxFontSize() { if (aciIdx >= fontStart) {
                                        int newFS =
                                          aciIdx +
                                          charCount;
                                        updateLineMetrics(
                                          newFS);
                                        fontStart =
                                          newFS;
                                    }
                                    return maxFontSize; }
    public float getMaxAscent() { if (aciIdx >= fontStart) {
                                      int newFS =
                                        aciIdx +
                                        charCount;
                                      updateLineMetrics(
                                        newFS);
                                      fontStart =
                                        newFS;
                                  }
                                  return maxAscent; }
    public float getMaxDescent() { if (aciIdx >= fontStart) {
                                       int newFS =
                                         aciIdx +
                                         charCount;
                                       updateLineMetrics(
                                         newFS);
                                       fontStart =
                                         newFS;
                                   }
                                   return maxDescent; }
    public boolean isLastChar() { return idx == numGlyphs -
                                    1; }
    public boolean done() { return idx >= numGlyphs; }
    public boolean isBreakChar() { switch (ch) { case org.apache.batik.extension.svg.GlyphIterator.
                                                        ZERO_WIDTH_SPACE:
                                                     return true;
                                                 case org.apache.batik.extension.svg.GlyphIterator.
                                                        ZERO_WIDTH_JOINER:
                                                     return false;
                                                 case org.apache.batik.extension.svg.GlyphIterator.
                                                        SOFT_HYPHEN:
                                                     return true;
                                                 case ' ':
                                                 case '\t':
                                                     return true;
                                                 default:
                                                     return false;
                                   } }
    protected boolean isPrinting(char tstCH) {
        switch (ch) {
            case org.apache.batik.extension.svg.GlyphIterator.
                   ZERO_WIDTH_SPACE:
                return false;
            case org.apache.batik.extension.svg.GlyphIterator.
                   ZERO_WIDTH_JOINER:
                return false;
            case org.apache.batik.extension.svg.GlyphIterator.
                   SOFT_HYPHEN:
                return true;
            case ' ':
            case '\t':
                return false;
            default:
                return true;
        }
    }
    public int getLineBreaks() { int ret =
                                   0;
                                 if (aciIdx +
                                       charCount >=
                                       lineBreakRunLimit) {
                                     ret =
                                       lineBreakCount;
                                     aci.
                                       setIndex(
                                         aciIdx +
                                           charCount);
                                     lineBreakRunLimit =
                                       aci.
                                         getRunLimit(
                                           FLOW_LINE_BREAK);
                                     aci.
                                       setIndex(
                                         aciIdx);
                                     java.lang.Object o =
                                       aci.
                                       getAttribute(
                                         FLOW_LINE_BREAK);
                                     lineBreakCount =
                                       o ==
                                         null
                                         ? 0
                                         : 1;
                                 }
                                 return ret;
    }
    public void nextChar() { if (ch == SOFT_HYPHEN ||
                                   ch ==
                                   ZERO_WIDTH_SPACE ||
                                   ch ==
                                   ZERO_WIDTH_JOINER) {
                                 gv.
                                   setGlyphVisible(
                                     idx,
                                     false);
                                 float chAdv =
                                   getCharAdvance(
                                     );
                                 adj -=
                                   chAdv;
                                 addLeftShift(
                                   idx,
                                   chAdv);
                             }
                             aciIdx += charCount;
                             ch = aci.setIndex(
                                        aciIdx);
                             idx++;
                             charCount = gv.
                                           getCharacterCount(
                                             idx,
                                             idx);
                             if (idx == numGlyphs)
                                 return;
                             if (aciIdx >=
                                   runLimit) {
                                 updateLineMetrics(
                                   aciIdx);
                                 runLimit =
                                   aci.
                                     getRunLimit(
                                       TEXT_COMPOUND_ID);
                                 font =
                                   (org.apache.batik.gvt.font.GVTFont)
                                     aci.
                                     getAttribute(
                                       GVT_FONT);
                                 if (font ==
                                       null) {
                                     font =
                                       new org.apache.batik.gvt.font.AWTGVTFont(
                                         aci.
                                           getAttributes(
                                             ));
                                 }
                                 fontStart =
                                   aciIdx;
                             }
                             float chAdv =
                               getCharAdvance(
                                 );
                             adj += chAdv;
                             if (isPrinting(
                                   )) { chIdx =
                                          idx;
                                        float chW =
                                          getCharWidth(
                                            );
                                        adv =
                                          adj -
                                            (chAdv -
                                               chW);
                             } }
    protected void addLeftShift(int idx, float chAdv) {
        if (leftShiftIdx ==
              null) {
            leftShiftIdx =
              (new int[1]);
            leftShiftIdx[0] =
              idx;
            leftShiftAmt =
              (new float[1]);
            leftShiftAmt[0] =
              chAdv;
        }
        else {
            int[] newLeftShiftIdx =
              new int[leftShiftIdx.
                        length +
                        1];
            java.lang.System.
              arraycopy(
                leftShiftIdx,
                0,
                newLeftShiftIdx,
                0,
                leftShiftIdx.
                  length);
            newLeftShiftIdx[leftShiftIdx.
                              length] =
              idx;
            leftShiftIdx =
              newLeftShiftIdx;
            float[] newLeftShiftAmt =
              new float[leftShiftAmt.
                          length +
                          1];
            java.lang.System.
              arraycopy(
                leftShiftAmt,
                0,
                newLeftShiftAmt,
                0,
                leftShiftAmt.
                  length);
            newLeftShiftAmt[leftShiftAmt.
                              length] =
              chAdv;
            leftShiftAmt =
              newLeftShiftAmt;
        }
    }
    protected void updateLineMetrics(int end) {
        org.apache.batik.gvt.font.GVTLineMetrics glm =
          font.
          getLineMetrics(
            aci,
            fontStart,
            end,
            frc);
        float ascent =
          glm.
          getAscent(
            );
        float descent =
          glm.
          getDescent(
            );
        float fontSz =
          font.
          getSize(
            );
        if (ascent >
              maxAscent)
            maxAscent =
              ascent;
        if (descent >
              maxDescent)
            maxDescent =
              descent;
        if (fontSz >
              maxFontSize)
            maxFontSize =
              fontSz;
    }
    public org.apache.batik.extension.svg.LineInfo newLine(java.awt.geom.Point2D.Float loc,
                                                           float lineWidth,
                                                           boolean partial,
                                                           java.awt.geom.Point2D.Float verticalAlignOffset) {
        if (ch ==
              SOFT_HYPHEN) {
            gv.
              setGlyphVisible(
                idx,
                true);
        }
        int lsi =
          0;
        int nextLSI;
        if (leftShiftIdx !=
              null)
            nextLSI =
              leftShiftIdx[lsi];
        else
            nextLSI =
              idx +
                1;
        for (int ci =
               lineIdx;
             ci <=
               idx;
             ci++) {
            if (ci ==
                  nextLSI) {
                leftShift +=
                  leftShiftAmt[lsi++];
                if (lsi <
                      leftShiftIdx.
                        length)
                    nextLSI =
                      leftShiftIdx[lsi];
            }
            gv.
              setGlyphPosition(
                ci,
                new java.awt.geom.Point2D.Float(
                  gp[2 *
                       ci] -
                    leftShift,
                  gp[2 *
                       ci +
                       1]));
        }
        leftShiftIdx =
          null;
        leftShiftAmt =
          null;
        float lineInfoChW;
        int hideIdx;
        if (chIdx !=
              0 ||
              isPrinting(
                )) {
            lineInfoChW =
              getCharWidth(
                chIdx);
            hideIdx =
              chIdx +
                1;
        }
        else {
            lineInfoChW =
              0;
            hideIdx =
              0;
        }
        int lineInfoIdx =
          idx +
          1;
        float lineInfoAdv =
          adv;
        float lineInfoAdj =
          adj;
        while (!done(
                  )) {
            adv =
              0;
            adj =
              0;
            if (ch ==
                  ZERO_WIDTH_SPACE ||
                  ch ==
                  ZERO_WIDTH_JOINER)
                gv.
                  setGlyphVisible(
                    idx,
                    false);
            ch =
              0;
            nextChar(
              );
            if (isPrinting(
                  ))
                break;
            lineInfoIdx =
              idx +
                1;
            lineInfoAdj +=
              adj;
        }
        for (int i =
               hideIdx;
             i <
               lineInfoIdx;
             i++) {
            gv.
              setGlyphVisible(
                i,
                false);
        }
        maxAscent =
          -java.lang.Float.
             MAX_VALUE;
        maxDescent =
          -java.lang.Float.
             MAX_VALUE;
        maxFontSize =
          -java.lang.Float.
             MAX_VALUE;
        org.apache.batik.extension.svg.LineInfo ret =
          new org.apache.batik.extension.svg.LineInfo(
          loc,
          aci,
          gv,
          lineIdx,
          lineInfoIdx,
          lineInfoAdj,
          lineInfoAdv,
          lineInfoChW,
          lineWidth,
          partial,
          verticalAlignOffset);
        lineIdx =
          idx;
        return ret;
    }
    public boolean isPrinting() { if (aci.
                                        getAttribute(
                                          PREFORMATTED) ==
                                        java.lang.Boolean.
                                          TRUE)
                                      return true;
                                  return isPrinting(
                                           ch);
    }
    public float getCharAdvance() { return getCharAdvance(
                                             idx);
    }
    public float getCharWidth() { return getCharWidth(
                                           idx);
    }
    protected float getCharAdvance(int gvIdx) {
        return gp[2 *
                    gvIdx +
                    2] -
          gp[2 *
               gvIdx];
    }
    protected float getCharWidth(int gvIdx) {
        java.awt.geom.Rectangle2D lcBound =
          gv.
          getGlyphVisualBounds(
            gvIdx).
          getBounds2D(
            );
        java.awt.geom.Point2D lcLoc =
          gv.
          getGlyphPosition(
            gvIdx);
        return (float)
                 (lcBound.
                    getX(
                      ) +
                    lcBound.
                    getWidth(
                      ) -
                    lcLoc.
                    getX(
                      ));
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVcC3AcxZnuXcmWLFmWZGNjbPyWwS92Y/M4u+wDZFmyZa8e" +
       "JwlBZIf1aHa0Gns1M8z2SrITH5h7YKACBAwmCXGlLibmOF4FpBLIA4cEgguS" +
       "OxuOlyvAwV1CAtTB5QgQjnD/39OzMzu73WKXrKqmdzTdf/f3f/3338+Ze94h" +
       "k9I2ma8ZNEL3WFo60mrQbsVOa4mWlJJO98GzuHqoQvnD5W92rguTyQNk2rCS" +
       "7lCVtNama6lEeoDM0400VQxVS3dqWgIlum0trdmjCtVNY4DM1NPtI1ZKV3Xa" +
       "YSY0TNCv2DHSqFBq64MZqrXzDCiZFwMkUYYk2hyMXh8jU1XT2uMln+1L3uKL" +
       "wZQjXllpShpiu5RRJZqheioa09N0/bhNVlpmak8yZdKINk4ju1Lncwq2xs7P" +
       "o2DxA/V//Pim4QZGwQzFMEzK1Ev3aGkzNaolYqTee9qa0kbSV5C/JRUxUutL" +
       "TElTzC00CoVGoVBXWy8VoK/TjMxIi8nUoW5Oky0VAVGyKDcTS7GVEZ5NN8MM" +
       "OVRTrjsTBm0XZrV1tMxT8daV0YOHLm94sILUD5B63ehFOCqAoFDIABCqjQxq" +
       "dro5kdASA6TRgMru1WxdSel7eU1PT+tJQ6EZqH6XFnyYsTSblelxBfUIutkZ" +
       "lZp2Vr0hZlD8v0lDKSUJus7ydHU0bMPnoGCNDsDsIQXsjotU7taNBCULghJZ" +
       "HZu2QQIQrRrR6LCZLarSUOABme6YSEoxktFeMD0jCUknmWCANiVzhJki15ai" +
       "7laSWhwtMpCu24mCVFMYEShCycxgMpYT1NKcQC356uedzg03fNnYYoRJCDAn" +
       "NDWF+GtBaH5AqEcb0mwN2oEjOHVF7DZl1o8PhAmBxDMDiZ003//Kexevmn/s" +
       "KSfN3AJpugZ3aSqNq0cGp504s2X5ugqEUW2ZaR0rP0dz1sq6ecz6cQs8zKxs" +
       "jhgZcSOP9Tz5xavu1t4Kk5p2Mlk1U5kRsKNG1Ryx9JRmb9YMzVaolmgnUzQj" +
       "0cLi20kV3Md0Q3Oedg0NpTXaTipT7NFkk/0PFA1BFkhRDdzrxpDp3lsKHWb3" +
       "4xYhpAouMhWuJuL8sV9K4tFhc0SLKqpi6IYZ7bZN1D8dBY8zCNwORwfB6ndH" +
       "02bGBhOMmnYyqoAdDGs8AhqNZqRBx2h6NBndnNpjDbdT1Ma0I2hoVvmLGEct" +
       "Z4yFQlABZwabfwpazhYzldDsuHows7H1vfviTzumhc2B80PJKig14pQaYaVG" +
       "sqVGoNRITqkkFGKFnYalOzUN9bQbWjy43KnLe7+0deeBxRVgYtZYJZAchqSL" +
       "c7qeFs8tuL48rt4/vW7voldW/yxMKmNkuqLSjJLCnqTZToKPUnfzZjx1EDol" +
       "r29Y6OsbsFOzTVVLgGsS9RE8l2pzVLPxOSWn+XJwey5so1Fxv1EQPzl2+9j+" +
       "/iu/ECbh3O4Ai5wEngzFu9GJZ511U9ANFMq3/po3/3j/bftMzyHk9C9ut5gn" +
       "iTosDppDkJ64umKh8r34j/c1MdqngMOmCjQw8IXzg2Xk+Jv1ru9GXapB4SHT" +
       "HlFSGOVyXEOHbXPMe8LstJHdnwZmUYsNcDZcu3iLZL8YO8vC8HTHrtHOAlqw" +
       "vuGve61vvfir353L6Ha7kXpf/9+r0fU+14WZTWdOqtEz2z5b0yDdr2/vvuXW" +
       "d67ZzmwWUiwpVGAThi3gshTWCP7hqSteevWVI8+Fs3YeotB3ZwZhCDSeVRKf" +
       "kxqJklDaWR4ecH0p8A1oNU2XGGCf+pCuDKY0bFj/V7909ffevqHBsYMUPHHN" +
       "aNXEGXjPz9hIrnr68g/ms2xCKna9HmdeMsefz/BybrZtZQ/iGN9/ct7Xf6F8" +
       "C3oG8MZpfa/GHGyYt3UENZuSpUwSxxSR7Agv0TIM3KngRVxP4qZelud+kqM0" +
       "MgTGGNnc38ecT7+Gxs1s4nwm9gUWnod8sqIJi1uPwdK0v23lNl/fCCyu3vTc" +
       "u3X97/7kPUZG7hDOb0odirXesV4MzhqH7E8P+r4tSnoY0p13rHNHQ+rYx5Dj" +
       "AOSogkdPd9ngfsdzDI+nnlT18k9/NmvniQoSbiM1KVNJtCmsDZMp0Hi09DB4" +
       "7nHroosd2xmrhqCBqUrylM97gPW3oLBltI5YlNXl3h+c/vCGo4dfYUZssSzm" +
       "5TfQG7nt3li4gWJ4NgYr881eJBqowZDTgFxzKKo3Yii2SUyiC4M2FrUBg80O" +
       "VxeVSCs+aLWciLns4SLseHM6ODZp8nzs3c/+1b8f/dptY86wa7m4YwnIzf5T" +
       "V2rw6tc/zDNP1qUUGBIG5Aei99wxp+XCt5i859tRumk8f7AA/aMnu+bukffD" +
       "iyc/ESZVA6RB5ZOUfiWVQY85AAPztDtzgYlMTnzuINsZUa7P9l1nBvsVX7HB" +
       "XsUbpMA9psb7ukBHgiZKNsF1Fje2pUE7DRF2s90xVRauwOAcVn0VeBsB551m" +
       "UyEKEHRDSQWc+OluxgUKoGRqd09rW1dPR3NfX+sm14yjn8kHNmXjvObE7HTH" +
       "RHZ6SS4Fm+FazhEuE1CQlFGAQRyDnQV0XybIGTxlW6zr0nisvbM1vrGntXkb" +
       "PlYDugwXqcsWuFbxElcKdDFL1mWlIGdKGvpaL+uLt3R1dHdd0rkp3r6pkDLW" +
       "Z1cGYwgmi/IiIwJlxkpW5hye8zl5ylRD3xlv6+rsK6TEeJE1shau1byo1XlK" +
       "hLLjKmzzkXaYtCc1e/rr3z7ywf5r1oZxqDBpFH0DuJ0GL11nBhcb/vGeW+fV" +
       "HnztetYLQc73YqZXlkyICCUltb1dbX3xLV/s3tLamTspwYF/b2YwDRMIfQTG" +
       "i6N8Ur2me6d6oKn7Px3PfUYBASfdzLuiX+1/YdczbDRajVOUPtdb+SYgMJXx" +
       "DYUbHOifwl8Irj/jhZDxAf6CG23hM+SF2SmyZeHoQ9KFBBSI7pv+6u473rzX" +
       "USDYXwQSawcOXvdp5IaDzhDTWWdZkrfU4Zdx1locdTC4HtEtkpXCJNp+e/++" +
       "H9617xoH1fTcVYNWIzNy7/OfPBO5/bXjBaaqleown8f5Rw4wS8itHEejTdfW" +
       "/+im6RVtMLtpJ9UZQ78io7UncjuWqnRm0Fdb3gKO19lw3bBmKAmtgEoItKar" +
       "SmhNa7idrinQmvBmPyELa/HmmyU3BVER4OgGWnu64pe2b+rbEu/tbm5pxefX" +
       "BbS6owStzuVFnivRqg5vjpSslagIShp9Wm3tgh6pp5Bad352tViZc+G6gJd5" +
       "QZ5ajv++t7A2JAC/UpIVJRV6wkl/gLcl/Pmq7/5rmIYvFfusH/89FDTJ+0rQ" +
       "ci2Htlag5aPeYP+BfMVE0jCiUofbEwzgQwGUPywB5TpezjoByp9KUYqkKali" +
       "S4uFcT5eAs4NvKQNApxPSXGKpGGgqqi6AObxEmBeyAu6UADzX6UwRdIUJhzg" +
       "qFvMjEELIf23EpA287KaBUiflyIVSUObUhKjE7U7mJeYymdreS+UoFoLB9ci" +
       "UO11qWoiaabaLrw9FcD4RgkYW3kprQKMv5NiFEnDONXOGDEcIhSyk98XCXQx" +
       "cWYPxP0tAPRdKVCRNHQv6CA22pqyu0eC+L0SELfzMtsFiD+QIhZJUzIti1jY" +
       "ED8sEu58uGK8wJgA7p+lcEXSMLbDJT8mANPnRdJFwTbTUcenyacl2HQHx9JR" +
       "WJNQlVQTkTQ4P8TZSxW7EOeh6hKQdvKyOgVIp0mRiqQB6Ygy3pxWNYfOgJ8I" +
       "1ZeAtIuX1SVAOlOKVCRNSQ0g3aQJoc4qEuqZcHXzwroFUM+UQhVJw0wToKKF" +
       "9up7tUJY5xWJFW96eGk9AqxLpFhF0tCzjekJZ6s0iLKpSJQY1cfL6ROgXCFF" +
       "KZKmJKwyiIGxfGhlkRBnwdXPC+kXQFwthSiShpYEE1e2NJ0u1ObXFIkUN6gv" +
       "42VdJkC6VopUJI2jAlXH2wsCGNeVwOYAL2VAgPEiKUaRNFR4chTv1gYgXlyC" +
       "Te7ghewQQGyTQhRJI0Qr91hVdlWI7ZY5SxA7ap98LP2d3zzorHUUWnMKHOS4" +
       "62i1emrkSbbmhAVdm4U0BxEsgOtsDon9UnLp5zxhAGIjuPdn2s1wx7YY3MML" +
       "5coa14mWilexfPwd/u6SX115eMl/sB21aj3dr9jNdrLAIRqfzLv3vPrWybp5" +
       "97FN7UpcjkMK64Knj/IPF+WcGWLs16OBdLLbU8HRv2NvTgJuSo715a0DhPGW" +
       "rWrsZFldD7O4lGYkHb/7MEr2Wt5mU2AzdYa3YtqSMg0Nd3TdOOcQhm5Gsqe0" +
       "IHI8D6lN5uXsUHUwPb3tnl9Pu/mNR5qSG4s5fYHP5k9wvgL/XwCVtUJc10Eo" +
       "v7j693P6LhzeWcRBigUBUwhm+c8d9xzffJZ6c5gdBHP2ofIOkOUKrc9dJKyx" +
       "NZqxjdxlwSVZ2wj1ei5kJatg9n/BDcnQkCQO7QF35SepWNGOXUiS78576u5P" +
       "kqAJ4L/BqWpowr3QgDdFD3Q5dz6XC7ypJfWmImnolIZs1bVqZ+NaGePjfRxK" +
       "9WhGQrP5QcWAGlcUqcYiuBQORBGosUeqhkiakqkpbYj2DutDtN1ZzQtty4pP" +
       "w9SNxNkSIu4vJds//xGxKJAVTWrmSLRbocMx5ltcJ17O7B0V/waDK50lKbGX" +
       "vNLl9u8/o5fEtJdlPeTV+R4SHw9gsCPf5eHjeBZX6GoMEpK2JGuyuBgUuhYD" +
       "3UEiSXvj52yTe0swZpXbkyow5oNSYxZJ+425eQQbXagjAPbWEkaMGi9OE4D9" +
       "phSsSBrG31mwzA4DSIvYzMi6uiQvKylA+k9SpCJp6PuToxuhI3W93cyst8MW" +
       "Fuk2YVyyZlMA/3ck+Md9vU8WB/ubTAJHXn04WMq57j4FjBBEp5LZnt2Rqw8e" +
       "TnTdudodlt4MhFPTOieljWopX1ZnOA0vC+MMzB4XjW7hMG4JkukpKjpGJBKV" +
       "tMLvS+IeweBB7GRNa89qTBHzeH7oL3E8SMTBIa7IoeI5EIkG9PR5lhhT9ucS" +
       "Ip7E4DEBEcfKQEQ9xuHCy6Ncm0eLJ0IkKtHzhCTuWQyeoaQuqVHnYBmMM3w9" +
       "GePil2XggonjfuZjXKHHiudCJCrR9xVJ3GsYvERJFXCBB5UwzXUeCy+XyyLQ" +
       "1z7BVXmieBZEohJN35LEvYPBbyipBRaaW9oL2cNvy8BEo2sPT3N1ni6eCZGo" +
       "RNsPJXF/wuAP2F8BEwm2HnPKI+F/y0DCDIxDB3GCa3KieBJEomJFw5MkcVUY" +
       "wCB9CpDQZetJHc+Sh45meQiHymkML3JlXiyeB5GoRNfpkrjTMKhzjWFXrjGE" +
       "p5WLBFzveplr8nLxJIhEJYoukMQtwmAOJdOAhI7AGr9HxtxykTEPrje4Rm8U" +
       "T4ZIVKLwKkkcTtXCZ8MswSHDt4vkUbGsXFTgcOptrs/bxVMhEpWou04Sh+8d" +
       "hM9zRhEdudtUHhfnl8tholm8zxV6v3guRKISfdskcVswaKZ4RDympNlAgqWT" +
       "nK6oGjTNlKYYhYaxh8Y9BjeWi0F0tR9xGj4qnkGRqISlyyRxuKQR7qWkMuEs" +
       "Aoa3ehT0lYsCbFCfcD0+KZ4CkahETU0Sl8RgJwzC9LRzfsEZjvqZUMrABK5P" +
       "kIVgeVVOns6vgAkW+tavQjBIsGyTairVEoGTf3WSPAM0+Gz/OsYFlfCEg7Lw" +
       "CGts3bZuUN1IBmgyyjiPCzVylRqLNhihqETZ/ZK4v8PgK44HjrmnXlhKb9we" +
       "3lcGLth7UjCDCfFdOee3OC5EohJ9b5DE3YTBtZRUG9q4538DPrdy1NQTHjXX" +
       "lYEatt59Pui1jeu3TU5N2MpvNCLRgPregrCz8neKEXFYQtK3Mfg6jF6URCLm" +
       "WzkM3+yR8o1ykXIOaMS3QkJ5GykTkyISFXuSh5jO/yLhA1+7CH+XksaMlVCo" +
       "hm2oQ6O2zjZl/KQcLQMpbMFyLmDVuWZ68Y1IJBrQuZIBqWT/z6ZkbsHF16Y2" +
       "PO7JDIm5UwweYTT9QELhjzB4CIYzhjaG/LllnD3BC43sMwfGkOlx/HAZh4qh" +
       "BzhRDxTPsUhUQspxSdzTGPxc1ns9UcZ5ZegRrs0jxRMhEpUo+7wk7kUMTjjz" +
       "SnTYzYlRd4vdN4E4WcZ5ZehxrtHjxZMhEpUo/IYk7r8weMWZVyIZl2YPqHlU" +
       "vFouJ7QY9DjO9Tkup6KQZxaJTuSZ35Xw8T8YvDWRcbxdLkYWAtCTXK2TxTMi" +
       "Ep2IkU8kjHyKwYdyC/noL/KeNwwoc143xxNfs/M+suR8GEi973B99emHL3nB" +
       "OXfkfrxnaoxUD2VSKf/LzL77yZatDemMyKnOq83s9bKKKkrmy/sNSiogROgV" +
       "kx2ZGkrmiGVgepK990vVUdIQlKJkEvv1p2sAR+2lwxdR2I0/yQzABEnw9jTL" +
       "7f58b3w6b4OPO4cC5vrJZ0e4Z05UZ77tyiU5R4rY57Hc4z8Z5wNZcfX+w1s7" +
       "v/zeBXc6XwlRU8revZhLbYxUOR8sYZniEaJFwtzcvCZvWf7xtAemLHU3QBsd" +
       "wF4DmOsZKL7lELLQVuYEPqGRbsp+SeOlIxt+8ssDk0+GSWg7CSmUzNie/978" +
       "uJWxybztsfy3G/sVm33bY/3yb+y5cNXQf59y358N5X6PIJg+rj539EvP3jz7" +
       "yPwwqW0nk3Tc32Av9G/aY/Ro6qg9QOr0dOs4QIRcdCWV8+rkNDRrBT+cxXjh" +
       "dNZln+I3ZihZnP/aaP6XeWpS5phmbzQzRgKzqYuRWu+JUzOBU1gZywoIeE94" +
       "VWJ4GwbXj2NtgD3GYx2W5b5VW3OGxZr2oUKOh53FqGC93CG8W/b/B3MayDpP" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ZgpT2PT88YBaI7TRwZ32kJ4NiTYu93Rm");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "xb9787957o/y49X+H0gmX/dXXQAA");
}
