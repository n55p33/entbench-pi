package org.apache.batik.gvt.flow;
public class LineInfo {
    org.apache.batik.gvt.flow.FlowRegions fr;
    double lineHeight = -1;
    double ascent = -1;
    double descent = -1;
    double hLeading = -1;
    double baseline;
    int numGlyphs;
    int words = 0;
    int size = 0;
    org.apache.batik.gvt.flow.GlyphGroupInfo[] ggis = null;
    int newSize = 0;
    org.apache.batik.gvt.flow.GlyphGroupInfo[] newGGIS = null;
    int numRanges;
    double[] ranges;
    double[] rangeAdv;
    org.apache.batik.gvt.flow.BlockInfo bi = null;
    boolean paraStart;
    boolean paraEnd;
    protected static final int FULL_WORD = 0;
    protected static final int FULL_ADV = 1;
    public LineInfo(org.apache.batik.gvt.flow.FlowRegions fr, org.apache.batik.gvt.flow.BlockInfo bi,
                    boolean paraStart) { super();
                                         this.fr = fr;
                                         this.bi = bi;
                                         this.lineHeight = bi.getLineHeight(
                                                                );
                                         this.ascent = bi.getAscent(
                                                            );
                                         this.descent = bi.getDescent(
                                                             );
                                         this.hLeading = (lineHeight -
                                                            (ascent +
                                                               descent)) /
                                                           2;
                                         this.baseline = (float) (fr.
                                                                    getCurrentY(
                                                                      ) +
                                                                    hLeading +
                                                                    ascent);
                                         this.paraStart = paraStart;
                                         this.paraEnd = false;
                                         if (lineHeight > 0) { fr.
                                                                 newLineHeight(
                                                                   lineHeight);
                                                               updateRangeInfo(
                                                                 );
                                         } }
    public void setParaEnd(boolean paraEnd) { this.paraEnd = paraEnd;
    }
    public boolean addWord(org.apache.batik.gvt.flow.WordInfo wi) {
        double nlh =
          wi.
          getLineHeight(
            );
        if (nlh <=
              lineHeight)
            return insertWord(
                     wi);
        fr.
          newLineHeight(
            nlh);
        if (!updateRangeInfo(
               )) {
            if (lineHeight >
                  0)
                fr.
                  newLineHeight(
                    lineHeight);
            return false;
        }
        if (!insertWord(
               wi)) {
            if (lineHeight >
                  0)
                setLineHeight(
                  lineHeight);
            return false;
        }
        lineHeight =
          nlh;
        if (wi.
              getAscent(
                ) >
              ascent)
            ascent =
              wi.
                getAscent(
                  );
        if (wi.
              getDescent(
                ) >
              descent)
            descent =
              wi.
                getDescent(
                  );
        hLeading =
          (nlh -
             (ascent +
                descent)) /
            2;
        baseline =
          (float)
            (fr.
               getCurrentY(
                 ) +
               hLeading +
               ascent);
        return true;
    }
    public boolean insertWord(org.apache.batik.gvt.flow.WordInfo wi) {
        mergeGlyphGroups(
          wi);
        if (!assignGlyphGroupRanges(
               newSize,
               newGGIS))
            return false;
        swapGlyphGroupInfo(
          );
        return true;
    }
    static final float MAX_COMPRESS = 0.1F;
    static final float COMRESS_SCALE = 3;
    public boolean assignGlyphGroupRanges(int ggSz, org.apache.batik.gvt.flow.GlyphGroupInfo[] ggis) {
        int i =
          0;
        int r =
          0;
        while (r <
                 numRanges) {
            double range =
              ranges[2 *
                       r +
                       1] -
              ranges[2 *
                       r];
            float adv =
              0;
            float rangeAdvance =
              0;
            while (i <
                     ggSz) {
                org.apache.batik.gvt.flow.GlyphGroupInfo ggi =
                  ggis[i];
                ggi.
                  setRange(
                    r);
                adv =
                  ggi.
                    getAdvance(
                      );
                double delta =
                  range -
                  (rangeAdvance +
                     adv);
                if (delta <
                      0)
                    break;
                i++;
                rangeAdvance +=
                  adv;
            }
            if (i ==
                  ggSz) {
                i--;
                rangeAdvance -=
                  adv;
            }
            org.apache.batik.gvt.flow.GlyphGroupInfo ggi =
              ggis[i];
            float ladv =
              ggi.
              getLastAdvance(
                );
            while (rangeAdvance +
                     ladv >
                     range) {
                i--;
                ladv =
                  0;
                if (i <
                      0)
                    break;
                ggi =
                  ggis[i];
                if (r !=
                      ggi.
                      getRange(
                        ))
                    break;
                rangeAdvance -=
                  ggi.
                    getAdvance(
                      );
                ladv =
                  ggi.
                    getLastAdvance(
                      );
            }
            i++;
            rangeAdv[r] =
              rangeAdvance +
                ladv;
            r++;
            if (i ==
                  ggSz)
                return true;
        }
        return false;
    }
    public boolean setLineHeight(double lh) { fr.newLineHeight(
                                                   lh);
                                              if (updateRangeInfo(
                                                    )) { lineHeight =
                                                           lh;
                                                         return true;
                                              }
                                              if (lineHeight >
                                                    0) fr.
                                                         newLineHeight(
                                                           lineHeight);
                                              return false;
    }
    public double getCurrentY() { return fr.getCurrentY();
    }
    public boolean gotoY(double y) { if (fr.gotoY(y)) return true;
                                     if (lineHeight > 0) updateRangeInfo(
                                                           );
                                     this.baseline = (float)
                                                       (fr.
                                                          getCurrentY(
                                                            ) +
                                                          hLeading +
                                                          ascent);
                                     return false; }
    protected boolean updateRangeInfo() { fr.resetRange();
                                          int nr = fr.getNumRangeOnLine(
                                                        );
                                          if (nr == 0) return false;
                                          numRanges = nr;
                                          if (ranges == null) {
                                              rangeAdv =
                                                (new double[numRanges]);
                                              ranges =
                                                (new double[2 *
                                                              numRanges]);
                                          }
                                          else
                                              if (numRanges >
                                                    rangeAdv.
                                                      length) {
                                                  int sz =
                                                    2 *
                                                    rangeAdv.
                                                      length;
                                                  if (sz <
                                                        numRanges)
                                                      sz =
                                                        numRanges;
                                                  rangeAdv =
                                                    (new double[sz]);
                                                  ranges =
                                                    (new double[2 *
                                                                  sz]);
                                              }
                                          for (int r = 0;
                                               r <
                                                 numRanges;
                                               r++) { double[] rangeBounds =
                                                        fr.
                                                        nextRange(
                                                          );
                                                      double r0 =
                                                        rangeBounds[0];
                                                      if (r ==
                                                            0) {
                                                          double delta =
                                                            bi.
                                                            getLeftMargin(
                                                              );
                                                          if (paraStart) {
                                                              double indent =
                                                                bi.
                                                                getIndent(
                                                                  );
                                                              if (delta <
                                                                    -indent)
                                                                  delta =
                                                                    0;
                                                              else
                                                                  delta +=
                                                                    indent;
                                                          }
                                                          r0 +=
                                                            delta;
                                                      }
                                                      double r1 =
                                                        rangeBounds[1];
                                                      if (r ==
                                                            numRanges -
                                                            1)
                                                          r1 -=
                                                            bi.
                                                              getRightMargin(
                                                                );
                                                      ranges[2 *
                                                               r] =
                                                        r0;
                                                      ranges[2 *
                                                               r +
                                                               1] =
                                                        r1;
                                          }
                                          return true; }
    protected void swapGlyphGroupInfo() { org.apache.batik.gvt.flow.GlyphGroupInfo[] tmp =
                                            ggis;
                                          ggis = newGGIS;
                                          newGGIS =
                                            tmp;
                                          size = newSize;
                                          newSize =
                                            0; }
    protected void mergeGlyphGroups(org.apache.batik.gvt.flow.WordInfo wi) {
        int numGG =
          wi.
          getNumGlyphGroups(
            );
        newSize =
          0;
        if (ggis ==
              null) {
            newSize =
              numGG;
            newGGIS =
              (new org.apache.batik.gvt.flow.GlyphGroupInfo[numGG]);
            for (int i =
                   0;
                 i <
                   numGG;
                 i++)
                newGGIS[i] =
                  wi.
                    getGlyphGroup(
                      i);
        }
        else {
            int s =
              0;
            int i =
              0;
            org.apache.batik.gvt.flow.GlyphGroupInfo nggi =
              wi.
              getGlyphGroup(
                i);
            int nStart =
              nggi.
              getStart(
                );
            org.apache.batik.gvt.flow.GlyphGroupInfo oggi =
              ggis[size -
                     1];
            int oStart =
              oggi.
              getStart(
                );
            newGGIS =
              assureSize(
                newGGIS,
                size +
                  numGG);
            if (nStart <
                  oStart) {
                oggi =
                  ggis[s];
                oStart =
                  oggi.
                    getStart(
                      );
                while (s <
                         size &&
                         i <
                         numGG) {
                    if (nStart <
                          oStart) {
                        newGGIS[newSize++] =
                          nggi;
                        i++;
                        if (i <
                              numGG) {
                            nggi =
                              wi.
                                getGlyphGroup(
                                  i);
                            nStart =
                              nggi.
                                getStart(
                                  );
                        }
                    }
                    else {
                        newGGIS[newSize++] =
                          oggi;
                        s++;
                        if (s <
                              size) {
                            oggi =
                              ggis[s];
                            oStart =
                              oggi.
                                getStart(
                                  );
                        }
                    }
                }
            }
            while (s <
                     size) {
                newGGIS[newSize++] =
                  ggis[s++];
            }
            while (i <
                     numGG) {
                newGGIS[newSize++] =
                  wi.
                    getGlyphGroup(
                      i++);
            }
        }
    }
    public void layout() { if (size == 0) return;
                           assignGlyphGroupRanges(
                             size,
                             ggis);
                           org.apache.batik.gvt.font.GVTGlyphVector gv =
                             ggis[0].
                             getGlyphVector(
                               );
                           int justType = FULL_WORD;
                           double ggAdv = 0;
                           double gAdv = 0;
                           int[] rangeGG = new int[numRanges];
                           int[] rangeG = new int[numRanges];
                           org.apache.batik.gvt.flow.GlyphGroupInfo[] rangeLastGGI =
                             new org.apache.batik.gvt.flow.GlyphGroupInfo[numRanges];
                           org.apache.batik.gvt.flow.GlyphGroupInfo ggi =
                             ggis[0];
                           int r = ggi.getRange(
                                         );
                           rangeGG[r]++;
                           rangeG[r] += ggi.
                                          getGlyphCount(
                                            );
                           for (int i = 1;
                                i <
                                  size;
                                i++) { ggi =
                                         ggis[i];
                                       r =
                                         ggi.
                                           getRange(
                                             );
                                       if (rangeLastGGI[r] ==
                                             null ||
                                             !rangeLastGGI[r].
                                             getHideLast(
                                               ))
                                           rangeGG[r]++;
                                       rangeLastGGI[r] =
                                         ggi;
                                       rangeG[r] +=
                                         ggi.
                                           getGlyphCount(
                                             );
                                       org.apache.batik.gvt.flow.GlyphGroupInfo pggi =
                                         ggis[i -
                                                1];
                                       int pr =
                                         pggi.
                                         getRange(
                                           );
                                       if (r !=
                                             pr)
                                           rangeG[pr] +=
                                             pggi.
                                               getLastGlyphCount(
                                                 ) -
                                               pggi.
                                               getGlyphCount(
                                                 );
                           }
                           rangeG[r] += ggi.
                                          getLastGlyphCount(
                                            ) -
                                          ggi.
                                          getGlyphCount(
                                            );
                           int currRange =
                             -1;
                           double locX = 0;
                           double range =
                             0;
                           double rAdv = 0;
                           r = -1;
                           ggi = null;
                           for (int i = 0;
                                i <
                                  size;
                                i++) { org.apache.batik.gvt.flow.GlyphGroupInfo pggi =
                                         ggi;
                                       int prevRange =
                                         currRange;
                                       ggi =
                                         ggis[i];
                                       currRange =
                                         ggi.
                                           getRange(
                                             );
                                       if (currRange !=
                                             prevRange) {
                                           locX =
                                             ranges[2 *
                                                      currRange];
                                           range =
                                             ranges[2 *
                                                      currRange +
                                                      1] -
                                               locX;
                                           rAdv =
                                             rangeAdv[currRange];
                                           int textAlign =
                                             bi.
                                             getTextAlignment(
                                               );
                                           if (paraEnd &&
                                                 textAlign ==
                                                 org.apache.batik.gvt.flow.BlockInfo.
                                                   ALIGN_FULL)
                                               textAlign =
                                                 org.apache.batik.gvt.flow.BlockInfo.
                                                   ALIGN_START;
                                           switch (textAlign) {
                                               default:
                                               case org.apache.batik.gvt.flow.BlockInfo.
                                                      ALIGN_FULL:
                                                   {
                                                       double delta =
                                                         range -
                                                         rAdv;
                                                       if (justType ==
                                                             FULL_WORD) {
                                                           int numSp =
                                                             rangeGG[currRange] -
                                                             1;
                                                           if (numSp >=
                                                                 1)
                                                               ggAdv =
                                                                 delta /
                                                                   numSp;
                                                       }
                                                       else {
                                                           int numSp =
                                                             rangeG[currRange] -
                                                             1;
                                                           if (numSp >=
                                                                 1)
                                                               gAdv =
                                                                 delta /
                                                                   numSp;
                                                       }
                                                   }
                                                   break;
                                               case org.apache.batik.gvt.flow.BlockInfo.
                                                      ALIGN_START:
                                                   break;
                                               case org.apache.batik.gvt.flow.BlockInfo.
                                                      ALIGN_MIDDLE:
                                                   locX +=
                                                     (range -
                                                        rAdv) /
                                                       2;
                                                   break;
                                               case org.apache.batik.gvt.flow.BlockInfo.
                                                      ALIGN_END:
                                                   locX +=
                                                     range -
                                                       rAdv;
                                                   break;
                                           }
                                       }
                                       else
                                           if (pggi !=
                                                 null &&
                                                 pggi.
                                                 getHideLast(
                                                   )) {
                                               gv.
                                                 setGlyphVisible(
                                                   pggi.
                                                     getEnd(
                                                       ),
                                                   false);
                                           }
                                       int start =
                                         ggi.
                                         getStart(
                                           );
                                       int end =
                                         ggi.
                                         getEnd(
                                           );
                                       boolean[] hide =
                                         ggi.
                                         getHide(
                                           );
                                       java.awt.geom.Point2D p2d =
                                         gv.
                                         getGlyphPosition(
                                           start);
                                       double deltaX =
                                         p2d.
                                         getX(
                                           );
                                       double advAdj =
                                         0;
                                       for (int g =
                                              start;
                                            g <=
                                              end;
                                            g++) {
                                           java.awt.geom.Point2D np2d =
                                             gv.
                                             getGlyphPosition(
                                               g +
                                                 1);
                                           if (hide[g -
                                                      start]) {
                                               gv.
                                                 setGlyphVisible(
                                                   g,
                                                   false);
                                               advAdj +=
                                                 np2d.
                                                   getX(
                                                     ) -
                                                   p2d.
                                                   getX(
                                                     );
                                           }
                                           else {
                                               gv.
                                                 setGlyphVisible(
                                                   g,
                                                   true);
                                           }
                                           p2d.
                                             setLocation(
                                               p2d.
                                                 getX(
                                                   ) -
                                                 deltaX -
                                                 advAdj +
                                                 locX,
                                               p2d.
                                                 getY(
                                                   ) +
                                                 baseline);
                                           gv.
                                             setGlyphPosition(
                                               g,
                                               p2d);
                                           p2d =
                                             np2d;
                                           advAdj -=
                                             gAdv;
                                       }
                                       if (ggi.
                                             getHideLast(
                                               ))
                                           locX +=
                                             ggi.
                                               getAdvance(
                                                 ) -
                                               advAdj;
                                       else
                                           locX +=
                                             ggi.
                                               getAdvance(
                                                 ) -
                                               advAdj +
                                               ggAdv;
                           } }
    public static org.apache.batik.gvt.flow.GlyphGroupInfo[] assureSize(org.apache.batik.gvt.flow.GlyphGroupInfo[] ggis,
                                                                        int sz) {
        if (ggis ==
              null) {
            if (sz <
                  10)
                sz =
                  10;
            return new org.apache.batik.gvt.flow.GlyphGroupInfo[sz];
        }
        if (sz <=
              ggis.
                length)
            return ggis;
        int nsz =
          ggis.
            length *
          2;
        if (nsz <
              sz)
            nsz =
              sz;
        return new org.apache.batik.gvt.flow.GlyphGroupInfo[nsz];
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "8CL+im+n/xfm/AGhcDgAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "b1fTcYfr4911GSq5kQ4zjM5ZtWVnQZeKMQk3lnO6o9VDXIrnXpFdM2F9qPkj" +
       "Ajd4Lmh0+9XxJhlHmiHoCa50qymGuprGsxSiC1405hKm11TAbL+vdZmqrCFF" +
       "vY5VwzWV+EUtNCgeY+X6AjYctM/ApTXSZ9xFbAzqzgyigeNsK17LjtoJ20e1" +
       "6sjmY87AMLUWJiWj5kMJzg5a4bQOEb0pawIPwy4WOwiEy3EXNcJZBZ+WKc4a" +
       "1bu9pIUlaIwP5xGwJEEbUVrjAcaikVjvwpWZHqWQRGklq9eYGSQi0dqI77fE" +
       "AGkMbAJNktVirhdNYZL5e2avog/t6dKXuRhpNHtti5NjSg+rbVpIJU/wMJu2" +
       "q34w6YEu1SQcJeR5ds5oLVqrS2RTWKyT2OxQWNw0ZZkd2NOxWoNsEhOdEC2X" +
       "W0JU5jiKg3FtKPYwzodLGlmHlHZJK6EIMltYE5RLw8q0NaoMcNB8igJxHYxb" +
       "LRy8g2OlSiPhJ1jNmzRcYTaSqqXOVJb4eqTg0pQpQqqOlhy51IbqBMg4JqYT" +
       "VoBppEove8S6UqSXVNVC4hnwH1ORMaYzvgFhKhgcGG4jNftV28MN2HF0WhNB" +
       "zyf7HtSjWB0DI00nFWxCDWdxFxpQ+IQjB2x5ScrwqlzR27iqcBRe5X2SqQXY" +
       "HJtCMYn3R3W3jfG0PhOpjUjYCDLWbMEuMtYmwBiQhqNq8prkgP4nBie217wb" +
       "b0as2fDKmjVYJ3VtUaERFvbSFYUXI99tgOZp1NoxGPNMP90s+iwf+lSxvyHQ" +
       "NafpSwZfDebOGJ1AlEYsHCqJ2nq4sFROW8+DxjiZw1oCjbF0gpBaWqvITLmz" +
       "HvVINJ5rxHS2Elh62glxusOipSE+kYbxdB6M+uMpsdSk6WpUFqeTfmk4WTIp" +
       "VGKIBRIusc4YjCRwjatTI54dTjCZxpTSeAENByGlgz7US2l1siIjPVHMIboY" +
       "onhrU4nRxWoIN8pCYwiLFjkfNH0SH0odG0olmNbd8aBpaHVUsWEXMkmlRVu8" +
       "lS5los5EJaNry3W0WtuYqCWsQJ9txyLf");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("G21sCqLoRVtnikNEBH6RxkhMWoGgygzrI+N02h0tKUar0QS6lOMg2gyoiSng" +
       "WjydpBW5qWmIv3Iiv2+g4qRvFifddm08L1Nrkej2wpBfCYkx5temaAxbhDdv" +
       "qWa5m0K9KaY4ELaMrJXRXLp0Z91XbFziEr1dLo5WFiKYTbZtUL1oKkSMkSKo" +
       "1tzU4cE4kiK9PEVMqYoFtp/aqbye1CKlMimtxWas0MLQthccBPHSuLKxU77o" +
       "zhCVxMJFv89K8mrl+GCSIlBMZVYptfh5IPsE0bNqs5LEGuNVOZrNVliECTQx" +
       "JuO1MqnzIyQI07LY6M95r1tDsXKZsyqkkGDtWqwuZYsIKpNWyyPhOYVDRYa3" +
       "S1657w5gY+6GRL/kzniT0rpwjW/g0IQqqavVQDQrtIAwfQ1YzVlCYAxVSnHc" +
       "7lulaDZFN8Ik6g3KguSv7aLVAmO9x63iDtLWBZiU1b5jIdLIr80iomq1dWw9" +
       "xyPIJ1EYK3Vb40lq1ZJhg+woRi806ICfpYxJiiWbqU4sx+kmttusV9VxV61T" +
       "aDERalTCETrbC4wm1KX6qK4xNkpo4nTRwRWcIZZwfdZdS3VlTSEMLVJzwppZ" +
       "ercjN2qcsGg03LY/SLpSjTCMpd6RKLrmyNXyhNkQMG9Dk/qqGdl9SiWaTdni" +
       "nRYyrw5HfGk6NHyruOb7EcvMyvUUDGBIEW7otQ0TmCpUnVput1xLVBolB8Ks" +
       "B9MsRdjcwt/UAlWeix2GJSGFXDUTHjEdLGlJaaJ1mwiuLSW41lJncjtZDzfd" +
       "sqARQsiWMGuNwqo6HK2RzZAmKYWHBgk6d/uloL0moU6jhbMrW2e6K8GlMbrC" +
       "++vAW/u6E1SKMdIEnnyFaiq9RJuxuBIpXnXGJAu4GNo8giGErKzZtVIcVquj" +
       "om/DJi/YmL9oDOMeZc5RmwVE8DZH0BJuUZba746x8bjRJwViILMkOqyZoVNp" +
       "tdxeiwCD/RQl1LjIBGsM1dqhiFI9Zr0hcLir9YsWRDW5WZFnGpmsqAGBCc1k" +
       "UTNlOx3Zy1CWFx5LScQi0K0FWRvYRWqaRNbMpKSmUlrUcW6qbIgB3KjXJ24Z" +
       "DNX1fl+cLp1lvTddrwdjtDonO9ZmSE5DLoxCvlKezBslmCM6cw0MlBjLCSsE" +
       "b7H9btN1GjIdFNdUo79MGYKW20wDHYxonezi9lrFi4bl4ehyiHqNGdyiJytb" +
       "gXudWWM5bPiZjOuJJdL8mHY2oyLdbvOLmhbAw1JnPu1bLuNbFib1mqNZbdKY" +
       "QavFAAxdTX0D18gmm/ZcC3PgYX/c5hrAraoGMVRqxbVyQPkNp8lhilrpCOtB" +
       "u7/qVbqihA7ZdbrCkYC1mEkbbvOSY3cDliOmi8APjEYj2UjFSjLVNtJMxLnO" +
       "YMUnSIjDvYkyH4pFyp4lET/3mvV0MAOeMrLozCfLVGoGrr1hFQctImW2izYl" +
       "e0UuOQrmS+2YrOMWbAu8jeBq7FCuUQQzus0kxUv+1JdKWDifVludhcF47c1o" +
       "1eDljr0SMae8dJXiiqoEsO8yMr5y5npbcIZTpt0oLvQqpZJx0BqGUGneDWva" +
       "ZoU2EbnCakFRVwM3MbmigQwXI0dadSW0am/4ddjBtMY6hrSx5znaGlJaWru5" +
       "lgZTlMXXSIxqkj9E5pOWBJcRGGiwDVcWvj5t28ioM+Mgnw+GjY1GY7oCZiH9" +
       "Et+2Bm2O7pvKVCbpgDO5VkCWlPl82RM4OCrTa5yfzos9qAnBUVJZFqHWfIVL" +
       "uCIumtZSsicbxIyKtCAsZ/112jMQyqY3RtwwgPKEnjwqkmtRCje66NFwOu3U" +
       "DLSOQKUyUoTqm5gZzYa4UHbxOgOZDuTCqebARMuQKZ0giDe+MXtD/aZre4X9" +
       "wvyV/MGhLsvOVtH24Gt4S50e2XRysJiRf24uHDsIdGQxI095724xLwwK9590" +
       "Vivfcv7Rdz35lDL4WOnMbuXvsahwa+T5r7fVlWofKWq7Y+vnDmDkxzmyjXO9" +
       "HYze8TWVQ6KXiWwvF9lWUMeWrfcOE2D5KsLw5HXtvWwHyB4TFc6FasRulyuv" +
       "uDqw8kzlcEGmd7WFgaPVHKOdbW/OtqsVhjvaw+eV9v5yzSlHnKZeoGQ7xnIB" +
       "vO0U4WQrt3s/EBVuERUly5SL9FAKb7leKdwPLncnBff5bvy9fOfGnnsKv6ym" +
       "PTPK9huGahBdgaJ1vRSzZdEndhSfeH4oHtklst2Yl3PZnMLzHVkQR4W7Qbc1" +
       "dfdw3+DhlqMjnFfXwfnF++bk0zvOn37e+7SQU/qRU+i+JwveGRVuz05HHmy+" +
       "P8byXdfB8q595X1mx/KZ54flURIfOCXuySz40ajwAl2NsndPqhvl+7+FQ3rv" +
       "u17FzXbHfHZH77Pfo0Z86hSOH8mCD0eFm3Qv8oRjjfdT18Eu22uTH0r40o7d" +
       "l66R3d6tV228T5wS93QWfCwqnI99RYzUvAvSu0O7Ryh+/DooZhv08t0Kf7mj" +
       "+JfPP8VfOSXuV7PgF6PCXWEi+pfuUs5i+EOWn75elkUA+Ow27/b7+lleNoT8" +
       "i1OofjYLPhMV7nTUQFcPuYbHiP7adRB9wa4/7u3ybr+fX3Pz5VPi/l0WfCHb" +
       "ES6uvTg6xuzfXAez/KgSiN97esfs6WtgdrCxcu/c1cbJfIvvEzmZr55C9L9k" +
       "wX8A/gAYJ+NA3d+w/OFDsr99LWTTqHB2/zh5djb23sv+mGL7ZwryJ586f/ae" +
       "p/j/uD0Wsf+HB7cyhbNabNtHD84dub/ZD1TNzJlv9fgOPyfxh1HhpSf6fsCT" +
       "zb5y7fz6Nv0fRYUXXyl9VLgBhEdT/ilQ8+MpgYHOv4+m+yaQ4GG67GBZfnM0" +
       "yf8EpYMk2e23/X2X9cgOo+1Jw3Trzd57VHnyKc9dV2uGI5OXhy45V5D/hcj+" +
       "GYB4+yciF+VPPdXpv/071Y9tj4bLtrjZZKWcZQq3bE+p54Vm5wheeWJp+2Xd" +
       "3H70u3f8wq2P7E+H7tgCPlTkI9heceVz2A3Hj/KT05tfveeX3vAPn/q9fGvi" +
       "/weHMWFr20UAAA==");
}
