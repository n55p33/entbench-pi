package org.apache.batik.gvt.text;
public class GlyphLayout implements org.apache.batik.gvt.text.TextSpanLayout {
    private org.apache.batik.gvt.font.GVTGlyphVector gv;
    private org.apache.batik.gvt.font.GVTFont font;
    private org.apache.batik.gvt.font.GVTLineMetrics metrics;
    private java.text.AttributedCharacterIterator aci;
    private java.awt.geom.Point2D advance;
    private java.awt.geom.Point2D offset;
    private float xScale = 1;
    private float yScale = 1;
    private org.apache.batik.gvt.text.TextPath textPath;
    private java.awt.geom.Point2D textPathAdvance;
    private int[] charMap;
    private boolean vertical;
    private boolean adjSpacing = true;
    private float[] glyphAdvances;
    private boolean isAltGlyph;
    private boolean layoutApplied = false;
    private boolean spacingApplied = false;
    private boolean pathApplied = false;
    public static final java.text.AttributedCharacterIterator.Attribute FLOW_LINE_BREAK =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        FLOW_LINE_BREAK;
    public static final java.text.AttributedCharacterIterator.Attribute
      FLOW_PARAGRAPH =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        FLOW_PARAGRAPH;
    public static final java.text.AttributedCharacterIterator.Attribute
      FLOW_EMPTY_PARAGRAPH =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        FLOW_EMPTY_PARAGRAPH;
    public static final java.text.AttributedCharacterIterator.Attribute
      LINE_HEIGHT =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        LINE_HEIGHT;
    public static final java.text.AttributedCharacterIterator.Attribute
      VERTICAL_ORIENTATION =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        VERTICAL_ORIENTATION;
    public static final java.text.AttributedCharacterIterator.Attribute
      VERTICAL_ORIENTATION_ANGLE =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        VERTICAL_ORIENTATION_ANGLE;
    public static final java.text.AttributedCharacterIterator.Attribute
      HORIZONTAL_ORIENTATION_ANGLE =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        HORIZONTAL_ORIENTATION_ANGLE;
    private static final java.text.AttributedCharacterIterator.Attribute
      X =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        X;
    private static final java.text.AttributedCharacterIterator.Attribute
      Y =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        Y;
    private static final java.text.AttributedCharacterIterator.Attribute
      DX =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        DX;
    private static final java.text.AttributedCharacterIterator.Attribute
      DY =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        DY;
    private static final java.text.AttributedCharacterIterator.Attribute
      ROTATION =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        ROTATION;
    private static final java.text.AttributedCharacterIterator.Attribute
      BASELINE_SHIFT =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        BASELINE_SHIFT;
    private static final java.text.AttributedCharacterIterator.Attribute
      WRITING_MODE =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        WRITING_MODE;
    private static final java.lang.Integer WRITING_MODE_TTB = org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                                                                WRITING_MODE_TTB;
    private static final java.lang.Integer ORIENTATION_AUTO =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        ORIENTATION_AUTO;
    public static final java.text.AttributedCharacterIterator.Attribute
      GVT_FONT =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        GVT_FONT;
    protected static java.util.Set runAtts = new java.util.HashSet(
      );
    static { runAtts.add(X);
             runAtts.add(Y);
             runAtts.add(DX);
             runAtts.add(DY);
             runAtts.add(ROTATION);
             runAtts.add(BASELINE_SHIFT); }
    protected static java.util.Set szAtts = new java.util.HashSet(
      );
    static { szAtts.add(java.awt.font.TextAttribute.SIZE);
             szAtts.add(GVT_FONT);
             szAtts.add(LINE_HEIGHT); }
    public GlyphLayout(java.text.AttributedCharacterIterator aci,
                       int[] charMap,
                       java.awt.geom.Point2D offset,
                       java.awt.font.FontRenderContext frc) {
        super(
          );
        this.
          aci =
          aci;
        this.
          offset =
          offset;
        this.
          font =
          getFont(
            );
        this.
          charMap =
          charMap;
        this.
          metrics =
          font.
            getLineMetrics(
              aci,
              aci.
                getBeginIndex(
                  ),
              aci.
                getEndIndex(
                  ),
              frc);
        this.
          gv =
          null;
        this.
          aci.
          first(
            );
        this.
          vertical =
          aci.
            getAttribute(
              WRITING_MODE) ==
            WRITING_MODE_TTB;
        this.
          textPath =
          (org.apache.batik.gvt.text.TextPath)
            aci.
            getAttribute(
              org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                TEXTPATH);
        org.apache.batik.gvt.font.AltGlyphHandler altGlyphHandler =
          (org.apache.batik.gvt.font.AltGlyphHandler)
            this.
              aci.
            getAttribute(
              org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                ALT_GLYPH_HANDLER);
        if (altGlyphHandler !=
              null) {
            this.
              gv =
              altGlyphHandler.
                createGlyphVector(
                  frc,
                  this.
                    font.
                    getSize(
                      ),
                  this.
                    aci);
            if (this.
                  gv !=
                  null) {
                this.
                  isAltGlyph =
                  true;
            }
        }
        if (this.
              gv ==
              null) {
            this.
              gv =
              font.
                createGlyphVector(
                  frc,
                  this.
                    aci);
        }
    }
    public org.apache.batik.gvt.font.GVTGlyphVector getGlyphVector() {
        return this.
                 gv;
    }
    public java.awt.geom.Point2D getOffset() {
        return offset;
    }
    public void setScale(float xScale, float yScale,
                         boolean adjSpacing) {
        if (vertical)
            xScale =
              1;
        else
            yScale =
              1;
        if (xScale !=
              this.
                xScale ||
              yScale !=
              this.
                yScale ||
              adjSpacing !=
              this.
                adjSpacing) {
            this.
              xScale =
              xScale;
            this.
              yScale =
              yScale;
            this.
              adjSpacing =
              adjSpacing;
            spacingApplied =
              false;
            glyphAdvances =
              null;
            pathApplied =
              false;
        }
    }
    public void setOffset(java.awt.geom.Point2D offset) {
        if (offset.
              getX(
                ) !=
              this.
                offset.
              getX(
                ) ||
              offset.
              getY(
                ) !=
              this.
                offset.
              getY(
                )) {
            if (layoutApplied ||
                  spacingApplied) {
                float dx =
                  (float)
                    (offset.
                       getX(
                         ) -
                       this.
                         offset.
                       getX(
                         ));
                float dy =
                  (float)
                    (offset.
                       getY(
                         ) -
                       this.
                         offset.
                       getY(
                         ));
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
                java.awt.geom.Point2D.Float pos =
                  new java.awt.geom.Point2D.Float(
                  );
                for (int i =
                       0;
                     i <=
                       numGlyphs;
                     i++) {
                    pos.
                      x =
                      gp[2 *
                           i] +
                        dx;
                    pos.
                      y =
                      gp[2 *
                           i +
                           1] +
                        dy;
                    gv.
                      setGlyphPosition(
                        i,
                        pos);
                }
            }
            this.
              offset =
              offset;
            pathApplied =
              false;
        }
    }
    public org.apache.batik.gvt.font.GVTGlyphMetrics getGlyphMetrics(int glyphIndex) {
        return gv.
          getGlyphMetrics(
            glyphIndex);
    }
    public org.apache.batik.gvt.font.GVTLineMetrics getLineMetrics() {
        return metrics;
    }
    public boolean isVertical() { return vertical;
    }
    public boolean isOnATextPath() { return textPath !=
                                       null;
    }
    public int getGlyphCount() { return gv.
                                   getNumGlyphs(
                                     ); }
    public int getCharacterCount(int startGlyphIndex,
                                 int endGlyphIndex) {
        return gv.
          getCharacterCount(
            startGlyphIndex,
            endGlyphIndex);
    }
    public boolean isLeftToRight() { aci.
                                       first(
                                         );
                                     int bidiLevel =
                                       ((java.lang.Integer)
                                          aci.
                                          getAttribute(
                                            org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                                              BIDI_LEVEL)).
                                       intValue(
                                         );
                                     return (bidiLevel &
                                               1) ==
                                       0;
    }
    private final void syncLayout() { if (!pathApplied) {
                                          doPathLayout(
                                            );
                                      } }
    public void draw(java.awt.Graphics2D g2d) {
        syncLayout(
          );
        gv.
          draw(
            g2d,
            aci);
    }
    public java.awt.geom.Point2D getAdvance2D() {
        adjustTextSpacing(
          );
        return advance;
    }
    public java.awt.Shape getOutline() { syncLayout(
                                           );
                                         return gv.
                                           getOutline(
                                             );
    }
    public float[] getGlyphAdvances() { if (glyphAdvances !=
                                              null)
                                            return glyphAdvances;
                                        if (!spacingApplied)
                                            adjustTextSpacing(
                                              );
                                        int numGlyphs =
                                          gv.
                                          getNumGlyphs(
                                            );
                                        float[] glyphPos =
                                          gv.
                                          getGlyphPositions(
                                            0,
                                            numGlyphs +
                                              1,
                                            null);
                                        glyphAdvances =
                                          (new float[numGlyphs +
                                                       1]);
                                        int off =
                                          0;
                                        if (isVertical(
                                              ))
                                            off =
                                              1;
                                        float start =
                                          glyphPos[off];
                                        for (int i =
                                               0;
                                             i <
                                               numGlyphs +
                                               1;
                                             i++) {
                                            glyphAdvances[i] =
                                              glyphPos[2 *
                                                         i +
                                                         off] -
                                                start;
                                        }
                                        return glyphAdvances;
    }
    public java.awt.Shape getDecorationOutline(int decorationType) {
        syncLayout(
          );
        java.awt.Shape g =
          new java.awt.geom.GeneralPath(
          );
        if ((decorationType &
               DECORATION_UNDERLINE) !=
              0) {
            ((java.awt.geom.GeneralPath)
               g).
              append(
                getUnderlineShape(
                  ),
                false);
        }
        if ((decorationType &
               DECORATION_STRIKETHROUGH) !=
              0) {
            ((java.awt.geom.GeneralPath)
               g).
              append(
                getStrikethroughShape(
                  ),
                false);
        }
        if ((decorationType &
               DECORATION_OVERLINE) !=
              0) {
            ((java.awt.geom.GeneralPath)
               g).
              append(
                getOverlineShape(
                  ),
                false);
        }
        return g;
    }
    public java.awt.geom.Rectangle2D getBounds2D() {
        syncLayout(
          );
        return gv.
          getBounds2D(
            aci);
    }
    public java.awt.geom.Rectangle2D getGeometricBounds() {
        syncLayout(
          );
        java.awt.geom.Rectangle2D gvB;
        java.awt.geom.Rectangle2D decB;
        gvB =
          gv.
            getGeometricBounds(
              );
        decB =
          getDecorationOutline(
            DECORATION_ALL).
            getBounds2D(
              );
        return gvB.
          createUnion(
            decB);
    }
    public java.awt.geom.Point2D getTextPathAdvance() {
        syncLayout(
          );
        if (textPath !=
              null) {
            return textPathAdvance;
        }
        else {
            return getAdvance2D(
                     );
        }
    }
    public int getGlyphIndex(int charIndex) {
        int numGlyphs =
          getGlyphCount(
            );
        int j =
          0;
        for (int i =
               0;
             i <
               numGlyphs;
             i++) {
            int count =
              getCharacterCount(
                i,
                i);
            for (int n =
                   0;
                 n <
                   count;
                 n++) {
                int glyphCharIndex =
                  charMap[j++];
                if (charIndex ==
                      glyphCharIndex)
                    return i;
                if (j >=
                      charMap.
                        length)
                    return -1;
            }
        }
        return -1;
    }
    public int getLastGlyphIndex(int charIndex) {
        int numGlyphs =
          getGlyphCount(
            );
        int j =
          charMap.
            length -
          1;
        for (int i =
               numGlyphs -
               1;
             i >=
               0;
             --i) {
            int count =
              getCharacterCount(
                i,
                i);
            for (int n =
                   0;
                 n <
                   count;
                 n++) {
                int glyphCharIndex =
                  charMap[j--];
                if (charIndex ==
                      glyphCharIndex)
                    return i;
                if (j <
                      0)
                    return -1;
            }
        }
        return -1;
    }
    public double getComputedOrientationAngle(int index) {
        if (isGlyphOrientationAuto(
              )) {
            if (isVertical(
                  )) {
                char ch =
                  aci.
                  setIndex(
                    index);
                if (isLatinChar(
                      ch))
                    return 90.0;
                else
                    return 0.0;
            }
            return 0.0;
        }
        else {
            return getGlyphOrientationAngle(
                     );
        }
    }
    public java.awt.Shape getHighlightShape(int beginCharIndex,
                                            int endCharIndex) {
        syncLayout(
          );
        if (beginCharIndex >
              endCharIndex) {
            int temp =
              beginCharIndex;
            beginCharIndex =
              endCharIndex;
            endCharIndex =
              temp;
        }
        java.awt.geom.GeneralPath shape =
          null;
        int numGlyphs =
          getGlyphCount(
            );
        java.awt.geom.Point2D.Float[] topPts =
          new java.awt.geom.Point2D.Float[2 *
                                            numGlyphs];
        java.awt.geom.Point2D.Float[] botPts =
          new java.awt.geom.Point2D.Float[2 *
                                            numGlyphs];
        int ptIdx =
          0;
        int currentChar =
          0;
        for (int i =
               0;
             i <
               numGlyphs;
             i++) {
            int glyphCharIndex =
              charMap[currentChar];
            if (glyphCharIndex >=
                  beginCharIndex &&
                  glyphCharIndex <=
                  endCharIndex &&
                  gv.
                  isGlyphVisible(
                    i)) {
                java.awt.Shape gbounds =
                  gv.
                  getGlyphLogicalBounds(
                    i);
                if (gbounds !=
                      null) {
                    if (shape ==
                          null)
                        shape =
                          new java.awt.geom.GeneralPath(
                            );
                    float[] pts =
                      new float[6];
                    int count =
                      0;
                    int type =
                      -1;
                    java.awt.geom.PathIterator pi =
                      gbounds.
                      getPathIterator(
                        null);
                    java.awt.geom.Point2D.Float firstPt =
                      null;
                    while (!pi.
                             isDone(
                               )) {
                        type =
                          pi.
                            currentSegment(
                              pts);
                        if (type ==
                              java.awt.geom.PathIterator.
                                SEG_MOVETO ||
                              type ==
                              java.awt.geom.PathIterator.
                                SEG_LINETO) {
                            if (count >
                                  4)
                                break;
                            if (count ==
                                  4) {
                                if (firstPt ==
                                      null ||
                                      firstPt.
                                        x !=
                                      pts[0] ||
                                      firstPt.
                                        y !=
                                      pts[1])
                                    break;
                            }
                            else {
                                java.awt.geom.Point2D.Float pt;
                                pt =
                                  new java.awt.geom.Point2D.Float(
                                    pts[0],
                                    pts[1]);
                                if (count ==
                                      0)
                                    firstPt =
                                      pt;
                                switch (count) {
                                    case 0:
                                        botPts[ptIdx] =
                                          pt;
                                        break;
                                    case 1:
                                        topPts[ptIdx] =
                                          pt;
                                        break;
                                    case 2:
                                        topPts[ptIdx +
                                                 1] =
                                          pt;
                                        break;
                                    case 3:
                                        botPts[ptIdx +
                                                 1] =
                                          pt;
                                        break;
                                }
                            }
                        }
                        else
                            if (type ==
                                  java.awt.geom.PathIterator.
                                    SEG_CLOSE) {
                                if (count <
                                      4 ||
                                      count >
                                      5)
                                    break;
                            }
                            else {
                                break;
                            }
                        count++;
                        pi.
                          next(
                            );
                    }
                    if (pi.
                          isDone(
                            )) {
                        if (botPts[ptIdx] !=
                              null &&
                              (topPts[ptIdx].
                                 x !=
                                 topPts[ptIdx +
                                          1].
                                   x ||
                                 topPts[ptIdx].
                                   y !=
                                 topPts[ptIdx +
                                          1].
                                   y))
                            ptIdx +=
                              2;
                    }
                    else {
                        addPtsToPath(
                          shape,
                          topPts,
                          botPts,
                          ptIdx);
                        ptIdx =
                          0;
                        shape.
                          append(
                            gbounds,
                            false);
                    }
                }
            }
            currentChar +=
              getCharacterCount(
                i,
                i);
            if (currentChar >=
                  charMap.
                    length)
                currentChar =
                  charMap.
                    length -
                    1;
        }
        addPtsToPath(
          shape,
          topPts,
          botPts,
          ptIdx);
        return shape;
    }
    public static final double eps = 1.0E-5;
    public static boolean epsEQ(double a,
                                double b) {
        return a +
          eps >
          b &&
          a -
          eps <
          b;
    }
    public static int makeConvexHull(java.awt.geom.Point2D.Float[] pts,
                                     int numPts) {
        java.awt.geom.Point2D.Float tmp;
        for (int i =
               1;
             i <
               numPts;
             i++) {
            if (pts[i].
                  x <
                  pts[i -
                        1].
                    x ||
                  pts[i].
                    x ==
                  pts[i -
                        1].
                    x &&
                  pts[i].
                    y <
                  pts[i -
                        1].
                    y) {
                tmp =
                  pts[i];
                pts[i] =
                  pts[i -
                        1];
                pts[i -
                      1] =
                  tmp;
                i =
                  0;
                continue;
            }
        }
        java.awt.geom.Point2D.Float pt0 =
          pts[0];
        java.awt.geom.Point2D.Float pt1 =
          pts[numPts -
                1];
        java.awt.geom.Point2D.Float dxdy =
          new java.awt.geom.Point2D.Float(
          pt1.
            x -
            pt0.
              x,
          pt1.
            y -
            pt0.
              y);
        float soln;
        float c =
          dxdy.
            y *
          pt0.
            x -
          dxdy.
            x *
          pt0.
            y;
        java.awt.geom.Point2D.Float[] topList =
          new java.awt.geom.Point2D.Float[numPts];
        java.awt.geom.Point2D.Float[] botList =
          new java.awt.geom.Point2D.Float[numPts];
        botList[0] =
          (topList[0] =
             pts[0]);
        int nTopPts =
          1;
        int nBotPts =
          1;
        for (int i =
               1;
             i <
               numPts -
               1;
             i++) {
            java.awt.geom.Point2D.Float pt =
              pts[i];
            soln =
              dxdy.
                x *
                pt.
                  y -
                dxdy.
                  y *
                pt.
                  x +
                c;
            if (soln <
                  0) {
                while (nBotPts >=
                         2) {
                    pt0 =
                      botList[nBotPts -
                                2];
                    pt1 =
                      botList[nBotPts -
                                1];
                    float dx =
                      pt1.
                        x -
                      pt0.
                        x;
                    float dy =
                      pt1.
                        y -
                      pt0.
                        y;
                    float c0 =
                      dy *
                      pt0.
                        x -
                      dx *
                      pt0.
                        y;
                    soln =
                      dx *
                        pt.
                          y -
                        dy *
                        pt.
                          x +
                        c0;
                    if (soln >
                          eps)
                        break;
                    if (soln >
                          -eps) {
                        if (pt1.
                              y <
                              pt.
                                y)
                            pt =
                              pt1;
                        nBotPts--;
                        break;
                    }
                    nBotPts--;
                }
                botList[nBotPts++] =
                  pt;
            }
            else {
                while (nTopPts >=
                         2) {
                    pt0 =
                      topList[nTopPts -
                                2];
                    pt1 =
                      topList[nTopPts -
                                1];
                    float dx =
                      pt1.
                        x -
                      pt0.
                        x;
                    float dy =
                      pt1.
                        y -
                      pt0.
                        y;
                    float c0 =
                      dy *
                      pt0.
                        x -
                      dx *
                      pt0.
                        y;
                    soln =
                      dx *
                        pt.
                          y -
                        dy *
                        pt.
                          x +
                        c0;
                    if (soln <
                          -eps)
                        break;
                    if (soln <
                          eps) {
                        if (pt1.
                              y >
                              pt.
                                y)
                            pt =
                              pt1;
                        nTopPts--;
                        break;
                    }
                    nTopPts--;
                }
                topList[nTopPts++] =
                  pt;
            }
        }
        java.awt.geom.Point2D.Float pt =
          pts[numPts -
                1];
        while (nBotPts >=
                 2) {
            pt0 =
              botList[nBotPts -
                        2];
            pt1 =
              botList[nBotPts -
                        1];
            float dx =
              pt1.
                x -
              pt0.
                x;
            float dy =
              pt1.
                y -
              pt0.
                y;
            float c0 =
              dy *
              pt0.
                x -
              dx *
              pt0.
                y;
            soln =
              dx *
                pt.
                  y -
                dy *
                pt.
                  x +
                c0;
            if (soln >
                  eps)
                break;
            if (soln >
                  -eps) {
                if (pt1.
                      y >=
                      pt.
                        y)
                    nBotPts--;
                break;
            }
            nBotPts--;
        }
        while (nTopPts >=
                 2) {
            pt0 =
              topList[nTopPts -
                        2];
            pt1 =
              topList[nTopPts -
                        1];
            float dx =
              pt1.
                x -
              pt0.
                x;
            float dy =
              pt1.
                y -
              pt0.
                y;
            float c0 =
              dy *
              pt0.
                x -
              dx *
              pt0.
                y;
            soln =
              dx *
                pt.
                  y -
                dy *
                pt.
                  x +
                c0;
            if (soln <
                  -eps)
                break;
            if (soln <
                  eps) {
                if (pt1.
                      y <=
                      pt.
                        y)
                    nTopPts--;
                break;
            }
            nTopPts--;
        }
        java.lang.System.
          arraycopy(
            topList,
            0,
            pts,
            0,
            nTopPts);
        int i =
          nTopPts;
        pts[i++] =
          pts[numPts -
                1];
        for (int n =
               nBotPts -
               1;
             n >
               0;
             n--,
               i++)
            pts[i] =
              botList[n];
        return i;
    }
    public static void addPtsToPath(java.awt.geom.GeneralPath shape,
                                    java.awt.geom.Point2D.Float[] topPts,
                                    java.awt.geom.Point2D.Float[] botPts,
                                    int numPts) {
        if (numPts <
              2)
            return;
        if (numPts ==
              2) {
            shape.
              moveTo(
                topPts[0].
                  x,
                topPts[0].
                  y);
            shape.
              lineTo(
                topPts[1].
                  x,
                topPts[1].
                  y);
            shape.
              lineTo(
                botPts[1].
                  x,
                botPts[1].
                  y);
            shape.
              lineTo(
                botPts[0].
                  x,
                botPts[0].
                  y);
            shape.
              lineTo(
                topPts[0].
                  x,
                topPts[0].
                  y);
            return;
        }
        java.awt.geom.Point2D.Float[] boxes =
          new java.awt.geom.Point2D.Float[8];
        java.awt.geom.Point2D.Float[] chull =
          new java.awt.geom.Point2D.Float[8];
        boxes[4] =
          topPts[0];
        boxes[5] =
          topPts[1];
        boxes[6] =
          botPts[1];
        boxes[7] =
          botPts[0];
        java.awt.geom.Area[] areas =
          new java.awt.geom.Area[numPts /
                                   2];
        int nAreas =
          0;
        for (int i =
               2;
             i <
               numPts;
             i +=
               2) {
            boxes[0] =
              boxes[4];
            boxes[1] =
              boxes[5];
            boxes[2] =
              boxes[6];
            boxes[3] =
              boxes[7];
            boxes[4] =
              topPts[i];
            boxes[5] =
              topPts[i +
                       1];
            boxes[6] =
              botPts[i +
                       1];
            boxes[7] =
              botPts[i];
            float delta;
            float sz;
            float dist;
            delta =
              boxes[2].
                x -
                boxes[0].
                  x;
            dist =
              delta *
                delta;
            delta =
              boxes[2].
                y -
                boxes[0].
                  y;
            dist +=
              delta *
                delta;
            sz =
              (float)
                java.lang.Math.
                sqrt(
                  dist);
            delta =
              boxes[6].
                x -
                boxes[4].
                  x;
            dist =
              delta *
                delta;
            delta =
              boxes[6].
                y -
                boxes[4].
                  y;
            dist +=
              delta *
                delta;
            sz +=
              (float)
                java.lang.Math.
                sqrt(
                  dist);
            delta =
              (boxes[0].
                 x +
                 boxes[1].
                   x +
                 boxes[2].
                   x +
                 boxes[3].
                   x -
                 (boxes[4].
                    x +
                    boxes[5].
                      x +
                    boxes[6].
                      x +
                    boxes[7].
                      x)) /
                4;
            dist =
              delta *
                delta;
            delta =
              (boxes[0].
                 y +
                 boxes[1].
                   y +
                 boxes[2].
                   y +
                 boxes[3].
                   y -
                 (boxes[4].
                    y +
                    boxes[5].
                      y +
                    boxes[6].
                      y +
                    boxes[7].
                      y)) /
                4;
            dist +=
              delta *
                delta;
            dist =
              (float)
                java.lang.Math.
                sqrt(
                  dist);
            java.awt.geom.GeneralPath gp =
              new java.awt.geom.GeneralPath(
              );
            if (dist <
                  sz) {
                java.lang.System.
                  arraycopy(
                    boxes,
                    0,
                    chull,
                    0,
                    8);
                int npts =
                  makeConvexHull(
                    chull,
                    8);
                gp.
                  moveTo(
                    chull[0].
                      x,
                    chull[0].
                      y);
                for (int n =
                       1;
                     n <
                       npts;
                     n++)
                    gp.
                      lineTo(
                        chull[n].
                          x,
                        chull[n].
                          y);
                gp.
                  closePath(
                    );
            }
            else {
                mergeAreas(
                  shape,
                  areas,
                  nAreas);
                nAreas =
                  0;
                if (i ==
                      2) {
                    gp.
                      moveTo(
                        boxes[0].
                          x,
                        boxes[0].
                          y);
                    gp.
                      lineTo(
                        boxes[1].
                          x,
                        boxes[1].
                          y);
                    gp.
                      lineTo(
                        boxes[2].
                          x,
                        boxes[2].
                          y);
                    gp.
                      lineTo(
                        boxes[3].
                          x,
                        boxes[3].
                          y);
                    gp.
                      closePath(
                        );
                    shape.
                      append(
                        gp,
                        false);
                    gp.
                      reset(
                        );
                }
                gp.
                  moveTo(
                    boxes[4].
                      x,
                    boxes[4].
                      y);
                gp.
                  lineTo(
                    boxes[5].
                      x,
                    boxes[5].
                      y);
                gp.
                  lineTo(
                    boxes[6].
                      x,
                    boxes[6].
                      y);
                gp.
                  lineTo(
                    boxes[7].
                      x,
                    boxes[7].
                      y);
                gp.
                  closePath(
                    );
            }
            areas[nAreas++] =
              new java.awt.geom.Area(
                gp);
        }
        mergeAreas(
          shape,
          areas,
          nAreas);
    }
    public static void mergeAreas(java.awt.geom.GeneralPath shape,
                                  java.awt.geom.Area[] shapes,
                                  int nShapes) {
        while (nShapes >
                 1) {
            int n =
              0;
            for (int i =
                   1;
                 i <
                   nShapes;
                 i +=
                   2) {
                shapes[i -
                         1].
                  add(
                    shapes[i]);
                shapes[n++] =
                  shapes[i -
                           1];
                shapes[i] =
                  null;
            }
            if ((nShapes &
                   1) ==
                  1)
                shapes[n -
                         1].
                  add(
                    shapes[nShapes -
                             1]);
            nShapes =
              nShapes /
                2;
        }
        if (nShapes ==
              1)
            shape.
              append(
                shapes[0],
                false);
    }
    public org.apache.batik.gvt.text.TextHit hitTestChar(float x,
                                                         float y) {
        syncLayout(
          );
        org.apache.batik.gvt.text.TextHit textHit =
          null;
        int currentChar =
          0;
        for (int i =
               0;
             i <
               gv.
               getNumGlyphs(
                 );
             i++) {
            java.awt.Shape gbounds =
              gv.
              getGlyphLogicalBounds(
                i);
            if (gbounds !=
                  null) {
                java.awt.geom.Rectangle2D gbounds2d =
                  gbounds.
                  getBounds2D(
                    );
                if (gbounds.
                      contains(
                        x,
                        y)) {
                    boolean isRightHalf =
                      x >
                      gbounds2d.
                      getX(
                        ) +
                      gbounds2d.
                      getWidth(
                        ) /
                      2.0;
                    boolean isLeadingEdge =
                      !isRightHalf;
                    int charIndex =
                      charMap[currentChar];
                    textHit =
                      new org.apache.batik.gvt.text.TextHit(
                        charIndex,
                        isLeadingEdge);
                    return textHit;
                }
            }
            currentChar +=
              getCharacterCount(
                i,
                i);
            if (currentChar >=
                  charMap.
                    length)
                currentChar =
                  charMap.
                    length -
                    1;
        }
        return textHit;
    }
    protected org.apache.batik.gvt.font.GVTFont getFont() {
        aci.
          first(
            );
        org.apache.batik.gvt.font.GVTFont gvtFont =
          (org.apache.batik.gvt.font.GVTFont)
            aci.
            getAttribute(
              GVT_FONT);
        if (gvtFont !=
              null)
            return gvtFont;
        return new org.apache.batik.gvt.font.AWTGVTFont(
          aci.
            getAttributes(
              ));
    }
    protected java.awt.Shape getOverlineShape() {
        double y =
          metrics.
          getOverlineOffset(
            );
        float overlineThickness =
          metrics.
          getOverlineThickness(
            );
        y +=
          overlineThickness;
        aci.
          first(
            );
        java.lang.Float dy =
          (java.lang.Float)
            aci.
            getAttribute(
              DY);
        if (dy !=
              null)
            y +=
              dy.
                floatValue(
                  );
        java.awt.Stroke overlineStroke =
          new java.awt.BasicStroke(
          overlineThickness);
        java.awt.geom.Rectangle2D logicalBounds =
          gv.
          getLogicalBounds(
            );
        return overlineStroke.
          createStrokedShape(
            new java.awt.geom.Line2D.Double(
              logicalBounds.
                getMinX(
                  ) +
                overlineThickness /
                2.0,
              offset.
                getY(
                  ) +
                y,
              logicalBounds.
                getMaxX(
                  ) -
                overlineThickness /
                2.0,
              offset.
                getY(
                  ) +
                y));
    }
    protected java.awt.Shape getUnderlineShape() {
        double y =
          metrics.
          getUnderlineOffset(
            );
        float underlineThickness =
          metrics.
          getUnderlineThickness(
            );
        y +=
          underlineThickness *
            1.5;
        java.awt.BasicStroke underlineStroke =
          new java.awt.BasicStroke(
          underlineThickness);
        aci.
          first(
            );
        java.lang.Float dy =
          (java.lang.Float)
            aci.
            getAttribute(
              DY);
        if (dy !=
              null)
            y +=
              dy.
                floatValue(
                  );
        java.awt.geom.Rectangle2D logicalBounds =
          gv.
          getLogicalBounds(
            );
        return underlineStroke.
          createStrokedShape(
            new java.awt.geom.Line2D.Double(
              logicalBounds.
                getMinX(
                  ) +
                underlineThickness /
                2.0,
              offset.
                getY(
                  ) +
                y,
              logicalBounds.
                getMaxX(
                  ) -
                underlineThickness /
                2.0,
              offset.
                getY(
                  ) +
                y));
    }
    protected java.awt.Shape getStrikethroughShape() {
        double y =
          metrics.
          getStrikethroughOffset(
            );
        float strikethroughThickness =
          metrics.
          getStrikethroughThickness(
            );
        java.awt.Stroke strikethroughStroke =
          new java.awt.BasicStroke(
          strikethroughThickness);
        aci.
          first(
            );
        java.lang.Float dy =
          (java.lang.Float)
            aci.
            getAttribute(
              DY);
        if (dy !=
              null)
            y +=
              dy.
                floatValue(
                  );
        java.awt.geom.Rectangle2D logicalBounds =
          gv.
          getLogicalBounds(
            );
        return strikethroughStroke.
          createStrokedShape(
            new java.awt.geom.Line2D.Double(
              logicalBounds.
                getMinX(
                  ) +
                strikethroughThickness /
                2.0,
              offset.
                getY(
                  ) +
                y,
              logicalBounds.
                getMaxX(
                  ) -
                strikethroughThickness /
                2.0,
              offset.
                getY(
                  ) +
                y));
    }
    protected void doExplicitGlyphLayout() {
        this.
          gv.
          performDefaultLayout(
            );
        float baselineAscent =
          vertical
          ? (float)
              gv.
              getLogicalBounds(
                ).
              getWidth(
                )
          : metrics.
          getAscent(
            ) +
          java.lang.Math.
          abs(
            metrics.
              getDescent(
                ));
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
        float verticalFirstOffset =
          0.0F;
        float horizontalFirstOffset =
          0.0F;
        boolean glyphOrientationAuto =
          isGlyphOrientationAuto(
            );
        int glyphOrientationAngle =
          0;
        if (!glyphOrientationAuto) {
            glyphOrientationAngle =
              getGlyphOrientationAngle(
                );
        }
        int i =
          0;
        int aciStart =
          aci.
          getBeginIndex(
            );
        int aciIndex =
          0;
        char ch =
          aci.
          first(
            );
        int runLimit =
          aciIndex +
          aciStart;
        java.lang.Float x =
          null;
        java.lang.Float y =
          null;
        java.lang.Float dx =
          null;
        java.lang.Float dy =
          null;
        java.lang.Float rotation =
          null;
        java.lang.Object baseline =
          null;
        float shift_x_pos =
          0;
        float shift_y_pos =
          0;
        float curr_x_pos =
          (float)
            offset.
            getX(
              );
        float curr_y_pos =
          (float)
            offset.
            getY(
              );
        java.awt.geom.Point2D.Float pos =
          new java.awt.geom.Point2D.Float(
          );
        boolean hasArabicTransparent =
          false;
        while (i <
                 numGlyphs) {
            if (aciIndex +
                  aciStart >=
                  runLimit) {
                runLimit =
                  aci.
                    getRunLimit(
                      runAtts);
                x =
                  (java.lang.Float)
                    aci.
                    getAttribute(
                      X);
                y =
                  (java.lang.Float)
                    aci.
                    getAttribute(
                      Y);
                dx =
                  (java.lang.Float)
                    aci.
                    getAttribute(
                      DX);
                dy =
                  (java.lang.Float)
                    aci.
                    getAttribute(
                      DY);
                rotation =
                  (java.lang.Float)
                    aci.
                    getAttribute(
                      ROTATION);
                baseline =
                  aci.
                    getAttribute(
                      BASELINE_SHIFT);
            }
            org.apache.batik.gvt.font.GVTGlyphMetrics gm =
              gv.
              getGlyphMetrics(
                i);
            if (i ==
                  0) {
                if (isVertical(
                      )) {
                    if (glyphOrientationAuto) {
                        if (isLatinChar(
                              ch)) {
                            verticalFirstOffset =
                              0.0F;
                        }
                        else {
                            float advY =
                              gm.
                              getVerticalAdvance(
                                );
                            float asc =
                              metrics.
                              getAscent(
                                );
                            float dsc =
                              metrics.
                              getDescent(
                                );
                            verticalFirstOffset =
                              asc +
                                (advY -
                                   (asc +
                                      dsc)) /
                                2;
                        }
                    }
                    else {
                        if (glyphOrientationAngle ==
                              0) {
                            float advY =
                              gm.
                              getVerticalAdvance(
                                );
                            float asc =
                              metrics.
                              getAscent(
                                );
                            float dsc =
                              metrics.
                              getDescent(
                                );
                            verticalFirstOffset =
                              asc +
                                (advY -
                                   (asc +
                                      dsc)) /
                                2;
                        }
                        else {
                            verticalFirstOffset =
                              0.0F;
                        }
                    }
                }
                else {
                    if (glyphOrientationAngle ==
                          270) {
                        horizontalFirstOffset =
                          (float)
                            gm.
                            getBounds2D(
                              ).
                            getHeight(
                              );
                    }
                    else {
                        horizontalFirstOffset =
                          0;
                    }
                }
            }
            else {
                if (glyphOrientationAuto &&
                      verticalFirstOffset ==
                      0.0F &&
                      !isLatinChar(
                         ch)) {
                    float advY =
                      gm.
                      getVerticalAdvance(
                        );
                    float asc =
                      metrics.
                      getAscent(
                        );
                    float dsc =
                      metrics.
                      getDescent(
                        );
                    verticalFirstOffset =
                      asc +
                        (advY -
                           (asc +
                              dsc)) /
                        2;
                }
            }
            float ox =
              0.0F;
            float oy =
              0.0F;
            float glyphOrientationRotation =
              0.0F;
            float glyphRotation =
              0.0F;
            if (ch !=
                  java.text.CharacterIterator.
                    DONE) {
                if (vertical) {
                    if (glyphOrientationAuto) {
                        if (isLatinChar(
                              ch)) {
                            glyphOrientationRotation =
                              (float)
                                (java.lang.Math.
                                   PI /
                                   2.0F);
                        }
                        else {
                            glyphOrientationRotation =
                              0.0F;
                        }
                    }
                    else {
                        glyphOrientationRotation =
                          (float)
                            java.lang.Math.
                            toRadians(
                              glyphOrientationAngle);
                    }
                    if (textPath !=
                          null) {
                        x =
                          null;
                    }
                }
                else {
                    glyphOrientationRotation =
                      (float)
                        java.lang.Math.
                        toRadians(
                          glyphOrientationAngle);
                    if (textPath !=
                          null) {
                        y =
                          null;
                    }
                }
                if (rotation ==
                      null ||
                      rotation.
                      isNaN(
                        )) {
                    glyphRotation =
                      glyphOrientationRotation;
                }
                else {
                    glyphRotation =
                      rotation.
                        floatValue(
                          ) +
                        glyphOrientationRotation;
                }
                if (x !=
                      null &&
                      !x.
                      isNaN(
                        )) {
                    if (i ==
                          0)
                        shift_x_pos =
                          (float)
                            (x.
                               floatValue(
                                 ) -
                               offset.
                               getX(
                                 ));
                    curr_x_pos =
                      x.
                        floatValue(
                          ) -
                        shift_x_pos;
                }
                if (dx !=
                      null &&
                      !dx.
                      isNaN(
                        )) {
                    curr_x_pos +=
                      dx.
                        floatValue(
                          );
                }
                if (y !=
                      null &&
                      !y.
                      isNaN(
                        )) {
                    if (i ==
                          0)
                        shift_y_pos =
                          (float)
                            (y.
                               floatValue(
                                 ) -
                               offset.
                               getY(
                                 ));
                    curr_y_pos =
                      y.
                        floatValue(
                          ) -
                        shift_y_pos;
                }
                if (dy !=
                      null &&
                      !dy.
                      isNaN(
                        )) {
                    curr_y_pos +=
                      dy.
                        floatValue(
                          );
                }
                else
                    if (i >
                          0) {
                        curr_y_pos +=
                          gp[i *
                               2 +
                               1] -
                            gp[i *
                                 2 -
                                 1];
                    }
                float baselineAdjust =
                  0.0F;
                if (baseline !=
                      null) {
                    if (baseline instanceof java.lang.Integer) {
                        if (baseline ==
                              java.awt.font.TextAttribute.
                                SUPERSCRIPT_SUPER) {
                            baselineAdjust =
                              baselineAscent *
                                0.5F;
                        }
                        else
                            if (baseline ==
                                  java.awt.font.TextAttribute.
                                    SUPERSCRIPT_SUB) {
                                baselineAdjust =
                                  -baselineAscent *
                                    0.5F;
                            }
                    }
                    else
                        if (baseline instanceof java.lang.Float) {
                            baselineAdjust =
                              ((java.lang.Float)
                                 baseline).
                                floatValue(
                                  );
                        }
                    if (vertical) {
                        ox =
                          baselineAdjust;
                    }
                    else {
                        oy =
                          -baselineAdjust;
                    }
                }
                if (vertical) {
                    oy +=
                      verticalFirstOffset;
                    if (glyphOrientationAuto) {
                        if (isLatinChar(
                              ch)) {
                            ox +=
                              metrics.
                                getStrikethroughOffset(
                                  );
                        }
                        else {
                            java.awt.geom.Rectangle2D glyphBounds =
                              gv.
                              getGlyphVisualBounds(
                                i).
                              getBounds2D(
                                );
                            ox -=
                              (float)
                                (glyphBounds.
                                   getMaxX(
                                     ) -
                                   gp[2 *
                                        i] -
                                   glyphBounds.
                                   getWidth(
                                     ) /
                                   2);
                        }
                    }
                    else {
                        java.awt.geom.Rectangle2D glyphBounds =
                          gv.
                          getGlyphVisualBounds(
                            i).
                          getBounds2D(
                            );
                        if (glyphOrientationAngle ==
                              0) {
                            ox -=
                              (float)
                                (glyphBounds.
                                   getMaxX(
                                     ) -
                                   gp[2 *
                                        i] -
                                   glyphBounds.
                                   getWidth(
                                     ) /
                                   2);
                        }
                        else
                            if (glyphOrientationAngle ==
                                  180) {
                                ox +=
                                  (float)
                                    (glyphBounds.
                                       getMaxX(
                                         ) -
                                       gp[2 *
                                            i] -
                                       glyphBounds.
                                       getWidth(
                                         ) /
                                       2);
                            }
                            else
                                if (glyphOrientationAngle ==
                                      90) {
                                    ox +=
                                      metrics.
                                        getStrikethroughOffset(
                                          );
                                }
                                else {
                                    ox -=
                                      metrics.
                                        getStrikethroughOffset(
                                          );
                                }
                    }
                }
                else {
                    ox +=
                      horizontalFirstOffset;
                    if (glyphOrientationAngle ==
                          90) {
                        oy -=
                          gm.
                            getHorizontalAdvance(
                              );
                    }
                    else
                        if (glyphOrientationAngle ==
                              180) {
                            oy -=
                              metrics.
                                getAscent(
                                  );
                        }
                }
            }
            pos.
              x =
              curr_x_pos +
                ox;
            pos.
              y =
              curr_y_pos +
                oy;
            gv.
              setGlyphPosition(
                i,
                pos);
            if (org.apache.batik.gvt.text.ArabicTextHandler.
                  arabicCharTransparent(
                    ch)) {
                hasArabicTransparent =
                  true;
            }
            else {
                if (vertical) {
                    float advanceY =
                      0;
                    if (glyphOrientationAuto) {
                        if (isLatinChar(
                              ch)) {
                            advanceY =
                              gm.
                                getHorizontalAdvance(
                                  );
                        }
                        else {
                            advanceY =
                              gm.
                                getVerticalAdvance(
                                  );
                        }
                    }
                    else {
                        if (glyphOrientationAngle ==
                              0 ||
                              glyphOrientationAngle ==
                              180) {
                            advanceY =
                              gm.
                                getVerticalAdvance(
                                  );
                        }
                        else
                            if (glyphOrientationAngle ==
                                  90) {
                                advanceY =
                                  gm.
                                    getHorizontalAdvance(
                                      );
                            }
                            else {
                                advanceY =
                                  gm.
                                    getHorizontalAdvance(
                                      );
                                gv.
                                  setGlyphTransform(
                                    i,
                                    java.awt.geom.AffineTransform.
                                      getTranslateInstance(
                                        0,
                                        advanceY));
                            }
                    }
                    curr_y_pos +=
                      advanceY;
                }
                else {
                    float advanceX =
                      0;
                    if (glyphOrientationAngle ==
                          0) {
                        advanceX =
                          gm.
                            getHorizontalAdvance(
                              );
                    }
                    else
                        if (glyphOrientationAngle ==
                              180) {
                            advanceX =
                              gm.
                                getHorizontalAdvance(
                                  );
                            gv.
                              setGlyphTransform(
                                i,
                                java.awt.geom.AffineTransform.
                                  getTranslateInstance(
                                    advanceX,
                                    0));
                        }
                        else {
                            advanceX =
                              gm.
                                getVerticalAdvance(
                                  );
                        }
                    curr_x_pos +=
                      advanceX;
                }
            }
            if (!epsEQ(
                   glyphRotation,
                   0)) {
                java.awt.geom.AffineTransform glyphTransform =
                  gv.
                  getGlyphTransform(
                    i);
                if (glyphTransform ==
                      null) {
                    glyphTransform =
                      new java.awt.geom.AffineTransform(
                        );
                }
                java.awt.geom.AffineTransform rotAt;
                if (epsEQ(
                      glyphRotation,
                      java.lang.Math.
                        PI /
                        2)) {
                    rotAt =
                      new java.awt.geom.AffineTransform(
                        0,
                        1,
                        -1,
                        0,
                        0,
                        0);
                }
                else
                    if (epsEQ(
                          glyphRotation,
                          java.lang.Math.
                            PI)) {
                        rotAt =
                          new java.awt.geom.AffineTransform(
                            -1,
                            0,
                            0,
                            -1,
                            0,
                            0);
                    }
                    else
                        if (epsEQ(
                              glyphRotation,
                              3 *
                                java.lang.Math.
                                  PI /
                                2)) {
                            rotAt =
                              new java.awt.geom.AffineTransform(
                                0,
                                -1,
                                1,
                                0,
                                0,
                                0);
                        }
                        else {
                            rotAt =
                              java.awt.geom.AffineTransform.
                                getRotateInstance(
                                  glyphRotation);
                        }
                glyphTransform.
                  concatenate(
                    rotAt);
                gv.
                  setGlyphTransform(
                    i,
                    glyphTransform);
            }
            aciIndex +=
              gv.
                getCharacterCount(
                  i,
                  i);
            if (aciIndex >=
                  charMap.
                    length)
                aciIndex =
                  charMap.
                    length -
                    1;
            ch =
              aci.
                setIndex(
                  aciIndex +
                    aciStart);
            i++;
        }
        pos.
          x =
          curr_x_pos;
        pos.
          y =
          curr_y_pos;
        gv.
          setGlyphPosition(
            i,
            pos);
        advance =
          new java.awt.geom.Point2D.Float(
            (float)
              (curr_x_pos -
                 offset.
                 getX(
                   )),
            (float)
              (curr_y_pos -
                 offset.
                 getY(
                   )));
        if (hasArabicTransparent) {
            ch =
              aci.
                first(
                  );
            aciIndex =
              0;
            i =
              0;
            int transparentStart =
              -1;
            while (i <
                     numGlyphs) {
                if (org.apache.batik.gvt.text.ArabicTextHandler.
                      arabicCharTransparent(
                        ch)) {
                    if (transparentStart ==
                          -1)
                        transparentStart =
                          i;
                }
                else {
                    if (transparentStart !=
                          -1) {
                        java.awt.geom.Point2D loc =
                          gv.
                          getGlyphPosition(
                            i);
                        org.apache.batik.gvt.font.GVTGlyphMetrics gm =
                          gv.
                          getGlyphMetrics(
                            i);
                        int tyS =
                          0;
                        int txS =
                          0;
                        float advX =
                          0;
                        float advY =
                          0;
                        if (vertical) {
                            if (glyphOrientationAuto ||
                                  glyphOrientationAngle ==
                                  90)
                                advY =
                                  gm.
                                    getHorizontalAdvance(
                                      );
                            else
                                if (glyphOrientationAngle ==
                                      270)
                                    advY =
                                      0;
                                else
                                    if (glyphOrientationAngle ==
                                          0)
                                        advX =
                                          gm.
                                            getHorizontalAdvance(
                                              );
                                    else
                                        advX =
                                          -gm.
                                            getHorizontalAdvance(
                                              );
                        }
                        else {
                            if (glyphOrientationAngle ==
                                  0)
                                advX =
                                  gm.
                                    getHorizontalAdvance(
                                      );
                            else
                                if (glyphOrientationAngle ==
                                      90)
                                    advY =
                                      gm.
                                        getHorizontalAdvance(
                                          );
                                else
                                    if (glyphOrientationAngle ==
                                          180)
                                        advX =
                                          0;
                                    else
                                        advY =
                                          -gm.
                                            getHorizontalAdvance(
                                              );
                        }
                        float baseX =
                          (float)
                            (loc.
                               getX(
                                 ) +
                               advX);
                        float baseY =
                          (float)
                            (loc.
                               getY(
                                 ) +
                               advY);
                        for (int j =
                               transparentStart;
                             j <
                               i;
                             j++) {
                            java.awt.geom.Point2D locT =
                              gv.
                              getGlyphPosition(
                                j);
                            org.apache.batik.gvt.font.GVTGlyphMetrics gmT =
                              gv.
                              getGlyphMetrics(
                                j);
                            float locX =
                              (float)
                                locT.
                                getX(
                                  );
                            float locY =
                              (float)
                                locT.
                                getY(
                                  );
                            float tx =
                              0;
                            float ty =
                              0;
                            float advT =
                              gmT.
                              getHorizontalAdvance(
                                );
                            if (vertical) {
                                if (glyphOrientationAuto ||
                                      glyphOrientationAngle ==
                                      90)
                                    locY =
                                      baseY -
                                        advT;
                                else
                                    if (glyphOrientationAngle ==
                                          270)
                                        locY =
                                          baseY +
                                            advT;
                                    else
                                        if (glyphOrientationAngle ==
                                              0)
                                            locX =
                                              baseX -
                                                advT;
                                        else
                                            locX =
                                              baseX +
                                                advT;
                            }
                            else {
                                if (glyphOrientationAngle ==
                                      0)
                                    locX =
                                      baseX -
                                        advT;
                                else
                                    if (glyphOrientationAngle ==
                                          90)
                                        locY =
                                          baseY -
                                            advT;
                                    else
                                        if (glyphOrientationAngle ==
                                              180)
                                            locX =
                                              baseX +
                                                advT;
                                        else
                                            locY =
                                              baseY +
                                                advT;
                            }
                            locT =
                              new java.awt.geom.Point2D.Double(
                                locX,
                                locY);
                            gv.
                              setGlyphPosition(
                                j,
                                locT);
                            if (txS !=
                                  0 ||
                                  tyS !=
                                  0) {
                                java.awt.geom.AffineTransform at;
                                at =
                                  java.awt.geom.AffineTransform.
                                    getTranslateInstance(
                                      tx,
                                      ty);
                                at.
                                  concatenate(
                                    gv.
                                      getGlyphTransform(
                                        i));
                                gv.
                                  setGlyphTransform(
                                    i,
                                    at);
                            }
                        }
                        transparentStart =
                          -1;
                    }
                }
                aciIndex +=
                  gv.
                    getCharacterCount(
                      i,
                      i);
                if (aciIndex >=
                      charMap.
                        length)
                    aciIndex =
                      charMap.
                        length -
                        1;
                ch =
                  aci.
                    setIndex(
                      aciIndex +
                        aciStart);
                i++;
            }
        }
        layoutApplied =
          true;
        spacingApplied =
          false;
        glyphAdvances =
          null;
        pathApplied =
          false;
    }
    protected void adjustTextSpacing() { if (spacingApplied)
                                             return;
                                         if (!layoutApplied)
                                             doExplicitGlyphLayout(
                                               );
                                         aci.
                                           first(
                                             );
                                         java.lang.Boolean customSpacing =
                                           (java.lang.Boolean)
                                             aci.
                                             getAttribute(
                                               org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                                                 CUSTOM_SPACING);
                                         if (customSpacing !=
                                               null &&
                                               customSpacing.
                                               booleanValue(
                                                 )) {
                                             advance =
                                               doSpacing(
                                                 (java.lang.Float)
                                                   aci.
                                                   getAttribute(
                                                     org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                                                       KERNING),
                                                 (java.lang.Float)
                                                   aci.
                                                   getAttribute(
                                                     org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                                                       LETTER_SPACING),
                                                 (java.lang.Float)
                                                   aci.
                                                   getAttribute(
                                                     org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                                                       WORD_SPACING));
                                             layoutApplied =
                                               false;
                                         }
                                         applyStretchTransform(
                                           !adjSpacing);
                                         spacingApplied =
                                           true;
                                         pathApplied =
                                           false;
    }
    protected java.awt.geom.Point2D doSpacing(java.lang.Float kern,
                                              java.lang.Float letterSpacing,
                                              java.lang.Float wordSpacing) {
        boolean autoKern =
          true;
        boolean doWordSpacing =
          false;
        boolean doLetterSpacing =
          false;
        float kernVal =
          0.0F;
        float letterSpacingVal =
          0.0F;
        if (kern !=
              null &&
              !kern.
              isNaN(
                )) {
            kernVal =
              kern.
                floatValue(
                  );
            autoKern =
              false;
        }
        if (letterSpacing !=
              null &&
              !letterSpacing.
              isNaN(
                )) {
            letterSpacingVal =
              letterSpacing.
                floatValue(
                  );
            doLetterSpacing =
              true;
        }
        if (wordSpacing !=
              null &&
              !wordSpacing.
              isNaN(
                )) {
            doWordSpacing =
              true;
        }
        int numGlyphs =
          gv.
          getNumGlyphs(
            );
        float dx =
          0.0F;
        float dy =
          0.0F;
        java.awt.geom.Point2D[] newPositions =
          new java.awt.geom.Point2D[numGlyphs +
                                      1];
        java.awt.geom.Point2D prevPos =
          gv.
          getGlyphPosition(
            0);
        int prevCode =
          gv.
          getGlyphCode(
            0);
        float x =
          (float)
            prevPos.
            getX(
              );
        float y =
          (float)
            prevPos.
            getY(
              );
        java.awt.geom.Point2D lastCharAdvance =
          new java.awt.geom.Point2D.Double(
          advance.
            getX(
              ) -
            (gv.
               getGlyphPosition(
                 numGlyphs -
                   1).
               getX(
                 ) -
               x),
          advance.
            getY(
              ) -
            (gv.
               getGlyphPosition(
                 numGlyphs -
                   1).
               getY(
                 ) -
               y));
        try {
            org.apache.batik.gvt.font.GVTFont font =
              gv.
              getFont(
                );
            if (numGlyphs >
                  1 &&
                  (doLetterSpacing ||
                     !autoKern)) {
                for (int i =
                       1;
                     i <=
                       numGlyphs;
                     ++i) {
                    java.awt.geom.Point2D gpos =
                      gv.
                      getGlyphPosition(
                        i);
                    int currCode;
                    currCode =
                      i ==
                        numGlyphs
                        ? -1
                        : gv.
                        getGlyphCode(
                          i);
                    dx =
                      (float)
                        gpos.
                        getX(
                          ) -
                        (float)
                          prevPos.
                          getX(
                            );
                    dy =
                      (float)
                        gpos.
                        getY(
                          ) -
                        (float)
                          prevPos.
                          getY(
                            );
                    if (autoKern) {
                        if (vertical)
                            dy +=
                              letterSpacingVal;
                        else
                            dx +=
                              letterSpacingVal;
                    }
                    else {
                        if (vertical) {
                            float vKern =
                              0;
                            if (currCode !=
                                  -1)
                                vKern =
                                  font.
                                    getVKern(
                                      prevCode,
                                      currCode);
                            dy +=
                              kernVal -
                                vKern +
                                letterSpacingVal;
                        }
                        else {
                            float hKern =
                              0;
                            if (currCode !=
                                  -1)
                                hKern =
                                  font.
                                    getHKern(
                                      prevCode,
                                      currCode);
                            dx +=
                              kernVal -
                                hKern +
                                letterSpacingVal;
                        }
                    }
                    x +=
                      dx;
                    y +=
                      dy;
                    newPositions[i] =
                      new java.awt.geom.Point2D.Float(
                        x,
                        y);
                    prevPos =
                      gpos;
                    prevCode =
                      currCode;
                }
                for (int i =
                       1;
                     i <=
                       numGlyphs;
                     ++i) {
                    if (newPositions[i] !=
                          null) {
                        gv.
                          setGlyphPosition(
                            i,
                            newPositions[i]);
                    }
                }
            }
            if (vertical) {
                lastCharAdvance.
                  setLocation(
                    lastCharAdvance.
                      getX(
                        ),
                    lastCharAdvance.
                      getY(
                        ) +
                      kernVal +
                      letterSpacingVal);
            }
            else {
                lastCharAdvance.
                  setLocation(
                    lastCharAdvance.
                      getX(
                        ) +
                      kernVal +
                      letterSpacingVal,
                    lastCharAdvance.
                      getY(
                        ));
            }
            dx =
              0.0F;
            dy =
              0.0F;
            prevPos =
              gv.
                getGlyphPosition(
                  0);
            x =
              (float)
                prevPos.
                getX(
                  );
            y =
              (float)
                prevPos.
                getY(
                  );
            if (numGlyphs >
                  1 &&
                  doWordSpacing) {
                for (int i =
                       1;
                     i <
                       numGlyphs;
                     i++) {
                    java.awt.geom.Point2D gpos =
                      gv.
                      getGlyphPosition(
                        i);
                    dx =
                      (float)
                        gpos.
                        getX(
                          ) -
                        (float)
                          prevPos.
                          getX(
                            );
                    dy =
                      (float)
                        gpos.
                        getY(
                          ) -
                        (float)
                          prevPos.
                          getY(
                            );
                    boolean inWS =
                      false;
                    int beginWS =
                      i;
                    int endWS =
                      i;
                    org.apache.batik.gvt.font.GVTGlyphMetrics gm =
                      gv.
                      getGlyphMetrics(
                        i);
                    while (gm.
                             getBounds2D(
                               ).
                             getWidth(
                               ) <
                             0.01 ||
                             gm.
                             isWhitespace(
                               )) {
                        if (!inWS)
                            inWS =
                              true;
                        if (i ==
                              numGlyphs -
                              1) {
                            break;
                        }
                        ++i;
                        ++endWS;
                        gpos =
                          gv.
                            getGlyphPosition(
                              i);
                        gm =
                          gv.
                            getGlyphMetrics(
                              i);
                    }
                    if (inWS) {
                        int nWS =
                          endWS -
                          beginWS;
                        float px =
                          (float)
                            prevPos.
                            getX(
                              );
                        float py =
                          (float)
                            prevPos.
                            getY(
                              );
                        dx =
                          (float)
                            (gpos.
                               getX(
                                 ) -
                               px) /
                            (nWS +
                               1);
                        dy =
                          (float)
                            (gpos.
                               getY(
                                 ) -
                               py) /
                            (nWS +
                               1);
                        if (vertical) {
                            dy +=
                              wordSpacing.
                                floatValue(
                                  ) /
                                (nWS +
                                   1);
                        }
                        else {
                            dx +=
                              wordSpacing.
                                floatValue(
                                  ) /
                                (nWS +
                                   1);
                        }
                        for (int j =
                               beginWS;
                             j <=
                               endWS;
                             ++j) {
                            x +=
                              dx;
                            y +=
                              dy;
                            newPositions[j] =
                              new java.awt.geom.Point2D.Float(
                                x,
                                y);
                        }
                    }
                    else {
                        dx =
                          (float)
                            (gpos.
                               getX(
                                 ) -
                               prevPos.
                               getX(
                                 ));
                        dy =
                          (float)
                            (gpos.
                               getY(
                                 ) -
                               prevPos.
                               getY(
                                 ));
                        x +=
                          dx;
                        y +=
                          dy;
                        newPositions[i] =
                          new java.awt.geom.Point2D.Float(
                            x,
                            y);
                    }
                    prevPos =
                      gpos;
                }
                java.awt.geom.Point2D gPos =
                  gv.
                  getGlyphPosition(
                    numGlyphs);
                x +=
                  (float)
                    (gPos.
                       getX(
                         ) -
                       prevPos.
                       getX(
                         ));
                y +=
                  (float)
                    (gPos.
                       getY(
                         ) -
                       prevPos.
                       getY(
                         ));
                newPositions[numGlyphs] =
                  new java.awt.geom.Point2D.Float(
                    x,
                    y);
                for (int i =
                       1;
                     i <=
                       numGlyphs;
                     ++i) {
                    if (newPositions[i] !=
                          null) {
                        gv.
                          setGlyphPosition(
                            i,
                            newPositions[i]);
                    }
                }
            }
        }
        catch (java.lang.Exception e) {
            e.
              printStackTrace(
                );
        }
        double advX =
          gv.
          getGlyphPosition(
            numGlyphs -
              1).
          getX(
            ) -
          gv.
          getGlyphPosition(
            0).
          getX(
            );
        double advY =
          gv.
          getGlyphPosition(
            numGlyphs -
              1).
          getY(
            ) -
          gv.
          getGlyphPosition(
            0).
          getY(
            );
        java.awt.geom.Point2D newAdvance =
          new java.awt.geom.Point2D.Double(
          advX +
            lastCharAdvance.
            getX(
              ),
          advY +
            lastCharAdvance.
            getY(
              ));
        return newAdvance;
    }
    protected void applyStretchTransform(boolean stretchGlyphs) {
        if (xScale ==
              1 &&
              yScale ==
              1)
            return;
        java.awt.geom.AffineTransform scaleAT =
          java.awt.geom.AffineTransform.
          getScaleInstance(
            xScale,
            yScale);
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
        float initX =
          gp[0];
        float initY =
          gp[1];
        java.awt.geom.Point2D.Float pos =
          new java.awt.geom.Point2D.Float(
          );
        for (int i =
               0;
             i <=
               numGlyphs;
             i++) {
            float dx =
              gp[2 *
                   i] -
              initX;
            float dy =
              gp[2 *
                   i +
                   1] -
              initY;
            pos.
              x =
              initX +
                dx *
                xScale;
            pos.
              y =
              initY +
                dy *
                yScale;
            gv.
              setGlyphPosition(
                i,
                pos);
            if (stretchGlyphs &&
                  i !=
                  numGlyphs) {
                java.awt.geom.AffineTransform glyphTransform =
                  gv.
                  getGlyphTransform(
                    i);
                if (glyphTransform !=
                      null) {
                    glyphTransform.
                      preConcatenate(
                        scaleAT);
                    gv.
                      setGlyphTransform(
                        i,
                        glyphTransform);
                }
                else {
                    gv.
                      setGlyphTransform(
                        i,
                        scaleAT);
                }
            }
        }
        advance =
          new java.awt.geom.Point2D.Float(
            (float)
              (advance.
                 getX(
                   ) *
                 xScale),
            (float)
              (advance.
                 getY(
                   ) *
                 yScale));
        layoutApplied =
          false;
    }
    protected void doPathLayout() { if (pathApplied)
                                        return;
                                    if (!spacingApplied)
                                        adjustTextSpacing(
                                          );
                                    getGlyphAdvances(
                                      );
                                    if (textPath ==
                                          null) {
                                        pathApplied =
                                          true;
                                        return;
                                    }
                                    boolean horizontal =
                                      !isVertical(
                                         );
                                    boolean glyphOrientationAuto =
                                      isGlyphOrientationAuto(
                                        );
                                    int glyphOrientationAngle =
                                      0;
                                    if (!glyphOrientationAuto) {
                                        glyphOrientationAngle =
                                          getGlyphOrientationAngle(
                                            );
                                    }
                                    float pathLength =
                                      textPath.
                                      lengthOfPath(
                                        );
                                    float startOffset =
                                      textPath.
                                      getStartOffset(
                                        );
                                    int numGlyphs =
                                      gv.
                                      getNumGlyphs(
                                        );
                                    for (int i =
                                           0;
                                         i <
                                           numGlyphs;
                                         i++) {
                                        gv.
                                          setGlyphVisible(
                                            i,
                                            true);
                                    }
                                    float glyphsLength;
                                    if (horizontal) {
                                        glyphsLength =
                                          (float)
                                            gv.
                                            getLogicalBounds(
                                              ).
                                            getWidth(
                                              );
                                    }
                                    else {
                                        glyphsLength =
                                          (float)
                                            gv.
                                            getLogicalBounds(
                                              ).
                                            getHeight(
                                              );
                                    }
                                    if (pathLength ==
                                          0.0F ||
                                          glyphsLength ==
                                          0.0F) {
                                        pathApplied =
                                          true;
                                        textPathAdvance =
                                          advance;
                                        return;
                                    }
                                    java.awt.geom.Point2D firstGlyphPosition =
                                      gv.
                                      getGlyphPosition(
                                        0);
                                    float glyphOffset =
                                      0;
                                    float currentPosition;
                                    if (horizontal) {
                                        glyphOffset =
                                          (float)
                                            firstGlyphPosition.
                                            getY(
                                              );
                                        currentPosition =
                                          (float)
                                            (firstGlyphPosition.
                                               getX(
                                                 ) +
                                               startOffset);
                                    }
                                    else {
                                        glyphOffset =
                                          (float)
                                            firstGlyphPosition.
                                            getX(
                                              );
                                        currentPosition =
                                          (float)
                                            (firstGlyphPosition.
                                               getY(
                                                 ) +
                                               startOffset);
                                    }
                                    char ch =
                                      aci.
                                      first(
                                        );
                                    int start =
                                      aci.
                                      getBeginIndex(
                                        );
                                    int currentChar =
                                      0;
                                    int lastGlyphDrawn =
                                      -1;
                                    float lastGlyphAdvance =
                                      0;
                                    for (int i =
                                           0;
                                         i <
                                           numGlyphs;
                                         i++) {
                                        java.awt.geom.Point2D currentGlyphPos =
                                          gv.
                                          getGlyphPosition(
                                            i);
                                        float glyphAdvance =
                                          0;
                                        float nextGlyphOffset =
                                          0;
                                        java.awt.geom.Point2D nextGlyphPosition =
                                          gv.
                                          getGlyphPosition(
                                            i +
                                              1);
                                        if (horizontal) {
                                            glyphAdvance =
                                              (float)
                                                (nextGlyphPosition.
                                                   getX(
                                                     ) -
                                                   currentGlyphPos.
                                                   getX(
                                                     ));
                                            nextGlyphOffset =
                                              (float)
                                                (nextGlyphPosition.
                                                   getY(
                                                     ) -
                                                   currentGlyphPos.
                                                   getY(
                                                     ));
                                        }
                                        else {
                                            glyphAdvance =
                                              (float)
                                                (nextGlyphPosition.
                                                   getY(
                                                     ) -
                                                   currentGlyphPos.
                                                   getY(
                                                     ));
                                            nextGlyphOffset =
                                              (float)
                                                (nextGlyphPosition.
                                                   getX(
                                                     ) -
                                                   currentGlyphPos.
                                                   getX(
                                                     ));
                                        }
                                        java.awt.geom.Rectangle2D glyphBounds =
                                          gv.
                                          getGlyphOutline(
                                            i).
                                          getBounds2D(
                                            );
                                        float glyphWidth =
                                          (float)
                                            glyphBounds.
                                            getWidth(
                                              );
                                        float glyphHeight =
                                          (float)
                                            glyphBounds.
                                            getHeight(
                                              );
                                        float glyphMidX =
                                          0;
                                        if (glyphWidth >
                                              0) {
                                            glyphMidX =
                                              (float)
                                                (glyphBounds.
                                                   getX(
                                                     ) +
                                                   glyphWidth /
                                                   2.0F);
                                            glyphMidX -=
                                              (float)
                                                currentGlyphPos.
                                                getX(
                                                  );
                                        }
                                        float glyphMidY =
                                          0;
                                        if (glyphHeight >
                                              0) {
                                            glyphMidY =
                                              (float)
                                                (glyphBounds.
                                                   getY(
                                                     ) +
                                                   glyphHeight /
                                                   2.0F);
                                            glyphMidY -=
                                              (float)
                                                currentGlyphPos.
                                                getY(
                                                  );
                                        }
                                        float charMidPos;
                                        if (horizontal) {
                                            charMidPos =
                                              currentPosition +
                                                glyphMidX;
                                        }
                                        else {
                                            charMidPos =
                                              currentPosition +
                                                glyphMidY;
                                        }
                                        java.awt.geom.Point2D charMidPoint =
                                          textPath.
                                          pointAtLength(
                                            charMidPos);
                                        if (charMidPoint !=
                                              null) {
                                            float angle =
                                              textPath.
                                              angleAtLength(
                                                charMidPos);
                                            java.awt.geom.AffineTransform glyphPathTransform =
                                              new java.awt.geom.AffineTransform(
                                              );
                                            if (horizontal) {
                                                glyphPathTransform.
                                                  rotate(
                                                    angle);
                                            }
                                            else {
                                                glyphPathTransform.
                                                  rotate(
                                                    angle -
                                                      java.lang.Math.
                                                        PI /
                                                      2);
                                            }
                                            if (horizontal) {
                                                glyphPathTransform.
                                                  translate(
                                                    0,
                                                    glyphOffset);
                                            }
                                            else {
                                                glyphPathTransform.
                                                  translate(
                                                    glyphOffset,
                                                    0);
                                            }
                                            if (horizontal) {
                                                glyphPathTransform.
                                                  translate(
                                                    -glyphMidX,
                                                    0.0F);
                                            }
                                            else {
                                                glyphPathTransform.
                                                  translate(
                                                    0.0F,
                                                    -glyphMidY);
                                            }
                                            java.awt.geom.AffineTransform glyphTransform =
                                              gv.
                                              getGlyphTransform(
                                                i);
                                            if (glyphTransform !=
                                                  null) {
                                                glyphPathTransform.
                                                  concatenate(
                                                    glyphTransform);
                                            }
                                            gv.
                                              setGlyphTransform(
                                                i,
                                                glyphPathTransform);
                                            gv.
                                              setGlyphPosition(
                                                i,
                                                charMidPoint);
                                            lastGlyphDrawn =
                                              i;
                                            lastGlyphAdvance =
                                              glyphAdvance;
                                        }
                                        else {
                                            gv.
                                              setGlyphVisible(
                                                i,
                                                false);
                                        }
                                        currentPosition +=
                                          glyphAdvance;
                                        glyphOffset +=
                                          nextGlyphOffset;
                                        currentChar +=
                                          gv.
                                            getCharacterCount(
                                              i,
                                              i);
                                        if (currentChar >=
                                              charMap.
                                                length)
                                            currentChar =
                                              charMap.
                                                length -
                                                1;
                                        ch =
                                          aci.
                                            setIndex(
                                              currentChar +
                                                start);
                                    }
                                    if (lastGlyphDrawn >
                                          -1) {
                                        java.awt.geom.Point2D lastGlyphPos =
                                          gv.
                                          getGlyphPosition(
                                            lastGlyphDrawn);
                                        if (horizontal) {
                                            textPathAdvance =
                                              new java.awt.geom.Point2D.Double(
                                                lastGlyphPos.
                                                  getX(
                                                    ) +
                                                  lastGlyphAdvance,
                                                lastGlyphPos.
                                                  getY(
                                                    ));
                                        }
                                        else {
                                            textPathAdvance =
                                              new java.awt.geom.Point2D.Double(
                                                lastGlyphPos.
                                                  getX(
                                                    ),
                                                lastGlyphPos.
                                                  getY(
                                                    ) +
                                                  lastGlyphAdvance);
                                        }
                                    }
                                    else {
                                        textPathAdvance =
                                          new java.awt.geom.Point2D.Double(
                                            0,
                                            0);
                                    }
                                    layoutApplied =
                                      false;
                                    spacingApplied =
                                      false;
                                    pathApplied =
                                      true;
    }
    protected boolean isLatinChar(char c) {
        if (c <
              255 &&
              java.lang.Character.
              isLetterOrDigit(
                c)) {
            return true;
        }
        java.lang.Character.UnicodeBlock block =
          java.lang.Character.UnicodeBlock.
          of(
            c);
        if (block ==
              java.lang.Character.UnicodeBlock.
                BASIC_LATIN ||
              block ==
              java.lang.Character.UnicodeBlock.
                LATIN_1_SUPPLEMENT ||
              block ==
              java.lang.Character.UnicodeBlock.
                LATIN_EXTENDED_ADDITIONAL ||
              block ==
              java.lang.Character.UnicodeBlock.
                LATIN_EXTENDED_A ||
              block ==
              java.lang.Character.UnicodeBlock.
                LATIN_EXTENDED_B ||
              block ==
              java.lang.Character.UnicodeBlock.
                ARABIC ||
              block ==
              java.lang.Character.UnicodeBlock.
                ARABIC_PRESENTATION_FORMS_A ||
              block ==
              java.lang.Character.UnicodeBlock.
                ARABIC_PRESENTATION_FORMS_B) {
            return true;
        }
        return false;
    }
    protected boolean isGlyphOrientationAuto() {
        if (!isVertical(
               ))
            return false;
        aci.
          first(
            );
        java.lang.Integer vOrient =
          (java.lang.Integer)
            aci.
            getAttribute(
              VERTICAL_ORIENTATION);
        if (vOrient !=
              null) {
            return vOrient ==
              ORIENTATION_AUTO;
        }
        return true;
    }
    protected int getGlyphOrientationAngle() {
        int glyphOrientationAngle =
          0;
        aci.
          first(
            );
        java.lang.Float angle;
        if (isVertical(
              )) {
            angle =
              (java.lang.Float)
                aci.
                getAttribute(
                  VERTICAL_ORIENTATION_ANGLE);
        }
        else {
            angle =
              (java.lang.Float)
                aci.
                getAttribute(
                  HORIZONTAL_ORIENTATION_ANGLE);
        }
        if (angle !=
              null) {
            glyphOrientationAngle =
              (int)
                angle.
                floatValue(
                  );
        }
        if (glyphOrientationAngle !=
              0 ||
              glyphOrientationAngle !=
              90 ||
              glyphOrientationAngle !=
              180 ||
              glyphOrientationAngle !=
              270) {
            while (glyphOrientationAngle <
                     0) {
                glyphOrientationAngle +=
                  360;
            }
            while (glyphOrientationAngle >=
                     360) {
                glyphOrientationAngle -=
                  360;
            }
            if (glyphOrientationAngle <=
                  45 ||
                  glyphOrientationAngle >
                  315) {
                glyphOrientationAngle =
                  0;
            }
            else
                if (glyphOrientationAngle >
                      45 &&
                      glyphOrientationAngle <=
                      135) {
                    glyphOrientationAngle =
                      90;
                }
                else
                    if (glyphOrientationAngle >
                          135 &&
                          glyphOrientationAngle <=
                          225) {
                        glyphOrientationAngle =
                          180;
                    }
                    else {
                        glyphOrientationAngle =
                          270;
                    }
        }
        return glyphOrientationAngle;
    }
    public boolean hasCharacterIndex(int index) {
        for (int n =
               0;
             n <
               charMap.
                 length;
             n++) {
            if (index ==
                  charMap[n])
                return true;
        }
        return false;
    }
    public boolean isAltGlyph() { return this.
                                           isAltGlyph;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "87ZecvTjd/N/HhA3tN3spazVMVLJ/48B");
    public static final java.lang.String jlc$ClassType$jl7$1 =
      ("qzRS9KCXuza7rqnta96bdf+01fYjJ3VcYcfOFzvGiM/4h7JoG4s8b9a36vMv" +
       "2H/+ro0PP7136jNhEtpGQholc7YVv9d5PJszydJtseIXcPdpJnvl/4Y1X5nY" +
       "dPLQH19gTx6Rovdle8sPxJ+996Kf37TwrmVhUt1BpqTQZbAXTjdPpLv1+JjZ" +
       "j/v2WsZBRaglpRkFb/eehWas4b/OYbwIOmfmz+K/nqBkZfGLzYv/Ycd0I7NL" +
       "N9l9daxmZoxUO2d4z3jeVZzLZj0CzhnRlZjig6oQoGBvgD0OxLZks/Z736ev" +
       "z7KB3OUfsKDhDrGv+G34/wEkg7BLPGsAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "MTU77kDpacDDtpkiUSdwUa40F7N1c9Fd");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("8i6XhJJvdWvYWpERtSqT0RJXGbRGU8gEE2B3tAw7gjyLCETSV4RoomCggBJV" +
       "DoUJtMnhCKXjo0mPjrpkFJgcXp303e5gnM4Zy7MQebpuqlWFCG201a4tFqjV" +
       "r+HzWqZ1BZvj27InjVYrZOGAIZfdoOMew/vFKYzKZgNLRwtuPQIhISpOacqy" +
       "1dk4osqzoZp5jF1KGC9iddoQCaAs/WZ7DbxBx+SLqafaVb/SKrEZwaa2jixo" +
       "0zOqjDgVKcscSfXE9h1LFQzKyibr6iRcVhoZhqEOEEbPzmqS167HgekMg1UT" +
       "bKOl0u+4JQoPW0OqxyO1equXjaW251hFKM1YuL3ihkJz5OkW73ojoloOpVYY" +
       "0wIxaxQtJSZor9WoNlqIPOKzbNzuZQZD0L2+i3WUgO7Aa2fpZXCYEPOyno7F" +
       "QRw0/KYwGahwNBhkY36kZsDv4ka11sBq4QpNywsWtsSBrefl2IFaNVGx0+Tn" +
       "Q4w35AUBrBUOkzOYmldmk4aHNtDiHOqLXG3i6mxSnEuc0zRwuVgr2zWfJa3G" +
       "esHKA3pVE4eEZM04k0qkVG0RU2y9LEkQiEAgDAlije72+gHcJJjYZGbA5AQT" +
       "vFEerFK82FnotWXIlTPTc11+qSLWsjy1JFJz1pI3rybjjqcU/VKozBc0GFPD" +
       "SZQ4o9AfAu9hGkaWdKmQJiZUXKXpntfUYZOIbWTAsmx1nLW0plu3LN0gJit/" +
       "hlbJkiUpBJTyIz3EacsZy8NluJCmOg47LhiQjeJ1NhJNAu4uUUEScQGdyEsM" +
       "5jpirYo59EpxvVUittystYj6JcEf4twKQkQ+qDjk3E7kjlmOIk4kw74nlijL" +
       "HQhdWzYwezwza63ILusJXyMjzJvWgC4RXtzBAyBsU1KiGtxvlBOhF5eNcORY" +
       "UQ/qVjpazxpg6DRoalY7QkLM7wQBHpc8toLpsjCvrqXeXCstpsm8LNcl2LYa" +
       "PTC2MyJ/wtsNKBuToLeg01DqJitzmESOghmE6iUJtVoXh4E5nDMmtdRkQy4P" +
       "F2CbKaU51xy1q1Oq5Ug8GAtybTTtOzjs4ZSOuZZAVNsdnzS9uoI1p+hQnXe0" +
       "4bA6MkYLM2l5hGaOZt1+1m4PLVOBw960EsYzBLFWsWMRrLMY6xgCrTlplA5E" +
       "R6Rr09itRyVHdJKh3BMqIZ6FCyULa8PMAwPFcr2PJlqFx+ZzzWLXHKqsHDzs" +
       "MOOYoPow1odGKD2cNkOdnNUSZRWhJjsdCmtgjlxg99Ylj9eWrWnYpyXGqaNS" +
       "I0XDsFin2kmgFeuZNR1UV/AgIFWs3EXcoD8pGzxSGqdkzRxAZZ0l4F46DIGf" +
       "EY0qFyzHVY4qa5AjQGV21Q4bM1/ScM2YEURzsiDLSJUQidGqUqwOGK7UhsZh" +
       "rz9gyRK5NgVoHKyGIlOLo3SJm60m2RO7Is2u9aW3JCd2c70el5IaUYxKTLTw" +
       "GjSGDgyTCDvjkkyMuumMclR/wE/aBklUA1HpZvNxs86WQ9CVtOYI15Chb0k1" +
       "suWtJ6PYHK1NArTthFojVUbuLWB52gzw0B6Vi3V/vBzhrZCi00nGVdiEXDVd" +
       "olUf9MZ8xwrxhoYuik2LLtciqVz15BrnMl5aX2h6NzYdLImiTi+Uic6wKlPB" +
       "AGAatxOn7zb6pMJ7mc2rxbmSEPi8awStsLfqrlk1NmfrEoN0Oamitpp+TVFl" +
       "cT71K0HdrhtapcOAkRWuJSAMECKz30KSVrNjDQbulB+25YkGXJE6bSPrqg78" +
       "rcezmTjRUhDu1XtuOpRCJwrdErh8vZkO/WpTiaG4Swb8su/Wmm5lGTCaBvl1" +
       "vrYeluuRXYrkyVyPXdAGi2rqpzzslZepPsvKmtcdLBqwXB97gzpaXZsjbtat" +
       "+l5WCuqx1VqEOBhhFOlpH4biHqU06lZMlEcV0q2sDQjRBRmSg2U0SpZVQfcl" +
       "dkwOuEXfHvWdJd3oyRHiywqBFIureDEdLxWFnMV9P2IEr5dCmA5ZU9ySYAXS" +
       "mvAUyyp4oIvVSFvUZqs2z6RTuoxMqhUdSSFRWrlOs9puuMHMnLuzEIwPOJFR" +
       "1WY97DVqDiNVWwt+Plin1Vm1V44GkVOKe0om2JJDdKGqETE2KVtVEiZqdMui" +
       "rDEll7FhN+UXVkD3BKMKNWjRLC1DJXaqISPbcDlsKGUm9Bq67hXxtZut1h6B" +
       "jVlGCoyJNBnq3mrgxkiKS5242+bXJIm0CKJhFKshwXSa46jHrgasUveNlFwU" +
       "e3a97pcEcgwvIRRNizJXBnq66ENgmLMMy1XIiZkAVjJMapdqE8EnbJzx5gvf" +
       "EKuaYzdsLwOjh6WqUFVnKWczfZhYTBfNLCg1HWu9imuzhCmu1kwA8cMahuPN" +
       "uVutDgehVGWWHLRK7VowzdCGgKYtiEnSsOGjYcdPJGukcw66XLcZrDasamGt" +
       "m6mjNe3CCwhFmHp12mpBYgdVBWGRBMkiWdojbuElrJumcV1bMoNFyy7jedzd" +
       "VLoEhhNoB5cgdbpEJ0hqjp1VY1zEPcnASy1nAbe7iA0lWcfs8mO0CZm+TVDq" +
       "ekwsXUFD7WpqReO1VcHCUWOBUS7Wikpx0l7VnBHX8rBODee7LM1qVDvuCK2W" +
       "VefbQ5kfW1TdBJaMrtlTnqwzoHu3wKBebsXVYJam4gDW5t1qAlmijtkGNVGm" +
       "stYwe5GelRbrqJqsBwYsrzA3tlW33+rUkdWgCxTWGsCU5altyQk0PymykhwU" +
       "M768pubDOtEXiXTWGUnttdaxl0mGtzrr8Wg2X6zGCqnZ7em63eFNS66NF5WW" +
       "3pl1SzGZdMYguO50elNnpg69trTu8BMFlcc061oMCEHUujYbOGt6UWNCytbm" +
       "ZlSNOli905bNETytyBiQvQ5kr8Qi1+ytom7aTkZupKoqMy71ez7NxyvGSVfr" +
       "zNZb3QoPmTaFCytgQqkO4jQ0d7rusAyvlbXYNYKSTXBKR6B8NFUyatqYoK1e" +
       "RemQipKlEWkaXmVaa3cbETGxhiVdcyZDOmWr3XJ7LczUmVgeyIMkVirzaQpG" +
       "LCYXoV4ijaNkKlakbsgCHenVmflYUiSIpsYLUZzyEhFEXk3oLLrMSCZCq5ew" +
       "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" +
       "EO83A74/u+P9s3e/XX/pgrxfyZNPhIVX");
    public static final java.lang.String jlc$ClassType$jl5$2 =
      ("6MHGFJ+ch4hC5xTTT151UAGcz/2f3DH95N1n+hsX5P2nPPn3YeHJw1m0M6Zc" +
       "Tg4rf/2qYwAQGt7/5zuuf35Jrnc4zXTwexcQzhc7P/gMcEKaGByv0Xw4oXai" +
       "VX/7LtzQ8cCD27rb/dWZniTyuQvy/keefPb2ddKP2f3xZdiloKOfCEny9xU+" +
       "edtbg7dvupV+8iPXHnjlR8af3r4L8PBttA+ShQeWkWmefPvYie/3ub6y1DeU" +
       "H9ykj7obHv8nLLzq3CEZsFX5Lkd78Gfb8n8eFp44q3xYOADpyZJ/BUYIp0uG" +
       "hXs3+xPl7tkHQjwuFxbu2345WeRecHZQJP96n3sYH5xYo237urZ0a22fPKkw" +
       "G/qPv1BLHFU5+brMfEi6eb/z4TvKIma3gOJHPzIYfuPnaz+6fV2nZIpZlp/l" +
       "AbJw//bNoZuT5u85e/25Zzs81329N37x0Z968NnD+0wf3QI+Vt4T2J4++92Y" +
       "HcsNN2+zzH7mlf/0rT/2kd/aLNj3/wBnPS9veHsAAA==");
}
