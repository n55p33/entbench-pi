package org.apache.batik.extension.svg;
public class FlowExtGlyphLayout extends org.apache.batik.gvt.text.GlyphLayout {
    public FlowExtGlyphLayout(java.text.AttributedCharacterIterator aci, int[] charMap,
                              java.awt.geom.Point2D offset,
                              java.awt.font.FontRenderContext frc) {
        super(
          aci,
          charMap,
          offset,
          frc);
    }
    public static void textWrapTextChunk(java.text.AttributedCharacterIterator[] acis,
                                         java.util.List chunkLayouts,
                                         java.util.List flowRects) {
        org.apache.batik.gvt.font.GVTGlyphVector[] gvs =
          new org.apache.batik.gvt.font.GVTGlyphVector[acis.
                                                         length];
        java.util.List[] chunkLineInfos =
          new java.util.List[acis.
                               length];
        org.apache.batik.extension.svg.GlyphIterator[] gis =
          new org.apache.batik.extension.svg.GlyphIterator[acis.
                                                             length];
        java.util.Iterator clIter =
          chunkLayouts.
          iterator(
            );
        java.util.Iterator flowRectsIter =
          flowRects.
          iterator(
            );
        org.apache.batik.extension.svg.RegionInfo currentRegion =
          null;
        float y0;
        float x0;
        float width;
        float height =
          0;
        if (flowRectsIter.
              hasNext(
                )) {
            currentRegion =
              (org.apache.batik.extension.svg.RegionInfo)
                flowRectsIter.
                next(
                  );
            height =
              (float)
                currentRegion.
                getHeight(
                  );
        }
        boolean lineHeightRelative =
          true;
        float lineHeight =
          1.0F;
        float nextLineMult =
          0.0F;
        float dy =
          0.0F;
        java.awt.geom.Point2D.Float verticalAlignOffset =
          new java.awt.geom.Point2D.Float(
          0,
          0);
        float prevBotMargin =
          0;
        for (int chunk =
               0;
             clIter.
               hasNext(
                 );
             chunk++) {
            java.text.AttributedCharacterIterator aci =
              acis[chunk];
            if (currentRegion !=
                  null) {
                java.util.List extraP =
                  (java.util.List)
                    aci.
                    getAttribute(
                      FLOW_EMPTY_PARAGRAPH);
                if (extraP !=
                      null) {
                    java.util.Iterator epi =
                      extraP.
                      iterator(
                        );
                    while (epi.
                             hasNext(
                               )) {
                        org.apache.batik.extension.svg.MarginInfo emi =
                          (org.apache.batik.extension.svg.MarginInfo)
                            epi.
                            next(
                              );
                        float inc =
                          prevBotMargin >
                          emi.
                          getTopMargin(
                            )
                          ? prevBotMargin
                          : emi.
                          getTopMargin(
                            );
                        if (dy +
                              inc <=
                              height &&
                              !emi.
                              isFlowRegionBreak(
                                )) {
                            dy +=
                              inc;
                            prevBotMargin =
                              emi.
                                getBottomMargin(
                                  );
                        }
                        else {
                            if (!flowRectsIter.
                                  hasNext(
                                    )) {
                                currentRegion =
                                  null;
                                break;
                            }
                            currentRegion =
                              (org.apache.batik.extension.svg.RegionInfo)
                                flowRectsIter.
                                next(
                                  );
                            height =
                              (float)
                                currentRegion.
                                getHeight(
                                  );
                            verticalAlignOffset =
                              new java.awt.geom.Point2D.Float(
                                0,
                                0);
                            dy =
                              0;
                            prevBotMargin =
                              0;
                        }
                    }
                    if (currentRegion ==
                          null)
                        break;
                }
            }
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
            int numGlyphs =
              gv.
              getNumGlyphs(
                );
            aci.
              first(
                );
            org.apache.batik.extension.svg.MarginInfo mi =
              (org.apache.batik.extension.svg.MarginInfo)
                aci.
                getAttribute(
                  FLOW_PARAGRAPH);
            if (mi ==
                  null) {
                continue;
            }
            if (currentRegion ==
                  null) {
                for (int idx =
                       0;
                     idx <
                       numGlyphs;
                     idx++)
                    gv.
                      setGlyphVisible(
                        idx,
                        false);
                continue;
            }
            float inc =
              prevBotMargin >
              mi.
              getTopMargin(
                )
              ? prevBotMargin
              : mi.
              getTopMargin(
                );
            if (dy +
                  inc <=
                  height) {
                dy +=
                  inc;
            }
            else {
                if (!flowRectsIter.
                      hasNext(
                        )) {
                    currentRegion =
                      null;
                    break;
                }
                currentRegion =
                  (org.apache.batik.extension.svg.RegionInfo)
                    flowRectsIter.
                    next(
                      );
                height =
                  (float)
                    currentRegion.
                    getHeight(
                      );
                verticalAlignOffset =
                  new java.awt.geom.Point2D.Float(
                    0,
                    0);
                dy =
                  mi.
                    getTopMargin(
                      );
            }
            prevBotMargin =
              mi.
                getBottomMargin(
                  );
            float leftMargin =
              mi.
              getLeftMargin(
                );
            float rightMargin =
              mi.
              getRightMargin(
                );
            if (((org.apache.batik.gvt.text.GlyphLayout)
                   layouts.
                   get(
                     0)).
                  isLeftToRight(
                    )) {
                leftMargin +=
                  mi.
                    getIndent(
                      );
            }
            else {
                rightMargin +=
                  mi.
                    getIndent(
                      );
            }
            x0 =
              (float)
                currentRegion.
                getX(
                  ) +
                leftMargin;
            y0 =
              (float)
                currentRegion.
                getY(
                  );
            width =
              (float)
                (currentRegion.
                   getWidth(
                     ) -
                   (leftMargin +
                      rightMargin));
            height =
              (float)
                currentRegion.
                getHeight(
                  );
            java.util.List lineInfos =
              new java.util.LinkedList(
              );
            chunkLineInfos[chunk] =
              lineInfos;
            float prevDesc =
              0.0F;
            org.apache.batik.extension.svg.GlyphIterator gi =
              new org.apache.batik.extension.svg.GlyphIterator(
              aci,
              gv);
            gis[chunk] =
              gi;
            org.apache.batik.extension.svg.GlyphIterator breakGI =
              null;
            org.apache.batik.extension.svg.GlyphIterator newBreakGI =
              null;
            if (!gi.
                  done(
                    ) &&
                  !gi.
                  isPrinting(
                    )) {
                updateVerticalAlignOffset(
                  verticalAlignOffset,
                  currentRegion,
                  dy);
                lineInfos.
                  add(
                    gi.
                      newLine(
                        new java.awt.geom.Point2D.Float(
                          x0,
                          y0 +
                            dy),
                        width,
                        true,
                        verticalAlignOffset));
            }
            org.apache.batik.extension.svg.GlyphIterator lineGI =
              gi.
              copy1(
                );
            boolean firstLine =
              true;
            while (!gi.
                     done(
                       )) {
                boolean doBreak =
                  false;
                boolean partial =
                  false;
                if (gi.
                      isPrinting(
                        ) &&
                      gi.
                      getAdv(
                        ) >
                      width) {
                    if (breakGI ==
                          null) {
                        if (!flowRectsIter.
                              hasNext(
                                )) {
                            currentRegion =
                              null;
                            gi =
                              lineGI.
                                copy1(
                                  gi);
                            break;
                        }
                        currentRegion =
                          (org.apache.batik.extension.svg.RegionInfo)
                            flowRectsIter.
                            next(
                              );
                        x0 =
                          (float)
                            currentRegion.
                            getX(
                              ) +
                            leftMargin;
                        y0 =
                          (float)
                            currentRegion.
                            getY(
                              );
                        width =
                          (float)
                            (currentRegion.
                               getWidth(
                                 ) -
                               (leftMargin +
                                  rightMargin));
                        height =
                          (float)
                            currentRegion.
                            getHeight(
                              );
                        verticalAlignOffset =
                          new java.awt.geom.Point2D.Float(
                            0,
                            0);
                        dy =
                          firstLine
                            ? mi.
                            getTopMargin(
                              )
                            : 0;
                        prevDesc =
                          0;
                        gi =
                          lineGI.
                            copy1(
                              gi);
                        continue;
                    }
                    gi =
                      breakGI.
                        copy1(
                          gi);
                    nextLineMult =
                      1;
                    doBreak =
                      true;
                    partial =
                      false;
                }
                else
                    if (gi.
                          isLastChar(
                            )) {
                        nextLineMult =
                          1;
                        doBreak =
                          true;
                        partial =
                          true;
                    }
                int lnBreaks =
                  gi.
                  getLineBreaks(
                    );
                if (lnBreaks !=
                      0) {
                    if (doBreak)
                        nextLineMult -=
                          1;
                    nextLineMult +=
                      lnBreaks;
                    doBreak =
                      true;
                    partial =
                      true;
                }
                if (!doBreak) {
                    if (gi.
                          isBreakChar(
                            ) ||
                          breakGI ==
                          null ||
                          !breakGI.
                          isBreakChar(
                            )) {
                        newBreakGI =
                          gi.
                            copy1(
                              newBreakGI);
                        gi.
                          nextChar(
                            );
                        if (gi.
                              getChar(
                                ) !=
                              org.apache.batik.extension.svg.GlyphIterator.
                                ZERO_WIDTH_JOINER) {
                            org.apache.batik.extension.svg.GlyphIterator tmpGI =
                              breakGI;
                            breakGI =
                              newBreakGI;
                            newBreakGI =
                              tmpGI;
                        }
                    }
                    else {
                        gi.
                          nextChar(
                            );
                    }
                    continue;
                }
                float lineSize =
                  gi.
                  getMaxAscent(
                    ) +
                  gi.
                  getMaxDescent(
                    );
                float lineBoxHeight;
                if (lineHeightRelative)
                    lineBoxHeight =
                      gi.
                        getMaxFontSize(
                          ) *
                        lineHeight;
                else
                    lineBoxHeight =
                      lineHeight;
                float halfLeading =
                  (lineBoxHeight -
                     lineSize) /
                  2;
                float ladv =
                  prevDesc +
                  halfLeading +
                  gi.
                  getMaxAscent(
                    );
                float newDesc =
                  halfLeading +
                  gi.
                  getMaxDescent(
                    );
                dy +=
                  ladv;
                float bottomEdge =
                  newDesc;
                if (newDesc <
                      gi.
                      getMaxDescent(
                        ))
                    bottomEdge =
                      gi.
                        getMaxDescent(
                          );
                if (dy +
                      bottomEdge >
                      height) {
                    if (!flowRectsIter.
                          hasNext(
                            )) {
                        currentRegion =
                          null;
                        gi =
                          lineGI.
                            copy1(
                              gi);
                        break;
                    }
                    float oldWidth =
                      width;
                    currentRegion =
                      (org.apache.batik.extension.svg.RegionInfo)
                        flowRectsIter.
                        next(
                          );
                    x0 =
                      (float)
                        currentRegion.
                        getX(
                          ) +
                        leftMargin;
                    y0 =
                      (float)
                        currentRegion.
                        getY(
                          );
                    width =
                      (float)
                        (currentRegion.
                           getWidth(
                             ) -
                           (leftMargin +
                              rightMargin));
                    height =
                      (float)
                        currentRegion.
                        getHeight(
                          );
                    verticalAlignOffset =
                      new java.awt.geom.Point2D.Float(
                        0,
                        0);
                    dy =
                      firstLine
                        ? mi.
                        getTopMargin(
                          )
                        : 0;
                    prevDesc =
                      0;
                    if (oldWidth >
                          width ||
                          lnBreaks !=
                          0) {
                        gi =
                          lineGI.
                            copy1(
                              gi);
                    }
                    continue;
                }
                prevDesc =
                  newDesc +
                    (nextLineMult -
                       1) *
                    lineBoxHeight;
                nextLineMult =
                  0.0F;
                updateVerticalAlignOffset(
                  verticalAlignOffset,
                  currentRegion,
                  dy +
                    bottomEdge);
                lineInfos.
                  add(
                    gi.
                      newLine(
                        new java.awt.geom.Point2D.Float(
                          x0,
                          y0 +
                            dy),
                        width,
                        partial,
                        verticalAlignOffset));
                x0 -=
                  leftMargin;
                width +=
                  leftMargin +
                    rightMargin;
                leftMargin =
                  mi.
                    getLeftMargin(
                      );
                rightMargin =
                  mi.
                    getRightMargin(
                      );
                x0 +=
                  leftMargin;
                width -=
                  leftMargin +
                    rightMargin;
                firstLine =
                  false;
                lineGI =
                  gi.
                    copy1(
                      lineGI);
                breakGI =
                  null;
            }
            dy +=
              prevDesc;
            int idx =
              gi.
              getGlyphIndex(
                );
            while (idx <
                     numGlyphs)
                gv.
                  setGlyphVisible(
                    idx++,
                    false);
            if (mi.
                  isFlowRegionBreak(
                    )) {
                currentRegion =
                  null;
                if (flowRectsIter.
                      hasNext(
                        )) {
                    currentRegion =
                      (org.apache.batik.extension.svg.RegionInfo)
                        flowRectsIter.
                        next(
                          );
                    height =
                      (float)
                        currentRegion.
                        getHeight(
                          );
                    dy =
                      0;
                    prevBotMargin =
                      0;
                    verticalAlignOffset =
                      new java.awt.geom.Point2D.Float(
                        0,
                        0);
                }
            }
        }
        for (int chunk =
               0;
             chunk <
               acis.
                 length;
             chunk++) {
            java.util.List lineInfos =
              chunkLineInfos[chunk];
            if (lineInfos ==
                  null)
                continue;
            java.text.AttributedCharacterIterator aci =
              acis[chunk];
            aci.
              first(
                );
            org.apache.batik.extension.svg.MarginInfo mi =
              (org.apache.batik.extension.svg.MarginInfo)
                aci.
                getAttribute(
                  FLOW_PARAGRAPH);
            if (mi ==
                  null) {
                continue;
            }
            int justification =
              mi.
              getJustification(
                );
            org.apache.batik.gvt.font.GVTGlyphVector gv =
              gvs[chunk];
            if (gv ==
                  null)
                break;
            org.apache.batik.extension.svg.GlyphIterator gi =
              gis[chunk];
            layoutChunk(
              gv,
              gi.
                getOrigin(
                  ),
              justification,
              lineInfos);
        }
    }
    public static void updateVerticalAlignOffset(java.awt.geom.Point2D.Float verticalAlignOffset,
                                                 org.apache.batik.extension.svg.RegionInfo region,
                                                 float maxDescent) {
        float freeSpace =
          (float)
            region.
            getHeight(
              ) -
          maxDescent;
        verticalAlignOffset.
          setLocation(
            0,
            region.
              getVerticalAlignment(
                ) *
              freeSpace);
    }
    public static void layoutChunk(org.apache.batik.gvt.font.GVTGlyphVector gv,
                                   java.awt.geom.Point2D origin,
                                   int justification,
                                   java.util.List lineInfos) {
        java.util.Iterator lInfoIter =
          lineInfos.
          iterator(
            );
        int numGlyphs =
          gv.
          getNumGlyphs(
            );
        float[] gp =
          gv.
          getGlyphPositions(
            0,
            numGlyphs +
              1,
            null);
        java.awt.geom.Point2D.Float lineLoc =
          null;
        float lineAdv =
          0;
        float lineVAdv =
          0;
        float xOrig =
          (float)
            origin.
            getX(
              );
        float yOrig =
          (float)
            origin.
            getY(
              );
        float xScale =
          1;
        float xAdj =
          0;
        float charW =
          0;
        float lineWidth =
          0;
        boolean partial =
          false;
        float verticalAlignOffset =
          0;
        int lineEnd =
          0;
        int i;
        java.awt.geom.Point2D.Float pos =
          new java.awt.geom.Point2D.Float(
          );
        for (i =
               0;
             i <
               numGlyphs;
             i++) {
            if (i ==
                  lineEnd) {
                xOrig +=
                  lineAdv;
                if (!lInfoIter.
                      hasNext(
                        ))
                    break;
                org.apache.batik.extension.svg.LineInfo li =
                  (org.apache.batik.extension.svg.LineInfo)
                    lInfoIter.
                    next(
                      );
                lineEnd =
                  li.
                    getEndIdx(
                      );
                lineLoc =
                  li.
                    getLocation(
                      );
                lineAdv =
                  li.
                    getAdvance(
                      );
                lineVAdv =
                  li.
                    getVisualAdvance(
                      );
                charW =
                  li.
                    getLastCharWidth(
                      );
                lineWidth =
                  li.
                    getLineWidth(
                      );
                partial =
                  li.
                    isPartialLine(
                      );
                verticalAlignOffset =
                  li.
                    getVerticalAlignOffset(
                      ).
                    y;
                xAdj =
                  0;
                xScale =
                  1;
                switch (justification) {
                    case 0:
                    default:
                        break;
                    case 1:
                        xAdj =
                          (lineWidth -
                             lineVAdv) /
                            2;
                        break;
                    case 2:
                        xAdj =
                          lineWidth -
                            lineVAdv;
                        break;
                    case 3:
                        if (!partial &&
                              lineEnd !=
                              i +
                              1) {
                            xScale =
                              (lineWidth -
                                 charW) /
                                (lineVAdv -
                                   charW);
                        }
                        break;
                }
            }
            pos.
              x =
              lineLoc.
                x +
                (gp[2 *
                      i] -
                   xOrig) *
                xScale +
                xAdj;
            pos.
              y =
              lineLoc.
                y +
                (gp[2 *
                      i +
                      1] -
                   yOrig +
                   verticalAlignOffset);
            gv.
              setGlyphPosition(
                i,
                pos);
        }
        pos.
          x =
          xOrig;
        pos.
          y =
          yOrig;
        if (lineLoc !=
              null) {
            pos.
              x =
              lineLoc.
                x +
                (gp[2 *
                      i] -
                   xOrig) *
                xScale +
                xAdj;
            pos.
              y =
              lineLoc.
                y +
                (gp[2 *
                      i +
                      1] -
                   yOrig) +
                verticalAlignOffset;
        }
        gv.
          setGlyphPosition(
            i,
            pos);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "P/ZkMVI4JYgMSbQwy9Cc/dmtYsCvnUr4");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("N75XCdeBsK7uYQ+u/AVK+MJpix+6JD0QyPa7YAS3KM9BcUqxN1SMv11GmgtW" +
       "/WxB3LvPUHv1Daz6tXvI+feL5t9E0MNWefiqtOcLkv3ydyPZLIIev3ymqzig" +
       "8vZLR0n3xx+lL7x848G3vbz8d/vDH8dHFB+ioAfV2LLObjefub/mBYpqlCw8" +
       "tN+y88q/1yPoqXvbZwSsPdlvZ391D/MHEfTE3WFABj+5Pwv1XyPo5kUoYN7l" +
       "/9lxX4+g66fjIuja/ubskG8AmsCQ4vaPvJNjOXc0lPKYzhnJZlfOFygnWnv8" +
       "jbR2pqZ59lzQLk8GH+9cx7Oj3PDFl8fTn/p283P7Q1ySJe52xSwPUtAD+/Nk" +
       "J7vf77zrbMdzXRs+/51Hf+Wh547D/6N7gk+d7AxtT9/5xFTf9qLyjNPuH7/t" +
       "1977iy9/tdwS/L/1KlTXsi0AAA==");
}
