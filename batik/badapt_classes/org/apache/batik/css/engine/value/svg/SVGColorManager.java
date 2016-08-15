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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "51xkijBzc+FQhqYt0tHN2LvkPz2xMseWIwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "dTixk0dfz07O7Dbec26PUD6LPo7n0/3D");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("6JvKl1+m2R/5TuOL+1driivledHKAyPo/v0DupM9wXN3bO24rcv9D3z34V+4" +
       "8vzx/uXhvcCn8+6MbO+6/RMx0guT8lFX/qtP/PKH/8nLXy/v9f8fq2b0NK8u" +
       "AAA=");
}
