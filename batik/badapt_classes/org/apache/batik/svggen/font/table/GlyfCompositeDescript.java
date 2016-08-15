package org.apache.batik.svggen.font.table;
public class GlyfCompositeDescript extends org.apache.batik.svggen.font.table.GlyfDescript {
    private java.util.List components = new java.util.ArrayList();
    protected boolean beingResolved = false;
    protected boolean resolved = false;
    public GlyfCompositeDescript(org.apache.batik.svggen.font.table.GlyfTable parentTable,
                                 java.io.ByteArrayInputStream bais) {
        super(
          parentTable,
          (short)
            -1,
          bais);
        org.apache.batik.svggen.font.table.GlyfCompositeComp comp;
        do  {
            comp =
              new org.apache.batik.svggen.font.table.GlyfCompositeComp(
                bais);
            components.
              add(
                comp);
        }while((comp.
                  getFlags(
                    ) &
                  org.apache.batik.svggen.font.table.GlyfCompositeComp.
                    MORE_COMPONENTS) !=
                 0); 
        if ((comp.
               getFlags(
                 ) &
               org.apache.batik.svggen.font.table.GlyfCompositeComp.
                 WE_HAVE_INSTRUCTIONS) !=
              0) {
            readInstructions(
              bais,
              bais.
                read(
                  ) <<
                8 |
                bais.
                read(
                  ));
        }
    }
    public void resolve() { if (resolved) return;
                            if (beingResolved) { java.lang.System.
                                                   err.println("Circular reference in GlyfCompositeDesc");
                                                 return; }
                            beingResolved = true;
                            int firstIndex = 0;
                            int firstContour = 0;
                            java.util.Iterator i = components.iterator(
                                                                );
                            while (i.hasNext()) { org.apache.batik.svggen.font.table.GlyfCompositeComp comp =
                                                    (org.apache.batik.svggen.font.table.GlyfCompositeComp)
                                                      i.
                                                      next(
                                                        );
                                                  comp.
                                                    setFirstIndex(
                                                      firstIndex);
                                                  comp.
                                                    setFirstContour(
                                                      firstContour);
                                                  org.apache.batik.svggen.font.table.GlyfDescript desc;
                                                  desc =
                                                    parentTable.
                                                      getDescription(
                                                        comp.
                                                          getGlyphIndex(
                                                            ));
                                                  if (desc !=
                                                        null) {
                                                      desc.
                                                        resolve(
                                                          );
                                                      firstIndex +=
                                                        desc.
                                                          getPointCount(
                                                            );
                                                      firstContour +=
                                                        desc.
                                                          getContourCount(
                                                            );
                                                  }
                            }
                            resolved = true;
                            beingResolved = false;
    }
    public int getEndPtOfContours(int i) { org.apache.batik.svggen.font.table.GlyfCompositeComp c =
                                             getCompositeCompEndPt(
                                               i);
                                           if (c !=
                                                 null) {
                                               org.apache.batik.svggen.font.table.GlyphDescription gd =
                                                 parentTable.
                                                 getDescription(
                                                   c.
                                                     getGlyphIndex(
                                                       ));
                                               return gd.
                                                 getEndPtOfContours(
                                                   i -
                                                     c.
                                                     getFirstContour(
                                                       )) +
                                                 c.
                                                 getFirstIndex(
                                                   );
                                           }
                                           return 0;
    }
    public byte getFlags(int i) { org.apache.batik.svggen.font.table.GlyfCompositeComp c =
                                    getCompositeComp(
                                      i);
                                  if (c !=
                                        null) {
                                      org.apache.batik.svggen.font.table.GlyphDescription gd =
                                        parentTable.
                                        getDescription(
                                          c.
                                            getGlyphIndex(
                                              ));
                                      return gd.
                                        getFlags(
                                          i -
                                            c.
                                            getFirstIndex(
                                              ));
                                  }
                                  return 0;
    }
    public short getXCoordinate(int i) { org.apache.batik.svggen.font.table.GlyfCompositeComp c =
                                           getCompositeComp(
                                             i);
                                         if (c !=
                                               null) {
                                             org.apache.batik.svggen.font.table.GlyphDescription gd =
                                               parentTable.
                                               getDescription(
                                                 c.
                                                   getGlyphIndex(
                                                     ));
                                             int n =
                                               i -
                                               c.
                                               getFirstIndex(
                                                 );
                                             int x =
                                               gd.
                                               getXCoordinate(
                                                 n);
                                             int y =
                                               gd.
                                               getYCoordinate(
                                                 n);
                                             short x1 =
                                               (short)
                                                 c.
                                                 scaleX(
                                                   x,
                                                   y);
                                             x1 +=
                                               c.
                                                 getXTranslate(
                                                   );
                                             return x1;
                                         }
                                         return 0;
    }
    public short getYCoordinate(int i) { org.apache.batik.svggen.font.table.GlyfCompositeComp c =
                                           getCompositeComp(
                                             i);
                                         if (c !=
                                               null) {
                                             org.apache.batik.svggen.font.table.GlyphDescription gd =
                                               parentTable.
                                               getDescription(
                                                 c.
                                                   getGlyphIndex(
                                                     ));
                                             int n =
                                               i -
                                               c.
                                               getFirstIndex(
                                                 );
                                             int x =
                                               gd.
                                               getXCoordinate(
                                                 n);
                                             int y =
                                               gd.
                                               getYCoordinate(
                                                 n);
                                             short y1 =
                                               (short)
                                                 c.
                                                 scaleY(
                                                   x,
                                                   y);
                                             y1 +=
                                               c.
                                                 getYTranslate(
                                                   );
                                             return y1;
                                         }
                                         return 0;
    }
    public boolean isComposite() { return true;
    }
    public int getPointCount() { if (!resolved)
                                     java.lang.System.
                                       err.
                                       println(
                                         "getPointCount called on unresolved GlyfCompositeDescript");
                                 org.apache.batik.svggen.font.table.GlyfCompositeComp c =
                                   (org.apache.batik.svggen.font.table.GlyfCompositeComp)
                                     components.
                                     get(
                                       components.
                                         size(
                                           ) -
                                         1);
                                 return c.
                                   getFirstIndex(
                                     ) +
                                   parentTable.
                                   getDescription(
                                     c.
                                       getGlyphIndex(
                                         )).
                                   getPointCount(
                                     ); }
    public int getContourCount() { if (!resolved)
                                       java.lang.System.
                                         err.
                                         println(
                                           "getContourCount called on unresolved GlyfCompositeDescript");
                                   org.apache.batik.svggen.font.table.GlyfCompositeComp c =
                                     (org.apache.batik.svggen.font.table.GlyfCompositeComp)
                                       components.
                                       get(
                                         components.
                                           size(
                                             ) -
                                           1);
                                   return c.
                                     getFirstContour(
                                       ) +
                                     parentTable.
                                     getDescription(
                                       c.
                                         getGlyphIndex(
                                           )).
                                     getContourCount(
                                       );
    }
    public int getComponentIndex(int i) {
        return ((org.apache.batik.svggen.font.table.GlyfCompositeComp)
                  components.
                  get(
                    i)).
          getFirstIndex(
            );
    }
    public int getComponentCount() { return components.
                                       size(
                                         );
    }
    protected org.apache.batik.svggen.font.table.GlyfCompositeComp getCompositeComp(int i) {
        org.apache.batik.svggen.font.table.GlyfCompositeComp c;
        for (int n =
               0;
             n <
               components.
               size(
                 );
             n++) {
            c =
              (org.apache.batik.svggen.font.table.GlyfCompositeComp)
                components.
                get(
                  n);
            org.apache.batik.svggen.font.table.GlyphDescription gd =
              parentTable.
              getDescription(
                c.
                  getGlyphIndex(
                    ));
            if (c.
                  getFirstIndex(
                    ) <=
                  i &&
                  i <
                  c.
                  getFirstIndex(
                    ) +
                  gd.
                  getPointCount(
                    )) {
                return c;
            }
        }
        return null;
    }
    protected org.apache.batik.svggen.font.table.GlyfCompositeComp getCompositeCompEndPt(int i) {
        org.apache.batik.svggen.font.table.GlyfCompositeComp c;
        for (int j =
               0;
             j <
               components.
               size(
                 );
             j++) {
            c =
              (org.apache.batik.svggen.font.table.GlyfCompositeComp)
                components.
                get(
                  j);
            org.apache.batik.svggen.font.table.GlyphDescription gd =
              parentTable.
              getDescription(
                c.
                  getGlyphIndex(
                    ));
            if (c.
                  getFirstContour(
                    ) <=
                  i &&
                  i <
                  c.
                  getFirstContour(
                    ) +
                  gd.
                  getContourCount(
                    )) {
                return c;
            }
        }
        return null;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "70ffeXh/eIu6/1okvxdB9wADMh6gM8KL");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("3egML33j7QIs7PeZA4CfeecB/ukt6v6sSP57BF0BAA9o90YQ/8fbhfg4eH7i" +
       "AOJPfG9W4rnbb47z3IWi8DsgSitxHlwyGLqqlp5Geg56J5D+1AHSn3rHjXnu" +
       "6i3q7i+Su86AvIE5z939NkAW+KAqeL5wAPILbxXk4rsz5yO3QPpokTwYQVcP" +
       "kRa8U2TK1g9EEPJW71AedS4V9NDbVVATPK8dKOi175GCnr2Fgp4rkqci6IGz" +
       "CipDrKLy8WO0T78VtCkY9Ia3T4urdA+94Sb8/va28guvXLn04CvCvy4vYB7d" +
       "sL6Tgi7psW2fvJ90In/BDzTdLJVx5/62UnnaOteIoCff3L4gnogO792dq+97" +
       "ohH0yK16gvCr+HOySzuCHrxJl+KGRJk52f4DwCvPtgeilH9PtvvBCLp83A4M" +
       "tc+cbIKDEBo0KbLEkWfD36VnH5ol3YfmD5101pLT738zq584VL731FGw/F8R" +
       "h8e2mDm4jPXaK6PJD38L/en9XVXFlvO8GOUSBV3cX5stBy2Ofk/cdLTDsS4M" +
       "nvn2vb9451OHx9R79wIfL5wTsj1244uhPcePyquc+a88+Pc/8DOv/E55F+T/" +
       "Agdtq1muMgAA");
}
