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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVcC3AcxZnuXcmWLFmWZGNjbPyWwS+0sXmcffYBsizZsleP" +
       "SEIQ2WE9mh2txl7NDLO90tqJj0fuDgMVIGAwSYgrdTEx4XgVkEogDxwSCC5I" +
       "7mw4Xq4AB3cJCVAHlyNAOML9f0/Pzuzsdotdsqqa3tF0/93f//Xffz9n7n6b" +
       "TErZZL5m0Ga6x9JSzW0G7VHslBZvTSqpVD88i6kHK5Q/XvpG17owmTxIpo0o" +
       "qU5VSWntupaMpwbJPN1IUcVQtVSXpsVRosfWUpo9plDdNAbJTD3VMWoldVWn" +
       "nWZcwwQDih0ljQqltj6UploHz4CSeVFAEmFIIi3B6PVRMlU1rT1e8tm+5K2+" +
       "GEw56pWVoqQhuksZUyJpqicjUT1F12dsstIyk3sSSZM2axnavCt5Lqdga/Tc" +
       "PAoW31//p49uHGlgFMxQDMOkTL1Ur5Yyk2NaPErqvadtSW00dRn5e1IRJbW+" +
       "xJQ0Rd1CI1BoBAp1tfVSAfo6zUiPtppMHermNNlSERAli3IzsRRbGeXZ9DDM" +
       "kEM15bozYdB2YVZbR8s8FW9ZGTlw8NKGBypI/SCp140+hKMCCAqFDAKh2uiQ" +
       "Zqda4nEtPkgaDajsPs3WlaS+l9f09JSeMBSahup3acGHaUuzWZkeV1CPoJud" +
       "VqlpZ9UbZgbF/5s0nFQSoOssT1dHw3Z8DgrW6ADMHlbA7rhI5W7diFOyICiR" +
       "1bFpGyQA0apRjY6Y2aIqDQUekOmOiSQVIxHpA9MzEpB0kgkGaFMyR5gpcm0p" +
       "6m4locXQIgPpepwoSDWFEYEilMwMJmM5QS3NCdSSr37e7tpw/ZeMLUaYhABz" +
       "XFOTiL8WhOYHhHq1Yc3WoB04glNXRG9VZv1kf5gQSDwzkNhJ84Mvv3vhqvlH" +
       "n3TSzC2Qpntol6bSmHp4aNrx01uXr6tAGNWWmdKx8nM0Z62sh8esz1jgYWZl" +
       "c8TIZjfyaO8TX7jiLu3NMKnpIJNVM5keBTtqVM1RS09q9mbN0GyFavEOMkUz" +
       "4q0svoNUwX1UNzTnaffwcEqjHaQyyR5NNtn/QNEwZIEU1cC9bgyb7r2l0BF2" +
       "n7EIIVVwkalwNRHnj/1SEouMmKNaRFEVQzfMSI9tov6pCHicIeB2JDIEVr87" +
       "kjLTNphgxLQTEQXsYETjEdBoNCMFOkZSY4nI5uQea6SDojam3YyGZpW/iAxq" +
       "OWM8FIIKOD3Y/JPQcraYybhmx9QD6Y1t794be8oxLWwOnB9KVkGpzU6pzazU" +
       "5mypzVBqc06pJBRihZ2CpTs1DfW0G1o8uNypy/u+uHXn/sUVYGLWeCWQHIak" +
       "i3O6nlbPLbi+PKbeN71u76KXV/88TCqjZLqi0rSSxJ6kxU6Aj1J382Y8dQg6" +
       "Ja9vWOjrG7BTs01Vi4NrEvURPJdqc0yz8Tklp/hycHsubKMRcb9RED85etv4" +
       "lQOXfy5MwrndARY5CTwZivegE88666agGyiUb/3Vb/zpvlv3mZ5DyOlf3G4x" +
       "TxJ1WBw0hyA9MXXFQuX7sZ/sa2K0TwGHTRVoYOAL5wfLyPE3613fjbpUg8LD" +
       "pj2qJDHK5biGjtjmuPeE2Wkjuz8FzKIWG+BsuHbxFsl+MXaWheGpjl2jnQW0" +
       "YH3D3/VZ33rh178/m9HtdiP1vv6/T6Prfa4LM5vOnFSjZ7b9tqZBut/c1nPz" +
       "LW9fvZ3ZLKRYUqjAJgxbwWUprBH845OXvfjKy4efDWftPESh704PwRAok1US" +
       "n5MaiZJQ2hkeHnB9SfANaDVNFxlgn/qwrgwlNWxY/1e/dPX337q+wbGDJDxx" +
       "zWjVxBl4z0/bSK546tL357NsQip2vR5nXjLHn8/wcm6xbWUP4shceWLe13+p" +
       "fAt6BvDGKX2vxhxsmLd1BDWbkqVMEscUzdkRXrx1BLhTwYu4nsRNvSzP/STG" +
       "aPMwGGPz5oF+5nwGNDRuZhPnMrHPsfAc5JMVTVjcegyWpvxtK7f5+kZgMfXG" +
       "Z9+pG3jnp+8yMnKHcH5T6lSs9Y71YnBGBrI/Nej7tiipEUh3ztGuHQ3Jox9B" +
       "joOQowoePdVtg/vN5BgeTz2p6qWf/XzWzuMVJNxOapKmEm9XWBsmU6DxaKkR" +
       "8NwZ64ILHdsZr4aggalK8pTPe4D1t6CwZbSNWpTV5d4fnvrQhiOHXmZGbLEs" +
       "5uU30Bu47d5QuIFieCYGK/PNXiQaqMGQ04BccyiqN2IotklMohuDdha1AYPN" +
       "DlcXlEgrPmiznIi57OEi7HhzOjg2afJ87F3P/M2/H/narePOsGu5uGMJyM3+" +
       "c3dy6KrXPsgzT9alFBgSBuQHI3ffPqf1/DeZvOfbUbopkz9YgP7Rk11z1+h7" +
       "4cWTHw+TqkHSoPJJyoCSTKPHHISBecqducBEJic+d5DtjCjXZ/uu04P9iq/Y" +
       "YK/iDVLgHlPjfV2gI0ETJZvgOoMb29KgnYYIu9numCoLV2BwFqu+CrxtBued" +
       "YlMhChB0Q0kGnPipbsYFCqBkak9vW3t3b2dLf3/bJteMI5/KBzZl47zmxOx0" +
       "x0R2elEuBZvhWs4RLhNQkJBRgEEMg50FdF8myBk8ZXu0++JYtKOrLbaxt61l" +
       "Gz5WA7qMFKnLFrhW8RJXCnQxS9ZlpSBnShr62y7pj7V2d/Z0X9S1KdaxqZAy" +
       "1qdXBmMIJovwIpsFyoyXrMxZPOez8pSphr4z1t7d1V9IiUyRNbIWrtW8qNV5" +
       "SoSy4yps880dMGlPaPb01759+P0rr14bxqHCpDH0DeB2Grx0XWlcbPinu2+Z" +
       "V3vg1etYLwQ534OZXl4yISKUlNT2dbf3x7Z8oWdLW1fupAQH/n3poRRMIPRR" +
       "GC+O8Un1mp6d6v6mnv90PPdpBQScdDPvjHx14PldT7PRaDVOUfpdb+WbgMBU" +
       "xjcUbnCgfwJ/Ibj+ghdCxgf4C260lc+QF2anyJaFow9JFxJQILJv+iu7b3/j" +
       "HkeBYH8RSKztP3DtJ83XH3CGmM46y5K8pQ6/jLPW4qiDwXWIbpGsFCbR/rv7" +
       "9v3ozn1XO6im564atBnp0Xue+/jp5ttePVZgqlqpjvB5nH/kALOE3MpxNNp0" +
       "Tf2Pb5xe0Q6zmw5SnTb0y9JaRzy3Y6lKpYd8teUt4HidDdcNa4aS0AqohEBr" +
       "uqKE1rSG2+maAq0Jb64kZGEt3nyz5KYgKgIc3WBbb3fs4o5N/VtifT0trW34" +
       "/NqAVreXoNXZvMizJVrV4c3hkrUSFUFJo0+rrd3QI/UWUuuOT68WK3MuXOfx" +
       "Ms/LU8vx3/cU1oYE4FdKsqKkQo876ffztoQ/X/Xdfw3T8KVin/XjvweDJnlv" +
       "CVqu5dDWCrR8xBvs35+vmEgaRlTqSEecAXwwgPJHJaBcx8tZJ0D5MylKkTQl" +
       "VWxpsTDOx0rAuYGXtEGA80kpTpE0DFQVVRfAPFYCzPN5QecLYP6rFKZImsKE" +
       "Axx1q5k2aCGk/1YC0hZeVosA6XNSpCJpaFNKfGyidgfzElP5dC3v+RJUa+Xg" +
       "WgWqvSZVTSTNVNuFtycDGF8vAWMbL6VNgPH3UowiaRin2mkjikOEQnbyhyKB" +
       "LibO7IG4vwWAviMFKpKG7gUdxEZbU3b3ShC/WwLiDl5mhwDx+1LEImlKpmUR" +
       "CxviB0XCnQ9XlBcYFcD9ixSuSBrGdrjkxwRg+rxIuijYbjrq+DT5pASb7uRY" +
       "OgtrEqqSaiKSBueHOPuoYhfiPFRdAtIuXlaXAOk0KVKRNCAdVTItKVVz6Az4" +
       "iVB9CUi7eVndAqQzpUhF0pTUANJNmhDqrCKhng5XDy+sRwD1dClUkTTMNAEq" +
       "WmifvlcrhHVekVjxppeX1ivAukSKVSQNPdu4Hne2SoMom4pEiVH9vJx+AcoV" +
       "UpQiaUrCKoMYGMuHVhYJcRZcA7yQAQHE1VKIImloSTBxZUvTqUJtfk2RSHGD" +
       "+hJe1iUCpGulSEXSOCpQdbw9L4BxXQlsDvJSBgUYL5BiFElDhSfG8G5tAOKF" +
       "JdjkDl7IDgHEdilEkTRCtHKPVWVXhdhumbMEsaP2iUdT3/ntA85aR6E1p8BB" +
       "jjuPVKsnR59ga05Y0DVZSHMQwQK4zuSQ2C8lF3/GEwYgNop7f6bdAndsi8E9" +
       "vFCurHGdaKl4FcvH36HvLvn15YeW/AfbUavWUwOK3WInChyi8cm8c/crb56o" +
       "m3cv29SuxOU4pLAuePoo/3BRzpkhxn49GkgXuz0ZHP079uYk4KbkWF/eOkAY" +
       "b9mqxk6W1XUwi0tqRsLxuw+hZJ/lbTYFNlNneCumrUnT0HBH141zDmHoZnP2" +
       "lBZEZvKQ2mRezg5VJ9PT2+75zbSbXn+4KbGxmNMX+Gz+BOcr8P8FUFkrxHUd" +
       "hPLLq/4wp//8kZ1FHKRYEDCFYJbf67z72OYz1JvC7CCYsw+Vd4AsV2h97iJh" +
       "ja3RtG3kLgsuydpGqM9zIStZBbP/C25IhoYlcWgPuCs/ScWKduxCknx33lN3" +
       "f5IETQD/DU5VQxPuhQa8KXqgS7nzuVTgTS2pNxVJQ6c0bKuuVTsb18o4H+/j" +
       "UKpXM+KazQ8qBtS4rEg1FsGlcCCKQI09UjVE0pRMTWrDtG9EH6YdzmpeaFtW" +
       "fBqmbiTOlhBxfynZ/tmPiEWArEhCM0cjPQodiTLf4jrxcmbvqPh5DC53lqTE" +
       "XvJyl9t/+JReEtNekvWQV+V7SHw8iMGOfJeHj2NZXKGrMIhL2pKsyeJiUOga" +
       "DHQHiSTtDZ+xTe4twZhVbk+qwJgPSI1ZJO035pZRbHShzgDYW0oYMWq8OE0A" +
       "9ptSsCJpGH9nwTI7DCAtYjMj6+oSvKyEAOk/S5GKpKHvT4xthI7U9XYzs94O" +
       "W1hzjwnjkjWbAvi/I8Gf8fU+WRzsbzIJHHn14WAp57r7FDBCEJ1KZnt2h686" +
       "cCjefcdqd1h6ExBOTeuspDamJX1ZneY0vCyM0zB7XDS6mcO4OUimp6joGJFI" +
       "VNIKfyCJexiDB7CTNa09qzFF1OP5wb/G8SARBwe5IgeL50AkGtDT51miTNlf" +
       "SIh4AoNHBUQcLQMR9RiHCy+PcG0eKZ4IkahEz+OSuGcweJqSuoRGnYNlMM7w" +
       "9WSMi1+VgQsmjvuZj3KFHi2eC5GoRN+XJXGvYvAiJVXABR5UwjTXeiy8VC6L" +
       "QF/7OFfl8eJZEIlKNH1TEvc2Br+lpBZYaGntKGQPvysDE42uPTzF1XmqeCZE" +
       "ohJtP5DE/RmDP2J/BUzE2XrMSY+E/y0DCTMwDh3Eca7J8eJJEImKFQ1PksRV" +
       "YQCD9ClAQretJ3Q8Sx46kuUhHCqnMbzAlXmheB5EohJdp0viTsGgzjWGXbnG" +
       "EJ5WLhJwveslrslLxZMgEpUoukAStwiDOZRMAxI6A2v8Hhlzy0XGPLhe5xq9" +
       "XjwZIlGJwqskcThVC58JswSHDN8ukkfFsnJRgcOpt7g+bxVPhUhUou46SRy+" +
       "dxA+xxlFdOZuU3lcnFsuh4lm8R5X6L3iuRCJSvRtl8RtwaCF4hHxqJJiAwmW" +
       "TnK6omrINJOaYhQaxh7MeAxuLBeD6Go/5DR8WDyDIlEJS5dI4nBJI9xHSWXc" +
       "WQQMb/Uo6C8XBdigPuZ6fFw8BSJRiZqaJC6BwU4YhOkp5/yCMxz1M6GUgQlc" +
       "nyALwfKqnDydXwETLPStX4VgkGDZJtVUqsUDJ//qJHkGaPDZ/rWMCyrhCQdl" +
       "4VHW2Hps3aC6kQjQZJRxHhdq5Co1Fm0wQlGJsldK4r6CwZcdDxx1T72wlN64" +
       "PbyvDFyw96RgBhPiu3LOb3FciEQl+l4vibsRg2soqTa0jOd/Az63cszU4x41" +
       "15aBGrbefS7otY3rt01OTdjKbzQi0YD63oKws/J3khFxSELStzH4OoxelHg8" +
       "6ls5DN/kkfKNcpFyFmjEt0JCeRspE5MiEhV7kgeZzv8i4QNfuwh/l5LGtBVX" +
       "qIZtqFOjts42ZfykHCkDKWzBci5g1blmevGNSCQa0LmSAalk/8+mZG7Bxdem" +
       "djzuyQyJuVMMHmY0/VBC4Y8xeBCGM4Y2jvy5ZZw5wQuN7DMHxrDpcfxQGYeK" +
       "ofs5UfcXz7FIVELKMUncUxj8QtZ7PV7GeWXoYa7Nw8UTIRKVKPucJO4FDI47" +
       "80p02C3xMXeL3TeBOFHGeWXoMa7RY8WTIRKVKPy6JO6/MHjZmVciGRdnD6h5" +
       "VLxSLie0GPQ4xvU5JqeikGcWiU7kmd+R8PE/GLw5kXG8VS5GFgLQE1ytE8Uz" +
       "IhKdiJGPJYx8gsEHcgv58K/ynjcMKHNeN8cTX7PzPrLkfBhIvfdQffWphy56" +
       "3jl35H68Z2qUVA+nk0n/y8y++8mWrQ3rjMipzqvN7PWyiipK5sv7DUoqIETo" +
       "FZMdmRpK5ohlYHqSvfdL1VHSEJSiZBL79adrAEftpcMXUdiNP8kMwARJ8PYU" +
       "y+3+fG98Om+DZ5xDAXP95LMj3DMnqjPfduWSnCNF7PNY7vGftPOBrJh636Gt" +
       "XV9697w7nK+EqEll717MpTZKqpwPlrBM8QjRImFubl6Ttyz/aNr9U5a6G6CN" +
       "DmCvAcz1DBTfcghZaCtzAp/QSDVlv6Tx4uENP/3V/sknwiS0nYQUSmZsz39v" +
       "PmOlbTJvezT/7cYBxWbf9li//Bt7zl81/N8n3fdnQ7nfIwimj6nPHvniMzfN" +
       "Pjw/TGo7yCQd9zfYC/2b9hi9mjpmD5I6PdWWAYiQi64kc16dnIZmreCHsxgv" +
       "nM667FP8xgwli/NfG83/Mk9N0hzX7I1m2ohjNnVRUus9cWomcAorbVkBAe8J" +
       "r0oMb8XgugzWBthjLNppWe5btTV/a7GmfbCQ42FnMSpYL3cQ75b9Pw5LSIQ6" +
       "TwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "WxKj9uoia3JUdeSvbGVoexV3PrPnfWLg");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("qWtr3UV7ttpvdMjaciW1ljZQ46BLNsyRnhKyOqqqVd7CIGnVs3EHdq0VnhbL" +
       "PaLjgn53R0MsXdpoKVP35thBtUlbw5t2yic8GpJ6OJunq6FZDNNOYs8m6ixc" +
       "FHEBDlq82kiGk74Zh8RiwSt2F9hWg+pziT+xpjbXHuqtuJOMHWXc6s9LXbE7" +
       "ZLGWLgqduCuKm3prU7NFtImN7IYhAj9nMdgEI6tdCoRRi6VZ18IXIda1PBMe" +
       "4+tiNFzhZR1zRnNBYNgWsZBce7p0tNCiRGMuztIgMMZle9lK5nxX5Acspyc1" +
       "yjMqvM/4bi0gbJFqLum02NJ8cRQMbGUESveZCckklGhNaG0oa60GmEQMKKIs" +
       "djugbXxeQFN5tBQWIzqezitDniLxokUbZXuEBWQCJlBjvo8FA11dNXs1NB0P" +
       "nAhf0jxqjiY9GLXbhINb/JRESDhu9bttWp/NcafRwU2K0G2HmAtDLKa6nCiJ" +
       "Y0u3ElcFroPCVeyRLlQhL24hsDKsE+UAQdHZLOHEbuQN4aaplOBJCRdlnmIG" +
       "q0G3tkn4QQVDnHYVAlPOicn6QWNaV/WWp0c2QjSXbSwJKVJXuk6trS2pap1a" +
       "9pZeGZ4YEtQC45+ylEarfrcqdTzMWtuI5iIapIUqXPfdqrasNPkk7Y9qQa+V" +
       "GJzvQ1V0uAnmVurVmuTcHCebkkxxpUYzmcxrXXUutSGjP29N1Ka7SOd1qTwe" +
       "rexSvBhGvTRZFS2ZhhxVmLRZh/UMLHHDkSeUKJQq18ob3KV82eMqYF5PyMvu" +
       "oOIOjY0Ji3STEyrFBrxReXXsFUE1ZOqyzLhIbopoXwsRDgHmZB6m1Ei3uF5v" +
       "AdVWAQQhc7ncpoBfSeBYe0Kr03pj06j0J5syvcQaGDaJVkVRr7UisWI1GzZt" +
       "zZTqMCar854ZJWs9IBdMc9PhYxlVOQirwB3LnziaZHIJFkG8JnX1JMXmXlqt" +
       "Omx1CncIYYBD+AgWBymXWAMF6Y4XJt/wNokomAJfCdhUpAd1raR2E/AoUsuI" +
       "X6OAAR91gzFT7CqbAbJAY74WEma5HZGOhmHdQafUHM1EohQMGUEK8ZhsElR9" +
       "om/cwFDasTRFF65qC33HQtPp2pOh2OVsQmqFhIUxJW3GDXzdFnrT2ixMNVdd" +
       "LjgLxjG46iwEYryk104zhor00CBi1pgvpYFYFBs8tUJshuxPaYOaVVh53CVD" +
       "pmP1KkE3Whu0PeqDOT41oGxeiHG5mApGLV7JlqjOi4sVbXJ8pyzT/VIVDuSh" +
       "SvHWxsQnUsmfMNIC6ROlVjOI+QjYQ5Jqeiuh08CxVjyZMbN60eeX3TUBbAbE" +
       "wyQwY9RSqKWx1WmMmuPJJmrW+lLZ2sxW3mw+k1Rg7KAOQk6R6agoDTeRuunQ" +
       "FOWVa1IrgBtho42jGEGXu7IXV6w6UtewmTHV9IVetupEivYFI4kCXHHpcVn2" +
       "jElpia2Z0gZtjHG+7mr9Wn9kAxdh5pN0uyOyne50jdFGauNoAxNYBUywN+12" +
       "uc/BKxUiEb41RFcG3DGNHlxqzckYGMqyawusM+U7Vq3lsxQ6Gmi9ATNsDm0K" +
       "Wxc5jSwZXbnWmSsWsSn2+YTUVga94BN/SHoT1mGYxqop8YxdLormIHJny0Se" +
       "Vbttyq4YGEz6Q7Y4psfkcrJs2bQ4bqFDeLSaCWPDXiMiVu8N2lCj3546iEHL" +
       "RMfpslRZIJZaBQ2LToDKE4X04i454JbrCCdqlYQTNu3y2F0YmEz4Fh1zME5A" +
       "QxfnKjSEjjZEBXh2/KRIQOsSjgnMCreqhKY0aFA+DQaUbntQ5ubRUJwMMLyJ" +
       "Oa1BaMR0dYDwaa0+T0YWhS08Rt20nLFrGSic1aEHpaUtRKS5mUnkWPVIgoal" +
       "nkWvlkbkhJHTS2XGJIKRn8xbfLyy8b48ZFppp96qLBHKcjbr0pjkepYBp4vm" +
       "eLaSOw5JrxbRXBMsEYMROlrxFM4iyXw+bUcePTS1fhA3zKKaipw1skDBtTo/" +
       "XBf1tFVMU6et92UwY3E0rx0lVs1xkSE8rveqdjLEaH45jB1kGK8UrF2zqHRB" +
       "03Zr5UqC1wXGMuywdF+ZAMVPrQZjtNKkhxp4nfQhGB8iEr7GOw5B87DeqXko" +
       "3WmmFC+NNWkwYFRo5NcxZIzqNjAucn3aXiEoTw9teaHQWB1djWoTqz8PYGiN" +
       "MemmzNTJkTkAGNet3mraXXj4Wh+vCKHH8fG4JppzEpfpWBwtohFOQ9CCpuZg" +
       "3onLUCgx2Dq0sIHu1ERKqlBBVFWw+nwwG8j0MKUsfQFjfrntllYD0I6Ro3dr" +
       "YTbBA24x8G2ERgVMqOs1Tl0v8fZ61awPTdTi7KTa66vVtmYTA6fo1Ja2Gg3N" +
       "SuQvBKU06+tQa1OvatFmVEtr5TKsoGSoGlO+4ceTahiXyn1Bn3XVzcAuTfB6" +
       "1e+uIoiuzq12yhM9Pt5Qtb6fGg5lInUngnEWAl3ZZbWgvW67MyIu0ZgxjAIC" +
       "ZmzCEhtz05A3S8SuDdhpsrIgB+6RMSqOFx05XrT7sziqVeTpek5hc7wrbVDN" +
       "hs2y6rjGkmR5bKCUei7fUpw5hBTBDLaBprrh6rNNsh6s6URkGMqdlCARxWoT" +
       "JDVQjGRqk8psuYZleQWvBgnbwBkqDfFAm6YDcmJ0/WkEj6baeNMANoTodZmR" +
       "p4FJBDKI5QYnNkhDGvsTpcGukJHQGQJPiUs0ul9r451aAykFpQpWTZmx0asK" +
       "BtpvU3l6RmkMJ4i0S7+u0/06xFAz2RU1mxzqHl63YLGX8j3bKJHcoJYuRzC9" +
       "MOw5qUn2qDF39eIQ4QiI7K3g+ZhERGBs22ZvQJTXMYGMNh2rq9s0ydGTFDEj" +
       "gtLMJYx0obU305guxRosognjBrfhwt58ilqd5VQfTKdSYK3henXmVGGqjsiV" +
       "xUhsFb15yYPWyLpYRFwpHFTDGWMHm8WSbXDS2raDLhwtG/jIX4DR02/LjO4O" +
       "wTPfcibUggfl9soixQOtsWW012gqetgipnGgMeORbrMcMmdWrSGNcJPRulgt" +
       "Tskm0neLuAyneGvMNeEeM6vijLeYcVM9kXgPY9sNjp00luQ05vpoSFv1ap2M" +
       "x2Kz3mysGl63SCwIx2mUG0wgyN1FsOKcEGWQwWzYcduJ6tSFeL2BFDZsjmCl" +
       "TtYxFnexZUvblHFUmGqmJStYvGkF0IDHRWdZF9JaQrAcVBWhaO6tbL7kTQYj" +
       "3pWjTbW55Nw+8IXopbERoIY2QVNJnTYdG4LQuLFxkDLEIl51qnuDhjftrGx3" +
       "Vvc4aunZzGbKcrMVJJB+Yw2UubmZTjCoojYtu+nOAheHO3VOl6TWxB7YYL6m" +
       "leu615Hd0MCoKDWXHlOvN9ockporUBsLnNQqxMybbMnajBudslvxrRnricNR" +
       "EjU1yXe1lh+q4hxtGQgdlnxGRcZmYm4kNLZmPTYIJANWY0GElAbpTlVsUKu0" +
       "PYYPJr2qNmjAapNbwT2+M6gLq1YrWyL73mtbInsgX/I7PMVh5uQr2+++hlWw" +
       "9Ni3IodrpfnfbYUTO/+PrZXmKR862PkZFh457XCGfJfN8+969jm9/4Pl/d0i" +
       "6jviwp2xH7zJMZaGc6yoV24X4A9hvDIrPvvk9wM7GB84uWR7RPSKJsv3g75u" +
       "21BnLL3/8BlxP5oFz2ffv/jBunxiSfcHr2Xj6GnEPrQj9qGbQ+zkTti9nz6D" +
       "3c9kwUdPYfeTN8Duvuxh9gHtz+/Y/fzN77ZfPiPu41nwC3HhJaYRbw9h8HTj" +
       "2IcmOcEXboBgnuwV4PqlHcFfuvkE//MZcb+VBZ+IC7cDgthuE9rbj6h98kb7" +
       "LvtK4ld31H715lP7vTPi/msWfDYu3A2otbDO1Xruv9wAvQcOeu5TO3qfuvn0" +
       "/scZcX+aBV/IviEB9PT8m9oXjpj90Q0we+mB0n16x+zTN5/Zl8+I+99Z8EVg" +
       "2AGzfmibdnbgxd63HpH70s3ots/tyH3u5pP76hlx/5QFf3fQbbMT3fb3N8os" +
       "+zD493fMfv+mM9u/84y4bGPp/oW4cC9gxpzYrnDIcP/WG2X4CLj+ZMfwT24+" +
       "w5edEfeKLLg/LtyzZXhs18oRvwdulF82ln9xx++LN5/fE2fEPZkFr9qOdszl" +
       "e2COCD5yo5Yl68Cv7Ah+5eYTfNMZcVAWvC7OjqnIPgPLBrw83YnPv25Xfd8x" +
       "FO+I9OtvlHRmcf5+R/rvbz7pN58R95YsaMSFC/r2y+v98hEv5EZ5ZdL61R2v" +
       "r958XtQZcXQWYGB8t6PtzsCt+3KcHn4D9LIvTguPA6S3b/Nuf18sPTB6BaEf" +
       "G1ps6Of512/P6YzOoJqdBLHfz+WWC20v3n5weZwpdxOc7L3dfG37e3M7Ujkj" +
       "TsuCt27NTu9gn2ee8shV2/+mGyCYHyAEPNG93ZaZ7e/NJeieEZcdirdvxYU7" +
       "PCM91ehcWPq2fsTXvgG+92YPYQC9u+PbvUa++/xV+R599r79evqFnN23nMH8" +
       "W7NgBUZMRdd7x76+3l8cMU1vlOmbAOjdVo+9K7Z6XB/TY9r5oZzIe84g+V1Z" +
       "8B1x4YEk0JXYyESYMeLQzveOHGf6nTfANNuxme1u3bN3TO2bI8MX8gQX8v9f" +
       "Fhe+9qqfoD/VPti+/0Jud7Lggzn3Z89olw9nwfvAcOoZq6xRDup47TmnHean" +
       "TnpT/6jh3n8TfI69j+4a7qM3X/mfPyPuh7LgX59lu3/gJjj9ez+3Y/dzN5/d" +
       "R8+I+6ks+NGt059ZNjATzXaZ5aJyxPAjN8Hp3/uVHcNfufkMf+GMuF/Mgp/Z" +
       "Ov0ZQ+lw1/MRv5+9UcV+NYD6yR2/T14jvxdrwj5xBslfz4KPn9eN//FGaT4O" +
       "AH1mR/Mz/0w0P3sGzd/Jgt86uy9/+5pO8QNey2WHs2Ybih+64hDo7cHF2o8/" +
       "d98dr3hu9Lvb/cAHhwvf2SvcMU0c5/ipdsfubwtCY2rn3O/Mw3uDnMsfxIVH" +
       "zzakceEWEOaD0H/b5vlCXHj49DzAZz28P57rT+LC/SdzxYVb89/j6f4nMHJH" +
       "6bLTcvKb40n+HGACSbLbvwgOxoNjm4m2xwKm2117Dx2TpO3qw7l754+tIzx5" +
       "2c7c/Pjug120yfYA70vaTzxHs2//cv0Htwevao6y2WSl3NEr3L49AzYvNNuJ" +
       "+8SppR2UdRv1+n+496N3Pn2wMnHvFvCRVB/D9tjVTzkl3CDOzyXd/Owr/v2b" +
       "/+1zf5gfr/b/AIp6VFFXXQAA");
}
