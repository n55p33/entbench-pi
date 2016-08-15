package org.apache.batik.css.engine.value.svg;
public class BaselineShiftManager extends org.apache.batik.css.engine.value.LengthManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_BASELINE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          BASELINE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_SUB_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          SUB_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_SUPER_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          SUPER_VALUE); }
    public boolean isInheritedProperty() { return false; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_BASELINE_SHIFT_VALUE; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_BASELINE_SHIFT_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 BASELINE_VALUE;
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
                java.lang.Object v =
                  values.
                  get(
                    lu.
                      getStringValue(
                        ).
                      toLowerCase(
                        ).
                      intern(
                        ));
                if (v ==
                      null) {
                    throw createInvalidIdentifierDOMException(
                            lu.
                              getStringValue(
                                ));
                }
                return (org.apache.batik.css.engine.value.Value)
                         v;
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
            throw createInvalidIdentifierDOMException(
                    value);
        }
        java.lang.Object v =
          values.
          get(
            value.
              toLowerCase(
                ).
              intern(
                ));
        if (v ==
              null) {
            throw createInvalidIdentifierDOMException(
                    value);
        }
        return (org.apache.batik.css.engine.value.Value)
                 v;
    }
    public org.apache.batik.css.engine.value.Value computeValue(org.apache.batik.css.engine.CSSStylableElement elt,
                                                                java.lang.String pseudo,
                                                                org.apache.batik.css.engine.CSSEngine engine,
                                                                int idx,
                                                                org.apache.batik.css.engine.StyleMap sm,
                                                                org.apache.batik.css.engine.value.Value value) {
        if (value.
              getPrimitiveType(
                ) ==
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_PERCENTAGE) {
            sm.
              putLineHeightRelative(
                idx,
                true);
            int fsi =
              engine.
              getLineHeightIndex(
                );
            org.apache.batik.css.engine.CSSStylableElement parent;
            parent =
              (org.apache.batik.css.engine.CSSStylableElement)
                elt.
                getParentNode(
                  );
            if (parent ==
                  null) {
                parent =
                  elt;
            }
            org.apache.batik.css.engine.value.Value fs =
              engine.
              getComputedStyle(
                parent,
                pseudo,
                fsi);
            float fsv =
              fs.
              getFloatValue(
                );
            float v =
              value.
              getFloatValue(
                );
            return new org.apache.batik.css.engine.value.FloatValue(
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_NUMBER,
              fsv *
                v /
                100.0F);
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
    protected int getOrientation() { return BOTH_ORIENTATION;
    }
    public BaselineShiftManager() { super(
                                      ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "aCbLZu/QWvGKb+f+B6nDtiBRIwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL16e8zk1nUf95N2pV3L2tXKD0W2ZEle2ZWZfCTnwZmpXNdD" +
       "znBe5HCG5HBmmDRrvoczfA3fw0SpY6CxU6OukciJAyTKH7HhOvAjCBL0ESRQ" +
       "UjR2ECNF0qBtAtQOmgB1mhqNUTRN66buJef79ntoHxVW6AD3DnnvOfeec+65" +
       "v3t47/3Ct6CLYQDBvmfvTNuLDvUsOlzb9cNo5+vh4ZCuT+Qg1DXSlsNQAGU3" +
       "1ed+6epffeeTq2sH0CUJelx2XS+SI8tzQ04PPTvRNRq6elLatXUnjKBr9FpO" +
       "ZCSOLBuhrTB6kYbedIo1gm7QxyIgQAQEiICUIiDtEyrA9GbdjR2y4JDdKNxC" +
       "PwJdoKFLvlqIF0HPnm3ElwPZOWpmUmoAWni4eBeBUiVzFkDP3NJ9r/NrFP4U" +
       "jLz80z947ZcfgK5K0FXL5QtxVCBEBDqRoEcc3VH0IGxrmq5J0GOurmu8Hliy" +
       "beWl3BJ0PbRMV47iQL9lpKIw9vWg7PPEco+ohW5BrEZecEs9w9Jt7fjtomHL" +
       "JtD1bSe67jWkinKg4BULCBYYsqofszy4sVwtgt51nuOWjjdGgACwPuTo0cq7" +
       "1dWDrgwKoOv7sbNl10T4KLBcE5Be9GLQSwQ9ecdGC1v7srqRTf1mBD1xnm6y" +
       "rwJUl0tDFCwR9NbzZGVLYJSePDdKp8bnW+P3f+KH3L57UMqs6apdyP8wYHr6" +
       "HBOnG3qgu6q+Z3zkffRPyW/79Y8dQBAgfus54j3NP/3hb3/we59+9at7mnfc" +
       "hoZV1roa3VQ/ozz6++8kX2g9UIjxsO+FVjH4ZzQv3X9yVPNi5oOZ97ZbLRaV" +
       "h8eVr3K/vfzwL+p/cQBdGUCXVM+OHeBHj6me41u2HvR0Vw/kSNcG0GXd1ciy" +
       "fgA9BJ5py9X3paxhhHo0gB60y6JLXvkOTGSAJgoTPQSeLdfwjp99OVqVz5kP" +
       "QdBDIEGPgPQ+aP8r/yPIQVaeoyOyKruW6yGTwCv0DxHdjRRg2xWiAK/fIKEX" +
       "B8AFES8wERn4wUo/qlDDgtYEMiGJbMc6EiYmQsihXojJrywjYmQXeEZwWLid" +
       "//+7w6ywwLX0wgUwOO88Dw02mFV9z9b04Kb6ckx0v/2lm797cGuqHNkugv42" +
       "kOFwL8NhKcMhkOFwL8NhKcMhkOHwdjJAFy6UXb+lkGXvE2BENwAbAGo+8gL/" +
       "94Yf+thzDwBn9NMHwXAUpMidwZs8QZNBiZkqcGno1U+nPyr+ffQAOjiLwoX8" +
       "oOhKwT4psPMWRt44P/tu1+7Vj37zr778Uy95J/PwDKwfwcNrOYvp/dx5Swee" +
       "qmsAME+af98z8q/e/PWXbhxADwLMADgZycB2AIKePt/HmWn+4jFkFrpcBAob" +
       "XuDIdlF1jHNXolXgpSclpQs8Wj4/BmzchI6yMxOhqH3cL/K37F2mGLRzWpSQ" +
       "/Hd4/+f+/e/9ebU09zF6Xz21HvJ69OIpxCgau1piw2MnPiAEug7o/sOnJz/5" +
       "qW999PtLBwAU775dhzeKnARIAYYQmPkffHX7R9/4+mf+8ODEaSKwZMaKbanZ" +
       "Xsnvgt8FkP5PkQrlioL9bL9OHkHOM7cwxy96fs+JbAB9bDAhCw+6MXMdT7MM" +
       "S1ZsvfDY/331eexX/8snru19wgYlxy71vfdu4KT8ewjow7/7g//j6bKZC2qx" +
       "+p3Y74RsD6mPn7TcDgJ5V8iR/egfPPUzX5F/DoAzAMTQyvUS46DSHlA5gGhp" +
       "C7jMkXN1lSJ7V3h6Ipyda6eilJvqJ//wL98s/uVvfLuU9myYc3rcGdl/ce9q" +
       "RfZMBpp/+/lZ35fDFaCrvTr+gWv2q98BLUqgRRXgXMgGAIayM15yRH3xoT/+" +
       "zX/5tg/9/gPQAQVdsT1Zo+RywkGXgafr4QogWOb/3Q/uvTl9GGTXSlWh1yi/" +
       "d5AnyrcHgYAv3BlrqCJKOZmuT/wv1lY+8h//+jVGKFHmNovzOX4J+cLPPkl+" +
       "4C9K/pPpXnA/nb0WmkFEd8Jb+UXnvx88d+lfHUAPSdA19ShcFAvgBZNIAiFS" +
       "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" +
       "/EPfxj+7vy6m2nKeF608TEMP7W+ulY0W");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("X03P3rG147Yu9V/4zqO/dPn54y+8R/cCn0ywU7K96/b3sbqOH5U3qPJ/9vZf" +
       "ef/nXvl6eePh/wJNsynyNy4AAA==");
}
