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
      1471109864000L;
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
       "xG4aE2S6+0SsjO8gatYwfATuE3spsezFYksOVwPkcTix1TCcz2gaFhhcm/tK" +
       "p00ouJ/lt3h3+P8AwAwp4QtBAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "NS3HqV8VQ3KqC8YqXGOTySQ0LRQlNlTb");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("WG9ao/IaM/l6Tyf7ATu1OMom2nAtctHSvNfdFGuVZWWwiexuTYVXNCIE7ZHe" +
       "wOraghm5k5BrY9TUCztMcxSQeHnhhVIQuJWo3aXUmQY1BvNYHyzwjS53DAwi" +
       "8I60IvqJwPSrtDPlXWyD9cMBVZ1NSmqlrHg1LCw2NuutfjSEapJZGq+Z/Mhx" +
       "hm0UqkzR1noNS3Np2V/itqrjyzRes8s57ofyhh5iostbE8Nju+xSSCNdIQJo" +
       "rs/xJgoCnu6SAh5r05gXNWoerVbzcFXzu7GglGUC7lhE06TRuiZECx+eJ1RC" +
       "IlGZmHRA+VCL11qxVWU0mmZwlkKCSq3MdCLcFiQPE8hxpSNxk26lyRAevFrW" +
       "DLMht8uROyyjHB17lMuR0zFLMGGDFIWmIGlARGPVx3STG46Tutun/HGlr0nL" +
       "eaeCELwwqpUnulKMKr5F1YNguQJKa4xGAlfrN9vWuImlAabVO0Q7WQUkRRnh" +
       "ChbWZq8ONaY8xLBsahgjYWI6yarYQulBc5rOkxpKcEwlDZEps26Ne/31wGIq" +
       "DKE0wjZvUp0lFSZWP+pInfpAGExa08Ws0uRL82SKGJt6ZVmcImw54amWTweI" +
       "S1aqrO4HtMx02qgdlkNzRSUwGIaNjs1rU8mzeiaMdYBv6swSpWl20fp4oahE" +
       "Kjkkb3F84Ez89Xrajb2oR6mjsibP1qX5GA7rbTT0GJPGaJtQBYHE/EW/2PAb" +
       "FtVuVHxa6w2HOlGKuFrAkPFmjnSbQyQ0PbLWK9ui4A3QSXHeQevdGqc5fFL0" +
       "+umwGleBSvQFrxObCYWkhjOEO7UWMdZ7m2FpwvaFKmyDtT7RHGvkKoh0SBSH" +
       "DYwZ9qJ1h52jeK8Bx0iJKErQYMIkS5PFilG/NTInNrFer0FE7xflYrqqA2to" +
       "l1Ot1rZjdIiuMLCylou+SoYzaIlXZE2G2TIZTTzWdqsObel8ncYJekKJGARW" +
       "fhKtFqsJshpMui2kOIXmmpzA6cqbl5AGJsDJFCV7YqWFlScMJ6+aFk4otlkK" +
       "LaVjoE4xgikmwTFEEpEpXwNrPMMbTkvIBidAzKHAJQIiOQ/2Ww2kH8H1rrGO" +
       "DGZlS4uZIkQ6LqLuGsHpiloEQdAGiVfGHN44Fj706iNT5AhhTCZUg+eGDbzv" +
       "e+u0TahVnpm2MKgMBa0KVukYvhtQC9q0cL1cHPNE6uu8i2KwA0VdY9agsW4p" +
       "kNZQFSn7bmnNAqR0ddoZ0rVKhVarPrMhIcVXFLwcDYa0g4wrDGbpAgXiTELB" +
       "B3DJGVZUglcr47E/F+xO3x3pxZ5b50EA36MWeqqZ1ZrYTKJhEiVTqD0ZGQtc" +
       "N4hls12KkTXjlAdLo5G0ygKFTCpFeOKvhkC/gkWs1KYhhfquL6fNheEP2Zgx" +
       "xKmelKakmCKq0NQ00YKCHgj2nbALmQGqoUWGqMW12C2PgnqtVvvp7Nb6P35+" +
       "t/xflD/dONyHvDLxLOOXn8dd/eTYI9vDJ0D533WFU3tXjz0BOrZZaC87nWTP" +
       "6O+53B7j/Pn8x97x9DPS8FdKB1u63hIUbgwc97WmHMnmsfZesX2AdyhL9iAq" +
       "327Y3MnSPP006gjtRbzlwr16y9YZj+6+eEbel7Lkt4PCzaocDEJr+4w3f6R1" +
       "RPDvPNdjk+ONnsKXb3TJyvZ2+HrPA1/hktD2jrC/OS/wtTPwfT1L/nVQuAHg" +
       "a7EdKTmF7SvnwJY9Vs83PbE7bOyVH7tvnJH3rSz5o6BwPcDWdHZvPLw0KDxw" +
       "5nabw5I5/j8+B/57soslcLxph/9NVx7/n52R99+z5NtB4SU7/GPZlmRv9+rF" +
       "ARn35c8jhXhHwKXL5VR85xxUHJqxtKNCujJUXKTrf34GH3+RJT/c2nJuyKQj" +
       "yaf0/UfnAPlgdvFxcFg7kNbVAbl33eVB7t2QJXtB4eUHILuhH+iKLub7hzq2" +
       "4hyM/MMnR/6Mwhkze/vnYCafVV4FjmjHTHSVmHnJGczcmSW3BYWXHjBDOypA" +
       "atad0Jb8A1ZuPWRlogm7PfA5/tvPgT/T/Hxn0dt2+N92lfA/eAb+rMm9e4LC" +
       "bQf4+3Lg6eIh8kefexfi8Ro5KfeeVynuB8dTO1KeukqkwGeQgmRJ8RgpwzDI" +
       "3vjJLt91hPM158D5suxitt/3vTuc771KOF93Bs7XZwkeFO449H2yeUrzX36o" +
       "+arsWBfGshgItmrKSOOIB+K84cBD4PjQjocPXSUezpgv9+gsoYLC7Qc8HLwz" +
       "dsDCS0+ywDi6HRxnoHleN/AacHx0x8BHrxID8zMYyHbW7U3A4uGAgakn2H72" +
       "HtABBfecpKCmKMAgTpbKqZie1/gfAcfHd1R8/CpRoZxBRbY3bU/YBkjbXda6" +
       "Hx5MCKc8wPIcYPN3prJ6v7ED+xtXBuyx7ZDZDru9QY7KOwNxts95zwLq719K" +
       "/U9vEYscXTpiwD4vA21wfHbHwGevDgNvzFG+/QwG/naWvBWov39a/bOM6Aju" +
       "k1diwL+wg/uFKw/3UiN2/dJxTFmwc6R//wwW3pslT4Fpzz/SfH2Zv9h6nINf" +
       "OK+7fwAcX95x8OWrZOEfPgPnM1nyARDV6f5pmO8+gvnB8zqye8HxBzuYf3Bl" +
       "YF5zdOfnzYfJW3NQv3YG4E9kyS8HhVuOr3Hykm89wvux8w7rw+D48Q7vj68S" +
       "3jznaCN9dh+hcF/hohequfPucLd1K3uB0vFq4Cxf9xxsnr9aTSeXMt1rFdMR" +
       "gtNanv/Odt3u/ZPdtuu9z12a2rN30e995q+2ix50m9fOfp+xi37vX5yR98Us" +
       "+Z0sx9tKckbZLyXb/795Rpl/lSWfOhbAHJ/D9j5zpOafPm/QDlRs775t3e3/" +
       "86v5cSBfPyPvD7Pk32zj1BPr1Oz6G44w/tvzui4Qk+5d2GG8cOUxfuuMvD/J" +
       "kv8QFG4CGC+97PqPVwLd63boXndl0B1Zz95v5UmO5Yz7cHvZfbi9b5+F8zy3" +
       "1nJNfRCI3NrhbF0ZnMddAVgUPJIvCrI7ghdqQeDpyzCQJVITPEEMZK8TyPnr" +
       "9TneH5/BRXYPbu9/BIUXAi62Co00Tqn0/7wCa+29N+7IeOMVV+n9M+6+7Wd3" +
       "3/b3dstssHjK75dcynD3z3M7LQ8vXwUEVnco1SuP8o4z8l6SJbeAdZMre1nk" +
       "3JAVITSD7aut6xMh5P6t571rfD8QeXfbcO8K3TY8tWrYxpH7956B+P4sefl2" +
       "zjlUehKMa/7i6NH94/27zzusIH/vXTu4v3BF4R5Y8osPl/ctT3A1XdyZ4P/O" +
       "kT52BgsXsuQRsDCUPCE+Nc6vej7AEzCxnf7WS/bhirsu+prU9gtI4iefue2G" +
       "lz0z+3fbl8wPvlJ0I124QQlN8/gb+MfOr3M9WdFzSm7M01vdHAYWFF5+2Xud" +
       "AJ2yewK0X96WJ4CmX6p8/nL9iZKPA1ynS4LQLv9/vNzrwWRwVC4oXLc9OV6k" +
       "lr3M52VvaO3X3YOhO/by2PaTBcnWP991XKHy5xh3PNdwHFY5/t2UzLvn3/06" +
       "eIc4ZHbf/vjUM93Bz/6g8ivb77aIppCmWSs30IXrt5+QyRvN3kN+4LKtHbR1" +
       "XfvRn9z66RsfOXgWfOtW4CPlPibbfZf+SApluUH+WZP0n73sN1/3q898I397" +
       "7v8BD61lbJBNAAA=");
}
