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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL0ZC3BU1fVmE0LIP+ErnwAhSAO6K1RbMfgJgUBwgS3BdAxg" +
       "eHl7d/eRt+8937ubbLBYdaYj/VFL8dNWmU6L4gfFcXTqp1qsUz+jdUa0VeuI" +
       "VjutnzLCOH5G29pz7n1v32+z6KDNzLt5e+85597zP+e+A0fJOMskLVRjUTZq" +
       "UCu6UmMJybRoskuVLGsjzA3I15dL71/y1rqlEVLZT+ozkrVWlizarVA1afWT" +
       "WYpmMUmTqbWO0iRiJExqUXNYYoqu9ZPJitWTNVRFVthaPUkRoE8y46RJYsxU" +
       "BnOM9tgEGJkVh5PE+ElincHljjiplXVj1AWf5gHv8qwgZNbdy2KkMb5NGpZi" +
       "OaaosbhisY68SRYZujqaVnUWpXkW3aaeZYtgTfyskAha72748NNrMo1cBBMl" +
       "TdMZZ8/aQC1dHabJOGlwZ1eqNGtdSi4n5XFS4wFmpC3ubBqDTWOwqcOtCwWn" +
       "r6NaLtulc3aYQ6nSkPFAjMz1EzEkU8raZBL8zEChitm8c2Tgdk6BW8FliMVr" +
       "F8X2XH9J4z3lpKGfNChaLx5HhkMw2KQfBEqzg9S0OpNJmuwnTRoou5eaiqQq" +
       "221NN1tKWpNYDtTviAUncwY1+Z6urECPwJuZk5luFthLcYOyf41LqVIaeJ3i" +
       "8io47MZ5YLBagYOZKQnszkapGFK0JCOzgxgFHtsuBABAHZ+lLKMXtqrQJJgg" +
       "zcJEVElLx3rB9LQ0gI7TwQBNRqaPSRRlbUjykJSmA2iRAbiEWAKoCVwQiMLI" +
       "5CAYpwRamh7Qkkc/R9ct23WZtlqLkDI4c5LKKp6/BpBaAkgbaIqaFPxAINYu" +
       "jF8nTXl4Z4QQAJ4cABYwv/3O8QtOazn0pICZUQRm/eA2KrMBed9g/XMzu9qX" +
       "luMxqgzdUlD5Ps65lyXslY68ARFmSoEiLkadxUMbHr/4itvpuxFS3UMqZV3N" +
       "ZcGOmmQ9aygqNVdRjZoSo8keMoFqyS6+3kPGw3tc0aiYXZ9KWZT1kAqVT1Xq" +
       "/DeIKAUkUETV8K5oKd15NySW4e95gxAyHh5SC88CIv74f0aSsYyepTFJljRF" +
       "02MJU0f+rRhEnEGQbSY2CFY/FLP0nAkmGNPNdEwCO8hQewGchmoW8BizhtNg" +
       "tfrIyjxbpY4ambg0ClYVRWsz/k/75JHfiSNlZaCKmcFAoIIPrdbVJDUH5D25" +
       "5SuP3zXwtDAydAxbUowshq2jYuso3zpa2DoKW0fDW5OyMr7jJDyCUDyobQgC" +
       "AETg2vbeLWu27mwtB4szRipA5gja6stEXW6UcEL7gHywuW773COLH4uQijhp" +
       "lmSWk1RMLJ1mGkKWPGR7de0g5Cg3VczxpArMcaYu0yREqrFShk2lSh+mJs4z" +
       "MslDwUlk6LKxsdNI0fOTQzeMXNn33TMiJOLPDrjlOAhsiJ7AmF6I3W3BqFCM" +
       "bsPVb3148LoduhsffOnGyZIhTOShNWgTQfEMyAvnSPcNPLyjjYt9AsRvJoG/" +
       "QWhsCe7hCz8dTihHXqqA4ZRuZiUVlxwZV7OMqY+4M9xYm/j7JDCLGvTHWfC0" +
       "2w7K/+PqFAPHqcK40c4CXPBUcW6vcdNLz779dS5uJ6s0eMqBXso6PJEMiTXz" +
       "mNXkmu1Gk1KAe/WGxM+uPXr1Jm6zADGv2IZtOHZBBAMVgpi/9+SlL792ZN8L" +
       "EdfOGaTy3CBURPkCkzhPqkswCbud6p4HIqEKUQKtpu0iDexTSSnSoErRsf7d" +
       "MH/xff/a1SjsQIUZx4xOOzEBd/6U5eSKpy/5qIWTKZMxE7syc8FEeJ/oUu40" +
       "TWkUz5G/8vCsnz8h3QSJAoKzpWynPN5WcBlUcM6nMTKfY2KJES0UfMmuDMhO" +
       "hsTbwygXor9GRe/rzQ1ajO8lEtjmmsd/b/3mH/eIBNZaBDiQFW/dXyW/kn38" +
       "7wLhlCIIAm7yrbEf97247RluP1UYVHAeT1/nCRkQfDzG21jQaz2qsQmeC2y9" +
       "XiCyy6aTj/oxaYTF0lTPQo3BMhCc0izjJJWvknwelDF/7Jjn0cneW+Y9+929" +
       "8/4GJtRPqhQL4irIqUiV48E5duC1dw/XzbqLh5kKFLctan95GK7+fEUd10ID" +
       "DsvyVnFzSJhKFhx+2DaHJYmt8s62BDcHxDtHqPAz+CuD57/4oOpwQqiwucuu" +
       "UuYUyhTDwN3aS/QV/k1jO5pfG7rxrTuFDQbLuAAw3bnnB59Fd+0Rfi1q3Xmh" +
       "ctOLI+pdYZE4rMDTzS21C8fo/ufBHQ/duuNqcapmf+W2EhqTO//yn2eiN7z+" +
       "VJEioVyx+5UzMdAV0vokvwIEQyu+3/C7a5rLu0HVPaQqpymX5mhP0ksRtGrl" +
       "Bj3+5tbQfMLLGioGKo6FqIPwAWb66greurqp7fbnv/nn/T+9bkQwXEJ9Abxp" +
       "n6xXB69642Muh1AmL6LRAH5/7MCN07vOe5fjuykVsdvy4UIN3MfFXXJ79oNI" +
       "a+UfI2R8P2mU7VaxT1JzmKj6wUEsp3+EdtK37m91RF3fUSgZZgZNyrNtMJl7" +
       "NVXBfFppEs5XRnj6uphjLODjQhxO55qJ4GuUAVFFk1SOtwKSo8qDDf7qwaHT" +
       "o9GIwHOyh8g7yAd0SrpGMYU5a6LqVPRooUuFxWK2MctnG2t5GHEF/Wr97jcf" +
       "aEsv/yLlJs61nKCgxN+zQcsLxza34FGeuOqd6RvPy2z9ApXj7IANBUnetvbA" +
       "U6tOlXdHeCMsLCDUQPuROvx6rzYpdPya3yfnCe1z7QnV47CIK5j/PqOgB8L1" +
       "IILuUIm1LA4ZsBUZFS3sogS4EZrFOmV28QpoZdZgvGbZfv/Ue5ft33uEF2tG" +
       "ngStBX8m8o6FTebUIE9GMU9CUwvBb8kKZ3V2YTUFnh3thmEDtKvUtK9U+DHP" +
       "KsHCdhzmW97y328injujAfmaF47V9R175HgoGPmr3bWS0eE66KmYEaYG27PV" +
       "kpUBuDMPrdvcqB76lKfvGkmGXGutN4GBvK82tqHHjf/ro49N2fpcOYl0k2pV" +
       "l5LdEm8zyASo76mVgQ4zb5xv10EjVTA0clZJiPmw6nDCssPADC+UsKtCucX/" +
       "KoPNvLeM9lEA3x/rvoVnwn1X7dmbXH/zYqcouJABM7pxukqHqeohVc7fk4Vj" +
       "NCP5s+EZto/BircsJYNipcUv4AI9QpNDrQjVgC2Ve852doHKHETqgOewTeWw" +
       "IHWy9xDpYRYzuX1TE+/PdKhQ0hvBYBMSr9W+rPuOz7WPENr5OOwpuOvnbDWC" +
       "CQJ/9wpKdjb7ZSnF4bBZpDIcthTS2PXhNIY/B3CQwnmJW5TYlmPjoJSIFr8u" +
       "sbYPh1/hoImTlIC9ZUzvGysa+jKo225JI9yZoDVb0Dilben7rXaVWwTWc8u5" +
       "66EH+/sXNMqOyy31t1LoWbfZhnubMNzNJ2lQgJaNMSiCoRjaqGRpEm/v8ZC2" +
       "wX6l9Hn89dUfrtzuGFI73zv7lnOF3OaOkQRc+Ae+9fpzN20/eECU5ViPMLJo" +
       "rO8N4Y8ceA9Uoq/z6OiDVeccevvNvi2OjupxOFDws3pvPhG3D/cWNx0c7+Dj" +
       "7hIWeT8OP2SkCV3326ZkoLd3ZXKaKBe6ua+J3dcwUjGsKyISX4bDj8TC5SeV" +
       "eIqF99OBi08EzbKPv3B4x+En4dAuKBWhWCK0g8RnFC1E2rohCzMHpv0E17cb" +
       "aBpee7SUzjGWe6QakDC0AA7dkEY550+UUOZhHB5l5JSckYSWuY+akOMktVNV" +
       "0pq4yUeAB10F/uGrUuAS0EW5oBkp+7IUKCgVoRgQSeAW7Gsh5UCaE3Xjqr6N" +
       "/Eq9j2I1hfA5HLpc3zlSQtxv4PASIzUqv5HnXhMQ8MtfhoDz0FSGPwBgyT0t" +
       "9N1RfCuT79rbUDV170Uvipse53tWLbRIqZyqejtLz3ulYdKUwlmrFWWswf+9" +
       "w0hLaQNn4C7DonN9W+AcZWT62DhQ6hXevVjHGGkMYoFP8P9euPcZqXbhoJwT" +
       "L16QD+FMAIKvHxmFKqWoKfCqxSPZfFm4FubanHwibXqK33m+aM8/IzuZOZew" +
       "k8rBvWvWXXb8GzeL63NZlbbztqQmTsaLm/xCqzl3TGoOrcrV7Z/W3z1hvpM3" +
       "msSBXV+b4bFcC2KKgQY0PXC3bLUVrphf3rfskT/trDwMGW8TKZMYmbgpfLOR" +
       "N3JQoWyKh6+goC3nl94d7b8YPe+01Huv8LaPhG6MgvAD8gv7tzy/e9q+lgip" +
       "6SHjoFOgeX7lsmJU20DlYbOf1CnWyjwcEagokuq736pHW5fwAzOXiy3OusIs" +
       "fnxhpDV8tRf+ZAV91gg1l+s5jZeKddD5uTPOlYOvW88ZRgDBnfHcna4XIV9U" +
       "WOUD8bWG4dx8Vs80uNMnxszpZdX8Fd9q/geWnalkYiIAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "789CTU5BxhSntiq7hGub/v7uVtHh1045");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("/BvfK4frgFlX97AHV/4COXzhtsUPXeIecGT7U7CeMC/vQYEMNA3KI+Hbpae5" +
       "oNXPFpN795nZXn0DrX7tHnz+/aL4tyn0sFtevir1+QJnv/zdcHabQo9fvtNV" +
       "XFB5+6WrpPvrj+oXXr7x4Nte5v/9/vLH8RXFh2joQSNz3bPHzWfq18JYN+yS" +
       "hIf2R3Zh+fd6Cj11b/1Mgbav98fZX93D/EEKPXF3GBDBT+pnof5bCt28CAXU" +
       "u/w/2+/rKXT9tF8KXdtXznb5BpgT6FJU/yg8uZZzR0Upr+mc4ez2yvkE5URq" +
       "j7+R1M7kNM+ec9rlzeDjk+uMO4oNX3x5OP7Jbzc/t7/EpbpynhejPEhDD+zv" +
       "k52cfr/zrqMdj3Wt//x3Hv2Vh547dv+P7id8amRn5vb0nW9MUV6Ylnec8n/y" +
       "tl977y++/NXySPD/Au1YnJqyLQAA");
}
