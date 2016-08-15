package org.apache.batik.gvt.flow;
public class FlowTextPainter extends org.apache.batik.gvt.renderer.StrokingTextPainter {
    protected static org.apache.batik.gvt.TextPainter singleton = new org.apache.batik.gvt.flow.FlowTextPainter(
      );
    public static org.apache.batik.gvt.TextPainter getInstance() {
        return singleton;
    }
    public java.util.List getTextRuns(org.apache.batik.gvt.TextNode node,
                                      java.text.AttributedCharacterIterator aci) {
        java.util.List textRuns =
          node.
          getTextRuns(
            );
        if (textRuns !=
              null) {
            return textRuns;
        }
        java.text.AttributedCharacterIterator[] chunkACIs =
          getTextChunkACIs(
            aci);
        textRuns =
          computeTextRuns(
            node,
            aci,
            chunkACIs);
        aci.
          first(
            );
        java.util.List rgns =
          (java.util.List)
            aci.
            getAttribute(
              FLOW_REGIONS);
        if (rgns !=
              null) {
            java.util.Iterator i =
              textRuns.
              iterator(
                );
            java.util.List chunkLayouts =
              new java.util.ArrayList(
              );
            org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun tr =
              (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
                i.
                next(
                  );
            java.util.List layouts =
              new java.util.ArrayList(
              );
            chunkLayouts.
              add(
                layouts);
            layouts.
              add(
                tr.
                  getLayout(
                    ));
            while (i.
                     hasNext(
                       )) {
                tr =
                  (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
                    i.
                    next(
                      );
                if (tr.
                      isFirstRunInChunk(
                        )) {
                    layouts =
                      new java.util.ArrayList(
                        );
                    chunkLayouts.
                      add(
                        layouts);
                }
                layouts.
                  add(
                    tr.
                      getLayout(
                        ));
            }
            textWrap(
              chunkACIs,
              chunkLayouts,
              rgns,
              fontRenderContext);
        }
        node.
          setTextRuns(
            textRuns);
        return node.
          getTextRuns(
            );
    }
    public static final char SOFT_HYPHEN = 173;
    public static final char ZERO_WIDTH_SPACE = 8203;
    public static final char ZERO_WIDTH_JOINER = 8205;
    public static final char SPACE = ' ';
    public static final java.text.AttributedCharacterIterator.Attribute
      WORD_LIMIT =
      org.apache.batik.gvt.flow.TextLineBreaks.
        WORD_LIMIT;
    public static final java.text.AttributedCharacterIterator.Attribute
      FLOW_REGIONS =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        FLOW_REGIONS;
    public static final java.text.AttributedCharacterIterator.Attribute
      FLOW_LINE_BREAK =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        FLOW_LINE_BREAK;
    public static final java.text.AttributedCharacterIterator.Attribute
      LINE_HEIGHT =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        LINE_HEIGHT;
    public static final java.text.AttributedCharacterIterator.Attribute
      GVT_FONT =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        GVT_FONT;
    protected static java.util.Set szAtts = new java.util.HashSet(
      );
    static { szAtts.add(java.awt.font.TextAttribute.SIZE);
             szAtts.add(GVT_FONT);
             szAtts.add(LINE_HEIGHT); }
    public static boolean textWrap(java.text.AttributedCharacterIterator[] acis,
                                   java.util.List chunkLayouts,
                                   java.util.List flowRects,
                                   java.awt.font.FontRenderContext frc) {
        org.apache.batik.gvt.font.GVTGlyphVector[] gvs =
          new org.apache.batik.gvt.font.GVTGlyphVector[acis.
                                                         length];
        org.apache.batik.gvt.flow.WordInfo[][] wordInfos =
          new org.apache.batik.gvt.flow.WordInfo[acis.
                                                   length][];
        java.util.Iterator clIter =
          chunkLayouts.
          iterator(
            );
        float prevBotMargin =
          0;
        int numWords =
          0;
        org.apache.batik.gvt.flow.BlockInfo[] blockInfos =
          new org.apache.batik.gvt.flow.BlockInfo[acis.
                                                    length];
        float[] topSkip =
          new float[acis.
                      length];
        for (int chunk =
               0;
             clIter.
               hasNext(
                 );
             chunk++) {
            java.text.AttributedCharacterIterator aci =
              acis[chunk];
            java.util.List gvl =
              new java.util.LinkedList(
              );
            java.util.List layouts =
              (java.util.List)
                clIter.
                next(
                  );
            java.util.Iterator iter =
              layouts.
              iterator(
                );
            while (iter.
                     hasNext(
                       )) {
                org.apache.batik.gvt.text.GlyphLayout gl =
                  (org.apache.batik.gvt.text.GlyphLayout)
                    iter.
                    next(
                      );
                gvl.
                  add(
                    gl.
                      getGlyphVector(
                        ));
            }
            org.apache.batik.gvt.font.GVTGlyphVector gv =
              new org.apache.batik.gvt.font.MultiGlyphVector(
              gvl);
            gvs[chunk] =
              gv;
            wordInfos[chunk] =
              doWordAnalysis(
                gv,
                aci,
                numWords,
                frc);
            aci.
              first(
                );
            org.apache.batik.gvt.flow.BlockInfo bi =
              (org.apache.batik.gvt.flow.BlockInfo)
                aci.
                getAttribute(
                  FLOW_PARAGRAPH);
            bi.
              initLineInfo(
                frc);
            blockInfos[chunk] =
              bi;
            if (prevBotMargin >
                  bi.
                  getTopMargin(
                    ))
                topSkip[chunk] =
                  prevBotMargin;
            else
                topSkip[chunk] =
                  bi.
                    getTopMargin(
                      );
            prevBotMargin =
              bi.
                getBottomMargin(
                  );
            numWords +=
              wordInfos[chunk].
                length;
        }
        java.util.Iterator frIter =
          flowRects.
          iterator(
            );
        org.apache.batik.gvt.flow.RegionInfo currentRegion =
          null;
        int currWord =
          0;
        int chunk =
          0;
        java.util.List lineInfos =
          new java.util.LinkedList(
          );
        while (frIter.
                 hasNext(
                   )) {
            currentRegion =
              (org.apache.batik.gvt.flow.RegionInfo)
                frIter.
                next(
                  );
            org.apache.batik.gvt.flow.FlowRegions fr =
              new org.apache.batik.gvt.flow.FlowRegions(
              currentRegion.
                getShape(
                  ));
            while (chunk <
                     wordInfos.
                       length) {
                org.apache.batik.gvt.flow.WordInfo[] chunkInfo =
                  wordInfos[chunk];
                org.apache.batik.gvt.flow.BlockInfo bi =
                  blockInfos[chunk];
                org.apache.batik.gvt.flow.WordInfo wi =
                  chunkInfo[currWord];
                java.lang.Object flowLine =
                  wi.
                  getFlowLine(
                    );
                double lh =
                  java.lang.Math.
                  max(
                    wi.
                      getLineHeight(
                        ),
                    bi.
                      getLineHeight(
                        ));
                org.apache.batik.gvt.flow.LineInfo li =
                  new org.apache.batik.gvt.flow.LineInfo(
                  fr,
                  bi,
                  true);
                double newY =
                  li.
                  getCurrentY(
                    ) +
                  topSkip[chunk];
                topSkip[chunk] =
                  0;
                if (li.
                      gotoY(
                        newY))
                    break;
                while (!li.
                         addWord(
                           wi)) {
                    newY =
                      li.
                        getCurrentY(
                          ) +
                        lh *
                        0.1;
                    if (li.
                          gotoY(
                            newY))
                        break;
                }
                if (fr.
                      done(
                        ))
                    break;
                currWord++;
                for (;
                     currWord <
                       chunkInfo.
                         length;
                     currWord++) {
                    wi =
                      chunkInfo[currWord];
                    if (wi.
                          getFlowLine(
                            ) ==
                          flowLine &&
                          li.
                          addWord(
                            wi))
                        continue;
                    li.
                      layout(
                        );
                    lineInfos.
                      add(
                        li);
                    li =
                      null;
                    flowLine =
                      wi.
                        getFlowLine(
                          );
                    lh =
                      java.lang.Math.
                        max(
                          wi.
                            getLineHeight(
                              ),
                          bi.
                            getLineHeight(
                              ));
                    if (!fr.
                          newLine(
                            lh))
                        break;
                    li =
                      new org.apache.batik.gvt.flow.LineInfo(
                        fr,
                        bi,
                        false);
                    while (!li.
                             addWord(
                               wi)) {
                        newY =
                          li.
                            getCurrentY(
                              ) +
                            lh *
                            0.1;
                        if (li.
                              gotoY(
                                newY))
                            break;
                    }
                    if (fr.
                          done(
                            ))
                        break;
                }
                if (li !=
                      null) {
                    li.
                      setParaEnd(
                        true);
                    li.
                      layout(
                        );
                }
                if (fr.
                      done(
                        ))
                    break;
                chunk++;
                currWord =
                  0;
                if (bi.
                      isFlowRegionBreak(
                        ))
                    break;
                if (!fr.
                      newLine(
                        lh))
                    break;
            }
            if (chunk ==
                  wordInfos.
                    length)
                break;
        }
        boolean overflow =
          chunk <
          wordInfos.
            length;
        while (chunk <
                 wordInfos.
                   length) {
            org.apache.batik.gvt.flow.WordInfo[] chunkInfo =
              wordInfos[chunk];
            while (currWord <
                     chunkInfo.
                       length) {
                org.apache.batik.gvt.flow.WordInfo wi =
                  chunkInfo[currWord];
                int numGG =
                  wi.
                  getNumGlyphGroups(
                    );
                for (int gg =
                       0;
                     gg <
                       numGG;
                     gg++) {
                    org.apache.batik.gvt.flow.GlyphGroupInfo ggi =
                      wi.
                      getGlyphGroup(
                        gg);
                    org.apache.batik.gvt.font.GVTGlyphVector gv =
                      ggi.
                      getGlyphVector(
                        );
                    int end =
                      ggi.
                      getEnd(
                        );
                    for (int g =
                           ggi.
                           getStart(
                             );
                         g <=
                           end;
                         g++) {
                        gv.
                          setGlyphVisible(
                            g,
                            false);
                    }
                }
                currWord++;
            }
            chunk++;
            currWord =
              0;
        }
        return overflow;
    }
    static int[] allocWordMap(int[] wordMap, int sz) { if (wordMap !=
                                                             null) {
                                                           if (sz <=
                                                                 wordMap.
                                                                   length) {
                                                               return wordMap;
                                                           }
                                                           if (sz <
                                                                 wordMap.
                                                                   length *
                                                                 2) {
                                                               sz =
                                                                 wordMap.
                                                                   length *
                                                                   2;
                                                           }
                                                       }
                                                       int[] ret =
                                                         new int[sz];
                                                       int ext =
                                                         wordMap !=
                                                         null
                                                         ? wordMap.
                                                             length
                                                         : 0;
                                                       if (sz <
                                                             ext) {
                                                           ext =
                                                             sz;
                                                       }
                                                       if (ext !=
                                                             0) {
                                                           java.lang.System.
                                                             arraycopy(
                                                               wordMap,
                                                               0,
                                                               ret,
                                                               0,
                                                               ext);
                                                       }
                                                       java.util.Arrays.
                                                         fill(
                                                           ret,
                                                           ext,
                                                           sz,
                                                           -1);
                                                       return ret;
    }
    static org.apache.batik.gvt.flow.WordInfo[] doWordAnalysis(org.apache.batik.gvt.font.GVTGlyphVector gv,
                                                               java.text.AttributedCharacterIterator aci,
                                                               int numWords,
                                                               java.awt.font.FontRenderContext frc) {
        int numGlyphs =
          gv.
          getNumGlyphs(
            );
        int[] glyphWords =
          new int[numGlyphs];
        int[] wordMap =
          allocWordMap(
            null,
            10);
        int maxWord =
          0;
        int aciIdx =
          aci.
          getBeginIndex(
            );
        for (int i =
               0;
             i <
               numGlyphs;
             i++) {
            int cnt =
              gv.
              getCharacterCount(
                i,
                i);
            aci.
              setIndex(
                aciIdx);
            java.lang.Integer integer =
              (java.lang.Integer)
                aci.
                getAttribute(
                  WORD_LIMIT);
            int minWord =
              integer.
              intValue(
                ) -
              numWords;
            if (minWord >
                  maxWord) {
                maxWord =
                  minWord;
                wordMap =
                  allocWordMap(
                    wordMap,
                    maxWord +
                      1);
            }
            aciIdx++;
            for (int c =
                   1;
                 c <
                   cnt;
                 c++) {
                aci.
                  setIndex(
                    aciIdx);
                integer =
                  (java.lang.Integer)
                    aci.
                    getAttribute(
                      WORD_LIMIT);
                int cWord =
                  integer.
                  intValue(
                    ) -
                  numWords;
                if (cWord >
                      maxWord) {
                    maxWord =
                      cWord;
                    wordMap =
                      allocWordMap(
                        wordMap,
                        maxWord +
                          1);
                }
                if (cWord <
                      minWord) {
                    wordMap[minWord] =
                      cWord;
                    minWord =
                      cWord;
                }
                else
                    if (cWord >
                          minWord) {
                        wordMap[cWord] =
                          minWord;
                    }
                aciIdx++;
            }
            glyphWords[i] =
              minWord;
        }
        int words =
          0;
        org.apache.batik.gvt.flow.WordInfo[] cWordMap =
          new org.apache.batik.gvt.flow.WordInfo[maxWord +
                                                   1];
        for (int i =
               0;
             i <=
               maxWord;
             i++) {
            int nw =
              wordMap[i];
            if (nw ==
                  -1) {
                cWordMap[i] =
                  new org.apache.batik.gvt.flow.WordInfo(
                    words++);
            }
            else {
                int word =
                  nw;
                nw =
                  wordMap[i];
                while (nw !=
                         -1) {
                    word =
                      nw;
                    nw =
                      wordMap[word];
                }
                wordMap[i] =
                  word;
                cWordMap[i] =
                  cWordMap[word];
            }
        }
        wordMap =
          null;
        org.apache.batik.gvt.flow.WordInfo[] wordInfos =
          new org.apache.batik.gvt.flow.WordInfo[words];
        for (int i =
               0;
             i <=
               maxWord;
             i++) {
            org.apache.batik.gvt.flow.WordInfo wi =
              cWordMap[i];
            wordInfos[wi.
                        getIndex(
                          )] =
              cWordMap[i];
        }
        aciIdx =
          aci.
            getBeginIndex(
              );
        int aciEnd =
          aci.
          getEndIndex(
            );
        char ch =
          aci.
          setIndex(
            aciIdx);
        int aciWordStart =
          aciIdx;
        org.apache.batik.gvt.font.GVTFont gvtFont =
          (org.apache.batik.gvt.font.GVTFont)
            aci.
            getAttribute(
              GVT_FONT);
        float lineHeight =
          1.0F;
        java.lang.Float lineHeightFloat =
          (java.lang.Float)
            aci.
            getAttribute(
              LINE_HEIGHT);
        if (lineHeightFloat !=
              null)
            lineHeight =
              lineHeightFloat.
                floatValue(
                  );
        int runLimit =
          aci.
          getRunLimit(
            szAtts);
        org.apache.batik.gvt.flow.WordInfo prevWI =
          null;
        float[] lastAdvAdj =
          new float[numGlyphs];
        float[] advAdj =
          new float[numGlyphs];
        boolean[] hideLast =
          new boolean[numGlyphs];
        boolean[] hide =
          new boolean[numGlyphs];
        boolean[] space =
          new boolean[numGlyphs];
        float[] glyphPos =
          gv.
          getGlyphPositions(
            0,
            numGlyphs +
              1,
            null);
        for (int i =
               0;
             i <
               numGlyphs;
             i++) {
            char pch =
              ch;
            ch =
              aci.
                setIndex(
                  aciIdx);
            java.lang.Integer integer =
              (java.lang.Integer)
                aci.
                getAttribute(
                  WORD_LIMIT);
            org.apache.batik.gvt.flow.WordInfo theWI =
              cWordMap[integer.
                         intValue(
                           ) -
                         numWords];
            if (theWI.
                  getFlowLine(
                    ) ==
                  null)
                theWI.
                  setFlowLine(
                    aci.
                      getAttribute(
                        FLOW_LINE_BREAK));
            if (prevWI ==
                  null) {
                prevWI =
                  theWI;
            }
            else
                if (prevWI !=
                      theWI) {
                    org.apache.batik.gvt.font.GVTLineMetrics lm =
                      gvtFont.
                      getLineMetrics(
                        aci,
                        aciWordStart,
                        aciIdx,
                        frc);
                    prevWI.
                      addLineMetrics(
                        gvtFont,
                        lm);
                    prevWI.
                      addLineHeight(
                        lineHeight);
                    aciWordStart =
                      aciIdx;
                    prevWI =
                      theWI;
                }
            int chCnt =
              gv.
              getCharacterCount(
                i,
                i);
            if (chCnt ==
                  1) {
                char nch;
                float kern;
                switch (ch) {
                    case SOFT_HYPHEN:
                        hideLast[i] =
                          true;
                        nch =
                          aci.
                            next(
                              );
                        aci.
                          previous(
                            );
                        kern =
                          gvtFont.
                            getHKern(
                              pch,
                              nch);
                        advAdj[i] =
                          -(glyphPos[2 *
                                       i +
                                       2] -
                              glyphPos[2 *
                                         i] +
                              kern);
                        break;
                    case ZERO_WIDTH_JOINER:
                        hide[i] =
                          true;
                        break;
                    case ZERO_WIDTH_SPACE:
                        hide[i] =
                          true;
                        break;
                    case SPACE:
                        space[i] =
                          true;
                        nch =
                          aci.
                            next(
                              );
                        aci.
                          previous(
                            );
                        kern =
                          gvtFont.
                            getHKern(
                              pch,
                              nch);
                        lastAdvAdj[i] =
                          -(glyphPos[2 *
                                       i +
                                       2] -
                              glyphPos[2 *
                                         i] +
                              kern);
                    default:
                }
            }
            aciIdx +=
              chCnt;
            if (aciIdx >
                  runLimit &&
                  aciIdx <
                  aciEnd) {
                org.apache.batik.gvt.font.GVTLineMetrics lm =
                  gvtFont.
                  getLineMetrics(
                    aci,
                    aciWordStart,
                    runLimit,
                    frc);
                prevWI.
                  addLineMetrics(
                    gvtFont,
                    lm);
                prevWI.
                  addLineHeight(
                    lineHeight);
                prevWI =
                  null;
                aciWordStart =
                  aciIdx;
                aci.
                  setIndex(
                    aciIdx);
                gvtFont =
                  (org.apache.batik.gvt.font.GVTFont)
                    aci.
                    getAttribute(
                      GVT_FONT);
                java.lang.Float f =
                  (java.lang.Float)
                    aci.
                    getAttribute(
                      LINE_HEIGHT);
                lineHeight =
                  f.
                    floatValue(
                      );
                runLimit =
                  aci.
                    getRunLimit(
                      szAtts);
            }
        }
        org.apache.batik.gvt.font.GVTLineMetrics lm =
          gvtFont.
          getLineMetrics(
            aci,
            aciWordStart,
            runLimit,
            frc);
        prevWI.
          addLineMetrics(
            gvtFont,
            lm);
        prevWI.
          addLineHeight(
            lineHeight);
        int[] wordGlyphCounts =
          new int[words];
        for (int i =
               0;
             i <
               numGlyphs;
             i++) {
            int word =
              glyphWords[i];
            int cWord =
              cWordMap[word].
              getIndex(
                );
            glyphWords[i] =
              cWord;
            wordGlyphCounts[cWord]++;
        }
        cWordMap =
          null;
        int[][] wordGlyphs =
          new int[words][];
        int[] wordGlyphGroupsCounts =
          new int[words];
        for (int i =
               0;
             i <
               numGlyphs;
             i++) {
            int cWord =
              glyphWords[i];
            int[] wgs =
              wordGlyphs[cWord];
            if (wgs ==
                  null) {
                wgs =
                  (wordGlyphs[cWord] =
                     (new int[wordGlyphCounts[cWord]]));
                wordGlyphCounts[cWord] =
                  0;
            }
            int cnt =
              wordGlyphCounts[cWord];
            wgs[cnt] =
              i;
            if (cnt ==
                  0) {
                wordGlyphGroupsCounts[cWord]++;
            }
            else {
                if (wgs[cnt -
                          1] !=
                      i -
                      1)
                    wordGlyphGroupsCounts[cWord]++;
            }
            wordGlyphCounts[cWord]++;
        }
        for (int i =
               0;
             i <
               words;
             i++) {
            int cnt =
              wordGlyphGroupsCounts[i];
            org.apache.batik.gvt.flow.GlyphGroupInfo[] wordGlyphGroups =
              new org.apache.batik.gvt.flow.GlyphGroupInfo[cnt];
            if (cnt ==
                  1) {
                int[] glyphs =
                  wordGlyphs[i];
                int start =
                  glyphs[0];
                int end =
                  glyphs[glyphs.
                           length -
                           1];
                wordGlyphGroups[0] =
                  new org.apache.batik.gvt.flow.GlyphGroupInfo(
                    gv,
                    start,
                    end,
                    hide,
                    hideLast[end],
                    glyphPos,
                    advAdj,
                    lastAdvAdj,
                    space);
            }
            else {
                int glyphGroup =
                  0;
                int[] glyphs =
                  wordGlyphs[i];
                int prev =
                  glyphs[0];
                int start =
                  prev;
                for (int j =
                       1;
                     j <
                       glyphs.
                         length;
                     j++) {
                    if (prev +
                          1 !=
                          glyphs[j]) {
                        int end =
                          glyphs[j -
                                   1];
                        wordGlyphGroups[glyphGroup] =
                          new org.apache.batik.gvt.flow.GlyphGroupInfo(
                            gv,
                            start,
                            end,
                            hide,
                            hideLast[end],
                            glyphPos,
                            advAdj,
                            lastAdvAdj,
                            space);
                        start =
                          glyphs[j];
                        glyphGroup++;
                    }
                    prev =
                      glyphs[j];
                }
                int end =
                  glyphs[glyphs.
                           length -
                           1];
                wordGlyphGroups[glyphGroup] =
                  new org.apache.batik.gvt.flow.GlyphGroupInfo(
                    gv,
                    start,
                    end,
                    hide,
                    hideLast[end],
                    glyphPos,
                    advAdj,
                    lastAdvAdj,
                    space);
            }
            wordInfos[i].
              setGlyphGroups(
                wordGlyphGroups);
        }
        return wordInfos;
    }
    public FlowTextPainter() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AzSh6tzMPNFr+2aNamIyy8/Q/JMZ4U4+fRgqS5kqKZbmkCLvM6lJMVIODCCy" +
       "es3xEE+Aca/5ZVWheMJifzPPPiU1nL8TAR9zvsQ/ZRLPJ3OFQU5OcMQJrSrx" +
       "bQ02LYxUikiXyUYJ8HVBMcAVLorqozd5Y/NrHk4IUyycVME5u6EZ4oZqXRjh" +
       "81SWoGE9dr4DixWE3qYLJr27XErxKGjOuKrKVFBOEgxD5BQEQ4xapBkmm2vi" +
       "NH/fZTAM+cXBmhLIgtNcqKowuyBdFpvmLyPb/8eQg8U5qDWSomomMiiwdIy7" +
       "jB3RTiV6LqIQboCGLs65zQF7FpXQu294uNgOD93vMjwg7EI+FTYdxXEAu0/D" +
       "ZnkJx76YU9uBzYoS5t9X4hsu+UO4kxJqNSkpAXvpLFw51MnbC0ugvQybDYzU" +
       "CbKsittUPdEncGFe5DjaxlPgaIvxWysQu9byjbUlHA2J+FCxWwUNDSgvrID2" +
       "fv/rLhjcekZHeuS9WnqU4vEuwr/GpYhNGxfXrhKiTGCzHQq7hIpy3KwI8l5D" +
       "MjzuXIvwC0ox7jhHKp9CVwff0cG5okpSDXaQlO0g8qwcJD1LB0lxqaRP5iBG" +
       "iW9ZbPbkHSRdykGmZuogjoHveC8MPId7pIX3pfBwf2nRdUzzCqF47+GG6iWH" +
       "L3varLfsa351sNJOZmXZffzseq/SdJqUuJbqzMNofl4VupKR0wJNhJEK/OF2" +
       "td+E/wQUMn7wUB5B64b8NCONXkioP/ivG+4zjNQ4cFCBmS9ukM8DdgDB12s1" +
       "27LP8SXbroXDPrVwzrSx5W598NXRopOp0bULs6agjuY3a+2FR3bQ2t06fnhr" +
       "/xWvf/Br5nUkURampxFLLZS85qUnq+T17pS5sdm4qnrb3p5339y19tKl4DqU" +
       "mzZuTGCj/OrQMs/9HKM1f03nmSObHvzlgarHocTfTkICFK3bi68+5LSsTpq3" +
       "x4rPT2FFwC8Otbd9ae9F65N/e9Y+cw8VXinxwsfFJ4/ufOL6pUdaykhtlFRK" +
       "oKccv5OxZa8yRMVJfYzUS0ZXDkgELFAhFxzOzkM7F/DOLZeLJc76fC/eU4No" +
       "V3wwXXy7rwZMmuodalbBwIsLlVqnx16bFGz4ZDXNM8Dpca1euB+Gc6gNMNh4" +
       "rE/T7EteNds07u2Z4JR7O3/Ft6/8F3ZHX9h1LwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "YceU1g4oEQ4MLAWbWl6b5zm+IZF2td9v");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "/x++J4panjsAAA==");
}
