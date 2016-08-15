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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "72c58LwXquSv7K3qv0H5xco6IQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "0QTYlEab3q6CZJq2qFqQoqNGpnhNYoJh5bbA37u/nZnHd5tQx5cj1narbPjw" +
       "fexI7JueL4v3Hu+97f6uQhefOJ46lYHKXZZ3XXTnYbfD8vmPvvSyyv5C5Whz" +
       "+u/E0MOx53+/raWafQrVgwDT+y/eTWJ2Vz5OTll+66P//enZD5ofuo9z5GfP" +
       "8Xke5S8xr/zO8HuVn7oMPXB85nLHZZSznW6dPWl5JNTiJHRnZ85b3nWs2Xcc" +
       "7du+eKjZF++2q3nj7lZw+cQK9gZw7sTw0v50dWcCO4BfvMeR4i+VxT+Ioau2" +
       "522SHfEPn5jMP3yjTazT6HYVf//seXV5pvSJQxk/8d2U8R/fQ8bXyuILMfTQ" +
       "4X7zX+AIarg4dQR1oo9X/yr08cVDfXzxr14fR5IdXCzZ3L1j1z3fofz1e2jw" +
       "N8riX5xosPz8tRO1fOkvq5YWeF47VMtr3yW1fOxUDPxkDD2omFK46/Rv7iH4" +
       "V8vid2PoSUM71NXMlOKu5PasyLel/Jwivnw/ishi6Ik7b96UVweeuuOG3/5W" +
       "mvKFl69fe/Ll+b/fXT45vjn2MA1d0xPbPn3Se+r9qh9qurUT5+H9ua+/+/lP" +
       "MfSOC+0EKEg/Oq39/T3812LorXeDj6EHQHka8r/E0I3zkDF0Zfd7Gu4PYuiR" +
       "EzgQhPYvp0H+EGAHIOXrN/27HKrsj8azS2dT0fGAPPFGA3Iqe73nTM7Z3cU8" +
       "yg8Jd3iS++rL5PjHvt38hf0tGsWWwFwIYLlGQw/tL/Qc55jnL8R2hOvq6IXv" +
       "PPbFh997lA8f2zN8Yu6neHv27tdU+o4f7y6WFP/0yX/yA7/48td2Zzz/H+iU" +
       "vAckKwAA");
}
