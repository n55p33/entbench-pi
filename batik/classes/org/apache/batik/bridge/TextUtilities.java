package org.apache.batik.bridge;
public abstract class TextUtilities implements org.apache.batik.util.CSSConstants, org.apache.batik.bridge.ErrorConstants {
    public static java.lang.String getElementContent(org.w3c.dom.Element e) {
        java.lang.StringBuffer result =
          new java.lang.StringBuffer(
          );
        for (org.w3c.dom.Node n =
               e.
               getFirstChild(
                 );
             n !=
               null;
             n =
               n.
                 getNextSibling(
                   )) {
            switch (n.
                      getNodeType(
                        )) {
                case org.w3c.dom.Node.
                       ELEMENT_NODE:
                    result.
                      append(
                        getElementContent(
                          (org.w3c.dom.Element)
                            n));
                    break;
                case org.w3c.dom.Node.
                       CDATA_SECTION_NODE:
                case org.w3c.dom.Node.
                       TEXT_NODE:
                    result.
                      append(
                        n.
                          getNodeValue(
                            ));
            }
        }
        return result.
          toString(
            );
    }
    public static java.util.ArrayList svgHorizontalCoordinateArrayToUserSpace(org.w3c.dom.Element element,
                                                                              java.lang.String attrName,
                                                                              java.lang.String valueStr,
                                                                              org.apache.batik.bridge.BridgeContext ctx) {
        org.apache.batik.parser.UnitProcessor.Context uctx =
          org.apache.batik.bridge.UnitProcessor.
          createContext(
            ctx,
            element);
        java.util.ArrayList values =
          new java.util.ArrayList(
          );
        java.util.StringTokenizer st =
          new java.util.StringTokenizer(
          valueStr,
          ", ",
          false);
        while (st.
                 hasMoreTokens(
                   )) {
            values.
              add(
                new java.lang.Float(
                  org.apache.batik.bridge.UnitProcessor.
                    svgHorizontalCoordinateToUserSpace(
                      st.
                        nextToken(
                          ),
                      attrName,
                      uctx)));
        }
        return values;
    }
    public static java.util.ArrayList svgVerticalCoordinateArrayToUserSpace(org.w3c.dom.Element element,
                                                                            java.lang.String attrName,
                                                                            java.lang.String valueStr,
                                                                            org.apache.batik.bridge.BridgeContext ctx) {
        org.apache.batik.parser.UnitProcessor.Context uctx =
          org.apache.batik.bridge.UnitProcessor.
          createContext(
            ctx,
            element);
        java.util.ArrayList values =
          new java.util.ArrayList(
          );
        java.util.StringTokenizer st =
          new java.util.StringTokenizer(
          valueStr,
          ", ",
          false);
        while (st.
                 hasMoreTokens(
                   )) {
            values.
              add(
                new java.lang.Float(
                  org.apache.batik.bridge.UnitProcessor.
                    svgVerticalCoordinateToUserSpace(
                      st.
                        nextToken(
                          ),
                      attrName,
                      uctx)));
        }
        return values;
    }
    public static java.util.ArrayList svgRotateArrayToFloats(org.w3c.dom.Element element,
                                                             java.lang.String attrName,
                                                             java.lang.String valueStr,
                                                             org.apache.batik.bridge.BridgeContext ctx) {
        java.util.StringTokenizer st =
          new java.util.StringTokenizer(
          valueStr,
          ", ",
          false);
        java.util.ArrayList values =
          new java.util.ArrayList(
          );
        java.lang.String s;
        while (st.
                 hasMoreTokens(
                   )) {
            try {
                s =
                  st.
                    nextToken(
                      );
                values.
                  add(
                    new java.lang.Float(
                      java.lang.Math.
                        toRadians(
                          org.apache.batik.bridge.SVGUtilities.
                            convertSVGNumber(
                              s))));
            }
            catch (java.lang.NumberFormatException nfEx) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  element,
                  nfEx,
                  ERR_ATTRIBUTE_VALUE_MALFORMED,
                  new java.lang.Object[] { attrName,
                  valueStr });
            }
        }
        return values;
    }
    public static java.lang.Float convertFontSize(org.w3c.dom.Element e) {
        org.apache.batik.css.engine.value.Value v =
          org.apache.batik.bridge.CSSUtilities.
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              FONT_SIZE_INDEX);
        return new java.lang.Float(
          v.
            getFloatValue(
              ));
    }
    public static java.lang.Float convertFontStyle(org.w3c.dom.Element e) {
        org.apache.batik.css.engine.value.Value v =
          org.apache.batik.bridge.CSSUtilities.
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              FONT_STYLE_INDEX);
        switch (v.
                  getStringValue(
                    ).
                  charAt(
                    0)) {
            case 'n':
                return java.awt.font.TextAttribute.
                         POSTURE_REGULAR;
            default:
                return java.awt.font.TextAttribute.
                         POSTURE_OBLIQUE;
        }
    }
    public static java.lang.Float convertFontStretch(org.w3c.dom.Element e) {
        org.apache.batik.css.engine.value.Value v =
          org.apache.batik.bridge.CSSUtilities.
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              FONT_STRETCH_INDEX);
        java.lang.String s =
          v.
          getStringValue(
            );
        switch (s.
                  charAt(
                    0)) {
            case 'u':
                if (s.
                      charAt(
                        6) ==
                      'c') {
                    return java.awt.font.TextAttribute.
                             WIDTH_CONDENSED;
                }
                else {
                    return java.awt.font.TextAttribute.
                             WIDTH_EXTENDED;
                }
            case 'e':
                if (s.
                      charAt(
                        6) ==
                      'c') {
                    return java.awt.font.TextAttribute.
                             WIDTH_CONDENSED;
                }
                else {
                    if (s.
                          length(
                            ) ==
                          8) {
                        return java.awt.font.TextAttribute.
                                 WIDTH_SEMI_EXTENDED;
                    }
                    else {
                        return java.awt.font.TextAttribute.
                                 WIDTH_EXTENDED;
                    }
                }
            case 's':
                if (s.
                      charAt(
                        6) ==
                      'c') {
                    return java.awt.font.TextAttribute.
                             WIDTH_SEMI_CONDENSED;
                }
                else {
                    return java.awt.font.TextAttribute.
                             WIDTH_SEMI_EXTENDED;
                }
            default:
                return java.awt.font.TextAttribute.
                         WIDTH_REGULAR;
        }
    }
    public static java.lang.Float convertFontWeight(org.w3c.dom.Element e) {
        org.apache.batik.css.engine.value.Value v =
          org.apache.batik.bridge.CSSUtilities.
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              FONT_WEIGHT_INDEX);
        float f =
          v.
          getFloatValue(
            );
        switch ((int)
                  f) {
            case 100:
                return java.awt.font.TextAttribute.
                         WEIGHT_EXTRA_LIGHT;
            case 200:
                return java.awt.font.TextAttribute.
                         WEIGHT_LIGHT;
            case 300:
                return java.awt.font.TextAttribute.
                         WEIGHT_DEMILIGHT;
            case 400:
                return java.awt.font.TextAttribute.
                         WEIGHT_REGULAR;
            case 500:
                return java.awt.font.TextAttribute.
                         WEIGHT_SEMIBOLD;
            default:
                return java.awt.font.TextAttribute.
                         WEIGHT_BOLD;
        }
    }
    public static org.apache.batik.gvt.TextNode.Anchor convertTextAnchor(org.w3c.dom.Element e) {
        org.apache.batik.css.engine.value.Value v =
          org.apache.batik.bridge.CSSUtilities.
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              TEXT_ANCHOR_INDEX);
        switch (v.
                  getStringValue(
                    ).
                  charAt(
                    0)) {
            case 's':
                return org.apache.batik.gvt.TextNode.Anchor.
                         START;
            case 'm':
                return org.apache.batik.gvt.TextNode.Anchor.
                         MIDDLE;
            default:
                return org.apache.batik.gvt.TextNode.Anchor.
                         END;
        }
    }
    public static java.lang.Object convertBaselineShift(org.w3c.dom.Element e) {
        org.apache.batik.css.engine.value.Value v =
          org.apache.batik.bridge.CSSUtilities.
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              BASELINE_SHIFT_INDEX);
        if (v.
              getPrimitiveType(
                ) ==
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_IDENT) {
            java.lang.String s =
              v.
              getStringValue(
                );
            switch (s.
                      charAt(
                        2)) {
                case 'p':
                    return java.awt.font.TextAttribute.
                             SUPERSCRIPT_SUPER;
                case 'b':
                    return java.awt.font.TextAttribute.
                             SUPERSCRIPT_SUB;
                default:
                    return null;
            }
        }
        else {
            return new java.lang.Float(
              v.
                getFloatValue(
                  ));
        }
    }
    public static java.lang.Float convertKerning(org.w3c.dom.Element e) {
        org.apache.batik.css.engine.value.Value v =
          org.apache.batik.bridge.CSSUtilities.
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              KERNING_INDEX);
        if (v.
              getPrimitiveType(
                ) ==
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_IDENT) {
            return null;
        }
        return new java.lang.Float(
          v.
            getFloatValue(
              ));
    }
    public static java.lang.Float convertLetterSpacing(org.w3c.dom.Element e) {
        org.apache.batik.css.engine.value.Value v =
          org.apache.batik.bridge.CSSUtilities.
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              LETTER_SPACING_INDEX);
        if (v.
              getPrimitiveType(
                ) ==
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_IDENT) {
            return null;
        }
        return new java.lang.Float(
          v.
            getFloatValue(
              ));
    }
    public static java.lang.Float convertWordSpacing(org.w3c.dom.Element e) {
        org.apache.batik.css.engine.value.Value v =
          org.apache.batik.bridge.CSSUtilities.
          getComputedStyle(
            e,
            org.apache.batik.css.engine.SVGCSSEngine.
              WORD_SPACING_INDEX);
        if (v.
              getPrimitiveType(
                ) ==
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_IDENT) {
            return null;
        }
        return new java.lang.Float(
          v.
            getFloatValue(
              ));
    }
    public TextUtilities() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "+Su+Rf4H3ST2qnMlAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "bnjkm2nzaMjJY4T591Nx7v1wqSCe7D/T");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("PvsqOfr+bzQ+vTvGKNtiluVc7qWge3YnKgum+XLDu27J7ZDX3fi1Nx76tfue" +
       "PfwSe2gn8LFLnpDt6ZufE+w7flR8fWX/6q3/8js/8+pfF6eL/h+r4c3xkDAA" +
       "AA==");
}
