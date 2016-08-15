package org.apache.batik.gvt.font;
public final class SVGGVTGlyphVector implements org.apache.batik.gvt.font.GVTGlyphVector {
    public static final java.text.AttributedCharacterIterator.Attribute PAINT_INFO =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        PAINT_INFO;
    private org.apache.batik.gvt.font.GVTFont font;
    private org.apache.batik.gvt.font.Glyph[] glyphs;
    private java.awt.font.FontRenderContext frc;
    private java.awt.geom.GeneralPath outline;
    private java.awt.geom.Rectangle2D logicalBounds;
    private java.awt.geom.Rectangle2D bounds2D;
    private java.awt.Shape[] glyphLogicalBounds;
    private boolean[] glyphVisible;
    private java.awt.geom.Point2D endPos;
    private org.apache.batik.gvt.text.TextPaintInfo cacheTPI;
    public SVGGVTGlyphVector(org.apache.batik.gvt.font.GVTFont font,
                             org.apache.batik.gvt.font.Glyph[] glyphs,
                             java.awt.font.FontRenderContext frc) {
        super(
          );
        this.
          font =
          font;
        this.
          glyphs =
          glyphs;
        this.
          frc =
          frc;
        outline =
          null;
        bounds2D =
          null;
        logicalBounds =
          null;
        glyphLogicalBounds =
          (new java.awt.Shape[glyphs.
                                length]);
        glyphVisible =
          (new boolean[glyphs.
                         length]);
        for (int i =
               0;
             i <
               glyphs.
                 length;
             i++) {
            glyphVisible[i] =
              true;
        }
        endPos =
          glyphs[glyphs.
                   length -
                   1].
            getPosition(
              );
        endPos =
          new java.awt.geom.Point2D.Float(
            (float)
              (endPos.
                 getX(
                   ) +
                 glyphs[glyphs.
                          length -
                          1].
                 getHorizAdvX(
                   )),
            (float)
              endPos.
              getY(
                ));
    }
    public org.apache.batik.gvt.font.GVTFont getFont() { return font;
    }
    public java.awt.font.FontRenderContext getFontRenderContext() {
        return frc;
    }
    public int getGlyphCode(int glyphIndex) throws java.lang.IndexOutOfBoundsException {
        if (glyphIndex <
              0 ||
              glyphIndex >
              glyphs.
                length -
              1) {
            throw new java.lang.IndexOutOfBoundsException(
              "glyphIndex " +
              glyphIndex +
              " is out of bounds, should be between 0 and " +
              (glyphs.
                 length -
                 1));
        }
        return glyphs[glyphIndex].
          getGlyphCode(
            );
    }
    public int[] getGlyphCodes(int beginGlyphIndex, int numEntries,
                               int[] codeReturn) throws java.lang.IndexOutOfBoundsException,
        java.lang.IllegalArgumentException { if (numEntries <
                                                   0) {
                                                 throw new java.lang.IllegalArgumentException(
                                                   "numEntries argument value, " +
                                                   numEntries +
                                                   ", is illegal. It must be > 0.");
                                             }
                                             if (beginGlyphIndex <
                                                   0) {
                                                 throw new java.lang.IndexOutOfBoundsException(
                                                   "beginGlyphIndex " +
                                                   beginGlyphIndex +
                                                   " is out of bounds, should be between 0 and " +
                                                   (glyphs.
                                                      length -
                                                      1));
                                             }
                                             if (beginGlyphIndex +
                                                   numEntries >
                                                   glyphs.
                                                     length) {
                                                 throw new java.lang.IndexOutOfBoundsException(
                                                   "beginGlyphIndex + numEntries (" +
                                                   beginGlyphIndex +
                                                   "+" +
                                                   numEntries +
                                                   ") exceeds the number of glpyhs in this GlyphVector");
                                             }
                                             if (codeReturn ==
                                                   null) {
                                                 codeReturn =
                                                   (new int[numEntries]);
                                             }
                                             for (int i =
                                                    beginGlyphIndex;
                                                  i <
                                                    beginGlyphIndex +
                                                    numEntries;
                                                  i++) {
                                                 codeReturn[i -
                                                              beginGlyphIndex] =
                                                   glyphs[i].
                                                     getGlyphCode(
                                                       );
                                             }
                                             return codeReturn;
    }
    public java.awt.font.GlyphJustificationInfo getGlyphJustificationInfo(int glyphIndex) {
        if (glyphIndex <
              0 ||
              glyphIndex >
              glyphs.
                length -
              1) {
            throw new java.lang.IndexOutOfBoundsException(
              "glyphIndex: " +
              glyphIndex +
              ", is out of bounds. Should be between 0 and " +
              (glyphs.
                 length -
                 1) +
              ".");
        }
        return null;
    }
    public java.awt.Shape getGlyphLogicalBounds(int glyphIndex) {
        if (glyphLogicalBounds[glyphIndex] ==
              null &&
              glyphVisible[glyphIndex]) {
            computeGlyphLogicalBounds(
              );
        }
        return glyphLogicalBounds[glyphIndex];
    }
    private void computeGlyphLogicalBounds() {
        float ascent =
          0;
        float descent =
          0;
        if (font !=
              null) {
            org.apache.batik.gvt.font.GVTLineMetrics lineMetrics =
              font.
              getLineMetrics(
                "By",
                frc);
            ascent =
              lineMetrics.
                getAscent(
                  );
            descent =
              lineMetrics.
                getDescent(
                  );
            if (descent <
                  0) {
                descent =
                  -descent;
            }
        }
        if (ascent ==
              0) {
            float maxAscent =
              0;
            float maxDescent =
              0;
            for (int i =
                   0;
                 i <
                   getNumGlyphs(
                     );
                 i++) {
                if (!glyphVisible[i])
                    continue;
                org.apache.batik.gvt.font.GVTGlyphMetrics glyphMetrics =
                  getGlyphMetrics(
                    i);
                java.awt.geom.Rectangle2D glyphBounds =
                  glyphMetrics.
                  getBounds2D(
                    );
                ascent =
                  (float)
                    -glyphBounds.
                    getMinY(
                      );
                descent =
                  (float)
                    (glyphBounds.
                       getHeight(
                         ) -
                       ascent);
                if (ascent >
                      maxAscent)
                    maxAscent =
                      ascent;
                if (descent >
                      maxDescent)
                    maxDescent =
                      descent;
            }
            ascent =
              maxAscent;
            descent =
              maxDescent;
        }
        java.awt.Shape[] tempLogicalBounds =
          new java.awt.Shape[getNumGlyphs(
                               )];
        boolean[] rotated =
          new boolean[getNumGlyphs(
                        )];
        double maxWidth =
          -1;
        double maxHeight =
          -1;
        for (int i =
               0;
             i <
               getNumGlyphs(
                 );
             i++) {
            if (!glyphVisible[i]) {
                tempLogicalBounds[i] =
                  null;
                continue;
            }
            java.awt.geom.AffineTransform glyphTransform =
              getGlyphTransform(
                i);
            org.apache.batik.gvt.font.GVTGlyphMetrics glyphMetrics =
              getGlyphMetrics(
                i);
            java.awt.geom.Rectangle2D glyphBounds =
              new java.awt.geom.Rectangle2D.Double(
              0,
              -ascent,
              glyphMetrics.
                getHorizontalAdvance(
                  ),
              ascent +
                descent);
            if (glyphBounds.
                  isEmpty(
                    )) {
                if (i >
                      0) {
                    rotated[i] =
                      rotated[i -
                                1];
                }
                else {
                    rotated[i] =
                      true;
                }
            }
            else {
                java.awt.geom.Point2D p1 =
                  new java.awt.geom.Point2D.Double(
                  glyphBounds.
                    getMinX(
                      ),
                  glyphBounds.
                    getMinY(
                      ));
                java.awt.geom.Point2D p2 =
                  new java.awt.geom.Point2D.Double(
                  glyphBounds.
                    getMaxX(
                      ),
                  glyphBounds.
                    getMinY(
                      ));
                java.awt.geom.Point2D p3 =
                  new java.awt.geom.Point2D.Double(
                  glyphBounds.
                    getMinX(
                      ),
                  glyphBounds.
                    getMaxY(
                      ));
                java.awt.geom.Point2D gpos =
                  getGlyphPosition(
                    i);
                java.awt.geom.AffineTransform tr =
                  java.awt.geom.AffineTransform.
                  getTranslateInstance(
                    gpos.
                      getX(
                        ),
                    gpos.
                      getY(
                        ));
                if (glyphTransform !=
                      null)
                    tr.
                      concatenate(
                        glyphTransform);
                tempLogicalBounds[i] =
                  tr.
                    createTransformedShape(
                      glyphBounds);
                java.awt.geom.Point2D tp1 =
                  new java.awt.geom.Point2D.Double(
                  );
                java.awt.geom.Point2D tp2 =
                  new java.awt.geom.Point2D.Double(
                  );
                java.awt.geom.Point2D tp3 =
                  new java.awt.geom.Point2D.Double(
                  );
                tr.
                  transform(
                    p1,
                    tp1);
                tr.
                  transform(
                    p2,
                    tp2);
                tr.
                  transform(
                    p3,
                    tp3);
                double tdx12 =
                  tp1.
                  getX(
                    ) -
                  tp2.
                  getX(
                    );
                double tdx13 =
                  tp1.
                  getX(
                    ) -
                  tp3.
                  getX(
                    );
                double tdy12 =
                  tp1.
                  getY(
                    ) -
                  tp2.
                  getY(
                    );
                double tdy13 =
                  tp1.
                  getY(
                    ) -
                  tp3.
                  getY(
                    );
                if (java.lang.Math.
                      abs(
                        tdx12) <
                      0.001 &&
                      java.lang.Math.
                      abs(
                        tdy13) <
                      0.001) {
                    rotated[i] =
                      false;
                }
                else
                    if (java.lang.Math.
                          abs(
                            tdx13) <
                          0.001 &&
                          java.lang.Math.
                          abs(
                            tdy12) <
                          0.001) {
                        rotated[i] =
                          false;
                    }
                    else {
                        rotated[i] =
                          true;
                    }
                java.awt.geom.Rectangle2D rectBounds;
                rectBounds =
                  tempLogicalBounds[i].
                    getBounds2D(
                      );
                if (rectBounds.
                      getWidth(
                        ) >
                      maxWidth)
                    maxWidth =
                      rectBounds.
                        getWidth(
                          );
                if (rectBounds.
                      getHeight(
                        ) >
                      maxHeight)
                    maxHeight =
                      rectBounds.
                        getHeight(
                          );
            }
        }
        java.awt.geom.GeneralPath logicalBoundsPath =
          new java.awt.geom.GeneralPath(
          );
        for (int i =
               0;
             i <
               getNumGlyphs(
                 );
             i++) {
            if (tempLogicalBounds[i] !=
                  null) {
                logicalBoundsPath.
                  append(
                    tempLogicalBounds[i],
                    false);
            }
        }
        java.awt.geom.Rectangle2D fullBounds =
          logicalBoundsPath.
          getBounds2D(
            );
        if (fullBounds.
              getHeight(
                ) <
              maxHeight *
              1.5) {
            for (int i =
                   0;
                 i <
                   getNumGlyphs(
                     );
                 i++) {
                if (rotated[i])
                    continue;
                if (tempLogicalBounds[i] ==
                      null)
                    continue;
                java.awt.geom.Rectangle2D glyphBounds =
                  tempLogicalBounds[i].
                  getBounds2D(
                    );
                double x =
                  glyphBounds.
                  getMinX(
                    );
                double width =
                  glyphBounds.
                  getWidth(
                    );
                if (i <
                      getNumGlyphs(
                        ) -
                      1 &&
                      tempLogicalBounds[i +
                                          1] !=
                      null) {
                    java.awt.geom.Rectangle2D ngb =
                      tempLogicalBounds[i +
                                          1].
                      getBounds2D(
                        );
                    if (ngb.
                          getX(
                            ) >
                          x) {
                        double nw =
                          ngb.
                          getX(
                            ) -
                          x;
                        if (nw <
                              width *
                              1.15 &&
                              nw >
                              width *
                              0.85) {
                            double delta =
                              (nw -
                                 width) *
                              0.5;
                            width +=
                              delta;
                            ngb.
                              setRect(
                                ngb.
                                  getX(
                                    ) -
                                  delta,
                                ngb.
                                  getY(
                                    ),
                                ngb.
                                  getWidth(
                                    ) +
                                  delta,
                                ngb.
                                  getHeight(
                                    ));
                        }
                    }
                }
                tempLogicalBounds[i] =
                  new java.awt.geom.Rectangle2D.Double(
                    x,
                    fullBounds.
                      getMinY(
                        ),
                    width,
                    fullBounds.
                      getHeight(
                        ));
            }
        }
        else
            if (fullBounds.
                  getWidth(
                    ) <
                  maxWidth *
                  1.5) {
                for (int i =
                       0;
                     i <
                       getNumGlyphs(
                         );
                     i++) {
                    if (rotated[i])
                        continue;
                    if (tempLogicalBounds[i] ==
                          null)
                        continue;
                    java.awt.geom.Rectangle2D glyphBounds =
                      tempLogicalBounds[i].
                      getBounds2D(
                        );
                    double y =
                      glyphBounds.
                      getMinY(
                        );
                    double height =
                      glyphBounds.
                      getHeight(
                        );
                    if (i <
                          getNumGlyphs(
                            ) -
                          1 &&
                          tempLogicalBounds[i +
                                              1] !=
                          null) {
                        java.awt.geom.Rectangle2D ngb =
                          tempLogicalBounds[i +
                                              1].
                          getBounds2D(
                            );
                        if (ngb.
                              getY(
                                ) >
                              y) {
                            double nh =
                              ngb.
                              getY(
                                ) -
                              y;
                            if (nh <
                                  height *
                                  1.15 &&
                                  nh >
                                  height *
                                  0.85) {
                                double delta =
                                  (nh -
                                     height) *
                                  0.5;
                                height +=
                                  delta;
                                ngb.
                                  setRect(
                                    ngb.
                                      getX(
                                        ),
                                    ngb.
                                      getY(
                                        ) -
                                      delta,
                                    ngb.
                                      getWidth(
                                        ),
                                    ngb.
                                      getHeight(
                                        ) +
                                      delta);
                            }
                        }
                    }
                    tempLogicalBounds[i] =
                      new java.awt.geom.Rectangle2D.Double(
                        fullBounds.
                          getMinX(
                            ),
                        y,
                        fullBounds.
                          getWidth(
                            ),
                        height);
                }
            }
        java.lang.System.
          arraycopy(
            tempLogicalBounds,
            0,
            glyphLogicalBounds,
            0,
            getNumGlyphs(
              ));
    }
    public org.apache.batik.gvt.font.GVTGlyphMetrics getGlyphMetrics(int idx) {
        if (idx <
              0 ||
              idx >
              glyphs.
                length -
              1)
            throw new java.lang.IndexOutOfBoundsException(
              "idx: " +
              idx +
              ", is out of bounds. Should be between 0 and " +
              (glyphs.
                 length -
                 1) +
              '.');
        if (idx <
              glyphs.
                length -
              1) {
            if (font !=
                  null) {
                float hkern =
                  font.
                  getHKern(
                    glyphs[idx].
                      getGlyphCode(
                        ),
                    glyphs[idx +
                             1].
                      getGlyphCode(
                        ));
                float vkern =
                  font.
                  getVKern(
                    glyphs[idx].
                      getGlyphCode(
                        ),
                    glyphs[idx +
                             1].
                      getGlyphCode(
                        ));
                return glyphs[idx].
                  getGlyphMetrics(
                    hkern,
                    vkern);
            }
        }
        return glyphs[idx].
          getGlyphMetrics(
            );
    }
    public java.awt.Shape getGlyphOutline(int glyphIndex) {
        if (glyphIndex <
              0 ||
              glyphIndex >
              glyphs.
                length -
              1) {
            throw new java.lang.IndexOutOfBoundsException(
              "glyphIndex: " +
              glyphIndex +
              ", is out of bounds. Should be between 0 and " +
              (glyphs.
                 length -
                 1) +
              ".");
        }
        return glyphs[glyphIndex].
          getOutline(
            );
    }
    public java.awt.geom.Rectangle2D getGlyphCellBounds(int glyphIndex) {
        return getGlyphLogicalBounds(
                 glyphIndex).
          getBounds2D(
            );
    }
    public java.awt.geom.Point2D getGlyphPosition(int glyphIndex) {
        if (glyphIndex ==
              glyphs.
                length)
            return endPos;
        if (glyphIndex <
              0 ||
              glyphIndex >
              glyphs.
                length -
              1) {
            throw new java.lang.IndexOutOfBoundsException(
              "glyphIndex: " +
              glyphIndex +
              ", is out of bounds. Should be between 0 and " +
              (glyphs.
                 length -
                 1) +
              '.');
        }
        return glyphs[glyphIndex].
          getPosition(
            );
    }
    public float[] getGlyphPositions(int beginGlyphIndex,
                                     int numEntries,
                                     float[] positionReturn) {
        if (numEntries <
              0) {
            throw new java.lang.IllegalArgumentException(
              "numEntries argument value, " +
              numEntries +
              ", is illegal. It must be > 0.");
        }
        if (beginGlyphIndex <
              0) {
            throw new java.lang.IndexOutOfBoundsException(
              "beginGlyphIndex " +
              beginGlyphIndex +
              " is out of bounds, should be between 0 and " +
              (glyphs.
                 length -
                 1));
        }
        if (beginGlyphIndex +
              numEntries >
              glyphs.
                length +
              1) {
            throw new java.lang.IndexOutOfBoundsException(
              "beginGlyphIndex + numEntries (" +
              beginGlyphIndex +
              '+' +
              numEntries +
              ") exceeds the number of glpyhs in this GlyphVector");
        }
        if (positionReturn ==
              null) {
            positionReturn =
              (new float[numEntries *
                           2]);
        }
        if (beginGlyphIndex +
              numEntries ==
              glyphs.
                length +
              1) {
            numEntries--;
            positionReturn[numEntries *
                             2] =
              (float)
                endPos.
                getX(
                  );
            positionReturn[numEntries *
                             2 +
                             1] =
              (float)
                endPos.
                getY(
                  );
        }
        for (int i =
               beginGlyphIndex;
             i <
               beginGlyphIndex +
               numEntries;
             i++) {
            java.awt.geom.Point2D glyphPos;
            glyphPos =
              glyphs[i].
                getPosition(
                  );
            positionReturn[(i -
                              beginGlyphIndex) *
                             2] =
              (float)
                glyphPos.
                getX(
                  );
            positionReturn[(i -
                              beginGlyphIndex) *
                             2 +
                             1] =
              (float)
                glyphPos.
                getY(
                  );
        }
        return positionReturn;
    }
    public java.awt.geom.AffineTransform getGlyphTransform(int glyphIndex) {
        if (glyphIndex <
              0 ||
              glyphIndex >
              glyphs.
                length -
              1) {
            throw new java.lang.IndexOutOfBoundsException(
              "glyphIndex: " +
              glyphIndex +
              ", is out of bounds. Should be between 0 and " +
              (glyphs.
                 length -
                 1) +
              '.');
        }
        return glyphs[glyphIndex].
          getTransform(
            );
    }
    public java.awt.Shape getGlyphVisualBounds(int glyphIndex) {
        if (glyphIndex <
              0 ||
              glyphIndex >
              glyphs.
                length -
              1) {
            throw new java.lang.IndexOutOfBoundsException(
              "glyphIndex: " +
              glyphIndex +
              ", is out of bounds. Should be between 0 and " +
              (glyphs.
                 length -
                 1) +
              '.');
        }
        return glyphs[glyphIndex].
          getOutline(
            );
    }
    public java.awt.geom.Rectangle2D getBounds2D(java.text.AttributedCharacterIterator aci) {
        aci.
          first(
            );
        org.apache.batik.gvt.text.TextPaintInfo tpi =
          (org.apache.batik.gvt.text.TextPaintInfo)
            aci.
            getAttribute(
              PAINT_INFO);
        if (bounds2D !=
              null &&
              org.apache.batik.gvt.text.TextPaintInfo.
              equivilent(
                tpi,
                cacheTPI))
            return bounds2D;
        java.awt.geom.Rectangle2D b =
          null;
        if (tpi.
              visible) {
            for (int i =
                   0;
                 i <
                   getNumGlyphs(
                     );
                 i++) {
                if (!glyphVisible[i])
                    continue;
                java.awt.geom.Rectangle2D glyphBounds =
                  glyphs[i].
                  getBounds2D(
                    );
                if (glyphBounds ==
                      null)
                    continue;
                if (b ==
                      null)
                    b =
                      glyphBounds;
                else
                    b.
                      add(
                        glyphBounds);
            }
        }
        bounds2D =
          b;
        if (bounds2D ==
              null) {
            bounds2D =
              new java.awt.geom.Rectangle2D.Float(
                );
        }
        cacheTPI =
          new org.apache.batik.gvt.text.TextPaintInfo(
            tpi);
        return bounds2D;
    }
    public java.awt.geom.Rectangle2D getLogicalBounds() {
        if (logicalBounds ==
              null) {
            java.awt.geom.GeneralPath logicalBoundsPath =
              new java.awt.geom.GeneralPath(
              );
            for (int i =
                   0;
                 i <
                   getNumGlyphs(
                     );
                 i++) {
                java.awt.Shape glyphLogicalBounds =
                  getGlyphLogicalBounds(
                    i);
                if (glyphLogicalBounds !=
                      null) {
                    logicalBoundsPath.
                      append(
                        glyphLogicalBounds,
                        false);
                }
            }
            logicalBounds =
              logicalBoundsPath.
                getBounds2D(
                  );
        }
        return logicalBounds;
    }
    public int getNumGlyphs() { if (glyphs !=
                                      null) {
                                    return glyphs.
                                             length;
                                }
                                return 0;
    }
    public java.awt.Shape getOutline() { if (outline ==
                                               null) {
                                             outline =
                                               new java.awt.geom.GeneralPath(
                                                 );
                                             for (int i =
                                                    0;
                                                  i <
                                                    glyphs.
                                                      length;
                                                  i++) {
                                                 if (glyphVisible[i]) {
                                                     java.awt.Shape glyphOutline =
                                                       glyphs[i].
                                                       getOutline(
                                                         );
                                                     if (glyphOutline !=
                                                           null) {
                                                         outline.
                                                           append(
                                                             glyphOutline,
                                                             false);
                                                     }
                                                 }
                                             }
                                         }
                                         return outline;
    }
    public java.awt.Shape getOutline(float x,
                                     float y) {
        java.awt.Shape outline =
          getOutline(
            );
        java.awt.geom.AffineTransform tr =
          java.awt.geom.AffineTransform.
          getTranslateInstance(
            x,
            y);
        java.awt.Shape translatedOutline =
          tr.
          createTransformedShape(
            outline);
        return translatedOutline;
    }
    public java.awt.geom.Rectangle2D getGeometricBounds() {
        return getOutline(
                 ).
          getBounds2D(
            );
    }
    public void performDefaultLayout() { logicalBounds =
                                           null;
                                         outline =
                                           null;
                                         bounds2D =
                                           null;
                                         float currentX =
                                           0;
                                         float currentY =
                                           0;
                                         for (int i =
                                                0;
                                              i <
                                                glyphs.
                                                  length;
                                              i++) {
                                             org.apache.batik.gvt.font.Glyph g =
                                               glyphs[i];
                                             g.
                                               setTransform(
                                                 null);
                                             glyphLogicalBounds[i] =
                                               null;
                                             java.lang.String uni =
                                               g.
                                               getUnicode(
                                                 );
                                             if (uni !=
                                                   null &&
                                                   uni.
                                                   length(
                                                     ) !=
                                                   0 &&
                                                   org.apache.batik.gvt.text.ArabicTextHandler.
                                                   arabicCharTransparent(
                                                     uni.
                                                       charAt(
                                                         0))) {
                                                 int j;
                                                 for (j =
                                                        i +
                                                          1;
                                                      j <
                                                        glyphs.
                                                          length;
                                                      j++) {
                                                     uni =
                                                       glyphs[j].
                                                         getUnicode(
                                                           );
                                                     if (uni ==
                                                           null ||
                                                           uni.
                                                           length(
                                                             ) ==
                                                           0)
                                                         break;
                                                     char ch =
                                                       uni.
                                                       charAt(
                                                         0);
                                                     if (!org.apache.batik.gvt.text.ArabicTextHandler.
                                                           arabicCharTransparent(
                                                             ch))
                                                         break;
                                                 }
                                                 if (j !=
                                                       glyphs.
                                                         length) {
                                                     org.apache.batik.gvt.font.Glyph bg =
                                                       glyphs[j];
                                                     float rEdge =
                                                       currentX +
                                                       bg.
                                                       getHorizAdvX(
                                                         );
                                                     for (int k =
                                                            i;
                                                          k <
                                                            j;
                                                          k++) {
                                                         g =
                                                           glyphs[k];
                                                         g.
                                                           setTransform(
                                                             null);
                                                         glyphLogicalBounds[i] =
                                                           null;
                                                         g.
                                                           setPosition(
                                                             new java.awt.geom.Point2D.Float(
                                                               rEdge -
                                                                 g.
                                                                 getHorizAdvX(
                                                                   ),
                                                               currentY));
                                                     }
                                                     i =
                                                       j;
                                                     g =
                                                       bg;
                                                 }
                                             }
                                             g.
                                               setPosition(
                                                 new java.awt.geom.Point2D.Float(
                                                   currentX,
                                                   currentY));
                                             currentX +=
                                               g.
                                                 getHorizAdvX(
                                                   );
                                         }
                                         endPos =
                                           new java.awt.geom.Point2D.Float(
                                             currentX,
                                             currentY);
    }
    public void setGlyphPosition(int glyphIndex,
                                 java.awt.geom.Point2D newPos)
          throws java.lang.IndexOutOfBoundsException {
        if (glyphIndex ==
              glyphs.
                length) {
            endPos =
              (java.awt.geom.Point2D)
                newPos.
                clone(
                  );
            return;
        }
        if (glyphIndex <
              0 ||
              glyphIndex >
              glyphs.
                length -
              1) {
            throw new java.lang.IndexOutOfBoundsException(
              "glyphIndex: " +
              glyphIndex +
              ", is out of bounds. Should be between 0 and " +
              (glyphs.
                 length -
                 1) +
              '.');
        }
        glyphs[glyphIndex].
          setPosition(
            newPos);
        glyphLogicalBounds[glyphIndex] =
          null;
        outline =
          null;
        bounds2D =
          null;
        logicalBounds =
          null;
    }
    public void setGlyphTransform(int glyphIndex,
                                  java.awt.geom.AffineTransform newTX) {
        if (glyphIndex <
              0 ||
              glyphIndex >
              glyphs.
                length -
              1) {
            throw new java.lang.IndexOutOfBoundsException(
              "glyphIndex: " +
              glyphIndex +
              ", is out of bounds. Should be between 0 and " +
              (glyphs.
                 length -
                 1) +
              '.');
        }
        glyphs[glyphIndex].
          setTransform(
            newTX);
        glyphLogicalBounds[glyphIndex] =
          null;
        outline =
          null;
        bounds2D =
          null;
        logicalBounds =
          null;
    }
    public void setGlyphVisible(int glyphIndex,
                                boolean visible) {
        if (visible ==
              glyphVisible[glyphIndex])
            return;
        glyphVisible[glyphIndex] =
          visible;
        outline =
          null;
        bounds2D =
          null;
        logicalBounds =
          null;
        glyphLogicalBounds[glyphIndex] =
          null;
    }
    public boolean isGlyphVisible(int glyphIndex) {
        return glyphVisible[glyphIndex];
    }
    public int getCharacterCount(int startGlyphIndex,
                                 int endGlyphIndex) {
        int numChars =
          0;
        if (startGlyphIndex <
              0) {
            startGlyphIndex =
              0;
        }
        if (endGlyphIndex >
              glyphs.
                length -
              1) {
            endGlyphIndex =
              glyphs.
                length -
                1;
        }
        for (int i =
               startGlyphIndex;
             i <=
               endGlyphIndex;
             i++) {
            org.apache.batik.gvt.font.Glyph glyph =
              glyphs[i];
            if (glyph.
                  getGlyphCode(
                    ) ==
                  -1) {
                numChars++;
            }
            else {
                java.lang.String glyphUnicode =
                  glyph.
                  getUnicode(
                    );
                numChars +=
                  glyphUnicode.
                    length(
                      );
            }
        }
        return numChars;
    }
    public void draw(java.awt.Graphics2D graphics2D,
                     java.text.AttributedCharacterIterator aci) {
        aci.
          first(
            );
        org.apache.batik.gvt.text.TextPaintInfo tpi =
          (org.apache.batik.gvt.text.TextPaintInfo)
            aci.
            getAttribute(
              PAINT_INFO);
        if (!tpi.
               visible)
            return;
        for (int i =
               0;
             i <
               glyphs.
                 length;
             i++) {
            if (glyphVisible[i]) {
                glyphs[i].
                  draw(
                    graphics2D);
            }
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "9hncnM0iwUo8YCld4qd49tL/AphYFXc3RwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "mrAy608Wylon2VkVV2YzvAU7oTq04GyuTYZMt2YZoWF4WBRQeHfQq3IBMiUy" +
       "lYVHvXQquLYlJeF8lVUUaWyTG25OC7PtSF/628qCRmgfwQClcpUmJ43hVKu2" +
       "8AodTxINIeRBtT/2Ray77Gz7ZFMcSpLjdFs8o8uysArsmNtohCIYboCNRdxf" +
       "1JBmKFtGirDdbDzUfVJkYAUBsW5/0O6ZFZto4x2FWPXd6mxGVQbDtjtbEdm8" +
       "Tkvj6aTa42FxOVdQD1NmC0c2TG2S0ma2GnjenCE686E021Lbzrw78KYBFTo8" +
       "HA9WHr3edEMJn0+oSc+bmhqmVAVz29v2fVKDN7LUUpYhtmlTkDBqEM4iWbTr" +
       "GCfhPdhPdNcNOpPakA7wzsra6N4C7tWHqTFcz/vIaDjEWSGRia4fyESjv5lm" +
       "qGuilpB6aKu2UCtuJGJDjCZmqdVoznDgQKvoOHK3fNKqIEiXV3U3VmSnZ3Ja" +
       "byxJdpoplOtVexxsie5CioYYxk0XPaivtZr11aLXIUW9BkL5crrFycYWgieJ" +
       "yiD1aYt2pkEP4itddBX1SKfBdkZkM0unUCPouOISjtsxLmiQhNDJTEVgb65E" +
       "baHuztx6L8Wcquo0tKbOeGna9o1xZLFj2BZjoiq1w4rSX1nBOhv7ZXnirhR3" +
       "S1iWVdlY6GjYSFstnI7o+rRXlTR15Lnq0Ec3lMSSaCAmhtFWKLtL9YZVrVN3" +
       "7cZqG9qLKMPL3nJEUdPx2qaqa6ZjWEukuYksDfZXc1/CVTumw4ncgN1lSqsD" +
       "o10b1rqxSKypmKxDW5ba0quFKXV1Ut4y/npoVdX1ho8cUzQpL26w5U2gtlIL" +
       "UYcE53orHhOqXW7Z6LL2SJsFcr1HrbuQoUJrBR5UJ9NRPNSq7bo990ZNo7E0" +
       "W03J8qeE3Oe7m95KZsG0sTRo2t9iQAd0FrezPrXolauIqE076y3D0uUBaazj" +
       "OjdtNLIqDKyUtYnbaW2TdeT2eu7AGo4YynQGmRxPY/URvUQUHA/RVnkoUlJt" +
       "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" +
       "oUc1ImhmrrrLJtYeUs4iPziB95JGzC0c");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
