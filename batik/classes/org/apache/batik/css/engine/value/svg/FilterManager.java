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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "V/ZW8B9SVt/1Kx4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL06C8wsV1lz/9v76KXtvb2FUkvfvQXL1n929jW7XMDOzL53" +
       "Hju7O7O7I3KZ587szmvnsTM7UAV8UCUC0RYhQqMJBCWFEgNKYiBVg0AgKoao" +
       "mEiJGgWBSDWisSqemf3f99E0bdxkzp455/u+833f+b7vfHPOefL70Anfg3Ku" +
       "Y65nphNsq3GwPTfL28HaVf3tLlnui56vKoQp+v4ItF2S7/vU2R8+9z793BZ0" +
       "UoBuEW3bCcTAcGx/oPqOuVIVEjq739owVcsPoHPkXFyJcBgYJkwafnCRhF52" +
       "ADWALpC7LMCABRiwAGcswNg+FEC6UbVDi0gxRDvwl9DPQMdI6KQrp+wF0L2H" +
       "ibiiJ1o7ZPqZBIDC6fSdB0JlyLEH3bMn+0bmywR+PAc/9utvPve7x6GzAnTW" +
       "sIcpOzJgIgCDCNANlmpJqudjiqIqAnSzrarKUPUM0TSSjG8BOu8bM1sMQk/d" +
       "U1LaGLqql425r7kb5FQ2L5QDx9sTTzNUU9l9O6GZ4gzIeuu+rBsJm2k7EPCM" +
       "ARjzNFFWd1GuWxi2EkB3H8XYk/FCDwAA1FOWGujO3lDX2SJogM5v5s4U7Rk8" +
       "DDzDngHQE04IRgmg269KNNW1K8oLcaZeCqDbjsL1N10A6vpMESlKAL3iKFhG" +
       "CczS7Udm6cD8fJ9+/XvearftrYxnRZXNlP/TAOmuI0gDVVM91ZbVDeINryXf" +
       "L976uUe3IAgAv+II8Abm99/27MMP3fX0lzYwr7oCDCPNVTm4JH9EuulrdxAP" +
       "1o6nbJx2Hd9IJ/+Q5Jn593d6LsYu8Lxb9yimndu7nU8P/mT69o+r392CznSg" +
       "k7Jjhhawo5tlx3INU/Vaqq16YqAqHeh61VaIrL8DnQJ10rDVTSujab4adKDr" +
       "zKzppJO9AxVpgESqolOgbtias1t3xUDP6rELQdAp8EA3gOc10OaX/QeQBuuO" +
       "pcKiLNqG7cB9z0nl92HVDiSgWx2WgNUvYN8JPWCCsOPNYBHYga7udMh+CjsD" +
       "PMEr0QxV2F/N4KZhAnOiRBuYhLed2pv7/zZSnMp8Ljp2DEzHHUeDgQn8qO2Y" +
       "iupdkh8L8cazn7z0la0959jRVgAVweDbm8G3s8G3weDbm8G3s8G3weDbhwaH" +
       "jh3Lxnx5ysRm+sHkLUAYAAHyhgeHP919y6P3HQd250bXAc2noPDV4zSxHzg6" +
       "WXiUgfVCT38gegf/s/ktaOtwwE0ZB01nUvR+Gib3wuGFo452Jbpn3/XtHz71" +
       "/kecfZc7FMF3IsHlmKkn33dUxZ4jqwqIjfvkX3uP+JlLn3vkwhZ0HQgPICQG" +
       "ItAjiDZ3HR3jkEdf3I2OqSwngMCa41mimXbthrQzge450X5LNvc3ZfWbgY6r" +
       "0E5xyObT3lvctHz5xlbSSTsiRRZ93zB0P/zXf/qdYqbu3UB99sDSN1SDiweC" +
       "Q0rsbBYGbt63gZGnqgDubz/Q/7XHv/+un8oMAEDcf6UBL6QlAYICmEKg5l/4" +
       "0vIbz3zzI1/f2jeaAKyOoWQacrwR8kfgdww8/5s+qXBpw8axzxM70eWevfDi" +
       "piO/ep83EGhM4IKpBV3gbMtRDM0QJVNNLfa/zz6AfOZ77zm3sQkTtOya1EPP" +
       "T2C//cdw6O1fefN/3JWROSanC92+/vbBNtHzln3KmOeJ65SP+B1/cecHvyh+" +
       "GMRhEPt8I1GzcAZl+oCyCcxnushlJXykr5AWd/sHHeGwrx1ISC7J7/v6D27k" +
       "f/D5ZzNuD2c0B+edEt2LG1NLi3tiQP6VR72+Lfo6gCs9Tb/pnPn0c4CiACjK" +
       "ILL5jAfiT3zISnagT5z6mz/841vf8rXj0FYTOmM6otIUM4eDrgeWrvo6CF2x" +
       "+5MPb6w5Og2Kc5mo0GXCbwzktuztOGDwwavHmmaakOy7623/xZjSO//uPy9T" +
       "QhZlrrAOH8EX4Cc/dDvxxu9m+PvunmLfFV8ek0Hyto9b+Lj171v3nfzCFnRK" +
       "gM7JO5khn0Zc4EQCyIb83XQRZI+H+g9nNptl/OJeOLvjaKg5MOzRQLO/FoB6" +
       "Cp3Wz+xP+IPxMeCIJwrb6HY+fX84Q7w3Ky+kxWs2Wk+rPw481s8yTIChGbZo" +
       "ZnQeDIDFmPKFXR/lQcYJVHxhbqIZmVeAHDuzjlSY7U2atolVaVnccJHVK1e1" +
       "hou7vILZv2mfGOmAjO/d//C+r773/mfAFHWhE9mCBmbmwIh0mCbBv/jk43e+" +
       "7LFvvTsLQCD68D//3O0Pp1R715I4Lepp0dgV9fZU1GG2rpOiH1BZnFCVTNpr" +
       "WmbfMywQWlc7GR78yPlnFh/69ic22dtRMzwCrD762C//aPs9j20dyJnvvyxt" +
       "PYizyZszpm/c0bAH3XutUTKM5j899cgf/PYj79pwdf5wBtgAHzif+Mv/+er2" +
       "B7715SskGteZzouY2OCmD7VLfgfb/ZGIoI0jLo45zUZzcBWXW5Gj4bFOCExb" +
       "1fX6sCsO3DlKz/Nws0Hxlk8IVnmFWmhcDCtrpqBqo/Fs5GJLmzMMg20ZHKAx" +
       "CIgetlwKrsmKg4HlEou80Bu6oUUOB8OlK+ZZtskPV7mZpLmWsNIKEVpJJt2x" +
       "GrRplMrBtJqrFqVaRaKLmsUYTr6uDDAeXy4aiRPPyvllWyZaQ7GjEHOJ9hSs" +
       "2JkXlDmcy1URT8OiJkd3Eqsr1YVeoTVSKLNhCF5d7Fq+pQ+9xryNEp3Fej5r" +
       "1S2KnUbIaIy0mhxZ9mtDvjDoCnZBNNsE0RGjBjdFrGa3Pl+yTkVqWE5LF1p1" +
       "titzCIFqqB7MieWiPqhFRlMrE+RK7uSj9ZKdrytDh/EiaZ5rsobv9nrEWgoI" +
       "JHDIID8SrE4vdujFnKVRUxqPY9yvL3MavmiPcqLXl3Skx7epTsUjlqI7lIRC" +
       "SXeXIrUYz6b8yKrZrNu17BVLI3iu1R2jBmEu60FAsGssjze6gRjnl3myMlz2" +
       "zIVelWhHE6iB5DWavZ6TH4Xd+awgB72pUKp79Tox4Xw3n8xQzqOCaa9XUQW1" +
       "Pwzz3ZatIBJM4TW+LlLL8QBZVBbGDMc4PYowZ8iJnakktJ01W5m3XG7MxPjU" +
       "16cLEHJNsYSUJaMnsstxsSQ2FVHIT21CqJtiNLcIaSH0HMEaUUax1fbtEh/r" +
       "rIwj/oQhpz0CDab9WJ92HdoYzNb1IrLwcZFZt5a8EwrV+bTQT/gSho074Ugn" +
       "xPy8NyOaHNVe6lzoWBjS1p0GgvTnbHPpzFhKbBJFhjHs+tjXhr1OZdRQxQFI" +
       "N3GKHXDuIOrEi+5gJeSoJBp6AW0Uh0sUCZVKsaTiasD7tFNPWIZzFrpqavVF" +
       "RPeX06DbmFLYKsCopugTA7hOIBWBMLBG3Ody00U7yVtUsV0oB2HfaDnNBZgV" +
       "BBbq6qDS0fPUnFzZIqeQLLygEr6nUAWuoHZRklFRicJEkVt5jVZjLLSExSzf" +
       "RKtMbzwpJrXqIMeuIp4ds9UlsBvTZFl46bbyLlHy4rbRWFIjzGwMUI4wB06M" +
       "VFeYzEfFYMo7toNO4eao0UW5TpsIS04e1v2Z4Te4eq+zVrsab7VEuFKeWbl2" +
       "IA6iGR+VqGWJXIwMFoZdYzYeWnq34XeGvMXzRJSftry+Vm+0GwZLFAwea6za" +
       "pbzQclwMiSIXt+MGNoWHOO6x9Y4gDeI84SB6l+OJsjmrIgTnlRqV2hgbT6gO" +
       "SRXhEWxV2LyPmmGfqPZNi3H78czxO7kKPeR7c7ztDlvuvFwtJJ1CtTcoMFKU" +
       "74EFiZv1CaOBo3bUwUA1bOLkPOpEDqWWhrPVvBrKSZll11GOpCNXx5huNJBX" +
       "s7lfQF3XW0cqnK+yXcx2GyCCdQd6THkohsEdt+B5QuyvSK8QsNiS6NEiSTc4" +
       "3tQr4kgzGqSx4MbBis+zMy5ZdKclzptKOCUUZkOD61XX7rTkNc1eUG8afrvS" +
       "K3uB5dOgGzV0lDIXg1VxEKv9+SiKa9VyCSNsPcFxWiCYFu2zuWjdrXRLVDFX" +
       "qNdHqybX9mykgAazXAI8y14OgB5c16bWra5Xm+SYhrBQRD8icsyK7K0smVYJ" +
       "syVPAa9EF6M13VI79MDCiwNrGC2mbZqhuk1puuggcYvLTwseYKNWQPT5BIls" +
       "RiDgBVcm7dmw1K/IaA3N5Wik3VigEj8sV1f5mTMuhBzFWcsciMSyFK97+VaH" +
       "w4tlbY4ppZraRwklXNOs14270zrtMWu8EakONgtqlWkVRttIVFNH9iysE81J" +
       "t9CLug07GRcEODGr1bBepoG9qq2G0vETTjGNWFpwVoExqarltulIR4kZ2yjr" +
       "CV1ABhGbLKxSSScKfbQs1MbLYFjLyR4ukqRM9CWxGFCl3Eyh4Tgv5XNdH4Vr" +
       "bcytWqMx7SLVdr8zINYruSCEdBRVI23Q6cPt0A9ztbmbq3sYMSh0WZtgc6HB" +
       "MHgO64VlZC5HtQDVxjSIpiC+5orzolVcMDow044cFiszObTbejfQxipaXntF" +
       "f4UEYaNZMnms1S52KqsYb/uFcIHbKFgkKmSdbVeMii9Y2Fqt1Ap9xQkmZNx0" +
       "ZgruNYZ4i0mKJYK1NLG0WPDKuJ+gPFKTfCZUNHzksNa4py9pxWpVSzy2VEd+" +
       "1BjQYR4Ox219gM67Cs7JScLSnaGlSDg/rqNJzp5aiuxOhH7HJoq5fEkZdpe1" +
       "KFBG7XZjpTaWRVuKXHdckiS/ppbzuJHkerKDm7bCYOsiqdhzHa/kRrlSTjb6" +
       "U3iFTGVqvKzhpS7DMGDtpQN4NeCqcNgyW1qX6SmTfBhz64E+nCR4x8q7lKuu" +
       "rHLimGM+N1Xg0LATrUXL+cXQ69V0cz7CNKPa7tSERR12czyPanBNa47jWg/t" +
       "uvVVEw5nNQouawqaIHFFIPk8Q2F9f0hyo2RVVV1bLFIEwXX6mMgjpuD11KFX" +
       "lnhrKjudUoC23NLYyLfF/mTV1FvTcAS+C+f9+touGCSmeHMLi8xW3xcrSbm3" +
       "4BGuOVwSwxncaZYJK+zw+kqbRbRQpnAu7sg2OWTn1WlNcHOYXw8rQ7fsNGBi" +
       "pFan0bTF8grMrEZcvh2ixVyH5P1OtYsxo3WywhZI4i5dB2GlKT+2Sc40yzV2" +
       "FSzBulergQyB1WGYU8rtUU9ktP4qKVGN+dQJO6qlmUGXrCdDetl2a4W5ZC3k" +
       "TiVclROpBpOuxspEMyzVmjjfpht5fUwV/CGCWqu6pBkVklUUZsSPqijfXWm4" +
       "EK7w8njBt82+sRo0Vmx5KvWmBmkaSsM340E+8Mx5w12bwVxHSXQs0c1VCy6R" +
       "Fcqp1AwHuLM6Z7Sx7zVbKi0ItheE6KKizUfj9jQHdyl5ik4n9CRmLcSW8n2W" +
       "GdWMtbEsLy2sKZZxTppVCIJfYfkuohjlUr5OJpG0mJudPIJHy345nktJeVmT" +
       "68tJMhFA2kP25nO5wLcSn2PVYVwoTbq91UyUNF90q2iXNqdyeV7jO5UYRXGL" +
       "mFWmlBeuS5KPEmu8X5wJ2DLQp1iSKKY5UeRIXrQKPuOUAa/a1BdL5YqCtKwi" +
       "bhSmRh8thM1KHI/MdW3K28TK8oVqzK+xigLWTq/VnPdydTco1h07CRsFXk+i" +
       "NmvFNV1A3GjYaJUMSoiHFRzzciGCKYzmIxHF9FktrDF5QjIWVbYsIWyRapN6" +
       "6NXLEcavB7MCmmsURrkcSNEsC5n19IUpmh6xHgljdyRRy2Z+qsxKjAJ3Cl6O" +
       "7PYtF4k8YTEuKD1jPO+VllKuSK3zA1vIu4zGeF5/EQ/U8ZAViWWZNBJvRTE5" +
       "AlbIFSGV6IaPk+PyrAyCPKu0+6a80FCpNo4M03SbJo5ShVhwSLg/CSy2afeL" +
       "MENM0Lq18DmE1dmBJCqE4mqwkZuNeJqrSGZvWpxojmUXcwwZjkcu6izdRWlq" +
       "BijcNLpFCp6AQIggeo/j122QKYMwNysOG4kVmOPO2LTtCaJYsjKiJgO4MSgY" +
       "ZXxS5Ty8NkTqM6+3TsgxMR2OO5E2HvgOsaabA5VsJhptr/uLpDrFxTzpuP2S" +
       "kCzc6jBg6prkuf0e4SaVBuGo7dZIw5YJ8HB0JbalEG7lCmpzqedIYkYsOaa0" +
       "RlzGqlYErlyr1CuFUdLhJ8aq1mQluF8FC7ChNlbVzpyb2yMrCQvFVbIKtSYt" +
       "WIsSZXbphV9uU2RT4NcWaiUU4/o1HmkW1xWkXM4Hk4Iyxstlj/FAAjCt6Tjc" +
       "cD1fhdV1K2EmeK6mFcm6ztfoppQnFRkpmJgqBVYFrdSq06qi1MeI22flFtwf" +
       "rWuFDibafM0JJK5KwU1WzCWjPoyT9fWwt6hMhAqnLtYVpQC+VCPHpWiMH6mz" +
       "aKlXibY75VnLKvsWQiCN1pxpcSLvK0sBHwh6M3aW9sK127RuWp1pfT71m4Kl" +
       "mmatInM0V1glFUljXNktzGcxbTkuLS+tGb90iowVo3G16k6CHlLMUyMn53UJ" +
       "zmiRJI/1qgqhacvQLpbHJD4tlxqWOecK5XCS8LAwroL55QMY6cUgqcfe8Ib0" +
       "M/VNL2yn4OZsU2TvIGtuomlH6wV8IW+67k2LB/Y2grPfyWtsBB/YLIPSr/47" +
       "r3Y+lX3xf+Sdjz2hMB9FtnY2GccBdH3guD9hqivVPEDqNKD02qvvblDZ8dz+" +
       "5tcX3/nPt4/eqL/lBWzv332Ez6Mkf4d68sutV8u/ugUd39sKu+zg8DDSxcMb" +
       "YGc8NQg9e3RoG+zOPc3ekmrs1eB5aEezD115i/2KVnAss4LN3F9jD9e7Rl+2" +
       "K20F0C2G37F11TMCVQHfhNlRbIYwOGAwfACdkhzHVEV735js59tuOThk1jDf" +
       "k/582ngveIo70hdfeunfcY2+n0uLtwXQ2Zka7EpN78xda1/ER16EiLfsusvr" +
       "dkR83Usv4q9co++9afFoAL3c8DHbsMQgPV/YlTXtW+3L+UsvVs4HwIPtyIm9" +
       "9HJ+8Bp9v5EWjwXQeSO9epDtMF5FysdfhJRn08a7wNPekbL90kv50Wv0fSwt" +
       "fvOwwe4d3x1x1ePGzp2QTOrfehFSZ0vAPeBhdqRmXnqpP32Nvt9Li6c2UtdV" +
       "TQzNzZHF7lb/a57/uHkfPtPGp16sNu4AD7+jDf6l0cZWBrC1K9SrUqGiopzJ" +
       "4ovyNqnGhiyanG0EuzAPXEtwYjhsZLVstD86MtqxnVP0HUq37Y6mONZ2naEa" +
       "say66eKZIX8pLT4XQC+TPVUM1EyZadNn9zX6+Rer0fvA4+xo1HlpNHp85/Tu" +
       "Cs5xwtcdL1v8suToCxn+16+so/T1yxnAN9Liz0CatdHD5lzpStr48xeijTiA" +
       "bjx0FSI9y73tsntYm7tD8iefOHv6lU9wf5XdBti733M9CZ3WQtM8ePR2oH7S" +
       "9VTNyGS4fnMQ52Z/33oeG9q7qwHCCSgz1p/ZoP59AN37vKjBzunYQcR/3LHt" +
       "qyAG0MlN5SDOd8ACdiUcwBYoD0J+L4DOHYUEXGT/B+H+JYDO7MOBQTeVgyD/" +
       "CqgDkLT6b+6uo1SeX12Y5AeeKG9i1M6UxscOp8h7lnL++SzlQFZ9/6FcOLvP" +
       "t5u3hpsbfZfkp57o0m99tvLRzaUL2RSTJKVymoRObe5/7OW+916V2i6tk+0H" +
       "n7vpU9c/sJun37RheN8ZD/B295VvNTQsN8juISSffeWnX/+xJ76ZnYX+H0Q5" +
       "qRloKQAA");
}
