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
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "81d8i/wP7YCBE3MlAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "yMljhPn3U3Hu/XCpYMXtP9M+8yo1/IGv");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("Nz61O8aoOcp2m3O5l4bu2Z2oLJjmyw3vuCW3Q153k9e+8dAv3/fs4ZfYQzuB" +
       "j13yhGxP3/ycYNcNkuLra/sf3vzvv+vTr/5pcbronwCjHZ+SkDAAAA==");
}
