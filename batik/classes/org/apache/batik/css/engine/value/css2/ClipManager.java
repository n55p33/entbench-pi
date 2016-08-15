package org.apache.batik.css.engine.value.css2;
public class ClipManager extends org.apache.batik.css.engine.value.RectManager {
    public boolean isInheritedProperty() { return false; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_CLIP_VALUE; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_CLIP_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.ValueConstants.
                 AUTO_VALUE;
    }
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException { switch (lu.
                                                      getLexicalUnitType(
                                                        )) {
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_INHERIT:
                                                    return org.apache.batik.css.engine.value.InheritValue.
                                                             INSTANCE;
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_IDENT:
                                                    if (lu.
                                                          getStringValue(
                                                            ).
                                                          equalsIgnoreCase(
                                                            org.apache.batik.util.CSSConstants.
                                                              CSS_AUTO_VALUE)) {
                                                        return org.apache.batik.css.engine.value.ValueConstants.
                                                                 AUTO_VALUE;
                                                    }
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
            throw createInvalidStringTypeDOMException(
                    type);
        }
        if (!value.
              equalsIgnoreCase(
                org.apache.batik.util.CSSConstants.
                  CSS_AUTO_VALUE)) {
            throw createInvalidIdentifierDOMException(
                    value);
        }
        return org.apache.batik.css.engine.value.ValueConstants.
                 AUTO_VALUE;
    }
    public ClipManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1ZfWwUxxUfn7+/8BcGQsBgY0hN4C4QaBuZpsHGDqZnc8Xg" +
       "tCZgxntz9tp7u8vunH12SkoitdBWQYiShFSFqhIRtCKAqqZplQaRRmpCk0ZK" +
       "SpumLSRSqpa0QQFVSv+gbfre7O7t3p7vXFd1T9q5vZn35r33e2/ezJs7c50U" +
       "mgZpYCoP8gmdmcEOlUeoYbJou0JNczv0DUhP5tO/7b7Wc0+AFPWTOcPU7Jao" +
       "yTplpkTNfrJYVk1OVYmZPYxFkSNiMJMZY5TLmtpP6mWzK64rsiTzbi3KkKCP" +
       "GmFSQzk35MEEZ132BJwsDoMmIaFJaKN/uDVMKiRNn3DJF3jI2z0jSBl3ZZmc" +
       "VIdH6BgNJbishMKyyVuTBrlT15SJIUXjQZbkwRFlvQ3BlvD6DAiazld9dOvw" +
       "cLWAoI6qqsaFeeY2ZmrKGIuGSZXb26GwuLmXPEzyw6TcQ8xJc9gRGgKhIRDq" +
       "WOtSgfaVTE3E2zVhDndmKtIlVIiTxvRJdGrQuD1NROgMM5Rw23bBDNYuTVlr" +
       "WZlh4uN3ho4+ubv6B/mkqp9UyWovqiOBEhyE9AOgLD7IDHNjNMqi/aRGBWf3" +
       "MkOmijxpe7rWlIdUyhPgfgcW7EzozBAyXazAj2CbkZC4ZqTMi4mAsn8VxhQ6" +
       "BLbOc221LOzEfjCwTAbFjBiFuLNZCkZlNcrJEj9HysbmzwEBsBbHGR/WUqIK" +
       "VAodpNYKEYWqQ6FeCD11CEgLNQhAg5OFWSdFrHUqjdIhNoAR6aOLWENAVSqA" +
       "QBZO6v1kYibw0kKflzz+ud6z4dBD6mY1QPJA5yiTFNS/HJgafEzbWIwZDNaB" +
       "xVixMvwEnffCwQAhQFzvI7ZonvvSzftWNVx8xaK5fQqarYMjTOID0snBOW8s" +
       "am+5Jx/VKNE1U0bnp1kuVlnEHmlN6pBh5qVmxMGgM3hx28+/uP/77K8BUtZF" +
       "iiRNScQhjmokLa7LCjPuZyozKGfRLlLK1Gi7GO8ixfAellVm9W6NxUzGu0iB" +
       "IrqKNPEbIIrBFAhRGbzLakxz3nXKh8V7UieEFMNDKuD5BLE+4psTFhrW4ixE" +
       "JarKqhaKGBrab4Yg4wwCtsOhQYj60ZCpJQwIwZBmDIUoxMEwswckE2mHQKfQ" +
       "GFUSDDvWQtjIejdVISKMIIab/v8SlESL68bz8sAZi/ypQIFVtFlToswYkI4m" +
       "2jpunh141QozXBo2VpysBdlBS3ZQyA6CqKAlOyhkY8faoEc2ycsTIueiDpbv" +
       "wXOjkAMgCVe09O7asudgUz4EnT5eALAjaVPaZtTuJgonuw9I52orJxuvrnkp" +
       "QArCpJZKPEEV3Fs2GkOQtaRRe2FXDMI25e4WSz27BW5zhiaxKCSrbLuGPUuJ" +
       "NsYM7OdkrmcGZy/DVRvKvpNMqT+5eGz8kb4v3xUggfQNAkUWQm5D9gim9VT6" +
       "bvYnhqnmrTpw7aNzT+zT3BSRtuM4G2UGJ9rQ5A8KPzwD0sql9NmBF/Y1C9hL" +
       "IYVzCp6H7Njgl5GWgVqdbI62lIDBMc2IUwWHHIzL+LChjbs9IlprsKm3AhdD" +
       "yKeg2Ag+06sf/+3r798tkHT2jCrPZt/LeKsnT+FktSIj1bgRud1gDOiuHIt8" +
       "8/HrB3aKcASKZVMJbMa2HfITeAcQ/More99+5+rJywE3hDls1IlBOO8khS1z" +
       "P4ZPHjz/wgdzC3ZYOaa23U50S1OZTkfJK1zdIOcpkA4wOJp3qBCGckymgwrD" +
       "9fOPquVrnv3gULXlbgV6nGhZNf0Ebv9tbWT/q7v/3iCmyZNwz3Xxc8msRF7n" +
       "zrzRMOgE6pF85M3FT71Mj8OWAGnYlCeZyKxE4EGEA9cLLO4S7Trf2KewWW56" +
       "Yzx9GXnORgPS4cs3KvtuXLgptE0/XHn93k31ViuKLC+AsNXEbtIyPY7O07Gd" +
       "nwQd5vsT1WZqDsNk6y72PFitXLwFYvtBrASp2NxqQMZMpoWSTV1Y/LsXX5q3" +
       "5418EugkZYpGo51ULDhSCpHOzGFItkn9s/dZeoyXQFMt8CAZCGV0oBeWTO3f" +
       "jrjOhUcmfzz/hxtOnbgqwlK35rjdO+EK0bZgs8oKW3xdnUyBJT5FOcBKn9Mg" +
       "i7OdXMSp6+SjR09Etz69xjpf1KafBjrgsPvMb/75WvDYu5em2HZKuaavVtgY" +
       "UzwyS1Bk2k7RLQ51bra6MufIez9pHmqbySaBfQ3TbAP4ewkYsTJ70ver8vKj" +
       "f1m4/d7hPTPI90t8cPqn/F73mUv3r5COBMQJ1kr1GSffdKZWL7Ag1GBwVFfR" +
       "TOypFKtlWSoA6tCxK5xl43x7V4uVmEU0YdORYhUxUZaDNUcy6Msx9gVsPs9J" +
       "HVSU6jDUHpAvYZsS5UX6wQH93JsYNGGTl+OQ+Mfso/DayB7pYHPkj1YY3jYF" +
       "g0VXfzr0WN9bI68Jh5VghKRg8kQHRJJnu6rGJohLoSVHYZmuT2hf7Tuj3772" +
       "jKWP/xzvI2YHj3794+Cho9YSsYqdZRn1hpfHKnh82jXmkiI4Ov98bt/zp/cd" +
       "CNi4d3FSPKhpCqNqyi95qfPa3HQULV03fa3qp4dr8zth8XWRkoQq702wrmh6" +
       "ABabiUEPrG595IajrTXumJzkrXRS2aex2Wa9b/gvsyh2tOmivzs96O+AZ50d" +
       "uetmHvTZWHME9t4cY6ITFvdc2dyoynHKcfN2oh7HHnQhic8WJMvhabXtap05" +
       "JNlYc5j9cI6x/dhMwPFJxtsIEbtZAJmcBUCqcKwBnjbbqraZA5KNNYfR38gx" +
       "9hg2X4UD0BDjDhKpw3S/vfLxa5fnnXKSL9u3S54VjT9jnmV2YBYgrMWxRni6" +
       "bBy6Zg5hNtYcMB3PMfYdbI6lQ9gDuUoQL+CkWpy48HIoaF0OuQg9NQsI1eDY" +
       "UngitpmRmSOUjTUHCmdyjJ3F5pSF0CYWowmF92HN7yB0x/S3Ay69AO70bAG3" +
       "CJ4HbOsfmDlw2Vh94ASEIgHH/tvR/vG7JWG2SaVgmCVliSo7VJk7NMtzYdTe" +
       "29sh3oSKz/ukORuuPdMCR1pUiwc3be3uSEpMxzOlYH4Rmx9xUi4ZDKpKgTt2" +
       "nXfBf262wG+CZ8RGcGTm4Gdj9cGRLxTJny7DFUKpZWTJcdh+F5sL4vX1qQHH" +
       "nz8TBL/G5hInNRaoVhqYCtpf/C+gTYL3PBdpWPUtyLjCt66dpbMnqkrmn9jx" +
       "lih1UlfDFXB0jSUUxXPk8h6/inSDxWRhWYVVKevi6wonK/6ziz5OCvBLWPAH" +
       "i/ldThqnZQa3jKUygc34nr2AsjByUmS9eHn+BKeiqXhgY4PWS/k+JHA/JWgh" +
       "vr10H3BS5tKBUOvFS/IhzA4k+HpDd1bj6ukB2wZFuu3LZF5mQS4Cp366wPHU" +
       "28vSigzxH5BzCk9Y/wINSOdObOl56OYnn7ZuxySFTk7iLOVw9rbu4FLlZmPW" +
       "2Zy5ija33JpzvnS5UxSk3c55dRPhCwtH3GQt9F0Xmc2pW6O3T2648MuDRW9C" +
       "ObOT5MFardvp+QfG+ruhNaknoM7fGc6sMaA0F/dYrS3fmrh3VezD34u7DmLV" +
       "JIuy0w9Il0/t+tWRBScbAqS8ixRCvcOS/aRMNjdNqOCkMaOfVMpmRxJUhFlk" +
       "qqQVMHNwdVFc+QIXG87KVC9em3LSlFmWZV42lynaODPatIQaxWmgBCp3e5xr" +
       "h7SKPaHrPga3x1OJMisHojcgWAfC3bru3DkWlOkiv8SypsS8fPGKbwX/Buub" +
       "l0MfHgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
