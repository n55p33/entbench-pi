package org.apache.batik.css.engine.value.svg;
public class SVGPaintManager extends org.apache.batik.css.engine.value.svg.SVGColorManager {
    public SVGPaintManager(java.lang.String prop) { super(prop); }
    public SVGPaintManager(java.lang.String prop, org.apache.batik.css.engine.value.Value v) {
        super(
          prop,
          v);
    }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return true; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_PAINT; }
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException { switch (lu.
                                                      getLexicalUnitType(
                                                        )) {
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
                                                default:
                                                    return super.
                                                      createValue(
                                                        lu,
                                                        engine);
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_URI:
                                            }
                                            java.lang.String value =
                                              lu.
                                              getStringValue(
                                                );
                                            java.lang.String uri =
                                              resolveURI(
                                                engine.
                                                  getCSSBaseURI(
                                                    ),
                                                value);
                                            lu =
                                              lu.
                                                getNextLexicalUnit(
                                                  );
                                            if (lu ==
                                                  null) {
                                                return new org.apache.batik.css.engine.value.URIValue(
                                                  value,
                                                  uri);
                                            }
                                            org.apache.batik.css.engine.value.ListValue result =
                                              new org.apache.batik.css.engine.value.ListValue(
                                              ' ');
                                            result.
                                              append(
                                                new org.apache.batik.css.engine.value.URIValue(
                                                  value,
                                                  uri));
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
                                                          CSS_NONE_VALUE)) {
                                                    result.
                                                      append(
                                                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                                                          NONE_VALUE);
                                                    return result;
                                                }
                                            }
                                            org.apache.batik.css.engine.value.Value v =
                                              super.
                                              createValue(
                                                lu,
                                                engine);
                                            if (v.
                                                  getCssValueType(
                                                    ) ==
                                                  org.w3c.dom.css.CSSValue.
                                                    CSS_CUSTOM) {
                                                org.apache.batik.css.engine.value.ListValue lv =
                                                  (org.apache.batik.css.engine.value.ListValue)
                                                    v;
                                                for (int i =
                                                       0;
                                                     i <
                                                       lv.
                                                       getLength(
                                                         );
                                                     i++) {
                                                    result.
                                                      append(
                                                        lv.
                                                          item(
                                                            i));
                                                }
                                            }
                                            else {
                                                result.
                                                  append(
                                                    v);
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
                NONE_VALUE) {
            return value;
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
            if (v.
                  getPrimitiveType(
                    ) ==
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_URI) {
                v =
                  lv.
                    item(
                      1);
                if (v ==
                      org.apache.batik.css.engine.value.svg.SVGValueConstants.
                        NONE_VALUE) {
                    return value;
                }
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
                        lv.
                          item(
                            0));
                    result.
                      append(
                        t);
                    if (lv.
                          getLength(
                            ) ==
                          3) {
                        result.
                          append(
                            lv.
                              item(
                                1));
                    }
                    return result;
                }
                return value;
            }
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
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
