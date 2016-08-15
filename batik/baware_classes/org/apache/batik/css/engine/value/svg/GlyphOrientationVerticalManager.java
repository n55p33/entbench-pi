package org.apache.batik.css.engine.value.svg;
public class GlyphOrientationVerticalManager extends org.apache.batik.css.engine.value.svg.GlyphOrientationManager {
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_GLYPH_ORIENTATION_VERTICAL_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 AUTO_VALUE;
    }
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException {
        if (lu.
              getLexicalUnitType(
                ) ==
              org.w3c.css.sac.LexicalUnit.
                SAC_IDENT) {
            if (lu.
                  getStringValue(
                    ).
                  equalsIgnoreCase(
                    org.apache.batik.util.CSSConstants.
                      CSS_AUTO_VALUE)) {
                return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                         AUTO_VALUE;
            }
            throw createInvalidIdentifierDOMException(
                    lu.
                      getStringValue(
                        ));
        }
        return super.
          createValue(
            lu,
            engine);
    }
    public org.apache.batik.css.engine.value.Value createStringValue(short type,
                                                                     java.lang.String value,
                                                                     org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException {
        if (type !=
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_IDENT) {
            throw createInvalidStringTypeDOMException(
                    type);
        }
        if (value.
              equalsIgnoreCase(
                org.apache.batik.util.CSSConstants.
                  CSS_AUTO_VALUE)) {
            return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                     AUTO_VALUE;
        }
        throw createInvalidIdentifierDOMException(
                value);
    }
    public GlyphOrientationVerticalManager() {
        super(
          );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AsBY+1PIGQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "6DEvF9GJs5yWheLSxFKPb8WWM4IdsrApK3O4Gbb4AjIiukyzmb2uve2VvTHf" +
       "nh8OHFwDgRflrKP7Ct4Ut10PZsUjBwei+efMyauDIweiRw6NoOzt995r3e7k" +
       "b77PPfnMs/Lwk8jO3mHbLIJujlzvpyxlrVhHRN0IJD127bd8Kr/cOjwE+tKT" +
       "/3L35K36O17BMff9J/Q8KfJT1PNf6b5B+uAOdMPBkdAV127HmS4dPwg6FyjR" +
       "KnAmx46D7j3w7B2Zxx4Ez2N7nn3s6kfNV42CU3kUbOf+Zc4yg5fpy09n7Qg6" +
       "rynRKHDzC0x6T/vuYcQ41ztbOCo3b1gemJgH0APgQfZMRH78Jr7rZfrenRWb" +
       "rYltRRVX1vbgb//A7I3Xv8Y5pM+9kf6o3rgHPPU9b9R/PN7YyQl29o16fWZU" +
       "jEq5LaEo7ZJKkl06cY4R7dM88nKGYyyL57V8tF85MdqpvbuoPUl37Y8mu/Zu" +
       "e0jhiaR4WerlzB/Miqci6FVSoIiRkjsza3ry0KNP/6gefQg8vT2P9n48Hr1h" +
       "7ww8+z0+ApvTCDod6m4QHUDr+3P+Z6/uo+znh3KCX8+KjwGQ3vphezp7NW/8" +
       "2ivxRgIQ6TpXjNkdyV1X/Ctie5MvffbZ8ze97lnur/NbtoPb9ptJ6CZ1ZVlH" +
       "j7SP1M94gaIauVU3bw+4vfzr09eJqoNb0Qg4dr09Of/UlvUzEfTgdVmjvVPn" +
       "o4yf34v2azBG0Jlt5SjPb0fQa67GA9QC5VHK342gCycpgRb591G6P4igc4d0" +
       "YNBt5SjJHwHpgCSrftHbT523/N8ukfdmNjl1fOU9CKE7rhdCRxbrh48tsfmf" +
       "bPaXw9X2bzaXpc8926ff+WL1k9s7TfC6nqaZlJtI6Oz2evVgSX3wmtL2ZZ3p" +
       "PfrSbZ+/+ZH95f+2rcKHWXpEt/uvfmmI216UX/Olv/+633nzbzz7zfyq4X8B" +
       "wn07WP0kAAA=");
}
