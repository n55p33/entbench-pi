package org.apache.batik.css.engine.value.svg;
public class SVGColorManager extends org.apache.batik.css.engine.value.svg.ColorManager {
    protected java.lang.String property;
    protected org.apache.batik.css.engine.value.Value defaultValue;
    public SVGColorManager(java.lang.String prop) { this(prop, org.apache.batik.css.engine.value.svg.SVGValueConstants.
                                                                 BLACK_RGB_VALUE);
    }
    public SVGColorManager(java.lang.String prop, org.apache.batik.css.engine.value.Value v) {
        super(
          );
        property =
          prop;
        defaultValue =
          v;
    }
    public boolean isInheritedProperty() { return false;
    }
    public boolean isAnimatableProperty() { return true;
    }
    public boolean isAdditiveProperty() { return true;
    }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_COLOR;
    }
    public java.lang.String getPropertyName() { return property;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return defaultValue;
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
                      CSS_CURRENTCOLOR_VALUE)) {
                return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                         CURRENTCOLOR_VALUE;
            }
        }
        org.apache.batik.css.engine.value.Value v =
          super.
          createValue(
            lu,
            engine);
        lu =
          lu.
            getNextLexicalUnit(
              );
        if (lu ==
              null) {
            return v;
        }
        if (lu.
              getLexicalUnitType(
                ) !=
              org.w3c.css.sac.LexicalUnit.
                SAC_FUNCTION ||
              !lu.
              getFunctionName(
                ).
              equalsIgnoreCase(
                "icc-color")) {
            throw createInvalidLexicalUnitDOMException(
                    lu.
                      getLexicalUnitType(
                        ));
        }
        lu =
          lu.
            getParameters(
              );
        if (lu.
              getLexicalUnitType(
                ) !=
              org.w3c.css.sac.LexicalUnit.
                SAC_IDENT) {
            throw createInvalidLexicalUnitDOMException(
                    lu.
                      getLexicalUnitType(
                        ));
        }
        org.apache.batik.css.engine.value.ListValue result =
          new org.apache.batik.css.engine.value.ListValue(
          ' ');
        result.
          append(
            v);
        org.apache.batik.css.engine.value.svg.ICCColor icc =
          new org.apache.batik.css.engine.value.svg.ICCColor(
          lu.
            getStringValue(
              ));
        result.
          append(
            icc);
        lu =
          lu.
            getNextLexicalUnit(
              );
        while (lu !=
                 null) {
            if (lu.
                  getLexicalUnitType(
                    ) !=
                  org.w3c.css.sac.LexicalUnit.
                    SAC_OPERATOR_COMMA) {
                throw createInvalidLexicalUnitDOMException(
                        lu.
                          getLexicalUnitType(
                            ));
            }
            lu =
              lu.
                getNextLexicalUnit(
                  );
            if (lu ==
                  null) {
                throw createInvalidLexicalUnitDOMException(
                        (short)
                          -1);
            }
            icc.
              append(
                getColorValue(
                  lu));
            lu =
              lu.
                getNextLexicalUnit(
                  );
        }
        return result;
    }
    public org.apache.batik.css.engine.value.Value computeValue(org.apache.batik.css.engine.CSSStylableElement elt,
                                                                java.lang.String pseudo,
                                                                org.apache.batik.css.engine.CSSEngine engine,
                                                                int idx,
                                                                org.apache.batik.css.engine.StyleMap sm,
                                                                org.apache.batik.css.engine.value.Value value) {
        if (value ==
              org.apache.batik.css.engine.value.svg.SVGValueConstants.
                CURRENTCOLOR_VALUE) {
            sm.
              putColorRelative(
                idx,
                true);
            int ci =
              engine.
              getColorIndex(
                );
            return engine.
              getComputedStyle(
                elt,
                pseudo,
                ci);
        }
        if (value.
              getCssValueType(
                ) ==
              org.w3c.dom.css.CSSValue.
                CSS_VALUE_LIST) {
            org.apache.batik.css.engine.value.ListValue lv =
              (org.apache.batik.css.engine.value.ListValue)
                value;
            org.apache.batik.css.engine.value.Value v =
              lv.
              item(
                0);
            org.apache.batik.css.engine.value.Value t =
              super.
              computeValue(
                elt,
                pseudo,
                engine,
                idx,
                sm,
                v);
            if (t !=
                  v) {
                org.apache.batik.css.engine.value.ListValue result =
                  new org.apache.batik.css.engine.value.ListValue(
                  ' ');
                result.
                  append(
                    t);
                result.
                  append(
                    lv.
                      item(
                        1));
                return result;
            }
            return value;
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
    protected float getColorValue(org.w3c.css.sac.LexicalUnit lu) {
        switch (lu.
                  getLexicalUnitType(
                    )) {
            case org.w3c.css.sac.LexicalUnit.
                   SAC_INTEGER:
                return lu.
                  getIntegerValue(
                    );
            case org.w3c.css.sac.LexicalUnit.
                   SAC_REAL:
                return lu.
                  getFloatValue(
                    );
        }
        throw createInvalidLexicalUnitDOMException(
                lu.
                  getLexicalUnitType(
                    ));
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "z2kxRZi5uXAoQ9MW6ehm7F3yH2BzTXSWIwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "duHs1uHYTx59PT85tdt4z5k9Qvks+mg9");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("n+wfRt/UvvTSkP2Bbze/sH+1pjlKnhdSHmAq9+8f0B3vCZ69o7QjWZfID7z2" +
       "8C9ffu5o//LwXuGTcXdKt3fd/olYzw3i8lFX/mtP/PMP/+OXvlbe6/8/DIlA" +
       "nq8uAAA=");
}
