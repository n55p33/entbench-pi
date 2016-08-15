package org.apache.batik.bridge;
public class CSSFontFace extends org.apache.batik.bridge.FontFace implements org.apache.batik.util.SVGConstants {
    org.apache.batik.gvt.font.GVTFontFamily fontFamily = null;
    public CSSFontFace(java.util.List srcs, java.lang.String familyName, float unitsPerEm,
                       java.lang.String fontWeight,
                       java.lang.String fontStyle,
                       java.lang.String fontVariant,
                       java.lang.String fontStretch,
                       float slope,
                       java.lang.String panose1,
                       float ascent,
                       float descent,
                       float strikethroughPosition,
                       float strikethroughThickness,
                       float underlinePosition,
                       float underlineThickness,
                       float overlinePosition,
                       float overlineThickness) { super(srcs, familyName,
                                                        unitsPerEm,
                                                        fontWeight,
                                                        fontStyle,
                                                        fontVariant,
                                                        fontStretch,
                                                        slope,
                                                        panose1,
                                                        ascent,
                                                        descent,
                                                        strikethroughPosition,
                                                        strikethroughThickness,
                                                        underlinePosition,
                                                        underlineThickness,
                                                        overlinePosition,
                                                        overlineThickness);
    }
    protected CSSFontFace(java.lang.String familyName) { super(familyName);
    }
    public static org.apache.batik.bridge.CSSFontFace createCSSFontFace(org.apache.batik.css.engine.CSSEngine eng,
                                                                        org.apache.batik.css.engine.FontFaceRule ffr) {
        org.apache.batik.css.engine.StyleMap sm =
          ffr.
          getStyleMap(
            );
        java.lang.String familyName =
          getStringProp(
            sm,
            eng,
            org.apache.batik.css.engine.SVGCSSEngine.
              FONT_FAMILY_INDEX);
        org.apache.batik.bridge.CSSFontFace ret =
          new org.apache.batik.bridge.CSSFontFace(
          familyName);
        org.apache.batik.css.engine.value.Value v;
        v =
          sm.
            getValue(
              org.apache.batik.css.engine.SVGCSSEngine.
                FONT_WEIGHT_INDEX);
        if (v !=
              null)
            ret.
              fontWeight =
              v.
                getCssText(
                  );
        v =
          sm.
            getValue(
              org.apache.batik.css.engine.SVGCSSEngine.
                FONT_STYLE_INDEX);
        if (v !=
              null)
            ret.
              fontStyle =
              v.
                getCssText(
                  );
        v =
          sm.
            getValue(
              org.apache.batik.css.engine.SVGCSSEngine.
                FONT_VARIANT_INDEX);
        if (v !=
              null)
            ret.
              fontVariant =
              v.
                getCssText(
                  );
        v =
          sm.
            getValue(
              org.apache.batik.css.engine.SVGCSSEngine.
                FONT_STRETCH_INDEX);
        if (v !=
              null)
            ret.
              fontStretch =
              v.
                getCssText(
                  );
        v =
          sm.
            getValue(
              org.apache.batik.css.engine.SVGCSSEngine.
                SRC_INDEX);
        org.apache.batik.util.ParsedURL base =
          ffr.
          getURL(
            );
        if (v !=
              null &&
              v !=
              org.apache.batik.css.engine.value.ValueConstants.
                NONE_VALUE) {
            if (v.
                  getCssValueType(
                    ) ==
                  org.w3c.dom.css.CSSValue.
                    CSS_PRIMITIVE_VALUE) {
                ret.
                  srcs =
                  new java.util.LinkedList(
                    );
                ret.
                  srcs.
                  add(
                    getSrcValue(
                      v,
                      base));
            }
            else
                if (v.
                      getCssValueType(
                        ) ==
                      org.w3c.dom.css.CSSValue.
                        CSS_VALUE_LIST) {
                    ret.
                      srcs =
                      new java.util.LinkedList(
                        );
                    for (int i =
                           0;
                         i <
                           v.
                           getLength(
                             );
                         i++) {
                        ret.
                          srcs.
                          add(
                            getSrcValue(
                              v.
                                item(
                                  i),
                              base));
                    }
                }
        }
        return ret;
    }
    public static java.lang.Object getSrcValue(org.apache.batik.css.engine.value.Value v,
                                               org.apache.batik.util.ParsedURL base) {
        if (v.
              getCssValueType(
                ) !=
              org.w3c.dom.css.CSSValue.
                CSS_PRIMITIVE_VALUE)
            return null;
        if (v.
              getPrimitiveType(
                ) ==
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_URI) {
            if (base !=
                  null)
                return new org.apache.batik.util.ParsedURL(
                  base,
                  v.
                    getStringValue(
                      ));
            return new org.apache.batik.util.ParsedURL(
              v.
                getStringValue(
                  ));
        }
        if (v.
              getPrimitiveType(
                ) ==
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_STRING)
            return v.
              getStringValue(
                );
        return null;
    }
    public static java.lang.String getStringProp(org.apache.batik.css.engine.StyleMap sm,
                                                 org.apache.batik.css.engine.CSSEngine eng,
                                                 int pidx) {
        org.apache.batik.css.engine.value.Value v =
          sm.
          getValue(
            pidx);
        org.apache.batik.css.engine.value.ValueManager[] vms =
          eng.
          getValueManagers(
            );
        if (v ==
              null) {
            org.apache.batik.css.engine.value.ValueManager vm =
              vms[pidx];
            v =
              vm.
                getDefaultValue(
                  );
        }
        while (v.
                 getCssValueType(
                   ) ==
                 org.w3c.dom.css.CSSValue.
                   CSS_VALUE_LIST) {
            v =
              v.
                item(
                  0);
        }
        return v.
          getStringValue(
            );
    }
    public static float getFloatProp(org.apache.batik.css.engine.StyleMap sm,
                                     org.apache.batik.css.engine.CSSEngine eng,
                                     int pidx) {
        org.apache.batik.css.engine.value.Value v =
          sm.
          getValue(
            pidx);
        org.apache.batik.css.engine.value.ValueManager[] vms =
          eng.
          getValueManagers(
            );
        if (v ==
              null) {
            org.apache.batik.css.engine.value.ValueManager vm =
              vms[pidx];
            v =
              vm.
                getDefaultValue(
                  );
        }
        while (v.
                 getCssValueType(
                   ) ==
                 org.w3c.dom.css.CSSValue.
                   CSS_VALUE_LIST) {
            v =
              v.
                item(
                  0);
        }
        return v.
          getFloatValue(
            );
    }
    public org.apache.batik.gvt.font.GVTFontFamily getFontFamily(org.apache.batik.bridge.BridgeContext ctx) {
        if (fontFamily !=
              null)
            return fontFamily;
        fontFamily =
          super.
            getFontFamily(
              ctx);
        return fontFamily;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "CxWuXLlAIQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
