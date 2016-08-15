package org.apache.batik.gvt.font;
public class AWTGVTGlyphVector implements org.apache.batik.gvt.font.GVTGlyphVector {
    public static final java.text.AttributedCharacterIterator.Attribute PAINT_INFO =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        PAINT_INFO;
    private java.awt.font.GlyphVector awtGlyphVector;
    private org.apache.batik.gvt.font.AWTGVTFont gvtFont;
    private java.text.CharacterIterator ci;
    private java.awt.geom.Point2D[] defaultGlyphPositions;
    private java.awt.geom.Point2D.Float[] glyphPositions;
    private java.awt.geom.AffineTransform[] glyphTransforms;
    private java.awt.Shape[] glyphOutlines;
    private java.awt.Shape[] glyphVisualBounds;
    private java.awt.Shape[] glyphLogicalBounds;
    private boolean[] glyphVisible;
    private org.apache.batik.gvt.font.GVTGlyphMetrics[] glyphMetrics;
    private java.awt.geom.GeneralPath outline;
    private java.awt.geom.Rectangle2D visualBounds;
    private java.awt.geom.Rectangle2D logicalBounds;
    private java.awt.geom.Rectangle2D bounds2D;
    private float scaleFactor;
    private float ascent;
    private float descent;
    private org.apache.batik.gvt.text.TextPaintInfo cacheTPI;
    public AWTGVTGlyphVector(java.awt.font.GlyphVector glyphVector,
                             org.apache.batik.gvt.font.AWTGVTFont font,
                             float scaleFactor,
                             java.text.CharacterIterator ci) { super(
                                                                 );
                                                               this.
                                                                 awtGlyphVector =
                                                                 glyphVector;
                                                               this.
                                                                 gvtFont =
                                                                 font;
                                                               this.
                                                                 scaleFactor =
                                                                 scaleFactor;
                                                               this.
                                                                 ci =
                                                                 ci;
                                                               org.apache.batik.gvt.font.GVTLineMetrics lineMetrics =
                                                                 gvtFont.
                                                                 getLineMetrics(
                                                                   "By",
                                                                   awtGlyphVector.
                                                                     getFontRenderContext(
                                                                       ));
                                                               ascent =
                                                                 lineMetrics.
                                                                   getAscent(
                                                                     );
                                                               descent =
                                                                 lineMetrics.
                                                                   getDescent(
                                                                     );
                                                               outline =
                                                                 null;
                                                               visualBounds =
                                                                 null;
                                                               logicalBounds =
                                                                 null;
                                                               bounds2D =
                                                                 null;
                                                               int numGlyphs =
                                                                 glyphVector.
                                                                 getNumGlyphs(
                                                                   );
                                                               glyphPositions =
                                                                 (new java.awt.geom.Point2D.Float[numGlyphs +
                                                                                                    1]);
                                                               glyphTransforms =
                                                                 (new java.awt.geom.AffineTransform[numGlyphs]);
                                                               glyphOutlines =
                                                                 (new java.awt.Shape[numGlyphs]);
                                                               glyphVisualBounds =
                                                                 (new java.awt.Shape[numGlyphs]);
                                                               glyphLogicalBounds =
                                                                 (new java.awt.Shape[numGlyphs]);
                                                               glyphVisible =
                                                                 (new boolean[numGlyphs]);
                                                               glyphMetrics =
                                                                 (new org.apache.batik.gvt.font.GVTGlyphMetrics[numGlyphs]);
                                                               for (int i =
                                                                      0;
                                                                    i <
                                                                      numGlyphs;
                                                                    i++) {
                                                                   glyphVisible[i] =
                                                                     true;
                                                               }
    }
    public org.apache.batik.gvt.font.GVTFont getFont() {
        return gvtFont;
    }
    public java.awt.font.FontRenderContext getFontRenderContext() {
        return awtGlyphVector.
          getFontRenderContext(
            );
    }
    public int getGlyphCode(int glyphIndex) {
        return awtGlyphVector.
          getGlyphCode(
            glyphIndex);
    }
    public int[] getGlyphCodes(int beginGlyphIndex,
                               int numEntries,
                               int[] codeReturn) {
        return awtGlyphVector.
          getGlyphCodes(
            beginGlyphIndex,
            numEntries,
            codeReturn);
    }
    public java.awt.font.GlyphJustificationInfo getGlyphJustificationInfo(int glyphIndex) {
        return awtGlyphVector.
          getGlyphJustificationInfo(
            glyphIndex);
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
        if (tpi ==
              null)
            return null;
        if (!tpi.
               visible)
            return null;
        cacheTPI =
          new org.apache.batik.gvt.text.TextPaintInfo(
            tpi);
        java.awt.Shape outline =
          null;
        if (tpi.
              fillPaint !=
              null) {
            outline =
              getOutline(
                );
            bounds2D =
              outline.
                getBounds2D(
                  );
        }
        java.awt.Stroke stroke =
          tpi.
            strokeStroke;
        java.awt.Paint paint =
          tpi.
            strokePaint;
        if (stroke !=
              null &&
              paint !=
              null) {
            if (outline ==
                  null)
                outline =
                  getOutline(
                    );
            java.awt.geom.Rectangle2D strokeBounds =
              stroke.
              createStrokedShape(
                outline).
              getBounds2D(
                );
            if (bounds2D ==
                  null)
                bounds2D =
                  strokeBounds;
            else
                bounds2D.
                  add(
                    strokeBounds);
        }
        if (bounds2D ==
              null)
            return null;
        if (bounds2D.
              getWidth(
                ) ==
              0 ||
              bounds2D.
              getHeight(
                ) ==
              0)
            bounds2D =
              null;
        return bounds2D;
    }
    public java.awt.geom.Rectangle2D getLogicalBounds() {
        if (logicalBounds ==
              null) {
            computeGlyphLogicalBounds(
              );
        }
        return logicalBounds;
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
            float glyphX =
              0;
            float glyphY =
              -ascent /
              scaleFactor;
            float glyphWidth =
              glyphMetrics.
              getHorizontalAdvance(
                ) /
              scaleFactor;
            float glyphHeight =
              glyphMetrics.
              getVerticalAdvance(
                ) /
              scaleFactor;
            java.awt.geom.Rectangle2D glyphBounds =
              new java.awt.geom.Rectangle2D.Double(
              glyphX,
              glyphY,
              glyphWidth,
              glyphHeight);
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
                tr.
                  scale(
                    scaleFactor,
                    scaleFactor);
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
                      0.001 ||
                      java.lang.Math.
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
        logicalBounds =
          logicalBoundsPath.
            getBounds2D(
              );
        if (logicalBounds.
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
                    logicalBounds.
                      getMinY(
                        ),
                    width,
                    logicalBounds.
                      getHeight(
                        ));
            }
        }
        else
            if (logicalBounds.
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
                        logicalBounds.
                          getMinX(
                            ),
                        y,
                        logicalBounds.
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
    public org.apache.batik.gvt.font.GVTGlyphMetrics getGlyphMetrics(int glyphIndex) {
        if (glyphMetrics[glyphIndex] !=
              null)
            return glyphMetrics[glyphIndex];
        java.awt.geom.Point2D glyphPos =
          defaultGlyphPositions[glyphIndex];
        char c =
          ci.
          setIndex(
            ci.
              getBeginIndex(
                ) +
              glyphIndex);
        ci.
          setIndex(
            ci.
              getBeginIndex(
                ));
        org.apache.batik.gvt.font.AWTGlyphGeometryCache.Value v =
          org.apache.batik.gvt.font.AWTGVTFont.
          getGlyphGeometry(
            gvtFont,
            c,
            awtGlyphVector,
            glyphIndex,
            glyphPos);
        java.awt.geom.Rectangle2D gmB =
          v.
          getBounds2D(
            );
        java.awt.geom.Rectangle2D bounds =
          new java.awt.geom.Rectangle2D.Double(
          gmB.
            getX(
              ) *
            scaleFactor,
          gmB.
            getY(
              ) *
            scaleFactor,
          gmB.
            getWidth(
              ) *
            scaleFactor,
          gmB.
            getHeight(
              ) *
            scaleFactor);
        float adv =
          (float)
            (defaultGlyphPositions[glyphIndex +
                                     1].
               getX(
                 ) -
               defaultGlyphPositions[glyphIndex].
               getX(
                 ));
        glyphMetrics[glyphIndex] =
          new org.apache.batik.gvt.font.GVTGlyphMetrics(
            adv *
              scaleFactor,
            ascent +
              descent,
            bounds,
            java.awt.font.GlyphMetrics.
              STANDARD);
        return glyphMetrics[glyphIndex];
    }
    public java.awt.Shape getGlyphOutline(int glyphIndex) {
        if (glyphOutlines[glyphIndex] ==
              null) {
            java.awt.geom.Point2D glyphPos =
              defaultGlyphPositions[glyphIndex];
            char c =
              ci.
              setIndex(
                ci.
                  getBeginIndex(
                    ) +
                  glyphIndex);
            ci.
              setIndex(
                ci.
                  getBeginIndex(
                    ));
            org.apache.batik.gvt.font.AWTGlyphGeometryCache.Value v =
              org.apache.batik.gvt.font.AWTGVTFont.
              getGlyphGeometry(
                gvtFont,
                c,
                awtGlyphVector,
                glyphIndex,
                glyphPos);
            java.awt.Shape glyphOutline =
              v.
              getOutline(
                );
            java.awt.geom.AffineTransform tr =
              java.awt.geom.AffineTransform.
              getTranslateInstance(
                getGlyphPosition(
                  glyphIndex).
                  getX(
                    ),
                getGlyphPosition(
                  glyphIndex).
                  getY(
                    ));
            java.awt.geom.AffineTransform glyphTransform =
              getGlyphTransform(
                glyphIndex);
            if (glyphTransform !=
                  null) {
                tr.
                  concatenate(
                    glyphTransform);
            }
            tr.
              scale(
                scaleFactor,
                scaleFactor);
            glyphOutlines[glyphIndex] =
              tr.
                createTransformedShape(
                  glyphOutline);
        }
        return glyphOutlines[glyphIndex];
    }
    private static final boolean outlinesPositioned;
    private static final boolean drawGlyphVectorWorks;
    private static final boolean glyphVectorTransformWorks;
    static { java.lang.String s = java.lang.System.
               getProperty(
                 "java.specification.version");
             if ("1.4".compareTo(s) <= 0) {
                 outlinesPositioned =
                   true;
                 drawGlyphVectorWorks =
                   true;
                 glyphVectorTransformWorks =
                   true;
             }
             else
                 if ("Mac OS X".
                       equals(
                         java.lang.System.
                           getProperty(
                             "os.name"))) {
                     outlinesPositioned =
                       true;
                     drawGlyphVectorWorks =
                       false;
                     glyphVectorTransformWorks =
                       false;
                 }
                 else {
                     outlinesPositioned =
                       false;
                     drawGlyphVectorWorks =
                       true;
                     glyphVectorTransformWorks =
                       false;
                 } }
    static boolean outlinesPositioned() {
        return outlinesPositioned;
    }
    public java.awt.geom.Rectangle2D getGlyphCellBounds(int glyphIndex) {
        return getGlyphLogicalBounds(
                 glyphIndex).
          getBounds2D(
            );
    }
    public java.awt.geom.Point2D getGlyphPosition(int glyphIndex) {
        return glyphPositions[glyphIndex];
    }
    public float[] getGlyphPositions(int beginGlyphIndex,
                                     int numEntries,
                                     float[] positionReturn) {
        if (positionReturn ==
              null) {
            positionReturn =
              (new float[numEntries *
                           2]);
        }
        for (int i =
               beginGlyphIndex;
             i <
               beginGlyphIndex +
               numEntries;
             i++) {
            java.awt.geom.Point2D glyphPos =
              getGlyphPosition(
                i);
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
        return glyphTransforms[glyphIndex];
    }
    public java.awt.Shape getGlyphVisualBounds(int glyphIndex) {
        if (glyphVisualBounds[glyphIndex] ==
              null) {
            java.awt.geom.Point2D glyphPos =
              defaultGlyphPositions[glyphIndex];
            char c =
              ci.
              setIndex(
                ci.
                  getBeginIndex(
                    ) +
                  glyphIndex);
            ci.
              setIndex(
                ci.
                  getBeginIndex(
                    ));
            org.apache.batik.gvt.font.AWTGlyphGeometryCache.Value v =
              org.apache.batik.gvt.font.AWTGVTFont.
              getGlyphGeometry(
                gvtFont,
                c,
                awtGlyphVector,
                glyphIndex,
                glyphPos);
            java.awt.geom.Rectangle2D glyphBounds =
              v.
              getOutlineBounds2D(
                );
            java.awt.geom.AffineTransform tr =
              java.awt.geom.AffineTransform.
              getTranslateInstance(
                getGlyphPosition(
                  glyphIndex).
                  getX(
                    ),
                getGlyphPosition(
                  glyphIndex).
                  getY(
                    ));
            java.awt.geom.AffineTransform glyphTransform =
              getGlyphTransform(
                glyphIndex);
            if (glyphTransform !=
                  null) {
                tr.
                  concatenate(
                    glyphTransform);
            }
            tr.
              scale(
                scaleFactor,
                scaleFactor);
            glyphVisualBounds[glyphIndex] =
              tr.
                createTransformedShape(
                  glyphBounds);
        }
        return glyphVisualBounds[glyphIndex];
    }
    public int getNumGlyphs() { return awtGlyphVector.
                                  getNumGlyphs(
                                    ); }
    public java.awt.Shape getOutline() { if (outline !=
                                               null)
                                             return outline;
                                         outline =
                                           new java.awt.geom.GeneralPath(
                                             );
                                         for (int i =
                                                0;
                                              i <
                                                getNumGlyphs(
                                                  );
                                              i++) {
                                             if (glyphVisible[i]) {
                                                 java.awt.Shape glyphOutline =
                                                   getGlyphOutline(
                                                     i);
                                                 outline.
                                                   append(
                                                     glyphOutline,
                                                     false);
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
        outline =
          tr.
            createTransformedShape(
              outline);
        return outline;
    }
    public java.awt.geom.Rectangle2D getGeometricBounds() {
        if (visualBounds ==
              null) {
            java.awt.Shape outline =
              getOutline(
                );
            visualBounds =
              outline.
                getBounds2D(
                  );
        }
        return visualBounds;
    }
    public void performDefaultLayout() { if (defaultGlyphPositions ==
                                               null) {
                                             awtGlyphVector.
                                               performDefaultLayout(
                                                 );
                                             defaultGlyphPositions =
                                               (new java.awt.geom.Point2D.Float[getNumGlyphs(
                                                                                  ) +
                                                                                  1]);
                                             for (int i =
                                                    0;
                                                  i <=
                                                    getNumGlyphs(
                                                      );
                                                  i++)
                                                 defaultGlyphPositions[i] =
                                                   awtGlyphVector.
                                                     getGlyphPosition(
                                                       i);
                                         }
                                         outline =
                                           null;
                                         visualBounds =
                                           null;
                                         logicalBounds =
                                           null;
                                         bounds2D =
                                           null;
                                         float shiftLeft =
                                           0;
                                         int i =
                                           0;
                                         for (;
                                              i <
                                                getNumGlyphs(
                                                  );
                                              i++) {
                                             glyphTransforms[i] =
                                               null;
                                             glyphVisualBounds[i] =
                                               null;
                                             glyphLogicalBounds[i] =
                                               null;
                                             glyphOutlines[i] =
                                               null;
                                             glyphMetrics[i] =
                                               null;
                                             java.awt.geom.Point2D glyphPos =
                                               defaultGlyphPositions[i];
                                             float x =
                                               (float)
                                                 (glyphPos.
                                                    getX(
                                                      ) *
                                                    scaleFactor -
                                                    shiftLeft);
                                             float y =
                                               (float)
                                                 (glyphPos.
                                                    getY(
                                                      ) *
                                                    scaleFactor);
                                             ci.
                                               setIndex(
                                                 i +
                                                   ci.
                                                   getBeginIndex(
                                                     ));
                                             if (glyphPositions[i] ==
                                                   null) {
                                                 glyphPositions[i] =
                                                   new java.awt.geom.Point2D.Float(
                                                     x,
                                                     y);
                                             }
                                             else {
                                                 glyphPositions[i].
                                                   x =
                                                   x;
                                                 glyphPositions[i].
                                                   y =
                                                   y;
                                             }
                                         }
                                         java.awt.geom.Point2D glyphPos =
                                           defaultGlyphPositions[i];
                                         glyphPositions[i] =
                                           new java.awt.geom.Point2D.Float(
                                             (float)
                                               (glyphPos.
                                                  getX(
                                                    ) *
                                                  scaleFactor -
                                                  shiftLeft),
                                             (float)
                                               (glyphPos.
                                                  getY(
                                                    ) *
                                                  scaleFactor));
    }
    public void setGlyphPosition(int glyphIndex,
                                 java.awt.geom.Point2D newPos) {
        glyphPositions[glyphIndex].
          x =
          (float)
            newPos.
            getX(
              );
        glyphPositions[glyphIndex].
          y =
          (float)
            newPos.
            getY(
              );
        outline =
          null;
        visualBounds =
          null;
        logicalBounds =
          null;
        bounds2D =
          null;
        if (glyphIndex !=
              getNumGlyphs(
                )) {
            glyphVisualBounds[glyphIndex] =
              null;
            glyphLogicalBounds[glyphIndex] =
              null;
            glyphOutlines[glyphIndex] =
              null;
            glyphMetrics[glyphIndex] =
              null;
        }
    }
    public void setGlyphTransform(int glyphIndex,
                                  java.awt.geom.AffineTransform newTX) {
        glyphTransforms[glyphIndex] =
          newTX;
        outline =
          null;
        visualBounds =
          null;
        logicalBounds =
          null;
        bounds2D =
          null;
        glyphVisualBounds[glyphIndex] =
          null;
        glyphLogicalBounds[glyphIndex] =
          null;
        glyphOutlines[glyphIndex] =
          null;
        glyphMetrics[glyphIndex] =
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
        visualBounds =
          null;
        logicalBounds =
          null;
        bounds2D =
          null;
        glyphVisualBounds[glyphIndex] =
          null;
        glyphLogicalBounds[glyphIndex] =
          null;
        glyphOutlines[glyphIndex] =
          null;
        glyphMetrics[glyphIndex] =
          null;
    }
    public boolean isGlyphVisible(int glyphIndex) {
        return glyphVisible[glyphIndex];
    }
    public int getCharacterCount(int startGlyphIndex,
                                 int endGlyphIndex) {
        if (startGlyphIndex <
              0) {
            startGlyphIndex =
              0;
        }
        if (endGlyphIndex >=
              getNumGlyphs(
                )) {
            endGlyphIndex =
              getNumGlyphs(
                ) -
                1;
        }
        int charCount =
          0;
        int start =
          startGlyphIndex +
          ci.
          getBeginIndex(
            );
        int end =
          endGlyphIndex +
          ci.
          getBeginIndex(
            );
        for (char c =
               ci.
               setIndex(
                 start);
             ci.
               getIndex(
                 ) <=
               end;
             c =
               ci.
                 next(
                   )) {
            charCount +=
              org.apache.batik.gvt.text.ArabicTextHandler.
                getNumChars(
                  c);
        }
        return charCount;
    }
    public void draw(java.awt.Graphics2D graphics2D,
                     java.text.AttributedCharacterIterator aci) {
        int numGlyphs =
          getNumGlyphs(
            );
        aci.
          first(
            );
        org.apache.batik.gvt.text.TextPaintInfo tpi =
          (org.apache.batik.gvt.text.TextPaintInfo)
            aci.
            getAttribute(
              org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                PAINT_INFO);
        if (tpi ==
              null)
            return;
        if (!tpi.
               visible)
            return;
        java.awt.Paint fillPaint =
          tpi.
            fillPaint;
        java.awt.Stroke stroke =
          tpi.
            strokeStroke;
        java.awt.Paint strokePaint =
          tpi.
            strokePaint;
        if (fillPaint ==
              null &&
              (strokePaint ==
                 null ||
                 stroke ==
                 null))
            return;
        boolean useHinting =
          drawGlyphVectorWorks;
        if (useHinting &&
              stroke !=
              null &&
              strokePaint !=
              null)
            useHinting =
              false;
        if (useHinting &&
              fillPaint !=
              null &&
              !(fillPaint instanceof java.awt.Color))
            useHinting =
              false;
        if (useHinting) {
            java.lang.Object v1 =
              graphics2D.
              getRenderingHint(
                java.awt.RenderingHints.
                  KEY_TEXT_ANTIALIASING);
            java.lang.Object v2 =
              graphics2D.
              getRenderingHint(
                java.awt.RenderingHints.
                  KEY_STROKE_CONTROL);
            if (v1 ==
                  java.awt.RenderingHints.
                    VALUE_TEXT_ANTIALIAS_ON &&
                  v2 ==
                  java.awt.RenderingHints.
                    VALUE_STROKE_PURE)
                useHinting =
                  false;
        }
        final int typeGRot =
          java.awt.geom.AffineTransform.
            TYPE_GENERAL_ROTATION;
        final int typeGTrans =
          java.awt.geom.AffineTransform.
            TYPE_GENERAL_TRANSFORM;
        if (useHinting) {
            java.awt.geom.AffineTransform at =
              graphics2D.
              getTransform(
                );
            int type =
              at.
              getType(
                );
            if ((type &
                   typeGTrans) !=
                  0 ||
                  (type &
                     typeGRot) !=
                  0)
                useHinting =
                  false;
        }
        if (useHinting) {
            for (int i =
                   0;
                 i <
                   numGlyphs;
                 i++) {
                if (!glyphVisible[i]) {
                    useHinting =
                      false;
                    break;
                }
                java.awt.geom.AffineTransform at =
                  glyphTransforms[i];
                if (at !=
                      null) {
                    int type =
                      at.
                      getType(
                        );
                    if ((type &
                           ~java.awt.geom.AffineTransform.
                              TYPE_TRANSLATION) ==
                          0) {
                        
                    }
                    else
                        if (glyphVectorTransformWorks &&
                              (type &
                                 typeGTrans) ==
                              0 &&
                              (type &
                                 typeGRot) ==
                              0) {
                            
                        }
                        else {
                            useHinting =
                              false;
                            break;
                        }
                }
            }
        }
        if (useHinting) {
            double sf =
              scaleFactor;
            double[] mat =
              new double[6];
            for (int i =
                   0;
                 i <
                   numGlyphs;
                 i++) {
                java.awt.geom.Point2D pos =
                  glyphPositions[i];
                double x =
                  pos.
                  getX(
                    );
                double y =
                  pos.
                  getY(
                    );
                java.awt.geom.AffineTransform at =
                  glyphTransforms[i];
                if (at !=
                      null) {
                    at.
                      getMatrix(
                        mat);
                    x +=
                      mat[4];
                    y +=
                      mat[5];
                    if (mat[0] !=
                          1 ||
                          mat[1] !=
                          0 ||
                          mat[2] !=
                          0 ||
                          mat[3] !=
                          1) {
                        mat[4] =
                          0;
                        mat[5] =
                          0;
                        at =
                          new java.awt.geom.AffineTransform(
                            mat);
                    }
                    else {
                        at =
                          null;
                    }
                }
                pos =
                  new java.awt.geom.Point2D.Double(
                    x /
                      sf,
                    y /
                      sf);
                awtGlyphVector.
                  setGlyphPosition(
                    i,
                    pos);
                awtGlyphVector.
                  setGlyphTransform(
                    i,
                    at);
            }
            graphics2D.
              scale(
                sf,
                sf);
            graphics2D.
              setPaint(
                fillPaint);
            graphics2D.
              drawGlyphVector(
                awtGlyphVector,
                0,
                0);
            graphics2D.
              scale(
                1 /
                  sf,
                1 /
                  sf);
            for (int i =
                   0;
                 i <
                   numGlyphs;
                 i++) {
                java.awt.geom.Point2D pos =
                  defaultGlyphPositions[i];
                awtGlyphVector.
                  setGlyphPosition(
                    i,
                    pos);
                awtGlyphVector.
                  setGlyphTransform(
                    i,
                    null);
            }
        }
        else {
            java.awt.Shape outline =
              getOutline(
                );
            if (fillPaint !=
                  null) {
                graphics2D.
                  setPaint(
                    fillPaint);
                graphics2D.
                  fill(
                    outline);
            }
            if (stroke !=
                  null &&
                  strokePaint !=
                  null) {
                graphics2D.
                  setStroke(
                    stroke);
                graphics2D.
                  setPaint(
                    strokePaint);
                graphics2D.
                  draw(
                    outline);
            }
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "i2m81GTTuSskWPGXGZJL2SmeLft/Git9ubRRAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "7o0m5ZSTMbi9CKtCyvXr2TRKGvLGCgat7YKRswo5NSojWYWCTRCL/LSC+RA3" +
       "ZwEWnVaXirnCMAWZ+RtTqk2SDmcMmqs4ZZr+ui939LJeg+0oTggo8vVyK1A9" +
       "gmsmHEuOEZmaezVr0JOkkdpuyhNBmo7rLdXSaA+LY41nyvS6lWS6LAFfjy4h" +
       "fR3OZIhNxipu1oKMWDbZTqIgUV8PRoO6nTaruMc7EAd1IriOSKxS3QyiaTPA" +
       "y92YnpbrYMRhnFur1tGBOVYTKql0++iQDqb1ydwhJs2omlRESYZhYQVJ1X4n" +
       "buOz6chY99UI7bcilC7zJjBXSdDhN2J9PJJQpC1zosoNI3PqtKfdIKjr9fmm" +
       "sWwYZg+XUtwPNWvSkYSeus6qMc0QAUcwk3Q+E+SpWcugOKvPPLxsoVUN5mfK" +
       "ehKVRyMEySaMP2uTKBx2iTSaSPacJDIpGq/nnVTxsVWn0kNdB6tqUjjXoJHR" +
       "QClGFWV9hBKV6YgfmbbACCA+Y8pNDFLVLZHB5UWfsriKbkgZOfdovDFsqvjQ" +
       "EypMNumMYq5Fw+0yy647oy0xtLpyfzYjcI3BIbnW2LL2EN12tjHUkIakiKUY" +
       "0p7ZPWrSW6y6DYWUtllKtUOfrsxDAtvWUdRDYwh1F6PlpjWqZEqLhaq8DY3b" +
       "sAZV43Q6DLDWkvEYHCNhVy2X5dqMLNeQrWoiXQoWpWA7WOsrqO1sUWSDVbpm" +
       "AmLMfmAifDgITFeU/QaIZmi6kqh+V3EVOGDBZD/DNFPDKxFamSA1mQQOM671" +
       "OhVMLguqpwTCRm8rW8+TOxO5jhhzhZwnCDsfKRuqTm3trjWJEo7iXBqxN4Oh" +
       "kbFWECPGFjgUR8XJ+SYa1cgOhw9Tty7OlOqyjEYNbqvWJ1s+FGR4PFrjtbk7" +
       "qFmqi4hOx+qbyYSP67Y3IWFLM5dmV+H1KbdAeuVFu9XCyFaLanIsM06Ddidt" +
       "DtV1n3CTxqLTI4fdpJM24kGrS9vzSZB15uh6LtMWYeqDWUuPVmursmBlnZJH" +
       "xoqGUDQa4hq1JeubFkRG08FazsTmzIBBQLGVqKElJihDt7JtZAZrsxdZ9bnb" +
       "2fbxVO01bXPVdqdQdd3w2qOKv6nCg2k2Q5ucKBvj6VzrIuXBpL+CIAIKkCVf" +
       "xjkGTzq4t212MFhxeKSBbVe0TnYCxZVadL+PTlhMb6MNuNkGMYLfScIsa7I9" +
       "vVZuW5Q+GdQGZFIZlesYplY3/aBW3zQqUmPVEwi7V9d65Y0cAbdFqL1A8dcj" +
       "1XJdaZSaba8uUs12vafGzAQW8ErFXMttKEKcNpBQ1Y0WvN5glcagrjixvaRW" +
       "k9hB5nW+Oo5kP2u6mNCm7C5iCgHCayAOw6daMpm31ZCqMKjJBAHjcBxijxi4" +
       "UfdWUGckwe10EDm4a3SG4gIRCF8hMcaQlnpE4E69NegP/abiia0Fq44iYdBd" +
       "0mMxRqoU7HWJGuRlTlOoTTquOLQtjqt4btscmBWWmacINFbsjh5SnWREcfUY" +
       "JxokBffGEyFcEwHrTppkW1i6Q2uwbAWiMKTLYg2qW+G6B7szUVvRy1VCzLaS" +
       "JplrWF5b6BRZiOu0seXcJjWYNwREWg2TjkSJJNBs0rO6BLpoucKigdnddISF" +
       "IknJTQibU53VJk1Jwl/0VjQIduIuD8bBdDJhua2w4noEJ/WCWYZsu4uZviKn" +
       "K9KZ6htaqKgZPWBrGTGcLXrVlosQbgUZhIs01zByAvGaEEFcAIxZrK+HeKWc" +
       "VEGkTc0XdNqbTwaSUi5LGgWmbk3erM+aUIvW1KG2doZczxEZMG2obwb+fGoz" +
       "dWRboZQ4sXgkZRE7GOCBa8OEO69wQYXnZNaY4cPqRt9AWTzuCXy7DJMbTmla" +
       "CbHQvApVaYpiEg4NWKMwlRG5NdezRlPGLo+46YRGkEowhvpTe4zxcdyFO6jM" +
       "+nPAxjk6q1vLBRQsoXql54WVsToYLhbqlIbRmhLxMwhpGisU5hncnI6TrAyc" +
       "Fa+6+c4DNlvOBcErQ4MaEokKV+02yo1ereJ1uaQZzZbDYVRnhU6oCvyWHSw1" +
       "k6upVNqtojUy7ZgpJorDSohEVN3AJqjX");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "4hU/+sXf+9zvFbuk/x+YgF2ao18AAA==");
}
