package org.apache.batik.css.engine.value.svg;
public class FilterManager extends org.apache.batik.css.engine.value.AbstractValueManager {
    public boolean isInheritedProperty() { return false; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_FILTER_PROPERTY;
    }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_URI_OR_IDENT; }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 NONE_VALUE;
    }
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException { switch (lu.
                                                      getLexicalUnitType(
                                                        )) {
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_INHERIT:
                                                    return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                                                             INHERIT_VALUE;
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_URI:
                                                    return new org.apache.batik.css.engine.value.URIValue(
                                                      lu.
                                                        getStringValue(
                                                          ),
                                                      resolveURI(
                                                        engine.
                                                          getCSSBaseURI(
                                                            ),
                                                        lu.
                                                          getStringValue(
                                                            )));
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
                                            }
                                            throw createInvalidLexicalUnitDOMException(
                                                    lu.
                                                      getLexicalUnitType(
                                                        ));
    }
    public org.apache.batik.css.engine.value.Value createStringValue(short type,
                                                                     java.lang.String value,
                                                                     org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException {
        if (type ==
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_IDENT) {
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
        if (type ==
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_URI) {
            return new org.apache.batik.css.engine.value.URIValue(
              value,
              resolveURI(
                engine.
                  getCSSBaseURI(
                    ),
                value));
        }
        throw createInvalidStringTypeDOMException(
                type);
    }
    public FilterManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "/sreCv8DJWk2OSseAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1aDewsV1Wf92/72j7avtcWSi397itYtv5nd2c/KSC787Wz" +
       "MzszO7M7s7sij9mZ2fnY+dr52J1dqAJGqRKBaIsQodEEgpJCiQElMZCqQSAQ" +
       "FUNUTKREjYJAoBrRiIp3Zv/ffe81TRv/ydz/3XvPOff8zj333DP3zhPfg66K" +
       "QqgQ+M7acPx4V0/jXdup7sbrQI92u0yVV8JI11BHiaIBaLug3vvJsz/80XvN" +
       "czvQ6Ql0s+J5fqzElu9Fgh75zlLXGOjsYSvu6G4UQ+cYW1kqcBJbDsxYUfwQ" +
       "A73kCGsMnWf2VYCBCjBQAc5VgFuHVIDpet1LXDTjULw4WkA/B51ioNOBmqkX" +
       "Q/ccFxIooeLuieFzBEDCNdlvCYDKmdMQuvsA+xbzswA/VoAf/Y03nfu9K6Cz" +
       "E+is5YmZOipQIgaDTKDrXN2d6mHU0jRdm0A3erquiXpoKY61yfWeQDdFluEp" +
       "cRLqB0bKGpNAD/MxDy13nZphCxM19sMDeDNLd7T9X1fNHMUAWG85xLpFSGTt" +
       "AOAZCygWzhRV32e5cm55WgzddZLjAON5GhAA1qtdPTb9g6Gu9BTQAN20nTtH" +
       "8QxYjEPLMwDpVX4CRomh2y4pNLN1oKhzxdAvxNCtJ+n4bRegujY3RMYSQy87" +
       "SZZLArN024lZOjI/32Nf++63eB1vJ9dZ01Un0/8awHTnCSZBn+mh7qn6lvG6" +
       "VzPvU2757CM7EASIX3aCeEvzB2995g0P3vnUF7c0r7gIDTe1dTW+oH54esNX" +
       "b0cfaF6RqXFN4EdWNvnHkOfuz+/1PJQGYOXdciAx69zd73xK+NPx2z6mf2cH" +
       "OkNBp1XfSVzgRzeqvhtYjh6SuqeHSqxrFHSt7mlo3k9BV4M6Y3n6tpWbzSI9" +
       "pqArnbzptJ//BiaaARGZia4Gdcub+fv1QInNvJ4GEARdDR7oOvC8Ctr+5f9j" +
       "aAabvqvDiqp4lufDfOhn+CNY9+IpsK0JT4HXz+HIT0LggrAfGrAC/MDU9zrU" +
       "KKM1gE7wUnESHY6WBkxYDnCnnuIBlwh3M38L/t9GSjPM51anToHpuP1kMHDA" +
       "Our4jqaHF9RHkzb+zCcufHnnYHHsWSuGEDD47nbw3XzwXTD47nbw3XzwXTD4" +
       "7rHBoVOn8jFfmimxnX4weXMQBkCAvO4B8We7b37k3iuA3wWrK4HlM1L40nEa" +
       "PQwcVB4eVeC90FPvX71d+vniDrRzPOBmioOmMxk7n4XJg3B4/uRCu5jcs+/8" +
       "1g+ffN/D/uGSOxbB9yLBszmzlXzvSROHvqprIDYein/13cqnL3z24fM70JUg" +
       "PICQGCvAjiDa3HlyjGMr+qH96JhhuQoAnvmhqzhZ135IOxObob86bMnn/oa8" +
       "fiOwcQPaK475fNZ7c5CVL936SjZpJ1Dk0fd1YvChv/mzbyO5ufcD9dkjW5+o" +
       "xw8dCQ6ZsLN5GLjx0AcGoa4Dur97P//rj33vnT+TOwCguO9iA57PShQEBTCF" +
       "wMy/+MXF15/+xoe/tnPoNDHYHZOpY6npFuSPwd8p8Pxv9mTgsobtwr4J3Ysu" +
       "dx+ElyAb+ZWHuoFA44AlmHnQ+aHn+po1s5Spo2ce+99n7y99+rvvPrf1CQe0" +
       "7LvUg88t4LD9J9rQ2778pv+4MxdzSs02ukP7HZJto+fNh5JbYaisMz3St//l" +
       "HR/4gvIhEIdB7IusjZ6HMyi3B5RPYDG3RSEv4RN95ay4Kzq6EI6vtSMJyQX1" +
       "vV/7wfXSDz73TK7t8Yzm6Lz3lOChratlxd0pEP/yk6u+o0QmoKs8xb7xnPPU" +
       "j4DECZCogsgWcSGIP+kxL9mjvurqv/2jP7nlzV+9AtohoDOOr2iEki846Frg" +
       "6XpkgtCVBj/9hq03r64BxbkcKvQs8FsHuTX/dQVQ8IFLxxoiS0gOl+ut/8U5" +
       "03f8/X8+ywh5lLnIPnyCfwI/8cHb0Nd/J+c/XO4Z953ps2MySN4Oecsfc/99" +
       "597Tn9+Brp5A59S9zFDKIi5YRBOQDUX76SLIHo/1H89sttv4Qwfh7PaToebI" +
       "sCcDzeFeAOoZdVY/czjhD6SnwEK8qrxb3y1mv9+QM96Tl+ez4lVbq2fVnwQr" +
       "NsozTMAxszzFyeU8EAOPcdTz+2tUAhknMPF526nnYl4GcuzcOzIwu9s0bRur" +
       "shLZapHXa5f0hof2dQWzf8OhMMYHGd+7/vG9X3nPfU+DKepCV+UbGpiZIyOy" +
       "SZYE/9ITj93xkke/+a48AIHoI73t/u/nKQV9OcRZgWUFvg/1tgyqmO/rjBLF" +
       "vTxO6FqO9rKeyYeWC0Lrci/Dgx++6en5B7/18W32dtINTxDrjzz6Kz/effej" +
       "O0dy5vuelbYe5dnmzbnS1+9ZOITuudwoOQfxz08+/Ie/8/A7t1rddDwDxMEL" +
       "zsf/6n++svv+b37pIonGlY7/AiY2vuGDnUpEtfb/mNJkJq+GaSrPOKQJV8RG" +
       "z2wVMFvE16peRTsaNQ9ctxfJ/KBRVFOZLnY7HbauIjrTRJQRMvDqU5yeUsSw" +
       "4gwpoT2kbZMpUH572JYwiV1sRIolqIFrC+Iw9otTkRSGoTzH+gt/uPQ7U62H" +
       "RPUE6RTU+ro00ubIJJkWlKauw81qVKo3ClMOmbeJxB8r1nCFaQQFMtf2NJiz" +
       "42LRLYoNurY0kNoqYgbtmb1MahWe59qdVGH9fp8J4T4ji+MmFdBGwXIUKprX" +
       "Uqbdbhrdll9JbdHCa0V1mBKCUCUwhdGdUt8ZCu1gmVKOTbZwZU0MrbUnpbhF" +
       "z+3qpuUHsomjA4pV52VurtUNyxTnhNAtI+tuv75mIpXyixsl8kRamXfrDczg" +
       "goUBzMFZA3spkmHASMqgm9CDfgv3Bqt2NTBWXtuJUZJpWQpTEmBtGa98f4IN" +
       "qaYjKx2V7xTDoiAFHi5gCzZM6pMJNYwLzNLH6f7CRvvDVBAbhkgaotkX2gtZ" +
       "jgfGbCIJeMVJUiHBQsmlnTERmG1ioFe7Er0xA8xjcVadTCzLCZKySiqp5kw7" +
       "coQxTEqySHvcKCyVpWuuZF83BcmCqdWwqLa6okGRfaklDrooyxQ3pDUShlI/" +
       "XJUpHi8i+Nw2ndATNSaaOAOCW8HtcRRinIP7CBMzJKr1B9O4K7QIsWSP/FXd" +
       "4d2QRqcmx1q1NTOVIgbtNMdcuypSfhANV4Uu0h3ahrt2SFry/GrPVsqz1pAy" +
       "mOFclE10PTYWDkYUfSzEBLEfpRUeq3SCdQe3GKLTbtkK7XCi5sh0PCZ7bIq7" +
       "Y72m4NOer7QW/gpbSYavLFGxMXEMZzKpSZGb8rZKsmZd6cIzepb0MU9h8XnX" +
       "LhAqNqyRHUV0uzhVb/FYb0prSsfWWTwsIjXcYOx2v7zpL/nBOBzPpqRVaI61" +
       "VuRWCLfH0B0U60ce5Uc6qVWlQoS1h2t26IwEYTqtMNGyypjRWtiEIj0Xx8Jk" +
       "PinLWIsM18WmoM1m8KpTJZsFia11LEMiRGvUtss+0VVcGo9xnRowQg8dCbwj" +
       "kFXSGHUKTaw7a+m4K1nNVp0c2wtzppj9ioMQ6LLB4j3JQI2JwE3XjDpfp4gj" +
       "9XB41QSj42LSbjszTLXGKx6ujX1ivvJFgcFbwYSQ+3NO6S82o1UTTal5K/Yd" +
       "o82kBYY2QrpfUnu06TfEFskXjb5axPqkXFS11oIbrx3CWAYVnjVsIJ+DJYN0" +
       "mi10w8JDuJrMWYarziLGMwrSuG4USTxZ26O5TONWMergpbgWVkvMcu1WZDNS" +
       "q6Y/1PrcyuDIRqs16hiY2RqyFaMV8QaPtsSNvS5M7Z45XHXHsGM21LGB4S01" +
       "dFcaEjpOExE2rZmlAa+k1hgvThy1UAu7timMjFWDqSaLRRC4y3AEc/bKRBer" +
       "VZcdj13HKVZizCcYEuMRzR3ivUDWesS4ihtTRuv61hy18UVp3V1V147Unntk" +
       "kngKTdhtK9GicXG66ZZ6k7g/Gw38tKGCEFKAU6reqAsbVBAETCf5qG8V1hOU" +
       "rVt2v7jZSHGzwQdetQIvpcLKrwz9mrSo9ypuv8x2kubKiHmZsBA0bIxnrgSj" +
       "Fb2J0VQlnWJFHG1Nl4Ou2ldsDE3snuNQK46e+KK4Tqn+0laDsO+03LpZj0NG" +
       "jhSs13SYRBDmnI4yq3K4gZGkPoan3KQrlxdmucrHZt+OVH8csFKkY8MFEs+1" +
       "qNj3saTmu2Y9rdXVUaujFXVDxsogrk1lbU5SRjxstxm4lMZ1hK+b5ZofzjQX" +
       "p5OBLxkiy7txsm50+EqBw6osEo91EteEwApqm66NKEEvIrhJlZHLUxMrd1sG" +
       "tcEcJQbv0abb7aVtshvxyGZT8Eu1EtyoEigbaSuxSdh60Z7W250p3Jks+5Uy" +
       "nBTmqu01xl7ECGGlrA/IKdlAglp12OTB7PZsWBXrdL2OcF6Fi4wuPnbKKmWv" +
       "K5Rf6VSMpGLIbIqV4WVznDbnAynUaJ1P6rpQQYwhYVRniTQvqUveYpRaXEA2" +
       "zojXCmFnPB65YtQyrHqn6rJ009oUh8OFkupefzwjkDkG4uoQH3Smy2BMdJSa" +
       "wMTFTkRThkS17dBIF/iGGTDOcLPwA2a2hEPFj5ElgbZhbL0YEe1NvBptMH/A" +
       "rDSa8ih24ZbEBpg0Ix32AxZTVWwiksOSSshjfdSrNRNNQp3ZXHFnDF8X0rjn" +
       "hQiJSFSx6thzb9RbTqVYKZJynRklTW7SwCyvQDXGjOeVWJQeUepotmzVNB3z" +
       "17ptNAoJSxUVrQDWOabPNAKp18O6inY3tQaP8zqtcLQeanjqe/M54dEC46+F" +
       "QQMuNT2hlixQKoWbMSoXFLHaNZbD0iagyDIHAkBPrCF4Z7ZohGEbrtU0NsYs" +
       "rbSxeDXkR+1aAKcFuOkxdm0l2Uu7Smljqim5ndFGG5gpO8ZpX+BohNngG3nY" +
       "kJB1YdFrNcWNKRWZQXUZtEhER2QKnyRVNuQ8LurQM7oHY66ljm2uPymkQbic" +
       "BwIviJJqMDRWsUZzelIxdbzAMe1SZ14lNNxej00KhetmlVzW0SJZNRN35A8q" +
       "4yli45hR7IxUdFop9cy63qxbaGlK82gfmzd69VW3p9aUBcn2yTIhhZtSd5LM" +
       "xky9tqmMdXhaQyvjArLgGmbV7HVgpFytEJhQKcbjuF9f1Fkas3R+OGMrMbmk" +
       "uxVp0+Q3DszXRpvCCq5hWlqvcX6Xpnw8ItYTp9RwZ7zSt3XaXNSmXm1TKOtk" +
       "zTDr41mn7LOozOglbs4UgvKqTTWJUaelBBoV24kih1xPnBBLTxjRdXfGSgnb" +
       "rCCNiSB5nW4wQppltRFXaiyrdgZTL0gKzbXGm1rYiWa6W9Z7WoNxQ78yUGyv" +
       "3qIwqlDV+lKPHbTEWG0Vp6ZicUMPbFG1RUlt0O2g6rMbYW2MlLQy7ESNjea3" +
       "SoVCu8gkCy0KbNxpl5YMbY/LdK/cpWCWWIO1zM2LdX2hcmuxKvPcGJZEPdIL" +
       "q4npcy5K16OErHMr1Rg0KhgFIlfYJvVRzC2QcI7N/ahkNzt8te3UHXvUQZjI" +
       "H5ZrPTckhZleKi5Jjkbngw0aVYRG0+ZdtNfvTBodlFxOymhQac+LajtRubFY" +
       "l3kM1TYDtmzbsof1DWSempw4EnFiVpIpJtg0k6jtViuYVlYKBhFxm4oZwKqt" +
       "GuqSqBmdziYdpTI8Xo7hCR+3luoUwDaEdtda0XIcRVYs23K1x/kKYlXcejMl" +
       "JLgsMj0xtL0BPo8VCZ+TrAGXtZpKgHf/TVfWCs5gCAcLEy22zKEjpEjJG7Xb" +
       "y4JT6NMwKdQJgUAnHGxVZay0ArkSgbrT6bIo9RV3XtXsdjisratrAp55prNq" +
       "LnnP41pIyDi9oVJsLwIinlSYsgM3GIXtDaWpmxQdW4vXg7ATFyp6OuU8ZZWM" +
       "Rum6gCSNcs9TsdIMrQxkeW4NOr4aV1toLLMCNUjksiQsylFjUQijjbmoLip8" +
       "xeKKCEXB5GI1G8b9Ir2OojViuHhg9TrV+ZRuqbagjkirynubKraZFKh2rLRL" +
       "Q6/Sq677y65st5fVUtErtYfTmAPpN0+IMyrYtCrzOi+7SoKQhbLSWaRgjlfl" +
       "xZCrrKoB7YLNSeJmumHG88aaICohMpFIeANTXFTxbKaA932mWmwmpGYitXrd" +
       "s+Vo3Ve7g2F5LaO2hZNVLXWniw2ta1HJ2RBLpYwQpZUvl1mpXauG3EJLEKpp" +
       "tmE8DBVZ19dcsztim02+FtiCBrMS0mDifomrtnjWRZpYpMM9dTLD0lLA9ocE" +
       "XKn2tRBvs4MFXOQCfyZP1/50Og4Q2HDSOkXjNblaG/NoSePq8KYEkmSPXJZ9" +
       "32hIfZ3AigvOH7F9ZNAIptYAZAYKtRjqTc6o+CurYjjSWt4YZHG9walW2pDx" +
       "aB0O1oUqT4NgEEaF9bSKMF1ZRpVuMnTaqVMstmKJ7CAyr/JhTDUDxdfb4bIz" +
       "nFAilVrrUh9dYuNZTdLk2gxNIwlxDUuXe/a0gsJRqINcFOvK4FVKjHTwNvq6" +
       "7DX1jc/vpODG/FDk4CLLdupZB/k83pC3Xfdkxf0HB8H53+nLHAQfOSyDsrf+" +
       "Oy51P5W/8X/4HY8+rnEfKe3sHTLKMXRt7Ac/5ehL3Tki6hog6dWXPt3o5ddz" +
       "h4dfX3jHv9w2eL355udxvH/XCT1Pivzd3hNfIl+p/toOdMXBUdizLg6PMz10" +
       "/ADsTKjHSegNjh2D3XFg2Zszi70SPA/uWfbBix+xX9QLTuVesJ37y5zhhpfp" +
       "y0+l3Ri62Yooz9RDK9Y1PvTzq9icQTjiMFIMXT31fUdXvENn8p7ruOXokHmD" +
       "fYD+pqzxHvAge+iRFx/92y/T9wtZ8dYYOmvo8T5qdm/uyEOID78AiDfvL5fX" +
       "7EF8zYsP8Vcv0/eerHgkhl5qRS3PcpU4u1/Yx5r1LQ9x/vILxXk/eFp7OFsv" +
       "Ps4PXKbvN7Pi0Ri6yco+PchPGC+B8rEXgPJs1ngneDp7KDsvPsqPXKbvo1nx" +
       "W8cd9uD67sRSvcLa+yYkR/3bLwB1vgXcDR5uDzX34qP+1GX6fj8rntyiBi9X" +
       "SuJsryz2j/pf9dzXzYf0uTU++UKtcTt4pD1rSC+ONXZygp19UK/IQK0QNccS" +
       "Keouo6eWqjhDz4r3ae6/HHBUFPG8lo/2xydGO7V3i74n6db90TTf3cW4Hp6q" +
       "epBtnjnzF7PiszH0EjXUlVjPjZk1febQop97oRa9Fzz+nkX9F8eiV+zd3l1k" +
       "cVwVmX6Yb355cvT5nP9rF7dR9vNLOcHXs+LPQZq1tcP2Xuli1viL52ONNIau" +
       "P/YpRHaXe+uzvsPafjukfuLxs9e8/PHhX+dfAxx833MtA10zSxzn6NXbkfrp" +
       "INRnVo7h2u1FXJD/++Zz+NDBtxognIAyV/3pLes/xNA9z8ka792OHWX8pz3f" +
       "vgRjDJ3eVo7yfBtsYBfjAWqB8ijld2Po3ElKoEX+/yjd92PozCEdGHRbOUry" +
       "r0A6IMmq/xbsL5Tac5urNY3iUFG3MWpvStNTx1PkA0+56bk85UhWfd+xXDj/" +
       "nm8/b022X/RdUJ98vMu+5ZnaR7YfXaiOstlkUq5hoKu3338c5L73XFLavqzT" +
       "nQd+dMMnr71/P0+/Yavw4WI8ottdF/+qAXeDOP8OYfOZl3/qtR99/Bv5Xej/" +
       "Acr6IXFoKQAA");
}
