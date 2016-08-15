package org.apache.batik.css.engine.value.svg;
public class EnableBackgroundManager extends org.apache.batik.css.engine.value.LengthManager {
    protected int orientation;
    public boolean isInheritedProperty() { return false; }
    public boolean isAnimatableProperty() { return false; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_ENABLE_BACKGROUND_VALUE;
    }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_ENABLE_BACKGROUND_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 ACCUMULATE_VALUE;
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
            default:
                throw createInvalidLexicalUnitDOMException(
                        lu.
                          getLexicalUnitType(
                            ));
            case org.w3c.css.sac.LexicalUnit.
                   SAC_IDENT:
                java.lang.String id =
                  lu.
                  getStringValue(
                    ).
                  toLowerCase(
                    ).
                  intern(
                    );
                if (id ==
                      org.apache.batik.util.CSSConstants.
                        CSS_ACCUMULATE_VALUE) {
                    return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                             ACCUMULATE_VALUE;
                }
                if (id !=
                      org.apache.batik.util.CSSConstants.
                        CSS_NEW_VALUE) {
                    throw createInvalidIdentifierDOMException(
                            id);
                }
                org.apache.batik.css.engine.value.ListValue result =
                  new org.apache.batik.css.engine.value.ListValue(
                  ' ');
                result.
                  append(
                    org.apache.batik.css.engine.value.svg.SVGValueConstants.
                      NEW_VALUE);
                lu =
                  lu.
                    getNextLexicalUnit(
                      );
                if (lu ==
                      null) {
                    return result;
                }
                result.
                  append(
                    super.
                      createValue(
                        lu,
                        engine));
                for (int i =
                       1;
                     i <
                       4;
                     i++) {
                    lu =
                      lu.
                        getNextLexicalUnit(
                          );
                    if (lu ==
                          null) {
                        throw createMalformedLexicalUnitDOMException(
                                );
                    }
                    result.
                      append(
                        super.
                          createValue(
                            lu,
                            engine));
                }
                return result;
        }
    }
    public org.apache.batik.css.engine.value.Value createStringValue(short type,
                                                                     java.lang.String value,
                                                                     org.apache.batik.css.engine.CSSEngine engine) {
        if (type !=
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_IDENT) {
            throw createInvalidStringTypeDOMException(
                    type);
        }
        if (!value.
              equalsIgnoreCase(
                org.apache.batik.util.CSSConstants.
                  CSS_ACCUMULATE_VALUE)) {
            throw createInvalidIdentifierDOMException(
                    value);
        }
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 ACCUMULATE_VALUE;
    }
    public org.apache.batik.css.engine.value.Value createFloatValue(short unitType,
                                                                    float floatValue)
          throws org.w3c.dom.DOMException {
        throw createDOMException(
                );
    }
    public org.apache.batik.css.engine.value.Value computeValue(org.apache.batik.css.engine.CSSStylableElement elt,
                                                                java.lang.String pseudo,
                                                                org.apache.batik.css.engine.CSSEngine engine,
                                                                int idx,
                                                                org.apache.batik.css.engine.StyleMap sm,
                                                                org.apache.batik.css.engine.value.Value value) {
        if (value.
              getCssValueType(
                ) ==
              org.w3c.dom.css.CSSValue.
                CSS_VALUE_LIST) {
            org.apache.batik.css.engine.value.ListValue lv =
              (org.apache.batik.css.engine.value.ListValue)
                value;
            if (lv.
                  getLength(
                    ) ==
                  5) {
                org.apache.batik.css.engine.value.Value lv1 =
                  lv.
                  item(
                    1);
                orientation =
                  HORIZONTAL_ORIENTATION;
                org.apache.batik.css.engine.value.Value v1 =
                  super.
                  computeValue(
                    elt,
                    pseudo,
                    engine,
                    idx,
                    sm,
                    lv1);
                org.apache.batik.css.engine.value.Value lv2 =
                  lv.
                  item(
                    2);
                orientation =
                  VERTICAL_ORIENTATION;
                org.apache.batik.css.engine.value.Value v2 =
                  super.
                  computeValue(
                    elt,
                    pseudo,
                    engine,
                    idx,
                    sm,
                    lv2);
                org.apache.batik.css.engine.value.Value lv3 =
                  lv.
                  item(
                    3);
                orientation =
                  HORIZONTAL_ORIENTATION;
                org.apache.batik.css.engine.value.Value v3 =
                  super.
                  computeValue(
                    elt,
                    pseudo,
                    engine,
                    idx,
                    sm,
                    lv3);
                org.apache.batik.css.engine.value.Value lv4 =
                  lv.
                  item(
                    4);
                orientation =
                  VERTICAL_ORIENTATION;
                org.apache.batik.css.engine.value.Value v4 =
                  super.
                  computeValue(
                    elt,
                    pseudo,
                    engine,
                    idx,
                    sm,
                    lv4);
                if (lv1 !=
                      v1 ||
                      lv2 !=
                      v2 ||
                      lv3 !=
                      v3 ||
                      lv4 !=
                      v4) {
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
                        v1);
                    result.
                      append(
                        v2);
                    result.
                      append(
                        v3);
                    result.
                      append(
                        v4);
                    return result;
                }
            }
        }
        return value;
    }
    protected int getOrientation() { return orientation;
    }
    public EnableBackgroundManager() { super(
                                         );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "nf8BmpmbtmAkAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "09TwVj2ytWlbWY9R3WdcsoYgHUPoYkADs1zUmy2+s5ss6ryJgljuuG1VXA0l" +
       "ehLMvRjE63krGnUGSLu66MqDATzKBpEikDGb2sRsVIdWVk/hrLaR162+1dbq" +
       "5DCi1lFo9CgBjVrjOYv3u6mJmwkvacBJ8Wbf9RWdSYiRxFl2F5e2i54DqzOc" +
       "MS11NBlILr6z2k0tsUdk0+3V1OHOkbyeHU13KTXdgPGJZiKW9VR/GNHLLEZd" +
       "HCbyqLUxfSPfLZoYnKuMviHpQQvK+KXIIyIxdWd6qPZ60KTaUVJtpPKDzY7l" +
       "R3MDrGpSs0GnaGzrIxozLNZeYFhdqmJZ2F/hNoEQdtiAh3SCjCjLtDk+aa1x" +
       "SplNtqvAjQzTafAreps4K4r3GHXtaLSa13lHYFm9Gay7GtTfhkjPmJsdjdfj" +
       "1bQ64ykaJoY1fNTGlImS15w6m6lz2MSqlmFQ3Zxu27O80ajZ8ywXB4vGjhfl" +
       "JEo1Rqyi9S46NJr8zmHRWtNeqZ1klmZuJ9VUipxCY4Q2qgrHjoQ4nU5TolqF" +
       "Uxqlh1i1SQznQs47NuTlRK+tNg1WIPwQrIh2YlQNFpiHmWHDNtcZJkup0+ja" +
       "5sQ1ubZq1iYyHmwbDUEdjL08UrWq3cm5mMVjm6aM+aTaT3drONix0dLiGhrZ" +
       "hiFGsbtzbaJ4i8Y0zbuL0DKg6iLeEhaardv9PgaGUorUWJuu55mEJ3x9ys1k" +
       "SxhFwy0yi5GaJ9Y3bV9vchOPD7bRaOhRvCEF3RZqtBpEjefRRgdMrLtRrI5c" +
       "jEckGYZMeQeRhBO3kimDMt3xxhkFSDAnWyixoF0Ws3Ykg1PTBQJy+DjW1hwY" +
       "6A6W1yfjZkhOkEYguLs+S4SGB5LdJlhCLv3U1dpdx3fWIG2xOp3Oh4stCP3d" +
       "bY08Ue4C3Tx13dho0SC+i92PfdPLRfHqzb3D8nfxDucSJ/ZuK8VW2/O3O0wt" +
       "t9m++IkbbyqTn6qfP9zzHsaVR2LP/6u2mqr2CVKPAkofuv2WIlOeJR/vxf7W" +
       "J/7bs/PvMz72Lk6bXjzD51mSP8e89TvkB+QfPV954ObO7DtOuU8jXT+9H3sp" +
       "VOMkdOendmWfv6nZJwuNfQA8yKFmkVuf+Nx6S7a0gv3Y3+FI4Y07tP1gUeRx" +
       "5UkzolxDDc1YVaahV94buNVm2kNrz7NVyT02pu3dttJOdllWJKel/2Dl8ODr" +
       "6P/+Sv9379D2maL4VFx5rxl1XNOR4uIs6Ej8ou3jx3J++l7lfBU83UM5u/df" +
       "zs/foe0fFMWPxZWrZnGJpNzzvo2UN+5BystFZXHCQB1KSd1/Kb94h7afLop/" +
       "GFcu62p8JN6R31HHIv6jexDxalH5MnimhyJO77+IX75D2y8VxT8+LeL4MNiI" +
       "xyK+dQ8ilvH+JfCIhyKK91/Ef3aHtl8vil/Zi9hXNSmx98dlRwcZH7z7pYdj" +
       "+FIbv3qv2ngOPB891MZH7482zpcA54+E+u5CqKwhl7JEknwwUnNTlmwerFeP" +
       "YF69k+A9jsPLt7K3r5zp7dzhDY5DSs8c9aZ4zkF/wuC5rPrFTFki/+ui+I24" +
       "8qgcqlKslsosqt4+1uhv3qtGXwHPJw81+sn7o9EH9onRrSatC5HhheXhXJkJ" +
       "/csS/z/cwQb/Y1H8AUin9irYH5jdShF/eK+KKGLJjUNF3LivplV8/tEttaHZ" +
       "nhSXqF+/tZ0Un18tAb5ZFP8lrlzZK4IoMG+lhz+9Vz08D54vHOrhC/dHDxdL" +
       "gItHRn9wF/fh4q1dTP/FfVLVPWEtRUEdUbl2JyoFCZWRSq7fLnn6i9sb2blS" +
       "xD+PixuZjp/c2tG+fa9z1Uvg+cqhXr/ybvXav1sgP3fpDm2PFcWFuPI4COST" +
       "42sCx+osJDx38d1ICBLVp29zm624jvPMOy7a7i+Hyr/45uWHn36T/4PyQtfN" +
       "C5yPjCoPg3W/ffL2xIn3i36oamapgkf2dyn8Uq4n7xKKb168i0E0SssF3Lmr" +
       "e9Sn4srLd0WND4/QTyJ+1+EUcRvEuHJx/3IS5zmQ194KB7AFypOQLwIHPwsJ" +
       "uCj/T8K9ElcuHcOBTvcvJ0FeBdQBSPH6");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("Af/IaaC7q2sEvmLjcCzz/Uz1zEm7Lt3h6t2M5cQS9P2nFo7lTe2jRV6yv6v9" +
       "uvylN+nxD3yr9VP7C3OyLe12BZWHR5WH9nf3SqLFQvHl21I7onVx8Np3Hv/y" +
       "I68eLWof3zN87GMneHvx1jfScMePyztku199+p9878+8+cflTYn/C/bN3ldC" +
       "LwAA");
}
