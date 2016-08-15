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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "sIyXrBCv+Nb8H3GNyrjxIAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL16C8zsxnUe73+lK+la1r2SbFlRLFmSr+zIm/5ccrmvyk69" +
       "5L64JJe7y8c+mkYmueSSy/eb3ESN7aK13aCO0cqpg8YCgjhIYjixEeRhIHCg" +
       "JEhiI0HbFEaTFKgdtAWal5MYaJ2gTpoOuf9b9wHhCv0Bzs+dOefM+c6cOXM4" +
       "M5/7BnRvGEAVz7XyjeVGh2oWHW6t+mGUe2p4OKLrEykI1TVhSWHIg7oXlWe/" +
       "cO1b3/6Efv0AurKCHpUcx42kyHCdcKaGrpWoaxq6dlrbs1Q7jKDr9FZKJDiO" +
       "DAumjTB6gYbedIY1gm7QxyrAQAUYqACXKsCdUyrA9GbViW2i4JCcKPShfwpd" +
       "oqErnlKoF0HPnBfiSYFkH4mZlAiAhPuL3yIAVTJnAfT0CfY95tcA/mQFfvnf" +
       "ft/1n78MXVtB1wyHK9RRgBIR6GQFPWirtqwGYWe9Vtcr6GFHVdecGhiSZexK" +
       "vVfQI6GxcaQoDtQTIxWVsacGZZ+nlntQKbAFsRK5wQk8zVCt9fGvezVL2gCs" +
       "j51i3SPsF/UA4FUDKBZokqIes9xjGs46gt5xkeME4w0KEADW+2w10t2Tru5x" +
       "JFABPbIfO0tyNjAXBYazAaT3ujHoJYKeuKXQwtaepJjSRn0xgh6/SDfZNwGq" +
       "B0pDFCwR9NaLZKUkMEpPXBilM+PzjfF7P/79ztA5KHVeq4pV6H8/YHrqAtNM" +
       "1dRAdRR1z/jge+gfkR770kcPIAgQv/UC8Z7ml3/gm+//7qde/fKe5jtvQsPK" +
       "W1WJXlQ+Iz/0e28nnm9fLtS433NDoxj8c8hL958ctbyQeWDmPXYisWg8PG58" +
       "dfZbyw9+Vv2zA+gqCV1RXCu2gR89rLi2Z1hqMFAdNZAidU1CD6jOmijbSeg+" +
       "8E4bjrqvZTUtVCMSuscqq6645W9gIg2IKEx0H3g3HM09fvekSC/fMw+CoPvA" +
       "Az0InvdA+7/yfwS5sO7aKiwpkmM4LjwJ3AJ/CKtOJAPb6rAMvN6EQzcOgAvC" +
       "brCBJeAHunrUoIQF7QboBCeSFatwmJR+5ZpqVwp1KQiknJEc4BvBYeF43v//" +
       "LrPCCtfTS5fAAL39YniwwMwautZaDV5UXo7x3jd/7sXfOTiZLkf2i6D3Ai0O" +
       "91ocllocAi0O91ocllocAi0Ob64FdOlS2flbCm32ngHG1QQRAsTOB5/n/sno" +
       "Ax999jJwSS+9BwxKQQrfOoQTpzGFLCOnAhwbevVT6YfEH6weQAfnY3GBAFRd" +
       "LdgnRQQ9iZQ3Ls7Bm8m99pE//tbnf+Ql93Q2ngvuR0HitZzFJH/2oq0DV1HX" +
       "IGyein/P09Ivvvill24cQPeAyAGiZSQBg4JA9NTFPs5N9heOA2eB5V4AWHMD" +
       "W7KKpuNodzXSAzc9rSmd4KHy/WFg438IHRXnpkPR+qhXlG/ZO00xaBdQlIH5" +
       "fZz36T/4939SK819HMOvnVkVOTV64UzcKIRdKyPEw6c+wAeqCuj+66cm/+aT" +
       "3/jIPy4dAFC882Yd3ihKAsQLMITAzP/8y/4ffv1rn/nqwanTRGDhjGXLULI9" +
       "yL8Hf5fA83+LpwBXVOzn/CPEUeB5+iTyeEXP7zrVDcQgC0zKwoNuCI7trg3N" +
       "kGRLLTz2b689h/zin3/8+t4nLFBz7FLffWcBp/XfgUMf/J3v++unSjGXlGIN" +
       "PLXfKdk+sD56KrlTzKxCj+xD/+nJH/1t6dMgRIOwGBo7tYx0UGkPqBzAammL" +
       "SlnCF9rQonhHeHYinJ9rZ3KVF5VPfPWv3iz+1a9+s9T2fLJzdtwZyXth72pF" +
       "8XQGxL/t4qwfgvAA6LBXx9973Xr120DiCkhUQKwL2QAEouyclxxR33vff/m1" +
       "33jsA793GTroQ1ctV1r3pXLCQQ8AT1dDHcSwzPtH7997c3o/KK6XUKHXgN87" +
       "yOPlr8tAwedvHWv6Ra5yOl0f/z+sJX/4v/3Na4xQRpmbLNEX+Ffw537sCeJ7" +
       "/qzkP53uBfdT2WuDM8jrTnnRz9r/++DZK795AN23gq4rR0mjWIReMIlWIFEK" +
       "jzNJkFieaz+f9OxX+BdOwtnbL4aaM91eDDSniwJ4L6iL96unA/58dglMxHvR" +
       "w+Zhtfj9/pLxmbK8URTv3lu9eP0uMGPDMvkEHJrhSFYp5/kIeIyl3DieoyJI" +
       "RoGJb2ytZinmrSD9Lr2jAHO4z+D2saooa3styvfGLb3hhWNdweg/dCqMdkEy" +
       "+EP/4xO/+8Pv/DoYohF0b7mygZE50+M4LvLjf/G5Tz75ppf/6IfKAASij/jB" +
       "5/6yzDao2yEuim5R9I6hPlFA5cqVnpbCiCnjhLou0d7WMyeBYYPQmhwlf/BL" +
       "j3zd/LE//tl9YnfRDS8Qqx99+V/+/eHHXz44k06/8zUZ7VmefUpdKv3mIwsH" +
       "0DO366Xk6P/Pz7/0Kz/90kf2Wj1yPjnsgW+fn/3Pf/e7h5/6o6/cJOO4x3Lv" +
       "YmCja/wQC8nO8R+NrLR5qmQzQXPQyXAd7zASM/lpPGqxQo/Fpk1qVo3XAk7L" +
       "pNBkjXncRXijw7QbcgtFW1EzWTnyZOL5PdwXapyhd2cdqu8LpkBxlt/H+3Mr" +
       "oqiNQM0IwpwTVWtEEYIRocHUovSeD08ZV5u37TYsd9eoWvftyMtq4a7ZROpN" +
       "WFOTrrJTYZejZCaqhrPqMBa3o4DdDvkg8Tx53LOrYJWqye683VFlDoDY1jKp" +
       "WptV9fqkbq9dR1pMbRQV5qKUxphjIIt13ZotbBoVw+ksX/cTZhUtybrk6+36" +
       "uO5H6Gq8FUVhYS/MOU5We2rEUrbj9BN/SUo73lQ6IyzZuj2LkfCRPMzq8XY1" +
       "9jO+O5xMyP4kIdFaqnNegNblXtPHgsQlSMSKqaCP+cF43mTm8dqtRnRP36n4" +
       "zIoXs8XaH3c3nIzt1uxm0K2bTUHTFqkrcsrG7o2RmtolJnQ8RJdLNNVHmRAn" +
       "yNrehLLastt1mmNHjkVWJJNV6+zAHY+WO8KTGsgQXwcLpovy8pbtsetcFAeY" +
       "7+MdJ8dGBD8IZhHB2vPKhukZPrZsRhvcjhd1H9CZWNpSB8ESU7RETmK9MTcj" +
       "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" +
       "2RHE2RsP8Rdu0/ZLRfH5PcSuqkmxtT9qOT6iePedz8tP6UtrfOFurfF28CyP" +
       "rLF8Y6xxUBIcHIP6zgJUWlNKLKGkHNJqZiiSJThGdEzz3O2AExzXK9/K3n79" +
       "Qm+Xjk7/jyQ9ftzb2rUPuyzTyxTVKxbPkvnLRfGlCHqTEqhSpJbGLKq+eGrR" +
       "X71biz4Lnt2RRXdvjEUvH5063mT+3xvqblAufmVy9Jsl/1dvbqPi51dKgj8s" +
       "iv8A0qy9HfbnYTezxn+8W2s8CZ6PHVnjY2+MNa6UBFeOR/zwDr7DRblVLIfF" +
       "LTzVOWOqovj0sZQbt5NSiFAZqdT6i6VO//02s/xPiuJrUXGPzfbim3vZ1+82" +
       "UBdR7MeP7Prjr8euIEX1AjdSFZAg3TGY/a/btH2rKP4igh4CwYwNDGBa6fjS" +
       "xqdPgf7l6wGaRdBjN78MVNxmePw1lxT3F+uUn3vl2v1ve0X4/fI+zMnltwdo" +
       "6H4ttqyzh89n3q94gaoZJZIH9kfRXvnv7+4QjU6uLYG1F5Qlhr8tWS9BEfTM" +
       "HVmjo/Phs4yXj6LkLRgj6Mr+5SzPFZDt3YwHqAXKs5QPRND1i5RAi/L/WboH" +
       "I+jqKR3odP9yluQakA5Iitfr3vHUge9sLhr8ivSjscz2wfrxs95d+sojd/KV" +
       "Mx9m7zz3OVXecj3+9In391xfVD7/ymj8/d9s/OT+vpFiSbtdIeV+Grpvf/Wp" +
       "FFp8Pj1zS2nHsq4Mn//2Q1944LnjT72H9gqfzrQzur3j5hd6erYXlVdwdl98" +
       "2y+896de+Vp5DeD/ARWpn7N+LAAA");
}
