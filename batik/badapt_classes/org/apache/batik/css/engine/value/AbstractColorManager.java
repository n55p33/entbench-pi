package org.apache.batik.css.engine.value;
public abstract class AbstractColorManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_AQUA_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          AQUA_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_BLACK_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          BLACK_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_BLUE_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          BLUE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_FUCHSIA_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          FUCHSIA_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_GRAY_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          GRAY_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_GREEN_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          GREEN_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_LIME_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          LIME_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_MAROON_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          MAROON_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_NAVY_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          NAVY_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_OLIVE_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          OLIVE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_PURPLE_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          PURPLE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_RED_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          RED_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_SILVER_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          SILVER_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_TEAL_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          TEAL_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_WHITE_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          WHITE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_YELLOW_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          YELLOW_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_ACTIVEBORDER_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          ACTIVEBORDER_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_ACTIVECAPTION_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          ACTIVECAPTION_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_APPWORKSPACE_VALUE, org.apache.batik.css.engine.value.ValueConstants.
                                                    APPWORKSPACE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_BACKGROUND_VALUE, org.apache.batik.css.engine.value.ValueConstants.
                                                  BACKGROUND_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_BUTTONFACE_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          BUTTONFACE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_BUTTONHIGHLIGHT_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          BUTTONHIGHLIGHT_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_BUTTONSHADOW_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          BUTTONSHADOW_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_BUTTONTEXT_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          BUTTONTEXT_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_CAPTIONTEXT_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          CAPTIONTEXT_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_GRAYTEXT_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          GRAYTEXT_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_HIGHLIGHT_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          HIGHLIGHT_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_HIGHLIGHTTEXT_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          HIGHLIGHTTEXT_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_INACTIVEBORDER_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          INACTIVEBORDER_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_INACTIVECAPTION_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          INACTIVECAPTION_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_INACTIVECAPTIONTEXT_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          INACTIVECAPTIONTEXT_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_INFOBACKGROUND_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          INFOBACKGROUND_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_INFOTEXT_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          INFOTEXT_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_MENU_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          MENU_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_MENUTEXT_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          MENUTEXT_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_SCROLLBAR_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          SCROLLBAR_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_THREEDDARKSHADOW_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          THREEDDARKSHADOW_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_THREEDFACE_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          THREEDFACE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_THREEDHIGHLIGHT_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          THREEDHIGHLIGHT_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_THREEDLIGHTSHADOW_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          THREEDLIGHTSHADOW_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_THREEDSHADOW_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          THREEDSHADOW_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_WINDOW_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          WINDOW_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_WINDOWFRAME_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          WINDOWFRAME_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_WINDOWTEXT_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          WINDOWTEXT_VALUE);
    }
    protected static final org.apache.batik.css.engine.value.StringMap
      computedValues =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { computedValues.put(org.apache.batik.util.CSSConstants.
                                  CSS_BLACK_VALUE,
                                org.apache.batik.css.engine.value.ValueConstants.
                                  BLACK_RGB_VALUE);
             computedValues.put(org.apache.batik.util.CSSConstants.
                                  CSS_SILVER_VALUE,
                                org.apache.batik.css.engine.value.ValueConstants.
                                  SILVER_RGB_VALUE);
             computedValues.put(org.apache.batik.util.CSSConstants.
                                  CSS_GRAY_VALUE,
                                org.apache.batik.css.engine.value.ValueConstants.
                                  GRAY_RGB_VALUE);
             computedValues.put(org.apache.batik.util.CSSConstants.
                                  CSS_WHITE_VALUE,
                                org.apache.batik.css.engine.value.ValueConstants.
                                  WHITE_RGB_VALUE);
             computedValues.put(org.apache.batik.util.CSSConstants.
                                  CSS_MAROON_VALUE,
                                org.apache.batik.css.engine.value.ValueConstants.
                                  MAROON_RGB_VALUE);
             computedValues.put(org.apache.batik.util.CSSConstants.
                                  CSS_RED_VALUE,
                                org.apache.batik.css.engine.value.ValueConstants.
                                  RED_RGB_VALUE);
             computedValues.put(org.apache.batik.util.CSSConstants.
                                  CSS_PURPLE_VALUE,
                                org.apache.batik.css.engine.value.ValueConstants.
                                  PURPLE_RGB_VALUE);
             computedValues.put(org.apache.batik.util.CSSConstants.
                                  CSS_FUCHSIA_VALUE,
                                org.apache.batik.css.engine.value.ValueConstants.
                                  FUCHSIA_RGB_VALUE);
             computedValues.put(org.apache.batik.util.CSSConstants.
                                  CSS_GREEN_VALUE,
                                org.apache.batik.css.engine.value.ValueConstants.
                                  GREEN_RGB_VALUE);
             computedValues.put(org.apache.batik.util.CSSConstants.
                                  CSS_LIME_VALUE,
                                org.apache.batik.css.engine.value.ValueConstants.
                                  LIME_RGB_VALUE);
             computedValues.put(org.apache.batik.util.CSSConstants.
                                  CSS_OLIVE_VALUE,
                                org.apache.batik.css.engine.value.ValueConstants.
                                  OLIVE_RGB_VALUE);
             computedValues.put(org.apache.batik.util.CSSConstants.
                                  CSS_YELLOW_VALUE,
                                org.apache.batik.css.engine.value.ValueConstants.
                                  YELLOW_RGB_VALUE);
             computedValues.put(org.apache.batik.util.CSSConstants.
                                  CSS_NAVY_VALUE,
                                org.apache.batik.css.engine.value.ValueConstants.
                                  NAVY_RGB_VALUE);
             computedValues.put(org.apache.batik.util.CSSConstants.
                                  CSS_BLUE_VALUE,
                                org.apache.batik.css.engine.value.ValueConstants.
                                  BLUE_RGB_VALUE);
             computedValues.put(org.apache.batik.util.CSSConstants.
                                  CSS_TEAL_VALUE,
                                org.apache.batik.css.engine.value.ValueConstants.
                                  TEAL_RGB_VALUE);
             computedValues.put(org.apache.batik.util.CSSConstants.
                                  CSS_AQUA_VALUE,
                                org.apache.batik.css.engine.value.ValueConstants.
                                  AQUA_RGB_VALUE);
    }
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException {
        if (lu.
              getLexicalUnitType(
                ) ==
              org.w3c.css.sac.LexicalUnit.
                SAC_RGBCOLOR) {
            lu =
              lu.
                getParameters(
                  );
            org.apache.batik.css.engine.value.Value red =
              createColorComponent(
                lu);
            lu =
              lu.
                getNextLexicalUnit(
                  ).
                getNextLexicalUnit(
                  );
            org.apache.batik.css.engine.value.Value green =
              createColorComponent(
                lu);
            lu =
              lu.
                getNextLexicalUnit(
                  ).
                getNextLexicalUnit(
                  );
            org.apache.batik.css.engine.value.Value blue =
              createColorComponent(
                lu);
            return createRGBColor(
                     red,
                     green,
                     blue);
        }
        return super.
          createValue(
            lu,
            engine);
    }
    public org.apache.batik.css.engine.value.Value computeValue(org.apache.batik.css.engine.CSSStylableElement elt,
                                                                java.lang.String pseudo,
                                                                org.apache.batik.css.engine.CSSEngine engine,
                                                                int idx,
                                                                org.apache.batik.css.engine.StyleMap sm,
                                                                org.apache.batik.css.engine.value.Value value) {
        if (value.
              getPrimitiveType(
                ) ==
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_IDENT) {
            java.lang.String ident =
              value.
              getStringValue(
                );
            org.apache.batik.css.engine.value.Value v =
              (org.apache.batik.css.engine.value.Value)
                computedValues.
                get(
                  ident);
            if (v !=
                  null) {
                return v;
            }
            if (values.
                  get(
                    ident) ==
                  null) {
                throw new java.lang.IllegalStateException(
                  "Not a system-color:" +
                  ident);
            }
            return engine.
              getCSSContext(
                ).
              getSystemColor(
                ident);
        }
        return super.
          computeValue(
            elt,
            pseudo,
            engine,
            idx,
            sm,
            value);
    }
    protected org.apache.batik.css.engine.value.Value createRGBColor(org.apache.batik.css.engine.value.Value r,
                                                                     org.apache.batik.css.engine.value.Value g,
                                                                     org.apache.batik.css.engine.value.Value b) {
        return new org.apache.batik.css.engine.value.RGBColorValue(
          r,
          g,
          b);
    }
    protected org.apache.batik.css.engine.value.Value createColorComponent(org.w3c.css.sac.LexicalUnit lu)
          throws org.w3c.dom.DOMException {
        switch (lu.
                  getLexicalUnitType(
                    )) {
            case org.w3c.css.sac.LexicalUnit.
                   SAC_INTEGER:
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_NUMBER,
                  lu.
                    getIntegerValue(
                      ));
            case org.w3c.css.sac.LexicalUnit.
                   SAC_REAL:
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_NUMBER,
                  lu.
                    getFloatValue(
                      ));
            case org.w3c.css.sac.LexicalUnit.
                   SAC_PERCENTAGE:
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_PERCENTAGE,
                  lu.
                    getFloatValue(
                      ));
        }
        throw createInvalidRGBComponentUnitDOMException(
                lu.
                  getLexicalUnitType(
                    ));
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    private org.w3c.dom.DOMException createInvalidRGBComponentUnitDOMException(short type) {
        java.lang.Object[] p =
          new java.lang.Object[] { getPropertyName(
                                     ),
        new java.lang.Integer(
          type) };
        java.lang.String s =
          org.apache.batik.css.engine.value.Messages.
          formatMessage(
            "invalid.rgb.component.unit",
            p);
        return new org.w3c.dom.DOMException(
          org.w3c.dom.DOMException.
            NOT_SUPPORTED_ERR,
          s);
    }
    public AbstractColorManager() { super(
                                      ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "/RfkF6eoth8AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/2F1nvl/ARbLrCWvKgAA");
}
