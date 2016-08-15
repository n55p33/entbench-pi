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
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "JO0u2xyPmBWFS3B32i2ha2TrDUOE4xYAdkuVLpUJsRxMggVjhV15uu6XfaLL" +
           "sqOWjQfT7cSpcIg4HpckBK4OM0RbV2tCT9vMuqMOT1n1WRWEzJg2Pc0UNHqo" +
           "tFslNZNCeIWtwOp5C2OVKM2sFWkEnK2684a7oIxKs16PFTnDLSpNcYXDa/7I" +
           "NJZaaTVezVfyfELyBhMEG32tG9PuutYxxFaXEhppSVbJkqxkYHXj20rWHsZh" +
           "4CbwUBo2NkSnMZf9Zmy2GoNlpLSktpbpdWE2WCHl5WAqJOlctrBUnXdrYa/e" +
           "G621UN9U6V6tafFEVBdLDYIYdDO3OtOwYT+gYbw+bJtsK+vqOJ5vdTavbAt2" +
           "b7HbPLopAzuv/MMr2WWltx8QOj6NLV7vOnvVcvI09vgsCcpPux6+021Yce73" +
           "qfc+97wy+XRl7+AMDgNb6YNLypNyIujK0T3E4d658orvMoA2D95yg7q79ZM/" +
           "//y1yw88z/5NcYZ/dDN3hYIua7FtnzzlOdG+6AeqZhaKX9md+fjFzwci6OGX" +
           "1S6CLh82C3N+fcf3GxH02tvxRdB58DxJ+WwEXT9LmR8N5b8n6T4cQVeP6YBz" +
           "d42TJB8F0gFJ3vyYf5uDid3xWHrudGCP0um+H7VpP5ELT546WCzuvA/iMIp3" +
           "t9435S88T47f9SL66d2lhGyLWZZLuUxBl3b3I0dXP4/fUdqhrIv9p16654tX" +
           "3niYXffsFD4uiBO6PXr7G4CO40fFmX32Bw/83lt++/lvFuck/wuXHeD9jCAA" +
           "AA==");
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
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "o8ZpxPd0bd9DJ/VIcjrzOS3Prb42DWb74TSMgrzTnHp0Ky1cx+M7yz03oedd" +
           "xylw3YlX3nyveklTsjF1suWl0cho5uNlsTT59WxON2crWEhausgUW9Za78kJ" +
           "ueAMH50tkAlCcrA/4XlJY3ZBsjCFKEKDOYoqdIOpsbPuRhykW6/VpWc9eWun" +
           "7qhO9he2GQrUsmXh3Jj2lIju4g5KGpiS2JiCBzbbBL6E53JhPuoyAQ33uFp7" +
           "Pms2XNuZWa2NN2wNBXNn2ht5FBWzldFaMsiuUxPwDjt3HQ3vK3yTKIbCTnUa" +
           "23HObIDNx55sIrLIphk66sYda8YPF1tu7hJOn8RR1aEtY7hXEi82IitF0FUq" +
           "DNqEb6cCjopEXZhh86HbQRSC6Qq2LyCLKO9xQmNRn0/0TVhfBst1tNn0kx46" +
           "nWkhDwKmnyHLTUJHuI0ta8UQS5JdQYj8wF5taFZsL71Ney6yNDqRme6UinCz" +
           "vmmszTYzafOKL5s1VN7icbsuThjS4LPREp/gpoN2dWWdoGZTGyc043VkVYNh" +
           "bZQLsLJZhy1yR3Yo1xSASNlCGRXDvcgIK6tm2h2eQ2uOIIZdVhMLPNkThBqs" +
           "m9iUN8e25gZFmwnGuJD0w+Wu8Nd5Uu/KuWs3A4NEDHTu7xoAn+wrVktZ0vV2" +
           "xJILsaZJCN1ZzDbtnEgn2IyWiX5NMpswGlHt7qrty/NQaawJY7drZhwlUeYm" +
           "7JrqeIVu5FjZ9NF4LWcwjCZEM+51zY25CVynhmwWGoIpptMakrvuXtMyPV4x" +
           "jRbc9aml1aRZh2gpYOcUrAipwNaCJCyZCTJC3Mmu58z7SDFYikyvvezkU01a" +
           "ad4u3w4MXS2QTVa3dTQL14o0GFhMNpo09h1D6HYXNOKMMh2BPY6KCXo+JIY9" +
           "b+85ilPnuqmsyQ23vh4tg+ZCtVrbTJsEWj/B+pMREg/re6e5CE1jH5m1dc7u" +
           "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");
    }
    public StrokingTextPainter() { super(
                                     ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "O5iKex1ZWGdQTM5q3tKSjCU+Z8ftUSJK");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "1Rv/+XN/Vpz4/P/4GHAN8lMAAA==");
}
