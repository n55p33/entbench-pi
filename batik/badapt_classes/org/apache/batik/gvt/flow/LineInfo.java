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
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "i/vLBXR84ym6jL/i27n/B0I3qjVwOAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL18C9TjWH2fv9nX7LC7syywu2xYHruzwGIY2ZZs2V1CsGzL" +
       "li1bsmTLlkIZZL0sWy/rLcF2gdMETmkphywJ5CR7OC3QlGwgoUmatoecTUsL" +
       "NECblKYpbUJC2jwKtHBOkzQlbXol+3vMN/N9s7Oz1OfoWtZ9/X7/+7//+7+6" +
       "9/rpbxdu8dxC0bGNRDNs/6IS+xdXRvWinziKd7FPVmnR9RS5ZYieNwHPLkkP" +
       "/fz5P/veB5Z3nyncKhReJFqW7Yu+blseo3i2ESoyWTh/+LRjKKbnF+4mV2Io" +
       "QoGvGxCpe/5jZOEFR7L6hQvkPgQIQIAABCiHADUPU4FMdypWYLayHKLle5vC" +
       "3yjskYVbHSmD5xdedXkhjuiK5q4YOmcASjib/eYAqTxz7BZeecB9y/kKwh8q" +
       "Qk/+xFvv/sxNhfNC4bxusRkcCYDwQSVC4Q5TMReK6zVlWZGFwgstRZFZxdVF" +
       "Q09z3ELhHk/XLNEPXOVASNnDwFHcvM5Dyd0hZdzcQPJt94CeqiuGvP/rFtUQ" +
       "NcD13kOuW4Z49hwQPKcDYK4qSsp+lpvXuiX7hVccz3HA8cIAJABZbzMVf2kf" +
       "VHWzJYIHhXu2bWeIlgaxvqtbGkh6ix2AWvzCAycWmsnaEaW1qCmX/ML9x9PR" +
       "2yiQ6vZcEFkWv/CS48nykkArPXCslY60z7dHb3z/262edSbHLCuSkeE/CzK9" +
       "/FgmRlEVV7EkZZvxjteRPy7e+9n3nikUQOKXHEu8TfOP3/HdN7/+5c98YZvm" +
       "B66ShlqsFMm/JH1scddvvKz1aOOmDMZZx/b0rPEvY56rP72LeSx2QM+796DE" +
       "LPLifuQzzL/i3/lJ5ZtnCueIwq2SbQQm0KMXSrbp6IbidhVLcUVfkYnC7Yol" +
       "t/J4onAbuCd1S9k+pVTVU3yicLORP7rVzn8DEamgiExEt4F73VLt/XtH9Jf5" +
       "fewUCoXbwFW4A1yvKmw/+bdfmEJL21QgURIt3bIh2rUz/h6kWP4CyHYJLYDW" +
       "ryHPDlyggpDtapAI9GCp7CK00IdUw46gHCmo/mKmXs73q+A4Y3R3tLcHhP2y" +
       "413dAL2kZxuy4l6Sngywznc/denXzxyo/k4WfuEhUNfFbV0X87ougrouZnVd" +
       "3K+rsLeXV/HirM5tW4KoNejTwNrd8Sj71/tve+9DNwElcqKbgRizpNDJRrd1" +
       "aAWI3NZJQBULz3w4ehf3ROlM4czl1jPDCR6dy7LTmc07sG0Xjveaq5V7/j1/" +
       "/Gef/vHH7cP+c5k53nXrK3Nm3fKh4xJ1bUmRgaE7LP51rxR/6dJnH79wpnAz" +
       "6OvAvvkikBkwHS8/Xsdl3fOxfVOXcbkFEFZt1xSNLGrfPp3zl64dHT7Jm/qu" +
       "/P6FQMYvyPT1ReB6406B8+8s9kVOFr54qxpZox1jkZvSH2Sdn/7tr/wJnIt7" +
       "3+qePzKOsYr/2JGenhV2Pu/TLzzUgYmrKCDd73yY/rEPffs9P5wrAEjx8NUq" +
       "vJCFLdDDQRMCMf/IFzb/8eu/+7GvnjlUGh8MdcHC0KX4gGT2vHDuFJKgtlcf" +
       "4gGWwgCdKtOaC1PLtGVd1cWFoWRa+pfnHyn/0rfef/dWDwzwZF+NXn/tAg6f" +
       "vxQrvPPX3/rnL8+L2ZOykepQZofJtubvRYclN11XTDIc8bt+88GPfF78aWBI" +
       "gfHy9FTJ7dFNuQxuypm/xC88cnKfxEHAKFqGcT/1wyenxgxbWmddGMB59BQ/" +
       "yNVN0M7hbuyAHr/n6+uf+uOf244LxweaY4mV9z75t/7q4vufPHNkNH74igHx" +
       "aJ7tiJwr6J3btv4r8NkD1//NrqyNswdbi3xPazcsvPJgXHCcGNB51Wmw8irw" +
       "P/r04//sZx5/z5bGPZcPRh3ga/3cb/2fL1388O998SpW8baFbRuKaOUooRzl" +
       "6/LwYgYrb61CHvdDWfAK76g5uly8R3y8S9IHvvqdO7nv/Op38xovdxKP9r6h" +
       "6Gzlc1cWvDKje99x29sTvSVIhzwzesvdxjPfAyUKoEQJjB4e5QKjH1/WV3ep" +
       "b7nta7/2L+5922/cVDiDF84ZtijjYm72CrcDe6N4SzBexM4PvXnb3aKzILg7" +
       "p1q4gvy2m96f/3rp6eqFZz7eodG8/39TxuLd3/hfVwght/VX0bhj+QXo6Z96" +
       "oPWmb+b5D41ulvvl8ZUDIfCHD/NWPmn+6ZmHbv2XZwq3CYW7pZ2zzYlGkJky" +
       "ATiY3r4HDhzyy+Ivdxa3ntFjB4PKy46r/JFqj5v7Q1UD91nq7P7cMQt/876F" +
       "f2hn/B46buH3CvnNMM/yqjy8kAWvOaKedb9wRs1FU9oOCFn45iwYbRuwdWJj" +
       "9y6H8gPgengH5eEToEyuAeVc5q31FF1bbuc3SP58C+SvgQFAtsEIoBwDOr1O" +
       "oPeB68IO6IUTgL71GkBvFT0JuGbZL/4YnEvXCed+cD2yg/PICXCUa8C5TVZO" +
       "xKNeJ56XguvVOzyvPgGPcQ08Z5ekIspgsnQ1QOZ1AnoxuF6zA/SaEwB51wK0" +
       "ED0lU66rAfKvE9A94HrtDtBrTwCUXgPQ7WB46RqJs/Supug36du2PALy7c8B" +
       "5KM7kI+eAPJvXgPkLZHtbifETxxD8yPXieY8uIo7NMUT0LzvGmhyb+hqYP72" +
       "dYJ5JbhevwPz+hPAfPBaYDRN98Co9sjJo1ru0219oKc+8fBXnnjq4d/PB+Gz" +
       "ugdsf9PVrjKzP5LnO09//Zu/eeeDn8qnDjdn+ptVfe74K5Er33hc9iIjx3vH" +
       "Af9sSlt4AHjT/3VLf/vtF97yfE0/M/dzAkRBizmu/ent97X8eN/Rfe3Jjm7e" +
       "17quHTi5t5tlyJyVvd2ENNeSLPjJfQX46NUV4Ex2+1rQNVTdEo2D4cBQLG37" +
       "/iBXzo848UEVZ7b59jFunf7MRbjYMmxLyeYP+3Hb+bNuXzx4hQYi4yvAuoXX" +
       "nax1w7zxDx2az7/7vz0wedPybdcxcX7FMaU8XuQ/HD79xe6rpQ+eKdx04N5c" +
       "8X7t8kyPXe7UnHMVP3CtyWWuzYNb+efy2wo/Cx7JRXyKg/0Lp8T9oyz4FGgt" +
       "KRP1tmVOSf7LceGYafmx52B137AzLW84wbT8k2sN5pYSsSeYun96nXgyR+zi" +
       "Ds/FE/A88yzwdLsEm4vvGJ5few7OTmmHp3QCns8/i6GTAf1HuerI9IXrRPQS" +
       "cJV3iMonIPrKtbxBN4eTx//EQfFZxYW7wKXtite2tnZ9g7Zw4eqypkAs18UV" +
       "MBcJs7fnQ9F39ThbbwClYHmCfdP7/7O6XCD8ydb1q/sS/e3TrGsW/P2tbLPg" +
       "YwfN/O+uNKvZz09kwc9caSez3z+7rTbPnQWfPqX7f/2UuN/Pgt/Jgl/cIjkl" +
       "7R9cYUb+zXOYolR2WlM5QSn/8Foub66UTTk84H4E0B89h36L7AAhJwD69jUA" +
       "nVno2V3lGJT/fp1Q7gVXdQelegKU/3ktE5K9ZmR90c29bPQYoj99DhOU2g5R" +
       "7QRE37uWkc0QdSz5anj+8tnjySbhBQhc9R2e+hV49g5e0uZOCAHcKE1x7/nG" +
       "Rz/25+96T/1M9t7xljB7nwE8gbsP042CbKHvR5/+0IMvePL33pe/l90VvXfm" +
       "6txuyuTs2j6wNooMjKSXLx0e6dwgHp+S5KUZxbSvYsr3bnoOvBs73o2r8M7K" +
       "zC1DdnPXCaCzuNuz4NxlSM/mSJtt7mpAzz97oNmVz8fesQP6jqs20PlDwQOP" +
       "V/S/9u0v/r3/9MbvfAs0D77fPFnNt/zgl7705ezm3pMN6jEmdwyb80stakgz" +
       "HZbN0x+bfN6iZjUeo3jfdVLMJuqP7yg+fkpb5PJ+6FmDvxMAz3BfYltNspPF" +
       "P3gM6MPXBLplu7cHmFYuohez9157rztZG/Lx6BiM+1aGdGH/xTOnuB5wqC+s" +
       "DHTfkT/Sb7aLxsd6dP1ZgwS6cNdhYaRtaY+977984Et/9+GvA1XoX6YKQLG5" +
       "dz7yzXdmP+Dr4/NAxofNPQBS9PxhvrKhyAeUjmnIzcCbfu6U/Htf20M8orn/" +
       "IblFq9qU4rkVwPPQlpuQPC7V1/0Bi64bWJ83JL1FBBLWFyi5MWBoxfS0OiVp" +
       "XS7wLTkMRqbAiwt4sW50EQEf9FuysergGmI3N34wjwZEx+4E/XGTTebCOMXt" +
       "iOwWO51m3ND6ntj08NkUxTTVglBQmilYcnHB65Wi61hKJYCgAIUgFFxQEe31" +
       "4EQqG2tjNiVgvNJnMJfTw1jjjVJt4PSMWeK2PI1MDCiYujWEdOBGOWL7i+lK" +
       "GNV4oQkT6/UcxQcb08W6yXzU8frmOvFVYWyuB4OxMBLL/WRsDvouUWGXfMhZ" +
       "bW7G4BNRc5LlrNtfDLGuyXXbFFdikhU059urVkw3+wTCxKSK6lAwcbDubKKY" +
       "MOWQ9IhD6RbHD4thRZj02LW7xEynrVOiaNd5RveUWp2V+UWw2nDT+XRmw+tZ" +
       "UOrJCyLU6t7E7Cy7JbqxqJsIFHS74ZJwtFAUXIrqhTPadJ2axoz6Uz01G4Fb" +
       "2sRlAjLSqTPV2gI6WPXGptVBV6XuWqKsGSLPPKyoi5vqgmhQptKjWJjrrogW" +
       "bzKcxFJdoeMIQdXAVktD3HSHFbQa8QFeFhBciGYSqcNKuGLQan0uhStOZKrL" +
       "9titLNut9bjT0UrV7njQLFElZyQCvWe44crBZ+2IqemOPnASDUedkef1xVGf" +
       "bKptFNHwITzsjuam6m5irUd04GEipTCbREaRHwhqccOKPotZS7lKExuKSttq" +
       "txXNNVwTDLsVLkb9jSdxpDQnlHlt0LSLshrxnNZjKMMl4lDGOJ8VMMxcTwab" +
       "/mCm80VssLEEEdusxshAbA+SEYkxBjldJsqIXeoCQ8BwGVtPmXLfJTG+s161" +
       "0hJXHPoRq/kNvsIKcKrAKF1ueA0nQKe2Pm6beJ/j4lG9ybT8OkP7wBjZ06rd" +
       "0RZ4Mg86stigJ8tBCx8rYjf0Nqs0FUJKtdy27tC0PnHJxJ8IFGy3Dc5g6RVf" +
       "Q6tcqqB2sJkSvMwLwWCyQhghTWcTwTbgidVeNCM9sn3e7A0Hk6SKNkx3AZu8" +
       "ZdfYolVlB0V/Q2p+rdxy3dl0xGwWJgnEOO124PIaNaYsNI/qFpJgDWSirwUc" +
       "9aulymbgWWXWpQf+DBSIMV3Dbq65abtYHBi+KMulkc5DUWMRY62qh7W7AS4w" +
       "EttT01EizONh2hgg/U4g2oEVj7lRD9qUkFk/ZtZUmVcxtqSu4qA2WU+4disw" +
       "qyaC9eyICSqttMmSTplrDL0aMw6lmGs1Vv7SpYiSmvYTMMLQYhXamEGkp4Ir" +
       "eo6oLwwCXcvhTFInC0QrN5ccXOVxogiPuVJawpVRIxZbYZfmOQmy9fV4FfJa" +
       "rzKQeFb3hOXEHjELJRKDcJHUoiLMIR22K9Ac0RG9ioGu5z1X0pUGX6sxdXsD" +
       "O9FgA4+sksVu7InTqbCzaZUtcbI3SkfaUmFipUZUVja5kEQYYm2ozKCyUVv1" +
       "R5ra6de1fmUAz2tYexpb1Q5uLXkJRth0iKFeV3L1fqKG1iIuFylxNGUIfxSu" +
       "eGEM8wN9rDLtkTwcKjJkg3HNh81xESpWvXEDgzk4Ad2hM1Rjg2vq7WK52Fdb" +
       "ZD8xw1mybqznaY1vSfNiOYqSadLix4Lr10mVqeJ4bS56Q6jPYlFiyZOhu+FW" +
       "64TUlZVg1Zx+2PYXFBcm9aY/WzUHE161NnDFomh1RrpE1GPjUncxHcb1OUw7" +
       "YTclA6jRIyGoZM1HCWVXVhWF1paJazdibb0QiyNzM+K4SuIP2U1PMSGJgq05" +
       "XETUilSt4N0lbFBB2vGbyrCjRUudXocWGsZxpQjJSlLeDEKrTcbpYsm2rF6C" +
       "sVJkNVh8ODYb7rwdazDORs2aVrY4eWP3G4OZg3c53p7UIHW0SaVGXUZ9ckrQ" +
       "3HAZl7urdqNZQYqK6hGkUpdG5ZCDMJNYETWuLJuLFbf0FAUlZ3V4MlsPJIUJ" +
       "1fm8CsNVOlg2PLqxXLCp0QzGpo+sBjbiRCE/Y8oeZjlaZaymLNZ1YKEnUSV5" +
       "o9douzF1fJ1Apoic2PFiqLSmZDONl0V0TWK14rwNSxQw0YjXowcdYllrxcWh" +
       "Wukhy1SpJ6OZ1TZLg6pOSX0bwptAKUpyaTYUY0jr1DuWDcWR0uu0qU5YsRzP" +
       "QWcJQk6HRAQRQYlspV2ii2jqAl7WILRR7mHNUdEt1txJs64WFQ+KuwhEWExr" +
       "2UbkvtztGSWxQyOEPCH5ZWBwy3DeGoRhvSapmNpLY4QdYJsBGNFDpmXRIQkK" +
       "RfgAUqy0qsaD3qgrcxUDGMkOXsQ7g4WOY9J8RVRXYlG1TKdYtTdFu603GLpm" +
       "DUTJpKjGRqm7U7IkBFyXHtPm0pjWo7qntDVktZ5Po/YqRoeIEnvjVldqtzpG" +
       "Mo1ms3K1PadjqbduAbejHld8y7QXNN2jZl45kpB56JcIbN3qmTDvEt3qAubR" +
       "dAmzDZ4vk6Fd7Vfdmc9OeqUuSTRaenuAqhUzaMV1ZD5jK6jsVSQLTlEKCQK1" +
       "NgOOjU+EokNuJrU+FTUTPIlCX1o0K4oySlLEbw8b6x479i2cYyMr7mNrtFiv" +
       "bxaGXPOihbak6GaoQw2nFo16cJGYlTDMJym6pKft4oAmEbUP25RT6YVQ0eml" +
       "aeTMPXM52eCTJqLCAkE3apuVD8GeWnI6qVX2TNXS7bjY76GNUJSKhgNG+lox" +
       "GQerkdpdjbCIarPzcBk1fJVp+G7IeKbUkQngOgUJP7VG9tgTtMWMqLLpjKfK" +
       "Mw6v1YELgsk9FTMFyLXQlrIIy0F55fU2hsmErjSjYrjkUpVKqWLBwBwSCBg0" +
       "JIFMlYVNraOgXjQwe7ParAdTURfZGqQjMzi2xs11jbGFNjaGUtAKw3WitF1v" +
       "srJb9QGPz9fJemovsXIzMjEkTRYbZw0aulZcN/wEkVUDthSl3mo7MBMhMhNu" +
       "IMxSG2iP3wgtfKm2SxWzjTZjrTSOjSGviVInmLXbQ0pFYJTHbS4yolZa2aCg" +
       "/2HDgZzZPkZLGkRp2pKwxO0oY6QuFhOlrE20sDWdCnGzTMDcqsVuDJ421Hag" +
       "+/iYxA2I9l0PoZs928a72njEUMtWzYEpsdUbRBMR8xpiUAvKzSkWtqOpyAxh" +
       "Yt7UWHljTGJHK8MM602D1HcDy4Rj2YqA5QVjtquRlXBJEnNmWCZSkQl0r7IO" +
       "4MiGatWWMYQjF7iOM6bYrG+C5YCgbHO8midIrz6zpxpXH6SRUjXHUZvASiMM" +
       "MzrtpBN3Pd6GnWaIUeUirrfbsWkLVljhGtCkruIpDkbkGbaIQi8aq5tqW0lS" +
       "aGA05wtuPm7hVNpYD8SVQEZjsy7BxGhe9OaMI9WNCIukiha3Jc/iKtpsVlKb" +
       "dZiLhC7HVPs9qNZbVYWAlsOo105DFwfq3i6vEGNkEo1RS6JUtFLjlIWxggZ+" +
       "VNmUxvpy2A/rFKobXZTBi7Vqvde3Y4UFmZvzObap44EK84JiV7WkTqgToVUb" +
       "GHaKL7B+3etROF5fSd31hA1Ep0eMK/UWDkRN6jiMEVWtzi+WscRNxhSzwoOl" +
       "vgo4nd6Y/lRaE90BRqG8bSuDSjIcV7rA/4v7xlLGk+ZIIrs1MCaIdarRqHor" +
       "KrWrpD8cAoMtVbo4hBTbdaEyX2Cb4gCvo6igki6sl9yeO2isBMorWkDxzF5s" +
       "I1CYBCN1IE8XKEwGpLZeAX3ckAES6DC8AZ2v4uIiilBD1ak38NT1qggtDfUa" +
       "iszGniNFyrhaYiQRwy2bmYawyjoya7ZxT8EFmZ+gvs1YiN/0vSnsYFqrVxyL" +
       "2rK9GXT5TmW1Lg2xdkCXWxauT7FaqiA2jtApPO3HoJ+RlmvAjTG0SpdNyDLT" +
       "IaGuVJGelYYRbVCDIaKJy04LHVOLsRR2W5Ni2KGMltJeCOqsNBjTLjkdMFi5" +
       "C9yBMfDe0pglhmOjuwKCmZUmdbPRXYZFdaGlNFnj+rjXGNNMGCZ8aeMFQ02o" +
       "GQahGFBMjYcW0l5FCxQMFTQ5R9RqB5iGjo101jWJnARse6orLRot4slCJsMx" +
       "WaSDuV7UWpNqiR6mSqOdrNButTMazpcCoQV+l3WVzmA1WjgVJcJJdFzeEGSS" +
       "+KHTEqYKT9nA7nWMuYyKWh+CajYvDpgKFi40wg1cPRo0Rzbfaot9s9/ebJCR" +
       "N+vVWbOldwLNVFJYsswmsUrHSac75el+5A8pvS0PQ5NUa2uqxjd5EuFDP9QR" +
       "akzaJby7Ho8mGsaMNq4jucs5veiDKckC");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "QWjr8uHCzPBaCwRHqzlGO9vmnG1bK4x3tMfPK+39ZZtTjjrNbFfOdo7lAnjb" +
       "KcLJVnD3ftgv3CbKcpYpF+mhFN5yo1J4EFzWTgrW8934e/kOjj3rFH5ZTXu6" +
       "n+079BTXvwrF1Y1SzJZHn9hRfOL5oXhkt8h2g17OJT2F5zuyIPAL94Juq2vW" +
       "4f7Bw61HRziHN8D5xfvm5DM7zp953vs0n1P60VPovjcL3uUX7sxOSR5swj/G" +
       "8t03wPKefeV9ZsfymeeH5VESHzwl7sks+Dt+4QWa4rcC11UsP98Hzh/Se/+N" +
       "Km62S+ZzO3qf+z414lOncPxoFnzEL9yi2b7NH2u8n7wBdtmem/xwwpd37L58" +
       "nez2br9m433ylLins+DjfuF84Miir+RdkNgd3j1C8RM3QDHbqJfvWviLHcW/" +
       "eP4p/vIpcb+SBb/gF+7xItG5fLdyFjM9ZPmZG2VZAoDPbvNuv2+c5RVDyD8/" +
       "hernsuCzfuFuU3E15ZCrd4zor94A0Rfs+uPeLu/2+/k1N185Je7fZsEXs53h" +
       "YmIH/jFm//oGmOVHlkD83tM7Zk9fB7ODDZZ75641TuZbfZ/IyXztFKL/OQv+" +
       "PfAHwDgZuMr+xuWPHJL9reshG/uFs/vHyrMzsvdf8QcV2z9VkD711Pmz9z01" +
       "/Q/b4xH7f3xwO1k4qwaGcfQA3ZH7Wx1XUfWc+VaP73JyEn/gF156ou8HPNns" +
       "K9fOb2zT/6FfePHV0vuFm0B4NOWfADU/nhIY6Pz7aLpvAQkepssOmOU3R5P8" +
       "D1A6SJLdfsfZd1mP7DTanjiMt97s/UeVJ5/y3HOtZjgyeXn4svMF+V+J7J8F" +
       "CLZ/JnJJ+vRT/dHbv1v7+PaIuGSIaZqVcpYs3LY9rZ4Xmp0neNWJpe2XdWvv" +
       "0e/d9fO3P7I/HbprC/hQkY9ge8XVz2N3TMfPT1Cnv3LfL77xHzz1u/kWxf8H" +
       "hJgBFONFAAA=");
}
