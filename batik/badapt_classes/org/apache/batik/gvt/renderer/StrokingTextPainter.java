package org.apache.batik.gvt.renderer;
public class StrokingTextPainter extends org.apache.batik.gvt.renderer.BasicTextPainter {
    public static final java.text.AttributedCharacterIterator.Attribute PAINT_INFO =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        PAINT_INFO;
    public static final java.text.AttributedCharacterIterator.Attribute
      FLOW_REGIONS =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        FLOW_REGIONS;
    public static final java.text.AttributedCharacterIterator.Attribute
      FLOW_PARAGRAPH =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        FLOW_PARAGRAPH;
    public static final java.text.AttributedCharacterIterator.Attribute
      TEXT_COMPOUND_ID =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        TEXT_COMPOUND_ID;
    public static final java.text.AttributedCharacterIterator.Attribute
      GVT_FONT =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        GVT_FONT;
    public static final java.text.AttributedCharacterIterator.Attribute
      GVT_FONTS =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        GVT_FONTS;
    public static final java.text.AttributedCharacterIterator.Attribute
      BIDI_LEVEL =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        BIDI_LEVEL;
    public static final java.text.AttributedCharacterIterator.Attribute
      XPOS =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        X;
    public static final java.text.AttributedCharacterIterator.Attribute
      YPOS =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        Y;
    public static final java.text.AttributedCharacterIterator.Attribute
      TEXTPATH =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        TEXTPATH;
    public static final java.text.AttributedCharacterIterator.Attribute
      WRITING_MODE =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        WRITING_MODE;
    public static final java.lang.Integer WRITING_MODE_TTB = org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                                                               WRITING_MODE_TTB;
    public static final java.lang.Integer WRITING_MODE_RTL =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        WRITING_MODE_RTL;
    public static final java.text.AttributedCharacterIterator.Attribute
      ANCHOR_TYPE =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        ANCHOR_TYPE;
    public static final java.lang.Integer ADJUST_SPACING =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        ADJUST_SPACING;
    public static final java.lang.Integer ADJUST_ALL = org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                                                         ADJUST_ALL;
    public static final org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute
      ALT_GLYPH_HANDLER =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        ALT_GLYPH_HANDLER;
    static java.util.Set extendedAtts = new java.util.HashSet(
      );
    static { extendedAtts.add(FLOW_PARAGRAPH);
             extendedAtts.add(TEXT_COMPOUND_ID);
             extendedAtts.add(GVT_FONT); }
    protected static org.apache.batik.gvt.TextPainter
      singleton =
      new org.apache.batik.gvt.renderer.StrokingTextPainter(
      );
    public static org.apache.batik.gvt.TextPainter getInstance() {
        return singleton;
    }
    public void paint(org.apache.batik.gvt.TextNode node,
                      java.awt.Graphics2D g2d) {
        java.text.AttributedCharacterIterator aci;
        aci =
          node.
            getAttributedCharacterIterator(
              );
        if (aci ==
              null)
            return;
        java.util.List textRuns =
          getTextRuns(
            node,
            aci);
        paintDecorations(
          textRuns,
          g2d,
          org.apache.batik.gvt.text.TextSpanLayout.
            DECORATION_UNDERLINE);
        paintDecorations(
          textRuns,
          g2d,
          org.apache.batik.gvt.text.TextSpanLayout.
            DECORATION_OVERLINE);
        paintTextRuns(
          textRuns,
          g2d);
        paintDecorations(
          textRuns,
          g2d,
          org.apache.batik.gvt.text.TextSpanLayout.
            DECORATION_STRIKETHROUGH);
    }
    protected void printAttrs(java.text.AttributedCharacterIterator aci) {
        aci.
          first(
            );
        int start =
          aci.
          getBeginIndex(
            );
        java.lang.System.
          out.
          print(
            "AttrRuns: ");
        while (aci.
                 current(
                   ) !=
                 java.text.CharacterIterator.
                   DONE) {
            int end =
              aci.
              getRunLimit(
                );
            java.lang.System.
              out.
              print(
                "" +
                (end -
                   start) +
                ", ");
            aci.
              setIndex(
                end);
            start =
              end;
        }
        java.lang.System.
          out.
          println(
            "");
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
        node.
          setTextRuns(
            textRuns);
        return node.
          getTextRuns(
            );
    }
    public java.util.List computeTextRuns(org.apache.batik.gvt.TextNode node,
                                          java.text.AttributedCharacterIterator aci,
                                          java.text.AttributedCharacterIterator[] chunkACIs) {
        int[][] chunkCharMaps =
          new int[chunkACIs.
                    length][];
        int chunkStart =
          aci.
          getBeginIndex(
            );
        for (int i =
               0;
             i <
               chunkACIs.
                 length;
             i++) {
            org.apache.batik.gvt.text.BidiAttributedCharacterIterator iter;
            iter =
              new org.apache.batik.gvt.text.BidiAttributedCharacterIterator(
                chunkACIs[i],
                fontRenderContext,
                chunkStart);
            chunkACIs[i] =
              iter;
            chunkCharMaps[i] =
              iter.
                getCharMap(
                  );
            chunkACIs[i] =
              createModifiedACIForFontMatching(
                chunkACIs[i]);
            chunkStart +=
              chunkACIs[i].
                getEndIndex(
                  ) -
                chunkACIs[i].
                getBeginIndex(
                  );
        }
        java.util.List textRuns =
          new java.util.ArrayList(
          );
        org.apache.batik.gvt.renderer.StrokingTextPainter.TextChunk chunk;
        org.apache.batik.gvt.renderer.StrokingTextPainter.TextChunk prevChunk =
          null;
        int currentChunk =
          0;
        java.awt.geom.Point2D location =
          node.
          getLocation(
            );
        do  {
            chunkACIs[currentChunk].
              first(
                );
            chunk =
              getTextChunk(
                node,
                chunkACIs[currentChunk],
                chunkCharMaps[currentChunk],
                textRuns,
                prevChunk);
            chunkACIs[currentChunk].
              first(
                );
            if (chunk !=
                  null) {
                location =
                  adjustChunkOffsets(
                    location,
                    textRuns,
                    chunk);
            }
            prevChunk =
              chunk;
            currentChunk++;
        }while(chunk !=
                 null &&
                 currentChunk <
                 chunkACIs.
                   length); 
        return textRuns;
    }
    protected java.text.AttributedCharacterIterator[] getTextChunkACIs(java.text.AttributedCharacterIterator aci) {
        java.util.List aciList =
          new java.util.ArrayList(
          );
        int chunkStartIndex =
          aci.
          getBeginIndex(
            );
        aci.
          first(
            );
        java.lang.Object writingMode =
          aci.
          getAttribute(
            WRITING_MODE);
        boolean vertical =
          writingMode ==
          WRITING_MODE_TTB;
        while (aci.
                 setIndex(
                   chunkStartIndex) !=
                 java.text.CharacterIterator.
                   DONE) {
            org.apache.batik.gvt.text.TextPath prevTextPath =
              null;
            for (int start =
                   chunkStartIndex,
                   end =
                     0;
                 aci.
                   setIndex(
                     start) !=
                   java.text.CharacterIterator.
                     DONE;
                 start =
                   end) {
                org.apache.batik.gvt.text.TextPath textPath =
                  (org.apache.batik.gvt.text.TextPath)
                    aci.
                    getAttribute(
                      TEXTPATH);
                if (start !=
                      chunkStartIndex) {
                    if (vertical) {
                        java.lang.Float runY =
                          (java.lang.Float)
                            aci.
                            getAttribute(
                              YPOS);
                        if (runY !=
                              null &&
                              !runY.
                              isNaN(
                                ))
                            break;
                    }
                    else {
                        java.lang.Float runX =
                          (java.lang.Float)
                            aci.
                            getAttribute(
                              XPOS);
                        if (runX !=
                              null &&
                              !runX.
                              isNaN(
                                ))
                            break;
                    }
                    if (prevTextPath ==
                          null &&
                          textPath !=
                          null)
                        break;
                    if (prevTextPath !=
                          null &&
                          textPath ==
                          null)
                        break;
                }
                prevTextPath =
                  textPath;
                if (aci.
                      getAttribute(
                        FLOW_PARAGRAPH) !=
                      null) {
                    end =
                      aci.
                        getRunLimit(
                          FLOW_PARAGRAPH);
                    aci.
                      setIndex(
                        end);
                    break;
                }
                end =
                  aci.
                    getRunLimit(
                      TEXT_COMPOUND_ID);
                if (start !=
                      chunkStartIndex)
                    continue;
                org.apache.batik.gvt.TextNode.Anchor anchor;
                anchor =
                  (org.apache.batik.gvt.TextNode.Anchor)
                    aci.
                    getAttribute(
                      ANCHOR_TYPE);
                if (anchor ==
                      org.apache.batik.gvt.TextNode.Anchor.
                        START)
                    continue;
                if (vertical) {
                    java.lang.Float runY =
                      (java.lang.Float)
                        aci.
                        getAttribute(
                          YPOS);
                    if (runY ==
                          null ||
                          runY.
                          isNaN(
                            ))
                        continue;
                }
                else {
                    java.lang.Float runX =
                      (java.lang.Float)
                        aci.
                        getAttribute(
                          XPOS);
                    if (runX ==
                          null ||
                          runX.
                          isNaN(
                            ))
                        continue;
                }
                for (int i =
                       start +
                       1;
                     i <
                       end;
                     i++) {
                    aci.
                      setIndex(
                        i);
                    if (vertical) {
                        java.lang.Float runY =
                          (java.lang.Float)
                            aci.
                            getAttribute(
                              YPOS);
                        if (runY ==
                              null ||
                              runY.
                              isNaN(
                                ))
                            break;
                    }
                    else {
                        java.lang.Float runX =
                          (java.lang.Float)
                            aci.
                            getAttribute(
                              XPOS);
                        if (runX ==
                              null ||
                              runX.
                              isNaN(
                                ))
                            break;
                    }
                    aciList.
                      add(
                        new org.apache.batik.gvt.text.AttributedCharacterSpanIterator(
                          aci,
                          i -
                            1,
                          i));
                    chunkStartIndex =
                      i;
                }
            }
            int chunkEndIndex =
              aci.
              getIndex(
                );
            aciList.
              add(
                new org.apache.batik.gvt.text.AttributedCharacterSpanIterator(
                  aci,
                  chunkStartIndex,
                  chunkEndIndex));
            chunkStartIndex =
              chunkEndIndex;
        }
        java.text.AttributedCharacterIterator[] aciArray =
          new java.text.AttributedCharacterIterator[aciList.
                                                      size(
                                                        )];
        java.util.Iterator iter =
          aciList.
          iterator(
            );
        for (int i =
               0;
             iter.
               hasNext(
                 );
             ++i) {
            aciArray[i] =
              (java.text.AttributedCharacterIterator)
                iter.
                next(
                  );
        }
        return aciArray;
    }
    protected static java.text.AttributedCharacterIterator createModifiedACIForFontMatching(java.text.AttributedCharacterIterator aci) {
        aci.
          first(
            );
        java.text.AttributedString as =
          null;
        int asOff =
          0;
        int begin =
          aci.
          getBeginIndex(
            );
        boolean moreChunks =
          true;
        int start;
        int end =
          aci.
          getRunStart(
            TEXT_COMPOUND_ID);
        while (moreChunks) {
            start =
              end;
            end =
              aci.
                getRunLimit(
                  TEXT_COMPOUND_ID);
            int aciLength =
              end -
              start;
            java.util.List fonts;
            fonts =
              (java.util.List)
                aci.
                getAttribute(
                  GVT_FONTS);
            float fontSize =
              12;
            java.lang.Float fsFloat =
              (java.lang.Float)
                aci.
                getAttribute(
                  java.awt.font.TextAttribute.
                    SIZE);
            if (fsFloat !=
                  null)
                fontSize =
                  fsFloat.
                    floatValue(
                      );
            if (fonts.
                  size(
                    ) ==
                  0) {
                fonts.
                  add(
                    org.apache.batik.gvt.font.FontFamilyResolver.
                      defaultFont.
                      deriveFont(
                        fontSize,
                        aci));
            }
            boolean[] fontAssigned =
              new boolean[aciLength];
            if (as ==
                  null)
                as =
                  new java.text.AttributedString(
                    aci);
            org.apache.batik.gvt.font.GVTFont defaultFont =
              null;
            int numSet =
              0;
            int firstUnset =
              start;
            boolean firstUnsetSet;
            for (int i =
                   0;
                 i <
                   fonts.
                   size(
                     );
                 i++) {
                int currentIndex =
                  firstUnset;
                firstUnsetSet =
                  false;
                aci.
                  setIndex(
                    currentIndex);
                org.apache.batik.gvt.font.GVTFont font =
                  (org.apache.batik.gvt.font.GVTFont)
                    fonts.
                    get(
                      i);
                if (defaultFont ==
                      null)
                    defaultFont =
                      font;
                while (currentIndex <
                         end) {
                    int displayUpToIndex =
                      font.
                      canDisplayUpTo(
                        aci,
                        currentIndex,
                        end);
                    java.lang.Object altGlyphElement;
                    altGlyphElement =
                      aci.
                        getAttribute(
                          ALT_GLYPH_HANDLER);
                    if (altGlyphElement !=
                          null) {
                        displayUpToIndex =
                          -1;
                    }
                    if (displayUpToIndex ==
                          -1) {
                        displayUpToIndex =
                          end;
                    }
                    if (displayUpToIndex <=
                          currentIndex) {
                        if (!firstUnsetSet) {
                            firstUnset =
                              currentIndex;
                            firstUnsetSet =
                              true;
                        }
                        currentIndex++;
                    }
                    else {
                        int runStart =
                          -1;
                        for (int j =
                               currentIndex;
                             j <
                               displayUpToIndex;
                             j++) {
                            if (fontAssigned[j -
                                               start]) {
                                if (runStart !=
                                      -1) {
                                    as.
                                      addAttribute(
                                        GVT_FONT,
                                        font,
                                        runStart -
                                          begin,
                                        j -
                                          begin);
                                    runStart =
                                      -1;
                                }
                            }
                            else {
                                if (runStart ==
                                      -1)
                                    runStart =
                                      j;
                            }
                            fontAssigned[j -
                                           start] =
                              true;
                            numSet++;
                        }
                        if (runStart !=
                              -1) {
                            as.
                              addAttribute(
                                GVT_FONT,
                                font,
                                runStart -
                                  begin,
                                displayUpToIndex -
                                  begin);
                        }
                        currentIndex =
                          displayUpToIndex +
                            1;
                    }
                }
                if (numSet ==
                      aciLength)
                    break;
            }
            int runStart =
              -1;
            org.apache.batik.gvt.font.GVTFontFamily prevFF =
              null;
            org.apache.batik.gvt.font.GVTFont prevF =
              defaultFont;
            for (int i =
                   0;
                 i <
                   aciLength;
                 i++) {
                if (fontAssigned[i]) {
                    if (runStart !=
                          -1) {
                        as.
                          addAttribute(
                            GVT_FONT,
                            prevF,
                            runStart +
                              asOff,
                            i +
                              asOff);
                        runStart =
                          -1;
                        prevF =
                          null;
                        prevFF =
                          null;
                    }
                }
                else {
                    char c =
                      aci.
                      setIndex(
                        start +
                          i);
                    org.apache.batik.gvt.font.GVTFontFamily fontFamily;
                    fontFamily =
                      org.apache.batik.gvt.font.FontFamilyResolver.
                        getFamilyThatCanDisplay(
                          c);
                    if (runStart ==
                          -1) {
                        runStart =
                          i;
                        prevFF =
                          fontFamily;
                        if (prevFF ==
                              null)
                            prevF =
                              defaultFont;
                        else
                            prevF =
                              fontFamily.
                                deriveFont(
                                  fontSize,
                                  aci);
                    }
                    else
                        if (prevFF !=
                              fontFamily) {
                            as.
                              addAttribute(
                                GVT_FONT,
                                prevF,
                                runStart +
                                  asOff,
                                i +
                                  asOff);
                            runStart =
                              i;
                            prevFF =
                              fontFamily;
                            if (prevFF ==
                                  null)
                                prevF =
                                  defaultFont;
                            else
                                prevF =
                                  fontFamily.
                                    deriveFont(
                                      fontSize,
                                      aci);
                        }
                }
            }
            if (runStart !=
                  -1) {
                as.
                  addAttribute(
                    GVT_FONT,
                    prevF,
                    runStart +
                      asOff,
                    aciLength +
                      asOff);
            }
            asOff +=
              aciLength;
            if (aci.
                  setIndex(
                    end) ==
                  java.text.AttributedCharacterIterator.
                    DONE) {
                moreChunks =
                  false;
            }
            start =
              end;
        }
        if (as !=
              null)
            return as.
              getIterator(
                );
        return aci;
    }
    protected org.apache.batik.gvt.renderer.StrokingTextPainter.TextChunk getTextChunk(org.apache.batik.gvt.TextNode node,
                                                                                       java.text.AttributedCharacterIterator aci,
                                                                                       int[] charMap,
                                                                                       java.util.List textRuns,
                                                                                       org.apache.batik.gvt.renderer.StrokingTextPainter.TextChunk prevChunk) {
        int beginChunk =
          0;
        if (prevChunk !=
              null)
            beginChunk =
              prevChunk.
                end;
        int endChunk =
          beginChunk;
        int begin =
          aci.
          getIndex(
            );
        if (aci.
              current(
                ) ==
              java.text.CharacterIterator.
                DONE)
            return null;
        java.awt.geom.Point2D.Float offset =
          new java.awt.geom.Point2D.Float(
          0,
          0);
        java.awt.geom.Point2D.Float advance =
          new java.awt.geom.Point2D.Float(
          0,
          0);
        boolean isChunkStart =
          true;
        org.apache.batik.gvt.text.TextSpanLayout layout =
          null;
        do  {
            int start =
              aci.
              getRunStart(
                extendedAtts);
            int end =
              aci.
              getRunLimit(
                extendedAtts);
            java.text.AttributedCharacterIterator runaci;
            runaci =
              new org.apache.batik.gvt.text.AttributedCharacterSpanIterator(
                aci,
                start,
                end);
            int[] subCharMap =
              new int[end -
                        start];
            java.lang.System.
              arraycopy(
                charMap,
                start -
                  begin,
                subCharMap,
                0,
                subCharMap.
                  length);
            java.awt.font.FontRenderContext frc =
              fontRenderContext;
            java.awt.RenderingHints rh =
              node.
              getRenderingHints(
                );
            if (rh !=
                  null &&
                  rh.
                  get(
                    java.awt.RenderingHints.
                      KEY_TEXT_ANTIALIASING) ==
                  java.awt.RenderingHints.
                    VALUE_TEXT_ANTIALIAS_OFF) {
                frc =
                  aaOffFontRenderContext;
            }
            layout =
              getTextLayoutFactory(
                ).
                createTextLayout(
                  runaci,
                  subCharMap,
                  offset,
                  frc);
            textRuns.
              add(
                new org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun(
                  layout,
                  runaci,
                  isChunkStart));
            java.awt.geom.Point2D layoutAdvance =
              layout.
              getAdvance2D(
                );
            advance.
              x +=
              (float)
                layoutAdvance.
                getX(
                  );
            advance.
              y +=
              (float)
                layoutAdvance.
                getY(
                  );
            ++endChunk;
            if (aci.
                  setIndex(
                    end) ==
                  java.text.CharacterIterator.
                    DONE)
                break;
            isChunkStart =
              false;
        }while(true); 
        return new org.apache.batik.gvt.renderer.StrokingTextPainter.TextChunk(
          beginChunk,
          endChunk,
          advance);
    }
    protected java.awt.geom.Point2D adjustChunkOffsets(java.awt.geom.Point2D location,
                                                       java.util.List textRuns,
                                                       org.apache.batik.gvt.renderer.StrokingTextPainter.TextChunk chunk) {
        org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun r =
          (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
            textRuns.
            get(
              chunk.
                begin);
        int anchorType =
          r.
          getAnchorType(
            );
        java.lang.Float length =
          r.
          getLength(
            );
        java.lang.Integer lengthAdj =
          r.
          getLengthAdjust(
            );
        boolean doAdjust =
          true;
        if (length ==
              null ||
              length.
              isNaN(
                ))
            doAdjust =
              false;
        int numChars =
          0;
        for (int n =
               chunk.
                 begin;
             n <
               chunk.
                 end;
             ++n) {
            r =
              (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
                textRuns.
                get(
                  n);
            java.text.AttributedCharacterIterator aci =
              r.
              getACI(
                );
            numChars +=
              aci.
                getEndIndex(
                  ) -
                aci.
                getBeginIndex(
                  );
        }
        if (lengthAdj ==
              org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                ADJUST_SPACING &&
              numChars ==
              1)
            doAdjust =
              false;
        float xScale =
          1;
        float yScale =
          1;
        r =
          (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
            textRuns.
            get(
              chunk.
                end -
                1);
        org.apache.batik.gvt.text.TextSpanLayout layout =
          r.
          getLayout(
            );
        org.apache.batik.gvt.font.GVTGlyphMetrics lastMetrics =
          layout.
          getGlyphMetrics(
            layout.
              getGlyphCount(
                ) -
              1);
        org.apache.batik.gvt.font.GVTLineMetrics lastLineMetrics =
          layout.
          getLineMetrics(
            );
        java.awt.geom.Rectangle2D lastBounds =
          lastMetrics.
          getBounds2D(
            );
        float halfLeading =
          (lastMetrics.
             getVerticalAdvance(
               ) -
             (lastLineMetrics.
                getAscent(
                  ) +
                lastLineMetrics.
                getDescent(
                  ))) /
          2;
        float lastW =
          (float)
            (lastBounds.
               getWidth(
                 ) +
               lastBounds.
               getX(
                 ));
        float lastH =
          (float)
            (halfLeading +
               lastLineMetrics.
               getAscent(
                 ) +
               (lastBounds.
                  getHeight(
                    ) +
                  lastBounds.
                  getY(
                    )));
        java.awt.geom.Point2D visualAdvance;
        if (!doAdjust) {
            visualAdvance =
              new java.awt.geom.Point2D.Float(
                (float)
                  (chunk.
                     advance.
                     getX(
                       ) +
                     lastW -
                     lastMetrics.
                     getHorizontalAdvance(
                       )),
                (float)
                  (chunk.
                     advance.
                     getY(
                       ) -
                     lastMetrics.
                     getVerticalAdvance(
                       ) +
                     lastH));
        }
        else {
            java.awt.geom.Point2D advance =
              chunk.
                advance;
            if (layout.
                  isVertical(
                    )) {
                if (lengthAdj ==
                      ADJUST_SPACING) {
                    yScale =
                      (float)
                        ((length.
                            floatValue(
                              ) -
                            lastH) /
                           (advance.
                              getY(
                                ) -
                              lastMetrics.
                              getVerticalAdvance(
                                )));
                }
                else {
                    double adv =
                      advance.
                      getY(
                        ) -
                      lastMetrics.
                      getVerticalAdvance(
                        ) +
                      lastH;
                    yScale =
                      (float)
                        (length.
                           floatValue(
                             ) /
                           adv);
                }
                visualAdvance =
                  new java.awt.geom.Point2D.Float(
                    0,
                    length.
                      floatValue(
                        ));
            }
            else {
                if (lengthAdj ==
                      ADJUST_SPACING) {
                    xScale =
                      (float)
                        ((length.
                            floatValue(
                              ) -
                            lastW) /
                           (advance.
                              getX(
                                ) -
                              lastMetrics.
                              getHorizontalAdvance(
                                )));
                }
                else {
                    double adv =
                      advance.
                      getX(
                        ) +
                      lastW -
                      lastMetrics.
                      getHorizontalAdvance(
                        );
                    xScale =
                      (float)
                        (length.
                           floatValue(
                             ) /
                           adv);
                }
                visualAdvance =
                  new java.awt.geom.Point2D.Float(
                    length.
                      floatValue(
                        ),
                    0);
            }
            java.awt.geom.Point2D.Float adv =
              new java.awt.geom.Point2D.Float(
              0,
              0);
            for (int n =
                   chunk.
                     begin;
                 n <
                   chunk.
                     end;
                 ++n) {
                r =
                  (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
                    textRuns.
                    get(
                      n);
                layout =
                  r.
                    getLayout(
                      );
                layout.
                  setScale(
                    xScale,
                    yScale,
                    lengthAdj ==
                      ADJUST_SPACING);
                java.awt.geom.Point2D lAdv =
                  layout.
                  getAdvance2D(
                    );
                adv.
                  x +=
                  (float)
                    lAdv.
                    getX(
                      );
                adv.
                  y +=
                  (float)
                    lAdv.
                    getY(
                      );
            }
            chunk.
              advance =
              adv;
        }
        float dx =
          0.0F;
        float dy =
          0.0F;
        switch (anchorType) {
            case org.apache.batik.gvt.TextNode.Anchor.
                   ANCHOR_MIDDLE:
                dx =
                  (float)
                    (-visualAdvance.
                       getX(
                         ) /
                       2.0);
                dy =
                  (float)
                    (-visualAdvance.
                       getY(
                         ) /
                       2.0);
                break;
            case org.apache.batik.gvt.TextNode.Anchor.
                   ANCHOR_END:
                dx =
                  (float)
                    -visualAdvance.
                    getX(
                      );
                dy =
                  (float)
                    -visualAdvance.
                    getY(
                      );
                break;
            default:
                break;
        }
        r =
          (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
            textRuns.
            get(
              chunk.
                begin);
        layout =
          r.
            getLayout(
              );
        java.text.AttributedCharacterIterator runaci =
          r.
          getACI(
            );
        runaci.
          first(
            );
        boolean vertical =
          layout.
          isVertical(
            );
        java.lang.Float runX =
          (java.lang.Float)
            runaci.
            getAttribute(
              XPOS);
        java.lang.Float runY =
          (java.lang.Float)
            runaci.
            getAttribute(
              YPOS);
        org.apache.batik.gvt.text.TextPath textPath =
          (org.apache.batik.gvt.text.TextPath)
            runaci.
            getAttribute(
              TEXTPATH);
        float absX =
          (float)
            location.
            getX(
              );
        float absY =
          (float)
            location.
            getY(
              );
        float tpShiftX =
          0;
        float tpShiftY =
          0;
        if (runX !=
              null &&
              !runX.
              isNaN(
                )) {
            absX =
              runX.
                floatValue(
                  );
            tpShiftX =
              absX;
        }
        if (runY !=
              null &&
              !runY.
              isNaN(
                )) {
            absY =
              runY.
                floatValue(
                  );
            tpShiftY =
              absY;
        }
        if (vertical) {
            absY +=
              dy;
            tpShiftY +=
              dy;
            tpShiftX =
              0;
        }
        else {
            absX +=
              dx;
            tpShiftX +=
              dx;
            tpShiftY =
              0;
        }
        for (int n =
               chunk.
                 begin;
             n <
               chunk.
                 end;
             ++n) {
            r =
              (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
                textRuns.
                get(
                  n);
            layout =
              r.
                getLayout(
                  );
            runaci =
              r.
                getACI(
                  );
            runaci.
              first(
                );
            textPath =
              (org.apache.batik.gvt.text.TextPath)
                runaci.
                getAttribute(
                  TEXTPATH);
            if (vertical) {
                runX =
                  (java.lang.Float)
                    runaci.
                    getAttribute(
                      XPOS);
                if (runX !=
                      null &&
                      !runX.
                      isNaN(
                        )) {
                    absX =
                      runX.
                        floatValue(
                          );
                }
            }
            else {
                runY =
                  (java.lang.Float)
                    runaci.
                    getAttribute(
                      YPOS);
                if (runY !=
                      null &&
                      !runY.
                      isNaN(
                        )) {
                    absY =
                      runY.
                        floatValue(
                          );
                }
            }
            if (textPath ==
                  null) {
                layout.
                  setOffset(
                    new java.awt.geom.Point2D.Float(
                      absX,
                      absY));
                java.awt.geom.Point2D ladv =
                  layout.
                  getAdvance2D(
                    );
                absX +=
                  ladv.
                    getX(
                      );
                absY +=
                  ladv.
                    getY(
                      );
            }
            else {
                layout.
                  setOffset(
                    new java.awt.geom.Point2D.Float(
                      tpShiftX,
                      tpShiftY));
                java.awt.geom.Point2D ladv =
                  layout.
                  getAdvance2D(
                    );
                tpShiftX +=
                  (float)
                    ladv.
                    getX(
                      );
                tpShiftY +=
                  (float)
                    ladv.
                    getY(
                      );
                ladv =
                  layout.
                    getTextPathAdvance(
                      );
                absX =
                  (float)
                    ladv.
                    getX(
                      );
                absY =
                  (float)
                    ladv.
                    getY(
                      );
            }
        }
        return new java.awt.geom.Point2D.Float(
          absX,
          absY);
    }
    protected void paintDecorations(java.util.List textRuns,
                                    java.awt.Graphics2D g2d,
                                    int decorationType) {
        java.awt.Paint prevPaint =
          null;
        java.awt.Paint prevStrokePaint =
          null;
        java.awt.Stroke prevStroke =
          null;
        java.awt.geom.Rectangle2D decorationRect =
          null;
        double yLoc =
          0;
        double height =
          0;
        for (int i =
               0;
             i <
               textRuns.
               size(
                 );
             i++) {
            org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun textRun =
              (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
                textRuns.
                get(
                  i);
            java.text.AttributedCharacterIterator runaci =
              textRun.
              getACI(
                );
            runaci.
              first(
                );
            org.apache.batik.gvt.text.TextPaintInfo tpi =
              (org.apache.batik.gvt.text.TextPaintInfo)
                runaci.
                getAttribute(
                  PAINT_INFO);
            if (tpi !=
                  null &&
                  tpi.
                    composite !=
                  null) {
                g2d.
                  setComposite(
                    tpi.
                      composite);
            }
            java.awt.Paint paint =
              null;
            java.awt.Stroke stroke =
              null;
            java.awt.Paint strokePaint =
              null;
            if (tpi !=
                  null) {
                switch (decorationType) {
                    case org.apache.batik.gvt.text.TextSpanLayout.
                           DECORATION_UNDERLINE:
                        paint =
                          tpi.
                            underlinePaint;
                        stroke =
                          tpi.
                            underlineStroke;
                        strokePaint =
                          tpi.
                            underlineStrokePaint;
                        break;
                    case org.apache.batik.gvt.text.TextSpanLayout.
                           DECORATION_OVERLINE:
                        paint =
                          tpi.
                            overlinePaint;
                        stroke =
                          tpi.
                            overlineStroke;
                        strokePaint =
                          tpi.
                            overlineStrokePaint;
                        break;
                    case org.apache.batik.gvt.text.TextSpanLayout.
                           DECORATION_STRIKETHROUGH:
                        paint =
                          tpi.
                            strikethroughPaint;
                        stroke =
                          tpi.
                            strikethroughStroke;
                        strokePaint =
                          tpi.
                            strikethroughStrokePaint;
                        break;
                    default:
                        return;
                }
            }
            if (textRun.
                  isFirstRunInChunk(
                    )) {
                java.awt.Shape s =
                  textRun.
                  getLayout(
                    ).
                  getDecorationOutline(
                    decorationType);
                java.awt.geom.Rectangle2D r2d =
                  s.
                  getBounds2D(
                    );
                yLoc =
                  r2d.
                    getY(
                      );
                height =
                  r2d.
                    getHeight(
                      );
            }
            if (textRun.
                  isFirstRunInChunk(
                    ) ||
                  paint !=
                  prevPaint ||
                  stroke !=
                  prevStroke ||
                  strokePaint !=
                  prevStrokePaint) {
                if (decorationRect !=
                      null) {
                    if (prevPaint !=
                          null) {
                        g2d.
                          setPaint(
                            prevPaint);
                        g2d.
                          fill(
                            decorationRect);
                    }
                    if (prevStroke !=
                          null &&
                          prevStrokePaint !=
                          null) {
                        g2d.
                          setPaint(
                            prevStrokePaint);
                        g2d.
                          setStroke(
                            prevStroke);
                        g2d.
                          draw(
                            decorationRect);
                    }
                    decorationRect =
                      null;
                }
            }
            if ((paint !=
                   null ||
                   strokePaint !=
                   null) &&
                  !textRun.
                  getLayout(
                    ).
                  isVertical(
                    ) &&
                  !textRun.
                  getLayout(
                    ).
                  isOnATextPath(
                    )) {
                java.awt.Shape decorationShape =
                  textRun.
                  getLayout(
                    ).
                  getDecorationOutline(
                    decorationType);
                if (decorationRect ==
                      null) {
                    java.awt.geom.Rectangle2D r2d =
                      decorationShape.
                      getBounds2D(
                        );
                    decorationRect =
                      new java.awt.geom.Rectangle2D.Double(
                        r2d.
                          getX(
                            ),
                        yLoc,
                        r2d.
                          getWidth(
                            ),
                        height);
                }
                else {
                    java.awt.geom.Rectangle2D bounds =
                      decorationShape.
                      getBounds2D(
                        );
                    double minX =
                      java.lang.Math.
                      min(
                        decorationRect.
                          getX(
                            ),
                        bounds.
                          getX(
                            ));
                    double maxX =
                      java.lang.Math.
                      max(
                        decorationRect.
                          getMaxX(
                            ),
                        bounds.
                          getMaxX(
                            ));
                    decorationRect.
                      setRect(
                        minX,
                        yLoc,
                        maxX -
                          minX,
                        height);
                }
            }
            prevPaint =
              paint;
            prevStroke =
              stroke;
            prevStrokePaint =
              strokePaint;
        }
        if (decorationRect !=
              null) {
            if (prevPaint !=
                  null) {
                g2d.
                  setPaint(
                    prevPaint);
                g2d.
                  fill(
                    decorationRect);
            }
            if (prevStroke !=
                  null &&
                  prevStrokePaint !=
                  null) {
                g2d.
                  setPaint(
                    prevStrokePaint);
                g2d.
                  setStroke(
                    prevStroke);
                g2d.
                  draw(
                    decorationRect);
            }
        }
    }
    protected void paintTextRuns(java.util.List textRuns,
                                 java.awt.Graphics2D g2d) {
        for (int i =
               0;
             i <
               textRuns.
               size(
                 );
             i++) {
            org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun textRun =
              (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
                textRuns.
                get(
                  i);
            java.text.AttributedCharacterIterator runaci =
              textRun.
              getACI(
                );
            runaci.
              first(
                );
            org.apache.batik.gvt.text.TextPaintInfo tpi =
              (org.apache.batik.gvt.text.TextPaintInfo)
                runaci.
                getAttribute(
                  PAINT_INFO);
            if (tpi !=
                  null &&
                  tpi.
                    composite !=
                  null) {
                g2d.
                  setComposite(
                    tpi.
                      composite);
            }
            textRun.
              getLayout(
                ).
              draw(
                g2d);
        }
    }
    public java.awt.Shape getOutline(org.apache.batik.gvt.TextNode node) {
        java.awt.geom.GeneralPath outline =
          null;
        java.text.AttributedCharacterIterator aci;
        aci =
          node.
            getAttributedCharacterIterator(
              );
        if (aci ==
              null)
            return null;
        java.util.List textRuns =
          getTextRuns(
            node,
            aci);
        for (int i =
               0;
             i <
               textRuns.
               size(
                 );
             ++i) {
            org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun textRun =
              (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
                textRuns.
                get(
                  i);
            org.apache.batik.gvt.text.TextSpanLayout textRunLayout =
              textRun.
              getLayout(
                );
            java.awt.geom.GeneralPath textRunOutline =
              new java.awt.geom.GeneralPath(
              textRunLayout.
                getOutline(
                  ));
            if (outline ==
                  null) {
                outline =
                  textRunOutline;
            }
            else {
                outline.
                  setWindingRule(
                    java.awt.geom.GeneralPath.
                      WIND_NON_ZERO);
                outline.
                  append(
                    textRunOutline,
                    false);
            }
        }
        java.awt.Shape underline =
          getDecorationOutline(
            textRuns,
            org.apache.batik.gvt.text.TextSpanLayout.
              DECORATION_UNDERLINE);
        java.awt.Shape strikeThrough =
          getDecorationOutline(
            textRuns,
            org.apache.batik.gvt.text.TextSpanLayout.
              DECORATION_STRIKETHROUGH);
        java.awt.Shape overline =
          getDecorationOutline(
            textRuns,
            org.apache.batik.gvt.text.TextSpanLayout.
              DECORATION_OVERLINE);
        if (underline !=
              null) {
            if (outline ==
                  null) {
                outline =
                  new java.awt.geom.GeneralPath(
                    underline);
            }
            else {
                outline.
                  setWindingRule(
                    java.awt.geom.GeneralPath.
                      WIND_NON_ZERO);
                outline.
                  append(
                    underline,
                    false);
            }
        }
        if (strikeThrough !=
              null) {
            if (outline ==
                  null) {
                outline =
                  new java.awt.geom.GeneralPath(
                    strikeThrough);
            }
            else {
                outline.
                  setWindingRule(
                    java.awt.geom.GeneralPath.
                      WIND_NON_ZERO);
                outline.
                  append(
                    strikeThrough,
                    false);
            }
        }
        if (overline !=
              null) {
            if (outline ==
                  null) {
                outline =
                  new java.awt.geom.GeneralPath(
                    overline);
            }
            else {
                outline.
                  setWindingRule(
                    java.awt.geom.GeneralPath.
                      WIND_NON_ZERO);
                outline.
                  append(
                    overline,
                    false);
            }
        }
        return outline;
    }
    public java.awt.geom.Rectangle2D getBounds2D(org.apache.batik.gvt.TextNode node) {
        java.text.AttributedCharacterIterator aci;
        aci =
          node.
            getAttributedCharacterIterator(
              );
        if (aci ==
              null)
            return null;
        java.util.List textRuns =
          getTextRuns(
            node,
            aci);
        java.awt.geom.Rectangle2D bounds =
          null;
        for (int i =
               0;
             i <
               textRuns.
               size(
                 );
             ++i) {
            org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun textRun =
              (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
                textRuns.
                get(
                  i);
            org.apache.batik.gvt.text.TextSpanLayout textRunLayout =
              textRun.
              getLayout(
                );
            java.awt.geom.Rectangle2D runBounds =
              textRunLayout.
              getBounds2D(
                );
            if (runBounds !=
                  null) {
                if (bounds ==
                      null)
                    bounds =
                      runBounds;
                else
                    bounds.
                      add(
                        runBounds);
            }
        }
        java.awt.Shape underline =
          getDecorationStrokeOutline(
            textRuns,
            org.apache.batik.gvt.text.TextSpanLayout.
              DECORATION_UNDERLINE);
        if (underline !=
              null) {
            if (bounds ==
                  null)
                bounds =
                  underline.
                    getBounds2D(
                      );
            else
                bounds.
                  add(
                    underline.
                      getBounds2D(
                        ));
        }
        java.awt.Shape strikeThrough =
          getDecorationStrokeOutline(
            textRuns,
            org.apache.batik.gvt.text.TextSpanLayout.
              DECORATION_STRIKETHROUGH);
        if (strikeThrough !=
              null) {
            if (bounds ==
                  null)
                bounds =
                  strikeThrough.
                    getBounds2D(
                      );
            else
                bounds.
                  add(
                    strikeThrough.
                      getBounds2D(
                        ));
        }
        java.awt.Shape overline =
          getDecorationStrokeOutline(
            textRuns,
            org.apache.batik.gvt.text.TextSpanLayout.
              DECORATION_OVERLINE);
        if (overline !=
              null) {
            if (bounds ==
                  null)
                bounds =
                  overline.
                    getBounds2D(
                      );
            else
                bounds.
                  add(
                    overline.
                      getBounds2D(
                        ));
        }
        return bounds;
    }
    protected java.awt.Shape getDecorationOutline(java.util.List textRuns,
                                                  int decorationType) {
        java.awt.geom.GeneralPath outline =
          null;
        java.awt.Paint prevPaint =
          null;
        java.awt.Paint prevStrokePaint =
          null;
        java.awt.Stroke prevStroke =
          null;
        java.awt.geom.Rectangle2D decorationRect =
          null;
        double yLoc =
          0;
        double height =
          0;
        for (int i =
               0;
             i <
               textRuns.
               size(
                 );
             i++) {
            org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun textRun =
              (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
                textRuns.
                get(
                  i);
            java.text.AttributedCharacterIterator runaci =
              textRun.
              getACI(
                );
            runaci.
              first(
                );
            java.awt.Paint paint =
              null;
            java.awt.Stroke stroke =
              null;
            java.awt.Paint strokePaint =
              null;
            org.apache.batik.gvt.text.TextPaintInfo tpi =
              (org.apache.batik.gvt.text.TextPaintInfo)
                runaci.
                getAttribute(
                  PAINT_INFO);
            if (tpi !=
                  null) {
                switch (decorationType) {
                    case org.apache.batik.gvt.text.TextSpanLayout.
                           DECORATION_UNDERLINE:
                        paint =
                          tpi.
                            underlinePaint;
                        stroke =
                          tpi.
                            underlineStroke;
                        strokePaint =
                          tpi.
                            underlineStrokePaint;
                        break;
                    case org.apache.batik.gvt.text.TextSpanLayout.
                           DECORATION_OVERLINE:
                        paint =
                          tpi.
                            overlinePaint;
                        stroke =
                          tpi.
                            overlineStroke;
                        strokePaint =
                          tpi.
                            overlineStrokePaint;
                        break;
                    case org.apache.batik.gvt.text.TextSpanLayout.
                           DECORATION_STRIKETHROUGH:
                        paint =
                          tpi.
                            strikethroughPaint;
                        stroke =
                          tpi.
                            strikethroughStroke;
                        strokePaint =
                          tpi.
                            strikethroughStrokePaint;
                        break;
                    default:
                        return null;
                }
            }
            if (textRun.
                  isFirstRunInChunk(
                    )) {
                java.awt.Shape s =
                  textRun.
                  getLayout(
                    ).
                  getDecorationOutline(
                    decorationType);
                java.awt.geom.Rectangle2D r2d =
                  s.
                  getBounds2D(
                    );
                yLoc =
                  r2d.
                    getY(
                      );
                height =
                  r2d.
                    getHeight(
                      );
            }
            if (textRun.
                  isFirstRunInChunk(
                    ) ||
                  paint !=
                  prevPaint ||
                  stroke !=
                  prevStroke ||
                  strokePaint !=
                  prevStrokePaint) {
                if (decorationRect !=
                      null) {
                    if (outline ==
                          null) {
                        outline =
                          new java.awt.geom.GeneralPath(
                            decorationRect);
                    }
                    else {
                        outline.
                          append(
                            decorationRect,
                            false);
                    }
                    decorationRect =
                      null;
                }
            }
            if ((paint !=
                   null ||
                   strokePaint !=
                   null) &&
                  !textRun.
                  getLayout(
                    ).
                  isVertical(
                    ) &&
                  !textRun.
                  getLayout(
                    ).
                  isOnATextPath(
                    )) {
                java.awt.Shape decorationShape =
                  textRun.
                  getLayout(
                    ).
                  getDecorationOutline(
                    decorationType);
                if (decorationRect ==
                      null) {
                    java.awt.geom.Rectangle2D r2d =
                      decorationShape.
                      getBounds2D(
                        );
                    decorationRect =
                      new java.awt.geom.Rectangle2D.Double(
                        r2d.
                          getX(
                            ),
                        yLoc,
                        r2d.
                          getWidth(
                            ),
                        height);
                }
                else {
                    java.awt.geom.Rectangle2D bounds =
                      decorationShape.
                      getBounds2D(
                        );
                    double minX =
                      java.lang.Math.
                      min(
                        decorationRect.
                          getX(
                            ),
                        bounds.
                          getX(
                            ));
                    double maxX =
                      java.lang.Math.
                      max(
                        decorationRect.
                          getMaxX(
                            ),
                        bounds.
                          getMaxX(
                            ));
                    decorationRect.
                      setRect(
                        minX,
                        yLoc,
                        maxX -
                          minX,
                        height);
                }
            }
            prevPaint =
              paint;
            prevStroke =
              stroke;
            prevStrokePaint =
              strokePaint;
        }
        if (decorationRect !=
              null) {
            if (outline ==
                  null) {
                outline =
                  new java.awt.geom.GeneralPath(
                    decorationRect);
            }
            else {
                outline.
                  append(
                    decorationRect,
                    false);
            }
        }
        return outline;
    }
    protected java.awt.Shape getDecorationStrokeOutline(java.util.List textRuns,
                                                        int decorationType) {
        java.awt.geom.GeneralPath outline =
          null;
        java.awt.Paint prevPaint =
          null;
        java.awt.Paint prevStrokePaint =
          null;
        java.awt.Stroke prevStroke =
          null;
        java.awt.geom.Rectangle2D decorationRect =
          null;
        double yLoc =
          0;
        double height =
          0;
        for (int i =
               0;
             i <
               textRuns.
               size(
                 );
             i++) {
            org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun textRun =
              (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
                textRuns.
                get(
                  i);
            java.text.AttributedCharacterIterator runaci =
              textRun.
              getACI(
                );
            runaci.
              first(
                );
            java.awt.Paint paint =
              null;
            java.awt.Stroke stroke =
              null;
            java.awt.Paint strokePaint =
              null;
            org.apache.batik.gvt.text.TextPaintInfo tpi =
              (org.apache.batik.gvt.text.TextPaintInfo)
                runaci.
                getAttribute(
                  PAINT_INFO);
            if (tpi !=
                  null) {
                switch (decorationType) {
                    case org.apache.batik.gvt.text.TextSpanLayout.
                           DECORATION_UNDERLINE:
                        paint =
                          tpi.
                            underlinePaint;
                        stroke =
                          tpi.
                            underlineStroke;
                        strokePaint =
                          tpi.
                            underlineStrokePaint;
                        break;
                    case org.apache.batik.gvt.text.TextSpanLayout.
                           DECORATION_OVERLINE:
                        paint =
                          tpi.
                            overlinePaint;
                        stroke =
                          tpi.
                            overlineStroke;
                        strokePaint =
                          tpi.
                            overlineStrokePaint;
                        break;
                    case org.apache.batik.gvt.text.TextSpanLayout.
                           DECORATION_STRIKETHROUGH:
                        paint =
                          tpi.
                            strikethroughPaint;
                        stroke =
                          tpi.
                            strikethroughStroke;
                        strokePaint =
                          tpi.
                            strikethroughStrokePaint;
                        break;
                    default:
                        return null;
                }
            }
            if (textRun.
                  isFirstRunInChunk(
                    )) {
                java.awt.Shape s =
                  textRun.
                  getLayout(
                    ).
                  getDecorationOutline(
                    decorationType);
                java.awt.geom.Rectangle2D r2d =
                  s.
                  getBounds2D(
                    );
                yLoc =
                  r2d.
                    getY(
                      );
                height =
                  r2d.
                    getHeight(
                      );
            }
            if (textRun.
                  isFirstRunInChunk(
                    ) ||
                  paint !=
                  prevPaint ||
                  stroke !=
                  prevStroke ||
                  strokePaint !=
                  prevStrokePaint) {
                if (decorationRect !=
                      null) {
                    java.awt.Shape s =
                      null;
                    if (prevStroke !=
                          null &&
                          prevStrokePaint !=
                          null)
                        s =
                          prevStroke.
                            createStrokedShape(
                              decorationRect);
                    else
                        if (prevPaint !=
                              null)
                            s =
                              decorationRect;
                    if (s !=
                          null) {
                        if (outline ==
                              null)
                            outline =
                              new java.awt.geom.GeneralPath(
                                s);
                        else
                            outline.
                              append(
                                s,
                                false);
                    }
                    decorationRect =
                      null;
                }
            }
            if ((paint !=
                   null ||
                   strokePaint !=
                   null) &&
                  !textRun.
                  getLayout(
                    ).
                  isVertical(
                    ) &&
                  !textRun.
                  getLayout(
                    ).
                  isOnATextPath(
                    )) {
                java.awt.Shape decorationShape =
                  textRun.
                  getLayout(
                    ).
                  getDecorationOutline(
                    decorationType);
                if (decorationRect ==
                      null) {
                    java.awt.geom.Rectangle2D r2d =
                      decorationShape.
                      getBounds2D(
                        );
                    decorationRect =
                      new java.awt.geom.Rectangle2D.Double(
                        r2d.
                          getX(
                            ),
                        yLoc,
                        r2d.
                          getWidth(
                            ),
                        height);
                }
                else {
                    java.awt.geom.Rectangle2D bounds =
                      decorationShape.
                      getBounds2D(
                        );
                    double minX =
                      java.lang.Math.
                      min(
                        decorationRect.
                          getX(
                            ),
                        bounds.
                          getX(
                            ));
                    double maxX =
                      java.lang.Math.
                      max(
                        decorationRect.
                          getMaxX(
                            ),
                        bounds.
                          getMaxX(
                            ));
                    decorationRect.
                      setRect(
                        minX,
                        yLoc,
                        maxX -
                          minX,
                        height);
                }
            }
            prevPaint =
              paint;
            prevStroke =
              stroke;
            prevStrokePaint =
              strokePaint;
        }
        if (decorationRect !=
              null) {
            java.awt.Shape s =
              null;
            if (prevStroke !=
                  null &&
                  prevStrokePaint !=
                  null)
                s =
                  prevStroke.
                    createStrokedShape(
                      decorationRect);
            else
                if (prevPaint !=
                      null)
                    s =
                      decorationRect;
            if (s !=
                  null) {
                if (outline ==
                      null)
                    outline =
                      new java.awt.geom.GeneralPath(
                        s);
                else
                    outline.
                      append(
                        s,
                        false);
            }
        }
        return outline;
    }
    public org.apache.batik.gvt.text.Mark getMark(org.apache.batik.gvt.TextNode node,
                                                  int index,
                                                  boolean leadingEdge) {
        java.text.AttributedCharacterIterator aci;
        aci =
          node.
            getAttributedCharacterIterator(
              );
        if (aci ==
              null)
            return null;
        if (index <
              aci.
              getBeginIndex(
                ) ||
              index >
              aci.
              getEndIndex(
                ))
            return null;
        org.apache.batik.gvt.text.TextHit textHit =
          new org.apache.batik.gvt.text.TextHit(
          index,
          leadingEdge);
        return new org.apache.batik.gvt.renderer.BasicTextPainter.BasicMark(
          node,
          textHit);
    }
    protected org.apache.batik.gvt.text.Mark hitTest(double x,
                                                     double y,
                                                     org.apache.batik.gvt.TextNode node) {
        java.text.AttributedCharacterIterator aci;
        aci =
          node.
            getAttributedCharacterIterator(
              );
        if (aci ==
              null)
            return null;
        java.util.List textRuns =
          getTextRuns(
            node,
            aci);
        for (int i =
               0;
             i <
               textRuns.
               size(
                 );
             ++i) {
            org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun textRun =
              (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
                textRuns.
                get(
                  i);
            org.apache.batik.gvt.text.TextSpanLayout layout =
              textRun.
              getLayout(
                );
            org.apache.batik.gvt.text.TextHit textHit =
              layout.
              hitTestChar(
                (float)
                  x,
                (float)
                  y);
            if (textHit !=
                  null &&
                  layout.
                  getBounds2D(
                    ).
                  contains(
                    x,
                    y)) {
                return new org.apache.batik.gvt.renderer.BasicTextPainter.BasicMark(
                  node,
                  textHit);
            }
        }
        return null;
    }
    public org.apache.batik.gvt.text.Mark selectFirst(org.apache.batik.gvt.TextNode node) {
        java.text.AttributedCharacterIterator aci;
        aci =
          node.
            getAttributedCharacterIterator(
              );
        if (aci ==
              null)
            return null;
        org.apache.batik.gvt.text.TextHit textHit =
          new org.apache.batik.gvt.text.TextHit(
          aci.
            getBeginIndex(
              ),
          false);
        return new org.apache.batik.gvt.renderer.BasicTextPainter.BasicMark(
          node,
          textHit);
    }
    public org.apache.batik.gvt.text.Mark selectLast(org.apache.batik.gvt.TextNode node) {
        java.text.AttributedCharacterIterator aci;
        aci =
          node.
            getAttributedCharacterIterator(
              );
        if (aci ==
              null)
            return null;
        org.apache.batik.gvt.text.TextHit textHit =
          new org.apache.batik.gvt.text.TextHit(
          aci.
            getEndIndex(
              ) -
            1,
          false);
        return new org.apache.batik.gvt.renderer.BasicTextPainter.BasicMark(
          node,
          textHit);
    }
    public int[] getSelected(org.apache.batik.gvt.text.Mark startMark,
                             org.apache.batik.gvt.text.Mark finishMark) {
        if (startMark ==
              null ||
              finishMark ==
              null) {
            return null;
        }
        org.apache.batik.gvt.renderer.BasicTextPainter.BasicMark start;
        org.apache.batik.gvt.renderer.BasicTextPainter.BasicMark finish;
        try {
            start =
              (org.apache.batik.gvt.renderer.BasicTextPainter.BasicMark)
                startMark;
            finish =
              (org.apache.batik.gvt.renderer.BasicTextPainter.BasicMark)
                finishMark;
        }
        catch (java.lang.ClassCastException cce) {
            throw new java.lang.Error(
              "This Mark was not instantiated by this TextPainter class!");
        }
        org.apache.batik.gvt.TextNode textNode =
          start.
          getTextNode(
            );
        if (textNode ==
              null)
            return null;
        if (textNode !=
              finish.
              getTextNode(
                ))
            throw new java.lang.Error(
              "Markers are from different TextNodes!");
        java.text.AttributedCharacterIterator aci;
        aci =
          textNode.
            getAttributedCharacterIterator(
              );
        if (aci ==
              null)
            return null;
        int[] result =
          new int[2];
        result[0] =
          start.
            getHit(
              ).
            getCharIndex(
              );
        result[1] =
          finish.
            getHit(
              ).
            getCharIndex(
              );
        java.util.List textRuns =
          getTextRuns(
            textNode,
            aci);
        java.util.Iterator trI =
          textRuns.
          iterator(
            );
        int startGlyphIndex =
          -1;
        int endGlyphIndex =
          -1;
        org.apache.batik.gvt.text.TextSpanLayout startLayout =
          null;
        org.apache.batik.gvt.text.TextSpanLayout endLayout =
          null;
        while (trI.
                 hasNext(
                   )) {
            org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun tr =
              (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
                trI.
                next(
                  );
            org.apache.batik.gvt.text.TextSpanLayout tsl =
              tr.
              getLayout(
                );
            if (startGlyphIndex ==
                  -1) {
                startGlyphIndex =
                  tsl.
                    getGlyphIndex(
                      result[0]);
                if (startGlyphIndex !=
                      -1)
                    startLayout =
                      tsl;
            }
            if (endGlyphIndex ==
                  -1) {
                endGlyphIndex =
                  tsl.
                    getGlyphIndex(
                      result[1]);
                if (endGlyphIndex !=
                      -1)
                    endLayout =
                      tsl;
            }
            if (startGlyphIndex !=
                  -1 &&
                  endGlyphIndex !=
                  -1)
                break;
        }
        if (startLayout ==
              null ||
              endLayout ==
              null)
            return null;
        int startCharCount =
          startLayout.
          getCharacterCount(
            startGlyphIndex,
            startGlyphIndex);
        int endCharCount =
          endLayout.
          getCharacterCount(
            endGlyphIndex,
            endGlyphIndex);
        if (startCharCount >
              1) {
            if (result[0] >
                  result[1] &&
                  startLayout.
                  isLeftToRight(
                    )) {
                result[0] +=
                  startCharCount -
                    1;
            }
            else
                if (result[1] >
                      result[0] &&
                      !startLayout.
                      isLeftToRight(
                        )) {
                    result[0] -=
                      startCharCount -
                        1;
                }
        }
        if (endCharCount >
              1) {
            if (result[1] >
                  result[0] &&
                  endLayout.
                  isLeftToRight(
                    )) {
                result[1] +=
                  endCharCount -
                    1;
            }
            else
                if (result[0] >
                      result[1] &&
                      !endLayout.
                      isLeftToRight(
                        )) {
                    result[1] -=
                      endCharCount -
                        1;
                }
        }
        return result;
    }
    public java.awt.Shape getHighlightShape(org.apache.batik.gvt.text.Mark beginMark,
                                            org.apache.batik.gvt.text.Mark endMark) {
        if (beginMark ==
              null ||
              endMark ==
              null) {
            return null;
        }
        org.apache.batik.gvt.renderer.BasicTextPainter.BasicMark begin;
        org.apache.batik.gvt.renderer.BasicTextPainter.BasicMark end;
        try {
            begin =
              (org.apache.batik.gvt.renderer.BasicTextPainter.BasicMark)
                beginMark;
            end =
              (org.apache.batik.gvt.renderer.BasicTextPainter.BasicMark)
                endMark;
        }
        catch (java.lang.ClassCastException cce) {
            throw new java.lang.Error(
              "This Mark was not instantiated by this TextPainter class!");
        }
        org.apache.batik.gvt.TextNode textNode =
          begin.
          getTextNode(
            );
        if (textNode ==
              null)
            return null;
        if (textNode !=
              end.
              getTextNode(
                ))
            throw new java.lang.Error(
              "Markers are from different TextNodes!");
        java.text.AttributedCharacterIterator aci;
        aci =
          textNode.
            getAttributedCharacterIterator(
              );
        if (aci ==
              null)
            return null;
        int beginIndex =
          begin.
          getHit(
            ).
          getCharIndex(
            );
        int endIndex =
          end.
          getHit(
            ).
          getCharIndex(
            );
        if (beginIndex >
              endIndex) {
            org.apache.batik.gvt.renderer.BasicTextPainter.BasicMark tmpMark =
              begin;
            begin =
              end;
            end =
              tmpMark;
            int tmpIndex =
              beginIndex;
            beginIndex =
              endIndex;
            endIndex =
              tmpIndex;
        }
        java.util.List textRuns =
          getTextRuns(
            textNode,
            aci);
        java.awt.geom.GeneralPath highlightedShape =
          new java.awt.geom.GeneralPath(
          );
        for (int i =
               0;
             i <
               textRuns.
               size(
                 );
             ++i) {
            org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun textRun =
              (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
                textRuns.
                get(
                  i);
            org.apache.batik.gvt.text.TextSpanLayout layout =
              textRun.
              getLayout(
                );
            java.awt.Shape layoutHighlightedShape =
              layout.
              getHighlightShape(
                beginIndex,
                endIndex);
            if (layoutHighlightedShape !=
                  null &&
                  !layoutHighlightedShape.
                  getBounds(
                    ).
                  isEmpty(
                    )) {
                highlightedShape.
                  append(
                    layoutHighlightedShape,
                    false);
            }
        }
        return highlightedShape;
    }
    class TextChunk {
        public int begin;
        public int end;
        public java.awt.geom.Point2D advance;
        public TextChunk(int begin, int end,
                         java.awt.geom.Point2D advance) {
            super(
              );
            this.
              begin =
              begin;
            this.
              end =
              end;
            this.
              advance =
              new java.awt.geom.Point2D.Float(
                (float)
                  advance.
                  getX(
                    ),
                (float)
                  advance.
                  getY(
                    ));
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAL1Ye2wcRxmfOz9iO3b8yMt5J47TKg9um9BAI4eSxLEbpxfn" +
           "ZLuWuDS5zO3N3W28t7vZnbXPbg1pEcStRBQgTQNq/JerVFHbVIgKJGgVVAFF" +
           "LUhtA6UgEoSQCCoRjRAFEaB8M7N7+7g7V/0HS97bm/m+b77375t7/haqs0y0" +
           "lmg0RicNYsX6NJrApkUyvSq2rBFYS8lP1+C/Hbs5uCuK6pNoUR5bh2RskX6F" +
           "qBkridYomkWxJhNrkJAM40iYxCLmOKaKriXRUsUaKBiqIiv0kJ4hjGAUm3HU" +
           "jik1lbRNyYAjgKI1cdBE4ppIe8PbPXHULOvGpEfe6SPv9e0wyoJ3lkVRW/wE" +
           "HseSTRVViisW7SmaaKuhq5M5VacxUqSxE+pOxwUH4zvLXND1UuuHd87m27gL" +
           "FmNN0yk3zxoilq6Ok0wctXqrfSopWCfRF1FNHC30EVPUHXcPleBQCQ51rfWo" +
           "QPsWotmFXp2bQ11J9YbMFKJoQ1CIgU1ccMQkuM4goYE6tnNmsHZ9yVphZZmJ" +
           "T22Vzj19rO07Nag1iVoVbZipI4MSFA5JgkNJIU1Ma28mQzJJ1K5BsIeJqWBV" +
           "mXIi3WEpOQ1TG8LvuoUt2gYx+ZmeryCOYJtpy1Q3S+ZleUI53+qyKs6Brcs8" +
           "W4WF/WwdDGxSQDEziyHvHJbaMUXLULQuzFGysftBIADWBQVC83rpqFoNwwLq" +
           "ECmiYi0nDUPqaTkgrdMhAU2KVlYVynxtYHkM50iKZWSILiG2gKqRO4KxULQ0" +
           "TMYlQZRWhqLki8+twd1nHtEOaFEUAZ0zRFaZ/guBaW2IaYhkiUmgDgRj85b4" +
           "ebzslZkoQkC8NEQsaL736O0929ZefV3QrKpAczh9gsg0Jc+lF721unfzrhqm" +
           "RoOhWwoLfsByXmUJZ6enaECHWVaSyDZj7ubVoZ984dRl8n4UNQ2gellX7QLk" +
           "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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "f4wgAAA=");
    }
    public class TextRun {
        protected java.text.AttributedCharacterIterator
          aci;
        protected org.apache.batik.gvt.text.TextSpanLayout
          layout;
        protected int anchorType;
        protected boolean firstRunInChunk;
        protected java.lang.Float length;
        protected java.lang.Integer lengthAdjust;
        public TextRun(org.apache.batik.gvt.text.TextSpanLayout layout,
                       java.text.AttributedCharacterIterator aci,
                       boolean firstRunInChunk) {
            super(
              );
            this.
              layout =
              layout;
            this.
              aci =
              aci;
            this.
              aci.
              first(
                );
            this.
              firstRunInChunk =
              firstRunInChunk;
            this.
              anchorType =
              org.apache.batik.gvt.TextNode.Anchor.
                ANCHOR_START;
            org.apache.batik.gvt.TextNode.Anchor anchor =
              (org.apache.batik.gvt.TextNode.Anchor)
                aci.
                getAttribute(
                  org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                    ANCHOR_TYPE);
            if (anchor !=
                  null) {
                this.
                  anchorType =
                  anchor.
                    getType(
                      );
            }
            if (aci.
                  getAttribute(
                    WRITING_MODE) ==
                  WRITING_MODE_RTL) {
                if (anchorType ==
                      org.apache.batik.gvt.TextNode.Anchor.
                        ANCHOR_START) {
                    anchorType =
                      org.apache.batik.gvt.TextNode.Anchor.
                        ANCHOR_END;
                }
                else
                    if (anchorType ==
                          org.apache.batik.gvt.TextNode.Anchor.
                            ANCHOR_END) {
                        anchorType =
                          org.apache.batik.gvt.TextNode.Anchor.
                            ANCHOR_START;
                    }
            }
            length =
              (java.lang.Float)
                aci.
                getAttribute(
                  org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                    BBOX_WIDTH);
            lengthAdjust =
              (java.lang.Integer)
                aci.
                getAttribute(
                  org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                    LENGTH_ADJUST);
        }
        public java.text.AttributedCharacterIterator getACI() {
            return aci;
        }
        public org.apache.batik.gvt.text.TextSpanLayout getLayout() {
            return layout;
        }
        public int getAnchorType() { return anchorType;
        }
        public java.lang.Float getLength() {
            return length;
        }
        public java.lang.Integer getLengthAdjust() {
            return lengthAdjust;
        }
        public boolean isFirstRunInChunk() {
            return firstRunInChunk;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public StrokingTextPainter() { super(
                                     ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1cCXQcxZmuGR2WZeuwjA98yMYWEIOZCQ6QgIAg67DGjKRB" +
       "EgLLxuPWTEvTds/0uLtGGptweWFxNm8dcIghvODwEmPAOBzZ5SUsSXBeXggs" +
       "WR4QsllCOAJZQpZlwY9ANkuO/f+q6umenu6WZ7Jav9c1re6qv+r76j/qah99" +
       "l9QYOmmVMzREd2VlI9SdoTFJN+RkpyoZxjA8iydur5I+2Pp2//lBUjtKGlOS" +
       "0ZeQDLlHkdWkMUqWKxmDSpmEbPTLchJLxHTZkPVJiSpaZpQsUIxIOqsqCYX2" +
       "aUkZM4xIepTMkyjVlbEclSNCACXLo9CSMGtJuMP5uj1K5ia07C4r+2Jb9k7b" +
       "G8yZtuoyKGmObpcmpXCOKmo4qhi0Pa+TM7OaumtC1WhIztPQdvVcQcHG6Lkl" +
       "FKx6uOmjj29JNTMK5kuZjEYZPGNQNjR1Uk5GSZP1tFuV08ZOci2pipI5tsyU" +
       "tEXNSsNQaRgqNdFauaD1DXIml+7UGBxqSqrNJrBBlJxSLCQr6VJaiImxNoOE" +
       "Oiqws8KAdmUBLUdZAvHLZ4Zvu31r87eqSNMoaVIyQ9icBDSCQiWjQKicHpN1" +
       "oyOZlJOjZF4GOntI1hVJVXaLnm4xlImMRHPQ/SYt+DCXlXVWp8UV9CNg03MJ" +
       "qukFeONMocRfNeOqNAFYF1pYOcIefA4A6xVomD4ugd6JItU7lEySkhXOEgWM" +
       "bZdCBig6Ky3TlFaoqjojwQPSwlVElTIT4SFQvcwEZK3RQAF1SpZ4CkWus1Ji" +
       "hzQhx1EjHfli/BXkms2IwCKULHBmY5Kgl5Y4esnWP+/2X7jv6kxvJkgC0Oak" +
       "nFCx/XOgUKuj0KA8Lusy2AEvOPeM6AFp4ff2BgmBzAscmXmeb3/u+CVrW489" +
       "xfMsdckzMLZdTtB44tBY4/PLOtecX4XNqMtqhoKdX4ScWVlMvGnPZ8HDLCxI" +
       "xJch8+WxwSc3XX9EfidI6iOkNqGpuTTo0byEls4qqqxvkDOyLlE5GSGz5Uyy" +
       "k72PkFlwH1UyMn86MD5uyDRCqlX2qFZjfwNF4yACKaqHeyUzrpn3WYmm2H0+" +
       "SwiZBReZC1cP4f/YLyXJcEpLy2EpIWWUjBaO6RriN8LgccaA21R4DLR+R9jQ" +
       "cjqoYFjTJ8IS6EFKFi8mJmkYOiEJPaGjPmmgnRPDYEoxiWluCLUt+/9UTx7x" +
       "zp8KBKArljkdgQo21KupICGeuC23vvv4g/FnuJKhYQimKDkbqg7xqkOs6hBU" +
       "HTKrDrlUTQIBVuNJ2ATe8dBtO8ABgAeeu2boqo3b9q6qAo3LTlUD55h1VVEk" +
       "6rS8hOna44mHWhp2n/Lq2T8MkuooaZESNCepGFg69AlwWYkdwqrnjkGMskLF" +
       "SluowBinawk5CZ7KK2QIKXXapKzjc0pOskkwAxmabNg7jLi2nxy7Y+qGkes+" +
       "GSTB4uiAVdaAY8PiMfTpBd/d5vQKbnKbbn77o4cOXKNZ/qEo3JhRsqQkYljl" +
       "1AknPfHEGSulR+Pfu6aN0T4b/DeFTkbX2Oqso8j9tJuuHLHUAeBxTU9LKr4y" +
       "Oa6nKV2bsp4wZZ2HyQKut6hCjgayKHDRUPauf3v2t59iTJoBo8kW6Ydk2m5z" +
       "UiishbmjeZZGDuuyDPleuSP2pS+/e/Nmpo6QY7VbhW2YdoJzgt4BBm96audL" +
       "r7166MWgpcIUonRuDAY7eYblpL/AvwBcf8YLHQs+4A6mpVN4uZUFN5fFmk+z" +
       "2gYOTwVngMrRdnkG1FAZV6QxVUb7+WPTqWc/+p/7mnl3q/DE1Ja10wuwnp+8" +
       "nlz/zNbftzIxgQQGXIs/Kxv34vMtyR26Lu3CduRveGH5V34s3QXxAHywoeyW" +
       "mVsljA/COvBcxsUnWXqO492nMTnVsOt4sRnZBkbxxC0vvt8w8v73j7PWFo+s" +
       "7P3eJ2XbuRbxXoDKLiAiKXLz+HZhFtNFeWjDIqej6pWMFAg751j/lmb12MdQ" +
       "7ShUmwBHbAzo4PfyRaokctfM+sUPfrhw2/NVJNhD6lVNSvZIzODIbNB02UiB" +
       "r81nP3sJb8dUHSTNjA9SwlDJA+yFFe79253OUtYju7+z6B8vvPfgq0wts1zG" +
       "UlYeLWlZkYdlg3jLyI/89NM/u/fWA1N8GLDG27M5yi3+nwF1bM8b/13SL8yn" +
       "uQxRHOVHw0e/uqTz4ndYecu5YOm2fGnIAgdtlV13JP1hcFXtj4Jk1ihpTohB" +
       "84ik5tCuR2GgaJgjaRhYF70vHvTxEU57wXkuczo2W7VOt2aFSrjH3Hjf4NBB" +
       "7GmC3b5R6GDEqYMBwm42siKnsXQNJmtZ91Xh7VngYgw2NKfQBCUjqflCBUxH" +
       "FsHVKyrodVRASX2sI9I/HI/09wywYospCTN9wlF+qDDnSnamwMclIIhHqMyc" +
       "XVvhHffJmH4Gk0t5/Rd6KnRXMQHr4eoX7evzIGDEjwBM+jEZcEEeFZKjJcjn" +
       "9kQHrogPdm+IDPQP4bNBB5ArygTSBdegqO4yDyBbKwYSE5JjJUAaGZBYx2DH" +
       "hsGOWK8blHiZUFBPRkSFl3tAGa8YyrCQPFwCpXm4+8rheOdAX2zg8v6ueKTL" +
       "DcxEmWAw26iocpMHmEzFYK4Ukq8sAVO3YWQ43jPQP+wGQisTRAdcW0VVV3mA" +
       "mKwYxBYheUsJiNkmCFcTmarA1sdEXZIHimsrRrFNSN5WgqJ+faQrEo92j3RH" +
       "3WBcVyaM8+EaF5XJHjD+tmIYSSE5WQKj+srYgGs/3FwBgO2iGsUDwL6KAaSE" +
       "5FQpgE0eAL5YgU1nRDVpDwAHKgagCslqCYA6dFCxjmFXL3v7iYNYjE8xYOii" +
       "qp0eIA5WDGKnh2SIfFcMRoYj/RvifQNd3W5AvlYmEAwXOVEd9QByuGIg1EMy" +
       "hAs7kPjw8HpzCMMH4TiKC0UyVJ7gQ0cbwnsrQJgX7ZjyQPhwxQinPCQ7EQ4O" +
       "M/d11AHmkTKNpxOuz4kqr/YA852KwewWkneXgJnT0d/ZOzAYH94Uc1W7xyqw" +
       "n+tEbdd64DhWMY5rPSTDgKuja+PlQ8PxoVhHJ/SNW5f8oEwomO0GUeH1HlCe" +
       "qhjK9R6SITAKKB1RV816ukwYG+D6G1HZHg8Yz1UMY4+HZLD3juhwfEN0U6w3" +
       "3tvR3xXtHjQ9QY/rKiWb3MDIxm9+gwuXXnOc50+clzn4dC1cN4nW3+TByy/c" +
       "eQkwShxs1PvIA/8OLcdl2CQ034Ap/nJrio8LlUO5MYMOSlNsLyGe2HJ688K2" +
       "8z9Yxef4rS55bZsO+x7/p9HR05sTPPMqN8HFmw333VuXeDn95K95gZNdCvB8" +
       "C+4L//3Iz7f/hK3d1eFa7bA5a7atxHbofIbN1wSbC6Tgej1pIiQoc074LyVb" +
       "/srFdCiWDlMlrWQmwsNKWk7iTh5iEIv1MyqfrUAVrc5YnfbADrXjvc8cvojT" +
       "eorHwoyV/7HLXn/+rt0PHeWrg0gvJWd67T2WbnjimvCpPuvaloJ8uOGCY799" +
       "c+SqoFjPa8Tk3/OmOTZYa1VDMluhfJe9wjWtQGHV/6RiNeGSuz7f9N1bWqp6" +
       "gqQ6QupyGWVnTo4ki5daZhm5MZveWFts7AFXGkxCeVx3pSRwRjabd9j2yydu" +
       "2wtMn3ersMVbPWz7Q3fbDsL8KqtrFHRGTrrZ+Uk+sqGsAXqjylSsqwG9K129" +
       "nW0LxoH1Ix+seR9/dJbVTvavlngvpLKcS80FTPBGXluabDv20J7bDiYH7jmb" +
       "K3ZL8TZhdyaX/ua//uknoTtef9plR2o21bJnqfKkrNrqXFDsAMGK+thur7Vg" +
       "+Erj/jcfa5tYX84GEj5rnWaLCP9eASDO8DYcZ1N+vOc/lgxfnNpWxl7QCged" +
       "TpH39x19esNpif1BtrXNVzJLtsSLC7UXG1W9LtOcnik2o9UFBWjFjl0D1wGh" +
       "AAecRmApXakFWFHfofrzfCSynK77B4H5Pu8WYNIA49AJmdo78o8Fgwg0Tmf8" +
       "/qvx+GB9Fp8HZhePADDb3QLO3T4EYdFAabD3KupAG+Skmu5guac76Af9NHPx" +
       "XRxpCkZEupRNKQljXRfja6UPl6yhSympyaJjMXw3B2I6RDiqTApHHr6m5bUd" +
       "X337m2LAUbLVWJRZ3nvb3/0ltO82bu78RMfqkkMV9jL8VIfd1xv2COlSCyvR" +
       "85uHrnn8vmtuFoErUENJ9aSmJC3dWDYDutGI7y6G6xHRwY+UYTzMFf/BYTcN" +
       "PsIc/WkGXKEHp57Quj8j53wfzbgIk0/B1CKrg2agJIb5TIvIc2aASFZ8KVxP" +
       "COxPlG9kXkXdjQyFnILJBQx2rw8lGzHp5I4HrW8wlzFYxteLFaEFrvtFI+43" +
       "G/EWa8RvOBFvo6S+wnCq0b5ByXZ8AwPO7sU/j+ct9rtmiv0VcD0nWv9c+ex7" +
       "FXXwWlWYLQr2DfdJC9uQ5j5ky5wnnzC+8da3zDHpG4XKV2Jd7XC9ICp/wdlu" +
       "w3fga6vk4OHVz153cPWv2J5wnWLAiAAGEC5HuGxl3j/62jsvNCx/kI082Kgc" +
       "K21wnn0rPdpWdGKNYWpCLrYWFOPEbNnVE3RxSXzkGpCni9sDrPoQJbWqnJmg" +
       "KaYZnxCOF+/XUlIFAPBWyuadVlQchNiKXaeqZWQ8lWC+4+eFFC1UOF8IL/Nu" +
       "jQ/M5o1nldm0jTXHx0BzPu+mMNEh0iWwXRyGT/bdXiZjs64iy2SlNvtIvBaT" +
       "EUqa8Bgc9KPpQfBx1LLrabcrK7BrXLcgF0JTG7lM/utj1+eVBCPPou7ByHKo" +
       "n/eh5AuY3EhJs3ConalcZkdHZ4Q1/yqLk5tmgJOz8d1l0NQ7BbA7fThxtZs/" +
       "YOIy1fOUOB1Vt/tQ9RVMboWpYUKXJSr3sTM/chLI6tH0Hg2mQxJNpGAiyZ1p" +
       "gbr9M0AdWyNsAxYu5TL5b1nq5FnUQUENa0jNTitMYLqlON7iHEPA47+UbP4r" +
       "V3RwJQWG0uEJWUuHYxJNRZlXNBeMZlI8d7dxTA7nDffVOcfoel1sW2JvW+zX" +
       "ZmR8k/ttFKH4jCNcQ8ZhM2Q8eIIhA/OmWFWY3F8aG/BxGhPNx9kfZq29HxPD" +
       "xwwe9Xn3bUz+ARMuy8+9P1aue7e8NESy9rLPzLYV3BuTdMinaU9g8jVK5tqd" +
       "Ij77rmXVd8+AVS/Ed5+A/tovTHN/+VbtVdR98GfSuaAwc0V7CMU0oGwdU8Yo" +
       "w81o+Wcfyp7F5EeUtEjJ7TmDM8bPjzOMz1jEPTlTk79zAY842FHlPH4xPXFV" +
       "WzyKeo+aGTWrMXmAcfCSDz8vY/IixFk2y++SE5peWI+yz+h+NlPshKDRrwiI" +
       "vyyfnV96FHVAtvkbzg4D/5YPMWwe9itKGhgx9hGZjZU3ZoAVDFk4z616T0B7" +
       "bxpWSmdankW9hxmnMNAf+BDyISb/BbN+cD4DOYrfXphW2liw0qGUJA51M37e" +
       "m6khxmoAex6XyX9PiJ8azDnHp+g0/ASD3vwEqzHbn/gSwHotl0ka67pMgk4u" +
       "dmODMCKQcGFf5GBc/XkGuGLL9+C4q8VhAP5bloV5Fp3GwpjrCc7zIWw+JnNh" +
       "8geEWY5HqBaK+H2BnGDDTJED7qf6dwLh78onx6voCZHT6kPOSkxOpmRJETls" +
       "+CC7U7RkplZ9FoHhTHKZ/LcsX+RZ1Dt+seH8A6wpR/C1WGZwLDnMGtM0VZYy" +
       "7oMyRuKZPgSvw+Q0EAME90n6DtNUW72PExSyMb5PnwG+5+O7JUDWjYK0G8tW" +
       "Sc+i3gMtP5Zrk1rOXKhxG/kGL7G842d96O7B5AKgO6VAMGULmcFzLDLbZ3DB" +
       "uOYuwchd5SuvV9HpAsVlPlQMYRKFQGHI+ClHj6KX0NE3U3Sgbh0RmI6UT4dX" +
       "0eno2OpDxzZMNsG4gtMRlUrYGJ2pUdYygPK4gPR4+Wx4FfV0/sFzWMJg7/Ch" +
       "BKfEwXE+lBhirLDDA4F7LE6mPSJfKSerCKlt5jL5b1mceBY9IU7yPpzsxsSg" +
       "ZB5w0qtMpFS4KBtu7iyOg/T/gpk8JfNd5ur4Mdbiks/q+afgiQcPNtUtOnj5" +
       "z/lav/m59twoqRvPqar9cyHbfW1Wl8cVRuxcls5jx1WCe7z2ds2lBErqzFsE" +
       "EbyBl7sJxlNu5SipgtSecy9M+pw5Kalhv/Z8XwDTtPJBROA39iz7QDpkwdsv" +
       "Zs1AGvJfCVkvGUrCRm2eK9NSe8ewEywLputP28mT1UUbOey/STDXx3IxcVDq" +
       "oYMb+68+ft49/BvShCrtRtUic6JkFv9SlQmtKjl0ZZdmyqrtXfNx48OzTzVX" +
       "14q+YbW3jWkVuET2vecSx0eVRlvh28qXDl34/X/ZW/tCkAQ2k4AEWri59Hu1" +
       "fDank+Wbo6VnqEYknX3t2b7mzl0Xrx1/72X2RSDhZ66WeeePJ16896qf7l98" +
       "qDVI5kRIjQKdlGcf0nXtysBsZVIfJQ2K0Z2HJoIURVKLDmg1orJL+B8oMF4E" +
       "nQ2Fp/hxMSWrSjf1Sz/Jrle1KVln8ycU0xAlc6wnvGccZ1dy2ayjgPVEdCWm" +
       "7+9k4xrsDdDWeLQvmzW/zK2/JMvM/rj3KOfr7BbvvvG/CTsw70JFAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "VEJmTt2CWjUrWg/A9NHuVZAabah0rQoa");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "IoCWGTuWwrG1qI63UD909CotOh6yUSeVDHXUVuqtSRXEldqmpmwsgwcTQ0xy" +
       "4XLbbmRhhGu4pDPDtbuVoC1dg/rsmoVCq05zixAMYOv1moQwIUrhSp9AUfSb" +
       "80cyX7jkY/HiAeDRxhrLgfMbf3KJp0G7W0/kydNHD1aLv9tL57+eXuR8ZP9C" +
       "bxSWXnPefpni6dZPvvMDz2ncT1UPHxz/dVy6K/aDb3L0te6cqOrloKbXn/8k" +
       "jy22Cx2/kvsb7/yfjwrfsnzrJTYdvPYUztNV/iz7sd8iv05930HplqMXdG/Y" +
       "yHR9oWevfy337lCPk9ATrns59zVHzD6WM/YMOD60Z/ZDpx9ZH/fdjc+rj7Vg" +
       "pwBFhjNfL79yxwX37sqTg7j0EkOPD8XI8/3BkcpcueWFHiCerLO48OXr3wZo" +
       "gOPH9zL++CVkLN6G+IYzxTvYkXD4cPs15z6RH/iafphr9+a+ksZXyVAJlqYa" +
       "1Qryrjx0AUGvzJP74tJtQf5sv8jyFycM6XNx6da1b2rHdN1/E3Tl702UvgUc" +
       "v7Cn6xcuS9enzqTryn43z56Ip7+il7QL8b/uAmpenydPxKW7gxBQk9eUZ7vy" +
       "qmMuXncTXBTZXgWOT+65+OSLqjo5vJflydcXsjQukLOVJ9DORnKdGiVeVGT8" +
       "d9fr+f0XgT3k/r6TezCK/SpX3nBMWOVmCXstOH5/j+H3XxzCbjkadvaERRe+" +
       "JVRsitm9M/HcTz/5e29/7sk/L/aV3GlGohKioXHGnsoTZf72Y5/53Kfvfc3P" +
       "F/uwileYCt95ejPqjXtNr9tCWghyzxE1j+dMPAuOT++p+fQZ1ADBzrKX/PWI" +
       "K9T+9aEr/Rdyx0fj8e2O7hnx8iyPcQsAn1dGBtl5Hu2h45dnMMf39HzD0uG9" +
       "3eY90796tNkX3MzOBP/lHfiisfz/Jy9Q89kF974tTyTgBdUczA77Bdnfku1+" +
       "8QvyvDVPvjUu3Z9vLQUO6IUs6yKtvvKGU3b0ppuwo/z9vdIbAYP37crufl80" +
       "J3zsc5wL2Mn36V0x4tIDe5+DLRPPRrFe4WHJY0Ff8O3/CwSt5heHANKP7AX9" +
       "kUsIWmj8p/Lk7ADkBmmzC6Td5kkUlx5XQ12J9cM3uoC8hB8SvhezSqwudy+t" +
       "7c20kD6+CemL11OfAoLQu7K735vv5tuKDLedcJd52j1q9569Qt+637e0+41L" +
       "6k3uOlaCIIKitTEP/TTSQyiPfHhTtfWQVzzdOdzc/I/RTNGng/O96fceetNz" +
       "3va/wZvmedmi0jx5941uM788yhPhAj/4vQWud7+QH3zvBffenyc/lCdv3iG5" +
       "IO8H9zp47Muezu+BiP9g3/W73wt8GXD2z156j/dTR/6iqO5dF0D80Tx5e1y6" +
       "56SXya99+NjG3nETNvZwfvEbgKDv2wv8vhfHxvYhySFHLz8K7A3dd6/yPuCh" +
       "hp8iP59plb4JYHj/Hsv7zye/oKD4/6cuYO9f5MmPx6UHFc1Koh15u08fFCb/" +
       "08cc/sTNzgmaQNr9rrJb3vzic3jM0lP7Htu1ck5rJ1h6uLDK4uIvXkDVL+fJ" +
       "J8BwVsyicF31w6P5+ckJwy/cLFFXAeQ/3UP/kxeHqJOR2TFRT5R2Br1r5ZzW" +
       "ThJV/P/rF3D0G3nya3Hp3oKjw3DoFEGfvAmCiuUcMKO65W/2kP/msgSdPUE4" +
       "MdTvpP7UBVL+QZ78Dpg0ApfDJXH+hZBDM77vyIzHS2X/tYRC6N+92WH+STDM" +
       "tnZld79fA6E/c4HQf54nf7ybQXb8xNOivXsCUr/yeuc1AqOxkm842OcoCPiv" +
       "N0HAy/YWfet+x9Xu92tlFode9sLWTpjFznV8/gLuvpAnfwlmPYC7Y8exV538" +
       "3n885umvbpYn4D5u/bs98r/7WvJ0V175vaCVL+5b++JXwtOXLuCpCHH+Pi49" +
       "eh1PRXygn83WP9zsYsMrQJy73pXd/d68WZ1ebNhFkafmz3fMfd/RFS+v4eCu" +
       "8zk5yD99cXArKAA4YZXQPrS5x87fKHaULafo4LaboOih/OKjgJp37Sl614uj" +
       "UCcH7lPE3K75ybz4xNLBq44808GjFzD02jwBjNyxNMGQU6xHHRw/Ljh4+EVY" +
       "wLvtI3v5P/LiqMhpz3twwdr3QTlPngKeN9Lzr7gQZniDjE/frIx5H390L+NH" +
       "v0YyNi+QMX/Qc1ABQ+pOxnxP1CkRqzcbNbwaiPYrexF/5cUR8XjmdvBAkRSy" +
       "oBfIieXJG3ej6LgQtdiqd+Xdx4J+880K+rpS6fYHdmV3v18rQdkLBOXyhIpL" +
       "LwWCUqaxdMARFzHR6joPftC7jLhZXHrojOli/k2jR274EuHu63nqzz93/52v" +
       "eG7yR7vV2MMv3N3FlO5cJI5z8hM0J85vD0J9YRZc3FWk9wWFWOJ5D2oOZ7Nx" +
       "6c7D0xz9wWRXbgYG/7PKxaVbQHoy55vBDON0zrh0W/F7Mt81YCzH+YDf3J2c" +
       "zDIHtYMs+akaHI4bVy+ejHeUyFRPUJvtFh8eOalveb+VHnyhfjvxPPXJ65ba" +
       "iy9LHj6xTPj9vt+PP9cffMcXWj+1+wiY6ijbfEWtdCdTumP3PbKi0vyp5xPn" +
       "1nZY1+3UM1+67xN3PX34hPa+HeBj3T+B7bVnf2Wr6wZx8V2s7b95xb964z9/" +
       "7s+KHZ//H9PfER7yUwAA");
}
