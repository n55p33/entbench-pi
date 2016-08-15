package org.apache.batik.gvt.font;
public class MultiGlyphVector implements org.apache.batik.gvt.font.GVTGlyphVector {
    org.apache.batik.gvt.font.GVTGlyphVector[] gvs;
    int[] nGlyphs;
    int[] off;
    int nGlyph;
    public MultiGlyphVector(java.util.List gvs) { super();
                                                  int nSlots = gvs.size();
                                                  this.gvs = (new org.apache.batik.gvt.font.GVTGlyphVector[nSlots]);
                                                  this.nGlyphs = (new int[nSlots]);
                                                  this.off = (new int[nSlots]);
                                                  java.util.Iterator iter =
                                                    gvs.
                                                    iterator(
                                                      );
                                                  int i = 0;
                                                  while (iter.hasNext()) {
                                                      off[i] =
                                                        nGlyph;
                                                      org.apache.batik.gvt.font.GVTGlyphVector gv =
                                                        (org.apache.batik.gvt.font.GVTGlyphVector)
                                                          iter.
                                                          next(
                                                            );
                                                      this.
                                                        gvs[i] =
                                                        gv;
                                                      nGlyphs[i] =
                                                        gv.
                                                          getNumGlyphs(
                                                            );
                                                      nGlyph +=
                                                        nGlyphs[i];
                                                      i++;
                                                  }
                                                  nGlyphs[i -
                                                            1]++;
    }
    public int getNumGlyphs() { return nGlyph; }
    int getGVIdx(int glyphIdx) { if (glyphIdx > nGlyph) return -1;
                                 if (glyphIdx == nGlyph) return gvs.
                                                                  length -
                                                           1;
                                 for (int i = 0; i < nGlyphs.
                                                       length;
                                      i++) if (glyphIdx -
                                                 off[i] <
                                                 nGlyphs[i])
                                               return i;
                                 return -1; }
    public org.apache.batik.gvt.font.GVTFont getFont() { throw new java.lang.IllegalArgumentException(
                                                           "Can\'t be correctly Implemented");
    }
    public java.awt.font.FontRenderContext getFontRenderContext() {
        return gvs[0].
          getFontRenderContext(
            );
    }
    public int getGlyphCode(int glyphIndex) {
        int idx =
          getGVIdx(
            glyphIndex);
        return gvs[idx].
          getGlyphCode(
            glyphIndex -
              off[idx]);
    }
    public java.awt.font.GlyphJustificationInfo getGlyphJustificationInfo(int glyphIndex) {
        int idx =
          getGVIdx(
            glyphIndex);
        return gvs[idx].
          getGlyphJustificationInfo(
            glyphIndex -
              off[idx]);
    }
    public java.awt.Shape getGlyphLogicalBounds(int glyphIndex) {
        int idx =
          getGVIdx(
            glyphIndex);
        return gvs[idx].
          getGlyphLogicalBounds(
            glyphIndex -
              off[idx]);
    }
    public org.apache.batik.gvt.font.GVTGlyphMetrics getGlyphMetrics(int glyphIndex) {
        int idx =
          getGVIdx(
            glyphIndex);
        return gvs[idx].
          getGlyphMetrics(
            glyphIndex -
              off[idx]);
    }
    public java.awt.Shape getGlyphOutline(int glyphIndex) {
        int idx =
          getGVIdx(
            glyphIndex);
        return gvs[idx].
          getGlyphOutline(
            glyphIndex -
              off[idx]);
    }
    public java.awt.geom.Rectangle2D getGlyphCellBounds(int glyphIndex) {
        return getGlyphLogicalBounds(
                 glyphIndex).
          getBounds2D(
            );
    }
    public java.awt.geom.Point2D getGlyphPosition(int glyphIndex) {
        int idx =
          getGVIdx(
            glyphIndex);
        return gvs[idx].
          getGlyphPosition(
            glyphIndex -
              off[idx]);
    }
    public java.awt.geom.AffineTransform getGlyphTransform(int glyphIndex) {
        int idx =
          getGVIdx(
            glyphIndex);
        return gvs[idx].
          getGlyphTransform(
            glyphIndex -
              off[idx]);
    }
    public java.awt.Shape getGlyphVisualBounds(int glyphIndex) {
        int idx =
          getGVIdx(
            glyphIndex);
        return gvs[idx].
          getGlyphVisualBounds(
            glyphIndex -
              off[idx]);
    }
    public void setGlyphPosition(int glyphIndex,
                                 java.awt.geom.Point2D newPos) {
        int idx =
          getGVIdx(
            glyphIndex);
        gvs[idx].
          setGlyphPosition(
            glyphIndex -
              off[idx],
            newPos);
    }
    public void setGlyphTransform(int glyphIndex,
                                  java.awt.geom.AffineTransform newTX) {
        int idx =
          getGVIdx(
            glyphIndex);
        gvs[idx].
          setGlyphTransform(
            glyphIndex -
              off[idx],
            newTX);
    }
    public void setGlyphVisible(int glyphIndex,
                                boolean visible) {
        int idx =
          getGVIdx(
            glyphIndex);
        gvs[idx].
          setGlyphVisible(
            glyphIndex -
              off[idx],
            visible);
    }
    public boolean isGlyphVisible(int glyphIndex) {
        int idx =
          getGVIdx(
            glyphIndex);
        return gvs[idx].
          isGlyphVisible(
            glyphIndex -
              off[idx]);
    }
    public int[] getGlyphCodes(int beginGlyphIndex,
                               int numEntries,
                               int[] codeReturn) {
        int[] ret =
          codeReturn;
        if (ret ==
              null)
            ret =
              (new int[numEntries]);
        int[] tmp =
          null;
        int gvIdx =
          getGVIdx(
            beginGlyphIndex);
        int gi =
          beginGlyphIndex -
          off[gvIdx];
        int i =
          0;
        org.apache.batik.gvt.font.GVTGlyphVector gv;
        while (numEntries !=
                 0) {
            int len =
              numEntries;
            if (gi +
                  len >
                  nGlyphs[gvIdx])
                len =
                  nGlyphs[gvIdx] -
                    gi;
            gv =
              gvs[gvIdx];
            if (i ==
                  0) {
                gv.
                  getGlyphCodes(
                    gi,
                    len,
                    ret);
            }
            else {
                if (tmp ==
                      null ||
                      tmp.
                        length <
                      len)
                    tmp =
                      (new int[len]);
                gv.
                  getGlyphCodes(
                    gi,
                    len,
                    tmp);
                java.lang.System.
                  arraycopy(
                    tmp,
                    0,
                    ret,
                    i,
                    len);
            }
            gi =
              0;
            gvIdx++;
            numEntries -=
              len;
            i +=
              len;
        }
        return ret;
    }
    public float[] getGlyphPositions(int beginGlyphIndex,
                                     int numEntries,
                                     float[] positionReturn) {
        float[] ret =
          positionReturn;
        if (ret ==
              null)
            ret =
              (new float[numEntries *
                           2]);
        float[] tmp =
          null;
        int gvIdx =
          getGVIdx(
            beginGlyphIndex);
        int gi =
          beginGlyphIndex -
          off[gvIdx];
        int i =
          0;
        org.apache.batik.gvt.font.GVTGlyphVector gv;
        while (numEntries !=
                 0) {
            int len =
              numEntries;
            if (gi +
                  len >
                  nGlyphs[gvIdx])
                len =
                  nGlyphs[gvIdx] -
                    gi;
            gv =
              gvs[gvIdx];
            if (i ==
                  0) {
                gv.
                  getGlyphPositions(
                    gi,
                    len,
                    ret);
            }
            else {
                if (tmp ==
                      null ||
                      tmp.
                        length <
                      len *
                      2)
                    tmp =
                      (new float[len *
                                   2]);
                gv.
                  getGlyphPositions(
                    gi,
                    len,
                    tmp);
                java.lang.System.
                  arraycopy(
                    tmp,
                    0,
                    ret,
                    i,
                    len *
                      2);
            }
            gi =
              0;
            gvIdx++;
            numEntries -=
              len;
            i +=
              len *
                2;
        }
        return ret;
    }
    public java.awt.geom.Rectangle2D getLogicalBounds() {
        java.awt.geom.Rectangle2D ret =
          null;
        for (int idx =
               0;
             idx <
               gvs.
                 length;
             idx++) {
            java.awt.geom.Rectangle2D b =
              gvs[idx].
              getLogicalBounds(
                );
            if (ret ==
                  null)
                ret =
                  b;
            else
                ret.
                  add(
                    b);
        }
        return ret;
    }
    public java.awt.Shape getOutline() { java.awt.geom.GeneralPath ret =
                                           null;
                                         for (int idx =
                                                0;
                                              idx <
                                                gvs.
                                                  length;
                                              idx++) {
                                             java.awt.Shape s =
                                               gvs[idx].
                                               getOutline(
                                                 );
                                             if (ret ==
                                                   null)
                                                 ret =
                                                   new java.awt.geom.GeneralPath(
                                                     s);
                                             else
                                                 ret.
                                                   append(
                                                     s,
                                                     false);
                                         }
                                         return ret;
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
    public java.awt.geom.Rectangle2D getBounds2D(java.text.AttributedCharacterIterator aci) {
        java.awt.geom.Rectangle2D ret =
          null;
        int begin =
          aci.
          getBeginIndex(
            );
        for (int idx =
               0;
             idx <
               gvs.
                 length;
             idx++) {
            org.apache.batik.gvt.font.GVTGlyphVector gv =
              gvs[idx];
            int end =
              gv.
              getCharacterCount(
                0,
                gv.
                  getNumGlyphs(
                    )) +
              1;
            java.awt.geom.Rectangle2D b =
              gvs[idx].
              getBounds2D(
                new org.apache.batik.gvt.text.AttributedCharacterSpanIterator(
                  aci,
                  begin,
                  end));
            if (ret ==
                  null)
                ret =
                  b;
            else
                ret.
                  add(
                    b);
            begin =
              end;
        }
        return ret;
    }
    public java.awt.geom.Rectangle2D getGeometricBounds() {
        java.awt.geom.Rectangle2D ret =
          null;
        for (int idx =
               0;
             idx <
               gvs.
                 length;
             idx++) {
            java.awt.geom.Rectangle2D b =
              gvs[idx].
              getGeometricBounds(
                );
            if (ret ==
                  null)
                ret =
                  b;
            else
                ret.
                  add(
                    b);
        }
        return ret;
    }
    public void performDefaultLayout() { for (int idx =
                                                0;
                                              idx <
                                                gvs.
                                                  length;
                                              idx++) {
                                             gvs[idx].
                                               performDefaultLayout(
                                                 );
                                         }
    }
    public int getCharacterCount(int startGlyphIndex,
                                 int endGlyphIndex) {
        int idx1 =
          getGVIdx(
            startGlyphIndex);
        int idx2 =
          getGVIdx(
            endGlyphIndex);
        int ret =
          0;
        for (int idx =
               idx1;
             idx <=
               idx2;
             idx++) {
            int gi1 =
              startGlyphIndex -
              off[idx];
            int gi2 =
              endGlyphIndex -
              off[idx];
            if (gi2 >=
                  nGlyphs[idx]) {
                gi2 =
                  nGlyphs[idx] -
                    1;
            }
            ret +=
              gvs[idx].
                getCharacterCount(
                  gi1,
                  gi2);
            startGlyphIndex +=
              gi2 -
                gi1 +
                1;
        }
        return ret;
    }
    public void draw(java.awt.Graphics2D g2d,
                     java.text.AttributedCharacterIterator aci) {
        int begin =
          aci.
          getBeginIndex(
            );
        for (int idx =
               0;
             idx <
               gvs.
                 length;
             idx++) {
            org.apache.batik.gvt.font.GVTGlyphVector gv =
              gvs[idx];
            int end =
              gv.
              getCharacterCount(
                0,
                gv.
                  getNumGlyphs(
                    )) +
              1;
            gv.
              draw(
                g2d,
                new org.apache.batik.gvt.text.AttributedCharacterSpanIterator(
                  aci,
                  begin,
                  end));
            begin =
              end;
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "ywGwKQ/gzlHJfq3GoWqvAlSoejyjOWzze7hyqIJIy0F1UQhUG7BYy0izAxXk" +
       "uKYi50FaXT5k8lJw/NZVS9SWwnXUBuFo5fgFkZbD75Mh+HVjcYUHv+1Zhqcp" +
       "8PEKF5KuKkAyF+twJ/a4zdfxyiEJIi0HSSIEkm1Y9DHSljfpVPWp3vy86mHy" +
       "G9sBQbekpVW6YZML2ZZqhVnL4Tpl832qcsiCSMtBtjsEsr1YDDLS4kDmnPJx" +
       "AJtdCNiArmjMC9anq2Wy1sF1l83xXZWDFURaDqz9IWDh4a0IZaTVAWuXKWkW" +
       "nphw0GovRKs7lQKNLGzFUUtVy1CtIL632ZWhFkRaDrWJENRuxIKJGFVkuoqV" +
       "dVyiz1plq4ALP6CC/T1kM/dQ5bgEkfrY9mw54T5DZJgD8PkQcI5icRPon1VK" +
       "//jmu22OcozUjulK0gXrSLXA2gLXYzbHj1UOVhBpGbA0DsjtIWDhFlPki6B/" +
       "ll//sOJWF5nj1RSjJ232nqwcmSDSEGT4wzs9cuCTiakjuq5SSSulm338yEHk" +
       "qyGQ4q5lZBKiCMtVTmWEn8H0Avp31XKJy+A6b6NyvnJAg0jL2atHQiD5BhYP" +
       "QpSuWH5ETruIPFQtC74Yrudttp6vHJEgUh/DNXwiNY7yieIk5/87Idj8MxaP" +
       "M9LoTZp5y5MuNE9US1g64frA5u+DyqEJIi0HDa9xX/rgZhlZQooOH3/6T3Gq" +
       "q0dXdbMb7ngi7bzwqVbX7sueyLO5cpZmSkrVJVbazvif8t/XiX7F3n3kJbE2" +
       "vPyDX+hEXvjjXujAsJwaf4e80Im8FlL3BhavYs0XxExC2v48SIyDXuhwqh+G" +
       "9PhLLP7VE2t6A4PIv7nadr5aCR6IdWSJ6FP8r0jbAklDeH4vpO43WLwrEpWC" +
       "TRV8PuDCcaFadhmSkkjM5ilWORxBpMEsR6MhdbXI628ZaQA4Sif+v6smEBtt" +
       "bjZWDkQQaWAMFHmRF5zt5hBI8HxjtCEEkuj0aqlKB/DTZ/PVVzkkQaSloxj+" +
       "G3LNFTzXxA38WP6zu2TPqGRKMqNmP6P8fDuHZlEIbEuxmMvIdIBNaNSGTYU6" +
       "FZ1XxT2kyB6b+T2V4xZEGsLt2pC69VistLePIH3nu4uljEx0VbXyi5XATdrm" +
       "Kl05IEGkIUxfFlJ3BRYfg8zdoCZmWZtoSsqqTJwrvKEgQ4heUq1XR0uBH3ur" +
       "PlL5Ln8gaaC5sYM+DsDmEHD6sLhKOOi81vWAtPCwyX2JFO2ulrCAK4ncarN3" +
       "S+XI3BJAWhoZx+rMzO9w9ZmSMarIwlxE2zkoO0IAG8RiKyO1SVMa90nPtj8F" +
       "RhCjtvi/ccOD5POKvqIVX37KD0w218+d/NSPxblV5+vMGQlSn8qqqveos+e+" +
       "zjBpSuH4zhAHnw3O3j5G5ge+sgCuU/b76ehe0V4CvSrVnp9oLmiZBL78LSEc" +
       "5/+97dLg+9x2jNSJG2+T/Xhex0zjrX12D5a0xT3CKc6G54SPWejFm78fnl1u" +
       "mfIk3o+v0EPx752dc2TZAfv7krOT12y78cKff018/CWr0sGD2Mv0BJkqvkPj" +
       "ndYUfavi7c3pq27L6g+bHpy2wjkX0yom7OrBQlcW8aRCxEDZWOD7MsrqzH8g" +
       "9ZPTG5/4/tG656IksptEYLlm7i4+RZ8zsiZp350o/vJkUDL5J1tdq/924sp1" +
       "qV+9xL9TIOLA66Lg9sPyC/fsff74vNOLo2R6P5miaEma48f7N01oO6g8Zg6R" +
       "RsXanIMpQi+KpBZ81tKEYizhl9AcFxvOxvxT/HSQkY7ik8bFH1w2qPo4NbkD" +
       "xG4aE2S6+0SsjO8gatYwfATuE3spsezFYksOVwPkcTix1TCcz2gaugyuzX2l" +
       "0yYU3M/yW7w7/H8QYiYxC0EAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "MOJUfQF65iN3Ea//bl7/yJFlte9JLp5kQOx5VBf5pPXD/Qeu+1f7heuFwu3S" +
       "LrBlRTPM3IMAgjn/INoFwe+J/JOB2TYKeezQUb/itBM91u1pF3o0uYHzrHR2" +
       "ftMpr5mzfBc4Htnp7SOn9XavkJ+08ir35+lDWfIzuxHaNvWX4G8PHP8vO7Lr" +
       "2YVtZHEHsQtv7juMb1ww216jRb5/puHlLmJreE//owe/8ranH/wvuf7doPsA" +
       "dt3TLhFAHqvz/We++d2v3XL3p/KZKPcKOQGnI++LA+sT8XLO182HfGW6Wngx" +
       "OJ7Y8fXEFqR8zugGgFdsH6gn5EcaCPqdmEyCPOCgxA0Iyg+iqL+Rfg591asu" +
       "HxG12emxeOjQbg/cdva7niXMgQKxl1ag/ez0VQFQXd0WzZztHpj4TMXWguXZ" +
       "Bs94ugXm4mgX90NP3PFN4yPf+fVtTH/auk8VVp586t1/eeE9T+0fW0k9eNFi" +
       "5nid7WoqF/CWXMrkxNx0iV7yGq1vf/qJz/3aE+/aSnXHyXUBCZa9v/6H//f3" +
       "L3zoW793iYD0GqCa2Y+hmxwSvL9l7WCEtjNq5ivA2smxlWxyPsjbBqe6c+Fw" +
       "3Qoyk4uGyis8enmO6dwUjjzb777zv981ff3yLT9FVHrvKY5ON/kJ+pnfa79S" +
       "et9+4ZpDP3fRovZkpcdOerebPAWswu3pCR9391b7cv62qpclD+dDd8ZM65yR" +
       "t84SIN21Ukb1dmTOKB4khW3ImaW1LGlv2X/tZae++knH/EJwPLpzNI9exjHH" +
       "l3PMO1O63s7t1M8L0Ift35yVuQ30M9g2v/0fFKRzOhjRdf3MtyxArO4rHjRw" +
       "ZIXRJUPxGNFWzAM/9jfRTc7Amy/vmp44oPAdZ7mmLOG3ZGaJkDeaJW+92Cqz" +
       "n3KWqBebWfZb33ab184S6wztefKMvHdnyc9nibeV5Iyyf/8iLUx+Si0EWlIo" +
       "7rSweBkt/KXn0MJrHFU9hH1Mlvf+NWR5zU6W11xGlg88hyzXbS3icCCPifPB" +
       "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" +
       "iVO/JoXEVBeNVbhGJ5NJaFrlMr4hO8Z6");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("0x5V1qgpNPo6QQfs1OJIG+/A9cgtl+b93qZYry6qg01k9+oavKIQMeiM9Cba" +
       "WPLMyJ2EXAclp17YZVqjgMAqvBfKQeBWo06P1GZLqDmYx/qAxza60jVQCMe6" +
       "8gqnE5Gha5QzFVx0g9LhgKzNJiWtWlG9OhoWm5v1Vj+aYi3JLE1YmsLIcYad" +
       "MlSdltvrNSzP5QW9wGxNxxZpvGYXc8wPlQ01RCVXsCaGx/bYhZhGuooH0Fyf" +
       "Y60yCHh6CxJ4rE1zXlyS82i1moerut+LRbWi4HDXwlsmVW4sxYj34XlCJgQS" +
       "VfBJF5QPl/F6WWzXmCVFMRhLIkG1XmG6EWaLsoeKxLjalblJr9picA9eLeqG" +
       "2VQ6lcgdVsocFXukyxHTMYszYZOQxJYoL4GIxopGdZMbjpOGS5P+uEov5cW8" +
       "W0VwQRzVKxNdLUZV3yIbQbBYAaU1RiORq9OtjjVuoWmALhtdvJOsAoIkjXAF" +
       "i2uz34CaUwFiWDY1jJE4MZ1kVWyXqUFrms6TehnnmGoaIlNm3R736fXAYqoM" +
       "rjbDjmCS3QUZJhYddeVuYyAOJu0pP6u2hNI8mSLGplFdFKcIW0kEsu1TAeIS" +
       "1Rqr+wGlMN1O2Q4robkiExgMw0ZH5/Wp7Fl9E0a7wDd1Z4naMnvlxphXNTyV" +
       "HUKwOCFwJv56Pe3FXtQntVFlqczWpfkYDhudcugxJoVSNq6JIoH6PF1s+k2L" +
       "7DSrPrXsD4c6Xoq4esAQ8WaO9FpDJDQ9ot6v2JLoDcqT4rxbbvTq3NIRkqJH" +
       "p8NaXAMqQYteNzYTEkkNZwh36218rPc3w9KEpcUabIO1Pt4aL4lVEOmQJA2b" +
       "KDPsR+suOy9j/SYcIyW8KEODCZMsTBYtRnR7ZE5sfL1eg4jeLyrFdNUA1tCp" +
       "pMt6x47Lw/IKBStrpehrRDiDFlhVWSowWyGiicfabs2hLF1oUBhOTUgJhcDK" +
       "T6a0Yi1BVoNJr40Up9B8qSRwuvLmJaSJinAyLRN9qdpGKxOGU1YtC8NV2yyF" +
       "lto1yk4xgkkmwVBElpCpUAdrPMMbTkvIBsNBzKHCJRwiOA/2202EjuBGz1hH" +
       "BrOyZX6mipGOSWV3jWBUVSuCIGiDxCtjDm8cCxt6jZEpcbg4JhKyKXDDJkb7" +
       "3jrt4FpNYKZtFKpAQbuKVruG7wYkT5kWpleKYwFPfV1wyyjsQFHPmDUptFcK" +
       "5DVUQyq+W1qzAClVm3aHVL1apbSaz2wISPVVFatEgyHlIOMqg1q6SII4E1ex" +
       "AVxyhlUNF7TqeOzPRbtLuyO92HcbAgjg+ySvp0uzVpdaSTRMomQKdSYjg8d0" +
       "A1+0OqUYWTNOZbAwmkm7IpLIpFqEJ/5qCPQr4GO1Pg3Jsu/6StriDX/Ixowh" +
       "TfWkNCWkFNHEUNuE6Rwx4Q0/K9NgKYHFGNTBR7zOJwRM1uv1170uu7X+T366" +
       "W/4vyJ9uHO5DXplYlvHLP8Vd/eTYI9vDJ0D533WFU3tXjz0BOrZZaC87nWTP" +
       "6O++3B7j/Pn8x9/51NPy8FdKB1u63hIUbgwc9zWmEinmsfZevn2AdyhL9iAq" +
       "327Y2snSOv006gjtRbzlwr1qy9YZj+6+eEbel7Lkt4PCzZoSDEJr+4w3f6R1" +
       "RPDvPNdjk+ONnsKXb3TJyvZ3+Po/Bb7CJaHtHWF/c17ga2fg+3qW/JugcAPA" +
       "12a7cnIK21fOgS17rJ5vemJ32NgrP3bfOCPvW1nyR0HheoCt5ezeeLgzKNx/" +
       "5nabw5I5/j8+B/67s4slcLxph/9NVx7/n52R9z+y5NtB4UU7/GPFlhVv9+rF" +
       "ARn35s8jxXhHwKXL5VR85xxUHJqxvKNCvjJUXKTrf34GH3+RJT/c2nJuyIQj" +
       "K6f0/UfnAPlAdvExcFg7kNbVAbl33eVB7t2QJXtB4WUHIHuhH+iqLuX7h7q2" +
       "6hyM/EMnR/6Mwhkze/vnYCafVV4JjmjHTHSVmHnRGcy8OEtuCwp3HjBDORpA" +
       "ajac0Jb9A1ZuPWRlshR3e+Bz/LefA3+m+fnOorft8L/tKuF/4Az8WZN7dweF" +
       "2w7w00rg6dIh8keeexfi8Ro5KfecVynuA8eTO1KevEqkwGeQgmRJ8RgpwzDI" +
       "3vjJLr/0COerz4HzJdnFbL/v+3Y433eVcL72DJyvzxIsKNxx6PsU85Tmv+xQ" +
       "8zXFsS6MFSkQbc1UkOYRD/h5w4EHwfHhHQ8fvko8nDFf7lFZQgaF2w94OHhn" +
       "7ICFO0+ywDi6HRxnoHVeN/BqcHxsx8DHrhID8zMYyHbW7U3A4uGAgakn2n72" +
       "HtABBXefpKCuqsAgTpbKqZie1/gfBscndlR84ipRoZ5BRbY3bU/cBkjbXda6" +
       "Hx5MCKc8wOIcYPN3prJ6v7ED+xtXBuyx7ZDZDru9QY7KOwNxts95zwLq719K" +
       "/U9vEYscXT5iwD4vAx1wfG7HwOeuDgNvzFG+4wwG/m6WvBWov39a/bOM6Aju" +
       "E1diwL+wg/uFKw/3UiN2/cJxTEW0c6T/4AwW3pclT4Jpzz/SfH2Rv9h6nINf" +
       "OK+7vx8cX95x8OWrZOEfOQPn01nyQRDV6f5pmO85gvmh8zqye8DxBzuYf3Bl" +
       "YF5zdOfnzYfJW3NQv3YG4E9myS8HhVuOr3Hykm89wvvx8w7rQ+D48Q7vj68S" +
       "3jznaCN9dh+hcG/hohequfPucLd1K3uB0vHq4Cxf9xxsnr9aTSeXMt1rVdMR" +
       "g9Nanv/Odt3u/dPdtuu9z1+a2rN30e999q+3ix50m9fOfp+xi37vX56R98Us" +
       "+Z0sx9tKckbZLyXb/795Rpl/nSWfPhbAHJ/D9j57pOafOW/QDlRs795t3e3/" +
       "86v5cSBfPyPvD7Pk327j1BPr1Oz6G44w/rvzui4Qk+5d2GG8cOUxfuuMvD/J" +
       "kv8YFG4CGC+97PpPVwLda3foXntl0B1Zz95v5UmO5Yz7cHvZfbi9b5+F8zy3" +
       "1nJNfQCI3N7hbF8ZnMddAVgUPJwvCrI7ghfqQeDpizBQZGIpeqIUKF43UPLX" +
       "63O8Pz6Di+we3N7/DArPB1xsFRppnlLp/3UF1tp7b9yR8cYrrtL7Z9x928/u" +
       "vu3v7ZbZYPGU3y+5lOHun+d2Wh5evhIIrO1Qalce5R1n5L0oS24B6yZX8bLI" +
       "uamoYmgG21db1ydCyP1bz3vX+D4g8u624d4Vum14atWwjSP37zkD8X1Z8rLt" +
       "nHOo9AQY1/zF0aP7x/t3nXdYQf7eu3dwf+GKwj2w5BceLu/bnugudWlngv8n" +
       "R/roGSxcyJKHwcJQ9sT41Di/8qcBnoCJ7fS3XrIPV7z0oq9Jbb+AJH3q6dtu" +
       "eMnTs3+/fcn84CtFN1KFG9TQNI+/gX/s/DrXU1Q9p+TGPL3VzWGgQeFll73X" +
       "CdCpuydA+5VteRxo+qXK5y/Xnyj5GMB1uiQI7fL/x8u9HkwGR+WCwnXbk+NF" +
       "6tnLfF72htZ+wz0YumMvj20/WZBs/fNLjytU/hzjjucajsMqx7+bknn3/Ltf" +
       "B+8Qh8zu2x+ffro3+LkfVH9l+90WyRTTNGvlBqpw/fYTMnmj2XvI91+2tYO2" +
       "rus88pNbP3PjwwfPgm/dCnyk3Mdku/fSH0khLTfIP2uS/vOX/OZrf/Xpb+Rv" +
       "z/1/6nCUIZBNAAA=");
}
