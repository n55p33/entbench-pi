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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "VvxfmJtGsrYfAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "o+o88/8Cpc3Wna8qAAA=");
}
