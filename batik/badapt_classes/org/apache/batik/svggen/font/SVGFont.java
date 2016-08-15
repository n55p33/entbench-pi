package org.apache.batik.svggen.font;
public class SVGFont implements org.apache.batik.util.XMLConstants, org.apache.batik.util.SVGConstants, org.apache.batik.svggen.font.table.ScriptTags, org.apache.batik.svggen.font.table.FeatureTags {
    static final java.lang.String EOL;
    static final java.lang.String PROPERTY_LINE_SEPARATOR = "line.separator";
    static final java.lang.String PROPERTY_LINE_SEPARATOR_DEFAULT = "\n";
    static final int DEFAULT_FIRST = 32;
    static final int DEFAULT_LAST = 128;
    static { java.lang.String temp;
             try { temp = java.lang.System.getProperty(PROPERTY_LINE_SEPARATOR,
                                                       PROPERTY_LINE_SEPARATOR_DEFAULT);
             }
             catch (java.lang.SecurityException e) {
                 temp =
                   PROPERTY_LINE_SEPARATOR_DEFAULT;
             }
             EOL = temp; }
    private static java.lang.String QUOT_EOL = XML_CHAR_QUOT + EOL;
    private static java.lang.String CONFIG_USAGE = "SVGFont.config.usage";
    private static java.lang.String CONFIG_SVG_BEGIN = "SVGFont.config.svg.begin";
    private static java.lang.String CONFIG_SVG_TEST_CARD_START = "SVGFont.config.svg.test.card.start";
    private static java.lang.String CONFIG_SVG_TEST_CARD_END = "SVGFont.config.svg.test.card.end";
    protected static java.lang.String encodeEntities(java.lang.String s) {
        java.lang.StringBuffer sb =
          new java.lang.StringBuffer(
          );
        for (int i =
               0;
             i <
               s.
               length(
                 );
             i++) {
            if (s.
                  charAt(
                    i) ==
                  XML_CHAR_LT) {
                sb.
                  append(
                    XML_ENTITY_LT);
            }
            else
                if (s.
                      charAt(
                        i) ==
                      XML_CHAR_GT) {
                    sb.
                      append(
                        XML_ENTITY_GT);
                }
                else
                    if (s.
                          charAt(
                            i) ==
                          XML_CHAR_AMP) {
                        sb.
                          append(
                            XML_ENTITY_AMP);
                    }
                    else
                        if (s.
                              charAt(
                                i) ==
                              XML_CHAR_APOS) {
                            sb.
                              append(
                                XML_ENTITY_APOS);
                        }
                        else
                            if (s.
                                  charAt(
                                    i) ==
                                  XML_CHAR_QUOT) {
                                sb.
                                  append(
                                    XML_ENTITY_QUOT);
                            }
                            else {
                                sb.
                                  append(
                                    s.
                                      charAt(
                                        i));
                            }
        }
        return sb.
          toString(
            );
    }
    protected static java.lang.String getContourAsSVGPathData(org.apache.batik.svggen.font.Glyph glyph,
                                                              int startIndex,
                                                              int count) {
        if (glyph.
              getPoint(
                startIndex).
              endOfContour) {
            return "";
        }
        java.lang.StringBuffer sb =
          new java.lang.StringBuffer(
          );
        int offset =
          0;
        while (offset <
                 count) {
            org.apache.batik.svggen.font.Point point =
              glyph.
              getPoint(
                startIndex +
                  offset %
                  count);
            org.apache.batik.svggen.font.Point point_plus1 =
              glyph.
              getPoint(
                startIndex +
                  (offset +
                     1) %
                  count);
            org.apache.batik.svggen.font.Point point_plus2 =
              glyph.
              getPoint(
                startIndex +
                  (offset +
                     2) %
                  count);
            if (offset ==
                  0) {
                sb.
                  append(
                    PATH_MOVE).
                  append(
                    java.lang.String.
                      valueOf(
                        point.
                          x)).
                  append(
                    XML_SPACE).
                  append(
                    java.lang.String.
                      valueOf(
                        point.
                          y));
            }
            if (point.
                  onCurve &&
                  point_plus1.
                    onCurve) {
                if (point_plus1.
                      x ==
                      point.
                        x) {
                    sb.
                      append(
                        PATH_VERTICAL_LINE_TO).
                      append(
                        java.lang.String.
                          valueOf(
                            point_plus1.
                              y));
                }
                else
                    if (point_plus1.
                          y ==
                          point.
                            y) {
                        sb.
                          append(
                            PATH_HORIZONTAL_LINE_TO).
                          append(
                            java.lang.String.
                              valueOf(
                                point_plus1.
                                  x));
                    }
                    else {
                        sb.
                          append(
                            PATH_LINE_TO).
                          append(
                            java.lang.String.
                              valueOf(
                                point_plus1.
                                  x)).
                          append(
                            XML_SPACE).
                          append(
                            java.lang.String.
                              valueOf(
                                point_plus1.
                                  y));
                    }
                offset++;
            }
            else
                if (point.
                      onCurve &&
                      !point_plus1.
                         onCurve &&
                      point_plus2.
                        onCurve) {
                    sb.
                      append(
                        PATH_QUAD_TO).
                      append(
                        java.lang.String.
                          valueOf(
                            point_plus1.
                              x)).
                      append(
                        XML_SPACE).
                      append(
                        java.lang.String.
                          valueOf(
                            point_plus1.
                              y)).
                      append(
                        XML_SPACE).
                      append(
                        java.lang.String.
                          valueOf(
                            point_plus2.
                              x)).
                      append(
                        XML_SPACE).
                      append(
                        java.lang.String.
                          valueOf(
                            point_plus2.
                              y));
                    offset +=
                      2;
                }
                else
                    if (point.
                          onCurve &&
                          !point_plus1.
                             onCurve &&
                          !point_plus2.
                             onCurve) {
                        sb.
                          append(
                            PATH_QUAD_TO).
                          append(
                            java.lang.String.
                              valueOf(
                                point_plus1.
                                  x)).
                          append(
                            XML_SPACE).
                          append(
                            java.lang.String.
                              valueOf(
                                point_plus1.
                                  y)).
                          append(
                            XML_SPACE).
                          append(
                            java.lang.String.
                              valueOf(
                                midValue(
                                  point_plus1.
                                    x,
                                  point_plus2.
                                    x))).
                          append(
                            XML_SPACE).
                          append(
                            java.lang.String.
                              valueOf(
                                midValue(
                                  point_plus1.
                                    y,
                                  point_plus2.
                                    y)));
                        offset +=
                          2;
                    }
                    else
                        if (!point.
                               onCurve &&
                              !point_plus1.
                                 onCurve) {
                            sb.
                              append(
                                PATH_SMOOTH_QUAD_TO).
                              append(
                                java.lang.String.
                                  valueOf(
                                    midValue(
                                      point.
                                        x,
                                      point_plus1.
                                        x))).
                              append(
                                XML_SPACE).
                              append(
                                java.lang.String.
                                  valueOf(
                                    midValue(
                                      point.
                                        y,
                                      point_plus1.
                                        y)));
                            offset++;
                        }
                        else
                            if (!point.
                                   onCurve &&
                                  point_plus1.
                                    onCurve) {
                                sb.
                                  append(
                                    PATH_SMOOTH_QUAD_TO).
                                  append(
                                    java.lang.String.
                                      valueOf(
                                        point_plus1.
                                          x)).
                                  append(
                                    XML_SPACE).
                                  append(
                                    java.lang.String.
                                      valueOf(
                                        point_plus1.
                                          y));
                                offset++;
                            }
                            else {
                                java.lang.System.
                                  out.
                                  println(
                                    "drawGlyph case not catered for!!");
                                break;
                            }
        }
        sb.
          append(
            PATH_CLOSE);
        return sb.
          toString(
            );
    }
    protected static java.lang.String getSVGFontFaceElement(org.apache.batik.svggen.font.Font font) {
        java.lang.StringBuffer sb =
          new java.lang.StringBuffer(
          );
        java.lang.String fontFamily =
          font.
          getNameTable(
            ).
          getRecord(
            org.apache.batik.svggen.font.table.Table.
              nameFontFamilyName);
        short unitsPerEm =
          font.
          getHeadTable(
            ).
          getUnitsPerEm(
            );
        java.lang.String panose =
          font.
          getOS2Table(
            ).
          getPanose(
            ).
          toString(
            );
        short ascent =
          font.
          getHheaTable(
            ).
          getAscender(
            );
        short descent =
          font.
          getHheaTable(
            ).
          getDescender(
            );
        int baseline =
          0;
        sb.
          append(
            XML_OPEN_TAG_START).
          append(
            SVG_FONT_FACE_TAG).
          append(
            EOL).
          append(
            XML_TAB).
          append(
            SVG_FONT_FAMILY_ATTRIBUTE).
          append(
            XML_EQUAL_QUOT).
          append(
            fontFamily).
          append(
            QUOT_EOL).
          append(
            XML_TAB).
          append(
            SVG_UNITS_PER_EM_ATTRIBUTE).
          append(
            XML_EQUAL_QUOT).
          append(
            unitsPerEm).
          append(
            QUOT_EOL).
          append(
            XML_TAB).
          append(
            SVG_PANOSE_1_ATTRIBUTE).
          append(
            XML_EQUAL_QUOT).
          append(
            panose).
          append(
            QUOT_EOL).
          append(
            XML_TAB).
          append(
            SVG_ASCENT_ATTRIBUTE).
          append(
            XML_EQUAL_QUOT).
          append(
            ascent).
          append(
            QUOT_EOL).
          append(
            XML_TAB).
          append(
            SVG_DESCENT_ATTRIBUTE).
          append(
            XML_EQUAL_QUOT).
          append(
            descent).
          append(
            QUOT_EOL).
          append(
            XML_TAB).
          append(
            SVG_ALPHABETIC_ATTRIBUTE).
          append(
            XML_EQUAL_QUOT).
          append(
            baseline).
          append(
            XML_CHAR_QUOT).
          append(
            XML_OPEN_TAG_END_NO_CHILDREN).
          append(
            EOL);
        return sb.
          toString(
            );
    }
    protected static void writeFontAsSVGFragment(java.io.PrintStream ps,
                                                 org.apache.batik.svggen.font.Font font,
                                                 java.lang.String id,
                                                 int first,
                                                 int last,
                                                 boolean autoRange,
                                                 boolean forceAscii)
          throws java.lang.Exception { int horiz_advance_x =
                                         font.
                                         getOS2Table(
                                           ).
                                         getAvgCharWidth(
                                           );
                                       ps.
                                         print(
                                           XML_OPEN_TAG_START);
                                       ps.
                                         print(
                                           SVG_FONT_TAG);
                                       ps.
                                         print(
                                           XML_SPACE);
                                       if (id !=
                                             null) {
                                           ps.
                                             print(
                                               SVG_ID_ATTRIBUTE);
                                           ps.
                                             print(
                                               XML_EQUAL_QUOT);
                                           ps.
                                             print(
                                               id);
                                           ps.
                                             print(
                                               XML_CHAR_QUOT);
                                           ps.
                                             print(
                                               XML_SPACE);
                                       }
                                       ps.
                                         print(
                                           SVG_HORIZ_ADV_X_ATTRIBUTE);
                                       ps.
                                         print(
                                           XML_EQUAL_QUOT);
                                       ps.
                                         print(
                                           horiz_advance_x);
                                       ps.
                                         print(
                                           XML_CHAR_QUOT);
                                       ps.
                                         print(
                                           XML_OPEN_TAG_END_CHILDREN);
                                       ps.
                                         print(
                                           getSVGFontFaceElement(
                                             font));
                                       org.apache.batik.svggen.font.table.CmapFormat cmapFmt =
                                         null;
                                       if (forceAscii) {
                                           cmapFmt =
                                             font.
                                               getCmapTable(
                                                 ).
                                               getCmapFormat(
                                                 org.apache.batik.svggen.font.table.Table.
                                                   platformMacintosh,
                                                 org.apache.batik.svggen.font.table.Table.
                                                   encodingRoman);
                                       }
                                       else {
                                           cmapFmt =
                                             font.
                                               getCmapTable(
                                                 ).
                                               getCmapFormat(
                                                 org.apache.batik.svggen.font.table.Table.
                                                   platformMicrosoft,
                                                 org.apache.batik.svggen.font.table.Table.
                                                   encodingUGL);
                                           if (cmapFmt ==
                                                 null) {
                                               cmapFmt =
                                                 font.
                                                   getCmapTable(
                                                     ).
                                                   getCmapFormat(
                                                     org.apache.batik.svggen.font.table.Table.
                                                       platformMicrosoft,
                                                     org.apache.batik.svggen.font.table.Table.
                                                       encodingUndefined);
                                           }
                                       }
                                       if (cmapFmt ==
                                             null) {
                                           throw new java.lang.Exception(
                                             "Cannot find a suitable cmap table");
                                       }
                                       org.apache.batik.svggen.font.table.GsubTable gsub =
                                         (org.apache.batik.svggen.font.table.GsubTable)
                                           font.
                                           getTable(
                                             org.apache.batik.svggen.font.table.Table.
                                               GSUB);
                                       org.apache.batik.svggen.font.table.SingleSubst initialSubst =
                                         null;
                                       org.apache.batik.svggen.font.table.SingleSubst medialSubst =
                                         null;
                                       org.apache.batik.svggen.font.table.SingleSubst terminalSubst =
                                         null;
                                       if (gsub !=
                                             null) {
                                           org.apache.batik.svggen.font.table.Script s =
                                             gsub.
                                             getScriptList(
                                               ).
                                             findScript(
                                               SCRIPT_TAG_ARAB);
                                           if (s !=
                                                 null) {
                                               org.apache.batik.svggen.font.table.LangSys ls =
                                                 s.
                                                 getDefaultLangSys(
                                                   );
                                               if (ls !=
                                                     null) {
                                                   org.apache.batik.svggen.font.table.Feature init =
                                                     gsub.
                                                     getFeatureList(
                                                       ).
                                                     findFeature(
                                                       ls,
                                                       FEATURE_TAG_INIT);
                                                   org.apache.batik.svggen.font.table.Feature medi =
                                                     gsub.
                                                     getFeatureList(
                                                       ).
                                                     findFeature(
                                                       ls,
                                                       FEATURE_TAG_MEDI);
                                                   org.apache.batik.svggen.font.table.Feature fina =
                                                     gsub.
                                                     getFeatureList(
                                                       ).
                                                     findFeature(
                                                       ls,
                                                       FEATURE_TAG_FINA);
                                                   initialSubst =
                                                     (org.apache.batik.svggen.font.table.SingleSubst)
                                                       gsub.
                                                       getLookupList(
                                                         ).
                                                       getLookup(
                                                         init,
                                                         0).
                                                       getSubtable(
                                                         0);
                                                   medialSubst =
                                                     (org.apache.batik.svggen.font.table.SingleSubst)
                                                       gsub.
                                                       getLookupList(
                                                         ).
                                                       getLookup(
                                                         medi,
                                                         0).
                                                       getSubtable(
                                                         0);
                                                   terminalSubst =
                                                     (org.apache.batik.svggen.font.table.SingleSubst)
                                                       gsub.
                                                       getLookupList(
                                                         ).
                                                       getLookup(
                                                         fina,
                                                         0).
                                                       getSubtable(
                                                         0);
                                               }
                                           }
                                       }
                                       ps.
                                         println(
                                           getGlyphAsSVG(
                                             font,
                                             font.
                                               getGlyph(
                                                 0),
                                             0,
                                             horiz_advance_x,
                                             initialSubst,
                                             medialSubst,
                                             terminalSubst,
                                             ""));
                                       try {
                                           if (first ==
                                                 -1) {
                                               if (!autoRange)
                                                   first =
                                                     DEFAULT_FIRST;
                                               else
                                                   first =
                                                     cmapFmt.
                                                       getFirst(
                                                         );
                                           }
                                           if (last ==
                                                 -1) {
                                               if (!autoRange)
                                                   last =
                                                     DEFAULT_LAST;
                                               else
                                                   last =
                                                     cmapFmt.
                                                       getLast(
                                                         );
                                           }
                                           for (int i =
                                                  first;
                                                i <=
                                                  last;
                                                i++) {
                                               int glyphIndex =
                                                 cmapFmt.
                                                 mapCharCode(
                                                   i);
                                               if (glyphIndex >
                                                     0) {
                                                   ps.
                                                     println(
                                                       getGlyphAsSVG(
                                                         font,
                                                         font.
                                                           getGlyph(
                                                             glyphIndex),
                                                         glyphIndex,
                                                         horiz_advance_x,
                                                         initialSubst,
                                                         medialSubst,
                                                         terminalSubst,
                                                         32 <=
                                                           i &&
                                                           i <=
                                                           127
                                                           ? encodeEntities(
                                                               java.lang.String.
                                                                 valueOf(
                                                                   (char)
                                                                     i))
                                                           : XML_CHAR_REF_PREFIX +
                                                         java.lang.Integer.
                                                           toHexString(
                                                             i) +
                                                         XML_CHAR_REF_SUFFIX));
                                               }
                                           }
                                           org.apache.batik.svggen.font.table.KernTable kern =
                                             (org.apache.batik.svggen.font.table.KernTable)
                                               font.
                                               getTable(
                                                 org.apache.batik.svggen.font.table.Table.
                                                   kern);
                                           if (kern !=
                                                 null) {
                                               org.apache.batik.svggen.font.table.KernSubtable kst =
                                                 kern.
                                                 getSubtable(
                                                   0);
                                               org.apache.batik.svggen.font.table.PostTable post =
                                                 (org.apache.batik.svggen.font.table.PostTable)
                                                   font.
                                                   getTable(
                                                     org.apache.batik.svggen.font.table.Table.
                                                       post);
                                               for (int i =
                                                      0;
                                                    i <
                                                      kst.
                                                      getKerningPairCount(
                                                        );
                                                    i++) {
                                                   ps.
                                                     println(
                                                       getKerningPairAsSVG(
                                                         kst.
                                                           getKerningPair(
                                                             i),
                                                         post));
                                               }
                                           }
                                       }
                                       catch (java.lang.Exception e) {
                                           java.lang.System.
                                             err.
                                             println(
                                               e.
                                                 getMessage(
                                                   ));
                                       }
                                       ps.
                                         print(
                                           XML_CLOSE_TAG_START);
                                       ps.
                                         print(
                                           SVG_FONT_TAG);
                                       ps.
                                         println(
                                           XML_CLOSE_TAG_END);
    }
    protected static java.lang.String getGlyphAsSVG(org.apache.batik.svggen.font.Font font,
                                                    org.apache.batik.svggen.font.Glyph glyph,
                                                    int glyphIndex,
                                                    int defaultHorizAdvanceX,
                                                    java.lang.String attrib,
                                                    java.lang.String code) {
        java.lang.StringBuffer sb =
          new java.lang.StringBuffer(
          );
        int firstIndex =
          0;
        int count =
          0;
        int i;
        int horiz_advance_x;
        horiz_advance_x =
          font.
            getHmtxTable(
              ).
            getAdvanceWidth(
              glyphIndex);
        if (glyphIndex ==
              0) {
            sb.
              append(
                XML_OPEN_TAG_START);
            sb.
              append(
                SVG_MISSING_GLYPH_TAG);
        }
        else {
            sb.
              append(
                XML_OPEN_TAG_START).
              append(
                SVG_GLYPH_TAG).
              append(
                XML_SPACE).
              append(
                SVG_UNICODE_ATTRIBUTE).
              append(
                XML_EQUAL_QUOT).
              append(
                code).
              append(
                XML_CHAR_QUOT);
            sb.
              append(
                XML_SPACE).
              append(
                SVG_GLYPH_NAME_ATTRIBUTE).
              append(
                XML_EQUAL_QUOT).
              append(
                font.
                  getPostTable(
                    ).
                  getGlyphName(
                    glyphIndex)).
              append(
                XML_CHAR_QUOT);
        }
        if (horiz_advance_x !=
              defaultHorizAdvanceX) {
            sb.
              append(
                XML_SPACE).
              append(
                SVG_HORIZ_ADV_X_ATTRIBUTE).
              append(
                XML_EQUAL_QUOT).
              append(
                horiz_advance_x).
              append(
                XML_CHAR_QUOT);
        }
        if (attrib !=
              null) {
            sb.
              append(
                attrib);
        }
        if (glyph !=
              null) {
            sb.
              append(
                XML_SPACE).
              append(
                SVG_D_ATTRIBUTE).
              append(
                XML_EQUAL_QUOT);
            for (i =
                   0;
                 i <
                   glyph.
                   getPointCount(
                     );
                 i++) {
                count++;
                if (glyph.
                      getPoint(
                        i).
                      endOfContour) {
                    sb.
                      append(
                        getContourAsSVGPathData(
                          glyph,
                          firstIndex,
                          count));
                    firstIndex =
                      i +
                        1;
                    count =
                      0;
                }
            }
            sb.
              append(
                XML_CHAR_QUOT);
        }
        sb.
          append(
            XML_OPEN_TAG_END_NO_CHILDREN);
        chopUpStringBuffer(
          sb);
        return sb.
          toString(
            );
    }
    protected static java.lang.String getGlyphAsSVG(org.apache.batik.svggen.font.Font font,
                                                    org.apache.batik.svggen.font.Glyph glyph,
                                                    int glyphIndex,
                                                    int defaultHorizAdvanceX,
                                                    org.apache.batik.svggen.font.table.SingleSubst arabInitSubst,
                                                    org.apache.batik.svggen.font.table.SingleSubst arabMediSubst,
                                                    org.apache.batik.svggen.font.table.SingleSubst arabTermSubst,
                                                    java.lang.String code) {
        java.lang.StringBuffer sb =
          new java.lang.StringBuffer(
          );
        boolean substituted =
          false;
        int arabInitGlyphIndex =
          glyphIndex;
        int arabMediGlyphIndex =
          glyphIndex;
        int arabTermGlyphIndex =
          glyphIndex;
        if (arabInitSubst !=
              null) {
            arabInitGlyphIndex =
              arabInitSubst.
                substitute(
                  glyphIndex);
        }
        if (arabMediSubst !=
              null) {
            arabMediGlyphIndex =
              arabMediSubst.
                substitute(
                  glyphIndex);
        }
        if (arabTermSubst !=
              null) {
            arabTermGlyphIndex =
              arabTermSubst.
                substitute(
                  glyphIndex);
        }
        if (arabInitGlyphIndex !=
              glyphIndex) {
            sb.
              append(
                getGlyphAsSVG(
                  font,
                  font.
                    getGlyph(
                      arabInitGlyphIndex),
                  arabInitGlyphIndex,
                  defaultHorizAdvanceX,
                  XML_SPACE +
                  SVG_ARABIC_FORM_ATTRIBUTE +
                  XML_EQUAL_QUOT +
                  SVG_INITIAL_VALUE +
                  XML_CHAR_QUOT,
                  code));
            sb.
              append(
                EOL);
            substituted =
              true;
        }
        if (arabMediGlyphIndex !=
              glyphIndex) {
            sb.
              append(
                getGlyphAsSVG(
                  font,
                  font.
                    getGlyph(
                      arabMediGlyphIndex),
                  arabMediGlyphIndex,
                  defaultHorizAdvanceX,
                  XML_SPACE +
                  SVG_ARABIC_FORM_ATTRIBUTE +
                  XML_EQUAL_QUOT +
                  SVG_MEDIAL_VALUE +
                  XML_CHAR_QUOT,
                  code));
            sb.
              append(
                EOL);
            substituted =
              true;
        }
        if (arabTermGlyphIndex !=
              glyphIndex) {
            sb.
              append(
                getGlyphAsSVG(
                  font,
                  font.
                    getGlyph(
                      arabTermGlyphIndex),
                  arabTermGlyphIndex,
                  defaultHorizAdvanceX,
                  XML_SPACE +
                  SVG_ARABIC_FORM_ATTRIBUTE +
                  XML_EQUAL_QUOT +
                  SVG_TERMINAL_VALUE +
                  XML_CHAR_QUOT,
                  code));
            sb.
              append(
                EOL);
            substituted =
              true;
        }
        if (substituted) {
            sb.
              append(
                getGlyphAsSVG(
                  font,
                  glyph,
                  glyphIndex,
                  defaultHorizAdvanceX,
                  XML_SPACE +
                  SVG_ARABIC_FORM_ATTRIBUTE +
                  XML_EQUAL_QUOT +
                  SVG_ISOLATED_VALUE +
                  XML_CHAR_QUOT,
                  code));
        }
        else {
            sb.
              append(
                getGlyphAsSVG(
                  font,
                  glyph,
                  glyphIndex,
                  defaultHorizAdvanceX,
                  null,
                  code));
        }
        return sb.
          toString(
            );
    }
    protected static java.lang.String getKerningPairAsSVG(org.apache.batik.svggen.font.table.KerningPair kp,
                                                          org.apache.batik.svggen.font.table.PostTable post) {
        java.lang.StringBuffer sb =
          new java.lang.StringBuffer(
          );
        sb.
          append(
            XML_OPEN_TAG_START).
          append(
            SVG_HKERN_TAG).
          append(
            XML_SPACE);
        sb.
          append(
            SVG_G1_ATTRIBUTE).
          append(
            XML_EQUAL_QUOT);
        sb.
          append(
            post.
              getGlyphName(
                kp.
                  getLeft(
                    )));
        sb.
          append(
            XML_CHAR_QUOT).
          append(
            XML_SPACE).
          append(
            SVG_G2_ATTRIBUTE).
          append(
            XML_EQUAL_QUOT);
        sb.
          append(
            post.
              getGlyphName(
                kp.
                  getRight(
                    )));
        sb.
          append(
            XML_CHAR_QUOT).
          append(
            XML_SPACE).
          append(
            SVG_K_ATTRIBUTE).
          append(
            XML_EQUAL_QUOT);
        sb.
          append(
            -kp.
              getValue(
                ));
        sb.
          append(
            XML_CHAR_QUOT).
          append(
            XML_OPEN_TAG_END_NO_CHILDREN);
        return sb.
          toString(
            );
    }
    protected static void writeSvgBegin(java.io.PrintStream ps) {
        ps.
          println(
            org.apache.batik.svggen.font.Messages.
              formatMessage(
                CONFIG_SVG_BEGIN,
                new java.lang.Object[] { SVG_PUBLIC_ID,
                SVG_SYSTEM_ID }));
    }
    protected static void writeSvgDefsBegin(java.io.PrintStream ps) {
        ps.
          println(
            XML_OPEN_TAG_START +
            SVG_DEFS_TAG +
            XML_OPEN_TAG_END_CHILDREN);
    }
    protected static void writeSvgDefsEnd(java.io.PrintStream ps) {
        ps.
          println(
            XML_CLOSE_TAG_START +
            SVG_DEFS_TAG +
            XML_CLOSE_TAG_END);
    }
    protected static void writeSvgEnd(java.io.PrintStream ps) {
        ps.
          println(
            XML_CLOSE_TAG_START +
            SVG_SVG_TAG +
            XML_CLOSE_TAG_END);
    }
    protected static void writeSvgTestCard(java.io.PrintStream ps,
                                           java.lang.String fontFamily) {
        ps.
          println(
            org.apache.batik.svggen.font.Messages.
              formatMessage(
                CONFIG_SVG_TEST_CARD_START,
                null));
        ps.
          println(
            fontFamily);
        ps.
          println(
            org.apache.batik.svggen.font.Messages.
              formatMessage(
                CONFIG_SVG_TEST_CARD_END,
                null));
    }
    public static final char ARG_KEY_START_CHAR =
      '-';
    public static final java.lang.String ARG_KEY_CHAR_RANGE_LOW =
      "-l";
    public static final java.lang.String ARG_KEY_CHAR_RANGE_HIGH =
      "-h";
    public static final java.lang.String ARG_KEY_ID =
      "-id";
    public static final java.lang.String ARG_KEY_ASCII =
      "-ascii";
    public static final java.lang.String ARG_KEY_TESTCARD =
      "-testcard";
    public static final java.lang.String ARG_KEY_AUTO_RANGE =
      "-autorange";
    public static final java.lang.String ARG_KEY_OUTPUT_PATH =
      "-o";
    public static void main(java.lang.String[] args) {
        try {
            java.lang.String path =
              parseArgs(
                args,
                null);
            java.lang.String low =
              parseArgs(
                args,
                ARG_KEY_CHAR_RANGE_LOW);
            java.lang.String high =
              parseArgs(
                args,
                ARG_KEY_CHAR_RANGE_HIGH);
            java.lang.String id =
              parseArgs(
                args,
                ARG_KEY_ID);
            java.lang.String ascii =
              parseArgs(
                args,
                ARG_KEY_ASCII);
            java.lang.String testCard =
              parseArgs(
                args,
                ARG_KEY_TESTCARD);
            java.lang.String outPath =
              parseArgs(
                args,
                ARG_KEY_OUTPUT_PATH);
            java.lang.String autoRange =
              parseArgs(
                args,
                ARG_KEY_AUTO_RANGE);
            java.io.PrintStream ps =
              null;
            java.io.FileOutputStream fos =
              null;
            if (outPath !=
                  null) {
                fos =
                  new java.io.FileOutputStream(
                    outPath);
                ps =
                  new java.io.PrintStream(
                    fos);
            }
            else {
                ps =
                  java.lang.System.
                    out;
            }
            if (path !=
                  null) {
                org.apache.batik.svggen.font.Font font =
                  org.apache.batik.svggen.font.Font.
                  create(
                    path);
                writeSvgBegin(
                  ps);
                writeSvgDefsBegin(
                  ps);
                writeFontAsSVGFragment(
                  ps,
                  font,
                  id,
                  low !=
                    null
                    ? java.lang.Integer.
                    parseInt(
                      low)
                    : -1,
                  high !=
                    null
                    ? java.lang.Integer.
                    parseInt(
                      high)
                    : -1,
                  autoRange !=
                    null,
                  ascii !=
                    null);
                writeSvgDefsEnd(
                  ps);
                if (testCard !=
                      null) {
                    java.lang.String fontFamily =
                      font.
                      getNameTable(
                        ).
                      getRecord(
                        org.apache.batik.svggen.font.table.Table.
                          nameFontFamilyName);
                    writeSvgTestCard(
                      ps,
                      fontFamily);
                }
                writeSvgEnd(
                  ps);
                if (fos !=
                      null) {
                    fos.
                      close(
                        );
                }
            }
            else {
                usage(
                  );
            }
        }
        catch (java.lang.Exception e) {
            e.
              printStackTrace(
                );
            java.lang.System.
              err.
              println(
                e.
                  getMessage(
                    ));
            usage(
              );
        }
    }
    private static void chopUpStringBuffer(java.lang.StringBuffer sb) {
        if (sb.
              length(
                ) <
              256) {
            return;
        }
        else {
            for (int i =
                   240;
                 i <
                   sb.
                   length(
                     );
                 i++) {
                if (sb.
                      charAt(
                        i) ==
                      ' ') {
                    sb.
                      setCharAt(
                        i,
                        '\n');
                    i +=
                      240;
                }
            }
        }
    }
    private static int midValue(int a, int b) {
        return a +
          (b -
             a) /
          2;
    }
    private static java.lang.String parseArgs(java.lang.String[] args,
                                              java.lang.String name) {
        for (int i =
               0;
             i <
               args.
                 length;
             i++) {
            if (name ==
                  null) {
                if (args[i].
                      charAt(
                        0) !=
                      ARG_KEY_START_CHAR) {
                    return args[i];
                }
            }
            else
                if (name.
                      equalsIgnoreCase(
                        args[i])) {
                    if (i <
                          args.
                            length -
                          1 &&
                          args[i +
                                 1].
                          charAt(
                            0) !=
                          ARG_KEY_START_CHAR) {
                        return args[i +
                                      1];
                    }
                    else {
                        return args[i];
                    }
                }
        }
        return null;
    }
    private static void usage() { java.lang.System.
                                    err.println(
                                          org.apache.batik.svggen.font.Messages.
                                            formatMessage(
                                              CONFIG_USAGE,
                                              null));
    }
    public SVGFont() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "xk0a780PeMdFaLj381u82/t/1Nsip4k9AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "012uepUZyVY5amEMN7a0svrw0Ki21WN5");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "1AVK/sUL7v1KnvxyXLpDycHssF+Q/T9mu89fuCDPl/PkMyACd+SbBoSXXOZ+" +
       "gR0VWz7y8e/FvR29eFk7Or3f4xZ2tO+JR87unGwluq6FBb/fuYD77+XJb8al" +
       "hxTT8wX/dNkzkvitVyCJR/OLTwBSf7GXxF+8ipI4caKnHwn8yQWk/3uevBiX" +
       "rjiWWmymLYqdUP2jV0A19xD5vqnDr++pfv2bQnVnRLvx4qsXUP3fefKV/JFT" +
       "/q4X4DmjE2dScP2zV6rgoFtve2BXdvf5KnE9zeLvLrj39Tz5a+AQkkgu9gyc" +
       "Vtq/uQy7LC7dtX8Okm/Pf+ymt+Xs3vCifPaFB648+oLwX3bDy/FbWO4elq7o" +
       "iW2f3k196vxOP9R0q2B6925vdeHXD++IS6+/aB4D3FL+kYM9vH1X5EpcevQW" +
       "RfJd1sXJ6fyvAeHC2fxAXsXn6Xz3x6V7TvKBqnYnp7M8GJduA1ny04f8Y99z" +
       "arPubh96tnNLj53Smt1j+IdeqjuuFzn9yog8PChecHT8vDfZveLoSPm5Fyj6" +
       "e79W/6ndKysUW95u81qugJF89/aM/Uh+ekft2dqO67qz/8zf3v/zd7/l+Pn2" +
       "/TvAJxp8CtsT578TgnD8uHiLw/bfPvqvv/1fvvCHxW7l/w+TD/SweUoAAA==");
}
