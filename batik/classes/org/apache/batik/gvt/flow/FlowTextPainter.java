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
      1471109864000L;
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
       "rE/T7EteNRs07u2Z4JR7O3/Ft6/8F9KM9Ex1LwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL17C8zsWH3f3Lt37z7Ze9nlsdmwy7J7F1gmvZ4Ze15dQrFn" +
       "7Bl77PGMZ8bjcQMXv+0Zvx9jjxMKi9qCSkVQu1AqwaqVSNqihY3aRm1VJdqq" +
       "apMoKC0IpU0fgYaqTaCoIJUQlbT02PO97ne/7y4XaD7JZ/yd8z/n/P7P8z/2" +
       "8UvfqtwdhZWq79k7w/bi61oWX1/bzevxztei6xTdnEhhpKk9W4qiOai7oTz1" +
       "K1f++PsfN69erFwWK49IruvFUmx5bsRpkWdvNZWuXDmuxW3NieLKVXotbSUo" +
       "iS0boq0ofo6uPHCia1y5Rh9CgAAECECASggQekwFOr1GcxOnV/SQ3DgKKn+p" +
       "coGuXPaVAl5cecvNg/hSKDkHw0xKDsAI9xb/84CpsnMWVp484n3P8y0Mf6IK" +
       "vfC33nv1H95VuSJWrljurICjABAxmESsPOhojqyFEaqqmipWXutqmjrTQkuy" +
       "rbzELVYejizDleIk1I6EVFQmvhaWcx5L7kGl4C1MlNgLj9jTLc1WD/+7W7cl" +
       "A/D6hmNe9xwSRT1g8H4LAAt1SdEOu1zaWK4aV958uscRj9dGgAB0vcfRYtM7" +
       "muqSK4GKysN73dmSa0CzOLRcA5De7SVglrjy2LmDFrL2JWUjGdqNuPLoabrJ" +
       "vglQ3VcKougSV15/mqwcCWjpsVNaOqGfb43f+bGfd4fuxRKzqil2gf9e0OmJ" +
       "U504TddCzVW0fccH30F/UnrDr33kYqUCiF9/inhP809+4Tvv/pknXvnNPc1P" +
       "n0HDymtNiW8on5Uf+tKbes927ypg3Ot7kVUo/ybOS/OfHLQ8l/nA895wNGLR" +
       "eP2w8RXuX68++Dntmxcr95OVy4pnJw6wo9cqnuNbthYONFcLpVhTycp9mqv2" +
       "ynaycg+4py1X29eyuh5pMVm5ZJdVl73yfyAiHQxRiOgecG+5und470uxWd5n" +
       "fqVSuQdclQfBBVf2f+VvXPk5yPQcDZIUybVcD5qEXsF/BGluLAPZmpAMrH4D" +
       "RV4SAhOEvNCAJGAHpnbQYGxjSLe9FBisl86BC02k0mKvF1bm/38ePyv4u5pe" +
       "uABE/6bTjm8Dnxl6tqqFN5QXEgz/zhdu/PbFI0c4kExceRZMeX0/5fVyyutg" +
       "yuvFlNdPTVm5cKGc6XXF1HsFA/VsgKODEPjgs7P3UO/7yFN3Acvy00tAtgUp" +
       "dH4k7h2HBrIMgAqwz8orn0qf5z9Qu1i5eHNILeCCqvuL7pMiEB4FvGunXems" +
       "ca98+A//+OVPvt87dqqbYvSBr9/as/DVp04LNvQUTQXR73j4dzwp/eqNX3v/" +
       "tYuVSyAAgKAXA4kV8eSJ03Pc5LPPHca/gpe7AcO6FzqSXTQdBq37YzMESjiq" +
       "KTX+UHn/WiDjbuWguMmqi9ZH/KJ83d5CCqWd4qKMrz878z/z73/nj+BS3Ieh" +
       "+MqJxW2mxc+dcP9isCulo7/22AbmoaYBuv/8qcnf/MS3PvwXSwMAFE+fNeG1" +
       "ouwBtwcqBGL+K78Z/N5Xf/+zX7l4bDQxWP8S2baUbM/kD8DfBXD93+IqmCsq" +
       "9q77cO8gfjx5FED8Yua3HmMDocQG7lZY0LWF63iqpVuSbGuFxf7plWfqv/o/" +
       "PnZ1bxM2qDk0qZ959QGO638Kq3zwt9/7vSfKYS4oxVJ2LL9jsn18fOR4ZDQM" +
       "pV2BI3v+y4//7d+QPgMiLYhukZVrZcCqlPKolAqslbKoliV0qq1RFG+OTjrC" +
       "zb52IuW4oXz8K99+Df/tX/9OifbmnOWk3hnJf25vakXxZAaGf+Nprx9KkQno" +
       "kFfGP3fVfuX7YEQRjKiAKBaxIYg62U1WckB99z3/4V/8yze870t3VS4Slftt" +
       "T1IJqXS4yn3A0rXIBAEr8//Cu/fWnN4Liqslq5VbmN8byKPlfw8BgM+eH2uI" +
       "IuU4dtdH/zdryx/6gz+5RQhllDljpT3VX4Re+vRjvXd9s+x/7O5F7yeyWyMx" +
       "SM+O+zY+53z34lOX/9XFyj1i5apykPvxkp0UTiSCfCc6TAhBfnhT+825y36h" +
       "fu4onL3pdKg5Me3pQHO8AoD7grq4v/9UbHl9IeUeuNoHsaV9OrZcqJQ37y67" +
       "vKUsrxXF20qdXIwr9/mhFwOUGsjXLkdlollO8ixoikDmZWvxgdRfH1eePHMh" +
       "OrH+7ENZUcJFge4NoHWusTx3xMqjRW0HXOoBK+otrFw4CmqFdK+TYEJDCx/+" +
       "g7/z2e89/+HOxcI3794WWgAKvnpMN06KbPmvvvSJxx944WsfLeMYGPnzxaCj" +
       "s8VyV3H79qLAY6AVy5XsQ5k8MGOJ+Y3hajLEx7c36EloOSAibw9SP+j9D391" +
       "8+k//Pw+rTttvaeItY+88Nd+cP1jL1w8kUw/fUs+e7LPPqEuUb6mhFrEg7fc" +
       "bpayB/HfX37/P//77//wHtXDN6eGONj5fP53/88Xr3/qa791RlZySTGl0wqn" +
       "fwSFawcK185QeHHDVCpPPlDcvPdVtVUU3KGqroo4x95Ykv358MZsgvbK1uUp" +
       "wDd+BMD6AWD9NoBLJeh3Bvi1JwBTLDnGubMQG3eIuAku4wCxcaZPPXLsKz2g" +
       "UhDstRD56OD3No+9NQN67x16lV95sujl3hlXd58re+8OOXkKXOsDTqxzAl16" +
       "Z+DuX7Jc/wZNMuT8MMZBpTSKnfZ1NAabTxlsO9UjuZCxVqZF147aTjGV3SFT" +
       "GLicA6bsc5j64J0x9SBBs8sbHD4g2fGsqPuFUxifv0OMA3D5Bxi9czB++M4w" +
       "Xikx0sDIb2Acjo7OgvmRO4RZLIThAczgHJgfuzOYD5QIhzg5GM7PgviLdwix" +
       "IEsOIMbnQPzEnUG8d8DPbxDs+Ex8n/zh8ZW5RK2gOcCXnoPv0+fkEsVtv8R3" +
       "CO1ylAM3iW5aiW5eJzkpLZ+r3FD+2fRrX/pM/vJL+4VGliKQS1XPe0R361PC" +
       "Yhf4zG12sscPb747+POv/NHX+fdcPEjOH7hZAo/eTgKHMeI1x0kzyAiLyl8+" +
       "JfjPvKrgSxmBAAwiZON6+3qt+P9zd6b6N65t5drhDovXwggkyNfWdvsQ5okk" +
       "aP8Y7RTIZ39okECFDx0PRnuu8dxH/+vHv/iLT38V6Is6XCAK6jHYIPJ/+fuP" +
       "vbv45x/dGT+PFfzMyscstBTFTLmV09QjluYnQAsgAbG9H4Ol+HV/fYhEJHr4" +
       "R9eknogqvC5MhNiNNmo9mptUQ2k0rF4DH+B4lqLNtdruE2bXweCGZjgrlZY7" +
       "Dc2Jclh1NQRKmhNiwPT6GoX1eqSy5HrpGp3u8CicdnByZ41GvKVMDYuaYVLP" +
       "Im0C5SUvodrbduJqcNCiqtkIHoXVGrRtQ7quQyoCrcP6aGQ01JjoEaZqa2su" +
       "NGlvMe6FPoY3G7sVZqxrmCLIO0SAw3XH1xF6t1nzA8oRCC+tLuaYF9fmttkn" +
       "Bo4lECuStBYBq9eMGTsYz/ypzlPGwgmYzWo5W6xqXseZjWi8Ol7g3IqYT1eN" +
       "WTWljGS9VMQ175GDgcOiswU339ibCFJzDckXlhQ06imhtwx6qw7r2I5Mc7tD" +
       "kKvGDmZ6Nh5tdjMyH1IrttZ0xZ0f6LRmj3Y7hmlknUG7qeMRvmxMXAKxja5Q" +
       "G8vteleQA85q9DCvZwRINRWnXW7aXDiSReEDv63Svmmv+9AGGa2q3NJUUrJV" +
       "y7QuSc6xAJst68lwZhlbHwkai527i21zHKyC+WLWGxA2b+HTudoj1h7nbsYo" +
       "O5AcOcsNpR/vtjlM+QoREgjSdLhprurw1horMZlyprcRuTWFr3AS81nGWGC+" +
       "6OdBloi4YcmD3TAl7H6dURfO1F/adK3WGNgEiduGUG80aAxQDtR5yyV32ykJ" +
       "9RyxtnRartvYxDsjnHSCTXs0RW1EYNs7aTgU15McW5EpYWo2iSZtdsDjGTnz" +
       "RhyhIpzGNWU6xdFB33OndVvKF13em66nU9Fn8CZOUNxCxOLxfGFgUrAisZaX" +
       "Rr3abBTFK1xZUGRtbko+qia1SYovhmyTHKIkiSSdFZbOpYEjcrUogeRc2lZd" +
       "g1gE28VG7E2HbM9a0zMhTfrL9a5vOtasZc47KZat1JocUc4wQ1N91EOHBsc1" +
       "Dbwqy0N4202rsTzf5oxJuAmaM+nWT0Z0D9EGIgQ3WEeVOW1BZi7vOD4ZTNJe" +
       "HjpCn/f1hstIHLUmtFWOMMsMmvSHtQ6ubbdUUgV4Ai/gRjzLR1iSedvAdMa4" +
       "42hGlw96SOp41izhOUqd0NvFnBzCDjubRrBmLOczr5eNRs5c4yVhB9UIfLbo" +
       "YWQQYGrNpoKt1KZCtKZ3ur5Joc0Ohba0fhPN+1B117HYGRGOa6Rh9LxgE1AE" +
       "JiyE6npq4u5wMJXn3q5vryB8PlyEKOIMiGGdx6coWzPnrdo42GyWs2jtEVgQ" +
       "s+sVSvenobKKxp6oen7md/uQKTLmgjSqMdtdW9V+Ds0CxaMDRSemcTAJu8IW" +
       "2IQ27pkwtjHStTzH7AaV7vKRwqRNznT7dOSII3zq7hxzbtWDJTbN0ynCbuZS" +
       "Esqmy8fwkDfVvi/Zc36JyhhRUxfDQUsAjsLBPaRKZ/429HmlqnbqqBisLI7a" +
       "EJsloMFoSpzXCA+3lKjdqslmPd/45IwP/RmaLDKBEwPUwmaLgZVGdc3b1OWB" +
       "vlktkv5Q7k1jjcFGCi1AIWXxiROaIXCqlTiabRl0bdrUdJoO+y0ymke6V0+6" +
       "cFIdxtWBZHeRlh4z1fpq08eWLpF7IkE2B0CoTblDei7tt7LF1lxCJNEN+TxS" +
       "dgTL1NGdGaHLdpYSK0lW+7FLzvJF6hLz+rrXX1P1LQh5u9jowhutbXF5pDqb" +
       "pbOVcFJDXae2hbFVUq3B63a7g86aFJvjtaRPt5iBEIdOD99RPtKg3O2SnZFz" +
       "y0UhrbVMuTjRJ0upraYKuhyNYWQWN4ZiD0fp2ECnUFdmunmeQzCFu7ssnYt+" +
       "bxxVx9M6O0XodKsbcmc6mUAYljKk6luYP3LnlrMKO1UC6NUVWJnDVtQEq6o4" +
       "srS68xTd2X5vxuyyebdZ74ylDtSs253J2A8DOxgOY1+uUzXd6FLQciq1O1WN" +
       "h+Qq4U0t0uE3arXvG2LIKYjT18MkRIWWYqpdYZ0TcCeAUTEbNkYxuajPh2uE" +
       "slPd7K13+q5KRbDfdqvyCnPay0Gjs6JhxeRRRiBazWYnFNq1eKrqze50ydtY" +
       "stUVahnGPietliuapK3xYmEOJ50EhGx1s2ElYm31+VnX8PGByGpqawxxI6qL" +
       "DFor1WjYRI/OBwbawhhbNWamWGuKuQ5te2YmR9pop9qwxA14j8fjDqquo5SY" +
       "tVSwLFHRPNwi6W6lLrrCdDykmpseSRHC0iBsGWm1ldDLB8lGc7f0xHX8gB26" +
       "1bETiBvE3k6ymFs3ejsyorsrlWpDbWvagCbbgHBaMqOOO8vheNNBmnJVqaHa" +
       "FgoJPZv7pqLU3DqNMzASKUm+FMWasFXoIdvBCa6tO5bN8NjAdNu0DYtdJFrW" +
       "4fomJ3ciktYsW8wmvZBc6vOQmRlkX44t0xi1kGFsKkt1ySRwExk6rXG71/S3" +
       "S2C3KpGu4x4CJ90sXQne1Gsjqm00NHQQpo1BbwiJO0+LkEZNHidJsxp5K0fa" +
       "+iODCUbcrMZPpW02HDehcYYTvoz2q8w4ILr2zsp5mhTwFrVlBd5V+sxwJUdz" +
       "B3fZ6nw1bCQ7fpLX6QiempM0IN2Fwm1HWJVZTAVzhO9WnhvOrbaiV/WYrzfS" +
       "KG2aM3blgIAQeyrbb0XttVOdzLJBMw77bThll23PmGw0rh8GdDve6f0a7aT4" +
       "IPDBkPqKlDcbamo6/pBre0PPhXV3lsatBIrwNrZ0UIRtNNH5jLBJpsssE6Ge" +
       "rNh2hrKxAXdqurapuSnuwCOyTXY1dhLCbSLf0fxywjMOLa9bkWNo4cDmwII1" +
       "tde7Xmh6WbNFbhPJ9atIV+Lb82HQ6ScbzDcUVtcltcMQfdFdZUQdC614lbbX" +
       "Q4eM/D4s+bMIQjlY6FS3CVRlIVVd1Wmepw2lRdJ8e12fQHokIHysaczMxYPa" +
       "tFaXbNPCd3avYxGZPGoknLdrKNLW7aoLeAPXe11u4dd5v18XB5vaQksQhcy3" +
       "CR62csZlQapJjmu5sfbmjLF1w86qG0UQOZbEjdqF0LE+2dAkiA6dhjCeIR3R" +
       "8ZGujdVgbMaOV/UuhupEXNvVzK0+NFOloQhdr9tOxpSb8sLMWVOiEcQtnXK0" +
       "Ma9iixzdwR2Br3uEp3e16bAeCznVi0FcopYC6+jkREQtlVRXVH2ajNyq6+gt" +
       "2HZWsdMaUmbqZzA7pskZB9fBYpQON9MhR/M92m2mZtLamo0lPCazZSZVpUBq" +
       "6GODm6GOOJDk6bi/rI4yiejWMrw5x2dNAR6So2auoDi8objMtQnBDiE/GXYQ" +
       "Jm/Sad/1MsLNcrSqNPKmnbIpk5GCoEYrIu4Eo8hlYxRaD2uwhllNcSUBy+mt" +
       "lyrro6uso6kSE6CDlcfl7pqZox2NVKf1hkxDw3VTX4kdb2RvGu1x0tNQu8Xm" +
       "TYefoAOZBN42hoOmN69WyWHWhXMfnWBMLEVtHJ147YljdJYG5XAtv81thDU8" +
       "pTtbHNK6GvD+oRA1Utucz6eLtKM1UNYU9Wq+mU8iPsQJEgQ5HdumDTKKatW6" +
       "OpsyDA9z2sRab5U67bS6CAnzfCCs0epWmqzrCATpgyxuCyOQvOjuUhW721oe" +
       "THgkZEUTtlUTmVIaJ6ZxE62hw+4yWvMQBCnxhLOW1rznuYMex1iULaH0BBf7" +
       "025jTUc9rrq1kGTZZ1rGtt0y6bwpZ9ttMu4tYClAF/EMg6otm86zRgOaZ6vG" +
       "KjZbi4RsKANXSBfDtm7MY0HCwzhe27TenrhTS9Qhhg7n9RjvyMPWKmqOqa3M" +
       "9kxrYanrtkXPJhmM7OB4G7M9DqKqatTi4NlyVZU7IeLh7RqL2EmEi2oHgJ9M" +
       "dlVlzWedloutkcZ60/Aa9gpZEzxbS5xNnWt4khepWDhdmR2oBfeWNbkqq1BN" +
       "38aJ1PLXVGyFjVjMNkg2h4R0MGJ345XCN2e6G9aFpjQWqLk2XjFqzVxoI8Hm" +
       "4JiH29RAUzW6LuqZkdVznchqJDFtBnQ9leustRCFpa30lykVQAIRc8Ig38k0" +
       "XU86kYhnIHVBq5SoG0SmGw5DCTIvWOusveAj3YhFerEUl02iv/ZrkNamlMUw" +
       "mPTWUWs8bkM8hagTN20yMgOiSqePkfNxmHr2gh9bAanLjM16cajAWLWZdslx" +
       "t2FjIVxfYruV3YlXXA3u9B2KZ1ssw0/5NY4g6LipJitTwZiOWncjeLDMO7sJ" +
       "m29YZzasMjm/bTp9YbKdq768latp3vVYwe9UubmncHY1RQRM97YtSKuK3lQ1" +
       "u6TVNgI2YCbZnO1WV+Nwgq7jYKg3sE53ASIhOQH7NWoeRlOxkRBNmApmUD6a" +
       "aWiHhVvYYob3wARjM5p7GKsK7oaFIMboOuuM9mvW0kthLdKEOYTMl1AT2sp1" +
       "kcQULu9to2oWNbaM1NE0vSpk1URsa3LbSMTdkNO6TR1oSGdwn+2qNJrPzFac" +
       "M5MxEVYb0lhyyN2uA00hihGRBVLVOSOYNTfBSJSdTY/eMi2bYniS7fd6Oy2C" +
       "MxyvoooENUV+aWoMZek5MEJrUXfpzhzluvk2mkIiR08omCWmiyarMFMqnIWZ" +
       "PK016FW2sDaWsFusqM6QxxgF5WkvDLxcba6gcTjcIORit1N4sINLWriIeGIg" +
       "cGuzU58tvQHeVUOkb2VLHA5WNBU22gIeZqPBmk1G4YgnMBY3sn4Tm+JTJJN8" +
       "bOM4DbBxHUK6OEeZqiJgjkmTRjxWgpGXJjtMJfytQ+8mMtTRpkZn0Qz6y5nn" +
       "eA5jWalK7tprDObmFt+iA3Iqe70BHbWa+ZRoE74wTRpdJBkbbL8Lb5l1arRx" +
       "skrMV2om4GhSg8B6uaGydmu16CZYvvJmzbgrIGYENm4sssmoYDzb+Kiw9Wki" +
       "bdYZV+7VEmM73cn9Vb7oyaPIiuPFRMVdZUBozf5ayuyJIZHbbLmLpklX3q3l" +
       "hT1EG1SV6GXLdDHuz4xtSPYbOkjMaHOtaBtxqCWz7tINFsgWT9IQGvgrczzI" +
       "dCE0R9Z80MuH06Btkv4OHqVkx272mXWeCOQ27dW8rL02hyO/2+NTXa8pg6a3" +
       "8Wd9QZrabM3oBKlC9es0VrOzQOImTQsbWMuuKE/kzXDGqbsN2EAnHlikh1ut" +
       "12EmpNr2SQH2dSwFm1pOXeR5LyCQdnUw");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("aFnLIQ1vpZDWIwlu1qMxxYqOIOp6HmkBNFOpYJFQcpAzY0+3ET7xR1wtpcYm" +
       "hY8glmjEahWH0umCcdvpAmtiLUTujHvsWNhY3gSytoMqkq/HU0Qhepgz6yYb" +
       "ptNXjT5Wb0T1RpuedGaCHHpCfxLyaR7Osuay2e2MBc7zWb8mL4DKJWOdrGCp" +
       "2iA4WJ424lpLd80QypZbHcLCprvYLDjJ8TOCpsVZpxks3KA6r7f9WRNsrZDA" +
       "DWXYb8Jwd1fvxiMb6QcLJxcTIP81xIZTJoK6wxFT12uw68xYebjNbUMKh54y" +
       "1+cbskeMYNlqdapNehbN/QDOkHAybxBE2uuwsax2Ja0L9h9jsKquqkraAbHU" +
       "zdJIJygESnSWbvkLVdptzNgmuJE3UpRtk81EqbPjGJ7Sga3NaqLQ3xg4TaAm" +
       "keUg9jFtAuqztKjRlNJu6T1IWyBjj4fTVBB27TAVGSfxVMmWsRRsFWw+cLN6" +
       "SyYGOSL2hTEQr69IdS3BqgOlZYyZsYmEODRv47E25qJaO2mICMW1WRgi4hbU" +
       "IbojpotndTpF0eKx5K/f4fvC8vHv0ZHKtd0uGl6+gyei+6a3FMUzR4/By7/L" +
       "lfMPLJ041FEpXjM/ft5JyfIV82c/9MKLKvtL9cPn7au4cl/s+X/O1raafWKo" +
       "4lTwO85/gs+UB0WPD2n8xoe+8dj8Xeb77uAY2ptP4Tw95D9gXvqtwVuVv3Gx" +
       "ctfRkY1bjrDe3Om5mw9q3B9qcRK685uOazx+JNknCok9C653Hkj2nadfMBzr" +
       "7uz3K28/8X7lNgeOvnKbtt8tin8TVx4wtPiQjaJqcGwy//bVHqKfHLOs+OIR" +
       "jyXZT1f2r7oqh78/JI8XSh7PZO/iXgiHrzYeP/ckythTtUOqZ36od7nlfF+7" +
       "jcj+W1H8x73Iiim4xI1Kwr97xPYDBfGV27F9iOmhk4e09gfavnEs+v/0Y4j+" +
       "saKyeEn+gQMMH/gJmtelkupSdNvXbOWBuf1rthd/+enf+cCLT/+X8szZvVbE" +
       "SyEaGmecqz7R59svffWbX37N418oz2iW7wBLLzp9IP3W8+Y3HSMv4T94JJUn" +
       "CyE8B64vH0il/I0r6k/g1G+ouaoWamFxSt3bWK5xxuniP5N5Sp6/fqSsCwen" +
       "e49eeP3J4cvbP3017R+tLpdtzTVi86wXb3eBiYvb7/nZef558kyJ7blacSDz" +
       "sG1/ONnyrh99tAAaszPBf3EPvpysKJ4+30svPHCbtuI4zoX74srdSgFmj/02" +
       "5FcPnO3Yv58u2t4Grg8eWNEHz/Ktbxx78xldnz/o+vyrdAUienMpIimNr+ue" +
       "G18nQMGVNnDwEUjZ5X/dhoNHi8r/GVfuLaiXoeSfpcd7ZM+zNck9Dj/f/jHC" +
       "T5k7PA40d9++7/73TiL/2ZHnpGV992i2Bw8C7qXxfrb9b1xRfkx3k3w/gqKt" +
       "ARLjNAIeVywnE0vZaOFEcjX70Kv/LKYpFVk50y8Kp77wtgOnvlD9IZ26KH5Q" +
       "DloUb73Ve4vqS0Vx+Xx3BNOWvV/NHRu3aUOKojjxcOGhPZLb0LayEu3+n2du" +
       "Q9gpiifjyoOSbXvK0gtVRirF89Yj+77wlh/Dvt9QVF4DonjmwL6f+cnY9+HK" +
       "euD6bz/7Y48iDAz4+cDe+SavFeexC/qvH2nz9aUMsNvIhyiKnwUJiOoVwkFd" +
       "yd5FVnTKr8pE5pHbcXkI9Knzv0opxidd3TvfdslD22V+JNsd/oi2S5aSGL6a" +
       "7c5v08YXBXdku8Pb2a5wYFWl7b3rTmwvK47I3fxtT/FxwqO3fDq4/9xN+cKL" +
       "V+5944uLf7dPnQ4/SbuPrtyrJ7Z98iz5ifvLfqjpVinf+/Yny/0S9nvjyk+d" +
       "q9y4cqn4KRBfeM+eXgJr+ln0IFMA5UlKNa5cPU0JVuXy9ySdEVfuP6YDycj+" +
       "5iTJGowOSIrbjX9ok/UzYR+mT9fPSJ+yvXU8etLny6Xw4VdT14kd8NM3pcTl" +
       "V6CHe8xkcnDA7eUXqfHPf6f1S/sPeRRbyvNilHtB9rr/puggez19WO7kaIdj" +
       "XR4++/2HfuW+Zw731A/tAR/HnxPY3nz2lzK448flty35P33jP37n33vx98uD" +
       "8f8P4RDc+J47AAA=");
}
