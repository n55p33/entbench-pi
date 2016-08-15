package org.apache.batik.css.engine.value.svg;
public class StrokeDasharrayManager extends org.apache.batik.css.engine.value.LengthManager {
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_LENGTH_LIST_OR_IDENT; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_STROKE_DASHARRAY_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 NONE_VALUE;
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
                   SAC_IDENT:
                if (lu.
                      getStringValue(
                        ).
                      equalsIgnoreCase(
                        org.apache.batik.util.CSSConstants.
                          CSS_NONE_VALUE)) {
                    return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                             NONE_VALUE;
                }
                throw createInvalidIdentifierDOMException(
                        lu.
                          getStringValue(
                            ));
            default:
                org.apache.batik.css.engine.value.ListValue lv =
                  new org.apache.batik.css.engine.value.ListValue(
                  ' ');
                do  {
                    org.apache.batik.css.engine.value.Value v =
                      super.
                      createValue(
                        lu,
                        engine);
                    lv.
                      append(
                        v);
                    lu =
                      lu.
                        getNextLexicalUnit(
                          );
                    if (lu !=
                          null &&
                          lu.
                          getLexicalUnitType(
                            ) ==
                          org.w3c.css.sac.LexicalUnit.
                            SAC_OPERATOR_COMMA) {
                        lu =
                          lu.
                            getNextLexicalUnit(
                              );
                    }
                }while(lu !=
                         null); 
                return lv;
        }
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
                  CSS_NONE_VALUE)) {
            return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                     NONE_VALUE;
        }
        throw createInvalidIdentifierDOMException(
                value);
    }
    public org.apache.batik.css.engine.value.Value computeValue(org.apache.batik.css.engine.CSSStylableElement elt,
                                                                java.lang.String pseudo,
                                                                org.apache.batik.css.engine.CSSEngine engine,
                                                                int idx,
                                                                org.apache.batik.css.engine.StyleMap sm,
                                                                org.apache.batik.css.engine.value.Value value) {
        switch (value.
                  getCssValueType(
                    )) {
            case org.w3c.dom.css.CSSValue.
                   CSS_PRIMITIVE_VALUE:
                return value;
        }
        org.apache.batik.css.engine.value.ListValue lv =
          (org.apache.batik.css.engine.value.ListValue)
            value;
        org.apache.batik.css.engine.value.ListValue result =
          new org.apache.batik.css.engine.value.ListValue(
          ' ');
        for (int i =
               0;
             i <
               lv.
               getLength(
                 );
             i++) {
            result.
              append(
                super.
                  computeValue(
                    elt,
                    pseudo,
                    engine,
                    idx,
                    sm,
                    lv.
                      item(
                        i)));
        }
        return result;
    }
    protected int getOrientation() { return BOTH_ORIENTATION;
    }
    public StrokeDasharrayManager() { super(
                                        );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "WSVe8a3tPz4/EZPxIAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AA1+VLV6LAAA");
}
