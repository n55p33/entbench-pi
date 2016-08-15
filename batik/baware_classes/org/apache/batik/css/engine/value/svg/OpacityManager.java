package org.apache.batik.css.engine.value.svg;
public class OpacityManager extends org.apache.batik.css.engine.value.AbstractValueManager {
    protected boolean inherited;
    protected java.lang.String property;
    public OpacityManager(java.lang.String prop, boolean inherit) { super(
                                                                      );
                                                                    property =
                                                                      prop;
                                                                    inherited =
                                                                      inherit;
    }
    public boolean isInheritedProperty() { return inherited; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return true; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_NUMBER_OR_INHERIT; }
    public java.lang.String getPropertyName() { return property; }
    public org.apache.batik.css.engine.value.Value getDefaultValue() { return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                                                                                NUMBER_1;
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
        }
        throw createInvalidLexicalUnitDOMException(
                lu.
                  getLexicalUnitType(
                    ));
    }
    public org.apache.batik.css.engine.value.Value createFloatValue(short type,
                                                                    float floatValue)
          throws org.w3c.dom.DOMException {
        if (type ==
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_NUMBER) {
            return new org.apache.batik.css.engine.value.FloatValue(
              type,
              floatValue);
        }
        throw createInvalidFloatTypeDOMException(
                type);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL0ZaWwc1fl5fca3ncvkcC4nURLYDUfSggnFcezEyfpQHCLh" +
       "AM7b2bfrSWZnhpm39johFBAooVURpCGkFaQ/GgRFQGhVRKsWlJaWQ0AljhZo" +
       "xaEWqbQUlagqoKaFft97MzvHetey1HSleTv73vd977u/97199GNSaVuknek8" +
       "yidNZkd7dD5ELZsluzVq27tgblS5r5z+44YPBy6PkKoR0jhG7X6F2qxXZVrS" +
       "HiGLVd3mVFeYPcBYEjGGLGYza5xy1dBHyFzV7suYmqqovN9IMgTYTa04aaGc" +
       "W2oiy1mfQ4CTxXHgJCY4iXWFlzvjpF4xzEkPvM0H3u1bQciMt5fNSXN8Hx2n" +
       "sSxXtVhctXlnziLrTEObTGsGj7Icj+7TNjgq2B7fUKCC5U80fXru7rFmoYLZ" +
       "VNcNLsSzdzLb0MZZMk6avNkejWXsG8nNpDxO6nzAnHTE3U1jsGkMNnWl9aCA" +
       "+wamZzPdhhCHu5SqTAUZ4mRZkIhJLZpxyAwJnoFCDXdkF8gg7dK8tFLKAhHv" +
       "XRc7dt8NzT8qJ00jpEnVh5EdBZjgsMkIKJRlEsyyu5JJlhwhLToYe5hZKtXU" +
       "A46lW201rVOeBfO7asHJrMkssaenK7AjyGZlFW5YefFSwqGcX5UpjaZB1nme" +
       "rFLCXpwHAWtVYMxKUfA7B6Viv6onOVkSxsjL2LEDAAC1OsP4mJHfqkKnMEFa" +
       "pYtoVE/HhsH19DSAVhrggBYnC4oSRV2bVNlP02wUPTIENySXAGqWUASicDI3" +
       "DCYogZUWhKzks8/HA1fedVDfpkdIGfCcZIqG/NcBUnsIaSdLMYtBHEjE+rXx" +
       "43Te00cihADw3BCwhHnqprNXX9h+5gUJs3AKmMHEPqbwUeVUovHVRd1rLi9H" +
       "NmpMw1bR+AHJRZQNOSudORMyzLw8RVyMuotndj537S2PsI8ipLaPVCmGls2A" +
       "H7UoRsZUNWZtZTqzKGfJPjKL6clusd5HquE9rupMzg6mUjbjfaRCE1NVhvgN" +
       "KkoBCVRRLbyrespw303Kx8R7ziSEVMND6uFZReRHfHOSjo0ZGRajCtVV3YgN" +
       "WQbKb8cg4yRAt2OxBHj9/phtZC1wwZhhpWMU/GCMOQuKjbBp4Ck2TrUsi9nj" +
       "6dggQKh8sp/q4BNWFB3O/P9tlUOpZ0+UlYFBFoXTgQaRtM3QkswaVY5lN/ec" +
       "fXz0JelqGB6Ovji5DHaPyt2jYvco7B6Vu0fF7lHYPRrcnZSViU3nIBfSA8B+" +
       "+yETQCquXzN8/fa9R5aXg+uZExWgfARdHihJ3V66cHP8qHK6teHAsncvfjZC" +
       "KuKklSo8SzWsMF1WGnKXst8J7/oEFCuvZiz11QwsdpahsCSkrGK1w6FSY4wz" +
       "C+c5meOj4FY0jN1Y8XoyJf/kzImJW3d/fX2ERIJlAreshAyH6EOY3PNJvCOc" +
       "Hqai23T4w09PHz9keIkiUHfcclmAiTIsD7tFWD2jytql9MnRpw91CLXPgkTO" +
       "KdgecmR7eI9AHup0czrKUgMCpwwrQzVccnVcy8csY8KbEf7aIt7ngFvUYWBe" +
       "AM8GJ1LFN67OM3GcL/0b/SwkhagZm4bNB976zV8uFep2y0uT71wwzHinL6Uh" +
       "sVaRvFo8t91lMQZw75wY+va9Hx/eI3wWIFZMtWEHjt2QysCEoOY7Xrjx7ffe" +
       "PfVGxPNzDjU9m4CjUS4vJM6T2hJCwm6rPH4gJWqQK9BrOq7RwT/VlEoTGsPA" +
       "+nfTyouf/NtdzdIPNJhx3ejC6Ql48xdsJre8dMNn7YJMmYIl2dOZBybz/GyP" +
       "cpdl0UnkI3fra4u/8zx9ACoGZGlbPcBE4o0IHUSE5G1wQhOYWH2jsvoGkwAG" +
       "2nA2YUPAqhmwz7hT3C4Z2qsc6Rj6QBauC6ZAkHBzH459a/eb+14W1q/BlIDz" +
       "uHeDL+Ahdfhcr1la5Uv4lMHzBT5oDZyQRaK126lUS/OlyjRzwPmaEmfLoACx" +
       "Q63v7b//w8ekAOFSHgJmR45948voXcekSeV5Z0XBkcOPI888UhwcOpG7ZaV2" +
       "ERi9fz596GcPHzosuWoNVu8eOJw+9rv/vBw98f6LU5SI6oRhaIzKPHYZ+nk+" +
       "q88J2kcKteXOpp/f3VreCwmlj9RkdfXGLOtL+qnCkc3OJnwG885SYsIvHhqH" +
       "k7K1YAcxvUGwsT7PDBHMELG2HYeVtj+vBs3lO5WPKne/8UnD7k+eOStEDh7r" +
       "/Wmkn5pS3y04rEJ9zw/XvW3UHgO4y84MXNesnTkHFEeAogLV3R60oATnAknH" +
       "ga6s/v0vnp2399VyEukltZpBk71U5G8yCxIns8egeufMr10t88ZEDQzNQlRS" +
       "IHzBBMbukqmzQk/G5CKOD/xk/o+vfOjkuyKBmZLGQieI4UARKNiiOfRqxiOv" +
       "f+W3D91zfEK6U4ngCOG1/WtQS9z2x88LVC5K5BTxEsIfiT16/4Luqz4S+F6t" +
       "QuyOXOEhCOq9h3vJI5l/RpZX/TpCqkdIs+I0Y7vxiAMVYAQaENvt0KBhC6wH" +
       "mwl5cu7M1+JF4YD1bRuukv4YqOABf/cKYyOacCk865yasS5cGMuIeLlOoKwW" +
       "41ocLnLr0CzTMjhwyZKhUtRQgiygqfoY9ICAhhNXyPqL4w4crpe0Boq65O6g" +
       "CO3wrHf2Wl9EBHk0WI3DaCGnxbA5lHXLEH0o/t4YYjRVgtGct+G6/IbiU0VC" +
       "TYO/SnvBQTADLC7W14lse+q2YyeTgw9eHHHy0mbQLDfMizQ2zjQfqRqkFIiz" +
       "ftHJek77TuPRP/20I715JmdinGuf5tSLv5dAxKwtHrphVp6/7a8Ldl01tncG" +
       "x9slIS2FSf6g/9EXt65SjkZE2y6jqaDdDyJ1BmOo1mI8a+nByrEib9fZri03" +
       "OXbdFHZDz3NCLpE/uBVDLVGHbiqxdjMOE5zMVu0+N9iGfL58hefGuenirXQJ" +
       "wIldppi3gxpZDc8WR6wtM9dIMdQSUt9ZYu2bONwOfZhqd+lqhnI8rxZRyR3n" +
       "SyUr4dnhyLVj5iophlpC7OMl1k7gcA+UHRXv58RRrohCjp4HhTThGibvnY5U" +
       "O2eukGKoJYT+fom1B3E4CQezNOOuJvKN5Vdx6JTSbfK9d3FSrjr3rb5zK/7c" +
       "mvNU+L3zoMJWXFsGz7WOHq6duQqLoZZQ05Ml1p7C4YmgCgecTLrR08YPz4M2" +
       "WnBtKTx7HZH2zlwbxVBLSPzLEmu/wuFpqY0tLEWzmjzque3r6unvxTx4obhn" +
       "zpfiFsGTdqRPz1xxxVBDygm17wtR/olLFSG2TZVonOVUhWrX6Cp3YVaW0lH3" +
       "8HCPeBMsvhrazW0hHUpt7m5JIxPdMtjfk1OYiYcLgfwmDi9zUqdYDFpyoXec" +
       "es5T/ivnS/kYwwcdDR6cufKLoZZQfolsVgk9oVUqn5XCTUGHWQRXCPLB1CbC" +
       "n28JgE9weI9D7yTM0Iv0prLF+/8LW+Q4aQxeOmNL21bwp5f8o0Z5/GRTzfyT" +
       "17wpzsn5P1Pq4cSbymqav+nyvVeZFkupQrZ62YKZ4uvzaVw7fy0O9QVGIcJn" +
       "EvUcJ8umRQVjjOdzh4P4hRNyRRA5qZIvPpwy6PPmTIUDbMHoh6wAq4UhgQvx" +
       "7Yer5qTWg4NN5YsfpBaoAwi+1plu/G6cXl1dCZtb0MAIj3FMmisL9lV5F5o7" +
       "nQv5WrEVgRZG/HnqthtZ+ffpqHL65PaBg2c3PijvihWNHjiAVOripFpeW+db" +
       "lmVFqbm0qratOdf4xKyVbnPXIhn2csFCX5nZBRFkoucuCF2k2h35+9S3T135" +
       "zCtHql6LkLI9pIxCa7Cn8LYhZ2ahV9wTL7xwg/ZO3PB2rvnu5FUXpv7+B3Gf" +
       "Q+QF3aLi8KPKGw9d//rRtlPtEVLXRyqhb2U5cQ2yZVLfyZRxa4Q0qHZPDlgE" +
       "KirVArd5jRhkFC92hV4cdTbkZ/GfBk6WF15mFv4/U6sZE8zabGR1ce3QAO2l" +
       "N+O2roGuL2uaIQRvxjEljr0yBaI1wGtH4/2m6d71VrSZItNsnTojonu3i1d8" +
       "W/JfhhdKAlghAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "T8oT1P8LPxGEMgYsAAA=");
}
