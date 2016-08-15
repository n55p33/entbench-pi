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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "87ZecvTjd/N/HhA3tN3spazVMVLJ/48B");
    public static final java.lang.String jlc$ClassType$jl7$1 =
      ("qzRS9KCXuza7rqnta96bdf+01fYjJ3VcYcfOFzvGiM/4h7JoG4s8b9a36vMv" +
       "2H/+ro0PP7136jNhEtpGQholc7YVv9d5PJszydJtseIXcPdpJnvl/4Y1X5nY" +
       "dPLQH19gTx6Rovdle8sPxJ+996Kf37TwrmVhUt1BpqTQZbAXTjdPpLv1+JjZ" +
       "j/v2WsZBRaglpRkFb/eehWas4b/OYbwIOmfmz+K/nqBkZfGLzYv/Ycd0I7NL" +
       "N9l9daxmZoxUO2d4z3jeVZzLZj0CzhnRlZjig6oQoGBvgD0OxLZks/Z736cv" +
       "zLKB3OUfsKDhDrGv+G34/wH07b+bPGsAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ZIbt6Y2p2XEHSk8DHrbNFIk6gYtypbmY");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "ftH15l+M99sA35/f8f75e9+uv3JJ3q/l");
    public static final java.lang.String jlc$ClassType$jl5$2 =
      ("yafCwqv0YGOKT85DRKFzhumnrzuoAM7nwU/vmH763jP9rUvy/nOe/Mew8PTh" +
       "LNo5Uy4nh5W/ed0xAAgNH/zLHde/vCLXu5xmOviDSwjni50ffA44IU0Mjtdo" +
       "PpxQO9Gqv3sPbuh46OFt3e3++kxPEvnCJXn/d558/s510o/Z/elV2KWgo58I" +
       "SfL3FT59x1uDt2+6lX76YzceevXHxp/dvgvw8G20D5OFh5aRaZ58+9iJ7w+4" +
       "vrLUN5Qf3qSPuxse/29YeM2FQzJgq/JdjvbgL7bl/zIsPHVe+bBwANKTJf8G" +
       "jBDOlgwL92/2J8rdtw+EeFwuLDyw/XKyyP3g7KBI/vUB9zA+OLFG2/Z1benW" +
       "2j59UmE29J98sZY4qnLydZn5kHTzfufDd5RFzG4BxY9/bDD81i/Wfnz7uk7J" +
       "FLMsP8tDZOHB7ZtDNyfN33P2xgvPdniuB3pv+fLjP/Pwmw/vM318C/hYeU9g" +
       "e/b8d2N2LDfcvM0y+7lX/6t3/MTHfmezYN//D7cBZRl4ewAA");
}
