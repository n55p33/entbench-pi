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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "kP7Bi3/3FR988qv5Ltr/AcKJAvHmKAAA");
}
