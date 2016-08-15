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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "4PmRA3g/8s7D+6Nb1P23Ivn9GLoHGHDm");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("ATrDvcSNz/DS198uwMJ+nz4A+Ol3HuCf3aLuz4vkv8fQFQDwgHZvBPF/vF2I" +
       "j4PnJw8g/uR3ZyWeu/3mOM9dKAq/DaK0EufBJYORq6jZaaTnoHcC6U8fIP3p" +
       "d9yY567eou7+IrnrDMgbmPPc3W8DZIEPqoLn8wcgP/9WQQrfmTkfuQXSR4vk" +
       "wRi6eoi04J0iU7Z+IIaQt3qH8qhzqaCH3q6CUPC8dqCg175LCnr2Fgp6rkie" +
       "iqEHziqoDLGKyseP0T79VtBmYNAb3j4trtI99Iab8Pvb2/IvvnLl0oOvcP+m" +
       "vIB5dMP6Tgq6pCW2ffJ+0on8BT9UNaNUxp3720rlaetcI4aefHP7gngiPrx3" +
       "d66+79mMoUdu1ROEX8Wfk13aMfTgTboUNyTKzMn2HwBeebY9EKX8e7LdD8TQ" +
       "5eN2YKh95mSTLgihQZMiix95NvwdevahWbJ9aP7QSWctOf3+N7P6iUPle08d" +
       "Bcv/FXF4bEtmB5exXntlPP3BbzZ/Zn9XVbal3a4Y5RIFXdxfmy0HLY5+T9x0" +
       "tMOxLgyf+da9v3TnU4fH1Hv3Ah8vnBOyPXbji6F9x4/Lq5y7X33wH3zgZ1/5" +
       "3fIuyP8FIv4b8q4yAAA=");
}
