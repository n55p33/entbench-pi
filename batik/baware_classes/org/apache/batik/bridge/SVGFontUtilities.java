package org.apache.batik.bridge;
public abstract class SVGFontUtilities implements org.apache.batik.util.SVGConstants {
    public static java.util.List getFontFaces(org.w3c.dom.Document doc, org.apache.batik.bridge.BridgeContext ctx) {
        java.util.Map fontFamilyMap =
          ctx.
          getFontFamilyMap(
            );
        java.util.List ret =
          (java.util.List)
            fontFamilyMap.
            get(
              doc);
        if (ret !=
              null)
            return ret;
        ret =
          new java.util.LinkedList(
            );
        org.w3c.dom.NodeList fontFaceElements =
          doc.
          getElementsByTagNameNS(
            SVG_NAMESPACE_URI,
            SVG_FONT_FACE_TAG);
        org.apache.batik.bridge.SVGFontFaceElementBridge fontFaceBridge;
        fontFaceBridge =
          (org.apache.batik.bridge.SVGFontFaceElementBridge)
            ctx.
            getBridge(
              SVG_NAMESPACE_URI,
              SVG_FONT_FACE_TAG);
        for (int i =
               0;
             i <
               fontFaceElements.
               getLength(
                 );
             i++) {
            org.w3c.dom.Element fontFaceElement =
              (org.w3c.dom.Element)
                fontFaceElements.
                item(
                  i);
            ret.
              add(
                fontFaceBridge.
                  createFontFace(
                    ctx,
                    fontFaceElement));
        }
        org.apache.batik.css.engine.CSSEngine engine =
          ((org.apache.batik.dom.svg.SVGOMDocument)
             doc).
          getCSSEngine(
            );
        java.util.List sms =
          engine.
          getFontFaces(
            );
        java.util.Iterator iter =
          sms.
          iterator(
            );
        while (iter.
                 hasNext(
                   )) {
            org.apache.batik.css.engine.FontFaceRule ffr =
              (org.apache.batik.css.engine.FontFaceRule)
                iter.
                next(
                  );
            ret.
              add(
                org.apache.batik.bridge.CSSFontFace.
                  createCSSFontFace(
                    engine,
                    ffr));
        }
        return ret;
    }
    public static org.apache.batik.gvt.font.GVTFontFamily getFontFamily(org.w3c.dom.Element textElement,
                                                                        org.apache.batik.bridge.BridgeContext ctx,
                                                                        java.lang.String fontFamilyName,
                                                                        java.lang.String fontWeight,
                                                                        java.lang.String fontStyle) {
        java.lang.String fontKeyName =
          fontFamilyName.
          toLowerCase(
            ) +
        " " +
        fontWeight +
        " " +
        fontStyle;
        java.util.Map fontFamilyMap =
          ctx.
          getFontFamilyMap(
            );
        org.apache.batik.gvt.font.GVTFontFamily fontFamily =
          (org.apache.batik.gvt.font.GVTFontFamily)
            fontFamilyMap.
            get(
              fontKeyName);
        if (fontFamily !=
              null) {
            return fontFamily;
        }
        org.w3c.dom.Document doc =
          textElement.
          getOwnerDocument(
            );
        java.util.List fontFaces =
          (java.util.List)
            fontFamilyMap.
            get(
              doc);
        if (fontFaces ==
              null) {
            fontFaces =
              getFontFaces(
                doc,
                ctx);
            fontFamilyMap.
              put(
                doc,
                fontFaces);
        }
        java.util.Iterator iter =
          fontFaces.
          iterator(
            );
        java.util.List svgFontFamilies =
          new java.util.LinkedList(
          );
        while (iter.
                 hasNext(
                   )) {
            org.apache.batik.bridge.FontFace fontFace =
              (org.apache.batik.bridge.FontFace)
                iter.
                next(
                  );
            if (!fontFace.
                  hasFamilyName(
                    fontFamilyName)) {
                continue;
            }
            java.lang.String fontFaceStyle =
              fontFace.
              getFontStyle(
                );
            if (fontFaceStyle.
                  equals(
                    SVG_ALL_VALUE) ||
                  fontFaceStyle.
                  indexOf(
                    fontStyle) !=
                  -1) {
                org.apache.batik.gvt.font.GVTFontFamily ffam =
                  fontFace.
                  getFontFamily(
                    ctx);
                if (ffam !=
                      null)
                    svgFontFamilies.
                      add(
                        ffam);
            }
        }
        if (svgFontFamilies.
              size(
                ) ==
              1) {
            fontFamilyMap.
              put(
                fontKeyName,
                svgFontFamilies.
                  get(
                    0));
            return (org.apache.batik.gvt.font.GVTFontFamily)
                     svgFontFamilies.
                     get(
                       0);
        }
        else
            if (svgFontFamilies.
                  size(
                    ) >
                  1) {
                java.lang.String fontWeightNumber =
                  getFontWeightNumberString(
                    fontWeight);
                java.util.List fontFamilyWeights =
                  new java.util.ArrayList(
                  svgFontFamilies.
                    size(
                      ));
                java.util.Iterator ffiter =
                  svgFontFamilies.
                  iterator(
                    );
                while (ffiter.
                         hasNext(
                           )) {
                    org.apache.batik.gvt.font.GVTFontFace fontFace;
                    fontFace =
                      ((org.apache.batik.gvt.font.GVTFontFamily)
                         ffiter.
                         next(
                           )).
                        getFontFace(
                          );
                    java.lang.String fontFaceWeight =
                      fontFace.
                      getFontWeight(
                        );
                    fontFaceWeight =
                      getFontWeightNumberString(
                        fontFaceWeight);
                    fontFamilyWeights.
                      add(
                        fontFaceWeight);
                }
                java.util.List newFontFamilyWeights =
                  new java.util.ArrayList(
                  fontFamilyWeights);
                for (int i =
                       100;
                     i <=
                       900;
                     i +=
                       100) {
                    java.lang.String weightString =
                      java.lang.String.
                      valueOf(
                        i);
                    boolean matched =
                      false;
                    int minDifference =
                      1000;
                    int minDifferenceIndex =
                      0;
                    for (int j =
                           0;
                         j <
                           fontFamilyWeights.
                           size(
                             );
                         j++) {
                        java.lang.String fontFamilyWeight =
                          (java.lang.String)
                            fontFamilyWeights.
                            get(
                              j);
                        if (fontFamilyWeight.
                              indexOf(
                                weightString) >
                              -1) {
                            matched =
                              true;
                            break;
                        }
                        java.util.StringTokenizer st =
                          new java.util.StringTokenizer(
                          fontFamilyWeight,
                          " ,");
                        while (st.
                                 hasMoreTokens(
                                   )) {
                            int weightNum =
                              java.lang.Integer.
                              parseInt(
                                st.
                                  nextToken(
                                    ));
                            int difference =
                              java.lang.Math.
                              abs(
                                weightNum -
                                  i);
                            if (difference <
                                  minDifference) {
                                minDifference =
                                  difference;
                                minDifferenceIndex =
                                  j;
                            }
                        }
                    }
                    if (!matched) {
                        java.lang.String newFontFamilyWeight =
                          newFontFamilyWeights.
                          get(
                            minDifferenceIndex) +
                        ", " +
                        weightString;
                        newFontFamilyWeights.
                          set(
                            minDifferenceIndex,
                            newFontFamilyWeight);
                    }
                }
                for (int i =
                       0;
                     i <
                       svgFontFamilies.
                       size(
                         );
                     i++) {
                    java.lang.String fontFaceWeight =
                      (java.lang.String)
                        newFontFamilyWeights.
                        get(
                          i);
                    if (fontFaceWeight.
                          indexOf(
                            fontWeightNumber) >
                          -1) {
                        fontFamilyMap.
                          put(
                            fontKeyName,
                            svgFontFamilies.
                              get(
                                i));
                        return (org.apache.batik.gvt.font.GVTFontFamily)
                                 svgFontFamilies.
                                 get(
                                   i);
                    }
                }
                fontFamilyMap.
                  put(
                    fontKeyName,
                    svgFontFamilies.
                      get(
                        0));
                return (org.apache.batik.gvt.font.GVTFontFamily)
                         svgFontFamilies.
                         get(
                           0);
            }
            else {
                org.apache.batik.gvt.font.GVTFontFamily gvtFontFamily =
                  new org.apache.batik.gvt.font.UnresolvedFontFamily(
                  fontFamilyName);
                fontFamilyMap.
                  put(
                    fontKeyName,
                    gvtFontFamily);
                return gvtFontFamily;
            }
    }
    protected static java.lang.String getFontWeightNumberString(java.lang.String fontWeight) {
        if (fontWeight.
              equals(
                SVG_NORMAL_VALUE)) {
            return SVG_400_VALUE;
        }
        else
            if (fontWeight.
                  equals(
                    SVG_BOLD_VALUE)) {
                return SVG_700_VALUE;
            }
            else
                if (fontWeight.
                      equals(
                        SVG_ALL_VALUE)) {
                    return "100, 200, 300, 400, 500, 600, 700, 800, 900";
                }
        return fontWeight;
    }
    public SVGFontUtilities() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "tBCdiGLxOf7Kmiv/AeW6ljdIGQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "xnB1udhchhsMEZICU4AbKr1aaCt9IlpUb5lGeH9DiP7Ir/iwA1KjepPuohrS" +
       "snh0wZpEIy1NJKsolpsEXg1qMOKh/nwtxLO0s0yVlCnMPaOPYNVNEgUDKoCH" +
       "pbZHDEYxuinhyKKCD7G4Rhlzn++yPbRpxLIooxMudnlugwfxFBuuywN9sAqx" +
       "il7DLb3GjRdDQauuxpV4nYzHnqFOuQRNNu3ZhExxZzRYDkdCs5Aka1cznLWP" +
       "K+MC0QpRA1H6CDrl52RBSTwcZhriLGCoYrU+DKS6FNmdslCtTupTatRzS7LJ" +
       "+fZqYgYtuVaczInWoKGiG3LYqXLAIYdFsjq3GzUTGbRwIMMGuSkoyrw3sTil" +
       "LNYnfnMj2NbCbk6LhklIZodcyH0TpHqqPBrMhrOOTw9NHiXKCcssUkTmJkPN" +
       "V6PWKGrJy6KhJ41xz+2b5oCIE9NW2E3UmE8qSZkLqeoa7y867Y7BLWIO70Yz" +
       "urAeVHC8iGCkQkYNLZ7WNxW7pmKBXKkKVFe1V6vQT8tiLEtx2+wuNG5FWDTr" +
       "pTNKmY6VFJ/3+gVdLttz3hC8eXmDLNyKUeZalSZVL6pwr+Lo7AYTJEVVBY+G" +
       "xZqE6yllCSV5RXZiyWsyVJcn6u2otiLlUkvt+pOqOJvVlHV5s1A3sTOn1TLT" +
       "tvs84rcnXb9WiAszzaooaI1EK7BqbUpex6Nn+npp23OiPHR8n5nDduhNeBQF" +
       "83CF4lOWQlNsILlOM4pUtCoTGjlcGJRcYqyizWPzdU2V5hu5hsCBORdrDUW3" +
       "SFZLJj2YqUzryyo5VbF+d2h0YKoquopoTatttKjUFJTZoLHRlpCmr5UnIDUU" +
       "Z2bBnG0ipIYvqPIcbosDWm5bE7o4NpnGiuqgYaHiRiWtMNfWphg6wTog+KEQ" +
       "9az5ujqRWcJQHLI0q6Qggio4P120YYJbLtRa2COwFq6r5mhgDguR3+PizaZN" +
       "VWQfN3i3Ho8HUWVeYsaltZeOu61g1JiOm5qDVXyvpnC1xsCEzZCsK0aLSQcL" +
       "nLaNGCFUvmKZSqc1JIjs9e0tL+0N+ra8WHDQvwEvztmN1kt4c0yvfODOXpHi" +
       "jCgFoS/KYXpQPc0/565RPT1SYTq1X7V4+LJyef4azE1bB1287K36vqu1d/I3" +
       "6o+++6lnlMHHijt7RTw+hG4KXe/1lhqr1om61muvXj3o5d2tw+LS59/9r/eM" +
       "36i//SWUzx84QedJlL/be/aLrVfJv74DXXdQarqs73Z808XjBaazvhpGvjM+" +
       "Vma670AJd2UyfwRcxT0lFK9cwr6GcnNr2hrSiULpzhZqX3cvz3SXYPKu4tq7" +
       "DVeObHWv6QpuPnq1PgiZf+21R/Nj4mvUY386G1YhdLOmhln7hMr6lsfKLMfV" +
       "OBKT3DYuyX80/MZXPrJ57tltFUUSAzWE4Kt1kS9vZGe9ikev0W857C9+v/WT" +
       "z3/rn6Zv3be+lx0o4/aMjTuvpYx9ad16tBy8LZ3/3KGf+j+qwnNUavmCc0DD" +
       "g9ni68Gl7dGg/R8axOkc6vQ+F3ccNYissw/sIbu1Pgg+2yHH9SvX0PqvZcOT" +
       "IXTLgdZtw1rvH/Pqy0xLi8PdBYDbbU3HJ+BzAf7SjyHAe7PFMri+uyfA774U" +
       "AYJI5PluqMqhqlxdjqe2QfFQOM9cQzi/lQ1Ph9Ar94TDq4amh9sK7GHlt3XI" +
       "/YdeCvdpCJ0/2arMei13X/Y3iG3rXv7UM+fO3PXM5G/ybt1Be/0mBjqziCzr" +
       "aGn8yPwGz1cXRs7OTdtCuZd/fTyE7rpK4AihG7aTnOTf3sJ/AlB7Ej6ETuff" +
       "R+E+GUJnD+EAqu3kKMinQ+g6AJJNf8+7QlF92yFITx15nuzZSi7k23+UkA+2" +
       "HG3mZXEl/xvK/vMiYvfC13PPdPvveKHysW0zUbbEzSbDcoaBbtz2NQ+eOQ9d" +
       "Fds+rhvaj71466dvenQ/Qt26JfjQbo/Q9sCVu3VN2wvz/trmD+/6zBs+/szX" +
       "8hr//wLzCk4CHyQAAA==");
}
