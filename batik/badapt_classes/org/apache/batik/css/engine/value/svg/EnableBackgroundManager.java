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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "8z+jBb5DYCQAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Yy90ohXMlaKjZBLmlqfaT+c9+0n++s1w9tzZUHOi27OB5nhWgO85dP5+6Uxs" +
       "eTzX8gvwQQ5jC3I2tpwrFS8fKVBeLsprefHBI1d+xA89ALlUlYL2a6D0qBea" +
       "cIrcq/uOYzYNTQcGneQwM0LeuPp16yf+9Of3Wc/ZAToDrH7mxt/8i4PP3jh/" +
       "Itd8/zvSvZM4+3yz4PI9Bau5yb98p14KjP6ffPmNf/KP3vj0nqurpzMnAi4M" +
       "fv7f/O/fPfjCH//2LSbjB2BWvI/OeVnPi/beppu3tf/re97OQd1eqB1gB5X8" +
       "e3pr/T+Qv/4lGE+jYnUAMTTTleyjkXh6Y8vXjiKoAFcLcESubWysIPM+uD4q" +
       "fDc3tYN9in2G19f+n3mFmnz8mNjIg9n6j/6nz/3u337/16FW6NKFIvGA6jvR" +
       "4zjOFzCfeuvzzz96449/tJgeoEEJH3/1vxfp4A/eSeK8mOcFfyTqs7moXJGJ" +
       "jaQIMEUUV5Wb0vZPyEMDOBd49yAtuJIN0IhqH/0YQeqJqZyxojppyUhrXVYW" +
       "yGhDU+jcMTpxeebYW4rgJrtVNmGUeEDQmenXszrIGhZWV1YLbTL1VKfDsZTo" +
       "OZQfS6495II+Pat0dVbw15w564bEtDq3/VSQCMkTA5YbUkN/GKRDG2vV43qC" +
       "yZta7AvmFKgk4iRzLdG0KfxXdxPN6gzXClOJqMogZuadcGwu2DDxm+s+4VcC" +
       "IO1ApSdH9WqVRHbrCgbWIy9gTWvMTfkALHxjHQq+KUXtNc1b4m4yFqyVU7VH" +
       "FCEjnLRzejYZS3So1zh1mYhWTxDZvtIM6UznsGHHcXssu7OqNs2MV5vtpG01" +
       "haxCzDjH0tdpawpkgQqbLYlgMWzG4phPVgZD0FMXGW9vtJ6seNUhOWx6vLDd" +
       "qe5mQatLKZ4HLO/KytKOlFrQkFGC3NKLBjWYqaDXY3GYeyueh3b0HuAr7izZ" +
       "hWSdqQA+sz1z3gnKda4m+M10ve0JlEjv+PLSwiQ0blqElQapxMWARQWpjwwA" +
       "sW3ymebIfYUzOHIz87dRt+1lAeHON75R9uZjKpgMJ9iSWoX9mhrhUo2JEGLS" +
       "Ks/puKVKSZaRorWk27Xh2OsF22GbMCoW2Ra64sAhHTAn2SVldyrBvLPUWynf" +
       "JIMIKKumuBpxosOvar3GQjBTpsakfGvnL2eLsDuSVuTKDVdRs+UP2l6jqjT4" +
       "gPejgVheNQFYzrWajg6Ermk4tOmirsxsJbRs0nNj1Y/XVE0xamO23ZZqotQS" +
       "CHyM89GGpwbSeqWwQ0HiDK9dxcfcrB/EejqR3G4aDA0uGwdmy2iul8zAt8wh" +
       "pg30YVCbUdRq0regkTAcRQuiwUq0gjS1Uaeatog1kKuSTbDtRsrNBYVDOr4h" +
       "zazdWqSHq95U6uwEExu76MLVkKXO6caslyYsuZtPp6NqVFVjaefiIVHbxe3O" +
       "uN4yYjoZG2XVoBAZjCZAkQVvFQgdp+mrPbOzTRdxc6eRojsljY7RiGULdXrM" +
       "YL7FMdUN15uwU/fKXNNocJQKAlqvlqvdeSjxY9ZZWEKlYdATPqlYY5vh6tyw" +
       "xTa4ropDtx7X1tXWVpoP1FlN8r0AdPtYq+OZHDWjzAAV6qwVhtjabpeHoLnr" +
       "mKRFwD66LVxaJq25trMyv0/gO24W8JU6qwxdrTrulzl0SDHpaLmxvA06FTCa" +
       "SKbOpNu1nKZDt/0ywwRyW7G7NWPu0VSVHcuMJW1TWxHtCkvyCtphfL6Fe6bQ" +
       "DPTFZMlosxaKtNJVtsqg2Kopt7nRzBp0O4ta1Vkp83lnJ9IYoww4RVv00I6S" +
       "NGSGQbsDejuRdDbCRao7F0yPWDOCyThVyuyQIWFKfodimbTcx8XMnU1ERW8R" +
       "3eWGA2JEhqC8bVY6IbkwbWaOjqq6QIvpdBWAyYgmMXTQWE3HigYWi4GTmupm" +
       "BXPBcX+yWjXN4VZUN85ymNIxnikuBrqTWTZqVCK8yc931MQZhQzBjsamJIss" +
       "H4hThp1iE2j3VrntTPCdyCd9nq92EDkJ1NYK1LXppDukLJJJjYk4wzo93MUY" +
       "FYMOANaTAcVbIE4RvDad47XqHFFMrtu245VV2WRjILXrGJuZ6nLhAjkJ0xY5" +
       "xWr6PIq2A1JO/Ul7Qu7oeTaAYbwalwl1LVldvTFpOtIy6IXWUkDGLJ8hddWb" +
       "b8YOsdshK0MZkjMdet2i19AHA2wj1MsNsdvzaZ8nFzs+TQcmBhfJRkQu2cj3" +
       "Whs8ixl9VVnj9TmCV7ApbiI8pm/4YRqNSehLfmWWkp1qm+mvXaxu7NbadDCo" +
       "gGZopUZlq5JLsjvsgsjRogZCJe1WDW8xU0M3shrhbGKFG+mtfuqN3YFT9bOI" +
       "YFmx2+n5g9qOl+IhyQmDrotqWAOQA8GYIQgudjeJkgb4aKNGTiNoCxgyYeuW" +
       "b8AZBhBmRrDWnPFUzWiuBqrrqjRVd0xJmfVq2zFW3uKDZFphJjNm25mILV+l" +
       "LSohFvosWnYX3W4aE5N6szI27dpwu0V6qFonpDLq2MsknlQ3Zb+mTeeoKPVB" +
       "NA23YT1KxooPRhi9aHOrkK6gc67NoxOAtBWLEJW+PuvZ3DqYQ20BSasnQZVN" +
       "FhV61wMUkYYztFsrWynlAqc93Ll8YyUi5bI4b9VVfEFIZl1iparomA7qjdma" +
       "1PN347A/oeNqstna66WKVhezcdtrcZ1GV2VraDeKhmENX9Tijslq6/Ka6U/H" +
       "RorJloT64mAk0ttRRERdQljyZYA6U2QQ+OtWA/drWBZXuSVfz7adtSkiZjJ1" +
       "F5a9QcpMDVdYyCvPSES5rdoWDHLNcGdq8iDpsJq1jhLH37aoSgdLWE7jNLRc" +
       "EzapQK/Ent/v17pxpDhw0l2keJcRnUZ1DntBB9mS7HtCZQBitdugO7ulNp6Q" +
       "aSNYjGNCCTQSH8VcD1+bxEjrUBsdHy7ZMkNMyS277kb9uCKtx1KjIoq1perJ" +
       "gOToNdGMWtS2SThUI1D6446yVhb+uG1HAjP226uIa2+GjkNZzniyXNgsssUa" +
       "s36CwEnSdfuTdipJa6W6bWqyFsbVFs+s9aFcbtSqdV9jvYWMUQnYKBtCZiZC" +
       "a9SdTcGw3Ai1en2qxW1sWV4u5CEMUT0LR8rTwSqteM0xDvrGSsCqGEwzN2nL" +
       "wASJdywhVaZIozpqDDZlZL2uJdDEt0Rc7sp4q5NM61GmRC3NNcFMbPD+LiGm" +
       "eF22wA5xOwFZ6ylhJVyutPq4L1f1Og1QhV/N57ah70JuNldCMBpupmaKo6jl" +
       "mlHTd4gJanLbvjfsuUI5Q1iqJuBABVJ/JjOeKPN+a6ogOzYhE8/idFzmN7qp" +
       "J6PFMiJ0XUvExZYbjhJEjzfzsIn2kmW7itZ3wnxNCnTZI/0Z3yVrOGr2vGzp" +
       "1Js6gjdVBQRLzK9S9WV1R/dXSxOxW4Mg3Nbjba0vuKFrJ/xiHWYbZbyscHLf" +
       "ovx1jxogoqpNmkFVGxpBb1Ot6UQE0y95RXrTslWubtUOGqY8vnKEeKFquhrU" +
       "yBVW24Vx0kvlZOcri+WWIdqCUOsCnsWXNL/c1tq9DGcaJhA3mzk919dtypZi" +
       "1DLazKJO1pgEW2FuggxNVaCwIGaCoK9se+UB4zcnFSqJuGnZrHPjAVsjm+OW" +
       "Ykxp2c9QAwOIPxMcBsxYGTSWyxqKjGFQpXhpO3b8oQOzRaJfiWQSkfV4AQ2v" +
       "b/XnqLIRWlqF4lxSjEbRbLsg6ZBsDHiP6KhInx2nSTvadMhZ12rLairERhZO" +
       "gtXU7PVFIloiS4Zb7hCiYTc90J8wccVEK+KoPStPMQbtkAzaBPpQ0xjJRsqO" +
       "DoWvGi3Z4pYpbsrbLZXZEuV7NEpx6tizwkG6oZ36zmh2OzWtveQkGXrgdCw3" +
       "VzaKaUtuGK1WbVQhuCWKG60qs/b4SsTNJ8FiIWJduoLhqsixWxgVapyj96Pu" +
       "rtHZIEqvonMJSeqUC/MzOk6WCZskg1FD6tdYSVjWSVEQuWARMH59KKyEWbDZ" +
       "eWRnlBCOMEjLYxqs+U3A9cNgR2tsZd0fa+uqIq70pThYjhpVXG91ZnK/JnI8" +
       "gxKYsqkbuoZU5tRA60Y46HnD+pxFWssATrhMQFCOMK/OFrbcS+utsg9jumUp" +
       "A4tyGhrRrEa2Nm0p6zGm+4xLVlC0bQgdHGpglol6o8m3d5NFlTcxGMsdt6WK" +
       "q6FET4K5B2C8njejUXuAtsqLjjwY1EbpIFIEErCJ3Z+NqsjK6iqc1TKyqtWz" +
       "WlqVHEbUOgqNLiVgUXM8Z4leJzEJM+YlDTop0ei5vqIzcX8kcZbdIaTtouvU" +
       "1BnBmJY6mgwkl9hZrYYW2yOy4XYr6nDnSF7Xjqa7hJpu4PhEMxFPu6o/jOhl" +
       "CjCXqPWzqLkxfSPbLRp4LVMZfUPSgyaS8kuRR8X+1J3podrtIpNyW0m0kcoP" +
       "NjuWH80NuKpJzDqdYMDWRzRuWKy9wPGqVMbTsLci7D7at8N6bUjH6IiyTJvj" +
       "4+aaoJTZZLsK3MgwnTq/orexs6J4j1HXjkarWZV3BJbVG8G6oyG9bYh2jbnZ" +
       "1ngdrKblGU/Rtf6wQoxauDJRsopTZVN1XjPxsmUYVCejW/Ysq9cr9jzNxMGi" +
       "vuNFOY4SjRHLWLWDDY0Gv3NYrNKwV2o7niWp2040lSKnyBiljbLCsSMBJNNp" +
       "0i+XawmN0UO83OgP50LGOzbiZf1uS20YrND3Q7gi2olROVjgHm6Gddtcp7gs" +
       "JU69Y5sT1+RaqlmZyESwrdcFdTD2skjVynY74wBLAJumjPmk3Et261qwY6Ol" +
       "xdU1slVDGMXuzLWJ4i3q0yTrLELLQMoLsO1bWLpu9Xo4HEopUoE2Xc9TiYj5" +
       "6pSbyZYwioZbdAbQiidWNy1fb3ATjw+20WjoUbwhBZ0mZjTr/QrPY/U2nFh3" +
       "I6COXJxHJbmGmPIOIfsOaMZTBmM6440zCtBgTjax/oJ2WdzakQxBTRcozOEB" +
       "0NYcHOg2nlUn40ZITtB6IDgcJY7G/HiwpXHKWCQkaO3Km8660Vt2Z+12+8Mf" +
       "zrcg9He3NfJEsQt089R1Y2N5g/gudj/2TS/nxas39w6L38U7nEuc2Lst5Vtt" +
       "z9/uMLXYZvvSJ2+8qUx+qnr+cM97CEqPAM//y7aaqPYJUo9CSh+6/ZYiU5wl" +
       "H+/F/uYn/+uz8x8wPvYuTptePMPnWZI/w7z12+QH5L9zvvTAzZ3Zd5xyn0a6" +
       "fno/9lKogjh056d2ZZ+/qdknc419AD7ooWbRW5/43HpLtrCC/djf4UjhjTu0" +
       "/XBeZKD0pBlRrqGGJlCVaegV9wZutZn20NrzbFVyj41pe7ettJNdFhXxaek/" +
       "WDo8+Dr6v7/S/607tH02Lz4NSu81o7ZrOhLIz4KOxM/bPnEs52fuVc5X4dM5" +
       "lLNz/+X8wh3a/n5e/BgoXTXzSyTFnvdtpLxxD1JezivzEwbqUErq/kv5pTu0" +
       "/XRe/ANQuqyr4Ei8I7+jjkX8yXsQ8Wpe+TJ8pociTu+/iF+5Q9sv5sXPnRZx" +
       "fBhsxGMR37oHEYt4/xJ8xEMRxfsv4j+9Q9uv5cUv70XsqZoU2/vjsqODjA/e" +
       "/dLDMXyhjV+5V208B5+PHmrjo/dHG+cLgPNHQn1vLlRalwtZIkk+GKmZKUs2" +
       "D9erRzCv3knwLscRxVvR21fP9Hbu8AbHIaVnjnpTPOegN2GITFb9fKYskP9V" +
       "Xvw6KD0qh6oE1EKZedXbxxr9jXvV6Cvw+dShRj91fzT6wD4xutWkdSEyvLA4" +
       "nCsyoX9R4P/7O9jgf8iL34fp1F4F+wOzWyniD+5VEXksuXGoiBv31bTyzz+8" +
       "pTY025NAgfqNW9tJ/vm1AuBbefGfQenKXhH9HPNWeviTe9XD8/D54qEevnh/" +
       "9HCxALh4ZPQHd3EfDmztfPrP75Oq7glryQvqiMq1O1HJSaiMVHD9dsHTn9/e" +
       "yM4VIv4ZyG9kOn58a0f7zr3OVS/B56uHev3qu9Vr726B/NylO7Q9lhcXQOlx" +
       "GMgnx9cEjtWZS3ju4ruRECaqT9/mNlt+HeeZd1y03V8OlX/hzcsPP/0m//vF" +
       "ha6bFzgfGZUehut+++TtiRPvF/1Q1cxCBY/s71L4hVxP3iUU37x4B2A0SooF" +
       "3Lmre9SnQOnlu6KCwyP0k4jfczhF3AYRlC7uX07iPAfz2lvhQLZgeRLyRejg" +
       "ZyEhF8X/SbhXQOnSMRzsdP9yEuRVSB2C");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("5K8f8I+cBrm7ukbwCxiHY5ntZ6pnTtp14Q5X72YsJ5ag7z+1cCxuah8t8uL9" +
       "Xe3X5S+/SY9/6NvNn9pfmJNtabfLqTw8Kj20v7tXEM0Xii/fltoRrYuD1777" +
       "+FceefVoUfv4nuFjHzvB24u3vpFGOD4o7pDtfuXpf/z9//DNPypuSvxfqNGA" +
       "gEIvAAA=");
}
