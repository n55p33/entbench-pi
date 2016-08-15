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
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "pYXoRBSLz/FX1lz5D4HkzHFIGQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ULOitSk3Su0lwNFpDQkie317y4t7g749LxYc9G/Ai3N2o/Ui3hzTqx+4s1ek" +
       "OCtKQeiLcpgeVE/zz/nrVE+PVJhO7VctHr6iXJ6/BnN866CLl71Vv+Ja7Z38" +
       "jfqj737qGWXwseLOXhFvGkI3h673OkuNVetEXes1164e9PLu1mFx6fPv/td7" +
       "x2/Q3/4iyucPnKDzJMrf7T37xdYr5V/fgW44KDVd0Xc7vunS8QLTOV8NI98Z" +
       "HyszveJACXdnMn8EXMU9JRSvXsK+jnJza9oa0olC6c4Wal93L810l2DyruLa" +
       "uw1Xjmx1r+kKbj56rT4ImX/ttUfzY+Lr1GPfmQ2rELpFU8OsfUJlfctjZZbj" +
       "ahyJSW4bl+U/Gn7jKx/ZPPfstooiiYEaQvC1ushXNrKzXsWj1+m3HPYXv9/6" +
       "6ee/9U/8W/et7yUHyrgjY+Ou6yljX1q3HS0Hb0vnP3/op/6Pq/AclVq+4BzQ" +
       "8GC2+DpwaXs0aP+HBnE6hzq9z8WdRw0i6+wDe8hurQ+Cz3bIcf3KdbT+a9nw" +
       "ZAjdeqB127DW+8e86grT0uJwdwHgdlv8+AR8LsBf+gkEeF+2WAbXd/cE+N0X" +
       "I0AQiTzfDVU5VJVry/HUNigeCueZ6wjnt7Lh6RB6+Z5wpqqh6eG2AntY+W0d" +
       "cv+hF8N9GkIXTrYqs17LPVf8DWLbupc/9cz5s3c/M/mbvFt30F6/mYHOLiLL" +
       "OloaPzI/4/nqwsjZuXlbKPfyr4+H0N3XCBwhdGY7yUn+7S38JwC1J+FD6HT+" +
       "fRTukyF07hAOoNpOjoJ8OoRuACDZ9Pe8qxTVtx2C9NSR58mereRCvuPHCflg" +
       "y9FmXhZX8r+h7D8vInYvfD33TLf/jhcqH9s2E2VL3GwyLGcZ6KZtX/PgmfPQ" +
       "NbHt4zrTfuyHt3365kf3I9RtW4IP7fYIbQ9cvVvXtL0w769t/vDuz7z+4898" +
       "La/x/y86sAN4HyQAAA==");
}
