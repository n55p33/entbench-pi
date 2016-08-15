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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "bjC4OZtFgpV4wFK6xE/x7KX/Bdfqzlw3RwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL18C9Dr6Fme/393z16yt+ySZLNkd5PsbiBxOLIlW7ZnSRrL" +
       "tizJsiRL8kWm7IkkS7Ksq3WzrDSFhEJCmYZQEpIWsrQzJLR0Q6CFKQzQLtOB" +
       "EEJhuBVopyR0SgultGQ60A5pSz/J/i/nP+f/d8+ec+oZfZb03d7nfd/v/d73" +
       "0ye9+Kelu8KgVPY9e2vYXnRZS6PLK7t+Odr6WniZouucHITaomPLYSiCe1fU" +
       "t/7YQ3/x1Y8uHz4sXZqXHpVd14vkyPTckNdCz060BV166ORuz9acMCo9TK/k" +
       "RIbiyLQh2gyj5+jSa05VjUrP0EckQIAECJAAFSRA7ZNSoNIDmhs7nbyG7Ebh" +
       "uvQ3Swd06ZKv5uRFpbdc3YgvB7Kzb4YrEIAW7smvJwBUUTkNSm8+xr7DfA3g" +
       "j5ehj33i+Yf/6R2lh+alh0xXyMlRARER6GReut/RHEULwvZioS3mpde6mrYQ" +
       "tMCUbTMr6J6XHglNw5WjONCOmZTfjH0tKPo84dz9ao4tiNXIC47h6aZmL46u" +
       "7tJt2QBYX3+CdYcQz+8DgPeZgLBAl1XtqMqdlukuotJTZ2scY3xmAAqAqnc7" +
       "WrT0jru605XBjdIjO9nZsmtAQhSYrgGK3uXFoJeo9Pi5jea89mXVkg3tSlR6" +
       "7Gw5bpcFSt1bMCKvEpVed7ZY0RKQ0uNnpHRKPn/KfONH3ucS7mFB80JT7Zz+" +
       "e0ClJ89U4jVdCzRX1XYV738H/X3y63/uw4elEij8ujOFd2X++d/4ynve+eRL" +
       "v7Qr87XXKcMqK02Nrqg/pDz462/qvL11R07GPb4Xmrnwr0JeqD+3z3ku9cHI" +
       "e/1xi3nm5aPMl/hflL71R7Q/OSzdR5YuqZ4dO0CPXqt6jm/aWtDXXC2QI21B" +
       "lu7V3EWnyCdLd4Nz2nS13V1W10MtIkt32sWtS15xDVikgyZyFt0Nzk1X947O" +
       "fTlaFuepXyqVHgBH6d3geHtp9yv+o9Lz0NJzNEhWZdd0PYgLvBx/CGlupADe" +
       "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" +
       "WR25ZCOE5sa6u2pi7RFpL/OD5Tk3bkTs");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
