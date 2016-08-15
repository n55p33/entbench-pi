package org.apache.batik.gvt.font;
public class FontFamilyResolver {
    public static final org.apache.batik.gvt.font.AWTFontFamily defaultFont =
      new org.apache.batik.gvt.font.AWTFontFamily(
      "SansSerif");
    protected static final java.util.Map fonts = new java.util.HashMap();
    protected static final java.util.List awtFontFamilies = new java.util.ArrayList(
      );
    protected static final java.util.List awtFonts = new java.util.ArrayList(
      );
    static { fonts.put("sans-serif", "SansSerif");
             fonts.put("serif", "Serif");
             fonts.put("times", "Serif");
             fonts.put("times new roman", "Serif");
             fonts.put("cursive", "Dialog");
             fonts.put("fantasy", "Symbol");
             fonts.put("monospace", "Monospaced");
             fonts.put("monospaced", "Monospaced");
             fonts.put("courier", "Monospaced");
             java.awt.GraphicsEnvironment env;
             env = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment(
                                                  );
             java.lang.String[] fontNames = env.getAvailableFontFamilyNames(
                                                  );
             int nFonts = fontNames != null ? fontNames.length : 0;
             for (int i = 0; i < nFonts; i++) { fonts.put(fontNames[i].
                                                            toLowerCase(
                                                              ),
                                                          fontNames[i]);
                                                java.util.StringTokenizer st =
                                                  new java.util.StringTokenizer(
                                                  fontNames[i]);
                                                java.lang.String fontNameWithoutSpaces =
                                                  "";
                                                while (st.
                                                         hasMoreTokens(
                                                           )) {
                                                    fontNameWithoutSpaces +=
                                                      st.
                                                        nextToken(
                                                          );
                                                }
                                                fonts.put(
                                                        fontNameWithoutSpaces.
                                                          toLowerCase(
                                                            ),
                                                        fontNames[i]);
                                                java.lang.String fontNameWithDashes =
                                                  fontNames[i].
                                                  replace(
                                                    ' ',
                                                    '-');
                                                if (!fontNameWithDashes.
                                                      equals(
                                                        fontNames[i])) {
                                                    fonts.
                                                      put(
                                                        fontNameWithDashes.
                                                          toLowerCase(
                                                            ),
                                                        fontNames[i]);
                                                }
             }
             awtFontFamilies.add(defaultFont);
             awtFonts.add(new org.apache.batik.gvt.font.AWTGVTFont(
                            defaultFont.
                              getFamilyName(
                                ),
                            0,
                            12));
             java.util.Collection fontValues = fonts.
               values(
                 );
             java.util.Iterator iter = fontValues.
               iterator(
                 );
             while (iter.hasNext()) { java.lang.String fontFamily =
                                        (java.lang.String)
                                          iter.
                                          next(
                                            );
                                      org.apache.batik.gvt.font.AWTFontFamily awtFontFamily =
                                        new org.apache.batik.gvt.font.AWTFontFamily(
                                        fontFamily);
                                      awtFontFamilies.
                                        add(
                                          awtFontFamily);
                                      org.apache.batik.gvt.font.AWTGVTFont font =
                                        new org.apache.batik.gvt.font.AWTGVTFont(
                                        fontFamily,
                                        0,
                                        12);
                                      awtFonts.
                                        add(
                                          font);
             } }
    protected static final java.util.Map resolvedFontFamilies =
      new java.util.HashMap(
      );
    public static java.lang.String lookup(java.lang.String familyName) {
        return (java.lang.String)
                 fonts.
                 get(
                   familyName.
                     toLowerCase(
                       ));
    }
    public static org.apache.batik.gvt.font.GVTFontFamily resolve(java.lang.String familyName) {
        familyName =
          familyName.
            toLowerCase(
              );
        org.apache.batik.gvt.font.GVTFontFamily resolvedFF =
          (org.apache.batik.gvt.font.GVTFontFamily)
            resolvedFontFamilies.
            get(
              familyName);
        if (resolvedFF ==
              null) {
            java.lang.String awtFamilyName =
              (java.lang.String)
                fonts.
                get(
                  familyName);
            if (awtFamilyName !=
                  null) {
                resolvedFF =
                  new org.apache.batik.gvt.font.AWTFontFamily(
                    awtFamilyName);
            }
            resolvedFontFamilies.
              put(
                familyName,
                resolvedFF);
        }
        return resolvedFF;
    }
    public static org.apache.batik.gvt.font.GVTFontFamily resolve(org.apache.batik.gvt.font.UnresolvedFontFamily fontFamily) {
        return resolve(
                 fontFamily.
                   getFamilyName(
                     ));
    }
    public static org.apache.batik.gvt.font.GVTFontFamily getFamilyThatCanDisplay(char c) {
        for (int i =
               0;
             i <
               awtFontFamilies.
               size(
                 );
             i++) {
            org.apache.batik.gvt.font.AWTFontFamily fontFamily =
              (org.apache.batik.gvt.font.AWTFontFamily)
                awtFontFamilies.
                get(
                  i);
            org.apache.batik.gvt.font.AWTGVTFont font =
              (org.apache.batik.gvt.font.AWTGVTFont)
                awtFonts.
                get(
                  i);
            if (font.
                  canDisplay(
                    c) &&
                  fontFamily.
                  getFamilyName(
                    ).
                  indexOf(
                    "Song") ==
                  -1) {
                return fontFamily;
            }
        }
        return null;
    }
    public FontFamilyResolver() { super();
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "n+XA816okr+yt6r/At2/XLk6IQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "JCsAAA==");
}
