package org.apache.batik.css.engine.value.svg;
public class StrokeMiterlimitManager extends org.apache.batik.css.engine.value.AbstractValueManager {
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return true; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_NUMBER_OR_INHERIT; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_STROKE_MITERLIMIT_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 NUMBER_4;
    }
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException {
        switch (lu.
                  getLexicalUnitType(
                    )) {
            case org.w3c.css.sac.LexicalUnit.
                   SAC_INHERIT:
                return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                         INHERIT_VALUE;
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
            default:
                throw createInvalidLexicalUnitDOMException(
                        lu.
                          getLexicalUnitType(
                            ));
        }
    }
    public org.apache.batik.css.engine.value.Value createFloatValue(short unitType,
                                                                    float floatValue)
          throws org.w3c.dom.DOMException {
        if (unitType ==
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_NUMBER) {
            return new org.apache.batik.css.engine.value.FloatValue(
              unitType,
              floatValue);
        }
        throw createInvalidFloatTypeDOMException(
                unitType);
    }
    public StrokeMiterlimitManager() { super(
                                         );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "E5s5NEKbVyJe8a30P8N5SjuEHgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "PyT/38+nKQAA");
}
