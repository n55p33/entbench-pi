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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "tmq8N9/vHReh4d7Hb/Fuz/8BkcvmSIk9AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "7PS3UegSc6Lft8cTMLRPm/P6YtkDdu8K");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "kcqykHlKAAA=");
}
