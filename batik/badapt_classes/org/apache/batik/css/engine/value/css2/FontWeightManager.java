package org.apache.batik.css.engine.value.css2;
public class FontWeightManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_ALL_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          ALL_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_BOLD_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          BOLD_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_BOLDER_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          BOLDER_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_LIGHTER_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          LIGHTER_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_NORMAL_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          NORMAL_VALUE); }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_FONT_WEIGHT_VALUE; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_FONT_WEIGHT_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.ValueConstants.
                 NORMAL_VALUE;
    }
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException {
        if (lu.
              getLexicalUnitType(
                ) ==
              org.w3c.css.sac.LexicalUnit.
                SAC_INTEGER) {
            int i =
              lu.
              getIntegerValue(
                );
            switch (i) {
                case 100:
                    return org.apache.batik.css.engine.value.ValueConstants.
                             NUMBER_100;
                case 200:
                    return org.apache.batik.css.engine.value.ValueConstants.
                             NUMBER_200;
                case 300:
                    return org.apache.batik.css.engine.value.ValueConstants.
                             NUMBER_300;
                case 400:
                    return org.apache.batik.css.engine.value.ValueConstants.
                             NUMBER_400;
                case 500:
                    return org.apache.batik.css.engine.value.ValueConstants.
                             NUMBER_500;
                case 600:
                    return org.apache.batik.css.engine.value.ValueConstants.
                             NUMBER_600;
                case 700:
                    return org.apache.batik.css.engine.value.ValueConstants.
                             NUMBER_700;
                case 800:
                    return org.apache.batik.css.engine.value.ValueConstants.
                             NUMBER_800;
                case 900:
                    return org.apache.batik.css.engine.value.ValueConstants.
                             NUMBER_900;
            }
            throw createInvalidFloatValueDOMException(
                    i);
        }
        return super.
          createValue(
            lu,
            engine);
    }
    public org.apache.batik.css.engine.value.Value createFloatValue(short type,
                                                                    float floatValue)
          throws org.w3c.dom.DOMException {
        if (type ==
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_NUMBER) {
            int i =
              (int)
                floatValue;
            if (floatValue ==
                  i) {
                switch (i) {
                    case 100:
                        return org.apache.batik.css.engine.value.ValueConstants.
                                 NUMBER_100;
                    case 200:
                        return org.apache.batik.css.engine.value.ValueConstants.
                                 NUMBER_200;
                    case 300:
                        return org.apache.batik.css.engine.value.ValueConstants.
                                 NUMBER_300;
                    case 400:
                        return org.apache.batik.css.engine.value.ValueConstants.
                                 NUMBER_400;
                    case 500:
                        return org.apache.batik.css.engine.value.ValueConstants.
                                 NUMBER_500;
                    case 600:
                        return org.apache.batik.css.engine.value.ValueConstants.
                                 NUMBER_600;
                    case 700:
                        return org.apache.batik.css.engine.value.ValueConstants.
                                 NUMBER_700;
                    case 800:
                        return org.apache.batik.css.engine.value.ValueConstants.
                                 NUMBER_800;
                    case 900:
                        return org.apache.batik.css.engine.value.ValueConstants.
                                 NUMBER_900;
                }
            }
        }
        throw createInvalidFloatValueDOMException(
                floatValue);
    }
    public org.apache.batik.css.engine.value.Value computeValue(org.apache.batik.css.engine.CSSStylableElement elt,
                                                                java.lang.String pseudo,
                                                                org.apache.batik.css.engine.CSSEngine engine,
                                                                int idx,
                                                                org.apache.batik.css.engine.StyleMap sm,
                                                                org.apache.batik.css.engine.value.Value value) {
        if (value ==
              org.apache.batik.css.engine.value.ValueConstants.
                BOLDER_VALUE) {
            sm.
              putParentRelative(
                idx,
                true);
            org.apache.batik.css.engine.CSSContext ctx =
              engine.
              getCSSContext(
                );
            org.apache.batik.css.engine.CSSStylableElement p =
              org.apache.batik.css.engine.CSSEngine.
              getParentCSSStylableElement(
                elt);
            float fw;
            if (p ==
                  null) {
                fw =
                  400;
            }
            else {
                org.apache.batik.css.engine.value.Value v =
                  engine.
                  getComputedStyle(
                    p,
                    pseudo,
                    idx);
                fw =
                  v.
                    getFloatValue(
                      );
            }
            return createFontWeight(
                     ctx.
                       getBolderFontWeight(
                         fw));
        }
        else
            if (value ==
                  org.apache.batik.css.engine.value.ValueConstants.
                    LIGHTER_VALUE) {
                sm.
                  putParentRelative(
                    idx,
                    true);
                org.apache.batik.css.engine.CSSContext ctx =
                  engine.
                  getCSSContext(
                    );
                org.apache.batik.css.engine.CSSStylableElement p =
                  org.apache.batik.css.engine.CSSEngine.
                  getParentCSSStylableElement(
                    elt);
                float fw;
                if (p ==
                      null) {
                    fw =
                      400;
                }
                else {
                    org.apache.batik.css.engine.value.Value v =
                      engine.
                      getComputedStyle(
                        p,
                        pseudo,
                        idx);
                    fw =
                      v.
                        getFloatValue(
                          );
                }
                return createFontWeight(
                         ctx.
                           getLighterFontWeight(
                             fw));
            }
            else
                if (value ==
                      org.apache.batik.css.engine.value.ValueConstants.
                        NORMAL_VALUE) {
                    return org.apache.batik.css.engine.value.ValueConstants.
                             NUMBER_400;
                }
                else
                    if (value ==
                          org.apache.batik.css.engine.value.ValueConstants.
                            BOLD_VALUE) {
                        return org.apache.batik.css.engine.value.ValueConstants.
                                 NUMBER_700;
                    }
        return value;
    }
    protected org.apache.batik.css.engine.value.Value createFontWeight(float f) {
        switch ((int)
                  f) {
            case 100:
                return org.apache.batik.css.engine.value.ValueConstants.
                         NUMBER_100;
            case 200:
                return org.apache.batik.css.engine.value.ValueConstants.
                         NUMBER_200;
            case 300:
                return org.apache.batik.css.engine.value.ValueConstants.
                         NUMBER_300;
            case 400:
                return org.apache.batik.css.engine.value.ValueConstants.
                         NUMBER_400;
            case 500:
                return org.apache.batik.css.engine.value.ValueConstants.
                         NUMBER_500;
            case 600:
                return org.apache.batik.css.engine.value.ValueConstants.
                         NUMBER_600;
            case 700:
                return org.apache.batik.css.engine.value.ValueConstants.
                         NUMBER_700;
            case 800:
                return org.apache.batik.css.engine.value.ValueConstants.
                         NUMBER_800;
            default:
                return org.apache.batik.css.engine.value.ValueConstants.
                         NUMBER_900;
        }
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public FontWeightManager() { super();
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1aC2wcxRmeO79f8Ssv8nDixAnKg7uQQAE5TXEcGzucH4qD" +
       "2zoEZ7w3Z2+8t7vsztnn0JSH2iYtBfEIT0FUVUFQmhCEQH1QaFDUAoUiAaFA" +
       "W6AvCVoalUBLUWmh/z+7e7u3d7fGUl1LOx7P/P/M/3//P//8M+Ojp0mJaZAm" +
       "pvIIn9KZGelQeT81TBZvV6hp7oS2YemOIvrBFe/0XhQmpUNkzhg1eyRqsk6Z" +
       "KXFziCyVVZNTVWJmL2Nx5Og3mMmMCcplTR0i82SzO6krsiTzHi3OkGCQGjFS" +
       "Tzk35JEUZ932AJwsjYEkUSFJtM3f3Roj1ZKmT7nkCz3k7Z4epEy6c5mc1MX2" +
       "0gkaTXFZicZkk7emDbJO15SpUUXjEZbmkb3K+TYE22Pn50Cw4uHaDz++aaxO" +
       "QNBIVVXjQj1zBzM1ZYLFY6TWbe1QWNK8knyVFMVIlYeYk5aYM2kUJo3CpI62" +
       "LhVIX8PUVLJdE+pwZ6RSXUKBOGnOHkSnBk3aw/QLmWGEcm7rLphB2+UZbS0t" +
       "c1S8bV300B1X1D1SRGqHSK2sDqA4EgjBYZIhAJQlR5hhtsXjLD5E6lUw9gAz" +
       "ZKrI+2xLN5jyqEp5CszvwIKNKZ0ZYk4XK7Aj6GakJK4ZGfUSwqHsv0oSCh0F" +
       "Xee7uloadmI7KFgpg2BGgoLf2SzF47Ia52SZnyOjY8ulQACsZUnGx7TMVMUq" +
       "hQbSYLmIQtXR6AC4njoKpCUaOKDByaKCgyLWOpXG6SgbRo/00fVbXUBVIYBA" +
       "Fk7m+cnESGClRT4reexzunfzjVepXWqYhEDmOJMUlL8KmJp8TDtYghkM1oHF" +
       "WL02djud/8TBMCFAPM9HbNH84CtnLl7fdOIZi2ZxHpq+kb1M4sPSkZE5Ly5p" +
       "X3NREYpRrmumjMbP0lyssn67pzWtQ4SZnxkROyNO54kdP//yNQ+yd8OkspuU" +
       "SpqSSoIf1UtaUpcVZlzCVGZQzuLdpIKp8XbR303KoB6TVWa19iUSJuPdpFgR" +
       "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" +
       "F7FmKn8mg759iahireu/5leUeJMkAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "WZ6nQW57Mx6QAIH6LOWzwAkvUgItyv9n");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("6a4n0IOndGDQ/cNZkg8A6YCkePy+8DgyYG9usFPnOJrRfL89PXHWr8vl8Oib" +
       "OcuZV9Hnzr1Alne6j1/20v2t7pe0L73WH/7Id+qf39+001xltyuk3M9CV/aX" +
       "/kqhxQvjs7eUdizrcu+F7z38aw88f/xy+/Be4dM1dka39978KlvHC5Py8tnu" +
       "n73rN37gV177enlZ5P8BsUMExGwvAAA=");
}
