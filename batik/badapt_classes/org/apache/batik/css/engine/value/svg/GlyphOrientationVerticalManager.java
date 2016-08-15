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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "ZYJH1cgZAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "EwX9JAAA");
}
