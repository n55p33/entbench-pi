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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "E585NEKbVyJe8a30P8JoXSmEHgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "27xJ/6cpAAA=");
}
